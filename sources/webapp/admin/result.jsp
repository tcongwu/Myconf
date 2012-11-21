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
//current status id
int csid=RequestUtils.getParam(request, "sec", StatusBean.STATUS_DEFAULT);

//paper statistics data
Map stats=PaperDAO.statPaperByResult();

//status list
List statuses=StatusDAO.list();
StatusBean status=null;

int qs=ReviewDAO.countQuits();

//paper list
int pcount=stats.containsKey(new Integer(csid))?((Number)stats.get(new Integer(csid))).intValue():0;
Page pg=PaperDAO.queryPaper(request, RequestUtils.getParam(request, "page", 0), Globals.PAGESIZE_10);
PaperBean paper=null;

List subs=SubjectDAO.list();
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
	<script language="JavaScript">
	function reviewDetail(pid) {
		window.open("<html:rewrite page="/admin/resultdetail.jsp?id="/>"+pid, "review", "resizable=no,scrollbars=yes,height=600,width=800");
	}
	</script>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td class="pagecontent_title"><b><bean:message key="menu.left.result" bundle="admin"/></b></td>
        </tr>
        <tr> 
          <td align="right" class="pagecontent_right">
          	<%if(csid==StatusBean.STATUS_DEFAULT){%>
          	<span class="pagemenu_visited"><bean:message key="menu.result.top.undispose" bundle="admin"/>(<%=stats.containsKey(new Integer(StatusBean.STATUS_DEFAULT))?((Number)stats.get(new Integer(StatusBean.STATUS_DEFAULT))).intValue():0%>)</span> 
          	<%}else{%>
          	<a href="<html:rewrite page="/admin/result.jsp?sec="/><%=StatusBean.STATUS_DEFAULT%>" class="pagemenu"><bean:message key="menu.result.top.undispose" bundle="admin"/>(<%=stats.containsKey(new Integer(StatusBean.STATUS_DEFAULT))?((Number)stats.get(new Integer(StatusBean.STATUS_DEFAULT))).intValue():0%>)</a> 
          	<%}%>
          	<%
          	  if(statuses!=null && statuses.size()>0){
          	  	for(int i=0;i<statuses.size();i++){
          	  	  status=(StatusBean)statuses.get(i);
          	%>
          	<%if(csid==status.getId()){%>
          	> <span class="pagemenu_visited"><%=status.getStatus()%>(<%=stats.containsKey(new Integer(status.getId()))?((Number)stats.get(new Integer(status.getId()))).intValue():0%>)</span> 
          	<%}else{%>
          	> <a href="<html:rewrite page="/admin/result.jsp?sec="/><%=status.getId()%>" class="pagemenu"><%=status.getStatus()%>(<%=stats.containsKey(new Integer(status.getId()))?((Number)stats.get(new Integer(status.getId()))).intValue():0%>)</a> 
          	<%}%>
          	<%}}%>
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.result.ins1" bundle="admin"/></li>
                  <li><bean:message key="page.result.ins2" bundle="admin"/></li>
				  <li><bean:message key="page.result.ins3" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/admin/result.jsp"/>" method="post" name="search" id="search">
	          <input name="sec" type="hidden" id="sec" value="<%=csid%>">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="21%" class="form_row_title"><bean:message key="page.paper.title.no" bundle="admin"/></td>
                  <td class="form_row_content"><input name="pid" type="text" id="pid" size="18">
                    {<bean:message key="page.paper.ins6" bundle="admin"/>} </td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="21%" class="form_row_title"><bean:message key="page.paper.title.subject" bundle="admin"/></td>
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
                  <td width="21%" class="form_row_title"><bean:message key="page.paper.title.keyword" bundle="admin"/></td>
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
			<script language="JavaScript">
			function gradePaper(id, status) {
				result.id.value=id;
				result.status.value=status;
				result.submit();
			}
			</script>
            <form action="<html:rewrite page="/paper.do"/>" method="post" name="result" id="result">
		        <input name="fromPage" type="hidden" id="fromPage" value="/admin/result.jsp">
		        <input name="eventSubmit_Result" type="hidden" id="eventSubmit_Result" value="1">
		        <input name="pid" type="hidden" id="pid" value="<%=StringUtils.exportString(request.getParameter("pid"))%>">
		        <input name="subject" type="hidden" id="subject" value="<%=StringUtils.exportString(request.getParameter("subject"))%>">
		        <input name="keyword" type="hidden" id="keyword" value="<%=StringUtils.exportString(request.getParameter("keyword"))%>">
		        <input name="page" type="hidden" id="page" value="<%=StringUtils.exportString(request.getParameter("page"))%>">
		        <input name="status" type="hidden" id="status" value="0">
		        <input name="id" type="hidden" id="id" value="0">
		        <input name="sec" type="hidden" id="sec" value="<%=csid%>">
            </form>
            <%if(pg!=null && pg.hasNext()){%>
			<table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
              <tr> 
                <td width="6%" align="center" nowrap class="table_head"><bean:message key="common.text.no" bundle="admin"/></td>
                <td width="36%" class="table_head" nowrap><bean:message key="common.text.title" bundle="admin"/></td>
                <td width="23%" nowrap class="table_head"><bean:message key="common.text.subject" bundle="admin"/></td>
                <td width="17%" nowrap class="table_head"><bean:message key="common.text.result" bundle="admin"/></td>
                <td width="18%" class="table_head" nowrap><bean:message key="common.text.accept.paper" bundle="admin"/></td>
              </tr>
              <%
              	List reviews=null;
              	ReviewBean review=null;
              	while(pg.hasNext()){
              		paper=(PaperBean)pg.next();
              %>
              <tr> 
                <td align="center" valign="top" class="table_cell"><%=paper.getId()%></td>
                <td valign="top" class="table_cell"><a href="<html:rewrite page="/viewpaper.jsp?id="/><%=paper.getId()%>" target="_blank" title="<bean:message key="page.paper.link.ins.down" bundle="admin"/>" class="blue"><%=paper.getTitle()%></a></td>
                <td valign="top" class="table_cell"><%=paper.getSubject().getSubject()%></td>
                <td nowrap class="table_cell">
                <%
                  reviews=paper.getReviews();
                  if(reviews!=null && reviews.size()>0){
                  	for(int j=0;j<reviews.size();j++){
                  	  review=(ReviewBean)reviews.get(j);
                %>
                  #<%=j+1%>&nbsp;<%=StringUtils.exportString(StatusDAO.getStatusInMap(review.getRecoStatus()))%><br>
                <%}%>
                  <strong><a href="javascript:reviewDetail(<%=paper.getId()%>)" class="blue"><bean:message key="common.text.review.detail" bundle="admin"/></a></strong>
                <%}else{%>
                  <bean:message key="common.text.noreview" bundle="admin"/>
                <%}%>
                </td>
                <td valign="top" class="table_cell">
                  <select style="width:88px" name="grade" onChange="if(this.value.length>0){gradePaper(<%=paper.getId()%>, this.value);}">
                  	<%if(StringUtils.isEmpty(StatusDAO.getStatusInMap(paper.getStatus()))){%>
                    <option selected><bean:message key="common.list.please.select"/></option>
                    <%}else{%>
                    <option value="<%=paper.getStatus()%>" selected><%=StatusDAO.getStatusInMap(paper.getStatus())%></option>
                    <%}%>
	                <%
	                  if(statuses!=null && statuses.size()>0){
	                  	for(int j=0;j<statuses.size();j++){
	                  	  status=(StatusBean)statuses.get(j);
	                %>
                    <option value="<%=status.getId()%>"><%=status.getStatus()%></option>
                    <%}}%>
                  </select> </td>
              </tr>
              <%}%>
            </table>
            <table width="100%" border="0" cellpadding="5" cellspacing="0" style="border-bottom:#cccccc 1px solid">
              <tr> 
                <td align="right" nowrap><%=pg.getControlPane(request, "/admin/result.jsp")%></td>
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