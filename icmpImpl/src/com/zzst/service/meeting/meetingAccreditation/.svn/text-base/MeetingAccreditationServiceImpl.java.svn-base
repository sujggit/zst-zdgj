package com.zzst.service.meeting.meetingAccreditation;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.meetingAccreditation.MeetingAccreditationDAO;
import com.zzst.model.meeting.meetingAccreditation.MeetingAccreditationVO;

/**
 * class description: MeetingAccreditation Impl
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingAccreditationServiceImpl implements
		MeetingAccreditationService {

	private static Logger logger = CbfLogger
			.getLogger(MeetingAccreditationServiceImpl.class.getName());

	/**
	 * method description : addMeetingAccreditation
	 * 
	 * @param MeetingAccreditationVO
	 * @return MeetingAccreditationVO
	 * @throws SQLException
	 */
	public MeetingAccreditationVO addMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException {
		return MeetingAccreditationDAO.addMeetingAccreditation(
				vMeetingAccreditationVO, tManager);
	}

	/**
	 * method description : getMeetingAccreditationList
	 * 
	 * @param MeetingAccreditationVO
	 * @return ArrayList<MeetingAccreditationVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingAccreditationVO> getMeetingAccreditationList(
			MeetingAccreditationVO vMeetingAccreditationVO,
			PageController mPageController) throws SQLException {
		return MeetingAccreditationDAO.getMeetingAccreditationList(
				vMeetingAccreditationVO, mPageController);
	}

	/**
	 * method description : delMeetingAccreditation
	 * 
	 * @param MeetingAccreditationVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == MeetingAccreditationDAO.delMeetingAccreditation(
				vMeetingAccreditationVO, tManager)) {
			re = true;
		}
		return re;
	}

	/**
	 * method description : modify MeetingAccreditation state by id
	 * 
	 * @param MeetingAccreditationVO
	 * @return MeetingAccreditationVO
	 * @throws SQLException
	 */
	public MeetingAccreditationVO delMeetingAccreditationForState(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException {
		return modifyMeetingAccreditation(vMeetingAccreditationVO, tManager);
	}

	/**
	 * method description : modify MeetingAccreditation all columns by id
	 * 
	 * @param MeetingAccreditationVO
	 * @return MeetingAccreditationVO
	 * @throws SQLException
	 */
	public MeetingAccreditationVO modifyMeetingAccreditation(
			MeetingAccreditationVO vMeetingAccreditationVO,
			TransactionManager tManager) throws SQLException {
		return MeetingAccreditationDAO.modifyMeetingAccreditation(
				vMeetingAccreditationVO, tManager);
	}

	public static void main(String args[]) throws SQLException {
		MeetingAccreditationVO vMeetingAccreditationVO = new MeetingAccreditationVO();
		vMeetingAccreditationVO.setMeetingAccreditationID(1);
		vMeetingAccreditationVO.setMeetingDetailID(1);
		vMeetingAccreditationVO.setUserFromID(1);
		vMeetingAccreditationVO.setUserFromName("userFromName");
		vMeetingAccreditationVO.setUserToID(1);
		vMeetingAccreditationVO.setUserToName("userToName");
		vMeetingAccreditationVO.setDescription("description");
		vMeetingAccreditationVO.setRevision(new Long(1));

		new MeetingAccreditationServiceImpl().addMeetingAccreditation(
				vMeetingAccreditationVO, null);
		System.out.println("=========add Success!");

		ArrayList<MeetingAccreditationVO> lstMeetingAccreditation = new MeetingAccreditationServiceImpl()
				.getMeetingAccreditationList(vMeetingAccreditationVO, null);

		if (lstMeetingAccreditation.size() > 0) {
			System.out.println("=========query Result:");
			MeetingAccreditationVO vvMeetingAccreditationVO = (MeetingAccreditationVO) lstMeetingAccreditation
					.get(0);
			System.out.println("meetingAccreditationID="
					+ vvMeetingAccreditationVO.getMeetingAccreditationID());
			System.out.println("meetingDetailID="
					+ vvMeetingAccreditationVO.getMeetingDetailID());
			System.out.println("userFromID="
					+ vvMeetingAccreditationVO.getUserFromID());
			System.out.println("userFromName="
					+ vvMeetingAccreditationVO.getUserFromName());
			System.out.println("userToID="
					+ vvMeetingAccreditationVO.getUserToID());
			System.out.println("userToName="
					+ vvMeetingAccreditationVO.getUserToName());
			System.out.println("description="
					+ vvMeetingAccreditationVO.getDescription());
			System.out.println("revision="
					+ vvMeetingAccreditationVO.getRevision());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
