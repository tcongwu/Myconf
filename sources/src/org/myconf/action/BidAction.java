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

import org.myconf.Globals;
import org.myconf.beans.BidBean;
import org.myconf.beans.PaperBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.BidDAO;
import org.myconf.dao.PaperDAO;
import org.myconf.util.RequestUtils;

/**
 * ר�Ҿ��������ص�Action��
 * @author libin
 */
public class BidAction extends ActionBase {

	private final static Log log = LogFactory.getLog(BidAction.class);

	/**
	 * ���ר�Ҿ�������ļ�¼
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int paperId=RequestUtils.getParam(request, "id", 0);
		ActionMessages msgs = new ActionMessages();
		
		//�ж��û��Ƿ��¼
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsExpert()!=UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try{
				//�鿴�Ƿ���ڼ�¼
				BidBean obid=BidDAO.getBid(paperId, loginUser.getId());
				if(obid==null){
					//��ȡҪ�����ĸ����Ϣ
					PaperBean paper=PaperDAO.getPaper(paperId);
					if(paper==null){
						msgs.add("err", new ActionMessage("error.unknow"));
					}else{
						BidBean bid=new BidBean();
						bid.setPaper(paper);
						bid.setExpertId(loginUser.getId());
						bid.setExpertName(loginUser.getRealName());
						bid.setResearch(loginUser.getResearch());
						bid.setBidTime(new Timestamp(System.currentTimeMillis()));
						
						BidDAO.save(bid);
					}
				}else{
					obid.setExpertName(loginUser.getRealName());
					obid.setResearch(loginUser.getResearch());
					obid.setBidTime(new Timestamp(System.currentTimeMillis()));
					
					BidDAO.flush();
				}
				
			}catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when expert bid a paper", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}
		
		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.bid.paper.success"));
	}

}
