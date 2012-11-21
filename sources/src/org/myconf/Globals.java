package org.myconf;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.util.MessageResources;
import org.apache.struts.util.MessageResourcesFactory;
import org.myconf.util.StringUtils;

/**
 * MYCONF��ȫ�ֳ�������
 * @author libin
 */
public class Globals {

	public final static String DEFAULT_CONTENT_TYPE = "text/html;charset=UTF-8";
	
	public final static String LOCAL_PATH_PREFIX = "file://";
	
	public final static String SH="��";
	public final static String SPLIT=",";
	
	public final static int PAGESIZE_10 = 10;
	public final static int PAGESIZE_20 = 20;
	
	public final static String ENC_UTF_8 = "UTF-8";
	public final static String ENC_8859_1 = "8859_1";
	public static final String DEFAULT_CHARSET = "UTF-8";
	public static final String DEFAULT_LANGUAGE = "en";

	public final static String RANDOM_LOGIN_KEY = "RANDOM_LOGIN_KEY";
	
	public final static String PARAM_SID = "sid";
	
	public final static String MAIL_QUEUE = "MAIL_QUEUE";

	public final static String USER_AGENT = "user-agent";
	
	public final static String SESSION_ID_KEY_IN_COOKIE = "MYCONF_SESSION_ID";

	public final static String LANGUAGE_SIMPLIFIED = "����";
	public final static String LANGUAGE_TRADITIONAL = "����";
	public final static String LANGUAGE_ENGLISH = "ENGLISH";

	public final static int LANG_SIMPLIFIED = 1;
	public final static int LANG_TRADITIONAL = 2;
	public final static int LANG_ENGLISH = 3;
	
	public final static String TEMPLATE_DEFAUT = "soar";//Ĭ������Ϊ"soar"��ģ��
	
	/**
	 * ���й�����webapp�Լ���������ڵ�·��
	 * ��ActionServletExtend���и�ֵ
	 * @see org.myconf.servlet.ActionServletExtend#init()
	 */
	public static String WEBAPP_PATH ;
	public static String PAPER_ROOT_WEB="/submission/paper";
	public static String PAPER_ROOT;
	
	public static String ROOT=null;
	
	/**
	 * ��ȡ������
	 * 
	 * @return
	 */
	public static String getConfShortName(){
		return "ICWL2001";
	}
	
	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public static String getConfName(){
		return "International Conference 2001";
	}
	
	/**
	 * ���Ӧ�õĻ�����Ŀ¼
	 * @param req
	 * @return
	 */
	public static String root(HttpServletRequest req){
		if(ROOT==null){
			ROOT=req.getContextPath();
			if(ROOT==null)
				ROOT="";
		}
		return ROOT;
	}
	
	/**
	 * ��ָ��·��ת���ɷ��ϵ�ǰӦ�û�����·��
	 * @param req
	 * @param path
	 * @return
	 */
	public static String webPath(HttpServletRequest req, String path){
		if(!StringUtils.isEmpty(path)&&(path.charAt(0)=='/'))
			return root(req)+path;

		return path;
		
	}
	
	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @return
	 */
	public static String getMessage(String bundle, String key) {
		if(key==null)
			return null;
		MessageResources res = MessageResourcesFactory.createFactory().createResources(bundle);
		if(res==null)
			return null;
		return res.getMessage(key);
	}

	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @param param
	 * @return
	 */
	public static String getMessage(String bundle, String key, Object param) {
		if(key==null)
			return null;
		MessageResources res = MessageResourcesFactory.createFactory().createResources(bundle);
		if(res==null)
			return null;
		return res.getMessage(key, param);
	}

	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static String getMessage(String bundle, String key, Object param1, Object param2) {
		if(key==null)
			return null;
		MessageResources res = MessageResourcesFactory.createFactory().createResources(bundle);
		if(res==null)
			return null;
		return res.getMessage(key, param1, param2);
	}

	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @param param1
	 * @param param2
	 * @param param3
	 * @return
	 */
	public static String getMessage(String bundle, String key, Object param1, Object param2, Object param3) {
		if(key==null)
			return null;
		MessageResources res = MessageResourcesFactory.createFactory().createResources(bundle);
		if(res==null)
			return null;
		return res.getMessage(key, param1, param2, param3);
	}

	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @param params
	 * @return
	 */
	public static String getMessage(String bundle, String key, Object[] params) {
		if(key==null)
			return null;
		MessageResources res = MessageResourcesFactory.createFactory().createResources(bundle);
		if(res==null)
			return null;
		return res.getMessage(key, params);
	}

}
