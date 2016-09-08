package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.DvdVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	DVD控制
 *@date 2012-7-6下午01:39:23
 *@author ryan
 */
public class DvdImpl {
	private static Logger logger = Logger.getLogger(AudioControlImpl.class
			.getName());
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private DvdVO dvdVO  ;
	
	private CenterControlClientThread ccThread= null;
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public DvdImpl(String ip,int port,DvdVO dvdVO){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.dvdVO = dvdVO;
		ccThread = new CenterControlClientThread(centerControlIP,centerControlPort);
	}
	
	
	/**
	 * 提取状态
	 * @return
	 */
//	public  ExcuteResultVO dvdStatus(){
//		logger.info("音频设备控制：getMuteStatus		begin");
//		String command  = ControlCommandHelp.DVD_POWER_STATUS[0].replaceFirst("##1", dvdVO.getId());
//		try{
//			String str ="";
//			if(ccThread!=null){
//				str= ccThread.sendCommandByReturn(command);	
//				if(ControlCommandHelp.DVD_POWER_STATUS[1].replaceFirst("##1", dvdVO.getId()).equalsIgnoreCase(str)){
//					dvdVO.setStatus(DvdVO.status_on);
//					resultVO.setSuccess(true);
//				}else if(ControlCommandHelp.DVD_POWER_STATUS[1].replaceFirst("##1", dvdVO.getId()).equalsIgnoreCase(str)){
//					dvdVO.setStatus(DvdVO.status_off);
//					resultVO.setSuccess(true);
//				}else{
//					logger.warn("音频设备	提取状态		返回值不正确");
//				}
//			}
//		}catch(Exception e){
//			resultVO.setSuccess(false);
//			resultVO.setDes(e.getMessage());
//			logger.error("异常："+e.getMessage());
//		}
//		resultVO.setObject(dvdVO);
//		return resultVO;
//	}
}
