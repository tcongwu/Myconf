package org.myconf.formbean;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.struts.upload.FormFile;
import org.myconf.Globals;
import org.myconf.util.StringUtils;

/**
 * 系统设置表单
 * @author libin
 */
public class ConfigForm extends FormBean {
	
	private FormFile banner;	//网站banner图片路径
	
	private String subIns;	//投稿说明
	private String[] format;		//稿件格式
	private String subFormat;	//稿件格式
	private int subSize;	//稿件大小
	private long subBeginDate;	//投稿开始日期
	private int subYear1;		//投稿开始日期的年
	private int subMonth1;		//投稿开始日期的月
	private int subDay1;		//投稿开始日期的日
	private int subHour1;		//投稿开始日期的小时
	private long subEndDate;	//投稿截止日期
	private int subYear2;		//投稿截止日期的年
	private int subMonth2;		//投稿截止始日期的月
	private int subDay2;		//投稿截止日期的日
	private int subHour2;		//投稿截止日期的小时
	private long conBeginDate;	//定稿开始日期
	private int conYear1;		//定稿开始日期的年
	private int conMonth1;		//定稿开始日期的月
	private int conDay1;		//定稿开始日期的日
	private int conHour1;		//定稿开始日期的小时
	private long conEndDate;	//定稿截止日期
	private int conYear2;		//定稿截止日期的年
	private int conMonth2;		//定稿截止始日期的月
	private int conDay2;		//定稿截止日期的日
	private int conHour2;		//定稿截止日期的小时

	private String reviewIns;	//评审说明
	private long reviewBeginDate;	//评审开始日期
	private int reviewYear1;		//评审开始日期的年
	private int reviewMonth1;		//评审开始日期的月
	private int reviewDay1;		//评审开始日期的日
	private int reviewHour1;		//评审开始日期的小时
	private long reviewEndDate;	//评审截止日期
	private int reviewYear2;		//评审截止日期的年
	private int reviewMonth2;		//评审截止始日期的月
	private int reviewDay2;		//评审截止日期的日
	private int reviewHour2;		//评审截止日期的小时
	private int isAnony;	//是否匿名评审
		
	private String email;	//邮件客户端EMAIL地址
	private String pass;		//邮件帐号密码，加密
	private int bySSL;	//是否通过SSL连接邮件服务器
	private String smtp;	//邮件帐号的SMTP服务器地址，用于发送邮件
	private int port;		//SMTP服务器的端口
	
	private int isProcess;	//是否开放评审过程
	private int isOpen;		//是否公布评审结果
	
	private Timestamp updateTime;	//设置更新时间
	
	public FormFile getBanner() {
		return banner;
	}

	public void setBanner(FormFile file) {
		this.banner = file;
	}

	public String getSubIns() {
		return subIns;
	}

	public void setSubIns(String str) {
		this.subIns = str;
	}

	public String getSubFormat() {
		if(format!=null && format.length>0){
			StringBuffer sbuf=new StringBuffer();
			for(int i=0;i<format.length;i++){
				if(StringUtils.isNotEmpty(format[i].trim())){
					if(sbuf.length()>0)
						sbuf.append(Globals.SPLIT);
					sbuf.append(format[i]);
				}
			}
			return sbuf.toString().replaceAll("，", Globals.SPLIT).replaceAll(",", Globals.SPLIT);
		}
		return null;
	}

	public void setFormat(String[] str) {
		this.format = str;
	}

	public int getSubSize() {
		return subSize;
	}

	public void setSubSize(int it) {
		this.subSize = it;
	}

	public long getSubBeginDate() {
		try{
			if(subYear1>0 && subMonth1>0 && subDay1>0){
				Calendar cal=Calendar.getInstance();
				cal.clear();
				cal.set(subYear1, subMonth1-1, subDay1, subHour1, 0);
			
				return cal.getTimeInMillis();
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}

	public void setSubYear1(int it) {
		this.subYear1 = it;
	}

	public void setSubMonth1(int it) {
		this.subMonth1 = it;
	}

	public void setSubDay1(int it) {
		this.subDay1 = it;
	}

	public void setSubHour1(int it) {
		this.subHour1 = it;
	}

	public long getSubEndDate() {
		try{
			if(subYear2>0 && subMonth2>0 && subDay2>0){
				Calendar cal=Calendar.getInstance();
				cal.clear();
				cal.set(subYear2, subMonth2-1, subDay2, subHour2, 0);
			
				return cal.getTimeInMillis();
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}

	public void setSubYear2(int it) {
		this.subYear2 = it;
	}

	public void setSubMonth2(int it) {
		this.subMonth2 = it;
	}

	public void setSubDay2(int it) {
		this.subDay2 = it;
	}

	public void setSubHour2(int it) {
		this.subHour2 = it;
	}

	public long getConBeginDate() {
		try{
			if(conYear1>0 && conMonth1>0 && conDay1>0){
				Calendar cal=Calendar.getInstance();
				cal.clear();
				cal.set(conYear1, conMonth1-1, conDay1, conHour1, 0);
			
				return cal.getTimeInMillis();
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}

	public void setConYear1(int it) {
		this.conYear1 = it;
	}

	public void setConMonth1(int it) {
		this.conMonth1 = it;
	}

	public void setConDay1(int it) {
		this.conDay1 = it;
	}

	public void setConHour1(int it) {
		this.conHour1 = it;
	}

	public long getConEndDate() {
		try{
			if(conYear2>0 && conMonth2>0 && conDay2>0){
				Calendar cal=Calendar.getInstance();
				cal.clear();
				cal.set(conYear2, conMonth2-1, conDay2, conHour2, 0);
			
				return cal.getTimeInMillis();
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}

	public void setConYear2(int it) {
		this.conYear2 = it;
	}

	public void setConMonth2(int it) {
		this.conMonth2 = it;
	}

	public void setConDay2(int it) {
		this.conDay2 = it;
	}

	public void setConHour2(int it) {
		this.conHour2 = it;
	}

	public String getReviewIns() {
		return reviewIns;
	}

	public void setReviewIns(String str) {
		this.reviewIns = str;
	}

	public long getReviewBeginDate() {
		try{
			if(reviewYear1>0 && reviewMonth1>0 && reviewDay1>0){
				Calendar cal=Calendar.getInstance();
				cal.clear();
				cal.set(reviewYear1, reviewMonth1-1, reviewDay1, reviewHour1, 0);
			
				return cal.getTimeInMillis();
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}

	public void setReviewYear1(int it) {
		this.reviewYear1 = it;
	}

	public void setReviewMonth1(int it) {
		this.reviewMonth1 = it;
	}

	public void setReviewDay1(int it) {
		this.reviewDay1 = it;
	}

	public void setReviewHour1(int it) {
		this.reviewHour1 = it;
	}

	public long getReviewEndDate() {
		try{
			if(reviewYear2>0 && reviewMonth2>0 && reviewDay2>0){
				Calendar cal=Calendar.getInstance();
				cal.clear();
				cal.set(reviewYear2, reviewMonth2-1, reviewDay2, reviewHour2, 0);
			
				return cal.getTimeInMillis();
			}
		}
		catch(Exception e){
			return 0;
		}
		return 0;
	}

	public void setReviewYear2(int it) {
		this.reviewYear2 = it;
	}

	public void setReviewMonth2(int it) {
		this.reviewMonth2 = it;
	}

	public void setReviewDay2(int it) {
		this.reviewDay2 = it;
	}

	public void setReviewHour2(int it) {
		this.reviewHour2 = it;
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
}
