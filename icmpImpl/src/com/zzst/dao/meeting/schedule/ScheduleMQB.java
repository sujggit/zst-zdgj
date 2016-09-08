package com.zzst.dao.meeting.schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.schedule.ScheduleVO;

/**
 * class description: Schedule MQB
 * 
 * @date Mon Aug 29 16:18:14 CST 2016
 * @author ryan
 */
public class ScheduleMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ScheduleMQB.class.getName());

	public static int QUERY_FROM_SCHEDULE = 1;
	public static int QUERY_FROM_SCHEDULE_BY_IDS = 2;
	public static int QUERY_BY_WEEK = 3;
	public static int QUERY_BY_WEEK_WITH_STATUS = 4;
	private ScheduleVO scheduleVO;
	private ArrayList<ScheduleVO> listSchedule = new ArrayList<ScheduleVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ScheduleMQB(int operatorType, ScheduleVO scheduleVO) {
		_operatorType = operatorType;
		this.scheduleVO = scheduleVO;
		makeSql();
	}

	public ScheduleMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if (QUERY_FROM_SCHEDULE == _operatorType) {
			String temp = "SELECT s.scheduleId, s.scheduleTime, s.weekTime, s.meetingId, m.meetingName, ro.meetingroomName, m.startTime, m.endTime, s.workId, sw.workName, s.isEvent, s.mark, s. STATUS, s.applyId, u.fullName, s.leaderId, mi. NAME, s.createTime,s.applyPeopleId,s.applySug,s.applyTime,u2.fullName AS applyName FROM z_t_schedule s LEFT JOIN z_t_schedule_work sw ON s.workId = sw.workId LEFT JOIN z_t_meetingdetail m ON s.meetingId = m.meetingDetailID LEFT JOIN z_t_mobileinfo mi ON s.leaderId = mi.id LEFT JOIN z_t_user u ON s.applyId = u.userID LEFT JOIN z_t_meetingdetail_room mr ON m.meetingDetailID = mr.meetingDetailID LEFT JOIN z_t_meetingroom ro ON mr.meetingroomID = ro.meetingroomID LEFT JOIN z_t_user u2 ON s.applyPeopleId = u2.userID ";
			strsql.append(temp);
			strsql.append(" where 1=1 ");
			if (null != scheduleVO) {
				if (!StringUtils.isNullOrBlank(scheduleVO.getScheduleId())) {
					strsql.append(" and scheduleId= ? ");
					super.addStringForField(scheduleVO.getScheduleId());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getScheduleTime())) {
					strsql.append(" and scheduleTime= ? ");
					super.addStringForField(scheduleVO.getScheduleTime());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getWeekTime())) {
					strsql.append(" and weekTime= ? ");
					super.addStringForField(scheduleVO.getWeekTime());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getMeetingId())) {
					strsql.append(" and meetingId= ? ");
					super.addStringForField(scheduleVO.getMeetingId());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getWorkId())) {
					strsql.append(" and workId= ? ");
					super.addStringForField(scheduleVO.getWorkId());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getIsEvent())) {
					strsql.append(" and isEvent= ? ");
					super.addStringForField(scheduleVO.getIsEvent());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getMark())) {
					strsql.append(" and mark= ? ");
					super.addStringForField(scheduleVO.getMark());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getStatus())) {
					strsql.append(" and status= ? ");
					super.addStringForField(scheduleVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getApplyId())) {
					strsql.append(" and applyId= ? ");
					super.addStringForField(scheduleVO.getApplyId());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getLeaderId())) {
					strsql.append(" and leaderId= ? ");
					super.addStringForField(scheduleVO.getLeaderId());
				}
				if (!StringUtils.isNullOrBlank(scheduleVO.getCreateTime())) {
					strsql.append(" and s.createTime= ? ");
					super.addTimestampForField(scheduleVO.getCreateTime());
				}
			}
		} else if (QUERY_FROM_SCHEDULE_BY_IDS == _operatorType) {
			strsql.append("select scheduleId,scheduleTime,weekTime,meetingId,workId,isEvent,mark,status,applyId,leaderId,createTime ");
			strsql.append(" from z_t_schedule ");
			strsql.append(" where 1=1 ");
			strsql.append(" and scheduleId in (?) ");
			super.addStringForField(ids);
		} else if (QUERY_BY_WEEK == _operatorType){
			strsql.delete(0, strsql.length());
			strsql.append("SELECT DISTINCT s.scheduleTime,s.applyId,u.fullName,s.createTime,s.status FROM `z_t_schedule` s,z_t_user u WHERE s.applyId=u.userID ORDER BY s.createTime DESC;");
		} else if(QUERY_BY_WEEK_WITH_STATUS == _operatorType){
			strsql.delete(0, strsql.length());
			strsql.append("SELECT DISTINCT s.scheduleTime,s.applyId,u.fullName,s.createTime,s.status FROM `z_t_schedule` s,z_t_user u WHERE s.applyId=u.userID ");
			if("1".equals(scheduleVO.getStatus())){
				strsql.append("AND s.status=1 ");
			}else{
				strsql.append("AND s.status=0 OR s.status is NULL ");
			}
			strsql.append("ORDER BY s.createTime DESC;");
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if (QUERY_BY_WEEK == _operatorType || QUERY_BY_WEEK_WITH_STATUS == _operatorType){
			scheduleVO = new ScheduleVO();
			scheduleVO.setScheduleTime(rs.getString("scheduleTime"));
			scheduleVO.setApplyId(rs.getString("applyId"));
			scheduleVO.setFullName(rs.getString("fullName"));
			scheduleVO.setCreateTime(rs.getTimestamp("createTime"));
			scheduleVO.setStatus(rs.getString("status"));
			listSchedule.add(scheduleVO);
		}else if(QUERY_FROM_SCHEDULE == _operatorType) {
			scheduleVO = new ScheduleVO();
			scheduleVO.setScheduleId(rs.getString("scheduleId"));
			scheduleVO.setScheduleTime(rs.getString("scheduleTime"));
			scheduleVO.setWeekTime(rs.getString("weekTime"));
			scheduleVO.setMeetingId(rs.getString("meetingId"));
			scheduleVO.setWorkId(rs.getString("workId"));
			scheduleVO.setIsEvent(rs.getString("isEvent"));
			scheduleVO.setMark(rs.getString("mark"));
			scheduleVO.setStatus(rs.getString("status"));
			scheduleVO.setApplyId(rs.getString("applyId"));
			scheduleVO.setLeaderId(rs.getString("leaderId"));
			scheduleVO.setCreateTime(rs.getTimestamp("createTime"));
			scheduleVO.setFullName(rs.getString("fullName"));
			scheduleVO.setWorkName(rs.getString("workName"));
			scheduleVO.setMeetingName(rs.getString("meetingName"));
			scheduleVO.setStartTime(rs.getTimestamp("startTime"));
			scheduleVO.setEndTime(rs.getTimestamp("endTime"));
			scheduleVO.setLeaderName(rs.getString("NAME"));
			scheduleVO.setRoomName(rs.getString("meetingroomName"));
			scheduleVO.setApplyPeopleId(rs.getString("applyPeopleId"));
			scheduleVO.setApplyPeople(rs.getString("applyName"));
			scheduleVO.setApplyTime(rs.getTimestamp("applyTime"));
			scheduleVO.setApplysug(rs.getString("applySug"));
			listSchedule.add(scheduleVO);
		}
	}

	public ArrayList<ScheduleVO> getScheduleList() {
		return listSchedule;
	}

	public ScheduleVO getScheduleVO() {
		return scheduleVO;
	}

}
