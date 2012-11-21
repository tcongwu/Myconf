/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _site;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.dao.ContentDAO;
import org.myconf.dao.MenuDAO;
import org.myconf.dao.LangDAO;
import org.myconf.beans.MenuBean;
import org.myconf.beans.ContentBean;
import org.myconf.beans.LangBean;
import org.myconf.util.StringUtils;
import java.util.*;

public class _site_0menuedit__jsp extends com.caucho.jsp.JavaPage{
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
	
	List clist=ContentDAO.getContentByVersion(LangDAO.getLang(langId));
	
	MenuBean mbean;
	String menuname="";
	String  mtype="";
	String mlink="";
	String mopentype="";
	String  mpublished="";
	String mstyle="";
	String mordering="";
	
	String mid=StringUtils.exportString(request.getParameter("id"));
	if(!mid.equals("")){
		mbean=MenuDAO.getMenuByID(Integer.parseInt(mid));
		menuname=StringUtils.exportString(mbean.getMenuName());
		mtype=StringUtils.exportString(mbean.getType());
		mlink=StringUtils.exportString(mbean.getLink());
		mopentype=StringUtils.exportString(mbean.getOpenType());
		mstyle=StringUtils.exportString(mbean.getStyle());
		mpublished=mbean.getPublished()+"";
		mordering=mbean.getOrdering()+"";
		
		
	}


      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      
//*********************************
//head
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/head.jsp");
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_name_notnull");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("page.site.menu_link_notnull");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      
//*********************************
//top
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/top.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/logo_site.jsp");
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      
//*********************************
//content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/site/sub/mainmenu1.jsp");
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      pageContext.include("/site/sub/leftmenu1.jsp");
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      pageContext.include("/inc/stat.jsp");
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.submenu2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag1.setKey(key);
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag1.setKey("page.site.menu_point1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag1.setKey("page.site.setting_point3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/menu.do");
      int _jspEval31 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar32 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar32 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      out.print((languange));
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((mid));
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      _jsp_tag1.setKey("page.site.menu_name");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      out.print((menuname));
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      _jsp_tag1.setKey("page.site.menu_linktype");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      if(mtype.equals("page")){out.println("checked");}
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      if(mtype.equals("url")){out.println("checked");}
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_link");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      out.print((mlink));
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      _jsp_tag1.setKey("page.site.menu_linkcontent");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      
				  			 if(clist!=null&&clist.size()>0){
				   				for(int i=0;i<clist.size();i++){
				   					ContentBean cbean=(ContentBean)clist.get(i);
				   					if(cbean.getPublished()==1){
				   			
				   		
				  			 
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      out.print((cbean.getId()));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      if(mlink.equals(cbean.getId()+"")){out.println("SELECTED");}
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      out.print((StringUtils.exportString(cbean.getTitle())));
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      		}
								}
							}
							
							
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_opentype");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      if(mopentype.equals("_self")){out.println("SELECTED");}
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_open2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      if(mopentype.equals("_blank")){out.println("SELECTED");}
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_open1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      _jsp_tag1.setKey("page.site.menu_published");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      if(mpublished.equals("1")){out.println("SELECTED");}
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_published1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      if(mpublished.equals("2")){out.println("SELECTED");}
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_published2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
      _jsp_tag1.setKey("page.site.menu_showtype");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      if(mstyle.indexOf("1")>=0){out.println("checked");}
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_showtype1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string42, 0, _jsp_string42.length);
      if(mstyle.indexOf("2")>=0){out.println("checked");}
      pageContext.write(_jsp_string43, 0, _jsp_string43.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu_showtype2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string44, 0, _jsp_string44.length);
      _jsp_tag1.setKey("page.site.menu_editbutton");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string45, 0, _jsp_string45.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string46, 0, _jsp_string46.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_site_0menuedit__jsp.java", "/conf1/site/site_menuedit.jsp");
    _caucho_line_map.add(23, 1);
    _caucho_line_map.add(2, 39);
    _caucho_line_map.add(7, 45);
    _caucho_line_map.add(8, 55);
    _caucho_line_map.add(9, 59);
    _caucho_line_map.add(14, 65);
    _caucho_line_map.add(34, 94);
    _caucho_line_map.add(39, 106);
    _caucho_line_map.add(84, 152);
    _caucho_line_map.add(89, 154);
    _caucho_line_map.add(95, 164);
    _caucho_line_map.add(128, 167);
    _caucho_line_map.add(133, 173);
    _caucho_line_map.add(134, 175);
    _caucho_line_map.add(137, 177);
    _caucho_line_map.add(142, 183);
    _caucho_line_map.add(148, 185);
    _caucho_line_map.add(149, 187);
    _caucho_line_map.add(156, 189);
    _caucho_line_map.add(157, 199);
    _caucho_line_map.add(170, 202);
    _caucho_line_map.add(172, 205);
    _caucho_line_map.add(176, 208);
    _caucho_line_map.add(177, 220);
    _caucho_line_map.add(178, 222);
    _caucho_line_map.add(183, 224);
    _caucho_line_map.add(185, 227);
    _caucho_line_map.add(192, 229);
    _caucho_line_map.add(194, 232);
    _caucho_line_map.add(194, 234);
    _caucho_line_map.add(201, 236);
    _caucho_line_map.add(203, 246);
    _caucho_line_map.add(211, 248);
    _caucho_line_map.add(215, 251);
    _caucho_line_map.add(223, 260);
    _caucho_line_map.add(223, 262);
    _caucho_line_map.add(223, 264);
    _caucho_line_map.add(238, 272);
    _caucho_line_map.add(242, 282);
    _caucho_line_map.add(242, 284);
    _caucho_line_map.add(243, 294);
    _caucho_line_map.add(243, 296);
    _caucho_line_map.add(257, 309);
    _caucho_line_map.add(257, 311);
    _caucho_line_map.add(258, 321);
    _caucho_line_map.add(258, 323);
    _caucho_line_map.add(267, 333);
    _caucho_line_map.add(269, 336);
    _caucho_line_map.add(269, 338);
    _caucho_line_map.add(271, 348);
    _caucho_line_map.add(271, 350);
    _caucho_line_map.add(279, 360);
    _caucho_line_map.add(292, 363);
    _caucho_line_map.add(297, 369);
    _caucho_line_map.add(302, 375);
    _caucho_line_map.add(305, 377);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("site/site_menuedit.jsp"), 1180786006000L, 11211L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string38;
  private static byte []_jsp_string39;
  private static byte []_jsp_string2;
  private static byte []_jsp_string6;
  private static byte []_jsp_string11;
  private static byte []_jsp_string18;
  private static byte []_jsp_string24;
  private static byte []_jsp_string41;
  private static byte []_jsp_string44;
  private static byte []_jsp_string1;
  private static byte []_jsp_string27;
  private static byte []_jsp_string31;
  private static byte []_jsp_string9;
  private static byte []_jsp_string22;
  private static byte []_jsp_string42;
  private static byte []_jsp_string0;
  private static byte []_jsp_string30;
  private static byte []_jsp_string8;
  private static byte []_jsp_string32;
  private static byte []_jsp_string29;
  private static byte []_jsp_string19;
  private static byte []_jsp_string33;
  private static byte []_jsp_string21;
  private static byte []_jsp_string16;
  private static byte []_jsp_string37;
  private static byte []_jsp_string13;
  private static byte []_jsp_string5;
  private static byte []_jsp_string40;
  private static byte []_jsp_string34;
  private static byte []_jsp_string28;
  private static byte []_jsp_string20;
  private static byte []_jsp_string26;
  private static byte []_jsp_string17;
  private static byte []_jsp_string45;
  private static byte []_jsp_string25;
  private static byte []_jsp_string14;
  private static byte []_jsp_string36;
  private static byte []_jsp_string43;
  private static byte []_jsp_string15;
  private static byte []_jsp_string12;
  private static byte []_jsp_string46;
  private static byte []_jsp_string4;
  private static byte []_jsp_string3;
  private static byte []_jsp_string10;
  private static byte []_jsp_string23;
  private static byte []_jsp_string7;
  private static byte []_jsp_string35;
  static {
    try {
      _jsp_string38 = "   \r\n							<OPTION  VALUE=\"2\" ".getBytes("UTF8");
      _jsp_string39 = " \r\n							</SELECT>   \r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n       </table>\r\n	   \r\n	    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\" id=\"pagebox3\">\r\n                <tr>\r\n                  <td width=\"20%\" class=\"form_row_title\">   ".getBytes("UTF8");
      _jsp_string2 = "\");\r\n	window.location.href=\"".getBytes("UTF8");
      _jsp_string6 = "\r\n<script  language=\"javascript\">\r\nfunction checkForm()\r\n{\r\n	if (trim(formMenu.menuName.value).length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string11 = "\r\n		   ".getBytes("UTF8");
      _jsp_string18 = "\">\r\n	<input type=\"hidden\" name=\"id\" value=\"".getBytes("UTF8");
      _jsp_string24 = "  value=\"url\" onClick=\"switchRadioValue();\">\r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n       </table>\r\n	   <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\" id=\"urlbox\">\r\n                <tr>\r\n                  <td width=\"20%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string41 = " value=\"1\"> ".getBytes("UTF8");
      _jsp_string44 = "\r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n       </table>\r\n\r\n	  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n		<tr> \r\n		  <td class=\"form_row_submit\">      <input name=\"eventSubmit_EditMenu\" type=\"submit\" class=\"button\" value=\"".getBytes("UTF8");
      _jsp_string1 = "\r\n<script languange=\"javascript\">\r\n	alert(\"".getBytes("UTF8");
      _jsp_string27 = "   </td>\r\n                  <td width=\"80%\" class=\"form_row_content\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n                   \r\n							<SELECT  NAME=\"linkcontent\"  SIZE=\"10\"   >  \r\n						 ".getBytes("UTF8");
      _jsp_string31 = "</option>\r\n							\r\n							".getBytes("UTF8");
      _jsp_string9 = "\r\n\r\n\r\n".getBytes("UTF8");
      _jsp_string22 = " </td>\r\n                  <td width=\"80%\" class=\"form_row_content\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n                   page<input type=\"radio\" name=\"type1\" value=\"page\" ".getBytes("UTF8");
      _jsp_string42 = " \r\n				   &nbsp;&nbsp;\r\n				  <input type=\"checkbox\"  name=\"style2\"  ".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string30 = " >".getBytes("UTF8");
      _jsp_string8 = "\");\r\n		formMenu.link.focus();\r\n		return ;\r\n	}\r\n-->	\r\n	\r\n	return true;\r\n} 	\r\n</script>\r\n\r\n<script language=javascript>\r\n\r\nfunction switchRadioValue(){   \r\n  if (formMenu.type1[0].checked)\r\n  {\r\n   hideLayer('urlbox');\r\n   showLayer('pagebox');\r\n   //showLayer('pagebox1');\r\n   //showLayer('pagebox2');\r\n   showLayer('pagebox3');\r\n  }\r\n   if (formMenu.type1[1].checked)\r\n  {\r\n   hideLayer('pagebox');\r\n   //hideLayer('pagebox1');\r\n  // hideLayer('pagebox2');\r\n   hideLayer('pagebox3');\r\n   showLayer('urlbox');\r\n  } \r\n }\r\n </script>\r\n\r\n<body  onLoad=\"switchRadioValue();\">\r\n".getBytes("UTF8");
      _jsp_string32 = "\r\n							</SELECT>   \r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n       </table>\r\n	   \r\n	    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\" id=\"pagebox1\">\r\n                <tr>\r\n                  <td width=\"20%\" class=\"form_row_title\"> ".getBytes("UTF8");
      _jsp_string29 = "\"  ".getBytes("UTF8");
      _jsp_string19 = "\">\r\n		\r\n	  \r\n	    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td width=\"20%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string33 = "    </td>\r\n                  <td width=\"80%\" class=\"form_row_content\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n                  \r\n							<SELECT  NAME=\"openType\"   >\r\n							<OPTION  VALUE=\"_self\" ".getBytes("UTF8");
      _jsp_string21 = "\"> \r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n       </table>\r\n	    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td width=\"20%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string16 = "</li>\r\n        		<div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n	<form name=\"formMenu\" action=\"".getBytes("UTF8");
      _jsp_string37 = "   </td>\r\n                  <td width=\"80%\" class=\"form_row_content\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n                 \r\n							<SELECT  NAME=\"published\"   >  \r\n							<OPTION  VALUE=\"1\"  ".getBytes("UTF8");
      _jsp_string13 = "</b></td>\r\n		  <td class=\"site_version\" align=\"right\"><b>".getBytes("UTF8");
      _jsp_string5 = "\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string40 = "  </td>\r\n                  <td width=\"80%\" class=\"form_row_content\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n				  <input type=\"checkbox\"  name=\"style1\"  ".getBytes("UTF8");
      _jsp_string34 = ">".getBytes("UTF8");
      _jsp_string28 = " \r\n							<OPTION  VALUE=\"".getBytes("UTF8");
      _jsp_string20 = " </td>\r\n                  <td width=\"80%\" class=\"form_row_content\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n                    <input name=\"menuName\" type=\"text\" size=\"40\" value=\"".getBytes("UTF8");
      _jsp_string26 = "\" size=\"40\"> \r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n       </table>\r\n	   \r\n	    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\" id=\"pagebox\">\r\n                <tr>\r\n                  <td width=\"20%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string17 = "\"    method=\"post\"   onSubmit=\"return checkForm();\">\r\n	<input type=\"hidden\" name=\"languange\" value=\"".getBytes("UTF8");
      _jsp_string45 = " \">\r\n		  </td></tr>\r\n	  </table>\r\n	  \r\n            </form>\r\n			\r\n			</td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n<div class=\"spacer_20\"></div>\r\n".getBytes("UTF8");
      _jsp_string25 = " </td>\r\n                  <td width=\"80%\" class=\"form_row_content\">&nbsp;&nbsp;&nbsp;&nbsp;\r\n                  <input type=\"text\" name=\"link\" value=\"".getBytes("UTF8");
      _jsp_string14 = "</b></td>\r\n        </tr>\r\n        <tr >\r\n          <td align=\"right\"  colspan=\"2\" height=\"5\">&nbsp;\r\n          	\r\n          </td>		\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string36 = "   \r\n							 \r\n							</SELECT>   \r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n       </table>\r\n	   \r\n	     <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\" id=\"pagebox2\">\r\n                <tr>\r\n                  <td width=\"20%\" class=\"form_row_title\">  ".getBytes("UTF8");
      _jsp_string43 = "   value=\"2\"> ".getBytes("UTF8");
      _jsp_string15 = "</li>\r\n				\r\n                  <li>".getBytes("UTF8");
      _jsp_string12 = "\r\n		  </td>\r\n        </tr>\r\n      </table></td>\r\n     <td width=\"598\" valign=\"top\" class=\"pagecontent\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n	\r\n        <tr>\r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string46 = "\r\n</body>\r\n</html>\r\n".getBytes("UTF8");
      _jsp_string4 = "\r\n\r\n".getBytes("UTF8");
      _jsp_string3 = "\"\r\n\r\n</script>\r\n\r\n\r\n".getBytes("UTF8");
      _jsp_string10 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n		  ".getBytes("UTF8");
      _jsp_string23 = " onClick=\"switchRadioValue();\"> &nbsp;&nbsp;&nbsp;url<input type=\"radio\" name=\"type1\" ".getBytes("UTF8");
      _jsp_string7 = "\");\r\n		formMenu.menuName.focus();\r\n		return false;\r\n	}\r\n<!--	\r\n	if (trim(formMenu.link.value).length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string35 = "   \r\n							<OPTION  VALUE=\"_blank\"  ".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
