package org.myconf.beans;

/**
 * �ʼ���Ϣ��
 * @author libin
 */
public class MailBean {
	
	private String from;	//������
	private String pass;	//����email����
	private String smtp;	//�����ʼ���������ַ
	private int port;	//�������˿�
	private boolean bySSL;	//�Ƿ�ʹ�ð�ȫ����
	
	private String[] to;	//�ռ��˵�ַ�б�
	
	private String subject;	//�ʼ�����
	private String content;	//�ʼ�����
	
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
