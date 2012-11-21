package org.myconf.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
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
import org.myconf.beans.MailBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.ConfigDAO;
import org.myconf.formbean.MailForm;
import org.myconf.util.MailSender;
import org.myconf.util.StringUtils;
import org.myconf.Globals;

/**
 * 发送邮件相关的Action类
 * 
 * @author libin
 */
public class MailAction extends ActionBase {

	private final static Log log = LogFactory.getLog(MailAction.class);

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
	protected ActionForward doSend(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		MailForm mform = (MailForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(StringUtils.isEmpty(mform.getReceiver()))
			msgs.add("err", new ActionMessage("error.receiver.not.null"));
		else{
			try {
				//创建邮件内容对象
				MailBean mail=createMail();
				
				mail.setTo(mform.getReceiver().split(";"));
				mail.setSubject(StringUtils.exportString(mform.getSubject()));
				if(mform.getContent()!=null){
					mform.setContent(mform.getContent().replaceAll("\n", "<br>"));
					mform.setContent(mform.getContent().replaceAll(" ", "&nbsp;"));
				}
				mail.setContent(StringUtils.exportString(mform.getContent()));
				
				log.info("sending mail("+mail.getSubject()+") to "+mail.getTo()[0]);
				sendMail(mail);
				log.info("sending mail success...");

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.sending.mail"));
				log.error("send mail error.", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.send.mail.success"), false);
	}
	
	/**
	 * 创建一个邮件对象，对象包含发件人，以及邮件服务器信息
	 * @return
	 */
	protected static MailBean createMail(){
		ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
		MailBean mail=new MailBean();
		if(StringUtils.isEmpty(conf.getEmail()) || StringUtils.isEmpty(conf.getPass()) || StringUtils.isEmpty(conf.getSmtp()) || conf.getPort()==0){
			mail.setFrom(ConfigBean.MAIL_ADDRESS);
			mail.setPass(ConfigBean.MAIL_PASS);
			mail.setSmtp(ConfigBean.MAIL_SMTP);
			mail.setPort(25);
			mail.setBySSL(false);
		}else{
			mail.setFrom(conf.getEmail());
			mail.setPass(conf.getPass());
			mail.setSmtp(conf.getSmtp());
			mail.setPort(conf.getPort());
			mail.setBySSL(conf.getBySSL()==ConfigBean.TRUE);
		}
		return mail;
	}
    
	/**
	 * 发送邮件
	 * @param mail 包含邮件内容的对象
	 */
	public static void sendMail(MailBean mail) throws UnsupportedEncodingException, MessagingException, SendFailedException, Exception {
		String mailHost = mail.getSmtp();	//发送邮件服务器地址
		String mailUser = mail.getUser();			//发送邮件服务器的用户帐号
		String mailPassword = mail.getPass();	//发送邮件服务器的用户密码
		String[] toAddress = mail.getTo();
		
		//使用超文本格式发送邮件
		MailSender sendmail = MailSender.getHtmlMailSender(mailHost, mail.getPort(), mailUser, mailPassword, mail.getBySSL());
		//使用纯文本格式发送邮件
		//MailSender sendmail = MailSender.getTextMailSender(mailHost, mailUser,mailPassword);
		
		sendmail.setSubject(mail.getSubject());
		sendmail.setSendDate(new Date());
		sendmail.setMailContent(mail.getContent()); //邮件内容
		sendmail.setMailFrom(mail.getFrom(), null);
		sendmail.setMailTo(toAddress, "to");
		//开始发送邮件
		sendmail.sendMail();
	}

}
