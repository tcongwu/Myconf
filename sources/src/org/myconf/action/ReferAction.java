package org.myconf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.myconf.beans.ConfigBean;
import org.myconf.beans.ReferBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.ConfigDAO;
import org.myconf.dao.ReferDAO;
import org.myconf.dao.ReviewDAO;
import org.myconf.formbean.ReferForm;

/**
 * 评审指标相关的Action类
 * @author libin
 */
public class ReferAction extends ActionBase {

	private final static Log log = LogFactory.getLog(ReferAction.class);

	/**
	 * 添加或修改评审指标
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAddOrModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReferForm refer = (ReferForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(!refer.validateForm())
			msgs.add("err", new ActionMessage("error.staritem.not.null"));
		else{
			try{
				ReferBean rbean=null;
				if(refer.getId()>0){
					//从数据库中读取主题信息
					rbean=ReferDAO.getRefer(refer.getId());
					if(rbean==null)
						msgs.add("err", new ActionMessage("error.unknow"));
					else //检查序号是否重复
					if(rbean.getReferNo()!=refer.getReferNo() && ReferDAO.isExist(refer.getReferNo()))
						msgs.add("err", new ActionMessage("error.referno.duplicate"));
					else{
						if(!isBeginReview()){
							rbean.setReferNo(refer.getReferNo());
						}
						rbean.setTitle(refer.getTitle());
						rbean.setMinScore(refer.getMinScore());
						rbean.setMaxScore(refer.getMaxScore());
						rbean.setDescription(refer.getDescription());
						ReferDAO.update(rbean);
					}
				}else{
					//查看评审指标的序号是否处于1～16之间
					if(refer.getReferNo()>16 || refer.getReferNo()<1){
						msgs.add("err", new ActionMessage("error.referno"));
					}else //判断序号是否已经被使用
					if(ReferDAO.isExist(refer.getReferNo())){
						msgs.add("err", new ActionMessage("error.referno.duplicate"));
					}else //判断是否已经开始评审
					if(isBeginReview()){
						msgs.add("err", new ActionMessage("error.review.begin"));
					}else{
						//否则添加新的评审指标
						rbean=new ReferBean();
						rbean.setReferNo(refer.getReferNo());
						rbean.setTitle(refer.getTitle());
						rbean.setMinScore(refer.getMinScore());
						rbean.setMaxScore(refer.getMaxScore());
						rbean.setDescription(refer.getDescription());
					
						ReferDAO.save(rbean);
					}
				}
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when add or modify review refer", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}
	
	/**
	 * 判断评审是否开始
	 * @return
	 */
	public static boolean isBeginReview(){
		ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
		if(conf!=null && conf.getReviewBeginDate()>0 && System.currentTimeMillis()>conf.getReviewBeginDate()){
			return true;
		}
		if(ReviewDAO.getReviewCount()>0){
			return true;
		}
		return false;
	}

	/**
	 * 删除评审指标
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReferForm refer = (ReferForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try{
				//完成数据操作
				if(isBeginReview()){
					msgs.add("err", new ActionMessage("error.review.begin"));
				}else{
					ReferDAO.delete(refer.getId());
				}
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when delete review refer", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}

}
