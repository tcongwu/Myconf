package org.myconf.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.myconf.Page;
import org.myconf.beans.BBSBean;

/**
 * ��������Ϣ���ݲ����ӿڣ��κ��������йص����ݲ�����ͨ��������ɡ�
 * ���ڷ�װ��BBSBean��ķ��ʣ�
 * Ҳ����Myconf_BBSInfo��ķ���
 * @author Lee Bin
 */
public class BBSDAO extends DAO {

	/**
	 * Ĭ�ϵĹ��캯��
	 */
  public BBSDAO() {
	}
	
	/**
	 * ��ȡ������Ϣ�б�(���������һ��������)
	 * @param curPage ��ǰҳ��
	 * @param pageSize	��ҳ��С
	 * @param status ���۵�״̬
	 * @return ҳ����󣨺���ҳ��Ϣ�͵�ǰҳ������ݼ�¼��
	 */
	public static Page getPageDiscuss(int curPage, int pageSize, int status) {
		
		String hql = "FROM BBSBean AS b WHERE b.parentId=0 AND b.status=:status ORDER BY b.isTop, b.id desc";

		Session ssn = getSession();
		Query q = ssn.createQuery(hql);
		q.setInteger("status", status);
		
		return new Page(q.list(), curPage, pageSize);
	}
	
	/**
	 * ��ȡ��Ч������Ϣ�б�
	 * @param curPage ��ǰҳ��
	 * @param pageSize	��ҳ��С
	 * @return ҳ����󣨺���ҳ��Ϣ�͵�ǰҳ������ݼ�¼��
	 */
	public static Page getPageDiscuss(int curPage, int pageSize) {
		return getPageDiscuss(curPage, pageSize, BBSBean.STATUS_NORMAL);
	}
	
	/**
	 * ��ȡĳ������
	 * @param id ������ID
	 * @return �����б�
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
	 * �������ۻ�ظ�
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
	 * ��������ID����ȡ��Ӧ��������Ϣ
	 * @param id
	 * @return
	 */
	public static BBSBean getBBS(int id){
		if(id < 0)
			return null;
		return (BBSBean)getBean(BBSBean.class, id);
	}
	
	/**
	 * �޸�������Ϣ
	 * @param bbs
	 */
	public static void update(BBSBean bbs){
		flush();
	}
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public static boolean delete(int id){
		return commitNamedUpdate("DELETE_BBS", id, id)>0;
	}
}