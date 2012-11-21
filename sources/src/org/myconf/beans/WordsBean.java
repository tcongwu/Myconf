package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * ���������Ϣ��
 * @author libin
 */
public class WordsBean extends _BeanBase {
	
	private PaperBean paper;		//�����Եĸ����Ϣ
	
	private int userId;	//�����û�ID
	private String firstName;	//�����û�����
	private String lastName;	//�����û�����
	private String content;	//��������
	private Timestamp createTime;	//���Դ���ʱ��

	public PaperBean getPaper() {
		if(paper==null)
		paper = new PaperBean();
		return paper;
	}

	public void setPaper(PaperBean user) {
		this.paper = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int it) {
		this.userId = it;
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

	public String getContent() {
		return content;
	}

	public void setContent(String str) {
		this.content = str;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp ts) {
		this.createTime = ts;
	}
}