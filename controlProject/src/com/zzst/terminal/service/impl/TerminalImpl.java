package com.zzst.terminal.service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.communication.TerminalClientThreadByReturn;
import com.zzst.terminal.service.impl.communication.TerminalClientTreadByAudioReturn;
import com.zzst.terminal.service.impl.communication.TerminalCommnadEnues;
import com.zzst.terminal.service.impl.vo.AudiometerVO;
import com.zzst.terminal.service.impl.vo.CallDetailVO;
import com.zzst.terminal.service.impl.vo.CameraVO;
import com.zzst.terminal.service.impl.vo.ShoamiVO;
import com.zzst.terminal.service.impl.vo.TerminalMeetingVO;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.ServerSocketEnues;
import com.zzst.util.SystemConfig;

/**
 * 终端对象
 * 实现终端功能
 *@author	ryan
 *@since	2010-11-5上午10:05:44
 *@version	1.0
 */

public class TerminalImpl extends TerminalObject  {
	private static Logger logger = Logger.getLogger(TerminalImpl.class
			.getName());
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public TerminalImpl(String[] ip) {
		super(ip);
		//计划完善snmp部分，在设备注册完成时提取相应信息
		//initDateFromSnmp();
	}
	
//	@Override
//	public boolean setCallDetailOff() {
////		for(String s : AudiometerVO.typeMunes){
//			TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread("");
//			t.setLoop(false);
//			ServerSocketEnues.removeTerminalhread("test");
////		}
//		return true;
//	}
	
	@Override
	public ShoamiVO getWhoamiVO() {
		if(!this.shoami.getMap().isEmpty()) return shoami;
		
		String	command = TerminalCommnadEnues.WHOAMI[0];
		String	commandReturn = TerminalCommnadEnues.WHOAMI[1];
		
		TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread(this.terminalIp);
		if(t==null){
			TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,command,commandReturn);
		}else{
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);	
		}
		
		return shoami;
	}
	
	@Override
	public  CallDetailVO setCallDetailOn() {
		String	command1 = TerminalCommnadEnues.CALL_INFO_COMMAND1[0];
		String	command3 = TerminalCommnadEnues.CALL_INFO_COMMAND3[0];
//		String	commandReturn1 = TerminalCommnadEnues.CALL_INFO_COMMAND1[1];
		String	commandReturn3 = TerminalCommnadEnues.CALL_INFO_COMMAND3[1];
		
		TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread(this.terminalIp);
		if(t==null){
			TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,command3,commandReturn3);
		}else{
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command1);
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command3);	
		}
		
		
		
		return this.getCallDetailVO();
	}
	
	@Override
	public ExcuteResultVO setAudiometerOn(String audiometerType) {
		 audiometerVOList.remove(audiometerType);
		 
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setDes("网络异常");			
		}else{
			String	command = TerminalCommnadEnues.COMMAND_SOUND_AUDIOMETER_GET[0];
			command = command.replaceFirst("##1", audiometerType);
			
			String	commandReturn = TerminalCommnadEnues.COMMAND_SOUND_AUDIOMETER_GET[1];
			commandReturn = commandReturn.replaceFirst("##1", audiometerType);
			
			
			TerminalClientTreadByAudioReturn t = new TerminalClientTreadByAudioReturn(terminalIp,terminalPort,command,commandReturn,false);
			t.run();
			
//			ServerSocketEnues.audioThreadMap.put(this.terminalIp+audiometerType, t);
			
			resultVO.setSuccess(true);
		}
		return resultVO;
	}

	@Override
	public boolean setAudiometerAllOn() {
		audiometerVOList.clear();
		for(String s : AudiometerVO.typeMunes){
			setAudiometerOn(s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			String	command = TerminalCommnadEnues.COMMAND_SOUND_AUDIOMETER_GET[0].replaceFirst("##1", s);
//			String	commandReturn = TerminalCommnadEnues.COMMAND_SOUND_AUDIOMETER_GET[1].replaceFirst("##1", s);
//			TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread(s);
//			if(t==null){
//				TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,command,commandReturn);
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
				
			//modfiy by ryan on 2012-05-18
//			if(command.indexOf("audiometer ")==0){
//				ServerSocketEnues.setTerminalThread(command.split(" ")[1], t);
//			}
		}
		return true;
	}
	
//	@Override
	/**
	 * 结束线程
	 */
//	public boolean setAudiometerAllOff() {
//		for(String s : AudiometerVO.typeMunes){
//			TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread(s);
//			t.setLoop(false);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			ServerSocketEnues.removeTerminalhread(s);
//		}
//		return true;
//	}
	
	@Override
	/**
	 * 结束线程
	 */
	public ExcuteResultVO setAudiometerOff(String audiometerType) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setDes("网络异常");			
		}else{
			String	command = TerminalCommnadEnues.COMMAND_SOUND_AUDIOMETER_OFF[0];
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
			
			TerminalClientTreadByAudioReturn t = ServerSocketEnues.audioThreadMap.get(this.terminalIp+audiometerType);
			if(t!=null)
				t.setLoop(false);
			
			ServerSocketEnues.removeTerminalhread(this.terminalIp+audiometerType);
			resultVO.setSuccess(true);
		}
		
		//初始化音量值
		AudiometerVO vo = this.audiometerVOList.get(audiometerType);
		if(vo!=null)
			vo.setNum(AudiometerVO.num_def);
		
		return resultVO;
	}
	
	
	@Override
	public boolean answerPhone() {
		if(TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_ANSWER_PHONE)){
//			TerminalMeetingVO terminalMeetingVO = new TerminalMeetingVO();
//			terminalMeetingVO.setMeetingType(TerminalMeetingVO.TYPE_HPONE_IN);
//			this.setMeetingVO(terminalMeetingVO);
//			
			return true;
		}
		return false;
	}

	@Override
	/**
	 * snmp处理this.setMeetingVO(terminalMeetingVO)
	 */
	public boolean answerVideo() {
		if(TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_ANSWER_TERMINAL)){
//			TerminalMeetingVO terminalMeetingVO = new TerminalMeetingVO();
//			terminalMeetingVO.setMeetingType(TerminalMeetingVO.TYPE_MANUAL_IN);
//			this.setMeetingVO(terminalMeetingVO);
//			
			return true;
		}
		return false;
	}

	@Override
	/**
	 * snmp处理this.setMeetingVO(terminalMeetingVO)
	 */
	public boolean callIP(int speed, String ip) {
		String command =TerminalCommnadEnues.COMMAND_CALL_IP.replaceFirst("speed", speed+"");
		if(TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command.replaceFirst("dialstr", ip))){
			TerminalMeetingVO terminalMeetingVO = new TerminalMeetingVO();
			terminalMeetingVO.setFarIP(ip);
			terminalMeetingVO.setSpeed(speed);
			terminalMeetingVO.setMeetingType(TerminalMeetingVO.TYPE_MANUAL_OUT);
			this.setMeetingVO(SystemConfig.METHED_WITHIN,terminalMeetingVO);
			
			return true;
		}
		return false;
	}

	@Override
	/**
	 * snmp处理this.setMeetingVO(terminalMeetingVO)
	 */
	public boolean callPhone(String phoneNumber) {
		if(TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CALL_PHONE.replaceFirst("phoneNumber", phoneNumber))){
			TerminalMeetingVO terminalMeetingVO = new TerminalMeetingVO();
			terminalMeetingVO.setFarPhone(phoneNumber);
			terminalMeetingVO.setMeetingType(TerminalMeetingVO.TYPE_HPONE_OUT);
			this.setMeetingVO(SystemConfig.METHED_WITHIN,terminalMeetingVO);
			return true;
		}
		return false;
	}


	@Override
	public boolean cameraDown() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_DOWN);
	}


	@Override
	public boolean cameraFar() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_FAR);
	}


	@Override
	public boolean cameraGetPosition(String number) {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_PRESET_GET.replaceAll("##1", number));
	}

	
	@Override
	public boolean cameraLeft() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_LEFT);
	}

	@Override
	public boolean cameraMoveDown() {
		if(TerminalObject.Group300Model.equals(this.terminalModel)){
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_DOWN);
		}else{
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_DOWN);
		}
	}



	@Override
	public boolean cameraMoveLeft() {
		if(TerminalObject.Group300Model.equals(this.terminalModel)){
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_LEFT);
		}else{
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_LEFT);
		}
		
	}
	
	@Override
	public boolean cameraMoveFar() {
		if(TerminalObject.Group300Model.equals(this.terminalModel)){
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_FAR);
		}else{
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_FAR);
		}
	}
	
	@Override
	public boolean cameraMoveNear() {
		if(TerminalObject.Group300Model.equals(this.terminalModel)){
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_NEAR);
		}else{
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_NEAR);
		}
	}

	@Override
	public boolean cameraMoveRight() {
		if(TerminalObject.Group300Model.equals(this.terminalModel)){
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_RIGHT);
		}else{
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_RIGHT);
		}
	}

	@Override
	public boolean cameraMoveStop() {
		if(TerminalObject.Group300Model.equals(this.terminalModel)){
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_STOP);
		}else{
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_STOP);
		}
	}

	@Override
	public boolean cameraMoveUp() {
		if(TerminalObject.Group300Model.equals(this.terminalModel)){
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_UP);
		}else{
			return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_UP);
		}
		
	}

	@Override
	public boolean cameraNear() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_NEAR);
	}

	@Override
	public boolean cameraRight() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_RIGHT);
	}

	@Override /** change by yangyi **/
	public boolean cameraSelectNumber(String mumber) {
		String command = TerminalCommnadEnues.COMMAND_CAMERA_NEAR;
		command = command.replaceFirst("##1", mumber);
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean cameraSetPosition(String number) {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_PRESET_SET.replaceFirst("##1", number));
	}

	@Override
	public boolean cameraUp() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CAMERA_NEAR_UP);
	}

	@Override
	public boolean getCallSound(String number) {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_SOUND_CALL_SET.replaceFirst("##1", number));
	}

	@Override
	public boolean getPromptSound(String number) {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_SOUND_PROMPT_SET.replaceFirst("##1", number));
	}

	@Override
	public boolean getFarMuteStatus() {
		//return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_FAR_STATUS[0]);
		TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread(this.terminalIp);
		if(t==null){
			TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_FAR_STATUS[0],TerminalCommnadEnues.COMMAND_MUTE_FAR_STATUS[1]);
		}else{
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_FAR_STATUS[0]);	
		}
		//modify by ryan on 2012-5-18
		//return TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_FAR_STATUS[0],TerminalCommnadEnues.COMMAND_MUTE_FAR_STATUS[1]);
		return true;
	}

	@Override
	public boolean getNearMuteStatus() {
		//return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_NEAR_STATUS[0]);
		TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread(this.terminalIp);
		if(t==null){
			TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_NEAR_STATUS[0],TerminalCommnadEnues.COMMAND_MUTE_NEAR_STATUS[1]);
		}else{
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_NEAR_STATUS[0]);	
		}
		//return TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_NEAR_STATUS[0],TerminalCommnadEnues.COMMAND_MUTE_NEAR_STATUS[1]);
		return true;
	}

	@Override
	public boolean graphics() {
		return false;
	}

	@Override
	public boolean graphicsPlay() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_GRAPHICS_PLAY);
	}

	@Override
	public boolean graphicsStop() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_GRAPHICS_STOP);
	}

	@Override
	public boolean hangupAll() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_HANGUP_ALL);
	}

	@Override
	public boolean hangupPhone() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_HANGUP_PHONE);
	}

	@Override
	public boolean hangupVideo() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_CLOSE_TERMINAL);
	}

	@Override
	public boolean monitorGetView(String monitorNumber) {
		return false;
	}

	@Override
	public boolean monitorOutDVI50hz720p(String monitorNumber) {
		return false;
	}

	@Override //change by yangyi
	public boolean monitorOutVGA50hz720p(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_DISPLAY_SET;
		command = command.replaceFirst("##1", monitorNumber);
		command = command.replaceFirst("##2", "vag 4:3");
		command = command.replaceFirst("##3", "720p");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorOutYPbPr1080i(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_DISPLAY_SET;
		command = command.replaceFirst("##1", monitorNumber);
		command = command.replaceFirst("##2", "component 16:9");
		command = command.replaceFirst("##3", "1080i");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorSetViewAll(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET;
		command = command.replace("##1", "monitor"+monitorNumber);
		command = command.replace("##2", "all");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorSetViewFar(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET;
		command = command.replace("##1", "monitor"+monitorNumber);
		command = command.replace("##2", "far");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorSetViewFarOrContent(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET;
		command = command.replace("##1", "monitor"+monitorNumber);
		command = command.replace("##2", "content-or-far");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorSetViewFarOrNear(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET;
		command = command.replace("##1", "monitor"+monitorNumber);
		command = command.replace("##2", "near-or-far");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorSetViewNear(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET;
		command = command.replace("##1", "monitor"+monitorNumber);
		command = command.replace("##2", "near");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorSetViewNearOrContent(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET;
		command = command.replace("##1", "monitor"+monitorNumber);
		command = command.replace("##2", "content-or-near");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean monitorSetViewNone(String monitorNumber) {
		String command = TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET;
		command = command.replace("##1", "monitor"+monitorNumber);
		command = command.replace("##2", "none");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean muteOff() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_NEAR_ON);
	}

	@Override
	public boolean muteOn() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.COMMAND_MUTE_NEAR_OFF);
	}

	@Override
	public ArrayList<TerminalMeetingVO> getMeetingVO() {
		ArrayList<TerminalMeetingVO> mList = new ArrayList<TerminalMeetingVO>();
		Iterator<TerminalMeetingVO> i = meetingVOMap.values().iterator();
		while(i.hasNext()){
			mList.add(i.next());
		}
		return mList;
	}

	
	@Override
	public TerminalMeetingVO getMeetingVO(String nearIp,String farIp){
		if(nearIp==null||nearIp.length()<0||farIp==null||farIp.length()<0) return null;
		
		farIp = EquipmentObjectImpl.getTerminalIp(farIp);
		
		String key = TerminalMeetingVO.key.replaceAll("NEARIP", nearIp);
		key =key.replaceAll("FARIP", farIp);
		if(meetingVOMap.size()==0) return null;
		return meetingVOMap.get(key);
	}
	
	@Override
	public boolean setMeetingVO(String str,TerminalMeetingVO terminalMeetingVO){
		if(!str.equalsIgnoreCase(SystemConfig.METHED_WITHIN))	return false;
		if(terminalMeetingVO==null)	return false;
		
		String key = TerminalMeetingVO.key.replaceAll("NEARIP", this.terminalIp);
		key = key.replaceAll("FARIP", terminalMeetingVO.getFarIP());
		this.setStatus(SystemConfig.METHED_WITHIN,status_onMeeting);
		meetingVOMap.put(key, terminalMeetingVO);
		return true;
	}


	@Override
	public boolean setAudiometerVO(String key, AudiometerVO audiometerVO) {
		if(!key.equalsIgnoreCase(SystemConfig.METHED_WITHIN))	return false;
		//audiometerVOList.clear();
		audiometerVOList.put(audiometerVO.getType(), audiometerVO);
		return true;
	}
	
	@Override
	public	boolean removeMeetingVO(String key,String farIp){
		if(!key.equalsIgnoreCase(SystemConfig.METHED_WITHIN))	return false;
		
		farIp = EquipmentObjectImpl.getTerminalIp(farIp);
		
		key = TerminalMeetingVO.key.replaceAll("NEARIP", this.terminalIp);
		key = key.replaceAll("FARIP", farIp);
		
		if(meetingVOMap.isEmpty()){
			//this.setOnLine(false);
			this.setStatus(SystemConfig.METHED_WITHIN,status_on);
		}else{
			meetingVOMap.remove(key);
			if(meetingVOMap.isEmpty())
				//this.setOnLine(false);
				this.setStatus(SystemConfig.METHED_WITHIN,status_on);
			else
				this.setStatus(SystemConfig.METHED_WITHIN,status_onMeeting);
		}
		if(status_onMeeting.equalsIgnoreCase(this.getStatus()))
			return true;
		else
			return false;
		//return this.isOnLine();
	}
	
	
	public	ExcuteResultVO getAudiometerVO(){
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setDes("网络不通"+this.terminalIp);			
		}else{
//			try {//等待2秒后再取数据
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {	}
			
//			AudiometerVO vo = audiometerVOList.get(AudiometerVO.lineoutleft);
//			if(vo==null) {
//				logger.info("lineoutleft对象为空");
//			}else
//				logger.info(this.terminalIp+"方法内"+vo.getNum()+"===lineoutleft");
			
			
			resultVO.setSuccess(true);
			resultVO.setObject(this.audiometerVOList);
		}
		return resultVO;
	}

	@Override
	public boolean getConnectStaus(String ip) {
		if(status_onMeeting.equalsIgnoreCase(this.getStatus()))
			return true;
		else 
			return false;
		//return this.isOnLine();
	}

	@Override
	public boolean buttonBack() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_BACK_CONTENT);
	}

	@Override
	public boolean buttonCallhangup() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_HANGUP_CONTENT);
	}

	@Override
	public boolean buttonCamera() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_CAMERA_CONTENT);
	}

	@Override
	public boolean buttonDelete() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_DELETE_CONTENT);
	}

	@Override
	public boolean buttonDirectory() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_DIRECTORY_CONTENT);
	}

	@Override
	public boolean buttonDown() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_DOWN_CONTENT);
	}

	@Override
	public boolean buttonFar() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_FAR_CONTENT);
	}

	@Override
	public boolean buttonGraphics() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_GRAPHICS_CONTENT);
	}

	@Override
	public boolean buttonHelp() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_HELP_CONTENT);
	}
	
	@Override
	public boolean buttonInfo() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_INFO_CONTENT);
	}
	
	@Override
	public boolean buttonHome() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_HOME_CONTENT);
	}

	@Override
	public boolean buttonKeyboard() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_KEYBOARD_CONTENT);
	}

	@Override
	public boolean buttonLeft() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_LEFT_CONTENT);
	}

	@Override
	public boolean buttonMute() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_MUTE_CONTENT);
	}

	@Override
	public boolean buttonNear() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_NEAR_CONTENT);
	}

	@Override
	public boolean buttonNum(String num) {
		String command  = TerminalCommnadEnues.BUTTON_NUM_CONTENT.replaceFirst("##1",num);
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}
 
 
 

	@Override
	public boolean buttonPeriod() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_PERIOD_CONTENT);
	}

	@Override
	public boolean buttonPip() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_PIP_CONTENT);
	}

	@Override
	public boolean buttonRight() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_RIGHT_CONTENT);
	}

	@Override
	public boolean buttonSelect() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_SELECT_CONTENT);
	}

	@Override
	public boolean buttonUp() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_UP_CONTENT);
	}

	@Override
	public boolean buttonVolumeDown() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_VOLUME_DOWN_CONTENT);
	}

	@Override
	public boolean buttonVolumeUp() {
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.BUTTON_VOLUME_UP_CONTENT);
	}

	@Override
	public void setStatus(String key, String status) {
		if(SystemConfig.METHED_WITHIN.equalsIgnoreCase(key)){
			this.status = status;	
		}
	}

	@Override
	public CallDetailVO getCallDetailVO() {
		return this.callDetailVO;
	}

	@Override
	public CameraVO cameraGetPosition() {
		String	command = TerminalCommnadEnues.CAMERA_NEAR_POSITION_GET[0];
		String	commandReturn = TerminalCommnadEnues.CAMERA_NEAR_POSITION_GET[1];
		TerminalClientThreadByReturn t = ServerSocketEnues.getTerminalThread(this.terminalIp);
		if(t==null){
			TerminalImplHelp.sendCommandByBackInfo(this.terminalIp,this.terminalPort,command,commandReturn);
			try {
				Thread.sleep(5000);	
			} catch (Exception e) {
			}
		}else{
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
		}
		
		return this.getCameraVO();
	}

	@Override
	public boolean cameraSetPosition(String x, String y, String zoom) {
		try {
			if(x==null||x.length()==0||y==null||y.length()==0||zoom==null||zoom.length()==0){
				return false;
			}
			if(Integer.valueOf(x)<-880||Integer.valueOf(x)>880) return false;
			if(Integer.valueOf(x)<-300||Integer.valueOf(x)>300) return false;
			if(Integer.valueOf(x)<0||Integer.valueOf(x)>1023) return false;
			
			String	command = TerminalCommnadEnues.CAMERA_NEAR_POSITION_SET[0];
			
			command = command.replaceAll("##1", x);
			command = command.replaceAll("##2", y);
			command = command.replaceAll("##3", zoom);
			return	TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
			 
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean cameraFar(int num) {
		String	command = TerminalCommnadEnues.COMMAND_CAMERA_FAR;
		command = command.replaceAll("##1", num+"");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public boolean cameraNear(int num) {
		String	command = TerminalCommnadEnues.COMMAND_CAMERA_NEAR;
		command = command.replaceAll("##1", num+"");
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
	}

	@Override
	public ExcuteResultVO testToneOff() {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setDes("网络不通");			
		}else{
			String	command = TerminalCommnadEnues.testToneOff[0];
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
			resultVO.setSuccess(true);
		}
		return resultVO;
	}

	@Override
	public ExcuteResultVO testToneOn() {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setDes("网络不通");
		}else{
			String	command = TerminalCommnadEnues.testToneOn[0];
			TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command);
			resultVO.setSuccess(true);
		}
		return resultVO;
	}

	@Override
	public boolean callAuto(int speed, String dialstr) {
		String command =TerminalCommnadEnues.COMMAND_CALL_AUTO.replaceFirst("speed", speed+"");
		if(TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,command.replaceFirst("dialstr", dialstr))){
			TerminalMeetingVO terminalMeetingVO = new TerminalMeetingVO();
			terminalMeetingVO.setDialstr(dialstr);
			terminalMeetingVO.setSpeed(speed);
			terminalMeetingVO.setMeetingType(TerminalMeetingVO.TYPE_MANUAL_OUT);
			this.setMeetingVO(SystemConfig.METHED_WITHIN,terminalMeetingVO);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean echocanceller_no() {
		// TODO Auto-generated method stub
	return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.echocanceller_no);
	}

	@Override
	public boolean echocanceller_yes() {
		// TODO Auto-generated method stub
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.echocanceller_yes);
	}

	@Override
	public boolean enablekeyboardnoisereduction_no() {
		// TODO Auto-generated method stub
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.enablekeyboardnoisereduction_no);
	}

	@Override
	public boolean enablekeyboardnoisereduction_yes() {
		// TODO Auto-generated method stub
		return TerminalImplHelp.sendCommand(this.terminalIp,this.terminalPort,TerminalCommnadEnues.enablekeyboardnoisereduction_yes);
	}


	



	

	
	
}
