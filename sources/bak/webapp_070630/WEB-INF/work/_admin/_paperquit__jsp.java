/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _admin;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.dao.*;
import org.myconf.beans.*;
import java.util.*;

public class _paperquit__jsp extends com.caucho.jsp.JavaPage{
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
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//paper statistics data
int[] stats=PaperDAO.statPaper();

//quit list
List quits=ReviewDAO.listQuits();
ReviewBean quit=null;
PaperBean paper=null;
int qs=0;
if(quits!=null)
	qs=quits.size();

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
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/admin/paperassign.jsp?id=");
      int _jspEval6 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar7 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar7 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("menu.left.paper");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setPage("/admin/paper.jsp");
      int _jspEval13 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar14 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar14 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag2.setKey("menu.paper.top.all");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((stats[0]));
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setPage("/admin/paperunassign.jsp");
      int _jspEval20 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar21 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar21 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag2.setKey("menu.paper.top.not.assign");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((stats[PaperBean.PAPER_STATE_NORMAL]));
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag1.setPage("/admin/paperassigned.jsp");
      int _jspEval27 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar28 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar28 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag2.setKey("menu.paper.top.assigned");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((stats[PaperBean.PAPER_STATE_ASSIGNED]));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag2.setKey("menu.paper.top.quit");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((qs));
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag1.setPage("/admin/papercycle.jsp");
      int _jspEval37 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar38 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar38 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag2.setKey("menu.paper.top.recycle");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((stats[PaperBean.PAPER_STATE_FORBIDDEN]));
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag2.setKey("page.paperquit.ins1");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag1.setPage("/paper.do");
      int _jspEval47 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar48 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar48 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      if(quits!=null && quits.size()>0){
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("common.text.no");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      _jsp_tag2.setKey("common.text.title");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      _jsp_tag2.setKey("common.text.subject");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      _jsp_tag2.setKey("common.text.quitexpert");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      
              	for(int i=0;i<quits.size();i++){
              		quit=(ReviewBean)quits.get(i);
              		paper=quit.getPaper();
              		if(paper.getState()!=PaperBean.PAPER_STATE_FORBIDDEN){
              
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/viewpaper.jsp?id=");
      int _jspEval66 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar67 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar67 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((paper.getId()));
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("page.paper.link.ins.down");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      out.print((paper.getTitle()));
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      out.print((paper.getSubject().getSubject()));
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      _jsp_tag2.setKey("page.paper.link.ins.assign");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      out.print((quit.getExpertName()));
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      _jsp_tag3.setKey("ins.confirm.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      _jsp_tag1.setPage("/images/sub_del.gif");
      int _jspEval82 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar83 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar83 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      }}
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      }else{
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.norecord");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      }
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_paperquit__jsp.java", "/myconf/admin/paperquit.jsp");
    _caucho_line_map.add(17, 1);
    _caucho_line_map.add(1, 34);
    _caucho_line_map.add(6, 40);
    _caucho_line_map.add(7, 50);
    _caucho_line_map.add(8, 54);
    _caucho_line_map.add(13, 60);
    _caucho_line_map.add(25, 73);
    _caucho_line_map.add(39, 86);
    _caucho_line_map.add(44, 92);
    _caucho_line_map.add(47, 94);
    _caucho_line_map.add(52, 100);
    _caucho_line_map.add(53, 102);
    _caucho_line_map.add(54, 104);
    _caucho_line_map.add(59, 110);
    _caucho_line_map.add(65, 112);
    _caucho_line_map.add(66, 114);
    _caucho_line_map.add(73, 116);
    _caucho_line_map.add(78, 128);
    _caucho_line_map.add(81, 138);
    _caucho_line_map.add(81, 144);
    _caucho_line_map.add(81, 147);
    _caucho_line_map.add(82, 149);
    _caucho_line_map.add(82, 155);
    _caucho_line_map.add(82, 158);
    _caucho_line_map.add(83, 160);
    _caucho_line_map.add(83, 166);
    _caucho_line_map.add(83, 169);
    _caucho_line_map.add(84, 171);
    _caucho_line_map.add(84, 174);
    _caucho_line_map.add(85, 176);
    _caucho_line_map.add(85, 182);
    _caucho_line_map.add(85, 185);
    _caucho_line_map.add(93, 187);
    _caucho_line_map.add(116, 190);
    _caucho_line_map.add(121, 196);
    _caucho_line_map.add(124, 198);
    _caucho_line_map.add(125, 208);
    _caucho_line_map.add(126, 211);
    _caucho_line_map.add(127, 214);
    _caucho_line_map.add(128, 217);
    _caucho_line_map.add(130, 226);
    _caucho_line_map.add(138, 235);
    _caucho_line_map.add(138, 246);
    _caucho_line_map.add(138, 248);
    _caucho_line_map.add(138, 258);
    _caucho_line_map.add(139, 260);
    _caucho_line_map.add(140, 262);
    _caucho_line_map.add(140, 264);
    _caucho_line_map.add(140, 267);
    _caucho_line_map.add(141, 269);
    _caucho_line_map.add(141, 278);
    _caucho_line_map.add(141, 281);
    _caucho_line_map.add(141, 283);
    _caucho_line_map.add(144, 289);
    _caucho_line_map.add(149, 293);
    _caucho_line_map.add(152, 302);
    _caucho_line_map.add(159, 304);
    _caucho_line_map.add(164, 310);
    _caucho_line_map.add(169, 316);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/paperquit.jsp"), 1182181782937L, 7268L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string32;
  private static byte []_jsp_string7;
  private static byte []_jsp_string8;
  private static byte []_jsp_string1;
  private static byte []_jsp_string29;
  private static byte []_jsp_string34;
  private static byte []_jsp_string25;
  private static byte []_jsp_string40;
  private static byte []_jsp_string21;
  private static byte []_jsp_string16;
  private static byte []_jsp_string0;
  private static byte []_jsp_string36;
  private static byte []_jsp_string11;
  private static byte []_jsp_string10;
  private static byte []_jsp_string15;
  private static byte []_jsp_string9;
  private static byte []_jsp_string37;
  private static byte []_jsp_string4;
  private static byte []_jsp_string18;
  private static byte []_jsp_string27;
  private static byte []_jsp_string22;
  private static byte []_jsp_string20;
  private static byte []_jsp_string2;
  private static byte []_jsp_string39;
  private static byte []_jsp_string5;
  private static byte []_jsp_string33;
  private static byte []_jsp_string24;
  private static byte []_jsp_string3;
  private static byte []_jsp_string17;
  private static byte []_jsp_string35;
  private static byte []_jsp_string30;
  private static byte []_jsp_string31;
  private static byte []_jsp_string6;
  private static byte []_jsp_string13;
  private static byte []_jsp_string12;
  private static byte []_jsp_string38;
  private static byte []_jsp_string26;
  private static byte []_jsp_string14;
  private static byte []_jsp_string19;
  private static byte []_jsp_string28;
  private static byte []_jsp_string23;
  static {
    try {
      _jsp_string32 = "\" onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string7 = "</b></td>\r\n        </tr>\r\n        <tr> \r\n          <td align=\"right\" class=\"pagecontent_right\"><a href=\"".getBytes("UTF8");
      _jsp_string8 = "\" class=\"pagemenu\">".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string29 = ")\" class=\"blue\" title=\"".getBytes("UTF8");
      _jsp_string34 = ")\"><img src=\"".getBytes("UTF8");
      _jsp_string25 = "\" target=\"_blank\" title=\"".getBytes("UTF8");
      _jsp_string40 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string21 = "</td>\r\n                <td width=\"6%\" align=\"center\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string16 = "\" method=\"post\" name=\"del\" id=\"del\">\r\n		        <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/admin/paperquit.jsp\">\r\n		        <input name=\"eventSubmit_Recycle\" type=\"hidden\" id=\"eventSubmit_Recycle\" value=\"1\">\r\n		        <input name=\"id\" type=\"hidden\" id=\"id\" value=\"0\">\r\n            </form>\r\n            ".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string36 = "\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string11 = ")</a> \r\n			> <a href=\"".getBytes("UTF8");
      _jsp_string10 = ")</a> \r\n            > <a href=\"".getBytes("UTF8");
      _jsp_string15 = "</li>\r\n                  <div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n			  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n				<tr> \r\n				  <td nowrap class=\"form_row_submit\">&nbsp; </td>\r\n				</tr>\r\n			  </table>\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n              <tr>\r\n                <td width=\"52%\">\r\n					<div class=\"line_dashed\"></div>\r\n					<div class=\"spacer_10\"></div>\r\n				</td>\r\n              </tr>\r\n            </table>\r\n			<script language=\"JavaScript\">\r\n			function delPaper(id) {\r\n				del.id.value=id;\r\n				del.submit();\r\n			}\r\n			</script>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string9 = "(".getBytes("UTF8");
      _jsp_string37 = "\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n              <tr> \r\n                <td align=\"center\" class=\"blackbold\" nowrap>".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string18 = "</td>\r\n                <td width=\"50%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string27 = "</a></td>\r\n                <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string22 = "</td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string20 = "</td>\r\n                <td width=\"16%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string39 = "\r\n          </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	<script language=\"JavaScript\">\r\n	function paperAssign(pid) {\r\n		window.open(\"".getBytes("UTF8");
      _jsp_string33 = "')\" href=\"javascript:delPaper(".getBytes("UTF8");
      _jsp_string24 = "</td>\r\n                <td class=\"table_cell\"><a href=\"".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string17 = "\r\n			<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n              <tr> \r\n                <td width=\"6%\" align=\"center\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string35 = "\" width=\"21\" height=\"21\" border=\"0\"></a> \r\n                </td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string30 = "\">".getBytes("UTF8");
      _jsp_string31 = "</a></strong> </td>\r\n                <td align=\"center\" class=\"table_cell\"><a title=\"".getBytes("UTF8");
      _jsp_string6 = "\"+pid, \"paper\", \"resizable=no,scrollbars=yes,height=600,width=800\");\r\n	}\r\n	</script>\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr> \r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string13 = ")</span> \r\n            > <a href=\"".getBytes("UTF8");
      _jsp_string12 = ")</a> \r\n            > <span class=\"pagemenu_visited\">".getBytes("UTF8");
      _jsp_string38 = "</td>\r\n              </tr>\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string26 = "\" class=\"blue\">".getBytes("UTF8");
      _jsp_string14 = ")</a></td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string19 = "</td>\r\n                <td width=\"22%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string28 = "</td>\r\n                <td class=\"table_cell\"><strong><a href=\"javascript:paperAssign(".getBytes("UTF8");
      _jsp_string23 = "\r\n              <tr> \r\n                <td align=\"center\" class=\"table_cell\">".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
