package com.zzst.dao.meeting.meetingService;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.cbfImpl.util.IntegerUtils;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;

/**
 * class description: MeetingService DAO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:10 CST 2009
 */

public class MeetingServiceDAO {

	private static Logger logger = CbfLogger.getLogger(MeetingServiceDAO.class
			.getName());

	/**
	 * 
	 * @param vMeetingServiceVO
	 * @param tManager
	 * @return vMeetingServiceVO
	 * @throws SQLException
	 */
	public static MeetingServiceVO addMeetingService(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException {
		MeetingServiceTO vMeetingServiceTO = new MeetingServiceTO(
				MeetingServiceTO.ADD_MEETINGSERVICE, vMeetingServiceVO);
		vMeetingServiceTO.setSqlStr();
		logger.info("add sql is :" + vMeetingServiceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingServiceTO, tManager);
		}

		return vMeetingServiceVO;
	}

	/**
	 * 
	 * @param vMeetingServiceVO
	 * @param mPageController
	 * @return ArrayList<MeetingServiceVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingServiceVO> getMeetingServiceList(
			MeetingServiceVO vMeetingServiceVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select meetingServiceID,meetingDetailID,serviceID,serviceType,equipmentID,modelName,equipmentNameCaption,serviceName,servicePrice,needNumber,totalMoney,description,revision,meetingRoomID ");
		strsql.append(" from T_MeetingService ");
		strsql.append(" where 1=1 ");
		if (null != vMeetingServiceVO) {

			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getMeetingServiceID())) {
				strsql.append(" and meetingServiceID="
						+ vMeetingServiceVO.getMeetingServiceID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID="
						+ vMeetingServiceVO.getMeetingDetailID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getServiceID())) {
				strsql.append(" and serviceID="
						+ vMeetingServiceVO.getServiceID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getServiceType())) {
				strsql.append(" and serviceType="
						+ vMeetingServiceVO.getServiceType());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getEquipmentID())) {
				strsql.append(" and equipmentID="
						+ vMeetingServiceVO.getEquipmentID());
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO.getModelName())) {
				strsql.append(" and modelName='"
						+ vMeetingServiceVO.getModelName() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO
					.getEquipmentNameCaption())) {
				strsql.append(" and equipmentNameCaption='"
						+ vMeetingServiceVO.getEquipmentNameCaption() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO.getServiceName())) {
				strsql.append(" and serviceName='"
						+ vMeetingServiceVO.getServiceName() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO.getDescription())) {
				strsql.append(" and description='"
						+ vMeetingServiceVO.getDescription() + "'");
			}
		}

		MeetingServiceMQB vMeetingServiceMQB = new MeetingServiceMQB(
				MeetingServiceMQB.QUERY_FROM_MEETINGSERVICE);
		vMeetingServiceMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingServiceMQB, mPageController);

		return vMeetingServiceMQB.getMeetingServiceList();
	}

	/**
	 * 
	 * @param vMeetingServiceVO
	 * @param mPageController
	 * @return ArrayList<MeetingServiceVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingServiceVO> getMeetingServiceListAllVO(
			MeetingServiceVO vMeetingServiceVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql
				.append("select s.meetingServiceID,s.meetingDetailID,s.serviceType,s.equipmentID,s.modelName,s.equipmentNameCaption,e.equipmentip,e.status ,s.description,s.revision,s.meetingRoomID,e.uplinkEquipmentID");
		strsql.append(" FROM t_meetingservice AS s Left Join t_equipment AS e ON  s.equipmentID=e.equipmentId");
		strsql.append(" where 1=1 ");
		if (null != vMeetingServiceVO) {
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getMeetingServiceID())) {
				strsql.append(" and meetingServiceID="
						+ vMeetingServiceVO.getMeetingServiceID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID="
						+ vMeetingServiceVO.getMeetingDetailID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getMeetingRoomID())) {
				strsql.append(" and s.meetingRoomID="
						+ vMeetingServiceVO.getMeetingRoomID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getServiceType())) {
				strsql.append(" and serviceType="
						+ vMeetingServiceVO.getServiceType());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingServiceVO
					.getEquipmentID())) {
				strsql.append(" and equipmentID="
						+ vMeetingServiceVO.getEquipmentID());
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO.getModelName())) {
				strsql.append(" and modelName='"
						+ vMeetingServiceVO.getModelName() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO
					.getEquipmentNameCaption())) {
				strsql.append(" and equipmentNameCaption='"
						+ vMeetingServiceVO.getEquipmentNameCaption() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO.getServiceName())) {
				strsql.append(" and serviceName='"
						+ vMeetingServiceVO.getServiceName() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingServiceVO.getDescription())) {
				strsql.append(" and description='"
						+ vMeetingServiceVO.getDescription() + "'");
			}
		}

		MeetingServiceMQB2 vMeetingServiceMQB2 = new MeetingServiceMQB2(
				MeetingServiceMQB.QUERY_FROM_MEETINGSERVICE);
		vMeetingServiceMQB2.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingServiceMQB2, mPageController);

		return vMeetingServiceMQB2.getMeetingServiceList();
	}
	
	/**
	 * 
	 * @param vMeetingServiceVO
	 * @param tManager
	 * @return MeetingServiceVO
	 * @throws SQLException
	 */
	public static MeetingServiceVO modifyMeetingService(
			MeetingServiceVO vMeetingServiceVO, TransactionManager tManager)
			throws SQLException {
		MeetingServiceTO vMeetingServiceTO = new MeetingServiceTO(
				MeetingServiceTO.MODIFY_MEETINGSERVICE, vMeetingServiceVO);
		vMeetingServiceTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingServiceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingServiceTO, tManager);
		}

		return vMeetingServiceVO;
	}

	/**
	 * 
	 * @param vMeetingServiceVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delMeetingService(MeetingServiceVO vMeetingServiceVO,
			TransactionManager tManager) throws SQLException {
		MeetingServiceTO vMeetingServiceTO = new MeetingServiceTO(
				MeetingServiceTO.DEL_MEETINGSERVICE, vMeetingServiceVO);
		vMeetingServiceTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingServiceTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingServiceTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingServiceTO, tManager);
		}
		return vMeetingServiceTO.getexecuteResult();
	}

}
