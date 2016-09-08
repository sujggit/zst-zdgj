package com.zzst.model.meeting.equipment;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;

/**
 * class description: 终端设备
 * 
 * @date Wed Nov 30 10:22:49 CST 2011
 * @author ryan
 */
public class EquipmentTerminalVO  extends EquipmentVO implements Serializable {

	private static final long serialVersionUID = 1L;

//private String equipmentID;
	private String loginName;
	private String loginPassword;
	private Timestamp createTime;
	private String pstn;
	private String speed;
	private String videoTreaty;
	private String radioTreaty;
	private String equipmentMCUID;
	private String description;
	private long revision = Long.MIN_VALUE;
	
	//新增加的字段
	private String dialingType;//类型
	private String dialingDirection;//呼叫方向
	private String aliasName;//别名
	private String aliasType;//别名类型
	private String maxPesolution;//分辨率
	private String cascadeRole;//级联角色
	private String agc;//增益
	private String ptsNumber;//会议号码
	private int isCheck = Integer.MIN_VALUE;//判断是否勾选控制参数:1为选中，0为未选中
    private boolean isMian;
    private MeetingDetailEquipmentVO mdev;

    private String mcuResourse;//占用MCU的资源数
    private String useRole;//角色
    private String controlParameter;//控制参数，与中控、音频处理器相关
    
    
	public String getMcuResourse() {
		return mcuResourse;
	}

	public void setMcuResourse(String mcuResourse) {
		this.mcuResourse = mcuResourse;
	}

	public String getUseRole() {
		return useRole;
	}

	public void setUseRole(String useRole) {
		this.useRole = useRole;
	}

	public String getControlParameter() {
		return controlParameter;
	}

	public void setControlParameter(String controlParameter) {
		this.controlParameter = controlParameter;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDialingType() {
		return dialingType;
	}

	public void setDialingType(String dialingType) {
		this.dialingType = dialingType;
	}

	public String getDialingDirection() {
		return dialingDirection;
	}

	public void setDialingDirection(String dialingDirection) {
		this.dialingDirection = dialingDirection;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getAliasType() {
		return aliasType;
	}

	public void setAliasType(String aliasType) {
		this.aliasType = aliasType;
	}

	public String getMaxPesolution() {
		return maxPesolution;
	}

	public void setMaxPesolution(String maxPesolution) {
		this.maxPesolution = maxPesolution;
	}

	public String getCascadeRole() {
		return cascadeRole;
	}

	public void setCascadeRole(String cascadeRole) {
		this.cascadeRole = cascadeRole;
	}

	public String getAgc() {
		return agc;
	}

	public void setAgc(String agc) {
		this.agc = agc;
	}

	public String getPtsNumber() {
		return ptsNumber;
	}

	public void setPtsNumber(String ptsNumber) {
		this.ptsNumber = ptsNumber;
	}

	public int getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setPstn(String pstn) {
		this.pstn = pstn;
	}

	public String getPstn() {
		return pstn;
	}

	public void setVideoTreaty(String videoTreaty) {
		this.videoTreaty = videoTreaty;
	}

	public String getVideoTreaty() {
		return videoTreaty;
	}

	public void setRadioTreaty(String radioTreaty) {
		this.radioTreaty = radioTreaty;
	}

	public String getRadioTreaty() {
		return radioTreaty;
	}

	public void setEquipmentMCUID(String equipmentMCUID) {
		this.equipmentMCUID = equipmentMCUID;
	}

	public String getEquipmentMCUID() {
		return equipmentMCUID;
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

	public void setMian(boolean isMian) {
		this.isMian = isMian;
	}

	public boolean isMian() {
		return isMian;
	}

	public void setMdev(MeetingDetailEquipmentVO mdev) {
		this.mdev = mdev;
	}

	public MeetingDetailEquipmentVO getMdev() {
		return mdev;
	}

}
