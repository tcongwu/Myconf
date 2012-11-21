package org.myconf.formbean;

/**
 * 讨论区表单类
 * @author libin
 */
public class BBSForm extends FormBean {
	
	private String boardName;	//版块名称
	private int parentId;	//帖子的父贴ID
	private String title;	//帖子的标题
	private String content;	//帖子的内容
	
	private int isTop;	//是否置顶
	private int status;		//帖子的状态
	
	public BBSForm(){}

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
}
