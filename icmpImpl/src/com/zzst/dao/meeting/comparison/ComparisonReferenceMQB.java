package com.zzst.dao.meeting.comparison;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;

/**
 * class description: ComparisonReference MQB
 * 
 * @date Sat Apr 27 11:12:39 CST 2013
 * @author ryan
 */
public class ComparisonReferenceMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ComparisonReferenceMQB.class
			.getName());

	public static int QUERY_FROM_COMPARISONREFERENCE = 1;
	public static int QUERY_FROM_COMPARISONREFERENCE_BY_IDS = 2;

	private ComparisonReferenceVO comparisonReferenceVO;
	private ArrayList<ComparisonReferenceVO> listComparisonReference = new ArrayList<ComparisonReferenceVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ComparisonReferenceMQB(int operatorType,
			ComparisonReferenceVO comparisonReferenceVO) {
		_operatorType = operatorType;
		this.comparisonReferenceVO = comparisonReferenceVO;
		makeSql();
	}

	public ComparisonReferenceMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
		.append("select ID,meetingRoomID,R_Pr,G_Y,B_Pb,rIndex,gIndex,bIndex,S_R,S_G,S_B,x_min,x_max,type,updateTime,updateUserID,status,description ");
		strsql.append(" from Z_T_COMPARISON_REFERENCE ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_COMPARISONREFERENCE == _operatorType) {
			if (null != comparisonReferenceVO) {
				if (!StringUtils.isNullOrBlank(comparisonReferenceVO.getID())) {
					strsql.append(" and ID= ? ");
					super.addStringForField(comparisonReferenceVO.getID());
				}
				if (!StringUtils.isNullOrBlank(comparisonReferenceVO
						.getMeetingRoomID())) {
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(comparisonReferenceVO
							.getMeetingRoomID());
				}
				if (!StringUtils.isNullOrBlank(comparisonReferenceVO.getR_Pr())) {
					strsql.append(" and R_Pr= ? ");
					super.addStringForField(comparisonReferenceVO.getR_Pr());
				}
				if (!StringUtils.isNullOrBlank(comparisonReferenceVO.getG_Y())) {
					strsql.append(" and G_Y= ? ");
					super.addStringForField(comparisonReferenceVO.getG_Y());
				}
				if (!StringUtils.isNullOrBlank(comparisonReferenceVO.getB_Pb())) {
					strsql.append(" and B_Pb= ? ");
					super.addStringForField(comparisonReferenceVO.getB_Pb());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getRIndex()) {
					strsql.append(" and rIndex= ? ");
					super.addIntForField(comparisonReferenceVO.getRIndex());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getGIndex()) {
					strsql.append(" and gIndex= ? ");
					super.addIntForField(comparisonReferenceVO.getGIndex());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getBIndex()) {
					strsql.append(" and bIndex= ? ");
					super.addIntForField(comparisonReferenceVO.getBIndex());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getS_R()) {
					strsql.append(" and S_R= ? ");
					super.addIntForField(comparisonReferenceVO.getS_R());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getS_G()) {
					strsql.append(" and S_G= ? ");
					super.addIntForField(comparisonReferenceVO.getS_G());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getS_B()) {
					strsql.append(" and S_B= ? ");
					super.addIntForField(comparisonReferenceVO.getS_B());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getX_min()) {
					strsql.append(" and x_min= ? ");
					super.addIntForField(comparisonReferenceVO.getX_min());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getX_max()) {
					strsql.append(" and x_max= ? ");
					super.addIntForField(comparisonReferenceVO.getX_max());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getType()) {
					strsql.append(" and type= ? ");
					super.addIntForField(comparisonReferenceVO.getType());
				}
				if (!StringUtils.isNullOrBlank(comparisonReferenceVO
						.getUpdateUserID())) {
					strsql.append(" and updateUserID= ? ");
					super.addStringForField(comparisonReferenceVO
							.getUpdateUserID());
				}
				if (Integer.MIN_VALUE != comparisonReferenceVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(comparisonReferenceVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(comparisonReferenceVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(comparisonReferenceVO
							.getDescription());
				}
			}
		} else if (QUERY_FROM_COMPARISONREFERENCE_BY_IDS == _operatorType) {
			strsql.append(" and ID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		comparisonReferenceVO = new ComparisonReferenceVO();
		comparisonReferenceVO.setID(rs.getString("ID"));
		comparisonReferenceVO.setMeetingRoomID(rs.getString("meetingRoomID"));
		comparisonReferenceVO.setR_Pr(rs.getString("R_Pr"));
		comparisonReferenceVO.setG_Y(rs.getString("G_Y"));
		comparisonReferenceVO.setB_Pb(rs.getString("B_Pb"));
		comparisonReferenceVO.setRIndex(rs.getInt("rIndex"));
		comparisonReferenceVO.setGIndex(rs.getInt("gIndex"));
		comparisonReferenceVO.setBIndex(rs.getInt("bIndex"));
		comparisonReferenceVO.setS_R(rs.getInt("S_R"));
		comparisonReferenceVO.setS_G(rs.getInt("S_G"));
		comparisonReferenceVO.setS_B(rs.getInt("S_B"));
		comparisonReferenceVO.setX_min(rs.getInt("x_min"));
		comparisonReferenceVO.setX_max(rs.getInt("x_max"));
		comparisonReferenceVO.setType(rs.getInt("type"));
		comparisonReferenceVO.setUpdateTime(rs.getTimestamp("updateTime"));
		comparisonReferenceVO.setUpdateUserID(rs.getString("updateUserID"));
		comparisonReferenceVO.setStatus(rs.getInt("status"));
		comparisonReferenceVO.setDescription(rs.getString("description"));
		listComparisonReference.add(comparisonReferenceVO);
	}

	public ArrayList<ComparisonReferenceVO> getComparisonReferenceList() {
		return listComparisonReference;
	}

	public ComparisonReferenceVO getComparisonReferenceVO() {
		return comparisonReferenceVO;
	}

}
