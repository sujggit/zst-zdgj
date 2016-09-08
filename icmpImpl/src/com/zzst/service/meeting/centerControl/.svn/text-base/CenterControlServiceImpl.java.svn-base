package com.zzst.service.meeting.centerControl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.centerControl.CenterControlDAO;
import com.zzst.model.meeting.centerControl.CenterControlVO;

/**
 * class description: CenterControl ServiceImpl
 * 
 * @date Thu Jun 28 15:18:31 CST 2012
 * @author ryan
 */
public class CenterControlServiceImpl implements CenterControlService {
	private static Logger logger = CjfLogger.getLogger(CenterControlServiceImpl.class.getName());

	@Override
	public CenterControlVO add(CenterControlVO centerControlVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		centerControlVO = CenterControlDAO.add(centerControlVO, null);
		logger.info("serviceImpl	add	end");
		return centerControlVO;
	}

	@Override
	public ArrayList<CenterControlVO> query(CenterControlVO centerControlVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<CenterControlVO> listCenterControl = CenterControlDAO.query(centerControlVO, pageController);
		logger.info("serviceImpl	query	end");
		return listCenterControl;
	}

	@Override
	public CenterControlVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<CenterControlVO> listCenterControl = CenterControlDAO.queryByIDs(id, null);
		if (listCenterControl != null && listCenterControl.size() == 1) {
			logger.info("serviceImpl	end");
			return listCenterControl.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<CenterControlVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<CenterControlVO> listCenterControl = CenterControlDAO.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listCenterControl;
	}

	@Override
	public CenterControlVO modify(CenterControlVO centerControlVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		centerControlVO = CenterControlDAO.modify(centerControlVO, null);
		logger.info("serviceImpl	modify	end");
		return centerControlVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = CenterControlDAO.deleteByID(id, null);
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
		int num = CenterControlDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	
	public ArrayList<CenterControlVO> queryNoDuplicates(CenterControlVO centerControlVO) throws Exception{
		logger.info("serviceImpl    queryNoDuplicates begin");
		ArrayList<CenterControlVO> centerControlList = CenterControlDAO.queryNoDuplicates(centerControlVO);

		logger.info("serviceImpl    queryNoDuplicates end");
		return centerControlList;
		
	}

}
