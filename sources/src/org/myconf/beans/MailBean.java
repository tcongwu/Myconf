package org.myconf.beans;

/**
 * 邮件信息类
 * @author libin
 */
public class MailBean {
	
	private String from;	//发件人
	private String pass;	//发件email密码
	private String smtp;	//发送邮件服务器地址
	private int port;	//服务器端口
	private boolean bySSL;	//是否使用安全连接
	
	private String[] to;	//收件人地址列表
	
	private String subject;	//邮件主题
	private String content;	//邮件内容
	
	public MailBean(){}

	public String getFrom() {
		return from;
	}

	public void setFrom(String str) {
		this.from = str;
	}
	
	public String getUser(){
		if(from!=null && from.indexOf('@')!=-1)
			return from.substring(0, from.indexOf('@'));
		
		return null;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String str) {
		this.pass = str;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String str) {
		this.smtp = str;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int it) {
		this.port = it;
	}

	public boolean getBySSL() {
		return bySSL;
	}

	public void setBySSL(boolean bn) {
		this.bySSL = bn;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] str) {
		this.to = str;
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
