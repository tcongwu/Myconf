package org.myconf.beans;

import java.sql.Timestamp;

import org.myconf.beans.base._BeanBase;

/**
 * 会议网站页面内容信息类
 * @author libin
 */
public class ContentBean extends _BeanBase {
	
	public final static int CONTENT_PUBLISHED  = 1;//发布
	public final static int CONTENT_PUBLISHED_NOT = 2;//不发布
		
	private LangBean lang;	//所属语言版本
	private String title;	//页面标题
	private String pagetext;	//内容
	private int sectionId;	//属于那个部分
	private int version;	//页面版本，每修改一次，版本加1
	private int published;	//是否发布
	private int ordering;		//页面内容的排序
	
	private int creator;	//创建用户ID
	private Timestamp createTime;	//创建帖子的时间
	
	private int modifier;	//修改菜单的用户ID
	private Timestamp modifyTime;	//修改的时间
	
	private int hits; //内容页面被浏览的次数

	public LangBean getLang() {
		return lang;
	}

	public void setLang(LangBean lb) {
		this.lang = lb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String str) {
		this.title = str;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int it) {
		this.sectionId = it;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int it) {
		this.version = it;
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

	public int getHits() {
		return hits;
	}

	public void setHits(int it) {
		this.hits = it;
	}
	
	public String getPagetext() {
		return pagetext;
	}

	
	public void setPagetext(String string) {
		pagetext = string;
	}

}