/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _admin;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.*;
import org.myconf.dao.*;
import org.myconf.beans.*;
import org.myconf.util.*;
import java.util.*;

public class _paperassign__jsp extends com.caucho.jsp.JavaPage{
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
    org.apache.struts.taglib.bean.MessageTag _jsp_tag4 = null;
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
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//paper data
PaperBean paper=PaperDAO.getPaper(RequestUtils.getParam(request, "id", 0));
if(paper==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
//paper authors
List authors=paper.getAuthors();
if(authors==null || authors.size()==0){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

//paper review experts
HashMap rexp=paper.getExpertMap();

//quit experts
String qex=paper.getQuitExpertNameList();

//expert list
List experts=UserDAO.listExperts();

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
      pageContext.include("/inc/logo_admin.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//content
//*********************************

      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("page.paperassign.title");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setPage("/paper.do");
      }

      int _jspEval9 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      _jsp_tag1.setKey("page.paperassign.ins1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("page.paperassign.ins2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("page.paperassign.ins3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("page.paperassign.title.title");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((paper.getTitle()));
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      
          AuthorBean author=null;
		  for(int i=0;i<authors.size();i++){
		  	author=(AuthorBean)authors.get(i);
        
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag3.setBundle("admin");
        _jsp_tag3.setKey("page.paperassign.title.author");
      }

      _jsp_tag3.setArg0(String.valueOf(author.getOrderNo()));
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      out.print((author.toString()));
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      }
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("page.paper.title.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((paper.getSubject().getSubject()));
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag1.setKey("page.paperassign.title.abstract");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((paper.getAbstr()));
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag1.setKey("page.paperassign.title.bid");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((paper.getBidNameList()));
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      if(StringUtils.isNotEmpty(qex)){
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.text.quitexpert");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((qex));
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      }
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("page.paperassign.title.expert");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      if(experts!=null && experts.size()>0){
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      if (_jsp_tag4 == null) {
        _jsp_tag4 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag4.setPageContext(pageContext);
        _jsp_tag4.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag4.setKey("common.text.choice");
      _jsp_tag4.doStartTag();
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.text.expertname");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      _jsp_tag1.setKey("common.text.worklocation");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      _jsp_tag1.setKey("common.text.research");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      _jsp_tag1.setKey("common.text.email");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      _jsp_tag1.setKey("common.text.papernum");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      
          	UserBean expert=null;
          	for(int i=0;i<experts.size();i++){
          	  expert=(UserBean)experts.get(i);
          
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      out.print((expert.getId()));
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      if(rexp!=null && rexp.get(new Integer(expert.getId()))!=null){out.print(" checked");}
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      out.print((expert.getName().toString()));
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      out.print((expert.getId()));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      out.print((expert.getId()));
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      out.print((expert.getName().toString()));
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      out.print((StringUtils.exportString(expert.getWorkLocation())));
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      out.print((StringUtils.exportString(expert.getResearch())));
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      out.print((expert.getEmail()));
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      out.print((expert.getReviews().size()));
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      }
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      }
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      if (_jsp_tag4 == null) {
        _jsp_tag4 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag4.setPageContext(pageContext);
        _jsp_tag4.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag4.setKey("common.button.ok");
      _jsp_tag4.doStartTag();
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      _jsp_tag4.setKey("common.button.back");
      _jsp_tag4.doStartTag();
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
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
      if (_jsp_tag4 != null)
        _jsp_tag4.release();
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
    _caucho_line_map = new com.caucho.java.LineMap("_paperassign__jsp.java", "/conf1/admin/paperassign.jsp");
    _caucho_line_map.add(19, 1);
    _caucho_line_map.add(1, 37);
    _caucho_line_map.add(6, 43);
    _caucho_line_map.add(7, 53);
    _caucho_line_map.add(8, 57);
    _caucho_line_map.add(13, 63);
    _caucho_line_map.add(27, 78);
    _caucho_line_map.add(50, 100);
    _caucho_line_map.add(55, 106);
    _caucho_line_map.add(58, 108);
    _caucho_line_map.add(63, 114);
    _caucho_line_map.add(64, 116);
    _caucho_line_map.add(72, 122);
    _caucho_line_map.add(104, 132);
    _caucho_line_map.add(106, 144);
    _caucho_line_map.add(112, 146);
    _caucho_line_map.add(113, 149);
    _caucho_line_map.add(114, 152);
    _caucho_line_map.add(122, 155);
    _caucho_line_map.add(123, 158);
    _caucho_line_map.add(126, 160);
    _caucho_line_map.add(133, 166);
    _caucho_line_map.add(134, 177);
    _caucho_line_map.add(137, 179);
    _caucho_line_map.add(140, 181);
    _caucho_line_map.add(141, 191);
    _caucho_line_map.add(146, 193);
    _caucho_line_map.add(147, 196);
    _caucho_line_map.add(152, 198);
    _caucho_line_map.add(153, 201);
    _caucho_line_map.add(156, 203);
    _caucho_line_map.add(159, 205);
    _caucho_line_map.add(160, 215);
    _caucho_line_map.add(163, 217);
    _caucho_line_map.add(166, 219);
    _caucho_line_map.add(177, 229);
    _caucho_line_map.add(180, 231);
    _caucho_line_map.add(181, 240);
    _caucho_line_map.add(182, 250);
    _caucho_line_map.add(183, 253);
    _caucho_line_map.add(184, 256);
    _caucho_line_map.add(185, 259);
    _caucho_line_map.add(187, 262);
    _caucho_line_map.add(193, 270);
    _caucho_line_map.add(194, 272);
    _caucho_line_map.add(195, 274);
    _caucho_line_map.add(195, 276);
    _caucho_line_map.add(195, 278);
    _caucho_line_map.add(198, 282);
    _caucho_line_map.add(199, 284);
    _caucho_line_map.add(200, 286);
    _caucho_line_map.add(207, 292);
    _caucho_line_map.add(208, 301);
    _caucho_line_map.add(215, 304);
    _caucho_line_map.add(220, 310);
    _caucho_line_map.add(225, 316);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/paperassign.jsp"), 1184592544234L, 9646L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string13;
  private static byte []_jsp_string32;
  private static byte []_jsp_string2;
  private static byte []_jsp_string1;
  private static byte []_jsp_string16;
  private static byte []_jsp_string11;
  private static byte []_jsp_string38;
  private static byte []_jsp_string6;
  private static byte []_jsp_string17;
  private static byte []_jsp_string0;
  private static byte []_jsp_string36;
  private static byte []_jsp_string26;
  private static byte []_jsp_string18;
  private static byte []_jsp_string19;
  private static byte []_jsp_string3;
  private static byte []_jsp_string22;
  private static byte []_jsp_string24;
  private static byte []_jsp_string30;
  private static byte []_jsp_string27;
  private static byte []_jsp_string9;
  private static byte []_jsp_string37;
  private static byte []_jsp_string35;
  private static byte []_jsp_string7;
  private static byte []_jsp_string4;
  private static byte []_jsp_string15;
  private static byte []_jsp_string28;
  private static byte []_jsp_string29;
  private static byte []_jsp_string33;
  private static byte []_jsp_string34;
  private static byte []_jsp_string5;
  private static byte []_jsp_string23;
  private static byte []_jsp_string8;
  private static byte []_jsp_string25;
  private static byte []_jsp_string31;
  private static byte []_jsp_string10;
  private static byte []_jsp_string14;
  private static byte []_jsp_string20;
  private static byte []_jsp_string12;
  private static byte []_jsp_string21;
  static {
    try {
      _jsp_string13 = "</td>\r\n          </tr>\r\n        </table>\r\n        <table id=\"confirm\" width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n          <tr> \r\n            <td width=\"18%\" valign=\"top\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string32 = "</td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body onLoad=\"listExpert()\">\r\n".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string16 = "</td>\r\n            <td class=\"form_row_content_abstract\">".getBytes("UTF8");
      _jsp_string11 = "\r\n        <table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n          <tr> \r\n            <td width=\"18%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string38 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string6 = "\">\r\n        <br>\r\n        <table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n          <tr>\r\n            <td><table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n                <tr> \r\n                  <td> <li>".getBytes("UTF8");
      _jsp_string17 = "</td>\r\n            <td class=\"form_row_content_title\" id=\"expertList\"></td>\r\n          </tr>\r\n        </table>\r\n        <table width=\"90%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"line_solid\">\r\n          <tr> \r\n            <td width=\"52%\"> <div class=\"spacer_20\"></div>\r\n              <div class=\"line_dashed\"></div>\r\n              <div class=\"spacer_10\"></div></td>\r\n          </tr>\r\n        </table>\r\n        ".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string36 = "\" class=\"button\"> \r\n              <input name=\"Button\" type=\"button\" onClick=\"window.close()\" class=\"button\" value=\"".getBytes("UTF8");
      _jsp_string26 = "\"".getBytes("UTF8");
      _jsp_string18 = "\r\n        <table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n          <tr> \r\n            <td width=\"5%\" align=\"center\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string19 = "</td>\r\n            <td width=\"14%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" height=\"31\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr> \r\n    <td width=\"10\" class=\"channel_bar_left\">&nbsp;</td>\r\n    <td width=\"448\" class=\"channel_bar_bg\"><span class=\"bartitle\">&nbsp;".getBytes("UTF8");
      _jsp_string22 = "</td>\r\n            <td width=\"22%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string24 = "</td>\r\n          </tr>\r\n          ".getBytes("UTF8");
      _jsp_string30 = "\" value=\"".getBytes("UTF8");
      _jsp_string27 = "></td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string9 = "</td>\r\n            <td class=\"form_row_content_title\">".getBytes("UTF8");
      _jsp_string37 = "\"> \r\n          </tr>\r\n        </table>\r\n        <br>\r\n      </form></td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string35 = "\r\n        <table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n          <tr> \r\n            <td class=\"form_row_submit\"><input type=\"submit\" id=\"sb\" name=\"save\" value=\"".getBytes("UTF8");
      _jsp_string7 = "</li>\r\n                    <li>".getBytes("UTF8");
      _jsp_string4 = "</span></td>\r\n    <td width=\"310\" style=\"PADDING-TOP: 2px;\" align=\"right\" class=\"channel_bar_bg\">&nbsp; \r\n      </td>\r\n    <td width=\"10\" class=\"channel_bar_right\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<script language=\"JavaScript\">\r\nfunction listExpert(){\r\n	var nameList=\"\";\r\n	if(assign.expertId==null){\r\n		return;\r\n	}\r\n	if(assign.expertId.length==null){\r\n		if(assign.expertId.checked){\r\n			eval(\"nameList=assign.expertName\"+i+\"value\");\r\n		}\r\n	}else{\r\n		for(var i=0;i<assign.expertId.length;i++){\r\n			if(assign.expertId[i].checked){\r\n				if(nameList==\"\"){\r\n					eval(\"nameList=assign.expertName\"+assign.expertId[i].value+\".value\");\r\n				}else{\r\n					eval(\"nameList=nameList+', '+assign.expertName\"+assign.expertId[i].value+\".value\");\r\n				}\r\n			}\r\n		}\r\n	}\r\n	expertList.innerText=nameList;\r\n}\r\n</script>\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr> \r\n    <td valign=\"top\" class=\"pagecontent\"><form action=\"".getBytes("UTF8");
      _jsp_string15 = "</pre></td>\r\n          </tr>\r\n        </table>\r\n        <table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n          <tr> \r\n            <td width=\"18%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string28 = " \r\n              <input name=\"expertName".getBytes("UTF8");
      _jsp_string29 = "\" type=\"hidden\" id=\"expertName".getBytes("UTF8");
      _jsp_string33 = "</td>\r\n            <td align=\"center\" class=\"table_cell\">".getBytes("UTF8");
      _jsp_string34 = "\r\n       </table>\r\n        ".getBytes("UTF8");
      _jsp_string5 = "\" method=\"post\" name=\"assign\" id=\"assign\">\r\n        <input name=\"eventSubmit_Assign\" type=\"hidden\" id=\"eventSubmit_Assign\" value=\"1\">\r\n        <input name=\"id\" type=\"hidden\" id=\"id\" value=\"".getBytes("UTF8");
      _jsp_string23 = "</td>\r\n            <td width=\"7%\" align=\"center\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string8 = "</li>\r\n                  </td>\r\n                </tr>\r\n              </table></td>\r\n          </tr>\r\n        </table>\r\n        <table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n          <tr> \r\n            <td width=\"18%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string25 = "\r\n          <tr> \r\n            <td align=\"center\" class=\"table_cell\"><input name=\"expertId\" type=\"checkbox\" id=\"expertId\" onClick=\"listExpert()\" value=\"".getBytes("UTF8");
      _jsp_string31 = "\"/>\r\n            </td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string10 = "</td>\r\n          </tr>\r\n        </table>\r\n        ".getBytes("UTF8");
      _jsp_string14 = "</td>\r\n            <td class=\"form_row_content_abstract\"><font color=\"#000000\"><pre>".getBytes("UTF8");
      _jsp_string20 = "</td>\r\n            <td width=\"22%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string12 = "</td>\r\n            <td class=\"form_row_content_author\">".getBytes("UTF8");
      _jsp_string21 = "</td>\r\n            <td width=\"30%\" nowrap class=\"table_head\">".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
