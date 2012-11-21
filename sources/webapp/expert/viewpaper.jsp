<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="expert" />
<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.*" %>
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
//paper data
PaperBean paper=PaperDAO.getPaper(RequestUtils.getParam(request, "id", 0));
if(paper==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
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
<jsp:include page="/inc/logo_expert.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="common.title.bid" bundle="expert"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/bid.do"/>" method="post" name="bid" id="bid">
        <input name="eventSubmit_Add" type="hidden" id="eventSubmit_Add" value="1">
        <input name="id" type="hidden" id="id" value="<%=paper.getId()%>">
        <br>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="83%" class="form_row_bar"><bean:message key="common.title.paper.detail" bundle="admin"/></td>
            <td width="17%" align="right" class="form_row_bar"><div align="right"></div></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content_title"><table width="80%" border="0" align="center" cellpadding="0" cellspacing="6">
                <tr> 
                  <td align="center" class="blackbold"><%=paper.getTitle()%></td>
                </tr>
                <tr> 
                  <td><strong><bean:message key="page.paper.title.subject" bundle="admin"/></strong><%=paper.getSubject().getSubject()%></td>
                </tr>
                <tr> 
                  <td><strong><bean:message key="page.paperassign.title.abstract" bundle="admin"/></strong><%=paper.getAbstr()%></td>
                </tr>
              </table>
              
            </td>
          </tr>
        </table>
        <table width="90%" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="52%">&nbsp;</td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content_title"> &nbsp; 
              <input type="submit" id="sub" name="sub" value="<bean:message key="common.button.bid.paper"/>" class="button"> 
              &nbsp; <input name="Button" type="button" onClick="window.close()" class="button" value="<bean:message key="common.button.back"/>"></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td>&nbsp; </tr>
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