package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.UpDownScreenVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	升降屏控制
 *@date 2012-2-28上午10:39:04
 *@author ryan
 */
public class UpDownScreenImpl {
	private static Logger logger = Logger.getLogger(UpDownScreenImpl.class
			.getName());
	
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private	UpDownScreenVO upDownScreenVO;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public UpDownScreenImpl(String ip,int port,UpDownScreenVO upDownScreenVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.upDownScreenVO = upDownScreenVO;
	}
	
	/**
	 * 升 
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO screenUP(String id){
		logger.info("升降屏设备：UpDownScreenImpl		screenUP		begin");
		String command  = ControlCommandHelp.UPDOWN_SCREEN_UP[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				upDownScreenVO.setStatus(UpDownScreenVO.status_up);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("升降屏升异常："+e.getMessage());
		}
		resultVO.setObject(upDownScreenVO);
		logger.info("升降屏设备：UpDownScreenImpl		screenUP		end");
		return resultVO;
	}
	
	/**
	 * 降
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO screenDown(String id){
		logger.info("升降屏设备：UpDownScreenImpl		screenDown		begin");
		String command  = ControlCommandHelp.UPDOWN_SCREEN_DOWN[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				upDownScreenVO.setStatus(UpDownScreenVO.status_down);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("升降屏全降异常："+e.getMessage());
		}
		resultVO.setObject(upDownScreenVO);
		logger.info("升降屏设备：UpDownScreenImpl		screenDown		end");
		return resultVO;
	}
	
	/**
	 * 降
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO screenStatus(String id){
		logger.info("升降屏设备：UpDownScreenImpl		screenStatus		begin");
		String command  = ControlCommandHelp.UPDOWN_SCREEN_STATUS[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("升降屏全降异常："+e.getMessage());
		}
		resultVO.setObject(upDownScreenVO);
		logger.info("升降屏设备：UpDownScreenImpl		screenStatus		end");
		return resultVO;
	}
}
