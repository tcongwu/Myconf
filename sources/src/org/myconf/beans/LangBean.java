package org.myconf.beans;

import java.sql.Timestamp;
import java.util.List;

import org.myconf.beans.base._BeanBase;

/**
 * ������վ������Ϣ��
 * @author libin
 */
public class LangBean extends _BeanBase {
	
	public final static int LANG_ZH_CN=1;//�����������԰汾
	public final static int LANG_ZH_TW=2;//�����������԰汾
	public final static int LANG_ENGLISH=3;//Ӣ�����԰汾
	
	public final static int LANG_PUBLISHED  = 1;//����
	public final static int LANG_PUBLISHED_NOT = 2;//������
	public final static int LANG_ISDEDAULT  = 1;//Ĭ�Ϸ���
	public final static int LANG_ISDEDAULT_NOT = 2;//Ĭ�ϲ�����
	
	private String languange;	//���԰汾
	private String confName;	//��������
	private String shortName;	//������
	private String template;	//��ʹ��ģ��
	private String copyright;	//��Ȩ��Ϣ
	private String email;	//��ϵemail
	private int published;	//�Ƿ񷢲�
	private int isDefault;	//�Ƿ�ΪĬ������
	
	private Timestamp createTime;	//����ʱ��
	private Timestamp updateTime;	//����ʱ��
	
	private List menus;	//ĳ���԰汾�еĲ˵���
	private List contents;	//ĳ���԰汾�е�����ҳ��
	
	
	private int show1;//1-�����Ƿ���ʾ��banner��
	private int show2;//1-����Ƿ���ʾ��banner��

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
