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
<%@ page import="java.util.*" %>
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
//paper statistics data
int[] stats=PaperDAO.statPaper();

List subjects=SubjectDAO.list();
List statuses=StatusDAO.list();
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
          <td class="pagecontent_title"><b><bean:message key="menu.left.export" bundle="admin"/></b></td>
        </tr>
        <tr> 
          <td align="right" class="pagecontent_right">&nbsp;</tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.export.ins1" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/paper.do"/>" method="post" target="_blank" name="xls" id="xls">
              <input name="eventSubmit_Export" type="hidden" id="eventSubmit_Export" value="1">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="18%" class="form_row_title"><bean:message key="page.paper.title.subject" bundle="admin"/></td>
                  <td class="form_row_content"><select name="subject" id="subject">
                      <option selected><bean:message key="common.list.please.select"/></option>
	                  <%
	                  	SubjectBean subject=null;
	                  	if((subjects!=null)&&(subjects.size()>0)){
	                  		for(int i=0;i<subjects.size();i++){
	                  			subject=(SubjectBean)subjects.get(i);
	                  %>
	                  <option value="<%=subject.getId()%>"><%=StringUtils.exportString(subject.getSubject())%></option>
	                  <%}}%>
                    </select></td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="18%" class="form_row_title"><bean:message key="common.title.accept.status" bundle="admin"/></td>
                  <td class="form_row_content"><select name="status" id="status">
                      <option selected><bean:message key="common.list.please.select"/></option>
	                  <%
	                  	StatusBean status=null;
	                  	if((statuses!=null)&&(statuses.size()>0)){
	                  		for(int i=0;i<statuses.size();i++){
	                  			status=(StatusBean)statuses.get(i);
	                  %>
	                  <option value="<%=status.getId()%>"><%=StringUtils.exportString(status.getStatus())%></option>
	                  <%}}%>
                    </select>
                  </td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td nowrap class="form_row_submit"><input name="sub" type="submit" class="button" id="sub" value="<bean:message key="common.button.export"/>">
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