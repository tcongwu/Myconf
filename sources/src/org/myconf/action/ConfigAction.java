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

import org.myconf.beans.ConfigBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.ConfigDAO;
import org.myconf.formbean.ConfigForm;
import org.myconf.util.StringUtils;

/**
 * ϵͳ������ص�Action��
 * @author libin
 */
public class ConfigAction extends ActionBase {

	private final static Log log = LogFactory.getLog(ConfigAction.class);

	/**
	 * ����ϵͳ����
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @wml_only modify_pwd.vm
	 */
	protected ActionForward doSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ConfigForm conf = (ConfigForm) form;
		ActionMessages msgs = new ActionMessages();
		
		// �ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsAdmin()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try{
				boolean isSave=false;
				//�����ݿ��ж�ȡ������Ϣ
				ConfigBean cbean=ConfigDAO.getConfigByID(ConfigBean.CONFIG_ID);
				if(cbean==null){
					cbean=new ConfigBean();
					cbean.setId(ConfigBean.CONFIG_ID);
					isSave=true;
				}
				
				//���ñ������޸����ݶ���
				if(StringUtils.isNotEmpty(conf.getSubIns()))
					cbean.setSubIns(conf.getSubIns());
				if(StringUtils.isNotEmpty(conf.getSubFormat()))
					cbean.setSubFormat(conf.getSubFormat());
				if(conf.getSubSize()>0)
					cbean.setSubSize(conf.getSubSize());
				if(conf.getSubBeginDate()>0)
					cbean.setSubBeginDate(conf.getSubBeginDate());
				if(conf.getSubEndDate()>0)
					cbean.setSubEndDate(conf.getSubEndDate());
				if(conf.getConBeginDate()>0)
					cbean.setConBeginDate(conf.getConBeginDate());
				if(conf.getConEndDate()>0)
					cbean.setConEndDate(conf.getConEndDate());
				if(StringUtils.isNotEmpty(conf.getReviewIns()))
					cbean.setReviewIns(conf.getReviewIns());
				if(conf.getReviewBeginDate()>0)
					cbean.setReviewBeginDate(conf.getReviewBeginDate());
				if(conf.getReviewEndDate()>0)
					cbean.setReviewEndDate(conf.getReviewEndDate());
				if(conf.getIsAnony()>0)
					cbean.setIsAnony(conf.getIsAnony());
				if(StringUtils.isNotEmpty(conf.getEmail()))
					cbean.setEmail(conf.getEmail());
				if(StringUtils.isNotEmpty(conf.getPass()))
					cbean.setPass(conf.getPass());
				if(conf.getBySSL()>0)
					cbean.setBySSL(conf.getBySSL());
				if(StringUtils.isNotEmpty(conf.getSmtp()))
					cbean.setSmtp(conf.getSmtp());
				if(conf.getPort()>0)
					cbean.setPort(conf.getPort());
				if(conf.getIsProcess()>0)
					cbean.setIsProcess(conf.getIsProcess());
				if(conf.getIsOpen()>0)
					cbean.setIsOpen(conf.getIsOpen());
				cbean.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				if(isSave)
					cbean.setCreateTime(new Timestamp(System.currentTimeMillis()));
				
				//���������ݿ�
				if(isSave)
					ConfigDAO.createConfig(cbean);
				else
					ConfigDAO.updateConfig(cbean);
					
				//���±�����ϵͳ�е�������Ϣ
				ConfigDAO.setCurrentConfig(cbean);
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when save system config", e);
			}
		}
		System.out.println(request.getRequestURI()+":"+request.getContextPath());
		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		String fromPage = conf.getFromPage();
		if (StringUtils.isNotEmpty(fromPage))
			return new ActionForward(fromPage);
		
		return mapping.findForward("home.admin");
	}

}
