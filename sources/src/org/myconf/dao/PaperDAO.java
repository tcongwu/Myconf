package org.myconf.dao;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import org.myconf.Globals;
import org.myconf.Page;
import org.myconf.beans.AuthorBean;
import org.myconf.beans.PaperBean;
import org.myconf.beans.ReviewBean;
import org.myconf.beans.StatusBean;
import org.myconf.beans.SubjectBean;
import org.myconf.beans.UserBean;
import org.myconf.formbean.PaperForm;
import org.myconf.util.RequestUtils;
import org.myconf.util.StringUtils;

/**
 * 稿件数据访问接口
 * @author libin
 */
public class PaperDAO extends DAO {

	/**
	 * 根据稿件ID来获取对应的稿件信息
	 * @param id
	 * @return
	 */
	public static PaperBean getPaper(int id){
		if(id < 0)
			return null;
		return (PaperBean)getBean(PaperBean.class, id);
	}
	
	/**
	 * 获得某用户所投稿件
	 * 
	 * @param uid
	 * @return
	 */
	public static List getPapersByUser(int uid){
		return findNamedAll("LIST_USER_PAPER", uid);
	}

	/**
	 * 统计各种状态稿件的数量
	 * 
	 * @return
	 */
	public static int[] statPaper(){
		Session ssn = getSession();
		String sql = "SELECT state,COUNT(*) FROM Myconf_PaperInfo GROUP BY state";
		SQLQuery query = ssn.createSQLQuery(sql);
		List stats=query.list();
		int[] results=new int[4];
		if(stats!=null && stats.size()>0){
			Object[] stat=null;
			for(int i=0;i<stats.size();i++){
				stat=(Object[])stats.get(i);
				results[((Number)stat[0]).intValue()]=((Number)stat[1]).intValue();
			}
		}
		results[0]=results[PaperBean.PAPER_STATE_NORMAL]+results[PaperBean.PAPER_STATE_ASSIGNED];
		
		return results;
	}

	/**
	 * 根据录用结果统计各种类型稿件的数量
	 * 
	 * @return
	 */
	public static Map statPaperByResult(){
		Session ssn = getSession();
		String sql = "SELECT astatus,COUNT(*) FROM Myconf_PaperInfo GROUP BY astatus";
		SQLQuery query = ssn.createSQLQuery(sql);
		List stats=query.list();
		HashMap results=new HashMap();
		if(stats!=null && stats.size()>0){
			Object[] stat=null;
			for(int i=0;i<stats.size();i++){
				stat=(Object[])stats.get(i);
				results.put(stat[0], stat[1]);
			}
		}
		
		return results;
	}
	
	/**
	 * 统计稿件
	 * @param type 统计类型
	 * @return
	 */
	public static Map statistics(int type){
		String other=Globals.getMessage("common", "common.text.other");
		String undispose=Globals.getMessage("common", "common.text.undispose");
		
		Session ssn = getSession();
		String sql = null;
		if(type==PaperBean.STATISTICS_BY_COUNTRY){
			sql="SELECT u.country,p.astatus,count(*) FROM Myconf_PaperInfo p, Myconf_UserInfo u WHERE p.userid=u.id group by u.country,p.astatus order by u.country,p.astatus";
		}else if(type==PaperBean.STATISTICS_BY_STATE){
			sql="SELECT u.state,p.astatus,count(*) FROM Myconf_PaperInfo p, Myconf_UserInfo u WHERE p.userid=u.id group by u.state,p.astatus order by u.state,p.astatus";
		}else{
			sql="SELECT s.subject,p.astatus,count(*) FROM Myconf_PaperInfo p, Myconf_PaperSubject s WHERE p.asubject=s.id group by s.subject,p.astatus order by s.subject,p.astatus";
		}
		SQLQuery query = ssn.createSQLQuery(sql);
		List stats=query.list();
		
		//保存所有统计数据（第一层）
		Map all=new HashMap();
		Integer allSum=null;
		//保存录用结果统计数据（第二层）
		Map vmap=null;
		Integer vSum=null;
		
		//遍历统计数据，并把它们保存到map中
		if(stats!=null && stats.size()>0){
			Object[] stat=null;
			String temp=null;
			for(int i=0;i<stats.size();i++){
				stat=(Object[])stats.get(i);
				//替换第一层缺失的键值数据
				if(StringUtils.isEmpty((String)stat[0])){
					stat[0]=other;
				}
				//替换第二层（录用结果）的键值数据
				temp=StatusDAO.getStatusInMap(((Number)stat[1]).intValue());
				if(StringUtils.isEmpty(temp)){
					stat[1]=undispose;
				}else{
					stat[1]=temp;
				}
				
				//是否存在第一层统计数据
				vmap=(Map)all.get(stat[0]);
				if(vmap==null){
					vmap=new HashMap();
					all.put(stat[0], vmap);
				}
				//是否存在所有稿件（第一层）的计数统计
				allSum=(Integer)all.get(PaperBean.STATISTICS_SUM);
				if(allSum==null){
					allSum=new Integer(0);
				}
				//是否存在指定方面稿件（第二层）的计数统计
				vSum=(Integer)vmap.get(PaperBean.STATISTICS_SUM);
				if(vSum==null){
					vSum=new Integer(0);
				}
				//存入数据，计数数据
				vmap.put(stat[1], stat[2]);
				allSum=new Integer(allSum.intValue()+((Number)stat[2]).intValue());
				vSum=new Integer(vSum.intValue()+((Number)stat[2]).intValue());
				all.put(PaperBean.STATISTICS_SUM, allSum);
				vmap.put(PaperBean.STATISTICS_SUM, vSum);
			}
		}
		
		return all;
	}
	
	/**
	 * 查询符合条件的稿件(稿件状态，paper*.jsp)
	 * @param request
	 * @param status
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public static Page queryPaper(HttpServletRequest request, int status, int curPage, int pageSize){
		int id=RequestUtils.getParam(request, "pid", 0);
		int subject=RequestUtils.getParam(request, "subject", 0);
		int astat=RequestUtils.getParam(request, "status", 0);
		String keyword=RequestUtils.getParam(request, "keyword", "");
		
		StringBuffer hql = new StringBuffer("FROM PaperBean AS p");
		if(status==-1){
			hql.append(" WHERE p.state<>:status");
		}else{
			hql.append(" WHERE p.state=:status");
		}
		if(id>0){
			hql.append(" AND p.id=:id");
		}
		if(subject>0){
			hql.append(" AND p.subject.id=:subject");
		}
		if(astat>0){
			hql.append(" AND p.status=:astat");
		}
		if(StringUtils.isNotEmpty(keyword)){
			hql.append(" AND (p.title LIKE :keyword OR p.abstr LIKE :keyword OR p.authorNames LIKE :keyword)");
		}
		hql.append(" ORDER BY p.id");
		Session ssn = getSession();
		Query q = ssn.createQuery(hql.toString());
		if(status==-1){
			q.setInteger("status", PaperBean.PAPER_STATE_FORBIDDEN);
		}else{
			q.setInteger("status", status);
		}
		if(id>0){
			q.setInteger("id", id);
		}
		if(subject>0){
			q.setInteger("subject", subject);
		}
		if(astat>0){
			q.setInteger("astat", astat);
		}
		if(StringUtils.isNotEmpty(keyword)){
			q.setString("keyword", '%'+keyword+'%');
		}
		//if(curPage>0 && pageSize>0){
			//q.setFirstResult((curPage-1)*pageSize);
			//q.setMaxResults(pageSize);
		//}
		
		return new Page(q.list(), curPage, pageSize);
	}
	
	/**
	 * 查询符合条件的稿件(稿件状态，papercycle.jsp)
	 * @param status
	 * @return
	 */
	public static List queryPaper(int status){
		
		StringBuffer hql = new StringBuffer("FROM PaperBean AS p WHERE p.state=:status ORDER BY p.id");
		Session ssn = getSession();
		Query q = ssn.createQuery(hql.toString());
		q.setInteger("status", status);
		
		return q.list();
	}
	
	/**
	 * 查询符合条件的稿件(录用状态，result.jsp)
	 * @param request
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public static Page queryPaper(HttpServletRequest request, int curPage, int pageSize){
		int status=RequestUtils.getParam(request, "sec", StatusBean.STATUS_DEFAULT);
		int id=RequestUtils.getParam(request, "pid", 0);
		int subject=RequestUtils.getParam(request, "subject", 0);
		String keyword=RequestUtils.getParam(request, "keyword", "");
		
		StringBuffer hql = new StringBuffer("FROM PaperBean AS p WHERE p.state<>:state AND p.status=:status");
		if(id>0){
			hql.append(" AND p.id=:id");
		}
		if(subject>0){
			hql.append(" AND p.subject.id=:subject");
		}
		if(StringUtils.isNotEmpty(keyword)){
			hql.append(" AND (p.title LIKE :keyword OR p.abstr LIKE :keyword OR p.authorNames LIKE :keyword)");
		}
		hql.append(" ORDER BY p.id");
		Session ssn = getSession();
		Query q = ssn.createQuery(hql.toString());
		q.setInteger("state", PaperBean.PAPER_STATE_FORBIDDEN);
		q.setInteger("status", status);
		if(id>0){
			q.setInteger("id", id);
		}
		if(subject>0){
			q.setInteger("subject", subject);
		}
		if(StringUtils.isNotEmpty(keyword)){
			q.setString("keyword", '%'+keyword+'%');
		}
		//if(curPage>0 && pageSize>0){
			//q.setFirstResult((curPage-1)*pageSize);
			//q.setMaxResults(pageSize);
		//}
		
		return new Page(q.list(), curPage, pageSize);
	}
	
	/**
	 * 查询符合条件的稿件(稿件下载，downloadpack.jsp)
	 * @param status
	 * @param subject
	 * @return
	 */
	public static List queryPaper(StatusBean status, SubjectBean subject){
		
		StringBuffer hql = new StringBuffer("FROM PaperBean AS p WHERE p.state<>:state");
		if(status!=null){
			hql.append(" AND p.status=:status");
		}
		if(subject!=null){
			hql.append(" AND p.subject.id=:subject");
		}
		hql.append(" ORDER BY p.id");
		Session ssn = getSession();
		Query q = ssn.createQuery(hql.toString());
		q.setInteger("state", PaperBean.PAPER_STATE_FORBIDDEN);
		if(status!=null){
			q.setInteger("status", status.getId());
		}
		if(subject!=null){
			q.setInteger("subject", subject.getId());
		}
		
		return q.list();
	}
	
	/**
	 * 检查用户是否拥有对稿件的各种权限
	 * 
	 * @param id 稿件ID
	 * @param uid 用户ID
	 * @return 是否拥有
	 */
	public static boolean checkUserPaper(int id, int uid){
		return (namedUniqueResult("CHECK_USER_PAPER", id, uid)!=null);
	}
	
	/**
	 * 修改稿件信息
	 * @param paper
	 */
	public static void updatePaper(PaperBean paper){
		flush();
	}
	
	/**
	 * 删除稿件，连同作者信息等一起
	 * @param paper
	 */
	public static void deletePaper(PaperBean paper){
		getSession().delete(paper);
		getSession().flush();
	}
	
	/**
	 * 写稿件信息到数据库
	 * 
	 * @param pform 稿件表单数据
	 * @param loginUser 用户信息
	 * @throws IllegalAccessException 
	 * @throws ObjectNotFoundException 
	 */
	public static PaperBean create(PaperForm pform, UserBean loginUser) 
		throws IllegalArgumentException, HibernateException
	{
		if(pform==null || loginUser==null || StringUtils.isEmpty(pform.getPfile().getFileName()))
			throw new IllegalArgumentException();
			
		//创建稿件对象
		UserBean user=pform.getUserInfo();
		PaperBean paper=pform.getPaper(true);
		List authors=pform.getAuthors();
		if(user==null || paper==null || authors==null || authors.size()<1)
			throw new IllegalArgumentException();
			
		Session ssn = getSession();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try{
			beginTransaction();
			
			//先修改用户联系信息
			UserBean ubean = (UserBean)ssn.get(UserBean.class, new Integer(loginUser.getId()));
			if (ubean == null || ubean.getStatus()!=UserBean.STATUS_NORMAL)
				throw new IllegalArgumentException();
			//更新用户数据
			ubean.getName().setTitle(user.getName().getTitle());
			ubean.getName().setFirstName(user.getName().getFirstName());
			ubean.getName().setLastName(user.getName().getLastName());
			ubean.setWorkLocation(user.getWorkLocation());
			ubean.setResearch(user.getResearch());
			ubean.setPhone(user.getPhone());
			ubean.setFax(user.getFax());
			ubean.setAddress(user.getAddress());
			ubean.setPostcode(user.getPostcode());
			ubean.setState(user.getState());
			ubean.setCountry(user.getCountry());
			
			//创建稿件信息
			paper.setSubUser(ubean);
			paper.setState(PaperBean.PAPER_STATE_NORMAL);
			paper.setFilePath(StringUtils.getFileExtend(pform.getPfile().getFileName()));
			paper.setStatus(StatusBean.STATUS_DEFAULT);
			paper.setRegTime(ts);
			paper.setUpdateTime(ts);
			
			ssn.save(paper);
			
			//逐一添加稿件作者信息
			AuthorBean author=null;
			for(int i=0;i<authors.size();i++){
				author = (AuthorBean)authors.get(i);
				author.setPaper(paper);
				author.setRegTime(ts);
				author.setUpdateTime(ts);
			}
			paper.setAuthors(authors);
			
			ssn.update(paper);
			
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		
		return paper;
	}
	
	/**
	 * 修改稿件信息
	 * 
	 * @param pform 稿件表单数据
	 * @param loginUser 用户信息
	 * @throws IllegalAccessException 
	 * @throws ObjectNotFoundException 
	 */
	public static PaperBean modify(PaperForm pform, UserBean loginUser) 
		throws IllegalArgumentException, HibernateException
	{
		if(pform==null || loginUser==null)
			throw new IllegalArgumentException();
			
		//创建稿件对象
		UserBean user=pform.getUserInfo();
		PaperBean paper=pform.getPaper(false);
		List authors=pform.getAuthors();
		if(user==null || paper==null || authors==null || authors.size()<1)
			throw new IllegalArgumentException();
			
		Session ssn = getSession();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try{
			beginTransaction();
			
			//获取稿件信息
			PaperBean pbean = (PaperBean)ssn.get(PaperBean.class, new Integer(paper.getId()));
			if (pbean == null || pbean.getState()==PaperBean.PAPER_STATE_FORBIDDEN)
				throw new IllegalArgumentException();
			
			//获取并修改用户联系信息
			UserBean ubean = pbean.getSubUser();
			if (ubean == null || ubean.getStatus()!=UserBean.STATUS_NORMAL || loginUser.getId()!=ubean.getId())
				throw new IllegalArgumentException();
			
			//更新用户数据
			ubean.getName().setTitle(user.getName().getTitle());
			ubean.getName().setFirstName(user.getName().getFirstName());
			ubean.getName().setLastName(user.getName().getLastName());
			ubean.setWorkLocation(user.getWorkLocation());
			ubean.setResearch(user.getResearch());
			ubean.setPhone(user.getPhone());
			ubean.setFax(user.getFax());
			ubean.setAddress(user.getAddress());
			ubean.setPostcode(user.getPostcode());
			ubean.setState(user.getState());
			ubean.setCountry(user.getCountry());
			ssn.update(ubean);
			
			//修改稿件信息	
			pbean.setTitle(paper.getTitle());
			pbean.setSubject(paper.getSubject());
			pbean.setAbstr(paper.getAbstr());
			pbean.setAuthorNames(paper.getAuthorNames());
			if(pform.getPfile().getFileSize()>0)
				pbean.setFilePath(StringUtils.getFileExtend(pform.getPfile().getFileName()));
			pbean.setUpdateTime(ts);
			
			//逐一添加稿件作者信息
			AuthorBean author=null;
			for(int i=0;i<authors.size();i++){
				author = (AuthorBean)authors.get(i);
				author.setPaper(pbean);
				author.setRegTime(ts);
				author.setUpdateTime(ts);
			}
			//删除原有作者
			List aus=pbean.getAuthors();
			while(aus!=null && aus.size()>0){
				author=(AuthorBean)aus.remove(0);
				ssn.delete(author);
			}
			//添加新修改的作者
			pbean.setAuthors(authors);
			
			ssn.update(pbean);
			
			commit();			
		
			return pbean;
			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
	}
	
	/**
	 * 分发稿件
	 * 
	 * @param pform 稿件表单数据
	 * @param loginUser 用户信息
	 * @throws IllegalAccessException 
	 * @throws ObjectNotFoundException 
	 */
	public static PaperBean assign(PaperForm pform) 
		throws IllegalArgumentException, HibernateException
	{
		if(pform==null)
			throw new IllegalArgumentException();
			
		//获取专家列表
		Hashtable ehash=pform.getExpertHash();
			
		Session ssn = getSession();
		try{
			beginTransaction();
			
			//获取稿件信息
			PaperBean pbean = (PaperBean)ssn.get(PaperBean.class, new Integer(pform.getId()));
			if (pbean == null || pbean.getState()==PaperBean.PAPER_STATE_FORBIDDEN)
				throw new IllegalArgumentException();
			
			//获取稿件评审信息列表
			List reviews=pbean.getReviews();
			ReviewBean review=null;
			//把已有的评审信息列表与新的评审专家进行对比，删除原有专家列表中在最新列表中已经不在的专家
			if(reviews!=null && reviews.size()>0){
				for(int i=0;i<reviews.size();i++){
					review=(ReviewBean)reviews.get(i);
					if(ehash==null || ehash.get(new Integer(review.getExpert().getId()))==null){
						review=(ReviewBean)reviews.remove(i);
						ssn.delete(review);
					}else{
						ehash.remove(new Integer(review.getExpert().getId()));
					}
				}
			}
			
			//获得新的专家的列表
			Enumeration newexp=null;
			if(ehash!=null && ehash.size()>0){
				newexp=ehash.keys();
			}
			Integer eid=null;
			UserBean expert=null;
			while(newexp!=null && newexp.hasMoreElements()){
				eid=(Integer)newexp.nextElement();
				expert=(UserBean)ssn.get(UserBean.class, eid);
				if(expert!=null){
					review=new ReviewBean();
					review.setExpert(expert);
					review.setExpertName(expert.getName().toString());
					review.setPaper(pbean);
					review.setStatus(ReviewBean.REVIEW_STATUS_BEGIN);
					review.setRecoStatus(StatusBean.STATUS_DEFAULT);
					
					reviews.add(review);
					ssn.save(review);
				}
			}
			pbean.setReviews(reviews);
			
			//设置稿件状态为已分发
			if(pbean.getState()!=PaperBean.PAPER_STATE_ASSIGNED){
				pbean.setState(PaperBean.PAPER_STATE_ASSIGNED);
			}
			
			ssn.update(pbean);
			
			commit();			
		
			return pbean;
			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
	}
	
	/**
	 * 判断是否完成了所有稿件的录用
	 * @return
	 */
	public static boolean isFinish(){
		return executeNamedStat("CHECK_FINISH").intValue()==0;
	}
}
