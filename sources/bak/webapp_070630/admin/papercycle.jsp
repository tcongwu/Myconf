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
//paper statistics data
int[] stats=PaperDAO.statPaper();
int qs=ReviewDAO.countQuits();

//paper list
List papers=PaperDAO.queryPaper(PaperBean.PAPER_STATE_FORBIDDEN);
PaperBean paper=null;
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
          <td class="pagecontent_title"><b><bean:message key="menu.left.paper" bundle="admin"/></b></td>
        </tr>
        <tr> 
          <td align="right" class="pagecontent_right"><a href="<html:rewrite page="/admin/paper.jsp"/>" class="pagemenu"><bean:message key="menu.paper.top.all" bundle="admin"/>(<%=stats[0]%>)</a> 
            > <a href="<html:rewrite page="/admin/paperunassign.jsp"/>" class="pagemenu"><bean:message key="menu.paper.top.not.assign" bundle="admin"/>(<%=stats[PaperBean.PAPER_STATE_NORMAL]%>)</a> 
			> <a href="<html:rewrite page="/admin/paperassigned.jsp"/>" class="pagemenu"><bean:message key="menu.paper.top.assigned" bundle="admin"/>(<%=stats[PaperBean.PAPER_STATE_ASSIGNED]%>)</a> 
            > <a href="<html:rewrite page="/admin/paperquit.jsp"/>" class="pagemenu"><bean:message key="menu.paper.top.quit" bundle="admin"/>(<%=qs%>)</a> 
            > <span class="pagemenu_visited"><bean:message key="menu.paper.top.recycle" bundle="admin"/>(<%=stats[PaperBean.PAPER_STATE_FORBIDDEN]%>)</span></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.papercycle.ins1" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
			  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
				<tr> 
				  <td nowrap class="form_row_submit">&nbsp; </td>
				</tr>
			  </table>
            <table width="100%" cellspacing="0" cellpadding="0">
              <tr>
                <td width="52%">
					<div class="line_dashed"></div>
					<div class="spacer_10"></div>
				</td>
              </tr>
            </table>
			<script language="JavaScript">
			function recoverPaper(id) {
				reco.id.value=id;
				reco.submit();
			}
			</script>
            <form action="<html:rewrite page="/paper.do"/>" method="post" name="reco" id="reco">
		        <input name="fromPage" type="hidden" id="fromPage" value="/admin/papercycle.jsp">
		        <input name="eventSubmit_Recover" type="hidden" id="eventSubmit_Recover" value="1">
		        <input name="id" type="hidden" id="id" value="0">
            </form>
            <%if(papers!=null && papers.size()>0){%>
			<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
              <tr> 
                <td width="6%" align="center" nowrap class="table_head"><bean:message key="common.text.no" bundle="admin"/></td>
                <td width="58%" class="table_head" nowrap><bean:message key="common.text.title" bundle="admin"/></td>
                <td width="30%" nowrap class="table_head"><bean:message key="common.text.subject" bundle="admin"/></td>
                <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.recover"/></td>
              </tr>
              <%
              	for(int i=0;i<papers.size();i++){
              		paper=(PaperBean)papers.get(i);
              %>
              <tr> 
                <td align="center" class="table_cell"><%=paper.getId()%></td>
                <td class="table_cell"><a href="<html:rewrite page="/viewpaper.jsp?id="/><%=paper.getId()%>" target="_blank" title="<bean:message key="page.paper.link.ins.down" bundle="admin"/>" class="blue"><%=paper.getTitle()%></a></td>
                <td class="table_cell"><%=paper.getSubject().getSubject()%></td>
                <td align="center" nowrap class="table_cell"><a title="<bean:message key="common.text.recover"/>" onClick="return confirm('<bean:message key="ins.confirm.recover"/>')" href="javascript:recoverPaper(<%=paper.getId()%>)"><img src="<html:rewrite page="/images/recover.gif"/>" width="21" height="21" border="0"></td>
              </tr>
              <%}%>
            </table>
            <%}else{%>
            <table width="100%" border="0" cellpadding="5" cellspacing="0">
              <tr> 
                <td align="center" class="blackbold" nowrap><bean:message key="common.text.norecord"/></td>
              </tr>
            </table>
            <%}%>
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