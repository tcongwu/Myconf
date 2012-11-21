<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="site" />

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.myconf.util.StringUtils" %>
<%
	String languange=StringUtils.exportString(request.getParameter("version"));
	String key="page.site.setting_zhcn";
	if(languange.equals("zh_tw")){
		key="page.site.setting_zhtw";
		}
	else if(languange.equals("english")){
		key="page.site.setting_zhen";
		}
	
	session.setAttribute("key",key);
	session.setAttribute("version",languange);
	
	StringBuffer url=new StringBuffer();
	url.append(request.getContextPath()).append("/site/site_setting.jsp");
  
	response.sendRedirect(url.toString());
%>	
  