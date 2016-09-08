package com.zzst.dao.meeting.level;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.level.LevelVO;

/**
 * class description: Level TO
 * 
 * @date Thu Nov 14 10:43:30 CST 2013
 * @author ryan
 */
public class LevelTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(LevelTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_LEVELGRADE = 1;
	public static int MODIFY_LEVELGRADE = 2;
	public static int DEL_LEVELGRADE = 3;
	public static int DEL_LEVELBYPID = 4;
	private int result = 0;

	private LevelVO levelVO;

	public LevelTO(int operatorType, LevelVO levelGradeVO) {
		this.operatorType = operatorType;
		this.levelVO = levelGradeVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_LEVELGRADE == operatorType) {
			sqlstr.append("insert into z_t_level ");
			sqlstr
					.append("(levelID,levelName,pId,levelPath,createUserId,createTime,status,description,revision,nodeServer,nodeIP,nodePort)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(levelVO.getLevelID());
			super.addStringForField(levelVO.getLevelName());
			super.addStringForField(levelVO.getPId());
			super.addStringForField(levelVO.getLevelPath());
			super.addStringForField(levelVO.getCreateUserId());
			super.addTimestampForField(levelVO.getCreateTime());
			super.addIntForField(levelVO.getStatus());
			super.addStringForField(levelVO.getDescription());
			super.addLongForField(levelVO.getRevision());
			super.addIntForField(levelVO.getNodeServer());
			super.addStringForField(levelVO.getNodeIP());
			super.addIntForField(levelVO.getNodePort());
		} else if (MODIFY_LEVELGRADE == operatorType) {
			sqlstr.append("update  z_t_level set ");
			sqlstr.append(" levelID = levelID ");

			if (levelVO.getLevelName() != null) {
				sqlstr.append(" , levelName=? ");
				super.addStringForField(levelVO.getLevelName());
			}

			if (levelVO.getPId() != null) {
				sqlstr.append(" , pId=? ");
				super.addStringForField(levelVO.getPId());
			}

			if (levelVO.getLevelPath() != null) {
				sqlstr.append(" , levelPath=? ");
				super.addStringForField(levelVO.getLevelPath());
			}

			if (levelVO.getCreateUserId() != null) {
				sqlstr.append(" , createUserId=? ");
				super.addStringForField(levelVO.getCreateUserId());
			}

			if (levelVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(levelVO.getCreateTime());
			}

			if (levelVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(levelVO.getStatus());
			}

			if (levelVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(levelVO.getDescription());
			}

			if (levelVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(levelVO.getRevision());
			}
			
			if (levelVO.getNodeServer() != Integer.MIN_VALUE) {
				sqlstr.append(" , nodeServer=?");
				super.addIntForField(levelVO.getNodeServer());
			}
			
			if (levelVO.getNodePort() != Integer.MIN_VALUE) {
				sqlstr.append(" , nodePort=?");
				super.addIntForField(levelVO.getNodePort());
			}
			
			if (levelVO.getNodeIP() != null) {
				sqlstr.append(" , nodeIP=? ");
				super.addStringForField(levelVO.getNodeIP());
			}

			sqlstr.append(" where levelID in (?) ");
			if (levelVO.getLevelID() != null) {
				super.addStringForField(levelVO.getLevelID());
			}
		} else if (DEL_LEVELGRADE == operatorType) {
			sqlstr.append("delete  from  z_t_level ");
			sqlstr.append(" where levelID in (?) ");
			super.addStringForField(levelVO.getLevelID());
		} else if (DEL_LEVELBYPID == operatorType) {
			sqlstr.append("delete  from  z_t_level ");
			sqlstr.append(" where pId in (?) ");
			super.addStringForField(levelVO.getLevelID());
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
