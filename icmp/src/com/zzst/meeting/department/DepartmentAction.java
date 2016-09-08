package com.zzst.meeting.department;

import java.sql.SQLException;
import java.util.ArrayList;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.department.DepartmentVO;

public class DepartmentAction {
	private ArrayList<DepartmentVO> list_department = new ArrayList<DepartmentVO>();
	
    public ArrayList<DepartmentVO> getAllDepartments(){
    	try {
    		list_department = ServiceFactory.getDepartmentService().getAllFuncList(new DepartmentVO(),null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_department;
    }
}
