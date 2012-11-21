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
<LINK href="<%=temproot%>css/template.css" type=text/css rel=stylesheet></HEAD>
<BODY bgColor=#ffffff>
<DIV align=center>


<%
if(list!=null&&list.size()>1){

%>
<table width="780"  align="center">
	<tr>
		<td   bgcolor="B7DF5B">
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

<TABLE borderColor=#ffffff cellSpacing=0 cellPadding=0 <%if(!banner.equals("")){%> width=778 <%}else{%>  width=700 <%}%> border=0>
  <TBODY>
  <TR vAlign=top>
   		 <TD width="778" <%if(!banner.equals("")){%> height=100 <%}else{%> height=125 <%}%> background="<%if(!banner.equals("")){out.println(banner);}else{%><%=temproot%>images/banner1.jpg<%}%>">
        	 <TABLE cellSpacing=0 cellPadding=0 width=700 align=right border=0>
      			  <TBODY>
        				<TR>
         			 		<TD align=left height=35><font color='#ff6600' size='5'><%if(lbean!=null){if(lbean.getShow2()==1){out.println(StringUtils.exportString(lbean.getShortName()));}}%></font></TD>
         			  </TR>
      			 	 <TR>
         				 <TD>
           					 <DIV align=left><SPAN ><font color='#ff6600' size='3'><%if(lbean!=null){if(lbean.getShow1()==1){out.println(StringUtils.exportString(lbean.getConfName()));}}%></font></SPAN></DIV>
           				</TD>
         				</TR>
         			</TBODY>
         	</TABLE>
    
			   
	  	</TD>
    </TR>
  <TR vAlign=top>
    <TD>
      <DIV align=center>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD vAlign=top width=167>
            <DIV align=center>
            <TABLE cellSpacing=0 cellPadding=0 width=160 border=0>
              <TBODY>
              <TR>
                <TD>
                  <DIV align=center><FONT 
                  face="Verdana, Arial, Helvetica, sans-serif" 
                  color=#00e010><STRONG>
                  <TABLE class=moduletable cellSpacing=0 cellPadding=0>
                    <TBODY>
                    <TR>
                      <TD>
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
                            <TD>
                            
                            <A class=mainlevel 
                            
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
                          <%	}
								}
							}
				 		%>	
                          </TBODY></TABLE></TD></TR></TBODY></TABLE>
                  <TABLE class=moduletable cellSpacing=0 cellPadding=0>
                    <TBODY>
                    </TBODY></TABLE></STRONG></FONT></DIV></TD></TR></TBODY></TABLE></DIV></TD>
          <TD vAlign=top>
            <TABLE cellSpacing=0 cellPadding=0 width="90%" align=center 
                  border=0>
                <TBODY>
                  <TR>
                    <TD>                      <TABLE class=contentpaneopen>
                        <TBODY>
                         <tr>
              				<td height="10">
             				 </td>
              			</tr>
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
                          
                        </TBODY>
                      </TABLE>
                      <DIV class=back_button></DIV></TD>
                  </TR>
                </TBODY>
              </TABLE>         </TR></TBODY></TABLE>
      </DIV>
      <DIV align=center></DIV>
      <DIV align=center></DIV></TD></TR>
      <TR vAlign=top>
    <TD colSpan=3>
      <DIV align=center>
      <HR color=#e6e6e6 noShade SIZE=1>
      </DIV>
      <DIV align=center></DIV>
      <DIV align=center></DIV></TD></TR>
  <TR vAlign=top bgColor=#ffffff align="center">
    
    <TD align="center">
    	<div align=center>Copyright: <%=StringUtils.exportString(lbean.getCopyright())%> &nbsp;&nbsp;&nbsp;Email: <%=StringUtils.exportString(lbean.getEmail())%></div><br>
      <DIV align=center><FONT face="Arial, Helvetica, sans-serif" color=#cccccc size=1>
      <A href="http://www.myconf.org/" target="_blank">Powered by MyConf 1.0</A></FONT></DIV>
      
      </TD>
   </TR>
</TBODY></TABLE>
</DIV><!-- 1174833122 --></BODY></HTML>
