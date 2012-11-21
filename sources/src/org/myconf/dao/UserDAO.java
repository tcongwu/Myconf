package org.myconf.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.myconf.Page;
import org.myconf.beans.UserBean;
import org.myconf.util.RequestUtils;
import org.myconf.util.StringUtils;

/**
 * �û���ص����ݿ���ʽӿ�
 * @author libin
 */
public class UserDAO extends DAO {
	
	/**
	 * ��ѯ�����������û�(user.jsp)
	 * @param request
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public static Page queryUser(HttpServletRequest request, int curPage, int pageSize){
		int role=RequestUtils.getParam(request, "role", 0);
		String keyword=RequestUtils.getParam(request, "keyword", null);
		
		StringBuffer hql = new StringBuffer("FROM UserBean AS u WHERE u.status=:status");
		if(role==UserBean.ROLE_AUTHOR){
			hql.append(" AND u.isAuthor=:role");
		}else
		if(role==UserBean.ROLE_CONTENT){
			hql.append(" AND u.isContent=:role");
		}else
		if(role==UserBean.ROLE_EXPERT){
			hql.append(" AND u.isExpert=:role");
		}else
		if(role==UserBean.ROLE_ADMIN){
			hql.append(" AND u.isAdmin=:role");
		}
		if(StringUtils.isNotEmpty(keyword)){
			hql.append(" AND (u.realName LIKE :keyword OR u.workLocation LIKE :keyword OR u.country LIKE :keyword)");
		}
		hql.append(" ORDER BY u.id");
		Session ssn = getSession();
		Query q = ssn.createQuery(hql.toString());
		q.setInteger("status", UserBean.STATUS_NORMAL);
		if(role==UserBean.ROLE_AUTHOR || role==UserBean.ROLE_CONTENT || role==UserBean.ROLE_EXPERT || role==UserBean.ROLE_ADMIN){
			q.setInteger("role", UserBean.TRUE);
		}
		if(StringUtils.isNotEmpty(keyword)){
			q.setString("keyword", '%'+keyword+'%');
		}
		
		return new Page(q.list(), curPage, pageSize);
	}
	
	/**
	 * �����Ƿ���Ч���г��û�(usercycle.jsp)
	 * @param isNorm
	 * @return
	 */
	public static List queryUser(boolean isNorm){
		
		StringBuffer hql = new StringBuffer("FROM UserBean AS u WHERE u.status=:status ORDER BY u.id");
		Session ssn = getSession();
		Query q = ssn.createQuery(hql.toString());
		if(isNorm)
			q.setInteger("status", UserBean.STATUS_NORMAL);
		else
			q.setInteger("status", UserBean.STATUS_FORBIDDEN);
		
		return q.list();
	}
	
	/**
	 * ������վ��ע���û���
	 * @return
	 */
	public static int getUserCount(){
		String hql = "SELECT COUNT(*) FROM UserBean d WHERE d.status=?";
		return executeStatAsInt(hql, UserBean.STATUS_NORMAL);
	}
	
	/**
	 * ������վ��Ͷ���û���
	 * @return
	 */
	public static int getAuthorCount(){
		String hql = "SELECT COUNT(*) FROM UserBean d WHERE d.status=? AND d.isAuthor=?";
		return executeStatAsInt(hql, UserBean.STATUS_NORMAL, UserBean.TRUE);
	}
	
	/**
	 * ��ѯ�����û�
	 * @param fromIdx
	 * @param count
	 * @return
	 */
	public static List listOnlineUsers(int fromIdx, int count){
		return executeNamedQuery("ONLINE_USERS", fromIdx, count, UserBean.STATUS_ONLINE);
	}
	
	/**
	 * ��ѯ�����û���
	 * @return
	 */
	public static int getOnlineUserCount(){
		return executeNamedStat("ONLINE_USER_COUNT", UserBean.STATUS_ONLINE).intValue();
	}
	
	/**
	 * ɾ�������˵ĺ��ѹ�ϵ
	 * @param ownerId
	 * @param friendId
	 */
	public static int deleteFriend(int ownerId, String[] friendIds){
		if(friendIds == null|| friendIds.length == 0)
			return 0;
		StringBuffer hql = new StringBuffer("DELETE FROM FriendBean f WHERE f.owner=? AND f.friend.id IN (");
		for(int i=0;i<friendIds.length;i++){
			hql.append("?,");
		}
		hql.append("?)");
		Session ssn = getSession();
		try{
			beginTransaction();
			Query q = ssn.createQuery(hql.toString());
			q.setInteger(0, ownerId);
			int i=0;
			for(;i<friendIds.length;i++){
				String s_id = (String)friendIds[i];
				int id = -1;
				try{
					id = Integer.parseInt(s_id);
				}catch(Exception e){}
				q.setInteger(i+1, id);
			}
			q.setInteger(i+1, -1);
			int er = q.executeUpdate();
			commit();
			return er;
		}catch(HibernateException e){
			rollback();
			throw e;
		}
	}
	
	/**
	 * ����ĳ��վ��ע���û�
	 * @param site
	 * @param searchKey
	 * @return
	 */
	public static List searchUser(String searchKey){
		String key = '%' + searchKey + '%';
		return executeNamedQuery("SEARCH_USER", -1, 20, new Object[]{key, key, key, key});
	}
	
	/**
	 * �������û�
	 * @param user
	 * @param commit
	 * @return
	 */
	public static boolean createUser(UserBean user){
		if(user == null) 
			return false;
		save(user);
		return true;
	}
	
	/**
	 * �г�����վ��ע����û�
	 * @param fromIdx
	 * @param count
	 * @return
	 */
	public static List listUsers(int fromIdx, int count){
		return executeNamedQuery("LIST_REGUSERS_OF_SITE", fromIdx, count);
	}

	/**
	 * �г���ĳ����վ��ע����û���
	 * @return
	 */
	public static int getUserCountFromSite(){
		return executeNamedStat("REGUSER_COUNT_OF_SITE").intValue();
	}
	
	/**
	 * �����û�����
	 * @param user
	 * @param commit
	 * @throws HibernateException
	 */
	public static void updateUser(UserBean user){
		flush();
	}

	/**
	 * �û�ע��
	 * @param userid
	 * @param lastLogin ���һ�ε�¼��ʱ��
	 * @return
	 */
	public static int userLogout(int userid, Timestamp lastLogin){
		Session ssn = getSession();
		if(ssn == null)
			return -1;
		try{
			beginTransaction();
			Query q = ssn.getNamedQuery("USER_LOGOUT");
			q.setInteger("online_status", UserBean.STATUS_OFFLINE);
			q.setInteger("user_id", userid);
			q.setTimestamp("last_time", lastLogin);
			int er = q.executeUpdate();
			commit();
			return er;
		}catch(HibernateException e){
			rollback();
			throw e;
		}
	}
	
	/**
	 * �����û���Ż�ȡ�û���ϸ��Ϣ
	 * @param user_id
	 * @return
	 * @throws HibernateException
	 */
	public static UserBean getUserByID(int user_id){
		if(user_id < 0)
			return null;
		return (UserBean)getBean(UserBean.class, user_id);
	}
	
	/**
	 * �����û���email�����û�����,�����û��ĵ�¼
	 * @param email
	 * @return
	 * @throws HibernateException
	 */
	public static UserBean getUserByEmail(String email){
		return (UserBean)namedUniqueResult("GET_USER_BY_EMAIL", email);
	}
	
	/**
	 * �г�����ר��
	 * @return ר���б�
	 */
	public static List listExperts(){
		return executeNamedQuery("LIST_EXPERT", -1, -1, UserBean.TRUE, UserBean.STATUS_NORMAL);
	}
	
}
