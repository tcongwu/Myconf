package org.myconf.formbean;

import org.myconf.util.StringUtils;

/**
 * 评审指标表单类
 * @author libin
 */
public class ReferForm extends FormBean {
	
	private int referNo;	//指标序号
	private String title;	//评审指标的标题
	private String description;	//评审指标的详细说明
	
	private float minScore;	//指标的最低分
	private float maxScore;	//指标的最高分

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
	 * 验证表单
	 * 
	 * @return 是否有效
	 */
	public boolean validateForm(){
		if(StringUtils.isEmpty(this.title) || this.referNo<1 || this.minScore<0 || this.maxScore<=0)
			return false;
		
		return true;
	}
}
