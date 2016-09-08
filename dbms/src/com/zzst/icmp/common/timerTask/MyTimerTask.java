package com.zzst.icmp.common.timerTask;

import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.common.hibernate.db.FarHibernateSessionFactory;
import com.common.hibernate.db.HibernateSessionFactory;
import com.zzst.icmp.ControlFactoryHelp;
import com.zzst.icmp.entity.ZTAddress;
import com.zzst.icmp.entity.ZTDeleteinfo;
import com.zzst.icmp.entity.ZTDepartment;
import com.zzst.icmp.entity.ZTDepartmentUser;
import com.zzst.icmp.entity.ZTDepartmentUserId;
import com.zzst.icmp.entity.ZTDictionary;
import com.zzst.icmp.entity.ZTEquipment;
import com.zzst.icmp.entity.ZTEquipmentBackup;
import com.zzst.icmp.entity.ZTEquipmentBackupId;
import com.zzst.icmp.entity.ZTEquipmentDictionary;
import com.zzst.icmp.entity.ZTEquipmentGroup;
import com.zzst.icmp.entity.ZTEquipmentMaintain;
import com.zzst.icmp.entity.ZTEquipmentMcu;
import com.zzst.icmp.entity.ZTEquipmentMcuPool;
import com.zzst.icmp.entity.ZTEquipmentTerminal;
import com.zzst.icmp.entity.ZTFunction;
import com.zzst.icmp.entity.ZTInformation;
import com.zzst.icmp.entity.ZTLevel;
import com.zzst.icmp.entity.ZTLevelConfig;
import com.zzst.icmp.entity.ZTLevelConfigId;
import com.zzst.icmp.entity.ZTLog;
import com.zzst.icmp.entity.ZTMcucascademodel;
import com.zzst.icmp.entity.ZTMeetingdetail;
import com.zzst.icmp.entity.ZTMeetingdetailCost;
import com.zzst.icmp.entity.ZTMeetingdetailDepartment;
import com.zzst.icmp.entity.ZTMeetingdetailDepartmentId;
import com.zzst.icmp.entity.ZTMeetingdetailEquipment;
import com.zzst.icmp.entity.ZTMeetingdetailRoom;
import com.zzst.icmp.entity.ZTMeetingdetailRoomId;
import com.zzst.icmp.entity.ZTMeetingdetailUser;
import com.zzst.icmp.entity.ZTMeetingdetailUserId;
import com.zzst.icmp.entity.ZTMeetingroom;
import com.zzst.icmp.entity.ZTMeetingroomEquipment;
import com.zzst.icmp.entity.ZTMeetingroomEquipmentId;
import com.zzst.icmp.entity.ZTPollTemplate;
import com.zzst.icmp.entity.ZTPollTerminal;
import com.zzst.icmp.entity.ZTPost;
import com.zzst.icmp.entity.ZTPubCentercontrol;
import com.zzst.icmp.entity.ZTRole;
import com.zzst.icmp.entity.ZTRoleFunc;
import com.zzst.icmp.entity.ZTRoleFuncId;
import com.zzst.icmp.entity.ZTTemplate;
import com.zzst.icmp.entity.ZTTemplateEquipment;
import com.zzst.icmp.entity.ZTTemplateEquipmentGroup;
import com.zzst.icmp.entity.ZTTemplateMeeting;
import com.zzst.icmp.entity.ZTUser;
import com.zzst.icmp.entity.ZTUserPost;
import com.zzst.icmp.entity.ZTUserRole;
import com.zzst.icmp.entity.ZTUserRoleId;

/**
 * 更新与自己节点相关的，最后更新时间之后的数据
 * @author zhangdq
 *
 */
public class MyTimerTask extends TimerTask {
	private static Logger logger = Logger.getLogger(MyTimerTask.class.getName());
	
	private static Timestamp nowTime;
	private static Timestamp lastTime;
	private static String userIDs;
	private static String roomIDs;
	private static Session parentSession;
	private static Session localSession;
	private static Transaction parentTX ;
	private static Transaction localTX ;
	
	
	@Override
	public void run() {
		logger.info("节点ID"+CommonHelp.nodeID+" 开始同步");
		nowTime = new Timestamp(System.currentTimeMillis());
		lastTime = CommonHelp.getUpdateLastTime();
		CommonHelp.STATUS_UPDATING = true;
		if(lastTime ==null) return;
		boolean dbConnect =false;
		try{
			if(ControlFactoryHelp.far_db_datasource.indexOf("mysql")>=0){
				DriverManager.registerDriver (new com.mysql.jdbc.Driver());
				DriverManager.getConnection(ControlFactoryHelp.far_db_datasource,ControlFactoryHelp.far_db_name,ControlFactoryHelp.far_db_password);
		
				DriverManager.getConnection(ControlFactoryHelp.local_db_datasource,ControlFactoryHelp.local_db_name,ControlFactoryHelp.local_db_password);
		
				dbConnect = true;
			}else
				logger.warn("目前只支持mysql数据库！");
		}catch(Exception e){}
		
		if(!dbConnect) {
			logger.info("数据库链接异常，此次同步失败！");
			return;
		}
		
		parentSession	=FarHibernateSessionFactory.getSessionFactory().openSession();
		localSession	=HibernateSessionFactory.getSessionFactory().openSession();
		parentTX		= parentSession.beginTransaction();
		localTX			= localSession.beginTransaction();
		
		pubGetUserIDs();
		pubGetRoomIDs();
//		userIDs = "8a8188b5425092af01425094449d0001";
//		roomIDs ="8a8185f24521e5b0014521e6c92a0004";
//		lastTime = new Timestamp(System.currentTimeMillis()-777777777);
		
		
		
		//单表同步
		
		z_t_department();
		z_t_department_user("");
		
		parentTX.commit();
		localTX.commit();
		
		parentSession.close();
		localSession.close();
		
//		try {
//			Thread.sleep(1*1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		parentSession	=FarHibernateSessionFactory.getSessionFactory().openSession();
		localSession	=HibernateSessionFactory.getSessionFactory().openSession();
		parentTX		= parentSession.beginTransaction();
		localTX			= localSession.beginTransaction();
		
		//公用表部分的同步
		z_t_level();
		z_t_level_config();
		//单表同步
		String userIDs = z_t_user();//用户表
		z_t_post();//岗位表
		z_t_user_post();//用户-岗位表
		z_t_role();//角色表
		z_t_function();//功能表
		z_t_role_func();//角色-功能表
		z_t_user_role();//用户-角色表
		z_t_meetingroom();//会议室表
		z_t_meetingroom_equipment();//会议室-设备表
		String meetingdetailIDs = z_t_meetingdetail();//会议表
		z_t_meetingdetail_cost(meetingdetailIDs);//会议-费用表
		z_t_meetingdetail_department(meetingdetailIDs);//会议-部门表
		z_t_meetingdetail_equipment(meetingdetailIDs);//会议-设备表
		z_t_meetingdetail_room(meetingdetailIDs);//会议-会议室表
		z_t_meetingdetail_user(meetingdetailIDs);//会议-人员表
		z_t_address();//地址表
		z_t_dictionary();//配置表
		z_t_information();//告警信息表
//		z_t_log();//日志表
		String equipmentIDs = z_t_equipment();
		z_t_equipment_mcu(equipmentIDs);
		z_t_equipment_Terminal(equipmentIDs);
		z_t_equipment_Maintain(equipmentIDs);
		z_t_equipment_group(equipmentIDs);
		z_t_equipment_dictionary();
		z_t_equipment_backup(equipmentIDs);
		z_t_equipment_mcu_pool(equipmentIDs);
		
		z_t_template();
		z_t_template_meeting();
		z_t_template_equipment_group();
		z_t_template_equipment();

		z_t_pub_centercontrol(equipmentIDs);
		z_t_poll_template(equipmentIDs);
		z_t_poll_terminal(equipmentIDs);
		z_t_mcucascademodel(equipmentIDs);
		
		
		CommonHelp.updateLastTime(nowTime);
		CommonHelp.STATUS_UPDATING = false;
		parentTX.commit();
		localTX.commit();
		parentSession.close();
		localSession.close();
		logger.info("节点ID："+CommonHelp.nodeID+" 同步完成");
	}

	public static void main(String[] args) {
		PropertyConfigurator.configure("./src/applog4j.properties");//加载.properties文件
		new MyTimerTask().run();
	}
	
	/**
	 * 全部更新
	 */
	private static void z_t_mcucascademodel(String equipmentIDs){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMcucascademodel> parentList = pubGetDBDate(ZTMcucascademodel.class,null,null,true);
		logger.info("父节点z_t_mcucascademodel需要更新的总条数："+parentList.size());
		Map<String,ZTMcucascademodel> parentMap = new HashMap<String,ZTMcucascademodel>();
		
		for(int i=0;i<parentList.size();i++){
			ZTMcucascademodel entity =parentList.get(i);
	        parentMap.put(entity.getCascadeId(), entity);
        }
		
		List localList = pubGetDBDate(ZTMcucascademodel.class,null,null,false);
		logger.info("本地节点z_t_mcucascademodel需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMcucascademodel entity = (ZTMcucascademodel)localList.get(i);
			ZTMcucascademodel parentEntity =parentMap.get(entity.getCascadeId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getCascadeId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getCascadeId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getCascadeId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_mcucascademodel表时出现异常，本地信息："+entity.getCascadeId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTMcucascademodel> mapEntry : parentMap.entrySet()) {
				ZTMcucascademodel entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getCascadeId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_mcucascademodel表是出现异常，本地信息："+entity.getCascadeId()+"失败");
				}
				
			}
		}
	}
	
	
	/**
	 * 全部更新
	 */
	private static void z_t_poll_terminal(String equipmentIDs){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTPollTerminal> parentList = pubGetDBDate(ZTPollTerminal.class,null,null,true);
		logger.info("父节点z_t_poll_terminal需要更新的总条数："+parentList.size());
		Map<String,ZTPollTerminal> parentMap = new HashMap<String,ZTPollTerminal>();
		
		for(int i=0;i<parentList.size();i++){
			ZTPollTerminal entity =parentList.get(i);
	        parentMap.put(entity.getPollTerminalId(), entity);
        }
		
		List localList = pubGetDBDate(ZTPollTerminal.class,null,null,false);
		logger.info("本地节点z_t_poll_terminal需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTPollTerminal entity = (ZTPollTerminal)localList.get(i);
			ZTPollTerminal parentEntity =parentMap.get(entity.getPollTerminalId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getPollTerminalId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getPollTerminalId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getPollTerminalId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_poll_terminal表时出现异常，本地信息："+entity.getPollTerminalId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTPollTerminal> mapEntry : parentMap.entrySet()) {
				ZTPollTerminal entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getPollTerminalId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_poll_terminal表时出现异常，本地信息："+entity.getPollTerminalId()+" 失败");
				}
				
			}
		}
	}
	
	
	/**
	 * 全部更新
	 */
	private static void z_t_poll_template(String equipmentIDs){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTPollTemplate> parentList = pubGetDBDate(ZTPollTemplate.class,null,null,true);
		logger.info("父节点z_t_poll_template需要更新的总条数："+parentList.size());
		Map<String,ZTPollTemplate> parentMap = new HashMap<String,ZTPollTemplate>();
		
		for(int i=0;i<parentList.size();i++){
			ZTPollTemplate entity =parentList.get(i);
	        parentMap.put(entity.getPollTemplateId(), entity);
        }
		
		List localList = pubGetDBDate(ZTPollTemplate.class,null,null,false);
		logger.info("本地节点z_t_poll_template需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTPollTemplate entity = (ZTPollTemplate)localList.get(i);
			ZTPollTemplate parentEntity =parentMap.get(entity.getPollTemplateId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getPollTemplateId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getPollTemplateId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getPollTemplateId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_poll_template表时出现异常，本地信息："+entity.getPollTemplateId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTPollTemplate> mapEntry : parentMap.entrySet()) {
				ZTPollTemplate entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getPollTemplateId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_poll_template表时出现异常，本地信息："+entity.getPollTemplateId()+" 失败");
				}
				
			}
		}
	}
	
	
	/**
	 * 全部更新
	 */
	private static void z_t_pub_centercontrol(String equipmentIDs){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTPubCentercontrol> parentList = pubGetDBDate(ZTPubCentercontrol.class,null,null,true);
		logger.info("父节点ZTPubCentercontrol需要更新的总条数："+parentList.size());
		Map<String,ZTPubCentercontrol> parentMap = new HashMap<String,ZTPubCentercontrol>();
		
		for(int i=0;i<parentList.size();i++){
			ZTPubCentercontrol entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTPubCentercontrol.class,null,null,false);
		logger.info("本地节点ZTPubCentercontrol需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTPubCentercontrol entity = (ZTPubCentercontrol)localList.get(i);
			ZTPubCentercontrol parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步ZTPubCentercontrol表时出现异常，本地信息："+entity.getId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTPubCentercontrol> mapEntry : parentMap.entrySet()) {
				ZTPubCentercontrol entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步ZTPubCentercontrol表时出现异常，本地信息："+entity.getId()+" 失败");
				}
				
			}
		}
	}
	
	/**
	 * 全部更新
	 */
	private static void z_t_template_meeting(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTTemplateMeeting> parentList = pubGetDBDate(ZTTemplateMeeting.class,null,null,true);
		logger.info("父节点z_t_template_meeting需要更新的总条数："+parentList.size());
		Map<String,ZTTemplateMeeting> parentMap = new HashMap<String,ZTTemplateMeeting>();
		
		for(int i=0;i<parentList.size();i++){
			ZTTemplateMeeting entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTTemplateMeeting.class,null,null,false);
		logger.info("本地节点z_t_template_meeting需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTTemplateMeeting entity = (ZTTemplateMeeting)localList.get(i);
			ZTTemplateMeeting parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_template_meeting表时出现异常，本地信息："+entity.getId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTTemplateMeeting> mapEntry : parentMap.entrySet()) {
				ZTTemplateMeeting entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_template_meeting表时出现异常，本地信息："+entity.getId()+" 失败");
				}
				
			}
		}
	}
	
	
	/**
	 * 全部更新
	 */
	private static void z_t_template_equipment_group(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTTemplateEquipmentGroup> parentList = pubGetDBDate(ZTTemplateEquipmentGroup.class,null,null,true);
		logger.info("父节点ZTTemplateEquipmentGroup需要更新的总条数："+parentList.size());
		Map<String,ZTTemplateEquipmentGroup> parentMap = new HashMap<String,ZTTemplateEquipmentGroup>();
		
		for(int i=0;i<parentList.size();i++){
			ZTTemplateEquipmentGroup entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTTemplateEquipmentGroup.class,null,null,false);
		logger.info("本地节点ZTTemplateEquipmentGroup需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTTemplateEquipmentGroup entity = (ZTTemplateEquipmentGroup)localList.get(i);
			ZTTemplateEquipmentGroup parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步ZTTemplateEquipmentGroup表时出现异常，本地信息："+entity.getId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTTemplateEquipmentGroup> mapEntry : parentMap.entrySet()) {
				ZTTemplateEquipmentGroup entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步ZTTemplateEquipmentGroup表时出现异常，本地信息："+entity.getId()+" 失败");
				}
				
			}
		}
	}
	
	/**
	 * 全部更新
	 */
	private static void z_t_template_equipment(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTTemplateEquipment> parentList = pubGetDBDate(ZTTemplateEquipment.class,null,null,true);
		logger.info("父节点z_t_template_equipment需要更新的总条数："+parentList.size());
		Map<String,ZTTemplateEquipment> parentMap = new HashMap<String,ZTTemplateEquipment>();
		
		for(int i=0;i<parentList.size();i++){
			ZTTemplateEquipment entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTTemplateEquipment.class,null,null,false);
		logger.info("本地节点z_t_template_equipment需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTTemplateEquipment entity = (ZTTemplateEquipment)localList.get(i);
			ZTTemplateEquipment parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_template_equipment表时出现异常，本地信息："+entity.getId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTTemplateEquipment> mapEntry : parentMap.entrySet()) {
				ZTTemplateEquipment entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_template_equipment表时出现异常，本地信息："+entity.getId()+" 失败");
				}
				
			}
		}
	}
	
	/**
	 * 全部更新
	 */
	private static void z_t_template(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTTemplate> parentList = pubGetDBDate(ZTTemplate.class,null,null,true);
		logger.info("父节点z_t_template需要更新的总条数："+parentList.size());
		Map<String,ZTTemplate> parentMap = new HashMap<String,ZTTemplate>();
		
		for(int i=0;i<parentList.size();i++){
			ZTTemplate entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTTemplate.class,null,null,false);
		logger.info("本地节点z_t_template需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTTemplate entity = (ZTTemplate)localList.get(i);
			ZTTemplate parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_template表时出现异常，本地信息："+entity.getId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTTemplate> mapEntry : parentMap.entrySet()) {
				ZTTemplate entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_template表时出现异常，本地信息："+entity.getId()+" 失败");
				}
				
			}
		}
	}
	
	/**
	 * 全部更新
	 */
	private static void z_t_department_user(String ids){
		Date datenow = new Date(System.currentTimeMillis());
		List<ZTDepartmentUser> parentList = pubGetDBDate(ZTDepartmentUser.class,null,null,true);
		logger.info("父节点ZTDepartmentUser需要更新的总条数："+parentList.size());
		Map<ZTDepartmentUserId,ZTDepartmentUser> parentMap = new HashMap<ZTDepartmentUserId,ZTDepartmentUser>();
		
		for(int i=0;i<parentList.size();i++){
			ZTDepartmentUser entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTDepartmentUser.class,null,null,false);
		logger.info("本地节点ZTDepartmentUser需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTDepartmentUser entity = (ZTDepartmentUser)localList.get(i);
			ZTDepartmentUser parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId().getDepartmentId()+","+entity.getId().getUserId(),entity);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
				logger.error("同步ZTDepartmentUser表时出现异常，本地信息："+entity.getId().getUserId()+" 失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTDepartmentUserId, ZTDepartmentUser> mapEntry : parentMap.entrySet()) {
				ZTDepartmentUser entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId().getDepartmentId()+","+entity.getId().getUserId(),entity);
				}catch(Exception e){
					logger.error("同步ZTDepartmentUser表时出现异常，本地信息："+entity.getId().getUserId()+" 失败");
				}
				
			}
		}
	}
	
	/**
	 * 全部更新
	 */
	private static void z_t_department(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTDepartment> parentList = pubGetDBDate(ZTDepartment.class,null,null,true);
		logger.info("父节点ZTDepartment需要更新的总条数："+parentList.size());
		Map<String,ZTDepartment> parentMap = new HashMap<String,ZTDepartment>();
		
		for(int i=0;i<parentList.size();i++){
			ZTDepartment entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTDepartment.class,null,null,false);
		logger.info("本地节点ZTDepartment需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTDepartment entity = (ZTDepartment)localList.get(i);
			ZTDepartment parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步ZTDepartment表时出现异常，本地信息："+entity.getId()+"("+entity.getName()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTDepartment> mapEntry : parentMap.entrySet()) {
				ZTDepartment entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步ZTDepartment表时出现异常，本地信息："+entity.getId()+"("+entity.getName()+")失败");
				}
				
			}
		}
	}
	
	private static void z_t_equipment_mcu_pool(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipmentMcuPool> parentList = pubGetDBDate(ZTEquipmentMcuPool.class,"equipmentId",ids,true);
		logger.info("父节点z_t_equipment_mcu_pool需要更新的总条数："+parentList.size());
		Map<String,ZTEquipmentMcuPool> parentMap = new HashMap<String,ZTEquipmentMcuPool>();
		
		for(int i=0;i<parentList.size();i++){
			ZTEquipmentMcuPool entity =parentList.get(i);
	        parentMap.put(entity.getEquipmentId(), entity);
        }
		
		List localList = pubGetDBDate(ZTEquipmentMcuPool.class,null,null,false);
		logger.info("本地节点z_t_equipment_mcu_pool需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipmentMcuPool entity = (ZTEquipmentMcuPool)localList.get(i);
			ZTEquipmentMcuPool parentEntity =parentMap.get(entity.getEquipmentId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getEquipmentId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getEquipmentId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getEquipmentId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_equipment_mcu_pool表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTEquipmentMcuPool> mapEntry : parentMap.entrySet()) {
				ZTEquipmentMcuPool entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getEquipmentId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_equipment_mcu_pool表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
				}
				
			}
		}
	}
	
	private static void z_t_equipment_backup(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipmentBackup> parentList = pubGetDBDate(ZTEquipmentBackup.class,"id.equipmentId",ids,true);
		logger.info("父节点z_t_equipment_backup需要更新的总条数："+parentList.size());
		Map<ZTEquipmentBackupId,ZTEquipmentBackup> parentMap = new HashMap<ZTEquipmentBackupId,ZTEquipmentBackup>();
		
		for(int i=0;i<parentList.size();i++){
			ZTEquipmentBackup entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
		
		List localList = pubGetDBDate(ZTEquipmentBackup.class,"id.equipmentId",null,false);
		logger.info("本地节点z_t_equipment_backup需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipmentBackup entity = (ZTEquipmentBackup)localList.get(i);
			ZTEquipmentBackup parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId().getEquipmentId()+","+entity.getId().getBackupEquipmentId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_equipment_backup表时出现异常，本地信息："+entity.getId()+"("+entity.getId().getEquipmentId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTEquipmentBackupId, ZTEquipmentBackup> mapEntry : parentMap.entrySet()) {
				ZTEquipmentBackup entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId().getEquipmentId()+","+entity.getId().getBackupEquipmentId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_equipment_backup表时出现异常，本地信息："+entity.getId()+"("+entity.getId().getEquipmentId()+")失败");
				}
				
			}
		}
	}

	/**
	 * 全部更新
	 * @param ids
	 */
	private static void z_t_equipment_dictionary(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipmentDictionary> parentList = pubGetDBDate(ZTEquipmentDictionary.class,null,null,true);
		logger.info("父节点z_t_equipment_dictionary需要更新的总条数："+parentList.size());
		Map<String,ZTEquipmentDictionary> parentMap = new HashMap<String,ZTEquipmentDictionary>();
		
		for(int i=0;i<parentList.size();i++){
			ZTEquipmentDictionary entity =parentList.get(i);
	        parentMap.put(entity.getDicId(), entity);
        }
		
		List localList = pubGetDBDate(ZTEquipmentDictionary.class,null,null,false);
		logger.info("本地节点z_t_equipment_dictionary需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipmentDictionary entity = (ZTEquipmentDictionary)localList.get(i);
			ZTEquipmentDictionary parentEntity =parentMap.get(entity.getDicId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getDicId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getDicId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getDicId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_equipment_dictionary表时出现异常，本地信息："+entity.getDicId()+"("+entity.getDicId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTEquipmentDictionary> mapEntry : parentMap.entrySet()) {
				ZTEquipmentDictionary entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getDicId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_equipment_dictionary表时出现异常，本地信息："+entity.getDicId()+"("+entity.getDicId()+")失败");
				}
			}
		}
	}
	/**
	 * 全部同步，待修改
	 * @param ids
	 */
	private static void z_t_equipment_group(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipmentGroup> parentList = pubGetDBDate(ZTEquipmentGroup.class,null,null,true);
		logger.info("父节点ZTEquipmentGroup需要更新的总条数："+parentList.size());
		Map<String,ZTEquipmentGroup> parentMap = new HashMap<String,ZTEquipmentGroup>();
		
		for(int i=0;i<parentList.size();i++){
			ZTEquipmentGroup equipment =parentList.get(i);
	        parentMap.put(equipment.getId(), equipment);
        }
		
		List localList = pubGetDBDate(ZTEquipmentGroup.class,null,null,false);
		logger.info("本地节点ZTEquipmentGroup需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipmentGroup entity = (ZTEquipmentGroup)localList.get(i);
			ZTEquipmentGroup parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步ZTEquipmentGroup表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTEquipmentGroup> mapEntry : parentMap.entrySet()) {
				ZTEquipmentGroup entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步ZTEquipmentGroup表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
				}
			}
		}
	}
	
	private static String z_t_equipment(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipment> parentList = pubGetDBDate(ZTEquipment.class,"roomId",roomIDs,true);
		logger.info("父节点z_t_equipment需要更新的总条数："+parentList.size());
		Map<String,ZTEquipment> parentMap = new HashMap<String,ZTEquipment>();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<parentList.size();i++){
	        ZTEquipment equipment =parentList.get(i);
	        sb.append(equipment.getEquipmentId()+",");
	        parentMap.put(equipment.getEquipmentId(), equipment);
        }
		if(sb.length()>0) sb = sb.deleteCharAt(sb.length()-1);
		
		List localList = pubGetDBDate(ZTEquipment.class,"roomId",null,false);
		logger.info("本地节点z_t_equipment需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipment entity = (ZTEquipment)localList.get(i);
			ZTEquipment parentEntity =parentMap.get(entity.getEquipmentId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getEquipmentId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getEquipmentId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getEquipmentId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_equipment表时出现异常，本地信息："+entity.getEquipmentNo()+"("+entity.getEquipmentId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTEquipment> mapEntry : parentMap.entrySet()) {
				ZTEquipment entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getEquipmentId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_equipment表时出现异常，本地信息："+entity.getEquipmentNo()+"("+entity.getEquipmentId()+")失败");
				}
				
			}
		}
		
		return sb.toString();
	}
	
	private static void z_t_equipment_Maintain(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipmentMaintain> parentList = pubGetDBDate(ZTEquipmentMaintain.class,"equipmentId",ids,true);
		logger.info("父节点z_t_equipment_Maintain需要更新的总条数："+parentList.size());
		Map<String,ZTEquipmentMaintain> parentMap = new HashMap<String,ZTEquipmentMaintain>();
		for(int i=0;i<parentList.size();i++){
			ZTEquipmentMaintain equipment =parentList.get(i);
	        parentMap.put(equipment.getMaintainId(), equipment);
        }
        
		List localList = pubGetDBDate(ZTEquipmentMaintain.class,"equipmentId",null,false);
		logger.info("本地节点z_t_equipment_Maintain需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipmentMaintain entity = (ZTEquipmentMaintain)localList.get(i);
			ZTEquipmentMaintain parentEntity =parentMap.get(entity.getMaintainId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getMaintainId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getMaintainId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getMaintainId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_equipment_Maintain表时出现异常，本地信息："+entity.getMaintainId()+"("+entity.getEquipmentId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTEquipmentMaintain> mapEntry : parentMap.entrySet()) {
				ZTEquipmentMaintain entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getMaintainId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_equipment_Maintain表时出现异常，本地信息："+entity.getMaintainId()+"("+entity.getEquipmentId()+")失败");
				}
			}
		}
	}
	
	private static void z_t_equipment_Terminal(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipmentTerminal> parentList = pubGetDBDate(ZTEquipmentTerminal.class,"equipmentId",ids,true);
		logger.info("父节点z_t_equipment_Terminal需要更新的总条数："+parentList.size());
		Map<String,ZTEquipmentTerminal> parentMap = new HashMap<String,ZTEquipmentTerminal>();
		for(int i=0;i<parentList.size();i++){
			ZTEquipmentTerminal equipment =parentList.get(i);
	        parentMap.put(equipment.getEquipmentId(), equipment);
        }
        
		List localList = pubGetDBDate(ZTEquipmentTerminal.class,"equipmentId",null,false);
		logger.info("本地节点z_t_equipment_Terminal需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipmentTerminal entity = (ZTEquipmentTerminal)localList.get(i);
			ZTEquipmentTerminal parentEntity =parentMap.get(entity.getEquipmentId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getEquipmentId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getEquipmentId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getEquipmentId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_equipment_Terminal表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTEquipmentTerminal> mapEntry : parentMap.entrySet()) {
				ZTEquipmentTerminal entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getEquipmentId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_equipment_Terminal表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
				}
				
			}
		}
	}
	
	private static void z_t_equipment_mcu(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTEquipmentMcu> parentList = pubGetDBDate(ZTEquipmentMcu.class,"equipmentId",ids,true);
		logger.info("父节点z_t_equipment_mcu需要更新的总条数："+parentList.size());
		Map<String,ZTEquipmentMcu> parentMap = new HashMap<String,ZTEquipmentMcu>();
		for(int i=0;i<parentList.size();i++){
			ZTEquipmentMcu equipment =parentList.get(i);
	        parentMap.put(equipment.getEquipmentId(), equipment);
        }
        
		List localList = pubGetDBDate(ZTEquipmentMcu.class,"equipmentId",null,false);
		logger.info("本地节点z_t_equipment_mcu需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTEquipmentMcu entity = (ZTEquipmentMcu)localList.get(i);
			ZTEquipmentMcu parentEntity =parentMap.get(entity.getEquipmentId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Timestamp date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getEquipmentId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getEquipmentId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getEquipmentId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_equipment_mcu表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTEquipmentMcu> mapEntry : parentMap.entrySet()) {
				ZTEquipmentMcu entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getEquipmentId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_equipment_mcu表时出现异常，本地信息："+entity.getEquipmentId()+"("+entity.getEquipmentId()+")失败");
				}
			}
		}
	}
	
	
	/**
	 * 此表为全部更新
	 */
	public static void z_t_level(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTLevel> parentList = pubGetDBDate(ZTLevel.class,null,null,true);
		logger.info("父节点z_t_level需要更新的总条数："+parentList.size());
		Map<String,ZTLevel> parentMap = new HashMap<String,ZTLevel>();
		for(int i=0;i<parentList.size();i++){
			ZTLevel level =parentList.get(i);
	        parentMap.put(level.getLevelId(), level);
        }
        
		List localList = pubGetDBDate(ZTLevel.class,null,null,false);
		logger.info("本地节点z_t_level需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTLevel entity = (ZTLevel)localList.get(i);
			ZTLevel parentEntity =parentMap.get(entity.getLevelId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getLevelId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getLevelId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getLevelId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_level表时出现异常，本地分级信息："+entity.getLevelName()+"("+entity.getLevelId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTLevel> mapEntry : parentMap.entrySet()) {
				ZTLevel entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getLevelId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_level表时出现异常，本地分级信息："+entity.getLevelName()+"("+entity.getLevelId()+")失败");
				}
			}
		}
	}
	
	private static void z_t_level_config(){
		Date datenow = new Date(System.currentTimeMillis());
		List<ZTLevelConfig> parentList = pubGetDBDate(ZTLevelConfig.class,"id.levelId",null,true);
		logger.info("父节点z_t_level_config需要更新的总条数："+parentList.size());
		Map<ZTLevelConfigId,ZTLevelConfig> parentMap = new HashMap<ZTLevelConfigId,ZTLevelConfig>();
		for(int i=0;i<parentList.size();i++){
			ZTLevelConfig levelConfig =parentList.get(i);
	        parentMap.put(levelConfig.getId(), levelConfig);
        }
        
		List localList = pubGetDBDate(ZTLevelConfig.class,"id.levelId",null,false);
		logger.info("本地节点z_t_level_config需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTLevelConfig entity = (ZTLevelConfig)localList.get(i);
			ZTLevelConfig parentEntity =parentMap.get(entity.getId());
			
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
						//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
						if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
							localSession.merge(parentEntity);
							localSession.flush();
						}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
							if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
								localSession.merge(parentEntity);
								localSession.flush();
								//	logger.info("更新本地");
							}else{//父节点更新--数据以本地为准
								parentSession.merge(entity);
								parentSession.flush();
								//	logger.info("更新父节点");
							}
						}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getLid(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_level_config表时出现异常，本地levelID："+entity.getId().getLevelId()+"和levelKey："+entity.getId().getLevelKey()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTLevelConfigId, ZTLevelConfig> mapEntry : parentMap.entrySet()) {
				ZTLevelConfig entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getLid(),entity);
				}catch(Exception e){
					logger.error("同步z_t_level_config表时出现异常，本地levelID："+entity.getId().getLevelId()+"和levelKey："+entity.getId().getLevelKey()+"失败");
				}
				
			}
		}
	}
	
	private static String z_t_user(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTUser> parentList = pubGetDBDate(ZTUser.class,"userId",userIDs,true);
		logger.info("父节点z_t_user需要更新的总条数："+parentList.size());
		Map<String,ZTUser> parentMap = new HashMap<String,ZTUser>();
        
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<parentList.size();i++){
			ZTUser user =parentList.get(i);
	        parentMap.put(user.getUserId(), user);
	        sb.append(user.getUserId()+",");
        }
		if(sb.length()>0) sb = sb.deleteCharAt(sb.length()-1);
		
		
		List localList = pubGetDBDate(ZTUser.class,"userId",null,false);
		logger.info("本地节点z_t_user需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTUser entity = (ZTUser)localList.get(i);
			ZTUser parentEntity =parentMap.get(entity.getUserId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getUserId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getUserId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getUserId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_user表时出现异常，本地用户信息："+entity.getFullName()+"("+entity.getUserId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTUser> mapEntry : parentMap.entrySet()) {
				ZTUser entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getUserId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_user表时出现异常，本地用户信息："+entity.getFullName()+"("+entity.getUserId()+")失败");
				}
			}
		}
		return sb.toString();
	}
	
	private void  z_t_post(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTPost> parentList = pubGetDBDate(ZTPost.class,"createUserId",userIDs,true);
		logger.info("父节点z_t_post需要更新的总条数："+parentList.size());
		Map<String,ZTPost> parentMap = new HashMap<String,ZTPost>();
		for(int i=0;i<parentList.size();i++){
			ZTPost entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTPost.class,"createUserId",null,false);
		logger.info("本地节点z_t_post需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTPost entity = (ZTPost)localList.get(i);
			ZTPost parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_post表时出现异常，本地岗位信息："+entity.getPostName()+"("+entity.getId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTPost> mapEntry : parentMap.entrySet()) {
				ZTPost entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_post表时出现异常，本地岗位信息："+entity.getPostName()+"("+entity.getId()+")失败");
				}
				
			}
		}
	}
	
	private void z_t_user_post(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTUserPost> parentList = pubGetDBDate(ZTUserPost.class,"userId",userIDs,true);
		logger.info("父节点z_t_user_post需要更新的总条数："+parentList.size());
		Map<String,ZTUserPost> parentMap = new HashMap<String,ZTUserPost>();
		for(int i=0;i<parentList.size();i++){
			ZTUserPost entity =parentList.get(i);
	        parentMap.put(entity.getUserId(), entity);
        }
        
		List localList = pubGetDBDate(ZTUserPost.class,"userId",null,false);
		logger.info("本地节点z_t_user_post需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTUserPost entity = (ZTUserPost)localList.get(i);
			ZTUserPost parentEntity =parentMap.get(entity.getUserId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getUserId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getUserId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getUserId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_user_post表时出现异常，本地userId："+entity.getUserId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTUserPost> mapEntry : parentMap.entrySet()) {
				ZTUserPost entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getUserId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_user_post表时出现异常，本地userId："+entity.getUserId()+"失败");
				}
			}
		}
	}
	
	private void z_t_role(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTRole> parentList = pubGetDBDate(ZTRole.class,"createBy",userIDs,true);
		logger.info("父节点z_t_role需要更新的总条数："+parentList.size());
		Map<String,ZTRole> parentMap = new HashMap<String,ZTRole>();
		for(int i=0;i<parentList.size();i++){
			ZTRole entity =parentList.get(i);
	        parentMap.put(entity.getRoleId(), entity);
        }
        
		List localList = pubGetDBDate(ZTRole.class,"createBy",null,false);
		logger.info("本地节点z_t_role需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTRole entity = (ZTRole)localList.get(i);
			ZTRole parentEntity =parentMap.get(entity.getRoleId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getRoleId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getRoleId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getRoleId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_role表时出现异常，本地岗位信息："+entity.getRoleName()+"("+entity.getRoleId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTRole> mapEntry : parentMap.entrySet()) {
				ZTRole entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getRoleId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_role表时出现异常，本地岗位信息："+entity.getRoleName()+"("+entity.getRoleId()+")失败");
				}
			}
		}
	}
	/**
	 * 此表为全部更新
	 *
	 */
	private void z_t_function(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTFunction> parentList = pubGetDBDate(ZTFunction.class,"funcId",null,true);
		logger.info("父节点z_t_function需要更新的总条数："+parentList.size());
		Map<String,ZTFunction> parentMap = new HashMap<String,ZTFunction>();
		for(int i=0;i<parentList.size();i++){
			ZTFunction entity =parentList.get(i);
	        parentMap.put(entity.getFuncId(), entity);
        }
        
		List localList = pubGetDBDate(ZTFunction.class,"funcId",null,false);
		logger.info("本地节点z_t_function需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTFunction entity = (ZTFunction)localList.get(i);
			ZTFunction parentEntity =parentMap.get(entity.getFuncId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getFuncId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getFuncId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getFuncId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_function表时出现异常，本地功能信息："+entity.getFuncName()+"("+entity.getFuncId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTFunction> mapEntry : parentMap.entrySet()) {
				ZTFunction entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getFuncId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_function表时出现异常，本地功能信息："+entity.getFuncName()+"("+entity.getFuncId()+")失败");
				}
			}
		}
	}
	
	private void z_t_role_func(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTRoleFunc> parentList = pubGetDBDate(ZTRoleFunc.class,"id.roleId",null,true);
		logger.info("父节点z_t_role_func需要更新的总条数："+parentList.size());
		Map<ZTRoleFuncId,ZTRoleFunc> parentMap = new HashMap<ZTRoleFuncId,ZTRoleFunc>();
		for(int i=0;i<parentList.size();i++){
			ZTRoleFunc entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTRoleFunc.class,"id.roleId",null,false);
		logger.info("本地节点z_t_role_func需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTRoleFunc entity = (ZTRoleFunc)localList.get(i);
			ZTRoleFunc parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getRid(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_role_func表时出现异常，本地roleID："+entity.getId().getRoleId()+"和funcId："+entity.getId().getFuncId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTRoleFuncId, ZTRoleFunc> mapEntry : parentMap.entrySet()) {
				ZTRoleFunc entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getRid(),entity);
				}catch(Exception e){
					logger.error("同步z_t_role_func表时出现异常，本地roleID："+entity.getId().getRoleId()+"和funcId："+entity.getId().getFuncId()+"失败");
				}
			}
		}
	}
	
	private void z_t_user_role(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTUserRole> parentList = pubGetDBDate(ZTUserRole.class,"id.userId",userIDs,true);
		logger.info("父节点z_t_user_role需要更新的总条数："+parentList.size());
		Map<ZTUserRoleId,ZTUserRole> parentMap = new HashMap<ZTUserRoleId,ZTUserRole>();
		for(int i=0;i<parentList.size();i++){
			ZTUserRole entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTUserRole.class,"id.userId",null,false);
		logger.info("本地节点z_t_user_role需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTUserRole entity = (ZTUserRole)localList.get(i);
			ZTUserRole parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getUid(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_user_role表时出现异常，本地userId："+entity.getId().getUserId()+"和roleId："+entity.getId().getRoleId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTUserRoleId, ZTUserRole> mapEntry : parentMap.entrySet()) {
				ZTUserRole entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getUid(),entity);
				}catch(Exception e){
					logger.error("同步z_t_user_role表时出现异常，本地userId："+entity.getId().getUserId()+"和roleId："+entity.getId().getRoleId()+"失败");
				}
			}
		}
	}
	
	
	private void z_t_meetingroom(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingroom> parentList = pubGetDBDate(ZTMeetingroom.class,"meetingroomId",roomIDs,true);
		logger.info("父节点z_t_meetingroom需要更新的总条数："+parentList.size());
		Map<String,ZTMeetingroom> parentMap = new HashMap<String,ZTMeetingroom>();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingroom meetingRoom =parentList.get(i);
	        parentMap.put(meetingRoom.getMeetingroomId(), meetingRoom);
        }
        
		List localList = pubGetDBDate(ZTMeetingroom.class,"meetingroomId",null,false);
		logger.info("本地节点z_t_meetingroom需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingroom entity = (ZTMeetingroom)localList.get(i);
			ZTMeetingroom parentEntity =parentMap.get(entity.getMeetingroomId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getMeetingroomId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getMeetingroomId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getMeetingroomId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingroom表时出现异常，本地会议室信息："+entity.getMeetingroomName()+"("+entity.getMeetingroomId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTMeetingroom> mapEntry : parentMap.entrySet()) {
				ZTMeetingroom entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getMeetingroomId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingroom表时出现异常，本地会议室信息："+entity.getMeetingroomName()+"("+entity.getMeetingroomId()+")失败");
				}
			}
		}
	}
	
	private void z_t_meetingroom_equipment(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingroomEquipment> parentList = pubGetDBDate(ZTMeetingroomEquipment.class,"id.roomId",roomIDs,true);
		logger.info("父节点z_t_meetingroom_equipment需要更新的总条数："+parentList.size());
		Map<ZTMeetingroomEquipmentId,ZTMeetingroomEquipment> parentMap = new HashMap<ZTMeetingroomEquipmentId,ZTMeetingroomEquipment>();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingroomEquipment meetingRoomEquipment =parentList.get(i);
	        parentMap.put(meetingRoomEquipment.getId(), meetingRoomEquipment);
        }
        
		List localList = pubGetDBDate(ZTMeetingroomEquipment.class,"id.roomId",null,false);
		logger.info("本地节点z_t_meetingroom_equipment需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingroomEquipment entity = (ZTMeetingroomEquipment)localList.get(i);
			ZTMeetingroomEquipment parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId().getRoomId()+","+entity.getId().getEquipmentId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingroom_equipment表时出现异常，本地会议室ID："+entity.getId().getRoomId()+"和设备ID："+entity.getId().getEquipmentId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTMeetingroomEquipmentId, ZTMeetingroomEquipment> mapEntry : parentMap.entrySet()) {
				ZTMeetingroomEquipment entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId().getRoomId()+","+entity.getId().getEquipmentId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingroom_equipment表时出现异常，本地会议室ID："+entity.getId().getRoomId()+"和设备ID："+entity.getId().getEquipmentId()+"失败");
				}
			}
		}
	}
	
	private String z_t_meetingdetail(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingdetail> parentList = pubGetDBDate(ZTMeetingdetail.class,"createUserId",userIDs,true);
		logger.info("父节点z_t_meetingdetail需要更新的总条数："+parentList.size());
		Map<String,ZTMeetingdetail> parentMap = new HashMap<String,ZTMeetingdetail>();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingdetail entity =parentList.get(i);
			sb.append(entity.getMeetingDetailId()+",");
	        parentMap.put(entity.getMeetingDetailId(), entity);
        }
		if(sb.length()>0) sb = sb.deleteCharAt(sb.length()-1);
		
		List localList = pubGetDBDate(ZTMeetingdetail.class,"createUserId",null,false);
		logger.info("本地节点z_t_meetingdetail需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingdetail entity = (ZTMeetingdetail)localList.get(i);
			ZTMeetingdetail parentEntity =parentMap.get(entity.getMeetingDetailId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getMeetingDetailId());
						continue;
					}else{
						entity.setDbmsTime(date);
					parentMap.remove(entity.getMeetingDetailId());
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
					if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新
						localSession.merge(parentEntity);
						localSession.flush();
					}else{//父节点更新
						parentSession.merge(entity);
						parentSession.flush();
					}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getMeetingDetailId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingdetail表时出现异常，本地会议信息："+entity.getMeetingName()+"("+entity.getMeetingDetailId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTMeetingdetail> mapEntry : parentMap.entrySet()) {
				ZTMeetingdetail entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getMeetingDetailId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingdetail表时出现异常，本地会议信息："+entity.getMeetingName()+"("+entity.getMeetingDetailId()+")失败");
				}
			}
		}
		return sb.toString();
	}
	
	private void z_t_meetingdetail_cost(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingdetailCost> parentList = pubGetDBDate(ZTMeetingdetailCost.class,"meetingDetailId",ids,true);
		logger.info("父节点z_t_meetingdetail_cost需要更新的总条数："+parentList.size());
		Map<String,ZTMeetingdetailCost> parentMap = new HashMap<String,ZTMeetingdetailCost>();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingdetailCost entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTMeetingdetailCost.class,"meetingDetailId",null,false);
		logger.info("本地节点z_t_meetingdetail_cost需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingdetailCost entity = (ZTMeetingdetailCost)localList.get(i);
			ZTMeetingdetailCost parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingdetail_cost表时出现异常，本地信息id："+entity.getId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTMeetingdetailCost> mapEntry : parentMap.entrySet()) {
				ZTMeetingdetailCost entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingdetail_cost表时出现异常，本地信息id："+entity.getId()+"失败");
				}
			}
		}
	}
	
	private void z_t_meetingdetail_department(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingdetailDepartment> parentList = pubGetDBDate(ZTMeetingdetailDepartment.class,"id.meetingDetailId",ids,true);
		logger.info("父节点z_t_meetingdetail_department需要更新的总条数："+parentList.size());
		Map<ZTMeetingdetailDepartmentId,ZTMeetingdetailDepartment> parentMap = new HashMap<ZTMeetingdetailDepartmentId,ZTMeetingdetailDepartment>();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingdetailDepartment entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTMeetingdetailDepartment.class,"id.meetingDetailId",null,false);
		logger.info("本地节点z_t_meetingdetail_department需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingdetailDepartment entity = (ZTMeetingdetailDepartment)localList.get(i);
			ZTMeetingdetailDepartment parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId().getMeetingDetailId()+","+entity.getId().getDepartId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingdetail_department表时出现异常，本地meetingDetailId："+entity.getId().getMeetingDetailId()+"和departId："+entity.getId().getDepartId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTMeetingdetailDepartmentId, ZTMeetingdetailDepartment> mapEntry : parentMap.entrySet()) {
				ZTMeetingdetailDepartment entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId().getMeetingDetailId()+","+entity.getId().getDepartId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingdetail_department表时出现异常，本地meetingDetailId："+entity.getId().getMeetingDetailId()+"和departId："+entity.getId().getDepartId()+"失败");
				}
			}
		}
	}
	
	private void z_t_meetingdetail_equipment(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingdetailEquipment> parentList = pubGetDBDate(ZTMeetingdetailEquipment.class,"meetingDetailId",ids,true);
		logger.info("父节点z_t_meetingdetail_equipment需要更新的总条数："+parentList.size());
		Map<String,ZTMeetingdetailEquipment> parentMap = new HashMap<String,ZTMeetingdetailEquipment>();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingdetailEquipment entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTMeetingdetailEquipment.class,"meetingDetailId",null,false);
		logger.info("本地节点z_t_meetingdetail_equipment需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingdetailEquipment entity = (ZTMeetingdetailEquipment)localList.get(i);
			ZTMeetingdetailEquipment parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingdetail_equipment表时出现异常，本地信息id："+entity.getId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTMeetingdetailEquipment> mapEntry : parentMap.entrySet()) {
				ZTMeetingdetailEquipment entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingdetail_equipment表时出现异常，本地信息id："+entity.getId()+"失败");
				}
			}
		}
	}

	private void z_t_meetingdetail_room(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingdetailRoom> parentList = pubGetDBDate(ZTMeetingdetailRoom.class,"id.meetingDetailId",ids,true);
		logger.info("父节点z_t_meetingdetail_room需要更新的总条数："+parentList.size());
		Map<ZTMeetingdetailRoomId,ZTMeetingdetailRoom> parentMap = new HashMap<ZTMeetingdetailRoomId,ZTMeetingdetailRoom>();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingdetailRoom entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTMeetingdetailRoom.class,"id.meetingDetailId",null,false);
		logger.info("本地节点z_t_meetingdetail_room需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingdetailRoom entity = (ZTMeetingdetailRoom)localList.get(i);
			ZTMeetingdetailRoom parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId().getMeetingroomId()+","+entity.getId().getMeetingDetailId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingdetail_room表时出现异常，本地meetingroomId："+entity.getId().getMeetingroomId()+"和meetingDetailId："+entity.getId().getMeetingDetailId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTMeetingdetailRoomId, ZTMeetingdetailRoom> mapEntry : parentMap.entrySet()) {
				ZTMeetingdetailRoom entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId().getMeetingroomId()+","+entity.getId().getMeetingDetailId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingdetail_room表时出现异常，本地meetingroomId："+entity.getId().getMeetingroomId()+"和meetingDetailId："+entity.getId().getMeetingDetailId()+"失败");
				}
			}
		}
	}
	
	private void z_t_meetingdetail_user(String ids){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTMeetingdetailUser> parentList = pubGetDBDate(ZTMeetingdetailUser.class,"id.meetingDetailId",ids,true);
		logger.info("父节点z_t_meetingdetail_user需要更新的总条数："+parentList.size());
		Map<ZTMeetingdetailUserId,ZTMeetingdetailUser> parentMap = new HashMap<ZTMeetingdetailUserId,ZTMeetingdetailUser>();
		for(int i=0;i<parentList.size();i++){
			ZTMeetingdetailUser entity =parentList.get(i);
	        parentMap.put(entity.getId(), entity);
        }
        
		List localList = pubGetDBDate(ZTMeetingdetailUser.class,"id.meetingDetailId",null,false);
		logger.info("本地节点z_t_meetingdetail_user需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTMeetingdetailUser entity = (ZTMeetingdetailUser)localList.get(i);
			ZTMeetingdetailUser parentEntity =parentMap.get(entity.getId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getId().getUserId()+","+entity.getId().getMeetingDetailId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_meetingdetail_user表时出现异常，本地userId："+entity.getId().getUserId()+"和meetingDetailId："+entity.getId().getMeetingDetailId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<ZTMeetingdetailUserId, ZTMeetingdetailUser> mapEntry : parentMap.entrySet()) {
				ZTMeetingdetailUser entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getId().getUserId()+","+entity.getId().getMeetingDetailId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_meetingdetail_user表时出现异常，本地userId："+entity.getId().getUserId()+"和meetingDetailId："+entity.getId().getMeetingDetailId()+"失败");
				}
				
			}
		}
	}
	/**
	 * 此表为全部更新
	 *
	 */
	private void z_t_address(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTAddress> parentList = pubGetDBDate(ZTAddress.class,"addressId",null,true);
		logger.info("父节点z_t_address需要更新的总条数："+parentList.size());
		Map<String,ZTAddress> parentMap = new HashMap<String,ZTAddress>();
		for(int i=0;i<parentList.size();i++){
			ZTAddress entity =parentList.get(i);
	        parentMap.put(entity.getAddressId(), entity);
        }
        
		List localList = pubGetDBDate(ZTAddress.class,"addressId",null,false);
		logger.info("本地节点z_t_address需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTAddress entity = (ZTAddress)localList.get(i);
			ZTAddress parentEntity =parentMap.get(entity.getAddressId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getAddressId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getAddressId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getAddressId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_address表时出现异常，本地地址信息："+entity.getName()+"("+entity.getAddressId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTAddress> mapEntry : parentMap.entrySet()) {
				ZTAddress entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getAddressId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_address表时出现异常，本地地址信息："+entity.getName()+"("+entity.getAddressId()+")失败");
				}
			}
		}
	}
	/**
	 * 此表为全部更新
	 *
	 */
	private void z_t_dictionary(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTDictionary> parentList = pubGetDBDate(ZTDictionary.class,"dicId",null,true);
		logger.info("父节点z_t_dictionary需要更新的总条数："+parentList.size());
		Map<String,ZTDictionary> parentMap = new HashMap<String,ZTDictionary>();
		for(int i=0;i<parentList.size();i++){
			ZTDictionary entity =parentList.get(i);
	        parentMap.put(entity.getDicId(), entity);
        }
        
		List localList = pubGetDBDate(ZTDictionary.class,"dicId",null,false);
		logger.info("本地节点z_t_dictionary需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTDictionary entity = (ZTDictionary)localList.get(i);
			ZTDictionary parentEntity =parentMap.get(entity.getDicId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getDicId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getDicId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getDicId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_dictionary表时出现异常，本地dicId："+entity.getDicId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTDictionary> mapEntry : parentMap.entrySet()) {
				ZTDictionary entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getDicId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_dictionary表时出现异常，本地dicId："+entity.getDicId()+"失败");
				}
			}
		}
	}
	/**
	 * 此表为全部更新
	 *
	 */
	private void z_t_information(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTInformation> parentList = pubGetDBDate(ZTInformation.class,"infoId",null,true);
		logger.info("父节点z_t_information需要更新的总条数："+parentList.size());
		Map<String,ZTInformation> parentMap = new HashMap<String,ZTInformation>();
		for(int i=0;i<parentList.size();i++){
			ZTInformation entity =parentList.get(i);
	        parentMap.put(entity.getInfoId(), entity);
        }
        
		List localList = pubGetDBDate(ZTInformation.class,"infoId",null,false);
		logger.info("本地节点z_t_information需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTInformation entity = (ZTInformation)localList.get(i);
			ZTInformation parentEntity =parentMap.get(entity.getInfoId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getInfoId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getInfoId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getInfoId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_information表时出现异常，本地告警信息："+entity.getTitle()+"("+entity.getInfoId()+")失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTInformation> mapEntry : parentMap.entrySet()) {
				ZTInformation entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getInfoId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_information表时出现异常，本地告警信息："+entity.getTitle()+"("+entity.getInfoId()+")失败");
				}
			}
		}
	}
	/**
	 * 此表为全部更新
	 *
	 */
	private void z_t_log(){
		Timestamp datenow = new Timestamp(System.currentTimeMillis());
		List<ZTLog> parentList = pubGetDBDate(ZTLog.class,"logId",null,true);
		logger.info("父节点z_t_log需要更新的总条数："+parentList.size());
		Map<String,ZTLog> parentMap = new HashMap<String,ZTLog>();
		for(int i=0;i<parentList.size();i++){
			ZTLog entity =parentList.get(i);
	        parentMap.put(entity.getLogId(), entity);
        }
        
		List localList = pubGetDBDate(ZTLog.class,"logId",null,false);
		logger.info("本地节点z_t_log需要更新的总条数："+localList.size());
		for(int i=0;i<localList.size();i++){
			ZTLog entity = (ZTLog)localList.get(i);
			ZTLog parentEntity =parentMap.get(entity.getLogId());
			try{
				//处理更新部分
				if(parentEntity!=null){
					Date date = entity.getDbmsTime();
					entity.setDbmsTime(parentEntity.getDbmsTime());
					Map<String, String> result = CommonHelp.compare(entity, parentEntity);
					if(!result.containsValue("false")){//除了dbms_time字段，还有其它属性都一样，不更新数据
						logger.info("不用更新");
						parentMap.remove(entity.getLogId());
						continue;
					}else{
						entity.setDbmsTime(date);
						parentMap.remove(entity.getLogId());
					//比较时间，如果父节点时间不为空或者父节点时间和本地时间都为空，数据以父节点为准
					if((entity.getDbmsTime()==null && parentEntity.getDbmsTime()==null) || (entity.getDbmsTime()==null && parentEntity.getDbmsTime()!=null)){
						localSession.merge(parentEntity);
						localSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()==null){//父节点时间为空，本地时间不为空，数据以本地为准
						parentSession.merge(entity);
						parentSession.flush();
					}else if(entity.getDbmsTime()!=null && parentEntity.getDbmsTime()!=null){
						if(entity.getDbmsTime().before(parentEntity.getDbmsTime())){//比较日期，最新的数据为准。本地更新--数据以服务器为准
							localSession.merge(parentEntity);
							localSession.flush();
						}else{//父节点更新--数据以本地为准
							parentSession.merge(entity);
							parentSession.flush();
						}
					}
					}
				}else{//本地多一条数据
					entity.setDbmsTime(datenow);
					pubCheckParentDelID(entity.getLogId(),entity);
				}
			}catch(Exception e){
				logger.error("同步z_t_log表时出现异常，本地logId："+entity.getLogId()+"失败");
			}
		}
		
		//处理父节点中多出来的数据
		if(parentMap.size()>0){//服务器数据比本地多，将服务器多出的数据更新到本地
			for (Map.Entry<String, ZTLog> mapEntry : parentMap.entrySet()) {
				ZTLog entity = mapEntry.getValue();
				try{
					entity.setDbmsTime(datenow);
					pubCheckLocalDelID(entity.getLogId(),entity);
				}catch(Exception e){
					logger.error("同步z_t_log表时出现异常，本地logId："+entity.getLogId()+"失败");
				}
				
			}
		}
	}

	/**
	 * 提取数据
	 * @param class1  实体类对象
	 * @param	columnName	实体类的字段名称
	 * @param	ids 关联的ID
	 * @param mark	为true时，提取父节点数据，为false时，提取本地数据
	 * @return List 接收时强转为Class即可
	 */
	public static List pubGetDBDate(Class class1,String columnName,String ids,boolean mark){
		Criteria c;
		if(mark)
			c	=	parentSession.createCriteria(class1);
		else
			c	=	localSession.createCriteria(class1);
		
		if(mark&&ids!=null&&ids.length()>0)
			c.add(Restrictions.in(columnName, ids.split(",")));
		c.add(Restrictions.or(Restrictions.gt("dbmsTime",lastTime),Restrictions.isNull("dbmsTime")));
		return c.list();
	}
	
	/**
	 * 检测是否是父节点上删除数据--本地比服务器多数据
	 * @param key
	 * @param Object
	 * @return
	 */
	public static boolean pubCheckParentDelID(String key,Object obj){
		//去父节点查询z_t_deleteinfo表是否有记录
		Criteria c;
		c = parentSession.createCriteria(ZTDeleteinfo.class);
		c.add(Restrictions.eq("delInfoId", key));
		List list = c.list();
		
		if(list!=null && list.size()>0){//父节点z_t_deleteinfo表有数据，本地删除相应数据
			localSession.delete(obj);
			localSession.flush();
		}else{//父节点z_t_deleteinfo表没有数据，父节点增加相应数据
			parentSession.merge(obj);
			parentSession.flush();
			localSession.merge(obj);
			localSession.flush();
		}
		return false;
	}
	
	/**
	 * 检测是否是删除数据--父节点比本地多数据
	 * @param id
	 * @param mark	true为父节点来的数据，false为本地来的数据
	 * @return
	 */
	public static boolean pubCheckLocalDelID(String key,Object obj){
		//去本地查询z_t_deleteinfo表是否有记录
		Criteria c;
		c = localSession.createCriteria(ZTDeleteinfo.class);
		c.add(Restrictions.eq("delInfoId", key));
		List list = c.list();
		if(list!=null && list.size()>0){//本地节点z_t_deleteinfo表有数据，父节点删除相应数据
			parentSession.delete(obj);
			parentSession.flush();
		}else{//本地节点z_t_deleteinfo表没有数据，本地增加相应数据
			localSession.merge(obj);
			localSession.flush();
			parentSession.merge(obj);
			parentSession.flush();
		}
		
		return false;
	}
	
	public static void pubGetUserIDs(){
		//Session session =FarHibernateSessionFactory.getSessionFactory().openSession();
		String sql ="select GROUP_CONCAT(levelkey) as ids from z_t_level_config where levelId = '"+CommonHelp.nodeID+"' and levelType='z_t_user'";
		userIDs = (String)parentSession.createSQLQuery(sql).addScalar("ids").uniqueResult();
	}
	
	
	public static void pubGetRoomIDs(){
		//Session session =FarHibernateSessionFactory.getSessionFactory().openSession();
		String sql ="select GROUP_CONCAT(levelkey) as ids from z_t_level_config where levelId = '"+CommonHelp.nodeID+"' and levelType='z_t_meetingroom'";
		roomIDs = (String)parentSession.createSQLQuery(sql).addScalar("ids").uniqueResult();
	}
}
