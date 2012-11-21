package org.myconf.beans;

import java.util.Date;

import org.myconf.beans.base._BeanBase;

/**
 * 网站统计信息
 * @author libin
 */
public class StatBean extends _BeanBase {

	protected int statDate;
	protected int uvCount;
	protected int pvCount;	
	protected Date updateTime;
	
	public StatBean(){}
	
	public int getStatDate() {
		return statDate;
	}
	
	public void setStatDate(int statDate) {
		this.statDate = statDate;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public int getPvCount() {
		return pvCount;
	}
	
	public void setPvCount(int pvCount) {
		this.pvCount = pvCount;
	}
	
	public void incPvCount(int count){
		this.pvCount += count;
	}
	
	public int getUvCount() {
		return uvCount;
	}
	
	public void setUvCount(int uvCount) {
		this.uvCount = uvCount;
	}
	
	public void incUvCount(int count){
		this.uvCount += count;
	}
	
	public Object clone(){
		StatBean ssb = new StatBean();
		ssb.setId(super.getId());
		ssb.setPvCount(this.pvCount);
		ssb.setUvCount(this.uvCount);
		ssb.setStatDate(this.statDate);
		ssb.setUpdateTime(this.updateTime);
		return ssb;
	}
}
