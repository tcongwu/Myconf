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

  //��ʼ��ȫ�ֱ���
  public void init() throws ServletException {
  }

  //���� HTTP Post ����
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    Log log=LogFactory.getLog(DocServlet.class);
		int id=0;
		PaperBean paper=null;
		
    
		// �ж��û��Ƿ��¼
		UserBean loginUser = UserBean.copyFrom(UserLoginManager.getLoginUser(request, response, true));
		if(loginUser == null){
			request.setAttribute("err", Globals.getMessage("common", "error.need_login"));
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}else{
			try {
				//���Ҫ�򿪵ĸ����ID
				id=RequestUtils.getParam(request, "id", 0);
				//��ȡ�����Ϣ����
				paper=(PaperBean)PaperDAO.getPaper(id);
				//�жϵ�ǰ�û��Ƿ���Ȩ�����ظ��
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
		
		//��ʼ�������ĵ���
		ServletOutputStream out = response.getOutputStream();
    
    //��ȡҪ����ĸ���ļ�
    File docFile=FileUtils.getPaperFile(id, paper.getFilePath());

		//���������MIME����
		//response.setContentType("application/doc");
		// Content-disposition header - don't open in browser and
		// set the "Save As..." filename.
		// *There is reportedly a bug in IE4.0 which ignores this...
		//response.setHeader("Content-disposition","attachment; filename=" + gKey + ".rls");

    //���������MIME����
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
      //ʹ�� Buffered Stream �������
      in=new FileInputStream(docFile);
      bis = new BufferedInputStream(in);
      bos = new BufferedOutputStream(out);

      byte[] buff = new byte[4096];
      int bytesRead;

      //�򵥵Ķ�дѭ��
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

  //�ͷ���Դ
  public void destroy() {
  }
}