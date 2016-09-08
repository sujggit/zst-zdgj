package com.zzst.service.project.avic.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.project.avic.service.AvicServiceDAO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.service.AvicServiceVO;

/**
 * class description: AvicService ServiceImpl
 * 
 * @date Thu Sep 20 15:23:06 CST 2012
 * @author ryan
 */
public class AvicServiceServiceImpl implements AvicServiceService {
	private static Logger logger = CjfLogger
			.getLogger(AvicServiceServiceImpl.class.getName());

	@Override
	public AvicServiceVO add(AvicServiceVO avicServiceVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		avicServiceVO = AvicServiceDAO.add(avicServiceVO, null);
		logger.info("serviceImpl	add	end");
		return avicServiceVO;
	}

	@Override
	public ArrayList<AvicServiceVO> query(AvicServiceVO avicServiceVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<AvicServiceVO> listAvicService = AvicServiceDAO.query(
				avicServiceVO, pageController);
		logger.info("serviceImpl	query	end");
		return listAvicService;
	}

	@Override
	public AvicServiceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<AvicServiceVO> listAvicService = AvicServiceDAO.queryByIDs(
				id, null);
		if (listAvicService != null && listAvicService.size() == 1) {
			logger.info("serviceImpl	end");
			return listAvicService.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<AvicServiceVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<AvicServiceVO> listAvicService = AvicServiceDAO.queryByIDs(
				ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listAvicService;
	}

	@Override
	public AvicServiceVO modify(AvicServiceVO avicServiceVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		avicServiceVO = AvicServiceDAO.modify(avicServiceVO, null);
		logger.info("serviceImpl	modify	end");
		return avicServiceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = AvicServiceDAO.deleteByID(id, null);
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
		int num = AvicServiceDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public ArrayList<AvicServiceVO> queryApplyServices(
			AvicServiceVO avicServiceVO, UserVO userVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryApplyServices	begin");
		ArrayList<AvicServiceVO> listApply;
		listApply = AvicServiceDAO.queryApplyServices(avicServiceVO,userVO.getUserID(),  pageController);
		logger.info("serviceImpl queryApplyServices	end");
		return listApply;
	}

	@Override
	public ArrayList<AvicServiceVO> queryApplyServicesHistory(
			AvicServiceVO avicServiceVO, UserVO userVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl queryApplyServicesHistory	begin");
		ArrayList<AvicServiceVO> listApply;
		listApply = AvicServiceDAO.queryApplyServicesHistory(avicServiceVO,userVO.getUserID(), pageController);
		logger.info("serviceImpl queryApplyServicesHistory	end");
		return listApply;
	}

	@Override
	public ArrayList<AvicServiceVO> queryApplyServicesHistory(
			AvicServiceVO avicServiceVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl queryApplyServicesHistory	begin");
		ArrayList<AvicServiceVO> listApply;
		listApply = AvicServiceDAO.queryApplyServicesHistory(avicServiceVO, pageController);
		logger.info("serviceImpl queryApplyServicesHistory	end");
		return listApply;
	}

	@Override
	public List<AvicServiceVO> queryForCostStatistices(
			AvicServiceVO avicServiceVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl queryForCostStatistices	begin");
		ArrayList<AvicServiceVO> listApply;
		listApply = AvicServiceDAO.queryForCostStatistices(avicServiceVO, pageController);
		logger.info("serviceImpl queryForCostStatistices	end");
		return listApply;
	}
	
	

}
