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
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.util.StringUtils" %>
<%@ page import="org.myconf.util.RequestUtils" %>
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
//paper pages
Page pg=PaperDAO.queryPaper(request, -1, RequestUtils.getParam(request, "page", 0), Globals.PAGESIZE_20);
PaperBean paper=null;

List subs=SubjectDAO.list();
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
<jsp:include page="/inc/logo_expert.jsp" />
<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/expert/sub/mainmenu2.jsp" />
<br>
<script language="JavaScript">
function viewPaper(pid) {
	window.open("<html:rewrite page="/expert/viewpaper.jsp?id="/>"+pid, "paper", "resizable=no,scrollbars=yes,height=600,width=800");
}
</script>
<TABLE width=778 height="84" border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=5><img src="<html:rewrite page="/images/rounded_top.gif"/>" width="778" height="5"></TD>
    </TR>
    <TR> 
      <TD width=1 height="73" noWrap bgColor=#a9a9a9></TD>
      <TD width=776 noWrap>
		<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td class="pagecontent_title"><b><bean:message key="menu.top.bid" bundle="expert"/></b></td>
          </tr>
        </table>
        <form action="<html:rewrite page="/expert/bid.jsp"/>" method="post" name="bid" id="bid">
          <br>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
            <tr> 
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                  <tr> 
                    <td><li><bean:message key="page.paper.ins1" bundle="admin"/></li></td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title"><bean:message key="page.paper.title.no" bundle="admin"/></td>
              <td class="form_row_content"><input name="id" type="text" id="id" size="18">
                {<bean:message key="page.paper.ins6" bundle="admin"/>} </td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
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
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title"><bean:message key="page.paper.title.keyword" bundle="admin"/></td>
              <td class="form_row_content"><input name="keyword" type="text" id="keyword" size="28">
                {<bean:message key="page.paper.ins7" bundle="admin"/>}</td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td nowrap class="form_row_submit"><input name="sub" type="submit" class="button" id="sub" value="<bean:message key="common.button.search.paper"/>"> 
              </td>
            </tr>
          </table>
        </form>
        <table width="88%" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="52%"> <div class="spacer_20"></div>
              <div class="line_dashed"></div>
              <div class="spacer_10"></div></td>
          </tr>
        </table>
        <%if(pg!=null && pg.hasNext()){%>
        <table width="88%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
          <tr> 
            <td width="7%" align="center" nowrap class="table_head"><bean:message key="common.text.no" bundle="admin"/></td>
            <td width="55%" class="table_head" nowrap><bean:message key="common.text.title" bundle="admin"/></td>
            <td width="32%" nowrap class="table_head"><bean:message key="common.text.subject" bundle="admin"/></td>
            <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.view"/></td>
          </tr>
          <%
          	while(pg.hasNext()){
          	  paper=(PaperBean)pg.next();
          %>
          <tr> 
            <td align="center" class="table_cell"><%=paper.getId()%></td>
            <td class="table_cell"><%=paper.getTitle()%></td>
            <td class="table_cell"><%=paper.getSubject().getSubject()%></td>
            <td align="center" class="table_cell"><a title="<bean:message key="common.text.view"/>" href="javascript:viewPaper(<%=paper.getId()%>)"><img src="<html:rewrite page="/images/bid.gif"/>" width="22" height="20" border="0"></a> 
            </td>
          </tr>
          <%}%>
        </table>
        <%if(pg.getPageCount()>1){%>
        <table width="88%" border="0" align="center" cellpadding="5" cellspacing="0" style="border-bottom:#cccccc 1px solid">
          <tr> 
            <td align="right" nowrap><%=pg.getControlPane(request, "/expert/bid.jsp")%></td>
          </tr>
        </table>
        <%}%>
        <%}else{%>
        <table width="100%" border="0" cellpadding="5" cellspacing="0">
          <tr> 
            <td align="center" class="blackbold" nowrap><bean:message key="common.text.norecord"/></td>
          </tr>
        </table>
        <%}%>
        <br>
      </TD>
      <TD noWrap width=1 bgColor=#a9a9a9></TD>
    </TR>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=6><img src="<html:rewrite page="/images/rounded_bottom.gif"/>" width="778" height="5"></TD>
    </TR>
  </TBODY>
</TABLE>
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