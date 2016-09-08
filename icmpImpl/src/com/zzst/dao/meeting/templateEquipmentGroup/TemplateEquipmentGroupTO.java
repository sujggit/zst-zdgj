package com.zzst.dao.meeting.templateEquipmentGroup;


import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;

/**
 * class description:	TemplateEquipmentGroup TO
 * @date Wed Mar 20 18:48:48 CST 2013
 * @author ryan
 */
public class TemplateEquipmentGroupTO extends TransactionObject {

	private	static Logger logger = CbfLogger.getLogger(TemplateEquipmentGroupTO.class.getName());
	private int operatorType=-1;

	public static int 	ADD_TEMPLATEEQUIPMENTGROUP=1;
	public static int 	MODIFY_TEMPLATEEQUIPMENTGROUP=2;
	public static int 	DEL_TEMPLATEEQUIPMENTGROUP=3;
	private int result = 0;

	private TemplateEquipmentGroupVO templateEquipmentGroupVO;
	private	String	ids = "";

	public TemplateEquipmentGroupTO(int operatorType,TemplateEquipmentGroupVO templateEquipmentGroupVO){
		this.operatorType = operatorType;
		this.templateEquipmentGroupVO = templateEquipmentGroupVO;
	}
	public TemplateEquipmentGroupTO(int operatorType,String ids){
		this.operatorType = operatorType;
		this.ids = ids;
	}







	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_TEMPLATEEQUIPMENTGROUP == operatorType) {
			sqlstr.append("insert into z_t_template_equipment_group ");	
			sqlstr.append("(ID,name,status,description,levelid)");									
			sqlstr.append(" values (?,?,?,?,?)");
			super.addStringForField(templateEquipmentGroupVO.getID());
			super.addStringForField(templateEquipmentGroupVO.getName());
			super.addIntForField(templateEquipmentGroupVO.getStatus());
			super.addStringForField(templateEquipmentGroupVO.getDescription());
			super.addStringForField(templateEquipmentGroupVO.getLevelid());
		}else if (MODIFY_TEMPLATEEQUIPMENTGROUP == operatorType) {
			sqlstr.append("update  z_t_template_equipment_group set ");
			sqlstr.append(" ID = ID ");



			if(templateEquipmentGroupVO.getName()!=null){
				sqlstr.append(" , name=? ");
				super.addStringForField(templateEquipmentGroupVO.getName());
			}	

			if(templateEquipmentGroupVO.getStatus()!=Integer.MIN_VALUE){
				sqlstr.append(" , status=?");	
				super.addIntForField(templateEquipmentGroupVO.getStatus());
			}

			if(templateEquipmentGroupVO.getDescription()!=null){
				sqlstr.append(" , description=? ");
				super.addStringForField(templateEquipmentGroupVO.getDescription());
			}	


			sqlstr.append(" where ID in (?) ");
			if(templateEquipmentGroupVO.getID()!=null){
				super.addStringForField(templateEquipmentGroupVO.getID());
			}	
		}else if (DEL_TEMPLATEEQUIPMENTGROUP == operatorType) {
			sqlstr.append("delete  from  z_t_template_equipment_group ");
			sqlstr.append(" where ID in (?) ");
			super.addStringForField(templateEquipmentGroupVO.getID());
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr(){
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


