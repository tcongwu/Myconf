/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _submission;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.beans.ConfigBean;
import org.myconf.dao.ConfigDAO;
import org.myconf.util.StringUtils;

public class _instruction__jsp extends com.caucho.jsp.JavaPage{
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
    org.apache.struts.taglib.html.RewriteTag _jsp_tag1 = null;
    org.apache.struts.taglib.bean.MessageTag _jsp_tag2 = null;
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
        _jsp_tag0.setModule("author");
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
      pageContext.include("/inc/logo_author.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/submission/sub/mainmenu1.jsp");
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/images/rounded_top.gif");
      int _jspEval6 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar7 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar7 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      if((conf==null)||StringUtils.isEmpty(conf.getSubIns())){
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setKey("common.ins.underedit");
      }

      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      }else{
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      out.print((conf.getSubIns().replaceAll(" ", "&nbsp").replaceAll("\n", "<br>")));
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      }
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/images/rounded_bottom.gif");
      int _jspEval13 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar14 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar14 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_instruction__jsp.java", "/myconf/submission/instruction.jsp");
    _caucho_line_map.add(17, 1);
    _caucho_line_map.add(1, 33);
    _caucho_line_map.add(6, 39);
    _caucho_line_map.add(7, 49);
    _caucho_line_map.add(8, 53);
    _caucho_line_map.add(13, 59);
    _caucho_line_map.add(25, 72);
    _caucho_line_map.add(30, 76);
    _caucho_line_map.add(35, 82);
    _caucho_line_map.add(38, 84);
    _caucho_line_map.add(43, 90);
    _caucho_line_map.add(44, 92);
    _caucho_line_map.add(45, 94);
    _caucho_line_map.add(50, 100);
    _caucho_line_map.add(55, 102);
    _caucho_line_map.add(60, 114);
    _caucho_line_map.add(64, 116);
    _caucho_line_map.add(68, 125);
    _caucho_line_map.add(71, 127);
    _caucho_line_map.add(74, 129);
    _caucho_line_map.add(79, 131);
    _caucho_line_map.add(83, 143);
    _caucho_line_map.add(88, 149);
    _caucho_line_map.add(93, 155);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("submission/instruction.jsp"), 1182180038531L, 2787L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string5;
  private static byte []_jsp_string10;
  private static byte []_jsp_string6;
  private static byte []_jsp_string1;
  private static byte []_jsp_string8;
  private static byte []_jsp_string3;
  private static byte []_jsp_string2;
  private static byte []_jsp_string9;
  private static byte []_jsp_string11;
  private static byte []_jsp_string7;
  private static byte []_jsp_string0;
  private static byte []_jsp_string4;
  static {
    try {
      _jsp_string5 = "\r\n      	<TABLE width=518 border=0 align=\"center\" cellPadding=5 cellSpacing=0>\r\n          <TBODY>\r\n            <TR> \r\n              <TD align=\"center\" style=\"font-size:16px;\" class=\"redins\">".getBytes("UTF8");
      _jsp_string10 = "\" width=\"778\" height=\"5\"></TD>\r\n    </TR>\r\n  </TBODY>\r\n</TABLE>\r\n".getBytes("UTF8");
      _jsp_string6 = "</TD>\r\n            </TR>\r\n          </TBODY>\r\n        </TABLE>\r\n        ".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string8 = "</td>\r\n          </tr>\r\n        </table>\r\n        ".getBytes("UTF8");
      _jsp_string3 = "\r\n<br>\r\n<TABLE width=778 height=\"84\" border=0 align=\"center\" cellPadding=0 cellSpacing=0 summary=null>\r\n  <TBODY>\r\n    <TR> \r\n      <TD noWrap width=778 colSpan=2 height=5><img src=\"".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string9 = "\r\n      </TD>\r\n      <TD noWrap width=1 bgColor=#a9a9a9></TD>\r\n    </TR>\r\n    <TR> \r\n      <TD noWrap width=778 colSpan=2 height=6><img src=\"".getBytes("UTF8");
      _jsp_string11 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string7 = "\r\n        <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"18\">\r\n          <tr>\r\n            <td style=\"font-size:16px;font-weight:bold\">".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string4 = "\" width=\"778\" height=\"5\"></TD>\r\n    </TR>\r\n    <TR> \r\n      <TD width=1 height=\"73\" noWrap bgColor=#a9a9a9></TD>\r\n      <TD width=776>\r\n      	".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
