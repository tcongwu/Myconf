<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.util.StringUtils" %>
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

<body onLoad="submission.password.focus();">
<jsp:include page="/inc/top_sim.jsp" />
<jsp:include page="/inc/logo_author.jsp" />
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.login.please_input"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<SCRIPT language="javascript">
function checkForm()
{
	if (submission.password.value.length == 0) {
		alert("<bean:message key="error.password.not.null"/>");
		submission.password.focus();
		return false;
	}
	return true;
}
</script>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/user.do"/>" method="post" onSubmit="return checkForm();" name="submission" id="submission">
        <input name="email" type="hidden" id="email" value="<%=StringUtils.exportString(request.getParameter("email"))%>">
        <input name="eventSubmit_AddAuthor" type="hidden" id="eventSubmit_AddAuthor" value="1">
        <br>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
          <tr>
            <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                <tr> 
                  <td>
                      <li><span class="blackbold"><bean:message key="page.existuser.exist" bundle="author"/></span></li>
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="25%" class="form_row_title"><bean:message key="common.textbox.email"/></td>
            <td width="75%" class="form_row_content">&nbsp;&nbsp;<%=StringUtils.exportString(request.getParameter("email"))%></td>
          </tr>
        </table>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="25%" class="form_row_title"><bean:message key="common.textbox.password"/></td>
            <td width="75%" class="form_row_content"><input name="password" type="password" id="password" size="32"></td>
          </tr>
        </table>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_submit"><input type="submit" id="sub" name="sub" value="<bean:message key="common.button.login"/>" class="button"> 
              <input name="Button" type="button" onClick="window.history.back()" class="button" value="<bean:message key="common.button.back"/>">
          </tr>
        </table>
        <br>
      </form></td>
  </tr>
</table>
<jsp:include page="/inc/footer.jsp" />
</body>
</html>