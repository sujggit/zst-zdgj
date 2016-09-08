package com.zzst.service.project.avic.applyConference;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.project.avic.applyConference.ApplyConferenceDAO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

/**	
 * class description: ApplyConference ServiceImpl
 * @date  Wed Sep 19 16:15:16 CST 2012
 * @author ryan
 */
public class ApplyConferenceServiceImpl implements ApplyConferenceService {
	private static Logger logger = CjfLogger
			.getLogger(ApplyConferenceServiceImpl.class.getName());

	@Override
	public ApplyConferenceVO add(ApplyConferenceVO applyConferenceVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		applyConferenceVO = ApplyConferenceDAO.add(applyConferenceVO, null);
		logger.info("serviceImpl	add	end");
		return applyConferenceVO;
	}

	@Override
	public ArrayList<ApplyConferenceVO> query(
			ApplyConferenceVO applyConferenceVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<ApplyConferenceVO> listApplyConference = ApplyConferenceDAO
				.query(applyConferenceVO, pageController);
		logger.info("serviceImpl	query	end");
		return listApplyConference;
	}

	@Override
	public ApplyConferenceVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<ApplyConferenceVO> listApplyConference = ApplyConferenceDAO
				.queryByIDs(id, null);
		if (listApplyConference != null && listApplyConference.size() == 1) {
			logger.info("serviceImpl	end");
			return listApplyConference.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<ApplyConferenceVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<ApplyConferenceVO> listApplyConference = ApplyConferenceDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listApplyConference;
	}

	@Override
	public ApplyConferenceVO modify(ApplyConferenceVO applyConferenceVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		applyConferenceVO = ApplyConferenceDAO.modify(applyConferenceVO, null);
		logger.info("serviceImpl	modify	end");
		return applyConferenceVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = ApplyConferenceDAO.deleteByID(id, null);
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
		int num = ApplyConferenceDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}


	@Override
	public ArrayList<ApplyConferenceVO> getNoServiceConference()
			throws Exception {
		logger.info("serviceImpl	getNoServiceConference	begin");
		ArrayList<ApplyConferenceVO> listApplyConference = ApplyConferenceDAO
				.queryNoServiceConference(null);
		logger.info("serviceImpl	getNoServiceConference	end");
		return listApplyConference;
	}

	@Override
	public ArrayList<ApplyConferenceVO> queryApplyConferences(ApplyConferenceVO applyConferenceVO,UserVO userVO ,PageController pageController)throws Exception {
		logger.info("serviceImpl queryApplyConferences	begin");
		ArrayList<ApplyConferenceVO> listApply;
		listApply = ApplyConferenceDAO.queryApplyConferences(applyConferenceVO,userVO.getUserID(), pageController);
		logger.info("serviceImpl queryApplyConferences	end");
		return listApply;
	}
	
	@Override
	public ArrayList<ApplyConferenceVO> queryApplyConferencesHistory(ApplyConferenceVO applyConferenceVO,
			UserVO userVO,PageController pageController) throws Exception {
		logger.info("serviceImpl queryApplyConferencesHistory	begin");
		ArrayList<ApplyConferenceVO> listApply;
		listApply = ApplyConferenceDAO.queryApplyConferencesHistory(applyConferenceVO,userVO.getUserID(), pageController);
		logger.info("serviceImpl queryApplyConferencesHistory	end");
		return listApply;
	}
	
	@Override
	public ArrayList<ApplyConferenceVO> queryApplyConferencesHistory(
			ApplyConferenceVO applyConferenceVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl queryApplyConferencesHistoryAll	begin");
		ArrayList<ApplyConferenceVO> listApply;
		listApply = ApplyConferenceDAO.queryApplyConferencesHistory(applyConferenceVO, pageController);
		logger.info("serviceImpl queryApplyConferencesHistoryAll	end");
		return listApply;
	}

	@Override
	public ArrayList<ApplyConferenceVO> queryBusyMeetingRoom(
			ApplyConferenceVO applyConferenceVO, PageController pageController)
			throws Exception {
		logger.info("serviceImpl queryBusyMeetingRoom	begin");
		ArrayList<ApplyConferenceVO> listApply;
		listApply = ApplyConferenceDAO.queryBusyMeetingRoom(applyConferenceVO, pageController);
		logger.info("serviceImpl queryBusyMeetingRoom	end");
		return listApply;
	}
}
