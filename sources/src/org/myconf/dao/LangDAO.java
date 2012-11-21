
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
 * ��վ��Ϣ�������ݷ��ʽӿ�
 * 
 */
public class LangDAO extends DAO{


	/**
		 * �����Ƿ�����վ������Ϣ����,������ֵΪ0�����ڵ�һ������ĳһ���԰汾��վ������ϢʱĬ��Ϊ����  
		 * @return
		 */
		public static int getLangCount(){
			String hql = "SELECT COUNT(*) FROM LangBean";
			return executeStatAsInt(hql, null);
		}

	/**
		 * ���ݱ�Ż�ȡ��վ����������Ϣ
		 * @param sid
		 * @return
		 */
		public static LangBean getLangByID(int sid){
			if(sid<1)
				return null;
			return (LangBean)getBean(LangBean.class, sid);
		}

	/**
	 * ���ĳһ���԰汾��վ��Ϣ�Ļ���������Ϣ
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
	 * ��ȡȫ���Ѿ���������վ��Ϣ
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
		 * ���ݻ�����վ���԰汾����ȡ��Ӧ�Ļ�������վ��Ϣ
		 * @param languange
		 * @return
		 */
		public static LangBean getLang(String languange){
			if(languange==null)
				return null;
			return (LangBean)getSession().get(LangBean.class, new String(languange));
			
		}
	
	/**
	 * ���ݻ�����վID����ȡ��Ӧ�Ļ�������վ��Ϣ
	 * @param id
	 * @return
	 */
	public static LangBean getLang(int id){
		if(id < 0)
			return null;
		return (LangBean)getBean(LangBean.class, id);
	}
	
	/**
		 * ����Ĭ�Ϸ���isDefault����ȡ������վ��Ϣ��ȡ��һ����¼
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
	 * �޸Ļ�����վ��Ϣ
	 * @param lang
	 */
	public static void updateLang(LangBean lang){
		flush();
	}
	
	/**
	 * ɾ��������վ������Ϣ
	 * @param lang
	 */
	public static void deleteLang(LangBean lang){
		getSession().delete(lang);
		getSession().flush();
	}
	
	/**
	 * д������վ��Ϣ�����ݿ�
	 * @param pform ������վ������
	 * @param loginUser �û���Ϣ
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
	 * �г����л�����վ��Ϣ
	 * @return
	 */
	public static List getLanglist(){
		String hql = "FROM LangBean AS L ORDER BY L.id ASC";
		return executeQuery(hql, -1, -1, null);
	}
	
	/**
	 * �޸Ļ�����վ������Ĭ����Ϣ
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
