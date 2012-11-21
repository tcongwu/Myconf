package org.myconf.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.myconf.beans.BidBean;

/**
 * 专家竞评稿件数据访问接口
 * @author libin
 */
public class BidDAO extends DAO {

	/**
	 * 增加专家竞评记录
	 * @param bid
	 */
	public static boolean save(BidBean bid){
		if(bid==null)
			return false;
		
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(bid);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		return true;
	}
	
	/**
	 * 根据稿件ID和专家ID获取相应的竟评记录
	 * @param pid 稿件ID
	 * @param eid 专家ID
	 * @return 竟评记录
	 */
	public static BidBean getBid(int pid, int eid) {
		return (BidBean)namedUniqueResult("BID_BY_IE", pid, eid);
	}
}
