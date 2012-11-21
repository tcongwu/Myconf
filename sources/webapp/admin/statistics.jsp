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
//statistics type
int type=RequestUtils.getParam(request, "type", PaperBean.STATISTICS_BY_SUBJECT);

//paper statistics data
Map stats=PaperDAO.statistics(type);

//section iterator
Iterator secs=null;
if(type==PaperBean.STATISTICS_BY_COUNTRY || type==PaperBean.STATISTICS_BY_STATE){
	secs=stats.keySet().iterator();
}else{
	List subjects=SubjectDAO.listSubject();
	if(subjects==null){
		throw new Exception(Globals.getMessage("common", "error.unknow"));
	}
	secs=subjects.iterator();
}
if(secs==null || !secs.hasNext()){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
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
          <td class="pagecontent_title"><b><bean:message key="menu.left.statistics" bundle="admin"/></b></td>
        </tr>
        <tr> 
          <td align="right" class="pagecontent_right">
          	<%if(type!=PaperBean.STATISTICS_BY_COUNTRY && type!=PaperBean.STATISTICS_BY_STATE){%>
          	<span class="pagemenu_visited"><bean:message key="menu.statistics.subject" bundle="admin"/></span> 
          	<%}else{%>
          	<a href="<html:rewrite page="/admin/statistics.jsp?type="/><%=PaperBean.STATISTICS_BY_SUBJECT%>" class="pagemenu"><bean:message key="menu.statistics.subject" bundle="admin"/></a> 
          	<%}%>
          	<%if(type==PaperBean.STATISTICS_BY_COUNTRY){%>
          	> <span class="pagemenu_visited"><bean:message key="menu.statistics.country" bundle="admin"/></span> 
          	<%}else{%>
          	> <a href="<html:rewrite page="/admin/statistics.jsp?type="/><%=PaperBean.STATISTICS_BY_COUNTRY%>" class="pagemenu"><bean:message key="menu.statistics.country" bundle="admin"/></a> 
          	<%}%>
          	<%if(type==PaperBean.STATISTICS_BY_STATE){%>
          	> <span class="pagemenu_visited"><bean:message key="menu.statistics.state" bundle="admin"/></span> 
          	<%}else{%>
          	> <a href="<html:rewrite page="/admin/statistics.jsp?type="/><%=PaperBean.STATISTICS_BY_STATE%>" class="pagemenu"><bean:message key="menu.statistics.state" bundle="admin"/></a> 
          	<%}%>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td> <table width="100%" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="52%"> <div class="spacer_20"></div></td>
              </tr>
            </table>
            <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
              <tr> 
                <td width="30%" class="table_head" nowrap>
                <%if(type==PaperBean.STATISTICS_BY_COUNTRY){%>
                	<bean:message key="common.text.statistics.country" bundle="admin"/>
                <%}else if(type==PaperBean.STATISTICS_BY_STATE){%>
                	<bean:message key="common.text.statistics.state" bundle="admin"/>
                <%}else{%>
                	<bean:message key="common.text.statistics.subject" bundle="admin"/>
                <%}%>
                </td>
                <td width="41%" nowrap class="table_head"><bean:message key="common.text.statistics.accept" bundle="admin"/></td>
                <td width="29%" class="table_head" nowrap><bean:message key="common.text.statistics.sum" bundle="admin"/></td>
              </tr>
              <%
              	Map vmap=null;
              	String key=null;
              	String skey=null;
              	Iterator skeys=null;
              	int sum=0;
              	int cnt=0;
              	while(secs.hasNext()){
              	  key=(String)secs.next();
              	  if(!PaperBean.STATISTICS_SUM.equals(key)){
              	  	vmap=(Map)stats.get(key);
              	  	if(vmap==null){
              	  	  sum=0;
              	  	  skeys=null;
              	  	}else{
              	  	  sum=((Integer)vmap.remove(PaperBean.STATISTICS_SUM)).intValue();
              	  	  skeys=vmap.keySet().iterator();
              	  	}
              %>
              <tr> 
                <td valign="top" class="table_cell"><%=key%></td>
                <td nowrap class="table_cell">
                  <%if(skeys!=null){%>
                  <table width="98%" border="0" cellspacing="2" cellpadding="0">
                	<%
                	  	while(skeys.hasNext()){
                	  	  skey=(String)skeys.next();
                	  	  cnt=((Number)vmap.get(skey)).intValue();
                	%>
                    <tr> 
                      <td width="47%"><%=skey%></td>
                      <td width="25%"><%=cnt%></td>
                      <td width="28%"><%=100*cnt/sum%>%</td>
                    </tr>
                    <%}%>
                  </table>
                  <%}%>
                </td>
                <td valign="top" class="table_cell"><%=sum%></td>
              </tr>
              <%}}%>
              <%sum=((Integer)stats.get(PaperBean.STATISTICS_SUM)).intValue();%>
              <tr> 
                <td valign="top" class="table_cell" style="color:blue"><bean:message key="common.text.statistics.all" bundle="admin"/></td>
                <td class="table_cell">&nbsp;</td>
                <td valign="top" class="table_cell" style="color:blue"><%=sum%></td>
              </tr>
            </table>
            
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