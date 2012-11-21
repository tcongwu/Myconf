<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="author" />
<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.Globals" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.util.StringUtils" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.struts.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
//*********************************
//variable
//*********************************
%>
<jsp:useBean id="uinfo" class="org.myconf.SessionUserObject" scope="request" />
<%
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);

String[] fms=ConfigDAO.getFileTypes(ConfigBean.CONFIG_ID);
List subs=SubjectDAO.list();
int i=0;
Locale loc=RequestUtils.getUserLocale(request, null);
if(loc==null)
	throw new Exception(Globals.getMessage("common", "error.language.null"));
%>

<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />

<body<%if(conf!=null && conf.isStage()==ConfigBean.STAGE_SUBMISSION){%> onLoad="init();"<%}%>>
<%
//*********************************
//top
//*********************************
%>
<jsp:include page="/inc/top.jsp" />
<jsp:include page="/inc/logo_author.jsp" />
<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/submission/sub/mainmenu2.jsp" />
<br>
<script language="JavaScript">
function displayAuthor(num){
	for(var i=1; i<=18; i++){
		if(i<=num){
			showLayer('author'+i);
		}else{
			hideLayer('author'+i);
		}
	}
}
function moreAuthor(obj){
	var sum=obj.value;
	if(sum<18){
		obj.value=1*sum+1;
		displayAuthor(1*sum+1);
	}
}
function lessAuthor(obj){
	var sum=obj.value;
	if(sum>1){
		obj.value=sum-1
		displayAuthor(sum-1);
	}
}
</script>
<SCRIPT language="javascript">
function init()
{
	subform.ctitle.value='<%=StringUtils.exportString(uinfo.getName().getTitle())%>';
	subform.country.value='<%=StringUtils.exportString(uinfo.getCountry())%>';
	displayAuthor(subform.asum.value);
}
function checkForm()
{
	if (trim(subform.title.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.title.focus();
		return false;
	}
	if (subform.subject.value.length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.subject.focus();
		return false;
	}
	if (trim(subform.abstr.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.abstr.focus();
		return false;
	}
	var sum=subform.asum.value;
	if(sum>0){
		for(var i=1;i<=sum;i++){
			if (eval("trim(subform.authorFirstName"+i+".value).length == 0")) {
				alert("<bean:message key="error.staritem.not.null"/>");
				eval("subform.authorFirstName"+i+".focus()");
				return false;
			}
		}
		for(var i=1;i<=sum;i++){
			if (eval("trim(subform.authorLastName"+i+".value).length == 0")) {
				alert("<bean:message key="error.staritem.not.null"/>");
				eval("subform.authorLastName"+i+".focus()");
				return false;
			}
		}
	}
	if (trim(subform.firstName.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.firstName.focus();
		return false;
	}
	if (trim(subform.lastName.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.lastName.focus();
		return false;
	}
	if (trim(subform.workLocation.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.workLocation.focus();
		return false;
	}
	if (trim(subform.phone.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.phone.focus();
		return false;
	}
	if (trim(subform.address.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.address.focus();
		return false;
	}
	if (trim(subform.country.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.country.focus();
		return false;
	}
	if (trim(subform.postcode.value).length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		subform.postcode.focus();
		return false;
	}
	if (trim(subform.pfile.value).length == 0) {
		alert("<bean:message key="error.paper.file.not.null"/>");
		subform.pfile.focus();
		return false;
	}
	return true;
}
</script>
<TABLE width=778 height="84" border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
  <TBODY>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=5><img src="<html:rewrite page="/images/rounded_top.gif"/>" width="778" height="5"></TD>
    </TR>
    <TR> 
      <TD width=1 height="73" noWrap bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
      <TD width=776 vAlign=top noWrap>
      	<%if(conf!=null && conf.isStage()==ConfigBean.STAGE_SUBMISSION){%>
      	<form action="<html:rewrite page="/paper.do"/>" method="post" enctype="multipart/form-data" onSubmit="return checkForm();" name="subform" id="subform">
		  <input type="hidden" name="eventSubmit_UploadPaper" value="1"/>
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr> 
              <td class="pagecontent_title"><b><bean:message key="page.subpage.title.profile" bundle="author"/></b></td>
            </tr>
          </table>
          <br>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
            <tr> 
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                  <tr> 
                    <td> <li><bean:message key="page.subpage.ins.profile" bundle="author"/></li></td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title">*<bean:message key="page.subpage.form.title" bundle="author"/></td>
              <td width="82%" class="form_row_content"><input name="title" type="text" id="title" size="80"> 
                &nbsp;</td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title">*<bean:message key="page.subpage.form.subject" bundle="author"/></td>
              <td width="82%" class="form_row_content"><select name="subject" id="subject">
                  <option value="" selected><bean:message key="page.subpage.form.subject.please" bundle="author"/></option>
                  <%
                  	SubjectBean sub=null;
                  	if((subs!=null)&&(subs.size()>0)){
                  		for(i=0;i<subs.size();i++){
                  			sub=(SubjectBean)subs.get(i);
                  %>
                  <option value="<%=sub.getId()%>"><%=StringUtils.exportString(sub.getSubject())%></option>
                  <%}}%>
                </select></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="18%" class="form_row_title">*<bean:message key="page.subpage.form.abstract" bundle="author"/></td>
              <td width="82%" class="form_row_content">&nbsp;&nbsp;<bean:message key="page.subpage.form.abstract.ins" bundle="author"/></strong></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td class="form_row_content"> <div class="spacer_5"></div>
                <textarea name="abstr" id="abstr" style="width:80%;height:280px"></textarea> 
                <div class="spacer_5"></div></td>
            </tr>
          </table>
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr> 
              <td class="pagecontent_title"><b><bean:message key="page.subpage.title.author" bundle="author"/></b></td>
            </tr>
          </table>
          <br>
          <input name="asum" type="hidden" id="asum" value="1">
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
            <tr> 
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                  <tr> 
                    <td> <li><bean:message key="page.subpage.ins.author1" bundle="author"/></li>
                      <li><bean:message key="page.subpage.ins.author2" bundle="author"/></li></td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title">&nbsp;</td>
              <td width="23%" class="form_row_title">*<bean:message key="page.subpage.form.author.firstname" bundle="author"/></td>
              <td width="23%" class="form_row_title">*<bean:message key="page.subpage.form.author.lastname" bundle="author"/></td>
              <td width="23%" class="form_row_title"><bean:message key="page.subpage.form.author.email" bundle="author"/></td>
              <td width="23%" class="form_row_title"><bean:message key="page.subpage.form.author.institute" bundle="author"/></td>
            </tr>
          </table>
          <table id="author1" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>1</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName1" type="text" id="authorFirstName1"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName1" type="text" id="authorLastName1"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail1" type="text" id="authorEmail1"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute1" type="text" id="auhtorInstitute1"></td>
            </tr>
          </table>
          <table id="author2" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>2</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName2" type="text" id="authorFirstName2"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName2" type="text" id="authorLastName2"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail2" type="text" id="authorEmail2"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute2" type="text" id="auhtorInstitute2"></td>
            </tr>
          </table>
          <table id="author3" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>3</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName3" type="text" id="authorFirstName3"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName3" type="text" id="authorLastName3"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail3" type="text" id="authorEmail3"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute3" type="text" id="auhtorInstitute3"></td>
            </tr>
          </table>
          <table id="author4" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>4</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName4" type="text" id="authorFirstName4"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName4" type="text" id="authorLastName4"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail4" type="text" id="authorEmail4"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute4" type="text" id="auhtorInstitute4"></td>
            </tr>
          </table>
          <table id="author5" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>5</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName5" type="text" id="authorFirstName5"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName5" type="text" id="authorLastName5"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail5" type="text" id="authorEmail5"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute5" type="text" id="auhtorInstitute5"></td>
            </tr>
          </table>
          <table id="author6" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>6</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName6" type="text" id="authorFirstName6"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName6" type="text" id="authorLastName6"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail6" type="text" id="authorEmail6"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute6" type="text" id="auhtorInstitute6"></td>
            </tr>
          </table>
          <table id="author7" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>7</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName7" type="text" id="authorFirstName7"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName7" type="text" id="authorLastName7"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail7" type="text" id="authorEmail7"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute7" type="text" id="auhtorInstitute7"></td>
            </tr>
          </table>
          <table id="author8" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>8</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName8" type="text" id="authorFirstName8"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName8" type="text" id="authorLastName8"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail8" type="text" id="authorEmail8"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute8" type="text" id="auhtorInstitute8"></td>
            </tr>
          </table>
          <table id="author9" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>9</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName9" type="text" id="authorFirstName9"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName9" type="text" id="authorLastName9"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail9" type="text" id="authorEmail9"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute9" type="text" id="auhtorInstitute9"></td>
            </tr>
          </table>
          <table id="author10" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>10</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName10" type="text" id="authorFirstName10"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName10" type="text" id="authorLastName10"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail10" type="text" id="authorEmail10"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute10" type="text" id="auhtorInstitute10"></td>
            </tr>
          </table>
          <table id="author11" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>11</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName11" type="text" id="authorFirstName11"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName11" type="text" id="authorLastName11"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail11" type="text" id="authorEmail11"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute11" type="text" id="auhtorInstitute11"></td>
            </tr>
          </table>
          <table id="author12" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>12</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName12" type="text" id="authorFirstName12"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName12" type="text" id="authorLastName12"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail12" type="text" id="authorEmail12"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute12" type="text" id="auhtorInstitute12"></td>
            </tr>
          </table>
          <table id="author13" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>13</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName13" type="text" id="authorFirstName13"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName13" type="text" id="authorLastName13"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail13" type="text" id="authorEmail13"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute13" type="text" id="auhtorInstitute13"></td>
            </tr>
          </table>
          <table id="author14" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>14</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName14" type="text" id="authorFirstName14"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName14" type="text" id="authorLastName14"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail14" type="text" id="authorEmail14"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute14" type="text" id="auhtorInstitute14"></td>
            </tr>
          </table>
          <table id="author15" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>15</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName15" type="text" id="authorFirstName15"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName15" type="text" id="authorLastName15"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail15" type="text" id="authorEmail15"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute15" type="text" id="auhtorInstitute15"></td>
            </tr>
          </table>
          <table id="author16" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>16</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName16" type="text" id="authorFirstName16"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName16" type="text" id="authorLastName16"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail16" type="text" id="authorEmail16"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute16" type="text" id="auhtorInstitute16"></td>
            </tr>
          </table>
          <table id="author17" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>17</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName17" type="text" id="authorFirstName17"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName17" type="text" id="authorLastName17"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail17" type="text" id="authorEmail17"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute17" type="text" id="auhtorInstitute17"></td>
            </tr>
          </table>
          <table id="author18" width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="8%" class="form_row_title"><%=Globals.SH%>18</td>
              <td width="23%" class="form_row_grid"><input name="authorFirstName18" type="text" id="authorFirstName18"></td>
              <td width="23%" class="form_row_grid"><input name="authorLastName18" type="text" id="authorLastName18"></td>
              <td width="23%" class="form_row_grid"><input name="authorEmail18" type="text" id="authorEmail18"></td>
              <td width="23%" class="form_row_grid"><input name="authorInstitute18" type="text" id="auhtorInstitute18"></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td class="form_row_submit"><input name="more" onClick="moreAuthor(subform.asum)" type="button" class="button" id="more" value="<bean:message key="page.subpage.form.addauthor" bundle="author"/>"> 
                <input name="less" onClick="lessAuthor(subform.asum)" type="button" class="button" id="less" value="<bean:message key="page.subpage.form.lessauthor" bundle="author"/>"> 
              </td>
            </tr>
          </table>
          <br>
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr> 
              <td class="pagecontent_title"><b><bean:message key="page.subpage.title.contact" bundle="author"/></b></td>
            </tr>
          </table>
          <br>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
            <tr> 
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                  <tr> 
                    <td> <li><bean:message key="page.subpage.ins.contact" bundle="author"/></li>
                      </td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="20%" height="25" class="form_row_title"><bean:message key="page.subpage.form.ctitle" bundle="author"/></td>
              <td width="30%" class="form_row_content"><select name="ctitle" id="ctitle">
                  <option value=""> </option>
                  <option value="Mr.">Mr.</option>
                  <option value="Ms.">Ms.</option>
                  <option value="Dr.">Dr.</option>
                  <option value="Prof.">Prof.</option>
                  <%if(loc.equals(Locale.SIMPLIFIED_CHINESE) || loc.equals(Locale.TRADITIONAL_CHINESE)){%>
                  <option value="<bean:message key="common.title.mr"/>"><bean:message key="common.title.mr"/></option>
                  <option value="<bean:message key="common.title.ms"/>"><bean:message key="common.title.ms"/></option>
                  <option value="<bean:message key="common.title.dr"/>"><bean:message key="common.title.dr"/></option>
                  <option value="<bean:message key="common.title.prof"/>"><bean:message key="common.title.prof"/></option>
                  <%}%>
                </select></td>
              <td width="20%" class="form_row_content">&nbsp;</td>
              <td width="30%" class="form_row_content">&nbsp;</td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="20%" height="25" class="form_row_title">*<bean:message key="page.subpage.form.firstname" bundle="author"/></td>
              <td width="30%" class="form_row_grid"><input name="firstName" type="text" id="firstName" size="26" value="<%=StringUtils.exportString(uinfo.getName().getFirstName())%>"></td>
              <td width="20%" class="form_row_title"><bean:message key="page.subpage.form.fax" bundle="author"/></td>
              <td width="30%" class="form_row_content"><input name="fax" type="text" id="fax" size="26" value="<%=StringUtils.exportString(uinfo.getFax())%>"></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="20%" height="25" class="form_row_title">*<bean:message key="page.subpage.form.lastname" bundle="author"/></td>
              <td width="30%" class="form_row_grid"><input name="lastName" type="text" id="lastName" size="26" value="<%=StringUtils.exportString(uinfo.getName().getLastName())%>"></td>
              <td width="20%" class="form_row_title">*<bean:message key="page.subpage.form.address" bundle="author"/></td>
              <td width="30%" class="form_row_content"><input name="address" type="text" id="address" size="26" value="<%=StringUtils.exportString(uinfo.getAddress())%>"></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="20%" height="25" class="form_row_title">*<bean:message key="page.subpage.form.worklocation" bundle="author"/></td>
              <td width="30%" class="form_row_grid"><input name="workLocation" type="text" id="workLocation" size="26" value="<%=StringUtils.exportString(uinfo.getWorkLocation())%>"></td>
              <td width="20%" class="form_row_title"><bean:message key="page.subpage.form.state" bundle="author"/></td>
              <td width="30%" class="form_row_content"><input name="state" type="text" id="state" size="26" value="<%=StringUtils.exportString(uinfo.getState())%>"></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="20%" height="25" class="form_row_title"><bean:message key="page.subpage.form.research" bundle="author"/></td>
              <td width="30%" class="form_row_grid"><input name="research" type="text" id="research" size="26" value="<%=StringUtils.exportString(uinfo.getResearch())%>"></td>
              <td width="20%" class="form_row_title">*<bean:message key="page.subpage.form.country" bundle="author"/></td>
              <td width="30%" class="form_row_content">
			  <SELECT name=country size=1 id="country" style="width:180px;">
			  	<OPTION value="" selected><bean:message key="common.list.please.select"/></OPTION>
				<OPTION value="Afghanistan">Afghanistan</OPTION>
				<OPTION value="Albania">Albania</OPTION>
				<OPTION value="Algeria">Algeria</OPTION> 
              	<OPTION value="American Samoa">American Samoa</OPTION>
				<OPTION value="Andorra">Andorra</OPTION>
				<OPTION value="Angola">Angola</OPTION>
				<OPTION value="Anguilla">Anguilla</OPTION>
				<OPTION value="Antarctica">Antarctica</OPTION> 
              	<OPTION value="Antigua and Barbuda">Antigua and Barbuda</OPTION>
				<OPTION value="Argentina">Argentina</OPTION>
				<OPTION value="Armenia">Armenia</OPTION> 
              	<OPTION value="Aruba">Aruba</OPTION>
				<OPTION value="Australia">Australia</OPTION>
				<OPTION value="Austria">Austria</OPTION> 
              	<OPTION value="Azerbaijan">Azerbaijan</OPTION>
				<OPTION value="Bahamas">Bahamas</OPTION>
				<OPTION value="Bahrain">Bahrain</OPTION> 
              	<OPTION value="Bangladesh">Bangladesh</OPTION>
				<OPTION value="Barbados">Barbados</OPTION>
				<OPTION value="Belarus">Belarus</OPTION> 
              	<OPTION value="Belgium">Belgium</OPTION>
				<OPTION value="Belize">Belize</OPTION> 
              	<OPTION value="Benin">Benin</OPTION>
				<OPTION value="Bermuda">Bermuda</OPTION> 
              	<OPTION value="Bhutan">Bhutan</OPTION>
				<OPTION value="Bolivia">Bolivia</OPTION> 
              	<OPTION value="Bosnia and Herzegovina">Bosnia and Herzegovina</OPTION>
				<OPTION value="Botswana">Botswana</OPTION>
				<OPTION value="Brazil">Brazil</OPTION> 
              	<OPTION value="British Indian Ocean Territory">British Indian Ocean Territory</OPTION>
				<OPTION value="Brunei Darussalam">Brunei Darussalam</OPTION>
				<OPTION value="Bulgaria">Bulgaria</OPTION>
				<OPTION value="Burkina Faso">Burkina Faso</OPTION> 
              	<OPTION value="Burundi">Burundi</OPTION>
				<OPTION value="Cambodia">Cambodia</OPTION>
				<OPTION value="Cameroon">Cameroon</OPTION> 
              	<OPTION value="Canada">Canada</OPTION>
				<OPTION value="Cape Verde">Cape Verde</OPTION>
				<OPTION value="Cayman Islands">Cayman Islands</OPTION>
				<OPTION value="Central African Republic">Central African Republic</OPTION>
				<OPTION value="Chad">Chad</OPTION>
				<OPTION value="Chile">Chile</OPTION>
				<OPTION value="China">China</OPTION>
              	<OPTION value="China, Hong Kong">China, Hong Kong</OPTION>
				<OPTION value="China, Taiwan">China, Taiwan</OPTION> 
				<OPTION value="Colombia">Colombia</OPTION>
				<OPTION value="Comoros">Comoros</OPTION>
				<OPTION value="Congo">Congo</OPTION>
				<OPTION value="Congo, Dem. Republic of the">Congo, Dem. Republic of the</OPTION>
				<OPTION value="Cook Islands">Cook Islands</OPTION>
				<OPTION value="Costa Rica">Costa Rica</OPTION>
				<OPTION value="Croatia">Croatia</OPTION>
				<OPTION value="Cuba">Cuba</OPTION>
				<OPTION value="Cyprus">Cyprus</OPTION>
				<OPTION value="Czech Republic">Czech Republic</OPTION>
				<OPTION value="Denmark">Denmark</OPTION> 
              	<OPTION value="Djibouti">Djibouti</OPTION>
				<OPTION value="Dominica">Dominica</OPTION>
				<OPTION value="Dominican Republic">Dominican Republic</OPTION>
				<OPTION value="East Timor">East Timor</OPTION>
				<OPTION value="Ecuador">Ecuador</OPTION>
				<OPTION value="Egypt">Egypt</OPTION>
				<OPTION value="El Salvador">El Salvador</OPTION>
				<OPTION value="Equatorial Guinea">Equatorial Guinea</OPTION>
				<OPTION value="Eritrea">Eritrea</OPTION>
				<OPTION value="Estonia">Estonia</OPTION>
				<OPTION value="Ethiopia">Ethiopia</OPTION> 
              	<OPTION value="Falkland Islands">Falkland Islands</OPTION>
				<OPTION value="Faroe Islands">Faroe Islands</OPTION>
				<OPTION value="Fiji">Fiji</OPTION>
				<OPTION value="Finland">Finland</OPTION>
				<OPTION value="France">France</OPTION>
				<OPTION value="French Guiana">French Guiana</OPTION>
				<OPTION value="French olynesia">French olynesia</OPTION>
				<OPTION value="Gabon">Gabon</OPTION>
				<OPTION value="Gambia">Gambia</OPTION>
				<OPTION value="Georgia">Georgia</OPTION>
				<OPTION value="Germany">Germany</OPTION>
				<OPTION value="Ghana">Ghana</OPTION>
				<OPTION value="Gibraltar">Gibraltar</OPTION>
				<OPTION value="Greece">Greece</OPTION> 
              	<OPTION value="Greenland">Greenland</OPTION>
				<OPTION value="Grenada">Grenada</OPTION>
				<OPTION value="Guadeloupe">Guadeloupe</OPTION> 
              	<OPTION value="Guam">Guam</OPTION>
				<OPTION value="Guatemala">Guatemala</OPTION> 
              	<OPTION value="Guinea">Guinea</OPTION>
				<OPTION value="Guinea-Bissau">Guinea-Bissau</OPTION>
				<OPTION value="Guyana">Guyana</OPTION> 
              	<OPTION value="Haiti">Haiti</OPTION>
				<OPTION value="Honduras">Honduras</OPTION> 
				<OPTION value="Hungary">Hungary</OPTION>
				<OPTION value="Iceland">Iceland</OPTION> 
              	<OPTION value="India">India</OPTION>
				<OPTION value="Indonesia">Indonesia</OPTION>
				<OPTION value="Iran">Iran</OPTION>
				<OPTION value="Iraq">Iraq</OPTION>
				<OPTION value="Ireland">Ireland</OPTION>
				<OPTION value="Israel">Israel</OPTION>
				<OPTION value="Italy">Italy</OPTION>
				<OPTION value="Ivory Coast">Ivory Coast</OPTION>
				<OPTION value="Jamaica">Jamaica</OPTION> 
             	<OPTION value="Japan">Japan</OPTION>
				<OPTION value="Jordan">Jordan</OPTION> 
              	<OPTION value="Kazakstan">Kazakstan</OPTION>
				<OPTION value="Kenya">Kenya</OPTION>
				<OPTION value="Kiribati">Kiribati</OPTION>
				<OPTION value="Korea, North">Korea, North</OPTION>
				<OPTION value="Korea, South">Korea, South</OPTION>
				<OPTION value="Kuwait">Kuwait</OPTION>
				<OPTION value="Kyrgyzstan">Kyrgyzstan</OPTION>
				<OPTION value="Laos">Laos</OPTION> 
              	<OPTION value="Latvia">Latvia</OPTION>
				<OPTION value="Lebanon">Lebanon</OPTION> 
             	<OPTION value="Lesotho">Lesotho</OPTION>
				<OPTION value="Liberia">Liberia</OPTION>
				<OPTION value="Libya">Libya</OPTION>
				<OPTION value="Liechtenstein">Liechtenstein</OPTION>
				<OPTION value="Lithuania">Lithuania</OPTION>
				<OPTION value="Luxembourg">Luxembourg</OPTION> 
                <OPTION value="Macau">Macau</OPTION>
				<OPTION value="Macedonia">Macedonia</OPTION>
				<OPTION value="Madagascar">Madagascar</OPTION> 
                <OPTION value="Malawi">Malawi</OPTION>
				<OPTION value="Malaysia">Malaysia</OPTION>
				<OPTION value="Maldives">Maldives</OPTION> 
                <OPTION value="Mali">Mali</OPTION>
				<OPTION value="Malta">Malta</OPTION> 
                <OPTION value="Marshall Islands">Marshall Islands</OPTION>
				<OPTION value="Martinique">Martinique</OPTION>
				<OPTION value="Mauritania">Mauritania</OPTION> 
                <OPTION value="Mauritius">Mauritius</OPTION>
				<OPTION value="Mayotte">Mayotte</OPTION>
				<OPTION value="Mexico">Mexico</OPTION>
				<OPTION value="Micronesia, Federated States of">Micronesia, Federated States of</OPTION>
				<OPTION value="Moldova">Moldova</OPTION>
				<OPTION value="Monaco">Monaco</OPTION>
				<OPTION value="Mongolia">Mongolia</OPTION>
				<OPTION value="Montserrat">Montserrat</OPTION> 
                <OPTION value="Morocco">Morocco</OPTION>
				<OPTION value="Mozambique">Mozambique</OPTION>
				<OPTION value="Myanmar">Myanmar</OPTION> 
                <OPTION value="Namibia">Namibia</OPTION>
				<OPTION value="Nauru">Nauru</OPTION> 
                <OPTION value="Nepal">Nepal</OPTION>
				<OPTION value="Netherlands">Netherlands</OPTION>
				<OPTION value="Netherlands Antilles">Netherlands Antilles</OPTION>
				<OPTION value="New Caledonia">New Caledonia</OPTION>
				<OPTION value="New Zealand">New Zealand</OPTION>
				<OPTION value="Nicaragua">Nicaragua</OPTION> 
                <OPTION value="Niger">Niger</OPTION>
				<OPTION value="Nigeria">Nigeria</OPTION> 
                <OPTION value="Niue">Niue</OPTION>
				<OPTION value="Norfolk Island">Norfolk Island</OPTION>
				<OPTION value="Northern Mariana Islands">Northern Mariana Islands</OPTION> 
                <OPTION value="Norway">Norway</OPTION>
				<OPTION value="Oman">Oman</OPTION> 
                <OPTION value="Pakistan">Pakistan</OPTION>
				<OPTION value="Palau">Palau</OPTION> 
                <OPTION value="Palestinian Territory">Palestinian Territory</OPTION>
				<OPTION value="Panama">Panama</OPTION>
				<OPTION value="Papua New Guinea">Papua New Guinea</OPTION>
				<OPTION value="Paraguay">Paraguay</OPTION>
				<OPTION value="Peru">Peru</OPTION>
				<OPTION value="Philippines">Philippines</OPTION> 
                <OPTION value="Pitcairn">Pitcairn</OPTION>
				<OPTION value="Poland">Poland</OPTION>
				<OPTION value="Portugal">Portugal</OPTION> 
                <OPTION value="Puerto Rico">Puerto Rico</OPTION>
				<OPTION value="Qatar">Qatar</OPTION>
				<OPTION value="Reunion">Reunion</OPTION>
				<OPTION value="Romania">Romania</OPTION>
				<OPTION value="Russia">Russia</OPTION> 
				<OPTION value="Rwanda">Rwanda</OPTION> 
				<OPTION value="Saint Helena">Saint Helena</OPTION> 
                <OPTION value="Saint Kitts and Nevis">Saint Kitts and Nevis</OPTION> 
				<OPTION value="Saint Lucia">Saint Lucia</OPTION>  
				<OPTION value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</OPTION> 
				<OPTION value="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</OPTION> 
				<OPTION value="Samoa">Samoa</OPTION> 
				<OPTION value="San Marino">San Marino</OPTION> 
				<OPTION value="Sao Tome and Principe">Sao Tome and Principe</OPTION> 
				<OPTION value="Saudi Arabia">Saudi Arabia</OPTION> 
				<OPTION value="Senegal">Senegal</OPTION> 
				<OPTION value="Seychelles">Seychelles</OPTION> 
                <OPTION value="Sierra Leone">Sierra Leone</OPTION> 
				<OPTION value="Singapore">Singapore</OPTION> 
				<OPTION value="Slovakia">Slovakia</OPTION> 
                <OPTION value="Slovenia">Slovenia</OPTION> 
				<OPTION value="Solomon Islands">Solomon Islands</OPTION> 
				<OPTION value="Somalia">Somalia</OPTION> 
				<OPTION value="South Africa">South Africa</OPTION> 
				<OPTION value="Spain">Spain</OPTION> 
                <OPTION value="Sri Lanka">Sri Lanka</OPTION> 
				<OPTION value="Sudan">Sudan</OPTION> 
				<OPTION value="Suriname">Suriname</OPTION> 
				<OPTION value="Swaziland">Swaziland</OPTION> 
				<OPTION value="Sweden">Sweden</OPTION> 
                <OPTION value="Switzerland">Switzerland</OPTION> 
				<OPTION value="Syria">Syria</OPTION> 
				<OPTION value="Tajikistan">Tajikistan</OPTION> 
				<OPTION value="Tanzania">Tanzania</OPTION> 
                <OPTION value="Thailand">Thailand</OPTION> 
				<OPTION value="Togo">Togo</OPTION> 
                <OPTION value="Tokelau">Tokelau</OPTION> 
				<OPTION value="Tonga">Tonga</OPTION> 
                <OPTION value="Trinidad And Tobago">Trinidad And Tobago</OPTION> 
				<OPTION value="Tunisia">Tunisia</OPTION> 
				<OPTION value="Turkey">Turkey</OPTION> 
				<OPTION value="Turkmenistan">Turkmenistan</OPTION> 
				<OPTION value="Turks and Caicos Islands">Turks and Caicos Islands</OPTION> 
				<OPTION value="Tuvalu">Tuvalu</OPTION> 
				<OPTION value="Uganda">Uganda</OPTION> 
				<OPTION value="Ukraine">Ukraine</OPTION> 
				<OPTION value="United Arab Emirates">United Arab Emirates</OPTION> 
				<OPTION value="United Kingdom">United Kingdom</OPTION> 
				<OPTION value="United States">United States</OPTION> 
				<OPTION value="United States Minor Outlying Islands">United States Minor Outlying Islands</OPTION> 
				<OPTION value="Uruguay">Uruguay</OPTION> 
				<OPTION value="Uzbekistan">Uzbekistan</OPTION> 
                <OPTION value="Vanuatu">Vanuatu</OPTION> 
				<OPTION value="Vatican City">Vatican City</OPTION> 
				<OPTION value="Venezuela">Venezuela</OPTION> 
				<OPTION value="Viet Nam">Viet Nam</OPTION> 
				<OPTION value="Virgin Islands, British">Virgin Islands, British</OPTION> 
				<OPTION value="Virgin Islands, U.S.">Virgin Islands, U.S.</OPTION> 
                <OPTION value="Wallis and Futuna">Wallis and Futuna</OPTION> 
				<OPTION value="Western Sahara">Western Sahara</OPTION> 
				<OPTION value="Yemen">Yemen</OPTION> 
                <OPTION value="Zambia">Zambia</OPTION> 
				<OPTION value="Zimbabwe">Zimbabwe</OPTION> 
				<OPTION value="other">other</OPTION></SELECT></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td width="20%" height="25" class="form_row_title">*<bean:message key="page.subpage.form.phone" bundle="author"/></td>
              <td width="30%" class="form_row_grid"><input name="phone" type="text" id="phone" size="26" value="<%=StringUtils.exportString(uinfo.getPhone())%>"></td>
              <td width="20%" class="form_row_title">*<bean:message key="page.subpage.form.postcode" bundle="author"/></td>
              <td width="30%" class="form_row_content"><input name="postcode" type="text" id="postcode" size="26" value="<%=StringUtils.exportString(uinfo.getPostcode())%>"></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td class="form_row_submit">&nbsp; </td>
            </tr>
          </table>
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr> 
              <td class="pagecontent_title"><b><bean:message key="page.subpage.title.upload" bundle="author"/></b></td>
            </tr>
          </table>
          <br>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form">
            <tr> 
              <td><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
                  <tr> 
                    <td> <bean:message key="page.subpage.ins.upload" bundle="author"/> 
	                  <%
	                  	if((fms!=null)&&(fms.length>0)){
	                  		for(i=0;i<fms.length;i++){
	                  %>
                      <li class="blackbold">.<%=fms[i]%></li>
                      <%}}%>
                    </td>
                  </tr>
                </table></td>
            </tr>
          </table>
          <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
            <tr> 
              <td height="25" class="form_row_content">
			  	<div class="spacer_20"></div>
			  	<input name="pfile" type="file" id="pfile" size="58">
				<div class="spacer_20"></div></td>
            </tr>
          </table>
          <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0" class="line_dashed">
            <tr> 
              <td align="center" class="graybar"> 
                <input name="eventSubmit_UploadPaper" type="submit" id="eventSubmit_UploadPaper" style="width: 180px; height: 24px;" value="<bean:message key="page.subpage.form.submit" bundle="author"/>">
			  </td>
            </tr>
          </table>
		  <div class="spacer_5"></div>
        </form>
        <%}else{%>
      	<TABLE width="518" border="0" align="center" cellPadding=5 cellSpacing=0>
          <TBODY>
            <TR> 
              <TD align="center" height="180" style="font-size:16px;" class="redins"><bean:message key="error.submission.closed"/></TD>
            </TR>
          </TBODY>
        </TABLE>
        <%}%>
      </TD>
      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
    </TR>
    <TR> 
      <TD noWrap width=778 colSpan=2 height=6><img src="<html:rewrite page="/images/rounded_bottom.gif"/>" width="778" height="5"></TD>
    </TR>
  </TBODY>
</TABLE>
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