package com.zzst.action.meeting.notice;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.enc.service.ENCObject;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.util.ControlFactory;

public class NoticeAction extends CjfAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(NoticeAction.class.getName());
	private EquipmentVO equipmentVO=new EquipmentVO();
	private ArrayList<EquipmentVO> equipmentVOList = new ArrayList<EquipmentVO>();
	private EquipmentTerminalVO equipmentTerminalVO=new EquipmentTerminalVO();
	private EquipmentMcuVO equipmentMcuVO=new EquipmentMcuVO();
	private MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
	private UserVO userVO=new UserVO();
	private ArrayList<EquipmentMcuVO> equipmentMcuList=new  ArrayList<EquipmentMcuVO>();
	private ArrayList<EquipmentVO> equipmentVOListsss = new ArrayList<EquipmentVO>();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private ArrayList<MeetingDetailVO>  lst_conference = new ArrayList<MeetingDetailVO>();
	
	
	public	String	queryLocalConference(){
		logger.info("GeneralMeetingAction	queryLocalConference		begin");
		try{
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			if(meetingDetailVO.getMeetingStartTime()==null)
				meetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
			lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, getPageControler());
			
		}catch(Exception e){
			logger.error("GeneralMeetingAction	queryLocalConference		error："+e.getMessage()+"/");
			e.printStackTrace();
			
			return "FAILURE";	
		}
		logger.info("GeneralMeetingAction	queryLocalConference		end");
		return "SUCCESS";
	}
	
	//add by yangyi
	public String noticePublish(){
		try {
			ArrayList<EquipmentVO> equipmentVOList = ServiceFactory.getEquipmentService().queryEquipmentVOByMeetingRoomIDs(meetingDetailVO.getMeetingRoomNameIDs());
			for (EquipmentVO equipmentVO : equipmentVOList) {
				ENCObject obj = (ENCObject)ControlFactory.getEncObject();
				obj.setURLView(equipmentVO.getMac(), equipmentVO.getDescription());
			}
			if(meetingDetailVO.getStatus()!=null&&meetingDetailVO.getStatus().equalsIgnoreCase(Integer.MIN_VALUE+"")){
				meetingDetailVO.setStatus("");
			}
			lst_conference = ServiceFactory.getMeetingDetailService().getMeetingDetailList(meetingDetailVO, getPageControler());
			
		} catch (Exception e) {
			logger.error(e);
			return "FAILURE";
		}
		
		return "SUCCESS";
	}
	
	public String showNoticeInfo(){
		
		return "SUCCESS";
	}
	

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public ArrayList<EquipmentVO> getEquipmentVOList() {
		return equipmentVOList;
	}

	public void setEquipmentVOList(ArrayList<EquipmentVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}

	public EquipmentTerminalVO getEquipmentTerminalVO() {
		return equipmentTerminalVO;
	}

	public void setEquipmentTerminalVO(EquipmentTerminalVO equipmentTerminalVO) {
		this.equipmentTerminalVO = equipmentTerminalVO;
	}

	public EquipmentMcuVO getEquipmentMcuVO() {
		return equipmentMcuVO;
	}

	public void setEquipmentMcuVO(EquipmentMcuVO equipmentMcuVO) {
		this.equipmentMcuVO = equipmentMcuVO;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public ArrayList<EquipmentMcuVO> getEquipmentMcuList() {
		return equipmentMcuList;
	}

	public void setEquipmentMcuList(ArrayList<EquipmentMcuVO> equipmentMcuList) {
		this.equipmentMcuList = equipmentMcuList;
	}

	public ArrayList<EquipmentVO> getEquipmentVOListsss() {
		return equipmentVOListsss;
	}

	public void setEquipmentVOListsss(ArrayList<EquipmentVO> equipmentVOListsss) {
		this.equipmentVOListsss = equipmentVOListsss;
	}

	public void setLst_conference(ArrayList<MeetingDetailVO> lst_conference) {
		this.lst_conference = lst_conference;
	}

	public ArrayList<MeetingDetailVO> getLst_conference() {
		return lst_conference;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}
    	
   
}
