package org.myconf.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.myconf.beans.BBSBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.BBSDAO;
import org.myconf.formbean.BBSForm;
import org.myconf.util.RequestUtils;
import org.myconf.util.StringUtils;

/** 
 * ������ز���Action��
 */
public class BBSAction extends ActionBase {

	private final static Log log = LogFactory.getLog(BBSAction.class);
	
	/**
	 * ��������
	 * @param mapping ·��ӳ�����
	 * @param form ������
	 * @param request �������
	 * @param response ��Ӧ����
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doJoinDiscuss(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
		BBSForm bform = (BBSForm)form;
		ActionMessages msgs = new ActionMessages();
	
		//�ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsExpert()!=UserBean.TRUE && loginUser.getIsAdmin()!=UserBean.TRUE &&loginUser.getIsContent()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(StringUtils.isEmpty(bform.getFromPage()))
			msgs.add("err", new ActionMessage("error.unknow"));
		else{
			try {
				//��õ�ǰ���۵ĸ�����
				BBSBean fbbean=BBSDAO.getBBS(bform.getParentId());
				//���û�У�����ID��Ϊ0���򱨴�
				if(fbbean==null && bform.getParentId()!=0){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else{
					//�������
					BBSBean bbean=new BBSBean();
					bbean.setBoardName(BBSBean.BOARD_CONF);
					bbean.setParentId(bform.getParentId());
					bbean.setTitle(bform.getTitle());
					bbean.setContent(bform.getContent());
					bbean.setIsTop(BBSBean.FALSE);
					bbean.setStatus(BBSBean.STATUS_NORMAL);
					bbean.setAuthorId(loginUser.getId());
					bbean.setAuthorName(loginUser.getRealName());
					bbean.setVisitCount(0);
					bbean.setReplyCount(0);
					bbean.setCreateTime(new Timestamp(System.currentTimeMillis()));
					BBSDAO.save(bbean);
					
					//��������·������ۣ����������⸸���۵Ļظ���
					if(fbbean!=null){
						fbbean.setReplyCount(fbbean.getReplyCount()+1);
						BBSDAO.update(fbbean);
					}
				}

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when join discuss", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
	
		return new ActionForward(bform.getFromPage());
	}
	
	/**
	 * �ö�����
	 * @param mapping ·��ӳ�����
	 * @param form ������
	 * @param request �������
	 * @param response ��Ӧ����
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doTopDiscuss(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
		BBSForm bform = (BBSForm)form;
		ActionMessages msgs = new ActionMessages();
		int cnt=RequestUtils.getParam(request, "rowcnt", 0);
		int isCancel=RequestUtils.getParam(request, "ic", 0);
	
		//�ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(StringUtils.isEmpty(bform.getFromPage()))
			msgs.add("err", new ActionMessage("error.unknow"));
		else{
			try {
				if(cnt>0){
					//��һ��ȡҪ�ö������£����������ݿ�
					BBSBean bbean=null;
					for(int i=0;i<cnt;i++){
						bbean=BBSDAO.getBBS(RequestUtils.getParam(request, "id"+i, 0));
						if(bbean!=null && bbean.getParentId()==0){
							if(isCancel==1){
								bbean.setIsTop(BBSBean.FALSE);
							}else{
								bbean.setIsTop(BBSBean.TRUE);
							}
							BBSDAO.update(bbean);
						}
					}
				}

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when top discuss", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
	
		return new ActionForward(bform.getFromPage());
	}
	
	/**
	 * ɾ������
	 * @param mapping ·��ӳ�����
	 * @param form ������
	 * @param request �������
	 * @param response ��Ӧ����
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doDeleteDiscuss(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
		BBSForm bform = (BBSForm)form;
		ActionMessages msgs = new ActionMessages();
		int cnt=RequestUtils.getParam(request, "rowcnt", 0);
	
		//�ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else if(StringUtils.isEmpty(bform.getFromPage()))
			msgs.add("err", new ActionMessage("error.unknow"));
		else{
			try {
				if(cnt>0){
					//��һ��ȡҪɾ�������£����������ݿ�
					int delId=0;
					for(int i=0;i<cnt;i++){
						delId=RequestUtils.getParam(request, "id"+i, 0);
						if(delId>0){
							BBSDAO.delete(delId);
						}
					}
				}

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when delete discuss", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
	
		return new ActionForward(bform.getFromPage());
	}
}
