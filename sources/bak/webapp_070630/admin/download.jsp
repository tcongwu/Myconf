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
//paper statistics data
int[] stats=PaperDAO.statPaper();

//paper list
Page pg=PaperDAO.queryPaper(request, -1, RequestUtils.getParam(request, "page", 0), Globals.PAGESIZE_10);
PaperBean paper=null;

List subs=SubjectDAO.list();
List stas=StatusDAO.list();
String names=null;
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
          <td align="right" class="pagecontent_right"><span class="pagemenu_visited"><bean:message key="menu.download.single" bundle="admin"/>(<%=stats[0]%>)</span> 
            > <a href="<html:rewrite page="/admin/downloadpack.jsp"/>" class="pagemenu"><bean:message key="menu.download.pack" bundle="admin"/></a></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.download.ins1" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/admin/download.jsp"/>" method="post" name="search" id="search">
	        <input name="fromPage" type="hidden" id="fromPage" value="/admin/download.jsp">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="18%" class="form_row_title"><bean:message key="page.paper.title.no" bundle="admin"/></td>
                  <td class="form_row_content"><input name="pid" type="text" id="pid" size="18">
                    {<bean:message key="page.paper.ins6" bundle="admin"/>} </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="18%" class="form_row_title"><bean:message key="page.paper.title.subject" bundle="admin"/></td>
                  <td class="form_row_content"><select name="subject" id="subject">
                      <option selected><bean:message key="common.list.please.select"/></option>
	                  <%
	                  	SubjectBean sub=null;
	                  	if((subs!=null)&&(subs.size()>0)){
	                  		for(int i=0;i<subs.size();i++){
	                  			sub=(SubjectBean)subs.get(i);
	                  %>
	                  <option value="<%=sub.getId()%>"><%=StringUtils.exportString(sub.getSubject())%></option>
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
	                  	StatusBean sta=null;
	                  	if((stas!=null)&&(stas.size()>0)){
	                  		for(int i=0;i<stas.size();i++){
	                  			sta=(StatusBean)stas.get(i);
	                  %>
	                  <option value="<%=sta.getId()%>"><%=StringUtils.exportString(sta.getStatus())%></option>
	                  <%}}%>
                    </select></td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="18%" class="form_row_title"><bean:message key="page.paper.title.keyword" bundle="admin"/></td>
                  <td class="form_row_content"><input name="keyword" type="text" id="keyword" size="28">
                    {<bean:message key="page.paper.ins7" bundle="admin"/>}</td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td nowrap class="form_row_submit"><input name="sub" type="submit" class="button" id="sub" value="<bean:message key="common.button.search.paper"/>">
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
            <%if(pg!=null && pg.hasNext()){%>
			<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
              <tr> 
                <td width="6%" align="center" nowrap class="table_head"><bean:message key="common.text.no" bundle="admin"/></td>
                <td width="48%" class="table_head" nowrap><bean:message key="common.text.title" bundle="admin"/></td>
                <td width="28%" nowrap class="table_head"><bean:message key="common.text.subject" bundle="admin"/></td>
                <td width="11%" nowrap class="table_head"><bean:message key="common.text.accept.status" bundle="admin"/></td>
                <td width="7%" align="center" class="table_head" nowrap><bean:message key="common.text.download"/></td>
              </tr>
              <%
              	while(pg.hasNext()){
              		paper=(PaperBean)pg.next();
              		names=paper.getExpertNameList();
              %>
              <tr> 
                <td align="center" class="table_cell"><%=paper.getId()%></td>
                <td class="table_cell"><%=paper.getTitle()%></td>
                <td class="table_cell"><a href="<html:rewrite page="/admin/download.jsp?subject="/><%=paper.getSubject().getId()%>" title="<bean:message key="page.paper.link.ins.subject" bundle="admin"/>"><%=paper.getSubject().getSubject()%></a></td>
                <td class="table_cell"><%=StringUtils.exportString(StatusDAO.getStatusInMap(paper.getStatus()))%></td>
                <td align="center" class="table_cell"><a title="<bean:message key="common.text.download"/>" href="<html:rewrite page="/viewpaper.jsp?id="/><%=paper.getId()%>" target="_blank"><img src="<html:rewrite page="/images/icon_down.gif"/>" width="21" height="21" border="0"></a></td>
              </tr>
              <%}%>
            </table>
            <table width="100%" border="0" cellpadding="5" cellspacing="0" style="border-bottom:#cccccc 1px solid">
              <tr> 
                <td align="right" nowrap><%=pg.getControlPane(request, "/admin/download.jsp")%></td>
              </tr>
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