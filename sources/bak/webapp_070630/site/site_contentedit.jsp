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
<%@ page import="org.myconf.dao.ContentDAO" %>
<%@ page import="org.myconf.beans.ContentBean" %>
<%@ page import="org.myconf.util.StringUtils" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
	String key=(String) session.getAttribute("key");
	String languange=(String) session.getAttribute("version");
	if(key==null||languange==null){
	
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
	ContentBean cbean;
	String ctitle="";
	String  cpagetext="";
	String  cpublished="";
	String  cversion="";
	String cid=StringUtils.exportString(request.getParameter("cid"));
	if(!cid.equals("")){
		cbean=ContentDAO.getContentByID(Integer.parseInt(cid));
		ctitle=StringUtils.exportString(cbean.getTitle());
		cpagetext=StringUtils.exportString(cbean.getPagetext());
		cpublished=cbean.getPublished()+"";
		cversion=cbean.getVersion()+"";
	}
%>


<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />

<script  language="javascript" src="<%=request.getContextPath()%>/fckeditor.js"  type="text/javascript"></script>
<script  language="javascript">
function checkForm()
{
	if (trim(formContent.title.value).length == 0) {
		alert("<bean:message key="page.site.content_titile_notnull" bundle="site" />");
		formContent.title.focus();
		return false;
	}
	alert(formContent.pagetext.value);
	alert(formContent.pagetext.value.length);
	
	if (trim(formContent.pagetext.value).length == 0) {
		alert("<bean:message key="page.site.content_pagetext_notnull" bundle="site" />");
		formContent.pagetext.focus();
		return ;
	}
	
	return true;
} 	
</script>

<body >
<%
//*********************************
//top
//*********************************
%>
<jsp:include page="/inc/top.jsp" />
<jsp:include page="/inc/logo_site.jsp" />






<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/site/sub/mainmenu1.jsp" />
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr>
    <td width="180" height="55" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenu">
        <tr> 
          <td height="41">
		  <jsp:include page="/site/sub/leftmenu1.jsp" />
		   <jsp:include page="/inc/stat.jsp" />
		  </td>
        </tr>
      </table></td>
     <td width="598" valign="top" class="pagecontent"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	
        <tr>
          <td class="pagecontent_title"><b><bean:message key="page.site.contentm" bundle="site" /></b></td>
		  <td class="site_version" align="right"><b><bean:message key="<%=key%>" bundle="site" /></b></td>
        </tr>
        <tr >
          <td align="right"  colspan="2" height="5">
          	&nbsp;
          </td>		
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.site.content_point1" bundle="site" /></li>
				
                  <li><bean:message key="page.site.menu_point2" bundle="site" /></li>
        		<div class="spacer_5"></div></td>
              </tr>
            </table>
	<form name="formContent" action="<html:rewrite page="/content.do"/>"    method="post"   onSubmit="return checkForm();">
		<input type="hidden" name="languange" value="<%=languange%>">
		<input type="hidden" name="version" value="<%=cversion%>">
		<input type="hidden" name="id" value="<%=cid%>">
		
	  <div class="spacer_1"></div>
		
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr>
                  <td width="15%" class="form_row_title"><bean:message key="page.site.content_title1" bundle="site" /> </td>
                  <td width="85%" class="form_row_content">&nbsp;
                    <input name="title" type="text" size="60" value="<%=ctitle%>"> 
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	  
	   
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" >
                <tr>
                  <!--<td width="15%" class="form_row_title"><bean:message key="page.site.content" bundle="site" />   </td>-->
                  <td width="100%" class="form_row_submit">
                   <textarea id="pagetext" name="pagetext" cols="80" rows="4"><%=cpagetext%></textarea>
							
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" >
                <tr>
                  <td width="15%" class="form_row_title"><bean:message key="page.site.content_attach" bundle="site" />   </td>
                  <td width="85%" class="form_row_submit">&nbsp;
                  
					<iframe src="site_content_attach.jsp" frameBorder="0" width="400" height="22" scrolling="no"></iframe>		 
                   </td>
                </tr>
       </table>
	   
	     <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" >
                <tr>
                  <td width="15%" class="form_row_title"> <bean:message key="page.site.menu_published" bundle="site" /></td>
                  <td width="85%" class="form_row_submit">&nbsp;&nbsp;
                 
							<SELECT  NAME="published"   >  
							<OPTION  VALUE="1"  <%if(cpublished.equals("1")) {out.println("selected");}%>><bean:message key="page.site.menu_published1" bundle="site" /> </option>  
							<OPTION  VALUE="2" <%if(cpublished.equals("2")) {out.println("selected");}%>><bean:message key="page.site.menu_published2" bundle="site" /> </option>
							</SELECT>   
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	   
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
		<tr> 
		  <td class="form_row_submit"> <input name="eventSubmit_EditContent" type="submit" class="button" value="<bean:message key="page.site.menu_editbutton" bundle="site" /> ">
		  </td></tr>
	  </table>
	  
      </form>
			
			</td>
        </tr>
      </table> 
    </td>
  </tr>
</table>
<div class="spacer_20"></div>
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


<script type="text/javascript">
    window.onload = function()
    {
        sBasePath="<%=request.getContextPath()%>/";
        var oFCKeditor = new FCKeditor('pagetext') ;
        oFCKeditor.BasePath = sBasePath ;
        oFCKeditor.Height = 350;
        oFCKeditor.width="100%";
        oFCKeditor.ReplaceTextarea() ;
    }
</script>

<%}%>