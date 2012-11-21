package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * ��������Ϣ��
 * @author libin
 */
public class BBSBean extends _BeanBase {
	
	public final static String BOARD_CONF="conference";
	
	private String boardName;	//�������
	private int parentId;	//���ӵĸ���ID
	private String title;	//���ӵı���
	private String content;	//���ӵ�����
	
	private int isTop;	//�Ƿ��ö�
	private int status;		//���ӵ�״̬
	
	private int authorId;	//����ID
	private String authorName;	//���ߵ�����
	
	private int visitCount;	//�������
	private int replyCount;		//�ظ�����
	private Timestamp createTime;	//�������ӵ�ʱ��
	
	public BBSBean(){}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String str) {
		this.boardName = str;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int it) {
		this.parentId = it;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String str) {
		this.title = str;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String str) {
		this.content = str;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int it) {
		this.isTop = it;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int it) {
		this.status = it;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int it) {
		this.authorId = it;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String str) {
		this.authorName = str;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int it) {
		this.visitCount = it;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int it) {
		this.replyCount = it;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp ts) {
		this.createTime = ts;
	}
}
