
package org.myconf.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.myconf.Globals;
import org.myconf.util.StringUtils;

/**
 * 上传后的文件处理
 * 
 */

 public class UploadFileHandler {
	
	/**
	 * 初始化文件处理接口
	 * @param config
	 */
	private static SimpleDateFormat fmt_fn = new SimpleDateFormat("yyyyMM/ddHHmmssSSS");
		private String diskPath;
		private String baseURI;
		public void init(ServletConfig config){
			String path = config.getInitParameter("file_saved_path");
					this.baseURI = config.getInitParameter("file_base_uri");
					if(path.startsWith(Globals.LOCAL_PATH_PREFIX)){
						path = path.substring(Globals.LOCAL_PATH_PREFIX.length());
					}
					else if(path.startsWith("/")){
						if(baseURI == null)
							baseURI = path;
						path = config.getServletContext().getRealPath(path);			
					}		
					this.diskPath = path;
					if(!diskPath.endsWith(File.separator))
						diskPath += File.separator;
					if(!baseURI.endsWith("/"))
						baseURI += "/";
					//创建存储上传文件的目录
					File fp = new File(diskPath);
					if(!fp.exists())
						fp.mkdirs();
	
	
	
		}
	
	
	/**
	 * 保存上传后的文件并返回该文件对应的URL地址
	 * 子类必须设置图片的存储路径,例如
	 * req.setAttribute("file.path", newFile);
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String save(HttpServletRequest req, HttpServletResponse res, File file) throws Exception{
				String fileName = file.getName();
				int dotIdx = fileName.lastIndexOf('.');
				while(true){
					String newName = getFilename();
					if(dotIdx !=-1){
						newName += fileName.substring(dotIdx).toLowerCase();
					}
					File newFile = new File(diskPath + StringUtils.replace(newName,"/",File.separator));
					if(!newFile.getParentFile().exists()){
						newFile.getParentFile().mkdir();
					}
					else if(newFile.exists()){
						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {}
						continue;
					}
					writeTo(file, newFile);
					req.setAttribute("file.path", newFile.getPath());
					return baseURI + newName;
				}
	 }
	
		private void writeTo(File f, File newFile) throws IOException{
				FileInputStream fis = new FileInputStream(f);
				FileOutputStream fos = new FileOutputStream(newFile);
				try{
					byte[] buf = new byte[8192];
					do{
						int rc = fis.read(buf);
						if(rc == -1)
							break;
						fos.write(buf, 0, rc);
						if(rc < buf.length)
							break;
					}while(true);
				}finally{
					fis.close();
					fos.close();
				}
			}
	
			private String getFilename(){
				return fmt_fn.format(new Date());
			}
	

			public void destroy() {
				this.diskPath = null;
				this.baseURI = null;
			}

	

	
	
	

}
