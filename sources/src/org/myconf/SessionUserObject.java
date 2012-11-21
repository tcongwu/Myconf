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
 * 记录在会话中的用户基本资料
 * @see org.myconf.beans.UserBean
 * @author libin
 */
public class SessionUserObject extends UserBaseInfo implements HttpSessionBindingListener{

	private final static Log log = LogFactory.getLog(SessionUserObject.class);
	
	/* session 相关的信息,跟bean无关 */
	private String sessionId;

	/**
	 * 从PO对象中复制一份数据，克隆
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
	 * 保存session_id防止某些应用服务器会话实效后无法获取session_id
	 */
	public void valueBound(HttpSessionBindingEvent e) {
		this.sessionId = e.getSession().getId();
	}

	/**
	 * 执行用户注销方法
	 * 由于该方法是由应用服务器调用的，不经过HibernateFilter，因此必须手动关闭Session
	 */
	public void valueUnbound(HttpSessionBindingEvent e) {
		SessionUserObject user = (SessionUserObject)e.getValue();
		if(user != null){
			try{
				UserLoginManager.logoutUser(user);
			}catch(Exception excp){
				log.error("Error when logout user, userid="+user.getId(), excp);
			}
			//此处由于不受HibernateFilter控制，因此需要显式的来关闭数据库资源
			HibernateUtils.closeSession();			
		}
	}

	private String getSessionId() {
		return sessionId;
	}

}
