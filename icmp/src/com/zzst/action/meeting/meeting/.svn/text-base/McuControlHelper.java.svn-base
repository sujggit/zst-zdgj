package com.zzst.action.meeting.meeting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.cbf.db.TransactionManager;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.MeetingUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.ConfAllPts;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfProfileVO;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOInterfaceConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMainVO;
import com.zzst.application.mcuVO.ZZOResultVO;
import com.zzst.application.mcuservice.conf.ConfServiceImpl;
import com.zzst.application.mcuservice.mainStatus.MeetingMcuService;
import com.zzst.application.mcuservice.mainStatus.MeetingMcuServiceImpl;
import com.zzst.application.meeting.mcu.operate.Message;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcu.operate.rmx2000.ZZMCU2000ContactHandler;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.service.meeting.equipment.EquipmentMcuService;
import com.zzst.service.meeting.equipment.EquipmentMcuServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentTerminalService;
import com.zzst.service.meeting.equipment.EquipmentTerminalServiceImpl;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;

public class McuControlHelper {
	
	
	/**
	 * 根据MCU接口组织数据，召开会议
	 * @param interfaceConfVO
	 * @return	ZZOResultVO
	 */
	public static ZZOResultVO creatConfInMcu(ZZOInterfaceConfVO interfaceConfVO2,List<ZZOMainVO> mainList){
		ZZOInterfaceConfVO interfaceConfVO = new ZZOInterfaceConfVO();
		
		ZZOMainVO mcuVO = new ZZOMainVO();
		mcuVO.setEquipmentID("1");
		mcuVO.setEquipmentName("石油销售RMX2000C");
		mcuVO.setAdminLoginName("SUPPORT");
		mcuVO.setAdminLoginPassword("SUPPORT");
		mcuVO.setEquipmentIP("110.0.0.1");
		mcuVO.setCommandIP("110.0.0.2");
		mcuVO.setModelID(MCUConfig.RMX2000C_EQUIPMENT_MODEL_ID);
		
		ZZOConfProfileVO confProfileVO = new ZZOConfProfileVO();
		confProfileVO.setGuid("39");
		mcuVO.setZzoConfProfileVO(confProfileVO);
		List<ZZOMainVO> ptsList = new ArrayList<ZZOMainVO>();
		ZZOMainVO ptsVO = new ZZOMainVO();
		ptsVO.setUplinkEquipmentID(mcuVO.getEquipmentID());
		ptsVO.setEquipmentIP("110.32.0.2");
		ptsVO.setEquipmentName("金融中心2");
		ptsList.add(ptsVO);
		
		ptsVO = new ZZOMainVO();
		ptsVO.setUplinkEquipmentID(mcuVO.getEquipmentID());
		ptsVO.setEquipmentIP("110.1.1.102");
		ptsVO.setEquipmentName("北京2");
		ptsList.add(ptsVO);
		
		ptsVO = new ZZOMainVO();//主会里的级联点==============
		ptsVO.setUplinkEquipmentID(mcuVO.getEquipmentID());
		ptsVO.setEquipmentIP("110.1.1.102");
		ptsVO.setEquipmentName("北京2");
//		ptsVO.setCascadeRole(cascadeRole);
		ptsVO.setCommandIP(null);
//		ptsVO.setAliasType(aliasType);
//		ptsVO.setAliasName(aliasName);
		ptsList.add(ptsVO);
		
		mcuVO.setSubMainVOList(ptsList);//mcu1

		ZZOMainVO mcuVO2 = new ZZOMainVO();//2000的
		mcuVO2.setEquipmentID("1");
		mcuVO2.setEquipmentName("石油销售RMX2000C");
		mcuVO2.setAdminLoginName("SUPPORT");
		mcuVO2.setAdminLoginPassword("SUPPORT");
		mcuVO2.setEquipmentIP("110.0.0.1");
		mcuVO2.setCommandIP("110.0.0.2");
		mcuVO2.setModelID(MCUConfig.RMX2000C_EQUIPMENT_MODEL_ID);
		
		confProfileVO = new ZZOConfProfileVO();
		confProfileVO.setGuid("39");
		mcuVO2.setZzoConfProfileVO(confProfileVO);
		
		List<ZZOMainVO> ptsList2 = new ArrayList<ZZOMainVO>();
		ptsVO = new ZZOMainVO();
		ptsVO.setUplinkEquipmentID(mcuVO.getEquipmentID());
		ptsVO.setEquipmentIP("110.32.0.2");
		ptsVO.setEquipmentName("金融中心2");
		ptsList.add(ptsVO);
		mcuVO2.setSubMainVOList(ptsList2);
		
		List<ZZOMainVO> mcuList = new ArrayList<ZZOMainVO>();
		mcuList.add(mcuVO);
		mcuList.add(mcuVO2);
		
		interfaceConfVO.setMainVOList(mcuList);
		ZZOMcuFactory.getInstance().createConf(interfaceConfVO);
		
		return null;
	}
	
	/**
	 * create meeting in mcu immediately
	 * @param vMeetingDetailVO
	 * @author wangle
	 */
	public ZZOResultVO creatConfInMcu(MeetingDetailVO vMeetingDetailVO ){
		String meetingRoomIDs = vMeetingDetailVO.getMeetingRoomNameIDs();
		
		if(!OperateUtil.isAvailable(meetingRoomIDs) || !OperateUtil.isAvailable(vMeetingDetailVO.getConfProfileID())){
			return null;
		}
		
		
		ZZOResultVO resultVO = null;
		Map<String, String> ipProfIdMap = null;
		
		meetingRoomIDs = "'" + meetingRoomIDs.replace(",", "','") + "'";
		try {
			
			//get meeting profile map
			McuCascadeModelVO mcuCascadeModelVO =  this.getCascadeModel(vMeetingDetailVO.getConfProfileID());
			if( mcuCascadeModelVO != null  ){
				ipProfIdMap = this.getProfilesMap(mcuCascadeModelVO);
			}
			
			
			
			ArrayList<EquipmentTerminalVO> equipmentTerminalVOList = new EquipmentTerminalServiceImpl().queryByRoomIDs(meetingRoomIDs);		
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
				MeetingRoomVO mainMeetingRoomVO = new MeetingRoomVO();//主会场
				Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = MeetingUtil.getMCU(buffer.toString());
				Set<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> set = map.entrySet();
		        for (Iterator<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> it = set.iterator(); it.hasNext();) {
		            Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>> entry = (Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>) it.next();
		            EquipmentMcuVO outMcuVO = entry.getKey();
		            List<EquipmentTerminalVO> terminalList = entry.getValue();
		            ZZOMainVO innerMcuVO = new ZZOMainVO();
		            innerMcuVO.setEquipmentID(outMcuVO.getEquipmentID());
		            innerMcuVO.setEquipmentName(outMcuVO.getEquipmentNO());
		            innerMcuVO.setAdminLoginName(outMcuVO.getLoginName());
		            innerMcuVO.setAdminLoginPassword(outMcuVO.getLoginPassword());
		            innerMcuVO.setEquipmentIP(outMcuVO.getIp());
		            innerMcuVO.setCommandIP(outMcuVO.getCommandIP());
		            innerMcuVO.setModelID(outMcuVO.getEquipmentModel());
		            //MCU 4000 and MCU 2000 use the same model id
		            if(outMcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
		            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
		            }
		           
		            //add profiler
		            ZZOConfProfileVO confProfileVO = new ZZOConfProfileVO();
		         
		            confProfileVO.setGuid(ipProfIdMap.get(outMcuVO.getIp()));
		    		if(vMeetingDetailVO.getConfProfileID().length() < 10){
		    			confProfileVO.setGuid(vMeetingDetailVO.getConfProfileID());
		    		}
		            innerMcuVO.setZzoConfProfileVO(confProfileVO);
		            //add terminals
		    		List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
		    		
		    		
		            for(EquipmentTerminalVO outTerminal : terminalList){
		            	 ZZOMainVO innerTerminalVO = new ZZOMainVO();
		            	 if(outTerminal.getMeetingRoomVO() != null){
		            		 if( vMeetingDetailVO.getMeetingRoomID().equalsIgnoreCase(outTerminal.getMeetingRoomVO().getMeetingRoomID())){
		            			 mainMeetingRoomVO = outTerminal.getMeetingRoomVO();
		            		 }
		            		 innerTerminalVO.setEquipmentName(outTerminal.getMeetingRoomVO().getMeetingRoomName());
		            	 }else{
		            		 innerTerminalVO.setEquipmentName(outTerminal.getEquipmentName());
		            		 mainMeetingRoomVO.setMeetingRoomName(outTerminal.getEquipmentName());
		            	 }
		            	 innerTerminalVO.setEquipmentIP(outTerminal.getIp());
		            	 
		            	 //E.164 TODO
		            	 //是否启用小号
		            	 if(outTerminal.getRadioTreaty()!=null && !"".equals(outTerminal.getRadioTreaty()) && "E164".equalsIgnoreCase(outTerminal.getRadioTreaty())){
		            		 innerTerminalVO.setAliasName(outTerminal.getPstn());//别名——电话号码
		            		 innerTerminalVO.setAliasType(outTerminal.getRadioTreaty());
		            		 innerTerminalVO.setEquipmentIP(MeetingAppConfig.E164_IP);
		            	 }
		            	 
		            	 innerTermList.add(innerTerminalVO);
		            }
		            innerMcuVO.setSubMainVOList(innerTermList);
		            innerMcuVOList.add(innerMcuVO);
		        }
		        ZZOInterfaceConfVO interfaceConfVO = new ZZOInterfaceConfVO();
				interfaceConfVO.setConfFlagId(vMeetingDetailVO.getMeetingDetailID());
				interfaceConfVO.setConfName(vMeetingDetailVO.getMeetingName());
				interfaceConfVO.setConfNumber(new Random().nextInt(7777)+1000+"");//addby chenshuo 会议号为随机数减少重复几率
				
				//根据建会模式增加一些设置  add on 2013-4-25 by chenshuo
				if( mcuCascadeModelVO != null ){//
					if( McuControlHelper.personalModel(mcuCascadeModelVO.getConfModel())){//个人模式
						interfaceConfVO.setBroadcaster(mainMeetingRoomVO.getMeetingRoomName());
					}
					if( McuControlHelper.sameScreenModel(mcuCascadeModelVO.getConfModel())){//相同分屏模式
						//TODO:一些对相同分屏模式的操作写在这
					}
					if( McuControlHelper.lectureModel(mcuCascadeModelVO.getConfModel())){//演讲者模式
						interfaceConfVO.setLecturer(mainMeetingRoomVO.getMeetingRoomName());
					}
					
				}
				
				
				interfaceConfVO.setMasterConf(true);
				interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
				try{
					//interfaceConfVO.setDuration((int)(Float.parseFloat(vMeetingDetailVO.getMeetingDescription())) * 60);//modifyby chenshuo 类型转换异常
				}catch (Exception e) {
					interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
				}
				interfaceConfVO.setMainVOList(innerMcuVOList);
				resultVO = ZZOMcuFactory.getInstance().createConf(interfaceConfVO);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultVO;
	
	}
	/**
	 * 根据会议设备表建会
	 * @param vMeetingDetailVO
	 * @return
	 * @author John.Zhang
	 */
	public ZZOResultVO creatConfInMcuLevelTwo(String meetingDetailID){
		
		
		ZZOResultVO resultVO = null;
		Map<String, String> ipProfIdMap = null;
		
		try {
			MeetingDetailVO  vMeetingDetailVO = new MeetingDetailVO(); 
			 vMeetingDetailVO= ServiceFactory.getMeetingDetailService().queryByID(meetingDetailID);//得到会议对象VO
			//get meeting profile map
			McuCascadeModelVO mcuCascadeModelVO =  this.getCascadeModel(vMeetingDetailVO.getConfProfileID());
			if( mcuCascadeModelVO != null  ){
				ipProfIdMap = this.getProfilesMap(mcuCascadeModelVO);
			}
			
				ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
				MeetingRoomVO mainMeetingRoomVO = new MeetingRoomVO();//主会场
				Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = MeetingUtil.getMCULevelTwo(vMeetingDetailVO.getMeetingDetailID());
				Set<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> set = map.entrySet();
		        for (Iterator<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> it = set.iterator(); it.hasNext();) {
		            Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>> entry = (Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>) it.next();
		            EquipmentMcuVO outMcuVO = entry.getKey();
		            List<EquipmentTerminalVO> terminalList = entry.getValue();
		            ZZOMainVO innerMcuVO = new ZZOMainVO();
		            innerMcuVO.setEquipmentID(outMcuVO.getEquipmentID());
		            innerMcuVO.setEquipmentName(outMcuVO.getEquipmentNO());
		            innerMcuVO.setAdminLoginName(outMcuVO.getLoginName());
		            innerMcuVO.setAdminLoginPassword(outMcuVO.getLoginPassword());
		            innerMcuVO.setEquipmentIP(outMcuVO.getIp());
		            innerMcuVO.setCommandIP(outMcuVO.getCommandIP());
		            innerMcuVO.setModelID(outMcuVO.getEquipmentModel());
		            //MCU 4000 and MCU 2000 use the same model id
		            if(outMcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
		            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
		            }
		           
		            //add profiler
		            ZZOConfProfileVO confProfileVO = new ZZOConfProfileVO();
		         
		            confProfileVO.setGuid(ipProfIdMap.get(outMcuVO.getIp()));
		    		if(vMeetingDetailVO.getConfProfileID().length() < 10){
		    			confProfileVO.setGuid(vMeetingDetailVO.getConfProfileID());
		    		}
		            innerMcuVO.setZzoConfProfileVO(confProfileVO);
		            //add terminals
		    		List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
		    		
		    		
		            for(EquipmentTerminalVO outTerminal : terminalList){
		            	 ZZOMainVO innerTerminalVO = new ZZOMainVO();
		            	 if(outTerminal.getMdev().getMainEquipment()==MeetingDetailEquipmentVO.MAIN_VALID){
		            	  mainMeetingRoomVO = outTerminal.getMeetingRoomVO();
		            	  innerTerminalVO.setEquipmentName(outTerminal.getEquipmentNO());
		            	 }else{
		            	innerTerminalVO.setEquipmentName(outTerminal.getEquipmentNO());
		                mainMeetingRoomVO.setMeetingRoomName(outTerminal.getEquipmentNO());
		            	 }
		            	
		            	 innerTerminalVO.setEquipmentIP(outTerminal.getIp());
		            	 
		            	 //E.164 TODO
		            	 //是否启用小号
		            	 if(outTerminal.getRadioTreaty()!=null && !"".equals(outTerminal.getRadioTreaty()) && "E164".equalsIgnoreCase(outTerminal.getRadioTreaty())){
		            		 innerTerminalVO.setAliasName(outTerminal.getPstn());//别名——电话号码
		            		 innerTerminalVO.setAliasType(outTerminal.getRadioTreaty());
		            		 innerTerminalVO.setEquipmentIP(MeetingAppConfig.E164_IP);
		            	 }
		            	 
		            	 innerTermList.add(innerTerminalVO);
		            }
		            innerMcuVO.setSubMainVOList(innerTermList);
		            innerMcuVOList.add(innerMcuVO);
		        }
		        ZZOInterfaceConfVO interfaceConfVO = new ZZOInterfaceConfVO();
				interfaceConfVO.setConfFlagId(vMeetingDetailVO.getMeetingDetailID());
				interfaceConfVO.setConfName(vMeetingDetailVO.getMeetingName());
				interfaceConfVO.setConfNumber(new Random().nextInt(7777)+1000+"");//addby chenshuo 会议号为随机数减少重复几率
				
				//根据建会模式增加一些设置  add on 2013-4-25 by chenshuo
				if( mcuCascadeModelVO != null ){//
					if( McuControlHelper.personalModel(mcuCascadeModelVO.getConfModel())){//个人模式
						interfaceConfVO.setBroadcaster(mainMeetingRoomVO.getMeetingRoomName());
					}
					if( McuControlHelper.sameScreenModel(mcuCascadeModelVO.getConfModel())){//相同分屏模式
						//TODO:一些对相同分屏模式的操作写在这
					}
					if( McuControlHelper.lectureModel(mcuCascadeModelVO.getConfModel())){//演讲者模式
						interfaceConfVO.setLecturer(mainMeetingRoomVO.getMeetingRoomName());
					}
					
				}
				
				
				interfaceConfVO.setMasterConf(true);
				interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
				try{
					//interfaceConfVO.setDuration((int)(Float.parseFloat(vMeetingDetailVO.getMeetingDescription())) * 60);//modifyby chenshuo 类型转换异常
				}catch (Exception e) {
					interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
				}
				interfaceConfVO.setMainVOList(innerMcuVOList);
				resultVO = ZZOMcuFactory.getInstance().createConf(interfaceConfVO);
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultVO;
	
	}
	
	
	/**注意：这是针对每个子MCU的模板全部设置为演讲者模式模板时调用的方法
	 * create meeting in mcu immediately
	 * @param vMeetingDetailVO
	 * @author chenshuo
	 */
	public List<ZZOResultVO> creatLinkConfInMcu(MeetingDetailVO vMeetingDetailVO , int type ){
		try{
			return  createConf(vMeetingDetailVO, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 
	 * @param vMeetingDetailVO
	 * @param type 建会模式 1-全部子MCU演讲者模式 2-全部子MCU模板无模式
	 * @throws Exception
	 */
	private List<ZZOResultVO> createConf( MeetingDetailVO vMeetingDetailVO , int type ) throws Exception{
		String meetingRoomIDs = vMeetingDetailVO.getMeetingRoomNameIDs();
		
		if(!OperateUtil.isAvailable(meetingRoomIDs) || !OperateUtil.isAvailable(vMeetingDetailVO.getConfProfileID())){
			return null;
		}
		
		
		
		//get meeting profile map
		Map<String, String> ipProfIdMap = null;
		McuCascadeModelVO mcuCascadeModelVO =  this.getCascadeModel(vMeetingDetailVO.getConfProfileID());
		if( mcuCascadeModelVO != null  ){
			ipProfIdMap = this.getProfilesMap(mcuCascadeModelVO);
		}
	
		Calendar currentTime = Calendar.getInstance();
		String masterConfNumber = new Random().nextInt(8999)+1000+"";//主会会议号 4位数字
		String slaveConfNumber = "";//子会会议号
		
		meetingRoomIDs = "'" + meetingRoomIDs.replace(",", "','") + "'";
		
		//取得主会场对应会议室id
		String mainMeetingRoomID = vMeetingDetailVO.getMeetingRoomID();
		mainMeetingRoomID = "'" + mainMeetingRoomID + "'";
		EquipmentMcuVO mainMcuVO = new EquipmentMcuVO();//主MCU对象
		EquipmentVO   mainVO = new EquipmentVO();
		List<EquipmentTerminalVO> TerList = null;//主MCU终端对象
		List<ZZOMainVO> mainTerList = null;
		List<ZZOInterfaceConfVO> interfaceConfVOList = new ArrayList<ZZOInterfaceConfVO>();//会议对象List（几个MCU级联建几个会）
		
			//取得主mcu
			String mainMCUID = mcuCascadeModelVO.getDescription();//获取主MCUID
			mainVO.setEquipmentID(mainMCUID);
			mainVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
			mainVO = ServiceFactory.getEquipmentService().query(mainVO, null).get(0);
			mainMcuVO = ServiceFactory.getEquipmentMcuService().queryByID(mainMCUID);
			MeetingRoomVO mainMeetingRoomVO = new MeetingRoomVO();//主会场
		
			ArrayList<EquipmentTerminalVO> equipmentTerminalVOList = new EquipmentTerminalServiceImpl().queryByRoomIDs(meetingRoomIDs);		
			if(equipmentTerminalVOList != null && equipmentTerminalVOList.size() > 0){
				Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = getMcuAndTeminalMap(equipmentTerminalVOList);//所有MCU及其终端集合
				Set<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> set = map.entrySet();
				for (Iterator<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> it = set.iterator(); it.hasNext();) {
			            Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>> entry = (Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>) it.next();
			            EquipmentMcuVO outMcuVO = entry.getKey();
			            if( outMcuVO.getIp().equals(mainVO.getIp()) ){
			            	TerList = entry.getValue();
			            	mainTerList = getInnerTermList(TerList);//取得主MCU下的终端集合
			            }
			            List<EquipmentTerminalVO> terminalList = entry.getValue();//
			            for( EquipmentTerminalVO etVO :  terminalList ){
			            	if( etVO.getMeetingRoomVO().getMeetingRoomID().equalsIgnoreCase(vMeetingDetailVO.getMeetingRoomID())){
			            		mainMeetingRoomVO = etVO.getMeetingRoomVO();
			            	}
			            }
			            
			      }
				int i = 1;
		        for (Iterator<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> it = set.iterator(); it.hasNext();) {
		            Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>> entry = (Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>) it.next();
		            EquipmentMcuVO outMcuVO = entry.getKey();
		           
		            if( !outMcuVO.getIp().equals(mainVO.getIp())){//1.如果是从MCU,则需要在从MCU终端集合中添加主MCU级联点
		            	
		            	ZZOMainVO innerMcuVO = new ZZOMainVO();//子mcu信息
			            innerMcuVO.setEquipmentID(outMcuVO.getEquipmentID());
			            innerMcuVO.setEquipmentName(outMcuVO.getEquipmentNO());
			            innerMcuVO.setAdminLoginName(outMcuVO.getLoginName());
			            innerMcuVO.setAdminLoginPassword(outMcuVO.getLoginPassword());
			            innerMcuVO.setEquipmentIP(outMcuVO.getIp());
			            innerMcuVO.setCommandIP(outMcuVO.getCommandIP());
			            innerMcuVO.setModelID(outMcuVO.getEquipmentModel());//modify by chenshuo on 3-7
			            //MCU 4000 and MCU 2000 use the same model id
			            if(outMcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
			            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
			            }
			            
			            //子MCU终端List中添加级联点
			            List<EquipmentTerminalVO> terminalList = entry.getValue();//取得子mcu对应终端List
			            
			            List<ZZOMainVO> innerTermList = getInnerTermList(terminalList);//拼接终端List
			            
			            
			    
			            ZZOMainVO innerLinkTerminalVO = new ZZOMainVO();//设置从会中级联点对象，对象为主MCU信息(当成终端)
			            innerLinkTerminalVO.setAliasName(masterConfNumber);//级联点别名与主MCU建会的会议号一致
			            innerLinkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE);
			            innerLinkTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_IN);//方向为呼入
			            if(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID.equals(innerMcuVO.getModelID())){
			            	innerLinkTerminalVO.setCallDirection(MCUConfig.DIAL_IN_EXTERNAL_VALUE);
			            	innerLinkTerminalVO.setCommandIP(mainMcuVO.getCommandIP());
			            	innerLinkTerminalVO.setModelID(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID);
			            	innerLinkTerminalVO.setAliasName("");//级联点别名与主MCU建会的会议号一致
					        //innerLinkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE_E164);
			            }
			            innerLinkTerminalVO.setCascadeRole(MeetingAppConfig.CASCADEROLE_SLAVE);//级联角色为从会
			            innerLinkTerminalVO.setEquipmentIP(mainMcuVO.getCommandIP());//主mcu的信令ip
			            innerLinkTerminalVO.setEquipmentName(mainVO.getEquipmentNO()+"级联点");//显示名
			            //innerLinkTerminalVO.setUplinkEquipmentID(mainMcuVO.getEquipmentID());//上一级设备ID
			            innerTermList.add(innerLinkTerminalVO);//级联点加入从会终端List
			            
			            //add profiler
			            ZZOConfProfileVO confProfileVO = new ZZOConfProfileVO();//会议模板对象
			           
			            
			            confProfileVO.setGuid(ipProfIdMap.get(outMcuVO.getIp()));//子会模板ID根据数据库中的配置提取
			            innerMcuVO.setZzoConfProfileVO(confProfileVO);
			            innerMcuVO.setSubMainVOList(innerTermList);
			            
			            ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();//mainVOList
			            innerMcuVOList.add(innerMcuVO);
			            ZZOInterfaceConfVO interfaceConfVO = new ZZOInterfaceConfVO();
			            interfaceConfVO.setConfFlagId(vMeetingDetailVO.getMeetingDetailID());//子会议ID
						interfaceConfVO.setConfName(vMeetingDetailVO.getMeetingName()+outMcuVO.getEquipmentNO());//子会议名字
						
						
						//根据建会模式增加一些设置  add on 2013-4-25 by chenshuo
						if( mcuCascadeModelVO != null ){//
							if( McuControlHelper.personalModel(mcuCascadeModelVO.getConfModel())){//个人模式（级联点个人模式）
								interfaceConfVO.setBroadcaster(mainVO.getEquipmentNO()+"级联点");
							}
							if( McuControlHelper.sameScreenModel(mcuCascadeModelVO.getConfModel())){//相同分屏模式(级联点为演讲者)
								//TODO:一些对相同分屏模式级联点的操作写在这
								interfaceConfVO.setLecturer(mainVO.getEquipmentNO()+"级联点");
							}
							if( McuControlHelper.lectureModel(mcuCascadeModelVO.getConfModel())){//演讲者模式(级联点为演讲者)
								interfaceConfVO.setLecturer(mainVO.getEquipmentNO()+"级联点");
							}
							
						}
						
						
						slaveConfNumber = new Random().nextInt(8999)+1000+"";
						interfaceConfVO.setConfNumber(slaveConfNumber);//子会会议号 modify by chenshuo at 2013-3-12
						try{
							interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));//modifyby chenshuo 类型转换异常
						}catch (Exception e) {
							interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
						}
						interfaceConfVO.setMainVOList(innerMcuVOList);//
						//interfaceConfVO.setParentIpAndConfNum(mainVO.getIp()+MeetingAppConfig.CONFER_NUMBER);
						interfaceConfVO.setOrderNumber(1);//从会先建会
						interfaceConfVOList.add(interfaceConfVO);
						
						//2.主MCU对应终端添加子MCU级联点
						ZZOMainVO linkTerminalVO = new ZZOMainVO();//创建当前子MCU级联点对象
						linkTerminalVO.setAliasName(slaveConfNumber);//级联点别名与子MCU会议ID一致
						linkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE);
						linkTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_OUT);//方向为呼出
						linkTerminalVO.setCascadeRole(MeetingAppConfig.CASCADEROLE_MASTER);
						linkTerminalVO.setEquipmentIP(outMcuVO.getCommandIP());
						linkTerminalVO.setEquipmentName(outMcuVO.getEquipmentNO()+"级联点"+i);
						if(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID.equals(outMcuVO.getEquipmentModel())){
							linkTerminalVO.setModelID(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID);
							linkTerminalVO.setCommandIP(outMcuVO.getCommandIP());
							linkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE_E164);
						}
						mainTerList.add(linkTerminalVO);//把级联点加入主MCU终端list
			           
			            
		            }
		            i++;
		        }
		        ZZOMainVO mMcuVO = new ZZOMainVO();//主mcu信息
	            //设置mcu信息
	            mMcuVO.setEquipmentID(mainVO.getEquipmentID());
	            mMcuVO.setEquipmentName(mainVO.getEquipmentNO());
	            mMcuVO.setAdminLoginName(mainMcuVO.getLoginName());
	            mMcuVO.setAdminLoginPassword(mainMcuVO.getLoginPassword());
	            mMcuVO.setEquipmentIP(mainVO.getIp());
	            mMcuVO.setCommandIP(mainMcuVO.getCommandIP());
	            mMcuVO.setModelID(mainVO.getEquipmentModel());//add by chenshuo on 3-7
	          //MCU 4000 and MCU 2000 use the same model id
	            if(mainVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
	            	mMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
	            }
	            ZZOConfProfileVO confProfileVO1 = new ZZOConfProfileVO();//模板对象
	            confProfileVO1.setGuid(ipProfIdMap.get(mainVO.getIp()));//主会模板ID由前台传值
	            //confProfileVO.setGuid(ipProfIdMap.get(innerMcuVO.getEquipmentIP()));
	            mMcuVO.setZzoConfProfileVO(confProfileVO1);
	            mMcuVO.setSubMainVOList(mainTerList);//设置主MCU终端list（包含级联点）
	            ArrayList<ZZOMainVO> innerMcuVOList1 = new ArrayList<ZZOMainVO>();//mainVOList
	            innerMcuVOList1.add(mMcuVO);//所有终端和mcu信息
	            
	            ZZOInterfaceConfVO interfaceConfVO1 = new ZZOInterfaceConfVO();//主会议对象
	            interfaceConfVO1.setConfFlagId(vMeetingDetailVO.getMeetingDetailID());//会议ID
				interfaceConfVO1.setConfName(vMeetingDetailVO.getMeetingName() + mainVO.getEquipmentNO());//会议名字
	            interfaceConfVO1.setConfNumber(masterConfNumber);//modify by chenshuo at 2013-3-12
				interfaceConfVO1.setMasterConf(true);//是否主会
				try{
					interfaceConfVO1.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));//modifyby chenshuo at 2013-3-12
				}catch (Exception e) {
					interfaceConfVO1.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
				}
				interfaceConfVO1.setMainVOList(innerMcuVOList1);//
				
				
				
				//根据建会模式增加一些设置  add on 2013-4-25 by chenshuo
				if( mcuCascadeModelVO != null ){//
					if( McuControlHelper.personalModel(mcuCascadeModelVO.getConfModel())){//个人模式（主会个人模式）
						interfaceConfVO1.setBroadcaster(mainMeetingRoomVO.getMeetingRoomName());
					}
					if( McuControlHelper.sameScreenModel(mcuCascadeModelVO.getConfModel())){//相同分屏模式(主会相同分屏)
						//TODO:一些对主会相同分屏模式的操作写在这
					}
					if( McuControlHelper.lectureModel(mcuCascadeModelVO.getConfModel())){//演讲者模式(主会演讲者)
						interfaceConfVO1.setLecturer(mainMeetingRoomVO.getMeetingRoomName());
					}
					
				}
				
				interfaceConfVO1.setOrderNumber(5);//主会后建会
				interfaceConfVOList.add(interfaceConfVO1);
			}
				
			List<ZZOResultVO> zzoResultList =  ZZOMcuFactory.getInstance().createConf(interfaceConfVOList);
			return zzoResultList;
}
	
	/**
	 * spliter object by regular delimiter
	 * @param object
	 * @return
	 * @author wangle
	 * @since Feb 1, 2012
	 */
	public static String[] splitter(String object, String delimiter){
		if(object == null || object.trim().equals("")){
			return null;
		}
		
		String[] result = object.split(delimiter);
		return result;
	}
	
	/**
	 * 根据终端ips取得对应mcu集合
	 * @param EquipmentTerminalVOList
	 * @return
	 * @throws Exception
	 */
	private ArrayList<EquipmentMcuVO> getMcuList( ArrayList<EquipmentTerminalVO> EquipmentTerminalVOList) throws Exception{
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<EquipmentTerminalVOList.size(); i++){
			EquipmentTerminalVO terminal = EquipmentTerminalVOList.get(i);
			if(i > 0){
			 buffer.append(",");	
			}
			buffer.append("'" + terminal.getIp() + "'");
		}
		EquipmentMcuService mcuser = new EquipmentMcuServiceImpl();
		ArrayList<EquipmentMcuVO> mculist = mcuser.queryByIPs(buffer.toString());
		return mculist;
	}
	
	/**
	 * 根据终端ips取得对应终端对象集合
	 * @param EquipmentTerminalVOList
	 * @return
	 * @throws Exception
	 */
	private ArrayList<EquipmentTerminalVO> getTerList( List<EquipmentTerminalVO> EquipmentTerminalVOList) throws Exception{
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<EquipmentTerminalVOList.size(); i++){
			EquipmentTerminalVO terminal = EquipmentTerminalVOList.get(i);
			if(i > 0){
			 buffer.append(",");	
			}
			buffer.append("'" + terminal.getIp() + "'");
		}
		EquipmentTerminalService terser = new EquipmentTerminalServiceImpl();
		ArrayList<EquipmentTerminalVO> terlist = terser.queryByIPs(buffer.toString());
		return terlist;
	}
	
	/**
	 * 拼接mcu接口需要的终端List集合
	 * @param terminalList
	 * @return
	 */
	private  List<ZZOMainVO>  getInnerTermList( List<EquipmentTerminalVO> terminalList ){
		List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
        for(EquipmentTerminalVO outTerminal : terminalList){
        	 ZZOMainVO innerTerminalVO = new ZZOMainVO();
        	 if(outTerminal.getMeetingRoomVO() != null){
        		 innerTerminalVO.setEquipmentName(outTerminal.getMeetingRoomVO().getMeetingRoomName());
        	 }else{
        		 innerTerminalVO.setEquipmentName(outTerminal.getEquipmentName());
        	 }
        	 innerTerminalVO.setEquipmentIP(outTerminal.getIp());
        	 innerTermList.add(innerTerminalVO);//拼接subMainVOList
        }
        return innerTermList;
	}
	
	/**
	 * 获取模板组
	 */
	private McuCascadeModelVO getCascadeModel( String cascadeID ) throws Exception{
		return ServiceFactory.getMcuCascadeModelService().queryByID(cascadeID);
	}
	
	/**
	 * 拆分模板组IDS存为map以便使用
	 */
	private Map<String,String> getProfilesMap( McuCascadeModelVO mcuCascadeModelVO ){
		HashMap<String,String> profilesMap = new HashMap<String,String>();
		try{
			String mcuIP = mcuCascadeModelVO.getMcuIp();
			String modelID = mcuCascadeModelVO.getModelID();
			String[] mcuIPs = mcuIP.split("_");
			String[] modelIDs = modelID.split("_");
			for( int i=0; i<mcuIPs.length; i++ ){
				profilesMap.put(mcuIPs[i], modelIDs[i]);
			}
			
		}catch( Exception e ){
			
		}
		return profilesMap;
	}
	
	/**
	 * 
	 */
	public static Map<EquipmentMcuVO, List<EquipmentTerminalVO>> getMcuAndTeminalMap(ArrayList<EquipmentTerminalVO> equipmentTerminalVOList){
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<equipmentTerminalVOList.size(); i++){
			EquipmentTerminalVO terminal = equipmentTerminalVOList.get(i);
			if(i > 0){
			 buffer.append(",");	
			}
			buffer.append("'" + terminal.getIp() + "'");
		}
		
		Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = MeetingUtil.getMCU(buffer.toString());//所有MCU及其终端集合
	
		return map;
		
	}
	
	/**
	 * 获取MCU建会失败返回信息
	 * @param xmlMessage
	 * @return
	 */
	public static  String getErrorMessage( String xmlMessage ){
		if( xmlMessage.indexOf("Display name already exists") != -1 ){
			return "请检查MCU上是否已经存在相同名称的会议";
		}
		if( xmlMessage.indexOf("Profile not found") != -1 ){
			return "请检查各会议调用的模板是否正确";
		}
		if( xmlMessage.indexOf("User not found") != -1 ){
			return "MCU上不存在系统注册的MCU设备用户名";
		}if( xmlMessage.indexOf("Invalid end time") != -1){
		    return "不合法的会议时长";
	    }else {
			return "对不起，可能因为配置错误导致建会失败";
		}
	}
	
	/**
	 * 是否是个人模式
	 * @param confModel
	 * @return
	 */
	public static  boolean personalModel( String confModel ){
		if( String.valueOf(McuCascademodelEnum.PERSONAL_MODEL).equalsIgnoreCase(confModel)){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 是否是相同分屏模式
	 * @param confModel
	 * @return
	 */
	public static  boolean sameScreenModel( String confModel ){
		if( String.valueOf(McuCascademodelEnum.SAME_SCREEN_MODEL).equalsIgnoreCase(confModel)){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 是否是演讲者模式
	 */
	public static  boolean lectureModel( String confModel ){
		if( String.valueOf(McuCascademodelEnum.LECTURE_MODEL).equalsIgnoreCase(confModel)){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * synchronize every conference information from mcu in a big meeting.
	 * @param meetingDetailID
	 * @return
	 */
	public  boolean synConfsFromMcu(String meetingDetailID){
		List<ZZOMainStatusVO> mainStatusList = null;
		try {
			ZZOConfVO confVO = new ZZOConfVO();
			confVO.setConfFlagId(meetingDetailID);
			List<ZZOConfVO> confVOList = new ConfServiceImpl().getConfList(confVO, null);
			if(confVOList == null || confVOList.size() <= 0){
				return false;
			}
			ZZMCU2000ContactHandler mcu2000ContactHandler = new ZZMCU2000ContactHandler();
			for(ZZOConfVO tempConfVO : confVOList){
				mainStatusList = ZZOMcuFactory.getInstance().getMcuControlHelper().synConfFromMcu(tempConfVO);
				if(mainStatusList == null || mainStatusList.size() <= 0){
					continue;
				}
				
				//synchronize meeting room status.
				synMainStatus(confVOList, tempConfVO, mainStatusList, mcu2000ContactHandler);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private void synMainStatus(List<ZZOConfVO> confVOList, ZZOConfVO tempConfVO, List<ZZOMainStatusVO> mainStatusList, ZZMCU2000ContactHandler mcu2000ContactHandler){
		TransactionManager tManager = null;
		MeetingMcuService meetingMcuService = new MeetingMcuServiceImpl();
		try {
			tManager = new TransactionManager();
			tManager.beginTransaction();
			ZZOMainStatusVO meetingMcuVOTemp = new ZZOMainStatusVO();
			meetingMcuVOTemp.setConfFlagId(tempConfVO.getConfFlagId());
			meetingMcuVOTemp.setMcuIp(tempConfVO.getMcuIP());
			meetingMcuVOTemp.setMcuMeetingID(tempConfVO.getGuid());
			List<ZZOMainStatusVO> oldMeetingMcuVoList  = ConfAllPts.getMeetingMcuList(meetingMcuVOTemp);
			//check cascade point
			for(ZZOMainStatusVO tempMainStatusVO : oldMeetingMcuVoList){
				for(ZZOConfVO aConfVO : confVOList){
					if(aConfVO.getMcuCommandIP().equals(tempMainStatusVO.getMcu_participant_ip())){
						if(aConfVO.getIsMasterConf() != null && aConfVO.getIsMasterConf().intValue() == MCUConfig.IS_MASTER_CONF){
							if(tempMainStatusVO.getNodeType() == null || tempMainStatusVO.getNodeType().intValue() != MCUConfig.SLAVE_MCU_CASCADE_TYPE){
								tempMainStatusVO.setNodeType(MCUConfig.SLAVE_MCU_CASCADE_TYPE);
								meetingMcuService.modifyMeetingMcu(tempMainStatusVO, null);
								//update a conference participant
								ConfAllPts.updateConfPts(tempMainStatusVO);
							}
						}else{
							if(tempMainStatusVO.getNodeType() == null || tempMainStatusVO.getNodeType().intValue() != MCUConfig.MASTER_MCU_CASCADE_TYPE){
								tempMainStatusVO.setNodeType(MCUConfig.MASTER_MCU_CASCADE_TYPE);
								meetingMcuService.modifyMeetingMcu(tempMainStatusVO, null);
								//update a conference participant
								ConfAllPts.updateConfPts(tempMainStatusVO);
							}
						}
						//break conference loop
						break;
					}
				}
				//check meeting name property where rolling call will be used.
				if(!OperateUtil.isAvailable(tempMainStatusVO.getMeetingName())){
					for(ZZOConfVO aConfVO : confVOList){
						if(aConfVO.getMcuIP().equals(tempMainStatusVO.getMcuIp()) && aConfVO.getGuid().equals(tempMainStatusVO.getMcuMeetingID())){
							tempMainStatusVO.setMeetingName(aConfVO.getConfName());
							break;
						}
					}
				}
						
			}
			
			for(int i = 0; i < mainStatusList.size(); i++){
				ZZOMainStatusVO meetingMcu = mainStatusList.get(i); 
				if(meetingMcu.getOnGoingPartyChange() == null || !meetingMcu.getOnGoingPartyChange().trim().equals(Message.ONGOING_PARTY_CHANGE_INTO_DELETED)){
					mcu2000ContactHandler.updateMeetingMcu(meetingMcu, oldMeetingMcuVoList, tempConfVO, tManager);
				}
			}
			
			//modify meeting mcu info to the latest
			//mcu2000ContactHandler.modifyOldMeetingMcu(mainStatusList, oldMeetingMcuVoList, tempConfVO, tManager);
			tManager.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if(tManager!=null){
				 tManager.rollback();
			}
		}finally{
			if(tManager != null){
				tManager.endTransaction();
			}
		}
	}
	
	/**
	 * create conferences rapidly.
	 * @param vMeetingDetailVO
	 * @throws Exception
	 */
	public List<ZZOResultVO> createRapidConf(String meetingDetailId) throws Exception{
		
		MeetingDetailVO vMeetingDetailVO = ServiceFactory.getMeetingDetailService().queryByID(meetingDetailId);
		MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
		meetingDetailEquipmentVO.setMeetingDetailID(vMeetingDetailVO.getMeetingDetailID());
		ArrayList<MeetingDetailEquipmentVO> mdEquipmentList = ServiceFactory.getMeetingDetailEquipmentService().query(meetingDetailEquipmentVO, null);
		if(mdEquipmentList == null || mdEquipmentList.size() <= 0){
			return null;
		}
		//GET MCU LIST
		EquipmentMcuVO equipmentMcuVO = new EquipmentMcuVO();
		equipmentMcuVO.setStatus(EquipmentEnum.STATUS_VALID);		
		ArrayList<EquipmentMcuVO> equpmentmcuList = ServiceFactory.getEquipmentMcuService().query(equipmentMcuVO, null);
		if(equpmentmcuList == null || equpmentmcuList.size() <= 0){
			return null;
		}
		
		List<EquipmentMcuVO> slaveMcuList = new ArrayList<EquipmentMcuVO>(); //GET SLAVE MCU
		MeetingDetailEquipmentVO mainMDEquipmentVO = null; //主MCU开会信息
		MeetingDetailEquipmentVO mainMeetingRoom = new MeetingDetailEquipmentVO(); //主会场
		EquipmentVO   mainVO ; //主MCU信息
		EquipmentMcuVO mainMcuVO = null;  //主MCU信息
		Map<String,MeetingDetailEquipmentVO> slaveMDEquipmentMap = new HashMap<String,MeetingDetailEquipmentVO>();
		Map<String, List<MeetingDetailEquipmentVO>> mcuPartyList = new HashMap<String, List<MeetingDetailEquipmentVO>>();
		for(MeetingDetailEquipmentVO mdEquipmentVO : mdEquipmentList){
			//get mcu
			if(mdEquipmentVO.getEquipmentType() == EquipmentEnum.TYPE_ID_MCU){
				if("-1".equals(mdEquipmentVO.getCascadeID())){
					mainMDEquipmentVO = mdEquipmentVO;
					mainMcuVO = getEquipmentVO(mdEquipmentVO.getEquipmentID(), equpmentmcuList);
				}else{
					slaveMDEquipmentMap.put(mdEquipmentVO.getEquipmentID(), mdEquipmentVO);
					slaveMcuList.add(getEquipmentVO(mdEquipmentVO.getEquipmentID(), equpmentmcuList));
				}
			}else{
				if(mdEquipmentVO.getMainEquipment() == 1){
					mainMeetingRoom = mdEquipmentVO;
				}
				//collect mcu-party list information.
				System.out.println("*******************id=" + mdEquipmentVO.getEquipmentID());
				collectParty(mdEquipmentVO, mcuPartyList);
			}
		}
		if(mainMcuVO == null){
			return null;
		}
		mainVO = ServiceFactory.getEquipmentService().queryByID(mainMcuVO.getEquipmentID());
		//get party list in master mcu
		System.out.println("*******************id=" + mainVO.getEquipmentID() + "  ** mainmcuvo id=" + mainMcuVO.getEquipmentID());
		List<MeetingDetailEquipmentVO> mdEquList = mcuPartyList.get(mainVO.getEquipmentID());
		if(mdEquList == null){
			return null;
		}
		List<ZZOMainVO> mainTerList = getRapidInnerTermList(mdEquList);//主MCU终端对象列表
		
//		String meetingRoomIDs = vMeetingDetailVO.getMeetingRoomNameIDs();
		
//		if(!OperateUtil.isAvailable(meetingRoomIDs) || !OperateUtil.isAvailable(vMeetingDetailVO.getConfProfileID())){
//			return null;
//		}
		//没有开会模式，返回。
		if(!OperateUtil.isAvailable(vMeetingDetailVO.getConfProfileID())){
			return null;
		}
		
		
		//get meeting profile map
//		Map<String, String> ipProfIdMap = null;
		McuCascadeModelVO mcuCascadeModelVO =  this.getCascadeModel(vMeetingDetailVO.getConfProfileID());
//		if( mcuCascadeModelVO != null  ){
//			ipProfIdMap = this.getProfilesMap(mcuCascadeModelVO);
//		}
	
		Calendar currentTime = Calendar.getInstance();
		String masterConfNumber = new Random().nextInt(8999)+1000+"";//主会会议号 4位数字
		String slaveConfNumber = "";//子会会议号
		
//		meetingRoomIDs = "'" + meetingRoomIDs.replace(",", "','") + "'";
		
		//取得主会场对应会议室id
//		String mainMeetingRoomID = vMeetingDetailVO.getMeetingRoomID();
//		mainMeetingRoomID = "'" + mainMeetingRoomID + "'";
//		EquipmentMcuVO mainMcuVO = new EquipmentMcuVO();//主MCU对象
//		EquipmentVO   mainVO = new EquipmentVO();
//		List<EquipmentTerminalVO> TerList = null;//主MCU终端对象
		
		List<ZZOInterfaceConfVO> interfaceConfVOList = new ArrayList<ZZOInterfaceConfVO>();//会议对象List（几个MCU级联建几个会）
		
			//取得主mcu
//			String mainMCUID = mcuCascadeModelVO.getDescription();//获取主MCUID
//			mainVO.setEquipmentID(mainMCUID);
//			mainVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
//			mainVO = ServiceFactory.getEquipmentService().query(mainVO, null).get(0);
//			mainMcuVO = ServiceFactory.getEquipmentMcuService().queryByID(mainMCUID);
//			MeetingRoomVO mainMeetingRoomVO = new MeetingRoomVO();//主会场
		
//			ArrayList<EquipmentTerminalVO> equipmentTerminalVOList = new EquipmentTerminalServiceImpl().queryByRoomIDs(meetingRoomIDs);		
//			if(equipmentTerminalVOList != null && equipmentTerminalVOList.size() > 0){
//				Map<EquipmentMcuVO, List<EquipmentTerminalVO>> map = getMcuAndTeminalMap(equipmentTerminalVOList);//所有MCU及其终端集合
//				Set<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> set = map.entrySet();
//				for (Iterator<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> it = set.iterator(); it.hasNext();) {
//			            Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>> entry = (Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>) it.next();
//			            EquipmentMcuVO outMcuVO = entry.getKey();
//			            if( outMcuVO.getIp().equals(mainVO.getIp()) ){
//			            	TerList = entry.getValue();
//			            	mainTerList = getInnerTermList(TerList);//取得主MCU下的终端集合
//			            }
//			            List<EquipmentTerminalVO> terminalList = entry.getValue();//
//			            for( EquipmentTerminalVO etVO :  terminalList ){
//			            	if( etVO.getMeetingRoomVO().getMeetingRoomID().equalsIgnoreCase(vMeetingDetailVO.getMeetingRoomID())){
//			            		mainMeetingRoomVO = etVO.getMeetingRoomVO();
//			            	}
//			            }
//			            
//			      }
				int i = 1;
//		        for (Iterator<Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>> it = set.iterator(); it.hasNext();) {
//		            Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>> entry = (Map.Entry<EquipmentMcuVO, List<EquipmentTerminalVO>>) it.next();
//		            EquipmentMcuVO outMcuVO = entry.getKey();
		            for(EquipmentMcuVO outMcuVO : slaveMcuList){  
		            	EquipmentVO slaveMcuVO = ServiceFactory.getEquipmentService().queryByID(outMcuVO.getEquipmentID());
//		            if( !outMcuVO.getIp().equals(mainVO.getIp())){//1.如果是从MCU,则需要在从MCU终端集合中添加主MCU级联点
		            	ZZOMainVO innerMcuVO = new ZZOMainVO();//子mcu信息
			            innerMcuVO.setEquipmentID(outMcuVO.getEquipmentID());
			            innerMcuVO.setEquipmentName(slaveMcuVO.getEquipmentNO());
			            innerMcuVO.setAdminLoginName(outMcuVO.getLoginName());
			            innerMcuVO.setAdminLoginPassword(outMcuVO.getLoginPassword());
			            innerMcuVO.setEquipmentIP(slaveMcuVO.getIp());
			            innerMcuVO.setCommandIP(outMcuVO.getCommandIP());
			            innerMcuVO.setModelID(slaveMcuVO.getEquipmentModel());//modify by chenshuo on 3-7
			            //MCU 4000 and MCU 2000 use the same model id
			            if(slaveMcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
			            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
			            }
			            
			            //子MCU终端List中添加级联点
			           // List<EquipmentTerminalVO> terminalList = entry.getValue();//取得子mcu对应终端List
			         // List<ZZOMainVO> innerTermList = getInnerTermList(terminalList);//拼接终端List
			            List<MeetingDetailEquipmentVO> slaveMdEquList = mcuPartyList.get(outMcuVO.getEquipmentID());
			    		if(slaveMdEquList == null){
			    			slaveMdEquList = new ArrayList<MeetingDetailEquipmentVO>();
			    		}
			    		List<ZZOMainVO> innerTermList = getRapidInnerTermList(slaveMdEquList);//取得子mcu对应终端List
			            
			            ZZOMainVO innerLinkTerminalVO = new ZZOMainVO();//设置从会中级联点对象，对象为主MCU信息(当成终端)
			            innerLinkTerminalVO.setAliasName(masterConfNumber);//级联点别名与主MCU建会的会议号一致
			            innerLinkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE);
			            innerLinkTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_IN);//方向为呼入
			            if(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID.equals(innerMcuVO.getModelID())){
			            	innerLinkTerminalVO.setCallDirection(MCUConfig.DIAL_IN_EXTERNAL_VALUE);
			            	innerLinkTerminalVO.setCommandIP(mainMcuVO.getCommandIP());
			            	innerLinkTerminalVO.setModelID(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID);
			            	innerLinkTerminalVO.setAliasName("");//级联点别名与主MCU建会的会议号一致
					        //innerLinkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE_E164);
			            }
			            innerLinkTerminalVO.setCascadeRole(MeetingAppConfig.CASCADEROLE_SLAVE);//级联角色为从会
			            innerLinkTerminalVO.setEquipmentIP(mainMcuVO.getCommandIP());//主mcu的信令ip
			            innerLinkTerminalVO.setEquipmentName(mainVO.getEquipmentNO()+"级联点");//显示名
			            //innerLinkTerminalVO.setUplinkEquipmentID(mainMcuVO.getEquipmentID());//上一级设备ID
			            innerTermList.add(innerLinkTerminalVO);//级联点加入从会终端List
			            
			            //add profiler
			            ZZOConfProfileVO confProfileVO = new ZZOConfProfileVO();//会议模板对象
			            MeetingDetailEquipmentVO mde = slaveMDEquipmentMap.get(outMcuVO.getEquipmentID());
			            confProfileVO.setGuid(mde.getConfProfileID());//子会模板ID根据数据库中的配置提取
			            innerMcuVO.setZzoConfProfileVO(confProfileVO);
			            innerMcuVO.setSubMainVOList(innerTermList);
			            
			            ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();//mainVOList
			            innerMcuVOList.add(innerMcuVO);
			            ZZOInterfaceConfVO interfaceConfVO = new ZZOInterfaceConfVO();
			            interfaceConfVO.setConfFlagId(vMeetingDetailVO.getMeetingDetailID());//子会议ID
						interfaceConfVO.setConfName(vMeetingDetailVO.getMeetingName()+slaveMcuVO.getEquipmentNO());//子会议名字
						
						//根据建会模式增加一些设置  add on 2013-4-25 by chenshuo
						if( mcuCascadeModelVO != null ){//
							if( McuControlHelper.personalModel(mcuCascadeModelVO.getConfModel())){//个人模式（级联点个人模式）
								interfaceConfVO.setBroadcaster(mainVO.getEquipmentNO()+"级联点");
							}
							if( McuControlHelper.sameScreenModel(mcuCascadeModelVO.getConfModel())){//相同分屏模式(级联点为演讲者)
								//TODO:一些对相同分屏模式级联点的操作写在这
								interfaceConfVO.setLecturer(mainVO.getEquipmentNO()+"级联点");
							}
							if( McuControlHelper.lectureModel(mcuCascadeModelVO.getConfModel())){//演讲者模式(级联点为演讲者)
								interfaceConfVO.setLecturer(mainVO.getEquipmentNO()+"级联点");
							}
						}
						
						slaveConfNumber = new Random().nextInt(8999)+1000+"";
						interfaceConfVO.setConfNumber(slaveConfNumber);//子会会议号 modify by chenshuo at 2013-3-12
						try{
							interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));//modifyby chenshuo 类型转换异常
						}catch (Exception e) {
							interfaceConfVO.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
						}
						interfaceConfVO.setMainVOList(innerMcuVOList);//
						//interfaceConfVO.setParentIpAndConfNum(mainVO.getIp()+MeetingAppConfig.CONFER_NUMBER);
						interfaceConfVO.setOrderNumber(1);//从会先建会
						interfaceConfVOList.add(interfaceConfVO);
						
						//2.主MCU对应终端添加子MCU级联点
						ZZOMainVO linkTerminalVO = new ZZOMainVO();//创建当前子MCU级联点对象
						linkTerminalVO.setAliasName(slaveConfNumber);//级联点别名与子MCU会议ID一致
						linkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE);
						linkTerminalVO.setCallDirection(MeetingAppConfig.CALLDIRECTION_OUT);//方向为呼出
						linkTerminalVO.setCascadeRole(MeetingAppConfig.CASCADEROLE_MASTER);
						linkTerminalVO.setEquipmentIP(outMcuVO.getCommandIP());
						linkTerminalVO.setEquipmentName(slaveMcuVO.getEquipmentNO()+"级联点"+i);
						if(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID.equals(slaveMcuVO.getEquipmentModel())){
							linkTerminalVO.setModelID(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID);
							linkTerminalVO.setCommandIP(outMcuVO.getCommandIP());
							linkTerminalVO.setAliasType(MeetingAppConfig.ALIAS_TYPE_E164);
						}
						mainTerList.add(linkTerminalVO);//把级联点加入主MCU终端list
			              
//		            }
		            i++;
		        }
		        ZZOMainVO mMcuVO = new ZZOMainVO();//主mcu信息
	            //设置mcu信息
	            mMcuVO.setEquipmentID(mainVO.getEquipmentID());
	            mMcuVO.setEquipmentName(mainVO.getEquipmentNO());
	            mMcuVO.setAdminLoginName(mainMcuVO.getLoginName());
	            mMcuVO.setAdminLoginPassword(mainMcuVO.getLoginPassword());
	            mMcuVO.setEquipmentIP(mainVO.getIp());
	            mMcuVO.setCommandIP(mainMcuVO.getCommandIP());
	            mMcuVO.setModelID(mainVO.getEquipmentModel());//add by chenshuo on 3-7
	          //MCU 4000 and MCU 2000 use the same model id
	            if(mainVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
	            	mMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
	            }
	            ZZOConfProfileVO confProfileVO1 = new ZZOConfProfileVO();//模板对象
	            if(mainMDEquipmentVO.getConfProfileID() == null || mainMDEquipmentVO.getConfProfileID().equals("")){
	            	confProfileVO1.setGuid("4");//主会模板ID由前台传值
	            }else{
	            	confProfileVO1.setGuid(mainMDEquipmentVO.getConfProfileID());//主会模板ID由前台传值
	            }
	            //confProfileVO.setGuid(ipProfIdMap.get(innerMcuVO.getEquipmentIP()));
	            mMcuVO.setZzoConfProfileVO(confProfileVO1);
	            mMcuVO.setSubMainVOList(mainTerList);//设置主MCU终端list（包含级联点）
	            ArrayList<ZZOMainVO> innerMcuVOList1 = new ArrayList<ZZOMainVO>();//mainVOList
	            innerMcuVOList1.add(mMcuVO);//所有终端和mcu信息
	            
	            ZZOInterfaceConfVO interfaceConfVO1 = new ZZOInterfaceConfVO();//主会议对象
	            interfaceConfVO1.setConfFlagId(vMeetingDetailVO.getMeetingDetailID());//会议ID
				interfaceConfVO1.setConfName(vMeetingDetailVO.getMeetingName() + mainVO.getEquipmentNO());//会议名字
	            interfaceConfVO1.setConfNumber(masterConfNumber);//modify by chenshuo at 2013-3-12
				interfaceConfVO1.setMasterConf(true);//是否主会
				try{
					interfaceConfVO1.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));//modifyby chenshuo at 2013-3-12
				}catch (Exception e) {
					interfaceConfVO1.setDuration((int)((vMeetingDetailVO.getMeetingEndTime().getTime() - vMeetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60)));
				}
				interfaceConfVO1.setMainVOList(innerMcuVOList1);//
				
				//根据建会模式增加一些设置  add on 2013-4-25 by chenshuo
				if( mcuCascadeModelVO != null ){//
					if( McuControlHelper.personalModel(mcuCascadeModelVO.getConfModel())){//个人模式（主会个人模式）
						interfaceConfVO1.setBroadcaster(mainMeetingRoom.getEquipmentNo());
					}
					if( McuControlHelper.sameScreenModel(mcuCascadeModelVO.getConfModel())){//相同分屏模式(主会相同分屏)
						//TODO:一些对主会相同分屏模式的操作写在这
					}
					if( McuControlHelper.lectureModel(mcuCascadeModelVO.getConfModel())){//演讲者模式(主会演讲者)
						interfaceConfVO1.setLecturer(mainMeetingRoom.getEquipmentNo());
					}
				}
				
				interfaceConfVO1.setOrderNumber(5);//主会后建会
				interfaceConfVOList.add(interfaceConfVO1);
//			}
			List<ZZOResultVO> zzoResultList =  ZZOMcuFactory.getInstance().createConf(interfaceConfVOList);
			return zzoResultList;
	}
	
	/**
	 * 拼接mcu接口需要的终端List集合
	 * @param terminalList
	 * @return
	 */
	private  List<ZZOMainVO>  getRapidInnerTermList(List<MeetingDetailEquipmentVO> terminalList ){
		List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
        for(MeetingDetailEquipmentVO outTerminal : terminalList){
        	 ZZOMainVO innerTerminalVO = new ZZOMainVO();
        	 innerTerminalVO.setEquipmentName(outTerminal.getEquipmentNo());
        	 innerTerminalVO.setEquipmentIP(outTerminal.getEquipmentIP());
        	 innerTerminalVO.setpInterface(outTerminal.getDialingType());
         	 innerTerminalVO.setAliasName(outTerminal.getAliasName());//级联点别名与主MCU建会的会议号一致
         	 innerTerminalVO.setAliasType(outTerminal.getAliasType());
         	 innerTerminalVO.setLineRate(outTerminal.getSpeed());
         	 innerTerminalVO.setMaxResolution(outTerminal.getMaxPesolution());
         	 innerTerminalVO.setVideoProtocol(outTerminal.getVideoAgreementType());
         	 innerTerminalVO.setCascadeRole(outTerminal.getCascadeRole());//级联角色
         	 innerTerminalVO.setAgc(outTerminal.getAgc());
         	 //innerTerminalVO.setServiceName(outTerminal.getNetService());
         	 innerTermList.add(innerTerminalVO);//拼接subMainVOList
        }
        return innerTermList;
	}
	
	private void collectParty(MeetingDetailEquipmentVO mdEquipmentVO, Map<String, List<MeetingDetailEquipmentVO>> mcuPartyList) {
		if(mcuPartyList.get(mdEquipmentVO.getCascadeID()) == null){
			List<MeetingDetailEquipmentVO> mPartyList = new ArrayList<MeetingDetailEquipmentVO>();
			mPartyList.add(mdEquipmentVO);
			mcuPartyList.put(mdEquipmentVO.getCascadeID(), mPartyList);
			return;
		}
		List<MeetingDetailEquipmentVO> mPartyList = mcuPartyList.get(mdEquipmentVO.getCascadeID());
		mPartyList.add(mdEquipmentVO);
		mcuPartyList.put(mdEquipmentVO.getCascadeID(), mPartyList);
		
	}

	private EquipmentMcuVO getEquipmentVO(String id, List<EquipmentMcuVO> equipList){
		for(EquipmentMcuVO equip: equipList){
			if(id.equals(equip.getEquipmentID())){
				return equip;
			}
		}
		return null;
	}
}
