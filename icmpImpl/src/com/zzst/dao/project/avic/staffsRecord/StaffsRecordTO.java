package com.zzst.dao.project.avic.staffsRecord;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.project.avic.StaffsRecordVO;

/**
 * class description: StaffsRecord TO
 * 
 * @date Fri Sep 14 18:17:43 CST 2012
 * @author ryan
 */
public class StaffsRecordTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(StaffsRecordTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_STAFFSRECORD = 1;
	public static int MODIFY_STAFFSRECORD = 2;
	public static int DEL_STAFFSRECORD = 3;
	private int result = 0;

	private StaffsRecordVO staffsRecordVO;
	private String ids = "";

	public StaffsRecordTO(int operatorType, StaffsRecordVO staffsRecordVO) {
		this.operatorType = operatorType;
		this.staffsRecordVO = staffsRecordVO;
	}

	public StaffsRecordTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_STAFFSRECORD == operatorType) {
			sqlstr.append("insert into avic_t_staffs_record ");
			sqlstr
					.append("(staffsRecordID,departmentName,departmentID,departmentNo,facsimile,meetingRoomAddressOne,peopleCountOne,meetingRoomAddressTwo,peopleCountTwo,leaderName,leaderMobile,leaderTel,technicalName,technicalMobile,technicalTel,technicalEmail,netTechnicalName,netTechnicalMobile,netTechnicalTel,netTechnicalEmail,creatPersonID,createDate,description,revision,status)");
			sqlstr
					.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(staffsRecordVO.getStaffsRecordID());
			super.addStringForField(staffsRecordVO.getDepartmentName());
			super.addStringForField(staffsRecordVO.getDepartmentID());
			super.addStringForField(staffsRecordVO.getDepartmentNo());
			super.addStringForField(staffsRecordVO.getFacsimile());
			super.addStringForField(staffsRecordVO.getMeetingRoomAddressOne());
			super.addIntForField(staffsRecordVO.getPeopleCountOne());
			super.addStringForField(staffsRecordVO.getMeetingRoomAddressTwo());
			super.addIntForField(staffsRecordVO.getPeopleCountTwo());
			super.addStringForField(staffsRecordVO.getLeaderName());
			super.addStringForField(staffsRecordVO.getLeaderMobile());
			super.addStringForField(staffsRecordVO.getLeaderTel());
			super.addStringForField(staffsRecordVO.getTechnicalName());
			super.addStringForField(staffsRecordVO.getTechnicalMobile());
			super.addStringForField(staffsRecordVO.getTechnicalTel());
			super.addStringForField(staffsRecordVO.getTechnicalEmail());
			super.addStringForField(staffsRecordVO.getNetTechnicalName());
			super.addStringForField(staffsRecordVO.getNetTechnicalMobile());
			super.addStringForField(staffsRecordVO.getNetTechnicalTel());
			super.addStringForField(staffsRecordVO.getNetTechnicalEmail());
			super.addStringForField(staffsRecordVO.getCreatPersonID());
			super.addTimestampForField(staffsRecordVO.getCreateDate());
			super.addStringForField(staffsRecordVO.getDescription());
			super.addLongForField(staffsRecordVO.getRevision());
			super.addIntForField(staffsRecordVO.getStatus());
		} else if (MODIFY_STAFFSRECORD == operatorType) {
			sqlstr.append("update  avic_t_staffs_record set ");
			sqlstr.append(" staffsRecordID = staffsRecordID ");

			if (staffsRecordVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentName=? ");
				super.addStringForField(staffsRecordVO.getDepartmentName());
			}

			if (staffsRecordVO.getDepartmentID() != null) {
				sqlstr.append(" , departmentID=? ");
				super.addStringForField(staffsRecordVO.getDepartmentID());
			}

			if (staffsRecordVO.getDepartmentNo() != null) {
				sqlstr.append(" , departmentNo=? ");
				super.addStringForField(staffsRecordVO.getDepartmentNo());
			}

			if (staffsRecordVO.getFacsimile() != null) {
				sqlstr.append(" , facsimile=? ");
				super.addStringForField(staffsRecordVO.getFacsimile());
			}

			if (staffsRecordVO.getMeetingRoomAddressOne() != null) {
				sqlstr.append(" , meetingRoomAddressOne=? ");
				super.addStringForField(staffsRecordVO
						.getMeetingRoomAddressOne());
			}

			if (staffsRecordVO.getPeopleCountOne() != Integer.MIN_VALUE) {
				sqlstr.append(" , peopleCountOne=?");
				super.addIntForField(staffsRecordVO.getPeopleCountOne());
			}

			if (staffsRecordVO.getMeetingRoomAddressTwo() != null) {
				sqlstr.append(" , meetingRoomAddressTwo=? ");
				super.addStringForField(staffsRecordVO
						.getMeetingRoomAddressTwo());
			}

			if (staffsRecordVO.getPeopleCountTwo() != Integer.MIN_VALUE) {
				sqlstr.append(" , peopleCountTwo=?");
				super.addIntForField(staffsRecordVO.getPeopleCountTwo());
			}

			if (staffsRecordVO.getLeaderName() != null) {
				sqlstr.append(" , leaderName=? ");
				super.addStringForField(staffsRecordVO.getLeaderName());
			}

			if (staffsRecordVO.getLeaderMobile() != null) {
				sqlstr.append(" , leaderMobile=? ");
				super.addStringForField(staffsRecordVO.getLeaderMobile());
			}

			if (staffsRecordVO.getLeaderTel() != null) {
				sqlstr.append(" , leaderTel=? ");
				super.addStringForField(staffsRecordVO.getLeaderTel());
			}

			if (staffsRecordVO.getTechnicalName() != null) {
				sqlstr.append(" , technicalName=? ");
				super.addStringForField(staffsRecordVO.getTechnicalName());
			}

			if (staffsRecordVO.getTechnicalMobile() != null) {
				sqlstr.append(" , technicalMobile=? ");
				super.addStringForField(staffsRecordVO.getTechnicalMobile());
			}

			if (staffsRecordVO.getTechnicalTel() != null) {
				sqlstr.append(" , technicalTel=? ");
				super.addStringForField(staffsRecordVO.getTechnicalTel());
			}

			if (staffsRecordVO.getTechnicalEmail() != null) {
				sqlstr.append(" , technicalEmail=? ");
				super.addStringForField(staffsRecordVO.getTechnicalEmail());
			}

			if (staffsRecordVO.getNetTechnicalName() != null) {
				sqlstr.append(" , netTechnicalName=? ");
				super.addStringForField(staffsRecordVO.getNetTechnicalName());
			}

			if (staffsRecordVO.getNetTechnicalMobile() != null) {
				sqlstr.append(" , netTechnicalMobile=? ");
				super.addStringForField(staffsRecordVO.getNetTechnicalMobile());
			}

			if (staffsRecordVO.getNetTechnicalTel() != null) {
				sqlstr.append(" , netTechnicalTel=? ");
				super.addStringForField(staffsRecordVO.getNetTechnicalTel());
			}

			if (staffsRecordVO.getNetTechnicalEmail() != null) {
				sqlstr.append(" , netTechnicalEmail=? ");
				super.addStringForField(staffsRecordVO.getNetTechnicalEmail());
			}

			if (staffsRecordVO.getCreatPersonID() != null) {
				sqlstr.append(" , creatPersonID=? ");
				super.addStringForField(staffsRecordVO.getCreatPersonID());
			}

			if (staffsRecordVO.getCreateDate() != null) {
				sqlstr.append(" , createDate=? ");
				super.addTimestampForField(staffsRecordVO.getCreateDate());
			}

			if (staffsRecordVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(staffsRecordVO.getDescription());
			}

			if (staffsRecordVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(staffsRecordVO.getRevision());
			}

			if (staffsRecordVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(staffsRecordVO.getStatus());
			}

			sqlstr.append(" where staffsRecordID in (?) ");
			if (staffsRecordVO.getStaffsRecordID() != null) {
				super.addStringForField(staffsRecordVO.getStaffsRecordID());
			}
		} else if (DEL_STAFFSRECORD == operatorType) {
			sqlstr.append("delete  from  avic_t_staffs_record ");
			sqlstr.append(" where staffsRecordID in (?) ");
			super.addStringForField(staffsRecordVO.getStaffsRecordID());
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
