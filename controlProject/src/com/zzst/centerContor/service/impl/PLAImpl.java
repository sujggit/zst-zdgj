package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.CurtainVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	等离子控制
 *@date 2012-2-28上午10:37:10
 *@author ryan
 */
public class PLAImpl {

	private static Logger logger = Logger.getLogger(PLAImpl.class
			.getName());
	
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private	PlaVO plaVO;
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public PLAImpl(String ip,int port,PlaVO plaVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.plaVO = plaVO;
	}
	
	/**
	 * 等离子当前开关状态
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO plaStatus(){
		logger.info("等离子设备：PLAImpl		plaStatus		begin");
		try{
			String command  = ControlCommandHelp.PLA_STATUS[0];
			command  = command.replaceFirst("##1",plaVO.getId());
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("等离子设备提取状态异常："+e.getMessage());
		}
		resultVO.setObject(plaVO);
		logger.info("等离子设备：PLAImpl		plaStatus		end");
		return resultVO;
	}
	
	
	/**
	 * 等离子开
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO plaON(String id){
		logger.info("等离子设备：PLAImpl		plaON		begin");
		try{
			String command  = ControlCommandHelp.PLA_ON[0];
			command  = command.replaceFirst("##1",id);
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				plaVO.setStatus(PlaVO.status_on);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("等离子异常："+e.getMessage());
		}
		resultVO.setObject(plaVO);
		logger.info("等离子设备：PLAImpl		plaON		end");
		return resultVO;
	}
	/**
	 * 选择频道
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO plaChannel(String id,String no){
		logger.info("等离子设备：PLAImpl		plaChannel		begin");
		
		try{
			String command  = ControlCommandHelp.PLA_SWITCH[0];
			command  = command.replaceFirst("##1",id);
			command  = command.replaceFirst("##2",no);
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				plaVO.setChannel(no);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("等离子异常："+e.getMessage());
		}
		resultVO.setObject(plaVO);
		logger.info("等离子设备：PLAImpl		plaChannel		end");
		return resultVO;
	}
	/**
	 * 提取当前显示通道
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO plaChannel(String id){
		logger.info("等离子设备：PLAImpl		plaChannel		begin");
		
		try{
			String command  = ControlCommandHelp.PLA_SWITCH_STATUS[0];
			command  = command.replaceFirst("##1",id);
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("等离子异常："+e.getMessage());
		}
		resultVO.setObject(plaVO);
		logger.info("等离子设备：PLAImpl		plaChannel		end");
		return resultVO;
	}
	
	
	/**
	 * 等离子关
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO plaOFF(String id){
		logger.info("等离子设备：PLAImpl		plaOFF		begin");
		try{
			String command  = ControlCommandHelp.PLA_OFF[0];
			command  = command.replaceFirst("##1",id);
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
				plaVO.setStatus(PlaVO.status_off);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("升降屏升异常："+e.getMessage());
		}
		resultVO.setObject(plaVO);
		logger.info("等离子设备：PLAImpl		plaOFF		end");
		return resultVO;
	}
}
