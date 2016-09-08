package com.zzst.dao.meeting.dataInterface.equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;

/**
 * class description: EquipmentInterface MQB
 * 
 * @date Mon Jul 01 16:11:19 CST 2013
 * @author ryan
 */
public class EquipmentInterfaceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentInterfaceMQB.class
			.getName());

	public static int QUERY_FROM_EQUIPMENTINTERFACE = 1;
	public static int QUERY_FROM_EQUIPMENTINTERFACE_BY_IDS = 2;
	public static int QUERY_FROM_EQUIPMENTINTERFACE_AVAILABLE = 3;

	private EquipmentInterfaceVO equipmentInterfaceVO;
	private ArrayList<EquipmentInterfaceVO> listEquipmentInterface = new ArrayList<EquipmentInterfaceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public EquipmentInterfaceMQB(int operatorType,
			EquipmentInterfaceVO equipmentInterfaceVO) {
		_operatorType = operatorType;
		this.equipmentInterfaceVO = equipmentInterfaceVO;
		makeSql();
	}

	public EquipmentInterfaceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select equipmentID,equipmentType,equipmentModel,equipmentNO,equipmentStatus,mac,ip,commandIP,port,roomNO,adminName,loginName,loginPassword,mcuIp,appraisalTaskNum,showFormatFlag,inputModel,outputModel,appraisalModel,collectModel,equipmentDesc,serialNumber,equipmentIdentifier,maintainceStartTime,maintainMonth,status,description,creatorId ");
		strsql.append(" from z_t_interface_in_equipment ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_EQUIPMENTINTERFACE == _operatorType) {
			if (null != equipmentInterfaceVO) {
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getEquipmentID());
				}
				if (Integer.MIN_VALUE != equipmentInterfaceVO
						.getEquipmentType()) {
					strsql.append(" and equipmentType= ? ");
					super.addIntForField(equipmentInterfaceVO
							.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getEquipmentModel())) {
					strsql.append(" and equipmentModel= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getEquipmentModel());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getEquipmentNO())) {
					strsql.append(" and equipmentNO like ? ");
					super.addStringForField("%"+equipmentInterfaceVO
							.getEquipmentNO()+"%");
				}
				if (Integer.MIN_VALUE != equipmentInterfaceVO
						.getEquipmentStatus()) {
					strsql.append(" and equipmentStatus= ? ");
					super.addIntForField(equipmentInterfaceVO
							.getEquipmentStatus());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO.getMac())) {
					strsql.append(" and mac= ? ");
					super.addStringForField(equipmentInterfaceVO.getMac());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO.getIp())) {
					strsql.append(" and ip= ? ");
					super.addStringForField(equipmentInterfaceVO.getIp());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getCommandIP())) {
					strsql.append(" and commandIP= ? ");
					super
							.addStringForField(equipmentInterfaceVO
									.getCommandIP());
				}
				if (Integer.MIN_VALUE != equipmentInterfaceVO.getPort()) {
					strsql.append(" and port= ? ");
					super.addIntForField(equipmentInterfaceVO.getPort());
				}
				if (!StringUtils
						.isNullOrBlank(equipmentInterfaceVO.getRoomNO())) {
					strsql.append(" and roomNO= ? ");
					super.addStringForField(equipmentInterfaceVO.getRoomNO());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getAdminName())) {
					strsql.append(" and adminName= ? ");
					super
							.addStringForField(equipmentInterfaceVO
									.getAdminName());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getLoginName())) {
					strsql.append(" and loginName= ? ");
					super
							.addStringForField(equipmentInterfaceVO
									.getLoginName());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getLoginPassword())) {
					strsql.append(" and loginPassword= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getLoginPassword());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO.getMcuIp())) {
					strsql.append(" and mcuIp= ? ");
					super.addStringForField(equipmentInterfaceVO.getMcuIp());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getAppraisalTaskNum())) {
					strsql.append(" and appraisalTaskNum= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getAppraisalTaskNum());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getShowFormatFlag())) {
					strsql.append(" and showFormatFlag= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getShowFormatFlag());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getInputModel())) {
					strsql.append(" and inputModel= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getInputModel());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getOutputModel())) {
					strsql.append(" and outputModel= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getOutputModel());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getAppraisalModel())) {
					strsql.append(" and appraisalModel= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getAppraisalModel());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getCollectModel())) {
					strsql.append(" and collectModel= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getCollectModel());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getEquipmentDesc())) {
					strsql.append(" and equipmentDesc= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getEquipmentDesc());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getSerialNumber())) {
					strsql.append(" and serialNumber= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getSerialNumber());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getEquipmentIdentifier())) {
					strsql.append(" and equipmentIdentifier= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getEquipmentIdentifier());
				}
				if (Integer.MIN_VALUE != equipmentInterfaceVO
						.getMaintainMonth()) {
					strsql.append(" and maintainMonth= ? ");
					super.addIntForField(equipmentInterfaceVO
							.getMaintainMonth());
				}
				if (Integer.MIN_VALUE != equipmentInterfaceVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(equipmentInterfaceVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(equipmentInterfaceVO
							.getDescription());
				}
				if (!StringUtils.isNullOrBlank(equipmentInterfaceVO
						.getCreatorId())) {
					strsql.append(" and creatorId= ? ");
					super
							.addStringForField(equipmentInterfaceVO
									.getCreatorId());
				}
			}
		} else if (QUERY_FROM_EQUIPMENTINTERFACE_BY_IDS == _operatorType) {
			strsql.append(" and equipmentID in (?) ");
			super.addStringForField(ids);
		} else if( QUERY_FROM_EQUIPMENTINTERFACE_AVAILABLE == _operatorType ){
			strsql.append(" and status != 1");
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
		equipmentInterfaceVO = new EquipmentInterfaceVO();
		equipmentInterfaceVO.setEquipmentID(rs.getString("equipmentID"));
		equipmentInterfaceVO.setEquipmentType(rs.getInt("equipmentType"));
		equipmentInterfaceVO.setEquipmentModel(rs.getString("equipmentModel"));
		equipmentInterfaceVO.setEquipmentNO(rs.getString("equipmentNO"));
		equipmentInterfaceVO.setEquipmentStatus(rs.getInt("equipmentStatus"));
		equipmentInterfaceVO.setMac(rs.getString("mac"));
		equipmentInterfaceVO.setIp(rs.getString("ip"));
		equipmentInterfaceVO.setCommandIP(rs.getString("commandIP"));
		equipmentInterfaceVO.setPort(rs.getInt("port"));
		equipmentInterfaceVO.setRoomNO(rs.getString("roomNO"));
		equipmentInterfaceVO.setAdminName(rs.getString("adminName"));
		equipmentInterfaceVO.setLoginName(rs.getString("loginName"));
		equipmentInterfaceVO.setLoginPassword(rs.getString("loginPassword"));
		equipmentInterfaceVO.setMcuIp(rs.getString("mcuIp"));
		equipmentInterfaceVO.setAppraisalTaskNum(rs
				.getString("appraisalTaskNum"));
		equipmentInterfaceVO.setShowFormatFlag(rs.getString("showFormatFlag"));
		equipmentInterfaceVO.setInputModel(rs.getString("inputModel"));
		equipmentInterfaceVO.setOutputModel(rs.getString("outputModel"));
		equipmentInterfaceVO.setAppraisalModel(rs.getString("appraisalModel"));
		equipmentInterfaceVO.setCollectModel(rs.getString("collectModel"));
		equipmentInterfaceVO.setEquipmentDesc(rs.getString("equipmentDesc"));
		equipmentInterfaceVO.setSerialNumber(rs.getString("serialNumber"));
		equipmentInterfaceVO.setEquipmentIdentifier(rs
				.getString("equipmentIdentifier"));
		equipmentInterfaceVO.setMaintainceStartTime(rs
				.getTimestamp("maintainceStartTime"));
		equipmentInterfaceVO.setMaintainMonth(rs.getInt("maintainMonth"));
		equipmentInterfaceVO.setStatus(rs.getInt("status"));
		equipmentInterfaceVO.setDescription(rs.getString("description"));
		equipmentInterfaceVO.setCreatorId(rs.getString("creatorId"));
		listEquipmentInterface.add(equipmentInterfaceVO);
	}

	public ArrayList<EquipmentInterfaceVO> getEquipmentInterfaceList() {
		return listEquipmentInterface;
	}

	public EquipmentInterfaceVO getEquipmentInterfaceVO() {
		return equipmentInterfaceVO;
	}

}
