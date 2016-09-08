package com.zzst.meeting.department;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzst.model.meeting.department.DepartmentVO;


public class EditServlet extends HttpServlet {
	
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
		String idstr = request.getParameter("id");
		String parentId = request.getParameter("parentId");
		String leaf = request.getParameter("leaf");
//		String number = request.getParameter("number");
		DepartmentVO obj = null;
		if(null != idstr){
			DepartmentManager navigateManager = new DepartmentManager();
			obj = navigateManager.get(idstr);
		}else{
			obj = new DepartmentVO();
			obj.setParentId(parentId);
			obj.setLeaf(new Integer(leaf));
		//	obj.setNumber(new Integer(number));
		}
		request.setAttribute("obj", obj);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/meeting/department/console-edit.jsp");
		dispatcher.forward(request, response);
	}
}
