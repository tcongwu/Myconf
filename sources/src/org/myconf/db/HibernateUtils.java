package org.myconf.db;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import org.myconf.db.Hibernate;

/**
 * MYCONF对Hibernate的操作接口的封装
 * @author libin
 */
public class HibernateUtils {
	
	private final static Log log = LogFactory.getLog(HibernateUtils.class);

	private final static String HIBERNATE_CFG = "/hibernate.cfg.xml";
	private static Hibernate hibernate;
	
	static{
		try{
			URL xml = HibernateUtils.class.getResource(HIBERNATE_CFG);
			hibernate = Hibernate.init(xml.getPath());
		}catch(Exception e){
			log.fatal("Hibernate Initialize failed.", e);
		}
	}
	
	/**
	 * Initialize the hibernate environment
	 * @param context
	 * @throws MalformedURLException 
	 */
	public synchronized final static void init(){
		//Nothing to do
	}

	/**
	 * 释放所有Hibernate占用的资源 
	 * @see org.myconf.servlet.ActionServlet#destroy()
	 */
	public synchronized final static void destroy(){
		if(hibernate != null)
			hibernate.destroy();
	}

	public final static Session getSession() {
		if(hibernate != null)
			return hibernate.getSession();
		return null;
	}

	public final static void beginTransaction() {
		if(hibernate != null)
			hibernate.beginTransaction();
	}

	public final static void closeSession() {
		if(hibernate != null)
			hibernate.closeSession();
	}

	public final static void commit() {
		if(hibernate != null)
			hibernate.commit();
	}

	public final static void rollback() {
		if(hibernate != null)
			hibernate.rollback();
	}
    
}
