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

<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>
<head>
    
    <title>upload</title>
    <style>
    	body,input {font-size: 12px; font-family: "Verdana", "Verdana"}
    	.button { border-width: 1px; height:18px;}
    </style>
</head>
<body leftmargin='10' topmargin='0' marginwidth='0' marginheight='0' class="form_row_submit">
<form name="attachfile" method="POST" enctype="multipart/form-data" action="<%=request.getContextPath()%>/servlet/fckeditor_upload" onsubmit="return check(this);">	
    <input type="hidden" name="fromPage" value="/site/site_content_attach.jsp">	
    <input type="hidden" name="Type" value="File" class="form_row_submit">
     <input type="hidden" name="filename"  >
    <input type="file" name="NewFile" id="NewFile" size="38" class="button">
    <input type="submit"  onclick="javascript:setname()" value="<bean:message key="page.site.content_attachadd" bundle="site" />"  name="eventSubmit_UploadImage" class="button">
</form>
</body>

<script language="javascript">
function setname(){
	var filename = document.getElementById("NewFile");
	document.attachfile.filename.value=filename.value;

}
	
function check(theForm){
	filetype=new   Array();   
 	filetype[0]="doc";     
  	filetype[1]="txt";     
  	filetype[2]="xls";
  	filetype[3]="pdf"; 
  	filetype[4]="ppt";   
  	filetype[5]="zip"; 
  	filetype[6]="rar";  
	
	var filename = document.getElementById("NewFile");
	if((theForm.NewFile.value.length==0)){
		
		alert("<bean:message key="page.site.setting_uploadfile_notnull" bundle="site" />");
		theForm.NewFile.focus();
		return false;
	}
	var flag=0;
	for(var i=0;i<filetype.length;i++){
	if((filename.value.substring(filename.value.length-3).toLowerCase())==filetype[i])
		flag++;
		}	
	if(flag==0){
		alert("<bean:message key="page.site.setting_contentattach_filetype" bundle="site" />");
		theForm.NewFile.focus();
		return false;
	
		}
	theForm.eventSubmit_UploadImage.disabled = true;
	return true;
}	
 <%
 	int errno=1;
	String upload_image_msg="";
	String upload_image_uri="";
	String filename="";
	String fileName="";
	String url="";
	String name="";
 
 
	 upload_image_msg=(String) request.getAttribute("upload_image_msg");
	 Integer upload_image_errno=(Integer) request.getAttribute("upload_image_errno");
	 if(upload_image_errno!=null){
		 errno=upload_image_errno.intValue();
		 }
	 upload_image_uri=(String) request.getAttribute("upload_image_uri");
	 fileName=(String) request.getAttribute("upload_image_name");
	
	 url=request.getContextPath()+"/"+upload_image_uri;
	 if(fileName!=null){
	 name=java.net.URLDecoder.decode(fileName,"UTF-8");
	 int a=fileName.lastIndexOf("\\");
	 int b=fileName.lastIndexOf(".");
		filename=fileName.substring(a,b);	
		}

	
	
 %>	
 <%
   if(errno == 0){%>		
		var filename1 = document.getElementById("NewFile");
		var oEditor = window.top.FCKeditorAPI.GetInstance("pagetext");
		<!--var html = "<img src='<%=upload_image_uri%>'/><a href="<%=upload_image_uri%>">  </a>";-->
		var html = "<a href='<%=upload_image_uri%>'><%=filename%></a>";
		oEditor.InsertHtml(html);
<%}%>
</script>
</html>
