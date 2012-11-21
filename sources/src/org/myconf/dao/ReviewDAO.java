package org.myconf.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.myconf.beans.ReviewBean;

/**
 * 稿件评审记录数据访问接口
 * @author libin
 */
public class ReviewDAO extends DAO {
	
	/**
	 * 列出所有专家退审的评审记录
	 * @return 退审列表
	 */
	public static List listQuits(){
		return executeNamedQuery("LIST_QUIT_REVIEW", -1, -1, ReviewBean.REVIEW_STATUS_QUIT);
	}
	
	/**
	 * 计数退审记录
	 * @return
	 */
	public static int countQuits(){
		return executeNamedStat("COUNT_QUIT_REVIEW", ReviewBean.REVIEW_STATUS_QUIT).intValue();
	}
	
	/**
	 * 列出某专家的评审记录
	 * @param expertId 专家ID
	 * @param status 评审记录状态
	 * @return
	 */
	public static List listExpertReviews(int expertId, int status){
		return executeNamedQuery("LIST_EXPERT_REVIEW", -1, -1, expertId, status);
	}

	/**
	 * 增加评审记录
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
	 * 根据指标ID来获取对应的评审记录信息
	 * @param id
	 * @return
	 */
	public static ReviewBean getReview(int id){
		if(id < 0)
			return null;
		return (ReviewBean)getBean(ReviewBean.class, id);
	}
	
	/**
	 * 修改评审信息
	 * @param refer
	 */
	public static void update(ReviewBean review){
		flush();
	}
	
	/**
	 * 获取评审记录的个数
	 * @return
	 */
	public static int getReviewCount(){
		return executeNamedStat("REVIEW_COUNT").intValue();
	}
}
