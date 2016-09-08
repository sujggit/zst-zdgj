package com.zzst.action.meeting.autocompare.histogram;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.McuControlDwr;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOPtsChannel;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.meeting.dwr.VideoCardDwrMethod;
import com.zzst.meeting.service.comparison.ComparisonReferenceServiceImpl;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;
import com.zzst.model.meeting.comparison.ComparisonVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;
import com.zzst.service.meeting.videoCard.VideoCardServiceImpl;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;

/**
 * 视频比对
 * @author ryan
 *
 */
public class HistogramThread extends Thread{
	
	private static Logger logger = CjfLogger.getLogger(HistogramThread.class.getName());
	private String meetingDetailId;
	private String VideoCardParameter;
	private ZZOMainStatusVO mainStatusVO;
	private List<ZZOMainStatusVO> mainStatusVOList;
	
	private EquipmentVO mainEndPointVO;
	private EquipmentVO mainCenterControlVO;
	private EquipmentVO mainVideoCardInfoVO;
	
	private EquipmentVO branchEndPointVO;
	private EquipmentVO branchCenterControlVO;
	private EquipmentVO branchVideoCardVO;
	
	
	private int x_min;
	private int x_max;
	
	private boolean isContinued;
	public HistogramThread(){
		
	}
	public HistogramThread(String meetingDetailId,String VideoCardParameter, ZZOMainStatusVO mainStatusVO, List<ZZOMainStatusVO> mainStatusVOList){
		this.meetingDetailId = meetingDetailId;
		this.mainStatusVO = mainStatusVO;
		this.mainStatusVOList = mainStatusVOList;
		this.VideoCardParameter=VideoCardParameter;
		
		try {
			List<ComparisonCriteriaVO> criteriaList = ServiceFactory.getConparisonCriteriaService().query(null, null);
			if(criteriaList != null && criteriaList.size() > 0){
				ComparisonCriteriaVO  criteriaVO = criteriaList.get(0);
				x_min = criteriaVO.getX_min();
				x_max = criteriaVO.getX_max();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isContinued = true;
	}
	
	/**
	 *auto compare process.
	 */
	public void run(){
		long startTime = System.currentTimeMillis();
		try {
			ComparisonVO com = new ComparisonVO();
			com.setMeetingDetailID(this.meetingDetailId);
			List<ComparisonVO> tempComparisonList = ServiceFactory.getConparisonService().query(com, null);
			//获取主会场
			EquipmentVO mainEndPointVO = new EquipmentVO();
			mainEndPointVO.setIp(mainStatusVO.getMcu_participant_ip());
			mainEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(mainEndPointVO, null);
			if(equipList == null || equipList.size() <= 0){
				logger.debug("无设备	结束");
				return;
			}
			mainEndPointVO = equipList.get(0);
			
			//主会场比对卡发送彩条
			mainVideoCardInfoVO = new EquipmentVO();
			mainVideoCardInfoVO.setMeetingRoomVO(mainEndPointVO.getMeetingRoomVO());
			mainVideoCardInfoVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipList = ServiceFactory.getEquipmentService().query(mainVideoCardInfoVO, null);
			if(equipList == null || equipList.size() <= 0){
				logger.debug("无设备	结束");
				return;
			}
			mainVideoCardInfoVO = equipList.get(0);
			
			HistogramUtil histogramUtil = new HistogramUtil();
			ComparisonVO comparisonVO = null;
			ComparisonDetailVO comparisonDetailVO = null;
			
			
			
			//循环选定一个在线分会场
			for(ZZOMainStatusVO branchMainstatusVO : mainStatusVOList){
				long roomStartTime = System.currentTimeMillis();
				if(!isContinued){
					logger.debug("break	");
					break;
				}
				
				if(branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)
						&& branchMainstatusVO.getConnectStatus() != null && branchMainstatusVO.getConnectStatus().intValue() != MCUConfig.DISCONNECTED_STATUS){
					try{
						comparisonVO = new ComparisonVO();
						comparisonDetailVO = new ComparisonDetailVO();
						//从中控获取设备状态，并作分析
						boolean isContinuedTemp = getEqStatusResult(branchMainstatusVO.getMcu_participant_ip(), comparisonVO, comparisonDetailVO, true);
						long equipmentTime = System.currentTimeMillis()-roomStartTime;
						logger.debug("提取中控设备状态		执行时长："+equipmentTime);
						
						if(!isContinuedTemp){
							comparisonVO.setResult(HistogramUtil.BAD_RESULT);
						}else{
							//主会场到分会场图像的比对流程
							try{
								comparisonDetailVO = downVideoCompare(branchMainstatusVO.getMcu_participant_ip(), comparisonDetailVO);
								comparisonVO.setDownVideoQuality(histogramUtil.getComprehensiveResult(comparisonDetailVO.getS_R_result(), comparisonDetailVO.getS_G_result(), comparisonDetailVO.getS_B_result()));
							}catch(Exception e){
								comparisonVO.setDownVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
							}
							
							long roomTime = System.currentTimeMillis()-roomStartTime-equipmentTime;
							logger.debug("主会场到分会场图像的比对流程		执行时长："+roomTime);
							
							if(!isContinued){
								logger.debug("break	");
								break;
							}
							
							//分会场到主会场图像的比对流程
							try{
								comparisonDetailVO = upVideoCompare(branchMainstatusVO, comparisonDetailVO);
								comparisonVO.setUpVideoQuality(histogramUtil.getComprehensiveResult(comparisonDetailVO.getUplinkS_R_result(), comparisonDetailVO.getUplinkS_G_result(), comparisonDetailVO.getUplinkS_B_result()));
							}catch(Exception e){
								comparisonVO.setUpVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
							}
							long room2Time = System.currentTimeMillis()-roomStartTime-equipmentTime-roomTime;
							logger.debug("主会场到分会场图像的比对流程		执行时长："+room2Time);
							
							if(!isContinued){
								logger.debug("break	");
								break;
							}
							
							comparisonVO.setResult(histogramUtil.getResult(new int[]{comparisonVO.getDownVideoQuality(), comparisonVO.getUpVideoQuality()}, null));
							
							//获取分会场终端当前时间的丢包率和帧率
							comparisonVO = getPtsChannel(branchMainstatusVO, comparisonVO);
							long room3Time = System.currentTimeMillis()-roomStartTime-equipmentTime-roomTime-room2Time;
							logger.debug("获取分会场终端当前时间的丢包率和帧率		执行时长："+room3Time);
							
						}
						if(!isContinued){
							logger.debug("break	");
							break;
						}
					}catch (Exception e) {
						comparisonVO.setResult(HistogramUtil.BAD_RESULT);
						//description field is used to record equipment status information.
						//comparisonVO.setDescription(e.getMessage());
						logger.error(e.getMessage());
					}
					
					//保存
					Timestamp now = new Timestamp(System.currentTimeMillis());
					comparisonDetailVO.setUpdateTime(now);
					comparisonDetailVO = ServiceFactory.getConparisonDetailService().add(comparisonDetailVO);
					//comparisonVO.setMeetingRoomName(branchMainstatusVO.getMcu_participant_name());
					//comparisonVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
					comparisonVO.setCompDetailID(comparisonDetailVO.getID());
					comparisonVO.setMeetingRoomID(branchEndPointVO.getMeetingRoomVO().getMeetingRoomID());
					comparisonVO.setMeetingDetailID(this.meetingDetailId);
					comparisonVO.setUpdateTime(now);
					comparisonVO.setStatus(Integer.parseInt(VideoCardParameter));
					
					
					 //UserVO vo = (UserVO)this..getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
					//comparisonReferenceVO_.setUpdateUserID(vo.getUserID());
					//comparisonVO.setUpdateUserID(updateUserID);
					//音视频 视频 
					for(ComparisonVO oldComparisonVO : tempComparisonList){
						if(oldComparisonVO.getMeetingRoomID().equals(comparisonVO.getMeetingRoomID())){
							comparisonVO.setID(oldComparisonVO.getID());
						}
					}
					ServiceFactory.getConparisonService().replace(comparisonVO, null);
				}else{
					//handler disconnect participant when polling.
					if(branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)
						&& (branchMainstatusVO.getConnectStatus() == null || branchMainstatusVO.getConnectStatus().intValue() == MCUConfig.DISCONNECTED_STATUS)){
						new VideoCardDwrMethod().replaceDisconnResult(branchMainstatusVO, this.meetingDetailId, VideoCardParameter);
					}
				}
				logger.debug("点名	"+branchMainstatusVO.getAliasName()+"("+branchMainstatusVO.getMcu_participant_ip()+")	执行时长："+(System.currentTimeMillis()-roomStartTime));
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		//remove thread cache.
		HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getInstance();
		if(histogramThreadPoolManager != null){
			histogramThreadPoolManager.removeInvalidPolling(this.meetingDetailId);
		}
		logger.debug("点名	全部完成		执行时长："+(System.currentTimeMillis()-startTime));
	}
	/**
	 * 主会场到分会场图像的比对流程
	 * @param endpointIp
	 * @return
	 * @throws Exception
	 */
	private ComparisonDetailVO downVideoCompare(String endpointIp, ComparisonDetailVO comparisonDetailVO){
		try{
			
			//获取分会场
			branchEndPointVO = new EquipmentVO();
			branchEndPointVO.setIp(endpointIp);
			branchEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(branchEndPointVO, null);
			if(equipList == null || equipList.size() <= 0){
				return comparisonDetailVO;
			}
			branchEndPointVO = equipList.get(0);
			
			//视频评价结果请求
			branchVideoCardVO = new EquipmentVO();
			branchVideoCardVO.setMeetingRoomVO(branchEndPointVO.getMeetingRoomVO());
			branchVideoCardVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipList = ServiceFactory.getEquipmentService().query(branchVideoCardVO, null);
			if(equipList == null || equipList.size() <= 0){
				return comparisonDetailVO;
			}
			branchVideoCardVO = equipList.get(0);
			
			VideoCardVO videoCardVO = new VideoCardVO();
			videoCardVO.setEquipmentID(branchVideoCardVO.getEquipmentID());
			List<VideoCardVO> videoCardList = new VideoCardServiceImpl().query(videoCardVO, null);
			if(videoCardList == null || videoCardList.size() <= 0){
				return comparisonDetailVO;
			}
			videoCardVO = videoCardList.get(0);
			//get MASTER  meeting room comparision reference 
			ComparisonReferenceVO comparisonReferenceVO = new ComparisonReferenceVO();
			comparisonReferenceVO.setMeetingRoomID(mainVideoCardInfoVO.getMeetingRoomVO().getMeetingRoomID());
			List<ComparisonReferenceVO> referenceList = new ComparisonReferenceServiceImpl().query(comparisonReferenceVO, null);
			if(referenceList == null || referenceList.size() <= 0){
				return comparisonDetailVO;
			}
			
		
			comparisonReferenceVO = referenceList.get(0);
			HistogramUtil util = new HistogramUtil();
			int[][] rgbArray = util.getRGBArea(branchVideoCardVO.getIp(), videoCardVO);
			comparisonDetailVO.setR_Pr(util.getRGBAssembly(rgbArray[0]));
			comparisonDetailVO.setG_Y(util.getRGBAssembly(rgbArray[1]));
			comparisonDetailVO.setB_Pb(util.getRGBAssembly(rgbArray[2]));
			comparisonDetailVO.setS_R(util.getArea(rgbArray[0], x_min, x_max));
			comparisonDetailVO.setS_G(util.getArea(rgbArray[1], x_min, x_max));
			comparisonDetailVO.setS_B(util.getArea(rgbArray[2], x_min, x_max));
			comparisonDetailVO.setS_R_gap(util.getAreaGap(comparisonDetailVO.getS_R(), comparisonReferenceVO.getS_R()));
			comparisonDetailVO.setS_G_gap(util.getAreaGap(comparisonDetailVO.getS_G(), comparisonReferenceVO.getS_G()));
			comparisonDetailVO.setS_B_gap(util.getAreaGap(comparisonDetailVO.getS_B(), comparisonReferenceVO.getS_B()));
			comparisonDetailVO.setS_R_result(util.getEvaluateResult(comparisonDetailVO.getS_R_gap(), HistogramUtil.RED_VALUE));
			comparisonDetailVO.setS_G_result(util.getEvaluateResult(comparisonDetailVO.getS_G_gap(), HistogramUtil.GREEN_VALUE));
			comparisonDetailVO.setS_B_result(util.getEvaluateResult(comparisonDetailVO.getS_B_gap(), HistogramUtil.BLUE_VALUE));
			HistogramUtil histogramUtil = new HistogramUtil();
			int result = histogramUtil.getComprehensiveResult(comparisonDetailVO.getS_R_result(), comparisonDetailVO.getS_G_result(), comparisonDetailVO.getS_B_result());
			if(result == HistogramUtil.BAD_RESULT || result == HistogramUtil.OK_RESULT){
//				rgbArray = util.getRGBArea(branchVideoCardVO.getIp(), videoCardVO);
//				comparisonDetailVO.setR_Pr(util.getRGBAssembly(rgbArray[0]));
//				comparisonDetailVO.setG_Y(util.getRGBAssembly(rgbArray[1]));
//				comparisonDetailVO.setB_Pb(util.getRGBAssembly(rgbArray[2]));
//				comparisonDetailVO.setS_R(util.getArea(rgbArray[0], x_min, x_max));
//				comparisonDetailVO.setS_G(util.getArea(rgbArray[1], x_min, x_max));
//				comparisonDetailVO.setS_B(util.getArea(rgbArray[2], x_min, x_max));
//				comparisonDetailVO.setS_R_gap(util.getAreaGap(comparisonDetailVO.getS_R(), comparisonReferenceVO.getS_R()));
//				comparisonDetailVO.setS_G_gap(util.getAreaGap(comparisonDetailVO.getS_G(), comparisonReferenceVO.getS_G()));
//				comparisonDetailVO.setS_B_gap(util.getAreaGap(comparisonDetailVO.getS_B(), comparisonReferenceVO.getS_B()));
//				comparisonDetailVO.setS_R_result(util.getEvaluateResult(comparisonDetailVO.getS_R_gap(), HistogramUtil.RED_VALUE));
//				comparisonDetailVO.setS_G_result(util.getEvaluateResult(comparisonDetailVO.getS_G_gap(), HistogramUtil.GREEN_VALUE));
//				comparisonDetailVO.setS_B_result(util.getEvaluateResult(comparisonDetailVO.getS_B_gap(), HistogramUtil.BLUE_VALUE));
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
//		VideoCardController mainVideoCard = new VideoCardController(branchVideoCardVO.getIp());
//		
//		byte getByte = 0x00;
//		int[][] revByte = mainVideoCard.getCommand(getByte);
//		
//		comparisonVO = new ComparisonVO();
//		comparisonVO.setDownVideoQuality(revByte[2]+"_"+revByte[3]+"_"+revByte[4]);
		return comparisonDetailVO;
	}
	
	/**
	 * 分会场到主会场图像的比对流程
	 * @param endpointIp
	 * @return
	 * @throws Exception
	 */
	private ComparisonDetailVO upVideoCompare(ZZOMainStatusVO branchMainstatusVO, ComparisonDetailVO comparisonDetailVO) throws Exception{
		//分会场终端被设为发言人
		McuControlDwr mcd = new McuControlDwr();
		String monitor = mainStatusVO.getMcu_participant_name()+"__"+mainStatusVO.getMcuMeetingID()+"__"+mainStatusVO.getMcuIp()+"__"+mainStatusVO.getMcu_participant_id();
		String[] roomInfos = new String[1];
		//pId,meetingID,flagId,mcuIp,pName
		roomInfos[0]=branchMainstatusVO.getMcu_participant_id()+"_"+branchMainstatusVO.getMcuMeetingID()+"_"+branchMainstatusVO.getConfFlagId() + "_" + branchMainstatusVO.getMcuIp() + "_" + branchMainstatusVO.getMcu_participant_name();
		mcd.setPersonal(roomInfos, monitor, MCUConfig.layoutTypes[1]);
		
		Thread.sleep(5000);
		
		VideoCardVO videoCardVO = new VideoCardVO();
		videoCardVO.setEquipmentID(mainVideoCardInfoVO.getEquipmentID());
		List<VideoCardVO> videoCardList = new VideoCardServiceImpl().query(videoCardVO, null);
		if(videoCardList == null || videoCardList.size() <= 0){
			return comparisonDetailVO;
		}
		videoCardVO = videoCardList.get(0);
		
		//get branch meeting room comparision reference 
		ComparisonReferenceVO comparisonReferenceVO = new ComparisonReferenceVO();
		comparisonReferenceVO.setMeetingRoomID(branchVideoCardVO.getMeetingRoomVO().getMeetingRoomID());
		List<ComparisonReferenceVO> referenceList = new ComparisonReferenceServiceImpl().query(comparisonReferenceVO, null);
		if(referenceList == null || referenceList.size() <= 0){
			return comparisonDetailVO;
		}
		comparisonReferenceVO = referenceList.get(0);
		
		HistogramUtil util = new HistogramUtil();
		int[][] rgbArray = util.getRGBArea(mainVideoCardInfoVO.getIp(), videoCardVO);
		comparisonDetailVO.setUplinkR_Pr(util.getRGBAssembly(rgbArray[0]));
		comparisonDetailVO.setUplinkG_Y(util.getRGBAssembly(rgbArray[1]));
		comparisonDetailVO.setUplinkB_Pb(util.getRGBAssembly(rgbArray[2]));
		comparisonDetailVO.setUplinkS_R(util.getArea(rgbArray[0], x_min, x_max));
		comparisonDetailVO.setUplinkS_G(util.getArea(rgbArray[1], x_min, x_max));
		comparisonDetailVO.setUplinkS_B(util.getArea(rgbArray[2], x_min, x_max));
		comparisonDetailVO.setUplinkS_R_gap(util.getAreaGap(comparisonDetailVO.getUplinkS_R(), comparisonReferenceVO.getS_R()));
		comparisonDetailVO.setUplinkS_G_gap(util.getAreaGap(comparisonDetailVO.getUplinkS_G(), comparisonReferenceVO.getS_G()));
		comparisonDetailVO.setUplinkS_B_gap(util.getAreaGap(comparisonDetailVO.getUplinkS_B(), comparisonReferenceVO.getS_B()));
		comparisonDetailVO.setUplinkS_R_result(util.getEvaluateResult(comparisonDetailVO.getUplinkS_R_gap(), HistogramUtil.RED_VALUE));
		comparisonDetailVO.setUplinkS_G_result(util.getEvaluateResult(comparisonDetailVO.getUplinkS_G_gap(), HistogramUtil.GREEN_VALUE));
		comparisonDetailVO.setUplinkS_B_result(util.getEvaluateResult(comparisonDetailVO.getUplinkS_B_gap(), HistogramUtil.BLUE_VALUE));

		int result = util.getComprehensiveResult(comparisonDetailVO.getUplinkS_R_result(), comparisonDetailVO.getUplinkS_G_result(), comparisonDetailVO.getUplinkS_B_result());
		if(result == HistogramUtil.BAD_RESULT || result == HistogramUtil.OK_RESULT){
//			rgbArray = util.getRGBArea(mainVideoCardInfoVO.getIp(), videoCardVO);
//			comparisonDetailVO.setUplinkR_Pr(util.getRGBAssembly(rgbArray[0]));
//			comparisonDetailVO.setUplinkG_Y(util.getRGBAssembly(rgbArray[1]));
//			comparisonDetailVO.setUplinkB_Pb(util.getRGBAssembly(rgbArray[2]));
//			comparisonDetailVO.setUplinkS_R(util.getArea(rgbArray[0], x_min, x_max));
//			comparisonDetailVO.setUplinkS_G(util.getArea(rgbArray[1], x_min, x_max));
//			comparisonDetailVO.setUplinkS_B(util.getArea(rgbArray[2], x_min, x_max));
//			comparisonDetailVO.setUplinkS_R_gap(util.getAreaGap(comparisonDetailVO.getUplinkS_R(), comparisonReferenceVO.getS_R()));
//			comparisonDetailVO.setUplinkS_G_gap(util.getAreaGap(comparisonDetailVO.getUplinkS_G(), comparisonReferenceVO.getS_G()));
//			comparisonDetailVO.setUplinkS_B_gap(util.getAreaGap(comparisonDetailVO.getUplinkS_B(), comparisonReferenceVO.getS_B()));
//			comparisonDetailVO.setUplinkS_R_result(util.getEvaluateResult(comparisonDetailVO.getUplinkS_R_gap(), HistogramUtil.RED_VALUE));
//			comparisonDetailVO.setUplinkS_G_result(util.getEvaluateResult(comparisonDetailVO.getUplinkS_G_gap(), HistogramUtil.GREEN_VALUE));
//			comparisonDetailVO.setUplinkS_B_result(util.getEvaluateResult(comparisonDetailVO.getUplinkS_B_gap(), HistogramUtil.BLUE_VALUE));

		}
		return comparisonDetailVO;
	}
	
	private ComparisonVO getPtsChannel(ZZOMainStatusVO branchMainstatusVO, ComparisonVO comparisonVO){
		List<ZZOPtsChannel> ptsChannelList = ZZOMcuFactory.getInstance().getMcuControlHelper().getPtsChannel(meetingDetailId, 
				branchMainstatusVO.getMcu_participant_name()+"__"+branchMainstatusVO.getMcuMeetingID()+"__"+branchMainstatusVO.getMcuIp());
		if(ptsChannelList != null && ptsChannelList.size() > 0){
			boolean isInExisted = false, isOutExisted = false;;
			for(ZZOPtsChannel ptsChannel : ptsChannelList){
				if(ptsChannel.getChannelType().equals(MCUConfig.VIDEO_IN_TEXT)){
					isInExisted = true;
					if(OperateUtil.isAvailable(ptsChannel.getFractionLoss()) && OperateUtil.isAvailable(ptsChannel.getFractionLossPeak())){
						comparisonVO.setReceivePacketLoss((Float.parseFloat(ptsChannel.getFractionLoss()))/100);
					}
					if(OperateUtil.isAvailable(ptsChannel.getVideoFrameRate())){
						comparisonVO.setSendframeRate(Integer.parseInt(ptsChannel.getVideoFrameRate()));
					}
				}
				if(ptsChannel.getChannelType().equals(MCUConfig.VIDEO_OUT_TEXT)){
					isOutExisted = true;
					//mainStatusVO.setSendPacketLoss(ptsChannel.getFractionLoss() + "%(" + ptsChannel.getFractionLossPeak() + "%)");
					if(OperateUtil.isAvailable(ptsChannel.getFractionLoss()) && OperateUtil.isAvailable(ptsChannel.getFractionLossPeak())){
						comparisonVO.setSendPacketLoss((Float.parseFloat(ptsChannel.getFractionLoss()))/100);
					}
					if(OperateUtil.isAvailable(ptsChannel.getVideoFrameRate())){
						comparisonVO.setReceiveframeRate(Integer.parseInt(ptsChannel.getVideoFrameRate()));
					}
				}
				if(isInExisted && isOutExisted){
					break;
				}
			}
		}
		
		return comparisonVO;
	}
	
	/**
	 * get eqipment status from center control.
	 * @param endpointIp
	 * @param comparisonVO
	 * @param comparisonDetailVO
	 * @param isCheckC8
	 * @return
	 */
	public boolean getEqStatusResult(String endpointIp, ComparisonVO comparisonVO, ComparisonDetailVO comparisonDetailVO, boolean isCheckC8){
		boolean isGood = true;
		
		try{
		/*annotated wangle 2013-9-26. need newest centercontrol jar.*/
		//get equipment status
		//获取分会场
		branchEndPointVO = new EquipmentVO();
		branchEndPointVO.setIp(endpointIp);
		branchEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
		List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(branchEndPointVO, null);
		if(equipList == null || equipList.size() <= 0){
			return false;
		}
		branchEndPointVO = equipList.get(0);
		
		//视频评价结果请求
		branchVideoCardVO = new EquipmentVO();
		branchVideoCardVO.setMeetingRoomVO(branchEndPointVO.getMeetingRoomVO());
		branchVideoCardVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		equipList = ServiceFactory.getEquipmentService().query(branchVideoCardVO, null);
		if(equipList == null || equipList.size() <= 0){
			return false;
		}
		branchVideoCardVO = equipList.get(0);
		CenterControlObject obj = ControlFactory.getCenterControlObject(branchVideoCardVO.getIp());
		StringBuffer buffer = new StringBuffer();
		//goodCount = 1 meaning that  terminal is normal.
		int goodCount = 1, count = 1;
		if(obj == null){
			logger.info("设备为空");
		}else{
			ExcuteResultVO rvo = obj.getEquipmentStatus(CenterControlObject.def_ID);
			
			//利用监测音频时的时间，等待中控返回值。	modify by ryan on 2013-12-27
			if(isCheckC8){
				//check if c8 is connecte 
				branchVideoCardVO = new EquipmentVO();
				branchVideoCardVO.setMeetingRoomVO(branchEndPointVO.getMeetingRoomVO());
				branchVideoCardVO.setEquipmentType(EquipmentEnum.TYPE_ID_AUDIO);
				List<EquipmentVO> equipmentVOList=ServiceFactory.getEquipmentService().queryEquipments(branchVideoCardVO, null);
				if(equipmentVOList != null && equipmentVOList.size() > 0){
					branchVideoCardVO = equipmentVOList.get(0);
					boolean isConnected = HistogramUtil.getEquipmentStatus(branchVideoCardVO.getIp(), 2000);
					if(isConnected){
						buffer.append("audioHandler:true;");
					}else{
						buffer.append("audioHandler:false;");
					}
				}
			}
			
			if(rvo.isSuccess()){
				for(String s : obj.getEquipmentList()){
					//等离子pla
					if("pla".equalsIgnoreCase(s)){
						for(PlaVO vo : obj.getPlaList()){
							if(vo.isAvailable()){
								buffer.append("pla" + vo.getId() + ":" + vo.isAvailable() + ";");
								if(vo.isAvailable()){
									goodCount++;
								}
							}else{
								buffer.append("pla" + vo.getId() + ":false" +  ";");
							}
							count++;
						}
					}else if("sysPower".equalsIgnoreCase(s)){
						for(SysPowerVO vo : obj.getSysPowerList()){
							if(vo.isAvailable()){
								buffer.append("sysPower" + ":" + vo.isAvailable() + ";");
								if(vo.isAvailable()){
									goodCount++;
								}
							}else{
								buffer.append("sysPower" + ":false" +  ";");
							}
							count++;
						}
					}else if("matrix".equalsIgnoreCase(s)){
						MatrixSwitchVO vo = obj.getMatrixSwitchList().get(0);
						if(vo.isAvailable()){
							buffer.append("matrix" + ":" + vo.isAvailable() + ";");
							if(vo.isAvailable()){
								goodCount++;
							}
						}else{
							buffer.append("matrix" + ":false" + ";");
						}
						count++;
					}else if("camera".equalsIgnoreCase(s)){
						for(CameraVO vo : obj.getCameraList()){
							if(vo.isAvailable()){
								buffer.append("camera" + vo.getId() + ":" + vo.isAvailable() + ";");
								if(vo.isAvailable()){
									goodCount++;
								}
							}else{
								buffer.append("camera" + vo.getId() + ":false" + ";");
							}
							count++;
						}
					}else if("proj".equalsIgnoreCase(s)){
						for(ProjVO vo : obj.getProjList()){
							if(vo.isAvailable()){
								buffer.append("proj" + vo.getId() + ":" + vo.isAvailable() + ";");
								if(vo.isAvailable()){
									goodCount++;
								}
							}else{
								buffer.append("proj" + vo.getId() + ":false" + ";");
							}
							count++;
						}
					}
				}
			}else{
				logger.info("中控"+obj.getIP()+"网络不通");	
			}
			logger.info("中控"+obj.getIP()+"设备是否可用："+buffer.toString());	
		}
		
		//计算比例
		//comparisonVO.setDescription(goodCount + "/" + count);
		//记录设备状态
		 
		comparisonDetailVO.setDescription(buffer.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return isGood;
	}
	
	
	
	
	
	public boolean isContinued() {
		return isContinued;
	}
	public void setContinued(boolean isContinued) {
		this.isContinued = isContinued;
	}
}
