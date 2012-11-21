<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %> 
<html> 
<head> 
<title></title> 
</head> 
<body bgcolor="white"> 

<p><%=System.currentTimeMillis()%></p> 
<p><%=pageContext.getServletContext().getRealPath("/lyfcounter.txt")%></p> 
</body> 
</html>