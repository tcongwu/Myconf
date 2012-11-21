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
<%@ page import="org.myconf.util.*" %>
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
          <td class="pagecontent_title"><b><bean:message key="menu.left.submission" bundle="admin"/></b></td>
        </tr>
        <tr>
          <td align="right" class="pagecontent_right"><span class="pagemenu_visited"><bean:message key="menu.sub.top.ins" bundle="admin"/></span> > 
                <a href="<html:rewrite page="/admin/subsubject.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.subject" bundle="admin"/></a> > 
                <a href="<html:rewrite page="/admin/subformat.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.format" bundle="admin"/></a> > 
                <a href="<html:rewrite page="/admin/subsize.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.size" bundle="admin"/></a> > 
				<a href="<html:rewrite page="/admin/subdate.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.subdate" bundle="admin"/></a> > 
				<a href="<html:rewrite page="/admin/subcondate.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.confirmdate" bundle="admin"/></a></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.subins.ins1" bundle="admin"/></li>
				  <li><bean:message key="page.subins.ins2" bundle="admin"/></li>
                  <li><bean:message key="page.subins.ins3" bundle="admin"/></li>
        		<div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/config.do"/>" method="post" name="subins" id="subins">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_content"><div class="spacer_5"></div>
    				<input name="eventSubmit_Save" type="hidden" id="eventSubmit_Save" value="1">
    				<input name="fromPage" type="hidden" id="fromPage" value="">
                    <textarea name="subIns" id="subIns" style="width:80%;height:280px"><%if(conf!=null){out.print(StringUtils.exportString(conf.getSubIns()));}%></textarea>
    				<div class="spacer_5"></div></td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_submit"><input name="save" onClick="subins.fromPage.value='/admin/subins.jsp';" type="submit" class="button" id="save" value="<bean:message key="common.button.save"/>">
                    <input name="next" onClick="subins.fromPage.value='/admin/subsubject.jsp';" type="submit" class="button" id="next" value="<bean:message key="common.button.save.and.next"/>">
                  </td>
                </tr>
              </table>
            </form></td>
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