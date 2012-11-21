package org.myconf;

import java.util.Hashtable;

import javax.servlet.jsp.JspException;
import javax.servlet.ServletException;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;

import org.myconf.beans.base._BeanBase;
import org.myconf.util.StatTool;
import org.myconf.util.StringUtils;

/**
 * <p>Title:��֤��ǩ�� </p>
 * <p>Description:����http����ڶ�ͨ�����������֤ </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * @author Lee Bin
 * @version 1.0
 */

public class AuthTag extends BodyTagSupport {
	
  /** ��ǰģ������ */
  private String module=null;
  /** ��֤ʧ�ܺ�Ҫ��ת����URL��ַ */
  private String url=null;
  /** ��ǰģ������ */
  private static Hashtable mrTable=null;
  /** ��֤������� */
  public static final int AUTH_OK=0;
  public static final int AUTH_FAIL=1;
  public static final int AUTH_SKIP=2;
  /** ϵͳģ����Ϣ���� */
  public static final String MODULE_ADMIN="admin";
  public static final String MODULE_EXPERT="expert";
  public static final String MODULE_SITE="site";
  public static final String MODULE_AUTHOR="author";
  
  /**
   * Ĭ�ϵĹ��캯��
   */
  public AuthTag() {
  }

  /**
   * ���캯��
   * @param value ģ������
   */
  public AuthTag(String value, String url) {
		setModule(value);
		setRedirection(url);
  }

  /**
   * ����ϵͳ��ǰģ��
   * @param value ģ������
   */
  public void setModule(String value) {
  	if(value==null)
    	module=value;
    else
    	module=value.trim();
  }

  /**
   * ����ϵͳҪ��ת����URL��ַ
   * @param url URL��ַ
   */
  public void setRedirection(String url) {
		if(url==null)
			this.url=url;
		else
			this.url=url.trim();
  }
  
  /**
   * ��ʼ��ϵͳģ�������ı���֮���ӳ���
   */
  public void initMRTable(){
  	if(mrTable==null)
  		mrTable=new Hashtable();
  		
		mrTable.clear();
		
		mrTable.put(MODULE_ADMIN,new Integer(1));
		mrTable.put(MODULE_EXPERT,new Integer(2));
		mrTable.put(MODULE_SITE,new Integer(3));
		mrTable.put(MODULE_AUTHOR,new Integer(4));
  }
  
  /**
   * �ж�ĳ�û��Ƿ���Ȩ�޽��뵱ǰģ��
   * @param suser �û���Ϣ
   * @return �Ƿ���Ȩ��
   */
  public boolean isAccess(SessionUserObject suser){
  	if(mrTable==null){
			initMRTable();
  	}
  	
		if(StringUtils.isEmpty(module)||(suser.getIsAdmin()==_BeanBase.TRUE))
			return true;
  	
  	Object no=mrTable.get(module);
  	if(no==null)
			return true;
  	
		switch(((Integer)no).intValue()){ 
			case 2: 
				if(suser.getIsExpert()==_BeanBase.TRUE)
					return true;
				break; 
			case 3: 
				if(suser.getIsContent()==_BeanBase.TRUE)
					return true;
				break; 
			case 4:
				if(suser.getIsAuthor()==_BeanBase.TRUE)
					return true;
				break; 
			default: 
				break; 
		} 
  	return false;
  }

  protected void Auth_internal(HttpServletRequest request,HttpServletResponse response) throws Exception {
    
    StatTool.execute(request, response);	//ִ�з�������ͳ��
    
    int authret=AUTH_FAIL; //��ʼ����֤���
    
    /** �鿴�û��Ƿ�ͨ������֤ */
    SessionUserObject uinfo=UserLoginManager.getLoginUser(request, response, true);
    if(uinfo==null){
			if(!StringUtils.isEmpty(url)){
					response.sendRedirect(Globals.webPath(request, url));
					return;
			}else{
				StringBuffer tmp = new StringBuffer(request.getRequestURI().replaceFirst(Globals.root(request),""));
				if(request.getQueryString()!=null){
					tmp.append('?');
					tmp.append(request.getQueryString());
				}
	    		
				response.sendRedirect(Globals.root(request)+"/login.jsp?fromPage="+StringUtils.URLEncode(tmp.toString()));
				return;
			}
    }
    
		/** ���û�����Ȩ�޼�� */
		if(!isAccess(uinfo)){
			throw new Exception(Globals.getMessage("common","error.can_not_access"));
		}
    
    authret=AUTH_OK;
    request.setAttribute("uinfo", uinfo);
    String url=null;
    if(StringUtils.isEmpty(module) || AuthTag.MODULE_AUTHOR.equals(module))
    	url="/submission";
    else
    	url="";
    request.setAttribute("url", url);
  }

  public boolean doAuth(HttpServlet servlet,HttpServletRequest request,HttpServletResponse response)
  throws ServletException, java.io.IOException
  {
    try {
      Auth_internal(request,response);
    } catch (Exception ex) {
      request.setAttribute("javax.servlet.jsp.jspException",ex);
      response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
      servlet.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
      return false;
    }
    return true;
  }

  public int doStartTag() throws javax.servlet.jsp.JspException {
    try {
      Auth_internal( (HttpServletRequest) pageContext.getRequest(),
             (HttpServletResponse) pageContext.getResponse());
    }
    catch (Exception ex) {
      throw new JspException("",ex);
    }
    return EVAL_BODY_INCLUDE;
  }

  public int doEndTag() throws javax.servlet.jsp.JspException {
    return super.doEndTag();
  }
}