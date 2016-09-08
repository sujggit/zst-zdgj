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
public class LevelConfigJoinMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(LevelConfigJoinMQB.class.getName());

	public static int QUERY_FROM_LEVELCONFIG = 1;
	public static int QUERY_FROM_LEVELCONFIG_ONLY = 2;

	private LevelConfigVO levelConfigVO;
	private ArrayList<LevelConfigVO> listLevelConfig = new ArrayList<LevelConfigVO>();

	private int _operatorType = -1;
	private String ids = "";

	public LevelConfigJoinMQB(int operatorType, LevelConfigVO levelConfigVO) {
		_operatorType = operatorType;
		this.levelConfigVO = levelConfigVO;
		makeSql();
	}

	public LevelConfigJoinMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	
	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(QUERY_FROM_LEVELCONFIG == _operatorType){
			if(LevelEnum.LEVEL_USER.equals(levelConfigVO.getLevelType())){
				strsql.append("SELECT LC.*,L.LEVELNAME,L.LEVELPATH,ZTU.FULLNAME");
				strsql.append(" FROM Z_T_LEVEL_CONFIG LC ");
				strsql.append(" INNER JOIN Z_T_LEVEL L ON L.levelID = LC.levelID");
				strsql.append(" INNER JOIN Z_T_USER ZTU ON ZTU.USERID = LC.levelKey");
				strsql.append(" where 1=1 and LC.status="+LevelEnum.STATUS_LEVELCONFIG_VALID+" and L.status="+LevelEnum.STATUS_LEVEL_VALID+" and ZTU.status!="+UserEnum.INVALID);
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelKeyName())) {
					strsql.append(" and ZTU.FULLNAME= ? ");
					super.addStringForField(levelConfigVO.getLevelKeyName());
				}
			}else if(LevelEnum.LEVEL_ROOM.equals(levelConfigVO.getLevelType())){
				strsql.append("SELECT LC.*,L.LEVELNAME,L.LEVELPATH,mr.meetingroomName");
				strsql.append(" FROM Z_T_LEVEL_CONFIG LC ");
				strsql.append(" INNER JOIN Z_T_LEVEL L ON L.levelID = LC.levelID");
				strsql.append(" INNER JOIN Z_T_MEETINGROOM mr ON mr.meetingroomId = LC.levelKey");
				strsql.append(" where 1=1 and LC.status="+LevelEnum.STATUS_LEVELCONFIG_VALID+" and L.status="+LevelEnum.STATUS_LEVEL_VALID+" and mr.status!="+MeetingRoomEnum.ROOM_STATUS_INVALID);
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelKeyName())) {
					strsql.append(" and mr.meetingroomName= ? ");
					super.addStringForField(levelConfigVO.getLevelKeyName());
				}
			}
			if (null != levelConfigVO) {
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelID())) {
					strsql.append(" and LC.levelID= ? ");
					super.addStringForField(levelConfigVO.getLevelID());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelKey())) {
					strsql.append(" and LC.levelKey= ? ");
					super.addStringForField(levelConfigVO.getLevelKey());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelType())) {
					strsql.append(" and LC.levelType= ? ");
					super.addStringForField(levelConfigVO.getLevelType());
				}
				if (Integer.MIN_VALUE != levelConfigVO.getSuperPower()) {
					strsql.append(" and superPower= ? ");
					super.addIntForField(levelConfigVO.getSuperPower());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getCreateUserId())) {
					strsql.append(" and LC.createUserId= ? ");
					super.addStringForField(levelConfigVO.getCreateUserId());
				}
				if (Integer.MIN_VALUE != levelConfigVO.getStatus()) {
					strsql.append(" and LC.status= ? ");
					super.addIntForField(levelConfigVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getDescription())) {
					strsql.append(" and LC.description= ? ");
					super.addStringForField(levelConfigVO.getDescription());
				}
				if (Long.MIN_VALUE != levelConfigVO.getRevision()) {
					strsql.append(" and LC.revision= ? ");
					super.addLongForField(levelConfigVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelVO().getLevelName())) {
					strsql.append(" and L.LEVELNAME= ? ");
					super.addStringForField(levelConfigVO.getLevelVO().getLevelName());
				}
				if (!StringUtils.isNullOrBlank(levelConfigVO.getLevelVO().getLevelPath())) {
					strsql.append(" and L.LEVELPATH= ? ");
					super.addStringForField(levelConfigVO.getLevelVO().getLevelPath());
				}
			}
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
		LevelConfigVO levelConfigVOTemp = new LevelConfigVO();
		if(QUERY_FROM_LEVELCONFIG==_operatorType){
		levelConfigVOTemp.setLevelID(rs.getString("levelID"));
		levelConfigVOTemp.setLevelKey(rs.getString("levelKey"));
		levelConfigVOTemp.setLevelType(rs.getString("levelType"));
		levelConfigVOTemp.setSuperPower(rs.getInt("superPower"));
		levelConfigVOTemp.setCreateUserId(rs.getString("createUserId"));
		levelConfigVOTemp.setCreateTime(rs.getTimestamp("createTime"));
		levelConfigVOTemp.setStatus(rs.getInt("status"));
		levelConfigVOTemp.setDescription(rs.getString("description"));
		levelConfigVOTemp.setRevision(rs.getLong("revision"));
		
		levelConfigVOTemp.getLevelVO().setLevelName(rs.getString("levelName"));
		levelConfigVOTemp.getLevelVO().setLevelPath(rs.getString("levelPath"));
		
		if(LevelEnum.LEVEL_USER.equals(levelConfigVO.getLevelType())){
			levelConfigVOTemp.setLevelKeyName(rs.getString("fullName"));
		}else if(LevelEnum.LEVEL_ROOM.equals(levelConfigVO.getLevelType())){
			levelConfigVOTemp.setLevelKeyName(rs.getString("meetingroomName"));
		}
		
		}else if(QUERY_FROM_LEVELCONFIG_ONLY==_operatorType){
			
			levelConfigVOTemp.setLevelID(rs.getString("levelID"));
			levelConfigVOTemp.setLevelKey(rs.getString("levelKey"));
			levelConfigVOTemp.setLevelType(rs.getString("levelType"));
		}
		listLevelConfig.add(levelConfigVOTemp);
	}

	public ArrayList<LevelConfigVO> getLevelConfigList() {
		return listLevelConfig;
	}

	public LevelConfigVO getLevelConfigVO() {
		return levelConfigVO;
	}

}
