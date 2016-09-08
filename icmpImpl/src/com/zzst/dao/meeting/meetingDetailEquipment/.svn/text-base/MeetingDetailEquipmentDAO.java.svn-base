package com.zzst.dao.meeting.meetingDetailEquipment;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;

/**
 * class description: MeetingDetailEquipment DAO
 * 
 * @date Thu May 08 17:42:44 CST 2014
 * @author ryan
 */
public class MeetingDetailEquipmentDAO {
	private static Logger logger = CjfLogger
			.getLogger(MeetingDetailEquipmentDAO.class.getName());

	/**
	 * 查询在时间段内使用的设备
	 * @param meetingDetailEquipmentVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailEquipmentVO> queryUseEquipment(
			Timestamp startTime,Timestamp endTime,PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
		MeetingDetailEquipmentMQB meetingDetailEquipmentMQB = new MeetingDetailEquipmentMQB(
				MeetingDetailEquipmentMQB.QUERY_FROM_MEETINGDETAILEQUIPMENT,
				meetingDetailEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("SELECT me.id,me.equipmentID,me.meetingDetailID,me.equipmentType,me.equipmentNo,me.equipmentIP,me.equipmentNumber,me.equipmentTel,me.audioAgreementType,me.speed,me.count,me.roomID,me.cascadeID,me.createUserID,me.createDate,me.`status`,me.description,me.videoAgreementType,me.agc,me.cascadeRole,me.maxPesolution,me.aliasType,me.aliasName,me.dialingDirection,me.dialingType,me.confProfileID,me.mainEquipment ");
		sqlStr.append("FROM z_t_meetingdetail_equipment AS me ");
		sqlStr.append("WHERE me.meetingDetailID IN ( ");
		sqlStr.append("SELECT mdetail.meetingDetailID ");
		sqlStr.append("FROM z_t_meetingdetail as mdetail ");
		sqlStr.append("WHERE  (mdetail.status='"+MeetingDetailEnum.STATUS_APPROVED+"' OR mdetail.status='"+MeetingDetailEnum.STATUS_ING+"' OR mdetail.status='"+MeetingDetailEnum.STATUS_APPROVED_PASS+"') ");
		sqlStr.append(" and ((mdetail.startTime BETWEEN '"+startTime+"' AND '"+endTime+"') OR (mdetail.endTime BETWEEN '"+startTime+"' AND '"+endTime+"') OR ");
		sqlStr.append(" (mdetail.startTime <= '"+startTime+"' AND '"+endTime+"' <= mdetail.endTime )) ");
		sqlStr.append(")");
		sqlStr.append("and me.status ="+MeetingDetailEquipmentVO.VALID);
		
		meetingDetailEquipmentMQB.setSql(sqlStr.toString());
		logger.info("sqlStr	:	" + meetingDetailEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingDetailEquipmentMQB.getMeetingDetailEquipmentList()
						.size());
		logger.info("DAO	query	end");
		return meetingDetailEquipmentMQB.getMeetingDetailEquipmentList();
	}
	
	/**
	 * add MeetingDetailEquipmentVO object
	 * 
	 * @param MeetingDetailEquipmentVO
	 * @param TransactionManager
	 * @return MeetingDetailEquipmentVO
	 * @throws Exception
	 */
	public static MeetingDetailEquipmentVO add(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add	begin");
		meetingDetailEquipmentVO.setId(UtilDAO.getUUid());
		MeetingDetailEquipmentTO meetingDetailEquipmentTO = new MeetingDetailEquipmentTO(
				MeetingDetailEquipmentTO.ADD_MEETINGDETAILEQUIPMENT,
				meetingDetailEquipmentVO);

		meetingDetailEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailEquipmentTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailEquipmentTO,
					tManager);
		}
		logger.info("DAO	add	end");
		return meetingDetailEquipmentVO;
	}

	/**
	 * modify MeetingDetailEquipmentVO column by ID
	 * 
	 * @param MeetingDetailEquipmentVO
	 * @param TransactionManager
	 * @return MeetingDetailEquipmentVO
	 * @throws Exception
	 */
	public static MeetingDetailEquipmentVO modify(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
		MeetingDetailEquipmentTO meetingDetailEquipmentTO = new MeetingDetailEquipmentTO(
				MeetingDetailEquipmentTO.MODIFY_MEETINGDETAILEQUIPMENT,
				meetingDetailEquipmentVO);
		meetingDetailEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailEquipmentTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailEquipmentTO,
					tManager);
		}
		logger.info("DAO	modify	end");
		return meetingDetailEquipmentVO;
	}

	/**
	 * query MeetingDetailEquipmentVO list 注意：
	 * 查询当前表状态不为失效的数据，如果包含关联查询不过滤其状态。如：关联用户信息，不管用户是否正常都需要查询出该数据。 需要把关联信息的状态带到前台
	 * 
	 * @param MeetingDetailEquipmentVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailEquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailEquipmentVO> query(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		MeetingDetailEquipmentMQB meetingDetailEquipmentMQB = new MeetingDetailEquipmentMQB(
				MeetingDetailEquipmentMQB.QUERY_FROM_MEETINGDETAILEQUIPMENT,
				meetingDetailEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingDetailEquipmentMQB.getMeetingDetailEquipmentList()
						.size());
		logger.info("DAO	query	end");
		return meetingDetailEquipmentMQB.getMeetingDetailEquipmentList();
	}

	/**
	 * query MeetingDetailEquipmentVO list by IDs 查询多个id时，id格式为：a,b,c,d
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingDetailEquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailEquipmentVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
		meetingDetailEquipmentVO.setId(ids);
		MeetingDetailEquipmentMQB meetingDetailEquipmentMQB = new MeetingDetailEquipmentMQB(
				MeetingDetailEquipmentMQB.QUERY_FROM_MEETINGDETAILEQUIPMENT_BY_IDS,
				meetingDetailEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingDetailEquipmentMQB.getMeetingDetailEquipmentList()
						.size());
		logger.info("DAO	queryByIDs	end");
		return meetingDetailEquipmentMQB.getMeetingDetailEquipmentList();
	}

	/**
	 * delete MeetingDetailEquipmentVO by ids 多个id时，id格式为：a,b,c,d
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingDetailEquipmentVO
	 * @throws Exception
	 */
	public static int deleteByIDs(String ids, TransactionManager tManager)
			throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
		meetingDetailEquipmentVO.setId(ids);
		MeetingDetailEquipmentTO meetingDetailEquipmentTO = new MeetingDetailEquipmentTO(
				MeetingDetailEquipmentTO.DEL_MEETINGDETAILEQUIPMENT,
				meetingDetailEquipmentVO);

		meetingDetailEquipmentTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingDetailEquipmentTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingDetailEquipmentTO,
					true);
		} else {
			TransactionTemplate.executeTransaction(meetingDetailEquipmentTO,
					tManager);
		}
		logger.info("result	:	" + meetingDetailEquipmentTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingDetailEquipmentTO.getexecuteResult();
	}

	/**
	 * query MeetingDetailEquipmentVO list 模糊查询
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingDetailEquipmentVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingDetailEquipmentVO> queryFuzzySearch(
			String str, PageController pageController) throws Exception {
		logger.info("DAO	queryFuzzySearch	begin");
		MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
		meetingDetailEquipmentVO.setId(str);
		MeetingDetailEquipmentMQB meetingDetailEquipmentMQB = new MeetingDetailEquipmentMQB(
				MeetingDetailEquipmentMQB.QUERY_FROM_MEETINGDETAILEQUIPMENT_BY_FUZZYSEARCH,
				meetingDetailEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingDetailEquipmentMQB.getMeetingDetailEquipmentList()
						.size());
		logger.info("DAO	queryFuzzySearch	end");
		return meetingDetailEquipmentMQB.getMeetingDetailEquipmentList();
	}
	
	public static ArrayList<MeetingDetailEquipmentVO> queryMeeting(
			MeetingDetailEquipmentVO meetingDetailEquipmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryMeeting	begin");
		MeetingDetailEquipmentMQB meetingDetailEquipmentMQB = new MeetingDetailEquipmentMQB(
				MeetingDetailEquipmentMQB.QUERY_FROM_MEETINGDETAILEQUIPMENT_NEW,
				meetingDetailEquipmentVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingDetailEquipmentMQB.getSql());
		QueryTemplate.executeQueryForList(meetingDetailEquipmentMQB,
				pageController);
		logger.info("list size	:	"
				+ meetingDetailEquipmentMQB.getMeetingDetailEquipmentList()
						.size());
		logger.info("DAO	queryMeeting	end");
		return meetingDetailEquipmentMQB.getMeetingDetailEquipmentList();
	}
	
}
