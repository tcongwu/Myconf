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
import java.util.*;

public class _usercycle__jsp extends com.caucho.jsp.JavaPage{
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
    org.apache.struts.taglib.bean.MessageTag _jsp_tag2 = null;
    org.apache.struts.taglib.html.RewriteTag _jsp_tag3 = null;
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
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//recycle users list
List users=UserDAO.queryUser(false);
UserBean user=null;

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
      pageContext.include("/admin/sub/mainmenu3.jsp");
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      pageContext.include("/admin/sub/leftmenu3.jsp");
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      pageContext.include("/inc/stat.jsp");
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("menu.left.user.recycle");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      _jsp_tag1.setKey("page.usercycle.ins1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      if(users!=null && users.size()>0){
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.text.realname");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("common.text.email");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("common.text.email");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("common.text.recover");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      
              	for(int i=0;i<users.size();i++){
              	  user=(UserBean)users.get(i);
              
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      out.print((StringUtils.exportString(user.getRealName())));
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((user.getEmail()));
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((StringUtils.exportString(user.getWorkLocation())));
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("ins.confirm.recover");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setPage("/user.do?eventSubmit_Recover&id=");
      int _jspEval27 = _jsp_tag3.doStartTag();
      int _jsp_endTagVar28 = _jsp_tag3.doEndTag();
      if (_jsp_endTagVar28 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((user.getId()));
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      _jsp_tag3.setPage("/images/recover.gif");
      int _jspEval31 = _jsp_tag3.doStartTag();
      int _jsp_endTagVar32 = _jsp_tag3.doEndTag();
      if (_jsp_endTagVar32 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      }
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      }else{
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setKey("common.text.norecord");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      }
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_usercycle__jsp.java", "/conf1/admin/usercycle.jsp");
    _caucho_line_map.add(18, 1);
    _caucho_line_map.add(1, 35);
    _caucho_line_map.add(6, 41);
    _caucho_line_map.add(7, 51);
    _caucho_line_map.add(8, 55);
    _caucho_line_map.add(13, 61);
    _caucho_line_map.add(26, 75);
    _caucho_line_map.add(33, 81);
    _caucho_line_map.add(38, 87);
    _caucho_line_map.add(41, 89);
    _caucho_line_map.add(46, 95);
    _caucho_line_map.add(47, 97);
    _caucho_line_map.add(48, 99);
    _caucho_line_map.add(53, 105);
    _caucho_line_map.add(59, 107);
    _caucho_line_map.add(60, 109);
    _caucho_line_map.add(67, 111);
    _caucho_line_map.add(79, 121);
    _caucho_line_map.add(94, 124);
    _caucho_line_map.add(97, 126);
    _caucho_line_map.add(98, 136);
    _caucho_line_map.add(99, 139);
    _caucho_line_map.add(100, 142);
    _caucho_line_map.add(102, 151);
    _caucho_line_map.add(108, 158);
    _caucho_line_map.add(109, 160);
    _caucho_line_map.add(110, 162);
    _caucho_line_map.add(110, 171);
    _caucho_line_map.add(110, 182);
    _caucho_line_map.add(110, 184);
    _caucho_line_map.add(113, 190);
    _caucho_line_map.add(118, 194);
    _caucho_line_map.add(121, 203);
    _caucho_line_map.add(128, 205);
    _caucho_line_map.add(133, 211);
    _caucho_line_map.add(138, 217);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/usercycle.jsp"), 1178724836000L, 5086L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string6;
  private static byte []_jsp_string14;
  private static byte []_jsp_string15;
  private static byte []_jsp_string7;
  private static byte []_jsp_string1;
  private static byte []_jsp_string3;
  private static byte []_jsp_string16;
  private static byte []_jsp_string18;
  private static byte []_jsp_string8;
  private static byte []_jsp_string10;
  private static byte []_jsp_string11;
  private static byte []_jsp_string23;
  private static byte []_jsp_string13;
  private static byte []_jsp_string0;
  private static byte []_jsp_string19;
  private static byte []_jsp_string9;
  private static byte []_jsp_string20;
  private static byte []_jsp_string4;
  private static byte []_jsp_string17;
  private static byte []_jsp_string5;
  private static byte []_jsp_string12;
  private static byte []_jsp_string21;
  private static byte []_jsp_string2;
  private static byte []_jsp_string22;
  static {
    try {
      _jsp_string6 = "</b></td>\r\n        </tr>\r\n        <tr> \r\n          <td height=\"16\" class=\"pagecontent_right\"></td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td>\r\n			<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr> \r\n                <td><div class=\"spacer_5\"></div>\r\n                  <li>".getBytes("UTF8");
      _jsp_string14 = "</td>\r\n                <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string15 = "</td>\r\n                <td align=\"center\" nowrap class=\"table_cell\"><a onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string7 = "</li>\r\n                  <div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n              <tr> \r\n                <td nowrap class=\"form_row_submit\">&nbsp; </td>\r\n              </tr>\r\n            </table>\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n              <tr> \r\n                <td width=\"52%\"> <div class=\"line_dashed\"></div>\r\n                  <div class=\"spacer_10\"></div></td>\r\n              </tr>\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string16 = "')\" href=\"".getBytes("UTF8");
      _jsp_string18 = "\" width=\"21\" height=\"21\" border=\"0\"></a> \r\n                </td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string8 = "\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n              <tr> \r\n                <td width=\"12%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string10 = "</td>\r\n                <td width=\"33%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string11 = "</td>\r\n                <td width=\"7%\" align=\"center\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string23 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string13 = "\r\n              <tr> \r\n                <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string19 = "\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string9 = "</td>\r\n                <td width=\"48%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string20 = "\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n              <tr> \r\n                <td align=\"center\" class=\"blackbold\" nowrap>".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string17 = "\"><img src=\"".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr> \r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string12 = "</td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string21 = "</td>\r\n              </tr>\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string22 = "\r\n          </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
