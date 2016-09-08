package com.zzst.dao.meeting.meetingDetailUser;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;

/**
 * class description: MeetingDetailUser TO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailUserTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(MeetingDetailUserTO.class.getName());

	private int operatorType = -1;

	public static int ADD_MEETINGDETAILUSER = 1;

	public static int MODIFY_MEETINGDETAILUSER = 2;

	public static int DEL_MEETINGDETAILUSER = 3;
	
	public static int DEL_ALLMEETINGDETAILUSERS = 4;

	private int result = 0;

	private MeetingDetailUserVO vMeetingDetailUserVO;

	public MeetingDetailUserTO(int operatorType,
			MeetingDetailUserVO vMeetingDetailUserVO) {
		this.operatorType = operatorType;
		this.vMeetingDetailUserVO = vMeetingDetailUserVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGDETAILUSER == operatorType) {
			sqlstr.append("insert into z_t_meetingdetail_user ");
			sqlstr.append("(meetingDetailID,userID,status,appraisalID,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_MEETINGDETAILUSER == operatorType) {
			sqlstr.append("update  z_t_meetingdetail_user set ");
			sqlstr.append(" status=?,appraisalID=?,description=?,revision=?");
			sqlstr.append(" where meetingDetailID=? and userID=? ");

			this.sqlStr = sqlstr.toString();
		}else if (DEL_MEETINGDETAILUSER == operatorType) {
			sqlstr.append("delete  from z_t_meetingdetail_user ");
			sqlstr.append(" where  meetingDetailID=? and userID=?");

			this.sqlStr = sqlstr.toString();
		}else if(DEL_ALLMEETINGDETAILUSERS == operatorType){
			sqlstr.append("delete  from z_t_meetingdetail_user ");
			sqlstr.append(" where  meetingDetailID=?");

			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_MEETINGDETAILUSER == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getUserID());
				this.stmt.setInt(colNum++, vMeetingDetailUserVO.getStatus());
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getAppraisalID());
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getDescription());
				this.stmt.setLong(colNum++, vMeetingDetailUserVO.getRevision());
			} else if (MODIFY_MEETINGDETAILUSER == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vMeetingDetailUserVO.getStatus());
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getAppraisalID());
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getDescription());
				this.stmt.setLong(colNum++, vMeetingDetailUserVO.getRevision());
				
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getUserID());
			} else if (DEL_MEETINGDETAILUSER == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getUserID());
			} else if(DEL_ALLMEETINGDETAILUSERS == operatorType){
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailUserVO.getMeetingDetailID());			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" MEETINGDETAILUSERTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" MEETINGDETAILUSERTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
