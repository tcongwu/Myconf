package org.myconf.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.myconf.beans.StatusBean;

/**
 * 稿件评审结果状态数据访问接口
 * @author libin
 */
public class StatusDAO extends DAO {
	
	private static Map stats=null;

	/**
	 * 增加评审结果状态
	 * @param status
	 */
	public static boolean save(StatusBean status){
		if(status==null)
			return false;
		
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(status);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		stats=null;
		return true;
	}
	
	/**
	 * 删除评审结果状态
	 * @param id
	 * @return
	 */
	public static boolean delete(int id){
		stats=null;
		return commitNamedUpdate("DELETE_STATUS", id)>0;
	}
	
	/**
	 * 列出所有状态
	 * @return
	 */
	public static List list(){
		return findNamedAll("LIST_STATUS");
	}

	/**
	 * 根据状态ID来获取对应的稿件评审结果状态信息
	 * @param id
	 * @return
	 */
	public static StatusBean getStatus(int id){
		if(id < 0)
			return null;
		return (StatusBean)getBean(StatusBean.class, id);
	}
	
	/**
	 * 修改稿件评审结果状态信息
	 * @param status
	 */
	public static void update(StatusBean status){
		stats=null;
		flush();
	}
	
	/**
	 * 检查是否存在指定的状态
	 * @param sta 状态ID
	 * @return
	 */
	public static boolean containStatus(int sta){
		if(stats==null){
			stats=new Hashtable();
			List ls=findNamedAll("LIST_STATUS");
			if(ls!=null && ls.size()>0){
				StatusBean sb=null;
				for(int i=0;i<ls.size();i++){
					sb=(StatusBean)ls.get(i);
					stats.put(new Integer(sb.getId()), sb.getStatus());
				}
			}
		}
		return stats.containsKey(new Integer(sta));
	}
	
	/**
	 * 根据状态ID取得状态内容
	 * @param sta 状态ID
	 * @return
	 */
	public static String getStatusInMap(int sta){
		if(stats==null){
			stats=new Hashtable();
			List ls=findNamedAll("LIST_STATUS");
			if(ls!=null && ls.size()>0){
				StatusBean sb=null;
				for(int i=0;i<ls.size();i++){
					sb=(StatusBean)ls.get(i);
					stats.put(new Integer(sb.getId()), sb.getStatus());
				}
			}
		}
		return (String)stats.get(new Integer(sta));
	}
	
	/**
	 * 判断ID所代表的评审结果状态是否可以被删除
	 * @param id
	 * @return
	 */
	public static boolean canBeDelete(int id){
		return (executeNamedStatAsInt("CHECK_DELETE_IN_PAPER", id)==0 && executeNamedStatAsInt("CHECK_DELETE_IN_REVIEW", id)==0);
	}
}
