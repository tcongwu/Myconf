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
<%@ page import="org.myconf.*" %>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.util.StringUtils" %>
<%@ page import="org.myconf.util.RequestUtils" %>
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
//get role
int role=RequestUtils.getParam(request, "role", 0);

//user pages list
Page pg=UserDAO.queryUser(request, RequestUtils.getParam(request, "page", 1), Globals.PAGESIZE_10);
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
	  <script language="JavaScript">
	  function editUser(uid) {
		window.open("<html:rewrite page="/admin/useredit.jsp?id="/>"+uid, "user", "resizable=no,scrollbars=yes,height=600,width=800");
	  }
	  </script>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td class="pagecontent_title"><b>
          <%if(role==UserBean.ROLE_ADMIN){%>
          	<bean:message key="menu.left.user.admin" bundle="admin"/>
          <%}else if(role==UserBean.ROLE_AUTHOR){%>
          	<bean:message key="menu.left.user.author" bundle="admin"/>
          <%}else if(role==UserBean.ROLE_CONTENT){%>
          	<bean:message key="menu.left.user.site" bundle="admin"/>
          <%}else if(role==UserBean.ROLE_EXPERT){%>
          	<bean:message key="menu.left.user.expert" bundle="admin"/>
          <%}else{%>
          	<bean:message key="menu.left.all.user" bundle="admin"/>
          <%}%>
          </b></td>
        </tr>
        <tr> 
          <td height="16" class="pagecontent_right"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.user.ins1" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/admin/user.jsp"/>" method="post" name="search" id="search">
              <input name="role" type="hidden" id="role" value="<%=StringUtils.exportString(request.getParameter("role"))%>">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="16%" class="form_row_title"><bean:message key="page.paper.title.keyword" bundle="admin"/></td>
                  <td class="form_row_content"><input name="keyword" type="text" id="keyword" size="18">
                    {<bean:message key="page.user.ins2" bundle="admin"/>}</td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td nowrap class="form_row_submit"><input name="sub" type="submit" class="button" id="sub" value="<bean:message key="common.button.search.user"/>">
                  </td>
                </tr>
              </table>
            </form>
            <table width="100%" cellspacing="0" cellpadding="0">
              <tr>
                <td width="52%">
					<div class="spacer_20"></div>
					<div class="line_dashed"></div>
					<div class="spacer_10"></div>
				</td>
              </tr>
            </table>
			<script language="JavaScript">
			function delUser(id) {
				del.id.value=id;
				del.submit();
			}
			</script>
            <form action="<html:rewrite page="/user.do"/>" method="post" name="del" id="del">
		        <input name="fromPage" type="hidden" id="fromPage" value="/admin/user.jsp">
		        <input name="eventSubmit_Recycle" type="hidden" id="eventSubmit_Recycle" value="1">
		        <input name="role" type="hidden" id="role" value="<%=StringUtils.exportString(request.getParameter("role"))%>">
		        <input name="keyword" type="hidden" id="keyword" value="<%=StringUtils.exportString(request.getParameter("keyword"))%>">
		        <input name="page" type="hidden" id="page" value="<%=StringUtils.exportString(request.getParameter("page"))%>">
		        <input name="id" type="hidden" id="id" value="0">
            </form>
            <%if(pg!=null && pg.hasNext()){%>
			<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
              <tr> 
                <td width="13%" nowrap class="table_head"><bean:message key="common.text.realname" bundle="admin"/></td>
                <td width="32%" class="table_head" nowrap><bean:message key="common.text.email" bundle="admin"/></td>
                <td width="15%" nowrap class="table_head"><bean:message key="common.text.password" bundle="admin"/></td>
                <td width="28%" nowrap class="table_head"><bean:message key="common.text.worklocation" bundle="admin"/></td>
                <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.modify"/></td>
                <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.delete"/></td>
              </tr>
              <%
              	while(pg.hasNext()){
              	  user=(UserBean)pg.next();
              %>
              <tr> 
                <td class="table_cell"><%=StringUtils.exportString(user.getRealName())%></td>
                <td class="table_cell"><a class="blue" href="<html:rewrite page="/admin/mailsend.jsp?mail="/><%=user.getEmail()%>" target="_blank"><%=user.getEmail()%></a></td>
                <td class="table_cell"><%=user.getPassword()%></td>
                <td class="table_cell"><%=StringUtils.exportString(user.getWorkLocation())%></td>
                <td align="center" class="table_cell"><a href="javascript:editUser(<%=user.getId()%>)"><img src="<html:rewrite page="/images/sub_edit.gif"/>" width="21" height="21" border="0"></a> 
                </td>
                <td align="center" class="table_cell"><a onClick="return confirm('<bean:message key="ins.confirm.delete"/>')" href="javascript:delUser(<%=user.getId()%>)"><img src="<html:rewrite page="/images/sub_del.gif"/>" width="21" height="21" border="0"></a> 
                </td>
              </tr>
              <%}%>
            </table>
            <table width="100%" border="0" cellpadding="5" cellspacing="0" style="border-bottom:#cccccc 1px solid">
              <tr> 
                <td align="right" nowrap><%=pg.getControlPane(request, "/admin/user.jsp")%></td>
              </tr>
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