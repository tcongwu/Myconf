<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="site" />


<%
//*********************************
//define
//*********************************
%>

<%@ page import="org.myconf.beans.LangBean" %>
<%@ page import="org.myconf.dao.LangDAO" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
	
	String lang=(String) session.getAttribute("version");
	if(lang==null){
	
%>
<script languange="javascript">
	alert("<bean:message key="page.site.setting_sessionout" bundle="site"/>");
	window.location.href="<html:rewrite page="/site/index.jsp"/>"

</script>


<%	
	return;
	 
	}else{

%>

<%
	
	List langList=LangDAO.getLanglist();
	
%>

<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />


<body >
<jsp:include page="/inc/top.jsp" />
<jsp:include page="/inc/logo_site.jsp" />

<script language="javascript">

function checkForm()
{

	
	var checkName=document.getElementsByName("publish");
	var count=0;
	
	
	for(var i=0;i<checkName.length;i++){
	         if(checkName[i].checked){
			 count++;
			 }
	      }
	if(count==0){
	alert("<bean:message key="page.site.version_published_chose" bundle="site" />");
	return ;
	}
	
	document.langset.action="<html:rewrite page="/lang.do"/>" ;
	document.langset.method="post";
	document.langset.submit();
} 	


</script>


<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.site.published"  bundle="site"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>


<table width="778" border="0" cellpadding="0" cellspacing="0"  align="center">
  <tr>
    <td><div class="spacer_5"></div>
	 &nbsp;
	<div class="spacer_5"></div></td>
  </tr>
 </table>
 <table width="778" border="0" cellpadding="0" cellspacing="0" class="form" align="center">
     <tr>
       <td><table width="778" border="0" cellpadding="0" cellspacing="0" class="form_note" align="center">
 			 <tr>
   				 <td><div class="spacer_5"></div>
	 				 <li><bean:message key="page.site.published.point1" bundle="site"/></li>
	 				 <li><bean:message key="page.site.published.point2" bundle="site"/></li>
    				 <div class="spacer_5"></div>
    			</td>
 			 </tr>
		 </table>
 		</td>
 	</tr>
 </table>
 
 <table width="778" border="0" cellpadding="0" cellspacing="0"  align="center" class="form">
  <tr>
    <td><div class="spacer_5"></div>
	 &nbsp;
	<div class="spacer_5"></div></td>
  </tr>
 </table>
 
 <form  action="<html:rewrite page="/lang.do"/>"  name="langset"    method="post"  >
 	  <input name="eventSubmit_Published" type="hidden" id="eventSubmit_Published" value="1">
      <table width="778"  border="0" cellpadding="0" cellspacing="1" class="table" align="center">
      
      		<%
      			if(langList!=null&&langList.size()>0){
					for(int i=0;i<langList.size();i++){
      					LangBean lbean=(LangBean) langList.get(i);
      		
      		%>
			<tr class="table_head" > 
			  <td width="33%" align="center" nowrap><% if(lbean.getId()==LangBean.LANG_ZH_CN){ out.println(org.myconf.Globals.LANGUAGE_SIMPLIFIED);} if(lbean.getId()==LangBean.LANG_ZH_TW){ out.println(org.myconf.Globals.LANGUAGE_TRADITIONAL);} if(lbean.getId()==LangBean.LANG_ENGLISH){ out.println(org.myconf.Globals.LANGUAGE_ENGLISH);}%> </td>
			   <td width="33%" align="center" nowrap><bean:message key="page.site.menu_published1" bundle="site" />&nbsp;&nbsp;<input type="checkbox" id="publish"   name="publish" value="<%=lbean.getId()%>" <%if(lbean.getPublished()==1){out.println("checked");}%>> </td>
			    <td width="33%" align="center" nowrap><bean:message key="page.site.published.first" bundle="site" />&nbsp;&nbsp;<input type="radio"  id="isdefault"  name="isdefault" value="<%=lbean.getId()%>" <%if(lbean.getIsDefault()==1){out.println("checked");}%> > </td>
		    </tr>	
		    
		    <%
		    	}
		    }	
		    
		    
		    %>
		    

	  </table>
      <table  width="778" border="0" cellpadding="0" cellspacing="0" class="form_row" align="center">
        <tr align="center"> 
          <td class="form_row_submit" >
          	<input name="Submit" onClick="if(confirm('<bean:message key="page.site.version_published" bundle="site" />')){checkForm();window.close();}"   type="button" class="button" value="<bean:message key='page.site.template_submit' bundle='site'/>" >
          </td></tr>
      </table>
</form>
<div class="spacer_20"></div>
<%
//**********************************
//footer
//**********************************
%>
<jsp:include page="/inc/footer.jsp" />
</body>
</html>
<%}%>
