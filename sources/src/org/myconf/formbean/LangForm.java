
package org.myconf.formbean;

import java.sql.Timestamp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.myconf.beans.LangBean;
import org.myconf.util.StringUtils;

/**
 * 设置站点基本信息表单
 * @author 
 */

public class LangForm extends FormBean {
	
	final static Log log = LogFactory.getLog(LangForm.class);
	
	protected String languange;	//语言版本
	protected String confname;	//会议完整名称
	protected String shortname;	//会议简称
	protected String copyright;	//会议网站版权
	protected String email;	//会议网站email
	protected String template;	//会议网站模板
	protected int published;		//会议网站是否发布 1-发布 2-不发布
	protected int isdefault;		//是否为默认发布状态 1-是 2-否
	private Timestamp createTime;	//创建时间
	private Timestamp updateTime;	//更新时间
	private int show1;//1-名称是否显示在banner上
	private int show2;//1-会议简称是否显示在banner上
	

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
		 * 验证表单
		 * 
		 * @return 是否有效
		 */
		public boolean validateForm(){
			if(StringUtils.isEmpty(this.confname)||StringUtils.isEmpty(this.shortname)||StringUtils.isEmpty(this.copyright)||StringUtils.isEmpty(this.email))
				return false;
				return true;
		}
	
	/**
		 * 将form转换为bean
		 * 
		 * @param request
		 * @param user
		 * @return
		 */
		public LangBean formToBean() {
			LangBean lbean = new LangBean();
			// 赋值
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

