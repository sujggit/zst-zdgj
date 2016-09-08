package com.zzst.dao.meeting.templateEquipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;

/**
 * class description: TemplateEquipment MQB
 * 
 * @date Wed Mar 20 13:12:04 CST 2013
 * @author ryan
 */
public class TemplateEquipmentMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(TemplateEquipmentMQB.class
			.getName());

	public static int QUERY_FROM_TEMPLATEEQUIPMENT = 1;
	public static int QUERY_FROM_TEMPLATEEQUIPMENT_BY_IDS = 2;

	private TemplateEquipmentVO templateEquipmentVO;
	private ArrayList<TemplateEquipmentVO> listTemplateEquipment = new ArrayList<TemplateEquipmentVO>();

	private int _operatorType = -1;
	private String ids = "";

	public TemplateEquipmentMQB(int operatorType,
			TemplateEquipmentVO templateEquipmentVO) {
		_operatorType = operatorType;
		this.templateEquipmentVO = templateEquipmentVO;
		makeSql();
	}

	public TemplateEquipmentMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select ID,groupId,equipmentName,equipmentIp,pInterface,aliasName,aliasType,ptsNumber,lineRate,maxResolution,videoProtocol,cascadeRole,agc,callDirection,isMain,description,meetingRoomID ");
		strsql.append(" from z_t_template_equipment ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_TEMPLATEEQUIPMENT == _operatorType) {
			if (null != templateEquipmentVO) {
				if (!StringUtils.isNullOrBlank(templateEquipmentVO.getID())) {
					strsql.append(" and ID= ? ");
					super.addStringForField(templateEquipmentVO.getID());
				}
				if (!StringUtils
						.isNullOrBlank(templateEquipmentVO.getGroupId())) {
					strsql.append(" and groupId= ? ");
					super.addStringForField(templateEquipmentVO.getGroupId());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getEquipmentName())) {
					strsql.append(" and equipmentName like ? ");
					super.addStringForField("%"+templateEquipmentVO
							.getEquipmentName()+"%");
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getEquipmentIp())) {
					strsql.append(" and equipmentIp= ? ");
					super.addStringForField(templateEquipmentVO
							.getEquipmentIp());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getPInterface())) {
					strsql.append(" and pInterface= ? ");
					super
							.addStringForField(templateEquipmentVO
									.getPInterface());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getAliasName())) {
					strsql.append(" and aliasName= ? ");
					super.addStringForField(templateEquipmentVO.getAliasName());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getAliasType())) {
					strsql.append(" and aliasType= ? ");
					super.addStringForField(templateEquipmentVO.getAliasType());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getPtsNumber())) {
					strsql.append(" and ptsNumber= ? ");
					super.addStringForField(templateEquipmentVO.getPtsNumber());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getLineRate())) {
					strsql.append(" and lineRate= ? ");
					super.addStringForField(templateEquipmentVO.getLineRate());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getMaxResolution())) {
					strsql.append(" and maxResolution= ? ");
					super.addStringForField(templateEquipmentVO
							.getMaxResolution());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getVideoProtocol())) {
					strsql.append(" and videoProtocol= ? ");
					super.addStringForField(templateEquipmentVO
							.getVideoProtocol());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getCascadeRole())) {
					strsql.append(" and cascadeRole= ? ");
					super.addStringForField(templateEquipmentVO
							.getCascadeRole());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO.getAgc())) {
					strsql.append(" and agc= ? ");
					super.addStringForField(templateEquipmentVO.getAgc());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getCallDirection())) {
					strsql.append(" and callDirection= ? ");
					super.addStringForField(templateEquipmentVO
							.getCallDirection());
				}
				if (Integer.MIN_VALUE != templateEquipmentVO.getIsMain()) {
					strsql.append(" and isMain= ? ");
					super.addIntForField(templateEquipmentVO.getIsMain());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(templateEquipmentVO
							.getDescription());
				}
				if (!StringUtils.isNullOrBlank(templateEquipmentVO.getMeetingRoomID())) {
					strsql.append(" and meetingRoomID = ? ");
					super.addStringForField(templateEquipmentVO.getMeetingRoomID());
				}
			}
		} else if (QUERY_FROM_TEMPLATEEQUIPMENT_BY_IDS == _operatorType) {
			strsql.append(" and ID in (?) ");
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
		templateEquipmentVO = new TemplateEquipmentVO();
		templateEquipmentVO.setID(rs.getString("ID"));
		templateEquipmentVO.setGroupId(rs.getString("groupId"));
		templateEquipmentVO.setEquipmentName(rs.getString("equipmentName"));
		templateEquipmentVO.setEquipmentIp(rs.getString("equipmentIp"));
		templateEquipmentVO.setPInterface(rs.getString("pInterface"));
		templateEquipmentVO.setAliasName(rs.getString("aliasName"));
		templateEquipmentVO.setAliasType(rs.getString("aliasType"));
		templateEquipmentVO.setPtsNumber(rs.getString("ptsNumber"));
		templateEquipmentVO.setLineRate(rs.getString("lineRate"));
		templateEquipmentVO.setMaxResolution(rs.getString("maxResolution"));
		templateEquipmentVO.setVideoProtocol(rs.getString("videoProtocol"));
		templateEquipmentVO.setCascadeRole(rs.getString("cascadeRole"));
		templateEquipmentVO.setAgc(rs.getString("agc"));
		templateEquipmentVO.setCallDirection(rs.getString("callDirection"));
		templateEquipmentVO.setIsMain(rs.getInt("isMain"));
		templateEquipmentVO.setDescription(rs.getString("description"));
		templateEquipmentVO.setMeetingRoomID(rs.getString("meetingRoomID"));
		listTemplateEquipment.add(templateEquipmentVO);
	}

	public ArrayList<TemplateEquipmentVO> getTemplateEquipmentList() {
		return listTemplateEquipment;
	}

	public TemplateEquipmentVO getTemplateEquipmentVO() {
		return templateEquipmentVO;
	}

}
