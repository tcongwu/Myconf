package org.myconf.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.tags.StyleTag;
import org.htmlparser.util.NodeList;

import org.myconf.MCSecurityManager;
import org.myconf.SessionUserObject;
import org.myconf.UserLoginManager;
import org.myconf.beans.UserBean;
import org.myconf.dao.UserDAO;
import org.myconf.util.StringUtils;

/**
 * ��Struts��Action�������չ��ʵ��doXxxxx�Ĺ���<br/> eventSubmit_Xxxxx -> doXxxxx
 * 
 * @author liudong
 */
public abstract class ActionBase extends ActionExtend {

	private final static Log log = LogFactory.getLog(ActionBase.class);
	
	final static String ISO8859_1 = "8859_1";
	
	final static String KEY_SITE = "admin_action_site";
	final static String KEY_USER = "admin_action_user";
	
	protected final static String WML_IDENTITY = "WML";

	public final static int MAX_REPLY_LENGTH = 2000;	//���Ļظ����ݳ���
	public final static int MAX_TOPIC_LENGTH = 4000;	//��������ݳ���
	public final static int MAX_GB_COUNT_LENGTH = 2000;//�������Գ���

	/**
	 * ����ı���Ϣ�������
	 * @param res
	 * @param msg
	 * @throws IOException
	 */
	protected static void outputPlainMsg(HttpServletResponse res, String msg) throws IOException{
		res.setContentType("text/plain;charset=UTF-8");
		res.getWriter().print(msg);
	}
	
	/**
	 * ���˵�html�еĽű���Ϣ
	 * @param html
	 * @return
	 */
	protected static String filterScriptAndStyle(String html){
		if(StringUtils.isEmpty(html))
			return html;
		try{
			StringBuffer text = new StringBuffer();
			Parser parser = new Parser();
			parser.setEncoding("8859_1");
			parser.setInputHTML(html);
			//�������еĽڵ�
			NodeList nodes = parser.extractAllNodesThatMatch(scriptFilter);			
			for(int i=0;i<nodes.size();i++){
				Node node = nodes.elementAt(i);
				if(node instanceof TextNode)
					text.append(node.getText());
				else{
					text.append('<');
					text.append(node.getText());
					text.append('>');
				}
			}
			return text.toString();
		}catch(Exception e){
			log.error("Filter script exception ", e);
		}
		return html;
	}
	
	public static void main(String[] args){
		String html = "<p>��������(<a href=\"http://www.javayou.com\">Java������</a>)ɶʱ�����ŷ�����һ������</p><img src=\"http://www.dlog.cn/logo/dlog.vm\"/>";
		System.out.println(filterScriptAndStyle(html));
	}

	/**
	 * �������˳��ı��еĽű�����ʽ��Ϣ
	 * ���л�����һЩ�Ƿ���ͼƬ����
	 */
	private final static NodeFilter scriptFilter = new NodeFilter() {
		public boolean accept(Node node) {
			if(node instanceof ImageTag){
				ImageTag itag = (ImageTag)node;
				String url = itag.getImageURL();
				if(url!=null){
					url = url.toLowerCase();
					return url.endsWith(".jpg") || url.endsWith(".gif")
							|| url.endsWith(".png") || url.endsWith(".bmp");
				}
			}
			if(node instanceof StyleTag)
				return false;
			if(node instanceof ScriptTag)
				return false;
			if(node.getParent()!=null)
				return accept(node.getParent());
			return true;
		}
	};

	/**
	 * �Զ��ж��Ƿ�����ݽ��������ֹ���
	 * @param content
	 * @return
	 */
	protected static String autoFiltrate(String content) {
		if(StringUtils.isEmpty(content))
			return null;
			
		return MCSecurityManager.IllegalGlossary.autoGlossaryFiltrate(content);
	}
	
	/**
	 * �ж��ı����Ƿ����������
	 * @param text
	 * @return
	 */
	protected static boolean existIllegalWord(String text){
		return MCSecurityManager.IllegalGlossary.existIllegalWord(text);
	}
	
	/**
	 * �����������ʾ���ݵ�ģ��
	 * @return
	 * @throws IOException
	 */
	protected String getReplyNotifyTemplate() throws IOException{
		return getTemplate("/WEB-INF/conf/reply_notify.html");
	}
	
	/**
	 * ��ȡ����������ʾ����ģ��
	 * @return
	 * @throws IOException
	 */
	protected String getPasswordTipTemplate() throws IOException{
		return getTemplate("/WEB-INF/conf/password_tip.html");
		
	}

	/**
	 * ������ݵ�ģ��
	 * @return
	 * @throws IOException
	 */
	protected String getTemplate(String tmp) throws IOException{
		ServletContext sc = getServlet().getServletContext();
		InputStream in = sc.getResourceAsStream(tmp);
		StringBuffer template = new StringBuffer(512);
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(in));
			do{
				String line = reader.readLine();
				if(line==null)
					break;
				template.append(line);
				template.append("\r\n");
			}while(true);
		}finally{
			in.close();
		}
		return template.toString();
	}
	
	/**
	 * ��ʾ�ı���ʾ��Ϣ������ָ����url��ַ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param msg
	 * @param url
	 * @return
	 * @throws IOException 
	 */
	protected static ActionForward msgbox(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String msg, String url, boolean isLoad) throws IOException{
		
		if(StringUtils.isNotEmpty(msg))
			request.setAttribute("msg", msg);
		if(StringUtils.isNotEmpty(url))
			request.setAttribute("page", url);
		if(isLoad)
			request.setAttribute("reload", "true");
		
		return mapping.findForward("msgbox");
	}
	
	/**
	 * ���ؼ��ı��������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param msg
	 * @return
	 * @throws IOException 
	 */
	protected static ActionForward msgbox(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String msg) throws IOException
	{
		return msgbox(mapping,form,request,response,msg,null,false);
	}
	
	/**
	 * ���ؼ��ı��������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param msg
	 * @return
	 * @throws IOException 
	 */
	protected static ActionForward msgbox(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String msg, boolean isLoad) throws IOException
	{
		return msgbox(mapping,form,request,response,msg,null,isLoad);
	}
	
	/**
	 * ��ȡ��ǰ��¼�û�������
	 * 
	 * @param request
	 * @return
	 */
	protected static UserBean getLoginUserP(HttpServletRequest request,
			HttpServletResponse response) {
		return (UserBean)getLoginUser(request,response,true);
	}
	
	/**
	 * ��ȡ��ǰ��¼�û�������
	 * 
	 * @param request
	 * @return
	 */
	protected static UserBean getLoginUser(HttpServletRequest request,
			HttpServletResponse response) {
		return UserBean.copyFrom(getLoginUser(request,response,false));
	}

	/**
	 * ��ȡ��ǰ��¼�û�������
	 * 
	 * @param request
	 * @return
	 */
	protected static SessionUserObject getLoginUser(HttpServletRequest request,
			HttpServletResponse response, boolean persistence) {
		SessionUserObject user = UserLoginManager.getLoginUser(request, response, true);
		try {
			if(user != null && persistence)
				return UserDAO.getUserByID(user.getId());
		} catch (Exception e) {
			log.error("getLoginUser failed.", e);
		}
		return user;
	}

	protected static ActionForward makeForward(ActionForward forward, String extend) {
		StringBuffer uri = new StringBuffer(forward.getPath());
		if (uri.indexOf("?") >= 0)
			uri.append('&');
		else
			uri.append('?');
		uri.append(extend);
		return new ActionForward(uri.toString(), true);
	}

	protected static ActionForward makeForward(ActionForward forward, String p_name,
			String p_value) {
		StringBuffer uri = new StringBuffer(forward.getPath());
		if (uri.indexOf("?") >= 0)
			uri.append('&');
		else
			uri.append('?');
		uri.append(p_name);
		uri.append('=');
		uri.append(p_value);
		return new ActionForward(uri.toString(), true);
	}
	
}
