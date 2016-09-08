package com.zzst.terminal.service.impl;

import java.util.ArrayList;

import com.zzst.terminal.service.ZZSTTerminalObject;
import com.zzst.terminal.service.impl.communication.TerminalClientThread;
import com.zzst.terminal.service.impl.communication.TerminalCommnadEnues;
import com.zzst.util.ZZSTControlException;


/**
 *@Description
 *@date 2011-3-21下午07:00:00
 *@author ryan
 */
public class TerminalImpl_old	extends	ZZSTTerminalObject {

	
	public TerminalImpl_old(String ip){
		super(ip);
	}
	
	/**
	 * 提取终端声音状态---需要现场测试
	 * @return
	 */
	public String getMuteStatus(){
		sendCommandByBackInfo(TerminalCommnadEnues.COMMAND_MUTE_NEAR_STATUS[0]);
		return getEquipmentInfo(terminalIp)[3];
		//sendCommand(TerminalImplHelp.COMMAND_MUTE_NEAR_STATUS);
//		if(terminalIp.equals(ZZSTTerminalObject.venueID[0])){
//			return ZZSTTerminalObject.muteStatus[0];	
//		}else if(terminalIp.equals(ZZSTTerminalObject.venueID[1])){
//			return ZZSTTerminalObject.muteStatus[1];	
//		}else if(terminalIp.equals(ZZSTTerminalObject.venueID[2])){
//			return ZZSTTerminalObject.muteStatus[2];	
//		}else {
//			return ZZSTTerminalObject.muteStatus[3];	
//		}
		
	}
	
	/**
	 * 提取终端通话信息
	 * @return
	 *  数组说明
	 * 0：输出速率
	 * 1：输入速率
	 * 2：输出视频协议
	 * 3：输入视频协议
	 * 4：输出视频格式
	 * 5：输入视频格式
	 * 6：输出音频协议
	 * 7：输入音频协议
	 * 8：总丢包率
	 * 9：数据包丢失百分比
	 * 10：tcp
	 * 11：输出音频速率
	 * 12：输入音频速率
	 * 13：输出视频速率
	 * 14：输入视频速率
	 * 15：输出使用中的视频速率
	 * 16：输入使用中的视频速率
	 * 17：输出视频帧速率
	 * 18：输入视频帧速率
	 * 19：输出视频数据包丢失
	 * 20：输入视频数据包丢失
	 * 21：输出视频抖动
	 * 22：输入视频抖动
	 * 23：输出音频数据包丢失
	 * 24：输入音频数据包丢失
	 * 25：输出音频抖动
	 * 26：输入音频抖动
	 * 28：dc
	 * 29：rcp
	 * 30: rsid
	 * 31：ccaps
	 */
	public String[] getTerminalCallInfo(){
		sendCommandByBackInfo(TerminalCommnadEnues.CALL_INFO_COMMAND1[0]);
		sendCommandByBackInfo(TerminalCommnadEnues.CALL_INFO_COMMAND3[0]);
		
		return  getEquipmentCallInfo(terminalIp);
	}
	
	/**
	 * 提取终端音量值---？？？
	 * @return
	 */
	public String[] getMuteSoundValue(){
		sendCommandByBackInfo(TerminalCommnadEnues.CALL_INFO_COMMAND3[0]);
		return  getEquipmentSoundInfo(terminalIp);
	}
	
	/**
	 * 向终端发送提示信息
	 * @return
	 */
	public boolean sendContentToTerminal(String content){
		return sendCommand(TerminalCommnadEnues.COMMAND_SEND_CONTENT.replaceAll("##1", content));
	}
	
	/**
	 * 控制近端摄像机一直向左移动
	 * @return
	 */
	public boolean cameraMoveLeft(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_LEFT);
	}
	
	/**
	 * 控制近端摄像机向左跳动
	 * @return
	 */
	public boolean cameraLeft(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_LEFT);
	}
	
	/**
	 * 控制近端摄像机一直向右移动
	 * @return
	 */
	public boolean cameraMoveRight(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_RIGHT);
	}
	
	/**
	 * 控制近端摄像机向右跳动
	 * @return
	 */
	public boolean cameraRight(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_RIGHT);
	}
	
	/**
	 * 控制近端摄像机一直向上移动
	 * @return
	 */
	public boolean cameraMoveUp(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_UP);
	}
	
	/**
	 * 控制近端摄像机向上跳动
	 * @return
	 */
	public boolean cameraUp(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_UP);
	}
	
	/**
	 * 控制近端摄像机一直向下移动
	 * @return
	 */
	public boolean cameraMoveDown(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_DOWN);
	}
	
	/**
	 * 控制近端摄像机向下跳动
	 * @return
	 */
	public boolean cameraDown(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_DOWN);
	}
	
	/**
	 * 控制近端摄像机一直聚焦--近
	 * @return
	 */
	public boolean cameraMoveNear(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_NEAR);
	}
	
	/**
	 * 控制近端摄像机跳动一格聚焦--近
	 * @return
	 */
	public boolean cameraNear(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_NEAR);
	}
	
	/**
	 * 控制近端摄像机一直聚焦--远
	 * @return
	 */
	public boolean cameraMoveFar(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_FAR);
	}
	/**
	 * 控制近端摄像机跳动一格聚焦--远
	 * @return
	 */
	public boolean cameraFar(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_FAR);
	}
	
	
	/**
	 * 设置摄像头当前位置到预置位
	 * @param number
	 * @return
	 */
	public boolean cameraSetPosition(String number){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_PRESET_SET.replaceAll("##1", number));
		//return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_POSITION_SET.replaceAll("##1", number));
	}
	
	/**
	 * 调用摄像头预置位
	 * @param number
	 * @return
	 */
	public boolean cameraGetPosition(String number){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_PRESET_GET.replaceAll("##1", number));
		//return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_POSITION_GET.replaceAll("##1", number));
	}
		
	/**
	 * 控制近端摄像机停止移动
	 * @return
	 */
	public boolean cameraMoveStop(){
		return sendCommand(TerminalCommnadEnues.COMMAND_CAMERA_NEAR_MOVE_STOP);
	}
	
	/**
	 * 选择终端的输入摄像头
	 * @return
	 */
	public boolean cameraSelectNumber(String mumber){
		String command =TerminalCommnadEnues.COMMAND_CAMERA_SELECT_NUMBER.replaceFirst("##1", mumber);
		return sendCommand(command);
	}
	
	/**
	 * /**
	 * 设置终端输出格式为vga 50hz720p
	 * 呼通状态下不能更改
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public boolean monitorOutVGA50hz720p(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_DISPLAY_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "vga 16:9");
		command = command.replaceFirst("##3", "50hz720p");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端输出格式为dvi 50hz720p
	 * 呼通状态下不能更改
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public boolean monitorOutDVI50hz720p(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_DISPLAY_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "dvi 4:3");
		command = command.replaceFirst("##3", "50hz720p");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端输出格式为YPbPr 1080i
	 * 呼通状态下不能更改
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public boolean monitorOutYPbPr1080i(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_DISPLAY_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "component 16:9");
		command = command.replaceFirst("##3", "1080i");
		return sendCommand(command);
	}
	
	/**
	 * 提取终端监视器显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public boolean monitorGetView(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_GET.replaceFirst("##1", "monitor"+monitorNumber);
		return sendCommand(command);
	}
	
	/**
	 * 设置终端监视器显示近端视频
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public boolean monitorSetViewNear(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "near");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端监视器显示近端视频
	 * @param monitorNumber 编号为 1、2
	 * @return
	 */
	public boolean monitorSetViewFar(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "far");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端监视器显示近端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public boolean monitorSetViewNearOrContent(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "near-or-content");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端监视器显示远端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public boolean monitorSetViewFarOrContent(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "near-or-content");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端监视器显示远端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public boolean monitorSetViewFarOrNear(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "near-or-far");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端监视器显示近端视频、远端视频、显示内容
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public boolean monitorSetViewAll(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "all");
		return sendCommand(command);
	}
	
	/**
	 * 设置终端监视器不显示
	 * @param monitorNumber 编号为 1、2
	 * @return boolean
	 */
	public boolean monitorSetViewNone(String monitorNumber){
		String command =TerminalCommnadEnues.COMMAND_CONFIG_PRESENTATION_SET.replaceFirst("##1", "monitor"+monitorNumber);
		command = command.replaceFirst("##2", "none");
		return sendCommand(command);
	}
	
	/**
	 * 返回终端web控制界面URL
	 * @return 
	 */
	public String getFarmage(){
		return TerminalCommnadEnues.WEB_URL_FAR_IMAGE.replaceFirst("##1", this.terminalIp);
	}
	
	/**
	 * 提示声音
	 * @param number  范围是1-4
	 * @return
	 */
	public boolean getPromptSound(String number){
		return sendCommand(TerminalCommnadEnues.COMMAND_SOUND_PROMPT_SET.replaceFirst("##1", number));
	}
	
	/**
	 * 终端呼叫铃音
	 * 未测试
	 * @param number  范围是1-10
	 * @return
	 */
	public boolean getCallSound(String number){
		return sendCommand(TerminalCommnadEnues.COMMAND_SOUND_CALL_SET.replaceFirst("##1", number));
	}
	
	/**
	 * 终端发送双流
	 * 相当于遥控器上的"内容"按钮
	 * @return boolean
	 */
	public boolean graphics(){
		return sendCommand(TerminalCommnadEnues.COMMAND_GRAPHICS);
	}
	
	/**
	 * 终端发送双流
	 *没实现 
	 * @return boolean
	 */
	public boolean graphicsPlay(){
		return true;//sendCommand(TerminalCommnadEnues.COMMAND_GRAPHICS_PLAY);
	}
	
	/**
	 * 终端结束双流
	 * 没实现
	 * @return boolean
	 */
	public boolean graphicsStop(){
		return true;//sendCommand(TerminalCommnadEnues.COMMAND_GRAPHICS_STOP);
	}
	
	/**
	 * 非静音
	 * 没实现
	 * @return boolean
	 */
	public boolean muteOn(){
		return sendCommand(TerminalCommnadEnues.COMMAND_MUTE_NEAR_OFF);
	}
	
	/**
	 * 静音
	 * 没实现
	 * @return boolean
	 */
	public boolean muteOFF(){
		return sendCommand(TerminalCommnadEnues.COMMAND_MUTE_NEAR_ON);
	}
	/**
	 * 终端发送命令
	 * @param command
	 * @return
	 */
	private boolean sendCommand(String command){
		try {
			//
			TerminalClientThread.sendCommandToTerminal(terminalIp, terminalPort, command);
		} catch (ZZSTControlException e) {
		}
		return true;
	}
	
	/**
	 * 终端发送命令提取返回值
	 * @param command
	 * @return
	 */
	private boolean sendCommandByBackInfo(String command){
		try {
			//new TerminalClientThreadByReturn(terminalIp,terminalPort,command).sendCommand();
		} catch (Exception e) {
		}
		return true;
	}

}
