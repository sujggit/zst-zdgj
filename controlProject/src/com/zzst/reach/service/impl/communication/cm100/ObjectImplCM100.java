package com.zzst.reach.service.impl.communication.cm100;

import org.apache.log4j.Logger;

import com.zzst.reach.service.ReachObject;
import com.zzst.reach.service.vo.ReachVO;
import com.zzst.util.ExcuteResultVO;

public class ObjectImplCM100 extends ReachObject{
	private static Logger logger = Logger.getLogger(ObjectImplCM100.class
			.getName());
	
	
	public ObjectImplCM100(ReachVO vo) {
		super(vo);
		logger.info("CM100设备接口");
	}

	public ExcuteResultVO connect(int channelID,int bhighrate,String[] ips) {
		return null;
	}

	public ExcuteResultVO play(String fileName, int channelID) {
		return null;
	}

	public ExcuteResultVO continuePlay(int channelID) {
		return null;
	}

	public ExcuteResultVO pausePlay(int channelID) {
		return null;
	}
	
	public ExcuteResultVO stopPlay(int channelID) {
		return null;
	}

	public ExcuteResultVO unConnect(int channelID) {
		return null;
	}

	@Override
	public ExcuteResultVO channelStatus(int channelID) {
		return null;
	}

	@Override
	public ExcuteResultVO getRecordStatus(int channelID) {
		return null;
	}

}
