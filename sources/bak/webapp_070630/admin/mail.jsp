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
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.util.StringUtils" %>
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
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
if(conf==null)
	conf=new ConfigBean();
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
<jsp:include page="/admin/sub/mainmenu4.jsp" />
<br>
<script language="JavaScript">
function checkForm(){
	if (conf.email.value.length == 0) {
		alert("<bean:message key="error.star.not.null"/>");
		conf.email.focus();
		return false;
	}
	if (conf.pass.value.length == 0) {
		alert("<bean:message key="error.star.not.null"/>");
		conf.pass.focus();
		return false;
	}
	if (conf.smtp.value.length == 0) {
		alert("<bean:message key="error.star.not.null"/>");
		conf.smtp.focus();
		return false;
	}
	if (conf.port.value.length == 0) {
		alert("<bean:message key="error.star.not.null"/>");
		conf.port.focus();
		return false;
	}
	if (!isRange(trim(conf.port.value), "0123456789")) {
		alert("<bean:message key="error.port.must.integer"/>");
		conf.port.select();
		conf.port.focus();
		return false;
	}
	return true;
}
</script>
<TABLE width=778 height="84" border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=5><img src="<html:rewrite page="/images/rounded_top.gif"/>" width="778" height="5"></TD>
    </TR>
    <TR> 
      <TD width=1 height="73" noWrap bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
      <TD width=776 noWrap>
		<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td class="pagecontent_title"><b><bean:message key="menu.top.mail" bundle="admin"/></b></td>
          </tr>
        </table>
        <br>
        <form action="<html:rewrite page="/config.do"/>" method="post" onSubmit="return checkForm()" name="conf" id="conf">
          <input name="eventSubmit_Save" type="hidden" id="eventSubmit_Save" value="0">
          <input name="fromPage" type="hidden" id="fromPage" value="/admin/mail.jsp">
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
            <tr> 
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                  <tr> 
                    <td> <li><bean:message key="page.mail.ins1" bundle="admin"/></li>
                      <li><bean:message key="page.mail.ins2" bundle="admin"/></li>
                      <li><bean:message key="page.mail.ins3" bundle="admin"/></li>
                      <li><bean:message key="page.mail.ins4" bundle="admin"/></li></td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title">*<bean:message key="common.textbox.email"/></td>
              <td class="form_row_content"><input name="email" type="text" id="email" size="50" value="<%=StringUtils.exportString(conf.getEmail())%>">
              </td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title">*<bean:message key="common.title.email.pass" bundle="admin"/></td>
              <td class="form_row_content"><input name="pass" type="password" id="pass" size="50" value="<%=StringUtils.exportString(conf.getPass())%>"></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title">*<bean:message key="common.title.email.smtp" bundle="admin"/></td>
              <td class="form_row_content"><input name="smtp" type="text" id="smtp" size="50" value="<%=StringUtils.exportString(conf.getSmtp())%>"></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title">*<bean:message key="common.title.email.port" bundle="admin"/></td>
              <td class="form_row_content"><input name="port" type="text" id="port" size="10" value="<%if(conf.getPort()==0){out.print(25);}else{out.print(conf.getPort());}%>"></td>
            </tr>
          </table>
	      <script language="JavaScript">
			function check(obj){
				if(obj.checked){
					conf.bySSL.value=<%=ConfigBean.TRUE%>;
				}else{
					conf.bySSL.value=<%=ConfigBean.FALSE%>;
				}
			}
		  </script>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td class="form_row_content">
				<input name="bySSL" type="hidden" id="bySSL" value="<%=conf.getBySSL()%>">
				<input name="chk" type="checkbox" onClick="check(this)" id="chk" value="1"<%if(conf.getBySSL()==ConfigBean.TRUE){out.print(" checked");}%>>
                <bean:message key="page.mail.ins5" bundle="admin"/></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td nowrap class="form_row_submit"><input name="sub" type="submit" id="sub" value="<bean:message key="common.button.email.setting"/>"> 
              <input name="send" type="button" id="send" onClick="window.open('<html:rewrite page="/admin/mailsend.jsp"/>');" value="<bean:message key="common.button.send.mail"/>"></td>
            </tr>
          </table>
        </form>
        
        <table width="88%" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="52%"> <div class="spacer_20"></div>
              <div class="line_dashed"></div>
              <div class="spacer_10"></div></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
          <tr> 
            <td width="12%" nowrap class="table_head"><bean:message key="common.text.email.service" bundle="admin"/></td>
            <td width="24%" class="table_head" nowrap><bean:message key="common.text.email.smtp" bundle="admin"/></td>
            <td width="7%" nowrap class="table_head"><bean:message key="common.text.email.port" bundle="admin"/></td>
            <td width="6%" nowrap class="table_head"><bean:message key="common.text.email.byssl" bundle="admin"/></td>
            <td width="9%" nowrap class="table_head"><bean:message key="common.text.email.test.success" bundle="admin"/></td>
            <td width="13%" nowrap class="table_head"><bean:message key="common.text.email.recommend" bundle="admin"/></td>
            <td width="29%" class="table_head" nowrap><bean:message key="common.text.email.memo" bundle="admin"/></td>
          </tr>
          <tr valign="top"> 
            <td class="table_cell">163.com</td>
            <td class="table_cell">smtp.163.com</td>
            <td class="table_cell">25</td>
            <td class="table_cell"><bean:message key="common.text.no"/></td>
            <td class="table_cell"><bean:message key="common.text.yes"/></td>
            <td class="table_cell"><img src="<html:rewrite page="/images/5.gif"/>" width="61" height="12"></td>
            <td class="table_cell"><bean:message key="page.mail.memo.client" bundle="admin"/></td>
          </tr>
          <tr valign="top"> 
            <td nowrap class="table_cell">126.com</td>
            <td class="table_cell">smtp.126.com</td>
            <td class="table_cell">25</td>
            <td nowrap class="table_cell"><bean:message key="common.text.no"/></td>
            <td nowrap class="table_cell"><bean:message key="common.text.yes"/></td>
            <td nowrap class="table_cell"><img src="<html:rewrite page="/images/5.gif"/>" width="61" height="12"></td>
            <td class="table_cell"><bean:message key="page.mail.memo.client" bundle="admin"/></td>
          </tr>
          <tr valign="top"> 
            <td nowrap class="table_cell">gmail.com</td>
            <td class="table_cell">smtp.gmail.com</td>
            <td class="table_cell">465</td>
            <td nowrap class="table_cell"><bean:message key="common.text.yes"/></td>
            <td nowrap class="table_cell"><bean:message key="common.text.yes"/></td>
            <td nowrap class="table_cell"><img src="<html:rewrite page="/images/1.gif"/>" width="13" height="12"></td>
            <td class="table_cell"><bean:message key="page.mail.memo.gmail" bundle="admin"/></td>
          </tr>
          <tr valign="top"> 
            <td nowrap class="table_cell">sohu.com</td>
            <td class="table_cell">smtp.sohu.com</td>
            <td class="table_cell">25</td>
            <td nowrap class="table_cell"><bean:message key="common.text.no"/></td>
            <td nowrap class="table_cell"><bean:message key="common.text.yes"/></td>
            <td nowrap class="table_cell"><img src="<html:rewrite page="/images/3.gif"/>" width="37" height="12"></td>
            <td class="table_cell"><bean:message key="page.mail.memo.client" bundle="admin"/></td>
          </tr>
          <tr valign="top"> 
            <td nowrap class="table_cell">sina.com</td>
            <td class="table_cell">smtp.sina.com</td>
            <td class="table_cell">25</td>
            <td nowrap class="table_cell"><bean:message key="common.text.no"/></td>
            <td nowrap class="table_cell"><bean:message key="common.text.yes"/></td>
            <td nowrap class="table_cell"><img src="<html:rewrite page="/images/3.gif"/>" width="37" height="12"></td>
            <td class="table_cell"><bean:message key="page.mail.memo.client" bundle="admin"/></td>
          </tr>
          <tr valign="top"> 
            <td nowrap class="table_cell">yahoo.com.cn</td>
            <td class="table_cell">smtp.mail.yahoo.com.cn</td>
            <td class="table_cell">465</td>
            <td nowrap class="table_cell"><bean:message key="common.text.yes"/></td>
            <td nowrap class="table_cell"><bean:message key="common.text.no"/></td>
            <td nowrap class="table_cell">-</td>
            <td class="table_cell"><bean:message key="page.mail.memo.client" bundle="admin"/></td>
          </tr>
          <tr valign="top"> 
            <td nowrap class="table_cell">hotmail.com</td>
            <td class="table_cell">-</td>
            <td class="table_cell">-</td>
            <td nowrap class="table_cell">-</td>
            <td nowrap class="table_cell">-</td>
            <td nowrap class="table_cell">-</td>
            <td class="table_cell"><bean:message key="page.mail.memo.hotmail" bundle="admin"/></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="21" class="blackbold"><bean:message key="page.mail.attention" bundle="admin"/></td>
          </tr>
        </table>
        <br>
      </TD>
      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
    </TR>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=6><img src="<html:rewrite page="/images/rounded_bottom.gif"/>" width="778" height="5"></TD>
    </TR>
  </TBODY>
</TABLE>
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