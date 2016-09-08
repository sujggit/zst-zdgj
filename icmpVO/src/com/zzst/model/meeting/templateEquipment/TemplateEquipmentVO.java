package com.zzst.model.meeting.templateEquipment;



import java.io.Serializable;

/**
 * class description: equipment Object
 * @date Wed Mar 20 10:59:53 CST 2013
 * @author ryan
 */
public class TemplateEquipmentVO implements Serializable {

	private static final long serialVersionUID = 1L;	    



	private String ID;
	private String groupId;
	private String equipmentName;
	private String equipmentIp;
	private String pInterface;
	private String aliasName;
	private String aliasType;
	private String ptsNumber;
	private String lineRate;
	private String maxResolution;
	private String videoProtocol;
	private String cascadeRole;
	private String agc;
	private String callDirection;
	private int isMain	=	Integer.MIN_VALUE;    
	private String description;
	private String meetingRoomID;




	public void setID(String ID){
		this.ID = ID;
	}
	public String getID(){
		return ID;
	}


	public void setGroupId(String groupId){
		this.groupId = groupId;
	}
	public String getGroupId(){
		return groupId;
	}


	public void setEquipmentName(String equipmentName){
		this.equipmentName = equipmentName;
	}
	public String getEquipmentName(){
		return equipmentName;
	}


	public void setEquipmentIp(String equipmentIp){
		this.equipmentIp = equipmentIp;
	}
	public String getEquipmentIp(){
		return equipmentIp;
	}


	public void setPInterface(String pInterface){
		this.pInterface = pInterface;
	}
	public String getPInterface(){
		return pInterface;
	}


	public void setAliasName(String aliasName){
		this.aliasName = aliasName;
	}
	public String getAliasName(){
		return aliasName;
	}


	public void setAliasType(String aliasType){
		this.aliasType = aliasType;
	}
	public String getAliasType(){
		return aliasType;
	}


	public void setPtsNumber(String ptsNumber){
		this.ptsNumber = ptsNumber;
	}
	public String getPtsNumber(){
		return ptsNumber;
	}


	public void setLineRate(String lineRate){
		this.lineRate = lineRate;
	}
	public String getLineRate(){
		return lineRate;
	}


	public void setMaxResolution(String maxResolution){
		this.maxResolution = maxResolution;
	}
	public String getMaxResolution(){
		return maxResolution;
	}


	public void setVideoProtocol(String videoProtocol){
		this.videoProtocol = videoProtocol;
	}
	public String getVideoProtocol(){
		return videoProtocol;
	}


	public void setCascadeRole(String cascadeRole){
		this.cascadeRole = cascadeRole;
	}
	public String getCascadeRole(){
		return cascadeRole;
	}


	public void setAgc(String agc){
		this.agc = agc;
	}
	public String getAgc(){
		return agc;
	}


	public void setCallDirection(String callDirection){
		this.callDirection = callDirection;
	}
	public String getCallDirection(){
		return callDirection;
	}


	public void setIsMain(int isMain){
		this.isMain = isMain;
	}                
	public int getIsMain(){
		return isMain;
	}


	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public String getMeetingRoomID() {
		return meetingRoomID;
	}
	public void setMeetingRoomID(String meetingRoomID) {
		this.meetingRoomID = meetingRoomID;
	}
	
	


}


