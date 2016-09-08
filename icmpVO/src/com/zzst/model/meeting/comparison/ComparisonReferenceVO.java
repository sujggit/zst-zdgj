package com.zzst.model.meeting.comparison;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: ComparisonReference Object
 * @date Sat Apr 27 11:12:39 CST 2013
 * @author ryan
 */
public class ComparisonReferenceVO implements Serializable {

	private static final long serialVersionUID = 1L;	    



	private String ID;
	private String meetingRoomID;
	private String R_Pr;
	private String G_Y;
	private String B_Pb;
	private int rIndex	=	Integer.MIN_VALUE;    
	private int gIndex	=	Integer.MIN_VALUE;    
	private int bIndex	=	Integer.MIN_VALUE;    
	private int S_R	=	Integer.MIN_VALUE;    
	private int S_G	=	Integer.MIN_VALUE;    
	private int S_B	=	Integer.MIN_VALUE;    
	private int x_min	=	Integer.MIN_VALUE;    
	private int x_max	=	Integer.MIN_VALUE;    
	private int type	=	Integer.MIN_VALUE;    
	private Timestamp updateTime;	            	
	private String updateUserID;
	private int status	=	Integer.MIN_VALUE;    
	private String description;

	  //////
	//从equipment表中查出相应的比对卡ip和终端ip;
	private String videoCardIp;
	private String terminalIp;
    private String meetingRoomName;



	public void setID(String ID){
		this.ID = ID;
	}
	public String getID(){
		return ID;
	}


	public void setMeetingRoomID(String meetingRoomID){
		this.meetingRoomID = meetingRoomID;
	}
	public String getMeetingRoomID(){
		return meetingRoomID;
	}


	public void setR_Pr(String R_Pr){
		this.R_Pr = R_Pr;
	}
	public String getR_Pr(){
		return R_Pr;
	}


	public void setG_Y(String G_Y){
		this.G_Y = G_Y;
	}
	public String getG_Y(){
		return G_Y;
	}


	public void setB_Pb(String B_Pb){
		this.B_Pb = B_Pb;
	}
	public String getB_Pb(){
		return B_Pb;
	}


	public void setRIndex(int rIndex){
		this.rIndex = rIndex;
	}                
	public int getRIndex(){
		return rIndex;
	}


	public void setGIndex(int gIndex){
		this.gIndex = gIndex;
	}                
	public int getGIndex(){
		return gIndex;
	}


	public void setBIndex(int bIndex){
		this.bIndex = bIndex;
	}                
	public int getBIndex(){
		return bIndex;
	}


	public void setS_R(int S_R){
		this.S_R = S_R;
	}                
	public int getS_R(){
		return S_R;
	}


	public void setS_G(int S_G){
		this.S_G = S_G;
	}                
	public int getS_G(){
		return S_G;
	}


	public void setS_B(int S_B){
		this.S_B = S_B;
	}                
	public int getS_B(){
		return S_B;
	}


	public void setX_min(int x_min){
		this.x_min = x_min;
	}                
	public int getX_min(){
		return x_min;
	}


	public void setX_max(int x_max){
		this.x_max = x_max;
	}                
	public int getX_max(){
		return x_max;
	}


	public void setType(int type){
		this.type = type;
	}                
	public int getType(){
		return type;
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
	public String getVideoCardIp() {
		return videoCardIp;
	}
	public void setVideoCardIp(String videoCardIp) {
		this.videoCardIp = videoCardIp;
	}
	public String getTerminalIp() {
		return terminalIp;
	}
	public void setTerminalIp(String terminalIp) {
		this.terminalIp = terminalIp;
	}
	public String getMeetingRoomName() {
		return meetingRoomName;
	}
	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}





}


