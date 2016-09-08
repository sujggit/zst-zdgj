package com.zzst.dao.meeting.meetingRoomMaintain;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.MeetingRoomMaintain;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;

/**
 * class description: MeetingRoomMaintain TO
 * 
 * @date Wed Sep 12 09:42:15 CST 2012
 * @author ryan
 */
public class MeetingRoomMaintainTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(MeetingRoomMaintainTO.class.getName());
	private int operatorType = -1;

	public static int ADD_MEETINGROOMMAINTAIN = 1;
	public static int MODIFY_MEETINGROOMMAINTAIN = 2;
	public static int DEL_MEETINGROOMMAINTAIN = 3;
	public static int DEL_MEETINGROOMMAINTAIN_KEY = 4;
	private int result = 0;

	private MeetingRoomMaintainVO meetingRoomMaintainVO;
	private String ids = "";

	public MeetingRoomMaintainTO(int operatorType,
			MeetingRoomMaintainVO meetingRoomMaintainVO) {
		this.operatorType = operatorType;
		this.meetingRoomMaintainVO = meetingRoomMaintainVO;
	}

	public MeetingRoomMaintainTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGROOMMAINTAIN == operatorType) {
			sqlstr.append("insert into z_t_meetingroom_maintain ");
			sqlstr
					.append("(maintainID,roomID,maintainUserName,createUserID,createTime,STATUS,REVISION,DESCRIPTION,maintainKey,maintainType,processStatus)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(meetingRoomMaintainVO.getMaintainID());
			super.addStringForField(meetingRoomMaintainVO.getRoomID());
			super.addStringForField(meetingRoomMaintainVO.getMaintainUserName());
			super.addStringForField(meetingRoomMaintainVO.getCreateUserID());
			super.addTimestampForField(meetingRoomMaintainVO.getCreateTime());
			super.addIntForField(meetingRoomMaintainVO.getStatus());
			super.addLongForField(meetingRoomMaintainVO.getRevision());
			super.addStringForField(meetingRoomMaintainVO.getDescription());
			super.addStringForField(meetingRoomMaintainVO.getMaintainKey());
			super.addIntForField(meetingRoomMaintainVO.getMaintainType());
			super.addIntForField(meetingRoomMaintainVO.getProcessStatus());
		} else if (MODIFY_MEETINGROOMMAINTAIN == operatorType) {
			sqlstr.append("update  z_t_meetingroom_maintain set ");
			sqlstr.append(" maintainID = maintainID ");

			if (meetingRoomMaintainVO.getRoomID() != null) {
				sqlstr.append(" , roomID=? ");
				super.addStringForField(meetingRoomMaintainVO.getRoomID());
			}

			if (meetingRoomMaintainVO.getMaintainUserName() != null) {
				sqlstr.append(" , maintainUserName=? ");
				super.addStringForField(meetingRoomMaintainVO
						.getMaintainUserName());
			}

			if (meetingRoomMaintainVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(meetingRoomMaintainVO.getCreateUserID());
			}

			if (meetingRoomMaintainVO.getCreateTime() != null) {
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					sqlstr.append(" , createTime= "+ UtilDAO.oracleToDate(meetingRoomMaintainVO
							.getCreateTime()));
				}else{
					sqlstr.append(" , createTime=? ");
					super.addTimestampForField(meetingRoomMaintainVO
							.getCreateTime());
				}
			}

			if (meetingRoomMaintainVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , STATUS=?");
				super.addIntForField(meetingRoomMaintainVO.getStatus());
			}

			if (meetingRoomMaintainVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , REVISION=? ");
				super.addLongForField(meetingRoomMaintainVO.getRevision());
			}

			if (meetingRoomMaintainVO.getDescription() != null) {
				sqlstr.append(" , DESCRIPTION=? ");
				super.addStringForField(meetingRoomMaintainVO.getDescription());
			}

			if (meetingRoomMaintainVO.getMaintainKey() != null) {
				sqlstr.append(" , maintainKey=? ");
				super.addStringForField(meetingRoomMaintainVO.getMaintainKey());
			}
			if (meetingRoomMaintainVO.getMaintainType() != Integer.MIN_VALUE) {
				sqlstr.append(" , maintainType=?");
				super.addIntForField(meetingRoomMaintainVO.getMaintainType());
			}
			if (meetingRoomMaintainVO.getProcessStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , processStatus=?");
				super.addIntForField(meetingRoomMaintainVO.getProcessStatus());
			}
			
			sqlstr.append(" where maintainID =? ");
			if (meetingRoomMaintainVO.getMaintainID() != null) {
				super.addStringForField(meetingRoomMaintainVO.getMaintainID());
			}
		} else if (DEL_MEETINGROOMMAINTAIN == operatorType) {
			sqlstr.append("delete  from  z_t_meetingroom_maintain ");
			if(meetingRoomMaintainVO.getMaintainID()!=null){
				String[] idArray = meetingRoomMaintainVO.getMaintainID().split(",");
				for(int i=0;i<idArray.length;i++){
					if(i!=0)
						sqlstr.append(" or ");
					sqlstr.append(" maintainID = '"+idArray[i]+"' ");
				}
			}
		} else if (DEL_MEETINGROOMMAINTAIN_KEY == operatorType) {
			sqlstr.append("update  z_t_meetingroom_maintain set ");
			sqlstr.append(" STATUS=?");
			super.addIntForField(MeetingRoomMaintain.STATUS_INVALID);
			sqlstr.append(" where ");
			
			sqlstr.append(" maintainKey = '"+meetingRoomMaintainVO.getMaintainKey()+"' ");
			sqlstr.append(" and maintainType = '"+meetingRoomMaintainVO.getMaintainType()+"' ");
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
