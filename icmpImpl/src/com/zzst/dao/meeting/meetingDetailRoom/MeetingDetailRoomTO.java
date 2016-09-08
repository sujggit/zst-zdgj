package com.zzst.dao.meeting.meetingDetailRoom;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;

/**
 *  
 * @author zhangjy
 * @date 2014-01-14
 */

public class MeetingDetailRoomTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(MeetingDetailRoomTO.class.getName());

	private int operatorType = -1;

	public static int ADD_MEETINGDETAILRoom = 1;

	public static int MODIFY_MEETINGDETAILRoom = 2;

	public static int DEL_MEETINGDETAILRoom = 3;
	
	public static int DEL_ALLMEETINGDETAILRoomS = 4;

	private int result = 0;

	private MeetingDetailRoomVO mdrv;

	public MeetingDetailRoomTO(int operatorType,MeetingDetailRoomVO vMeetingDetailRoomVO) {
		this.operatorType = operatorType;
		this.mdrv = vMeetingDetailRoomVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MEETINGDETAILRoom == operatorType) {
			sqlstr.append("insert into z_t_meetingdetail_room ");
			sqlstr.append("(meetingDetailID,meetingroomID,speed,ismain,description,revision,rank,manNum,info1,info2,info3,info4,info5)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_MEETINGDETAILRoom == operatorType) {
			sqlstr.append("update  z_t_meetingdetail_room set ");
			sqlstr.append(" speed=?,ismain=?,description=?,revision=?,rank=?,manNum=?,info1=?,info2=?,info3=?,info4=?,info5=?");
			sqlstr.append(" where meetingDetailID=? and meetingroomID=? ");
			this.sqlStr = sqlstr.toString();
		}else if (DEL_MEETINGDETAILRoom == operatorType) {
			sqlstr.append("delete  from z_t_meetingdetail_room ");
			sqlstr.append(" where  meetingDetailID= ?");
			super.addStringForField(mdrv.getMeetingDetailId());
			sqlstr.append(" and meetingroomID= ?");
			super.addStringForField(mdrv.getMeetingRoomId());
			this.sqlStr = sqlstr.toString();
		}else if(DEL_ALLMEETINGDETAILRoomS == operatorType){
			sqlstr.append("delete  from z_t_meetingdetail_room ");
			sqlstr.append(" where  meetingDetailID=?");
			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_MEETINGDETAILRoom == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, mdrv.getMeetingDetailId());
				this.stmt.setString(colNum++,mdrv.getMeetingRoomId());
				this.stmt.setInt(colNum++, mdrv.getSpeed());
				this.stmt.setInt(colNum++, mdrv.getIsmain());
				this.stmt.setString(colNum++, mdrv.getDescription());
				this.stmt.setString(colNum++, mdrv.getRevision());
				this.stmt.setString(colNum++, mdrv.getRank());
				this.stmt.setString(colNum++, mdrv.getManNum());
				this.stmt.setString(colNum++, mdrv.getInfo1());
				this.stmt.setString(colNum++, mdrv.getInfo2());
				this.stmt.setString(colNum++, mdrv.getInfo3());
				this.stmt.setString(colNum++, mdrv.getInfo4());
				this.stmt.setString(colNum++, mdrv.getInfo5());
			} else if (MODIFY_MEETINGDETAILRoom == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, mdrv.getSpeed());
				this.stmt.setInt(colNum++, mdrv.getIsmain());
				this.stmt.setString(colNum++, mdrv.getDescription());
				this.stmt.setString(colNum++, mdrv.getRevision());
				this.stmt.setString(colNum++, mdrv.getRank());
				this.stmt.setString(colNum++, mdrv.getManNum());
				this.stmt.setString(colNum++, mdrv.getInfo1());
				this.stmt.setString(colNum++, mdrv.getInfo2());
				this.stmt.setString(colNum++, mdrv.getInfo3());
				this.stmt.setString(colNum++, mdrv.getInfo4());
				this.stmt.setString(colNum++, mdrv.getInfo5());
				
				this.stmt.setString(colNum++, mdrv.getMeetingDetailId());
				this.stmt.setString(colNum++,mdrv.getMeetingRoomId());
			} else if (DEL_MEETINGDETAILRoom == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, mdrv.getMeetingDetailId());
				this.stmt.setString(colNum++,mdrv.getMeetingRoomId());
			} else if(DEL_ALLMEETINGDETAILRoomS == operatorType){
				int colNum = 1;
				this.stmt.setString(colNum++, mdrv.getMeetingDetailId());			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" MEETINGDETAILRoomTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" MEETINGDETAILRoomTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
