package org.myconf.formbean;

import org.apache.struts.action.ActionForm;

/**
 * FormBean�Ļ���
 * @author libin
 */
public abstract class FormBean extends ActionForm {

	private int id;		//������
	private String fromPage;
	private String __ClientId;	//�ͻ��˰�ȫʶ����

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
