package org.myconf.formbean;

/**
 * 稿件评审结果状态表单类
 * @author libin
 */
public class StatusForm extends FormBean {
	
	private String status;	//主题

	public String getStatus() {
		return status;
	}

	public void setStatus(String str) {
		this.status = str;
	}
}
