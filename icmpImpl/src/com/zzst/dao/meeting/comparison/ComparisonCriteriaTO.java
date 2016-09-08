package com.zzst.dao.meeting.comparison;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;

/**
 * class description: ComparisonCriteria TO
 * 
 * @date Fri Apr 26 16:04:41 CST 2013
 * @author ryan
 */
public class ComparisonCriteriaTO extends TransactionObject {

	private static Logger logger = CbfLogger
	.getLogger(ComparisonCriteriaTO.class.getName());
	private int operatorType = -1;

	public static int ADD_COMPARISONCRITERIA = 1;
	public static int MODIFY_COMPARISONCRITERIA = 2;
	public static int DEL_COMPARISONCRITERIA = 3;
	private int result = 0;

	private ComparisonCriteriaVO comparisonCriteriaVO;
	private String ids = "";

	public ComparisonCriteriaTO(int operatorType,
			ComparisonCriteriaVO comparisonCriteriaVO) {
		this.operatorType = operatorType;
		this.comparisonCriteriaVO = comparisonCriteriaVO;
	}

	public ComparisonCriteriaTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_COMPARISONCRITERIA == operatorType) {
			sqlstr.append("insert into Z_T_COMPARISON_CRITERIA ");
			sqlstr
			.append("(ComCriteriaID,rsGap_Good_lower,rsGap_Good_upper,rsGap_Ok_lower,rsGap_Ok_upper,gsGap_Good_lower,gsGap_Good_upper,gsGap_Ok_lower,gsGap_Ok_upper,bsGap_Good_lower,bsGap_Good_upper,bsGap_Ok_lower,bsGap_Ok_upper,x_min,x_max,updateUserID,updateTime,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(comparisonCriteriaVO.getComCriteriaID());
			super.addIntForField(comparisonCriteriaVO.getRsGap_Good_lower());
			super.addIntForField(comparisonCriteriaVO.getRsGap_Good_upper());
			super.addIntForField(comparisonCriteriaVO.getRsGap_Ok_lower());
			super.addIntForField(comparisonCriteriaVO.getRsGap_Ok_upper());
			super.addIntForField(comparisonCriteriaVO.getGsGap_Good_lower());
			super.addIntForField(comparisonCriteriaVO.getGsGap_Good_upper());
			super.addIntForField(comparisonCriteriaVO.getGsGap_Ok_lower());
			super.addIntForField(comparisonCriteriaVO.getGsGap_Ok_upper());
			super.addIntForField(comparisonCriteriaVO.getBsGap_Good_lower());
			super.addIntForField(comparisonCriteriaVO.getBsGap_Good_upper());
			super.addIntForField(comparisonCriteriaVO.getBsGap_Ok_lower());
			super.addIntForField(comparisonCriteriaVO.getBsGap_Ok_upper());
			super.addIntForField(comparisonCriteriaVO.getX_min());
			super.addIntForField(comparisonCriteriaVO.getX_max());
			super.addStringForField(comparisonCriteriaVO.getUpdateUserID());
			super.addTimestampForField(comparisonCriteriaVO.getUpdateTime());
			super.addStringForField(comparisonCriteriaVO.getDescription());
			super.addLongForField(comparisonCriteriaVO.getRevision());
		} else if (MODIFY_COMPARISONCRITERIA == operatorType) {
			sqlstr.append("update  Z_T_COMPARISON_CRITERIA set ");
			sqlstr.append(" ComCriteriaID = ComCriteriaID ");

			if (comparisonCriteriaVO.getRsGap_Good_lower() != Integer.MIN_VALUE) {
				sqlstr.append(" , rsGap_Good_lower=?");
				super
				.addIntForField(comparisonCriteriaVO
						.getRsGap_Good_lower());
			}

			if (comparisonCriteriaVO.getRsGap_Good_upper() != Integer.MIN_VALUE) {
				sqlstr.append(" , rsGap_Good_upper=?");
				super
				.addIntForField(comparisonCriteriaVO
						.getRsGap_Good_upper());
			}

			if (comparisonCriteriaVO.getRsGap_Ok_lower() != Integer.MIN_VALUE) {
				sqlstr.append(" , rsGap_Ok_lower=?");
				super.addIntForField(comparisonCriteriaVO.getRsGap_Ok_lower());
			}

			if (comparisonCriteriaVO.getRsGap_Ok_upper() != Integer.MIN_VALUE) {
				sqlstr.append(" , rsGap_Ok_upper=?");
				super.addIntForField(comparisonCriteriaVO.getRsGap_Ok_upper());
			}

			if (comparisonCriteriaVO.getGsGap_Good_lower() != Integer.MIN_VALUE) {
				sqlstr.append(" , gsGap_Good_lower=?");
				super
				.addIntForField(comparisonCriteriaVO
						.getGsGap_Good_lower());
			}

			if (comparisonCriteriaVO.getGsGap_Good_upper() != Integer.MIN_VALUE) {
				sqlstr.append(" , gsGap_Good_upper=?");
				super
				.addIntForField(comparisonCriteriaVO
						.getGsGap_Good_upper());
			}

			if (comparisonCriteriaVO.getGsGap_Ok_lower() != Integer.MIN_VALUE) {
				sqlstr.append(" , gsGap_Ok_lower=?");
				super.addIntForField(comparisonCriteriaVO.getGsGap_Ok_lower());
			}

			if (comparisonCriteriaVO.getGsGap_Ok_upper() != Integer.MIN_VALUE) {
				sqlstr.append(" , gsGap_Ok_upper=?");
				super.addIntForField(comparisonCriteriaVO.getGsGap_Ok_upper());
			}

			if (comparisonCriteriaVO.getBsGap_Good_lower() != Integer.MIN_VALUE) {
				sqlstr.append(" , bsGap_Good_lower=?");
				super
				.addIntForField(comparisonCriteriaVO
						.getBsGap_Good_lower());
			}

			if (comparisonCriteriaVO.getBsGap_Good_upper() != Integer.MIN_VALUE) {
				sqlstr.append(" , bsGap_Good_upper=?");
				super
				.addIntForField(comparisonCriteriaVO
						.getBsGap_Good_upper());
			}

			if (comparisonCriteriaVO.getBsGap_Ok_lower() != Integer.MIN_VALUE) {
				sqlstr.append(" , bsGap_Ok_lower=?");
				super.addIntForField(comparisonCriteriaVO.getBsGap_Ok_lower());
			}

			if (comparisonCriteriaVO.getBsGap_Ok_upper() != Integer.MIN_VALUE) {
				sqlstr.append(" , bsGap_Ok_upper=?");
				super.addIntForField(comparisonCriteriaVO.getBsGap_Ok_upper());
			}

			if (comparisonCriteriaVO.getX_min() != Integer.MIN_VALUE) {
				sqlstr.append(" , x_min=?");
				super.addIntForField(comparisonCriteriaVO.getX_min());
			}

			if (comparisonCriteriaVO.getX_max() != Integer.MIN_VALUE) {
				sqlstr.append(" , x_max=?");
				super.addIntForField(comparisonCriteriaVO.getX_max());
			}

			if (comparisonCriteriaVO.getUpdateUserID() != null) {
				sqlstr.append(" , updateUserID=? ");
				super.addStringForField(comparisonCriteriaVO.getUpdateUserID());
			}

			if (comparisonCriteriaVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super
				.addTimestampForField(comparisonCriteriaVO
						.getUpdateTime());
			}

			if (comparisonCriteriaVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(comparisonCriteriaVO.getDescription());
			}

			if (comparisonCriteriaVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(comparisonCriteriaVO.getRevision());
			}

			sqlstr.append(" where ComCriteriaID in (?) ");
			if (comparisonCriteriaVO.getComCriteriaID() != null) {
				super
				.addStringForField(comparisonCriteriaVO
						.getComCriteriaID());
			}
		} else if (DEL_COMPARISONCRITERIA == operatorType) {
			sqlstr.append("delete  from  Z_T_COMPARISON_CRITERIA ");
			sqlstr.append(" where ComCriteriaID in (?) ");
			super.addStringForField(comparisonCriteriaVO.getComCriteriaID());
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
