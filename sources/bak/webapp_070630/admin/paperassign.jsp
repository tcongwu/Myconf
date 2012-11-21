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
//paper data
PaperBean paper=PaperDAO.getPaper(RequestUtils.getParam(request, "id", 0));
if(paper==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
//paper authors
List authors=paper.getAuthors();
if(authors==null || authors.size()==0){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

//paper review experts
HashMap rexp=paper.getExpertMap();

//quit experts
String qex=paper.getQuitExpertNameList();

//expert list
List experts=UserDAO.listExperts();
%>

<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />

<body onLoad="listExpert()">
<%
//*********************************
//top
//*********************************
%>
<jsp:include page="/inc/logo_admin.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.paperassign.title" bundle="admin"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<script language="JavaScript">
function listExpert(){
	var nameList="";
	if(assign.expertId==null){
		return;
	}
	if(assign.expertId.length==null){
		if(assign.expertId.checked){
			eval("nameList=assign.expertName"+i+"value");
		}
	}else{
		for(var i=0;i<assign.expertId.length;i++){
			if(assign.expertId[i].checked){
				if(nameList==""){
					eval("nameList=assign.expertName"+assign.expertId[i].value+".value");
				}else{
					eval("nameList=nameList+', '+assign.expertName"+assign.expertId[i].value+".value");
				}
			}
		}
	}
	expertList.innerText=nameList;
}
</script>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/paper.do"/>" method="post" name="assign" id="assign">
        <input name="eventSubmit_Assign" type="hidden" id="eventSubmit_Assign" value="1">
        <input name="id" type="hidden" id="id" value="<%=paper.getId()%>">
        <br>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
          <tr>
            <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                <tr> 
                  <td> <li><bean:message key="page.paperassign.ins1" bundle="admin"/></li>
                    <li><bean:message key="page.paperassign.ins2" bundle="admin"/></li>
                    <li><bean:message key="page.paperassign.ins3" bundle="admin"/></li>
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" class="form_row_title"><bean:message key="page.paperassign.title.title" bundle="admin"/></td>
            <td class="form_row_content_title"><%=paper.getTitle()%></td>
          </tr>
        </table>
        <%
          AuthorBean author=null;
		  for(int i=0;i<authors.size();i++){
		  	author=(AuthorBean)authors.get(i);
        %>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" class="form_row_title"><bean:message key="page.paperassign.title.author" bundle="admin" arg0="<%=String.valueOf(author.getOrderNo())%>"/></td>
            <td class="form_row_content_author"><%=author.toString()%></td>
          </tr>
        </table>
        <%}%>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" class="form_row_title"><bean:message key="page.paper.title.subject" bundle="admin"/></td>
            <td class="form_row_content_title"><%=paper.getSubject().getSubject()%></td>
          </tr>
        </table>
        <table id="confirm" width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" valign="top" class="form_row_title"><bean:message key="page.paperassign.title.abstract" bundle="admin"/></td>
            <td class="form_row_content_abstract"><font color="#000000"><pre><%=paper.getAbstr()%></pre></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" class="form_row_title"><bean:message key="page.paperassign.title.bid" bundle="admin"/></td>
            <td class="form_row_content_abstract"><%=paper.getBidNameList()%></td>
          </tr>
        </table>
        <%if(StringUtils.isNotEmpty(qex)){%>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" class="form_row_title"><bean:message key="common.text.quitexpert" bundle="admin"/></td>
            <td class="form_row_content_abstract"><%=qex%></td>
          </tr>
        </table>
        <%}%>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" class="form_row_title"><bean:message key="page.paperassign.title.expert" bundle="admin"/></td>
            <td class="form_row_content_title" id="expertList"></td>
          </tr>
        </table>
        <table width="90%" align="center" cellpadding="0" cellspacing="0" class="line_solid">
          <tr> 
            <td width="52%"> <div class="spacer_20"></div>
              <div class="line_dashed"></div>
              <div class="spacer_10"></div></td>
          </tr>
        </table>
        <%if(experts!=null && experts.size()>0){%>
        <table width="90%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
          <tr> 
            <td width="5%" align="center" nowrap class="table_head"><bean:message key="common.text.choice"/></td>
            <td width="14%" class="table_head" nowrap><bean:message key="common.text.expertname" bundle="admin"/></td>
            <td width="22%" nowrap class="table_head"><bean:message key="common.text.worklocation" bundle="admin"/></td>
            <td width="30%" nowrap class="table_head"><bean:message key="common.text.research" bundle="admin"/></td>
            <td width="22%" class="table_head" nowrap><bean:message key="common.text.email" bundle="admin"/></td>
            <td width="7%" align="center" nowrap class="table_head"><bean:message key="common.text.papernum" bundle="admin"/></td>
          </tr>
          <%
          	UserBean expert=null;
          	for(int i=0;i<experts.size();i++){
          	  expert=(UserBean)experts.get(i);
          %>
          <tr> 
            <td align="center" class="table_cell"><input name="expertId" type="checkbox" id="expertId" onClick="listExpert()" value="<%=expert.getId()%>"<%if(rexp!=null && rexp.get(new Integer(expert.getId()))!=null){out.print(" checked");}%>></td>
            <td class="table_cell"><%=expert.getName().toString()%> 
              <input name="expertName<%=expert.getId()%>" type="hidden" id="expertName<%=expert.getId()%>" value="<%=expert.getName().toString()%>"/>
            </td>
            <td class="table_cell"><%=StringUtils.exportString(expert.getWorkLocation())%></td>
            <td class="table_cell"><%=StringUtils.exportString(expert.getResearch())%></td>
            <td class="table_cell"><%=expert.getEmail()%></td>
            <td align="center" class="table_cell"><%=expert.getReviews().size()%></td>
          </tr>
          <%}%>
       </table>
        <%}%>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td class="form_row_submit"><input type="submit" id="sb" name="save" value="<bean:message key="common.button.ok"/>" class="button"> 
              <input name="Button" type="button" onClick="window.close()" class="button" value="<bean:message key="common.button.back"/>"> 
          </tr>
        </table>
        <br>
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