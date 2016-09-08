package com.zzst.action.meeting.util.webService.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.MeetingThread;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.notice.SendMessageInstance;
import com.zzst.action.meeting.util.webService.ConferenceServices;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.meetingDebug.MeetingDebugVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.model.mobileInfo.MobileInfoVO;
import com.zzst.service.meeting.user.UserServiceImpl;
import com.zzst.service.mobileInfo.MobileInfoService;
import com.zzst.service.mobileInfo.MobileInfoServiceImpl;
import com.zzst.zdgj.messageUtil.NoteSendThread;

public class ConferenceServicesImpl implements ConferenceServices {
	private static Logger logger = CjfLogger.getLogger(ConferenceServicesImpl.class.getName());
	ArrayList<String> ml = new ArrayList<String>();//取消用，在预定中设置值
	@Override
	public String conferenceBook(String xml) {
		logger.info("conferenceBook begin");
		logger.info(xml);
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		//禁用流程，直接将状态设置成审批通过
		meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 会议ID 唯一标识符 不在使用，用其他多个字段来确定会议。
		///String meetingDetailID = XmlReader.getTagValue(xml, "meetingDetailID").split(",")[1];
		///meetingDetailVO.setMeetingDetailID(meetingDetailID);
		//申请人问题：使用备用字段  info1  申请人部门:申请人
		String applicant = XmlReader.getTagValue(xml, "applicant").split(",")[1];
		//String applicantDepartment = XmlReader.getTagValue(xml, "applicantDepartment").split(",")[1];
		meetingDetailVO.setInfo1(applicant);//先不管部门
		//参会人员：info3 主持人，前排就坐，参会人员，参会人数
		String host=null;
		String rostrum=null;
		String frontSeat=null;
		String number=null;
		try {
			host = XmlReader.getTagValue(xml, "host").split(",")[1];
		} catch (Exception e1) {
			host="未填写";
		}
		try {
			rostrum = XmlReader.getTagValue(xml, "rostrum").split(",")[1];
		} catch (Exception e1) {
			rostrum = "未填写";
		}
		try {
			frontSeat = XmlReader.getTagValue(xml, "frontSeat").split(",")[1];
		} catch (Exception e1) {
			frontSeat="未填写";
		}
		try {
			number = XmlReader.getTagValue(xml, "number").split(",")[1];
		} catch (Exception e1) {
			number="未填写";
		}
					//根据人名来匹配手机号，然后给相关人员发送短信  mobileList 需要发送短信的电话号码
					ArrayList<String> mobileList = new ArrayList<String>();
					Map<String, String> infoMap = new HashMap<String, String>();//人员电话名单
					try {
						MobileInfoService mis = new MobileInfoServiceImpl();
						ArrayList<MobileInfoVO> mobileInfoList = mis.query(new MobileInfoVO(), null);
						for(MobileInfoVO mi : mobileInfoList){
							infoMap.put(mi.getName(), mi.getMobile());
						}
						String[] hosts = host.split(",");
						String[] rostrums = rostrum.split(",");
						String[] frontSeats = frontSeat.split(",");
						for(String s:hosts){
							if(infoMap.containsKey(s)){
								mobileList.add(infoMap.get(s));
							}
						}
						for(String s:rostrums){
							if(infoMap.containsKey(s)){
								mobileList.add(infoMap.get(s));
							}
						}
						for(String s:frontSeats){
							if(infoMap.containsKey(s)){
								mobileList.add(infoMap.get(s));
							}
						}
						ml=mobileList;//取消用
						/**/
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("查询用户信息失败");
					}
		String info3 = host+"；"+rostrum+"；"+frontSeat;
		meetingDetailVO.setInfo3(info3);
		//人数info4
		String info4 = number;
		meetingDetailVO.setInfo4(info4);
		//会议描述
		String description=null;
		try {
			description = XmlReader.getTagValue(xml, "description").split(",")[1];
		} catch (Exception e1) {
			description="未填写";
		}	
		meetingDetailVO.setMeetingDescription(description);
		//会议开始结束时间
		String meetingStartTime = XmlReader.getTagValue(xml,"meetingStartTime").split(",")[1];;// 开始时间
		String meetingEndTime = XmlReader.getTagValue(xml,"meetingEndTime").split(",")[1];// 结束时间
		try {
			meetingDetailVO.setMeetingStartTime(new Timestamp(format.parse(meetingStartTime).getTime()));
			meetingDetailVO.setMeetingEndTime(new Timestamp(format.parse(meetingEndTime).getTime()));
		} catch (ParseException e) {
			return XmlReader.getXmlTop("false", "时间格式不正确");
		}
		//会议名称
		String meetingName = null;
		try {
			meetingName = XmlReader.getTagValue(xml, "meetingName").split(",")[1];
		} catch (Exception e1) {
			meetingName="未填写";
		}
		meetingDetailVO.setMeetingName(meetingName);
		//会议形式     本地会议 1      视频会议2
		String meetingForm = XmlReader.getTagValue(xml, "meetingForm").split(",")[1];
		//----------------------公共信息结束-开始判断会议形式-------------------------
		if("1".equals(meetingForm)||"本地会议".equals(meetingForm)){
			meetingDetailVO.setMeetingType(1);
			// 本地会议没有主会场分会场概念。会议室名称：根据推送过来的会议室名字匹配会议室，如果没有，返回错误信息
			String meetingRoomName = XmlReader.getTagValue(xml, "meetingRoomName").split(",")[1];
			try {
				ArrayList<MeetingRoomVO> roomList = ServiceFactory.getMeetingRoomService().query(new MeetingRoomVO(), null);
				for(MeetingRoomVO room:roomList){
					if(meetingRoomName.equals(room.getMeetingRoomName())){
						meetingDetailVO.setMeetingRoomNameIDs(room.getMeetingRoomID());
						meetingDetailVO.setMeetingRoomNames(room.getMeetingRoomName());
						break;
					}
				}
				if(!(meetingDetailVO.getMeetingRoomNameIDs()!=null)){
					return XmlReader.getXmlTop("false", "预约的会议室不存在，请联系会议维护人员");
				}
			} catch (Exception e) {
				return XmlReader.getXmlTop("false", "会议室异常，请联系会议维护人员");
			}
			//参会人员和单位问题。
			ArrayList<UserVO> listUser = new ArrayList<UserVO>();//存储参会人员，只有ID被赋值了
			ArrayList<VideoconferenceVO> listRoom = new ArrayList<VideoconferenceVO>();//存储会议室信息
			if(null!=meetingDetailVO.getMeetingRoomNameIDs()&&!meetingDetailVO.getMeetingRoomNameIDs().trim().equals("")){
				String[] roomIDs = {};
				roomIDs = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				int userLength = roomIDs.length;
				
				for(int i=0;i<userLength;i++){
					VideoconferenceVO venueVO = new VideoconferenceVO();
					venueVO.setSubmeetingRoomID(roomIDs[i]);
					listRoom.add(venueVO);
				}
			}
			//创建时间
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			//创建会议
			try {
				MeetingDetailDAO.addMeetingDetail(meetingDetailVO, null);
			} catch (Exception e) {
				return XmlReader.getXmlTop("false", "本地会议添加失败。");
			}
			//起线程，设置与会人员、与会单位等
			MeetingThread gAddThread = new MeetingThread(meetingDetailVO,listUser,listRoom,null,MeetingThread.GENERAL_ADD);
			Thread thread = new Thread(gAddThread);
			thread.start();
			//短信
			//发送短信
			if(MeetingAppConfig.sms_status && mobileList.size()==0){
				logger.info("没有需要发送短信的联系人。");
			}else {//TODO 发送短信
				NoteSendThread nst = new NoteSendThread(mobileList, meetingDetailVO,"1");
				nst.start();
			}
			//增加定时器，以便会议状态的定时修改
			MeetingTaskOperate.meetingStartTask(meetingDetailVO);
			MeetingTaskOperate.meetingEndTask(meetingDetailVO);
			return XmlReader.getXmlTop("true", "本地会议预约成功");
		}else if("2".equals(meetingForm)||"视频会议".equals(meetingForm)){
			meetingDetailVO.setMeetingType(2);
			//TODO 视频会议相关的操作
			//主会场,分场未推送，等预约完会议之后再添加分会场
			String meetingRoomName = XmlReader.getTagValue(xml, "meetingRoomName").split(",")[1];
			try {
				ArrayList<MeetingRoomVO> roomList = ServiceFactory.getMeetingRoomService().query(new MeetingRoomVO(), null);
				for(MeetingRoomVO room:roomList){
					if(meetingRoomName.equals(room.getMeetingRoomName())){
						meetingDetailVO.setMeetingRoomID(room.getMeetingRoomID());
						meetingDetailVO.setMeetingRoomName(room.getMeetingRoomName());
						break;
					}
				}
				if(!(meetingDetailVO.getMeetingRoomID()!=null)){
					return XmlReader.getXmlTop("false", "预约的会议室不存在，请联系会议维护人员");
				}
			} catch (Exception e) {
				return XmlReader.getXmlTop("false", "会议室异常，请联系会议维护人员");
			}
			String[] userIDs = {};//参会人员id
			String[] roomIDs = {};//分会场id
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			try {
				MeetingDetailDAO.addMeetingDetail(meetingDetailVO, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MeetingThread addMeeting = new MeetingThread(meetingDetailVO,userIDs,roomIDs,MeetingThread.ADD);
			Thread thread = new Thread(addMeeting);
			thread.start();
			MeetingDebugVO meetingDebugVO = new MeetingDebugVO();
			meetingDebugVO.setMeetingDetailId(meetingDetailVO.getMeetingDetailID());
			meetingDebugVO.setNoticeStatus(0);
			try {
				ServiceFactory.getMeetingDebugService().add(meetingDebugVO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//发送短信
			if(MeetingAppConfig.sms_status && mobileList.size()==0){
				logger.info("没有需要发送短信的联系人。");
			}else {//TODO 发送短信
				NoteSendThread nst = new NoteSendThread(mobileList, meetingDetailVO,"1");
				nst.start();
			}
			//add 20120416 增加定时器，以便会议状态的定时修改
			MeetingTaskOperate.meetingStartTask(meetingDetailVO);
			//MeetingTaskOperate.meetingEndTask(meetingDetailVO);
			return XmlReader.getXmlTop("true", "视频会议预约成功。");
		}else 
			return XmlReader.getXmlTop("false", "会议形式错误");
	}
	
	@Override
	public String cancelBookMeet(String strXml) {
		//取消会议，根据会议开始结束时间查询会议。
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		String meetingName = XmlReader.getTagValue(strXml, "meetingName").split(",")[1];
		meetingDetailVO.setMeetingName(meetingName);
		String meetingStartTime = XmlReader.getTagValue(strXml,"meetingStartTime").split(",")[1];// 开始时间
		String meetingEndTime = XmlReader.getTagValue(strXml,"meetingEndTime").split(",")[1];// 结束时间
		try {
			meetingDetailVO.setMeetingStartTime(new Timestamp(format.parse(meetingStartTime).getTime()));
			meetingDetailVO.setMeetingEndTime(new Timestamp(format.parse(meetingEndTime).getTime()));
		} catch (ParseException e) {
			return XmlReader.getXmlTop("false", "时间格式不正确");
		}
		String meetingId = ServiceFactory.getMeetingDetailService().query(meetingDetailVO);
		if(meetingId==null){
			return XmlReader.getXmlTop("false", "取消会议失败");
		}
		MeetingDetailVO meetingDetailVO1 = new MeetingDetailVO();
		meetingDetailVO1.setMeetingDetailID(meetingId);
		try {
			meetingDetailVO1 = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO1, null).get(0);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		meetingDetailVO1.setStatus("11");//取消会议
		try {
			ServiceFactory.getMeetingDetailService()
					.ModifyMeetingDetailForState(meetingDetailVO1);
			MeetingTaskOperate.removeMeetingEndTask(meetingId);
			//发送短信
			if(MeetingAppConfig.sms_status && ml.size()==0){
				logger.info("没有需要发送短信的联系人。");
			}else {//TODO 发送短信
				NoteSendThread nst = new NoteSendThread(ml, meetingDetailVO,"2");
				nst.start();
			}
			return XmlReader.getXmlTop("true", "取消会议成功");
		} catch (SQLException e) {

			return XmlReader.getXmlTop("false", "取消会议异常");
		}
	}

}
