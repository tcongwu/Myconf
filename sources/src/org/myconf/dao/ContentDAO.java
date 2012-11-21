
package org.myconf.dao;

import java.util.List;

import org.hibernate.Session;
import org.myconf.beans.ContentBean;
import org.myconf.beans.LangBean;
import org.hibernate.Query;


/**
 * ��վ������Ϣ�������ݷ��ʽӿ�
 * 
 */
public class ContentDAO extends DAO{


	/**
		 * ���ݱ�Ż�ȡ��վ������Ϣ
		 * @param sid
		 * @return
		 */
		public static ContentBean getContentByID(int sid){
			if(sid<1)
				return null;
			return (ContentBean)getBean(ContentBean.class, sid);
		}

	/**
	 * ��Ҫע��mysql�����ݿ�����ִ�С���� 
	 * 
	 * ���ĳһ���԰汾��վ����
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
		 * ���ݻ�����վ���԰汾����ȡ��Ӧ�Ļ�����վ������Ϣ
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
	 * ���ݻ�����վID����ȡ��Ӧ�Ļ�������վ��Ϣ
	 * @param id
	 * @return
	 */
	public static ContentBean getContent(int id){
		if(id < 0)
			return null;
		return (ContentBean)getBean(ContentBean.class, id);
	}
	
	/**
	 * �޸Ļ�����վ������Ϣ
	 * @param content
	 */
	public static void updateContent(ContentBean content){
		flush();
	}
	
	/**
		 * ���»�����վ������Ϣ
		 * @param content
		 */
		public static void updateSiteContent(ContentBean content){
			flush();
		}
	/**
	 * ɾ��������վ������Ϣ
	 * @param content
	 */
	public static void deleteContent(ContentBean contetn){
		getSession().delete(contetn);
		getSession().flush();
	}
	
	/**
	 * д������վ������Ϣ�����ݿ�
	 */
	
	
	public static void createContent(ContentBean content){
			if(content==null)
				return;
			save(content);
		}
		
	/**
		 * ���ݷ���published״̬����ȡ������վ������Ϣ��ȡ��һ����¼
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
