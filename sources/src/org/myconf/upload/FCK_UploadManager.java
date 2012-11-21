
package org.myconf.upload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * ����Э��FCKEditor�༭�����ļ��ϴ�����
 * ������FCKEditor_UploadServlet���г�ʼ��
 * 
 */
public class FCK_UploadManager {
	
	private static UploadFileHandler fileHandler;
	
	/**
	 * ��ʼ��
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
	 * �������ڴ����ϴ������ʵ��
	 * @return
	 */
	public final static UploadFileHandler getUploadHandler(){
		return fileHandler;
	}

}
