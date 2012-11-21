<%@ page contentType="text/html;charset=gb2312"%>
<%
System.out.println("aa");
//org.myconf.util.MailSender.testSend();
System.out.println("/my/myconf/dir/my.jsp".replaceAll("/my",""));
%>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body>
<form name="form1" method="post" action="">
  <input name="a" type="checkbox" id="a" value="11">
  11 
  <input name="a" type="checkbox" id="a" value="22">
  22 
  <input name="a" type="checkbox" id="a" value="33">
  33 
  <input name="a" type="checkbox" id="a" value="44">
  44 
  <input type="submit" name="Submit" value="Submit">
</form>
</body>
</html>
