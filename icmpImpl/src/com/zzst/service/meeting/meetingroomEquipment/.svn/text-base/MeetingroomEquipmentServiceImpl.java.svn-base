package com.zzst.service.meeting.meetingroomEquipment;


import java.util.ArrayList;

import com.cbf.db.DBConnection;
import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.meetingroomEquipment.MeetingroomEquipmentDAO;
import com.zzst.model.meeting.meetingroomEquipment.MeetingroomEquipmentVO;

import org.apache.log4j.Logger;

/**
 * class description: MeetingroomEquipment ServiceImpl
 * 
 * @date Fri Jul 19 14:33:03 CST 2013
 * @author ryan
 */
public class MeetingroomEquipmentServiceImpl implements
		MeetingroomEquipmentService {
	private static Logger logger = CjfLogger
			.getLogger(MeetingroomEquipmentServiceImpl.class.getName());

	@Override
	public MeetingroomEquipmentVO add(
			MeetingroomEquipmentVO meetingroomEquipmentVO) throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingroomEquipmentVO = MeetingroomEquipmentDAO.add(
				meetingroomEquipmentVO, null);
		logger.info("serviceImpl	add	end");
		return meetingroomEquipmentVO;
	}

	@Override
	public ArrayList<MeetingroomEquipmentVO> query(
			MeetingroomEquipmentVO meetingroomEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingroomEquipmentVO> listMeetingroomEquipment = MeetingroomEquipmentDAO
				.query(meetingroomEquipmentVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingroomEquipment;
	}

	@Override
	public MeetingroomEquipmentVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingroomEquipmentVO> listMeetingroomEquipment = MeetingroomEquipmentDAO
				.queryByIDs(id, null);
		if (listMeetingroomEquipment != null
				&& listMeetingroomEquipment.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingroomEquipment.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingroomEquipmentVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingroomEquipmentVO> listMeetingroomEquipment = MeetingroomEquipmentDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingroomEquipment;
	}

	@Override
	public MeetingroomEquipmentVO modify(
			MeetingroomEquipmentVO meetingroomEquipmentVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingroomEquipmentVO = MeetingroomEquipmentDAO.modify(
				meetingroomEquipmentVO, null);
		logger.info("serviceImpl	modify	end");
		return meetingroomEquipmentVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MeetingroomEquipmentDAO.deleteByID(id, null);
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

	public static void main(String args[]) throws Exception {
		// DBConnection.setDbInfo("jdbc:oracle:thin:@10.1.3.182:1521:cinda",
		// "cinda", "cinda");
		DBConnection.setDbInfo(
				"jdbc:mysql://10.1.0.10:3306/icmp?characterEncoding=gb2312",
				"test", "123456");
		MeetingroomEquipmentVO vMeetingroomEquipmentVO = new MeetingroomEquipmentVO();
		vMeetingroomEquipmentVO.setRoomId("roomId");
		vMeetingroomEquipmentVO.setEquipmentId("equipmentId");
		vMeetingroomEquipmentVO.setDescription("description");
		vMeetingroomEquipmentVO.setRevision(new Long(888));

		new MeetingroomEquipmentServiceImpl().add(vMeetingroomEquipmentVO);
		System.out.println("=========add Success!");

		ArrayList<MeetingroomEquipmentVO> lstMeetingroomEquipment = new MeetingroomEquipmentServiceImpl()
				.query(vMeetingroomEquipmentVO, null);

		if (lstMeetingroomEquipment.size() > 0) {
			System.out.println("=========query Result:");
			MeetingroomEquipmentVO vvMeetingroomEquipmentVO = (MeetingroomEquipmentVO) lstMeetingroomEquipment
					.get(0);
			System.out
					.println("roomId=" + vvMeetingroomEquipmentVO.getRoomId());
			System.out.println("equipmentId="
					+ vvMeetingroomEquipmentVO.getEquipmentId());
			System.out.println("description="
					+ vvMeetingroomEquipmentVO.getDescription());
			System.out.println("revision="
					+ vvMeetingroomEquipmentVO.getRevision());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
