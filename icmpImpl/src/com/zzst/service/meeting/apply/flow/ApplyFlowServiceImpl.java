package com.zzst.service.meeting.apply.flow;

import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.apply.flow.ApplyFlowDAO;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;

import org.apache.log4j.Logger;

/**
 * class description: ApplyFlow ServiceImpl
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public class ApplyFlowServiceImpl implements ApplyFlowService {
	private static Logger logger = CjfLogger
			.getLogger(ApplyFlowServiceImpl.class.getName());

	@Override
	public ApplyFlowVO add(ApplyFlowVO applyFlowVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		applyFlowVO = ApplyFlowDAO.add(applyFlowVO, null);
		logger.info("serviceImpl	add	end");
		return applyFlowVO;
	}

	@Override
	public ArrayList<ApplyFlowVO> query(ApplyFlowVO applyFlowVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ApplyFlowVO> listApplyFlow = ApplyFlowDAO.query(applyFlowVO,
				pageController);
		logger.info("serviceImpl	query	end");
		return listApplyFlow;
	}

	@Override
	public ApplyFlowVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ApplyFlowVO> listApplyFlow = ApplyFlowDAO
				.queryByIDs(id, null);
		if (listApplyFlow != null && listApplyFlow.size() == 1) {
			logger.info("serviceImpl	end");
			return listApplyFlow.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ApplyFlowVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ApplyFlowVO> listApplyFlow = ApplyFlowDAO.queryByIDs(ids,
				null);
		logger.info("serviceImpl	queryByIDs	end");
		return listApplyFlow;
	}

	@Override
	public ApplyFlowVO modify(ApplyFlowVO applyFlowVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		applyFlowVO = ApplyFlowDAO.modify(applyFlowVO, null);
		logger.info("serviceImpl	modify	end");
		return applyFlowVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ApplyFlowDAO.deleteByID(id, null);
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
