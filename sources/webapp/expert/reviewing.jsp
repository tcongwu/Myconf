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
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:useBean id="uinfo" class="org.myconf.SessionUserObject" scope="request" />
<%
//*********************************
//variable
//*********************************
%>
<%
//expert reviewing
List reviews=ReviewDAO.listExpertReviews(uinfo.getId(), ReviewBean.REVIEW_STATUS_BEGIN);
ReviewBean review=null;
PaperBean paper=null;

//review date
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
Date begin=null;
Date end=null;
if(conf!=null){
	if(conf.getReviewBeginDate()>0){
		begin=new Date(conf.getReviewBeginDate());
	}
	if(conf.getReviewEndDate()>0){
		end=new Date(conf.getReviewEndDate());
	}
}
String beginStr=StringUtils.exportDate(begin, "yyyy-MM-dd HH:mm", "-- -- --");
String endStr=StringUtils.exportDate(end, "yyyy-MM-dd HH:mm", "-- -- --");
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
<jsp:include page="/expert/sub/mainmenu3.jsp" />
<br>
<script language="JavaScript">
function reviewPaper(rid) {
	window.open("<html:rewrite page="/expert/reviewpaper.jsp?id="/>"+rid, "review", "resizable=no,scrollbars=yes,height=600,width=800");
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
      	<%if(conf!=null && conf.getReviewBeginDate()<System.currentTimeMillis() && conf.getReviewEndDate()>System.currentTimeMillis()){%>
		<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td class="pagecontent_title"><b><bean:message key="menu.top.reviewing" bundle="expert"/></b></td>
          </tr>
        </table>
        <br>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
          <tr> 
            <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                <tr> 
                  <td> <li><bean:message key="page.reviewing.ins1" bundle="expert"/></li>
                    <li><bean:message key="page.reviewing.ins2" bundle="expert"/></li>
                    <li><bean:message key="page.reviewing.ins3" bundle="expert" arg0="<%=beginStr%>" arg1="<%=endStr%>"/></li></td>
                </tr>
              </table></td>
          </tr>
        </table>
        <table width="88%" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="52%"> <div class="spacer_20"></div>
              <div class="line_dashed"></div>
              <div class="spacer_10"></div></td>
          </tr>
        </table>
        <%if(reviews!=null && reviews.size()>0){%>
        <table width="88%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
          <tr> 
            <td width="6%" align="center" nowrap class="table_head"><bean:message key="common.text.no" bundle="admin"/></td>
            <td width="50%" class="table_head" nowrap><bean:message key="common.text.title" bundle="admin"/></td>
            <td width="32%" nowrap class="table_head"><bean:message key="common.text.subject" bundle="admin"/></td>
            <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.quit" bundle="expert"/></td>
            <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.review" bundle="expert"/></td>
          </tr>
          <%
          	for(int i=0;i<reviews.size();i++){
          	  review=(ReviewBean)reviews.get(i);
          	  paper=review.getPaper();
          %>
          <tr> 
            <td align="center" class="table_cell"><%=paper.getId()%></td>
            <td class="table_cell"><%=paper.getTitle()%></td>
            <td class="table_cell"><%=paper.getSubject().getSubject()%></td>
            <td align="center" class="table_cell"><a title="<bean:message key="common.text.quit" bundle="expert"/>" onClick="return confirm('<bean:message key="ins.confirm.quit"/>')" href="<html:rewrite page="/review.do?eventSubmit_Quit&id="/><%=review.getId()%>"><img src="<html:rewrite page="/images/quit.gif"/>" width="21" height="21" border="0"></a> 
            </td>
            <td align="center" class="table_cell"><a title="<bean:message key="common.text.review" bundle="expert"/>" href="javascript:reviewPaper(<%=review.getId()%>)"><img src="<html:rewrite page="/images/review.gif"/>" width="20" height="22" border="0"></a> 
            </td>
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
        <br>
        <%}else{%>
	  	<TABLE width=518 border=0 align="center" cellPadding=5 cellSpacing=0>
          <TBODY>
            <TR> 
              <TD align="center" style="font-size:16px;" class="redins"><bean:message key="common.ins.not.begin.review"/></TD>
            </TR>
          </TBODY>
        </TABLE> 
        <%}%>
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