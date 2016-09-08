package com.zzst.dao.meeting.levelConfig;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;

/**
 * class description: LevelConfig TO
 * 
 * @date Mon Nov 18 11:28:49 CST 2013
 * @author ryan
 */
public class LevelConfigTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(LevelConfigTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_LEVELCONFIG = 1;
	public static int MODIFY_LEVELCONFIG = 2;
	public static int DEL_LEVELCONFIG = 3;
	public static final int DEL_LEVELVO = 4;
	private int result = 0;

	private LevelConfigVO levelConfigVO;

	public LevelConfigTO(int operatorType, LevelConfigVO levelConfigVO) {
		this.operatorType = operatorType;
		this.levelConfigVO = levelConfigVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_LEVELCONFIG == operatorType) {
			sqlstr.append("insert into z_t_level_config ");
			sqlstr
					.append("(levelID,levelKey,levelType,superPower,createUserId,createTime,status,description,revision,lid)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(levelConfigVO.getLevelID());
			super.addStringForField(levelConfigVO.getLevelKey());
			super.addStringForField(levelConfigVO.getLevelType());
			super.addIntForField(levelConfigVO.getSuperPower());
			super.addStringForField(levelConfigVO.getCreateUserId());
			super.addTimestampForField(levelConfigVO.getCreateTime());
			super.addIntForField(levelConfigVO.getStatus());
			super.addStringForField(levelConfigVO.getDescription());
			super.addLongForField(levelConfigVO.getRevision());
			super.addStringForField(levelConfigVO.getLid());
		} else if (MODIFY_LEVELCONFIG == operatorType) {
			sqlstr.append("update  z_t_level_config set ");
			sqlstr.append(" levelID = levelID ");

			if (levelConfigVO.getLevelKey() != null) {
				sqlstr.append(" , levelKey=? ");
				super.addStringForField(levelConfigVO.getLevelKey());
			}

			if (levelConfigVO.getLevelType() != null) {
				sqlstr.append(" , levelType=? ");
				super.addStringForField(levelConfigVO.getLevelType());
			}

			if (Integer.MIN_VALUE != levelConfigVO.getSuperPower()) {
				sqlstr.append(" and superPower= ? ");
				super.addIntForField(levelConfigVO.getSuperPower());
			}
			
			if (levelConfigVO.getCreateUserId() != null) {
				sqlstr.append(" , createUserId=? ");
				super.addStringForField(levelConfigVO.getCreateUserId());
			}

			if (levelConfigVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(levelConfigVO.getCreateTime());
			}

			if (levelConfigVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(levelConfigVO.getStatus());
			}

			if (levelConfigVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(levelConfigVO.getDescription());
			}

			if (levelConfigVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(levelConfigVO.getRevision());
			}

			sqlstr.append(" where levelID in (?) ");
			if (levelConfigVO.getLevelID() != null) {
				super.addStringForField(levelConfigVO.getLevelID());
			}
		} else if (DEL_LEVELCONFIG == operatorType) {
			sqlstr.append("delete  from  z_t_level_config ");
			sqlstr.append(" where levelID in (?) ");
			super.addStringForField(levelConfigVO.getLevelID());
		}else if (DEL_LEVELVO == operatorType) {
			if(levelConfigVO!=null){
				sqlstr.append("delete  from  z_t_level_config ");
				sqlstr.append(" where 1=1 ");
				if(levelConfigVO.getLevelID() !=null){
					sqlstr.append("and levelID=?");
					super.addStringForField(levelConfigVO.getLevelID());
				}
				if(levelConfigVO.getLevelType() !=null){
					sqlstr.append("and levelType=?");
					super.addStringForField(levelConfigVO.getLevelType());
				}
				if(levelConfigVO.getLevelKey() !=null){
					sqlstr.append("and levelKey=?");
					super.addStringForField(levelConfigVO.getLevelKey());
				}
				if(levelConfigVO.getSuperPower() != Integer.MIN_VALUE){
					sqlstr.append("and superPower=?");
					super.addIntForField(levelConfigVO.getSuperPower());
				}
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
