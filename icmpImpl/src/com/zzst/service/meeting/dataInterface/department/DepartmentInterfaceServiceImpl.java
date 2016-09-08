package com.zzst.service.meeting.dataInterface.department;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dataInterface.department.DepartmentInterfaceDAO;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceDAO;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;

/**
 * class description: DepartmentInterface ServiceImpl
 * 
 * @date Tue Jun 18 17:35:52 CST 2013
 * @author ryan
 */
public class DepartmentInterfaceServiceImpl implements
		DepartmentInterfaceService {
	private static Logger logger = CjfLogger
			.getLogger(DepartmentInterfaceServiceImpl.class.getName());

	@Override
	public DepartmentInterfaceVO add(DepartmentInterfaceVO departmentInterfaceVO,boolean ifAutoId)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		departmentInterfaceVO = DepartmentInterfaceDAO.add(
				departmentInterfaceVO,ifAutoId, null);
		logger.info("serviceImpl	add	end");
		return departmentInterfaceVO;
	}

	@Override
	public ArrayList<DepartmentInterfaceVO> query(
			DepartmentInterfaceVO departmentInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<DepartmentInterfaceVO> listDepartmentInterface = DepartmentInterfaceDAO
				.query(departmentInterfaceVO, pageController);
		logger.info("serviceImpl	query	end");
		return listDepartmentInterface;
	}

	@Override
	public DepartmentInterfaceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<DepartmentInterfaceVO> listDepartmentInterface = DepartmentInterfaceDAO
				.queryByIDs(id, null);
		if (listDepartmentInterface != null
				&& listDepartmentInterface.size() == 1) {
			logger.info("serviceImpl	end");
			return listDepartmentInterface.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<DepartmentInterfaceVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<DepartmentInterfaceVO> listDepartmentInterface = DepartmentInterfaceDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listDepartmentInterface;
	}

	@Override
	public DepartmentInterfaceVO modify(
			DepartmentInterfaceVO departmentInterfaceVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		departmentInterfaceVO = DepartmentInterfaceDAO.modify(
				departmentInterfaceVO, null);
		logger.info("serviceImpl	modify	end");
		return departmentInterfaceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = DepartmentInterfaceDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = DepartmentInterfaceDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public int deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		int num = DepartmentInterfaceDAO.deleteAll(null);
		logger.info("serviceImpl	deleteAll	end");
		return num;
	}

	@Override
	public ArrayList<DepartmentInterfaceVO> queryAvailable(
			DepartmentInterfaceVO departmentInterfaceVO,
			PageController pageController) throws Exception {
			logger.info("serviceImpl	queryAvailable	begin");
			ArrayList<DepartmentInterfaceVO> listDepartmentInterface = DepartmentInterfaceDAO
					.queryAvailable(departmentInterfaceVO, pageController);
			
			/*LogVO  logVO  = new LogVO();
			logVO.setLogType(LogEnum.TYPE_DEFAULT);
			logVO.setLevel(LogEnum.LEVEL_DeFAULT);
			logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行查询操作");
			new LogServiceImpl().add(logVO);*/
			
			
			logger.info("serviceImpl	queryAvailable	end");
			return listDepartmentInterface;
	}
	
	
}
