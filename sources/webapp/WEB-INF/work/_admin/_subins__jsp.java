/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _admin;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.dao.*;
import org.myconf.beans.*;
import org.myconf.util.*;

public class _subins__jsp extends com.caucho.jsp.JavaPage{
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
    org.apache.struts.taglib.bean.MessageTag _jsp_tag3 = null;
    try {
      
//*********************************
//security
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      if (_jsp_tag0 == null) {
        _jsp_tag0 = new org.myconf.AuthTag();
        _jsp_tag0.setPageContext(pageContext);
        _jsp_tag0.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag0.setModule("admin");
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
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);

      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      
//*********************************
//head
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/head.jsp");
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      
//*********************************
//top
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/top.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/logo_admin.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/admin/sub/mainmenu1.jsp");
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      pageContext.include("/admin/sub/leftmenu1.jsp");
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      pageContext.include("/inc/stat.jsp");
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("menu.left.submission");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      _jsp_tag1.setKey("menu.sub.top.ins");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/admin/subsubject.jsp");
      int _jspEval12 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar13 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar13 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("menu.sub.top.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag2.setPage("/admin/subformat.jsp");
      int _jspEval19 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar20 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar20 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("menu.sub.top.format");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag2.setPage("/admin/subsize.jsp");
      int _jspEval26 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar27 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar27 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("menu.sub.top.size");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setPage("/admin/subdate.jsp");
      int _jspEval33 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar34 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar34 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("menu.sub.top.subdate");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setPage("/admin/subcondate.jsp");
      int _jspEval40 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar41 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar41 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("menu.sub.top.confirmdate");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag1.setKey("page.subins.ins1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag1.setKey("page.subins.ins2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag1.setKey("page.subins.ins3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag2.setPage("/config.do");
      int _jspEval56 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar57 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar57 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if(conf!=null){out.print(StringUtils.exportString(conf.getSubIns()));}
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.button.save");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      _jsp_tag3.setKey("common.button.save.and.next");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      if (_jsp_tag0 != null)
        _jsp_tag0.release();
      if (_jsp_tag1 != null)
        _jsp_tag1.release();
      if (_jsp_tag2 != null)
        _jsp_tag2.release();
      if (_jsp_tag3 != null)
        _jsp_tag3.release();
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
    _caucho_line_map = new com.caucho.java.LineMap("_subins__jsp.java", "/myconf/admin/subins.jsp");
    _caucho_line_map.add(17, 1);
    _caucho_line_map.add(1, 34);
    _caucho_line_map.add(6, 40);
    _caucho_line_map.add(7, 50);
    _caucho_line_map.add(8, 54);
    _caucho_line_map.add(13, 60);
    _caucho_line_map.add(25, 73);
    _caucho_line_map.add(30, 77);
    _caucho_line_map.add(35, 83);
    _caucho_line_map.add(38, 85);
    _caucho_line_map.add(43, 91);
    _caucho_line_map.add(44, 93);
    _caucho_line_map.add(45, 95);
    _caucho_line_map.add(50, 101);
    _caucho_line_map.add(56, 103);
    _caucho_line_map.add(57, 105);
    _caucho_line_map.add(64, 107);
    _caucho_line_map.add(67, 117);
    _caucho_line_map.add(68, 120);
    _caucho_line_map.add(68, 132);
    _caucho_line_map.add(69, 135);
    _caucho_line_map.add(69, 141);
    _caucho_line_map.add(70, 144);
    _caucho_line_map.add(70, 150);
    _caucho_line_map.add(71, 153);
    _caucho_line_map.add(71, 159);
    _caucho_line_map.add(72, 162);
    _caucho_line_map.add(72, 168);
    _caucho_line_map.add(80, 171);
    _caucho_line_map.add(81, 174);
    _caucho_line_map.add(82, 177);
    _caucho_line_map.add(86, 180);
    _caucho_line_map.add(98, 188);
    _caucho_line_map.add(99, 197);
    _caucho_line_map.add(109, 200);
    _caucho_line_map.add(114, 206);
    _caucho_line_map.add(119, 212);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/subins.jsp"), 1176989706000L, 5072L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string17;
  private static byte []_jsp_string14;
  private static byte []_jsp_string8;
  private static byte []_jsp_string6;
  private static byte []_jsp_string1;
  private static byte []_jsp_string3;
  private static byte []_jsp_string12;
  private static byte []_jsp_string13;
  private static byte []_jsp_string19;
  private static byte []_jsp_string0;
  private static byte []_jsp_string18;
  private static byte []_jsp_string16;
  private static byte []_jsp_string4;
  private static byte []_jsp_string7;
  private static byte []_jsp_string2;
  private static byte []_jsp_string15;
  private static byte []_jsp_string5;
  private static byte []_jsp_string9;
  private static byte []_jsp_string10;
  private static byte []_jsp_string11;
  static {
    try {
      _jsp_string17 = "\">\r\n                    <input name=\"next\" onClick=\"subins.fromPage.value='/admin/subsubject.jsp';\" type=\"submit\" class=\"button\" id=\"next\" value=\"".getBytes("UTF8");
      _jsp_string14 = "</li>\r\n        		<div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string8 = "\" class=\"pagemenu\">".getBytes("UTF8");
      _jsp_string6 = "</b></td>\r\n        </tr>\r\n        <tr>\r\n          <td align=\"right\" class=\"pagecontent_right\"><span class=\"pagemenu_visited\">".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string12 = "</li>\r\n				  <li>".getBytes("UTF8");
      _jsp_string13 = "</li>\r\n                  <li>".getBytes("UTF8");
      _jsp_string19 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string18 = "\">\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n            </form></td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string16 = "</textarea>\r\n    				<div class=\"spacer_5\"></div></td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td class=\"form_row_submit\"><input name=\"save\" onClick=\"subins.fromPage.value='/admin/subins.jsp';\" type=\"submit\" class=\"button\" id=\"save\" value=\"".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string7 = "</span> > \r\n                <a href=\"".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string15 = "\" method=\"post\" name=\"subins\" id=\"subins\">\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td class=\"form_row_content\"><div class=\"spacer_5\"></div>\r\n    				<input name=\"eventSubmit_Save\" type=\"hidden\" id=\"eventSubmit_Save\" value=\"1\">\r\n    				<input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"\">\r\n                    <textarea name=\"subIns\" id=\"subIns\" style=\"width:80%;height:280px\">".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr>\r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string9 = "</a> > \r\n                <a href=\"".getBytes("UTF8");
      _jsp_string10 = "</a> > \r\n				<a href=\"".getBytes("UTF8");
      _jsp_string11 = "</a></td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
