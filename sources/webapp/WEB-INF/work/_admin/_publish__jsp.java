/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _admin;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.dao.*;
import org.myconf.beans.*;

public class _publish__jsp extends com.caucho.jsp.JavaPage{
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

      _jsp_tag1.setKey("menu.left.publish");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      _jsp_tag1.setKey("page.publish.ins1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setPage("/config.do");
      }

      int _jspEval12 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar13 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar13 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("page.publish.title.pub");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("page.publish.ins2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      out.print((ConfigBean.TRUE));
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      out.print((ConfigBean.FALSE));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      out.print((conf.getIsOpen()));
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      if(conf.getIsOpen()==ConfigBean.TRUE){out.print("checked");}
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("page.publish.checkbox.pub");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag1.setKey("page.publish.title.pro");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((ConfigBean.TRUE));
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      out.print((ConfigBean.FALSE));
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((conf.getIsProcess()));
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      if(conf.getIsProcess()==ConfigBean.TRUE){out.print("checked");}
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("page.publish.checkbox.pro");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if(!PaperDAO.isFinish()){
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("error.not.finished.review");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      }
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("ins.confirm.publish");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      _jsp_tag3.setKey("common.button.ok");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_publish__jsp.java", "/conf1/admin/publish.jsp");
    _caucho_line_map.add(16, 1);
    _caucho_line_map.add(1, 33);
    _caucho_line_map.add(6, 39);
    _caucho_line_map.add(7, 49);
    _caucho_line_map.add(8, 53);
    _caucho_line_map.add(13, 59);
    _caucho_line_map.add(24, 71);
    _caucho_line_map.add(29, 75);
    _caucho_line_map.add(34, 81);
    _caucho_line_map.add(37, 83);
    _caucho_line_map.add(42, 89);
    _caucho_line_map.add(43, 91);
    _caucho_line_map.add(44, 93);
    _caucho_line_map.add(49, 99);
    _caucho_line_map.add(55, 101);
    _caucho_line_map.add(56, 103);
    _caucho_line_map.add(63, 105);
    _caucho_line_map.add(74, 115);
    _caucho_line_map.add(78, 118);
    _caucho_line_map.add(83, 130);
    _caucho_line_map.add(84, 133);
    _caucho_line_map.add(90, 136);
    _caucho_line_map.add(101, 140);
    _caucho_line_map.add(102, 142);
    _caucho_line_map.add(103, 144);
    _caucho_line_map.add(110, 154);
    _caucho_line_map.add(117, 157);
    _caucho_line_map.add(126, 161);
    _caucho_line_map.add(127, 163);
    _caucho_line_map.add(128, 165);
    _caucho_line_map.add(134, 175);
    _caucho_line_map.add(134, 176);
    _caucho_line_map.add(134, 185);
    _caucho_line_map.add(134, 186);
    _caucho_line_map.add(134, 195);
    _caucho_line_map.add(145, 198);
    _caucho_line_map.add(150, 204);
    _caucho_line_map.add(155, 210);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/publish.jsp"), 1184428592859L, 6117L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string20;
  private static byte []_jsp_string11;
  private static byte []_jsp_string23;
  private static byte []_jsp_string8;
  private static byte []_jsp_string9;
  private static byte []_jsp_string1;
  private static byte []_jsp_string3;
  private static byte []_jsp_string12;
  private static byte []_jsp_string15;
  private static byte []_jsp_string16;
  private static byte []_jsp_string24;
  private static byte []_jsp_string17;
  private static byte []_jsp_string14;
  private static byte []_jsp_string0;
  private static byte []_jsp_string13;
  private static byte []_jsp_string21;
  private static byte []_jsp_string7;
  private static byte []_jsp_string10;
  private static byte []_jsp_string4;
  private static byte []_jsp_string22;
  private static byte []_jsp_string2;
  private static byte []_jsp_string6;
  private static byte []_jsp_string18;
  private static byte []_jsp_string19;
  private static byte []_jsp_string5;
  static {
    try {
      _jsp_string20 = " \r\n                    <div class=\"spacer_5\"></div></td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td class=\"form_row_submit\"><input name=\"sub\" onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string11 = ";\r\n					}else{\r\n						pub.isOpen.value=".getBytes("UTF8");
      _jsp_string23 = "\">\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n            </form>\r\n		</td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string8 = "\" method=\"post\" name=\"pub\" id=\"pub\">\r\n              <input name=\"eventSubmit_Save\" type=\"hidden\" id=\"eventSubmit_Save\" value=\"0\">\r\n              <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/admin/publish.jsp\">\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"25%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string9 = "</td>\r\n                  <td class=\"form_row_content\">&nbsp;&nbsp;{".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string12 = ";\r\n					}\r\n				}\r\n			  </script>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td class=\"form_row_content\">\r\n				  	<div class=\"spacer_5\"></div>\r\n                      \r\n                    <input name=\"isOpen\" type=\"hidden\" id=\"isOpen\" value=\"".getBytes("UTF8");
      _jsp_string15 = " \r\n                    <div class=\"spacer_5\"></div>\r\n					</td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td width=\"25%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string16 = "</td>\r\n                  <td class=\"form_row_content\">&nbsp;</td>\r\n                </tr>\r\n              </table>\r\n		      <script language=\"JavaScript\">\r\n				function checkProcess(obj){\r\n					if(obj.checked){\r\n						pub.isProcess.value=".getBytes("UTF8");
      _jsp_string24 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string17 = ";\r\n					}else{\r\n						pub.isProcess.value=".getBytes("UTF8");
      _jsp_string14 = ">\r\n                    ".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string13 = "\">\r\n                    <input name=\"chkOpen\" type=\"checkbox\" onClick=\"checkOpen(this)\" id=\"chkOpen\" value=\"1\"".getBytes("UTF8");
      _jsp_string21 = "\\n\\n".getBytes("UTF8");
      _jsp_string7 = "</li>\r\n				  <div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string10 = "}</td>\r\n                </tr>\r\n              </table>\r\n		      <script language=\"JavaScript\">\r\n				function checkOpen(obj){\r\n					if(obj.checked){\r\n						pub.isOpen.value=".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string22 = "')\" type=\"submit\" class=\"button\" id=\"sub\" value=\"".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string6 = "</b></td>\r\n        </tr>\r\n        <tr>\r\n          <td height=\"15\" align=\"right\"></td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li class=\"redins\">".getBytes("UTF8");
      _jsp_string18 = ";\r\n					}\r\n				}\r\n			  </script>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td class=\"form_row_content\"> <div class=\"spacer_5\"></div>\r\n                    <input name=\"isProcess\" type=\"hidden\" id=\"isProcess\" value=\"".getBytes("UTF8");
      _jsp_string19 = "\">\r\n                    <input name=\"chkProcess\" type=\"checkbox\" onClick=\"checkProcess(this)\" id=\"chkProcess\" value=\"1\"".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr>\r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}