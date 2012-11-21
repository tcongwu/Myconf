package org.myconf.util;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.myconf.Globals;

/**
 * @author Lee Bin
 *
 * 数据的分页包装类
 */
public class Page {
	
	private int curPage; //当前页
	private int pageCount; //页面数
	private int rowCount; //记录数
	private int pageSize; //每页记录数

	/**
	 * 默认的构造函数
	 */
	public Page() {
	}
	
	/**
	 * 带初始化参数的构造函数
	 * @param rows 记录数
	 * @param psize 页面记录大小
	 * @param cpage 当前页
	 */
	public Page(int rows, int psize, int cpage){
		if(rows<0)
			rows=0;
		if(psize<=0)
			psize=1;
		if(cpage<=0)
			cpage=1;
		
		this.curPage=cpage;
		this.rowCount=rows;
		this.pageSize=psize;
		if(this.rowCount%this.pageSize==0){
			this.pageCount=this.rowCount/this.pageSize;
		}else{
			this.pageCount=this.rowCount/this.pageSize+1;
		}
		
		if(curPage>1 && curPage>pageCount)
			curPage=pageCount;
	}
	
	/**
	 * 设置对象的分页参数
	 * @param rows 记录数
	 * @param psize 页面记录大小
	 * @param cpage 当前页
	 */
	public void setParam(int rows, int psize, int cpage){
		if(rows<0)
			rows=0;
		if(psize<=0)
			psize=1;
		if(cpage<=0)
			cpage=1;

		this.curPage=cpage;
		this.rowCount=rows;
		this.pageSize=psize;
		if(this.rowCount%this.pageSize==0){
			this.pageCount=this.rowCount/this.pageSize;
		}else{
			this.pageCount=this.rowCount/this.pageSize+1;
		}
		
		if(curPage>1 && curPage>pageCount)
			curPage=pageCount;
	}
	
	/**
	 * 获取当前页面记录的行数
	 * @return 行数
	 */
	public int getCurPageRow(){
		if(curPage<pageCount)
			return pageSize;
		else
			return rowCount-(pageCount-1)*pageSize;
	}
	
	/**
	 * 获取当前页面
	 * @return 当前页面
	 */
	public int getCurPage(){
		return curPage;
	}
	
	/**
	 * 获取页面数
	 * @return 页面数
	 */
	public int getPageCount(){
		return pageCount;
	}
	
	/**
	 * 获取记录数
	 * @return 记录数
	 */
	public int getRowCount(){
		return rowCount;
	}
	
	/**
	 * 获取每页记录数
	 * @return 每页记录数
	 */
	public int getPageSize(){
		return pageSize;
	}
	
	/**
	 * 获取页面的控制调整菜单
	 * @param url 要跳转到的页面
	 * @return 菜单的HTML代码
	 */
	public String getControlPane(String url){
		if(StringUtils.isEmpty(url))
			return "";
		
		//如果页面数量小于1，则不输出任何HTML代码
		if(this.pageCount<=1)
			return "";
			
		//获取参数连字符
		char cnt;
		if(url.indexOf('?')==-1)
			cnt='?';
		else
			cnt='&';
			
		StringBuffer html=new StringBuffer();
		
		if(this.curPage!=1){
			html.append("<a class='blue' href='");
			html.append(url);
			html.append(cnt);
			html.append("page=");
			html.append(this.curPage-1);
			html.append("'>&lt;");
			html.append(Globals.getMessage("common", "common.link.previou"));
			html.append("</a>&nbsp");
		}
		
		if(this.curPage!=this.pageCount){
			html.append("<a class='blue' href='");
			html.append(url);
			html.append(cnt);
			html.append("page=");
			html.append(this.curPage+1);
			html.append("'>");
			html.append(Globals.getMessage("common", "common.link.next"));
			html.append("&gt;</a>");
		}
		
		return html.toString();		
	}
	
	/**
	 * 获取页面的控制调整菜单
	 * @param req 含查询参数的请求对象
	 * @param url 要跳转到的页面
	 * @return 菜单的HTML代码
	 */
	public String getControlPane(HttpServletRequest req, String url){
		
		url=url+getQueryString(req);
		
		return getControlPane(url);
	}
	
	/**
	 * 获取数字式的页面控制跳转面板
	 * @param url 要跳转到的页面
	 * @return 数字控制面板的HTML代码
	 */
	public String getDigitalPane(String url){
		if(StringUtils.isEmpty(url))
			return "";
		
		//如果页面数量小于1，则不输出任何HTML代码
		if(this.pageCount<=1)
			return "";
			
		//获取参数连字符
		char cnt;
		if(url.indexOf('?')==-1)
			cnt='?';
		else
			cnt='&';
			
		StringBuffer html=new StringBuffer();
		for(int i=1;i<=this.pageCount;i++){
			if(this.curPage==i){
				html.append("<span>[");
				html.append(i);
				html.append("]</span>&nbsp;");
			}else{
				html.append("<span>[<a class='blue' href='");
				html.append(url);
				html.append(cnt);
				html.append("page=");
				html.append(i);
				html.append("'>");
				html.append(i);
				html.append("</a>]</span>&nbsp;");
			}
		}
		
		return html.toString();
	}
	
	/**
	 * 获取数字式的页面控制跳转面板
	 * @param req 含查询参数的请求对象
	 * @param url 要跳转到的页面
	 * @return 数字控制面板的HTML代码
	 */
	public String getDigitalPane(HttpServletRequest req, String url){
		
		url=url+getQueryString(req);
		
		return getDigitalPane(url);
	}
	
	/**
	 * 获取请求对象中的查询字段
	 * @param req 请求对象
	 * @return 
	 */
	public String getQueryString(HttpServletRequest req){
		Enumeration pnames=req.getParameterNames();
		StringBuffer query=new StringBuffer();
		String tmpname;
		String tmpvalue;
		int i=0;
		while(pnames.hasMoreElements()){
			tmpname=(String)pnames.nextElement();
			if((tmpname!=null)&&(!tmpname.toLowerCase().equals("page"))){
				tmpvalue=req.getParameter(tmpname);
				if(tmpvalue!=null){
					if(i==0){
						query.append('?');
					}else{
						query.append('&');
					}
					query.append(tmpname);
					query.append('=');
					query.append(tmpvalue);
					i++;
				}
			}
		}
		
		return query.toString();
	}
}
