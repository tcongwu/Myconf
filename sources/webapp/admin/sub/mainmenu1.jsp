<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="org.myconf.beans.*" %>
<jsp:useBean id="uinfo" class="org.myconf.SessionUserObject" scope="request" />
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><div class="fleft sitenav"><a class="nav_on"><a class="selected" href="<html:rewrite page="/admin/index.jsp"/>"><bean:message key="menu.top.submission_review" bundle="admin"/></a></a><a href="<html:rewrite page="/site/index.jsp"/>"><bean:message key="menu.top.site" bundle="admin"/></a><a class="split"></a><a href="<html:rewrite page="/admin/user.jsp"/>"><bean:message key="menu.top.user" bundle="admin"/></a><a class="split"></a><a href="<html:rewrite page="/admin/mail.jsp"/>"><bean:message key="menu.top.mail" bundle="admin"/></a><a class="split"></a><a href="<html:rewrite page="/bbs/index2.jsp"/>" target="_blank"><bean:message key="menu.top.bbs" bundle="admin"/></a></div></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">
	  <select name="select"onChange="if(this.value.length>0){window.location='<html:rewrite page="/user.do"/>?eventSubmit_SelectRole&rid='+this.value;}">
        <option selected><bean:message key="menu.role.title"/></option>
        <%if(uinfo.getIsAdmin()==UserBean.TRUE){%><option value="admin"><bean:message key="menu.role.admin"/></option><%}%>
        <%if(uinfo.getIsExpert()==UserBean.TRUE){%><option value="expert"><bean:message key="menu.role.expert"/></option><%}%>
        <%if(uinfo.getIsContent()==UserBean.TRUE){%><option value="site"><bean:message key="menu.role.site"/></option><%}%>
        <%if(uinfo.getIsAuthor()==UserBean.TRUE){%><option value="author"><bean:message key="menu.role.author"/></option><%}%>
      </select>
      &nbsp;</td>
	<td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>