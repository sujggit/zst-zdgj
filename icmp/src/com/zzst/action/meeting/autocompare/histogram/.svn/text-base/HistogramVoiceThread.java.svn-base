package com.zzst.action.meeting.autocompare.histogram;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMediaSourcesVO;
import com.zzst.application.mcuVO.ZZOPtsChannel;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.centerContor.service.CenterControlObject;
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
/**
 * 音视频比对
 * @author wangle
 *
 */
public class HistogramVoiceThread extends Thread{
	private static Logger logger = CbfLogger.getLogger(HistogramVoiceThread.class.getName());	
	
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
	public static boolean isVoiceThreadEnd = false;
	private String lastPts = null;
	public HistogramVoiceThread(){
		
	}
	public HistogramVoiceThread(String meetingDetailId,String VideoCardParameter, ZZOMainStatusVO mainStatusVO, List<ZZOMainStatusVO> mainStatusVOList){
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
		HistogramUtil histogramUtil = new HistogramUtil();
		EquipmentVO mainEndPointVO = null;
		try {
			ComparisonVO com = new ComparisonVO();
			com.setMeetingDetailID(this.meetingDetailId);
			List<ComparisonVO> tempComparisonList = ServiceFactory.getConparisonService().query(com, null);

			//获取主会场终端
			mainEndPointVO = new EquipmentVO();
			mainEndPointVO.setIp(mainStatusVO.getMcu_participant_ip());
			mainEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(mainEndPointVO, null);
			if(equipList == null || equipList.size() <= 0){
				return;
			}
			mainEndPointVO = equipList.get(0);
			
			
			//获取主会场比对卡
			mainVideoCardInfoVO = new EquipmentVO();
			mainVideoCardInfoVO.setMeetingRoomVO(mainEndPointVO.getMeetingRoomVO());
			mainVideoCardInfoVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipList = ServiceFactory.getEquipmentService().query(mainVideoCardInfoVO, null);
			if(equipList == null || equipList.size() <= 0){
				return;
			}
			mainVideoCardInfoVO = equipList.get(0);
			/*
			for(ZZOMainStatusVO branchMainstatusVO : mainStatusVOList){
				if(branchMainstatusVO.getConnectStatus() != MCUConfig.DISCONNECTED_STATUS){
					new McuDwrMethod().muteParticipants(branchMainstatusVO.getConfFlagId(), branchMainstatusVO.getMcu_participant_name()+"__"+branchMainstatusVO.getMcuMeetingID() + "__" + branchMainstatusVO.getMcuIp(), true);
				}
			}
			*/
			//add audio control by centercontrol wangle 2014-1-9
			addAudioControl(mainStatusVOList, true);
			
			ComparisonVO comparisonVO = null;
			ComparisonDetailVO comparisonDetailVO = null;
			//循环选定一个在线分会场
			for(ZZOMainStatusVO branchMainstatusVO : mainStatusVOList){
				long millis = System.currentTimeMillis();
				logger.info("点名"+branchMainstatusVO.getMcu_participant_ip()+"会场，开始时间："+millis);
				
				//选择一个分会场
				branchEndPointVO = new EquipmentVO();
				branchEndPointVO.setIp(branchMainstatusVO.getMcu_participant_ip());
				branchEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				equipList = ServiceFactory.getEquipmentService().query(branchEndPointVO, null);
				if(equipList == null || equipList.size() <= 0){
					continue;
				}
				branchEndPointVO = equipList.get(0);
				
				//视频评价结果请求
				branchCenterControlVO = new EquipmentVO();
				branchCenterControlVO.setMeetingRoomVO(branchEndPointVO.getMeetingRoomVO());
				branchCenterControlVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
				equipList = ServiceFactory.getEquipmentService().query(branchCenterControlVO, null);
				if(equipList == null || equipList.size() <= 0){
					//continue;
				}else{
					branchCenterControlVO = equipList.get(0);
				}
//				if(branchMainstatusVO.getConnectStatus() == MCUConfig.DISCONNECTED_STATUS){
//					addDisconnectCompare(branchEndPointVO);
//					continue;	
//			    }	
				
				if(!isContinued){
					break;
				}
				////////////////////////@author:zhangjy/////////////////
			    boolean bl=false;
			    try{
			    	bl=branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)
						&& branchMainstatusVO.getConnectStatus() != null && branchMainstatusVO.getConnectStatus().intValue() != MCUConfig.DISCONNECTED_STATUS;
			    }catch(Exception E){}
			    	if(bl){
			    		try{
			    		//set a speaker.
			    		setSpeaker(branchMainstatusVO);
			    		
			    		comparisonVO = new ComparisonVO();
						comparisonDetailVO = new ComparisonDetailVO();
						comparisonVO.setMeetingRoomID(branchEndPointVO.getMeetingRoomVO().getMeetingRoomID());
						//音视频 视频 
						for(ComparisonVO oldComparisonVO : tempComparisonList){
							if(oldComparisonVO.getMeetingRoomID().equals(comparisonVO.getMeetingRoomID())){
								comparisonVO.setID(oldComparisonVO.getID());
							}
						}
						
						//start a thread.
			    		conferenceThread confThread = new conferenceThread(branchMainstatusVO, comparisonVO, mainEndPointVO, branchCenterControlVO, branchEndPointVO);
			    		FutureTask<Integer> target = new FutureTask<Integer>(confThread);
			    		new Thread(target, "confThread" + branchMainstatusVO.getMcu_participant_ip()).start();
			    		
			    		
						/*
						//从中控获取设备状态，并作分析
						HistogramThread histogramHelp = new HistogramThread();
						boolean isContinuedTemp =histogramHelp.getEqStatusResult(branchMainstatusVO.getMcu_participant_ip(), comparisonVO, comparisonDetailVO, true);
						if(!isContinuedTemp){
							comparisonVO.setResult(HistogramUtil.BAD_RESULT);
						}else{
							logger.info(mainEndPointVO.getIp()+"======================="+branchMainstatusVO.getMcu_participant_ip());
							//主会场终端发送声音
							histogramUtil.makeNoise(mainEndPointVO.getIp());
						*/	
							//主会场到分会场图像的比对流程
							try{
								//分会场被选为发言人
								comparisonDetailVO = downVideoCompare(branchMainstatusVO.getMcu_participant_ip(), comparisonDetailVO);						
								comparisonVO.setDownVideoQuality(histogramUtil.getComprehensiveResult(comparisonDetailVO.getS_R_result(), comparisonDetailVO.getS_G_result(), comparisonDetailVO.getS_B_result()));
							}catch(Exception e){
								comparisonVO.setDownVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
							}
							/*
							if(branchMainstatusVO.getMcu_participant_ip()!=null && !branchMainstatusVO.getMcu_participant_ip().equals("")){							
								try{
									 int downVoiceResult=histogramUtil.getVoiceResult(mainEndPointVO.getIp(),branchMainstatusVO.getMcu_participant_ip());							
									 int evaDownResult=histogramUtil.getVoiceEvalutResult(downVoiceResult);
									 comparisonVO.setDownAudioQuality(evaDownResult);
									 comparisonVO.setDescription("down:" + downVoiceResult);
								}catch(Exception e){
									comparisonVO.setDownAudioQuality(HistogramUtil.NONEVOICE_VALUE);
								}
							}else{
								comparisonVO.setDownAudioQuality(HistogramUtil.ISNOTAPPRAISAL_RESULT);
							}
							//关闭主会场声音
							if(mainEndPointVO != null){
								histogramUtil.disableNoise(mainEndPointVO.getIp());
							}
							*/
							if(!isContinued){
								break;
							}
							/*
							//分会场发声音
							histogramUtil.makeNoise(branchMainstatusVO.getMcu_participant_ip());
							*/
							//分会场到主会场图像的比对流程
							try{
								comparisonDetailVO = upVideoCompare(branchMainstatusVO, comparisonDetailVO);
								comparisonVO.setUpVideoQuality(histogramUtil.getComprehensiveResult(comparisonDetailVO.getUplinkS_R_result(), comparisonDetailVO.getUplinkS_G_result(), comparisonDetailVO.getUplinkS_B_result()));
							}catch(Exception e){
								comparisonVO.setUpVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
							}
							/*
							try{
							  int upVoiceResult=histogramUtil.getVoiceResult(branchMainstatusVO.getMcu_participant_ip(),mainEndPointVO.getIp());
							  comparisonVO.setDescription(comparisonVO.getDescription() + "    up:" + upVoiceResult);
							  int evaUpResult=histogramUtil.getVoiceEvalutResult(upVoiceResult);
							  comparisonVO.setUpAudioQuality(evaUpResult);
							}catch(Exception e){
								 comparisonVO.setUpAudioQuality(HistogramUtil.NONEVOICE_VALUE);
							}
							//分会场发声音
							histogramUtil.disableNoise(branchMainstatusVO.getMcu_participant_ip());
							*/
							if(!isContinued){
								break;
							}
							
							
							
							
							//获取分会场终端当前时间的丢包率和帧率
							comparisonVO = getPtsChannel(branchMainstatusVO, comparisonVO);
						//}
						if(!isContinued){
							break;
						}
					}catch (Exception e) {
						comparisonVO.setResult(HistogramUtil.BAD_RESULT);
						comparisonVO.setDescription(e.getMessage());
						e.printStackTrace();
					}
					
					//保存
					Timestamp now = new Timestamp(System.currentTimeMillis());
					comparisonDetailVO.setUpdateTime(now);
					comparisonDetailVO = ServiceFactory.getConparisonDetailService().add(comparisonDetailVO);
					//comparisonVO.setMeetingRoomName(branchMainstatusVO.getMcu_participant_name());
					//comparisonVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
					comparisonVO.setCompDetailID(comparisonDetailVO.getID());
					//comparisonVO.setMeetingRoomID(branchEndPointVO.getMeetingRoomVO().getMeetingRoomID());
					comparisonVO.setMeetingDetailID(this.meetingDetailId);
					comparisonVO.setUpdateTime(now);
					comparisonVO.setStatus(Integer.parseInt(VideoCardParameter));
					
					
					 //UserVO vo = (UserVO)this..getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
					//comparisonReferenceVO_.setUpdateUserID(vo.getUserID());
					//comparisonVO.setUpdateUserID(updateUserID);
					
					int count = 0;
					while(!isVoiceThreadEnd && count < 3){
						Thread.sleep(2000);
						count++;
					}
					if(isVoiceThreadEnd){
						com = new ComparisonVO();
						com.setMeetingDetailID(this.meetingDetailId);
						com.setID(comparisonVO.getID());
						List<ComparisonVO> oldComparisonList = ServiceFactory.getConparisonService().query(com, null);
						if(oldComparisonList != null && oldComparisonList.size() > 0){
							com = oldComparisonList.get(0);
							comparisonVO.setDownAudioQuality(com.getDownAudioQuality());
							comparisonVO.setUpAudioQuality(com.getUpAudioQuality());
							comparisonVO.setDescription(com.getDescription());
							comparisonVO.setResult(histogramUtil.getAVCResult(com.getDescription(), new int[]{comparisonVO.getDownVideoQuality(), comparisonVO.getUpVideoQuality()}, new int[]{comparisonVO.getDownAudioQuality(), comparisonVO.getUpAudioQuality()}));
						
							ServiceFactory.getConparisonService().replace(comparisonVO, null);
						}
					}else{
						comparisonVO.setResult(HistogramUtil.BAD_RESULT);
						ServiceFactory.getConparisonService().replace(comparisonVO, null);
					}
				}else{
					//handler disconnect participant when polling.
					if(branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)
						&& (branchMainstatusVO.getConnectStatus() == null || branchMainstatusVO.getConnectStatus().intValue() == MCUConfig.DISCONNECTED_STATUS)){
						new VideoCardDwrMethod().replaceDisconnResult(branchMainstatusVO, this.meetingDetailId, VideoCardParameter);
					}
				}
			    
			    addAudioControl(mainStatusVOList, false);
				long ll = System.currentTimeMillis()-millis;
				logger.info("点名"+branchMainstatusVO.getMcu_participant_ip()+"会场结束,点名时长："+ll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//remove thread cache.
		HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getInstance();
		if(histogramThreadPoolManager != null){
			histogramThreadPoolManager.stopPolling(meetingDetailId);
			histogramThreadPoolManager.stopVoicePolling(meetingDetailId);
		}
	}
	/**
	 * 主会场到分会场图像的比对流程
	 * @param endpointIp
	 * @return
	 * @throws Exception
	 */
	public ComparisonDetailVO downVideoCompare(String endpointIp, ComparisonDetailVO comparisonDetailVO){
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
			e.printStackTrace();
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
	public ComparisonDetailVO upVideoCompare(ZZOMainStatusVO branchMainstatusVO,ComparisonDetailVO comparisonDetailVO) throws Exception{
		/*
		//分会场终端被设为发言人
		McuControlDwr mcd = new McuControlDwr();
		String monitor = mainStatusVO.getMcu_participant_name()+"__"+mainStatusVO.getMcuMeetingID()+"__"+mainStatusVO.getMcuIp()+"__"+mainStatusVO.getMcu_participant_id();
		String[] roomInfos = new String[1];
		//pId,meetingID,flagId,mcuIp,pName
		roomInfos[0]=branchMainstatusVO.getMcu_participant_id()+"_"+branchMainstatusVO.getMcuMeetingID()+"_"+branchMainstatusVO.getConfFlagId() + "_" + branchMainstatusVO.getMcuIp() + "_" + branchMainstatusVO.getMcu_participant_name();
		mcd.setPersonal(roomInfos, monitor, MCUConfig.layoutTypes[1]);
		
		Thread.sleep(5000);
		*/
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
	
	public ComparisonVO getPtsChannel(ZZOMainStatusVO branchMainstatusVO, ComparisonVO comparisonVO){
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
	
	//add disconnected ep compare result.
	public void addDisconnectCompare(EquipmentVO endPointVO){
		try{
		ComparisonVO comparisonVO = new ComparisonVO();
		ComparisonDetailVO comparisonDetailVO = new ComparisonDetailVO();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		comparisonDetailVO.setUpdateTime(now);
		comparisonDetailVO = ServiceFactory.getConparisonDetailService().add(comparisonDetailVO);
		//comparisonVO.setMeetingRoomName(branchMainstatusVO.getMcu_participant_name());
		//comparisonVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
		comparisonVO.setCompDetailID(comparisonDetailVO.getID());
		comparisonVO.setMeetingRoomID(endPointVO.getMeetingRoomVO().getMeetingRoomID());
		comparisonVO.setMeetingDetailID(this.meetingDetailId);
		comparisonVO.setUpdateTime(now);
		comparisonVO.setUpAudioQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
		comparisonVO.setUpVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
		comparisonVO.setDownVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
		comparisonVO.setDownAudioQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
		comparisonVO.setStatus(Integer.parseInt(VideoCardParameter));
		comparisonVO.setResult(HistogramUtil.ISNOTCONNECTED_RESULT);
		
		ServiceFactory.getConparisonService().add(comparisonVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void addAudioControl(List<ZZOMainStatusVO> mainStatusVOList, boolean isOpen){
		for(ZZOMainStatusVO branchMainstatusVO : mainStatusVOList){
			try{
				if(branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)
						&& branchMainstatusVO.getConnectStatus() != null && branchMainstatusVO.getConnectStatus().intValue() != MCUConfig.DISCONNECTED_STATUS){
					//获取分会场
					branchEndPointVO = new EquipmentVO();
					branchEndPointVO.setIp(branchMainstatusVO.getMcu_participant_ip());
					branchEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(branchEndPointVO, null);
					if(equipList == null || equipList.size() <= 0){
						continue;
					}
					branchEndPointVO = equipList.get(0);
					
					//视频评价结果请求
					branchVideoCardVO = new EquipmentVO();
					branchVideoCardVO.setMeetingRoomVO(branchEndPointVO.getMeetingRoomVO());
					branchVideoCardVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
					equipList = ServiceFactory.getEquipmentService().query(branchVideoCardVO, null);
					if(equipList == null || equipList.size() <= 0){
						continue;
					}
					branchVideoCardVO = equipList.get(0);
					CenterControlObject obj = ControlFactory.getCenterControlObject(branchVideoCardVO.getIp());
					if(obj != null){
						if(isOpen){
							obj.audioMuteOn(CenterControlObject.def_ID);
						}else{
							obj.audioMuteOff(CenterControlObject.def_ID);
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * set a speaker.
	 * @param branchMainstatusVO
	 */
	private void setSpeaker(ZZOMainStatusVO branchMainstatusVO){
		if(lastPts!=null){
			ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(meetingDetailId, lastPts, true);
		}
		
		//分会场终端被设为发言人
		String monitor = mainStatusVO.getMcu_participant_name()+"__"+mainStatusVO.getMcuMeetingID()+"__"+mainStatusVO.getMcuIp()+"__"+mainStatusVO.getMcu_participant_id();
		String[] roomInfos = new String[1];
		//pId,meetingID,flagId,mcuIp,pName
		roomInfos[0]=branchMainstatusVO.getMcu_participant_id()+"_"+branchMainstatusVO.getMcuMeetingID()+"_"+branchMainstatusVO.getConfFlagId() + "_" + branchMainstatusVO.getMcuIp() + "_" + branchMainstatusVO.getMcu_participant_name();
		setPersonalSpeaker(roomInfos, monitor, MCUConfig.layoutTypes[1]);
		
		/*compare down then up video, this time is useless.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		String[] infov = roomInfos[0].split("_");
		String roomInfo1 = infov[4]+"__"+infov[1]+"__"+infov[3];
		ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(meetingDetailId,roomInfo1,false);
		lastPts = roomInfo1;	
	}
	
	/**
	 * 设置个人模式
	 * @param infos 包括pId,meetingID,flagId,mcuIp,pName
	 * @param monitor 包括pName,meetingID,mcuIp,pId
	 * @param mode 包括personal,conference
	 */
	public void setPersonalSpeaker(String[] infos,String monitor,String mode){
		String[] forceIdArray = new String[infos.length];
		String[] monitorInfo = monitor.split("__");
		for(int i=0;i<infos.length;i++){
			if(monitorInfo[1].equals(infos[i].split("_")[1])){    //mcuMeetingId是否相同 相同则为同一会议中
				forceIdArray[i]=infos[i].split("_")[0];			//将该会场id存入forceIdArray
			//不在同一会议中 对其级联会中的级联点进行操作
			}else{
				List<ZZOMainStatusVO> confRoomList = new ArrayList<ZZOMainStatusVO>();
				//取得被看会场的会议中会场列表confRoomList
				confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(infos[i].split("_")[2], infos[i].split("_")[3], infos[i].split("_")[1]);
				for(int j=0;j<confRoomList.size();j++){
					//找出该会议中的级联点
					if(!confRoomList.get(j).getCascadeRole().equals("none")){
						String[] forceIdArray1 = new String[1];
						forceIdArray1[0] = infos[i].split("_")[0];
						ZZOMediaSourcesVO zzoMediaSourcesVO1= new ZZOMediaSourcesVO();
						List<ZZOMediaSourcesVO> mediaList1=new ArrayList<ZZOMediaSourcesVO>();	
						zzoMediaSourcesVO1.setLayout("1x1");
						zzoMediaSourcesVO1.setLayoutType("personal");
						zzoMediaSourcesVO1.setMcuIP(confRoomList.get(j).getMcuIp());
						zzoMediaSourcesVO1.setMcuMeetingID(confRoomList.get(j).getMcuMeetingID());
						zzoMediaSourcesVO1.setMcuParticipantId(confRoomList.get(j).getMcu_participant_id());
						zzoMediaSourcesVO1.setForceIdArray(forceIdArray1);
						mediaList1.add(zzoMediaSourcesVO1);
						ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
						//unmute this cp
						String ptsFlag = confRoomList.get(j).getMcu_participant_name() + "__" + confRoomList.get(j).getMcuMeetingID() + "__" + 
						   confRoomList.get(j).getMcuIp();
						ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(infos[i].split("_")[2], ptsFlag,false);
						
						//取得会议列表 confList
						List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(infos[i].split("_")[2]);
						for(int m=0;m<confList.size();m++){
							//取得级联点所属会议
							if((confList.get(m).getConfName()+confList.get(m).getMcuIP()).equals(confRoomList.get(j).getMeetingName()+confRoomList.get(j).getMcuIp())){
								List<ZZOMainStatusVO> confRoomList1 = new ArrayList<ZZOMainStatusVO>();
								//取得主会下会场
								confRoomList1 = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(infos[i].split("_")[2], monitorInfo[2], monitorInfo[1]);
								for(int n=0;n<confRoomList1.size();n++){
									if(confRoomList1.get(n).getAliasName()!=null&&((confRoomList1.get(n).getAliasName()+confRoomList1.get(n).getMcu_participant_ip()).equals(confList.get(m).getE164()+confList.get(m).getMcuCommandIP()))){
										//将主会中级联点存入forceIdArray
										forceIdArray[i]=confRoomList1.get(n).getMcu_participant_id();
										//unmute this cp
										ptsFlag = confRoomList1.get(n).getMcu_participant_name() + "__" + confRoomList1.get(n).getMcuMeetingID() + "__" + 
										confRoomList1.get(n).getMcuIp();
										ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(infos[i].split("_")[2], ptsFlag,false);
										break;
									}
								}
								break;
							}
							
						}
						break;
					}
				}
			}
		}
		String layoutType = MCUConfig.LAYOUT_MODE_1X1;
		ZZOMediaSourcesVO zzoMediaSourcesVO= new ZZOMediaSourcesVO();
		List<ZZOMediaSourcesVO> mediaList=new ArrayList<ZZOMediaSourcesVO>();	
		
		if(infos.length==1){
			layoutType = MCUConfig.LAYOUT_MODE_1X1;
		}else if(infos.length==2){
			layoutType = MCUConfig.LAYOUT_MODE_1X2;
		}else if(infos.length==4){
			layoutType = MCUConfig.LAYOUT_MODE_2X2;
		}
		zzoMediaSourcesVO.setLayout(layoutType);
		zzoMediaSourcesVO.setLayoutType(mode);
		zzoMediaSourcesVO.setMcuIP(monitorInfo[2]);
		zzoMediaSourcesVO.setMcuMeetingID(monitorInfo[1]);
		zzoMediaSourcesVO.setMcuParticipantId(monitorInfo[3]);
		zzoMediaSourcesVO.setForceIdArray(forceIdArray);
		mediaList.add(zzoMediaSourcesVO);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList);
	}
	
	
	public boolean isContinued() {
		return isContinued;
	}
	public void setContinued(boolean isContinued) {
		this.isContinued = isContinued;
	}
	public EquipmentVO getMainEndPointVO() {
		return mainEndPointVO;
	}
	public void setMainEndPointVO(EquipmentVO mainEndPointVO) {
		this.mainEndPointVO = mainEndPointVO;
	}
	public EquipmentVO getMainCenterControlVO() {
		return mainCenterControlVO;
	}
	public void setMainCenterControlVO(EquipmentVO mainCenterControlVO) {
		this.mainCenterControlVO = mainCenterControlVO;
	}
	public EquipmentVO getMainVideoCardInfoVO() {
		return mainVideoCardInfoVO;
	}
	public void setMainVideoCardInfoVO(EquipmentVO mainVideoCardInfoVO) {
		this.mainVideoCardInfoVO = mainVideoCardInfoVO;
	}
}
