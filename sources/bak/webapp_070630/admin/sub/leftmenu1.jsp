<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="embed_module">
  <tr>
    <td class="module_title"><b><bean:message key="menu.top.submission_review" bundle="admin"/></b></td>
  </tr>
  <tr>
    <td class="module_content"> <span class="paper_setting"><a href="<html:rewrite page="/admin/subins.jsp"/>" title="<bean:message key="menu.left.submission.ins" bundle="admin"/>"><bean:message key="menu.left.submission" bundle="admin"/></a></span> 
      <span class="paper_setting"><a href="<html:rewrite page="/admin/reviewins.jsp"/>" title="<bean:message key="menu.left.review.ins" bundle="admin"/>"><bean:message key="menu.left.review" bundle="admin"/></a></span> 
      <span class="paper_diliver"><a href="<html:rewrite page="/admin/paper.jsp"/>" title="<bean:message key="menu.left.paper.ins" bundle="admin"/>"><bean:message key="menu.left.paper" bundle="admin"/></a></span> 
      <span class="paper_review"><a href="<html:rewrite page="/admin/result.jsp"/>" title="<bean:message key="menu.left.result.ins" bundle="admin"/>"><bean:message key="menu.left.result" bundle="admin"/></a></span> 
      <span class="paper_export"><a href="<html:rewrite page="/admin/export.jsp"/>" title="<bean:message key="menu.left.export.ins" bundle="admin"/>"><bean:message key="menu.left.export" bundle="admin"/></a></span> 
      <span class="paper_download"><a href="<html:rewrite page="/admin/download.jsp"/>" title="<bean:message key="menu.left.download.ins" bundle="admin"/>"><bean:message key="menu.left.download" bundle="admin"/></a></span> 
      <span class="paper_stat"><a href="<html:rewrite page="/admin/statistics.jsp"/>" title="<bean:message key="menu.left.statistics.ins" bundle="admin"/>"><bean:message key="menu.left.statistics" bundle="admin"/></a></span> 
      <span class="paper_publish"><a href="<html:rewrite page="/admin/publish.jsp"/>" title="<bean:message key="menu.left.publish.ins" bundle="admin"/>"><b><bean:message key="menu.left.publish" bundle="admin"/></b></a></span></td>
  </tr>
</table>