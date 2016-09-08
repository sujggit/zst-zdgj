package com.zzst.action.meeting.message;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.meeting.information.InformationVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.message.MessageVO;

/**
 * ROLE action
 * @author zhangliang
 * Nov 4, 2011 11:24:59 AM
 */
public class MessageAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(MessageAction.class.getName());
	
	private MessageVO mVO = new MessageVO();
	private List<MessageVO> mList = new ArrayList<MessageVO>();
	
	private InformationVO ifVO = new InformationVO();
	private List<InformationVO> ifList = new ArrayList<InformationVO>();
	
	/**
	 * detail a MessageVO
	 * @return
	 */
	public String detail() {
		logger.info("MessageAction		addPost		begin");
		try {
			ifList = ServiceFactory.getInformationService().query(ifVO,null);
			ifVO = ifList.get(0);
//			MeetingDetailVO mdVO = new MeetingDetailVO();
//			mdVO = ServiceFactory.getMeetingDetailService().queryByID(ifVO.getMeetingDetailId());
//			String meetingDetailName = "";
//			meetingDetailName = mdVO.getMeetingName();
//			request.setAttribute("meetingDetailName", meetingDetailName);
		} catch (Exception e) {
			request.setAttribute("info", "获取告警信息异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("PostAction		addPost		end");
		return REQUEST_SUCCESS;
	}

	
	
	public List<InformationVO> getIfList() {
		return ifList;
	}



	public void setIfList(List<InformationVO> ifList) {
		this.ifList = ifList;
	}



	public InformationVO getIfVO() {
		return ifVO;
	}



	public void setIfVO(InformationVO ifVO) {
		this.ifVO = ifVO;
	}



	public List<MessageVO> getMList() {
		return mList;
	}

	public void setMList(List<MessageVO> list) {
		mList = list;
	}

	public MessageVO getMVO() {
		return mVO;
	}

	public void setMVO(MessageVO mvo) {
		mVO = mvo;
	}
	
	

}
