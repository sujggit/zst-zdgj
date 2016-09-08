package com.zzst.dao.meeting.kst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.kst.WallPresetVO;

/**
 * class description: WallPreset MQB
 * 
 * @date Mon Jul 30 14:19:01 CST 2012
 * @author ryan
 */
public class WallPresetMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(WallPresetMQB.class.getName());

	public static int QUERY_FROM_WALLPRESET = 1;
	public static int QUERY_FROM_WALLPRESET_BY_IDS = 2;

	private WallPresetVO wallPresetVO;
	private ArrayList<WallPresetVO> listWallPreset = new ArrayList<WallPresetVO>();

	private int _operatorType = -1;

	public WallPresetMQB(int operatorType, WallPresetVO wallPresetVO) {
		_operatorType = operatorType;
		this.wallPresetVO = wallPresetVO;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,viewname,status,description,parentID,leaf ");
		strsql.append(" from z_kst_wallpreset ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_WALLPRESET == _operatorType) {
			if (null != wallPresetVO) {
				if (!StringUtils.isNullOrBlank(wallPresetVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(wallPresetVO.getId());
				}
				if (!StringUtils.isNullOrBlank(wallPresetVO.getViewName())) {
					strsql.append(" and viewname like '%"+wallPresetVO.getViewName()+"%'");
					//super.addStringForField(wallPresetVO.getViewName());
				}
				if (!StringUtils.isNullOrBlank(wallPresetVO.getStatus())) {
					strsql.append(" and status= ? ");
					super.addStringForField(wallPresetVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(wallPresetVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(wallPresetVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(wallPresetVO.getParentID())) {
					strsql.append(" and parentID= ? ");
					super.addStringForField(wallPresetVO.getParentID());
				}
				if (!StringUtils.isNullOrBlank(wallPresetVO.getLeaf())) {
					strsql.append(" and leaf= ? ");
					super.addStringForField(wallPresetVO.getLeaf());
				}
			}
		} else if (QUERY_FROM_WALLPRESET_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
			super.addStringForField(wallPresetVO.getId());
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
		wallPresetVO = new WallPresetVO();
		wallPresetVO.setId(rs.getString("id"));
		wallPresetVO.setViewName(rs.getString("viewname"));
		wallPresetVO.setStatus(rs.getString("status"));
		wallPresetVO.setDescription(rs.getString("description"));
		wallPresetVO.setParentID(rs.getString("parentID"));
		wallPresetVO.setLeaf(rs.getString("leaf"));
		listWallPreset.add(wallPresetVO);
	}

	public ArrayList<WallPresetVO> getWallPresetList() {
		return listWallPreset;
	}

	public WallPresetVO getWallPresetVO() {
		return wallPresetVO;
	}

}
