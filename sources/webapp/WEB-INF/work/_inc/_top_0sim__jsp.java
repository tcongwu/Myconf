/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _inc;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _top_0sim__jsp extends com.caucho.jsp.JavaPage{
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
    try {
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      out.print((org.myconf.Globals.LANGUAGE_SIMPLIFIED));
      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      out.print((org.myconf.Globals.LANGUAGE_TRADITIONAL));
      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      out.print((org.myconf.Globals.LANGUAGE_ENGLISH));
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
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
    _caucho_line_map = new com.caucho.java.LineMap("_top_0sim__jsp.java", "/myconf/inc/top_sim.jsp");
    _caucho_line_map.add(1, 1);
    _caucho_line_map.add(1, 27);
    _caucho_line_map.add(4, 28);
    _caucho_line_map.add(4, 30);
    _caucho_line_map.add(4, 32);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("inc/top_sim.jsp"), 1175436038000L, 474L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string1;
  private static byte []_jsp_string0;
  private static byte []_jsp_string2;
  static {
    try {
      _jsp_string1 = "</b></a>&nbsp;|&nbsp;<a href=\"#\"><b>".getBytes("UTF8");
      _jsp_string0 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"0\" class=\"float_bar\">\r\n  <tr>\r\n    <td width=\"268\">&nbsp;<a href=\"#\"><b>".getBytes("UTF8");
      _jsp_string2 = "</b></a></td>\r\n    <td width=\"498\" align=\"right\">&nbsp;</td>\r\n  </tr>\r\n</table>".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
