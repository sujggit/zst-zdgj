package com.zzst.dao.meeting.apply.applyDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;

/**
 * class description: ApplyDetail MQB
 * 
 * @date Tue Jul 02 12:22:34 CST 2013
 * @author ryan
 */
public class ApplyDetailMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ApplyDetailMQB.class.getName());

	public static int QUERY_FROM_APPLYDETAIL = 1;
	public static int QUERY_FROM_APPLYDETAIL_BY_IDS = 2;

	private ApplyDetailVO applyDetailVO;
	private ArrayList<ApplyDetailVO> listApplyDetail = new ArrayList<ApplyDetailVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ApplyDetailMQB(int operatorType, ApplyDetailVO applyDetailVO) {
		_operatorType = operatorType;
		this.applyDetailVO = applyDetailVO;
		makeSql();
	}

	public ApplyDetailMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select detailID,flowID,flownodeID,flownodeName,applyDetailID,flowType,checkType,orderNum,checkUserIDs,userID,suggestion,createTime,status,revision,description ");
		strsql.append(" from z_t_apply_detail ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_APPLYDETAIL == _operatorType) {
			if (null != applyDetailVO) {
				if (!StringUtils.isNullOrBlank(applyDetailVO.getDetailID())) {
					strsql.append(" and detailID= ? ");
					super.addStringForField(applyDetailVO.getDetailID());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getFlowID())) {
					strsql.append(" and flowID= ? ");
					super.addStringForField(applyDetailVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getFlownodeID())) {
					strsql.append(" and flownodeName= ? ");
					super.addStringForField(applyDetailVO.getFlownodeName());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getFlownodeName())) {
					strsql.append(" and flownodeID= ? ");
					super.addStringForField(applyDetailVO.getFlownodeID());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getApplyDetailID())) {
					strsql.append(" and applyDetailID= ? ");
					super.addStringForField(applyDetailVO.getApplyDetailID());
				}
				if (Integer.MIN_VALUE != applyDetailVO.getFlowType()) {
					strsql.append(" and flowType= ? ");
					super.addIntForField(applyDetailVO.getFlowType());
				}
				if (Integer.MIN_VALUE != applyDetailVO.getCheckType()) {
					strsql.append(" and checkType= ? ");
					super.addIntForField(applyDetailVO.getCheckType());
				}
				if (Integer.MIN_VALUE != applyDetailVO.getOrderNum()) {
					strsql.append(" and orderNum= ? ");
					super.addIntForField(applyDetailVO.getOrderNum());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getCheckUserIDs())) {
					strsql.append(" and checkUserIDs= ? ");
					super.addStringForField(applyDetailVO.getCheckUserIDs());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getUserID())) {
					strsql.append(" and userID= ? ");
					super.addStringForField(applyDetailVO.getUserID());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getSuggestion())) {
					strsql.append(" and suggestion= ? ");
					super.addStringForField(applyDetailVO.getSuggestion());
				}
				if (Integer.MIN_VALUE != applyDetailVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(applyDetailVO.getStatus());
				}
				if (Long.MIN_VALUE != applyDetailVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(applyDetailVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyDetailVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(applyDetailVO.getDescription());
				}
			}
		} else if (QUERY_FROM_APPLYDETAIL_BY_IDS == _operatorType) {
			strsql.append(" and detailID in (?) ");
			super.addStringForField(ids);
		}
		strsql.append(" order by flowID,orderNum,createTime");
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		applyDetailVO = new ApplyDetailVO();
		applyDetailVO.setDetailID(rs.getString("detailID"));
		applyDetailVO.setFlowID(rs.getString("flowID"));
		applyDetailVO.setFlownodeID(rs.getString("flownodeID"));
		applyDetailVO.setFlownodeName(rs.getString("flownodeName"));
		applyDetailVO.setApplyDetailID(rs.getString("applyDetailID"));
		applyDetailVO.setFlowType(rs.getInt("flowType"));
		applyDetailVO.setCheckType(rs.getInt("checkType"));
		applyDetailVO.setOrderNum(rs.getInt("orderNum"));
		applyDetailVO.setCheckUserIDs(rs.getString("checkUserIDs"));
		applyDetailVO.setUserID(rs.getString("userID"));
		applyDetailVO.setSuggestion(rs.getString("suggestion"));
		applyDetailVO.setCreateTime(rs.getTimestamp("createTime"));
		applyDetailVO.setStatus(rs.getInt("status"));
		applyDetailVO.setRevision(rs.getLong("revision"));
		applyDetailVO.setDescription(rs.getString("description"));
		listApplyDetail.add(applyDetailVO);
	}

	public ArrayList<ApplyDetailVO> getApplyDetailList() {
		return listApplyDetail;
	}

	public ApplyDetailVO getApplyDetailVO() {
		return applyDetailVO;
	}

}
