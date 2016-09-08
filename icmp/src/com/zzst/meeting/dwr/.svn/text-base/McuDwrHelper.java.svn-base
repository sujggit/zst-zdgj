package com.zzst.meeting.dwr;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.ConfAllPts;
import com.zzst.application.mcuUtil.ConfManager;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfProfileVO;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOInterfaceConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMainVO;
import com.zzst.application.mcuVO.ZZOResultVO;
import com.zzst.application.mcuservice.conf.ConfService;
import com.zzst.application.mcuservice.conf.ConfServiceImpl;
import com.zzst.application.mcuservice.mainStatus.MeetingMcuServiceImpl;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcu.operate.rmx2000.DeleteRMX2000Conf;
import com.zzst.application.meeting.mcu.operate.rmx2000.R2000DoConfList;
import com.zzst.application.meeting.mcu.operate.rmx2000.RMX2000Sender;
import com.zzst.application.meeting.mcu.operate.rmx2000.ZZMCULoginRMX2000;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.application.meeting.mcuInterface.IMcuDwrMethodHelp;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;
import com.zzst.model.meeting.templateMeeting.TemplateMeetingVO;
import com.zzst.model.meeting.user.UserVO;

public class McuDwrHelper {
	private String oldMcuIpField = null;
	private String newMcuIpField = null;
	private String oldTemplateId = null;
	public static String MASTER_CONF_BACKUP_NUMBER = "6000";
	/**
	 * backup mcu wangle 2013-8-26
	 * @param meetingDetailID: current meeting Detail id
	 * @param newMcuIp: new mcu ip
	 * @return
	 */
	public boolean backupMcu(String meetingDetailID, String oldMcuIp, String newMcuIp){
		try {
			
			oldMcuIpField = oldMcuIp;
			newMcuIpField = newMcuIp;
			ZZOInterfaceConfVO mainConf = null;
			
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			meetingDetailVO.setMeetingDetailID(meetingDetailID);
			List<MeetingDetailVO> meetingDetailList = ServiceFactory.getMeetingDetailService().queryMeetingDetailList2(meetingDetailVO, null);
			if(meetingDetailList == null || meetingDetailList.size() <= 0){
				return false;
			}
			meetingDetailVO = meetingDetailList.get(0);
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().queryIP(oldMcuIp);
			if(equipList == null || equipList.size() <= 0){
				return false;
			}
			EquipmentVO mcuVO = equipList.get(0);
			TemplateMeetingVO templateMeetingVO = new TemplateMeetingVO();
			templateMeetingVO.setMcuEquipmentId(mcuVO.getEquipmentID());
			templateMeetingVO.setTemplateId(meetingDetailVO.getTemplateID());
			List<TemplateMeetingVO> templateMeetingList = ServiceFactory.getTemplateMeetingService().query(templateMeetingVO, null);
			if(templateMeetingList == null || templateMeetingList.size() <= 0){
				return false;
			}
			List<ZZOInterfaceConfVO> interfaceConfVOList = new ArrayList<ZZOInterfaceConfVO>();
			boolean isMasterMcuBackup = false;
			for(TemplateMeetingVO oldTemplateMeetingVO : templateMeetingList){
				ZZOInterfaceConfVO interfaceConfVO = addMeeting(oldTemplateMeetingVO, newMcuIp, meetingDetailVO);
				if(interfaceConfVO != null){
					interfaceConfVOList.add(interfaceConfVO);
				}
				if(oldTemplateMeetingVO.getIsMain() == 1){
					isMasterMcuBackup = true;
					mainConf = interfaceConfVO;
				}
			}
			List<ZZOResultVO> resultVOList = ZZOMcuFactory.getInstance().createConf(interfaceConfVOList, true);
			if(resultVOList.size()!= 0){//建会失败
				//==================do nothing temporarily======
				
				//==============================================
				return false;
			}else{
				try{
					Thread.sleep(3000);
				}catch(Exception e){
					e.printStackTrace();
				}
				//
				ConfManager confManager = ZZOMcuFactory.getInstance().getConfManager();
				ZZOConfVO confVO = new ZZOConfVO();
				confVO.setConfFlagId(meetingDetailID);
				List<ZZOConfVO> confList = confManager.getConfList(confVO);
				if(!isMasterMcuBackup){
					EquipmentMcuVO oldMcuEquipmentVO = ServiceFactory.getEquipmentMcuService().queryByMCUID(mcuVO.getEquipmentID());
					addCPInMasterConf(mcuVO, oldMcuEquipmentVO.getCommandIP(), newMcuIp, confList, interfaceConfVOList);
				}else{
					//set broadcaster
					ZZOConfVO masterConfVO = null;
					for(ZZOConfVO zzconf : confList){
						if(zzconf.getMcuIP().equals(newMcuIp) && zzconf.getIsMasterConf()==MCUConfig.IS_MASTER_CONF){
							masterConfVO = zzconf;
							List<ZZOMainStatusVO> equipmentList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(zzconf.getConfFlagId(), zzconf.getMcuIP(), zzconf.getGuid());
							for(ZZOMainStatusVO equipment : equipmentList){
								if(equipment.getMcu_participant_name().equals(mainConf.getBroadcaster())){
									//ZZOConfVO newConfVO = new ZZOConfVO();
									zzconf.setLayoutConfigGuid(equipment.getMcu_participant_id());
									zzconf.setLayoutMode(MCUConfig.LAYOUT_MODE_1X1);
									IMcuDwrMethodHelp imcu =	ZZOMcuFactory.createMethodHelp(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
									imcu.setVideo(zzconf);
								}
								if(equipment.getMcu_participant_name().equals(mainConf.getLecturer())){
									StringBuffer str = new StringBuffer();
									str.append(equipment.getMcu_participant_name());
									str.append("__");
									str.append(zzconf.getGuid());
									str.append("__");
									str.append(zzconf.getMcuIP());
									ZZOMcuFactory.getInstance().getMcuControlHelper().setLecturer(zzconf.getConfFlagId(), str.toString(), zzconf);
								}
							}
							break;
						}		
					}
					IMcuDwrMethodHelp mcuDwrMethodHelp = null;
					List<ZZOMainStatusVO> meetingMcuVOList = null;
					for(ZZOConfVO zzconf : confList){
						if(!zzconf.getMcuIP().equals(newMcuIp) && zzconf.getIsMasterConf()!=MCUConfig.IS_MASTER_CONF){
							ZZOMainStatusVO meetingMcuVO = new ZZOMainStatusVO();
							meetingMcuVO.setConfFlagId(zzconf.getConfFlagId());
							meetingMcuVO.setMcu_participant_ip(masterConfVO.getMcuCommandIP());
							meetingMcuVO.setMcuMeetingID(zzconf.getGuid());
							meetingMcuVO.setMcuIp(zzconf.getMcuIP());
							meetingMcuVOList = ConfAllPts.getMeetingMcuList(meetingMcuVO);
							if(meetingMcuVOList == null || meetingMcuVOList.size() <= 0){
								continue;
							}
						
							zzconf.setLayoutMode(MCUConfig.LAYOUT_MODE_1X1);
							zzconf.setLayoutConfigGuid(meetingMcuVOList.get(0).getMcu_participant_id());
							mcuDwrMethodHelp = ZZOMcuFactory.createMethodHelp(zzconf.getMcuType());
							mcuDwrMethodHelp.setVideo(zzconf);
						}
					}
				}
				
				//delete old conference.
				for(ZZOConfVO tempConfVO : confList){
					if(tempConfVO.getMcuIP().equals(oldMcuIp)){
						confVO = tempConfVO;
						break;
					}
				}
				String message = deleteConf(confVO);
				if(message == null || message.length() <= 0){
					//1.handle useless old conference and participant information when mcu is disconnnected.
					List<ZZOConfVO> delList = new ArrayList<ZZOConfVO>();
					for(ZZOConfVO tempConfVO : confList){
						if(tempConfVO.getMcuIP().equals(oldMcuIp)){
							delList.add(tempConfVO);
						}
					}
					if(delList != null && delList.size() > 0){
						ZZOMainStatusVO meetingMcuVOTemp = null;
						List<ZZOMainStatusVO> oldMeetingMcuVoList = null;
						List<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
						for(ZZOConfVO tempConfVO : delList){
							meetingMcuVOTemp = new ZZOMainStatusVO();
							meetingMcuVOTemp.setConfFlagId(tempConfVO.getConfFlagId());
							meetingMcuVOTemp.setMcuIp(tempConfVO.getMcuIP());
							meetingMcuVOTemp.setMcuMeetingID(tempConfVO.getGuid());
							oldMeetingMcuVoList = ConfAllPts.getMeetingMcuList(meetingMcuVOTemp);
							if(confRoomVector != null && oldMeetingMcuVoList != null){
								confRoomVector.removeAll(oldMeetingMcuVoList);
							}
							new MeetingMcuServiceImpl().delMeetingMcuByMcuMeetingId(meetingMcuVOTemp, null);
						}
						confList.removeAll(delList);
					}
				}
				//2.handle conference relationship.
				ZZOConfVO masterConfVO = null;
				for(ZZOConfVO tempConfVO : confList){
					if(tempConfVO.getIsMasterConf() != null &&  tempConfVO.getIsMasterConf().intValue() == 1){
						masterConfVO = tempConfVO;
						break;
					}
				}
				if(masterConfVO != null){
					for(ZZOConfVO tempConfVO : confList){
						if(!tempConfVO.getConfID().equals(masterConfVO.getConfID())){
							tempConfVO.setParentIpAndConfNum(masterConfVO.getMcuIP() + masterConfVO.getE164());
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	//add a small conference into a big conference.
	public ZZOInterfaceConfVO addMeeting(TemplateMeetingVO templateMeetingVO, String newMcuIp, MeetingDetailVO meetingDetailVO){
		ZZOInterfaceConfVO interfaceConfVO = null;
		try {
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().queryIP(newMcuIp);
			if(equipList == null || equipList.size() <= 0){
				return null;
			}
			EquipmentVO mcuVO = equipList.get(0);
			EquipmentMcuVO equipmentMcuVO = ServiceFactory.getEquipmentMcuService().queryByMCUID(mcuVO.getEquipmentID());
			
			
			TemplateEquipmentVO equipmentGroupVO = new TemplateEquipmentVO();
			equipmentGroupVO.setGroupId(templateMeetingVO.getGroupId());
			ArrayList<TemplateEquipmentVO> equipmentGroupList = ServiceFactory.getTemplateEquipmentService().query(equipmentGroupVO, null);
			interfaceConfVO = assembleConfVOByEquipGroup(meetingDetailVO, templateMeetingVO, mcuVO, equipmentMcuVO, equipmentGroupList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return interfaceConfVO;
	}
	
	public ZZOInterfaceConfVO assembleConfVOByEquipGroup(MeetingDetailVO meetingDetailVO, TemplateMeetingVO templateMeetingVO, EquipmentVO mcuVO, EquipmentMcuVO equipmentMcuVO, List<TemplateEquipmentVO> equipmentGroupList) throws Exception{
		ZZOInterfaceConfVO interfaceConfVO = new ZZOInterfaceConfVO();
		if(templateMeetingVO.getIsMain() == 1){
			interfaceConfVO.setMasterConf(true);
		}else{
			try{
				ConfManager confManager = ZZOMcuFactory.getInstance().getConfManager();
				ZZOConfVO confVO = new ZZOConfVO();
				confVO.setConfFlagId(meetingDetailVO.getMeetingDetailID());
				List<ZZOConfVO> confList = confManager.getConfList(confVO);
				for(ZZOConfVO tempConfVO : confList){
					if(tempConfVO.getIsMasterConf() != null &&  tempConfVO.getIsMasterConf().intValue() == 1){
						interfaceConfVO.setParentIpAndConfNum(tempConfVO.getMcuIP() + tempConfVO.getE164());
						break;
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		interfaceConfVO.setOrderNumber(templateMeetingVO.getRank());
		interfaceConfVO.setConfFlagId(meetingDetailVO.getMeetingDetailID());
		interfaceConfVO.setConfName(templateMeetingVO.getMeetingName());
		interfaceConfVO.setDuration(5 * 24 * 60);
		interfaceConfVO.setConfNumber(templateMeetingVO.getMeetingNumber());
		if(templateMeetingVO.getIsMain() == 1){
			interfaceConfVO.setConfNumber(MASTER_CONF_BACKUP_NUMBER);
		}
		ZZOMainVO mcuMainVO = new ZZOMainVO();
		mcuMainVO.setEquipmentName(mcuVO.getEquipmentNO());
		mcuMainVO.setEquipmentID(mcuVO.getEquipmentID());
		//mcuMainVO.setEquipmentName(mcuVO.getEquipmentName());
		mcuMainVO.setAdminLoginName(equipmentMcuVO.getLoginName());
		mcuMainVO.setAdminLoginPassword(equipmentMcuVO.getLoginPassword());
		mcuMainVO.setEquipmentIP(mcuVO.getIp());
		mcuMainVO.setCommandIP(equipmentMcuVO.getCommandIP());
		//mcuMainVO.setModelID(MCUConfig.RMX2000_EQUIPMENT_MODEL_ID);
		mcuMainVO.setModelID(mcuVO.getEquipmentModel());
		//MCU 4000 and MCU 2000 use the same model id
        if(mcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
        	mcuMainVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
        }
		
		if(templateMeetingVO.getIsMain() != 1){
			mcuMainVO.setUplinkEquipmentID("x");
		}else{
			mcuMainVO.setUplinkEquipmentID("");
		}
		
		//2. get conference profile guid in every mcu.
		String tempMcuIp=oldMcuIpField+","+newMcuIpField;
		String tempMcuTemplateIDs=templateMeetingVO.getMcuTemplateID();
		McuCascadeModelVO tempmmv=new McuCascadeModelVO();
		tempmmv.setStatus(McuCascademodelEnum.STATUS_BACK);
		tempmmv.setMcuIp(tempMcuIp);
		tempmmv.setModelID(tempMcuTemplateIDs+",%");
		ArrayList<McuCascadeModelVO> mmList=ServiceFactory.getMcuCascadeModelService().query(tempmmv, null);
		if(mmList == null || mmList.size() <= 0 || mmList.get(0).getModelID().equals("")){
			return null;
		}
		tempMcuTemplateIDs = mmList.get(0).getModelID();
		if(tempMcuTemplateIDs.split(",").length < 2){
			return null;
		}
		ZZOConfProfileVO confProfileVO = new ZZOConfProfileVO();
		confProfileVO.setGuid(tempMcuTemplateIDs.split(",")[1]);
		mcuMainVO.setZzoConfProfileVO(confProfileVO);
		
		//3. add end points
		List<ZZOMainVO> ptsList = new ArrayList<ZZOMainVO>();
		ZZOMainVO ptsVO = null;
		if(templateMeetingVO.getIsMain() != 1){
			for(TemplateEquipmentVO equipmentGroupVO : equipmentGroupList){
				//set broadcaster and lecturer
				if( equipmentGroupVO.getIsMain() != Integer.MIN_VALUE && equipmentGroupVO.getIsMain() == 1 ){//广播者
	        		interfaceConfVO.setBroadcaster(equipmentGroupVO.getEquipmentName());
	        		//videoconferenceVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
	        	}
	        	if( equipmentGroupVO.getIsMain() != Integer.MIN_VALUE && equipmentGroupVO.getIsMain() == 2 ){//演讲者
	        		interfaceConfVO.setLecturer(equipmentGroupVO.getEquipmentName());
	        		//videoconferenceVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
	        	}
	        	if( equipmentGroupVO.getIsMain() != Integer.MIN_VALUE && equipmentGroupVO.getIsMain() == 3 ){//广播+演讲者
	        		interfaceConfVO.setBroadcaster(equipmentGroupVO.getEquipmentName());
	        		interfaceConfVO.setLecturer(equipmentGroupVO.getEquipmentName());
	        		//videoconferenceVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
	        	}
				
				//add end point
				ptsVO = new ZZOMainVO();
				ptsVO.setEquipmentName(equipmentGroupVO.getEquipmentName());
				ptsVO.setEquipmentIP(equipmentGroupVO.getEquipmentIp());
				ptsVO.setAliasName(equipmentGroupVO.getAliasName());
				ptsVO.setAliasType(equipmentGroupVO.getAliasType());
				if(equipmentGroupVO.getCallDirection() != null && equipmentGroupVO.getCallDirection().equals("0")){
					ptsVO.setCallDirection(MCUConfig.MGC_CASCADE_DIAL_DIRECTION_DIAL_IN);
				}else{
					ptsVO.setCallDirection(MCUConfig.MGC_CASCADE_DIAL_DIRECTION_DIAL_OUT);
				}
				ptsVO.setLineRate(equipmentGroupVO.getLineRate());
				ptsVO.setMaxResolution(equipmentGroupVO.getMaxResolution());
				ptsVO.setVideoProtocol(equipmentGroupVO.getVideoProtocol());
				ptsVO.setCascadeRole(equipmentGroupVO.getCascadeRole());
				ptsVO.setServiceName(equipmentGroupVO.getDescription());
				
				ptsList.add(ptsVO);
			}
		}else{
			ZZOMainStatusVO tempMainStatusVO = new ZZOMainStatusVO();
			tempMainStatusVO.setConfFlagId(meetingDetailVO.getMeetingDetailID());
			tempMainStatusVO.setMcuIp(oldMcuIpField);
			List<ZZOMainStatusVO> mainStatusVOList = new MeetingMcuServiceImpl().getMeetingMcuList(tempMainStatusVO, null);
			if(mainStatusVOList != null && mainStatusVOList.size() > 0){
				for(ZZOMainStatusVO mStatusVO : mainStatusVOList){
					//set broadcaster and lecturer
					if(mStatusVO.getIsSpeaker() != null && mStatusVO.getIsSpeaker().intValue() == 1){//广播者
		        		interfaceConfVO.setBroadcaster(mStatusVO.getMcu_participant_name());
		        	}
		        	if(mStatusVO.getIsLecturer() != null && mStatusVO.getIsLecturer().intValue() == 1){//演讲者
		        		interfaceConfVO.setLecturer(mStatusVO.getMcu_participant_name());
		        	}
		        	
					//add end point
					ptsVO = new ZZOMainVO();
					ptsVO.setEquipmentName(mStatusVO.getMcu_participant_name());
					ptsVO.setEquipmentIP(mStatusVO.getMcu_participant_ip());
					ptsVO.setAliasName(mStatusVO.getAliasName());
					ptsVO.setAliasType(mStatusVO.getAliasType());
					ptsVO.setCallDirection(mStatusVO.getCasDialDirection());
					//ptsVO.setLineRate(mStatusVO.getCallSpeed());
					ptsVO.setMaxResolution(mStatusVO.getMaxResolution());
					ptsVO.setVideoProtocol(mStatusVO.getVideoProtocol());
					ptsVO.setCascadeRole(mStatusVO.getCascadeRole());
					
					ptsList.add(ptsVO);
				}
			}
		}
		mcuMainVO.setSubMainVOList(ptsList);
		List<ZZOMainVO> mcuList = new ArrayList<ZZOMainVO>();
		mcuList.add(mcuMainVO);
		interfaceConfVO.setMainVOList(mcuList);
		
		return interfaceConfVO;
	}
	
	private void addCPInMasterConf(EquipmentVO oldmcuVO, String oldMcuCommandIp, String newMcuIp, List<ZZOConfVO> confList, List<ZZOInterfaceConfVO> interfaceConfVOList){
		ZZOConfVO masterConfVO = null;
		List<ZZOConfVO> newConfList = new ArrayList<ZZOConfVO>();
		List<EquipmentVO> equipList;
		try {
			equipList = ServiceFactory.getEquipmentService().queryIP(newMcuIp);
		
		if(equipList == null || equipList.size() <= 0){
			return;
		}
		EquipmentVO newMcuVO = equipList.get(0);
		EquipmentMcuVO newEquipmentMcuVO = ServiceFactory.getEquipmentMcuService().queryByMCUID(newMcuVO.getEquipmentID());
		for(ZZOConfVO tempConfVO : confList){
			if(tempConfVO.getMcuIP().equals(newMcuIp)){
				newConfList.add(tempConfVO);
			}
		}
		
		for(ZZOConfVO tempConfVO : confList){
			if(tempConfVO.getIsMasterConf() != null &&  tempConfVO.getIsMasterConf().intValue() == 1){
				masterConfVO = tempConfVO;
				ZZOMainStatusVO meetingMcuVOTemp = new ZZOMainStatusVO();
				meetingMcuVOTemp.setConfFlagId(tempConfVO.getConfFlagId());
				meetingMcuVOTemp.setMcuIp(tempConfVO.getMcuIP());
				meetingMcuVOTemp.setMcuMeetingID(tempConfVO.getGuid());
				List<ZZOMainStatusVO> oldMeetingMcuVoList = ConfAllPts.getMeetingMcuList(meetingMcuVOTemp);
				if(oldMeetingMcuVoList != null && oldMeetingMcuVoList.size() > 0){
					McuDwrMethod mcuDwrMethod = new McuDwrMethod();
					ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
					List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
					ZZOMainVO innerMcuVO = new ZZOMainVO();
		            innerMcuVO.setEquipmentIP(oldmcuVO.getIp());
		            innerMcuVO.setModelID(oldmcuVO.getEquipmentModel());
		            //MCU 4000 and MCU 2000 use the same model id
		            if(oldmcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
		            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
		            }
					for(ZZOMainStatusVO oldMeetingMcuVO : oldMeetingMcuVoList){
						if(oldMeetingMcuVO.getMcu_participant_ip().equals(oldMcuCommandIp)){
							 if(newConfList.size() > 0){
								 for(ZZOConfVO newTempConf : newConfList){
									 ZZOMainVO innerTerminalVO = new ZZOMainVO();
					            	 innerTerminalVO.setEquipmentName(oldMeetingMcuVO.getMcu_participant_name() + masterConfVO.getMcuIP());
					            	 innerTerminalVO.setEquipmentIP(newEquipmentMcuVO.getCommandIP());
					            	 innerTerminalVO.setCallDirection("");
					            	 innerTerminalVO.setAliasType(MCUConfig.ALIAS_TYPE_E164);
					            	 innerTerminalVO.setCascadeRole(MCUConfig.RMX2000_CASCADE_MASTER);
				            	
				            		 innerTerminalVO.setAliasName(newConfList.get(0).getE164());
				            	 
				            		 innerTermList.add(innerTerminalVO);
								 }
							 }
							 break;
					    }
					}
					innerMcuVO.setSubMainVOList(innerTermList);
					innerMcuVOList.add(innerMcuVO);
					ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(masterConfVO.getConfFlagId(), masterConfVO.getConfID(), innerMcuVOList);
				}
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * delete conference 
	 * @param confVO
	 * @return
	 */
	public  String deleteConf(ZZOConfVO confVO){
		String message = "";
		if(confVO == null){
			return message;
		}
		String account = confVO.getMcuAccount();
		if(OperateUtil.isAvailable(account)){
			String[] namePasswd = account.split(MCUConfig.SUBTRACTION_DELIMITER + MCUConfig.SUBTRACTION_DELIMITER);
			if(namePasswd.length > 1){
				ZZMCULoginRMX2000 loginRmx2000 = ZZMCULoginRMX2000.getInstance(confVO.getMcuIP(), MCUConfig.MCU_RMX2000_PORT, namePasswd[0], namePasswd[1]);
				if(loginRmx2000 == null){
					return message;
				}
				String mcuToken = loginRmx2000.getMcuToken();
				DeleteRMX2000Conf deleteRMX2000Conf = new DeleteRMX2000Conf();
				String deleteRMX2000ConfMessage = deleteRMX2000Conf.consDeleteConf(mcuToken, confVO.getGuid());
				
				message = RMX2000Sender.sendPost("http://" + confVO.getMcuIP(), deleteRMX2000ConfMessage);
				//System.out.println(message);
			}
		}
		return message;
	}
	/**
	 * 预检检测mcu是否在线
	 * @param mDetailId
	 * @param str
	 * @return
	 */
	public  String getMcuOnLine(String mDetailId,String str){
		String info = str;
		String[] infoA = info.split("_");
		if(infoA.length>1){
		List<ZZOMainStatusVO> confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(mDetailId, infoA[3], infoA[1]);
		if(confRoomList!=null){
			for(ZZOMainStatusVO zVO : confRoomList){
				if((zVO.getMcu_participant_id()).equals(infoA[0])){
					String zip=zVO.getMcu_participant_ip();
					if(zVO.getVideo()==1||zVO.getConnectStatus()!=1||zip==null||zip.equals("")){
						return "outLine";
						}else{
						return zip;
						}
					}
				}
			}
		}
		
		
		return "outLine";
	}
	/**
	 * synchronize conferences from all of  mcu
	 * 2014-5-22 wangle
	 */
	public void synConfsFromMcu(){
		List<ZZOConfVO> oldConfList = new ArrayList<ZZOConfVO>();
		List<ZZOConfVO>  confList;
		List<ZZOConfVO> atempConfList ;
		try{
			String mcuIp, mcuName, mcuPasswd;
			EquipmentVO tempMcuVO = new EquipmentVO();
			
			  ///////////////会议室分级分权 @author:zhangjy///////////////////////////
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO suv = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					tempMcuVO.setLevel(true);
					tempMcuVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			
			List<EquipmentVO> equipList = ServiceFactory.getEquipmentService().queryMCUID(tempMcuVO);
			if(equipList != null && equipList.size() > 0){
				for(EquipmentVO mcuVO : equipList){
					mcuIp = mcuVO.getIp();
					
					EquipmentMcuVO equipmentMcuVO = ServiceFactory.getEquipmentMcuService().queryByMCUID(mcuVO.getEquipmentID());
					mcuName = equipmentMcuVO.getLoginName();
					mcuPasswd = equipmentMcuVO.getLoginPassword();
					ZZMCULoginRMX2000 loginRMX2000 = null;
					try{
						loginRMX2000 = ZZMCULoginRMX2000.getInstance(mcuVO.getIp(), MCUConfig.MCU_RMX2000_PORT, equipmentMcuVO.getLoginName(), equipmentMcuVO.getLoginPassword());
						if(loginRMX2000 == null || !OperateUtil.isAvailable(loginRMX2000.getMcuToken())){
							continue;
						}
						R2000DoConfList r2000DoConfList = new R2000DoConfList();
						
						String message = r2000DoConfList.getConfListCommand(loginRMX2000.getMcuToken());
						message = RMX2000Sender.sendPost("http://" + mcuVO.getIp(), message);
						confList = r2000DoConfList.assembleConfList(message);
						if(confList == null || confList.size() <= 0){
							continue;
						}
					}catch(Exception e){
						e.printStackTrace();
						continue;
					}
					//---------------------------------------------begin-----------------------------------------
					ConfService confService = new ConfServiceImpl();
					ZZOConfVO tempConfVO = new ZZOConfVO();
					tempConfVO.setMcuIP(mcuIp);
					
					oldConfList = confService.getConfList(tempConfVO, null);
					boolean isExisted = false;
					//-----------------------------------------------END---------------------------------------
					for(ZZOConfVO confVO : confList){
						confVO.setMcuType(MCUConfig.RMX2000_EQUIPMENT_MODEL_ID);
						confVO.setMcuIP(mcuIp);
						confVO.setMcuAccount(mcuName + 
								MCUConfig.SUBTRACTION_DELIMITER + MCUConfig.SUBTRACTION_DELIMITER + mcuPasswd);
						
						//----------------------------------------begin-2--------------------------------
						//1.find out new conferences----need to do.
						//note: add conf flag id, we can create a new id
						isExisted = false;
						if(oldConfList != null && oldConfList.size() > 0){
							for(ZZOConfVO oldConfVO : oldConfList){
								if(oldConfVO.getConfName().equals(confVO.getConfName()) && oldConfVO.getGuid().equals(confVO.getGuid())){
									if(confVO.getMcuIP().equals(oldConfVO.getMcuIP())){
										atempConfList = ConfManager.getInstance().getConfList(oldConfVO);
										if(atempConfList != null && atempConfList.size() > 0){
											//内存中存在会议信息，才认为这个会议存在。
											isExisted = true;
										}
										
									}else{
										confVO.setConfFlagId(oldConfVO.getConfFlagId());
									}
								}
							}
						}
						if(isExisted){
							continue;
						}
						oldConfList.add(confVO);
						
						//2.initial conference information
						confVO.setMcuName(mcuVO.getEquipmentNO());
						confVO.setMcuCommandIP(equipmentMcuVO.getCommandIP());
						confVO.setIsMasterConf(MCUConfig.IS_MASTER_CONF);
						if(!OperateUtil.isAvailable(confVO.getConfFlagId())){
							//confVO.setConfFlagId(UtilDAO.getUUid());
							addMeetingDetail(confVO);
							
						}
						//save this conference information in mcu jar at first.
						new ConfAllPts().setInitConfAllPts(confVO); 
						//3.save to db
						try {
							confService.addConf(confVO, null);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//add conference object into memory.
						ConfManager.getInstance().addConf(confVO);
						loginRMX2000.setInterMessageList(confVO.getConfFlagId(), confVO.getGuid(), null);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		/*
		//clear old meetingdetail record.
		if(oldConfList != null && oldConfList.size() > 0){
			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setStatus("" + MeetingDetailEnum.STATUS_ING);
			vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			try {
				List<MeetingDetailVO> meetingDetailList = ServiceFactory.getMeetingDetailService().query(vMeetingDetailVO, null);
				if(meetingDetailList != null && meetingDetailList.size() > 0){
					boolean isExisted =false;
					for(MeetingDetailVO meetingDetailVO : meetingDetailList){
						isExisted = false;
						for(ZZOConfVO confVO : oldConfList){
							if(meetingDetailVO.getMeetingDetailID().equals(confVO.getConfFlagId())){
								isExisted = true;
								break;
							}
						}
						if(!isExisted){
							meetingDetailVO.setStatus("" + MeetingDetailEnum.STATUS_END);
							ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(meetingDetailVO);
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
	}
	
	public void addMeetingDetail(ZZOConfVO confVO){
		MeetingDetailVO detailVO = new MeetingDetailVO();
		detailVO.setMeetingDetailID(confVO.getConfFlagId());
		detailVO.setMeetingName(confVO.getConfName() + " (" + confVO.getMcuName() + ")");
		Calendar c = Calendar.getInstance();
		
		//detailVO.setMeetingStartTime(confVO.getStartTime());
		detailVO.setMeetingStartTime(new Timestamp(c.getTimeInMillis()));
		if(confVO.getEndTime() == null){
			String endTime = "2099-01-01 00:00:00";
			Timestamp meetingEndTime = Timestamp.valueOf(endTime);
			detailVO.setMeetingEndTime(meetingEndTime);
		}else{
			detailVO.setMeetingEndTime(confVO.getEndTime());
		}
		detailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
		detailVO.setStatus("" + MeetingDetailEnum.STATUS_ING);
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session = ctx.getHttpServletRequest().getSession(); 
		UserVO suv = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		detailVO.setCreateUserID(suv.getUserID());
		detailVO.setMeetingDescription("会议控制-同步MCU上会议所得");
		try {
			detailVO = ServiceFactory.getMeetingDetailService().addMeetingDetail(detailVO);
			confVO.setConfFlagId(detailVO.getMeetingDetailID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
