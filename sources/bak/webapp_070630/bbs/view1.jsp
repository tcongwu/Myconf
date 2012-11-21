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
<%@ page import="org.myconf.*" %>
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
//bbs data
int id=RequestUtils.getParam(request, "id", 0);
List list=BBSDAO.getDiscuss(id);
if((list==null)||(list.size()==0)){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
String defaultTitle=null;
BBSBean bbs=null;
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
	<%
	  for(int i=0;i<list.size();i++){
		bbs=(BBSBean)list.get(i);
		if(i==0){
			defaultTitle="RE:"+bbs.getTitle();
		}
	%>
    <br>
    <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td class="discussblock"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="20" class="discusstitle"><table width="100%" border="0" cellspacing="3" cellpadding="0">
                  <tr>
                    <td width="5%"><img src="<html:rewrite page="/images/cloud.gif"/>" width="22" height="17"></td>
                    <td width="78%" valign="middle"><strong><%=bbs.getTitle()%></strong></td>
                    <td width="17%" align="right" class="textgrey"><%if(i==0){%><bean:message key="common.text.bbs.master"/><%}else{%><bean:message key="common.text.bbs.ceng" arg0="<%=String.valueOf(i)%>"/><%}%></td>
                  </tr>
                </table></td>
            </tr>
            <tr>
              <td><table width="100%" border="0" cellspacing="6" cellpadding="0">
                  <tr> 
                    <td valign="top"><%=bbs.getContent().replaceAll("\r","<br>")%></td>
                  </tr>
                </table></td>
            </tr>
            <tr>
              <td><table width="100%" border="0" cellspacing="5" cellpadding="0">
                  <tr>
                    <td width="33%">&nbsp;</td>
                    <td width="29%"><%if(i==0){%><bean:message key="common.text.bbs.beginer"/><%}else{%><bean:message key="common.text.bbs.replyer"/><%}%><font color="#3300CC"><%=bbs.getAuthorName()%></font></td>
                    <td width="38%" class="textgrey"><bean:message key="common.bbs.title.issue.time"/><%=StringUtils.exportDate(bbs.getCreateTime(), "yyyy-MM-dd HH:mm")%></td>
                  </tr>
                </table></td>
            </tr>
          </table></td>
      </tr>
    </table>
    <%}%>
    <br>
    <table width="100%" border="0" cellpadding="0" cellspacing="6">
  	  <tr>
        <td align="right" valign="top"> <form action="<html:rewrite page="/bbs.do"/>" method="post" onsubmit="return checkForm();" name="discuss" id="discuss">
        	<input name="id" type="hidden" id="id" value="<%=id%>">
        	<input name="eventSubmit_JoinDiscuss" type="hidden" id="eventSubmit_JoinDiscuss" value="0">
        	<input name="parentId" type="hidden" id="parentId" value="<%=id%>">
        	<input name="page" type="hidden" id="page" value="<%=StringUtils.exportString(request.getParameter("page"))%>">
        	<input name="fromPage" type="hidden" id="fromPage" value="/bbs/view1.jsp">
            <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td height="80"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<td><table width="100%" border="0" cellspacing="4" cellpadding="0">
							<tr>
							  <td class="bigblocktitle"><img src="<html:rewrite page="/images/orange_arrow.gif"/>" width="14" height="14"> 
								<bean:message key="common.text.bbs.reply"/></td>
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
                            <td width="85%"><input name="title" type="text" id="title" style="width:480px;" value="<%=defaultTitle%>"> 
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
                  		<input name="sub" type="submit" id="sub" value="<bean:message key="common.text.bbs.reply"/>">
                      	<input name="back" type="button" id="back" onClick="window.location='<html:rewrite page="/bbs/index1.jsp?page="/><%=StringUtils.exportString(request.getParameter("page"))%>'" value="<bean:message key="common.button.back"/>"></td>
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