package com.zzst.dao.meeting.equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;

/**
 * class description: EquipmentTerminal MQB
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 * @modify by zhangliang
 */
public class EquipmentTerminalMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentTerminalMQB.class.getName());

	public static int QUERY_FROM_EQUIPMENTTERMINAL = 1;
	public static int QUERY_FROM_EQUIPMENTTERMINAL_BY_IDS = 2;
	public static int QUERY_TERMINAL_BY_ROOMS = 3;
	public static int QUERY_TERMINAL_BY_IPS   = 4;
	public static int QUERY_TERMINAL_BY_MEETINGID   = 5;
	public static int QUERY_TERMINAL_BY_MID   = 6;//MEETINGDETAILID
	

	private EquipmentTerminalVO equipmentTerminalVO;
	private ArrayList<EquipmentTerminalVO> listEquipmentTerminal = new ArrayList<EquipmentTerminalVO>();

	private int _operatorType = -1;
	private String ids = "";
	

	public EquipmentTerminalMQB(int operatorType, EquipmentTerminalVO equipmentTerminalVO) {
		_operatorType = operatorType;
		this.equipmentTerminalVO = equipmentTerminalVO;
		makeSql();
	}

	public EquipmentTerminalMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	private void makeSql() {
		if (QUERY_FROM_EQUIPMENTTERMINAL == _operatorType) {
			StringBuffer strsql = new StringBuffer();
			strsql.append("select a.equipmentID,a.loginName,a.loginPassword,a.createTime,a.pstn,a.speed,a.videoTreaty,a.radioTreaty,a.equipmentMCUID,a.description,a.revision,a.dialingType,a.dialingDirection,a.aliasName,a.maxPesolution,a.aliasType,a.cascadeRole,a.agc,a.ptsNumber,a.isCheck,a.mcuResourse,a.useRole,a.controlParameter ");
			strsql.append(" ,c.meetingroomID");//add by ryan on 2013-04-28
			strsql.append(" ,b.equipmentName,b.equipmentNO,b.ip,b.status,b.serialNumber,c.meetingroomName,d.loginName from z_t_Equipment_Terminal a, z_t_equipment  b, z_t_meetingroom  c, z_t_user d ");
			strsql.append(" where a.equipmentID = b.equipmentID and b.roomID =c.meetingroomID and b.adminID=d.userID and  b.status!="+EquipmentEnum.STATUS_INVALID+" and b.status!="+EquipmentEnum.STATUS_USELESS+" and c.status!="+MeetingRoomEnum.ROOM_STATUS_INVALID);
			
			if (null != equipmentTerminalVO) {
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getEquipmentID())) {
					strsql.append(" and a.equipmentID= ? ");
					super.addStringForField(equipmentTerminalVO.getEquipmentID());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getLoginName())) {
					strsql.append(" and a.loginName= ? ");
					super.addStringForField(equipmentTerminalVO.getLoginName());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getLoginPassword())) {
					strsql.append(" and a.loginPassword= ? ");
					super.addStringForField(equipmentTerminalVO.getLoginPassword());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getPstn())) {
					strsql.append(" and a.pstn= ? ");
					super.addStringForField(equipmentTerminalVO.getPstn());
				}
				
				//add by ryan on 2013-04-28
				if (Integer.MIN_VALUE != equipmentTerminalVO.getStatus()) {
					strsql.append(" and b.status= ? ");
					super.addIntForField(equipmentTerminalVO.getStatus());
				}
				
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getSpeed())) {
					strsql.append(" and a.speed= ? ");
					super.addStringForField(equipmentTerminalVO.getSpeed());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getVideoTreaty())) {
					strsql.append(" and a.videoTreaty= ? ");
					super.addStringForField(equipmentTerminalVO.getVideoTreaty());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getRadioTreaty())) {
					strsql.append(" and a.radioTreaty= ? ");
					super.addStringForField(equipmentTerminalVO.getRadioTreaty());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getEquipmentMCUID())) {
					strsql.append(" and a.equipmentMCUID= ? ");
					super.addStringForField(equipmentTerminalVO.getEquipmentMCUID());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getDescription())) {
					strsql.append(" and a.description= ? ");
					super.addStringForField(equipmentTerminalVO.getDescription());
				}
				if (Long.MIN_VALUE != equipmentTerminalVO.getRevision()) {
					strsql.append(" and a.revision= ? ");
					super.addLongForField(equipmentTerminalVO.getRevision());
				}
				//新增加的字段
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getDialingType())) {
					strsql.append(" and a.dialingType= ? ");
					super.addStringForField(equipmentTerminalVO.getDialingType());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getDialingDirection())) {
					strsql.append(" and a.dialingDirection= ? ");
					super.addStringForField(equipmentTerminalVO.getDialingDirection());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getAliasName())) {
					strsql.append(" and a.aliasName= ? ");
					super.addStringForField(equipmentTerminalVO.getAliasName());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getAliasType())) {
					strsql.append(" and a.aliasType= ? ");
					super.addStringForField(equipmentTerminalVO.getAliasType());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getMaxPesolution())) {
					strsql.append(" and a.maxPesolution= ? ");
					super.addStringForField(equipmentTerminalVO.getMaxPesolution());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getCascadeRole())) {
					strsql.append(" and a.cascadeRole= ? ");
					super.addStringForField(equipmentTerminalVO.getCascadeRole());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getAgc())) {
					strsql.append(" and a.agc= ? ");
					super.addStringForField(equipmentTerminalVO.getAgc());
				}
				if (!StringUtils.isNullOrBlank(equipmentTerminalVO.getPtsNumber())) {
					strsql.append(" and a.ptsNumber= ? ");
					super.addStringForField(equipmentTerminalVO.getPtsNumber());
				}
				if (Integer.MIN_VALUE != equipmentTerminalVO.getIsCheck()) {
					strsql.append(" and a.isCheck= ? ");
					super.addIntForField(equipmentTerminalVO.getIsCheck());
				}
				
			}
			setSql(strsql.toString());
		} else if (QUERY_FROM_EQUIPMENTTERMINAL_BY_IDS == _operatorType) {
			StringBuffer strsql = new StringBuffer();
			strsql.append("select equipmentID,loginName,loginPassword,createTime,pstn,speed,videoTreaty,radioTreaty,equipmentMCUID,description,revision,dialingType,dialingDirection,aliasName,aliasType,maxPesolution,cascadeRole,agc,ptsNumber,isCheck,mcuResourse,useRole,controlParameter ");
			strsql.append(" from z_t_Equipment_Terminal ");
			strsql.append(" where 1=1 ");
			
			strsql.append(" and equipmentID in (?) ");
			super.addStringForField(ids);
			setSql(strsql.toString());
		}
		else if(QUERY_TERMINAL_BY_ROOMS == _operatorType)
		{
			StringBuffer strsql = new StringBuffer();
			strsql.append("select equipmentID, equipmentName,ip    from ( z_t_equipment inner join z_t_user on z_t_equipment.adminID=z_t_user.userID) inner join z_t_meetingroom on z_t_equipment.roomID=z_t_meetingroom.meetingroomID  where 1=1  and z_t_meetingroom.status=0 and z_t_user.status = 1    ");

			strsql.append(" and z_t_equipment.equipmentType = "+EquipmentEnum.TYPE_ID_TERMINAL);
			
			strsql.append(" and z_t_equipment.roomID in("+ids+") and z_t_equipment.status != 3");
		//	super.addStringForField(ids);
			setSql(strsql.toString());
		}
		else if(QUERY_TERMINAL_BY_IPS  == _operatorType)
		{
			StringBuffer strsql = new StringBuffer();
			strsql.append("select a.equipmentID,a.loginName,a.loginPassword,a.createTime,a.pstn,a.speed,a.videoTreaty,a.radioTreaty,a.equipmentMCUID,a.description,a.revision,a.dialingType,a.dialingDirection,a.aliasName,a.maxPesolution,a.aliasType,a.cascadeRole,a.agc,a.ptsNumber,a.isCheck,a.mcuResourse,a.useRole,a.controlParameter ");
			strsql.append(" ,b.equipmentName,b.ip,b.equipmentNO,b.ip,b.status,b.serialNumber,c.meetingroomName,c.meetingroomID from z_t_Equipment_Terminal a, z_t_equipment  b, z_t_meetingroom  c,z_t_user d ");
			strsql.append(" where 1=1 and  a.equipmentID = b.equipmentID and b.roomID =c.meetingroomID  and c.adminID=d.userID");
			strsql.append(" and b.ip in("+ids+") and b.status=1 and c.status != 1");//modify by ryan on 20120601
			setSql(strsql.toString());
		}else if(QUERY_TERMINAL_BY_MID  == _operatorType)
		{
			StringBuffer strsql = new StringBuffer();
			strsql.append("select zme.meetingDetailID,zme.equipmentID,zet.equipmentID,zet.loginName,zet.loginPassword,zet.createTime,zet.pstn,");
			strsql.append("zme.speed,zet.videoTreaty,zet.radioTreaty,zme.cascadeID as equipmentMCUID,zet.description,zet.revision,zet.dialingType,");
			strsql.append("zet.dialingDirection,zet.aliasType,zet.cascadeRole,zet.agc,zet.isCheck,ze.equipmentName,zme.equipmentNo,zme.mcuResourse,zme.useRole,zme.controlParameter,");
			strsql.append("zme.equipmentIP AS ip,ze.`status`,ze.serialNumber,zme.`status` AS zmeStatus,zm.meetingroomID,zm.meetingroomName,zet.aliasName,zet.maxPesolution,zet.ptsNumber,");
			strsql.append("zme.createDate,zme.createUserID,zme.roomID,zme.count,zme.audioAgreementType,zme.equipmentTel,zme.equipmentNumber,zme.equipmentType,zme.agc as zmeAgc,zme.videoAgreementType,");
			strsql.append("zme.cascadeRole as zmeCascadeRole,zme.maxPesolution as zmeMaxPesolution,zme.aliasType AS zmeAliasType,zme.aliasName as zmeAliasName,zme.dialingDirection as  zmeDialingDirection,zme.dialingType as zmeDialingType,zme.confProfileID,zme.mainEquipment");
			strsql.append(" FROM z_t_meetingdetail_equipment AS zme");
			strsql.append(" JOIN z_t_equipment_terminal AS zet ON zme.equipmentID = zet.equipmentID");
			strsql.append(" JOIN z_t_equipment AS ze ON zme.equipmentID = ze.equipmentID");
			strsql.append(" JOIN z_t_meetingroom AS zm ON zme.roomID = zm.meetingroomID");
			strsql.append(" where 1=1 ");
			//strsql.append(" and zme.`status` = 1 AND ze.`status` = 1 AND zm.`status` = 1");
			strsql.append(" and zme.meetingDetailID = '"+ids+"'");
			
			setSql(strsql.toString());
		}
		else if(QUERY_TERMINAL_BY_MEETINGID  == _operatorType)
		{
			StringBuffer strsql = new StringBuffer();
			strsql.append("select a.equipmentID,a.loginName,a.loginPassword,a.createTime,a.pstn,a.speed,a.videoTreaty,a.radioTreaty,zme.cascadeID as equipmentMCUID,a.description,a.revision,a.dialingType,a.dialingDirection,a.aliasName,a.maxPesolution,a.aliasType,a.cascadeRole,a.agc,a.ptsNumber,a.isCheck,a.mcuResourse,a.useRole,a.controlParameter ");
			strsql.append(" ,b.equipmentName,b.ip,b.equipmentNO,b.ip,b.status,b.serialNumber,c.meetingroomName,c.meetingroomID from z_t_meetingdetail_equipment zme,z_t_Equipment_Terminal a, z_t_equipment  b, z_t_meetingroom  c,z_t_user d ");
			strsql.append(" where 1=1 and zme.equipmentID=a.equipmentID and  a.equipmentID = b.equipmentID and b.roomID =c.meetingroomID  and c.adminID=d.userID");
			strsql.append(" zme.meetingDetailID='"+ids+"'" );//modify by ryan on 20120601
			setSql(strsql.toString());
		}
		
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		if(QUERY_TERMINAL_BY_ROOMS == _operatorType)
		{
			equipmentTerminalVO = new EquipmentTerminalVO();
			equipmentTerminalVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentTerminalVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentTerminalVO.setIp(rs.getString("ip"));
			listEquipmentTerminal.add(equipmentTerminalVO);
		}
		else if(QUERY_FROM_EQUIPMENTTERMINAL ==_operatorType || QUERY_TERMINAL_BY_IPS == _operatorType)
		{	
			equipmentTerminalVO = new EquipmentTerminalVO();
			equipmentTerminalVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentTerminalVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentTerminalVO.setIp(rs.getString("ip"));
			equipmentTerminalVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingroomName"));
			equipmentTerminalVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("meetingroomID"));
			equipmentTerminalVO.getUserVO().setLoginName(rs.getString("loginName"));
			equipmentTerminalVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentTerminalVO.setLoginName(rs.getString("loginName"));
			equipmentTerminalVO.setLoginPassword(rs.getString("loginPassword"));
			equipmentTerminalVO.setCreateTime(rs.getTimestamp("createTime"));
			equipmentTerminalVO.setPstn(rs.getString("pstn"));
			equipmentTerminalVO.setSpeed(rs.getString("speed"));
			equipmentTerminalVO.setVideoTreaty(rs.getString("videoTreaty"));
			equipmentTerminalVO.setRadioTreaty(rs.getString("radioTreaty"));
			equipmentTerminalVO.setEquipmentMCUID(rs.getString("equipmentMCUID"));
			equipmentTerminalVO.setDescription(rs.getString("description"));
			equipmentTerminalVO.setRevision(rs.getLong("revision"));
			equipmentTerminalVO.setStatus(rs.getInt("status"));
			equipmentTerminalVO.setSerialNumber(rs.getString("serialNumber"));
			
			equipmentTerminalVO.setDialingType(rs.getString("dialingType"));
			equipmentTerminalVO.setDialingDirection(rs.getString("dialingDirection"));
			equipmentTerminalVO.setAliasName(rs.getString("aliasName"));
			equipmentTerminalVO.setAliasType(rs.getString("aliasType"));
			equipmentTerminalVO.setMaxPesolution(rs.getString("maxPesolution"));
			equipmentTerminalVO.setCascadeRole(rs.getString("cascadeRole"));
			equipmentTerminalVO.setAgc(rs.getString("agc"));
			equipmentTerminalVO.setPtsNumber(rs.getString("ptsNumber"));
			equipmentTerminalVO.setIsCheck(rs.getInt("isCheck"));
			equipmentTerminalVO.setMcuResourse(rs.getString("mcuResourse"));
			equipmentTerminalVO.setUseRole(rs.getString("useRole"));
			equipmentTerminalVO.setControlParameter(rs.getString("controlParameter"));
			listEquipmentTerminal.add(equipmentTerminalVO);
		}else if(QUERY_TERMINAL_BY_MID == _operatorType)
		{	
			equipmentTerminalVO = new EquipmentTerminalVO();
			equipmentTerminalVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentTerminalVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentTerminalVO.setIp(rs.getString("ip"));
			equipmentTerminalVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingroomName"));
			equipmentTerminalVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("meetingroomID"));
			equipmentTerminalVO.getUserVO().setLoginName(rs.getString("loginName"));
			equipmentTerminalVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentTerminalVO.setLoginName(rs.getString("loginName"));
			equipmentTerminalVO.setLoginPassword(rs.getString("loginPassword"));
			equipmentTerminalVO.setCreateTime(rs.getTimestamp("createTime"));
			equipmentTerminalVO.setPstn(rs.getString("pstn"));
			equipmentTerminalVO.setSpeed(rs.getString("speed"));
			equipmentTerminalVO.setVideoTreaty(rs.getString("videoTreaty"));
			equipmentTerminalVO.setRadioTreaty(rs.getString("radioTreaty"));
			equipmentTerminalVO.setEquipmentMCUID(rs.getString("equipmentMCUID"));
			equipmentTerminalVO.setDescription(rs.getString("description"));
			equipmentTerminalVO.setRevision(rs.getLong("revision"));
			equipmentTerminalVO.setStatus(rs.getInt("status"));
			equipmentTerminalVO.setSerialNumber(rs.getString("serialNumber"));
			equipmentTerminalVO.setDialingType(rs.getString("dialingType"));
			equipmentTerminalVO.setDialingDirection(rs.getString("dialingDirection"));
			equipmentTerminalVO.setAliasName(rs.getString("aliasName"));
			equipmentTerminalVO.setAliasType(rs.getString("aliasType"));
			equipmentTerminalVO.setMaxPesolution(rs.getString("maxPesolution"));
			equipmentTerminalVO.setCascadeRole(rs.getString("cascadeRole"));
			equipmentTerminalVO.setAgc(rs.getString("agc"));
			equipmentTerminalVO.setPtsNumber(rs.getString("ptsNumber"));
			equipmentTerminalVO.setIsCheck(rs.getInt("isCheck"));
			equipmentTerminalVO.setMcuResourse(rs.getString("mcuResourse"));
			equipmentTerminalVO.setUseRole(rs.getString("useRole"));
			equipmentTerminalVO.setControlParameter(rs.getString("controlParameter"));
			MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
			meetingDetailEquipmentVO.setEquipmentID(rs.getString("equipmentID"));
			meetingDetailEquipmentVO.setMeetingDetailID(rs.getString("meetingDetailID"));
			meetingDetailEquipmentVO.setEquipmentNo(rs.getString("equipmentNo"));
			meetingDetailEquipmentVO.setEquipmentIP(rs.getString("ip"));
			meetingDetailEquipmentVO.setEquipmentNumber(rs.getString("equipmentNumber"));
			meetingDetailEquipmentVO.setEquipmentTel(rs.getString("equipmentTel"));
			meetingDetailEquipmentVO.setAudioAgreementType(rs.getString("audioAgreementType"));
			meetingDetailEquipmentVO.setRoomID(rs.getString("roomID"));
			meetingDetailEquipmentVO.setCascadeID(rs.getString("equipmentMCUID"));
			meetingDetailEquipmentVO.setCreateUserID(rs.getString("createUserID"));
			meetingDetailEquipmentVO.setDescription(rs.getString("description"));
			meetingDetailEquipmentVO.setEquipmentType(rs.getInt("equipmentType"));
			meetingDetailEquipmentVO.setSpeed(rs.getString("speed"));
			meetingDetailEquipmentVO.setCount(rs.getInt("count"));
			meetingDetailEquipmentVO.setStatus(rs.getInt("status"));
			meetingDetailEquipmentVO.setCreateDate(rs.getTimestamp("createDate"));
			meetingDetailEquipmentVO.setVideoAgreementType(rs.getString("videoAgreementType"));
			meetingDetailEquipmentVO.setAgc(rs.getString("zmeAgc"));
			meetingDetailEquipmentVO.setCascadeRole(rs.getString("zmeCascadeRole"));
			meetingDetailEquipmentVO.setMaxPesolution(rs.getString("zmeMaxPesolution"));
			meetingDetailEquipmentVO.setAliasType(rs.getString("zmeAliasType"));
			meetingDetailEquipmentVO.setAliasName(rs.getString("zmeAliasName"));
			meetingDetailEquipmentVO.setDialingDirection(rs.getString("zmeDialingDirection"));
			meetingDetailEquipmentVO.setDialingType(rs.getString("zmeDialingType"));
			meetingDetailEquipmentVO.setConfProfileID(rs.getString("confProfileID"));
			meetingDetailEquipmentVO.setMainEquipment(rs.getInt("mainEquipment"));
			equipmentTerminalVO.setMdev(meetingDetailEquipmentVO);
			listEquipmentTerminal.add(equipmentTerminalVO);
		}else if(QUERY_TERMINAL_BY_MEETINGID == _operatorType)
		{	
			equipmentTerminalVO = new EquipmentTerminalVO();
			equipmentTerminalVO.setEquipmentName(rs.getString("equipmentName"));
			equipmentTerminalVO.setEquipmentNO(rs.getString("equipmentNO"));
			equipmentTerminalVO.setIp(rs.getString("ip"));
			equipmentTerminalVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingroomName"));
			equipmentTerminalVO.getMeetingRoomVO().setMeetingRoomID(rs.getString("meetingroomID"));
			equipmentTerminalVO.getUserVO().setLoginName(rs.getString("loginName"));
			equipmentTerminalVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentTerminalVO.setLoginName(rs.getString("loginName"));
			equipmentTerminalVO.setLoginPassword(rs.getString("loginPassword"));
			equipmentTerminalVO.setCreateTime(rs.getTimestamp("createTime"));
			equipmentTerminalVO.setPstn(rs.getString("pstn"));
			equipmentTerminalVO.setSpeed(rs.getString("speed"));
			equipmentTerminalVO.setVideoTreaty(rs.getString("videoTreaty"));
			equipmentTerminalVO.setRadioTreaty(rs.getString("radioTreaty"));
			equipmentTerminalVO.setEquipmentMCUID(rs.getString("equipmentMCUID"));
			equipmentTerminalVO.setDescription(rs.getString("description"));
			equipmentTerminalVO.setRevision(rs.getLong("revision"));
			equipmentTerminalVO.setStatus(rs.getInt("status"));
			equipmentTerminalVO.setSerialNumber(rs.getString("serialNumber"));
			
			equipmentTerminalVO.setDialingType(rs.getString("dialingType"));
			equipmentTerminalVO.setDialingDirection(rs.getString("dialingDirection"));
			equipmentTerminalVO.setAliasName(rs.getString("aliasName"));
			equipmentTerminalVO.setAliasType(rs.getString("aliasType"));
			equipmentTerminalVO.setMaxPesolution(rs.getString("maxPesolution"));
			equipmentTerminalVO.setCascadeRole(rs.getString("cascadeRole"));
			equipmentTerminalVO.setAgc(rs.getString("agc"));
			equipmentTerminalVO.setPtsNumber(rs.getString("ptsNumber"));
			equipmentTerminalVO.setIsCheck(rs.getInt("isCheck"));
			equipmentTerminalVO.setMcuResourse(rs.getString("mcuResourse"));
			equipmentTerminalVO.setUseRole(rs.getString("useRole"));
			equipmentTerminalVO.setControlParameter(rs.getString("controlParameter"));
			listEquipmentTerminal.add(equipmentTerminalVO);
		}
		else
		{
			equipmentTerminalVO = new EquipmentTerminalVO();
			equipmentTerminalVO.setEquipmentID(rs.getString("equipmentID"));
			equipmentTerminalVO.setLoginName(rs.getString("loginName"));
			equipmentTerminalVO.setLoginPassword(rs.getString("loginPassword"));
			equipmentTerminalVO.setCreateTime(rs.getTimestamp("createTime"));
			equipmentTerminalVO.setPstn(rs.getString("pstn"));
			equipmentTerminalVO.setSpeed(rs.getString("speed"));
			equipmentTerminalVO.setVideoTreaty(rs.getString("videoTreaty"));
			equipmentTerminalVO.setRadioTreaty(rs.getString("radioTreaty"));
			equipmentTerminalVO.setEquipmentMCUID(rs.getString("equipmentMCUID"));
			equipmentTerminalVO.setDescription(rs.getString("description"));
			equipmentTerminalVO.setRevision(rs.getLong("revision"));
			equipmentTerminalVO.setDialingType(rs.getString("dialingType"));
			equipmentTerminalVO.setDialingDirection(rs.getString("dialingDirection"));
			equipmentTerminalVO.setAliasName(rs.getString("aliasName"));
			equipmentTerminalVO.setAliasType(rs.getString("aliasType"));
			equipmentTerminalVO.setMaxPesolution(rs.getString("maxPesolution"));
			equipmentTerminalVO.setCascadeRole(rs.getString("cascadeRole"));
			equipmentTerminalVO.setAgc(rs.getString("agc"));
			equipmentTerminalVO.setPtsNumber(rs.getString("ptsNumber"));
			equipmentTerminalVO.setIsCheck(rs.getInt("isCheck"));
			equipmentTerminalVO.setMcuResourse(rs.getString("mcuResourse"));
			equipmentTerminalVO.setUseRole(rs.getString("useRole"));
			equipmentTerminalVO.setControlParameter(rs.getString("controlParameter"));
			listEquipmentTerminal.add(equipmentTerminalVO);
		}
	}

	public ArrayList<EquipmentTerminalVO> getEquipmentTerminalList() {
		return listEquipmentTerminal;
	}

	public EquipmentTerminalVO getEquipmentTerminalVO() {
		return equipmentTerminalVO;
	}

}
