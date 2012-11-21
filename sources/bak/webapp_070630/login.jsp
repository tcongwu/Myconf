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

<body onLoad="init();">
<jsp:include page="/inc/top_sim.jsp" />
<jsp:include page="/inc/logo_login.jsp" />
<SCRIPT language="javascript">
function init()
{
	var rem=getCookie("rem");
	var uname=getCookie("uname")
	if(!rem||rem==1){
		login.rem.checked=true;
	}
	if(uname&&uname!=0){
		login.email.value=uname;
		login.password.focus();
	}else{
		login.email.focus();
	}
}

function save()
{
	if(login.rem.checked){
		setCookie("rem", 1);
		setCookie("uname", login.email.value);
	}else{
		setCookie("rem", 0);
		setCookie("uname", 0);
	}
}

function checkForm()
{
	if (login.email.value.length == 0) {
		alert("<bean:message key="error.email.not.null"/>");
		login.email.focus();
		return false;
	}
	if (!isEmail(login.email.value)) {
		alert("<bean:message key="error.email.wrong.format"/>");
		login.email.focus();
		login.email.select();
		return false;
	}
	if (login.password.value.length == 0) {
		alert("<bean:message key="error.password.not.null"/>");
		login.password.focus();
		return false;
	}
	return true;
}
</script>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.login.please_input"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td height="55" valign="top" class="pagecontent"><form action="<html:rewrite page="/user.do"/>" method="post" onSubmit="save();return checkForm();" name="login" id="login">
        <input name="fromPage" type="hidden" id="fromPage" value="<%=StringUtils.exportString(request.getParameter("fromPage"))%>">
        <input name="eventSubmit_Login" type="hidden" id="eventSubmit_Login" value="1">
        <br>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" class="form_row_title"><bean:message key="common.textbox.email"/></td>
            <td class="form_row_content"><input name="email" type="text" id="email" size="32"></td>
          </tr>
        </table>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" class="form_row_title"><bean:message key="common.textbox.password"/></td>
            <td class="form_row_content"><input name="password" type="password" id="password" size="32"></td>
          </tr>
        </table>
        <table id="remember" width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content"> <input name="rem" type="checkbox" id="rem" value="1" checked>
              <bean:message key="page.login.remember"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<html:rewrite page="/forgetpass.jsp"/>" target="_blank" class="blue"><bean:message key="page.login.forget"/></a> 
            </td>
          </tr>
        </table>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_submit"><input name="sub" type="submit" id="sub" value="<bean:message key="common.button.login"/>"> 
              <input name="back" type="button" onClick="window.history.back()" id="back" value="<bean:message key="common.button.back"/>"> </td>
          </tr>
        </table>
        <br>
      </form></td>
  </tr>
</table>
<jsp:include page="/inc/footer.jsp" />
</body>
</html>