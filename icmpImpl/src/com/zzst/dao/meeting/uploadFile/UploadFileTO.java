package com.zzst.dao.meeting.uploadFile;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.meeting.uploadFile.UploadFileVO;

/**
 * class description: UploadFile TO
 * 
 * @date Thu Sep 20 14:13:12 CST 2012
 * @author ryan
 */
public class UploadFileTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(UploadFileTO.class
			.getName());
	private int operatorType = -1;

	public static int ADD_UPLOADFILE = 1;
	public static int MODIFY_UPLOADFILE = 2;
	public static int DEL_UPLOADFILE = 3;
	private int result = 0;
	public static int    MODIFY_STATE = 4;
	public static int DEL_UPLOADFILE_BY_MEETING = 5;

	private UploadFileVO uploadFileVO;
	private String ids = "";

	public UploadFileTO(int operatorType, UploadFileVO uploadFileVO) {
		this.operatorType = operatorType;
		this.uploadFileVO = uploadFileVO;
	}

	public UploadFileTO(int operatorType, String ids) {
		this.operatorType = operatorType;
		this.ids = ids;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_UPLOADFILE == operatorType) {
			sqlstr.append("insert into z_t_upload_file ");
			sqlstr
					.append("(uploadID,uploadType,uploadKey,fileName,fileType,fileUrl,createUserID,createTime,status,revision,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?,?,?,?)");
			super.addStringForField(uploadFileVO.getUploadID());
			super.addIntForField(uploadFileVO.getUploadType());
			super.addStringForField(uploadFileVO.getUploadKey());
			super.addStringForField(uploadFileVO.getFileName());
			super.addStringForField(uploadFileVO.getFileType());
			super.addStringForField(uploadFileVO.getFileUrl());
			super.addStringForField(uploadFileVO.getCreateUserID());
			super.addTimestampForField(uploadFileVO.getCreateTime());
			super.addIntForField(uploadFileVO.getStatus());
			super.addLongForField(uploadFileVO.getRevision());
			super.addStringForField(uploadFileVO.getDescription());
		} else if (MODIFY_UPLOADFILE == operatorType) {
			sqlstr.append("update  z_t_upload_file set ");
			sqlstr.append(" uploadID = uploadID ");

			if (uploadFileVO.getUploadType() != Integer.MIN_VALUE) {
				sqlstr.append(" , uploadType=?");
				super.addIntForField(uploadFileVO.getUploadType());
			}

			if (uploadFileVO.getUploadKey() != null) {
				sqlstr.append(" , uploadKey=? ");
				super.addStringForField(uploadFileVO.getUploadKey());
			}

			if (uploadFileVO.getFileName() != null) {
				sqlstr.append(" , fileName=? ");
				super.addStringForField(uploadFileVO.getFileName());
			}

			if (uploadFileVO.getFileType() != null) {
				sqlstr.append(" , fileType=?");
				super.addStringForField(uploadFileVO.getFileType());
			}

			if (uploadFileVO.getFileUrl() != null) {
				sqlstr.append(" , fileUrl=? ");
				super.addStringForField(uploadFileVO.getFileUrl());
			}

			if (uploadFileVO.getCreateUserID() != null) {
				sqlstr.append(" , createUserID=? ");
				super.addStringForField(uploadFileVO.getCreateUserID());
			}

			if (uploadFileVO.getCreateTime() != null) {
				if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
					sqlstr.append(" , createTime= ");
					sqlstr.append(UtilDAO.oracleToDate(uploadFileVO.getCreateTime()));
				}else{
					sqlstr.append(" , createTime=? ");
					super.addTimestampForField(uploadFileVO.getCreateTime());
				}
				
			}
			
			if (uploadFileVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(uploadFileVO.getStatus());
			}
			if (uploadFileVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(uploadFileVO.getRevision());
			}

			if (uploadFileVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(uploadFileVO.getDescription());
			}

			sqlstr.append(" where uploadID in (?) ");
			if (uploadFileVO.getUploadID() != null) {
				super.addStringForField(uploadFileVO.getUploadID());
			}
		} else if (DEL_UPLOADFILE == operatorType) {
			sqlstr.append("delete  from  z_t_upload_file ");
			sqlstr.append(" where uploadID in (?) ");
			super.addStringForField(uploadFileVO.getUploadID());
		} else if (MODIFY_STATE == operatorType) {
			sqlstr.append("update  z_t_upload_file set");
			sqlstr.append(" status= "+FileEnum.STATUS_INVALID);
			sqlstr.append(" where uploadID in (?) ");
			super.addStringForField(uploadFileVO.getUploadID());
		}else if (DEL_UPLOADFILE_BY_MEETING == operatorType){
			sqlstr.append("delete from z_t_upload_file ");
			sqlstr.append("where uploadkey in (?)");
			sqlstr.append(" and uploadType in (?)");
			super.addStringForField(uploadFileVO.getUploadKey());
			super.addIntForField(uploadFileVO.getUploadType());
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
