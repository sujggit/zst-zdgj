package com.zzst.model.meeting.meetingDetail;

import java.io.Serializable;
import java.sql.Timestamp;

import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;
import com.zzst.model.meeting.levelConfig.LevelConfigVO;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;

/**
 * class description: MeetingDetail VO
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public class MeetingDetailVO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String meetingDetailID; //meetingDetailID
	private String meetingName;
	private Timestamp meetingStartTime;
	private Timestamp meetingEndTime;
	private String meetingID;//temlyMeetingID
	private int meetingType=Integer.MIN_VALUE;
	private int useReach=Integer.MIN_VALUE;//isRecord
	private Integer grade=Integer.MIN_VALUE;//level
	private String status;
	private String notifyType;	
	private String createUserID;
	private Timestamp createTime;
	private String meetingDescription;
	private Long revision=Long.MIN_VALUE;
	private String participatorIDs;//参会人员
	private String participators;
	private String meetingRoomNameIDs;//视频会议--会场 、普通会议会议室        
	private String meetingRoomNames;
	private String meetingRoomID;//视频会议主会场
	private String meetingRoomName;
	private String confProfileID;
	private String confDocAdminId;
	private String confDocAdminName;
	private Timestamp realityStartTime;//实际会议的开始时间
	
	//add by chenshuo 2013-2-4
	private String meetingRoomNamesTrim;//当会议室过多时临时存储前两个会议室供页面显示
	private String meetingUserNamesTrim;//当参会人员过多时临时存储前两个会议室供页面显示
	
	//add by ryan on 2012-04-23
	private String departmentNames;
	private String departmentIDs;
	
	//审批记录，modify by zhangliang@2012--5-11
	private String examby;
	private Timestamp examtime;
	
	//会议调试信息 add by zhangjz@2013-05-28
	private MeetingDebugVO meetingDebugVO= new MeetingDebugVO();
	
	private Float time;//会议时长
	
	//add template and backup fields wangle 2013-8-22
	private String templateID;
	private int templateType;
	private String info1;
	private String info2;
	private String info3;
	private String info4;
	private String info5;
	//add by wangyulong 2013-8-28
	private String fullName;//查询使用
	private String checkfullName;//detail使用（备用）
	//以下字段为历史遗留-------------------新开发时不建议使用
	
	
	
	private Integer useNotice=Integer.MIN_VALUE;

	private String createUserName;
	
	private String showParticipatorNames;
	
	private String neededEquipmentIDs;
	
	private String neededEquipmentNames;
	
	private String neededEquipModelNames;
	
	private String neededRooms4Equip;
	
	private String neededServiceIDs;
	
	private String neededServiceNames;
	
	private String neededVideoEquipsShow;
	
	//save Monday, Tuesday, Wednesday, Thursday, Friday, Saturday and Sunday
	private String weekDay;
	
	private long useTime;
	
	private int startTDNumber;
	
	private int endTDNumber;
	
	private String sendEmailFormat;
	
	private String sendSMSFormat;
	
	private String meetingAgenda;
	
/////分级分权
	private LevelConfigVO levelConfigVO = new LevelConfigVO();
	private String lvoids;
	private boolean openlevel;
	
	//审批过程vo
	private ApplyDetailVO applyDetailVO = new ApplyDetailVO();
	
	
	public Timestamp getRealityStartTime() {
		return realityStartTime;
	}

	public void setRealityStartTime(Timestamp realityStartTime) {
		this.realityStartTime = realityStartTime;
	}

	public String getDepartmentNames() {
		return departmentNames;
	}

	public void setDepartmentNames(String departmentNames) {
		this.departmentNames = departmentNames;
	}

	public String getDepartmentIDs() {
		return departmentIDs;
	}

	public void setDepartmentIDs(String departmentIDs) {
		this.departmentIDs = departmentIDs;
	}

	public long getUseTime() {
		return useTime;
	}

	public void setUseTime(long useTime) {
		this.useTime = useTime;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingStartTime(Timestamp meetingStartTime) {
		this.meetingStartTime = meetingStartTime;
	}

	public Timestamp getMeetingStartTime() {
		return meetingStartTime;
	}

	public void setMeetingEndTime(Timestamp meetingEndTime) {
		this.meetingEndTime = meetingEndTime;
	}

	public Timestamp getMeetingEndTime() {
		return meetingEndTime;
	}

	public void setUseNotice(Integer useNotice) {
		this.useNotice = useNotice;
	}

	public Integer getUseNotice() {
		return useNotice;
	}

	public void setUseReach(Integer useReach) {
		this.useReach = useReach;
	}

	public Integer getUseReach() {
		return useReach;
	}



	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getNotifyType() {
		return notifyType;
	}



	public int getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(int meetingType) {
		this.meetingType = meetingType;
	}

	 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMeetingDescription(String meetingDescription) {
		this.meetingDescription = meetingDescription;
	}

	public String getMeetingDescription() {
		return meetingDescription;
	}

	public void setRevision(Long revision) {
		this.revision = revision;
	}

	public Long getRevision() {
		return revision;
	}

	public String getMeetingRoomNameIDs() {
		return meetingRoomNameIDs;
	}

	public void setMeetingRoomNameIDs(String meetingRoomNameIDs) {
		this.meetingRoomNameIDs = meetingRoomNameIDs;
	}

	public String getMeetingRoomNames() {
		return meetingRoomNames;
	}

	public void setMeetingRoomNames(String meetingRoomNames) {
		this.meetingRoomNames = meetingRoomNames;
	}

	public String getNeededEquipmentIDs() {
		return neededEquipmentIDs;
	}

	public void setNeededEquipmentIDs(String neededEquipmentIDs) {
		this.neededEquipmentIDs = neededEquipmentIDs;
	}

	public String getNeededEquipmentNames() {
		return neededEquipmentNames;
	}

	public void setNeededEquipmentNames(String neededEquipmentNames) {
		this.neededEquipmentNames = neededEquipmentNames;
	}

	public String getNeededEquipModelNames() {
		return neededEquipModelNames;
	}

	public void setNeededEquipModelNames(String neededEquipModelNames) {
		this.neededEquipModelNames = neededEquipModelNames;
	}

	public String getNeededServiceIDs() {
		return neededServiceIDs;
	}

	public void setNeededServiceIDs(String neededServiceIDs) {
		this.neededServiceIDs = neededServiceIDs;
	}

	public String getNeededServiceNames() {
		return neededServiceNames;
	}

	public void setNeededServiceNames(String neededServiceNames) {
		this.neededServiceNames = neededServiceNames;
	}

	public String getParticipatorIDs() {
		return participatorIDs;
	}

	public void setParticipatorIDs(String participatorIDs) {
		this.participatorIDs = participatorIDs;
	}

	public String getParticipators() {
		return participators;
	}

	public void setParticipators(String participators) {
		this.participators = participators;
	}

	public String getShowParticipatorNames() {
		return showParticipatorNames;
	}

	public void setShowParticipatorNames(String showParticipatorNames) {
		this.showParticipatorNames = showParticipatorNames;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getNeededVideoEquipsShow() {
		return neededVideoEquipsShow;
	}

	public void setNeededVideoEquipsShow(String neededVideoEquipsShow) {
		this.neededVideoEquipsShow = neededVideoEquipsShow;
	}

	public String getNeededRooms4Equip() {
		return neededRooms4Equip;
	}

	public void setNeededRooms4Equip(String neededRooms4Equip) {
		this.neededRooms4Equip = neededRooms4Equip;
	}

	public int getEndTDNumber() {
		return endTDNumber;
	}

	public void setEndTDNumber(int endTDNumber) {
		this.endTDNumber = endTDNumber;
	}

	public int getStartTDNumber() {
		return startTDNumber;
	}

	public void setStartTDNumber(int startTDNumber) {
		this.startTDNumber = startTDNumber;
	}

	public String getSendEmailFormat() {
		return sendEmailFormat;
	}

	public void setSendEmailFormat(String sendEmailFormat) {
		this.sendEmailFormat = sendEmailFormat;
	}

	public String getSendSMSFormat() {
		return sendSMSFormat;
	}

	public void setSendSMSFormat(String sendSMSFormat) {
		this.sendSMSFormat = sendSMSFormat;
	}

	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public String getMeetingID() {
		return meetingID;
	}

	public void setMeetingID(String meetingID) {
		this.meetingID = meetingID;
	}

	public String getMeetingRoomID() {
		return meetingRoomID;
	}

	public void setMeetingRoomID(String meetingRoomID) {
		this.meetingRoomID = meetingRoomID;
	}

	public String getConfProfileID() {
		return confProfileID;
	}

	public void setConfProfileID(String confProfileID) {
		this.confProfileID = confProfileID;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserID() {
		return createUserID;
	}

	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	/**
	 * @return the examby
	 */
	public String getExamby() {
		return examby;
	}

	/**
	 * @param examby the examby to set
	 */
	public void setExamby(String examby) {
		this.examby = examby;
	}

	/**
	 * @return the examtime
	 */
	public Timestamp getExamtime() {
		return examtime;
	}

	/**
	 * @param examtime the examtime to set
	 */
	public void setExamtime(Timestamp examtime) {
		this.examtime = examtime;
	}

	public String getMeetingAgenda() {
		return meetingAgenda;
	}

	public void setMeetingAgenda(String meetingAgenda) {
		this.meetingAgenda = meetingAgenda;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public String getMeetingRoomNamesTrim() {
		return meetingRoomNamesTrim;
	}

	public void setMeetingRoomNamesTrim(String meetingRoomNamesTrim) {
		this.meetingRoomNamesTrim = meetingRoomNamesTrim;
	}

	public String getMeetingUserNamesTrim() {
		return meetingUserNamesTrim;
	}

	public void setMeetingUserNamesTrim(String meetingUserNamesTrim) {
		this.meetingUserNamesTrim = meetingUserNamesTrim;
	}

	public void setMeetingDebugVO(MeetingDebugVO meetingDebugVO) {
		this.meetingDebugVO = meetingDebugVO;
	}

	public MeetingDebugVO getMeetingDebugVO() {
		return meetingDebugVO;
	}

	public void setConfDocAdminId(String confDocAdminId) {
		this.confDocAdminId = confDocAdminId;
	}

	public String getConfDocAdminId() {
		return confDocAdminId;
	}

	public void setConfDocAdminName(String confDocAdminName) {
		this.confDocAdminName = confDocAdminName;
	}

	public String getConfDocAdminName() {
		return confDocAdminName;
	}

	public String getTemplateID() {
		return templateID;
	}

	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}

	public int getTemplateType() {
		return templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	public String getInfo1() {
		return info1;
	}

	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	public String getInfo2() {
		return info2;
	}

	public void setInfo2(String info2) {
		this.info2 = info2;
	}

	public String getInfo3() {
		return info3;
	}

	public void setInfo3(String info3) {
		this.info3 = info3;
	}

	public String getInfo4() {
		return info4;
	}

	public void setInfo4(String info4) {
		this.info4 = info4;
	}

	public String getInfo5() {
		return info5;
	}

	public void setInfo5(String info5) {
		this.info5 = info5;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCheckfullName() {
		return checkfullName;
	}

	public void setCheckfullName(String checkfullName) {
		this.checkfullName = checkfullName;
	}

	public ApplyDetailVO getApplyDetailVO() {
		return applyDetailVO;
	}

	public void setApplyDetailVO(ApplyDetailVO applyDetailVO) {
		this.applyDetailVO = applyDetailVO;
	}

	public LevelConfigVO getLevelConfigVO() {
		return levelConfigVO;
	}

	public void setLevelConfigVO(LevelConfigVO levelConfigVO) {
		this.levelConfigVO = levelConfigVO;
	}

	public String getLvoids() {
		return lvoids;
	}

	public void setLvoids(String lvoids) {
		this.lvoids = lvoids;
	}

	public boolean getOpenlevel() {
		return openlevel;
	}

	public void setOpenlevel(boolean openlevel) {
		this.openlevel = openlevel;
	}
    
	
}
