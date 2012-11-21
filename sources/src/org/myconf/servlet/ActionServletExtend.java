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
 * 对Struts进行扩展，实现Hibernate的初始化以及参数编码的自动处理
 * @author liudong
 */
public class ActionServletExtend extends ActionServlet {

	private String encoding;

	static {
		ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
		ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
	}

	/**
	 * Globals.WEBAPP_PATH变量值对使用access数据库来说非常重要，涉及一个相对路径的问题
	 */
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		if (Globals.WEBAPP_PATH == null)
			Globals.WEBAPP_PATH = context.getRealPath("");
		if (Globals.PAPER_ROOT == null)
			Globals.PAPER_ROOT = context.getRealPath(Globals.PAPER_ROOT_WEB);

		//初始化系统安全控制
		try {
			MCSecurityManager.init(context);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		//初始化用户资料管理接口
		try {
			MCUserManager.init(context);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		//执行Struts的初始化过程
		super.init();
		
		encoding = getInitParameter("encoding");
		if(encoding==null)
			encoding = Globals.ENC_UTF_8;
	}

	/**
	 * 实现对编码的自动转码处理
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
			//文件表单的编码处理
			request = req;
			request.setCharacterEncoding(encoding);
		} else {
			//自动编码处理
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
		//释放缓存管理器
		MyCacheManager.shutdown();
		//释放Struts
		super.destroy();
	}

}
