package org.myconf.util;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.myconf.Globals;

/**
 * @author Lee Bin
 *
 * ���ݵķ�ҳ��װ��
 */
public class Page {
	
	private int curPage; //��ǰҳ
	private int pageCount; //ҳ����
	private int rowCount; //��¼��
	private int pageSize; //ÿҳ��¼��

	/**
	 * Ĭ�ϵĹ��캯��
	 */
	public Page() {
	}
	
	/**
	 * ����ʼ�������Ĺ��캯��
	 * @param rows ��¼��
	 * @param psize ҳ���¼��С
	 * @param cpage ��ǰҳ
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
	 * ���ö���ķ�ҳ����
	 * @param rows ��¼��
	 * @param psize ҳ���¼��С
	 * @param cpage ��ǰҳ
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
	 * ��ȡ��ǰҳ���¼������
	 * @return ����
	 */
	public int getCurPageRow(){
		if(curPage<pageCount)
			return pageSize;
		else
			return rowCount-(pageCount-1)*pageSize;
	}
	
	/**
	 * ��ȡ��ǰҳ��
	 * @return ��ǰҳ��
	 */
	public int getCurPage(){
		return curPage;
	}
	
	/**
	 * ��ȡҳ����
	 * @return ҳ����
	 */
	public int getPageCount(){
		return pageCount;
	}
	
	/**
	 * ��ȡ��¼��
	 * @return ��¼��
	 */
	public int getRowCount(){
		return rowCount;
	}
	
	/**
	 * ��ȡÿҳ��¼��
	 * @return ÿҳ��¼��
	 */
	public int getPageSize(){
		return pageSize;
	}
	
	/**
	 * ��ȡҳ��Ŀ��Ƶ����˵�
	 * @param url Ҫ��ת����ҳ��
	 * @return �˵���HTML����
	 */
	public String getControlPane(String url){
		if(StringUtils.isEmpty(url))
			return "";
		
		//���ҳ������С��1��������κ�HTML����
		if(this.pageCount<=1)
			return "";
			
		//��ȡ�������ַ�
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
	 * ��ȡҳ��Ŀ��Ƶ����˵�
	 * @param req ����ѯ�������������
	 * @param url Ҫ��ת����ҳ��
	 * @return �˵���HTML����
	 */
	public String getControlPane(HttpServletRequest req, String url){
		
		url=url+getQueryString(req);
		
		return getControlPane(url);
	}
	
	/**
	 * ��ȡ����ʽ��ҳ�������ת���
	 * @param url Ҫ��ת����ҳ��
	 * @return ���ֿ�������HTML����
	 */
	public String getDigitalPane(String url){
		if(StringUtils.isEmpty(url))
			return "";
		
		//���ҳ������С��1��������κ�HTML����
		if(this.pageCount<=1)
			return "";
			
		//��ȡ�������ַ�
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
	 * ��ȡ����ʽ��ҳ�������ת���
	 * @param req ����ѯ�������������
	 * @param url Ҫ��ת����ҳ��
	 * @return ���ֿ�������HTML����
	 */
	public String getDigitalPane(HttpServletRequest req, String url){
		
		url=url+getQueryString(req);
		
		return getDigitalPane(url);
	}
	
	/**
	 * ��ȡ��������еĲ�ѯ�ֶ�
	 * @param req �������
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
