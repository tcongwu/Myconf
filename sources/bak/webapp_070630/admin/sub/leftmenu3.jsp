<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.myconf.beans.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="embed_module">
  <tr>
    <td class="module_title"><b><bean:message key="menu.top.user" bundle="admin"/></b></td>
  </tr>
  <tr>
    <td class="module_content">
	<span class="user_all"><a href="<html:rewrite page="/admin/user.jsp"/>"><b><bean:message key="menu.left.all.user" bundle="admin"/></b></a></span>
    <span class="user_add"><a href="<html:rewrite page="/admin/useradd.jsp"/>"><b><bean:message key="menu.left.add.user" bundle="admin"/></b></a></span>
	<span class="user_adds"><a href="<html:rewrite page="/admin/useradds.jsp"/>"><b><bean:message key="menu.left.add.experts" bundle="admin"/></b></a></span>
	<span class="user_recycle"><a href="<html:rewrite page="/admin/usercycle.jsp"/>"><b><bean:message key="menu.left.user.recycle" bundle="admin"/></b></a></span>
	<span class="user_section"><a href="<html:rewrite page="/admin/user.jsp?role="/><%=UserBean.ROLE_CONTENT%>"><bean:message key="menu.left.user.site" bundle="admin"/></a></span>
	<span class="user_section"><a href="<html:rewrite page="/admin/user.jsp?role="/><%=UserBean.ROLE_AUTHOR%>"><bean:message key="menu.left.user.author" bundle="admin"/></a></span>
	<span class="user_section"><a href="<html:rewrite page="/admin/user.jsp?role="/><%=UserBean.ROLE_EXPERT%>"><bean:message key="menu.left.user.expert" bundle="admin"/></a></span>
	<span class="user_section"><a href="<html:rewrite page="/admin/user.jsp?role="/><%=UserBean.ROLE_ADMIN%>"><bean:message key="menu.left.user.admin" bundle="admin"/></a></span></td>
  </tr>
</table>