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

public class _download__jsp extends com.caucho.jsp.JavaPage{
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
      //@ page errorPage="/error.jsp" 
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

//paper list
Page pg=PaperDAO.queryPaper(request, -1, RequestUtils.getParam(request, "page", 0), Globals.PAGESIZE_10);
PaperBean paper=null;

List subs=SubjectDAO.list();
List stas=StatusDAO.list();
String names=null;

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
      _jsp_tag1.setKey("menu.download.single");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      out.print((stats[0]));
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/admin/downloadpack.jsp");
      int _jspEval12 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar13 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar13 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("menu.download.pack");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.download.ins1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag2.setPage("/admin/download.jsp");
      int _jspEval22 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar23 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar23 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag1.setKey("page.paper.title.no");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag1.setKey("page.paper.ins6");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag1.setKey("page.paper.title.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.list.please.select");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      
	                  	SubjectBean sub=null;
	                  	if((subs!=null)&&(subs.size()>0)){
	                  		for(int i=0;i<subs.size();i++){
	                  			sub=(SubjectBean)subs.get(i);
	                  
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      out.print((sub.getId()));
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((StringUtils.exportString(sub.getSubject())));
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      }}
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.title.accept.status");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.list.please.select");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      
	                  	StatusBean sta=null;
	                  	if((stas!=null)&&(stas.size()>0)){
	                  		for(int i=0;i<stas.size();i++){
	                  			sta=(StatusBean)stas.get(i);
	                  
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      out.print((sta.getId()));
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((StringUtils.exportString(sta.getStatus())));
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      }}
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("page.paper.title.keyword");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      _jsp_tag1.setKey("page.paper.ins7");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.button.search.paper");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      if(pg!=null && pg.hasNext()){
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.text.no");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      _jsp_tag1.setKey("common.text.title");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      _jsp_tag1.setKey("common.text.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      _jsp_tag1.setKey("common.text.accept.status");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.download");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      
              	while(pg.hasNext()){
              		paper=(PaperBean)pg.next();
              		names=paper.getExpertNameList();
              
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      out.print((paper.getTitle()));
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/admin/download.jsp?subject=");
      int _jspEval68 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar69 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar69 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((paper.getSubject().getId()));
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("page.paper.link.ins.subject");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((paper.getSubject().getSubject()));
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      out.print((StringUtils.exportString(StatusDAO.getStatusInMap(paper.getStatus()))));
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.download");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      _jsp_tag2.setPage("/viewpaper.jsp?id=");
      int _jspEval78 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar79 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar79 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((paper.getId()));
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      _jsp_tag2.setPage("/images/icon_down.gif");
      int _jspEval82 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar83 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar83 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      }
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
      out.print((pg.getControlPane(request, "/admin/download.jsp")));
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      }else{
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.norecord");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      }
      pageContext.write(_jsp_string42, 0, _jsp_string42.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string43, 0, _jsp_string43.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_download__jsp.java", "/conf1/admin/download.jsp");
    _caucho_line_map.add(19, 1);
    _caucho_line_map.add(1, 36);
    _caucho_line_map.add(6, 42);
    _caucho_line_map.add(7, 52);
    _caucho_line_map.add(8, 56);
    _caucho_line_map.add(13, 62);
    _caucho_line_map.add(19, 69);
    _caucho_line_map.add(27, 78);
    _caucho_line_map.add(41, 91);
    _caucho_line_map.add(46, 97);
    _caucho_line_map.add(49, 99);
    _caucho_line_map.add(54, 105);
    _caucho_line_map.add(55, 107);
    _caucho_line_map.add(56, 109);
    _caucho_line_map.add(61, 115);
    _caucho_line_map.add(67, 117);
    _caucho_line_map.add(68, 119);
    _caucho_line_map.add(75, 121);
    _caucho_line_map.add(78, 131);
    _caucho_line_map.add(78, 134);
    _caucho_line_map.add(79, 136);
    _caucho_line_map.add(79, 148);
    _caucho_line_map.add(87, 151);
    _caucho_line_map.add(91, 154);
    _caucho_line_map.add(95, 160);
    _caucho_line_map.add(97, 163);
    _caucho_line_map.add(102, 166);
    _caucho_line_map.add(104, 169);
    _caucho_line_map.add(105, 178);
    _caucho_line_map.add(111, 185);
    _caucho_line_map.add(111, 187);
    _caucho_line_map.add(112, 189);
    _caucho_line_map.add(118, 191);
    _caucho_line_map.add(120, 201);
    _caucho_line_map.add(121, 210);
    _caucho_line_map.add(127, 217);
    _caucho_line_map.add(127, 219);
    _caucho_line_map.add(128, 221);
    _caucho_line_map.add(134, 223);
    _caucho_line_map.add(136, 233);
    _caucho_line_map.add(141, 236);
    _caucho_line_map.add(155, 245);
    _caucho_line_map.add(158, 247);
    _caucho_line_map.add(159, 257);
    _caucho_line_map.add(160, 260);
    _caucho_line_map.add(161, 263);
    _caucho_line_map.add(162, 266);
    _caucho_line_map.add(164, 275);
    _caucho_line_map.add(171, 283);
    _caucho_line_map.add(172, 285);
    _caucho_line_map.add(172, 296);
    _caucho_line_map.add(172, 298);
    _caucho_line_map.add(172, 308);
    _caucho_line_map.add(173, 310);
    _caucho_line_map.add(174, 312);
    _caucho_line_map.add(174, 321);
    _caucho_line_map.add(174, 326);
    _caucho_line_map.add(174, 328);
    _caucho_line_map.add(176, 334);
    _caucho_line_map.add(180, 336);
    _caucho_line_map.add(183, 338);
    _caucho_line_map.add(186, 340);
    _caucho_line_map.add(189, 349);
    _caucho_line_map.add(196, 351);
    _caucho_line_map.add(201, 357);
    _caucho_line_map.add(206, 363);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/download.jsp"), 1184595341562L, 9359L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string31;
  private static byte []_jsp_string10;
  private static byte []_jsp_string13;
  private static byte []_jsp_string21;
  private static byte []_jsp_string9;
  private static byte []_jsp_string38;
  private static byte []_jsp_string1;
  private static byte []_jsp_string43;
  private static byte []_jsp_string27;
  private static byte []_jsp_string28;
  private static byte []_jsp_string0;
  private static byte []_jsp_string22;
  private static byte []_jsp_string7;
  private static byte []_jsp_string12;
  private static byte []_jsp_string41;
  private static byte []_jsp_string4;
  private static byte []_jsp_string36;
  private static byte []_jsp_string5;
  private static byte []_jsp_string34;
  private static byte []_jsp_string29;
  private static byte []_jsp_string26;
  private static byte []_jsp_string16;
  private static byte []_jsp_string2;
  private static byte []_jsp_string15;
  private static byte []_jsp_string17;
  private static byte []_jsp_string23;
  private static byte []_jsp_string42;
  private static byte []_jsp_string39;
  private static byte []_jsp_string32;
  private static byte []_jsp_string3;
  private static byte []_jsp_string19;
  private static byte []_jsp_string24;
  private static byte []_jsp_string6;
  private static byte []_jsp_string37;
  private static byte []_jsp_string20;
  private static byte []_jsp_string18;
  private static byte []_jsp_string33;
  private static byte []_jsp_string8;
  private static byte []_jsp_string14;
  private static byte []_jsp_string25;
  private static byte []_jsp_string11;
  private static byte []_jsp_string40;
  private static byte []_jsp_string35;
  private static byte []_jsp_string30;
  static {
    try {
      _jsp_string31 = "</td>\r\n                <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string10 = "</a></td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string13 = "</td>\r\n                  <td class=\"form_row_content\"><input name=\"pid\" type=\"text\" id=\"pid\" size=\"18\">\r\n                    {".getBytes("UTF8");
      _jsp_string21 = "</td>\r\n                  <td class=\"form_row_content\"><input name=\"keyword\" type=\"text\" id=\"keyword\" size=\"28\">\r\n                    {".getBytes("UTF8");
      _jsp_string9 = "\" class=\"pagemenu\">".getBytes("UTF8");
      _jsp_string38 = "\" width=\"21\" height=\"21\" border=\"0\"></a></td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string43 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string27 = "</td>\r\n                <td width=\"11%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string28 = "</td>\r\n                <td width=\"7%\" align=\"center\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string22 = "}</td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td nowrap class=\"form_row_submit\"><input name=\"sub\" type=\"submit\" class=\"button\" id=\"sub\" value=\"".getBytes("UTF8");
      _jsp_string7 = "(".getBytes("UTF8");
      _jsp_string12 = "\" method=\"post\" name=\"search\" id=\"search\">\r\n	        <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/admin/download.jsp\">\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"21%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string41 = "\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n              <tr> \r\n                <td align=\"center\" class=\"blackbold\" nowrap>".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string36 = "\" href=\"".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr> \r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string34 = "</a></td>\r\n                <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string29 = "</td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string26 = "</td>\r\n                <td width=\"28%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string16 = "</option>\r\n	                  ".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string15 = "</td>\r\n                  <td class=\"form_row_content\"><select name=\"subject\" id=\"subject\">\r\n                      <option selected>".getBytes("UTF8");
      _jsp_string17 = "\r\n	                  <option value=\"".getBytes("UTF8");
      _jsp_string23 = "\">\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n            </form>\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n              <tr>\r\n                <td width=\"52%\">\r\n					<div class=\"spacer_20\"></div>\r\n					<div class=\"line_dashed\"></div>\r\n					<div class=\"spacer_10\"></div>\r\n				</td>\r\n              </tr>\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string42 = "\r\n          </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string39 = "\r\n            </table>\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" style=\"border-bottom:#cccccc 1px solid\">\r\n              <tr> \r\n                <td align=\"right\" nowrap>".getBytes("UTF8");
      _jsp_string32 = "</td>\r\n                <td class=\"table_cell\"><a href=\"".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string19 = "\r\n                    </select></td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"21%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string24 = "\r\n			<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n              <tr> \r\n                <td width=\"6%\" align=\"center\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string6 = "</b></td>\r\n        </tr>\r\n        <tr> \r\n          <td align=\"right\" class=\"pagecontent_right\"><span class=\"pagemenu_visited\">".getBytes("UTF8");
      _jsp_string37 = "\" target=\"_blank\"><img src=\"".getBytes("UTF8");
      _jsp_string20 = "</td>\r\n                  <td class=\"form_row_content\"><select name=\"status\" id=\"status\">\r\n                      <option selected>".getBytes("UTF8");
      _jsp_string18 = "\">".getBytes("UTF8");
      _jsp_string33 = "\" title=\"".getBytes("UTF8");
      _jsp_string8 = ")</span> \r\n            > <a href=\"".getBytes("UTF8");
      _jsp_string14 = "} </td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"21%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string25 = "</td>\r\n                <td width=\"48%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string11 = "</li>\r\n                  <div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string40 = "</td>\r\n              </tr>\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string35 = "</td>\r\n                <td align=\"center\" class=\"table_cell\"><a title=\"".getBytes("UTF8");
      _jsp_string30 = "\r\n              <tr> \r\n                <td align=\"center\" class=\"table_cell\">".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
