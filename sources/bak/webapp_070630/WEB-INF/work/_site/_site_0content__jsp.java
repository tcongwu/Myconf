/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _site;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.dao.ContentDAO;
import org.myconf.dao.LangDAO;
import org.myconf.beans.ContentBean;
import org.myconf.beans.LangBean;
import org.myconf.util.StringUtils;
import java.util.*;

public class _site_0content__jsp extends com.caucho.jsp.JavaPage{
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
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//security
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      if (_jsp_tag0 == null) {
        _jsp_tag0 = new org.myconf.AuthTag();
        _jsp_tag0.setPageContext(pageContext);
        _jsp_tag0.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag0.setModule("site");
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
      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/site/site_contentinfo.jsp?contentId=");
      int _jspEval6 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar7 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar7 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      
	String key=(String) session.getAttribute("key");
	String languange=(String) session.getAttribute("version");
	if(key==null||languange==null){
	

      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("site");
      }

      _jsp_tag2.setKey("page.site.setting_sessionout");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/site/index.jsp");
      int _jspEval13 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar14 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar14 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      	
	return;
	 
	}else{


      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      
	int langId=1;
	if(languange.equals("zh_cn")){langId=LangBean.LANG_ZH_CN;}
	if(languange.equals("zh_tw")){langId=LangBean.LANG_ZH_TW;}
	if(languange.equals("english")){langId=LangBean.LANG_ENGLISH;}
	LangBean lang=LangDAO.getLang(langId);
	List clist=ContentDAO.getContentByVersion(lang);
	boolean isAdd=false;
	if(lang!=null){isAdd=true;}
	
	


      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      
//*********************************
//head
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/head.jsp");
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      
//*********************************
//top
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/top.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/logo_site.jsp");
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      
//*********************************
//content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/site/sub/mainmenu1.jsp");
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      pageContext.include("/site/sub/leftmenu1.jsp");
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      pageContext.include("/inc/stat.jsp");
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("site");
      }

      _jsp_tag2.setKey("page.site.contentm");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag2.setKey(key);
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag2.setKey("page.site.content_point1");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      _jsp_tag2.setKey("page.site.menu_point2");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if(isAdd==false){
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/images/rounded_top.gif");
      int _jspEval29 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar30 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar30 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("site");
      }

      _jsp_tag2.setKey("page.site.content_must");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      _jsp_tag1.setPage("/images/rounded_bottom.gif");
      int _jspEval36 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar37 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar37 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      }else{
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("site");
      }

      _jsp_tag2.setKey("page.site.content_title");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      _jsp_tag2.setKey("page.site.menu_published0");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      _jsp_tag2.setKey("page.site.menu_edit");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      _jsp_tag2.setKey("page.site.menu_delete");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      
				   	if(clist!=null&&clist.size()>0){
				   		for(int i=0;i<clist.size();i++){
				   			ContentBean cbean=(ContentBean)clist.get(i);
				   			
				   			
				   		
				   
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      out.print((cbean.getId()));
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      out.print((StringUtils.exportString(cbean.getTitle())));
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      if(cbean.getPublished()==1){
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("site");
      }

      _jsp_tag2.setKey("page.site.content_updatestatus");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/content.do?eventSubmit_UpdateStatus&id=");
      int _jspEval55 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar56 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar56 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((cbean.getId()));
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      _jsp_tag2.setKey("page.site.menu_published1");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      }else{
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("site");
      }

      _jsp_tag2.setKey("page.site.content_updatestatus");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/content.do?eventSubmit_UpdateStatus&id=");
      int _jspEval65 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar66 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar66 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((cbean.getId()));
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      _jsp_tag2.setKey("page.site.menu_published2");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      }
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/site/site_contentedit.jsp");
      int _jspEval72 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar73 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar73 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      out.print(((cbean.getId())));
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      _jsp_tag1.setPage("/images/sub_edit.gif");
      int _jspEval76 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar77 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar77 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag3.setKey("ins.confirm.delete");
      }

      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      _jsp_tag1.setPage("/content.do?eventSubmit_Delete&id=");
      int _jspEval83 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar84 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar84 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.print((cbean.getId()));
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      _jsp_tag1.setPage("/images/sub_del.gif");
      int _jspEval87 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar88 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar88 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      
						}
					}
				 	
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setPage("/site/site_contentadd.jsp");
      int _jspEval91 = _jsp_tag1.doStartTag();
      int _jsp_endTagVar92 = _jsp_tag1.doEndTag();
      if (_jsp_endTagVar92 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("site");
      }

      _jsp_tag2.setKey("page.site.content_add");
      _jsp_tag2.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      }
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string42, 0, _jsp_string42.length);
      }
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
    _caucho_line_map = new com.caucho.java.LineMap("_site_0content__jsp.java", "/myconf/site/site_content.jsp");
    _caucho_line_map.add(21, 1);
    _caucho_line_map.add(2, 38);
    _caucho_line_map.add(7, 44);
    _caucho_line_map.add(8, 54);
    _caucho_line_map.add(9, 58);
    _caucho_line_map.add(14, 64);
    _caucho_line_map.add(26, 74);
    _caucho_line_map.add(29, 86);
    _caucho_line_map.add(37, 103);
    _caucho_line_map.add(42, 115);
    _caucho_line_map.add(64, 136);
    _caucho_line_map.add(69, 142);
    _caucho_line_map.add(72, 144);
    _caucho_line_map.add(77, 150);
    _caucho_line_map.add(78, 152);
    _caucho_line_map.add(85, 160);
    _caucho_line_map.add(92, 162);
    _caucho_line_map.add(93, 164);
    _caucho_line_map.add(100, 166);
    _caucho_line_map.add(101, 176);
    _caucho_line_map.add(114, 179);
    _caucho_line_map.add(115, 182);
    _caucho_line_map.add(119, 185);
    _caucho_line_map.add(124, 187);
    _caucho_line_map.add(133, 199);
    _caucho_line_map.add(142, 209);
    _caucho_line_map.add(146, 215);
    _caucho_line_map.add(150, 217);
    _caucho_line_map.add(151, 227);
    _caucho_line_map.add(152, 230);
    _caucho_line_map.add(153, 233);
    _caucho_line_map.add(165, 247);
    _caucho_line_map.add(166, 249);
    _caucho_line_map.add(166, 251);
    _caucho_line_map.add(166, 261);
    _caucho_line_map.add(166, 272);
    _caucho_line_map.add(166, 274);
    _caucho_line_map.add(166, 277);
    _caucho_line_map.add(166, 279);
    _caucho_line_map.add(166, 289);
    _caucho_line_map.add(166, 300);
    _caucho_line_map.add(166, 302);
    _caucho_line_map.add(166, 305);
    _caucho_line_map.add(167, 307);
    _caucho_line_map.add(167, 319);
    _caucho_line_map.add(167, 321);
    _caucho_line_map.add(168, 327);
    _caucho_line_map.add(168, 336);
    _caucho_line_map.add(168, 341);
    _caucho_line_map.add(168, 343);
    _caucho_line_map.add(170, 349);
    _caucho_line_map.add(179, 354);
    _caucho_line_map.add(179, 366);
    _caucho_line_map.add(182, 376);
    _caucho_line_map.add(190, 378);
    _caucho_line_map.add(195, 384);
    _caucho_line_map.add(200, 390);
    _caucho_line_map.add(203, 392);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("site/site_content.jsp"), 1180792094000L, 7889L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string4;
  private static byte []_jsp_string10;
  private static byte []_jsp_string39;
  private static byte []_jsp_string7;
  private static byte []_jsp_string14;
  private static byte []_jsp_string28;
  private static byte []_jsp_string22;
  private static byte []_jsp_string15;
  private static byte []_jsp_string3;
  private static byte []_jsp_string1;
  private static byte []_jsp_string16;
  private static byte []_jsp_string41;
  private static byte []_jsp_string33;
  private static byte []_jsp_string0;
  private static byte []_jsp_string13;
  private static byte []_jsp_string11;
  private static byte []_jsp_string20;
  private static byte []_jsp_string40;
  private static byte []_jsp_string12;
  private static byte []_jsp_string30;
  private static byte []_jsp_string23;
  private static byte []_jsp_string8;
  private static byte []_jsp_string36;
  private static byte []_jsp_string18;
  private static byte []_jsp_string37;
  private static byte []_jsp_string27;
  private static byte []_jsp_string9;
  private static byte []_jsp_string25;
  private static byte []_jsp_string19;
  private static byte []_jsp_string17;
  private static byte []_jsp_string21;
  private static byte []_jsp_string32;
  private static byte []_jsp_string24;
  private static byte []_jsp_string26;
  private static byte []_jsp_string29;
  private static byte []_jsp_string31;
  private static byte []_jsp_string38;
  private static byte []_jsp_string35;
  private static byte []_jsp_string2;
  private static byte []_jsp_string42;
  private static byte []_jsp_string6;
  private static byte []_jsp_string5;
  private static byte []_jsp_string34;
  static {
    try {
      _jsp_string4 = "\");\r\n	window.location.href=\"".getBytes("UTF8");
      _jsp_string10 = "\r\n		   ".getBytes("UTF8");
      _jsp_string39 = "'\"  class=\"button\" value=\"".getBytes("UTF8");
      _jsp_string7 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string14 = "</li>\r\n                  <li>".getBytes("UTF8");
      _jsp_string28 = "')\" href=\"".getBytes("UTF8");
      _jsp_string22 = "</td>\r\n					   <td width=\"10%\" align=\"center\" nowrap>".getBytes("UTF8");
      _jsp_string15 = "</li>\r\n        		<div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n       ".getBytes("UTF8");
      _jsp_string3 = "\r\n<script languange=\"javascript\">\r\n	alert(\"".getBytes("UTF8");
      _jsp_string1 = "\r\n<script language=\"JavaScript\">\r\nfunction contentInfo(contentId) {\r\n	window.open(\"".getBytes("UTF8");
      _jsp_string16 = "      \r\n            <br>\r\n            <TABLE width=80% height=\"84\" border=0 align=\"center\" cellPadding=0 cellSpacing=0 summary=null>\r\n				  <TBODY>\r\n				    <TR> \r\n				      <TD noWrap width=80% colSpan=2 height=5><img width=\"600\" src=\"".getBytes("UTF8");
      _jsp_string41 = "          \r\n            </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n<div class=\"spacer_20\"></div>\r\n".getBytes("UTF8");
      _jsp_string33 = "</td>\r\n					   <td width=\"10%\" align=\"center\" nowrap title=\"edit\"><a href=\"".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string13 = "</b></td>\r\n        </tr>\r\n        <tr >\r\n          <td align=\"right\"  colspan=\"2\" height=\"5\">\r\n          	&nbsp;\r\n          </td>		\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
      _jsp_string11 = "\r\n		  </td>\r\n        </tr>\r\n      </table></td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n	\r\n        <tr>\r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string20 = "         \r\n         \r\n              <table width=\"100%\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n					<tr class=\"table_head\"> \r\n					  <td width=\"40%\" nowrap>".getBytes("UTF8");
      _jsp_string40 = "\">\r\n                  </td></tr>\r\n              </table>\r\n    ".getBytes("UTF8");
      _jsp_string12 = "</b></td>\r\n		  <td class=\"site_version\" align=\"right\"><b>".getBytes("UTF8");
      _jsp_string30 = "</a>".getBytes("UTF8");
      _jsp_string23 = "</td>\r\n				    </tr>\r\n				    \r\n				   ".getBytes("UTF8");
      _jsp_string8 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string36 = "\" width=\"21\" height=\"21\" border=\"0\"></a> </td>\r\n					   <td width=\"10%\" align=\"center\" nowrap title=\"delete\"><a onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string18 = "</TD>\r\n				            </TR>\r\n				          </TBODY>\r\n				        </TABLE>\r\n				       \r\n				      </TD>\r\n				      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type=\"block\" width=\"1\"></TD>\r\n				    </TR>\r\n				    <TR> \r\n				      <TD noWrap width=80% colSpan=2 height=6><img width=\"600\" src=\"".getBytes("UTF8");
      _jsp_string37 = "\" width=\"21\" height=\"21\" border=\"0\"></a></td>\r\n				    </tr>\r\n					".getBytes("UTF8");
      _jsp_string27 = "<a onClick=\"return confirm('".getBytes("UTF8");
      _jsp_string9 = "\r\n\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td width=\"180\" height=\"55\" valign=\"top\"><table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n		   ".getBytes("UTF8");
      _jsp_string25 = ")\">".getBytes("UTF8");
      _jsp_string19 = "\"  height=\"5\"></TD>\r\n				    </TR>\r\n				  </TBODY>\r\n				</TABLE>\r\n 	 ".getBytes("UTF8");
      _jsp_string17 = "\"  height=\"5\"></TD>\r\n				    </TR>\r\n				    <TR> \r\n				      <TD width=1 height=\"73\" noWrap bgColor=#a9a9a9><SPACER type=\"block\" width=\"1\"></TD>\r\n				      <TD width=80% noWrap>\r\n				      	\r\n				      	<TABLE width=80% border=0 align=\"center\" cellPadding=5 cellSpacing=0>\r\n				          <TBODY>\r\n				            <TR> \r\n				              <TD align=\"center\" style=\"font-size:16px;\" class=\"redins\">".getBytes("UTF8");
      _jsp_string21 = "</td>\r\n					  <td width=\"15%\" align=\"center\" nowrap>".getBytes("UTF8");
      _jsp_string32 = " </a> ".getBytes("UTF8");
      _jsp_string24 = " \r\n					<tr class=\"table_cell\"> \r\n					  <td width=\"40%\" nowrap><a href=\"#\" onclick=\"javascript:contentInfo(".getBytes("UTF8");
      _jsp_string26 = "</a></td>\r\n					  <td width=\"15%\" align=\"center\" nowrap title=\"change published status\">".getBytes("UTF8");
      _jsp_string29 = "\">".getBytes("UTF8");
      _jsp_string31 = "&published=do\">".getBytes("UTF8");
      _jsp_string38 = "	\r\n					\r\n				</table>\r\n			\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\r\n                <tr> \r\n                  <td class=\"form_row_submit\"> <input name=\"Submit\" type=\"button\" onclick=\"window.location.href='".getBytes("UTF8");
      _jsp_string35 = "\"><img src=\"".getBytes("UTF8");
      _jsp_string2 = "\"+contentId, \"contentInfo\", \"resizable=no,scrollbars=yes,height=600,width=800\");\r\n}\r\n</script>\r\n".getBytes("UTF8");
      _jsp_string42 = "\r\n</body>\r\n</html>\r\n".getBytes("UTF8");
      _jsp_string6 = "\r\n\r\n".getBytes("UTF8");
      _jsp_string5 = "\"\r\n\r\n</script>\r\n\r\n\r\n".getBytes("UTF8");
      _jsp_string34 = "?cid=".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}