package com.zzst.action.meeting.dataInterface;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceService;
import com.zzst.service.meeting.log.LogServiceImpl;

public class MeetingRoomInterfaceAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(MeetingRoomInterfaceAction.class.getName());
	private static MeetingRoomInterfaceService mrService = ServiceFactory.getMeetingRoomInterfaceService();
	private ArrayList<MeetingRoomInterfaceVO> mrifList = new ArrayList<MeetingRoomInterfaceVO>();
	private MeetingRoomInterfaceVO mrVO = new MeetingRoomInterfaceVO();
	
	
	public String queryMeetingRoom(){
		logger.info("MeetingRoomInterfaceAction	queryMeetingRoom	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			mrifList = mrService.query(mrVO, pSplittor.getPControler());
			
		}catch(Exception e){
			logger.error("MeetingRoomInterfaceAction	queryMeetingRoom	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("MeetingRoomInterfaceAction	queryMeetingRoom	end");
		return SUCCESS; 
	}
	
	public String delete(){
		logger.info("MeetingRoomInterfaceAction	delete	begin");
		try{
			mrService.deleteByID(mrVO.getId());
			
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行delete操作");
				new LogServiceImpl().add(logVO);
			}
			
			
		}catch(Exception e){
			logger.error("MeetingRoomInterfaceAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomInterfaceAction	delete	end");
		return SUCCESS;
	}
	
	public String detail(){
		logger.info("MeetingRoomInterfaceAction	detail	begin");
		try{
			mrVO = mrService.queryByID(mrVO.getId());
			
		}catch(Exception e){
			logger.error("MeetingRoomInterfaceAction	detail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomInterfaceAction	detail	end");
		return SUCCESS;
	}
	
	public String beforeModify(){
		logger.info("MeetingRoomInterfaceAction	beforeModify	begin");
		try{
			mrVO = mrService.queryByID(mrVO.getId());
			
		}catch(Exception e){
			logger.error("MeetingRoomInterfaceAction	beforeModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomInterfaceAction	beforeModify	end");
		return SUCCESS;
	}
	
	public String modify(){
		logger.info("MeetingRoomInterfaceAction	modify	begin");
		try{
			
			
			mrVO = mrService.modify(mrVO);
			
			
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_meetingroom表 进行update操作");
				new LogServiceImpl().add(logVO);
			}
			
		}catch(Exception e){
			logger.error("MeetingRoomInterfaceAction	modify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomInterfaceAction	modify	end");
		return SUCCESS;
	}

	public ArrayList<MeetingRoomInterfaceVO> getMrifList() {
		return mrifList;
	}

	public void setMrifList(ArrayList<MeetingRoomInterfaceVO> mrifList) {
		this.mrifList = mrifList;
	}

	public MeetingRoomInterfaceVO getMrVO() {
		return mrVO;
	}

	public void setMrVO(MeetingRoomInterfaceVO mrVO) {
		this.mrVO = mrVO;
	}
	
	
}
