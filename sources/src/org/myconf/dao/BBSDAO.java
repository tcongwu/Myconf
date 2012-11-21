package org.myconf.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.myconf.Page;
import org.myconf.beans.BBSBean;

/**
 * 讨论区信息数据操作接口，任何与讨论有关的数据操作都通过此类完成。
 * 用于封装对BBSBean类的访问，
 * 也就是Myconf_BBSInfo表的访问
 * @author Lee Bin
 */
public class BBSDAO extends DAO {

	/**
	 * 默认的构造函数
	 */
  public BBSDAO() {
	}
	
	/**
	 * 获取讨论信息列表(整个会议就一个讨论区)
	 * @param curPage 当前页面
	 * @param pageSize	分页大小
	 * @param status 讨论的状态
	 * @return 页面对象（含分页信息和当前页面的数据记录）
	 */
	public static Page getPageDiscuss(int curPage, int pageSize, int status) {
		
		String hql = "FROM BBSBean AS b WHERE b.parentId=0 AND b.status=:status ORDER BY b.isTop, b.id desc";

		Session ssn = getSession();
		Query q = ssn.createQuery(hql);
		q.setInteger("status", status);
		
		return new Page(q.list(), curPage, pageSize);
	}
	
	/**
	 * 获取有效讨论信息列表
	 * @param curPage 当前页面
	 * @param pageSize	分页大小
	 * @return 页面对象（含分页信息和当前页面的数据记录）
	 */
	public static Page getPageDiscuss(int curPage, int pageSize) {
		return getPageDiscuss(curPage, pageSize, BBSBean.STATUS_NORMAL);
	}
	
	/**
	 * 获取某起讨论
	 * @param id 主讨论ID
	 * @return 讨论列表
	 */
	public static List getDiscuss(int id) throws SQLException {
		if(id==0){
			return null;
		}
		
		String hql = "FROM BBSBean AS b WHERE b.id=:id OR b.parentId=:id ORDER BY b.id";
		Session ssn = getSession();
		Query q = ssn.createQuery(hql);
		q.setInteger("id", id);
		
		List ls=q.list();
		if(ls!=null && ls.size()>0){
			BBSBean mbean=(BBSBean)ls.get(0);
			mbean.setVisitCount(mbean.getVisitCount()+1);
			flush();
		}
		
		return ls;
	}

	/**
	 * 增加讨论或回复
	 * @param sub
	 */
	public static boolean save(BBSBean bbs){
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(bbs);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		return true;
	}

	/**
	 * 根据讨论ID来获取对应的讨论信息
	 * @param id
	 * @return
	 */
	public static BBSBean getBBS(int id){
		if(id < 0)
			return null;
		return (BBSBean)getBean(BBSBean.class, id);
	}
	
	/**
	 * 修改讨论信息
	 * @param bbs
	 */
	public static void update(BBSBean bbs){
		flush();
	}
	
	/**
	 * 删除讨论
	 * @param id
	 * @return
	 */
	public static boolean delete(int id){
		return commitNamedUpdate("DELETE_BBS", id, id)>0;
	}
}