package com.zzst.dao.meeting.dataInterface.meetingRoom;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;

/**
 * class description: MeetingRoomInterface TO
 * 
 * @date Fri May 24 16:23:45 CST 2013
 * @author ryan
 */
public class MeetingRoomInterfaceTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(MeetingRoomInterfaceTO.class.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGROOMINTERFACE = 1;
	public static int MODIFY_MEETINGROOMINTERFACE = 2;
	public static int DEL_MEETINGROOMINTERFACE = 3;
	public static int DEL_ALL = 4;
	
	private int result = 0;

	private MeetingRoomInterfaceVO meetingRoomInterfaceVO;
	private String ids = "";

	public MeetingRoomInterfaceTO(int operatorType,
			MeetingRoomInterfaceVO meetingRoomInterfaceVO) {
		this.operatorType = operatorType;
		this.meetingRoomInterfaceVO = meetingRoomInterfaceVO;
	}

	public MeetingRoomInterfaceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGROOMINTERFACE == operatorType) {
			sqlstr.append("insert into z_interface_in_meetingroom ");
			sqlstr
					.append("(id,meetingroomName,roomNO,meetingRoomType,capacity,adminName,departmentName,addressName,status,meetingRoomStatus,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(meetingRoomInterfaceVO.getId());
			super
					.addStringForField(meetingRoomInterfaceVO
							.getMeetingroomName());
			super.addStringForField(meetingRoomInterfaceVO.getRoomNO());
			super.addIntForField(meetingRoomInterfaceVO.getMeetingRoomType());
			super.addIntForField(meetingRoomInterfaceVO.getCapacity());
			super.addStringForField(meetingRoomInterfaceVO.getAdminName());
			super.addStringForField(meetingRoomInterfaceVO.getDepartmentName());
			super.addStringForField(meetingRoomInterfaceVO.getAddressName());
			super.addIntForField(meetingRoomInterfaceVO.getStatus());
			super.addIntForField(meetingRoomInterfaceVO.getMeetingRoomStatus());
			super.addStringForField(meetingRoomInterfaceVO.getDescription());
		} else if (MODIFY_MEETINGROOMINTERFACE == operatorType) {
			sqlstr.append("update  z_interface_in_meetingroom set ");
			sqlstr.append(" id = id ");

			if (meetingRoomInterfaceVO.getMeetingroomName() != null) {
				sqlstr.append(" , meetingroomName=? ");
				super.addStringForField(meetingRoomInterfaceVO
						.getMeetingroomName());
			}

			if (meetingRoomInterfaceVO.getRoomNO() != null) {
				sqlstr.append(" , roomNO=? ");
				super.addStringForField(meetingRoomInterfaceVO.getRoomNO());
			}

			if (meetingRoomInterfaceVO.getMeetingRoomType() != Integer.MIN_VALUE) {
				sqlstr.append(" , meetingRoomType=?");
				super.addIntForField(meetingRoomInterfaceVO
						.getMeetingRoomType());
			}

			if (meetingRoomInterfaceVO.getCapacity() != Integer.MIN_VALUE) {
				sqlstr.append(" , capacity=?");
				super.addIntForField(meetingRoomInterfaceVO.getCapacity());
			}

			if (meetingRoomInterfaceVO.getAdminName() != null) {
				sqlstr.append(" , adminName=? ");
				super.addStringForField(meetingRoomInterfaceVO.getAdminName());
			}

			if (meetingRoomInterfaceVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentName=? ");
				super.addStringForField(meetingRoomInterfaceVO
						.getDepartmentName());
			}

			if (meetingRoomInterfaceVO.getAddressName() != null) {
				sqlstr.append(" , addressName=? ");
				super
						.addStringForField(meetingRoomInterfaceVO
								.getAddressName());
			}

			if (meetingRoomInterfaceVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(meetingRoomInterfaceVO.getStatus());
			}

			if (meetingRoomInterfaceVO.getMeetingRoomStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , meetingRoomStatus=?");
				super.addIntForField(meetingRoomInterfaceVO
						.getMeetingRoomStatus());
			}

			if (meetingRoomInterfaceVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super
						.addStringForField(meetingRoomInterfaceVO
								.getDescription());
			}

			sqlstr.append(" where id in (?) ");
			if (meetingRoomInterfaceVO.getId() != null) {
				super.addStringForField(meetingRoomInterfaceVO.getId());
			}
		} else if (DEL_MEETINGROOMINTERFACE == operatorType) {
			sqlstr.append("delete  from  z_interface_in_meetingroom ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(meetingRoomInterfaceVO.getId());
		} else if ( DEL_ALL == operatorType ){
			sqlstr.append("delete  from  z_interface_in_meetingroom ");
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
