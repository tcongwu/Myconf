package org.myconf;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.myconf.beans.UserBean;
import org.myconf.dao.UserDAO;
import org.myconf.util.RequestUtils;
import org.myconf.util.StringUtils;

/**
 * �û���¼���� ����Cookie��Session��Ͻ����û���¼�Ự���ж� 
 * TODO: ��ֹһ��__ClientIdʹ�ö��
 * 
 * <pre>���㲻����ӵ��ʱ,��Ψһ������,�������Լ���Ҫ����</pre>
 * 
 * @author libin
 */
public class UserLoginManager {

	private final static Log log = LogFactory.getLog(UserLoginManager.class);
	
	/**
	 * �����ύʱ����������ɱ����0.5��������
	 */
	private final static int MIN_MS_BETWEEN_ACTION = 500;

	/**
	 * ������Ч����һ��Сʱ
	 */
	private final static int MAX_MS_BETWEEN_ACTION = 3600000;
	private final static String SESSION_USER_KEY = "MYCONF_USER";
	private final static String COOKIE_LASTLOGIN_KEY = "MYCONF_LL";//last login key
	private final static String COOKIE_UUID_KEY = "myconf_uuid";

	/**
	 * �Զ���¼���ж��û��Ƿ��¼
	 * 
	 * @param request
	 * @param response
	 * @param uuid ����û���Ϣ�Ķ���
	 * @param verify_host �Ƿ��޶��û�ֻ��ʹ��ͬһ�ͻ��˵�¼
	 * @return
	 */
	public static SessionUserObject getLoginUser(HttpServletRequest request,
			HttpServletResponse response, boolean verify_host) {
		// ���session�м�¼��ֱ�Ӵ�session�ж�ȡ������
		Cookie uuidCookie = null;
		HttpSession ssn = request.getSession(false);
		if (ssn != null) {
			SessionUserObject user = (SessionUserObject) ssn
					.getAttribute(SESSION_USER_KEY);
			if (user != null){				
				uuidCookie = getUuidCookie(request);
				//������sessionֵ���ڣ���cookieֵҲ���ڲ���Ч
				//(��Ҫ��Լ�Ⱥ�����£��û���s1ע���ˣ�������������s2ʱ������ʾ��¼״̬)
				if(uuidCookie!=null)
					return user;
				ssn.invalidate();
				return null;
			}
		}
		String uuid = null;
		if(uuidCookie == null)
			uuidCookie = getUuidCookie(request);
		if (uuidCookie != null)
			uuid = uuidCookie.getValue();
		if(StringUtils.isEmpty(uuid))
			return null;
		// session�������û�������ִ���Զ���¼����
		try {
			UUID oUUID = new UUID(uuid);
			String new_host = request.getRemoteAddr();
			if (verify_host && !StringUtils.equals(new_host, oUUID.host))
				return null;
			UserBean user = UserDAO.getUserByID(oUUID.uid);
			// �û�������
			if (user == null || user.getStatus() != UserBean.STATUS_NORMAL
					|| user.getPassword().hashCode() != oUUID.pwdCode) {
				RequestUtils.setCookie(request, response, COOKIE_UUID_KEY, "", 0);
				RequestUtils.setCookie(request, response, COOKIE_LASTLOGIN_KEY, "", 0);
				return null;
			}

			return loginUser(request, response, user);
		} catch (Exception e) {
			log.error("Exception occur when get current user.", e);
		}

		return null;
	}

	/**
	 * �����ѵ�¼�ĻỰ�е��û�����
	 * 
	 * @param req
	 * @param ubean
	 */
	public static void updateLoginUser(HttpServletRequest req, UserBean ubean) {
		HttpSession ssn = req.getSession(true);
		if (ssn != null && ubean != null) {
			ssn.setAttribute(SESSION_USER_KEY, SessionUserObject
					.copyFrom(ubean));
		}
	}

	/**
	 * ���ر����û���¼��Ϣ��Cookie
	 * 
	 * @param request
	 * @return
	 */
	protected static Cookie getUuidCookie(HttpServletRequest request) {
		return RequestUtils.getCookie(request, COOKIE_UUID_KEY);
	}

	/**
	 * ִ���û���¼����
	 * 
	 * @param req
	 * @param res
	 * @param ubean
	 * @param keepDays
	 * @see org.myconf.action.UserAction#doLogin(ActionMapping,
	 *      ActionForm, HttpServletRequest, HttpServletResponse)
	 */
	public static SessionUserObject loginUser(HttpServletRequest req,
			HttpServletResponse res, UserBean ubean) {
		HttpSession ssn = req.getSession(false);
		if (ssn != null) {
			SessionUserObject rub = (SessionUserObject) ssn
					.getAttribute(SESSION_USER_KEY);
			if (rub != null && rub.getId()==ubean.getId()) {
				return rub;
			}
		}
		
		// �����û����������һ�η���ʱ���Լ����ʵ�ַ,ͬʱ��������״̬
		ubean.setLastAddr(req.getRemoteAddr());
		ubean.setLastTime(new Timestamp(System.currentTimeMillis()));
		ubean.setOnlineStatus(1);
		MCUserManager.update(ubean);

		// д��¼��Ϣ��cookie,��ʹ��session�����û�����
		UUID uuid = new UUID();
		uuid.uid = ubean.getId();
		uuid.pwdCode = ubean.getPassword().hashCode();
		uuid.host = req.getRemoteAddr();

		String value = uuid.toString();
		RequestUtils.setCookie(req, res, COOKIE_UUID_KEY, value, -1);
		RequestUtils.setCookie(req, res, COOKIE_LASTLOGIN_KEY, ubean.getLastTime().toString(), -1);
		
		// �û����ϱ�����Session��
		if (ssn == null)
			ssn = req.getSession(true);
		if (ssn != null && ubean != null) {
			ssn.setAttribute(SESSION_USER_KEY, SessionUserObject.copyFrom(ubean));
		}
		return ubean;
	}

	/**
	 * ע���û�
	 * 
	 * @param req
	 * @param res
	 * @see org.myconf.action.UserAction#doLogout(ActionMapping,
	 *      ActionForm, HttpServletRequest, HttpServletResponse, String)
	 */
	public static void logoutUser(HttpServletRequest req,
			HttpServletResponse res) {

		SessionUserObject ubean = getLoginUser(req, res, false);
		if (ubean != null) {
			MCUserManager.userLogout(ubean);
		}

		// ���Cookie
		RequestUtils.setCookie(req, res, COOKIE_UUID_KEY, "", 0);
		RequestUtils.setCookie(req, res, COOKIE_LASTLOGIN_KEY, "", 0);

		// ���session
		HttpSession ssn = req.getSession(false);
		if (ssn != null) {
			ssn.invalidate();
		}
	}

	/**
	 * ע���û�
	 * 
	 * @param userid
	 * @param lastLogin
	 * @see SessionUserObject#valueUnbound(HttpSessionBindingEvent)
	 */
	public static void logoutUser(SessionUserObject user) {
		MCUserManager.userLogout(user);
	}

	/**
	 * ��֤�ͻ��˰�ȫʶ����
	 * 
	 * @param req
	 * @param clientId
	 * @return
	 */
	public static boolean validateClientId(HttpServletRequest req,
			String clientId) {
		return ClientID.validate(req, clientId);
	}

	/**
	 * ���ɿͻ��˰�ȫʶ����
	 * 
	 * @param req
	 * @return
	 */
	public static String generateClientId(HttpServletRequest req,
			HttpServletResponse res) {
		return ClientID.generate(req, res);
	}

	/**
	 * �Զ���¼��ʶ
	 * 
	 * @author liudong
	 */
	private static class UUID {

		/**
		 * �Զ���¼��ʶ�ļ������� IMPORTANT: �����޸ĸ�ֵ�����±���ϵͳ�Ա�֤ϵͳ�İ�ȫ�� ����Կ�ĳ��ȱ�����8��������
		 */
		private final static String UUID_ENCRYPT_KEY = "1M2O3Y4N546C7F83";

		private final static String PATTERN = "{0}_{1}@{2}";

		private final static MessageFormat parser = new MessageFormat(PATTERN);

		public int uid;

		public String host;

		public int pwdCode;

		public UUID() {
		}

		/**
		 * ���л����ַ���
		 */
		public String toString() {
			String uuid = MessageFormat.format(PATTERN, new String[] {
					String.valueOf(uid), String.valueOf(pwdCode), host });
			return StringUtils.encrypt(uuid, UUID_ENCRYPT_KEY);
		}

		/**
		 * ��ԭ
		 * 
		 * @param cookie
		 * @return
		 * @throws ParseException
		 */
		public UUID(String cookie) throws ParseException {
			String uuid = StringUtils.decrypt(cookie, UUID_ENCRYPT_KEY);
			Object[] args = parser.parse(uuid);
			uid = Integer.parseInt((String) args[0]);
			pwdCode = Integer.parseInt((String) args[1]);
			host = (String) args[2];
		}

	}

	/**
	 * �ͻ�����֤��
	 * 
	 * @author liudong
	 */
	private static class ClientID {

		private final static String CLIENTID_ENCRYPT_KEY = "MYCONF0V1";

		private final static String PATTERN = "{0}|{1}|{2}";

		private final static MessageFormat parser = new MessageFormat(PATTERN);

		/**
		 * ���ɿͻ��˰�ȫʶ����
		 * 
		 * @param req
		 * @return
		 */
		public static String generate(HttpServletRequest req,
				HttpServletResponse res) {
			long ct = System.currentTimeMillis();
			String user_agent = RequestUtils.getHeader(req, Globals.USER_AGENT);
			String remote_host = req.getRemoteAddr();
			StringBuffer code = new StringBuffer();
			code.append(ct);
			code.append('|');
			code.append(remote_host);
			code.append('|');
			if (user_agent != null)
				code.append(Math.abs(user_agent.hashCode()));
			else
				code.append(ct);
			return StringUtils.encrypt(code.toString(), CLIENTID_ENCRYPT_KEY);
		}

		/**
		 * ��֤�ͻ��˰�ȫʶ����
		 * 
		 * @param req
		 * @param clientId
		 * @return
		 */
		public static boolean validate(HttpServletRequest req, String clientId) {
			String clientCode = StringUtils.decrypt(clientId,
					CLIENTID_ENCRYPT_KEY);
			try {
				Object[] objs = parser.parse(clientCode);
				String host = req.getRemoteAddr();
				if (host.equals(objs[1])) {
					String user_agent = RequestUtils.getHeader(req,
							Globals.USER_AGENT);
					String ua = (user_agent!=null)?String.valueOf(Math.abs(user_agent.hashCode())):null;
					if (objs[2].equals(ua) || objs[2].equals(objs[0])) {
						long lt = Long.parseLong((String) objs[0]);
						long ct = System.currentTimeMillis();
						// �ͻ���ʶ�������Ч����һ����ͷ
						long it = ct - lt;
						if (MIN_MS_BETWEEN_ACTION < it
								&& it < MAX_MS_BETWEEN_ACTION) {
							return true;
						}
					}
				}
			} catch (ParseException e) {
			}
			return false;
		}

	}
}
