package org.myconf.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.myconf.beans.ReviewBean;

/**
 * ��������¼���ݷ��ʽӿ�
 * @author libin
 */
public class ReviewDAO extends DAO {
	
	/**
	 * �г�����ר������������¼
	 * @return �����б�
	 */
	public static List listQuits(){
		return executeNamedQuery("LIST_QUIT_REVIEW", -1, -1, ReviewBean.REVIEW_STATUS_QUIT);
	}
	
	/**
	 * ���������¼
	 * @return
	 */
	public static int countQuits(){
		return executeNamedStat("COUNT_QUIT_REVIEW", ReviewBean.REVIEW_STATUS_QUIT).intValue();
	}
	
	/**
	 * �г�ĳר�ҵ������¼
	 * @param expertId ר��ID
	 * @param status �����¼״̬
	 * @return
	 */
	public static List listExpertReviews(int expertId, int status){
		return executeNamedQuery("LIST_EXPERT_REVIEW", -1, -1, expertId, status);
	}

	/**
	 * ���������¼
	 * @param review
	 */
	public static boolean save(ReviewBean review){
		if(review==null)
			return false;
		
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(review);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		return true;
	}

	/**
	 * ����ָ��ID����ȡ��Ӧ�������¼��Ϣ
	 * @param id
	 * @return
	 */
	public static ReviewBean getReview(int id){
		if(id < 0)
			return null;
		return (ReviewBean)getBean(ReviewBean.class, id);
	}
	
	/**
	 * �޸�������Ϣ
	 * @param refer
	 */
	public static void update(ReviewBean review){
		flush();
	}
	
	/**
	 * ��ȡ�����¼�ĸ���
	 * @return
	 */
	public static int getReviewCount(){
		return executeNamedStat("REVIEW_COUNT").intValue();
	}
}
