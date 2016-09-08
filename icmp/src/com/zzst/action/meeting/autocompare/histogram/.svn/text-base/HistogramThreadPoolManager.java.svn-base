package com.zzst.action.meeting.autocompare.histogram;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.autocompare.AutoCompareThread;
import com.zzst.application.mcuUtil.ConfAllPts;
import com.zzst.application.mcuVO.ZZOMainStatusVO;

/**
 * 
 * 音视频比对
 * mcu polling manager
 * @author Administrator
 *
 */
public class HistogramThreadPoolManager{
	private static Logger logger = CbfLogger.getLogger(HistogramThreadPoolManager.class.getName());	
	
	
	//the key is confFlagId
	private Map<String, HistogramThread> confPollMap = null;
	
	private Map<String, HistogramVoiceThread> voiceThreadMap = null;
	
	private static HistogramThreadPoolManager pollPtsPoolManager = null;
	private static HistogramThreadPoolManager pollPtsVoicePoolManager = null;
	
	private HistogramThreadPoolManager(){
		confPollMap = new HashMap<String, HistogramThread>();
	}
	
	
	private HistogramThreadPoolManager(String voice){
		voiceThreadMap = new HashMap<String, HistogramVoiceThread>();
	}
	
	
	public static HistogramThreadPoolManager getInstance(){
		if(pollPtsPoolManager == null){
			pollPtsPoolManager = new HistogramThreadPoolManager();
		}
		
		return pollPtsPoolManager;
	}
	
	public static HistogramThreadPoolManager getVoiceInstance(){
		if(pollPtsVoicePoolManager == null){
			pollPtsVoicePoolManager = new HistogramThreadPoolManager("音视频");
		}
		
		return pollPtsVoicePoolManager;
	}
	
	
	/**
	 * poll participants
	 * @param confFlagId
	 * @param ptsIpVmcuIps
	 * @param interval
	 */
	public boolean pollPts(String confFlagId,String VideoCardParameter, ZZOMainStatusVO mainMeetingRoom , List<ZZOMainStatusVO> meetingRoomList){
		long time = System.currentTimeMillis();
		boolean isPolling = false;
		if(pollPtsPoolManager == null || pollPtsPoolManager.getConfPollMap() == null){
			return isPolling;
		}
//		HistogramThread pollPtsObject = null;
		
		//conference polling doesn't exist
		if(pollPtsPoolManager.getConfPollMap().size() == 0 || !pollPtsPoolManager.getConfPollMap().containsKey(confFlagId) || 
				pollPtsPoolManager.getConfPollMap().get(confFlagId) == null){
			//pollPtsObject = new HistogramThread(confFlagId, ptsIpVmcuIps, interval);
			HistogramThread autoCompareThread = new HistogramThread(confFlagId,VideoCardParameter, mainMeetingRoom , meetingRoomList);
			pollPtsPoolManager.getConfPollMap().put(confFlagId,autoCompareThread);
			autoCompareThread.start();
			isPolling = true;
		}
		
		logger.debug("执行时长："+(System.currentTimeMillis()-time)); 
		return isPolling;
	}
	
	/**
	 * check if comparing thread is existed.
	 * @param confFlagId
	 * @param ptsIpVmcuIps
	 * @param interval
	 */
	public boolean isThreadExisted(String confFlagId){
		long time = System.currentTimeMillis();
		boolean isPolling = false;
		
		//conference polling doesn't exist
		if(pollPtsPoolManager != null && pollPtsPoolManager.getConfPollMap() != null && 
			pollPtsPoolManager.getConfPollMap().size() != 0 && pollPtsPoolManager.getConfPollMap().containsKey(confFlagId) && 
				pollPtsPoolManager.getConfPollMap().get(confFlagId) != null){
			isPolling = true;
		}
		if(pollPtsVoicePoolManager != null && pollPtsVoicePoolManager.getVoiceThreadMap() != null && 
				pollPtsVoicePoolManager.getVoiceThreadMap().size() != 0 && pollPtsVoicePoolManager.getVoiceThreadMap().containsKey(confFlagId) && 
				pollPtsVoicePoolManager.getVoiceThreadMap().get(confFlagId) != null){
				isPolling = true;
		}
		
		
		return isPolling;
	}
	
	
	
	/**
	 * poll participants
	 * @param confFlagId
	 * @param ptsIpVmcuIps
	 * @param interval
	 */
	public boolean pollPtsVoice(String confFlagId,String VideoCardParameter, ZZOMainStatusVO mainMeetingRoom , List<ZZOMainStatusVO> meetingRoomList){
		boolean isPolling = false;
		if(pollPtsVoicePoolManager == null || pollPtsVoicePoolManager.getVoiceThreadMap() == null){
			return isPolling;
		}
		HistogramThread pollPtsObject = null;
		
		//conference polling doesn't exist
		if(pollPtsVoicePoolManager.getVoiceThreadMap().size() == 0 || !pollPtsVoicePoolManager.getVoiceThreadMap().containsKey(confFlagId) || 
				pollPtsVoicePoolManager.getVoiceThreadMap().get(confFlagId) == null){
			//pollPtsObject = new HistogramThread(confFlagId, ptsIpVmcuIps, interval);
			HistogramVoiceThread autoCompareVoiceThread = new HistogramVoiceThread(confFlagId,VideoCardParameter, mainMeetingRoom , meetingRoomList);
			pollPtsVoicePoolManager.getVoiceThreadMap().put(confFlagId,autoCompareVoiceThread);
			autoCompareVoiceThread.start();
			isPolling = true;
		}
		 
		return isPolling;
	}
	/**
	 * stop polling
	 * @param confFlagId
	 */
	public boolean stopPolling(String confFlagId){
		boolean isStoped = false;
		if(pollPtsPoolManager == null || pollPtsPoolManager.getConfPollMap() == null){
			return isStoped;
		}
		
		if(pollPtsPoolManager.getConfPollMap().size() == 0 || !pollPtsPoolManager.getConfPollMap().containsKey(confFlagId) || 
				pollPtsPoolManager.getConfPollMap().get(confFlagId) == null){
			return isStoped;
		}
		
		HistogramThread pollPtsObject = pollPtsPoolManager.getConfPollMap().get(confFlagId);
		if(pollPtsObject == null){
			return isStoped;
		}
		//make pollPtsObject thread to wait
		pollPtsObject.setContinued(false);
		pollPtsObject.interrupt();
		pollPtsPoolManager.getConfPollMap().remove(confFlagId);
		
		return isStoped;
	}
	
	
	/**
	 * stop polling
	 * @param confFlagId
	 */
	public boolean stopVoicePolling(String confFlagId){
		boolean isStoped = false;
		if(pollPtsVoicePoolManager == null || pollPtsVoicePoolManager.getVoiceThreadMap() == null){
			return isStoped;
		}
		
		if(pollPtsVoicePoolManager.getVoiceThreadMap().size() == 0 || !pollPtsVoicePoolManager.getVoiceThreadMap().containsKey(confFlagId) || 
				pollPtsVoicePoolManager.getVoiceThreadMap().get(confFlagId) == null){
			return isStoped;
		}
		
		HistogramVoiceThread pollPtsObject = pollPtsVoicePoolManager.getVoiceThreadMap().get(confFlagId);
		if(pollPtsObject == null){
			return isStoped;
		}
		//make pollPtsObject thread to wait
		pollPtsObject.setContinued(false);
		pollPtsObject.interrupt();
		pollPtsVoicePoolManager.getVoiceThreadMap().remove(confFlagId);
		
		return isStoped;
	}
	
	
	/**
	 * remove special invalid polling object and stop this thread
	 * @param confFlagId
	 */
	public void removeInvalidPolling(String confFlagId){
		if(pollPtsPoolManager == null || pollPtsPoolManager.getConfPollMap() == null){
			return;
		}
		
		if(pollPtsPoolManager.getConfPollMap().size() == 0 || !pollPtsPoolManager.getConfPollMap().containsKey(confFlagId) || 
				pollPtsPoolManager.getConfPollMap().get(confFlagId) == null){
			return;
		}
		
		HistogramThread pollPtsObject = pollPtsPoolManager.getConfPollMap().get(confFlagId);
		if(pollPtsObject == null){
			return;
		}
		//make pollPtsObject thread to wait
//		pollPtsObject.setValid(false);
//		pollPtsObject.setContinued(true);
		pollPtsPoolManager.getConfPollMap().remove(confFlagId);
	}

	
	/**
	 * remove special invalid polling object and stop this thread
	 * @param confFlagId
	 */
	public void removeInvalidPollingVoice(String confFlagId){
		if(pollPtsVoicePoolManager == null || pollPtsVoicePoolManager.getVoiceThreadMap() == null){
			return;
		}
		
		if(pollPtsVoicePoolManager.getVoiceThreadMap().size() == 0 || !pollPtsVoicePoolManager.getVoiceThreadMap().containsKey(confFlagId) || 
				pollPtsVoicePoolManager.getVoiceThreadMap().get(confFlagId) == null){
			return;
		}
		
		HistogramVoiceThread pollPtsObject = pollPtsVoicePoolManager.getVoiceThreadMap().get(confFlagId);
		if(pollPtsObject == null){
			return;
		}
		//make pollPtsObject thread to wait
//		pollPtsObject.setValid(false);
//		pollPtsObject.setContinued(true);
		pollPtsVoicePoolManager.getVoiceThreadMap().remove(confFlagId);
	}
	
	public Map<String, HistogramThread> getConfPollMap() {
		return confPollMap;
	}

	public void setConfPollMap(Map<String, HistogramThread> confPollMap) {
		this.confPollMap = confPollMap;
	}

	public Map<String, HistogramVoiceThread> getVoiceThreadMap() {
		return voiceThreadMap;
	}

	public void setVoiceThreadMap(Map<String, HistogramVoiceThread> voiceThreadMap) {
		this.voiceThreadMap = voiceThreadMap;
	}

}
