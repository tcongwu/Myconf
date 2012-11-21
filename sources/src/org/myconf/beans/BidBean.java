package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * 专家竟评稿件信息类
 * @author libin
 */
public class BidBean extends _BeanBase {
	
	private PaperBean paper;		//所竟评的稿件信息
	
	private int expertId;	//竟评专家ID
	private String expertName;	//竟评专家姓名
	private String research;	//竟评专家的研究方向
	private Timestamp bidTime;	//提交竟评的时间

	public PaperBean getPaper() {
		if(paper==null)
		paper = new PaperBean();
		return paper;
	}

	public void setPaper(PaperBean user) {
		this.paper = user;
	}

	public int getExpertId() {
		return expertId;
	}

	public void setExpertId(int it) {
		this.expertId = it;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String str) {
		this.expertName = str;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String str) {
		this.research = str;
	}

	public Timestamp getBidTime() {
		return bidTime;
	}

	public void setBidTime(Timestamp ts) {
		this.bidTime = ts;
	}
}