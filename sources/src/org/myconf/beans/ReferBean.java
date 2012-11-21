package org.myconf.beans;

import org.myconf.beans.base._BeanBase;

/**
 * ����ָ����Ϣ��
 * @author libin
 */
public class ReferBean extends _BeanBase {
	
	private int referNo;	//ָ�����
	private int status;		//ָ��״̬
	private String title;	//����ָ��ı���
	private String description;	//����ָ�����ϸ˵��
	
	private float minScore;	//ָ�����ͷ�
	private float maxScore;	//ָ�����߷�

	public int getReferNo() {
		return referNo;
	}

	public void setReferNo(int it) {
		this.referNo = it;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int it) {
		this.status = it;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String str) {
		this.title = str;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String str) {
		this.description = str;
	}

	public float getMinScore() {
		return minScore;
	}

	public void setMinScore(float ft) {
		this.minScore = ft;
	}

	public float getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(float ft) {
		this.maxScore = ft;
	}
}
