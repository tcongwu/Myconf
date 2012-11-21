package org.myconf.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.myconf.beans.BidBean;

/**
 * ר�Ҿ���������ݷ��ʽӿ�
 * @author libin
 */
public class BidDAO extends DAO {

	/**
	 * ����ר�Ҿ�����¼
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
	 * ���ݸ��ID��ר��ID��ȡ��Ӧ�ľ�����¼
	 * @param pid ���ID
	 * @param eid ר��ID
	 * @return ������¼
	 */
	public static BidBean getBid(int pid, int eid) {
		return (BidBean)namedUniqueResult("BID_BY_IE", pid, eid);
	}
}
