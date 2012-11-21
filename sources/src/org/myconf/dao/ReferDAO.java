package org.myconf.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.myconf.beans.ReferBean;

/**
 * �������ָ�����ݷ��ʽӿ�
 * @author libin
 */
public class ReferDAO extends DAO {

	/**
	 * ����ָ��
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
	 * ɾ��ָ��
	 * @param id
	 * @return
	 */
	public static boolean delete(int id){
		return commitNamedUpdate("DELETE_REFER", id)>0;
	}
	
	/**
	 * �г���������ָ��
	 * @return
	 */
	public static List list(){
		return findNamedAll("LIST_REFER");
	}

	/**
	 * ����ָ��ID����ȡ��Ӧ������ָ����Ϣ
	 * @param id
	 * @return
	 */
	public static ReferBean getRefer(int id){
		if(id < 0)
			return null;
		return (ReferBean)getBean(ReferBean.class, id);
	}
	
	/**
	 * �޸�ָ����Ϣ
	 * @param refer
	 */
	public static void update(ReferBean refer){
		flush();
	}
	
	/**
	 * ��ȡ�Ѷ��������ָ�����
	 * @return
	 */
	public static int getReferCount(){
		return executeNamedStat("REFER_COUNT").intValue();
	}
	
	/**
	 * �ж��Ƿ����ָ�����
	 * @param referNo ָ�����
	 * @return
	 */
	public static boolean isExist(int referNo){
		return executeNamedStat("CHECK_REFERNO", referNo).intValue()>0;
	}
}
