package com.zzst.dao.meeting.equipment.maintain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;

import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

/**
 * class description: EquipmentMaintain MQB
 * 
 * @date Mon May 06 13:35:59 CST 2013
 * @author ryan
 */
public class EquipmentMaintainMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentMaintainMQB.class.getName());

	public static int QUERY_FROM_EQUIPMENTMAINTAIN = 1;
	public static int QUERY_FROM_EQUIPMENTMAINTAIN_BY_IDS = 2;
	public static int QUERY_FROM_EQUIPMENTMAINTAIN_ALL = 3;
	public static int QUERY_FROM_EQUIPMENTMAINTAIN_BY_SQLS=4;
	public static int QUERY_FROM_EQUIPMENTMAINTAIN_JOIN_EQUIPMENT = 5;
	
	private EquipmentMaintainVO equipmentMaintainVO;
	private ArrayList<EquipmentMaintainVO> listEquipmentMaintain = new ArrayList<EquipmentMaintainVO>();

	private int _operatorType = -1;
	private String ids = "";

	public EquipmentMaintainMQB(int operatorType, EquipmentMaintainVO equipmentMaintainVO) {
		_operatorType = operatorType;
		this.equipmentMaintainVO = equipmentMaintainVO;
		makeSql();
	}

	public EquipmentMaintainMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(QUERY_FROM_EQUIPMENTMAINTAIN_BY_SQLS==_operatorType){
			strsql.append("select maintainID,equipmentID,roomID,status,updateUserID,updateTime,maintainCost,description,revision ");
			strsql.append(" from z_t_Equipment_maintain ");
			strsql.append(" where 1=1 ");
			strsql.append(equipmentMaintainVO.getSqls());

		}else if( QUERY_FROM_EQUIPMENTMAINTAIN_JOIN_EQUIPMENT == _operatorType ){
			strsql.append("SELECT a.maintainID, a.equipmentID , a.roomID , a.updateUserID , a.updateTime ,a.maintainCost ,a.description, a.status , b.equipmentType, b.equipmentNO , b.equipmentIdentifier ,c.meetingroomName ");
			strsql.append("FROM z_t_equipment_maintain a INNER JOIN z_t_equipment b ON a.equipmentID = b.equipmentID INNER JOIN z_t_meetingroom c ON a.roomID = c.meetingroomID ");
			strsql.append("WHERE 1= 1 ");
			
			if (null != equipmentMaintainVO) {
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getMaintainID())) {
					strsql.append(" and a.maintainID= ? ");
					super.addStringForField(equipmentMaintainVO.getMaintainID());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getEquipmentID())) {
					strsql.append(" and a.equipmentID= ? ");
					super.addStringForField(equipmentMaintainVO.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getRoomID())) {
					strsql.append(" and a.roomID= ? ");
					super.addStringForField(equipmentMaintainVO.getRoomID());
				}
				if (Integer.MIN_VALUE != equipmentMaintainVO.getStatus()) {
					strsql.append(" and a.status= ? ");
					super.addIntForField(equipmentMaintainVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getUpdateUserID())) {
					strsql.append(" and a.updateUserID= ? ");
					super.addStringForField(equipmentMaintainVO.getUpdateUserID());
				}
				
				if( Integer.MIN_VALUE != equipmentMaintainVO.getEquipmentVO().getEquipmentType() ){
					strsql.append(" and b.equipmentType= ? ");
					super.addIntForField(equipmentMaintainVO.getEquipmentVO().getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomID())) {
					strsql.append(" and b.roomID= ? ");
					super.addStringForField(equipmentMaintainVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomID());
				}
				if ( !StringUtils.isNullOrBlank(equipmentMaintainVO.getEquipmentVO().getEquipmentIdentifier()) ){
					strsql.append(" and b.equipmentIdentifier = ? ");
					super.addStringForField(equipmentMaintainVO.getEquipmentVO().getEquipmentIdentifier());
				}
				if ( equipmentMaintainVO.getUpdateStartTime() != null ) {
					strsql.append(" and a.updateTime >= ? ");
					super.addTimestampForField(equipmentMaintainVO.getUpdateStartTime() );
				}
				if ( equipmentMaintainVO.getUpdateEndTime() != null ) {
					strsql.append(" and a.updateTime <= ? ");
					super.addTimestampForField(equipmentMaintainVO.getUpdateEndTime() );
				}
			}
		}else if( QUERY_FROM_EQUIPMENTMAINTAIN_ALL == _operatorType ){

			strsql.append("SELECT a.maintainID , a.equipmentID , b.roomID ,a.updateUserID , a.updateTime ,SUM(maintainCost) sumCost,a.description,a.status,COUNT(*) maintainTime, b.equipmentType, b.equipmentNO, b.equipmentIdentifier, c.meetingroomName ");
			strsql.append("FROM z_t_equipment_maintain a  INNER JOIN  z_t_equipment b ON a.equipmentID = b.equipmentID  INNER JOIN  z_t_meetingroom c ON b.roomID = c.meetingroomID   ");
			strsql.append("where 1=1 and b.status != 3 ");
			if (null != equipmentMaintainVO) {
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getMaintainID())) {
					strsql.append(" and a.maintainID= ? ");
					super.addStringForField(equipmentMaintainVO.getMaintainID());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getEquipmentID())) {
					strsql.append(" and a.equipmentID= ? ");
					super.addStringForField(equipmentMaintainVO.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getRoomID())) {
					strsql.append(" and b.roomID= ? ");
					super.addStringForField(equipmentMaintainVO.getRoomID());
				}
				if (Integer.MIN_VALUE != equipmentMaintainVO.getStatus()) {
					strsql.append(" and a.status= ? ");
					super.addIntForField(equipmentMaintainVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getUpdateUserID())) {
					strsql.append(" and a.updateUserID= ? ");
					super.addStringForField(equipmentMaintainVO.getUpdateUserID());
				}
				
				if( Integer.MIN_VALUE != equipmentMaintainVO.getEquipmentVO().getEquipmentType() ){
					strsql.append(" and b.equipmentType= ? ");
					super.addIntForField(equipmentMaintainVO.getEquipmentVO().getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomID())) {
					strsql.append(" and b.roomID= ? ");
					super.addStringForField(equipmentMaintainVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomID());
				}
				if ( !StringUtils.isNullOrBlank(equipmentMaintainVO.getEquipmentVO().getEquipmentIdentifier()) ){
					strsql.append(" and b.equipmentIdentifier = ? ");
					super.addStringForField(equipmentMaintainVO.getEquipmentVO().getEquipmentIdentifier());
				}
				
				if(!StringUtils.isNullOrBlank(equipmentMaintainVO.getSqls())){
				strsql.append(equipmentMaintainVO.getSqls());
				}
                //////////////////////会议室分级分权@author:zhangjy/////////////////////////
				if(equipmentMaintainVO.isLevel()){
					strsql.append(" and c.meetingroomID in("+equipmentMaintainVO.getLsql()+") ");
				}
				//////////////////////////////end//////////////////////////////////////////
			}
			strsql.append("GROUP BY a.equipmentID");
		}else{
			strsql.append("select maintainID,equipmentID,roomID,status,updateUserID,updateTime,maintainCost,description,revision ");
			strsql.append(" from z_t_Equipment_maintain ");
			strsql.append(" where 1=1 ");

			if (QUERY_FROM_EQUIPMENTMAINTAIN == _operatorType) {
				if (null != equipmentMaintainVO) {
					if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getMaintainID())) {
						strsql.append(" and maintainID= ? ");
						super.addStringForField(equipmentMaintainVO.getMaintainID());
					}
					if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getEquipmentID())) {
						strsql.append(" and equipmentID= ? ");
						super.addStringForField(equipmentMaintainVO.getEquipmentID());
					}
					if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getRoomID())) {
						strsql.append(" and roomID= ? ");
						super.addStringForField(equipmentMaintainVO.getRoomID());
					}
					if (Integer.MIN_VALUE != equipmentMaintainVO.getStatus()) {
						strsql.append(" and status= ? ");
						super.addIntForField(equipmentMaintainVO.getStatus());
					}
					if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getUpdateUserID())) {
						strsql.append(" and updateUserID= ? ");
						super.addStringForField(equipmentMaintainVO.getUpdateUserID());
					}
					if (Integer.MIN_VALUE != equipmentMaintainVO.getMaintainCost()) {
						strsql.append(" and maintainCost= ? ");
						super.addIntForField(equipmentMaintainVO.getMaintainCost());
					}
					if (!StringUtils.isNullOrBlank(equipmentMaintainVO.getDescription())) {
						strsql.append(" and description= ? ");
						super.addStringForField(equipmentMaintainVO.getDescription());
					}
					if (Long.MIN_VALUE != equipmentMaintainVO.getRevision()) {
						strsql.append(" and revision= ? ");
						super.addLongForField(equipmentMaintainVO.getRevision());
					}
					
				}
			} else if (QUERY_FROM_EQUIPMENTMAINTAIN_BY_IDS == _operatorType) {
				strsql.append(" and maintainID in (?) ");
				super.addStringForField(ids);
			}
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
		if( QUERY_FROM_EQUIPMENTMAINTAIN_ALL == _operatorType ){
			
			equipmentMaintainVO = new EquipmentMaintainVO();
			equipmentMaintainVO.setMaintainID(rs.getString("a.maintainID"));
			equipmentMaintainVO.setEquipmentID(rs.getString("a.equipmentID"));
			equipmentMaintainVO.setRoomID(rs.getString("b.roomID"));
			equipmentMaintainVO.setUpdateUserID(rs.getString("a.updateUserID"));
			equipmentMaintainVO.setUpdateTime(rs.getTimestamp("a.updateTime"));
			equipmentMaintainVO.setSumCost(rs.getInt("sumCost"));
			equipmentMaintainVO.setDescription(rs.getString("a.description"));
			equipmentMaintainVO.setStatus(rs.getInt("a.status"));
			equipmentMaintainVO.setMaintainTime(rs.getInt("maintainTime"));
			
			EquipmentVO e = new EquipmentVO();
			e.setEquipmentType(rs.getInt("b.equipmentType"));
			e.setEquipmentNO(rs.getString("b.equipmentNO"));
			e.setEquipmentIdentifier(rs.getString("b.equipmentIdentifier"));
			
			
			
			MeetingRoomVO mr = new MeetingRoomVO();
			mr.setMeetingRoomID(rs.getString("b.roomID"));
			mr.setMeetingRoomName(rs.getString("c.meetingroomName"));
			
			e.setMeetingRoomVO(mr);
			equipmentMaintainVO.setEquipmentVO(e);
			
			listEquipmentMaintain.add(equipmentMaintainVO);
			
			
		}else if( QUERY_FROM_EQUIPMENTMAINTAIN_JOIN_EQUIPMENT == _operatorType ){
			
			equipmentMaintainVO = new EquipmentMaintainVO();
			equipmentMaintainVO.setMaintainID(rs.getString("a.maintainID"));
			equipmentMaintainVO.setEquipmentID(rs.getString("a.equipmentID"));
			equipmentMaintainVO.setRoomID(rs.getString("a.roomID"));
			equipmentMaintainVO.setUpdateUserID(rs.getString("a.updateUserID"));
			equipmentMaintainVO.setUpdateTime(rs.getTimestamp("a.updateTime"));
			equipmentMaintainVO.setMaintainCost(rs.getInt("a.maintainCost"));
			equipmentMaintainVO.setDescription(rs.getString("a.description"));
			equipmentMaintainVO.setStatus(rs.getInt("a.status"));
			
			EquipmentVO e = new EquipmentVO();
			e.setEquipmentType(rs.getInt("b.equipmentType"));
			e.setEquipmentNO(rs.getString("b.equipmentNO"));
			e.setEquipmentIdentifier(rs.getString("b.equipmentIdentifier"));
			
			
			
			MeetingRoomVO mr = new MeetingRoomVO();
			mr.setMeetingRoomID(rs.getString("a.roomID"));
			mr.setMeetingRoomName(rs.getString("c.meetingroomName"));
			
			e.setMeetingRoomVO(mr);
			equipmentMaintainVO.setEquipmentVO(e);
			
			listEquipmentMaintain.add(equipmentMaintainVO);
			
			
		}else{
			equipmentMaintainVO = new EquipmentMaintainVO();
			equipmentMaintainVO.setMaintainID(rs.getString("maintainID"));
			equipmentMaintainVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentMaintainVO.setRoomID(rs.getString("roomID"));
			equipmentMaintainVO.setStatus(rs.getInt("status"));
			equipmentMaintainVO.setUpdateUserID(rs.getString("updateUserID"));
			equipmentMaintainVO.setUpdateTime(rs.getTimestamp("updateTime"));
			equipmentMaintainVO.setMaintainCost(rs.getInt("maintainCost"));
			equipmentMaintainVO.setDescription(rs.getString("description"));
			equipmentMaintainVO.setRevision(rs.getLong("revision"));
			listEquipmentMaintain.add(equipmentMaintainVO);
		}
		
	}

	public ArrayList<EquipmentMaintainVO> getEquipmentMaintainList() {
		return listEquipmentMaintain;
	}

	public EquipmentMaintainVO getEquipmentMaintainVO() {
		return equipmentMaintainVO;
	}

}
