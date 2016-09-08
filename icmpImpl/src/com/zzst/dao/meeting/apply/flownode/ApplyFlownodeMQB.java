package com.zzst.dao.meeting.apply.flownode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;

/**
 * class description: ApplyFlownode MQB
 * 
 * @date Tue Jul 02 12:28:39 CST 2013
 * @author ryan
 */
public class ApplyFlownodeMQB extends MasterQueryObject {
	static Logger logger = CbfLogger
			.getLogger(ApplyFlownodeMQB.class.getName());

	public static int QUERY_FROM_APPLYFLOWNODE = 1;
	public static int QUERY_FROM_APPLYFLOWNODE_BY_IDS = 2;

	private ApplyFlownodeVO applyFlownodeVO;
	private ArrayList<ApplyFlownodeVO> listApplyFlownode = new ArrayList<ApplyFlownodeVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ApplyFlownodeMQB(int operatorType, ApplyFlownodeVO applyFlownodeVO) {
		_operatorType = operatorType;
		this.applyFlownodeVO = applyFlownodeVO;
		makeSql();
	}

	public ApplyFlownodeMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select flownodeID,flowID,flownodeName,orderNum,prevOrder,nextOrder,flownodeType,userID,postNO,checkType,checkRule,createUserID,createTime,status,revision,description ");
		strsql.append(" from z_t_apply_flownode ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_APPLYFLOWNODE == _operatorType) {
			if (null != applyFlownodeVO) {
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getFlownodeID())) {
					strsql.append(" and flownodeID= ? ");
					super.addStringForField(applyFlownodeVO.getFlownodeID());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getFlowID())) {
					strsql.append(" and flowID= ? ");
					super.addStringForField(applyFlownodeVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO
						.getFlownodeName())) {
					strsql.append(" and flownodeName= ? ");
					super.addStringForField(applyFlownodeVO.getFlownodeName());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getOrderNum()) {
					strsql.append(" and orderNum= ? ");
					super.addIntForField(applyFlownodeVO.getOrderNum());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getPrevOrder()) {
					strsql.append(" and prevOrder= ? ");
					super.addIntForField(applyFlownodeVO.getPrevOrder());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getNextOrder()) {
					strsql.append(" and nextOrder= ? ");
					super.addIntForField(applyFlownodeVO.getNextOrder());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getFlownodeType()) {
					strsql.append(" and flownodeType= ? ");
					super.addIntForField(applyFlownodeVO.getFlownodeType());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getUserID())) {
					strsql.append(" and userID= ? ");
					super.addStringForField(applyFlownodeVO.getUserID());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getPostNO())) {
					strsql.append(" and postNO= ? ");
					super.addStringForField(applyFlownodeVO.getPostNO());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getCheckType()) {
					strsql.append(" and checkType= ? ");
					super.addIntForField(applyFlownodeVO.getCheckType());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getCheckRule())) {
					strsql.append(" and checkRule= ? ");
					super.addStringForField(applyFlownodeVO.getCheckRule());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO
						.getCreateUserID())) {
					strsql.append(" and createUserID= ? ");
					super.addStringForField(applyFlownodeVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(applyFlownodeVO.getStatus());
				}
				if (Long.MIN_VALUE != applyFlownodeVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(applyFlownodeVO.getRevision());
				}
				if (!StringUtils
						.isNullOrBlank(applyFlownodeVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(applyFlownodeVO.getDescription());
				}
			}
		} else if (QUERY_FROM_APPLYFLOWNODE_BY_IDS == _operatorType) {
			strsql.append(" and flownodeID in (?) ");
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
		applyFlownodeVO = new ApplyFlownodeVO();
		applyFlownodeVO.setFlownodeID(rs.getString("flownodeID"));
		applyFlownodeVO.setFlowID(rs.getString("flowID"));
		applyFlownodeVO.setFlownodeName(rs.getString("flownodeName"));
		applyFlownodeVO.setOrderNum(rs.getInt("orderNum"));
		applyFlownodeVO.setPrevOrder(rs.getInt("prevOrder"));
		applyFlownodeVO.setNextOrder(rs.getInt("nextOrder"));
		applyFlownodeVO.setFlownodeType(rs.getInt("flownodeType"));
		applyFlownodeVO.setUserID(rs.getString("userID"));
		applyFlownodeVO.setPostNO(rs.getString("postNO"));
		applyFlownodeVO.setCheckType(rs.getInt("checkType"));
		applyFlownodeVO.setCheckRule(rs.getString("checkRule"));
		applyFlownodeVO.setCreateUserID(rs.getString("createUserID"));
		applyFlownodeVO.setCreateTime(rs.getTimestamp("createTime"));
		applyFlownodeVO.setStatus(rs.getInt("status"));
		applyFlownodeVO.setRevision(rs.getLong("revision"));
		applyFlownodeVO.setDescription(rs.getString("description"));
		listApplyFlownode.add(applyFlownodeVO);
	}

	public ArrayList<ApplyFlownodeVO> getApplyFlownodeList() {
		return listApplyFlownode;
	}

	public ApplyFlownodeVO getApplyFlownodeVO() {
		return applyFlownodeVO;
	}

}
