package com.zzst.service.meeting.cost;

import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.meeting.cost.MeetingDetailCostDAO;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;

import org.apache.log4j.Logger;

/**
 * class description: MeetingDetailCost ServiceImpl
 * 
 * @date Fri May 17 15:30:40 CST 2013
 * @author ryan
 */
public class MeetingDetailCostServiceImpl implements MeetingDetailCostService {
	private static Logger logger = CjfLogger
			.getLogger(MeetingDetailCostServiceImpl.class.getName());

	@Override
	public MeetingDetailCostVO add(MeetingDetailCostVO meetingDetailCostVO)
			throws Exception {
		logger.info("serviceImpl	add	begin");
		meetingDetailCostVO = MeetingDetailCostDAO.add(meetingDetailCostVO,
				null);
		logger.info("serviceImpl	add	end");
		return meetingDetailCostVO;
	}

	@Override
	public ArrayList<MeetingDetailCostVO> query(
			MeetingDetailCostVO meetingDetailCostVO,
			PageController pageController) throws Exception {
		logger.info("serviceImpl	query	begin");
		ArrayList<MeetingDetailCostVO> listMeetingDetailCost = MeetingDetailCostDAO
				.query(meetingDetailCostVO, pageController);
		logger.info("serviceImpl	query	end");
		return listMeetingDetailCost;
	}

	@Override
	public MeetingDetailCostVO queryByID(String id) throws Exception {
		logger.info("serviceImpl	queryByID	begin");
		ArrayList<MeetingDetailCostVO> listMeetingDetailCost = MeetingDetailCostDAO
				.queryByIDs(id, null);
		if (listMeetingDetailCost != null && listMeetingDetailCost.size() == 1) {
			logger.info("serviceImpl	end");
			return listMeetingDetailCost.get(0);
		}
		logger.info("serviceImpl	queryByID	end");
		return null;
	}

	@Override
	public ArrayList<MeetingDetailCostVO> queryByIDs(String ids)
			throws Exception {
		logger.info("serviceImpl	queryByIDs	begin");
		ArrayList<MeetingDetailCostVO> listMeetingDetailCost = MeetingDetailCostDAO
				.queryByIDs(ids, null);
		logger.info("serviceImpl	queryByIDs	end");
		return listMeetingDetailCost;
	}

	@Override
	public MeetingDetailCostVO modify(MeetingDetailCostVO meetingDetailCostVO)
			throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingDetailCostVO = MeetingDetailCostDAO.modify(meetingDetailCostVO,
				null);
		logger.info("serviceImpl	modify	end");
		return meetingDetailCostVO;
	}

	@Override
	public boolean deleteByID(String id) throws Exception {
		logger.info("serviceImpl	deleteByID	begin");
		int num = MeetingDetailCostDAO.deleteByID(id, null);
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
	public List<MeetingDetailCostVO> queryMeetingDetail(
			MeetingDetailCostVO meetingDetailCostVO, PageController pControler)
			throws Exception {
		logger.info("serviceImpl	queryMeetingDetail	begin");
		ArrayList<MeetingDetailCostVO> listMeetingDetailCost = MeetingDetailCostDAO
				.queryMeetingDetail(meetingDetailCostVO, pControler);
		logger.info("serviceImpl	queryMeetingDetail	end");
		return listMeetingDetailCost;
	}

	@Override
	public MeetingDetailCostVO modifyCout(
			MeetingDetailCostVO meetingDetailCostVO) throws Exception {
		logger.info("serviceImpl	modify	begin");
		meetingDetailCostVO = MeetingDetailCostDAO.modifyCout(meetingDetailCostVO,
				null);
		logger.info("serviceImpl	modify	end");
		return meetingDetailCostVO;
	}

}
