package com.zzst.dao.meeting.meetingRoom;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.cbfImpl.util.IntegerUtils;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

/**
 * class description: MeetingRoom TO
 * 
 * @author linsha
 * @date 2011-11-15
 */

public class MeetingRoomTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(MeetingRoomTO.class.getName());

	private int operatorType = -1;

	public static int 		ADD_MEETINGROOM 		= 	1	;
	public static int 		MODIFY_MEETINGROOM 		= 	2	;
	public static int 		DEL_MEETINGROOM 		= 	3	;
	public	static	int		MODIFY_IP_PORT			=	4	;
	public static int    MODIFY_STATE=5;
	public static int      UPDATE_BY_ROOMNO = 6;
	private int result = 0;

	private MeetingRoomVO meetingRoomVO;
	private String ids = "";

	public MeetingRoomTO(int operatorType, MeetingRoomVO meetingRoomVO) {
		this.operatorType = operatorType;
		this.meetingRoomVO = meetingRoomVO;
	}

	public MeetingRoomTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}
	
	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGROOM == operatorType) {
			sqlstr.append("insert into z_t_Meetingroom ");
			sqlstr.append("(meetingRoomID,meetingRoomName,roomNO");
			sqlstr.append(",meetingroomType,capacity,planeImg");
			sqlstr.append(",pictureImg,meetingroomUrl,status,adminID,departmentID");
			sqlstr.append(",addressID,description,revision,roomPCA");
			sqlstr.append(")");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(meetingRoomVO.getMeetingRoomID());
			super.addStringForField(meetingRoomVO.getMeetingRoomName());
			super.addStringForField(meetingRoomVO.getRoomNO());
			super.addIntForField(meetingRoomVO.getMeetingRoomType());
			super.addIntForField(meetingRoomVO.getCapacity());
			super.addStringForField(meetingRoomVO.getPlaneImg());
			super.addStringForField(meetingRoomVO.getPictureImg());
			super.addStringForField(meetingRoomVO.getMeetingroomUrl());
			super.addIntForField(meetingRoomVO.getStatus());
//			super.addStringForField(meetingRoomVO.getAdminID());
//			super.addStringForField(meetingRoomVO.getDepartmentID());
			super.addStringForField(meetingRoomVO.getUserVO().getUserID());
			super.addStringForField(meetingRoomVO.getDepartmentVO().getId());
			super.addStringForField(meetingRoomVO.getAddressVO().getAddressID());
			super.addStringForField(meetingRoomVO.getDescription());
			super.addIntForField(meetingRoomVO.getRevision());
			super.addStringForField(meetingRoomVO.getRoomPCA());
			
			
		} else if (MODIFY_MEETINGROOM == operatorType) {
			sqlstr.append("update  z_t_Meetingroom set ");
			sqlstr.append(" meetingRoomID = meetingRoomID ");

			if (meetingRoomVO.getMeetingRoomName()!= null) {
				sqlstr.append(" , meetingRoomName=? ");
				super.addStringForField(meetingRoomVO.getMeetingRoomName());
			}

			if (meetingRoomVO.getRoomNO() != null) {
				sqlstr.append(" , roomNO=? ");
				super.addStringForField(meetingRoomVO.getRoomNO());
			}

			if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getMeetingRoomType())) {
				sqlstr.append(" , meetingroomType=? ");
				super.addIntForField(meetingRoomVO.getMeetingRoomType());
			}
			
			if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getCapacity())) {
				sqlstr.append(" , capacity=? ");
				super.addIntForField(meetingRoomVO.getCapacity());
			}

			if (meetingRoomVO.getPlaneImg() != null) {
				sqlstr.append(" , planeImg=? ");
				super.addStringForField(meetingRoomVO.getPlaneImg());
			}

			if (meetingRoomVO.getPictureImg()!= null) {
				sqlstr.append(" , pictureImg=?");
				super.addStringForField(meetingRoomVO.getPictureImg());
			}

			if (meetingRoomVO.getMeetingroomUrl()!= null) {
				sqlstr.append(" , meetingRoomUrl=? ");
				super.addStringForField(meetingRoomVO.getMeetingroomUrl());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getStatus())) {
				sqlstr.append(" , status=? ");
				super.addIntForField(meetingRoomVO.getStatus());
			}
			
//			if (meetingRoomVO.getAdminID()!=null) {
//				sqlstr.append(" , adminID=? ");
//				super.addStringForField(meetingRoomVO.getAdminID());
//			}
//
//			if (meetingRoomVO.getDepartmentID() != null) {
//				sqlstr.append(" , departmentID=? ");
//				super.addStringForField(meetingRoomVO.getDepartmentID());
//			}
			
			if (meetingRoomVO.getUserVO().getUserID()!=null) {
				sqlstr.append(" , adminID=? ");
				super.addStringForField(meetingRoomVO.getUserVO().getUserID());
			}

			if (meetingRoomVO.getDepartmentVO().getId() != null) {
				sqlstr.append(" , departmentID=? ");
				super.addStringForField(meetingRoomVO.getDepartmentVO().getId());
			}
			
			if (meetingRoomVO.getAddressVO().getAddressID() != null&& meetingRoomVO.getAddressVO() !=null) {
				sqlstr.append(" , addressID=? ");
				super.addStringForField(meetingRoomVO.getAddressVO().getAddressID());
			}
			if (meetingRoomVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(meetingRoomVO.getDescription());
			}
			if (meetingRoomVO.getRoomPCA() != null) {
				sqlstr.append(" , roomPCA=? ");
				super.addStringForField(meetingRoomVO.getRoomPCA());
			}
			if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getRevision())) {
				sqlstr.append(" , revision=?");
				super.addIntForField(meetingRoomVO.getRevision());
			}
		
			sqlstr.append(" where meetingRoomID in (?) ");
	    	super.addStringForField(meetingRoomVO.getMeetingRoomID());

		
		} else if (DEL_MEETINGROOM == operatorType) {
			sqlstr.append("delete  from  z_t_Meetingroom ");
			sqlstr.append(" where meetingRoomID in (?) ");
			super.addStringForField(ids);
		 }else if(MODIFY_STATE==operatorType){
		    sqlstr.append("update  z_t_Meetingroom set");
			sqlstr.append(" status= "+MeetingRoomEnum.ROOM_STATUS_INVALID);
			sqlstr.append(" where meetingRoomID in (?) ");
			super.addStringForField(meetingRoomVO.getMeetingRoomID());
		}else if ( UPDATE_BY_ROOMNO == operatorType){
			sqlstr.append("update  z_t_Meetingroom set ");
			sqlstr.append(" meetingRoomID = meetingRoomID ");
			
			if( meetingRoomVO != null ){
				if (meetingRoomVO.getMeetingRoomName()!= null) {
					sqlstr.append(" , meetingRoomName=? ");
					super.addStringForField(meetingRoomVO.getMeetingRoomName());
				}
	
	
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getMeetingRoomType())) {
					sqlstr.append(" , meetingroomType=? ");
					super.addIntForField(meetingRoomVO.getMeetingRoomType());
				}
				
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getCapacity())) {
					sqlstr.append(" , capacity=? ");
					super.addIntForField(meetingRoomVO.getCapacity());
				}
	
				if (meetingRoomVO.getPlaneImg() != null) {
					sqlstr.append(" , planeImg=? ");
					super.addStringForField(meetingRoomVO.getPlaneImg());
				}
	
				if (meetingRoomVO.getPictureImg()!= null) {
					sqlstr.append(" , pictureImg=?");
					super.addStringForField(meetingRoomVO.getPictureImg());
				}
	
				if (meetingRoomVO.getMeetingroomUrl()!= null) {
					sqlstr.append(" , meetingRoomUrl=? ");
					super.addStringForField(meetingRoomVO.getMeetingroomUrl());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getStatus())) {
					sqlstr.append(" , status=? ");
					super.addIntForField(meetingRoomVO.getStatus());
				}
				
				if (meetingRoomVO.getRoomPCA() != null) {
					sqlstr.append(" , roomPCA=? ");
					super.addStringForField(meetingRoomVO.getRoomPCA());
				}
				if (meetingRoomVO.getUserVO().getUserID()!=null) {
					sqlstr.append(" , adminID=? ");
					super.addStringForField(meetingRoomVO.getUserVO().getUserID());
				}
	
				if (meetingRoomVO.getDepartmentVO().getId() != null) {
					sqlstr.append(" , departmentID=? ");
					super.addStringForField(meetingRoomVO.getDepartmentVO().getId());
				}
				
				if (meetingRoomVO.getAddressVO().getAddressID() != null) {
					sqlstr.append(" , addressID=? ");
					super.addStringForField(meetingRoomVO.getAddressVO().getAddressID());
				}
				if (meetingRoomVO.getDescription() != null) {
					sqlstr.append(" , description=? ");
					super.addStringForField(meetingRoomVO.getDescription());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getRevision())) {
					sqlstr.append(" , revision=?");
					super.addIntForField(meetingRoomVO.getRevision());
				}
		
			}
			sqlstr.append(" where roomNO = ? ");
	    	super.addStringForField(meetingRoomVO.getRoomNO());
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
