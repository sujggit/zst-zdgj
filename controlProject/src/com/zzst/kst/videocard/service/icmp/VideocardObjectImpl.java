package com.zzst.kst.videocard.service.icmp;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.zzst.kst.videocard.service.VideocardObject;
import com.zzst.kst.videocard.service.icmp.communication.ServerSocketThread;
import com.zzst.kst.videocard.vo.VideoCardVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description
 *@date 2012-8-12上午11:43:14
 *@author ryan
 */
public class VideocardObjectImpl extends VideocardObject{
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	private ServerSocketThread thread= null;
	private static Logger logger = Logger.getLogger(VideocardObjectImpl.class
			.getName());
	
	public VideocardObjectImpl(VideoCardVO vcVO) {
		super(vcVO);
	}
	 
	@Override
	public ExcuteResultVO setModel(byte[] sendCommand) {
		logger.info("视频对比卡：setModel		begin");
		try{
			logger.info("参数："+new String(sendCommand));
			resultVO.setSuccess(true);
			//resultVO.setObject(null);//需要返回值时需要
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("异常："+e.getMessage());
		}
		logger.info("视频对比卡：setModel		end");
		return resultVO;
	}



	@Override
	public ExcuteResultVO getVideoCardObj() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ExcuteResultVO restart() {
		// TODO Auto-generated method stub
		
		return null;
	}



	@Override
	public ExcuteResultVO setIP(String gateway, String mask) {
		// TODO Auto-generated method stub
		return null;
	}
}
