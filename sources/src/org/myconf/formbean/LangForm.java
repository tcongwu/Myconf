
package org.myconf.formbean;

import java.sql.Timestamp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.myconf.beans.LangBean;
import org.myconf.util.StringUtils;

/**
 * ����վ�������Ϣ��
 * @author 
 */

public class LangForm extends FormBean {
	
	final static Log log = LogFactory.getLog(LangForm.class);
	
	protected String languange;	//���԰汾
	protected String confname;	//������������
	protected String shortname;	//������
	protected String copyright;	//������վ��Ȩ
	protected String email;	//������վemail
	protected String template;	//������վģ��
	protected int published;		//������վ�Ƿ񷢲� 1-���� 2-������
	protected int isdefault;		//�Ƿ�ΪĬ�Ϸ���״̬ 1-�� 2-��
	private Timestamp createTime;	//����ʱ��
	private Timestamp updateTime;	//����ʱ��
	private int show1;//1-�����Ƿ���ʾ��banner��
	private int show2;//1-�������Ƿ���ʾ��banner��
	

	public String getConfname() {
		return confname;
	}

	public String getCopyright() {
		return copyright;
	}

	
	public Timestamp getCreateTime() {
		return createTime;
	}

	public String getEmail() {
		return email;
	}


	public int getIsdefault() {
		return isdefault;
	}

	
	public String getLanguange() {
		return languange;
	}


	public int getPublished() {
		return published;
	}

	
	public String getShortname() {
		return shortname;
	}


	public String getTemplate() {
		return template;
	}


	public Timestamp getUpdateTime() {
		return updateTime;
	}


	public void setConfname(String confname) {
		this.confname = confname;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setIsdefault(int  isdefault) {
		this.isdefault = isdefault;
	}


	public void setPublished(int published) {
		this.published = published;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}


	public void setTemplate(String template) {
		this.template = template;
	}


	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	

	public int getShow1() {
			return show1;
		}

	
	public int getShow2() {
			return show2;
		}

	public void setShow1(int show1) {
			this.show1 = show1;
		}

		
	public void setShow2(int show2) {
			this.show2 = show2;
		}

	
	public void setLanguange(String languange) {
		this.languange = languange;
	}
	
	
	/**
		 * ��֤��
		 * 
		 * @return �Ƿ���Ч
		 */
		public boolean validateForm(){
			if(StringUtils.isEmpty(this.confname)||StringUtils.isEmpty(this.shortname)||StringUtils.isEmpty(this.copyright)||StringUtils.isEmpty(this.email))
				return false;
				return true;
		}
	
	/**
		 * ��formת��Ϊbean
		 * 
		 * @param request
		 * @param user
		 * @return
		 */
		public LangBean formToBean() {
			LangBean lbean = new LangBean();
			// ��ֵ
			lbean.setLanguange(getLanguange());
			lbean.setConfName(getConfname());
			lbean.setShortName(getShortname());
			lbean.setCopyright(getCopyright());
			lbean.setEmail(getEmail());
			lbean.setTemplate(getTemplate());
			lbean.setIsDefault(getIsdefault());
			lbean.setCreateTime(getCreateTime());
			lbean.setUpdateTime(getUpdateTime());
			lbean.setShow1(getShow1());
			lbean.setShow2(getShow2());
			
			return lbean;
		}
		
	public LangBean getLang(){
			LangBean lang = new LangBean();
			lang.setConfName(this.confname);
			lang.setShortName(this.getShortname());
			lang.setCopyright(this.getCopyright());
			lang.setEmail(this.email);
		  lang.setCreateTime(this.createTime);
		  lang.setUpdateTime(this.updateTime);
		  lang.setLanguange(this.getLanguange());
		  lang.setIsDefault(this.isdefault);
		  lang.setPublished(this.published);
		  lang.setShow1(this.show1);
		  lang.setShow2(this.show2);
		  
			return lang;
		}
	


}

