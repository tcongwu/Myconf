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
List statuses=StatusDAO.list();
StatusBean status=null;
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
          <td class="pagecontent_title"><b><bean:message key="menu.left.review" bundle="admin"/></b></td>
        </tr>
        <tr>
          <td align="right" class="pagecontent_right"><a href="<html:rewrite page="/admin/reviewins.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.reviewins" bundle="admin"/></a> 
            > <a href="<html:rewrite page="/admin/reviewrefer.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.refer" bundle="admin"/></a> 
            > <span class="pagemenu_visited"><bean:message key="menu.sub.top.status" bundle="admin"/></span> 
            > <a href="<html:rewrite page="/admin/reviewdate.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.reviewdate" bundle="admin"/></a></td>
        </tr>
      </table>
      <script language="JavaScript">
		function modStatus(id){
			addstatus.id.value=id;
			eval("addstatus.status.value=sta"+id+".value");
			if(id>0){
				addstatus.addmod.value="<bean:message key="common.button.modify"/>";
				hideLayer("next");
				showLayer("back");
			}else{
				addstatus.addmod.value="<bean:message key="common.button.add"/>";
				hideLayer("back");
				showLayer("next");
			}
		}
		function checkForm()
		{
			if (trim(addstatus.status.value).length == 0) {
				alert("<bean:message key="error.status.not.null"/>");
				addstatus.status.focus();
				return false;
			}
			return true;
		}
	  </script>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.reviewstatus.ins1" bundle="admin"/></li>
                  <li><bean:message key="page.reviewstatus.ins2" bundle="admin"/></li>
                  <li><bean:message key="page.reviewstatus.ins3" bundle="admin"/></li>
				  <li><bean:message key="page.reviewstatus.ins4" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/status.do"/>" method="post" name="addstatus" id="addstatus">
              <input name="id" type="hidden" id="id" value="0">
              <input name="eventSubmit_AddOrModify" type="hidden" id="eventSubmit_AddOrModify" value="0">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr>
                  <td width="20%" class="form_row_title"><bean:message key="page.reviewstatus.title.status" bundle="admin"/></td>
                  <td class="form_row_content"><input name="status" type="text" id="status" size="68"></td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td width="8%" nowrap class="form_row_submit"><input name="addmod" type="submit" class="button" id="addmod" value="<bean:message key="common.button.add"/>">
                  </td>
                  <td width="92%" nowrap class="form_row_submit"><input name="next" type="button" onClick="window.location='<html:rewrite page="/admin/reviewdate.jsp"/>'" class="button" id="next" value="<bean:message key="common.button.next.setting"/>"> 
                    <input name="back" type="button" onClick="modStatus(0)" class="button" style="display:none" id="back" value="<bean:message key="common.button.back.add"/>"> 
                  </td>
                </tr>
              </table>
            </form>
            <table width="100%" cellspacing="0" cellpadding="0">
              <tr>
                <td width="52%">
					<div class="spacer_20"></div>
					<div class="line_dashed"></div>
					<div class="spacer_10"></div>
				</td>
              </tr>
            </table>
			<input name="sta0" type="hidden" id="sta0" value=""/>
			<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
			  <tr> 
				  
                <td width="88%" class="table_head" nowrap><bean:message key="page.reviewstatus.text.status" bundle="admin"/></td>
				  <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.modify"/></td>
				  <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.delete"/></td>
			  </tr>
			  <%
				if(statuses!=null && statuses.size()>0){
				  for(int i=0;i<statuses.size();i++){
				  	status=(StatusBean)statuses.get(i);
			  %>
			  <tr> 
				<td class="table_cell"><%=status.getStatus()%>
				  <input name="sta<%=status.getId()%>" type="hidden" id="sta<%=status.getId()%>" value="<%=status.getStatus()%>"/></td>
                <td align="center" class="table_cell"><a title="<bean:message key="common.text.modify"/>" href="javascript:modStatus(<%=status.getId()%>)"><img src="<html:rewrite page="/images/sub_edit.gif"/>" width="21" height="21" border="0"></a></td>
                <td align="center" class="table_cell"><a title="<bean:message key="common.text.delete"/>" onClick="return confirm('<bean:message key="ins.confirm.delete"/>')" href="<html:rewrite page="/status.do?eventSubmit_Delete&id="/><%=status.getId()%>"><img src="<html:rewrite page="/images/sub_del.gif"/>" width="21" height="21" border="0"></a></td>
			  </tr>
			  <%}}%>
			</table></td>
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