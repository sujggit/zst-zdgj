package com.zzst.service.meeting.meetingDebug;

import java.util.ArrayList;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.meetingDebug.MeetingDebugDAO;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;

import org.apache.log4j.Logger;

/**
 * class description: MeetingDebug ServiceImpl
 * 
 * @date Tue May 28 15:03:30 CST 2013
 * @author ryan
 */
public class MeetingDebugServiceImpl implements MeetingDebugService {
	private static Logger logger = CjfLogger
			.getLogger(MeetingDebugServiceImpl.class.getName());

	@Override
	public MeetingDebugVO add(MeetingDebugVO meetingDebugVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingDebugVO = MeetingDebugDAO.add(meetingDebugVO, null);
		logger.info("serviceImpl	add	end");
		return meetingDebugVO;
	}

	@Override
	public ArrayList<MeetingDebugVO> query(MeetingDebugVO meetingDebugVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingDebugVO> listMeetingDebug = MeetingDebugDAO.query(
				meetingDebugVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingDebug;
	}

	@Override
	public MeetingDebugVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingDebugVO> listMeetingDebug = MeetingDebugDAO
				.queryByIDs(id, null);
		if (listMeetingDebug != null && listMeetingDebug.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingDebug.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingDebugVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingDebugVO> listMeetingDebug = MeetingDebugDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingDebug;
	}

	@Override
	public MeetingDebugVO modify(MeetingDebugVO meetingDebugVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingDebugVO = MeetingDebugDAO.modify(meetingDebugVO, null);
		logger.info("serviceImpl	modify	end");
		return meetingDebugVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MeetingDebugDAO.deleteByID(id, null);
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
