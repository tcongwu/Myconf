/*
 * JSP generated by Resin 2.1.16 (built Tue Feb 15 11:12:27 PST 2005)
 */

package _site;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.myconf.Globals;
import org.myconf.beans.*;
import org.myconf.dao.*;
import org.myconf.util.StringUtils;

public class _site_0setting__jsp extends com.caucho.jsp.JavaPage{
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
        _jsp_tag0.setModule("site");
      }

      _jsp_tag0.doStartTag();
      _jsp_tag0.setBodyContent(null);
      int _jsp_endTagVar3 = _jsp_tag0.doEndTag();
      if (_jsp_endTagVar3 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      
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

      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      
	String key=(String) session.getAttribute("key");
	String languange=(String) session.getAttribute("version");
	if(key==null||languange==null){
	

      pageContext.write(_jsp_string2, 0, _jsp_string2.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_sessionout");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string3, 0, _jsp_string3.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/site/index.jsp");
      int _jspEval9 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar10 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar10 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string4, 0, _jsp_string4.length);
      	
	return;
	 
	}else{


      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      

	int langcount=LangDAO.getLangCount();
	int langId=1;
	int isdefault=1;
	if(langcount>=1) {
		isdefault=LangBean.LANG_ISDEDAULT_NOT;
		}
	else
		{
		isdefault=LangBean.LANG_ISDEDAULT;
		}
		
	if(languange.equals("zh_cn")){
		langId=LangBean.LANG_ZH_CN;
		}
	else if(languange.equals("zh_tw")){
		langId=LangBean.LANG_ZH_TW;
		
		}
	else if(languange.equals("english")){
		langId=LangBean.LANG_ENGLISH;
		
		}
	
				
	LangBean lbean=LangDAO.getLangByID(langId);
	ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
	if(lbean!=null){
		if(lbean.getIsDefault()==1||lbean.getIsDefault()==2)
			isdefault=lbean.getIsDefault();
	}
	


      pageContext.write(_jsp_string5, 0, _jsp_string5.length);
      
//*********************************
//head
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/head.jsp");
      pageContext.write(_jsp_string6, 0, _jsp_string6.length);
      
//*********************************
//top
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/top.jsp");
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/inc/logo_site.jsp");
      pageContext.write(_jsp_string1, 0, _jsp_string1.length);
      
//*********************************
//content
//*********************************

      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
      pageContext.include("/site/sub/mainmenu1.jsp");
      pageContext.write(_jsp_string7, 0, _jsp_string7.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_uploadfile_notnull");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string8, 0, _jsp_string8.length);
      _jsp_tag1.setKey("page.site.setting_banner_filetype");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string9, 0, _jsp_string9.length);
      _jsp_tag1.setKey("page.site.setting_name_notnull");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string10, 0, _jsp_string10.length);
      _jsp_tag1.setKey("page.site.setting_shortname_notnull");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string11, 0, _jsp_string11.length);
      _jsp_tag1.setKey("page.site.setting_copyright_notnull");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string12, 0, _jsp_string12.length);
      _jsp_tag1.setKey("page.site.setting_email_notnull");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string13, 0, _jsp_string13.length);
      pageContext.include("/site/sub/leftmenu1.jsp");
      pageContext.write(_jsp_string14, 0, _jsp_string14.length);
      pageContext.include("/inc/stat.jsp");
      pageContext.write(_jsp_string15, 0, _jsp_string15.length);
      _jsp_tag1.setKey("page.site.submenu7");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string16, 0, _jsp_string16.length);
      _jsp_tag1.setKey(key);
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string17, 0, _jsp_string17.length);
      _jsp_tag1.setKey("page.site.setting_point1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string18, 0, _jsp_string18.length);
      _jsp_tag1.setKey("page.site.setting_point2");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string19, 0, _jsp_string19.length);
      _jsp_tag1.setKey("page.site.setting_point3");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string20, 0, _jsp_string20.length);
      if (_jsp_tag2 == null) {
        _jsp_tag2 = new org.apache.struts.taglib.html.RewriteTag();
        _jsp_tag2.setPageContext(pageContext);
        _jsp_tag2.setParent((javax.servlet.jsp.tagext.Tag) null);
      }

      _jsp_tag2.setPage("/lang.do");
      int _jspEval46 = _jsp_tag2.doStartTag();
      int _jsp_endTagVar47 = _jsp_tag2.doEndTag();
      if (_jsp_endTagVar47 == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      pageContext.write(_jsp_string21, 0, _jsp_string21.length);
      out.print((languange));
      pageContext.write(_jsp_string22, 0, _jsp_string22.length);
      out.print((isdefault));
      pageContext.write(_jsp_string23, 0, _jsp_string23.length);
      _jsp_tag1.setKey("page.site.setting_name");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string24, 0, _jsp_string24.length);
       if(lbean!=null){out.println(StringUtils.exportString(lbean.getConfName()));}
      pageContext.write(_jsp_string25, 0, _jsp_string25.length);
       if(lbean!=null){ if(StringUtils.exportString(lbean.getShow1()+"").equals("1")){out.println("checked");}}
      pageContext.write(_jsp_string26, 0, _jsp_string26.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_showbanner");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string27, 0, _jsp_string27.length);
      _jsp_tag1.setKey("page.site.setting_shortname");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string28, 0, _jsp_string28.length);
       if(lbean!=null){out.println(StringUtils.exportString(lbean.getShortName()));}
      pageContext.write(_jsp_string29, 0, _jsp_string29.length);
      if(lbean!=null){ if(StringUtils.exportString(lbean.getShow2()+"").equals("1")){out.println("checked");}}
      pageContext.write(_jsp_string30, 0, _jsp_string30.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_showbanner");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string31, 0, _jsp_string31.length);
      _jsp_tag1.setKey("page.site.setting_copyright");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string32, 0, _jsp_string32.length);
       if(lbean!=null){out.println(StringUtils.exportString(lbean.getCopyright()));}
      pageContext.write(_jsp_string33, 0, _jsp_string33.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_email");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string34, 0, _jsp_string34.length);
      if(lbean!=null){out.println(StringUtils.exportString(lbean.getEmail()));}
      pageContext.write(_jsp_string35, 0, _jsp_string35.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_save");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string36, 0, _jsp_string36.length);
      if (_jsp_tag3 == null) {
        _jsp_tag3 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag3.setPageContext(pageContext);
        _jsp_tag3.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag3.setKey("common.button.save.and.next");
      }

      _jsp_tag3.doStartTag();
      pageContext.write(_jsp_string37, 0, _jsp_string37.length);
      _jsp_tag1.setKey("page.site.setting_savenext");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string38, 0, _jsp_string38.length);
      
			
			
			if(lbean!=null){
					
				
			
      pageContext.write(_jsp_string39, 0, _jsp_string39.length);
      out.print((request.getContextPath()));
      pageContext.write(_jsp_string40, 0, _jsp_string40.length);
      if (_jsp_tag1 == null) {
        _jsp_tag1 = new org.apache.struts.taglib.bean.MessageTag();
        _jsp_tag1.setPageContext(pageContext);
        _jsp_tag1.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_tag1.setBundle("site");
      }

      _jsp_tag1.setKey("page.site.setting_banner");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string41, 0, _jsp_string41.length);
      _jsp_tag1.setKey("page.site.content_attachadd");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string42, 0, _jsp_string42.length);
      _jsp_tag1.setKey("page.site.setting_banner_size1");
      _jsp_tag1.doStartTag();
      pageContext.write(_jsp_string43, 0, _jsp_string43.length);
      		
			  	 StringBuffer sb=new StringBuffer();
			  	 String img="";
			  	 String temp="";
			  	 String temproot="";
			  	 img=(String)request.getAttribute("upload_image_uri");
			  	 if(conf!=null){
			  			img=StringUtils.exportString(conf.getBanner());
			  			
					}		
			 			 
			  if(img.equals(""))	{	
				temp=StringUtils.exportString(lbean.getTemplate());
				if(temp.equals("")) temp=Globals.TEMPLATE_DEFAUT;
				temproot=sb.append(request.getContextPath()).append("/").append("site").append("/").append("template").append("/").append(temp).append("/").append("images").append("/").append("banner.jpg").toString();
			  	img=temproot;	
			  	}
			  	
			  
      pageContext.write(_jsp_string44, 0, _jsp_string44.length);
      out.print((img));
      pageContext.write(_jsp_string45, 0, _jsp_string45.length);
      if(temp.equals("fall")||temp.equals("soar")){
      pageContext.write(_jsp_string46, 0, _jsp_string46.length);
      }else{
      pageContext.write(_jsp_string47, 0, _jsp_string47.length);
      }
      pageContext.write(_jsp_string48, 0, _jsp_string48.length);
      if(lbean!=null){if(lbean.getShow2()==1){out.println(StringUtils.exportString(lbean.getShortName()));}}
      pageContext.write(_jsp_string49, 0, _jsp_string49.length);
      if(temp.equals("fall")||temp.equals("soar")){
      pageContext.write(_jsp_string46, 0, _jsp_string46.length);
      }else{
      pageContext.write(_jsp_string47, 0, _jsp_string47.length);
      }
      pageContext.write(_jsp_string50, 0, _jsp_string50.length);
      if(lbean!=null){if(lbean.getShow1()==1){out.println(StringUtils.exportString(lbean.getConfName()));}}
      pageContext.write(_jsp_string51, 0, _jsp_string51.length);
      
			}
			
			
				
			
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
      }
      pageContext.write(_jsp_string0, 0, _jsp_string0.length);
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
    _caucho_line_map = new com.caucho.java.LineMap("_site_0setting__jsp.java", "/myconf/site/site_setting.jsp");
    _caucho_line_map.add(19, 1);
    _caucho_line_map.add(1, 35);
    _caucho_line_map.add(6, 41);
    _caucho_line_map.add(7, 51);
    _caucho_line_map.add(9, 55);
    _caucho_line_map.add(14, 61);
    _caucho_line_map.add(36, 92);
    _caucho_line_map.add(41, 104);
    _caucho_line_map.add(47, 111);
    _caucho_line_map.add(84, 147);
    _caucho_line_map.add(89, 153);
    _caucho_line_map.add(92, 155);
    _caucho_line_map.add(97, 161);
    _caucho_line_map.add(98, 163);
    _caucho_line_map.add(105, 171);
    _caucho_line_map.add(122, 173);
    _caucho_line_map.add(145, 186);
    _caucho_line_map.add(151, 189);
    _caucho_line_map.add(157, 192);
    _caucho_line_map.add(163, 195);
    _caucho_line_map.add(179, 198);
    _caucho_line_map.add(180, 200);
    _caucho_line_map.add(188, 202);
    _caucho_line_map.add(189, 205);
    _caucho_line_map.add(205, 208);
    _caucho_line_map.add(206, 211);
    _caucho_line_map.add(207, 214);
    _caucho_line_map.add(212, 217);
    _caucho_line_map.add(213, 229);
    _caucho_line_map.add(214, 231);
    _caucho_line_map.add(219, 233);
    _caucho_line_map.add(221, 236);
    _caucho_line_map.add(221, 238);
    _caucho_line_map.add(221, 240);
    _caucho_line_map.add(229, 250);
    _caucho_line_map.add(231, 253);
    _caucho_line_map.add(231, 255);
    _caucho_line_map.add(231, 257);
    _caucho_line_map.add(239, 267);
    _caucho_line_map.add(241, 270);
    _caucho_line_map.add(251, 272);
    _caucho_line_map.add(253, 282);
    _caucho_line_map.add(261, 284);
    _caucho_line_map.add(262, 294);
    _caucho_line_map.add(263, 303);
    _caucho_line_map.add(276, 306);
    _caucho_line_map.add(283, 314);
    _caucho_line_map.add(289, 316);
    _caucho_line_map.add(292, 326);
    _caucho_line_map.add(292, 329);
    _caucho_line_map.add(307, 332);
    _caucho_line_map.add(329, 352);
    _caucho_line_map.add(333, 354);
    _caucho_line_map.add(333, 356);
    _caucho_line_map.add(333, 358);
    _caucho_line_map.add(333, 360);
    _caucho_line_map.add(337, 362);
    _caucho_line_map.add(337, 364);
    _caucho_line_map.add(337, 366);
    _caucho_line_map.add(337, 368);
    _caucho_line_map.add(345, 370);
    _caucho_line_map.add(357, 377);
    _caucho_line_map.add(362, 383);
    _caucho_line_map.add(367, 389);
    _caucho_line_map.add(370, 391);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("site/site_setting.jsp"), 1180791032000L, 13226L);
    _caucho_depends.add(depend);
  }

  protected void _caucho_clearDepends()
  {
    _caucho_depends.clear();
  }

  private static byte []_jsp_string48;
  private static byte []_jsp_string49;
  private static byte []_jsp_string3;
  private static byte []_jsp_string14;
  private static byte []_jsp_string46;
  private static byte []_jsp_string22;
  private static byte []_jsp_string43;
  private static byte []_jsp_string44;
  private static byte []_jsp_string5;
  private static byte []_jsp_string19;
  private static byte []_jsp_string27;
  private static byte []_jsp_string50;
  private static byte []_jsp_string2;
  private static byte []_jsp_string42;
  private static byte []_jsp_string0;
  private static byte []_jsp_string32;
  private static byte []_jsp_string9;
  private static byte []_jsp_string11;
  private static byte []_jsp_string15;
  private static byte []_jsp_string26;
  private static byte []_jsp_string39;
  private static byte []_jsp_string34;
  private static byte []_jsp_string12;
  private static byte []_jsp_string20;
  private static byte []_jsp_string7;
  private static byte []_jsp_string6;
  private static byte []_jsp_string41;
  private static byte []_jsp_string38;
  private static byte []_jsp_string30;
  private static byte []_jsp_string37;
  private static byte []_jsp_string10;
  private static byte []_jsp_string24;
  private static byte []_jsp_string45;
  private static byte []_jsp_string18;
  private static byte []_jsp_string8;
  private static byte []_jsp_string23;
  private static byte []_jsp_string35;
  private static byte []_jsp_string16;
  private static byte []_jsp_string52;
  private static byte []_jsp_string28;
  private static byte []_jsp_string31;
  private static byte []_jsp_string33;
  private static byte []_jsp_string36;
  private static byte []_jsp_string47;
  private static byte []_jsp_string21;
  private static byte []_jsp_string40;
  private static byte []_jsp_string25;
  private static byte []_jsp_string29;
  private static byte []_jsp_string53;
  private static byte []_jsp_string51;
  private static byte []_jsp_string13;
  private static byte []_jsp_string1;
  private static byte []_jsp_string4;
  private static byte []_jsp_string17;
  static {
    try {
      _jsp_string48 = "'><b>".getBytes("UTF8");
      _jsp_string49 = "</b></font></TD>\r\n        					  </TR>\r\n      						  <TR>\r\n       							   <TD>\r\n           								 <DIV align=left><SPAN ><font color='".getBytes("UTF8");
      _jsp_string3 = "\");\r\n	window.location.href=\"".getBytes("UTF8");
      _jsp_string14 = "\r\n		   ".getBytes("UTF8");
      _jsp_string46 = "#00CCFF".getBytes("UTF8");
      _jsp_string22 = "\">\r\n               <input type=\"hidden\" name=\"isdefault\"  value=\"".getBytes("UTF8");
      _jsp_string43 = " </span> \r\n                    </td>\r\n                </tr>\r\n              </table>\r\n			  </form>\r\n			  \r\n			  \r\n			   <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td class=\"form_row_submit\">&nbsp;\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n              <br>\r\n              \r\n			  ".getBytes("UTF8");
      _jsp_string44 = "\r\n			    <table   border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  width=\"600\">\r\n			   \r\n			  	 <tr> 	 \r\n					 <td class=\"site_blockphoto\"   width=\"600\" height=\"100\"    background=\"".getBytes("UTF8");
      _jsp_string5 = "\r\n\r\n<html>\r\n".getBytes("UTF8");
      _jsp_string19 = "</li>\r\n                  <li>".getBytes("UTF8");
      _jsp_string27 = "\r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n              </table>\r\n				 \r\n				  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td width=\"17%\" class=\"form_row_title\">*".getBytes("UTF8");
      _jsp_string50 = "' size='3'><b>".getBytes("UTF8");
      _jsp_string2 = "\r\n<script languange=\"javascript\">\r\n	alert(\"".getBytes("UTF8");
      _jsp_string42 = "\"> <span class=\"form_row_content\">".getBytes("UTF8");
      _jsp_string0 = "\r\n".getBytes("UTF8");
      _jsp_string32 = "</td>\r\n                  <td width=\"83%\" class=\"form_row_content\">&nbsp;\r\n                    <input name=\"copyright\" type=\"text\" size=\"40\" value=\"".getBytes("UTF8");
      _jsp_string9 = "\");\r\n		theForm.NewFile.focus();\r\n		return false;\r\n	\r\n		}\r\n	theForm.eventSubmit_UploadImage.disabled = true;\r\n	return true;\r\n}\r\n 	\r\n\r\nfunction checkForm()\r\n{\r\n	if (trim(langset.confname.value).length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string11 = "\");\r\n		langset.shortname.focus();\r\n		return false;\r\n	}\r\n	\r\n	if (trim(langset.copyright.value).length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string15 = "\r\n		  </td>\r\n        </tr>\r\n      </table>\r\n    </td>\r\n    <td width=\"598\" valign=\"top\" class=\"pagecontent\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n	\r\n        <tr>\r\n          <td class=\"pagecontent_title\"><b>".getBytes("UTF8");
      _jsp_string26 = "> ".getBytes("UTF8");
      _jsp_string39 = "   \r\n			   <form name=\"banner_upload\" method=\"post\" enctype=\"multipart/form-data\" action=\"".getBytes("UTF8");
      _jsp_string34 = "</td>\r\n                  <td width=\"83%\" class=\"form_row_content\">&nbsp;\r\n                    <input name=\"email\" type=\"text\" size=\"40\" value=\"".getBytes("UTF8");
      _jsp_string12 = "\");\r\n		langset.copyright.focus();\r\n		return false;\r\n	}\r\n	\r\n	if (trim(langset.email.value).length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string20 = "</li>\r\n        		<div class=\"spacer_5\"></div></td>\r\n              </tr>\r\n            </table>\r\n        \r\n              <form  action=\"".getBytes("UTF8");
      _jsp_string7 = "\r\n\r\n\r\n\r\n<script language=\"javascript\">\r\n \r\n\r\nfunction check(theForm){\r\n	filetype=new   Array();   \r\n 	filetype[0]=\"jpg\";     \r\n  	filetype[1]=\"gif\";     \r\n  	filetype[2]=\"jpeg\";     \r\n  	\r\n	\r\n	var filename = document.getElementById(\"NewFile\");\r\n	if((theForm.NewFile.value.length==0)){\r\n		\r\n		alert(\"".getBytes("UTF8");
      _jsp_string6 = "\r\n\r\n<body>\r\n".getBytes("UTF8");
      _jsp_string41 = "</td>\r\n                 	 <td class=\"form_row_content\">&nbsp;\r\n                    <input name=\"NewFile\" id=\"NewFile\" type=\"file\" size=\"30\">\r\n                    &nbsp;<input type=\"submit\" name=\"eventSubmit_UploadImage\" class=\"button\" value=\"".getBytes("UTF8");
      _jsp_string38 = "\">-->\r\n                  </td>\r\n				  \r\n                </tr>\r\n              </table>\r\n          \r\n			  <table  width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\r\n			   <tr> 	 \r\n					 <td>&nbsp;\r\n					 </td>\r\n				 </tr>	\r\n			  </table>\r\n			   </form>\r\n			".getBytes("UTF8");
      _jsp_string30 = " > ".getBytes("UTF8");
      _jsp_string37 = "\">\r\n                   <!-- <input name=\"Submit\" type=\"submit\" class=\"button\" value=\"".getBytes("UTF8");
      _jsp_string10 = "\");\r\n		langset.confname.focus();\r\n		return false;\r\n	}\r\n	\r\n	if (trim(langset.shortname.value).length == 0) {\r\n		alert(\"".getBytes("UTF8");
      _jsp_string24 = "</td>\r\n                  <td width=\"83%\" class=\"form_row_content\">&nbsp;\r\n                    <input name=\"confname\" type=\"text\" size=\"40\" value=\"".getBytes("UTF8");
      _jsp_string45 = "\">\r\n					 	 <TABLE cellSpacing=0 cellPadding=0 width=400 align=right border=0>\r\n        					<TBODY>\r\n       						 <TR>\r\n        						  <TD align=left height=35><font color='".getBytes("UTF8");
      _jsp_string18 = "</li>\r\n				  <li>".getBytes("UTF8");
      _jsp_string8 = "\");\r\n		theForm.NewFile.focus();\r\n		return false;\r\n	}\r\n	var flag=0;\r\n	for(var i=0;i<filetype.length;i++){\r\n	if((filename.value.substring(filename.value.length-3).toLowerCase())==filetype[i])\r\n		flag++;\r\n		}	\r\n	if(flag==0){\r\n		alert(\"".getBytes("UTF8");
      _jsp_string23 = "\">\r\n               <input name=\"eventSubmit_SiteSetting\" type=\"hidden\" id=\"eventSubmit_SiteSetting\" value=\"1\">\r\n               <input name=\"fromPage\" type=\"hidden\" id=\"fromPage\" value=\"\">\r\n				  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td width=\"17%\" class=\"form_row_title\">*".getBytes("UTF8");
      _jsp_string35 = "\">\r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n              </table>\r\n		  \r\n              <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_row\">\r\n                <tr> \r\n                  <td class=\"form_row_submit\"><input  name=\"SiteSetting\" onClick=\"langset.fromPage.value='/site/site_setting.jsp';\"   type=\"submit\"  value=\"".getBytes("UTF8");
      _jsp_string16 = "</b></td>\r\n		   <td class=\"site_version\" align=\"right\"><b>".getBytes("UTF8");
      _jsp_string52 = "   \r\n            </td>\r\n        </tr>\r\n      </table> \r\n    </td>\r\n  </tr>\r\n</table>\r\n".getBytes("UTF8");
      _jsp_string28 = "</td>\r\n                  <td width=\"83%\" class=\"form_row_content\">&nbsp;\r\n                    <input name=\"shortname\" type=\"text\" size=\"40\" value=\"".getBytes("UTF8");
      _jsp_string31 = "\r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n              </table>\r\n				 \r\n			    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td width=\"17%\" class=\"form_row_title\">*".getBytes("UTF8");
      _jsp_string33 = "\">\r\n					 <div class=\"spacer_5\"></div>\r\n                   </td>\r\n                </tr>\r\n              </table>\r\n				\r\n				\r\n              \r\n			    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                <tr>\r\n                  <td width=\"17%\" class=\"form_row_title\">*".getBytes("UTF8");
      _jsp_string36 = "\" class=\"button\">\r\n                   <input name=\"next\" onClick=\"langset.fromPage.value='/site/site_content.jsp';\" type=\"submit\" class=\"button\" id=\"next\" value=\"".getBytes("UTF8");
      _jsp_string47 = "#ff6600".getBytes("UTF8");
      _jsp_string21 = "\"  name=\"langset\"    method=\"post\"   onSubmit=\"return checkForm();\">\r\n               <input type=\"hidden\" name=\"languange\"  value=\"".getBytes("UTF8");
      _jsp_string40 = "/servlet/fckeditor_upload\" onsubmit=\"return check(this);\">\r\n			    <input type=\"hidden\" name=\"fromPage\" value=\"/site/site_setting.jsp\">	\r\n    			 <input type=\"hidden\" name=\"Type\" value=\"Image\">\r\n    			 <input type=\"hidden\" name=\"banner\" value=\"1\">\r\n			     <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"form_row\">\r\n                	<tr>\r\n                 	 <td  width=\"17%\" class=\"form_row_title\">".getBytes("UTF8");
      _jsp_string25 = "\"> <input type=\"checkbox\" name=\"show1\" value=\"1\" ".getBytes("UTF8");
      _jsp_string29 = "\"> <input type=\"checkbox\" name=\"show2\" value=\"1\"  ".getBytes("UTF8");
      _jsp_string53 = "\r\n</body>\r\n</html>\r\n".getBytes("UTF8");
      _jsp_string51 = "</b></font></SPAN></DIV></TD>\r\n         					 <TD align=right>&nbsp;</TD></TR></TBODY></TABLE>\r\n   \r\n					\r\n				 </tr>	\r\n			\r\n			   </table>\r\n			   \r\n			".getBytes("UTF8");
      _jsp_string13 = "\");\r\n		langset.emailt.focus();\r\n		return false;\r\n	}\r\n	\r\n	return true;\r\n} 	\r\n</script>\r\n\r\n\r\n<table width=\"778\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"MARGIN-TOP: 10px;\">\r\n  <tr>\r\n   <td width=\"180\" height=\"55\" valign=\"top\">\r\n    <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"leftmenu\">\r\n        <tr> \r\n          <td height=\"41\">\r\n		   ".getBytes("UTF8");
      _jsp_string1 = "\r\n\r\n".getBytes("UTF8");
      _jsp_string4 = "\"\r\n\r\n</script>\r\n\r\n\r\n".getBytes("UTF8");
      _jsp_string17 = "</b></td>\r\n		   <div class=\"spacer_5\"></div>\r\n        </tr>\r\n        <tr >\r\n          <td align=\"right\"  colspan=\"2\" height=\"5\">\r\n          	&nbsp;\r\n          </td>		\r\n        </tr>\r\n      </table>\r\n      <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form\">\r\n        <tr>\r\n          <td>\r\n		  \r\n		  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"form_note\">\r\n              <tr>\r\n                <td><div class=\"spacer_5\"></div>\r\n				  <li>".getBytes("UTF8");
    } catch (java.io.UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }
}