package com.zzst.action.meeting.equipmentControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.centerContor.vo.CenterControlVO;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.initDate.DBHelp;


/**
 *@Description
 *@date 2011-12-21下午01:53:44
 *@author ryan
 */
public class InitEquipmentControlDate {
	
	private static Logger logger = CjfLogger.getLogger(InitEquipmentControlDate.class.getName());
	
	public static void init(){ 
		//中控
//		initCCDBDate();
//		initCenterControl();
//		
//		//终端
//		initTerminalDate();
		
//		//告示
//		initENCDate();
//		//可视通部分
//		initKSTDate();
		
//		//开始检测中控网络情况
//		ControlFactory.startEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL);
//		//开始检测终端网络情况
//		ControlFactory.startEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_TERMINAL);

	}
	
	public static void initCCDBDate(){ 
		ControlFactory.dbInitDate(DBHelp.type_mysql, MeetingAppConfig.DB_USER, MeetingAppConfig.DB_PASSWD, MeetingAppConfig.DB_URL);
	}
	
	
//	public static void initENCDate(){
//		String[] obj = new String[10];
//		obj[0] = MeetingAppConfig.enc_serverIP;
//		obj[1] = MeetingAppConfig.enc_serverName;
//		obj[2] = MeetingAppConfig.enc_serverPas;
//		obj[3] = MeetingAppConfig.enc_db_url;
//		obj[4] = MeetingAppConfig.enc_db_name;
//		obj[5] = MeetingAppConfig.enc_db_password;
//		obj[6] = MeetingAppConfig.enc_db_type;
//		
//		ControlFactory.eNCServerDate(obj);
//	}
	
	/**
	 * 加载可视通信息
	 */
//	public static void initKSTDate(){
//		ArrayList<KstVO> list = new ArrayList<KstVO>();
//		KstVO kstVO = new KstVO();
//		kstVO.setIp(MeetingAppConfig.kst_server_IP);
//		
//		list.add(kstVO);
//		
//		ControlFactory.kstInitDate(list);
//	}
	
	/**
	 * 初始化终端设备
	 */
	public static void initTerminalDate(){
//		logger.info("加载终端个数开始");
		try{
			EquipmentTerminalVO equipmentVO = new EquipmentTerminalVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);//add by ryan 2013-04-28
			ArrayList<EquipmentTerminalVO> equipmentList=ServiceFactory.getEquipmentTerminalService().query(equipmentVO, null);
			
			if(equipmentList!=null)
				logger.info("加载终端个数："+equipmentList.size());	
			else
				logger.info("加载终端个数为空");
			Map<String,String[]> map = new HashMap<String,String[]>();
			for(EquipmentTerminalVO vo : equipmentList){
				String[] s = new String[8];
				s[0] = vo.getIp();
				s[1] = "";
				if(vo.getLoginName() == null){
					s[2] = "";
				}else{
					s[2] = vo.getLoginName();
				}
				if(vo.getLoginPassword() == null){
					s[3] = "";
				}else{
					s[3] = vo.getLoginPassword();
				}
				
				s[4] = "";
				s[5] = "";
				s[6] = "";
				s[7] = "";
				map.put(vo.getIp(), s);
			}
			ControlFactory.terminalInitDate(map);
		}catch(Exception e){
			logger.error("InitEquipmentControlDate	initTerminalDate	error："+e.getMessage());
		}
	}
	
	
	/**
	 * 初始化中控数据
	 */
	public static void initCenterControl(){
		try{
			EquipmentVO equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			ArrayList<EquipmentVO> equipmentList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
 
			ArrayList<CenterControlVO> ccList = new ArrayList<CenterControlVO>();
			for(EquipmentVO vo : equipmentList){
				ccList.add(initCenterControl(vo));
			}
			ControlFactory.centerControlInitDate(ccList);
			 
		}catch(Exception e){
			logger.error("InitEquipmentControlDate	initCenterControl	error："+e.getMessage());
		}
	}
	

	private static CenterControlVO initCenterControl(EquipmentVO vo){
		String name = vo.getMeetingRoomVO().getMeetingRoomName();
		CenterControlVO c = new CenterControlVO();
		c.setId(vo.getEquipmentNO());
		c.setIp(vo.getIp());
		c.setPort(vo.getPort());
		c.setName(name);
		return c;
	}
}
