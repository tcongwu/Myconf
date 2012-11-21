package org.myconf.beans.base;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 网站的访问统计信息
 * @author lee bin
 */
public class SiteStatInfo implements Serializable {

	private long uvToday;
	private long uvThisWeek;
	private long uvThisMonth;
	private long uvThisYear;
	private long uvTotal;
	private int userCount;
	private int authorCount;
	private int paperCount;
	private int outPaperCount;
	private int inPaperCount;
	private int quitPaperCount;
	private Timestamp createTime;
	
	public long getUvThisMonth() {
		return uvThisMonth;
	}
	public void setUvThisMonth(long uvThisMonth) {
		this.uvThisMonth = uvThisMonth;
	}
	public long getUvThisWeek() {
		return uvThisWeek;
	}
	public void setUvThisWeek(long uvThisWeek) {
		this.uvThisWeek = uvThisWeek;
	}
	public long getUvThisYear() {
		return uvThisYear;
	}
	public void setUvThisYear(long uvThisYear) {
		this.uvThisYear = uvThisYear;
	}
	public long getUvToday() {
		return uvToday;
	}
	public void setUvToday(long uvToday) {
		this.uvToday = uvToday;
	}
	public long getUvTotal() {
		return uvTotal;
	}
	public void setUvTotal(long uvTotal) {
		this.uvTotal = uvTotal;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int it) {
		this.userCount = it;
	}
	public int getAuthorCount() {
		return authorCount;
	}
	public void setAuthorCount(int it) {
		this.authorCount = it;
	}
	public int getPaperCount() {
		return paperCount;
	}
	public void setPaperCount(int it) {
		this.paperCount = it;
	}
	public int getOutPaperCount() {
		return outPaperCount;
	}
	public void setOutPaperCount(int it) {
		this.outPaperCount = it;
	}
	public int getInPaperCount() {
		return inPaperCount;
	}
	public void setInPaperCount(int it) {
		this.inPaperCount = it;
	}
	public int getQuitPaperCount() {
		return quitPaperCount;
	}
	public void setQuitPaperCount(int it) {
		this.quitPaperCount = it;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp ts) {
		this.createTime = ts;
	}
	
}
