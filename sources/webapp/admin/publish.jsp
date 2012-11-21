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
<jsp:include page="/admin/sub/mainmenu1.jsp" />
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr>
    <td width="180" height="55" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenu">
        <tr> 
          <td height="41">
			<jsp:include page="/admin/sub/leftmenu1.jsp" />
			<jsp:include page="/inc/stat.jsp" />
          </td>
        </tr>
      </table></td>
    <td width="598" valign="top" class="pagecontent">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="pagecontent_title"><b><bean:message key="menu.left.publish" bundle="admin"/></b></td>
        </tr>
        <tr>
          <td height="15" align="right"></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li class="redins"><bean:message key="page.publish.ins1" bundle="admin"/></li>
				  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/config.do"/>" method="post" name="pub" id="pub">
              <input name="eventSubmit_Save" type="hidden" id="eventSubmit_Save" value="0">
              <input name="fromPage" type="hidden" id="fromPage" value="/admin/publish.jsp">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="25%" class="form_row_title"><bean:message key="page.publish.title.pub" bundle="admin"/></td>
                  <td class="form_row_content">&nbsp;&nbsp;{<bean:message key="page.publish.ins2" bundle="admin"/>}</td>
                </tr>
              </table>
		      <script language="JavaScript">
				function checkOpen(obj){
					if(obj.checked){
						pub.isOpen.value=<%=ConfigBean.TRUE%>;
					}else{
						pub.isOpen.value=<%=ConfigBean.FALSE%>;
					}
				}
			  </script>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_content">
				  	<div class="spacer_5"></div>
                      
                    <input name="isOpen" type="hidden" id="isOpen" value="<%=conf.getIsOpen()%>">
                    <input name="chkOpen" type="checkbox" onClick="checkOpen(this)" id="chkOpen" value="1"<%if(conf.getIsOpen()==ConfigBean.TRUE){out.print("checked");}%>>
                    <bean:message key="page.publish.checkbox.pub" bundle="admin"/> 
                    <div class="spacer_5"></div>
					</td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr>
                  <td width="25%" class="form_row_title"><bean:message key="page.publish.title.pro" bundle="admin"/></td>
                  <td class="form_row_content">&nbsp;</td>
                </tr>
              </table>
		      <script language="JavaScript">
				function checkProcess(obj){
					if(obj.checked){
						pub.isProcess.value=<%=ConfigBean.TRUE%>;
					}else{
						pub.isProcess.value=<%=ConfigBean.FALSE%>;
					}
				}
			  </script>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_content"> <div class="spacer_5"></div>
                    <input name="isProcess" type="hidden" id="isProcess" value="<%=conf.getIsProcess()%>">
                    <input name="chkProcess" type="checkbox" onClick="checkProcess(this)" id="chkProcess" value="1"<%if(conf.getIsProcess()==ConfigBean.TRUE){out.print("checked");}%>>
                    <bean:message key="page.publish.checkbox.pro" bundle="admin"/> 
                    <div class="spacer_5"></div></td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_submit"><input name="sub" onClick="return confirm('<%if(!PaperDAO.isFinish()){%><bean:message key="error.not.finished.review"/>\\n\n<%}%><bean:message key="ins.confirm.publish"/>')" type="submit" class="button" id="sub" value="<bean:message key="common.button.ok"/>">
                  </td>
                </tr>
              </table>
            </form>
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