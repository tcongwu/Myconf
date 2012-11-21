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
 * ���ݵķ�ҳ��װ��
 */
public class Page {
	
	private int curPage; //��ǰҳ
	private int pageCount; //ҳ����
	private int rowCount; //��¼��
	private int pageSize; //ÿҳ��¼��

	private List dataList; //��ǰҳ�����ݼ�
	private Iterator it; //���ݵ��������

	/**
	 * Ĭ�ϵĹ��캯��
	 */
	public Page() {
	}
	
	/**
	 * ����ʼ�������Ĺ��캯��
	 * @param data �����б�
	 * @param psize ҳ���¼��С
	 * @param cpage ��ǰҳ
	 */
	public Page(List data, int cpage, int psize){
		setParam(data, cpage, psize);
	}
	
	/**
	 * ���ö���ķ�ҳ����
	 * @param data �����б�
	 * @param psize ҳ���¼��С
	 * @param cpage ��ǰҳ
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
	 * ��ȡ��ǰҳ���¼������
	 * @return ����
	 */
	public int getCurPageRow(){
		if(dataList!=null)
			return dataList.size();
		else
			return 0;
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
	 * ��ȡ����ǰҳ��Ҫ��ʾ������
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
	 * ��ȡ���ݱ�������
	 * @return Iterator ���ݱ�������
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
	 * ������ݼ�¼
	 * @param obj ���ݼ�¼����
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
	 * �ж��Ƿ�������ݼ�¼��û�б���
	 * @return �Ƿ����
	 */
	public boolean hasNext(){
		if(it==null)
			it=getIterator();
			
		if(it==null)
			return false;
			
		return it.hasNext();
	}
	
	/**
	 * ��ȡ��¼���е���һ�����ݼ�¼
	 * @return ���ݼ�¼����
	 */
	public Object next(){
		if(it==null)
			it=getIterator();
			
		if(it==null)
			return null;
			
		return it.next();
	}
	
	/**
	 * ��ȡҳ��Ŀ��Ƶ����˵�
	 * @param url Ҫ��ת����ҳ��
	 * @return �˵���HTML����
	 */
	public String getControlPane(String url){
		if(StringUtils.isEmpty(url) || this.pageCount==0)
			return "";
			
		//��ȡ�������ַ�
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
	 * ��ȡҳ��Ŀ��Ƶ����˵�
	 * @param req ����ѯ�������������
	 * @param url Ҫ��ת����ҳ��
	 * @return �˵���HTML����
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
	 * ��ȡ����ʽ��ҳ�������ת���
	 * @param url Ҫ��ת����ҳ��
	 * @return ���ֿ�������HTML����
	 */
	public String getDigitalPane(String url){
		if(StringUtils.isEmpty(url) || this.pageCount==0)
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
