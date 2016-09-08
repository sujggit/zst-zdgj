package com.zzst.action.meeting.dataInterface.meeting;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.VideoconferenceEnum;
import com.zzst.model.meeting.dataInterface.enums.InterfaceMeetingDetailEnum;
import com.zzst.model.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;


/**
 *@Description	实现会议预约接口表的维护功能
 *@date 2013-5-30上午11:36:30
 *@author ryan
 */
public class InterfaceMeetingDetailAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(InterfaceMeetingDetailAction.class.getName());
	
	private static InterfaceMeetingDetailService service = ServiceFactory.getInterfaceMeetingDetailService();
	private ArrayList<InterfaceMeetingDetailVO> list = new ArrayList<InterfaceMeetingDetailVO>();
	private InterfaceMeetingDetailVO interfaceMeetingDetailVO = new InterfaceMeetingDetailVO();
	
	/**
	 * 接口表倒到核心表
	 */
	public void dataInput(){
		logger.info("InterfaceMeetingDetailAction	dataInput	begin");
		try {
			MeetingDetailService meetingService = ServiceFactory.getMeetingDetailService();
			InterfaceMeetingDetailVO interVO = new InterfaceMeetingDetailVO();
			interVO.setStatus(InterfaceMeetingDetailEnum.import_default);
			list = service.query(interVO, null);
			for(InterfaceMeetingDetailVO vo : list){
				if(MeetingDetailEnum.TYPE_GENERAL==vo.getMeetingType()){
					MeetingDetailVO mvo = new MeetingDetailVO();
					mvo.setMeetingType(MeetingDetailEnum.TYPE_GENERAL);
					mvo.setConfProfileID(vo.getConfProfileID());
					mvo.setMeetingID(vo.getId());
					try{
						UserVO u = new UserVO();
						u.setLoginName(vo.getCreateUserName());
						u = ServiceFactory.getUserService().getUserInfo(u, null);
						mvo.setCreateUserID(u.getUserID());
					}catch(Exception e){
						
					}
					mvo.setMeetingStartTime(vo.getStarttime());
					mvo.setMeetingEndTime(vo.getEndtime());
					mvo.setMeetingName(vo.getMeetingname());
					mvo.setStatus(vo.getMeetingStatus()+"");
					ArrayList<VideoconferenceVO> roomList = new ArrayList<VideoconferenceVO>(); 
					if(null!=vo.getRoomNos()&&vo.getRoomNos().length()>0){
						String[] roomIDs = vo.getRoomNos().split(",");
						for(int i=0;i<roomIDs.length;i++){
							VideoconferenceVO venueVO = new VideoconferenceVO();
							MeetingRoomVO rvo = new MeetingRoomVO();
							rvo.setRoomNO(roomIDs[i]);
							ArrayList<MeetingRoomVO> roomListNO = ServiceFactory.getMeetingRoomService().query(rvo,null);
							if(roomListNO!=null&&roomListNO.size()==1){
								venueVO.setSubmeetingRoomID(roomListNO.get(0).getMeetingRoomID());
								roomList.add(venueVO);
							}
						}
					}
					MeetingDetailVO voed = new MeetingDetailVO();
					voed.setMeetingID(vo.getId());
					List<MeetingDetailVO> list = meetingService.query(voed, null);
					if(list!=null&&list.size()==0)
						meetingService.addGeneralMeetingDetail(mvo, null, roomList, null);					
				}else if(MeetingDetailEnum.TYPE_VEDIO==vo.getMeetingType()){
					MeetingDetailVO mvo = new MeetingDetailVO();
					mvo.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
					mvo.setConfProfileID(vo.getConfProfileID());
					mvo.setMeetingID(vo.getId());
					try{
						UserVO u = new UserVO();
						u.setLoginName(vo.getCreateUserName());
						u = ServiceFactory.getUserService().getUserInfo(u, null);
						mvo.setCreateUserID(u.getUserID());
					}catch(Exception e){
						
					}
					mvo.setMeetingStartTime(vo.getStarttime());
					mvo.setMeetingEndTime(vo.getEndtime());
					mvo.setMeetingName(vo.getMeetingname());
					mvo.setStatus(vo.getMeetingStatus()+"");
					ArrayList<VideoconferenceVO> roomList = new ArrayList<VideoconferenceVO>(); 
					String meetingroomNameIDs = "";
					
					MeetingRoomVO rvo = new MeetingRoomVO();
					rvo.setRoomNO(vo.getMainRoomNO());
					ArrayList<MeetingRoomVO> roomListNO = ServiceFactory.getMeetingRoomService().query(rvo,null);
					if(roomListNO!=null&&roomListNO.size()==1){
						VideoconferenceVO venueVO = new VideoconferenceVO();
						venueVO.setSubmeetingRoomID(roomListNO.get(0).getMeetingRoomID());
						venueVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
						meetingroomNameIDs +=meetingroomNameIDs+","+roomListNO.get(0).getMeetingRoomID();
						roomList.add(venueVO);
					}
					String[] roomIDs ={};
					if(null!=vo.getRoomNos()&&vo.getRoomNos().length()>0){
						roomIDs = vo.getRoomNos().split(",");
						for(int i=0;i<roomIDs.length;i++){
							if(roomIDs[i].equals(vo.getMainRoomNO())) continue;
							
							VideoconferenceVO venueVO = new VideoconferenceVO();
							rvo = new MeetingRoomVO();
							rvo.setRoomNO(roomIDs[i]);
							rvo.setStatus(MeetingRoomEnum.ROOM_STATUS_VALID);
							roomListNO = ServiceFactory.getMeetingRoomService().query(rvo,null);
							if(roomListNO!=null&&roomListNO.size()==1){
								venueVO.setSubmeetingRoomID(roomListNO.get(0).getMeetingRoomID());
								venueVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
								meetingroomNameIDs +=meetingroomNameIDs+","+roomListNO.get(0).getMeetingRoomID();
								roomList.add(venueVO);
							}
						}
					}
					MeetingDetailVO voed = new MeetingDetailVO();
					voed.setMeetingID(vo.getId());
					List<MeetingDetailVO> list = meetingService.query(voed, null);
					if(list!=null&&list.size()==0){
						meetingService.addVedioMeetingDetail(mvo, null, roomList);
					}else{
						meetingService.modifyVedioMeetingDetail(mvo,null,roomList);
					}
					MeetingTaskOperate.meetingStartTask(mvo);//定时器	
				}else{
					logger.warn("同步预约信息异常");
				}
			}
		} catch (Exception e) {
			logger.error("InterfaceMeetingDetailAction	dataInput	error:"+e.getMessage());
		}
		logger.info("InterfaceMeetingDetailAction	dataInput	end");
	}
	
	public String query(){
		logger.info("InterfaceMeetingDetailAction	query	begin");
		try {
			
		} catch (Exception e) {
			logger.error("MeetingRoomAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("InterfaceMeetingDetailAction	query	end");
		return	SUCCESS;
	}

	public String modify(){
		
		return "";
	}
}
