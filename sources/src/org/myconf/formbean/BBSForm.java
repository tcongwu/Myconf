package org.myconf.formbean;

/**
 * ����������
 * @author libin
 */
public class BBSForm extends FormBean {
	
	private String boardName;	//�������
	private int parentId;	//���ӵĸ���ID
	private String title;	//���ӵı���
	private String content;	//���ӵ�����
	
	private int isTop;	//�Ƿ��ö�
	private int status;		//���ӵ�״̬
	
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
