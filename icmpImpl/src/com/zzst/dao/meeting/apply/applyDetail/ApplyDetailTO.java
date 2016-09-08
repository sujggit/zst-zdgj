package com.zzst.dao.meeting.apply.applyDetail;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;

/**
 * class description: ApplyDetail TO
 * 
 * @date Tue Jul 02 12:22:34 CST 2013
 * @author ryan
 */
public class ApplyDetailTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ApplyDetailTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_APPLYDETAIL = 1;
	public static int MODIFY_APPLYDETAIL = 2;
	public static int DEL_APPLYDETAIL = 3;
	private int result = 0;

	private ApplyDetailVO applyDetailVO;

	public ApplyDetailTO(int operatorType, ApplyDetailVO applyDetailVO) {
		this.operatorType = operatorType;
		this.applyDetailVO = applyDetailVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_APPLYDETAIL == operatorType) {
			sqlstr.append("insert into z_t_apply_detail ");
			sqlstr
					.append("(detailID,flowID,flownodeID,flownodeName,applyDetailID,flowType,checkType,orderNum,checkUserIDs,userID,suggestion,createTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(applyDetailVO.getDetailID());
			super.addStringForField(applyDetailVO.getFlowID());
			super.addStringForField(applyDetailVO.getFlownodeID());
			super.addStringForField(applyDetailVO.getFlownodeName());
			super.addStringForField(applyDetailVO.getApplyDetailID());
			super.addIntForField(applyDetailVO.getFlowType());
			super.addIntForField(applyDetailVO.getCheckType());
			super.addIntForField(applyDetailVO.getOrderNum());
			super.addStringForField(applyDetailVO.getCheckUserIDs());
			super.addStringForField(applyDetailVO.getUserID());
			super.addStringForField(applyDetailVO.getSuggestion());
			super.addTimestampForField(applyDetailVO.getCreateTime());
			super.addIntForField(applyDetailVO.getStatus());
			super.addLongForField(applyDetailVO.getRevision());
			super.addStringForField(applyDetailVO.getDescription());
		} else if (MODIFY_APPLYDETAIL == operatorType) {
			sqlstr.append("update  z_t_apply_detail set ");
			sqlstr.append(" detailID = detailID ");

			if (applyDetailVO.getFlowID() != null) {
				sqlstr.append(" , flowID=? ");
				super.addStringForField(applyDetailVO.getFlowID());
			}

			if (applyDetailVO.getFlownodeID() != null) {
				sqlstr.append(" , flownodeID=? ");
				super.addStringForField(applyDetailVO.getFlownodeID());
			}
			if (applyDetailVO.getFlownodeName() != null) {
				sqlstr.append(" , flownodeName=? ");
				super.addStringForField(applyDetailVO.getFlownodeName());
			}

			if (applyDetailVO.getApplyDetailID() != null) {
				sqlstr.append(" , applyDetailID=? ");
				super.addStringForField(applyDetailVO.getApplyDetailID());
			}

			if (applyDetailVO.getFlowType() != Integer.MIN_VALUE) {
				sqlstr.append(" , flowType=?");
				super.addIntForField(applyDetailVO.getFlowType());
			}
			if (applyDetailVO.getCheckType() != Integer.MIN_VALUE) {
				sqlstr.append(" , checkType=?");
				super.addIntForField(applyDetailVO.getCheckType());
			}
			
			if (applyDetailVO.getOrderNum() != Integer.MIN_VALUE) {
				sqlstr.append(" , orderNum=?");
				super.addIntForField(applyDetailVO.getOrderNum());
			}

			if (applyDetailVO.getCheckUserIDs() != null) {
				sqlstr.append(" , checkUserIDs=? ");
				super.addStringForField(applyDetailVO.getCheckUserIDs());
			}

			if (applyDetailVO.getUserID() != null) {
				sqlstr.append(" , userID=? ");
				super.addStringForField(applyDetailVO.getUserID());
			}

			if (applyDetailVO.getSuggestion() != null) {
				sqlstr.append(" , suggestion=? ");
				super.addStringForField(applyDetailVO.getSuggestion());
			}

			if (applyDetailVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(applyDetailVO.getCreateTime());
			}

			if (applyDetailVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(applyDetailVO.getStatus());
			}

			if (applyDetailVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(applyDetailVO.getRevision());
			}

			if (applyDetailVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(applyDetailVO.getDescription());
			}

			sqlstr.append(" where detailID in (?) ");
			if (applyDetailVO.getDetailID() != null) {
				super.addStringForField(applyDetailVO.getDetailID());
			}
		} else if (DEL_APPLYDETAIL == operatorType) {
			sqlstr.append("delete  from  z_t_apply_detail ");
			sqlstr.append(" where detailID in (?) ");
			super.addStringForField(applyDetailVO.getDetailID());
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
