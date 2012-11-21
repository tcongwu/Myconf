
package org.myconf.formbean;

import java.sql.Timestamp;
import org.myconf.beans.LangBean;


public class MenuForm extends FormBean{

	private LangBean lang;	//�������԰汾
	private String menuType;	//�˵�����
	private String menuName;	//�˵�����
	private String link;	//�˵�ָ������ӵ�ַ
	private String type;	//��������
	private String openType;	//���������ݵķ�ʽ
	private String style;	//�˵���ʽ
	
	private int published;	//�Ƿ񷢲�
	private int ordering;		//�˵�������
	
	private int creator;	//�����û�ID
	private Timestamp createTime;	//�������ӵ�ʱ��
	
	private int modifier;	//�޸Ĳ˵����û�ID
	private Timestamp modifyTime;	//�޸ĵ�ʱ��

	public LangBean getLang() {
		return lang;
	}

	public void setLang(LangBean lb) {
		this.lang = lb;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String str) {
		this.menuType = str;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String str) {
		this.menuName = str;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String str) {
		this.link = str;
	}

	public String getType() {
		return type;
	}

	public void setType(String str) {
		this.type = str;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String str) {
		this.openType = str;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String str) {
		this.style = str;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int it) {
		this.published = it;
	}

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int it) {
		this.ordering = it;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int it) {
		this.creator = it;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp ts) {
		this.createTime = ts;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int it) {
		this.modifier = it;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp ts) {
		this.modifyTime = ts;
	}

}