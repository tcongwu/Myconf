
package org.myconf.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.myconf.beans.LangBean;
import org.myconf.formbean.LangForm;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.myconf.util.*;

/**
 * 网站信息设置数据访问接口
 * 
 */
public class LangDAO extends DAO{


	/**
		 * 返回是否有网站基本信息设置,若返回值为0，则在第一次设置某一语言版本网站基本信息时默认为发布  
		 * @return
		 */
		public static int getLangCount(){
			String hql = "SELECT COUNT(*) FROM LangBean";
			return executeStatAsInt(hql, null);
		}

	/**
		 * 根据编号获取网站基本设置信息
		 * @param sid
		 * @return
		 */
		public static LangBean getLangByID(int sid){
			if(sid<1)
				return null;
			return (LangBean)getBean(LangBean.class, sid);
		}

	/**
	 * 获得某一语言版本网站信息的基本设置信息
	 * 
	 * @param languange
	 * @return
	 */
	public static List getLangByVersion(String  languange){
		Session ssn = getSession();
		String sql="SELECT * FROM Myconf_SiteLang L where L.languange=?";
		SQLQuery query = ssn.createSQLQuery(sql);
		query.setString(0,languange);
		List langlist=query.list();
		return langlist;
	}
	
	/**
	 * 获取全部已经发布的网站信息
	 * 
	 * @param languange
	 * @return
	 */
	public static List getLangPubish(){
		Session ssn = getSession();
		String sql="From LangBean  where published=:published";
		Query query = ssn.createQuery(sql.toString());
		query.setParameter("published",new Integer(LangBean.LANG_PUBLISHED));
		List langlist=query.list();
		return langlist;
	}
	
	
	/**
		 * 根据会议网站语言版本来获取对应的会议往网站信息
		 * @param languange
		 * @return
		 */
		public static LangBean getLang(String languange){
			if(languange==null)
				return null;
			return (LangBean)getSession().get(LangBean.class, new String(languange));
			
		}
	
	/**
	 * 根据会议网站ID来获取对应的会议往网站信息
	 * @param id
	 * @return
	 */
	public static LangBean getLang(int id){
		if(id < 0)
			return null;
		return (LangBean)getBean(LangBean.class, id);
	}
	
	/**
		 * 根据默认发布isDefault来获取会议网站信息，取第一条记录
		 * @param id
		 * @return
		 */
		public static LangBean getDefaultLang(){
				String hql="From LangBean AS l where l.isDefault=:isDefault";
				Session ssn = getSession();
				Query q = ssn.createQuery(hql.toString());
				q.setParameter("isDefault",new Integer(LangBean.LANG_ISDEDAULT));
				q.setMaxResults(1);
				return (LangBean) q.uniqueResult();
			}
			
	/**
	 * 修改会议网站信息
	 * @param lang
	 */
	public static void updateLang(LangBean lang){
		flush();
	}
	
	/**
	 * 删除会议网站设置信息
	 * @param lang
	 */
	public static void deleteLang(LangBean lang){
		getSession().delete(lang);
		getSession().flush();
	}
	
	/**
	 * 写会议网站信息到数据库
	 * @param pform 会议网站表单数据
	 * @param loginUser 用户信息
	 * @throws IllegalAccessException 
	 * @throws ObjectNotFoundException 
	 */
	public static boolean create(LangForm lform) 
		throws IllegalAccessException, HibernateException
	{
			
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(lform);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		
		return true;
	}
	
	public static void createLang(LangBean lang){
			if(lang==null)
				return;
			save(lang);
		}
		
	/**
	 * 列出所有会议网站信息
	 * @return
	 */
	public static List getLanglist(){
		String hql = "FROM LangBean AS L ORDER BY L.id ASC";
		return executeQuery(hql, -1, -1, null);
	}
	
	/**
	 * 修改会议网站发布和默认信息
	 * @param lang
	 */
	public static void updatePublished(String[] lang,String first){
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		boolean isdef=true;
		if(lang!=null&&lang.length>0){
			for(int i=0;i<lang.length;i++){
				LangBean lbean1=getLang(Integer.parseInt(lang[i]));
					lbean1.setPublished(LangBean.LANG_PUBLISHED);
					if(lang[i].equals(StringUtils.exportString(first))) 
						{
						lbean1.setIsDefault(LangBean.LANG_ISDEDAULT);
						isdef=false;
						}
					else{
						lbean1.setIsDefault(LangBean.LANG_ISDEDAULT_NOT)	;
					}
						lbean1.setUpdateTime(ts);
						flush();
				}
			}
			if(isdef){
			List list=getLanglist();
			LangBean lb=(LangBean)list.get(0);
			if(lb!=null)
			{
				lb.setIsDefault(LangBean.LANG_ISDEDAULT);
				flush();
			}
			}
		}

		
}
