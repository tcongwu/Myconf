
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
import org.myconf.beans.LangBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.LangDAO;
import org.myconf.formbean.LangForm;
import org.myconf.util.*;


	/**
	 * 会议网站操作相关的Action类
	 * 
	 * @author
	 */
	public class LangAction extends ActionBase {
		private final static Log log = LogFactory.getLog(LangAction.class);
	
	/**
	 * 添加会议网站基本信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	protected ActionForward doSiteSetting(final ActionMapping mapping,
				final ActionForm form, final HttpServletRequest request,
				final HttpServletResponse response) throws Exception 			
		{
			LangForm lform = (LangForm) form;
			LangBean lbean=null;
			ActionMessages msgs = new ActionMessages();
			// 判断用户是否登录
			UserBean loginUser = super.getLoginUser(request, response);
			if(loginUser == null)
					msgs.add("err", new ActionMessage("error.need_login"));
			else if(loginUser.getIsAdmin()!=UserBean.TRUE)
					msgs.add("err", new ActionMessage("error.can_not_access"));
			else{
					try{
							Timestamp ts=new Timestamp(System.currentTimeMillis());
						
							int id=1;
							String languange=StringUtils.exportString(request.getParameter("languange"));
							if(languange.equals("zh_cn")){id=LangBean.LANG_ZH_CN;}
							if(languange.equals("zh_tw")){id=LangBean.LANG_ZH_TW;}
							if(languange.equals("english")){id=LangBean.LANG_ENGLISH;}
							boolean isSave=false;
							//从数据库中读取设置信息
							lbean=LangDAO.getLangByID(id);
							if(lbean==null)
								{
									lbean=new LangBean();
									lbean.setId(id);
									isSave=true;
									}
				  		
								//利用表单数据修改数据对象
						
								String publishId=StringUtils.exportString(request.getParameter("publishId"));//获取是否发布
								String template=StringUtils.exportString(request.getParameter("template"));//获得所选模板
								String isdefault=request.getParameter("isdefault");
								if(StringUtils.exportString(isdefault).equals("")){isdefault=LangBean.LANG_PUBLISHED_NOT+"";}
								if(StringUtils.isNotEmpty(languange))
								lbean.setLanguange(languange);
								lbean.setIsDefault(Integer.parseInt(isdefault));
								if(StringUtils.isNotEmpty(lform.getConfname()))
								lbean.setConfName(lform.getConfname());
								if(StringUtils.isNotEmpty(lform.getShortname()))
								lbean.setShortName(lform.getShortname());
								if(StringUtils.isNotEmpty(lform.getCopyright()))
								lbean.setCopyright(lform.getCopyright());
								if(StringUtils.isNotEmpty(lform.getEmail()))
								lbean.setEmail(lform.getEmail());
								if(lform.getShow1()!=0||lform.getShow1()!=1)
								lbean.setShow1(lform.getShow1());
								if(lform.getShow2()!=0||lform.getShow2()!=1)
								lbean.setShow2(lform.getShow2());
								lbean.setCreateTime(ts);
								lbean.setUpdateTime(ts);
								if(StringUtils.isNotEmpty(publishId))
								lbean.setPublished(LangBean.LANG_PUBLISHED);//如果取值不为空，则发布
								if(StringUtils.isNotEmpty(template))
								lbean.setTemplate(template);
								//保存入数据库
								if(isSave){
										LangDAO.createLang(lbean);
									}
								else{
										LangDAO.updateLang(lbean);
									}
						
								}catch (Exception e) {
												msgs.add("err", new ActionMessage("error.db"));
												log.error("database error when save site_setting", e);
								}	
					
					}
			if (!msgs.isEmpty()) {
				saveMessages(request, msgs);
				return mapping.findForward("error");
			}
			
			request.setAttribute("lang", lbean);
			String fromPage = lform.getFromPage();
			if (StringUtils.isNotEmpty(fromPage))
					return new ActionForward(fromPage);
					
			return mapping.findForward("home.site");
		}
	
		protected ActionForward doPublished(final ActionMapping mapping,
					final ActionForm form, final HttpServletRequest request,
					final HttpServletResponse response) throws Exception 			
			{
				
				ActionMessages msgs = new ActionMessages();
				// 判断用户是否登录
				UserBean loginUser = super.getLoginUser(request, response);
				if(loginUser == null)
						msgs.add("err", new ActionMessage("error.need_login"));
				else if(loginUser.getIsAdmin()!=UserBean.TRUE)
						msgs.add("err", new ActionMessage("error.can_not_access"));
				else{
						try{
								
								String [] lang=request.getParameterValues("publish");
								String isdefault=request.getParameter("isdefault");
								List langlist=LangDAO.getLanglist();
								String [] nopublish=null;
								int count=0;
								if(lang.length<langlist.size()){
									nopublish=new String[langlist.size()-lang.length];
									for(int i=0;i<langlist.size();i++){
											LangBean lb=(LangBean)langlist.get(i);
										for(int j=0;j<lang.length;j++){
											if(!lang[j].equals((lb.getId()+"").trim()))
											{
												nopublish[count]=lb.getId()+"";
												count++;
											
											}
										}
									
									}
								}
								if(nopublish!=null&&nopublish.length>0){
									for(int m=0;m<nopublish.length;m++){
										LangBean lbn=LangDAO.getLang(Integer.parseInt(nopublish[m]));
										lbn.setPublished(LangBean.LANG_PUBLISHED_NOT);
										lbn.setIsDefault(LangBean.LANG_ISDEDAULT_NOT);
										LangDAO.updateLang(lbn);
									
									}
								}
								LangDAO.updatePublished(lang,isdefault);
						
							
						
									}catch (Exception e) {
													msgs.add("err", new ActionMessage("error.db"));
													log.error("database error when update site_setting", e);
									}	
					
						}
				if (!msgs.isEmpty()) {
					saveMessages(request, msgs);
					return mapping.findForward("error");
				}
			
			
					
				return mapping.findForward(null);
			}
	
	}
	

	
	