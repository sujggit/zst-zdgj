package com.zzst.dao.meeting.apply.flownode;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;

/**
 * class description: ApplyFlownode TO
 * 
 * @date Tue Jul 02 12:28:39 CST 2013
 * @author ryan
 */
public class ApplyFlownodeTO extends TransactionObject {

	public static final int DEL_APPLYFLOWNODE_BYFLOWID = 4;
	private static Logger logger = CbfLogger.getLogger(ApplyFlownodeTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_APPLYFLOWNODE = 1;
	public static int MODIFY_APPLYFLOWNODE = 2;
	public static int DEL_APPLYFLOWNODE = 3;
	private int result = 0;

	private ApplyFlownodeVO applyFlownodeVO;

	public ApplyFlownodeTO(int operatorType, ApplyFlownodeVO applyFlownodeVO) {
		this.operatorType = operatorType;
		this.applyFlownodeVO = applyFlownodeVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_APPLYFLOWNODE == operatorType) {
			sqlstr.append("insert into z_t_apply_flownode ");
			sqlstr
					.append("(flownodeID,flowID,flownodeName,orderNum,prevOrder,nextOrder,flownodeType,userID,postNO,checkType,checkRule,createUserID,createTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(applyFlownodeVO.getFlownodeID());
			super.addStringForField(applyFlownodeVO.getFlowID());
			super.addStringForField(applyFlownodeVO.getFlownodeName());
			super.addIntForField(applyFlownodeVO.getOrderNum());
			super.addIntForField(applyFlownodeVO.getPrevOrder());
			super.addIntForField(applyFlownodeVO.getNextOrder());
			super.addIntForField(applyFlownodeVO.getFlownodeType());
			super.addStringForField(applyFlownodeVO.getUserID());
			super.addStringForField(applyFlownodeVO.getPostNO());
			super.addIntForField(applyFlownodeVO.getCheckType());
			super.addStringForField(applyFlownodeVO.getCheckRule());
			super.addStringForField(applyFlownodeVO.getCreateUserID());
			super.addTimestampForField(applyFlownodeVO.getCreateTime());
			super.addIntForField(applyFlownodeVO.getStatus());
			super.addLongForField(applyFlownodeVO.getRevision());
			super.addStringForField(applyFlownodeVO.getDescription());
		} else if (MODIFY_APPLYFLOWNODE == operatorType) {
			sqlstr.append("update  z_t_apply_flownode set ");
			sqlstr.append(" flownodeID = flownodeID ");

			if (applyFlownodeVO.getFlowID() != null) {
				sqlstr.append(" , flowID=? ");
				super.addStringForField(applyFlownodeVO.getFlowID());
			}

			if (applyFlownodeVO.getFlownodeName() != null) {
				sqlstr.append(" , flownodeName=? ");
				super.addStringForField(applyFlownodeVO.getFlownodeName());
			}

			if (applyFlownodeVO.getOrderNum() != Integer.MIN_VALUE) {
				sqlstr.append(" , orderNum=?");
				super.addIntForField(applyFlownodeVO.getOrderNum());
			}

			if (applyFlownodeVO.getPrevOrder() != Integer.MIN_VALUE) {
				sqlstr.append(" , prevOrder=?");
				super.addIntForField(applyFlownodeVO.getPrevOrder());
			}

			if (applyFlownodeVO.getNextOrder() != Integer.MIN_VALUE) {
				sqlstr.append(" , nextOrder=?");
				super.addIntForField(applyFlownodeVO.getNextOrder());
			}

			if (applyFlownodeVO.getFlownodeType() != Integer.MIN_VALUE) {
				sqlstr.append(" , flownodeType=?");
				super.addIntForField(applyFlownodeVO.getFlownodeType());
			}

			if (applyFlownodeVO.getUserID() != null) {
				sqlstr.append(" , userID=? ");
				super.addStringForField(applyFlownodeVO.getUserID());
			}

			if (applyFlownodeVO.getPostNO() != null) {
				sqlstr.append(" , postNO=? ");
				super.addStringForField(applyFlownodeVO.getPostNO());
			}

			if (applyFlownodeVO.getCheckType() != Integer.MIN_VALUE) {
				sqlstr.append(" , checkType=?");
				super.addIntForField(applyFlownodeVO.getCheckType());
			}

			if (applyFlownodeVO.getCheckRule() != null) {
				sqlstr.append(" , checkRule=? ");
				super.addStringForField(applyFlownodeVO.getCheckRule());
			}

			if (applyFlownodeVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(applyFlownodeVO.getCreateUserID());
			}

			if (applyFlownodeVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(applyFlownodeVO.getCreateTime());
			}

			if (applyFlownodeVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(applyFlownodeVO.getStatus());
			}

			if (applyFlownodeVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(applyFlownodeVO.getRevision());
			}

			if (applyFlownodeVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(applyFlownodeVO.getDescription());
			}

			sqlstr.append(" where flownodeID in (?) ");
			if (applyFlownodeVO.getFlownodeID() != null) {
				super.addStringForField(applyFlownodeVO.getFlownodeID());
			}
		} else if (DEL_APPLYFLOWNODE == operatorType) {
			sqlstr.append("delete  from  z_t_apply_flownode ");
			sqlstr.append(" where flownodeID in (?) ");
			super.addStringForField(applyFlownodeVO.getFlownodeID());
		} else if (DEL_APPLYFLOWNODE_BYFLOWID == operatorType) {
			sqlstr.append("delete from z_t_apply_flownode ");
			sqlstr.append(" where flowID = ?");
			super.addStringForField(applyFlownodeVO.getFlowID());
			if (!StringUtils.isNullOrBlank(applyFlownodeVO
					.getFlownodeName())) {
				sqlstr.append(" and flownodeName= ? ");
				super.addStringForField(applyFlownodeVO.getFlownodeName());
			}
			if (Integer.MIN_VALUE != applyFlownodeVO.getOrderNum()) {
				sqlstr.append(" and orderNum= ? ");
				super.addIntForField(applyFlownodeVO.getOrderNum());
			}
			if (Integer.MIN_VALUE != applyFlownodeVO.getPrevOrder()) {
				sqlstr.append(" and prevOrder= ? ");
				super.addIntForField(applyFlownodeVO.getPrevOrder());
			}
			if (Integer.MIN_VALUE != applyFlownodeVO.getNextOrder()) {
				sqlstr.append(" and nextOrder= ? ");
				super.addIntForField(applyFlownodeVO.getNextOrder());
			}
			if (Integer.MIN_VALUE != applyFlownodeVO.getFlownodeType()) {
				sqlstr.append(" and flownodeType= ? ");
				super.addIntForField(applyFlownodeVO.getFlownodeType());
			}
			if (!StringUtils.isNullOrBlank(applyFlownodeVO.getUserID())) {
				sqlstr.append(" and userID= ? ");
				super.addStringForField(applyFlownodeVO.getUserID());
			}
			if (!StringUtils.isNullOrBlank(applyFlownodeVO.getPostNO())) {
				sqlstr.append(" and postNO= ? ");
				super.addStringForField(applyFlownodeVO.getPostNO());
			}
			if (Integer.MIN_VALUE != applyFlownodeVO.getCheckType()) {
				sqlstr.append(" and checkType= ? ");
				super.addIntForField(applyFlownodeVO.getCheckType());
			}
			if (!StringUtils.isNullOrBlank(applyFlownodeVO.getCheckRule())) {
				sqlstr.append(" and checkRule= ? ");
				super.addStringForField(applyFlownodeVO.getCheckRule());
			}
			if (!StringUtils.isNullOrBlank(applyFlownodeVO
					.getCreateUserID())) {
				sqlstr.append(" and createUserID= ? ");
				super.addStringForField(applyFlownodeVO.getCreateUserID());
			}
			if (Integer.MIN_VALUE != applyFlownodeVO.getStatus()) {
				sqlstr.append(" and status= ? ");
				super.addIntForField(applyFlownodeVO.getStatus());
			}
			if (Long.MIN_VALUE != applyFlownodeVO.getRevision()) {
				sqlstr.append(" and revision= ? ");
				super.addLongForField(applyFlownodeVO.getRevision());
			}
			if (!StringUtils
					.isNullOrBlank(applyFlownodeVO.getDescription())) {
				sqlstr.append(" and description= ? ");
				super.addStringForField(applyFlownodeVO.getDescription());
			}
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
