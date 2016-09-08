package com.zzst.action.meeting.meeting;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.meeting.dwr.DwrMethod;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;

public class ScreenModelAction extends BaseAction{
	private static Logger logger = CbfLogger.getLogger(ScreenModelAction.class.getName());
	private ArrayList<MeetingDetailVO> meetingDetailList = new ArrayList<MeetingDetailVO>();

	
	public String beforeSetPersonal(){
		logger.info("ScreenModelAction  beforeSetPersonal  begin");
		List<ZZOMainStatusVO> confRoomList = new ArrayList<ZZOMainStatusVO>();
		String[] rooms = request.getParameter("guid").split("__");
		String guid = rooms[1];
		String op = request.getParameter("op");
		try {
			List<ZZOConfVO> confVOList = new ArrayList<ZZOConfVO>();	
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
			meetingDetailList = meetingDetailService.getMeetingListForToday(vMeetingDetailVO, null);
			if(meetingDetailList != null && meetingDetailList.size() > 0){
				List<ZZOConfVO> oldConfList = null;
				for(MeetingDetailVO meetingDetail : meetingDetailList){
					oldConfList = ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(meetingDetail.getMeetingDetailID());
					for(int i=0;i<oldConfList.size();i++){
						if(oldConfList.get(i).getGuid().equals(guid)&&oldConfList.get(i).getIsMasterConf()==1){
							confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetail.getMeetingDetailID());
						}else if(oldConfList.get(i).getGuid().equals(guid)){
							confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(oldConfList.get(i).getConfFlagId(), oldConfList.get(i).getMcuIP(), oldConfList.get(i).getGuid());
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return  REQUEST_FAILURE;
		}
		List<ZZOMainStatusVO> confRoomList1 = new ArrayList<ZZOMainStatusVO>();
		confRoomList1.addAll(confRoomList);
		for(int k=0;k<confRoomList1.size();k++){
			if(!confRoomList1.get(k).getCascadeRole().equals("none")){
				confRoomList1.remove(k);
				k--;
			}
		}
		request.setAttribute("meetingRoomList", confRoomList1);
		request.setAttribute("monitor",request.getParameter("guid") );
		if(op.equals("one")){
			request.setAttribute("screenCount", 1);
		}else if(op.equals("two")){
			request.setAttribute("screenCount", 2);
		}else if(op.equals("four")){
			request.setAttribute("screenCount", 4);
		}
		DwrMethod.infos=null;
		DwrMethod.numCache=-1;
		DwrMethod.selectCount=null;
		return REQUEST_SUCCESS;
		
		
	}
}
