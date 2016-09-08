package com.zzst.centerContor.service.impl;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.vo.VedioTerminalVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	视频终端
 *@date 2011-12-23上午11:53:26
 *@author ryan
 */
public class VedioTerminalImpl {
	private static Logger logger = Logger.getLogger(VedioTerminalImpl.class
			.getName());
	
	
	private String  centerControlIP  ;
	private int 	centerControlPort  ;
	private VedioTerminalVO termianlVO = new VedioTerminalVO();
	
	
	private CenterControlClientThread ccThread= null;
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public VedioTerminalImpl(String ccIP,int port,VedioTerminalVO vtvo){
		this.centerControlIP = ccIP;
		this.centerControlPort = port;
		this.termianlVO = vtvo; 
		ccThread = new CenterControlClientThread(centerControlIP,centerControlPort);
	}
	
	
	
	
}
