package com.zzst.audio.service;

import com.zzst.audio.service.vo.AudioVO;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.SystemConfig;


/**
 *@Description	音频控制接口
 *@date 2012-10-27下午07:13:35
 *@author ryan
 */
public abstract class AudioObject extends EquipmentObject{
	
	/**
	 * 在线
	 */
	public static final String status_on = "0";
	
	/**
	 * ip不通
	 */
	public static final String status_off = "1";
	
	/**
	 * 未知状态
	 */
	public static final String status_def = "-1";
	
	
	/**
	 * 输入、输出非静音
	 * @param code 名称
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomSetMuteON(String code);
	
	/**
	 * 输入、输出静音
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomSetMuteOFF(String code);
	
	/**
	 * 提前xx输入、输出静音状态
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomGetMuteStatus(String code);
	
	
	/**
	 * 提取输出设置的level值
	 * MUTE_LINE_OUT_GAIN
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomGetOutLevelNum(String code);
	
	
	/**
	 * 设置输出设置的level值
	 * MUTE_LINE_OUT_GAIN
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomSetOutLevelNum(String code,String num);
	
	/**
	 * 提取输出设置的fader值
	 * fader
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomGetOutFaderNum(String code);
	
	/**
	 * 提取输出设置的fader值
	 * fader
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomSetOutFaderNum(String code,String num);
	
	/**
	 * 提取输入设置的LEVEL值
	 * LEVEL
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomSetInLevelNum(String code,String num);
	
	/**
	 * 提取输入设置的LEVEL值
	 * LEVEL
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomGetInLevelNum(String code);
	
	
	/**
	 * 发送指令
	 * @param command
	 * @return ExcuteResultVO object强转为AudioVO
	 */
	public abstract ExcuteResultVO polycomSendCommand(String command);
	
	
	private AudioVO audioVO = new AudioVO();
	public String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String sys,String status) {
		if(SystemConfig.METHED_WITHIN.equalsIgnoreCase(sys))
			this.status = status;
	}

	public void setAudioVO(AudioVO audioVO){
		this.audioVO = audioVO;
	}
	
	public AudioVO getAudioVO(){
		return audioVO;
	}
	
	public String getIp() {
		return audioVO.getIp();
	}

	public int getPort() {
		return audioVO.getPort();
	}

	/**
	 * 提取当前检查终端的的线程数
	 * @return int
	 * add by ryan on 20140226
	 */
	public static int getNetStatusThreadNumber() {
		return EquipmentObjectImpl.net_status_thread_number_audio;
	}
}
