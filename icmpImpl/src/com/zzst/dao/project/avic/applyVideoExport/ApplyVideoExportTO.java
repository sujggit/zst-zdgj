package com.zzst.dao.project.avic.applyVideoExport;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.project.avic.applyVideoExport.ApplyVideoExportVO;

/**
 * class description: ApplyVideoExport TO
 * 
 * @date Tue Sep 25 16:50:34 CST 2012
 * @author ryan
 */
public class ApplyVideoExportTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ApplyVideoExportTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_APPLYVIDEOEXPORT = 1;
	public static int MODIFY_APPLYVIDEOEXPORT = 2;
	public static int DEL_APPLYVIDEOEXPORT = 3;
	private int result = 0;

	private ApplyVideoExportVO applyVideoExportVO;
	private String ids = "";

	public ApplyVideoExportTO(int operatorType,
			ApplyVideoExportVO applyVideoExportVO) {
		this.operatorType = operatorType;
		this.applyVideoExportVO = applyVideoExportVO;
	}

	public ApplyVideoExportTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_APPLYVIDEOEXPORT == operatorType) {
			sqlstr.append("insert into avic_t_apply_video_export ");
			sqlstr.append("(applyID,departmentID,departmentName,applyUserID,applyUserName,contactWay,meetingDetailID,meetingDetailName,applyWay,applyNumber,mediaCode,security,exportUserName,pickUpUserName,exportDes,flowID,createUserID,createTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(applyVideoExportVO.getApplyID());
			super.addStringForField(applyVideoExportVO.getDepartmentID());
			super.addStringForField(applyVideoExportVO.getDepartmentName());
			super.addStringForField(applyVideoExportVO.getApplyUserID());
			super.addStringForField(applyVideoExportVO.getApplyUserName());
			super.addStringForField(applyVideoExportVO.getContactWay());
			super.addStringForField(applyVideoExportVO.getMeetingDetailID());
			super.addStringForField(applyVideoExportVO.getMeetingDetailName());
			super.addStringForField(applyVideoExportVO.getApplyWay());
			super.addIntForField(applyVideoExportVO.getApplyNumber());
			super.addStringForField(applyVideoExportVO.getMediaCode());
			super.addIntForField(applyVideoExportVO.getSecurity());
			super.addStringForField(applyVideoExportVO.getExportUserName());
			super.addStringForField(applyVideoExportVO.getPickUpUserName());
			super.addStringForField(applyVideoExportVO.getExportDes());
			super.addStringForField(applyVideoExportVO.getFlowID());
			super.addStringForField(applyVideoExportVO.getCreateUserID());
			super.addTimestampForField(applyVideoExportVO.getCreateTime());
			super.addIntForField(applyVideoExportVO.getStatus());
			super.addLongForField(applyVideoExportVO.getRevision());
			super.addStringForField(applyVideoExportVO.getDescription());
		} else if (MODIFY_APPLYVIDEOEXPORT == operatorType) {
			sqlstr.append("update  avic_t_apply_video_export set ");
			sqlstr.append(" applyID = applyID ");

			if (applyVideoExportVO.getDepartmentID() != null) {
				sqlstr.append(" , departmentID=? ");
				super.addStringForField(applyVideoExportVO.getDepartmentID());
			}

			if (applyVideoExportVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentName=? ");
				super.addStringForField(applyVideoExportVO.getDepartmentName());
			}

			if (applyVideoExportVO.getApplyUserID() != null) {
				sqlstr.append(" , applyUserID=? ");
				super.addStringForField(applyVideoExportVO.getApplyUserID());
			}

			if (applyVideoExportVO.getApplyUserName() != null) {
				sqlstr.append(" , applyUserName=? ");
				super.addStringForField(applyVideoExportVO.getApplyUserName());
			}

			if (applyVideoExportVO.getContactWay() != null) {
				sqlstr.append(" , contactWay=? ");
				super.addStringForField(applyVideoExportVO.getContactWay());
			}

			if (applyVideoExportVO.getMeetingDetailID() != null) {
				sqlstr.append(" , meetingDetailID=? ");
				super.addStringForField(applyVideoExportVO.getMeetingDetailID());
			}

			if (applyVideoExportVO.getMeetingDetailName() != null) {
				sqlstr.append(" , meetingDetailName=? ");
				super.addStringForField(applyVideoExportVO.getMeetingDetailName());
			}

			if (applyVideoExportVO.getApplyWay() != null) {
				sqlstr.append(" , applyWay=? ");
				super.addStringForField(applyVideoExportVO.getApplyWay());
			}

			if (applyVideoExportVO.getApplyNumber() != Integer.MIN_VALUE) {
				sqlstr.append(" , applyNumber=?");
				super.addIntForField(applyVideoExportVO.getApplyNumber());
			}

			if (applyVideoExportVO.getMediaCode() != null) {
				sqlstr.append(" , mediaCode=? ");
				super.addStringForField(applyVideoExportVO.getMediaCode());
			}

			if (applyVideoExportVO.getSecurity() != Integer.MIN_VALUE) {
				sqlstr.append(" , security=?");
				super.addIntForField(applyVideoExportVO.getSecurity());
			}

			if (applyVideoExportVO.getExportUserName() != null) {
				sqlstr.append(" , exportUserName=? ");
				super.addStringForField(applyVideoExportVO.getExportUserName());
			}

			if (applyVideoExportVO.getPickUpUserName() != null) {
				sqlstr.append(" , pickUpUserName=? ");
				super.addStringForField(applyVideoExportVO.getPickUpUserName());
			}

			if (applyVideoExportVO.getExportDes() != null) {
				sqlstr.append(" , exportDes=? ");
				super.addStringForField(applyVideoExportVO.getExportDes());
			}

			if (applyVideoExportVO.getFlowID() != null) {
				sqlstr.append(" , flowID=? ");
				super.addStringForField(applyVideoExportVO.getFlowID());
			}

			if (applyVideoExportVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(applyVideoExportVO.getCreateUserID());
			}

			if (applyVideoExportVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(applyVideoExportVO.getCreateTime());
			}

			if (applyVideoExportVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(applyVideoExportVO.getStatus());
			}

			if (applyVideoExportVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(applyVideoExportVO.getRevision());
			}

			if (applyVideoExportVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(applyVideoExportVO.getDescription());
			}

			sqlstr.append(" where applyID in (?) ");
			if (applyVideoExportVO.getApplyID() != null) {
				super.addStringForField(applyVideoExportVO.getApplyID());
			}
		} else if (DEL_APPLYVIDEOEXPORT == operatorType) {
			sqlstr.append("delete  from  avic_t_apply_video_export ");
			sqlstr.append(" where applyID in (?) ");
			super.addStringForField(applyVideoExportVO.getApplyID());
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
