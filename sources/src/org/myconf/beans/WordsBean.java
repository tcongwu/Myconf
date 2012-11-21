package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * 稿件留言信息类
 * @author libin
 */
public class WordsBean extends _BeanBase {
	
	private PaperBean paper;		//所留言的稿件信息
	
	private int userId;	//留言用户ID
	private String firstName;	//留言用户的名
	private String lastName;	//留言用户的姓
	private String content;	//留言内容
	private Timestamp createTime;	//留言创建时间

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