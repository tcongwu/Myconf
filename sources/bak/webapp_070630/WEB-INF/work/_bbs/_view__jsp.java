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
import java.util.*;

public class _view__jsp extends com.caucho.jsp.JavaPage{
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
        _jsp_tag0.setModule("expert");
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
      
//bbs data
int id=RequestUtils.getParam(request, "id", 0);
List list=BBSDAO.getDiscuss(id);
if((list==null)||(list.size()==0)){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
String defaultTitle=null;
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
      pageContext.include("/inc/logo_expert.jsp");
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

      _jsp_tag1.setKey("error.staritem.not.null");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      _jsp_tag1.setKey("error.staritem.not.null");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      _jsp_tag1.setKey("common.title.bbs");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      
	  for(int i=0;i<list.size();i++){
		bbs=(BBSBean)list.get(i);
		if(i==0){
			defaultTitle="RE:"+bbs.getTitle();
		}
	
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/images/cloud.gif");
      int _jspEval15 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar16 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar16 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((bbs.getTitle()));
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      if(i==0){
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.text.bbs.master");
      _jsp_tag1.doStartTag();
      }else{
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag3.setKey("common.text.bbs.ceng");
      }

      _jsp_tag3.setArg0(String.valueOf(i));
      _jsp_tag3.doStartTag();
      }
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      out.print((bbs.getContent().replaceAll("\r","<br>")));
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if(i==0){
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.text.bbs.beginer");
      _jsp_tag1.doStartTag();
      }else{
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.text.bbs.replyer");
      _jsp_tag1.doStartTag();
      }
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      out.print((bbs.getAuthorName()));
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.bbs.title.issue.time");
      _jsp_tag1.doStartTag();
      out.print((StringUtils.exportDate(bbs.getCreateTime(), "yyyy-MM-dd HH:mm")));
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      }
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/bbs.do");
      int _jspEval34 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar35 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar35 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((id));
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      out.print((id));
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((StringUtils.exportString(request.getParameter("page"))));
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      _jsp_tag2.setPage("/images/orange_arrow.gif");
      int _jspEval38 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar39 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar39 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.text.bbs.reply");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      _jsp_tag1.setKey("common.bbs.title.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      out.print((defaultTitle));
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      _jsp_tag1.setKey("common.bbs.title.content");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      _jsp_tag1.setKey("common.text.bbs.reply");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      _jsp_tag2.setPage("/bbs/index.jsp?page=");
      int _jspEval54 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar55 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar55 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((StringUtils.exportString(request.getParameter("page"))));
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      _jsp_tag1.setKey("common.button.back");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_view__jsp.java", "/myconf/bbs/view.jsp");
    _caucho_line_map.add(19, 1);
    _caucho_line_map.add(1, 36);
    _caucho_line_map.add(6, 42);
    _caucho_line_map.add(7, 52);
    _caucho_line_map.add(8, 56);
    _caucho_line_map.add(13, 62);
    _caucho_line_map.add(27, 77);
    _caucho_line_map.add(39, 88);
    _caucho_line_map.add(44, 94);
    _caucho_line_map.add(47, 96);
    _caucho_line_map.add(52, 102);
    _caucho_line_map.add(53, 104);
    _caucho_line_map.add(62, 110);
    _caucho_line_map.add(67, 119);
    _caucho_line_map.add(77, 122);
    _caucho_line_map.add(87, 125);
    _caucho_line_map.add(101, 133);
    _caucho_line_map.add(102, 145);
    _caucho_line_map.add(103, 147);
    _caucho_line_map.add(103, 148);
    _caucho_line_map.add(103, 156);
    _caucho_line_map.add(103, 157);
    _caucho_line_map.add(103, 166);
    _caucho_line_map.add(110, 168);
    _caucho_line_map.add(118, 170);
    _caucho_line_map.add(118, 171);
    _caucho_line_map.add(118, 179);
    _caucho_line_map.add(118, 180);
    _caucho_line_map.add(118, 188);
    _caucho_line_map.add(118, 190);
    _caucho_line_map.add(119, 192);
    _caucho_line_map.add(119, 200);
    _caucho_line_map.add(126, 202);
    _caucho_line_map.add(130, 204);
    _caucho_line_map.add(131, 216);
    _caucho_line_map.add(134, 220);
    _caucho_line_map.add(142, 222);
    _caucho_line_map.add(143, 228);
    _caucho_line_map.add(158, 237);
    _caucho_line_map.add(159, 240);
    _caucho_line_map.add(166, 242);
    _caucho_line_map.add(184, 245);
    _caucho_line_map.add(185, 248);
    _caucho_line_map.add(185, 253);
    _caucho_line_map.add(185, 255);
    _caucho_line_map.add(197, 258);
    _caucho_line_map.add(202, 264);
    _caucho_line_map.add(207, 270);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("bbs/view.jsp"), 1179320293050L, 8138L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string13;
  private static byte []_jsp_string18;
  private static byte []_jsp_string20;
  private static byte []_jsp_string10;
  private static byte []_jsp_string15;
  private static byte []_jsp_string4;
  private static byte []_jsp_string12;
  private static byte []_jsp_string1;
  private static byte []_jsp_string3;
  private static byte []_jsp_string17;
  private static byte []_jsp_string28;
  private static byte []_jsp_string22;
  private static byte []_jsp_string16;
  private static byte []_jsp_string14;
  private static byte []_jsp_string0;
  private static byte []_jsp_string25;
  private static byte []_jsp_string23;
  private static byte []_jsp_string5;
  private static byte []_jsp_string7;
  private static byte []_jsp_string19;
  private static byte []_jsp_string9;
  private static byte []_jsp_string6;
  private static byte []_jsp_string26;
  private static byte []_jsp_string27;
  private static byte []_jsp_string11;
  private static byte []_jsp_string2;
  private static byte []_jsp_string21;
  private static byte []_jsp_string24;
  private static byte []_jsp_string8;
  static {
    try {
      _jsp_string13 = "</font></td>\r\n                    <td width=\"38%\" class=\"textgrey\">".getBytes("UTF8");
      _jsp_string18 = "\">\r\n        	<input name=\"page\" type=\"hidden\" id=\"page\" value=\"".getBytes("UTF8");
      _jsp_string20 = "\" width=\"14\" height=\"14\"> \r\n								".getBytes("UTF8");
      _jsp_string10 = "</td>\r\n                  </tr>\r\n                </table></td>\r\n            </tr>\r\n            <tr>\r\n              <td><table width=\"100%\" border=\"0\" cellspacing=\"6\" cellpadding=\"0\">\r\n                  <tr> \r\n                    <td valign=\"top\">".getBytes("UTF8");
      _jsp_string15 = "\r\n    <br>\r\n    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"6\">\r\n  	  <tr>\r\n        <td align=\"right\" valign=\"top\"> <form action=\"".getBytes("UTF8");
      _jsp_string4 = "\");\r\n		discuss.title.focus();\r\n	    return false;\r\n	}\r\n	if (discuss.content.value.length==0){\r\n		alert(\"".getBytes("UTF8");
      _jsp_string12 = "<font color=\"#3300CC\">".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string3 = "\r\n<script language=\"JavaScript\">\r\nfunction checkForm()\r\n{\r\n	if (discuss.title.value.length==0){\r\n		alert(\"".getBytes("UTF8");
      _jsp_string17 = "\">\r\n        	<input name=\"eventSubmit_JoinDiscuss\" type=\"hidden\" id=\"eventSubmit_JoinDiscuss\" value=\"0\">\r\n        	<input name=\"parentId\" type=\"hidden\" id=\"parentId\" value=\"".getBytes("UTF8");
      _jsp_string28 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string22 = "</td>\r\n                            <td width=\"85%\"><input name=\"title\" type=\"text\" id=\"title\" style=\"width:480px;\" value=\"".getBytes("UTF8");
      _jsp_string16 = "\" method=\"post\" onsubmit=\"return checkForm();\" name=\"discuss\" id=\"discuss\">\r\n        	<input name=\"id\" type=\"hidden\" id=\"id\" value=\"".getBytes("UTF8");
      _jsp_string14 = "</td>\r\n                  </tr>\r\n                </table></td>\r\n            </tr>\r\n          </table></td>\r\n      </tr>\r\n    </table>\r\n    ".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string25 = "\">\r\n                      	<input name=\"back\" type=\"button\" id=\"back\" onClick=\"window.location='".getBytes("UTF8");
      _jsp_string23 = "\"> \r\n                            </td>\r\n                          </tr>\r\n                          <tr> \r\n                            <td align=\"right\" valign=\"top\"> \r\n                              <table width=\"99%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                                <tr>\r\n                                      <td height=\"22\" align=\"right\">*".getBytes("UTF8");
      _jsp_string5 = "\");\r\n		discuss.content.focus();\r\n	    return false;\r\n	}\r\n	return true;\r\n}\r\n</script>\r\n<table width=\"778\" height=\"31\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr> \r\n    <td width=\"10\" class=\"channel_bar_left\">&nbsp;</td>\r\n    <td width=\"448\" class=\"channel_bar_bg\"><span class=\"bartitle\">&nbsp;".getBytes("UTF8");
      _jsp_string7 = "\r\n    <br>\r\n    <table width=\"96%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n      <tr>\r\n        <td class=\"discussblock\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n            <tr>\r\n              <td height=\"20\" class=\"discusstitle\"><table width=\"100%\" border=\"0\" cellspacing=\"3\" cellpadding=\"0\">\r\n                  <tr>\r\n                    <td width=\"5%\"><img src=\"".getBytes("UTF8");
      _jsp_string19 = "\">\r\n        	<input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/bbs/view.jsp\">\r\n            <table width=\"96%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n              <tr> \r\n                <td height=\"80\"> <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n					  <tr>\r\n						<td><table width=\"100%\" border=\"0\" cellspacing=\"4\" cellpadding=\"0\">\r\n							<tr>\r\n							  <td class=\"bigblocktitle\"><img src=\"".getBytes("UTF8");
      _jsp_string9 = "</strong></td>\r\n                    <td width=\"17%\" align=\"right\" class=\"textgrey\">".getBytes("UTF8");
      _jsp_string6 = "</span></td>\r\n    <td width=\"310\" style=\"PADDING-TOP: 2px;\" align=\"right\" class=\"channel_bar_bg\">&nbsp; \r\n      </td>\r\n    <td width=\"10\" class=\"channel_bar_right\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr> \r\n    <td valign=\"top\" class=\"pagecontent\">\r\n    <br>\r\n	".getBytes("UTF8");
      _jsp_string26 = "'\" value=\"".getBytes("UTF8");
      _jsp_string27 = "\"></td>\r\n              		  </td>\r\n                    </tr>\r\n                  </table>\r\n              </tr>\r\n            </table>\r\n          </form></td>\r\n      </tr>\r\n    </table> \r\n     </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string11 = "</td>\r\n                  </tr>\r\n                </table></td>\r\n            </tr>\r\n            <tr>\r\n              <td><table width=\"100%\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                  <tr>\r\n                    <td width=\"33%\">&nbsp;</td>\r\n                    <td width=\"29%\">".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string21 = "</td>\r\n							</tr>\r\n						  </table></td>\r\n					  </tr>\r\n					  <tr>\r\n						<td><table width=\"100%\" height=\"1\" bgcolor=\"#000000\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n							<tr>\r\n							  <td></td>\r\n							</tr>\r\n						  </table></td>\r\n					  </tr>\r\n                    <tr> \r\n                      <td align=\"center\">\r\n						<table width=\"99%\" border=\"0\" cellspacing=\"8\" cellpadding=\"0\">\r\n                          <tr> \r\n                                <td width=\"15%\" align=\"right\">*".getBytes("UTF8");
      _jsp_string24 = "</td>\r\n                                </tr>\r\n                              </table></td>\r\n                            <td><textarea name=\"content\" rows=\"8\" id=\"content\" style=\"width:480px;\"></textarea></td>\r\n                          </tr>\r\n                        </table>\r\n                      </td>\r\n                    </tr>\r\n                  </table></td>\r\n              </tr>\r\n              <tr> \r\n                <td>&nbsp;</td>\r\n              </tr>\r\n              <tr> \r\n                <td align=\"center\"> \r\n				  <table width=\"80%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n                    <tr>\r\n                      <td>\r\n                  		<input name=\"sub\" type=\"submit\" id=\"sub\" value=\"".getBytes("UTF8");
      _jsp_string8 = "\" width=\"22\" height=\"17\"></td>\r\n                    <td width=\"78%\" valign=\"middle\"><strong>".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
