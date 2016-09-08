package com.zzst.dao.meeting.announcement;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.announcement.AnnouncementVO;

/**
 * class description: Announcement TO
 * 
 * @author ryan
 * @date Fri Aug 28 10:29:05 CST 2009
 */

public class AnnouncementTO extends TransactionObject {

	static Logger logger = CbfLogger.getLogger(AnnouncementTO.class.getName());

	private int operatorType = -1;

	public static int ADD_ANNOUNCEMENT = 1;

	public static int MODIFY_ANNOUNCEMENT = 2;

	public static int DEL_ANNOUNCEMENT = 3;

	private int result = 0;

	private AnnouncementVO vAnnouncementVO;

	public AnnouncementTO(int operatorType, AnnouncementVO vAnnouncementVO) {
		this.operatorType = operatorType;
		this.vAnnouncementVO = vAnnouncementVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_ANNOUNCEMENT == operatorType) {
			sqlstr.append("insert into t_Announcement ");
			sqlstr
					.append("(userID,userName,createTime,startTime,endTime,title,content,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?)");
			this.sqlStr = sqlstr.toString();
		} else if (MODIFY_ANNOUNCEMENT == operatorType) {
			sqlstr.append("update  t_Announcement set ");
			sqlstr
					.append(" userID=?,userName=?,createTime=?,startTime=?,endTime=?,title=?,content=?,description=?");
			sqlstr.append(" where announcementID= ? ");

			this.sqlStr = sqlstr.toString();
		}else if (DEL_ANNOUNCEMENT == operatorType) {
			sqlstr.append("delete  from t_Announcement ");
			sqlstr.append(" where announcementID= ?");
			this.sqlStr = sqlstr.toString();
		}
	}

	public void setValues() throws SQLException {
		try {
			if (ADD_ANNOUNCEMENT == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vAnnouncementVO.getUserID());
				this.stmt.setString(colNum++, vAnnouncementVO.getUserName());
				this.stmt.setTimestamp(colNum++, vAnnouncementVO
						.getCreateTime());
				this.stmt
						.setTimestamp(colNum++, vAnnouncementVO.getStartTime());
				this.stmt.setTimestamp(colNum++, vAnnouncementVO.getEndTime());
				this.stmt.setString(colNum++, vAnnouncementVO.getTitle());
				this.stmt.setString(colNum++, vAnnouncementVO.getContent());
				this.stmt.setString(colNum++, vAnnouncementVO.getDescription());
				this.stmt.setLong(colNum++, vAnnouncementVO.getRevision());

			} else if (MODIFY_ANNOUNCEMENT == operatorType) {
				int colNum = 1;

				this.stmt.setInt(colNum++, vAnnouncementVO.getUserID());

				this.stmt.setString(colNum++, vAnnouncementVO.getUserName());

				this.stmt.setTimestamp(colNum++, vAnnouncementVO
						.getCreateTime());

				this.stmt
						.setTimestamp(colNum++, vAnnouncementVO.getStartTime());

				this.stmt.setTimestamp(colNum++, vAnnouncementVO.getEndTime());

				this.stmt.setString(colNum++, vAnnouncementVO.getTitle());

				this.stmt.setString(colNum++, vAnnouncementVO.getContent());

				this.stmt.setString(colNum++, vAnnouncementVO.getDescription());

				this.stmt.setInt(colNum++, vAnnouncementVO.getAnnouncementID());

			}else if (DEL_ANNOUNCEMENT == operatorType) {
				int colNum = 1;
				this.stmt.setInt(colNum++, vAnnouncementVO.getAnnouncementID());
			}
		} catch (Exception e) {
			throw new SQLException(e.toString());
		}

	}

	public void execute() throws SQLException {
		logger.info(" ANNOUNCEMENTTO execute begin::::::");
		result = this.stmt.executeUpdate();
		logger.info("execute  number is: " + result);
		logger.info(" ANNOUNCEMENTTO execute end::::::");
	}

	public int getexecuteResult() {
		return result;
	}

}
