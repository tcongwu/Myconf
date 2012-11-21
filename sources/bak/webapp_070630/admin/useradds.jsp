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
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

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
	<SCRIPT language="javascript">
	function checkForm()
	{
		if (addusers.ufile.value.length == 0) {
			alert("<bean:message key="error.expert.list.not.null"/>");
			return false;
		}
		return true;
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
      <form action="<html:rewrite page="/user.do"/>" method="post" enctype="multipart/form-data" name="addusers" id="addusers" onSubmit="return checkForm()">
        <input name="eventSubmit_AddUsers" type="hidden" id="eventSubmit_AddUsers" value="1">
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title"><bean:message key="page.useradds.title.template.download" bundle="admin"/></td>
            <td class="form_row_content">&nbsp;&nbsp;{<bean:message key="page.useradds.ins1" bundle="admin"/>}{<a href="<html:rewrite page="/expertlist.xls"/>" class="blue"><bean:message key="common.text.download"/></a>}</td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
          <tr> 
            <td width="20%" class="form_row_title"><bean:message key="page.useradds.title.expert.list" bundle="admin"/></td>
            <td class="form_row_content"> &nbsp;&nbsp;{<bean:message key="page.useradds.ins2" bundle="admin"/>}</td>
          </tr>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content"> <div class="spacer_5"></div>
              <div class="spacer_10"> 
                <input name="ufile" type="file" id="ufile" size="58">
              </div></td>
          </tr>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td nowrap class="form_row_submit"><input name="sub" type="submit" class="button" id="sub" value="<bean:message key="common.button.batch.add"/>"> 
            </td>
          </tr>
        </table>
      </form>
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