package com.sparc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sparc.dao.MySqlDao;
import com.sparc.entity.PersonTO;

public class HelloServlet extends HttpServlet{

	Logger logger = LogManager.getLogger(HelloServlet.class);
	MySqlDao dao = new MySqlDao();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doPost(HttpServletRequest reqest, HttpServletResponse response) 
			throws ServletException, IOException {
		logger.debug("Inside doPost, printing params " + reqest.getParameterMap());
		List<PersonTO> personList = new ArrayList<PersonTO>();
			try {
			dao.writeDataBase(reqest.getParameter("first_name"), reqest.getParameter("last_name"));;
			personList=	dao.readDataBase();
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
			response.getWriter().println("Printing the list of users added " + personList);
			
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
