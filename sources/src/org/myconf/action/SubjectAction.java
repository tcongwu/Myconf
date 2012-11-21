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

import org.myconf.beans.SubjectBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.SubjectDAO;
import org.myconf.formbean.SubjectForm;
import org.myconf.util.StringUtils;

/**
 * 会议主题相关的Action类
 * @author libin
 */
public class SubjectAction extends ActionBase {

	private final static Log log = LogFactory.getLog(SubjectAction.class);

	/**
	 * 添加或修改会议主题
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
		SubjectForm sub = (SubjectForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(StringUtils.isEmpty(sub.getSubject()))
			msgs.add("err", new ActionMessage("error.suject.not.null"));
		else{
			try{
				SubjectBean sbean=null;
				Timestamp ts=new Timestamp(System.currentTimeMillis());
				if(sub.getId()>0){
					//从数据库中读取主题信息
					sbean=SubjectDAO.getSubject(sub.getId());
					if(sbean==null)
						msgs.add("err", new ActionMessage("error.unknow"));
					else{
						sbean.setSubject(sub.getSubject());
						sbean.setUpdateTime(ts);
						SubjectDAO.update(sbean);
					}
				}else{
					sbean=new SubjectBean();
					sbean.setSubject(sub.getSubject());
					sbean.setUpdateTime(ts);
					sbean.setRegTime(ts);
					
					SubjectDAO.save(sbean);
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
	 * 删除会议主题
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
		SubjectForm sub = (SubjectForm) form;
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
				if(SubjectDAO.isDelete(sub.getId()))
					SubjectDAO.delete(sub.getId());
				else
					msgs.add("err", new ActionMessage("error.subject.used"));
				
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
