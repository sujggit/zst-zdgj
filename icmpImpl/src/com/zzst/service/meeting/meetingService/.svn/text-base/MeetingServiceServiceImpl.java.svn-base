package com.zzst.service.meeting.meetingService;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.dao.meeting.meetingService.MeetingServiceDAO;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;

/**
 * class description: MeetingService Impl
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:10 CST 2009
 */

public class MeetingServiceServiceImpl implements MeetingServiceService {

	private static Logger logger = CbfLogger
			.getLogger(MeetingServiceServiceImpl.class.getName());

	/**
	 * method description : addMeetingService
	 * 
	 * @param MeetingServiceVO
	 * @return MeetingServiceVO
	 * @throws SQLException
	 */
	public MeetingServiceVO addMeetingService(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException {
		return MeetingServiceDAO.addMeetingService(vMeetingServiceVO, tManager);
	}

	/**
	 * method description : getMeetingServiceList
	 * 
	 * @param MeetingServiceVO
	 * @return ArrayList<MeetingServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingServiceVO> getMeetingServiceList(
			MeetingServiceVO vMeetingServiceVO, PageController mPageController)
			throws SQLException {
		return MeetingServiceDAO.getMeetingServiceList(vMeetingServiceVO,
				mPageController);
	}
	/**
	 * 
	 * @param vMeetingServiceVO
	 * @param mPageController
	 * @return ArrayList<MeetingServiceVO>
	 * @throws SQLException
	 */
	public ArrayList<MeetingServiceVO> getMeetingServiceListAllVO(
			MeetingServiceVO vMeetingServiceVO, PageController mPageController)
			throws SQLException {
		return MeetingServiceDAO.getMeetingServiceListAllVO(vMeetingServiceVO,
				mPageController);
	}
	/**
	 * method description : delMeetingService
	 * 
	 * @param MeetingServiceVO
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean delMeetingService(MeetingServiceVO vMeetingServiceVO,
			TransactionManager tManager) throws SQLException {
		boolean re = false;
		if (1 == MeetingServiceDAO.delMeetingService(vMeetingServiceVO,
				tManager)) {
			re = true;
		}
		return re;
	}

	/**
	 * method description : modify MeetingService state by id
	 * 
	 * @param MeetingServiceVO
	 * @return MeetingServiceVO
	 * @throws SQLException
	 */
	public MeetingServiceVO delMeetingServiceForState(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException {
		return modifyMeetingService(vMeetingServiceVO, tManager);
	}

	/**
	 * method description : modify MeetingService all columns by id
	 * 
	 * @param MeetingServiceVO
	 * @return MeetingServiceVO
	 * @throws SQLException
	 */
	public MeetingServiceVO modifyMeetingService(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException {
		return MeetingServiceDAO.modifyMeetingService(vMeetingServiceVO,
				tManager);
	}

	public static void main(String args[]) throws SQLException {
		MeetingServiceVO vMeetingServiceVO = new MeetingServiceVO();
		vMeetingServiceVO.setMeetingServiceID(1);
		vMeetingServiceVO.setMeetingDetailID(1);
		vMeetingServiceVO.setServiceID(1);
		vMeetingServiceVO.setServiceType(1);
		vMeetingServiceVO.setEquipmentID(1);
		vMeetingServiceVO.setModelName("modelName");
		vMeetingServiceVO.setEquipmentNameCaption("equipmentNameCaption");
		vMeetingServiceVO.setServiceName("serviceName");
		vMeetingServiceVO.setDescription("description");
		vMeetingServiceVO.setRevision(new Long(1));

		new MeetingServiceServiceImpl().addMeetingService(vMeetingServiceVO,
				null);
		System.out.println("=========add Success!");

		ArrayList<MeetingServiceVO> lstMeetingService = new MeetingServiceServiceImpl()
				.getMeetingServiceList(vMeetingServiceVO, null);

		if (lstMeetingService.size() > 0) {
			System.out.println("=========query Result:");
			MeetingServiceVO vvMeetingServiceVO = (MeetingServiceVO) lstMeetingService
					.get(0);
			System.out.println("meetingServiceID="
					+ vvMeetingServiceVO.getMeetingServiceID());
			System.out.println("meetingDetailID="
					+ vvMeetingServiceVO.getMeetingDetailID());
			System.out
					.println("serviceID=" + vvMeetingServiceVO.getServiceID());
			System.out.println("serviceType="
					+ vvMeetingServiceVO.getServiceType());
			System.out.println("equipmentID="
					+ vvMeetingServiceVO.getEquipmentID());
			System.out
					.println("modelName=" + vvMeetingServiceVO.getModelName());
			System.out.println("equipmentNameCaption="
					+ vvMeetingServiceVO.getEquipmentNameCaption());
			System.out.println("serviceName="
					+ vvMeetingServiceVO.getServiceName());
			System.out.println("servicePrice="
					+ vvMeetingServiceVO.getServicePrice());
			System.out.println("needNumber="
					+ vvMeetingServiceVO.getNeedNumber());
			System.out.println("totalMoney="
					+ vvMeetingServiceVO.getTotalMoney());
			System.out.println("description="
					+ vvMeetingServiceVO.getDescription());
			System.out.println("revision=" + vvMeetingServiceVO.getRevision());

		} else {
			System.out
					.println("=========query Result  is  null   !!!!!!!!!!!!!!!!!!!!!!");
		}

	}

}
