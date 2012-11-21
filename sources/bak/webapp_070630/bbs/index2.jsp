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
Page pg=BBSDAO.getPageDiscuss(RequestUtils.getParam(request, "page", 0), Globals.PAGESIZE_20);
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
<jsp:include page="/inc/logo_admin.jsp" />
<%
//*********************************
//content
//*********************************
%>
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
      <form action="<html:rewrite page="/bbs.do"/>" method="post" name="bbs" id="bbs">
      <%if(pg!=null && pg.hasNext()){%>
	  <input name="fromPage" type="hidden" id="fromPage" value="/bbs/index2.jsp">
	  <input name="rowcnt" type="hidden" id="rowcnt" value="<%=pg.getCurPageRow()%>">
	  <input name="page" type="hidden" id="page" value="<%=pg.getCurPage()%>">
      <table width="96%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
        <tr> 
          <td width="5%" class="table_head" nowrap><bean:message key="common.text.choice"/></td>
          <td width="49%" class="table_head" nowrap><bean:message key="common.text.bbs.subject"/></td>
          <td width="16%" nowrap class="table_head"><bean:message key="common.text.bbs.author"/></td>
          <td width="16%" nowrap class="table_head"><bean:message key="common.text.bbs.publish.time"/></td>
          <td width="7%" align="center" class="table_head" nowrap><bean:message key="common.text.bbs.visit.count"/></td>
          <td width="7%" align="center" class="table_head" nowrap><bean:message key="common.text.bbs.reply.count"/></td>
        </tr>
        <%
          int i=0;
	      while(pg.hasNext()){
	        bbs=(BBSBean)pg.next();
	    %>
        <tr> 
          <td class="table_cell"><input name="id<%=i%>" type="checkbox" id="id<%=i%>" value="<%=bbs.getId()%>"></td>
          <td class="table_cell"><%if(bbs.getIsTop()==BBSBean.TRUE){%><font color=red><strong><bean:message key="common.text.bbs.top"/></strong></font><%}%><a class="blue" href="<html:rewrite page="/bbs/view2.jsp?id="/><%=bbs.getId()%>&page=<%=pg.getCurPage()%>"><%=bbs.getTitle()%></a></td>
          <td class="table_cell"><%=bbs.getAuthorName()%></td>
          <td nowrap class="table_cell"><%=StringUtils.exportDate(bbs.getCreateTime(), "yyyy-MM-dd HH:mm")%></td>
          <td align="center" class="table_cell"><%=bbs.getVisitCount()%></td>
          <td align="center" class="table_cell"><%=bbs.getReplyCount()%></td>
        </tr>
        <%i++;}%>
      </table>
      <table width="96%" border="0" align="center" cellpadding="5" cellspacing="0" style="border-bottom:#cccccc 1px solid">
        <tr> 
          <td align="right" nowrap><%=pg.getDigitalPane(request, "/bbs/index2.jsp")%></td>
        </tr>
      </table>
      <%}else{%>
      <table width="100%" border="0" cellpadding="5" cellspacing="0">
        <tr> 
          <td align="center" class="blackbold" nowrap><bean:message key="common.text.norecord"/></td>
        </tr>
      </table>
      <%}%>
      <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td>&nbsp;</td>
        </tr>
      </table>
      <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td> &nbsp; <input name="Button" type="button" class="button" onClick="window.location='<html:rewrite page="/bbs/begin2.jsp?page="/><%=pg.getCurPage()%>'" value="<bean:message key="common.button.issue.talk"/>"> 
            &nbsp;<input name="back" type="button" class="button" id="back" onClick="window.close()" value="<bean:message key="common.button.back"/>">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input name="eventSubmit_TopDiscuss" type="submit" id="eventSubmit_TopDiscuss" onClick="return confirm('<bean:message key="ins.confirm.top"/>')" value="<bean:message key="common.button.bbs.top"/>">
            <input name="eventSubmit_DeleteDiscuss" type="submit" id="eventSubmit_DeleteDiscuss" onClick="return confirm('<bean:message key="ins.confirm.delete"/>')" value="<bean:message key="common.button.bbs.delete"/>"></td>
        </tr>
      </table>
      </form>
      <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td>&nbsp;</td>
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