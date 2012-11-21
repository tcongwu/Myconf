package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * 稿件评审结果信息类
 * @author libin
 */
public class ReviewBean extends _BeanBase {

	public final static int REVIEW_STATUS_BEGIN  = 1;
	public final static int REVIEW_STATUS_FINISH = 2;
	public final static int REVIEW_STATUS_QUIT = 3;
	
	private PaperBean paper;		//所评审的稿件信息
	
	private UserBean expert;	//评审专家
	private String expertName;	//评审专家姓名
	private int status;	//评审信息的状态
	
	private float score1;	//指标1的得分
	private float score2;	//指标2的得分
	private float score3;	//指标3的得分
	private float score4;	//指标4的得分
	private float score5;	//指标5的得分
	private float score6;	//指标6的得分
	private float score7;	//指标7的得分
	private float score8;	//指标8的得分
	private float score9;	//指标9的得分
	private float score10;	//指标10的得分
	private float score11;	//指标11的得分
	private float score12;	//指标12的得分
	private float score13;	//指标13的得分
	private float score14;	//指标14的得分
	private float score15;	//指标15的得分
	private float score16;	//指标16的得分
	
	private float totalScore;	//评审总的得分
	private int recoStatus;	//专家推荐的录用状态
	private String opinion;	//专家的评审意见
	private Timestamp reviewTime;	//评审提交时间

	public PaperBean getPaper() {
		if(paper==null)
		paper = new PaperBean();
		return paper;
	}

	public void setPaper(PaperBean user) {
		this.paper = user;
	}

	public UserBean getExpert() {
		return expert;
	}

	public void setExpert(UserBean u) {
		this.expert = u;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String str) {
		this.expertName = str;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int it) {
		this.status = it;
	}

	public float getScore1() {
		return score1;
	}

	public void setScore1(float ft) {
		this.score1 = ft;
	}

	public float getScore2() {
		return score2;
	}

	public void setScore2(float ft) {
		this.score2 = ft;
	}

	public float getScore3() {
		return score3;
	}

	public void setScore3(float ft) {
		this.score3 = ft;
	}

	public float getScore4() {
		return score4;
	}

	public void setScore4(float ft) {
		this.score4 = ft;
	}

	public float getScore5() {
		return score5;
	}

	public void setScore5(float ft) {
		this.score5 = ft;
	}

	public float getScore6() {
		return score6;
	}

	public void setScore6(float ft) {
		this.score6 = ft;
	}

	public float getScore7() {
		return score7;
	}

	public void setScore7(float ft) {
		this.score7 = ft;
	}

	public float getScore8() {
		return score8;
	}

	public void setScore8(float ft) {
		this.score8 = ft;
	}

	public float getScore9() {
		return score9;
	}

	public void setScore9(float ft) {
		this.score9 = ft;
	}

	public float getScore10() {
		return score10;
	}

	public void setScore10(float ft) {
		this.score10 = ft;
	}

	public float getScore11() {
		return score11;
	}

	public void setScore11(float ft) {
		this.score11 = ft;
	}

	public float getScore12() {
		return score12;
	}

	public void setScore12(float ft) {
		this.score12 = ft;
	}

	public float getScore13() {
		return score13;
	}

	public void setScore13(float ft) {
		this.score13 = ft;
	}

	public float getScore14() {
		return score14;
	}

	public void setScore14(float ft) {
		this.score14 = ft;
	}

	public float getScore15() {
		return score15;
	}

	public void setScore15(float ft) {
		this.score15 = ft;
	}

	public float getScore16() {
		return score16;
	}

	public void setScore16(float ft) {
		this.score16 = ft;
	}

	public float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(float ft) {
		this.totalScore = ft;
	}

	public int getRecoStatus() {
		return recoStatus;
	}

	public void setRecoStatus(int it) {
		this.recoStatus = it;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String str) {
		this.opinion = str;
	}

	public Timestamp getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Timestamp ts) {
		this.reviewTime = ts;
	}
}