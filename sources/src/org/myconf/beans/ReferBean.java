package org.myconf.beans;

import org.myconf.beans.base._BeanBase;

/**
 * 评审指标信息类
 * @author libin
 */
public class ReferBean extends _BeanBase {
	
	private int referNo;	//指标序号
	private int status;		//指标状态
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
