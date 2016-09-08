package com.zzst.model.meeting.comparison;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: ComparisonCriteria Object
 * @date Fri Apr 26 16:04:41 CST 2013
 * @author ryan
 */
public class ComparisonCriteriaVO implements Serializable {

	private static final long serialVersionUID = 1L;	    



	private String ComCriteriaID;
	private int rsGap_Good_lower	=	Integer.MIN_VALUE;    
	private int rsGap_Good_upper	=	Integer.MIN_VALUE;    
	private int rsGap_Ok_lower	=	Integer.MIN_VALUE;    
	private int rsGap_Ok_upper	=	Integer.MIN_VALUE;    
	private int gsGap_Good_lower	=	Integer.MIN_VALUE;    
	private int gsGap_Good_upper	=	Integer.MIN_VALUE;    
	private int gsGap_Ok_lower	=	Integer.MIN_VALUE;    
	private int gsGap_Ok_upper	=	Integer.MIN_VALUE;    
	private int bsGap_Good_lower	=	Integer.MIN_VALUE;    
	private int bsGap_Good_upper	=	Integer.MIN_VALUE;    
	private int bsGap_Ok_lower	=	Integer.MIN_VALUE;    
	private int bsGap_Ok_upper	=	Integer.MIN_VALUE;    
	private int x_min	=	Integer.MIN_VALUE;    
	private int x_max	=	Integer.MIN_VALUE;    
	private String updateUserID;
	private Timestamp updateTime;	            	
	private String description;
	private long revision	=	Long.MIN_VALUE;




	public void setComCriteriaID(String ComCriteriaID){
		this.ComCriteriaID = ComCriteriaID;
	}
	public String getComCriteriaID(){
		return ComCriteriaID;
	}


	public void setRsGap_Good_lower(int rsGap_Good_lower){
		this.rsGap_Good_lower = rsGap_Good_lower;
	}                
	public int getRsGap_Good_lower(){
		return rsGap_Good_lower;
	}


	public void setRsGap_Good_upper(int rsGap_Good_upper){
		this.rsGap_Good_upper = rsGap_Good_upper;
	}                
	public int getRsGap_Good_upper(){
		return rsGap_Good_upper;
	}


	public void setRsGap_Ok_lower(int rsGap_Ok_lower){
		this.rsGap_Ok_lower = rsGap_Ok_lower;
	}                
	public int getRsGap_Ok_lower(){
		return rsGap_Ok_lower;
	}


	public void setRsGap_Ok_upper(int rsGap_Ok_upper){
		this.rsGap_Ok_upper = rsGap_Ok_upper;
	}                
	public int getRsGap_Ok_upper(){
		return rsGap_Ok_upper;
	}


	public void setGsGap_Good_lower(int gsGap_Good_lower){
		this.gsGap_Good_lower = gsGap_Good_lower;
	}                
	public int getGsGap_Good_lower(){
		return gsGap_Good_lower;
	}


	public void setGsGap_Good_upper(int gsGap_Good_upper){
		this.gsGap_Good_upper = gsGap_Good_upper;
	}                
	public int getGsGap_Good_upper(){
		return gsGap_Good_upper;
	}


	public void setGsGap_Ok_lower(int gsGap_Ok_lower){
		this.gsGap_Ok_lower = gsGap_Ok_lower;
	}                
	public int getGsGap_Ok_lower(){
		return gsGap_Ok_lower;
	}


	public void setGsGap_Ok_upper(int gsGap_Ok_upper){
		this.gsGap_Ok_upper = gsGap_Ok_upper;
	}                
	public int getGsGap_Ok_upper(){
		return gsGap_Ok_upper;
	}


	public void setBsGap_Good_lower(int bsGap_Good_lower){
		this.bsGap_Good_lower = bsGap_Good_lower;
	}                
	public int getBsGap_Good_lower(){
		return bsGap_Good_lower;
	}


	public void setBsGap_Good_upper(int bsGap_Good_upper){
		this.bsGap_Good_upper = bsGap_Good_upper;
	}                
	public int getBsGap_Good_upper(){
		return bsGap_Good_upper;
	}


	public void setBsGap_Ok_lower(int bsGap_Ok_lower){
		this.bsGap_Ok_lower = bsGap_Ok_lower;
	}                
	public int getBsGap_Ok_lower(){
		return bsGap_Ok_lower;
	}


	public void setBsGap_Ok_upper(int bsGap_Ok_upper){
		this.bsGap_Ok_upper = bsGap_Ok_upper;
	}                
	public int getBsGap_Ok_upper(){
		return bsGap_Ok_upper;
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


	public void setUpdateUserID(String updateUserID){
		this.updateUserID = updateUserID;
	}
	public String getUpdateUserID(){
		return updateUserID;
	}


	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
	public Timestamp getUpdateTime(){
		return updateTime;
	}    	            	



	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}


	public void setRevision(long revision){
		this.revision = revision;
	}
	public long getRevision(){
		return revision;
	}                	            	





}


