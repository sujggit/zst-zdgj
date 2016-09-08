package com.zzst.meeting.dwr;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.autocompare.histogram.HistogramThread;
import com.zzst.action.meeting.autocompare.histogram.HistogramThreadPoolManager;
import com.zzst.action.meeting.autocompare.histogram.HistogramUtil;
import com.zzst.action.meeting.autocompare.histogram.HistogramVoiceThread;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;
import com.zzst.model.meeting.comparison.ComparisonVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

public class VoiceCardDwrMethod {
	private static Logger logger = CbfLogger.getLogger(VideoCardDwrMethod.class.getName());	
	
	public String autoCompareVoice(String meetingDetailId,String VideoCardParameter){
		HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getVoiceInstance();
		if(histogramThreadPoolManager.isThreadExisted(meetingDetailId)){
			return "none";
		}
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
			//删除有关本次会议的所有会场
			try {
				ServiceFactory.getConparisonService().deleteByMeetingDetailID(meetingDetailId, null);
				//初始化所有会场
				VideoCardDwrMethod dwrMethod = new VideoCardDwrMethod();
				for(ZZOMainStatusVO branchMainstatusVO : meetingRoomList){
					try{
					if(branchMainstatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER 
							&& branchMainstatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)){
						dwrMethod.addInitResult(branchMainstatusVO, meetingDetailId, VideoCardParameter);
						
					}
					}catch(Exception e){e.printStackTrace();}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//HistogramThreadPoolManager histogramThreadPoolManager = HistogramThreadPoolManager.getVoiceInstance();
			boolean isSuccessful = histogramThreadPoolManager.pollPtsVoice(meetingDetailId,VideoCardParameter, mainMeetingRoom , meetingRoomList);
			if(!isSuccessful){
				return "none";
			}
		}
		return "success";
	}
	
	/**
	 * to compare a meeting room
	 * @param meetingDetailId
	 * @param VideoCardParameter
	 * @return
	 * wangle 2013-10-17
	 * @throws Exception 
	 */
	public String singleCompareVoice(String comparisonId){
		try{
			ComparisonVO comparisonVO = new ComparisonVO();
			comparisonVO.setID(comparisonId);
			List<ComparisonVO> comparisionList = ServiceFactory.getConparisonService().query(comparisonVO, null);
			if(comparisionList == null || comparisionList.size() <= 0){
				return "none";
			}
			comparisonVO = comparisionList.get(0);
			
			EquipmentVO currentEndPointVO = new EquipmentVO();
			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setMeetingRoomID(comparisonVO.getMeetingRoomID());
			currentEndPointVO.setMeetingRoomVO(meetingRoomVO);
			currentEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(currentEndPointVO, null);
			if(equipList == null || equipList.size() <= 0){
				return "none";
			}
			currentEndPointVO = equipList.get(0);
			
			//get broadcaster.
			List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(comparisonVO.getMeetingDetailID());
			if(meetingRoomList == null || meetingRoomList.size() <= 0){
				return "none";
			}
			ZZOMainStatusVO mainMeetingRoom = new ZZOMainStatusVO();
			ZZOMainStatusVO currentMainStatusVO = null;
			boolean isMainExisted = false;
			boolean isCurrentExisted = false;
			for(int i=0;i<meetingRoomList.size();i++){
				if(meetingRoomList.get(i).getIsSpeaker()==1&&meetingRoomList.get(i).getCascadeRole().equals("none")){
					mainMeetingRoom = meetingRoomList.get(i);
					isMainExisted = true;
				}
				if(meetingRoomList.get(i).getMcu_participant_ip().trim().equals(currentEndPointVO.getIp())){
					currentMainStatusVO =  meetingRoomList.get(i);
					isCurrentExisted = true;
				}
				if(isMainExisted && isCurrentExisted){
					break;
				}
			}
			if(mainMeetingRoom==null || currentMainStatusVO == null){
				return "none";
			}else{
				if(currentMainStatusVO.getConnectStatus() == null || currentMainStatusVO.getConnectStatus().intValue() != MCUConfig.CONNECTED_STATUS){
					return "none";
				}
				if(mainMeetingRoom.getConnectStatus() == null || mainMeetingRoom.getConnectStatus().intValue() != MCUConfig.CONNECTED_STATUS){
					return "none";
				}
				singleCompare(comparisonVO, mainMeetingRoom, currentMainStatusVO, currentEndPointVO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * single compare. wangle 2013-10-18
	 * @param currentComparisonVO
	 * @param mainMainStatusVO
	 * @param currentMainStatusVO
	 * @param currentEndPointVO
	 */
	private void singleCompare(ComparisonVO currentComparisonVO, ZZOMainStatusVO mainMainStatusVO, ZZOMainStatusVO currentMainStatusVO,EquipmentVO currentEndPointVO){
		HistogramUtil histogramUtil = new HistogramUtil();
		HistogramVoiceThread histogramVoiceUtil = new HistogramVoiceThread(currentComparisonVO.getMeetingDetailID(), "" + currentComparisonVO.getStatus(), mainMainStatusVO, null);
		EquipmentVO mainEndPointVO = null;
		try {
			//获取主会场终端
			mainEndPointVO = new EquipmentVO();
			mainEndPointVO.setIp(mainMainStatusVO.getMcu_participant_ip());
			mainEndPointVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(mainEndPointVO, null);
			if(equipList == null || equipList.size() <= 0){
				return;
			}
			mainEndPointVO = equipList.get(0);
			histogramVoiceUtil.setMainEndPointVO(mainEndPointVO);
			
			//获取主会场比对卡
			EquipmentVO mainVideoCardInfoVO = new EquipmentVO();
			mainVideoCardInfoVO.setMeetingRoomVO(mainEndPointVO.getMeetingRoomVO());
			mainVideoCardInfoVO.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
			equipList = ServiceFactory.getEquipmentService().query(mainVideoCardInfoVO, null);
			if(equipList == null || equipList.size() <= 0){
				return;
			}
			mainVideoCardInfoVO = equipList.get(0);
			histogramVoiceUtil.setMainVideoCardInfoVO(mainVideoCardInfoVO);
			
			ComparisonVO comparisonVO = null;
			ComparisonDetailVO comparisonDetailVO = null;
			if(currentMainStatusVO.getIsSpeaker()!=MCUConfig.IS_SPEAKER && currentMainStatusVO.getCascadeRole().equalsIgnoreCase(MCUConfig.CASCADE_NONE)
					&& currentMainStatusVO.getConnectStatus() != null && currentMainStatusVO.getConnectStatus().intValue() != MCUConfig.DISCONNECTED_STATUS){
				try{
					comparisonVO = new ComparisonVO();
					comparisonDetailVO = new ComparisonDetailVO();
					//从中控获取设备状态，并作分析
					HistogramThread histogramHelp = new HistogramThread();
					boolean isContinuedTemp = histogramHelp.getEqStatusResult(currentMainStatusVO.getMcu_participant_ip(), comparisonVO, comparisonDetailVO, true);
					if(!isContinuedTemp){
						comparisonVO.setResult(HistogramUtil.BAD_RESULT);
					}else{
						//主会场终端发送声音
						histogramUtil.makeNoise(mainEndPointVO.getIp());
						
						//主会场到分会场图像的比对流程
						try{
							//分会场被选为发言人
							comparisonDetailVO = histogramVoiceUtil.downVideoCompare(currentMainStatusVO.getMcu_participant_ip(), comparisonDetailVO);						
							comparisonVO.setDownVideoQuality(histogramUtil.getComprehensiveResult(comparisonDetailVO.getS_R_result(), comparisonDetailVO.getS_G_result(), comparisonDetailVO.getS_B_result()));
						}catch(Exception e){
							comparisonVO.setDownVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
						}
						if(currentMainStatusVO.getMcu_participant_ip()!=null && !currentMainStatusVO.getMcu_participant_ip().equals("")){							
							try{
								 int downVoiceResult=histogramUtil.getVoiceResult(mainEndPointVO.getIp(),currentMainStatusVO.getMcu_participant_ip());							
								 int evaDownResult=histogramUtil.getVoiceEvalutResult(downVoiceResult);
								 comparisonVO.setDownAudioQuality(evaDownResult);
								 //comparisonVO.setDescription("down:" + downVoiceResult);
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
							
						//分会场发声音
						histogramUtil.makeNoise(currentMainStatusVO.getMcu_participant_ip());
						
						//分会场到主会场图像的比对流程
						try{
							comparisonDetailVO = histogramVoiceUtil.upVideoCompare(currentMainStatusVO, comparisonDetailVO);
							comparisonVO.setUpVideoQuality(histogramUtil.getComprehensiveResult(comparisonDetailVO.getUplinkS_R_result(), comparisonDetailVO.getUplinkS_G_result(), comparisonDetailVO.getUplinkS_B_result()));
						}catch(Exception e){
							comparisonVO.setUpVideoQuality(HistogramUtil.ISNOTCONNECTED_RESULT);
						}
						
						try{
						  int upVoiceResult=histogramUtil.getVoiceResult(currentMainStatusVO.getMcu_participant_ip(),mainEndPointVO.getIp());
						  //comparisonVO.setDescription(comparisonVO.getDescription() + "    up:" + upVoiceResult);
						  int evaUpResult=histogramUtil.getVoiceEvalutResult(upVoiceResult);
						  comparisonVO.setUpAudioQuality(evaUpResult);
						}catch(Exception e){
							 comparisonVO.setUpAudioQuality(HistogramUtil.NONEVOICE_VALUE);
						}
						//分会场发声音
						histogramUtil.disableNoise(currentMainStatusVO.getMcu_participant_ip());
						
						comparisonVO.setResult(histogramUtil.getResult(new int[]{comparisonVO.getDownVideoQuality(), comparisonVO.getUpVideoQuality()}, new int[]{comparisonVO.getDownAudioQuality(), comparisonVO.getUpAudioQuality()}));
						
						//获取分会场终端当前时间的丢包率和帧率
						comparisonVO = histogramVoiceUtil.getPtsChannel(currentMainStatusVO, comparisonVO);
					}
				}catch (Exception e) {
					comparisonVO.setResult(HistogramUtil.BAD_RESULT);
					comparisonVO.setDescription(e.getMessage());
					e.printStackTrace();
				}
				
				//保存
				Timestamp now = new Timestamp(System.currentTimeMillis());
				comparisonDetailVO.setUpdateTime(now);
				comparisonDetailVO.setID(currentComparisonVO.getCompDetailID());
				comparisonDetailVO = ServiceFactory.getConparisonDetailService().modify(comparisonDetailVO);
				//comparisonVO.setMeetingRoomName(currentMainStatusVO.getMcu_participant_name());
				//comparisonVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
				comparisonVO.setCompDetailID(comparisonDetailVO.getID());
				comparisonVO.setMeetingRoomID(currentEndPointVO.getMeetingRoomVO().getMeetingRoomID());
				comparisonVO.setMeetingDetailID(currentComparisonVO.getMeetingDetailID());
				comparisonVO.setUpdateTime(now);
				comparisonVO.setStatus(currentComparisonVO.getStatus());
				comparisonVO.setID(currentComparisonVO.getID());
				comparisonVO.setDescription(comparisonDetailVO.getDescription());
				ServiceFactory.getConparisonService().replace(comparisonVO, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
