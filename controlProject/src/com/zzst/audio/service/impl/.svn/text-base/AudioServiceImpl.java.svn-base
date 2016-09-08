package com.zzst.audio.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.zzst.audio.service.AudioObject;
import com.zzst.audio.service.vo.AudioVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	音频控制接口实现
 *@date 2012-10-27下午07:13:54
 *@author ryan
 */
public class AudioServiceImpl extends AudioObject{
	private static Logger logger = Logger.getLogger(AudioServiceImpl.class
			.getName());
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	/**
	 * 0 ip
	 * 1 port	默认52774
	 * 2 名称
	 * @param info
	 */
	public AudioServiceImpl(String[] info){
		AudioVO audioVO = new AudioVO();
		audioVO.setIp(info[0]);
		audioVO.setPort(Integer.valueOf(info[1]));
		audioVO.setLogin_name(info[2]);
		this.setAudioVO(audioVO);
	}

	@Override
	public ExcuteResultVO polycomSendCommand(String command) {
		
		return new C16ServiceImpl(this.getAudioVO()).sendCommand(command);
	}

	@Override
	public ExcuteResultVO polycomSetMuteOFF(String code) {
		
		return new C16ServiceImpl(this.getAudioVO()).setMuteOFF(code);
	}

	@Override
	public ExcuteResultVO polycomSetMuteON(String code) {
		
		return new C16ServiceImpl(this.getAudioVO()).setMuteON(code);
	}

	@Override
	public ExcuteResultVO polycomGetOutLevelNum(String code) {
		
		return new C16ServiceImpl(this.getAudioVO()).c16GetOutLevelNum(code);
	}

	@Override
	public ExcuteResultVO polycomGetMuteStatus(String code) {
		return new C16ServiceImpl(this.getAudioVO()).c16GetMuteStatus(code);
	}

	@Override
	public ExcuteResultVO polycomGetOutFaderNum(String code) {
		return new C16ServiceImpl(this.getAudioVO()).c16GetOutFaderNum(code);
	}

	@Override
	public ExcuteResultVO polycomSetOutFaderNum(String code, String num) {
		return new C16ServiceImpl(this.getAudioVO()).c16SetOutFaderNum(code,num);
	}

	@Override
	public ExcuteResultVO polycomSetOutLevelNum(String code, String num) {
		return new C16ServiceImpl(this.getAudioVO()).c16SetOutLevelNum(code,num);
	}

	@Override
	public ExcuteResultVO polycomGetInLevelNum(String code) {
		return new C16ServiceImpl(this.getAudioVO()).c16GetInLevelNum(code);
	}

	@Override
	public ExcuteResultVO polycomSetInLevelNum(String code, String num) {
		return new C16ServiceImpl(this.getAudioVO()).c16SetInLevelNum(code,num);
	}

	 

	
	
	
}
