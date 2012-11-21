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
<%@ page import="org.myconf.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%
	 String version=StringUtils.exportString(request.getParameter("version"));
%>

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


<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.site.chooseversion"  bundle="site"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>


<table width="778" border="0" cellpadding="0" cellspacing="0"  align="center">
  <tr>
    <td><div class="spacer_5"></div>
	 &nbsp;
	<div class="spacer_5"></div></td>
  </tr>
 </table>
 <table width="778" border="0" cellpadding="0" cellspacing="0" class="form" align="center">
     <tr>
       <td><table width="778" border="0" cellpadding="0" cellspacing="0" class="form_note" align="center">
 			 <tr>
   				 <td><div class="spacer_5"></div>
	 				 <li><bean:message key="page.site.versionpoint1" bundle="site"/></li>
	 				 <li><bean:message key="page.site.versionpoint2" bundle="site"/></li>
    				 <div class="spacer_5"></div>
    			</td>
 			 </tr>
		 </table>
 		</td>
 	</tr>
 </table>
 
 <table width="778" border="0" cellpadding="0" cellspacing="0"  align="center" class="form">
  <tr>
    <td><div class="spacer_5"></div>
	 &nbsp;
	<div class="spacer_5"></div></td>
  </tr>
 </table>
 
  
<form name="form1" method="get" action="site_in.jsp" >
      <table width="778"  border="0" cellpadding="0" cellspacing="1" class="table" align="center">
			<tr class="table_head"> 
			  <td width="33%" align="center" nowrap><%=org.myconf.Globals.LANGUAGE_SIMPLIFIED%> <input type="radio"  name="version" value="zh_cn" <%if(version.equals("zh_cn")||version.equals(""))out.println("checked");%>> </td>
			  <td width="33%" align="center" nowrap><%=org.myconf.Globals.LANGUAGE_TRADITIONAL%> <input type="radio" name="version" value="zh_tw" <%if(version.equals("zh_tw"))out.println("checked");%>></td>
			   <td width="33%" align="center" nowrap><%=org.myconf.Globals.LANGUAGE_ENGLISH%>   <input type="radio" name="version"  value="english"  <%if(version.equals("english"))out.println("checked");%>></td>
		    </tr>		
	  </table>
      <table  width="778" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr align="center"> 
          <td class="form_row_submit" >
          	<input name="Submit" type="submit" class="button" value="<bean:message key='page.site.subimt' bundle='site'/>" >
          </td></tr>
      </table>
</form>
<div class="spacer_20"></div>
<%
//**********************************
//footer
//**********************************
%>
<jsp:include page="/inc/footer.jsp" />
</body>
</html>
