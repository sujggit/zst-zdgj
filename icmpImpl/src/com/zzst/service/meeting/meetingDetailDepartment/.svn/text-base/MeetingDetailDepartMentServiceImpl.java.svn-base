package com.zzst.service.meeting.meetingDetailDepartment;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.meetingDetailDepartment.MeetingDetailDepartMentDAO;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;

/**
 * class description: MeetingDetailDepartMent ServiceImpl
 * 
 * @date Fri Apr 20 16:39:24 CST 2012
 * @author ryan
 */
public class MeetingDetailDepartMentServiceImpl implements MeetingDetailDepartMentService {
	private static Logger logger = CjfLogger.getLogger(MeetingDetailDepartMentServiceImpl.class.getName());

	@Override
	public MeetingDetailDepartMentVO add(MeetingDetailDepartMentVO meetingDetailDepartMentVO,TransactionManager tManager) throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingDetailDepartMentVO = MeetingDetailDepartMentDAO.add(meetingDetailDepartMentVO, null);
		logger.info("serviceImpl	add	end");
		return meetingDetailDepartMentVO;
	}

	@Override
	public ArrayList<MeetingDetailDepartMentVO> query(MeetingDetailDepartMentVO meetingDetailDepartMentVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingDetailDepartMentVO> listMeetingDetailDepartMent = MeetingDetailDepartMentDAO.query(
				meetingDetailDepartMentVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingDetailDepartMent;
	}

	@Override
	public MeetingDetailDepartMentVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingDetailDepartMentVO> listMeetingDetailDepartMent = MeetingDetailDepartMentDAO.queryByIDs(id,
				null);
		if (listMeetingDetailDepartMent != null && listMeetingDetailDepartMent.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingDetailDepartMent.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingDetailDepartMentVO> queryByIDs(String ids) throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingDetailDepartMentVO> listMeetingDetailDepartMent = MeetingDetailDepartMentDAO.queryByIDs(ids,
				null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingDetailDepartMent;
	}

	@Override
	public MeetingDetailDepartMentVO modify(MeetingDetailDepartMentVO meetingDetailDepartMentVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingDetailDepartMentVO = MeetingDetailDepartMentDAO.modify(meetingDetailDepartMentVO, null);
		logger.info("serviceImpl	modify	end");
		return meetingDetailDepartMentVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MeetingDetailDepartMentDAO.deleteByID(id, null);
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
		int num = MeetingDetailDepartMentDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

}
