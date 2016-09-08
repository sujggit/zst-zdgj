package com.zzst.centerContor.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.zzst.centerContor.vo.AudioControlVO;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.CenterControlVO;
import com.zzst.centerContor.vo.CurtainVO;
import com.zzst.centerContor.vo.LightVO;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.ProjVO;
import com.zzst.centerContor.vo.RoomModelVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.centerContor.vo.TvVO;
import com.zzst.centerContor.vo.UpDownScreenVO;
import com.zzst.centerContor.vo.VedioTerminalVO;
import com.zzst.centerContor.vo.VideomVO;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ExcuteResultVO;

/**
 * 描述		中控设备对象
 *@author	ryan
 *@since	2010-11-11下午01:34:22
 *@version	1.0
 */

public abstract class CenterControlObject extends EquipmentObject{
	
	
	/**
	 * 中控型号
	 */
	public static final	String AMX = "amx";
	
	/**
	 * 中控在线
	 */
	public static final String status_on = "0";
	
	/**
	 * 中控ip不通
	 */
	public static final String status_off = "1";
	
	/**
	 * 中控未知状态
	 */
	public static final String status_def = "-1";
	
	/**
	 * 默认控制设备ID号
	 */
	public static final String def_ID = "1";
	
	/**
	 * 心跳时间间隔
	 * 以秒为单位
	 */
	public static long HEARBEAT_TIME = 10*60*1000;
	
	
	//中控控制的设备类型

	protected String 	centerControlIp = "172.0.0.1";
	protected String 	centerControlType = AMX;
	protected int	    centerControlProt = 1550;
	protected String	status = status_def;
	
	/**
	 * 给中控直接发送命令
	 * @param command
	 * @return ExcuteResultVO   object转换String
	 */
	public abstract ExcuteResultVO sendCommand(String command);
	
	/**
	 * 取会议室组合键列表
	 * @param id 中控ID
	 * @return ExcuteResultVO   object转换RoomModelVO
	 */
	public ArrayList<RoomModelVO> getRoomModelList(){
		ArrayList<RoomModelVO> msvList = new ArrayList<RoomModelVO>();
		Iterator<RoomModelVO> i = CenterControlObjectHelp.getRoomModelVOList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		Comparator<RoomModelVO> comparator = new Comparator<RoomModelVO>(){
			   public int compare(RoomModelVO s1, RoomModelVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
			
		return msvList;
	}
	
	/**
	 * 取会议室组合键列表。已经废弃，不再使用 modify 20140709,统一使用getRoomModelList()这个方法
	 * @param id 中控ID
	 * @return ExcuteResultVO   object转换RoomModelVO
	 */
	public abstract ExcuteResultVO getRoomModelList(String id);
	
	
	/**
	 * 设置会议室组合键
	 * @param id 中控ID
	 * @param modelID 模式ID
	 * @return ExcuteResultVO   object转换RoomModelVO
	 */
	public abstract ExcuteResultVO setRoomModel(String id,String modelID);
	
	/**
	 * 提前当前会议室组合键
	 * @param id 中控ID
	 * @return ExcuteResultVO   object转换String
	 */
	public abstract ExcuteResultVO getRoomModel(String id);
	
	/**
	 * 提取中控设备状态
	 * @return String
	 */
	public abstract String getStatus();
	
	/**
	 * 设置中控设备状态
	 * @param status
	 */
	public abstract void setStatus(String sys,String status);
	
	/**
	 * 提取音频设备状态
	 * @param id
	 * @return ExcuteResultVO object转换AudioControlVO
	 */
	public abstract ExcuteResultVO audioStatus(String id);
	
	
	/**
	 * 音频设备静音操作
	 * @param id
	 * @return ExcuteResultVO object转换AudioControlVO
	 */
	public abstract ExcuteResultVO audioMuteOn(String id);
	
	/**
	 * 音频设备非静音操作
	 * @param id
	 * @return ExcuteResultVO object转换AudioControlVO
	 */
	public abstract ExcuteResultVO audioMuteOff(String id);
	
	/**
	 * 提取音频设备音量值操作
	 * @param id
	 * @return ExcuteResultVO object转换AudioControlVO
	 */
	public abstract ExcuteResultVO audioMuteNum(String id);
	
	
	
	/**
	 * 设置音频设备音量值		未实现
	 * @param id
	 * @param num
	 * @return ExcuteResultVO  object转换AudioControlVO
	 */
	public abstract ExcuteResultVO audioSetMuteNum(String id,String num);
	
	/**
	 * 音频设备 音量  -
	 * @param id
	 * @return ExcuteResultVO  object转换AudioControlVO
	 */
	public abstract ExcuteResultVO audioSetMuteDown(String id);
	
	/**
	 * 音频设备 音量  +
	 * @param id
	 * @return ExcuteResultVO  object转换AudioControlVO
	 */
	public abstract ExcuteResultVO audioSetMuteUP(String id);
	
	
	/**
	 * 矩阵单个切换操作
	 * @param id
	 * @param in
	 * @param out
	 * @return  ExcuteResultVO	 object转换MatrixSwitchVO
	 */
	public abstract ExcuteResultVO matrixSwitch(String id,String in ,String out);
	
	/**
	 * 矩阵一对多切换操作
	 * @param id
	 * @param in
	 * @param String[] out
	 * @return  ExcuteResultVO	 object转换MatrixSwitchVO
	 */
	public abstract ExcuteResultVO matrixSwitch(String id,String in ,String[] out);
	
	/**
	 * 窗帘-开
	 * @param id
	 * @return	ExcuteResultVO
	 */
	public abstract ExcuteResultVO curtainOpen(String id);
	
	/**
	 * 窗帘-关
	 * @param id
	 * @return	ExcuteResultVO
	 */
	public abstract ExcuteResultVO curtainClose(String id);
	
	/**
	 * 窗帘-停止
	 * @param id
	 * @return	ExcuteResultVO
	 */
	public abstract ExcuteResultVO curtainStop(String id);
	
	/**
	 * 提取矩阵上所有的切换对应关系
	 * @param id
	 * @return ExcuteResultVO 	object转换MatrixSwitchVO
	 */
	public abstract ExcuteResultVO matrixSwitchList(String id);
	
	/**
	 * 提取矩阵上输出对应的输入
	 * @param id
	 * @param toUnm
	 * @return ExcuteResultVO 	object转换String 
	 */
	public abstract ExcuteResultVO matrixSwitchIn(String id,String toUnm);
	
	/**
	 * 提取矩阵上出入对应的输出列表
	 * @param id
	 * @param fromUnm
	 * @return ExcuteResultVO	object转换ArrayList<String>
	 */
	public abstract ExcuteResultVO matrixSwitchOut(String id,String fromUnm);
	
	
	/**
	 * 视频会议终端状态
	 * @param id
	 * @return ExcuteResultVO	
	 */
	public abstract ExcuteResultVO vedioTerminalStatus(String id);
	
	
	/**
	 * 系统电源状态
	 * @param id
	 * @return	ExcuteResultVO object转换SysPowerVO
	 */
	public abstract ExcuteResultVO sysPowerStatus(String id);
	
	/**
	 * 系统电源--开
	 * @param id
	 * @return ExcuteResultVO object转换SysPowerVO
	 */
	public abstract ExcuteResultVO sysPowerOn(String id);
	
	/**
	 * 系统电源--关
	 * @param id
	 * @return ExcuteResultVO object转换SysPowerVO
	 */
	public abstract ExcuteResultVO sysPowerOff(String id);
	
	/**
	 * 提取大屏模式列表
	 * @param id
	 * @return ExcuteResultVO object转换ViewScreentVO   String[][] s= ViewScreentVO.getAllModel() 0为ID，1为显示名称
	 */
	public abstract ExcuteResultVO viewScreentModelList(String id);
	
	/**
	 * 提取大屏模式对应的输出端口
	 * @param id
	 * @return ExcuteResultVO object转换ViewScreentVO   Map<String,String> allModelSwitchOutPort = ViewScreentVO.getModelSwitchOutPort()
	 */
	public abstract ExcuteResultVO viewScreentModelSwitchOutPort(String id);
	
	
	/**
	 * 大屏模式切换
	 * @param id
	 * @param modelID 当前大屏的模式ID
	 * @param matrixID   当前是操作的矩阵ID
	 * @param in
	 * @param out
	 * @return ExcuteResultVO object转换ViewScreentVO   
	 */
	public abstract ExcuteResultVO viewScreentModelSwitch(String id,String modelID,String matrixID,String in,String out);
	
	/**
	 * 大屏开关状态
	 * @param id
	 * @return	ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewScreentStauts(String id);
	

	/**
	 * 设置大屏当前模式下相关窗口信息
	 * @param id
	 * @param handle	窗口句柄
	 * @param sourceName	信号源名称
	 * @return ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewScreentModelInfo(String id, String no,String handle,String sourceName);
	
	
	/**
	 * 只适用于石油销售数据共享模式（Vlink）
	 * @param id
	 * @param sourceName	信号源
	 * @return ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewModelInfo(String id, String no,String sourceName);
	
	
	/**
	 * 设置大屏模式
	 * @param id
	 * @param no
	 * @return ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewScreentModel(String id,String no);
	
	/**
	 * 提取大屏当前显示模式
	 * @param id
	 * @return ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewScreentModelStatus(String id);
	
	/**
	 * 提取大屏当前显示模式及详细信息
	 * @param id
	 * @return ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewScreentModelStatusInfo(String id);
	
	/**
	 * 大屏设备--开电源
	 * @param id
	 * @return ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewScreentON(String id);
	
	/**
	 * 大屏设备--关电源
	 * @param id
	 * @return ExcuteResultVO	object转换ViewScreentVO
	 */
	public abstract ExcuteResultVO viewScreentOFF(String id);
	
	/**
	 * 摄像头左转
	 * @param id 
	 * @return ExcuteResultVO object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraLeft(String id);
	
	/**
	 * 摄像头右转
	 * @param id
	 * @return ExcuteResultVO object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraRight(String id);
	
	/**
	 * 摄像头向上
	 * @param id
	 * @return ExcuteResultVO object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraUp(String id);
	
	/**
	 * 摄像头向下
	 * @param id
	 * @return ExcuteResultVO object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraDown(String id);
	
	/**
	 * 摄像头停止转动
	 * @param id
	 * @return ExcuteResultVO object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraStop(String id);
	
	/**
	 * 提取摄像头所有速度
	 * @param id
	 * @return ExcuteResultVO object转换String[][] 0是ID 1是显示名称
	 */
	public abstract ExcuteResultVO cameraAllSpeed(String id);
	
	/**
	 * 提取摄像头所有预置位
	 * @param id
	 * @return ExcuteResultVO object转换String[][] 0是ID 1是显示名称
	 */
	public abstract ExcuteResultVO cameraAllStore(String id);
	
	/**
	 * 提取摄像头当前调用的预置位
	 * @param id
	 * @return ExcuteResultVO object转换String 是ID
	 */
	public abstract ExcuteResultVO cameraStore(String id);
	
	
	/**
	 * 设置预置位
	 * @param id
	 * @param num
	 * @return ExcuteResultVO object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraStore(String id,String num);
	
	/**
	 * 调用某个预置位
	 * @param id
	 * @param num
	 * @return ExcuteResultVO object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraRecall(String id,String num);
	
	/**
	 * 提取当前摄像头移动速度
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraGetSpeed(String id);
	
	/**
	 * 设置摄像头移动速度
	 * @param id
	 * @param num
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraSetSpeed(String id,String num);
	
	
	/**
	 * 设置摄像头焦距变大
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraZoomAdd(String id);
	
	/**
	 * 设置摄像头焦距减小
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraZoomSubtract(String id);
	
	/**
	 * 摄像头是否有自动跟踪功能
	 * @param id
	 * @return ExcuteResultVO  object转换boolean
	 */
	public abstract ExcuteResultVO cameraAutoTrack(String id);
	
	/**
	 * 摄像头自动跟踪-开
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraAutoTrackOn(String id);
	
	/**
	 * 摄像头自动跟踪-关
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraAutoTrackOff(String id);
	
	/**
	 * 摄像头详细参数--曝光
	 * @param String id 
	 * @param boolean  true 自动 false 手动
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraExposureManual(String id,boolean b);
	/**
	 * 摄像头详细参数--提取曝光状态
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraExposureManualStatus(String id);
	
	/**
	 * 摄像头详细参数--增益
	 * 启用手动曝光后起作用，
	 * @param id
	 * @param gain
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraExposureManualGain(String id,int gain);
	
	/**
	 * 摄像头详细参数--快门
	 * 启用手动曝光后起作用，
	 * @param id
	 * @param speed
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraExposureManualSpeed(String id,String speed);
	/**
	 * 摄像头详细参数--光圈
	 * 启用手动曝光后起作用，
	 * @param liris
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraExposureManuaIris(String id,String liris);
	 
	/**
	 * 摄像头详细参数--白平衡
	 * @param id
	 * @param boolean  true 自动 false 手动
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraWhiteBalanceManual(String id,boolean b);

	/**
	 * 摄像头详细参数--提取白平衡状态
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraWhiteBalanceManualStatus(String id);
	
	/**
	 * 摄像头详细参数--红值
	 * 启用手动白平衡后起作用，
	 * @param id
	 * @param int   -128~127
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraWhiteBalanceManualR(String id,int r);
	
	/**
	 * 摄像头详细参数--蓝值
	 * 启用手动白平衡后起作用，
	 * @param id
	 * @param int   -128~127
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraWhiteBalanceManualB(String id,int b);
	
	/**
	 * 摄像头详细参数--设置背光
	 * @param id
	 * @param boolean   true 自动 false 手动
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraBackLight(String id,boolean b);
	
	/**
	 * 摄像头详细参数--提取背光状态
	 * @param id
	 * @return ExcuteResultVO  object转换CameraVO
	 */
	public abstract ExcuteResultVO cameraBackLightStatus(String id);
	
//	public abstract ExcuteResultVO upDownScreenAllUP(); 需解决更新缓存问题
//	public abstract ExcuteResultVO upDownScreenAllDown();
	/**
	 * 升级屏---升
	 * @param id 
	 * @return ExcuteResultVO  object转换UpDownScreenVO
	 */
	public abstract ExcuteResultVO upDownScreenScreenUP(String id);
	
	/**
	 * 升级屏---当前的状态
	 * @param id 
	 * @return ExcuteResultVO  object转换UpDownScreenVO
	 */
	public abstract ExcuteResultVO upDownScreenScreenStatus(String id);
	
	
	/**
	 * 升级屏---降
	 * @param id
	 * @return ExcuteResultVO  object转换UpDownScreenVO
	 */
	public abstract ExcuteResultVO upDownScreenScreenDown(String id);
	
	
	/**
	 * 升级屏---组升
	 * @param id 
	 * @return ExcuteResultVO  object转换UpDownScreenVO
	 */
	public abstract ExcuteResultVO upDownScreenScreenUP(String[] id);
	
	/**
	 * 升级屏---组降
	 * @param id UpDownScreenVO
	 * @return ExcuteResultVO  object转换UpDownScreenVO
	 */
	public abstract ExcuteResultVO upDownScreenScreenDown(String[] id);
	
	/**
	 * 灯光--开
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO lightOn(String id);
	
	/**
	 * 灯光--关
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO lightOff(String id);
	
	/**
	 * 灯光--组开
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO lightOn(String[] ids);
	
	/**
	 * 灯光--组关
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO lightOff(String[] ids);
	
	/**
	 * 灯光--状态
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO lightStatus(String id);
	
	/**
	 * 等离子-提取开关状态
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO plaStatus(String id);
	
	/**
	 * 等离子-调用等离子模式
	 * @param id
	 * @param no	模式ID
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO plaChannel(String id,String no);
	
	/**
	 * 等离子-当前等离子模式
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO plaChannel(String id);
	
	/**
	 * 等离子-提取等离子模式列表
	 * @param id
	 * @return ExcuteResultVO  object转换String[][]
	 */
	public abstract ExcuteResultVO plaChannelList(String id);
	
	
	/**
	 * 等离子-开
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO plaOn(String id);
	
	/**
	 * 等离子-关
	 * @param id
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO plaOff(String id);
	
	/**
	 * 等离子-组开
	 * @param ids
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO plaOn(String[] ids);
	
	/**
	 * 等离子-组关
	 * @param ids
	 * @return ExcuteResultVO  object转换PlaVO
	 */
	public abstract ExcuteResultVO plaOff(String[] ids);
	
	/**
	 * DVD-提取当前电源状态
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
//	public abstract ExcuteResultVO dvdPowerStaus(String id);
	
	/**
	 * DVD-播放
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdPlay(String id);
	
	/**
	 * DVD-停止
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdStop(String id);
	
	/**
	 * DVD-暂停
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdPause(String id);
	
	/**
	 * DVD-下一个
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdNext(String id);
	
	/**
	 * DVD-上一个
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdPrev(String id);
	
	/**
	 * DVD-前进
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdForward(String id);
	
	/**
	 * DVD-后退
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdReverse(String id);
	
	/**
	 * DVD-录制
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdRec(String id);
	
	/**
	 * DVD-停止录制
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdStopRec(String id);
	
	/**
	 * DVD-输入
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdInput(String id);
	
	/**
	 * DVD- 播放dvd
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdDvd(String id);
	
	/**
	 * DVD- 硬盘
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdDdd(String id);
	
	/**
	 * DVD-频道+
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdChannelAdd(String id);
	
	/**
	 * DVD-频道-
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdChannelSubtract(String id);
	
	/**
	 * DVD-电源
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdPower(String id);
	
	/**
	 * DVD-开/关仓
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdOpcl(String id);
	
	
	/**
	 * DVD-菜单
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdMenu(String id);
	
	/**
	 * DVD-主菜单
	 * @param id
	 * @return
	 */
	public abstract ExcuteResultVO dvdMainMenu(String id);
		
	/**
	 * DVD-返回
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdBack(String id);
	
	/**
	 * DVD-声道
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdAudioLine(String id);
	
	/**
	 * DVD-字幕
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdtitle(String id);
	
	/**
	 * DVD-上
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdUP(String id);
	
	/**
	 * DVD-下
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdDown(String id);
	
	/**
	 * DVD-左
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdLeft(String id);
	
	/**
	 * DVD-右
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdRight(String id);
	
	/**
	 * DVD-确认
	 * @param id
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdEnter(String id);
	
	/**
	 * DVD-输入数字
	 * @param id
	 * @param num  0-9之间
	 * @return ExcuteResultVO  object转换DvdVO
	 */
	public abstract ExcuteResultVO dvdNum(String id,String num);
	
	/**
	 * 投影机-电源开
	 * @param id
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projPowerOn(String id);
	
	/**
	 * 投影机-电源组开
	 * @param id
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projGroupPowerOn(String[] ids);
	
	/**
	 * 投影机-电源关
	 * @param id
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projPowerOff(String id);
	
	/**
	 * 投影机-电源组关
	 * @param id
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projGroupPowerOff(String[] ids);
	
	/**
	 * 投影机-设置输入信号格式
	 * @param id
	 * @param type
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projSetPowerDisplay(String id,String type);
	
	/**
	 * 投影机-提取输入信号格式
	 * @param id
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2013-8-19
	 */
	public abstract ExcuteResultVO projGetPowerDisplay(String id);
	
	
	/**
	 * 投影机-提取当前电源状态
	 * @param id
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projGetPowerStatus(String id);
	
	/**
	 * 投影机-使用时长
	 * @param id
	 * @return ExcuteResultVO object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projUseTime(String id);
	
	/**
	 * 投影机-灯泡使用时长
	 * @param id
	 * @return ExcuteResultVO  object转换ProjVO
	 * @author ryan
	 * @since	2012-10-15
	 */
	public abstract ExcuteResultVO projLightUseTime(String id);
	
	/**
	 * 机顶盒-系统电源
	 * @param id
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvPower(String id);
	
	/**
	 * 机顶盒-静音
	 * @param id
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvMute(String id);
	
	/**
	 * 机顶盒-频道+
	 * @param id
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvPinDaoUp(String id);
	
	/**
	 * 机顶盒-频道-
	 * @param id
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvPinDaoDown(String id);
	
	/**
	 * 机顶盒-音量+
	 * @param id
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvMuteUp(String id);
	
	/**
	 * 机顶盒-音量-
	 * @param id
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvMuteDown(String id);
	
	/**
	 * 机顶盒-菜单
	 * @param id
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvMenu(String id);
	
	/**
	 * 机顶盒-输入号码
	 * @param id
	 * @param num 0-9
	 * @return ExcuteResultVO object转换TvVO
	 */
	public abstract ExcuteResultVO tvNum(String id,int num);
	
	/**
	 * 画面分割器-调用模式
	 * @param id
	 * @param num 
	 * @return ExcuteResultVO object转换VideomVO
	 */
	public abstract ExcuteResultVO videomModel(String id,String num);
	
	/**
	 * 画面分割器-信号切换-无实现
	 * @param id
	 * @param model
	 * @param num
	 * @param num2
	 * @return ExcuteResultVO object转换VideomVO
	 */
	public abstract ExcuteResultVO videomModelInfo(String id,String model,String num,String num2);
	
	
	/**
	 * 提取机顶盒的列表
	 * @return	ArrayList<TvVO>
	 */
	public  ArrayList<TvVO> getTvList(){
		ArrayList<TvVO> msvList = new ArrayList<TvVO>();
		Iterator<TvVO> i = CenterControlObjectHelp.getTvList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		
		Comparator<TvVO> comparator = new Comparator<TvVO>(){
			   public int compare(TvVO s1, TvVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
		return msvList;
	}
	
	
	/**
	 * 提取等离子的列表
	 * @return	ArrayList<PlaVO>
	 */
	public  ArrayList<PlaVO> getPlaList(){
		ArrayList<PlaVO> msvList = new ArrayList<PlaVO>();
		if(CenterControlObjectHelp.getPlaList(centerControlIp)!=null){
			Iterator<PlaVO> i = CenterControlObjectHelp.getPlaList(centerControlIp).values().iterator();
			while(i.hasNext()){
				msvList.add(i.next());
			}
		}
		Comparator<PlaVO> comparator = new Comparator<PlaVO>(){
			   public int compare(PlaVO s1, PlaVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
			
		return msvList;
	}
	
	/**
	 * 提取升降屏的列表
	 * @return	ArrayList<UpDownScreenVO>
	 */
	public  ArrayList<UpDownScreenVO> getUpDownScreenList(){
		ArrayList<UpDownScreenVO> msvList = new ArrayList<UpDownScreenVO>();
		Iterator<UpDownScreenVO> i = CenterControlObjectHelp.getUpDownScreenList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		Comparator<UpDownScreenVO> comparator = new Comparator<UpDownScreenVO>(){
			   public int compare(UpDownScreenVO s1, UpDownScreenVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
		return msvList;
	}
	
	/**
	 * 提取灯光的列表
	 * @return	ArrayList<LightVO>
	 */
	public  ArrayList<LightVO> getLightList(){
		ArrayList<LightVO> msvList = new ArrayList<LightVO>();
		Iterator<LightVO> i = CenterControlObjectHelp.getLightList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		//做正序排序
		Comparator<LightVO> comparator = new Comparator<LightVO>(){
		   public int compare(LightVO s1, LightVO s2) {
		     return  s1.getName().compareTo(s2.getName());
		   }
		};
		Collections.sort(msvList,comparator);
		return msvList;
	}
	
	/**
	 * 提取中控下窗帘列表
	 * @return ArrayList<CurtainVO>
	 */
	public ArrayList<CurtainVO> getCurtainList(){
		ArrayList<CurtainVO> msvList = new ArrayList<CurtainVO>();
		Iterator<CurtainVO> i = CenterControlObjectHelp.getCurtainList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		
		Comparator<CurtainVO> comparator = new Comparator<CurtainVO>(){
			   public int compare(CurtainVO s1, CurtainVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
		return msvList;
	}
	
	/**
	 * 提取中控下投影机列表
	 * @return ArrayList<ProjVO>
	 */
	public ArrayList<ProjVO> getProjList(){
		ArrayList<ProjVO> msvList = new ArrayList<ProjVO>();
		Iterator<ProjVO> i = CenterControlObjectHelp.getProjList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		Comparator<ProjVO> comparator = new Comparator<ProjVO>(){
			   public int compare(ProjVO s1, ProjVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
			
		return msvList;
	}
	
	/**
	 * 提取中控下的摄像头列表
	 * @return	ArrayList<CameraVO>
	 */
	public  ArrayList<CameraVO> getCameraList(){
		ArrayList<CameraVO> msvList = new ArrayList<CameraVO>();
		Iterator<CameraVO> i = CenterControlObjectHelp.getCameraList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		//做正序排序
		Comparator<CameraVO> comparator = new Comparator<CameraVO>(){
		   public int compare(CameraVO s1, CameraVO s2) {
		     return  s1.getName().compareTo(s2.getName());
		   }
		};
		Collections.sort(msvList,comparator);
		return msvList;
	}
	
	/**
	 * 提取中控下的矩阵列表
	 * @return	ArrayList<MatrixSwitchVO>
	 */
	public  ArrayList<MatrixSwitchVO> getMatrixSwitchList(){
		ArrayList<MatrixSwitchVO> msvList = new ArrayList<MatrixSwitchVO>();
		Iterator<MatrixSwitchVO> i = CenterControlObjectHelp.getMatrixList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		//做正序排序
		Comparator<MatrixSwitchVO> comparator = new Comparator<MatrixSwitchVO>(){
		   public int compare(MatrixSwitchVO s1, MatrixSwitchVO s2) {
		     return  s1.getName().compareTo(s2.getName());
		   }
		};
		Collections.sort(msvList,comparator);
		return msvList;
	}
	
	/**
	 * 提取中控下设备是否可用
	 * @return	ExcuteResultVO
	 */
	public abstract	ExcuteResultVO getEquipmentStatus (String id);
	
	/**
	 * 提取中控下的音频设备列表
	 * @return	ArrayList<AudioControlVO>
	 */
	public ArrayList<AudioControlVO> getAudioList (){
		ArrayList<AudioControlVO> msvList = new ArrayList<AudioControlVO>();
		Iterator<AudioControlVO> i = CenterControlObjectHelp.getAudioList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		
		//做正序排序
		Comparator<AudioControlVO> comparator = new Comparator<AudioControlVO>(){
		   public int compare(AudioControlVO s1, AudioControlVO s2) {
		     return  s1.getName().compareTo(s2.getName());
		   }
		};
		Collections.sort(msvList,comparator);
		return msvList;
	}
	/**
	 * 提取中控下的系统电源设备列表
	 * @return	ArrayList<SysPowerVO>
	 */
	public ArrayList<SysPowerVO> getSysPowerList (){
		ArrayList<SysPowerVO> msvList = new ArrayList<SysPowerVO>();
		Iterator<SysPowerVO> i = CenterControlObjectHelp.getSysPowerList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		
		Comparator<SysPowerVO> comparator = new Comparator<SysPowerVO>(){
			   public int compare(SysPowerVO s1, SysPowerVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
		return msvList;
	}
	/**
	 * 返回中控下的视频终端列表
	 * @return ArrayList<VedioTerminalVO>
	 */
	public ArrayList<VedioTerminalVO> getVedioTerminalList (){
		ArrayList<VedioTerminalVO> msvList = new ArrayList<VedioTerminalVO>();
		Iterator<VedioTerminalVO> i = CenterControlObjectHelp.getVedioTerminalList(centerControlIp).values().iterator();
		while(i.hasNext()){
			msvList.add(i.next());
		}
		Comparator<VedioTerminalVO> comparator = new Comparator<VedioTerminalVO>(){
			   public int compare(VedioTerminalVO s1, VedioTerminalVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(msvList,comparator);
		return msvList;
	}
	
	/**
	 * 返回中控下可以控制的设备类型
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getEquipmentList (){ 
		ArrayList<String> list = new ArrayList<String>();
		Iterator<String> i = CenterControlObjectHelp.equipmentMap.values().iterator();
		while(i.hasNext()){
			list.add(i.next());
		}
		
		Comparator<String> comparator = new Comparator<String>(){
			   public int compare(String s1, String s2) {
			     return  s1.compareTo(s2);
			   }
			};
			Collections.sort(list,comparator);
		return list;
	}
	
	/**
	 * 返回中控下的画面分割器列表
	 * @return ArrayList<VideomVO>
	 */
	public ArrayList<VideomVO> getVideomList (){
		ArrayList<VideomVO> list = new ArrayList<VideomVO>();
		Iterator<VideomVO> i = CenterControlObjectHelp.getVideomList(centerControlIp).values().iterator();
		while(i.hasNext()){
			list.add(i.next());
		}
		
		Comparator<VideomVO> comparator = new Comparator<VideomVO>(){
			   public int compare(VideomVO s1, VideomVO s2) {
			     return  s1.getName().compareTo(s2.getName());
			   }
			};
			Collections.sort(list,comparator);
		return list;
	}
	
	/**
	 * 提取当前检查终端的的线程数
	 * @return int
	 * add by ryan on 20140225
	 */
	public static int getNetStatusThreadNumber() {
		return EquipmentObjectImpl.net_status_thread_number_cc;
	}
	
	public String getIP(){
		return this.centerControlIp;
	}
	
	public int getPort(){
		return this.centerControlProt;
	}
	
	public CenterControlObject(CenterControlVO vo){
		this.centerControlIp = vo.getIp();
		this.centerControlProt = vo.getPort();
	}
}
