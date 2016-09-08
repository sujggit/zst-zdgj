




	    	                    
        
        		

       
    package com.zzst.model.meeting.scheduleWork;

import java.io.Serializable;
	
	/**
	 * class description: ScheduleWork Object
	 * @date Mon Aug 22 16:03:33 CST 2016
	 * @author ryan
	 */
	public class ScheduleWorkVO implements Serializable {
	
		private static final long serialVersionUID = 1L;	    
				

	    
	    	            	        		            	private String workId;
	                    	        		            	private String workName;
	                    	        		            	private String status;
	                            
                        

        
                	            	            	public void setWorkId(String workId){
	                	this.workId = workId;
	            	}
	            	public String getWorkId(){
	                	return workId;
	            	}
	            	            	           
	        
        	            	            	public void setWorkName(String workName){
	                	this.workName = workName;
	            	}
	            	public String getWorkName(){
	                	return workName;
	            	}
	            	            	           
	        
        	            	            	public void setStatus(String status){
	                	this.status = status;
	            	}
	            	public String getStatus(){
	                	return status;
	            	}
	            	            	           
	        
        	
		                
		
	}

    
    