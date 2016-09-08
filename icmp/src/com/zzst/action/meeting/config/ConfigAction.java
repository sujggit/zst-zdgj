package com.zzst.action.meeting.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.equipmentControl.InitEquipmentControlDate;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.CenterControlEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.meeting.centerControl.CenterControlVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.config.ConfigVO;
import com.zzst.model.meeting.configTcip.ConfigTcipVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.mailConfig.MailConfigVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class ConfigAction extends CjfAction {
	
	private static final long serialVersionUID = 1L;
	
	private ConfigVO configVO = new ConfigVO();
	
	private InputStream  excelStream;
	
	private CenterControlVO centerControlVO = new CenterControlVO();
	
	private  ArrayList<CenterControlVO> ccList = new ArrayList<CenterControlVO>();
	
	private static Logger logger = CjfLogger.getLogger(ConfigAction.class.getName());
	
	private int type;
	
	private ConfigTcipVO configTcipVO1 = new ConfigTcipVO();
	
	private ConfigTcipVO configTcipVO2 = new ConfigTcipVO();
	
	private MailConfigVO mailConfigVO = new MailConfigVO();
	

	/**
	 * 
	 * author:tanzanlong
	 * 中控配置导出功能
	 * @return
	 */
	public String centerControlInfoExportQuery(){
		logger.info("ConfigAction	centerControlInfoExportQuery	begin");
		try{
			ccList=ServiceFactory.getCenterControlService().query(centerControlVO, null);
			
			String fileName = "centerControlInfo.xls";
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头	
		
			if(ccList!=null&&ccList.size()>0){
						
				for (int i = 0; i < ccList.size(); i++) {
					CenterControlVO lVO = ccList.get(i);
					CellVO[] cell = new CellVO[5];
					CellVO ex0 = new CellVO();
					ex0.setValue((i+1)+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getEquipmentName());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(lVO.getCcIP());
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					for(String[] s : CenterControlEnum.getEquipmentType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getEquipmentType()+"")){
							 ex3.setValue(s[1]);
							 continue;
						 }
					}
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getCcNO());
					cell[4] = ex4;
					
					
					list.add(cell);
					
				}
				
			}
			
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("ConfigAction	centerControlInfoExportQuery 	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("ConfigAction	centerControlInfoExportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[5];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备名称");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("中控IP");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备类型");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备编号");
		cellTitle[4] = ex0;
		list.add(cellTitle);
	}
	
	
	
	/**
	 * 获取配置的基本信息
	 * @return 操作结果信息
	 * @author 杨屹
	 */
	public String getConfigInfo(){
		if( MCUConfig.IS_AUTO_MCUE_WHEN_PTS_CONNECTED ){//传递给页面判断是否勾中静音
			configVO.setAutoMute(MeetingAppConfig.AUTO_MUTE);
		}
		if(MeetingAppConfig.mail_status){
			configVO.setEmail(true);
		}
		
		if(MeetingAppConfig.sms_status){
			configVO.setSms(true);
		}
		
		if(MeetingAppConfig.meetingservice_status){
			configVO.setMeetingbook_service(true);
		}
		
		if(MeetingAppConfig.record_status){
			configVO.setRecord(true);
		}
		if(MeetingAppConfig.billboard_status){
			configVO.setBillboard(true);
		}
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		try {
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO);
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if (list!=null&&list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					BaseInfoVO infoVO = list.get(i);
					if(infoVO.getInfoValue()==null||infoVO.getInfoValue().length()==0) continue;
					
					if (infoVO.getInfoName().equalsIgnoreCase("app_name")) {
						configVO.setAppName(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("copyright")) {
						configVO.setCopyright(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_end_hour")) {
						configVO.setqUERY_VIEW_END_HOUR(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_start_hour")) {
						configVO.setqUERY_VIEW_START_HOUR(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_width")) {
						configVO.setsTATISTICS_IMAGE_WIDTH(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_height")) {
						configVO.setsTATISTICS_IMAGE_HEIGTH(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("task_period_hour")) {
						configVO.settASK_PERIOD_HOUR(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_count_name")) {
						configVO.setsTATISTICS_COUNT_NAME(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_time_name")) {
						configVO.setsTATISTICS_TIME_NAME(infoVO.getInfoValue());continue;
					}else if(infoVO.getInfoName().equalsIgnoreCase("if_callin_or_not")){
						if( infoVO.getInfoValue().equals(BaseInfoEnum.IF_CALLIN_FALSE)){
							configVO.setIfcallin(false);
						}else{
							configVO.setIfcallin(true);
						}
						continue;
					}else if(infoVO.getInfoName().equalsIgnoreCase("base_info_billboard_time")){
						configVO.setBillboardTime(Integer.parseInt(infoVO.getInfoValue()));continue;
					}else if(infoVO.getInfoName().equalsIgnoreCase("meeting_debug_duration")){
//						configVO.setMeetingDebugDuration(Integer.parseInt(infoVO.getInfoValue()));
						configVO.setMeetingDebugDuration(infoVO.getInfoValue());
					}else if(infoVO.getInfoName().equalsIgnoreCase(BaseInfoEnum.IF_OPENLOG)){
						if( infoVO.getInfoValue().equals(BaseInfoEnum.IF_OPENLOG_FALSE)){
							configVO.setIfOpenLog(false);
						}else{
							configVO.setIfOpenLog(true);
						}
						continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 发布管理中，修改系统基本配置
	 * @return
	 */
	public String getSysConfigInfo(){
	
		if( MCUConfig.IS_AUTO_MCUE_WHEN_PTS_CONNECTED ){//传递给页面判断是否勾中静音
			configVO.setAutoMute(MeetingAppConfig.AUTO_MUTE);
		}
		
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		try {
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO);
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if (list!=null&&list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					BaseInfoVO infoVO = list.get(i);
					if(infoVO.getInfoValue()==null||infoVO.getInfoValue().length()==0) continue;
					
					if (infoVO.getInfoName().equalsIgnoreCase("app_name")) {
						configVO.setAppName(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_end_hour")) {
						configVO.setqUERY_VIEW_END_HOUR(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_start_hour")) {
						configVO.setqUERY_VIEW_START_HOUR(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_width")) {
						configVO.setsTATISTICS_IMAGE_WIDTH(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_height")) {
						configVO.setsTATISTICS_IMAGE_HEIGTH(Integer.valueOf(infoVO.getInfoValue()));continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("task_period_hour")) {
						configVO.settASK_PERIOD_HOUR(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_count_name")) {
						configVO.setsTATISTICS_COUNT_NAME(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_time_name")) {
						configVO.setsTATISTICS_TIME_NAME(infoVO.getInfoValue());continue;
					}else if (infoVO.getInfoName().equalsIgnoreCase("copyright")) {
						configVO.setCopyright(infoVO.getInfoValue());continue;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String modifySysConfig(){
		try {
			type = 1; //修改系统名称
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO);
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if (list!=null&&list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					BaseInfoVO infoVO = list.get(i);
					if (infoVO.getInfoName().equalsIgnoreCase("app_name")) {
						infoVO.setInfoValue(configVO.getAppName());
					}
					/*else if (infoVO.getInfoName().equalsIgnoreCase("query_view_end_hour")) {
						infoVO.setInfoValue(configVO.getqUERY_VIEW_END_HOUR()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_start_hour")) {
						infoVO.setInfoValue(configVO.getqUERY_VIEW_START_HOUR()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_width")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_IMAGE_WIDTH()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_height")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_IMAGE_HEIGTH()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("task_period_hour")) {
						infoVO.setInfoValue(configVO.gettASK_PERIOD_HOUR());
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_count_name")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_COUNT_NAME());
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_time_name")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_TIME_NAME());
					}else if (infoVO.getInfoName().equalsIgnoreCase("copyright")) {
						infoVO.setInfoValue(configVO.getCopyright()+"");
					}*/
					ServiceFactory.getBaseInfoService().modify(infoVO);
				}
			}
			if( configVO.getAutoMute() == MeetingAppConfig.AUTO_MUTE){//终端呼入后是否需要静音
				MCUConfig.IS_AUTO_MCUE_WHEN_PTS_CONNECTED = true;
			}else{
				MCUConfig.IS_AUTO_MCUE_WHEN_PTS_CONNECTED = false;
			}
			refreshAppConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 修改内存中配置的基本信息，并将其写入相应的XML文件
	 * @return 操作结果信息
	 * @author 杨屹
	 */
	public String modifyConfig(){
		try {
			type = 2;	//修改系统配置
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO);
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_EMAIL);
			ArrayList<BaseInfoVO> list1= ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			
			
			
			for(BaseInfoVO biVO : list1){
				if(BaseInfoEnum.EMAIL_ISEFFECT.equals(biVO.getDescription())){
					if(configVO.isEmail()){
						biVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_TRUE);
					}else{
						biVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_FALSE);
					}
					ServiceFactory.getBaseInfoService().modify(biVO);
				}
			}
			if (list!=null&&list.size()>0) {
				for (int i = 0; i < list.size(); i++) {
					BaseInfoVO infoVO = list.get(i);
					/*if (infoVO.getInfoName().equalsIgnoreCase("app_name")) {
						infoVO.setInfoValue(configVO.getAppName());
					}else if (infoVO.getInfoName().equalsIgnoreCase("copyright")) {
						infoVO.setInfoValue(configVO.getCopyright()+"");
					}else */
					if (infoVO.getInfoName().equalsIgnoreCase("query_view_end_hour")) {
						infoVO.setInfoValue(configVO.getqUERY_VIEW_END_HOUR()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("query_view_start_hour")) {
						infoVO.setInfoValue(configVO.getqUERY_VIEW_START_HOUR()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_width")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_IMAGE_WIDTH()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_image_height")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_IMAGE_HEIGTH()+"");
					}else if (infoVO.getInfoName().equalsIgnoreCase("task_period_hour")) {
						infoVO.setInfoValue(configVO.gettASK_PERIOD_HOUR());
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_count_name")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_COUNT_NAME());
					}else if (infoVO.getInfoName().equalsIgnoreCase("statistics_time_name")) {
						infoVO.setInfoValue(configVO.getsTATISTICS_TIME_NAME());
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_sms_isEffect")){
						if(configVO.isSms()){
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_TRUE);
						}else{
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_FALSE);
						}
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_record_isEffect")){
						if(configVO.isRecord()){
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_TRUE);
						}else{
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_FALSE);
						}
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_billboard_isEffect")){
						if(configVO.isBillboard()){
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_TRUE);
						}else{
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_FALSE);
						}
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_meetingservice_isEffect")){
						if(configVO.isMeetingbook_service()){
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_TRUE);
						}else{
							infoVO.setInfoValue(BaseInfoEnum.EMAIL_ISEFFECT_FALSE);
						}
					}else if (infoVO.getInfoName().equalsIgnoreCase("if_callin_or_not")){
						if(configVO.isIfcallin()){
							infoVO.setInfoValue(BaseInfoEnum.IF_CALLIN_TRUE);
						}else{
							infoVO.setInfoValue(BaseInfoEnum.IF_CALLIN_FALSE);
						}
					}else if (infoVO.getInfoName().equalsIgnoreCase("base_info_billboard_time")){
						infoVO.setInfoValue(Integer.toString(configVO.getBillboardTime()));
					}else if (infoVO.getInfoName().equalsIgnoreCase("meeting_debug_duration")){
//						infoVO.setInfoValue(Integer.toString(configVO.getMeetingDebugDuration()));
						infoVO.setInfoValue(configVO.getMeetingDebugDuration());
					}else if (infoVO.getInfoName().equalsIgnoreCase(BaseInfoEnum.IF_OPENLOG)){
						if(configVO.isIfOpenLog()){
							infoVO.setInfoValue(BaseInfoEnum.IF_OPENLOG_TRUE);
						}else{
							infoVO.setInfoValue(BaseInfoEnum.IF_OPENLOG_FALSE);
						}
					}
					ServiceFactory.getBaseInfoService().modify(infoVO);
				}
			}
			if( configVO.getAutoMute() == MeetingAppConfig.AUTO_MUTE){//终端呼入后是否需要静音
				MCUConfig.IS_AUTO_MCUE_WHEN_PTS_CONNECTED = true;
			}else{
				MCUConfig.IS_AUTO_MCUE_WHEN_PTS_CONNECTED = false;
			}
			
			
			refreshAppConfig();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	private void refreshAppConfig(){
		if(type ==1){
		MeetingAppConfig.APP_NAME = configVO.getAppName();
		MeetingAppConfig.COPYRIGHT = configVO.getCopyright();
		}else{
		MeetingAppConfig.QUERY_VIEW_END_HOUR = configVO.getqUERY_VIEW_END_HOUR();
		MeetingAppConfig.QUERY_VIEW_START_HOUR = configVO.getqUERY_VIEW_START_HOUR();
		//MeetingAppConfig.STATISTICS_IMAGE_WIDTH = configVO.getsTATISTICS_IMAGE_WIDTH();
		//MeetingAppConfig.STATISTICS_IMAGE_HEIGTH = configVO.getsTATISTICS_IMAGE_HEIGTH();
		MeetingAppConfig.TASK_PERIOD_HOUR = configVO.gettASK_PERIOD_HOUR();
		MeetingAppConfig.STATISTICS_COUNT_NAME = configVO.getsTATISTICS_COUNT_NAME();
		MeetingAppConfig.STATISTICS_TIME_NAME = configVO.getsTATISTICS_TIME_NAME();
		MeetingAppConfig.meetingservice_status = configVO.isMeetingbook_service();
		MeetingAppConfig.sms_status = configVO.isSms();
		MeetingAppConfig.billboard_status = configVO.isBillboard();
		MeetingAppConfig.record_status = configVO.isRecord();
		MeetingAppConfig.mail_status = configVO.isEmail();
		MeetingAppConfig.ifCallInOrNot = configVO.isIfcallin();
		MeetingAppConfig.billboard_time = configVO.getBillboardTime();
		MeetingAppConfig.MEETING_DEBUG_DURATION = configVO.getMeetingDebugDuration();
		}
	}

	/***
	 * 查询中控配置列表
	 * 
	 * @param 
	 * @author yangyi
	 */
	public String getCenterControlList(){
		try {
			EquipmentVO equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			ArrayList<EquipmentVO> ccEquipmentList = ServiceFactory.getEquipmentService().query(
					equipmentVO, null);
			this.getCurHttpServletRequest().setAttribute("ccEquipmentList", ccEquipmentList);
			ccList = ServiceFactory.getCenterControlService().query(centerControlVO, getPageControler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/***
	 * 根据ID查询中控配置详情(查看)
	 * 
	 * @param 
	 * @author yangyi
	 */
	public String getCenterControlInfo(){
		String ccID = centerControlVO.getId();
		try {
			centerControlVO = ServiceFactory.getCenterControlService().queryByID(ccID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/***
	 * 根据ID查询中控配置详情(修改)
	 * 
	 * @param 
	 * @author yangyi
	 */
	public String modifyCenterControlInfoBefore(){
		String ccID = centerControlVO.getId();
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		ArrayList<EquipmentVO>  ccEquipmentList=null;
		try {
			centerControlVO = ServiceFactory.getCenterControlService().queryByID(ccID);
			ccEquipmentList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getCurHttpServletRequest().setAttribute("ccEquipmentList", ccEquipmentList);
		return "success";
	}
	
	/***
	 * 根据ID查询中控配置详情(复制)
	 * 
	 * @param 
	 * @author ljf
	 */
	public String copyCenterControlInfoBefore(){
		String ccID = centerControlVO.getId();
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		ArrayList<EquipmentVO>  ccEquipmentList=null;
		try {
			centerControlVO = ServiceFactory.getCenterControlService().queryByID(ccID);
			ccEquipmentList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getCurHttpServletRequest().setAttribute("ccEquipmentList", ccEquipmentList);
		return "success";
	}
	
	/***
	 * 根据ID修改中控配置详情
	 * 
	 * @param 
	 * @author yangyi
	 */
	public String modifyCenterControlInfo(){
		try {
			ServiceFactory.getCenterControlService().modify(centerControlVO);
			
			EquipmentVO equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentVO.setIp(centerControlVO.getCcIP());
			ArrayList<EquipmentVO> equipmentList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			ArrayList<com.zzst.centerContor.vo.CenterControlVO> ccList = new ArrayList<com.zzst.centerContor.vo.CenterControlVO>();
			for(EquipmentVO vo : equipmentList){
				ccList.add(initCenterControl(vo));
			}
			ControlFactory.centerControlInitDate(ccList);
//			InitEquipmentControlDate.initCenterControl();//同步缓存
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		centerControlVO = new CenterControlVO();
		return "success";
	}
	
	private com.zzst.centerContor.vo.CenterControlVO initCenterControl(EquipmentVO vo){
		String name = vo.getMeetingRoomVO().getMeetingRoomName();
		com.zzst.centerContor.vo.CenterControlVO c = new com.zzst.centerContor.vo.CenterControlVO();
		c.setId(vo.getEquipmentNO());
		c.setIp(vo.getIp());
		c.setPort(vo.getPort());
		c.setName(name);
		return c;
	}
	/***
	 * 新增中控配置信息(前)
	 * 
	 * @param 
	 * @author yangyi
	 */
	public String addCenterControlInfoBefore(){
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
		ArrayList<EquipmentVO>  ccEquipmentList=null;
		try {
			ccEquipmentList = ServiceFactory.getEquipmentService().query(
					equipmentVO, null);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		this.getCurHttpServletRequest().setAttribute("ccEquipmentList", ccEquipmentList);
		return "success";
	}
	
	/***
	 * 新增中控配置信息
	 * 
	 * @param 
	 * @author yangyi
	 */
	public String addCenterControlInfo(){
		try {
			ServiceFactory.getCenterControlService().add(centerControlVO);
			
			EquipmentVO equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentVO.setIp(centerControlVO.getCcIP());
			ArrayList<EquipmentVO> equipmentList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			ArrayList<com.zzst.centerContor.vo.CenterControlVO> ccList = new ArrayList<com.zzst.centerContor.vo.CenterControlVO>();
			for(EquipmentVO vo : equipmentList){
				ccList.add(initCenterControl(vo));
			}
			/**
			 * 同步中控数据的优化	add	 by	ryan	20140221
			 */
			ControlFactory.centerControlInitDate(ccList);	
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		centerControlVO = new CenterControlVO();
//		InitEquipmentControlDate.initCenterControl();//同步缓存
		return "success";
	}
	
	/***
	 * 删除中控配置信息
	 * 
	 * @param 
	 * @author yangyi
	 */
	public String delCenterControlInfo(){
		String ccID = centerControlVO.getId();
		try {
			CenterControlVO evo = ServiceFactory.getCenterControlService().queryByID(ccID);
			
			ServiceFactory.getCenterControlService().deleteByID(ccID);
			
			EquipmentVO	equipmentVO = new EquipmentVO();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
			equipmentVO.setIp(evo.getCcIP());
			ArrayList<EquipmentVO> equipmentList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			
			ArrayList<com.zzst.centerContor.vo.CenterControlVO> ccList = new ArrayList<com.zzst.centerContor.vo.CenterControlVO>();
			for(EquipmentVO vo : equipmentList){
				ccList.add(initCenterControl(vo));
			}
			ControlFactory.centerControlInitDate(ccList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		centerControlVO = new CenterControlVO();
		/**
		 * 同步中控数据的优化add 20130313
		 */
//		InitEquipmentControlDate.initCenterControl();//同步缓存
		return "success";
	}
	
	/**
	 * 获取邮件、短信、告示配置
	 * @return
	 */
	public String getNoticeConfig(){
		logger.info("ConfigAction  getNoticeConfig begin.");
		try {
			if(MeetingAppConfig.mail_status){
				configVO.setEmail(true);
			}
			if(MeetingAppConfig.sms_status){
				configVO.setSms(true);
			}
			if(MeetingAppConfig.billboard_status){
				configVO.setBillboard(true);
			}
			List<ConfigTcipVO> list = ServiceFactory.getConfigTcipService().query(configTcipVO1, null);
			for(int i=0;i<list.size();i++){
				if("DX".equals(list.get(i).getPortsName())){
					configTcipVO1 = list.get(i);
				}else if("GS".equals(list.get(i).getPortsName())){
					configTcipVO2 = list.get(i);
				}
			}
			List<MailConfigVO> list2 = ServiceFactory.getMailConfigService().query(mailConfigVO, null);
			if(list2!=null&&list2.size()>0){
				mailConfigVO = list2.get(0);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
		logger.info("ConfigAction  getNoticeConfig  end");
		return SUCCESS;
	}
	
	public String modifyNoticeConfig(){
		logger.info("ConfigAction modifyNoticeConfig begin");
		try {
			int dxId = configTcipVO1.getId();
			String dxAddress = configTcipVO1.getAddress();
			String dxName = configTcipVO1.getName();
			String dxPassword = configTcipVO1.getPassword();
			
			int gsId = configTcipVO2.getId();
			String gsAddress = configTcipVO2.getAddress();
			String gsName = configTcipVO2.getName();
			String gsPassword = configTcipVO2.getPassword();
			
			int mailId = mailConfigVO.getId();
			String mailSmtp = mailConfigVO.getMailSmtp();
			String mailName = mailConfigVO.getMailName();
			String mailPass = mailConfigVO.getMailPass();
			
			if(MeetingAppConfig.mail_status){//邮箱
				configVO.setEmail(true);
				if(mailId!=Integer.MIN_VALUE){
				ServiceFactory.getMailConfigService().deleteByID(mailId);
				}
				MailConfigVO mailVO = new MailConfigVO();
				mailVO.setMailSmtp(mailSmtp);
				mailVO.setMailName(mailName);
				mailVO.setMailPass(mailPass);
				ServiceFactory.getMailConfigService().add(mailVO);
			}
			if(MeetingAppConfig.sms_status){//短信
				configVO.setSms(true);
				if(dxId!=Integer.MIN_VALUE){
					ServiceFactory.getConfigTcipService().deleteByID(dxId);
				}
				ConfigTcipVO cftVO = new ConfigTcipVO();
				cftVO.setId(2);
				cftVO.setAddress(dxAddress);
				cftVO.setName(dxName);
				cftVO.setPassword(dxPassword);
				cftVO.setPortsName("DX");
				cftVO.setStatus(1);
				ServiceFactory.getConfigTcipService().add(cftVO);
				
			}
			if(MeetingAppConfig.billboard_status){//告示
				configVO.setBillboard(true);
				if(gsId!=Integer.MIN_VALUE){
					ServiceFactory.getConfigTcipService().deleteByID(gsId);
				}
				ConfigTcipVO gsVO = new ConfigTcipVO();
				gsVO.setId(1);
				gsVO.setAddress(gsAddress);
				gsVO.setName(gsName);
				gsVO.setPassword(gsPassword);
				gsVO.setPortsName("GS");
				gsVO.setStatus(1);
				ServiceFactory.getConfigTcipService().add(gsVO);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		logger.info("ConfigAction modifyNoticeConfig end");
		this.getCurHttpServletRequest().setAttribute("info", "保存成功！");
		return SUCCESS;
	}
	
	public void setConfigVO(ConfigVO configVO) {
		this.configVO = configVO;
	}

	public ConfigVO getConfigVO() {
		return configVO;
	}

	public void setCenterControlVO(CenterControlVO centerControlVO) {
		this.centerControlVO = centerControlVO;
	}

	public CenterControlVO getCenterControlVO() {
		return centerControlVO;
	}

	public void setCcList(ArrayList<CenterControlVO> ccList) {
		this.ccList = ccList;
	}

	public ArrayList<CenterControlVO> getCcList() {
		return ccList;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public void setConfigTcipVO1(ConfigTcipVO configTcipVO1) {
		this.configTcipVO1 = configTcipVO1;
	}

	public ConfigTcipVO getConfigTcipVO1() {
		return configTcipVO1;
	}

	public void setConfigTcipVO2(ConfigTcipVO configTcipVO2) {
		this.configTcipVO2 = configTcipVO2;
	}

	public ConfigTcipVO getConfigTcipVO2() {
		return configTcipVO2;
	}

	public void setMailConfigVO(MailConfigVO mailConfigVO) {
		this.mailConfigVO = mailConfigVO;
	}

	public MailConfigVO getMailConfigVO() {
		return mailConfigVO;
	}
	
}
