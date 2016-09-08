package com.zzst.reach.service.impl;

import com.zzst.reach.service.ReachObject;
import com.zzst.reach.service.impl.communication.cm100.ObjectImplCM100;
import com.zzst.reach.service.impl.communication.cm200.ObjectImplCM200;
import com.zzst.reach.service.impl.communication.cm400.ObjectImplCM400;
import com.zzst.reach.service.vo.ReachVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	锐取录播服务器接口实现类
 *@date 2013-1-21下午02:50:45
 *@author ryan
 */
public class ReachObjectImpl extends ReachObject {

	
	public ReachObject obj;
	public ReachObjectImpl(ReachVO vo) {
		super(vo);
		if(vo.getServerType().equalsIgnoreCase(ReachVO.cm100)) obj = new ObjectImplCM100(vo);
		if(vo.getServerType().equalsIgnoreCase(ReachVO.cm200)) obj = new ObjectImplCM200(vo);
		if(vo.getServerType().equalsIgnoreCase(ReachVO.cm400)) obj = new ObjectImplCM400(vo);
	}

	@Override
	public ExcuteResultVO connect(int channelID,int bhighrate,String[] ips) {
		return obj.connect(channelID, bhighrate, ips);
	}

//	@Override
//	public ExcuteResultVO getRoomStatus(String roomID) {
//		return obj.getRoomStatus(roomID);
//	}

	@Override
	public ExcuteResultVO play(String fileName, int channelID) {
		return obj.play(fileName, channelID);
	}

	@Override
	public ExcuteResultVO continuePlay(int channelID) {
		return obj.continuePlay(channelID);
	}

	@Override
	public ExcuteResultVO pausePlay(int channelID) {
		return obj.pausePlay(channelID);
	}
	
	@Override
	public ExcuteResultVO stopPlay(int channelID) {
		return obj.stopPlay(channelID);
	}

	@Override
	public ExcuteResultVO unConnect(int channelID) {
		return obj.unConnect(channelID);
	}

	@Override
	public ExcuteResultVO channelStatus(int channelID) {
		return obj.channelStatus(channelID);
	}

	@Override
	public ExcuteResultVO getRecordStatus(int channelID) {
		return obj.getRecordStatus(channelID);
	}

}
