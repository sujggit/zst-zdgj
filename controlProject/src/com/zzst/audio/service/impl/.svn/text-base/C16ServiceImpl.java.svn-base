package com.zzst.audio.service.impl;

import org.apache.log4j.Logger;

import com.zzst.audio.service.impl.communication.C16ClientThread;
import com.zzst.audio.service.vo.AudioVO;
import com.zzst.util.ExcuteResultVO;

/**
 * 描述
 *@author	ryan
 *@since	2010-11-15上午11:15:25
 *@version	1.0
 */

public class C16ServiceImpl {
	private static Logger logger = Logger.getLogger(C16ServiceImpl.class
			.getName());
	
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	private AudioVO audioVO = new AudioVO();
	public C16ServiceImpl( AudioVO audioVO){
		this.audioVO = audioVO;
	}
	
	public ExcuteResultVO c16SetOutFaderNum(String code,String num) {
		try{
			String command = C16ClientThread.SET_MUTE_FADER[0].replaceFirst("##1", code);
			command = command.replaceFirst("##2", num);
			C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
//			this.audioVO.setOutFaderNum(str.substring(str.indexOf("\" ")+2,str.length()));
			//str.substring(str.indexOf("\" ")+2,str.length())
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	public ExcuteResultVO c16GetOutFaderNum(String code) {
		try{
			String command = C16ClientThread.GET_MUTE_FADER[0].replaceFirst("##1", code);
			String str = C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			this.audioVO.setOutFaderNum(str.substring(str.indexOf("\" ")+2,str.length()));
			//str.substring(str.indexOf("\" ")+2,str.length())
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	public ExcuteResultVO c16GetOutLevelNum(String code) {
		try{
			String command = C16ClientThread.GET_MUTE_LINE_OUT_GAIN[0].replaceFirst("##1", code);
			String str = C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			this.audioVO.setOutLevelNum(str.substring(str.indexOf("\" ")+2,str.length()));
			//str.substring(str.indexOf("\" ")+2,str.length())
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
			
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	public ExcuteResultVO c16SetOutLevelNum(String code,String num) {
		try{
			String command = C16ClientThread.GET_MUTE_LINE_OUT_GAIN[0].replaceFirst("##1", code);
			command = command.replaceFirst("##2", num);
			C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
//			this.audioVO.setOutLevelNum(str.substring(str.indexOf("\" ")+2,str.length()));
			//str.substring(str.indexOf("\" ")+2,str.length())
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	public ExcuteResultVO c16SetInLevelNum(String code,String num) {
		try{
			String command = C16ClientThread.SET_MIC_IN_GAIN[0].replaceFirst("##1", code);
			command = command.replaceFirst("##2", num);
			C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	public ExcuteResultVO c16GetInLevelNum(String code) {
		try{
			String command = C16ClientThread.GET_MIC_IN_GAIN[0].replaceFirst("##1", code);
			String str = C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			this.audioVO.setInLevelNum(str.substring(str.indexOf("\" ")+2,str.length()));
			
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	/**
	 * 静音
	 * @return ExcuteResultVO
	 */
	public ExcuteResultVO setMuteOFF(String code) {
		try{
			String command = C16ClientThread.MUTE_OFF[0].replaceFirst("##1", code);
			C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 非静音
	 * @return ExcuteResultVO
	 */
	public ExcuteResultVO setMuteON(String code) {
		try{
			String command = C16ClientThread.MUTE_ON[0].replaceFirst("##1", code);
			C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	
	/**
	 * 提取输入、输出静音状态
	 * @return ExcuteResultVO
	 */
	public ExcuteResultVO c16GetMuteStatus(String code) {
		String command = C16ClientThread.MUTE_STATUS[0];
		command = command.replaceFirst("##1", code);
		try{
			String str = C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			
			this.audioVO.setMuteStatus(Integer.valueOf(str.substring(str.indexOf("\" ")+2,str.length())));
			resultVO.setSuccess(true);
			resultVO.setObject(this.audioVO);
			
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		
		return resultVO;
	}
	
	/**
	 * 支持直接发送指令
	 * @return ExcuteResultVO
	 */
	public ExcuteResultVO sendCommand(String command){
		try{
			C16ClientThread.sendCommandToC16(this.audioVO.getIp(), Integer.valueOf(this.audioVO.getPort()).intValue(), command);
			resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setDes(e.getMessage());
		}
		return resultVO;
	}
	


}
