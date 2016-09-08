package com.zzst.action.meeting.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;


public class EncodingFilter extends HttpServlet implements Filter{
	private static Logger logger = CbfLogger.getLogger(EncodingFilter.class.getName());
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FilterConfig filterConfig;
	 protected String encoding = null;
	 public void init(FilterConfig filterConfig) {
	        this.filterConfig = filterConfig;
	        this.encoding = filterConfig.getInitParameter("encoding");
	    }

	    public void setFilterConfig(FilterConfig filterConfig) {
	        this.filterConfig = filterConfig;
	    }

	    public FilterConfig getFilterConfig() {
	        return filterConfig;
	    }

	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
	    {
	    	try {
	        if(request.getCharacterEncoding()==null){
	        	String encoding = this.encoding;
	        	if(encoding!=null){
					request.setCharacterEncoding(encoding);
	        	}
	        }
				filterChain.doFilter(request, response);
	    	} catch (UnsupportedEncodingException e) {
	    		logger.error(e.getMessage());
	    	} catch (IOException e) {
	    		logger.error(e.getMessage());
			} catch (ServletException e) {
				logger.error(e.getMessage());
			}
	    }

	    public void destroy()
	    {
	    }

}
