package com.zzst.service.meeting.dataInterface.user;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.dataInterface.role.RoleInterfaceDAO;
import com.zzst.dao.meeting.dataInterface.user.UserInterfaceDAO;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;

/**
 * class description: UserInterface ServiceImpl
 * 
 * @date Tue Jun 18 18:58:24 CST 2013
 * @author ryan
 */
public class UserInterfaceServiceImpl implements UserInterfaceService {
	private static Logger logger = CjfLogger
			.getLogger(UserInterfaceServiceImpl.class.getName());

	@Override
	public UserInterfaceVO add(UserInterfaceVO userInterfaceVO,boolean isAuto)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		if(isAuto){
			userInterfaceVO.setUserid(UtilDAO.getUUid());
		}
		userInterfaceVO = UserInterfaceDAO.add(userInterfaceVO, null);
		logger.info("serviceImpl	add	end");
		return userInterfaceVO;
	}

	@Override
	public ArrayList<UserInterfaceVO> query(UserInterfaceVO userInterfaceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<UserInterfaceVO> listUserInterface = UserInterfaceDAO.query(
				userInterfaceVO, pageController);
		logger.info("serviceImpl	query	end");
		return listUserInterface;
	}

	@Override
	public UserInterfaceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<UserInterfaceVO> listUserInterface = UserInterfaceDAO
				.queryByIDs(id, null);
		if (listUserInterface != null && listUserInterface.size() == 1) {
			logger.info("serviceImpl	end");
			return listUserInterface.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<UserInterfaceVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<UserInterfaceVO> listUserInterface = UserInterfaceDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listUserInterface;
	}

	@Override
	public UserInterfaceVO modify(UserInterfaceVO userInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		userInterfaceVO = UserInterfaceDAO.modify(userInterfaceVO, null);
		logger.info("serviceImpl	modify	end");
		return userInterfaceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = UserInterfaceDAO.deleteByID(id, null);
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
		int num = UserInterfaceDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	
	@Override
	public ArrayList<UserInterfaceVO> queryAvailable(
			UserInterfaceVO userInterfaceVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	queryAvailable	begin");
		ArrayList<UserInterfaceVO> listUserInterface = UserInterfaceDAO.queryAvailable(
				userInterfaceVO, pageController);
		logger.info("serviceImpl	queryAvailable	end");
		return listUserInterface;
	}

	@Override
	public int deleteAll() throws Exception {
		logger.info("serviceImpl	deleteAll	begin");
		int num = UserInterfaceDAO.deleteAll(null);
		logger.info("serviceImpl	deleteAll	end");
		return num;
	}

	@Override
	public UserInterfaceVO addByCreateId(UserInterfaceVO userInterfaceVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		userInterfaceVO = UserInterfaceDAO.addByCreateId(userInterfaceVO, null);
		logger.info("serviceImpl	add	end");
		return userInterfaceVO;
	}
	
	
}
