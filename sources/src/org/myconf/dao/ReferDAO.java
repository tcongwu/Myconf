package org.myconf.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.myconf.beans.ReferBean;

/**
 * 稿件评审指标数据访问接口
 * @author libin
 */
public class ReferDAO extends DAO {

	/**
	 * 增加指标
	 * @param refer
	 */
	public static boolean save(ReferBean refer){
		if(refer==null)
			return false;
		
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(refer);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		return true;
	}
	
	/**
	 * 删除指标
	 * @param id
	 * @return
	 */
	public static boolean delete(int id){
		return commitNamedUpdate("DELETE_REFER", id)>0;
	}
	
	/**
	 * 列出所有评审指标
	 * @return
	 */
	public static List list(){
		return findNamedAll("LIST_REFER");
	}

	/**
	 * 根据指标ID来获取对应的评审指标信息
	 * @param id
	 * @return
	 */
	public static ReferBean getRefer(int id){
		if(id < 0)
			return null;
		return (ReferBean)getBean(ReferBean.class, id);
	}
	
	/**
	 * 修改指标信息
	 * @param refer
	 */
	public static void update(ReferBean refer){
		flush();
	}
	
	/**
	 * 获取已定义的评审指标个数
	 * @return
	 */
	public static int getReferCount(){
		return executeNamedStat("REFER_COUNT").intValue();
	}
	
	/**
	 * 判断是否存在指标序号
	 * @param referNo 指标序号
	 * @return
	 */
	public static boolean isExist(int referNo){
		return executeNamedStat("CHECK_REFERNO", referNo).intValue()>0;
	}
}
