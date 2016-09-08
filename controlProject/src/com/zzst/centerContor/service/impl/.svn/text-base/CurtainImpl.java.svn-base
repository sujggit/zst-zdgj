package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.CurtainVO;
import com.zzst.util.ExcuteResultVO;

/**
 *@Description	窗帘控制
 *@date 2012-7-6下午01:39:23
 *@author yangyi
 */
public class CurtainImpl {
	
	private static Logger logger = Logger.getLogger(LightImpl.class
			.getName());
	
	private String centerControlIP ;
	private int centerControlPort  ;
	private	CurtainVO curtainVO;
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public CurtainImpl(String ip,int port,CurtainVO curtainVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.curtainVO = curtainVO;
		
	}
	
	

	public String getCenterControlIP() {
		return centerControlIP;
	}

	public void setCenterControlIP(String centerControlIP) {
		this.centerControlIP = centerControlIP;
	}

	public int getCenterControlPort() {
		return centerControlPort;
	}

	public void setCenterControlPort(int centerControlPort) {
		this.centerControlPort = centerControlPort;
	}

	public CurtainVO getCurtainVO() {
		return curtainVO;
	}

	public void setCurtainVO(CurtainVO curtainVO) {
		this.curtainVO = curtainVO;
	}

	public ExcuteResultVO getResultVO() {
		return resultVO;
	}

	public void setResultVO(ExcuteResultVO resultVO) {
		this.resultVO = resultVO;
	}



	public ExcuteResultVO curtainClose(String id) {
		logger.info("窗帘设备：CurtainImpl		curtainClose		begin");
		String command  = ControlCommandHelp.CURTAIN_CLOSE[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				curtainVO.setStatus(CurtainVO.status_off);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("窗帘关异常："+e.getMessage());
		}
		resultVO.setObject(curtainVO);
		logger.info("窗帘设备：CurtainImpl		curtainClose		end");
		return resultVO;
	}



	public ExcuteResultVO curtainOpen(String id) {
		logger.info("窗帘设备：CurtainImpl		curtainOpen		begin");
		String command  = ControlCommandHelp.CURTAIN_OPEN[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				curtainVO.setStatus(CurtainVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("窗帘开异常："+e.getMessage());
		}
		resultVO.setObject(curtainVO);
		logger.info("窗帘设备：CurtainImpl		curtainOpen		end");
		return resultVO;
	}
	
	public ExcuteResultVO curtainStop(String id) {
		logger.info("窗帘设备：CurtainImpl		curtainStop		begin");
		String command  = ControlCommandHelp.CURTAIN_STOP[0].replaceFirst("##1",id);
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				curtainVO.setStatus(CurtainVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("窗帘开异常："+e.getMessage());
		}
		resultVO.setObject(curtainVO);
		logger.info("窗帘设备：CurtainImpl		curtainStop		end");
		return resultVO;
	}
}
