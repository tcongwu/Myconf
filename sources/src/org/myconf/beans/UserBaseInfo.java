package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base.NameInfo;
import org.myconf.beans.base._BeanBase;

/**
 * 用户资料类的基类
 * @see org.myconf.SessionUserObject
 * @author libin
 */
public abstract class UserBaseInfo extends _BeanBase {
	
	private String email;		//用户email，也是网站的登录帐号
	
	private NameInfo name;		//用户的姓名和称谓信息
	
	private String realName;		//用户真实姓名
	private String workLocation;	//工作单位
	private String research;	//研究方向
	private String phone;	//联系电话
	private String fax;	//传真
	private String address;	//通信地址
	private String postcode;	//邮编
	private String state;	//所在省份或州
	private String country;	//所在国家
	
	private int isAdmin;	//是否为系统管理员
	private int isExpert;	//是否为评审专家
	private int isContent;	//是否为会议网站管理员
	private int isAuthor;	//是否为作者
	
	private String role;	//用户所拥有的角色
	private int status;	//用户状态
	
	private int loginCount;	//用户登录的次数
	private Timestamp regTime;	//帐号注册时间
	private Timestamp lastTime;	//最后一次登录的时间
	private String lastAddr;	//第一次注册的IP地址或者是最后一次登录的IP地址
	
	public UserBaseInfo(){}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String str) {
		this.email = str;
	}

	public NameInfo getName() {
		if(name==null)
			name = new NameInfo();
		return name;
	}

	public void setName(NameInfo name) {
		this.name = name;
	}

	public String getRealName() {
		if(this.name==null)
			return null;
		return this.name.toString();
	}

	public void setRealName(String str) {
		this.realName = str;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String str) {
		this.workLocation = str;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String str) {
		this.research = str;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String str) {
		this.phone = str;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String str) {
		this.fax = str;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String str) {
		this.address = str;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String str) {
		this.postcode = str;
	}

	public String getState() {
		return state;
	}

	public void setState(String str) {
		this.state = str;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String str) {
		this.country = str;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int it) {
		this.isAdmin = it;
	}

	public int getIsExpert() {
		return isExpert;
	}

	public void setIsExpert(int it) {
		this.isExpert = it;
	}

	public int getIsContent() {
		return isContent;
	}

	public void setIsContent(int it) {
		this.isContent = it;
	}

	public int getIsAuthor() {
		return isAuthor;
	}

	public void setIsAuthor(int it) {
		this.isAuthor = it;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String str) {
		this.role = str;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int it) {
		this.status = it;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int it) {
		this.loginCount = it;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getLastTime() {
		return lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastAddr() {
		return lastAddr;
	}

	public void setLastAddr(String lastAddr) {
		this.lastAddr = lastAddr;
	}
}
