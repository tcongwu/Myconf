package org.myconf;

import org.myconf.beans.UserBean;
import org.myconf.dao.UserDAO;

/**
 * 对用户资料管理接口的实现
 * @author libin
 */
public class MCUserBridge implements UserBridge {

	/* (non-Javadoc)
	 * @see org.myconf.UserBridge#create(org.myconf.beans.UserBean)
	 */
	public void create(UserBean user) {
		UserDAO.createUser(user);		
	}

	/* (non-Javadoc)
	 * @see org.myconf.UserBridge#getUserByName(java.lang.String)
	 */
	public UserBean getUserByEmail(String email){
		return UserDAO.getUserByEmail(email);
	}

	/* (non-Javadoc)
	 * @see org.myconf.UserBridge#update(org.myconf.beans.UserBean)
	 */
	public void update(UserBean user) {
		UserDAO.updateUser(user);
	}

	/* (non-Javadoc)
	 * @see org.myconf.UserBridge#userLogin(com.liusoft.dlog4j.beans.UserBean)
	 */
	public void userLogin(UserBean user) {
		UserDAO.flush();
	}

	/* (non-Javadoc)
	 * @see org.myconf.UserBridge#userLogout(org.myconf.beans.UserBean)
	 */
	public void userLogout(SessionUserObject user) {
		UserDAO.userLogout(user.getId(), user.getLastTime());
	}

}
