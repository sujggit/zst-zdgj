package com.zzst.service.meeting.dataInterface.role;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceDAO;
import com.zzst.dao.meeting.dataInterface.role.RoleInterfaceDAO;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;

/**
 * class description: RoleInterface ServiceImpl
 * 
 * @date Mon Jun 17 19:18:02 CST 2013
 * @author ryan
 */
public class RoleInterfaceServiceImpl implements RoleInterfaceService {
	private static Logger logger = CjfLogger
			.getLogger(RoleInterfaceServiceImpl.class.getName());

	@Override
	public RoleInterfaceVO add(RoleInterfaceVO roleInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		roleInterfaceVO = RoleInterfaceDAO.add(roleInterfaceVO, null);
		logger.info("serviceImpl	add	end");
		return roleInterfaceVO;
	}

	@Override
	public ArrayList<RoleInterfaceVO> query(RoleInterfaceVO roleInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<RoleInterfaceVO> listRoleInterface = RoleInterfaceDAO.query(
				roleInterfaceVO, pageController);
		logger.info("serviceImpl	query	end");
		return listRoleInterface;
	}

	@Override
	public RoleInterfaceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<RoleInterfaceVO> listRoleInterface = RoleInterfaceDAO
				.queryByIDs(id, null);
		if (listRoleInterface != null && listRoleInterface.size() == 1) {
			logger.info("serviceImpl	end");
			return listRoleInterface.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<RoleInterfaceVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<RoleInterfaceVO> listRoleInterface = RoleInterfaceDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listRoleInterface;
	}

	@Override
	public RoleInterfaceVO modify(RoleInterfaceVO roleInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		roleInterfaceVO = RoleInterfaceDAO.modify(roleInterfaceVO, null);
		logger.info("serviceImpl	modify	end");
		return roleInterfaceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = RoleInterfaceDAO.deleteByID(id, null);
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
		int num = RoleInterfaceDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public ArrayList<RoleInterfaceVO> queryAvailable(
			RoleInterfaceVO roleInterfaceVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	queryAvailable	begin");
		ArrayList<RoleInterfaceVO> listRoleInterface = RoleInterfaceDAO.queryAvailable(
				roleInterfaceVO, pageController);
		logger.info("serviceImpl	queryAvailable	end");
		return listRoleInterface;
	}

	@Override
	public int deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		int num = RoleInterfaceDAO.deleteAll(null);
		logger.info("serviceImpl	deleteAll	end");
		return num;
	}

	@Override
	public RoleInterfaceVO addByCreateId(RoleInterfaceVO roleInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	addByCreateId	begin");
		roleInterfaceVO = RoleInterfaceDAO.addByCreateId(roleInterfaceVO, null);
		logger.info("serviceImpl	addByCreateId	end");
		return roleInterfaceVO;
	}

	
	
}
