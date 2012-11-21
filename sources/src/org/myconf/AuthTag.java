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
 * <p>Title:认证标签类 </p>
 * <p>Description:所有http的入口都通过此类进行认证 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * @author Lee Bin
 * @version 1.0
 */

public class AuthTag extends BodyTagSupport {
	
  /** 当前模块名称 */
  private String module=null;
  /** 认证失败后要跳转到的URL地址 */
  private String url=null;
  /** 当前模块名称 */
  private static Hashtable mrTable=null;
  /** 认证结果常量 */
  public static final int AUTH_OK=0;
  public static final int AUTH_FAIL=1;
  public static final int AUTH_SKIP=2;
  /** 系统模块信息常量 */
  public static final String MODULE_ADMIN="admin";
  public static final String MODULE_EXPERT="expert";
  public static final String MODULE_SITE="site";
  public static final String MODULE_AUTHOR="author";
  
  /**
   * 默认的构造函数
   */
  public AuthTag() {
  }

  /**
   * 构造函数
   * @param value 模块名称
   */
  public AuthTag(String value, String url) {
		setModule(value);
		setRedirection(url);
  }

  /**
   * 设置系统当前模块
   * @param value 模块名称
   */
  public void setModule(String value) {
  	if(value==null)
    	module=value;
    else
    	module=value.trim();
  }

  /**
   * 设置系统要跳转到的URL地址
   * @param url URL地址
   */
  public void setRedirection(String url) {
		if(url==null)
			this.url=url;
		else
			this.url=url.trim();
  }
  
  /**
   * 初始化系统模块与它的编码之间的映射表
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
   * 判断某用户是否有权限进入当前模块
   * @param suser 用户信息
   * @return 是否有权限
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
    
    StatTool.execute(request, response);	//执行访问人数统计
    
    int authret=AUTH_FAIL; //初始化认证结果
    
    /** 查看用户是否通过了认证 */
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
    
		/** 对用户进行权限检查 */
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