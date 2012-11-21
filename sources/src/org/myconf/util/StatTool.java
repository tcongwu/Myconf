package org.myconf.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.myconf.MyCacheManager;
import org.myconf.beans.ConfigBean;
import org.myconf.beans.PaperBean;
import org.myconf.beans.base.SiteStatInfo;

import org.myconf.dao.ConfigDAO;
import org.myconf.dao.PaperDAO;
import org.myconf.dao.ReviewDAO;
import org.myconf.dao.StatDAO;
import org.myconf.dao.UserDAO;

/**
 * ������վ����ͳ�ƵĹ��߼�
 * @author lee bin
 */
public class StatTool{

	private final static Log log = LogFactory.getLog(StatTool.class);
	private final static String CACHE_KEY = "vstat";
	
	/**
	 * ��ȡ��վ�ķ���ͳ����Ϣ
	 * @return
	 */
	public static SiteStatInfo getSiteStatInfo() {

		SiteStatInfo ssi = (SiteStatInfo) MyCacheManager.getObjectCached(
				CACHE_KEY, "myconf_stat");

		if (ssi == null) {
			ssi = new SiteStatInfo();
			int[] stats=PaperDAO.statPaper();

			ssi.setUvThisMonth(StatDAO.getUVThisMonth());
			ssi.setUvThisWeek(StatDAO.getUVThisWeek());
			ssi.setUvThisYear(StatDAO.getUVThisYear());
			ssi.setUvToday(StatDAO.getUVToday());
			ssi.setUvTotal(StatDAO.getUVTotal());
			ssi.setUserCount(UserDAO.getUserCount());
			ssi.setAuthorCount(UserDAO.getAuthorCount());
			ssi.setPaperCount(stats[0]);
			ssi.setInPaperCount(stats[PaperBean.PAPER_STATE_NORMAL]);
			ssi.setOutPaperCount(stats[PaperBean.PAPER_STATE_ASSIGNED]);
			ssi.setQuitPaperCount(ReviewDAO.countQuits());
			if(ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID)!=null)
				ssi.setCreateTime(ConfigDAO.getCurrentConfig(ConfigBean.CONFIG_ID).getCreateTime());

			MyCacheManager.putObjectCached(CACHE_KEY, "myconf_stat", ssi);
		}
		return ssi;
	}
	
	/**
	 * ���շ����˴�
	 * @return
	 */
	public static long uv_today(){
		return StatDAO.getUVToday();
	}

	/**
	 * ���ܷ����˴�
	 * @return
	 */
	public static long uv_this_week(){
		return StatDAO.getUVThisWeek();
	}

	/**
	 * ���·����˴�
	 * @return
	 */
	public static long uv_this_month(){
		return StatDAO.getUVThisMonth();
	}

	/**
	 * ��������˴�
	 * @return
	 */
	public static long uv_this_year(){
		return StatDAO.getUVThisYear();
	}

	/**
	 * ���з����˴�
	 * @return
	 */
	public static long uv_total(){
		return StatDAO.getUVTotal();
	}

	/**
	 * �û�����
	 * @return
	 */
	public static long user_count(){
		return UserDAO.getUserCount();
	}

	/**
	 * �������
	 * @return
	 */
	public static long paper_count(){
		return PaperDAO.statPaper()[0];
	}
	
	/**
	 * ��¼ҳ�����ͳ��
	 */
	public static boolean execute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().isNew()){
			//д�����˴�
			try {
				StatDAO.writeStatData(1);
				return true;
			} catch (Exception e) {
				log.error("write visit stat failed.", e);
			}
		}
		return false;
	}
	
}
