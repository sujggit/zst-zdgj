 package com.zzst.dao.meeting.informationUser;
    
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import org.apache.log4j.Logger;
	import com.cbf.db.MasterQueryObject;
	import com.cbf.log.CbfLogger;
	import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.informationUser.InformationUserVO;

	/**
	 * class description:	InformationUser MQB
	 * @date Tue Jan 29 18:25:43 CST 2013
	 * @author ryan
	 */
	public class InformationUserMQB extends MasterQueryObject {
		static Logger logger = CbfLogger.getLogger(InformationUserMQB.class.getName());
		
		public static int  QUERY_FROM_INFORMATIONUSER		=	1;
		public static int  QUERY_FROM_INFORMATIONUSER_BY_IDS =	2;

		private InformationUserVO  informationUserVO;
		private ArrayList<InformationUserVO> listInformationUser=new ArrayList<InformationUserVO>();
		 
		
		private int _operatorType=-1;
		private	String	ids = "";
		
		public InformationUserMQB(int operatorType,InformationUserVO  informationUserVO){
			_operatorType=operatorType;
			this.informationUserVO = informationUserVO;
			makeSql();
		}
		public InformationUserMQB(int operatorType, String	ids) {
			_operatorType = operatorType;
			this.ids = ids;
			makeSql();
		}
		private	void	makeSql(){
			StringBuffer strsql=new StringBuffer();
																																							strsql.append("select infoID,disposeUserID,disposeTime,status,description ");
			strsql.append(" from z_t_information_user ");
			strsql.append(" where 1=1 ");	

				if (QUERY_FROM_INFORMATIONUSER == _operatorType) {
					if(null!=informationUserVO){
																					if(!StringUtils.isNullOrBlank(informationUserVO.getInfoID())){
									strsql.append(" and infoID= ? ");
									super.addStringForField(informationUserVO.getInfoID());
								}
																												if(!StringUtils.isNullOrBlank(informationUserVO.getDisposeUserID())){
									strsql.append(" and disposeUserID= ? ");
									super.addStringForField(informationUserVO.getDisposeUserID());
								}
																																									if(Integer.MIN_VALUE!=informationUserVO.getStatus()){
									strsql.append(" and status= ? ");
									super.addIntForField(informationUserVO.getStatus());
								}
																												if(!StringUtils.isNullOrBlank(informationUserVO.getDescription())){
									strsql.append(" and description= ? ");
									super.addStringForField(informationUserVO.getDescription());
								}
																			}
				}else if (QUERY_FROM_INFORMATIONUSER_BY_IDS == _operatorType) {
																		strsql.append(" and infoID in (?) ");
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
			informationUserVO=new InformationUserVO();
							            	               	            informationUserVO.setInfoID(rs.getString("infoID"));
														            	               	            informationUserVO.setDisposeUserID(rs.getString("disposeUserID"));
														            								informationUserVO.setDisposeTime(rs.getTimestamp("disposeTime"));
														            								informationUserVO.setStatus(rs.getInt("status"));
				            							            	               	            informationUserVO.setDescription(rs.getString("description"));
													listInformationUser.add(informationUserVO);
		}
		
		public ArrayList<InformationUserVO> getInformationUserList(){
			return listInformationUser;
		}
		public InformationUserVO getInformationUserVO(){
			return informationUserVO;
		}

	}



    