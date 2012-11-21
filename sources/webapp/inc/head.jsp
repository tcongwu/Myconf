<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%System.out.println(request.getRequestURI()+":"+request.getContextPath());%>
<head>
<title>MyConf.org--<bean:message key="common.title.keyword"/></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<html:rewrite page="/css/main.css"/>" rel="stylesheet" type="text/css">
<link href="<html:rewrite page="/css/global.css"/>" rel="stylesheet" type="text/css">
<SCRIPT language="javascript" src="<html:rewrite page="/js/common.js"/>" type="text/javascript"></SCRIPT>
</head>