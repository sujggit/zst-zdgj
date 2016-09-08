package com.zzst.dao.meeting.dataInterface.terminal;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;

/**
 * class description: TerminalInterface TO
 * 
 * @date Sat Jun 08 11:18:45 CST 2013
 * @author ryan
 */
public class TerminalInterfaceTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(TerminalInterfaceTO.class.getName());
	private int operatorType = -1;

	public static int ADD_TERMINALINTERFACE = 1;
	public static int MODIFY_TERMINALINTERFACE = 2;
	public static int DEL_TERMINALINTERFACE = 3;
	public static int DEL_ALL = 4;
	
	private int result = 0;

	private TerminalInterfaceVO terminalInterfaceVO;
	private String ids = "";

	public TerminalInterfaceTO(int operatorType,
			TerminalInterfaceVO terminalInterfaceVO) {
		this.operatorType = operatorType;
		this.terminalInterfaceVO = terminalInterfaceVO;
	}

	public TerminalInterfaceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_TERMINALINTERFACE == operatorType) {
			sqlstr.append("insert into z_t_interface_in_terminal ");
			sqlstr
					.append("(equipmentID,equipmentModel,equipmentNO,equipmentStatus,mac,ip,port,roomName,adminName,mcuIp,description,serialNumber,equipmentIdentifier,maintainceStartTime,maintainMonth,status)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(terminalInterfaceVO.getEquipmentID());
			super.addStringForField(terminalInterfaceVO.getEquipmentModel());
			super.addStringForField(terminalInterfaceVO.getEquipmentNO());
			super.addIntForField(terminalInterfaceVO.getEquipmentStatus());
			super.addStringForField(terminalInterfaceVO.getMac());
			super.addStringForField(terminalInterfaceVO.getIp());
			super.addIntForField(terminalInterfaceVO.getPort());
			super.addStringForField(terminalInterfaceVO.getRoomName());
			super.addStringForField(terminalInterfaceVO.getAdminName());
			super.addStringForField(terminalInterfaceVO.getMcuIp());
			super.addStringForField(terminalInterfaceVO.getDescription());
			super.addStringForField(terminalInterfaceVO.getSerialNumber());
			super.addStringForField(terminalInterfaceVO
					.getEquipmentIdentifier());
			super.addTimestampForField(terminalInterfaceVO
					.getMaintainceStartTime());
			super.addIntForField(terminalInterfaceVO.getMaintainMonth());
			super.addIntForField(terminalInterfaceVO.getStatus());
		} else if (MODIFY_TERMINALINTERFACE == operatorType) {
			sqlstr.append("update  z_t_interface_in_terminal set ");
			sqlstr.append(" equipmentID = equipmentID ");

			if (terminalInterfaceVO.getEquipmentModel() != null) {
				sqlstr.append(" , equipmentModel=? ");
				super
						.addStringForField(terminalInterfaceVO
								.getEquipmentModel());
			}

			if (terminalInterfaceVO.getEquipmentNO() != null) {
				sqlstr.append(" , equipmentNO=? ");
				super.addStringForField(terminalInterfaceVO.getEquipmentNO());
			}

			if (terminalInterfaceVO.getEquipmentStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , equipmentStatus=?");
				super.addIntForField(terminalInterfaceVO.getEquipmentStatus());
			}

			if (terminalInterfaceVO.getMac() != null) {
				sqlstr.append(" , mac=? ");
				super.addStringForField(terminalInterfaceVO.getMac());
			}

			if (terminalInterfaceVO.getIp() != null) {
				sqlstr.append(" , ip=? ");
				super.addStringForField(terminalInterfaceVO.getIp());
			}

			if (terminalInterfaceVO.getPort() != Integer.MIN_VALUE) {
				sqlstr.append(" , port=?");
				super.addIntForField(terminalInterfaceVO.getPort());
			}

			if (terminalInterfaceVO.getRoomName() != null) {
				sqlstr.append(" , roomName=? ");
				super.addStringForField(terminalInterfaceVO.getRoomName());
			}

			if (terminalInterfaceVO.getAdminName() != null) {
				sqlstr.append(" , adminName=? ");
				super.addStringForField(terminalInterfaceVO.getAdminName());
			}

			if (terminalInterfaceVO.getMcuIp() != null) {
				sqlstr.append(" , mcuIp=? ");
				super.addStringForField(terminalInterfaceVO.getMcuIp());
			}

			if (terminalInterfaceVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(terminalInterfaceVO.getDescription());
			}

			if (terminalInterfaceVO.getSerialNumber() != null) {
				sqlstr.append(" , serialNumber=? ");
				super.addStringForField(terminalInterfaceVO.getSerialNumber());
			}

			if (terminalInterfaceVO.getEquipmentIdentifier() != null) {
				sqlstr.append(" , equipmentIdentifier=? ");
				super.addStringForField(terminalInterfaceVO
						.getEquipmentIdentifier());
			}

			if (terminalInterfaceVO.getMaintainceStartTime() != null) {
				sqlstr.append(" , maintainceStartTime=? ");
				super.addTimestampForField(terminalInterfaceVO
						.getMaintainceStartTime());
			}

			if (terminalInterfaceVO.getMaintainMonth() != Integer.MIN_VALUE) {
				sqlstr.append(" , maintainMonth=?");
				super.addIntForField(terminalInterfaceVO.getMaintainMonth());
			}

			if (terminalInterfaceVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(terminalInterfaceVO.getStatus());
			}

			sqlstr.append(" where equipmentID in (?) ");
			if (terminalInterfaceVO.getEquipmentID() != null) {
				super.addStringForField(terminalInterfaceVO.getEquipmentID());
			}
		} else if (DEL_TERMINALINTERFACE == operatorType) {
			sqlstr.append("delete  from  z_t_interface_in_terminal ");
			sqlstr.append(" where equipmentID in (?) ");
			super.addStringForField(terminalInterfaceVO.getEquipmentID());
		}else if ( DEL_ALL == operatorType ){
			sqlstr.append("delete  from  z_t_interface_in_terminal ");
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
