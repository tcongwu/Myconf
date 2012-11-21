<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:useBean id="msg" class="java.lang.String" scope="request" />
<jsp:useBean id="url" class="java.lang.String" scope="request" />
<jsp:useBean id="reload" class="java.lang.String" scope="request" />
<script language="javascript" type="text/javascript">
	<%if(org.myconf.util.StringUtils.isNotEmpty(reload)){%>
    window.opener.location.reload();
    <%}%>
	<%if(org.myconf.util.StringUtils.isNotEmpty(msg)){%>
    alert("<%=msg%>");
    <%}%>
	<%if(org.myconf.util.StringUtils.isNotEmpty(url)){%>
    location.href="<html:rewrite page="<%=url%>"/>";
    <%}else{%>
    window.close();
    window.opener.focus();
    <%}%>
</script>