package com.zzst.dao.meeting.equipmentMCUPool;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipmentMCUPool.EquipmentMCUPoolVO;

/**
 * class description: EquipmentMCUPool TO
 * 
 * @date Thu Jan 31 09:29:38 CST 2013
 * @author ryan
 */
public class EquipmentMCUPoolTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(EquipmentMCUPoolTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_EQUIPMENTMCUPOOL = 1;
	public static int MODIFY_EQUIPMENTMCUPOOL = 2;
	public static int DEL_EQUIPMENTMCUPOOL = 3;
	private int result = 0;

	private EquipmentMCUPoolVO equipmentMCUPoolVO;
	private String ids = "";

	public EquipmentMCUPoolTO(int operatorType,
			EquipmentMCUPoolVO equipmentMCUPoolVO) {
		this.operatorType = operatorType;
		this.equipmentMCUPoolVO = equipmentMCUPoolVO;
	}

	public EquipmentMCUPoolTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_EQUIPMENTMCUPOOL == operatorType) {
			sqlstr.append("insert into z_t_equipment_MCU_pool ");
			sqlstr.append("(equipmentID,resourceNum,weight,useNum,status)");
			sqlstr.append(" values (?,?,?,?,?)");
			super.addStringForField(equipmentMCUPoolVO.getEquipmentID());
			super.addIntForField(equipmentMCUPoolVO.getResourceNum());
			super.addIntForField(equipmentMCUPoolVO.getWeight());
			super.addIntForField(equipmentMCUPoolVO.getUseNum());
			super.addIntForField(equipmentMCUPoolVO.getStatus());
		} else if (MODIFY_EQUIPMENTMCUPOOL == operatorType) {
			sqlstr.append("update  z_t_equipment_MCU_pool set ");
			sqlstr.append(" equipmentID = equipmentID ");

			if (equipmentMCUPoolVO.getResourceNum() != Integer.MIN_VALUE) {
				sqlstr.append(" , resourceNum=?");
				super.addIntForField(equipmentMCUPoolVO.getResourceNum());
			}

			if (equipmentMCUPoolVO.getWeight() != Integer.MIN_VALUE) {
				sqlstr.append(" , weight=?");
				super.addIntForField(equipmentMCUPoolVO.getWeight());
			}

			if (equipmentMCUPoolVO.getUseNum() != Integer.MIN_VALUE) {
				sqlstr.append(" , useNum=?");
				super.addIntForField(equipmentMCUPoolVO.getUseNum());
			}

			if (equipmentMCUPoolVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(equipmentMCUPoolVO.getStatus());
			}

			sqlstr.append(" where equipmentID in (?) ");
			if (equipmentMCUPoolVO.getEquipmentID() != null) {
				super.addStringForField(equipmentMCUPoolVO.getEquipmentID());
			}
		} else if (DEL_EQUIPMENTMCUPOOL == operatorType) {
			sqlstr.append("delete  from  z_t_equipment_MCU_pool ");
			sqlstr.append(" where equipmentID in (?) ");
			super.addStringForField(equipmentMCUPoolVO.getEquipmentID());
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
