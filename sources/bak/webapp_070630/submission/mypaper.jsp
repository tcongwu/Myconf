<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="author" />
<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.Globals" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.dao.*" %>
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
<jsp:useBean id="uinfo" class="org.myconf.SessionUserObject" scope="request" />
<%
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
List papers=PaperDAO.getPapersByUser(uinfo.getId());
int i=0;
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
<jsp:include page="/inc/logo_author.jsp" />
<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/submission/sub/mainmenu3.jsp" />
<br>
<script language="JavaScript">
function reviewDetail(pid) {
	window.open("<html:rewrite page="/submission/resultdetail.jsp?id="/>"+pid, "review", "resizable=no,scrollbars=yes,height=600,width=800");
}
</script>
<TABLE width=778 height="84" border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=5><img src="<html:rewrite page="/images/rounded_top.gif"/>" width="778" height="5"></TD>
    </TR>
    <TR> 
      <TD width=1 height="73" noWrap bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
      <TD width=776 vAlign=top noWrap><form action="/paper.do" method="post" enctype="multipart/form-data" onSubmit="return checkForm();" name="subform" id="subform">
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr> 
              <td class="pagecontent_title">
              	<b>
              	<%if(conf==null || conf.isStage()==ConfigBean.STAGE_NONE){%>
              	  <bean:message key="page.mypaper.stage.none" bundle="author" arg0="<%=Globals.getConfShortName()%>"/>
              	<%}else if(conf.isStage()==ConfigBean.STAGE_SUBMISSION){%>
              	  <bean:message key="page.mypaper.stage.submission" bundle="author" arg0="<%=conf.getFmSubBeginDate()%>" arg1="<%=conf.getFmSubEndDate()%>"/>
              	<%}else if(conf.isStage()==ConfigBean.STAGE_REVIEW){%>
              	  <bean:message key="page.mypaper.stage.review" bundle="author" arg0="<%=conf.getFmReviewBeginDate()%>" arg1="<%=conf.getFmReviewEndDate()%>"/>
              	<%}else if(conf.isStage()==ConfigBean.STAGE_CONFIRM){%>
              	  <bean:message key="page.mypaper.stage.confirm" bundle="author" arg0="<%=conf.getFmConBeginDate()%>" arg1="<%=conf.getFmConEndDate()%>"/>
              	<%}else if(conf.isStage()==ConfigBean.STAGE_DONE){%>
              	  <bean:message key="page.mypaper.stage.none" bundle="author" arg0="<%=Globals.getConfShortName()%>"/><bean:message key="page.mypaper.stage.done" bundle="author"/>
              	<%}%>
              	</b>
              </td>
            </tr>
          </table>
          <br>
          <input type="hidden" name="sid2" value="1"/>
          <input type="hidden" name="box2" value="-1"/>
          <input type="hidden" name="eventSubmit_DeleteSelected2" value=""/>
          <%if(papers!=null && papers.size()>0){%>
          <table width="96%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
            <tr> 
              <td width="5%" align="center" nowrap class="table_head"><bean:message key="page.mypaper.table.no" bundle="author"/></td>
              <td class="table_head" width="77%" nowrap><bean:message key="page.mypaper.table.title" bundle="author"/></td>
              <td class="table_head" width="9%" nowrap><bean:message key="pape.mypaper.table.status" bundle="author"/></td>
              <td class="table_head" width="9%" nowrap><bean:message key="common.text.do"/></td>
            </tr>
            <%
              PaperBean paper=null;
              for(i=0;i<papers.size();i++){
            	paper=(PaperBean)papers.get(i);
            %>
            <tr> 
              <td align="center" class="table_cell" nowrap><%=paper.getId()%></td>
              <td class="table_cell"><%=paper.getTitle()%></td>
              <td class="table_cell" nowrap>
              	<%if(conf!=null && conf.getIsOpen()==ConfigBean.TRUE){%>
              	  <%if(conf!=null && conf.getIsProcess()==ConfigBean.TRUE && paper.getStatus()!=-1){%>
              	  	<a href="javascript:reviewDetail(<%=paper.getId()%>)" class="blue">
              	  <%}%>
	              <%=StringUtils.exportString(StatusDAO.getStatusInMap(paper.getStatus()), Globals.getMessage("author", "pape.mypaper.status.reviewing"))%>
              	  <%if(conf!=null && conf.getIsProcess()==ConfigBean.TRUE && paper.getStatus()!=-1){%>
              	  	</a>
              	  <%}%>
              	<%}else if(conf==null || conf.isStage()==ConfigBean.STAGE_NONE || conf.isStage()==ConfigBean.STAGE_SUBMISSION){%>
	              <bean:message key="pape.mypaper.status.forreview" bundle="author"/>
              	<%}else if(conf.isStage()==ConfigBean.STAGE_REVIEW){%>
	              <bean:message key="pape.mypaper.status.reviewing" bundle="author"/>
              	<%}else if(conf.isStage()==ConfigBean.STAGE_CONFIRM || conf.isStage()==ConfigBean.STAGE_DONE){%>
	              <bean:message key="pape.mypaper.status.reviewed" bundle="author"/>
              	<%}%>
              </td>
              <td class="table_cell" nowrap>
              	<%if(conf!=null && conf.isStage()==ConfigBean.STAGE_SUBMISSION && conf.getIsOpen()!=ConfigBean.TRUE){%>
              	  <a href="<html:rewrite page="/submission/modpaper.jsp?id="/><%=paper.getId()%>"><img src="<html:rewrite page="/images/sub_edit.gif"/>" width="21" height="21" border="0"></a>&nbsp; 
                  <a onClick="return confirm('<bean:message key="ins.confirm.delete"/>')" href="<html:rewrite page="/paper.do?eventSubmit_DelPaper&id="/><%=paper.getId()%>"><img src="<html:rewrite page="/images/sub_del.gif"/>" width="21" height="21" border="0"></a> 
              	<%}else if(conf!=null && conf.isStage()==ConfigBean.STAGE_CONFIRM && conf.getIsOpen()==ConfigBean.TRUE){%>
	              <a class="blue" href="<html:rewrite page="/submission/modpaper.jsp?id="/><%=paper.getId()%>"><bean:message key="page.mypaper.do.confirm" bundle="author"/></a>
              	<%}%>
              </td>
            </tr>
            <%}%>
          </table>
          <%}%>
          <p>&nbsp;</p>
          </form>
        
      </TD>
      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
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