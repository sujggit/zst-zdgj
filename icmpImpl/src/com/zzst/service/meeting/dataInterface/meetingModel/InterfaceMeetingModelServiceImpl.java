package com.zzst.service.meeting.dataInterface.meetingModel;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dataInterface.meetingModel.InterfaceMeetingModelDAO;
import com.zzst.model.meeting.dataInterface.meetingModel.InterfaceMeetingModelVO;

/**
 * class description: InterfaceMeetingModel ServiceImpl
 * 
 * @date Thu May 30 11:17:02 CST 2013
 * @author ryan
 */
public class InterfaceMeetingModelServiceImpl implements InterfaceMeetingModelService {
	private static Logger logger = CjfLogger.getLogger(InterfaceMeetingModelServiceImpl.class.getName());

	@Override
	public InterfaceMeetingModelVO add(InterfaceMeetingModelVO interfaceMeetingModelVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		interfaceMeetingModelVO = InterfaceMeetingModelDAO.add(interfaceMeetingModelVO, null);
		logger.info("serviceImpl	add	end");
		return interfaceMeetingModelVO;
	}

	@Override
	public ArrayList<InterfaceMeetingModelVO> query(InterfaceMeetingModelVO interfaceMeetingModelVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<InterfaceMeetingModelVO> listInterfaceMeetingModel = InterfaceMeetingModelDAO.query(
				interfaceMeetingModelVO, pageController);
		logger.info("serviceImpl	query	end");
		return listInterfaceMeetingModel;
	}

	@Override
	public InterfaceMeetingModelVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<InterfaceMeetingModelVO> listInterfaceMeetingModel = InterfaceMeetingModelDAO.queryByIDs(id, null);
		if (listInterfaceMeetingModel != null && listInterfaceMeetingModel.size() == 1) {
			logger.info("serviceImpl	end");
			return listInterfaceMeetingModel.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<InterfaceMeetingModelVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<InterfaceMeetingModelVO> listInterfaceMeetingModel = InterfaceMeetingModelDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listInterfaceMeetingModel;
	}

	@Override
	public InterfaceMeetingModelVO modify(InterfaceMeetingModelVO interfaceMeetingModelVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		interfaceMeetingModelVO = InterfaceMeetingModelDAO.modify(interfaceMeetingModelVO, null);
		logger.info("serviceImpl	modify	end");
		return interfaceMeetingModelVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = InterfaceMeetingModelDAO.deleteByID(id, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByID	end");
			return false;
		}
	}

	@Override
	public void deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		if (ids != null && ids.length() > 0) {
			String[] id = ids.split(",");
			for (int i = id.length; i >= 0; i--) {
				deleteByID(id[i]);
			}
		}
		logger.info("serviceImpl	deleteByIDs	end");
	}

}
