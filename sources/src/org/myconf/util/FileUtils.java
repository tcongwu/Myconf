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
 * �ļ�������صĹ����࣬
 * ���·�����ļ����ȵĲ���
 */
public class FileUtils {
	
	final static Log log = LogFactory.getLog(FileUtils.class);
	
	public final static int CONVERT_RAMDOM = 97;	//�����
	public final static int PARAM_ID = 1;
	public final static int PARAM_TYPE = 2;
	public final static int PARAM_NAME = 3;
	
	/**
	 * ��·�����ҵ�ָ�����ļ�
	 * @param path ·������
	 * @param start �ļ����Ŀ�ʼ�ַ�
	 * @param fmt �ļ�����
	 * @return �ļ�����
	 */
	public static File findFile(File path, String start, String fmt){
		if((path==null)||(!path.isDirectory())||(start==null)||(fmt==null)){
			return null;
		}
		
		java.io.File allfiles[] = path.listFiles();

		//Ѱ��ָ���ļ�
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
	 * �½�Ŀ¼
	 * @param folderPath String �� c:/fqf
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
	 * �Ƿ���ڵ�ǰĿ¼
	 * @param path ��Ҫ�жϵ�Ŀ¼
	 * @return boolean �Ƿ����
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
	 * �½��ļ�
	 * @param filePathAndName String �ļ�·�������� ��c:/fqf.txt
	 * @param fileContent String �ļ�����
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
	 * ɾ���ļ�
	 * @param filePathAndName String �ļ�·�������� ��c:/fqf.txt
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
	 * ɾ���ļ���
	 * @param filePathAndName String �ļ���·�������� ��c:/fqf
	 * @param fileContent String
	 * @return boolean
	 */
	public static boolean delFolder(String folderPath) {
	  try {
		delAllFile(folderPath); //ɾ����������������
		String filePath = folderPath;
		filePath = filePath.toString();
		java.io.File myFilePath = new java.io.File(filePath);
		myFilePath.delete(); //ɾ�����ļ���
	  }
	  catch (Exception e) {
		return false;
	  }
	  return true;
	}

	/**
	 * ɾ���ļ�������������ļ�
	 * @param path String �ļ���·�� �� c:/fqf
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
			  delAllFile(path+"/"+ tempList[i]);//��ɾ���ļ���������ļ�
			  delFolder(path+"/"+ tempList[i]);//��ɾ�����ļ���
			}
		  }
	  }catch(Exception e){
		  return false;
	  }
	  return true;
	}

	/**
	 * ���Ƶ����ļ�
	 * @param oldPath String ԭ�ļ�·�� �磺c:/fqf.txt
	 * @param newPath String ���ƺ�·�� �磺f:/fqf.txt
	 * @return boolean
	 */
	public static boolean copyFile(String oldPath, String newPath) {
	  try {
		int bytesum = 0;
		int byteread = 0;
		File oldfile = new File(oldPath);
		if (oldfile.exists()) { //�ļ�����ʱ
		  InputStream inStream = new FileInputStream(oldPath); //����ԭ�ļ�
		  FileOutputStream fs = new FileOutputStream(newPath);
		  byte[] buffer = new byte[1444];
		  int length;
		  while ( (byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread; //�ֽ��� �ļ���С
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
	 * ���������ļ�������
	 * @param oldPath String ԭ�ļ�·�� �磺c:/fqf
	 * @param newPath String ���ƺ�·�� �磺f:/fqf/ff
	 * @return boolean
	 */
	public static boolean copyFolder(String oldPath, String newPath) {

	  try {
		(new File(newPath)).mkdirs(); //����ļ��в����� �������ļ���
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
		  if(temp.isDirectory()){//��������ļ���
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
	 * �ƶ��ļ���ָ��Ŀ¼
	 * @param oldPath String �磺c:/fqf.txt
	 * @param newPath String �磺d:/fqf.txt
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
	 * �ƶ��ļ���ָ��Ŀ¼
	 * @param oldPath String �磺c:/fqf.txt
	 * @param newPath String �磺d:/fqf.txt
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
	 * ���ϴ����ļ����浽������
	 * @param file
	 * @param path
	 * @throws IOException
	 */
	public static void writeToFile(FormFile file, String path) throws IOException{
		//�����ϴ����ļ�
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
	 * �������ڴ�Ÿ���ļ���·��
	 * @param pid ���ID
	 * @param ext ����ļ���չ��������: .doc
	 * @return 
	 * @throws IOException
	 */
	public static String createPaperSavePath(int pid, String ext){
		if(Globals.PAPER_ROOT == null)
			return null;
			
		//������ڴ�Ÿ����Ŀ¼
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
	 * ��ȡָ��ID��doc�ļ�����
	 * @param pid ���ID
	 * @param ext ����ļ���չ��������: .doc
	 * @return �ļ�����
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
	 * ȡ�ô�����ļ�
	 * @param status ��������״̬
	 * @param subject ������������
	 * @return ����ļ�
	 */
	public static File getZipFile(StatusBean status, SubjectBean subject){
		if(Globals.PAPER_ROOT == null)
			return null;
		
		StringBuffer zipPath = new StringBuffer();
		zipPath.append(Globals.PAPER_ROOT);
		zipPath.append(File.separator);
		zipPath.append("zip");
		//������ڴ��zip�ļ���Ŀ¼
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
	 * ȡ�����������ļ�
	 * @param title �������
	 * @param ext ����ļ�����
	 * @return ���������ļ�
	 */
	public static String getRenameFile(String title, String ext){
		if(Globals.PAPER_ROOT == null)
			return null;
		
		StringBuffer rename = new StringBuffer();
		rename.append(Globals.PAPER_ROOT);
		rename.append(File.separator);
		rename.append("temp");
		//������ڴ��zip�ļ���Ŀ¼
		if(!isExistFolder(rename.toString()) && !newFolder(rename.toString()))
			return null;
		
		rename.append(File.separator);
		rename.append(StringUtils.filterFileName(title));
		rename.append('.');
		rename.append(ext);
		
		return rename.toString();
	}

	/**
	 * ���Ƶ����ļ�
	 * @param oldPath String ԭ�ļ�·�� �磺c:/fqf.txt
	 * @param newPath String ���ƺ�·�� �磺f:/fqf.txt
	 * @return boolean
	 */
	public static boolean copyFile(File oldfile, String newPath) {
	  try {
		int bytesum = 0;
		int byteread = 0;
		if (oldfile.exists()) { //�ļ�����ʱ
		  InputStream inStream = new FileInputStream(oldfile.toString()); //����ԭ�ļ�
		  FileOutputStream fs = new FileOutputStream(newPath);
		  byte[] buffer = new byte[1444];
		  int length;
		  while ( (byteread = inStream.read(buffer)) != -1) {
			bytesum += byteread; //�ֽ��� �ļ���С
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
	 * ���ɴ������б��xls�ļ�
	 * @param papers �������б�
	 * @return 
	 * @throws IOException
	 */
	public static String exportXLS(List papers){
		if(papers==null && papers.size()==0)
			return null;
		
		//��ȡҪ�����xls�ļ�����·��
		if(Globals.PAPER_ROOT == null)
			return null;
		StringBuffer xls = new StringBuffer();
		xls.append(Globals.PAPER_ROOT);
		if(!Globals.PAPER_ROOT.endsWith(File.separator))
			xls.append(File.separator);
		xls.append("temp");
		//������ڴ��xls�ļ���Ŀ¼
		if(!isExistFolder(xls.toString()) && !newFolder(xls.toString()))
			return null;
		xls.append(File.separator);
		xls.append("list.xls");
		
		//���ɴ������б�������
		//���̧ͷ
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

		//ѭ������������б�
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
		
		//���xls�ļ�Դ
		if(Globals.WEBAPP_PATH == null)
			return null;
		StringBuffer src = new StringBuffer();
		src.append(Globals.WEBAPP_PATH);
		if(!Globals.WEBAPP_PATH.endsWith(File.separator))
			src.append(File.separator);
		src.append("admin/xls.htm");
		
		//��д�ļ�
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

			//�滻���ݲ���
			String exp=content.toString().replaceFirst("--0content0--", list.toString());
			
			//�����list.xls
			FileOutputStream fos = new FileOutputStream(write);
			Writer out = new OutputStreamWriter(fos, Globals.ENC_UTF_8);
			out.write(exp);
			out.close();
			fos.close();

		}catch(FileNotFoundException e){ //�ļ�δ�ҵ�
		  log.error("file not found err when expert xls", e);
		  return null;
		}catch(IOException e){
			log.error("io err when expert xls", e);
			return null;
		} 		
		
		return xls.toString();
	}

}
