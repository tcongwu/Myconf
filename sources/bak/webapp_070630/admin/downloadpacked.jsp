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
<jsp:useBean id="status" class="org.myconf.beans.StatusBean" scope="request" />
<jsp:useBean id="subject" class="org.myconf.beans.SubjectBean" scope="request" />
<jsp:useBean id="sum" class="java.lang.String" scope="request" />
<jsp:useBean id="zipFile" class="java.lang.String" scope="request" />
<%
//paper statistics data
int[] stats=PaperDAO.statPaper();

//instruction initial
String statusName=Globals.getMessage("common", "common.text.all");
if(status!=null && StringUtils.isNotEmpty(status.getStatus())){
	statusName=status.getStatus();
}
String subjectName=Globals.getMessage("common", "common.text.all");
if(subject!=null && StringUtils.isNotEmpty(subject.getSubject())){
	subjectName=subject.getSubject();
}
zipFile=Globals.root(request)+Globals.PAPER_ROOT_WEB+"/zip/"+zipFile;
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
          <td class="pagecontent_title"><b><bean:message key="menu.left.download" bundle="admin"/></b></td>
        </tr>
        <tr> 
          <td align="right" class="pagecontent_right">
          	<a href="<html:rewrite page="/admin/download.jsp"/>" class="pagemenu"><bean:message key="menu.download.single" bundle="admin"/>(<%=stats[0]%>)</a> 
            > <span class="pagemenu_visited"><bean:message key="menu.download.pack" bundle="admin"/></span></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td> <table width="100%" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="52%"> <div class="spacer_20"></div></td>
              </tr>
            </table>
            <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
              <tr> 
                <td colspan="3" nowrap class="table_head"><strong><bean:message key="page.downloadpacked.downloading" bundle="admin"/></strong></td>
              </tr>
              <tr> 
                <td colspan="3" valign="top" class="table_cell"><table width="92%" border="0" align="center" cellpadding="0" cellspacing="8">
                    <tr>
                      <td><bean:message key="page.downloadpacked.ins" bundle="admin" arg0="<%=subjectName%>" arg1="<%=statusName%>" arg2="<%=sum%>"/></td>
                    </tr>
                    <tr>
                      <td><bean:message key="page.downloadpacked.redownload" bundle="admin" arg0="<%=zipFile%>"/></td>
                    </tr>
                    <tr>
                      <td><bean:message key="page.downloadpacked.back" bundle="admin"/><a href="<html:rewrite page="/admin/downloadpack.jsp"/>" class="blue"><bean:message key="common.button.back"/></a></td>
                    </tr>
                  </table>
				  <iframe src="<%=zipFile%>" width="0" height="0"></iframe>
                  </td>
              </tr>
            </table>
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