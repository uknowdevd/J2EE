package com.sparc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloServlet extends HttpServlet{

	Logger logger = LogManager.getLogger(HelloServlet.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doPost(HttpServletRequest reqest, HttpServletResponse response) 
			throws ServletException, IOException {
		logger.debug("Inside doPost, printing params " + reqest.getParameterMap());
		response.getWriter().println("Post Method - Hello World! " + reqest.getParameter("first_name") + " " + reqest.getParameter("last_name"));
		
	}
	
	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) 
			throws ServletException, IOException {
		logger.debug("Inside doGet, printing params " + reqest.getParameterMap());

		response.getWriter().println("Get Method - Hello World!"  + reqest.getParameter("first_name") + " " + reqest.getParameter("last_name"));
	}
	@Override
	public void init() throws ServletException {
		logger.debug("Servlet " + this.getServletName() + " has started");
	}
	@Override
	public void destroy() {
		logger.debug("Servlet " + this.getServletName() + " has stopped");
	}
}
