package org.myconf.db;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate的操作接口
 * @author libin
 */
public class Hibernate {

	private final static Log log = LogFactory.getLog(Hibernate.class);

	private String hibernate_cfg;
	private SessionFactory sessionFactory;
	
	/** 为每次请求线程保持一个独立的数据库操作会话，避免数据库操作混乱 */
	private ThreadLocal sessions;
	private ThreadLocal transactions;

	/**
	 * Initialize the hibernate environment
	 * @param hibernate_cfg
	 * @throws MalformedURLException 
	 */
	public final static Hibernate init(String hibernate_cfg){
		return new Hibernate(hibernate_cfg);
	}

	/**
	 * 根据输入的配置文件初始化Hibernate
	 * @param cfg_path
	 */
	private Hibernate(String cfg_path){
		sessions = new ThreadLocal();
		transactions = new ThreadLocal();
		Configuration cfg = new Configuration().configure(new File(cfg_path));			
		sessionFactory = cfg.buildSessionFactory();
		this.hibernate_cfg = cfg_path;
	}

	/**
	 * 返回对应的Hibernate配置文件的路径
	 * @return
	 */
	public String getHibernateConfig() {
		return hibernate_cfg;
	}
    
	/**
	 * Get a instance of hibernate's session
	 * @return
	 * @throws HibernateException
	 */
	public Session getSession(){
		if(sessions == null)
			return null;

		Session ssn = (Session)sessions.get();
		if (ssn == null) {
			ssn = sessionFactory.openSession();
			sessions.set(ssn);
		}
		
		return ssn;
	}
		
	/**
	 * Closes the Session local to the thread.
	 */
	public void closeSession(){
		if(sessions == null)
			return;
		// Would be written as a no-op in an EJB container with CMT
		Session ssn = (Session)sessions.get();
		if(ssn == null)
			return;
		else if(ssn.isOpen())
			ssn.close();		
		
		sessions.set(null);
	}

	/**
	 * Start a new database transaction.
	 */
	public void beginTransaction(){
		if(transactions == null)
			return;
		// Would be written as a no-op in an EJB container with CMT
		Transaction tx = (Transaction)transactions.get();
		if (tx == null || tx.wasCommitted() || tx.wasRolledBack()) {
			Session ssn = (Session)sessions.get();
			if(ssn == null){
				ssn = getSession();
				tx = ssn.beginTransaction();
				transactions.set(tx);
			}
			else if(ssn != null){
				tx = ssn.beginTransaction();
				transactions.set(tx);				
			}
		}
		else{
			if(tx!=null && log.isWarnEnabled())
				log.warn("Trying to begin a exist transaction, nothing to do.", new Exception());
		}
	}

	/**
	 * Commit the database transaction.
	 */
	public void commit(){
		if(transactions == null)
			return;
		// Would be written as a no-op in an EJB container with CMT
		Transaction tx = (Transaction)transactions.get();
		if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
			tx.commit();
		}
		else{
			if(tx!=null && log.isWarnEnabled())
				log.warn("Trying to commit the uncommitable transaction, nothing to do.");
		}
		if(tx!=null)
			transactions.set(null);
	}

	/**
	 * Rollback the database transaction.
	 */
	public void rollback(){
		if(transactions == null)
			return;
		Transaction tx = (Transaction)transactions.get();
		transactions.set(null);
		if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
			tx.rollback();
		}
		else{
			if(tx!=null && log.isWarnEnabled())
				log.warn("Trying to rollback the unrollbackable transaction, nothing to do.");
		}
	}

	/**
	 * 释放所有Hibernate占用的资源 
	 * @see org.myconf.servlet.ActionServletExtend#destroy()
	 */
	public void destroy(){
		if(sessionFactory!=null){
			sessionFactory.close();
			sessionFactory = null;
		}
		sessions = null;
		transactions = null;
		if(log.isWarnEnabled())
			log.warn("Hibernate("+hibernate_cfg+") was destroy successfully, all of sessions were closed.");
	}

}
