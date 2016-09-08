package com.zzst.dao.meeting.uploadFile.impower;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.swh.db.model.DBFields;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;

/**
 * class description: UploadFileImpower MQB
 * 
 * @date Mon May 27 18:11:34 CST 2013
 * @author ryan
 */
public class UploadFileImpowerMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(UploadFileImpowerMQB.class
			.getName());

	public static int QUERY_FROM_UPLOADFILEIMPOWER = 1;
	public static int QUERY_FROM_UPLOADFILEIMPOWER_BY_IDS = 2;

	private UploadFileImpowerVO uploadFileImpowerVO;
	private ArrayList<UploadFileImpowerVO> listUploadFileImpower = new ArrayList<UploadFileImpowerVO>();

	private int _operatorType = -1;
	private String ids = "";

	public UploadFileImpowerMQB(int operatorType,
			UploadFileImpowerVO uploadFileImpowerVO) {
		_operatorType = operatorType;
		this.uploadFileImpowerVO = uploadFileImpowerVO;
		makeSql();
	}

	public UploadFileImpowerMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		strsql.append("select id,uploadId,userId,createUserId,createTime,endTime,status,description ");
		strsql.append(" from z_t_upload_file_impower ");
		strsql.append(" where 1=1 ");

		if (QUERY_FROM_UPLOADFILEIMPOWER == _operatorType) {
			if (null != uploadFileImpowerVO) {
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO.getId())) {
					strsql.append(" and id= ? ");
					super.addStringForField(uploadFileImpowerVO.getId());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO
						.getUploadId())) {
					strsql.append(" and uploadId= ? ");
					super.addStringForField(uploadFileImpowerVO.getUploadId());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO.getUserId())) {
					strsql.append(" and userId= ? ");
					super.addStringForField(uploadFileImpowerVO.getUserId());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO
						.getCreateUserId())) {
					strsql.append(" and createUserId= ? ");
					super.addStringForField(uploadFileImpowerVO
							.getCreateUserId());
				}
				if (Integer.MIN_VALUE != uploadFileImpowerVO.getStatus()) {
					strsql.append(" and status= ? ");
					super.addIntForField(uploadFileImpowerVO.getStatus());
				}
				if (!StringUtils.isNullOrBlank(uploadFileImpowerVO
						.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(uploadFileImpowerVO
							.getDescription());
				}
			}
		} else if (QUERY_FROM_UPLOADFILEIMPOWER_BY_IDS == _operatorType) {
			strsql.append(" and id in (?) ");
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
		uploadFileImpowerVO = new UploadFileImpowerVO();
		uploadFileImpowerVO.setId(rs.getString("id"));
		uploadFileImpowerVO.setUploadId(rs.getString("uploadId"));
		uploadFileImpowerVO.setUserId(rs.getString("userId"));
		uploadFileImpowerVO.setCreateUserId(rs.getString("createUserId"));
		uploadFileImpowerVO.setCreateTime(rs.getTimestamp("createTime"));
		uploadFileImpowerVO.setEndTime(rs.getTimestamp("endTime"));
		uploadFileImpowerVO.setStatus(rs.getInt("status"));
		uploadFileImpowerVO.setDescription(rs.getString("description"));
		listUploadFileImpower.add(uploadFileImpowerVO);
	}

	public ArrayList<UploadFileImpowerVO> getUploadFileImpowerList() {
		return listUploadFileImpower;
	}

	public UploadFileImpowerVO getUploadFileImpowerVO() {
		return uploadFileImpowerVO;
	}

}
