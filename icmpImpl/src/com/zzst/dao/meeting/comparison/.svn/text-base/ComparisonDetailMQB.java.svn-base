package com.zzst.dao.meeting.comparison;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;

/**
 * class description:	ComparisonDetail MQB
 * @date Sun Apr 28 13:09:54 CST 2013
 * @author ryan
 */
public class ComparisonDetailMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ComparisonDetailMQB.class.getName());

	public static int  QUERY_FROM_COMPARISONDETAIL		=	1;
	public static int  QUERY_FROM_COMPARISONDETAIL_BY_IDS =	2;

	private ComparisonDetailVO  comparisonDetailVO;
	private ArrayList<ComparisonDetailVO> listComparisonDetail=new ArrayList<ComparisonDetailVO>();


	private int _operatorType=-1;
	private	String	ids = "";

	public ComparisonDetailMQB(int operatorType,ComparisonDetailVO  comparisonDetailVO){
		_operatorType=operatorType;
		this.comparisonDetailVO = comparisonDetailVO;
		makeSql();
	}
	public ComparisonDetailMQB(int operatorType, String	ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	private	void	makeSql(){
		StringBuffer strsql=new StringBuffer();
		strsql.append("select ID,R_Pr,G_Y,B_Pb,uplinkR_Pr,uplinkG_Y,uplinkB_Pb,S_R,S_R_gap,S_R_result,S_G,S_G_gap,S_G_result,S_B,S_B_gap,S_B_result,uplinkS_R,uplinkS_R_gap,uplinkS_R_result,uplinkS_G,uplinkS_G_gap,uplinkS_G_result,uplinkS_B,uplinkS_B_gap,uplinkS_B_result,type,updateTime,updateUserID,status,description ");
		strsql.append(" from Z_T_MEETING_COMPARISON_DETAIL ");
		strsql.append(" where 1=1 ");	

		if (QUERY_FROM_COMPARISONDETAIL == _operatorType) {
			if(null!=comparisonDetailVO){
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getID())){
					strsql.append(" and ID= ? ");
					super.addStringForField(comparisonDetailVO.getID());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getR_Pr())){
					strsql.append(" and R_Pr= ? ");
					super.addStringForField(comparisonDetailVO.getR_Pr());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getG_Y())){
					strsql.append(" and G_Y= ? ");
					super.addStringForField(comparisonDetailVO.getG_Y());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getB_Pb())){
					strsql.append(" and B_Pb= ? ");
					super.addStringForField(comparisonDetailVO.getB_Pb());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getUplinkR_Pr())){
					strsql.append(" and uplinkR_Pr= ? ");
					super.addStringForField(comparisonDetailVO.getUplinkR_Pr());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getUplinkG_Y())){
					strsql.append(" and uplinkG_Y= ? ");
					super.addStringForField(comparisonDetailVO.getUplinkG_Y());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getUplinkB_Pb())){
					strsql.append(" and uplinkB_Pb= ? ");
					super.addStringForField(comparisonDetailVO.getUplinkB_Pb());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getS_R()){
					strsql.append(" and S_R= ? ");
					super.addIntForField(comparisonDetailVO.getS_R());
				}
				if(Float.MIN_VALUE!=comparisonDetailVO.getS_R_gap()){
					strsql.append(" and S_R_gap= ? ");
					super.addFloatForField(comparisonDetailVO.getS_R_gap());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getS_R_result()){
					strsql.append(" and S_R_result= ? ");
					super.addIntForField(comparisonDetailVO.getS_R_result());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getS_G()){
					strsql.append(" and S_G= ? ");
					super.addIntForField(comparisonDetailVO.getS_G());
				}
				if(Float.MIN_VALUE!=comparisonDetailVO.getS_G_gap()){
					strsql.append(" and S_G_gap= ? ");
					super.addFloatForField(comparisonDetailVO.getS_G_gap());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getS_G_result()){
					strsql.append(" and S_G_result= ? ");
					super.addIntForField(comparisonDetailVO.getS_G_result());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getS_B()){
					strsql.append(" and S_B= ? ");
					super.addIntForField(comparisonDetailVO.getS_B());
				}
				if(Float.MIN_VALUE!=comparisonDetailVO.getS_B_gap()){
					strsql.append(" and S_B_gap= ? ");
					super.addFloatForField(comparisonDetailVO.getS_B_gap());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getS_B_result()){
					strsql.append(" and S_B_result= ? ");
					super.addIntForField(comparisonDetailVO.getS_B_result());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getUplinkS_R()){
					strsql.append(" and uplinkS_R= ? ");
					super.addIntForField(comparisonDetailVO.getUplinkS_R());
				}
				if(Float.MIN_VALUE!=comparisonDetailVO.getUplinkS_R_gap()){
					strsql.append(" and uplinkS_R_gap= ? ");
					super.addFloatForField(comparisonDetailVO.getUplinkS_R_gap());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getUplinkS_R_result()){
					strsql.append(" and uplinkS_R_result= ? ");
					super.addIntForField(comparisonDetailVO.getUplinkS_R_result());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getUplinkS_G()){
					strsql.append(" and uplinkS_G= ? ");
					super.addIntForField(comparisonDetailVO.getUplinkS_G());
				}
				if(Float.MIN_VALUE!=comparisonDetailVO.getUplinkS_G_gap()){
					strsql.append(" and uplinkS_G_gap= ? ");
					super.addFloatForField(comparisonDetailVO.getUplinkS_G_gap());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getUplinkS_G_result()){
					strsql.append(" and uplinkS_G_result= ? ");
					super.addIntForField(comparisonDetailVO.getUplinkS_G_result());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getUplinkS_B()){
					strsql.append(" and uplinkS_B= ? ");
					super.addIntForField(comparisonDetailVO.getUplinkS_B());
				}
				if(Float.MIN_VALUE!=comparisonDetailVO.getUplinkS_B_gap()){
					strsql.append(" and uplinkS_B_gap= ? ");
					super.addFloatForField(comparisonDetailVO.getUplinkS_B_gap());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getUplinkS_B_result()){
					strsql.append(" and uplinkS_B_result= ? ");
					super.addIntForField(comparisonDetailVO.getUplinkS_B_result());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getType()){
					strsql.append(" and type= ? ");
					super.addIntForField(comparisonDetailVO.getType());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getUpdateUserID())){
					strsql.append(" and updateUserID= ? ");
					super.addStringForField(comparisonDetailVO.getUpdateUserID());
				}
				if(Integer.MIN_VALUE!=comparisonDetailVO.getStatus()){
					strsql.append(" and status= ? ");
					super.addIntForField(comparisonDetailVO.getStatus());
				}
				if(!StringUtils.isNullOrBlank(comparisonDetailVO.getDescription())){
					strsql.append(" and description= ? ");
					super.addStringForField(comparisonDetailVO.getDescription());
				}
			}
		}else if (QUERY_FROM_COMPARISONDETAIL_BY_IDS == _operatorType) {
			strsql.append(" and ID in (?) ");
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
		comparisonDetailVO=new ComparisonDetailVO();
		comparisonDetailVO.setID(rs.getString("ID"));
		comparisonDetailVO.setR_Pr(rs.getString("R_Pr"));
		comparisonDetailVO.setG_Y(rs.getString("G_Y"));
		comparisonDetailVO.setB_Pb(rs.getString("B_Pb"));
		comparisonDetailVO.setUplinkR_Pr(rs.getString("uplinkR_Pr"));
		comparisonDetailVO.setUplinkG_Y(rs.getString("uplinkG_Y"));
		comparisonDetailVO.setUplinkB_Pb(rs.getString("uplinkB_Pb"));
		comparisonDetailVO.setS_R(rs.getInt("S_R"));
		comparisonDetailVO.setS_R_gap(rs.getFloat("S_R_gap"));
		comparisonDetailVO.setS_R_result(rs.getInt("S_R_result"));
		comparisonDetailVO.setS_G(rs.getInt("S_G"));
		comparisonDetailVO.setS_G_gap(rs.getFloat("S_G_gap"));
		comparisonDetailVO.setS_G_result(rs.getInt("S_G_result"));
		comparisonDetailVO.setS_B(rs.getInt("S_B"));
		comparisonDetailVO.setS_B_gap(rs.getFloat("S_B_gap"));
		comparisonDetailVO.setS_B_result(rs.getInt("S_B_result"));
		comparisonDetailVO.setUplinkS_R(rs.getInt("uplinkS_R"));
		comparisonDetailVO.setUplinkS_R_gap(rs.getFloat("uplinkS_R_gap"));
		comparisonDetailVO.setUplinkS_R_result(rs.getInt("uplinkS_R_result"));
		comparisonDetailVO.setUplinkS_G(rs.getInt("uplinkS_G"));
		comparisonDetailVO.setUplinkS_G_gap(rs.getFloat("uplinkS_G_gap"));
		comparisonDetailVO.setUplinkS_G_result(rs.getInt("uplinkS_G_result"));
		comparisonDetailVO.setUplinkS_B(rs.getInt("uplinkS_B"));
		comparisonDetailVO.setUplinkS_B_gap(rs.getFloat("uplinkS_B_gap"));
		comparisonDetailVO.setUplinkS_B_result(rs.getInt("uplinkS_B_result"));
		comparisonDetailVO.setType(rs.getInt("type"));
		comparisonDetailVO.setUpdateTime(rs.getTimestamp("updateTime"));
		comparisonDetailVO.setUpdateUserID(rs.getString("updateUserID"));
		comparisonDetailVO.setStatus(rs.getInt("status"));
		comparisonDetailVO.setDescription(rs.getString("description"));
		listComparisonDetail.add(comparisonDetailVO);
	}

	public ArrayList<ComparisonDetailVO> getComparisonDetailList(){
		return listComparisonDetail;
	}
	public ComparisonDetailVO getComparisonDetailVO(){
		return comparisonDetailVO;
	}

}



