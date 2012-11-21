package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.Globals;
import org.myconf.beans.base._BeanBase;
import org.myconf.util.StringUtils;

/**
 * 系统设置信息类
 * @author libin
 */
public class ConfigBean extends _BeanBase {
	
	public final static int CONFIG_ID=1;

	public final static int STAGE_NONE=1;
	public final static int STAGE_SUBMISSION=2;
	public final static int STAGE_REVIEW=3;
	public final static int STAGE_CONFIRM=4;
	public final static int STAGE_DONE=5;
	
	public final static String MAIL_ADDRESS="leebin98@163.com";
	public final static String MAIL_PASS="yahooo";
	public final static String MAIL_SMTP="smtp.163.com";
	
	private String banner;	//网站banner图片路径
	private String subIns;	//投稿说明
	private String subFormat;	//稿件格式
	private int subSize;	//稿件大小
	private long subBeginDate;	//投稿开始日期
	private long subEndDate;	//投稿截止日期
	private long conBeginDate;	//定稿开始日期
	private long conEndDate;	//定稿截止日期

	private String reviewIns;	//评审说明
	private long reviewBeginDate;	//评审开始日期
	private long reviewEndDate;	//评审截止日期
	private int isAnony;	//是否匿名评审
		
	private String email;	//邮件客户端EMAIL地址
	private String pass;		//邮件帐号密码，加密
	private int bySSL;	//是否通过SSL连接邮件服务器
	private String smtp;	//邮件帐号的SMTP服务器地址，用于发送邮件
	private int port;		//SMTP服务器使用的端口
	
	private int isProcess;	//是否开放评审过程
	private int isOpen;		//是否公布评审结果
	
	private Timestamp updateTime;	//设置更新时间
	private Timestamp createTime;	//设置创建时间，即建站时间
	
	/**
	 * 判断会议当前所处状态
	 * 
	 * @return 代表阶段的整数
	 */
	public int isStage(){
		long cur=System.currentTimeMillis();
		
		if(cur>this.subBeginDate && cur<this.subEndDate)
			return STAGE_SUBMISSION;
			
		if(cur>this.reviewBeginDate && cur<this.reviewEndDate)
			return STAGE_REVIEW;

		if(cur>this.conBeginDate && cur<this.conEndDate)
			return STAGE_CONFIRM;

		if(this.reviewEndDate>0 && cur>this.reviewEndDate && this.isOpen==ConfigBean.TRUE)
			return STAGE_DONE;

		return STAGE_NONE;
	}
	
	/**
	 * 获取会议当前阶段的名称
	 * @return
	 */
	public String getStageName(){
		
		switch(isStage()){
			case STAGE_SUBMISSION: 
				return Globals.getMessage("common", "common.stage.submission");
			case STAGE_REVIEW: 
				return Globals.getMessage("common", "common.stage.review");
			case STAGE_CONFIRM:
				return Globals.getMessage("common", "common.stage.confirm");
			case STAGE_DONE:
				return Globals.getMessage("common", "common.stage.finish");
			default: 
				return "- -";
		} 

	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String str) {
		this.banner = str;
	}

	public String getSubIns() {
		return subIns;
	}

	public void setSubIns(String str) {
		this.subIns = str;
	}

	public String getSubFormat() {
		return subFormat;
	}

	public void setSubFormat(String str) {
		this.subFormat = str;
	}

	public int getSubSize() {
		return subSize;
	}

	public void setSubSize(int it) {
		this.subSize = it;
	}

	public long getSubBeginDate() {
		return subBeginDate;
	}
	
	public String getFmSubBeginDate(){
		return StringUtils.exportDate(this.subBeginDate, "yyyy-MM-dd", "0000-00-00");
	}

	public void setSubBeginDate(long lg) {
		this.subBeginDate = lg;
	}

	public long getSubEndDate() {
		return subEndDate;
	}
	
	public String getFmSubEndDate(){
		return StringUtils.exportDate(this.subEndDate, "yyyy-MM-dd", "0000-00-00");
	}

	public void setSubEndDate(long lg) {
		this.subEndDate = lg;
	}

	public long getConBeginDate() {
		return conBeginDate;
	}
	
	public String getFmConBeginDate(){
		return StringUtils.exportDate(this.conBeginDate, "yyyy-MM-dd", "0000-00-00");
	}

	public void setConBeginDate(long lg) {
		this.conBeginDate = lg;
	}

	public long getConEndDate() {
		return conEndDate;
	}
	
	public String getFmConEndDate(){
		return StringUtils.exportDate(this.conEndDate, "yyyy-MM-dd", "0000-00-00");
	}

	public void setConEndDate(long lg) {
		this.conEndDate = lg;
	}

	public String getReviewIns() {
		return reviewIns;
	}

	public void setReviewIns(String str) {
		this.reviewIns = str;
	}

	public long getReviewBeginDate() {
		return reviewBeginDate;
	}
	
	public String getFmReviewBeginDate(){
		return StringUtils.exportDate(this.reviewBeginDate, "yyyy-MM-dd", "0000-00-00");
	}

	public void setReviewBeginDate(long lg) {
		this.reviewBeginDate = lg;
	}

	public long getReviewEndDate() {
		return reviewEndDate;
	}
	
	public String getFmReviewEndDate(){
		return StringUtils.exportDate(this.reviewEndDate, "yyyy-MM-dd", "0000-00-00");
	}

	public void setReviewEndDate(long lg) {
		this.reviewEndDate = lg;
	}

	public int getIsAnony() {
		return isAnony;
	}

	public void setIsAnony(int it) {
		this.isAnony = it;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String str) {
		this.email = str;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String str) {
		this.pass = str;
	}

	public int getBySSL() {
		return bySSL;
	}

	public void setBySSL(int it) {
		this.bySSL = it;
	}

	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String str) {
		this.smtp = str;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int it) {
		this.port = it;
	}

	public int getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(int it) {
		this.isProcess = it;
	}

	public int getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(int it) {
		this.isOpen = it;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp ts) {
		this.updateTime = ts;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp ts) {
		this.createTime = ts;
	}
}
