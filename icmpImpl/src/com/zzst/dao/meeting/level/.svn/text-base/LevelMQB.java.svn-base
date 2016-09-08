package com.zzst.dao.meeting.level;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.level.LevelVO;

/**
 * class description: Level MQB
 * 
 * @date Thu Nov 14 10:43:30 CST 2013
 * @author ryan
 */
public class LevelMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(LevelMQB.class.getName());

	public static int QUERY_FROM_LEVELGRADE = 1;
	public static int QUERY_FROM_LEVELGRADE_BY_IDS = 2;
	
	public static int QUERY_FROM_LEVELBYPID = 3;
	
	public static int QUERY_CHECK_CHILD = 4;
	
	public static int QUERY_CHECK_CHILD_ONE = 5;
	

	private LevelVO levelVO;
	private ArrayList<LevelVO> listLevel = new ArrayList<LevelVO>();

	private int _operatorType = -1;
	private String ids = "";
	
	private boolean res = false;
	
	public LevelMQB(int operatorType) {
		_operatorType = operatorType;
	}

	public LevelMQB(int operatorType, LevelVO levelGradeVO) {
		_operatorType = operatorType;
		this.levelVO = levelGradeVO;
		makeSql();
	}

	public LevelMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		LevelVO levelVO = new LevelVO();
		levelVO.setLevelID(ids);
		this.levelVO = levelVO;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select levelID,levelName,pId,levelPath,createUserId,createTime,status,description,revision,nodeServer,nodeIP,nodePort ");
		strsql.append(" from z_t_level ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_LEVELGRADE == _operatorType) {
			if (null != levelVO) {
				if (!StringUtils.isNullOrBlank(levelVO.getLevelID())) {
					strsql.append(" and levelID= ? ");
					super.addStringForField(levelVO.getLevelID());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getLevelName())) {
					strsql.append(" and levelName= ? ");
					super.addStringForField(levelVO.getLevelName());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getPId())) {
					strsql.append(" and pId= ? ");
					super.addStringForField(levelVO.getPId());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getLevelPath())) {
					strsql.append(" and levelPath= ? ");
					super.addStringForField(levelVO.getLevelPath());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getCreateUserId())) {
					strsql.append(" and createUserId= ? ");
					super.addStringForField(levelVO.getCreateUserId());
				}
				if (Integer.MIN_VALUE != levelVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(levelVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(levelVO.getDescription());
				}
				if (Long.MIN_VALUE != levelVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(levelVO.getRevision());
				}
				if (Integer.MIN_VALUE != levelVO.getNodeServer()){
					strsql.append(" and nodeServer = ?");
					super.addIntForField(levelVO.getNodeServer());
				}
				if (Integer.MIN_VALUE != levelVO.getNodePort()){
					strsql.append(" and nodePort = ?");
					super.addIntForField(levelVO.getNodePort());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getNodeIP())) {
					strsql.append(" and nodeIP= ? ");
					super.addStringForField(levelVO.getNodeIP());
				}
			}
		} else if (QUERY_FROM_LEVELGRADE_BY_IDS == _operatorType) {
			strsql.append(" and levelID in (?) ");
			super.addStringForField(ids);
		} else if (QUERY_FROM_LEVELBYPID == _operatorType) {
			if (null != levelVO) {
				if (!StringUtils.isNullOrBlank(levelVO.getPId())) {
					strsql.append(" and pId= ? ");
					super.addStringForField(levelVO.getPId());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getPId())) {
					strsql.append(" or levelID= ? ");
					super.addStringForField(levelVO.getPId());
				}
				if (!StringUtils.isNullOrBlank(levelVO.getPId())) {
					strsql.append(" order by levelPath ");
				}
			}
		} else if (QUERY_CHECK_CHILD_ONE == _operatorType) {
			if (null != levelVO) {
				if (!StringUtils.isNullOrBlank(levelVO.getPId())) {
					strsql.append(" and pId= ? ");
					super.addStringForField(levelVO.getLevelID());
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
		if(QUERY_FROM_LEVELGRADE == _operatorType){
			levelVO = new LevelVO();
			levelVO.setLevelID(rs.getString("levelID"));
			levelVO.setLevelName(rs.getString("levelName"));
			levelVO.setPId(rs.getString("pId"));
			levelVO.setLevelPath(rs.getString("levelPath"));
			levelVO.setCreateUserId(rs.getString("createUserId"));
			levelVO.setCreateTime(rs.getTimestamp("createTime"));
			levelVO.setStatus(rs.getInt("status"));
			levelVO.setDescription(rs.getString("description"));
			levelVO.setRevision(rs.getLong("revision"));
			//add by liujf 20140702新增字段
			levelVO.setNodeServer(rs.getInt("nodeServer"));
			levelVO.setNodeIP(rs.getString("nodeIP"));
			levelVO.setNodePort(rs.getInt("nodePort"));
			listLevel.add(levelVO);
		}else if(QUERY_FROM_LEVELBYPID == _operatorType){
			levelVO = new LevelVO();
			levelVO.setLevelID(rs.getString("levelID"));
			levelVO.setLevelName(rs.getString("levelName"));
			levelVO.setPId(rs.getString("pId"));
			levelVO.setLevelPath(rs.getString("levelPath"));
			levelVO.setCreateUserId(rs.getString("createUserId"));
			levelVO.setCreateTime(rs.getTimestamp("createTime"));
			levelVO.setStatus(rs.getInt("status"));
			levelVO.setDescription(rs.getString("description"));
			levelVO.setRevision(rs.getLong("revision"));
			//	add by liujf 20140702新增字段
			levelVO.setNodeServer(rs.getInt("nodeServer"));
			levelVO.setNodeIP(rs.getString("nodeIP"));
			levelVO.setNodePort(rs.getInt("nodePort"));
			listLevel.add(levelVO);
		}
		else if(QUERY_CHECK_CHILD == _operatorType)
		{
			System.out.println(rs.getInt(1));
			if(rs.getInt(1)>0)
				res =true;
		}
	}

	public ArrayList<LevelVO> getLevelGradeList() {
		return listLevel;
	}

	public LevelVO getLevelGradeVO() {
		return levelVO;
	}
	
	public boolean getres(){
		
		return res;
	}

}
