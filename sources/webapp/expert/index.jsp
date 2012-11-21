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
<%@ page import="org.myconf.beans.ConfigBean" %>
<%@ page import="org.myconf.dao.ConfigDAO" %>
<%@ page import="org.myconf.util.StringUtils" %>
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
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
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
<jsp:include page="/expert/sub/mainmenu1.jsp" />
<br>
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
            <td class="pagecontent_title"><b><bean:message key="menu.top.reviewins" bundle="expert"/></b></td>
          </tr>
        </table>
      	<%if((conf==null)||StringUtils.isEmpty(conf.getSubIns())){%>
      	<TABLE width=518 border=0 align="center" cellPadding=5 cellSpacing=0>
          <TBODY>
            <TR> 
              <TD align="center" style="font-size:16px;" class="redins"><bean:message key="common.ins.underedit"/></TD>
            </TR>
          </TBODY>
        </TABLE>
        <%}else{%>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="18">
          <tr>
            <td style="font-size:16px;font-weight:bold"><%=conf.getReviewIns().replaceAll(" ", "&nbsp").replaceAll("\n", "<br>")%></td>
          </tr>
        </table>
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