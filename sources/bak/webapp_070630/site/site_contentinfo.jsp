<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="site" />


<%
//*********************************
//define
//*********************************
%>

<%@ page import="org.myconf.beans.ContentBean" %>
<%@ page import="org.myconf.dao.ContentDAO" %>
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


<body >
<jsp:include page="/inc/top.jsp" />
<jsp:include page="/inc/logo_site.jsp" />


<%
int contentId=RequestUtils.getParam(request, "contentId", 0);
ContentBean cbean=ContentDAO.getContentByID(contentId);
%>

<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.site.content_info"  bundle="site"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>


 
 <table width="778" border="0" cellpadding="0" cellspacing="0"  align="center" class="form">
  <tr>
    <td><div class="spacer_5"></div>
	 &nbsp;
	<div class="spacer_5"></div></td>
  </tr>
 </table>
 
  <div class="spacer_1"></div>
		
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr>
                  <td width="15%" class="form_row_title"><bean:message key="page.site.content_title1" bundle="site" /> </td>
                  <td width="85%" class="form_row_content">&nbsp;
                    <%=StringUtils.exportString(cbean.getTitle())%> 
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	  
	   
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" >
                <tr>
                 
                  <td width="100%" class="form_row_submit" align="center">
                   <%=StringUtils.exportString(cbean.getPagetext())%>
							
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	  
	   <table  width="778" border="0" cellpadding="0" cellspacing="0" class="form_row" align="center">
        <tr align="center"> 
          <td class="form_row_submit" >
          	<input name="Submit" onClick="window.close();"   type="button" class="button" value="<bean:message key='page.site.content_info_close' bundle='site'/>" >
          </td></tr>
      </table>
<div class="spacer_20"></div>
<%
//**********************************
//footer
//**********************************
%>
<jsp:include page="/inc/footer.jsp" />
</body>
</html>

