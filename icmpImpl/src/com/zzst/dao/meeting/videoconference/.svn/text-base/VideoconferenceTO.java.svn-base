package com.zzst.dao.meeting.videoconference;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

/**
 * class description: Videoconference TO
 * 
 * @author ryan
 * @date Mon Aug 24 13:32:23 CST 2009
 */

public class VideoconferenceTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(VideoconferenceTO.class
			.getName());

	private int operatorType = -1;

	public static int ADD_VIDEOCONFERENCE = 1;

	public static int MODIFY_VIDEOCONFERENCE = 2;

	public static int DEL_VIDEOCONFERENCE = 3;
	public static int DEL_ALLVIDEOCONFERENCEs = 4;

	private int result = 0;

	private VideoconferenceVO vVideoconferenceVO;

	public VideoconferenceTO(int operatorType,
			VideoconferenceVO vVideoconferenceVO) {
		this.operatorType = operatorType;
		this.vVideoconferenceVO = vVideoconferenceVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_VIDEOCONFERENCE == operatorType) {
			sqlstr.append("insert into z_t_meetingdetail_room ");
			sqlstr.append("(meetingDetailID,meetingroomID,speed,ismain,description,revision,rank)");
			sqlstr.append(" values (?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_VIDEOCONFERENCE == operatorType) {
			sqlstr.append("update  z_t_meetingdetail_room set ");
			sqlstr
					.append(" meetingDetailID=?,meetingroomID=?,speed=?,ismain=?,description=?,rank=?");
			sqlstr.append(" where videoconferenceID= ? ");

			this.sqlStr = sqlstr.toString();
		}else if (DEL_VIDEOCONFERENCE == operatorType) {
			sqlstr.append("delete  from z_t_meetingdetail_room ");
			sqlstr.append(" where meetingDetailID= ? and meetingroomID=?");

			this.sqlStr = sqlstr.toString();
		}else if(DEL_ALLVIDEOCONFERENCEs == operatorType) {
			sqlstr.append("delete  from z_t_meetingdetail_room ");
			sqlstr.append(" where meetingDetailID= ?");

			this.sqlStr = sqlstr.toString();			
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_VIDEOCONFERENCE == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vVideoconferenceVO
						.getMeetingDetailID());
				this.stmt.setString(colNum++, vVideoconferenceVO
						.getSubmeetingRoomID());
				this.stmt.setInt(colNum++, vVideoconferenceVO.getRate());
				this.stmt.setInt(colNum++, vVideoconferenceVO.getIsmain());
				this.stmt.setString(colNum++, vVideoconferenceVO.getDescription());
				this.stmt.setLong(colNum++, vVideoconferenceVO.getRevision());
				this.stmt.setString(colNum++, vVideoconferenceVO.getRank());
			} else if (MODIFY_VIDEOCONFERENCE == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vVideoconferenceVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vVideoconferenceVO.getSubmeetingRoomID());
				this.stmt.setInt(colNum++, vVideoconferenceVO.getRate());
				this.stmt.setInt(colNum++, vVideoconferenceVO.getIsmain());
				this.stmt.setString(colNum++, vVideoconferenceVO.getDescription());
				this.stmt.setString(colNum++, vVideoconferenceVO.getRank());
				this.stmt.setString(colNum++, vVideoconferenceVO.getMeetingDetailID());
				//this.stmt.setString(colNum++, vVideoconferenceVO.getOldMeetingRoomID());
			}else if (DEL_VIDEOCONFERENCE == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vVideoconferenceVO.getMeetingDetailID());
				this.stmt.setString(colNum++, vVideoconferenceVO.getSubmeetingRoomID());
			}else if (DEL_ALLVIDEOCONFERENCEs == operatorType) {
				int colNum = 1;
				this.stmt.setString(colNum++, vVideoconferenceVO.getMeetingDetailID());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" VIDEOCONFERENCETO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" VIDEOCONFERENCETO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
