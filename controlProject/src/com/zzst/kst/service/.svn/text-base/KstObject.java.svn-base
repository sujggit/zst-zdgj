package com.zzst.kst.service;


import com.vmediax.oneplusn.ice.api.vmxICE.LiveMeetTemplate;
import com.vmediax.oneplusn.ice.api.vmxICE.TerminalInfo;
import com.zzst.kst.service.impl.MCUProxy;
import com.zzst.kst.service.impl.vo.KstVO;
import com.zzst.util.EquipmentObject;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	控制可视通设备
 *@date 2012-8-14下午01:47:03
 *@author ryan
 */
public abstract class KstObject  extends EquipmentObject{
//	private static Logger logger = Logger.getLogger(KstObject.class.getName());
	
	protected String ip;//视频监控服务器IP
	
	protected String videoIP;//视频网关IP
	protected int videoPort;//视频网关IP
	public KstObject(KstVO kstVO){
		this.ip = kstVO.getIp();
		this.videoIP = kstVO.getVideoIP();
		this.videoPort = kstVO.getVideoPort();
	}
	
	/**
	 * GK模块-操作trsp终端
	 * 呼叫
	 * @param TerminalInfo 必须设置监控地址(属性名为ipaddr),监控名称(属性名为name)，终端类型(属性名为terminalType)的值
	 * @param number 通道
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO callRtspTerminal(String ip,String name,String type,String number);
	
	/**
	 * GK模块-操作trsp终端
	 * 删除
	 * @param TerminalInfo 必须设置监控地址(属性名为ipaddr)
	 * @param number 通道
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO stopRtspTerminal(String ip,String number);
	
	/**
	 * GK模块-操作trsp终端
	 * 手动挂断
	 * @param presetid
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO disconnectRtspTerminal(String ip,String number);
	
	/**
	 * GK模块-操作trsp终端
	 * 重邀
	 * @param presetid
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO reconnectRtspTerminal(String ip,String number);
	
	//=============================================================
	
	/**
	 * 查看电视墙预案
	 * @param presetid
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO exectWallPreset(String presetid);
	
	/**
	 * 提取电视墙预案列表
	 * @param url
	 * @return  ExcuteResultVO    (Presets)getObject()
	 */
	public abstract ExcuteResultVO getallWallPreset();
	
	/**
	 * 提取省公司下组信息
	 * @param domainid
	 * @return ExcuteResultVO    (ArrayList<Group>)getObject()
	 */
	public abstract ExcuteResultVO getallgroups(String domainid);
	
	/**
	 * 提取组下摄像头列表
	 * @param groupid
	 * @return ExcuteResultVO    (ArrayList<Camera>)getObject()
	 */
	public abstract ExcuteResultVO getCamerasbyGroupID(String groupid);
	
	/**
	 * 查看组摄像头图像
	 * @param groupid
	 * @return ExcuteResultVO    (String)getObject()
	 */
	public abstract ExcuteResultVO viewGroupVideo(String system,String group,String model);
	
	/**
	 * 查看摄像头图像
	 * @param groupid
	 * @return ExcuteResultVO    (String)getObject()
	 */
	public abstract ExcuteResultVO getCameraVideo(String system,String camera,String model);
	
	/**
	 * 获取网关代理对象
	 * @param netIp
	 * @param port
	 * @return MCUProx 对象
	 */
	public abstract MCUProxy getMCUProx();
	
	/**
	 * 设置固定通道摄像机参数
	 * @param channelNumber	通道号 取值1-16
	 * @param division	分屏模式 取值 1、4、9、16
	 * @param camers 	设置多画面的摄像机视频来源。
						格式：窗格号：摄像机号
						设置多个摄像机时用";"号连接
						例：1:35;2:124;3:33;4:98

	 * @return ExcuteResultVO (String)getObject() 会议编号
	 */
	public abstract ExcuteResultVO setChannel(String channelNumber,String division,String camers);
	
	/**
	 * 视频网关--创建会议
	 * @param meetingName
	 * @return ExcuteResultVO
	 */
	public abstract ExcuteResultVO conferenceCreat(String meetingName);
	 
	
	/**
	 * 可视通邀请会议
	 * @param rtspUrl 邀请ip	
	 * @param meetNumber 会议号
	 * @return  ExcuteResultVO (String)getObject()
	 */
	public abstract ExcuteResultVO inviteVideoTerminal(String rtspUrl ,String meetNumber);
	/**
	 * 可视通结束及时会议
	 * @param meetNumber 会议编号
	 * @return ExcuteResultVO (String)getObject()
	 */
	public abstract ExcuteResultVO stopLiveMeet(String meetNumber);
	
	/**
	 * //添加即时模板
	 */
	public abstract ExcuteResultVO addLiveTemplate(LiveMeetTemplate liveTemplate);
    
	/**
	 * 调用可视通网关开及时会议
	 * @param liveTemplateName 及时会议模板名称
	 * @param videoTermList	开会终端列表
	 * @return ExcuteResultVO (String)getObject()
	 */
	public abstract ExcuteResultVO startLiveMeeting(String liveTemplateName,TerminalInfo[] videoTermList);
	
	public abstract ExcuteResultVO startModeMeeting(String liveTemplateName,TerminalInfo[] videoTermList);
	public abstract ExcuteResultVO stopModeMeeting(String meetNum);
	
	public abstract ExcuteResultVO connectAll(String meetNumber);
	
	public abstract  ExcuteResultVO  SetScreen(TerminalInfo[] terminals, String number, String vscreen,String index, String mode);
	
	
}

