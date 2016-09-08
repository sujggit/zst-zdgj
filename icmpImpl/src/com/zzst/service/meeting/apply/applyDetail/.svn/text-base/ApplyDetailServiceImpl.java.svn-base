package com.zzst.service.meeting.apply.applyDetail;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.apply.applyDetail.ApplyDetailDAO;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;

import org.apache.log4j.Logger;

/**
 * class description: ApplyDetail ServiceImpl
 * 
 * @date Tue Jul 02 12:22:34 CST 2013
 * @author ryan
 */
public class ApplyDetailServiceImpl implements ApplyDetailService {
	private static Logger logger = CjfLogger
			.getLogger(ApplyDetailServiceImpl.class.getName());

	@Override
	public ApplyDetailVO add(ApplyDetailVO applyDetailVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		applyDetailVO = ApplyDetailDAO.add(applyDetailVO, null);
		logger.info("serviceImpl	add	end");
		return applyDetailVO;
	}

	@Override
	public ArrayList<ApplyDetailVO> query(ApplyDetailVO applyDetailVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ApplyDetailVO> listApplyDetail = ApplyDetailDAO.query(
				applyDetailVO, pageController);
		logger.info("serviceImpl	query	end");
		return listApplyDetail;
	}

	@Override
	public ApplyDetailVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ApplyDetailVO> listApplyDetail = ApplyDetailDAO.queryByIDs(
				id, null);
		if (listApplyDetail != null && listApplyDetail.size() == 1) {
			logger.info("serviceImpl	end");
			return listApplyDetail.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ApplyDetailVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ApplyDetailVO> listApplyDetail = ApplyDetailDAO.queryByIDs(
				ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listApplyDetail;
	}

	@Override
	public ApplyDetailVO modify(ApplyDetailVO applyDetailVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		applyDetailVO = ApplyDetailDAO.modify(applyDetailVO, null);
		logger.info("serviceImpl	modify	end");
		return applyDetailVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ApplyDetailDAO.deleteByID(id, null);
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
