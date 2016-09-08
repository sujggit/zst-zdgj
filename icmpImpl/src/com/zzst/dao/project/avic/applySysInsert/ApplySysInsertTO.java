package com.zzst.dao.project.avic.applySysInsert;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.project.avic.applySysInsert.ApplySysInsertVO;

/**
 * class description: ApplySysInsert TO
 * 
 * @date Fri Sep 21 17:34:16 CST 2012
 * @author ryan
 */
public class ApplySysInsertTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ApplySysInsertTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_APPLYSYSINSERT = 1;
	public static int MODIFY_APPLYSYSINSERT = 2;
	public static int DEL_APPLYSYSINSERT = 3;
	private int result = 0;

	private ApplySysInsertVO applySysInsertVO;
	private String ids = "";

	public ApplySysInsertTO(int operatorType, ApplySysInsertVO applySysInsertVO) {
		this.operatorType = operatorType;
		this.applySysInsertVO = applySysInsertVO;
	}

	public ApplySysInsertTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_APPLYSYSINSERT == operatorType) {
			sqlstr.append("insert into avic_t_apply_sys_insert ");
			sqlstr.append("(applyID,departmentID,departmentName,departmentCode,linkmanName,linkmanPhone,linkmanFax,linkmanCellPhone,terminalModel,terminalIP,terminalFirewallPortScope,terminalLanPlace,displayEquipment,amplifedSound,terminalNumber,speed,natChange,fireWallBrand,flowID,createUserID,createTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(applySysInsertVO.getApplyID());
			super.addStringForField(applySysInsertVO.getDepartmentID());
			super.addStringForField(applySysInsertVO.getDepartmentName());
			super.addStringForField(applySysInsertVO.getDepartmentCode());
			super.addStringForField(applySysInsertVO.getLinkmanName());
			super.addStringForField(applySysInsertVO.getLinkmanPhone());
			super.addStringForField(applySysInsertVO.getLinkmanFax());
			super.addStringForField(applySysInsertVO.getLinkmanCellPhone());
			super.addStringForField(applySysInsertVO.getTerminalModel());
			super.addStringForField(applySysInsertVO.getTerminalIP());
			super.addStringForField(applySysInsertVO.getTerminalFirewallPortScope());
			super.addStringForField(applySysInsertVO.getTerminalLanPlace());
			super.addStringForField(applySysInsertVO.getDisplayEquipment());
			super.addStringForField(applySysInsertVO.getAmplifedSound());
			super.addIntForField(applySysInsertVO.getTerminalNumber());
			super.addIntForField(applySysInsertVO.getSpeed());
			super.addIntForField(applySysInsertVO.getNatChange());
			super.addStringForField(applySysInsertVO.getFireWallBrand());
			super.addStringForField(applySysInsertVO.getFlowID());
			super.addStringForField(applySysInsertVO.getCreateUserID());
			super.addTimestampForField(applySysInsertVO.getCreateTime());
			super.addIntForField(applySysInsertVO.getStatus());
			super.addLongForField(applySysInsertVO.getRevision());
			super.addStringForField(applySysInsertVO.getDescription());
		} else if (MODIFY_APPLYSYSINSERT == operatorType) {
			sqlstr.append("update  avic_t_apply_sys_insert set ");
			sqlstr.append(" applyID = applyID ");

			if (applySysInsertVO.getDepartmentID() != null) {
				sqlstr.append(" , departmentID=? ");
				super.addStringForField(applySysInsertVO.getDepartmentID());
			}

			if (applySysInsertVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentName=? ");
				super.addStringForField(applySysInsertVO.getDepartmentName());
			}

			if (applySysInsertVO.getDepartmentCode() != null) {
				sqlstr.append(" , departmentCode=? ");
				super.addStringForField(applySysInsertVO.getDepartmentCode());
			}

			if (applySysInsertVO.getLinkmanName() != null) {
				sqlstr.append(" , linkmanName=? ");
				super.addStringForField(applySysInsertVO.getLinkmanName());
			}

			if (applySysInsertVO.getLinkmanPhone() != null) {
				sqlstr.append(" , linkmanPhone=? ");
				super.addStringForField(applySysInsertVO.getLinkmanPhone());
			}

			if (applySysInsertVO.getLinkmanFax() != null) {
				sqlstr.append(" , linkmanFax=? ");
				super.addStringForField(applySysInsertVO.getLinkmanFax());
			}

			if (applySysInsertVO.getLinkmanCellPhone() != null) {
				sqlstr.append(" , linkmanCellPhone=? ");
				super.addStringForField(applySysInsertVO.getLinkmanCellPhone());
			}

			if (applySysInsertVO.getTerminalModel() != null) {
				sqlstr.append(" , terminalModel=? ");
				super.addStringForField(applySysInsertVO.getTerminalModel());
			}

			if (applySysInsertVO.getTerminalIP() != null) {
				sqlstr.append(" , terminalIP=? ");
				super.addStringForField(applySysInsertVO.getTerminalIP());
			}

			if (applySysInsertVO.getTerminalFirewallPortScope() != null) {
				sqlstr.append(" , terminalFirewallPortScope=? ");
				super.addStringForField(applySysInsertVO
						.getTerminalFirewallPortScope());
			}

			if (applySysInsertVO.getTerminalLanPlace() != null) {
				sqlstr.append(" , terminalLanPlace=? ");
				super.addStringForField(applySysInsertVO.getTerminalLanPlace());
			}

			if (applySysInsertVO.getDisplayEquipment() != null) {
				sqlstr.append(" , displayEquipment=? ");
				super.addStringForField(applySysInsertVO.getDisplayEquipment());
			}

			if (applySysInsertVO.getAmplifedSound() != null) {
				sqlstr.append(" , amplifedSound=? ");
				super.addStringForField(applySysInsertVO.getAmplifedSound());
			}

			if (applySysInsertVO.getTerminalNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , terminalNumber=?");
				super.addIntForField(applySysInsertVO.getTerminalNumber());
			}

			if (applySysInsertVO.getSpeed() != Integer.MIN_VALUE) {
				sqlstr.append(" , speed=?");
				super.addIntForField(applySysInsertVO.getSpeed());
			}

			if (applySysInsertVO.getNatChange() != Integer.MIN_VALUE) {
				sqlstr.append(" , natChange=?");
				super.addIntForField(applySysInsertVO.getNatChange());
			}

			if (applySysInsertVO.getFireWallBrand() != null) {
				sqlstr.append(" , fireWallBrand=? ");
				super.addStringForField(applySysInsertVO.getFireWallBrand());
			}

			if (applySysInsertVO.getFlowID() != null) {
				sqlstr.append(" , flowID=? ");
				super.addStringForField(applySysInsertVO.getFlowID());
			}
			
			if (applySysInsertVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(applySysInsertVO.getCreateUserID());
			}

			if (applySysInsertVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(applySysInsertVO.getCreateTime());
			}

			if (applySysInsertVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(applySysInsertVO.getStatus());
			}

			if (applySysInsertVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(applySysInsertVO.getRevision());
			}

			if (applySysInsertVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(applySysInsertVO.getDescription());
			}

			sqlstr.append(" where applyID in (?) ");
			if (applySysInsertVO.getApplyID() != null) {
				super.addStringForField(applySysInsertVO.getApplyID());
			}
		} else if (DEL_APPLYSYSINSERT == operatorType) {
			sqlstr.append("delete  from  avic_t_apply_sys_insert ");
			sqlstr.append(" where applyID in (?) ");
			super.addStringForField(applySysInsertVO.getApplyID());
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
