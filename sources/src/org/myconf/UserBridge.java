package org.myconf;

import org.myconf.beans.UserBean;

/**
 * �û����Ϲ���ӿ�
 * �û�ע��/��¼/�����޸ĵȶ���ͨ���ýӿڽ���
 * �ýӿ��û���չ������ϵͳ���û�����ͬ������
 * @author libin
 */
public interface UserBridge {
	
	/**
	 * ���һ���û�
	 * @param user
	 * @throws Exception
	 */
	public void create(final UserBean user);
	
	/**
	 * �����û�����
	 * @param user
	 * @throws Exception
	 */
	public void update(final UserBean user);
	
	/**
	 * ͨ���û�������ȡ�û�����
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public UserBean getUserByEmail(final String email);
	
	/**
	 * �û���¼�󴥷��÷���
	 * @param user
	 * @throws Exception
	 */
	public void userLogin(final UserBean user);
	
	/**
	 * �û��˳���¼�󴥷��÷���
	 * @param user
	 * @throws Exception
	 */
	public void userLogout(final SessionUserObject user);

}
