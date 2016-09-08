package com.zzst.dao.meeting.equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.AddressEnu;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: Equipment MQB
 * 
 * @date Wed Nov 30 10:22:48 CST 2011
 * @author ryan
 */
public class EquipmentMQB extends MasterQueryObject {

	static Logger logger = CbfLogger.getLogger(EquipmentMQB.class.getName());

	public static int QUERY_FROM_EQUIPMENT = 1;
	public static int QUERY_FROM_EQUIPMENT_BY_IDS = 2;
	public static int QUERY_IP=3;
	public static int QUERY_BY_MEETINGROOM_IDS=4;
	public static int QUERY_NOTICE = 5;
	public static int QUERY_NOTICE_BY_IDS = 6;
	public static final int QUERY_EQUIPMENTS = 7;
	public static int QUERY_FROM_EQUIPMENT_SCRAP = 8;//报废的设备查询。
	
	public static int QUERY_FROM_EQUIPMENT_ONLY = 9;
	public static int QUERY_FROM_EQUIPMENT_BY_ID = 10;
	public static int QUERY_FROM_EQUIPMENT_ADDRESS_ROOM	= 11;
	
	private EquipmentVO equipmentVO;
	private ArrayList<EquipmentVO> listEquipment = new ArrayList<EquipmentVO>();

	private int _operatorType = -1;
	private String ids = "";

	public EquipmentMQB(int operatorType, EquipmentVO equipmentVO) {
		_operatorType = operatorType;
		this.equipmentVO = equipmentVO;
		makeSql();
	}

	public EquipmentMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if (QUERY_FROM_EQUIPMENT_ADDRESS_ROOM == _operatorType) {//add by zhangdq on 20140314
			strsql.append("select eq.equipmentID,eq.equipmentName,eq.equipmentType,eq.equipmentModel,eq.status,eq.ip,eq.port,eq.equipmentNO,eq.createDate,eq.description,eq.revision,eq.adminID,eq.roomID as equipmentRoomID,eq.mac,eq.serialNumber,eq.equipmentIdentifier,eq.maintenanceStartTime,eq.maintenanceEndTime ");
			strsql.append(" ,mr.meetingroomID, mr.meetingroomName,mr.meetingroomType,mr.capacity ,mr.status as roomStatus,mr.adminID as roomAdminID,mr.departmentID,mr.addressID as roomAddressID,mr.roomPCA ");
			strsql.append(" ,ad.addressID,ad.name,ad.parentID,ad.status as addressStatus,ad.leaf ");
			strsql.append(" ,eter.equipmentMCUID ");
			strsql.append(" ,emcu.AllResourceNumber,emcu.useResourceNumber,emcu.parentID as mcuParentID ");
			strsql.append(" from z_t_equipment eq ");
			strsql.append(" left join z_t_meetingroom mr on eq.roomID = mr.meetingroomID ");
			strsql.append(" left join z_t_address ad on ad.addressID = mr.addressID ");
			strsql.append(" left join z_t_equipment_terminal eter on eq.equipmentID = eter.equipmentID ");
			strsql.append(" left join z_t_equipment_mcu emcu on eq.equipmentID = emcu.equipmentID ");
			
			strsql.append(" where 1=1 and eq.status ="+EquipmentEnum.STATUS_VALID+" and ( eq.equipmentType = "+EquipmentEnum.TYPE_ID_MCU +" or eq.equipmentType = "+EquipmentEnum.TYPE_ID_TERMINAL+" ) ");
			strsql.append(" and mr.status = "+MeetingRoomEnum.ROOM_STATUS_VALID);
			strsql.append(" and ad.status = "+AddressEnu.VALID);
			if (null != equipmentVO) {
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentID())) {
					strsql.append(" and eq.equipmentID= ? ");
					super.addStringForField(equipmentVO.getEquipmentID());
				}
				
				if (!StringUtils.isNullOrBlank(equipmentVO.getIp())) {
					strsql.append(" and eq.ip= ? ");
					super.addStringForField(equipmentVO.getIp());
				}
				
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentNO())) {
					strsql.append(" and eq.equipmentNO= ? ");
					super.addStringForField(equipmentVO.getEquipmentNO());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getMeetingRoomVO().getMeetingRoomID())) {
					strsql.append(" and eq.roomID= ? ");
					super.addStringForField(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				}
				
				if (!StringUtils.isNullOrBlank(equipmentVO.getMeetingRoomVO().getAddressVO().getAddressID())) {
					strsql.append(" and eq.addressID= ? ");
					super.addStringForField(equipmentVO.getMeetingRoomVO().getAddressVO().getAddressID());
				}
				
				if (!StringUtils.isNullOrBlank(equipmentVO.getUserVO().getUserID())) {
					strsql.append(" and eq.adminID= ? ");
					super.addStringForField(equipmentVO.getUserVO().getUserID());
				}
				if(equipmentVO.isLevel()){
					strsql.append(equipmentVO.getLsql());
				}
			}
			strsql.append(" order by ad.parentID desc");
		}else if (QUERY_FROM_EQUIPMENT == _operatorType) {
			strsql.append("select z_t_equipment.loginName,z_t_equipment.password,z_t_equipment.equroomID,z_t_equipment.equipmentID,z_t_equipment.equipmentName,z_t_equipment.equipmentType,z_t_equipment.equipmentModel,z_t_equipment.status,z_t_equipment.ip,z_t_equipment.port,z_t_equipment.equipmentNO,z_t_equipment.createDate,z_t_equipment.description,z_t_equipment.revision,z_t_equipment.adminID,z_t_equipment.roomID,z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName, z_t_user.userID,z_t_user.fullName,z_t_user.email,z_t_user.mobile ");
			strsql.append(",z_t_equipment.mac,z_t_equipment.serialNumber,z_t_equipment.equipmentIdentifier,z_t_equipment.maintenanceStartTime,z_t_equipment.maintenanceEndTime,z_t_meetingroom.addressID");
			strsql.append(" from( z_t_equipment inner join z_t_user on z_t_equipment.adminID=z_t_user.userID)inner join z_t_meetingroom on z_t_equipment.roomID=z_t_meetingroom.meetingroomID  ");
			strsql.append(" where 1=1 and z_t_equipment.status !="+EquipmentEnum.STATUS_INVALID+" and z_t_equipment.status !="+EquipmentEnum.STATUS_USELESS+" and z_t_meetingroom.status != "+MeetingRoomEnum.ROOM_STATUS_INVALID+" and z_t_user.status != "+UserEnum.INVALID);
			/**modify by xiongshun ~~~~and z_t_meetingroom.`status`=0
			 * 查询中控列表，需要剔除~会议室状态无效的中控
			 */
			if (null != equipmentVO) {
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(equipmentVO.getEquipmentID());
				}
				if (Integer.MIN_VALUE != equipmentVO.getEquipmentType()&& equipmentVO.getEquipmentType()!=-1) {
					strsql.append(" and equipmentType= ? ");
					super.addIntForField(equipmentVO.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentName())) {
					strsql.append(" and equipmentName="+equipmentVO.getEquipmentName());
//					super.addStringForField(equipmentVO.getEquipmentName());
//					strsql.append(" and equipmentName like ('%"+equipmentVO.getEquipmentName()+"%') ");
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentModel())) {
					strsql.append(" and equipmentModel= ? ");
					super.addStringForField(equipmentVO.getEquipmentModel());
				}
				if (Integer.MIN_VALUE != equipmentVO.getStatus()) {
				   strsql.append(" and z_t_equipment.status = ? ");
					super.addIntForField(equipmentVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getIp())) {
					strsql.append(" and ip= ? ");
					super.addStringForField(equipmentVO.getIp());
				}
				if (Integer.MIN_VALUE != equipmentVO.getPort()) {
					strsql.append(" and port= ? ");
					super.addIntForField(equipmentVO.getPort());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentNO())) {
					strsql.append(" and equipmentNO= ? ");
					super.addStringForField(equipmentVO.getEquipmentNO());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getMeetingRoomVO().getMeetingRoomID())) {
					strsql.append(" and z_t_equipment.roomID= ? ");
					super.addStringForField(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				}
				
				if (!StringUtils.isNullOrBlank(equipmentVO.getMeetingRoomVO().getAddressVO().getAddressID())) {
					strsql.append(" and z_t_meetingroom.addressID= ? ");
					super.addStringForField(equipmentVO.getMeetingRoomVO().getAddressVO().getAddressID());
				}
				
				if (!StringUtils.isNullOrBlank(equipmentVO.getUserVO().getUserID())) {
					strsql.append(" and z_t_equipment.adminID= ? ");
					super.addStringForField(equipmentVO.getUserVO().getUserID());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(equipmentVO.getDescription());
				}
				if (Long.MIN_VALUE != equipmentVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(equipmentVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getMac())) {
					strsql.append(" and mac= ? ");
					super.addStringForField(equipmentVO.getMac());
				}
				if ( equipmentVO.getMaintenanceStartTime() !=null ) {
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
						strsql.append(" and maintenanceStartTime >= "+UtilDAO.oracleToDate(equipmentVO.getMaintenanceStartTime()));
					}else{
						strsql.append(" and maintenanceStartTime >= '"+equipmentVO.getMaintenanceStartTime()+"'");
						//super.addTimestampForField(equipmentVO.getMaintenanceStartTime());
					}
				}
				if ( equipmentVO.getMaintenanceEndTime() !=null ) {
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
						strsql.append(" and maintenanceEndTime <= "+UtilDAO.oracleToDate(equipmentVO.getMaintenanceEndTime()));
					}else{
						strsql.append(" and maintenanceEndTime <= '"+equipmentVO.getMaintenanceEndTime()+"'");
						//super.addTimestampForField(equipmentVO.getMaintenanceStartTime());
					}
					
				}
				if( !StringUtils.isNullOrBlank(equipmentVO.getSerialNumber())){
					strsql.append(" and serialNumber = ? ");
					super.addStringForField(equipmentVO.getSerialNumber());
				}
				
				if(equipmentVO.isLevel()){
					strsql.append(equipmentVO.getLsql());
				}
			}
			strsql.append(" order by z_t_equipment.createDate desc");
		}else if (QUERY_FROM_EQUIPMENT_BY_IDS == _operatorType) {
			strsql.append("select z_t_equipment.equipmentID,z_t_equipment.equipmentName,z_t_equipment.equipmentType,z_t_equipment.equipmentModel,z_t_equipment.status,z_t_equipment.ip,z_t_equipment.port,z_t_equipment.equipmentNO,z_t_equipment.createDate,z_t_equipment.description,z_t_equipment.revision,z_t_equipment.adminID,z_t_equipment.roomID,z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName, z_t_user.userID,z_t_user.fullName ");
			strsql.append(",z_t_equipment.mac,z_t_equipment.serialNumber,z_t_equipment.equipmentIdentifier,z_t_equipment.maintenanceStartTime,z_t_equipment.maintenanceEndTime,z_t_equipment.loginName,z_t_equipment.password,z_t_equipment.equroomID");
			strsql.append(" from( z_t_equipment inner join z_t_user on z_t_equipment.adminID=z_t_user.userID)inner join z_t_meetingroom on z_t_equipment.roomID=z_t_meetingroom.meetingroomID  ");
			strsql.append(" where 1=1 ");
			strsql.append(" and equipmentID in (?) ");
			super.addStringForField(ids);
		}else if(QUERY_IP==_operatorType){
			strsql.append("select *  from z_t_Equipment");
			strsql.append(" where 1=1");
			strsql.append(" and  ip  in ('"+ids+"') and status!=3");
//			super.addStringForField(ids);
		}else if(QUERY_BY_MEETINGROOM_IDS == _operatorType){
			strsql.append("select z_t_equipment.equipmentID,z_t_equipment.equipmentName,z_t_equipment.equipmentType,z_t_equipment.equipmentModel,z_t_equipment.status,z_t_equipment.ip,z_t_equipment.port,z_t_equipment.equipmentNO,z_t_equipment.createDate,z_t_equipment.description,z_t_equipment.revision,z_t_equipment.adminID,z_t_equipment.roomID");
			strsql.append(",z_t_equipment.mac");
//			strsql.append(" from( z_t_equipment inner join z_t_user on z_t_equipment.adminID=z_t_user.userID)inner join z_t_meetingroom on z_t_equipment.roomID=z_t_meetingroom.meetingroomID  ");
			strsql.append(" from z_t_equipment where 1=1 and z_t_equipment.equipmentType="+EquipmentEnum.TYPE_ID_ENC);
			
			String[] _ids = ids.split(",");
			StringBuffer idsChange = new StringBuffer();
			for (String id : _ids) {
				idsChange.append("'"+id+"',");
			}
			ids = (idsChange.substring(0,idsChange.length()-1)).toString();
			strsql.append(" and roomID in ("+ids+") ");
			
			super.addStringForField(ids);
		}else if(QUERY_NOTICE == _operatorType){
			strsql.append("select eq.equipmentID,eq.equipmentName,eq.equipmentType,eq.equipmentModel,eq.status,eq.ip,eq.port,eq.equipmentNO,eq.createDate,eq.description,eq.revision,eq.adminID,eq.roomID,eq.mac,eq.serialNumber,eq.maintenanceStartTime,eq.maintenanceEndTime,eq.equipmentIdentifier,z_t_user.fullName");
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
				strsql.append(",to_char(wmsys.wm_concat(mr.meetingroomName)) rooms ,to_char(wmsys.wm_concat(mr.meetingroomID)) roomIds");
			}else{
				strsql.append(",group_concat(mr.meetingroomName) rooms ,group_concat(mr.meetingroomID) roomIds");
			}
			
			strsql.append(" from z_t_equipment  eq inner join z_t_meetingroom_equipment me on   eq.equipmentID = me.equipmentId inner join z_t_meetingroom mr on me.roomId = mr.meetingroomID left join z_t_user on eq.adminID=z_t_user.userID where 1=1");
			if(!StringUtils.isNullOrBlank(equipmentVO.getEquipmentID())){
				strsql.append(" and me.equipmentId = ?");
				super.addStringForField(equipmentVO.getEquipmentID());
			}
			if(Integer.MIN_VALUE != equipmentVO.getEquipmentType()){
				strsql.append(" and eq.equipmentType = ?");
				super.addIntForField(equipmentVO.getEquipmentType());
			}
			if(!StringUtils.isNullOrBlank(equipmentVO.getMeetingRoomVO().getMeetingRoomID())){
				strsql.append(" and me.roomId = ?");
				super.addStringForField(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			}
			strsql.append(" group by eq.equipmentID,eq.equipmentName,eq.equipmentType,eq.equipmentModel,eq.status,eq.ip,eq.port,eq.equipmentNO,eq.createDate,eq.description,eq.revision,eq.adminID,eq.roomID,eq.mac,eq.serialNumber,eq.maintenanceStartTime,eq.maintenanceEndTime,eq.equipmentIdentifier,z_t_user.fullName");
			
		}else if(QUERY_NOTICE_BY_IDS == _operatorType){
			strsql.append("select eq.equipmentID,eq.equipmentName,eq.equipmentType,eq.equipmentModel,eq.status,eq.ip,eq.port,eq.equipmentNO,eq.createDate,eq.description,eq.revision,eq.adminID,eq.roomID,eq.mac");
			strsql.append(" from z_t_equipment eq  inner join z_t_meetingroom_equipment me on eq.equipmentID = me.equipmentId");
			strsql.append(" where instr('"+ids+"',me.roomId)>0 group by eq.equipmentID,eq.equipmentName,eq.equipmentType,eq.equipmentModel,eq.status,eq.ip,eq.port,eq.equipmentNO,eq.createDate,eq.description,eq.revision,eq.adminID,eq.roomID,eq.mac ");
		}else if(QUERY_EQUIPMENTS == _operatorType){
			strsql.append("select eq.equipmentID,eq.equipmentName,eq.equipmentType,eq.equipmentModel,eq.status,eq.ip,eq.port,eq.equipmentNO,eq.createDate,eq.description,eq.revision,eq.adminID,eq.roomID,eq.mac,eq.serialNumber,eq.maintenanceStartTime,eq.maintenanceEndTime,eq.equipmentIdentifier,z_t_user.fullName");
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
				strsql.append(",to_char(wmsys.wm_concat(mr.meetingroomName)) rooms ,to_char(wmsys.wm_concat(mr.meetingroomID)) roomIds");
			}else{
				strsql.append(",group_concat(mr.meetingroomName) rooms ,group_concat(mr.meetingroomID) roomIds");
			}
			
			strsql.append(" from z_t_equipment  eq inner join z_t_meetingroom_equipment me on   eq.equipmentID = me.equipmentId inner join z_t_meetingroom mr on me.roomId = mr.meetingroomID left join z_t_user on eq.adminID=z_t_user.userID where 1=1 and eq.status !="+EquipmentEnum.STATUS_INVALID+" and eq.status !="+EquipmentEnum.STATUS_USELESS);
			if(!StringUtils.isNullOrBlank(equipmentVO.getEquipmentID())){
				strsql.append(" and me.equipmentId = ?");
				super.addStringForField(equipmentVO.getEquipmentID());
			}
			if(Integer.MIN_VALUE != equipmentVO.getEquipmentType()){
				strsql.append(" and eq.equipmentType = ?");
				super.addIntForField(equipmentVO.getEquipmentType());
			}
			if(!StringUtils.isNullOrBlank(equipmentVO.getMeetingRoomVO().getMeetingRoomID())){
				strsql.append(" and me.roomId = ?");
				super.addStringForField(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			}//所属会议室
			
			if(equipmentVO.isLevel()){
				strsql.append(equipmentVO.getLsql());
			} 
			strsql.append(" group by eq.equipmentID,eq.equipmentName,eq.equipmentType,eq.equipmentModel,eq.status,eq.ip,eq.port,eq.equipmentNO,eq.createDate,eq.description,eq.revision,eq.adminID,eq.roomID,eq.mac,eq.serialNumber,eq.maintenanceStartTime,eq.maintenanceEndTime,eq.equipmentIdentifier,z_t_user.fullName order by eq.equipmentNO");
			
		}else if (QUERY_FROM_EQUIPMENT_SCRAP == _operatorType) {
			strsql.append("select z_t_equipment.equipmentID,z_t_equipment.equipmentName,z_t_equipment.equipmentType,z_t_equipment.equipmentModel,z_t_equipment.status,z_t_equipment.ip,z_t_equipment.port,z_t_equipment.equipmentNO,z_t_equipment.createDate,z_t_equipment.description,z_t_equipment.revision,z_t_equipment.adminID,z_t_equipment.roomID,z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName, z_t_user.userID,z_t_user.fullName,z_t_user.email,z_t_user.mobile ");
			strsql.append(",z_t_equipment.mac,z_t_equipment.serialNumber,z_t_equipment.equipmentIdentifier,z_t_equipment.maintenanceStartTime,z_t_equipment.maintenanceEndTime");
			strsql.append(" from( z_t_equipment inner join z_t_user on z_t_equipment.adminID=z_t_user.userID)inner join z_t_meetingroom on z_t_equipment.roomID=z_t_meetingroom.meetingroomID  ");
			strsql.append(" where 1=1 and z_t_equipment.status !="+EquipmentEnum.STATUS_INVALID+" and z_t_meetingroom.status != "+MeetingRoomEnum.ROOM_STATUS_INVALID+" and z_t_user.status != "+UserEnum.INVALID);
			/**modify by xiongshun ~~~~and z_t_meetingroom.`status`=0
			 * 查询中控列表，需要剔除~会议室状态无效的中控
			 */
			if (null != equipmentVO) {
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentID())) {
					strsql.append(" and equipmentID= ? ");
					super.addStringForField(equipmentVO.getEquipmentID());
				}
				if (Integer.MIN_VALUE != equipmentVO.getEquipmentType()&& equipmentVO.getEquipmentType()!=-1) {
					strsql.append(" and equipmentType= ? ");
					super.addIntForField(equipmentVO.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentName())) {
					strsql.append(" and equipmentName="+equipmentVO.getEquipmentName());
//					super.addStringForField(equipmentVO.getEquipmentName());
//					strsql.append(" and equipmentName like ('%"+equipmentVO.getEquipmentName()+"%') ");
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentModel())) {
					strsql.append(" and equipmentModel= ? ");
					super.addStringForField(equipmentVO.getEquipmentModel());
				}
				if (Integer.MIN_VALUE != equipmentVO.getStatus()) {
				   strsql.append(" and z_t_equipment.status = ? ");
					super.addIntForField(equipmentVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getIp())) {
					strsql.append(" and ip= ? ");
					super.addStringForField(equipmentVO.getIp());
				}
				if (Integer.MIN_VALUE != equipmentVO.getPort()) {
					strsql.append(" and port= ? ");
					super.addIntForField(equipmentVO.getPort());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentNO())) {
					strsql.append(" and equipmentNO= ? ");
					super.addStringForField(equipmentVO.getEquipmentNO());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getMeetingRoomVO().getMeetingRoomID())) {
					strsql.append(" and z_t_equipment.roomID= ? ");
					super.addStringForField(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getUserVO().getUserID())) {
					strsql.append(" and z_t_equipment.adminID= ? ");
					super.addStringForField(equipmentVO.getUserVO().getUserID());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(equipmentVO.getDescription());
				}
				if (Long.MIN_VALUE != equipmentVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(equipmentVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getMac())) {
					strsql.append(" and mac= ? ");
					super.addStringForField(equipmentVO.getMac());
				}
				if ( equipmentVO.getMaintenanceStartTime() !=null ) {
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
						strsql.append(" and maintenanceStartTime >= "+UtilDAO.oracleToDate(equipmentVO.getMaintenanceStartTime()));
					}else{
						strsql.append(" and maintenanceStartTime >= '"+equipmentVO.getMaintenanceStartTime()+"'");
						//super.addTimestampForField(equipmentVO.getMaintenanceStartTime());
					}
				}
				if ( equipmentVO.getMaintenanceEndTime() !=null ) {
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
						strsql.append(" and maintenanceEndTime <= "+UtilDAO.oracleToDate(equipmentVO.getMaintenanceEndTime()));
					}else{
						strsql.append(" and maintenanceEndTime <= '"+equipmentVO.getMaintenanceEndTime()+"'");
						//super.addTimestampForField(equipmentVO.getMaintenanceStartTime());
					}
					
				}
				if( !StringUtils.isNullOrBlank(equipmentVO.getSerialNumber())){
					strsql.append(" and serialNumber = ? ");
					super.addStringForField(equipmentVO.getSerialNumber());
				}
				
				if(equipmentVO.isLevel()){
					strsql.append(equipmentVO.getLsql());
				}
			}
			strsql.append(" order by z_t_equipment.createDate desc");
		}else if(QUERY_FROM_EQUIPMENT_ONLY == _operatorType){
			strsql.append("select z_t_equipment.equipmentID,z_t_equipment.equipmentName,z_t_equipment.equipmentType,z_t_equipment.equipmentModel,z_t_equipment.status,z_t_equipment.ip,z_t_equipment.port,z_t_equipment.equipmentNO,z_t_equipment.createDate,z_t_equipment.description,z_t_equipment.revision,z_t_equipment.adminID,z_t_equipment.roomID");
			strsql.append(",z_t_equipment.mac");
			strsql.append(" from z_t_equipment where 1=1 ");
			if(null != equipmentVO){
				if (Integer.MIN_VALUE != equipmentVO.getEquipmentType()&& equipmentVO.getEquipmentType()!=-1) {
					strsql.append(" and equipmentType= ? ");
					super.addIntForField(equipmentVO.getEquipmentType());
				}
				if (!StringUtils.isNullOrBlank(equipmentVO.getEquipmentName())) {
					strsql.append(" and equipmentName= ? ");
					super.addStringForField(equipmentVO.getEquipmentName());
				}
			}
		}else if (QUERY_FROM_EQUIPMENT_BY_ID == _operatorType) {
			strsql.append("select z_t_equipment.equipmentID,z_t_equipment.equipmentName,z_t_equipment.equipmentType,z_t_equipment.equipmentModel,z_t_equipment.status,z_t_equipment.ip,z_t_equipment.port,z_t_equipment.equipmentNO,z_t_equipment.createDate,z_t_equipment.description,z_t_equipment.revision,z_t_equipment.adminID,z_t_equipment.roomID ");
			strsql.append(",z_t_equipment.mac,z_t_equipment.serialNumber,z_t_equipment.equipmentIdentifier,z_t_equipment.maintenanceStartTime,z_t_equipment.maintenanceEndTime");
			strsql.append(" from z_t_equipment  ");
			strsql.append(" where 1=1 ");
			strsql.append(" and equipmentID in (?) ");
			super.addStringForField(ids);
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
		if(QUERY_FROM_EQUIPMENT_ADDRESS_ROOM == _operatorType){
			equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
			equipmentVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
			equipmentVO.setStatus(rs.getInt("status"));
			equipmentVO.setIp(rs.getString("ip"));
			equipmentVO.setPort(rs.getInt("port"));
			equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
			equipmentVO.setDescription(rs.getString("description"));
			equipmentVO.setRevision(rs.getLong("revision"));
			equipmentVO.setMac(rs.getString("mac"));
			equipmentVO.setSerialNumber(rs.getString("serialNumber"));
			equipmentVO.setEquipmentIdentifier(rs.getString("equipmentIdentifier"));
			equipmentVO.setMaintenanceStartTime(rs.getTimestamp("maintenanceStartTime"));
			equipmentVO.setMaintenanceEndTime(rs.getTimestamp("maintenanceEndTime"));
			
			equipmentVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("equipmentRoomID"));
			equipmentVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingroomName"));
			equipmentVO.getMeetingRoomVO().getAddressVO().setAddressID(rs.getString("roomAddressID"));
			equipmentVO.getMeetingRoomVO().setMeetingRoomType(rs.getInt("meetingroomType"));
			equipmentVO.getMeetingRoomVO().setCapacity(rs.getInt("capacity"));
			equipmentVO.getMeetingRoomVO().setStatus(rs.getInt("roomStatus"));
			equipmentVO.getMeetingRoomVO().getUserVO().setUserID(rs.getString("roomAdminID"));
			equipmentVO.getMeetingRoomVO().getDepartmentVO().setId(rs.getString("departmentID"));
			equipmentVO.getMeetingRoomVO().setRoomPCA(rs.getString("roomPCA"));
			
			equipmentVO.getAddressVO().setAddressID(rs.getString("roomAddressID"));
			equipmentVO.getAddressVO().setParentID(rs.getString("parentID"));
			equipmentVO.getAddressVO().setName(rs.getString("name"));
			equipmentVO.getAddressVO().setStatus(rs.getInt("addressStatus"));
			equipmentVO.getAddressVO().setLeaf(rs.getInt("leaf"));
			
			equipmentVO.getUserVO().setUserID(rs.getString("adminID"));
			if(EquipmentEnum.TYPE_ID_TERMINAL==rs.getInt("equipmentType")){
				equipmentVO.setCascadeEquipmentID(rs.getString("equipmentMCUID"));
			}
			
			if(EquipmentEnum.TYPE_ID_MCU==rs.getInt("equipmentType")){
				equipmentVO.setCascadeEquipmentID(rs.getString("mcuParentID"));
				equipmentVO.setAllResourceNumber(rs.getInt("allResourceNumber"));
				equipmentVO.setUseResourceNumber(rs.getInt("useResourceNumber"));
			}
			
			listEquipment.add(equipmentVO);
		}else if(QUERY_BY_MEETINGROOM_IDS == _operatorType){
			equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
			equipmentVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
			equipmentVO.setStatus(rs.getInt("status"));
			equipmentVO.setIp(rs.getString("ip"));
			equipmentVO.setPort(rs.getInt("port"));
			equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
			equipmentVO.setDescription(rs.getString("description"));
			equipmentVO.setRevision(rs.getLong("revision"));
			equipmentVO.setMac(rs.getString("mac"));
			listEquipment.add(equipmentVO);
		}else if(QUERY_FROM_EQUIPMENT_ONLY == _operatorType){
			equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
			equipmentVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
			equipmentVO.setStatus(rs.getInt("status"));
			equipmentVO.setIp(rs.getString("ip"));
			equipmentVO.setPort(rs.getInt("port"));
			equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
			equipmentVO.setDescription(rs.getString("description"));
			equipmentVO.setRevision(rs.getLong("revision"));
			equipmentVO.setMac(rs.getString("mac"));
			listEquipment.add(equipmentVO);
		}
		else if(QUERY_NOTICE == _operatorType){
				equipmentVO = new EquipmentVO();
				equipmentVO.setEquipmentID(rs.getString("equipmentID"));
				equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
				equipmentVO.setEquipmentName(rs.getString("equipmentName"));
				equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
				equipmentVO.setStatus(rs.getInt("status"));
				equipmentVO.setIp(rs.getString("ip"));
				equipmentVO.setPort(rs.getInt("port"));
				equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
				equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
				equipmentVO.setDescription(rs.getString("description"));
				equipmentVO.setRevision(rs.getLong("revision"));
				equipmentVO.setMac(rs.getString("mac"));
				equipmentVO.setSerialNumber(rs.getString("serialNumber"));
				equipmentVO.setMaintenanceStartTime(rs.getTimestamp("maintenanceStartTime"));
				equipmentVO.setMaintenanceEndTime(rs.getTimestamp("maintenanceEndTime"));
				equipmentVO.setEquipmentIdentifier(rs.getString("equipmentIdentifier"));
				equipmentVO.getUserVO().setUserID(rs.getString("adminID"));
				equipmentVO.getUserVO().setName(rs.getString("fullName"));
				equipmentVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("rooms"));
				equipmentVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("roomIds"));
				listEquipment.add(equipmentVO);
		}else if(QUERY_NOTICE_BY_IDS == _operatorType){
				equipmentVO = new EquipmentVO();
				equipmentVO.setEquipmentID(rs.getString("equipmentID"));
				equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
				equipmentVO.setEquipmentName(rs.getString("equipmentName"));
				equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
				equipmentVO.setStatus(rs.getInt("status"));
				equipmentVO.setIp(rs.getString("ip"));
				equipmentVO.setPort(rs.getInt("port"));
				equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
				equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
				equipmentVO.setDescription(rs.getString("description"));
				equipmentVO.setRevision(rs.getLong("revision"));
				equipmentVO.setMac(rs.getString("mac"));
				listEquipment.add(equipmentVO);
		}else if(QUERY_IP == _operatorType){
				equipmentVO = new EquipmentVO();
				equipmentVO.setEquipmentID(rs.getString("equipmentID"));
				equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
				equipmentVO.setEquipmentName(rs.getString("equipmentName"));
				equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
				equipmentVO.setStatus(rs.getInt("status"));
				equipmentVO.setIp(rs.getString("ip"));
				equipmentVO.setPort(rs.getInt("port"));
				equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
				equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
				equipmentVO.setDescription(rs.getString("description"));
				equipmentVO.setRevision(rs.getLong("revision"));
				equipmentVO.setMac(rs.getString("mac"));
				listEquipment.add(equipmentVO);
		}else if(QUERY_EQUIPMENTS == _operatorType){
			equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
			equipmentVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
			equipmentVO.setStatus(rs.getInt("status"));
			equipmentVO.setIp(rs.getString("ip"));
			equipmentVO.setPort(rs.getInt("port"));
			equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
			equipmentVO.setDescription(rs.getString("description"));
			equipmentVO.setRevision(rs.getLong("revision"));
			equipmentVO.setMac(rs.getString("mac"));
			equipmentVO.setSerialNumber(rs.getString("serialNumber"));
			equipmentVO.setMaintenanceStartTime(rs.getTimestamp("maintenanceStartTime"));
			equipmentVO.setMaintenanceEndTime(rs.getTimestamp("maintenanceEndTime"));
			equipmentVO.setEquipmentIdentifier(rs.getString("equipmentIdentifier"));
			equipmentVO.getUserVO().setUserID(rs.getString("adminID"));
			equipmentVO.getUserVO().setName(rs.getString("fullName"));
			equipmentVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("rooms"));
			equipmentVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("roomIds"));
			listEquipment.add(equipmentVO);
		}else if(QUERY_FROM_EQUIPMENT_BY_ID == _operatorType){
			equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
			equipmentVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
			equipmentVO.setStatus(rs.getInt("status"));
			equipmentVO.setIp(rs.getString("ip"));
			equipmentVO.setPort(rs.getInt("port"));
			equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("roomID"));
			equipmentVO.getUserVO().setUserID(rs.getString("adminID"));
			equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
			equipmentVO.setDescription(rs.getString("description"));
			equipmentVO.setRevision(rs.getLong("revision"));
			equipmentVO.setMac(rs.getString("mac"));
			equipmentVO.setSerialNumber(rs.getString("serialNumber"));
			equipmentVO.setEquipmentIdentifier(rs.getString("equipmentIdentifier"));
			equipmentVO.setMaintenanceStartTime(rs.getTimestamp("maintenanceStartTime"));
			equipmentVO.setMaintenanceEndTime(rs.getTimestamp("maintenanceEndTime"));
			listEquipment.add(equipmentVO);
		}else{
				equipmentVO = new EquipmentVO();
				equipmentVO.setEquipmentID(rs.getString("equipmentID"));
				equipmentVO.setEquipmentType(rs.getInt("equipmentType"));
				equipmentVO.setEquipmentName(rs.getString("equipmentName"));
				equipmentVO.setEquipmentModel(rs.getString("equipmentModel"));
				equipmentVO.setStatus(rs.getInt("status"));
				equipmentVO.setIp(rs.getString("ip"));
				equipmentVO.setPort(rs.getInt("port"));
				equipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
				equipmentVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("meetingroomID"));
				equipmentVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingroomName"));
				equipmentVO.getUserVO().setUserID(rs.getString("userID"));
				equipmentVO.getUserVO().setName(rs.getString("fullName"));
				//add on 2013-5-23
				if(QUERY_FROM_EQUIPMENT == _operatorType){
					equipmentVO.getMeetingRoomVO().getAddressVO().setAddressID(rs.getString("addressID"));
					equipmentVO.getUserVO().setEmail(rs.getString("email"));
					equipmentVO.getUserVO().setMobile(rs.getString("mobile"));
				}
			
				if(QUERY_FROM_EQUIPMENT == _operatorType || QUERY_FROM_EQUIPMENT_BY_IDS == _operatorType){
					equipmentVO.setLoginName(rs.getString("loginName"));
					equipmentVO.setPassword(rs.getString("password"));
					equipmentVO.setEquroomID(rs.getString("equroomID"));
				}
			
				equipmentVO.setCreateDate(rs.getTimestamp("createDate"));
				equipmentVO.setDescription(rs.getString("description"));
				equipmentVO.setRevision(rs.getLong("revision"));
				equipmentVO.setMac(rs.getString("mac"));
				//add on 2013-5-7
				equipmentVO.setSerialNumber(rs.getString("serialNumber"));
				equipmentVO.setEquipmentIdentifier(rs.getString("equipmentIdentifier"));
				equipmentVO.setMaintenanceStartTime(rs.getTimestamp("maintenanceStartTime"));
				equipmentVO.setMaintenanceEndTime(rs.getTimestamp("maintenanceEndTime"));
				
				listEquipment.add(equipmentVO);
		}
		
	}

	public ArrayList<EquipmentVO> getEquipmentList() {
		return listEquipment;
	}

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

}
