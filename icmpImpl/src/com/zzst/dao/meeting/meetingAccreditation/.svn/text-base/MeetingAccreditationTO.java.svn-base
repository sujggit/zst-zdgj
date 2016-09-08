package com.zzst.dao.meeting.meetingAccreditation;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingAccreditation.MeetingAccreditationVO;

/**
 * class description: MeetingAccreditation TO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingAccreditationTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(MeetingAccreditationTO.class
			.getName());

	private int operatorType = -1;

	public static int ADD_MEETINGACCREDITATION = 1;

	public static int MODIFY_MEETINGACCREDITATION = 2;

	public static int DEL_MEETINGACCREDITATION = 3;

	private int result = 0;

	private MeetingAccreditationVO vMeetingAccreditationVO;

	public MeetingAccreditationTO(int operatorType,
			MeetingAccreditationVO vMeetingAccreditationVO) {
		this.operatorType = operatorType;
		this.vMeetingAccreditationVO = vMeetingAccreditationVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGACCREDITATION == operatorType) {
			sqlstr.append("insert into t_MeetingAccreditation ");
			sqlstr
					.append("(meetingDetailID,userFromID,userFromName,userToID,userToName,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_MEETINGACCREDITATION == operatorType) {
			sqlstr.append("update  t_MeetingAccreditation set ");
			sqlstr
					.append(" meetingDetailID=?,userFromID=?,userFromName=?,userToID=?,userToName=?,description=?");
			sqlstr.append(" where meetingAccreditationID= ? ");

			this.sqlStr = sqlstr.toString();
		}else if (DEL_MEETINGACCREDITATION == operatorType) {
			sqlstr.append("delete  from t_MeetingAccreditation ");
			sqlstr.append(" where meetingDetailID= ?");

			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_MEETINGACCREDITATION == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vMeetingAccreditationVO
						.getMeetingDetailID());
				this.stmt.setInt(colNum++, vMeetingAccreditationVO
						.getUserFromID());
				this.stmt.setString(colNum++, vMeetingAccreditationVO
						.getUserFromName());
				this.stmt.setInt(colNum++, vMeetingAccreditationVO
						.getUserToID());
				this.stmt.setString(colNum++, vMeetingAccreditationVO
						.getUserToName());
				this.stmt.setString(colNum++, vMeetingAccreditationVO
						.getDescription());
				this.stmt.setLong(colNum++, vMeetingAccreditationVO
						.getRevision());

			} else if (MODIFY_MEETINGACCREDITATION == operatorType) {
				int colNum = 1;

				this.stmt.setInt(colNum++, vMeetingAccreditationVO
						.getMeetingDetailID());

				this.stmt.setInt(colNum++, vMeetingAccreditationVO
						.getUserFromID());

				this.stmt.setString(colNum++, vMeetingAccreditationVO
						.getUserFromName());

				this.stmt.setInt(colNum++, vMeetingAccreditationVO
						.getUserToID());

				this.stmt.setString(colNum++, vMeetingAccreditationVO
						.getUserToName());

				this.stmt.setString(colNum++, vMeetingAccreditationVO
						.getDescription());

				this.stmt.setInt(colNum++, vMeetingAccreditationVO
						.getMeetingAccreditationID());

			}else if (DEL_MEETINGACCREDITATION == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vMeetingAccreditationVO.getMeetingDetailID());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" MEETINGACCREDITATIONTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" MEETINGACCREDITATIONTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
