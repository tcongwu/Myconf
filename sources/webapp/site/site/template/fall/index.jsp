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
<LINK href="<%=temproot%>css/template.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>


<%
if(list!=null&&list.size()>1){

%>
<table width="780"  align="center">
	<tr>
		<td class=pathway >
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

<table width="778" align="center">
<tr align="center" >
<td width="1%">&nbsp;</td>
<td align="center" >
<DIV id=main align="center">
<TABLE cellSpacing=0 cellPadding=0 width=780 border=0 align="center">
  <TBODY>
  <TR>
    <TD width=778 height=100  background="<%if(!banner.equals("")){out.println(banner);}else{%><%=temproot%>images/lu.jpg<%}%>">
   <TABLE cellSpacing=0 cellPadding=0 width=670 align=right border=0>
        <TBODY>
        <TR>
          <TD align=left height=35><font color="#00CCFF" size='5'><b><%if(lbean!=null){if(lbean.getShow2()==1){out.println(StringUtils.exportString(lbean.getShortName()));}}%></b></font></TD>
          </TR>
        <TR>
          <TD>
            <DIV align=left><SPAN ><font color="#00CCFF" size='3'><b><%if(lbean!=null){if(lbean.getShow1()==1){out.println(StringUtils.exportString(lbean.getConfName()));}}%></b></font></SPAN></DIV></TD>
          <TD align=right>&nbsp;</TD></TR></TBODY></TABLE>
   
      
       </TD>
   </TR></TBODY></TABLE>

<TABLE style="MARGIN-TOP: 5px" cellSpacing=0 cellPadding=0 width="100%" 
border=0>
  <TBODY>
  <TR>
    <TD class=left width="199" id="leftside">
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
               <%		}
						}
					}
				 	%>	
              
            </TBODY></TABLE></TD></TR></TBODY></TABLE>
    </TD>
    <TD class=content width="579">
      
      <TABLE class=contentpaneopen>
        <TBODY>
        
        <TR>
          <TD vAlign=top colSpan=2>
          
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
        </TBODY></TABLE>
     
      </TD>
    </TR>
  <TR>
    <TD colSpan=3 height=5></TD></TR>
  <TR>
    <TD class=copyright colSpan=3>
      </TD></TR></TBODY></TABLE></div>
	  </td>
			  </tr>
		</table> 
		<div align=center>Copyright: <%=StringUtils.exportString(lbean.getCopyright())%> &nbsp;&nbsp;&nbsp;Email: <%=StringUtils.exportString(lbean.getEmail())%><br>
		<DIV align=center><BR><A href="http://www.myconf.org">Powered by MyConf 1.0</A> </DIV>
</BODY></HTML>
