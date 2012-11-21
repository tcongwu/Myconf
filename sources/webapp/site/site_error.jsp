<%
//*********************************
//define
//*********************************
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page isErrorPage="true" %>

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
<jsp:include page="/inc/logo.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.error.ins"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<br>
<TABLE width=778 height="84" border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=5><img src="<html:rewrite page="/images/rounded_top.gif"/>" width="778" height="5"></TD>
    </TR>
    <TR> 
      <TD width=1 height="73" noWrap bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
      <TD width=776 align="right" vAlign=middle noWrap> <TABLE width=518 border=0 align="center" cellPadding=5 cellSpacing=0>
          <TBODY>
            <TR> 
              <TD align="center" class="redins">
              	<%
              	 // if(request.getAttribute("err")!=null){
              	  	//out.print(org.myconf.util.StringUtils.exportString((String)request.getAttribute("err")));
              	//  }
              	%>
				<!--
				<html:messages  id="error" message="true">  
					<bean:write name="error"/><br>  
				</html:messages>
				-->
			
			 <TD align="center" style="font-size:16px;" class="redins"><bean:message key="page.site.content_must" bundle="site"/></TD>
			  </TD>
            </TR>
          </TBODY>
        </TABLE></TD>
      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
    </TR>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=6><img src="<html:rewrite page="/images/rounded_bottom.gif"/>" width="778" height="5"></TD>
    </TR>
  </TBODY>
</TABLE>
<TABLE width=778 border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD noWrap colSpan=2 height=10><SPACER height="10" 
  type="block"></TD>
    </TR>
  </TBODY>
</TABLE>
<TABLE width=778 border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD height=38 colSpan=2 align="center" noWrap bgcolor="#D3D3DF">
      	<!-- <input name="home" type="button" id="home" style="width:130px;height:24px;" onClick="window.location='<html:rewrite page="/"/>'" value="<bean:message key="common.button.home"/>">-->
        <input name="close" type="button" id="close" style="width:130px;height:24px;" onClick="window.close()" value="<bean:message key="common.button.closewindow"/>"> 
       <!-- <input name="back" type="button" id="back" style="width:130px;height:24px;" onClick="window.history.back()" value="<bean:message key="common.button.back"/>">-->
        <SPACER height="10" type="block">
      </TD>
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
