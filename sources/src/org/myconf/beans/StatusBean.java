package org.myconf.beans;

import java.sql.Timestamp;
import org.myconf.beans.base._BeanBase;

/**
 * ���¼��״̬��Ϣ��
 * @author libin
 */
public class StatusBean extends _BeanBase {
	
	public final static int STATUS_DEFAULT = -1;	//���Ĭ�ϵ�¼��״̬
	
	private String status;	//����
	
	private Timestamp regTime;	//����ʱ��
	private Timestamp updateTime;	//������µ�ʱ��

	public String getStatus() {
		return status;
	}

	public void setStatus(String str) {
		this.status = str;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp lastTime) {
		this.updateTime = lastTime;
	}
}
