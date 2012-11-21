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
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);

//paper data
PaperBean paper=PaperDAO.getPaper(RequestUtils.getParam(request, "id", 0));
if(paper==null){
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
<jsp:include page="/inc/logo_author.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="common.title.expert.review" bundle="admin"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<%if(conf!=null && conf.getIsProcess()==ConfigBean.TRUE && conf.getIsOpen()==ConfigBean.TRUE){%>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr>
    <td valign="top" class="pagecontent">
        <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td class="form_row_content_author">
		      <%
		        if(reviews!=null && reviews.size()>0){
		          for(int i=0;i<reviews.size();i++){
		          	review=(ReviewBean)reviews.get(i);
		          	if(review.getStatus()!=ReviewBean.REVIEW_STATUS_QUIT){
		      %>
              <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td>&nbsp;</td>
                </tr>
              </table> 
              <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" class="table">
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
              <table width="100%" border="0" cellpadding="5" cellspacing="0">
                <tr> 
                  <td align="center" height="58" nowrap><input name="close" type="button" id="close" style="width:130px;height:24px;" onClick="window.close()" value="<bean:message key="common.button.closewindow"/>"></td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
    </td>
  </tr>
</table>
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