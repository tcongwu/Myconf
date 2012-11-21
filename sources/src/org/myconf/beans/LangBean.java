package org.myconf.beans;

import java.sql.Timestamp;
import java.util.List;

import org.myconf.beans.base._BeanBase;

/**
 * 会议网站设置信息类
 * @author libin
 */
public class LangBean extends _BeanBase {
	
	public final static int LANG_ZH_CN=1;//简体中文语言版本
	public final static int LANG_ZH_TW=2;//繁体中文语言版本
	public final static int LANG_ENGLISH=3;//英语语言版本
	
	public final static int LANG_PUBLISHED  = 1;//发布
	public final static int LANG_PUBLISHED_NOT = 2;//不发布
	public final static int LANG_ISDEDAULT  = 1;//默认发布
	public final static int LANG_ISDEDAULT_NOT = 2;//默认不发布
	
	private String languange;	//语言版本
	private String confName;	//会议名称
	private String shortName;	//会议简称
	private String template;	//所使用模板
	private String copyright;	//版权信息
	private String email;	//联系email
	private int published;	//是否发布
	private int isDefault;	//是否为默认语言
	
	private Timestamp createTime;	//创建时间
	private Timestamp updateTime;	//更新时间
	
	private List menus;	//某语言版本中的菜单项
	private List contents;	//某语言版本中的内容页面
	
	
	private int show1;//1-名称是否显示在banner上
	private int show2;//1-简称是否显示在banner上

	public String getLanguange() {
		return languange;
	}

	public void setLanguange(String str) {
		this.languange = str;
	}

	public String getConfName() {
		return confName;
	}

	public void setConfName(String str) {
		this.confName = str;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String str) {
		this.shortName = str;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String str) {
		this.template = str;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String str) {
		this.copyright = str;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String str) {
		this.email = str;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int it) {
		this.published = it;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int it) {
		this.isDefault = it;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp ts) {
		this.createTime = ts;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp ts) {
		this.updateTime = ts;
	}

	public List getMenus() {
		return menus;
	}

	public void setMenus(List ms) {
		this.menus = ms;
	}

	public List getContents() {
		return contents;
	}

	public void setContents(List cs) {
		this.contents = cs;
	}
	

	public int getShow1() {
		return show1;
	}

	public int getShow2() {
		return show2;
	}


	public void setShow1(int it) {
		show1 = it;
	}


	public void setShow2(int it) {
		show2 = it;
	}

}
