package com.zzst.dao.meeting.uploadFile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.gsiec.cbimpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.uploadFile.UploadFileVO;

/**
 * class description: UploadFile MQB
 * 
 * @date Thu Sep 20 14:13:12 CST 2012
 * @author ryan
 */
public class UploadFileMQB extends MasterQueryObject {
	public static final int QUERYBASEINFO_FROM_UPLOADFILE = 3;

	static Logger logger = CbfLogger.getLogger(UploadFileMQB.class.getName());

	public static int QUERY_FROM_UPLOADFILE = 1;
	public static int QUERY_FROM_UPLOADFILE_BY_IDS = 2;

	private UploadFileVO uploadFileVO;
	private ArrayList<UploadFileVO> listUploadFile = new ArrayList<UploadFileVO>();

	private int _operatorType = -1;
	private String ids = "";

	public UploadFileMQB(int operatorType, UploadFileVO uploadFileVO) {
		_operatorType = operatorType;
		this.uploadFileVO = uploadFileVO;
		makeSql();
	}

	public UploadFileMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(uploadFileVO.getUploadType()==FileEnum.RULE_FILE){
			strsql.append("select uf.*,d.name departName,u.fullName ");
			strsql.append(" from z_t_upload_file uf,z_t_department d,z_t_user u");
			strsql.append(" where 1=1 and uf.uploadKey=d.id AND uf.createUserID=u.userID and uf.status = " + FileEnum.STATUS_VALID);
			strsql.append(" and uploadType = "+FileEnum.RULE_FILE);
		}else if(uploadFileVO.getUploadType()==FileEnum.MEETING_FILE||uploadFileVO.getUploadType()==FileEnum.MEETING_RECORD_FILE){
			strsql.append("select uf.*,m.meetingName,m.startTime,m.endTime,m.status mStatus,m.createUserID mCreateUserID,m.createTime mCreateTime,m.description mDescription,u.fullName,u.loginName");
			strsql.append(" from z_t_upload_file uf,z_t_meetingdetail m,z_t_user u");
			strsql.append(" where 1=1 and uf.uploadKey=m.meetingDetailID and uf.createUserID=u.userID");
			strsql.append(" and uf.status!="+FileEnum.STATUS_INVALID+" and m.status!="+MeetingDetailEnum.STATUS_INVALID+" and u.status!="+UserEnum.INVALID);
			strsql.append(" and uploadType in("+FileEnum.MEETING_FILE+","+FileEnum.MEETING_RECORD_FILE+")");
		}else if(uploadFileVO.getUploadType()==FileEnum.MEETINGROOM_FILE){
			strsql.append("select uf.*,mr.meetingRoomName,mr.status mrStatus,mr.adminID,u.fullName,u.loginName");
			strsql.append(" from z_t_upload_file uf,z_t_meetingroom mr,z_t_user u");
			strsql.append(" where 1=1 and uf.uploadKey=mr.meetingRoomID and uf.createUserID=u.userID");
			strsql.append(" and uf.status="+FileEnum.STATUS_VALID+" and mr.status!="+MeetingRoomEnum.ROOM_STATUS_INVALID+" and u.status!="+UserEnum.INVALID);
			strsql.append(" and uploadType = "+FileEnum.MEETINGROOM_FILE);
		}else if(uploadFileVO.getUploadType()==FileEnum.EQUIPMENT_FILE){
			strsql.append("SELECT uf.*,e.equipmentID,e.equipmentName,e.equipmentType,e.status eStatus,e.ip,e.port,e.equipmentNO,e.adminID,e.roomID,u.fullName");
			strsql.append(" FROM z_t_upload_file uf,z_t_equipment e,z_t_user u");
			strsql.append(" where 1=1 AND uf.uploadKey=e.equipmentID AND uf.createUserID=u.userID");
			strsql.append(" and uf.status="+FileEnum.STATUS_VALID+" AND e.status!=3 and u.status!="+UserEnum.INVALID);
			strsql.append(" and uploadType = "+FileEnum.EQUIPMENT_FILE);
		}

		if (QUERY_FROM_UPLOADFILE == _operatorType) {
			if (null != uploadFileVO) {
				if (!StringUtils.isNullOrBlank(uploadFileVO.getUploadID())) {
					strsql.append(" and uf.uploadID= ? ");
					super.addStringForField(uploadFileVO.getUploadID());
				}
				/**
				if (Integer.MIN_VALUE != uploadFileVO.getUploadType()) {
					strsql.append(" and uf.uploadType= ? ");
					super.addIntForField(uploadFileVO.getUploadType());
				}
				*/
				if (!StringUtils.isNullOrBlank(uploadFileVO.getUploadKey())) {
					strsql.append(" and uf.uploadKey= ? ");
					super.addStringForField(uploadFileVO.getUploadKey());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getFileName())) {
					strsql.append(" and uf.fileName like '%" + uploadFileVO.getFileName().trim() + "%'");
					//super.addStringForField(uploadFileVO.getFileName());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getFileType())) {
					strsql.append(" and uf.fileType= ? ");
					super.addStringForField(uploadFileVO.getFileType());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getFileUrl())) {
					strsql.append(" and uf.fileUrl= ? ");
					super.addStringForField(uploadFileVO.getFileUrl());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getCreateUserID())) {
					strsql.append(" and uf.createUserID= ? ");
					super.addStringForField(uploadFileVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != uploadFileVO.getStatus()) {
					strsql.append(" and uf.status= ? ");
					super.addIntForField(uploadFileVO.getStatus());
				}
				if (Long.MIN_VALUE != uploadFileVO.getRevision()) {
					strsql.append(" and uf.revision= ? ");
					super.addLongForField(uploadFileVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getDescription())) {
					strsql.append(" and uf.description= ? ");
					super.addStringForField(uploadFileVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getCreateTime())) {
					strsql.append(" and uf.createTime>= ? ");
					super.addTimestampForField(uploadFileVO.getCreateTime());
				}
				if(!StringUtils.isNullOrBlank(uploadFileVO.getMeetingDetailVO().getMeetingName())){
					strsql.append(" and m.meetingName like '%" + uploadFileVO.getMeetingDetailVO().getMeetingName().trim() + "%'");
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getMeetingDetailVO().getMeetingStartTime())) {
					strsql.append(" and m.startTime>= ? ");
					super.addTimestampForField(uploadFileVO.getMeetingDetailVO().getMeetingStartTime());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getMeetingDetailVO().getMeetingEndTime())) {
					strsql.append(" and m.endTime<= ? ");
					super.addTimestampForField(uploadFileVO.getMeetingDetailVO().getMeetingEndTime());
				}
				//会议室资料
				if(!StringUtils.isNullOrBlank(uploadFileVO.getMeetingRoomVO().getMeetingRoomName())){
					strsql.append(" and mr.meetingRoomName like '%" + uploadFileVO.getMeetingRoomVO().getMeetingRoomName().trim() + "%'");
				}
				//设备资料
				if(Integer.MIN_VALUE != uploadFileVO.getEquipmentVO().getEquipmentType()){
					strsql.append(" and eum.equipmentType= ? ");
					super.addIntForField(uploadFileVO.getEquipmentVO().getEquipmentType());
				}
				if(!StringUtils.isNullOrBlank(uploadFileVO.getEquipmentVO().getEquipmentNO())){
					strsql.append(" and eum.equipmentNO like '%" + uploadFileVO.getEquipmentVO().getEquipmentNO().trim() + "%'");
				}
			}
			strsql.append(" order by uf.createTime desc");
		} else if (QUERY_FROM_UPLOADFILE_BY_IDS == _operatorType) {
			strsql.append(" and uf.uploadID in (?) ");
			super.addStringForField(ids);
		} else if (QUERYBASEINFO_FROM_UPLOADFILE == _operatorType) {
			if (null != uploadFileVO) {
				if (!StringUtils.isNullOrBlank(uploadFileVO.getUploadID())) {
					strsql.append(" and uf.uploadID= ? ");
					super.addStringForField(uploadFileVO.getUploadID());
				}
				if (Integer.MIN_VALUE != uploadFileVO.getUploadType()) {
					strsql.append(" and uf.uploadType= ? ");
					super.addIntForField(uploadFileVO.getUploadType());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getUploadKey())) {
					strsql.append(" and uf.uploadKey= ? ");
					super.addStringForField(uploadFileVO.getUploadKey());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getFileName())) {
					strsql.append(" and uf.fileName= ? ");
					super.addStringForField(uploadFileVO.getFileName());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getFileType())) {
					strsql.append(" and uf.fileType= ? ");
					super.addStringForField(uploadFileVO.getFileType());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getFileUrl())) {
					strsql.append(" and uf.fileUrl= ? ");
					super.addStringForField(uploadFileVO.getFileUrl());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getCreateUserID())) {
					strsql.append(" and uf.createUserID= ? ");
					super.addStringForField(uploadFileVO.getCreateUserID());
				}
				if (Integer.MIN_VALUE != uploadFileVO.getStatus()) {
					strsql.append(" and uf.status= ? ");
					super.addIntForField(uploadFileVO.getStatus());
				}
				if (Long.MIN_VALUE != uploadFileVO.getRevision()) {
					strsql.append(" and uf.revision= ? ");
					super.addLongForField(uploadFileVO.getRevision());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getDescription())) {
					strsql.append(" and uf.description= ? ");
					super.addStringForField(uploadFileVO.getDescription());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getCreateTime())) {
					if(CbfConfig.DB_TYPE.equals(CbfConfig.DB_TYPE_ORACLE)){
						strsql.append(" and uf.createTime=  "+UtilDAO.oracleToDate(uploadFileVO.getCreateTime()));
					}else{
					strsql.append(" and uf.createTime= ? ");
					super.addTimestampForField(uploadFileVO.getCreateTime());
					}
					System.out.println(uploadFileVO.getCreateTime());
					
				}
				if(!StringUtils.isNullOrBlank(uploadFileVO.getMeetingDetailVO().getMeetingName())){
					strsql.append(" and m.meetingName= ? ");
					super.addStringForField(uploadFileVO.getMeetingDetailVO().getMeetingName());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getMeetingDetailVO().getMeetingStartTime())) {
					strsql.append(" and m.startTime= ? ");
					super.addTimestampForField(uploadFileVO.getMeetingDetailVO().getMeetingStartTime());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getMeetingDetailVO().getMeetingEndTime())) {
					strsql.append(" and m.endTime= ? ");
					super.addTimestampForField(uploadFileVO.getMeetingDetailVO().getMeetingEndTime());
				}
			}
			strsql.append(" order by uf.createTime desc");
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
		uploadFileVO = new UploadFileVO();
		uploadFileVO.setUploadID(rs.getString("uploadID"));
		uploadFileVO.setUploadType(rs.getInt("uploadType"));
		uploadFileVO.setUploadKey(rs.getString("uploadKey"));
		uploadFileVO.setFileName(rs.getString("fileName"));
		uploadFileVO.setFileType(rs.getString("fileType"));
		uploadFileVO.setFileUrl(rs.getString("fileUrl"));
		uploadFileVO.setCreateUserID(rs.getString("createUserID"));
		uploadFileVO.setCreateTime(rs.getTimestamp("createTime"));
		uploadFileVO.setStatus(rs.getInt("status"));
		uploadFileVO.setRevision(rs.getLong("revision"));
		uploadFileVO.setDescription(rs.getString("description"));
		uploadFileVO.getUserVO().setName(rs.getString("fullName"));
		if(uploadFileVO.getUploadType()==FileEnum.RULE_FILE){
			uploadFileVO.getDepartmentVO().setTitle(rs.getString("departName"));
		}
		if(uploadFileVO.getUploadType()==FileEnum.MEETINGROOM_FILE){
			uploadFileVO.getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingRoomName"));
			uploadFileVO.getMeetingRoomVO().setStatus(rs.getInt("mrStatus"));
		}
		if(uploadFileVO.getUploadType()==FileEnum.EQUIPMENT_FILE){
			uploadFileVO.getEquipmentVO().setEquipmentNO(rs.getString("equipmentNO"));
			uploadFileVO.getEquipmentVO().setEquipmentName(rs.getString("equipmentName"));
			uploadFileVO.getEquipmentVO().setEquipmentType(rs.getInt("equipmentType"));
			uploadFileVO.getEquipmentVO().setStatus(rs.getInt("eStatus"));
			uploadFileVO.getEquipmentVO().setIp(rs.getString("ip"));
			uploadFileVO.getEquipmentVO().setPort(rs.getInt("port"));
		}
		if(uploadFileVO.getUploadType()==FileEnum.MEETING_FILE||uploadFileVO.getUploadType()==FileEnum.MEETING_RECORD_FILE){
			uploadFileVO.getMeetingDetailVO().setMeetingName(rs.getString("meetingName"));
			uploadFileVO.getMeetingDetailVO().setMeetingStartTime(rs.getTimestamp("startTime"));
			uploadFileVO.getMeetingDetailVO().setMeetingEndTime(rs.getTimestamp("endTime"));
			uploadFileVO.getMeetingDetailVO().setStatus(rs.getString("mStatus"));
			uploadFileVO.getMeetingDetailVO().setMeetingDescription(rs.getString("mDescription"));
		}
		listUploadFile.add(uploadFileVO);
	}

	public ArrayList<UploadFileVO> getUploadFileList() {
		return listUploadFile;
	}

	public UploadFileVO getUploadFileVO() {
		return uploadFileVO;
	}

}
