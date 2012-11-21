package org.myconf.action;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.myconf.beans.StatusBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.StatusDAO;
import org.myconf.formbean.StatusForm;
import org.myconf.util.StringUtils;

/**
 * 评审结果状态相关的Action类
 * @author libin
 */
public class StatusAction extends ActionBase {

	private final static Log log = LogFactory.getLog(StatusAction.class);

	/**
	 * 添加或修改评审结果状态
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
		StatusForm status = (StatusForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(StringUtils.isEmpty(status.getStatus()))
			msgs.add("err", new ActionMessage("error.status.not.null"));
		else{
			try{
				StatusBean sbean=null;
				Timestamp ts=new Timestamp(System.currentTimeMillis());
				if(status.getId()>0){
					//从数据库中读取主题信息
					sbean=StatusDAO.getStatus(status.getId());
					if(sbean==null)
						msgs.add("err", new ActionMessage("error.unknow"));
					else{
						sbean.setStatus(status.getStatus());
						sbean.setUpdateTime(ts);
						StatusDAO.update(sbean);
					}
				}else{
					sbean=new StatusBean();
					sbean.setStatus(status.getStatus());
					sbean.setUpdateTime(ts);
					sbean.setRegTime(ts);
					
					StatusDAO.save(sbean);
				}
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when add or modify subject", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}

	/**
	 * 删除评审结果状态
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
		StatusForm status = (StatusForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try{
				if(StatusDAO.canBeDelete(status.getId())){
					//完成数据操作
					StatusDAO.delete(status.getId());
				}else{
					msgs.add("err", new ActionMessage("error.status.already.used"));
				}
				
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when delete subject", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}

}
