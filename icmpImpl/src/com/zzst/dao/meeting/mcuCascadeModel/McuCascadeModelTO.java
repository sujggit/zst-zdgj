package com.zzst.dao.meeting.mcuCascadeModel;

import java.sql.SQLException;


import com.cbf.db.TransactionObject;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;

/**
 * class description:	McuCascadeModel TO
 * @date Tue Nov 20 10:40:39 CST 2012
 * @author ryan
 */
public class McuCascadeModelTO extends TransactionObject {

	private int operatorType = -1;

	public static int ADD_MCUCASCADEMODEL = 1;
	public static int MODIFY_MCUCASCADEMODEL = 2;
	public static int DEL_MCUCASCADEMODEL = 3;
	public static int DEL_MCUCASCADEMODEL_MCUIP = 4;
	private int result = 0;

	private McuCascadeModelVO mcuCascadeModelVO;
	private String ids = "";

	public McuCascadeModelTO(int operatorType,
			McuCascadeModelVO mcuCascadeModelVO) {
		this.operatorType = operatorType;
		this.mcuCascadeModelVO = mcuCascadeModelVO;
	}

	public McuCascadeModelTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_MCUCASCADEMODEL == operatorType) {
			sqlstr.append("insert into z_t_mcucascademodel ");
			sqlstr
					.append("(CascadeID,cascadeName,mcuName,mcuIp,modelID,modelName,createUserID,createDate,status,description,confModel)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(mcuCascadeModelVO.getCascadeID());
			super.addStringForField(mcuCascadeModelVO.getCascadeName());
			super.addStringForField(mcuCascadeModelVO.getMcuName());
			super.addStringForField(mcuCascadeModelVO.getMcuIp());
			super.addStringForField(mcuCascadeModelVO.getModelID());
			super.addStringForField(mcuCascadeModelVO.getModelName());
			super.addStringForField(mcuCascadeModelVO.getCreateUserID());
			super.addTimestampForField(mcuCascadeModelVO.getCreateDate());
			super.addIntForField(mcuCascadeModelVO.getStatus());
			super.addStringForField(mcuCascadeModelVO.getDescription());
			super.addStringForField(mcuCascadeModelVO.getConfModel());
		} else if (MODIFY_MCUCASCADEMODEL == operatorType) {
			sqlstr.append("update z_t_mcucascademodel set ");
			sqlstr.append(" CascadeID = CascadeID ");

			if (mcuCascadeModelVO.getCascadeName() != null) {
				sqlstr.append(" , cascadeName=? ");
				super.addStringForField(mcuCascadeModelVO.getCascadeName());
			}

			if (mcuCascadeModelVO.getMcuName() != null) {
				sqlstr.append(" , mcuName=? ");
				super.addStringForField(mcuCascadeModelVO.getMcuName());
			}

			if (mcuCascadeModelVO.getMcuIp() != null) {
				sqlstr.append(" , mcuIp=? ");
				super.addStringForField(mcuCascadeModelVO.getMcuIp());
			}

			if (mcuCascadeModelVO.getModelID() != null) {
				sqlstr.append(" , modelID=? ");
				super.addStringForField(mcuCascadeModelVO.getModelID());
			}

			if (mcuCascadeModelVO.getModelName() != null) {
				sqlstr.append(" , modelName=? ");
				super.addStringForField(mcuCascadeModelVO.getModelName());
			}

			if (mcuCascadeModelVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(mcuCascadeModelVO.getCreateUserID());
			}

			if (mcuCascadeModelVO.getCreateDate() != null) {
				sqlstr.append(" , createDate=? ");
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					UtilDAO.oracleToDate(mcuCascadeModelVO.getCreateDate());
				}else{
					super.addTimestampForField(mcuCascadeModelVO.getCreateDate());
				}
			}

			if (mcuCascadeModelVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(mcuCascadeModelVO.getStatus());
			}

			if (mcuCascadeModelVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(mcuCascadeModelVO.getDescription());
			}

			sqlstr.append(" where CascadeID in (?) ");
			if (mcuCascadeModelVO.getCascadeID() != null) {
				super.addStringForField(mcuCascadeModelVO.getCascadeID());
			}
		} else if (DEL_MCUCASCADEMODEL == operatorType) {
			sqlstr.append("delete  from  z_t_mcucascademodel ");
			sqlstr.append(" where CascadeID = ? ");
			super.addStringForField(mcuCascadeModelVO.getCascadeID());
		} else if (DEL_MCUCASCADEMODEL_MCUIP == operatorType) {
			sqlstr.append("delete  from  z_t_mcucascademodel ");
			sqlstr.append(" where mcuIp = ? ");
			super.addStringForField(mcuCascadeModelVO.getMcuIp());
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
