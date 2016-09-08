package com.zzst.action.meeting.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.MeetingTypeEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;
import com.zzst.service.meeting.baseinfo.BaseInfoService;


/**
 *@Description
 *@date 2012-6-25下午04:58:46
 *@author ryan
 */
public class BaseInfoHelp {
	private static Logger logger = CjfLogger.getLogger(BaseInfoHelp.class.getName());
	
	/**
	 * 读取配置
	 *
	 */
	public static void getConfigInfo(){
		try{
			getSysCon();//系统配置
		}catch(Exception e){
			
		}
		
		try{
			getMcuCon();//mcu模板信息
		}catch(Exception e){
			
		}
		
		try{
			getEmailCon();//加载email信息
		}catch(Exception e){
			
		}
		
//		try{
//			getKstCon();//加载可视通信息
//		}catch(Exception e){
//			
//		}
		
		
//		getMeetingType();//加载会议类型数据字典信息 addby chenshuo
//		getMeetingStatus();//加载会议状态数据字典信息 addby chenshuo
//		getLogType();//加载日志类型数据字典信息 addby chenshuo
//		getMeetingRoomType();//加载会议室类型数据字典信息 addby chenshuo
//		getEquipmentType();//加载设备类型数据字典信息 addby chenshuo
	}
	
	/**
	 * 加载可视通基本信息
	 *
	 */
	public static void getKstCon(){ 
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoType("kst_server");
		try{
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().queryForKstInit(baseInfoVO, null);
			if(list==null||list.size()==0) return ;
			
			for (BaseInfoVO baseInfo : list) {
				if(BaseInfoEnum.TYPE_KST_SERVER_IP.equals(baseInfo.getInfoType())){
					MeetingAppConfig.kst_server_IP = baseInfo.getInfoValue();
				}
			}
		}catch (Exception e) {
			logger.error("提取可视通基本信息异常："+e.getMessage());
		}

	}
	
	/**
	 * 初始化系统邮件
	 *
	 */
	public static void getEmailCon(){
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_EMAIL);
		try{
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if(list==null||list.size()==0) return ;
			
			for (BaseInfoVO baseInfo : list ) {
				if(BaseInfoEnum.EMAIL_ISEFFECT.equals(baseInfo.getDescription())){
					String effect = baseInfo.getInfoValue();
					if(effect!=null&&effect.length()>0&&BaseInfoEnum.EMAIL_ISEFFECT_TRUE.equalsIgnoreCase(effect))
						MeetingAppConfig.mail_status = true;
					else
						MeetingAppConfig.mail_status = false;
				}else if(BaseInfoEnum.EMAIL_ADDRESS.equals(baseInfo.getDescription())){
					MeetingAppConfig.MAIL_ADDRESS=baseInfo.getInfoValue();
				}else if(BaseInfoEnum.EMAIL_SMTP.equals(baseInfo.getDescription())){
					MeetingAppConfig.MAIL_SMTP=baseInfo.getInfoValue();
				}else if(BaseInfoEnum.EMAIL_SMTP_PORT.equals(baseInfo.getDescription())){
					MeetingAppConfig.MAIL_SMTP_PORT=baseInfo.getInfoValue();
				}else if(BaseInfoEnum.EMAIL_USERNAME.equals(baseInfo.getDescription())){
					MeetingAppConfig.MAIL_USERNAME=baseInfo.getInfoValue();
				}else if(BaseInfoEnum.EMAIL_PASSWORD.equals(baseInfo.getDescription())){
					MeetingAppConfig.MAIL_PASSWORD=baseInfo.getInfoValue();
				}else if(BaseInfoEnum.EMAIL_FORMAT.equals(baseInfo.getDescription())){
					MeetingAppConfig.MAIL_FORMAT=baseInfo.getInfoValue();
				}
			}
		}catch(Exception e){
			logger.error("提取邮件基本信息异常："+e.getMessage());
		}
	}
	
	/**
	 * 提取mcu模板信息
	 *
	 */
	public static void getMcuCon(){
		try {
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if (list!=null&&list.size()>0) {
				String[] ids = new String[list.size()];
				String[] names = new String[list.size()];
				Map<String, Map<String, String>> profileMap = new HashMap<String, Map<String, String>>();
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 0; i < list.size(); i++) {
					BaseInfoVO infoVO = list.get(i);
					if(infoVO.getInfoValue()==null||infoVO.getInfoValue().length()==0) continue;
					ids[i] = infoVO.getInfoValue();
					names[i] = infoVO.getDescription();
					
					map.put(infoVO.getInfoName(), infoVO.getInfoValue());
					profileMap.put(infoVO.getInfoValue(), map);
				}
				
				MeetingAppConfig.profileIds = ids;
				MeetingAppConfig.profileNames = names;
				MeetingAppConfig.profileMap = profileMap;
				
//				设置mcu内部标识信息与外面同步
				MCUConfig.RMX2000_EQUIPMENT_MODEL_ID = String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000);
				MCUConfig.RMX2000C_EQUIPMENT_MODEL_ID = String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000C);
				MCUConfig.RMX1000_EQUIPMENT_MODEL_ID = String.valueOf(EquipmentEnum.MODEL_ID_MCU_1000);
				
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 提取系统配置
	 *
	 */
	private static void getSysCon(){
		try {
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO);
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if (list!=null&&list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					BaseInfoVO infoVO = list.get(i);
					if(infoVO.getInfoValue()==null||infoVO.getInfoValue().length()==0) continue;
					
					if (infoVO.getInfoName().equalsIgnoreCase("app_name")) {
						MeetingAppConfig.APP_NAME=infoVO.getInfoValue();continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("copyright")) {
						MeetingAppConfig.COPYRIGHT=infoVO.getInfoValue();continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_end_hour")) {
						MeetingAppConfig.QUERY_VIEW_END_HOUR=Integer.valueOf(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_start_hour")) {
						MeetingAppConfig.QUERY_VIEW_START_HOUR=Integer.valueOf(infoVO.getInfoValue());continue;
//					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_width")) {
//						MeetingAppConfig.STATISTICS_IMAGE_WIDTH=Integer.valueOf(infoVO.getInfoValue());continue;
//					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_height")) {
//						MeetingAppConfig.STATISTICS_IMAGE_HEIGTH=Integer.valueOf(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("task_period_hour")) {
						MeetingAppConfig.TASK_PERIOD_HOUR=infoVO.getInfoValue();continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_count_name")) {
						MeetingAppConfig.STATISTICS_COUNT_NAME=infoVO.getInfoValue();continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_time_name")) {
						MeetingAppConfig.STATISTICS_TIME_NAME=infoVO.getInfoValue();continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_sms_isEffect")) {
						if(BaseInfoEnum.EMAIL_ISEFFECT_TRUE.equals(infoVO.getInfoValue())){
							MeetingAppConfig.sms_status = true;
						}else{
							MeetingAppConfig.sms_status = false;
						}
						continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_billboard_isEffect")) {
						if(BaseInfoEnum.EMAIL_ISEFFECT_TRUE.equals(infoVO.getInfoValue())){
							MeetingAppConfig.billboard_status = true;
						}else{
							MeetingAppConfig.billboard_status = false;
						}
						continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_record_isEffect")) {
						if(BaseInfoEnum.EMAIL_ISEFFECT_TRUE.equals(infoVO.getInfoValue())){
							MeetingAppConfig.record_status = true;
						}else{
							MeetingAppConfig.record_status = false;
						}
						continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_meetingservice_isEffect")) {
						if(BaseInfoEnum.EMAIL_ISEFFECT_TRUE.equals(infoVO.getInfoValue())){
							MeetingAppConfig.meetingservice_status = true;
							
						}else{
							MeetingAppConfig.meetingservice_status = false;
						}
						continue;
					}else if(infoVO.getInfoName().equals("if_callin_or_not") ){//初始化是否允许终端主动呼入
						if( BaseInfoEnum.IF_CALLIN_FALSE.equals(infoVO.getInfoValue())){
							MeetingAppConfig.ifCallInOrNot = false;
						}else{
							MeetingAppConfig.ifCallInOrNot = true;
						}
						continue;
					}else if(infoVO.getInfoName().equals("base_info_billboard_time")){
						MeetingAppConfig.billboard_time = Integer.parseInt(infoVO.getInfoValue());continue;
					}else if(infoVO.getInfoName().equals("meeting_debug_duration")){
//						MeetingAppConfig.MEETING_DEBUG_DURATION = Integer.parseInt(infoVO.getInfoValue());
						MeetingAppConfig.MEETING_DEBUG_DURATION = infoVO.getInfoValue();
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * addby chenshuo
	 * 查询会议类型数据字典
	 * @return 返回数据字典infovalue infoname数组
	 */
	public static String[][] getMeetingType( ){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_MEEITNG_TYPE);
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			int size = list.size();
			String[][] s = new String[size][2];
			for( int i=0; i<list.size(); i++ ){
				s[i][0] = list.get(i).getInfoValue();
				s[i][1] = list.get(i).getInfoName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * addby chenshuo
	 * 查询数据字典是否配置相应的会议类型
	 */
	public static boolean isExistInMeetingType( int meetingType ){
		String[][] meetingTypes = BaseInfoHelp.getMeetingType();
		for( int i=0; i<meetingTypes.length; i++ ){
			if( Integer.parseInt(meetingTypes[i][0]) == meetingType ){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * addby chenshuo
	 * 查询会议状态数据字典
	 * @return 返回数据字典infovalue infoname数组
	 */
	public static String[][] getMeetingStatus( ){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_MEETING_STATUS);
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			int size = list.size();
			String[][] s = new String[size][2];
			for( int i=0; i<list.size(); i++ ){
				s[i][0] = list.get(i).getInfoValue();
				s[i][1] = list.get(i).getInfoName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * addby chenshuo
	 * 查询日志类型数据字典
	 * @return 返回数据字典infovalue infoname数组
	 */
	public static String[][] getLogType(){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_LOG_TYPE);
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			int size = list.size();
			String[][] s = new String[size][2];
			for( int i=0; i<list.size(); i++ ){
				s[i][0] = list.get(i).getInfoValue();
				s[i][1] = list.get(i).getInfoName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * addby tanzanlong
	 * 查询日志类型数据字典
	 * @return 返回数据字典infovalue infoname数组
	 */
	public static String[][] getMeetingControlMenu(){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_MEETINGCONTROL_MENU);
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			int size = list.size();
			String[][] s = new String[size][2];
			for( int i=0; i<list.size(); i++ ){
				s[i][0] = list.get(i).getInfoValue();
				s[i][1] = list.get(i).getInfoName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * addby chenshuo
	 * 查询会议室类型数据字典
	 * @return 返回数据字典infovalue infoname数组
	 */
	public static String[][] getMeetingRoomType(){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_MEEITNGROOM_TYPE);
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			int size = list.size();
			String[][] s = new String[size][2];
			for( int i=0; i<list.size(); i++ ){
				s[i][0] = list.get(i).getInfoValue();
				s[i][1] = list.get(i).getInfoName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[][] getMeetingServiceType(){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_MEETINGSERVICE_TYPE);
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			int size = list.size();
			String[][] s = new String[size][2];
			for( int i=0; i<list.size(); i++ ){
				s[i][0] = list.get(i).getInfoValue();
				s[i][1] = list.get(i).getInfoName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * addby chenshuo
	 * 查询设备类型数据字典
	 * @return 返回数据字典infovalue infoname数组
	 */
	public static String[][] getEquipmentType( ){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE);
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			int size = list.size();
			String[][] s = new String[size][2];
			for( int i=0; i<list.size(); i++ ){
				s[i][0] = list.get(i).getInfoValue();
				s[i][1] = list.get(i).getInfoName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String[][] getEquipmentTypeNew( ){
		DictionaryEquipmentVO dicEquipmentVO = new DictionaryEquipmentVO();
		dicEquipmentVO.setParentID(DateBaseEnum.Default_ID);
		
		try {
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(dicEquipmentVO, null);
			int size = deList.size();
			String[][] s = new String[size][2];
			for( int i=0; i<deList.size(); i++ ){
				s[i][0] = Integer.toString(deList.get(i).getDicValue());
				s[i][1] = deList.get(i).getDicName();
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * addby chenshuo
	 * 页面直接调用
	 * 根据数据字典信息返回数据字典列表项
	 * @param dictionaryType BaseInfoEnum数据字典枚举类
	 * @return
	 */
	public static String listBaseInfoHtmlStr( String dictionaryType ){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(dictionaryType);
		StringBuffer html = new StringBuffer();
	
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			if( BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE.equals(dictionaryType)){
					for( BaseInfoVO bif : list){
						if( EquipmentEnum.TYPE_ID_MCU == Integer.parseInt(bif.getInfoValue())){
							html.append("&nbsp;&nbsp;<a href='/icmp/equipment/mcuBeforAdd.action'>MCU添加</a>");
						}else if( EquipmentEnum.TYPE_ID_TERMINAL == Integer.parseInt(bif.getInfoValue())){
							html.append("&nbsp;&nbsp;<a href='/icmp/equipment/terminalBeforAdd.action'>终端添加</a>");
						}else if( EquipmentEnum.TYPE_ID_CENTERCONTROL == Integer.parseInt(bif.getInfoValue())){
							html.append("&nbsp;&nbsp;<a href='/icmp/equipment/centerControlBeforAdd.action'>中控添加</a>");
							
						}else if( EquipmentEnum.TYPE_ID_VIDEOCARD == Integer.parseInt(bif.getInfoValue())){
								html.append("&nbsp;&nbsp;<a href='/icmp/equipment/centerControlBeforAdd.action'>比对卡添加</a>");
								
							
						}else if( EquipmentEnum.TYPE_ID_ENC == Integer.parseInt(bif.getInfoValue()) ){
							html.append("&nbsp;&nbsp;<a href='/icmp/equipment/noticeBeforAdd.action'>告示添加</a>");
						}else if(  EquipmentEnum.TYPE_ID_QBOX == Integer.parseInt(bif.getInfoValue()) ){
							html.append("&nbsp;&nbsp;<a href='/icmp/equipment/QBoxBeforAdd.action'>QBox添加</a>");
						}else if(  EquipmentEnum.TYPE_ID_MICROPHONE == Integer.parseInt(bif.getInfoValue()) ){
							html.append("&nbsp;&nbsp;<a href='/icmp/equipment/microphoneBeforAdd.action'>话筒添加</a>");
						}
					}
				}else if( BaseInfoEnum.DICTIONARY_MEEITNG_TYPE.equals(dictionaryType) ){
					for( BaseInfoVO bif : list){
						if( MeetingTypeEnum.PLOYCOM_MEETING_NEW == Integer.parseInt(bif.getInfoValue())){
							html.append("&nbsp;&nbsp;<a href='/icmp/detail/vedioAddBefor.action'>视频会议</a>");
						}else if( MeetingTypeEnum.HOST_MEETING_NEW == Integer.parseInt(bif.getInfoValue())){
							html.append("&nbsp;&nbsp;<a href='/icmp/detail/generalAddBefor.action'>本地会议</a>");
						}
					}
				}
			return html.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * addby chenshuo
	 * 根据数据字典配置初始化默认显示页面
	 * @param dictionaryType
	 * @return
	 */
	public static String InitializePage( String dictionaryType ){
		BaseInfoService bis = ServiceFactory.getBaseInfoService();
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setDescription(dictionaryType);
		StringBuffer html = new StringBuffer();
		
		try {
			ArrayList<BaseInfoVO> list =  bis.query(baseInfoVO, null);
			if( list !=null && list.size()>0 ){
				BaseInfoVO bif = list.get(0);
				if( BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE.equals(dictionaryType)){

					if( EquipmentEnum.TYPE_ID_MCU == Integer.parseInt(bif.getInfoValue())){
						html.append("/icmp/equipment/mcuBeforAdd.action");
						return html.toString();
					}else if( EquipmentEnum.TYPE_ID_TERMINAL == Integer.parseInt(bif.getInfoValue())){
						html.append("/icmp/equipment/terminalBeforAdd.action");
						return html.toString();
					}
					else if( EquipmentEnum.TYPE_ID_VIDEOCARD == Integer.parseInt(bif.getInfoValue())){
						html.append("/icmp/equipment/videoCardBeforeAdd.action");
						return html.toString();
					}
					
					else if( EquipmentEnum.TYPE_ID_CENTERCONTROL == Integer.parseInt(bif.getInfoValue())){
						html.append("/icmp/equipment/centerControlBeforAdd.action");
						return html.toString();
					}else if( EquipmentEnum.TYPE_ID_ENC == Integer.parseInt(bif.getInfoValue()) ){
						html.append("/icmp/equipment/noticeBeforAdd.action");
						return html.toString();
					}else if(  EquipmentEnum.TYPE_ID_QBOX == Integer.parseInt(bif.getInfoValue()) ){
						html.append("/icmp/equipment/QBoxBeforAdd.action");
						return html.toString();
					}else{
						if( list.size()>1 ){
							BaseInfoVO bif1 = list.get(1);
							if( EquipmentEnum.TYPE_ID_MCU == Integer.parseInt(bif1.getInfoValue())){
								html.append("/icmp/equipment/mcuBeforAdd.action");
								return html.toString();
							}else if( EquipmentEnum.TYPE_ID_TERMINAL == Integer.parseInt(bif1.getInfoValue())){
								html.append("/icmp/equipment/terminalBeforAdd.action");
								return html.toString();
							}
							else if( EquipmentEnum.TYPE_ID_VIDEOCARD == Integer.parseInt(bif1.getInfoValue())){
								html.append("/icmp/equipment/videoCardBeforeAdd.action");
								return html.toString();
							}
							else if( EquipmentEnum.TYPE_ID_CENTERCONTROL == Integer.parseInt(bif1.getInfoValue())){
								html.append("/icmp/equipment/centerControlBeforAdd.action");
								return html.toString();
							}else if( EquipmentEnum.TYPE_ID_ENC == Integer.parseInt(bif1.getInfoValue()) ){
								html.append("/icmp/equipment/noticeBeforAdd.action");
								return html.toString();
							}else if(  EquipmentEnum.TYPE_ID_QBOX == Integer.parseInt(bif1.getInfoValue()) ){
								html.append("/icmp/equipment/QBoxBeforAdd.action");
								return html.toString();
							}
						}else{
							html.append("/icmp/meeting/equipment/noEquipment.jsp");
							return html.toString();
						}
					}
				
				}else if( BaseInfoEnum.DICTIONARY_MEEITNG_TYPE.equals(dictionaryType)){
					if( MeetingTypeEnum.PLOYCOM_MEETING_NEW == Integer.parseInt(bif.getInfoValue())){
						html.append("/icmp/detail/vedioAddBefor.action");
						return html.toString();
					}else if( MeetingTypeEnum.HOST_MEETING_NEW == Integer.parseInt(bif.getInfoValue())){
						html.append("/icmp/detail/generalAddBefor.action");
						return html.toString();
					}else{
						html.append("/icmp/meeting/equipment/noEquipment.jsp");
						return html.toString();
					}
				}	
			}else{
				html.append("/icmp/meeting/equipment/noEquipment.jsp");
				return html.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
