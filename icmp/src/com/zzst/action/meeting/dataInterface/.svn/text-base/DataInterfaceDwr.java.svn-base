package com.zzst.action.meeting.dataInterface;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;



import com.cbf.db.TransactionManager;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.DES;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.model.enums.DataInterfaceEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceVO;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.equipment.EquipmentCenterControlVO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;
import com.zzst.service.meeting.address.AddressService;
import com.zzst.service.meeting.auth.RoleService;
import com.zzst.service.meeting.auth.RoleServiceImpl;
import com.zzst.service.meeting.dataInterface.department.DepartmentInterfaceService;
import com.zzst.service.meeting.dataInterface.equipment.EquipmentInterfaceService;
import com.zzst.service.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceService;
import com.zzst.service.meeting.dataInterface.role.RoleInterfaceService;
import com.zzst.service.meeting.dataInterface.terminal.TerminalInterfaceService;
import com.zzst.service.meeting.dataInterface.user.UserInterfaceService;
import com.zzst.service.meeting.department.DepartmentService;
import com.zzst.service.meeting.equipment.EquipmentMcuService;
import com.zzst.service.meeting.equipment.EquipmentService;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.userDepartment.UserDepartmentService;
import com.zzst.service.meeting.userDepartment.UserDepartmentServiceImpl;
import com.zzst.service.meeting.userRole.UserRoleService;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;

public class DataInterfaceDwr {
	private static MeetingRoomInterfaceService mis = ServiceFactory.getMeetingRoomInterfaceService();
	private static TerminalInterfaceService tis = ServiceFactory.getTerminalInterfaceService();
	private static EquipmentInterfaceService eis = ServiceFactory.getEquipmentInterfaceService();
	private static RoleInterfaceService rif = ServiceFactory.getRoleInterfaceService();
	private static MeetingRoomService mrs = ServiceFactory.getMeetingRoomService();
	private static DepartmentInterfaceService dis = ServiceFactory.getDepartmentInterfaceService();
	private static UserService us = ServiceFactory.getUserService();
	private static DepartmentService ds = ServiceFactory.getDepartmentService();
	private static AddressService as = ServiceFactory.getAddressService();
	private static EquipmentService es = ServiceFactory.getEquipmentService();
	private static RoleService rs = new RoleServiceImpl();
	private static UserInterfaceService uis = ServiceFactory.getUserInterfaceService();
	private static EquipmentMcuService em = ServiceFactory.getEquipmentMcuService();
	
	
	private ArrayList<MeetingRoomInterfaceVO>  availList = new ArrayList<MeetingRoomInterfaceVO>();
	private ArrayList<EquipmentInterfaceVO> terAvailList = new ArrayList<EquipmentInterfaceVO>();
	
	public String dataImport(){
		MeetingRoomInterfaceVO mrVO = new MeetingRoomInterfaceVO();
		MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
		
		try{
			
			//将接口表名字字段转化为对应表主键 adminID  departmentID addressID
			
			HashMap<String,String> userMap = toAdminMap();//user Map
			   
			HashMap<String,String> departmentMap = toDepartmentMap();//department Map
			   
			HashMap<String,String> addressMap = toAddressMap();	//address Map
			
			
		   ArrayList<MeetingRoomInterfaceVO> list =	 mis.queryAvailable(mrVO, null);//接口表未导入的数据集合
		   
		   ArrayList<MeetingRoomVO> meetingRoomList = mrs.query(meetingRoomVO, null);//数据库核心表已经存在的数据集合
		  
		   for( int i=0; i<list.size(); i++ ){
			   MeetingRoomInterfaceVO mrTemp = list.get(i);
			   if( mrTemp.getRoomNO() != null ){
				   for( int j=0; j<list.size(); j++ ){
					   if( mrTemp.getMeetingroomName().equalsIgnoreCase(list.get(j).getMeetingroomName()) && (i != j ) ){//自身的会议室名字重复
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("会议室名字重复");
						   break;
					   }
					   if( mrTemp.getRoomNO().equalsIgnoreCase(list.get(j).getRoomNO()) && (i != j )){//自身会议室编号重复
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("会议室编号重复");
						   break;
					   }
					   
					   if( j ==  (list.size()- 1) ){ //还要与数据库验证
						    
						   if( isRoomNameDuplicate(mrTemp, meetingRoomList)){//与数据库数据重复
							   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
							   mrTemp.setDescription("会议室名字重复");
							   break;
						   }else{//与数据库数据会议室名字不重复还要判断是否存在各个外键
							 
							   
							 String adminID = getAdminID(mrTemp.getAdminName(),userMap);
							 String departmentID = getDepartmentID(mrTemp.getDepartmentName(), departmentMap);
							 String addressID = getAddressID(mrTemp.getAddressName(), addressMap);
							 
							 if( adminID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("会议室管理员没有匹配到ID");
								   break;
							 }else if ( departmentID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("所属单位没有匹配到ID");
								   break;
							 }else if (addressID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("会议室位置没有匹配到ID");
								   break;
							 }else{
								  
								 if( isRoomNODuplicate(mrTemp.getRoomNO(), meetingRoomList)){//roomNO存在则为更新操作
									 mrTemp.setSqlType(DataInterfaceEnum.UPDATE_TYPE);
								 }else{//roomNO不存在则为添加操作
									 mrTemp.setSqlType(DataInterfaceEnum.ADD_TYPE);
							   }
								 
								 mrTemp.setStatus(DataInterfaceEnum.IMPORT_SUCCESS);//标记为可以导入
								 mrTemp.setDescription("同步成功");
								 mrTemp.setAdminID(adminID);
								 mrTemp.setDepartmentID(departmentID);
								 mrTemp.setAddressID(addressID);
								 availList.add(mrTemp);//加入可以导入的集合 
							 }
							  
							 
						   }
						   
					   }
				   }
			   }else{
				   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   mrTemp.setDescription("没有会议室编号");
			   }
			   
		   }
		   
		   for( MeetingRoomInterfaceVO temp : list){
			   mis.modify(temp);//修改接口表状态，描述
		   }
		   
		   for( MeetingRoomInterfaceVO temp  : availList){
			   MeetingRoomVO roomVO = toMeetingRoomVO(temp);
			   if( temp.getSqlType() == 2 ){
				   mrs.add(roomVO);//添加到核心表
			   }else if( temp.getSqlType() == 1){
				   mrs.updateByRoomNO(roomVO);
			   }
			   
		   }
		   
		   
		   WebContext wc =  WebContextFactory.get();
		   HttpServletRequest req = wc.getHttpServletRequest();
		   HttpSession  session = req.getSession();
		   
		   UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("从会议室接口表向会议室核心表同步了数据");
				new LogServiceImpl().add(logVO);
			}
		   
			
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		return "sucess";
	}
	
	/**
	 * 终端数据同步
	 * @return
	 */
	/*public String terminalImport(){
		TerminalInterfaceVO mrVO = new TerminalInterfaceVO();
		EquipmentVO equipmentVO = new EquipmentVO();
		EquipmentVO equipmentVO1 = new EquipmentVO();
		equipmentVO1.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);//类型为终端
		
		try{
			
			//将接口表名字字段转化为对应表主键 adminID  roomID equipmentMCUID
			
			HashMap<String,String> userMap = toAdminMap();
			
			HashMap<String,String> roomMap = toMeetingRoomMap();
			   
			HashMap<String,String> mcuMap = toMCUMap();
			
			
			
		   ArrayList<TerminalInterfaceVO> list = tis.queryAvailable(mrVO, null);//终端接口表未导入的数据集合
		   
		   ArrayList<EquipmentVO> equipmentList = es.query(equipmentVO, null);//数据库核心表已经存在的数据集合
		   ArrayList<EquipmentVO> equipmentList1 = es.query(equipmentVO1, null);
		   
		   for( int i=0; i<list.size(); i++ ){
			   TerminalInterfaceVO mrTemp = list.get(i);
			   if( mrTemp.getSerialNumber() != null ){
				   for( int j=0; j<list.size(); j++ ){
					   if( mrTemp.getIp().equalsIgnoreCase(list.get(j).getIp()) && (i != j ) ){//自身的ip重复
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("ip重复");
						   break;
					   }
					   if( mrTemp.getSerialNumber().equalsIgnoreCase(list.get(j).getSerialNumber()) && (i != j )){//自身序列号重复
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("序列号重复");
						   break;
					   }
					   if( mrTemp.getRoomName().equalsIgnoreCase(list.get(j).getRoomName()) && (i != j )){//自身所属会议室重复
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("所属会议室重复");
						   break;
					   }
					   
					   if( j ==  (list.size()- 1) ){ //还要与数据库验证
						    
						   
						   
						   if( isTerminalIpDuplicate(mrTemp, equipmentList)){//IP与数据库数据重复
							   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
							   mrTemp.setDescription("将要添加一个终端但ip重复");
							   break;
						   }else if( isBelongMeetingRoomDuplicate(mrTemp, equipmentList1)){//终端所属会议室与数据库中重复
							   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
							   mrTemp.setDescription("将要添加一个终端但所属会议室重复");
							   break;
							   
						   }else{//还要判断是否能关联到各个外键
							 
							 String adminID = getAdminID(mrTemp.getAdminName(),userMap);
							 String roomID = getRoomID(mrTemp.getRoomName(), roomMap);
							 String mcuID = getMCUID(mrTemp.getMcuIp(), mcuMap);
							 
							 if( adminID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("管理员没有匹配到ID");
								   break;
							 }else if ( roomID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("所属会议室没有匹配到ID");
								   break;
							 }else if (mcuID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("所属MCU没有匹配到ID");
								   break;
							 }else{
								 
								if( isSerialNumberDuplicate(mrTemp.getSerialNumber(), equipmentList1)){//serialNumber存在则为更新操作
									 mrTemp.setSqlType(DataInterfaceEnum.UPDATE_TYPE);
								 }else{//serialNumber不存在则为添加操作
									 mrTemp.setSqlType(DataInterfaceEnum.ADD_TYPE);
							    }
								  
								 mrTemp.setStatus(DataInterfaceEnum.IMPORT_SUCCESS);//标记为可以导入
								 mrTemp.setDescription("同步成功");
								 mrTemp.setAdminID(adminID);
								 mrTemp.setRoomID(roomID);
								 mrTemp.setMcuID(mcuID);
								 terAvailList.add(mrTemp);//加入可以导入的集合 
							 }
							  
							 
						   }
						   
					   }
				   }
			   }else{
				   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   mrTemp.setDescription("没有序列号");
			   }
			   
		   }
		   
		   for( TerminalInterfaceVO temp : list){
			   tis.modify(temp);//修改接口表状态，描述
		   }
		   
		   for( TerminalInterfaceVO temp  : terAvailList){
			   EquipmentVO equipmentTemp = toEquipmentVO(temp);
			   EquipmentTerminalVO terTemp = toEquipmentTerminalVO(temp);
			   if( temp.getSqlType() == 2 ){
				   es.addEquipmentTerminal(equipmentTemp, terTemp);//添加到核心表
			   }else if( temp.getSqlType() == 1){//更新操作
				   EquipmentVO evo = new EquipmentVO();
				   evo.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				   evo.setSerialNumber(temp.getSerialNumber());//根据序列号查询主键
				   evo = es.query(evo, null).get(0);
				   equipmentTemp.setEquipmentID(evo.getEquipmentID());
				   terTemp.setEquipmentID(evo.getEquipmentID());
				   es.modifyEquipmentTerminal(equipmentTemp, terTemp);//修改核心表对应数据
			   }
			   
		   }
		   
		   
		   WebContext wc =  WebContextFactory.get();
		   HttpServletRequest req = wc.getHttpServletRequest();
		   HttpSession  session = req.getSession();
		   
		   UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("从终端接口表向会议室核心表同步了数据");
				new LogServiceImpl().add(logVO);
			}
		   
			
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		return "sucess";
	}
	*/
	
	/**
	 * 设备数据同步
	 * @return
	 */
	public String equipmentImport(){
		EquipmentInterfaceVO miVO = new EquipmentInterfaceVO();
		EquipmentVO equipmentVO = new EquipmentVO();
		EquipmentVO equipmentVO1 = new EquipmentVO();
		equipmentVO1.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);//类型为终端
		
		try{
			
			//将接口表名字字段转化为对应表主键 adminID  roomID equipmentMCUID
			
			HashMap<String,String> userMap = toAdminMap();
			
			HashMap<String,String> roomMap = toMeetingRoomMap();
			   
			HashMap<String,String> mcuMap = toMCUMap();
			
			
			
		   ArrayList<EquipmentInterfaceVO> list = eis.queryAvailable(miVO, null);//设备接口表未导入的数据集合
		   
		   ArrayList<EquipmentVO> equipmentList = es.query(equipmentVO, null);//数据库核心表已经存在的数据集合
		   ArrayList<EquipmentVO> equipmentList1 = es.query(equipmentVO1, null);
		   
		   for( int i=0; i<list.size(); i++ ){
			   EquipmentInterfaceVO mrTemp = list.get(i);
			   
			   if( mrTemp.getSerialNumber() != null ){
				   for( int j=0; j<list.size(); j++ ){
					   if(  !StringUtils.isNullOrBlank(mrTemp.getIp()) && mrTemp.getIp().equalsIgnoreCase(list.get(j).getIp()) && (i != j ) ){//自身的ip重复
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("设备ip重复");
						   break;
					   }
					   if( mrTemp.getSerialNumber().equalsIgnoreCase(list.get(j).getSerialNumber()) && (i != j )){//自身序列号重复
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("序列号重复");
						   break;
					   }
//					  if( !StringUtils.isNullOrBlank(mrTemp.getRoomNO()) && mrTemp.getEquipmentType() == EquipmentEnum.TYPE_ID_TERMINAL && mrTemp.getRoomNO().equalsIgnoreCase(list.get(j).getRoomNO()) && (i != j )){//自身所属会议室重复
//							   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
//							   mrTemp.setDescription("所属会议室重复");
//							   break;
//					  }
					  if( !StringUtils.isNullOrBlank(mrTemp.getCommandIP()) && mrTemp.getEquipmentType() == EquipmentEnum.TYPE_ID_MCU && mrTemp.getCommandIP().equalsIgnoreCase(list.get(j).getCommandIP()) && (i != j )){//自身信令IP重复(mcu)
						   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   mrTemp.setDescription("信令IP重复");
						   break;
				      }
					   
					   
					   if( j ==  (list.size()- 1) ){ //还要与数据库验证
						    
						   
						   
						   if( isTerminalIpDuplicate(mrTemp, equipmentList)){//IP与数据库数据重复
							   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
							   mrTemp.setDescription("设备ip重复");
							   break;
						   }else if( !StringUtils.isNullOrBlank(mrTemp.getRoomNO()) && mrTemp.getEquipmentType() == EquipmentEnum.TYPE_ID_TERMINAL && isBelongMeetingRoomDuplicate(mrTemp, equipmentList1)){//终端所属会议室与数据库中重复
							   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
							   mrTemp.setDescription("所属会议室重复");
							   break;
							   
						   }else{//还要判断是否能关联到各个外键
							 
							 String adminID = getAdminID(mrTemp.getAdminName(),userMap);
							 String roomID = getRoomID(mrTemp.getRoomNO(), roomMap);
							 String mcuID = getMCUID(mrTemp.getMcuIp(), mcuMap);
							 
							 if( adminID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("管理员没有匹配到ID");
								   break;
							 }else if ( roomID == null ){
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("所属会议室没有匹配到ID");
								   break;
							 }else if ( mrTemp.getEquipmentType() == EquipmentEnum.TYPE_ID_TERMINAL && mcuID == null ){//终端的判断条件
								   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
								   mrTemp.setDescription("所属MCU没有匹配到ID");
								   break;
							 }else{
								 
								if( isSerialNumberDuplicate(mrTemp.getSerialNumber(), equipmentList)){//serialNumber存在则为更新操作
									 mrTemp.setSqlType(DataInterfaceEnum.UPDATE_TYPE);
								 }else{//serialNumber不存在则为添加操作
									 mrTemp.setSqlType(DataInterfaceEnum.ADD_TYPE);
							    }
								  
								 mrTemp.setStatus(DataInterfaceEnum.IMPORT_SUCCESS);//标记为可以导入
								 mrTemp.setDescription("同步成功");
								 mrTemp.setAdminID(adminID);
								 mrTemp.setRoomID(roomID);
								 mrTemp.setMcuID(mcuID);
								 terAvailList.add(mrTemp);//加入可以导入的集合 
							 }
							  
							 
						   }
						   
					   }
				   }
			   }else{
				   mrTemp.setStatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   mrTemp.setDescription("没有序列号");
			   }
			   
		   }
		   
		   for( EquipmentInterfaceVO temp : list){
			   eis.modify(temp);//修改接口表状态，描述
		   }
		   
		   for( EquipmentInterfaceVO temp  : terAvailList){
			   if( temp.getEquipmentType() == EquipmentEnum.TYPE_ID_TERMINAL  ){//终端
				   EquipmentVO equipmentTemp = toEquipmentVO(temp,EquipmentEnum.TYPE_ID_TERMINAL ,"终端");
				   EquipmentTerminalVO terTemp = toEquipmentTerminalVO(temp);
				   if( temp.getSqlType() == 2 ){
					   es.addEquipmentTerminal(equipmentTemp, terTemp);//添加到核心表
				   }else if( temp.getSqlType() == 1){//更新操作
					   EquipmentVO evo = new EquipmentVO();
					   evo.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
					   evo.setSerialNumber(temp.getSerialNumber());//根据序列号查询主键
					   evo = es.query(evo, null).get(0);
					   equipmentTemp.setEquipmentID(evo.getEquipmentID());
					   terTemp.setEquipmentID(evo.getEquipmentID());
					   es.modifyEquipmentTerminal(equipmentTemp, terTemp);//修改核心表对应数据
				   }
			   }else if( temp.getEquipmentType() ==  EquipmentEnum.TYPE_ID_MCU ){//MCU
				   EquipmentVO equipmentTemp = toEquipmentVO(temp,EquipmentEnum.TYPE_ID_MCU,"MCU");
				   EquipmentMcuVO terTemp = toEquipmentMCUVO(temp);
				   if( temp.getSqlType() == 2 ){
					   es.addEquipmentMcu(equipmentTemp, terTemp);//添加到核心表
				   }else if( temp.getSqlType() == 1){//更新操作
					   EquipmentVO evo = new EquipmentVO();
					   evo.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
					   evo.setSerialNumber(temp.getSerialNumber());//根据序列号查询主键
					   evo = es.query(evo, null).get(0);
					   equipmentTemp.setEquipmentID(evo.getEquipmentID());
					   terTemp.setEquipmentID(evo.getEquipmentID());
					   es.modifyEquipmentMcu(equipmentTemp, terTemp);//修改核心表对应数据
				   }
			   }else if( temp.getEquipmentType() == EquipmentEnum.TYPE_ID_CENTERCONTROL ){//中控
				   EquipmentVO equipmentTemp = toEquipmentVO(temp,EquipmentEnum.TYPE_ID_CENTERCONTROL,"中控");
				   if( temp.getSqlType() == 2 ){
					   es.add(equipmentTemp);//添加到核心表
				   }else if( temp.getSqlType() == 1){//更新操作
					   EquipmentVO evo = new EquipmentVO();
					   evo.setEquipmentType(EquipmentEnum.TYPE_ID_CENTERCONTROL);
					   evo.setSerialNumber(temp.getSerialNumber());//根据序列号查询主键
					   evo = es.query(evo, null).get(0);
					   equipmentTemp.setEquipmentID(evo.getEquipmentID());
					   es.modify(equipmentTemp);//修改核心表对应数据
				   }
			   }else if( temp.getEquipmentType() == EquipmentEnum.TYPE_ID_VIDEOCARD){//对比卡
				   EquipmentVO equipmentTemp = toEquipmentVO(temp,EquipmentEnum.TYPE_ID_VIDEOCARD,"对比卡");
				   VideoCardVO terTemp = toVideoCardVO(temp);
				   if( temp.getSqlType() == 2 ){
					   es.addEquipmentVideoCard(equipmentTemp, terTemp);//添加到核心表
				   }else if( temp.getSqlType() == 1){//更新操作
					   EquipmentVO evo = new EquipmentVO();
					   evo.setEquipmentType(EquipmentEnum.TYPE_ID_VIDEOCARD);
					   evo.setSerialNumber(temp.getSerialNumber());//根据序列号查询主键
					   evo = es.query(evo, null).get(0);
					   equipmentTemp.setEquipmentID(evo.getEquipmentID());
					   terTemp.setEquipmentID(evo.getEquipmentID());
					   es.modifyVideoCard(equipmentTemp, terTemp);//修改核心表对应数据
				   }
			   }else if( temp.getEquipmentType() == EquipmentEnum.TYPE_ID_OTHEREQUIPMENT ){//其他设备
				   EquipmentVO equipmentTemp = toEquipmentVO(temp,EquipmentEnum.TYPE_ID_OTHEREQUIPMENT,"其他设备");
				   if( temp.getSqlType() == 2 ){
					   es.addEqupment(equipmentTemp);//添加到核心表
				   }else if( temp.getSqlType() == 1){//更新操作
					   EquipmentVO evo = new EquipmentVO();
					   evo.setEquipmentType(EquipmentEnum.TYPE_ID_OTHEREQUIPMENT);
					   evo.setSerialNumber(temp.getSerialNumber());//根据序列号查询主键
					   evo = es.query(evo, null).get(0);
					   equipmentTemp.setEquipmentID(evo.getEquipmentID());
					   es.modify(equipmentTemp);//修改核心表对应数据
				   }
			   }
			   
			   
			   
		   }
		   
		   
		   WebContext wc =  WebContextFactory.get();
		   HttpServletRequest req = wc.getHttpServletRequest();
		   HttpSession  session = req.getSession();
		   
		   UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("从设备接口表向会议室核心表同步了数据");
				new LogServiceImpl().add(logVO);
			}
		   
			
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		return "sucess";
	}
	
	
	/**
	 * 
	 * 不同会议编号下会议室名字是否重名
	 */
	private boolean isRoomNameDuplicate( MeetingRoomInterfaceVO mrTemp , ArrayList<MeetingRoomVO> roomList){
		for( MeetingRoomVO mr :  roomList){
			if( mr.getMeetingRoomName().equalsIgnoreCase(mrTemp.getMeetingroomName()) && !(mr.getRoomNO().equalsIgnoreCase(mrTemp.getRoomNO()))){
				return true;
			}
		}
		return false;
	}
	
	
	private boolean isRoleIdDuplicate( RoleInterfaceVO riTemp , ArrayList<RoleVO> roleList){
		for( RoleVO rif :  roleList){
			if( riTemp.getRoleid().equalsIgnoreCase(rif.getRoleID())){
				return true;
			}
		}
		return false;
	}
	
	private boolean isRoomNODuplicate( String roomNO , ArrayList<MeetingRoomVO> roomList){
		for( MeetingRoomVO mr :  roomList){
			if( mr.getRoomNO().equalsIgnoreCase(roomNO)){
				return true;
			}
		}
		return false;
	}
	
	
	private boolean isSerialNumberDuplicate( String serialNumber , ArrayList<EquipmentVO> equipmentList){
		for( EquipmentVO mr :  equipmentList){
			if( serialNumber.equalsIgnoreCase(mr.getSerialNumber())){
				return true;
			}
		}
		return false;
	}
	
	private boolean isUserIdDuplicate( String userId , ArrayList<UserVO> userList){
		for( UserVO uv :  userList){
			if( uv.getUserID().equalsIgnoreCase(userId)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断IP是在已经在数据库存在(是否有不同serialNumber下ip相同的情况)
	 * @param ip
	 * @return
	 */
	private boolean isTerminalIpDuplicate( EquipmentInterfaceVO tiVO , ArrayList<EquipmentVO> equipmentList){
		for( EquipmentVO mr :  equipmentList){
			if( mr.getIp().equalsIgnoreCase(tiVO.getIp()) && !(mr.getSerialNumber().equalsIgnoreCase(tiVO.getSerialNumber()))){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * 判断数据库中该会议室下是否已有终端(是否有serialNumber不同所属会议室相同的情况 )
	 * @param ip
	 * @param equipmentList
	 * @return
	 */
	private boolean isBelongMeetingRoomDuplicate( EquipmentInterfaceVO tiVO , ArrayList<EquipmentVO> equipmentList){
		for( EquipmentVO mr :  equipmentList){
			if( tiVO.getRoomNO().equalsIgnoreCase(mr.getMeetingRoomVO().getRoomNO()) && !(tiVO.getSerialNumber().equalsIgnoreCase(mr.getSerialNumber())) ){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 人员Map
	 * @return
	 * @throws Exception
	 */
	private HashMap<String,String> toAdminMap() throws Exception{
		UserVO vUserVO = new  UserVO();
		vUserVO.setState(UserEnum.VALID);
		ArrayList<UserVO> list =  us.getUserList(vUserVO, null);
		
		
		HashMap<String,String> adminMap = new HashMap<String, String>();
		for( UserVO temp : list){
			adminMap.put(temp.getLoginName(), temp.getUserID());
		}
		return adminMap;
	}
	
	/**
	 * 部门(单位)MAP
	 */
	private HashMap<String,String> toDepartmentMap() throws Exception{
		ArrayList<DepartmentVO> list = ds.getAllFuncList(new DepartmentVO(), null);
		HashMap<String,String> map = new HashMap<String, String>();
		for( DepartmentVO temp : list){
			map.put(temp.getTitle(), temp.getId());
		}
		return map;
	}
	
	/**
	 * 区域MAP
	 * @return
	 * @throws Exception
	 */
	private HashMap<String,String> toAddressMap() throws Exception{
		AddressVO addressVO  = new AddressVO();
		ArrayList<AddressVO> list = as.query(addressVO, null);
		HashMap<String,String> map = new HashMap<String, String>();
		for( AddressVO temp : list){
			map.put(temp.getName(), temp.getAddressID());
		}
		return map;
	}
	
	/**
	 * 所有MCU设备MAP
	 * @return
	 * @throws Exception
	 */
	private HashMap<String,String> toMCUMap() throws Exception{
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		ArrayList<EquipmentVO> list = es.query(equipmentVO, null);
		HashMap<String,String> map = new HashMap<String, String>();
		for( EquipmentVO temp : list){
			map.put(temp.getIp(), temp.getEquipmentID());
		}
		return map;
	}
	
	/**
	 * 会议室Map
	 * @return
	 * @throws Exception
	 */
	private HashMap<String,String> toMeetingRoomMap() throws Exception{
		MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
		ArrayList<MeetingRoomVO> list = mrs.query(meetingRoomVO, null);
		HashMap<String,String> map = new HashMap<String, String>();
		for( MeetingRoomVO temp : list){
			map.put(temp.getRoomNO(), temp.getMeetingRoomID());//NO,ID
		}
		return map;
	}
	
	
	/**
	 * 角色Map
	 * @return
	 * @throws Exception
	 */
	private HashMap<String,String> toRoleMap() throws Exception{
		RoleVO roleVO = new RoleVO();
		ArrayList<RoleVO> list = rs.getRoleList(roleVO, null);
		HashMap<String,String> map = new HashMap<String, String>();
		for( RoleVO temp : list){
			map.put(temp.getRoleName(), temp.getRoleID());
		}
		return map;
	}
	
	private String getAdminID( String name , HashMap<String,String> userMap){
		String id = userMap.get(name);
		return id;
	}
	
	private String getAddressID( String name , HashMap<String,String> addressMap){
		String id = addressMap.get(name);
		return id;
	}

	private String getDepartmentID( String name , HashMap<String,String> departmentMap){
		String id = departmentMap.get(name);
		return id;
	}

	private String getRoomID( String name , HashMap<String,String> roomMap ){
		String id = roomMap.get(name);
		return id;
	}
	
	private String getMCUID( String ip , HashMap<String,String> mcuMap ){
		String id = mcuMap.get(ip);
		return id;
	}
	
	private MeetingRoomVO toMeetingRoomVO ( MeetingRoomInterfaceVO temp ){
		MeetingRoomVO mrVO = new MeetingRoomVO();
		UserVO userVO = new UserVO();
		DepartmentVO dpVO = new DepartmentVO();
		AddressVO addVO = new AddressVO();
		
		
		mrVO.setMeetingRoomName(temp.getMeetingroomName());
		mrVO.setRoomNO(temp.getRoomNO());
		mrVO.setMeetingRoomType(temp.getMeetingRoomType());
		mrVO.setCapacity(temp.getCapacity());
		mrVO.setStatus(temp.getMeetingRoomStatus());
		userVO.setUserID(temp.getAdminID());
		mrVO.setUserVO(userVO);
		
		dpVO.setId(temp.getDepartmentID());
		mrVO.setDepartmentVO(dpVO);
		
		addVO.setAddressID(temp.getAddressID());
		mrVO.setAddressVO(addVO);
		
		return mrVO;
		
	}
	
	private EquipmentVO toEquipmentVO( EquipmentInterfaceVO tif , int type , String name){
		EquipmentVO equipmentVO = new EquipmentVO();
		
		equipmentVO.setEquipmentType(type);
		equipmentVO.setEquipmentName(name);
		equipmentVO.setEquipmentModel(tif.getEquipmentModel());
		equipmentVO.setEquipmentNO(tif.getEquipmentNO());
		equipmentVO.setStatus(tif.getEquipmentStatus());
		equipmentVO.setMac(tif.getMac());
		equipmentVO.setIp(tif.getIp());
		equipmentVO.setPort(tif.getPort());
		equipmentVO.getMeetingRoomVO().setMeetingRoomID(tif.getRoomID());
		equipmentVO.getUserVO().setUserID(tif.getAdminID());
		equipmentVO.setSerialNumber(tif.getSerialNumber());
		equipmentVO.setEquipmentIdentifier(tif.getEquipmentIdentifier());
		equipmentVO.setDescription(tif.getEquipmentDesc());
		
		equipmentVO.setMaintenanceStartTime(tif.getMaintainceStartTime());
		//维保到期日
		if( tif.getMaintainceStartTime()!= null && tif.getMaintainMonth() != Integer.MIN_VALUE ){
			int durinMonths = tif.getMaintainMonth();
			Long st = tif.getMaintainceStartTime().getTime();
			Calendar sc = Calendar.getInstance();
			sc.setTimeInMillis(st);
			sc.add(Calendar.MONTH, durinMonths);
		    Long et = sc.getTimeInMillis();
		    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
		}
		
		return equipmentVO;
	}
	
	
	private EquipmentTerminalVO toEquipmentTerminalVO( EquipmentInterfaceVO tif ){
		EquipmentTerminalVO equipmentTerminalVO = new EquipmentTerminalVO();
		equipmentTerminalVO.setLoginName(tif.getLoginName());
		equipmentTerminalVO.setLoginPassword(tif.getLoginPassword());
		equipmentTerminalVO.setEquipmentMCUID(tif.getMcuID());
		
		return equipmentTerminalVO;
	}
	
	private EquipmentMcuVO toEquipmentMCUVO( EquipmentInterfaceVO tif ){
		EquipmentMcuVO equipmentMcuVO = new EquipmentMcuVO();
		equipmentMcuVO.setLoginName(tif.getLoginName());
		equipmentMcuVO.setLoginPassword(tif.getLoginPassword());
		equipmentMcuVO.setCommandIP(tif.getCommandIP());
		
		return equipmentMcuVO;
	}
	
	/**
	 * 转化为对比卡VO
	 * @param tif
	 * @return
	 */
	private VideoCardVO toVideoCardVO( EquipmentInterfaceVO tif ){
		VideoCardVO videoCardVO = new VideoCardVO();
		
		if( !StringUtils.isNullOrBlank(tif.getAppraisalTaskNum()) ){
			videoCardVO.setAppraisalTaskNum(tif.getAppraisalTaskNum());
		}else{
			videoCardVO.setAppraisalTaskNum("A8");
		}
		
		if( !StringUtils.isNullOrBlank(tif.getShowFormatFlag()) ){
			videoCardVO.setShowFormatFlag(tif.getShowFormatFlag());
		}else{
			videoCardVO.setShowFormatFlag("B8");
		}
		
		if( !StringUtils.isNullOrBlank(tif.getInputModel()) ){
			videoCardVO.setInputModel(tif.getInputModel());
		}else{
			videoCardVO.setInputModel("D2");
		}
		
		if( !StringUtils.isNullOrBlank(tif.getOutputModel()) ){
			videoCardVO.setOutputModel(tif.getOutputModel());
		}else{
			videoCardVO.setOutputModel("C2");
		}
		
		if( !StringUtils.isNullOrBlank(tif.getAppraisalModel()) ){
			videoCardVO.setAppraisalModel(tif.getAppraisalModel());
		}else{
			videoCardVO.setAppraisalModel("E5");
		}
		
		if( !StringUtils.isNullOrBlank(tif.getCollectModel()) ){
			videoCardVO.setCollectModel(tif.getCollectModel());
		}else{
			videoCardVO.setCollectModel("F1");
		}
		
		videoCardVO.setLoginName(tif.getLoginPassword());
		videoCardVO.setLoginPassWord(tif.getLoginPassword());
		
		return videoCardVO;
	}
	
	private RoleVO toRoleVO( RoleInterfaceVO rle ){
		RoleVO role = new RoleVO();
		
		Date tempDate = new Date(System.currentTimeMillis());
		role.setRoleID(rle.getRoleid());//利用接口表的主键作为主键
		role.setRoleName(rle.getRolename());
		role.setCreate_date(new SimpleDateFormat("yyyy-MM-dd hh:mm").format(tempDate));
		role.setNote(rle.getDescription());
		role.setCreate_by(rle.getCreatorid());
		role.setStatus(UserEnum.VALID+"");
		
		/* wc =  WebContextFactory.get();
		   HttpServletRequest req = wc.getHttpServletRequest();
		   HttpSession  session = req.getSession();
		   
		   UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				role.setCreate_by(sessionUserVO.getLoginName());
			}*/
		
		
		return role;
	}
	
	
	private UserVO toUserVO( UserInterfaceVO ule ) throws Exception{
		UserVO user = new UserVO();
		
		user.setUserID(ule.getUserid());//利用接口表的id作为核心表id
		user.setLoginName(ule.getLoginname());
		if( !StringUtils.isNullOrBlank(ule.getPassword())){
			user.setPassWord(DES.encryptPassword(ule.getPassword()));
			
		}else{
			user.setPassWord(DES.encryptPassword(DataInterfaceEnum.PSW_DEFAULT));//默认密码
		}
		user.setName(ule.getFullname());
		user.setEmail(ule.getEmail());
		user.setMobile(ule.getMobilephone());
		user.setState(UserEnum.VALID);
		user.getDepartmentVO().setId(ule.getDepartmentid());
		user.setRoleid(ule.getRoleid());
		
		return user;
	}
	
	/**
	 * 接口表对象转化为核心表对象
	 * @param rle
	 * @return
	 */
	private DepartmentVO toDepartmentVO( DepartmentInterfaceVO dif ){
		DepartmentVO dpt = new DepartmentVO();
		
		dpt.setId(dif.getDepartmentid());//id
		dpt.setTitle(dif.getDepartmentname());//name
		dpt.setParentId(dif.getParentid());
		if( dif.getParentid().equals("-1")){
			dpt.setLeaf(1);
		}else{
			dpt.setLeaf(0);
		}
		
		
		return dpt;
	}
	
	/**
	 * 角色导入
	 * @return
	 */
	public String roleImport(){
		RoleInterfaceVO riVO = new RoleInterfaceVO();
		RoleVO roleVO = new RoleVO();
		
		ArrayList<RoleInterfaceVO> roleList = new ArrayList<RoleInterfaceVO>();
		
		try{
			
		   ArrayList<RoleInterfaceVO> list = rif.queryAvailable(riVO, null);//接口表未导入的数据集合
		   
		   ArrayList<RoleVO> rolemList = rs.getRoleList(roleVO, null);//数据库核心表(role)已经存在的数据集合
		   
		   for( int i=0; i<list.size(); i++ ){
			   RoleInterfaceVO riTemp = list.get(i);
			   if( !StringUtils.isNullOrBlank(riTemp.getRolename())){
				   for( int j=0; j<list.size(); j++ ){
					   if( riTemp.getRolename().equalsIgnoreCase(list.get(j).getRolename()) && (i != j ) ){//自身的角色名字重复
						   riTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   riTemp.setImportdesc("角色名字重复");
						   break;
					   }
					   
					   if( j ==  (list.size()- 1) ){ //还要与数据库验证
							   if( isRoleIdDuplicate(riTemp, rolemList)){//roleid存在则为更新操作
								   riTemp.setSqlType(DataInterfaceEnum.UPDATE_TYPE);
								 }else{//roomNO不存在则为添加操作
									riTemp.setSqlType(DataInterfaceEnum.ADD_TYPE);
							   }
								 
							     riTemp.setImportstatus(DataInterfaceEnum.IMPORT_SUCCESS);//标记为可以导入
							     riTemp.setImportdesc("同步成功");
							     roleList.add(riTemp);//加入可以导入的集合 
					   }
				   }
			   }else{
				   riTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   riTemp.setImportdesc("没有角色名");
			   }
			   
		   }
		   
		   for( RoleInterfaceVO temp : list){
			   rif.modify(temp);//修改接口表状态，描述
		   }
		   
		   for( RoleInterfaceVO temp  : roleList){
			   RoleVO rv = toRoleVO(temp);
			   if( temp.getSqlType() == 2 ){
				   try{
					   rs.addRoleByCreateId(rv, null);//添加到核心表
				   }catch( SQLException esql){
					   continue;//添加失败进行下一次操作
				   }
				   
			   }else if( temp.getSqlType() == 1){
				   try{
					   //RoleVO rv1 =  rs.getRoleList(rv, null).get(0);
					   //rv.setRoleID(rv1.getRoleID());
					   rs.modifyRole(rv, null);
				   }catch( SQLException esql){
					   continue;//修改失败进行下一次操作
				   }
				  
			   }
			   
		   }
		   
		   
		   WebContext wc =  WebContextFactory.get();
		   HttpServletRequest req = wc.getHttpServletRequest();
		   HttpSession  session = req.getSession();
		   
		   UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("从角色接口表向角色核心表同步了数据");
				new LogServiceImpl().add(logVO);
			}
		   
			
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		return "sucess";
	}
	
	
	/**
	 * 组织结构导入
	 * @return
	 */
	public String departmentImport(){
		DepartmentInterfaceVO diVO = new DepartmentInterfaceVO();
		
		ArrayList<DepartmentInterfaceVO> diList = new ArrayList<DepartmentInterfaceVO>();
		
		try{
			
		   ArrayList<DepartmentInterfaceVO> list = dis.queryAvailable(diVO, null);//接口表未导入的数据集合
		   
		   
		   
		   for( int i=0; i<list.size(); i++ ){
			   DepartmentInterfaceVO diTemp = list.get(i);
			   if( !StringUtils.isNullOrBlank(diTemp.getParentid())){//父ID不为空
				     diTemp.setImportstatus(DataInterfaceEnum.IMPORT_SUCCESS);//标记为可以导入
				     diTemp.setImportdesc("同步成功");
				     diList.add(diTemp);//加入可以导入的集合 
			   }else{
				   diTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   diTemp.setImportdesc("父ID为空");
			   }
			   
		   }
		   
		   for( DepartmentInterfaceVO temp : list){
			   dis.modify(temp);//修改接口表状态，描述
		   }
		   
		   if( diList !=null && diList.size()>0 ){
			   ds.deleteAll();//清除核心表数据
		   }
		   
		   for( DepartmentInterfaceVO temp  : diList){
			   DepartmentVO rv = toDepartmentVO(temp);
			   try{
				   ds.addDepartment(rv,false);
			   }catch( Exception e ){
				   continue;
			   }
			    
		   }
		   
	   /*
		   WebContext wc =  WebContextFactory.get();
		   HttpServletRequest req = wc.getHttpServletRequest();
		   HttpSession  session = req.getSession();
		   
		   UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("从组织结构接口表向组织结构核心表同步了数据");
				new LogServiceImpl().add(logVO);
			}
		   
			*/
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		return "sucess";
	}
	
	/**
	 * 用户同步
	 * @return
	 */
	public String userImport(){
		UserInterfaceVO uiVO = new UserInterfaceVO();
		UserVO userVO = new UserVO();
		
		ArrayList<UserInterfaceVO> userList = new ArrayList<UserInterfaceVO>();
		
		try{
			
			//将接口表名字字段转化为对应表主键 roleID  departmentID 
			
			HashMap<String,String> userMap = toRoleMap();//role Map	
		
			
		   ArrayList<UserInterfaceVO> list = uis.queryAvailable(uiVO, null);//接口表未导入的数据集合
		   
		   userVO.setState(UserEnum.VALID);
		   //ArrayList<UserVO> usermList = us.getUserList(userVO, null);//数据库核心表(user)已经存在的数据集合
		   
		   for( int i=0; i<list.size(); i++ ){
			   UserInterfaceVO uiTemp = list.get(i);
			   if( StringUtils.isNullOrBlank(uiTemp.getDepartmentid())){
				   uiTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   uiTemp.setImportdesc("部门id为空");
				   continue;
			   }
			   //无需过滤角色
			  /* if( StringUtils.isNullOrBlank(uiTemp.getRolename())){
				   uiTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   uiTemp.setImportdesc("角色名字为空");
				   continue; 
			   }*/
			   if( !StringUtils.isNullOrBlank(uiTemp.getLoginname())){
				   for( int j=0; j<list.size(); j++ ){
					   if( uiTemp.getLoginname().equalsIgnoreCase(list.get(j).getLoginname()) && (i != j ) ){//自身的用户名字重复
						   uiTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
						   uiTemp.setImportdesc("用户名重复");
						   break;
					   }
					   
					   if( j ==  (list.size()- 1) ){ //还要与数据库验证
						   
							   /*if( isUserIdDuplicate(uiTemp.getUserid(), usermList)){//用户id存在则为更新操作
								   
								     uiTemp.setSqlType(DataInterfaceEnum.UPDATE_TYPE);
								 }else{//用户id不存在则为添加操作
									 uiTemp.setSqlType(DataInterfaceEnum.ADD_TYPE);
							   }*/
						   		StringBuffer roleIds = new StringBuffer();
						      if(uiTemp.getRolename()!=null){
						   		String[] roleNames = uiTemp.getRolename().split(",");
						      
						       for( int l=0; l<roleNames.length; l++){
						    	   String roleId = userMap.get(roleNames[l]);//拼接系统roleid  例801，802，803
						    	   if( roleId != null ){
						    		   if( roleIds.toString().length() >0 ){
						    			   roleIds.append(",");
						    		   }
						    		   roleIds.append(roleId);
						    		   
						    	   }
						       }
						      }
						     //  if( roleIds.toString().length() == 0 ){//没有匹配到任何角色
						    //	   uiTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
							//	   uiTemp.setImportdesc("没有匹配到角色");
						    //   }else{
						         uiTemp.setRoleid(roleIds.toString());
								 
							     uiTemp.setImportstatus(DataInterfaceEnum.IMPORT_SUCCESS);//标记为可以导入
							     uiTemp.setImportdesc("同步成功");
							     userList.add(uiTemp);//加入可以导入的集合
						    //   }
							   
					   }
				   }
			   }else{
				   uiTemp.setImportstatus(DataInterfaceEnum.IMNPORT_FAILURE);//标记为导入失败状态
				   uiTemp.setImportdesc("用户名为空");
			   }
			   
		   }
		   
		   for( UserInterfaceVO temp : list){
			   uis.modify(temp);//修改接口表状态，描述
		   }
		   
		   if( userList!=null && userList.size()>0 ){//清空user表及其关联数据
			   TransactionManager tManager = null;
			   try{
				   tManager = new TransactionManager();
				   tManager.beginTransaction();
				   ServiceFactory.getUserService().delAllUser(tManager);
				   new UserRoleServiceImpl().delAllUserRole(tManager);
				   new UserDepartmentServiceImpl().delAllDepUser(tManager); 
				   
			   }catch( SQLException sql){
				   tManager.rollback();
			   }
			   tManager.commit();
		   }
		   
		   for( UserInterfaceVO temp  : userList){
					   UserVO rv = toUserVO(temp);
					   UserDepartmentVO userDepartmentVO = new UserDepartmentVO();
					   UserRoleVO userRoleVO = new UserRoleVO();
					   /*if( temp.getSqlType() == 2 ){//添加操作*/
						 // TransactionManager tManager1 = null;
						  try{   
						//	tManager1 = new TransactionManager();
						  
						  //  tManager1.beginTransaction();
						    rv = us.addUserByCreateId(rv, null);//添加到核心表
						    //user_role表操作  user_department表操作
						   
						    userDepartmentVO.setUserVO(rv);//userid
						    userDepartmentVO.getDepartmentVO().setId(rv.getDepartmentVO().getId());//dptid
							//department
						    UserDepartmentService userDepartmentService = new UserDepartmentServiceImpl();
						    userDepartmentService.addUserDepartment(userDepartmentVO, null);
						    /////////role
						    
						    String[] rids = rv.getRoleid().split(",");
						    if(!rids[0].equals("")){
							    for( int n=0; n<rids.length; n++ ){
							    	userRoleVO.setUserID(rv.getUserID());//userid
								    userRoleVO.setRoleID(rids[n]);//roleid
									
									ArrayList<UserRoleVO> urlist = new ArrayList<UserRoleVO>();
									urlist.add(userRoleVO);
									UserRoleService userRoleService = new UserRoleServiceImpl();
									userRoleService.addUserRole(urlist, null);
							    }
						    }
						  }catch (Exception e) {
							 
							//  if(tManager1!=null){
							//		 tManager1.rollback();
							//	}
							  e.printStackTrace();
							  continue;
						  }
						 // tManager1.commit();
						 /*  }else if( temp.getSqlType() == 1){
							   TransactionManager tManager = null;
								  try{   
									//List<UserVO> um = UserDAO.getUserListbyName(rv, null);
									  
									tManager = new TransactionManager();
								  
								    tManager.beginTransaction();
								    rv = us.modifyUser(rv, tManager);//修改核心user表
								    //rv.setUserID(um.get(0).getUserID());
								    //user_role表操作  user_department表操作
								   
								    userDepartmentVO.setUserVO(rv);//userid
								    userDepartmentVO.getDepartmentVO().setId(rv.getDepartmentVO().getId());//dptid
									//department
								    UserDepartmentService userDepartmentService = new UserDepartmentServiceImpl();
								    userDepartmentService.modifyUserDepartment(userDepartmentVO, tManager);
								    /////////role
								    userRoleVO.setUserID(rv.getUserID());//userid
								    userRoleVO.setRoleID(rv.getRoleid());//roleid
									
									ArrayList<UserRoleVO> urlist = new ArrayList<UserRoleVO>();
									urlist.add(userRoleVO);
									UserVO t_u = new UserVO();
									t_u.getUserRoleVOList().add(userRoleVO);
									UserRoleService userRoleService = new UserRoleServiceImpl();
									userRoleService.modifyUserRole(t_u, tManager);//修改user_role表
								    
								    tManager.commit();
							   
							   
							  
						   }catch (Exception e) {
								  if(tManager!=null){
										 tManager.rollback();
									}
								  continue;
							  }
						   
					   }*/
		   
					/*
					   WebContext wc =  WebContextFactory.get();
					   HttpServletRequest req = wc.getHttpServletRequest();
					   HttpSession  session = req.getSession();
					   
					   UserVO sessionUserVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
						if( sessionUserVO != null ){
							LogVO  logVO  = new LogVO();
							logVO.setLogType(LogEnum.TYPE_DEFAULT);
							logVO.setLevel(LogEnum.LEVEL_DeFAULT);
							logVO.setUserID(sessionUserVO.getUserID());
							logVO.setUserName(sessionUserVO.getName());
							logVO.setOperatorContent("从用户接口表向用户核心表同步了数据");
							new LogServiceImpl().add(logVO);
						}
						
		   */
		   }
		}catch( Exception e ){
			e.printStackTrace();
		}
		
		return "sucess";
	}

	
	
}
