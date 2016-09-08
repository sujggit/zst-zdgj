package com.zzst.dao.project.avic.videoConferenceFeedBack;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackVO;

/**
 * class description: VideoConferenceFeedBack TO
 * 
 * @date Tue Sep 25 17:18:45 CST 2012
 * @author ryan
 */
public class VideoConferenceFeedBackTO extends TransactionObject {

	private static Logger logger = CbfLogger
			.getLogger(VideoConferenceFeedBackTO.class.getName());
	private int operatorType = -1;

	public static int ADD_VIDEOCONFERENCEFEEDBACK = 1;
	public static int MODIFY_VIDEOCONFERENCEFEEDBACK = 2;
	public static int DEL_VIDEOCONFERENCEFEEDBACK = 3;
	private int result = 0;

	private VideoConferenceFeedBackVO videoConferenceFeedBackVO;
	private String ids = "";

	public VideoConferenceFeedBackTO(int operatorType,
			VideoConferenceFeedBackVO videoConferenceFeedBackVO) {
		this.operatorType = operatorType;
		this.videoConferenceFeedBackVO = videoConferenceFeedBackVO;
	}

	public VideoConferenceFeedBackTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_VIDEOCONFERENCEFEEDBACK == operatorType) {
			sqlstr.append("insert into avic_t_vc_feedback ");
			sqlstr
					.append("(feedBackID,departmentID,departmentName,departmentCode,meetingDetailID,meetingDetailName,meetingDetailTime,userName,userPhone,bBuDes,flowID,createUserID,createTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(videoConferenceFeedBackVO.getFeedBackID());
			super
					.addStringForField(videoConferenceFeedBackVO
							.getDepartmentID());
			super.addStringForField(videoConferenceFeedBackVO
					.getDepartmentName());
			super.addStringForField(videoConferenceFeedBackVO
					.getDepartmentCode());
			super.addStringForField(videoConferenceFeedBackVO
					.getMeetingDetailID());
			super.addStringForField(videoConferenceFeedBackVO
					.getMeetingDetailName());
			super.addTimestampForField(videoConferenceFeedBackVO
					.getMeetingDetailTime());
			super.addStringForField(videoConferenceFeedBackVO.getUserName());
			super.addStringForField(videoConferenceFeedBackVO.getUserPhone());
			super.addStringForField(videoConferenceFeedBackVO.getBBuDes());
			super.addStringForField(videoConferenceFeedBackVO.getFlowID());
			super
					.addStringForField(videoConferenceFeedBackVO
							.getCreateUserID());
			super.addTimestampForField(videoConferenceFeedBackVO
					.getCreateTime());
			super.addIntForField(videoConferenceFeedBackVO.getStatus());
			super.addLongForField(videoConferenceFeedBackVO.getRevision());
			super.addStringForField(videoConferenceFeedBackVO.getDescription());
		} else if (MODIFY_VIDEOCONFERENCEFEEDBACK == operatorType) {
			sqlstr.append("update  avic_t_vc_feedback set ");
			sqlstr.append(" feedBackID = feedBackID ");

			if (videoConferenceFeedBackVO.getDepartmentID() != null) {
				sqlstr.append(" , departmentID=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getDepartmentID());
			}

			if (videoConferenceFeedBackVO.getDepartmentName() != null) {
				sqlstr.append(" , departmentName=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getDepartmentName());
			}

			if (videoConferenceFeedBackVO.getDepartmentCode() != null) {
				sqlstr.append(" , departmentCode=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getDepartmentCode());
			}

			if (videoConferenceFeedBackVO.getMeetingDetailID() != null) {
				sqlstr.append(" , meetingDetailID=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getMeetingDetailID());
			}

			if (videoConferenceFeedBackVO.getMeetingDetailName() != null) {
				sqlstr.append(" , meetingDetailName=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getMeetingDetailName());
			}

			if (videoConferenceFeedBackVO.getMeetingDetailTime() != null) {
				sqlstr.append(" , meetingDetailTime=? ");
				super.addTimestampForField(videoConferenceFeedBackVO
						.getMeetingDetailTime());
			}

			if (videoConferenceFeedBackVO.getUserName() != null) {
				sqlstr.append(" , userName=? ");
				super
						.addStringForField(videoConferenceFeedBackVO
								.getUserName());
			}

			if (videoConferenceFeedBackVO.getUserPhone() != null) {
				sqlstr.append(" , userPhone=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getUserPhone());
			}

			if (videoConferenceFeedBackVO.getBBuDes() != null) {
				sqlstr.append(" , bBuDes=? ");
				super.addStringForField(videoConferenceFeedBackVO.getBBuDes());
			}

			if (videoConferenceFeedBackVO.getFlowID() != null) {
				sqlstr.append(" , flowID=? ");
				super.addStringForField(videoConferenceFeedBackVO.getFlowID());
			}

			if (videoConferenceFeedBackVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getCreateUserID());
			}

			if (videoConferenceFeedBackVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(videoConferenceFeedBackVO
						.getCreateTime());
			}

			if (videoConferenceFeedBackVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(videoConferenceFeedBackVO.getStatus());
			}

			if (videoConferenceFeedBackVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(videoConferenceFeedBackVO.getRevision());
			}

			if (videoConferenceFeedBackVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(videoConferenceFeedBackVO
						.getDescription());
			}

			sqlstr.append(" where feedBackID in (?) ");
			if (videoConferenceFeedBackVO.getFeedBackID() != null) {
				super.addStringForField(videoConferenceFeedBackVO
						.getFeedBackID());
			}
		} else if (DEL_VIDEOCONFERENCEFEEDBACK == operatorType) {
			sqlstr.append("delete  from  avic_t_vc_feedback ");
			sqlstr.append(" where feedBackID in (?) ");
			super.addStringForField(videoConferenceFeedBackVO.getFeedBackID());
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
