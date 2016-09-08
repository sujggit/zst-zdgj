package com.zzst.action.meeting.util.notice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.messageContent.MessageContentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.service.meeting.userRole.UserRoleService;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;

public class SendMessageInstance implements Runnable{
	private Object info;
	private String type;
	private List<UserVO> userlist;
	private List<UserVO> userlist1;
	private List<UserVO> userlist2;
	private boolean isUpdate;
	private String oldRooms;
	private String newRooms;
	private SendByEmail sendByEmail = new SendByEmail();
	private SendBySMS sendBySMS = new SendBySMS();
	private SendByBillboard sendByBillboard = new SendByBillboard();
	private String meetingBookAdd = MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING;
	private String meetingBookModify = MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING;
	private String meetingBookDel = MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING;
	private String meetingBillboard = MeetingAppConfig.MESSAGE_TYPE_MEETINGBILLBOARD;
	
	/**
	 * 预定会议构造函数
	 * @param type
	 * @param info
	 * @param userlist
	 */
	public SendMessageInstance(String type , Object info , List<UserVO> userlist){
		this.info = info;
		this.type = type;
		this.userlist = userlist;
	}
	
	/**
	 * 常规构造函数
	 * @param type
	 * @param info
	 */
	public SendMessageInstance(String type , Object info){
		this.info = info;
		this.type = type;
		
	}
	
	public SendMessageInstance(String type , Object info , List<UserVO> removedUser , List<UserVO> addUser , List<UserVO> oldUser , boolean isUpdate,String oldRooms,String newRooms){
		this.info = info;
		this.type = type;
		this.userlist = removedUser;
		this.userlist1 = addUser;
		this.userlist2 = oldUser;
		this.isUpdate = isUpdate;
		this.oldRooms = oldRooms;
		this.newRooms = newRooms;
	}

	public void run() {

		try {
			//List<UserVO> userList = new ArrayList<UserVO>();
			UserRoleVO urVO = new UserRoleVO();
			urVO.setRoleID(DateBaseEnum.SYSTEM_ADMIN_ID);
			UserRoleService urService = new UserRoleServiceImpl();
			List<UserRoleVO> urList =urService.getUserByRole(urVO, null);
			if (type.equals(MeetingAppConfig.MESSAGE_TYPE_BOOKMEETING)) {
				//发送给与会人员
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				String[] meetingRooms = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				Object[] obj = new Object[3];
				obj[0] = info;
				if(meetingRooms.length==1){
					MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[0]);
					obj[1] = mr;
				}
				for(UserVO user : userlist){
					user = ServiceFactory.getUserService().getUserInfo(user, null);
					if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
						String address = user.getEmail();
						SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookUserMessage(meetingBookAdd),address);
						sendMessage.send();
					}
					if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
						String address = user.getMobile();
						SendMessage sendMessage = new SendMessage(obj,sendBySMS,new MeetingBookUserMessage(meetingBookAdd),address);
						sendMessage.send();
					}
					
				}
				//发送给系统管理员
				for(UserRoleVO urVO1 : urList){
					UserVO user = new UserVO();
					user.setUserID(urVO1.getUserID());
					user = ServiceFactory.getUserService().getUserInfo(user, null);
					if(user!=null){
						String address = user.getEmail();
						SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookSysAdminMessage(meetingBookAdd),address);
						sendMessage.send();
						String address1 = user.getMobile();
						SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookSysAdminMessage(meetingBookAdd),address1);
						sendMessage1.send();
					}
				}
				
				
				for(int i=0;i<meetingRooms.length;i++){
				
					MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[i]);
					
					obj[1] = mr;
					if(mr!=null){
						if(mr.getMeetingRoomType()==MeetingRoomEnum.ROOM_TYPE_GENERAL){		//会议室为本地会议室
							if(meetingDetailVO.getMeetingType()==1){	 	//预定会议为本地会议
								String address = mr.getUserVO().getEmail();
								SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookUserMessage(meetingBookAdd),address);
								sendMessage.send();
								String address1 = mr.getUserVO().getMobile();
								SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookUserMessage(meetingBookAdd),address1);
								sendMessage1.send();
							}else{
								String address = mr.getUserVO().getEmail();
								SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookUserMessage(meetingBookAdd),address);
								sendMessage.send();
								String address1 = mr.getUserVO().getMobile();
								SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookUserMessage(meetingBookAdd),address1);
								sendMessage1.send();
							}
							
							
						}else{//视频会议室
							//发送给设备管理员
							EquipmentVO equipmentVO = new EquipmentVO();
							equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
							equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
							equipmentVO.setMeetingRoomVO(mr);
							List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
							for(EquipmentVO eqVO : eqList){
								obj[2] = eqVO;
								String address = eqVO.getUserVO().getEmail();
								SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookEquipmentAdminMessage(meetingBookAdd),address);
								sendMessage.send();
								String address1 = eqVO.getUserVO().getMobile();
								SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookEquipmentAdminMessage(meetingBookAdd),address1);
								sendMessage1.send();
							}
							//发送给会议室管理员
							String address = mr.getUserVO().getEmail();
							SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookMeetingroomAdminMessage(meetingBookAdd),address);
							sendMessage.send();
							String address1 = mr.getUserVO().getMobile();
							SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookMeetingroomAdminMessage(meetingBookAdd),address1);
							sendMessage1.send();
						}
						
					}
					
				}
				if(meetingDetailVO.getNotifyType().charAt(2)=='1'){
					ArrayList<EquipmentVO> billboardList = ServiceFactory.getEquipmentService().queryNoticeByIds(meetingDetailVO.getMeetingRoomNameIDs());
					for(EquipmentVO eVO : billboardList){
						String address = eVO.getMac();
						SendMessage sendMessage = new SendMessage(obj,sendByBillboard,new BillboardMessage(meetingBillboard),address);
						sendMessage.send();
					}
				}
				
			} else if (type.equals(MeetingAppConfig.MESSAGE_TYPE_DELBOOKMEETING)) {
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				Object[] obj = new Object[3];
				obj[0] = info;
				//发送给与会人员
				MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
				meetingDetailUserVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
				List<MeetingDetailUserVO> meetingDetailUserList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(meetingDetailUserVO, null);
				if (meetingDetailUserList != null&& meetingDetailUserList.size() > 0) {
					for (MeetingDetailUserVO muVO : meetingDetailUserList) {
						UserVO uVO = new UserVO();
						uVO.setUserID(muVO.getUserID());
						uVO = ServiceFactory.getUserService().getUserInfo(uVO,null);
						if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
							String address = uVO.getEmail();
							SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookUserMessage(meetingBookDel),address);
							sendMessage.send();
						}
						if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
							String address1 = uVO.getMobile();
							SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookUserMessage(meetingBookDel),address1);
							sendMessage1.send();
						}
					}
				}
				//发送给系统管理员
				for(UserRoleVO urVO1 : urList){
					UserVO user = new UserVO();
					user.setUserID(urVO1.getUserID());
					user = ServiceFactory.getUserService().getUserInfo(user, null);
					if(user!=null){
					String address = user.getEmail();
					SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookSysAdminMessage(meetingBookDel),address);
					sendMessage.send();
					String address1 = user.getMobile();
					SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookSysAdminMessage(meetingBookDel),address1);
					sendMessage1.send();
					}
				}
				//发送给会议室管理员
				String[] meetingRooms = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				for(int i=0;i<meetingRooms.length;i++){
					MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[i]);
					obj[1] = mr;
					String address = mr.getUserVO().getEmail();
					SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookMeetingroomAdminMessage(meetingBookDel),address);
					sendMessage.send();
					String address1 = mr.getUserVO().getMobile();
					SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookMeetingroomAdminMessage(meetingBookDel),address1);
					sendMessage1.send();
					
					//发送给设备管理员
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
					equipmentVO.setMeetingRoomVO(mr);
					List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
					for(EquipmentVO eqVO : eqList){
						obj[2] = eqVO;
						String address2 = eqVO.getUserVO().getEmail();
						SendMessage sendMessage2 = new SendMessage(obj,sendByEmail,new MeetingBookEquipmentAdminMessage(meetingBookDel),address2);
						sendMessage2.send();
						String address3 = eqVO.getUserVO().getMobile();
						SendMessage sendMessage3 = new SendMessage(obj,sendBySMS,new MeetingBookEquipmentAdminMessage(meetingBookDel),address3);
						sendMessage3.send();
					}
				
				
			
				}
				if(meetingDetailVO.getNotifyType().charAt(2)=='1'){
					MessageContentVO mc = new MessageContentVO();
					mc.setFlowIdCont(meetingDetailVO.getMeetingDetailID());
					mc.setFlowType(MeetingAppConfig.MESSAGE_TYPE_MEETINGBILLBOARD);
					List<MessageContentVO> mcList = ServiceFactory.getMessageContentService().query(mc, null);
					for(MessageContentVO mcVO : mcList){
						ServiceFactory.getMessageContentService().deleteByID(mcVO.getId());
					}
				}
			} else if (type.equals(MeetingAppConfig.MESSAGE_TYPE_MODIFYBOOKMEETING)) {
				boolean isRoomUpdate = false;
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				Object[] obj = new Object[3];
				obj[0] = info;
				MeetingRoomVO meetingRoom = new MeetingRoomVO();
				//参会会议室变更 发送给会议室管理员
				if(oldRooms!=null&&newRooms!=null){
					if(!oldRooms.equals(newRooms)){
						
					List<String> oldMeetingRooms = new LinkedList<String>(Arrays.asList(oldRooms.split(",")));
					List<String> newMeetingRooms = new LinkedList<String>(Arrays.asList(newRooms.split(",")));
					if(oldMeetingRooms.size()==1&&newMeetingRooms.size()==1){
						meetingRoom = ServiceFactory.getMeetingRoomService().queryByID(newMeetingRooms.get(0));
						isRoomUpdate = true;
					}
					for(int i=0;i<newMeetingRooms.size();i++){
						for(int j=0;j<oldMeetingRooms.size();j++){
							if(oldMeetingRooms.get(j).equals(newMeetingRooms.get(i))){
								oldMeetingRooms.remove(j);
								newMeetingRooms.remove(i);
								i--;
								break;
							}
						}
					}
					
					for(int i=0;i<oldMeetingRooms.size();i++){
						MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(oldMeetingRooms.get(i));
						obj[1] = mr;
						String address = mr.getUserVO().getEmail();
						SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookMeetingroomAdminMessage(meetingBookDel),address);
						sendMessage.send();
						String address1 = mr.getUserVO().getMobile();
						SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookMeetingroomAdminMessage(meetingBookDel),address1);
						sendMessage1.send();
						//发送给设备管理员
						EquipmentVO equipmentVO = new EquipmentVO();
						equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
						equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
						equipmentVO.setMeetingRoomVO(mr);
						List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
						for(EquipmentVO eqVO : eqList){
							obj[2] = eqVO;
							String address2 = eqVO.getUserVO().getEmail();
							SendMessage sendMessage2 = new SendMessage(obj,sendByEmail,new MeetingBookEquipmentAdminMessage(meetingBookDel),address2);
							sendMessage2.send();
							String address3 = eqVO.getUserVO().getMobile();
							SendMessage sendMessage3 = new SendMessage(obj,sendBySMS,new MeetingBookEquipmentAdminMessage(meetingBookDel),address3);
							sendMessage3.send();
						}
					}
					
					for(int i=0;i<newMeetingRooms.size();i++){
						MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(newMeetingRooms.get(i));
						obj[1] = mr;
						String address = mr.getUserVO().getEmail();
						SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookMeetingroomAdminMessage(meetingBookAdd),address);
						sendMessage.send();
						String address1 = mr.getUserVO().getMobile();
						SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookMeetingroomAdminMessage(meetingBookAdd),address1);
						sendMessage1.send();
						//发送给设备管理员
						EquipmentVO equipmentVO = new EquipmentVO();
						equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
						equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
						equipmentVO.setMeetingRoomVO(mr);
						List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
						for(EquipmentVO eqVO : eqList){
							obj[2] = eqVO;
							String address2 = eqVO.getUserVO().getEmail();
							SendMessage sendMessage2 = new SendMessage(obj,sendByEmail,new MeetingBookEquipmentAdminMessage(meetingBookAdd),address2);
							sendMessage2.send();
							String address3 = eqVO.getUserVO().getMobile();
							SendMessage sendMessage3 = new SendMessage(obj,sendBySMS,new MeetingBookEquipmentAdminMessage(meetingBookAdd),address3);
							sendMessage3.send();
						}
					}
					}
				}
				
				
				if (isUpdate||isRoomUpdate) {
					//时间修改发送给与会人员
					obj[1] = meetingRoom;
					for(UserVO uVO : userlist2){
						uVO = ServiceFactory.getUserService().getUserInfo(uVO, null);
						if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
							String address = uVO.getEmail();
							SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookUserMessage(meetingBookModify),address);
							sendMessage.send();
						}
						if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
							String address1 = uVO.getMobile();
							SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookUserMessage(meetingBookModify),address1);
							sendMessage1.send();
						}
					}
					if(isUpdate){
					//发送给系统管理员
					for(UserRoleVO urVO1 : urList){
						UserVO user = new UserVO();
						user.setUserID(urVO1.getUserID());
						user = ServiceFactory.getUserService().getUserInfo(user, null);
						if(user!=null){
							String address = user.getEmail();
							SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookSysAdminMessage(meetingBookModify),address);
							sendMessage.send();
							String address1 = user.getMobile();
							SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookSysAdminMessage(meetingBookModify),address1);
							sendMessage1.send();
						}
						
					}
					//发送给会议室管理员
					String[] meetingRooms = meetingDetailVO.getMeetingRoomNameIDs().split(",");
					for(int i=0;i<meetingRooms.length;i++){
					MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[i]);
					obj[1] = mr;
					String address = mr.getUserVO().getEmail();
					SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookMeetingroomAdminMessage(meetingBookModify),address);
					sendMessage.send();
					String address1 = mr.getUserVO().getMobile();
					SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookMeetingroomAdminMessage(meetingBookModify),address1);
					sendMessage1.send();
					//发送给设备管理员
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
					equipmentVO.setMeetingRoomVO(mr);
					List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
					for(EquipmentVO eqVO : eqList){
						obj[2] = eqVO;
						String address2 = eqVO.getUserVO().getEmail();
						SendMessage sendMessage2 = new SendMessage(obj,sendByEmail,new MeetingBookEquipmentAdminMessage(meetingBookModify),address2);
						sendMessage2.send();
						String address3 = eqVO.getUserVO().getMobile();
						SendMessage sendMessage3 = new SendMessage(obj,sendBySMS,new MeetingBookEquipmentAdminMessage(meetingBookModify),address3);
						sendMessage3.send();
					}
					}
				}
				}
				//发送给取消的参会人员
				for(UserVO uVO : userlist){
					uVO = ServiceFactory.getUserService().getUserInfo(uVO, null);
					if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
						String address2 = uVO.getEmail();
						SendMessage sendMessage2 = new SendMessage(obj,sendByEmail,new MeetingBookUserMessage(meetingBookDel),address2);
						sendMessage2.send();
					}
					if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
						String address3 = uVO.getMobile();
						SendMessage sendMessage3 = new SendMessage(obj,sendBySMS,new MeetingBookUserMessage(meetingBookDel),address3);
						sendMessage3.send();
					}
				}
				//发送给新添加的参会人员
				for(UserVO uVO : userlist1){
					uVO = ServiceFactory.getUserService().getUserInfo(uVO, null);
					if(meetingDetailVO.getNotifyType().charAt(1)=='1'){
						String address2 = uVO.getEmail();
						SendMessage sendMessage2 = new SendMessage(obj,sendByEmail,new MeetingBookUserMessage(meetingBookAdd),address2);
						sendMessage2.send();
					}
					if(meetingDetailVO.getNotifyType().charAt(0)=='1'){
						String address3 = uVO.getMobile();
						SendMessage sendMessage3 = new SendMessage(obj,sendBySMS,new MeetingBookUserMessage(meetingBookAdd),address3);
						sendMessage3.send();
					}
					}
				if(meetingDetailVO.getNotifyType().charAt(2)=='1'){
					MessageContentVO mc = new MessageContentVO();
					mc.setFlowIdCont(meetingDetailVO.getMeetingDetailID());
					mc.setFlowType(MeetingAppConfig.MESSAGE_TYPE_MEETINGBILLBOARD);
					List<MessageContentVO> mcList = ServiceFactory.getMessageContentService().query(mc, null);
					for(MessageContentVO mcVO : mcList){
						ServiceFactory.getMessageContentService().deleteByID(mcVO.getId());
					}
					ArrayList<EquipmentVO> billboardList = ServiceFactory.getEquipmentService().queryNoticeByIds(meetingDetailVO.getMeetingRoomNameIDs());
					for(EquipmentVO eVO : billboardList){
						String address = eVO.getMac();
						SendMessage sendMessage = new SendMessage(obj,sendByBillboard,new BillboardMessage(meetingBillboard),address);
						sendMessage.send();
					}
				}
			}else if(type.equals(MeetingAppConfig.MESSAGE_TYPE_MEETINGDEBUG)){
				MeetingDetailVO meetingDetailVO = (MeetingDetailVO) info;
				Object[] obj = new Object[3];
				obj[0] = info;
				//发送给会议室管理员
				String[] meetingRooms = meetingDetailVO.getMeetingRoomNameIDs().split(",");
				for(int i=0;i<meetingRooms.length;i++){
				MeetingRoomVO mr = ServiceFactory.getMeetingRoomService().queryByID(meetingRooms[i]);
				obj[1] = mr;
				if(meetingDetailVO.getMeetingDebugVO().getNoticeType().charAt(1)=='1'){
					String address = mr.getUserVO().getEmail();
					SendMessage sendMessage = new SendMessage(obj,sendByEmail,new MeetingBookMeetingroomAdminMessage(MeetingAppConfig.MESSAGE_TYPE_MEETINGDEBUG),address);
					sendMessage.send();
				}
				if(meetingDetailVO.getMeetingDebugVO().getNoticeType().charAt(0)=='1'){
					String address1 = mr.getUserVO().getMobile();
					SendMessage sendMessage1 = new SendMessage(obj,sendBySMS,new MeetingBookMeetingroomAdminMessage(MeetingAppConfig.MESSAGE_TYPE_MEETINGDEBUG),address1);
					sendMessage1.send();
				}
				//发送给设备管理员
				EquipmentVO equipmentVO = new EquipmentVO();
				equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
				equipmentVO.setMeetingRoomVO(mr);
				List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
				for(EquipmentVO eqVO : eqList){
					obj[2] = eqVO;
					if(meetingDetailVO.getMeetingDebugVO().getNoticeType().charAt(1)=='1'){
						String address2 = eqVO.getUserVO().getEmail();
						SendMessage sendMessage2 = new SendMessage(obj,sendByEmail,new MeetingBookEquipmentAdminMessage(MeetingAppConfig.MESSAGE_TYPE_MEETINGDEBUG),address2);
						sendMessage2.send();
					}
					if(meetingDetailVO.getMeetingDebugVO().getNoticeType().charAt(0)=='1'){
						String address3 = eqVO.getUserVO().getMobile();
						SendMessage sendMessage3 = new SendMessage(obj,sendBySMS,new MeetingBookEquipmentAdminMessage(MeetingAppConfig.MESSAGE_TYPE_MEETINGDEBUG),address3);
						sendMessage3.send();
					}
				}
				
			}
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}