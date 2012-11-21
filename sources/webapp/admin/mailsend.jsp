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
<%@ page import="org.myconf.util.*" %>
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
<jsp:include page="/inc/logo_admin.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.mailsend.title" bundle="admin"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<SCRIPT language="javascript">
function checkForm()
{
	if (mail.receiver.value.length == 0) {
		alert("<bean:message key="error.receiver.not.null"/>");
		mail.receiver.focus();
		return false;
	}
	return true;
}
</script>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/mail.do"/>" method="post" onSubmit="return checkForm()" name="mail" id="mail">
        <input name="eventSubmit_Send" type="hidden" id="eventSubmit_Send" value="1">
        <br>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" height="25" class="form_row_title">*<bean:message key="common.title.receiver" bundle="admin"/></td>
            <td class="form_row_content"><input name="receiver" type="text" id="receiver" size="50" value="<%=StringUtils.exportString(request.getParameter("mail"))%>">
              {<bean:message key="page.mailsend.ins1" bundle="admin"/>} </td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" height="25" class="form_row_title"><bean:message key="common.title.mail.subject" bundle="admin"/></td>
            <td width="84%" class="form_row_content"><input name="subject" type="text" id="subject" size="50"></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content"> <div class="spacer_5"></div>
              <textarea name="content" cols="100" rows="20" id="content"></textarea>
              <div class="spacer_10"></div></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td nowrap class="form_row_submit"><input name="sub" type="submit" class="button" id="sub" value="<bean:message key="common.button.send.mail"/>">
              <input name="back" type="button" class="button" id="back" onClick="window.close()" value="<bean:message key="common.button.back"/>"> 
            </td>
          </tr>
        </table>
        </form></td>
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