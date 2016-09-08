package com.zzst.service.meeting.meetingRoomMaintainDetail;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailDAO;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;

/**
 * class description: MeetingRoomMaintainDetail ServiceImpl
 * 
 * @date Wed Sep 12 10:15:30 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainDetailServiceImpl implements
		MeetingRoomMaintainDetailService {
	private static Logger logger = CjfLogger
			.getLogger(MeetingRoomMaintainDetailServiceImpl.class.getName());

	@Override
	public MeetingRoomMaintainDetailVO add(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingRoomMaintainDetailVO = MeetingRoomMaintainDetailDAO.add(
				meetingRoomMaintainDetailVO, null);
		logger.info("serviceImpl	add	end");
		return meetingRoomMaintainDetailVO;
	}

	@Override
	public ArrayList<MeetingRoomMaintainDetailVO> query(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingRoomMaintainDetailVO> listMeetingRoomMaintainDetail = MeetingRoomMaintainDetailDAO
				.query(meetingRoomMaintainDetailVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingRoomMaintainDetail;
	}

	@Override
	public MeetingRoomMaintainDetailVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingRoomMaintainDetailVO> listMeetingRoomMaintainDetail = MeetingRoomMaintainDetailDAO
				.queryByIDs(id, null);
		if (listMeetingRoomMaintainDetail != null
				&& listMeetingRoomMaintainDetail.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingRoomMaintainDetail.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingRoomMaintainDetailVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingRoomMaintainDetailVO> listMeetingRoomMaintainDetail = MeetingRoomMaintainDetailDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingRoomMaintainDetail;
	}

	@Override
	public MeetingRoomMaintainDetailVO modify(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingRoomMaintainDetailVO = MeetingRoomMaintainDetailDAO.modify(
				meetingRoomMaintainDetailVO, null);
		logger.info("serviceImpl	modify	end");
		return meetingRoomMaintainDetailVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MeetingRoomMaintainDetailDAO.deleteByID(id, null);
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
		int num = MeetingRoomMaintainDetailDAO.deleteByID(ids, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}
	//addby duting
	public int deleteByMaintainID(String maintainID)throws Exception{
		logger.info("serviceImpl	deleteByIDs	begin");
		int num = MeetingRoomMaintainDetailDAO.deleteByMaintainID(maintainID, null);
		logger.info("serviceImpl	deleteByIDs	end");
		return num;
	}

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo(
				"jdbc:mysql://localhost:3306/icmp?characterEncoding=gb2312",
				"root", "yume");
		MeetingRoomMaintainDetailVO vMeetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
		vMeetingRoomMaintainDetailVO.setDetailID("detailID");
		vMeetingRoomMaintainDetailVO.setMaintainID("maintainID");
		vMeetingRoomMaintainDetailVO.setMaintainName("maintainName");
		vMeetingRoomMaintainDetailVO.setStatus(8);
		vMeetingRoomMaintainDetailVO.setQuestionDes("questionDes");
		vMeetingRoomMaintainDetailVO.setRevision(new Long(888));
		vMeetingRoomMaintainDetailVO.setDescription("description");

		new MeetingRoomMaintainDetailServiceImpl()
				.add(vMeetingRoomMaintainDetailVO);
		System.out.println("=========add Success!");

		ArrayList<MeetingRoomMaintainDetailVO> lstMeetingRoomMaintainDetail = new MeetingRoomMaintainDetailServiceImpl()
				.query(vMeetingRoomMaintainDetailVO, null);

		if (lstMeetingRoomMaintainDetail.size() > 0) {
			System.out.println("=========query Result:");
			MeetingRoomMaintainDetailVO vvMeetingRoomMaintainDetailVO = (MeetingRoomMaintainDetailVO) lstMeetingRoomMaintainDetail
					.get(0);
			System.out.println("detailID="
					+ vvMeetingRoomMaintainDetailVO.getDetailID());
			System.out.println("maintainID="
					+ vvMeetingRoomMaintainDetailVO.getMaintainID());
			System.out.println("maintainName="
					+ vvMeetingRoomMaintainDetailVO.getMaintainName());
			System.out.println("status="
					+ vvMeetingRoomMaintainDetailVO.getStatus());
			System.out.println("questionDes="
					+ vvMeetingRoomMaintainDetailVO.getQuestionDes());
			System.out.println("revision="
					+ vvMeetingRoomMaintainDetailVO.getRevision());
			System.out.println("description="
					+ vvMeetingRoomMaintainDetailVO.getDescription());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
