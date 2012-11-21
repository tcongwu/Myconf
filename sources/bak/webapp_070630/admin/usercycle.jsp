<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="admin" />
<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
//*********************************
//variable
//*********************************
%>
<%
//recycle users list
List users=UserDAO.queryUser(false);
UserBean user=null;
%>

<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />

<body>
<%
//*********************************
//top
//*********************************
%>
<jsp:include page="/inc/top.jsp" />
<jsp:include page="/inc/logo_admin.jsp" />
<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/admin/sub/mainmenu3.jsp" />
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr>
    <td width="180" height="55" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenu">
        <tr> 
          <td height="41">
			<jsp:include page="/admin/sub/leftmenu3.jsp" />
			<jsp:include page="/inc/stat.jsp" />
          </td>
        </tr>
      </table></td>
    <td width="598" valign="top" class="pagecontent">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td class="pagecontent_title"><b><bean:message key="menu.left.user.recycle" bundle="admin"/></b></td>
        </tr>
        <tr> 
          <td height="16" class="pagecontent_right"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr> 
                <td><div class="spacer_5"></div>
                  <li><bean:message key="page.usercycle.ins1" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
              <tr> 
                <td nowrap class="form_row_submit">&nbsp; </td>
              </tr>
            </table>
            <table width="100%" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="52%"> <div class="line_dashed"></div>
                  <div class="spacer_10"></div></td>
              </tr>
            </table>
            <%if(users!=null && users.size()>0){%>
            <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
              <tr> 
                <td width="12%" nowrap class="table_head"><bean:message key="common.text.realname" bundle="admin"/></td>
                <td width="48%" class="table_head" nowrap><bean:message key="common.text.email" bundle="admin"/></td>
                <td width="33%" nowrap class="table_head"><bean:message key="common.text.email" bundle="admin"/></td>
                <td width="7%" align="center" class="table_head" nowrap><bean:message key="common.text.recover"/></td>
              </tr>
              <%
              	for(int i=0;i<users.size();i++){
              	  user=(UserBean)users.get(i);
              %>
              <tr> 
                <td class="table_cell"><%=StringUtils.exportString(user.getRealName())%></td>
                <td class="table_cell"><%=user.getEmail()%></td>
                <td class="table_cell"><%=StringUtils.exportString(user.getWorkLocation())%></td>
                <td align="center" nowrap class="table_cell"><a onClick="return confirm('<bean:message key="ins.confirm.recover"/>')" href="<html:rewrite page="/user.do?eventSubmit_Recover&id="/><%=user.getId()%>"><img src="<html:rewrite page="/images/recover.gif"/>" width="21" height="21" border="0"></a> 
                </td>
              </tr>
              <%}%>
            </table>
            <%}else{%>
            <table width="100%" border="0" cellpadding="5" cellspacing="0">
              <tr> 
                <td align="center" class="blackbold" nowrap><bean:message key="common.text.norecord"/></td>
              </tr>
            </table>
            <%}%>
          </td>
        </tr>
      </table> 
    </td>
  </tr>
</table>
<%
//*********************************
//end content
//*********************************
%>
<%
//**********************************
//footer
//**********************************
%>
<jsp:include page="/inc/footer.jsp" />
</body>
</html>