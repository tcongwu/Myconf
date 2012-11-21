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
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:useBean id="instructions" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="users" class="java.util.ArrayList" scope="request" />

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
	  <script language="JavaScript">
	  function editUser(uid) {
		window.open("<html:rewrite page="/admin/useredit.jsp?id="/>"+uid, "user", "resizable=no,scrollbars=yes,height=600,width=800");
	  }
	  </script>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td class="pagecontent_title"><b><bean:message key="menu.left.add.experts" bundle="admin"/></b></td>
        </tr>
        <tr> 
          <td height="16" class="pagecontent_right"></td>
        </tr>
      </table>
	  <%if(instructions!=null && instructions.size()>0){%>
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
        <tr> 
          <td colspan="3" nowrap class="table_head"><strong><bean:message key="common.text.batch.result" bundle="admin"/></strong></td>
        </tr>
        <%
          String[] ins=null;
          for(int i=0;i<instructions.size();i++){
          	ins=(String[])instructions.get(i);
        %>
        <tr> 
          <td width="5%" align="center" class="table_cell"><%=ins[0]%></td>
          <td width="38%" class="table_cell"><%=ins[1]%></td>
          <td width="57%" class="table_cell"><%=ins[2]%></td>
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
      <%if(users!=null && users.size()>0){%>
      <table width="100%" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="52%"> <div class="spacer_20"></div>
            <div class="line_dashed"></div>
            <div class="spacer_10"></div></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
        <tr> 
          <td colspan="3" nowrap class="table_head"><strong><bean:message key="common.text.exist.users" bundle="admin"/></strong></td>
          <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.modify"/></td>
        </tr>
        <%
          UserBean user=null;
          for(int i=0;i<users.size();i++){
          	user=(UserBean)users.get(i);
        %>
        <tr> 
          <td width="18%" class="table_cell"><%=StringUtils.exportString(user.getRealName())%></td>
          <td width="37%" class="table_cell"><%=user.getEmail()%></td>
          <td width="39%" class="table_cell"><%=StringUtils.exportString(user.getWorkLocation())%></td>
          <td align="center" class="table_cell"><a href="javascript:editUser(<%=user.getId()%>)"><img src="<html:rewrite page="/images/sub_edit.gif"/>" width="21" height="21" border="0"></a> 
          </td>
        </tr>
        <%}%>
      </table>
      <%}%>
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