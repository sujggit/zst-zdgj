package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description 摄像机控制实现类
 *@date 2012-10-15下午04:36:16
 *@author ryan
 */
public class ProjImpl {

	private static Logger logger = Logger.getLogger(ProjImpl.class
			.getName());
	
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private	ProjVO projVO;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public ProjImpl(String ip,int port,ProjVO projVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.projVO = projVO;
	}
	
	public ExcuteResultVO getPowerStatus(String id) {
		logger.info("投影机设备：ProjImpl		getPowerStatus		begin");
		String command  = ControlCommandHelp.PROJ_STATUS[0].replaceFirst("##1",projVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("投影机设备：提取状态异常："+e.getMessage());
		}
		resultVO.setObject(projVO);
		logger.info("投影机设备：ProjImpl		getPowerStatus		end");
		return resultVO;
	}

	public ExcuteResultVO lightUseTime(String id) {
		logger.info("投影机设备未实现：ProjImpl		getPowerStatus		begin");
		return null;
	}

	public ExcuteResultVO powerOff(String id) {
		logger.info("投影机设备：ProjImpl		powerOff		begin");
		String command  = ControlCommandHelp.PROJ_POWER_OFF[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				projVO.setStatus(ProjVO.status_off);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("投影机设备异常："+e.getMessage());
		}
		resultVO.setObject(projVO);
		logger.info("投影机设备：ProjImpl		powerOff		end");
		return resultVO;
	}

	public ExcuteResultVO powerOn(String id) {
		logger.info("投影机设备：ProjImpl		powerOn		begin");
		String command  = ControlCommandHelp.PROJ_POWER_ON[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				projVO.setStatus(ProjVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("投影机设备异常："+e.getMessage());
		}
		resultVO.setObject(projVO);
		logger.info("投影机设备：ProjImpl		powerOn		end");
		return resultVO;
	}

	public ExcuteResultVO powerDisplay(String id, String type) {
		logger.info("投影机设备：ProjImpl		powerDisplay		begin");
		String command  = ControlCommandHelp.PROJ_DISPLAY_TYPE[0].replaceFirst("##1",id);
		command  = command.replaceFirst("##2",type);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				projVO.setDisplay_type(type);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("投影机设备异常："+e.getMessage());
		}
		resultVO.setObject(projVO);
		logger.info("投影机设备：ProjImpl		powerDisplay		end");
		return resultVO;
	}

	public ExcuteResultVO powerDisplay(String id) {
		logger.info("投影机设备：ProjImpl		powerDisplay		begin");
		String command  = ControlCommandHelp.PROJ_STATUS_DISPLAY[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("投影机设备异常："+e.getMessage());
		}
		resultVO.setObject(projVO);
		logger.info("投影机设备：ProjImpl		powerDisplay		end");
		return resultVO;
	}
	
	public ExcuteResultVO useTime(String id) {
		logger.info("投影机设备未实现：ProjImpl		powerDisplay		beginw");
		return resultVO;
	}
}
