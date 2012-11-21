package org.myconf.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.myconf.beans.LangBean;
import org.myconf.beans.MenuBean;

/**
 * ��������������ݷ��ʽӿ�
 * 
 */
public class MenuDAO extends DAO {


	/**
		 * ���ݱ�Ż�ȡ��վ�˵���Ϣ
		 * @param sid
		 * @return
		 */
		public static MenuBean getMenuByID(int sid){
			if(sid<1)
				return null;
			return (MenuBean)getBean(MenuBean.class, sid);
		}

	
	
	/**
		 * ���ݻ�����վ���԰汾����ȡ��Ӧ�Ļ�����վ�˵���Ϣ
		 * @param languange
		 * @return
		 */
		public static List getContentByLang(LangBean lang){
			if(lang==null)
				return null;
			return (List)getSession().get(MenuBean.class, lang);
			//return (LangBean)getBean(LangBean.class, languange);
		}
	
	/**
	 * ��Ҫע��mysql�����ݿ�����ִ�С���� 
	 * 
	 * ���ĳһ���԰汾��վ�˵�
	 * @param lang
	 * @return
	 */
	public static List getMenuByVersion(LangBean lang){
		Session ssn = getSession();
		String sql=" FROM MenuBean where lang=:lang order by ordering asc";
		Query query = ssn.createQuery(sql);
		query.setParameter("lang",lang);
		List menulist=query.list();
		return menulist;
	}
	
	/**
		 * 
		 * 
		 * ���ĳһ���԰汾��վ�˵�
		 * @param lang
		 * @return
		 */
		public static int getMenuMaxOrding(){
			
			Session ssn = getSession();
			int j=0;
		  Integer	i=new Integer(0);
		  i=(Integer)ssn.createQuery("select max(m.ordering) from MenuBean m ").uniqueResult();
		  if(i!=null)
		  j=i.intValue();
			return j;
		}
	
	
	/**
	 * ���ݻ���˵�ID����ȡ��Ӧ�Ĳ˵���Ϣ
	 * @param id
	 * @return
	 */
	public static MenuBean getMenu(int id){
		if(id < 0)
			return null;
		return (MenuBean)getBean(MenuBean.class, id);
	}
	
	/**
	 * �޸Ļ�����վ�˵���Ϣ
	 * @param menu
	 */
	public static void updateMenu(MenuBean menu){
		flush();
	}
	

	/**
	 * ɾ��������վ�˵���Ϣ
	 * @param menu
	 */
	public static void deleteMenu(MenuBean menu){
		getSession().delete(menu);
		getSession().flush();
	}
	
	/**
	 * д������վ�˵���Ϣ�����ݿ�
	 */
	
	
	public static void createMenu(MenuBean menu){
			if(menu==null)
				return;
			save(menu);
		}
		
	
	/**
	 * �������˵�
	 * @param menu
	 */
	public static void UpDownMenu(int id,int orderid){
		MenuBean m1=(MenuBean) getSession().get(MenuBean.class,new Integer(id));
		m1.setOrdering(orderid);
	  getSession().update(m1);
		getSession().flush();
	

		
	}
}
