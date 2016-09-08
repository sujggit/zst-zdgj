package com.zzst.meeting.department;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class JsonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	DepartmentManager navigateManager = new DepartmentManager();
	request.setAttribute("list", navigateManager.getChildrenById(request.getParameter("id")));
	RequestDispatcher dispatcher = request.getRequestDispatcher("/meeting/department/console-json.jsp");
	dispatcher.forward(request, response);
	}

}

