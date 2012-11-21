package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;
import org.myconf.util.CharsetChecker;
import org.myconf.util.StringUtils;

/**
 * ���������Ϣ��
 * @author libin
 */
public class AuthorBean extends _BeanBase {
	
	private PaperBean paper;		//�����������
	
	private int orderNo;	//��������
	private String firstName;	//���ߵ���
	private String lastName;	//���ߵ���
	private String email;	//email��ַ
	private String institute;	//���ڵ�λ
	
	private Timestamp regTime;	//����ʱ��
	private Timestamp updateTime;	//������µ�ʱ��
	
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
