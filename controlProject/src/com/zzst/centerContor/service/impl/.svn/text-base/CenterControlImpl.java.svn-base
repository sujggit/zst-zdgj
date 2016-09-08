package com.zzst.centerContor.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.service.CenterControlObjectHelp;
import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.AudioControlVO;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.CenterControlVO;
import com.zzst.centerContor.vo.CurtainVO;
import com.zzst.centerContor.vo.DvdVO;
import com.zzst.centerContor.vo.LightVO;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.centerContor.vo.RoomModelVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.centerContor.vo.TvVO;
import com.zzst.centerContor.vo.UpDownScreenVO;
import com.zzst.centerContor.vo.VideomVO;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.centerContor.vo.ViewScreentViewVO;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.SystemConfig;
import com.zzst.util.initDate.CCEquipmentDAO;

/**
 * 描述	中控控制
 *@author	ryan
 *@since	2010-11-11下午01:36:23
 *@version	1.0
 */ 

public class CenterControlImpl extends CenterControlObject {
	private static Logger logger = Logger.getLogger(CenterControlImpl.class
			.getName());
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	
	public CenterControlImpl(CenterControlVO vo) {
		super(vo);
		initCenterControl(vo);
	}
	
	@Override
	public  ExcuteResultVO sendCommand(String command){
		try {
			new CenterControlClientThread(this.centerControlIp,this.centerControlProt).sendCommand(command);
			resultVO.setSuccess(true);
			resultVO.setObject(command);
		} catch (Exception e) {
			resultVO.setDes(e.getMessage());
			resultVO.setSuccess(false);
		}
		return resultVO;
	}

	public void setStatus(String sys,String status) {
		if(SystemConfig.METHED_WITHIN.equalsIgnoreCase(sys))
			this.status = status;
	}
	
	@Override
	public String getStatus() {
		return this.status;
	}
	
	@Override
	public ExcuteResultVO setRoomModel(String id, String modelID) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		String command = ControlCommandHelp.ROOM_MODEL_SET[0];
		command = command.replaceFirst("##1",id);
		command = command.replaceFirst("##2",modelID);
		ExcuteResultVO rVO = sendCommand(command);
		if(rVO.isSuccess()){
			RoomModelVO av = CenterControlObjectHelp.getRoomModelVOList(this.centerControlIp).get(id);
			av.setModel(modelID);
			rVO.setObject(av);
		}
		return rVO;
	}
	
	@Override
	public ExcuteResultVO getRoomModel(String id) {
		String command = ControlCommandHelp.ROOM_MODEL_GET[0];
		command = command.replaceFirst("##1",id);
		ExcuteResultVO rVO = sendCommand(command);
		if(rVO.isSuccess()){
			RoomModelVO av = CenterControlObjectHelp.getRoomModelVOList(this.centerControlIp).get(id);
			rVO.setObject(av);
		}
		return rVO;
	}
	
	private ExcuteResultVO audioControl(String id,int str) {
		if(id==null||id.length()==0) id = def_ID;
		/*if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}*/
		try{
			AudioControlVO av = CenterControlObjectHelp.getAudioList(this.centerControlIp).get(id);
			if(av==null){
				resultVO.setSuccess(false);
				resultVO.setDes(vo_reachable);
				return resultVO;
			}
			
			switch(str){
				case 1:		return new AudioControlImpl(this.centerControlIp,this.centerControlProt,av).getMuteNum();
				case 2:		return new AudioControlImpl(this.centerControlIp,this.centerControlProt,av).setMuteOff();
				case 3:		return new AudioControlImpl(this.centerControlIp,this.centerControlProt,av).setMuteOn();
				case 4:		new AudioControlImpl(this.centerControlIp,this.centerControlProt,av).getMuteStatus();
							resultVO.setSuccess(true);
							resultVO.setObject(av);
							return resultVO;
				case 5:		return new AudioControlImpl(this.centerControlIp,this.centerControlProt,av).audioSetMuteDown();
				case 6:		return new AudioControlImpl(this.centerControlIp,this.centerControlProt,av).audioSetMuteUp();
				default:	resultVO.setSuccess(false);return resultVO;
			}	
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setObject(e.getMessage());
			return resultVO;
		}
	}
	
	@Override
	public ExcuteResultVO audioMuteNum(String id) {
		return audioControl(id,1);
	}

	@Override
	public ExcuteResultVO audioMuteOff(String id) {
		return audioControl(id,2);
	}

	@Override
	public ExcuteResultVO audioMuteOn(String id) {
		return audioControl(id,3);	
	}
	
	@Override
	public ExcuteResultVO audioStatus(String id) {
		return audioControl(id,4);	
	}

	@Override
	public ExcuteResultVO audioSetMuteNum(String id, String num) {
		/*if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}*/
		AudioControlVO av = CenterControlObjectHelp.getAudioList(this.centerControlIp).get(id);
		if(av==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new AudioControlImpl(this.centerControlIp,this.centerControlProt,av).audioSetMuteNum(num);
	}
	
	@Override
	public ExcuteResultVO audioSetMuteDown(String id) {
		return audioControl(id,5);		
	}

	@Override
	public ExcuteResultVO audioSetMuteUP(String id) {
		return audioControl(id,6);	
	}
	
	@Override
	public ExcuteResultVO matrixSwitch(String id, String in, String out) {
		/*if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}*/
		MatrixSwitchVO mv = CenterControlObjectHelp.getMatrixList(this.centerControlIp).get(id);
		if(mv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new MatrixSwitchImpl(this.centerControlIp,this.centerControlProt,mv).matrixSwitch(in, out);
	}
	
	@Override
	public ExcuteResultVO matrixSwitch(String id, String in, String[] out) {
		/*if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}*/
		MatrixSwitchVO mv = CenterControlObjectHelp.getMatrixList(this.centerControlIp).get(id);
		if(mv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new MatrixSwitchImpl(this.centerControlIp,this.centerControlProt,mv).matrixSwitch(in, out);
	}


	@Override
	public ExcuteResultVO matrixSwitchList(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		MatrixSwitchVO mv = CenterControlObjectHelp.getMatrixList(this.centerControlIp).get(id);
		if(mv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new MatrixSwitchImpl(this.centerControlIp,this.centerControlProt,mv).matrixSwitchList();
	}
	
	
	@Override
	public ExcuteResultVO matrixSwitchIn(String id,String toUnm) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		MatrixSwitchVO mv = CenterControlObjectHelp.getMatrixList(this.centerControlIp).get(id);
		if(mv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new MatrixSwitchImpl(this.centerControlIp,this.centerControlProt,mv).matrixSwitchFrom(toUnm);
	}
	
	
	@Override
	public ExcuteResultVO matrixSwitchOut(String id,String fromUnm) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		MatrixSwitchVO mv = CenterControlObjectHelp.getMatrixList(this.centerControlIp).get(id);
		if(mv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new MatrixSwitchImpl(this.centerControlIp,this.centerControlProt,mv).matrixSwitchTo(fromUnm);
	}

	private ExcuteResultVO sysPowerControl(String id,int str){
		if(id==null||id.length()==0) id = def_ID;
		/*if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}*/
		
		try{
			SysPowerVO sv = CenterControlObjectHelp.getSysPowerList(this.centerControlIp).get(id);
			if(sv==null){
				resultVO.setSuccess(false);
				resultVO.setDes(vo_reachable);
				return resultVO;
			}
		
			switch(str){
				case 1:		return new SysPowerImpl(this.centerControlIp,this.centerControlProt,sv).sysPowerOff();
				case 2:		return new SysPowerImpl(this.centerControlIp,this.centerControlProt,sv).sysPowerOn();
				case 3:		return new SysPowerImpl(this.centerControlIp,this.centerControlProt,sv).sysPowerStatus();
				default:	resultVO.setSuccess(false);return resultVO;
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	@Override
	public ExcuteResultVO sysPowerOff(String id) {
		return sysPowerControl(id,1);
		
	}

	@Override
	public ExcuteResultVO sysPowerOn(String id) {
		return sysPowerControl(id,2);
	}

	@Override
	public ExcuteResultVO sysPowerStatus(String id) {
		return sysPowerControl(id,3);
	}

	@Override
	public ExcuteResultVO vedioTerminalStatus(String id) {
		//new VedioTerminalImpl(this.centerControlIp,this.centerControlProt,mv);
		return null;
	}

	@Override
	public ExcuteResultVO viewScreentModel(String id, String no) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).setWallModel(no);
	}

	@Override
	public ExcuteResultVO viewScreentStauts(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		ViewScreentVO vv = null;
		if(CenterControlObjectHelp.getViewScreentList(this.centerControlIp)!=null)
			vv =  CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).getWallPowerStatus();
	}

	@Override
	public ExcuteResultVO viewScreentModelStatus(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).getWallModelStatus();
	}
	
	@Override
	public ExcuteResultVO viewScreentModelInfo(String id, String no, String handle, String sourceName) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).setWallModelInfo(no, handle, sourceName);
	}
	
	@Override
	public ExcuteResultVO viewScreentModelStatusInfo(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).getWallModelStatusInfo();
	}


	@Override
	public ExcuteResultVO viewScreentModelList(String id) {
		if(CenterControlObjectHelp.getViewScreentList(this.centerControlIp)==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		resultVO.setSuccess(true);
		resultVO.setObject(vv);
		return resultVO;
	}

	@Override
	public ExcuteResultVO viewScreentModelSwitchOutPort(String id) {
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).viewScreentModelSwitchOutPort();
	}
	@Override
	public ExcuteResultVO viewScreentOFF(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).setWallPowerOff();
	}


	@Override
	public ExcuteResultVO viewScreentON(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).setWallPowerOn();
	}
	
	@Override
	public ExcuteResultVO viewScreentModelSwitch(String id, String modelID, String matrixID, String in, String out) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		
		if(ViewScreentVO.model_SWITCH_MATRIX.equalsIgnoreCase(vv.getSwitchType())){
			resultVO = matrixSwitch(matrixID, in, out);
		}else if(ViewScreentVO.model_SWITCH_MODEL.equalsIgnoreCase(vv.getSwitchType())){
			resultVO = new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).viewScreentModelSwitch(id, modelID,in, out);	
		}
		return  resultVO;
	}


	@Override
	public ExcuteResultVO cameraDown(String id) {
		return cameraControl(id,17,true);
	}


	@Override
	public ExcuteResultVO cameraGetSpeed(String id) {
		return cameraControl(id,11,true);	
	}


	@Override
	public ExcuteResultVO cameraLeft(String id) {
		return cameraControl(id,12,true);
	}


	@Override
	public ExcuteResultVO cameraRecall(String id, String num) {
		return cameraControl2(id,num,11);
	}


	@Override
	public ExcuteResultVO cameraRight(String id) {
		return cameraControl(id,13,true);		
	}


	@Override
	public ExcuteResultVO cameraSetSpeed(String id, String num) {
		return cameraControl2(id,num,10);
	}


	@Override
	public ExcuteResultVO cameraStore(String id, String num) {
		return cameraControl2(id,num,9);
	}


	@Override
	public ExcuteResultVO cameraUp(String id) {
		return cameraControl(id,14,true);
	}


	@Override
	public ExcuteResultVO cameraStop(String id) {
		return cameraControl(id,15,true);
	}

	private ExcuteResultVO cameraControl(String id,int str,boolean b) {
		if(id==null||id.length()==0) id = def_ID;
		/*if(!status_on.equalsIgnoreCase(this.status)&&b){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}*/
		/*String temp = null;//临时
*/		try{
			/*if(id.contains("!")){
				temp=id.split("!")[0];
			}else{
				temp=id;
			}*/
			CameraVO cv = CenterControlObjectHelp.getCameraList(this.centerControlIp).get(id);
			if(cv==null){
				resultVO.setSuccess(false);
				resultVO.setDes(vo_reachable);
				return resultVO;
			}
			/*cv.setId(id);//需要参数
*/			
			switch(str){
				case 1:		resultVO.setSuccess(true);
							resultVO.setObject(cv.getAllSpeed());
							return resultVO;
				case 2:		resultVO.setSuccess(true);
							resultVO.setObject(cv.getStore());
							return resultVO;
				case 3:		resultVO.setSuccess(true);
							resultVO.setObject(cv.getStoreAll());
							return resultVO;		
				case 4:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).zoomAdd();
				case 5:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).zoomSubtract();
				case 6:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraAutoTrackOn();
				case 7:		resultVO.setSuccess(true);
							resultVO.setObject(cv.getStatusAutoTrack());
							return resultVO;
				case 8:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraAutoTrackOff();
				case 9:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeBackLightStatus();
				case 10:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeExposureManualStatus();
				case 11:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraGetSpeed();
				case 12:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraLeft();
				case 13:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraRight();
				case 14:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraUp();
				case 15:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraStop();
				case 16:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeWhiteBalanceManualStatus();
				case 17:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraDown();
				default:	resultVO.setSuccess(false);return resultVO;
			}	
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setObject(e.getMessage());
			return resultVO;
		}
	}
	private ExcuteResultVO cameraControl2(String id,Object obj,int str) {
		if(id==null||id.length()==0) id = def_ID;
		/*if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}*/
		try{
			CameraVO cv = CenterControlObjectHelp.getCameraList(this.centerControlIp).get(id);
			if(cv==null){
				resultVO.setSuccess(false);
				resultVO.setDes(vo_reachable);
				return resultVO;
			}
			
			switch(str){
				case 1:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeBackLight(Boolean.valueOf(obj+""));
				case 2:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeExposureManuaIris(obj.toString());
				case 3:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeExposureManual(Boolean.valueOf(obj+""));		
				case 4:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeExposureManualGain(Integer.valueOf(obj.toString()));
				case 5:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeExposureManualSpeed(obj.toString());
				case 6:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeWhiteBalanceManual(Boolean.valueOf(obj+""));
				case 7:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeWhiteBalanceManualB(Integer.valueOf(obj.toString()));
				case 8:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraeWhiteBalanceManualR(Integer.valueOf(obj.toString()));
				case 9:		return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraStore(obj.toString());
				case 10:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraSetSpeed(obj.toString());
				case 11:	return new CameraControlImpl(this.centerControlIp,this.centerControlProt,cv).cameraRecall(obj.toString());
				default:	resultVO.setSuccess(false);return resultVO;
			}	
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setObject(e.getMessage());
			return resultVO;
		}
	}
	
	@Override
	public ExcuteResultVO cameraAllSpeed(String id) {
		return cameraControl(id,1,false);
	}
	
	@Override
	public ExcuteResultVO cameraStore(String id) {
		return cameraControl(id,2,false);	
	}
	
	@Override
	public ExcuteResultVO cameraAllStore(String id) {
		return cameraControl(id,3,false);
	}
	

	@Override
	public ExcuteResultVO cameraZoomAdd(String id) {
		return cameraControl(id,4,true);	
	}



	@Override
	public ExcuteResultVO cameraZoomSubtract(String id) {
		return cameraControl(id,5,true);	
	}
	
	@Override
	public ExcuteResultVO cameraAutoTrackOn(String id) {
		return cameraControl(id,6,true);			
	}

	@Override
	public ExcuteResultVO cameraAutoTrack(String id) {
		return cameraControl(id,7,false);		
	}
	
	@Override
	public ExcuteResultVO cameraAutoTrackOff(String id) {
		return cameraControl(id,8,true);
	}

	@Override
	public ExcuteResultVO upDownScreenScreenDown(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
     	UpDownScreenVO cv = CenterControlObjectHelp.getUpDownScreenList(this.centerControlIp).get(id);
     	if(cv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
     	return	new UpDownScreenImpl(this.centerControlIp,this.centerControlProt,cv).screenDown(id);
	}

	@Override
	public ExcuteResultVO upDownScreenScreenStatus(String id) {
     	UpDownScreenVO cv = CenterControlObjectHelp.getUpDownScreenList(this.centerControlIp).get(id);
     	if(cv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
     	return	new UpDownScreenImpl(this.centerControlIp,this.centerControlProt,cv).screenDown(id);
	}

	@Override
	public ExcuteResultVO upDownScreenScreenDown(String[] id) {
		resultVO.setSuccess(true);
		for(String s : id){
			ExcuteResultVO reVO = upDownScreenScreenDown(s);
			if(!reVO.isSuccess())
				resultVO = reVO;
		}
     	return	resultVO;
	}



	@Override
	public ExcuteResultVO upDownScreenScreenUP(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
     	UpDownScreenVO cv = CenterControlObjectHelp.getUpDownScreenList(this.centerControlIp).get(id);
     	if(cv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
     	return	new UpDownScreenImpl(this.centerControlIp,this.centerControlProt,cv).screenUP(id);
	}


	@Override
	public ExcuteResultVO upDownScreenScreenUP(String[] id) {
		resultVO.setSuccess(true);
		for(String s : id){
			ExcuteResultVO reVO = upDownScreenScreenUP(s);
			if(!reVO.isSuccess())
				resultVO = reVO;
		}
     	return	resultVO;
	}
	





	@Override
	public ExcuteResultVO lightOff(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		LightVO cv = CenterControlObjectHelp.getLightList(this.centerControlIp).get(id);
		if(cv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
     	return	new LightImpl(this.centerControlIp,this.centerControlProt,cv).lightOFF(id);
	}



	@Override
	public ExcuteResultVO lightOff(String[] ids) {
		resultVO.setSuccess(true);
		for(String s : ids){
		ExcuteResultVO reVO = lightOff(s);
		if(!reVO.isSuccess())
			resultVO = reVO;
		}
	 	return	resultVO;
 	}

	@Override
	public ExcuteResultVO lightStatus(String id) {
		LightVO cv = CenterControlObjectHelp.getLightList(this.centerControlIp).get(id);
		if(cv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
     	return	new LightImpl(this.centerControlIp,this.centerControlProt,cv).lightOFF(id);
	}

	@Override
	public ExcuteResultVO lightOn(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		LightVO cv = CenterControlObjectHelp.getLightList(this.centerControlIp).get(id);
		if(cv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
     	return	new LightImpl(this.centerControlIp,this.centerControlProt,cv).lightON(id);
	}



	@Override
	public ExcuteResultVO lightOn(String[] ids) {
		resultVO.setSuccess(true);
		for(String s : ids){
			ExcuteResultVO reVO = lightOn(s);
			if(!reVO.isSuccess())
				resultVO = reVO;
			}
		 	return	resultVO;
	 	}


	@Override
	public ExcuteResultVO plaStatus(String id) {
		return plaControl(id,5,true);
	}
	
	@Override
	public ExcuteResultVO plaOff(String id) {
		return plaControl(id,4,true);
	}



	@Override
	public ExcuteResultVO plaOff(String[] ids) {
		resultVO.setSuccess(true);
		for(String s : ids){
		ExcuteResultVO reVO = plaOff(s);
		if(!reVO.isSuccess())
			resultVO = reVO;
		}
 		return	resultVO;
 	}

	@Override
	public ExcuteResultVO plaChannel(String id, String no) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		PlaVO cv = CenterControlObjectHelp.getPlaList(this.centerControlIp).get(id);
		if(cv==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
     	return	new PLAImpl(this.centerControlIp,this.centerControlProt,cv).plaChannel(id,no);
	}

	private ExcuteResultVO plaControl(String id,int str,boolean b){
		if(id==null||id.length()==0) id = def_ID;
		if(!status_on.equalsIgnoreCase(this.status)&&b){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		try{
			PlaVO cv = CenterControlObjectHelp.getPlaList(this.centerControlIp).get(id);
			if(cv==null){
				resultVO.setSuccess(false);
				resultVO.setDes(vo_reachable);
				return resultVO;
			}
		
			switch(str){
				case 1:		return	new PLAImpl(this.centerControlIp,this.centerControlProt,cv).plaChannel(id);
				
				case 2:		resultVO.setSuccess(true);
							resultVO.setObject(cv.getChannelList());
		     				return	resultVO;
				case 3:		return	new PLAImpl(this.centerControlIp,this.centerControlProt,cv).plaON(id);
				case 4:		return	new PLAImpl(this.centerControlIp,this.centerControlProt,cv).plaOFF(id);
				case 5:		return	new PLAImpl(this.centerControlIp,this.centerControlProt,cv).plaStatus();
				default:	resultVO.setSuccess(false);return resultVO;
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	@Override
	public ExcuteResultVO plaChannel(String id) {
		return plaControl(id,1,true);
	}
	
	@Override
	public ExcuteResultVO plaChannelList(String id) {
		return plaControl(id,2,false);
	}

	@Override
	public ExcuteResultVO plaOn(String id) {
		return plaControl(id,3,true);
	}

	@Override
	public ExcuteResultVO plaOn(String[] ids) {
		resultVO.setSuccess(true);
		for(String s : ids){
			ExcuteResultVO reVO = plaOn(s);
			if(!reVO.isSuccess())
				resultVO = reVO;
		}
		return	resultVO;
	}

	private ExcuteResultVO dvdControl(String id,int str) {
		if(id==null||id.length()==0) id = def_ID;
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		try{
			switch(str){
				case 1:		return this.sendCommand(ControlCommandHelp.DVD_AUDIO[0].replaceFirst("##1",id));
				case 2:		return this.sendCommand(ControlCommandHelp.DVD_RETURN[0].replaceFirst("##1",id));
				case 3:		return this.sendCommand(ControlCommandHelp.DVD_DOWN[0].replaceFirst("##1",id));
				case 4:		return this.sendCommand(ControlCommandHelp.DVD_ENTER[0].replaceFirst("##1",id));
				case 5:		return this.sendCommand(ControlCommandHelp.DVD_LEFT[0].replaceFirst("##1",id));
				case 6:		return this.sendCommand(ControlCommandHelp.DVD_MENU[0].replaceFirst("##1",id));
				case 7:		return this.sendCommand(ControlCommandHelp.DVD_NUM[0].replaceFirst("##1",id));
				case 8:		return this.sendCommand(ControlCommandHelp.DVD_OPCL[0].replaceFirst("##1",id));
				case 9:		return this.sendCommand(ControlCommandHelp.DVD_RIGHT[0].replaceFirst("##1",id));
				case 10:	return this.sendCommand(ControlCommandHelp.DVD_UP[0].replaceFirst("##1",id));
				case 11:	return this.sendCommand(ControlCommandHelp.DVD_TITLE[0].replaceFirst("##1",id));
				case 12:	return this.sendCommand(ControlCommandHelp.DVD_CHANNEL_ADD[0].replaceFirst("##1",id));
				case 13:	return this.sendCommand(ControlCommandHelp.DVD_CHANNEL_SUBTRACT[0].replaceFirst("##1",id));
				case 14:	return this.sendCommand(ControlCommandHelp.DVD_HDD[0].replaceFirst("##1",id));
				case 15:	return this.sendCommand(ControlCommandHelp.DVD_DVD[0].replaceFirst("##1",id));
				case 16:	return this.sendCommand(ControlCommandHelp.DVD_FORWARD[0].replaceFirst("##1",id));
				case 17:	return this.sendCommand(ControlCommandHelp.DVD_INPUT[0].replaceFirst("##1",id));
				case 18:	return this.sendCommand(ControlCommandHelp.DVD_MAIN_MENU[0].replaceFirst("##1",id));
				case 19:	return this.sendCommand(ControlCommandHelp.DVD_NEXT[0].replaceFirst("##1",id));
				case 20:	return this.sendCommand(ControlCommandHelp.DVD_PAUSE[0].replaceFirst("##1",id));
				case 21:	return this.sendCommand(ControlCommandHelp.DVD_PLAY[0].replaceFirst("##1",id));
				case 22:	return this.sendCommand(ControlCommandHelp.DVD_PREV[0].replaceFirst("##1",id));
				case 23:	return this.sendCommand(ControlCommandHelp.DVD_REC[0].replaceFirst("##1",id));
				case 24:	return this.sendCommand(ControlCommandHelp.DVD_REVERSE[0].replaceFirst("##1",id));
				case 25:	return this.sendCommand(ControlCommandHelp.DVD_STOP[0].replaceFirst("##1",id));
				case 26:	return this.sendCommand(ControlCommandHelp.DVD_STOP_REC[0].replaceFirst("##1",id));
				case 27:	return this.sendCommand(ControlCommandHelp.DVD_POWER[0].replaceFirst("##1",id));
				default:	resultVO.setSuccess(false);return resultVO;
			}	
		}catch(Exception e){
			resultVO.setSuccess(false);
			return resultVO;
		}
	}
	
	@Override
	public ExcuteResultVO dvdAudioLine(String id) {
     	return	dvdControl(id,1);
	}

	@Override
	public ExcuteResultVO dvdBack(String id) {
		return	dvdControl(id,2);
	}

	@Override
	public ExcuteResultVO dvdDown(String id) {
		return	dvdControl(id,3);
	}

	@Override
	public ExcuteResultVO dvdEnter(String id) {
		return	dvdControl(id,4);
	}

	@Override
	public ExcuteResultVO dvdLeft(String id) {
		return	dvdControl(id,5);
	}

	@Override
	public ExcuteResultVO dvdMenu(String id) {
		return	dvdControl(id,6);
	}

	@Override
	public ExcuteResultVO dvdNum(String id,String num) {
		String command = ControlCommandHelp.DVD_NUM[0].replaceFirst("##1",id).replaceFirst("##2", num);
		return	this.sendCommand(command);
	}

	@Override
	public ExcuteResultVO dvdOpcl(String id) {
		return	dvdControl(id,8);
	}

	@Override
	public ExcuteResultVO dvdRight(String id) {
		return	dvdControl(id,9);
	}

	@Override
	public ExcuteResultVO dvdUP(String id) {
		return	dvdControl(id,10);
	}

	@Override
	public ExcuteResultVO dvdtitle(String id) {
		return	dvdControl(id,11);
	}

	@Override
	public ExcuteResultVO dvdChannelAdd(String id) {
		return	dvdControl(id,12);
	}

	@Override
	public ExcuteResultVO dvdChannelSubtract(String id) {
		return	dvdControl(id,13);
	}

	@Override
	public ExcuteResultVO dvdDdd(String id) {
		return	dvdControl(id,14);
	}

	@Override
	public ExcuteResultVO dvdDvd(String id) {
		return	dvdControl(id,15);
	}

	@Override
	public ExcuteResultVO dvdForward(String id) {
		return	dvdControl(id,16);
	}

	@Override
	public ExcuteResultVO dvdInput(String id) {
		return	dvdControl(id,17);
	}

	@Override
	public ExcuteResultVO dvdMainMenu(String id) {
		return	dvdControl(id,18);
	}

	@Override
	public ExcuteResultVO dvdNext(String id) {
		return	dvdControl(id,19);
	}

	@Override
	public ExcuteResultVO dvdPause(String id) {
		return	dvdControl(id,20);
	}

	@Override
	public ExcuteResultVO dvdPlay(String id) {
		return	dvdControl(id,21);
	}

	@Override
	public ExcuteResultVO dvdPrev(String id) {
		return	dvdControl(id,22);
	}

	@Override
	public ExcuteResultVO dvdRec(String id) {
		return	dvdControl(id,23);
	}

	@Override
	public ExcuteResultVO dvdReverse(String id) {
		return	dvdControl(id,24);
	}

	@Override
	public ExcuteResultVO dvdStop(String id) {
		return	dvdControl(id,25);
	}

	@Override
	public ExcuteResultVO dvdStopRec(String id) {
		return	dvdControl(id,26);
	}
	
	@Override
	public ExcuteResultVO dvdPower(String id) {
		return	dvdControl(id,27);
	}

	@Override
	public ExcuteResultVO videomModel(String id, String num) {
		if(id==null||id.length()==0) id = def_ID;
		 
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		VideomVO vo = CenterControlObjectHelp.getVideomList(this.centerControlIp).get(id);
		if(vo==null){
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		String command = ControlCommandHelp.VIDEOM_MODEL[0];
		command = command.replaceFirst("##1",id);
		command = command.replaceFirst("##2",num);
		resultVO = this.sendCommand(command);
		if(resultVO.isSuccess()){
			vo.setModleID(num);	
			resultVO.setObject(vo);
		}
		return	resultVO;
	}

	@Override
	public ExcuteResultVO videomModelInfo(String id, String model, String num, String num2) {
		resultVO.setSuccess(false);
		resultVO.setDes(support);
		return resultVO;
	}
	
	/**
	 * 检查dvd设备是否在线、检查设备是否存在
	 * @param id
	 * @return
	 */
//	private boolean checkDVD(String id){
//		if(!status_on.equalsIgnoreCase(this.status)){
//			resultVO.setSuccess(false);
//			resultVO.setDes(ip_reachable);
//			return true;
//		}
//		
//		DvdVO cv = CenterControlObjectHelp.getDvdList(this.centerControlIp).get(id);
//		if(cv==null){
//			resultVO.setSuccess(false);
//			resultVO.setDes(vo_reachable);
//			return true;
//		}
//		return false;
//	}
	
	
	/**
	 * 提取中控--相关设备
	 * @param vo
	 * @return
	 */
	private static void initCenterControl(CenterControlVO vo){
		
		try{
			ArrayList<CenterControlVO> list = CCEquipmentDAO.getCCequipmentList(vo.getIp());
			ArrayList<AudioControlVO> audioList = new ArrayList<AudioControlVO>();
			ArrayList<ViewScreentVO> viewScreenList = new ArrayList<ViewScreentVO>();
			ArrayList<SysPowerVO> sysPowerList = new ArrayList<SysPowerVO>();
			ArrayList<MatrixSwitchVO> matrixSwitchList = new ArrayList<MatrixSwitchVO>();
			ArrayList<CameraVO> cameraList = new ArrayList<CameraVO>();
			ArrayList<PlaVO> plaList = new ArrayList<PlaVO>();
			ArrayList<UpDownScreenVO> upDownScreenList = new ArrayList<UpDownScreenVO>();
			ArrayList<LightVO> lightList = new ArrayList<LightVO>();
			ArrayList<DvdVO> dvdList = new ArrayList<DvdVO>();
			ArrayList<ProjVO> projList = new ArrayList<ProjVO>();
			ArrayList<TvVO> tvList = new ArrayList<TvVO>();
			//窗帘
			ArrayList<CurtainVO> curtainList = new ArrayList<CurtainVO>();
			//画面分割器
			ArrayList<VideomVO> videomList = new ArrayList<VideomVO>();
			//会议室组合键
			ArrayList<RoomModelVO> RoomModelList = new ArrayList<RoomModelVO>();
			
			//HashMap<String,String> screenViewMap = new HashMap<String,String>();
			
			//"3#5#203#view1#0,0,3,3;3#5#203#view2#0,3,2,2"
			
			for(CenterControlVO evo : list){
				if(CenterControlObjectHelp.control_type_roomModel.equalsIgnoreCase(evo.getEquipmentType())){
					RoomModelList.add(initRoomModelDate(evo));
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_roomModel);
				}else if(CenterControlObjectHelp.control_type_audio.equalsIgnoreCase(evo.getEquipmentType())){
					AudioControlVO av = new AudioControlVO();
					av.setId(evo.getCcNO());
					av.setIp(evo.getEquipmentIP());
					av.setName(evo.getEuipmentName());
					audioList.add(av);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_audio);
				}else if(CenterControlObjectHelp.control_type_matrix.equalsIgnoreCase(evo.getEquipmentType())){
					matrixSwitchList.add(initMatrixDate(evo));
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_matrix);
				}else if(CenterControlObjectHelp.control_type_screent.equalsIgnoreCase(evo.getEquipmentType())){
					viewScreenList.add(initScreenDate(evo));
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_screent);
//				}else if(CenterControlObjectHelp.control_type_screent_view.equalsIgnoreCase(evo.getEquipmentType())){
//					initScreenViewDate(screenViewMap,evo);
					//不再实现，已经集成到control_type_screent内
					//已经调整到加载中控时，加载改数据
				}else if(CenterControlObjectHelp.control_type_sysPower.equalsIgnoreCase(evo.getEquipmentType())){
					SysPowerVO sv = new SysPowerVO();
					sv.setId(evo.getCcNO());
					sv.setName(evo.getEuipmentName());
					sv.setIp(evo.getEquipmentIP());
					sysPowerList.add(sv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_sysPower);
				}else if(CenterControlObjectHelp.control_type_vedioTerminal.equalsIgnoreCase(evo.getEquipmentType())){
					
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_vedioTerminal);
				}else if(CenterControlObjectHelp.control_type_camera.equalsIgnoreCase(evo.getEquipmentType())){
					CameraVO cv = new CameraVO();
					cv.setId(evo.getCcNO());
					cv.setName(evo.getEuipmentName());
					String initDate = evo.getControlInitDate();
					if(initDate!=null&&initDate.length()>0){
						String[] option = initDate.split(";");
						if("0".equalsIgnoreCase(option[0]))//是否支持自动跟踪
							cv.setStatusAutoTrack(true);
						String[][] str = new String[option.length-1][2];//预置位列表
						for(int i=1;i<option.length;i++){
							String[] ss = option[i].split("-");
							if(ss.length==2){
								str[i-1][0]=ss[0];
								str[i-1][1]=ss[1];	
							}
						}
						cv.setStoreAll(str);
					}
					cameraList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_camera);
				}else if(CenterControlObjectHelp.control_type_pla.equalsIgnoreCase(evo.getEquipmentType())){
					PlaVO cv = initPlaDate(evo);
					plaList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_pla);
				}else if(CenterControlObjectHelp.control_type_upDownScreen.equalsIgnoreCase(evo.getEquipmentType())){
					UpDownScreenVO cv = new UpDownScreenVO();
					cv.setId(evo.getCcNO());
					cv.setName(evo.getEuipmentName());
					upDownScreenList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_upDownScreen);
				}else if(CenterControlObjectHelp.control_type_light.equalsIgnoreCase(evo.getEquipmentType())){
					LightVO cv = new LightVO();
					cv.setId(evo.getCcNO());
					cv.setName(evo.getEuipmentName());
					lightList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_light);
				}else if(CenterControlObjectHelp.control_type_dvd.equalsIgnoreCase(evo.getEquipmentType())){
					DvdVO cv = new DvdVO();
					cv.setId(evo.getCcNO());
					cv.setName(evo.getEuipmentName());
					dvdList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_dvd);
				}else if(CenterControlObjectHelp.control_type_proj.equalsIgnoreCase(evo.getEquipmentType())){
					ProjVO cv = new ProjVO();
					cv.setId(evo.getCcNO());
					cv.setName(evo.getEuipmentName());
					projList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_proj);
				}else if(CenterControlObjectHelp.control_type_curtain.equalsIgnoreCase(evo.getEquipmentType())){
					CurtainVO cv = new CurtainVO();
					cv.setId(evo.getCcNO());
					cv.setName(evo.getEuipmentName());
					curtainList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_curtain);
				}else if(CenterControlObjectHelp.control_type_tv.equalsIgnoreCase(evo.getEquipmentType())){
					TvVO cv = new TvVO();
					cv.setId(evo.getCcNO());
					cv.setName(evo.getEuipmentName());
					tvList.add(cv);
					CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_tv);
				}else if(CenterControlObjectHelp.control_type_videom.equalsIgnoreCase(evo.getEquipmentType())){
					VideomVO cv = initVideomDate(evo);
					if(cv!=null){
						videomList.add(cv);
						CenterControlObjectHelp.addEquipment(CenterControlObjectHelp.control_type_videom);
					}
				}
			}
			logger.info("中控（"+vo.getIp()+"）初始化设备总数："+list.size()+"：：：：摄像头个数："+cameraList.size()+"矩阵个数："+matrixSwitchList.size()+"音频设备个数："+audioList.size()+"系统电源个数："+sysPowerList.size()+"大屏个数："+viewScreenList.size()+"等离子个数："+plaList.size()+"升降屏个数："+upDownScreenList.size()+"灯光个数："+lightList.size()+"DVD个数："+dvdList.size()+"投影机个数："+projList.size()+"窗帘个数："+curtainList.size()+"机顶盒个数："+tvList.size()+"画面分割器个数："+videomList.size()+"会议室组合键个数："+RoomModelList.size());
			
			CenterControlObjectHelp.initMatrixDate(vo.getIp(), matrixSwitchList);
			CenterControlObjectHelp.initAudioDate(vo.getIp(), audioList);
			CenterControlObjectHelp.initCameraDate(vo.getIp(), cameraList);
			CenterControlObjectHelp.initSysPowerDate(vo.getIp(), sysPowerList);
			CenterControlObjectHelp.initViewScreentDate(vo.getIp(), viewScreenList);
//			CenterControlObjectHelp.initViewScreentViewDate(vo.getIp(), screenViewMap);
			CenterControlObjectHelp.initPlaDate(vo.getIp(), plaList);
			CenterControlObjectHelp.initUpDownScreenDate(vo.getIp(), upDownScreenList);
			CenterControlObjectHelp.initLightDate(vo.getIp(), lightList);
			CenterControlObjectHelp.initDVDDate(vo.getIp(), dvdList);
			CenterControlObjectHelp.initProjDate(vo.getIp(), projList);
			CenterControlObjectHelp.initCurtainDate(vo.getIp(), curtainList);
			CenterControlObjectHelp.initTvDate(vo.getIp(), tvList);
			CenterControlObjectHelp.initVideomDate(vo.getIp(), videomList);
			CenterControlObjectHelp.initRoomModelDate(vo.getIp(), RoomModelList);
			
			//加载所有大屏的显示样式；
			list = CCEquipmentDAO.getScreenViewList();
			ArrayList<ViewScreentViewVO> viList = new ArrayList<ViewScreentViewVO>();
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					String initViewDate = list.get(i).getControlInitDate();
					if(initViewDate!=null&&initViewDate.length()>0){
						String[]  viewInfo = initViewDate.split(";");
						for(int j=0;j<viewInfo.length;j++){
							ViewScreentViewVO vsvVO = new ViewScreentViewVO();
							String s = viewInfo[j];
							String[] key = s.substring(0, s.lastIndexOf("#")).split("#");
							vsvVO.setModel(key[0]+"*"+key[1]+"*"+key[2]);
							vsvVO.setId(key[3]);
							
							String[] x_y  = s.substring(s.lastIndexOf("#")+1,s.length()).split(",");
							vsvVO.setTop(x_y[0]);
							vsvVO.setLeft(x_y[1]);
							vsvVO.setHeight(x_y[2]);
							vsvVO.setWidth(x_y[3]);
							viList.add(vsvVO);
						}
					}
				}
			}
			CenterControlObjectHelp.initViewScreentViewDate(viList);
		}catch(Exception e){
			logger.error("加载控制设备异常："+e.getMessage());
		}
	}
	
//	private static HashMap<String,String> initScreenViewDate(ViewScreentVO v,CenterControlVO vo){
//		String initDate = vo.getControlInitDate();
//		if(initDate!=null&&initDate.length()>0){
//			String[]  viewInfo = initDate.split(";");
//			for(String s : viewInfo){
//				
//				map.put(s.substring(0, s.lastIndexOf("#")), s.substring(s.lastIndexOf("#")+1,s.length()));
//			}
//		}
//		return map;
//	}
	
	private static RoomModelVO initRoomModelDate(CenterControlVO evo){
		RoomModelVO cv = new RoomModelVO();
		try{
			cv.setId(evo.getCcNO());
			cv.setName(evo.getEuipmentName());
			String[][] modelList = null;
			String initDate = evo.getControlInitDate();
			if(initDate!=null&&initDate.length()>0){
				String[] oneModel = initDate.split(";");
				//1-视频会议;2-本地会议
				if(oneModel!=null&&oneModel.length>0){
					modelList = new String[oneModel.length][2];
					try{
						for(int i=0;i<oneModel.length;i++ ){
							String[] oneModelInfo = oneModel[i].split("-");
							modelList[i][0] = oneModelInfo[0];
							modelList[i][1] = oneModelInfo[1];
						}
					}catch(Exception e){
						logger.error("解析会议室组合键-详细信息时异常："+e.getMessage());
					}
				}
				cv.setModelList(modelList);
				return cv;
			}
		}catch(Exception e){
			logger.error("加载会议室组合键时异常："+e.getMessage());
		}
		return null;
	}
	
	private static PlaVO initPlaDate(CenterControlVO evo){
		PlaVO cv = new PlaVO();
		try{
			cv.setId(evo.getCcNO());
			cv.setName(evo.getEuipmentName());
			String[][] channelList = null;
			String initDate = evo.getControlInitDate();
			if(initDate!=null&&initDate.length()>0){
				
				String[] oneModel = initDate.split(";");
				//1-PC;2-RGB
				if(oneModel!=null&&oneModel.length>0){
					channelList = new String[oneModel.length][2];
					try{
						for(int i=0;i<oneModel.length;i++ ){
							String[] oneModelInfo = oneModel[i].split("-");
							channelList[i][0] = oneModelInfo[0];
							channelList[i][1] = oneModelInfo[1];
						}
					}catch(Exception e){
						logger.error("加载等离子频道基础数据时异常："+e.getMessage());
					}
				}
				cv.setChannelList(channelList);
				return cv;
			}else{
				logger.info("没有配置等离子频道基础数据");
			}
		}catch(Exception e){
			logger.error("加载等离子频道基础数据时异常："+e.getMessage());
		}
		return cv;
	}
	
	
	private static VideomVO initVideomDate(CenterControlVO evo){
		VideomVO cv = new VideomVO();
		try{
			cv.setId(evo.getCcNO());
			cv.setName(evo.getEuipmentName());
			String[][] modelList = null;
			String initDate = evo.getControlInitDate();
			if(initDate!=null&&initDate.length()>0){
				String[] oneModel = initDate.split(";");
				//1-画面分割器-RGB;2-画面分割器-AV
				if(oneModel!=null&&oneModel.length>0){
					modelList = new String[oneModel.length][3];
					try{
						for(int i=0;i<oneModel.length;i++ ){
							String[] oneModelInfo = oneModel[i].split("-");
							modelList[i][0] = oneModelInfo[0];
							modelList[i][1] = oneModelInfo[1];
							modelList[i][2] = oneModelInfo[2];
						}
					}catch(Exception e){
						logger.error("加载画面分割器某个模式时异常："+e.getMessage());
					}
				}
				cv.setModelList(modelList);
				return cv;
			}
		}catch(Exception e){
			logger.error("加载画面分割器基础数据时异常："+e.getMessage());
		}
		return null;
	}
	
	private static ViewScreentVO initScreenDate(CenterControlVO vo){
		ViewScreentVO vsv = new ViewScreentVO();
		try{
			vsv.setId(vo.getCcNO());
			vsv.setName(vo.getEuipmentName());
			String[][] allModel = null;
			Map<String ,String> allModelSwitchOutPort = new HashMap<String,String>();
			Map<String ,String> allModelType = new HashMap<String,String>();
			Map<String ,String> allModelSwitchOutPortType = new HashMap<String,String>();
			
			String initDate = vo.getControlInitDate();
			if(initDate!=null&&initDate.length()>0){
				String[] oneModel = initDate.split(";");
				//;3#5#203#AV-PC-7#AV,8#AV
				if(oneModel!=null&&oneModel.length>0){
					allModel = new String[oneModel.length][2];
					for(int i=0;i<oneModel.length;i++ ){
						String[] ss = oneModel[i].split("-");
						if(ss.length!=3) continue;
						String [] modelStr= ss[0].split("#");
						vsv.setModelNum(modelStr[0]+"*"+modelStr[1]);
						vsv.setSwitchType(modelStr[4]);
						allModelType.put(modelStr[2]+modelStr[3], modelStr[3]);
						
						allModel[i][0] = modelStr[2]+"-"+modelStr[3];
						allModel[i][1] = ss[1];
						String[] outStr = ss[2].split(",");
						String outPortStr="";
						String outPortTypeStr="";
						for(String s :outStr){
							outPortStr += s.split("#")[0]+",";
							outPortTypeStr += s.split("#")[1]+",";
						}
						allModelSwitchOutPort.put(modelStr[2]+modelStr[3], outPortStr);
						allModelSwitchOutPortType.put(modelStr[2]+modelStr[3], outPortTypeStr);
//						logger.info(ss[0]+"==="+ss[1]+"--------"+ss[2]+"------"+modelStr[0]+"*"+modelStr[1]+"==="+modelStr[2]+"---"+modelStr[3]);
					}
				}
			}
			vsv.setAllModelSwitchOutPortType(allModelSwitchOutPortType);
			vsv.setAllModelType(allModelType);
			vsv.setAllModel(allModel);
			vsv.setAllModelSwitchOutPort(allModelSwitchOutPort);

//			ArrayList<CenterControlVO> list = CCEquipmentDAO.getScreenViewList(vo.getIp());
//			ArrayList<ViewScreentViewVO> viewList = new ArrayList<ViewScreentViewVO>();
//			if(list!=null&&list.size()>0){
////				logger.info(vo.getIp()+"ip:::::::"+list.size());
//				for(int i=0;i<list.size();i++){
//					String initViewDate = list.get(i).getControlInitDate();
//					if(initViewDate!=null&&initViewDate.length()>0){
//						String[]  viewInfo = initViewDate.split(";");
//						for(int j=0;j<viewInfo.length;j++){
//							ViewScreentViewVO vsvVO = new ViewScreentViewVO();
//							String s = viewInfo[j];
//							String[] key = s.substring(0, s.lastIndexOf("#")).split("#");
//							vsvVO.setModel(key[0]+"*"+key[1]+"*"+key[2]);
//							vsvVO.setId(key[3]);
//							
//							String[] x_y  = s.substring(s.lastIndexOf("#")+1,s.length()).split(",");
//							vsvVO.setTop(x_y[0]);
//							vsvVO.setLeft(x_y[1]);
//							vsvVO.setHeight(x_y[2]);
//							vsvVO.setWidth(x_y[3]);
//							viewList.add(vsvVO);
////							logger.info(vo.getIp()+"ip:::::::"+vsvVO.getModel()+"=="+vsvVO.getId()+"=="+vsvVO.getLeft()+"=="+vsvVO.getWidth());
//							//map.put(s.substring(0, s.lastIndexOf("#")), s.substring(s.lastIndexOf("#")+1,s.length()));
//						}
//					}
//				}
//			}
//			//ArrayList<ViewScreentViewVO>
////			for(ViewScreentViewVO voaaa : viewList){
////				logger.info(vo.getIp()+":::::"+voaaa.getModel()+"=="+voaaa.getId()+"==="+""+voaaa.getWidth()+"---"+voaaa.getHeight()+"=="+voaaa.getViewStr());
////			}
//			vsv.setModelViewList(viewList);
		}catch(Exception e){
			logger.error("加载大屏基础数据时异常："+e.getMessage());
		}
		return vsv;
	}
	
	
	private static MatrixSwitchVO initMatrixDate(CenterControlVO vo){
		MatrixSwitchVO mv = new MatrixSwitchVO();
		try{
			String[][] in = null;
			String[][] out = null;
			String initDate = vo.getControlInitDate();
			if(initDate!=null&&initDate.length()>0){
				//int inNum = initDate.indexOf("in:");
				int outNum = initDate.indexOf("out:");
				String inStr = initDate.substring(3, outNum);
				String outStr = initDate.substring(outNum+4,initDate.length());
				if(inStr!=null&&inStr.length()>0){
					String[] s = inStr.split(";");
					in = new String[s.length][2];
					for(int i=0;i<s.length;i++){
						String[] str = s[i].split("-");
						if(str==null||str.length!=2) continue;
						in[i][0] = str[0];
						in[i][1] = str[1];
					}
				}
				
				if(outStr!=null&&outStr.length()>0){
					String[] s = outStr.split(";");
					out = new String[s.length][2];
					for(int i=0;i<s.length;i++){
						String[] str = s[i].split("-");
						if(str==null||str.length!=2) continue;
						out[i][0] = str[0];
						out[i][1] = str[1];
					}
				}
			}
			mv.setId(vo.getCcNO());
			mv.setIp(vo.getEquipmentIP());
			mv.setName(vo.getEuipmentName());
			mv.setIn(in);
			mv.setOut(out);
		}catch(Exception e){
			logger.error("加载矩阵基础数据时异常："+e.getMessage());
		}
		return mv;
	}

	@Override
	public ExcuteResultVO viewModelInfo(String id, String no, String sourceName) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		ViewScreentVO vv = CenterControlObjectHelp.getViewScreentList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new VeiwScreetnImpl(this.centerControlIp,this.centerControlProt,vv).setModelInfo(id, no, sourceName);
	}

	@Override
	public ExcuteResultVO projGetPowerStatus(String id) {
		return projControl(id,2);
 	}

	@Override
	public ExcuteResultVO projLightUseTime(String id) {
		return null;
	}

	@Override
	public ExcuteResultVO projPowerOff(String id) {
		return projControl(id,3);
	}

	@Override
	public ExcuteResultVO projPowerOn(String id) {
		return projControl(id,4);
	}

	@Override
	public ExcuteResultVO projSetPowerDisplay(String id, String type) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		ProjVO vv = CenterControlObjectHelp.getProjList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new ProjImpl(this.centerControlIp,this.centerControlProt,vv).powerDisplay(id, type);
	}

	private ExcuteResultVO projControl(String id,int str){
		if(id==null||id.length()==0) id = def_ID;
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		try{
			ProjVO vv = CenterControlObjectHelp.getProjList(this.centerControlIp).get(id);
			if(vv==null)  {
				resultVO.setSuccess(false);
				resultVO.setDes(vo_reachable);
				return resultVO;
			}
		
			switch(str){
				case 1:		return new ProjImpl(this.centerControlIp,this.centerControlProt,vv).powerDisplay(id);
				case 2:		return new ProjImpl(this.centerControlIp,this.centerControlProt,vv).getPowerStatus(id);
				case 3:		return new ProjImpl(this.centerControlIp,this.centerControlProt,vv).powerOff(id);
				case 4:		return new ProjImpl(this.centerControlIp,this.centerControlProt,vv).powerOn(id);
				default:	resultVO.setSuccess(false);return resultVO;
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	@Override
	public ExcuteResultVO projGetPowerDisplay(String id) {
		return projControl(id,1);
	}
	
	@Override
	public ExcuteResultVO projUseTime(String id) {
		return null;
	}

	@Override
	public ExcuteResultVO curtainClose(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		CurtainVO vv = CenterControlObjectHelp.getCurtainList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new CurtainImpl(this.centerControlIp,this.centerControlProt, vv).curtainClose(id);
	}

	@Override
	public ExcuteResultVO curtainOpen(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		CurtainVO vv = CenterControlObjectHelp.getCurtainList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new CurtainImpl(this.centerControlIp,this.centerControlProt, vv).curtainOpen(id);
	}

	@Override
	public ExcuteResultVO curtainStop(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		CurtainVO vv = CenterControlObjectHelp.getCurtainList(this.centerControlIp).get(id);
		if(vv==null)  {
			resultVO.setSuccess(false);
			resultVO.setDes(vo_reachable);
			return resultVO;
		}
		return new CurtainImpl(this.centerControlIp,this.centerControlProt, vv).curtainStop(id);
	}

	@Override
	public ExcuteResultVO tvMenu(String id) {
		return tvControl(id,1);
	}

	@Override
	public ExcuteResultVO tvMute(String id) {
		return tvControl(id,2);
	}

	@Override
	public ExcuteResultVO tvMuteDown(String id) {
		return tvControl(id,3);
	}

	@Override
	public ExcuteResultVO tvMuteUp(String id) {
		return tvControl(id,4);
	}

	@Override
	public ExcuteResultVO tvNum(String id, int num) {
		if(id==null||id.length()==0) id = def_ID;
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}

		String command = ControlCommandHelp.TV_NUMBER[0].replaceFirst("##1",id);
		command = command.replaceFirst("##2",num+"");
     	return	this.sendCommand(command);
	}

	@Override
	public ExcuteResultVO tvPinDaoDown(String id) {
		return tvControl(id,5);
	}

	@Override
	public ExcuteResultVO tvPinDaoUp(String id) {
		return tvControl(id,6);
	}

	@Override
	public ExcuteResultVO tvPower(String id) {
		return tvControl(id,7);
	}
	
	private ExcuteResultVO tvControl(String id,int str){
		if(id==null||id.length()==0) id = def_ID;
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		
		try{
			TvVO cv = CenterControlObjectHelp.getTvList(this.centerControlIp).get(id);
			if(cv==null){
				resultVO.setSuccess(false);
				resultVO.setDes(vo_reachable);
				return resultVO;
			}
		
			switch(str){
				case 1:		return	this.sendCommand(ControlCommandHelp.TV_MENU[0].replaceFirst("##1",id));
				case 2:		return	this.sendCommand(ControlCommandHelp.TV_MUTE[0].replaceFirst("##1",id));
				case 3:		return	this.sendCommand(ControlCommandHelp.TV_MUTE_DOWN[0].replaceFirst("##1",id));
				case 4:		return	this.sendCommand(ControlCommandHelp.TV_MUTE_UP[0].replaceFirst("##1",id));
				case 5:		return	this.sendCommand(ControlCommandHelp.TV_PINDAO_DOWN[0].replaceFirst("##1",id));
				case 6:		return	this.sendCommand(ControlCommandHelp.TV_PINDAO_UP[0].replaceFirst("##1",id));
				case 7:		return	this.sendCommand(ControlCommandHelp.TV_POWER[0].replaceFirst("##1",id));
				default:	resultVO.setSuccess(false);return resultVO;
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}

	@Override
	public ExcuteResultVO projGroupPowerOff(String[] ids) {
		resultVO.setSuccess(true);
		for(String s : ids){
			ExcuteResultVO reVO = projPowerOff(s);
			if(!reVO.isSuccess())
				resultVO = reVO;
		}
		return resultVO;
	}

	@Override
	public ExcuteResultVO projGroupPowerOn(String[] ids) {
		resultVO.setSuccess(true);
		for(String s : ids){
			ExcuteResultVO reVO = projPowerOn(s);
			if(!reVO.isSuccess())
				resultVO = reVO;
		}
		return resultVO;
	}

	@Override
	public ExcuteResultVO cameraBackLight(String id, boolean b) {
		return cameraControl2(id,b,1);
	}

	@Override
	public ExcuteResultVO cameraBackLightStatus(String id) {
		 return cameraControl(id,9,true);
	}

	@Override
	public ExcuteResultVO cameraExposureManuaIris(String id, String liris) {
		return cameraControl2(id,liris,2);
	}

	@Override
	public ExcuteResultVO cameraExposureManual(String id, boolean b) {
		return cameraControl2(id,b,3);
	}

	@Override
	public ExcuteResultVO cameraExposureManualGain(String id, int gain) {
		return cameraControl2(id,gain,4);
	}

	@Override
	public ExcuteResultVO cameraExposureManualSpeed(String id, String speed) {
		return cameraControl2(id,speed,5);
	}

	@Override
	public ExcuteResultVO cameraExposureManualStatus(String id) {
		return cameraControl(id,10,true);
	}

	@Override
	public ExcuteResultVO cameraWhiteBalanceManual(String id, boolean b) {
		return cameraControl2(id,b,6);
	}

	@Override
	public ExcuteResultVO cameraWhiteBalanceManualB(String id, int b) {
		return cameraControl2(id,b,7);
	}

	@Override
	public ExcuteResultVO cameraWhiteBalanceManualR(String id, int r) {
		return cameraControl2(id,r,8);
	}

	@Override
	public ExcuteResultVO cameraWhiteBalanceManualStatus(String id) {
		return cameraControl(id,16,true);
	}

	@Override
	public ExcuteResultVO getEquipmentStatus(String id) {
		if(!status_on.equalsIgnoreCase(this.status)){
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return resultVO;
		}
		try {
			String command = ControlCommandHelp.EQUIPMENT_STATUS.replaceFirst("##1",id);
			if(new CenterControlClientThread(this.getIP(),this.getPort()).sendCommand(command)){
				resultVO.setSuccess(true);
			}else{
				resultVO.setSuccess(false);
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.error("getEquipmentStatus:"+e.getMessage());
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	/**
	 *  取会议室组合键列表。已经废弃，不再使用 modify 20140709,统一使用getRoomModelList()这个方法
	 */
	@Override
	public ExcuteResultVO getRoomModelList(String id) {
		try{
			RoomModelVO av = CenterControlObjectHelp.getRoomModelVOList(this.centerControlIp).get(id);
			if(av!=null){
				if(av.getModelList()!=null){
					resultVO.setSuccess(true);
					resultVO.setObject(av);
				}else{
					resultVO.setDes("没有模式");
				}
			}else{
				resultVO.setDes("对象为空");
			}
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
}