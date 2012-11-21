
<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="site" />
<%
//*********************************
//define
//*********************************
%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.myconf.util.StringUtils" %>
<%
   StringBuffer url=new StringBuffer();
   String version=StringUtils.exportString(request.getParameter("version"));
   url.append(request.getContextPath()).append("/site/index.jsp?version=").append(version);
   session.removeAttribute("languange");
   session.removeAttribute("key");
   response.sendRedirect(url.toString());
%>	
  