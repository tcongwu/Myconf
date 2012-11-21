package org.myconf.action;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.myconf.beans.MenuBean;
import org.myconf.beans.UserBean;
import org.myconf.beans.LangBean;
import org.myconf.dao.LangDAO;
import org.myconf.dao.MenuDAO;
import org.myconf.formbean.MenuForm;
import org.myconf.util.StringUtils;

/**
 * 会议网站菜单相关的Action类
 * 
 */
public class MenuAction extends ActionBase {

	private final static Log log = LogFactory.getLog(MenuAction.class);

	/**
	 * 添加会议网站菜单
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAddMenu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MenuForm menu = (MenuForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsContent()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try{
				MenuBean mbean=null;
				Timestamp ts=new Timestamp(System.currentTimeMillis());
				
				int sid=1;
				String type1="";
				String style1="";
				String type2="";
				String style2="";
				String link="";
				String linkcontent="";
				String menuname="";
				String published="";
				String opentype="";
				link=StringUtils.exportString(request.getParameter("link"));
				linkcontent=StringUtils.exportString(request.getParameter("linkcontent"));
				type1=StringUtils.exportString(request.getParameter("type1"));
				style1=StringUtils.exportString(request.getParameter("style1"));
				style2=StringUtils.exportString(request.getParameter("style2"));
				menuname=menu.getMenuName();
				opentype=StringUtils.exportString(request.getParameter("openType"));
				published=StringUtils.exportString(request.getParameter("published"));
				String languange=StringUtils.exportString(request.getParameter("languange"));
				if(languange.equals("zh_cn")){sid=LangBean.LANG_ZH_CN;}
				if(languange.equals("zh_tw")){sid=LangBean.LANG_ZH_TW;}
				if(languange.equals("english")){sid=LangBean.LANG_ENGLISH;}
					
				mbean=new MenuBean();
				mbean.setMenuName(menuname);
			
				if(type1.equals("url")){
				mbean.setLink(link);
				mbean.setType(type1);
				
				}
				if(type1.equals("page"))
				{
				mbean.setLink(linkcontent);	
				mbean.setPublished(Integer.parseInt(published));
				mbean.setType(type1);
				mbean.setStyle(style1+","+style2);
			
				}
				mbean.setOpenType(opentype);
				mbean.setCreator(loginUser.getId());
				mbean.setModifier(loginUser.getId());
				mbean.setLang(LangDAO.getLangByID(sid));
				mbean.setModifyTime(ts);
				mbean.setCreateTime(ts);
				
				int order=MenuDAO.getMenuMaxOrding();// 取当前数据库中ordering最大值
				int ordering=order+1;
				mbean.setOrdering(ordering);
				
				MenuDAO.createMenu(mbean);
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when add menu", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}

	/**
		 * 修改菜单
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
	
		protected ActionForward doEditMenu(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			MenuForm menu = (MenuForm) form;
			ActionMessages msgs = new ActionMessages();
		
			//判断用户是否登录
			UserBean loginUser = super.getLoginUser(request, response);
			if(loginUser == null)
				msgs.add("err", new ActionMessage("error.need_login"));
			else if(loginUser.getIsContent()!=UserBean.TRUE)
				msgs.add("err", new ActionMessage("error.can_not_access"));
			else{
				try{
					MenuBean mbean=null;
					Timestamp ts=new Timestamp(System.currentTimeMillis());
				
					int sid=1;
					String type1="";
					String style1="";
					String type2="";
					String style2="";
					String link="";
					String linkcontent="";
					String menuname="";
					String published="";
					String opentype="";
					String id=StringUtils.exportString(request.getParameter("id"));
					if(!id.equals("")) 
					mbean=MenuDAO.getMenu(Integer.parseInt(id));
					
					link=StringUtils.exportString(request.getParameter("link"));
					linkcontent=StringUtils.exportString(request.getParameter("linkcontent"));
					type1=StringUtils.exportString(request.getParameter("type1"));
					style1=StringUtils.exportString(request.getParameter("style1"));
					style2=StringUtils.exportString(request.getParameter("style2"));
					menuname=menu.getMenuName();
					opentype=StringUtils.exportString(request.getParameter("openType"));
					published=StringUtils.exportString(request.getParameter("published"));
					String languange=StringUtils.exportString(request.getParameter("languange"));
					if(languange.equals("zh_cn")){sid=LangBean.LANG_ZH_CN;}
					if(languange.equals("zh_tw")){sid=LangBean.LANG_ZH_TW;}
					if(languange.equals("english")){sid=LangBean.LANG_ENGLISH;}
					
					mbean.setId(Integer.parseInt(id));
					mbean.setMenuName(menuname);
			
					if(type1.equals("url")){
					mbean.setLink(link);
					mbean.setType(type1);
				
					}
					if(type1.equals("page"))
					{
					mbean.setLink(linkcontent);	
					mbean.setPublished(Integer.parseInt(published));
					mbean.setType(type1);
					mbean.setStyle(style1+","+style2);
			
					}
					mbean.setOpenType(opentype);
				
					mbean.setModifier(loginUser.getId());
				
					mbean.setModifyTime(ts);
				
				
					MenuDAO.updateMenu(mbean);
				
				}catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when edit menu", e);
				}
			}

			if (!msgs.isEmpty()) {
				saveMessages(request, msgs);
				return mapping.findForward("error");
			}
		
			return mapping.getInputForward();
		}

	/**
	 * 删除会议菜单
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
		MenuForm menu = (MenuForm) form;
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
				
				MenuDAO.deleteMenu(MenuDAO.getMenu(menu.getId()));
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when delete menu", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}
	
	/**
	 * 排序上升会议菜单
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doMenuUp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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
			
				String id=StringUtils.exportString(request.getParameter("id"));
				String listi=StringUtils.exportString(request.getParameter("listi"));
				String langId=StringUtils.exportString(request.getParameter("langId"));
				List mlist=MenuDAO.getMenuByVersion(LangDAO.getLang(Integer.parseInt(langId)));
				int upid=0;
				int listid=0;
				if(!id.equals("")&&!listi.equals(""))
				 {
					listid=Integer.parseInt(listi);
					upid=listid-1;
					MenuBean mup1=(MenuBean) mlist.get(listid);
					int order1=mup1.getOrdering();
					MenuBean mup2=(MenuBean) mlist.get(upid);
					int order2=mup2.getOrdering();
					int id2=mup2.getId();
					mup1.setOrdering(order2);
					mup2.setOrdering(order1);
					MenuDAO.updateMenu(mup1);
					MenuDAO.updateMenu(mup2);
				
					}
				
				
		}catch (Exception e) {
			msgs.add("err", new ActionMessage("error.db"));
			log.error("database error when up menu", e);
		}
	}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}
	
	/**
	 * 排序下降会议菜单
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doMenuDown(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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
				String id=StringUtils.exportString(request.getParameter("id"));
				String listi=StringUtils.exportString(request.getParameter("listi"));
				String langId=StringUtils.exportString(request.getParameter("langId"));
				List mlist=MenuDAO.getMenuByVersion(LangDAO.getLang(Integer.parseInt(langId)));
				
				int upid=0;
				int listid=0;
				if(!id.equals("")&&!listi.equals(""))
				 {
					listid=Integer.parseInt(listi);
					upid=listid+1;
					MenuBean mup1=(MenuBean) mlist.get(listid);
					MenuBean mup2=(MenuBean) mlist.get(upid);
					int order1=mup1.getOrdering();
					int order2=mup2.getOrdering();
					int id2=mup2.getId();
					mup1.setOrdering(order2);
					mup2.setOrdering(order1);
					MenuDAO.updateMenu(mup1);
					MenuDAO.updateMenu(mup2);
						
					}
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when down menu", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.getInputForward();
	}
	
	/**
		 * 改变菜单发布状态
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
			MenuForm menu = (MenuForm) form;
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
						publish=MenuBean.MENU_PUBLISHED;
					else
						publish=MenuBean.MENU_PUBLISHED_NOT;
						
						MenuBean mbean=MenuDAO.getMenu(menu.getId());	
						mbean.setPublished(publish);
						MenuDAO.updateMenu(mbean);
				
				}catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when change menu published status ", e);
				}
			}

			if (!msgs.isEmpty()) {
				saveMessages(request, msgs);
				return mapping.findForward("error");
			}
		
			return mapping.getInputForward();
		}

}
