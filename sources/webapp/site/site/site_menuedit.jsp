
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
<%@ page import="org.myconf.dao.MenuDAO" %>
<%@ page import="org.myconf.dao.LangDAO" %>
<%@ page import="org.myconf.beans.MenuBean" %>
<%@ page import="org.myconf.beans.ContentBean" %>
<%@ page import="org.myconf.beans.LangBean" %>
<%@ page import="org.myconf.util.StringUtils" %>
<%@ page import="java.util.*" %>
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
	
	List clist=ContentDAO.getContentByVersion(LangDAO.getLang(langId));
	
	MenuBean mbean;
	String menuname="";
	String  mtype="";
	String mlink="";
	String mopentype="";
	String  mpublished="";
	String mstyle="";
	String mordering="";
	
	String mid=StringUtils.exportString(request.getParameter("id"));
	if(!mid.equals("")){
		mbean=MenuDAO.getMenuByID(Integer.parseInt(mid));
		menuname=StringUtils.exportString(mbean.getMenuName());
		mtype=StringUtils.exportString(mbean.getType());
		mlink=StringUtils.exportString(mbean.getLink());
		mopentype=StringUtils.exportString(mbean.getOpenType());
		mstyle=StringUtils.exportString(mbean.getStyle());
		mpublished=mbean.getPublished()+"";
		mordering=mbean.getOrdering()+"";
		
		
	}

%>
<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />
<script  language="javascript">
function checkForm()
{
	if (trim(formMenu.menuName.value).length == 0) {
		alert("<bean:message key="page.site.menu_name_notnull" bundle="site" />");
		formMenu.menuName.focus();
		return false;
	}
<!--	
	if (trim(formMenu.link.value).length == 0) {
		alert("<bean:message key="page.site.menu_link_notnull" bundle="site" />");
		formMenu.link.focus();
		return ;
	}
-->	
	
	return true;
} 	
</script>

<script language=javascript>

function switchRadioValue(){   
  if (formMenu.type1[0].checked)
  {
   hideLayer('urlbox');
   showLayer('pagebox');
   //showLayer('pagebox1');
   //showLayer('pagebox2');
   showLayer('pagebox3');
  }
   if (formMenu.type1[1].checked)
  {
   hideLayer('pagebox');
   //hideLayer('pagebox1');
  // hideLayer('pagebox2');
   hideLayer('pagebox3');
   showLayer('urlbox');
  } 
 }
 </script>

<body  onLoad="switchRadioValue();">
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
          <td class="pagecontent_title"><b><bean:message key="page.site.submenu2" bundle="site" /></b></td>
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
				  <li><bean:message key="page.site.menu_point1" bundle="site" /></li>
				
                  <li><bean:message key="page.site.setting_point3" bundle="site" /></li>
        		<div class="spacer_5"></div></td>
              </tr>
            </table>
	<form name="formMenu" action="<html:rewrite page="/menu.do"/>"    method="post"   onSubmit="return checkForm();">
	<input type="hidden" name="languange" value="<%=languange%>">
	<input type="hidden" name="id" value="<%=mid%>">
		
	  
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr>
                  <td width="20%" class="form_row_title"><bean:message key="page.site.menu_name" bundle="site" /> </td>
                  <td width="80%" class="form_row_content">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="menuName" type="text" size="40" value="<%=menuname%>"> 
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr>
                  <td width="20%" class="form_row_title"><bean:message key="page.site.menu_linktype" bundle="site" /> </td>
                  <td width="80%" class="form_row_content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   page<input type="radio" name="type1" value="page" <%if(mtype.equals("page")){out.println("checked");}%> onClick="switchRadioValue();"> &nbsp;&nbsp;&nbsp;url<input type="radio" name="type1" <%if(mtype.equals("url")){out.println("checked");}%>  value="url" onClick="switchRadioValue();">
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" id="urlbox">
                <tr>
                  <td width="20%" class="form_row_title"><bean:message key="page.site.menu_link" bundle="site" /> </td>
                  <td width="80%" class="form_row_content">&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="text" name="link" value="<%=mlink%>" size="40"> 
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	   
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" id="pagebox">
                <tr>
                  <td width="20%" class="form_row_title"><bean:message key="page.site.menu_linkcontent" bundle="site" />   </td>
                  <td width="80%" class="form_row_content">&nbsp;&nbsp;&nbsp;&nbsp;
                   
							<SELECT  NAME="linkcontent"  SIZE="10"   >  
						 <%
				  			 if(clist!=null&&clist.size()>0){
				   				for(int i=0;i<clist.size();i++){
				   					ContentBean cbean=(ContentBean)clist.get(i);
				   					if(cbean.getPublished()==1){
				   			
				   		
				  			 %> 
							<OPTION  VALUE="<%=cbean.getId()%>"  <%if(mlink.equals(cbean.getId()+"")){out.println("SELECTED");}%> ><%=StringUtils.exportString(cbean.getTitle())%></option>
							
							<%		}
								}
							}
							
							%>
							</SELECT>   
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	   
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" id="pagebox1">
                <tr>
                  <td width="20%" class="form_row_title"> <bean:message key="page.site.menu_opentype" bundle="site" />    </td>
                  <td width="80%" class="form_row_content">&nbsp;&nbsp;&nbsp;&nbsp;
                  
							<SELECT  NAME="openType"   >
							<OPTION  VALUE="_self" <%if(mopentype.equals("_self")){out.println("SELECTED");}%>><bean:message key="page.site.menu_open2" bundle="site" />   
							<OPTION  VALUE="_blank"  <%if(mopentype.equals("_blank")){out.println("SELECTED");}%> ><bean:message key="page.site.menu_open1" bundle="site" />   
							 
							</SELECT>   
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	   
	     <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" id="pagebox2">
                <tr>
                  <td width="20%" class="form_row_title">  <bean:message key="page.site.menu_published" bundle="site" />   </td>
                  <td width="80%" class="form_row_content">&nbsp;&nbsp;&nbsp;&nbsp;
                 
							<SELECT  NAME="published"   >  
							<OPTION  VALUE="1"  <%if(mpublished.equals("1")){out.println("SELECTED");}%>><bean:message key="page.site.menu_published1" bundle="site" />   
							<OPTION  VALUE="2" <%if(mpublished.equals("2")){out.println("SELECTED");}%>><bean:message key="page.site.menu_published2" bundle="site" /> 
							</SELECT>   
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>
	   
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row" id="pagebox3">
                <tr>
                  <td width="20%" class="form_row_title">   <bean:message key="page.site.menu_showtype" bundle="site" />  </td>
                  <td width="80%" class="form_row_content">&nbsp;&nbsp;&nbsp;&nbsp;
				  <input type="checkbox"  name="style1"  <%if(mstyle.indexOf("1")>=0){out.println("checked");}%> value="1"> <bean:message key="page.site.menu_showtype1" bundle="site" /> 
				   &nbsp;&nbsp;
				  <input type="checkbox"  name="style2"  <%if(mstyle.indexOf("2")>=0){out.println("checked");}%>   value="2"> <bean:message key="page.site.menu_showtype2" bundle="site" />
					 <div class="spacer_5"></div>
                   </td>
                </tr>
       </table>

	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
		<tr> 
		  <td class="form_row_submit">      <input name="eventSubmit_EditMenu" type="submit" class="button" value="<bean:message key="page.site.menu_editbutton" bundle="site" /> ">
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
<%}%>