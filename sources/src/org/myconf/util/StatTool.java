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
 * 用于网站访问统计的工具集
 * @author lee bin
 */
public class StatTool{

	private final static Log log = LogFactory.getLog(StatTool.class);
	private final static String CACHE_KEY = "vstat";
	
	/**
	 * 获取网站的访问统计信息
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
	 * 今日访问人次
	 * @return
	 */
	public static long uv_today(){
		return StatDAO.getUVToday();
	}

	/**
	 * 本周访问人次
	 * @return
	 */
	public static long uv_this_week(){
		return StatDAO.getUVThisWeek();
	}

	/**
	 * 本月访问人次
	 * @return
	 */
	public static long uv_this_month(){
		return StatDAO.getUVThisMonth();
	}

	/**
	 * 今年访问人次
	 * @return
	 */
	public static long uv_this_year(){
		return StatDAO.getUVThisYear();
	}

	/**
	 * 素有访问人次
	 * @return
	 */
	public static long uv_total(){
		return StatDAO.getUVTotal();
	}

	/**
	 * 用户人数
	 * @return
	 */
	public static long user_count(){
		return UserDAO.getUserCount();
	}

	/**
	 * 稿件数量
	 * @return
	 */
	public static long paper_count(){
		return PaperDAO.statPaper()[0];
	}
	
	/**
	 * 记录页面访问统计
	 */
	public static boolean execute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().isNew()){
			//写访问人次
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
