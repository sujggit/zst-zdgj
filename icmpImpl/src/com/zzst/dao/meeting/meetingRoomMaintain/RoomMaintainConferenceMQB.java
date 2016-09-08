package com.zzst.dao.meeting.meetingRoomMaintain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.MeetingRoomMaintain;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;

/**
 * class description: MeetingRoomMaintain MQB
 * 
 * @date Wed Sep 12 09:42:15 CST 2012
 * @author ryan
 */
public class RoomMaintainConferenceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingRoomMaintainMQB.class.getName());

	public static int QUERY_FROM_ROOMMAINTAINCONFERENCE = 1;
	public static int QUERY_ROOMMAINTAIN = 2;
	
	private MeetingRoomMaintainVO meetingRoomMaintainVO;
	private ArrayList<MeetingRoomMaintainVO> listMeetingRoomMaintain = new ArrayList<MeetingRoomMaintainVO>();

	private int _operatorType = -1;
	private String ids = "";

	public RoomMaintainConferenceMQB(int operatorType,
			MeetingRoomMaintainVO meetingRoomMaintainVO) {
		_operatorType = operatorType;
		this.meetingRoomMaintainVO = meetingRoomMaintainVO;
		makeSql();
	}

	public RoomMaintainConferenceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();

		if (QUERY_FROM_ROOMMAINTAINCONFERENCE == _operatorType) {
			strsql.append("SELECT mm.*,md.meetingName,md.startTime,md.endTime,mr.meetingroomName,mmi.detailID,mmi.maintainName,mmi.status mmiStatus,mmi.questionDes,mmi.type,mmi.description mmiDescription");
			strsql.append(" FROM z_t_meetingroom_maintain mm,z_t_meetingdetail md,z_t_meetingroom mr,z_t_meetingroom_maintain_info mmi");
			strsql.append(" WHERE 1=1 AND mm.maintainKey=md.meetingDetailID AND mm.roomID=mr.meetingroomID AND mm.maintainID=mmi.maintainID");
			strsql.append(" AND mm.STATUS="+MeetingRoomMaintain.STATUS_VALID+" AND mm.maintainType="+MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
			if (null != meetingRoomMaintainVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainID())) {
					strsql.append(" and mm.maintainID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getRoomID())) {
					strsql.append(" and mm.roomID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getRoomID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainUserName())) {
					strsql.append(" and mm.maintainUserName= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainUserName());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getCreateUserID())) {
					strsql.append(" and mm.createUserID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getStatus()) {
					strsql.append(" and mm.STATUS= ? ");
					super.addIntForField(meetingRoomMaintainVO.getStatus());
				}
				if (Long.MIN_VALUE != meetingRoomMaintainVO.getRevision()) {
					strsql.append(" and mm.REVISION= ? ");
					super.addLongForField(meetingRoomMaintainVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getDescription())) {
					strsql.append(" and mm.DESCRIPTION= ? ");
					super.addStringForField(meetingRoomMaintainVO.getDescription());
				}
				
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainKey())) {
					strsql.append(" and mm.maintainKey= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainKey());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getMaintainType()) {
					strsql.append(" and mm.maintainType= ? ");
					super.addIntForField(meetingRoomMaintainVO.getMaintainType());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getProcessStatus()) {
					strsql.append(" and mm.processStatus= ? ");
					super.addIntForField(meetingRoomMaintainVO.getProcessStatus());
				}
				if(meetingRoomMaintainVO.getCreateTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and mm.createTime>="+UtilDAO.oracleToDate(meetingRoomMaintainVO.getCreateTime()));
					}else{
						strsql.append(" and mm.createTime>= ? ");
						super.addTimestampForField(meetingRoomMaintainVO.getCreateTime());
					}
				}
				if(meetingRoomMaintainVO.getEndTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and mm.createTime<="+UtilDAO.oracleToDate(meetingRoomMaintainVO.getEndTime()));
					}else{
						strsql.append(" and mm.createTime<= ? ");
						super.addTimestampForField(meetingRoomMaintainVO.getEndTime());
					}
				}//检查起止时间
				
				if(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingStartTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and md.startTime>="+UtilDAO.oracleToDate(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingStartTime()));
					}else{
						strsql.append(" and md.startTime>= ? ");
						super.addTimestampForField(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingStartTime());
					}
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingName())) {
					strsql.append(" and md.meetingName like '%"+meetingRoomMaintainVO.getMeetingDetailVO().getMeetingName().trim()+"%'");
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getMaintainName())) {
					strsql.append(" and mmi.maintainName= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getMaintainName());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDescription())) {
					strsql.append(" and mmi.description= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDescription());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDetailID())) {
					strsql.append(" and mmi.detailID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDetailID());
				}
			}
			strsql.append(" order by mm.createTime desc");
		}else if(QUERY_ROOMMAINTAIN == _operatorType){
			strsql.append("SELECT mm.*,md.meetingName,md.startTime,md.endTime,mr.meetingroomName,mmi.detailID,mmi.maintainName,mmi.status mmiStatus,mmi.questionDes,mmi.type,mmi.description mmiDescription");
			strsql.append(" FROM z_t_meetingroom_maintain mm ");
			strsql.append(" LEFT JOIN z_t_meetingdetail md ON mm.maintainKey=md.meetingDetailID ");
			strsql.append(" LEFT JOIN z_t_meetingroom mr ON mm.roomID = mr.meetingroomID ");
			strsql.append(" LEFT JOIN z_t_meetingroom_maintain_info mmi ON mm.maintainID = mmi.maintainID ");
			strsql.append(" WHERE");
			strsql.append(" mm.STATUS="+MeetingRoomMaintain.STATUS_VALID+" AND mm.maintainType="+MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
			if (null != meetingRoomMaintainVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainID())) {
					strsql.append(" and mm.maintainID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getRoomID())) {
					strsql.append(" and mm.roomID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getRoomID());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainUserName())) {
					strsql.append(" and mm.maintainUserName= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainUserName());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getCreateUserID())) {
					strsql.append(" and mm.createUserID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getStatus()) {
					strsql.append(" and mm.STATUS= ? ");
					super.addIntForField(meetingRoomMaintainVO.getStatus());
				}
				if (Long.MIN_VALUE != meetingRoomMaintainVO.getRevision()) {
					strsql.append(" and mm.REVISION= ? ");
					super.addLongForField(meetingRoomMaintainVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getDescription())) {
					strsql.append(" and mm.DESCRIPTION= ? ");
					super.addStringForField(meetingRoomMaintainVO.getDescription());
				}
				
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMaintainKey())) {
					strsql.append(" and mm.maintainKey= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMaintainKey());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getMaintainType()) {
					strsql.append(" and mm.maintainType= ? ");
					super.addIntForField(meetingRoomMaintainVO.getMaintainType());
				}
				if (Integer.MIN_VALUE != meetingRoomMaintainVO.getProcessStatus()) {
					strsql.append(" and mm.processStatus= ? ");
					super.addIntForField(meetingRoomMaintainVO.getProcessStatus());
				}
				if(meetingRoomMaintainVO.getCreateTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and mm.createTime>="+UtilDAO.oracleToDate(meetingRoomMaintainVO.getCreateTime()));
					}else{
						strsql.append(" and mm.createTime>= ? ");
						super.addTimestampForField(meetingRoomMaintainVO.getCreateTime());
					}
				}
				if(meetingRoomMaintainVO.getEndTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and mm.createTime<="+UtilDAO.oracleToDate(meetingRoomMaintainVO.getEndTime()));
					}else{
						strsql.append(" and mm.createTime<= ? ");
						super.addTimestampForField(meetingRoomMaintainVO.getEndTime());
					}
				}//检查起止时间
				
				if(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingStartTime()!=null){
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and md.startTime>="+UtilDAO.oracleToDate(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingStartTime()));
					}else{
						strsql.append(" and md.startTime>= ? ");
						super.addTimestampForField(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingStartTime());
					}
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingDetailVO().getMeetingName())) {
					strsql.append(" and md.meetingName like '%"+meetingRoomMaintainVO.getMeetingDetailVO().getMeetingName().trim()+"%'");
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getMaintainName())) {
					strsql.append(" and mmi.maintainName= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getMaintainName());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDescription())) {
					strsql.append(" and mmi.description= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDescription());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDetailID())) {
					strsql.append(" and mmi.detailID= ? ");
					super.addStringForField(meetingRoomMaintainVO.getMeetingRoomMaintainDetailVO().getDetailID());
				}
			}
			strsql.append(" GROUP BY mm.maintainKey,mm.roomID order by mm.createTime desc");
			
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		meetingRoomMaintainVO = new MeetingRoomMaintainVO();
		MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		meetingRoomMaintainVO.setMaintainID(rs.getString("maintainID"));
		meetingRoomMaintainVO.setRoomID(rs.getString("roomID"));
		meetingRoomMaintainVO.setMaintainUserName(rs.getString("maintainUserName"));
		meetingRoomMaintainVO.setCreateUserID(rs.getString("createUserID"));
		meetingRoomMaintainVO.setCreateTime(rs.getTimestamp("createTime"));
		meetingRoomMaintainVO.setStatus(rs.getInt("status"));
		meetingRoomMaintainVO.setRevision(rs.getLong("REVISION"));
		meetingRoomMaintainVO.setDescription(rs.getString("description"));
		meetingRoomMaintainVO.setMaintainKey(rs.getString("maintainKey"));
		meetingRoomMaintainVO.setMaintainType(rs.getInt("maintainType"));
		meetingRoomMaintainVO.setProcessStatus(rs.getInt("processStatus"));
		meetingRoomMaintainVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingroomName"));
		
		meetingDetailVO.setMeetingName(rs.getString("meetingName"));
		meetingDetailVO.setMeetingStartTime(rs.getTimestamp("startTime"));
		meetingDetailVO.setMeetingEndTime(rs.getTimestamp("endTime"));
		meetingRoomMaintainVO.setMeetingDetailVO(meetingDetailVO);
		meetingRoomMaintainDetailVO.setDetailID(rs.getString("detailID"));
		meetingRoomMaintainDetailVO.setMaintainName(rs.getString("maintainName"));
		meetingRoomMaintainDetailVO.setType(rs.getInt("type"));
		meetingRoomMaintainDetailVO.setDescription(rs.getString("mmiDescription"));
		meetingRoomMaintainDetailVO.setStatus(rs.getInt("mmiStatus"));
		meetingRoomMaintainDetailVO.setQuestionDes(rs.getString("questionDes"));
		meetingRoomMaintainVO.setMeetingRoomMaintainDetailVO(meetingRoomMaintainDetailVO);
		
		listMeetingRoomMaintain.add(meetingRoomMaintainVO);
	}

	public ArrayList<MeetingRoomMaintainVO> getMeetingRoomMaintainList() {
		return listMeetingRoomMaintain;
	}

	public MeetingRoomMaintainVO getMeetingRoomMaintainVO() {
		return meetingRoomMaintainVO;
	}

}
