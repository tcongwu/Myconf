/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _site._sub;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.dao.*;
import org.myconf.util.*;
import org.myconf.beans.*;

public class _leftmenu1__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    com.caucho.jsp.QPageContext pageContext = (com.caucho.jsp.QPageContext) com.caucho.jsp.QJspFactory.create().getPageContext(this, request, response, null, true, 8192, true);
    javax.servlet.jsp.JspWriter out = (javax.servlet.jsp.JspWriter) pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.http.HttpSession session = pageContext.getSession();
    javax.servlet.ServletContext application = pageContext.getServletContext();
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    org.apache.struts.taglib.html.RewriteTag _jsp_tag0 = null;
    org.apache.struts.taglib.bean.MessageTag _jsp_tag1 = null;
    try {
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      if (_jsp_tag0 == null) {
        _jsp_tag0 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag0.setPageContext(pageContext);
        _jsp_tag0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag0.setPage("/site/publish.jsp?lang=");
      int _jspEval2 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar3 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar3 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      

	String langs=StringUtils.exportString(request.getParameter("version"));
	String  languange=(String) session.getAttribute("version");
	if(!langs.equals("")) languange=langs;
	if(languange==null||languange.equals("")){
	

      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_sessionout");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      if (_jsp_tag0 == null) {
        _jsp_tag0 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag0.setPageContext(pageContext);
        _jsp_tag0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag0.setPage("/site/index.jsp");
      int _jspEval9 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      	
	return;
	 
	}else{


      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      
	
	
	int langcount=LangDAO.getLangCount();
	int isdefault=1;
	if(langcount>1) {
		isdefault=LangBean.LANG_ISDEDAULT_NOT;
		}
	else
		{
		isdefault=LangBean.LANG_ISDEDAULT;
		}
	
	int langId=1;
	if(languange.equals("zh_cn")){langId=LangBean.LANG_ZH_CN;}
	if(languange.equals("zh_tw")){langId=LangBean.LANG_ZH_TW;}
	if(languange.equals("english")){langId=LangBean.LANG_ENGLISH;}
	
	LangBean lang=LangDAO.getLang(langId);
	boolean isAdd=false;
	if(lang!=null){isAdd=true;}	


      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.menu1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      if (_jsp_tag0 == null) {
        _jsp_tag0 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag0.setPageContext(pageContext);
        _jsp_tag0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag0.setPage("/site/site_setting.jsp?version=");
      int _jspEval16 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar17 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar17 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((languange));
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("page.site.submenu7");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.site.submenu7");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag0.setPage("/site/site_content.jsp");
      int _jspEval26 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar27 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar27 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("page.site.submenu3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.site.submenu3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag0.setPage("/site/site_menu.jsp");
      int _jspEval36 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar37 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar37 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("page.site.submenu2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.site.submenu2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag0.setPage("/site/site_template.jsp");
      int _jspEval46 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar47 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar47 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("page.site.submenu4");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.site.submenu4");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag1.setKey("page.site.menu3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag0.setPage("/site/site_out.jsp?version=");
      int _jspEval59 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar60 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar60 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((languange));
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("page.site.submenu5");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.site.submenu5");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      if(!languange.equals("")&&isAdd==true){
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      out.print((languange));
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.submenu6");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.site.submenu6");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      }
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      }
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      if (_jsp_tag0 != null)
        _jsp_tag0.release();
      if (_jsp_tag1 != null)
        _jsp_tag1.release();
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
    _caucho_line_map = new com.caucho.java.LineMap("_leftmenu1__jsp.java", "/myconf/site/sub/leftmenu1.jsp");
    _caucho_line_map.add(6, 1);
    _caucho_line_map.add(1, 32);
    _caucho_line_map.add(9, 38);
    _caucho_line_map.add(12, 50);
    _caucho_line_map.add(22, 69);
    _caucho_line_map.add(27, 81);
    _caucho_line_map.add(59, 112);
    _caucho_line_map.add(63, 122);
    _caucho_line_map.add(63, 133);
    _caucho_line_map.add(63, 135);
    _caucho_line_map.add(63, 138);
    _caucho_line_map.add(64, 141);
    _caucho_line_map.add(64, 147);
    _caucho_line_map.add(64, 150);
    _caucho_line_map.add(65, 153);
    _caucho_line_map.add(65, 159);
    _caucho_line_map.add(65, 162);
    _caucho_line_map.add(66, 165);
    _caucho_line_map.add(66, 171);
    _caucho_line_map.add(66, 174);
    _caucho_line_map.add(73, 177);
    _caucho_line_map.add(77, 180);
    _caucho_line_map.add(77, 185);
    _caucho_line_map.add(77, 187);
    _caucho_line_map.add(77, 190);
    _caucho_line_map.add(78, 193);
    _caucho_line_map.add(78, 195);
    _caucho_line_map.add(78, 197);
    _caucho_line_map.add(78, 207);
    _caucho_line_map.add(78, 210);
    _caucho_line_map.add(83, 212);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("site/sub/leftmenu1.jsp"), 1180786846000L, 3570L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string2;
  private static byte []_jsp_string17;
  private static byte []_jsp_string4;
  private static byte []_jsp_string1;
  private static byte []_jsp_string7;
  private static byte []_jsp_string20;
  private static byte []_jsp_string8;
  private static byte []_jsp_string19;
  private static byte []_jsp_string3;
  private static byte []_jsp_string15;
  private static byte []_jsp_string11;
  private static byte []_jsp_string10;
  private static byte []_jsp_string0;
  private static byte []_jsp_string9;
  private static byte []_jsp_string12;
  private static byte []_jsp_string16;
  private static byte []_jsp_string13;
  private static byte []_jsp_string6;
  private static byte []_jsp_string5;
  private static byte []_jsp_string21;
  private static byte []_jsp_string18;
  private static byte []_jsp_string14;
  static {
    try {
      _jsp_string2 = "\"+lang, \"published\", \"resizable=no,scrollbars=yes,height=600,width=800\");\r\n}\r\n</script>\r\n".getBytes("UTF8");
      _jsp_string17 = "<span class=\"paper_download\"><a href=\"#\" onclick=\"javascript:publish('".getBytes("UTF8");
      _jsp_string4 = "\");\r\n	window.location.href=\"".getBytes("UTF8");
      _jsp_string1 = "\r\n<script language=\"JavaScript\">\r\nfunction publish(lang) {\r\n	window.open(\"".getBytes("UTF8");
      _jsp_string7 = "\r\n<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"embed_module\">\r\n              <tr>\r\n                <td class=\"module_title\"><b>".getBytes("UTF8");
      _jsp_string20 = "\r\n		</td>\r\n              </tr>\r\n</table>\r\n\r\n".getBytes("UTF8");
      _jsp_string8 = "</b></td>\r\n              </tr>\r\n              <tr>\r\n                <td class=\"module_content\">\r\n				<span class=\"paper_setting\"><a href=\"".getBytes("UTF8");
      _jsp_string19 = "</a></span> ".getBytes("UTF8");
      _jsp_string3 = "\r\n<script languange=\"javascript\">\r\n	alert(\"".getBytes("UTF8");
      _jsp_string15 = "</b></td>\r\n              </tr>\r\n              <tr> \r\n                <td class=\"module_content\">\r\n    	    	<span class=\"paper_stat\"><a href=\"".getBytes("UTF8");
      _jsp_string11 = "</a></span>\r\n				<span class=\"paper_diliver\"><a href=\"".getBytes("UTF8");
      _jsp_string10 = "\">".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string9 = "\" title=\"".getBytes("UTF8");
      _jsp_string12 = "</a></span>\r\n		        <span class=\"paper_setting\"><a href=\"".getBytes("UTF8");
      _jsp_string16 = "</a></span>\r\n		".getBytes("UTF8");
      _jsp_string13 = "</a></span>\r\n				<span class=\"paper_review\"><a href=\"".getBytes("UTF8");
      _jsp_string6 = "\r\n\r\n".getBytes("UTF8");
      _jsp_string5 = "\"\r\n\r\n</script>\r\n\r\n\r\n".getBytes("UTF8");
      _jsp_string21 = "\r\n\r\n      ".getBytes("UTF8");
      _jsp_string18 = "')\"   title=\"".getBytes("UTF8");
      _jsp_string14 = "</a></span>\r\n				\r\n              </tr>\r\n</table>\r\n\r\n<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"embed_module_bottom\">\r\n              <tr> \r\n                <td class=\"module_title\"><b>".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
