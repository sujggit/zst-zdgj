package com.zzst.dao.meeting.schedule;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.schedule.ScheduleVO;

/**
 * class description: Schedule TO
 * 
 * @date Mon Aug 29 16:18:14 CST 2016
 * @author ryan
 */
public class ScheduleTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ScheduleTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_SCHEDULE = 1;
	public static int MODIFY_SCHEDULE = 2;
	public static int DEL_SCHEDULE = 3;
	private int result = 0;

	private ScheduleVO scheduleVO;

	public ScheduleTO(int operatorType, ScheduleVO scheduleVO) {
		this.operatorType = operatorType;
		this.scheduleVO = scheduleVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_SCHEDULE == operatorType) {
			sqlstr.append("insert into z_t_schedule ");
			sqlstr.append("(scheduleId,scheduleTime,weekTime,meetingId,workId,isEvent,mark,status,applyId,leaderId,createTime)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(scheduleVO.getScheduleId());
			super.addStringForField(scheduleVO.getScheduleTime());
			super.addStringForField(scheduleVO.getWeekTime());
			super.addStringForField(scheduleVO.getMeetingId());
			super.addStringForField(scheduleVO.getWorkId());
			super.addStringForField(scheduleVO.getIsEvent());
			super.addStringForField(scheduleVO.getMark());
			super.addStringForField(scheduleVO.getStatus());
			super.addStringForField(scheduleVO.getApplyId());
			super.addStringForField(scheduleVO.getLeaderId());
			super.addTimestampForField(scheduleVO.getCreateTime());
		} else if (MODIFY_SCHEDULE == operatorType) {
			sqlstr.append("update  z_t_schedule set ");
			sqlstr.append(" scheduleId = scheduleId ");

			if (scheduleVO.getScheduleTime() != null) {
				sqlstr.append(" , scheduleTime=? ");
				super.addStringForField(scheduleVO.getScheduleTime());
			}

			if (scheduleVO.getWeekTime() != null) {
				sqlstr.append(" , weekTime=? ");
				super.addStringForField(scheduleVO.getWeekTime());
			}

			if (scheduleVO.getMeetingId() != null) {
				sqlstr.append(" , meetingId=? ");
				super.addStringForField(scheduleVO.getMeetingId());
			}

			if (scheduleVO.getWorkId() != null) {
				sqlstr.append(" , workId=? ");
				super.addStringForField(scheduleVO.getWorkId());
			}

			if (scheduleVO.getIsEvent() != null) {
				sqlstr.append(" , isEvent=? ");
				super.addStringForField(scheduleVO.getIsEvent());
			}

			if (scheduleVO.getMark() != null) {
				sqlstr.append(" , mark=? ");
				super.addStringForField(scheduleVO.getMark());
			}

			if (scheduleVO.getStatus() != null) {
				sqlstr.append(" , status=? ");
				super.addStringForField(scheduleVO.getStatus());
			}

			if (scheduleVO.getApplyId() != null) {
				sqlstr.append(" , applyId=? ");
				super.addStringForField(scheduleVO.getApplyId());
			}

			if (scheduleVO.getLeaderId() != null) {
				sqlstr.append(" , leaderId=? ");
				super.addStringForField(scheduleVO.getLeaderId());
			}

			if (scheduleVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(scheduleVO.getCreateTime());
			}
			
			if (scheduleVO.getApplyPeopleId() != null) {
				sqlstr.append(" , applyPeopleId=? ");
				super.addStringForField(scheduleVO.getApplyPeopleId());
			}
			
			if (scheduleVO.getApplysug() != null) {
				sqlstr.append(" , applySug=? ");
				super.addStringForField(scheduleVO.getApplysug());
			}
			
			if (scheduleVO.getApplyTime() != null) {
				sqlstr.append(" , applyTime=? ");
				super.addTimestampForField(scheduleVO.getApplyTime());
			}

			sqlstr.append(" where scheduleId in (?) ");
			if (scheduleVO.getScheduleId() != null) {
				super.addStringForField(scheduleVO.getScheduleId());
			}
		} else if (DEL_SCHEDULE == operatorType) {
			sqlstr.append("delete  from  z_t_schedule ");
			sqlstr.append(" where scheduleId in (?) ");
			super.addStringForField(scheduleVO.getScheduleId());
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
