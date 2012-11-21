<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="expert" />
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
//review data
ReviewBean review=ReviewDAO.getReview(RequestUtils.getParam(request, "id", 0));
if(review==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

//paper data
PaperBean paper=review.getPaper();
if(paper==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
//paper authors
List authors=paper.getAuthors();
AuthorBean author=null;
if(authors==null || authors.size()==0){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

//review refer list
List refers=ReferDAO.list();
ReferBean refer=null;

//status list
List statuses=StatusDAO.list();
StatusBean status=null;

ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
boolean isBegin=false;
if(conf!=null && conf.getReviewBeginDate()<System.currentTimeMillis() && conf.getReviewEndDate()>System.currentTimeMillis() && refers!=null && refers.size()>0 && statuses!=null && statuses.size()>0){
	isBegin=true;
}
boolean isReviewed=false;
if(review.getStatus()==ReviewBean.REVIEW_STATUS_FINISH){
	isReviewed=true;
}
%>

<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />

<body>
<%
//*********************************
//top
//*********************************
%>
<jsp:include page="/inc/logo_expert.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="common.title.review.paper" bundle="expert"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<%if(isBegin){%>
<script language="JavaScript">
function isCheckStatus(){
	if(review.recoStatus.length==null){
		if(review.recoStatus.checked){
			return true;
		}
	}else{
		for(var i=0;i<review.recoStatus.length;i++){
			if(review.recoStatus[i].checked){
				return true;
			}
		}
	}
	return false;
}
function checkForm(){
	<%
	  for(int i=0;i<refers.size();i++){
	  	refer=(ReferBean)refers.get(i);
	%>
	if (review.score<%=refer.getReferNo()%>.value.length == 0) {
		alert("<bean:message key="error.please.grade" arg0="<%=String.valueOf(refer.getReferNo())%>"/>");
		review.score<%=refer.getReferNo()%>.focus();
		return false;
	}
	if (!isRange(trim(review.score<%=refer.getReferNo()%>.value), "0123456789.")) {
		alert("<bean:message key="error.grade.must.number"/>");
		review.score<%=refer.getReferNo()%>.select();
		review.score<%=refer.getReferNo()%>.focus();
		return false;
	}
	<%}%>
	if(!isCheckStatus()){
		alert("<bean:message key="error.please.recommend.status"/>");
		return false;
	}
	return true;
}
</script>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/review.do"/>" method="post" onSubmit="return checkForm()" name="review" id="review">
        <input name="eventSubmit_Grade" type="hidden" id="eventSubmit_Grade" value="1">
        <input name="id" type="hidden" id="id" value="<%=review.getId()%>">
        <br>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="80%" class="form_row_bar"><bean:message key="common.title.paper.detail" bundle="admin"/></td>
            <td width="20%" align="right" class="form_row_bar"><div align="right"><a href="<html:rewrite page="/viewpaper.jsp?id="/><%=paper.getId()%>" target="_blank" class="blue"><bean:message key="common.text.viewpaper" bundle="expert"/></a></div></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content_title"><table width="80%" border="0" align="center" cellpadding="0" cellspacing="6">
                <tr>
                  <td align="center" class="blackbold"><%=paper.getTitle()%></td>
                </tr>
                <%if(conf.getIsAnony()==ConfigBean.FALSE){%>
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
                <%}%>
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
            <td class="form_row_bar"><bean:message key="page.reviewpaper.please.review" bundle="expert"/></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content_author"><table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
              </table> 
              <table width="92%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
                <tr> 
                  <td width="6%" align="center" nowrap class="table_head"><bean:message key="common.text.refer.no" bundle="expert"/></td>
                  <td width="47%" class="table_head" nowrap><bean:message key="common.text.refer.title" bundle="expert"/></td>
                  <td width="37%" nowrap class="table_head"><bean:message key="common.text.refer.description" bundle="expert"/></td>
                  <td width="10%" class="table_head" nowrap><bean:message key="common.text.refer.score.range" bundle="expert"/></td>
                </tr>
				<%
				  for(int i=0;i<refers.size();i++){
				  	refer=(ReferBean)refers.get(i);
				%>
                <tr> 
                  <td align="center" valign="top" class="table_cell"><%=refer.getReferNo()%></td>
                  <td valign="top" class="table_cell"><%=refer.getTitle()%></td>
                  <td valign="top" class="table_cell"><%=StringUtils.exportString(refer.getDescription())%></td>
                  <td valign="top" class="table_cell"><%=refer.getMinScore()%>~<%=refer.getMaxScore()%></td>
                </tr>
                <tr> 
                  <td colspan="4" nowrap class="table_cell"><font color="orange"><bean:message key="common.title.grade" bundle="expert"/></font> 
                    <input name="score<%=refer.getReferNo()%>" type="text" id="score<%=refer.getReferNo()%>" value="<%if(isReviewed){out.print(PropertyUtils.getSimpleProperty(review, "score"+refer.getReferNo()));}%>"></td>
                </tr>
                <%}%>
              </table>
              <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr> 
                  <td>&nbsp;</td>
                </tr>
              </table>
              <table width="92%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
                <tr> 
                  <td width="100%" nowrap class="table_head"><bean:message key="page.reviewpaper.opinion" bundle="expert"/></td>
                </tr>
                <tr> 
                  <td class="table_cell"><textarea name="opinion" cols="98" rows="5" id="opinion"><%if(isReviewed){out.print(StringUtils.exportString(review.getOpinion()));}%></textarea></td>
                </tr>
              </table>
              <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr> 
                  <td>&nbsp;</td>
                </tr>
              </table>
              <table width="92%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
                <tr> 
                  <td colspan="3" nowrap class="table_head"><bean:message key="common.title.recemmend.status" bundle="expert"/></td>
                </tr>
                <tr> 
                  <td colspan="3" class="table_cell">
					<%
					  for(int i=0;i<statuses.size();i++){
					  	status=(StatusBean)statuses.get(i);
					%>
                  	<input type="radio" name="recoStatus" value="<%=status.getId()%>"<%if(status.getId()==review.getRecoStatus() && isReviewed){out.print(" checked");}%>>
                    <font color="orange"><%=status.getStatus()%></font> 
                    <%}%>
                  </td>
                </tr>
              </table>
              <table width="92%" align="center" cellpadding="0" cellspacing="0">
                <tr> 
                  <td> <div class="spacer_20"></div>
                    <div class="line_dashed"></div>
                    <div class="spacer_10"></div></td>
                </tr>
              </table> 
              <table width="92%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr> 
                  <td> &nbsp; <input type="submit" id="sub" name="sub" value="<bean:message key="common.button.submit.review"/>" class="button"> 
                    &nbsp; <input name="back" type="button" class="button" id="back" onClick="window.close()" value="<bean:message key="common.button.back"/>"></td>
                </tr>
              </table></td>
          </tr>
        </table>
        </form></td>
  </tr>
</table>
<%}else{%>
<TABLE width=518 border=0 align="center" cellPadding=5 cellSpacing=0>
  <TBODY>
    <TR> 
      <TD height="64" align="center" class="redins" style="font-size:16px;"><bean:message key="common.ins.not.begin.review"/></TD>
    </TR>
  </TBODY>
</TABLE>
<%}%>
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