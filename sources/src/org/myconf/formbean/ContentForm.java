
package org.myconf.formbean;

import java.sql.Timestamp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.myconf.beans.LangBean;

public class ContentForm extends FormBean{

	final static Log log = LogFactory.getLog(ContentForm.class);
	
	private LangBean lang;	//�������԰汾
	private String title;	//ҳ�����
	private String pagetext;	//ҳ������
	private int sectionId;	//�����Ǹ�����
	private int version;	//ҳ��汾��ÿ�޸�һ�Σ��汾��1
	private int published;	//�Ƿ񷢲�
	private int ordering;		//ҳ�����ݵ�����
	
	private int creator;	//�����û�ID
	private Timestamp createTime;	//�������ӵ�ʱ��
	
	private int modifier;	//�޸Ĳ˵����û�ID
	private Timestamp modifyTime;	//�޸ĵ�ʱ��
	
	private int hits; //����ҳ�汻����Ĵ���

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