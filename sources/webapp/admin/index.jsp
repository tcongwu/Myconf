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
<%@ page import="org.myconf.beans.base.*" %>
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
SiteStatInfo ssi=StatTool.getSiteStatInfo();
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
if(conf==null)
	conf=new ConfigBean();
	
	out.println("conf.getStageName="+conf.getStageName());
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
    <td width="598" valign="top" class="pagecontent"><table width="100%" border="0" cellpadding="0" cellspacing="2" class="panel">
        <tr> 
          <td class="panel_head"><bean:message key="page.home.aboutconf" bundle="admin"/></td>
        </tr>
        <tr>
          <td><table width="100%" border="0" cellspacing="2" cellpadding="0">
              <tr>
                <td><DIV class=spacer_1></DIV></DIV>
					<DIV class=panel_top><bean:message key="page.home.current" bundle="admin" arg0="<%=conf.getStageName()%>"/></DIV>
					
                  <DIV 
					class=panel_top_body><bean:message key="page.home.explain" bundle="admin"/></DIV></td>
              </tr>
              <tr>
                <td><DIV class=spacer_5></DIV>
					<DIV class=line_dashed></DIV></td>
              </tr>
              <tr>
                <td><DIV class=panel_body><IMG src="<html:rewrite page="/images/arrow.gif"/>" width="3" height="5"	border=0 align=absMiddle> 
                	<bean:message key="page.home.submission" bundle="admin" arg0="<%=StringUtils.exportDate(conf.getSubBeginDate(), "yyyy-MM-dd","-- -- --")%>" arg1="<%=StringUtils.exportDate(conf.getSubEndDate(), "yyyy-MM-dd","-- -- --")%>"/>&nbsp;&nbsp;[<A href="<html:rewrite page="/admin/subdate.jsp"/>" class="blue"><bean:message key="page.home.link.setting" bundle="admin"/></A>]<BR>
                    <IMG src="<html:rewrite page="/images/arrow.gif"/>" width="3" height="5" border=0 align=absMiddle> 
                    <bean:message key="page.home.review" bundle="admin" arg0="<%=StringUtils.exportDate(conf.getReviewBeginDate(), "yyyy-MM-dd","-- -- --")%>" arg1="<%=StringUtils.exportDate(conf.getReviewEndDate(), "yyyy-MM-dd","-- -- --")%>"/>&nbsp;&nbsp;[<A href="<html:rewrite page="/admin/reviewdate.jsp"/>" class="blue"><bean:message key="page.home.link.setting" bundle="admin"/></A>]<BR>
                    <IMG src="<html:rewrite page="/images/arrow.gif"/>" width="3" height="5" border=0 align=absMiddle> 
                    <bean:message key="page.home.confirm" bundle="admin" arg0="<%=StringUtils.exportDate(conf.getConBeginDate(), "yyyy-MM-dd","-- -- --")%>" arg1="<%=StringUtils.exportDate(conf.getConEndDate(), "yyyy-MM-dd","-- -- --")%>"/>&nbsp;&nbsp;[<A href="<html:rewrite page="/admin/subcondate.jsp"/>" class="blue"><bean:message key="page.home.link.setting" bundle="admin"/></A>]</div></td>
              </tr>
            </table></td>
        </tr>
      </table> 
      <table width="70%" height="5" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="2" class="panel">
        <tr> 
          <td class="panel_head"><bean:message key="page.home.aboutpaper" bundle="admin"/></td>
        </tr>
        <tr> 
          <td><table width="100%" border="0" cellspacing="2" cellpadding="0">
              <tr> 
                <td><DIV class=panel_top_body><IMG src="<html:rewrite page="/images/arrow.gif"/>" width="3" height="5" 
					border=0 align=absMiddle> <bean:message key="page.home.regcount" bundle="admin" arg0="<%=String.valueOf(ssi.getAuthorCount())%>" arg1="<%=String.valueOf(ssi.getPaperCount())%>"/>&nbsp;&nbsp;&nbsp;&nbsp; 
                    [<A href="<html:rewrite page="/admin/paper.jsp"/>" class="blue"><bean:message key="page.home.link.dispose" bundle="admin"/></A>]<BR>
                    <%if(conf.isStage()==ConfigBean.STAGE_REVIEW){%>
                    <IMG src="<html:rewrite page="/images/arrow.gif"/>" width="3" height="5" border=0 align=absMiddle> 
                    <bean:message key="page.home.delivercount" bundle="admin" arg0="<%=String.valueOf(ssi.getOutPaperCount())%>" arg1="<%=String.valueOf(ssi.getInPaperCount())%>"/> 
                    &nbsp;&nbsp;&nbsp;&nbsp; [<A href="<html:rewrite page="/admin/paperunassign.jsp"/>" class="blue"><bean:message key="page.home.link.deliver" bundle="admin"/></A>]<BR>
                    <IMG src="<html:rewrite page="/images/arrow.gif"/>" width="3" height="5" border=0 align=absMiddle> 
                    <bean:message key="page.home.quitcount" bundle="admin" arg0="<%=String.valueOf(ssi.getQuitPaperCount())%>"/>&nbsp;&nbsp;&nbsp;&nbsp; 
                    [<A href="<html:rewrite page="/admin/paperquit.jsp"/>" class="blue"><bean:message key="page.home.link.quit" bundle="admin"/></A>]</div></td>
                    <%}%>
              </tr>
            </table></td>
        </tr>
      </table></td>
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