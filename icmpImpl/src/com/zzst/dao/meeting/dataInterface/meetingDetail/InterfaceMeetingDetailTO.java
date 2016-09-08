package com.zzst.dao.meeting.dataInterface.meetingDetail;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailVO;

/**
 * class description: InterfaceMeetingDetail TO
 * 
 * @date Thu May 30 11:03:50 CST 2013
 * @author ryan
 */
public class InterfaceMeetingDetailTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(InterfaceMeetingDetailTO.class.getName());
	private int operatorType = -1;

	public static int ADD_INTERFACEMEETINGDETAIL = 1;
	public static int MODIFY_INTERFACEMEETINGDETAIL = 2;
	public static int DEL_INTERFACEMEETINGDETAIL = 3;
	private int result = 0;

	private InterfaceMeetingDetailVO interfaceMeetingDetailVO;

	public InterfaceMeetingDetailTO(int operatorType, InterfaceMeetingDetailVO interfaceMeetingDetailVO) {
		this.operatorType = operatorType;
		this.interfaceMeetingDetailVO = interfaceMeetingDetailVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_INTERFACEMEETINGDETAIL == operatorType) {
			sqlstr.append("insert into z_interface_in_meetingdetail ");
			sqlstr
					.append("(id,meetingname,starttime,endtime,meetingType,isRecord,meetingLevel,meetingStatus,notifyType,createUserName,createTime,roomNos,confProfileID,modelID,status,description,ref1,ref2,mainroomno)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(interfaceMeetingDetailVO.getId());
			super.addStringForField(interfaceMeetingDetailVO.getMeetingname());
			super.addTimestampForField(interfaceMeetingDetailVO.getStarttime());
			super.addTimestampForField(interfaceMeetingDetailVO.getEndtime());
			super.addIntForField(interfaceMeetingDetailVO.getMeetingType());
			super.addIntForField(interfaceMeetingDetailVO.getIsRecord());
			super.addIntForField(interfaceMeetingDetailVO.getLevel());
			super.addIntForField(interfaceMeetingDetailVO.getMeetingStatus());
			super.addIntForField(interfaceMeetingDetailVO.getNotifyType());
			super.addStringForField(interfaceMeetingDetailVO.getCreateUserName());
			super.addTimestampForField(interfaceMeetingDetailVO.getCreateTime());
			super.addStringForField(interfaceMeetingDetailVO.getRoomNos());
			super.addStringForField(interfaceMeetingDetailVO.getConfProfileID());
			super.addStringForField(interfaceMeetingDetailVO.getModelID());
			super.addIntForField(interfaceMeetingDetailVO.getStatus());
			super.addStringForField(interfaceMeetingDetailVO.getDescription());
			super.addStringForField(interfaceMeetingDetailVO.getRef1());
			super.addStringForField(interfaceMeetingDetailVO.getRef2());
			super.addStringForField(interfaceMeetingDetailVO.getMainRoomNO());
		} else if (MODIFY_INTERFACEMEETINGDETAIL == operatorType) {
			sqlstr.append("update  z_interface_in_meetingdetail set ");
			sqlstr.append(" id = id ");

			if (interfaceMeetingDetailVO.getMeetingname() != null) {
				sqlstr.append(" , meetingname=? ");
				super.addStringForField(interfaceMeetingDetailVO.getMeetingname());
			}

			if (interfaceMeetingDetailVO.getStarttime() != null) {
				sqlstr.append(" , starttime=? ");
				super.addTimestampForField(interfaceMeetingDetailVO.getStarttime());
			}

			if (interfaceMeetingDetailVO.getEndtime() != null) {
				sqlstr.append(" , endtime=? ");
				super.addTimestampForField(interfaceMeetingDetailVO.getEndtime());
			}

			if (interfaceMeetingDetailVO.getMeetingType() != Integer.MIN_VALUE) {
				sqlstr.append(" , meetingType=?");
				super.addIntForField(interfaceMeetingDetailVO.getMeetingType());
			}

			if (interfaceMeetingDetailVO.getIsRecord() != Integer.MIN_VALUE) {
				sqlstr.append(" , isRecord=?");
				super.addIntForField(interfaceMeetingDetailVO.getIsRecord());
			}

			if (interfaceMeetingDetailVO.getLevel() != Integer.MIN_VALUE) {
				sqlstr.append(" , meetingLevel=?");
				super.addIntForField(interfaceMeetingDetailVO.getLevel());
			}

			if (interfaceMeetingDetailVO.getMeetingStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , meetingStatus=?");
				super.addIntForField(interfaceMeetingDetailVO.getMeetingStatus());
			}

			if (interfaceMeetingDetailVO.getNotifyType() != Integer.MIN_VALUE) {
				sqlstr.append(" , notifyType=?");
				super.addIntForField(interfaceMeetingDetailVO.getNotifyType());
			}

			if (interfaceMeetingDetailVO.getCreateUserName() != null) {
				sqlstr.append(" , createUserName=? ");
				super.addStringForField(interfaceMeetingDetailVO.getCreateUserName());
			}

			if (interfaceMeetingDetailVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(interfaceMeetingDetailVO.getCreateTime());
			}

			if (interfaceMeetingDetailVO.getRoomNos() != null) {
				sqlstr.append(" , roomNos=? ");
				super.addStringForField(interfaceMeetingDetailVO.getRoomNos());
			}

			if (interfaceMeetingDetailVO.getConfProfileID() != null) {
				sqlstr.append(" , confProfileID=? ");
				super.addStringForField(interfaceMeetingDetailVO.getConfProfileID());
			}

			if (interfaceMeetingDetailVO.getModelID() != null) {
				sqlstr.append(" , modelID=? ");
				super.addStringForField(interfaceMeetingDetailVO.getModelID());
			}

			if (interfaceMeetingDetailVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(interfaceMeetingDetailVO.getStatus());
			}

			if (interfaceMeetingDetailVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(interfaceMeetingDetailVO.getDescription());
			}

			if (interfaceMeetingDetailVO.getRef1() != null) {
				sqlstr.append(" , ref1=? ");
				super.addStringForField(interfaceMeetingDetailVO.getRef1());
			}

			if (interfaceMeetingDetailVO.getRef2() != null) {
				sqlstr.append(" , ref2=? ");
				super.addStringForField(interfaceMeetingDetailVO.getRef2());
			}
			if (interfaceMeetingDetailVO.getMainRoomNO() != null) {
				sqlstr.append(" , mainroomno=? ");
				super.addStringForField(interfaceMeetingDetailVO.getMainRoomNO());
			}
			sqlstr.append(" where id in (?) ");
			if (interfaceMeetingDetailVO.getId() != null) {
				super.addStringForField(interfaceMeetingDetailVO.getId());
			}
		} else if (DEL_INTERFACEMEETINGDETAIL == operatorType) {
			sqlstr.append("delete  from  z_interface_in_meetingdetail ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(interfaceMeetingDetailVO.getId());
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
