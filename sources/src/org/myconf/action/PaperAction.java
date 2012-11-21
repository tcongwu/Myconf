package org.myconf.action;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.Archive;
import org.apache.commons.compress.ArchiveException;
import org.apache.commons.compress.ArchiverFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.myconf.beans.ConfigBean;
import org.myconf.beans.PaperBean;
import org.myconf.beans.StatusBean;
import org.myconf.beans.SubjectBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.ConfigDAO;
import org.myconf.dao.PaperDAO;
import org.myconf.dao.StatusDAO;
import org.myconf.dao.SubjectDAO;
import org.myconf.formbean.PaperForm;

import org.myconf.Globals;
import org.myconf.UserLoginManager;
import org.myconf.util.FileUtils;
import org.myconf.util.StringUtils;

/**
 * ���������ص�Action��
 * 
 * @author libin
 */
public class PaperAction extends ActionBase {

	private final static Log log = LogFactory.getLog(PaperAction.class);
	
	/**
	 * �ύ���
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doUploadPaper(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAuthor() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(!pform.validateForm())
			msgs.add("err", new ActionMessage("error.staritem.not.null"));
		else if(StringUtils.isEmpty(pform.getPfile().getFileName()))
			msgs.add("err", new ActionMessage("error.paper.file.not.null"));
		else if(!accept(pform.getPfile()))
			msgs.add("err", new ActionMessage("error.wrong.doc.format", StringUtils.getFileExtend(pform.getPfile().getFileName())));
		else if(!isMatchSize(pform.getPfile()))
			msgs.add("err", new ActionMessage("error.filesize.larger", new Integer(getFileSize())));
		else{
			try {
				//�Ѹ����Ϣ���������ݿ�
				PaperBean paper = PaperDAO.create(pform, loginUser);
				
				//�������ļ�������
				if(!save(pform.getPfile(), paper.getId())){
					PaperDAO.deletePaper(paper);
					msgs.add("err", new ActionMessage("error.save.file.err"));
					
				}else{
					//����session�е��û�����
					UserLoginManager.updateLoginUser(request, paper.getSubUser());
				}
			} catch (IllegalArgumentException e) {
				msgs.add("err", new ActionMessage("error.unknow"));
				log.error("argument error when modify paper", e);
			} catch (Exception e) {
				msgs.add("result", new ActionMessage("error.db"));
				log.error("database error when upload paper", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return mapping.findForward("mypaper");
	}
	
	/**
	 * �޸ĸ��
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doModPaper(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAuthor() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(!pform.validateForm())
			msgs.add("err", new ActionMessage("error.staritem.not.null"));
		else if(pform.getPfile().getFileSize()>0 && !accept(pform.getPfile()))
			msgs.add("err", new ActionMessage("error.wrong.doc.format", StringUtils.getFileExtend(pform.getPfile().getFileName())));
		else if(pform.getPfile().getFileSize()>0 && !isMatchSize(pform.getPfile()))
			msgs.add("err", new ActionMessage("error.filesize.larger", new Integer(getFileSize())));
		else{
			try {
				//�޸ĸ����Ϣ�����������ݿ�
				PaperBean paper = PaperDAO.modify(pform, loginUser);
				//����session�е��û�����
				UserLoginManager.updateLoginUser(request, paper.getSubUser());
				
				//����ϴ����¸��������ԭ�и���ļ�
				if(pform.getPfile().getFileSize()>0 && !save(pform.getPfile(), paper.getId())){
					msgs.add("err", new ActionMessage("error.save.file.err"));
				}
			} catch (IllegalArgumentException e) {
				msgs.add("err", new ActionMessage("error.unknow"));
				log.error("argument error when modify paper", e);
			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when modify paper", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return mapping.findForward("mypaper");
	}
	
	/**
	 * ɾ�����
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doDelPaper(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAuthor() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//��ȡҪɾ���ĸ����Ϣ
				PaperBean paper = PaperDAO.getPaper(pform.getId());
				//�жϵ�ǰ�û��Ƿ�ӵ��Ȩ��
				ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
				if(paper.getSubUser().getId()!=loginUser.getId() || conf==null || conf.isStage()!=ConfigBean.STAGE_SUBMISSION){
					//if(paper.getSubUser().getId()!=loginUser.getId()){
					msgs.add("err", new ActionMessage("error.can_not_access"));
				}else{
					PaperDAO.deletePaper(paper);
				}
			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when delete paper", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return mapping.findForward("mypaper");
	}
	
	/**
	 * �жϸ������ļ��Ƿ������ϴ�
	 * @param file
	 * @return
	 */
	protected boolean accept(FormFile file){
		String ext = StringUtils.getFileExtend(file.getFileName());
		if(ext==null) 
			return false;
		String[] filesAccepted = ConfigDAO.getFileTypes(ConfigBean.CONFIG_ID);
		if(filesAccepted==null || filesAccepted.length==0)
			return false;
		
		for(int i=0;i<filesAccepted.length;i++){
			if(ext.equalsIgnoreCase(filesAccepted[i]))
				return true;
		}
		
		return false;
	}
	
	/**
	 * �ж��ϴ�����ļ���С�Ƿ����Ҫ��
	 * @param file
	 * @return
	 */
	protected boolean isMatchSize(FormFile file){
			
		int size=getFileSize()*1024*1024;
		
		if(file.getFileSize()>size)
			return false;
		
		return true;
	}
	
	protected int getFileSize(){
		ConfigBean conf = ConfigDAO.getConfigByID(ConfigBean.CONFIG_ID);
		int size=5;
		if(conf!=null && conf.getSubSize()>0)
			size=conf.getSubSize();
			
		return size;
	}
	
	/**
	 * �������ļ�������
	 * 
	 * @param pfile ��������ļ����ݵı�����
	 * @param pid ���ID
	 * @return �Ƿ񱣴�ɹ�
	 * @throws IOException
	 */
	protected boolean save(FormFile pfile, int pid) throws IOException {
		//��ȡ����ļ���չ��
		String ext = StringUtils.getFileExtend(pfile.getFileName()).toLowerCase();

		String spath = FileUtils.createPaperSavePath(pid, ext);
		if(spath==null)
			return false;
			
		FileUtils.writeToFile(pfile, spath);
		
		return true;
	}
	
	/**
	 * �ַ����
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAssign(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//�ַ����
				PaperDAO.assign(pform);

			} catch (IllegalArgumentException e) {
				msgs.add("err", new ActionMessage("error.unknow"));
				log.error("unknown error when assign paper", e);
			} catch (Exception ex) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when assign paper", ex);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.assign.paper.success"), true);
	}
	
	/**
	 * �Ѹ���������վ
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
		PaperForm pform = (PaperForm)form;
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
				PaperBean paper = PaperDAO.getPaper(pform.getId());
				if(paper==null){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else{
					paper.setState(PaperBean.PAPER_STATE_FORBIDDEN);
					PaperDAO.updatePaper(paper);
				}
			} catch (Exception ex) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when recycle paper", ex);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		String fromPage = pform.getFromPage();
		
		if (StringUtils.isNotEmpty(fromPage))
			return new ActionForward(fromPage, true);

		return mapping.findForward("paper");
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
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//��ȡҪ�ӻ���վ�ָ��ĸ����Ϣ
				PaperBean paper = PaperDAO.getPaper(pform.getId());
				if(paper==null){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else{
					paper.setState(PaperBean.PAPER_STATE_NORMAL);
					PaperDAO.updatePaper(paper);
				}
			} catch (Exception ex) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when recycle paper", ex);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		String fromPage = pform.getFromPage();
		
		if (StringUtils.isNotEmpty(fromPage))
			return new ActionForward(fromPage, true);

		return mapping.findForward("papercycle");
	}
	
	/**
	 * ���ø������¼��״̬
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doResult(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
				
				//��ȡҪ����¼�ý���ĸ����Ϣ
				PaperBean paper = PaperDAO.getPaper(pform.getId());
				if(paper==null || paper.getState()==PaperBean.PAPER_STATE_FORBIDDEN || !StatusDAO.containStatus(pform.getStatus())){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else
				if(conf!=null && conf.getIsOpen()==ConfigBean.TRUE){
					msgs.add("err", new ActionMessage("error.already.published"));
				}else{
					paper.setStatus(pform.getStatus());
					PaperDAO.updatePaper(paper);
				}
			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when set review result", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		String fromPage = pform.getFromPage();
		if ("msgbox".equals(fromPage))
			return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.assign.review.success"), true);

		return mapping.findForward("result");
	}
	
	/**
	 * ���ָ�������ĸ��
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doPack(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		SubjectBean subject=null;
		StatusBean status=null;
		List papers=null;
		File zipFile=null;
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//��ȡҪ�����������������¼��״̬��Ϣ
				subject=SubjectDAO.getSubject(pform.getSubject());
				status=StatusDAO.getStatus(pform.getStatus());
				
				//��ȡҪ����ĸ�����б�
				papers=PaperDAO.queryPaper(status, subject);
				PaperBean paper=null;
				if(papers!=null && papers.size()>0){
					//����zipѹ����
					Archive archiver = ArchiverFactory.getInstance("zip");
					//��һ��Ҫѹ���ĸ������ѹ����
					File srcFile=null;
					//String desPath=null;
					for(int i=0;i<papers.size();i++){
						paper=(PaperBean)papers.get(i);
						srcFile=FileUtils.getPaperFile(paper.getId(), paper.getFilePath());
						archiver.add(srcFile);
						//desPath=FileUtils.getRenameFile(paper.getTitle(), paper.getFilePath());
						//if(FileUtils.copyFile(srcFile, desPath)){
						//	archiver.add(new File(desPath));
						//}else{
						//	throw new FileNotFoundException();
						//}
					}
					//�������ļ��б�xls�ļ�
					String xls=FileUtils.exportXLS(papers);
					if(StringUtils.isNotEmpty(xls))
						archiver.add(new File(xls));
					//���ѹ����
					zipFile=FileUtils.getZipFile(status, subject);
					archiver.save(zipFile);
				}else{
					msgs.add("err", new ActionMessage("error.file.not.found"));
				}
				
			} catch (ArchiveException ea) {
				msgs.add("err", new ActionMessage("error.pack"));
				log.error("zip error when pack papers", ea);
			} catch (FileNotFoundException ef) {
				msgs.add("err", new ActionMessage("error.file.not.found"));
				log.error("file not found error when pack papers", ef);
			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when pack papers", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		request.setAttribute("status", status);
		request.setAttribute("subject", subject);
		request.setAttribute("sum", String.valueOf(papers.size()));
		request.setAttribute("zipFile", zipFile.getName());
		return mapping.findForward("downpack");
	}
	
	/**
	 * ����¼�ý��
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doExport(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		PaperForm pform = (PaperForm)form;
		ActionMessages msgs = new ActionMessages();
		SubjectBean subject=null;
		StatusBean status=null;
		List papers=null;
		String xls=null;
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//��ȡҪ�����������������¼��״̬��Ϣ
				subject=SubjectDAO.getSubject(pform.getSubject());
				status=StatusDAO.getStatus(pform.getStatus());
				
				//��ȡҪ����ĸ�����б�
				papers=PaperDAO.queryPaper(status, subject);
				if(papers!=null && papers.size()>0){
					//����б�xls�ļ�
					xls=FileUtils.exportXLS(papers);
					//if(StringUtils.isEmpty(xls)){
						//msgs.add("err", new ActionMessage("error.file.not.found"));
					//}
				}else{
					msgs.add("err", new ActionMessage("error.file.not.found"));
				}
				
			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when pack papers", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return new ActionForward("/submission/paper/temp/list.xls");
	}

}
