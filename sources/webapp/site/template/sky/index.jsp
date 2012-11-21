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

<HTML><HEAD><TITLE>Myconf</TITLE>
<LINK href="<%=temproot%>css/template.css" type=text/css rel=stylesheet></HEAD>
<BODY  bgColor=#66FFCC background="<%=temproot%>images/bg.jpg" topMargin=0 marginheight="0"><BR>
<TABLE cellSpacing=10 cellPadding=0 width=778 align=center bgColor=#f0f0f0  border=0>
<TBODY>
  <TR>
    <TD bgColor=#ffffff>
      <TABLE cellSpacing=8 cellPadding=0 width="100%" border=0>
        <TBODY>
       	 <TR>
          <TD>
            <TABLE width="100%" border=0>
              <TBODY>
              	<TR>
                	<TD bgColor=#494949>
                  		<TABLE cellSpacing=0 cellPadding=0 width="100%" bgColor=#ffffff border=0>
                    		<TBODY>
                   			 <TR>
                      			<TD>
                      		
								<%
								if(list!=null&&list.size()>1){
								
								%>	
                      			<table width="99%"  align="center">
									<tr>
										<td height="17" bgColor=#5a86b3 >
										
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
								
                      				<TABLE cellSpacing=0 cellPadding=6 width="100%" border=0>
                          				<TBODY>
                         					 <TR>
                           						 <TD width=713>
                             						 <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                                						<TBODY>
                               								 <TR>
                                								<TD vAlign=to height=100  background="<%if(!banner.equals("")){out.println(banner);}else{%><%=temproot%>images/atmospherebanner1.jpg<%}%>">
                                								<TABLE cellSpacing=0 cellPadding=0 width=670 align=right border=0>
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
                                								<!--<IMG height=100 src="<%if(!banner.equals("")){out.println(banner);}else{%><%=temproot%>images/atmospherebanner1.jpg<%}%>" width=778 border=0>-->
                             									</TD>
															</TR>
														</TBODY>
													</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
                         		 </TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
             <TR>
                <TD>
                 <TABLE width="100%" border=0>
                    	<TBODY>
                    		<TR>
                     		 <TD style="BORDER-TOP-WIDTH: 1px; BORDER-RIGHT: 1px dotted; BORDER-LEFT-WIDTH: 1px; BORDER-BOTTOM-WIDTH: 1px" vAlign=top borderColor=#808080 align=left width=121>
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
														<%			}
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
               <TD vAlign=top align=left>
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
                        </TBODY>
					</TABLE>    
               <DIV class=back_button></DIV>
			   </TD>
                <TD  style="BORDER-TOP-WIDTH: 1px; BORDER-BOTTOM-WIDTH: 1px; BORDER-LEFT: 1px dotted; BORDER-RIGHT-WIDTH: 1px" vAlign=top borderColor=#808080 align=middle width=145>
                </TD>
			</TR>
		</TBODY>
</TABLE>
             
               
				  		</TD>
				 	 </TR>
				   		<TR>
               				 <TD bgColor=#5a86b3>
               				 
                 				 <P align=center><FONT face=Tahoma color=#ffffff size=1>Copyright: <%=StringUtils.exportString(lbean.getCopyright())%> &nbsp;&nbsp;&nbsp;Email: <%=StringUtils.exportString(lbean.getEmail())%>&nbsp;&nbsp;&nbsp;&nbsp;<A href="http://www.myconf.org/" target="_blank">Powered by MyConf 1.0</A></FONT></P>
                 			 </TD>
						</TR>
				  	</TBODY>
				</TABLE>
			</TD>
		</TR>
	</TBODY>
 </TABLE>
</TD>
</TR>
</TBODY>
</TABLE>
</BODY>
</HTML>
