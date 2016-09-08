package com.zzst.service.meeting.meetingDetailEquipment;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.meetingDetailEquipment.MeetingDetailEquipmentDAO;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;

/**
 * class description: MeetingDetailEquipment ServiceImpl
 * 
 * @date Wed May 07 16:48:00 CST 2014
 * @author ryan
 */
public class MeetingDetailEquipmentServiceImpl implements
		MeetingDetailEquipmentService {
	private static Logger logger = CjfLogger
			.getLogger(MeetingDetailEquipmentServiceImpl.class.getName());

	@Override
	public MeetingDetailEquipmentVO add(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO,TransactionManager tManager) throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingDetailEquipmentVO = MeetingDetailEquipmentDAO.add(
				meetingDetailEquipmentVO, null);
		logger.info("serviceImpl	add	end");
		return meetingDetailEquipmentVO;
	}

	@Override
	public ArrayList<MeetingDetailEquipmentVO> query(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingDetailEquipmentVO> listMeetingDetailEquipment = MeetingDetailEquipmentDAO
				.query(meetingDetailEquipmentVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingDetailEquipment;
	}

	@Override
	public MeetingDetailEquipmentVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingDetailEquipmentVO> listMeetingDetailEquipment = MeetingDetailEquipmentDAO
				.queryByIDs(id, null);
		if (listMeetingDetailEquipment != null
				&& listMeetingDetailEquipment.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingDetailEquipment.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingDetailEquipmentVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingDetailEquipmentVO> listMeetingDetailEquipment = MeetingDetailEquipmentDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingDetailEquipment;
	}

	@Override
	public MeetingDetailEquipmentVO modify(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingDetailEquipmentVO = MeetingDetailEquipmentDAO.modify(
				meetingDetailEquipmentVO, null);
		logger.info("serviceImpl	modify	end");
		return meetingDetailEquipmentVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MeetingDetailEquipmentDAO.deleteByIDs(id, null);
		logger.info("delete number : " + num);
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
		int num = MeetingDetailEquipmentDAO.deleteByIDs(ids, null);
		logger.info("delete number : " + num);
		logger.info("serviceImpl	deleteByIDs	end");
	}

	@Override
	public ArrayList<MeetingDetailEquipmentVO> queryFuzzySearch(String ids,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryFuzzySearch	begin");
		ArrayList<MeetingDetailEquipmentVO> listMeetingDetailEquipment = MeetingDetailEquipmentDAO
				.queryFuzzySearch(ids, null);
		logger.info("serviceImpl	queryFuzzySearch	end");
		return listMeetingDetailEquipment;
	}

	@Override
	public ArrayList<MeetingDetailEquipmentVO> queryUseEquipmentList(
			Timestamp startTime,Timestamp endTime,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryUseEquipmentList	begin");
		ArrayList<MeetingDetailEquipmentVO> listMeetingDetailEquipment = MeetingDetailEquipmentDAO
				.queryUseEquipment(startTime, endTime, pageController);
		logger.info("serviceImpl	queryUseEquipmentList	end");
		return listMeetingDetailEquipment;
	}
	
	@Override
	public ArrayList<MeetingDetailEquipmentVO> queryMeeting(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	queryMeeting	begin");
		ArrayList<MeetingDetailEquipmentVO> listMeetingDetailEquipment = MeetingDetailEquipmentDAO
				.queryMeeting(meetingDetailEquipmentVO, pageController);
		logger.info("serviceImpl	queryMeeting	end");
		return listMeetingDetailEquipment;
	}
}
