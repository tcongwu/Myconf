package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * 讨论区信息类
 * @author libin
 */
public class BBSBean extends _BeanBase {
	
	public final static String BOARD_CONF="conference";
	
	private String boardName;	//版块名称
	private int parentId;	//帖子的父贴ID
	private String title;	//帖子的标题
	private String content;	//帖子的内容
	
	private int isTop;	//是否置顶
	private int status;		//帖子的状态
	
	private int authorId;	//作者ID
	private String authorName;	//作者的名字
	
	private int visitCount;	//浏览次数
	private int replyCount;		//回复次数
	private Timestamp createTime;	//创建帖子的时间
	
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
