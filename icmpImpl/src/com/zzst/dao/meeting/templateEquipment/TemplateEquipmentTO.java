
package com.zzst.dao.meeting.templateEquipment;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;

/**
 * class description:	TemplateEquipment TO
 * @date Wed Mar 20 13:12:04 CST 2013
 * @author ryan
 */
public class TemplateEquipmentTO extends TransactionObject {

	private	static Logger logger = CbfLogger.getLogger(TemplateEquipmentTO.class.getName());
	private int operatorType=-1;

	public static int 	ADD_TEMPLATEEQUIPMENT=1;
	public static int 	MODIFY_TEMPLATEEQUIPMENT=2;
	public static int 	DEL_TEMPLATEEQUIPMENT=3;
	private int result = 0;

	private TemplateEquipmentVO templateEquipmentVO;
	private	String	ids = "";

	public TemplateEquipmentTO(int operatorType,TemplateEquipmentVO templateEquipmentVO){
		this.operatorType = operatorType;
		this.templateEquipmentVO = templateEquipmentVO;
	}
	public TemplateEquipmentTO(int operatorType,String ids){
		this.operatorType = operatorType;
		this.ids = ids;
	}



















	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_TEMPLATEEQUIPMENT == operatorType) {
			sqlstr.append("insert into z_t_template_equipment ");	
			sqlstr.append("(ID,groupId,equipmentName,equipmentIp,pInterface,aliasName,aliasType,ptsNumber,lineRate,maxResolution,videoProtocol,cascadeRole,agc,callDirection,isMain,description,meetingRoomID)");									
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(templateEquipmentVO.getID());
			super.addStringForField(templateEquipmentVO.getGroupId());
			super.addStringForField(templateEquipmentVO.getEquipmentName());
			super.addStringForField(templateEquipmentVO.getEquipmentIp());
			super.addStringForField(templateEquipmentVO.getPInterface());
			super.addStringForField(templateEquipmentVO.getAliasName());
			super.addStringForField(templateEquipmentVO.getAliasType());
			super.addStringForField(templateEquipmentVO.getPtsNumber());
			super.addStringForField(templateEquipmentVO.getLineRate());
			super.addStringForField(templateEquipmentVO.getMaxResolution());
			super.addStringForField(templateEquipmentVO.getVideoProtocol());
			super.addStringForField(templateEquipmentVO.getCascadeRole());
			super.addStringForField(templateEquipmentVO.getAgc());
			super.addStringForField(templateEquipmentVO.getCallDirection());
			super.addIntForField(templateEquipmentVO.getIsMain());
			super.addStringForField(templateEquipmentVO.getDescription());
			super.addStringForField(templateEquipmentVO.getMeetingRoomID());
		}else if (MODIFY_TEMPLATEEQUIPMENT == operatorType) {
			sqlstr.append("update  z_t_template_equipment set ");
			sqlstr.append(" ID = ID ");



			if(templateEquipmentVO.getGroupId()!=null){
				sqlstr.append(" , groupId=? ");
				super.addStringForField(templateEquipmentVO.getGroupId());
			}	

			if(templateEquipmentVO.getEquipmentName()!=null){
				sqlstr.append(" , equipmentName=? ");
				super.addStringForField(templateEquipmentVO.getEquipmentName());
			}	

			if(templateEquipmentVO.getEquipmentIp()!=null){
				sqlstr.append(" , equipmentIp=? ");
				super.addStringForField(templateEquipmentVO.getEquipmentIp());
			}	

			if(templateEquipmentVO.getPInterface()!=null){
				sqlstr.append(" , pInterface=? ");
				super.addStringForField(templateEquipmentVO.getPInterface());
			}	

			if(templateEquipmentVO.getAliasName()!=null){
				sqlstr.append(" , aliasName=? ");
				super.addStringForField(templateEquipmentVO.getAliasName());
			}	

			if(templateEquipmentVO.getAliasType()!=null){
				sqlstr.append(" , aliasType=? ");
				super.addStringForField(templateEquipmentVO.getAliasType());
			}	

			if(templateEquipmentVO.getPtsNumber()!=null){
				sqlstr.append(" , ptsNumber=? ");
				super.addStringForField(templateEquipmentVO.getPtsNumber());
			}	

			if(templateEquipmentVO.getLineRate()!=null){
				sqlstr.append(" , lineRate=? ");
				super.addStringForField(templateEquipmentVO.getLineRate());
			}	

			if(templateEquipmentVO.getMaxResolution()!=null){
				sqlstr.append(" , maxResolution=? ");
				super.addStringForField(templateEquipmentVO.getMaxResolution());
			}	

			if(templateEquipmentVO.getVideoProtocol()!=null){
				sqlstr.append(" , videoProtocol=? ");
				super.addStringForField(templateEquipmentVO.getVideoProtocol());
			}	

			if(templateEquipmentVO.getCascadeRole()!=null){
				sqlstr.append(" , cascadeRole=? ");
				super.addStringForField(templateEquipmentVO.getCascadeRole());
			}	

			if(templateEquipmentVO.getAgc()!=null){
				sqlstr.append(" , agc=? ");
				super.addStringForField(templateEquipmentVO.getAgc());
			}	

			if(templateEquipmentVO.getCallDirection()!=null){
				sqlstr.append(" , callDirection=? ");
				super.addStringForField(templateEquipmentVO.getCallDirection());
			}	

			if(templateEquipmentVO.getIsMain()!=Integer.MIN_VALUE){
				sqlstr.append(" , isMain=?");	
				super.addIntForField(templateEquipmentVO.getIsMain());
			}

			if(templateEquipmentVO.getDescription()!=null){
				sqlstr.append(" , description=? ");
				super.addStringForField(templateEquipmentVO.getDescription());
			}
			
			if(templateEquipmentVO.getMeetingRoomID()!=null){
				sqlstr.append(" , meetingRoomID =? ");
				super.addStringForField(templateEquipmentVO.getMeetingRoomID());
			}


			sqlstr.append(" where ID in (?) ");
			if(templateEquipmentVO.getID()!=null){
				super.addStringForField(templateEquipmentVO.getID());
			}	
		}else if (DEL_TEMPLATEEQUIPMENT == operatorType) {
			sqlstr.append("delete  from  z_t_template_equipment ");
			sqlstr.append(" where ID in (?) ");
			super.addStringForField(templateEquipmentVO.getID());
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


