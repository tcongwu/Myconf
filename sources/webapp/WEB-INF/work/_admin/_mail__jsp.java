/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _admin;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.beans.*;
import org.myconf.dao.*;
import org.myconf.util.StringUtils;

public class _mail__jsp extends com.caucho.jsp.JavaPage{
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
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
if(conf==null)
	conf=new ConfigBean();

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
      pageContext.include("/admin/sub/mainmenu4.jsp");
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("error.star.not.null");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      _jsp_tag1.setKey("error.star.not.null");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      _jsp_tag1.setKey("error.star.not.null");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      _jsp_tag1.setKey("error.star.not.null");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      _jsp_tag1.setKey("error.port.must.integer");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/images/rounded_top.gif");
      int _jspEval21 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar22 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar22 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag3.setBundle("admin");
      }

      _jsp_tag3.setKey("menu.top.mail");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag2.setPage("/config.do");
      int _jspEval28 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar29 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar29 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag3.setKey("page.mail.ins1");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag3.setKey("page.mail.ins2");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag3.setKey("page.mail.ins3");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag3.setKey("page.mail.ins4");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      _jsp_tag1.setKey("common.textbox.email");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((StringUtils.exportString(conf.getEmail())));
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag3.setKey("common.title.email.pass");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((StringUtils.exportString(conf.getPass())));
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      _jsp_tag3.setKey("common.title.email.smtp");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      out.print((StringUtils.exportString(conf.getSmtp())));
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      _jsp_tag3.setKey("common.title.email.port");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      if(conf.getPort()==0){out.print(25);}else{out.print(conf.getPort());}
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      out.print((ConfigBean.TRUE));
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      out.print((ConfigBean.FALSE));
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      out.print((conf.getBySSL()));
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      if(conf.getBySSL()==ConfigBean.TRUE){out.print(" checked");}
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag3.setBundle("admin");
      }

      _jsp_tag3.setKey("page.mail.ins5");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag1.setKey("common.button.email.setting");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/admin/mailsend.jsp");
      int _jspEval62 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar63 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar63 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      _jsp_tag1.setKey("common.button.send.mail");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
      _jsp_tag3.setKey("common.text.email.service");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      _jsp_tag3.setKey("common.text.email.smtp");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      _jsp_tag3.setKey("common.text.email.port");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      _jsp_tag3.setKey("common.text.email.byssl");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
      _jsp_tag3.setKey("common.text.email.test.success");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      _jsp_tag3.setKey("common.text.email.recommend");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      _jsp_tag3.setKey("common.text.email.memo");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      _jsp_tag1.setKey("common.text.no");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      _jsp_tag1.setKey("common.text.yes");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      _jsp_tag2.setPage("/images/5.gif");
      int _jspEval96 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar97 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar97 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      _jsp_tag3.setKey("page.mail.memo.client");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
      _jsp_tag1.setKey("common.text.no");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      _jsp_tag1.setKey("common.text.yes");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      _jsp_tag2.setPage("/images/5.gif");
      int _jspEval109 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar110 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar110 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      _jsp_tag3.setKey("page.mail.memo.client");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string42, 0, _jsp_string42.length);
      _jsp_tag1.setKey("common.text.yes");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      _jsp_tag1.setKey("common.text.yes");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      _jsp_tag2.setPage("/images/1.gif");
      int _jspEval122 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar123 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar123 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string43, 0, _jsp_string43.length);
      _jsp_tag3.setKey("page.mail.memo.gmail");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string44, 0, _jsp_string44.length);
      _jsp_tag1.setKey("common.text.no");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      _jsp_tag1.setKey("common.text.yes");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      _jsp_tag2.setPage("/images/3.gif");
      int _jspEval135 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar136 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar136 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string45, 0, _jsp_string45.length);
      _jsp_tag3.setKey("page.mail.memo.client");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string46, 0, _jsp_string46.length);
      _jsp_tag1.setKey("common.text.no");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      _jsp_tag1.setKey("common.text.yes");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      _jsp_tag2.setPage("/images/3.gif");
      int _jspEval148 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar149 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar149 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string45, 0, _jsp_string45.length);
      _jsp_tag3.setKey("page.mail.memo.client");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string47, 0, _jsp_string47.length);
      _jsp_tag1.setKey("common.text.yes");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      _jsp_tag1.setKey("common.text.no");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string48, 0, _jsp_string48.length);
      _jsp_tag3.setKey("page.mail.memo.client");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string49, 0, _jsp_string49.length);
      _jsp_tag3.setKey("page.mail.memo.hotmail");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string50, 0, _jsp_string50.length);
      _jsp_tag3.setKey("page.mail.attention");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string51, 0, _jsp_string51.length);
      _jsp_tag2.setPage("/images/rounded_bottom.gif");
      int _jspEval170 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar171 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar171 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string52, 0, _jsp_string52.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string53, 0, _jsp_string53.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_mail__jsp.java", "/myconf/admin/mail.jsp");
    _caucho_line_map.add(17, 1);
    _caucho_line_map.add(1, 34);
    _caucho_line_map.add(6, 40);
    _caucho_line_map.add(7, 50);
    _caucho_line_map.add(8, 54);
    _caucho_line_map.add(13, 60);
    _caucho_line_map.add(25, 73);
    _caucho_line_map.add(32, 79);
    _caucho_line_map.add(37, 85);
    _caucho_line_map.add(40, 87);
    _caucho_line_map.add(45, 93);
    _caucho_line_map.add(46, 95);
    _caucho_line_map.add(47, 97);
    _caucho_line_map.add(52, 103);
    _caucho_line_map.add(57, 105);
    _caucho_line_map.add(62, 114);
    _caucho_line_map.add(67, 117);
    _caucho_line_map.add(72, 120);
    _caucho_line_map.add(77, 123);
    _caucho_line_map.add(88, 126);
    _caucho_line_map.add(95, 138);
    _caucho_line_map.add(99, 148);
    _caucho_line_map.add(106, 154);
    _caucho_line_map.add(107, 157);
    _caucho_line_map.add(108, 160);
    _caucho_line_map.add(109, 163);
    _caucho_line_map.add(116, 166);
    _caucho_line_map.add(117, 169);
    _caucho_line_map.add(123, 171);
    _caucho_line_map.add(124, 174);
    _caucho_line_map.add(129, 176);
    _caucho_line_map.add(130, 179);
    _caucho_line_map.add(135, 181);
    _caucho_line_map.add(136, 184);
    _caucho_line_map.add(142, 186);
    _caucho_line_map.add(151, 190);
    _caucho_line_map.add(152, 192);
    _caucho_line_map.add(153, 194);
    _caucho_line_map.add(158, 204);
    _caucho_line_map.add(159, 213);
    _caucho_line_map.add(159, 225);
    _caucho_line_map.add(173, 228);
    _caucho_line_map.add(174, 231);
    _caucho_line_map.add(175, 234);
    _caucho_line_map.add(176, 237);
    _caucho_line_map.add(177, 240);
    _caucho_line_map.add(178, 243);
    _caucho_line_map.add(179, 246);
    _caucho_line_map.add(185, 249);
    _caucho_line_map.add(186, 252);
    _caucho_line_map.add(187, 255);
    _caucho_line_map.add(188, 261);
    _caucho_line_map.add(194, 264);
    _caucho_line_map.add(195, 267);
    _caucho_line_map.add(196, 270);
    _caucho_line_map.add(197, 276);
    _caucho_line_map.add(203, 279);
    _caucho_line_map.add(204, 282);
    _caucho_line_map.add(205, 285);
    _caucho_line_map.add(206, 291);
    _caucho_line_map.add(212, 294);
    _caucho_line_map.add(213, 297);
    _caucho_line_map.add(214, 300);
    _caucho_line_map.add(215, 306);
    _caucho_line_map.add(221, 309);
    _caucho_line_map.add(222, 312);
    _caucho_line_map.add(223, 315);
    _caucho_line_map.add(224, 321);
    _caucho_line_map.add(230, 324);
    _caucho_line_map.add(231, 327);
    _caucho_line_map.add(233, 330);
    _caucho_line_map.add(242, 333);
    _caucho_line_map.add(247, 336);
    _caucho_line_map.add(255, 339);
    _caucho_line_map.add(259, 345);
    _caucho_line_map.add(264, 351);
    _caucho_line_map.add(269, 357);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("admin/mail.jsp"), 1180609302000L, 12786L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string30;
  private static byte []_jsp_string36;
  private static byte []_jsp_string40;
  private static byte []_jsp_string34;
  private static byte []_jsp_string14;
  private static byte []_jsp_string52;
  private static byte []_jsp_string25;
  private static byte []_jsp_string48;
  private static byte []_jsp_string1;
  private static byte []_jsp_string12;
  private static byte []_jsp_string37;
  private static byte []_jsp_string13;
  private static byte []_jsp_string42;
  private static byte []_jsp_string45;
  private static byte []_jsp_string53;
  private static byte []_jsp_string0;
  private static byte []_jsp_string8;
  private static byte []_jsp_string16;
  private static byte []_jsp_string3;
  private static byte []_jsp_string39;
  private static byte []_jsp_string4;
  private static byte []_jsp_string2;
  private static byte []_jsp_string5;
  private static byte []_jsp_string32;
  private static byte []_jsp_string27;
  private static byte []_jsp_string15;
  private static byte []_jsp_string47;
  private static byte []_jsp_string51;
  private static byte []_jsp_string28;
  private static byte []_jsp_string18;
  private static byte []_jsp_string20;
  private static byte []_jsp_string44;
  private static byte []_jsp_string46;
  private static byte []_jsp_string41;
  private static byte []_jsp_string26;
  private static byte []_jsp_string43;
  private static byte []_jsp_string33;
  private static byte []_jsp_string11;
  private static byte []_jsp_string24;
  private static byte []_jsp_string21;
  private static byte []_jsp_string31;
  private static byte []_jsp_string6;
  private static byte []_jsp_string29;
  private static byte []_jsp_string10;
  private static byte []_jsp_string35;
  private static byte []_jsp_string9;
  private static byte []_jsp_string19;
  private static byte []_jsp_string38;
  private static byte []_jsp_string49;
  private static byte []_jsp_string50;
  private static byte []_jsp_string22;
  private static byte []_jsp_string7;
  private static byte []_jsp_string23;
  private static byte []_jsp_string17;
  static {
    try {
      _jsp_string30 = "</td>\r\n            <td width=\"7%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string36 = "</td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string40 = "</td>\r\n            <td nowrap class=\"table_cell\">".getBytes("UTF8");
      _jsp_string34 = "</td>\r\n            <td width=\"29%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string14 = "</td>\r\n              <td class=\"form_row_content\"><input name=\"email\" type=\"text\" id=\"email\" size=\"50\" value=\"".getBytes("UTF8");
      _jsp_string52 = "\" width=\"778\" height=\"5\"></TD>\r\n    </TR>\r\n  </TBODY>\r\n</TABLE>\r\n".getBytes("UTF8");
      _jsp_string25 = "</td>\r\n            </tr>\r\n          </table>\r\n          <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n            <tr> \r\n              <td nowrap class=\"form_row_submit\"><input name=\"sub\" type=\"submit\" id=\"sub\" value=\"".getBytes("UTF8");
      _jsp_string48 = "</td>\r\n            <td nowrap class=\"table_cell\">-</td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string12 = "</li>\r\n                      <li>".getBytes("UTF8");
      _jsp_string37 = "</td>\r\n            <td class=\"table_cell\"><img src=\"".getBytes("UTF8");
      _jsp_string13 = "</li></td>\r\n                  </tr>\r\n                </table></td>\r\n            </tr>\r\n          </table>\r\n          <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n            <tr> \r\n              <td width=\"18%\" class=\"form_row_title\">*".getBytes("UTF8");
      _jsp_string42 = "</td>\r\n          </tr>\r\n          <tr valign=\"top\"> \r\n            <td nowrap class=\"table_cell\">gmail.com</td>\r\n            <td class=\"table_cell\">smtp.gmail.com</td>\r\n            <td class=\"table_cell\">465</td>\r\n            <td nowrap class=\"table_cell\">".getBytes("UTF8");
      _jsp_string45 = "\" width=\"37\" height=\"12\"></td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string53 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string8 = "\");\r\n		conf.port.select();\r\n		conf.port.focus();\r\n		return false;\r\n	}\r\n	return true;\r\n}\r\n</script>\r\n<TABLE width=778 height=\"84\" border=0 align=\"center\" cellPadding=0 cellSpacing=0 summary=null>\r\n  <TBODY>\r\n    <TR> \r\n      <TD noWrap width=778 colSpan=2 height=5><img src=\"".getBytes("UTF8");
      _jsp_string16 = "</td>\r\n              <td class=\"form_row_content\"><input name=\"pass\" type=\"password\" id=\"pass\" size=\"50\" value=\"".getBytes("UTF8");
      _jsp_string3 = "\r\n<br>\r\n<script language=\"JavaScript\">\r\nfunction checkForm(){\r\n	if (conf.email.value.length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string39 = "</td>\r\n          </tr>\r\n          <tr valign=\"top\"> \r\n            <td nowrap class=\"table_cell\">126.com</td>\r\n            <td class=\"table_cell\">smtp.126.com</td>\r\n            <td class=\"table_cell\">25</td>\r\n            <td nowrap class=\"table_cell\">".getBytes("UTF8");
      _jsp_string4 = "\");\r\n		conf.email.focus();\r\n		return false;\r\n	}\r\n	if (conf.pass.value.length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string5 = "\");\r\n		conf.pass.focus();\r\n		return false;\r\n	}\r\n	if (conf.smtp.value.length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string32 = "</td>\r\n            <td width=\"9%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string27 = "');\" value=\"".getBytes("UTF8");
      _jsp_string15 = "\">\r\n              </td>\r\n            </tr>\r\n          </table>\r\n          <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n            <tr> \r\n              <td width=\"18%\" class=\"form_row_title\">*".getBytes("UTF8");
      _jsp_string47 = "</td>\r\n          </tr>\r\n          <tr valign=\"top\"> \r\n            <td nowrap class=\"table_cell\">yahoo.com.cn</td>\r\n            <td class=\"table_cell\">smtp.mail.yahoo.com.cn</td>\r\n            <td class=\"table_cell\">465</td>\r\n            <td nowrap class=\"table_cell\">".getBytes("UTF8");
      _jsp_string51 = "</td>\r\n          </tr>\r\n        </table>\r\n        <br>\r\n      </TD>\r\n      <TD noWrap width=1 bgColor=#a9a9a9><SPACER type=\"block\" width=\"1\"></TD>\r\n    </TR>\r\n    <TR> \r\n      <TD noWrap width=778 colSpan=2 height=6><img src=\"".getBytes("UTF8");
      _jsp_string28 = "\"></td>\r\n            </tr>\r\n          </table>\r\n        </form>\r\n        \r\n        <table width=\"88%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n          <tr> \r\n            <td width=\"52%\"> <div class=\"spacer_20\"></div>\r\n              <div class=\"line_dashed\"></div>\r\n              <div class=\"spacer_10\"></div></td>\r\n          </tr>\r\n        </table>\r\n        <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n          <tr> \r\n            <td width=\"12%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string18 = "</td>\r\n              <td class=\"form_row_content\"><input name=\"smtp\" type=\"text\" id=\"smtp\" size=\"50\" value=\"".getBytes("UTF8");
      _jsp_string20 = "\"></td>\r\n            </tr>\r\n          </table>\r\n	      <script language=\"JavaScript\">\r\n			function check(obj){\r\n				if(obj.checked){\r\n					conf.bySSL.value=".getBytes("UTF8");
      _jsp_string44 = "</td>\r\n          </tr>\r\n          <tr valign=\"top\"> \r\n            <td nowrap class=\"table_cell\">sohu.com</td>\r\n            <td class=\"table_cell\">smtp.sohu.com</td>\r\n            <td class=\"table_cell\">25</td>\r\n            <td nowrap class=\"table_cell\">".getBytes("UTF8");
      _jsp_string46 = "</td>\r\n          </tr>\r\n          <tr valign=\"top\"> \r\n            <td nowrap class=\"table_cell\">sina.com</td>\r\n            <td class=\"table_cell\">smtp.sina.com</td>\r\n            <td class=\"table_cell\">25</td>\r\n            <td nowrap class=\"table_cell\">".getBytes("UTF8");
      _jsp_string41 = "</td>\r\n            <td nowrap class=\"table_cell\"><img src=\"".getBytes("UTF8");
      _jsp_string26 = "\"> \r\n              <input name=\"send\" type=\"button\" id=\"send\" onClick=\"window.open('".getBytes("UTF8");
      _jsp_string43 = "\" width=\"13\" height=\"12\"></td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string33 = "</td>\r\n            <td width=\"13%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string11 = "\" method=\"post\" onSubmit=\"return checkForm()\" name=\"conf\" id=\"conf\">\r\n          <input name=\"eventSubmit_Save\" type=\"hidden\" id=\"eventSubmit_Save\" value=\"0\">\r\n          <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"/admin/mail.jsp\">\r\n          <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n            <tr> \r\n              <td><table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n                  <tr> \r\n                    <td> <li>".getBytes("UTF8");
      _jsp_string24 = ">\r\n                ".getBytes("UTF8");
      _jsp_string21 = ";\r\n				}else{\r\n					conf.bySSL.value=".getBytes("UTF8");
      _jsp_string31 = "</td>\r\n            <td width=\"6%\" nowrap class=\"table_head\">".getBytes("UTF8");
      _jsp_string6 = "\");\r\n		conf.smtp.focus();\r\n		return false;\r\n	}\r\n	if (conf.port.value.length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string29 = "</td>\r\n            <td width=\"24%\" class=\"table_head\" nowrap>".getBytes("UTF8");
      _jsp_string10 = "</b></td>\r\n          </tr>\r\n        </table>\r\n        <br>\r\n        <form action=\"".getBytes("UTF8");
      _jsp_string35 = "</td>\r\n          </tr>\r\n          <tr valign=\"top\"> \r\n            <td class=\"table_cell\">163.com</td>\r\n            <td class=\"table_cell\">smtp.163.com</td>\r\n            <td class=\"table_cell\">25</td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string9 = "\" width=\"778\" height=\"5\"></TD>\r\n    </TR>\r\n    <TR> \r\n      <TD width=1 height=\"73\" noWrap bgColor=#a9a9a9><SPACER type=\"block\" width=\"1\"></TD>\r\n      <TD width=776 noWrap>\r\n		<table width=\"99%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n          <tr> \r\n            <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string19 = "</td>\r\n              <td class=\"form_row_content\"><input name=\"port\" type=\"text\" id=\"port\" size=\"10\" value=\"".getBytes("UTF8");
      _jsp_string38 = "\" width=\"61\" height=\"12\"></td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string49 = "</td>\r\n          </tr>\r\n          <tr valign=\"top\"> \r\n            <td nowrap class=\"table_cell\">hotmail.com</td>\r\n            <td class=\"table_cell\">-</td>\r\n            <td class=\"table_cell\">-</td>\r\n            <td nowrap class=\"table_cell\">-</td>\r\n            <td nowrap class=\"table_cell\">-</td>\r\n            <td nowrap class=\"table_cell\">-</td>\r\n            <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string50 = "</td>\r\n          </tr>\r\n        </table>\r\n        <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n          <tr>\r\n            <td height=\"21\" class=\"blackbold\">".getBytes("UTF8");
      _jsp_string22 = ";\r\n				}\r\n			}\r\n		  </script>\r\n          <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n            <tr> \r\n              <td class=\"form_row_content\">\r\n				<input name=\"bySSL\" type=\"hidden\" id=\"bySSL\" value=\"".getBytes("UTF8");
      _jsp_string7 = "\");\r\n		conf.port.focus();\r\n		return false;\r\n	}\r\n	if (!isRange(trim(conf.port.value), \"0123456789\")) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string23 = "\">\r\n				<input name=\"chk\" type=\"checkbox\" onClick=\"check(this)\" id=\"chk\" value=\"1\"".getBytes("UTF8");
      _jsp_string17 = "\"></td>\r\n            </tr>\r\n          </table>\r\n          <table width=\"88%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n            <tr> \r\n              <td width=\"18%\" class=\"form_row_title\">*".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}
