package org.myconf.formbean;

/**
 * �ʼ�����
 * @author libin
 */
public class MailForm extends FormBean {
	
	private String receiver;	//�ռ��˵�ַ�б�
	
	private String subject;	//�ʼ�����
	private String content;	//�ʼ�����
	
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
