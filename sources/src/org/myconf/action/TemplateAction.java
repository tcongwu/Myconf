
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
import org.myconf.Globals;
import org.myconf.beans.LangBean;
import org.myconf.dao.LangDAO;
import org.myconf.util.RequestUtils;
import org.myconf.util.StatTool;
import org.myconf.util.StringUtils;
import org.myconf.util.FileUtils;
import java.io.File;

public class TemplateAction extends ActionBase{

	private final static Log log = LogFactory.getLog(TemplateAction.class);

	/**
		 * 模板选择
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 
		 */
		protected ActionForward doDefault(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			StatTool.execute(request, response);	//执行访问人数统计
			
			ActionMessages msgs = new ActionMessages();
			String template=null;
			LangBean lbean=null;
			String temproot=null;
			StringBuffer url=new StringBuffer();
			StringBuffer temp=new StringBuffer();
			int langId=0;
			try{
					langId=RequestUtils.getParam(request, "lang", 0);
					lbean=LangDAO.getLang(langId);
					if(lbean==null){
						 	lbean=LangDAO.getDefaultLang();
							if(lbean==null){
								msgs.add("err", new ActionMessage("error.db"));
						}
					}
					
					if(msgs.isEmpty()){
						template=lbean.getTemplate();
						if(StringUtils.isEmpty(template)){
							template=Globals.TEMPLATE_DEFAUT;//获取默认模板
						}
					}
					
					String path=getServlet().getServletContext().getRealPath("/")+"site"+File.separator+"template"+File.separator;
					String spath=path+template;
					if(FileUtils.isExistFolder(spath)){
						url.append("/").append("site").append("/").append("template").append("/").append(template).append("/index.jsp");
						temproot=temp.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(template).append("/").toString();
					}			
			
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("tempalte error when choosing", e);
			}

			if (!msgs.isEmpty()) {
				saveMessages(request, msgs);
				return mapping.findForward("error");
			}

			request.setAttribute("lang", lbean);
			request.setAttribute("temproot", temproot);
		
			return new ActionForward(url.toString());
		}

	}

