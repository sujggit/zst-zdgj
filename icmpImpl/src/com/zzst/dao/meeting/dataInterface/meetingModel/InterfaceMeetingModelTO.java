package com.zzst.dao.meeting.dataInterface.meetingModel;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.dataInterface.meetingModel.InterfaceMeetingModelVO;

/**
 * class description: InterfaceMeetingModel TO
 * 
 * @date Thu May 30 11:17:02 CST 2013
 * @author ryan
 */
public class InterfaceMeetingModelTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(InterfaceMeetingModelTO.class.getName());
	private int operatorType = -1;

	public static int ADD_INTERFACEMEETINGMODEL = 1;
	public static int MODIFY_INTERFACEMEETINGMODEL = 2;
	public static int DEL_INTERFACEMEETINGMODEL = 3;
	private int result = 0;

	private InterfaceMeetingModelVO interfaceMeetingModelVO;

	public InterfaceMeetingModelTO(int operatorType, InterfaceMeetingModelVO interfaceMeetingModelVO) {
		this.operatorType = operatorType;
		this.interfaceMeetingModelVO = interfaceMeetingModelVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_INTERFACEMEETINGMODEL == operatorType) {
			sqlstr.append("insert into z_interface_out_meetingmodel ");
			sqlstr.append("(modelID,modelName,modelDes,status,description,ref1,ref2)");
			sqlstr.append(" values (?,?,?,?,?,?,?)");
			super.addStringForField(interfaceMeetingModelVO.getModelID());
			super.addStringForField(interfaceMeetingModelVO.getModelName());
			super.addStringForField(interfaceMeetingModelVO.getModelDes());
			super.addIntForField(interfaceMeetingModelVO.getStatus());
			super.addStringForField(interfaceMeetingModelVO.getDescription());
			super.addStringForField(interfaceMeetingModelVO.getRef1());
			super.addStringForField(interfaceMeetingModelVO.getRef2());
		} else if (MODIFY_INTERFACEMEETINGMODEL == operatorType) {
			sqlstr.append("update  z_interface_out_meetingmodel set ");
			sqlstr.append(" modelID = modelID ");

			if (interfaceMeetingModelVO.getModelName() != null) {
				sqlstr.append(" , modelName=? ");
				super.addStringForField(interfaceMeetingModelVO.getModelName());
			}

			if (interfaceMeetingModelVO.getModelDes() != null) {
				sqlstr.append(" , modelDes=? ");
				super.addStringForField(interfaceMeetingModelVO.getModelDes());
			}

			if (interfaceMeetingModelVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(interfaceMeetingModelVO.getStatus());
			}

			if (interfaceMeetingModelVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(interfaceMeetingModelVO.getDescription());
			}

			if (interfaceMeetingModelVO.getRef1() != null) {
				sqlstr.append(" , ref1=? ");
				super.addStringForField(interfaceMeetingModelVO.getRef1());
			}

			if (interfaceMeetingModelVO.getRef2() != null) {
				sqlstr.append(" , ref2=? ");
				super.addStringForField(interfaceMeetingModelVO.getRef2());
			}

			sqlstr.append(" where modelID in (?) ");
			if (interfaceMeetingModelVO.getModelID() != null) {
				super.addStringForField(interfaceMeetingModelVO.getModelID());
			}
		} else if (DEL_INTERFACEMEETINGMODEL == operatorType) {
			sqlstr.append("delete  from  z_interface_out_meetingmodel ");
			sqlstr.append(" where modelID in (?) ");
			super.addStringForField(interfaceMeetingModelVO.getModelID());
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
