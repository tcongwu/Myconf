/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _site;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.*;
import org.myconf.dao.LangDAO;
import org.myconf.dao.MenuDAO;
import org.myconf.beans.LangBean;
import org.myconf.util.StringUtils;
import org.myconf.util.FileUtils;
import java.util.*;
import java.io.File;

public class _site_0template__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    com.caucho.jsp.QPageContext pageContext = (com.caucho.jsp.QPageContext) com.caucho.jsp.QJspFactory.create().getPageContext(this, request, response, "/error.jsp", true, 8192, true);
    javax.servlet.jsp.JspWriter out = (javax.servlet.jsp.JspWriter) pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.http.HttpSession session = pageContext.getSession();
    javax.servlet.ServletContext application = pageContext.getServletContext();
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    org.myconf.AuthTag _jsp_tag0 = null;
    org.apache.struts.taglib.bean.MessageTag _jsp_tag1 = null;
    org.apache.struts.taglib.html.RewriteTag _jsp_tag2 = null;
    try {
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//security
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      if (_jsp_tag0 == null) {
        _jsp_tag0 = new org.myconf.AuthTag();
        _jsp_tag0.setPageContext(pageContext);
        _jsp_tag0.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag0.setModule("site");
      }

      _jsp_tag0.doStartTag();
      _jsp_tag0.setBodyContent(null);
      int _jsp_endTagVar3 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar3 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//define
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
	String key=(String) session.getAttribute("key");
	String languange=(String) session.getAttribute("version");
	if(key==null||languange==null){
	

      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_sessionout");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/site/index.jsp");
      int _jspEval9 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      	
	return;
	 
	}else{


      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      
	int langId=1;
	if(languange.equals("zh_cn")){langId=LangBean.LANG_ZH_CN;}
	if(languange.equals("zh_tw")){langId=LangBean.LANG_ZH_TW;}
	if(languange.equals("english")){langId=LangBean.LANG_ENGLISH;}
	
	int langcount=LangDAO.getLangCount();
	int isdefault=1;
	if(langcount>1) {
		isdefault=LangBean.LANG_ISDEDAULT_NOT;
		}
	else
		{
		isdefault=LangBean.LANG_ISDEDAULT;
		}
	LangBean lbean=LangDAO.getLangByID(langId);
	String template="";
	if(lbean!=null){
		template=StringUtils.exportString(lbean.getTemplate());
		
	}
	if(StringUtils.isEmpty(template))
	{
		template=Globals.TEMPLATE_DEFAUT;
	
	}
	if(lbean!=null){
		if(lbean.getIsDefault()==1||lbean.getIsDefault()==2)
			isdefault=lbean.getIsDefault();
	}
	List mlist=MenuDAO.getMenuByVersion(lbean);
	boolean isAdd=false;
	if(mlist!=null&&mlist.size()!=0){isAdd=true;}
		
	


      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      
//*********************************
//head
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/head.jsp");
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      
//*********************************
//top
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/top.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/logo_site.jsp");
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      
//*********************************
//content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/site/sub/mainmenu1.jsp");
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      pageContext.include("/site/sub/leftmenu1.jsp");
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      pageContext.include("/inc/stat.jsp");
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.submenu4");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey(key);
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag1.setKey("page.site.template_point1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag1.setKey("page.site.menu_point2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      if(isAdd==false){
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/images/rounded_top.gif");
      int _jspEval25 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar26 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar26 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.content_must2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      _jsp_tag2.setPage("/images/rounded_bottom.gif");
      int _jspEval32 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar33 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar33 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      }else{
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/lang.do");
      int _jspEval36 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar37 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar37 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      out.print((languange));
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      out.print((isdefault));
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      
            	String temproot=null;
            	String temproot1=null;
            	StringBuffer temp=new StringBuffer();
            	StringBuffer temp1=new StringBuffer();
           
            	boolean ismod=false;
              	String path=getServletContext().getRealPath("/")+"site"+File.separator+"template";
              	
               	if(FileUtils.isExistFolder(path)){
               		File file=new File(path);
               		File[]   files   =   file.listFiles();
               		if(files.length%2!=0)  ismod=true;
               		int i;
               		String filename="";
               		String filename1="";
               		
               			if(ismod==true)
               				i=1;
               			else
               				i=0;	
               				for(;i<(files.length);i+=2)
               				{
               			
               				filename=files[i].getName();
               				if(ismod==true)
               					filename1=StringUtils.exportString(files[i-1].getName());
               				else
               					filename1=StringUtils.exportString(files[i+1].getName());
               			
               				temproot=temp.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(filename).append("/").toString();
               				temproot1=temp1.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(filename1).append("/").toString();
               			 
              
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      out.print((temproot1));
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      out.print((temproot));
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      out.print((filename1));
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      if(template.equals(filename1)){out.println("checked");} 
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      out.print((filename));
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      if(template.equals(filename)){out.println("checked");} 
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      
			
			temp=new StringBuffer();
			temp1=new StringBuffer();
			}
			
			
			if(ismod==true){
				filename=files[files.length-1].getName();
				temproot=temp.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(filename).append("/").toString();
			
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      out.print((temproot));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      out.print((filename));
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      if(template.equals(filename)){out.println("checked");} 
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      	}
			}	
			
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      if(isAdd==true){
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.template_submit");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      }
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      }
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      

}
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      if (_jsp_tag0 != null)
        _jsp_tag0.release();
      if (_jsp_tag1 != null)
        _jsp_tag1.release();
      if (_jsp_tag2 != null)
        _jsp_tag2.release();
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }
  }

  private com.caucho.java.LineMap _caucho_line_map;
  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.util.CauchoSystem.getVersionId() != -2089842219)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Depend depend;
      depend = (com.caucho.vfs.Depend) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public com.caucho.java.LineMap _caucho_getLineMap()
  {
    return _caucho_line_map;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.java.LineMap lineMap,
                   com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    mergePath.addClassPath(getClass().getClassLoader());
    _caucho_line_map = new com.caucho.java.LineMap("_site_0template__jsp.java", "/conf1/site/site_template.jsp");
    _caucho_line_map.add(23, 1);
    _caucho_line_map.add(2, 39);
    _caucho_line_map.add(7, 45);
    _caucho_line_map.add(8, 55);
    _caucho_line_map.add(9, 59);
    _caucho_line_map.add(14, 65);
    _caucho_line_map.add(34, 94);
    _caucho_line_map.add(39, 106);
    _caucho_line_map.add(85, 151);
    _caucho_line_map.add(90, 157);
    _caucho_line_map.add(93, 159);
    _caucho_line_map.add(98, 165);
    _caucho_line_map.add(99, 167);
    _caucho_line_map.add(106, 175);
    _caucho_line_map.add(113, 177);
    _caucho_line_map.add(114, 179);
    _caucho_line_map.add(121, 181);
    _caucho_line_map.add(122, 191);
    _caucho_line_map.add(135, 194);
    _caucho_line_map.add(136, 197);
    _caucho_line_map.add(141, 200);
    _caucho_line_map.add(146, 202);
    _caucho_line_map.add(155, 214);
    _caucho_line_map.add(164, 224);
    _caucho_line_map.add(168, 230);
    _caucho_line_map.add(171, 244);
    _caucho_line_map.add(172, 246);
    _caucho_line_map.add(175, 248);
    _caucho_line_map.add(212, 283);
    _caucho_line_map.add(213, 285);
    _caucho_line_map.add(217, 287);
    _caucho_line_map.add(217, 289);
    _caucho_line_map.add(218, 291);
    _caucho_line_map.add(218, 293);
    _caucho_line_map.add(226, 295);
    _caucho_line_map.add(242, 307);
    _caucho_line_map.add(247, 309);
    _caucho_line_map.add(247, 311);
    _caucho_line_map.add(255, 313);
    _caucho_line_map.add(264, 317);
    _caucho_line_map.add(264, 319);
    _caucho_line_map.add(264, 329);
    _caucho_line_map.add(270, 331);
    _caucho_line_map.add(278, 333);
    _caucho_line_map.add(283, 339);
    _caucho_line_map.add(288, 345);
    _caucho_line_map.add(291, 347);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("site/site_template.jsp"), 1182002563843L, 10048L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string33;
  private static byte []_jsp_string2;
  private static byte []_jsp_string8;
  private static byte []_jsp_string24;
  private static byte []_jsp_string5;
  private static byte []_jsp_string12;
  private static byte []_jsp_string1;
  private static byte []_jsp_string13;
  private static byte []_jsp_string19;
  private static byte []_jsp_string0;
  private static byte []_jsp_string9;
  private static byte []_jsp_string30;
  private static byte []_jsp_string16;
  private static byte []_jsp_string35;
  private static byte []_jsp_string10;
  private static byte []_jsp_string6;
  private static byte []_jsp_string28;
  private static byte []_jsp_string20;
  private static byte []_jsp_string32;
  private static byte []_jsp_string25;
  private static byte []_jsp_string18;
  private static byte []_jsp_string21;
  private static byte []_jsp_string7;
  private static byte []_jsp_string17;
  private static byte []_jsp_string15;
  private static byte []_jsp_string36;
  private static byte []_jsp_string34;
  private static byte []_jsp_string29;
  private static byte []_jsp_string27;
  private static byte []_jsp_string11;
  private static byte []_jsp_string22;
  private static byte []_jsp_string26;
  private static byte []_jsp_string23;
  private static byte []_jsp_string37;
  private static byte []_jsp_string4;
  private static byte []_jsp_string3;
  private static byte []_jsp_string31;
  private static byte []_jsp_string14;
  static {
    try {
      _jsp_string33 = "  <input name=\"Submit\" onClick=\"formTemp.fromPage.value='/site/site_template.jsp';\"  type=\"submit\"   class=\"button\" value=\"".getBytes("UTF8");
      _jsp_string2 = "\");\r\n	window.location.href=\"".getBytes("UTF8");
      _jsp_string8 = "\r\n		   ".getBytes("UTF8");
      _jsp_string24 = "sample.jpg\"> </td>\r\n				      \r\n				    </tr>\r\n					<tr >\r\n					  <td  width=\"50%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"radio\" name=\"template\" value=\"".getBytes("UTF8");
      _jsp_string5 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string12 = "</li>\r\n                  <li>".getBytes("UTF8");
      _jsp_string1 = "\r\n<script languange=\"javascript\">\r\n	alert(\"".getBytes("UTF8");
      _jsp_string13 = "</li>\r\n        		<div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            \r\n             ".getBytes("UTF8");
      _jsp_string19 = "\"    method=\"post\"   >\r\n          <input type=\"hidden\" name=\"languange\" value=\"".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string9 = "\r\n		  </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n	\r\n        <tr>\r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string30 = "\"  ".getBytes("UTF8");
      _jsp_string16 = "</TD>\r\n				            </TR>\r\n				          </TBODY>\r\n				        </TABLE>\r\n				       \r\n				      </TD>\r\n				      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type=\"block\" width=\"1\"></TD>\r\n				    </TR>\r\n				    <TR> \r\n				      <TD noWrap width=80% colSpan=2 height=6><img width=\"570\" src=\"".getBytes("UTF8");
      _jsp_string35 = "\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n         </form>     \r\n         \r\n         ".getBytes("UTF8");
      _jsp_string10 = "</b></td>\r\n		  <td class=\"site_version\" align=\"right\"><b>".getBytes("UTF8");
      _jsp_string6 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string28 = "\r\n			\r\n		\r\n				\r\n				<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" >\r\n					<tr > \r\n					  <td  width=\"50%\"  ><img  height=\"165\"  width=\"200\" border=\"1\" src=\"".getBytes("UTF8");
      _jsp_string20 = "\">\r\n          <input type=\"hidden\" name=\"isdefault\"  value=\"".getBytes("UTF8");
      _jsp_string32 = "	\r\n				\r\n			\r\n\r\n				\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\r\n                <tr> \r\n                  <td class=\"form_row_submit\" align=\"center\">".getBytes("UTF8");
      _jsp_string25 = "\" ".getBytes("UTF8");
      _jsp_string18 = "           \r\n           \r\n          <form name=\"formTemp\" action=\"".getBytes("UTF8");
      _jsp_string21 = "\">\r\n          <input name=\"eventSubmit_SiteSetting\" type=\"hidden\" id=\"eventSubmit_SiteSetting\" value=\"1\">\r\n           <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"\">\r\n            ".getBytes("UTF8");
      _jsp_string7 = "\r\n\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n		   ".getBytes("UTF8");
      _jsp_string17 = "\"  height=\"5\"></TD>\r\n				    </TR>\r\n				  </TBODY>\r\n				</TABLE>\r\n 	 ".getBytes("UTF8");
      _jsp_string15 = "\"  height=\"5\"></TD>\r\n				    </TR>\r\n				    <TR> \r\n				      <TD width=1 height=\"73\" noWrap bgColor=#a9a9a9><SPACER type=\"block\" width=\"1\"></TD>\r\n				      <TD width=80% noWrap>\r\n				      	\r\n				      	<TABLE width=80% border=0 align=\"center\" cellPadding=5 cellSpacing=0>\r\n				          <TBODY>\r\n				            <TR> \r\n				              <TD align=\"center\" style=\"font-size:16px;\" class=\"redins\">".getBytes("UTF8");
      _jsp_string36 = "\r\n          </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n<div class=\"spacer_20\"></div>\r\n".getBytes("UTF8");
      _jsp_string34 = "\">".getBytes("UTF8");
      _jsp_string29 = "sample.jpg\">  </td>\r\n					  \r\n				    \r\n				    </tr>\r\n					<tr >\r\n					  <td  width=\"50%\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"radio\" name=\"template\" value=\"".getBytes("UTF8");
      _jsp_string27 = " ></td>\r\n				     \r\n			       </tr>\r\n					<tr >\r\n					<td  align=\"center\" colspan=\"2\" height=\"2\">&nbsp;</td>\r\n			       </tr>\r\n				    	\r\n				</table>\r\n			".getBytes("UTF8");
      _jsp_string11 = "</b></td>\r\n        </tr>\r\n        <tr >\r\n          <td align=\"right\"  colspan=\"2\" height=\"5\">&nbsp;\r\n          	\r\n          </td>		\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string22 = "\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" >\r\n             \r\n					<tr > \r\n					  <td  width=\"50%\"  ><img  height=\"165\"  width=\"200\" border=\"1\" src=\"".getBytes("UTF8");
      _jsp_string26 = " ></td>\r\n					  <td  align=\"center\" width=\"50%\"><input type=\"radio\" name=\"template\" value=\"".getBytes("UTF8");
      _jsp_string23 = "sample.jpg\">  </td>\r\n					   <td  align=\"center\" ><img  height=\"165\"  width=\"200\" border=\"1\" src=\"".getBytes("UTF8");
      _jsp_string37 = "\r\n</body>\r\n</html>\r\n".getBytes("UTF8");
      _jsp_string4 = "\r\n\r\n".getBytes("UTF8");
      _jsp_string3 = "\"\r\n\r\n</script>\r\n\r\n\r\n".getBytes("UTF8");
      _jsp_string31 = " ></td>\r\n					  \r\n			       </tr>\r\n\r\n				    <tr >\r\n					<td  align=\"center\" colspan=\"2\" height=\"2\">&nbsp;</td>\r\n			       </tr>	\r\n				</table>\r\n			".getBytes("UTF8");
      _jsp_string14 = "      \r\n            <br>\r\n            <TABLE width=80% height=\"84\" border=0 align=\"center\" cellPadding=0 cellSpacing=0 summary=null>\r\n				  <TBODY>\r\n				    <TR> \r\n				      <TD noWrap width=80% colSpan=2 height=5><img width=\"570\" src=\"".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
