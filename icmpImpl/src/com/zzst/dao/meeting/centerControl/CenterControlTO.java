package com.zzst.dao.meeting.centerControl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.centerControl.CenterControlVO;

/**
 * class description: CenterControl TO
 * 
 * @date Thu Jun 28 15:18:31 CST 2012
 * @author ryan
 */
public class CenterControlTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(CenterControlTO.class.getName());
	private int operatorType = -1;

	public static int ADD_CENTERCONTROL = 1;
	public static int MODIFY_CENTERCONTROL = 2;
	public static int DEL_CENTERCONTROL = 3;
	private int result = 0;

	private CenterControlVO centerControlVO;
	private String ids = "";

	public CenterControlTO(int operatorType, CenterControlVO centerControlVO) {
		this.operatorType = operatorType;
		this.centerControlVO = centerControlVO;
	}

	public CenterControlTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_CENTERCONTROL == operatorType) {
			sqlstr.append("insert into z_t_pub_centercontrol ");
			sqlstr.append("(id,equipmentIP,command,equipmentType,euipmentName,ccNO,controlInitDate,ccIP)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			super.addStringForField(centerControlVO.getId());
			super.addStringForField(centerControlVO.getEquipmentIP());
			super.addStringForField(centerControlVO.getCommand());
			super.addStringForField(centerControlVO.getEquipmentType());
			super.addStringForField(centerControlVO.getEquipmentName());
			super.addStringForField(centerControlVO.getCcNO());
			super.addStringForField(centerControlVO.getControlInitDate());
			super.addStringForField(centerControlVO.getCcIP());
		} else if (MODIFY_CENTERCONTROL == operatorType) {
			sqlstr.append("update  z_t_pub_centercontrol set ");
			sqlstr.append(" id = id ");

			if (centerControlVO.getEquipmentIP() != null) {
				sqlstr.append(" , equipmentIP=? ");
				super.addStringForField(centerControlVO.getEquipmentIP());
			}

			if (centerControlVO.getCommand() != null) {
				sqlstr.append(" , command=? ");
				super.addStringForField(centerControlVO.getCommand());
			}

			if (centerControlVO.getEquipmentType() != null) {
				sqlstr.append(" , equipmentType=? ");
				super.addStringForField(centerControlVO.getEquipmentType());
			}

			if (centerControlVO.getEquipmentName() != null) {
				sqlstr.append(" , euipmentName=? ");
				super.addStringForField(centerControlVO.getEquipmentName());
			}

			if (centerControlVO.getCcNO() != null) {
				sqlstr.append(" , ccNO=? ");
				super.addStringForField(centerControlVO.getCcNO());
			}

			if (centerControlVO.getControlInitDate() != null) {
				sqlstr.append(" , controlInitDate=? ");
				super.addStringForField(centerControlVO.getControlInitDate());
			}
			
			if (centerControlVO.getControlInitDate() != null) {
				sqlstr.append(" , ccIP=? ");
				super.addStringForField(centerControlVO.getCcIP());
			}

			sqlstr.append(" where id in (?) ");
			if (centerControlVO.getId() != null) {
				super.addStringForField(centerControlVO.getId());
			}
		} else if (DEL_CENTERCONTROL == operatorType) {
			sqlstr.append("delete  from  z_t_pub_centercontrol ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(centerControlVO.getId());
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
