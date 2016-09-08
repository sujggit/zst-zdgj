package com.zzst.model.meeting.comparison;


import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

/**
 * class description: Comparison Object
 * @date Sat Apr 27 13:39:44 CST 2013
 * @author ryan
 */
public class ComparisonVO implements Serializable {

	private static final long serialVersionUID = 1L;	    



	private String ID;
	private String compDetailID;
	private String meetingDetailID;
	private String meetingName;
	private String meetingRoomID;
	private int upVideoQuality	=	Integer.MIN_VALUE;    
	private int downVideoQuality	=	Integer.MIN_VALUE;    
	private int upAudioQuality	=	Integer.MIN_VALUE;    
	private int downAudioQuality	=	Integer.MIN_VALUE;    
	private float sendPacketLoss	=	0;
	private float receivePacketLoss	=	0;
	private int sendframeRate	=	Integer.MIN_VALUE;    
	private int receiveframeRate	=	Integer.MIN_VALUE;    
	private Timestamp updateTime;
	private Timestamp startTime;
	private Timestamp endTime;
	private String updateUserID;
	private int result	=	Integer.MIN_VALUE;    
	private int status	=	Integer.MIN_VALUE;    
	private String description;

	private MeetingRoomVO meetingRoomVO;

	public void setID(String ID){
		this.ID = ID;
	}
	public String getID(){
		return ID;
	}

	public void setCompDetailID(String compDetailID){
		this.compDetailID = compDetailID;
	}
	public String getCompDetailID(){
		return compDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID){
		this.meetingDetailID = meetingDetailID;
	}
	public String getMeetingDetailID(){
		return meetingDetailID;
	}


	public void setMeetingRoomID(String meetingRoomID){
		this.meetingRoomID = meetingRoomID;
	}
	public String getMeetingRoomID(){
		return meetingRoomID;
	}

	public void setUpVideoQuality(int upVideoQuality){
		this.upVideoQuality = upVideoQuality;
	}                
	public int getUpVideoQuality(){
		return upVideoQuality;
	}

	public void setDownVideoQuality(int downVideoQuality){
		this.downVideoQuality = downVideoQuality;
	}                
	public int getDownVideoQuality(){
		return downVideoQuality;
	}

	public void setUpAudioQuality(int upAudioQuality){
		this.upAudioQuality = upAudioQuality;
	}                
	public int getUpAudioQuality(){
		return upAudioQuality;
	}

	public void setDownAudioQuality(int downAudioQuality){
		this.downAudioQuality = downAudioQuality;
	}                
	public int getDownAudioQuality(){
		return downAudioQuality;
	}

	public void setSendPacketLoss(Float sendPacketLoss){
		this.sendPacketLoss = sendPacketLoss;
	}
	public Float getSendPacketLoss(){
		return sendPacketLoss;
	} 

	public void setReceivePacketLoss(Float receivePacketLoss){
		this.receivePacketLoss = receivePacketLoss;
	}
	public Float getReceivePacketLoss(){
		return receivePacketLoss;
	} 

	public void setSendframeRate(int sendframeRate){
		this.sendframeRate = sendframeRate;
	}                
	public int getSendframeRate(){
		return sendframeRate;
	}


	public void setReceiveframeRate(int receiveframeRate){
		this.receiveframeRate = receiveframeRate;
	}                
	public int getReceiveframeRate(){
		return receiveframeRate;
	}


	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
	public Timestamp getUpdateTime(){
		return updateTime;
	}    	            	

	public void setUpdateUserID(String updateUserID){
		this.updateUserID = updateUserID;
	}
	public String getUpdateUserID(){
		return updateUserID;
	}

	public void setResult(int result){
		this.result = result;
	}                
	public int getResult(){
		return result;
	}

	public void setStatus(int status){
		this.status = status;
	}                
	public int getStatus(){
		return status;
	}

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}
	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}
	public void setSendPacketLoss(float sendPacketLoss) {
		this.sendPacketLoss = sendPacketLoss;
	}
	public void setReceivePacketLoss(float receivePacketLoss) {
		this.receivePacketLoss = receivePacketLoss;
	}
	public String getMeetingName() {
		return meetingName;
	}
	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	

}


