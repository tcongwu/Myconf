package org.myconf.formbean;

import org.apache.struts.action.ActionForm;

/**
 * FormBean的基类
 * @author libin
 */
public abstract class FormBean extends ActionForm {

	private int id;		//对象编号
	private String fromPage;
	private String __ClientId;	//客户端安全识别码

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getFromPage() {
		return fromPage;
	}

	public final void setFromPage(String fromPage) {
		this.fromPage = fromPage;		
	}

	public String get__ClientId() {
		return __ClientId;
	}

	public void set__ClientId(String clientId) {
		__ClientId = clientId;
	}
	
}
