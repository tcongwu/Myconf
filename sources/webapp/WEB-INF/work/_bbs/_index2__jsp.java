/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _bbs;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.*;
import org.myconf.dao.*;
import org.myconf.beans.*;
import org.myconf.util.*;

public class _index2__jsp extends com.caucho.jsp.JavaPage{
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
      
//bbs data
Page pg=BBSDAO.getPageDiscuss(RequestUtils.getParam(request, "page", 0), Globals.PAGESIZE_20);
BBSBean bbs=null;

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
      }

      _jsp_tag1.setKey("common.title.bbs");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/bbs.do");
      int _jspEval9 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      if(pg!=null && pg.hasNext()){
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      out.print((pg.getCurPageRow()));
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      out.print((pg.getCurPage()));
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.text.choice");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("common.text.bbs.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("common.text.bbs.author");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("common.text.bbs.publish.time");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag1.setKey("common.text.bbs.visit.count");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag1.setKey("common.text.bbs.reply.count");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      
          int i=0;
	      while(pg.hasNext()){
	        bbs=(BBSBean)pg.next();
	    
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      out.print((i));
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((i));
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      out.print((bbs.getId()));
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      if(bbs.getIsTop()==BBSBean.TRUE){
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.text.bbs.top");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      }
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/bbs/view2.jsp?id=");
      int _jspEval34 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar35 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar35 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((bbs.getId()));
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      out.print((pg.getCurPage()));
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      out.print((bbs.getTitle()));
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      out.print((bbs.getAuthorName()));
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      out.print((StringUtils.exportDate(bbs.getCreateTime(), "yyyy-MM-dd HH:mm")));
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      out.print((bbs.getVisitCount()));
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      out.print((bbs.getReplyCount()));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      i++;}
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      out.print((pg.getDigitalPane(request, "/bbs/index2.jsp")));
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      }else{
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.text.norecord");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      }
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/bbs/begin2.jsp?page=");
      int _jspEval41 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar42 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar42 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((pg.getCurPage()));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.button.issue.talk");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      _jsp_tag1.setKey("common.button.back");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      _jsp_tag1.setKey("ins.confirm.top");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      _jsp_tag1.setKey("common.button.bbs.top");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      _jsp_tag1.setKey("ins.confirm.delete");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      _jsp_tag1.setKey("common.button.bbs.delete");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_index2__jsp.java", "/myconf/bbs/index2.jsp");
    _caucho_line_map.add(18, 1);
    _caucho_line_map.add(1, 34);
    _caucho_line_map.add(6, 40);
    _caucho_line_map.add(7, 50);
    _caucho_line_map.add(8, 54);
    _caucho_line_map.add(13, 60);
    _caucho_line_map.add(26, 74);
    _caucho_line_map.add(33, 80);
    _caucho_line_map.add(38, 86);
    _caucho_line_map.add(41, 88);
    _caucho_line_map.add(46, 94);
    _caucho_line_map.add(47, 96);
    _caucho_line_map.add(55, 102);
    _caucho_line_map.add(65, 111);
    _caucho_line_map.add(66, 123);
    _caucho_line_map.add(69, 127);
    _caucho_line_map.add(72, 129);
    _caucho_line_map.add(73, 138);
    _caucho_line_map.add(74, 141);
    _caucho_line_map.add(75, 144);
    _caucho_line_map.add(76, 147);
    _caucho_line_map.add(77, 150);
    _caucho_line_map.add(79, 153);
    _caucho_line_map.add(85, 161);
    _caucho_line_map.add(85, 163);
    _caucho_line_map.add(86, 165);
    _caucho_line_map.add(86, 167);
    _caucho_line_map.add(86, 176);
    _caucho_line_map.add(86, 178);
    _caucho_line_map.add(86, 189);
    _caucho_line_map.add(86, 191);
    _caucho_line_map.add(86, 193);
    _caucho_line_map.add(87, 195);
    _caucho_line_map.add(88, 197);
    _caucho_line_map.add(89, 199);
    _caucho_line_map.add(90, 201);
    _caucho_line_map.add(96, 205);
    _caucho_line_map.add(99, 207);
    _caucho_line_map.add(102, 209);
    _caucho_line_map.add(105, 218);
    _caucho_line_map.add(113, 220);
    _caucho_line_map.add(113, 231);
    _caucho_line_map.add(113, 233);
    _caucho_line_map.add(114, 242);
    _caucho_line_map.add(116, 245);
    _caucho_line_map.add(116, 248);
    _caucho_line_map.add(117, 251);
    _caucho_line_map.add(117, 254);
    _caucho_line_map.add(129, 257);
    _caucho_line_map.add(134, 263);
    _caucho_line_map.add(139, 269);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("bbs/index2.jsp"), 1179331124000L, 6113L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string7;
  private static byte []_jsp_string23;
  private static byte []_jsp_string25;
  private static byte []_jsp_string9;
  private static byte []_jsp_string17;
  private static byte []_jsp_string18;
  private static byte []_jsp_string33;
  private static byte []_jsp_string6;
  private static byte []_jsp_string19;
  private static byte []_jsp_string1;
  private static byte []_jsp_string32;
  private static byte []_jsp_string35;
  private static byte []_jsp_string4;
  private static byte []_jsp_string11;
  private static byte []_jsp_string0;
  private static byte []_jsp_string13;
  private static byte []_jsp_string20;
  private static byte []_jsp_string3;
  private static byte []_jsp_string27;
  private static byte []_jsp_string22;
  private static byte []_jsp_string30;
  private static byte []_jsp_string12;
  private static byte []_jsp_string10;
  private static byte []_jsp_string2;
  private static byte []_jsp_string15;
  private static byte []_jsp_string5;
  private static byte []_jsp_string31;
  private static byte []_jsp_string24;
  private static byte []_jsp_string16;
  private static byte []_jsp_string21;
  private static byte []_jsp_string28;
  private static byte []_jsp_string29;
  private static byte []_jsp_string26;
  private static byte []_jsp_string8;
  private static byte []_jsp_string14;
  private static byte []_jsp_string34;
  static {
    try {
      _jsp_string7 = "\">\r\n	  <input name=\"page\" type=\"hidden\" id=\"page\" value=\"".getBytes("UTF8");
      _jsp_string23 = "</td>\r\n          <td nowrap class=\"table_cell\">".getBytes("UTF8");
      _jsp_string25 = "\r\n      </table>\r\n      <table width=\"96%\" border=\"0\" align=\"center\" cellpadding=\"5\" cellspacing=\"0\" style=\"border-bottom:#cccccc 1px solid\">\r\n        <tr> \r\n          <td align=\"right\" nowrap>".getBytes("UTF8");
      _jsp_string9 = "</td>\r\n          <td width=\"49%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string17 = "<font color=red><strong>".getBytes("UTF8");
      _jsp_string18 = "</strong></font>".getBytes("UTF8");
      _jsp_string33 = "\">\r\n            <input name=\"eventSubmit_DeleteDiscuss\" type=\"submit\" id=\"eventSubmit_DeleteDiscuss\" onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string6 = "\r\n	  <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/bbs/index2.jsp\">\r\n	  <input name=\"rowcnt\" type=\"hidden\" id=\"rowcnt\" value=\"".getBytes("UTF8");
      _jsp_string19 = "<a class=\"blue\" href=\"".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string32 = "')\" value=\"".getBytes("UTF8");
      _jsp_string35 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string4 = "</span></td>\r\n    <td width=\"310\" style=\"PADDING-TOP: 2px;\" align=\"right\" class=\"channel_bar_bg\">&nbsp; \r\n      </td>\r\n    <td width=\"10\" class=\"channel_bar_right\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr> \r\n    <td valign=\"top\" class=\"pagecontent\">\r\n      <br>\r\n      <form action=\"".getBytes("UTF8");
      _jsp_string11 = "</td>\r\n          <td width=\"7%\" align=\"center\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string13 = "\r\n        <tr> \r\n          <td class=\"table_cell\"><input name=\"id".getBytes("UTF8");
      _jsp_string20 = "&page=".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" height=\"31\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr> \r\n    <td width=\"10\" class=\"channel_bar_left\">&nbsp;</td>\r\n    <td width=\"448\" class=\"channel_bar_bg\"><span class=\"bartitle\">&nbsp;".getBytes("UTF8");
      _jsp_string27 = "\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n        <tr> \r\n          <td align=\"center\" class=\"blackbold\" nowrap>".getBytes("UTF8");
      _jsp_string22 = "</a></td>\r\n          <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string30 = "\"> \r\n            &nbsp;<input name=\"back\" type=\"button\" class=\"button\" id=\"back\" onClick=\"window.close()\" value=\"".getBytes("UTF8");
      _jsp_string12 = "</td>\r\n        </tr>\r\n        ".getBytes("UTF8");
      _jsp_string10 = "</td>\r\n          <td width=\"16%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string15 = "\" value=\"".getBytes("UTF8");
      _jsp_string5 = "\" method=\"post\" name=\"bbs\" id=\"bbs\">\r\n      ".getBytes("UTF8");
      _jsp_string31 = "\">\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n            <input name=\"eventSubmit_TopDiscuss\" type=\"submit\" id=\"eventSubmit_TopDiscuss\" onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string24 = "</td>\r\n          <td align=\"center\" class=\"table_cell\">".getBytes("UTF8");
      _jsp_string16 = "\"></td>\r\n          <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string21 = "\">".getBytes("UTF8");
      _jsp_string28 = "\r\n      <table width=\"80%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr> \r\n          <td>&nbsp;</td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"96%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr> \r\n          <td> &nbsp; <input name=\"Button\" type=\"button\" class=\"button\" onClick=\"window.location='".getBytes("UTF8");
      _jsp_string29 = "'\" value=\"".getBytes("UTF8");
      _jsp_string26 = "</td>\r\n        </tr>\r\n      </table>\r\n      ".getBytes("UTF8");
      _jsp_string8 = "\">\r\n      <table width=\"96%\" border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n        <tr> \r\n          <td width=\"5%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string14 = "\" type=\"checkbox\" id=\"id".getBytes("UTF8");
      _jsp_string34 = "\"></td>\r\n        </tr>\r\n      </table>\r\n      </form>\r\n      <table width=\"80%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n        <tr> \r\n          <td>&nbsp;</td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
