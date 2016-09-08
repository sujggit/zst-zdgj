package com.zzst.model.meeting.equipment;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: Equipment Object
 * 
 * @date Wed Nov 30 10:22:48 CST 2011
 * @author ryan
 */
public class EquipmentVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String equipmentID;
	private int equipmentType = Integer.MIN_VALUE;
	private String equipmentName;
	private String equipmentModel;
	private int status = Integer.MIN_VALUE;
	private String ip;
	private int port = Integer.MIN_VALUE;
	private String equipmentNO ;
	
//	private String roomID;
//	private int adminID = Integer.MIN_VALUE;
	private MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
	private UserVO userVO=new UserVO();
	private	AddressVO addressVO = new AddressVO();
	private Timestamp createDate;
	private String description;
	private long revision = Long.MIN_VALUE;
	
	//addby chenshuo on 2013-5-6
	private String mac ;//mac地址
	private String serialNumber;//序列号
	private String equipmentIdentifier;//资产编号
	private Timestamp maintenanceStartTime;//维保开始日期
	private Timestamp maintenanceEndTime;//维保结束日期
	private int maintenanceMonths;//维保期限
	//会议室分级分权
	private boolean isLevel;
	private String lsql;
	//mcu端口使用率
	private int audioTotal;//语音音频总数
	private int audioUsing;//语音音频使用数
	private int vedioTotal;//视频总数
	private int vedioUsing;//视频使用数
	
	private String cascadeEquipmentID;//设备的级联关系
	
	private int allResourceNumber;//MCU总资源数-页面传值使用
	private int useResourceNumber;//MCU剩余资源数-页面传值使用
	
	private ArrayList<BaseInfoVO> mcuModelList = new ArrayList<BaseInfoVO>();//MCU的模板列表
	
	
	private String descriptionNew;//存放中控中大屏的样式
	
	//添加字段,录播控制需要
	private String loginName;
	private String password;
	private String equroomID;
	public String getDescriptionNew() {
		return descriptionNew;
	}

	public void setDescriptionNew(String descriptionNew) {
		this.descriptionNew = descriptionNew;
	}

	public int getAllResourceNumber() {
		return allResourceNumber;
	}

	public void setAllResourceNumber(int allResourceNumber) {
		this.allResourceNumber = allResourceNumber;
	}

	public int getUseResourceNumber() {
		return useResourceNumber;
	}

	public void setUseResourceNumber(int useResourceNumber) {
		this.useResourceNumber = useResourceNumber;
	}

	public ArrayList<BaseInfoVO> getMcuModelList() {
		return mcuModelList;
	}

	public void setMcuModelList(ArrayList<BaseInfoVO> mcuModelList) {
		this.mcuModelList = mcuModelList;
	}

	public String getCascadeEquipmentID() {
		return cascadeEquipmentID;
	}

	public void setCascadeEquipmentID(String cascadeEquipmentID) {
		this.cascadeEquipmentID = cascadeEquipmentID;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public int getAudioTotal() {
		return audioTotal;
	}

	public void setAudioTotal(int audioTotal) {
		this.audioTotal = audioTotal;
	}

	public int getAudioUsing() {
		return audioUsing;
	}

	public void setAudioUsing(int audioUsing) {
		this.audioUsing = audioUsing;
	}

	public int getVedioTotal() {
		return vedioTotal;
	}

	public void setVedioTotal(int vedioTotal) {
		this.vedioTotal = vedioTotal;
	}

	public int getVedioUsing() {
		return vedioUsing;
	}

	public void setVedioUsing(int vedioUsing) {
		this.vedioUsing = vedioUsing;
	}

	public boolean isLevel() {
		return isLevel;
	}

	public void setLevel(boolean isLevel) {
		this.isLevel = isLevel;
	}

	public String getLsql() {
		return lsql;
	}

	public void setLsql(String lsql) {
		this.lsql = lsql;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentType(int equipmentType) {
		this.equipmentType = equipmentType;
	}

	public int getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}



//	public void setRoomID(String roomID) {
//		this.roomID = roomID;
//	}
//
//	public String getRoomID() {
//		return roomID;
//	}
//
//	public void setAdminID(int adminID) {
//		this.adminID = adminID;
//	}
//
//	public int getAdminID() {
//		return adminID;
//	}
	

	public String getEquipmentNO() {
		return equipmentNO;
	}

	public void setEquipmentNO(String equipmentNO) {
		this.equipmentNO = equipmentNO;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRevision() {
		return revision;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getEquipmentIdentifier() {
		return equipmentIdentifier;
	}

	public void setEquipmentIdentifier(String equipmentIdentifier) {
		this.equipmentIdentifier = equipmentIdentifier;
	}

	public Timestamp getMaintenanceStartTime() {
		return maintenanceStartTime;
	}

	public void setMaintenanceStartTime(Timestamp maintenanceStartTime) {
		this.maintenanceStartTime = maintenanceStartTime;
	}

	public Timestamp getMaintenanceEndTime() {
		return maintenanceEndTime;
	}

	public void setMaintenanceEndTime(Timestamp maintenanceEndTime) {
		this.maintenanceEndTime = maintenanceEndTime;
	}

	public int getMaintenanceMonths() {
		return maintenanceMonths;
	}

	public void setMaintenanceMonths(int maintenanceMonths) {
		this.maintenanceMonths = maintenanceMonths;
	}
	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEquroomID() {
		return equroomID;
	}

	public void setEquroomID(String equroomID) {
		this.equroomID = equroomID;
	}

}
