package org.myconf.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;

import org.myconf.Globals;
import org.myconf.db.HibernateUtils;

/**
 * A servlet filter that opens and closes a Hibernate Session for each request.
 * <p>
 * This filter guarantees a sane state, committing any pending database
 * transaction once all other filters (and servlets) have executed. It also
 * guarantees that the Hibernate <tt>Session</tt> of the current thread will
 * be closed before the response is send to the client.
 * <p>
 * Use this filter for the <b>session-per-request</b> pattern and if you are
 * using <i>Detached Objects</i>.
 *
 * @see HibernateUtils
 * @author Christian Bauer <christian@hibernate.org>
 */
public class HibernateFilter implements Filter {
	
	private ServletContext context = null;
	private boolean commit_on_close = false;

	public void init(FilterConfig filterConfig) throws ServletException {	
		context = filterConfig.getServletContext();
		if(Globals.WEBAPP_PATH==null)
			Globals.WEBAPP_PATH = context.getRealPath("");
		commit_on_close = "true".equalsIgnoreCase(filterConfig
				.getInitParameter("commit_on_close")); 
	}

	/**
	 * 请求完毕后释放数据库资源
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			// We don't start the database transaction here, but when first needed
			chain.doFilter(request, response);
			//User must commit the transaction manual
			if(commit_on_close){
				HibernateUtils.commit();
			}
		} catch(HibernateException e) {
			if(commit_on_close){
				HibernateUtils.rollback();
			}
		} finally {
			// No matter what happens, close the Session.
			try {
				HibernateUtils.closeSession();
			} catch (HibernateException ex) {
				LogFactory.getLog(HibernateFilter.class).error("Exception when close hibernate session", ex);
			}
		}
	}

	public void destroy() {
		// 释放Hibernate
		HibernateUtils.destroy();
	}

}
