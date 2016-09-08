



	    	            
         
        	
		
	        
        	
		
        

    
    
    package com.zzst.dao.mobileInfo;
    
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import org.apache.log4j.Logger;
	import com.cbf.db.MasterQueryObject;
	import com.cbf.log.CbfLogger;
	import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.mobileInfo.MobileInfoVO;

	/**
	 * class description:	MobileInfo MQB
	 * @date Mon Aug 01 09:37:00 CST 2016
	 * @author ryan
	 */
	public class MobileInfoMQB extends MasterQueryObject {
		static Logger logger = CbfLogger.getLogger(MobileInfoMQB.class.getName());
		
		public static int  QUERY_FROM_MOBILEINFO		=	1;
		public static int  QUERY_FROM_MOBILEINFO_BY_IDS =	2;

		private MobileInfoVO  mobileInfoVO;
		private ArrayList<MobileInfoVO> listMobileInfo=new ArrayList<MobileInfoVO>();
		 
		
		private int _operatorType=-1;
		private	String	ids = "";
		
		public MobileInfoMQB(int operatorType,MobileInfoVO  mobileInfoVO){
			_operatorType=operatorType;
			this.mobileInfoVO = mobileInfoVO;
			makeSql();
		}
		public MobileInfoMQB(int operatorType, String	ids) {
			_operatorType = operatorType;
			this.ids = ids;
			makeSql();
		}
		private	void	makeSql(){
			StringBuffer strsql=new StringBuffer();
																																		strsql.append("select id,name,mobile,status ");
			strsql.append(" from z_t_mobileInfo ");
			strsql.append(" where 1=1 ");	

				if (QUERY_FROM_MOBILEINFO == _operatorType) {
					if(null!=mobileInfoVO){
																					if(!StringUtils.isNullOrBlank(mobileInfoVO.getId())){
									strsql.append(" and id= ? ");
									super.addStringForField(mobileInfoVO.getId());
								}
																												if(!StringUtils.isNullOrBlank(mobileInfoVO.getName())){
									strsql.append(" and name= ? ");
									super.addStringForField(mobileInfoVO.getName());
								}
																												if(!StringUtils.isNullOrBlank(mobileInfoVO.getMobile())){
									strsql.append(" and mobile= ? ");
									super.addStringForField(mobileInfoVO.getMobile());
								}
																												if(!StringUtils.isNullOrBlank(mobileInfoVO.getStatus())){
									strsql.append(" and status= ? ");
									super.addStringForField(mobileInfoVO.getStatus());
								}
																			}
				}else if (QUERY_FROM_MOBILEINFO_BY_IDS == _operatorType) {
																		strsql.append(" and id in (?) ");
															super.addStringForField(ids);
																																																							}
			setSql(strsql.toString());
		}

		public void setSql(String sqlstr){
			this.sqlStr=sqlstr;
		}

		public String getSql(){
			return this.sqlStr;
		}
		public void getDataForRow(ResultSet rs) throws SQLException {
			mobileInfoVO=new MobileInfoVO();
							            	               	            mobileInfoVO.setId(rs.getString("id"));
														            	               	            mobileInfoVO.setName(rs.getString("name"));
														            	               	            mobileInfoVO.setMobile(rs.getString("mobile"));
														            	               	            mobileInfoVO.setStatus(rs.getString("status"));
													listMobileInfo.add(mobileInfoVO);
		}
		
		public ArrayList<MobileInfoVO> getMobileInfoList(){
			return listMobileInfo;
		}
		public MobileInfoVO getMobileInfoVO(){
			return mobileInfoVO;
		}

	}



    