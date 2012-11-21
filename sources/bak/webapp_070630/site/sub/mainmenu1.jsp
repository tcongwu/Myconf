<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:useBean id="uinfo" class="org.myconf.SessionUserObject" scope="request" />
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
	
	int langId=1;
	if(languange.equals("zh_cn")){langId=LangBean.LANG_ZH_CN;}
	if(languange.equals("zh_tw")){langId=LangBean.LANG_ZH_TW;}
	if(languange.equals("english")){langId=LangBean.LANG_ENGLISH;}
	
	
	

%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><div class="fleft sitenav"><a class="nav_on"><a class="selected" href="/"><bean:message key="page.site.menu1" bundle="site"/></a></a>
    <a href="<html:rewrite page="/index.do?lang="/><%=langId%>"  target="_blank"><bean:message key="page.site.menu2" bundle="site"/></a>
   <!--  <a href="<html:rewrite page="/bbs/index1.jsp"/>"  target="_blank"><bean:message key="page.site.menu2" bundle="site"/></a>-->
    </div></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">
	  <select name="select"onChange="if(this.value.length>0){window.location='<html:rewrite page="/user.do"/>?eventSubmit_SelectRole&rid='+this.value;}">
        <option selected><bean:message key="menu.role.title"/></option>
        <%if(uinfo.getIsAdmin()==UserBean.TRUE){%><option value="admin"><bean:message key="menu.role.admin"/></option><%}%>
        <%if(uinfo.getIsExpert()==UserBean.TRUE){%><option value="expert"><bean:message key="menu.role.expert"/></option><%}%>
        <%if(uinfo.getIsContent()==UserBean.TRUE){%><option value="site"><bean:message key="menu.role.site"/></option><%}%>
        <%if(uinfo.getIsAuthor()==UserBean.TRUE){%><option value="author"><bean:message key="menu.role.author"/></option><%}%>
      </select>
      &nbsp;</td>
	<td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<%}%>
