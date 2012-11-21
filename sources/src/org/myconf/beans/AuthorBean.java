package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;
import org.myconf.util.CharsetChecker;
import org.myconf.util.StringUtils;

/**
 * 稿件作者信息类
 * @author libin
 */
public class AuthorBean extends _BeanBase {
	
	private PaperBean paper;		//作者所属稿件
	
	private int orderNo;	//作者排序
	private String firstName;	//作者的名
	private String lastName;	//作者的姓
	private String email;	//email地址
	private String institute;	//所在单位
	
	private Timestamp regTime;	//创建时间
	private Timestamp updateTime;	//最近更新的时间
	
	public String toString(){
		StringBuffer tos=new StringBuffer();
		if(StringUtils.isEmpty(firstName)){
			return "";
		}else if(CharsetChecker.isZH(firstName.substring(0,1))){
			tos.append(StringUtils.exportString(lastName)+firstName);
		}else{
			tos.append(firstName+' '+StringUtils.exportString(lastName));
		}
		if(StringUtils.isNotEmpty(email)){
			tos.append(", ");
			tos.append(email);
		}
		if(StringUtils.isNotEmpty(institute)){
			tos.append(", ");
			tos.append(institute);
		}
		return tos.toString();
	}
	
	public String nameToString(){
		if(StringUtils.isEmpty(firstName)){
			return "";
		}else if(CharsetChecker.isZH(firstName.substring(0,1))){
			return StringUtils.exportString(lastName)+firstName;
		}else{
			return firstName+' '+StringUtils.exportString(lastName);
		}
	}

	public PaperBean getPaper() {
		if(paper==null)
			this.paper = new PaperBean();
		return paper;
	}

	public void setPaper(PaperBean pb) {
		this.paper = pb;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int it) {
		this.orderNo = it;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String str) {
		this.firstName = str;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String str) {
		this.lastName = str;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String str) {
		this.email = str;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String str) {
		this.institute = str;
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
}
