package com.zzst.action.meeting.autocompare.histogram;

import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.comparison.ComparisonVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.util.ControlFactory;


/**
 *@Description
 *@date 2014-1-10上午09:13:39
 *@author ryan
 */
public class conferenceThread implements Callable {
	private static Logger logger = CbfLogger.getLogger(conferenceThread.class.getName());	
	
	private ZZOMainStatusVO branchMainstatusVO;
	private ComparisonVO comparisonVO;
	private EquipmentVO mainEndPointVO;
	private EquipmentVO branchVideoCardVO;
	private EquipmentVO branchEndPointVO;
	
	public conferenceThread(ZZOMainStatusVO branchMainstatusVO,ComparisonVO comparisonVO,EquipmentVO mainEndPointVO, EquipmentVO branchVideoCardVO,EquipmentVO branchEndPointVO){
		this.branchMainstatusVO = branchMainstatusVO;
		this.comparisonVO = comparisonVO;
		this.mainEndPointVO = mainEndPointVO;
		this.branchVideoCardVO =  branchVideoCardVO;
		this.branchEndPointVO = branchEndPointVO;
	}
	
	public synchronized Object call() throws Exception {
		HistogramUtil histogramUtil = new HistogramUtil();
		CenterControlObject obj = ControlFactory.getCenterControlObject(branchVideoCardVO.getIp());
		if(obj == null){
			logger.info("设备为空");
		}else{
			//检查中控设备是否可用
			obj.getEquipmentStatus(CenterControlObject.def_ID);
		}
		
		logger.info(mainEndPointVO.getIp()+"======================="+branchMainstatusVO.getMcu_participant_ip());
		//主会场终端发送声音
		histogramUtil.makeNoise(mainEndPointVO.getIp());
		
		if(branchMainstatusVO.getMcu_participant_ip()!=null && !branchMainstatusVO.getMcu_participant_ip().equals("")){							
			try{
				 int downVoiceResult=histogramUtil.getVoiceResult(mainEndPointVO.getIp(),branchMainstatusVO.getMcu_participant_ip());							
				 int evaDownResult=histogramUtil.getVoiceEvalutResult(downVoiceResult);
				 comparisonVO.setDownAudioQuality(evaDownResult);
				 //comparisonVO.setDescription("down:" + downVoiceResult);
			}catch(Exception e){
				comparisonVO.setDownAudioQuality(HistogramUtil.NONEVOICE_VALUE);
			}
		}else{
			comparisonVO.setDownAudioQuality(HistogramUtil.ISNOTAPPRAISAL_RESULT);
		}
//			关闭主会场声音
		if(mainEndPointVO != null){
			histogramUtil.disableNoise(mainEndPointVO.getIp());
		}
		Thread.sleep(3000);
		
		//分会场终端发送声音
		histogramUtil.makeNoise(branchMainstatusVO.getMcu_participant_ip());
		
//			分会场发声音
		try{
			  int upVoiceResult=histogramUtil.getVoiceResult(branchMainstatusVO.getMcu_participant_ip(),mainEndPointVO.getIp());
			  //comparisonVO.setDescription(comparisonVO.getDescription() + "    up:" + upVoiceResult);
			  int evaUpResult=histogramUtil.getVoiceEvalutResult(upVoiceResult);
			  comparisonVO.setUpAudioQuality(evaUpResult);
		}catch(Exception e){
			 comparisonVO.setUpAudioQuality(HistogramUtil.NONEVOICE_VALUE);
		}
//			分会场发声音
		histogramUtil.disableNoise(branchMainstatusVO.getMcu_participant_ip());
		
//		取中控设备是否可用
		getEqStatusResult(branchMainstatusVO.getMcu_participant_ip(), comparisonVO, true);
		
		ServiceFactory.getConparisonService().replaceAudio(comparisonVO, null);
		HistogramVoiceThread.isVoiceThreadEnd = true;
		logger.info("音频点名完成");
		return null;
	}
	
	public boolean getEqStatusResult(String endpointIp, ComparisonVO comparisonVO, boolean isCheckC8){
		try{
			CenterControlObject obj = ControlFactory.getCenterControlObject(branchVideoCardVO.getIp());
			StringBuffer buffer = new StringBuffer();
			if(obj == null){
				logger.info("设备为空");
			}else{
				for(String s : obj.getEquipmentList()){
					//等离子pla
					if("pla".equalsIgnoreCase(s)){
						for(PlaVO vo : obj.getPlaList()){
							if(vo.isAvailable()){
								buffer.append("pla" + vo.getId() + ":" + vo.isAvailable() + ";");
							}else{
								buffer.append("pla" + vo.getId() + ":false" +  ";");
							}
						}
					}else if("sysPower".equalsIgnoreCase(s)){
						for(SysPowerVO vo : obj.getSysPowerList()){
							if(vo.isAvailable()){
								buffer.append("sysPower" + ":" + vo.isAvailable() + ";");
							}else{
								buffer.append("sysPower" + ":false" +  ";");
							}
						}
					}else if("matrix".equalsIgnoreCase(s)){
						if(obj.getMatrixSwitchList() != null && obj.getMatrixSwitchList().size() > 0){
							MatrixSwitchVO vo = obj.getMatrixSwitchList().get(0);
							if(vo.isAvailable()){
								buffer.append("matrix" + ":" + vo.isAvailable() + ";");
							}else{
								buffer.append("matrix" + ":false" + ";");
							}
						}
					}else if("camera".equalsIgnoreCase(s)){
						for(CameraVO vo : obj.getCameraList()){
							if(vo.isAvailable()){
								buffer.append("camera" + vo.getId() + ":" + vo.isAvailable() + ";");
							}else{
								buffer.append("camera" + vo.getId() + ":false" + ";");
							}
						}
					}else if("proj".equalsIgnoreCase(s)){
						for(ProjVO vo : obj.getProjList()){
							if(vo.isAvailable()){
								buffer.append("proj" + vo.getId() + ":" + vo.isAvailable() + ";");
							}else{
								buffer.append("proj" + vo.getId() + ":false" + ";");
							}
						}
					}
				}
					logger.info("中控"+obj.getIP()+"设备是否可用："+buffer.toString());	
			}
			
	//		利用监测音频时的时间，等待中控返回值。	modify by ryan on 2013-12-27
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
			comparisonVO.setDescription(buffer.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return true;
	}
	
}
