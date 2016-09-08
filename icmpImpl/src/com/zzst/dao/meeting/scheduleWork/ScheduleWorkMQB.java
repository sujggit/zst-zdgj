



	    	            
         
        	
		
	        
        	
		
        

    
    
    package com.zzst.dao.meeting.scheduleWork;
    
	import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.scheduleWork.ScheduleWorkVO;

	/**
	 * class description:	ScheduleWork MQB
	 * @date Mon Aug 22 16:03:33 CST 2016
	 * @author ryan
	 */
	public class ScheduleWorkMQB extends MasterQueryObject {
		static Logger logger = CbfLogger.getLogger(ScheduleWorkMQB.class.getName());
		
		public static int  QUERY_FROM_SCHEDULEWORK		=	1;
		public static int  QUERY_FROM_SCHEDULEWORK_BY_IDS =	2;

		private ScheduleWorkVO  scheduleWorkVO;
		private ArrayList<ScheduleWorkVO> listScheduleWork=new ArrayList<ScheduleWorkVO>();
		 
		
		private int _operatorType=-1;
		private	String	ids = "";
		
		public ScheduleWorkMQB(int operatorType,ScheduleWorkVO  scheduleWorkVO){
			_operatorType=operatorType;
			this.scheduleWorkVO = scheduleWorkVO;
			makeSql();
		}
		public ScheduleWorkMQB(int operatorType, String	ids) {
			_operatorType = operatorType;
			this.ids = ids;
			makeSql();
		}
		private	void	makeSql(){
			StringBuffer strsql=new StringBuffer();
																													strsql.append("select workId,workName,status ");
			strsql.append(" from z_t_schedule_work ");
			strsql.append(" where 1=1 ");	

				if (QUERY_FROM_SCHEDULEWORK == _operatorType) {
					if(null!=scheduleWorkVO){
																					if(!StringUtils.isNullOrBlank(scheduleWorkVO.getWorkId())){
									strsql.append(" and workId= ? ");
									super.addStringForField(scheduleWorkVO.getWorkId());
								}
																												if(!StringUtils.isNullOrBlank(scheduleWorkVO.getWorkName())){
									strsql.append(" and workName= ? ");
									super.addStringForField(scheduleWorkVO.getWorkName());
								}
																												if(!StringUtils.isNullOrBlank(scheduleWorkVO.getStatus())){
									strsql.append(" and status= ? ");
									super.addStringForField(scheduleWorkVO.getStatus());
								}
																			}
				}else if (QUERY_FROM_SCHEDULEWORK_BY_IDS == _operatorType) {
																		strsql.append(" and workId in (?) ");
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
			scheduleWorkVO=new ScheduleWorkVO();
							            	               	            scheduleWorkVO.setWorkId(rs.getString("workId"));
														            	               	            scheduleWorkVO.setWorkName(rs.getString("workName"));
														            	               	            scheduleWorkVO.setStatus(rs.getString("status"));
													listScheduleWork.add(scheduleWorkVO);
		}
		
		public ArrayList<ScheduleWorkVO> getScheduleWorkList(){
			return listScheduleWork;
		}
		public ScheduleWorkVO getScheduleWorkVO(){
			return scheduleWorkVO;
		}

	}



    