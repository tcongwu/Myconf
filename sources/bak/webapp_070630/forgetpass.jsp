<%
//*********************************
//define
//*********************************
%>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
//*********************************
//variable
//*********************************
%>
<jsp:useBean id="uinfo" class="org.myconf.SessionUserObject" scope="request" />

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
<jsp:include page="/inc/logo.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><strong style="font-size:14px">&nbsp;<bean:message key="page.forgetpass.title"/></strong></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<br>
<SCRIPT language="javascript">
function checkForm()
{
	if (getpass.email.value.length == 0) {
		alert("<bean:message key="error.email.not.null"/>");
		getpass.email.focus();
		return false;
	}
	if (!isEmail(getpass.email.value)) {
		alert("<bean:message key="error.email.wrong.format"/>");
		getpass.email.focus();
		getpass.email.select();
		return false;
	}
	return true;
}
</script>
<form action="<html:rewrite page="/user.do"/>" method="post" onSubmit="return checkForm()" name="getpass" id="getpass">
  <input name="eventSubmit_ForgetPass" type="hidden" id="eventSubmit_ForgetPass" value="1">
  <TABLE width=778 height="84" border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=5><img src="<html:rewrite page="/images/rounded_top.gif"/>" width="778" height="5"></TD>
    </TR>
    <TR> 
      <TD width=1 height="73" noWrap bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
      <TD width=776 vAlign=top noWrap>
          <br>
          <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
            <tr> 
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                  <tr> 
                    <td> <li><bean:message key="page.forgetpass.ins1"/></li>
                      </td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="21%" class="form_row_title"><bean:message key="common.textbox.email"/></td>
              <td width="79%" class="form_row_content"><input name="email" type="text" id="email" size="48"> 
                &nbsp;</td>
            </tr>
          </table>
          <table width="60%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td class="form_row_submit">&nbsp; </td>
            </tr>
          </table>
          <div class="spacer_5"></div>
        
      </TD>
      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
    </TR>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=6><img src="<html:rewrite page="/images/rounded_bottom.gif"/>" width="778" height="5"></TD>
    </TR>
  </TBODY>
</TABLE>
<br>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td align="center" class="graybar"> <input name="sub" type="submit" id="sub" style="width:130px;height:24px;" value="<bean:message key="common.button.get.pass"/>"> 
      <input name="close" type="button" id="close" style="width:130px;height:24px;" onClick="window.close()" value="<bean:message key="common.button.closewindow"/>"> 
    </td>
  </tr>
</table>
</form>
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