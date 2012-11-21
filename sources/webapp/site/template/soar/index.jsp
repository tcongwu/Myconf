
<%
//*********************************
//security
//*********************************
%>
<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.util.StringUtils" %>
<%@ page import="org.myconf.util.*" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<jsp:useBean id="lang" class="org.myconf.beans.LangBean" scope="request" />
<jsp:useBean id="templateroot" class="java.lang.String" scope="request" />

<%
	
	LangBean lbean=(LangBean)request.getAttribute("lang");
	String temproot=(String) request.getAttribute("temproot");
	List list=LangDAO.getLangPubish();
	List mlist=MenuDAO.getMenuByVersion(lbean);
	ContentBean cbean=null;	
	ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
	String banner=StringUtils.exportString(conf.getBanner());
    


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>MyConf.org--<bean:message key="common.title.keyword"/></TITLE>
</HEAD>
<BODY>
<LINK href="<%=temproot%>css/template.css"   type=text/css rel=stylesheet>

<%
if(list!=null&&list.size()>1){

%>
<table width="765"  align="center">
	<tr>
		<td  bgcolor="EDC3AA">
		<%if(lbean!=null){if(lbean.getId()==LangBean.LANG_ZH_CN){ out.println(org.myconf.Globals.LANGUAGE_SIMPLIFIED);} if(lbean.getId()==LangBean.LANG_ZH_TW){ out.println(org.myconf.Globals.LANGUAGE_TRADITIONAL);} if(lbean.getId()==LangBean.LANG_ENGLISH){ out.println(org.myconf.Globals.LANGUAGE_ENGLISH);}}%>
		
		
			<%
		
			for(int i=0;i<list.size();i++){
				LangBean lb=(LangBean)list.get(i);
				if(lb.getId()!=lbean.getId())
					{
						if(lb.getId()==LangBean.LANG_ZH_CN)
							{
								out.println(" | "+"<a href='"+request.getContextPath()+"/index.do?lang="+lb.getId()+"'>"+org.myconf.Globals.LANGUAGE_SIMPLIFIED+"</a>");
							}
						
						if(lb.getId()==LangBean.LANG_ZH_TW)
							{
								out.println(" | "+"<a href='"+request.getContextPath()+"/index.do?lang="+lb.getId()+"'>"+org.myconf.Globals.LANGUAGE_TRADITIONAL+"</a>");
							}	
						
						if(lb.getId()==LangBean.LANG_ENGLISH)
							{
								out.println(" | "+"<a href='"+request.getContextPath()+"/index.do?lang="+lb.getId()+"'>"+org.myconf.Globals.LANGUAGE_ENGLISH+"</a>");
							}		
					}
					
			}
		
		
		
		%>
		
		 </td>
	</tr>
</table>
<%}%>

<TABLE height="<%if(!banner.equals("")){out.println("100");}else{%>136<%}%>" cellSpacing=0 cellPadding=0 width=761 align=center border=0>
  <TBODY>
  <TR>
    <TD vAlign=top align=right  background="<%if(!banner.equals("")){out.println(banner);}else{%><%=temproot%>images/index_03.jpg<%}%>">
      <TABLE cellSpacing=0 cellPadding=0 width=370 align=right border=0>
        <TBODY>
        <TR>
          <TD align=right height=35><span class="maintitle"><%if(lbean!=null){if(lbean.getShow2()==1){out.println(StringUtils.exportString(lbean.getShortName()));}}%></span></TD>
          <TD align=right width=50>&nbsp;</TD></TR>
        <TR>
          <TD>
            <DIV align=left><SPAN ><font color='#ff6600' size='3'><%if(lbean!=null){if(lbean.getShow1()==1){out.println(StringUtils.exportString(lbean.getConfName()));}}%></font></SPAN></DIV></TD>
          <TD align=right>&nbsp;</TD></TR></TBODY></TABLE>
     </TD>
   </TR>
</TBODY>
</TABLE>
<%if(banner.equals("")){%>
<TABLE height=47 cellSpacing=0 cellPadding=0 width=761 align=center border=0>
  <TBODY>
  <TR>
    <TD width=162><IMG height=47 alt=""  src="<%=temproot%>images/index_05.jpg" width=162></TD>
    <TD vAlign=top align=right>
      <DIV align=right></DIV></TD>
    <TD width=15>&nbsp;</TD></TR>
   </TBODY>
</TABLE>
<%}%>
<TABLE height=8 cellSpacing=0 cellPadding=0 width=761 align=center border=0>
  <TBODY>
  <TR>
    <TD width=162><IMG height=8 alt="" src="<%=temproot%>images/index_08.jpg" width=162></TD>
    <TD><IMG height=8 alt="" src="<%=temproot%>images/index_09.jpg" width=584></TD>
    <TD width=15></TD></TR>
  </TBODY>
</TABLE>
<TABLE height=8 cellSpacing=0 cellPadding=4 width=761 align=center border=0>
  <TBODY>
  <TR>
    <TD vAlign=top width=154 background="<%=temproot%>images/index_11.jpg">
      <TABLE class=moduletable cellSpacing=0 cellPadding=0>
        <TBODY>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
            	  <%
            	  
				   	if(mlist!=null&&mlist.size()>0){
				   		for(int i=0;i<mlist.size();i++){
				   			MenuBean mbean=(MenuBean) mlist.get(i);	
				   			if(mbean.getPublished()==1){
				   			StringBuffer name=new StringBuffer();
				   			String menuName=StringUtils.exportString(mbean.getMenuName());
				   			if(StringUtils.exportString(mbean.getStyle()).indexOf("2")>=0){menuName=name.append("<b>").append(menuName).append("</b>").toString();}
				   		
				   					
				   %> 
              <TR align=left>
                <TD><A class=mainlevel 
                <%
                if(StringUtils.exportString(mbean.getType()).equals("url")){
                 %>
                 href="<%=StringUtils.exportString(mbean.getLink())%>"
				 <%}else{
				 
				 	
				 %>			 
				 	href="<%=request.getContextPath()%>/index.do?lang=<%=lbean.getId()%>&contentId=<%=StringUtils.exportString(mbean.getLink())%>"
               			 <%}%> 
                   target="<%=StringUtils.exportString(mbean.getOpenType())%>"><%=menuName%><%if(StringUtils.exportString(mbean.getStyle()).indexOf("1")>=0){%><img src="<%=request.getContextPath()%>/images/new1.gif" border="0" /><%}%></A>
                </TD>
              </TR>
      			<%
      			}
						}
					}
				 	%>	
      
                </TBODY>
              </TABLE>
             </TD>
            </TR>
           </TBODY>
        </TABLE>
     </TD>
    <TD vAlign=top>
     
      <HR>

     
      <TABLE class=contentpaneopen>
        <TBODY>
       
        <TR>
          <TD vAlign=top>
          	<%
          		int contentId=RequestUtils.getParam(request, "contentId", 0);
          		
          		cbean=ContentDAO.getContentByID(contentId);
          		
          		if(cbean==null)
          		cbean=ContentDAO.getDefaultContent(lbean);
          		
				if(cbean!=null){
					out.println(StringUtils.exportString(cbean.getPagetext()));
				}else{
					out.println("<font color='red' size='3'><b>Not Published or Under Construction!</b></font>");
				
				}
			
          	%>
          </TD></TR>
       </TBODY></TABLE>
      
     
      <HR>
      <BR></TD>
    <TD width=7></TD></TR></TBODY></TABLE>
<TABLE height=45 cellSpacing=0 cellPadding=0 width=766 align=center border=0>
  <TBODY>
  <TR>
    <TD vAlign=center align=middle 
    background="<%=temproot%>images/index_14.jpg">
      <DIV align=center>Copyright: <%=StringUtils.exportString(lbean.getCopyright())%> &nbsp;&nbsp;&nbsp;Email: <%=StringUtils.exportString(lbean.getEmail())%></DIV></TD></TR></TBODY></TABLE>
<DIV align=center><BR>
<DIV align=center><BR><A href="http://www.myconf.org" target="_blank">Powered by MyConf 1.0</A> </DIV>
</BODY></HTML>
