/**
 * 
 */
package com.zzst.service.meeting.department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.address.AddressDAO;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceDAO;
import com.zzst.dao.meeting.department.DepartmentDAO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.service.meeting.address.AddressServiceImpl;

/**
 * department interimpl
 * @author zhangliang
 * Nov 3, 201110:13:19 AM
 */
public class DepartmentServiceImpl implements DepartmentService {
	private static Logger logger = CjfLogger.getLogger(AddressServiceImpl.class.getName());
	/* (non-Javadoc)
	 * @see com.zzst.service.meeting.department.DepartmentService#getAllFuncList(com.zzst.model.meeting.department.DepartmentVO, com.cbf.db.PageController)
	 */
	@Override
	public ArrayList<DepartmentVO> getAllFuncList(DepartmentVO d,
			PageController pageController) throws SQLException {
		// TODO Auto-generated method stub
		return DepartmentDAO.getAllList(d, pageController) ;
	}

	/* (non-Javadoc)
	 * @see com.zzst.service.meeting.department.DepartmentService#ishaveChild(java.lang.String)
	 */
	@Override
	//判断当前节点有没有子节点
	public boolean ishaveChild(String id) throws Exception {
		// TODO Auto-generated method stub
		return DepartmentDAO.ishaveChild(id);
	}

	//获得当前节点的所有子节点
	public List<DepartmentVO> getallChild(String id) throws Exception {
		List <DepartmentVO>list=new ArrayList<DepartmentVO>();
		return DepartmentDAO.getChildrenById(id);
	}

	
	@Override
	public DepartmentVO addDepartment(DepartmentVO departmentVO ,boolean isAutoId) throws Exception {
		// TODO Auto-generated method stub
		//return null;
		logger.info("serviceImpl	add	begin");
		departmentVO = DepartmentDAO.addDepartment(departmentVO,isAutoId);
		logger.info("serviceImpl	add	end");
		return departmentVO;
	}

	@Override
	public DepartmentVO modifyDepartment(DepartmentVO departmentVO) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("serviceImpl	modify	begin");
		departmentVO = DepartmentDAO.modifyDepartment(departmentVO);
		logger.info("serviceImpl	modify	end");
		return departmentVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("serviceImpl	deleteByID	begin");
		int num = DepartmentDAO.delDepartment(id);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public boolean modifyDepartment(String id, String title)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		boolean b = DepartmentDAO.ajaxUpdateTitle(id, title);
		logger.info("serviceImpl	modify	end");
		return b;
	}

	@Override
	public DepartmentVO modifyParent(String id, String parentID) throws Exception {
		logger.info("serviceImpl	modifyParent	begin");
		DepartmentVO b = DepartmentDAO.modifyParent(id, parentID);
		logger.info("serviceImpl	modifyParent	end");
		return b;
	}

	@Override
	public int deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		int num = DepartmentDAO.deleteAll(null);
		logger.info("serviceImpl	deleteAll	end");
		return num;
	}

	@Override
	public List query(DepartmentVO dVo, PageController mPageController)
			throws SQLException {
		return DepartmentDAO.query(dVo, mPageController) ;
	}

	public ArrayList<DepartmentVO> getAllChildIDByParentID(String id) throws Exception {
		return DepartmentDAO.getAllChildIDByParentID(id);
	}

	
}
