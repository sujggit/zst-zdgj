



	    	        	
	
         
        	
		
	        
        	
		
        

    
   
    package com.zzst.dao.mobileInfo;
    
	import java.sql.SQLException;
	import org.apache.log4j.Logger;
	import com.cbf.db.TransactionObject;
	import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.mobileInfo.MobileInfoVO;

	/**
	 * class description:	MobileInfo TO
	 * @date Mon Aug 01 09:37:00 CST 2016
	 * @author ryan
	 */
    public class MobileInfoTO extends TransactionObject {
	
		private	static Logger logger = CbfLogger.getLogger(MobileInfoTO.class.getName());
		private int operatorType=-1;
		
		public static int 	ADD_MOBILEINFO=1;
		public static int 	MODIFY_MOBILEINFO=2;
		public static int 	DEL_MOBILEINFO=3;
		private int result = 0;
		
		private MobileInfoVO mobileInfoVO;
	 
		
		public MobileInfoTO(int operatorType,MobileInfoVO mobileInfoVO){
			this.operatorType = operatorType;
			this.mobileInfoVO = mobileInfoVO;
		}
	 
										

													
																			
																			
																			
				
		public void setSqlStr() {
			StringBuffer sqlstr = new StringBuffer();
			if (ADD_MOBILEINFO == operatorType) {
				sqlstr.append("insert into z_t_mobileInfo ");	
				sqlstr.append("(id,name,mobile,status)");									
				sqlstr.append(" values (?,?,?,?)");
								        						super.addStringForField(mobileInfoVO.getId());
													        						super.addStringForField(mobileInfoVO.getName());
													        						super.addStringForField(mobileInfoVO.getMobile());
													        						super.addStringForField(mobileInfoVO.getStatus());
												}else if (MODIFY_MOBILEINFO == operatorType) {
				sqlstr.append("update  z_t_mobileInfo set ");
																	sqlstr.append(" id = id ");
																																								
				
									
									            	               				if(mobileInfoVO.getName()!=null){
							sqlstr.append(" , name=? ");
							super.addStringForField(mobileInfoVO.getName());
						}	
					    									
									            	               				if(mobileInfoVO.getMobile()!=null){
							sqlstr.append(" , mobile=? ");
							super.addStringForField(mobileInfoVO.getMobile());
						}	
					    									
									            	               				if(mobileInfoVO.getStatus()!=null){
							sqlstr.append(" , status=? ");
							super.addStringForField(mobileInfoVO.getStatus());
						}	
					    													
				
															sqlstr.append(" where id in (?) ");
													if(mobileInfoVO.getId()!=null){
								super.addStringForField(mobileInfoVO.getId());
							}	
																																													}else if (DEL_MOBILEINFO == operatorType) {
				sqlstr.append("delete  from  z_t_mobileInfo ");
															sqlstr.append(" where id in (?) ");
													super.addStringForField(mobileInfoVO.getId());
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


    