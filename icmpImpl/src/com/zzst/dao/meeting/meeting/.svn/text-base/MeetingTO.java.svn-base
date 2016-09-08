package com.zzst.dao.meeting.meeting;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meeting.MeetingVO;

/**
 * class description: Meeting TO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(MeetingTO.class.getName());

	private int operatorType = -1;

	public static int ADD_MEETING = 1;

	public static int MODIFY_MEETING = 2;

	public static int DEL_MEETING = 3;

	private int result = 0;

	private MeetingVO vMeetingVO;

	public MeetingTO(int operatorType, MeetingVO vMeetingVO) {
		this.operatorType = operatorType;
		this.vMeetingVO = vMeetingVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETING == operatorType) {
			sqlstr.append("insert into t_Meeting ");
			sqlstr
					.append("(meetingID,meetingName,meetingType, temlyType, startDate,endDate,createUserID, createTime,status,description,revision )");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_MEETING == operatorType) {
			sqlstr.append("update  t_Meeting set ");
			sqlstr.append("meetingName=?,meetingType=?, temlyType=?, startDate=?,endDate=?,createUserID=?, createTime=?,status=?,description=?,revision=?");
			sqlstr.append(" where meetingID= ? ");

			this.sqlStr = sqlstr.toString();
		}else if (DEL_MEETING == operatorType) {
			sqlstr.append("delete  from t_Meeting ");
			sqlstr.append(" where meetingID= ?");

			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_MEETING == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingVO.getMeetingID());
				this.stmt.setString(colNum++, vMeetingVO.getMeetingName());
				this.stmt.setInt(colNum++, vMeetingVO.getMeetingType());
				this.stmt.setInt(colNum++, vMeetingVO.getPeriodType());
				this.stmt.setTimestamp(colNum++, vMeetingVO.getStartTime());
				this.stmt.setTimestamp(colNum++, vMeetingVO.getEndTime());
				this.stmt.setString(colNum++, vMeetingVO.getCreateUserID());
				this.stmt.setTimestamp(colNum++, vMeetingVO.getCreateTime());
				this.stmt.setInt(colNum++, vMeetingVO.getStatus());
				this.stmt.setString(colNum++, vMeetingVO.getMeetingDescription());
				this.stmt.setLong(colNum++, vMeetingVO.getRevision());
			} else if (MODIFY_MEETING == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingVO.getMeetingName());
				this.stmt.setInt(colNum++, vMeetingVO.getMeetingType());
				this.stmt.setInt(colNum++, vMeetingVO.getPeriodType());
				this.stmt.setTimestamp(colNum++, vMeetingVO.getStartTime());
				this.stmt.setTimestamp(colNum++, vMeetingVO.getEndTime());
				this.stmt.setString(colNum++, vMeetingVO.getCreateUserID());
				this.stmt.setTimestamp(colNum++, vMeetingVO.getCreateTime());
				this.stmt.setInt(colNum++, vMeetingVO.getStatus());
				this.stmt.setString(colNum++, vMeetingVO.getMeetingDescription());
				this.stmt.setLong(colNum++, vMeetingVO.getRevision());
				
				this.stmt.setString(colNum++, vMeetingVO.getMeetingID());
			}else if (DEL_MEETING == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingVO.getMeetingID());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" MEETINGTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" MEETINGTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
