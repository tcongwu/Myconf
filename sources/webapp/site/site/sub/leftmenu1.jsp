<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="org.myconf.beans.*" %>
<script language="JavaScript">
function publish(lang) {
	window.open("<html:rewrite page="/site/publish.jsp?lang="/>"+lang, "published", "resizable=no,scrollbars=yes,height=600,width=800");
}
</script>
<%

	String langs=StringUtils.exportString(request.getParameter("version"));
	String  languange=(String) session.getAttribute("version");
	if(!langs.equals("")) languange=langs;
	if(languange==null||languange.equals("")){
	
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
	int isdefault=1;
	if(langcount>1) {
		isdefault=LangBean.LANG_ISDEDAULT_NOT;
		}
	else
		{
		isdefault=LangBean.LANG_ISDEDAULT;
		}
	
	int langId=1;
	if(languange.equals("zh_cn")){langId=LangBean.LANG_ZH_CN;}
	if(languange.equals("zh_tw")){langId=LangBean.LANG_ZH_TW;}
	if(languange.equals("english")){langId=LangBean.LANG_ENGLISH;}
	
	LangBean lang=LangDAO.getLang(langId);
	boolean isAdd=false;
	if(lang!=null){isAdd=true;}	

%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="embed_module">
              <tr>
                <td class="module_title"><b><bean:message key="page.site.menu1" bundle="site"/></b></td>
              </tr>
              <tr>
                <td class="module_content">
				<span class="paper_setting"><a href="<html:rewrite page="/site/site_setting.jsp?version="/><%=languange%>" title="<bean:message key="page.site.submenu7" bundle="site"/>"><bean:message key="page.site.submenu7" bundle="site"/></a></span>
				<span class="paper_diliver"><a href="<html:rewrite page="/site/site_content.jsp"/>" title="<bean:message key="page.site.submenu3" bundle="site"/>"><bean:message key="page.site.submenu3" bundle="site"/></a></span>
		        <span class="paper_setting"><a href="<html:rewrite page="/site/site_menu.jsp"/>" title="<bean:message key="page.site.submenu2" bundle="site"/>"><bean:message key="page.site.submenu2" bundle="site"/></a></span>
				<span class="paper_review"><a href="<html:rewrite page="/site/site_template.jsp"/>" title="<bean:message key="page.site.submenu4" bundle="site"/>"><bean:message key="page.site.submenu4" bundle="site"/></a></span>
				
              </tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="embed_module_bottom">
              <tr> 
                <td class="module_title"><b><bean:message key="page.site.menu3" bundle="site"/></b></td>
              </tr>
              <tr> 
                <td class="module_content">
    	    	<span class="paper_stat"><a href="<html:rewrite page="/site/site_out.jsp?version="/><%=languange%>" title="<bean:message key="page.site.submenu5" bundle="site"/>"><bean:message key="page.site.submenu5" bundle="site"/></a></span>
		<%if(!languange.equals("")&&isAdd==true){%><span class="paper_download"><a href="#" onclick="javascript:publish('<%=languange%>')"   title="<bean:message key="page.site.submenu6" bundle="site"/>"><bean:message key="page.site.submenu6" bundle="site"/></a></span> <%}%>
		</td>
              </tr>
</table>

<%}%>

      