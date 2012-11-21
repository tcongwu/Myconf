package org.myconf.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.myconf.Globals;
import org.myconf.util.StringUtils;

/**
 * ʵ��Struts�Ĺ�����չ
 * @author liudong
 */
abstract class ActionExtend extends Action {

	public final static String METHOD_IDENT_PARAM = "__method";
	private final static Log log = LogFactory.getLog(ActionExtend.class);
	
	/**
	 * ִ��ǰ׼��
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	protected ActionForward beforeExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		return null;
	}

	/**
	 * ִ�к�
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	protected void afterExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
	}

	/**
	 * �����Ƿ񽫱�����ӳ�䵽Action���������<br/> ������Ը��Ǹ÷����������Զ�ӳ�书�� <br/>
	 * ���黹��ʹ��Struts��Formbean���������ģʽ<br/>
	 * 
	 * @param method
	 * @return
	 */
	protected boolean paramMapping(String method) {
		return false;
	}

	/**
	 * Action�����ڣ����ڸ��ݲ�ͬ���ύ��ť����ִ�����Ӧ�ķ��� 
	 * ��ť��������eventSubmit_Xxxx����Ӧִ�еķ�����doXxxx
	 */
	public final ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		ActionForward af = beforeExecute(mapping, form, req, res);
		if(af != null)
			return af;
		
		String param = null;
		String value = null;
		
		String __method = req.getParameter(METHOD_IDENT_PARAM);
		if(StringUtils.isNotBlank(__method)){
			param = METHOD_PREFIX + __method;
		}
		else{
			for (Enumeration params = req.getParameterNames(); params
					.hasMoreElements();) {
				String t_param = (String) params.nextElement();
				if (t_param.startsWith(SUBMIT_BUTTON_PREFIX)) {
					value = req.getParameter(t_param);
					param = METHOD_PREFIX
							+ t_param.substring(SUBMIT_BUTTON_PREFIX.length());
					break;
				}
			}
		}

		if (param == null)
			param = "doDefault";

		try {
			return callActionMethod(mapping, form, req, res, param, value);
		} catch (InvocationTargetException e) {
			Throwable t = e.getCause();
			if(t instanceof IllegalAccessException){
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			log.error("Exception occur when calling "+param+" in action:" + getClass().getName(), t);
			if (t instanceof Exception)
				throw (Exception) t;
			else
				throw new Exception(t);
		} catch (NoSuchMethodException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
			return null;
		} finally{
			afterExecute(mapping,form,req,res);
		}
	}
	
	/**
	 * Ĭ�ϵ�ִ�з���
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doDefault(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception{
		res.sendError(HttpServletResponse.SC_NOT_FOUND, "METHOD NOT FOUND.");
		return null;
	}

	/**
	 * �����¼�������
	 * 
	 * @param mapping
	 * @param form
	 * @param req
	 * @param res
	 * @param methodName
	 * @param value
	 * @return
	 * @throws Exception
	 */
	private ActionForward callActionMethod(ActionMapping mapping,
			ActionForm form, HttpServletRequest req, HttpServletResponse res,
			String methodName, String value) throws Exception {
		Method doMethod = null;
		Object params[] = (Object[]) null;

		for (int i = 0; i < methodParams.length; i++) {
			try {
				doMethod = getClass().getDeclaredMethod(methodName,
						methodParams[i]);
				if (doMethod == null)
					continue;
				Class[] param_classes = doMethod.getParameterTypes();
				if (param_classes.length == 4)
					params = new Object[] { mapping, form, req, res };
				else
					params = new Object[] { mapping, form, req, res, value };
				break;
			} catch (NoSuchMethodException excp) {
			}
		}

		if (doMethod != null) {
			if (paramMapping(doMethod.getName()))
				BeanUtils.populate(this, req.getParameterMap());

			Object ret = doMethod.invoke(this, params);
			
			Class returnType = doMethod.getReturnType();

			if (returnType.equals(ActionForward.class))
				return (ActionForward) ret;

			if (returnType.equals(String.class))
				return new ActionForward((String) ret, true);
			
			if (returnType.equals(void.class)||returnType.equals(Void.class))
				return null;
			
			throw new UnsupportedReturnTypeException(ret.getClass().getName());
		}

		throw new NoSuchMethodException(getClass().getName()+":"+methodName);
	}

	protected final static String SUBMIT_BUTTON_PREFIX = "eventSubmit_";

	protected final static String METHOD_PREFIX = "do";

	private final static Class method1Params[];
	private final static Class method2Params[];
	private final static Class methodParams[][];

	static {
		method1Params = (new Class[] {
				org.apache.struts.action.ActionMapping.class,
				org.apache.struts.action.ActionForm.class,
				javax.servlet.http.HttpServletRequest.class,
				javax.servlet.http.HttpServletResponse.class });
		method2Params = (new Class[] {
				org.apache.struts.action.ActionMapping.class,
				org.apache.struts.action.ActionForm.class,
				javax.servlet.http.HttpServletRequest.class,
				javax.servlet.http.HttpServletResponse.class,
				java.lang.String.class });
		methodParams = (new Class[][] { method1Params, method2Params});
	}
	
	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @return
	 */
    protected String getMessage(String bundle, String key) {
			return Globals.getMessage(bundle, key);
    }

	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @param param
	 * @return
	 */
    protected String getMessage(String bundle, String key, Object param) {
			return Globals.getMessage(bundle, key, param);
    }

	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @param param1
	 * @param param2
	 * @return
	 */
    protected String getMessage(String bundle, String key, Object param1, Object param2) {
			return Globals.getMessage(bundle, key, param1, param2);
    }

	/**
	 * ��ȡ��Դ�ж������Ϣ
	 * @param bundle
	 * @param key
	 * @param params
	 * @return
	 */
    protected String getMessage(String bundle, String key, Object[] params) {
			return Globals.getMessage(bundle, key, params);
    }
    
	protected ServletContext context() {
		return servlet.getServletContext();
	}

	protected ServletConfig config() {
		return servlet.getServletConfig();
	}

}

/**
 * �������Ͳ���֧��
 * @author liudong
 */
class UnsupportedReturnTypeException extends Exception {

	public UnsupportedReturnTypeException(String message) {
		super(message);
	}

}
