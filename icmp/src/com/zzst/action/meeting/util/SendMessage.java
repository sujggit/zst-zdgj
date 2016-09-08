package com.zzst.action.meeting.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.messageContent.MessageContentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

public class SendMessage {
	private Object info;
	private String type;
	private List<UserVO> userlist;
	private List<UserVO> userlist1;
	private List<UserVO> userlist2;
	private final Integer EMAILMESSAGE = 1;
	private final Integer MOBILEMESSAGE = 2;
	private boolean mail_status = MeetingAppConfig.mail_status;
	private boolean sms_status = MeetingAppConfig.sms_status;
	private boolean isUpdate;
	private String messageSwitch;
	/**
	 * 预定会议构造函数
	 * @param type
	 * @param info
	 * @param userlist
	 */
	public SendMessage(String type , Object info , List<UserVO> userlist, String messageSwitch){
		this.info = info;
		this.type = type;
		this.userlist = userlist;
		this.messageSwitch = messageSwitch;
	}
	
	/**
	 * 常规构造函数
	 * @param type
	 * @param info
	 */
	public SendMessage(String type , Object info,String messageSwitch){
		this.info = info;
		this.type = type;
		this.messageSwitch = messageSwitch;
		
	}
	
	public SendMessage(String type , Object info , List<UserVO> removedUser , List<UserVO> addUser , List<UserVO> oldUser , boolean isUpdate , String messageSwitch){
		this.info = info;
		this.type = type;
		this.userlist = removedUser;
		this.userlist1 = addUser;
		this.userlist2 = oldUser;
		this.isUpdate = isUpdate;
		this.messageSwitch = messageSwitch;
	}
	
	public String sendMessage(){
		if("11".equals(messageSwitch)){
			sendMessageByEmail(EMAILMESSAGE);
			sendMessageByEmail(MOBILEMESSAGE);
		}else if("10".equals(messageSwitch)){
			sendMessageByEmail(EMAILMESSAGE);
		}else if("01".equals(messageSwitch)){
			sendMessageByEmail(MOBILEMESSAGE);
		}else{
			
		}
		return "";
	}

	public String sendMessageByEmail(int mailOrMobile ) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分 ");
			List<UserVO> userList = new ArrayList<UserVO>();
			if (type.equals(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING)) {
				//发送给与会人员
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				String messageBody = "会议："
					+ meetingDetailVO.getMeetingName() + "将在"
					+ sdf.format(meetingDetailVO.getMeetingStartTime())
					+ "召开，请准时参加！";
				
				assembleData(userlist,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
				String[] meetingRooms = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				
				for(int i=0;i<meetingRooms.length;i++){
				
					MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[i]);
						if(mr.getMeetingRoomType()==MeetingRoomEnum.ROOM_TYPE_GENERAL){		//会议室为本地会议室
							if(meetingDetailVO.getMeetingType()==1){	 	//预定会议为本地会议
								//发送给本地会议室管理员
								messageBody = "会议："
									+meetingDetailVO.getMeetingName()+"将于"
									+sdf.format(meetingDetailVO.getMeetingStartTime())
									+"在"+mr.getMeetingRoomName()+"召开，请进行会议室准备。";
							}else{
								//发送给设备管理员
								/*EquipmentVO equipmentVO = new EquipmentVO();
								equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
								equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
								equipmentVO.setMeetingRoomVO(mr);
								List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
								for(EquipmentVO eqVO : eqList){
									messageBody = "视频会议："
										+meetingDetailVO.getMeetingName()+"将于"
										+sdf.format(meetingDetailVO.getMeetingStartTime())
										+"在"+mr.getMeetingRoomName()+"召开，请准备。";
									userList.clear();									//清除上次内容
									userList.add(eqVO.getUserVO());
									assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
								}*/
								//发送给会议室管理员
								messageBody = "视频会议："
									+meetingDetailVO.getMeetingName()+"将于"
									+sdf.format(meetingDetailVO.getMeetingStartTime())
									+"在"+mr.getMeetingRoomName()+"召开，请进行移送终端准备调试。";
							}
							
							userList.clear();									//清除上次内容
							userList.add(mr.getUserVO());
							assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
						}else{//视频会议室
							//发送给设备管理员
							EquipmentVO equipmentVO = new EquipmentVO();
							equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
							equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
							equipmentVO.setMeetingRoomVO(mr);
							List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
							for(EquipmentVO eqVO : eqList){
								messageBody = "视频会议："
									+meetingDetailVO.getMeetingName()+"将于"
									+sdf.format(meetingDetailVO.getMeetingStartTime())
									+"在"+mr.getMeetingRoomName()+"召开，请准备。";
								userList.clear();									//清除上次内容
								userList.add(eqVO.getUserVO());
								assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
							}
							//发送给会议室管理员
							messageBody = "视频会议："
								+meetingDetailVO.getMeetingName()+"将于"
								+sdf.format(meetingDetailVO.getMeetingStartTime())
								+"在"+mr.getMeetingRoomName()+"召开，请进行会议室准备。";
							userList.clear();
							userList.add(mr.getUserVO());
							assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
						}
					
				}
			} else if (type.equals(MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING)) {
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				String messageBody;
				//发送给与会人员
				MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
				meetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
				List<MeetingDetailUserVO> meetingDetailUserList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
				if (meetingDetailUserList != null&& meetingDetailUserList.size() > 0) {
					for (MeetingDetailUserVO muVO : meetingDetailUserList) {
						UserVO uVO = new UserVO();
						uVO.setUserID(muVO.getUserID());
						uVO = ServiceFactory.getUserService().getUserInfo(uVO,null);
						messageBody = "定于"+sdf.format(meetingDetailVO.getMeetingStartTime())
										+"召开的会议："+ meetingDetailVO.getMeetingName() + "已取消！";
						userList.clear();
						userList.add(uVO);
						assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING);
					}
				}
				//发送给会议室管理员
				String[] meetingRooms = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				for(int i=0;i<meetingRooms.length;i++){
				MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[i]);
				
					messageBody = "定于"+sdf.format(meetingDetailVO.getMeetingStartTime())
									+"在"+mr.getMeetingRoomName()+"召开的会议："
									+ meetingDetailVO.getMeetingName() + "已取消！";
					userList.clear();
					userList.add(mr.getUserVO());
					assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING);
				
				
					//发送给设备管理员
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
					equipmentVO.setMeetingRoomVO(mr);
					List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
					for(EquipmentVO eqVO : eqList){
						messageBody = "定于"+sdf.format(meetingDetailVO.getMeetingStartTime())
										+"在"+mr.getMeetingRoomName()+"召开的会议："
										+ meetingDetailVO.getMeetingName() + "已取消！";
						userList.clear();									//清除上次内容
						userList.add(eqVO.getUserVO());
						assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
					}
				
				}
			} else if (type.equals(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING)) {
				String messageBody;
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				
				if (isUpdate) {
					//时间修改发送给与会人员
					messageBody = "会议："
						+ meetingDetailVO.getMeetingName()
						+ "开始时间修改为"
						+ sdf.format(meetingDetailVO.getMeetingStartTime());
					assembleData(userlist2,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING);
					//发送给会议室管理员
					String[] meetingRooms = meetingDetailVO.getMeetingRoomNameIDs().split(",");
					for(int i=0;i<meetingRooms.length;i++){
					MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[i]);
					messageBody = "定于在"+mr.getMeetingRoomName()+"召开的会议："
						+ meetingDetailVO.getMeetingName()
						+ "开始时间修改为"
						+ sdf.format(meetingDetailVO.getMeetingStartTime());
					userList.clear();									//清除上次内容
					userList.add(mr.getUserVO());
					assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
					//发送给设备管理员
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
					equipmentVO.setMeetingRoomVO(mr);
					List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
					for(EquipmentVO eqVO : eqList){
						messageBody = "定于在"+mr.getMeetingRoomName()+"召开的会议："
						+ meetingDetailVO.getMeetingName()
						+ "开始时间修改为"
						+ sdf.format(meetingDetailVO.getMeetingStartTime());
						userList.clear();									//清除上次内容
						userList.add(eqVO.getUserVO());
						assembleData(userList,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING);
					}
					}
				}
				//发送给取消的参会人员
				messageBody = "会议："
					+ meetingDetailVO.getMeetingName() + "信息已修改，您无需参加本次会议";
				assembleData(userlist,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING);
				//发送给新添加的参会人员
				messageBody = "会议："
					+ meetingDetailVO.getMeetingName() + "将在"
					+ sdf.format(meetingDetailVO.getMeetingStartTime())
					+ "召开，请准时参加！";
				assembleData(userlist1,mailOrMobile,messageBody,MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING);
			
			}else if(type.equals(MeetingAppConfig.MESSAGE_TYPE_MEETINGEND)){
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
				meetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
				List<MeetingDetailUserVO> meetingDetailUserList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
				if (meetingDetailUserList != null&& meetingDetailUserList.size() > 0) {
					for (MeetingDetailUserVO muVO : meetingDetailUserList) {
						UserVO uVO = new UserVO();
						uVO.setUserID(muVO.getUserID());
						uVO = ServiceFactory.getUserService().getUserInfo(uVO,null);
						if (uVO != null && uVO.getEmail() != null) {
							String messageBody = "会议："+ meetingDetailVO.getMeetingName() + "将在5分钟后结束！";
							String address = "";
							if(mailOrMobile == EMAILMESSAGE){
								address = uVO.getEmail();
							}else{
								address = uVO.getMobile();
							}	
							addMessage(
									mailOrMobile,
									MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING,
									meetingDetailVO.getMeetingDetailID(),
									MeetingAppConfig.MAIL_SUBNAME, messageBody,
									address);
						}
					}
				}
				
			}else if(type.equals(MeetingAppConfig.MESSAGE_TYPE_TEROFFLINE)){
				
			}else if(type.equals(MeetingAppConfig.MESSAGE_TYPE_EQWANRRANTY)){
				EquipmentVO equipmentVO = (EquipmentVO)info;
				UserVO user = equipmentVO.getUserVO();
				String messageBody = "设备："+equipmentVO.getEquipmentName()+"维修期将于今天到期！";
				String address = "";
				if(mailOrMobile == EMAILMESSAGE){
					address = user.getEmail();
				}else{
					address = user.getMobile();
				}	
				addMessage(
						mailOrMobile,
						MeetingAppConfig.MESSAGE_TYPE_EQWANRRANTY,
						equipmentVO.getEquipmentID(),
						MeetingAppConfig.NOTICE_TITLE, messageBody,
						address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String sendMessageByMobile(){
		return "";
	}
	
	public void assembleData(List<UserVO> userList,int mailOrMobile,String messageBody,String flowType){
		for(UserVO user : userList){
			
		
		if (user.getEmail() != null && user.getEmail().length() > 1) {
			
			
			String address = "";
			if(mailOrMobile == EMAILMESSAGE){
				address = user.getEmail();
			}else{
				address = user.getMobile();
			}
			addMessage(mailOrMobile,
					MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING,
					flowType,
					MeetingAppConfig.MAIL_SUBNAME, messageBody,
					address);
		}
		}
	}
	
	public void addMessage(int messageType,String flowType,String flowIdCont,String messageSubject,String messageBody ,String messageAdress){
		try {
		MessageContentVO messageContent = new MessageContentVO();
		messageContent.setMessageType(messageType);

		messageContent.setFlowType(flowType);
		
		messageContent.setFlowIdCont(flowIdCont);
		messageContent.setMessageSubject(messageSubject);
		messageContent.setMessageBody(messageBody);
		messageContent.setInsertTime(new Timestamp(System.currentTimeMillis()));

		messageContent.setMessageAdress(messageAdress);

		
			ServiceFactory.getMessageContentService().add(messageContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
