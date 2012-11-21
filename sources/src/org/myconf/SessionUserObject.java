package org.myconf;

import java.sql.Timestamp;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.myconf.beans.base.NameInfo;
import org.myconf.beans.UserBaseInfo;
import org.myconf.beans.UserBean;
import org.myconf.db.HibernateUtils;

/**
 * ��¼�ڻỰ�е��û���������
 * @see org.myconf.beans.UserBean
 * @author libin
 */
public class SessionUserObject extends UserBaseInfo implements HttpSessionBindingListener{

	private final static Log log = LogFactory.getLog(SessionUserObject.class);
	
	/* session ��ص���Ϣ,��bean�޹� */
	private String sessionId;

	/**
	 * ��PO�����и���һ�����ݣ���¡
	 * @param bean
	 * @return
	 */
	public static SessionUserObject copyFrom(UserBean bean){
		if(bean==null)
			return null;
		
		SessionUserObject user = new SessionUserObject();
		user.setId(bean.getId());
		
		user.setEmail(bean.getEmail());
		
		if(bean.getName()!=null)
			user.setName((NameInfo)bean.getName().clone());
		
		user.setWorkLocation(bean.getWorkLocation());
		user.setResearch(bean.getResearch());
		user.setPhone(bean.getPhone());
		user.setFax(bean.getFax());
		user.setAddress(bean.getAddress());
		user.setPostcode(bean.getPostcode());
		user.setState(bean.getState());
		user.setCountry(bean.getCountry());
		
		user.setIsAdmin(bean.getIsAdmin());
		user.setIsAuthor(bean.getIsAuthor());
		user.setIsContent(bean.getIsContent());
		user.setIsExpert(bean.getIsExpert());
		
		user.setRole(bean.getRole());
		user.setStatus(bean.getStatus());
		
		user.setLoginCount(bean.getLoginCount());
		if(bean.getRegTime()!=null)
			user.setRegTime(new Timestamp(bean.getRegTime().getTime()));
		if(bean.getLastTime()!=null)
			user.setLastTime(new Timestamp(bean.getLastTime().getTime()));
		user.setLastAddr(bean.getLastAddr());

		return user;
	}
	
	/**
	 * ����session_id��ֹĳЩӦ�÷������ỰʵЧ���޷���ȡsession_id
	 */
	public void valueBound(HttpSessionBindingEvent e) {
		this.sessionId = e.getSession().getId();
	}

	/**
	 * ִ���û�ע������
	 * ���ڸ÷�������Ӧ�÷��������õģ�������HibernateFilter����˱����ֶ��ر�Session
	 */
	public void valueUnbound(HttpSessionBindingEvent e) {
		SessionUserObject user = (SessionUserObject)e.getValue();
		if(user != null){
			try{
				UserLoginManager.logoutUser(user);
			}catch(Exception excp){
				log.error("Error when logout user, userid="+user.getId(), excp);
			}
			//�˴����ڲ���HibernateFilter���ƣ������Ҫ��ʽ�����ر����ݿ���Դ
			HibernateUtils.closeSession();			
		}
	}

	private String getSessionId() {
		return sessionId;
	}

}
