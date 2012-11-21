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
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

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
<jsp:include page="/inc/logo_site.jsp" />
<%
//*********************************
//content
//*********************************
%>
<script language="JavaScript">
function checkForm()
{
	if (discuss.title.value.length==0){
		alert("<bean:message key="error.staritem.not.null"/>");
		discuss.title.focus();
	    return false;
	}
	if (discuss.content.value.length==0){
		alert("<bean:message key="error.staritem.not.null"/>");
		discuss.content.focus();
	    return false;
	}
	return true;
}
</script>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="common.title.bbs"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent">
    <br>
    <table width="100%" border="0" cellpadding="0" cellspacing="6">
  	  <tr>
        <td align="right" valign="top"> <form action="<html:rewrite page="/bbs.do"/>" method="post" onsubmit="return checkForm();" name="discuss" id="discuss">
        	<input name="eventSubmit_JoinDiscuss" type="hidden" id="eventSubmit_JoinDiscuss" value="0">
        	<input name="parentId" type="hidden" id="parentId" value="0">
        	<input name="page" type="hidden" id="page" value="<%=StringUtils.exportString(request.getParameter("page"))%>">
        	<input name="fromPage" type="hidden" id="fromPage" value="/bbs/index1.jsp">
            <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td height="80"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><table width="100%" border="0" cellspacing="4" cellpadding="0">
							<tr>
							  <td class="bigblocktitle"><img src="<html:rewrite page="/images/orange_arrow.gif"/>" width="14" height="14"> 
								<bean:message key="common.button.issue.talk"/></td>
							</tr>
						  </table></td>
					  </tr>
					  <tr>
						<td><table width="100%" height="1" bgcolor="#000000" border="0" cellspacing="0" cellpadding="0">
							<tr>
							  <td></td>
							</tr>
						  </table></td>
					  </tr>
                    <tr> 
                      <td align="center">
						<table width="99%" border="0" cellspacing="8" cellpadding="0">
                          <tr> 
                                <td width="15%" align="right">*<bean:message key="common.bbs.title.subject"/></td>
                            <td width="85%"><input name="title" type="text" id="title" style="width:480px;"> 
                            </td>
                          </tr>
                          <tr> 
                            <td align="right" valign="top"> 
                              <table width="99%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                      <td height="22" align="right">*<bean:message key="common.bbs.title.content"/></td>
                                </tr>
                              </table></td>
                            <td><textarea name="content" rows="8" id="content" style="width:480px;"></textarea></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td align="center"> 
				  <table width="80%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                  		<input name="sub" type="submit" id="sub" value="<bean:message key="common.button.ok"/>">
                      	<input name="back" type="button" id="back" onClick="window.location='<html:rewrite page="/bbs/index.jsp?page="/><%=StringUtils.exportString(request.getParameter("page"))%>'" value="<bean:message key="common.button.back"/>"></td>
              		  </td>
                    </tr>
                  </table>
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