package org.myconf.util;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * ������صĹ�����
 * @author Winter Lau
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils{

	/**
	 * �ϲ����ں�ʱ��
	 * @param date
	 * @param time
	 * @return
	 */
	public static Calendar mergeDateTime(Date date, Time time){
		Calendar cal = Calendar.getInstance();
		if(date!=null)
			cal.setTime(date);
		if(time!=null){
			Calendar temp = Calendar.getInstance();
			temp.setTime(time);
			cal.set(Calendar.HOUR_OF_DAY, temp.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE, temp.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, temp.get(Calendar.SECOND));
			cal.set(Calendar.MILLISECOND, temp.get(Calendar.MILLISECOND));
		}
		return cal;
	}
	
	/**
	 * ��������������������
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int diff_in_date(Date d1, Date d2){
		return (int)(d1.getTime() - d2.getTime())/86400000;
	}

	/**
	 * ��ȡĳ�쿪ʼ����һ��
	 * @param year
	 * @param month
	 * @param date
	 * @return
	 */
	public static Calendar getDateBegin(int year, int month, int date){
		Calendar begin_time = Calendar.getInstance();
		begin_time.set(Calendar.YEAR, year);
		begin_time.set(Calendar.MONTH, month-1);
		begin_time.set(Calendar.DATE, date);
		begin_time.set(Calendar.HOUR_OF_DAY, 0);
		begin_time.set(Calendar.MINUTE, 0);
		begin_time.set(Calendar.SECOND, 0);
		begin_time.set(Calendar.MILLISECOND, 0);
		return begin_time;
	}
	
	/**
	 * ���������ʱ���ֶ�
	 * @param cal
	 */
	public static void resetTime(Calendar cal){
		cal.set(Calendar.HOUR_OF_DAY,0);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
	}
	
}
