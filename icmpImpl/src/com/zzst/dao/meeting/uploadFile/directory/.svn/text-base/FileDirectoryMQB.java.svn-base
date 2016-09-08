package com.zzst.dao.meeting.uploadFile.directory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.uploadFile.directory.FileDirectoryVO;

/**
 * class description: FileDirectory MQB
 * 
 * @date Mon May 06 14:16:25 CST 2013
 * @author ryan
 */
public class FileDirectoryMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(FileDirectoryMQB.class.getName());

	public static int QUERY_FROM_FILEDIRECTORY = 1;
	public static int QUERY_FROM_FILEDIRECTORY_BY_IDS = 2;

	private FileDirectoryVO fileDirectoryVO;
	private ArrayList<FileDirectoryVO> listFileDirectory = new ArrayList<FileDirectoryVO>();

	private int _operatorType = -1;
	private String ids = "";

	public FileDirectoryMQB(int operatorType, FileDirectoryVO fileDirectoryVO) {
		_operatorType = operatorType;
		this.fileDirectoryVO = fileDirectoryVO;
		makeSql();
	}

	public FileDirectoryMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select dirID,name,parentID,status,updateUserID,updateTime,description,revision ");
		strsql.append(" from z_t_upload_file_directory ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_FILEDIRECTORY == _operatorType) {
			if (null != fileDirectoryVO) {
				if (!StringUtils.isNullOrBlank(fileDirectoryVO.getDirID())) {
					strsql.append(" and dirID= ? ");
					super.addStringForField(fileDirectoryVO.getDirID());
				}
				if (!StringUtils.isNullOrBlank(fileDirectoryVO.getName())) {
					strsql.append(" and name= ? ");
					super.addStringForField(fileDirectoryVO.getName());
				}
				if (!StringUtils.isNullOrBlank(fileDirectoryVO.getParentID())) {
					strsql.append(" and parentID= ? ");
					super.addStringForField(fileDirectoryVO.getParentID());
				}
				if (Integer.MIN_VALUE != fileDirectoryVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(fileDirectoryVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(fileDirectoryVO.getUpdateUserID())) {
					strsql.append(" and updateUserID= ? ");
					super.addStringForField(fileDirectoryVO.getUpdateUserID());
				}
				if (!StringUtils.isNullOrBlank(fileDirectoryVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(fileDirectoryVO.getDescription());
				}
				if (Long.MIN_VALUE != fileDirectoryVO.getRevision()) {
					strsql.append(" and revision= ? ");
					super.addLongForField(fileDirectoryVO.getRevision());
				}
			}
		} else if (QUERY_FROM_FILEDIRECTORY_BY_IDS == _operatorType) {
			strsql.append(" and dirID in (?) ");
			super.addStringForField(ids);
		}
		setSql(strsql.toString());
	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public String getSql() {
		return this.sqlStr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
		fileDirectoryVO = new FileDirectoryVO();
		fileDirectoryVO.setDirID(rs.getString("dirID"));
		fileDirectoryVO.setName(rs.getString("name"));
		fileDirectoryVO.setParentID(rs.getString("parentID"));
		fileDirectoryVO.setStatus(rs.getInt("status"));
		fileDirectoryVO.setUpdateUserID(rs.getString("updateUserID"));
		fileDirectoryVO.setUpdateTime(rs.getTimestamp("updateTime"));
		fileDirectoryVO.setDescription(rs.getString("description"));
		fileDirectoryVO.setRevision(rs.getLong("revision"));
		listFileDirectory.add(fileDirectoryVO);
	}

	public ArrayList<FileDirectoryVO> getFileDirectoryList() {
		return listFileDirectory;
	}

	public FileDirectoryVO getFileDirectoryVO() {
		return fileDirectoryVO;
	}

}
