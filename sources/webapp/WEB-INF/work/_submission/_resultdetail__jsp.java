/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _submission;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.*;
import org.myconf.dao.*;
import org.myconf.beans.*;
import org.myconf.util.*;
import java.util.*;
import org.apache.commons.beanutils.*;

public class _resultdetail__jsp extends com.caucho.jsp.JavaPage{
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
        _jsp_tag0.setModule("author");
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
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//variable
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);

//paper data
PaperBean paper=PaperDAO.getPaper(RequestUtils.getParam(request, "id", 0));
if(paper==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

//paper reviews
List reviews=paper.getReviews();
ReviewBean review=null;

//review refer list
List refers=ReferDAO.list();
ReferBean refer=null;
if(refers==null || refers.size()==0){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}

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
      pageContext.include("/inc/logo_author.jsp");
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

      _jsp_tag1.setKey("common.title.expert.review");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      if(conf!=null && conf.getIsProcess()==ConfigBean.TRUE && conf.getIsOpen()==ConfigBean.TRUE){
      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      
		        if(reviews!=null && reviews.size()>0){
		          for(int i=0;i<reviews.size();i++){
		          	review=(ReviewBean)reviews.get(i);
		          	if(review.getStatus()!=ReviewBean.REVIEW_STATUS_QUIT){
		      
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag2.setBundle("admin");
        _jsp_tag2.setKey("common.title.expert");
      }

      _jsp_tag2.setArg0(String.valueOf(i+1));
      _jsp_tag2.doStartTag();
      out.print((StringUtils.exportString(review.getExpertName())));
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      if(review.getStatus()==ReviewBean.REVIEW_STATUS_FINISH){
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      
                  for(int j=0;j<refers.size();j++){
                  	refer=(ReferBean)refers.get(j);
                
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      out.print((refer.getReferNo()));
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      out.print((refer.getTitle()));
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      out.print((PropertyUtils.getSimpleProperty(review, "score"+refer.getReferNo())));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      }
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.title.suggest.result");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      out.print((StringUtils.exportString(StatusDAO.getStatusInMap(review.getRecoStatus()))));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      if(StringUtils.isNotEmpty(review.getOpinion())){
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("admin");
      }

      _jsp_tag1.setKey("common.title.review.opnion");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      out.print((review.getOpinion()));
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      }
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      }else{
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.ins.review.not.finished");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      }
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      }}
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      }else{
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.text.norecord");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      }
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag3.setKey("common.button.closewindow");
      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      }
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//*********************************
//end content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      
//**********************************
//footer
//**********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/footer.jsp");
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_resultdetail__jsp.java", "/myconf/submission/resultdetail.jsp");
    _caucho_line_map.add(20, 1);
    _caucho_line_map.add(1, 37);
    _caucho_line_map.add(6, 43);
    _caucho_line_map.add(7, 53);
    _caucho_line_map.add(8, 57);
    _caucho_line_map.add(13, 63);
    _caucho_line_map.add(28, 79);
    _caucho_line_map.add(50, 100);
    _caucho_line_map.add(55, 106);
    _caucho_line_map.add(58, 108);
    _caucho_line_map.add(63, 114);
    _caucho_line_map.add(64, 116);
    _caucho_line_map.add(72, 122);
    _caucho_line_map.add(78, 132);
    _caucho_line_map.add(85, 134);
    _caucho_line_map.add(98, 141);
    _caucho_line_map.add(98, 151);
    _caucho_line_map.add(101, 155);
    _caucho_line_map.add(107, 162);
    _caucho_line_map.add(108, 164);
    _caucho_line_map.add(113, 168);
    _caucho_line_map.add(114, 178);
    _caucho_line_map.add(118, 192);
    _caucho_line_map.add(121, 196);
    _caucho_line_map.add(125, 207);
    _caucho_line_map.add(128, 211);
    _caucho_line_map.add(131, 213);
    _caucho_line_map.add(134, 222);
    _caucho_line_map.add(137, 224);
    _caucho_line_map.add(147, 235);
    _caucho_line_map.add(152, 241);
    _caucho_line_map.add(157, 247);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("submission/resultdetail.jsp"), 1180699160800L, 6004L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string4;
  private static byte []_jsp_string14;
  private static byte []_jsp_string13;
  private static byte []_jsp_string6;
  private static byte []_jsp_string22;
  private static byte []_jsp_string1;
  private static byte []_jsp_string17;
  private static byte []_jsp_string15;
  private static byte []_jsp_string24;
  private static byte []_jsp_string0;
  private static byte []_jsp_string8;
  private static byte []_jsp_string18;
  private static byte []_jsp_string19;
  private static byte []_jsp_string5;
  private static byte []_jsp_string7;
  private static byte []_jsp_string10;
  private static byte []_jsp_string3;
  private static byte []_jsp_string11;
  private static byte []_jsp_string20;
  private static byte []_jsp_string12;
  private static byte []_jsp_string21;
  private static byte []_jsp_string9;
  private static byte []_jsp_string16;
  private static byte []_jsp_string23;
  private static byte []_jsp_string2;
  static {
    try {
      _jsp_string4 = "</span></td>\r\n    <td width=\"310\" style=\"PADDING-TOP: 2px;\" align=\"right\" class=\"channel_bar_bg\">&nbsp; \r\n      </td>\r\n    <td width=\"10\" class=\"channel_bar_right\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string14 = "</td>\r\n                  <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string13 = "\r\n                <tr> \r\n                  <td align=\"center\" nowrap class=\"table_cell\">--</td>\r\n                  <td class=\"table_cell\">".getBytes("UTF8");
      _jsp_string6 = "\r\n              <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n                <tr>\r\n                  <td>&nbsp;</td>\r\n                </tr>\r\n              </table> \r\n              <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"3\" cellspacing=\"1\" class=\"table\">\r\n                <tr> \r\n                  <td colspan=\"3\" nowrap class=\"table_head\"><strong>".getBytes("UTF8");
      _jsp_string22 = "\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n                <tr> \r\n                  <td align=\"center\" height=\"58\" nowrap><input name=\"close\" type=\"button\" id=\"close\" style=\"width:130px;height:24px;\" onClick=\"window.close()\" value=\"".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string17 = "\r\n                <tr> \r\n                  <td colspan=\"3\" align=\"center\" class=\"table_cell\"><strong style=\"color:red\">".getBytes("UTF8");
      _jsp_string15 = "\r\n                <tr> \r\n                  <td colspan=\"3\" class=\"table_cell\"> <strong>".getBytes("UTF8");
      _jsp_string24 = "\r\n</body>\r\n</html>".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string8 = "\r\n                ".getBytes("UTF8");
      _jsp_string18 = "\r\n              </table>\r\n              ".getBytes("UTF8");
      _jsp_string19 = "\r\n              ".getBytes("UTF8");
      _jsp_string5 = "\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n    <td valign=\"top\" class=\"pagecontent\">\r\n        <table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n          <tr> \r\n            <td class=\"form_row_content_author\">\r\n		      ".getBytes("UTF8");
      _jsp_string7 = "</strong></td>\r\n                </tr>\r\n                ".getBytes("UTF8");
      _jsp_string10 = "</td>\r\n                  <td width=\"55%\" class=\"table_cell\">".getBytes("UTF8");
      _jsp_string3 = "\r\n<table width=\"778\" height=\"31\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n  <tr> \r\n    <td width=\"10\" class=\"channel_bar_left\">&nbsp;</td>\r\n    <td width=\"448\" class=\"channel_bar_bg\"><span class=\"bartitle\">&nbsp;".getBytes("UTF8");
      _jsp_string11 = "</td>\r\n                  <td width=\"36%\" class=\"table_cell\">".getBytes("UTF8");
      _jsp_string20 = "\r\n              <table width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\">\r\n                <tr> \r\n                  <td align=\"center\" class=\"blackbold\" nowrap>".getBytes("UTF8");
      _jsp_string12 = "</td>\r\n                </tr>\r\n                ".getBytes("UTF8");
      _jsp_string21 = "</td>\r\n                </tr>\r\n              </table>\r\n              ".getBytes("UTF8");
      _jsp_string9 = "\r\n                <tr> \r\n                  <td width=\"9%\" align=\"center\" class=\"table_cell\">".getBytes("UTF8");
      _jsp_string16 = "</strong>".getBytes("UTF8");
      _jsp_string23 = "\"></td>\r\n                </tr>\r\n              </table>\r\n            </td>\r\n          </tr>\r\n        </table>\r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string2 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}