package com.zzst.kst.service.impl;

import org.apache.log4j.Logger;

import com.zzst.util.ExcuteResultVO;



/**
 *@Description
 *@date 2012-8-27上午10:12:43
 *@author ryan
 */
public class VideoConferenceImpl {
	private static Logger logger = Logger.getLogger(VideoConferenceImpl.class
			.getName());
	
	private String videoIP  ;
	private int videoPort  ;
	
	public VideoConferenceImpl(){
		
	}
	
	public ExcuteResultVO conferenceCreat(String meetingName) {
		logger.info("VideoConferenceImpl	conferenceCreat	begin");
		
		logger.info("VideoConferenceImpl	conferenceCreat	end");
		return null;
	}
}
