package org.myconf.formbean;

import org.myconf.beans.UserBean;
import org.myconf.beans.base.NameInfo;
import org.myconf.util.StringUtils;
import org.apache.struts.upload.FormFile;

/**
 * ע���û���
 * @author libin
 */
public class UserForm extends FormBean {
	
	private String email;		//�û�email��Ҳ����վ�ĵ�¼�ʺ�
	private String password;	//��¼����
	private String password2;	//����ȷ��
	private String password3;	//������ȷ��
	
	private int isAdmin;	//�Ƿ�Ϊϵͳ����Ա
	private int isAuthor;	//�Ƿ�ΪͶ���û�
	private int isContent;	//�Ƿ�Ϊ��վ����Ա
	private int isExpert;	//�Ƿ�Ϊ����ר��

	private String title;		//�ƺ�
	private String firstName;	//��
	private String lastName;		//��
	
	private String workLocation;	//������λ
	private String research;	//�о�����
	private String phone;	//��ϵ�绰
	private String fax;	//����
	private String address;	//ͨ�ŵ�ַ
	private String postcode;	//�ʱ�
	private String state;	//����ʡ�ݻ���
	private String country;	//���ڹ���
	
	private FormFile ufile;	//ר���б�Excel�ĵ�
	
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
	 * ��formת��Ϊbean
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	public UserBean formToBean() {
		UserBean ubean = new UserBean();
		//��ֵ
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
