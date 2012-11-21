package org.myconf.beans;

import java.sql.Timestamp;
import java.util.List;

import org.myconf.beans.base._BeanBase;

/**
 * 稿件所属主题信息类
 * @author libin
 */
public class SubjectBean extends _BeanBase {
	
	private String subject;	//主题
	
	private Timestamp regTime;	//创建时间
	private Timestamp updateTime;	//最近更新的时间
	
	protected List papers;	//该主题下的稿件

	public String getSubject() {
		return subject;
	}

	public void setSubject(String str) {
		this.subject = str;
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
	
	public List getPapers() {
		return papers;
	}

	public void setPapers(List papers) {
		this.papers = papers;
	}
}
