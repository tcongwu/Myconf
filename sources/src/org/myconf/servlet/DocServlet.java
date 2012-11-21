package org.myconf.servlet;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.myconf.Globals;
import org.myconf.UserLoginManager;
import org.myconf.beans.PaperBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.PaperDAO;
import org.myconf.util.FileUtils;
import org.myconf.util.RequestUtils;

import java.io.*;

public class DocServlet extends HttpServlet {

  //初始化全局变量
  public void init() throws ServletException {
  }

  //处理 HTTP Post 请求
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    Log log=LogFactory.getLog(DocServlet.class);
		int id=0;
		PaperBean paper=null;
		
    
		// 判断用户是否登录
		UserBean loginUser = UserBean.copyFrom(UserLoginManager.getLoginUser(request, response, true));
		if(loginUser == null){
			request.setAttribute("err", Globals.getMessage("common", "error.need_login"));
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}else{
			try {
				//获得要打开的稿件的ID
				id=RequestUtils.getParam(request, "id", 0);
				//获取稿件信息对象
				paper=(PaperBean)PaperDAO.getPaper(id);
				//判断当前用户是否有权限下载稿件
				if(paper==null || paper.getSubUser().getId()!=loginUser.getId()){
					request.setAttribute("err", Globals.getMessage("common", "error.can_not_access"));
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			} catch (Exception e) {
				log.error("database error when open paper", e);
				request.setAttribute("err", Globals.getMessage("common", "error.db"));
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
		
		//开始输出稿件文档流
		ServletOutputStream out = response.getOutputStream();
    
    //获取要输出的稿件文件
    File docFile=FileUtils.getPaperFile(id, paper.getFilePath());

		//设置输出的MIME类型
		//response.setContentType("application/doc");
		// Content-disposition header - don't open in browser and
		// set the "Save As..." filename.
		// *There is reportedly a bug in IE4.0 which ignores this...
		//response.setHeader("Content-disposition","attachment; filename=" + gKey + ".rls");

    //设置输出的MIME类型
    response.setContentType("application/"+paper.getFilePath());
		response.setHeader("Content-disposition","attachment; filename=" + id + "." +paper.getFilePath());
    if(docFile==null){
    	response.sendError(HttpServletResponse.SC_NOT_FOUND);
    	return;
    }

    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
		FileInputStream in = null;

    try {
      //使用 Buffered Stream 输入输出
      in=new FileInputStream(docFile);
      bis = new BufferedInputStream(in);
      bos = new BufferedOutputStream(out);

      byte[] buff = new byte[4096];
      int bytesRead;

      //简单的读写循环
      while ( -1 != (bytesRead = bis.read(buff, 0, buff.length))) {
        bos.write(buff, 0, bytesRead);
      }

    } catch(Exception e) {
      log.error("error when download paper file!", e);
    } finally {
      if (bis != null)
        bis.close();
      if (bos != null)
        bos.close();
      if(in != null)
      	in.close();
    }
	}

  //释放资源
  public void destroy() {
  }
}