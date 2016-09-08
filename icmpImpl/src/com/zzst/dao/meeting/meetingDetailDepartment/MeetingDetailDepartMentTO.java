package com.zzst.dao.meeting.meetingDetailDepartment;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;

/**
 * class description: MeetingDetailDepartMent TO
 * 
 * @date Fri Apr 20 16:39:24 CST 2012
 * @author ryan
 */
public class MeetingDetailDepartMentTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(MeetingDetailDepartMentTO.class.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGDETAILDEPARTMENT = 1;
	public static int MODIFY_MEETINGDETAILDEPARTMENT = 2;
	public static int DEL_MEETINGDETAILDEPARTMENT = 3;
	private int result = 0;

	private MeetingDetailDepartMentVO meetingDetailDepartMentVO;
	private String ids = "";

	public MeetingDetailDepartMentTO(int operatorType, MeetingDetailDepartMentVO meetingDetailDepartMentVO) {
		this.operatorType = operatorType;
		this.meetingDetailDepartMentVO = meetingDetailDepartMentVO;
	}

	public MeetingDetailDepartMentTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGDETAILDEPARTMENT == operatorType) {
			sqlstr.append("insert into z_t_meetingdetail_department ");
			sqlstr.append("(meetingDetailID,departID,description)");
			sqlstr.append(" values ( '"+meetingDetailDepartMentVO.getMeetingDetailID()+"','");
			sqlstr.append(meetingDetailDepartMentVO.getDepartMentID()+"','");
			sqlstr.append(meetingDetailDepartMentVO.getDescription()+"' )");
//			super.addStringForField(meetingDetailDepartMentVO.getMeetingDetailID());
//			super.addStringForField(meetingDetailDepartMentVO.getDepartMentID());
//			super.addStringForField(meetingDetailDepartMentVO.getDescription());
		} else if (MODIFY_MEETINGDETAILDEPARTMENT == operatorType) {
			sqlstr.append("update  z_t_meetingdetail_department set ");
			sqlstr.append(" meetingDetailID = meetingDetailID ");

			if (meetingDetailDepartMentVO.getDepartMentID() != null) {
				sqlstr.append(" , departID=? ");
				super.addStringForField(meetingDetailDepartMentVO.getDepartMentID());
			}

			if (meetingDetailDepartMentVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(meetingDetailDepartMentVO.getDescription());
			}

			sqlstr.append(" where meetingDetailID in (?) ");
			if (meetingDetailDepartMentVO.getMeetingDetailID() != null) {
				super.addStringForField(meetingDetailDepartMentVO.getMeetingDetailID());
			}
		} else if (DEL_MEETINGDETAILDEPARTMENT == operatorType) {
			sqlstr.append("delete  from  z_t_meetingdetail_department ");
			sqlstr.append(" where meetingDetailID in (?) ");
			super.addStringForField(meetingDetailDepartMentVO.getMeetingDetailID());
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
