<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:useBean id="uinfo" class="org.myconf.SessionUserObject" scope="request" />
<jsp:useBean id="url" class="java.lang.String" scope="request" />
<table width="778" border="0" align="center" cellpadding="3" cellspacing="0" class="float_bar">
  <tr> 
    <td width="268">&nbsp;<a href="<html:rewrite page="/switch.do?lang="/><%=org.myconf.Globals.LANG_SIMPLIFIED%>&url=<%=url%>"><b><%=org.myconf.Globals.LANGUAGE_SIMPLIFIED%></b></a>&nbsp;|&nbsp;<a href="<html:rewrite page="/switch.do?lang="/><%=org.myconf.Globals.LANG_TRADITIONAL%>&url=<%=url%>"><b><%=org.myconf.Globals.LANGUAGE_TRADITIONAL%></b></a>&nbsp;|&nbsp;<a href="<html:rewrite page="/switch.do?lang="/><%=org.myconf.Globals.LANG_ENGLISH%>&url=<%=url%>"><b><%=org.myconf.Globals.LANGUAGE_ENGLISH%></b></a></td>
    <td width="498" align="right"><bean:message key="common.top.welcome"/><%=uinfo.getName().toString()%> | <a href="<html:rewrite page="/moduser.jsp"/>" target="_blank"><bean:message key="common.top.personinfo"/></a> | <a href="<html:rewrite page="/modpass.jsp"/>" target="_blank"><bean:message key="common.top.modpass"/></a> 
      | <a href="<html:rewrite page="/user.do"/>?eventSubmit_Logout&fromPage=<%=url%>"><bean:message key="common.top.exit"/></a>&nbsp;</td>
  </tr>
</table>