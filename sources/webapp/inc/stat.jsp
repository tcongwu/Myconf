<%@ page import="org.myconf.util.*" %>
<%@ page import="org.myconf.beans.base.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%
SiteStatInfo ssi=StatTool.getSiteStatInfo();
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="embed_module_bottom">
  <tr> 
    <td class="module_title"><b><bean:message key="site.title"/></b></td>
  </tr>
  <tr> 
    <td class="module_content"> <span class="stat_item"><bean:message key="site.createtime"/><%=StringUtils.exportDate(ssi.getCreateTime(), "yyyy/MM/dd", "-- -- --")%></span> 
      <span class="stat_item"><bean:message key="site.paper.sum"/><%=ssi.getPaperCount()%></span> 
      <span class="stat_item"><bean:message key="site.register.sum"/><%=ssi.getUserCount()%></span> 
      <span class="stat_item"><bean:message key="site.visit.today"/><%=ssi.getUvToday()%></span>
      <span class="stat_item"><bean:message key="site.visit.week"/><%=ssi.getUvThisWeek()%></span> 
      <span class="stat_item"><bean:message key="site.visit.month"/><%=ssi.getUvThisMonth()%></span>
      <span class="stat_item"><bean:message key="site.visit.all"/><%=ssi.getUvTotal()%></span> 
    </td>
  </tr>
</table>