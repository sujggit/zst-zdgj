package com.zzst.dao.meeting.meetingDetailEquipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;

/**
 * class description: MeetingDetailEquipment MQB
 * 
 * @date Thu May 08 17:42:44 CST 2014
 * @author ryan
 */
public class MeetingDetailEquipmentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(MeetingDetailEquipmentMQB.class
			.getName());

	public static int QUERY_FROM_MEETINGDETAILEQUIPMENT = 1;
	public static int QUERY_FROM_MEETINGDETAILEQUIPMENT_BY_IDS = 2;
	public static int QUERY_FROM_MEETINGDETAILEQUIPMENT_BY_FUZZYSEARCH = 3;
	
	public static int QUERY_FROM_MEETINGDETAILEQUIPMENT_NEW = 4;

	private MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
	private ArrayList<MeetingDetailEquipmentVO> listMeetingDetailEquipment = new ArrayList<MeetingDetailEquipmentVO>();

	private int _operatorType = -1;

	public MeetingDetailEquipmentMQB(int operatorType,
			MeetingDetailEquipmentVO meetingDetailEquipmentVO) {
		_operatorType = operatorType;
		this.meetingDetailEquipmentVO = meetingDetailEquipmentVO;
		makeSql();
	}

	private void makeSql() {
		

		if (QUERY_FROM_MEETINGDETAILEQUIPMENT == _operatorType) {
			StringBuffer strsql = new StringBuffer();
			strsql.append("select id,equipmentID,meetingDetailID,equipmentNo,equipmentIP,equipmentNumber,equipmentTel,audioAgreementType,roomID,cascadeID,createUserID,description,equipmentType,speed,count,status,createDate,videoAgreementType,agc,cascadeRole,maxPesolution,aliasType,aliasName,dialingDirection,dialingType,confProfileID,mainEquipment ");
			strsql.append(" from z_t_meetingdetail_equipment ");
			strsql.append(" where 1=1 ");
			if (null != meetingDetailEquipmentVO) {
				if (!StringUtils
						.isNullOrBlank(meetingDetailEquipmentVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(meetingDetailEquipmentVO.getId());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getMeetingDetailID())) {
					strsql.append(" and meetingDetailID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentNo())) {
					strsql.append(" and equipmentNo= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentNo());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentIP())) {
					strsql.append(" and equipmentIP= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentIP());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentNumber())) {
					strsql.append(" and equipmentNumber= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentNumber());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentTel())) {
					strsql.append(" and equipmentTel= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentTel());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAudioAgreementType())) {
					strsql.append(" and audioAgreementType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getAudioAgreementType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getRoomID())) {
					strsql.append(" and roomID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getRoomID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getCascadeID())) {
					strsql.append(" and cascadeID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getCascadeID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getDescription());
				}
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO.getMainEquipment()) {
					strsql.append(" and mainEquipment= ? ");
					super.addIntForField(meetingDetailEquipmentVO
							.getMainEquipment());
				}
				
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO
						.getEquipmentType()) {
					strsql.append(" and equipmentType= ? ");
					super.addIntForField(meetingDetailEquipmentVO
							.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getSpeed())) {
					strsql.append(" and speed= ? ");
					super.addStringForField(meetingDetailEquipmentVO.getSpeed());
				}
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO.getCount()) {
					strsql.append(" and count= ? ");
					super.addIntForField(meetingDetailEquipmentVO.getCount());
				}
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(meetingDetailEquipmentVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getVideoAgreementType())) {
					strsql.append(" and videoAgreementType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getVideoAgreementType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAgc())) {
					strsql.append(" and agc= ? ");
					super.addStringForField(meetingDetailEquipmentVO.getAgc());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getCascadeRole())) {
					strsql.append(" and cascadeRole= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getCascadeRole());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getMaxPesolution())) {
					strsql.append(" and maxPesolution= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getMaxPesolution());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAliasType())) {
					strsql.append(" and aliasType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getAliasType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAliasName())) {
					strsql.append(" and aliasName= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getAliasName());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getDialingDirection())) {
					strsql.append(" and dialingDirection= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getDialingDirection());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getDialingType())) {
					strsql.append(" and dialingType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getDialingType());
				}
				
			}
			
			setSql(strsql.toString());
		} else if (QUERY_FROM_MEETINGDETAILEQUIPMENT_BY_IDS == _operatorType) {
			StringBuffer strsql = new StringBuffer();
			strsql.append("select id,equipmentID,meetingDetailID,equipmentNo,equipmentIP,equipmentNumber,equipmentTel,audioAgreementType,roomID,cascadeID,createUserID,description,equipmentType,speed,count,status,createDate,videoAgreementType,agc,cascadeRole,maxPesolution,aliasType,aliasName,dialingDirection,dialingType,confProfileID,mainEquipment ");
			strsql.append(" from z_t_meetingdetail_equipment ");
			strsql.append(" where 1=1 ");
			String[] idArray = meetingDetailEquipmentVO.getId().split(",");
			strsql.append(" and ( ");
			for (int i = 0; i < idArray.length; i++) {
				if (i != 0)
					strsql.append(" or ");
				strsql.append(" id = '" + idArray[i] + "'");
			}
			strsql.append(" ) ");
			setSql(strsql.toString());
		} else if (QUERY_FROM_MEETINGDETAILEQUIPMENT_NEW == _operatorType) {
			StringBuffer strsql = new StringBuffer();
			strsql.append("select t.id,t.equipmentID,t.meetingDetailID,t.equipmentNo,t.equipmentIP,t.equipmentNumber,t.equipmentTel,t.audioAgreementType,t.roomID,t.cascadeID,t.createUserID,t.description,t.equipmentType,t.speed,t.count,t.status,t.createDate,t.videoAgreementType,t.agc,t.cascadeRole,t.maxPesolution,t.aliasType,t.aliasName,t.dialingDirection,t.dialingType,t.confProfileID,t.mainEquipment,m.meetingName,m.startTime,m.endTime,m.status meetingStatus ");
			strsql.append(" from z_t_meetingdetail_equipment t");
			strsql.append(" INNER JOIN z_t_meetingdetail m ON m.meetingDetailID = t.meetingDetailID");
			strsql.append(" where 1=1 ");
			if (null != meetingDetailEquipmentVO) {
				if (!StringUtils
						.isNullOrBlank(meetingDetailEquipmentVO.getId())) {
					strsql.append(" and t.id= ? ");
					super.addStringForField(meetingDetailEquipmentVO.getId());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentID())) {
					strsql.append(" and t.equipmentID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getMeetingDetailID())) {
					strsql.append(" and t.meetingDetailID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getMeetingDetailID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentNo())) {
					strsql.append(" and t.equipmentNo= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentNo());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentIP())) {
					strsql.append(" and t.equipmentIP= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentIP());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentNumber())) {
					strsql.append(" and t.equipmentNumber= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentNumber());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getEquipmentTel())) {
					strsql.append(" and t.equipmentTel= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getEquipmentTel());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAudioAgreementType())) {
					strsql.append(" and t.audioAgreementType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getAudioAgreementType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getRoomID())) {
					strsql.append(" and t.roomID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getRoomID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getCascadeID())) {
					strsql.append(" and t.cascadeID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getCascadeID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getCreateUserID())) {
					strsql.append(" and t.createUserID= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getCreateUserID());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getDescription())) {
					strsql.append(" and t.description= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getDescription());
				}
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO.getMainEquipment()) {
					strsql.append(" and t.mainEquipment= ? ");
					super.addIntForField(meetingDetailEquipmentVO
							.getMainEquipment());
				}
				
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO
						.getEquipmentType()) {
					strsql.append(" and t.equipmentType= ? ");
					super.addIntForField(meetingDetailEquipmentVO
							.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getSpeed())) {
					strsql.append(" and t.speed= ? ");
					super.addStringForField(meetingDetailEquipmentVO.getSpeed());
				}
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO.getCount()) {
					strsql.append(" and t.count= ? ");
					super.addIntForField(meetingDetailEquipmentVO.getCount());
				}
				if (Integer.MIN_VALUE != meetingDetailEquipmentVO.getStatus()) {
					strsql.append(" and t.status= ? ");
					super.addIntForField(meetingDetailEquipmentVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getVideoAgreementType())) {
					strsql.append(" and t.videoAgreementType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getVideoAgreementType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAgc())) {
					strsql.append(" and t.agc= ? ");
					super.addStringForField(meetingDetailEquipmentVO.getAgc());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getCascadeRole())) {
					strsql.append(" and t.cascadeRole= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getCascadeRole());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getMaxPesolution())) {
					strsql.append(" and t.maxPesolution= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getMaxPesolution());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAliasType())) {
					strsql.append(" and t.aliasType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getAliasType());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getAliasName())) {
					strsql.append(" and t.aliasName= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getAliasName());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getDialingDirection())) {
					strsql.append(" and t.dialingDirection= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getDialingDirection());
				}
				if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
						.getDialingType())) {
					strsql.append(" and t.dialingType= ? ");
					super.addStringForField(meetingDetailEquipmentVO
							.getDialingType());
				}
				Timestamp now = new Timestamp(System.currentTimeMillis());
				strsql.append(" and ((m.startTime>='"+now+"'");
				strsql.append(" and m.endTime>='"+now+"'");
				strsql.append(" and m.status!="+MeetingStatus.INVALID+")");
				strsql.append(" or (m.startTime<='"+now+"'");
				strsql.append(" and m.endTime>='"+now+"'");
				strsql.append(" and m.status!="+MeetingStatus.INVALID+"))");
				strsql.append(" and t.status!="+MeetingDetailEquipmentVO.INVALID);
				strsql.append(" and m.status!="+MeetingStatus.TEMPLATE);
			}
			setSql(strsql.toString());
		}
		
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_FROM_MEETINGDETAILEQUIPMENT == _operatorType) {
		meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
		meetingDetailEquipmentVO.setId(rs.getString("id"));
		meetingDetailEquipmentVO.setEquipmentID(rs.getString("equipmentID"));
		meetingDetailEquipmentVO.setMeetingDetailID(rs
				.getString("meetingDetailID"));
		meetingDetailEquipmentVO.setEquipmentNo(rs.getString("equipmentNo"));
		meetingDetailEquipmentVO.setEquipmentIP(rs.getString("equipmentIP"));
		meetingDetailEquipmentVO.setEquipmentNumber(rs
				.getString("equipmentNumber"));
		meetingDetailEquipmentVO.setEquipmentTel(rs.getString("equipmentTel"));
		meetingDetailEquipmentVO.setAudioAgreementType(rs
				.getString("audioAgreementType"));
		meetingDetailEquipmentVO.setRoomID(rs.getString("roomID"));
		meetingDetailEquipmentVO.setCascadeID(rs.getString("cascadeID"));
		meetingDetailEquipmentVO.setCreateUserID(rs.getString("createUserID"));
		meetingDetailEquipmentVO.setDescription(rs.getString("description"));
		meetingDetailEquipmentVO.setEquipmentType(rs.getInt("equipmentType"));
		meetingDetailEquipmentVO.setSpeed(rs.getString("speed"));
		meetingDetailEquipmentVO.setCount(rs.getInt("count"));
		meetingDetailEquipmentVO.setStatus(rs.getInt("status"));
		meetingDetailEquipmentVO.setCreateDate(rs.getTimestamp("createDate"));
		meetingDetailEquipmentVO.setVideoAgreementType(rs
				.getString("videoAgreementType"));
		meetingDetailEquipmentVO.setAgc(rs.getString("agc"));
		meetingDetailEquipmentVO.setCascadeRole(rs.getString("cascadeRole"));
		meetingDetailEquipmentVO
				.setMaxPesolution(rs.getString("maxPesolution"));
		meetingDetailEquipmentVO.setAliasType(rs.getString("aliasType"));
		meetingDetailEquipmentVO.setAliasName(rs.getString("aliasName"));
		meetingDetailEquipmentVO.setDialingDirection(rs
				.getString("dialingDirection"));
		meetingDetailEquipmentVO.setDialingType(rs.getString("dialingType"));
		meetingDetailEquipmentVO.setConfProfileID(rs.getString("confProfileID"));
		meetingDetailEquipmentVO.setMainEquipment(rs.getInt("mainEquipment"));
		
		listMeetingDetailEquipment.add(meetingDetailEquipmentVO);
		}else if (QUERY_FROM_MEETINGDETAILEQUIPMENT_NEW == _operatorType) {
			meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
			meetingDetailEquipmentVO.setId(rs.getString("id"));
			meetingDetailEquipmentVO.setEquipmentID(rs.getString("equipmentID"));
			meetingDetailEquipmentVO.setMeetingDetailID(rs
					.getString("meetingDetailID"));
			meetingDetailEquipmentVO.setEquipmentNo(rs.getString("equipmentNo"));
			meetingDetailEquipmentVO.setEquipmentIP(rs.getString("equipmentIP"));
			meetingDetailEquipmentVO.setEquipmentNumber(rs
					.getString("equipmentNumber"));
			meetingDetailEquipmentVO.setEquipmentTel(rs.getString("equipmentTel"));
			meetingDetailEquipmentVO.setAudioAgreementType(rs
					.getString("audioAgreementType"));
			meetingDetailEquipmentVO.setRoomID(rs.getString("roomID"));
			meetingDetailEquipmentVO.setCascadeID(rs.getString("cascadeID"));
			meetingDetailEquipmentVO.setCreateUserID(rs.getString("createUserID"));
			meetingDetailEquipmentVO.setDescription(rs.getString("description"));
			meetingDetailEquipmentVO.setEquipmentType(rs.getInt("equipmentType"));
			meetingDetailEquipmentVO.setSpeed(rs.getString("speed"));
			meetingDetailEquipmentVO.setCount(rs.getInt("count"));
			meetingDetailEquipmentVO.setStatus(rs.getInt("status"));
			meetingDetailEquipmentVO.setCreateDate(rs.getTimestamp("createDate"));
			meetingDetailEquipmentVO.setVideoAgreementType(rs
					.getString("videoAgreementType"));
			meetingDetailEquipmentVO.setAgc(rs.getString("agc"));
			meetingDetailEquipmentVO.setCascadeRole(rs.getString("cascadeRole"));
			meetingDetailEquipmentVO
					.setMaxPesolution(rs.getString("maxPesolution"));
			meetingDetailEquipmentVO.setAliasType(rs.getString("aliasType"));
			meetingDetailEquipmentVO.setAliasName(rs.getString("aliasName"));
			meetingDetailEquipmentVO.setDialingDirection(rs
					.getString("dialingDirection"));
			meetingDetailEquipmentVO.setDialingType(rs.getString("dialingType"));
			meetingDetailEquipmentVO.setConfProfileID(rs.getString("confProfileID"));
			meetingDetailEquipmentVO.setMainEquipment(rs.getInt("mainEquipment"));
			
			meetingDetailEquipmentVO.setMeetingStartTime(rs.getTimestamp("startTime"));
			meetingDetailEquipmentVO.setMeetingEndTime(rs.getTimestamp("endTime"));
			meetingDetailEquipmentVO.setMeetingName(rs.getString("meetingName"));
			
			listMeetingDetailEquipment.add(meetingDetailEquipmentVO);
		}
	}

	public ArrayList<MeetingDetailEquipmentVO> getMeetingDetailEquipmentList() {
		return listMeetingDetailEquipment;
	}

	public MeetingDetailEquipmentVO getMeetingDetailEquipmentVO() {
		return meetingDetailEquipmentVO;
	}

}
