package org.myconf;

import javax.servlet.ServletContext;

import org.myconf.beans.UserBean;
import org.myconf.util.StringUtils;

/**
 * �û����Ϲ���ӿ�
 * @author libin
 */
public class MCUserManager{
	
	private final static String MANAGER_KEY = "user-ext-manager";
	
	private static UserBridge dlog_bridge;
	private static UserBridge ext_bridge;
	
	/**
	 * ��ʼ���û����Ϲ������,������չ�û����Ϲ���ӿ�
	 * @param sContext
	 * @throws Exception
	 */
	public synchronized static void init(ServletContext sContext)
			throws Exception {
		if (dlog_bridge != null)
			return;
		dlog_bridge = new MCUserBridge();
		String ext_mgr_cls = sContext.getInitParameter(MANAGER_KEY);
		if (StringUtils.isEmpty(ext_mgr_cls)
				|| StringUtils.equals(dlog_bridge.getClass().getName(),
						ext_mgr_cls))
			return;
		ext_bridge = (UserBridge) Class.forName(ext_mgr_cls).newInstance();
	}
	
	public static void destroy(){
	}
	
	public static void create(UserBean user){
		if(ext_bridge!=null)
			ext_bridge.create(user);
		dlog_bridge.create(user);
	}

	/**
	 * TODO: ����ͬ�����ߵ�����
	 * @param email
	 * @return
	 */
	public static UserBean getUserByEmail(String email){
		return dlog_bridge.getUserByEmail(email);
	}

	public static void update(UserBean user){
		if(ext_bridge!=null)
			ext_bridge.update(user);
		dlog_bridge.update(user);
	}

	public static void userLogin(UserBean user){
		if(ext_bridge!=null)
			ext_bridge.userLogin(user);
		dlog_bridge.userLogin(user);
	}

	public static void userLogout(SessionUserObject user){
		if(ext_bridge!=null)
			ext_bridge.userLogout(user);
		dlog_bridge.userLogout(user);
	}

}
