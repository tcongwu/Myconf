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

public class _subsubject__jsp extends com.caucho.jsp.JavaPage{
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
      
List subjects=SubjectDAO.list();
SubjectBean subject=null;

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
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/admin/subins.jsp");
      int _jspEval9 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("menu.sub.top.ins");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("menu.sub.top.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag2.setPage("/admin/subformat.jsp");
      int _jspEval19 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar20 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar20 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("menu.sub.top.format");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setPage("/admin/subsize.jsp");
      int _jspEval26 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar27 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar27 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("menu.sub.top.size");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setPage("/admin/subdate.jsp");
      int _jspEval33 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar34 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar34 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("menu.sub.top.subdate");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setPage("/admin/subcondate.jsp");
      int _jspEval40 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar41 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar41 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("menu.sub.top.confirmdate");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.button.modify");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag3.setKey("common.button.add");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag3.setKey("error.suject.not.null");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag1.setKey("page.subsubject.ins1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag1.setKey("page.subsubject.ins2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      _jsp_tag1.setKey("page.subsubject.ins3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag1.setKey("page.subsubject.ins4");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      _jsp_tag2.setPage("/subject.do");
      int _jspEval68 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar69 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar69 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      _jsp_tag1.setKey("page.subsubject.title.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      _jsp_tag3.setKey("common.button.add");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      _jsp_tag2.setPage("/admin/subformat.jsp");
      int _jspEval78 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar79 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar79 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      _jsp_tag3.setKey("common.button.next.setting");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      _jsp_tag3.setKey("common.button.back.add");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      _jsp_tag3.setKey("common.text.subject");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      _jsp_tag3.setKey("common.text.modify");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      _jsp_tag3.setKey("common.text.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      
				  if(subjects!=null && subjects.size()>0){
				  	for(int i=0;i<subjects.size();i++){
				  	  subject=(SubjectBean)subjects.get(i);
				
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      out.print((StringUtils.exportString(subject.getSubject())));
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      out.print((subject.getId()));
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      out.print((subject.getId()));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      out.print((StringUtils.exportString(subject.getSubject())));
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.modify");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      out.print((subject.getId()));
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/images/sub_edit.gif");
      int _jspEval100 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar101 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar101 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      _jsp_tag3.setKey("common.text.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      _jsp_tag3.setKey("ins.confirm.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      _jsp_tag2.setPage("/subject.do?eventSubmit_Delete&id=");
      int _jspEval110 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar111 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar111 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((subject.getId()));
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      _jsp_tag2.setPage("/images/sub_del.gif");
      int _jspEval114 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar115 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar115 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      }}
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_subsubject__jsp.java", "/conf1/admin/subsubject.jsp");
    _caucho_line_map.add(18, 1);
    _caucho_line_map.add(1, 35);
    _caucho_line_map.add(6, 41);
    _caucho_line_map.add(7, 51);
    _caucho_line_map.add(8, 55);
    _caucho_line_map.add(13, 61);
    _caucho_line_map.add(26, 75);
    _caucho_line_map.add(32, 80);
    _caucho_line_map.add(37, 86);
    _caucho_line_map.add(40, 88);
    _caucho_line_map.add(45, 94);
    _caucho_line_map.add(46, 96);
    _caucho_line_map.add(47, 98);
    _caucho_line_map.add(52, 104);
    _caucho_line_map.add(58, 106);
    _caucho_line_map.add(59, 108);
    _caucho_line_map.add(66, 110);
    _caucho_line_map.add(69, 120);
    _caucho_line_map.add(69, 132);
    _caucho_line_map.add(70, 135);
    _caucho_line_map.add(71, 138);
    _caucho_line_map.add(71, 144);
    _caucho_line_map.add(72, 147);
    _caucho_line_map.add(72, 153);
    _caucho_line_map.add(73, 156);
    _caucho_line_map.add(73, 162);
    _caucho_line_map.add(74, 165);
    _caucho_line_map.add(74, 171);
    _caucho_line_map.add(82, 174);
    _caucho_line_map.add(86, 183);
    _caucho_line_map.add(94, 186);
    _caucho_line_map.add(106, 189);
    _caucho_line_map.add(107, 192);
    _caucho_line_map.add(108, 195);
    _caucho_line_map.add(109, 198);
    _caucho_line_map.add(113, 201);
    _caucho_line_map.add(118, 207);
    _caucho_line_map.add(124, 210);
    _caucho_line_map.add(126, 213);
    _caucho_line_map.add(126, 219);
    _caucho_line_map.add(127, 222);
    _caucho_line_map.add(144, 225);
    _caucho_line_map.add(145, 228);
    _caucho_line_map.add(146, 231);
    _caucho_line_map.add(148, 234);
    _caucho_line_map.add(155, 242);
    _caucho_line_map.add(155, 244);
    _caucho_line_map.add(155, 246);
    _caucho_line_map.add(156, 248);
    _caucho_line_map.add(156, 257);
    _caucho_line_map.add(156, 259);
    _caucho_line_map.add(157, 271);
    _caucho_line_map.add(157, 274);
    _caucho_line_map.add(157, 277);
    _caucho_line_map.add(157, 282);
    _caucho_line_map.add(157, 284);
    _caucho_line_map.add(159, 290);
    _caucho_line_map.add(166, 292);
    _caucho_line_map.add(171, 298);
    _caucho_line_map.add(176, 304);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/subsubject.jsp"), 1182181138000L, 7861L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string34;
  private static byte []_jsp_string17;
  private static byte []_jsp_string7;
  private static byte []_jsp_string8;
  private static byte []_jsp_string37;
  private static byte []_jsp_string30;
  private static byte []_jsp_string1;
  private static byte []_jsp_string15;
  private static byte []_jsp_string35;
  private static byte []_jsp_string32;
  private static byte []_jsp_string20;
  private static byte []_jsp_string39;
  private static byte []_jsp_string18;
  private static byte []_jsp_string0;
  private static byte []_jsp_string33;
  private static byte []_jsp_string27;
  private static byte []_jsp_string4;
  private static byte []_jsp_string13;
  private static byte []_jsp_string25;
  private static byte []_jsp_string2;
  private static byte []_jsp_string29;
  private static byte []_jsp_string10;
  private static byte []_jsp_string21;
  private static byte []_jsp_string22;
  private static byte []_jsp_string31;
  private static byte []_jsp_string11;
  private static byte []_jsp_string14;
  private static byte []_jsp_string38;
  private static byte []_jsp_string3;
  private static byte []_jsp_string12;
  private static byte []_jsp_string16;
  private static byte []_jsp_string24;
  private static byte []_jsp_string26;
  private static byte []_jsp_string28;
  private static byte []_jsp_string36;
  private static byte []_jsp_string9;
  private static byte []_jsp_string23;
  private static byte []_jsp_string19;
  private static byte []_jsp_string5;
  private static byte []_jsp_string6;
  static {
    try {
      _jsp_string34 = "\" onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string17 = "</li>\r\n        		<div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string7 = "\" class=\"pagemenu\">".getBytes("UTF8");
      _jsp_string8 = "</a>\r\n            > <span class=\"pagemenu_visited\">".getBytes("UTF8");
      _jsp_string37 = "\" width=\"21\" height=\"21\" border=\"0\"></a></td>\r\n				</tr>\r\n				".getBytes("UTF8");
      _jsp_string30 = "\"/></td>\r\n                  <td align=\"center\" class=\"table_cell\"><a title=\"".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string15 = "</li>\r\n                  <li>".getBytes("UTF8");
      _jsp_string35 = "')\" href=\"".getBytes("UTF8");
      _jsp_string32 = ")\"><img src=\"".getBytes("UTF8");
      _jsp_string20 = "\">\r\n                  </td>\r\n                  <td width=\"92%\" nowrap class=\"form_row_submit\"><input name=\"next\" type=\"button\" onClick=\"window.location='".getBytes("UTF8");
      _jsp_string39 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string18 = "\" method=\"post\" onSubmit=\"return checkForm()\" name=\"addsub\" id=\"addsub\">\r\n              <input name=\"id\" type=\"hidden\" id=\"id\" value=\"0\">\r\n              <input name=\"eventSubmit_AddOrModify\" type=\"hidden\" id=\"eventSubmit_AddOrModify\" value=\"0\">\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string33 = "\" width=\"21\" height=\"21\" border=\"0\"></a></td>\r\n                  <td align=\"center\" class=\"table_cell\"><a title=\"".getBytes("UTF8");
      _jsp_string27 = "\r\n					<input name=\"sub".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string13 = "\";\r\n				hideLayer(\"back\");\r\n				showLayer(\"next\");\r\n			}\r\n		}\r\n		function checkForm()\r\n		{\r\n			if (trim(addsub.subject.value).length == 0) {\r\n				alert(\"".getBytes("UTF8");
      _jsp_string25 = "</td>\r\n				</tr>\r\n				".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string29 = "\" value=\"".getBytes("UTF8");
      _jsp_string10 = "</a> \r\n            > <a href=\"".getBytes("UTF8");
      _jsp_string21 = "'\" class=\"button\" id=\"next4\" value=\"".getBytes("UTF8");
      _jsp_string22 = "\"> \r\n                    <input name=\"back\" type=\"button\" onClick=\"modSubject(0)\" class=\"button\" style=\"display:none\" id=\"back2\" value=\"".getBytes("UTF8");
      _jsp_string31 = "\" href=\"javascript:modSubject(".getBytes("UTF8");
      _jsp_string11 = "</a></td>\r\n        </tr>\r\n      </table>\r\n	  <script language=\"JavaScript\">\r\n		function modSubject(id){\r\n			addsub.id.value=id;\r\n			eval(\"addsub.subject.value=sub\"+id+\".value\");\r\n			if(id>0){\r\n				addsub.addbt.value=\"".getBytes("UTF8");
      _jsp_string14 = "\");\r\n				addsub.subject.focus();\r\n				return false;\r\n			}\r\n			return true;\r\n		}\r\n	  </script>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string38 = "\r\n			</table></td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string12 = "\";\r\n				hideLayer(\"next\");\r\n				showLayer(\"back\");\r\n			}else{\r\n				addsub.addbt.value=\"".getBytes("UTF8");
      _jsp_string16 = "</li>\r\n				  <li>".getBytes("UTF8");
      _jsp_string24 = "</td>\r\n				  <td width=\"6%\" align=\"center\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string26 = "\r\n				<tr>\r\n				  <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string28 = "\" type=\"hidden\" id=\"sub".getBytes("UTF8");
      _jsp_string36 = "\"><img src=\"".getBytes("UTF8");
      _jsp_string9 = "</span> \r\n            > <a href=\"".getBytes("UTF8");
      _jsp_string23 = "\"> \r\n                  </td>\r\n                </tr>\r\n              </table>\r\n            </form>\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n              <tr>\r\n                <td width=\"52%\">\r\n					<div class=\"spacer_20\"></div>\r\n					<div class=\"line_dashed\"></div>\r\n					<div class=\"spacer_10\"></div>\r\n				</td>\r\n              </tr>\r\n            </table>\r\n			<input name=\"sub0\" type=\"hidden\" id=\"sub0\" value=\"\"/>\r\n			<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n				<tr> \r\n				  <td width=\"88%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string19 = "</td>\r\n                  <td class=\"form_row_content\"><input name=\"subject\" type=\"text\" id=\"subject\" size=\"68\"></td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"8%\" nowrap class=\"form_row_submit\"><input name=\"addbt\" type=\"submit\" class=\"button\" id=\"addbt\" value=\"".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr>\r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string6 = "</b></td>\r\n        </tr>\r\n        <tr>\r\n          <td align=\"right\" class=\"pagecontent_right\"><a href=\"".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
