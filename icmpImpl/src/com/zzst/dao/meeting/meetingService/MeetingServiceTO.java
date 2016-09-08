package com.zzst.dao.meeting.meetingService;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingService.MeetingServiceVO;

/**
 * class description: MeetingService TO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:10 CST 2009
 */

public class MeetingServiceTO extends TransactionObject {

	static Logger logger = CbfLogger
			.getLogger(MeetingServiceTO.class.getName());

	private int operatorType = -1;

	public static int ADD_MEETINGSERVICE = 1;

	public static int MODIFY_MEETINGSERVICE = 2;

	public static int DEL_MEETINGSERVICE = 3;

	private int result = 0;

	private MeetingServiceVO vMeetingServiceVO;

	public MeetingServiceTO(int operatorType, MeetingServiceVO vMeetingServiceVO) {
		this.operatorType = operatorType;
		this.vMeetingServiceVO = vMeetingServiceVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGSERVICE == operatorType) {
			sqlstr.append("insert into T_MeetingService ");
			sqlstr
					.append("(meetingDetailID,serviceID,serviceType,equipmentID,modelName,equipmentNameCaption,serviceName,servicePrice,needNumber,totalMoney,description,revision,meetingRoomID)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_MEETINGSERVICE == operatorType) {
			sqlstr.append("update  T_MeetingService set ");
			sqlstr
					.append(" meetingDetailID=?,serviceID=?,serviceType=?,equipmentID=?,modelName=?,equipmentNameCaption=?,serviceName=?,servicePrice=?,needNumber=?,totalMoney=?,description=?,meetingRoomID=?");
			sqlstr.append(" where meetingServiceID= ? ");

			this.sqlStr = sqlstr.toString();
		}else if (DEL_MEETINGSERVICE == operatorType) {
			sqlstr.append("delete  from T_MeetingService ");
			sqlstr.append(" where meetingDetailID= ?");

			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_MEETINGSERVICE == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vMeetingServiceVO
						.getMeetingDetailID());
				this.stmt.setInt(colNum++, vMeetingServiceVO.getServiceID());
				this.stmt.setInt(colNum++, vMeetingServiceVO.getServiceType());
				this.stmt.setInt(colNum++, vMeetingServiceVO.getEquipmentID());
				this.stmt.setString(colNum++, vMeetingServiceVO.getModelName());
				this.stmt.setString(colNum++, vMeetingServiceVO
						.getEquipmentNameCaption());
				this.stmt.setString(colNum++, vMeetingServiceVO
						.getServiceName());
				this.stmt.setFloat(colNum++, vMeetingServiceVO.getServicePrice());
				this.stmt.setFloat(colNum++, vMeetingServiceVO.getNeedNumber());
				this.stmt.setFloat(colNum++, vMeetingServiceVO.getTotalMoney());
				this.stmt.setString(colNum++, vMeetingServiceVO
						.getDescription());
				this.stmt.setLong(colNum++, vMeetingServiceVO.getRevision());
				this.stmt.setInt(colNum++, vMeetingServiceVO.getMeetingRoomID());

			} else if (MODIFY_MEETINGSERVICE == operatorType) {
				int colNum = 1;

				this.stmt.setInt(colNum++, vMeetingServiceVO
						.getMeetingDetailID());

				this.stmt.setInt(colNum++, vMeetingServiceVO.getServiceID());

				this.stmt.setInt(colNum++, vMeetingServiceVO.getServiceType());

				this.stmt.setInt(colNum++, vMeetingServiceVO.getEquipmentID());

				this.stmt.setString(colNum++, vMeetingServiceVO.getModelName());

				this.stmt.setString(colNum++, vMeetingServiceVO
						.getEquipmentNameCaption());

				this.stmt.setString(colNum++, vMeetingServiceVO
						.getServiceName());

				this.stmt.setString(colNum++, vMeetingServiceVO
						.getDescription());

				this.stmt.setInt(colNum++, vMeetingServiceVO
						.getMeetingRoomID());
				
				this.stmt.setInt(colNum++, vMeetingServiceVO
						.getMeetingServiceID());
				
				
			}else if (DEL_MEETINGSERVICE == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vMeetingServiceVO.getMeetingDetailID());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" MEETINGSERVICETO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" MEETINGSERVICETO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
