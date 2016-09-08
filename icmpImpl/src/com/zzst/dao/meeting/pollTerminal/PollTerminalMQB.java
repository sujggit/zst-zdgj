package com.zzst.dao.meeting.pollTerminal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;

/**
 * class description: PollTerminal MQB
 * 
 * @date Thu May 16 15:21:34 CST 2013
 * @author ryan
 */
public class PollTerminalMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(PollTerminalMQB.class.getName());

	public static int QUERY_FROM_POLLTERMINAL = 1;
	public static int QUERY_FROM_POLLTERMINAL_BY_IDS = 2;
	public static int QUERY_FROM_POLLTERMINAL_WITH_EQUIPMENT = 3;
	public static int QUERY_FROM_POLLTERMINAL_RIGHTJOIN_EQUIPMENT = 4;

	private PollTerminalVO pollTerminalVO;
	private ArrayList<PollTerminalVO> listPollTerminal = new ArrayList<PollTerminalVO>();

	private int _operatorType = -1;
	private String ids = "";

	public PollTerminalMQB(int operatorType, PollTerminalVO pollTerminalVO) {
		_operatorType = operatorType;
		this.pollTerminalVO = pollTerminalVO;
		makeSql();
	}

	public PollTerminalMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		

		if (QUERY_FROM_POLLTERMINAL == _operatorType) {
			strsql.append("select pollTerminalID,pollTemplateID,equipmentID,createUserID,createTime,orderNum,description,orgType,status ");
			strsql.append(" from z_t_poll_terminal ");
			strsql.append(" where 1=1 ");
			if (null != pollTerminalVO) {
				if (!StringUtils.isNullOrBlank(pollTerminalVO
						.getPollTerminalID())) {
					strsql.append(" and pollTerminalID= ? ");
					super.addStringForField(pollTerminalVO.getPollTerminalID());
				}
				if (!StringUtils.isNullOrBlank(pollTerminalVO
						.getPollTemplateID())) {
					strsql.append(" and pollTemplateID= ? ");
					super.addStringForField(pollTerminalVO.getPollTemplateID());
				}
				if (!StringUtils.isNullOrBlank(pollTerminalVO.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(pollTerminalVO.getEquipmentID());
				}
				if (!StringUtils
						.isNullOrBlank(pollTerminalVO.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(pollTerminalVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != pollTerminalVO.getOrderNum()) {
					strsql.append(" and orderNum= ? ");
					super.addIntForField(pollTerminalVO.getOrderNum());
				}
				if (!StringUtils.isNullOrBlank(pollTerminalVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(pollTerminalVO.getDescription());
				}
				if (Integer.MIN_VALUE != pollTerminalVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(pollTerminalVO.getStatus());
				}
				if (Integer.MIN_VALUE != pollTerminalVO.getOrgType()) {
					strsql.append(" and orgType= ? ");
					super.addIntForField(pollTerminalVO.getOrgType());
				}
			}
		} else if (QUERY_FROM_POLLTERMINAL_BY_IDS == _operatorType) {
			strsql.append("select pollTerminalID,pollTemplateID,equipmentID,createUserID,createTime,orderNum,description,orgType,status ");
			strsql.append(" from z_t_poll_terminal ");
			strsql.append(" where 1=1 ");
			strsql.append(" and pollTerminalID in (?) ");
			super.addStringForField(ids);
		} else if (QUERY_FROM_POLLTERMINAL_WITH_EQUIPMENT == _operatorType){
			strsql.append("select p.pollTerminalID,p.pollTemplateID,p.equipmentID,p.createUserID,p.createTime,p.orderNum,p.description,p.orgType,p.status,e.equipmentNO,e.ip ");
			strsql.append(" from z_t_poll_terminal p inner join z_t_equipment e");
			strsql.append(" on p.equipmentID = e.equipmentID");
			if (null != pollTerminalVO) {
				if(!StringUtils.isNullOrBlank(pollTerminalVO
						.getPollTemplateID())) {
					strsql.append(" and pollTemplateID = ?");
					super.addStringForField(pollTerminalVO.getPollTemplateID());
				}
				if (Integer.MIN_VALUE != pollTerminalVO.getOrgType()) {
					strsql.append(" and p.orgType= ? ");
					super.addIntForField(pollTerminalVO.getOrgType());
				}
			}
			strsql.append(" order by p.orderNum");
		} else if( QUERY_FROM_POLLTERMINAL_RIGHTJOIN_EQUIPMENT == _operatorType ){
			strsql.append("SELECT  a.polltemplateID ,a.orderNum, b.equipmentID , b.equipmentNO,b.status,b.equipmentType FROM (select z_t_equipment.* from z_t_equipment join z_t_meetingroom on z_t_equipment.roomID = z_t_meetingroom.meetingroomID  join z_t_user on z_t_equipment.adminID =  z_t_user.userID where z_t_meetingroom.status = 0 and z_t_user.status = 1) b LEFT JOIN ");
			strsql.append("( SELECT * FROM z_t_poll_terminal WHERE 1= 1 and z_t_poll_terminal.orgType = 0 ");
			if (null != pollTerminalVO) {
				if(!StringUtils.isNullOrBlank(pollTerminalVO.getPollTemplateID())) {
					strsql.append("and z_t_poll_terminal.pollTemplateID  = ? ) a ");
					super.addStringForField(pollTerminalVO.getPollTemplateID());
				}
			}
			strsql.append(" ON b.equipmentID = a.equipmentID WHERE  b.equipmentType = 0 AND b.status != 3 ORDER BY a.orderNum");
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
		if(QUERY_FROM_POLLTERMINAL_WITH_EQUIPMENT == _operatorType){
			pollTerminalVO = new PollTerminalVO();
			pollTerminalVO.setPollTerminalID(rs.getString("pollTerminalID"));
			pollTerminalVO.setPollTemplateID(rs.getString("pollTemplateID"));
			pollTerminalVO.setEquipmentID(rs.getString("equipmentID"));
			pollTerminalVO.setCreateUserID(rs.getString("createUserID"));
			pollTerminalVO.setCreateTime(rs.getTimestamp("createTime"));
			pollTerminalVO.setOrderNum(rs.getInt("orderNum"));
			pollTerminalVO.setDescription(rs.getString("description"));
			pollTerminalVO.setStatus(rs.getInt("status"));
			pollTerminalVO.getEquipmentVO().setEquipmentNO(rs.getString("equipmentNo"));
			pollTerminalVO.setOrgType(rs.getInt("orgType"));
			pollTerminalVO.getEquipmentVO().setIp(rs.getString("ip"));
		}else if( QUERY_FROM_POLLTERMINAL_RIGHTJOIN_EQUIPMENT == _operatorType ){
			pollTerminalVO = new PollTerminalVO();
			pollTerminalVO.setPollTemplateID(rs.getString("a.polltemplateID"));
			pollTerminalVO.setOrderNum(rs.getInt("a.orderNum"));
			pollTerminalVO.setEquipmentID(rs.getString("b.equipmentID"));
			pollTerminalVO.getEquipmentVO().setEquipmentNO(rs.getString("b.equipmentNO"));
		}else{
			pollTerminalVO = new PollTerminalVO();
			pollTerminalVO.setPollTerminalID(rs.getString("pollTerminalID"));
			pollTerminalVO.setPollTemplateID(rs.getString("pollTemplateID"));
			pollTerminalVO.setEquipmentID(rs.getString("equipmentID"));
			pollTerminalVO.setCreateUserID(rs.getString("createUserID"));
			pollTerminalVO.setCreateTime(rs.getTimestamp("createTime"));
			pollTerminalVO.setOrderNum(rs.getInt("orderNum"));
			pollTerminalVO.setDescription(rs.getString("description"));
			pollTerminalVO.setStatus(rs.getInt("status"));
			pollTerminalVO.setOrgType(rs.getInt("orgType"));
		}
		
		listPollTerminal.add(pollTerminalVO);
	}

	public ArrayList<PollTerminalVO> getPollTerminalList() {
		return listPollTerminal;
	}

	public PollTerminalVO getPollTerminalVO() {
		return pollTerminalVO;
	}

}
