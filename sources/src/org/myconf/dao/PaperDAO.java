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
 * ������ݷ��ʽӿ�
 * @author libin
 */
public class PaperDAO extends DAO {

	/**
	 * ���ݸ��ID����ȡ��Ӧ�ĸ����Ϣ
	 * @param id
	 * @return
	 */
	public static PaperBean getPaper(int id){
		if(id < 0)
			return null;
		return (PaperBean)getBean(PaperBean.class, id);
	}
	
	/**
	 * ���ĳ�û���Ͷ���
	 * 
	 * @param uid
	 * @return
	 */
	public static List getPapersByUser(int uid){
		return findNamedAll("LIST_USER_PAPER", uid);
	}

	/**
	 * ͳ�Ƹ���״̬���������
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
	 * ����¼�ý��ͳ�Ƹ������͸��������
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
	 * ͳ�Ƹ��
	 * @param type ͳ������
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
		
		//��������ͳ�����ݣ���һ�㣩
		Map all=new HashMap();
		Integer allSum=null;
		//����¼�ý��ͳ�����ݣ��ڶ��㣩
		Map vmap=null;
		Integer vSum=null;
		
		//����ͳ�����ݣ��������Ǳ��浽map��
		if(stats!=null && stats.size()>0){
			Object[] stat=null;
			String temp=null;
			for(int i=0;i<stats.size();i++){
				stat=(Object[])stats.get(i);
				//�滻��һ��ȱʧ�ļ�ֵ����
				if(StringUtils.isEmpty((String)stat[0])){
					stat[0]=other;
				}
				//�滻�ڶ��㣨¼�ý�����ļ�ֵ����
				temp=StatusDAO.getStatusInMap(((Number)stat[1]).intValue());
				if(StringUtils.isEmpty(temp)){
					stat[1]=undispose;
				}else{
					stat[1]=temp;
				}
				
				//�Ƿ���ڵ�һ��ͳ������
				vmap=(Map)all.get(stat[0]);
				if(vmap==null){
					vmap=new HashMap();
					all.put(stat[0], vmap);
				}
				//�Ƿ�������и������һ�㣩�ļ���ͳ��
				allSum=(Integer)all.get(PaperBean.STATISTICS_SUM);
				if(allSum==null){
					allSum=new Integer(0);
				}
				//�Ƿ����ָ�����������ڶ��㣩�ļ���ͳ��
				vSum=(Integer)vmap.get(PaperBean.STATISTICS_SUM);
				if(vSum==null){
					vSum=new Integer(0);
				}
				//�������ݣ���������
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
	 * ��ѯ���������ĸ��(���״̬��paper*.jsp)
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
	 * ��ѯ���������ĸ��(���״̬��papercycle.jsp)
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
	 * ��ѯ���������ĸ��(¼��״̬��result.jsp)
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
	 * ��ѯ���������ĸ��(������أ�downloadpack.jsp)
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
	 * ����û��Ƿ�ӵ�жԸ���ĸ���Ȩ��
	 * 
	 * @param id ���ID
	 * @param uid �û�ID
	 * @return �Ƿ�ӵ��
	 */
	public static boolean checkUserPaper(int id, int uid){
		return (namedUniqueResult("CHECK_USER_PAPER", id, uid)!=null);
	}
	
	/**
	 * �޸ĸ����Ϣ
	 * @param paper
	 */
	public static void updatePaper(PaperBean paper){
		flush();
	}
	
	/**
	 * ɾ���������ͬ������Ϣ��һ��
	 * @param paper
	 */
	public static void deletePaper(PaperBean paper){
		getSession().delete(paper);
		getSession().flush();
	}
	
	/**
	 * д�����Ϣ�����ݿ�
	 * 
	 * @param pform ���������
	 * @param loginUser �û���Ϣ
	 * @throws IllegalAccessException 
	 * @throws ObjectNotFoundException 
	 */
	public static PaperBean create(PaperForm pform, UserBean loginUser) 
		throws IllegalArgumentException, HibernateException
	{
		if(pform==null || loginUser==null || StringUtils.isEmpty(pform.getPfile().getFileName()))
			throw new IllegalArgumentException();
			
		//�����������
		UserBean user=pform.getUserInfo();
		PaperBean paper=pform.getPaper(true);
		List authors=pform.getAuthors();
		if(user==null || paper==null || authors==null || authors.size()<1)
			throw new IllegalArgumentException();
			
		Session ssn = getSession();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try{
			beginTransaction();
			
			//���޸��û���ϵ��Ϣ
			UserBean ubean = (UserBean)ssn.get(UserBean.class, new Integer(loginUser.getId()));
			if (ubean == null || ubean.getStatus()!=UserBean.STATUS_NORMAL)
				throw new IllegalArgumentException();
			//�����û�����
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
			
			//���������Ϣ
			paper.setSubUser(ubean);
			paper.setState(PaperBean.PAPER_STATE_NORMAL);
			paper.setFilePath(StringUtils.getFileExtend(pform.getPfile().getFileName()));
			paper.setStatus(StatusBean.STATUS_DEFAULT);
			paper.setRegTime(ts);
			paper.setUpdateTime(ts);
			
			ssn.save(paper);
			
			//��һ��Ӹ��������Ϣ
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
	 * �޸ĸ����Ϣ
	 * 
	 * @param pform ���������
	 * @param loginUser �û���Ϣ
	 * @throws IllegalAccessException 
	 * @throws ObjectNotFoundException 
	 */
	public static PaperBean modify(PaperForm pform, UserBean loginUser) 
		throws IllegalArgumentException, HibernateException
	{
		if(pform==null || loginUser==null)
			throw new IllegalArgumentException();
			
		//�����������
		UserBean user=pform.getUserInfo();
		PaperBean paper=pform.getPaper(false);
		List authors=pform.getAuthors();
		if(user==null || paper==null || authors==null || authors.size()<1)
			throw new IllegalArgumentException();
			
		Session ssn = getSession();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try{
			beginTransaction();
			
			//��ȡ�����Ϣ
			PaperBean pbean = (PaperBean)ssn.get(PaperBean.class, new Integer(paper.getId()));
			if (pbean == null || pbean.getState()==PaperBean.PAPER_STATE_FORBIDDEN)
				throw new IllegalArgumentException();
			
			//��ȡ���޸��û���ϵ��Ϣ
			UserBean ubean = pbean.getSubUser();
			if (ubean == null || ubean.getStatus()!=UserBean.STATUS_NORMAL || loginUser.getId()!=ubean.getId())
				throw new IllegalArgumentException();
			
			//�����û�����
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
			
			//�޸ĸ����Ϣ	
			pbean.setTitle(paper.getTitle());
			pbean.setSubject(paper.getSubject());
			pbean.setAbstr(paper.getAbstr());
			pbean.setAuthorNames(paper.getAuthorNames());
			if(pform.getPfile().getFileSize()>0)
				pbean.setFilePath(StringUtils.getFileExtend(pform.getPfile().getFileName()));
			pbean.setUpdateTime(ts);
			
			//��һ��Ӹ��������Ϣ
			AuthorBean author=null;
			for(int i=0;i<authors.size();i++){
				author = (AuthorBean)authors.get(i);
				author.setPaper(pbean);
				author.setRegTime(ts);
				author.setUpdateTime(ts);
			}
			//ɾ��ԭ������
			List aus=pbean.getAuthors();
			while(aus!=null && aus.size()>0){
				author=(AuthorBean)aus.remove(0);
				ssn.delete(author);
			}
			//������޸ĵ�����
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
	 * �ַ����
	 * 
	 * @param pform ���������
	 * @param loginUser �û���Ϣ
	 * @throws IllegalAccessException 
	 * @throws ObjectNotFoundException 
	 */
	public static PaperBean assign(PaperForm pform) 
		throws IllegalArgumentException, HibernateException
	{
		if(pform==null)
			throw new IllegalArgumentException();
			
		//��ȡר���б�
		Hashtable ehash=pform.getExpertHash();
			
		Session ssn = getSession();
		try{
			beginTransaction();
			
			//��ȡ�����Ϣ
			PaperBean pbean = (PaperBean)ssn.get(PaperBean.class, new Integer(pform.getId()));
			if (pbean == null || pbean.getState()==PaperBean.PAPER_STATE_FORBIDDEN)
				throw new IllegalArgumentException();
			
			//��ȡ���������Ϣ�б�
			List reviews=pbean.getReviews();
			ReviewBean review=null;
			//�����е�������Ϣ�б����µ�����ר�ҽ��жԱȣ�ɾ��ԭ��ר���б����������б����Ѿ����ڵ�ר��
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
			
			//����µ�ר�ҵ��б�
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
			
			//���ø��״̬Ϊ�ѷַ�
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
	 * �ж��Ƿ���������и����¼��
	 * @return
	 */
	public static boolean isFinish(){
		return executeNamedStat("CHECK_FINISH").intValue()==0;
	}
}
