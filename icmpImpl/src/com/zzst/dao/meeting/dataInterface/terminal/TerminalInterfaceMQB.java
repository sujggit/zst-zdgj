package com.zzst.dao.meeting.dataInterface.terminal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: TerminalInterface MQB
 * 
 * @date Sat Jun 08 11:18:45 CST 2013
 * @author ryan
 */
public class TerminalInterfaceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(TerminalInterfaceMQB.class
			.getName());

	public static int QUERY_FROM_TERMINALINTERFACE = 1;
	public static int QUERY_FROM_TERMINALINTERFACE_BY_IDS = 2;
	public static int QUERY_FROM_MEETINGROOMINTERFACE_AVAILABLE = 3;

	private TerminalInterfaceVO terminalInterfaceVO;
	private ArrayList<TerminalInterfaceVO> listTerminalInterface = new ArrayList<TerminalInterfaceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public TerminalInterfaceMQB(int operatorType,
			TerminalInterfaceVO terminalInterfaceVO) {
		_operatorType = operatorType;
		this.terminalInterfaceVO = terminalInterfaceVO;
		makeSql();
	}

	public TerminalInterfaceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select equipmentID,equipmentModel,equipmentNO,equipmentStatus,mac,ip,port,roomName,adminName,mcuIp,description,serialNumber,equipmentIdentifier,maintainceStartTime,maintainMonth,status ");
		strsql.append(" from z_t_interface_in_terminal ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_TERMINALINTERFACE == _operatorType) {
			if (null != terminalInterfaceVO) {
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(terminalInterfaceVO
							.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getEquipmentModel())) {
					strsql.append(" and equipmentModel= ? ");
					super.addStringForField(terminalInterfaceVO
							.getEquipmentModel());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getEquipmentNO())) {
					strsql.append(" and equipmentNO like ? ");
					super.addStringForField("%"+terminalInterfaceVO
							.getEquipmentNO().trim()+"%");
				}
				if (Integer.MIN_VALUE != terminalInterfaceVO
						.getEquipmentStatus()) {
					strsql.append(" and equipmentStatus= ? ");
					super.addIntForField(terminalInterfaceVO
							.getEquipmentStatus());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO.getMac())) {
					strsql.append(" and mac= ? ");
					super.addStringForField(terminalInterfaceVO.getMac());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO.getIp())) {
					strsql.append(" and ip= ? ");
					super.addStringForField(terminalInterfaceVO.getIp());
				}
				if (Integer.MIN_VALUE != terminalInterfaceVO.getPort()) {
					strsql.append(" and port= ? ");
					super.addIntForField(terminalInterfaceVO.getPort());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getRoomName())) {
					strsql.append(" and roomName= ? ");
					super.addStringForField(terminalInterfaceVO.getRoomName());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getAdminName())) {
					strsql.append(" and adminName= ? ");
					super.addStringForField(terminalInterfaceVO.getAdminName());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO.getMcuIp())) {
					strsql.append(" and mcuIp= ? ");
					super.addStringForField(terminalInterfaceVO.getMcuIp());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(terminalInterfaceVO
							.getDescription());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getSerialNumber())) {
					strsql.append(" and serialNumber= ? ");
					super.addStringForField(terminalInterfaceVO
							.getSerialNumber());
				}
				if (!StringUtils.isNullOrBlank(terminalInterfaceVO
						.getEquipmentIdentifier())) {
					strsql.append(" and equipmentIdentifier= ? ");
					super.addStringForField(terminalInterfaceVO
							.getEquipmentIdentifier());
				}
				if (Integer.MIN_VALUE != terminalInterfaceVO.getMaintainMonth()) {
					strsql.append(" and maintainMonth= ? ");
					super
							.addIntForField(terminalInterfaceVO
									.getMaintainMonth());
				}
				if (Integer.MIN_VALUE != terminalInterfaceVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(terminalInterfaceVO.getStatus());
				}
			}
		} else if (QUERY_FROM_TERMINALINTERFACE_BY_IDS == _operatorType) {
			strsql.append(" and equipmentID in (?) ");
			super.addStringForField(ids);
		} else if ( QUERY_FROM_MEETINGROOMINTERFACE_AVAILABLE == _operatorType){
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
		terminalInterfaceVO = new TerminalInterfaceVO();
		terminalInterfaceVO.setEquipmentID(rs.getString("equipmentID"));
		terminalInterfaceVO.setEquipmentModel(rs.getString("equipmentModel"));
		terminalInterfaceVO.setEquipmentNO(rs.getString("equipmentNO"));
		terminalInterfaceVO.setEquipmentStatus(rs.getInt("equipmentStatus"));
		terminalInterfaceVO.setMac(rs.getString("mac"));
		terminalInterfaceVO.setIp(rs.getString("ip"));
		terminalInterfaceVO.setPort(rs.getInt("port"));
		terminalInterfaceVO.setRoomName(rs.getString("roomName"));
		terminalInterfaceVO.setAdminName(rs.getString("adminName"));
		terminalInterfaceVO.setMcuIp(rs.getString("mcuIp"));
		terminalInterfaceVO.setDescription(rs.getString("description"));
		terminalInterfaceVO.setSerialNumber(rs.getString("serialNumber"));
		terminalInterfaceVO.setEquipmentIdentifier(rs
				.getString("equipmentIdentifier"));
		terminalInterfaceVO.setMaintainceStartTime(rs
				.getTimestamp("maintainceStartTime"));
		terminalInterfaceVO.setMaintainMonth(rs.getInt("maintainMonth"));
		terminalInterfaceVO.setStatus(rs.getInt("status"));
		listTerminalInterface.add(terminalInterfaceVO);
	}

	public ArrayList<TerminalInterfaceVO> getTerminalInterfaceList() {
		return listTerminalInterface;
	}

	public TerminalInterfaceVO getTerminalInterfaceVO() {
		return terminalInterfaceVO;
	}

}
