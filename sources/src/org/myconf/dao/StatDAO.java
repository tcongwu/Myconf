package org.myconf.dao;

import java.sql.Timestamp;
import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.myconf.beans.StatBean;

/**
 * 访问统计
 * @author Winter Lau
 */
public class StatDAO extends DAO {

	/**
	 * 今日访问人次
	 * @param site
	 * @return
	 */
	public static long getUVToday(){		
		Calendar cal = Calendar.getInstance();
		int statDate = cal.get(Calendar.YEAR)*10000 + cal.get(Calendar.MONTH)*100 + cal.get(Calendar.DATE);
		return toLong(executeNamedStat("VISIT_STAT", statDate), 1);
	}

	/**
	 * 本周访问人次
	 * @param site
	 * @return
	 */
	public static long getUVThisWeek(){	
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		if(week > 1)
			cal.add(Calendar.DATE, 1-week);
		int statDate = cal.get(Calendar.YEAR)*10000 + cal.get(Calendar.MONTH)*100 + cal.get(Calendar.DATE);
		return toLong(executeNamedStat("VISIT_STAT", statDate), 1);
	}

	/**
	 * 本月访问人次
	 * @param site
	 * @return
	 */
	public static long getUVThisMonth(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		int statDate = cal.get(Calendar.YEAR)*10000 + cal.get(Calendar.MONTH)*100 + cal.get(Calendar.DATE);
		return toLong(executeNamedStat("VISIT_STAT", statDate), 1);
	}

	/**
	 * 今年访问人次
	 * @param site
	 * @return
	 */
	public static long getUVThisYear(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		int statDate = cal.get(Calendar.YEAR)*10000 + cal.get(Calendar.MONTH)*100 + cal.get(Calendar.DATE);
		return toLong(executeNamedStat("VISIT_STAT", statDate), 1);
	}

	/**
	 * 素有访问人次
	 * @param site
	 * @return
	 */
	public static long getUVTotal(){
		return toLong(executeNamedStat("VISIT_STAT_2"), 1);
	}
	
	private static long toLong(Number v, int defaultValue){
		return (v!=null)?v.longValue():defaultValue;
	}
	
	/**
	 * 写统计数据到数据库
	 * @param ssb
	 * @throws Exception 
	 */
	public static void writeStatData(int uvCount) throws Exception{
		Calendar cal = Calendar.getInstance();
		int statDate = cal.get(Calendar.YEAR)*10000 + cal.get(Calendar.MONTH)*100 + cal.get(Calendar.DATE);
		Session ssn = getSession();
		try{
			beginTransaction();
			Query update_q = ssn.getNamedQuery("UPDATE_SITE_STAT");
			update_q.setInteger(0, uvCount);
			update_q.setInteger(1, statDate);
			if(update_q.executeUpdate()<1){
				StatBean ssb = new StatBean();
				ssb.setUvCount(uvCount);
				ssb.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				ssb.setStatDate(statDate);
				ssn.save(ssb);
			}
			commit();
		}catch(Exception e){
			rollback();
			throw e;
		}
	}
	
}
