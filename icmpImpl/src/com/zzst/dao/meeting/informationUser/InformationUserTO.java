package com.zzst.dao.meeting.informationUser;
    
	import java.sql.SQLException;
	import org.apache.log4j.Logger;
	import com.cbf.db.TransactionObject;
	import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.informationUser.InformationUserVO;

	/**
	 * class description:	InformationUser TO
	 * @date Tue Jan 29 18:25:43 CST 2013
	 * @author ryan
	 */
    public class InformationUserTO extends TransactionObject {
	
		private	static Logger logger = CbfLogger.getLogger(InformationUserTO.class.getName());
		private int operatorType=-1;
		
		public static int 	ADD_INFORMATIONUSER=1;
		public static int 	MODIFY_INFORMATIONUSER=2;
		public static int 	DEL_INFORMATIONUSER=3;
		private int result = 0;
		
		private InformationUserVO informationUserVO;
		private	String	ids = "";
		
		public InformationUserTO(int operatorType,InformationUserVO informationUserVO){
			this.operatorType = operatorType;
			this.informationUserVO = informationUserVO;
		}
		public InformationUserTO(int operatorType,String ids){
			this.operatorType = operatorType;
			this.ids = ids;
		}
												

													
																			
																			
																			
																			
				
		public void setSqlStr() {
			StringBuffer sqlstr = new StringBuffer();
			if (ADD_INFORMATIONUSER == operatorType) {
				sqlstr.append("insert into z_t_information_user ");	
				sqlstr.append("(infoID,disposeUserID,disposeTime,status,description)");									
				sqlstr.append(" values (?,?,?,?,?)");
								        						super.addStringForField(informationUserVO.getInfoID());
													        						super.addStringForField(informationUserVO.getDisposeUserID());
													        						super.addTimestampForField(informationUserVO.getDisposeTime());
													        						super.addIntForField(informationUserVO.getStatus());
				        								        						super.addStringForField(informationUserVO.getDescription());
												}else if (MODIFY_INFORMATIONUSER == operatorType) {
				sqlstr.append("update  z_t_information_user set ");
																	sqlstr.append(" infoID = infoID ");
																																																		
				
									
									            	               				if(informationUserVO.getDisposeUserID()!=null){
							sqlstr.append(" , disposeUserID=? ");
							super.addStringForField(informationUserVO.getDisposeUserID());
						}	
					    									
									            						if(informationUserVO.getDisposeTime()!=null){
							sqlstr.append(" , disposeTime=? ");
							super.addTimestampForField(informationUserVO.getDisposeTime());
						}	
					   									
									            						if(informationUserVO.getStatus()!=Integer.MIN_VALUE){
							sqlstr.append(" , status=?");	
							super.addIntForField(informationUserVO.getStatus());
						}
				            									
									            	               				if(informationUserVO.getDescription()!=null){
							sqlstr.append(" , description=? ");
							super.addStringForField(informationUserVO.getDescription());
						}	
					    													
				
															sqlstr.append(" where infoID in (?) ");
													if(informationUserVO.getInfoID()!=null){
								super.addStringForField(informationUserVO.getInfoID());
							}	
																																																						}else if (DEL_INFORMATIONUSER == operatorType) {
				sqlstr.append("delete  from  z_t_information_user ");
															sqlstr.append(" where infoID in (?) ");
													super.addStringForField(ids);
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


    