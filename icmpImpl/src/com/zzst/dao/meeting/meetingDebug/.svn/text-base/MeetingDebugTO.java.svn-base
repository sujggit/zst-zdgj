package com.zzst.dao.meeting.meetingDebug;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;

/**
 * class description: MeetingDebug TO
 * 
 * @date Tue May 28 15:03:30 CST 2013
 * @author ryan
 */
public class MeetingDebugTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(MeetingDebugTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGDEBUG = 1;
	public static int MODIFY_MEETINGDEBUG = 2;
	public static int DEL_MEETINGDEBUG = 3;
	private int result = 0;

	private MeetingDebugVO meetingDebugVO;

	public MeetingDebugTO(int operatorType, MeetingDebugVO meetingDebugVO) {
		this.operatorType = operatorType;
		this.meetingDebugVO = meetingDebugVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGDEBUG == operatorType) {
			sqlstr.append("insert into z_t_meeting_debug ");
			sqlstr
					.append("(id,meetingDetailId,debugStartTime,noticeTime,noticeStatus)");
			sqlstr.append(" values (?,?,?,?,?)");
			super.addStringForField(meetingDebugVO.getId());
			super.addStringForField(meetingDebugVO.getMeetingDetailId());
			super.addTimestampForField(meetingDebugVO.getDebugStartTime());
			super.addTimestampForField(meetingDebugVO.getNoticeTime());
			super.addIntForField(meetingDebugVO.getNoticeStatus());
		} else if (MODIFY_MEETINGDEBUG == operatorType) {
			sqlstr.append("update  z_t_meeting_debug set ");
			
			if (meetingDebugVO.getDebugStartTime() != null) {
				sqlstr.append("  debugStartTime=? ");
				super.addTimestampForField(meetingDebugVO.getDebugStartTime());
				
			}

			if (meetingDebugVO.getNoticeTime() != null) {
				sqlstr.append(" , noticeTime=? ");
				super.addTimestampForField(meetingDebugVO.getNoticeTime());
			}

			if (meetingDebugVO.getNoticeStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , noticeStatus=?");
				super.addIntForField(meetingDebugVO.getNoticeStatus());
			}
			
			if(meetingDebugVO.getNoticeType()!=null){
				sqlstr.append(" , noticeType = ?");
				super.addStringForField(meetingDebugVO.getNoticeType());
			}
			sqlstr.append(" where meetingDetailId in (?) ");
			if (meetingDebugVO.getMeetingDetailId() != null) {
				super.addStringForField(meetingDebugVO.getMeetingDetailId());
			}
		} else if (DEL_MEETINGDEBUG == operatorType) {
			sqlstr.append("delete  from  z_t_meeting_debug ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(meetingDebugVO.getId());
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
