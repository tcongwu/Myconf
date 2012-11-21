package org.myconf.beans;

import java.sql.Timestamp;
import org.myconf.beans.base._BeanBase;

/**
 * 稿件录用状态信息类
 * @author libin
 */
public class StatusBean extends _BeanBase {
	
	public final static int STATUS_DEFAULT = -1;	//稿件默认的录用状态
	
	private String status;	//主题
	
	private Timestamp regTime;	//创建时间
	private Timestamp updateTime;	//最近更新的时间

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
