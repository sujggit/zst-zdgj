package com.zzst.action.meeting.util.notice;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

public class MessageContent {
	public String getMessageContent(String type){
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoName(type);
		String message = null;
		List<BaseInfoVO> biList = new ArrayList<BaseInfoVO>();
		try {
			biList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if(null!=biList){
				baseInfoVO = biList.get(0);
				message = baseInfoVO.getInfoValue();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return message;
	}
	
	public String replaceStr(Object[] obj,String message){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分 ");
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		if(meetingDetail.getMeetingName()!=null){
			message = message.replaceAll("##1", meetingDetail.getMeetingName());
		}
		
		if(meetingDetail.getMeetingStartTime()!=null){
			message = message.replaceAll("##2", sdf.format(meetingDetail.getMeetingStartTime()));
		}
		
		if(meetingDetail.getMeetingEndTime()!=null){
			message = message.replaceAll("##3", sdf.format(meetingDetail.getMeetingEndTime()));
		}
		
		if(meetingDetail.getMeetingDebugVO().getDebugStartTime()!=null){
			message = message.replaceAll("##6", sdf.format(meetingDetail.getMeetingDebugVO().getDebugStartTime()));
		}
		
		if(obj.length>0&&obj[1]!=null){
			MeetingRoomVO mr = (MeetingRoomVO)obj[1];
			message = message.replaceAll("##4", mr.getMeetingRoomName());
		}
		if(obj.length>1&&obj[2]!=null){
			EquipmentVO eq = (EquipmentVO)obj[2];
			message = message.replaceAll("##5", eq.getEquipmentNO());
		}
		return message;
	}
	
	public Timestamp getEndTime(Object[] obj){
		MeetingDetailVO meetingDetail = (MeetingDetailVO)obj[0];
		return meetingDetail.getMeetingEndTime();
	}
}
