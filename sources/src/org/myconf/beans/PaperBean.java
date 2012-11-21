package org.myconf.beans;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.myconf.beans.base._BeanBase;

/**
 * 稿件基本信息类
 * @author libin
 */
public class PaperBean extends _BeanBase {

	public final static int PAPER_STATE_NORMAL  = 1;		//正常
	public final static int PAPER_STATE_FORBIDDEN = 2;	//禁止
	public final static int PAPER_STATE_ASSIGNED = 3;	//已分发

	public final static int STATISTICS_BY_SUBJECT  = 1;		//按主题统计
	public final static int STATISTICS_BY_COUNTRY = 2;	//按国家统计
	public final static int STATISTICS_BY_STATE = 3;	//按省份统计
	public final static String STATISTICS_SUM="-all-";	//保存总数的键值
	
	private UserBean subUser;		//提交稿件的用户
	
	private String title;	//标题
	private int state;		//稿件状态
	private String abstr;	//摘要
	private String filePath;	//稿件文件存放路径
	private String authorNames;	//稿件作者姓名列表
	
	private SubjectBean subject;	//所属主题－
	private int status;		//录用状态－
	
	private float score;	//评审得分
	private Timestamp regTime;	//创建时间
	private Timestamp updateTime;	//最近更新时间
	
	protected List authors;	//稿件作者
	protected List reviews;	//稿件评审信息
	protected List bids;	//竟评稿件信息
	protected List words;	//稿件留言信息
	
	public PaperBean(){}

	public UserBean getSubUser() {
		if(subUser==null)
			subUser = new UserBean();
		return subUser;
	}

	public void setSubUser(UserBean user) {
		this.subUser = user;
	}
	
	public String getExpertNameList(){
		List ls=this.getReviews();
		ReviewBean review=null;
		if(ls!=null && ls.size()>0){
			StringBuffer names=new StringBuffer();
			for(int i=0;i<ls.size();i++){
				review=(ReviewBean)ls.get(i);
				if(i>0)
					names.append(", ");
				names.append(review.getExpertName());
			}
			return names.toString();
		}else{
			return "";
		}
	}
	
	public String getQuitExpertNameList(){
		List ls=this.getReviews();
		ReviewBean review=null;
		if(ls!=null && ls.size()>0){
			StringBuffer names=new StringBuffer();
			for(int i=0;i<ls.size();i++){
				review=(ReviewBean)ls.get(i);
				if(review.getStatus()==ReviewBean.REVIEW_STATUS_QUIT){
					if(names.length()>0)
						names.append(", ");
					names.append(review.getExpertName());
				}
			}
			return names.toString();
		}else{
			return "";
		}
	}
	
	public HashMap getExpertMap(){
		List ls=this.getReviews();
		ReviewBean review=null;
		HashMap ex=null;
		if(ls!=null && ls.size()>0){
			ex=new HashMap();
			for(int i=0;i<ls.size();i++){
				review=(ReviewBean)ls.get(i);
				ex.put(new Integer(review.getExpert().getId()), "true");
			}
		}
		
		return ex;
	}
	
	public String getBidNameList(){
		List ls=this.getBids();
		BidBean bid=null;
		if(ls!=null && ls.size()>0){
			StringBuffer names=new StringBuffer();
			for(int i=0;i<ls.size();i++){
				bid=(BidBean)ls.get(i);
				if(i>0)
					names.append(", ");
				names.append(bid.getExpertName());
			}
			return names.toString();
		}else{
			return "";
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String str) {
		this.title = str;
	}

	public int getState() {
		return state;
	}

	public void setState(int it) {
		this.state = it;
	}

	public String getAbstr() {
		return abstr;
	}

	public void setAbstr(String str) {
		this.abstr = str;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String str) {
		this.filePath = str;
	}

	public String getAuthorNames() {
		return this.authorNames;
	}

	public void setAuthorNames(String str) {
		this.authorNames = str;
	}

	public SubjectBean getSubject() {
		if(subUser==null)
			subject = new SubjectBean();
		return subject;
	}

	public void setSubject(SubjectBean sb) {
		this.subject = sb;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int it) {
		this.status = it;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float flt) {
		this.score = flt;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp ts) {
		this.updateTime = ts;
	}
	
	public List getAuthors() {
		return authors;
	}

	public void setAuthors(List aus) {
		this.authors = aus;
	}
	
	public List getReviews() {
		return reviews;
	}

	public void setReviews(List rws) {
		this.reviews = rws;
	}
	
	public List getBids() {
		return bids;
	}

	public void setBids(List bds) {
		this.bids = bds;
	}
	
	public List getWords() {
		return words;
	}

	public void setWords(List wds) {
		this.words = wds;
	}
}
