package com.zzst.service.meeting.dataInterface.meetingDetail;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailDAO;
import com.zzst.model.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailVO;

/**
 * class description: InterfaceMeetingDetail ServiceImpl
 * 
 * @date Thu May 30 11:03:50 CST 2013
 * @author ryan
 */
public class InterfaceMeetingDetailServiceImpl implements InterfaceMeetingDetailService {
	private static Logger logger = CjfLogger.getLogger(InterfaceMeetingDetailServiceImpl.class.getName());

	@Override
	public InterfaceMeetingDetailVO add(InterfaceMeetingDetailVO interfaceMeetingDetailVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		interfaceMeetingDetailVO = InterfaceMeetingDetailDAO.add(interfaceMeetingDetailVO, null);
		logger.info("serviceImpl	add	end");
		return interfaceMeetingDetailVO;
	}

	@Override
	public ArrayList<InterfaceMeetingDetailVO> query(InterfaceMeetingDetailVO interfaceMeetingDetailVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<InterfaceMeetingDetailVO> listInterfaceMeetingDetail = InterfaceMeetingDetailDAO.query(
				interfaceMeetingDetailVO, pageController);
		logger.info("serviceImpl	query	end");
		return listInterfaceMeetingDetail;
	}

	@Override
	public InterfaceMeetingDetailVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<InterfaceMeetingDetailVO> listInterfaceMeetingDetail = InterfaceMeetingDetailDAO.queryByIDs(id, null);
		if (listInterfaceMeetingDetail != null && listInterfaceMeetingDetail.size() == 1) {
			logger.info("serviceImpl	end");
			return listInterfaceMeetingDetail.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<InterfaceMeetingDetailVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<InterfaceMeetingDetailVO> listInterfaceMeetingDetail = InterfaceMeetingDetailDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listInterfaceMeetingDetail;
	}

	@Override
	public InterfaceMeetingDetailVO modify(InterfaceMeetingDetailVO interfaceMeetingDetailVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		interfaceMeetingDetailVO = InterfaceMeetingDetailDAO.modify(interfaceMeetingDetailVO, null);
		logger.info("serviceImpl	modify	end");
		return interfaceMeetingDetailVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = InterfaceMeetingDetailDAO.deleteByID(id, null);
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
