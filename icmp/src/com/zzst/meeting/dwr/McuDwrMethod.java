package com.zzst.meeting.dwr;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ServerContext;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.autocompare.AutoCompareThread;
import com.zzst.action.meeting.meeting.McuControlDwr;
import com.zzst.action.meeting.meeting.McuControlHelper;
import com.zzst.action.meeting.meetingStatic.MeetingDetialStatic;
import com.zzst.action.meeting.util.BaseInfoHelp;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.MeetingControlStatus;
import com.zzst.action.meeting.util.MeetingUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.tools.CommonUtil;
import com.zzst.application.mcuUtil.ConfAllPts;
import com.zzst.application.mcuUtil.ConfManager;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfProfileVO;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMainVO;
import com.zzst.application.mcuVO.ZZOMediaSourcesVO;
import com.zzst.application.mcuVO.ZZOPtsChannel;
import com.zzst.application.mcuservice.conf.ConfServiceImpl;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.PollTerminalEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.enums.VideoconferenceEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.information.InformationVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.equipment.EquipmentService;
import com.zzst.service.meeting.equipment.EquipmentTerminalServiceImpl;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;
import com.zzst.service.meeting.pollTemplate.PollTemplateService;
import com.zzst.service.meeting.pollTerminal.PollTerminalService;

public class McuDwrMethod {
	private static Logger logger = CbfLogger.getLogger(McuDwrMethod.class.getName());
	private static int count = 0;
	private static String info;
	private static Map<String, String> broadcastMap = new HashMap<String, String>();
	//private static MeetingUtil meetingUtil = new MeetingUtil();
	private static Map<String,String[][]> userMainStatusMap = new HashMap<String,String[][]>();
	
	private static HashMap<String,HashMap<String,String>> terComment = new HashMap<String,HashMap<String,String>>();
	
	public Map<String, String> muteParticipants(String meetingDetailID, String ptsIpVmcuIps, boolean isMuted){
		addMcuLog("mute " + ptsIpVmcuIps + isMuted,LogEnum.TYPE_CONTROL_OPERATION);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(meetingDetailID, ptsIpVmcuIps, isMuted);
	}
	public Map<String, String> dialParticipants(String meetingDetailID, String ptsIpVmcuIps, boolean isDialed){
		addMcuLog("dial " + ptsIpVmcuIps + isDialed,LogEnum.TYPE_CONTROL_OPERATION);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().dialParticipants(meetingDetailID, ptsIpVmcuIps, isDialed);
		
	}
	
	public Map<String, String> blockParticipants(String meetingDetailID, String ptsIpVmcuIps, boolean isDialed){
		addMcuLog("block " + ptsIpVmcuIps + isDialed,LogEnum.TYPE_CONTROL_OPERATION);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().blockParticipants(meetingDetailID, ptsIpVmcuIps, isDialed);
	}
	
	public Map<String, String> suspendParticipants(String meetingDetailID, String ptsIpVmcuIps, boolean isDialed){
		addMcuLog("suspend " + ptsIpVmcuIps + isDialed,LogEnum.TYPE_CONTROL_OPERATION);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().suspendParticipants(meetingDetailID, ptsIpVmcuIps, isDialed);
	}
	
	public void addParticipants(String meetingDetailID, String meetingRoomIDs, String meetingRoomNames){
	
		ArrayList<EquipmentTerminalVO> equipmentTerminalVOList;
		try {
			equipmentTerminalVOList = new EquipmentTerminalServiceImpl().queryByRoomIDs(meetingRoomIDs);		
			if(equipmentTerminalVOList != null && equipmentTerminalVOList.size() > 0){
				StringBuffer buffer = new StringBuffer();
				for(int i=0; i<equipmentTerminalVOList.size(); i++){
					EquipmentTerminalVO terminal = equipmentTerminalVOList.get(i);
					if(i > 0){
					 buffer.append(",");	
					}
					buffer.append("'" + terminal.getIp() + "'");
				}
				ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
				Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = MeetingUtil.getMCU(buffer.toString());
				Set<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> set = map.entrySet();
		        for (Iterator<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> it = set.iterator(); it.hasNext();) {
		            Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>> entry = (Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>) it.next();
		            EquipmentMcuVO outMcuVO = entry.getKey();
		            List<EquipmentTerminalVO> terminalList = entry.getValue();
		            ZZOMainVO innerMcuVO = new ZZOMainVO();
		            innerMcuVO.setEquipmentIP(outMcuVO.getIp());
		            innerMcuVO.setModelID(outMcuVO.getEquipmentModel());
		            //MCU 4000 and MCU 2000 use the same model id
		            if(outMcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
		            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
		            }
		            //		            innerMcuVO.setEquipmentIP("110.0.0.1");
//		            innerMcuVO.setModelID(MCUConfig.RMX2000C_EQUIPMENT_MODEL_ID);
		            List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
		           
		            for(EquipmentTerminalVO outTerminal : terminalList){
		            	 ZZOMainVO innerTerminalVO = new ZZOMainVO();
		            	 innerTerminalVO.setEquipmentName(outTerminal.getMeetingRoomVO().getMeetingRoomName());
		            	 innerTerminalVO.setEquipmentIP(outTerminal.getIp());
		            	 innerTermList.add(innerTerminalVO);
		            }
		            
//		            for(int i=0; i<terminalList.size(); i++){
//		            	EquipmentTerminalVO outTerminal = terminalList.get(i);
//		            	 ZZOMainVO innerTerminalVO = new ZZOMainVO();
//		            	 innerTerminalVO.setEquipmentName(outTerminal.getEquipmentName() + i);
//		            	 innerTerminalVO.setEquipmentIP("10.10.10.1" + count++);
//		            	 innerTermList.add(innerTerminalVO);
//		            }
		            innerMcuVO.setSubMainVOList(innerTermList);
		            innerMcuVOList.add(innerMcuVO);
		        }
		        ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(meetingDetailID, innerMcuVOList);
		        addMcuLog("add pts " + meetingRoomIDs,LogEnum.TYPE_CONTROL_OPERATION);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * monitor pts
	 * @param infos
	 * @return
	 * @author zhangjy
	 */
	public boolean setVideoScreenYJ(String infos){
		String[] tinfos=infos.split("_");
		ZZOConfVO confVO=new ZZOConfVO();
		ZZOConfVO tempconfVo=new ZZOConfVO();
		
			try {
				confVO.setConfFlagId(tinfos[2]);
				List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
				for (ZZOConfVO cVO : confList) {
					if(cVO.getMcuIP().equals(tinfos[3])&&cVO.getGuid().equals(tinfos[1])){
						tempconfVo=cVO;
					}
				}
				String[] splitInfos = tinfos[0].split("_");
				System.out.println(tinfos[2]+" | "+tempconfVo.getConfID()+" | "+""+" | "+ tempconfVo.getVideoMode()+" | "+tempconfVo.getLayoutMode()+" | "+ 1+" | "+ tinfos[0]);
				boolean ifsucc= this.setVideoScreen(tinfos[2], tempconfVo.getConfID(), "", tempconfVo.getVideoMode(), tempconfVo.getLayoutMode(), 1, splitInfos,"","","meeting");
				addMcuLog("monitor " + infos,LogEnum.TYPE_CONTROL_OPERATION);
				return ifsucc;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	}
	
	/**
	 * 演讲者选看会场
	 * @param meetingDetailId
	 * @param roomInfo
	 * @param participantId
	 */
	public void checkParticipantLecture(String meetingDetailId,String roomInfo,String participantId){
		ZZOConfVO confVO = new ZZOConfVO();
		ZZOConfVO confVO1 = new ZZOConfVO();
		confVO.setConfFlagId(meetingDetailId);
		String[] roomInfos = roomInfo.split("__");
		List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
		if (confList != null && confList.size() > 0) {
			for (ZZOConfVO zVO : confList) {
				if ((zVO.getGuid()+zVO.getMcuIP()).equals(roomInfos[1]+roomInfos[2])) {
					confVO1 = zVO;
				}
			}
			if (confVO1 != null) {
				if ((confVO1.getMcuType()).equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)) {
					ZZOMcuFactory.getInstance().getMcuControlHelper().set1000Video(confVO1.getConfID(), confVO1.getVideoMode(),confVO1.getLectureName(), false,MCUConfig.LAYOUT_MODE_101, 1, participantId, "");
				}else{
					ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailId, confVO1.getConfID(),"", "", MCUConfig.LAYOUT_MODE_1X1,1, participantId, "");
				}
			}
		}
		
		
	}
	
	//设置分屏信息
	public boolean setVideoScreen(String meetingDetailId, String confID,String lecturerRoomId, String videoMode, String layoutMode,int count, String[] splitInfos, String monitor, String mode,String type) {
		if (type.equals("meeting")) {
			ZZOConfVO confVO = new ZZOConfVO();
			ZZOConfVO confVO1 = new ZZOConfVO();
			confVO.setConfFlagId(meetingDetailId);

			List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
			if (confList != null && confList.size() > 0) {
				for (ZZOConfVO zVO : confList) {
					if (confID.equals(zVO.getConfID())) {
						confVO1 = zVO;
					}
				}
				if (confVO1 != null) {

					if ((confVO1.getMcuType()).equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)) {
						String forceIds = "";
						if (layoutMode.equals(MCUConfig.LAYOUT_MODE_801)) {
							String idTemp = "";
							idTemp = splitInfos[5];
							splitInfos[5] = splitInfos[6];
							splitInfos[6] = idTemp;
							String idTemp1 = "";
							idTemp1 = splitInfos[4];
							splitInfos[4] = splitInfos[7];
							splitInfos[7] = idTemp1;
							
						}
						if (layoutMode.equals(MCUConfig.LAYOUT_MODE_902)|| layoutMode.equals(MCUConfig.LAYOUT_MODE_903)|| layoutMode.equals(MCUConfig.LAYOUT_MODE_904)) {
							String idTemp = "";
							idTemp = splitInfos[6];
							splitInfos[6] = splitInfos[7];
							splitInfos[7] = idTemp;
							String idTemp1 = "";
							idTemp1 = splitInfos[8];
							splitInfos[8] = splitInfos[5];
							splitInfos[5] = idTemp1;
						}
						for (int i = 0; i < splitInfos.length; i++) {

							if (forceIds.equals("")) {
								forceIds += splitInfos[i];
							} else {
								forceIds += ("-" + splitInfos[i]);
							}
						}
						List<ZZOMainStatusVO> confTerminalList = new ArrayList<ZZOMainStatusVO>();
						confTerminalList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailId, confVO1.getMcuIP(),confVO1.getGuid());
						for (ZZOMainStatusVO zVO : confTerminalList) {
							if (zVO.getIsLecturer() == 1) {
								confVO1.setLectureName(zVO.getMcu_participant_name());
							}
						}
						ZZOMcuFactory.getInstance().getMcuControlHelper().set1000Video(confID, videoMode,confVO1.getLectureName(), false,layoutMode, count, forceIds, "");

					} else {
						String forceIds = "";
						for (int i = 0; i < splitInfos.length; i++) {

							if (i == splitInfos.length - 1) {
								forceIds = forceIds + splitInfos[i];
							} else {
								forceIds = forceIds + splitInfos[i] + "_";
							}
						}
						ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailId, confID,lecturerRoomId, videoMode, layoutMode,count, forceIds, "");
					}
				}
			}
		} else {
			
			
			String[] monitorInfo = monitor.split("__");
			ZZOMediaSourcesVO zzoMediaSourcesVO= new ZZOMediaSourcesVO();
			List<ZZOMediaSourcesVO> mediaList=new ArrayList<ZZOMediaSourcesVO>();	
			zzoMediaSourcesVO.setLayout(layoutMode);
			zzoMediaSourcesVO.setLayoutType(mode);
			zzoMediaSourcesVO.setMcuIP(monitorInfo[2]);
			zzoMediaSourcesVO.setMcuMeetingID(monitorInfo[1]);
			zzoMediaSourcesVO.setMcuParticipantId(monitorInfo[3]);
			zzoMediaSourcesVO.setForceIdArray(splitInfos);
			mediaList.add(zzoMediaSourcesVO);
			ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList);
		}
		this.addMcuLog("setVideoScreen:" + count,LogEnum.TYPE_CONTROL_OPERATION);
		return true;
	}
	
	public String deleteParticipant(String meetingDetailID, String ptsIpVmcuIps){
		this.addMcuLog("deleteParticipant:"+ptsIpVmcuIps,LogEnum.TYPE_CONTROL_OPERATION);
		delMeetingDetailRoomVO(meetingDetailID, ptsIpVmcuIps);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().deleteParticipant(meetingDetailID, ptsIpVmcuIps);
		
	}
	
	public String setLecturer(String meetingDetailID, String roomID){
		this.addMcuLog("setLecturer:"+roomID,LogEnum.TYPE_CONTROL_OPERATION);
//		return Factories.getMcuControlHelper().setLecturer(meetingDetailID, roomID);
		ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().setLecturer(meetingDetailID, roomID, null);
	}
	
	/**
	 * set a speaker
	 * @param meetingDetailID
	 * @param roomID
	 * @return
	 * @author wangle
	 * @since Feb 2, 2010
	 */
	public String setSpeaker(String meetingDetailID, String roomID,boolean ifNeedMute){
		this.addMcuLog("setSpeaker:"+roomID,LogEnum.TYPE_CONTROL_OPERATION);
		terminalPollThread1(meetingDetailID);
		ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
		if( !"".endsWith(MeetingAppConfig.CALLSITEBEFORE)&&ifNeedMute){
			ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(meetingDetailID, MeetingAppConfig.CALLSITEBEFORE, true);
			
		}
		if(ifNeedMute){
			MeetingAppConfig.CALLSITEBEFORE = roomID;
		}
		return ZZOMcuFactory.getInstance().getMcuControlHelper().setSpeaker(meetingDetailID, roomID, null);
	}
	
	/**
	 * set a speaker
	 * @param meetingDetailID
	 * @param roomID
	 * @return
	 * @author wangle
	 * @since Feb 2, 2010
	 */
	public String setSpeakerOnLinkConf(String meetingDetailID, String roomID , String linkInfoIps,boolean ifNeedMute ){
		terminalPollThread1(meetingDetailID);
		ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
		if( !"".endsWith(MeetingAppConfig.CALLSITEBEFORE)&&ifNeedMute){
			ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(meetingDetailID, MeetingAppConfig.CALLSITEBEFORE, true);
		
		}
		//级联会还需设置其对应于主MCU上的级联点为发言人
		ZZOMcuFactory.getInstance().getMcuControlHelper().setSpeaker(meetingDetailID, linkInfoIps, null);
		if(ifNeedMute){
		MeetingAppConfig.CALLSITEBEFORE = roomID;
		}
		return ZZOMcuFactory.getInstance().getMcuControlHelper().setSpeaker(meetingDetailID, roomID, null);
	}
	
	
	public void pollParticipants(String meetingDetailID, String meetingRoomIDs, int interval){
		this.addMcuLog("pollParticipants:"+meetingDetailID,LogEnum.TYPE_CONTROL_OPERATION);
		ZZOMcuFactory.getInstance().getMcuControlHelper().pollParticipants(meetingDetailID, meetingRoomIDs, interval);
	}
	
	public boolean stopPolling(String meetingDetailID){
		this.addMcuLog("stopPolling:"+meetingDetailID,LogEnum.TYPE_CONTROL_OPERATION);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
	}
	
	public void deleteConf(String meetingDetailID){
	
		if(!DwrMethod.kstMeetingNum.equals("-1")){
			DwrMethod.stopMonitoring(DwrMethod.kstMeetingNum,meetingDetailID);
		}
		ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
		MeetingDetailVO meetingDetailVO = null;
		
		try {
			TransactionManager tManager = null;
			tManager = new TransactionManager();
			tManager.beginTransaction();
			MeetingDetailService meetingDetailService=new MeetingDetailServiceImpl();
			meetingDetailVO = new MeetingDetailVO();
		
			meetingDetailVO = meetingDetailService.queryByID(meetingDetailID);
			if(meetingDetailVO!= null){
				this.addMcuLog("提前结束会议："+meetingDetailVO.getMeetingName(),LogEnum.TYPE_DB);
				Calendar currentTime = Calendar.getInstance();
				meetingDetailVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
				meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_END+"");
				meetingDetailService.modifyGeneralMeetingDetail(meetingDetailVO);
				McuDwrMethod.getTerComment().remove(meetingDetailVO.getMeetingDetailID());//清除该会议相关终端备注
				//MeetingAppConfig.pollMap.remove(meetingDetailVO.getMeetingDetailID());//清楚该会议轮询线程
				terminalPollThread1(meetingDetailVO.getMeetingDetailID());
//				MeetingVO meetingVO = new MeetingVO();
//				meetingVO.setMeetingID(meetingDetailVO.getMeetingID());
//				MeetingService meetingService = new MeetingServiceImpl();
//				meetingService.modifyMeeting(meetingVO, tManager);
//				meetingService.unDelMeeting(meetingVO, meetingDetailVO,tManager);
			}
			tManager.commit();
			//delete conference in mcu
			MeetingAppConfig.CALLSITEBEFORE = "";//还原默认设置
			
			info = null;
			ZZOMcuFactory.getInstance().getMcuControlHelper().deleteConf(meetingDetailID);
//			AUTO TIMER CONTROL
//			new MeetingAction().creatMeetingForSelf(meetingDetailVO,"del");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setEndTime(String meetingDetailID, String delayTime) throws SQLException{
		this.addMcuLog("setEndTime:"+meetingDetailID + ":" + delayTime,LogEnum.TYPE_CONTROL_OPERATION);
		  if(delayTime.equals("10")){
				MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
				meetingDetailVO.setMeetingDetailID(meetingDetailID);
				MeetingDetailService meetingDetailService=new MeetingDetailServiceImpl();
				ArrayList<MeetingDetailVO> meetingDetailVOList =  new ArrayList<MeetingDetailVO>();
				meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
				if(meetingDetailVOList!= null && meetingDetailVOList.size()>0){
					meetingDetailVO = meetingDetailVOList.get(0);
					if(meetingDetailVO.getMeetingEndTime() != null && meetingDetailVO.getMeetingStartTime() != null){
						long endTime = meetingDetailVO.getMeetingEndTime().getTime();
						long startTime = meetingDetailVO.getMeetingStartTime().getTime();
						int hour = (int)((endTime - startTime)/(1000 * 60 * 60));
						int other = (int)((endTime - startTime)%(1000 * 60 * 60));
						if(other > 0){
							hour = hour + 1;
						}
						if(hour < MCUConfig.MAX_CONF_HOUR_LENGTH){
							delayTime = String.valueOf(MCUConfig.MAX_CONF_HOUR_LENGTH - hour);
							ZZOMcuFactory.getInstance().getMcuControlHelper().setEndTime(meetingDetailID, delayTime);
						}
						
						return;
					}
				}
			}else{
				ZZOMcuFactory.getInstance().getMcuControlHelper().setEndTime(meetingDetailID, delayTime);
			}
		
//		  if(delayTime.equals("10")){
//				MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
//				meetingDetailVO.setMeetingDetailID(meetingDetailID);
//				MeetingDetailService meetingDetailService=new MeetingDetailServiceImpl();
//				ArrayList<MeetingDetailVO> meetingDetailVOList =  new ArrayList<MeetingDetailVO>();
//				meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
//				if(meetingDetailVOList!= null && meetingDetailVOList.size()>0){
//					meetingDetailVO = meetingDetailVOList.get(0);
//				}
//				
//				Calendar nextDay = Calendar.getInstance();
//				nextDay.set(Calendar.HOUR_OF_DAY, 0);
//				nextDay.set(Calendar.MINUTE, 0);
//				nextDay.set(Calendar.SECOND, 0);
//				nextDay.set(Calendar.MILLISECOND, 0);
//				nextDay.add(Calendar.DAY_OF_MONTH, 1);
//				
//				long i = nextDay.getTimeInMillis() - meetingDetailVO.getMeetingEndTime().getTime();
//				int hour = (int)(i/(1000 * 60 * 60));
//				delayTime = String.valueOf(hour);
//				}

//		  ZZOMcuFactory.getMcuControlHelper().setEndTime(meetingDetailID, delayTime);
	}
	public List<ZZOMainStatusVO> getMeetingMcuList(String meetingDetailID){
		if(ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().size() <= 0){
			return null;
		}
		
		List<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
		// List<ConfRoomVO> confRoomVector = ConfAllPts.getCopyConfRoomList(meetingDetailID);
		return confRoomVector;
	}
	
	
	public List<ZZOMainStatusVO> getNewMeetingMcuList(String meetingDetailID,  String[][] mainStatus2Array){
		
		if(mainStatus2Array == null || mainStatus2Array.length == 0 || ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().size() <= 0){
			return null;
		}
		List<ZZOMainStatusVO> mainStatusVOList = new ArrayList<ZZOMainStatusVO>();
		List<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
		try {
		boolean isUpdated = false, isNew = true;
		boolean isDropped = false;
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		if(confRoomVector != null && confRoomVector.size() > 0){
			for(int k=0; k<confRoomVector.size(); k++){
				ZZOMainStatusVO mainStatusVO = confRoomVector.get(k);
				isNew = true;
				for(int i=0; i<mainStatus2Array.length; i++){
					if(mainStatusVO.getMcu_participant_name().equals(mainStatus2Array[i][0]) && mainStatusVO.getMcuMeetingID().equals(mainStatus2Array[i][1])
							&& mainStatusVO.getMcuIp().equals(mainStatus2Array[i][2])){
						isNew = false;
						isUpdated = isUpdated(mainStatusVO, mainStatus2Array[i]);
						isDropped = isDropped(mainStatusVO, mainStatus2Array[i]);
						if(isUpdated){
							mainStatusVOList.add(mainStatusVO);
						}
						if(isDropped){												//添加终端断开信息
							InformationVO informationVO = new InformationVO();
							informationVO.setContent(mainStatusVO.getMcu_participant_name()+"已断开");
							informationVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
							informationVO.setInfoType(InformationEnum.TYPE_EQUIPMENT);
							informationVO.setStatus(InformationEnum.STATUS_VALID);
							informationVO.setTitle("终端断开提醒");
							ServiceFactory.getInformationService().add(informationVO);
							
						}
						break;
					}
				}
				if(isNew){
					mainStatusVOList.add(mainStatusVO);
				}
				buffer.append(mainStatusVO.getMeetingMCUKeyID());
				if(k != confRoomVector.size() - 1){
					buffer.append("__");
				}
				if(mainStatusVO.getConnectStatus() != null && mainStatusVO.getConnectStatus().intValue() == 1){
					count++;
				}
			}
			ZZOMainStatusVO mainStatusVO = new ZZOMainStatusVO();
			mainStatusVO.setDescription(buffer.toString());
			mainStatusVO.setPtsNumber(String.valueOf(count)+"/"+confRoomVector.size());
			mainStatusVOList.add(mainStatusVO);
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainStatusVOList;
	}
public List<ZZOMainStatusVO> getNewMeetingMcuList(String user, String meetingDetailID,  String[][] mainStatus2Array){
		if(ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().size() <= 0){
			return null;
		}
		//initialize user cache.
		boolean isExisted = true;
		if(mainStatus2Array != null && mainStatus2Array.length > 0){
			isExisted = false;
			userMainStatusMap.put(user, mainStatus2Array);
		}else{
			mainStatus2Array = userMainStatusMap.get(user);
			if(mainStatus2Array == null){
				return null;
			}
		}
		List<ZZOMainStatusVO> mainStatusVOList = new ArrayList<ZZOMainStatusVO>();
		List<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
		try {
		boolean isUpdated = false, isNew = true;
		boolean isDropped = false;
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		if(confRoomVector != null && confRoomVector.size() > 0){
			for(int k=0; k<confRoomVector.size(); k++){
				ZZOMainStatusVO mainStatusVO = confRoomVector.get(k);
				isNew = true;
				for(int i=0; i<mainStatus2Array.length; i++){
					if(mainStatusVO.getMcu_participant_name().equals(mainStatus2Array[i][0]) && mainStatusVO.getMcuMeetingID().equals(mainStatus2Array[i][1])
							&& mainStatusVO.getMcuIp().equals(mainStatus2Array[i][2])){
						isNew = false;
						isUpdated = isUpdated(mainStatusVO, mainStatus2Array[i]);
						isDropped = isDropped(mainStatusVO, mainStatus2Array[i]);
						if(isUpdated){
							mainStatusVOList.add(mainStatusVO);
							mainStatus2Array[i] = updateMainStatusArray(mainStatusVO, mainStatus2Array[i]);
						}
						if(isDropped){												//添加终端断开信息
							InformationVO informationVO = new InformationVO();
							informationVO.setMeetingDetailId(meetingDetailID);
							MeetingDetailVO mVO = new MeetingDetailVO(); 
							ArrayList<MeetingDetailVO> list = ServiceFactory.getMeetingDetailService().query(mVO, null);
							if(list!=null&list.size()>0){
								MeetingDetailVO mdVO = list.get(0);
								informationVO.setSourceName(mdVO.getCreateUserID());
							}
							informationVO.setContent(mainStatusVO.getMcu_participant_name()+"已断开");
							informationVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
							informationVO.setInfoType(InformationEnum.TYPE_EQUIPMENT);
							informationVO.setStatus(InformationEnum.STATUS_VALID);
							informationVO.setTitle("终端断开提醒");
//							informationVO.setSourceName(user);
							ServiceFactory.getInformationService().add(informationVO);
							
						}
						break;
					}
				}
				if(isNew){
					mainStatusVOList.add(mainStatusVO);
				}
				buffer.append(mainStatusVO.getMeetingMCUKeyID());
				if(k != confRoomVector.size() - 1){
					buffer.append("__");
				}
				if(mainStatusVO.getConnectStatus() != null && mainStatusVO.getConnectStatus().intValue() == 1){
					count++;//终端在线数
				}
				/*
				if( !MeetingAppConfig.ifCallInOrNot && mainStatusVO.getCascadeRole().equals("none") && mainStatusVO.getCasDialDirection().equals("dial_in")){    //对于主动呼入MCU的终端是否删除掉(ifCallInOrNot由系统配置决定)
					StringBuffer mvcps = new StringBuffer("");
					mvcps.append(mainStatusVO.getMcu_participant_name()+"__"+mainStatusVO.getMcuMeetingID()+"__"+mainStatusVO.getMcuIp());
					this.deleteParticipant(meetingDetailID, mvcps.toString());
				}
				*/
			}
			ZZOMainStatusVO mainStatusVO = new ZZOMainStatusVO();
			mainStatusVO.setDescription(buffer.toString());
			mainStatusVO.setPtsNumber(String.valueOf(count)+"/"+confRoomVector.size());
			mainStatusVOList.add(mainStatusVO);
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainStatusVOList;
	}


public List<ZZOMainStatusVO> getNewMeetingMcuList(String meetingDetailID){
	if(ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().size() <= 0){
		return null;
	}
	
	
	List<ZZOMainStatusVO> mainStatusVOList = new ArrayList<ZZOMainStatusVO>();
	List<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
	try {
	StringBuffer buffer = new StringBuffer();
	if(confRoomVector != null && confRoomVector.size() > 0){
		for(int k=0; k<confRoomVector.size(); k++){
			ZZOMainStatusVO mainStatusVO = confRoomVector.get(k);
			mainStatusVOList.add(mainStatusVO);
		
			buffer.append(mainStatusVO.getMeetingMCUKeyID());
			if(k != confRoomVector.size() - 1){
				buffer.append("__");
			}
			if(mainStatusVO.getConnectStatus() != null && mainStatusVO.getConnectStatus().intValue() == 1){
				count++;
			}
		}
		ZZOMainStatusVO mainStatusVO = new ZZOMainStatusVO();
		mainStatusVO.setDescription(buffer.toString());
		mainStatusVO.setPtsNumber(String.valueOf(count)+"/"+confRoomVector.size());
		mainStatusVOList.add(mainStatusVO);
	}
	
	
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return mainStatusVOList;
}


private String[]  updateMainStatusArray(ZZOMainStatusVO mainStatusVO, String[] mainStatus2Array){

	mainStatus2Array[3] = String.valueOf(mainStatusVO.getConnectStatus());
		
	
	mainStatus2Array[4] = String.valueOf(mainStatusVO.getAudio());
		
	
	mainStatus2Array[5] = String.valueOf(mainStatusVO.getVideo());
		
	
	mainStatus2Array[6] = String.valueOf(mainStatusVO.getContentToken());
		
	
	mainStatus2Array[7] = String.valueOf(mainStatusVO.getCasDialDirection());
		
	
	mainStatus2Array[8] = String.valueOf(mainStatusVO.getIsLecturer());
		
	
	mainStatus2Array[9] = String.valueOf(mainStatusVO.getIsSpeaker());
		
	
	mainStatus2Array[10] = String.valueOf(mainStatusVO.getReceivePacketLoss());
		
	
	mainStatus2Array[11] = String.valueOf(mainStatusVO.getSendPacketLoss());
		
	
	return mainStatus2Array;
	
}
	
	private boolean isUpdated(ZZOMainStatusVO mainStatusVO, String[] mainStatus2Array){
		if(!mainStatus2Array[3].equals(String.valueOf(mainStatusVO.getConnectStatus()))){
			return true;
		}
		if(!mainStatus2Array[4].equals(String.valueOf(mainStatusVO.getAudio()))){
			return true;
		}
		if(!mainStatus2Array[5].equals(String.valueOf(mainStatusVO.getVideo()))){
			return true;
		}
		if(!mainStatus2Array[6].equals(String.valueOf(mainStatusVO.getContentToken()))){
			return true;
		}
		if(!mainStatus2Array[7].equals(String.valueOf(mainStatusVO.getCasDialDirection()))){
			return true;
		}
		if(!mainStatus2Array[8].equals(String.valueOf(mainStatusVO.getIsLecturer()))){
			return true;
		}
		if(!mainStatus2Array[9].equals(String.valueOf(mainStatusVO.getIsSpeaker()))){
			return true;
		}
		if(!mainStatus2Array[10].equals(String.valueOf(mainStatusVO.getReceivePacketLoss()))){
			return true;
		}
		if(!mainStatus2Array[11].equals(String.valueOf(mainStatusVO.getSendPacketLoss()))){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断终端是否断开
	 * @param mainStatusVO
	 * @param mainStatus2Array
	 * @return
	 */
	private boolean isDropped(ZZOMainStatusVO mainStatusVO, String[] mainStatus2Array){
		if(mainStatus2Array[3].equals("1")&&mainStatusVO.getConnectStatus()!=1){
			return true;
		}
		return false;
		
	}

	public boolean addMode(String mcuIDs, String mainMcuID,String modeIDs,String cascadeName,String createUserID,String confModel) throws Exception{
System.out.println("================addmode=========================");
		boolean status = false;
		try {
			String mcuEquipmentIDs[] = mcuIDs.split("_");
			String mcumodeIDs[] = modeIDs.split("_");
			String mcuName ="";
			String mcuIp = "";
			String modeID = "";
			String modeName = "";
			for(int i=0;i<mcuEquipmentIDs.length;i++){
				EquipmentVO equipmentVO = new EquipmentVO();
				equipmentVO.setEquipmentID(mcuEquipmentIDs[i]);
				ArrayList<EquipmentVO> equipmentVOList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
				if(equipmentVOList != null && equipmentVOList.size()>0){
					equipmentVO = equipmentVOList.get(0);
					if(mcuName =="" ){
						mcuName = equipmentVO.getEquipmentNO();
					}else{
						mcuName += "_"+equipmentVO.getEquipmentNO();
					}
					if(mcuIp =="" ){
						mcuIp = equipmentVO.getIp();
					}else{
						mcuIp += "_"+equipmentVO.getIp();
					}
					BaseInfoVO baseInfoVO = new BaseInfoVO();
					baseInfoVO.setInfoName(equipmentVO.getIp());
					baseInfoVO.setInfoValue(mcumodeIDs[i]);
					ArrayList<BaseInfoVO> baseInfoVOList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
					if(baseInfoVOList != null && baseInfoVOList.size()>0){
						baseInfoVO = baseInfoVOList.get(0);
						if(modeID ==""){
							modeID = baseInfoVO.getInfoValue();
						}else{
							modeID += "_"+baseInfoVO.getInfoValue();
						}
						if(modeName ==""){
							modeName = baseInfoVO.getDescription();
						}else{
							modeName += "_"+baseInfoVO.getDescription();
						}
					}
				}
			}
			
			Timestamp date = new Timestamp(System.currentTimeMillis());
			
			McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
			mcuCascadeModelVO.setCascadeName(cascadeName);
			mcuCascadeModelVO.setMcuName(mcuName);
			mcuCascadeModelVO.setMcuIp(mcuIp);
			mcuCascadeModelVO.setModelID(modeID);
			mcuCascadeModelVO.setModelName(modeName);
			mcuCascadeModelVO.setDescription(mainMcuID);
			mcuCascadeModelVO.setStatus(McuCascademodelEnum.VALID);
			mcuCascadeModelVO.setCreateDate(date);
			mcuCascadeModelVO.setCreateUserID(createUserID);
			mcuCascadeModelVO.setConfModel(confModel);
			ServiceFactory.getMcuCascadeModelService().add(mcuCascadeModelVO);
			status = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===============end=======================/n/n/n\n\n\n");
		return status;
	}
	
	
	/**
	  * 录播开始录制
	  * @param meetingDetailID
	  * @param confID
	  */
	 public String recording(String meetingDetailID,String confID,String op){
		this.addMcuLog("recording:"+meetingDetailID + ":" + op,LogEnum.TYPE_CONTROL_OPERATION);
		if(op.equals("start")){
			ZZOMcuFactory.getInstance().getMcuControlHelper().startRecording(meetingDetailID, confID);
		}else if(op.equals("pause")){
			 ZZOMcuFactory.getInstance().getMcuControlHelper().pauseRecording(meetingDetailID, confID);
		}else if(op.equals("resume")){
			ZZOMcuFactory.getInstance().getMcuControlHelper().resumeRecording(meetingDetailID, confID);
		}else{
			ZZOMcuFactory.getInstance().getMcuControlHelper().stopRecording(meetingDetailID, confID);
		}
	 	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 	ConfManager confManager = ZZOMcuFactory.getInstance().getConfManager();
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(meetingDetailID);
		confVO.setConfID(confID);
		String recordStatus ="";
		List<ZZOConfVO> confList = confManager.getConfList(confVO);
		if(confList!=null&&confList.size()>0){
			recordStatus = confList.get(0).getRecordingStatus();
			System.out.println(recordStatus);
		}
		return recordStatus;
	 }

	 /**
	  * 录播停止录制
	  * @param meetingDetailID
	  * @param confID
	  */
	 public void stopRecording(String meetingDetailID,String confID){
	 	ZZOMcuFactory.getInstance().getMcuControlHelper().stopRecording(meetingDetailID, confID);
	 	this.addMcuLog("stopRecording:"+meetingDetailID,LogEnum.TYPE_CONTROL_OPERATION);
	 }
	 
	 /**
	  * 根据会议ID获取MCU集合(ip_name)
	  * @param confFlagId
	  * @return
	  */
	 public String[]  getMeetingMcuIPs(String confFlagId ){
			
		ConfManager confManager = ZZOMcuFactory.getInstance().getConfManager();
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(confFlagId);
		
		List<ZZOConfVO> confList = confManager.getConfList(confVO);
		String[] mcuIps_Name = new String[0];
		if( confList !=null && confList.size()> 0 ){
			mcuIps_Name = new String[confList.size()];
			int j = 0;
			for( int i=0; i<confList.size(); i++ ){
				mcuIps_Name[j++] = confList.get(i).getMcuIP()+"_"+confList.get(i).getMcuName();
			}
		}
		return mcuIps_Name;
	}
	 
	 /**
	  * 根据会议ID获取MCU所有会议集合
	  * @param confFlagId
	  * @return
	  */
	 public String[]  getMeetingConfs(String confFlagId ){
			
		ConfManager confManager = ZZOMcuFactory.getInstance().getConfManager();
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(confFlagId);
		
		List<ZZOConfVO> confList = confManager.getConfList(confVO);
		String[] confID_confName = new String[0];
		if( confList !=null && confList.size()> 0 ){
			confID_confName = new String[confList.size()];
			int j = 0;
			for( int i=0; i<confList.size(); i++ ){
				confID_confName[j++] = confList.get(i).getConfID()+"__"+confList.get(i).getConfName()+"__"+confList.get(i).getMcuIP();
			}
		}
		return confID_confName;
	}
	 
	 
    /**
     * 添加会场到XXMCU
     * @param meetingDetailID
     * @param meetingRoomIDs
     * @param mcuIp
     * @return
     * @author chenshuo
     */
	public boolean addMeetingRoom(String meetingDetailID, String[] meetingRoomIDs, String mcuIp){
		EquipmentService equSer = ServiceFactory.getEquipmentService();
		EquipmentVO mcuVO = new EquipmentVO();
		mcuVO.setIp(mcuIp);
		mcuVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
		ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
		try{
			List<EquipmentVO> mculist = equSer.query(mcuVO, null);
			mcuVO = mculist.get(0);//添加到的MCU对象
				ZZOMainVO innerMcuVO = new ZZOMainVO();
		        innerMcuVO.setEquipmentIP(mcuVO.getIp());
		        innerMcuVO.setModelID(mcuVO.getEquipmentModel());
		            //MCU 4000 and MCU 2000 use the same model id
		        if(mcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
		            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
		        }
				
				
				for( int i=0; i<meetingRoomIDs.length; i++ ){
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					meetingRoomVO.setMeetingRoomID(meetingRoomIDs[i]);
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setMeetingRoomVO(meetingRoomVO);
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					List<EquipmentVO> listEqu = equSer.query(equipmentVO, null);
					if( listEqu != null && listEqu.size()>0){
						equipmentVO = listEqu.get(0);//当前要添加的终端对象
						ZZOMainVO innerTerminalVO = new ZZOMainVO();
		            	innerTerminalVO.setEquipmentName(equipmentVO.getMeetingRoomVO().getMeetingRoomName());
		            	innerTerminalVO.setEquipmentIP(equipmentVO.getIp());
		            	innerTermList.add(innerTerminalVO);
					}
					
				}
				innerMcuVO.setSubMainVOList(innerTermList);
	            innerMcuVOList.add(innerMcuVO);
	            ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(meetingDetailID, innerMcuVOList);
	            
	            /**日志*/
	            WebContext webContext = WebContextFactory.get();     
	            LogVO logVO = new LogVO();
	            logVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
	            logVO.setLevel(LogEnum.LEVEL_DeFAULT);
	            logVO.setOperatorContent("用户会议控制中添加会场");
	            UserVO sessionUserVO = (UserVO)webContext.getSession().getAttribute(UserEnum.USER_SESSION_ID);
	            logVO.setUserID(sessionUserVO.getUserID());
	            ServiceFactory.getLogService().add(logVO);
			      
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		}
		return true;
	}
	
	
	
	/**
     * 添加会场到XX会议
     * @param meetingDetailID 会议ID
     * @param meetingRoomIDs 添加的会场ID
     * @param mcuIp 添加到的MCU IP
     * @param confID 添加到的会议ID
     * @param tempIP 手动输入的终端ip
     * @param tempName 手动输入的终端显示名称
     * @return
     * @author chenshuo add on 2013-4-26
     */
	public boolean addMeetingRoomOnConf(String meetingDetailID, String[] meetingRoomIDs, String confID , String mcuIp, String tempIP , String tempName){
		EquipmentService equSer = ServiceFactory.getEquipmentService();
		EquipmentVO mcuVO = new EquipmentVO();
		mcuVO.setIp(mcuIp);
		mcuVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
		ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
		try{
				List<EquipmentVO> mculist = equSer.query(mcuVO, null);
				mcuVO = mculist.get(0);//添加到的MCU对象
				ZZOMainVO innerMcuVO = new ZZOMainVO();
		        innerMcuVO.setEquipmentIP(mcuVO.getIp());
		        innerMcuVO.setModelID(mcuVO.getEquipmentModel());
		            //MCU 4000 and MCU 2000 use the same model id
		        if(mcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
		            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
		        }
				
				
				for( int i=0; i<meetingRoomIDs.length; i++ ){
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					meetingRoomVO.setMeetingRoomID(meetingRoomIDs[i]);
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setMeetingRoomVO(meetingRoomVO);
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					List<EquipmentVO> listEqu = equSer.query(equipmentVO, null);
					if( listEqu != null && listEqu.size()>0){
						equipmentVO = listEqu.get(0);//当前要添加的终端对象
						ZZOMainVO innerTerminalVO = new ZZOMainVO();
		            	innerTerminalVO.setEquipmentName(equipmentVO.getMeetingRoomVO().getMeetingRoomName());
		            	innerTerminalVO.setEquipmentIP(equipmentVO.getIp());
		            	innerTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_OUT);//TODO:呼入方式待定
		            	innerTermList.add(innerTerminalVO);
		                this.addMcuLog("会控添加会场(列表选择):"+innerTerminalVO.getEquipmentName()+","+innerTerminalVO.getEquipmentIP(),LogEnum.TYPE_CONTROL_OPERATION);
					}
					
				}
				
				//加入手动输入ip的终端
				ZZOMainVO innerTerminalVO = new ZZOMainVO();
            	innerTerminalVO.setEquipmentName(tempName);
            	innerTerminalVO.setEquipmentIP(tempIP);
            	innerTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_OUT);//TODO:呼入方式待定
            	innerTermList.add(innerTerminalVO);
            	//////
				innerMcuVO.setSubMainVOList(innerTermList);
	            innerMcuVOList.add(innerMcuVO);
	            ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(meetingDetailID, confID, innerMcuVOList);
	             /**日志*/
	            if(tempName!=null&&!tempName.equals("")){
	            this.addMcuLog("会控添加会场(手动添加):"+tempName+","+tempIP,LogEnum.TYPE_CONTROL_OPERATION);
	            }
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		}
		return true;
	}
	
	/**
	 * 点名
	 * @param meetingDetailId
	 * @param roomInfo
	 * @return
	 */
	public String rollCall(String meetingDetailId,String roomInfo,boolean ifNeedMute){
		stopPoll(meetingDetailId);		//停止正在进行的轮询
		if(info!=null&&ifNeedMute){
			muteParticipants(meetingDetailId, info, true);
		}
		List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailId);
		ZZOMainStatusVO mainMeetingRoom = null;
		for(int i=0;i<meetingRoomList.size();i++){
			if(meetingRoomList.get(i).getIsSpeaker()==1&&meetingRoomList.get(i).getCascadeRole().equals("none")){
				mainMeetingRoom = meetingRoomList.get(i);
				break;
			}
		}
		if(mainMeetingRoom==null){
			return "none";
		}else{
			McuControlDwr mcd = new McuControlDwr();
			String monitor = mainMeetingRoom.getMcu_participant_name()+"__"+mainMeetingRoom.getMcuMeetingID()+"__"+mainMeetingRoom.getMcuIp()+"__"+mainMeetingRoom.getMcu_participant_id();
			String[] roomInfos = new String[1];
			roomInfos[0]=roomInfo;
			if(ifNeedMute){
				mcd.callPollDetail(roomInfos, monitor, "personal");
			}else{
				mcd.setPersonal(roomInfos, monitor, "personal");
			}
		}
		if(ifNeedMute){//是否需要对上个会场静音
		String[] infov = roomInfo.split("_");
		String roomInfo1 = infov[4]+"__"+infov[1]+"__"+infov[3];
		muteParticipants(meetingDetailId,roomInfo1,false);
		info = roomInfo1;
		}
		this.addMcuLog("rollCall:"+roomInfo,LogEnum.TYPE_CONTROL_OPERATION);
		return "success";
	}
	/**
	 * set meetringroom's video to other terminal or software  terminal
	 * @author John.Zhang
	 * @date 2014.08.26
	 * @param meetingDetailId
	 * @param roomInfo
	 * @param ifNeedMute
	 * @return
	 */
	public String rollCallForYJ(String meetingDetailId,String monitorMeetingRoomIP,String roomInfo){

		List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailId);
		ZZOMainStatusVO monitorMeetingRoom = null;
		for(ZZOMainStatusVO tzms:meetingRoomList){
			if(tzms.getMcu_participant_ip().equals(monitorMeetingRoomIP)){
				monitorMeetingRoom = tzms;
				break;
			}
		}
		if(monitorMeetingRoom==null){
			return "false";
		}else{
			McuControlDwr mcd = new McuControlDwr();
			String monitor = monitorMeetingRoom.getMcu_participant_name()+"__"+monitorMeetingRoom.getMcuMeetingID()+"__"+monitorMeetingRoom.getMcuIp()+"__"+monitorMeetingRoom.getMcu_participant_id();
			String[] roomInfos = new String[1];
			roomInfos[0]=roomInfo;
			
			MeetingDetialStatic meetingListStatic=new MeetingDetialStatic();
			meetingListStatic.setMeetingDetialID(meetingDetailId);
			meetingListStatic.setMonitorMeetingRoomIP(monitorMeetingRoomIP);
			meetingListStatic.setNowMonitorMeetRoom(roomInfos);
			MeetingDetialStatic.addMeetingListStaticList(meetingListStatic);
			mcd.setPersonal(roomInfos, monitor, "personal");
		}
		
		return "success";
	}
	/**
	 * set main monitor terminal
	 * @author John.Zhang
	 * @date 2014.08.27
	 * @param meetingDetailId
	 * @param monitorMeetingRoomIP
	 * @return
	 */
	public String setrollCallForYJ(String meetingDetailId,String monitorMeetingRoomIP){
		MeetingDetialStatic meetingListStatic=new MeetingDetialStatic();
		meetingListStatic.setMeetingDetialID(meetingDetailId);
		meetingListStatic.setMonitorMeetingRoomIP(monitorMeetingRoomIP);
		MeetingDetialStatic.addMeetingListStaticList(meetingListStatic);
		return "success";
	}
	/**
	 * 广播
	 */
	public void setVideo(String meetingDetailID, String meetingInfo) {
		stopPoll(meetingDetailID);   //停止正在进行的轮询
		List<ZZOConfVO> confList = null;
		int personType = 1;
		List<ZZOMainStatusVO> personalPtsList = new ArrayList<ZZOMainStatusVO>();
		synchronized(broadcastMap){  //synchronized set broadcaster, this is useful to make broadcast as whole body.
			// 广播时先将所有级联点设置为会议模式
			List<ZZOMainStatusVO> roomlist = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
			if (null != roomlist && roomlist.size() > 0) {
				for (ZZOMainStatusVO zzo : roomlist) {
					if (!zzo.getCascadeRole().equals("none")) {
						String[] forceid = new String[1];
						forceid[0] = "auto";
						ZZOMediaSourcesVO zzoMediaSourcesVO1 = new ZZOMediaSourcesVO();
						List<ZZOMediaSourcesVO> mediaList1 = new ArrayList<ZZOMediaSourcesVO>();
						zzoMediaSourcesVO1.setLayout("1x1");
						zzoMediaSourcesVO1.setLayoutType("conference");
						zzoMediaSourcesVO1.setMcuIP(zzo.getMcuIp());
						zzoMediaSourcesVO1.setMcuMeetingID(zzo.getMcuMeetingID());
						zzoMediaSourcesVO1.setMcuParticipantId(zzo.getMcu_participant_id());
						zzoMediaSourcesVO1.setForceIdArray(forceid);
						mediaList1.add(zzoMediaSourcesVO1);
						ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
					}
					//collect personal mode and connected participants wangle 2013-9-22
					if(zzo.getCascadeRole().equals("none") && zzo.getRevision() != null && zzo.getRevision().intValue() == personType && 
							zzo.getConnectStatus() != null && zzo.getConnectStatus().intValue() == MCUConfig.CONNECTED_STATUS){
						personalPtsList.add(zzo);
					}
				}
			}
			
			
			
			// 广播会场时使其看主会场
			String[] venueInfo = meetingInfo.split("__");
			ZZOConfVO confVO = new ZZOConfVO();
			confVO.setConfFlagId(meetingDetailID);
			confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO); // 取得会议列表
			for (ZZOConfVO zconfVO : confList) {
				if ((zconfVO.getMcuIP() + zconfVO.getGuid()).equals(venueInfo[2]+ venueInfo[1])) {
					confVO = zconfVO; // 取得广播者所在会议
				}
			}
			if (confVO != null && confVO.getE164() != null) {
				VideoconferenceVO vc = new VideoconferenceVO();
				vc.setMeetingDetailID(meetingDetailID);
				EquipmentVO eqVO = MeetingUtil.getMainVenue(vc); // 取得主会场
				ZZOMainStatusVO masterVenue = null; // 主会场
				ZZOMainStatusVO broadcastVenue = null; // 广播者
				if (eqVO != null) {
					ZZOConfVO masterConf = MeetingUtil.getMasterConf(meetingDetailID); // 取得主会
					if (masterConf != null) {
						List<ZZOMainStatusVO> venueList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailID, masterConf.getMcuIP(),masterConf.getGuid());
						for (ZZOMainStatusVO venue : venueList) {
							if (venue.getMcu_participant_ip().equals(eqVO.getIp())) {
								masterVenue = venue; // 根据ip取得主会场
							}
							if (venue.getMcu_participant_name().equals(venueInfo[0])) {
								broadcastVenue = venue; // 根据名称取得广播者
							}
						}
						if (broadcastVenue != null&&masterVenue!=null) { // 如果广播者在主会，直接使其看主会场
							String[] forceid = new String[1];
							forceid[0] = masterVenue.getMcu_participant_id();
							ZZOMediaSourcesVO zzoMediaSourcesVO1 = new ZZOMediaSourcesVO();
							List<ZZOMediaSourcesVO> mediaList1 = new ArrayList<ZZOMediaSourcesVO>();
							zzoMediaSourcesVO1.setLayout("1x1");
							zzoMediaSourcesVO1.setLayoutType("personal");
							zzoMediaSourcesVO1.setMcuIP(broadcastVenue.getMcuIp());
							zzoMediaSourcesVO1.setMcuMeetingID(broadcastVenue.getMcuMeetingID());
							zzoMediaSourcesVO1.setMcuParticipantId(broadcastVenue.getMcu_participant_id());
							zzoMediaSourcesVO1.setForceIdArray(forceid);
							mediaList1.add(zzoMediaSourcesVO1);
	
							ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
						} else if(masterVenue!=null){ // 广播者在从会
							List<ZZOMainStatusVO> venueList1 = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailID,confVO.getMcuIP(), confVO.getGuid());
							for (ZZOMainStatusVO venue : venueList1) {
								if (venue.getMcu_participant_name().equals(venueInfo[0])) {
									broadcastVenue = venue; // 找出从会中的广播者
								}
							}
							
							if (masterVenue != null&&broadcastVenue!=null) {
								if (null != venueList && venueList.size() > 0) {
									for (ZZOMainStatusVO venue : venueList) {
										if ((confVO.getE164() + confVO.getMcuCommandIP()).equals(venue.getAliasName()+ venue.getMcu_participant_ip())) {
											//找出主会中的级联点，使其看主会场
											String[] forceid = new String[1];
											forceid[0] = masterVenue.getMcu_participant_id();
											ZZOMediaSourcesVO zzoMediaSourcesVO1 = new ZZOMediaSourcesVO();
											List<ZZOMediaSourcesVO> mediaList1 = new ArrayList<ZZOMediaSourcesVO>();
											zzoMediaSourcesVO1.setLayout("1x1");
											zzoMediaSourcesVO1.setLayoutType("personal");
											zzoMediaSourcesVO1.setMcuIP(venue.getMcuIp());
											zzoMediaSourcesVO1.setMcuMeetingID(venue.getMcuMeetingID());
											zzoMediaSourcesVO1.setMcuParticipantId(venue.getMcu_participant_id());
											zzoMediaSourcesVO1.setForceIdArray(forceid);
											mediaList1.add(zzoMediaSourcesVO1);
	
											ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
										}
									}
								}
								for (ZZOMainStatusVO venue : venueList1) {
									if((masterConf.getE164()+masterConf.getMcuCommandIP()).equals(venue.getAliasName()+venue.getMcu_participant_ip())){
										//找出从会中的级联点，广播者看级联点
										String[] forceid = new String[1];
										forceid[0] = venue.getMcu_participant_id();
										ZZOMediaSourcesVO zzoMediaSourcesVO1 = new ZZOMediaSourcesVO();
										List<ZZOMediaSourcesVO> mediaList1 = new ArrayList<ZZOMediaSourcesVO>();
										zzoMediaSourcesVO1.setLayout("1x1");
										zzoMediaSourcesVO1.setLayoutType("personal");
										zzoMediaSourcesVO1.setMcuIP(broadcastVenue.getMcuIp());
										zzoMediaSourcesVO1.setMcuMeetingID(broadcastVenue.getMcuMeetingID());
										zzoMediaSourcesVO1.setMcuParticipantId(broadcastVenue.getMcu_participant_id());
										zzoMediaSourcesVO1.setForceIdArray(forceid);
										mediaList1.add(zzoMediaSourcesVO1);
	
										ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
									}
								}
							}
						}
					}
				}
			}
			
			//find a broadcaster when the first time. wangle 2013-7-20
			if(!broadcastMap.containsKey(meetingDetailID)){
				ZZOConfVO masterConf = MeetingUtil.getMasterConf(meetingDetailID); // 取得主会
				if (masterConf != null) {
					List<ZZOMainStatusVO> venueList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailID, masterConf.getMcuIP(),masterConf.getGuid());
					if(venueList != null && venueList.size() > 0){
						for(ZZOMainStatusVO meetingMcuVO : venueList){
							if(meetingMcuVO.getNodeType() != null && meetingMcuVO.getNodeType().intValue() == MCUConfig.PTS_NODE_TYPE){
								if(meetingMcuVO.getIsSpeaker() != null && meetingMcuVO.getIsSpeaker().intValue() == MCUConfig.IS_SPEAKER){
									String ptsMessage = meetingMcuVO.getMcu_participant_name() + MCUConfig.OP_DELIMITER+ MCUConfig.OP_DELIMITER
										+ meetingMcuVO.getMcuMeetingID() +  MCUConfig.OP_DELIMITER+ MCUConfig.OP_DELIMITER + meetingMcuVO.getMcuIp();
									if(ptsMessage.equals(meetingInfo)){
										//don't set conference mode. but need to set broadcater command.
										break;
									}else{
										broadcastMap.put(meetingDetailID, ptsMessage);
										break;
									}
								}
							}
						}
					}
				}
			}
			
			ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailID, meetingInfo);
	
			//synchronize other conference casecade relation. wangle 2013-7-23
			MeetingUtil.synCascadeRelation(meetingInfo, confList);
			//check if other personal participant exists. wangle 2013-9-22
			if(personalPtsList != null && personalPtsList.size() > 0){
				String temp;
				for(ZZOMainStatusVO tempMainStatusVO : personalPtsList){
					temp = tempMainStatusVO.getMcu_participant_name() + "__" + tempMainStatusVO.getMcuMeetingID() + "__" + tempMainStatusVO.getMcuIp();
					if(broadcastMap.containsKey(meetingDetailID) && temp.equals(broadcastMap.get(meetingDetailID))){
						continue;
					}
					if(temp.equals(meetingInfo)){
						continue;
					}
					//change persion into conference mode.
					if(tempMainStatusVO.getRevision() == null || tempMainStatusVO.getRevision().intValue() != personType){
						continue;
					}
					ZZOMediaSourcesVO zzoMediaSourcesVO1 = new ZZOMediaSourcesVO();
					List<ZZOMediaSourcesVO> mediaList1 = new ArrayList<ZZOMediaSourcesVO>();
					zzoMediaSourcesVO1.setLayout("1x1");
					zzoMediaSourcesVO1.setLayoutType("conference");
					zzoMediaSourcesVO1.setMcuIP(tempMainStatusVO.getMcuIp());
					zzoMediaSourcesVO1.setMcuMeetingID(tempMainStatusVO.getMcuMeetingID());
					zzoMediaSourcesVO1.setMcuParticipantId(tempMainStatusVO.getMcu_participant_id());
					zzoMediaSourcesVO1.setForceIdArray(new String[] { MCUConfig.FORCE_STATE_AUTO });
					mediaList1.add(zzoMediaSourcesVO1);
		
					ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);	
				}
			}
			
			if (broadcastMap.containsKey(meetingDetailID)) {	//将上个广播的会场切换为会议模式
				if((broadcastMap.get(meetingDetailID)).equals(meetingInfo)){
					return;
				}
				//wangle 2013-7-30 mute previous broadcaster.
				//muteParticipants(meetingDetailID, broadcastMap.get(meetingDetailID), true);
				String[] ptsConfMcuArray = OperateUtil.splitter(broadcastMap.get(meetingDetailID), MCUConfig.OP_DELIMITER+ MCUConfig.OP_DELIMITER);
				if (ptsConfMcuArray == null || ptsConfMcuArray.length != 3) {
					return;
				}
				ZZOMainStatusVO meetingMcuVO = new ZZOMainStatusVO();
				meetingMcuVO.setConfFlagId(meetingDetailID);
				meetingMcuVO.setMcu_participant_name(ptsConfMcuArray[0]);
				meetingMcuVO.setMcuMeetingID(ptsConfMcuArray[1]);
				meetingMcuVO.setMcuIp(ptsConfMcuArray[2]);
				List<ZZOMainStatusVO> meetingMcuVOList = ConfAllPts.getMeetingMcuList(meetingMcuVO);
				if (meetingMcuVOList == null || meetingMcuVOList.size() <= 0) {
					return;
				}
				meetingMcuVO = meetingMcuVOList.get(0);
	
				ZZOMediaSourcesVO zzoMediaSourcesVO1 = new ZZOMediaSourcesVO();
				List<ZZOMediaSourcesVO> mediaList1 = new ArrayList<ZZOMediaSourcesVO>();
				zzoMediaSourcesVO1.setLayout("1x1");
				zzoMediaSourcesVO1.setLayoutType("conference");
				zzoMediaSourcesVO1.setMcuIP(meetingMcuVO.getMcuIp());
				zzoMediaSourcesVO1.setMcuMeetingID(meetingMcuVO.getMcuMeetingID());
				zzoMediaSourcesVO1.setMcuParticipantId(meetingMcuVO.getMcu_participant_id());
				zzoMediaSourcesVO1.setForceIdArray(new String[] { MCUConfig.FORCE_STATE_AUTO });
				mediaList1.add(zzoMediaSourcesVO1);
	
				ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
				
			}
			
			broadcastMap.put(meetingDetailID, meetingInfo);
		}
		this.addMcuLog("setVideo:"+meetingInfo,LogEnum.TYPE_CONTROL_OPERATION);
	}

	
	//显示字幕
	public void showMessage(String mcuType, String confID, boolean isEnableContent, String content, String fontSize, String color, String loopNum, String speed, String position,String transparence){
		try {
			ZZOConfVO confVO = new ZZOConfVO();
			confVO.setConfID(confID);
			List<ZZOConfVO> confVOList = new ConfServiceImpl().getConfList(confVO, null);
			if(confVOList == null || confVOList.size() <= 0){
				return;
			}
			
			confVO = confVOList.get(confVOList.size() - 1);
//			if(confVO.getIsMasterConf() == null || confVO.getIsMasterConf().intValue() != MCUConfig.IS_MASTER_CONF){
//				return;
//			}
			if(confVO.getMcuType().equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)){//rmx1000
				if(isEnableContent){
	                confVO.setIsShow(MCUConfig.YES);
				}else{
	                confVO.setIsShow(MCUConfig.NO);
				}
				confVO.setAlign("BOTTOM");
				 confVO.setVertical(position);//垂直边界
				 confVO.setTransparency(transparence);//透明度
				 String[] col = color.split("_");
				 String colorFont = col[0];
				 String backColor = col[1];
				 confVO.setColor(colorFont);
				 confVO.setBackColor(backColor);
				 
				 confVO.setSpeed(speed);
				 confVO.setContent(content);
                 confVO.setFontSize(fontSize);
                 confVO.setLoopNum(loopNum);
//                原有代码
//				 confVO.setContent(content);
//                 confVO.setFontSize(fontSize);
//                 confVO.setLoopNum(loopNum);
			}else{//rmx2000 4000
				confVO.setIsShow(String.valueOf(isEnableContent));
				confVO.setContent(content);
				confVO.setFontSize(fontSize);
				confVO.setColor(color);
				confVO.setLoopNum(loopNum);
				confVO.setSpeed(speed);
				confVO.setAlign(position);
				confVO.setTransparency(transparence);
			}
			
			   WebContext wc =  WebContextFactory.get();
			   HttpServletRequest req = wc.getHttpServletRequest();
			   HttpSession  session = req.getSession();
			 
			  ZZOMcuFactory.getInstance().getMcuControlHelper().showMessage(confVO, null);
			this.addMcuLog("设置字幕-会议名称"+confVO.getConfName(),LogEnum.TYPE_CONTROL_OPERATION);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//end point far image 
	public String getBlowUp(String ip){
		String nameIP = "";
		nameIP = "http://"+ip+"/far_image_1.jpg";
		
		return nameIP;
		
	}
	
	//end point near image 
	public String getBlowDown(String ip){
		String nameIP = "";
		nameIP = "http://"+ip+"/near_image_1.jpg";
		return nameIP;
		
	}
	
	public void setConference(String monitor){
		String[] monitorInfo = monitor.split("__");
		String[] forceIdArray = new String[4];
		ZZOMediaSourcesVO zzoMediaSourcesVO= new ZZOMediaSourcesVO();
		List<ZZOMediaSourcesVO> mediaList=new ArrayList<ZZOMediaSourcesVO>();	
		zzoMediaSourcesVO.setLayout("1x1");
		zzoMediaSourcesVO.setLayoutType("conference");
		zzoMediaSourcesVO.setMcuIP(monitorInfo[2]);
		zzoMediaSourcesVO.setMcuMeetingID(monitorInfo[1]);
		zzoMediaSourcesVO.setMcuParticipantId(monitorInfo[3]);
		zzoMediaSourcesVO.setForceIdArray(forceIdArray);
		mediaList.add(zzoMediaSourcesVO);
		
		ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList);
	}

	public ZZOConfVO getMasterConf(String meetingDetailID){
		ConfManager confManager = ZZOMcuFactory.getInstance().getConfManager();
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(meetingDetailID);
		List<ZZOConfVO> confList = confManager.getConfList(confVO);
		if(confList!=null){			
		for(int i=0;i<confList.size();i++){
			if(confList.get(i).getIsMasterConf()==1){
				confVO = confList.get(i);
			}
		}
		}
		return confVO;
	}
	
	/**
	 * get participant channel status.such as package loss ...
	 * @param meetingDetailID
	 * @param ptsNameVconfGuidVmcuIps
	 * @return
	 */
	public List<ZZOPtsChannel> getPtsChannel(String meetingDetailID, String ptsNameVconfGuidVmcuIps){
		return ZZOMcuFactory.getInstance().getMcuControlHelper().getPtsChannel(meetingDetailID, ptsNameVconfGuidVmcuIps);
		
	}
/**
 * 设置分屏中自动轮询间隔时间
 * @param confId
 * @param time
 */
	
	public void setIntervaltime(String confId,String time){
		try {
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfID(confId);
		List<ZZOConfVO> confVOList = new ConfServiceImpl().getConfList(confVO, null);
		if(confVOList == null || confVOList.size() <= 0){
			return;
		}
		confVO = confVOList.get(confVOList.size() - 1);
		ZZOMcuFactory.getInstance().getMcuControlHelper().setAutoScanInterval(confVO, time);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.addMcuLog("setIntervaltime:" + confId,LogEnum.TYPE_CONTROL_OPERATION);
	}

	/**
	 * add by xiongshun 20130306 16:30
	 * 同步MCU模板
	 * @return
	 */
	public String synchroMCUmode(){
		logger.info("EquipmentAction	query	begin");
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		int m = 0;
		try{
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
		    //UserVO lu = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			//UserVO lu = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		    WebContext ctx = WebContextFactory.get(); 
		    HttpSession session = ctx.getHttpServletRequest().getSession(); 
		    UserVO lu = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			ArrayList<EquipmentVO> equipmentVOList= ServiceFactory.getEquipmentService().queryMCUID(tev);
			if(equipmentVOList != null && equipmentVOList.size()>0){
				for(int i = 0; i<equipmentVOList.size();i++){
						EquipmentMcuVO equipmentMcuVO = ServiceFactory.getEquipmentMcuService().queryByID(equipmentVOList.get(i).getEquipmentID());
						logger.info("BaseInfoAction	getMCUTemplate	begin");
						try {
							String mcuIp = equipmentVOList.get(i).getIp();
							String mcuUserName = equipmentMcuVO.getLoginName();
							String mcuPsw = equipmentMcuVO.getLoginPassword();
							sb.append("MCU编号：" + equipmentVOList.get(i).getEquipmentNO() + ";MCU_IP地址：" + mcuIp + ";所属会议室：" + equipmentVOList.get(i).getMeetingRoomVO().getMeetingRoomName() + ";");
							List<ZZOConfProfileVO> profileList = ZZOMcuFactory.getInstance().getMcuControlHelper().getProfileList(mcuIp, mcuUserName, mcuPsw, null);
							logger.info("BaseInfoAction	getMCUTemplate	模板数量："+profileList.size());
							
							if(profileList!=null&&profileList.size()>0){
								BaseInfoVO baseInfoVO = new BaseInfoVO();
								baseInfoVO.setInfoName(mcuIp);
								//情况该MCU模板信息
								ServiceFactory.getBaseInfoService().delete(baseInfoVO);
								sb.append("提取模板成功;模板数量：" + profileList.size() + "。");
								m += profileList.size();
								for(ZZOConfProfileVO vo :profileList){
									baseInfoVO = new BaseInfoVO();
									baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
									baseInfoVO.setInfoName(mcuIp);
									baseInfoVO.setDescription(vo.getProfileName());
									baseInfoVO.setInfoValue(vo.getGuid());
									ServiceFactory.getBaseInfoService().add(baseInfoVO);
									logger.info("BaseInfoAction	getMCUTemplate	添加	"+vo.getProfileName()+"	成功，ID："+vo.getGuid());
								}
							}
							
							BaseInfoHelp.getMcuCon();//更新缓存
							} catch (Exception e) {
								sb1.append(equipmentVOList.get(i).getIp()+"（所属会议室：" + equipmentVOList.get(i).getMeetingRoomVO().getMeetingRoomName()+"）;");
								sb.append("提取模板失败。");
								logger.error("BaseInfoAction getMCUTemplate	error:"+equipmentMcuVO.getIp()+e.getMessage());
							}
							logger.info("BaseInfoAction	getMCUTemplate	end");
				
				}
			}
		}catch(Exception e){
			logger.error("EquipmentAction	query	error:"+e.getMessage());
		}
		//EquipmentMcuVO list = ServiceFactory.getEquipmentMcuService().queryByID("1");
		sb2.append("总共成功提取MCU模板"+m+"个；");
		if(sb1.length()>0){
			sb2.append("提取MCU模板失败的MCU_IP有：");
			sb2.append(sb1);
		}
		
		this.addMcuLog("synchroMCUmode",LogEnum.TYPE_CONTROL_OPERATION);
		return sb2.toString();
	}
	
	
	

	
	/**
	 * 开始分屏轮询
	 * @author zhangjz
	 * @param meetingDetailId 
	 * @param count				分屏屏数
	 * @param infos			所有屏会场数组
	 * @return
	 */
	public String startPoll(String meetingDetailId,String meetingMode,String layoutMode,String[][] infos,int intervalTime,String meetings){
		logger.info("McuDwrMethod		startPoll	begin");
		//MeetingAppConfig.pollMap.remove(meetingDetailId);
		terminalPollThread1(meetingDetailId);
		/**日志*/
		StringBuffer operatorContent = new StringBuffer();
		operatorContent.append("用户会议控制中/");
		//在日志记录内添加会议名字
		operatorContent.append(LogUtil.getMeetingDetailVO(meetingDetailId).getMeetingName());
		if(MeetingAppConfig.pollMap.get(meetingDetailId)==null){	//判断该会议是否正在轮询
			int count = infos.length;
			String monitor = "";
			ZZOConfVO confVO = new ZZOConfVO();
			confVO.setConfFlagId(meetingDetailId);
			try {
				if((VideoconferenceEnum.LECTURERMODE).equals(meetingMode)||(VideoconferenceEnum.SAMELAYOUTMODE).equals(meetingMode)){
					monitor = "";
					List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO); //取得会议列表
					for(ZZOConfVO cVO : confList){
						if(cVO.getIsMasterConf()==1){				//取得主会
							confVO = cVO;
						}
					}
					String[] layoutConfig = confVO.getLayoutConfigGuid().split("_");
					for(int i=0;i<infos.length;i++){
						if(infos[i][0].equals("None")){
							infos[i][0] = layoutConfig[i];  //modify by zhangjz 屏幕不变的
						}
					}
				}else if((VideoconferenceEnum.PERSONALMODE).equals(meetingMode)){
					List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailId);
					ZZOMainStatusVO mainMeetingRoom =null;
					for(int i=0;i<meetingRoomList.size();i++){
						if(meetingRoomList.get(i).getIsSpeaker()==1&&meetingRoomList.get(i).getCascadeRole().equals("none")){
							mainMeetingRoom = meetingRoomList.get(i);
							break;
						}
					}
					if(mainMeetingRoom==null){
						monitor = "";
					}else{
						monitor = mainMeetingRoom.getMcu_participant_name()+"__"+mainMeetingRoom.getMcuMeetingID()+"__"+mainMeetingRoom.getMcuIp()+"__"+mainMeetingRoom.getMcu_participant_id();
						String[] layoutConfig = mainMeetingRoom.getDescription().split("_");
						for(int i=0;i<infos.length;i++){
							if(infos[i][0].equals("None")){
								infos[i][0] = layoutConfig[i+1];   //modify by zhangjz 屏幕不变的
							}
						}
					}
				}
				synchronized (MeetingAppConfig.pollMap) {
					/*if(MeetingAppConfig.pollMap.get(meetingDetailId) != null){
						MeetingAppConfig.pollMap.get(meetingDetailId).setFlag(false);
						MeetingAppConfig.pollMap.get(meetingDetailId).getThread().interrupt();
					}*/
					terminalPollThread1(meetingDetailId);
					CallPollThread1 callPoll = new CallPollThread1(meetingDetailId,layoutMode,count,infos,intervalTime,meetingMode,monitor,meetings);
					//Thread callPollThread = new Thread(callPoll);
					MeetingAppConfig.pollMap.put(meetingDetailId, callPoll);		//将该轮询线程放入缓存
				}
				
				MeetingControlStatus mcs = new MeetingControlStatus();
				mcs.setPollStatus(MeetingAppConfig.POLL_START);
				MeetingAppConfig.meetingControlStatusMap.put(meetingDetailId, mcs);
				//callPollThread.start();
				logger.info("McuDwrMethod		startPoll	end && Poll Success");
				operatorContent.append("/轮询成功");
				LogUtil.addLogForOperate(operatorContent.toString());
				return "ok";
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}
		operatorContent.append("/轮询失败");
		LogUtil.addLogForOperate(operatorContent.toString());
		logger.info("McuDwrMethod		startPoll	end && Poll Failure");
		return "failure";
	}
	
	/**
	 * 调整轮询
	 * @return
	 */
	public String modifyPoll( String meetingDetailId,String[][] infos,int intervalTime){
		StringBuffer operatorContent = new StringBuffer();
	try{	
		if( MeetingAppConfig.pollMap.get(meetingDetailId) != null){//有轮询
			/**日志*/
			
			operatorContent.append("用户会议控制中/-会议名:");
			//在日志记录内添加会议名字
			operatorContent.append(LogUtil.getMeetingDetailVO(meetingDetailId).getMeetingName());
			
			CallPollThread1 cpt = MeetingAppConfig.pollMap.get(meetingDetailId);
			cpt.setIntervalTime(intervalTime);
			cpt.setInfos(infos);
			
			operatorContent.append("/调整轮询-增加会场成功");
			LogUtil.addLogForOperate(operatorContent.toString());
			
			return "ok";
		}else{
			operatorContent.append("/调整轮询-增加会场失败,会议没有轮询");
			LogUtil.addLogForOperate(operatorContent.toString());
			return "nopoll";
		}
	}catch (Exception e) {
		e.printStackTrace();
		operatorContent.append("/调整轮询-增加会场失败");
		LogUtil.addLogForOperate(operatorContent.toString());
		return "fall";
	}
		
}
	
	
	/**
	 * 停止分屏轮询
	 * @author zhangjz
	 * @param meetingDetailId
	 * @return
	 */
	public String stopPoll(String meetingDetailId){
	 try{	
		if(MeetingAppConfig.pollMap.get(meetingDetailId)!=null){
			/*MeetingAppConfig.pollMap.get(meetingDetailId).setFlag(false);
			MeetingAppConfig.pollMap.get(meetingDetailId).getThread().interrupt();*/
			terminalPollThread1(meetingDetailId);
			/*if(MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId)!=null){
				MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId).setPollStatus(MeetingAppConfig.POLL_STOP);
			}*/
			//MeetingAppConfig.pollMap.remove(meetingDetailId);
			/**日志*/
			StringBuffer operatorContent = new StringBuffer();
			operatorContent.append("用户会议控制中/");
			//在日志记录内添加会议名字
			operatorContent.append(LogUtil.getMeetingDetailVO(meetingDetailId).getMeetingName());
			operatorContent.append("/轮询被手动结束");
			LogUtil.addLogForOperate(operatorContent.toString());
			
			return "ok";
		}else{
			return "fall";
		}
	 }catch (Exception e) {
		e.printStackTrace();
		return "error";
	 }
	}
	
	/**
	 * 暂停轮询
	 * @param meetingDetailId
	 * @return
	 */
	public String suspendPoll(String meetingDetailId){
	  try{	
		if(MeetingAppConfig.pollMap.get(meetingDetailId)!=null){
			MeetingAppConfig.pollMap.get(meetingDetailId).setSuspend();
			
			if(MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId)!=null){
				MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId).setPollStatus(MeetingAppConfig.POLL_SUSPEND);
			}
			/**日志*/
			StringBuffer operatorContent = new StringBuffer();
			operatorContent.append("用户会议控制中/");
			//在日志记录内添加会议名字
			operatorContent.append(LogUtil.getMeetingDetailVO(meetingDetailId).getMeetingName());
			operatorContent.append("/轮询被暂停");
			LogUtil.addLogForOperate(operatorContent.toString());
			
			return "ok";
		}else{
			return "fall";
		}
	  }catch (Exception e) {
		return "error";
	  }
	}
	
	public String resumePoll(String meetingDetailId){
	   try{	
			if(MeetingAppConfig.pollMap.get(meetingDetailId)!=null){
				MeetingAppConfig.pollMap.get(meetingDetailId).setResume();
				
				if(MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId)!=null){
					MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId).setPollStatus(MeetingAppConfig.POLL_START);
				}
				/**日志*/
				StringBuffer operatorContent = new StringBuffer();
				operatorContent.append("用户会议控制中/");
				//在日志记录内添加会议名字
				operatorContent.append(LogUtil.getMeetingDetailVO(meetingDetailId).getMeetingName());
				operatorContent.append("/轮询被恢复");
				LogUtil.addLogForOperate(operatorContent.toString());
				return "ok";
			}else{
				return "faill";
			}
	   }catch( Exception e){
		   return "error";
	   }
	}
	
	/**
	 * 定制轮询(轮询中添加会场)
	 * @param meetingDetailId
	 * @return
	 */
	public String modifyPoll(String meetingDetailId){
			if(MeetingAppConfig.pollMap.get(meetingDetailId)!=null){
				return "ok";
			}else{
				return "fall";
			}
	}
	/**
	 * auto comparison handler.
	 * @param meetingDetailId
	 * @return
	 */
	public String autoCompare(String meetingDetailId){
		//get broadcaster.
		List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailId);
		if(meetingRoomList == null || meetingRoomList.size() <= 0){
			return "none";
		}
		ZZOMainStatusVO mainMeetingRoom = new ZZOMainStatusVO();
		for(int i=0;i<meetingRoomList.size();i++){
			if(meetingRoomList.get(i).getIsSpeaker()==1&&meetingRoomList.get(i).getCascadeRole().equals("none")){
				mainMeetingRoom = meetingRoomList.get(i);
				break;
			}
		}
		if(mainMeetingRoom==null){
			return "none";
		}else{
			//start thread
			//AutoCompareThread 
			AutoCompareThread autoCompareThread = new AutoCompareThread(meetingDetailId, mainMeetingRoom , meetingRoomList);
			autoCompareThread.start();
		}
		
		return "success";
	}
	
	/**
	 * 更新会场信息
	 * @param meetingDetailID
	 * @param confID
	 * @param ptsParticipantId
	 * @param infoValue 0-mcu_participant_name 1-casDialDirection 2-pInterface 3-mcu_participant_ip
	 *                  4-aliasName 5-aliasType 6-callSpeed 7-maxResolution 8-videoProtocol 9-cascadeRole
	 */
    public void 	updateParticipant ( String meetingDetailID , String confID , String ptsParticipantId , String[] infoValue  ){
    	
    	
    	ZZOMainVO zzoMainStatusVO = new ZZOMainVO();
    	zzoMainStatusVO.setEquipmentName(infoValue[0]);
    	zzoMainStatusVO.setCallDirection(infoValue[1]);
    	zzoMainStatusVO.setpInterface(infoValue[2]);
    	zzoMainStatusVO.setEquipmentIP(infoValue[3]);
    	zzoMainStatusVO.setAliasName(infoValue[4]);
    	zzoMainStatusVO.setAliasType(infoValue[5]);
    	zzoMainStatusVO.setLineRate(infoValue[6]);
    	zzoMainStatusVO.setMaxResolution(infoValue[7]);
    	zzoMainStatusVO.setVideoProtocol(infoValue[8]);
    	zzoMainStatusVO.setCascadeRole(infoValue[9]);
    	
    	ZZOMcuFactory.getInstance().getMcuControlHelper().updateParticipant(meetingDetailID, confID, ptsParticipantId, zzoMainStatusVO);
    	this.addMcuLog("updateParticipant:" + infoValue[0]+","+infoValue[3],LogEnum.TYPE_CONTROL_OPERATION);
    }
    
    
    /**
	 * 更新会场名字
	 * @param meetingDetailID
	 * @param confID
	 * @param ptsParticipantId
	 * 
	 */
    public void 	setParticipantVisualName ( String meetingDetailID , String confID , String ptsParticipantId , String equipmentName  ){
    	ZZOMcuFactory.getInstance().getMcuControlHelper().setPartyVisualName(meetingDetailID, confID, ptsParticipantId, equipmentName);
    	this.addMcuLog("setParticipantVisualName:" + equipmentName,LogEnum.TYPE_CONTROL_OPERATION);
    }

    
    public String getMeetingControlStatus(String meetingDetailId){
    	if(MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId)!=null){
    		return MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId).getPollStatus();
    	}
    	return MeetingAppConfig.POLL_STOP;
    }

    
    
    
    /**
	 * 添加轮询模板
	 * @param ptsParticipantId
	 * 
	 */
    public boolean 	addPollTerminal (  String templateName , String[] equipmentIDs ,String[] locIds){
    	
    	WebContext ctx = WebContextFactory.get(); 
		HttpSession session = ctx.getHttpServletRequest().getSession(); 
		UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
    	
    	PollTemplateVO ptVO = new PollTemplateVO();
    	ptVO.setCreateUserID(userVO.getUserID());
    	ptVO.setPollTemplateName(templateName);
    	//ptVO.setStatus(0);
    	ptVO.setCreateTime(new Timestamp(new Date().getTime()));
    	
    	try{
    		ptVO = ServiceFactory.getPollTemplateService().add(ptVO);
    		
    		PollTerminalService pos =  ServiceFactory.getPollTerminalService();
    		
    		///添加到轮询终端表
    		for( int i=0; i<equipmentIDs.length; i++ ){
    			PollTerminalVO pterVO = new PollTerminalVO();
    			pterVO.setCreateTime(new Timestamp(new Date().getTime()));
    			pterVO.setCreateUserID(userVO.getUserID());
    			pterVO.setEquipmentID(equipmentIDs[i]);
    			pterVO.setOrderNum(i+1);
    			pterVO.setPollTemplateID(ptVO.getPollTemplateID());
    			pterVO.setOrgType(PollTerminalEnum.TER);
    			pos.add(pterVO);
    			
    		}
    		
    		for( int i=0; i<locIds.length; i++ ){
    			PollTerminalVO pterVO = new PollTerminalVO();
    			pterVO.setCreateTime(new Timestamp(new Date().getTime()));
    			pterVO.setCreateUserID(userVO.getUserID());
    			pterVO.setEquipmentID(locIds[i]);
    			pterVO.setOrderNum(i+1);
    			pterVO.setPollTemplateID(ptVO.getPollTemplateID());
    			pterVO.setOrgType(PollTerminalEnum.LOC);
    			pos.add(pterVO);
    			
    		}
    	}catch( Exception e){
    		return false;
    	}
    	this.addMcuLog("addPollTerminal:" + templateName,LogEnum.TYPE_CONTROL_OPERATION);
    	return true;
    }
    
    
    /**
	 * 修改轮询模板
	 * @param ptsParticipantId
	 * 
	 */
    public boolean 	modifyPollTerminal (  String templateID , String templateName , String[] equipmentIDs ,String[] locIds){
        try{
	    	PollTerminalService pos =  ServiceFactory.getPollTerminalService();
	    	PollTemplateService pts =  ServiceFactory.getPollTemplateService();
	    	
	    	PollTerminalVO pollTerminalVO1 = new PollTerminalVO();
			pollTerminalVO1.setPollTemplateID(templateID);
			pos.deleteByVO(pollTerminalVO1);//删除终端
			pts.deleteByID(templateID);//删除模板
	    	
	    	
	    	WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
	    	
	    	PollTemplateVO ptVO = new PollTemplateVO();
	    	ptVO.setCreateUserID(userVO.getUserID());
	    	ptVO.setPollTemplateName(templateName);
	    	//ptVO.setStatus(0);
	    	ptVO.setCreateTime(new Timestamp(new Date().getTime()));
    	
    	
    		ptVO = pts.add(ptVO);
    		
    		
    		
    		///添加到轮询终端表
    		for( int i=0; i<equipmentIDs.length; i++ ){
    			PollTerminalVO pterVO = new PollTerminalVO();
    			pterVO.setCreateTime(new Timestamp(new Date().getTime()));
    			pterVO.setCreateUserID(userVO.getUserID());
    			pterVO.setEquipmentID(equipmentIDs[i]);
    			pterVO.setOrderNum(i+1);
    			pterVO.setPollTemplateID(ptVO.getPollTemplateID());
    			pterVO.setOrgType(PollTerminalEnum.TER);
    			pos.add(pterVO);
    			
    		}
    		//组织结构
    		for( int i=0; i<locIds.length; i++ ){
    			PollTerminalVO pterVO = new PollTerminalVO();
    			pterVO.setCreateTime(new Timestamp(new Date().getTime()));
    			pterVO.setCreateUserID(userVO.getUserID());
    			pterVO.setEquipmentID(locIds[i]);
    			pterVO.setOrderNum(i+1);
    			pterVO.setPollTemplateID(ptVO.getPollTemplateID());
    			pterVO.setOrgType(PollTerminalEnum.LOC);
    			pos.add(pterVO);
    			
    		}
    	}catch( Exception e){
    		return false;
    	}
    	this.addMcuLog("modifyPollTerminal:" + templateName,LogEnum.TYPE_CONTROL_OPERATION);
    	return true;
    }
    
    
    class UpdateMeetingRoomState extends Thread{
    	private ServerContext sctx = null;
    	private String meetingDetailId = null;
    	
    	public UpdateMeetingRoomState( ServerContext sctx , String meetingDetailId ){
    		this.sctx = sctx;
    		this.meetingDetailId = meetingDetailId;
    	}
    	
		@Override
		public void run() {
			
			while( true ){
				//得到上下文
				
				         
				 //得到要推送到 的页面  icmp为项目名称 ， 一定要加上。  
				 Collection<ScriptSession> sessions = sctx.getScriptSessionsByPage("/icmp/mcuControl/getClassifiedRoomList.action?chooseMeetingNumber=" + meetingDetailId);  
					          
				Util util = new Util(sessions);  
					          
				//下面是创建一个javascript脚本 ， 相当于调用页面js里 show(msg)方法;   
			    ScriptBuffer sb = new ScriptBuffer();  
				sb.appendScript("getMeetingRoomList(");  
				sb.appendData("room");  
			    sb.appendScript(")");  
				          
		        //推送  
				util.addScript(sb);
				
				try{
					this.sleep(5*1000);
				}catch( Exception e){
					e.printStackTrace();
				}
			}
			  
		}
    	
    }
    
    public Thread getThread( ServerContext sctx , String meetingDetailId ){
    	Thread t = new UpdateMeetingRoomState( sctx , meetingDetailId);
    	return t;
    }
    
    /**
     * synchronize conferences from every mcu .wangle 2013-09-16
     * @param meetingDetailID
     * @return
     */
    public boolean synConfsFromMcu(String meetingDetailID ){
    	addMcuLog("synConfsFromMcu " + meetingDetailID,LogEnum.TYPE_CONTROL_OPERATION);
    	
    	if(meetingDetailID == null || meetingDetailID.trim().equals("")){
    		//synchronize conferences from all of mcus that are registered.  
			new McuDwrHelper().synConfsFromMcu();
		}else{
			new McuControlHelper().synConfsFromMcu(meetingDetailID);	
		}
    	
    	return true;
    }
    
    /**
     * 
     * @param meetingDetailID 会议ID
     * @param ip  终端IP
     * @param comment  备注
     * @return
     */
    public boolean setCommentByIp( String meetingDetailID , String ip , String comment,String roomip){
    	HashMap<String,String>  ipMap  = terComment.get(meetingDetailID);
    	
    	if( ipMap == null ){
    		ipMap = new HashMap<String, String>();
    	}

        ipMap.put(ip, comment);
        
        terComment.put(meetingDetailID, ipMap);
    	
        
        /////日志
        WebContext wc = WebContextFactory.get();
        UserVO sessionUserVO = (UserVO)wc.getHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		if( sessionUserVO != null ){
			LogVO  logVO  = new LogVO();
			logVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
			logVO.setLevel(LogEnum.LEVEL_DeFAULT);
			logVO.setUserID(sessionUserVO.getUserID());
			logVO.setUserName(sessionUserVO.getName());
			logVO.setOperatorContent("对" + roomip.split("__")[0] + "会场添加备注");
			try {
				new LogServiceImpl().add(logVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
        
    	return true;
    }
    
    /**
     * 根据会议ID和终端IP获取该会场备注信息
     * @param meetingDetailID  会议ID
     * @param ip 终端IP
     * @return
     */
    public String getCommentByIp( String meetingDetailID , String ip ){
    	HashMap<String,String>  ipMap  = terComment.get(meetingDetailID);
    	
    	if( ipMap == null ){
    		return null;
    	}else{
    		String comment = ipMap.get(ip);
    		return comment;
    	}

        
    }
    
    /**
     * 获取该会议存放备注的map
     * @param meetingDetailID 会议ID
     * @return
     */
    public Map<String,String> getTerminalComment( String meetingDetailID ){
    	HashMap<String,String>  ipMap  =  this.getTerComment().get(meetingDetailID);
    	if( ipMap !=null ){
    		return ipMap;
    	}
    	return null;
    	
    }
    
    
	public static HashMap<String, HashMap<String, String>> getTerComment() {
		return terComment;
	}
    
    /**
     * 
     * @param confID 小会ID
     * @param meetingDetailID 系统会议ID
     * @return
     */
	public String[] getLayOutModeByConfID ( String confID,String meetingDetailID ){
		
		ZZOConfVO confVO = new ZZOConfVO();
		confVO.setConfFlagId(meetingDetailID);
		confVO.setConfID(confID);
		List<ZZOConfVO> confList;
		try {
			confList = new ConfServiceImpl().getConfList(confVO, null);
		
	//		List<ZZOConfVO> confList  = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
			for( ZZOConfVO zzoConfVO : confList ){
				if( zzoConfVO.getConfID().equals(confID)){
					String layoutMode = zzoConfVO.getLayoutMode();
					String[] layOutInfo = new String[3];
					String forceIds = zzoConfVO.getLayoutConfigGuid();
					layOutInfo[1] = forceIds;
					
					String key = (String)CommonUtil.getMapKey(MeetingAppConfig.layoutMap, layoutMode);
					if(key!=null){
						if(key.endsWith("_1000")){
							layOutInfo[0] = key.substring(0, key.length()-5);
							String[] forceId = forceIds.split("-");
							int screenCount=1;
							if(forceId.length>=5&&forceId.length<9){
								screenCount = 5;
							}else if(forceId.length==9){
								screenCount = 9;
							}else if(forceId.length>=10){
								screenCount = 10;
							}else{
								screenCount = forceId.length;
							}
							layOutInfo[2] = Integer.toString(screenCount);
						}else{
							layOutInfo[0] = key;
							String[] forceId = forceIds.split("_");
							int screenCount=1;
							if(forceId.length>=5&&forceId.length<9){
								screenCount = 5;
							}else if(forceId.length==9){
								screenCount = 9;
							}else if(forceId.length>=10){
								screenCount = 10;
							}else{
								screenCount = forceId.length;
							}
							layOutInfo[2] = Integer.toString(screenCount);
						}
					}else{
						layOutInfo[0] = "noPage";
					}
					
					return layOutInfo;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * backup mcu wangle 2013-8-26
	 * @param meetingDetailID: current meeting Detail id
	 * @param newMcuIp: new mcu ip
	 * @return
	 */
	public String backupMcu(String meetingDetailID, String oldMcuIp, String newMcuIp){
		//check if this conference is master in the cascade conference. it's manual to back up master conference. 
		/*
		ZZOConfVO tempconfVo=new ZZOConfVO();
		tempconfVo.setConfFlagId(meetingDetailID);
		List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(tempconfVo);
		if(confList != null && confList.size() > 1){
			for (ZZOConfVO cVO : confList) {
				if(cVO.getIsMasterConf() != null && cVO.getIsMasterConf().intValue() == MCUConfig.IS_MASTER_CONF && 
						cVO.getMcuIP().equals(oldMcuIp)){
					return "master";
				}
			}
		}
		*/
		new McuDwrHelper().backupMcu(meetingDetailID.trim(), oldMcuIp, newMcuIp);
		return "success";
	}
	
	//zjy添加操作日志
	public void addMcuLog(String operatorContent,int logtype){
		try{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 

			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);

			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(logtype);
			vLogVO.setUserIP(ctx.getHttpServletRequest().getRemoteHost());
			vLogVO.setUserID(userVO.getUserID());
			vLogVO.setUserName(userVO.getName());
			//vLogVO.setStarTime();
			if(operatorContent!=null&&operatorContent.length()>0){
				vLogVO.setOperatorContent(operatorContent);	
			}
//			ServiceFactory.getLogService().add(vLogVO);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			System.out.println("加入日志错误");
			e.printStackTrace();
		}
	}
	
	
	public void addSysLog(String operatorContent,int logtype,UserVO userVO,String ip){
		try{
			
			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(logtype);
			vLogVO.setUserIP(ip);
			vLogVO.setUserID(userVO.getUserID());
			vLogVO.setUserName(userVO.getName());
			//vLogVO.setStarTime();
			if(operatorContent!=null&&operatorContent.length()>0){
				vLogVO.setOperatorContent(operatorContent);	
			}
//			ServiceFactory.getLogService().add(vLogVO);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			System.out.println("加入日志错误");
			e.printStackTrace();
		}
	}
	
	/**
	 * terminal poll thread1.
	 * @param meetingDetailId
	 * wangle 2013-12-18
	 */
	private void terminalPollThread1(String meetingDetailId){
		if(MeetingAppConfig.pollMap.get(meetingDetailId) != null){
			MeetingAppConfig.pollMap.get(meetingDetailId).setFlag(false);
			MeetingAppConfig.pollMap.get(meetingDetailId).getThread().interrupt();
		}
		
		MeetingAppConfig.pollMap.remove(meetingDetailId);//清楚该会议轮询线程
		//clean polling control status.
		if(MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId)!=null){
			MeetingAppConfig.meetingControlStatusMap.get(meetingDetailId).setPollStatus(MeetingAppConfig.POLL_STOP);
		}
	}
	
	/**
	 * delete MeetingDetailRoomVO
	 * @param confFlagId
	 * @param ptsNameVconfGuidVmcuIps
	 */
	private void delMeetingDetailRoomVO(String confFlagId, String ptsNameVconfGuidVmcuIps){
		ZZOMainStatusVO meetingMcuVO = null;
		String[] ptsArray = OperateUtil.splitter(ptsNameVconfGuidVmcuIps, MCUConfig.SUBTRACTION_DELIMITER);
		String[] ptsConfMcuArray = null;
		try {
			if(ptsArray != null && ptsArray.length > 0){
				List<ZZOMainStatusVO> meetingMcuVOList = null;
				ZZOMainStatusVO tempMeetingMcuVO = new ZZOMainStatusVO();
				
				tempMeetingMcuVO.setConfFlagId(confFlagId);
				for(int i = 0; i < ptsArray.length; i++){
					ptsConfMcuArray =  OperateUtil.splitter(ptsArray[i], MCUConfig.OP_DELIMITER + MCUConfig.OP_DELIMITER);
					if(ptsConfMcuArray == null || ptsConfMcuArray.length != 3){
						continue;
					}
					tempMeetingMcuVO.setMcu_participant_name(ptsConfMcuArray[0]);
					tempMeetingMcuVO.setMcuMeetingID(ptsConfMcuArray[1]);
					tempMeetingMcuVO.setMcuIp(ptsConfMcuArray[2]);
					meetingMcuVOList = ConfAllPts.getMeetingMcuList(tempMeetingMcuVO);
					if(meetingMcuVOList == null || meetingMcuVOList.size() <= 0){
						continue;
					}
					
					meetingMcuVO = meetingMcuVOList.get(0);
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setIp(meetingMcuVO.getMcu_participant_ip());
				List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
				if(equipList != null &&equipList.size() >0){
					VideoconferenceVO videoConfVO = new VideoconferenceVO();
					videoConfVO.setMeetingDetailID(confFlagId);
					if(equipList.get(0).getMeetingRoomVO() != null){
						videoConfVO.setSubmeetingRoomID(equipList.get(0).getMeetingRoomVO().getMeetingRoomID());
						ServiceFactory.getVideoconferenceService().delVideoconference(videoConfVO, null);
					}
				}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	/**
	 * 
	 * @param meetingDetailID
	 * @param confId
	 * @param ptsVO
	 */
	public void addParticipantNew(String meetingDetailID, String confId, ZZOMainVO ptsVO){
		//1.assemble data
		List<ZZOMainVO> mainVOList = new ArrayList<ZZOMainVO>();
		ZZOMainVO mcuMainVO = new ZZOMainVO();
		List<ZZOMainVO> ptsList = new ArrayList<ZZOMainVO>();
		ptsList.add(ptsVO);
		mcuMainVO.setSubMainVOList(ptsList);
		mainVOList.add(mcuMainVO);
		//2.call adding method.
		ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(meetingDetailID, confId, mainVOList);		
	}
	
	/**
     * 添加终端到XX会议
     * @param meetingDetailID 会议ID
     * @param meetingRoomIDs 添加的会场ID
     * @param mcuIp 添加到的MCU IP
     * @param confID 添加到的会议ID
     * @param tempIP 手动输入的终端ip
     * @param tempName 手动输入的终端显示名称
     * @return
     * @author liujf add on 2014-8-27
     */
	public boolean addPartyOnConf(String meetingDetailID, String[] partyIDs, String confID , String mcuIp, String tempIP , String tempName){
		EquipmentService equSer = ServiceFactory.getEquipmentService();
		EquipmentVO mcuVO = new EquipmentVO();
		mcuVO.setIp(mcuIp);
		mcuVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
		ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
		try{
				List<EquipmentVO> mculist = equSer.query(mcuVO, null);
				mcuVO = mculist.get(0);//添加到的MCU对象
				ZZOMainVO innerMcuVO = new ZZOMainVO();
		        innerMcuVO.setEquipmentIP(mcuVO.getIp());
		        innerMcuVO.setModelID(mcuVO.getEquipmentModel());
		            //MCU 4000 and MCU 2000 use the same model id
		        if(mcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
		            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
		        }
				
				
				for( int i=0; i<partyIDs.length; i++ ){
//					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
//					meetingRoomVO.setMeetingRoomID(meetingRoomIDs[i]);
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setEquipmentID(partyIDs[i]);
					equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					List<EquipmentVO> listEqu = equSer.query(equipmentVO, null);
					if( listEqu != null && listEqu.size()>0){
						equipmentVO = listEqu.get(0);//当前要添加的终端对象
						ZZOMainVO innerTerminalVO = new ZZOMainVO();
		            	innerTerminalVO.setEquipmentName(equipmentVO.getEquipmentNO());
		            	innerTerminalVO.setEquipmentIP(equipmentVO.getIp());
		            	innerTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_OUT);//TODO:呼入方式待定
		            	//add advanced parameters wangle 2014-7-9
		            	EquipmentTerminalVO equipmentTerminalVO = ServiceFactory.getEquipmentTerminalService().queryByID(equipmentVO.getEquipmentID());
		            	if(equipmentTerminalVO != null){
		            		//new McuControlHelper().addAdvancedPara(innerTerminalVO, equipmentTerminalVO);
		            	}
		            	
		            	innerTermList.add(innerTerminalVO);
		                this.addMcuLog("会控添加会场(列表选择):"+innerTerminalVO.getEquipmentName()+","+innerTerminalVO.getEquipmentIP(),LogEnum.TYPE_CONTROL_OPERATION);
					}
					
				}
				
				//加入手动输入ip的终端
				ZZOMainVO innerTerminalVO = new ZZOMainVO();
            	innerTerminalVO.setEquipmentName(tempName);
            	innerTerminalVO.setEquipmentIP(tempIP);
            	innerTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_OUT);//TODO:呼入方式待定
            	innerTermList.add(innerTerminalVO);
            	//////
				innerMcuVO.setSubMainVOList(innerTermList);
	            innerMcuVOList.add(innerMcuVO);
	            ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(meetingDetailID, confID, innerMcuVOList);
	             /**日志*/
	            if(tempName!=null&&!tempName.equals("")){
	            this.addMcuLog("会控添加会场(手动添加):"+tempName+","+tempIP,LogEnum.TYPE_CONTROL_OPERATION);
	            }
			} catch (Exception e) {
				e.printStackTrace();
				return false;
		}
		return true;
	}
	
	public String getMcuNameNew(String mcuIP){
		String str="";
		EquipmentVO eVO = new EquipmentVO();
		eVO.setIp(mcuIP);
		try {
			ArrayList<EquipmentVO> list=ServiceFactory.getEquipmentService().queryIP(mcuIP);
			if(list!=null && list.size()>0){
				str = list.get(0).getEquipmentNO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
