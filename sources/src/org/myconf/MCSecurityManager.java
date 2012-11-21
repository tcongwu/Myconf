package org.myconf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;

/**
 * MYCONF在安全方面的一些处理方法 
 * 敏感词汇表：/WEB-INF/conf/illegal_glossary.dat
 * 
 * @author Winter Lau
 */
public class MCSecurityManager {

	/**
	 * 初始化
	 * @param sc
	 * @throws IOException
	 * 
	 * @see org.myconf.servlet.DLOG_ActionServlet#init()
	 */
	public static void init(ServletContext sc) throws IOException {
		IllegalGlossary.init(sc);
	}
	
	public static void destroy(){
		IllegalGlossary.destroy();
	}
	
	/**
	 * 敏感字汇
	 * @author Winter Lau
	 */
	public static class IllegalGlossary {

		private final static String file_glossary = "/WEB-INF/conf/illegal_glossary.dat";
		
		private static List glossary = null;
		
		public static void init(ServletContext sc) throws IOException {
			glossary = new ArrayList(1000);
			if(sc!=null)
				loadIllegalGlossary(sc);
		}

		public static void destroy(){
			if(glossary!=null)
				glossary.clear();
		}
		
		/**
		 * 加载敏感词汇表
		 * @param sc
		 * @throws IOException 
		 */
		private synchronized static void loadIllegalGlossary(ServletContext sc) throws IOException {
			InputStream in = sc.getResourceAsStream(file_glossary);
			BufferedReader reader = null;
			try{
				reader = new BufferedReader(new InputStreamReader(in));
				do{
					String line = reader.readLine();
					if(line==null)
						break;
					glossary.add(line.trim());
				}while(true);
			}finally{
				in.close();
			}
		}

		/**
		 * 自动将敏感词汇用XXX替换
		 * 
		 * @param content
		 * @return
		 */
		public static String autoGlossaryFiltrate(String content) {
			if(StringUtils.isEmpty(content))
				return content;
			for (int i = 0; i < glossary.size(); i++) {
				String word = (String)glossary.get(i);
				content = StringUtils.replace(content, word, StringUtils
						.repeat("X", word.length()));
			}
			return content;
		}
		
		/**
		 * 判断是否存在非法内容
		 * @param content
		 * @return
		 */
		public static boolean existIllegalWord(String content){
			if(StringUtils.isEmpty(content))
				return false;
			for (int i = 0; i < glossary.size(); i++) {
				String word = (String) glossary.get(i);
				if(content.indexOf(word)>=0)
					return true;
			}
			return false;
		}
		
		/**
		 * 删除内容中存在的关键字
		 * @param content
		 * @return
		 */
		public static String deleteIllegalWord(String content){
			if(StringUtils.isEmpty(content))
				return content;
			for (int i = 0; i < glossary.size(); i++) {
				String word = (String) glossary.get(i);
				content = StringUtils.remove(content, word);
			}
			return content;
		}
		
	}

	public static void main(String[] args) throws IOException{
		init(null);
		String text = "中华人民共和国国家主席毛泽东，我们叫他毛主席";
		System.out.println(IllegalGlossary.autoGlossaryFiltrate(text));
	}
}
