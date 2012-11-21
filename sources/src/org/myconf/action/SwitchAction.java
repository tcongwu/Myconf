package org.myconf.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.myconf.util.RequestUtils;

import org.apache.struts.Globals; 
import java.util.Locale;

/**
 * 发送邮件相关的Action类
 * 
 * @author libin
 */
public class SwitchAction extends ActionBase {

	private final static Log log = LogFactory.getLog(SwitchAction.class);

	/**
	 * 发送邮件(mailsend.jsp)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doDefault(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		int lang=RequestUtils.getParam(request, "lang", 0);

		switch(lang){ 
			case org.myconf.Globals.LANG_SIMPLIFIED:
				request.getSession().setAttribute(Globals.LOCALE_KEY,Locale.CHINA);
				break;
			case org.myconf.Globals.LANG_TRADITIONAL:
				request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.TAIWAN);
				break;
			case org.myconf.Globals.LANG_ENGLISH:
				request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
				break;
			default:
				request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
				break;
		}
		
		return new ActionForward(request.getParameter("url"), true);
	}

}
