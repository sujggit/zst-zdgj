



	    	        	
	
         
        	
		
	        
        	
		
        

    
   
    package com.zzst.dao.meeting.scheduleWork;
    
	import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.scheduleWork.ScheduleWorkVO;

	/**
	 * class description:	ScheduleWork TO
	 * @date Mon Aug 22 16:03:33 CST 2016
	 * @author ryan
	 */
    public class ScheduleWorkTO extends TransactionObject {
	
		private	static Logger logger = CbfLogger.getLogger(ScheduleWorkTO.class.getName());
		private int operatorType=-1;
		
		public static int 	ADD_SCHEDULEWORK=1;
		public static int 	MODIFY_SCHEDULEWORK=2;
		public static int 	DEL_SCHEDULEWORK=3;
		private int result = 0;
		
		private ScheduleWorkVO scheduleWorkVO;
	 
		
		public ScheduleWorkTO(int operatorType,ScheduleWorkVO scheduleWorkVO){
			this.operatorType = operatorType;
			this.scheduleWorkVO = scheduleWorkVO;
		}
	 
								

													
																			
																			
				
		public void setSqlStr() {
			StringBuffer sqlstr = new StringBuffer();
			if (ADD_SCHEDULEWORK == operatorType) {
				sqlstr.append("insert into z_t_schedule_work ");	
				sqlstr.append("(workId,workName,status)");									
				sqlstr.append(" values (?,?,?)");
								        						super.addStringForField(scheduleWorkVO.getWorkId());
													        						super.addStringForField(scheduleWorkVO.getWorkName());
													        						super.addStringForField(scheduleWorkVO.getStatus());
												}else if (MODIFY_SCHEDULEWORK == operatorType) {
				sqlstr.append("update  z_t_schedule_work set ");
																	sqlstr.append(" workId = workId ");
																														
				
									
									            	               				if(scheduleWorkVO.getWorkName()!=null){
							sqlstr.append(" , workName=? ");
							super.addStringForField(scheduleWorkVO.getWorkName());
						}	
					    									
									            	               				if(scheduleWorkVO.getStatus()!=null){
							sqlstr.append(" , status=? ");
							super.addStringForField(scheduleWorkVO.getStatus());
						}	
					    													
				
															sqlstr.append(" where workId in (?) ");
													if(scheduleWorkVO.getWorkId()!=null){
								super.addStringForField(scheduleWorkVO.getWorkId());
							}	
																																				}else if (DEL_SCHEDULEWORK == operatorType) {
				sqlstr.append("delete  from  z_t_schedule_work ");
															sqlstr.append(" where workId in (?) ");
													super.addStringForField(scheduleWorkVO.getWorkId());
																																				}
			this.sqlStr = sqlstr.toString();
		}

		public String getSqlStr(){
			return this.sqlStr;
		}

		public void setValues() throws SQLException {
			 
		}
		public void execute() throws SQLException {
			result = this.stmt.executeUpdate();
		}

		public int getexecuteResult() {
			return result;
		}

	}


    