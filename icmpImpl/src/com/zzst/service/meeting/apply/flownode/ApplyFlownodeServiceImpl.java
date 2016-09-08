package com.zzst.service.meeting.apply.flownode;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.apply.flownode.ApplyFlownodeDAO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;

import org.apache.log4j.Logger;

/**
 * class description: ApplyFlownode ServiceImpl
 * 
 * @date Tue Jul 02 12:22:34 CST 2013
 * @author ryan
 */
public class ApplyFlownodeServiceImpl implements ApplyFlownodeService {
	private static Logger logger = CjfLogger
			.getLogger(ApplyFlownodeServiceImpl.class.getName());

	@Override
	public ApplyFlownodeVO add(ApplyFlownodeVO applyFlownodeVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		applyFlownodeVO = ApplyFlownodeDAO.add(applyFlownodeVO, null);
		logger.info("serviceImpl	add	end");
		return applyFlownodeVO;
	}

	@Override
	public ArrayList<ApplyFlownodeVO> query(ApplyFlownodeVO applyFlownodeVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ApplyFlownodeVO> listApplyFlownode = ApplyFlownodeDAO.query(
				applyFlownodeVO, pageController);
		logger.info("serviceImpl	query	end");
		return listApplyFlownode;
	}

	@Override
	public ApplyFlownodeVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ApplyFlownodeVO> listApplyFlownode = ApplyFlownodeDAO
				.queryByIDs(id, null);
		if (listApplyFlownode != null && listApplyFlownode.size() == 1) {
			logger.info("serviceImpl	end");
			return listApplyFlownode.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ApplyFlownodeVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ApplyFlownodeVO> listApplyFlownode = ApplyFlownodeDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listApplyFlownode;
	}

	@Override
	public ApplyFlownodeVO modify(ApplyFlownodeVO applyFlownodeVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		applyFlownodeVO = ApplyFlownodeDAO.modify(applyFlownodeVO, null);
		logger.info("serviceImpl	modify	end");
		return applyFlownodeVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ApplyFlownodeDAO.deleteByID(id, null);
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

	@Override
	public ArrayList<ApplyFlownodeVO> queryWithOthTab(
			ApplyFlownodeVO applyFlownodeVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	queryWithOthTab	begin");
		ArrayList<ApplyFlownodeVO> listApplyFlownode = ApplyFlownodeDAO.queryWithOthTab(
				applyFlownodeVO, pageController);
		logger.info("serviceImpl	queryWithOthTab	end");
		return listApplyFlownode;
	}

	@Override
	public boolean deleteByFlowID(ApplyFlownodeVO applyFlownodeVO) throws Exception {
		logger.info("serviceImpl	deleteByFlowID	begin");
		int num = ApplyFlownodeDAO.deleteByFlowID(applyFlownodeVO, null);
		if (num == 1) {
			logger.info("serviceImpl	deleteByFlowID	end");
			return true;
		} else {
			logger.info("serviceImpl	deleteByFlowID	end");
			return false;
		}
	}

}
