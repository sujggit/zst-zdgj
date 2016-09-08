package com.zzst.meeting.dwr;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.autocompare.histogram.HistogramThread;
import com.zzst.action.meeting.autocompare.histogram.HistogramThreadPoolManager;
import com.zzst.action.meeting.autocompare.histogram.HistogramUtil;
import com.zzst.action.meeting.autocompare.histogram.TestThread;
import com.zzst.action.meeting.autocompare.histogram.VideoCardController;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.meeting.service.comparison.ComparisonReferenceServiceImpl;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;
import com.zzst.model.meeting.comparison.ComparisonVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;
import com.zzst.service.meeting.equipment.EquipmentServiceImpl;
import com.zzst.service.meeting.videoCard.VideoCardServiceImpl;

public class VideoCardDwrMethod {
	private static Logger logger = CbfLogger.getLogger(VideoCardDwrMethod.class.getName());
	//set standard meeting room RGB value
	private String flag="";
	
	public String setSomeOrAllStandardRGB(String meetingRoomIDList){
		String []meetingRoomID=meetingRoomIDList.split(",");
		for(int i=0;i<meetingRoomID.length;i++){
			
			synchronized(this){
				flag=this.setStandardRGB(meetingRoomID[i]);
			}
			
			if(flag.equals("false")){
				continue;
			}
			
		}
		return "true";
		
		
	}
	
	
	
	
	
	
	
	
	public String  setStandardRGB(String meetingRoomID){
		try {
			EquipmentVO equipmentVO = new EquipmentVO();
			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setMeetingRoomID(meetingRoomID);
			equipmentVO.setMeetingRoomVO(meetingRoomVO);
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			List<EquipmentVO> equipList = new EquipmentServiceImpl().query(equipmentVO, null);
			if(equipList == null || equipList.size() <= 0){
				return "false";
			}
			equipmentVO = equipList.get(equipList.size() - 1);
			
			
			VideoCardVO videoCardVO = new VideoCardVO();
			videoCardVO.setEquipmentID(equipmentVO.getEquipmentID());
			List<VideoCardVO> videoCardList = new VideoCardServiceImpl().query(videoCardVO, null);
			if(videoCardList == null || videoCardList.size() <= 0){
				return "false";
			}
			videoCardVO = videoCardList.get(0);
			HistogramUtil histogramUtil = new HistogramUtil();
			VideoCardController  videoCardController = new VideoCardController(equipmentVO.getIp());
			byte[] setCommand = new byte[9];
			setCommand[0]=0x02; //msg type。 0x02:设置视频参数命令
			setCommand[1]=0x55;	//fixed byte
			setCommand[2]=histogramUtil.getHexByte(videoCardVO.getAppraisalTaskNum()); //A6: colorful bar A8:frame mode
			setCommand[3]=histogramUtil.getHexByte(videoCardVO.getShowFormatFlag()); //B0: 1080P60 B1:1080P50 B7:720P60 
			setCommand[4]=histogramUtil.getHexByte(videoCardVO.getOutputModel()); //C0:DVI C1:VGA C2:YPbPr  out
			setCommand[5]=histogramUtil.getHexByte(videoCardVO.getInputModel()); //D0:DVI D1:VGA D2:YPbPr  in
			setCommand[6]=histogramUtil.getHexByte(videoCardVO.getAppraisalModel()); //E0:绝对偏差(彩条) E1:平均偏差(彩条) E2:自标准差(冻结帧) E3:自平均(冻结帧) E4:源标准差(冻结帧) E5:源平均(冻结帧)
			setCommand[7]=(byte)0xF1;// F1 多帧；F0：单帧;
			setCommand[8]=0x00;
			videoCardController.setCommand(setCommand);
			Thread.sleep(HistogramUtil.GET_HISTOGRAM_SLEEP_TIME);
			//视频评价结果请求
			
			byte getByte = 0x00;
			//
			//计算不同分辨率的倍数:
			int multiple = histogramUtil.getPixelMultiple(videoCardVO.getShowFormatFlag());
			int[][] rgbArray = videoCardController.getCommand(getByte, multiple);
			ComparisonReferenceVO comparisonReferenceVO = new ComparisonReferenceVO();
			comparisonReferenceVO.setMeetingRoomID(meetingRoomID);
			StringBuffer buffer = new StringBuffer();
			for(int i=0 ;i<rgbArray[0].length; i++){
				buffer.append(rgbArray[0][i]);
				if(i < rgbArray[0].length-1){
					buffer.append(",");
				}
			}
			comparisonReferenceVO.setR_Pr(buffer.toString());
			buffer = new StringBuffer();
			for(int i=0 ;i<rgbArray[1].length; i++){
				buffer.append(rgbArray[1][i]);
				if(i < rgbArray[1].length-1){
					buffer.append(",");
				}
			}
			comparisonReferenceVO.setG_Y(buffer.toString());
			buffer = new StringBuffer();
			for(int i=0 ;i<rgbArray[2].length; i++){
				buffer.append(rgbArray[2][i]);
				if(i < rgbArray[0].length-1){
					buffer.append(",");
				}
			}
			comparisonReferenceVO.setB_Pb(buffer.toString());
			
			List<ComparisonCriteriaVO> criteriaList = ServiceFactory.getConparisonCriteriaService().query(null, null);
			if(criteriaList == null || criteriaList.size() <= 0){
				return "false";
			}
			ComparisonCriteriaVO  criteriaVO = criteriaList.get(0);
			
			comparisonReferenceVO.setS_R(histogramUtil.getArea(rgbArray[0], criteriaVO.getX_min(), criteriaVO.getX_max()));
			comparisonReferenceVO.setS_G(histogramUtil.getArea(rgbArray[1], criteriaVO.getX_min(), criteriaVO.getX_max()));
			comparisonReferenceVO.setS_B(histogramUtil.getArea(rgbArray[2], criteriaVO.getX_min(), criteriaVO.getX_max()));
			
			ComparisonReferenceVO comparisonReferenceVO_=new ComparisonReferenceVO();
			ArrayList<ComparisonReferenceVO> comparisonReferenceVO_List=new ArrayList<ComparisonReferenceVO>();
			
			comparisonReferenceVO_.setMeetingRoomID(meetingRoomID);
			comparisonReferenceVO_List=ServiceFactory.getConparisonReferenceService().query(comparisonReferenceVO_, null);
			
			if(comparisonReferenceVO_List!=null&&comparisonReferenceVO_List.size()>0){
				ServiceFactory.getConparisonReferenceService().deleteByID(comparisonReferenceVO_List.get(0).getID());
			}
		
			
			new ComparisonReferenceServiceImpl().add(comparisonReferenceVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "true";
	}
	
	
	
	
	public String autoCompare(String meetingDetailId,String VideoCardParameter){
		HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getInstance();
		if(histogramThreadPoolManager.isThreadExisted(meetingDetailId)){
			return "none";
		}
		long time = System.currentTimeMillis();
		//get broadcaster.
		List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailId);
		if(meetingRoomList == null || meetingRoomList.size() <= 0){
			return "noconf";
		}
		ZZOMainStatusVO mainMeetingRoom = null;
		for(int i=0;i<meetingRoomList.size();i++){
			if(meetingRoomList.get(i).getIsSpeaker()==1&&meetingRoomList.get(i).getCascadeRole().equals("none")){
				mainMeetingRoom = meetingRoomList.get(i);
				break;
			}
		}
		if(mainMeetingRoom==null){
			return "nobroadcaster";
		}else{
			//start thread
			//AutoCompareThread 
			//AutoCompareThread autoCompareThread = new AutoCompareThread(meetingDetailId, mainMeetingRoom , meetingRoomList);
			//HistogramThread histogramThread = new HistogramThread(meetingDetailId, mainMeetingRoom , meetingRoomList);
			//histogramThread.start();
			//删除有关本次会议的所有会场
			try {
				ServiceFactory.getConparisonService().deleteByMeetingDetailID(meetingDetailId, null);

				//初始化所有会场
				for(ZZOMainStatusVO branchMainstatusVO : meetingRoomList){
					try{
					if(branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)){
						addInitResult(branchMainstatusVO, meetingDetailId, VideoCardParameter);
					}
					}catch(Exception e){}
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			//HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getInstance();
			boolean isSuccessful = histogramThreadPoolManager.pollPts(meetingDetailId,VideoCardParameter, mainMeetingRoom , meetingRoomList);
			if(!isSuccessful){
				return "none";
			}
		}
		logger.debug("点名	dwr	时长："+(System.currentTimeMillis()-time));
		return "success";
	}
	
	/**
	 * stop auto compare thread.
	 * @param meetingDetailId
	 * @return
	 */
	public String stopAutoCompare(String meetingDetailId){
		HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getInstance();
		boolean isSuccessfulVideo = histogramThreadPoolManager.stopPolling(meetingDetailId);
		boolean isSuccessfulVoice = histogramThreadPoolManager.stopVoicePolling(meetingDetailId);
		if(!isSuccessfulVideo&&!isSuccessfulVoice){
			return "none";
		}
		return "success";
	}
	/*测试tzl*/
	public String getCompareRGB(String ip){
		boolean flag=true;
		System.out.println("测试+"+ip+"+线程开始/////////////////////////////////////////////////////////");
		TestThread tr=new TestThread(ip);
		while(flag){
		tr.run();
		}
		System.out.println("测试线程结束/////////////////////////////////////////////////////////");
		return "success";
	}
	
	
	public String getThreadStatus(String meetingDetailId){
		HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getInstance();
		HistogramThread histogramThread= histogramThreadPoolManager.getConfPollMap().get(meetingDetailId);
		
		if(histogramThread!=null){
			 boolean isSuccessful =histogramThread.isContinued();
			 if(!isSuccessful){
				return "none";
			}
			return "success";
		}
			
		return "none";
		}
		
	
	public int  getComparisonProcess(String meetingDetailId){
		ArrayList <ComparisonVO> comparisonVOList=new ArrayList<ComparisonVO>();
	    ComparisonVO	comparisonVO=new ComparisonVO();
		comparisonVO.setMeetingDetailID(meetingDetailId);
		try {
			comparisonVOList=ServiceFactory.getConparisonService().query(comparisonVO, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int epCount = 0;
		int validCount = 0;
		int realEpCount = 0;
		List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailId);
		if(meetingRoomList == null || meetingRoomList.size() <= 0){
			return 0;
		}
		
		
			ZZOMainStatusVO mainMeetingRoom = new ZZOMainStatusVO();
			for(int i=0;i<meetingRoomList.size();i++){
				if(meetingRoomList.get(i).getCascadeRole().equals("none")){
					if(meetingRoomList.get(i).getIsSpeaker()==1){
						mainMeetingRoom = meetingRoomList.get(i);
					}else{
						realEpCount++;
					}
				}
			}
		
		
		if(comparisonVOList!=null&&comparisonVOList.size()>0){
			for(ComparisonVO oldCom : comparisonVOList){
				if(oldCom.getResult() > 0){
					validCount++;
				}
				epCount++;
			}
			HistogramUtil hu=new HistogramUtil();
			int percent=hu.getPercent(validCount, epCount);
			if(validCount == epCount && epCount == realEpCount){
				return percent;
			}else{
				HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getInstance();
				if(histogramThreadPoolManager.isThreadExisted(meetingDetailId)){
					return percent;
				}else{
					return 0;
				}
			}
			//return percent;
		}else{
			return 0;
		}
	}
	
	public String isTerminalHaveVideoCard(String meetingRoomId){
		EquipmentVO equipmentVO=new EquipmentVO();	
		MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
		ArrayList<EquipmentVO> equipmentVOList=new ArrayList<EquipmentVO>();
		
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
		try {
			meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(meetingRoomId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		equipmentVO.setMeetingRoomVO(meetingRoomVO);
		
		try {
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(equipmentVOList!=null&&equipmentVOList.size()>0){
			return "yes";
		}
		else{
			return "no";
		}
		
		}
		
	public ComparisonVO addInitResult(ZZOMainStatusVO branchMainstatusVO, String meetingDetailId, String VideoCardParameter){
		//获取分会场
		ComparisonVO comparisonVO = new ComparisonVO();
		try {
			EquipmentVO branchEndPointVO = new EquipmentVO();
		branchEndPointVO.setIp(branchMainstatusVO.getMcu_participant_ip());
		branchEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
		List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(branchEndPointVO, null);
		if(equipList == null || equipList.size() <= 0){
			return null;
		}
		branchEndPointVO = equipList.get(0);
		
		
		//保存
		Timestamp now = new Timestamp(System.currentTimeMillis());
		//comparisonVO.setCompDetailID(comparisonDetailVO.getID());
		comparisonVO.setMeetingRoomID(branchEndPointVO.getMeetingRoomVO().getMeetingRoomID());
		comparisonVO.setMeetingDetailID(meetingDetailId);
		comparisonVO.setUpdateTime(now);
		comparisonVO.setStatus(Integer.parseInt(VideoCardParameter));
		if(branchMainstatusVO.getConnectStatus() == null || branchMainstatusVO.getConnectStatus().intValue() == MCUConfig.DISCONNECTED_STATUS){
			comparisonVO.setResult(HistogramUtil.ISNOTCONNECTED_RESULT);
			
			//add comparison detail
			ComparisonDetailVO comparisonDetailVO = new ComparisonDetailVO();
			comparisonDetailVO.setUpdateTime(now);
			HistogramThread histogramUtil = new HistogramThread();
			histogramUtil.getEqStatusResult(branchMainstatusVO.getMcu_participant_ip(), comparisonVO, comparisonDetailVO, true);
			comparisonDetailVO = ServiceFactory.getConparisonDetailService().add(comparisonDetailVO);
			comparisonVO.setCompDetailID(comparisonDetailVO.getID());
		}
		
		ServiceFactory.getConparisonService().add(comparisonVO);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return comparisonVO;
	}
	public ComparisonVO replaceDisconnResult(ZZOMainStatusVO branchMainstatusVO, String meetingDetailId, String VideoCardParameter){
		//获取分会场
		ComparisonVO comparisonVO = new ComparisonVO();
		try {
			EquipmentVO branchEndPointVO = new EquipmentVO();
			branchEndPointVO.setIp(branchMainstatusVO.getMcu_participant_ip());
			branchEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(branchEndPointVO, null);
			if(equipList == null || equipList.size() <= 0){
				return null;
			}
			branchEndPointVO = equipList.get(0);
			
			
			//保存
			Timestamp now = new Timestamp(System.currentTimeMillis());
			//comparisonVO.setCompDetailID(comparisonDetailVO.getID());
			comparisonVO.setMeetingRoomID(branchEndPointVO.getMeetingRoomVO().getMeetingRoomID());
			comparisonVO.setMeetingDetailID(meetingDetailId);
			comparisonVO.setUpdateTime(now);
			comparisonVO.setStatus(Integer.parseInt(VideoCardParameter));
			comparisonVO.setResult(HistogramUtil.ISNOTCONNECTED_RESULT);
			
			//add comparison detail
			ComparisonDetailVO comparisonDetailVO = new ComparisonDetailVO();
			comparisonDetailVO.setUpdateTime(now);
			HistogramThread histogramUtil = new HistogramThread();
			histogramUtil.getEqStatusResult(branchMainstatusVO.getMcu_participant_ip(), comparisonVO, comparisonDetailVO, true);
			comparisonDetailVO = ServiceFactory.getConparisonDetailService().add(comparisonDetailVO);
			
			comparisonVO.setCompDetailID(comparisonDetailVO.getID());
			ComparisonVO com = new ComparisonVO();
			com.setMeetingDetailID(meetingDetailId);
			com.setMeetingRoomID(branchEndPointVO.getMeetingRoomVO().getMeetingRoomID());
			List<ComparisonVO> tempComparisonList = ServiceFactory.getConparisonService().query(com, null);
			if(tempComparisonList != null && tempComparisonList.size() > 0){
				comparisonVO.setID(tempComparisonList.get(0).getID());
			}
			ServiceFactory.getConparisonService().replace(comparisonVO, null);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return comparisonVO;
	}
		
}
