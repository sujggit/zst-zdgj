package com.zzst.dao.meeting.meetingDetailEquipment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;

/**
 * class description: MeetingDetailEquipment TO
 * 
 * @date Thu May 08 17:42:44 CST 2014
 * @author ryan
 */
public class MeetingDetailEquipmentTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(MeetingDetailEquipmentTO.class.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGDETAILEQUIPMENT = 1;
	public static int MODIFY_MEETINGDETAILEQUIPMENT = 2;
	public static int DEL_MEETINGDETAILEQUIPMENT = 3;
	private int result = 0;

	private MeetingDetailEquipmentVO meetingDetailEquipmentVO;

	public MeetingDetailEquipmentTO(int operatorType,
			MeetingDetailEquipmentVO meetingDetailEquipmentVO) {
		this.operatorType = operatorType;
		this.meetingDetailEquipmentVO = meetingDetailEquipmentVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGDETAILEQUIPMENT == operatorType) {
			sqlstr.append("insert into z_t_meetingdetail_equipment ");
			sqlstr.append("(id,equipmentID,meetingDetailID,equipmentNo,equipmentIP,equipmentNumber,equipmentTel,audioAgreementType,roomID,cascadeID,createUserID,description,equipmentType,speed,count,status,createDate,videoAgreementType,agc,cascadeRole,maxPesolution,aliasType,aliasName,dialingDirection,dialingType,confProfileID,mainEquipment)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(meetingDetailEquipmentVO.getId());
			super.addStringForField(meetingDetailEquipmentVO.getEquipmentID());
			super.addStringForField(meetingDetailEquipmentVO
					.getMeetingDetailID());
			super.addStringForField(meetingDetailEquipmentVO.getEquipmentNo());
			super.addStringForField(meetingDetailEquipmentVO.getEquipmentIP());
			super.addStringForField(meetingDetailEquipmentVO
					.getEquipmentNumber());
			super.addStringForField(meetingDetailEquipmentVO.getEquipmentTel());
			super.addStringForField(meetingDetailEquipmentVO
					.getAudioAgreementType());
			super.addStringForField(meetingDetailEquipmentVO.getRoomID());
			super.addStringForField(meetingDetailEquipmentVO.getCascadeID());
			super.addStringForField(meetingDetailEquipmentVO.getCreateUserID());
			super.addStringForField(meetingDetailEquipmentVO.getDescription());
			super.addIntForField(meetingDetailEquipmentVO.getEquipmentType());
			super.addStringForField(meetingDetailEquipmentVO.getSpeed());
			super.addIntForField(meetingDetailEquipmentVO.getCount());
			super.addIntForField(meetingDetailEquipmentVO.getStatus());
			super.addTimestampForField(meetingDetailEquipmentVO.getCreateDate());
			super.addStringForField(meetingDetailEquipmentVO
					.getVideoAgreementType());
			super.addStringForField(meetingDetailEquipmentVO.getAgc());
			super.addStringForField(meetingDetailEquipmentVO.getCascadeRole());
			super.addStringForField(meetingDetailEquipmentVO.getMaxPesolution());
			super.addStringForField(meetingDetailEquipmentVO.getAliasType());
			super.addStringForField(meetingDetailEquipmentVO.getAliasName());
			super.addStringForField(meetingDetailEquipmentVO
					.getDialingDirection());
			super.addStringForField(meetingDetailEquipmentVO.getDialingType());
			super.addStringForField(meetingDetailEquipmentVO.getConfProfileID());
			super.addIntForField(meetingDetailEquipmentVO.getMainEquipment());
		} else if (MODIFY_MEETINGDETAILEQUIPMENT == operatorType) {
			sqlstr.append("update  z_t_meetingdetail_equipment set ");
			sqlstr.append(" id = id ");

			if (meetingDetailEquipmentVO.getEquipmentID() != null) {
				sqlstr.append(" , equipmentID=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getEquipmentID());
			}

			if (meetingDetailEquipmentVO.getMeetingDetailID() != null) {
				sqlstr.append(" , meetingDetailID=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getMeetingDetailID());
			}

			if (meetingDetailEquipmentVO.getEquipmentNo() != null) {
				sqlstr.append(" , equipmentNo=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getEquipmentNo());
			}

			if (meetingDetailEquipmentVO.getEquipmentIP() != null) {
				sqlstr.append(" , equipmentIP=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getEquipmentIP());
			}

			if (meetingDetailEquipmentVO.getEquipmentNumber() != null) {
				sqlstr.append(" , equipmentNumber=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getEquipmentNumber());
			}

			if (meetingDetailEquipmentVO.getEquipmentTel() != null) {
				sqlstr.append(" , equipmentTel=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getEquipmentTel());
			}

			if (meetingDetailEquipmentVO.getAudioAgreementType() != null) {
				sqlstr.append(" , audioAgreementType=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getAudioAgreementType());
			}

			if (meetingDetailEquipmentVO.getRoomID() != null) {
				sqlstr.append(" , roomID=? ");
				super.addStringForField(meetingDetailEquipmentVO.getRoomID());
			}

			if (meetingDetailEquipmentVO.getCascadeID() != null) {
				sqlstr.append(" , cascadeID=? ");
				super.addStringForField(meetingDetailEquipmentVO.getCascadeID());
			}

			if (meetingDetailEquipmentVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getCreateUserID());
			}

			if (meetingDetailEquipmentVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getDescription());
			}

			if (meetingDetailEquipmentVO.getEquipmentType() != Integer.MIN_VALUE) {
				sqlstr.append(" , equipmentType=?");
				super.addIntForField(meetingDetailEquipmentVO
						.getEquipmentType());
			}

			if (!StringUtils.isNullOrBlank(meetingDetailEquipmentVO
					.getSpeed())) {
				sqlstr.append(" , speed=?");
				super.addStringForField(meetingDetailEquipmentVO.getSpeed());
			}

			if (meetingDetailEquipmentVO.getCount() != Integer.MIN_VALUE) {
				sqlstr.append(" , count=?");
				super.addIntForField(meetingDetailEquipmentVO.getCount());
			}

			if (meetingDetailEquipmentVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(meetingDetailEquipmentVO.getStatus());
			}

			if (meetingDetailEquipmentVO.getCreateDate() != null) {
				sqlstr.append(" , createDate=? ");
				super.addTimestampForField(meetingDetailEquipmentVO
						.getCreateDate());
			}

			if (meetingDetailEquipmentVO.getVideoAgreementType() != null) {
				sqlstr.append(" , videoAgreementType=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getVideoAgreementType());
			}

			if (meetingDetailEquipmentVO.getAgc() != null) {
				sqlstr.append(" , agc=? ");
				super.addStringForField(meetingDetailEquipmentVO.getAgc());
			}

			if (meetingDetailEquipmentVO.getCascadeRole() != null) {
				sqlstr.append(" , cascadeRole=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getCascadeRole());
			}

			if (meetingDetailEquipmentVO.getMaxPesolution() != null) {
				sqlstr.append(" , maxPesolution=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getMaxPesolution());
			}

			if (meetingDetailEquipmentVO.getAliasType() != null) {
				sqlstr.append(" , aliasType=? ");
				super.addStringForField(meetingDetailEquipmentVO.getAliasType());
			}

			if (meetingDetailEquipmentVO.getAliasName() != null) {
				sqlstr.append(" , aliasName=? ");
				super.addStringForField(meetingDetailEquipmentVO.getAliasName());
			}

			if (meetingDetailEquipmentVO.getDialingDirection() != null) {
				sqlstr.append(" , dialingDirection=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getDialingDirection());
			}

			if (meetingDetailEquipmentVO.getDialingType() != null) {
				sqlstr.append(" , dialingType=? ");
				super.addStringForField(meetingDetailEquipmentVO
						.getDialingType());
			}
			if (meetingDetailEquipmentVO.getMainEquipment() != Integer.MIN_VALUE) {
				sqlstr.append(" , mainEquipment=? ");
				super.addIntForField(meetingDetailEquipmentVO.getMainEquipment());
			}
			
			sqlstr.append(" where id = ? ");
			if (meetingDetailEquipmentVO.getId() != null) {
				super.addStringForField(meetingDetailEquipmentVO.getId());
			}
		} else if (DEL_MEETINGDETAILEQUIPMENT == operatorType) {
			sqlstr.append("delete  from  z_t_meetingdetail_equipment where ");
			String[] idArray = meetingDetailEquipmentVO.getId().split(",");
			for (int i = 0; i < idArray.length; i++) {
				if (i != 0)
					sqlstr.append(" or ");
				sqlstr.append(" id = '" + idArray[i] + "'");
			}
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setValues() throws SQLException {

	}

	public void execute() throws SQLException {
		result = this.stmt.executeUpdate();
	}

	public int getexecuteResult() {
		return result;
	}

}
