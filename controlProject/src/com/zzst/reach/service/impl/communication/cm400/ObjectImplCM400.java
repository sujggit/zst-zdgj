package com.zzst.reach.service.impl.communication.cm400;

import org.apache.log4j.Logger;

import com.zzst.reach.service.ReachObject;
import com.zzst.reach.service.vo.ReachVO;
import com.zzst.util.ExcuteResultVO;

public class ObjectImplCM400 extends ReachObject{
	private static Logger logger = Logger.getLogger(ObjectImplCM400.class
			.getName());
	
	public ObjectImplCM400(ReachVO vo) {
		super(vo);
		logger.info("CM400设备接口");
	}

	public ExcuteResultVO connect(int channelID,int bhighrate,String[] ips) {
		return null;
	}

	public ExcuteResultVO play(String fileName, int channelID) {
		return null;
	}

	public ExcuteResultVO continuePlay(int channelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ExcuteResultVO pausePlay(int channelID) {
		return null;
	}
	public ExcuteResultVO stopPlay(int channelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ExcuteResultVO unConnect(int channelID) {
		return null;
	}

	@Override
	public ExcuteResultVO channelStatus(int channelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExcuteResultVO getRecordStatus(int channelID) {
		// TODO Auto-generated method stub
		return null;
	}

}
