package com.zzst.dao.meeting.meetingRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.gsiec.cbf.system.CbfConfig;
import com.zzst.cbfImpl.util.IntegerUtils;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
/**
 * class description: MeetingRoom MQB
 * 
 * @author linsha
 * @date 2011-11-15
 */

public class MeetingRoomMQB extends MasterQueryObject {

	public static final int VALIDATE_FROM_MEETINGROOM = 6;

	static Logger logger = CbfLogger.getLogger(MeetingRoomMQB.class.getName());


	public static int QUERY_FROM_MEETINGROOM = 1;
	public static int QUERY_FROM_MEETINGROOM_BY_IDS = 2;
	public static int STATISTICS_FROM_MEETINGROOM = 3;
	public static int AVAILABLE_FROM_MEETINGROOM = 4;
	public static int QUERY_FROM_BY_IDS=5;
	public static int QUERY_FROM_MEETINGROOM_HAVE_TERMINAL = 7;
	public static int QUERY_FROM_MEETLIST_WEBSERVCIE=8;
	
	
	private MeetingRoomVO meetingRoomVO;
	private ArrayList<MeetingRoomVO> listMeetingRoom = new ArrayList<MeetingRoomVO>();

	public ArrayList<MeetingRoomVO> getListMeetingRoom() {
		return listMeetingRoom;
	}

	public void setListMeetingRoom(ArrayList<MeetingRoomVO> listMeetingRoom) {
		this.listMeetingRoom = listMeetingRoom;
	}

	private int _operatorType = -1;
	private String ids = "";
	private String deptid= "";
 

	public MeetingRoomMQB(int operatorType, MeetingRoomVO meetingRoomVO) {
		_operatorType = operatorType;
		this.meetingRoomVO = meetingRoomVO;
		makeSql();
	}
   
	public MeetingRoomMQB(int operatorType, String ids) {
		_operatorType = operatorType;
		this.ids = ids;
		makeSql();
	}
	public MeetingRoomMQB(int operatorType) {
		_operatorType = operatorType;
	}

	private void makeSql() {
		StringBuffer strsql = new StringBuffer();
		
		if (QUERY_FROM_MEETINGROOM == _operatorType) {
			strsql.append("select  z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName,z_t_meetingroom.roomNO,z_t_meetingroom.meetingroomType,z_t_meetingroom.capacity ,z_t_meetingroom.planeImg,z_t_meetingroom.pictureImg,z_t_meetingroom.meetingroomUrl,z_t_meetingroom.status,z_t_meetingroom.description,z_t_meetingroom.revision,z_t_user.userID,z_t_user.fullName, z_t_user.loginName,z_t_department.id,z_t_department.name dname,z_t_address.addressID ,z_t_address.name aname,z_t_address.parentID   ");
			strsql.append("from( ( z_t_meetingroom inner join z_t_user on z_t_meetingroom.adminID=z_t_user.userID)");
			strsql.append("inner join z_t_department on z_t_meetingroom.departmentID=z_t_department.id) ");
			strsql.append("inner join z_t_address on z_t_meetingroom.addressID=z_t_address.addressID ");
			strsql.append(" where 1=1  ");
			if (null != meetingRoomVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingRoomID())) {
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(meetingRoomVO.getMeetingRoomID());
				}
			
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingRoomName())) {
					strsql.append(" and meetingRoomName like '%"+meetingRoomVO.getMeetingRoomName()+"%'");
				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getRoomNO())) {
					strsql.append(" and roomNO= ? ");
					super.addStringForField(meetingRoomVO.getRoomNO());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getMeetingRoomType())&& meetingRoomVO.getMeetingRoomType()!=0&&meetingRoomVO.getMeetingRoomType()!=-1) {
				    strsql.append(" and meetingroomType= ?");
					super.addIntForField(meetingRoomVO.getMeetingRoomType());
				}
				
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getPlaneImg())) {
					strsql.append(" and planeImg= ? ");
					super.addStringForField(meetingRoomVO.getPlaneImg());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getPictureImg())) {
					strsql.append(" and pictureImg= ? ");
					super.addStringForField(meetingRoomVO.getPictureImg());
				}
//				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingroomUrl())) {
//					strsql.append(" and meetingroomUrl= ? ");
//					super.addStringForField(meetingRoomVO.getMeetingroomUrl());
//				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getStatus())) {
					strsql.append(" and z_t_meetingroom.status = ? ");
					super.addIntForField(meetingRoomVO.getStatus());
				}else{
					strsql.append(" and  z_t_meetingroom.status !="+MeetingRoomEnum.ROOM_STATUS_INVALID);
				}
//				if (!StringUtils.isNullOrBlank(meetingRoomVO.getAdminID())) {
//					strsql.append(" and adminID= ? ");
//					super.addStringForField(meetingRoomVO.getAdminID());
//				}
//				if (!StringUtils.isNullOrBlank(meetingRoomVO.getDepartmentID())) {
//					strsql.append(" and departmentID= ? ");
//					super.addStringForField(meetingRoomVO.getDepartmentID());
//				}
//			
				
				if (meetingRoomVO.getUserVO().getUserID()!=null && meetingRoomVO.getUserVO()!=null && !meetingRoomVO.getUserVO().getUserID().equals("")) {
					strsql.append(" and adminID= ?");
    				super.addStringForField(meetingRoomVO.getUserVO().getUserID());
				}
				if (meetingRoomVO.getDepartmentVO()!=null && meetingRoomVO.getDepartmentVO().getId()!=null && !meetingRoomVO.getDepartmentVO().getId().equals("")) {
					strsql.append(" and z_t_department.id= ? ");
					super.addStringForField(meetingRoomVO.getDepartmentVO().getId());
				}
				if (meetingRoomVO.getAddressVO()!=null&&meetingRoomVO.getAddressVO().getAddressID()!=null) {
					strsql.append(" and z_t_address.addressID= ? ");
					super.addStringForField(meetingRoomVO.getAddressVO().getAddressID());
				}
				
//				if(!StringUtils.isNullOrBlank(meetingRoomVO.getAddressID())){
//					strsql.append(" and z_t_address.addressID= ? ");
//					super.addStringForField(meetingRoomVO.getAddressID());
//					
//				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingRoomVO.getDescription());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getRevision())) {
					strsql.append(" and revision= ? ");
					super.addIntForField(meetingRoomVO.getRevision());
				}
				
				if(meetingRoomVO.isLevel()){
					strsql.append(meetingRoomVO.getLsql());
				}
 				strsql.append(" order by meetingRoomID ");
			}
		} else if (QUERY_FROM_MEETINGROOM_BY_IDS == _operatorType) {

			strsql.append("select  z_t_meetingroom.roomPCA,z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName,z_t_meetingroom.roomNO,z_t_meetingroom.meetingroomType,z_t_meetingroom.capacity ,z_t_meetingroom.planeImg,z_t_meetingroom.pictureImg,z_t_meetingroom.meetingroomUrl,z_t_meetingroom.status,z_t_meetingroom.description,z_t_meetingroom.revision,z_t_user.userID,z_t_user.fullName,z_t_user.email,z_t_user.mobile, z_t_department.id,z_t_department.name dname,z_t_address.addressID ,z_t_address.name aname ");

			strsql.append("from( ( z_t_meetingroom inner join z_t_user on z_t_meetingroom.adminID=z_t_user.userID)");
			strsql.append("inner join z_t_department on z_t_meetingroom.departmentID=z_t_department.id) ");
			strsql.append("inner join z_t_address on z_t_meetingroom.addressID=z_t_address.addressID ");
			strsql.append(" where 1=1  and  z_t_meetingroom.status!="+MeetingRoomEnum.ROOM_STATUS_INVALID);
			strsql.append(" and meetingRoomID in (?) ");//不支持多个查询，预约总览页面用到
			super.addStringForField(ids);
		}  else if (QUERY_FROM_BY_IDS == _operatorType) {
			strsql.append("select  z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName,z_t_meetingroom.roomNO,z_t_meetingroom.meetingroomType,z_t_meetingroom.capacity ,z_t_meetingroom.planeImg,z_t_meetingroom.pictureImg,z_t_meetingroom.meetingroomUrl,z_t_meetingroom.status,z_t_meetingroom.description,z_t_meetingroom.revision,z_t_user.userID,z_t_user.fullName, z_t_user.loginName, z_t_department.id,z_t_department.name dname,z_t_address.addressID ,z_t_address.name aname ");
			strsql.append("from( ( z_t_meetingroom inner join z_t_user on z_t_meetingroom.adminID=z_t_user.userID)");
			strsql.append("inner join z_t_department on z_t_meetingroom.departmentID=z_t_department.id) ");
			strsql.append("inner join z_t_address on z_t_meetingroom.addressID=z_t_address.addressID ");
			strsql.append(" where 1=1 ");
			strsql.append(" and meetingRoomID in (?) ");
			super.addStringForField(ids);
		}else if (STATISTICS_FROM_MEETINGROOM == _operatorType){
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
			strsql.append(" select mr.meetingroomID, mr.meetingroomName,mr.roomNO,mr.meetingroomType,mr.capacity ,mr.planeImg,mr.pictureImg,");
			strsql.append(" mr.meetingroomUrl,mr.status, count(mr.meetingroomID)  useCount,");
			strsql.append(" sum( to_number(mdl.endTime - mdl.startTime)*24)  useTime  from z_t_meetingdetail_room mdr ");
			strsql.append(" inner join z_t_meetingdetail  mdl on   mdl.meetingDetailID = mdr.meetingDetailID ");
			strsql.append(" and mdl.status in("+MeetingDetailEnum.STATUS_END+")");
			}else{
				strsql.append(" select mr.meetingroomID, mr.meetingroomName,mr.roomNO,mr.meetingroomType,mr.capacity ,mr.planeImg,mr.pictureImg,");
				strsql.append(" mr.meetingroomUrl,mr.status, if(mdl.meetingDetailID is null , 0 ,count(mr.meetingroomID))  useCount,");
				strsql.append(" sum(unix_timestamp(mdl.endTime) - unix_timestamp(mdl.startTime))/3600  useTime  from z_t_meetingdetail_room mdr ");
				strsql.append(" inner join z_t_meetingdetail  mdl on   mdl.meetingDetailID = mdr.meetingDetailID ");
				strsql.append(" and mdl.status in("+MeetingDetailEnum.STATUS_END+")");
			}
			if (meetingRoomVO != null){
				if(meetingRoomVO.getStartTime() !=null )
				{
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append(" and mdl.startTime >="+UtilDAO.oracleToDate(meetingRoomVO.getStartTime()));
					}else{
						strsql.append(" and mdl.startTime >= '"+meetingRoomVO.getStartTime() +"'");
					}
				}
				if(meetingRoomVO.getEndTime() != null )
				{
					if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){//update 时需要设置to_date
						strsql.append("  and mdl.endTime <="+UtilDAO.oracleToDate(meetingRoomVO.getEndTime()));
					}else{
						strsql.append(" and mdl.endTime <= '"+meetingRoomVO.getEndTime() +"'");
					}
				}
			}
			strsql.append(" right join z_t_meetingroom mr on mr.meetingroomID = mdr.meetingroomID where 1=1 ");
			if (meetingRoomVO != null){
				if(!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingRoomID())) {
					strsql.append(" and mr.meetingroomID in('"+meetingRoomVO.getMeetingRoomID().replaceAll(",", "','")+"') ");
				}
			}
			
			strsql.append(" and mr.status !="+MeetingRoomEnum.ROOM_STATUS_INVALID);
			
			if(CbfConfig.DB_TYPE == CbfConfig.DB_TYPE_ORACLE){
			strsql.append(" group by mr.meetingroomID, mr.meetingroomName,mr.roomNO,mr.meetingroomType,mr.capacity ,mr.planeImg,mr.pictureImg, mr.meetingroomUrl,mr.status");
			}else{
				strsql.append(" group by mr.meetingroomID");
			}
		}else if(VALIDATE_FROM_MEETINGROOM == _operatorType){
			strsql.append("select  z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName,z_t_meetingroom.roomNO,z_t_meetingroom.meetingroomType,z_t_meetingroom.capacity ,z_t_meetingroom.planeImg,z_t_meetingroom.pictureImg,z_t_meetingroom.meetingroomUrl,z_t_meetingroom.status,z_t_meetingroom.description,z_t_meetingroom.revision,z_t_user.userID,z_t_user.fullName,z_t_user.loginName, z_t_department.id,z_t_department.name dname,z_t_address.addressID ,z_t_address.name aname,z_t_address.parentID   ");
			strsql.append("from( ( z_t_meetingroom inner join z_t_user on z_t_meetingroom.adminID=z_t_user.userID)");
			strsql.append("inner join z_t_department on z_t_meetingroom.departmentID=z_t_department.id) ");
			strsql.append("inner join z_t_address on z_t_meetingroom.addressID=z_t_address.addressID ");
			strsql.append(" where 1=1  ");
			if (null != meetingRoomVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingRoomID())) {
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(meetingRoomVO.getMeetingRoomID());
				}
			
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingRoomName())) {
					strsql.append(" and meetingRoomName = ? ");
					super.addStringForField(meetingRoomVO.getMeetingRoomName().trim());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getRoomNO())) {
					strsql.append(" and roomNO= ? ");
					super.addStringForField(meetingRoomVO.getRoomNO());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getMeetingRoomType())&& meetingRoomVO.getMeetingRoomType()!=0&&meetingRoomVO.getMeetingRoomType()!=-1) {
				    strsql.append(" and meetingroomType= ?");
					super.addIntForField(meetingRoomVO.getMeetingRoomType());
				}
				
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getPlaneImg())) {
					strsql.append(" and planeImg= ? ");
					super.addStringForField(meetingRoomVO.getPlaneImg());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getPictureImg())) {
					strsql.append(" and pictureImg= ? ");
					super.addStringForField(meetingRoomVO.getPictureImg());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getStatus())) {
					strsql.append(" and z_t_meetingroom.status = ? ");
					super.addIntForField(meetingRoomVO.getStatus());
				}else{
					strsql.append(" and  z_t_meetingroom.status !="+MeetingRoomEnum.ROOM_STATUS_INVALID);
				}
				
				if (meetingRoomVO.getUserVO().getUserID()!=null && meetingRoomVO.getUserVO()!=null && !meetingRoomVO.getUserVO().getUserID().equals("")) {
					strsql.append(" and adminID= ?");
    				super.addStringForField(meetingRoomVO.getUserVO().getUserID());
				}
				if (meetingRoomVO.getDepartmentVO()!=null && meetingRoomVO.getDepartmentVO().getId()!=null && meetingRoomVO.getDepartmentVO().getId().equals("")) {
					strsql.append(" and z_t_department.id= ? ");
					super.addStringForField(meetingRoomVO.getDepartmentVO().getId());
				}
				if (meetingRoomVO.getAddressVO()!=null&&meetingRoomVO.getAddressVO().getAddressID()!=null) {
					strsql.append(" and z_t_address.addressID= ? ");
					super.addStringForField(meetingRoomVO.getAddressVO().getAddressID());
				}
				
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingRoomVO.getDescription());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getRevision())) {
					strsql.append(" and revision= ? ");
					super.addIntForField(meetingRoomVO.getRevision());
				}
 				strsql.append(" order by meetingRoomID ");
			}
		}else if( QUERY_FROM_MEETINGROOM_HAVE_TERMINAL == _operatorType){
			strsql.append("select  z_t_meetingroom.meetingroomID,z_t_meetingroom.meetingroomName,z_t_meetingroom.roomNO,z_t_meetingroom.meetingroomType,z_t_meetingroom.capacity ,z_t_meetingroom.planeImg,z_t_meetingroom.pictureImg,z_t_meetingroom.meetingroomUrl,z_t_meetingroom.status,z_t_meetingroom.description,z_t_meetingroom.revision,z_t_user.userID,z_t_user.fullName, z_t_user.loginName,z_t_department.id,z_t_department.name dname,z_t_address.addressID ,z_t_address.name aname,z_t_address.parentID   ");
			strsql.append("from( ( z_t_meetingroom inner join z_t_user on z_t_meetingroom.adminID=z_t_user.userID)");
			strsql.append("inner join z_t_department on z_t_meetingroom.departmentID=z_t_department.id) ");
			strsql.append("inner join z_t_address on z_t_meetingroom.addressID=z_t_address.addressID ");
			strsql.append("inner join z_t_equipment on z_t_meetingroom.meetingroomID=z_t_equipment.roomID ");
			strsql.append(" where 1=1  and z_t_equipment.equipmentType = 0 ");
			if (null != meetingRoomVO) {
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingRoomID())) {
					strsql.append(" and meetingRoomID= ? ");
					super.addStringForField(meetingRoomVO.getMeetingRoomID());
				}
			
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingRoomName())) {
					strsql.append(" and meetingRoomName like '%"+meetingRoomVO.getMeetingRoomName()+"%'");
				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getRoomNO())) {
					strsql.append(" and roomNO= ? ");
					super.addStringForField(meetingRoomVO.getRoomNO());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getMeetingRoomType())&& meetingRoomVO.getMeetingRoomType()!=0&&meetingRoomVO.getMeetingRoomType()!=-1) {
				    strsql.append(" and meetingroomType= ?");
					super.addIntForField(meetingRoomVO.getMeetingRoomType());
				}
				
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getPlaneImg())) {
					strsql.append(" and planeImg= ? ");
					super.addStringForField(meetingRoomVO.getPlaneImg());
				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getPictureImg())) {
					strsql.append(" and pictureImg= ? ");
					super.addStringForField(meetingRoomVO.getPictureImg());
				}
//				if (!StringUtils.isNullOrBlank(meetingRoomVO.getMeetingroomUrl())) {
//					strsql.append(" and meetingroomUrl= ? ");
//					super.addStringForField(meetingRoomVO.getMeetingroomUrl());
//				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getStatus())) {
					strsql.append(" and z_t_meetingroom.status = ? ");
					super.addIntForField(meetingRoomVO.getStatus());
				}else{
					strsql.append(" and  z_t_meetingroom.status !="+MeetingRoomEnum.ROOM_STATUS_INVALID);
				}
//				if (!StringUtils.isNullOrBlank(meetingRoomVO.getAdminID())) {
//					strsql.append(" and adminID= ? ");
//					super.addStringForField(meetingRoomVO.getAdminID());
//				}
//				if (!StringUtils.isNullOrBlank(meetingRoomVO.getDepartmentID())) {
//					strsql.append(" and departmentID= ? ");
//					super.addStringForField(meetingRoomVO.getDepartmentID());
//				}
//			
				
				if (meetingRoomVO.getUserVO().getUserID()!=null && meetingRoomVO.getUserVO()!=null && !meetingRoomVO.getUserVO().getUserID().equals("")) {
					strsql.append(" and adminID= ?");
    				super.addStringForField(meetingRoomVO.getUserVO().getUserID());
				}
				if (meetingRoomVO.getDepartmentVO()!=null && meetingRoomVO.getDepartmentVO().getId()!=null && meetingRoomVO.getDepartmentVO().getId().equals("")) {
					strsql.append(" and z_t_department.id= ? ");
					super.addStringForField(meetingRoomVO.getDepartmentVO().getId());
				}
				if (meetingRoomVO.getAddressVO()!=null&&meetingRoomVO.getAddressVO().getAddressID()!=null) {
					strsql.append(" and z_t_address.addressID= ? ");
					super.addStringForField(meetingRoomVO.getAddressVO().getAddressID());
				}
				
//				if(!StringUtils.isNullOrBlank(meetingRoomVO.getAddressID())){
//					strsql.append(" and z_t_address.addressID= ? ");
//					super.addStringForField(meetingRoomVO.getAddressID());
//					
//				}
				if (!StringUtils.isNullOrBlank(meetingRoomVO.getDescription())) {
					strsql.append(" and description= ? ");
					super.addStringForField(meetingRoomVO.getDescription());
				}
				if (!IntegerUtils.isNullOrMIN_VALUE(meetingRoomVO.getRevision())) {
					strsql.append(" and revision= ? ");
					super.addIntForField(meetingRoomVO.getRevision());
				}
				
 				strsql.append(" order by meetingRoomID ");
			}
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
		if(STATISTICS_FROM_MEETINGROOM == _operatorType){
			meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setMeetingRoomID(rs.getString("meetingRoomID"));
			meetingRoomVO.setMeetingRoomName(rs.getString("meetingRoomName"));
			meetingRoomVO.setRoomNO(rs.getString("roomNO"));
			meetingRoomVO.setMeetingRoomType(rs.getInt("meetingRoomType"));
			meetingRoomVO.setCapacity(rs.getInt("capacity"));
			meetingRoomVO.setPlaneImg(rs.getString("planeImg"));
			meetingRoomVO.setPictureImg(rs.getString("pictureImg"));
			meetingRoomVO.setMeetingroomUrl(rs.getString("meetingroomUrl"));
			meetingRoomVO.setStatus(rs.getInt("status"));
			meetingRoomVO.setUseCount(rs.getString("useCount"));
			meetingRoomVO.setUseTime(rs.getString("useTime"));
		}else{
			if(AVAILABLE_FROM_MEETINGROOM == _operatorType){
				meetingRoomVO = new MeetingRoomVO();
				meetingRoomVO.setMeetingRoomID(rs.getString("meetingRoomID"));
				meetingRoomVO.setMeetingRoomName(rs.getString("meetingRoomName"));
				meetingRoomVO.setRoomNO(rs.getString("roomNO"));
				meetingRoomVO.setMeetingRoomType(rs.getInt("meetingRoomType"));
				meetingRoomVO.setStatus(rs.getInt("status"));
			}else if(QUERY_FROM_MEETLIST_WEBSERVCIE == _operatorType){
				meetingRoomVO = new MeetingRoomVO();
				meetingRoomVO.setMeetingRoomID(rs.getString("meetingRoomID"));
				meetingRoomVO.setMeetingRoomName(rs.getString("meetingRoomName"));
				meetingRoomVO.setCapacity(rs.getInt("capacity"));
				UserVO userVO=new UserVO();
				userVO.setUserID(rs.getString("adminID"));
				meetingRoomVO.setUserVO(userVO);
				DepartmentVO departmentVO=new DepartmentVO();
				departmentVO.setId(rs.getString("departmentID"));
				departmentVO.setDepNo(rs.getString("dname"));
				meetingRoomVO.setDepartmentVO(departmentVO);
				AddressVO addressVO=new AddressVO();
				addressVO.setAddressID(rs.getString("addressID"));
				addressVO.setName(rs.getString("aname"));
				meetingRoomVO.setAddressVO(addressVO);
				meetingRoomVO.setMeetingRoomType(rs.getInt("meetingroomType"));
			}else if(QUERY_FROM_MEETINGROOM_BY_IDS == _operatorType){
				meetingRoomVO = new MeetingRoomVO();
				meetingRoomVO.setMeetingRoomID(rs.getString("meetingRoomID"));
				meetingRoomVO.setMeetingRoomName(rs.getString("meetingRoomName"));
				meetingRoomVO.setRoomNO(rs.getString("roomNO"));
				meetingRoomVO.setMeetingRoomType(rs.getInt("meetingRoomType"));
				meetingRoomVO.setCapacity(rs.getInt("capacity"));
				meetingRoomVO.setPlaneImg(rs.getString("planeImg"));
				meetingRoomVO.setPictureImg(rs.getString("pictureImg"));
				meetingRoomVO.setMeetingroomUrl(rs.getString("meetingroomUrl"));
				meetingRoomVO.setStatus(rs.getInt("status"));
				meetingRoomVO.setRoomPCA(rs.getString("roomPCA"));
		//		meetingRoomVO.setAdminID(rs.getString("adminID"));
		//		meetingRoomVO.setDepartmentID(rs.getString("departmentID"));
				meetingRoomVO.getDepartmentVO().setId(rs.getString("id"));
				meetingRoomVO.getDepartmentVO().setTitle(rs.getString("dname"));
			    meetingRoomVO.getUserVO().setUserID((rs.getString("userID")));
			    meetingRoomVO.getUserVO().setName(rs.getString("fullName"));
			    meetingRoomVO.getUserVO().setEmail(rs.getString("email"));
			    meetingRoomVO.getUserVO().setMobile(rs.getString("mobile"));
			   // meetingRoomVO.getUserVO().setLoginName(rs.getString("z_t_user.loginName"));
				meetingRoomVO.getAddressVO().setAddressID(rs.getString("addressID"));
				meetingRoomVO.getAddressVO().setName(rs.getString("aname"));
				//meetingRoomVO.getAddressVO().setParentID(rs.getString("z_t_address.parentID"));
				
				meetingRoomVO.setDescription(rs.getString("description"));
				meetingRoomVO.setRevision(rs.getInt("revision"));
			}else{
				meetingRoomVO = new MeetingRoomVO();
				meetingRoomVO.setMeetingRoomID(rs.getString("meetingRoomID"));
				meetingRoomVO.setMeetingRoomName(rs.getString("meetingRoomName"));
				meetingRoomVO.setRoomNO(rs.getString("roomNO"));
				meetingRoomVO.setMeetingRoomType(rs.getInt("meetingRoomType"));
				meetingRoomVO.setCapacity(rs.getInt("capacity"));
				meetingRoomVO.setPlaneImg(rs.getString("planeImg"));
				meetingRoomVO.setPictureImg(rs.getString("pictureImg"));
				meetingRoomVO.setMeetingroomUrl(rs.getString("meetingroomUrl"));
				meetingRoomVO.setStatus(rs.getInt("status"));
		//		meetingRoomVO.setAdminID(rs.getString("adminID"));
		//		meetingRoomVO.setDepartmentID(rs.getString("departmentID"));
				meetingRoomVO.getDepartmentVO().setId(rs.getString("id"));
				meetingRoomVO.getDepartmentVO().setTitle(rs.getString("dname"));
			    meetingRoomVO.getUserVO().setUserID((rs.getString("userID")));
			    meetingRoomVO.getUserVO().setName(rs.getString("fullName"));
			    meetingRoomVO.getUserVO().setLoginName(rs.getString("loginName"));
				meetingRoomVO.getAddressVO().setAddressID(rs.getString("addressID"));
				meetingRoomVO.getAddressVO().setName(rs.getString("aname"));
				//meetingRoomVO.getAddressVO().setParentID(rs.getString("z_t_address.parentID"));
				
				meetingRoomVO.setDescription(rs.getString("description"));
				meetingRoomVO.setRevision(rs.getInt("revision"));
			}
		}
		listMeetingRoom.add(meetingRoomVO);
	}



}
