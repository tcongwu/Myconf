package org.myconf.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.myconf.beans.SubjectBean;

/**
 * 稿件所属主题数据访问接口
 * @author libin
 */
public class SubjectDAO extends DAO {

	/**
	 * 增加主题
	 * @param sub
	 */
	public static boolean save(SubjectBean sub){
		Session ssn = getSession();
		try{
			beginTransaction();
			ssn.save(sub);
			commit();			
		}catch(HibernateException e){
			rollback();
			throw e;
		}
		return true;
	}
	
	/**
	 * 删除主题
	 * @param id
	 * @return
	 */
	public static boolean delete(int id){
		return commitNamedUpdate("DELETE_SUBJECT", id)>0;
	}
	
	/**
	 * 列出所有主题
	 * @return
	 */
	public static List list(){
		return findNamedAll("LIST_SUBJECT");
	}
	
	/**
	 * 获得所有主题的名称列表
	 * @return
	 */
	public static List listSubject(){
		List ls=findNamedAll("LIST_SUBJECT");
		if(ls!=null && ls.size()>0){
			List re=new ArrayList();
			SubjectBean sub=null;
			for(int i=0;i<ls.size();i++){
				sub=(SubjectBean)ls.get(i);
				re.add(sub.getSubject());
			}
			return re;
		}
		return null;
	}

	/**
	 * 根据主题ID来获取对应的稿件所属主题信息
	 * @param id
	 * @return
	 */
	public static SubjectBean getSubject(int id){
		if(id < 0)
			return null;
		return (SubjectBean)getBean(SubjectBean.class, id);
	}
	
	/**
	 * 修改稿件所属主题信息
	 * @param sub
	 */
	public static void update(SubjectBean sub){
		flush();
	}
	
	/**
	 * 判断是否可以删除主题
	 * @param id 主题的ID
	 * @return
	 */
	public static boolean isDelete(int id){
		return executeNamedStat("CHECK_DELETE_OF_SUBJECT", id).intValue()==0;
	}
}
