package com.zzst.dao.meeting.comparison;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.comparison.ComparisonVO;

/**
 * class description: Comparison TO
 * 
 * @date Sat Apr 27 13:39:44 CST 2013
 * @author ryan
 */
public class ComparisonTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ComparisonTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_COMPARISON = 1;
	public static int MODIFY_COMPARISON = 2;
	public static int DEL_COMPARISON = 3;
	public static int REPLACE_COMPARISON = 4;
	public static int DEL_BYMEETINGID_COMPARISON = 5;
	public static int MODIFY_COMPARISON_AUDIO = 6;
	private int result = 0;

	private ComparisonVO comparisonVO;
	private String ids = "";

	public ComparisonTO(int operatorType, ComparisonVO comparisonVO) {
		this.operatorType = operatorType;
		this.comparisonVO = comparisonVO;
	}

	public ComparisonTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_COMPARISON == operatorType) {
			sqlstr.append("insert into Z_T_MEETING_COMPARISON ");
			sqlstr
			.append("(ID,compDetailID,meetingDetailID,meetingRoomID,upVideoQuality,downVideoQuality,upAudioQuality,downAudioQuality,sendPacketLoss,receivePacketLoss,sendframeRate,receiveframeRate,updateTime,updateUserID,result,status,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(comparisonVO.getID());
			super.addStringForField(comparisonVO.getCompDetailID());
			super.addStringForField(comparisonVO.getMeetingDetailID());
			super.addStringForField(comparisonVO.getMeetingRoomID());
			super.addIntForField(comparisonVO.getUpVideoQuality());
			super.addIntForField(comparisonVO.getDownVideoQuality());
			super.addIntForField(comparisonVO.getUpAudioQuality());
			super.addIntForField(comparisonVO.getDownAudioQuality());
			super.addFloatForField(comparisonVO.getSendPacketLoss());
			super.addFloatForField(comparisonVO.getReceivePacketLoss());
			super.addIntForField(comparisonVO.getSendframeRate());
			super.addIntForField(comparisonVO.getReceiveframeRate());
			super.addTimestampForField(comparisonVO.getUpdateTime());
			super.addStringForField(comparisonVO.getUpdateUserID());
			super.addIntForField(comparisonVO.getResult());
			super.addIntForField(comparisonVO.getStatus());
			super.addStringForField(comparisonVO.getDescription());
		}else if (MODIFY_COMPARISON == operatorType) {
			sqlstr.append("update  Z_T_MEETING_COMPARISON set ");
			sqlstr.append(" ID = ID ");

			if (comparisonVO.getCompDetailID() != null) {
				sqlstr.append(" , compDetailID=? ");
				super.addStringForField(comparisonVO.getCompDetailID());
			}

			if (comparisonVO.getMeetingDetailID() != null) {
				sqlstr.append(" , meetingDetailID=? ");
				super.addStringForField(comparisonVO.getMeetingDetailID());
			}

			if (comparisonVO.getMeetingRoomID() != null) {
				sqlstr.append(" , meetingRoomID=? ");
				super.addStringForField(comparisonVO.getMeetingRoomID());
			}

			if (comparisonVO.getUpVideoQuality() != Integer.MIN_VALUE) {
				sqlstr.append(" , upVideoQuality=?");
				super.addIntForField(comparisonVO.getUpVideoQuality());
			}

			if (comparisonVO.getDownVideoQuality() != Integer.MIN_VALUE) {
				sqlstr.append(" , downVideoQuality=?");
				super.addIntForField(comparisonVO.getDownVideoQuality());
			}

			if (comparisonVO.getUpAudioQuality() != Integer.MIN_VALUE) {
				sqlstr.append(" , upAudioQuality=?");
				super.addIntForField(comparisonVO.getUpAudioQuality());
			}

			if (comparisonVO.getDownAudioQuality() != Integer.MIN_VALUE) {
				sqlstr.append(" , downAudioQuality=?");
				super.addIntForField(comparisonVO.getDownAudioQuality());
			}

			if (comparisonVO.getSendPacketLoss() != Float.MIN_VALUE) {
				sqlstr.append(" , sendPacketLoss=? ");
				super.addFloatForField(comparisonVO.getSendPacketLoss());
			}

			if (comparisonVO.getReceivePacketLoss() != Float.MIN_VALUE) {
				sqlstr.append(" , receivePacketLoss=? ");
				super.addFloatForField(comparisonVO.getReceivePacketLoss());
			}

			if (comparisonVO.getSendframeRate() != Integer.MIN_VALUE) {
				sqlstr.append(" , sendframeRate=?");
				super.addIntForField(comparisonVO.getSendframeRate());
			}

			if (comparisonVO.getReceiveframeRate() != Integer.MIN_VALUE) {
				sqlstr.append(" , receiveframeRate=?");
				super.addIntForField(comparisonVO.getReceiveframeRate());
			}

			if (comparisonVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(comparisonVO.getUpdateTime());
			}

			if (comparisonVO.getUpdateUserID() != null) {
				sqlstr.append(" , updateUserID=? ");
				super.addStringForField(comparisonVO.getUpdateUserID());
			}

			if (comparisonVO.getResult() != Integer.MIN_VALUE) {
				sqlstr.append(" , result=?");
				super.addIntForField(comparisonVO.getResult());
			}

			if (comparisonVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(comparisonVO.getStatus());
			}

			if (comparisonVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(comparisonVO.getDescription());
			}

			sqlstr.append(" where ID in (?) ");
			if (comparisonVO.getID() != null) {
				super.addStringForField(comparisonVO.getID());
			}
		} else if (DEL_COMPARISON == operatorType) {
			sqlstr.append("delete  from  Z_T_MEETING_COMPARISON ");
			sqlstr.append(" where ID in (?) ");
			super.addStringForField(ids);
		} else if (REPLACE_COMPARISON == operatorType) {
			sqlstr.append("replace into Z_T_MEETING_COMPARISON ");
			sqlstr
			.append("(ID,compDetailID,meetingDetailID,meetingRoomID,upVideoQuality,downVideoQuality,upAudioQuality,downAudioQuality,sendPacketLoss,receivePacketLoss,sendframeRate,receiveframeRate,updateTime,updateUserID,result,status,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(comparisonVO.getID());
			super.addStringForField(comparisonVO.getCompDetailID());
			super.addStringForField(comparisonVO.getMeetingDetailID());
			super.addStringForField(comparisonVO.getMeetingRoomID());
			super.addIntForField(comparisonVO.getUpVideoQuality());
			super.addIntForField(comparisonVO.getDownVideoQuality());
			super.addIntForField(comparisonVO.getUpAudioQuality());
			super.addIntForField(comparisonVO.getDownAudioQuality());
			super.addFloatForField(comparisonVO.getSendPacketLoss());
			super.addFloatForField(comparisonVO.getReceivePacketLoss());
			super.addIntForField(comparisonVO.getSendframeRate());
			super.addIntForField(comparisonVO.getReceiveframeRate());
			super.addTimestampForField(comparisonVO.getUpdateTime());
			super.addStringForField(comparisonVO.getUpdateUserID());
			super.addIntForField(comparisonVO.getResult());
			super.addIntForField(comparisonVO.getStatus());
			super.addStringForField(comparisonVO.getDescription());
		}else if (DEL_BYMEETINGID_COMPARISON == operatorType) {
			sqlstr.append("delete  from  Z_T_MEETING_COMPARISON ");
			sqlstr.append(" where meetingDetailID in (?) ");
			super.addStringForField(ids);
		}else if (MODIFY_COMPARISON_AUDIO == operatorType) {
			sqlstr.append("update  Z_T_MEETING_COMPARISON set ");
			sqlstr.append(" ID = ID ");

			
			if (comparisonVO.getUpAudioQuality() != Integer.MIN_VALUE) {
				sqlstr.append(" , upAudioQuality=?");
				super.addIntForField(comparisonVO.getUpAudioQuality());
			}

			if (comparisonVO.getDownAudioQuality() != Integer.MIN_VALUE) {
				sqlstr.append(" , downAudioQuality=?");
				super.addIntForField(comparisonVO.getDownAudioQuality());
			}
			
			if (comparisonVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(comparisonVO.getDescription());
			}
			
			sqlstr.append(" where ID = ? ");
			if (comparisonVO.getID() != null) {
				super.addStringForField(comparisonVO.getID());
			}
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
