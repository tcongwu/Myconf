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
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ page import="java.util.*" %>
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
List refers=ReferDAO.list();
ReferBean refer=null;
int no=1;
if(refers!=null && refers.size()>0)
	no=((ReferBean)refers.get(refers.size()-1)).getReferNo()+1;
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
<jsp:include page="/inc/top.jsp" />
<jsp:include page="/inc/logo_admin.jsp" />
<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/admin/sub/mainmenu1.jsp" />
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr>
    <td width="180" height="55" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenu">
        <tr> 
          <td height="41">
			<jsp:include page="/admin/sub/leftmenu1.jsp" />
			<jsp:include page="/inc/stat.jsp" />
          </td>
        </tr>
      </table></td>
    <td width="598" valign="top" class="pagecontent">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="pagecontent_title"><b><bean:message key="menu.left.review" bundle="admin"/></b></td>
        </tr>
        <tr>
          <td align="right" class="pagecontent_right"><a href="<html:rewrite page="/admin/reviewins.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.reviewins" bundle="admin"/></a> 
            > <span class="pagemenu_visited"><bean:message key="menu.sub.top.refer" bundle="admin"/></span> 
            > <a href="<html:rewrite page="/admin/reviewstatus.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.status" bundle="admin"/></a> 
            > <a href="<html:rewrite page="/admin/reviewdate.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.reviewdate" bundle="admin"/></a></td>
        </tr>
      </table>
      <script language="JavaScript">
		function modRefer(id){
			refer.id.value=id;
			eval("refer.referNo.value=rno"+id+".value");
			eval("refer.title.value=rtitle"+id+".value");
			eval("refer.minScore.value=iscore"+id+".value");
			eval("refer.maxScore.value=mscore"+id+".value");
			eval("refer.description.value=desc"+id+".value");
			if(id>0){
				refer.addmod.value="<bean:message key="common.button.modify"/>";
				hideLayer("next");
				showLayer("back");
			}else{
				refer.addmod.value="<bean:message key="common.button.add"/>";
				hideLayer("back");
				showLayer("next");
			}
		}
		function checkForm()
		{
			if (trim(refer.referNo.value).length == 0) {
				alert("<bean:message key="error.staritem.not.null"/>");
				refer.referNo.focus();
				return false;
			}
			if(!isRange(trim(refer.referNo.value),"1234567890")){
				alert("<bean:message key="error.must.integer"/>");
				refer.referNo.select();
				refer.referNo.focus();
				return false;
			}
			if (trim(refer.title.value).length == 0) {
				alert("<bean:message key="error.staritem.not.null"/>");
				refer.title.focus();
				return false;
			}
			if (trim(refer.minScore.value).length == 0) {
				alert("<bean:message key="error.staritem.not.null"/>");
				refer.minScore.focus();
				return false;
			}
			if(!isRange(trim(refer.minScore.value),"1234567890.")){
				alert("<bean:message key="error.must.number"/>");
				refer.minScore.select();
				refer.minScore.focus();
				return false;
			}
			if (trim(refer.maxScore.value).length == 0) {
				alert("<bean:message key="error.staritem.not.null"/>");
				refer.maxScore.focus();
				return false;
			}
			if(!isRange(trim(refer.maxScore.value),"1234567890.")){
				alert("<bean:message key="error.must.number"/>");
				refer.maxScore.select();
				refer.maxScore.focus();
				return false;
			}
			return true;
		}
	  </script>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.reviewrefer.ins1" bundle="admin"/></li>
                  <li><bean:message key="page.reviewrefer.ins2" bundle="admin"/></li>
				  <li><bean:message key="page.reviewrefer.ins4" bundle="admin"/></li>
				  <li><bean:message key="page.reviewrefer.ins5" bundle="admin"/></li>
                  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/refer.do"/>" method="post" onSubmit="return checkForm()" name="refer" id="refer">
              <input name="eventSubmit_AddOrModify" type="hidden" id="eventSubmit_AddOrModify" value="0">
              <input name="id" type="hidden" id="id" value="0">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_content">&nbsp;&nbsp;<span class="redins"><bean:message key="page.reviewrefer.ins3" bundle="admin"/></span></td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="20%" class="form_row_title">*<bean:message key="page.reviewrefer.title.no" bundle="admin"/></td>
                  <td class="form_row_content"><input name="referNo" type="text" id="referNo" size="8" value="<%=no%>">
                    {<bean:message key="page.reviewrefer.ins6" bundle="admin"/>} {<bean:message key="error.must.integer"/>}</td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="20%" class="form_row_title">*<bean:message key="page.reviewrefer.title.title" bundle="admin"/></td>
                  <td class="form_row_content"><input name="title" type="text" id="title" size="68"></td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="20%" class="form_row_title">*<bean:message key="page.reviewrefer.title.minscore" bundle="admin"/></td>
                  <td class="form_row_content"><input name="minScore" type="text" id="minScore" size="8">
                    {<bean:message key="page.reviewrefer.ins7" bundle="admin"/>}{<bean:message key="error.must.number"/>}</td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="20%" class="form_row_title">*<bean:message key="page.reviewrefer.title.maxscore" bundle="admin"/></td>
                  <td class="form_row_content"><input name="maxScore" type="text" id="maxScore" size="8">
                    {<bean:message key="error.must.number"/>}</td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="20%" valign="top" class="form_row_title"><bean:message key="page.reviewrefer.title.desc" bundle="admin"/></td>
                  <td class="form_row_content"><textarea name="description" cols="68" rows="3" id="description"></textarea>
                  </td>
                </tr>
              </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td width="8%" nowrap class="form_row_submit"><input name="addmod" type="submit" class="button" id="addmod" value="<bean:message key="common.button.add"/>">
                  </td>
                  <td width="92%" nowrap class="form_row_submit"><input name="next" type="button" onClick="window.location='<html:rewrite page="/admin/reviewstatus.jsp"/>'" class="button" id="next" value="<bean:message key="common.button.next.setting"/>"> 
                    <input name="back" type="button" onClick="modRefer(0)" class="button" style="display:none" id="back" value="<bean:message key="common.button.back.add"/>"> 
                  </td>
                </tr>
              </table>
            </form>
            <table width="100%" cellspacing="0" cellpadding="0">
              <tr>
                <td width="52%">
					<div class="spacer_20"></div>
					<div class="line_dashed"></div>
					<div class="spacer_10"></div>
				</td>
              </tr>
            </table>
			<input name="rno0" type="hidden" id="rno0" value="<%=no%>"/> 
            <input name="rtitle0" type="hidden" id="rtitle0" value=""/> 
            <input name="iscore0" type="hidden" id="iscore0" value=""/> 
            <input name="mscore0" type="hidden" id="mscore0" value=""/> 
            <input name="desc0" type="hidden" id="desc0" value=""/>
            <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
			  <tr> 
				  
                <td width="6%" align="center" nowrap class="table_head"><bean:message key="page.reviewrefer.text.no" bundle="admin"/></td>
				  
                <td width="66%" class="table_head" nowrap><bean:message key="page.reviewrefer.text.title" bundle="admin"/></td>
                <td width="8%" align="center" nowrap class="table_head"><bean:message key="page.reviewrefer.text.minscore" bundle="admin"/></td>
				  
                <td width="8%" align="center" nowrap class="table_head"><bean:message key="page.reviewrefer.text.maxscore" bundle="admin"/></td>
				  <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.modify"/></td>
				  <td width="6%" align="center" class="table_head" nowrap><bean:message key="common.text.delete"/></td>
			  </tr>
			  <%
				if(refers!=null && refers.size()>0){
				  for(int i=0;i<refers.size();i++){
				  	refer=(ReferBean)refers.get(i);
			  %>
			  <tr> 
                <td align="center" class="table_cell"><%=refer.getReferNo()%></td>
				  <td class="table_cell"><%=refer.getTitle()%>
				  <input name="rno<%=refer.getId()%>" type="hidden" id="rno<%=refer.getId()%>" value="<%=refer.getReferNo()%>"/>
                  <input name="rtitle<%=refer.getId()%>" type="hidden" id="rtitle<%=refer.getId()%>" value="<%=refer.getTitle()%>"/>
                  <input name="iscore<%=refer.getId()%>" type="hidden" id="iscore<%=refer.getId()%>" value="<%=refer.getMinScore()%>"/>
                  <input name="mscore<%=refer.getId()%>" type="hidden" id="mscore<%=refer.getId()%>" value="<%=refer.getMaxScore()%>"/>
                  <input name="desc<%=refer.getId()%>" type="hidden" id="desc<%=refer.getId()%>" value="<%=StringUtils.exportString(refer.getDescription())%>"/></td>
                <td align="center" class="table_cell"><%=refer.getMinScore()%></td>
                <td align="center" class="table_cell"><%=refer.getMaxScore()%></td>
                <td align="center" class="table_cell"><a title="<bean:message key="common.text.modify"/>" href="javascript:modRefer(<%=refer.getId()%>)"><img src="<html:rewrite page="/images/sub_edit.gif"/>" width="21" height="21" border="0"></a></td>
                <td align="center" class="table_cell"><a title="<bean:message key="common.text.delete"/>" onClick="return confirm('<bean:message key="ins.confirm.delete"/>')" href="<html:rewrite page="/refer.do?eventSubmit_Delete&id="/><%=refer.getId()%>"><img src="<html:rewrite page="/images/sub_del.gif"/>" width="21" height="21" border="0"></a></td>
			  </tr>
			  <%}}%>
			</table>
		  </td>
        </tr>
      </table> 
    </td>
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