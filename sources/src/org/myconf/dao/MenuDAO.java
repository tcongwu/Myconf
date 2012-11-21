package org.myconf.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.myconf.beans.LangBean;
import org.myconf.beans.MenuBean;

/**
 * 稿件所属主题数据访问接口
 * 
 */
public class MenuDAO extends DAO {


	/**
		 * 根据编号获取网站菜单信息
		 * @param sid
		 * @return
		 */
		public static MenuBean getMenuByID(int sid){
			if(sid<1)
				return null;
			return (MenuBean)getBean(MenuBean.class, sid);
		}

	
	
	/**
		 * 根据会议网站语言版本来获取对应的会议网站菜单信息
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
	 * 需要注意mysql的数据库表区分大小问题 
	 * 
	 * 获得某一语言版本网站菜单
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
		 * 获得某一语言版本网站菜单
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
	 * 根据会议菜单ID来获取对应的菜单信息
	 * @param id
	 * @return
	 */
	public static MenuBean getMenu(int id){
		if(id < 0)
			return null;
		return (MenuBean)getBean(MenuBean.class, id);
	}
	
	/**
	 * 修改会议网站菜单信息
	 * @param menu
	 */
	public static void updateMenu(MenuBean menu){
		flush();
	}
	

	/**
	 * 删除会议网站菜单信息
	 * @param menu
	 */
	public static void deleteMenu(MenuBean menu){
		getSession().delete(menu);
		getSession().flush();
	}
	
	/**
	 * 写会议网站菜单信息到数据库
	 */
	
	
	public static void createMenu(MenuBean menu){
			if(menu==null)
				return;
			save(menu);
		}
		
	
	/**
	 * 排序会议菜单
	 * @param menu
	 */
	public static void UpDownMenu(int id,int orderid){
		MenuBean m1=(MenuBean) getSession().get(MenuBean.class,new Integer(id));
		m1.setOrdering(orderid);
	  getSession().update(m1);
		getSession().flush();
	

		
	}
}
