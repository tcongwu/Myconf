/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _expert._sub;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.beans.*;

public class _mainmenu4__jsp extends com.caucho.jsp.JavaPage{
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
    org.apache.struts.taglib.bean.MessageTag _jsp_tag2 = null;
    try {
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      org.myconf.SessionUserObject uinfo;
      uinfo = (org.myconf.SessionUserObject) request.getAttribute("uinfo");
      if (uinfo == null) {
        uinfo = new org.myconf.SessionUserObject();
        request.setAttribute("uinfo", uinfo);
      }
      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      if (_jsp_tag0 == null) {
        _jsp_tag0 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag0.setPageContext(pageContext);
        _jsp_tag0.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag0.setPage("/expert/index.jsp");
      int _jspEval2 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar3 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar3 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("expert");
      }

      _jsp_tag1.setKey("menu.top.reviewins");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      _jsp_tag0.setPage("/expert/bid.jsp");
      int _jspEval9 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      _jsp_tag1.setKey("menu.top.bid");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      _jsp_tag0.setPage("/expert/reviewing.jsp");
      int _jspEval16 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar17 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar17 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      _jsp_tag1.setKey("menu.top.reviewing");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      _jsp_tag0.setPage("/expert/reviewed.jsp");
      int _jspEval23 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar24 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar24 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      _jsp_tag1.setKey("menu.top.reviewed");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      _jsp_tag0.setPage("/bbs/index.jsp");
      int _jspEval30 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar31 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar31 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      _jsp_tag1.setKey("menu.top.bbs");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag0.setPage("/user.do");
      int _jspEval37 = _jsp_tag0.doStartTag();
      int _jsp_endTagVar38 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar38 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("menu.role.title");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      if(uinfo.getIsAdmin()==UserBean.TRUE){
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("menu.role.admin");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      }
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      if(uinfo.getIsExpert()==UserBean.TRUE){
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("menu.role.expert");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      }
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      if(uinfo.getIsContent()==UserBean.TRUE){
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("menu.role.site");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      }
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      if(uinfo.getIsAuthor()==UserBean.TRUE){
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("menu.role.author");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      }
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_mainmenu4__jsp.java", "/myconf/expert/sub/mainmenu4.jsp");
    _caucho_line_map.add(4, 1);
    _caucho_line_map.add(1, 31);
    _caucho_line_map.add(9, 42);
    _caucho_line_map.add(9, 54);
    _caucho_line_map.add(9, 64);
    _caucho_line_map.add(9, 70);
    _caucho_line_map.add(9, 73);
    _caucho_line_map.add(9, 79);
    _caucho_line_map.add(9, 82);
    _caucho_line_map.add(9, 88);
    _caucho_line_map.add(9, 91);
    _caucho_line_map.add(9, 97);
    _caucho_line_map.add(11, 100);
    _caucho_line_map.add(12, 106);
    _caucho_line_map.add(13, 115);
    _caucho_line_map.add(13, 117);
    _caucho_line_map.add(13, 126);
    _caucho_line_map.add(14, 128);
    _caucho_line_map.add(14, 130);
    _caucho_line_map.add(14, 139);
    _caucho_line_map.add(15, 141);
    _caucho_line_map.add(15, 143);
    _caucho_line_map.add(15, 152);
    _caucho_line_map.add(16, 154);
    _caucho_line_map.add(16, 156);
    _caucho_line_map.add(16, 165);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("expert/sub/mainmenu4.jsp"), 1178722858000L, 2097L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string10;
  private static byte []_jsp_string6;
  private static byte []_jsp_string13;
  private static byte []_jsp_string4;
  private static byte []_jsp_string11;
  private static byte []_jsp_string3;
  private static byte []_jsp_string1;
  private static byte []_jsp_string2;
  private static byte []_jsp_string0;
  private static byte []_jsp_string12;
  private static byte []_jsp_string7;
  private static byte []_jsp_string14;
  private static byte []_jsp_string5;
  private static byte []_jsp_string15;
  private static byte []_jsp_string9;
  private static byte []_jsp_string8;
  private static byte []_jsp_string16;
  static {
    try {
      _jsp_string10 = "<option value=\"admin\">".getBytes("UTF8");
      _jsp_string6 = "\" target=\"_blank\">".getBytes("UTF8");
      _jsp_string13 = "<option value=\"expert\">".getBytes("UTF8");
      _jsp_string4 = "</a><a class=\"nav_on\"><a class=\"selected\" href=\"".getBytes("UTF8");
      _jsp_string11 = "</option>".getBytes("UTF8");
      _jsp_string3 = "</a><a class=\"split\"></a><a href=\"".getBytes("UTF8");
      _jsp_string1 = "\r\n<table width=\"778\" height=\"31\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr> \r\n    <td width=\"10\" class=\"channel_bar_left\">&nbsp;</td>\r\n    <td width=\"576\" class=\"channel_bar_bg\"><div class=\"fleft sitenav\"><a href=\"".getBytes("UTF8");
      _jsp_string2 = "\">".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string12 = "\r\n        ".getBytes("UTF8");
      _jsp_string7 = "</a></div></td>\r\n    <td width=\"182\" style=\"PADDING-TOP: 2px;\" align=\"right\" class=\"channel_bar_bg\">\r\n	  <select name=\"select\"onChange=\"if(this.value.length>0){window.location='".getBytes("UTF8");
      _jsp_string14 = "<option value=\"site\">".getBytes("UTF8");
      _jsp_string5 = "</a></a><a href=\"".getBytes("UTF8");
      _jsp_string15 = "<option value=\"author\">".getBytes("UTF8");
      _jsp_string9 = "</option>\r\n        ".getBytes("UTF8");
      _jsp_string8 = "?eventSubmit_SelectRole&rid='+this.value;}\">\r\n        <option selected>".getBytes("UTF8");
      _jsp_string16 = "\r\n      </select>\r\n      &nbsp;</td>\r\n	<td width=\"10\" class=\"channel_bar_right\">&nbsp;</td>\r\n  </tr>\r\n</table>".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
