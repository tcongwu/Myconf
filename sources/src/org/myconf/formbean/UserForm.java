package org.myconf.formbean;

import org.myconf.beans.UserBean;
import org.myconf.beans.base.NameInfo;
import org.myconf.util.StringUtils;
import org.apache.struts.upload.FormFile;

/**
 * 注册用户表单
 * @author libin
 */
public class UserForm extends FormBean {
	
	private String email;		//用户email，也是网站的登录帐号
	private String password;	//登录密码
	private String password2;	//密码确认
	private String password3;	//新密码确认
	
	private int isAdmin;	//是否为系统管理员
	private int isAuthor;	//是否为投稿用户
	private int isContent;	//是否为网站管理员
	private int isExpert;	//是否为评审专家

	private String title;		//称呼
	private String firstName;	//名
	private String lastName;		//姓
	
	private String workLocation;	//工作单位
	private String research;	//研究方向
	private String phone;	//联系电话
	private String fax;	//传真
	private String address;	//通信地址
	private String postcode;	//邮编
	private String state;	//所在省份或州
	private String country;	//所在国家
	
	private FormFile ufile;	//专家列表Excel文档
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String str) {
		this.email = str;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String str) {
		this.password = str;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String str) {
		this.password2 = str;
	}

	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String str) {
		this.password3 = str;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(int it) {
		this.isAdmin = it;
	}
	
	public int getIsAuthor() {
		return isAuthor;
	}
	
	public void setIsAuthor(int it) {
		this.isAuthor = it;
	}
	
	public int getIsContent() {
		return isContent;
	}
	
	public void setIsContent(int it) {
		this.isContent = it;
	}
	
	public int getIsExpert() {
		return isExpert;
	}
	
	public void setIsExpert(int it) {
		this.isExpert = it;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String str) {
		this.title = str;
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
	
	public FormFile getUfile() {
		return ufile;
	}
	
	public void setUfile(FormFile ff) {
		this.ufile = ff;
	}

	/**
	 * 将form转换为bean
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	public UserBean formToBean() {
		UserBean ubean = new UserBean();
		//赋值
		ubean.setEmail(getEmail().trim());
		ubean.setPassword(getPassword());	

		NameInfo ni = new NameInfo();
		if (StringUtils.isNotEmpty(getTitle()))
			ni.setTitle(getTitle());
		if (StringUtils.isNotEmpty(getFirstName()))
			ni.setFirstName(getFirstName());
		if (StringUtils.isNotEmpty(getLastName()))
			ni.setLastName(getLastName());
		ubean.setName(ni);

		ubean.setWorkLocation(getWorkLocation());
		ubean.setResearch(getResearch());
		ubean.setPhone(getPhone());
		ubean.setFax(getFax());
		ubean.setAddress(getAddress());
		ubean.setPostcode(getPostcode());
		ubean.setState(getState());
		ubean.setCountry(getCountry());

		return ubean;
	}
}
