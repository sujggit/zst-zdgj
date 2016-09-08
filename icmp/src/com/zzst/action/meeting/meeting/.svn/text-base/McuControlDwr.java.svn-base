package com.zzst.action.meeting.meeting;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.meeting.task.NoticeTask;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.MeetingUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMainVO;
import com.zzst.application.mcuVO.ZZOMediaSourcesVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.timerTask.CjfTimerHelper;


/**
 *@Description	会议控制涉及到的方法
 *@date 2012-5-23上午10:50:41
 *@author ryan
 */
public class McuControlDwr {

	private static Logger logger = CjfLogger.getLogger(McuControlDwr.class.getName());
	
	//轮询参数
	public static boolean isRolling = false;
	public static int rollNum = 0;
	
	
	/**
	 * 提取所有会场 （所有终端，不发所属mcu）
	 * @return
	 */
	public ArrayList<EquipmentVO> getAllMeetingRoom(){
		logger.info("McuControlDwr	getAllMeetingRoom	begin");
		ArrayList<EquipmentVO> equipmentVOList = new ArrayList<EquipmentVO>();
		try{
			EquipmentVO equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO,null);
		}catch(Exception e){
			logger.info("McuControlDwr	getAllMeetingRoom	error："+e.getMessage());
			return null;
		}
		logger.info("McuControlDwr	getAllMeetingRoom	end");
		return equipmentVOList;
	}
	
	/**
	 * 添加会场
	 * @param meetingDetailID
	 * @param meetingRoomIDs
	 * @param meetingRoomNames
	 */
	public boolean addParticipants(String meetingDetailID, String meetingRoomIP){
		try {
				ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
				Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = MeetingUtil.getMCU("'"+meetingRoomIP+"'");//sql要求
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
		            List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
		           
		            for(EquipmentTerminalVO outTerminal : terminalList){
		            	 ZZOMainVO innerTerminalVO = new ZZOMainVO();
		            	 innerTerminalVO.setEquipmentName(outTerminal.getMeetingRoomVO().getMeetingRoomName());
		            	 innerTerminalVO.setEquipmentIP(outTerminal.getIp());
		            	 
		            	 //E.164 TODO
		            	 if(outTerminal.getRadioTreaty()!=null && !"".equals(outTerminal.getRadioTreaty())){
		            		 innerTerminalVO.setAliasName(outTerminal.getPstn());//别名——电话号码
		            		 innerTerminalVO.setAliasType(outTerminal.getRadioTreaty());
		            		 innerTerminalVO.setEquipmentIP(MeetingAppConfig.E164_IP);
		            	 }
		            	 
		            	 innerTermList.add(innerTerminalVO);
		            }
		            
		            innerMcuVO.setSubMainVOList(innerTermList);
		            innerMcuVOList.add(innerMcuVO);
		        }
		        ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(meetingDetailID, innerMcuVOList);
		        
		} catch (Exception e) {
			logger.info("McuControlDwr	addParticipants	error："+e.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * 会议延时
	 * @param meetingDetailID
	 * @param delayTime
	 */
	public void meetingDelay(String meetingDetailID,String delayTime){
		ZZOMcuFactory.getInstance().getMcuControlHelper().setEndTime(meetingDetailID, delayTime);
		changeMeetingEndTime(meetingDetailID, delayTime);
	}
	
	private void changeMeetingEndTime(String meetingDetailID, String delayTime) {
		//meetingDetailID = "8a8183853b4a3ae5013b4b333aaa000e";
		MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
		vMeetingDetailVO.setMeetingDetailID(meetingDetailID);
		try {
			vMeetingDetailVO = ServiceFactory.getMeetingDetailService().getMeetingDetailList(vMeetingDetailVO, null).get(0);
			Timestamp endTime = new Timestamp(vMeetingDetailVO.getMeetingEndTime().getTime()+(Long.valueOf(delayTime)*3600*1000));
			vMeetingDetailVO.setMeetingEndTime(endTime);
			ServiceFactory.getMeetingDetailService().modifyGeneralMeetingDetail(vMeetingDetailVO);
			MeetingTaskOperate.removeMeetingEndTask(vMeetingDetailVO.getMeetingDetailID());
			MeetingTaskOperate.meetingEndTask(vMeetingDetailVO);
			CjfTimerHelper.removeTimerTask(vMeetingDetailVO.getMeetingDetailID());
			CjfTimerHelper.addTimerTask(
					   new Timestamp(vMeetingDetailVO.getMeetingEndTime().getTime()-MeetingAppConfig.meeting_ent_time)
					, new NoticeTask(vMeetingDetailVO.getMeetingDetailID(),"会议结束提醒开始",vMeetingDetailVO));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 设置广播者（级联会议，个人模式）
	 * @param meetingDetailID
	 * @param info 三段数据
	 * @param meetingRoomMID 数值为mcu_participant_id
	 */
	@SuppressWarnings("static-access")
	public void setBroadcaster(String meetingDetailID,String info,String meetingRoomMID){
//		meetingDetailID = "8a8183853b50af15013b50bf1ff10004";
//		info = "销售总部__72__10.1.1.1";
//		meetingRoomMID = "1";
		String screenModel = "1";
		String[] forceIdArray = new String[]{"Auto"};
		String layoutType = "personal";
		
		setVideo(meetingDetailID, info);//设置某会场为主会场（会议属性设置某会场）
		personalModeOperation(screenModel, meetingDetailID, info, meetingRoomMID, forceIdArray, layoutType);
		
		String[] infos = info.split("__");
		String mcuIp = infos[2];
		System.out.println("=======MCU的IP======"+mcuIp);
		
		ArrayList<EquipmentMcuVO> mcuVOs = new ArrayList<EquipmentMcuVO>(); 
		
		try {
			EquipmentVO eqVO = new EquipmentVO();
			eqVO.setIp(mcuIp);
			eqVO = ServiceFactory.getEquipmentService().query(eqVO, null).get(0);
			mcuVOs = ServiceFactory.getEquipmentMcuService().queryByIDs(eqVO.getEquipmentID());
			if(mcuVOs.size()>0 && mcuVOs.size()<2){
				EquipmentMcuVO mcuVO = mcuVOs.get(0);
				String commandIP = mcuVO.getCommandIP();
				
				List<ZZOMainStatusVO> meetingRoomsInConf = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
				
				if(meetingRoomsInConf!=null){
					for (ZZOMainStatusVO zzoMainStatusVO : meetingRoomsInConf) {
						if(zzoMainStatusVO.getMcu_participant_ip().equals(commandIP)){
							
							//组装数据，级联点Info
							String infoSecondaryMcu = 
								zzoMainStatusVO.getMcu_participant_name()+"__"+zzoMainStatusVO.getMcuMeetingID()+"__"+zzoMainStatusVO.getMcuIp();
							
							//会议属性设置为级联点，同时将级联点设置为个人模式
							setSpeaker(meetingDetailID, infoSecondaryMcu);
							personalModeOperation(screenModel, meetingDetailID, infoSecondaryMcu, zzoMainStatusVO.getMcu_participant_id(), forceIdArray, layoutType);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 声音操作
	 * @param meetingDetailID
	 * @param ptsIpVmcuIps
	 * @param isMuted
	 * @return Map<String, String>
	 */
	public Map<String, String> muteParticipants(String meetingDetailID, String ptsIpVmcuIps, boolean isMuted){
		return ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(meetingDetailID, ptsIpVmcuIps, isMuted);
	}
	
	/**
	 * 设为演讲者
	 * @param meetingDetailID
	 * @param ips
	 * @return String
	 */
	public String setLecturer(String meetingDetailID, String ip){
		ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
		return ZZOMcuFactory.getInstance().getMcuControlHelper().setLecturer(meetingDetailID, ip, null);
	}
	
	/**
	 * 取消演讲者
	 * @param confId
	 * @param ips
	 * @return String
	 */
	public String cancelPresident(String meetingDetailID, String ip){
		ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
		System.out.println(ip);
		//wang__5052__10.1.6.30
		
		String returnInfo = ZZOMcuFactory.getInstance().getMcuControlHelper().setNoneLecturer(meetingDetailID, null);
		
		//从系统缓存内取出当前会议下的所有终端的列表roomlist
		List<ZZOMainStatusVO> roomlist = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
		
		//将终端列表遍历，找到取消演讲者的终端对象，更新IsLecturer属性
		String[] strs = ip.split("__");
		if(roomlist!=null && roomlist.size()>0){
			for(ZZOMainStatusVO vo:roomlist){
				if(vo.getMcuIp().equals(strs[2]) && vo.getMcu_participant_name().equals(strs[0])){
					System.out.println("==========================="+vo.getMcu_participant_ip());
//					vo.setIsLecturer(MCUConfig.IS_LECTURER);
					vo.setIsLecturer(Integer.MIN_VALUE);
				}
			}
		}
		
		return returnInfo;
	}
	
	/**
	 * 设为发言者
	 * @param meetingDetailID
	 * @param ip
	 * @return String
	 */
	public String setSpeaker(String meetingDetailID, String ip){
		ZZOMcuFactory.getInstance().getMcuControlHelper().stopPolling(meetingDetailID);
		ZZOMcuFactory.getInstance().getMcuControlHelper().setSpeaker(meetingDetailID, ip);
		return "";
	}
	
	/**
	 * 视频屏蔽
	 * @param meetingDetailID
	 * @param ptsIpVmcuIps
	 * @param isDialed
	 * @return
	 */
	public Map<String, String> suspendParticipants(String meetingDetailID, String ip, boolean isDialed){
		return ZZOMcuFactory.getInstance().getMcuControlHelper().suspendParticipants(meetingDetailID, ip, isDialed);
	}
	
	/**
	 * 呼叫--挂断
	 * @param meetingDetailID
	 * @param ptsIpVmcuIps
	 * @param isDialed
	 * @return
	 */
	public Map<String, String> dialParticipants(String meetingDetailID, String ip, boolean isDialed){
		return ZZOMcuFactory.getInstance().getMcuControlHelper().dialParticipants(meetingDetailID, ip, isDialed);
	}
	
	/**
	 * 闭音操作
	 * @param meetingDetailID
	 * @param ip
	 * @param isDialed
	 * @return
	 */
	public Map<String, String> blockParticipants(String meetingDetailID, String ip, boolean isDialed){
		return ZZOMcuFactory.getInstance().getMcuControlHelper().blockParticipants(meetingDetailID, ip, isDialed);
	}
	
	
	/**
	 * 双流操作
	 * @param meetingDetailID
	 * @param ip
	 * @param isDialed
	 * @return
	 */
	public Map<String, String> changeContentTokenOwner(String meetingDetailID, String ip, boolean isDialed){
		return ZZOMcuFactory.getInstance().getMcuControlHelper().changeContentTokenOwner(meetingDetailID, ip, isDialed);
	}
	
	
	/**
	 * 个人模式操作，可满足设置个人模式、点名的操作
	 * @param screenModel 模式（几乘几）
	 * @param meetingDetailID
	 * @param info
	 * @param meetingRoomMID
	 * @param forceIdArray
	 */
	@SuppressWarnings("static-access")
	public void personalModeOperation(String screenModel, String meetingDetailID, String info, 
			String meetingRoomMID, String[] forceIdArray, String layoutType){
		//解析会场信息
		String[] roomInfo = info.split("__");
		
		ZZOMediaSourcesVO zzoMediaSourcesVO= new ZZOMediaSourcesVO();
		List<ZZOMediaSourcesVO> mediaList=new ArrayList<ZZOMediaSourcesVO>();	
		zzoMediaSourcesVO.setLayout(screenModel);
		zzoMediaSourcesVO.setLayoutType(layoutType);
		zzoMediaSourcesVO.setMcuIP(roomInfo[2]);
		zzoMediaSourcesVO.setMcuMeetingID(roomInfo[1]);
		zzoMediaSourcesVO.setMcuParticipantId(meetingRoomMID);
		zzoMediaSourcesVO.setForceIdArray(forceIdArray);
		mediaList.add(zzoMediaSourcesVO);
		
		ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList);
	}
	
	/**
	 * 选看会场
	 * @param meetingDetailID
	 * @param meetingInfo
	 */
	public void setVideo(String meetingDetailID, String meetingInfo){
		ZZOMcuFactory.getInstance().getMcuControlHelper().setVideo(meetingDetailID, meetingInfo);
	}
	
	/**
	 * 等待时间
	 * @param timeSpace
	 */
	public void waitTime(String timeSpace){
		try {
			Thread.sleep(Long.valueOf(timeSpace)*1000);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 开始轮询
	 * @param meetingDetailID
	 * @param meetingRoomIDs
	 * @param intervalTime
	 */
	public void startPolling(String meetingDetailID,String meetingRoomIDs,String intervalTime){
		String[] meetingRoomInfos = meetingRoomIDs.split("-");
		
		isRolling = true;
		
		while(isRolling){
			
			setVideo(meetingDetailID, meetingRoomInfos[rollNum]);
			waitTime(intervalTime);
			
			rollNum++;
			if (rollNum == meetingRoomInfos.length) {
				rollNum = 0;
			}
		}
		//ZZOMcuFactory.getInstance().getMcuControlHelper().pollParticipants(meetingDetailID, meetingRoomIDs, interval);
	}
	
	/**
	 * 结束轮询
	 */
	public void stopPolling(){
		isRolling = false;
	}
	
	/**
	 * 设置个人模式
	 * @param infos 包括pId,meetingID,flagId,mcuIp,pName
	 * @param monitor 包括pName,meetingID,mcuIp,pId
	 * @param mode 包括personal,conference
	 */
	public void setPersonal(String[] infos,String monitor,String mode){
		String[] forceIdArray = new String[infos.length];
		String[] monitorInfo = monitor.split("__");
		for(int i=0;i<infos.length;i++){
			if(monitorInfo[1].equals(infos[i].split("_")[1])){    //mcuMeetingId是否相同 相同则为同一会议中
				forceIdArray[i]=infos[i].split("_")[0];			//将该会场id存入forceIdArray
			//不在同一会议中 对其级联会中的级联点进行操作
			}else{
				List<ZZOMainStatusVO> confRoomList = new ArrayList<ZZOMainStatusVO>();
				//取得被看会场的会议中会场列表confRoomList
				confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(infos[i].split("_")[2], infos[i].split("_")[3], infos[i].split("_")[1]);
				for(int j=0;j<confRoomList.size();j++){
					//找出该会议中的级联点
					if(!confRoomList.get(j).getCascadeRole().equals("none")){
						String[] forceIdArray1 = new String[1];
						forceIdArray1[0] = infos[i].split("_")[0];
						ZZOMediaSourcesVO zzoMediaSourcesVO1= new ZZOMediaSourcesVO();
						List<ZZOMediaSourcesVO> mediaList1=new ArrayList<ZZOMediaSourcesVO>();	
						zzoMediaSourcesVO1.setLayout("1x1");
						zzoMediaSourcesVO1.setLayoutType("personal");
						zzoMediaSourcesVO1.setMcuIP(confRoomList.get(j).getMcuIp());
						zzoMediaSourcesVO1.setMcuMeetingID(confRoomList.get(j).getMcuMeetingID());
						zzoMediaSourcesVO1.setMcuParticipantId(confRoomList.get(j).getMcu_participant_id());
						zzoMediaSourcesVO1.setForceIdArray(forceIdArray1);
						mediaList1.add(zzoMediaSourcesVO1);
						
						ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
						
						//取得会议列表 confList
						List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(infos[i].split("_")[2]);
						for(int m=0;m<confList.size();m++){
							//取得级联点所属会议
							if((confList.get(m).getConfName()+confList.get(m).getMcuIP()).equals(confRoomList.get(j).getMeetingName()+confRoomList.get(j).getMcuIp())){
								List<ZZOMainStatusVO> confRoomList1 = new ArrayList<ZZOMainStatusVO>();
								//取得主会下会场
								confRoomList1 = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(infos[i].split("_")[2], monitorInfo[2], monitorInfo[1]);
								for(int n=0;n<confRoomList1.size();n++){
									if(confRoomList1.get(n).getAliasName()!=null&&((confRoomList1.get(n).getAliasName()+confRoomList1.get(n).getMcu_participant_ip()).equals(confList.get(m).getE164()+confList.get(m).getMcuCommandIP()))){
										//将主会中级联点存入forceIdArray
										forceIdArray[i]=confRoomList1.get(n).getMcu_participant_id();
									}
								}
							}
							
						}
					}
				}
			}
		}
		String layoutType = MCUConfig.LAYOUT_MODE_1X1;
		ZZOMediaSourcesVO zzoMediaSourcesVO= new ZZOMediaSourcesVO();
		List<ZZOMediaSourcesVO> mediaList=new ArrayList<ZZOMediaSourcesVO>();	
		
		if(infos.length==1){
			layoutType = MCUConfig.LAYOUT_MODE_1X1;
		}else if(infos.length==2){
			layoutType = MCUConfig.LAYOUT_MODE_1X2;
		}else if(infos.length==4){
			layoutType = MCUConfig.LAYOUT_MODE_2X2;
		}
		zzoMediaSourcesVO.setLayout(layoutType);
		zzoMediaSourcesVO.setLayoutType(mode);
		zzoMediaSourcesVO.setMcuIP(monitorInfo[2]);
		zzoMediaSourcesVO.setMcuMeetingID(monitorInfo[1]);
		zzoMediaSourcesVO.setMcuParticipantId(monitorInfo[3]);
		zzoMediaSourcesVO.setForceIdArray(forceIdArray);
		mediaList.add(zzoMediaSourcesVO);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList);
	}

	
	/**
	 * 设置个人模式
	 * @param infos 包括pId,meetingID,flagId,mcuIp,pName
	 * @param monitor 包括pName,meetingID,mcuIp,pId
	 * @param mode 包括personal,conference
	 */
	public void callPollDetail(String[] infos,String monitor,String mode){
		String[] forceIdArray = new String[infos.length];
		String[] monitorInfo = monitor.split("__");
		for(int i=0;i<infos.length;i++){
			if(monitorInfo[1].equals(infos[i].split("_")[1])){    //mcuMeetingId是否相同 相同则为同一会议中
				forceIdArray[i]=infos[i].split("_")[0];			//将该会场id存入forceIdArray
			//不在同一会议中 对其级联会中的级联点进行操作
			}else{
				List<ZZOMainStatusVO> confRoomList = new ArrayList<ZZOMainStatusVO>();
				//取得被看会场的会议中会场列表confRoomList
				confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(infos[i].split("_")[2], infos[i].split("_")[3], infos[i].split("_")[1]);
				for(int j=0;j<confRoomList.size();j++){
					//找出该会议中的级联点
					if(!confRoomList.get(j).getCascadeRole().equals("none")){
						String[] forceIdArray1 = new String[1];
						forceIdArray1[0] = infos[i].split("_")[0];
						ZZOMediaSourcesVO zzoMediaSourcesVO1= new ZZOMediaSourcesVO();
						List<ZZOMediaSourcesVO> mediaList1=new ArrayList<ZZOMediaSourcesVO>();	
						zzoMediaSourcesVO1.setLayout("1x1");
						zzoMediaSourcesVO1.setLayoutType("personal");
						zzoMediaSourcesVO1.setMcuIP(confRoomList.get(j).getMcuIp());
						zzoMediaSourcesVO1.setMcuMeetingID(confRoomList.get(j).getMcuMeetingID());
						zzoMediaSourcesVO1.setMcuParticipantId(confRoomList.get(j).getMcu_participant_id());
						zzoMediaSourcesVO1.setForceIdArray(forceIdArray1);
						mediaList1.add(zzoMediaSourcesVO1);
						
						ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList1);
						String name_meetingid_mcuip = confRoomList.get(j).getMcu_participant_name()+"__"+confRoomList.get(j).getMcuMeetingID()+"__"+confRoomList.get(j).getMcuIp();
						ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(infos[i].split("_")[2],name_meetingid_mcuip , false);
						//取得会议列表 confList
						List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(infos[i].split("_")[2]);
						for(int m=0;m<confList.size();m++){
							//取得级联点所属会议
							if((confList.get(m).getConfName()+confList.get(m).getMcuIP()).equals(confRoomList.get(j).getMeetingName()+confRoomList.get(j).getMcuIp())){
								List<ZZOMainStatusVO> confRoomList1 = new ArrayList<ZZOMainStatusVO>();
								//取得主会下会场
								confRoomList1 = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(infos[i].split("_")[2], monitorInfo[2], monitorInfo[1]);
								for(int n=0;n<confRoomList1.size();n++){
									if(confRoomList1.get(n).getAliasName()!=null&&((confRoomList1.get(n).getAliasName()+confRoomList1.get(n).getMcu_participant_ip()).equals(confList.get(m).getE164()+confList.get(m).getMcuCommandIP()))){
										//将主会中级联点存入forceIdArray
										forceIdArray[i]=confRoomList1.get(n).getMcu_participant_id();
										name_meetingid_mcuip = confRoomList1.get(n).getMcu_participant_name()+"__"+confRoomList1.get(n).getMcuMeetingID()+"__"+confRoomList1.get(n).getMcuIp();
										ZZOMcuFactory.getInstance().getMcuControlHelper().muteParticipants(infos[i].split("_")[2],name_meetingid_mcuip , false);
									}
								}
							}
							
						}
					}
				}
			}
		}
		String layoutType = MCUConfig.LAYOUT_MODE_1X1;
		ZZOMediaSourcesVO zzoMediaSourcesVO= new ZZOMediaSourcesVO();
		List<ZZOMediaSourcesVO> mediaList=new ArrayList<ZZOMediaSourcesVO>();	
		
		if(infos.length==1){
			layoutType = MCUConfig.LAYOUT_MODE_1X1;
		}else if(infos.length==2){
			layoutType = MCUConfig.LAYOUT_MODE_1X2;
		}else if(infos.length==4){
			layoutType = MCUConfig.LAYOUT_MODE_2X2;
		}
		zzoMediaSourcesVO.setLayout(layoutType);
		zzoMediaSourcesVO.setLayoutType(mode);
		zzoMediaSourcesVO.setMcuIP(monitorInfo[2]);
		zzoMediaSourcesVO.setMcuMeetingID(monitorInfo[1]);
		zzoMediaSourcesVO.setMcuParticipantId(monitorInfo[3]);
		zzoMediaSourcesVO.setForceIdArray(forceIdArray);
		mediaList.add(zzoMediaSourcesVO);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ZZOMcuFactory.getInstance().getMcuControlHelper().setMediaSources(mediaList);
	}


}
