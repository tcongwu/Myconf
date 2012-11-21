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

import org.myconf.beans.ContentBean;
import org.myconf.beans.UserBean;
import org.myconf.beans.LangBean;
import org.myconf.dao.ContentDAO;
import org.myconf.dao.LangDAO;
import org.myconf.formbean.ContentForm;
import org.myconf.util.StringUtils;

/**
 * 会议内容相关的Action类
 * 
 */
public class ContentAction extends ActionBase {

	private final static Log log = LogFactory.getLog(ContentAction.class);

	/**
	 * 添加会议内容
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAddContent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ContentForm con = (ContentForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsContent()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(StringUtils.isEmpty(con.getTitle()))
			msgs.add("err", new ActionMessage("error.content.title.not.null"));
		else if(StringUtils.isEmpty(con.getPagetext()))
			msgs.add("err", new ActionMessage("error.content.pagetext.not.null"));	
		else{
			try{
				ContentBean cbean=null;
				Timestamp ts=new Timestamp(System.currentTimeMillis());
				
				int sid=1;
				int version=1;//添加内容版本，第一次添加默认为1
				String languange=StringUtils.exportString(request.getParameter("languange"));
				if(languange.equals("zh_cn")){sid=LangBean.LANG_ZH_CN;}
				if(languange.equals("zh_tw")){sid=LangBean.LANG_ZH_TW;}
				if(languange.equals("english")){sid=LangBean.LANG_ENGLISH;}
					
				cbean=new ContentBean();
				cbean.setTitle(con.getTitle());
				cbean.setPagetext(con.getPagetext());
				cbean.setPublished(con.getPublished());
			
				
				cbean.setCreator(loginUser.getId());
				cbean.setModifier(loginUser.getId());
				cbean.setVersion(version);
				
				cbean.setLang(LangDAO.getLangByID(sid));
				
				
				cbean.setModifyTime(ts);
				cbean.setCreateTime(ts);
				
				ContentDAO.save(cbean);
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when add content", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}

	/**
		 * 修改会议内容
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		protected ActionForward doEditContent(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			ContentForm con = (ContentForm) form;
			ActionMessages msgs = new ActionMessages();
		
			//判断用户是否登录
			UserBean loginUser = super.getLoginUser(request, response);
			if(loginUser == null)
				msgs.add("err", new ActionMessage("error.need_login"));
			else if(loginUser.getIsContent()!=UserBean.TRUE)
				msgs.add("err", new ActionMessage("error.can_not_access"));
			else if(StringUtils.isEmpty(con.getTitle()))
				msgs.add("err", new ActionMessage("error.content.title.not.null"));
			else if(StringUtils.isEmpty(con.getPagetext()))
				msgs.add("err", new ActionMessage("error.content.pagetext.not.null"));	
			else{
				try{
					ContentBean cbean=null;
					Timestamp ts=new Timestamp(System.currentTimeMillis());
				
					int sid=1;
					int versionId=1;//内容版本，第一次添加默认为1
					String id=StringUtils.exportString(request.getParameter("id"));
					String languange=StringUtils.exportString(request.getParameter("languange"));
					String version=StringUtils.exportString(request.getParameter("version"));
					if(languange.equals("zh_cn")){sid=LangBean.LANG_ZH_CN;}
					if(languange.equals("zh_tw")){sid=LangBean.LANG_ZH_TW;}
					if(languange.equals("english")){sid=LangBean.LANG_ENGLISH;}
					
					if(!version.equals("")){versionId=Integer.parseInt(version)+1;}
					
					if(!id.equals("")) 
					cbean=ContentDAO.getContent(Integer.parseInt(id));
					cbean.setId(Integer.parseInt(id));
					cbean.setTitle(con.getTitle());
					cbean.setPagetext(con.getPagetext());
					cbean.setPublished(con.getPublished());
			
					cbean.setModifier(loginUser.getId());
					cbean.setVersion(versionId);
				
					cbean.setLang(LangDAO.getLangByID(sid));
				
				
					cbean.setModifyTime(ts);
					
				
					ContentDAO.updateContent(cbean);
				
				}catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when edit content", e);
				}
			}

			if (!msgs.isEmpty()) {
				saveMessages(request, msgs);
				return mapping.findForward("error");
			}
		
			return mapping.getInputForward();
		}

	/**
	 * 删除会议内容
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
		ContentForm content = (ContentForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsContent()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try{
				//完成数据操作
			
				ContentDAO.deleteContent(ContentDAO.getContent(content.getId()));
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when delete content", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
	
		return mapping.getInputForward();
	}

	/**
			 * 改变内容发布状态
			 * 
			 * @param mapping
			 * @param form
			 * @param request
			 * @param response
			 * @return
			 * @throws Exception
			 */
			protected ActionForward doUpdateStatus(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				ActionMessages msgs = new ActionMessages();
				ContentForm content = (ContentForm) form;
				//判断用户是否登录
				UserBean loginUser = super.getLoginUser(request, response);
				if(loginUser == null)
					msgs.add("err", new ActionMessage("error.need_login"));
				else if(loginUser.getIsContent()!=UserBean.TRUE)
					msgs.add("err", new ActionMessage("error.can_not_access"));
				else{
					try{
						//完成数据操作
						int publish=0;
						String published=StringUtils.exportString(request.getParameter("published"));
						if(published.equals("do"))
							publish=ContentBean.CONTENT_PUBLISHED;
						else
							publish=ContentBean.CONTENT_PUBLISHED_NOT;
						
							ContentBean cbean=ContentDAO.getContent(content.getId());	
							cbean.setPublished(publish);
							ContentDAO.updateContent(cbean);
				
					}catch (Exception e) {
						msgs.add("err", new ActionMessage("error.db"));
						log.error("database error when change content published status ", e);
					}
				}

				if (!msgs.isEmpty()) {
					saveMessages(request, msgs);
					return mapping.findForward("error");
				}
		
				return mapping.getInputForward();
			}


}
