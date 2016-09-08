package com.zzst.dao.meeting.uploadFile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbimpl.util.StringUtils;
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
public class UploadFileMQBByPower extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(UploadFileMQBByPower.class.getName());

	public static int QUERY_FROM_UPLOADFILE_IMPOWER = 1;
	public static int QUERY_FROM_UPLOADFILE_BY_IDS = 2;

	private UploadFileVO uploadFileVO;
	private ArrayList<UploadFileVO> listUploadFile = new ArrayList<UploadFileVO>();

	private int _operatorType = -1;
	private String ids = "";

	public UploadFileMQBByPower(int operatorType, UploadFileVO uploadFileVO) {
		_operatorType = operatorType;
		this.uploadFileVO = uploadFileVO;
		makeSql();
	}

	public UploadFileMQBByPower(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		if(uploadFileVO.getUploadType()==FileEnum.RULE_FILE){
			strsql.append("select uf.*,d.name 'departName',u.fullName ");
			strsql.append(" from z_t_upload_file uf,z_t_department d,z_t_user u");
			strsql.append(" where 1=1 and uf.uploadKey=d.id and uf.createUserID=u.userID and uf.status=" + FileEnum.STATUS_VALID);
			strsql.append(" and uploadType = "+FileEnum.RULE_FILE);
		}else if(uploadFileVO.getUploadType()==FileEnum.MEETINGROOM_FILE){
			strsql.append("select uf.*,mr.meetingRoomName,mr.status mrStatus,mr.adminID,mr.departmentID,mr.name deptName,mr.aName,u.fullName,u.loginName");
			strsql.append(" from z_t_upload_file uf,(SELECT mTemp.*,d.name,a.name aName FROM z_t_meetingroom mTemp,z_t_department d,z_t_address a where mTemp.departmentID=d.id and mTemp.addressID=a.addressID) mr,z_t_user u");
			strsql.append(" where 1=1 and uf.uploadKey=mr.meetingRoomID and uf.createUserID=u.userID");
			strsql.append(" and uf.status="+FileEnum.STATUS_VALID+" and mr.status!="+MeetingRoomEnum.ROOM_STATUS_INVALID+" and u.status!="+UserEnum.INVALID);
			strsql.append(" and uploadType = "+FileEnum.MEETINGROOM_FILE);
		}else if(uploadFileVO.getUploadType()==FileEnum.EQUIPMENT_FILE){
			strsql.append("SELECT uf.*,eum.*,u.fullName FROM z_t_upload_file uf,z_t_user u");
			strsql.append(" ,(SELECT e.equipmentID,e.equipmentName,e.equipmentType,e.status eStatus,e.ip,e.port,e.equipmentNO,e.adminID,e.roomID,z_t_meetingroom.meetingroomName,z_t_user.fullName adminName,z_t_user.email,z_t_user.mobile");
			strsql.append(" FROM(z_t_equipment e INNER JOIN z_t_user ON e.adminID=z_t_user.userID)INNER JOIN z_t_meetingroom ON e.roomID=z_t_meetingroom.meetingroomID");
			strsql.append(" WHERE 1=1 AND e.status!=3 AND z_t_meetingroom.status=0 AND z_t_user.status!="+UserEnum.INVALID);
			strsql.append(" ) eum WHERE uf.uploadKey=eum.equipmentID and uf.createUserID=u.userID and uf.status="+FileEnum.STATUS_VALID);
			strsql.append(" and uploadType = "+FileEnum.EQUIPMENT_FILE);
		}else{
			strsql.append("select uf.*,m.meetingName,m.startTime,m.endTime,m.status mStatus,m.createUserID mCreateUserID,m.createTime mCreateTime,u.fullName,u.loginName,ui.status power,ui.userId");
			strsql.append(" from z_t_upload_file uf,z_t_meetingdetail m,z_t_user u,z_t_upload_file_impower ui");
			strsql.append(" where 1=1 and uf.uploadKey=m.meetingDetailID and uf.createUserID=u.userID and uf.uploadID=ui.uploadId");
			strsql.append(" and uf.status!="+FileEnum.STATUS_INVALID+" and m.status!="+MeetingDetailEnum.STATUS_INVALID+" and u.status!="+UserEnum.INVALID);
			//查看是否有权限EquipmentID实际上是登录用户UserID
			strsql.append(" and ui.status!="+FileEnum.STATUS_IMPOWER_INVALID);
			strsql.append(" and uploadType in("+FileEnum.MEETING_FILE+","+FileEnum.MEETING_RECORD_FILE+")");
		}

		if (QUERY_FROM_UPLOADFILE_IMPOWER == _operatorType) {
			if (null != uploadFileVO) {
				if (Integer.MIN_VALUE != uploadFileVO.getUploadFileImpowerVO().getStatus()) {
					strsql.append(" and ui.status= ? ");
					super.addIntForField(uploadFileVO.getUploadFileImpowerVO().getStatus());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getUploadFileImpowerVO().getUserId())) {
					strsql.append(" and ui.userId= ? ");
					super.addStringForField(uploadFileVO.getUploadFileImpowerVO().getUserId());
				}
				if (!StringUtils.isNullOrBlank(uploadFileVO.getUploadID())) {
					strsql.append(" and uf.uploadID= ? ");
					super.addStringForField(uploadFileVO.getUploadID());
				}
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
				if(!StringUtils.isNullOrBlank(uploadFileVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomName())){
					strsql.append(" and eum.meetingRoomName like '%" + uploadFileVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomName().trim() + "%'");
				}
				if(!StringUtils.isNullOrBlank(uploadFileVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomID())){
					strsql.append(" and eum.roomID= ? ");
					super.addStringForField(uploadFileVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomID());
				}
			}
			strsql.append(" order by uf.createTime desc");
		} else if (QUERY_FROM_UPLOADFILE_BY_IDS == _operatorType) {
			strsql.append(" and uf.uploadID in (?) ");
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
			uploadFileVO.getMeetingRoomVO().getDepartmentVO().setTitle(rs.getString("deptName"));
			uploadFileVO.getMeetingRoomVO().getAddressVO().setName(rs.getString("aName"));
		}
		if(uploadFileVO.getUploadType()==FileEnum.EQUIPMENT_FILE){
			uploadFileVO.getEquipmentVO().setEquipmentNO(rs.getString("equipmentNO"));
			uploadFileVO.getEquipmentVO().setEquipmentName(rs.getString("equipmentName"));
			uploadFileVO.getEquipmentVO().setEquipmentType(rs.getInt("equipmentType"));
			uploadFileVO.getEquipmentVO().setStatus(rs.getInt("eStatus"));
			uploadFileVO.getEquipmentVO().setIp(rs.getString("ip"));
			uploadFileVO.getEquipmentVO().setPort(rs.getInt("port"));
			uploadFileVO.getEquipmentVO().getMeetingRoomVO().setMeetingRoomID(rs.getString("roomID"));
			uploadFileVO.getEquipmentVO().getMeetingRoomVO().setMeetingRoomName(rs.getString("meetingRoomName"));
			uploadFileVO.getEquipmentVO().getUserVO().setUserID(rs.getString("adminID"));
			uploadFileVO.getEquipmentVO().getUserVO().setName(rs.getString("adminName"));
			uploadFileVO.getEquipmentVO().getUserVO().setEmail(rs.getString("email"));
			uploadFileVO.getEquipmentVO().getUserVO().setMobile(rs.getString("mobile"));
		}
		if(uploadFileVO.getUploadType()==FileEnum.MEETING_FILE||uploadFileVO.getUploadType()==FileEnum.MEETING_RECORD_FILE){
			uploadFileVO.getMeetingDetailVO().setMeetingName(rs.getString("meetingName"));
			uploadFileVO.getMeetingDetailVO().setMeetingStartTime(rs.getTimestamp("startTime"));
			uploadFileVO.getMeetingDetailVO().setMeetingEndTime(rs.getTimestamp("endTime"));
			uploadFileVO.getMeetingDetailVO().setStatus(rs.getString("mStatus"));
			uploadFileVO.getUploadFileImpowerVO().setStatus(rs.getInt("power"));
			uploadFileVO.getUploadFileImpowerVO().setUserId(rs.getString("userId"));
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
