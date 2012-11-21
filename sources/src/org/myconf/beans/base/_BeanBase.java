package org.myconf.beans.base;

import java.io.Serializable;

/**
 * ����BEAN�Ļ���
 * @author libin
 */
public abstract class _BeanBase implements Serializable {

	public final static int STATUS_NORMAL  = 1;
	public final static int STATUS_FORBIDDEN = 2;

	public final static int TRUE  = 1;
	public final static int FALSE = 2;
	
	public final static int STATUS_ONLINE  = 1;
	public final static int STATUS_OFFLINE = 2;
	
	private int id=-1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		//��ͬ�����ྡ��ID����ͬҲ�ǲ���ȵ�
		if(!getClass().equals(obj.getClass()))
			return false;
		_BeanBase wb = (_BeanBase) obj;
		return getId() == wb.getId();
	}

	public int hashCode() {
		return _BeanBase.class.hashCode() + getId();
	}

}
