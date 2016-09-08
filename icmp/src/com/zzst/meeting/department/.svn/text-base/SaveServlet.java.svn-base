/**
 * 
 */
package com.zzst.meeting.department;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzst.model.meeting.department.DepartmentVO;



/**
 * @author zhangliang
 * Nov 1, 2011 5:58:36 PM
 */
public class SaveServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DepartmentManager manager = new DepartmentManager();
		DepartmentVO obj = null;
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String number = request.getParameter("number");
		String parentId = request.getParameter("parentId");
		String leaf = request.getParameter("leaf");
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		
		if(null != id && !"".equals(id)&& !"null".equals(id)){
			obj = manager.get(id);
			if(obj == null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error/error.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}else{
			obj = new DepartmentVO();
			obj.setLeaf(new Integer(leaf));
			obj.setParentId(parentId);
		}
	//	obj.setNumber(new Integer(number));
		obj.setTitle(title);
	//	obj.setUrl(url);
		if(null != id && !"".equals(id)&&!"null".equals(id)){
			manager.update(obj);
		}else{
			manager.save(obj);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/meeting/department/reload.jsp");
		dispatcher.forward(request, response);		
	}
}
