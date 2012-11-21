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
import org.myconf.beans.ReviewBean;
import org.myconf.beans.StatusBean;
import org.myconf.beans.UserBean;
import org.myconf.dao.ReviewDAO;
import org.myconf.dao.StatusDAO;
import org.myconf.formbean.ReviewForm;
import org.myconf.Globals;

/**
 * 评审操作相关的Action类
 * 
 * @author libin
 */
public class ReviewAction extends ActionBase {

	private final static Log log = LogFactory.getLog(ReviewAction.class);

	/**
	 * 给稿件打分(reviewpaper.jsp)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doGrade(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		ReviewForm rform = (ReviewForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsExpert() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//获取相应的评审记录
				ReviewBean rbean=ReviewDAO.getReview(rform.getId());
				//确认评审专家身份
				if(rbean==null){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else
				if(rbean.getExpert().getId()!=loginUser.getId()){
					msgs.add("err", new ActionMessage("error.can_not_access"));
				}else{
					//取得稿件推荐录用状态
					StatusBean status=StatusDAO.getStatus(rform.getRecoStatus());
					if(status==null){
						msgs.add("err", new ActionMessage("error.please.recommend.status"));
					}else{
						//更新评审记录
						rbean.setStatus(ReviewBean.REVIEW_STATUS_FINISH);
						rbean.setExpertName(loginUser.getRealName());
						rbean.setScore1(rform.getScore1());
						rbean.setScore2(rform.getScore2());
						rbean.setScore3(rform.getScore3());
						rbean.setScore4(rform.getScore4());
						rbean.setScore5(rform.getScore5());
						rbean.setScore6(rform.getScore6());
						rbean.setScore7(rform.getScore7());
						rbean.setScore8(rform.getScore8());
						rbean.setScore9(rform.getScore9());
						rbean.setScore10(rform.getScore10());
						rbean.setScore11(rform.getScore11());
						rbean.setScore12(rform.getScore12());
						rbean.setScore13(rform.getScore13());
						rbean.setScore14(rform.getScore14());
						rbean.setScore15(rform.getScore15());
						rbean.setScore16(rform.getScore16());
						rbean.setRecoStatus(rform.getRecoStatus());
						rbean.setOpinion(rform.getOpinion());
						rbean.setReviewTime(new Timestamp(System.currentTimeMillis()));
						
						ReviewDAO.update(rbean);
					}
				}

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when review paper", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return msgbox(mapping, form, request, response, Globals.getMessage("common", "msgbox.finish.review"), true);
	}

	/**
	 * 退审稿件(reviewing.jsp)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected ActionForward doQuit(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception 			
	{
		ReviewForm rform = (ReviewForm)form;
		ActionMessages msgs = new ActionMessages();
		
		// 判断用户是否登录
		UserBean loginUser = super.getLoginUser(request, response);
		if(loginUser == null)
			msgs.add("err", new ActionMessage("error.need_login"));
		else if(loginUser.getIsExpert() != UserBean.TRUE)
			msgs.add("err", new ActionMessage("error.can_not_access"));
		else{
			try {
				//获取相应的评审记录
				ReviewBean rbean=ReviewDAO.getReview(rform.getId());
				if(rbean==null || rbean.getStatus()==ReviewBean.REVIEW_STATUS_FINISH){
					msgs.add("err", new ActionMessage("error.unknow"));
				}else//确认评审专家身份
				if(rbean.getExpert().getId()!=loginUser.getId()){
					msgs.add("err", new ActionMessage("error.can_not_access"));
				}else{
					//退审稿件
					rbean.setStatus(ReviewBean.REVIEW_STATUS_QUIT);
					
					ReviewDAO.update(rbean);
				}

			} catch (Exception e) {
				msgs.add("err", new ActionMessage("error.db"));
				log.error("database error when quit paper", e);
			}
		}

		if (!msgs.isEmpty()) {
			saveMessages(request, msgs);
			return mapping.findForward("error");
		}

		return mapping.findForward("reviewing");
	}

}
