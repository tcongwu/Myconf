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
 * 稿件操作相关的Action类
 * 
 * @author libin
 */
public class PaperAction extends ActionBase {

	private final static Log log = LogFactory.getLog(PaperAction.class);
	
	/**
	 * 提交稿件
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
		
		// 判断用户是否登录
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
				//把稿件信息保存入数据库
				PaperBean paper = PaperDAO.create(pform, loginUser);
				
				//保存稿件文件到磁盘
				if(!save(pform.getPfile(), paper.getId())){
					PaperDAO.deletePaper(paper);
					msgs.add("err", new ActionMessage("error.save.file.err"));
					
				}else{
					//更新session中的用户资料
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
	 * 修改稿件
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
		
		// 判断用户是否登录
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
				//修改稿件信息，保存入数据库
				PaperBean paper = PaperDAO.modify(pform, loginUser);
				//更新session中的用户资料
				UserLoginManager.updateLoginUser(request, paper.getSubUser());
				
				//如果上传了新稿件，覆盖原有稿件文件
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
	 * 删除稿件
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
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAuthor() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//获取要删除的稿件信息
				PaperBean paper = PaperDAO.getPaper(pform.getId());
				//判断当前用户是否拥有权限
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
	 * 判断该类型文件是否允许上传
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
	 * 判断上传稿件文件大小是否符合要求
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
	 * 保存稿件文件到磁盘
	 * 
	 * @param pfile 包含稿件文件数据的表单对象
	 * @param pid 稿件ID
	 * @return 是否保存成功
	 * @throws IOException
	 */
	protected boolean save(FormFile pfile, int pid) throws IOException {
		//获取稿件文件扩展名
		String ext = StringUtils.getFileExtend(pfile.getFileName()).toLowerCase();

		String spath = FileUtils.createPaperSavePath(pid, ext);
		if(spath==null)
			return false;
			
		FileUtils.writeToFile(pfile, spath);
		
		return true;
	}
	
	/**
	 * 分发稿件
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
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//分发稿件
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
	 * 把稿件放入回收站
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
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//获取要放入回收站的稿件信息
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
	 * 从回收站恢复稿件
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
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//获取要从回收站恢复的稿件信息
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
	 * 设置稿件最终录用状态
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
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				ConfigBean conf=ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID);
				
				//获取要设置录用结果的稿件信息
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
	 * 打包指定条件的稿件
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
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//获取要打包稿件的所属主题和录用状态信息
				subject=SubjectDAO.getSubject(pform.getSubject());
				status=StatusDAO.getStatus(pform.getStatus());
				
				//获取要打包的稿件的列表
				papers=PaperDAO.queryPaper(status, subject);
				PaperBean paper=null;
				if(papers!=null && papers.size()>0){
					//创建zip压缩包
					Archive archiver = ArchiverFactory.getInstance("zip");
					//逐一把要压缩的稿件放入压缩包
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
					//输出打包文件列表xls文件
					String xls=FileUtils.exportXLS(papers);
					if(StringUtils.isNotEmpty(xls))
						archiver.add(new File(xls));
					//输出压缩包
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
	 * 导出录用结果
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
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//获取要打包稿件的所属主题和录用状态信息
				subject=SubjectDAO.getSubject(pform.getSubject());
				status=StatusDAO.getStatus(pform.getStatus());
				
				//获取要打包的稿件的列表
				papers=PaperDAO.queryPaper(status, subject);
				if(papers!=null && papers.size()>0){
					//输出列表xls文件
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
