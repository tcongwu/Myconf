package org.myconf.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.myconf.beans.SubjectBean;

/**
 * ��������������ݷ��ʽӿ�
 * @author libin
 */
public class SubjectDAO extends DAO {

	/**
	 * ��������
	 * @param sub
	 */
	public static boolean save(SubjectBean sub){
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(sub);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		return true;
	}
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public static boolean delete(int id){
		return commitNamedUpdate("DELETE_SUBJECT", id)>0;
	}
	
	/**
	 * �г���������
	 * @return
	 */
	public static List list(){
		return findNamedAll("LIST_SUBJECT");
	}
	
	/**
	 * �����������������б�
	 * @return
	 */
	public static List listSubject(){
		List ls=findNamedAll("LIST_SUBJECT");
		if(ls!=null && ls.size()>0){
			List re=new ArrayList();
			SubjectBean sub=null;
			for(int i=0;i<ls.size();i++){
				sub=(SubjectBean)ls.get(i);
				re.add(sub.getSubject());
			}
			return re;
		}
		return null;
	}

	/**
	 * ��������ID����ȡ��Ӧ�ĸ������������Ϣ
	 * @param id
	 * @return
	 */
	public static SubjectBean getSubject(int id){
		if(id < 0)
			return null;
		return (SubjectBean)getBean(SubjectBean.class, id);
	}
	
	/**
	 * �޸ĸ������������Ϣ
	 * @param sub
	 */
	public static void update(SubjectBean sub){
		flush();
	}
	
	/**
	 * �ж��Ƿ����ɾ������
	 * @param id �����ID
	 * @return
	 */
	public static boolean isDelete(int id){
		return executeNamedStat("CHECK_DELETE_OF_SUBJECT", id).intValue()==0;
	}
}
