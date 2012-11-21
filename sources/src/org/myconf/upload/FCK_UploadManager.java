
package org.myconf.upload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * 用于协调FCKEditor编辑器的文件上传管理
 * 该类由FCKEditor_UploadServlet进行初始化
 * 
 */
public class FCK_UploadManager {
	
	private static UploadFileHandler fileHandler;
	
	/**
	 * 初始化
	 * @param sConfig
	 * @param s_file_handler_class
	 * @throws ServletException
	 */
	public static void init(ServletConfig sConfig, String s_file_handler_class)
			throws ServletException
	{
		if (s_file_handler_class == null)
			fileHandler = new UploadFileHandler();
		else {
			try {
				fileHandler = (UploadFileHandler) Class.forName(
						s_file_handler_class).newInstance();
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		fileHandler.init(sConfig);

	}

	public static void destroy(){
		if (fileHandler != null) {
			fileHandler.destroy();
			fileHandler = null;
		}
	}

	/**
	 * 返回用于处理上传后的类实例
	 * @return
	 */
	public final static UploadFileHandler getUploadHandler(){
		return fileHandler;
	}

}
