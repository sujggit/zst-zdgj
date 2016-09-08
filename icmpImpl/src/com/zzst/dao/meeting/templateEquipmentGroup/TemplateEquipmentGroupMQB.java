package com.zzst.dao.meeting.templateEquipmentGroup;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;

/**
 * class description:	TemplateEquipmentGroup MQB
 * @date Wed Mar 20 18:48:48 CST 2013
 * @author ryan
 */
public class TemplateEquipmentGroupMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(TemplateEquipmentGroupMQB.class.getName());

	public static int  QUERY_FROM_TEMPLATEEQUIPMENTGROUP		=	1;
	public static int  QUERY_FROM_TEMPLATEEQUIPMENTGROUP_BY_IDS =	2;

	private TemplateEquipmentGroupVO  templateEquipmentGroupVO;
	private ArrayList<TemplateEquipmentGroupVO> listTemplateEquipmentGroup=new ArrayList<TemplateEquipmentGroupVO>();


	private int _operatorType=-1;
	private	String	ids = "";

	public TemplateEquipmentGroupMQB(int operatorType,TemplateEquipmentGroupVO  templateEquipmentGroupVO){
		_operatorType=operatorType;
		this.templateEquipmentGroupVO = templateEquipmentGroupVO;
		makeSql();
	}
	public TemplateEquipmentGroupMQB(int operatorType, String	ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	private	void	makeSql(){
		StringBuffer strsql=new StringBuffer();
		strsql.append("select ID,name,status,description,levelid");
		strsql.append(" from z_t_template_equipment_group ");
		strsql.append(" where 1=1 ");	

		if (QUERY_FROM_TEMPLATEEQUIPMENTGROUP == _operatorType) {
			if(null!=templateEquipmentGroupVO){
				if(!StringUtils.isNullOrBlank(templateEquipmentGroupVO.getID())){
					strsql.append(" and ID= ? ");
					super.addStringForField(templateEquipmentGroupVO.getID());
				}
				if(!StringUtils.isNullOrBlank(templateEquipmentGroupVO.getName())){
					strsql.append(" and name like ? ");
					super.addStringForField("%"+templateEquipmentGroupVO.getName()+"%");
				}
				if(Integer.MIN_VALUE!=templateEquipmentGroupVO.getStatus()){
					strsql.append(" and status= ? ");
					super.addIntForField(templateEquipmentGroupVO.getStatus());
				}
				if(!StringUtils.isNullOrBlank(templateEquipmentGroupVO.getDescription())){
					strsql.append(" and description= ? ");
					super.addStringForField(templateEquipmentGroupVO.getDescription());
				}
				if(!StringUtils.isNullOrBlank(templateEquipmentGroupVO.getLevelid())){
					strsql.append(" and levelid in("+templateEquipmentGroupVO.getLevelid()+") ");
					//super.addStringForField(templateEquipmentGroupVO.getLevelid());
				}
			}
		}else if (QUERY_FROM_TEMPLATEEQUIPMENTGROUP_BY_IDS == _operatorType) {
			strsql.append(" and ID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr){
		this.sqlStr=sqlstr;
	}

	public String getSql(){
		return this.sqlStr;
	}
	public void getDataForRow(ResultSet rs) throws SQLException {
		templateEquipmentGroupVO=new TemplateEquipmentGroupVO();
		templateEquipmentGroupVO.setID(rs.getString("ID"));
		templateEquipmentGroupVO.setName(rs.getString("name"));
		templateEquipmentGroupVO.setStatus(rs.getInt("status"));
		templateEquipmentGroupVO.setDescription(rs.getString("description"));
		templateEquipmentGroupVO.setLevelid(rs.getString("levelid"));
		listTemplateEquipmentGroup.add(templateEquipmentGroupVO);
	}

	public ArrayList<TemplateEquipmentGroupVO> getTemplateEquipmentGroupList(){
		return listTemplateEquipmentGroup;
	}
	public TemplateEquipmentGroupVO getTemplateEquipmentGroupVO(){
		return templateEquipmentGroupVO;
	}

}



