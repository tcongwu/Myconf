package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base.NameInfo;
import org.myconf.beans.base._BeanBase;

/**
 * �û�������Ļ���
 * @see org.myconf.SessionUserObject
 * @author libin
 */
public abstract class UserBaseInfo extends _BeanBase {
	
	private String email;		//�û�email��Ҳ����վ�ĵ�¼�ʺ�
	
	private NameInfo name;		//�û��������ͳ�ν��Ϣ
	
	private String realName;		//�û���ʵ����
	private String workLocation;	//������λ
	private String research;	//�о�����
	private String phone;	//��ϵ�绰
	private String fax;	//����
	private String address;	//ͨ�ŵ�ַ
	private String postcode;	//�ʱ�
	private String state;	//����ʡ�ݻ���
	private String country;	//���ڹ���
	
	private int isAdmin;	//�Ƿ�Ϊϵͳ����Ա
	private int isExpert;	//�Ƿ�Ϊ����ר��
	private int isContent;	//�Ƿ�Ϊ������վ����Ա
	private int isAuthor;	//�Ƿ�Ϊ����
	
	private String role;	//�û���ӵ�еĽ�ɫ
	private int status;	//�û�״̬
	
	private int loginCount;	//�û���¼�Ĵ���
	private Timestamp regTime;	//�ʺ�ע��ʱ��
	private Timestamp lastTime;	//���һ�ε�¼��ʱ��
	private String lastAddr;	//��һ��ע���IP��ַ���������һ�ε�¼��IP��ַ
	
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
