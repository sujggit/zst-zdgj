package com.zzst.service.meeting.meetingDetailUser;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.meetingDetailUser.MeetingDetailUserDAO;
import com.zzst.model.enums.MeetingParticipatEnum;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;

/**
 * class description: MeetingDetailUser Impl
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailUserServiceImpl implements MeetingDetailUserService {

	private static Logger logger = CbfLogger
			.getLogger(MeetingDetailUserServiceImpl.class.getName());

	/**
	 * method description : addMeetingDetailUser
	 * 
	 * @param MeetingDetailUserVO
	 * @return MeetingDetailUserVO
	 * @throws SQLException
	 */
	public MeetingDetailUserVO addMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
			vMeetingDetailUserVO.setStatus(MeetingParticipatEnum.WORK_FALSE);
			vMeetingDetailUserVO.setAppraisalID("-1");
		return MeetingDetailUserDAO.addMeetingDetailUser(vMeetingDetailUserVO,
				tManager);
	}

	/**
	 * method description : getMeetingDetailUserList
	 * 
	 * @param MeetingDetailUserVO
	 * @return ArrayList<MeetingDetailUserVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingDetailUserVO> getMeetingDetailUserList(
			MeetingDetailUserVO vMeetingDetailUserVO,
			PageController mPageController) throws SQLException {
		return MeetingDetailUserDAO.getMeetingDetailUserList(
				vMeetingDetailUserVO, mPageController);
	}

	/**
	 * method description : delMeetingDetailUser
	 * 
	 * @param MeetingDetailUserVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == MeetingDetailUserDAO.delMeetingDetailUserByDetailId(
				vMeetingDetailUserVO, tManager)) {
			re = true;
		}
		return re;
	}
	
	public boolean delMeetingDetailUserByDetailId(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == MeetingDetailUserDAO.delMeetingDetailUserByDetailId(
				vMeetingDetailUserVO, tManager)) {
			re = true;
		}
		return re;
	}
	
	/**
	 * method description : modify MeetingDetailUser state by id
	 * 
	 * @param MeetingDetailUserVO
	 * @return MeetingDetailUserVO
	 * @throws SQLException
	 */
	public MeetingDetailUserVO delMeetingDetailUserForState(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		return modifyMeetingDetailUser(vMeetingDetailUserVO, tManager);
	}

	/**
	 * method description : modify MeetingDetailUser all columns by id
	 * 
	 * @param MeetingDetailUserVO
	 * @return MeetingDetailUserVO
	 * @throws SQLException
	 */
	public MeetingDetailUserVO modifyMeetingDetailUser(
			MeetingDetailUserVO vMeetingDetailUserVO,
			TransactionManager tManager) throws SQLException {
		return MeetingDetailUserDAO.modifyMeetingDetailUser(
				vMeetingDetailUserVO, tManager);
	}


}
