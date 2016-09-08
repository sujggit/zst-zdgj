package com.zzst.dao.meeting.meetingDetail;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;

/**
 * class description: MeetingDetail TO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(MeetingDetailTO.class.getName());

	private int operatorType = -1;

	public static int ADD_MEETINGDETAIL = 1;

	public static int MODIFY_MEETINGDETAIL = 2;

	public static int DEL_MEETINGDETAIL = 3;

	public static int MODIFY_MEETINGDETAIL_STATUS = 4;
	public static int MODIFY_MEETINGDETAIL_INFO2=5;
	
	public static int ADD_EXAM = 5;
	//add template and backup fields wangle 2013-8-22 
	public static int ADD_MEETINGDETAIL2 = 6;
	
	private int result = 0;

	private MeetingDetailVO vMeetingDetailVO;

	public MeetingDetailTO(int operatorType, MeetingDetailVO vMeetingDetailVO) {
		this.operatorType = operatorType;
		this.vMeetingDetailVO = vMeetingDetailVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGDETAIL == operatorType) {
			sqlstr.append("insert into z_t_meetingdetail ");
			sqlstr.append("(meetingDetailID,temlyMeetingID, meetingName,startTime,endTime,meetingType,isRecord,meetingLevel,notifyType,status,createUserID, createTime, description,revision,confProfileID,meetingAgenda,confDocAdminId,confDocAdminName,info1,info2,info3,info4,info5,realityStartTime)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_MEETINGDETAIL == operatorType) {
			sqlstr.append("update  z_t_meetingdetail set ");
			sqlstr.append("temlyMeetingID=?,meetingName=?,startTime=?,endTime=?,meetingType=?,isRecord=?,meetingLevel=?,notifyType=?,status=?,createUserID=?, createTime=?, description=?,revision=?,confProfileID=?,meetingAgenda=?,confDocAdminId=?,confDocAdminName=?,info1=?,info2=?");
			sqlstr.append(" where meetingDetailID= ? ");

			this.sqlStr = sqlstr.toString();
		}else if (DEL_MEETINGDETAIL == operatorType) {
			sqlstr.append("delete  from z_t_meetingdetail ");
			sqlstr.append(" where meetingDetailID= ?");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_MEETINGDETAIL_STATUS == operatorType) {
			sqlstr.append("update  z_t_meetingdetail set ");
			sqlstr.append("status = ? ");
			sqlstr.append(" where meetingDetailID = ? ");
			this.sqlStr = sqlstr.toString();
		}else if (MODIFY_MEETINGDETAIL_INFO2 == operatorType) {
			sqlstr.append("update  z_t_meetingdetail set ");
			sqlstr.append("info2 = ? ");
			sqlstr.append(" where meetingDetailID = ? ");
			this.sqlStr = sqlstr.toString();
		}else if(ADD_EXAM == operatorType)
		{
			sqlstr.append("insert into z_t_meetingdetail_exam ");
			sqlstr.append("(meetingDetailID,examby,examTime)");
			sqlstr.append(" values (?,?,?)");
			this.sqlStr = sqlstr.toString();
		}else if(ADD_MEETINGDETAIL2 == operatorType)
		{
			sqlstr.append("insert into z_t_meetingdetail ");
			sqlstr.append("(meetingDetailID,temlyMeetingID, meetingName,startTime,endTime,meetingType,isRecord,meetingLevel,notifyType,status,createUserID, createTime, description,revision,confProfileID,meetingAgenda,confDocAdminId,confDocAdminName,templateID,templateType,info1,info2,info3,info4,info5,realityStartTime)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		}
		
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_MEETINGDETAIL == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingName());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getMeetingStartTime());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getMeetingEndTime());				
				this.stmt.setInt(colNum++, vMeetingDetailVO.getMeetingType());
				this.stmt.setInt(colNum++, vMeetingDetailVO.getUseReach());
				this.stmt.setInt(colNum++, vMeetingDetailVO.getGrade());
				this.stmt.setString(colNum++, vMeetingDetailVO.getNotifyType());
				this.stmt.setInt(colNum++, Integer.valueOf(vMeetingDetailVO.getStatus()));
				this.stmt.setString(colNum++, vMeetingDetailVO.getCreateUserID());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getCreateTime());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDescription());
				this.stmt.setLong(colNum++, vMeetingDetailVO.getRevision());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfProfileID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingAgenda());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfDocAdminId());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfDocAdminName());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo1());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo2());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo3());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo4());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo5());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getRealityStartTime());
			} else if (MODIFY_MEETINGDETAIL == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingName());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getMeetingStartTime());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getMeetingEndTime());				
				this.stmt.setInt(colNum++, vMeetingDetailVO.getMeetingType());
				this.stmt.setInt(colNum++, vMeetingDetailVO.getUseReach());
				this.stmt.setInt(colNum++, vMeetingDetailVO.getGrade());
				this.stmt.setString(colNum++, vMeetingDetailVO.getNotifyType());
				this.stmt.setInt(colNum++, Integer.valueOf(vMeetingDetailVO.getStatus()));
				this.stmt.setString(colNum++, vMeetingDetailVO.getCreateUserID());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getCreateTime());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDescription());
				this.stmt.setLong(colNum++, vMeetingDetailVO.getRevision());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfProfileID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingAgenda());//注意顺序
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfDocAdminId());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfDocAdminName());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo1());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo2());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDetailID());
				
			}else if (DEL_MEETINGDETAIL == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDetailID());
			}else if (MODIFY_MEETINGDETAIL_STATUS == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, Integer.valueOf(vMeetingDetailVO.getStatus()));
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDetailID());
			}else if (MODIFY_MEETINGDETAIL_INFO2 == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, Integer.valueOf(vMeetingDetailVO.getInfo2()));
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDetailID());
			}else if(ADD_EXAM == operatorType)
			{
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getExamby());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getExamtime());			
			}else if (ADD_MEETINGDETAIL2 == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingName());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getMeetingStartTime());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getMeetingEndTime());				
				this.stmt.setInt(colNum++, vMeetingDetailVO.getMeetingType());
				this.stmt.setInt(colNum++, vMeetingDetailVO.getUseReach());
				this.stmt.setInt(colNum++, vMeetingDetailVO.getGrade());
				this.stmt.setString(colNum++, vMeetingDetailVO.getNotifyType());
				this.stmt.setInt(colNum++, Integer.valueOf(vMeetingDetailVO.getStatus()));
				this.stmt.setString(colNum++, vMeetingDetailVO.getCreateUserID());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getCreateTime());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingDescription());
				this.stmt.setLong(colNum++, vMeetingDetailVO.getRevision());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfProfileID());
				this.stmt.setString(colNum++, vMeetingDetailVO.getMeetingAgenda());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfDocAdminId());
				this.stmt.setString(colNum++, vMeetingDetailVO.getConfDocAdminName());
				this.stmt.setString(colNum++, vMeetingDetailVO.getTemplateID());
				this.stmt.setInt(colNum++, vMeetingDetailVO.getTemplateType());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo1());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo2());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo3());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo4());
				this.stmt.setString(colNum++, vMeetingDetailVO.getInfo5());
				this.stmt.setTimestamp(colNum++, vMeetingDetailVO.getRealityStartTime());
			} 
			
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" MEETINGDETAILTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" MEETINGDETAILTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
