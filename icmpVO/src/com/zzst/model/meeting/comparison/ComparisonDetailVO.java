package com.zzst.model.meeting.comparison;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * class description: ComparisonDetail Object
 * @date Sun Apr 28 13:09:54 CST 2013
 * @author ryan
 */
public class ComparisonDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;	    



	private String ID;
	private String R_Pr;
	private String G_Y;
	private String B_Pb;
	private String uplinkR_Pr;
	private String uplinkG_Y;
	private String uplinkB_Pb;
	private int S_R	=	Integer.MIN_VALUE;    
	private float S_R_gap	=	Float.MIN_VALUE;
	private int S_R_result	=	Integer.MIN_VALUE;    
	private int S_G	=	Integer.MIN_VALUE;    
	private float S_G_gap	=	Float.MIN_VALUE;
	private int S_G_result	=	Integer.MIN_VALUE;    
	private int S_B	=	Integer.MIN_VALUE;    
	private float S_B_gap	=	Float.MIN_VALUE;
	private int S_B_result	=	Integer.MIN_VALUE;    
	private int uplinkS_R	=	Integer.MIN_VALUE;    
	private float uplinkS_R_gap	=	Float.MIN_VALUE;
	private int uplinkS_R_result	=	Integer.MIN_VALUE;    
	private int uplinkS_G	=	Integer.MIN_VALUE;    
	private float uplinkS_G_gap	=	Float.MIN_VALUE;
	private int uplinkS_G_result	=	Integer.MIN_VALUE;    
	private int uplinkS_B	=	Integer.MIN_VALUE;    
	private float uplinkS_B_gap	=	Float.MIN_VALUE;
	private int uplinkS_B_result	=	Integer.MIN_VALUE;    
	private int type	=	Integer.MIN_VALUE;    
	private Timestamp updateTime;	            	
	private String updateUserID;
	private int status	=	Integer.MIN_VALUE;    
	private String description;




	public void setID(String ID){
		this.ID = ID;
	}
	public String getID(){
		return ID;
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


	public void setUplinkR_Pr(String uplinkR_Pr){
		this.uplinkR_Pr = uplinkR_Pr;
	}
	public String getUplinkR_Pr(){
		return uplinkR_Pr;
	}


	public void setUplinkG_Y(String uplinkG_Y){
		this.uplinkG_Y = uplinkG_Y;
	}
	public String getUplinkG_Y(){
		return uplinkG_Y;
	}


	public void setUplinkB_Pb(String uplinkB_Pb){
		this.uplinkB_Pb = uplinkB_Pb;
	}
	public String getUplinkB_Pb(){
		return uplinkB_Pb;
	}


	public void setS_R(int S_R){
		this.S_R = S_R;
	}                
	public int getS_R(){
		return S_R;
	}


	public void setS_R_gap(Float S_R_gap){
		this.S_R_gap = S_R_gap;
	}
	public Float getS_R_gap(){
		return S_R_gap;
	} 


	public void setS_R_result(int S_R_result){
		this.S_R_result = S_R_result;
	}                
	public int getS_R_result(){
		return S_R_result;
	}


	public void setS_G(int S_G){
		this.S_G = S_G;
	}                
	public int getS_G(){
		return S_G;
	}


	public void setS_G_gap(Float S_G_gap){
		this.S_G_gap = S_G_gap;
	}
	public Float getS_G_gap(){
		return S_G_gap;
	} 


	public void setS_G_result(int S_G_result){
		this.S_G_result = S_G_result;
	}                
	public int getS_G_result(){
		return S_G_result;
	}


	public void setS_B(int S_B){
		this.S_B = S_B;
	}                
	public int getS_B(){
		return S_B;
	}


	public void setS_B_gap(Float S_B_gap){
		this.S_B_gap = S_B_gap;
	}
	public Float getS_B_gap(){
		return S_B_gap;
	} 


	public void setS_B_result(int S_B_result){
		this.S_B_result = S_B_result;
	}                
	public int getS_B_result(){
		return S_B_result;
	}


	public void setUplinkS_R(int uplinkS_R){
		this.uplinkS_R = uplinkS_R;
	}                
	public int getUplinkS_R(){
		return uplinkS_R;
	}


	public void setUplinkS_R_gap(Float uplinkS_R_gap){
		this.uplinkS_R_gap = uplinkS_R_gap;
	}
	public Float getUplinkS_R_gap(){
		return uplinkS_R_gap;
	} 


	public void setUplinkS_R_result(int uplinkS_R_result){
		this.uplinkS_R_result = uplinkS_R_result;
	}                
	public int getUplinkS_R_result(){
		return uplinkS_R_result;
	}


	public void setUplinkS_G(int uplinkS_G){
		this.uplinkS_G = uplinkS_G;
	}                
	public int getUplinkS_G(){
		return uplinkS_G;
	}


	public void setUplinkS_G_gap(Float uplinkS_G_gap){
		this.uplinkS_G_gap = uplinkS_G_gap;
	}
	public Float getUplinkS_G_gap(){
		return uplinkS_G_gap;
	} 


	public void setUplinkS_G_result(int uplinkS_G_result){
		this.uplinkS_G_result = uplinkS_G_result;
	}                
	public int getUplinkS_G_result(){
		return uplinkS_G_result;
	}


	public void setUplinkS_B(int uplinkS_B){
		this.uplinkS_B = uplinkS_B;
	}                
	public int getUplinkS_B(){
		return uplinkS_B;
	}


	public void setUplinkS_B_gap(Float uplinkS_B_gap){
		this.uplinkS_B_gap = uplinkS_B_gap;
	}
	public Float getUplinkS_B_gap(){
		return uplinkS_B_gap;
	} 


	public void setUplinkS_B_result(int uplinkS_B_result){
		this.uplinkS_B_result = uplinkS_B_result;
	}                
	public int getUplinkS_B_result(){
		return uplinkS_B_result;
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





}


