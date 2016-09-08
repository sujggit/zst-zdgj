package com.zzst.action.meeting.cost;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.file.FileAction;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.cost.MeetingDetailCostService;
import com.zzst.service.meeting.cost.MeetingDetailCostServiceImpl;
import com.zzst.service.meeting.dictionary.DictionaryService;
import com.zzst.service.meeting.dictionary.DictionaryServiceImpl;

public class MeetingCostAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(MeetingCostAction.class.getName());
	
	private DictionaryVO dictionaryVO = new DictionaryVO();
	private List<DictionaryVO> dList = new ArrayList<DictionaryVO>();
	private List<DictionaryVO> costList = new ArrayList<DictionaryVO>();
	private MeetingDetailCostVO meetingDetailCostVO = new MeetingDetailCostVO();
	private List<MeetingDetailCostVO> mcList = new ArrayList<MeetingDetailCostVO>();
	
	public String meetingCostSettingBefore(){
		logger.info("MeetingCostAction		meetingCostSettingBefore	begin");
		dictionaryVO.setDicType(DictionaryEnum.MEETINGCOST);
		DictionaryService dictionaryService = new DictionaryServiceImpl();
		try {
			costList = dictionaryService.query(dictionaryVO, null);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
		logger.info("MeetingCostAction		meetingCostSettingBefore	end");
		return REQUEST_SUCCESS;
	}

	public String meetingCostList(){
		logger.info("MeetingCostAction		meetingCostList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		MeetingDetailCostService meetingDetailCostService = new MeetingDetailCostServiceImpl();
		try {
			mcList = meetingDetailCostService.queryMeetingDetail(meetingDetailCostVO, pSplittor.getPControler());
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
		logger.info("MeetingCostAction		meetingCostList	end");
		return REQUEST_SUCCESS;
	}

	public String addMeetingCostBefore(){
		logger.info("MeetingCostAction		addMeetingCostBefore	begin");
		String meetingName = request.getParameter("meetingName");
		dictionaryVO.setDicType(DictionaryEnum.MEETINGCOST);
		DictionaryService dictionaryService = new DictionaryServiceImpl();
		try {
			costList = dictionaryService.query(dictionaryVO, null);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
		request.setAttribute("meetingName", meetingName);
		logger.info("MeetingCostAction		addMeetingCostBefore	end");
		return REQUEST_SUCCESS;
	}
	
	public String modifyMeetingCostBefore(){
		logger.info("MeetingCostAction		modifyMeetingCostBefore	begin");
		String meetingName = request.getParameter("meetingName");
		String meetingDetailId = request.getParameter("meetingDetailId");
		meetingDetailCostVO.setMeetingDetailId(meetingDetailId);
		MeetingDetailCostService meetingDetailCostService = new MeetingDetailCostServiceImpl();
		try {
			mcList = meetingDetailCostService.query(meetingDetailCostVO, null);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
		request.setAttribute("meetingName", meetingName);
		logger.info("MeetingCostAction		modifyMeetingCostBefore	end");
		return REQUEST_SUCCESS;
	}
	
	public String meetingCostDetail(){
		logger.info("MeetingCostAction		meetingCostDetail	begin");
		String meetingName = request.getParameter("meetingName");
		String meetingDetailId = request.getParameter("meetingDetailId");
		meetingDetailCostVO.setMeetingDetailId(meetingDetailId);
		MeetingDetailCostService meetingDetailCostService = new MeetingDetailCostServiceImpl();
		try {
			mcList = meetingDetailCostService.query(meetingDetailCostVO, null);
		} catch (Exception e) {
			logger.error(e.getStackTrace());
			e.printStackTrace();
		}
		UserVO userVO = new UserVO();
		userVO.setName(mcList.get(0).getUserVO().getName());
		meetingDetailCostVO.setUserVO(userVO);
		meetingDetailCostVO.setCreateTime(mcList.get(0).getCreateTime());
		request.setAttribute("meetingName", meetingName);
		logger.info("MeetingCostAction		meetingCostDetail	end");
		return REQUEST_SUCCESS;
	}
	
	public DictionaryVO getDictionaryVO() {
		return dictionaryVO;
	}

	public void setDictionaryVO(DictionaryVO dictionaryVO) {
		this.dictionaryVO = dictionaryVO;
	}

	public List<DictionaryVO> getdList() {
		return dList;
	}

	public void setdList(List<DictionaryVO> dList) {
		this.dList = dList;
	}

	public MeetingDetailCostVO getMeetingDetailCostVO() {
		return meetingDetailCostVO;
	}

	public void setMeetingDetailCostVO(MeetingDetailCostVO meetingDetailCostVO) {
		this.meetingDetailCostVO = meetingDetailCostVO;
	}

	public List<MeetingDetailCostVO> getMcList() {
		return mcList;
	}

	public void setMcList(List<MeetingDetailCostVO> mcList) {
		this.mcList = mcList;
	}

	public void setCostList(List<DictionaryVO> costList) {
		this.costList = costList;
	}

	public List<DictionaryVO> getCostList() {
		return costList;
	}
	
}
