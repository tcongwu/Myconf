
package org.myconf.dao;

import java.util.List;

import org.hibernate.Session;
import org.myconf.beans.ContentBean;
import org.myconf.beans.LangBean;
import org.hibernate.Query;


/**
 * 网站内容信息设置数据访问接口
 * 
 */
public class ContentDAO extends DAO{


	/**
		 * 根据编号获取网站内容信息
		 * @param sid
		 * @return
		 */
		public static ContentBean getContentByID(int sid){
			if(sid<1)
				return null;
			return (ContentBean)getBean(ContentBean.class, sid);
		}

	/**
	 * 需要注意mysql的数据库表区分大小问题 
	 * 
	 * 获得某一语言版本网站内容
	 * @param languange
	 * @return
	 */
	public static List getContentByVersion(LangBean lang){
		Session ssn = getSession();
		String sql=" FROM ContentBean where lang=:lang order by ordering asc";
		Query query = ssn.createQuery(sql);
	//	query.setInteger(0,lang);
		query.setParameter("lang",lang);
		
		List contentlist=query.list();
		return contentlist;
	}
	
	/**
		 * 根据会议网站语言版本来获取对应的会议网站内容信息
		 * @param languange
		 * @return
		 */
		public static List getContentByLang(LangBean lang){
			if(lang==null)
				return null;
			return (List)getSession().get(ContentBean.class, lang);
			//return (LangBean)getBean(LangBean.class, languange);
		}
	
	

	
	/**
	 * 根据会议网站ID来获取对应的会议往网站信息
	 * @param id
	 * @return
	 */
	public static ContentBean getContent(int id){
		if(id < 0)
			return null;
		return (ContentBean)getBean(ContentBean.class, id);
	}
	
	/**
	 * 修改会议网站内容信息
	 * @param content
	 */
	public static void updateContent(ContentBean content){
		flush();
	}
	
	/**
		 * 更新会议网站内容信息
		 * @param content
		 */
		public static void updateSiteContent(ContentBean content){
			flush();
		}
	/**
	 * 删除会议网站内容信息
	 * @param content
	 */
	public static void deleteContent(ContentBean contetn){
		getSession().delete(contetn);
		getSession().flush();
	}
	
	/**
	 * 写会议网站内容信息到数据库
	 */
	
	
	public static void createContent(ContentBean content){
			if(content==null)
				return;
			save(content);
		}
		
	/**
		 * 根据发布published状态来获取会议网站内容信息，取第一条记录
		 * @param id
		 * @return
		 */
	public static ContentBean getDefaultContent(LangBean lang){
				String hql="From ContentBean AS c where c.published=:published and c.lang=:lang order by c.id asc";
				Session ssn = getSession();
				Query q = ssn.createQuery(hql.toString());
				q.setParameter("published",new Integer(ContentBean.CONTENT_PUBLISHED));
				q.setParameter("lang",lang);
				q.setMaxResults(1);
				return (ContentBean) q.uniqueResult();
			}
}
