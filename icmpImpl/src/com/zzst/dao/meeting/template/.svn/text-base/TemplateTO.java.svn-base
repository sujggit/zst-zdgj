package com.zzst.dao.meeting.template;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.template.TemplateVO;

/**
 * class description: Template TO
 * 
 * @date Wed Mar 20 17:56:26 CST 2013
 * @author ryan
 */
public class TemplateTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(TemplateTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_TEMPLATE = 1;
	public static int MODIFY_TEMPLATE = 2;
	public static int DEL_TEMPLATE = 3;
	private int result = 0;

	private TemplateVO templateVO;
	private String ids = "";

	public TemplateTO(int operatorType, TemplateVO templateVO) {
		this.operatorType = operatorType;
		this.templateVO = templateVO;
	}

	public TemplateTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_TEMPLATE == operatorType) {
			sqlstr.append("insert into z_t_template ");
			sqlstr
					.append("(id,templateName,duration,createUserID,createTime,updateTime,status,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			super.addStringForField(templateVO.getId());
			super.addStringForField(templateVO.getTemplateName());
			super.addStringForField(templateVO.getDuration());
			super.addStringForField(templateVO.getCreateUserID());
			super.addTimestampForField(templateVO.getCreateTime());
			super.addTimestampForField(templateVO.getUpdateTime());
			super.addIntForField(templateVO.getStatus());
			super.addStringForField(templateVO.getDescription());
		} else if (MODIFY_TEMPLATE == operatorType) {
			sqlstr.append("update  z_t_template set ");
			sqlstr.append(" id = id ");

			if (templateVO.getTemplateName() != null) {
				sqlstr.append(" , templateName=? ");
				super.addStringForField(templateVO.getTemplateName());
			}

			if (templateVO.getDuration() != null) {
				sqlstr.append(" , duration=?");
				super.addStringForField(templateVO.getDuration());
			}

			if (templateVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(templateVO.getCreateUserID());
			}

			if (templateVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(templateVO.getCreateTime());
			}

			if (templateVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(templateVO.getUpdateTime());
			}

			if (templateVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(templateVO.getStatus());
			}

			if (templateVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(templateVO.getDescription());
			}

			sqlstr.append(" where id in (?) ");
			if (templateVO.getId() != null) {
				super.addStringForField(templateVO.getId());
			}
		} else if (DEL_TEMPLATE == operatorType) {
			sqlstr.append("delete  from  z_t_template ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(templateVO.getId());
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
