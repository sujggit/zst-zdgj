package com.zzst.dao.project.avic.applySysInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.project.avic.applySysInsert.ApplySysInsertVO;

/**
 * class description: ApplySysInsert MQB
 * 
 * @date Fri Sep 21 17:34:16 CST 2012
 * @author ryan
 */
public class ApplySysInsertMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ApplySysInsertMQB.class
			.getName());

	public static int QUERY_FROM_APPLYSYSINSERT = 1;
	public static int QUERY_FROM_APPLYSYSINSERT_BY_IDS = 2;
	public static int QUERY_FROM_BY_USERID = 3;
	public static int QUERY_HISTORY_FROM_BY_USERID = 4;
	public static int QUERY_HISTORY_ALL = 5;

	private ApplySysInsertVO applySysInsertVO;
	private ArrayList<ApplySysInsertVO> listApplySysInsert = new ArrayList<ApplySysInsertVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ApplySysInsertMQB(int operatorType, ApplySysInsertVO applySysInsertVO) {
		_operatorType = operatorType;
		this.applySysInsertVO = applySysInsertVO;
		makeSql();
	}

	public ApplySysInsertMQB(int operatorType,ApplySysInsertVO applySysInsertVO, String ids) {
		_operatorType = operatorType;
		this.applySysInsertVO = applySysInsertVO;
		this.ids = ids;
		makeSql();
	}
	
	public ApplySysInsertMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(QUERY_FROM_BY_USERID == _operatorType ){
			strsql.append("select asi.*");
			strsql.append(" from avic_t_apply_sys_insert asi ,z_t_apply_detail ad");
			strsql.append(" where 1=1 and ad.status="+ApplyEnum.STATUS_ING+" and asi.applyID=ad.applyDetailID and asi.status!="+ApplyEnum.STATUS_REJECT);
			strsql.append(" and ad.checkUserIDs like '%," + ids + ",%'");
			if (null != applySysInsertVO) {
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getApplyID())) {
					strsql.append(" and applyID= ? ");
					super.addStringForField(applySysInsertVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentID())) {
					strsql.append(" and departmentID= ? ");
					super.addStringForField(applySysInsertVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentName())) {
					strsql.append(" and departmentName like ? ");
					super.addStringForField("%" + applySysInsertVO.getDepartmentName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentCode())) {
					strsql.append(" and departmentCode= ? ");
					super.addStringForField(applySysInsertVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanName())) {
					strsql.append(" and linkmanName like ? ");
					super.addStringForField("%" + applySysInsertVO.getLinkmanName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanPhone())) {
					strsql.append(" and linkmanPhone= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanPhone());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanFax())) {
					strsql.append(" and linkmanFax= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanFax());
				}	
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanCellPhone())) {
					strsql.append(" and linkmanCellPhone= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanCellPhone());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalModel())) {
					strsql.append(" and terminalModel= ? ");
					super.addStringForField(applySysInsertVO.getTerminalModel());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalIP())) {
					strsql.append(" and terminalIP= ? ");
					super.addStringForField(applySysInsertVO.getTerminalIP());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalFirewallPortScope())) {
					strsql.append(" and terminalFirewallPortScope= ? ");
					super.addStringForField(applySysInsertVO.getTerminalFirewallPortScope());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalLanPlace())) {
					strsql.append(" and terminalLanPlace= ? ");
					super.addStringForField(applySysInsertVO.getTerminalLanPlace());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDisplayEquipment())) {
					strsql.append(" and displayEquipment= ? ");
					super.addStringForField(applySysInsertVO.getDisplayEquipment());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getAmplifedSound())) {
					strsql.append(" and amplifedSound= ? ");
					super.addStringForField(applySysInsertVO.getAmplifedSound());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getTerminalNumber()) {
					strsql.append(" and terminalNumber= ? ");
					super.addIntForField(applySysInsertVO.getTerminalNumber());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getSpeed()) {
					strsql.append(" and speed= ? ");
					super.addIntForField(applySysInsertVO.getSpeed());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getNatChange()) {
					strsql.append(" and natChange= ? ");
					super.addIntForField(applySysInsertVO.getNatChange());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getFireWallBrand())) {
					strsql.append(" and fireWallBrand= ? ");
					super.addStringForField(applySysInsertVO.getFireWallBrand());
				}
				
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getFlowID())) {
					strsql.append(" and flowID= ? ");
					super.addStringForField(applySysInsertVO.getFlowID());
				}
				
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(applySysInsertVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getStatus()) {
					strsql.append(" and asi.status= ? ");
					super.addIntForField(applySysInsertVO.getStatus());
				}
				if (Long.MIN_VALUE != applySysInsertVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(applySysInsertVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(applySysInsertVO.getDescription());
				}
			}
			strsql.append(" group by asi.applyID order by asi.createTime desc");
		}else if(QUERY_HISTORY_FROM_BY_USERID == _operatorType){//历史查询
			strsql.append("SELECT asi.* ");
			strsql.append(" from avic_t_apply_sys_insert asi , z_t_apply_detail ad ");
			strsql.append(" where 1=1 and asi.applyID = ad.applyDetailID and ad.userId = ? ");
			super.addStringForField(ids);
			if (null != applySysInsertVO) {
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getApplyID())) {
					strsql.append(" and asi.applyID= ? ");
					super.addStringForField(applySysInsertVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentID())) {
					strsql.append(" and asi.departmentID= ? ");
					super.addStringForField(applySysInsertVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentName())) {
					strsql.append(" and asi.departmentName like ? ");
					super.addStringForField("%" + applySysInsertVO.getDepartmentName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentCode())) {
					strsql.append(" and asi.departmentCode= ? ");
					super.addStringForField(applySysInsertVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanName())) {
					strsql.append(" and asi.linkmanName like ? ");
					super.addStringForField("%" + applySysInsertVO.getLinkmanName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanPhone())) {
					strsql.append(" and asi.linkmanPhone= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanPhone());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanFax())) {
					strsql.append(" and asi.linkmanFax= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanFax());
				}	
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanCellPhone())) {
					strsql.append(" and asi.linkmanCellPhone= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanCellPhone());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalModel())) {
					strsql.append(" and asi.terminalModel= ? ");
					super.addStringForField(applySysInsertVO.getTerminalModel());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalIP())) {
					strsql.append(" and asi.terminalIP= ? ");
					super.addStringForField(applySysInsertVO.getTerminalIP());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalFirewallPortScope())) {
					strsql.append(" and asi.terminalFirewallPortScope= ? ");
					super.addStringForField(applySysInsertVO.getTerminalFirewallPortScope());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalLanPlace())) {
					strsql.append(" and asi.terminalLanPlace= ? ");
					super.addStringForField(applySysInsertVO.getTerminalLanPlace());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDisplayEquipment())) {
					strsql.append(" and asi.displayEquipment= ? ");
					super.addStringForField(applySysInsertVO.getDisplayEquipment());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getAmplifedSound())) {
					strsql.append(" and asi.amplifedSound= ? ");
					super.addStringForField(applySysInsertVO.getAmplifedSound());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getTerminalNumber()) {
					strsql.append(" and asi.terminalNumber= ? ");
					super.addIntForField(applySysInsertVO.getTerminalNumber());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getSpeed()) {
					strsql.append(" and asi.speed= ? ");
					super.addIntForField(applySysInsertVO.getSpeed());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getNatChange()) {
					strsql.append(" and asi.natChange= ? ");
					super.addIntForField(applySysInsertVO.getNatChange());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getFireWallBrand())) {
					strsql.append(" and asi.fireWallBrand= ? ");
					super.addStringForField(applySysInsertVO.getFireWallBrand());
				}
				
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getFlowID())) {
					strsql.append(" and asi.flowID= ? ");
					super.addStringForField(applySysInsertVO.getFlowID());
				}
				
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getCreateUserID())) {
					strsql.append(" and asi.createUserID= ? ");
					super.addStringForField(applySysInsertVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getStatus()) {
					strsql.append(" and asi.status= ? ");
					super.addIntForField(applySysInsertVO.getStatus());
				}
				if (Long.MIN_VALUE != applySysInsertVO.getRevision()) {
					strsql.append(" and asi.revision= ? ");
					super.addLongForField(applySysInsertVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDescription())) {
					strsql.append(" and asi.description= ? ");
					super.addStringForField(applySysInsertVO.getDescription());
				}
			}
			strsql.append(" group by asi.applyID order by asi.createTime desc");
		}else if(QUERY_HISTORY_ALL == _operatorType){//历史查询
			strsql.append("SELECT asi.* ");
			strsql.append("from avic_t_apply_sys_insert asi , z_t_apply_detail ad ");
			strsql.append("where 1=1 and asi.applyID = ad.applyDetailID ");
			if (null != applySysInsertVO) {
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getApplyID())) {
					strsql.append(" and asi.applyID= ? ");
					super.addStringForField(applySysInsertVO.getApplyID());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentID())) {
					strsql.append(" and asi.departmentID= ? ");
					super.addStringForField(applySysInsertVO.getDepartmentID());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentName())) {
					strsql.append(" and asi.departmentName like ? ");
					super.addStringForField("%" + applySysInsertVO.getDepartmentName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentCode())) {
					strsql.append(" and asi.departmentCode= ? ");
					super.addStringForField(applySysInsertVO.getDepartmentCode());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanName())) {
					strsql.append(" and asi.linkmanName like ? ");
					super.addStringForField("%" + applySysInsertVO.getLinkmanName().trim() + "%");
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanPhone())) {
					strsql.append(" and asi.linkmanPhone= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanPhone());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanFax())) {
					strsql.append(" and asi.linkmanFax= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanFax());
				}	
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanCellPhone())) {
					strsql.append(" and asi.linkmanCellPhone= ? ");
					super.addStringForField(applySysInsertVO.getLinkmanCellPhone());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalModel())) {
					strsql.append(" and asi.terminalModel= ? ");
					super.addStringForField(applySysInsertVO.getTerminalModel());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalIP())) {
					strsql.append(" and asi.terminalIP= ? ");
					super.addStringForField(applySysInsertVO.getTerminalIP());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalFirewallPortScope())) {
					strsql.append(" and asi.terminalFirewallPortScope= ? ");
					super.addStringForField(applySysInsertVO.getTerminalFirewallPortScope());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalLanPlace())) {
					strsql.append(" and asi.terminalLanPlace= ? ");
					super.addStringForField(applySysInsertVO.getTerminalLanPlace());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDisplayEquipment())) {
					strsql.append(" and asi.displayEquipment= ? ");
					super.addStringForField(applySysInsertVO.getDisplayEquipment());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getAmplifedSound())) {
					strsql.append(" and asi.amplifedSound= ? ");
					super.addStringForField(applySysInsertVO.getAmplifedSound());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getTerminalNumber()) {
					strsql.append(" and asi.terminalNumber= ? ");
					super.addIntForField(applySysInsertVO.getTerminalNumber());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getSpeed()) {
					strsql.append(" and asi.speed= ? ");
					super.addIntForField(applySysInsertVO.getSpeed());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getNatChange()) {
					strsql.append(" and asi.natChange= ? ");
					super.addIntForField(applySysInsertVO.getNatChange());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getFireWallBrand())) {
					strsql.append(" and asi.fireWallBrand= ? ");
					super.addStringForField(applySysInsertVO.getFireWallBrand());
				}
				
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getFlowID())) {
					strsql.append(" and asi.flowID= ? ");
					super.addStringForField(applySysInsertVO.getFlowID());
				}
				
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getCreateUserID())) {
					strsql.append(" and asi.createUserID= ? ");
					super.addStringForField(applySysInsertVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applySysInsertVO.getStatus()) {
					strsql.append(" and asi.status= ? ");
					super.addIntForField(applySysInsertVO.getStatus());
				}
				if (Long.MIN_VALUE != applySysInsertVO.getRevision()) {
					strsql.append(" and asi.revision= ? ");
					super.addLongForField(applySysInsertVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applySysInsertVO.getDescription())) {
					strsql.append(" and asi.description= ? ");
					super.addStringForField(applySysInsertVO.getDescription());
				}
			}
			strsql.append(" group by asi.applyID order by asi.createTime desc");
		}else{
			strsql.append("select applyID,departmentID,departmentName,departmentCode,linkmanName,linkmanPhone,linkmanFax,linkmanCellPhone,terminalModel,terminalIP,terminalFirewallPortScope,terminalLanPlace,displayEquipment,amplifedSound,terminalNumber,speed,natChange,fireWallBrand,flowID,createUserID,createTime,status,revision,description ");
			strsql.append(" from avic_t_apply_sys_insert ");
			strsql.append(" where 1=1 ");

			if (QUERY_FROM_APPLYSYSINSERT == _operatorType) {
				if (null != applySysInsertVO) {
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getApplyID())) {
						strsql.append(" and applyID= ? ");
						super.addStringForField(applySysInsertVO.getApplyID());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentID())) {
						strsql.append(" and departmentID= ? ");
						super.addStringForField(applySysInsertVO.getDepartmentID());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentName())) {
						strsql.append(" and departmentName= ? ");
						super.addStringForField(applySysInsertVO.getDepartmentName());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getDepartmentCode())) {
						strsql.append(" and departmentCode= ? ");
						super.addStringForField(applySysInsertVO.getDepartmentCode());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanName())) {
						strsql.append(" and linkmanName= ? ");
						super.addStringForField(applySysInsertVO.getLinkmanName());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanPhone())) {
						strsql.append(" and linkmanPhone= ? ");
						super.addStringForField(applySysInsertVO.getLinkmanPhone());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanFax())) {
						strsql.append(" and linkmanFax= ? ");
						super.addStringForField(applySysInsertVO.getLinkmanFax());
					}	
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getLinkmanCellPhone())) {
						strsql.append(" and linkmanCellPhone= ? ");
						super.addStringForField(applySysInsertVO.getLinkmanCellPhone());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalModel())) {
						strsql.append(" and terminalModel= ? ");
						super.addStringForField(applySysInsertVO.getTerminalModel());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalIP())) {
						strsql.append(" and terminalIP= ? ");
						super.addStringForField(applySysInsertVO.getTerminalIP());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalFirewallPortScope())) {
						strsql.append(" and terminalFirewallPortScope= ? ");
						super.addStringForField(applySysInsertVO.getTerminalFirewallPortScope());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getTerminalLanPlace())) {
						strsql.append(" and terminalLanPlace= ? ");
						super.addStringForField(applySysInsertVO.getTerminalLanPlace());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getDisplayEquipment())) {
						strsql.append(" and displayEquipment= ? ");
						super.addStringForField(applySysInsertVO.getDisplayEquipment());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getAmplifedSound())) {
						strsql.append(" and amplifedSound= ? ");
						super.addStringForField(applySysInsertVO.getAmplifedSound());
					}
					if (Integer.MIN_VALUE != applySysInsertVO.getTerminalNumber()) {
						strsql.append(" and terminalNumber= ? ");
						super.addIntForField(applySysInsertVO.getTerminalNumber());
					}
					if (Integer.MIN_VALUE != applySysInsertVO.getSpeed()) {
						strsql.append(" and speed= ? ");
						super.addIntForField(applySysInsertVO.getSpeed());
					}
					if (Integer.MIN_VALUE != applySysInsertVO.getNatChange()) {
						strsql.append(" and natChange= ? ");
						super.addIntForField(applySysInsertVO.getNatChange());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getFireWallBrand())) {
						strsql.append(" and fireWallBrand= ? ");
						super.addStringForField(applySysInsertVO.getFireWallBrand());
					}
					
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getFlowID())) {
						strsql.append(" and flowID= ? ");
						super.addStringForField(applySysInsertVO.getFlowID());
					}
					
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getCreateUserID())) {
						strsql.append(" and createUserID= ? ");
						super.addStringForField(applySysInsertVO.getCreateUserID());
					}
					if (Integer.MIN_VALUE != applySysInsertVO.getStatus()) {
						strsql.append(" and status= ? ");
						super.addIntForField(applySysInsertVO.getStatus());
					}
					if (Long.MIN_VALUE != applySysInsertVO.getRevision()) {
						strsql.append(" and revision= ? ");
						super.addLongForField(applySysInsertVO.getRevision());
					}
					if (!StringUtils.isNullOrBlank(applySysInsertVO.getDescription())) {
						strsql.append(" and description= ? ");
						super.addStringForField(applySysInsertVO.getDescription());
					}
				}
			} else if (QUERY_FROM_APPLYSYSINSERT_BY_IDS == _operatorType) {
				strsql.append(" and applyID in (?) ");
				super.addStringForField(ids);
			}
			strsql.append(" group by applyID order by createTime desc");
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
		if( QUERY_FROM_BY_USERID == _operatorType ){
			applySysInsertVO = new ApplySysInsertVO();
			applySysInsertVO.setApplyID(rs.getString("applyID"));
			applySysInsertVO.setDepartmentID(rs.getString("departmentID"));
			applySysInsertVO.setDepartmentName(rs.getString("departmentName"));
			applySysInsertVO.setDepartmentCode(rs.getString("departmentCode"));
			applySysInsertVO.setLinkmanName(rs.getString("linkmanName"));
			applySysInsertVO.setLinkmanPhone(rs.getString("linkmanPhone"));
			applySysInsertVO.setLinkmanFax(rs.getString("linkmanFax"));
			applySysInsertVO.setLinkmanCellPhone(rs.getString("linkmanCellPhone"));
			applySysInsertVO.setTerminalModel(rs.getString("terminalModel"));
			applySysInsertVO.setTerminalIP(rs.getString("terminalIP"));
			applySysInsertVO.setTerminalFirewallPortScope(rs.getString("terminalFirewallPortScope"));
			applySysInsertVO.setTerminalLanPlace(rs.getString("terminalLanPlace"));
			applySysInsertVO.setDisplayEquipment(rs.getString("displayEquipment"));
			applySysInsertVO.setAmplifedSound(rs.getString("amplifedSound"));
			applySysInsertVO.setTerminalNumber(rs.getInt("terminalNumber"));
			applySysInsertVO.setSpeed(rs.getInt("speed"));
			applySysInsertVO.setNatChange(rs.getInt("natChange"));
			applySysInsertVO.setFireWallBrand(rs.getString("fireWallBrand"));
			applySysInsertVO.setFlowID(rs.getString("flowID"));
			applySysInsertVO.setCreateUserID(rs.getString("createUserID"));
			applySysInsertVO.setCreateTime(rs.getTimestamp("createTime"));
			applySysInsertVO.setStatus(rs.getInt("status"));
			applySysInsertVO.setRevision(rs.getLong("revision"));
			if(QUERY_FROM_BY_USERID == _operatorType){
				applySysInsertVO.setDescription(rs.getString("description"));
			}else{
				applySysInsertVO.setDescription(rs.getString("flow_id"));
			}
//			applySysInsertVO.setFlowId(rs.getString("flow_id"));//当前登录用户所在节点
			listApplySysInsert.add(applySysInsertVO);
			
		}else{
			applySysInsertVO = new ApplySysInsertVO();
			applySysInsertVO.setApplyID(rs.getString("applyID"));
			applySysInsertVO.setDepartmentID(rs.getString("departmentID"));
			applySysInsertVO.setDepartmentName(rs.getString("departmentName"));
			applySysInsertVO.setDepartmentCode(rs.getString("departmentCode"));
			applySysInsertVO.setLinkmanName(rs.getString("linkmanName"));
			applySysInsertVO.setLinkmanPhone(rs.getString("linkmanPhone"));
			applySysInsertVO.setLinkmanFax(rs.getString("linkmanFax"));
			applySysInsertVO.setLinkmanCellPhone(rs.getString("linkmanCellPhone"));
			applySysInsertVO.setTerminalModel(rs.getString("terminalModel"));
			applySysInsertVO.setTerminalIP(rs.getString("terminalIP"));
			applySysInsertVO.setTerminalFirewallPortScope(rs.getString("terminalFirewallPortScope"));
			applySysInsertVO.setTerminalLanPlace(rs.getString("terminalLanPlace"));
			applySysInsertVO.setDisplayEquipment(rs.getString("displayEquipment"));
			applySysInsertVO.setAmplifedSound(rs.getString("amplifedSound"));
			applySysInsertVO.setTerminalNumber(rs.getInt("terminalNumber"));
			applySysInsertVO.setSpeed(rs.getInt("speed"));
			applySysInsertVO.setNatChange(rs.getInt("natChange"));
			applySysInsertVO.setFireWallBrand(rs.getString("fireWallBrand"));
			applySysInsertVO.setFlowID(rs.getString("flowID"));
			applySysInsertVO.setCreateUserID(rs.getString("createUserID"));
			applySysInsertVO.setCreateTime(rs.getTimestamp("createTime"));
			applySysInsertVO.setStatus(rs.getInt("status"));
			applySysInsertVO.setRevision(rs.getLong("revision"));
			applySysInsertVO.setDescription(rs.getString("description"));
			listApplySysInsert.add(applySysInsertVO);
		}
	}

	public ArrayList<ApplySysInsertVO> getApplySysInsertList() {
		return listApplySysInsert;
	}

	public ApplySysInsertVO getApplySysInsertVO() {
		return applySysInsertVO;
	}

}
