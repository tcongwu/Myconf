<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="admin" />
<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.*" %>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.beanutils.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
//*********************************
//variable
//*********************************
%>
<%
//paper data
PaperBean paper=PaperDAO.getPaper(RequestUtils.getParam(request, "id", 0));
if(paper==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
//paper authors
List authors=paper.getAuthors();
AuthorBean author=null;
if(authors==null || authors.size()==0){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

//paper reviews
List reviews=paper.getReviews();
ReviewBean review=null;

//review refer list
List refers=ReferDAO.list();
ReferBean refer=null;
if(refers==null || refers.size()==0){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

//status list
List statuses=StatusDAO.list();
StatusBean status=null;
if(statuses==null || statuses.size()==0){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
%>

<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />

<body onLoad="currentStatus(<%=paper.getStatus()%>)">
<%
//*********************************
//top
//*********************************
%>
<jsp:include page="/inc/logo_admin.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="common.title.accept.paper" bundle="admin"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<script language="JavaScript">
function currentStatus(sta){
	if(sta==-1)
		sta='';
	result.status.value=sta;
}
function checkForm(){
	if (result.status.value.length == 0) {
		alert("<bean:message key="error.please.select.result"/>");
		result.status.focus();
		return false;
	}
	return true;
}
</script>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/paper.do"/>" method="post" onSubmit="return checkForm()" name="result" id="result">
        <input name="eventSubmit_Result" type="hidden" id="eventSubmit_Result" value="1">
        <input name="id" type="hidden" id="id" value="<%=paper.getId()%>">
        <input name="fromPage" type="hidden" id="fromPage" value="msgbox">
        <br>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="85%" class="form_row_bar"><bean:message key="common.title.paper.detail" bundle="admin"/></td>
            <td width="15%" align="right" class="form_row_bar"><div align="right"><a href="<html:rewrite page="/viewpaper.jsp?id="/><%=paper.getId()%>" target="_blank" class="blue"><bean:message key="common.text.download"/></a></div></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content_title"><table width="80%" border="0" align="center" cellpadding="0" cellspacing="6">
                <tr>
                  <td align="center" class="blackbold"><%=paper.getTitle()%></td>
                </tr>
                <tr>
                  <td align="center"><em>
			        <%
					  for(int i=0;i<authors.size();i++){
					  	author=(AuthorBean)authors.get(i);
			        %>
                  	<%=author.toString()%><br>
                  	<%}%>
                  </em></td>
                </tr>
                <tr>
                  <td><strong><bean:message key="page.paper.title.subject" bundle="admin"/></strong><%=paper.getSubject().getSubject()%></td>
                </tr>
                <tr>
                  <td><strong><bean:message key="page.paperassign.title.abstract" bundle="admin"/></strong><%=paper.getAbstr()%></td>
                </tr>
              </table>
              <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr> 
                  <td>&nbsp;</td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_bar"><bean:message key="common.title.expert.review" bundle="admin"/></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content_author">
		      <%
		        if(reviews!=null && reviews.size()>0){
		          for(int i=0;i<reviews.size();i++){
		          	review=(ReviewBean)reviews.get(i);
		          	if(review.getStatus()!=ReviewBean.REVIEW_STATUS_QUIT){
		      %>
              <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
              </table> 
              <table width="80%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
                <tr> 
                  <td colspan="3" nowrap class="table_head"><strong><bean:message key="common.title.expert" bundle="admin" arg0="<%=String.valueOf(i+1)%>"/><%=StringUtils.exportString(review.getExpertName())%></strong></td>
                </tr>
                <%if(review.getStatus()==ReviewBean.REVIEW_STATUS_FINISH){%>
                <%
                  for(int j=0;j<refers.size();j++){
                  	refer=(ReferBean)refers.get(j);
                %>
                <tr> 
                  <td width="9%" align="center" class="table_cell"><%=refer.getReferNo()%></td>
                  <td width="55%" class="table_cell"><%=refer.getTitle()%></td>
                  <td width="36%" class="table_cell"><%=PropertyUtils.getSimpleProperty(review, "score"+refer.getReferNo())%></td>
                </tr>
                <%}%>
                <tr> 
                  <td align="center" nowrap class="table_cell">--</td>
                  <td class="table_cell"><bean:message key="common.title.suggest.result" bundle="admin"/></td>
                  <td class="table_cell"><%=StringUtils.exportString(StatusDAO.getStatusInMap(review.getRecoStatus()))%></td>
                </tr>
                <%if(StringUtils.isNotEmpty(review.getOpinion())){%>
                <tr> 
                  <td colspan="3" class="table_cell"> <strong><bean:message key="common.title.review.opnion" bundle="admin"/></strong><%=review.getOpinion()%></td>
                </tr>
                <%}%>
                <%}else{%>
                <tr> 
                  <td colspan="3" align="center" class="table_cell"><strong style="color:red"><bean:message key="common.ins.review.not.finished"/></strong></td>
                </tr>
                <%}%>
              </table>
              <%}}%>
              <%}else{%>
              <table width="100%" border="0" cellpadding="5" cellspacing="0">
                <tr> 
                  <td align="center" class="blackbold" nowrap><bean:message key="common.text.norecord"/></td>
                </tr>
              </table>
              <%}%>
            </td>
          </tr>
        </table>
        <table width="90%" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td width="52%"> <div class="spacer_20"></div>
              <div class="line_dashed"></div>
              <div class="spacer_10"></div></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="16%" class="form_row_title"><strong><bean:message key="common.title.accept.paper" bundle="admin"/></strong></td>
            <td class="form_row_content_title">
              <select style="width:168px" name="status" id="status">
                <option value="" selected><bean:message key="common.list.please.select"/></option>
                <%
                  	for(int i=0;i<statuses.size();i++){
                  	  status=(StatusBean)statuses.get(i);
                %>
                <option value="<%=status.getId()%>"><%=status.getStatus()%></option>
                <%}%>
              </select>
              &nbsp; &nbsp; &nbsp; 
              <input type="submit" id="save" name="save" value="<bean:message key="common.button.accept"/>" class="button">
              &nbsp; 
              <input name="Button" type="button" onClick="window.close()" class="button" value="<bean:message key="common.button.back"/>"></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td>&nbsp; </tr>
        </table>
      </form></td>
  </tr>
</table>
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