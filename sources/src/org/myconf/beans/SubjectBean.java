package org.myconf.beans;

import java.sql.Timestamp;
import java.util.List;

import org.myconf.beans.base._BeanBase;

/**
 * �������������Ϣ��
 * @author libin
 */
public class SubjectBean extends _BeanBase {
	
	private String subject;	//����
	
	private Timestamp regTime;	//����ʱ��
	private Timestamp updateTime;	//������µ�ʱ��
	
	protected List papers;	//�������µĸ��

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
