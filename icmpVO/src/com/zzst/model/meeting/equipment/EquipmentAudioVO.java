package com.zzst.model.meeting.equipment;

import java.io.Serializable;


/**
 *@Description 音频设备
 *@date 2011-12-15下午02:55:37
 *@author ryan
 */
public class EquipmentAudioVO extends EquipmentVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private	String	modelNO;
	private String	volumeNumber;
	//�Ƿ���
	private boolean mute;
	
	
	public String getModelNO() {
		return modelNO;
	}
	public void setModelNO(String modelNO) {
		this.modelNO = modelNO;
	}
	public String getVolumeNumber() {
		return volumeNumber;
	}
	public void setVolumeNumber(String volumeNumber) {
		this.volumeNumber = volumeNumber;
	}
	/**
	 * @return the mute
	 */
	public boolean isMute() {
		return mute;
	}
	/**
	 * @param mute the mute to set
	 */
	public void setMute(boolean mute) {
		this.mute = mute;
	}
	
	
	
}
