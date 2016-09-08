package com.zzst.dao.meeting.comparison;

 
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import org.apache.log4j.Logger;
	import com.cbf.db.MasterQueryObject;
	import com.cbf.log.CbfLogger;
	import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;

	/**
	 * class description:	ComparisonCriteria MQB
	 * @date Fri Apr 26 16:04:41 CST 2013
	 * @author ryan
	 */
	public class ComparisonCriteriaMQB extends MasterQueryObject {
		static Logger logger = CbfLogger.getLogger(ComparisonCriteriaMQB.class.getName());
		
		public static int  QUERY_FROM_COMPARISONCRITERIA		=	1;
		public static int  QUERY_FROM_COMPARISONCRITERIA_BY_IDS =	2;

		private ComparisonCriteriaVO  comparisonCriteriaVO;
	private ArrayList<ComparisonCriteriaVO> listComparisonCriteria=new ArrayList<ComparisonCriteriaVO>();
		 
		
		private int _operatorType=-1;
		private	String	ids = "";
		
		public ComparisonCriteriaMQB(int operatorType,ComparisonCriteriaVO  comparisonCriteriaVO){
			_operatorType=operatorType;
			this.comparisonCriteriaVO = comparisonCriteriaVO;
			makeSql();
		}
		public ComparisonCriteriaMQB(int operatorType, String	ids) {
			_operatorType = operatorType;
			this.ids = ids;
			makeSql();
		}
		private	void	makeSql(){
			StringBuffer strsql=new StringBuffer();
																																																																																																													strsql.append("select ComCriteriaID,rsGap_Good_lower,rsGap_Good_upper,rsGap_Ok_lower,rsGap_Ok_upper,gsGap_Good_lower,gsGap_Good_upper,gsGap_Ok_lower,gsGap_Ok_upper,bsGap_Good_lower,bsGap_Good_upper,bsGap_Ok_lower,bsGap_Ok_upper,x_min,x_max,updateUserID,updateTime,description,revision ");
			strsql.append(" from Z_T_COMPARISON_CRITERIA ");
			strsql.append(" where 1=1 ");	

				if (QUERY_FROM_COMPARISONCRITERIA == _operatorType) {
					if(null!=comparisonCriteriaVO){
																					if(!StringUtils.isNullOrBlank(comparisonCriteriaVO.getComCriteriaID())){
									strsql.append(" and ComCriteriaID= ? ");
									super.addStringForField(comparisonCriteriaVO.getComCriteriaID());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getRsGap_Good_lower()){
									strsql.append(" and rsGap_Good_lower= ? ");
									super.addIntForField(comparisonCriteriaVO.getRsGap_Good_lower());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getRsGap_Good_upper()){
									strsql.append(" and rsGap_Good_upper= ? ");
									super.addIntForField(comparisonCriteriaVO.getRsGap_Good_upper());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getRsGap_Ok_lower()){
									strsql.append(" and rsGap_Ok_lower= ? ");
									super.addIntForField(comparisonCriteriaVO.getRsGap_Ok_lower());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getRsGap_Ok_upper()){
									strsql.append(" and rsGap_Ok_upper= ? ");
									super.addIntForField(comparisonCriteriaVO.getRsGap_Ok_upper());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getGsGap_Good_lower()){
									strsql.append(" and gsGap_Good_lower= ? ");
									super.addIntForField(comparisonCriteriaVO.getGsGap_Good_lower());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getGsGap_Good_upper()){
									strsql.append(" and gsGap_Good_upper= ? ");
									super.addIntForField(comparisonCriteriaVO.getGsGap_Good_upper());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getGsGap_Ok_lower()){
									strsql.append(" and gsGap_Ok_lower= ? ");
									super.addIntForField(comparisonCriteriaVO.getGsGap_Ok_lower());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getGsGap_Ok_upper()){
									strsql.append(" and gsGap_Ok_upper= ? ");
									super.addIntForField(comparisonCriteriaVO.getGsGap_Ok_upper());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getBsGap_Good_lower()){
									strsql.append(" and bsGap_Good_lower= ? ");
									super.addIntForField(comparisonCriteriaVO.getBsGap_Good_lower());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getBsGap_Good_upper()){
									strsql.append(" and bsGap_Good_upper= ? ");
									super.addIntForField(comparisonCriteriaVO.getBsGap_Good_upper());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getBsGap_Ok_lower()){
									strsql.append(" and bsGap_Ok_lower= ? ");
									super.addIntForField(comparisonCriteriaVO.getBsGap_Ok_lower());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getBsGap_Ok_upper()){
									strsql.append(" and bsGap_Ok_upper= ? ");
									super.addIntForField(comparisonCriteriaVO.getBsGap_Ok_upper());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getX_min()){
									strsql.append(" and x_min= ? ");
									super.addIntForField(comparisonCriteriaVO.getX_min());
								}
																												if(Integer.MIN_VALUE!=comparisonCriteriaVO.getX_max()){
									strsql.append(" and x_max= ? ");
									super.addIntForField(comparisonCriteriaVO.getX_max());
								}
																												if(!StringUtils.isNullOrBlank(comparisonCriteriaVO.getUpdateUserID())){
									strsql.append(" and updateUserID= ? ");
									super.addStringForField(comparisonCriteriaVO.getUpdateUserID());
								}
																																									if(!StringUtils.isNullOrBlank(comparisonCriteriaVO.getDescription())){
									strsql.append(" and description= ? ");
									super.addStringForField(comparisonCriteriaVO.getDescription());
								}
																												if(Long.MIN_VALUE != comparisonCriteriaVO.getRevision()){
									strsql.append(" and revision= ? ");
									super.addLongForField(comparisonCriteriaVO.getRevision());
								}
																			}
				}else if (QUERY_FROM_COMPARISONCRITERIA_BY_IDS == _operatorType) {
																		strsql.append(" and ComCriteriaID in (?) ");
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
			comparisonCriteriaVO=new ComparisonCriteriaVO();
							            	               	            comparisonCriteriaVO.setComCriteriaID(rs.getString("ComCriteriaID"));
														            								comparisonCriteriaVO.setRsGap_Good_lower(rs.getInt("rsGap_Good_lower"));
				            							            								comparisonCriteriaVO.setRsGap_Good_upper(rs.getInt("rsGap_Good_upper"));
				            							            								comparisonCriteriaVO.setRsGap_Ok_lower(rs.getInt("rsGap_Ok_lower"));
				            							            								comparisonCriteriaVO.setRsGap_Ok_upper(rs.getInt("rsGap_Ok_upper"));
				            							            								comparisonCriteriaVO.setGsGap_Good_lower(rs.getInt("gsGap_Good_lower"));
				            							            								comparisonCriteriaVO.setGsGap_Good_upper(rs.getInt("gsGap_Good_upper"));
				            							            								comparisonCriteriaVO.setGsGap_Ok_lower(rs.getInt("gsGap_Ok_lower"));
				            							            								comparisonCriteriaVO.setGsGap_Ok_upper(rs.getInt("gsGap_Ok_upper"));
				            							            								comparisonCriteriaVO.setBsGap_Good_lower(rs.getInt("bsGap_Good_lower"));
				            							            								comparisonCriteriaVO.setBsGap_Good_upper(rs.getInt("bsGap_Good_upper"));
				            							            								comparisonCriteriaVO.setBsGap_Ok_lower(rs.getInt("bsGap_Ok_lower"));
				            							            								comparisonCriteriaVO.setBsGap_Ok_upper(rs.getInt("bsGap_Ok_upper"));
				            							            								comparisonCriteriaVO.setX_min(rs.getInt("x_min"));
				            							            								comparisonCriteriaVO.setX_max(rs.getInt("x_max"));
				            							            	               	            comparisonCriteriaVO.setUpdateUserID(rs.getString("updateUserID"));
														            								comparisonCriteriaVO.setUpdateTime(rs.getTimestamp("updateTime"));
														            	               	            comparisonCriteriaVO.setDescription(rs.getString("description"));
														            								comparisonCriteriaVO.setRevision(rs.getLong("revision"));
													listComparisonCriteria.add(comparisonCriteriaVO);
		}
		
		public ArrayList<ComparisonCriteriaVO> getComparisonCriteriaList(){
			return listComparisonCriteria;
		}
		public ComparisonCriteriaVO getComparisonCriteriaVO(){
			return comparisonCriteriaVO;
		}

	}



    