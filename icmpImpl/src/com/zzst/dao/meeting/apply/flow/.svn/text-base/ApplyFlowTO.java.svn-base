package com.zzst.dao.meeting.apply.flow;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;

/**
 * class description: ApplyFlow TO
 * 
 * @date Tue Jul 02 10:59:09 CST 2013
 * @author ryan
 */
public class ApplyFlowTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ApplyFlowTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_APPLYFLOW = 1;
	public static int MODIFY_APPLYFLOW = 2;
	public static int DEL_APPLYFLOW = 3;
	private int result = 0;

	private ApplyFlowVO applyFlowVO;

	public ApplyFlowTO(int operatorType, ApplyFlowVO applyFlowVO) {
		this.operatorType = operatorType;
		this.applyFlowVO = applyFlowVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_APPLYFLOW == operatorType) {
			sqlstr.append("insert into z_t_apply_flow ");
			sqlstr
					.append("(flowID,flowName,flowType,createUserID,createTime,updateTime,startTime,endTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(applyFlowVO.getFlowID());
			super.addStringForField(applyFlowVO.getFlowName());
			super.addIntForField(applyFlowVO.getFlowType());
			super.addStringForField(applyFlowVO.getCreateUserID());
			super.addTimestampForField(applyFlowVO.getCreateTime());
			super.addTimestampForField(applyFlowVO.getUpdateTime());
			super.addTimestampForField(applyFlowVO.getStartTime());
			super.addTimestampForField(applyFlowVO.getEndTime());
			super.addIntForField(applyFlowVO.getStatus());
			super.addLongForField(applyFlowVO.getRevision());
			super.addStringForField(applyFlowVO.getDescription());
		} else if (MODIFY_APPLYFLOW == operatorType) {
			sqlstr.append("update  z_t_apply_flow set ");
			sqlstr.append(" flowID = flowID ");

			if (applyFlowVO.getFlowName() != null) {
				sqlstr.append(" , flowName=? ");
				super.addStringForField(applyFlowVO.getFlowName());
			}

			if (applyFlowVO.getFlowType() != Integer.MIN_VALUE) {
				sqlstr.append(" , flowType=?");
				super.addIntForField(applyFlowVO.getFlowType());
			}

			if (applyFlowVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(applyFlowVO.getCreateUserID());
			}

			if (applyFlowVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(applyFlowVO.getCreateTime());
			}

			if (applyFlowVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(applyFlowVO.getUpdateTime());
			}

			if (applyFlowVO.getStartTime() != null) {
				sqlstr.append(" , startTime=? ");
				super.addTimestampForField(applyFlowVO.getStartTime());
			}

			if (applyFlowVO.getEndTime() != null) {
				sqlstr.append(" , endTime=? ");
				super.addTimestampForField(applyFlowVO.getEndTime());
			}

			if (applyFlowVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(applyFlowVO.getStatus());
			}

			if (applyFlowVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(applyFlowVO.getRevision());
			}

			if (applyFlowVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(applyFlowVO.getDescription());
			}

			sqlstr.append(" where flowID in (?) ");
			if (applyFlowVO.getFlowID() != null) {
				super.addStringForField(applyFlowVO.getFlowID());
			}
		} else if (DEL_APPLYFLOW == operatorType) {
			sqlstr.append("delete  from  z_t_apply_flow ");
			sqlstr.append(" where flowID in (?) ");
			super.addStringForField(applyFlowVO.getFlowID());
		}
		this.sqlStr = sqlstr.toString();
	}

	public String getSqlStr() {
		return this.sqlStr;
	}

	public void setValues() throws SQLException {

	}

	public void execute() throws SQLException {
		result = this.stmt.executeUpdate();
	}

	public int getexecuteResult() {
		return result;
	}

}
