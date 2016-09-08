package com.zzst.dao.project.avic.applyConference;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

/**
 * class description:	ApplyConference TO
 * @date Wed Sep 19 16:15:16 CST 2012
 * @author ryan
 */
public class ApplyConferenceTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(ApplyConferenceTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_APPLYCONFERENCE = 1;
	public static int MODIFY_APPLYCONFERENCE = 2;
	public static int DEL_APPLYCONFERENCE = 3;
	private int result = 0;

	private ApplyConferenceVO applyConferenceVO;
	private String ids = "";

	public ApplyConferenceTO(int operatorType,
			ApplyConferenceVO applyConferenceVO) {
		this.operatorType = operatorType;
		this.applyConferenceVO = applyConferenceVO;
	}

	public ApplyConferenceTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_APPLYCONFERENCE == operatorType) {
			sqlstr.append("insert into avic_t_vc_apply_info ");
			sqlstr
					.append("(applyID,departmentID,departmentName,departmentCode,linkManID,linkManName,linkManPhone,linkManCellPhone,linkManFax,security,startTime,endTime,conferenceName,conferenceAgenda,graphicsDepartmentName,splitScreent,poll,videotape,otherRequire,departmentGroupLeadIDs,departmentGroupLeadNames,departmentGroupIDS,departmentGroupNames,departmentDirectlyIDS,departmentDirectlyNames,departmentMemberIDS,departmentMemberNames,departmentOutMemberIDS,departmentOutMemberNames,createUserID,mainVenueNumber,venueNumber,createTime,status,revision,description,venueConference,mainConference,venueConferenceIDs,mainConferenceID,countNumber,flowId)");
			sqlstr
					.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(applyConferenceVO.getApplyID());
			super.addStringForField(applyConferenceVO.getDepartmentID());
			super.addStringForField(applyConferenceVO.getDepartmentName());
			super.addStringForField(applyConferenceVO.getDepartmentCode());
			super.addStringForField(applyConferenceVO.getLinkManID());
			super.addStringForField(applyConferenceVO.getLinkManName());
			super.addStringForField(applyConferenceVO.getLinkManPhone());
			super.addStringForField(applyConferenceVO.getLinkManCellPhone());
			super.addStringForField(applyConferenceVO.getLinkManFax());
			super.addIntForField(applyConferenceVO.getSecurity());
			super.addTimestampForField(applyConferenceVO.getStartTime());
			super.addTimestampForField(applyConferenceVO.getEndTime());
			super.addStringForField(applyConferenceVO.getConferenceName());
			super.addStringForField(applyConferenceVO.getConferenceAgenda());
			super.addStringForField(applyConferenceVO
					.getGraphicsDepartmentName());
			super.addStringForField(applyConferenceVO.getSplitScreent());
			super.addStringForField(applyConferenceVO.getPoll());
			super.addIntForField(applyConferenceVO.getVideotape());
			super.addStringForField(applyConferenceVO.getOtherRequire());
			super.addStringForField(applyConferenceVO
					.getDepartmentGroupLeadIDs());
			super.addStringForField(applyConferenceVO
					.getDepartmentGroupLeadNames());
			super.addStringForField(applyConferenceVO.getDepartmentGroupIDS());
			super.addStringForField(applyConferenceVO.getDepartmentGroupNames());
			super.addStringForField(applyConferenceVO
					.getDepartmentDirectlyIDS());
			super.addStringForField(applyConferenceVO
					.getDepartmentDirectlyNames());
			super.addStringForField(applyConferenceVO.getDepartmentMemberIDS());
			super.addStringForField(applyConferenceVO
					.getDepartmentMemberNames());
			super.addStringForField(applyConferenceVO
					.getDepartmentOutMemberIDS());
			super.addStringForField(applyConferenceVO
					.getDepartmentOutMemberNames());
			super.addStringForField(applyConferenceVO.getCreateUserID());
			super.addStringForField(applyConferenceVO.getMainVenueNumber());
			super.addStringForField(applyConferenceVO.getVenueNumber());
			super.addTimestampForField(applyConferenceVO.getCreateTime());
			super.addIntForField(applyConferenceVO.getStatus());
			super.addLongForField(applyConferenceVO.getRevision());
			super.addStringForField(applyConferenceVO.getDescription());
			super.addStringForField(applyConferenceVO.getVenueConference());
			super.addStringForField(applyConferenceVO.getMainConference());
			super.addStringForField(applyConferenceVO.getVenueConferenceIDs());
			super.addStringForField(applyConferenceVO.getMainConferenceID());
			super.addStringForField(applyConferenceVO.getCountNumber());
			super.addStringForField(applyConferenceVO.getFlowId());
		} else if (MODIFY_APPLYCONFERENCE == operatorType) {
			sqlstr.append("update  avic_t_vc_apply_info set ");
			sqlstr.append(" applyID = applyID ");

			if (applyConferenceVO.getDepartmentID() != null) {
				sqlstr.append(" , departmentID=? ");
				super.addStringForField(applyConferenceVO.getDepartmentID());
			}

			if (applyConferenceVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentName=? ");
				super.addStringForField(applyConferenceVO.getDepartmentName());
			}

			if (applyConferenceVO.getDepartmentCode() != null) {
				sqlstr.append(" , departmentCode=? ");
				super.addStringForField(applyConferenceVO.getDepartmentCode());
			}

			if (applyConferenceVO.getLinkManID() != null) {
				sqlstr.append(" , linkManID=? ");
				super.addStringForField(applyConferenceVO.getLinkManID());
			}
			
			if (applyConferenceVO.getLinkManName() != null) {
				sqlstr.append(" , linkManName=? ");
				super.addStringForField(applyConferenceVO.getLinkManName());
			}

			if (applyConferenceVO.getLinkManPhone() != null) {
				sqlstr.append(" , linkManPhone=? ");
				super.addStringForField(applyConferenceVO.getLinkManPhone());
			}

			if (applyConferenceVO.getLinkManCellPhone() != null) {
				sqlstr.append(" , linkManCellPhone=? ");
				super
						.addStringForField(applyConferenceVO
								.getLinkManCellPhone());
			}

			if (applyConferenceVO.getLinkManFax() != null) {
				sqlstr.append(" , linkManFax=? ");
				super.addStringForField(applyConferenceVO.getLinkManFax());
			}

			if (applyConferenceVO.getSecurity() != Integer.MIN_VALUE) {
				sqlstr.append(" , security=?");
				super.addIntForField(applyConferenceVO.getSecurity());
			}

			if (applyConferenceVO.getStartTime() != null) {
				sqlstr.append(" , startTime=? ");
				super.addTimestampForField(applyConferenceVO.getStartTime());
			}

			if (applyConferenceVO.getEndTime() != null) {
				sqlstr.append(" , endTime=? ");
				super.addTimestampForField(applyConferenceVO.getEndTime());
			}

			if (applyConferenceVO.getConferenceName() != null) {
				sqlstr.append(" , conferenceName=? ");
				super.addStringForField(applyConferenceVO.getConferenceName());
			}

			if (applyConferenceVO.getConferenceAgenda() != null) {
				sqlstr.append(" , conferenceAgenda=? ");
				super.addStringForField(applyConferenceVO.getConferenceAgenda());
			}

			if (applyConferenceVO.getGraphicsDepartmentName() != null) {
				sqlstr.append(" , graphicsDepartmentName=? ");
				super.addStringForField(applyConferenceVO
						.getGraphicsDepartmentName());
			}

			if (applyConferenceVO.getSplitScreent() != null) {
				sqlstr.append(" , splitScreent=? ");
				super.addStringForField(applyConferenceVO.getSplitScreent());
			}

			if (applyConferenceVO.getPoll() != null) {
				sqlstr.append(" , poll=? ");
				super.addStringForField(applyConferenceVO.getPoll());
			}

			if (applyConferenceVO.getVideotape() != Integer.MIN_VALUE) {
				sqlstr.append(" , videotape=?");
				super.addIntForField(applyConferenceVO.getVideotape());
			}

			if (applyConferenceVO.getOtherRequire() != null) {
				sqlstr.append(" , otherRequire=? ");
				super.addStringForField(applyConferenceVO.getOtherRequire());
			}

			if (applyConferenceVO.getDepartmentGroupLeadIDs() != null) {
				sqlstr.append(" , departmentGroupLeadIDs=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentGroupLeadIDs());
			}

			if (applyConferenceVO.getDepartmentGroupLeadNames() != null) {
				sqlstr.append(" , departmentGroupLeadNames=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentGroupLeadNames());
			}

			if (applyConferenceVO.getDepartmentGroupIDS() != null) {
				sqlstr.append(" , departmentGroupIDS=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentGroupIDS());
			}

			if (applyConferenceVO.getDepartmentGroupNames() != null) {
				sqlstr.append(" , departmentGroupNames=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentGroupNames());
			}

			if (applyConferenceVO.getDepartmentDirectlyIDS() != null) {
				sqlstr.append(" , departmentDirectlyIDS=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentDirectlyIDS());
			}

			if (applyConferenceVO.getDepartmentDirectlyNames() != null) {
				sqlstr.append(" , departmentDirectlyNames=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentDirectlyNames());
			}

			if (applyConferenceVO.getDepartmentMemberIDS() != null) {
				sqlstr.append(" , departmentMemberIDS=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentMemberIDS());
			}

			if (applyConferenceVO.getDepartmentMemberNames() != null) {
				sqlstr.append(" , departmentMemberNames=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentMemberNames());
			}

			if (applyConferenceVO.getDepartmentOutMemberIDS() != null) {
				sqlstr.append(" , departmentOutMemberIDS=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentOutMemberIDS());
			}

			if (applyConferenceVO.getDepartmentOutMemberNames() != null) {
				sqlstr.append(" , departmentOutMemberNames=? ");
				super.addStringForField(applyConferenceVO
						.getDepartmentOutMemberNames());
			}

			if (applyConferenceVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(applyConferenceVO.getCreateUserID());
			}

			if (applyConferenceVO.getMainVenueNumber() != null) {
				sqlstr.append(" , mainVenueNumber=? ");
				super.addStringForField(applyConferenceVO.getMainVenueNumber());
			}

			if (applyConferenceVO.getVenueNumber() != null) {
				sqlstr.append(" , venueNumber=? ");
				super.addStringForField(applyConferenceVO.getVenueNumber());
			}

			if (applyConferenceVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(applyConferenceVO.getCreateTime());
			}

			if (applyConferenceVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(applyConferenceVO.getStatus());
			}

			if (applyConferenceVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(applyConferenceVO.getRevision());
			}

			if (applyConferenceVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(applyConferenceVO.getDescription());
			}

			if (applyConferenceVO.getVenueConference() != null) {
				sqlstr.append(" , venueConference=? ");
				super.addStringForField(applyConferenceVO.getVenueConference());
			}

			if (!StringUtils.isNullOrBlank(applyConferenceVO.getVenueConferenceIDs())) {
				sqlstr.append(" , venueConferenceIDs= ? ");
				super.addStringForField(applyConferenceVO.getVenueConferenceIDs());
			}
			if (!StringUtils.isNullOrBlank(applyConferenceVO.getMainConferenceID())) {
				sqlstr.append(" , mainConferenceID= ? ");
				super.addStringForField(applyConferenceVO.getMainConferenceID());
			}
			
			if (applyConferenceVO.getMainConference() != null) {
				sqlstr.append(" , mainConference=? ");
				super.addStringForField(applyConferenceVO.getMainConference());
			}

			if (applyConferenceVO.getCountNumber() != null) {
				sqlstr.append(" , countNumber=? ");
				super.addStringForField(applyConferenceVO.getCountNumber());
			}
			
			if (applyConferenceVO.getFlowId() != null) {
				sqlstr.append(" , flowId=? ");
				super.addStringForField(applyConferenceVO.getFlowId());
			}
			sqlstr.append(" where applyID in (?) ");
			if (applyConferenceVO.getApplyID() != null) {
				super.addStringForField(applyConferenceVO.getApplyID());
			}
		} else if (DEL_APPLYCONFERENCE == operatorType) {
			sqlstr.append("delete  from  avic_t_vc_apply_info ");
			sqlstr.append(" where applyID =? ");
			super.addStringForField(applyConferenceVO.getApplyID());
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
