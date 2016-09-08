package com.zzst.centerContor.service.impl;


import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.UpDownScreenVO;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	大屏控制
 *@date 2011-12-26上午11:30:27
 *@author ryan
 */
public class VeiwScreetnImpl {
	private static Logger logger = Logger.getLogger(VeiwScreetnImpl.class
			.getName());
	
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private ViewScreentVO viewScreentVO;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public VeiwScreetnImpl(String ip,int port,ViewScreentVO vo){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.viewScreentVO = vo;
		resultVO.setObject(viewScreentVO);
	}


	/**
	 * 设置大屏模式
	 * @param no
	 * @return
	 */
	public ExcuteResultVO setWallModel(String no) {
		logger.info("大屏设备：setWallModel		begin");
		String command  = ControlCommandHelp.SCREENT_SET_MODEL[0].replaceFirst("##1", viewScreentVO.getId());
		command	= command.replaceFirst("##2", no);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				viewScreentVO.setModel(no);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(viewScreentVO);
		return resultVO;
	}

	/**
	 * 设置大屏模式下详细信息
	 * @param no
	 * @param handle
	 * @param sourceName
	 * @return ExcuteResultVO
	 */
	public ExcuteResultVO setWallModelInfo(String no, String handle, String sourceName) {
		logger.info("大屏设备：viewScreentModelInfo		没有实现");
//		String command  = ControlCommandHelp.SCREENT_SET_MODEL_INFO[0].replaceFirst("##1", viewScreentVO.getId());
//		command	= command.replaceFirst("##2", no);
//		command	= command.replaceFirst("##3", handle);
//		command	= command.replaceFirst("##4", sourceName);
//		try{
//			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
//				resultVO.setSuccess(true);
//			}
//		}catch(Exception e){
//			resultVO.setSuccess(false);
//			resultVO.setDes(e.getMessage());
//			logger.error("异常："+e.getMessage());
//		}
//		resultVO.setObject(viewScreentVO);
		return resultVO;
	}
	
	
	//测试用，add by yangyi
	/**
	 * 设置大屏数据共享模式下详细信息（VLink）
	 * @param no
	 * @param model
	 * @param sourceName
	 * @return ExcuteResultVO
	 */
	public ExcuteResultVO setModelInfo(String id, String no, String sourceName) {
		logger.info("大屏设备：viewScreentModelInfo		begin	没有实现");
//		String command  = ControlCommandHelp.SCREENT_MODEL_INFO[0].replaceFirst("##1",id );
//		command	= command.replaceFirst("##2", no);
//		command	= command.replaceFirst("##3", sourceName);
//		try{
//			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
//				resultVO.setSuccess(true);
//			}
//		}catch(Exception e){
//			resultVO.setSuccess(false);
//			resultVO.setDes(e.getMessage());
//			logger.error("异常："+e.getMessage());
//		}
		resultVO.setObject(viewScreentVO);
		return resultVO;
	}
	
	/**
	 * 
	 *询问电源开发状态
	 * @return
	 */
	public ExcuteResultVO getWallPowerStatus() {
		logger.info("大屏设备：getWallPowerStatus		begin");
		String command  = ControlCommandHelp.SCREENT_STATUS[0].replaceFirst("##1", viewScreentVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备：getWallPowerStatus		end");
		return resultVO;
	}


	/**
	 * 查询大屏当前的模式
	 * @return
	 */
	public ExcuteResultVO getWallModelStatus() {
		logger.info("大屏设备：VeiwScreetnImpl	getWallModelStatus		begin"+this.centerControlIP);
		String command  = ControlCommandHelp.SCREENT_MODEL_STATUS[0].replaceFirst("##1", viewScreentVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备：VeiwScreetnImpl	getWallModelStatus		end"+this.centerControlIP);
		return resultVO;
	}
	
	/**
	 * 询问大屏当前的模式及详细信息
	 * @return
	 */
	public ExcuteResultVO getWallModelStatusInfo() {
		logger.info("大屏设备：VeiwScreetnImpl	getWallModelStatusInfo		begin"+this.centerControlIP);
		String command  = ControlCommandHelp.SCREENT_MODEL_STATUS_INFO[0].replaceFirst("##1", viewScreentVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
			
//			String str = ccThread.sendCommandByReturn(command);
//			if(str!=null&&str.length()>0){
//				int num = str.indexOf(ControlCommandHelp.SCREENT_MODEL_STATUS_INFO[1].replaceFirst("##1", viewScreentVO.getId()));
//				if(!(num<0)){
//					int sourceName = str.indexOf("INFO>");
//					String[] commandReturn = str.substring(sourceName+5, str.length()).split(">");
//					if(commandReturn!=null){
//						viewScreentVO.addModelInfo(commandReturn);
//					}
//					resultVO.setSuccess(true);
//				}else{
//					resultVO.setSuccess(false);
//					resultVO.setDes("中控返回值异常："+str);
//				}
//			}else{
//				resultVO.setSuccess(false);
//				resultVO.setDes("中控返回值异常："+str);
//			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备：	VeiwScreetnImpl		getWallModelStatusInfo		end"+this.centerControlIP);
		return resultVO;
	}
	
	/**
	 * 大屏电源关
	 * @return
	 */
	public ExcuteResultVO setWallPowerOff() {
		logger.info("大屏设备：VeiwScreetnImpl		setWallPowerOff		begin");
		String command  = ControlCommandHelp.SCREENT_OFF[0].replaceFirst("##1", viewScreentVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				viewScreentVO.setStatus(ViewScreentVO.status_off);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备：VeiwScreetnImpl		setWallPowerOff		end");
		return resultVO;
	}

	/**
	 * 大屏电源开
	 * @return
	 */
	
	public ExcuteResultVO setWallPowerOn() {
		logger.info("大屏设备：VeiwScreetnImpl		setWallPowerOn		begin");
		String command  = ControlCommandHelp.SCREENT_ON[0].replaceFirst("##1", viewScreentVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				viewScreentVO.setStatus(ViewScreentVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备：VeiwScreetnImpl		setWallPowerOn		end");
		return resultVO;
	}
	
	/**
	 * 初始化数据，不去中控询问 
	 * @return
	 */
	public ExcuteResultVO viewScreentModelList() {
		logger.info("大屏设备模式列表：VeiwScreetnImpl		viewScreentModelList		begin");
		resultVO.setSuccess(true);
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备模式列表：VeiwScreetnImpl		viewScreentModelList		end");
		return resultVO;
	}
	
	public ExcuteResultVO viewScreentModelSwitchOutPort() {
		logger.info("大屏设备模式输出端口列表：VeiwScreetnImpl	viewScreentModelSwitchOutPort		begin");
		resultVO.setSuccess(true);
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备模式输出端口列表：VeiwScreetnImpl	viewScreentModelSwitchOutPort		end");
		return resultVO;
	}
	
	
	public ExcuteResultVO viewScreentModelSwitch(String id,String modelID,String in,String out) {
		logger.info("大屏设备：VeiwScreetnImpl	viewScreentModelSwitch		begin");
		 String command  = ControlCommandHelp.SCREENT_MODEL_SWITCH[0].replaceFirst("##1", viewScreentVO.getId());
		 command  = command.replaceFirst("##2", modelID);
		 command  = command.replaceFirst("##3", in);
		 command  = command.replaceFirst("##4", out);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		resultVO.setObject(viewScreentVO);
		logger.info("大屏设备：VeiwScreetnImpl	viewScreentModelSwitch		end");
		return resultVO;
	}
	
	/**
	 * 十进制转16进制
	 * @param str
	 * @return String
	 */
	private String getHex(String str){
		String strHex = "0123456789ABCDEF";
		byte[] bArray = str.getBytes();
		StringBuffer  sb = new StringBuffer();
        for (int i = 0; i < bArray.length; i++) {
        	sb.append(strHex.charAt(0xf & bArray[i] >> 4)+""+ strHex.charAt(bArray[i] & 0xf));
        }
        return sb.toString();
	}
}
