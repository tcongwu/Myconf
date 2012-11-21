package org.myconf.util;

import java.io.*;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.myconf.Globals;
import org.myconf.beans.PaperBean;
import org.myconf.beans.StatusBean;
import org.myconf.beans.SubjectBean;
import org.myconf.dao.StatusDAO;

/**
 * @author Lee Bin
 *
 * 文件操作相关的工具类，
 * 完成路径、文件名等的操作
 */
public class FileUtils {
	
	final static Log log = LogFactory.getLog(FileUtils.class);
	
	public final static int CONVERT_RAMDOM = 97;	//随机数
	public final static int PARAM_ID = 1;
	public final static int PARAM_TYPE = 2;
	public final static int PARAM_NAME = 3;
	
	/**
	 * 从路径中找到指定的文件
	 * @param path 路径对象
	 * @param start 文件名的开始字符
	 * @param fmt 文件类型
	 * @return 文件对象
	 */
	public static File findFile(File path, String start, String fmt){
		if((path==null)||(!path.isDirectory())||(start==null)||(fmt==null)){
			return null;
		}
		
		java.io.File allfiles[] = path.listFiles();

		//寻找指定文件
		for (int i=0;i< allfiles.length; i++){
			if( allfiles[i].isFile() ){
				if (allfiles[i].getName().endsWith(fmt)&&allfiles[i].getName().startsWith(start))				{				
					return allfiles[i];
				}
			}
		}
		return null;
	}

	/**
	 * 新建目录
	 * @param folderPath String 如 c:/fqf
	 * @return boolean
	 */
	public static boolean newFolder(String folderPath) {
	  try {
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			if (!myFilePath.exists()) {
			  myFilePath.mkdirs();
			}
	  }
	  catch (Exception e) {
			return false;
	  }
	  
	  return true;
	}
  
	/**
	 * 是否存在当前目录
	 * @param path 需要判断的目录
	 * @return boolean 是否存在
	 */
	public static boolean isExistFolder(String path){
	  try {
			String filePath = path;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			if (myFilePath.exists()) {
			  return true;
			}else{
			  return false;
			}
	  }
	  catch (Exception e) {
			return false;
	  }
  	
	}

	/**
	 * 新建文件
	 * @param filePathAndName String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent String 文件内容
	 * @return boolean
	 */
	public static boolean newFile(String filePathAndName, String fileContent) {

	  try {
		String filePath = filePathAndName;
		filePath = filePath.toString();
		File myFilePath = new File(filePath);
		if (!myFilePath.exists()) {
		  myFilePath.createNewFile();
		}
		FileWriter resultFile = new FileWriter(myFilePath);
		PrintWriter myFile = new PrintWriter(resultFile);
		String strContent = fileContent;
		myFile.println(strContent);
		resultFile.close();

	  }
	  catch (Exception e) {
		return false;
	  }
	  return true;
	}

	/**
	 * 删除文件
	 * @param filePathAndName String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent String
	 * @return boolean
	 */
	public static boolean delFile(String filePathAndName) {
	  try {
		String filePath = filePathAndName;
		filePath = filePath.toString();
		java.io.File myDelFile = new java.io.File(filePath);
		myDelFile.delete();
	  }
	  catch (Exception e) {
		return false;
	  }
	  return true;
	}

	/**
	 * 删除文件夹
	 * @param filePathAndName String 文件夹路径及名称 如c:/fqf
	 * @param fileContent String
	 * @return boolean
	 */
	public static boolean delFolder(String folderPath) {
	  try {
		delAllFile(folderPath); //删除完里面所有内容
		String filePath = folderPath;
		filePath = filePath.toString();
		java.io.File myFilePath = new java.io.File(filePath);
		myFilePath.delete(); //删除空文件夹
	  }
	  catch (Exception e) {
		return false;
	  }
	  return true;
	}

	/**
	 * 删除文件夹里面的所有文件
	 * @param path String 文件夹路径 如 c:/fqf
	 */
	public static boolean delAllFile(String path) {
	  try{
		  File file = new File(path);
		  if (!file.exists()) {
			return true;
		  }
		  if (!file.isDirectory()) {
			return true;
		  }
		  String[] tempList = file.list();
		  File temp = null;
		  for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
			  temp = new File(path + tempList[i]);
			}
			else {
			  temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
			  temp.delete();
			}
			if (temp.isDirectory()) {
			  delAllFile(path+"/"+ tempList[i]);//先删除文件夹里面的文件
			  delFolder(path+"/"+ tempList[i]);//再删除空文件夹
			}
		  }
	  }catch(Exception e){
		  return false;
	  }
	  return true;
	}

	/**
	 * 复制单个文件
	 * @param oldPath String 原文件路径 如：c:/fqf.txt
	 * @param newPath String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static boolean copyFile(String oldPath, String newPath) {
	  try {
		int bytesum = 0;
		int byteread = 0;
		File oldfile = new File(oldPath);
		if (oldfile.exists()) { //文件存在时
		  InputStream inStream = new FileInputStream(oldPath); //读入原文件
		  FileOutputStream fs = new FileOutputStream(newPath);
		  byte[] buffer = new byte[1444];
		  int length;
		  while ( (byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread; //字节数 文件大小
			System.out.println(bytesum);
			fs.write(buffer, 0, byteread);
		  }
		  inStream.close();
		}
	  }
	  catch (Exception e) {
		return false;
	  }
	  return true;
	}

	/**
	 * 复制整个文件夹内容
	 * @param oldPath String 原文件路径 如：c:/fqf
	 * @param newPath String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public static boolean copyFolder(String oldPath, String newPath) {

	  try {
		(new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
		File a=new File(oldPath);
		String[] file=a.list();
		File temp=null;
		for (int i = 0; i < file.length; i++) {
		  if(oldPath.endsWith(File.separator)){
			temp=new File(oldPath+file[i]);
		  }
		  else{
			temp=new File(oldPath+File.separator+file[i]);
		  }

		  if(temp.isFile()){
			FileInputStream input = new FileInputStream(temp);
			FileOutputStream output = new FileOutputStream(newPath + "/" +
				(temp.getName()).toString());
			byte[] b = new byte[1024 * 5];
			int len;
			while ( (len = input.read(b)) != -1) {
			  output.write(b, 0, len);
			}
			output.flush();
			output.close();
			input.close();
		  }
		  if(temp.isDirectory()){//如果是子文件夹
			copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]);
		  }
		}
	  }
	  catch (Exception e) {
		return false;
	  }
	  return true;
	}

	/**
	 * 移动文件到指定目录
	 * @param oldPath String 如：c:/fqf.txt
	 * @param newPath String 如：d:/fqf.txt
	 */
	public static boolean moveFile(String oldPath, String newPath) {
	  if(!copyFile(oldPath, newPath)){
		  return false;
	  }
	  if(!delFile(oldPath)){
		  return false;
	  }
	  return true;
	}

	/**
	 * 移动文件到指定目录
	 * @param oldPath String 如：c:/fqf.txt
	 * @param newPath String 如：d:/fqf.txt
	 */
	public static boolean moveFolder(String oldPath, String newPath) {
	  if(!copyFolder(oldPath, newPath)){
		  return false;
	  }
	  if(!delFolder(oldPath)){
		  return false;
	  }
	  return true;
	}
	
	/**
	 * 将上传的文件保存到磁盘中
	 * @param file
	 * @param path
	 * @throws IOException
	 */
	public static void writeToFile(FormFile file, String path) throws IOException{
		//保存上传的文件
		FileOutputStream oldimage = null;
		InputStream fin = null;
		byte[] data = new byte[8192];
		try {
			fin = file.getInputStream();
			oldimage=new FileOutputStream(path);
			do{
				int rc = fin.read(data);
				if(rc == -1)
					break;
				oldimage.write(data, 0, rc);
				if(rc < data.length)
					break;
			}while(true);
		}finally{
			data = null;
			if(oldimage!=null)
				oldimage.close();
			if(fin!=null)
				fin.close();
		}
	}
	
	/**
	 * 生成用于存放稿件文件的路径
	 * @param pid 稿件ID
	 * @param ext 稿件文件扩展名，例如: .doc
	 * @return 
	 * @throws IOException
	 */
	public static String createPaperSavePath(int pid, String ext){
		if(Globals.PAPER_ROOT == null)
			return null;
			
		//检查用于存放稿件的目录
		if(!isExistFolder(Globals.PAPER_ROOT) && !newFolder(Globals.PAPER_ROOT))
			return null;
		
		StringBuffer file = new StringBuffer();
		file.append(Globals.PAPER_ROOT);
		if(!Globals.PAPER_ROOT.endsWith(File.separator))
			file.append(File.separator);
		file.append(pid);
		file.append('.');
		file.append(ext);
		
		return file.toString();
	}
	
	/**
	 * 获取指定ID的doc文件对象
	 * @param pid 稿件ID
	 * @param ext 稿件文件扩展名，例如: .doc
	 * @return 文件对象
	 */
	public static File getPaperFile(int pid, String ext) throws FileNotFoundException{
		String fpath=createPaperSavePath(pid, ext);
		if(fpath==null)
			throw new FileNotFoundException();
		
		File file=new File(fpath);
		if(file.exists()&&file.isFile()){
			return file;
		}else{
			throw new FileNotFoundException();
		}
	}
	
	/**
	 * 取得打包的文件
	 * @param status 打包稿件的状态
	 * @param subject 打包稿件的主题
	 * @return 打包文件
	 */
	public static File getZipFile(StatusBean status, SubjectBean subject){
		if(Globals.PAPER_ROOT == null)
			return null;
		
		StringBuffer zipPath = new StringBuffer();
		zipPath.append(Globals.PAPER_ROOT);
		zipPath.append(File.separator);
		zipPath.append("zip");
		//检查用于存放zip文件的目录
		if(!isExistFolder(zipPath.toString()) && !newFolder(zipPath.toString()))
			return null;
		
		zipPath.append(File.separator);
		zipPath.append(StringUtils.exportDate(new Date(), "yyyyMMdd"));
		if(status!=null){
			zipPath.append('(');
			zipPath.append(status.getStatus());
			zipPath.append(')');
		}
		if(subject!=null){
			zipPath.append('(');
			zipPath.append(subject.getSubject());
			zipPath.append(')');
		}
		zipPath.append(".zip");
		
		return new File(zipPath.toString());
	}
	
	/**
	 * 取得重命名的文件
	 * @param title 稿件标题
	 * @param ext 稿件文件类型
	 * @return 重命名的文件
	 */
	public static String getRenameFile(String title, String ext){
		if(Globals.PAPER_ROOT == null)
			return null;
		
		StringBuffer rename = new StringBuffer();
		rename.append(Globals.PAPER_ROOT);
		rename.append(File.separator);
		rename.append("temp");
		//检查用于存放zip文件的目录
		if(!isExistFolder(rename.toString()) && !newFolder(rename.toString()))
			return null;
		
		rename.append(File.separator);
		rename.append(StringUtils.filterFileName(title));
		rename.append('.');
		rename.append(ext);
		
		return rename.toString();
	}

	/**
	 * 复制单个文件
	 * @param oldPath String 原文件路径 如：c:/fqf.txt
	 * @param newPath String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	public static boolean copyFile(File oldfile, String newPath) {
	  try {
		int bytesum = 0;
		int byteread = 0;
		if (oldfile.exists()) { //文件存在时
		  InputStream inStream = new FileInputStream(oldfile.toString()); //读入原文件
		  FileOutputStream fs = new FileOutputStream(newPath);
		  byte[] buffer = new byte[1444];
		  int length;
		  while ( (byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread; //字节数 文件大小
			System.out.println(bytesum);
			fs.write(buffer, 0, byteread);
		  }
		  inStream.close();
		}
	  }
	  catch (Exception e) {
		return false;
	  }
	  return true;
	}
	
	/**
	 * 生成打包稿件列表的xls文件
	 * @param papers 打包稿件列表
	 * @return 
	 * @throws IOException
	 */
	public static String exportXLS(List papers){
		if(papers==null && papers.size()==0)
			return null;
		
		//获取要输出的xls文件名及路径
		if(Globals.PAPER_ROOT == null)
			return null;
		StringBuffer xls = new StringBuffer();
		xls.append(Globals.PAPER_ROOT);
		if(!Globals.PAPER_ROOT.endsWith(File.separator))
			xls.append(File.separator);
		xls.append("temp");
		//检查用于存放xls文件的目录
		if(!isExistFolder(xls.toString()) && !newFolder(xls.toString()))
			return null;
		xls.append(File.separator);
		xls.append("list.xls");
		
		//生成打包稿件列表表格内容
		//表格抬头
		StringBuffer list = new StringBuffer();
		list.append("<tr height=21 style='height:15.75pt'>");
		list.append("<td height=21 class=xl24 width=55 style='height:15.75pt;width:41pt'>");
		list.append(Globals.getMessage("admin", "common.text.no"));
		list.append("</td>");
		list.append("<td width=367 style='width:275pt'>");
		list.append(Globals.getMessage("admin", "common.text.title"));
		list.append("</td>");
		list.append("<td width=227 style='width:170pt'>");
		list.append(Globals.getMessage("admin", "common.text.subject"));
		list.append("</td>");
		list.append("<td width=113 style='width:85pt'>");
		list.append(Globals.getMessage("admin", "common.text.statistics.accept"));
		list.append("</td>");
		list.append("<td width=165 style='width:124pt'>");
		list.append(Globals.getMessage("admin", "common.text.realname"));
		list.append("</td>");
		list.append("<td class=xl25 width=214 style='width:161pt'>");
		list.append(Globals.getMessage("admin", "common.text.email"));
		list.append("</td>");
		list.append("<td width=161 style='width:121pt'>");
		list.append(Globals.getMessage("admin", "common.text.worklocation"));
		list.append("</td>");
		list.append("<td width=174 style='width:131pt'>");
		list.append(Globals.getMessage("admin", "common.text.statistics.country"));
		list.append("</td>");
		list.append("</tr>");

		//循环输出打包稿件列表
		PaperBean paper=null;
		for(int i=0;i<papers.size();i++){
			paper=(PaperBean)papers.get(i);
			list.append("<tr height=21 style='height:15.75pt'>");
			list.append("<td height=21 class=xl24 style='height:15.75pt' x:num>");
			list.append(paper.getId());
			list.append("</td>");
			list.append("<td>");
			list.append(paper.getTitle());
			list.append("</td>");
			list.append("<td>");
			list.append(paper.getSubject().getSubject());
			list.append("</td>");
			list.append("<td>");
			list.append(StringUtils.exportString(StatusDAO.getStatusInMap(paper.getStatus())));
			list.append("</td>");
			list.append("<td>");
			list.append(paper.getSubUser().getName().toString());
			list.append("</td>");
			list.append("<td class=xl26>");
			list.append(paper.getSubUser().getEmail());
			list.append("</td>");
			list.append("<td>");
			list.append(paper.getSubUser().getWorkLocation());
			list.append("</td>");
			list.append("<td class=xl25>");
			list.append(paper.getSubUser().getCountry());
			list.append("</td>");
			list.append("</tr>");
		}
		
		//获得xls文件源
		if(Globals.WEBAPP_PATH == null)
			return null;
		StringBuffer src = new StringBuffer();
		src.append(Globals.WEBAPP_PATH);
		if(!Globals.WEBAPP_PATH.endsWith(File.separator))
			src.append(File.separator);
		src.append("admin/xls.htm");
		
		//读写文件
		try{
   
			File read = new File(src.toString());
		  File write = new File(xls.toString());

		  FileInputStream fis = new FileInputStream(read);
		  DataInputStream in = new DataInputStream(fis);
		  BufferedReader d = new BufferedReader(new InputStreamReader(in, Globals.ENC_UTF_8));
		  StringBuffer content = new StringBuffer();
		  String line = null;
		  while ((line = d.readLine()) != null){
				content.append(line + "\r\n");
		  }
			d.close();
			in.close();
			fis.close();

			//替换内容部分
			String exp=content.toString().replaceFirst("--0content0--", list.toString());
			
			//输出到list.xls
			FileOutputStream fos = new FileOutputStream(write);
			Writer out = new OutputStreamWriter(fos, Globals.ENC_UTF_8);
			out.write(exp);
			out.close();
			fos.close();

		}catch(FileNotFoundException e){ //文件未找到
		  log.error("file not found err when expert xls", e);
		  return null;
		}catch(IOException e){
			log.error("io err when expert xls", e);
			return null;
		} 		
		
		return xls.toString();
	}

}
