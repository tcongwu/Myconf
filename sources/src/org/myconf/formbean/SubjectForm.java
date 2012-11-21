package org.myconf.formbean;

/**
 * 稿件所属主题表单类
 * @author libin
 */
public class SubjectForm extends FormBean {
	
	private String subject;	//主题
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String str) {
		this.subject = str;
	}
}
