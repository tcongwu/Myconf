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

public class _paper__jsp extends com.caucho.jsp.JavaPage{
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
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//paper statistics data
int[] stats=PaperDAO.statPaper();
int qs=ReviewDAO.countQuits();

//paper list
Page pg=PaperDAO.queryPaper(request, -1, RequestUtils.getParam(request, "page", 0), Globals.PAGESIZE_10);
PaperBean paper=null;

List subs=SubjectDAO.list();
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
      _jsp_tag2.setKey("menu.paper.top.all");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((stats[0]));
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setPage("/admin/paperunassign.jsp");
      int _jspEval16 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar17 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar17 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setKey("menu.paper.top.not.assign");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((stats[PaperBean.PAPER_STATE_NORMAL]));
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag1.setPage("/admin/paperassigned.jsp");
      int _jspEval23 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar24 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar24 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setKey("menu.paper.top.assigned");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((stats[PaperBean.PAPER_STATE_ASSIGNED]));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag1.setPage("/admin/paperquit.jsp");
      int _jspEval30 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar31 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar31 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setKey("menu.paper.top.quit");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((qs));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag1.setPage("/admin/papercycle.jsp");
      int _jspEval37 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar38 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar38 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setKey("menu.paper.top.recycle");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      out.print((stats[PaperBean.PAPER_STATE_FORBIDDEN]));
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag2.setKey("page.paper.ins1");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag2.setKey("page.paper.ins2");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag2.setKey("page.paper.ins3");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag2.setKey("page.paper.ins4");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag2.setKey("page.paper.ins5");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      _jsp_tag1.setPage("/admin/paper.jsp");
      int _jspEval59 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar60 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar60 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      _jsp_tag2.setKey("page.paper.title.no");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      _jsp_tag2.setKey("page.paper.ins6");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      _jsp_tag2.setKey("page.paper.title.subject");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.list.please.select");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      
	                  	SubjectBean sub=null;
	                  	if((subs!=null)&&(subs.size()>0)){
	                  		for(int i=0;i<subs.size();i++){
	                  			sub=(SubjectBean)subs.get(i);
	                  
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      out.print((sub.getId()));
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      out.print((StringUtils.exportString(sub.getSubject())));
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      }}
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("page.paper.title.keyword");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      _jsp_tag2.setKey("page.paper.ins7");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.button.search.paper");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/paper.do");
      int _jspEval84 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar85 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar85 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      out.print((StringUtils.exportString(request.getParameter("pid"))));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      out.print((StringUtils.exportString(request.getParameter("subject"))));
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      out.print((StringUtils.exportString(request.getParameter("keyword"))));
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      out.print((StringUtils.exportString(request.getParameter("page"))));
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      if(pg!=null && pg.hasNext()){
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("common.text.no");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      _jsp_tag2.setKey("common.text.title");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      _jsp_tag2.setKey("common.text.subject");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      _jsp_tag2.setKey("common.text.expert");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      
              	while(pg.hasNext()){
              		paper=(PaperBean)pg.next();
              		names=paper.getExpertNameList();
              
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/viewpaper.jsp?id=");
      int _jspEval103 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar104 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar104 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((paper.getId()));
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("page.paper.link.ins.down");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string42, 0, _jsp_string42.length);
      out.print((paper.getTitle()));
      pageContext.write(_jsp_string43, 0, _jsp_string43.length);
      _jsp_tag1.setPage("/admin/paper.jsp?subject=");
      int _jspEval110 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar111 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar111 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((paper.getSubject().getId()));
      pageContext.write(_jsp_string44, 0, _jsp_string44.length);
      _jsp_tag2.setKey("page.paper.link.ins.subject");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      out.print((paper.getSubject().getSubject()));
      pageContext.write(_jsp_string45, 0, _jsp_string45.length);
      if(StringUtils.isEmpty(names)){
      pageContext.write(_jsp_string46, 0, _jsp_string46.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string47, 0, _jsp_string47.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("page.paper.link.ins.assign");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string48, 0, _jsp_string48.length);
      _jsp_tag2.setKey("common.text.assign");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string49, 0, _jsp_string49.length);
      }else{
      pageContext.write(_jsp_string46, 0, _jsp_string46.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string47, 0, _jsp_string47.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
      }

      _jsp_tag2.setKey("page.paper.link.ins.redistribute");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      out.print((names));
      pageContext.write(_jsp_string50, 0, _jsp_string50.length);
      }
      pageContext.write(_jsp_string51, 0, _jsp_string51.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string52, 0, _jsp_string52.length);
      _jsp_tag3.setKey("ins.confirm.delete");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string53, 0, _jsp_string53.length);
      out.print((paper.getId()));
      pageContext.write(_jsp_string54, 0, _jsp_string54.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/images/sub_del.gif");
      int _jspEval132 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar133 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar133 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string55, 0, _jsp_string55.length);
      }
      pageContext.write(_jsp_string56, 0, _jsp_string56.length);
      out.print((pg.getControlPane(request, "/admin/paper.jsp")));
      pageContext.write(_jsp_string57, 0, _jsp_string57.length);
      }else{
      pageContext.write(_jsp_string58, 0, _jsp_string58.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.norecord");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string57, 0, _jsp_string57.length);
      }
      pageContext.write(_jsp_string59, 0, _jsp_string59.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string60, 0, _jsp_string60.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_paper__jsp.java", "/conf1/admin/paper.jsp");
    _caucho_line_map.add(19, 1);
    _caucho_line_map.add(1, 36);
    _caucho_line_map.add(6, 42);
    _caucho_line_map.add(7, 52);
    _caucho_line_map.add(8, 56);
    _caucho_line_map.add(13, 62);
    _caucho_line_map.add(27, 77);
    _caucho_line_map.add(41, 90);
    _caucho_line_map.add(46, 96);
    _caucho_line_map.add(49, 98);
    _caucho_line_map.add(54, 104);
    _caucho_line_map.add(55, 106);
    _caucho_line_map.add(56, 108);
    _caucho_line_map.add(61, 114);
    _caucho_line_map.add(67, 116);
    _caucho_line_map.add(68, 118);
    _caucho_line_map.add(75, 120);
    _caucho_line_map.add(80, 132);
    _caucho_line_map.add(83, 142);
    _caucho_line_map.add(83, 145);
    _caucho_line_map.add(84, 147);
    _caucho_line_map.add(84, 153);
    _caucho_line_map.add(84, 156);
    _caucho_line_map.add(85, 158);
    _caucho_line_map.add(85, 164);
    _caucho_line_map.add(85, 167);
    _caucho_line_map.add(86, 169);
    _caucho_line_map.add(86, 175);
    _caucho_line_map.add(86, 178);
    _caucho_line_map.add(87, 180);
    _caucho_line_map.add(87, 186);
    _caucho_line_map.add(87, 189);
    _caucho_line_map.add(95, 191);
    _caucho_line_map.add(96, 194);
    _caucho_line_map.add(97, 197);
    _caucho_line_map.add(98, 200);
    _caucho_line_map.add(99, 203);
    _caucho_line_map.add(103, 206);
    _caucho_line_map.add(107, 212);
    _caucho_line_map.add(109, 215);
    _caucho_line_map.add(114, 218);
    _caucho_line_map.add(116, 221);
    _caucho_line_map.add(117, 230);
    _caucho_line_map.add(123, 237);
    _caucho_line_map.add(123, 239);
    _caucho_line_map.add(124, 241);
    _caucho_line_map.add(130, 243);
    _caucho_line_map.add(132, 253);
    _caucho_line_map.add(137, 256);
    _caucho_line_map.add(157, 265);
    _caucho_line_map.add(160, 277);
    _caucho_line_map.add(161, 279);
    _caucho_line_map.add(162, 281);
    _caucho_line_map.add(163, 283);
    _caucho_line_map.add(166, 285);
    _caucho_line_map.add(169, 287);
    _caucho_line_map.add(170, 297);
    _caucho_line_map.add(171, 300);
    _caucho_line_map.add(172, 303);
    _caucho_line_map.add(173, 306);
    _caucho_line_map.add(175, 315);
    _caucho_line_map.add(182, 323);
    _caucho_line_map.add(182, 334);
    _caucho_line_map.add(182, 336);
    _caucho_line_map.add(182, 346);
    _caucho_line_map.add(183, 348);
    _caucho_line_map.add(183, 353);
    _caucho_line_map.add(183, 355);
    _caucho_line_map.add(183, 358);
    _caucho_line_map.add(186, 362);
    _caucho_line_map.add(186, 364);
    _caucho_line_map.add(186, 374);
    _caucho_line_map.add(187, 377);
    _caucho_line_map.add(188, 379);
    _caucho_line_map.add(188, 381);
    _caucho_line_map.add(188, 391);
    _caucho_line_map.add(189, 393);
    _caucho_line_map.add(191, 404);
    _caucho_line_map.add(191, 407);
    _caucho_line_map.add(191, 409);
    _caucho_line_map.add(194, 421);
    _caucho_line_map.add(198, 423);
    _caucho_line_map.add(201, 425);
    _caucho_line_map.add(204, 427);
    _caucho_line_map.add(207, 436);
    _caucho_line_map.add(214, 438);
    _caucho_line_map.add(219, 444);
    _caucho_line_map.add(224, 450);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/paper.jsp"), 1184593786859L, 11216L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string52;
  private static byte []_jsp_string49;
  private static byte []_jsp_string18;
  private static byte []_jsp_string25;
  private static byte []_jsp_string10;
  private static byte []_jsp_string46;
  private static byte []_jsp_string1;
  private static byte []_jsp_string32;
  private static byte []_jsp_string14;
  private static byte []_jsp_string30;
  private static byte []_jsp_string24;
  private static byte []_jsp_string41;
  private static byte []_jsp_string54;
  private static byte []_jsp_string37;
  private static byte []_jsp_string60;
  private static byte []_jsp_string43;
  private static byte []_jsp_string0;
  private static byte []_jsp_string26;
  private static byte []_jsp_string11;
  private static byte []_jsp_string12;
  private static byte []_jsp_string19;
  private static byte []_jsp_string8;
  private static byte []_jsp_string58;
  private static byte []_jsp_string4;
  private static byte []_jsp_string17;
  private static byte []_jsp_string34;
  private static byte []_jsp_string38;
  private static byte []_jsp_string36;
  private static byte []_jsp_string21;
  private static byte []_jsp_string2;
  private static byte []_jsp_string20;
  private static byte []_jsp_string22;
  private static byte []_jsp_string59;
  private static byte []_jsp_string5;
  private static byte []_jsp_string48;
  private static byte []_jsp_string51;
  private static byte []_jsp_string53;
  private static byte []_jsp_string40;
  private static byte []_jsp_string56;
  private static byte []_jsp_string45;
  private static byte []_jsp_string50;
  private static byte []_jsp_string3;
  private static byte []_jsp_string15;
  private static byte []_jsp_string28;
  private static byte []_jsp_string33;
  private static byte []_jsp_string7;
  private static byte []_jsp_string47;
  private static byte []_jsp_string55;
  private static byte []_jsp_string23;
  private static byte []_jsp_string44;
  private static byte []_jsp_string6;
  private static byte []_jsp_string9;
  private static byte []_jsp_string16;
  private static byte []_jsp_string31;
  private static byte []_jsp_string57;
  private static byte []_jsp_string27;
  private static byte []_jsp_string29;
  private static byte []_jsp_string42;
  private static byte []_jsp_string13;
  private static byte []_jsp_string35;
  private static byte []_jsp_string39;
  static {
    try {
      _jsp_string52 = "\" onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string49 = "</strong></a>\r\n                ".getBytes("UTF8");
      _jsp_string18 = "</td>\r\n                  <td class=\"form_row_content\"><input name=\"pid\" type=\"text\" id=\"pid\" size=\"18\">\r\n                    {".getBytes("UTF8");
      _jsp_string25 = "</td>\r\n                  <td class=\"form_row_content\"><input name=\"keyword\" type=\"text\" id=\"keyword\" size=\"28\">\r\n                    {".getBytes("UTF8");
      _jsp_string10 = "\" class=\"pagemenu\">".getBytes("UTF8");
      _jsp_string46 = "\r\n                  <a href=\"javascript:paperAssign(".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string32 = "\">\r\n		        <input name=\"id\" type=\"hidden\" id=\"id\" value=\"0\">\r\n            </form>\r\n            ".getBytes("UTF8");
      _jsp_string14 = "</li>\r\n                  <li>".getBytes("UTF8");
      _jsp_string30 = "\">\r\n		        <input name=\"keyword\" type=\"hidden\" id=\"keyword\" value=\"".getBytes("UTF8");
      _jsp_string24 = "\r\n                    </select></td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"22%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string41 = "\" target=\"_blank\" title=\"".getBytes("UTF8");
      _jsp_string54 = ")\"><img src=\"".getBytes("UTF8");
      _jsp_string37 = "</td>\r\n                <td width=\"6%\" align=\"center\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string60 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string43 = "</a></td>\r\n                <td class=\"table_cell\"><a href=\"".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string26 = "}</td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td nowrap class=\"form_row_submit\"><input name=\"sub\" type=\"submit\" class=\"button\" id=\"sub\" value=\"".getBytes("UTF8");
      _jsp_string11 = ")</a> \r\n			> <a href=\"".getBytes("UTF8");
      _jsp_string12 = ")</a> \r\n            > <a href=\"".getBytes("UTF8");
      _jsp_string19 = "} </td>\r\n                </tr>\r\n              </table>\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"22%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string8 = "(".getBytes("UTF8");
      _jsp_string58 = "\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n              <tr> \r\n                <td align=\"center\" class=\"blackbold\" nowrap>".getBytes("UTF8");
      _jsp_string4 = "\r\n			".getBytes("UTF8");
      _jsp_string17 = "\" method=\"post\" name=\"search\" id=\"search\">\r\n	        <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/admin/paper.jsp\">\r\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td width=\"22%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string34 = "</td>\r\n                <td width=\"50%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string38 = "</td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string36 = "</td>\r\n                <td width=\"16%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string21 = "</option>\r\n	                  ".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string20 = "</td>\r\n                  <td class=\"form_row_content\"><select name=\"subject\" id=\"subject\">\r\n                      <option selected>".getBytes("UTF8");
      _jsp_string22 = "\r\n	                  <option value=\"".getBytes("UTF8");
      _jsp_string59 = "\r\n          </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string5 = "\r\n          </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\">\r\n	<script language=\"JavaScript\">\r\n	function paperAssign(pid) {\r\n		window.open(\"".getBytes("UTF8");
      _jsp_string48 = "\" class=\"blue\"><strong>".getBytes("UTF8");
      _jsp_string51 = "\r\n                </td>\r\n                <td align=\"center\" class=\"table_cell\"><a title=\"".getBytes("UTF8");
      _jsp_string53 = "')\" href=\"javascript:delPaper(".getBytes("UTF8");
      _jsp_string40 = "</td>\r\n                <td class=\"table_cell\"><a href=\"".getBytes("UTF8");
      _jsp_string56 = "\r\n            </table>\r\n            <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" style=\"border-bottom:#cccccc 1px solid\">\r\n              <tr> \r\n                <td align=\"right\" nowrap>".getBytes("UTF8");
      _jsp_string45 = "</a></td>\r\n                <td class=\"table_cell\">\r\n                ".getBytes("UTF8");
      _jsp_string50 = "</a>\r\n                ".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n			".getBytes("UTF8");
      _jsp_string15 = "</li>\r\n				  <li>".getBytes("UTF8");
      _jsp_string28 = "\" method=\"post\" name=\"del\" id=\"del\">\r\n		        <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/admin/paper.jsp\">\r\n		        <input name=\"eventSubmit_Recycle\" type=\"hidden\" id=\"eventSubmit_Recycle\" value=\"1\">\r\n		        <input name=\"pid\" type=\"hidden\" id=\"pid\" value=\"".getBytes("UTF8");
      _jsp_string33 = "\r\n			<table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n              <tr> \r\n                <td width=\"6%\" align=\"center\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string7 = "</b></td>\r\n        </tr>\r\n        <tr> \r\n          <td align=\"right\" class=\"pagecontent_right\"><span class=\"pagemenu_visited\">".getBytes("UTF8");
      _jsp_string47 = ")\" title=\"".getBytes("UTF8");
      _jsp_string55 = "\" width=\"21\" height=\"21\" border=\"0\"></a> \r\n                </td>\r\n              </tr>\r\n              ".getBytes("UTF8");
      _jsp_string23 = "\">".getBytes("UTF8");
      _jsp_string44 = "\" title=\"".getBytes("UTF8");
      _jsp_string6 = "\"+pid, \"paper\", \"resizable=no,scrollbars=yes,height=600,width=800\");\r\n	}\r\n	</script>\r\n	  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n        <tr> \r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string9 = ")</span> \r\n            > <a href=\"".getBytes("UTF8");
      _jsp_string16 = "</li>\r\n                  <div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string31 = "\">\r\n		        <input name=\"page\" type=\"hidden\" id=\"page\" value=\"".getBytes("UTF8");
      _jsp_string57 = "</td>\r\n              </tr>\r\n            </table>\r\n            ".getBytes("UTF8");
      _jsp_string27 = "\">\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n            </form>\r\n            <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n              <tr>\r\n                <td width=\"52%\">\r\n					<div class=\"spacer_20\"></div>\r\n					<div class=\"line_dashed\"></div>\r\n					<div class=\"spacer_10\"></div>\r\n				</td>\r\n              </tr>\r\n            </table>\r\n			<script language=\"JavaScript\">\r\n			function delPaper(id) {\r\n				del.id.value=id;\r\n				del.submit();\r\n			}\r\n			</script>\r\n            <form action=\"".getBytes("UTF8");
      _jsp_string29 = "\">\r\n		        <input name=\"subject\" type=\"hidden\" id=\"subject\" value=\"".getBytes("UTF8");
      _jsp_string42 = "\" class=\"blue\">".getBytes("UTF8");
      _jsp_string13 = ")</a></td>\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string35 = "</td>\r\n                <td width=\"22%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string39 = "\r\n              <tr> \r\n                <td align=\"center\" class=\"table_cell\">".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
