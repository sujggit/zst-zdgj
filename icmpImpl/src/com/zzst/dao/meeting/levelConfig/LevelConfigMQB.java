package com.zzst.dao.meeting.levelConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;

/**
 * class description: LevelConfig MQB
 * 
 * @date Mon Nov 18 11:28:49 CST 2013
 * @author ryan
 */
public class LevelConfigMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(LevelConfigMQB.class.getName());

	public static int QUERY_FROM_LEVELCONFIG = 1;
	public static int QUERY_FROM_LEVELCONFIG_BY_IDS = 2;

	private LevelConfigVO levelConfigVO;
	private ArrayList<LevelConfigVO> listLevelConfig = new ArrayList<LevelConfigVO>();

	private int _operatorType = -1;
	private String ids = "";

	public LevelConfigMQB(int operatorType, LevelConfigVO levelConfigVO) {
		_operatorType = operatorType;
		this.levelConfigVO = levelConfigVO;
		makeSql();
	}

	public LevelConfigMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	
	public LevelConfigMQB(LevelConfigVO levelConfigVO) {
		this.levelConfigVO = levelConfigVO;
		makeSql2();
	}

	private void makeSql2() {
		StringBuffer strsql = new StringBuffer();
		if(LevelEnum.LEVEL_USER.equals(levelConfigVO.getLevelType())){
			strsql.append("SELECT LC.*,L.LEVELNAME,ZTU.FULLNAME");
			strsql.append(" FROM Z_T_LEVEL_CONFIG LC ");
			strsql.append(" INNER JOIN Z_T_LEVEL L ON L.levelID = LC.levelID");
			strsql.append(" INNER JOIN Z_T_USER ZTU ON ZTU.USERID = LC.levelKey");
			strsql.append(" where 1=1 and LC.status="+LevelEnum.STATUS_LEVELCONFIG_VALID+" and L.status="+LevelEnum.STATUS_LEVEL_VALID+" and ZTU.status!="+UserEnum.INVALID);
		}else if(LevelEnum.LEVEL_ROOM.equals(levelConfigVO.getLevelType())){
			strsql.append("SELECT LC.*,L.LEVELNAME,mr.meetingroomName");
			strsql.append(" FROM Z_T_LEVEL_CONFIG LC ");
			strsql.append(" INNER JOIN Z_T_LEVEL L ON L.levelID = LC.levelID");
			strsql.append(" INNER JOIN Z_T_MEETINGROOM mr ON mr.meetingroomId = LC.levelKey");
			strsql.append(" where 1=1 and LC.status="+LevelEnum.STATUS_LEVELCONFIG_VALID+" and L.status="+LevelEnum.STATUS_LEVEL_VALID+" and mr.status!="+MeetingRoomEnum.ROOM_STATUS_INVALID);
		}
		
		setSql(strsql.toString());
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select levelID,levelKey,levelType,superPower,createUserId,createTime,status,description,revision,lid ");
		strsql.append(" from z_t_level_config ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_LEVELCONFIG == _operatorType) {
			if (null != levelConfigVO) {
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelID())) {
					strsql.append(" and levelID= ? ");
					super.addStringForField(levelConfigVO.getLevelID());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelKey())) {
					strsql.append(" and levelKey= ? ");
					super.addStringForField(levelConfigVO.getLevelKey());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelType())) {
					strsql.append(" and levelType= ? ");
					super.addStringForField(levelConfigVO.getLevelType());
				}
				if (Integer.MIN_VALUE != levelConfigVO.getSuperPower()) {
					strsql.append(" and superPower= ? ");
					super.addIntForField(levelConfigVO.getSuperPower());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getCreateUserId())) {
					strsql.append(" and createUserId= ? ");
					super.addStringForField(levelConfigVO.getCreateUserId());
				}
				if (Integer.MIN_VALUE != levelConfigVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(levelConfigVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(levelConfigVO.getDescription());
				}
				if (Long.MIN_VALUE != levelConfigVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(levelConfigVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLid())) {
					strsql.append(" and lid= ? ");
					super.addStringForField(levelConfigVO.getLid());
				}
			}
		} else if (QUERY_FROM_LEVELCONFIG_BY_IDS == _operatorType) {
			strsql.append(" and levelID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		levelConfigVO = new LevelConfigVO();
		levelConfigVO.setLevelID(rs.getString("levelID"));
		levelConfigVO.setLevelKey(rs.getString("levelKey"));
		levelConfigVO.setLevelType(rs.getString("levelType"));
		levelConfigVO.setSuperPower(rs.getInt("superPower"));
		levelConfigVO.setCreateUserId(rs.getString("createUserId"));
		levelConfigVO.setCreateTime(rs.getTimestamp("createTime"));
		levelConfigVO.setStatus(rs.getInt("status"));
		levelConfigVO.setDescription(rs.getString("description"));
		levelConfigVO.setRevision(rs.getLong("revision"));
		levelConfigVO.getLevelVO().setLevelID(rs.getString("levelID"));
		levelConfigVO.setLid(rs.getString("lid"));
		listLevelConfig.add(levelConfigVO);
	}

	public ArrayList<LevelConfigVO> getLevelConfigList() {
		return listLevelConfig;
	}

	public LevelConfigVO getLevelConfigVO() {
		return levelConfigVO;
	}

}
