package com.zzst.dao.meeting.uploadFile.directory;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.uploadFile.directory.FileDirectoryVO;

/**
 * class description: FileDirectory TO
 * 
 * @date Mon May 06 14:16:25 CST 2013
 * @author ryan
 */
public class FileDirectoryTO extends TransactionObject {

	private static Logger logger = CbfLogger.getLogger(FileDirectoryTO.class.getName());
	private int operatorType = -1;

	public static int ADD_FILEDIRECTORY = 1;
	public static int MODIFY_FILEDIRECTORY = 2;
	public static int DEL_FILEDIRECTORY = 3;
	private int result = 0;

	private FileDirectoryVO fileDirectoryVO;

	public FileDirectoryTO(int operatorType, FileDirectoryVO fileDirectoryVO) {
		this.operatorType = operatorType;
		this.fileDirectoryVO = fileDirectoryVO;
	}

	public void setSqlStr() {
		StringBuffer sqlstr = new StringBuffer();
		if (ADD_FILEDIRECTORY == operatorType) {
			sqlstr.append("insert into z_t_upload_file_directory ");
			sqlstr.append("(dirID,name,parentID,status,updateUserID,updateTime,description,revision)");
			sqlstr.append(" values (?,?,?,?,?,?,?,?)");
			super.addStringForField(fileDirectoryVO.getDirID());
			super.addStringForField(fileDirectoryVO.getName());
			super.addStringForField(fileDirectoryVO.getParentID());
			super.addIntForField(fileDirectoryVO.getStatus());
			super.addStringForField(fileDirectoryVO.getUpdateUserID());
			super.addTimestampForField(fileDirectoryVO.getUpdateTime());
			super.addStringForField(fileDirectoryVO.getDescription());
			super.addLongForField(fileDirectoryVO.getRevision());
		} else if (MODIFY_FILEDIRECTORY == operatorType) {
			sqlstr.append("update  z_t_upload_file_directory set ");
			sqlstr.append(" dirID = dirID ");

			if (fileDirectoryVO.getName() != null) {
				sqlstr.append(" , name=? ");
				super.addStringForField(fileDirectoryVO.getName());
			}

			if (fileDirectoryVO.getParentID() != null) {
				sqlstr.append(" , parentID=? ");
				super.addStringForField(fileDirectoryVO.getParentID());
			}

			if (fileDirectoryVO.getStatus() != Integer.MIN_VALUE) {
				sqlstr.append(" , status=?");
				super.addIntForField(fileDirectoryVO.getStatus());
			}

			if (fileDirectoryVO.getUpdateUserID() != null) {
				sqlstr.append(" , updateUserID=? ");
				super.addStringForField(fileDirectoryVO.getUpdateUserID());
			}

			if (fileDirectoryVO.getUpdateTime() != null) {
				sqlstr.append(" , updateTime=? ");
				super.addTimestampForField(fileDirectoryVO.getUpdateTime());
			}

			if (fileDirectoryVO.getDescription() != null) {
				sqlstr.append(" , description=? ");
				super.addStringForField(fileDirectoryVO.getDescription());
			}

			if (fileDirectoryVO.getRevision() != Long.MIN_VALUE) {
				sqlstr.append(" , revision=? ");
				super.addLongForField(fileDirectoryVO.getRevision());
			}

			sqlstr.append(" where dirID in (?) ");
			if (fileDirectoryVO.getDirID() != null) {
				super.addStringForField(fileDirectoryVO.getDirID());
			}
		} else if (DEL_FILEDIRECTORY == operatorType) {
			sqlstr.append("delete  from  z_t_upload_file_directory ");
			sqlstr.append(" where dirID in (?) ");
			super.addStringForField(fileDirectoryVO.getDirID());
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
