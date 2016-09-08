package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	系统电源
 *@date 2011-12-26上午11:53:18
 *@author ryan
 */
public class SysPowerImpl {
	private static Logger logger = Logger.getLogger(SysPowerImpl.class
			.getName());
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private SysPowerVO sysPowerVO;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public SysPowerImpl(String ip,int port,SysPowerVO vo){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.sysPowerVO = vo;
	}
	

	public ExcuteResultVO sysPowerOff() {
		logger.info("系统电源设备：SysPowerImpl 	sysPowerOff		begin");
		String command  = ControlCommandHelp.POWER_OFF[0].replaceFirst("##1", sysPowerVO.getId());
		/*String no = sysPowerVO.getId();
		String command = null;
		if("001".equals(no)){
			command = "00_97";
		}if("002".equals(no)){
			command = "00_9C";
		}*/
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				sysPowerVO.setStatus(SysPowerVO.status_off);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(sysPowerVO);
		logger.info("系统电源设备：SysPowerImpl	sysPowerOff		end");
		return resultVO;
	}


	public ExcuteResultVO sysPowerOn() {
		logger.info("系统电源设备：SysPowerImpl	sysPowerOn	begin");
		/*String no = sysPowerVO.getId();
		String command = null;
		if("001".equals(no)){
			command = "00_96";
		}if("002".equals(no)){
			command = "00_9B";
		}*/
		String command  = (ControlCommandHelp.POWER_ON)[0].replaceFirst("##1", sysPowerVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				sysPowerVO.setStatus(SysPowerVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(sysPowerVO);
		logger.info("系统电源设备：SysPowerImpl	sysPowerOn	end");
		return resultVO;
	}


	public ExcuteResultVO sysPowerStatus() {
		logger.info("系统电源设备：SysPowerImpl	sysPowerStatus	begin");
		String command  = ControlCommandHelp.POWER_STATUS[0].replaceFirst("##1", sysPowerVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(sysPowerVO);
		logger.info("系统电源设备：SysPowerImpl	sysPowerStatus	end");
		return resultVO;
	}
	
	
}
