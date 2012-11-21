
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
<%@ page import="org.myconf.dao.MenuDAO" %>
<%@ page import="org.myconf.dao.LangDAO" %>
<%@ page import="org.myconf.dao.ContentDAO" %>
<%@ page import="org.myconf.beans.MenuBean" %>
<%@ page import="org.myconf.beans.LangBean" %>
<%@ page import="org.myconf.util.StringUtils" %>
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
	String key=(String) session.getAttribute("key");
	String languange=(String) session.getAttribute("version");
	if(key==null||languange==null){
	
%>
<script languange="javascript">
	alert("<bean:message key="page.site.setting_sessionout" bundle="site"/>");
	window.location.href="<html:rewrite page="/site/index.jsp"/>"

</script>


<%	
	return;
	 
	}else{

%>
<%
	int langId=1;
	if(languange.equals("zh_cn")){langId=LangBean.LANG_ZH_CN;}
	if(languange.equals("zh_tw")){langId=LangBean.LANG_ZH_TW;}
	if(languange.equals("english")){langId=LangBean.LANG_ENGLISH;}
	
	LangBean lang=LangDAO.getLang(langId);
	List mlist=MenuDAO.getMenuByVersion(lang);
	
	List clist=ContentDAO.getContentByVersion(lang);
	boolean isAdd=false;
	if(clist!=null&&clist.size()!=0){isAdd=true;}
	
	
	

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
<jsp:include page="/inc/logo_site.jsp" />

<%
//*********************************
//content
//*********************************
%>
<jsp:include page="/site/sub/mainmenu1.jsp" />
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr>
    <td width="180" height="55" valign="top">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="leftmenu">
        <tr> 
          <td height="41">
		   <jsp:include page="/site/sub/leftmenu1.jsp" />
		   <jsp:include page="/inc/stat.jsp" />
		  </td>
        </tr>
      </table></td>
    <td width="598" valign="top" class="pagecontent"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	
        <tr>
          <td class="pagecontent_title"><b><bean:message key="page.site.submenu2" bundle="site" /></b></td>
		  <td class="site_version" align="right"><b><bean:message key="<%=key%>" bundle="site" /></b></td>
        </tr>
        <tr >
          <td align="right"  colspan="2" height="5">&nbsp;
          	
          </td>		
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="form">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="form_note">
              <tr>
                <td><div class="spacer_5"></div>
				  <li><bean:message key="page.site.menu_point1" bundle="site" /></li>
                  <li><bean:message key="page.site.setting_point3" bundle="site" /></li>
        		<div class="spacer_5"></div></td>
              </tr>
            </table>
          
            <%if(isAdd==false){%>      
            <br>
            <TABLE width=80% height="84" border=0 align="center" cellPadding=0 cellSpacing=0 summary=null>
				  <TBODY>
				    <TR> 
				      <TD noWrap width=80% colSpan=2 height=5><img width="570" src="<html:rewrite page="/images/rounded_top.gif"/>"  height="5"></TD>
				    </TR>
				    <TR> 
				      <TD width=1 height="73" noWrap bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
				      <TD width=80% noWrap>
				      	
				      	<TABLE width=80% border=0 align="center" cellPadding=5 cellSpacing=0>
				          <TBODY>
				            <TR> 
				              <TD align="center" style="font-size:16px;" class="redins"><bean:message key="page.site.content_must1" bundle="site"/></TD>
				            </TR>
				          </TBODY>
				        </TABLE>
				       
				      </TD>
				      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type="block" width="1"></TD>
				    </TR>
				    <TR> 
				      <TD noWrap width=80% colSpan=2 height=6><img width="570" src="<html:rewrite page="/images/rounded_bottom.gif"/>"  height="5"></TD>
				    </TR>
				  </TBODY>
				</TABLE>
 	 <%}else{%>         
            
            <form name="form1" method="post" action="site_menuadd.jsp">
              <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table">
					<tr class="table_head"> 
					  <td width="40%" nowrap><bean:message key="page.site.menu_name1" bundle="site" /></td>
					  <td colspan="10%" align="center" nowrap><bean:message key="page.site.menu_linktype1" bundle="site" /></td>
					  <td width="15%" align="center" nowrap><bean:message key="page.site.menu_published0" bundle="site" /></td>
					   <td width="10%" align="center" nowrap><bean:message key="page.site.menu_edit" bundle="site" /></td>
					   <td width="10%" align="center" nowrap><bean:message key="page.site.menu_delete" bundle="site" /></td>
					   <td width="15%" colspan="2" align="center" nowrap><bean:message key="page.site.menu_order" bundle="site" /></td>
					</tr>
					  <%
					
				   	if(mlist!=null&&mlist.size()>0){
				   		for(int i=0;i<mlist.size();i++){
				   			MenuBean mbean=(MenuBean)mlist.get(i);
				   			
				   			
				   			
				   		
				   %> 
					<tr class="table_cell"> 
					  <td width="40%" nowrap><%=StringUtils.exportString(mbean.getMenuName())%></td>
					  <td colspan="10%" align="center" nowrap><%=StringUtils.exportString(mbean.getType())%></td>
					  <td width="15%" align="center" nowrap  title="change published status"><%if(mbean.getPublished()==1){%><a onClick="return confirm('<bean:message key="page.site.menu_updatestatus" bundle="site"/>')" href="<html:rewrite page="/menu.do?eventSubmit_UpdateStatus&id="/><%=mbean.getId()%>"><bean:message key="page.site.menu_published1" bundle="site" /></a><%}else{%><a onClick="return confirm('<bean:message key="page.site.menu_updatestatus" bundle="site"/>')" href="<html:rewrite page="/menu.do?eventSubmit_UpdateStatus&id="/><%=mbean.getId()%>&published=do"><bean:message key="page.site.menu_published2" bundle="site" />  <%}%></a></td>
					 
					   <td width="10%" align="center" nowrap  title="edit"><a href="<html:rewrite page="/site/site_menuedit.jsp"/>?id=<%=(mbean.getId())%>"><img src=" <html:rewrite page="/images/sub_edit.gif"/>" width="21" height="21" border="0"></a> </td>
					   <td width="10%" align="center" nowrap title="delete"><a onClick="return confirm('<bean:message key="ins.confirm.delete"/>')" href="<html:rewrite page="/menu.do?eventSubmit_Delete&id="/><%=mbean.getId()%>"><img src=" <html:rewrite page="/images/sub_del.gif"/>" width="21" height="21" border="0"></a></td>
					   <td width="7%" align="center" nowrap title="up"><%if(i!=0){%><a  href="<html:rewrite page="/menu.do?eventSubmit_MenuUp"/>&id=<%=mbean.getId()%>&listi=<%=i%>&langId=<%=langId%>"><img src=" <html:rewrite page="/images/uparrow.png"/>" width="12" height="12" border="0"></a><%}%> </td>
					   <td width="8%" align="center" nowrap title="down"><%if(i!=mlist.size()-1){%><a  href="<html:rewrite page="/menu.do?eventSubmit_MenuDown"/>&id=<%=mbean.getId()%>&listi=<%=i%>&langId=<%=langId%>"><img src=" <html:rewrite page="/images/downarrow.png"/>" width="12" height="12" border="0"></a><%}%></td>
					</tr>
					<%
						}
					}
				 	%>	
					
				</table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" >
                <tr> 
                  <td class="form_row_submit"><input name="Submit" type="button"  onclick="window.location.href='<html:rewrite page="/site/site_menuadd.jsp"/>'" class="button" value="<bean:message key="page.site.menu_add" bundle="site" />">
                  </td></tr>
              </table>
            </form>
       <%}%>     
            </td>
        </tr>
      </table> 
    </td>
  </tr>
</table>
<div class="spacer_20"></div>
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
<%}%>