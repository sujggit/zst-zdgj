package com.zzst.dao.meeting.meetingDetailRoom;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;

/**
 *  
 * @author zhangjy
 * @date 2014-01-14
 */
public class MeetingDetailRoomDAO {

	private static Logger logger = CbfLogger
			.getLogger(MeetingDetailRoomDAO.class.getName());

	/**
	 * 
	 * @param vMeetingDetailRoomVO
	 * @param tManager
	 * @return vMeetingDetailRoomVO
	 * @throws SQLException
	 */
	public static MeetingDetailRoomVO addMeetingDetailRoom(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailRoomTO vMeetingDetailRoomTO = new MeetingDetailRoomTO(
				MeetingDetailRoomTO.ADD_MEETINGDETAILRoom, vMeetingDetailRoomVO);
		vMeetingDetailRoomTO.setSqlStr();
		logger.info("add sql is :" + vMeetingDetailRoomTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO,
					tManager);
		}

		return vMeetingDetailRoomVO;
	}

	/**
	 * 
	 * @param vMeetingDetailRoomVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailRoomVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailRoomVO> getMeetingDetailRoomList(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();

		strsql.append("SELECT zmdr.meetingroomID,zmdr.meetingDetailID,zmd.meetingName,zmr.meetingroomName,zmdr.speed,zmdr.ismain,");
		strsql.append("zmdr.description,zmdr.revision,zmdr.rank,zmdr.manNum,zmdr.info1,zmdr.info3,zmdr.info2,zmdr.info4,zmdr.info5 ");
		strsql.append("from z_t_meetingdetail_room AS zmdr ");
		strsql.append("INNER JOIN z_t_meetingroom AS zmr ON zmdr.meetingroomID = zmr.meetingroomID ");
		strsql.append("INNER JOIN z_t_meetingdetail AS zmd ON zmd.meetingDetailID = zmdr.meetingDetailID ");
		strsql.append("where 1=1  ");
		
		if (null != vMeetingDetailRoomVO) {
			if (!StringUtils.isNullOrBlank(vMeetingDetailRoomVO.getMeetingDetailId())) {
				strsql.append(" and zmdr.meetingDetailID='" + vMeetingDetailRoomVO.getMeetingDetailId() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailRoomVO.getMeetingRoomId())) {
				strsql.append(" and zmdr.meetingroomID='" + vMeetingDetailRoomVO.getMeetingRoomId() + "'");
			}
			
		}
		

		MeetingDetailRoomMQB vMeetingDetailRoomMQB = new MeetingDetailRoomMQB(MeetingDetailRoomMQB.QUERY_FROM_MEETINGDETAILRoom);
		vMeetingDetailRoomMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailRoomMQB, mPageController);
		return vMeetingDetailRoomMQB.getMeetingDetailRoomList();
	}

	/**
	 * 
	 * @param vMeetingDetailRoomVO
	 * @param tManager
	 * @return MeetingDetailRoomVO
	 * @throws SQLException
	 */
	public static MeetingDetailRoomVO modifyMeetingDetailRoom(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailRoomTO vMeetingDetailRoomTO = new MeetingDetailRoomTO(MeetingDetailRoomTO.MODIFY_MEETINGDETAILRoom,vMeetingDetailRoomVO);
		vMeetingDetailRoomTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingDetailRoomTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO,
					tManager);
		}

		return vMeetingDetailRoomVO;
	}

	/**
	 * 
	 * @param vMeetingDetailRoomVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delMeetingDetailRoom(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailRoomTO vMeetingDetailRoomTO = new MeetingDetailRoomTO(
				MeetingDetailRoomTO.DEL_MEETINGDETAILRoom, vMeetingDetailRoomVO);
		vMeetingDetailRoomTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingDetailRoomTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO,
					tManager);
		}
		return vMeetingDetailRoomTO.getexecuteResult();
	}
	
	public static int delMeetingDetailRoomByDetailId(
			MeetingDetailRoomVO vMeetingDetailRoomVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailRoomTO vMeetingDetailRoomTO = new MeetingDetailRoomTO(
				MeetingDetailRoomTO.DEL_ALLMEETINGDETAILRoomS, vMeetingDetailRoomVO);
		vMeetingDetailRoomTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingDetailRoomTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailRoomTO,
					tManager);
		}
		return vMeetingDetailRoomTO.getexecuteResult();
	}

}
