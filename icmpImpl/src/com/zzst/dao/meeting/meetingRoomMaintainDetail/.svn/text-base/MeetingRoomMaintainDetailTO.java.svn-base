package com.zzst.dao.meeting.meetingRoomMaintainDetail;


import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;

/**
 * class description: MeetingRoomMaintainDetail TO
 * 
 * @date Wed Sep 12 10:15:30 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainDetailTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(MeetingRoomMaintainDetailTO.class.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGROOMMAINTAINDETAIL = 1;
	public static int MODIFY_MEETINGROOMMAINTAINDETAIL = 2;
	public static int DEL_MEETINGROOMMAINTAINDETAIL = 3;
	public static int DELETE_BY_MAINTAIID = 4;//addby duting 20120926
	
	private int result = 0;

	private MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO;
	private String ids = "";

	public MeetingRoomMaintainDetailTO(int operatorType,
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO) {
		this.operatorType = operatorType;
		this.meetingRoomMaintainDetailVO = meetingRoomMaintainDetailVO;
	}

	public MeetingRoomMaintainDetailTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGROOMMAINTAINDETAIL == operatorType) {
			sqlstr.append("insert into z_t_meetingroom_maintain_info ");
			sqlstr.append("(detailID,maintainID,maintainName,status,questionDes,revision,type,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			super.addStringForField(meetingRoomMaintainDetailVO.getDetailID());
			super.addStringForField(meetingRoomMaintainDetailVO.getMaintainID());
			super.addStringForField(meetingRoomMaintainDetailVO
					.getMaintainName());
			super.addIntForField(meetingRoomMaintainDetailVO.getStatus());
			super.addStringForField(meetingRoomMaintainDetailVO
					.getQuestionDes());
			super.addLongForField(meetingRoomMaintainDetailVO.getRevision());
			super.addIntForField(meetingRoomMaintainDetailVO.getType());
			super.addStringForField(meetingRoomMaintainDetailVO
					.getDescription());
			
		} else if (MODIFY_MEETINGROOMMAINTAINDETAIL == operatorType) {
			sqlstr.append("update  z_t_meetingroom_maintain_info set ");
			sqlstr.append(" detailID = detailID ");

			if (meetingRoomMaintainDetailVO.getMaintainID() != null) {
				sqlstr.append(" , maintainID=? ");
				super.addStringForField(meetingRoomMaintainDetailVO
						.getMaintainID());
			}

			if (meetingRoomMaintainDetailVO.getMaintainName() != null) {
				sqlstr.append(" , maintainName=? ");
				super.addStringForField(meetingRoomMaintainDetailVO
						.getMaintainName());
			}

			if (meetingRoomMaintainDetailVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(meetingRoomMaintainDetailVO.getStatus());
			}

			if (meetingRoomMaintainDetailVO.getQuestionDes() != null) {
				sqlstr.append(" , questionDes=? ");
				super.addStringForField(meetingRoomMaintainDetailVO
						.getQuestionDes());
			}

			if (meetingRoomMaintainDetailVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super
						.addLongForField(meetingRoomMaintainDetailVO
								.getRevision());
			}
			if(meetingRoomMaintainDetailVO.getType() != Integer.MIN_VALUE){
				sqlstr.append(" , type=? ");
				super.addIntForField(meetingRoomMaintainDetailVO.getType());
			}

			if (meetingRoomMaintainDetailVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(meetingRoomMaintainDetailVO
						.getDescription());
			}
			
			sqlstr.append(" where detailID  = ? ");
			super.addStringForField(meetingRoomMaintainDetailVO
					.getDetailID());
		} else if (DEL_MEETINGROOMMAINTAINDETAIL == operatorType) {
			sqlstr.append("delete  from  z_t_meetingroom_maintain_info ");
			sqlstr.append(" where detailID in (?) ");
			super.addStringForField(ids);
		}else if(DELETE_BY_MAINTAIID==operatorType){//addby duting 
			sqlstr.append("delete  from  z_t_meetingroom_maintain_info ");
			sqlstr.append(" where maintainID = ? ");
			super.addStringForField(meetingRoomMaintainDetailVO.getMaintainID());
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
