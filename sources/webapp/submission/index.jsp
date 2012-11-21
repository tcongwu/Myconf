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

<body onLoad="switchForm();init();">
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
<script language="JavaScript">
function switchForm(){
	if(submission.st[0].checked){
		changeStyle('s1','blackbold');
		changeStyle('s2','');
		hideLayer('confirm');
		showLayer('remember');
		submission.sb.value='<bean:message key="common.button.login"/>';
		submission.sb.name='eventSubmit_Login';
	}
	if(submission.st[1].checked){
		changeStyle('s1','');
		changeStyle('s2','blackbold');
		hideLayer('remember');
		showLayer('confirm');
		submission.sb.value='<bean:message key="common.button.register"/>';
		submission.sb.name='eventSubmit_Register';
	}
}
</script>
<SCRIPT language="javascript">
function init()
{
	var rem=getCookie("rem");
	var uname=getCookie("uname")
	if(!rem||rem==1){
		submission.rem.checked=true;
	}
	if(uname&&uname!=0){
		submission.email.value=uname;
		submission.password.focus();
	}else{
		submission.email.focus();
	}
}

function save()
{
	if(submission.rem.checked){
		setCookie("rem", 1);
		setCookie("uname", submission.email.value);
	}else{
		setCookie("rem", 0);
		setCookie("uname", 0);
	}
}

function checkForm()
{
	if (submission.email.value.length == 0) {
		alert("<bean:message key="error.email.not.null"/>");
		submission.email.focus();
		return false;
	}
	if (!isEmail(submission.email.value)) {
		alert("<bean:message key="error.email.wrong.format"/>");
		submission.email.focus();
		submission.email.select();
		return false;
	}
	if (submission.password.value.length == 0) {
		alert("<bean:message key="error.password.not.null"/>");
		submission.password.focus();
		return false;
	}
	if(submission.st[1].checked){
		if (submission.password2.value.length == 0) {
			alert("<bean:message key="error.confirmpass.not.null"/>");
			submission.password2.focus();
			return false;
		}
		if( submission.password.value.length<6) {
			alert("<bean:message key="error.password.not.less.six"/>");
			submission.password.select();
			submission.password.focus();
			return false;
		}
		if (submission.password.value != submission.password2.value) {
			alert("<bean:message key="error.confirmpass.not.match"/>");
			submission.password2.select();
			submission.password2.focus();
			return false;
		}
	}
	return true;
}
</script>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/user.do"/>" method="post" onSubmit="save();return checkForm();" name="submission" id="submission">
        <input name="fromPage" type="hidden" id="fromPage" value="/submission/mypaper.jsp">
        <br>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
          <tr>
            <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                <tr> 
                  <td>
                    <input name="st" type="radio" value="1" onClick="switchForm();" checked>
                    <span id="s1"><bean:message key="page.login.olduser" bundle="author"/></span><br>
                    <input type="radio" name="st" value="2" onClick="switchForm();">
                    <span id="s2"><bean:message key="page.login.newuser" bundle="author"/></span> 
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="25%" class="form_row_title"><bean:message key="common.textbox.email"/></td>
            <td width="75%" class="form_row_content"><input name="email" type="text" id="email" size="32"></td>
          </tr>
        </table>
        <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="25%" class="form_row_title"><bean:message key="common.textbox.password"/></td>
            <td width="75%" class="form_row_content"><input name="password" type="password" id="password" size="32"></td>
          </tr>
        </table>
        <table id="confirm" width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="25%" class="form_row_title"><bean:message key="common.textbox.confirmpass"/></td>
            <td width="75%" class="form_row_content"><input name="password2" type="password" id="password2" size="32">
              <bean:message key="page.register.password"/></td>
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
            <td class="form_row_submit"><input type="submit" id="sb" name="eventSubmit_Create" value="<bean:message key="common.button.login"/>" class="button"> 
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