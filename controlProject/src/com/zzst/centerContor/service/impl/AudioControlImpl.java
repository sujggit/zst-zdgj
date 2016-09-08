package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.AudioControlVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	音频设备控制
 *@date 2011-12-20下午04:09:30
 *@author ryan
 */
public class AudioControlImpl {
	private static Logger logger = Logger.getLogger(AudioControlImpl.class
			.getName());
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private AudioControlVO audioVO  ;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public AudioControlImpl(String ip,int port,AudioControlVO audioVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.audioVO = audioVO;
	}
	
	/**
	 * 提取状态
	 * @return
	 */
	public  void getMuteStatus(){
		logger.info("音频设备控制：getMuteStatus		begin");
		String command  = ControlCommandHelp.AUDIO_STATUS[0].replaceFirst("##1", audioVO.getId());
		try{
			new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command);
		}catch(Exception e){
			logger.error("异常："+e.getMessage());
		}
		logger.info("音频设备控制：getMuteStatus		end");
	}
	
	/**
	 * 静音
	 * @return
	 */
	public   ExcuteResultVO setMuteOn(){
		logger.info("音频设备控制：setMuteOn		begin");
		String command  = ControlCommandHelp.AUDIO_ON[0].replaceFirst("##1", audioVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				audioVO.setStatus(AudioControlVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(audioVO);
		logger.info("音频设备控制：setMuteOn		end");
		return resultVO;
	}
	
	/**
	 * 非静音
	 * @return
	 */
	public   ExcuteResultVO setMuteOff(){
		logger.info("音频设备控制：setMuteOff	begin");
		String command  = ControlCommandHelp.AUDIO_OFF[0].replaceFirst("##1", audioVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				audioVO.setStatus(AudioControlVO.status_off);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(audioVO);
		logger.info("音频设备控制：setMuteOff	end");
		return resultVO;
	}
	
	/**
	 * 提取音量值
	 * @return
	 */
	public   ExcuteResultVO getMuteNum(){
		logger.info("音频设备控制：getMuteNum	begin");
		String command  = ControlCommandHelp.AUDIO_GET_VALUES[0].replaceFirst("##1", audioVO.getId());
		try{
			new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(audioVO);
		logger.info("音频设备控制：getMuteNum	end");
		return resultVO;
	}
	
	/**
	 * 设备音量值     不好实现
	 * @param id
	 * @param num
	 * @return
	 */
	public ExcuteResultVO audioSetMuteNum(String num) {
		logger.info("音频设备控制：audioSetMuteNum	begin	num	:"+num);
		resultVO.setSuccess(true);
		resultVO.setObject(audioVO);
		logger.info("音频设备控制：audioSetMuteNum	end		num	:"+num);
		return resultVO;
	}
	
	/**
	 * 增加音量
	 * @return ExcuteResultVO
	 */
	public ExcuteResultVO audioSetMuteUp() {
		logger.info("音频设备控制：audioSetMuteUp	begin	");
		String command  = ControlCommandHelp.AUDIO_UP[0].replaceFirst("##1", audioVO.getId());
		try{
			new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(audioVO);
		logger.info("音频设备控制：audioSetMuteUp	end	");
		return resultVO;
	}
	
	public ExcuteResultVO audioSetMuteDown() {
		logger.info("音频设备控制：audioSetMuteDown		begin	");
		String command  = ControlCommandHelp.AUDIO_DOWN[0].replaceFirst("##1", audioVO.getId());
		try{
			new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		resultVO.setObject(audioVO);
		logger.info("音频设备控制：audioSetMuteDown		end	");
		return resultVO;
	}
}
