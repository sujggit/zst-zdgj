package com.zzst.kst.videocard.service;


import com.zzst.kst.videocard.vo.VideoCardVO;
import com.zzst.util.EquipmentObject;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	可视通--对比卡
 *@date 2013-1-5 上午11:42:06
 *@author ryan
 */
public abstract	class VideocardObject extends EquipmentObject{


	protected String ip;
	protected int tcpPort;
	protected int udpPort;
	protected int revSoTimeout;
	
	public  VideocardObject(VideoCardVO vcVO){
		this.ip = vcVO.getIp();
		this.tcpPort = vcVO.getTcpPort();
		this.udpPort = vcVO.getUdpPort();
		this.revSoTimeout = vcVO.getRevSoTimeout();
	}
	 
	/**
	 * 获取评测值
	 * @param ip
	 * @return
	 */
    public abstract ExcuteResultVO getVideoCardObj();
    
    /**
     * 设置模式
     * @return
     */
    public abstract ExcuteResultVO setModel(byte[] sendCommand);
    
    /**
     * 设置ip地址
     * @param ip
     * @param gateway
     * @param mask
     * @return
     */
    public abstract ExcuteResultVO setIP(String gateway,String mask);
    
    /**
     * 重启
     * @param ip
     * @return
     */
    public abstract ExcuteResultVO restart();
}
