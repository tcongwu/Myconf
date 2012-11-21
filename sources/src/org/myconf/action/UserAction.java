package org.myconf.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import org.myconf.AuthTag;
import org.myconf.MCUserManager;
import org.myconf.Globals;
import org.myconf.UserLoginManager;
import org.myconf.beans.MailBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.UserDAO;
import org.myconf.formbean.UserForm;
import org.myconf.util.StringUtils;

/**
 * �û�������ص�Action��
 * @author libin
 */
public class UserAction extends ActionBase {

	private final static Log log = LogFactory.getLog(UserAction.class);

	private final static int PASSLEN = 6;
	
	/**
	 * �û���¼
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();
		UserBean ubean = null;
		
		//�������ݵĺϷ���
		if (StringUtils.isEmpty(user.getEmail()))
			msgs.add("email", new ActionMessage("error.email.not.null"));
		else if (!StringUtils.isEmail(user.getEmail()))
			msgs.add("email", new ActionMessage("error.email.wrong.format"));
		else if (StringUtils.isEmpty(user.getPassword()))
			msgs.add("password", new ActionMessage("error.password.not.null"));
		else {
			ubean = MCUserManager.getUserByEmail(user.getEmail());
			if (ubean == null || !StringUtils.equals(ubean.getPassword(), user.getPassword()))
				msgs.add("password", new ActionMessage("error.auth.failed"));
			else if (ubean.getStatus() != UserBean.STATUS_NORMAL) {
				msgs.add("user", new ActionMessage("error.user.disabled"));
			} else {
				// ִ�е�¼����
				UserLoginManager.loginUser(request, response, ubean);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		String fromPage = user.getFromPage();
		
		if (StringUtils.isNotEmpty(fromPage))
			return new ActionForward(fromPage, true);
		
		if(ubean.getIsAuthor()==UserBean.TRUE)
			return mapping.findForward("home.author");
		else if(ubean.getIsExpert()==UserBean.TRUE)
			return mapping.findForward("home.expert");
		else if(ubean.getIsAdmin()==UserBean.TRUE)
			return mapping.findForward("home.admin");
		else if(ubean.getIsContent()==UserBean.TRUE)
			return mapping.findForward("home.site");

		msgs.add("err", new ActionMessage("error.can_not_access"));
		saveMessages(request, msgs);
		return mapping.findForward("error");
		
	}
	
	/**
	 * ��ɫ�л�
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doSelectRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		ActionMessages msgs = new ActionMessages();
		String role=request.getParameter("rid");
		
		if(AuthTag.MODULE_AUTHOR.equals(role))
			return mapping.findForward("home.author");
		else if(AuthTag.MODULE_EXPERT.equals(role))
			return mapping.findForward("home.expert");
		else if(AuthTag.MODULE_ADMIN.equals(role))
			return mapping.findForward("home.admin");
		else if(AuthTag.MODULE_SITE.equals(role))
			return mapping.findForward("home.site");

		msgs.add("err", new ActionMessage("error.unknow"));
		saveMessages(request, msgs);
		return mapping.findForward("error");
		
	}

	/**
	 * �û�ע�������COOKIE
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doLogout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//ִ��ע������
		UserLoginManager.logoutUser(request, response);
		
		String fromPage=request.getParameter("fromPage");
		if (StringUtils.isNotEmpty(fromPage))
			return new ActionForward(fromPage, true);
		return mapping.findForward("login");
	}
	
	/**
	 * ��������(forgetpass.jsp)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doForgetPass(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();

		//���email�ĺϷ���
		if (StringUtils.isEmpty(user.getEmail()))
			msgs.add("email", new ActionMessage("error.email.not.null"));
		else if (!StringUtils.isEmail(user.getEmail()))
			msgs.add("email", new ActionMessage("error.email.wrong.format"));
		else {
			try {
				//���email�û��Ƿ����
				UserBean ubean = UserDAO.getUserByEmail(user.getEmail());
				if (ubean == null) {
					msgs.add("err", new ActionMessage("error.user.not.available", user.getEmail()));
				}else{

					String[] toAddress = {ubean.getEmail()};
					
					//�����ʼ����ݶ���
					MailBean mail=MailAction.createMail();
				
					mail.setTo(toAddress);
					mail.setSubject(Globals.getMessage("common", "mail.forgetpass.subject"));
					mail.setContent(Globals.getMessage("common", "mail.forgetpass.content", ubean.getRealName(), ubean.getPassword(), StringUtils.exportDate(new Date(), "yyyy-MM-dd HH:mm")));
				
					log.info("sending mail("+mail.getSubject()+") to "+mail.getTo()[0]);
					MailAction.sendMail(mail);
					log.info("sending mail success...");
				}

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.sending.mail"));
				log.error("send pass mail error.", e);
			}
		}
		
		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.send.pass.mail"));
	}

	/**
	 * �޸��û��ĵ�¼����
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doChgPwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getId() != user.getId())
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			UserBean ubean = UserDAO.getUserByID(user.getId());
			if (ubean == null || ubean.getStatus()!=UserBean.STATUS_NORMAL) {
				msgs.add("err", new ActionMessage("error.user.not.available",	new Integer(user.getId())));
			}else if(!StringUtils.equals(user.getPassword(), ubean.getPassword()))
				msgs.add("err", new ActionMessage("error.old.password.err"));
			else if(StringUtils.isEmpty(user.getPassword2())||(user.getPassword2().length()<PASSLEN))
				msgs.add("err", new ActionMessage("error.password.not.less.six"));
			else if(!StringUtils.equals(user.getPassword2(), user.getPassword3()))
				msgs.add("err", new ActionMessage("error.confirmpass.not.match"));
			else{
				ubean.setPassword(user.getPassword2());
				try {
					MCUserManager.update(ubean);
				} catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when change user password", e);
				}
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.change.password.success"));
	}
	
	/**
	 * �û����ϸ���
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getId() != user.getId())
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			UserBean ubean = UserDAO.getUserByID(user.getId());
			if (ubean == null || ubean.getStatus()!=UserBean.STATUS_NORMAL) {
				msgs.add("err", new ActionMessage("error.user.not.available",	new Integer(user.getId())));
			}else{
				ubean.getName().setTitle(user.getTitle());
				ubean.getName().setFirstName(user.getFirstName());
				ubean.getName().setLastName(user.getLastName());
				ubean.setWorkLocation(user.getWorkLocation());
				ubean.setResearch(user.getResearch());
				ubean.setPhone(user.getPhone());
				ubean.setFax(user.getFax());
				ubean.setAddress(user.getAddress());
				ubean.setPostcode(user.getPostcode());
				ubean.setState(user.getState());
				ubean.setCountry(user.getCountry());
				
				try {
					MCUserManager.update(ubean);
					//����session�е��û�����
					UserLoginManager.updateLoginUser(request, ubean);		
				} catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when update user", e);
				}
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.update.user.success"));
	}
	
	/**
	 * �û�ע��
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doRegister(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();

		//��֤�û�ע���
		if (StringUtils.isEmpty(user.getEmail()))
			msgs.add("err", new ActionMessage("error.email.not.null"));
		else if (!StringUtils.isEmail(user.getEmail()))
			msgs.add("err", new ActionMessage("error.email.wrong.format"));
		else if (StringUtils.isEmpty(user.getPassword()))
			msgs.add("err", new ActionMessage("error.password.not.null"));
		else if (!StringUtils.equals(user.getPassword(), user.getPassword2()))
			msgs.add("err", new ActionMessage("error.confirmpass.not.match"));
		else if (user.getPassword().length()<PASSLEN)
			msgs.add("err", new ActionMessage("error.password.not.less.six"));
		else {
			//�鿴email�Ƿ��Ѿ�����
			UserBean ebean = UserDAO.getUserByEmail(user.getEmail());
			if (ebean != null && (ebean.getStatus()==UserBean.STATUS_NORMAL)) {
				return mapping.findForward("existuser");
			}else if(ebean != null && (ebean.getStatus()!=UserBean.STATUS_NORMAL)){
				msgs.add("err", new ActionMessage("error.user.not.available",	new Integer(ebean.getId())));
			}else{
				//�����û�
				UserBean ubean = user.formToBean();
				try {

					ubean.setIsAuthor(UserBean.TRUE);
					ubean.setIsAdmin(UserBean.FALSE);
					ubean.setIsContent(UserBean.FALSE);
					ubean.setIsExpert(UserBean.FALSE);
					ubean.setStatus(UserBean.STATUS_NORMAL);
					ubean.setLastAddr(request.getRemoteAddr());
				
					Timestamp ct = new Timestamp(System.currentTimeMillis());
					ubean.setRegTime(ct);
					ubean.setLastTime(ct);

					MCUserManager.create(ubean);
					// ִ�е�¼����
					UserLoginManager.loginUser(request, response, ubean);
				} catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when register", e);
				}
			}
		}
		
		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		//String fromPage = user.getFromPage();
		//if (StringUtils.isNotEmpty(fromPage))
			//return new ActionForward(fromPage, true);
		
		return mapping.findForward("submission");
	}
	
	/**
	 * ����û�(useradd.jsp)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAddUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();

		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else//��֤�û�ע���
		if (StringUtils.isEmpty(user.getEmail()))
			msgs.add("err", new ActionMessage("error.email.not.null"));
		else if (!StringUtils.isEmail(user.getEmail()))
			msgs.add("err", new ActionMessage("error.email.wrong.format"));
		else if (StringUtils.isEmpty(user.getPassword()))
			msgs.add("err", new ActionMessage("error.password.not.null"));
		else if (StringUtils.isEmpty(user.getFirstName()) || StringUtils.isEmpty(user.getLastName()) || StringUtils.isEmpty(user.getWorkLocation()))
			msgs.add("err", new ActionMessage("error.staritem.not.null"));
		else {
			//�鿴email�Ƿ��Ѿ�����
			UserBean ebean = UserDAO.getUserByEmail(user.getEmail());
			if (ebean != null) {
				msgs.add("err", new ActionMessage("error.email.exist"));
			}else{
				
				try {
					//�����û�
					UserBean ubean = user.formToBean();
					if(user.getIsAdmin()==1)
						ubean.setIsAdmin(UserBean.TRUE);
					else
						ubean.setIsAdmin(UserBean.FALSE);
					
					if(user.getIsAuthor()==1)
						ubean.setIsAuthor(UserBean.TRUE);
					else
						ubean.setIsAuthor(UserBean.FALSE);
					
					if(user.getIsContent()==1)
						ubean.setIsContent(UserBean.TRUE);
					else
						ubean.setIsContent(UserBean.FALSE);
					
					if(user.getIsExpert()==1)
						ubean.setIsExpert(UserBean.TRUE);
					else
						ubean.setIsExpert(UserBean.FALSE);
					
					ubean.setStatus(UserBean.STATUS_NORMAL);
					ubean.setLastAddr(request.getRemoteAddr());
				
					Timestamp ct = new Timestamp(System.currentTimeMillis());
					ubean.setRegTime(ct);
					ubean.setLastTime(ct);
					
					//д�����ݿ�
					MCUserManager.create(ubean);

				} catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when add user", e);
				}
			}
		}
		
		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return mapping.findForward("alluser1");
	}
	
	/**
	 * �޸��û�(useredit.jsp)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doEditUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();

		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else//��֤�û�ע���
		if (StringUtils.isEmpty(user.getEmail()) || !StringUtils.isEmail(user.getEmail()))
			msgs.add("err", new ActionMessage("error.operate.illegal"));
		else if (StringUtils.isEmpty(user.getPassword()))
			msgs.add("err", new ActionMessage("error.password.not.null"));
		else if (StringUtils.isEmpty(user.getFirstName()) || StringUtils.isEmpty(user.getLastName()) || StringUtils.isEmpty(user.getWorkLocation()))
			msgs.add("err", new ActionMessage("error.staritem.not.null"));
		else {
			try {
				//��ȡҪ�޸ĵ��û�
				UserBean ubean = UserDAO.getUserByEmail(user.getEmail());
				if (ubean == null) {
					msgs.add("err", new ActionMessage("error.unknow"));
				}else{
				
					//�޸���Ϣ
					if(user.getIsAdmin()==1)
						ubean.setIsAdmin(UserBean.TRUE);
					else
						ubean.setIsAdmin(UserBean.FALSE);
					
					if(user.getIsAuthor()==1)
						ubean.setIsAuthor(UserBean.TRUE);
					else
						ubean.setIsAuthor(UserBean.FALSE);
					
					if(user.getIsContent()==1)
						ubean.setIsContent(UserBean.TRUE);
					else
						ubean.setIsContent(UserBean.FALSE);
					
					if(user.getIsExpert()==1)
						ubean.setIsExpert(UserBean.TRUE);
					else
						ubean.setIsExpert(UserBean.FALSE);
					
					//��ֵ
					ubean.setPassword(user.getPassword());
					ubean.getName().setTitle(user.getTitle());
					ubean.getName().setFirstName(user.getFirstName());
					ubean.getName().setLastName(user.getLastName());

					ubean.setWorkLocation(user.getWorkLocation());
					ubean.setResearch(user.getResearch());
					ubean.setPhone(user.getPhone());
					ubean.setFax(user.getFax());
					ubean.setAddress(user.getAddress());
					ubean.setPostcode(user.getPostcode());
					ubean.setState(user.getState());
					ubean.setCountry(user.getCountry());
					
					//д�����ݿ�
					MCUserManager.update(ubean);
				}

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when edit user", e);
			}
		}
		
		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.edit.user.success"));
	}
	
	/**
	 * �����������ר��(useradds.jsp)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAddUsers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();
		Timestamp ct = new Timestamp(System.currentTimeMillis());
		List instructions=new ArrayList();
		List users=new ArrayList();

		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else //��֤ר���б�Excel�ĵ�
		if(StringUtils.isEmpty(user.getUfile().getFileName()) || user.getUfile().getFileSize()==0)
			msgs.add("err", new ActionMessage("error.expert.list.not.null"));
		else if(!isExcel(user.getUfile()))
			msgs.add("err", new ActionMessage("error.must.be.xls"));
		else {
			try{
				//����������
				Workbook wbook=Workbook.getWorkbook(user.getUfile().getInputStream());
				Sheet sheet=null;
				UserBean ucell=null;
				UserBean ubean=null;
				String[] instruction=null;
				if(wbook.getNumberOfSheets()>0){
					sheet=wbook.getSheet(0);
					if(sheet.getColumns()!=13 || sheet.getRows()==0){
						msgs.add("err", new ActionMessage("error.please.refer.template"));
					}else{
						//��������
						for(int i=0;i<sheet.getRows();i++){
							ucell=UserBean.convertToBean(sheet.getRow(i));
							
							//�����¼����ϵͳĬ�ϵ�����ѡ������������¼����
							if(ucell!=null && !"*EMAIL(�����ʼ�)".equalsIgnoreCase(ucell.getEmail()) && !"myconf.org@gmail.com".equalsIgnoreCase(ucell.getEmail())){
								instruction=new String[3];
								//������ݲ�ȫ������¼���ݣ�����ʾ
								if(StringUtils.isEmpty(ucell.getEmail()) || !StringUtils.isEmail(ucell.getEmail()) || StringUtils.isEmpty(ucell.getPassword()) || StringUtils.isEmpty(ucell.getName().getFirstName()) || StringUtils.isEmpty(ucell.getName().getLastName()) || StringUtils.isEmpty(ucell.getWorkLocation())){
									instruction[0]='#'+String.valueOf(i);
									instruction[1]=ucell.getEmail();
									instruction[2]=Globals.getMessage("common", "error.excel.staritem.not.null");
									instructions.add(instruction);
								}else{
									//�鿴�û��Ƿ��Ѿ�����
									ubean=UserDAO.getUserByEmail(ucell.getEmail());
									//����û��Ѿ����ڣ������Ѿ������û��б�
									if(ubean!=null){
										users.add(ubean);
									}else{
										ucell.setIsExpert(UserBean.TRUE);
										ucell.setIsAdmin(UserBean.FALSE);
										ucell.setIsAuthor(UserBean.FALSE);
										ucell.setIsContent(UserBean.FALSE);
										ucell.setStatus(UserBean.STATUS_NORMAL);
										ucell.setOnlineStatus(UserBean.STATUS_OFFLINE);
										ucell.setRegTime(ct);
										ucell.setLastTime(ct);
										//д�����ݿ�
										MCUserManager.create(ucell);
										instruction[0]='#'+String.valueOf(i);
										instruction[1]=ucell.getEmail();
										instruction[2]=Globals.getMessage("common", "msgbox.add.expert.success");
										instructions.add(instruction);
									}
								}
							}
						}
					}
				}else{
					msgs.add("err", new ActionMessage("error.please.refer.template"));
				}
				
			} catch (BiffException be) {
				msgs.add("err", new ActionMessage("error.create.workbook"));
				log.error("create workbook failed", be);
			} catch (IOException ie) {
				msgs.add("err", new ActionMessage("error.create.workbook"));
				log.error("create workbook failed", ie);
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("batch add expert failed", e);
			}
		}
		
		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		request.setAttribute("instructions", instructions);
		request.setAttribute("users", users);
		return mapping.findForward("addok");
	}
	
	/**
	 * �ж��Ƿ�ΪExcel�ĵ�
	 * @param file
	 * @return
	 */
	protected boolean isExcel(FormFile file){
		String ext = StringUtils.getFileExtend(file.getFileName());
		if(ext==null) 
			return false;
			
		return ext.equalsIgnoreCase("xls");
	}
	
	/**
	 * ���û��������վ����ʹ�û���Ч
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doRecycle(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//��ȡҪ�������վ�ĸ����Ϣ
				UserBean ubean = UserDAO.getUserByID(user.getId());
				if(ubean==null){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else{
					ubean.setStatus(UserBean.STATUS_FORBIDDEN);
					MCUserManager.update(ubean);
				}
			} catch (Exception ex) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when delete user", ex);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return mapping.findForward("alluser");
	}
	
	/**
	 * �ӻ���վ�ָ����
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doRecover(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//��ȡҪ�������վ�ĸ����Ϣ
				UserBean ubean = UserDAO.getUserByID(user.getId());
				if(ubean==null){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else{
					ubean.setStatus(UserBean.STATUS_NORMAL);
					MCUserManager.update(ubean);
				}
			} catch (Exception ex) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when recover user", ex);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return mapping.findForward("usercycle");
	}
	
	/**
	 * Ϊ�Ѵ����û����Ͷ���û����
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAddAuthor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		UserForm user = (UserForm) form;
		ActionMessages msgs = new ActionMessages();
		
		//����û���
		if (StringUtils.isEmpty(user.getPassword()))
			msgs.add("err", new ActionMessage("error.password.not.null"));
		else{
			//����email��ȡ�û�
			UserBean ubean = UserDAO.getUserByEmail(user.getEmail());
			if (ubean == null || ubean.getStatus()!=UserBean.STATUS_NORMAL) {
				msgs.add("err", new ActionMessage("error.operate.illegal"));
			}else if(!StringUtils.equals(ubean.getPassword(), user.getPassword())){
				msgs.add("err", new ActionMessage("error.can_not_access"));
			}else{
				
				ubean.setIsAuthor(UserBean.TRUE);
				try {
					//�����û�
					UserDAO.updateUser(ubean);
					
					// ִ�е�¼����
					UserLoginManager.loginUser(request, response, ubean);
					UserLoginManager.updateLoginUser(request, ubean);
				} catch (Exception e) {
					msgs.add("err", new ActionMessage("error.db"));
					log.error("database error when update user", e);
				}
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return mapping.findForward("submission");
	}

}
