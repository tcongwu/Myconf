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
int year=Calendar.getInstance().get(Calendar.YEAR)-2;
int syear1=0;
int smonth1=0;
int sday1=0;
int shour1=0;
int syear2=0;
int smonth2=0;
int sday2=0;
int shour2=0;

ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
if(conf!=null){
	if(conf.getSubBeginDate()>0){
		Calendar begin=Calendar.getInstance();
		begin.setTimeInMillis(conf.getSubBeginDate());
		syear1=begin.get(Calendar.YEAR);
		smonth1=begin.get(Calendar.MONTH)+1;
		sday1=begin.get(Calendar.DAY_OF_MONTH);
		shour1=begin.get(Calendar.HOUR_OF_DAY);
	}
	if(conf.getSubEndDate()>0){
		Calendar end=Calendar.getInstance();
		end.setTimeInMillis(conf.getSubEndDate());
		syear2=end.get(Calendar.YEAR);
		smonth2=end.get(Calendar.MONTH)+1;
		sday2=end.get(Calendar.DAY_OF_MONTH);
		shour2=end.get(Calendar.HOUR_OF_DAY);
	}
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
          <td class="pagecontent_title"><b><bean:message key="menu.left.submission" bundle="admin"/></b></td>
        </tr>
        <tr>
          <td align="right" class="pagecontent_right"><a href="<html:rewrite page="/admin/subins.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.ins" bundle="admin"/></a> > 
            <a href="<html:rewrite page="/admin/subsubject.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.subject" bundle="admin"/></a> > 
            <a href="<html:rewrite page="/admin/subformat.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.format" bundle="admin"/></a> > 
            <a href="<html:rewrite page="/admin/subsize.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.size" bundle="admin"/></a> > 
			<span class="pagemenu_visited"><bean:message key="menu.sub.top.subdate" bundle="admin"/></span> > 
			<a href="<html:rewrite page="/admin/subcondate.jsp"/>" class="pagemenu"><bean:message key="menu.sub.top.confirmdate" bundle="admin"/></a></td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.subdate.ins1" bundle="admin"/></li>
                  <li><bean:message key="page.subdate.ins2" bundle="admin"/></li>
                  <li><bean:message key="page.subdate.ins3" bundle="admin"/></li>
				  <div class="spacer_5"></div></td>
              </tr>
            </table>
            <form action="<html:rewrite page="/config.do"/>" method="post" name="sdate" id="sdate">
              <input name="eventSubmit_Save" type="hidden" id="eventSubmit_Save" value="0">
              <input name="fromPage" type="hidden" id="fromPage" value="/admin/subcondate.jsp">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr> 
                  <td width="27%" class="form_row_title"><bean:message key="page.subdate.title.begin" bundle="admin"/></td>
                  <td class="form_row_content"><select name="subYear1" id="subYear1">
                      <option value="<%=syear1%>" selected><%=syear1%></option>
                      <%for(int i=0;i<8;i++){%>
                      <option value="<%=year+i%>"><%=year+i%></option>
                      <%}%>
                    </select>
                    <bean:message key="common.text.year"/> 
                    <select name="subMonth1" id="subMonth1">
                      <option value="<%=smonth1%>" selected><%=smonth1%></option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                    </select>
                    <bean:message key="common.text.month"/> 
                    <select name="subDay1" id="subDay1">
                      <option value="<%=sday1%>" selected><%=sday1%></option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                      <option value="13">13</option>
                      <option value="14">14</option>
                      <option value="15">15</option>
                      <option value="16">16</option>
                      <option value="17">17</option>
                      <option value="18">18</option>
                      <option value="19">18</option>
                      <option value="20">20</option>
                      <option value="21">21</option>
                      <option value="22">22</option>
                      <option value="23">23</option>
                      <option value="24">24</option>
                      <option value="25">25</option>
                      <option value="26">26</option>
                      <option value="27">27</option>
                      <option value="28">28</option>
                      <option value="29">29</option>
                      <option value="30">30</option>
                      <option value="31">31</option>
                    </select>
                    <bean:message key="common.text.day"/> &nbsp; &nbsp; 
                    <select name="subHour1" id="subHour1">
                      <option value="<%=shour1%>" selected><%=shour1%></option>
                      <option value="00">00</option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                      <option value="13">13</option>
                      <option value="14">14</option>
                      <option value="15">15</option>
                      <option value="16">16</option>
                      <option value="17">17</option>
                      <option value="18">18</option>
                      <option value="19">19</option>
                      <option value="20">20</option>
                      <option value="21">21</option>
                      <option value="22">22</option>
                      <option value="23">23</option>
                    </select>
                    <bean:message key="common.text.hour"/></td>
                </tr>
              </table>
              <table width="100%" border="0" cellspacing="0" cellpadding="0" class="form_row">
                <tr>
                  <td width="27%" class="form_row_title"><bean:message key="page.subdate.title.end" bundle="admin"/></td>
                  <td class="form_row_content">
					<select name="subYear2" id="subYear2">
                      <option value="<%=syear2%>" selected><%=syear2%></option>
                      <%for(int i=0;i<8;i++){%>
                      <option value="<%=year%>"><%=year%></option>
                      <%year++;}%>
                    </select>
                    <bean:message key="common.text.year"/> 
                    <select name="subMonth2" id="subMonth2">
                      <option value="<%=smonth2%>" selected><%=smonth2%></option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                    </select>
                    <bean:message key="common.text.month"/> 
                    <select name="subDay2" id="subDay2">
                      <option value="<%=sday2%>" selected><%=sday2%></option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                      <option value="13">13</option>
                      <option value="14">14</option>
                      <option value="15">15</option>
                      <option value="16">16</option>
                      <option value="17">17</option>
                      <option value="18">18</option>
                      <option value="19">18</option>
                      <option value="20">20</option>
                      <option value="21">21</option>
                      <option value="22">22</option>
                      <option value="23">23</option>
                      <option value="24">24</option>
                      <option value="25">25</option>
                      <option value="26">26</option>
                      <option value="27">27</option>
                      <option value="28">28</option>
                      <option value="29">29</option>
                      <option value="30">30</option>
                      <option value="31">31</option>
                    </select>
                    <bean:message key="common.text.day"/> &nbsp; &nbsp; 
                    <select name="subHour2" id="subHour2">
                      <option value="<%=shour2%>" selected><%=shour2%></option>
                      <option value="00">00</option>
                      <option value="01">01</option>
                      <option value="02">02</option>
                      <option value="03">03</option>
                      <option value="04">04</option>
                      <option value="05">05</option>
                      <option value="06">06</option>
                      <option value="07">07</option>
                      <option value="08">08</option>
                      <option value="09">09</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                      <option value="13">13</option>
                      <option value="14">14</option>
                      <option value="15">15</option>
                      <option value="16">16</option>
                      <option value="17">17</option>
                      <option value="18">18</option>
                      <option value="19">19</option>
                      <option value="20">20</option>
                      <option value="21">21</option>
                      <option value="22">22</option>
                      <option value="23">23</option>
                    </select>
                    <bean:message key="common.text.hour"/></td>
                </tr>
              </table>
              <%
              	List subs=SubjectDAO.list();
              	if(subs==null || subs.size()==0){
              %>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_content">&nbsp;&nbsp;<span class="redins"><bean:message key="page.subdate.attention" bundle="admin"/></span></td>
                </tr>
              </table>
              <%}%>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_row">
                <tr> 
                  <td class="form_row_submit"><input onClick="sdate.fromPage.value='/admin/subdate.jsp';" name="save" type="submit" class="button" id="save2" value="<bean:message key="common.button.save"/>"> 
                    <input onClick="sdate.fromPage.value='/admin/subcondate.jsp';" name="next" type="submit" class="button" id="next2" value="<bean:message key="common.button.save.and.next"/>"> 
                  </td>
                </tr>
              </table>
            </form>
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