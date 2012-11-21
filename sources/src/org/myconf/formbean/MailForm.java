package org.myconf.formbean;

/**
 * 邮件表单类
 * @author libin
 */
public class MailForm extends FormBean {
	
	private String receiver;	//收件人地址列表
	
	private String subject;	//邮件主题
	private String content;	//邮件内容
	
	public MailForm(){}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String str) {
		this.receiver = str;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String str) {
		this.subject = str;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String str) {
		this.content = str;
	}
}
