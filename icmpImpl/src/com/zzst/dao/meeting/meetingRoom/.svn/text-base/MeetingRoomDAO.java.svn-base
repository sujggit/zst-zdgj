package com.zzst.dao.meeting.meetingRoom;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

/**
 * class description: MeetingRoom DAO
 * 
 * @author linsha
 * @date 2011-11-15
 */

public class MeetingRoomDAO {

	private static Logger logger = CbfLogger.getLogger(MeetingRoomDAO.class
			.getName());
	/**
	 * add MeetingRoomVO object
	 * 
	 * @param MeetingRoomVO
	 * @param TransactionManager
	 * @return MeetingRoomVO
	 * @throws Exception
	 */
	public static MeetingRoomVO add(MeetingRoomVO meetingRoomVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	add		begin");
		meetingRoomVO.setMeetingRoomID(UtilDAO.getUUid());
	//	meetingRoomVO.setRevision((int) CjfSequenceUtil.getNextRevision());
		MeetingRoomTO meetingRoomTO = new MeetingRoomTO(MeetingRoomTO.ADD_MEETINGROOM, meetingRoomVO);
		meetingRoomTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomTO, tManager);
		}
		logger.info("DAO	add		end");
		return meetingRoomVO;
	}


	/**
	 * query MeetingRoomVO list
	 * 
	 * @param MeetingRoomVO
	 * @param PageController
	 * @return ArrayList<MeetingRoomVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomVO> query(MeetingRoomVO meetingRoomVO,
			PageController pageController) throws Exception {
		logger.info("DAO	query	begin");
		 //////////////////////会议室分级分权@author:zhangjy/////////////////////////
		if(meetingRoomVO.isLevel()){
			if(!(meetingRoomVO.getLsql().equals(""))){
			meetingRoomVO.setLsql(" and meetingroomID in("+meetingRoomVO.getLsql()+") ");
			}else{
				meetingRoomVO.setLevel(false);
			}
		}
		//////////////////////////////end//////////////////////////////////////////
		MeetingRoomMQB meetingRoomMQB = new MeetingRoomMQB(MeetingRoomMQB.QUERY_FROM_MEETINGROOM, meetingRoomVO);
       
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMQB, pageController);
		logger.info("list size	:	"+ meetingRoomMQB.getListMeetingRoom().size());
		logger.info("DAO	query	end");
		return meetingRoomMQB.getListMeetingRoom();
	}

	/**
	 * query MeetingRoomVO list by IDs
	 * 
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingRoomVO>
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomVO> queryByIDs(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingRoomMQB meetingRoomMQB = new MeetingRoomMQB(
				MeetingRoomMQB.QUERY_FROM_MEETINGROOM_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMQB, pageController);
		logger.info("list size	:	"+ meetingRoomMQB.getListMeetingRoom().size());
		logger.info("DAO	queryByIDs	end");
		return meetingRoomMQB.getListMeetingRoom();
	}
	


	
	
	public static ArrayList<MeetingRoomVO> queryByID(String ids,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByID	begin");
		MeetingRoomMQB meetingRoomMQB = new MeetingRoomMQB(
				MeetingRoomMQB.QUERY_FROM_BY_IDS, ids);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMQB, pageController);
		logger.info("list size	:	"+ meetingRoomMQB.getListMeetingRoom().size());
		logger.info("DAO	queryByID	end");
		return meetingRoomMQB.getListMeetingRoom();
	}
	
	
	/**
	 * query MeetingRoomVO list by deptID
	 * auhor:tanzanlong 2012-12-10
	 * @param String
	 * @param PageController
	 * @return ArrayList<MeetingRoomVO>
	 * @throws Exception
	 */
	public static String  ishaveroomqueryByDeptID(DepartmentVO departmentVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryByIDs	begin");
		MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
		meetingRoomVO.setDepartmentVO(departmentVO);
		MeetingRoomMQB meetingRoomMQB = new MeetingRoomMQB(MeetingRoomMQB.QUERY_FROM_MEETINGROOM,meetingRoomVO);
		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMQB, pageController);
		logger.info("list size	:	"+ meetingRoomMQB.getListMeetingRoom().size());
		logger.info("DAO	queryByDeptID	end");
		ArrayList<MeetingRoomVO> list= meetingRoomMQB.getListMeetingRoom();
		if(list.size()<=0){
			return "yes";
		}else{
			return "no";
		}
		
	}
	
	
	/**
	 * modify MeetingRoomVO column by ID
	 * @param MeetingRoomVO
	 * @param TransactionManager
	 * @return MeetingRoomVO
	 * @throws Exception
	 */
	public static MeetingRoomVO modify(MeetingRoomVO meetingRoomVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
	//	meetingRoomVO.setRevision((int) CjfSequenceUtil.getNextRevision());
		MeetingRoomTO meetingRoomTO = new MeetingRoomTO(
				MeetingRoomTO.MODIFY_MEETINGROOM, meetingRoomVO);
		meetingRoomTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomTO, tManager);
		}
		logger.info("DAO	modify	end");
		return queryByID(meetingRoomVO.getMeetingRoomID(),null).get(0);
	}
	
	public static int modifystate(MeetingRoomVO meetingRoomVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	modify	begin");
	//	meetingRoomVO.setRevision((int) CjfSequenceUtil.getNextRevision());
		MeetingRoomTO meetingRoomTO = new MeetingRoomTO(
				MeetingRoomTO.MODIFY_STATE, meetingRoomVO);
		meetingRoomTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomTO, tManager);
		}
		logger.info("DAO	modify	end");
		return meetingRoomTO.getexecuteResult();
	}

	/**
	 * delete MeetingRoomVO by id
	 * 
	 * @param String
	 * @param TransactionManager
	 * @return MeetingRoomVO
	 * @throws Exception
	 */
	public static int deleteByID(String ids) throws Exception {
		logger.info("DAO	deleteByID	begin");
		MeetingRoomTO meetingRoomTO = new MeetingRoomTO(
				MeetingRoomTO.DEL_MEETINGROOM, ids);

		meetingRoomTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomTO.getSqlStr());
		TransactionTemplate.executeTransaction(meetingRoomTO, true);
		logger.info("result	:	" + meetingRoomTO.getexecuteResult());
		logger.info("DAO	deleteByID	end");
		return meetingRoomTO.getexecuteResult();
	}
	
	
	/**
	 * 修改会议室IP和端口，和号码
	 * @param meetingRoomVO
	 * @param tManager
	 * @return
	 * @throws Exception
	 * 
	 */
	public	static	int	modifyIpAndPort(MeetingRoomVO meetingRoomVO,TransactionManager tManager) throws Exception {
		logger.info("DAO	antoModifyIpAndPort		begin");
		MeetingRoomTO meetingRoomTO = new MeetingRoomTO(MeetingRoomTO.MODIFY_IP_PORT,meetingRoomVO);

		meetingRoomTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomTO.getSqlStr());
		TransactionTemplate.executeTransaction(meetingRoomTO, true);
		logger.info("result	:	" + meetingRoomTO.getexecuteResult());
		logger.info("DAO	autoModifyIpAndPort	end");
		return meetingRoomTO.getexecuteResult();	
		}
	
	/**
	 * calculate meeting room counts and total using time 
	 * @param meetingRoomVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<MeetingRoomVO> calculateMeetingRoom(MeetingRoomVO meetingRoomVO,
			PageController pageController) throws Exception {
		logger.info("DAO	calculateMeetingRoom	begin");
		MeetingRoomMQB meetingRoomMQB = new MeetingRoomMQB(
				MeetingRoomMQB.STATISTICS_FROM_MEETINGROOM, meetingRoomVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMQB, pageController);
		logger.info("list size	:	"+ meetingRoomMQB.getListMeetingRoom().size());
		logger.info("DAO	calculateMeetingRoom	end");
		return meetingRoomMQB.getListMeetingRoom();
	}
	
	/** 
	 * get empty meeting room list. 
	 * @param MeetingVO      存储开始时间、结束时间
	 * @param MeetingRoomVO  内id 存贮设备ID ;人数
	 * @param PageController
	 * @return ArrayList<MeetingRoomVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingRoomVO> getEmptyMeetingRoomList(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException {
		if(StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())){
			vMeetingDetailVO.setStatus(MeetingStatus.TO_BE_APPROVED + "," + MeetingStatus.APPROVED + "," + MeetingStatus.BE_ATTENDING + "," + MeetingStatus.APPLYING);
		}
			
		StringBuffer strsql = new StringBuffer();
		strsql.append("select distinct r.meetingroomID,r.meetingroomName,r.roomNO,r.meetingroomType,r.capacity ,r.planeImg,r.pictureImg,r.meetingroomUrl,r.status,r.description,r.revision from z_t_meetingroom r ");
		strsql.append(" where 1=1 ");
				
		if(vMeetingDetailVO!=null){
			if (vMeetingDetailVO.getMeetingStartTime() != null && vMeetingDetailVO.getMeetingEndTime() != null) {
				strsql.append(" and r.meetingroomID not in (select v.meetingroomID from z_t_meetingdetail_room v where v.meetingDetailID in (select distinct meetingDetailID from z_t_meetingdetail s" + 
						" where s.meetingDetailID != '" + vMeetingDetailVO.getMeetingDetailID() + 
						"' and s.status in (" + vMeetingDetailVO.getStatus() + ") " );
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and ((s.startTime <=" + UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime())  +
						" and s.endTime >" + UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime())+ ") or (s.startTime >=" +UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime())
						+" and s.startTime < " + UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime())+"))))");
				}else{
					strsql.append(" and ((s.startTime <= '" + vMeetingDetailVO.getMeetingStartTime() + "' " +
						" and s.endTime > '" + vMeetingDetailVO.getMeetingStartTime() + "') or (s.startTime >='" + vMeetingDetailVO.getMeetingStartTime()+
						"' and s.startTime < '" + vMeetingDetailVO.getMeetingEndTime()+"'))))");
				}
						
			}
		}
		strsql.append(" and r.status=0  order by r.roomNO desc");

		MeetingRoomMQB vMeetingRoomMQB = new MeetingRoomMQB(
				MeetingRoomMQB.AVAILABLE_FROM_MEETINGROOM);
		vMeetingRoomMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingRoomMQB, mPageController);

		return vMeetingRoomMQB.getListMeetingRoom();
	}
	
	/**
	 * 查询空闲会议室
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return
	 * @throws SQLException
	 * @author zhangjy
	 * @date 2013-12-06
	 * 
	 */
	public static ArrayList<MeetingRoomVO> getEmptyMeetingRoomListForWs(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException {
		if(StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())){
			vMeetingDetailVO.setStatus(MeetingStatus.TO_BE_APPROVED + "," + MeetingStatus.APPROVED + "," + MeetingStatus.BE_ATTENDING + "," + MeetingStatus.APPLYING);
		}
			
		StringBuffer strsql = new StringBuffer();
		strsql.append("select distinct r.meetingroomID,r.meetingroomName,r.meetingroomType,r.capacity,r.addressID,r.departmentID,r.adminID,z_t_department.name AS dname,z_t_address.name AS aname,z_t_user.fullName ");
		strsql.append(" from z_t_meetingroom r ");
		strsql.append(" INNER JOIN z_t_department ON r.departmentID = z_t_department.id ");
		strsql.append(" INNER JOIN z_t_address ON r.addressID = z_t_address.addressID ");
		strsql.append(" INNER JOIN z_t_user ON r.adminID = z_t_user.userID ");
		strsql.append(" where 1=1 ");
				
		if(vMeetingDetailVO!=null){
			if (vMeetingDetailVO.getMeetingStartTime() != null && vMeetingDetailVO.getMeetingEndTime() != null) {
				strsql.append(" and r.meetingroomID not in (select v.meetingroomID from z_t_meetingdetail_room v where v.meetingDetailID in (select distinct meetingDetailID from z_t_meetingdetail s" + 
						" where s.meetingDetailID != '" + vMeetingDetailVO.getMeetingDetailID() + 
						"' and s.status in (" + vMeetingDetailVO.getStatus() + ") " );
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and ((s.startTime <=" + UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime())  +
						" and s.endTime >" + UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime())+ ") or (s.startTime >=" +UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime())
						+" and s.startTime < " + UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime())+"))))");
				}else{
					strsql.append(" and ((s.startTime <= '" + vMeetingDetailVO.getMeetingStartTime() + "' " +
						" and s.endTime > '" + vMeetingDetailVO.getMeetingStartTime() + "') or (s.startTime >='" + vMeetingDetailVO.getMeetingStartTime()+
						"' and s.startTime < '" + vMeetingDetailVO.getMeetingEndTime()+"'))))");
				}
						
			}
		}
		strsql.append(" and r.status=0  order by r.roomNO desc");

		MeetingRoomMQB vMeetingRoomMQB = new MeetingRoomMQB(
				MeetingRoomMQB.QUERY_FROM_MEETLIST_WEBSERVCIE);
		vMeetingRoomMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());

		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingRoomMQB, mPageController);

		return vMeetingRoomMQB.getListMeetingRoom();
	}
	
	public static void main(String[] args) throws Exception{
		PageController pageController=new PageController();
		MeetingRoomDAO rd=new MeetingRoomDAO();
		DepartmentVO dv=new DepartmentVO();
		dv.setId("ff8080813b83362c013b836af588000b");
		//String str=rd.ishaveroomqueryByDeptID("ff8080813b83362c013b836af588000b", pageController);
	   // System.out.println("查找结果是"+str);
//		try {
//			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
//			Calendar c = Calendar.getInstance();
//			//vMeetingDetailVO.setMeetingDetailID("d0c0d89634216f750134216f75b10000");
//			vMeetingDetailVO.setStatus("1");
//			vMeetingDetailVO.setMeetingStartTime(new Timestamp(c.getTimeInMillis()));
//			c.add(Calendar.HOUR, 2);
//			vMeetingDetailVO.setMeetingEndTime(new Timestamp(c.getTimeInMillis()));
//			ArrayList list = getEmptyMeetingRoomList(vMeetingDetailVO,null);
//			System.out.println(list.size());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}


	public static ArrayList<MeetingRoomVO> validate(
			MeetingRoomVO meetingRoomVO, PageController pageController) throws Exception{
		logger.info("DAO	query	begin");
		MeetingRoomMQB meetingRoomMQB = new MeetingRoomMQB(
				MeetingRoomMQB.VALIDATE_FROM_MEETINGROOM, meetingRoomVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMQB, pageController);
		logger.info("list size	:	"+ meetingRoomMQB.getListMeetingRoom().size());
		logger.info("DAO	query	end");
		return meetingRoomMQB.getListMeetingRoom();
	}
	
	
	public static MeetingRoomVO updateByRoomNO(MeetingRoomVO meetingRoomVO,
			TransactionManager tManager) throws Exception {
		logger.info("DAO	updateByRoomNO	begin");
	//	meetingRoomVO.setRevision((int) CjfSequenceUtil.getNextRevision());
		MeetingRoomTO meetingRoomTO = new MeetingRoomTO(
				MeetingRoomTO.UPDATE_BY_ROOMNO, meetingRoomVO);
		meetingRoomTO.setSqlStr();
		logger.info("sqlStr	:	" + meetingRoomTO.getSqlStr());
		if (tManager == null) {
			TransactionTemplate.executeTransaction(meetingRoomTO, true);
		} else {
			TransactionTemplate.executeTransaction(meetingRoomTO, tManager);
		}
		logger.info("DAO	updateByRoomNO	end");
		return meetingRoomVO;
	}
	
	
	public static ArrayList<MeetingRoomVO> queryHaveTerminalMeetingRoom(MeetingRoomVO meetingRoomVO,
			PageController pageController) throws Exception {
		logger.info("DAO	queryHaveTerminalMeetingRoom	begin");
		MeetingRoomMQB meetingRoomMQB = new MeetingRoomMQB(
				MeetingRoomMQB.QUERY_FROM_MEETINGROOM_HAVE_TERMINAL, meetingRoomVO);

		if (pageController == null) {
			pageController = new PageController();
			pageController.setAll(true);
		}
		logger.info("sqlStr	:	" + meetingRoomMQB.getSql());
		QueryTemplate.executeQueryForList(meetingRoomMQB, pageController);
		logger.info("list size	:	"+ meetingRoomMQB.getListMeetingRoom().size());
		logger.info("DAO	queryHaveTerminalMeetingRoom	end");
		return meetingRoomMQB.getListMeetingRoom();
	}
	
}
