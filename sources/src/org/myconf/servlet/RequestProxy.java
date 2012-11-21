package org.myconf.servlet;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.myconf.Globals;

/**
 * �������ķ�װ�����ڴ����Զ�����
 * @author liudong
 */
public class RequestProxy extends HttpServletRequestWrapper{

	protected String encoding;

	public RequestProxy(HttpServletRequest request) throws UnsupportedEncodingException{
		this(request, Globals.ENC_UTF_8);
	}
	
	public RequestProxy(HttpServletRequest request, String encoding) throws UnsupportedEncodingException{
		super(request);
		this.encoding = (encoding==null)?Globals.ENC_UTF_8:encoding;
	}
	
	/**
	 * ����getParameter
	 */
	public String getParameter(String paramName) {
		String value = super.getParameter(paramName);
		if(value!=null){
			try {
				return new String(value.getBytes(Globals.ENC_8859_1),encoding);
			}catch(UnsupportedEncodingException e) {}
		}
		return value;
	}

	/**
	 * ����getParameterMap
	 */
	public Map getParameterMap() {
		Map params = super.getParameterMap();
		HashMap new_params = new HashMap();
		Iterator iter = params.keySet().iterator();
		while(iter.hasNext()){
			String key = (String)iter.next();
			Object oValue = params.get(key);
			if(oValue.getClass().isArray()){
				String[] values = (String[])params.get(key);
				String[] new_values = new String[values.length];
				for(int i=0;i<values.length;i++){
					try {
						new_values[i] = new String(values[i].getBytes(Globals.ENC_8859_1),encoding);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						break;
					}
				}
				new_params.put(key, new_values);
			}
			else{
				String value = (String)params.get(key);
				String new_value = null;
				try {
					new_value = (value!=null)?
							new String(value.getBytes(Globals.ENC_8859_1),encoding):null;
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					break;
				}
				if(new_value!=null)
					new_params.put(key,new_value);
			}
		}
		return new_params;
	}

	/**
	 * ����getParameterValues
	 */
	public String[] getParameterValues(String arg0) {
		String[] values = super.getParameterValues(arg0);
		for(int i=0;values!=null&&i<values.length;i++){
			try {
				values[i] = new String(values[i].getBytes(Globals.ENC_8859_1),encoding);
			} catch (UnsupportedEncodingException e) {}
		}
		return values;
	}
	
	public String getEncoding() {
		return encoding;
	}
}
