package com.zzst.dao.meeting.apply.flownode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;

/**
 * class description: ApplyFlownode MQB
 * 
 * @date Tue Jul 02 12:28:39 CST 2013
 * @author ryan
 */
public class ApplyFlownodeMQB1 extends MasterQueryObject {
	public static final int QUERY_FROM_APPLYFLOWNODE_APPLYFLOW = 0;

	static Logger logger = CbfLogger
			.getLogger(ApplyFlownodeMQB.class.getName());

	private ApplyFlownodeVO applyFlownodeVO;
	private ArrayList<ApplyFlownodeVO> listApplyFlownode = new ArrayList<ApplyFlownodeVO>();

	private int _operatorType = -1;
	private String ids = "";

	public ApplyFlownodeMQB1(int operatorType, ApplyFlownodeVO applyFlownodeVO) {
		_operatorType = operatorType;
		this.applyFlownodeVO = applyFlownodeVO;
		makeSql();
	}

	public ApplyFlownodeMQB1(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select fn.*,f.flowName,f.flowType,f.createTime fCreateTime");
		strsql.append(" from z_t_apply_flownode fn,z_t_apply_flow f");
		strsql.append(" where 1=1 and fn.flowID=f.flowID ");

		if (QUERY_FROM_APPLYFLOWNODE_APPLYFLOW == _operatorType) {
			if (null != applyFlownodeVO) {
				//重要字段，判断流程的是否启用status
				if (Integer.MIN_VALUE != applyFlownodeVO.getApplyFlowVO().getStatus()) {
					strsql.append(" and f.status= ? ");
					super.addIntForField(applyFlownodeVO.getApplyFlowVO().getStatus());
				}
				//重要字段，判断属于哪种流程类型flowType
				if (Integer.MIN_VALUE != applyFlownodeVO.getApplyFlowVO().getFlowType()) {
					strsql.append(" and f.flowType= ? ");
					super.addIntForField(applyFlownodeVO.getApplyFlowVO().getFlowType());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getApplyFlowVO().getFlowName())) {
					strsql.append(" and f.flowName= ? ");
					super.addStringForField(applyFlownodeVO.getApplyFlowVO().getFlowName());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getFlownodeID())) {
					strsql.append(" and fn.flownodeID= ? ");
					super.addStringForField(applyFlownodeVO.getFlownodeID());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getFlowID())) {
					strsql.append(" and fn.flowID= ? ");
					super.addStringForField(applyFlownodeVO.getFlowID());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO
						.getFlownodeName())) {
					strsql.append(" and fn.flownodeName= ? ");
					super.addStringForField(applyFlownodeVO.getFlownodeName());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getOrderNum()) {
					strsql.append(" and fn.orderNum= ? ");
					super.addIntForField(applyFlownodeVO.getOrderNum());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getPrevOrder()) {
					strsql.append(" and fn.prevOrder= ? ");
					super.addIntForField(applyFlownodeVO.getPrevOrder());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getNextOrder()) {
					strsql.append(" and fn.nextOrder= ? ");
					super.addIntForField(applyFlownodeVO.getNextOrder());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getFlownodeType()) {
					strsql.append(" and fn.flownodeType= ? ");
					super.addIntForField(applyFlownodeVO.getFlownodeType());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getUserID())) {
					strsql.append(" and fn.userID= ? ");
					super.addStringForField(applyFlownodeVO.getUserID());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getPostNO())) {
					strsql.append(" and fn.postNO= ? ");
					super.addStringForField(applyFlownodeVO.getPostNO());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getCheckType()) {
					strsql.append(" and fn.checkType= ? ");
					super.addIntForField(applyFlownodeVO.getCheckType());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO.getCheckRule())) {
					strsql.append(" and checkRule= ? ");
					super.addStringForField(applyFlownodeVO.getCheckRule());
				}
				if (!StringUtils.isNullOrBlank(applyFlownodeVO
						.getCreateUserID())) {
					strsql.append(" and fn.createUserID= ? ");
					super.addStringForField(applyFlownodeVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != applyFlownodeVO.getStatus()) {
					strsql.append(" and fn.status= ? ");
					super.addIntForField(applyFlownodeVO.getStatus());
				}
				if (Long.MIN_VALUE != applyFlownodeVO.getRevision()) {
					strsql.append(" and fn.revision= ? ");
					super.addLongForField(applyFlownodeVO.getRevision());
				}
				if (!StringUtils
						.isNullOrBlank(applyFlownodeVO.getDescription())) {
					strsql.append(" and fn.description= ? ");
					super.addStringForField(applyFlownodeVO.getDescription());
				}
				strsql.append(" order by fn.flowID,fn.orderNum");
			}
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
		ApplyFlowVO applyFlowVO = new ApplyFlowVO();
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
		
		applyFlowVO.setCreateTime(rs.getTimestamp("fCreateTime"));
		applyFlowVO.setFlowName(rs.getString("flowName"));
		applyFlowVO.setFlowType(rs.getInt("flowType"));
		applyFlownodeVO.setApplyFlowVO(applyFlowVO);
		
		listApplyFlownode.add(applyFlownodeVO);
	}

	public ArrayList<ApplyFlownodeVO> getApplyFlownodeList() {
		return listApplyFlownode;
	}

	public ApplyFlownodeVO getApplyFlownodeVO() {
		return applyFlownodeVO;
	}

}
