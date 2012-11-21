package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * ר�Ҿ��������Ϣ��
 * @author libin
 */
public class BidBean extends _BeanBase {
	
	private PaperBean paper;		//�������ĸ����Ϣ
	
	private int expertId;	//����ר��ID
	private String expertName;	//����ר������
	private String research;	//����ר�ҵ��о�����
	private Timestamp bidTime;	//�ύ������ʱ��

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