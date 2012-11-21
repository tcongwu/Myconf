
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

<%@ page import="org.myconf.dao.LangDAO" %>
<%@ page import="org.myconf.dao.MenuDAO" %>
<%@ page import="org.myconf.beans.LangBean" %>
<%@ page import="org.myconf.util.StringUtils" %>
<%@ page import="org.myconf.util.FileUtils" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.File" %>
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
	int langId=1;
	if(languange.equals("zh_cn")){langId=LangBean.LANG_ZH_CN;}
	if(languange.equals("zh_tw")){langId=LangBean.LANG_ZH_TW;}
	if(languange.equals("english")){langId=LangBean.LANG_ENGLISH;}
	
	int langcount=LangDAO.getLangCount();
	int isdefault=1;
	if(langcount>1) {
		isdefault=LangBean.LANG_ISDEDAULT_NOT;
		}
	else
		{
		isdefault=LangBean.LANG_ISDEDAULT;
		}
	LangBean lbean=LangDAO.getLangByID(langId);
	String template="";
	if(lbean!=null){
		template=StringUtils.exportString(lbean.getTemplate());
		
	}
	if(lbean!=null){
		if(lbean.getIsDefault()==1||lbean.getIsDefault()==2)
			isdefault=lbean.getIsDefault();
	}
	List mlist=MenuDAO.getMenuByVersion(lbean);
	boolean isAdd=false;
	if(mlist!=null&&mlist.size()!=0){isAdd=true;}
		
	

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
          <td class="pagecontent_title"><b><bean:message key="page.site.submenu4" bundle="site" /></b></td>
		  <td class="site_version" align="right"><b><bean:message key="<%=key%>" bundle="site" /></b></td>
        </tr>
        <tr >
          <td align="right"  colspan="2" height="5">&nbsp;
          	
          </td>		
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
               	 <li><bean:message key="page.site.template_point0" bundle="site" /></li>
				  <li><bean:message key="page.site.template_point1" bundle="site" /></li>
                  <li><bean:message key="page.site.menu_point2" bundle="site" /></li>
        		<div class="spacer_5"></div></td>
              </tr>
            </table>
           
          <form name="formTemp" action="<html:rewrite page="/lang.do"/>"    method="post"   >
          <input type="hidden" name="languange" value="<%=languange%>">
          <input type="hidden" name="isdefault"  value="<%=isdefault%>">
          <input name="eventSubmit_SiteSetting" type="hidden" id="eventSubmit_SiteSetting" value="1">
           <input name="fromPage" type="hidden" id="fromPage" value="">
            <%
            	String temproot=null;
            	String temproot1=null;
            	StringBuffer temp=new StringBuffer();
            	StringBuffer temp1=new StringBuffer();
            	
            	boolean ismod=false;
              	String path=getServletContext().getRealPath("/")+"site"+File.separator+"template";
              	
               	if(FileUtils.isExistFolder(path)){
               		File file=new File(path);
               		File[]   files   =   file.listFiles();
               		if(files.length%2!=0)  ismod=true;
               		int i;
               		String filename="";
               		String filename1="";
               		
               			if(ismod==true)
               				i=1;
               			else
               				i=0;	
               				for(;i<(files.length);i+=2)
               				{
               			
               				filename=files[i].getName();
               				if(ismod==true)
               					filename1=StringUtils.exportString(files[i-1].getName());
               				else
               					filename1=StringUtils.exportString(files[i+1].getName());
               			
               				temproot=temp.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(filename).append("/").toString();
               				temproot1=temp1.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(filename1).append("/").toString();
               			 
               			
               		
               	
              
              %>
              <table width="100%" border="0" cellpadding="3" cellspacing="1" >
             
					<tr > 
					  <td  width="50%"  ><img  height="165"  width="200" border="1" src="<%=temproot1%>sample.jpg">  </td>
					   <td  align="center" ><img  height="165"  width="200" border="1" src="<%=temproot%>sample.jpg"> </td>
				      
				    </tr>
					<tr >
					  <td  width="50%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="template" value="<%=filename1%>" <%if(template.equals(filename1)){out.println("checked");} %> ></td>
					  <td  align="center" width="50%"><input type="radio" name="template" value="<%=filename%>" <%if(template.equals(filename)){out.println("checked");} %> ></td>
				     
			       </tr>
					<tr >
					<td  align="center" colspan="2" height="2">&nbsp;</td>
			       </tr>
				    	
				</table>
			<%
			
			temp=new StringBuffer();
			temp1=new StringBuffer();
			}
			
			
			if(ismod==true){
				filename=files[files.length-1].getName();
				temproot=temp.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(filename).append("/").toString();
			%>
			
		
				
				<table width="100%" border="0" cellpadding="3" cellspacing="1" >
					<tr > 
					  <td  width="50%"  ><img  height="165"  width="200" border="1" src="<%=temproot%>sample.jpg">  </td>
					  
				    
				    </tr>
					<tr >
					  <td  width="50%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="template" value="<%=filename%>"  <%if(template.equals(filename)){out.println("checked");} %> ></td>
					  
			       </tr>

				    <tr >
					<td  align="center" colspan="2" height="2">&nbsp;</td>
			       </tr>	
				</table>
			<%	}
			}	
			%>	
				
			

				
              <table width="100%" border="0" cellpadding="0" cellspacing="0" >
                <tr> 
                  <td class="form_row_submit" align="center"><%if(isAdd==true){%>  <input name="Submit" onClick="formTemp.fromPage.value='/site/site_template.jsp';"  type="submit"   class="button" value="<bean:message key="page.site.template_submit" bundle="site" />"><%}%>
                  </td>
                </tr>
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
<%}%>