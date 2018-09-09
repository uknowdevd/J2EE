package com.sparc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
	private int requestCount = 0;

	Logger logger = LogManager.getLogger(LoggingFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("Logging Filter - init method");
		requestCount = 0;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		requestCount ++;
		logger.debug( Thread.currentThread().getName() + "Capturing request info - parameters" + request.getParameter("first_name") + " "  + request.getParameter("last_name"))  ;
		logger.debug( "Number of requests hit so far" + requestCount)  ;
		 chain.doFilter(request,response);
	}

	public void destroy() {
		logger.debug("Logging Filter - destroy method");
		requestCount = 0;

	}

}
