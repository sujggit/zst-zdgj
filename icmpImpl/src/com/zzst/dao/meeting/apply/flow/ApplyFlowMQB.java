package com.zzst.dao.meeting.apply.flow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * class description: ApplyFlow MQB
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public class ApplyFlowMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(ApplyFlowMQB.class.getName());

	public static int QUERY_FROM_APPLYFLOW = 1;
	public static int QUERY_FROM_APPLYFLOW_BY_IDS = 2;

	private ApplyFlowVO applyFlowVO;
	private ArrayList<ApplyFlowVO> listApplyFlow = new ArrayList<ApplyFlowVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ApplyFlowMQB(int operatorType, ApplyFlowVO applyFlowVO) {
		_operatorType = operatorType;
		this.applyFlowVO = applyFlowVO;
		makeSql();
	}

	public ApplyFlowMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql
				.append("select f.*,u.loginName,u.fullName,u.email,u.mobile");
		strsql.append(" from z_t_apply_flow f,z_t_user u");
		strsql.append(" where 1=1 and f.createUserID=u.userID and u.status="+UserEnum.VALID);

		if (QUERY_FROM_APPLYFLOW == _operatorType) {
			if (null != applyFlowVO) {
				if (!StringUtils.isNullOrBlank(applyFlowVO.getFlowID())) {
					strsql.append(" and f.flowID= ? ");
					super.addStringForField(applyFlowVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(applyFlowVO.getFlowName())) {
					strsql.append(" and f.flowName like '%"+ applyFlowVO.getFlowName().trim() + "%'");
				}
				if (Integer.MIN_VALUE != applyFlowVO.getFlowType()) {
					strsql.append(" and f.flowType= ? ");
					super.addIntForField(applyFlowVO.getFlowType());
				}
				if (!StringUtils.isNullOrBlank(applyFlowVO.getCreateUserID())) {
					strsql.append(" and f.createUserID= ? ");
					super.addStringForField(applyFlowVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applyFlowVO.getStatus()) {
					strsql.append(" and f.status= ? ");
					super.addIntForField(applyFlowVO.getStatus());
				}
				if (Long.MIN_VALUE != applyFlowVO.getRevision()) {
					strsql.append(" and f.revision= ? ");
					super.addLongForField(applyFlowVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(applyFlowVO.getDescription())) {
					strsql.append(" and f.description= ? ");
					super.addStringForField(applyFlowVO.getDescription());
				}
			}
			strsql.append(" order by f.createTime desc");
		} else if (QUERY_FROM_APPLYFLOW_BY_IDS == _operatorType) {
			strsql.append(" and f.flowID in (?) ");
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
		applyFlowVO = new ApplyFlowVO();
		UserVO userVO = new UserVO();
		applyFlowVO.setFlowID(rs.getString("flowID"));
		applyFlowVO.setFlowName(rs.getString("flowName"));
		applyFlowVO.setFlowType(rs.getInt("flowType"));
		applyFlowVO.setCreateUserID(rs.getString("createUserID"));
		applyFlowVO.setCreateTime(rs.getTimestamp("createTime"));
		applyFlowVO.setUpdateTime(rs.getTimestamp("updateTime"));
		applyFlowVO.setStartTime(rs.getTimestamp("startTime"));
		applyFlowVO.setEndTime(rs.getTimestamp("endTime"));
		applyFlowVO.setStatus(rs.getInt("status"));
		applyFlowVO.setRevision(rs.getLong("revision"));
		applyFlowVO.setDescription(rs.getString("description"));
		userVO.setLoginName(rs.getString("loginName"));
		userVO.setName(rs.getString("fullName"));
		userVO.setEmail(rs.getString("email"));
		userVO.setMobile(rs.getString("mobile"));
		applyFlowVO.setUserVO(userVO);
		listApplyFlow.add(applyFlowVO);
	}

	public ArrayList<ApplyFlowVO> getApplyFlowList() {
		return listApplyFlow;
	}

	public ApplyFlowVO getApplyFlowVO() {
		return applyFlowVO;
	}

}
