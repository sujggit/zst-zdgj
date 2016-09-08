package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.CurtainVO;
import com.zzst.centerContor.vo.LightVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	灯光控制
 *@date 2012-2-28下午05:39:40
 *@author ryan
 */
public class LightImpl {

	private static Logger logger = Logger.getLogger(LightImpl.class
			.getName());
	
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private	LightVO lightVO;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public LightImpl(String ip,int port,LightVO lightVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.lightVO = lightVO;
	}
	 
	/**
	 * 开
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO lightON(String id){
		logger.info("灯光设备：LightImpl		lightON		begin");
		String command  = ControlCommandHelp.LIGHT_ON[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				lightVO.setStatus(LightVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("灯光开异常："+e.getMessage());
		}
		resultVO.setObject(lightVO);
		logger.info("灯光设备：LightImpl		lightON		end");
		return resultVO;
	}
	
	/**
	 * 关
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO lightOFF(String id){
		logger.info("灯光设备：LightImpl		lightOFF		begin");
		String command  = ControlCommandHelp.LIGHT_OFF[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				lightVO.setStatus(LightVO.status_off);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("灯光关异常："+e.getMessage());
		}
		resultVO.setObject(lightVO);
		logger.info("灯光设备：LightImpl		lightOFF		end");
		return resultVO;
	}
	
	/**
	 * 当前开关状态
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO lightStatus(String id){
		logger.info("灯光设备：LightImpl		lightStatus		begin");
		String command  = ControlCommandHelp.LIGHT_STATUS[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("灯光关异常："+e.getMessage());
		}
		resultVO.setObject(lightVO);
		logger.info("灯光设备：LightImpl		lightStatus		end");
		return resultVO;
	}
}
