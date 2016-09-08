package com.zzst.dao.meeting.meetingDetail;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.PageController;
import com.cbf.db.QueryTemplate;
import com.cbf.db.TransactionManager;
import com.cbf.db.TransactionTemplate;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.cbfImpl.util.IntegerUtils;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.cbfImpl.util.TimeFormatUtil;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.enums.MeetingTypeEnum;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: MeetingDetail DAO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailDAO {

	private static Logger logger = CbfLogger.getLogger(MeetingDetailDAO.class
			.getName());
	/**
	 * 根据开始结束时间查询会议信息
	 * @param meetingStartTime
	 * @param meetingEndTime
	 * @return
	 */
	public static ArrayList<MeetingDetailVO> queryNextWeekMeeting(Timestamp meetingStartTime,
			Timestamp meetingEndTime) throws SQLException{
		String sql = "SELECT m.meetingDetailID,m.meetingName,m.startTime,m.endTime,r.meetingroomName" +
				" FROM z_t_meetingdetail m,z_t_meetingdetail_room mr,z_t_meetingroom r " +
				"WHERE m.meetingDetailID=mr.meetingDetailID AND r.meetingroomID=mr.meetingroomID AND m.startTime > '"+meetingStartTime+"' AND m.endTime < '"+meetingEndTime+"' AND m.`status`!=11";
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_WEEK);
		vMeetingDetailMQB.setSql(sql);
		logger.info("query sql is :" + sql);
		PageController mPageController = null;
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}
		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		return vMeetingDetailMQB.getMeetingDetailList();
	}
	/**
	 * 根据会议名称开始结束时间来取会议id
	 * @param vMeetingDetailVO
	 * @return
	 * @throws SQLException 
	 */
	public static String queryMeetingDetailID(MeetingDetailVO vMeetingDetailVO){
		String name = vMeetingDetailVO.getMeetingName();
		String stime = vMeetingDetailVO.getMeetingStartTime().toString();
		String etime = vMeetingDetailVO.getMeetingEndTime().toString();
		String sql = "SELECT meetingDetailID FROM z_t_meetingdetail " +
				"WHERE meetingName = '"+name+"' AND startTime = '"+stime+"' AND endTime = '"+etime+"' AND status != 11";
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_MID);
		vMeetingDetailMQB.setSql(sql);
		logger.info("query sql is :" + sql);
		PageController mPageController = null;
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		try {
			QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return vMeetingDetailMQB.getMeetingDetailList().get(0).getMeetingDetailID();
	}
	/**
	 * 
	 * @param vMeetingDetailVO
	 * @param tManager
	 * @return vMeetingDetailVO
	 * @throws SQLException
	 */
	public static MeetingDetailVO addMeetingDetail(
			MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
			throws Exception {
		//Long n = CjfSequenceUtil.getCurSequence("MEETING_ID");
		//重新生成ID 中电国际，注释掉
		vMeetingDetailVO.setMeetingDetailID(UtilDAO.getUUid());
		MeetingDetailTO vMeetingDetailTO = new MeetingDetailTO(
				MeetingDetailTO.ADD_MEETINGDETAIL, vMeetingDetailVO);
		vMeetingDetailTO.setSqlStr();
		logger.info("add sql is :" + vMeetingDetailTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, true);
		} else{
			TransactionTemplate.executeTransaction(vMeetingDetailTO, tManager);
		}
		return vMeetingDetailVO;
	}
	/**
	 * 添加新的字段：模板id，一些备用字段。 2013-8-22
	 * @param vMeetingDetailVO
	 * @param tManager
	 * @return vMeetingDetailVO
	 * @throws SQLException
	 */
	public static MeetingDetailVO addMeetingDetail2(
			MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
			throws Exception {
		//Long n = CjfSequenceUtil.getCurSequence("MEETING_ID");
		vMeetingDetailVO.setMeetingDetailID(UtilDAO.getUUid());
		MeetingDetailTO vMeetingDetailTO = new MeetingDetailTO(
				MeetingDetailTO.ADD_MEETINGDETAIL2, vMeetingDetailVO);
		vMeetingDetailTO.setSqlStr();
		logger.info("add sql is :" + vMeetingDetailTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, tManager);
		}

		return vMeetingDetailVO;
	}
	/**
	 * 提取单表会议信息，包括模板和备用字段
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> queryMeetingDetailList2(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException { 
		StringBuffer strsql = new StringBuffer();
		strsql = new StringBuffer();
		strsql.append("SELECT meetingDetailID,temlyMeetingID,startTime,endTime,");
		strsql.append("meetingType,isRecord,meetingLevel,status,notifyType,");
		strsql.append("createUserID,createTime,description,revision,meetingName,confProfileID,meetingAgenda,confDocAdminId,confDocAdminName,templateID,templateType,info1,info2,info3,info4,info5");
		strsql.append(" FROM z_t_meetingDetail ");
		strsql.append(" WHERE 1=1 ");
		if (null != vMeetingDetailVO) { 
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID='" + vMeetingDetailVO.getMeetingDetailID()+"'");//meetingDetailID为字符串类型
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingID())) {
				strsql.append(" and temlymeetingid='" + vMeetingDetailVO.getMeetingID()+"'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingName())){
				strsql.append(" and meetingName like ('%" + vMeetingDetailVO.getMeetingName().trim() + "%') ");			
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingType())) {
				strsql.append(" and meetingType= " + vMeetingDetailVO.getMeetingType() );			
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())) {
				strsql.append(" and status in (" + String.valueOf(vMeetingDetailVO.getStatus()) + ")");			
			}else{
				strsql.append(" and status != " + MeetingStatus.INVALID + " and status!= " +  MeetingStatus.TEMPLATE); 
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDescription())){
				strsql.append(" and description= '" + vMeetingDetailVO.getMeetingDescription() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and createUserID= '" + vMeetingDetailVO.getCreateUserID() + "'");		
			}
			  
			if(vMeetingDetailVO.getMeetingStartTime() != null || vMeetingDetailVO.getMeetingEndTime() != null){
				String meetingStartTime = null;
				if(vMeetingDetailVO.getMeetingStartTime() == null){
					meetingStartTime = "'1997-01-01 00:00:00'";
				}else{
					meetingStartTime = "'" + TimeFormatUtil.getTimeStandFormat(vMeetingDetailVO.getMeetingStartTime()) + "'";			
				}
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
				strsql.append("  and ((to_char(starttime, 'yyyy-mm-dd HH24:MI:SS') <=" + meetingStartTime + " and to_char(endtime, 'yyyy-mm-dd HH24:MI:SS') > " + meetingStartTime + ") or (to_char(starttime, 'yyyy-mm-dd HH24:MI:SS') >=" + 
						meetingStartTime + " and to_char(starttime, 'yyyy-mm-dd HH24:MI:SS') < ");
				}else{
					strsql.append("  and ((DATE_FORMAT(starttime, 'yyyy-mm-dd HH24:MI:SS') <=" + meetingStartTime + " and DATE_FORMAT(endtime, 'yyyy-mm-dd HH24:MI:SS') > " + meetingStartTime + ") or (DATE_FORMAT(starttime, 'yyyy-mm-dd HH24:MI:SS') >=" + 
							meetingStartTime + " and DATE_FORMAT(starttime, 'yyyy-mm-dd HH24:MI:SS') < ");
				}
				String meetingEndTime = null;
				if(vMeetingDetailVO.getMeetingEndTime() == null){
					meetingEndTime = "'9999-12-31 23:59:59'";
				}else{
					meetingEndTime = "'" + TimeFormatUtil.getTimeStandFormat(vMeetingDetailVO.getMeetingEndTime()) + "'";
				}
				strsql.append(meetingEndTime +  "))");
			}
		}
		strsql.append(" order by createTime desc ");
				
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL2);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		return vMeetingDetailMQB.getMeetingDetailList();
	
	}
	
	/**
	 * 提取会议明细本身表的信息，无关联查询
	 * add by zhangdq on 20140306
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return	ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> queryMeetingDetailList(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException { 
		StringBuffer strsql = new StringBuffer();
		strsql = new StringBuffer();
		strsql.append("SELECT meetingDetailID,temlyMeetingID,startTime,endTime,");
		strsql.append("meetingType,isRecord,meetingLevel,status,notifyType,");
		strsql.append("createUserID,createTime,description,revision,meetingName,confProfileID,meetingAgenda,confDocAdminId,confDocAdminName,templateID,templateType,info1,info2,info3,info4,info5");
		strsql.append(" FROM z_t_meetingDetail ");
		strsql.append(" WHERE ");
		strsql.append("  status != " + MeetingStatus.INVALID + " and status!= " +  MeetingStatus.TEMPLATE);
		
		if (null != vMeetingDetailVO) { 
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID='" + vMeetingDetailVO.getMeetingDetailID()+"'");
			}
			
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingID())) {
				strsql.append(" and temlymeetingid='" + vMeetingDetailVO.getMeetingID()+"'");
			}
			
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingType())) {
				strsql.append(" and meetingType= " + vMeetingDetailVO.getMeetingType() );			
			}
			
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())) {
				strsql.append(" and status =" +vMeetingDetailVO.getStatus() + ")");			
			}

			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and createUserID= '" + vMeetingDetailVO.getCreateUserID() + "'");		
			}
		}
		strsql.append(" order by createTime desc ");
				
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL2);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		return vMeetingDetailMQB.getMeetingDetailList();
	
	}
	
	/**
	 * 提取会议关联会议室
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> query(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException { 


		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT md.meetingDetailID,md.temlyMeetingID,md.startTime,md.endTime,");
		strsql.append("md.meetingType,md.isRecord,md.meetingLevel,md.status,md.notifyType,");
		strsql.append("md.createUserID,md.createTime,md.description,md.revision,md.meetingName,md.confProfileID,md.meetingAgenda, md.info1,md.realityStartTime");
		strsql.append(",mr.meetingroomName,mr.meetingroomID ");
		strsql.append(" FROM z_t_meetingDetail md ");
		strsql.append(" LEFT JOIN z_t_meetingdetail_room mdr ON mdr.meetingDetailID = md.meetingDetailID");
		strsql.append(" LEFT JOIN z_t_meetingroom mr ON mdr.meetingroomID = mr.meetingroomID  ");
		
		strsql.append(" WHERE 1=1 ");
		if (null != vMeetingDetailVO) { 
			strsql.append(getSql(vMeetingDetailVO));
		}
		
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	public static MeetingDetailVO queryByID(String id) throws SQLException { 
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT md.meetingDetailID,md.temlyMeetingID,md.startTime,md.endTime,");
		strsql.append("md.meetingType,md.isRecord,md.meetingLevel,md.status,md.notifyType,");
		strsql.append("md.createUserID,md.createTime,md.description,md.revision,md.meetingName,md.confProfileID,md.meetingAgenda, md.info1");
		strsql.append(" FROM z_t_meetingDetail md ");
		
		strsql.append(" WHERE 1=1 ");
		if (null != id) {
			strsql.append(" and md.meetingDetailID = '"+id+"' ");
		}
		
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_ID);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query by id sql is :" + strsql.toString());
		
		PageController 	mPageController = new PageController();
		mPageController.setAll(true);

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailVO();
	}
	
	/**
	 * 提取会议关联部门
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> queryForDepartment(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException { 
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT md.meetingDetailID,md.temlyMeetingID,md.startTime,md.endTime,");
		strsql.append("md.meetingType,md.isRecord,md.meetingLevel,md.status,md.notifyType,");
		strsql.append("md.createUserID,md.createTime,md.description,md.revision,md.meetingName,md.confProfileID,md.meetingAgenda");
		strsql.append(",mdd.departID,d.name ");
		strsql.append(" FROM z_t_meetingDetail md,z_t_meetingdetail_department mdd,z_t_department d");
		
		strsql.append(" WHERE 1=1 ");
		if (null != vMeetingDetailVO) {
			strsql.append(getSql(vMeetingDetailVO));
		}
		strsql.append(" GROUP BY  md.meetingDetailID");

		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERYForDepartment);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	private static String getSql(MeetingDetailVO vMeetingDetailVO){
		StringBuffer strsql = new StringBuffer();
		if (!StringUtils.isNullOrBlank(vMeetingDetailVO
				.getMeetingID())) {
			strsql.append(" and md.temlymeetingid='"
					+ vMeetingDetailVO.getMeetingID()+"'");
		}
		if (!StringUtils.isNullOrBlank(vMeetingDetailVO
				.getMeetingDetailID())) {
			strsql.append(" and md.meetingDetailID='"
					+ vMeetingDetailVO.getMeetingDetailID()+"'");//meetingDetailID为字符串类型
		}
		if (!StringUtils.isNullOrBlank(vMeetingDetailVO
				.getStatus())) {
			strsql.append(" and md.status in("+vMeetingDetailVO.getStatus() +") ");
		}
		
		if(vMeetingDetailVO.getMeetingStartTime()==null){
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
				strsql.append(" and md.startTime > to_date('2000-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')");
			}else{
				strsql.append(" and md.startTime > '2000-01-01 00:00:00.0'");
			}
		}else {
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
				strsql.append(" and md.startTime > "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
			}else{
				strsql.append(" and md.startTime > '"+vMeetingDetailVO.getMeetingStartTime()+"'");
			}
		} 
		if(vMeetingDetailVO.getMeetingEndTime()==null){
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
				strsql.append(" and  md.endTime < to_date('3000-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')");
			}else{
				strsql.append(" and  md.endTime < '3000-01-01 00:00:00.0'");
			}
		}else {
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
				strsql.append(" and md.endTime <  "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime()));
			}else{
				strsql.append(" and md.endTime < '"+vMeetingDetailVO.getMeetingEndTime()+"'");
			}
		} 
	
		return strsql.toString();
	}
	
	/**
	 * 
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 
	public static ArrayList<MeetingDetailVO> getMeetingDetailList(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException {
		StringBuffer strsql = new StringBuffer();
		strsql.append("call getMeetingDetailList(");
		if (null != vMeetingDetailVO) {
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDetailID())) {
				strsql.append("'" + vMeetingDetailVO.getMeetingDetailID() + "',");
			}else{
				strsql.append("null,");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingID())) {
				strsql.append("'" + vMeetingDetailVO.getMeetingID() + "',");
			}else{
				strsql.append("null,");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingRoomID())) {
				strsql.append("'" + vMeetingDetailVO.getMeetingRoomID() + "',");
			}else{
				strsql.append("null,");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingRoomName())){
				strsql.append("'" + vMeetingDetailVO.getMeetingRoomName().trim() + "',");
			}else{
				strsql.append("null,");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingName())){
				strsql.append("'" + vMeetingDetailVO.getMeetingName().trim() + "',");			
			}else{
				strsql.append("null,");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingType())) {
				strsql.append(vMeetingDetailVO.getMeetingType() + ",");			
			}else{
				strsql.append("-1,");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())) {
				strsql.append("'" + String.valueOf(vMeetingDetailVO.getStatus()) + "',");			
			}else{
				strsql.append("null,");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDescription())){
				strsql.append("'" + vMeetingDetailVO.getMeetingDescription() + "',");
			}else{
				strsql.append("null,");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getCreateUserID())) {
				strsql.append("'" + vMeetingDetailVO.getCreateUserID() + "',");		
			}else{
				strsql.append("null,");
			}
			if(vMeetingDetailVO.getMeetingStartTime() != null || vMeetingDetailVO.getMeetingEndTime() != null){
				if(vMeetingDetailVO.getMeetingStartTime() == null){
					strsql.append("'1997-01-01 00:00:00',");
				}else{
					strsql.append("'" + TimeFormatUtil.getTimeStandFormat(vMeetingDetailVO.getMeetingStartTime()) + "',");			
				}
				if(vMeetingDetailVO.getMeetingEndTime() == null){
					strsql.append("'9999-12-31 23:59:59'");
				}else{
					strsql.append("'" + TimeFormatUtil.getTimeStandFormat(vMeetingDetailVO.getMeetingEndTime()) + "'");
				}
			}else{
				strsql.append("null,null");
			}
		}else{
			strsql.append("null,null,null,null,null,-1,null,null,null,null,null");
		}
		strsql.append(");");
		//call getMeetingDetailv5(null,null,null,null,null,-1,-1,-1,-1,-1,null,-1,null,null,null);
		System.out.println("********strsql:\n" + strsql);
		Connection conn = null;
		CallableStatement comm = null;
		ResultSet rs  = null;
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL);
		try{
			conn = DBConnection.getConnection();
			comm = ((java.sql.Connection) conn).prepareCall(strsql.toString());
			comm.execute();
			rs = comm.getResultSet();
			//fetch data according to the page controller
			int count = 0;
			if(rs!= null && mPageController != null) {
			    rs.last();
			    int totalNum = rs.getRow();
			    int startPos = mPageController.getStartRowNo();
			    if (startPos >= totalNum)
			    	return vMeetingDetailMQB.getMeetingDetailList();
			    mPageController.setTotalNo(totalNum);
			    //rs.absolute(startPos);
			    if (startPos == 0 )
	               rs.beforeFirst();
			    else
			    	rs.absolute(startPos);
				    	
			 }
			 while (rs!= null && rs.next())
			 {
				vMeetingDetailMQB.getDataForRow(rs);
			    count ++;
			    if (mPageController != null && count >= mPageController.getPageSize())
			    	 break;
			 }
			 
		  	 }catch(Exception e){
		  		 e.printStackTrace();
		  		throw new SQLException(e.getMessage()); 
		  	 }
		  	 finally{
			 //free db resource
	  		 if(rs!=null){
	  			rs.close();
				rs = null;
	  		 }
			   comm.close();
			   comm = null;
			   conn.close();
		       conn =null;
		  	 }
		
		return vMeetingDetailMQB.getMeetingDetailList();
	}
	*/
	private static ArrayList<MeetingDetailVO> addMeetingData(MeetingDetailVO detailVO, ArrayList<MeetingDetailVO> finalMdList){
		//if(finalMdList.size() == 0){
			
		//	finalMdList.add(detailVO);
		//	return finalMdList;
		//}
		boolean isExisted = false;
		for(MeetingDetailVO meetingDetailVO : finalMdList){
			if(meetingDetailVO.getMeetingDetailID().equals(detailVO.getMeetingDetailID())){
				isExisted = true;
				if(detailVO.getStartTDNumber() == MeetingDetailEnum.mainVenue_valid){
					meetingDetailVO.setMeetingRoomID(detailVO.getMeetingRoomID());
					meetingDetailVO.setMeetingRoomName(detailVO.getMeetingRoomName());
				}
				meetingDetailVO.setMeetingRoomNames(meetingDetailVO.getMeetingRoomNames() + "," + detailVO.getMeetingRoomName());
				meetingDetailVO.setMeetingRoomNameIDs(meetingDetailVO.getMeetingRoomNameIDs() + "," + detailVO.getMeetingRoomID());
				break;
			}
		}
		if(!isExisted){
			detailVO.setMeetingRoomNames(detailVO.getMeetingRoomName());
			detailVO.setMeetingRoomNameIDs(detailVO.getMeetingRoomID());
			finalMdList.add(detailVO);
		}
		return finalMdList;
	}
	
	//查询我的会议列表,查询会议管理列表 相同 王玉龙 2013-8-28
	//下面只是取得一个id
	public static ArrayList<MeetingDetailVO> getMeetingDetailList(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException {
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT md.meetingDetailID");
		strsql.append(" FROM z_t_meetingDetail md ");
		strsql.append(" LEFT JOIN z_t_meetingdetail_room mdr ON mdr.meetingDetailID = md.meetingDetailID");
		strsql.append(" LEFT JOIN z_t_meetingroom mr ON mdr.meetingroomID = mr.meetingroomID  ");
		strsql.append(" LEFT JOIN z_t_meetingdetail_user mu ON mdr.meetingDetailID = mu.meetingDetailID ");
		strsql.append(" WHERE 1=1 ");
		if (null != vMeetingDetailVO) { 
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDetailID())) {
				strsql.append(" and md.meetingDetailID='" + vMeetingDetailVO.getMeetingDetailID()+"'");//meetingDetailID为字符串类型
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingID())) {
				strsql.append(" and md.temlymeetingid='" + vMeetingDetailVO.getMeetingID()+"'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingRoomID())) {
				strsql.append(" and mr.meetingRoomID= '" + vMeetingDetailVO.getMeetingRoomID() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingRoomName())){
				strsql.append(" and mr.meetingRoomName  like ('%" + vMeetingDetailVO.getMeetingRoomName().trim() + "%')");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingName())){
				strsql.append(" and md.meetingName like ('%" + vMeetingDetailVO.getMeetingName().trim() + "%') ");			
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingType())) {
				strsql.append(" and md.meetingType	= " + vMeetingDetailVO.getMeetingType() );
			}
			
			strsql.append(" and md.meetingType	!= " +MeetingDetailEnum.TYPE_VEDIO_DEBUG  );

			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())) {
				strsql.append(" and md.status in (" + String.valueOf(vMeetingDetailVO.getStatus()) + ")");			
			}else{
				strsql.append(" and md.status != " + MeetingStatus.INVALID + " and md.status!= " +  MeetingStatus.TEMPLATE); 
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDescription())){
				strsql.append(" and md.description= '" + vMeetingDetailVO.getMeetingDescription() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and (md.createUserID= '" + vMeetingDetailVO.getCreateUserID() + "'");
				strsql.append(" OR mu.userID= '" + vMeetingDetailVO.getCreateUserID() + "')");
			}
			Calendar c = Calendar.getInstance();
			Timestamp startTime =null;
			Timestamp endTime =null;
			if(vMeetingDetailVO.getMeetingStartTime() == null){
				c.clear();
				c.set(Calendar.YEAR, 2000);
				startTime = new Timestamp(c.getTimeInMillis());
			}else{
				startTime = vMeetingDetailVO.getMeetingStartTime();
			}
			if(vMeetingDetailVO.getMeetingEndTime() == null){
				c.clear();
				c.set(Calendar.YEAR, 2099);
				endTime = new Timestamp(c.getTimeInMillis());
			}else{
				endTime = vMeetingDetailVO.getMeetingEndTime();
			}
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
				strsql.append(" and (( md.startTime >="+UtilDAO.oracleToDate(startTime));
				strsql.append("  and md.startTime <="+UtilDAO.oracleToDate(endTime)+")");
				strsql.append(" or ( md.endTime >= "+UtilDAO.oracleToDate(startTime));
				strsql.append("  and md.endTime <="+UtilDAO.oracleToDate(endTime)+")");
				strsql.append(" or ( md.startTime <="+UtilDAO.oracleToDate(startTime));
				strsql.append("  and md.endTime >="+UtilDAO.oracleToDate(endTime)+"))");
			}else{
				strsql.append(" and (( md.startTime >= '"+startTime+"' ");
				strsql.append("  and md.startTime <= '"+endTime+"' )");
				strsql.append(" or ( md.endTime >= '"+startTime+"' ");
				strsql.append("  and md.endTime <= '"+endTime+"' )");
				strsql.append(" or ( md.startTime >= '"+startTime+"' ");
				strsql.append("  and md.endTime <= '"+endTime+"' ))");
			}
			
			if(vMeetingDetailVO.getOpenlevel()){
				strsql.append(" and md.createUserID IN(" + vMeetingDetailVO.getLvoids()+")");
			}
		}
		strsql.append(" GROUP BY md.meetingDetailID,md.createTime order by md.createTime desc ");
				
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_MEETINGDETAIL_IDS);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("getMeetDetail query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		StringBuffer buffer = new StringBuffer();
		ArrayList<MeetingDetailVO> meetingDetailList = vMeetingDetailMQB.getMeetingDetailList();
		if(meetingDetailList != null && meetingDetailList.size() > 0){
			for(int i=0; i<meetingDetailList.size(); i++){
				MeetingDetailVO oldMeetingVO = meetingDetailList.get(i);
				buffer.append("'" + oldMeetingVO.getMeetingDetailID() + "'");
				if(i != meetingDetailList.size()-1){
					buffer.append(",");
				}
			}
		}else{
			return meetingDetailList;
		}
		
		//这个是取得会议列表信息的所有的值
		 strsql = new StringBuffer();

		
		//strsql.append("SELECT md.meetingDetailID,md.startTime,md.endTime,md.isRecord,md.meetingLevel,md.createTimemd.temlyMeetingID, ");
		//strsql.append("md.meetingType,md.status ,mdr.ismain ,md.confDocAdminName ,md.confDocAdminId ,md.confProfileID,md.meetingAgenda,md.description,md.revision,md.notifyType ");
		//strsql.append("md.createUserID,md.meetingName,");
		//strsql.append("mr.meetingroomName,mr.meetingroomID, md.description,md.revision,,md.notifyType, md.info1,us.fullName");
		
		//strsql.append("SELECT md.meetingDetailID, md.meetingName,md.startTime,md.endTime,md.meetingType,md.status,md.createUserID,md.info1,us.fullName");

		strsql.append("SELECT md.meetingDetailID,md.temlyMeetingID,md.startTime,md.endTime,");
		strsql.append("md.meetingType,md.isRecord,md.meetingLevel,md.status,md.notifyType,");
		strsql.append("md.createUserID,md.createTime,md.description,md.revision,md.meetingName,md.confProfileID,md.meetingAgenda,md.confDocAdminId,md.confDocAdminName,md.info1 ");
		strsql.append(",mr.meetingroomName,mr.meetingroomID,mdr.ismain ,md.info1,md.info2,md.info3,md.templateType,md.templateID,us.fullName");

		strsql.append(" FROM z_t_meetingDetail md ");
		strsql.append(" LEFT JOIN z_t_meetingdetail_room mdr ON mdr.meetingDetailID = md.meetingDetailID");
		strsql.append(" LEFT JOIN z_t_meetingroom mr ON mdr.meetingroomID = mr.meetingroomID  ");	
		strsql.append(" LEFT JOIN z_t_user us        ON us.userID =md.createUserID");
		strsql.append(" WHERE 1=1 ");
		strsql.append(" and md.meetingDetailID in (" + buffer.toString() +")");
		strsql.append(" order by md.createTime desc");
		vMeetingDetailMQB = new MeetingDetailMQB(MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL_ROOM);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		mPageController = new PageController();
		mPageController.setAll(true);
		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		meetingDetailList = vMeetingDetailMQB.getMeetingDetailList();
		ArrayList<MeetingDetailVO> finalMdList = new ArrayList<MeetingDetailVO>();
		if(meetingDetailList != null && meetingDetailList.size() > 0){
			for(MeetingDetailVO detailVO : meetingDetailList){
				finalMdList = addMeetingData(detailVO, finalMdList);
			}
		}
		return finalMdList;
	}

	/**
	 * 查询开始时间、结束时间已经超过当前时间的列表
	 * add by ryan on 201-04-13
	 * @param vMeetingDetailVO
	 * @param status demo:1,2,4
	 * @param mPageController
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> pastSysTime(
		MeetingDetailVO vMeetingDetailVO,PageController mPageController) throws SQLException {
		StringBuffer strsql = new StringBuffer();
		Timestamp t = new Timestamp(System.currentTimeMillis());
		strsql.append("SELECT md.meetingDetailID,md.temlyMeetingID,md.startTime,md.endTime,");
		strsql.append("md.meetingType,md.isRecord,md.meetingLevel,md.status,md.notifyType,");
		strsql.append("md.createUserID,md.createTime,md.description,md.revision,md.meetingName,md.confProfileID,md.meetingAgenda");
		strsql.append(" FROM z_t_meetingDetail md WHERE 1=1  ");
//		strsql.append(" and md.status in("+vMeetingDetailVO.getStatus()+")");
		strsql.append(" and md.status in("+MeetingDetailEnum.STATUS_APPROVED_PASS+","+MeetingDetailEnum.STATUS_ING+")");
		if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
//			strsql.append(" and ( md.startTime >= "+UtilDAO.oracleToDate(t));
			strsql.append(" and md.startTime <= "+UtilDAO.oracleToDate(t)+"");
		}else{
//			strsql.append(" and ( md.startTime >='"+t+"'");
			strsql.append("  and md.startTime <= '"+t+"' ");
		}
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_PANDECT);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	/**
	 * 查询某个会议室，时间段内的会议列表
	 * add by ryan on 201-04-12
	 * @param vMeetingDetailVO
	 * @param status demo:1,2,4
	 * @param mPageController
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingDetailList(
			MeetingDetailVO vMeetingDetailVO, String status, PageController mPageController) throws SQLException {
		StringBuffer strsql = new StringBuffer();
		
		strsql.append("SELECT md.meetingDetailID,md.temlyMeetingID,md.startTime,md.endTime,");
		strsql.append("md.meetingType,md.isRecord,md.meetingLevel,md.status,md.notifyType,");
		strsql.append("md.createUserID,md.createTime,md.description,md.revision,md.meetingName,md.confProfileID,md.meetingAgenda,md.info1");
		strsql.append(" FROM z_t_meetingDetail md WHERE 1=1  ");
		strsql.append(" and md.status in("+status+")");
		if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
			strsql.append(" and (( md.startTime >="+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
			strsql.append("  and md.startTime <="+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime())+")");
			strsql.append(" or ( md.endTime >= "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
			strsql.append("  and md.endTime <="+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime())+")");
			strsql.append(" or ( md.startTime <="+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
			strsql.append("  and md.endTime >="+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime())+"))");
		}else{
			strsql.append(" and (( md.startTime >= '"+vMeetingDetailVO.getMeetingStartTime()+"' ");
			strsql.append("  and md.startTime <= '"+vMeetingDetailVO.getMeetingEndTime()+"' )");
			strsql.append(" or ( md.endTime >= '"+vMeetingDetailVO.getMeetingStartTime()+"' ");
			strsql.append("  and md.endTime <= '"+vMeetingDetailVO.getMeetingEndTime()+"' )");
			strsql.append(" or ( md.startTime <= '"+vMeetingDetailVO.getMeetingStartTime()+"' ");
			strsql.append("  and md.endTime >= '"+vMeetingDetailVO.getMeetingEndTime()+"' ))");
		}
		strsql.append(" AND md.meetingDetailID IN ( ");
		strsql.append(" SELECT mdr.meetingDetailID FROM z_t_meetingdetail_room mdr WHERE mdr.meetingroomID='"+vMeetingDetailVO.getMeetingRoomID()+"'");
		strsql.append(" ) ");
		strsql.append(" order by md.startTime"); 
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_PANDECT);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		return vMeetingDetailMQB.getMeetingDetailList();
	}

	/**
	 * 
	 * @param vMeetingDetailVO
	 * @param tManager
	 * @return MeetingDetailVO
	 * @throws SQLException
	 */
	public static MeetingDetailVO modifyMeetingDetail(
			MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
			throws SQLException { 
		MeetingDetailTO vMeetingDetailTO = new MeetingDetailTO(
				MeetingDetailTO.MODIFY_MEETINGDETAIL, vMeetingDetailVO);
		vMeetingDetailTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingDetailTO.getSqlStr());
		
		
		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, tManager);
		}

		return vMeetingDetailVO;
	}
	/**
	 * 修改会议状态
	 * @param vMeetingDetailVO
	 * @param tManager
	 * @return
	 * @throws SQLException
	 */
	public static MeetingDetailVO modifyMeetingDetailStatus(
			MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
			throws SQLException { 
		MeetingDetailTO vMeetingDetailTO = new MeetingDetailTO(
				MeetingDetailTO.MODIFY_MEETINGDETAIL_STATUS, vMeetingDetailVO);
		vMeetingDetailTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingDetailTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, tManager);
		}

		return vMeetingDetailVO;
	}
	
	
	/**
	 * 修改会参会人数，info2为参会人数专用字段
	 * @author:zhangjy 2014-01-16
	 */
	public static MeetingDetailVO modifyMeetingDetailInfo2(
			MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
			throws SQLException { 
		MeetingDetailTO vMeetingDetailTO = new MeetingDetailTO(
				MeetingDetailTO.MODIFY_MEETINGDETAIL_INFO2, vMeetingDetailVO);
		vMeetingDetailTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingDetailTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, tManager);
		}

		return vMeetingDetailVO;
	}
	
	public static void addExam(MeetingDetailVO vMeetingDetailVO, TransactionManager tManager)
	throws SQLException { 
		MeetingDetailTO vMeetingDetailTO = new MeetingDetailTO(
				MeetingDetailTO.ADD_EXAM, vMeetingDetailVO);
		vMeetingDetailTO.setSqlStr();
		logger.info("modify sql is :" + vMeetingDetailTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, tManager);
		}
	}
	/**
	 * 
	 * @param vMeetingDetailVO
	 * @param tManager
	 * @return int
	 * @throws SQLException
	 */
	public static int delMeetingDetail(MeetingDetailVO vMeetingDetailVO,
			TransactionManager tManager) throws SQLException {
		MeetingDetailTO vMeetingDetailTO = new MeetingDetailTO(
				MeetingDetailTO.DEL_MEETINGDETAIL, vMeetingDetailVO);
		vMeetingDetailTO.setSqlStr();
		logger.info("delete sql is :" + vMeetingDetailTO.getSqlStr());

		if (tManager == null) {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, true);
		} else {
			TransactionTemplate.executeTransaction(vMeetingDetailTO, tManager);
		}
		return vMeetingDetailTO.getexecuteResult();
	}

	/**
	 * 取我的会议
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingDetailListByUserID(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();
		//meetingid 表也不存在 不存在 TODO???
		strsql
				.append("select m.meetingDetailID,m.meetingID,m.meetingRoomID,m.meetingRoomName,m.meetingName,m.meetingStartTime,m.meetingEndTime,m.useNotice,m.useReach,m.meetingType,m.grade,m.notifyType,u.status,m.meetingDescription,m.revision," +
						"m.showParticipatorNames,m.neededEquipmentIDs,m.neededEquipmentNames,m.neededEquipModelNames,m.neededServiceIDs,m.neededServiceNames,m.meetingRoomNameIDs,m.meetingRoomNames,m.meetingAgenda,u.participatorID participatorIDs,u.participatorName  participators,u.userID createUserID,u.userName  createUserName, neededVideoEquipsShow, neededRooms4Equip,confProfileID ");
		strsql.append(" from t_meetingdetail m left join t_meetingdetailuser u on u.meetingDetailID=m.meetingDetailID ");
		strsql.append(" where 1=1 ");
		if (null != vMeetingDetailVO) {
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and (u.participatorID = "+vMeetingDetailVO.getCreateUserID()+" or u.userID= "+vMeetingDetailVO.getCreateUserID() + ")");
			}
		}
		strsql.append(" and m.status=" + MeetingStatus.APPROVED);
		strsql.append(" and m.meetingStartTime >= '"+TimeFormatUtil.getTimestamp()+"'");
		strsql.append("order by m.meetingID desc"); 
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	/**
	 * 次数统计
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingRoomStatistic(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();//meetingid 不存在 TODO???
		strsql.append("select m.meetingDetailID,m.meetingID,m.meetingName,m.meetingStartTime,m.meetingEndTime,m.useNotice,m.useReach,m.meetingType,m.grade,m.notifyType,m.meetingDescription,m.revision,m.createUserID,m.createUserName," +
				"m.participatorIDs,m.participators,m.showParticipatorNames,m.neededEquipmentIDs,m.neededEquipmentNames,m.neededEquipModelNames,m.neededServiceIDs,m.neededServiceNames,m.meetingRoomNameIDs,m.meetingRoomNames,m.meetingroomid,m.meetingRoomName,m.meetingAgenda count(m.meetingroomid) status, neededVideoEquipsShow , neededRooms4Equip,confProfileID,meetingAgenda");
		strsql.append(" from z_t_meetingdetail m ");
		strsql.append(" where 1=1 ");
		if(vMeetingDetailVO!=null){
			if(vMeetingDetailVO.getMeetingStartTime()!=null){
				strsql.append(" and meetingStartTime between '"+vMeetingDetailVO.getMeetingStartTime()+"'");
			}else{
				strsql.append(" and  meetingStartTime between    '" +
						TimeFormatUtil.getDateFromStr("2009-01-01 00:00:00.0")+"' ");
			}
			if(vMeetingDetailVO.getMeetingEndTime()!=null){
				strsql.append(" and '"+vMeetingDetailVO.getMeetingEndTime()+"' ");
			}else{
				strsql.append(" and '"+TimeFormatUtil.getTimestamp()+"' ");
			}
		}
		strsql.append(" group by m.meetingroomid   order by status desc ");
		
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	/**
	 * 时长统计
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingRoomStatisticForTime(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {
		
			StringBuffer strsql = new StringBuffer();
			//TODO::　sum(UNIX_TIMESTAMP(endtime)-UNIX_TIMESTAMP(starttime)) 在oracle中是不可以的
			strsql.append("select  mr.meetingroomid, mr.meetingroomname,endtime,starttime,sum(UNIX_TIMESTAMP(endtime)-UNIX_TIMESTAMP(starttime))  use_time from z_t_meetingdetail md,z_t_meetingdetail_room mdr,z_t_meetingroom mr ");
			strsql.append("where md.meetingDetailID = mdr.meetingDetailID and mdr.meetingroomID=mr.meetingroomID ");
			if(vMeetingDetailVO!=null){
				if(vMeetingDetailVO.getMeetingStartTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and md.starttime between "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
					}else{
						strsql.append(" and md.starttime between '"+vMeetingDetailVO.getMeetingStartTime()+"'");
					}
				}else{
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and  md.starttime between to_date('2009-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')" );
					}else{
						strsql.append(" and  md.starttime between    '" +
								TimeFormatUtil.getDateFromStr("2009-01-01 00:00:00.0")+"' ");
					}
				}
				if(vMeetingDetailVO.getMeetingEndTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and  "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime()));
					}else{
						strsql.append(" and '"+vMeetingDetailVO.getMeetingEndTime()+"' ");
					}
					
				}else{
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and  "+UtilDAO.oracleToDate(new Timestamp(System.currentTimeMillis())));
					}else{
						strsql.append(" and '"+TimeFormatUtil.getTimestamp()+"' ");
					}
					
				}
				
				if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getStatus())) {
					strsql.append(" and md.status=" + vMeetingDetailVO.getStatus());
				}
				
			}
			
			strsql.append(" group by mdr.meetingroomID  order by use_time desc"); 
			
			MeetingDetailMQBUseTime vMeetingDetailMQB = new MeetingDetailMQBUseTime(
					MeetingDetailMQBUseTime.QUERY_FROM_MEETINGDETAIL);
			vMeetingDetailMQB.setSql(strsql.toString());
			logger.info("query sql is :" + strsql.toString());
			if (mPageController == null) {
				mPageController = new PageController();
				mPageController.setAll(true);
			}
			QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
			return vMeetingDetailMQB.getMeetingDetailList();
		}
	
	/**
	 * 取用户的预定列表
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingDetailAndAssignListByUserID(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();
		//t_meetingdetail 不存在
		strsql.append("select d.meetingdetailid  id ,d.meetingStartTime  starttime ,d.meetingendtime  endtime,d.meetingName  meetingname ,d.meetingroomName  meetingroomName , d.meetingDescription  description ,d.status  status ,d.meetingID  meetingid, d.meetingType meetingType d.meetingAgenda meetingAgenda from t_meetingdetail  d ");
		if(vMeetingDetailVO!=null){
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" where d.createUserID ="+vMeetingDetailVO.getCreateUserID());
			}
		}
		strsql.append(" and d.status in("+MeetingStatus.APPROVED+", "+MeetingStatus.SAVED+") and d.meetingStartTime > '"+TimeFormatUtil.getTimestamp()+"' ");
		
		strsql.append(" union all select a.assignID  id,a.starttime  starttime ,a.endtime  endtime ,a.meetingName  meetingname,a.description  meetingroomName,a.description  description ,11  status ,-1 meetingid, a.meetingType meetingType  from t_assign a  ");
		
		if(vMeetingDetailVO!=null){
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getCreateUserID())) {
				strsql.append("  where a.userID ="+vMeetingDetailVO.getCreateUserID());
			}
		}
		strsql.append(" and a.starttime > '"+TimeFormatUtil.getTimestamp()+"'");
		strsql.append("order by meetingid desc");
		MeetingDetailMQBb vMeetingDetailMQBb = new MeetingDetailMQBb(
				MeetingDetailMQBb.QUERY_FROM_MEETINGDETAIL);
		vMeetingDetailMQBb.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQBb, mPageController);

		return vMeetingDetailMQBb.getMeetingDetailList();
	}
	
	/**
	 * 取我参加过的会议
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getOldMeetingDetailListByUserID(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {

		StringBuffer strsql = new StringBuffer();
		// t_meetingdetail
		strsql
				.append("select m.meetingDetailID,m.meetingID,m.meetingRoomID,m.meetingRoomName,m.meetingName,m.meetingStartTime,m.meetingEndTime,m.useNotice,m.useReach,m.meetingType,m.grade,m.notifyType,u.status,m.meetingDescription,m.revision," +
						"m.showParticipatorNames,m.neededEquipmentIDs,m.neededEquipmentNames,m.neededEquipModelNames,m.neededServiceIDs,m.neededServiceNames,m.meetingRoomNameIDs,m.meetingRoomNames,m.meetingAgenda,u.participatorID as participatorIDs,u.participatorName as participators,u.userID as createUserID,u.userName as createUserName, neededVideoEquipsShow, neededRooms4Equip,confProfileID,");
		strsql.append(" from t_meetingdetail m left join t_meetingdetailuser u on u.meetingDetailID=m.meetingDetailID ");
		strsql.append(" where 1=1 ");
		if (null != vMeetingDetailVO) {
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and u.participatorID = "+vMeetingDetailVO.getCreateUserID());;
			}
		}
		strsql.append(" and m.status=" + MeetingStatus.APPROVED);
		strsql.append(" and m.meetingStartTime < '"+TimeFormatUtil.getTimestamp()+"'");
		strsql.append("order by m.meetingID desc");
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	/**
	 * 取现在正在开的视频会议包括调试会议
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingListForToday(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException {
		//TODO: NULL as 有问题
		StringBuffer strsql = new StringBuffer();
//		strsql
//		.append("select meetingDetailID,meetingID,meetingRoomID,meetingRoomName,meetingName,meetingStartTime,meetingEndTime,useNotice,useReach,meetingType,grade,notifyType,status,meetingDescription,revision,createUserID,createUserName," +
//				"participatorIDs,participators,showParticipatorNames,neededEquipmentIDs,neededEquipmentNames,neededEquipModelNames,neededServiceIDs,neededServiceNames,meetingRoomNameIDs,meetingRoomNames,neededVideoEquipsShow, neededRooms4Equip,confProfileID ");
		strsql.append("select  meetingDetailID, temlyMeetingID,null as meetingRoomID,null as meetingRoomName,meetingName," +
					"startTime as meetingStartTime,endTime as meetingEndTime, null as useNotice,isRecord as useReach,meetingType,meetingLevel as grade ,notifyType,status,description,revision," + 
                     "createUserID,null as createUserName,  createTime, null as meetingRoomNames, null as meetingRoomNameIDs,null as participatorIDs,null as participators,null as showParticipatorNames,null as neededEquipmentIDs,null as neededEquipmentNames,null as neededEquipModelNames,null as neededServiceIDs,null as neededServiceNames,null as neededVideoEquipsShow,null as  neededRooms4Equip,null as confProfileID,null as meetingAgenda,null as confDocAdminId,null as confDocAdminName");
		strsql.append(" from z_t_meetingdetail");
		strsql.append(" where 1=1 ");
		//System.out.println("================" + strsql.toString());
		if(vMeetingDetailVO!=null){
			if(vMeetingDetailVO.getMeetingStartTime()!=null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and startTime <"+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()) +" and endTime > "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
				}else{
					strsql.append(" and startTime < '"+vMeetingDetailVO.getMeetingStartTime()+"'" +
							" and endTime >'"+vMeetingDetailVO.getMeetingStartTime()+"'");
				}
			}
		}
		strsql.append(" and status= "+MeetingStatus.BE_ATTENDING);//modify at 2012 9-5 by chenshuo
//		if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingType())) {
//			strsql.append(" and meetingType= "+vMeetingDetailVO.getMeetingType());//modify at 2013 3-21 by wangle
//		}else{
		strsql.append(" and (meetingType= "+MeetingDetailEnum.TYPE_VEDIO_DEBUG );//modify at 2013 3-21 by zhangdq
		strsql.append(" or meetingType= "+MeetingDetailEnum.TYPE_VEDIO+") ");
//		}
		if(vMeetingDetailVO.getOpenlevel()){
			strsql.append(" and createUserID IN(" + vMeetingDetailVO.getLvoids()+")");
		}
		strsql.append(" order by createTime desc");
		
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	/**
	 * 
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingDetailListExceptStatus(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();
		//TODO:??? t_meetingDetail 不存在
		strsql.append("select meetingDetailID,meetingID,meetingRoomID,meetingRoomName,meetingName,meetingStartTime,meetingEndTime,useNotice,useReach,meetingType,grade,notifyType,status,meetingDescription,revision,createUserID,createUserName," +
						"participatorIDs,participators,showParticipatorNames,neededEquipmentIDs,neededEquipmentNames,neededEquipModelNames,neededServiceIDs,neededServiceNames,meetingRoomNameIDs,meetingRoomNames,neededVideoEquipsShow, neededRooms4Equip,confProfileID,meetingAgenda ");
		strsql.append(" from z_t_MeetingDetail ");
		strsql.append(" where 1=1 ");
		if (null != vMeetingDetailVO) {

			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO
					.getMeetingDetailID())) {
				strsql.append(" and meetingDetailID="
						+ vMeetingDetailVO.getMeetingDetailID());
			}
			if (!IntegerUtils
					.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingID())) {
				strsql.append(" and meetingID="
						+ vMeetingDetailVO.getMeetingID());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO
					.getMeetingRoomID())) {
				strsql.append(" and meetingRoomID="
						+ vMeetingDetailVO.getMeetingRoomID());
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO
					.getMeetingRoomName())) {
				strsql.append(" and meetingRoomName like ('%"
						+ vMeetingDetailVO.getMeetingRoomName() + "%') ");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingName())) {
				strsql.append(" and meetingName like ('%"
						+ vMeetingDetailVO.getMeetingName() + "%') ");
			}
			if (!IntegerUtils
					.isNullOrMIN_VALUE(vMeetingDetailVO.getUseNotice())) {
				strsql.append(" and useNotice="
						+ vMeetingDetailVO.getUseNotice());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getUseReach())) {
				strsql
						.append(" and useReach="
								+ vMeetingDetailVO.getUseReach());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO
					.getMeetingType())) {
				if(vMeetingDetailVO.getMeetingType()==MeetingTypeEnum.HOST_MEETING_NEW){
					strsql.append(" and meetingType in ("+MeetingTypeEnum.selfMeetingType+","+MeetingTypeEnum.assignLocalMeetingType+","+MeetingTypeEnum.detailLocalMeetingType+")");
				}else if(vMeetingDetailVO.getMeetingType()==MeetingTypeEnum.PLOYCOM_MEETING_NEW){
					strsql.append(" and meetingType in ("+MeetingTypeEnum.assignVideoMeetingType+","+MeetingTypeEnum.detailVideoMeetingType+")");
				}else{
					strsql.append(" and meetingType ="+vMeetingDetailVO.getMeetingType());
				}
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getGrade())) {
				strsql.append(" and grade=" + vMeetingDetailVO.getGrade());
			}
			
			//if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getStatus())) {
			/*modified by wangle in 2010-10-26  add bracket under the following sentence*/
				strsql.append(" and (status=1 or status=3) " );
			//}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO
					.getMeetingDescription())) {
				strsql.append(" and meetingDescription='"
						+ vMeetingDetailVO.getMeetingDescription() + "'");
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and createUserID=" + vMeetingDetailVO.getCreateUserID());
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO
					.getCreateUserName())) {
				strsql.append(" and createUserName='"
						+ vMeetingDetailVO.getCreateUserName() + "'");
			}
			/*modified by wangle in 2010-10-26
//			if(vMeetingDetailVO.getMeetingStartTime()!=null){
//				strsql.append(" and meetingStartTime between '"+vMeetingDetailVO.getMeetingStartTime()+"'");
//			}
			//				else{
//				strsql.append(" and  meetingStartTime between    '" +
//						TimeFormatUtil.getDateFromStr("2009-01-01 00:00:00.0")+"' ");
//			}
//			if(vMeetingDetailVO.getMeetingEndTime()!=null){
//				strsql.append(" and '"+vMeetingDetailVO.getMeetingEndTime()+"' ");
//			}
//			else{
//				strsql.append(" and '"+TimeFormatUtil.getTimestamp()+"' ");
//			}
		}
			*/
			if(vMeetingDetailVO.getMeetingStartTime()!=null && vMeetingDetailVO.getMeetingEndTime()!=null){
				strsql.append(" and (meetingStartTime between '"+vMeetingDetailVO.getMeetingStartTime()+"'");
				strsql.append(" and '"+vMeetingDetailVO.getMeetingEndTime()+"' ");
				strsql.append(" or meetingEndTime between '" + vMeetingDetailVO.getMeetingStartTime()+"'");
				strsql.append(" and '"+vMeetingDetailVO.getMeetingEndTime()+"') ");
			}
			//select by meeting room id
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingRoomNames())) {
				strsql.append(" and meetingRoomNames like '%" + vMeetingDetailVO.getMeetingRoomNames() + "%'");
			}
		}
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FROM_MEETINGDETAIL);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	/**
	 * 
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public static ArrayList<MeetingDetailVO> getMeetingDetailListForStatus(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException {

		StringBuffer strsql = new StringBuffer();
		strsql.append("select meetingDetailID,temlyMeetingID,meetingName,startTime,endTime,meetingType,notifyType,status,description,createUserID,createTime ,meetingAgenda  ");
		strsql.append(" from z_t_MeetingDetail ");
		strsql.append(" where 1=1 ");
		if (null != vMeetingDetailVO) {
	
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())) {
				strsql.append(" and status='"+ vMeetingDetailVO.getStatus() + "'");
			}
		
		}
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(MeetingDetailMQB.QUERY_FORSTATUS);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	public static ArrayList<MeetingDetailVO> getMeetingDetailWithMeetingDebug(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException{
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT detail.meetingDetailID,detail.temlyMeetingID,detail.startTime,detail.endTime,");
		strsql.append("detail.meetingType,detail.isRecord,detail.meetingLevel,detail.status,detail.notifyType,");
		strsql.append("detail.createUserID,detail.createTime,detail.description,detail.revision,detail.meetingName,detail.confProfileID,detail.meetingAgenda,");
		strsql.append("debug.debugStartTime,debug.noticeTime,debug.noticeStatus,debug.noticeType");
		strsql.append(" from z_t_MeetingDetail detail");
		strsql.append(" inner join z_t_meeting_debug debug ");
		strsql.append("on detail.meetingDetailID = debug.meetingDetailId");
		if(vMeetingDetailVO!=null){
			if(vMeetingDetailVO.getMeetingDetailID()!=null){
				strsql.append(" and detail.meetingDetailID = '"+vMeetingDetailVO.getMeetingDetailID()+"'");
			}
			if(vMeetingDetailVO.getMeetingName()!=null&&!vMeetingDetailVO.getMeetingName().equals("")){
				strsql.append(" and meetingname like '%"+vMeetingDetailVO.getMeetingName()+"%'");
			}
		
			if(vMeetingDetailVO.getMeetingStartTime()!=null && vMeetingDetailVO.getMeetingEndTime()!=null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
					strsql.append(" and startTime >= "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()) );
					strsql.append(" and endTime <= "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime()));
				}else{
					strsql.append(" and startTime >= '"+vMeetingDetailVO.getMeetingStartTime()+"'");
					strsql.append(" and endTime <= '"+vMeetingDetailVO.getMeetingEndTime()+"' ");
				}
			}
			if(vMeetingDetailVO.getMeetingStartTime()!=null && vMeetingDetailVO.getMeetingEndTime()==null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
					strsql.append(" and startTime >= "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()) );
				}else{
					strsql.append(" and startTime >= '"+vMeetingDetailVO.getMeetingStartTime()+"'");
				}
			}
			if(vMeetingDetailVO.getMeetingStartTime()==null && vMeetingDetailVO.getMeetingEndTime()!=null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
					strsql.append(" and startTime <= "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime()) );
				}else{
					strsql.append(" and endTime <= '"+vMeetingDetailVO.getMeetingEndTime()+"' ");
				}
			}
			if(vMeetingDetailVO.getMeetingDebugVO().getNoticeStatus()!=Integer.MIN_VALUE){
				strsql.append(" and debug.noticeStatus in ("+vMeetingDetailVO.getMeetingDebugVO().getNoticeStatus()+")");
			}
		}
		strsql.append(" and status not in('11')");
		strsql.append(" and meetingtype not in(1)");
		strsql.append(" order by detail.startTime DESC");
	
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(MeetingDetailMQB.QUERY_WITH_MEETINGDEBUG);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);

		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	public static List<MeetingDetailVO> getMeetingDetailAndFileList(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException {
		logger.info("DAO	getMeetingDetailAndFileList	begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT md.*,uf.uploadID");
		strsql.append(" FROM z_t_meetingDetail md LEFT JOIN");
		strsql.append(" (SELECT MIN(uploadID) uploadID,uploadKey FROM z_t_upload_file GROUP BY uploadKey) uf");
		strsql.append(" ON md.meetingDetailID = uf.uploadKey WHERE 1=1");
		
		if (null != vMeetingDetailVO) { 
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDetailID())) {
				strsql.append(" and md.meetingDetailID='" + vMeetingDetailVO.getMeetingDetailID()+"'");//meetingDetailID为字符串类型
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingID())) {
				strsql.append(" and md.temlymeetingid='" + vMeetingDetailVO.getMeetingID()+"'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingName())){
				strsql.append(" and md.meetingName like ('%" + vMeetingDetailVO.getMeetingName().trim() + "%') ");			
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingType())) {
				strsql.append(" and md.meetingType= " + vMeetingDetailVO.getMeetingType() );			
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())) {
				strsql.append(" and md.status in (" + String.valueOf(vMeetingDetailVO.getStatus()) + ")");			
			}else{
				strsql.append(" and md.status != " + MeetingStatus.INVALID + " and md.status!= " +  MeetingStatus.TEMPLATE); 
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDescription())){
				strsql.append(" and md.description= '" + vMeetingDetailVO.getMeetingDescription() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and md.createUserID= '" + vMeetingDetailVO.getCreateUserID() + "'");		
			}
			
			if(vMeetingDetailVO.getMeetingStartTime()==null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and md.startTime > to_date('2000-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')");
				}else{
					strsql.append(" and md.startTime > '2000-01-01 00:00:00.0'");
				}
			}else {
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and md.startTime > "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
				}else{
					strsql.append(" and md.startTime > '"+vMeetingDetailVO.getMeetingStartTime()+"'");
				}
			} 
			if(vMeetingDetailVO.getMeetingEndTime()==null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and  md.endTime < to_date('3000-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')");
				}else{
					strsql.append(" and  md.endTime < '3000-01-01 00:00:00.0'");
				}
			}else {
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and md.endTime <  "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime()));
				}else{
					strsql.append(" and md.endTime < '"+vMeetingDetailVO.getMeetingEndTime()+"'");
				}
			} 
		}
		strsql.append(" ORDER BY md.startTime DESC");
		
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_MEETINGDETAIL_FILE);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		logger.info("DAO	getMeetingDetailAndFileList	end");
		return vMeetingDetailMQB.getMeetingDetailList();
	}
	public static List<MeetingDetailVO> getMeetingDetailApplyList(
			MeetingDetailVO vMeetingDetailVO, UserVO loginUser,
			PageController mPageController) throws SQLException {
		logger.info("DAO	getMeetingDetailApplyList	begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT md.*,ad.checkUserIDs,ad.userId,ad.createTime adCreateTime,ad.suggestion,ad.status adStatus,u.fullName");
		strsql.append(" FROM z_t_meetingdetail md,z_t_apply_detail ad,z_t_user u");
		strsql.append(" WHERE 1=1 AND md.meetingDetailID=ad.applyDetailID AND md.createUserID=u.userID");
		if(null != loginUser){
			strsql.append(" AND (ad.checkUserIDs like '%,"+loginUser.getUserID()+",%' or ad.userId='"+loginUser.getUserID()+"')");
		}
		if (null != vMeetingDetailVO) {
			if (Integer.MIN_VALUE != vMeetingDetailVO.getApplyDetailVO().getFlowType()) {
				strsql.append(" and ad.flowType= "+vMeetingDetailVO.getApplyDetailVO().getFlowType());
			}else{
				strsql.append(" and ad.flowType in("+ApplyEnum.VIDEO_CONFERENCE+","+ApplyEnum.CONFERENCE_BOOK+")");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDetailID())) {
				strsql.append(" and md.meetingDetailID='" + vMeetingDetailVO.getMeetingDetailID()+"'");//meetingDetailID为字符串类型
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingID())) {
				strsql.append(" and md.temlymeetingid='" + vMeetingDetailVO.getMeetingID()+"'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingName())){
				strsql.append(" and md.meetingName like ('%" + vMeetingDetailVO.getMeetingName().trim() + "%') ");			
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(vMeetingDetailVO.getMeetingType())) {
				strsql.append(" and md.meetingType= " + vMeetingDetailVO.getMeetingType() );			
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getStatus())) {
				strsql.append(" and md.status in (" + String.valueOf(vMeetingDetailVO.getStatus()) + ")");			
			}else{
				strsql.append(" and md.status != " + MeetingStatus.INVALID + " and md.status!= " +  MeetingStatus.TEMPLATE); 
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getMeetingDescription())){
				strsql.append(" and md.description= '" + vMeetingDetailVO.getMeetingDescription() + "'");
			}
			if (!StringUtils.isNullOrBlank(vMeetingDetailVO.getCreateUserID())) {
				strsql.append(" and md.createUserID= '" + vMeetingDetailVO.getCreateUserID() + "'");		
			}
			
			if(vMeetingDetailVO.getMeetingStartTime()==null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and md.startTime > to_date('2000-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')");
				}else{
					strsql.append(" and md.startTime > '2000-01-01 00:00:00.0'");
				}
			}else {
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and md.startTime > "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingStartTime()));
				}else{
					strsql.append(" and md.startTime > '"+vMeetingDetailVO.getMeetingStartTime()+"'");
				}
			} 
			if(vMeetingDetailVO.getMeetingEndTime()==null){
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and  md.endTime < to_date('3000-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss')");
				}else{
					strsql.append(" and  md.endTime < '3000-01-01 00:00:00.0'");
				}
			}else {
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					strsql.append(" and md.endTime <  "+UtilDAO.oracleToDate(vMeetingDetailVO.getMeetingEndTime()));
				}else{
					strsql.append(" and md.endTime < '"+vMeetingDetailVO.getMeetingEndTime()+"'");
				}
			} 
		}
		strsql.append(" ORDER BY md.startTime DESC");
		
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_MEETINGDETAIL_APPLY);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		if (mPageController == null) {
			mPageController = new PageController();
			mPageController.setAll(true);
		}

		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		logger.info("DAO	getMeetingDetailApplyList	end");
		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	public static List<MeetingDetailVO> getMeetingDetailByTimeAndName(MeetingDetailVO meetingDetailVO,Timestamp time) throws SQLException{
		logger.info("MeetingDetailDAO	getMeetingDetailByTimeAndName	begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT meetingDetailID,temlyMeetingID,startTime,endTime,");
		strsql.append("meetingType,isRecord,meetingLevel,status,notifyType,");
		strsql.append("createUserID,createTime,description,revision,meetingName,confProfileID,meetingAgenda");
		strsql.append(" from z_t_meetingdetail");
		strsql.append(" where status='3'");
		strsql.append(" and meetingType='2'");
		if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
			strsql.append(" and startTime < "+UtilDAO.oracleToDate(time));
			strsql.append(" and endTime > "+UtilDAO.oracleToDate(time));
		}else{
			strsql.append(" and startTime < '"+time+"'");
			strsql.append(" and endTime > '"+time+"'");
		}
		if(meetingDetailVO.getMeetingName()!=null){
			strsql.append(" and meetingname = '"+meetingDetailVO.getMeetingName()+"'");
		}
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_MEETINGDETAIL_TIMEANDNAME);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		PageController mPageController = new PageController();
		mPageController.setAll(true);
		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		logger.info("DAO	getMeetingDetailByTimeAndName	end");
		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	public static ArrayList<MeetingDetailVO> queryMeetingOccupy(
			MeetingDetailVO meetingDetailVO, PageController pageController) throws SQLException {
		logger.info("MeetingDetailDAO	queryMeetingOccupy	begin");
		StringBuffer strsql = new StringBuffer();
		strsql.append("SELECT EXTRACT(YEAR FROM md.startTime) AS view_meeting_year,EXTRACT(MONTH FROM md.startTime) AS view_meeting_month,EXTRACT(DAY FROM md.startTime) AS view_meeting_day,md.*");
		strsql.append(" from z_t_meetingdetail md");
		strsql.append(" where 1=1 and md.status NOT IN ("+MeetingDetailEnum.STATUS_INVALID+","+MeetingDetailEnum.STATUS_TEMPLATE+") ");
		
		strsql.append(" ORDER BY md.createTime desc");
		
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_MEETINGDETAIL_OCCUPY);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		PageController mPageController = new PageController();
		mPageController.setAll(true);
		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		logger.info("DAO	queryMeetingOccupy	end");
		
		return vMeetingDetailMQB.getMeetingDetailList();
	}
	
	public static ArrayList<MeetingDetailVO> queryByNowDate(MeetingDetailVO vMeetingDetailVO, PageController aPageController) throws SQLException{
		StringBuffer strsql = new StringBuffer();
		strsql.append("select meetingDetailID,temlyMeetingID,meetingName,startTime,endTime,meetingType,notifyType,status,description,createUserID,createTime ,meetingAgenda  ");
		strsql.append(" from z_t_MeetingDetail ");
		strsql.append(" where 1=1 ");
		if(vMeetingDetailVO.getMeetingEndTime()!=null){
			strsql.append("and z_t_meetingdetail.endTime > '"+vMeetingDetailVO.getMeetingEndTime()+"'");
		}
		strsql.append(" order by z_t_meetingdetail.endTime ");
		MeetingDetailMQB vMeetingDetailMQB = new MeetingDetailMQB(
				MeetingDetailMQB.QUERY_FORSTATUS);
		vMeetingDetailMQB.setSql(strsql.toString());
		logger.info("query sql is :" + strsql.toString());
		PageController mPageController = new PageController();
		mPageController.setAll(true);
		QueryTemplate.executeQueryForList(vMeetingDetailMQB, mPageController);
		return vMeetingDetailMQB.getMeetingDetailList();
	}
}