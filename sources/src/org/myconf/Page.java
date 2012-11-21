package org.myconf;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.myconf.util.StringUtils;

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

	private List dataList; //当前页面数据集
	private Iterator it; //数据的输出集合

	/**
	 * 默认的构造函数
	 */
	public Page() {
	}
	
	/**
	 * 带初始化参数的构造函数
	 * @param data 数据列表
	 * @param psize 页面记录大小
	 * @param cpage 当前页
	 */
	public Page(List data, int cpage, int psize){
		setParam(data, cpage, psize);
	}
	
	/**
	 * 设置对象的分页参数
	 * @param data 数据列表
	 * @param psize 页面记录大小
	 * @param cpage 当前页
	 */
	public void setParam(List data, int cpage, int psize){
		if(data==null)
			this.rowCount=0;
		else
			this.rowCount=data.size();
			
		if(psize<=0)
			this.pageSize=1;
		else
			this.pageSize=psize;
			
		if(cpage<=0)
			this.curPage=1;
		else
			this.curPage=cpage;
			
		this.dataList=data;
		
		if(this.rowCount%this.pageSize==0){
			this.pageCount=this.rowCount/this.pageSize;
		}else{
			this.pageCount=this.rowCount/this.pageSize+1;
		}
		
		if(this.curPage>1 && this.curPage>this.pageCount)
			this.curPage=this.pageCount;
	}
	
	/**
	 * 获取当前页面记录的行数
	 * @return 行数
	 */
	public int getCurPageRow(){
		if(dataList!=null)
			return dataList.size();
		else
			return 0;
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
	 * 提取出当前页面要显示的数据
	 * @return
	 */
	private Iterator getIterator(){
		if(dataList==null || dataList.size()==0){
			return null;
		}
		int fromIndex=(this.curPage-1)*this.pageSize;
		if(fromIndex>=dataList.size()){
			return null;
		}
		int toIndex=this.curPage*this.pageSize;
		if(toIndex>dataList.size()){
			toIndex=dataList.size();
		}
		return dataList.subList(fromIndex, toIndex).iterator();
	}
	
	/**
	 * 获取数据遍历集合
	 * @return Iterator 数据遍历集合
	 */
	public Iterator getDataIterator(){
		if(it!=null)
			return it;
		else if(dataList!=null)
			return getIterator();
		else
			return null;
	}
	
	/**
	 * 添加数据记录
	 * @param obj 数据记录对象
	 */
	public void addData(Object obj){
		if(obj==null)
			return;
		
		if(dataList==null){
			dataList=new ArrayList();
			dataList.clear();
		}
		
		dataList.add(obj);
	}

	/**
	 * 判断是否存在数据记录还没有遍历
	 * @return 是否存在
	 */
	public boolean hasNext(){
		if(it==null)
			it=getIterator();
			
		if(it==null)
			return false;
			
		return it.hasNext();
	}
	
	/**
	 * 获取记录集中的下一个数据记录
	 * @return 数据记录对象
	 */
	public Object next(){
		if(it==null)
			it=getIterator();
			
		if(it==null)
			return null;
			
		return it.next();
	}
	
	/**
	 * 获取页面的控制调整菜单
	 * @param url 要跳转到的页面
	 * @return 菜单的HTML代码
	 */
	public String getControlPane(String url){
		if(StringUtils.isEmpty(url) || this.pageCount==0)
			return "";
			
		//获取参数连字符
		char cnt;
		if(url.indexOf('?')==-1)
			cnt='?';
		else
			cnt='&';
			
		StringBuffer html=new StringBuffer();
		html.append(Globals.getMessage("common", "common.link.page.summary", String.valueOf(curPage), String.valueOf(pageCount), String.valueOf(rowCount)));
		html.append("&nbsp;");
		
		if(this.curPage!=1){
			html.append("<a class='blue' href='");
			html.append(url);
			html.append(cnt);
			html.append("page=1'>&lt;&lt;");
			html.append(Globals.getMessage("common", "common.link.firstpage"));
			html.append("</a>&nbsp<a class='blue' href='");
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
			html.append("&gt;</a>&nbsp<a class='blue' href='");
			html.append(url);
			html.append(cnt);
			html.append("page=");
			html.append(this.pageCount);
			html.append("'>");
			html.append(Globals.getMessage("common", "common.link.lastpage"));
			html.append("&gt;&gt</a>&nbsp");
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
		
		if(StringUtils.isEmpty(url)){
			return "";
		}else{
			if(url.charAt(0)=='/'){
				url=Globals.root(req)+url+getQueryString(req);
			}else{
				url=url+getQueryString(req);
			}
		}
		
		return getControlPane(url);
	}
	
	/**
	 * 获取数字式的页面控制跳转面板
	 * @param url 要跳转到的页面
	 * @return 数字控制面板的HTML代码
	 */
	public String getDigitalPane(String url){
		if(StringUtils.isEmpty(url) || this.pageCount==0)
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
		
		if(StringUtils.isEmpty(url)){
			return "";
		}else{
			if(url.charAt(0)=='/'){
				url=Globals.root(req)+url+getQueryString(req);
			}else{
				url=url+getQueryString(req);
			}
		}
		
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
