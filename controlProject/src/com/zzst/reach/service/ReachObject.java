package com.zzst.reach.service;

import com.zzst.reach.service.vo.ReachVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.SystemConfig;


/**
 *@Description	锐取录播服务器接口
 *@date 2013-1-21下午02:47:27
 *@author ryan
 */
public abstract class ReachObject extends EquipmentObject{
	
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
	 * 录制状态-录制中
	 */
	public static final int recordEX_play = 0;
	
	/**
	 * 录制状态-暂停
	 */
	public static final int recordEX_pausePlay = 1;
	
	/**
	 * 录制状态-停止
	 */
	public static final int recordEX_stopPlay = 2;
	
	/**
	 * 提前会议室连接状态
	 * @param  roomID	会议室ID
	 * @return ExcuteResultVO
	 */
//	public abstract ExcuteResultVO getRoomStatus(String roomID);
	
	/**
	 * 提取通道录制状态
	 * @param  roomID	会议室ID
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO getRecordStatus(int channelID);
	
	/**
	 * 连接通道
	 * @param channelID	通道id
	 * @param ips	连接编码器的IP 最多6个编码器
	 * @param bhighrate	录制的质量，默认为0
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO	connect(int channelID,int bhighrate,String[] ips);
	
	/**
	 * 断开通道
	 * @param channelID	会议室通道id
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO	unConnect(int channelID);
	
	/**
	 * 开始录制
	 * @param  fileName 支持ASCII码字符组成的文件名(可包含数字和字符)，不包含路径
	 * @param  channel 通道号 默认ReachVO.channelID_DEF
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO play(String fileName,int channelID);
	
	/**
	 * 停止录制
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO stopPlay(int channelID);
	
	/**
	 * 继续录制
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO continuePlay(int channelID);
	
	/**
	 * 暂停录制
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO pausePlay(int channelID);
	
	/**
	 * 检查通道状态
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO channelStatus(int channelID);
	
	public boolean  checkEquipmentStatus(){
		ReachObject obj = (ReachObject)ControlFactory.getReachObject(this.getVo().getServerIP());
		if(status_on.equalsIgnoreCase(obj.getStatus())){
			return true;
		}else{
			resultVO.setSuccess(false);
			resultVO.setDes(ip_reachable);
			return false;
		}
	}
	
	public ExcuteResultVO resultVO = new	ExcuteResultVO();
	private ReachVO vo = new ReachVO();
	private	String	status = status_def;

	public String getStatus() {
		return status;
	}

	/**
	 * 外部不允许使用
	 * @param status
	 */
	public void setStatus(String sys,String status) {
		if(SystemConfig.METHED_WITHIN.equalsIgnoreCase(sys))
			this.status = status;
	}

	public  ReachObject(ReachVO vo){
		this.vo = vo;
	}
	
	public ReachVO getVo() {
		
		return vo;
	}
}