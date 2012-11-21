package org.myconf.formbean;

import org.myconf.util.StringUtils;

/**
 * ����ָ�����
 * @author libin
 */
public class ReferForm extends FormBean {
	
	private int referNo;	//ָ�����
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
	
	/**
	 * ��֤��
	 * 
	 * @return �Ƿ���Ч
	 */
	public boolean validateForm(){
		if(StringUtils.isEmpty(this.title) || this.referNo<1 || this.minScore<0 || this.maxScore<=0)
			return false;
		
		return true;
	}
}
