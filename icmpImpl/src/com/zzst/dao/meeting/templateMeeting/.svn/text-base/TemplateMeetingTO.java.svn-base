package com.zzst.dao.meeting.templateMeeting;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.templateMeeting.TemplateMeetingVO;

/**
 * class description: TemplateMeeting TO
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public class TemplateMeetingTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(TemplateMeetingTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_TEMPLATEMEETING = 1;
	public static int MODIFY_TEMPLATEMEETING = 2;
	public static int DEL_TEMPLATEMEETING = 3;
	public static int DEL_TEMPLATEMEETING_BYTEMPLATEID = 4;
	private int result = 0;

	private TemplateMeetingVO templateMeetingVO;
	private String ids = "";

	public TemplateMeetingTO(int operatorType,
			TemplateMeetingVO templateMeetingVO) {
		this.operatorType = operatorType;
		this.templateMeetingVO = templateMeetingVO;
	}

	public TemplateMeetingTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_TEMPLATEMEETING == operatorType) {
			sqlstr.append("insert into z_t_template_meeting ");
			sqlstr
					.append("(id,templateId,meetingName,meetingNumber,mcuEquipmentId,isMain,parentId,groupId,mcuTemplateID,createUserID,createTime,updateTime,status,description,rank)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(templateMeetingVO.getId());
			super.addStringForField(templateMeetingVO.getTemplateId());
			super.addStringForField(templateMeetingVO.getMeetingName());
			super.addStringForField(templateMeetingVO.getMeetingNumber());
			super.addStringForField(templateMeetingVO.getMcuEquipmentId());
			super.addIntForField(templateMeetingVO.getIsMain());
			super.addStringForField(templateMeetingVO.getParentId());
			super.addStringForField(templateMeetingVO.getGroupId());
			super.addStringForField(templateMeetingVO.getMcuTemplateID());
			super.addStringForField(templateMeetingVO.getCreateUserID());
			super.addTimestampForField(templateMeetingVO.getCreateTime());
			super.addTimestampForField(templateMeetingVO.getUpdateTime());
			super.addIntForField(templateMeetingVO.getStatus());
			super.addStringForField(templateMeetingVO.getDescription());
			super.addIntForField(templateMeetingVO.getRank());
		} else if (MODIFY_TEMPLATEMEETING == operatorType) {
			sqlstr.append("update  z_t_template_meeting set ");
			sqlstr.append(" id = id ");

			if (templateMeetingVO.getTemplateId() != null) {
				sqlstr.append(" , templateId=? ");
				super.addStringForField(templateMeetingVO.getTemplateId());
			}

			if (templateMeetingVO.getMeetingName() != null) {
				sqlstr.append(" , meetingName=? ");
				super.addStringForField(templateMeetingVO.getMeetingName());
			}

			if (templateMeetingVO.getMeetingNumber() != null) {
				sqlstr.append(" , meetingNumber=? ");
				super.addStringForField(templateMeetingVO.getMeetingNumber());
			}

			if (templateMeetingVO.getMcuEquipmentId() != null) {
				sqlstr.append(" , mcuEquipmentId=? ");
				super.addStringForField(templateMeetingVO.getMcuEquipmentId());
			}

			if (templateMeetingVO.getIsMain() != Integer.MIN_VALUE) {
				sqlstr.append(" , isMain=?");
				super.addIntForField(templateMeetingVO.getIsMain());
			}

			if (templateMeetingVO.getParentId() != null) {
				sqlstr.append(" , parentId=? ");
				super.addStringForField(templateMeetingVO.getParentId());
			}

			if (templateMeetingVO.getGroupId() != null) {
				sqlstr.append(" , groupId=? ");
				super.addStringForField(templateMeetingVO.getGroupId());
			}

			if (templateMeetingVO.getMcuTemplateID() != null) {
				sqlstr.append(" , mcuTemplateID=? ");
				super.addStringForField(templateMeetingVO.getMcuTemplateID());
			}

			if (templateMeetingVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(templateMeetingVO.getCreateUserID());
			}

			if (templateMeetingVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(templateMeetingVO.getCreateTime());
			}

			if (templateMeetingVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(templateMeetingVO.getUpdateTime());
			}

			if (templateMeetingVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(templateMeetingVO.getStatus());
			}
			
			if (templateMeetingVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(templateMeetingVO.getDescription());
			}
			
			if (templateMeetingVO.getRank() != Integer.MIN_VALUE) {
				sqlstr.append(" , rank=?");
				super.addIntForField(templateMeetingVO.getRank());
			}
			
			sqlstr.append(" where id in (?) ");
			if (templateMeetingVO.getId() != null) {
				super.addStringForField(templateMeetingVO.getId());
			}
		} else if (DEL_TEMPLATEMEETING == operatorType) {
			sqlstr.append("delete  from  z_t_template_meeting ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(templateMeetingVO.getId());
		} else if (DEL_TEMPLATEMEETING_BYTEMPLATEID == operatorType){
			sqlstr.append("delete from z_t_template_meeting");
			sqlstr.append(" where templateId = ?");
			super.addStringForField(ids);
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
