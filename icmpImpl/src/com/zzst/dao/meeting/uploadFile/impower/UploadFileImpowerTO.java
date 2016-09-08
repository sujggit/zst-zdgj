package com.zzst.dao.meeting.uploadFile.impower;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;

/**
 * class description: UploadFileImpower TO
 * 
 * @date Mon May 27 18:11:34 CST 2013
 * @author ryan
 */
public class UploadFileImpowerTO extends TransactionObject {

	public static final int DEL_UPLOADID_UPLOADFILEIMPOWER = 4;
	public static final int DEL_UPLOADFILEIMPOWER_BYUSERS = 5;
	public static final int DELETE_UPLOADFILEIMPOWER = 6;
	private static Logger logger = CbfLogger
			.getLogger(UploadFileImpowerTO.class.getName());
	private int operatorType = -1;
	private String uploadId;
	private String userIDs;
	private int status;

	public static int ADD_UPLOADFILEIMPOWER = 1;
	public static int MODIFY_UPLOADFILEIMPOWER = 2;
	public static int DEL_UPLOADFILEIMPOWER = 3;
	private int result = 0;

	private UploadFileImpowerVO uploadFileImpowerVO;

	public UploadFileImpowerTO(int operatorType,
			UploadFileImpowerVO uploadFileImpowerVO) {
		this.operatorType = operatorType;
		this.uploadFileImpowerVO = uploadFileImpowerVO;
	}
	public UploadFileImpowerTO(int operatorType,
			String uploadId, String userIDs, int status) {
		this.operatorType = operatorType;
		this.uploadId = uploadId;
		this.userIDs = userIDs;
		this.status = status;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_UPLOADFILEIMPOWER == operatorType) {
			sqlstr.append("insert into z_t_upload_file_impower ");
			sqlstr.append("(id,uploadId,userId,createUserId,createTime,endTime,status,description)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			super.addStringForField(uploadFileImpowerVO.getId());
			super.addStringForField(uploadFileImpowerVO.getUploadId());
			super.addStringForField(uploadFileImpowerVO.getUserId());
			super.addStringForField(uploadFileImpowerVO.getCreateUserId());
			super.addTimestampForField(uploadFileImpowerVO.getCreateTime());
			super.addTimestampForField(uploadFileImpowerVO.getEndTime());
			super.addIntForField(uploadFileImpowerVO.getStatus());
			super.addStringForField(uploadFileImpowerVO.getDescription());
		} else if (MODIFY_UPLOADFILEIMPOWER == operatorType) {
			sqlstr.append("update  z_t_upload_file_impower set ");
			sqlstr.append(" id = id ");

			if (uploadFileImpowerVO.getCreateUserId() != null) {
				sqlstr.append(" , createUserId=? ");
				super.addStringForField(uploadFileImpowerVO.getCreateUserId());
			}
			if (uploadFileImpowerVO.getCreateTime() != null) {
				sqlstr.append(" , createTime=? ");
				super.addTimestampForField(uploadFileImpowerVO.getCreateTime());
			}
			if (uploadFileImpowerVO.getEndTime() != null) {
				sqlstr.append(" , endTime=? ");
				super.addTimestampForField(uploadFileImpowerVO.getEndTime());
			}
			if (uploadFileImpowerVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(uploadFileImpowerVO.getStatus());
			}
			if (uploadFileImpowerVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(uploadFileImpowerVO.getDescription());
			}
//			sqlstr.append(" where id in (?) ");20131227根据uploadId和userId来修改
//			if (uploadFileImpowerVO.getId() != null) {
//				super.addStringForField(uploadFileImpowerVO.getId());
//			}
			if (uploadFileImpowerVO.getUploadId() != null && uploadFileImpowerVO.getUserId() != null) {
				sqlstr.append(" where uploadId='"+uploadFileImpowerVO.getUploadId()+"' and userId='"+uploadFileImpowerVO.getUserId()+"'");
			}else{
				sqlstr = new StringBuffer();
			}
		} else if (DEL_UPLOADFILEIMPOWER == operatorType) {
			sqlstr.append("delete  from  z_t_upload_file_impower ");
			sqlstr.append(" where id in (?) ");
			super.addStringForField(uploadFileImpowerVO.getId());
		} else if (DEL_UPLOADID_UPLOADFILEIMPOWER == operatorType) {
			sqlstr.append("update  z_t_upload_file_impower set ");
			sqlstr.append(" status="+FileEnum.STATUS_IMPOWER_VISIBLE);
			sqlstr.append(" where status = " + FileEnum.STATUS_IMPOWER_DOWNLOAD);
			sqlstr.append(" and uploadId=?");
			if (uploadFileImpowerVO.getUploadId() != null) {
				super.addStringForField(uploadFileImpowerVO.getUploadId());
			}
			//super.addStringForField(uploadFileImpowerVO.getUploadId());信达现场发现的bug 20130717
		} else if (DEL_UPLOADFILEIMPOWER_BYUSERS == operatorType) {
			sqlstr.append("delete from z_t_upload_file_impower");
			sqlstr.append(" where status!=" + this.status);
			sqlstr.append(" and uploadId=?");
			if (this.uploadId != null) {
				super.addStringForField(this.uploadId);
			}
			if (this.userIDs != null) {
				sqlstr.append(" and userId in ('"+this.userIDs+"') ");
			}
			this.sqlStr = sqlstr.toString().replaceAll(",", "\',\'");
			return;
		} else if (DELETE_UPLOADFILEIMPOWER == operatorType) {
			sqlstr.append("delete from z_t_upload_file_impower");
			sqlstr.append(" where 1=1");
			if (null != uploadFileImpowerVO) {
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO.getId())) {
					sqlstr.append(" and id= ? ");
					super.addStringForField(uploadFileImpowerVO.getId());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO.getUploadId())) {
					sqlstr.append(" and uploadId= ? ");
					super.addStringForField(uploadFileImpowerVO.getUploadId());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO.getUserId())) {
					sqlstr.append(" and userId= ? ");
					super.addStringForField(uploadFileImpowerVO.getUserId());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO.getCreateUserId())) {
					sqlstr.append(" and createUserId= ? ");
					super.addStringForField(uploadFileImpowerVO.getCreateUserId());
				}
				if (Integer.MIN_VALUE != uploadFileImpowerVO.getStatus()) {
					sqlstr.append(" and status= ? ");
					super.addIntForField(uploadFileImpowerVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO.getDescription())) {
					sqlstr.append(" and description= ? ");
					super.addStringForField(uploadFileImpowerVO.getDescription());
				}
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
