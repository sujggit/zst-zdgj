/**
 * 
 */
package com.zzst.service.meeting.department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.department.DepartmentVO;


/**
 * department inter
 * @author zhangliang
 * Nov 3, 2011 10:10:08 AM
 */
public interface DepartmentService {
	public boolean ishaveChild(String id)  throws Exception ;
	public  ArrayList<DepartmentVO> getAllFuncList(DepartmentVO d,PageController mPageController) throws SQLException;
	public DepartmentVO addDepartment(DepartmentVO departmentVO,boolean isAutoId) throws Exception;
	/**
	 * 提取子节点方法
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ArrayList<DepartmentVO> getAllChildIDByParentID(String id) throws Exception ;
	public List getallChild(String id) throws Exception ;
	public DepartmentVO modifyDepartment(DepartmentVO departmentVO) throws Exception;
	public boolean modifyDepartment(String id,String title) throws Exception;
	public DepartmentVO modifyParent(String id,String parentID) throws Exception;
	public boolean deleteByID(String id) throws Exception;
	public int deleteAll() throws Exception;
	public List query(DepartmentVO dVo, PageController mPageController) throws SQLException;
}
