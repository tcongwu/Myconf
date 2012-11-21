package org.myconf.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlDateConverter;

import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.apache.struts.action.ActionServlet;

import org.myconf.MCSecurityManager;
import org.myconf.MCUserManager;
import org.myconf.MyCacheManager;
import org.myconf.Globals;
import org.myconf.util.RequestUtils;

/**
 * ��Struts������չ��ʵ��Hibernate�ĳ�ʼ���Լ�����������Զ�����
 * @author liudong
 */
public class ActionServletExtend extends ActionServlet {

	private String encoding;

	static {
		ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
	}

	/**
	 * Globals.WEBAPP_PATH����ֵ��ʹ��access���ݿ���˵�ǳ���Ҫ���漰һ�����·��������
	 */
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		if (Globals.WEBAPP_PATH == null)
			Globals.WEBAPP_PATH = context.getRealPath("");
		if (Globals.PAPER_ROOT == null)
			Globals.PAPER_ROOT = context.getRealPath(Globals.PAPER_ROOT_WEB);

		//��ʼ��ϵͳ��ȫ����
		try {
			MCSecurityManager.init(context);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		//��ʼ���û����Ϲ���ӿ�
		try {
			MCUserManager.init(context);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//ִ��Struts�ĳ�ʼ������
		super.init();
		
		encoding = getInitParameter("encoding");
		if(encoding==null)
			encoding = Globals.ENC_UTF_8;
	}

	/**
	 * ʵ�ֶԱ�����Զ�ת�봦��
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @see org.apache.struts.action.ActionServlet#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		HttpServletRequest request;
		if (RequestUtils.isMultipart(req)) {
			//�ļ����ı��봦��
			request = req;
			request.setCharacterEncoding(encoding);
		} else {
			//�Զ����봦��
			String enc = req.getCharacterEncoding();
			if (req instanceof RequestProxy)
				request = req;
			else if (encoding.equalsIgnoreCase(enc))
				request = req;
			else
				request = new RequestProxy(req, encoding);
		}
		super.process(request, res);
	}

	public void destroy() {
		//�ͷŻ��������
		MyCacheManager.shutdown();
		//�ͷ�Struts
		super.destroy();
	}

}
