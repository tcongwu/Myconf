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

public class _downloadpack__jsp extends com.caucho.jsp.JavaPage{
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
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//paper statistics data
int[] stats=PaperDAO.statPaper();

List subjects=SubjectDAO.list();
List statuses=StatusDAO.list();

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

      _jsp_tag1.setKey("menu.left.download");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/admin/download.jsp");
      int _jspEval9 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("menu.download.single");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((stats[0]));
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("menu.download.pack");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.downloadpack.ins1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag2.setPage("/paper.do");
      int _jspEval22 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar23 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar23 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag1.setKey("page.paper.title.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.list.please.select");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      
	                  	SubjectBean subject=null;
	                  	if((subjects!=null)&&(subjects.size()>0)){
	                  		for(int i=0;i<subjects.size();i++){
	                  			subject=(SubjectBean)subjects.get(i);
	                  
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      out.print((subject.getId()));
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((StringUtils.exportString(subject.getSubject())));
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      }}
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.title.accept.status");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.list.please.select");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      
	                  	StatusBean status=null;
	                  	if((statuses!=null)&&(statuses.size()>0)){
	                  		for(int i=0;i<statuses.size();i++){
	                  			status=(StatusBean)statuses.get(i);
	                  
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      out.print((status.getId()));
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((StringUtils.exportString(status.getStatus())));
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      }}
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.button.pack.paper");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_downloadpack__jsp.java", "/conf1/admin/downloadpack.jsp");
    _caucho_line_map.add(18, 1);
    _caucho_line_map.add(1, 35);
    _caucho_line_map.add(6, 41);
    _caucho_line_map.add(7, 51);
    _caucho_line_map.add(8, 55);
    _caucho_line_map.add(13, 61);
    _caucho_line_map.add(26, 75);
    _caucho_line_map.add(35, 83);
    _caucho_line_map.add(40, 89);
    _caucho_line_map.add(43, 91);
    _caucho_line_map.add(48, 97);
    _caucho_line_map.add(49, 99);
    _caucho_line_map.add(50, 101);
    _caucho_line_map.add(55, 107);
    _caucho_line_map.add(61, 109);
    _caucho_line_map.add(62, 111);
    _caucho_line_map.add(69, 113);
    _caucho_line_map.add(73, 123);
    _caucho_line_map.add(73, 135);
    _caucho_line_map.add(73, 138);
    _caucho_line_map.add(74, 140);
    _caucho_line_map.add(82, 143);
    _caucho_line_map.add(86, 146);
    _caucho_line_map.add(90, 152);
    _caucho_line_map.add(92, 155);
    _caucho_line_map.add(93, 164);
    _caucho_line_map.add(99, 171);
    _caucho_line_map.add(99, 173);
    _caucho_line_map.add(100, 175);
    _caucho_line_map.add(106, 177);
    _caucho_line_map.add(108, 187);
    _caucho_line_map.add(109, 196);
    _caucho_line_map.add(115, 203);
    _caucho_line_map.add(115, 205);
    _caucho_line_map.add(116, 207);
    _caucho_line_map.add(123, 209);
    _caucho_line_map.add(134, 218);
    _caucho_line_map.add(139, 224);
    _caucho_line_map.add(144, 230);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/downloadpack.jsp"), 1184595835125L, 5596L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string6;
  private static byte []_jsp_string7;
  private static byte []_jsp_string1;
  private static byte []_jsp_string3;
  private static byte []_jsp_string19;
  private static byte []_jsp_string17;
  private static byte []_jsp_string21;
  private static byte []_jsp_string18;
  private static byte []_jsp_string16;
  private static byte []_jsp_string0;
  private static byte []_jsp_string20;
  private static byte []_jsp_string8;
  private static byte []_jsp_string11;
  private static byte []_jsp_string4;
  private static byte []_jsp_string10;
  private static byte []_jsp_string5;
  private static byte []_jsp_string9;
  private static byte []_jsp_string14;
  private static byte []_jsp_string2;
  private static byte []_jsp_string13;
  private static byte []_jsp_string12;
  private static byte []_jsp_string15;
  static {
    try {
      _jsp_string6 = "</b></td>\r\n        </tr>\r\n        <tr> \r\n          <td align=\"right\" class=\"pagecontent_right\">\r\n          	<a href=\"".getBytes("UTF8");
      _jsp_string7 = "\" class=\"pagemenu\">".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string19 = "\r\n                    </select>\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td nowrap class=\"form_row_submit\"><input name=\"sub\" type=\"submit\" class=\"button\" id=\"sub\" value=\"".getBytes("UTF8");
      _jsp_string17 = "\r\n                    </select></td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"21%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string21 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string18 = "</td>\r\n                  <td class=\"form_row_content\"><select name=\"status\" id=\"status\">\r\n                      <option selected>".getBytes("UTF8");
      _jsp_string16 = "\">".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string20 = "\">\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n            </form>\r\n          </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string8 = "(".getBytes("UTF8");
      _jsp_string11 = "</li>\r\n                  <div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string10 = "</span></td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr> \r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string9 = ")</a> \r\n            > <span class=\"pagemenu_visited\">".getBytes("UTF8");
      _jsp_string14 = "</option>\r\n	                  ".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string13 = "</td>\r\n                  <td class=\"form_row_content\"><select name=\"subject\" id=\"subject\">\r\n                      <option selected>".getBytes("UTF8");
      _jsp_string12 = "\" method=\"post\" name=\"download\" id=\"download\">\r\n              <input name=\"eventSubmit_Pack\" type=\"hidden\" id=\"eventSubmit_Pack\" value=\"1\">\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"21%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string15 = "\r\n	                  <option value=\"".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}