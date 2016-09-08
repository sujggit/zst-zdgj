package com.zzst.dao.meeting.centerControl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.centerControl.CenterControlVO;

/**
 * class description: CenterControl MQB
 * 
 * @date Thu Jun 28 15:18:31 CST 2012
 * @author ryan
 */
public class CenterControlMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(CenterControlMQB.class.getName());

	public static int QUERY_FROM_CENTERCONTROL = 1;
	public static int QUERY_FROM_CENTERCONTROL_BY_IDS = 2;
	public static int QUERY_NO_DUPLICATES = 3;

	private CenterControlVO centerControlVO;
	private ArrayList<CenterControlVO> listCenterControl = new ArrayList<CenterControlVO>();

	private int _operatorType = -1;
	private String ids = "";

	public CenterControlMQB(int operatorType, CenterControlVO centerControlVO) {
		_operatorType = operatorType;
		this.centerControlVO = centerControlVO;
		makeSql();
	}

	public CenterControlMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();

		if (QUERY_FROM_CENTERCONTROL == _operatorType) {
			strsql.append("select id,equipmentIP,command,equipmentType,euipmentName,ccNO,controlInitDate,ccIP ");
			strsql.append(" from z_t_pub_centercontrol ");
			strsql.append(" where 1=1 ");
			if (null != centerControlVO) {
				if (!StringUtils.isNullOrBlank(centerControlVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(centerControlVO.getId());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getEquipmentIP())) {
					strsql.append(" and equipmentIP= ? ");
					super.addStringForField(centerControlVO.getEquipmentIP());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getCommand())) {
					strsql.append(" and command= ? ");
					super.addStringForField(centerControlVO.getCommand());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getEquipmentType())) {
					strsql.append(" and equipmentType= ? ");
					super.addStringForField(centerControlVO.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getEquipmentName())) {
					strsql.append(" and euipmentName= ? ");
					super.addStringForField(centerControlVO.getEquipmentName());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getCcNO())) {
					strsql.append(" and ccNO= ? ");
					super.addStringForField(centerControlVO.getCcNO());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getControlInitDate())) {
					strsql.append(" and controlInitDate= ? ");
					super.addStringForField(centerControlVO.getControlInitDate());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getCcIP())) {
					strsql.append(" and ccIP= ? ");
					super.addStringForField(centerControlVO.getCcIP());
				}
			}
			/**
			 * 查询中控列表，需要剔除~会议室状态无效的中控
			 */
			strsql.append(" and ccIP IN (SELECT z_t_equipment.ip FROM( z_t_equipment INNER JOIN z_t_user ON z_t_equipment.adminID=z_t_user.userID)INNER JOIN z_t_meetingroom ON z_t_equipment.roomID=z_t_meetingroom.meetingroomID WHERE 1=1 AND z_t_equipment.status!=3 AND z_t_meetingroom.status=0 AND z_t_equipment.equipmentType='2')");
			//////
			strsql.append(" order by ccIP ");
		} else if (QUERY_FROM_CENTERCONTROL_BY_IDS == _operatorType) {
			strsql.append("select id,equipmentIP,command,equipmentType,euipmentName,ccNO,controlInitDate,ccIP ");
			strsql.append(" from z_t_pub_centercontrol ");
			strsql.append(" where 1=1 ");
			strsql.append(" and id in (?) ");
			super.addStringForField(ids);
		}else if(QUERY_NO_DUPLICATES == _operatorType){
			strsql.append("select min(id) id,min(equipmentIP) equipmentIP,min(command) command,equipmentType,min(euipmentName) euipmentName,min(ccNO) ccNO,min(controlInitDate) controlInitDate,min(ccIP) ccIP ");
			strsql.append(" from z_t_pub_centercontrol ");
			strsql.append(" where 1=1 ");
			if (null != centerControlVO) {
				if (!StringUtils.isNullOrBlank(centerControlVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(centerControlVO.getId());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getEquipmentIP())) {
					strsql.append(" and equipmentIP= ? ");
					super.addStringForField(centerControlVO.getEquipmentIP());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getCommand())) {
					strsql.append(" and command= ? ");
					super.addStringForField(centerControlVO.getCommand());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getEquipmentType())) {
					strsql.append(" and equipmentType= ? ");
					super.addStringForField(centerControlVO.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getEquipmentName())) {
					strsql.append(" and euipmentName= ? ");
					super.addStringForField(centerControlVO.getEquipmentName());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getCcNO())) {
					strsql.append(" and ccNO= ? ");
					super.addStringForField(centerControlVO.getCcNO());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getControlInitDate())) {
					strsql.append(" and controlInitDate= ? ");
					super.addStringForField(centerControlVO.getControlInitDate());
				}
				if (!StringUtils.isNullOrBlank(centerControlVO.getCcIP())) {
					strsql.append(" and ccIP= ? ");
					super.addStringForField(centerControlVO.getCcIP());
				}
			}
			strsql.append(" group by equipmentType ");
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
		centerControlVO = new CenterControlVO();
		centerControlVO.setId(rs.getString("id"));
		centerControlVO.setEquipmentIP(rs.getString("equipmentIP"));
		centerControlVO.setCommand(rs.getString("command"));
		centerControlVO.setEquipmentType(rs.getString("equipmentType"));
		centerControlVO.setEquipmentName(rs.getString("euipmentName"));
		centerControlVO.setCcNO(rs.getString("ccNO"));
		centerControlVO.setControlInitDate(rs.getString("controlInitDate"));
		centerControlVO.setCcIP(rs.getString("ccIP"));
		listCenterControl.add(centerControlVO);
	}

	public ArrayList<CenterControlVO> getCenterControlList() {
		return listCenterControl;
	}

	public CenterControlVO getCenterControlVO() {
		return centerControlVO;
	}

}
