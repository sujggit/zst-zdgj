package com.zzst.terminal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zzst.terminal.service.impl.vo.AudiometerVO;
import com.zzst.terminal.service.impl.vo.CallDetailVO;
import com.zzst.terminal.service.impl.vo.CameraVO;
import com.zzst.terminal.service.impl.vo.ExceptionVO;
import com.zzst.terminal.service.impl.vo.ShoamiVO;
import com.zzst.terminal.service.impl.vo.TerminalMeetingVO;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description
 *@date 2011-3-21下午06:55:36
 *@author ryan
 */
public abstract class TerminalObject  extends EquipmentObject{
	
	/**
	 * 未知状态
	 */
	public static final String status_def = "-1";
	
	/**
	 * 在线
	 */
	public static final String status_on = "0";
	
	/**
	 * ip不通
	 */
	public static final String status_off = "1";
	
	/**
	 * 会议中
	 */
	public static final String status_onMeeting = "2";
	
	/**
	 * 终端型号
	 */
	public static final String Group300Model = "37";
	/**
	
	//////////方法-----------
	///add by ryan on 2011-12-30-------------遥控器--------begin
	
	/**
	 * 遥控器---画中画
	 * @return
	 */
	public	abstract	boolean	buttonPip();
	
	/**
	 * 遥控器---摄像机
	 * @return
	 */
	public	abstract	boolean	buttonCamera();
	
	/**
	 * 遥控器---内容
	 * @return boolean
	 */
	public	abstract	boolean	buttonGraphics();
	
	
	/**
	 * 遥控器---挂断/呼叫
	 * @return
	 */
	public	abstract	boolean	buttonCallhangup();
	
	
	/**
	 * 遥控器---近端
	 * @return
	 */
	public	abstract	boolean	buttonNear();
	
	/**
	 * 遥控器---远端
	 * @return
	 */
	public	abstract	boolean	buttonFar();
	
	/**
	 * 遥控器---声音加
	 * @return
	 */
	public	abstract	boolean	buttonVolumeUp();
	
	/**
	 * 遥控器---声音减
	 * @return
	 */
	public	abstract	boolean	buttonVolumeDown();
	
	/**
	 * 遥控器---向左
	 * @return
	 */
	public	abstract	boolean	buttonLeft();
	
	/**
	 * 遥控器---向右
	 * @return
	 */
	public	abstract	boolean	buttonRight();
	
	/**
	 * 遥控器---向上
	 * @return
	 */
	public	abstract	boolean	buttonUp();
	
	/**
	 * 遥控器---向下
	 * @return
	 */
	public	abstract	boolean	buttonDown();
	
	/**
	 * 遥控器---选择
	 * @return boolean
	 */
	public	abstract	boolean	buttonSelect();
	
	/**
	 * 遥控器---返回
	 * @return boolean
	 */
	public	abstract	boolean	buttonBack();
	
	/**
	 * 遥控器---主页
	 * @return boolean
	 */
	public	abstract	boolean	buttonHome();
	
	/**
	 * 遥控器---键盘
	 * @return
	 */
	public	abstract	boolean	buttonKeyboard();
	
	/**
	 * 遥控器---目录
	 * @return
	 */
	public	abstract	boolean	buttonDirectory();
	
	/**
	 * 遥控器---删除
	 * @return boolean
	 */
	public	abstract	boolean	buttonDelete();
	
	/**
	 * 遥控器---帮助
	 * @return
	 */
	public	abstract	boolean	buttonHelp();
	/**
	 * 遥控器---帮助
	 * @return
	 */
	public	abstract	boolean	buttonInfo();
	
	/**
	 * 遥控器---静音
	 * @return
	 */
	public	abstract	boolean	buttonMute();
	
	public	abstract	boolean	buttonPeriod();
	
	/**
	 * 输入数字、*、#
	 * @param num
	 * @return boolean
	 */
	public	abstract	boolean	buttonNum(String num);
	
	///add by ryan on 2011-12-30-------------遥控器--------end
	
	/**
	 * 提取是否在会议中状态
	 * 
	 */
	public	abstract	boolean	getConnectStaus(String ip);
	
	/**
	 * 呼叫ip
	 * @param speed
	 * @param ip
	 * @return
	 */
	public	abstract	boolean	callIP(int speed,String ip);
	

	/**
	 * 呼叫ip
	 * @param speed
	 * @param ip
	 * @return
	 */
	public	abstract	boolean	callAuto(int speed,String dialstr);
	
	/**
	 * 呼叫模拟电话
	 * @param phoneNumber
	 * @return
	 */
	public	abstract	boolean	callPhone(String phoneNumber);
	
	/**
	 * 挂断ip会话
	 * @return
	 */
	public	abstract	boolean	hangupVideo();
	
	/**
	 * 挂断电话
	 * @return
	 */
	public	abstract	boolean	hangupPhone();
	
	/**
	 * 挂断所有会话
	 * @return
	 */
	public	abstract	boolean	hangupAll();
	
	/**
	 * 应当ip会话
	 * @return
	 */
	public	abstract	boolean	answerVideo();
	
	/**
	 * 应当电话会话
	 * @return
	 */
	public	abstract	boolean	answerPhone();
	
	/**
	 * 取消静音
	 * @return
	 */
	public	abstract	boolean	muteOn();
	
	/**
	 * 静音
	 * @return
	 */
	public	abstract	boolean	muteOff();
	
	/**
	 * 提取终端远端声音状态
	 * 未实现
	 * @return
	 */
	public	abstract	boolean	getFarMuteStatus();
	/**
	 * 终端：键盘降噪
	 * @author John.Zhang
	 * Sets or gets the Enable Keyboard Noise Reduction setting.
	 * @return
	 */
    public abstract boolean enablekeyboardnoisereduction_yes();
	/**
	 * 终端：取消键盘降噪
	 * @author John.Zhang
	 * Sets or gets the Enable Keyboard Noise Reduction setting.
	 * @return
	 */
    public abstract boolean enablekeyboardnoisereduction_no();
    /**
     * 终端：回音消除，回音抑制
     * Sets or gets the configuration of echo cancellation, which prevents users from hearing their voices loop back from the far site.
     * @return
     */
    public abstract boolean echocanceller_yes();
    /**
     * 终端：取消回音消除，回音抑制
     * Sets or gets the configuration of echo cancellation, which prevents users from hearing their voices loop back from the far site.
     * @return
     */
    public abstract boolean echocanceller_no();
	/**
	 * 提取终端近端声音状态
	 * 未实现
	 * @return
	 */
	public	abstract	boolean	getNearMuteStatus();
	/**
	 * 控制近端摄像机一直向左移动
	 * @return
	 */
	public	abstract	boolean cameraMoveLeft();
	
	/**
	 * 切换输入摄像头
	 * num取值范围 1-6
	 * @return
	 */
	public	abstract	boolean cameraNear(int num);
	
	/**
	 *  num取值范围 1-5
	 * @return
	 */
	public	abstract	boolean cameraFar(int num);
	
	/**
	 * 控制近端摄像机向左跳动
	 * @return
	 */
	public	abstract	boolean cameraLeft();
	
	/**
	 * 控制近端摄像机一直向右移动
	 * @return
	 */
	public	abstract	boolean cameraMoveRight();
	
	/**
	 * 控制近端摄像机向右跳动
	 * @return
	 */
	public	abstract	boolean cameraRight();
	
	/**
	 * 控制近端摄像机一直向上移动
	 * @return
	 */
	public	abstract	boolean cameraMoveUp();
	
	/**
	 * 控制近端摄像机向上跳动
	 * @return
	 */
	public	abstract	boolean cameraUp();
	
	/**
	 * 控制近端摄像机一直向下移动
	 * @return
	 */
	public	abstract	boolean cameraMoveDown();
	
	/**
	 * 控制近端摄像机向下跳动
	 * @return
	 */
	public	abstract	boolean cameraDown();
	
	/**
	 * 控制近端摄像机一直聚焦--近
	 * @return
	 */
	public	abstract	boolean cameraMoveNear();
	
	/**
	 * 控制近端摄像机跳动一格聚焦--近
	 * @return
	 */
	public	abstract	boolean cameraNear();
	
	/**
	 * 控制近端摄像机一直聚焦--远
	 * @return
	 */
	public	abstract	boolean cameraMoveFar();
	/**
	 * 控制近端摄像机跳动一格聚焦--远
	 * @return
	 */
	public	abstract	boolean cameraFar();
	
	
	/**
	 * 设置摄像头当前位置到预置位
	 * @param number
	 * @return
	 */
	public	abstract	boolean cameraSetPosition(String number);
	
	
	/**
	 * 调用摄像头预置位
	 * @param number
	 * @return
	 */
	public	abstract	boolean cameraGetPosition(String number);
	
	
	/**
	 * 控制近端摄像机停止移动
	 * @return
	 */
	public	abstract	boolean cameraMoveStop();
	
	/**
	 * 选择终端的输入摄像头
	 * @return
	 */
	public	abstract	boolean cameraSelectNumber(String mumber);
	
	/**
	 * 设置终端输出格式为vga 50hz720p
	 * 呼通状态下不能更改
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public	abstract	boolean monitorOutVGA50hz720p(String monitorNumber);
	
	/**
	 * 设置终端输出格式为dvi 50hz720p
	 * 呼通状态下不能更改
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public	abstract	boolean monitorOutDVI50hz720p(String monitorNumber);
	
	/**
	 * 设置终端输出格式为YPbPr 1080i
	 * 呼通状态下不能更改
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public	abstract	boolean monitorOutYPbPr1080i(String monitorNumber);
	
	/**
	 * 提取终端监视器显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public	abstract	boolean monitorGetView(String monitorNumber);
	
	/**
	 * 设置终端监视器显示近端视频
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public	abstract	boolean monitorSetViewNear(String monitorNumber);
	
	/**
	 * 设置终端监视器显示近端视频
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public	abstract	boolean monitorSetViewFar(String monitorNumber);
	
	/**
	 * 设置终端监视器显示近端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public	abstract	boolean monitorSetViewNearOrContent(String monitorNumber);
	
	/**
	 * 设置终端监视器显示远端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public	abstract	boolean monitorSetViewFarOrContent(String monitorNumber);
	
	/**
	 * 设置终端监视器显示远端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public	abstract	boolean monitorSetViewFarOrNear(String monitorNumber);
	
	/**
	 * 设置终端监视器显示近端视频、远端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public	abstract	boolean monitorSetViewAll(String monitorNumber);
	
	/**
	 * 设置终端监视器不显示
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public	abstract	boolean monitorSetViewNone(String monitorNumber);
	
//	/**
//	 * 返回终端web控制界面URL
//	 * @return 
//	 */
//	public abstract	String getFarmage();
//	
	/**
	 * 提示声音
	 * @param number  范围是1-4
	 * @return
	 */
	public	abstract	boolean getPromptSound(String number);
	
	/**
	 * 终端呼叫铃音
	 * @param number  范围是1-10
	 * @return
	 */
	public	abstract	boolean getCallSound(String number);
	
	/**
	 * 终端发送双流
	 * 相当于遥控器上的"内容"按钮
	 * @return boolean
	 */
	public	abstract	boolean graphics();
	
	/**
	 * 终端发送双流
	 * 发送双流
	 * @return boolean
	 */
	public	abstract	boolean graphicsPlay();
	
	/**
	 * 终端结束双流
	 * 结束双流
	 * @return boolean
	 */
	public	abstract	boolean graphicsStop();
	
	/**
	 * 开始提取会议中的详细信息
	 * 计划调整为定时器处理
	 * @return boolean
	 * add  2012-0405 by ryan
	 */
	public abstract	 CallDetailVO setCallDetailOn() ;

	
	/**
	 * 结束提取会议中的详细信息
	 * @return boolean
	 * add  2012-0405 by ryan
	 */
//	public abstract	boolean setCallDetailOff() ;

	/**
	 * 提取音量值  -20表示没有声音
	 * @param String AudiometerVO.micleft ...
	 * @return boolean
	 * add  2011-0708 by ryan
	 * modify by ryan on 2012-5-18	同时只能提取一种音量值
	 * modify by ryan on 2014-3-28	同时提取多种音量值。不需要是必须关闭，占用很大的系统资源
	 */
	public abstract	 ExcuteResultVO setAudiometerOn(String audiometerType) ;

	/**
	 * 提取所有音量值  -20表示没有声音
	 * @return boolean
	 * add  2011-07-15 by ryan
	 * modify by ryan on 2012-5-18	同时只能提取一种音量值
	 * modify by ryan on 2014-3-28	同时提取多种音量值。不需要是必须关闭，占用很大的系统资源
	 */
	public abstract	boolean setAudiometerAllOn() ;
	
	/**
	 * 结束提取音量值
	 * @param String AudiometerVO.micleft ...
	 * @return boolean
	 * add  2011-0708 by ryan
	 */
	public  abstract	ExcuteResultVO	setAudiometerOff(String audiometerType);
	
	/**
	 * 结束所有提取音量值
	 * @return boolean
	 * add  2011-07-15 by ryan
	 */
//	public  abstract	boolean	setAudiometerAllOff();
	
	
	/**
	 * 提取会议对象
	 * @param nearIp
	 * @param farIp
	 * @return
	 * add  2011-0708 by ryan
	 */
	public	abstract	TerminalMeetingVO getMeetingVO(String nearIp,String farIp);
	
	/**
	 * 提取会议对象
	 * @param nearIp
	 * @param farIp
	 * @return
	 * add  2011-0708 by ryan
	 */
	public	abstract	ArrayList<TerminalMeetingVO> getMeetingVO();
	
	
	/**
	 * 提取声音对象
	 * 
	 * @return ExcuteResultVO object强转Map<String,AudiometerVO>  key AudiometerVO.micleft ...
	 */
	public abstract	ExcuteResultVO getAudiometerVO();
	
	 
	/**
	 * 提取通话详细参数
	 * @return CallDetailVO
	 */
	public	abstract	CallDetailVO getCallDetailVO();
	
	
	//add by ryan on 2012-04-10  begin=========begin
	
	/**
	 * 开始发测试音
	 * @return CallDetailVO
	 * add by rayn on 20130526
	 */
	public	abstract	ExcuteResultVO testToneOn ();
	
	/**
	 * 结束发测试音
	 * @return CallDetailVO
	 * add by rayn on 20130526
	 */
	public	abstract	ExcuteResultVO testToneOff ();
	
	/**
	 * 提取终端本身的配置详细参数
	 * @return ShoamiVO
	 */
	public abstract	ShoamiVO getWhoamiVO();
	
	//add by ryan on 2012-04-10  begin=========end

	//add by ryan on 2012-05-24  begin=========begin
	/**
	 * 提取摄像头当前的坐标
	 * @return CameraVO
	 */
	public	abstract	CameraVO  cameraGetPosition();
	
	/**
	 * 设置摄像头当前位置到预置位
	 * @param  -880 =< x <= 880
	 * @param  -300 =< y <=  300
	 * @param    0  =< zoom <= 1023
	 * @return
	 */
	public	abstract	boolean cameraSetPosition(String x,String y,String zoom);
	//add by ryan on 2012-05-24  begin=========end
	
	protected String	terminalIp ;
	protected int 		terminalPort	=24 ;
	protected String	telNumber;
	
	protected String       terminalModel;
	/**
	 * 远程访问登陆名。设置后必须先登录
	 */
	protected String	webLoginName;
	
	/**
	 * 远程访问登陆密码。设置后必须先登录
	 */
	protected String	webLoginPassword;
	
	/**
	 * 会议室登陆名。不影响控制
	 */
	protected String	roomName;
	
	/**
	 * 会议室登陆密码。不影响控制
	 */
	protected String	roomPassword;
	
	protected boolean	openSnmp = true;
	protected boolean	online	=	false;
	protected String	status	=	status_def;
	protected String	outerNetIp ;
	
	/**
	 * keyi TerminalMeetingVO.key
	 */
	protected   Map<String,TerminalMeetingVO> 	meetingVOMap		= new HashMap<String,TerminalMeetingVO>();
	protected   CallDetailVO 			callDetailVO	= new CallDetailVO();
	protected	ArrayList<ExceptionVO>	exceptionVOList =	new ArrayList<ExceptionVO>();
	protected   ShoamiVO 			shoami	= new ShoamiVO();
	protected   CameraVO 			cameraVO	= new CameraVO();
	
	/**
	 * key AudiometerVO.micleft
	 */
	protected	Map<String,AudiometerVO>	audiometerVOList = new HashMap<String,AudiometerVO>();
	
	
	
	public CameraVO getCameraVO() {
		return cameraVO;
	}

	public void setCameraVO(String key,CameraVO cameraVO) {
		this.cameraVO = cameraVO;
	}

	public ShoamiVO getShoami() {
		return shoami;
	}
	
	public boolean isOnLine() {
		if(status_on.equalsIgnoreCase(status)||status_onMeeting.equalsIgnoreCase(status))
			return true;
		else 
			return false;
	}

	public String getStatus() {
		return status;
	}

	
	public	abstract	void setStatus(String key,String status);
	
	/**
	 * 内部使用，不对外提供
	 * @param key
	 * @param TerminalMeetingVO
	 * @return
	 */
	public	abstract	boolean setMeetingVO(String key,TerminalMeetingVO terminalMeetingVO);
	
	/**
	 * 内部使用，不对外提供
	 * @param key
	 * @param TerminalMeetingVO
	 * @return
	 */
	public	abstract	boolean removeMeetingVO(String key,String farIp);
	
	/**
	 * 内部使用，不对外提供
	 * @param audiometerVO.micleft
	 * @param AudiometerVO
	 * @return boolean
	 */
	public abstract	boolean setAudiometerVO(String	key,AudiometerVO audiometerVO) ;
	
	
	/**
	 * 初始化数据
	 * 数组存储的结构
	 * 0:ip
	 * 1:phone
	 * 2:远程控制登陆名 ：默认为admin。影响控制
	 * 3：远程控制登陆密码
	 * 4:外网ip
	 * 5:会议室登陆名 ：默认为admin。不影响控制
	 * 6：会议室登陆密码
	 * 7：终端设备型号，例如：hdx7000、group300等
	 */
	public	TerminalObject(String[] info){
		this.terminalIp	=	info[0];
		this.telNumber	=	info[1];
		this.webLoginName	=	info[2];
		this.webLoginPassword	=info[3];
		this.outerNetIp	=	info[4];
		this.roomName	=	info[5];
		this.roomPassword	=	info[6];
		this.terminalModel  =   info[7];
	}
	public String getTerminalModel() {
		return terminalModel;
	}
	
	public String getWebLoginName() {
		return webLoginName;
	}

	public String getWebLoginPassword() {
		return webLoginPassword;
	}

	public String getRoomName() {
		return roomName;
	}

	public String getRoomPassword() {
		return roomPassword;
	}

	public String getTerminalIp() {
		return terminalIp;
	}
	
	public String getOuterNetIp() {
		return outerNetIp;
	}
	
	/**
	 * 提取当前检查终端的的线程数
	 * @return int
	 * add by ryan on 20140225
	 */
	public static int getNetStatusThreadNumber() {
		return EquipmentObjectImpl.net_status_thread_number_ter;
	}
	
	
}
