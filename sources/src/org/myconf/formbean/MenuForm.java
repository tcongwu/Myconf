
package org.myconf.formbean;

import java.sql.Timestamp;
import org.myconf.beans.LangBean;


public class MenuForm extends FormBean{

	private LangBean lang;	//所属语言版本
	private String menuType;	//菜单类型
	private String menuName;	//菜单名称
	private String link;	//菜单指向的链接地址
	private String type;	//链接类型
	private String openType;	//打开链接内容的方式
	private String style;	//菜单样式
	
	private int published;	//是否发布
	private int ordering;		//菜单的排序
	
	private int creator;	//创建用户ID
	private Timestamp createTime;	//创建帖子的时间
	
	private int modifier;	//修改菜单的用户ID
	private Timestamp modifyTime;	//修改的时间

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