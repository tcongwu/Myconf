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
<%@ page import="org.myconf.Globals" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.dao.*" %>
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

	int langcount=LangDAO.getLangCount();
	int langId=1;
	int isdefault=1;
	if(langcount>=1) {
		isdefault=LangBean.LANG_ISDEDAULT_NOT;
		}
	else
		{
		isdefault=LangBean.LANG_ISDEDAULT;
		}
		
	if(languange.equals("zh_cn")){
		langId=LangBean.LANG_ZH_CN;
		}
	else if(languange.equals("zh_tw")){
		langId=LangBean.LANG_ZH_TW;
		
		}
	else if(languange.equals("english")){
		langId=LangBean.LANG_ENGLISH;
		
		}
	
				
	LangBean lbean=LangDAO.getLangByID(langId);
	ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
	if(lbean!=null){
		if(lbean.getIsDefault()==1||lbean.getIsDefault()==2)
			isdefault=lbean.getIsDefault();
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
<jsp:include page="/inc/logo_site.jsp" />

<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/site/sub/mainmenu1.jsp" />



<script language="javascript">
 

function check(theForm){
	filetype=new   Array();   
 	filetype[0]="jpg";     
  	filetype[1]="gif";     
  	filetype[2]="jpeg";     
  	
	
	var filename = document.getElementById("NewFile");
	if((theForm.NewFile.value.length==0)){
		
		alert("<bean:message key="page.site.setting_uploadfile_notnull" bundle="site" />");
		theForm.NewFile.focus();
		return false;
	}
	var flag=0;
	for(var i=0;i<filetype.length;i++){
	if((filename.value.substring(filename.value.length-3).toLowerCase())==filetype[i])
		flag++;
		}	
	if(flag==0){
		alert("<bean:message key="page.site.setting_banner_filetype" bundle="site" />");
		theForm.NewFile.focus();
		return false;
	
		}
	theForm.eventSubmit_UploadImage.disabled = true;
	return true;
}
 	

function checkForm()
{
	if (trim(langset.confname.value).length == 0) {
		alert("<bean:message key="page.site.setting_name_notnull" bundle="site" />");
		langset.confname.focus();
		return false;
	}
	
	if (trim(langset.shortname.value).length == 0) {
		alert("<bean:message key="page.site.setting_shortname_notnull" bundle="site" />");
		langset.shortname.focus();
		return false;
	}
	
	if (trim(langset.copyright.value).length == 0) {
		alert("<bean:message key="page.site.setting_copyright_notnull" bundle="site" />");
		langset.copyright.focus();
		return false;
	}
	
	if (trim(langset.email.value).length == 0) {
		alert("<bean:message key="page.site.setting_email_notnull" bundle="site" />");
		langset.emailt.focus();
		return false;
	}
	
	return true;
} 	
</script>


<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr>
   <td width="180" height="55" valign="top">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenu">
        <tr> 
          <td height="41">
		   <jsp:include page="/site/sub/leftmenu1.jsp" />
		   <jsp:include page="/inc/stat.jsp" />
		  </td>
        </tr>
      </table>
    </td>
    <td width="598" valign="top" class="pagecontent"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	
        <tr>
          <td class="pagecontent_title"><b><bean:message key="page.site.submenu7" bundle="site" /></b></td>
		   <td class="site_version" align="right"><b><bean:message key="<%=key%>" bundle="site" /></b></td>
		   <div class="spacer_5"></div>
        </tr>
        <tr >
          <td align="right"  colspan="2" height="5">
          	&nbsp;
          </td>		
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td>
		  
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.site.setting_point1" bundle="site" /></li>
				  <li><bean:message key="page.site.setting_point2" bundle="site" /></li>
                  <li><bean:message key="page.site.setting_point3" bundle="site" /></li>
        		<div class="spacer_5"></div></td>
              </tr>
            </table>
        
              <form  action="<html:rewrite page="/lang.do"/>"  name="langset"    method="post"   onSubmit="return checkForm();">
               <input type="hidden" name="languange"  value="<%=languange%>">
               <input type="hidden" name="isdefault"  value="<%=isdefault%>">
               <input name="eventSubmit_SiteSetting" type="hidden" id="eventSubmit_SiteSetting" value="1">
               <input name="fromPage" type="hidden" id="fromPage" value="">
				  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr>
                  <td width="20%" class="form_row_title">*<bean:message key="page.site.setting_name" bundle="site" /></td>
                  <td width="80%" class="form_row_content">&nbsp;
                    <input name="confname" type="text" size="40" value="<% if(lbean!=null){out.println(StringUtils.exportString(lbean.getConfName()));}%>"> <input type="checkbox" name="show1" value="1" <% if(lbean!=null){ if(StringUtils.exportString(lbean.getShow1()+"").equals("1")){out.println("checked");}}%>> <bean:message key="page.site.setting_showbanner" bundle="site" />
					 <div class="spacer_5"></div>
                   </td>
                </tr>
              </table>
				 
				  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr>
                  <td width="20%" class="form_row_title">*<bean:message key="page.site.setting_shortname" bundle="site" /></td>
                  <td width="80%" class="form_row_content">&nbsp;
                    <input name="shortname" type="text" size="40" value="<% if(lbean!=null){out.println(StringUtils.exportString(lbean.getShortName()));}%>"> <input type="checkbox" name="show2" value="1"  <%if(lbean!=null){ if(StringUtils.exportString(lbean.getShow2()+"").equals("1")){out.println("checked");}}%> > <bean:message key="page.site.setting_showbanner" bundle="site" />
					 <div class="spacer_5"></div>
                   </td>
                </tr>
              </table>
				 
			    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr>
                  <td width="20%" class="form_row_title">*<bean:message key="page.site.setting_copyright" bundle="site" /></td>
                  <td width="80%" class="form_row_content">&nbsp;
                    <input name="copyright" type="text" size="40" value="<% if(lbean!=null){out.println(StringUtils.exportString(lbean.getCopyright()));}%>">
					 <div class="spacer_5"></div>
                   </td>
                </tr>
              </table>
				
				
              
			    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr>
                  <td width="20%" class="form_row_title">*<bean:message key="page.site.setting_email" bundle="site" /></td>
                  <td width="80%" class="form_row_content">&nbsp;
                    <input name="email" type="text" size="40" value="<%if(lbean!=null){out.println(StringUtils.exportString(lbean.getEmail()));}%>">
					 <div class="spacer_5"></div>
                   </td>
                </tr>
              </table>
		  
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_submit"><input  name="SiteSetting" onClick="langset.fromPage.value='/site/site_setting.jsp';"   type="submit"  value="<bean:message key="page.site.setting_save" bundle="site" />" class="button">
                   <input name="next" onClick="langset.fromPage.value='/site/site_content.jsp';" type="submit" class="button" id="next" value="<bean:message key="common.button.save.and.next"/>">
                   <!-- <input name="Submit" type="submit" class="button" value="<bean:message key="page.site.setting_savenext" bundle="site" />">-->
                  </td>
				  
                </tr>
              </table>
          
			  <table  width="100%" border="0" cellpadding="0" cellspacing="0" >
			   <tr> 	 
					 <td>&nbsp;
					 </td>
				 </tr>	
			  </table>
			   </form>
			<%
			
			
			if(lbean!=null){
					
				
			%>   
			   <form name="banner_upload" method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/servlet/fckeditor_upload" onsubmit="return check(this);">
			    <input type="hidden" name="fromPage" value="/site/site_setting.jsp">	
    			 <input type="hidden" name="Type" value="Image">
    			 <input type="hidden" name="banner" value="1">
			     <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                	<tr>
                 	 <td  width="17%" class="form_row_title"><bean:message key="page.site.setting_banner" bundle="site" /></td>
                 	 <td class="form_row_content">&nbsp;
                    <input name="NewFile" id="NewFile" type="file" size="30">
                    &nbsp;<input type="submit" name="eventSubmit_UploadImage" class="button" value="<bean:message key="page.site.content_attachadd" bundle="site" />"> <span class="form_row_content"><bean:message key="page.site.setting_banner_size1" bundle="site" /> </span> 
                    </td>
                </tr>
              </table>
			  </form>
			  
			  
			   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_submit">&nbsp;
                  </td>
                </tr>
              </table>
              <br>
              
			  <%		
			  	 StringBuffer sb=new StringBuffer();
			  	 String img="";
			  	 String temp="";
			  	 String temproot="";
			  	 img=(String)request.getAttribute("upload_image_uri");
			  	 if(conf!=null){
			  			img=StringUtils.exportString(conf.getBanner());
			  			
					}		
			 			 
			  if(img.equals(""))	{	
				temp=StringUtils.exportString(lbean.getTemplate());
				if(temp.equals("")) temp=Globals.TEMPLATE_DEFAUT;
				temproot=sb.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(temp).append("/").append("images").append("/").append("banner.jpg").toString();
			  	img=temproot;	
			  	}
			  	
			  %>
			    <table   border="0" cellpadding="0" cellspacing="0"  width="600">
			   
			  	 <tr> 	 
					 <td class="site_blockphoto"   width="600" height="100"    background="<%=img%>">
					 	 <TABLE cellSpacing=0 cellPadding=0 width=400 align=right border=0>
        					<TBODY>
       						 <TR>
        						  <TD align=left height=35><font color='<%if(temp.equals("fall")||temp.equals("soar")){%>#00CCFF<%}else{%>#ff6600<%}%>'><b><%if(lbean!=null){if(lbean.getShow2()==1){out.println(StringUtils.exportString(lbean.getShortName()));}}%></b></font></TD>
        					  </TR>
      						  <TR>
       							   <TD>
           								 <DIV align=left><SPAN ><font color='<%if(temp.equals("fall")||temp.equals("soar")){%>#00CCFF<%}else{%>#ff6600<%}%>' size='3'><b><%if(lbean!=null){if(lbean.getShow1()==1){out.println(StringUtils.exportString(lbean.getConfName()));}}%></b></font></SPAN></DIV></TD>
         					 <TD align=right>&nbsp;</TD></TR></TBODY></TABLE>
   
					
				 </tr>	
			
			   </table>
			   
			<%
			}
			
			
				
			%>   
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
<%}%>
