package com.zzst.action.meeting.autocompare;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Request;

import com.cbf.db.PageController;
import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;

public class SingleVideoCardCompareAction extends CjfAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = CjfLogger.getLogger(SingleVideoCardCompareAction.class.getName());
	private ComparisonReferenceVO comparisonReferenceVO;
	
	private ArrayList<ComparisonReferenceVO>  comparisonReferenceVOList =new ArrayList<ComparisonReferenceVO>();
	private ArrayList<MeetingRoomVO> meetingRoomList;
	private MeetingRoomVO meetingRoomVO;
	private ArrayList<EquipmentVO> equipmentVOList=new ArrayList<EquipmentVO>();
	//private MeetingDetailVO meetingDetailVO;
	private String meetingRoomID;
	private String meetingRoomName;
	private int referencedRoomCount;
	private int unReferencedRoomCount;
	//查询标准rbg值会场列表
	/**
	 * modified by wangle. remove rooms reference that don't exist. 2013-7-18
	 */
	public String queryCompareMeeting(){
		logger.info("SingleVideoCardCompareAction	queryCompareMeeting	begin");		
		try{
			//从设备表里查询所有比对卡的roomID；根据roomID
			EquipmentVO equipmentVO=new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
			ComparisonReferenceVO comparisonReferenceVO_=new ComparisonReferenceVO();
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			//referencedRoomCount=ServiceFactory.getConparisonReferenceService().query(comparisonReferenceVO_, null).size();
			
			if(meetingRoomID!=null&&!meetingRoomID.equals("")){
				comparisonReferenceVO_.setMeetingRoomID(meetingRoomID);
			}		
			comparisonReferenceVOList=ServiceFactory.getConparisonReferenceService().query(comparisonReferenceVO_, this.getPageControler());
			//ArrayList<ComparisonReferenceVO> deletedList = new ArrayList<ComparisonReferenceVO>();
			for(int i=0;i<comparisonReferenceVOList.size();i++){
				comparisonReferenceVO=comparisonReferenceVOList.get(i);
				MeetingRoomVO tempMeetingRoomVO = ServiceFactory.getMeetingRoomService().queryByID(comparisonReferenceVO.getMeetingRoomID());
				if(tempMeetingRoomVO == null || StringUtils.isNullOrBlank(tempMeetingRoomVO.getMeetingRoomName())){
					//deletedList.add(comparisonReferenceVO);
					continue;
				}
				comparisonReferenceVO.setMeetingRoomName(tempMeetingRoomVO.getMeetingRoomName());			
			
				//根据meetingRoomID获得会议室下的终端ip和比对卡ip
				equipmentVO=new EquipmentVO();
				meetingRoomVO=new MeetingRoomVO();
				meetingRoomVO.setMeetingRoomID(comparisonReferenceVO.getMeetingRoomID());
				equipmentVO.setMeetingRoomVO(meetingRoomVO);
				equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
				
			   ArrayList<EquipmentVO> equipmentList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			   if(equipmentList!=null&&equipmentList.size()>0){
					equipmentVO=equipmentList.get(0);
					comparisonReferenceVO.setVideoCardIp(equipmentVO.getIp());
			   }
			   equipmentVO=new EquipmentVO();
				
				equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				equipmentVO.setMeetingRoomVO(meetingRoomVO);
			   ArrayList<EquipmentVO> terminalList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			
			   if(terminalList!=null&&terminalList.size()>0){
					equipmentVO=terminalList.get(0);
					comparisonReferenceVO.setTerminalIp(equipmentVO.getIp());
				}
			}
			/*if(deletedList.size() > 0){
				comparisonReferenceVOList.removeAll(deletedList);
				ArrayList<EquipmentVO> delEquipList = new ArrayList<EquipmentVO>();
				for(EquipmentVO tempEquipmentVO : equipmentVOList){
					for(ComparisonReferenceVO delComparisonReferenceVO : deletedList){
						if(tempEquipmentVO.getMeetingRoomVO().getMeetingRoomID().equals(delComparisonReferenceVO.getMeetingRoomID())){
							delEquipList.add(tempEquipmentVO);
							break;
						}
					}
				}
				if(delEquipList.size() > 0){
					equipmentVOList.removeAll(delEquipList);
				}
			}*/
			referencedRoomCount = comparisonReferenceVOList.size();
			unReferencedRoomCount=equipmentVOList.size()-referencedRoomCount;
			//unReferencedRoomCount=equipmentVOList.size()-referencedRoomCount;
			
		}catch(Exception e){
			logger.error("SingleVideoCardCompareAction	queryCompareMeeting	error:"+e.getMessage());
		}
		logger.info("SingleVideoCardCompareAction	queryCompareMeeting	end");
		return SUCCESS;
	}

	
//获得未标定会场
	
	public String queryUnReferencedMeeting(){
		logger.info("SingleVideoCardCompareAction	queryUnReferencedMeeting	begin");		
		try{
			//获得由比对卡在使用的会议室
			EquipmentVO equipmentVO=new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
			ComparisonReferenceVO comparisonReferenceVO_=new ComparisonReferenceVO();			
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO, null);			
			comparisonReferenceVOList=ServiceFactory.getConparisonReferenceService().query(comparisonReferenceVO_, null);
			 
			
			//去除已标定的比对卡
			for(int j=0;j<comparisonReferenceVOList.size();j++ ){
				
				comparisonReferenceVO_=comparisonReferenceVOList.get(j);
				int equipmentSize=equipmentVOList.size();
				for(int i=0;i<equipmentSize;i++){
					equipmentVO=equipmentVOList.get(i);			
					if(equipmentVO.getMeetingRoomVO().getMeetingRoomID().equals(comparisonReferenceVO_.getMeetingRoomID())){
						equipmentVOList.remove(equipmentVO);
						equipmentSize--;
						i--;
						continue;
						}
					
				}

			
				
			}
			
			comparisonReferenceVOList=new ArrayList<ComparisonReferenceVO>();
			ArrayList<EquipmentVO> equipmentlist=	new ArrayList<EquipmentVO>();
			EquipmentVO equipmentVO_=new EquipmentVO();
			MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
			for(int s=0;s<equipmentVOList.size();s++){
				equipmentVO=equipmentVOList.get(s);
				comparisonReferenceVO_=new ComparisonReferenceVO();
				comparisonReferenceVO_.setMeetingRoomID(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				comparisonReferenceVO_.setVideoCardIp(equipmentVO.getIp());
				comparisonReferenceVO_.setMeetingRoomName(equipmentVO.getMeetingRoomVO().getMeetingRoomName());
			
				
				meetingRoomVO.setMeetingRoomID(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				equipmentVO_.setMeetingRoomVO(meetingRoomVO);
				equipmentVO_.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
		
				equipmentlist= ServiceFactory.getEquipmentService().query(equipmentVO_, null);
				  if(equipmentlist!=null&&equipmentlist.size()>0){
				 comparisonReferenceVO_.setTerminalIp(equipmentlist.get(0).getIp());}
				 //更新时间 ，更新人
				  
				  comparisonReferenceVO_.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				  UserVO vo = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
				  comparisonReferenceVO_.setUpdateUserID(vo.getUserID());
				
				  comparisonReferenceVOList.add(comparisonReferenceVO_);
			}
			
			
			
		}catch(Exception e){
			logger.error("SingleVideoCardCompareAction	queryUnReferencedMeeting	error:"+e.getMessage());
		}
		logger.info("SingleVideoCardCompareAction	queryUnReferencedMeeting	end");
		return SUCCESS;
	}

	
	
	
	
	public String singleCompareCriteria(){
		logger.info("SingleVideoCardCompareAction	singleCompareCriteria	begin");		
		try{
			
			comparisonReferenceVO=ServiceFactory.getConparisonReferenceService().queryByID(comparisonReferenceVO.getID());
	
		}catch(Exception e){
			logger.error("SingleVideoCardCompareAction	singleCompareCriteria	error:"+e.getMessage());
		}
		logger.info("SingleVideoCardCompareAction	singleCompareCriteria	end");
		return SUCCESS;
	}

	
	

	public String SingleCompareCriteriaModify(){
		logger.info("VideoCardCompareAction	compareCriteriaModify	begin");		
		try{
			
			ServiceFactory.getConparisonReferenceService().modify(comparisonReferenceVO);
			
		}catch(Exception e){
			logger.error("VideoCardCompareAction	compareCriteriaModify	error:"+e.getMessage());
		}
		logger.info("VideoCardCompareAction	compareCriteriaModify	end");
		return SUCCESS;
	}



	
	public String SingleCompareCriteriaAdd(){
		logger.info("VideoCardCompareAction	SingleCompareCriteriaAdd	begin");		
		try{
			ComparisonReferenceVO comparisonReferenceVO_=new ComparisonReferenceVO();
			comparisonReferenceVO_.setMeetingRoomID(comparisonReferenceVO.getMeetingRoomID());
			comparisonReferenceVO_.setMeetingRoomName(comparisonReferenceVO.getMeetingRoomName());
			comparisonReferenceVOList=ServiceFactory.getConparisonReferenceService().query(comparisonReferenceVO_, null);
			
			if(comparisonReferenceVOList!=null&&comparisonReferenceVOList.size()>0){
				return SUCCESS;
			}
			ServiceFactory.getConparisonReferenceService().add(comparisonReferenceVO);
			
		}catch(Exception e){
			logger.error("VideoCardCompareAction	SingleCompareCriteriaAdd	error:"+e.getMessage());
		}
		logger.info("VideoCardCompareAction	SingleCompareCriteriaAdd	end");
		return SUCCESS;
	}

	
	
	
	public String SingleCompareCriteriaDel(){
		logger.info("VideoCardCompareAction	SingleCompareCriteriaDel	begin");		
		try{
			
			ServiceFactory.getConparisonReferenceService().deleteByID(comparisonReferenceVO.getID());
			
		}catch(Exception e){
			logger.error("VideoCardCompareAction	SingleCompareCriteriaDel	error:"+e.getMessage());
		}
		logger.info("VideoCardCompareAction	SingleCompareCriteriaDel	end");
		return SUCCESS;
	}





	public ComparisonReferenceVO getComparisonReferenceVO() {
		return comparisonReferenceVO;
	}






	public void setComparisonReferenceVO(ComparisonReferenceVO comparisonReferenceVO) {
		this.comparisonReferenceVO = comparisonReferenceVO;
	}






	public ArrayList<ComparisonReferenceVO> getComparisonReferenceVOList() {
		return comparisonReferenceVOList;
	}






	public void setComparisonReferenceVOList(
			ArrayList<ComparisonReferenceVO> comparisonReferenceVOList) {
		this.comparisonReferenceVOList = comparisonReferenceVOList;
	}






	public ArrayList<MeetingRoomVO> getMeetingRoomList() {
		return meetingRoomList;
	}






	public void setMeetingRoomList(ArrayList<MeetingRoomVO> meetingRoomList) {
		this.meetingRoomList = meetingRoomList;
	}


	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}


	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}


	public String getMeetingRoomID() {
		return meetingRoomID;
	}


	public void setMeetingRoomID(String meetingRoomID) {
		this.meetingRoomID = meetingRoomID;
	}


	public String getMeetingRoomName() {
		return meetingRoomName;
	}


	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}


	public int getReferencedRoomCount() {
		return referencedRoomCount;
	}


	public void setReferencedRoomCount(int referencedRoomCount) {
		this.referencedRoomCount = referencedRoomCount;
	}


	public int getUnReferencedRoomCount() {
		return unReferencedRoomCount;
	}


	public void setUnReferencedRoomCount(int unReferencedRoomCount) {
		this.unReferencedRoomCount = unReferencedRoomCount;
	}


	public ArrayList<EquipmentVO> getEquipmentVOList() {
		return equipmentVOList;
	}


	public void setEquipmentVOList(ArrayList<EquipmentVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}


	
}
