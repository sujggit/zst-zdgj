package com.zzst.service.meeting.meetingRoomMaintain;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.meetingRoomMaintain.MeetingRoomMaintainDAO;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;

/**
 * class description: MeetingRoomMaintain ServiceImpl
 * 
 * @date Wed Sep 12 09:42:15 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainServiceImpl implements
		MeetingRoomMaintainService {
	private static Logger logger = CjfLogger
			.getLogger(MeetingRoomMaintainServiceImpl.class.getName());

	@Override
	public MeetingRoomMaintainVO add(MeetingRoomMaintainVO meetingRoomMaintainVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingRoomMaintainVO = MeetingRoomMaintainDAO.add(
				meetingRoomMaintainVO, null);
		logger.info("serviceImpl	add	end");
		return meetingRoomMaintainVO;
	}

	@Override
	public ArrayList<MeetingRoomMaintainVO> query(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingRoomMaintainVO> listMeetingRoomMaintain = MeetingRoomMaintainDAO
				.query(meetingRoomMaintainVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingRoomMaintain;
	}

	@Override
	public MeetingRoomMaintainVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingRoomMaintainVO> listMeetingRoomMaintain = MeetingRoomMaintainDAO
				.queryByIDs(id, null);
		if (listMeetingRoomMaintain != null
				&& listMeetingRoomMaintain.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingRoomMaintain.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingRoomMaintainVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingRoomMaintainVO> listMeetingRoomMaintain = MeetingRoomMaintainDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingRoomMaintain;
	}

	@Override
	public MeetingRoomMaintainVO modify(
			MeetingRoomMaintainVO meetingRoomMaintainVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingRoomMaintainVO = MeetingRoomMaintainDAO.modify(
				meetingRoomMaintainVO, null);
		logger.info("serviceImpl	modify	end");
		return meetingRoomMaintainVO;
	}

	@Override
	public boolean deleteByID(MeetingRoomMaintainVO meetingRoomMaintainVO) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
//		int num = MeetingRoomMaintainDAO.deleteByID(id, null);
//		if (num == 1) {
//			logger.info("serviceImpl	deleteByID	end");
//			return true;
//		} else {
//			logger.info("serviceImpl	deleteByID	end");
//			return false;
//		}
		TransactionManager tManager = new TransactionManager();
		try {
		//	tManager.beginTransaction();
			MeetingRoomMaintainDAO.modify(meetingRoomMaintainVO, null);
		//	int num = MeetingRoomDAO.deleteByID(id);
		
		}catch(Exception e){
		//	tManager.rollback();
		//	tManager.endTransaction();
			logger.error("serviceImpl	deleteByID		error	: "+e.getMessage());
			return false;
		}
		logger.info("serviceImpl	deleteByID		end");
	    return true;
	}

	@Override
	public int deleteByIDs(String ids) throws Exception {
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = MeetingRoomMaintainDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	@Override
	public ArrayList<MeetingRoomMaintainVO> queryRoomMaintainConference(
			MeetingRoomMaintainVO meetingRoomMaintainVO,
			PageController pControler) throws Exception {
		logger.info("serviceImpl	queryRoomMaintainConference	begin");
		ArrayList<MeetingRoomMaintainVO> listMeetingRoomMaintain = MeetingRoomMaintainDAO
				.queryRoomMaintainConference(meetingRoomMaintainVO, pControler);
		logger.info("serviceImpl	queryRoomMaintainConference	end");
		return listMeetingRoomMaintain;
	}

	public ArrayList<MeetingRoomMaintainVO> queryRoomMaintain(MeetingRoomMaintainVO meetingRoomMaintainVO, PageController pControler) throws Exception {
		logger.info("serviceImpl	queryRoomMaintain	begin");
		ArrayList<MeetingRoomMaintainVO> listMeetingRoomMaintain = MeetingRoomMaintainDAO
				.queryRoomMaintain(meetingRoomMaintainVO, pControler);
		logger.info("serviceImpl	queryRoomMaintain	end");
		return listMeetingRoomMaintain;
	}

}
