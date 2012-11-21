package org.myconf;

import org.myconf.beans.UserBean;

/**
 * 用户资料管理接口
 * 用户注册/登录/资料修改等都是通过该接口进行
 * 该接口用户扩展跟其他系统的用户数据同步功能
 * @author libin
 */
public interface UserBridge {
	
	/**
	 * 添加一个用户
	 * @param user
	 * @throws Exception
	 */
	public void create(final UserBean user);
	
	/**
	 * 更新用户资料
	 * @param user
	 * @throws Exception
	 */
	public void update(final UserBean user);
	
	/**
	 * 通过用户名来获取用户资料
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public UserBean getUserByEmail(final String email);
	
	/**
	 * 用户登录后触发该方法
	 * @param user
	 * @throws Exception
	 */
	public void userLogin(final UserBean user);
	
	/**
	 * 用户退出登录后触发该方法
	 * @param user
	 * @throws Exception
	 */
	public void userLogout(final SessionUserObject user);

}
