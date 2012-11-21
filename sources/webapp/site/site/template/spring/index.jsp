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


<%
	
	LangBean lbean=(LangBean)request.getAttribute("lang");
	String temproot=(String) request.getAttribute("temproot");
	
	List list=LangDAO.getLangPubish();
	
	List mlist=MenuDAO.getMenuByVersion(lbean);
	ContentBean cbean=null;	
	ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
	String banner=StringUtils.exportString(conf.getBanner());
	
    

%>

<HTML ><HEAD><TITLE>Myconf</TITLE>

<META content="index, follow" name=robots>
<LINK href="<%=temproot%>css/template.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<%
if(list!=null&&list.size()>1){

%>
<table width="780" align="center">
<tr align="center" >
<td align="center" >
<DIV id=main align="center">
<table   align="center">
	<tr bgcolor="#e9c086">
		<td  class=mainlevel   >&nbsp;<font size="2">
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
		</font>
		 </td>
	</tr>
</table>
</div>
</td>
<tr>
</table>

<%}%>
  
<table width="778" align="center">
<tr align="center" >
<td align="center" >
<DIV id=main align="center">




<TABLE cellSpacing=0 cellPadding=0 width="778" height="100" >
  <TBODY>
  
  <TR align="center" width="778" >
      <TD  height="98" width="778" background="<%if(!banner.equals("")){out.println(banner);}else{%><%=temproot%>images/luye.jpg<%}%>" >
           <TABLE cellSpacing=0 cellPadding=0 width=500  border=0 align="center">
      			  <TBODY>
        				<TR>
         			 		<TD align=left height=35 ><font color='#ff6600'><%if(lbean!=null){if(lbean.getShow2()==1){out.println(StringUtils.exportString(lbean.getShortName()));}}%></font></TD>
         			  </TR>
      			 	 <TR>
         				 <TD>
           					 <DIV align=left><SPAN ><font color='#ff6600' size='3'><%if(lbean!=null){if(lbean.getShow1()==1){out.println(StringUtils.exportString(lbean.getConfName()));}}%></font></SPAN></DIV>
           				</TD>
         				</TR>
         			</TBODY>
         	</TABLE>
     </TD></TR>
  </TBODY></TABLE>
  
<TABLE cellSpacing=0 cellPadding=0 >
  <TBODY align="cente" >
  <TR>
    <TD id=leftside>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
         <tr>
              <td height="10">
              </td>
          </tr>
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
		   			 				if(mbean.getType().equals("url")){
		 											%> 
		 						 			href="<%=mbean.getLink()%>">
		 				 							<%
									}else{
		 	
									%>			 
											href="<%=request.getContextPath()%>/index.do?lang=<%=lbean.getId()%>&contentId=<%=mbean.getLink()%>"
		 									<%}%> 
		   								target="<%=mbean.getOpenType()%>"><%=menuName%><%if(StringUtils.exportString(mbean.getStyle()).indexOf("1")>=0){%><img src="<%=request.getContextPath()%>/images/new1.gif" border="0" /><%}%>
            
            </A>
           </TD>
         </TR>
         
         <%						}
						       }
							}
		%>	
         </TBODY></TABLE>
      </TD>
    <TD id=content>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD>
            <DIV id=sandbox_area>
            <DIV class=clear></DIV></DIV></TD></TR>
        <TR>
          <TD id=mainbody>
            <TABLE class=contentpaneopen>
              <TBODY>
             </TBODY></TABLE>
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
                  
                  </TD>
              </TR>
              </TBODY></TABLE>            </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></DIV>
			  </td>
			  </tr>
		</table> 
<div align=center>Copyright: <%=StringUtils.exportString(lbean.getCopyright())%> &nbsp;&nbsp;&nbsp;Email: <%=StringUtils.exportString(lbean.getEmail())%></div>		
<DIV class=max align=center ><A href="http://www.myconf.org/" target="_blank">Powered by MyConf 1.0</A></DIV>
</BODY></HTML>
