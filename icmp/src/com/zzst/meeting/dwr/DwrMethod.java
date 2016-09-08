package com.zzst.meeting.dwr;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.json.types.JsonArray;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cbf.db.DBConnectionException;
import com.cbf.db.TransactionManager;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.camera.CameraAction;
import com.zzst.action.meeting.meeting.McuControlDwr;
import com.zzst.action.meeting.util.ApplyDetailUtil;
import com.zzst.action.meeting.util.DelFileUtil;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.task.FixedTimeTask2;
import com.zzst.action.meeting.util.tools.Eryptogram;
import com.zzst.action.meeting.util.tools.MD5;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMainVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.CommandHelp;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.AudioControlVO;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.PlaVO;
import com.zzst.centerContor.vo.SysPowerVO;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.meetingDetailRoom.MeetingDetailRoomDAO;
import com.zzst.kst.service.KstObject;
import com.zzst.kst.service.impl.KstObjectImpl;
import com.zzst.kst.service.impl.vo.Camera;
import com.zzst.kst.service.impl.vo.GroupsOut.Group;
import com.zzst.kst.service.impl.vo.GroupsOut.Group.SubGroup;
import com.zzst.kst.service.impl.vo.GroupsOut.Group.SubGroup.TreeGroup;
import com.zzst.kst.service.impl.vo.KstVO;
import com.zzst.kst.service.impl.vo.Presets;
import com.zzst.kst.service.impl.vo.Presets.Node;
import com.zzst.meeting.dwr.dataShare.SynchronizeThread;
import com.zzst.meeting.util.test.wordExport.WordExport;
import com.zzst.model.enums.AddressEnu;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.CenterControlEnum;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.FileEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.MeetingParticipatEnum;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.enums.MeetingTypeEnum;
import com.zzst.model.enums.TemplateEquipmentEnum;
import com.zzst.model.enums.UseStatusEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.announcement.AnnouncementVO;
import com.zzst.model.meeting.apply.applyDetail.ApplyDetailVO;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.auth.RoleFunc;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.centerControl.CenterControlVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.cost.MeetingDetailCostVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.equipment.EquipmentBackupVO;
import com.zzst.model.meeting.equipment.EquipmentCameraVO;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.kst.CameraGroup;
import com.zzst.model.meeting.kst.WallPresetVO;
import com.zzst.model.meeting.level.LevelVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.meeting.MeetingVO;
import com.zzst.model.meeting.meetingAccreditation.MeetingAccreditationVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.post.PostVO;
import com.zzst.model.meeting.service.ServiceVO;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;
import com.zzst.model.meeting.uploadFile.UploadFileImpowerVO;
import com.zzst.model.meeting.uploadFile.UploadFileVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.userDepartment.UserDepartmentVO;
import com.zzst.model.meeting.userRole.UserRoleVO;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;
import com.zzst.service.meeting.announcement.AnnouncementService;
import com.zzst.service.meeting.announcement.AnnouncementServiceImpl;
import com.zzst.service.meeting.auth.FuncServiceImpl;
import com.zzst.service.meeting.auth.RoleService;
import com.zzst.service.meeting.auth.RoleServiceImpl;
import com.zzst.service.meeting.baseinfo.BaseInfoService;
import com.zzst.service.meeting.centerControl.CenterControlService;
import com.zzst.service.meeting.centerControl.CenterControlServiceImpl;
import com.zzst.service.meeting.cost.MeetingDetailCostService;
import com.zzst.service.meeting.cost.MeetingDetailCostServiceImpl;
import com.zzst.service.meeting.dictionary.DictionaryService;
import com.zzst.service.meeting.dictionary.DictionaryServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentMcuService;
import com.zzst.service.meeting.equipment.EquipmentMcuServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentService;
import com.zzst.service.meeting.equipment.EquipmentServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentTerminalServiceImpl;
import com.zzst.service.meeting.kst.KstVedioMoniterServiceImpl;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;
import com.zzst.service.meeting.meeting.MeetingService;
import com.zzst.service.meeting.meeting.MeetingServiceImpl;
import com.zzst.service.meeting.meetingAccreditation.MeetingAccreditationService;
import com.zzst.service.meeting.meetingAccreditation.MeetingAccreditationServiceImpl;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;
import com.zzst.service.meeting.meetingDetailEquipment.MeetingDetailEquipmentServiceImpl;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserService;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserServiceImpl;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.meetingRoom.MeetingRoomServiceImpl;
import com.zzst.service.meeting.post.PostService;
import com.zzst.service.meeting.post.PostServiceImpl;
import com.zzst.service.meeting.service.ServiceService;
import com.zzst.service.meeting.service.ServiceServiceImpl;
import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.user.UserServiceImpl;
import com.zzst.service.meeting.userDepartment.UserDepartmentService;
import com.zzst.service.meeting.userDepartment.UserDepartmentServiceImpl;
import com.zzst.service.meeting.userRole.UserRoleService;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.ZZSTControlException;

public class DwrMethod {
	private static Logger logger = CjfLogger
	.getLogger(DwrMethod.class.getName());

	private UserRoleVO userRoleVO = new UserRoleVO();

	private UserVO user1VO = new UserVO();

	private ArrayList<EquipmentVO> equipmentVOList = new ArrayList<EquipmentVO>();

	private ArrayList<AnnouncementVO> announcmentVOList = new ArrayList<AnnouncementVO>();

	private ArrayList<MeetingDetailVO> meetingDetailVOList1 = new ArrayList<MeetingDetailVO>();

	private ArrayList<MeetingDetailVO> meetingDetailVOList2 = new ArrayList<MeetingDetailVO>();

	private ArrayList<MeetingDetailVO> meetingDetailVOList3 = new ArrayList<MeetingDetailVO>();

	private ArrayList<MeetingAccreditationVO> meetingAccreditationList = new ArrayList<MeetingAccreditationVO>();
	
	public static String[] infos;  //上次所有select中选中的value
	
	public static int numCache;   //上次选中的第几个select
	
	public static int[] selectCount; //各select的选中次数
	
	public static SynchronizeThread synchronizeThread ;
	public static String kstMeetingNum = "-1";//用来记录可视通网关会议编号
	public static String liveTemplateName = "test";
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public	static	HashMap<String,FixedTimeTask2>	repeatTask	=	new	HashMap<String,FixedTimeTask2>();//存储定时开关线程
	
	public static int numberTerStatus=0;//用来判断系统是否开启终端检测线程
	public static int numberCenStatus=0;//判断系统是否开启中控检测线程
	/**
	 * 根据会议模式提前mcu对应的模板ID
	 * @param meetingModelID 会议模式ID
	 * @return
	 */
	public String getMcuModelOptionByMeetingModel(String meetingModelID){
		StringBuffer sb = new StringBuffer();
		if(meetingModelID==null||meetingModelID.length()==0)	return sb.toString();
		
		try{
			McuCascadeModelVO mcuCascadeMode =  ServiceFactory.getMcuCascadeModelService().queryByID(meetingModelID);
			if(mcuCascadeMode !=null&& mcuCascadeMode.getMcuIp()!=null){
				sb.append(mcuCascadeMode.getMcuIp());
				sb.append("##");
				sb.append(mcuCascadeMode.getModelID());
			}
		}catch(Exception e){
			sb = new StringBuffer();
		}
		return sb.toString();
	}
	
	/**
	 * 提取MCU模板
	 * 
	 * @param ip
	 * @return
	 */
	public String getMcuModelOption(String ip){
		StringBuffer sb = new StringBuffer();
		try{
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoName(ip);
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
			ArrayList<BaseInfoVO> baseInfoVOList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			if(baseInfoVOList!=null){
				for(BaseInfoVO vo : baseInfoVOList ){
					sb.append("<option value='");
					sb.append(vo.getInfoValue()+"'>");
					sb.append(vo.getDescription());
					sb.append("</option>");
				}
			}
		}catch(Exception e){
			sb = new StringBuffer();
		}
		return sb.toString();
	}
	
	public boolean modifyAddressName(String id,String name){
		logger.info("DwrMethod	modifyAddressName	begin"+id+"==="+name);
		AddressVO addressVO = new AddressVO();
		addressVO.setAddressID(id);
		addressVO.setName(name);
		try{
			ServiceFactory.getAddressService().modify(addressVO);	
		}catch(Exception e){
			logger.error("DwrMethod	modifyAddressName	error:	"+e.getMessage());
		}
		return true;
	}
	
	//删除节点
	/*判断父节点是否有子节点
	 * author:tanzanlong
	 * 如果当前节点没有子节点，则将当前节点删除，如果有子节点，则将字节点删除，再将父节点删除
	*/
	public boolean removeAddressName(String id){
		logger.info("DwrMethod	removeAddressName begin"+id);
		AddressVO addressVO = new AddressVO();
		addressVO.setAddressID(id);
		try {
			ArrayList<AddressVO> list=ServiceFactory.getAddressService().queryAllchildrenByID(id);
			int childrenSize=list.size();
			//flag=ServiceFactory.getAddressService().ishaveChild(id);
			if(list==null||childrenSize==0){
				ServiceFactory.getAddressService().deleteByID(id);
			}else{
				for(int i=0;i<list.size();i++){
				AddressVO AddressVO_ = new AddressVO();
				AddressVO_=(AddressVO) list.get(i);
				System.out.println(AddressVO_.getAddressID());
				removeAddressName(AddressVO_.getAddressID());	
								}
				ServiceFactory.getAddressService().deleteByID(id);
			}
		} catch (Exception e) {
			logger.error("DwrMethod	removeAddressName	error:	"+e.getMessage());
		}
		return true;
	}
	
	public String addAddressName(String id,String newName,int newLeaf){
		logger.info("DwrMethod	addAddressName	begin"+newName);
		AddressVO addressVO=new AddressVO();
		addressVO.setParentID(id);
		addressVO.setName(newName);
		addressVO.setLeaf(AddressEnu.leaf_true);
		try{
			addressVO = ServiceFactory.getAddressService().add(addressVO);
		}catch(Exception e){
			logger.error("DwrMethod	addAddressName	error:	"+e.getMessage());
		}
		return addressVO.getAddressID();
	}
	public boolean modifyDepartmentName(String id,String title){
		logger.info("DwrMethod	modifyDepartmentName	begin"+id+"==="+title);
		DepartmentVO departmentVO = new DepartmentVO();
		departmentVO.setId(id);
		departmentVO.setTitle(title);
		try{
			ServiceFactory.getDepartmentService().modifyDepartment(id, title);
		}catch(Exception e){
			logger.error("DwrMethod	modifyDepartmentName	error:	"+e.getMessage());
		}
		return true;
	}
	public String addDepartmentName(String id,String newName,int newLeaf){
		logger.info("DwrMethod	addDepartmentName	begin"+newName);
		DepartmentVO departmentVO = new DepartmentVO();
		departmentVO.setParentId(id);
		departmentVO.setTitle(newName);
		departmentVO.setLeaf(0);
		try{
			ServiceFactory.getDepartmentService().addDepartment(departmentVO,true);
		}catch(Exception e){
			logger.error("DwrMethod	addDepartmentName	error:	"+e.getMessage());
		}
		return departmentVO.getId();
	}
	//删除部门(department)节点
	/*判断父节点是否有子节点
	 * author:tanzanlong
	 * 如果当前节点没有子节点，则将当前节点删除，如果有子节点，则将字节点删除，再将父节点删除
	*/
	public String removeDepartmentName(String id) throws Exception{
		logger.info("DwrMethod	removeDepartmentName begin"+id);
	
		DepartmentVO departmentVO = new DepartmentVO();
		departmentVO.setId(id);
		String bl=ServiceFactory.getMeetingRoomService().queryBydeptID(departmentVO,null);
		try {
			List<DepartmentVO> list =new ArrayList<DepartmentVO>();
			    list=ServiceFactory.getDepartmentService().getallChild(id);
			    int  childrenSize=list.size();
				//System.out.println("删除节点的子节点个数是"+list.size());
			if(list==null||childrenSize==0){
				//System.out.println("删除了没有子节点的节点");
				ServiceFactory.getDepartmentService().deleteByID(id);
			}else{
				//System.out.println("hava children ........");
				for(int i=0;i<list.size();i++){
				DepartmentVO departmentVO_ = new DepartmentVO();
				departmentVO_=(DepartmentVO) list.get(i);
				removeDepartmentName(departmentVO_.getId());
				}
					ServiceFactory.getDepartmentService().deleteByID(id);
				}
		} catch (Exception e) {
			logger.error("DwrMethod	removeDepartmentName	error:	"+e.getMessage());
		}
		return bl;
	}
	
	public boolean modifyFuncName(String id,String name){
		FuncVO funcVO=new FuncVO();
		funcVO.setFunc_id(id);
		funcVO.setFunc_name(name);
		try{
			ServiceFactory.getFuncService().modify(funcVO);
		}
		catch(Exception e){}
		return true;
	}
	public String addFuncName(String id,String newName,int newLeaf){
		FuncVO funcVO=new FuncVO();
		funcVO.setParent_id(id);
		funcVO.setFunc_name(newName);
		funcVO.setLeaf(0);
		funcVO.setClassName("icon icon-ssbs");
		try{
			funcVO = ServiceFactory.getFuncService().add(funcVO);
		}catch(Exception e){
			e.printStackTrace();
		}
		return funcVO.getFunc_id();
	}
	
	//删除菜单管理(func)节点
	/*判断父节点是否有子节点
	 * author:tanzanlong
	 * 如果当前节点没有子节点，则将当前节点删除，如果有子节点，则将字节点删除，再将父节点删除
	*/
	public boolean removeFuncName(String id){
		logger.info("DwrMethod	removeFuncName begin："+id);
		try{
			ServiceFactory.getFuncService().deleteByID(id);
		    ArrayList<FuncVO> list=ServiceFactory.getFuncService().getallChild(id);
			for(int i=0;i<list.size();i++){
				FuncVO FuncVO_=list.get(i);
				removeFuncName(FuncVO_.getFunc_id());					
		     }
	      }catch(Exception e){
	    	  logger.error(e.getMessage());
	      }
			return true;
	}
	
	public boolean dragDepartmentName(String id1,String newpId){
		logger.info("DwrMethod	dragDepartmentName	begin "+id1);
		logger.info(id1+"=========="+newpId);
		DepartmentVO departmentVO=new DepartmentVO();
		departmentVO.setAddressID(id1);
		departmentVO.setParentId(newpId);
		try{
			ServiceFactory.getDepartmentService().modifyParent(id1, newpId);
		}
		catch(Exception e){
			logger.error("DwrMethod dragDepartmentName	error:	"+e.getMessage());	
		}
		return true;
	}
	public boolean dragAddressName(String id1,String newpId){
		logger.info("DwrMethod	dragAddressName	begin "+id1);
		AddressVO addressVO=new AddressVO();
		addressVO.setAddressID(id1);
		addressVO.setParentID(newpId);
		try{
			ServiceFactory.getAddressService().modify(addressVO);
		}
		catch(Exception e){
			logger.error("DwrMethod dragAddressName	error:	"+e.getMessage());	
		}
		return true;
	}
	public boolean dragFuncName(String funcId,String newpId){
		logger.info("DwrMethod	dragFuncName	begin "+funcId);
		FuncVO funcVO=new FuncVO();
		funcVO.setFunc_id(funcId);
		funcVO.setParent_id(newpId);
		try{
			ServiceFactory.getFuncService().modify(funcVO);
		}catch(Exception e){
			logger.error("DwrMethod dragFuncName	error:	"+e.getMessage());	
		}
		return true;
	}
	
	public boolean UpdateOrderNum(String funcId,String orderNum){
		logger.info("DwrMethod	UpdateOrderNum	begin "+funcId);
		FuncVO funcVO=new FuncVO();
		funcVO.setFunc_id(funcId);
		funcVO.setNumber(orderNum);
		try{
			ServiceFactory.getFuncService().modify(funcVO);
		}catch(Exception e){
			logger.error("DwrMethod UpdateOrderNum	error:	"+e.getMessage());
		}
		return true;
	}
	/*public DepartmentVO[] expandDepartmentName(String pid){
		logger.info("DwrMethod expandDepartmentName begin "+pid);
		ArrayList<DepartmentVO> treeList = new ArrayList<DepartmentVO>();
		DepartmentVO departmentVO=new DepartmentVO();
		departmentVO.setParentId(pid);
		try{
			treeList = ServiceFactory.getDepartmentService().getAllFuncList(departmentVO, null);
		}catch(Exception e){
			logger.error("DwrMethod expandDepartmentName	error:	"+e.getMessage());	
		}
		DepartmentVO[] deptLs = new DepartmentVO[treeList.size()];
		treeList.toArray(deptLs);
		return treeList.toArray(deptLs);		
	}*/
	public CameraGroup[] expandTreeName(String pid){
		logger.info("DwrMethod expandTreeName begin "+pid);
		ArrayList<CameraGroup> treeList = new ArrayList<CameraGroup>();
		CameraGroup cameragroup=new CameraGroup();
		cameragroup.setParent_id(pid);
		try{
			treeList = ServiceFactory.getKstVedioMoniterService().getKstVedioMoniterList(cameragroup, null);
		}catch(Exception e){
			logger.error("DwrMethod expandTreeName	error:	"+e.getMessage());	
		}
		CameraGroup[] cameraLs = new CameraGroup[treeList.size()];
		treeList.toArray(cameraLs);
		return treeList.toArray(cameraLs);	
	}
	/**
	 * get user list by department id
	 * 
	 * @param vUserDepartmentVO
	 * @return
	 * @author wangle
	 * @since Aug 6, 2009
	 */
	public ArrayList<UserVO> getUserListByDepartID(String departmentID) {
		if (departmentID == null) {
			return null;
		}
		UserDepartmentVO userDepartmentVO = new UserDepartmentVO();
		userDepartmentVO.getDepartmentVO().setId(departmentID);
		//userDepartmentVO.getDepartmentVO().setSystemValue(0);
		userDepartmentVO.getUserVO().setState(UseStatusEnum.VALID);
		UserDepartmentService userDepartmentService = new UserDepartmentServiceImpl();
		try {
			ArrayList<UserDepartmentVO> userDepartmentVOList = userDepartmentService
					.getUserDepartmentList(userDepartmentVO, null);
			if (userDepartmentVOList != null && userDepartmentVOList.size() > 0) {
				ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
				for (UserDepartmentVO userDepartment : userDepartmentVOList) {
					userVOList.add(userDepartment.getUserVO());
				}
				return userVOList;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	/**
	 * get user list by department id group
	 * 
	 * @param vUserDepartmentVO
	 * @return
	 * @author wangle
	 * @since Aug 6, 2009
	 */
	public ArrayList<UserVO> getUserListGroupByDepartID(String departmentID) {
		if (departmentID == null) {
			return null;
		}
		UserDepartmentVO userDepartmentVO = new UserDepartmentVO();
		userDepartmentVO.getDepartmentVO().setId(departmentID);

		userDepartmentVO.getUserVO().setState(UseStatusEnum.VALID);
		UserDepartmentService userDepartmentService = new UserDepartmentServiceImpl();
		try {
			ArrayList<UserDepartmentVO> userDepartmentVOList = userDepartmentService
					.getUserDepartmentList(userDepartmentVO, null);
			if (userDepartmentVOList != null && userDepartmentVOList.size() > 0) {
				ArrayList<UserVO> userVOList = new ArrayList<UserVO>();
				for (UserDepartmentVO userDepartment : userDepartmentVOList) {
					userVOList.add(userDepartment.getUserVO());
				}
				return userVOList;
			}
		} catch (Exception e) {
			return null;
		}

		return null;
	}

	/**
	 * getUserList by userName
	 * @author wangrl
	 * @param id
	 * @return
	 */
	public ArrayList<UserVO> getUserListByUserName(String userName) {
		try {
			UserService userService = new UserServiceImpl();
			UserVO tmpUserVO = new UserVO();
			tmpUserVO.setName(userName);
			tmpUserVO.setState(UseStatusEnum.VALID);

			ArrayList<UserVO> lstUser = userService
					.getUserList(tmpUserVO, null);
			return lstUser;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserVO getUserVO(String id) {
		UserVO userVO = new UserVO();
		try {
			UserService service = new UserServiceImpl();
			userVO.setUserID(id);
			userVO = service.getUserInfo(userVO, null);

			UserRoleService userRoleService = new UserRoleServiceImpl();
			userRoleVO.setUserID(userVO.getUserID());
			ArrayList<UserRoleVO> userRoleVOList = userRoleService
					.getUserRoleList(userRoleVO, null);

			userVO.setUserRoleVOList(userRoleVOList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userVO;
	}

	public MeetingRoomVO getMeetingRoomVO(String meetingRoomID, String chargerID) {
		MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
		try {
			MeetingRoomService service = new MeetingRoomServiceImpl();
			meetingRoomVO.setMeetingRoomID(meetingRoomID);
			//meetingRoomVO.setChargerID(chargerID);
			UserService userService = new UserServiceImpl();
			user1VO.setUserID(chargerID);
			ArrayList<MeetingRoomVO> meetingRoomVOList = service.query(
					meetingRoomVO, null);
			if (meetingRoomVOList != null && meetingRoomVOList.size() > 0) {
				meetingRoomVO = meetingRoomVOList.get(0);
				ArrayList<UserVO> userVOList = userService.getUserList(user1VO,
						null);
				if (userVOList != null && userVOList.size() > 0) {
					user1VO = userVOList.get(0);
					//		meetingRoomVO.setChargerMobile(user1VO.getMobile());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetingRoomVO;
	}

	public AnnouncementVO getAnnouncementVOList(int id) {

		AnnouncementVO announcementVO = new AnnouncementVO();
		try {

			AnnouncementService announcementservice = new AnnouncementServiceImpl();
			announcementVO.setAnnouncementID(id);
			announcmentVOList = announcementservice.getAnnouncementList(
					announcementVO, null);

			if (announcmentVOList != null && announcmentVOList.size() > 0) {
				announcementVO = announcmentVOList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return announcementVO;
	}

	public EquipmentVO getEquipmentVO(String id) {
		EquipmentVO equipmentVO = new EquipmentVO();
		try {
			EquipmentService equipmentservice = new EquipmentServiceImpl();
			equipmentVO.setEquipmentID(id);
			equipmentVOList = equipmentservice.query(equipmentVO, null);

			if (equipmentVOList != null && equipmentVOList.size() > 0) {
				equipmentVO = equipmentVOList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return equipmentVO;
	}

	// 我的会议
	public MeetingDetailVO getMyMeetingDetailVO(String id) {
		MeetingDetailVO meetingDetailVO1 = new MeetingDetailVO();
		try {
			MeetingDetailService meetingDetailservice = new MeetingDetailServiceImpl();
			meetingDetailVO1.setMeetingDetailID(id);

			meetingDetailVOList1 = meetingDetailservice.getMeetingDetailList(
					meetingDetailVO1, null);

			if (meetingDetailVOList1 != null && meetingDetailVOList1.size() > 0) {
				meetingDetailVO1 = meetingDetailVOList1.get(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return meetingDetailVO1;
	}

	// 我的预定
	public MeetingDetailVO getMeetingDetailVO(String id) {
		MeetingDetailVO meetingDetailVO2 = new MeetingDetailVO();
		try {
			MeetingDetailService meetingDetailservice = new MeetingDetailServiceImpl();
			meetingDetailVO2.setMeetingDetailID(id);

			meetingDetailVOList2 = meetingDetailservice.getMeetingDetailList(
					meetingDetailVO2, null);
			if (meetingDetailVOList2 != null && meetingDetailVOList2.size() > 0) {
				meetingDetailVO2 = meetingDetailVOList2.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return meetingDetailVO2;
	}

	// 已参加过的会议
	public MeetingDetailVO pastMeetingDetailVO(String id) {
		MeetingDetailVO meetingDetailVO3 = new MeetingDetailVO();
		try {
			MeetingDetailService meetingDetailservice = new MeetingDetailServiceImpl();
			meetingDetailVO3.setMeetingDetailID(id);

			meetingDetailVOList3 = meetingDetailservice.getMeetingDetailList(
					meetingDetailVO3, null);
			if (meetingDetailVOList3 != null && meetingDetailVOList3.size() > 0) {
				meetingDetailVO3 = meetingDetailVOList3.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return meetingDetailVO3;
	}

	// 判断用户名是否已存在
	@SuppressWarnings("unchecked")
	public ArrayList checkUserName(String loginName) {
		UserVO userVO = new UserVO();
		ArrayList check = null;
		try {
			UserService service = new UserServiceImpl();
			userVO.setLoginName(loginName);
			userVO.setState(UserEnum.VALID);//锁定怎么办
			check = service.getUserList(userVO, null);
			if(check==null||check.size()==0){
				userVO.setState(UserEnum.lock);//如果锁定的话依然不能继续注册
				check = service.getUserList(userVO, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
//	 判断用户原始密码是否输入正确
	public boolean checkPassword(String passworld,String userID) {
		boolean flag = false;
		String passworld1 = MD5.GetMD5Code2(passworld);
		UserVO userVO = new UserVO();
		ArrayList<UserVO> check = null;
		try {
			UserService service = new UserServiceImpl();
			userVO.setUserID(userID);
			userVO.setState(UserEnum.VALID);//锁定怎么办
			check = service.getUserList(userVO, null);
			if(check!=null && check.size()>0){
				if(passworld1.equals(check.get(0).getPassWord())){
					flag = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 判断设备编号是否已存在
	public ArrayList checkEquipmentNo(String equipmentNO) {
		EquipmentVO equipmentVO = new EquipmentVO();
		ArrayList checkEquipmentNO = null;
		try {
			//			EquipmentService equipmentservice = new EquipmentServiceImpl();
			//			equipmentVO.setEquipmentNO(equipmentNO);
			//			
			//			checkEquipmentNO = equipmentservice.query(equipmentVO, null);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkEquipmentNO;
	}

	// 判断主MCU是否已存在@duanlei
	public ArrayList checkEquipmentMcu(int principalMcu) {
		EquipmentVO equipmentVO = new EquipmentVO();
		ArrayList checkEquipmentMCU = null;
		try {
			EquipmentService equipmentservice = new EquipmentServiceImpl();
			//		equipmentVO.setPrincipalMcu(principalMcu);
			checkEquipmentMCU = equipmentservice.query(equipmentVO, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkEquipmentMCU;
	}

	// 判断设备唯一标识是否已存在
	public ArrayList checkEquipmentName(String equipmentName) {
		EquipmentVO equipmentVO = new EquipmentVO();
		ArrayList checkEquipmentName = null;
		try {
			EquipmentService equipmentservice1 = new EquipmentServiceImpl();
			equipmentVO.setEquipmentName(equipmentName);
			checkEquipmentName = equipmentservice1.query(equipmentVO, null);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return checkEquipmentName;
	}

	// 判断会议室中是否已存在主MCU@duanlei
	public ArrayList checkMCUName(int meetingRoomID) {

		return null;
	}

	// 判断上联设备是否已存在@duanlei
	public ArrayList checkUplinkEquipment(String uplinkEquipmentName) {
		EquipmentVO EquipmentVO = new EquipmentVO();
		ArrayList uplinkEquipment = null;
		try {
			EquipmentService service = new EquipmentServiceImpl();
			//		EquipmentVO.setUplinkEquipmentName(uplinkEquipmentName);
			uplinkEquipment = service.query(EquipmentVO, null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uplinkEquipment;
	}

	public boolean checkIP(String ip) throws SQLException {
		boolean mark = false;
		if (getEquipmentStatus(ip, 1000)) {
			mark = true;
		}
		return mark;
	}
	
	public boolean checkEquipmentNameBoolean(String equipmentName) {
		EquipmentVO equipmentVO = new EquipmentVO();
		ArrayList checkEquipmentName = new ArrayList();
		try {
			EquipmentService equipmentservice1 = new EquipmentServiceImpl();
			equipmentVO.setEquipmentNO(equipmentName);
			checkEquipmentName = equipmentservice1.query(equipmentVO, null);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(checkEquipmentName.size()>0){
			return true;
		}
		return false;
	}
	
	
	/**   
	 * 能否ping通IP地址    
	 * @param server IP地址    
	 * @param timeout 超时时长    
	 * @return true能ping通    
	 */
	public static boolean getEquipmentStatus(String server, int timeout) {
		BufferedReader in = null;
		Runtime r = Runtime.getRuntime();

		String pingCommand = "ping " + server + " -n 1 -w " + timeout;
		try {
			Process p = r.exec(pingCommand);
			if (p == null) {
				return false;
			}
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				if (line.startsWith("Reply from")) {
					return true;
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * delete a period meeting
	 * @param meetingDetailID
	 * @author wangle
	 * @since Aug 31, 2009
	 */
	public void delOnePeriodMeeting(String meetingDetailID) {
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		meetingDetailVO.setMeetingDetailID(meetingDetailID);
		try {
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			meetingDetailService.delMeetingDetail(meetingDetailVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * confirm period meeting
	 * 
	 * @param meetingID
	 * @throws SQLException
	 * @author wangle
	 * @since Aug 31, 2009
	 */
	public void confirmPeriodMeeting(String meetingID) throws SQLException {
		TransactionManager tManager = new TransactionManager();

		MeetingVO meetingVO = new MeetingVO();
		meetingVO.setMeetingID(meetingID);

		MeetingService meetingService = new MeetingServiceImpl();
		try {
			ArrayList<MeetingVO> meetingVOList = meetingService.getMeetingList(
					meetingVO, null);
			if (meetingVOList != null && meetingVOList.size() > 0) {
				meetingVO = meetingVOList.get(0);
				meetingVO.setStatus(MeetingStatus.APPROVED);
				meetingService.modifyMeeting(meetingVO, tManager);

				MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
				meetingDetailVO.setMeetingID(meetingVO.getMeetingID());
				meetingDetailVO.setStatus(MeetingStatus.TO_BE_APPROVED+"");
				MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
				ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService
						.getMeetingDetailList(meetingDetailVO, null);
				if (meetingDetailVOList != null
						&& meetingDetailVOList.size() > 0) {
					for (MeetingDetailVO meetingDetail : meetingDetailVOList) {
						meetingDetail.setStatus(MeetingStatus.APPROVED+"");
						//						meetingDetailService.modifyMeetingDetail(meetingDetail,
						//								tManager);

						meetingService.addMeetingUVSInfo(meetingVO,
								meetingDetail);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * assgin sb. to attend this meeting
	 * 
	 * @param loginID
	 * @param meetingDetailID
	 * @param participatorID
	 * @param participatorName
	 * @return
	 * @author wangle
	 * @since Aug 31, 2009
	 */
	public String assignSbMeeting(String loginID, String loginName,
			int meetingDetailID, String participatorID, String participatorName) {
		String name1 = "";
		String name2 = "";
		String rs = "";
		String participators = "";
		String[] participator;
		try {

			MeetingAccreditationService meetingAccreditationservice = new MeetingAccreditationServiceImpl();
			MeetingAccreditationVO meetingAccreditationvo = new MeetingAccreditationVO();
			meetingAccreditationvo.setMeetingDetailID(meetingDetailID);
			meetingAccreditationvo.setUserToID(Integer.valueOf(participatorID));
			meetingAccreditationList = meetingAccreditationservice
					.getMeetingAccreditationList(meetingAccreditationvo, null);
			// 判断数据库中是否有异常数据
			if (meetingAccreditationList.size() >= 2) {
				rs = "数据库异常";
				return rs;
			}
			// 判断所选择的委派人是否为要参加本次会议的人员
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			ArrayList<MeetingDetailVO> meetingDetailVOList = new ArrayList<MeetingDetailVO>();
			meetingDetailVO.setMeetingDetailID(meetingDetailID + "");
			meetingDetailVOList = meetingDetailService.getMeetingDetailList(
					meetingDetailVO, null);
			if (meetingDetailVOList.size() == 1) {
				meetingDetailVO = meetingDetailVOList.get(0);
				participators = meetingDetailVO.getParticipators();
			}
			participator = participators.split("、");
			for (int i = 0; i < participator.length; i++) {
				if (participator[i].equals(participatorName)) {
					rs = participatorName + "也是本次会议参与者，请选择其他委派人";
					return rs;
				}
			}

			// 判断所指定的委派人是否已被本次会议的其他人委派
			if (meetingAccreditationList.size() == 1) {
				meetingAccreditationvo = (MeetingAccreditationVO) meetingAccreditationList
						.get(0);
				name1 = meetingAccreditationvo.getUserFromName();
				name2 = meetingAccreditationvo.getUserToName();
				rs = participatorName + "已被本次会议的" + name1 + "委派参加，请选择其他委派人";
				return rs;
			}

			TransactionManager tManager = new TransactionManager();

			MeetingDetailUserVO meetingDetailUserVO = new MeetingDetailUserVO();
			meetingDetailUserVO.setParticipatorID(loginID);
			meetingDetailUserVO.setMeetingDetailID(meetingDetailID + "");

			MeetingDetailUserService meetingDetailUserService = new MeetingDetailUserServiceImpl();
			ArrayList<MeetingDetailUserVO> meetingDetailUserVOList = meetingDetailUserService
					.getMeetingDetailUserList(meetingDetailUserVO, null);
			if (meetingDetailUserVOList != null
					&& meetingDetailUserVOList.size() > 0) {
				MeetingDetailUserVO temp = meetingDetailUserVOList.get(0);
				temp.setParticipatorID(participatorID);
				temp.setParticipatorName(participatorName);
				temp.setStatus(MeetingParticipatEnum.ASSIGN);

				meetingDetailUserService
						.modifyMeetingDetailUser(temp, tManager);

				MeetingAccreditationVO meetingAccreditationVO = new MeetingAccreditationVO();
				meetingAccreditationVO.setMeetingDetailID(meetingDetailID);
				meetingAccreditationVO.setUserFromID(Integer.parseInt(loginID));
				meetingAccreditationVO.setUserFromName(loginName);
				meetingAccreditationVO.setUserToID(Integer
						.parseInt(participatorID));
				meetingAccreditationVO.setUserToName(participatorName);
				MeetingAccreditationService meetingAccreditationService = new MeetingAccreditationServiceImpl();
				meetingAccreditationService.addMeetingAccreditation(
						meetingAccreditationVO, tManager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			rs = "系统错误";
			return rs;
		}
		rs = "委派成功";
		return rs;
	}

	/**
	 * check if meeting rooms are available.
	 * @param meetingDetailID
	 * @param meetingRoomNameIDs
	 * @param meetingRoomNames
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public ArrayList<String> checkMeetingRoom(String meetingDetailID,
			String meetingRoomNameIDs, String meetingRoomNames,
			String startTime, String endTime) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ArrayList<String> meetingRoomNameList = new ArrayList<String>();
		try {
			Date startTimeDate = format.parse(startTime);
			Date endTimeDate = format.parse(endTime);
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			if (meetingDetailID != null) {
				meetingDetailVO.setMeetingDetailID(meetingDetailID);
			}
			meetingDetailVO.setMeetingRoomNameIDs(meetingRoomNameIDs);
			meetingDetailVO.setMeetingRoomNames(meetingRoomNames);
			meetingDetailVO.setMeetingStartTime(new Timestamp(startTimeDate
					.getTime()));
			meetingDetailVO.setMeetingEndTime(new Timestamp(endTimeDate
					.getTime()));
			MeetingService meetingService = new MeetingServiceImpl();

			meetingService.checkAvailableMeetingRoom(meetingDetailVO,
					meetingRoomNameList);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return meetingRoomNameList;
	}

	/**
	 *  check meeting room is available
	 * @param meetingDetailID
	 * @param meetingType
	 * @param meetingRoomNameIDs
	 * @param duration is conference hours
	 * @return
	 */
	public ArrayList<String> checkMeetingRoom(String meetingDetailID,
			String meetingRoomNameIDs, String meetingRoomNames, String duration) {
		ArrayList<String> meetingRoomIdList = new ArrayList<String>();
		try {
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			//set start time and end time
			Calendar c = Calendar.getInstance();
			meetingDetailVO.setMeetingStartTime(new Timestamp(c.getTimeInMillis()));

			int iDuration = 0;
			try {
				iDuration = (int) ((Float.parseFloat(duration)) * 60);
			} catch (Exception e) {
				//to set all day time
			}
			c.add(Calendar.MINUTE, iDuration);
			meetingDetailVO.setMeetingEndTime(new Timestamp(c.getTimeInMillis()));

			if (meetingDetailID != null) {
				meetingDetailVO.setMeetingDetailID(meetingDetailID);
			}
			//meetingRoomNameIDs = meetingRoomNameIDs.replace("-", ",");
			//meetingRoomNames = meetingRoomNames.replace("、", ",");
			meetingDetailVO.setMeetingRoomNameIDs(meetingRoomNameIDs);
			meetingDetailVO.setMeetingRoomNames(meetingRoomNames);
			MeetingService meetingService = new MeetingServiceImpl();

			meetingService.checkAvailableMeetingRoom(meetingDetailVO,
					meetingRoomIdList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetingRoomIdList;
	}

	/**
	 * check temporarily saved meeting room is available
	 * 
	 * @param meetingType
	 * @param meetingRoomNameIDs
	 * @param startTime
	 * @param endTime
	 * @return true means meeting room is available. otherwise, meeting room was
	 *         used.
	 * @author wangle
	 * @since Sep 11, 2009
	 */
	public ArrayList<String> checkMeetingRoom(String meetingDetailID) {
		ArrayList<String> meetingRoomIdList = new ArrayList<String>();
		ArrayList<String> meetingRoomNameList = new ArrayList<String>();
		try {
			if (meetingDetailID.equals("")) {
				return null;
			}
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			meetingDetailVO.setMeetingDetailID(meetingDetailID);
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService
					.getMeetingDetailList(meetingDetailVO, null);
			if (meetingDetailVOList == null || meetingDetailVOList.size() <= 0) {
				return null;
			}
			meetingDetailVO = meetingDetailVOList.get(0);

			MeetingService meetingService = new MeetingServiceImpl();
			meetingService.checkAvailableMeetingRoom(meetingDetailVO,
					meetingRoomIdList);
			if (meetingRoomIdList != null && meetingRoomIdList.size() > 0) {
				String meetingId = meetingRoomIdList.get(0);
				if (MeetingTypeEnum.isPolycomMeeting(meetingDetailVO
						.getMeetingType())) {
					String meetingRoomIdsTemp = meetingDetailVO
							.getMeetingRoomNameIDs();
					String meetingRoomNamesTemp = meetingDetailVO
							.getMeetingRoomNames();
					String[] meetingRoomNames = splitName(meetingRoomNamesTemp);
					String[] meetingRoomIds = splitID(meetingRoomIdsTemp);
					if (meetingRoomIds != null && meetingRoomIds.length > 0
							&& meetingRoomNames != null
							&& meetingRoomNames.length > 0) {
						for (int i = 0; i < meetingRoomIds.length; i++) {
							if (meetingRoomIds[i].trim().equals(
									meetingId.trim())) {
								meetingRoomNameList.add(meetingRoomNames[i]);
								return meetingRoomNameList;
							}
						}
					}
				} else {
					meetingRoomNameList.add(meetingDetailVO
							.getMeetingRoomName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return meetingRoomNameList;
	}

	//@duanlei
	public String checkequipment(String modelID) {
		try {
			EquipmentVO equipmentVO = new EquipmentVO();
			EquipmentService equipmentService = new EquipmentServiceImpl();
			ArrayList<EquipmentVO> equpmentVOList = new ArrayList<EquipmentVO>();
			//equipmentVO.setModelID(Integer.valueOf(modelID));
			equipmentVOList = equipmentService.query(equipmentVO, null);
			if (equipmentVOList.size() > 0) {
				return "modelID";
			} else {
				return modelID;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modelID";
	}

	/**
	 * @author wangrl
	 * @since Nov 24,2009 check role
	 */
	public String checkRole(String userid) {
		try {
			UserRoleVO userRole = new UserRoleVO();
			UserRoleService userRoleService = new UserRoleServiceImpl();
			ArrayList userRoleList = new ArrayList();
			userRole.setUserID(userid);
			userRoleList = userRoleService.getUserRoleList(userRole, null);
			if (userRoleList.size() == 1) {
				UserRoleVO ur = new UserRoleVO();
				ur = (UserRoleVO) userRoleList.get(0);
				if (ur.getRoleName().equals("管理员")) {
					return "管理员" + "." + userid;
				}
				if (ur.getRoleName().equals("二级管理员")) {
					return "管理员" + "." + userid;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";
		}
		return "用户" + "." + userid;
	}

	/**
	 * format date
	 * 
	 * @param date
	 * @param dateFormat
	 * @return
	 * @author wangle
	 * @since Nov 3, 2009
	 */
	public String getFormatDate(Date date, String dateFormat) {
		if (date == null || dateFormat == null || dateFormat.trim().equals("")) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.format(date);
	}

	public String[] splitName(String names) {
		if (names == null || names.trim().equals("")) {
			return null;
		}

		String[] result = names.split("、");
		return result;
	}

	public String[] splitID(String IDs) {
		if (IDs == null || IDs.trim().equals("")) {
			return null;
		}

		String[] result = IDs.split("-");
		return result;
	}

	public String getMeetingNoticeInfo(String roomIDS) {
		String reStr = "";
		try {
			if (roomIDS != null && roomIDS.length() > 0) {
				String[] roomID = roomIDS.split(",");
				if (roomID.length > 0) {
					for (int i = 0; i < roomID.length; i++) {
						MeetingDetailVO vo = new MeetingDetailVO();
						Calendar c = Calendar.getInstance();
						long l = c.getTimeInMillis();
						long l2 = l + 24 * 60 * 60 * 1000;

						// 取当前时间到今天24点的所有会议
						vo.setMeetingStartTime(new Timestamp(l));
						vo.setMeetingEndTime(new Timestamp(l2));
						vo.setStatus(MeetingStatus.APPROVED+"");
						MeetingDetailService servie = new MeetingDetailServiceImpl();

						ArrayList<MeetingDetailVO> list = servie
								.getMeetingDetailList(vo, null);
						if (list != null && list.size() > 0) {
							for (MeetingDetailVO detail : list) {
								if (detail.getMeetingRoomID().equals(roomID[i])
										|| detail.getMeetingRoomNameIDs()
												.indexOf(roomID[i]) >= 0) {
									reStr += detail.getMeetingName()
											+ "  &nbsp;&nbsp;会议在&nbsp;&nbsp;"
											+ detail.getMeetingRoomName()
											+ "&nbsp;&nbsp;会议室举行";
								}
							}
						} else {
							reStr = "nothing";
						}
					}
				}
			}
		} catch (Exception e) {
			reStr = "error";
		}
		return reStr;
	}

	/**
	 * @author wangrl
	 * @param roleName
	 * check the roleName's unique
	 * @return
	 *  
	 */
	public boolean validation_roleName(String roleName) {
		boolean result = true;
		RoleVO roleVO = new RoleVO();
		roleName = roleName.trim();
		if (roleName.equals("")) {
			return false;
		}
		roleVO.setRoleName(roleName);

		RoleService roleService = new RoleServiceImpl();
		ArrayList<RoleVO> lstRole;
		try {
			lstRole = roleService.getRoleList(roleVO, null);
			if (lstRole.size() > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author wangrl
	 * @param serviceName 
	 * check the serviceName's unique
	 * @return
	 * 
	 */
	public boolean validation_serviceName(String serviceName) {
		boolean result = true;
		try {
			serviceName = serviceName.trim();
			if (serviceName.equals("")) {
				return false;
			}//服务名称为空，则不验证
			ServiceVO serviceVO = new ServiceVO();

			serviceVO.setServiceName(serviceName);
			serviceVO.setState(1);
			serviceVO.setParentID(1);
			ServiceService serviceService = new ServiceServiceImpl();

			ArrayList<ServiceVO> lstService = serviceService.getServiceList(
					serviceVO, null);

			if (lstService.size() > 0) {
				result = true;
			} else {
				result = false;
			}

		} catch (Exception e) {
			e.toString();
		}
		return result;
	}

	/**
	 * 
	 * @param 验证会议室roomNO
	 * @return
	 * @author linsha
	 */
	public boolean checkMeetingRoomNO(String roomNO) {
		boolean result = true;
		ArrayList<MeetingRoomVO> listm = new ArrayList<MeetingRoomVO>();
		try {
			roomNO = roomNO.trim();
			if (roomNO.equals("")) {
				return false;
			}//会议室编号为空，则不验证
			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setRoomNO(roomNO);
			listm = ServiceFactory.getMeetingRoomService().query(meetingRoomVO,
					null);
			if (listm.size() > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @param 验证会议室名称
	 * @return
	 * @author linsha
	 */
	public ArrayList<MeetingRoomVO> checkMeetingRoomName(String meetingRoomName) {
		ArrayList<MeetingRoomVO> listm = new ArrayList<MeetingRoomVO>();
		try {
			meetingRoomName = meetingRoomName.trim();
			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setMeetingRoomName(meetingRoomName);
			listm = ServiceFactory.getMeetingRoomService().validate(meetingRoomVO,null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listm;
	}

	/**
	 * 
	 * @param 验证设备IP包括MCU信令IP
	 * @return
	 * @author linsha
	 */
	public ArrayList<EquipmentVO> checkEquipmentIP(String ip) {
		ArrayList<EquipmentVO> liste = new ArrayList<EquipmentVO>();
		try {
			ip = ip.trim();
			if (!ip.equals("")) {
				EquipmentVO equipmentVO = new EquipmentVO();
				equipmentVO.setIp(ip);
				liste=ServiceFactory.getEquipmentService().queryIP(ip);
				if(liste.size()>0) return liste;
				
				EquipmentMcuVO equipmentMcuVO = new EquipmentMcuVO();
				equipmentMcuVO.setCommandIP(ip);
				ArrayList<EquipmentMcuVO> listMcu = ServiceFactory.getEquipmentMcuService().query(
						equipmentMcuVO, null);
				if(listMcu.size()>0){
					liste.add(equipmentVO);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	

	/**
	 * 
	 * @param 验证设备commandIP
	 * @return
	 * @author linsha
	 * 删除
	 */
	public ArrayList<EquipmentMcuVO> checkEquipmentcommandIP(String commandIP) {
		ArrayList<EquipmentMcuVO> liste = new ArrayList<EquipmentMcuVO>();
		ArrayList<EquipmentVO> liste1 = new ArrayList<EquipmentVO>();
		try {
			commandIP = commandIP.trim();
			if (!commandIP.equals("")) {

				EquipmentMcuVO equipmentMcuVO = new EquipmentMcuVO();
				equipmentMcuVO.setCommandIP(commandIP);
				liste = ServiceFactory.getEquipmentMcuService().query(
						equipmentMcuVO, null);

			}//设备commandIP称为空，则不验证

		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}

	//静音
	public String mutebyIP(String ccip,String audioId) {
		//调用中控接口
		logger.info(" 中控IP："+ccip+"，音频编号为"+audioId+"连接开始！"+df.format(new Date())+" 开始连接！");
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ccip);
		//获取电源状态,audioMuteOn中传参为该音频设备在中控上注册的id
		ExcuteResultVO vo = obj.audioMuteOn(audioId);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccip,audioId,"audio");
		String info = infos[0]+"("+ccip+")"+infos[1];
		if (vo.isSuccess()) {
			addLog(info+"--静音成功");
			logger.info(" 中控IP："+ccip+"，音频编号为"+audioId+"连接结束！"+df.format(new Date())+" 结束连接！");
			return audioId;
		} else {
			logger.info(" 中控IP："+ccip+"，音频编号为"+audioId+"连接结束！"+df.format(new Date())+" 连接失败！");
			addLog(info+"--静音失败");
			return null;
		}
	}

	//取消静音
	public String unmutebyIP(String ccip,String audioId) {
		//先判断是那个会议室的设备
		
		//根据会议室得到会议室编号
		//获取指令
		logger.info(" 中控IP："+ccip+"，音频编号为"+audioId+"连接开始！"+df.format(new Date())+" 开始连接！");
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ccip);
		//获取电源状态,audioMuteOff中传参为该音频设备在中控上注册的id
		ExcuteResultVO vo = obj.audioMuteOff(audioId);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccip,audioId,CenterControlEnum.type_audio_id);
		String info = infos[0]+"("+ccip+")"+infos[1]+"--取消静音";
		if (vo.isSuccess()) {
			addLog(info+"成功");
			logger.info(" 中控IP："+ccip+"，音频编号为"+audioId+"连接结束！"+df.format(new Date())+" 结束连接！");
			return audioId;
		} else {
			addLog(info+"失败");
			logger.info(" 中控IP："+ccip+"，音频编号为"+audioId+"连接结束！"+df.format(new Date())+" 连接失败！");
			return null;
		}
	}

	//电源开
	public String openpowerbyIP(String ip,String sysPowerId) {
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		//获取电源状态
		ExcuteResultVO vo = obj.sysPowerOn(sysPowerId);
		vo.setSuccess(true);//默认开启成功
		//日志
		String[] infos = getMeetingRoomNameandEquimentName(ip,sysPowerId,CenterControlEnum.type_sysPower_id);
		String info = infos[0]+"("+ip+")"+CenterControlEnum.type_sysPower_name+"开";
		if (vo.isSuccess()) {
			addLog(info+"--操作成功");
			return ip;
		} else {
			addLog(info+"--操作失败");
			return null;
		}
	}

	//电源关
	public String closepowerbyIP(String ip,String sysPowerId) {
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		//获取电源状态
		ExcuteResultVO vo = obj.sysPowerOff(sysPowerId);
		//日志
		String[] infos = getMeetingRoomNameandEquimentName(ip,sysPowerId,CenterControlEnum.type_sysPower_id);
		String info = infos[0]+"("+ip+")"+CenterControlEnum.type_sysPower_name+"关";
		if (vo.isSuccess()) {
			addLog(info+"--操作成功");
			return ip;
		} else {
			addLog(info+"--操作失败");
			return null;
		}
	}
	
	//add by yangyi 中控状态信息
	public ArrayList<String> getCenterControl(String ips){
		ArrayList<String> lst = new ArrayList<String>();
		String[] ip = ips.split(";");
		for(int i=0;i<ip.length;i++){
			CenterControlObject obj = (CenterControlObject)ControlFactory
				.getCenterControlObject(ip[i]);
			if(obj == null){
				logger.info(ip[i] + ":null");
			}else {
				String ipAndStatus = ip[i]+";"+obj.getStatus();
				lst.add(ipAndStatus);
			}
		}
		return lst;
	}
	
	//add by yangyi 终端状态信息
	public ArrayList<String> getTerminalControl(String ips){
		ArrayList<String> lst = new ArrayList<String>();
		String[] ip = ips.split(";");
		for(int i=0;i<ip.length;i++){
			TerminalObject obj = (TerminalObject)ControlFactory
				.getTerminalObject(ip[i]);
			if(obj == null){
				logger.info(ip[i] + ":null");
			}else {
				String status = "";
				if(obj.isOnLine()){
					status = "0";
				}else{
					status = "1";
				}
				String ipAndStatus = ip[i]+";"+status;
				lst.add(ipAndStatus);
			}
		}
		return lst;
	}
	
	//系统电源状态
	public ArrayList<String> getpowerlist(String ips) {
		String[] ip = ips.split(";");
		ArrayList<String> reslist = new ArrayList<String>();
		for (int i = 0; i < ip.length; i++) {
			//调用中控接口
			CenterControlObject obj = (CenterControlObject) ControlFactory
					.getCenterControlObject(ip[i]);
			
			String ipAndstatus = "";
			String sysIp = ip[i];
			String status = "";
			
			if (obj == null) {
				logger.info(ip[i] + ":null");
				status = "x";
				logger.info(df.format(new Date())+" 中控IP："+ip[i]+"连接异常！");
			} else {
				//获取电源状态
				ExcuteResultVO vo = obj.sysPowerStatus("1");
				if (vo.isSuccess()) {
					SysPowerVO sv = (SysPowerVO) vo.getObject();
					if (sv != null) {
						status = sv.getStatus();
					}
					else{
						status = "x";
						logger.info(df.format(new Date())+"连接异常！");
					}
				}else{
					status = "x";
					logger.info(df.format(new Date())+" 中控IP："+ip[i]+"连接异常！");
				}
			}
			ipAndstatus = sysIp+";"+status;
			reslist.add(ipAndstatus);
		}
		return reslist;
	}
	
	//等离子状态
	public ArrayList<String> getPlaStatusList(String ips) {
		String[] ip_And_Id = ips.split(";");
		//logger.info(ip.length);
		ArrayList<String> reslist = new ArrayList<String>();
		for (int i = 0; i < ip_And_Id.length; i++) {
			if(ip_And_Id[i]==null||ip_And_Id[i].length()==0) continue;
			String[] ipAndId = ip_And_Id[i].split("_");
			
			//调用中控接口
			CenterControlObject obj = (CenterControlObject) ControlFactory
					.getCenterControlObject(ipAndId[0]);
			
			String ipAndstatus = "";
			String sysIp = ip_And_Id[i];
			String status = "";
			
			if (obj == null) {
				logger.info(ip_And_Id[i] + ":null");
				status = "x";
			} else {
				//获取等离子状态
				ExcuteResultVO vo = obj.plaStatus(ipAndId[1]);
				if (vo.isSuccess()) {
					PlaVO sv = (PlaVO) vo.getObject();
					if (sv != null) {
						status = sv.getStatus();
					}
					else{
						status = "x";
					}
				}else{
					status = "x";
				}
			}
			ipAndstatus = sysIp+";"+status;
			reslist.add(ipAndstatus);
		}
		return reslist;
	}
	
	//等离子开
	public String plaControl_Open(String ip) {
		String[] ipAndId =  ip.split("_");
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ipAndId[0]);
		//获取电源状态
		ExcuteResultVO vo = obj.plaOn(ipAndId[1]);
		if (vo.isSuccess()) {
			addLog(ip+"等离子电源开--成功");
			return ip;
		} else {
			addLog(ip+"等离子电源开--失败");
			return null;
		}
	} 
	
	//等离子关
	public String plaControl_Close(String ip) {
		String[] ipAndId =  ip.split("_");
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ipAndId[0]);
		//获取电源状态
		ExcuteResultVO vo = obj.plaOff(ipAndId[1]);
		if (vo.isSuccess()) {
			addLog(ip+"等离子电源关--成功");
			return ip;
		} else {
			addLog(ip+"等离子电源开--失败");
			return null;
		}
	} 
	
	/**
	 * 音频状态，modify by 熊顺 20130218;
	 * 之前是通过不同中控IP控制其下的一个音频的状态的获取，
	 * 现如今是单个中控下的多个音频状态的获取
	 * @param ip
	 * @return
	 */
	public ArrayList<String> getaudiolist(String ip) {
		//String[] ip = ips.split(";");
		ArrayList<String> reslist = new ArrayList<String>();
		
		//for (int i = 0; i < ip.length; i++) {

			//调用中控接口
			CenterControlObject obj = (CenterControlObject) ControlFactory
					.getCenterControlObject(ip);
			ArrayList<AudioControlVO> list = obj.getAudioList();
			for(int i = 0;i<list.size();i++){
				String ipAndstatus = "";
				String sysIp = list.get(i).getId();
				String status = "";
				if (obj == null) {
					status = "x";
				} else {
					// 获取音频状态
					ExcuteResultVO vo = obj.audioStatus(sysIp);
					if (vo != null && vo.isSuccess()) {
						AudioControlVO sv = (AudioControlVO) vo.getObject();
						if (sv != null) {
							status = sv.getStatus();
							logger.info(df.format(new Date())+list.get(i).getName()+"连接状态为："+sv.getStatus());
						}else{
							status = "x";
							logger.info(df.format(new Date())+list.get(i).getName()+"连接状态为：异常！");
						}
					}else{
						status = "x";
						logger.info(df.format(new Date())+list.get(i).getName()+"连接异常！");
					}
				}
				ipAndstatus = sysIp + ";" +status;
				reslist.add(ipAndstatus);
				
			}
			
		//}
		return reslist;
	}
	//选择摄像头时发送命令的方法
	public String sendCommand(String values,String ip){
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		String com = CommandHelp.ml[Integer.parseInt(values)];
		try {
			new CenterControlClientThread(obj.getIP(),obj.getPort()).sendCommand(com);
		} catch (ZZSTControlException e) {
			e.printStackTrace();
		}
		return values;
	}
	//ip 设备ip   id 设备id  
	public String directionKey(String ip, String id, String values) {
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		ArrayList<CameraVO> list = obj.getCameraList();
		for (CameraVO cameVO : list) {
			if (cameVO.getId().equals(id)) {
				if (values.equals("up")) {
					//调用中控接口
					if (obj == null) {
						logger.info(ip + ":null");
					} else {
						ExcuteResultVO vo = obj.cameraUp(id);
						if (!vo.isSuccess()) {
							values = "";
						}
					}

				} else if (values.equals("down")) {
					//调用中控接口
					if (obj == null) {
						logger.info(ip + ":null");
					} else {
						ExcuteResultVO vo = obj.cameraDown(id);
						if (!vo.isSuccess()) {
							values = "";
						}
					}
				} else if (values.equals("left")) {
					//调用中控接口
					if (obj == null) {
						logger.info(ip + ":null");
					} else {
						ExcuteResultVO vo = obj.cameraLeft(id);
						if (!vo.isSuccess()) {
							values = "";
						}
					}

				} else if (values.equals("right")) {
					//调用中控接口
					if (obj == null) {
						logger.info(ip + ":null");
					} else {
						ExcuteResultVO vo = obj.cameraRight(id);
						if (!vo.isSuccess()) {
							values = "";
						}
					}
				}else if (values.contains("stop")) {
					//调用中控接口
					if (obj == null) {
						logger.info(ip + ":null");
					} else {
						ExcuteResultVO vo = obj.cameraStop(id);
						if (!vo.isSuccess()) {
							values = "";
						}
					}
				}
			}
		}
		return values;
	}

	//摄像头速度
	public String speed(String ip, String ids, String values) {
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		String com = null;
		if(CommandHelp.floorNum.equals("13F")){
			if(ids.equals("42")||ids.equals("43")||ids.equals("44")){//党组
				if("3".equals(values)){
					com = CommandHelp.ml[94];
				}else if("2".equals(values)){
					com = CommandHelp.ml[93];
				}else if("1".equals(values)){
					com = CommandHelp.ml[92];
				}
			}else if(ids.equals("40")||ids.equals("41")){//中型
				if("3".equals(values)){
					com = CommandHelp.ml[39];
				}else if("2".equals(values)){
					com = CommandHelp.ml[38];
				}else if("1".equals(values)){
					com = CommandHelp.ml[37];
				}
			}
		}else if(CommandHelp.floorNum.equals("12F")){
			if("3".equals(values)){//321-快中慢
				com = CommandHelp.ml[175];
			}else if("2".equals(values)){
				com = CommandHelp.ml[174];
			}else if("1".equals(values)){
				com = CommandHelp.ml[173];
			}
		}
		try {
			new CenterControlClientThread(obj.getIP(),obj.getPort()).sendCommand(com);
		} catch (ZZSTControlException e) {
			e.printStackTrace();
		}
		/*CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(ip);
		if (obj == null) {
			logger.info(ip + ":null");
		} else {
			ArrayList<CameraVO> list = obj.getCameraList();
			for (CameraVO cameVO : list) {
				if (cameVO.getId().equals(ids)) {
					ExcuteResultVO vo = obj.cameraSetSpeed(ids, values);
					if (vo.isSuccess()) {
						ip = "";
					}
				}
			}
		}*/
		return ip;
	}
	
	//摄像头变焦
	public String zooms(String op,String ip, String ids){
		if(op.equals("add")){
			CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(ip);
			if(obj==null){
				op = "";
			}
			ArrayList<CameraVO> list = obj.getCameraList();
			for (CameraVO cameVO : list) {
				if (cameVO.getId().equals(ids)) {
					ExcuteResultVO vo = obj.cameraZoomAdd(ids);
					if (!vo.isSuccess()) {
						op = "";
					}
				}
			}
		}else if(op.equals("subtract")){
			CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(ip);
			if(obj==null){
				op = "";
			}
			ArrayList<CameraVO> list = obj.getCameraList();
			for (CameraVO cameVO : list) {
				if (cameVO.getId().equals(ids)) {
					ExcuteResultVO vo = obj.cameraZoomSubtract(ids);
					if (!vo.isSuccess()) {
						op = "";
					}
				}
			}
		}
		return op;
	}
	
	public boolean cameraRecalls(String op,String ip, String ids, String values){
		boolean result=true;
		try {
			if(op.equals("recalls")){
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(ip);
				if(obj==null){
					result=false;
				}
				ArrayList<CameraVO> list = obj.getCameraList();
				for (CameraVO cameVO : list) {
					if (cameVO.getId().equals(ids)) {
						ExcuteResultVO vo = obj.cameraRecall(ids,values);
						if (!vo.isSuccess()) {
							result=false;
						}
					}
				}
			}else if(op.equals("store")){
				CenterControlObject obj = (CenterControlObject) ControlFactory.getCenterControlObject(ip);
				if(obj==null){
					result=false;
				}
				ArrayList<CameraVO> list = obj.getCameraList();
				for (CameraVO cameVO : list) {
					if (cameVO.getId().equals(ids)) {
						ExcuteResultVO vo = obj.cameraStore(ids,values);
						if (!vo.isSuccess()) {
							result=false;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			String[] infos = getMeetingRoomNameandEquimentName(ip,ids,CenterControlEnum.type_camera_id);
			String info = infos[0]+"("+ip+")"+infos[1]+"--预置位";
			if(op.equals("recalls")){
				info += "调用";
			}else if(op.equals("store")){
				info += "存储";
			}
			if(result){
				addLog(info+"成功");
			}else{
				addLog(info+"失败");
			}
		}
		return result;
	}
	
	//自动跟踪
	public boolean cameraOperation(String operation,String cameraIP,String id){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(cameraIP);
		boolean result = true;
		
		if (obj == null) {
			logger.info(cameraIP + ":null");
			result = false;
		}
		
		if(operation .equals("start")){
			ExcuteResultVO resultVO = obj.cameraAutoTrackOn(id);
			if(resultVO.isSuccess()){
				result = true;
			}else{
				result = false;
			}
		}
		if(operation.equals("close")){
			ExcuteResultVO resultVO = obj.cameraAutoTrackOff(id);
			if(resultVO.isSuccess()){
				result = true;
			}else{
				result = false;
			}
		}
		if(operation.equals("allview")){//全景
			ExcuteResultVO resultVO = cameraAllView(obj);
			if(resultVO.isSuccess()){
				result = true;
			}else{
				result = false;
			}
		}
		return result;
	}
	public ExcuteResultVO cameraAllView(CenterControlObject obj) {
		logger.info("摄像头设备控制：cameraAllView		begin");
		//String command  = ControlCommandHelp.CAMERA_AUTO_TRACK_OFF[0].replaceFirst("##1", cameraVO.getId());
		String command  = null;
		command = CommandHelp.ml[63];
		ExcuteResultVO resultVO =  new ExcuteResultVO();
		try{
			if(new CenterControlClientThread(obj.getIP(),obj.getPort()).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		logger.info("摄像头设备控制：cameraAllView		end");
		return resultVO;
	}
	//大屏电源开
	public String openScreenPowerbyIP(String ip) {
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		//获取电源状态
		ExcuteResultVO vo = obj.viewScreentON("1");
		if (vo.isSuccess()) {
			addLog(ip+"大屏电源开--成功");
			return ip;
		} else {
			addLog(ip+"大屏电源开--失败");
			return null;
		}
	}

	//大屏电源关
	public String closeScreenPowerbyIP(String ip) {
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		//获取电源状态
		ExcuteResultVO vo = obj.viewScreentOFF("1");
		if (vo.isSuccess()) {
			addLog(ip+"大屏电源关--成功");
			return ip;
		} else {
			addLog(ip+"大屏电源关--失败");
			return null;
		}
	}
	
	//大屏电源状态
	public ArrayList<String> getScreenPowerlist(String ips) {
		String[] ip = ips.split(";");
		ArrayList<EquipmentVO> equipmentList = new ArrayList<EquipmentVO>();
		ArrayList<String> reslist = new ArrayList<String>();
//		Random r = new Random();
//		int[] s = new int[] { 0, 1, -1 };
		for (int i = 0; i < ip.length; i++) {
			//调用中控接口
			CenterControlObject obj = (CenterControlObject) ControlFactory
					.getCenterControlObject(ip[i]);
			String ipAndStatus = "";
			String sysIp = ip[i];
			String status = "";
			if (obj == null) {
				logger.info(ip[i] + ":null");
				status = "x";
				logger.info(df.format(new Date())+" 中控IP："+ip[i]+"连接异常！");
			} else {
				//获取电源状态
				ExcuteResultVO vo = obj.viewScreentStauts("1");
				if (vo.isSuccess()) {
					ViewScreentVO sv = (ViewScreentVO) vo.getObject();
					if(null != sv){
						status = sv.getStatus();
					}else{
						status = "x";
						logger.info(df.format(new Date())+"连接异常！");
					}
				}else{
					status = "x";
					logger.info(df.format(new Date())+" 中控IP："+ip[i]+"连接异常！");
				}
			}
			ipAndStatus = sysIp+";"+status;
			reslist.add(ipAndStatus);
			//		reslist.add(s[(int)Math.abs(r.nextInt()%3)]);
		}
		return reslist;
	}
	
	/**
	 * 角色挂接功能
	 * @author zhangliang
	 */
	public String updateRoleFunc(String roleID,String[] funcs,String[] funcNames)
	{
			RoleVO roleVO = new RoleVO();
			if(roleID==null||roleID.length()==0)
				return "error";
			
				roleVO.setRoleID(roleID);	
				
				
			ArrayList<RoleFunc> list =new ArrayList<RoleFunc>();
			if(funcs !=null && funcs.length>0)
			{
				for(int i=0;i< funcs.length;i++ )
				{
					RoleFunc rf = new RoleFunc();
					rf.setRoleID(roleID);
					rf.setFuncID(funcs[i]);
					list.add(rf);
				}
			}
			
			
			try {
				
				new FuncServiceImpl().updateRoleFunc(roleVO, list, null);
				WebContext ctx = WebContextFactory.get(); 
				HttpSession session = ctx.getHttpServletRequest().getSession(); 
				UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
				
				RoleService roleService = new RoleServiceImpl();
				List<RoleVO> roleVOList = roleService.getRoleList(roleVO, null);
				if(roleVOList != null && roleVOList.size() > 0){
					roleVO = roleVOList.get(0);
				}
				LogUtil.addLogForOperate("重新为 "+roleVO.getRoleName()+" 添加菜单:", userVO.getUserID(), "", LogEnum.TYPE_DB, 1);
				for(String funcName:funcNames){
				LogUtil.addLogForOperate("向 "+roleVO.getRoleName()+" 添加菜单:"+funcName, userVO.getUserID(), "", LogEnum.TYPE_DB, 1);
				}
				return null;
			} catch (Exception e) {
				logger.info("设置权限异常："+e.getMessage());
				return "error";
			}
			
			
	}
	
	/**
	 * 添加操作日志
	 * @param operatorContent
	 */
	private void addLog(String operatorContent){
		try{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 

			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);

			LogVO vLogVO = new LogVO();
			vLogVO.setLogType(LogEnum.TYPE_CONTROL_OPERATION);
			vLogVO.setUserIP(ctx.getHttpServletRequest().getRemoteHost());
			vLogVO.setUserID(userVO.getUserID());
			vLogVO.setUserName(userVO.getName());
			if(operatorContent!=null&&operatorContent.length()>0){
				vLogVO.setOperatorContent(operatorContent);	
			}
//			ServiceFactory.getLogService().add(vLogVO);
			LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
		}catch(Exception e){
			
		}
	}
	
	/**
	 * 根据ccIp，equimentNO，equipmentType获取设备所属会议室以及该设备名字
	 * @param ccIp
	 * @param equimentNO
	 * @param equipmentType
	 * @return
	 */
	public static String[] getMeetingRoomNameandEquimentName(String ccIp, String equimentNO, String equipmentType){
		EquipmentVO equipmentVO = new EquipmentVO();
		equipmentVO.setIp(ccIp);
		try {
			ArrayList<EquipmentVO> equVO = ServiceFactory.getEquipmentService().query(equipmentVO, null);
			if(equVO!=null&&equVO.size()>0){
				String[] str = new String[2];
				str[0] = equVO.get(0).getMeetingRoomVO().getMeetingRoomName();
				CenterControlVO ccVO = new CenterControlVO();
				ccVO.setCcIP(ccIp);
				ccVO.setCcNO(equimentNO);
				ccVO.setEquipmentType(equipmentType);
				ArrayList<CenterControlVO> ccList = ServiceFactory.getCenterControlService().query(ccVO, null);
				if(ccList!=null&&ccList.size()>0){
					str[1] = ccList.get(0).getEquipmentName();
					return str;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//灯光控制
	public boolean lightGroupOperation(String operation,String ccIp,String choosedArray){
		boolean result = true;
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIp);
		
		if(null == choosedArray || "".equals(choosedArray)){
			result = false;
			return result;
		}
		
		String[] choosedList = choosedArray.split(",");
		ExcuteResultVO resultVO = new ExcuteResultVO();
		if(operation.contains("on")){
			resultVO =  obj.lightOn(choosedList);
		}
		if(operation.contains("off")){
			resultVO = obj.lightOff(choosedList);
		}
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIp,"1",CenterControlEnum.type_light_id);
		String info = infos[0]+"("+ccIp+")"+CenterControlEnum.type_light_name;
		if(!resultVO.isSuccess()){
			result =false;
		}
		if(result){
			addLog(info+"--操作成功");
		}else{
			addLog(info+"--操作失败");
		}
		return result;
	}
	
	//升降屏控制
	public boolean liftingGroupOperation(String operation,String ccIp,String choosedArray){
		boolean result = true;
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIp);
		
		if(null == choosedArray || "".equals(choosedArray)){
			result = false;
			return result;
		}
		
		String[] choosedList = choosedArray.split(",");
		ExcuteResultVO resultVO = new ExcuteResultVO();
		
		if(operation.contains("on")){
			resultVO =  obj.upDownScreenScreenUP(choosedList);
		}
		if(operation.contains("off")){
			resultVO = obj.upDownScreenScreenDown(choosedList);
		}
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIp,"1",CenterControlEnum.type_upDownScreen_id);
		String info = infos[0]+"("+ccIp+")"+CenterControlEnum.type_upDownScreen_name;
		if(!resultVO.isSuccess()){
			result =false;
		}
		if(result){
			addLog(info+"--操作成功");
		}else{
			addLog(info+"--操作失败");
		}
		return result;
	}

	//等离子控制
	public boolean plasmaGroupOperation(String operation,String ccIp,String choosedArray){
		boolean result = true;
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIp);
		
		if(null == choosedArray || "".equals(choosedArray)){
			result = false;
			return result;
		}
		
		String[] choosedList = choosedArray.split(",");
		
		ExcuteResultVO resultVO = new ExcuteResultVO();
		
		if(operation.contains("on")){
			resultVO =  obj.plaOn(choosedList);
		}
		if(operation.contains("off")){
			resultVO = obj.plaOff(choosedList);
		}
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIp,"1",CenterControlEnum.type_pla_id);
		String info = infos[0]+"("+ccIp+")"+CenterControlEnum.type_camera_name;
		//20130220控制台输出正常但是还是返回false
		if(!resultVO.isSuccess()){
			result =false;
		}
		if(result){
			addLog(info+"--操作成功");
		}else{
			addLog(info+"--操作失败");
		}
		return result;
	}
	public String plaChange(String op,String ccIp){
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ccIp);
		int tem = Integer.parseInt(op);
		String command = null;
		switch (tem) {
			case 0:command=CommandHelp.ml[75];break;//0-9 按钮0-9
			case 1:command=CommandHelp.ml[66];break;
			case 2:command=CommandHelp.ml[67];break;
			case 3:command=CommandHelp.ml[68];break;
			case 4:command=CommandHelp.ml[69];break;
			case 5:command=CommandHelp.ml[70];break;
			case 6:command=CommandHelp.ml[71];break;
			case 7:command=CommandHelp.ml[72];break;
			case 8:command=CommandHelp.ml[73];break;
			case 9:command=CommandHelp.ml[74];break;
			case 10:command=CommandHelp.ml[65];break;//电源
			case 11:command=CommandHelp.ml[78];break;//静音
			case 12:command=CommandHelp.ml[79];break;//————
			case 13:command=CommandHelp.ml[80];break;//频道+
			case 14:command=CommandHelp.ml[82];break;//音量-
			case 15:command=CommandHelp.ml[84];break;//菜单
			case 16:command=CommandHelp.ml[83];break;//音量+
			case 17:command=CommandHelp.ml[76];break;//-/--
			case 18:command=CommandHelp.ml[77];break;//回看
			case 19:command=CommandHelp.ml[81];break;//频道-
			case 20:command=CommandHelp.ml[87];break;//RES
			case 21:command=CommandHelp.ml[88];break;//9画面
			case 22:command=CommandHelp.ml[178];break;//Skip
			case 23:command=CommandHelp.ml[85];break;//Exit
			case 24:command=CommandHelp.ml[86];break;//PIP
			case 25:command=CommandHelp.ml[89];break;//Zz
			case 26:command=CommandHelp.ml[90];break;//Scan
			case 27:command=CommandHelp.ml[91];break;//SYS
		}
		try {
			new CenterControlClientThread(obj.getIP(),obj.getPort()).sendCommand(command);
		} catch (ZZSTControlException e) {
			e.printStackTrace();
		}
		return command;
	}
	/**
	 * add by xiongshun 20130314 等离子频道的切换
	 * @param ccIp
	 * @param plasma_id
	 * @param plasma_no
	 * @return
	 */
	public String plaChannel(String ccIp,String plasma_id,String plasma_no){
		String result = null;
		try {
			CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ccIp);
			ExcuteResultVO resultVO =  obj.plaChannel(plasma_id, plasma_no);
			PlaVO plaVO = (PlaVO) resultVO.getObject();
			
			String[] infos = getMeetingRoomNameandEquimentName(ccIp,plasma_id,CenterControlEnum.type_pla_id);
			String info = infos[0]+"("+ccIp+")"+infos[1]+"--频道切换";
			if(plaVO!=null){
				addLog(info+"（"+plaVO.getName()+"）成功");
				logger.info(plaVO.getName()+"当前频道为："+plaVO.getChannel()+"-"+plaVO.getChannelList()[Integer.parseInt(plaVO.getChannel())-1][1]+"。当前时间为："+df.format(new Date()));
			}else{
				addLog(info+"失败");
				result = plasma_id;
				logger.info("网络不通！");
			}
		} catch (Exception e) {
			result = plasma_id;
			logger.info(e.getMessage());
		}finally{
			return result;
		}
	}
	
	//可视同——同步数据——视频监控
	public boolean synchronizeInfo_camera(){
		boolean result = true;
		CameraAction cameraAction = new CameraAction();
		ArrayList<CameraGroup> treelist = cameraAction.initList();
		logger.info("==================="+treelist.size());
		ArrayList<CameraGroup> updateTreeList = new ArrayList<CameraGroup>();
		//提取组
		if(treelist != null && treelist.size()>0 ){
			for(int i=0; i<treelist.size(); i++){
				CameraGroup cameraGroup = treelist.get(i);
				KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
				ExcuteResultVO erVO = kstImpl.getallgroups(cameraGroup.getGroupid());
				ArrayList<Group> tmplist = (ArrayList<Group>)(erVO.getObject());
				if(tmplist!=null&&tmplist.size()>0){
					for(int j=0;j<tmplist.size();j++){
						Group g = (Group)tmplist.get(j);
//						cameraGroup.setDomainid(domainid);
						CameraGroup cg = new CameraGroup();
						cg.setGroupid(g.getId());
						cg.setGroupname(g.getName());
						cg.setParent_id(cameraGroup.getGroupid());
						cg.setType(g.getType());
						cg.setDomainid(cameraGroup.getGroupid());
						updateTreeList.add(cg);	
						List<SubGroup> subGList = g.getGList();
						if(subGList!=null&&subGList.size()>0){
							for(int h=0;h<subGList.size();h++){
								SubGroup sg = subGList.get(h);
								CameraGroup cg2 = new CameraGroup();
								cg2.setGroupid(sg.getId());
								cg2.setGroupname(sg.getName());
								cg2.setParent_id(g.getId());
								cg2.setType(sg.getType());
								cg2.setDomainid(cameraGroup.getGroupid());
								List<TreeGroup> treeList = sg.getTreeList();
								if(treeList!=null && treeList.size()>0){
									cg2.setLeaf(0);
								}else{
									ExcuteResultVO erVO1 = kstImpl.getCamerasbyGroupID(sg.getId());
									ArrayList<Camera> cameralist =(ArrayList<Camera>) erVO1.getObject();
									for(Camera c : cameralist){
										CameraGroup cg4 = new CameraGroup();
										cg4.setGroupid(c.getCameraid());
										cg4.setGroupname(c.getCameraname());
										cg4.setParent_id(sg.getId());
										cg4.setType(sg.getType());
										cg4.setDomainid(cameraGroup.getGroupid());
										cg4.setLeaf(2);
										updateTreeList.add(cg4);
									}
									cg2.setLeaf(1);
								}
								updateTreeList.add(cg2);
								
								if(treeList!=null && treeList.size()>0){
									for(int a=0;a<treeList.size();a++){
										TreeGroup tg = treeList.get(a);
										CameraGroup cg3 = new CameraGroup();
										cg3.setGroupid(tg.getId());
										cg3.setGroupname(tg.getName());
										cg3.setParent_id(sg.getId());
										cg3.setType(g.getType());
										cg3.setDomainid(cameraGroup.getGroupid());
										cg3.setLeaf(1);
										ExcuteResultVO erVO2 = kstImpl.getCamerasbyGroupID(tg.getId());
										ArrayList<Camera> cameralist =(ArrayList<Camera>) erVO2.getObject();
										for(Camera c : cameralist){
											CameraGroup cg5 = new CameraGroup();
											cg5.setGroupid(c.getCameraid());
											cg5.setGroupname(c.getCameraname());
											cg5.setParent_id(tg.getId());
											cg5.setType(sg.getType());
											cg5.setDomainid(cameraGroup.getGroupid());
											cg5.setLeaf(2);
											updateTreeList.add(cg5);
										}
										updateTreeList.add(cg3);
									}
								}
							}
						}
					}
				}
			}
		}
		
//		if(treelist != null && treelist.size()>0 ){
//			for(int i=0; i<treelist.size(); i++){
//				CameraGroup cameraGroup = treelist.get(i);
//				String url = MeetingAppConfig.kst_server_province;
//				url = url.replaceFirst("##1", cameraGroup.getGroupid());
//				ArrayList<Group> tmplist = KSTUtil.getallgroups(url);
//				if(tmplist!=null&&tmplist.size()>0){
//					for(int j=0;j<tmplist.size();j++){
//						Group g = tmplist.get(j);
////						cameraGroup.setDomainid(domainid);
//						CameraGroup cg = new CameraGroup();
//						cg.setGroupid(g.getId());
//						cg.setGroupname(g.getName());
//						cg.setParent_id(cameraGroup.getGroupid());
//						cg.setType(g.getType());
//						cg.setDomainid(cameraGroup.getGroupid());
//						updateTreeList.add(cg);	
//						List<SubGroup> subGList = g.getGList();
//						if(subGList!=null&&subGList.size()>0){
//							for(int h=0;h<subGList.size();h++){
//								SubGroup sg = subGList.get(h);
//								CameraGroup cg2 = new CameraGroup();
//								cg2.setGroupid(sg.getId());
//								cg2.setGroupname(sg.getName());
//								cg2.setParent_id(g.getId());
//								cg2.setType(sg.getType());
//								cg2.setDomainid(cameraGroup.getGroupid());
//								cg2.setLeaf(1);
//								updateTreeList.add(cg2);
//							}
//						}
//					}
//				}
//			}
//		}
		try{
			new KstVedioMoniterServiceImpl().delKstVedioMoniter();//正式环境下放开
			new KstVedioMoniterServiceImpl().addKstVedioMoniter(updateTreeList);
		}catch (Exception e) {
			logger.error("同步可视通基础信息失败"+e.getMessage());	
			result = false;
		}
		return result;
	}
	
	//可视通——同步数据——电视墙
	public boolean synchronizeInfo_wallPreset (){
		boolean result = true;
		try{
			ServiceFactory.getWallPresetService().deleteAll();
			
			KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
			ExcuteResultVO erVO=kstImpl.getallWallPreset();
			Presets presets= (Presets)(erVO.getObject());
			
//			Presets presets= KSTUtil.getallWallPreset(MeetingAppConfig.kst_server_wallpreset);
			if(presets!=null&&presets.getDataList()!=null&&presets.getDataList().size()>0){
				for(int i=0;i<presets.getDataList().size();i++){
					Node node = presets.getDataList().get(i);
					WallPresetVO wallPresetVO = new WallPresetVO();
					wallPresetVO.setId(node.getPresetid());
					wallPresetVO.setViewName(node.getPresetname());
					try{
						ServiceFactory.getWallPresetService().add(wallPresetVO);	
					}catch(Exception e){
						logger.error("可视通电视墙基础数据插入异常:"+e.getMessage());
					}
				}
			}
		}catch(Exception e){
			logger.error("提取可视通--电视墙基础信息失败"+e.getMessage());	
			result = false;
		}
		return result;
	}
	
	/***
	 * 
	 * 发送电视墙指令
	 * 
	 */
	public boolean sendMsgToWallPreset(String id){
		try {
			KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
			kstImpl.exectWallPreset(id);
			//KSTUtil.exectWallPreset(url);
		} catch (Exception e) {
			logger.error("发送电视墙指令失败："+e.getMessage());
			return false;
		}
		return true;
	}
	
	/***
	 * 
	 * 查看组内所有摄像头图像
	 * 
	 */
	public String viewAll(String system,String group,String model){
		ExcuteResultVO erVO = new ExcuteResultVO();
		try {
			KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
			erVO = kstImpl.viewGroupVideo(system, group, model);
		} catch (Exception e) {
			logger.error("发送电视墙指令失败："+e.getMessage());
			return "";
		}
		return (String)(erVO.getObject());
	}
	
	/***
	 * 
	 * 查看单个摄像头图像
	 * 
	 */
	public String viewOne(String system,String group,String model){
		ExcuteResultVO erVO = new ExcuteResultVO();
		try {
			KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
			erVO = kstImpl.getCameraVideo(system, group, model);
		} catch (Exception e) {
			logger.error("发送电视墙指令失败："+e.getMessage());
			return "";
		}
		return (String)(erVO.getObject());
	}

	/***
	 * DVD方向
	 * @author yangyi
	 */
	public String directionForDVD(String ip,String op){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ip);
		if(op!=null){
			if(op.equals("up")){
				ExcuteResultVO resultVO = obj.dvdUP("1");
				if(resultVO != null && resultVO.isSuccess()){
					return op;
				}
			}
			if(op.equals("down")){
				ExcuteResultVO resultVO = obj.dvdDown("1");
				if(resultVO != null && resultVO.isSuccess()){
					return op;
				}
			}
			if(op.equals("left")){
				ExcuteResultVO resultVO = obj.dvdLeft("1");
				if(resultVO != null && resultVO.isSuccess()){
					return op;
				}
			}
			if(op.equals("right")){
				ExcuteResultVO resultVO = obj.dvdRight("1");
				if(resultVO != null && resultVO.isSuccess()){
					return op;
				}
			}
			if(op.equals("enter")){
				ExcuteResultVO resultVO = obj.dvdEnter("1");
				if(resultVO != null && resultVO.isSuccess()){
					return op;
				}
			}
		}
		return null;
	}
	
	/**
	 * DVD操作
	 * @author yangyi
	 */
	public boolean operatorForDVD(String ip,String op){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ip);
		
		String[] infos = getMeetingRoomNameandEquimentName(ip,MeetingAppConfig.CC_DEF_ID,CenterControlEnum.type_dvd_id);
		String info = infos[0]+"("+ip+")"+infos[1]+"--";
		if(op!=null){
			if(op.equals("menu")){
				ExcuteResultVO resultVO = obj.dvdMenu("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"菜单操作成功");
					return true;
				}
				addLog(info+"菜单操作失败");
			}
			if(op.equals("back")){
				ExcuteResultVO resultVO = obj.dvdBack("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"返回操作成功");
					return true;
				}
				addLog(info+"返回操作失败");
			}
			if(op.equals("audioLine")){
				ExcuteResultVO resultVO = obj.dvdAudioLine("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"声道操作成功");
					return true;
				}
				addLog(info+"声道操作失败");
			}
			if(op.equals("title")){
				ExcuteResultVO resultVO = obj.dvdtitle("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"字幕操作成功");
					return true;
				}
				addLog(info+"字幕操作失败");
			}
			if(op.equals("power")){
				ExcuteResultVO resultVO = obj.dvdPower("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"电源操作成功");
					return true;
				}
				addLog(info+"电源操作失败");
			}
			if(op.equals("openOrClose")){
				ExcuteResultVO resultVO = obj.dvdOpcl("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"开/关仓操作成功");
					return true;
				}
				addLog(info+"开/关仓操作失败");
			}
		}
		return false;
	}
	
	/**
	 * DVD数字
	 * @author yangyi
	 */
	public boolean numForDVD(String ip, String op){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ip);
		if(op!=null){
			ExcuteResultVO resultVO = obj.dvdNum("1",op);
			if(resultVO != null && resultVO.isSuccess()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * DVD字符
	 * @author yangyi
	 */
	public boolean charForDVD(String ip, String op){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ip);
		
		String[] infos = getMeetingRoomNameandEquimentName(ip,MeetingAppConfig.CC_DEF_ID,CenterControlEnum.type_dvd_id);
		String info = infos[0]+"("+ip+")"+infos[1]+"--";
		if(op!=null){
			if(op.equals("start")){
				ExcuteResultVO resultVO = obj.dvdPlay("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"开始操作成功");
					return true;
				}
				addLog(info+"开始操作失败");
			}
			if(op.equals("pause")){
				ExcuteResultVO resultVO = obj.dvdPause("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"暂停操作成功");
					return true;
				}
				addLog(info+"暂停操作失败");
			}
			if(op.equals("stop")){
				ExcuteResultVO resultVO = obj.dvdStop("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"停止操作成功");
					return true;
				}
				addLog(info+"停止操作失败");
			}
			if(op.equals("nextSong")){
				ExcuteResultVO resultVO = obj.dvdNext("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"下一首操作成功");
					return true;
				}
				addLog(info+"下一首操作失败");
			}
			if(op.equals("lastSong")){
				ExcuteResultVO resultVO = obj.dvdPrev("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"上一首操作成功");
					return true;
				}
				addLog(info+"上一首操作失败");
			}
			if(op.equals("forward")){
				ExcuteResultVO resultVO = obj.dvdForward("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"前进操作成功");
					return true;
				}
				addLog(info+"前进操作失败");
			}
			if(op.equals("reverse")){
				ExcuteResultVO resultVO = obj.dvdReverse("1");
				if(resultVO != null && resultVO.isSuccess()){
					addLog(info+"后退操作成功");
					return true;
				}
				addLog(info+"后退操作失败");
			}
		}
		return false;
	}
	
	/**
	 * 自动开关机
	 * @param operation
	 * @param ccIP
	 * @param hour
	 * @param minute
	 * @return
	 */
	public boolean fixedTimeControl(String parame,String operation,String ccIP,String hour,String minute){
		boolean result = true;
		 logger.info(parame+"======="+operation+"=="+ccIP+"=="+hour+"=="+minute);
		 if(hour==null||hour.length()==0||minute==null||minute.length()==0){
			 return false;
		 }
		 
		 if(parame.equalsIgnoreCase("on")){//定时开设备
			 if(operation.contains("on")){
				 Calendar c = Calendar.getInstance();
				 c.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hour).intValue());
				 c.set(Calendar.MINUTE, Integer.valueOf(minute).intValue());
				 long delay = c.getTimeInMillis()-System.currentTimeMillis();
				 if(delay<=0){//修正设置时间在当前时间之前的bug
					 delay = delay + 24*60*60*1000;
				 }
				 
				 FixedTimeTask2 f2 = new FixedTimeTask2(ccIP+parame,"定时开启设备","on;"+ccIP+";"+hour+";"+minute);
				 new Timer(true).schedule(f2,delay,24*60*60*1000);
//				 new Timer(true).schedule(f2,2000,5000);
				 repeatTask.put(ccIP+parame, f2);

				saveFixedTime(BaseInfoEnum.TYPE_FIXEDTIME,ccIP,"on",hour,minute);//存储数据库
				
				addLog(ccIP+"定时开启设备 "+hour+"点"+minute+"分");
			}
			
			if(operation.contains("off")){
				FixedTimeTask2 f= repeatTask.get(ccIP+parame);
				if(f!=null)
					f.cancel();

				removeFixedTime(BaseInfoEnum.TYPE_FIXEDTIME,ccIP,"on");
				addLog(ccIP+"取消定时开启设备 ");
			}
		 }else{//定时关设备
			 if(operation.contains("on")){
				 Calendar c = Calendar.getInstance();
				 c.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hour).intValue());
				 c.set(Calendar.MINUTE, Integer.valueOf(minute).intValue());
				 long delay = c.getTimeInMillis()-System.currentTimeMillis();
				 if(delay<=0){//修正设置时间在当前时间之前的bug
					 delay = delay + 24*60*60*1000;
				 }
				 
				 FixedTimeTask2 f2 = new FixedTimeTask2(ccIP+parame,"定时关闭设备","off;"+ccIP+";"+hour+";"+minute);
				 new Timer(true).schedule(f2,delay,24*60*60*1000);
//				 new Timer(true).schedule(f2,2000,5000);
				 repeatTask.put(ccIP+parame, f2);
				
				 saveFixedTime(BaseInfoEnum.TYPE_FIXEDTIME,ccIP,"off",hour,minute);//存储数据库
				 addLog(ccIP+"定时关闭设备 "+hour+"点"+minute+"分");
			}
			
			if(operation.contains("off")){
				FixedTimeTask2 f= repeatTask.get(ccIP+parame);
				if(f!=null)
					f.cancel();

				removeFixedTime(BaseInfoEnum.TYPE_FIXEDTIME,ccIP,"off");
				addLog(ccIP+"取消定时关闭设备 ");
			}
		 }
		return result;
	}
	
	/**
	 * 
	 * 屏幕共享上行
	 * 
	 */
	public String screenShareUp(String ip){
		
		String result = "成功";
		String op_model = "";
		try{
			//得到远端中控对象，并取得远端当前的大屏模式信息
			CenterControlObject obj_op = (CenterControlObject)ControlFactory.getCenterControlObject(ip);
			ViewScreentVO op_model_vo = (ViewScreentVO)(obj_op.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID).getObject());
			op_model = op_model_vo.getModel();
			if(op_model.indexOf("VLINK")==-1){
				result = "本地未选择屏幕共享模式，只有数据共享模式才能执行此操作";
				return result;
			}
			
			//得到本地中控对象，并将远端大屏模式设置到本地
			CenterControlObject obj_local = (CenterControlObject)ControlFactory.getCenterControlObject(MeetingAppConfig.LOCAL_CCIP);
			if(op_model != null){
				obj_local.viewScreentModel(MeetingAppConfig.CC_DEF_ID, op_model);
			}else{
				throw new Exception("未取到远端当前大屏模式");
			}
			
			//根据当前远端模式，进行操作
//			if(op_model.indexOf("221-VLINK") != -1){
//				//提取远端当前模式下的信号源
//				ViewScreentVO vo = (ViewScreentVO)(obj_op.viewScreentModelStatusInfo(MeetingAppConfig.CC_DEF_ID).getObject());
//				
//				//将远端信号源设置到本地
//				if(vo.getModelInfo().length == 1){
//					source = vo.getModelInfo()[0];
//					obj_local.viewScreentModelInfo(MeetingAppConfig.CC_DEF_ID, op_model, MeetingAppConfig.CC_DEF_ID, source);
//				}
//			}
			
		}catch (Exception e) {
			result = "失败";
			logger.error(e.getMessage());
			return result;
		}
		
		if(synchronizeThread == null){
			synchronizeThread = new SynchronizeThread(ip);
			synchronizeThread.setCurrentModel(op_model);
			synchronizeThread.setOperateType("up");
			synchronizeThread.start();
		}else {
			synchronizeThread.setOperateIP(ip);
			synchronizeThread.setCurrentModel(op_model);
			synchronizeThread.setOperateType("up");
		}
		
		return result;
	}
	
//	public static void main(String[] args) {
//		
//		PropertyConfigurator.configure("E:/workspaceyy/cinda_meeting/controlProject/src/applog4j.properties");//加载.properties文件 
//		new CCTest().initSys();
//			
////		new CCTest().initCenterControlDate("10.215.9.50");
//		new CCTest().initCenterControlDate("10.255.255.19");
//		CenterControlObject obj = (CenterControlObject)ControlFactory.getCenterControlObject("10.255.255.19");
//		
//		DwrMethod dwr = new DwrMethod();
//		
//		dwr.projOperation("on", "10.255.255.19", "1");
//	}
	
	/**
	 * 
	 * 屏幕共享下行
	 * 
	 */
	public String screenShareDown(String ip){

		String result = "成功";
		String local_model = "";
		try{
			//得到本地中控对象，并取得本地当前的大屏模式信息
			CenterControlObject obj_local = (CenterControlObject)ControlFactory.getCenterControlObject(MeetingAppConfig.LOCAL_CCIP);
			ViewScreentVO local_model_vo = (ViewScreentVO)(obj_local.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID).getObject());
			local_model = local_model_vo.getModel();
			//local_model = "521-LINK";
			if(local_model.indexOf("VLINK")==-1){
				result = "远端未选择屏幕共享模式，只有数据共享模式才能执行此操作";
				return result;
			}
			
			//得到远端中控对象，并将本地大屏模式设置到远端
			CenterControlObject obj_op = (CenterControlObject)ControlFactory.getCenterControlObject(ip);
			if(local_model != null){
				obj_op.viewScreentModel(MeetingAppConfig.CC_DEF_ID, local_model);
			}else{
				throw new Exception("未取到本地当前大屏模式");
			}
			
			//根据当前本地模式，进行操作
//			if(local_model.indexOf("221-VLINK") != -1){
//				//提取本地当前模式下的信号源
//				ViewScreentVO vo = (ViewScreentVO)(obj_local.viewScreentModelStatusInfo(MeetingAppConfig.CC_DEF_ID).getObject());
//				
//				//将本地信号源设置到远端
//				if(vo.getModelInfo().length == 1){
//					source = vo.getModelInfo()[0];
//					obj_op.viewScreentModelInfo(MeetingAppConfig.CC_DEF_ID, local_model, MeetingAppConfig.CC_DEF_ID, source);
//				}
//			}
			
		}catch (Exception e) {
			result = "失败";
			logger.error(e.getMessage());
			return result;
		}
		
		if(synchronizeThread == null){
			synchronizeThread = new SynchronizeThread(ip);
			synchronizeThread.setCurrentModel(local_model);
			synchronizeThread.setOperateType("down");
			synchronizeThread.start();
		}else {
			synchronizeThread.setOperateIP(ip);
			synchronizeThread.setCurrentModel(local_model);
			synchronizeThread.setOperateType("down");
		}
		
		return result;
	}
	
	/***
	 * 切换数据共享矩阵
	 * 
	 * @param op_ip
	 * @param sourceName
	 * @return result
	 */
	public String changeSourceVlink(String op_ip,String sourceName){
		String result = "成功";
		
		CenterControlObject obj_op = (CenterControlObject)ControlFactory.getCenterControlObject(op_ip);
		ViewScreentVO op_model_vo = (ViewScreentVO)(obj_op.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID).getObject());
		String op_model = op_model_vo.getModel();
		
		if(op_model!=null){
			if(op_model.indexOf("221-VLINK") == -1){
				result = "只有数据共享2分屏模式才能执行此操作";
			}else{
				try{
					obj_op.viewScreentModelInfo(MeetingAppConfig.CC_DEF_ID, op_model, MeetingAppConfig.CC_DEF_ID, sourceName);
				}catch (Exception e) {
					logger.error(e.getMessage());
					result = "失败";
				}
			}
		}else{
			result = "失败";
		}
		return result;
	}
	
	private void saveFixedTime(String type,String ccIP,String value,String hour,String minute){
		try {
			//删除
			BaseInfoVO infoVO = new BaseInfoVO();
			infoVO.setInfoType(type);
			infoVO.setInfoName(ccIP);
			infoVO.setInfoValue(value);
			
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(infoVO, null);
			if(list!=null&&list.size()==0){
				infoVO.setDescription(hour+"-"+minute);
				ServiceFactory.getBaseInfoService().add(infoVO);
			}else{
				infoVO =list.get(0);
				infoVO.setDescription(hour+"-"+minute);
				ServiceFactory.getBaseInfoService().modify(infoVO);
			}
		} catch (Exception e) {
			logger.error("添加定时功能异常	:"+e.getMessage());
		}
	}
	
	private void removeFixedTime(String type,String ccIP,String value){
		BaseInfoVO infoVO = new BaseInfoVO();
		 infoVO.setInfoType(type);
		 infoVO.setInfoName(ccIP);
		 infoVO.setInfoValue(value);
		 try {
			ArrayList<BaseInfoVO> list = ServiceFactory.getBaseInfoService().query(infoVO, null);
			for(BaseInfoVO vo : list){
				if(vo.getInfoValue().indexOf(value)==0){
					ServiceFactory.getBaseInfoService().deleteByID(vo.getId());
					continue;
				}
			}
		} catch (Exception e) {
			logger.error("删除定时功能异常	:"+e.getMessage());
		}
	}
	
	/**
	 * addby chenshuo
	 * 根据会议室ID查询该会议室是否已有终端
	 * @param roomID
	 * @return
	 */
	public boolean isMeetingRoomTerminalExist( String roomID ){
		try{
			EquipmentVO equipmentVO = new EquipmentVO();
			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			meetingRoomVO.setMeetingRoomID(roomID);
			equipmentVO.setEquipmentType(0);
			equipmentVO.setMeetingRoomVO(meetingRoomVO);
			ArrayList<EquipmentVO> listEquipment =  ServiceFactory.getEquipmentService().query(equipmentVO, null);
			if( listEquipment !=null && listEquipment.size() > 0 ){
				return true;
			}else if( listEquipment !=null && listEquipment.size() == 0 ){
				return false;
			}
			
		}catch (Exception e) {
			logger.error("查询会议室是否已有终端异常   :" + e.getMessage());
		}
		return false;
	}
	
	public void setSynchronizeThread(SynchronizeThread synchronizeThread) {
		this.synchronizeThread = synchronizeThread;
	}
	public SynchronizeThread getSynchronizeThread() {
		return synchronizeThread;
	}
	/**
	 * 可视通视频监控程序
	 * @param groupid
	 * @return
	 */
	public String videoMonitoring(String groupid , String meetingDetailID){
		
		System.out.println("####################"+groupid+";"+meetingDetailID+"。。。。"+kstMeetingNum);
		//1.通过vci告诉流媒体服务器要查看的摄像机id和通道号分屏
		//2.在可视通网关上建立会议
		//3.通过会议名称将rtspUrl邀请进会议
		//4.mcu将可视通网关加到会议中
		
//		if(!kstMeetingNum.equals("-1")){
//			System.out.println("****************-----------");
//			DwrMethod.stopMonitoring(kstMeetingNum,meetingDetailID);
//			kstMeetingNum = "-1";
//		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		KstVO kstVO = new KstVO();
		kstVO.setIp(MeetingAppConfig.kst_server_IP);
		kstVO.setPort(10000);
		kstVO.setVideoIP(MeetingAppConfig.kst_vlc_IP);
		KstObject kstImpl = new KstObjectImpl(kstVO);
		String back  =(String) kstImpl.setChannel("16", "1", groupid).getObject();//通道1分屏1
		System.out.println("设置通道号返回指令：："+back);
		if(kstMeetingNum.equals("-1")){
			ExcuteResultVO erVO  = kstImpl.startModeMeeting(liveTemplateName, null);
			System.out.println("可视通网关建会返回会议编号：："+(String)erVO.getObject());
			kstMeetingNum = (String)erVO.getObject();
			ExcuteResultVO erVO1 = kstImpl.inviteVideoTerminal("16", (String)erVO.getObject());//通道号和上面必须一致
			System.out.println("可视通网关邀请摄像机返回值：："+(String)erVO.getObject());
		}
		kstImpl.connectAll(kstMeetingNum);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		McuControlDwr mcuControlDwr = new McuControlDwr();
		mcuControlDwr.addParticipants(meetingDetailID, MeetingAppConfig.kst_mcu_IP);
//		System.out.println("mcu添加结束.......");
		return kstMeetingNum;
	}
	
	public String videoMonitoring1(String groupid , String meetingDetailID){
		System.out.println("####################"+groupid+";"+meetingDetailID+"。。。。"+kstMeetingNum);
		//1.通过vci告诉流媒体服务器要查看的摄像机id和通道号分屏
		//2.在可视通网关上建立会议
		//3.通过会议名称将rtspUrl邀请进会议
		//4.mcu将可视通网关加到会议中
		
//		if(!kstMeetingNum.equals("-1")){
//			System.out.println("****************-----------");
//			DwrMethod.stopMonitoring(kstMeetingNum,meetingDetailID);
//			kstMeetingNum = "-1";
//		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		KstVO kstVO = new KstVO();
		kstVO.setIp(MeetingAppConfig.kst_server_IP);
		kstVO.setPort(10000);
		kstVO.setVideoIP(MeetingAppConfig.kst_vlc_IP);
		KstObject kstImpl = new KstObjectImpl(kstVO);
		String back  =(String) kstImpl.setChannel("16", "1", groupid).getObject();//通道1分屏1
		System.out.println("设置通道号返回指令：："+back);
		if(kstMeetingNum.equals("-1")){
			ExcuteResultVO erVO  = kstImpl.startLiveMeeting("中画质",null);
			System.out.println("可视通网关建会返回会议编号：："+(String)erVO.getObject());
			kstMeetingNum = (String)erVO.getObject();
			ExcuteResultVO erVO1 = kstImpl.inviteVideoTerminal("16", (String)erVO.getObject());//通道号和上面必须一致
			System.out.println("可视通网关邀请摄像机返回值：："+(String)erVO.getObject());
		}
		kstImpl.connectAll(kstMeetingNum);//全部重邀
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		McuControlDwr mcuControlDwr = new McuControlDwr();
		mcuControlDwr.addParticipants(meetingDetailID, MeetingAppConfig.kst_mcu_IP);
		System.out.println("mcu添加结束.......");
		return kstMeetingNum;
	}
	
	public static void main(String[] args) {
		DwrMethod m = new DwrMethod();
		m.videoMonitoring("", "");
	}
	/**
	 * 可视通关闭监控
	 * @param kstMeetNumber
	 * @param meetingDetailID
	 * @return
	 */
	public static String stopMonitoring(String kstMeetNumber,String meetingDetailID){
		System.out.println("**********结束会议：："+kstMeetNumber+"::"+meetingDetailID);
		KstObject kstImpl = ControlFactory.getKstObject(MeetingAppConfig.kst_server_IP);
		//通知可视通网关关闭会议
//		kstImpl.stopLiveMeet(kstMeetNumber);
		//MCU将可视通网关挂断
		kstImpl.stopModeMeeting(kstMeetNumber);
		McuDwrMethod mcuDwr = new McuDwrMethod();
		mcuDwr.deleteParticipant(meetingDetailID, MeetingAppConfig.kst_mcu_IP);
		kstMeetingNum = "-1";
//		ZZOMcuFactory.getInstance().getMcuControlHelper().dialParticipants(meetingDetailID, MeetingAppConfig.kst_mcu_IP, false);
		return "success";
	}
	
	/**
	 * add by tanzanlong
	 * @param date:2013-3-25
	 * @param  会场组中设广播者
	 * @param 
	 * @param 
	 * @param 
	 * @return
	 */
	public void setRadio(String ID,String groupId) {
		logger.info("DwrMethod	setRadio	begin");
	    TemplateEquipmentVO templateEquipmentVO=new TemplateEquipmentVO();
	    templateEquipmentVO.setGroupId(groupId);
	    try {
	    	ArrayList<TemplateEquipmentVO> templateEquipmentVOList=new ArrayList<TemplateEquipmentVO>();
	    	templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO, null);
	    	
	    	for(int i=0;i<templateEquipmentVOList.size();i++){
	    		TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
	    		templateEquipmentVO_=templateEquipmentVOList.get(i);
	    		if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_BROADCASTER){
	    			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_PTS);
	    		}
	    		if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_BROADCASTER_AND_LECTURER){
	    			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_LECTURER);
	    		}
	    		ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO_);
	    	}
	    	
			templateEquipmentVO= ServiceFactory.getTemplateEquipmentService().queryByID(ID);
			if(templateEquipmentVO.getIsMain()==TemplateEquipmentEnum.IS_LECTURER){
				templateEquipmentVO.setIsMain(TemplateEquipmentEnum.IS_BROADCASTER_AND_LECTURER);
			}else{
				templateEquipmentVO.setIsMain(TemplateEquipmentEnum.IS_BROADCASTER);
			}
			
			ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO);
			logger.info("DwrMethod	setRadio	end");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * add by tanzanlong
	 * @param date:2013-3-25
	 * @param  会场组中取消广播者
	 * @param 
	 * @param 
	 * @param 
	 * @return
	 */
	public void cancelRadio(String ID,String groupId) {
		logger.info("DwrMethod	cancelRadio	begin");
	    TemplateEquipmentVO templateEquipmentVO=new TemplateEquipmentVO();
	    templateEquipmentVO.setGroupId(groupId);
	    templateEquipmentVO.setID(ID);
	    try {
	    	ArrayList<TemplateEquipmentVO> templateEquipmentVOList=new ArrayList<TemplateEquipmentVO>();
	    	templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO, null);
	    	
	    		TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
	    		templateEquipmentVO_=templateEquipmentVOList.get(0);
	    		if(templateEquipmentVO_!=null&&templateEquipmentVO_.getID()!=null){
	    		
	    		if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_BROADCASTER){
	    			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_PTS);
	    		}
	    		if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_BROADCASTER_AND_LECTURER){
	    			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_LECTURER);
	    		}
	    		ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO_);
	    		}
	    		
			logger.info("DwrMethod	cancelRadio	end");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * add by tanzanlong
	 * @param date:2013-3-25
	 * @param  会场组中设广播者
	 * @param 
	 * @return
	 */
	public void setSpeaker(String ID,String groupId) {
		logger.info("DwrMethod	setSpeaker	begin");
	    TemplateEquipmentVO templateEquipmentVO=new TemplateEquipmentVO();
	    try {
	    	ArrayList<TemplateEquipmentVO> templateEquipmentVOList=new ArrayList<TemplateEquipmentVO>();
	    	templateEquipmentVO.setGroupId(groupId);
	    	templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO, null);
	    	
	    	for(int i=0;i<templateEquipmentVOList.size();i++){
	    		TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
	    		templateEquipmentVO_=templateEquipmentVOList.get(i);
	    		if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_LECTURER){
	    			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_PTS);
	    		}
	    		if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_BROADCASTER_AND_LECTURER){
	    			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_BROADCASTER);
	    		}
	    		
	    		ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO_);
	    	}
	    	
			templateEquipmentVO= ServiceFactory.getTemplateEquipmentService().queryByID(ID);
			
			if(templateEquipmentVO.getIsMain()==TemplateEquipmentEnum.IS_BROADCASTER){
				templateEquipmentVO.setIsMain(TemplateEquipmentEnum.IS_BROADCASTER_AND_LECTURER);
			}else{
				templateEquipmentVO.setIsMain(TemplateEquipmentEnum.IS_LECTURER);
			}
			
			ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO);
			logger.info("DwrMethod	setSpeaker	end");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * add by tanzanlong
	 * @param date:2013-3-25
	 * @param  会场组中取消广播者
	 * @param 
	 * @param 
	 * @param 
	 * @return
	 */
	public void cancelSpeaker(String ID,String groupId) {
		logger.info("DwrMethod	cancelSpeaker	begin");
	    TemplateEquipmentVO templateEquipmentVO=new TemplateEquipmentVO();
	    templateEquipmentVO.setGroupId(groupId);
	    templateEquipmentVO.setID(ID);
	    try {
	    	ArrayList<TemplateEquipmentVO> templateEquipmentVOList=new ArrayList<TemplateEquipmentVO>();
	    	templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO, null);
	    	
	    		TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
	    		templateEquipmentVO_=templateEquipmentVOList.get(0);
	    		if(templateEquipmentVO_!=null&&templateEquipmentVO_.getID()!=null){
	    		
	    			if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_LECTURER){
	        			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_PTS);
	        		}
	        		if(templateEquipmentVO_.getIsMain()==TemplateEquipmentEnum.IS_BROADCASTER_AND_LECTURER){
	        			templateEquipmentVO_.setIsMain(TemplateEquipmentEnum.IS_BROADCASTER);
	        		}
	        		ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO_);
	    		}
	    		
			logger.info("DwrMethod	cancelSpeaker	end");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * add by tanzanlong
	 * @param date:2013-3-25
	 * @param  会场组中根据会场组名判断是否已被注册
	 * @param 
	 * @return
	 */
	public boolean boolGroupIsExist(String GroupName) {
		logger.info("DwrMethod	boolGroupIsExist	begin");
	    TemplateEquipmentGroupVO templateEquipmentGroupVO=new TemplateEquipmentGroupVO();
	    try {
	    	ArrayList<TemplateEquipmentGroupVO> templateEquipmentGroupVOList=new ArrayList<TemplateEquipmentGroupVO>();
	    	templateEquipmentGroupVO.setName(GroupName);
	    	templateEquipmentGroupVOList=ServiceFactory.getTemplateEquipmentGroupService().query(templateEquipmentGroupVO, null);
	    	if(templateEquipmentGroupVOList.size()>0&&templateEquipmentGroupVOList!=null){
	    		return false;
	    		
	    	}
			logger.info("DwrMethod	boolGroupIsExist	end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 窗帘操作
	 * @param op
	 * @param ccIp
	 * @param choosedArray
	 * @return
	 */
	public boolean curtainOperation(String op,String ccIp,String choosedArray){
		boolean result = true;
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIp);
		if(null == choosedArray || "".equals(choosedArray)){
			result = false;
			return result;
		}
		
		String[] choosedList = choosedArray.split(",");
		ExcuteResultVO resultVO = new ExcuteResultVO();
		for(int i=0;i<choosedList.length;i++){
			if(op.contains("on")){
				resultVO =  obj.curtainOpen(choosedList[i]);
			}
			if(op.contains("off")){
				resultVO = obj.curtainClose(choosedList[i]);
			}
		}
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIp,MeetingAppConfig.CC_DEF_ID,CenterControlEnum.type_curtain_id);
		String info = infos[0]+"("+ccIp+")"+CenterControlEnum.type_curtain_name;
		if(!resultVO.isSuccess()){
			result =false;
		}
		if(result){
			addLog(info+"--操作成功");
		}else{
			addLog(info+"--操作失败");
		}
		return result;
	}
	 
	 /**
		 * 投影机操作
		 * @param op
		 * @param ccIp
		 * @param choosedArray
		 * @return
		 */
		public boolean projOperation(String op,String ccIp,String choosedArray){
			boolean result = true;
			
			CenterControlObject obj = (CenterControlObject) ControlFactory
			.getCenterControlObject(ccIp);
			
			if(null == choosedArray || "".equals(choosedArray)){
				result = false;
				return result;
			}
			
			String[] choosedList = choosedArray.split(",");
			
			ExcuteResultVO resultVO = new ExcuteResultVO();
			
			for(int i=0;i<choosedList.length;i++){
				if(op.contains("on")){
					resultVO =  obj.projPowerOn(choosedList[i]);
				}
				if(op.contains("off")){
					resultVO = obj.projPowerOff(choosedList[i]);
				}
			}
			
			if(!resultVO.isSuccess()){
				result =false;
			}
			return result;
		}
	
	//投影仪控制
	public boolean modifyProjector(String op,String ip){
		logger.info("投影仪设备控制：modifyProjector		begin");
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ip);
		boolean result = false;
		String command  = null;
		if(op.equals("on")){
			command = CommandHelp.ml[149];
		}else if(op.equals("off")){
			command = CommandHelp.ml[150];
		}else if(op.equals("up")){
			command = CommandHelp.ml[151];
		}else if(op.equals("down")){
			command = CommandHelp.ml[153];
		}else if(op.equals("stop")){
			command = CommandHelp.ml[152];
		}
		try{
			if(new CenterControlClientThread(obj.getIP(),obj.getPort()).sendCommand(command)){
				result = true;
			}
		}catch(Exception e){
			result = false;
		}
		return result;
	}
	/**
	  logger.info("摄像头设备控制：cameraAllView		begin");
		//String command  = ControlCommandHelp.CAMERA_AUTO_TRACK_OFF[0].replaceFirst("##1", cameraVO.getId());
		String command  = null;
		command = CommandHelp.ml[63];
		ExcuteResultVO resultVO =  new ExcuteResultVO();
		try{
			if(new CenterControlClientThread(obj.getIP(),obj.getPort()).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
		}
		logger.info("摄像头设备控制：cameraAllView		end");
		return resultVO;
	 */
		
		
		
		
		
	public boolean projectorGroupOperation(String operation,String ccIp,String choosedArray){
		boolean result = true;
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIp);
		
		if(null == choosedArray || "".equals(choosedArray)){
			result = false;
			return result;
		}
		
		String[] choosedList = choosedArray.split(",");
		ExcuteResultVO resultVO = new ExcuteResultVO();
		
		if(operation.contains("on")){
			resultVO =  obj.projGroupPowerOn(choosedList);
		}
		if(operation.contains("off")){
			resultVO = obj.projGroupPowerOff(choosedList);
		}
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIp,"1",CenterControlEnum.type_proj_id);
		String info = infos[0]+"("+ccIp+")"+CenterControlEnum.type_proj_name;
		if(!resultVO.isSuccess()){
			result =false;
		}
		if(result){
			addLog(info+"--操作成功");
		}else{
			addLog(info+"--操作失败");
		}
		return result;
	}
	
	//根据会场ID提取其MCU模板
	public String getMcuTemplateByMeetingRoomID ( String meetingRoomID ){
		logger.info("DwrMethod	getMcuTemplateByMeetingRoomID	begin");
		try{
			StringBuffer html = new StringBuffer();
			meetingRoomID = "'"+meetingRoomID+"'";
			ArrayList<EquipmentTerminalVO> mainEquipmentTerminalVOList = new EquipmentTerminalServiceImpl().queryByRoomIDs(meetingRoomID);
			EquipmentMcuVO mainMcuVO = null;
			StringBuffer buffer = new StringBuffer();
			if( mainEquipmentTerminalVOList !=null && mainEquipmentTerminalVOList.size()>0 ){
				for(int i=0; i<mainEquipmentTerminalVOList.size(); i++){
					EquipmentTerminalVO terminal = mainEquipmentTerminalVOList.get(i);
					if(i > 0){
					 buffer.append(",");	
					}
					buffer.append("'" + terminal.getIp() + "'");
				}
				EquipmentMcuService mcuser = new EquipmentMcuServiceImpl();
				ArrayList<EquipmentMcuVO> mculist = mcuser.queryByIPs(buffer.toString());
				mainMcuVO = mculist.get(0);
				BaseInfoService baseInfoService = ServiceFactory.getBaseInfoService();
				BaseInfoVO baseInfoVO = new BaseInfoVO();
				baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
				baseInfoVO.setInfoName(mainMcuVO.getIp());
				ArrayList<BaseInfoVO> baseList = baseInfoService.query(baseInfoVO, null);
				for( BaseInfoVO bio : baseList ){
						html.append("<option value='" + bio.getInfoValue() +"'");
						html.append(">" + bio.getDescription() + "</option>");
					}
				System.out.print(html.toString());
			}
			return html.toString();
		}catch( Exception e ){
			logger.error("DwrMethod getMcuTemplateByMeetingRoomID	error:	"+e.getMessage());	
			return "&nbsp";
		}
	}
	
	//根据id查询func表URL链接
	public String getFuncURLByID ( String funcID ){
		logger.info("DwrMethod	getFuncURLByID	begin");
		try{
			String url = "";
			FuncVO func = ServiceFactory.getFuncService().queryByID(funcID);
			url = func.getFunc_url()+"-"+func.getDescription();
			return url;
		}catch( Exception e ){
			logger.error("DwrMethod getFuncURLByID	error:	"+e.getMessage());	
			return "&nbsp";
		}
	}
	
	//向function表插入URL
	public String addFuncURL ( String funcID ,String url,String funcDescription ){
		logger.info("DwrMethod	getFuncURLByID	begin");
		try{
			FuncVO func = new FuncVO();
			func.setFunc_id(funcID);
			func.setFunc_url(url);
			func.setDescription(funcDescription);
			ServiceFactory.getFuncService().modify(func);
			return "success";
		}catch( Exception e ){
			logger.error("DwrMethod getFuncURLByID	error:	"+e.getMessage());	
			return "&nbsp";
		}
	}
	
	public ArrayList<CenterControlVO> getCenterControlEquipments(String meetingroomId){
		//根据id查出会议室信息，根据编号来判断使用那个中控指令
		try {
			MeetingRoomVO meetingroomVO1 = ServiceFactory.getMeetingRoomService().queryByID(meetingroomId);
			String no = meetingroomVO1.getRoomNO();
			CommandHelp.floorNum = no;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//---------------
		ArrayList<EquipmentVO> equipmentList = new ArrayList<EquipmentVO>();
		ArrayList<CenterControlVO> centerControlList = new ArrayList<CenterControlVO>();
		ArrayList<CenterControlVO> centerControlUseList = new ArrayList<CenterControlVO>();;
		EquipmentService equipmentService = new EquipmentServiceImpl();
		EquipmentVO equipmentVO = new EquipmentVO();
		MeetingRoomVO meetingroomVO = new MeetingRoomVO();
		equipmentVO.setEquipmentType(2);
		meetingroomVO.setMeetingRoomID(meetingroomId);
		equipmentVO.setMeetingRoomVO(meetingroomVO);
		try {
			equipmentList = equipmentService.query(equipmentVO, null);
			if(equipmentList!=null&&equipmentList.size()>0){
				equipmentVO = equipmentList.get(0);
				CenterControlVO centerControlVO = new CenterControlVO();
				centerControlVO.setCcIP(equipmentVO.getIp());
				CenterControlService centerControlService = new CenterControlServiceImpl();
				centerControlList = centerControlService.queryNoDuplicates(centerControlVO);
				String[][] type = CenterControlEnum.getEquipmentType();
				/**
				 * 通过strFun来维护需要展示出来的功能页面,如果该设备没有相应的页面功能则不在页面显示该设备centerControlList.remove(i)
				 * curtain窗帘,vedioTerminal视频终端audio,camera,curtain,light,matrix,pla,proj,screent,sysPower,upDownScreen,vedioTerminal
				 
				String strFun= "audio,camera,light,matrix,pla,proj,sysPower,upDownScreen,dvd,screent_view";
				String[] str = strFun.split(",");
				 
				for(int i=0;i<centerControlList.size();i++){
					for(int j=0;j<type.length;j++){
						if(centerControlList.get(i).getEquipmentType().equals(type[j][0])){
							for(int m = 0; m<str.length;m++){
								if(centerControlList.get(i).getEquipmentType().equals(str[m])){
									centerControlList.get(i).setEquipmentName(type[j][1]);
									centerControlUseList.add(centerControlList.get(i));
								}
							}
						}
					}
						
				}*/
				for(int i=0;i<centerControlList.size();i++){
					for(int j=0;j<type.length;j++){
						if(centerControlList.get(i).getEquipmentType().equals(type[j][0])){
							centerControlList.get(i).setEquipmentName(type[j][1]);
							centerControlUseList.add(centerControlList.get(i));
							//System.out.println(centerControlList.get(i).getEquipmentType());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("DwrMethod getCenterControlEquipments	error:	"+e.getMessage());	
		}
		return centerControlUseList;
	}
	
	/**
	 * 获取中控IP是否连接
	 * @param ccIp
	 * @return
	 */
	public String getccStatus(String ccIp){
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ccIp);
		if(obj!=null){
			return obj.getStatus();
		}else{
			return null;
		}
	}
	
	/**
	 * 根据单个设备的智能中控
	 * @param equipmentType
	 * @return
	 */
	public String getMeetingRoomByEquiment(String equipmentType){
		ArrayList<EquipmentVO> elist = new ArrayList<EquipmentVO>();
		ServiceFactory serviceFactory = new ServiceFactory();
		AddressVO addressVO = new AddressVO();
		MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
		EquipmentVO equipmentVO = new EquipmentVO();
		CenterControlVO centerControlVO = new CenterControlVO();
		
		centerControlVO.setEquipmentType(equipmentType);
		try {
			ArrayList<CenterControlVO> cclist= serviceFactory.getCenterControlService().query(centerControlVO, null);
			if(cclist!=null && cclist.size()>0){
				for(int i = 0;i<cclist.size();i++){
					equipmentVO.setIp(cclist.get(i).getCcIP());
					elist = serviceFactory.getEquipmentService().query(equipmentVO, null);
					if(elist!=null && elist.size()>0){
						meetingRoomVO = serviceFactory.getMeetingRoomService().queryByID(elist.get(0).getMeetingRoomVO().getMeetingRoomID());
						meetingRoomVO.setAddressVO(serviceFactory.getAddressService().queryByID(meetingRoomVO.getAddressVO().getAddressID()));
						elist.get(0).setMeetingRoomVO(meetingRoomVO);
						equipmentVOList.add(elist.get(0));
					}
				}
			}else{
				logger.info("会议室下的智能中控没有"+equipmentType);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询智能中控下有"+equipmentType+"的会议室出错！");
			return null;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if(equipmentVOList!=null && equipmentVOList.size()>0){
			Collections.sort(equipmentVOList, new Comparator<EquipmentVO>(){
	            public int compare(EquipmentVO arg0, EquipmentVO arg1) {
	                return arg0.getMeetingRoomVO().getRoomNO().compareTo(arg1.getMeetingRoomVO().getRoomNO());
	            }
	        });
			
			for(int j = 0;j<equipmentVOList.size();j++){
				addressVO = equipmentVOList.get(j).getMeetingRoomVO().getAddressVO();
				meetingRoomVO = equipmentVOList.get(j).getMeetingRoomVO();
				//判断addressId和meetingRoomID是否重复的临时字符串
				String addressTemp = "{id:\""+addressVO.getAddressID();
				String meetingRoomTemp = "{id:\""+meetingRoomVO.getMeetingRoomID();
				if(!(sb.toString().contains(addressTemp+"\","))){
					sb.append("{id:\""+addressVO.getAddressID()+"\"");
					sb.append(",pId:\""+addressVO.getParentID()+"\"");
					sb.append(",name:\""+addressVO.getName()+"\"");
					sb.append(",fullName:\""+addressVO.getName()+"\"");
					sb.append(",open:true,isParent:true},");
				}
				if(!(sb.toString().contains(meetingRoomTemp+"\","))){
					sb.append("{id:\""+meetingRoomVO.getMeetingRoomID()+"\"");
					sb.append(",pId:\""+addressVO.getAddressID()+"\"");
					sb.append(",name:\""+meetingRoomVO.getMeetingRoomName()+"\"");
					sb.append(",ccIp:\""+equipmentVOList.get(j).getIp()+"\"");
					sb.append(",equipmentType:\""+equipmentType+"\"");
					String status = "";
			        String ccStatus = new DwrMethod().getccStatus(equipmentVOList.get(j).getIp());
			        if(ccStatus==null||ccStatus=="1"){
			        	 status += "中控状态未知";
			        	 sb.append(",fullName:\""+meetingRoomVO.getMeetingRoomName()+"("+status+")\"");
			        	 sb.append(",icon:\"/icmp/meeting/equipmentControl/images/connected2.png\"");//disconnected2.png
			        }else{
			        	 status += "中控已连接";
			        	 sb.append(",fullName:\""+meetingRoomVO.getMeetingRoomName()+"("+status+")\"");
			        	 sb.append(",icon:\"/icmp/meeting/equipmentControl/images/connected2.png\"");
			        }
					sb.append(",isParent:false},");
				}
			}
		}else{
			logger.info("会议室下的智能中控没有"+equipmentType);
			return null;
		}
		String str = sb.substring(0, sb.length()-1);
		str += "];";
		logger.info("智能中控所属的会议室里的"+equipmentType+"查询成功");
		return str;
	}
	
	public String[][] changeOptions(int screenCount,String[] vals,int num,String monitor,String[][] options){
		String[] monitorinfo = monitor.split("__");   //monitorinfo 监视器信息 0.name 1.meetingID 2.mcuIp 3.participantId
		String[] meetingroominfo = vals[num].split("_"); // meetingroominfo 选择的会场 0.participantId 1.meetingID 2.confFlagId 3.mcuIp 4.name
		if(selectCount==null){ //如果第一次进入  selectCount初始化
			selectCount = new int[screenCount];
			for(int a=0;a<selectCount.length;a++){
				selectCount[a]=0;  //默认设置为0次
			}
		}
		//infos = null;
		//infos 上次的数据数组
		if(infos!=null){      //如果不是第一次
			
			String[] oldMeetingroom = infos[num].split("_");
			if(!oldMeetingroom[1].equals(meetingroominfo[1])&&(num == numCache||monitorinfo[1].equals(meetingroominfo[1]))&&selectCount[num]>0){ 
				//meetingID不同   且   （同一个select改变或主会的会场）  且 不是第一次选
				//取得该select上次选的会场所在会议中的所有会场
				List<ZZOMainStatusVO> confRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(oldMeetingroom[2], oldMeetingroom[3], oldMeetingroom[1]);
				List<ZZOMainStatusVO> confRoomList1 = new ArrayList<ZZOMainStatusVO>();
				confRoomList1.addAll(confRoomList);
				String val;  //组装select的value
				boolean flag=false;
				for(int n=0;n<confRoomList1.size();n++){     //去掉级联点
					if(!confRoomList1.get(n).getCascadeRole().equals("none")){
						confRoomList1.remove(n);
						n--;
					}
				}
				for(int m=0;m<screenCount;m++){
					if(m==num){     //当前select中option不变
						
						continue;
						
					}else{
						int len = options[m].length;		//向其他select中加入原来删除掉的会场
						String[] array = new String[len+confRoomList1.size()];
						System.arraycopy(options[m], 0, array, 0, options[m].length);
						for(int k=0;k<confRoomList1.size();k++){
							val = confRoomList1.get(k).getMcu_participant_id()+"_"+confRoomList1.get(k).getMcuMeetingID()+"_"+confRoomList1.get(k).getConfFlagId()+"_"+confRoomList1.get(k).getMcuIp()+"_"+confRoomList1.get(k).getMcu_participant_name();
							for(int t=0;t<array.length;t++){
								if(array[t]!=null&&array[t].equals(val)){
									flag = true;
									break;
								}
							}
							if(!flag){
								array[k+len] = val;
							}
							
							
							
						}
						options[m] = array;
					}
				}
			}
		}
		selectCount[num]++;   //当前select的选择次数加1
		numCache = num;      //记录本次操作的select序号
		if(!monitorinfo[1].equals(meetingroominfo[1])){     //删除其他select中当前选中会场所在会议中的会场
			String[] optionvalue;
			for(int i=0;i<screenCount;i++){
				if(i==num){
					continue;
				}else{
					int len1 = options[i].length;
					for(int n=0;n<len1;n++){
						if(options[i][n]!=null){
						optionvalue = options[i][n].split("_");
						if(optionvalue[1].equals(meetingroominfo[1])){
							for(int z=n;z<len1-1;z++){
								options[i][z]=options[i][z+1];
							}
							options[i][len1-1]=null;
							len1--;
							n--;
						}
						}
					}
				}
			}
			infos = vals;		//非主会的会场变化     记录本次所有select选中的值
		}
		return options;
		
	}
	public String videomModel(String ccip,String videomId,String modelId){
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ccip);
		//获取电源状态,audioMuteOff中传参为该音频设备在中控上注册的id
		ExcuteResultVO vo = obj.videomModel(videomId, modelId);
		//日志
		String[] infos = getMeetingRoomNameandEquimentName(ccip,videomId,CenterControlEnum.type_videom_id);
		String info = infos[0]+"("+ccip+")"+infos[1];
		if (vo.isSuccess()) {
			addLog(info+"--调用成功");
			return videomId;
		} else {
			addLog(info+"--调用失败");
			return null;
		}
	}
	
	public String setRoomModel(String ccip,String roomModelNo,String roomModelId){
		//调用中控接口
		CenterControlObject obj = (CenterControlObject) ControlFactory
				.getCenterControlObject(ccip);
		//获取电源状态,audioMuteOff中传参为该音频设备在中控上注册的id
		ExcuteResultVO vo = obj.setRoomModel(roomModelNo, roomModelId);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccip,roomModelNo,CenterControlEnum.type_roomModel_id);
		String info = infos[0]+"("+ccip+")"+infos[1];
		if (vo.isSuccess()) {
			addLog(info+"--调用成功");
			return roomModelId;
		} else {
			addLog(info+"--调用失败");
			return null;
		}
	}
	
	public String terminalBackup(String meetingDetailID,String[] terInfos){
		try {
			String [] terInfo;
			EquipmentVO equipmentVO = new EquipmentVO();
			EquipmentBackupVO equipmentBackupVO=new EquipmentBackupVO ();
			ArrayList<EquipmentVO> equipmentList1 = new ArrayList<EquipmentVO>();
			List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();
			ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
			for(int i=0;i<terInfos.length;i++){
				terInfo = terInfos[i].split("_");
				equipmentVO.setIp(terInfo[0]);
					equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO,null);
					if(equipmentVOList!=null && equipmentVOList.size()>0){
						EquipmentVO equipmentVO1 = equipmentVOList.get(0);
						equipmentBackupVO.setEquipmentID(equipmentVO1.getEquipmentID());
						ArrayList<EquipmentBackupVO> equipmentBackupVOList=ServiceFactory.getEquipmentBackupService().query(equipmentBackupVO, null);
						if(equipmentBackupVOList!=null && equipmentBackupVOList.size()>0){
							EquipmentBackupVO equipmentBackupVO1 = equipmentBackupVOList.get(0);
							EquipmentVO equipmentVO2 = new EquipmentVO();
							equipmentVO2.setEquipmentID(equipmentBackupVO1.getBackupEquipmentID());
							ArrayList<EquipmentVO> equipmentVOList1 = ServiceFactory.getEquipmentService().query(equipmentVO2, null);
							if(equipmentVOList1!=null&&equipmentVOList1.size()>0){
								equipmentVO2 = equipmentVOList1.get(0);
								EquipmentVO mcuVO = new EquipmentVO();
								mcuVO.setIp(terInfo[1]);
								mcuVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
								List<EquipmentVO> mculist = ServiceFactory.getEquipmentService().query(mcuVO, null);
								mcuVO = mculist.get(0);//添加到的MCU对象
								ZZOMainVO innerMcuVO = new ZZOMainVO();
						        innerMcuVO.setEquipmentIP(mcuVO.getIp());
						        innerMcuVO.setModelID(mcuVO.getEquipmentModel());
						            //MCU 4000 and MCU 2000 use the same model id
						        if(mcuVO.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
						            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
						        }
						        
						        ZZOMainVO innerTerminalVO = new ZZOMainVO();
						        innerTerminalVO.setEquipmentName(equipmentVO2.getMeetingRoomVO().getMeetingRoomName());
				            	innerTerminalVO.setEquipmentIP(equipmentVO2.getIp());
				            	innerTermList.add(innerTerminalVO);
				            	innerMcuVO.setSubMainVOList(innerTermList);
				            	innerMcuVOList.add(innerMcuVO);ZZOMcuFactory.getInstance().getMcuControlHelper().addParticipants(meetingDetailID, innerMcuVOList);
							}
						}
					}
					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
	
	//判断设备备份数据是否已存在
	/*date：2013-3-19
	 * author:tanzanlong
	 * 
	*/
	public ArrayList<String> preAddBckupBool(String equipmentID,String equipmentbackupIDs,String e1,String e2) throws Exception{
		logger.info("DwrMethod	preAddBckupBool begin");
		ArrayList <String>backList=new ArrayList<String>();
		try {
			EquipmentBackupVO equipmentBackupVO=new EquipmentBackupVO();
			equipmentBackupVO.setEquipmentID(equipmentID);
			equipmentBackupVO.setBackupEquipmentID(equipmentbackupIDs);
			ArrayList<EquipmentBackupVO> list=ServiceFactory.getEquipmentBackupService().query(equipmentBackupVO, null);
		    if(list.size()>0){
		    	backList.add("0");
		    	backList.add(e1);
		    	backList.add(e2);	    	
		    }
		    else{
		    	backList.add("1");
		    	backList.add(e1);
		    	backList.add(e2);	
		    }
		} catch (Exception e) {
			logger.error("DwrMethod	preAddBckupBool	error:	"+e.getMessage());
		}
		return backList;
	}

	/**
	 * 根据mcuid提取其模板
	 * @param mcuId
	 * @return
	 * @author chenshuo
	 */
	public String getTemplateByMcuIp(String mcuId){
		StringBuffer html = new StringBuffer();
		BaseInfoService baseInfoService = ServiceFactory.getBaseInfoService();
		try{
			EquipmentVO equipment = ServiceFactory.getEquipmentService().queryByID(mcuId);
			
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
			baseInfoVO.setInfoName(equipment.getIp());
			
			ArrayList<BaseInfoVO> baseList = baseInfoService.query(baseInfoVO, null);
			for( BaseInfoVO bio : baseList ){
				html.append("<option value='" + bio.getInfoValue() +"'");
				html.append(">" + bio.getDescription() + "</option>");
			}
		}catch( Exception e ){
			e.printStackTrace();
			return null;
		}
		return html.toString();
	}
	
	/**
	 * 根据mcuid提取其模板
	 * @param mcuId
	 * @return
	 * @author chenshuo
	 */
	public String getTemplateByMcuIp(String mcuId,String mcuTemplateId){
		StringBuffer html = new StringBuffer();
		BaseInfoService baseInfoService = ServiceFactory.getBaseInfoService();
		
		try{
			EquipmentVO equipment = ServiceFactory.getEquipmentService().queryByID(mcuId);
			
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
			baseInfoVO.setInfoName(equipment.getIp());
			
			ArrayList<BaseInfoVO> baseList = baseInfoService.query(baseInfoVO, null);
			for( BaseInfoVO bio : baseList ){
				html.append("<option value='" + bio.getInfoValue() +"'");
				if( bio.getInfoValue().equals(mcuTemplateId)){
					html.append("selected");
				}
				html.append(">" + bio.getDescription() + "</option>");
			}
		}catch( Exception e ){
			e.printStackTrace();
			return null;
		}
		
		return html.toString();
	}
	
	//添加会议组设备
	/*date：2013-3-22
	 * author:tanzanlong
	 * 
	*/
	public String preAddEquipent(String groupId,ArrayList<String> equipmentbackupIDs) throws Exception{
		logger.info("DwrMethod	preAddEquipent begin");
		try {
			ArrayList<TemplateEquipmentVO> templateEquipmentVOList=new ArrayList<TemplateEquipmentVO>();
			for(int i=0;i<equipmentbackupIDs.size();i++){
				EquipmentVO equipmentVO=new EquipmentVO();
				equipmentVO=ServiceFactory.getEquipmentService().queryByID(equipmentbackupIDs.get(i));
				//System.out.println(groupId+"-----groupid");
				//System.out.println(equipmentbackupIDs.get(i)+"-----groupid");
				TemplateEquipmentVO templateEquipmentVO=new TemplateEquipmentVO ();
				templateEquipmentVO.setEquipmentIp(equipmentVO.getIp());
				templateEquipmentVO.setEquipmentName(equipmentVO.getEquipmentNO());
				templateEquipmentVO.setGroupId(groupId);
				templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO,null);
				if(templateEquipmentVOList!=null&&templateEquipmentVOList.size()>0){
				continue;
				}
				templateEquipmentVO.setMeetingRoomID(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				ServiceFactory.getTemplateEquipmentService().add(templateEquipmentVO);
			}
		} catch (Exception e) {
			logger.error("DwrMethod	preAddEquipent	error:	"+e.getMessage());
		}
		return "ok";
	}
	
	/**
	 * 设备管理1模块 判断设备是否配置（在"产品发布"-"数据配置" 里面配置）。add by liujf--20131108
	 * @return
	 */
	public String getEquipmentTypeIsExit(){
		BaseInfoService baseInfoService = ServiceFactory.getBaseInfoService();
		BaseInfoVO biVO = new BaseInfoVO();
		biVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
		biVO.setDescription(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE);
		try{
			ArrayList<BaseInfoVO> baseList = baseInfoService.query(biVO, null);
			List<String> listNo = new ArrayList<String>();
			
			if( baseList != null && baseList.size()>0){
				for(int i=0;i<baseList.size();i++){
					listNo.add(baseList.get(i).getInfoValue());	
				}
				if(listNo.contains("4")||listNo.contains("9")){
					return baseList.get(0).getInfoValue();
				}
				
			}else if( baseList != null && baseList.size() == 0){
				return "none";
			}
		}catch( Exception e ){
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 设备管理模块 判断设备是否配置。（在"产品发布"-"数据配置" 里面配置）。add by liujf--20131108
	 * @return
	 */
	public String getEquipmentTypeExit(){
		BaseInfoService baseInfoService = ServiceFactory.getBaseInfoService();
		BaseInfoVO biVO = new BaseInfoVO();
		biVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
		biVO.setDescription(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE);
		try{
			ArrayList<BaseInfoVO> baseList = baseInfoService.query(biVO, null);
			List<String> listNo = new ArrayList<String>();
			
			if( baseList != null && baseList.size()>0){
				for(int i=0;i<baseList.size();i++){
					listNo.add(baseList.get(i).getInfoValue());	
				}
				if(listNo.contains("0")||listNo.contains("1")||listNo.contains("2")||listNo.contains("7")||listNo.contains("8")||listNo.contains("4")||listNo.contains("9")){
					return baseList.get(0).getInfoValue();
				}
				
			}else if( baseList != null && baseList.size() == 0){
				return "none";
			}
		}catch( Exception e ){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 返回配置的第一个设备类型
	 * @return
	 */
	public String getEquipmentType(){
		BaseInfoService baseInfoService = ServiceFactory.getBaseInfoService();
		BaseInfoVO biVO = new BaseInfoVO();
		biVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
		biVO.setDescription(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE);
		try{
			ArrayList<BaseInfoVO> baseList = baseInfoService.query(biVO, null);
			if( baseList != null && baseList.size()>0){
				return baseList.get(0).getInfoValue();
			}else if( baseList != null && baseList.size() == 0){
				return "none";
			}
		}catch( Exception e ){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 会议费用设置
	 * @param costArr
	 * @return
	 */
	public String meetingCostSetting(String[] costArr){
		for(int i=0;i<costArr.length;i++){
			String dicViewName = costArr[i].substring(0,costArr[i].lastIndexOf(":"));
			String dicValue = costArr[i].substring(costArr[i].lastIndexOf(":")+1);
			DictionaryVO dictionaryVO = new DictionaryVO();
			DictionaryService dictionaryService = new DictionaryServiceImpl();
			dictionaryVO.setDicType(DictionaryEnum.MEETINGCOST);
			dictionaryVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			dictionaryVO.setDicViewName(dicViewName);
			dictionaryVO.setDicValue(dicValue);
			try {
				dictionaryService.modifyDicValue(dictionaryVO);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return "success";
	}
	/**
	 * 添加会议费用
	 * @param meetingDetailId
	 * @param createUserID
	 * @param costArr
	 * @return
	 */
	public String addMeetingCost(String meetingDetailId,String createUserID,String[] costArr){
		//int summary = 0;
		//int summaryCout = 0;
		for(int i=0;i<costArr.length;i++){
			String costItem = costArr[i].substring(0,costArr[i].indexOf(":"));
			int costValue = Integer.parseInt(costArr[i].substring(costArr[i].indexOf(":")+1,costArr[i].lastIndexOf(":")));
			int cout = Integer.parseInt(costArr[i].substring(costArr[i].lastIndexOf(":")+1));
			MeetingDetailCostVO meetingDetailCostVO = new MeetingDetailCostVO();
			MeetingDetailCostService meetingDetailCostService = new MeetingDetailCostServiceImpl();
			//meetingDetailCostVO要设置status为有效，即0
			meetingDetailCostVO.setStatus(0);
			meetingDetailCostVO.setMeetingDetailId(meetingDetailId);
			meetingDetailCostVO.setCreateUserId(createUserID);
			meetingDetailCostVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingDetailCostVO.setCostItem(costItem);
			meetingDetailCostVO.setCostValue(costValue);
			meetingDetailCostVO.setCout(cout);
			//summary += costValue * cout;
			//summaryCout += cout;
			try {
				meetingDetailCostService.add(meetingDetailCostVO);
				/**
				if(i==(costArr.length-1)){
					meetingDetailCostVO.setCostItem("费用总计");
					meetingDetailCostVO.setCostValue(summary);
					meetingDetailCostVO.setCout(summaryCout);
					//meetingDetailCostService.add(meetingDetailCostVO);费用总计已可通过查询出，无需插入此数据
				}
				*/
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return "success";
	}
	/**
	 * 修改会议费用
	 * @param meetingDetailId
	 * @param createUserID
	 * @param costArr
	 * @return
	 */
	public String modifyMeetingCost(String meetingDetailId,String createUserID,String[] costArr){
		for(int i=0;i<costArr.length;i++){
			String costItem = costArr[i].substring(0,costArr[i].indexOf(":"));
			int costValue = Integer.parseInt(costArr[i].substring(costArr[i].indexOf(":")+1,costArr[i].lastIndexOf(":")));
			int cout = Integer.parseInt(costArr[i].substring(costArr[i].lastIndexOf(":")+1));
			MeetingDetailCostVO meetingDetailCostVO = new MeetingDetailCostVO();
			MeetingDetailCostService meetingDetailCostService = new MeetingDetailCostServiceImpl();
			//meetingDetailCostVO要设置status为有效，即0
			meetingDetailCostVO.setStatus(0);
			meetingDetailCostVO.setMeetingDetailId(meetingDetailId);
			meetingDetailCostVO.setCreateUserId(createUserID);
			meetingDetailCostVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingDetailCostVO.setCostItem(costItem);
			meetingDetailCostVO.setCostValue(costValue);
			meetingDetailCostVO.setCout(cout);
			try {
				meetingDetailCostService.modifyCout(meetingDetailCostVO);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return "success";
	}
	
	/**
	 * 根据会议Id确认是否有参会人员
	 * @param uploadKey
	 * @return
	 */
	public Boolean isGetMeetingUsers(String uploadKey){
		MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
		List<MeetingDetailUserVO> aList = new ArrayList<MeetingDetailUserVO>();
		
		vMeetingDetailUserVO.setMeetingDetailID(uploadKey);
		try {
			aList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(vMeetingDetailUserVO, null);
			if(aList!=null&&aList.size()>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 资料管理~授权下载功能~获取用户信息树
	 * @return
	 */
	public String getUsers(){
		List<DepartmentVO> dList = new ArrayList<DepartmentVO>();
		List<UserVO> uList = new ArrayList<UserVO>();
		DepartmentVO dpvo = new DepartmentVO();
		UserVO userVO = new UserVO();
		//构造树数据 
		StringBuffer sbUser = new StringBuffer();
		try {
			dList = ServiceFactory.getDepartmentService().getAllFuncList(new DepartmentVO(),null);
			/*///////////////  添加分级分权管理 author:xiongshun/////////////////////   */
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO pUserVO = (UserVO) session.getAttribute(UserEnum.USER_SESSION_ID);
			if(pUserVO.getOpenlevel()&&!pUserVO.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'")){
				LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
				userVO.setOpenlevel(pUserVO.getOpenlevel());
				userVO.setLvoids(lcs.queryByTypeAndLid(pUserVO.getLvoids(),LevelEnum.LEVEL_USER));
			}
			////////////////////////////////////end//////////////////////////////////////
			uList = ServiceFactory.getUserService().getUserList(userVO, null);
			sbUser.append("[");
			if(dList!=null && dList.size()>0){
				for(int i=0;i<dList.size();i++){
					dpvo = dList.get(i);
					if(dpvo.getParentId().indexOf("-")>=0 || dpvo.getParentId()==null || "".equals(dpvo.getParentId())){//只展开树的一级节点，功能优化
			        	sbUser.append("{id:'"+dpvo.getId()+"_dept',pId:'"+dpvo.getParentId()+"_dept',name:\""+dpvo.getTitle()+"\",fullName:\""+dpvo.getTitle()+"\",open:true,isParent:true},");
			         }else{
			        	sbUser.append("{id:'"+dpvo.getId()+"_dept',pId:'"+dpvo.getParentId()+"_dept',name:\""+dpvo.getTitle()+"\",fullName:\""+dpvo.getTitle()+"\",isParent:true,open:false},");
			         }
				}
				if(uList!=null && uList.size()>0){
					for(int j=0;j<uList.size();j++){
						userVO = uList.get(j);
						sbUser.append("{id:'"+userVO.getUserID()+"',pId:'"+userVO.getDepartmentVO().getId()+"_dept',name:\""+userVO.getName()+"\",fullName:\""+userVO.getName()+"\",icon:\"/icmp/plug-in/jquery-ztree-v3.5/css/img/diy/user.png\",open:false,isParent:false},");
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("获取人员信息失败！");
			return null;
		}
		String str = sbUser.substring(0, sbUser.length()-1);
		str += "];";
		logger.info("获取人员信息成功！");
		return str;
	}
	
	/**
	 * 资料管理~授权下载功能~获取参会人员信息树
	 * @return
	 */
	public String getMeetingUsers(String uploadKey){
		//该会议的参会人员
		MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
		UserVO vUserVO = new UserVO();
		List<MeetingDetailUserVO> aList = new ArrayList<MeetingDetailUserVO>();
		List<UserVO> uList = new ArrayList<UserVO>();
		
		vMeetingDetailUserVO.setMeetingDetailID(uploadKey);
		try {
			aList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(vMeetingDetailUserVO, null);
			if(aList!=null&&aList.size()>0){
				StringBuffer sbMeetingUser = new StringBuffer();
				sbMeetingUser.append("[");
				for(MeetingDetailUserVO aListTemp:aList){
					if(aListTemp.getUserID()==null||aListTemp.getUserID().length()==0||aListTemp.getUserID()=="null"){
	               	 continue;
	                }
					vUserVO.setUserID(aListTemp.getUserID());
					uList = ServiceFactory.getUserService().getUserList(vUserVO, null);
					String departID = "";
					String departName = "";
					String departPId = "";
					if(uList!=null&&uList.size()>0){
						departID = uList.get(0).getDepartmentVO().getId();
						departName = uList.get(0).getDepartmentVO().getTitle();
						departPId = uList.get(0).getDepartmentVO().getParentId();
					}
					sbMeetingUser.append("{id:'"+aListTemp.getUserID()+"',pId:'"+departID+"',name:\""+aListTemp.getUserName()+"\",fullName:\""+aListTemp.getUserName()+"\",icon:\"/icmp/plug-in/jquery-ztree-v3.5/css/img/diy/user.png\",open:false,isParent:false},");
					String departIDTemp = "{id:'"+departID;//避免所属单位重复
					if(!(sbMeetingUser.toString().contains(departIDTemp+"',"))){
						sbMeetingUser.append("{id:'"+departID+"',pId:'"+departPId+"',name:\""+departName+"\",fullName:\""+departName+"\",open:false,isParent:true},");
					}
				}
				String str = sbMeetingUser.substring(0, sbMeetingUser.length()-1);
				str += "];";
				logger.info("获取参会员工信息成功！");
				return str;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("获取参会员工信息失败！");
		return null;
	}
	
	/**
	 * 根据uploadId获取此文件的管理权限以及下载权限的人员树
	 * @param uploadId
	 * @return
	 */
	public String getUserByUploadId(String uploadId){
		UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
		uploadFileImpowerVO.setUploadId(uploadId);
		uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_DOWNLOAD);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		List<UploadFileImpowerVO> uiList = new ArrayList<UploadFileImpowerVO>();
		try {
			uiList = ServiceFactory.getUploadFileImpowerService().query(uploadFileImpowerVO, null);
			if(uiList!=null && uiList.size()>0){
				for(UploadFileImpowerVO vo:uiList){
					vo.getUserId();
					sb.append("{userId:'"+vo.getUserId()+"',status:'"+FileEnum.STATUS_IMPOWER_DOWNLOAD+"'},");
				}
			}
			uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_MANAGER);
			uiList = ServiceFactory.getUploadFileImpowerService().query(uploadFileImpowerVO,null);
			if(uiList!=null && uiList.size()>0){
				for(UploadFileImpowerVO vo:uiList){
					vo.getUserId();
					sb.append("{userId:'"+vo.getUserId()+"',status:'"+FileEnum.STATUS_IMPOWER_MANAGER+"'},");
				}
			}
			String str = sb.substring(0, sb.length()-1);
			str += "];";
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据资料类型，会议Id以及会议名称获取会议相关资料的信息树
	 * @param uploadType
	 * @param uploadKey
	 * @param meetingName
	 * @return
	 */
	public String getMeetingFileName(int uploadType,String uploadKey,String meetingName){
		UploadFileVO uploadFileVO = new UploadFileVO();
		List<UploadFileVO> uList = new ArrayList<UploadFileVO>();
		//uploadFileVO.setUploadID(uploadId);
		uploadFileVO.setUploadType(uploadType);
		uploadFileVO.setUploadKey(uploadKey);
		StringBuffer sb = new StringBuffer();
		try {
			uList = ServiceFactory.getFileuploadService().query(uploadFileVO, null);
			if(uList!=null&&uList.size()>0){
				sb.append("[");
				for(UploadFileVO uListTemp:uList){
					sb.append("{id:'"+uListTemp.getUploadID()+"',pId:'"+uploadKey+"',name:'"+uListTemp.getFileName()+"',fullName:'"+uListTemp.getFileName()+"',icon:\"/icmp/plug-in/jquery-ztree-v3.5/css/img/diy/tree_file.gif\",open:false,isParent:false},");
				}
				sb.append("{id:'"+uploadKey+"',pId:'-1',name:'"+meetingName+"',fullName:'"+meetingName+"',open:true,isParent:true}];");
				return sb.toString();
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 文件下载授权功能
	 */
	public Boolean updateFileImpower(String createUserId,String[] fileUploadIds,String[] userIDs){
		logger.info("DwrMethod	updateFileImpower	start	=====	开始资料授权");//数据库操作次数max：3+userIDs.length
		if(fileUploadIds!=null && fileUploadIds.length>0 && !"[]".equals(fileUploadIds) && createUserId!=null){//前台Array为空，这边接收为“[]”
			try {
				//第一步：先将文件下的所有非管理员权限设置为可见（即下载权限取消）
				ServiceFactory.getUploadFileImpowerService().deleteByUploadIds(fileUploadIds);
				if(userIDs !=null && userIDs.length>0 && !"[]".equals(fileUploadIds)){
					//第二步：传过来人员的集合存入userMap
					Map<String,String> userMap = new HashMap<String,String>();
					for(int i=0;i<userIDs.length;i++){
						userMap.put(userIDs[i], userIDs[i]);
					}
					//第三步：userMap剔除管理员
					for(int i=0;i< fileUploadIds.length;i++){
					UploadFileImpowerVO ufiVO = new UploadFileImpowerVO();
					ufiVO.setUploadId(fileUploadIds[i]);
					ufiVO.setStatus(FileEnum.STATUS_IMPOWER_MANAGER);
					List<UploadFileImpowerVO> ufiList = ServiceFactory.getUploadFileImpowerService().query(ufiVO, null);
					for(UploadFileImpowerVO vo:ufiList){
						if(userMap!=null&&userMap.get(vo.getUserId()+"")!=null){
							userMap.remove(vo.getUserId()+"");//传过来的人员的集合剔除掉“管理员”（//剔除管理员,防止出错）
						}
					}
					
					//第四步：原可见转为可下载权限的集合，userMap剔除可见权限的人员
					UploadFileImpowerVO ufiVO_Vis = new UploadFileImpowerVO();
					ufiVO_Vis.setUploadId(fileUploadIds[i]);
					ufiVO_Vis.setStatus(FileEnum.STATUS_IMPOWER_VISIBLE);
					List<UploadFileImpowerVO> ufiList_Vis = ServiceFactory.getUploadFileImpowerService().query(ufiVO_Vis, null);
					Map<String,String> map_Vis = new HashMap<String,String>();
					for(UploadFileImpowerVO vo:ufiList_Vis){
						if(userMap!=null&&userMap.get(vo.getUserId()+"")!=null){
							userMap.remove(vo.getUserId()+"");//传过来的人员的集合剔除掉“可见权限”，剩余的就是文件权限表没有此用户数据的集合
							map_Vis.put(vo.getUserId(), vo.getUserId());
						}
						
					}
					
					//原下载转为可见权限的集合，userMap剔除原来有下载权限的人员
					UploadFileImpowerVO ufiVO_Vis1 = new UploadFileImpowerVO();
					ufiVO_Vis1.setUploadId(fileUploadIds[i]);
					ufiVO_Vis1.setStatus(FileEnum.STATUS_IMPOWER_DOWNLOAD);
					List<UploadFileImpowerVO> ufiList_Vis1 = ServiceFactory.getUploadFileImpowerService().query(ufiVO_Vis1, null);
					Map<String,String> map_Vis1 = new HashMap<String,String>();
					boolean ifFind = false;
					for(UploadFileImpowerVO vo:ufiList_Vis1){
						ifFind = false;
						if(userMap!=null&&userMap.get(vo.getUserId()+"")!=null){
							userMap.remove(vo.getUserId()+"");//传过来的人员的集合剔除掉“可见权限”，剩余的就是文件权限表没有此用户数据的集合
							ifFind = true;
						}
						if(!ifFind){
							map_Vis1.put(vo.getUserId(), vo.getUserId());
						}
					}
					//第五步：修改文件的相关人员权限（可批量对文件授权）
					
						//bug961 由于oracle对sql中in语句有长度限制，不能多于1000个数据
						//ServiceFactory.getUploadFileImpowerService().deleteByUsers(fileUploadIds[i], users, FileEnum.STATUS_IMPOWER_MANAGER);
						//第六步：将已经拥有可见权限的人员的权限修改为“可下载权限”update
						if(map_Vis!=null&&map_Vis.size()>0){
							UploadFileImpowerVO uploadFileImpowerVO_Vis = new UploadFileImpowerVO();
							uploadFileImpowerVO_Vis.setUploadId(fileUploadIds[i]);
							uploadFileImpowerVO_Vis.setStatus(FileEnum.STATUS_IMPOWER_DOWNLOAD);
							Iterator<String> iterator_vis = map_Vis.values().iterator();//values遍历value比entryset和keyset高效20%
							while(iterator_vis.hasNext()){
								uploadFileImpowerVO_Vis.setUserId(iterator_vis.next());
								ServiceFactory.getUploadFileImpowerService().modify(uploadFileImpowerVO_Vis);
							}
						}
						//将原拥有下载权限的人员设置为可见权限
						if(map_Vis1!=null&&map_Vis1.size()>0){
							UploadFileImpowerVO uploadFileImpowerVO_Vis = new UploadFileImpowerVO();
							uploadFileImpowerVO_Vis.setUploadId(fileUploadIds[i]);
							uploadFileImpowerVO_Vis.setStatus(FileEnum.STATUS_IMPOWER_VISIBLE);
							Iterator<String> iterator_vis = map_Vis1.values().iterator();//values遍历value比entryset和keyset高效20%
							while(iterator_vis.hasNext()){
								uploadFileImpowerVO_Vis.setUserId(iterator_vis.next());
								ServiceFactory.getUploadFileImpowerService().modify(uploadFileImpowerVO_Vis);
							}
						}
						//第七步：将剩余的人员授予“可下载权限”add
						if(userMap!=null&&userMap.size()>0){
							UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
							uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_DOWNLOAD);
							uploadFileImpowerVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
							uploadFileImpowerVO.setCreateUserId(createUserId);//前台通过session传值
							uploadFileImpowerVO.setUploadId(fileUploadIds[i]);
							Iterator<String> iterator = userMap.values().iterator();//values遍历value比entryset和keyset高效20%
							while(iterator.hasNext()){
								uploadFileImpowerVO.setUserId(iterator.next());
								ServiceFactory.getUploadFileImpowerService().add(uploadFileImpowerVO);
							}
						}
					}
				}
				logger.info("DwrMethod	updateFileImpower	end	=====	资料授权成功");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("DwrMethod	updateFileImpower	failure	=====	资料授权失败");
		return false;
	}

	public boolean delFile(String filePath){
		DelFileUtil.DeleteFolder(filePath);
		return true;
	}
	
	public boolean modifyNoticeContent(String[][] infos){
		try {
		BaseInfoVO biVO = new BaseInfoVO();
		for(int i=0;i<infos.length;i++){
			biVO.setId(infos[i][0]);
			biVO.setInfoValue(infos[i][1]);
			ServiceFactory.getBaseInfoService().modify(biVO);
		}
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 查询角色是否已经被占用
	 * @param name
	 * @return true--被占用
	 */
	public boolean checkRoleName(String name ){
		ArrayList<RoleVO> listm = new ArrayList<RoleVO>();
		boolean isExit=false;
		try {
			name = name.trim();
			RoleVO roleVO = new RoleVO();
			roleVO.setRoleName(name);
			
			RoleService rs = new RoleServiceImpl();
			
			listm = rs.getRoleList(roleVO, null);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		for(int i=0;i<listm.size();i++){
			if(listm.get(i).getRoleName().equals(name)){
				isExit=true;
			}
		}
		return isExit;
//		if( listm.size() >0 ){
//			return true;
//		}else{
//			return false;
//		}
		
	}
	
	/**
	 * 摄像头详细参数设置-提取背光状态
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public String getCameraBackLightStatus(String ccIP, String cId){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraBackLightStatus(cId);
		if(resultVO.isSuccess()){
			CameraVO cVO = (CameraVO)resultVO.getObject();
			logger.info("获取背光状态信息成功");
			if(cVO.isBackLight()){
				return "ON";
			}else{
				return "OFF";
			}
		}
		return null;
	}
	
	/**
	 * 摄像头详细参数设置-提取曝光状态
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public String getCameraExposureManualStatus(String ccIP, String cId){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraExposureManualStatus(cId);
		if(resultVO.isSuccess()){
			CameraVO cVO = (CameraVO)resultVO.getObject();
			StringBuffer sb = new StringBuffer();
			if(cVO.isExposureManual()){
				sb.append("[{exposure:'ON'");
			}else{
				sb.append("[{exposure:'OFF'");
			}
			sb.append(",gain:'"+ cVO.getExposureManuaGain()+ "'");
			sb.append(",speed:'"+ cVO.getExposureManuaSpeed()+ "'");
			sb.append(",iris:'"+ cVO.getExposureManuaIris()+ "'}]");
			logger.info("获取曝光状态信息成功");
			return sb.toString();
		}
		return null;
	}
	
	/**
	 * 摄像头详细参数设置-提取白平衡状态
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public String getCameraWhiteBalanceManualStatus(String ccIP, String cId){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraWhiteBalanceManualStatus(cId);
		if(resultVO.isSuccess()){
			CameraVO cVO = (CameraVO)resultVO.getObject();
			StringBuffer sb = new StringBuffer();
			if(cVO.isWhiteBalanceManual()){
				sb.append("[{whiteBalance:'ON'");
			}else{
				sb.append("[{whiteBalance:'OFF'");
			}
			sb.append(",red:'"+ cVO.getWhiteBalanceManualR()+ "'");
			sb.append(",blue:'"+ cVO.getWhiteBalanceManualB()+ "'}]");
			logger.info("获取白平衡状态信息成功");
			return sb.toString();
		}
		return null;
	}
	
	/**
	 * 摄像头详细参数设置-背光
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraBackLight(String ccIP, String cId, Boolean flag){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraBackLight(cId, flag);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--背光操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	
	/**
	 * 摄像头详细参数设置-曝光
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraExposureManual(String ccIP, String cId, Boolean flag){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraExposureManual(cId, flag);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--曝光操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	
	/**
	 * 摄像头详细参数设置-白平衡
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraWhiteBalanceManual(String ccIP, String cId, Boolean flag){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraWhiteBalanceManual(cId, flag);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--白平衡操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	
	/**
	 * 摄像头详细参数设置-曝光-增益
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraExposureManualGain(String ccIP, String cId, int gain){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraExposureManualGain(cId, gain);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--曝光增益操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	
	/**
	 * 摄像头详细参数设置-曝光-快门
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraExposureManualSpeed(String ccIP, String cId, String speed){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraExposureManualSpeed(cId, speed);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--曝光快门操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	
	/**
	 * 摄像头详细参数设置-曝光-光圈
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraExposureManuaIris(String ccIP, String cId, String iris){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraExposureManuaIris(cId, iris);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--曝光光圈操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	
	/**
	 * 摄像头详细参数设置-白平衡-红
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraWhiteBalanceManualR(String ccIP, String cId, int red){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraWhiteBalanceManualR(cId, red);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--白平衡红操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	/**
	 * 摄像头详细参数设置-白平衡-蓝
	 * @param ccIP
	 * @param cId
	 * @return
	 */
	public Boolean cameraWhiteBalanceManualB(String ccIP, String cId, int blue){
		CenterControlObject obj = (CenterControlObject) ControlFactory
		.getCenterControlObject(ccIP);
		ExcuteResultVO resultVO = obj.cameraWhiteBalanceManualB(cId, blue);
		
		String[] infos = getMeetingRoomNameandEquimentName(ccIP,cId,CenterControlEnum.type_camera_id);
		String info = infos[0]+"("+ccIP+")"+infos[1]+"--白平衡蓝操作";
		if(resultVO.isSuccess()){
			addLog(info+"成功");
			return true;
		}
		addLog(info+"失败");
		return false;
	}
	
	
	/**
	 * 生成摄像头控制的参数模板的树结构
	 * @return
	 */
	public String cameraPreferencesBefore(String ccIP, String cId){
		EquipmentCameraVO equipmentCameraVO = new EquipmentCameraVO();
		List<EquipmentCameraVO> list = new ArrayList<EquipmentCameraVO>();
		StringBuffer sb = new StringBuffer();
		sb.append("[{id:'0',pId:'null',name:'当前参数',open:false,isParent:false},{id:'-1',pId:'null',name:'参数模板',open:true,isParent:true}");
		equipmentCameraVO.setCcIP(ccIP);
		equipmentCameraVO.setCameraId(cId);
		try {
			list = ServiceFactory.getEquipmentCameraService().query(equipmentCameraVO, null);
			if(list!=null && list.size()>0){
				for(EquipmentCameraVO listTemp:list){
					sb.append(",{id:'"+listTemp.getTemplateID()+"',pId:'-1',name:'"+listTemp.getTemplateName()+"',open:false,isParent:false}");
				}
			}
			sb.append("]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("进入摄像头参数控制页面...");
		return sb.toString();
	}

	/**
	 * 点击摄像头的参数模板，获取该模板的相关信息，以json格式传入前台
	 * @param templateID
	 * @return
	 */
	public String queryCameraTemplate(String templateID){
		EquipmentCameraVO equipmentCameraVO = new EquipmentCameraVO();
		StringBuffer sb = new StringBuffer();
		try {
			equipmentCameraVO = ServiceFactory.getEquipmentCameraService().queryByID(templateID);
			if(equipmentCameraVO!=null){
				sb.append("[{templateID:'"+ equipmentCameraVO.getTemplateID()+ "'");
				sb.append(",templateName:'"+ equipmentCameraVO.getTemplateName()+ "'");
				sb.append(",cameraId:'"+ equipmentCameraVO.getCameraId()+ "'");
				sb.append(",backlight:'"+ equipmentCameraVO.getBacklight()+ "'");
				sb.append(",exposure:'"+ equipmentCameraVO.getExposure()+ "'");
				sb.append(",gain:'"+ equipmentCameraVO.getGain()+ "'");
				sb.append(",speed:'"+ equipmentCameraVO.getSpeed()+ "'");
				sb.append(",iris:'"+ equipmentCameraVO.getIris()+ "'");
				sb.append(",whiteBalance:'"+ equipmentCameraVO.getWhiteBalance()+ "'");
				sb.append(",red:'"+ equipmentCameraVO.getRed()+ "'");
				sb.append(",blue:'"+ equipmentCameraVO.getBlue()+ "'");
				sb.append(",createTime:'"+ equipmentCameraVO.getCreateTime()+ "'");
				sb.append(",createUserId:'"+ equipmentCameraVO.getCreateUserId()+ "'");
				sb.append(",status:'"+ equipmentCameraVO.getStatus()+ "'");
				sb.append(",description:'"+ equipmentCameraVO.getDescription()+ "'}]");
				logger.info("模板提取成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	/**
	 * 修改摄像头控制的参数模板的名称
	 * @param templateID
	 * @param templateName
	 * @return
	 */
	public Boolean updateCameraPreferences(String templateID, String templateName){
		EquipmentCameraVO equipmentCameraVO = new EquipmentCameraVO();
		equipmentCameraVO.setTemplateID(templateID);
		equipmentCameraVO.setTemplateName(templateName.trim());
		try {
			ServiceFactory.getEquipmentCameraService().modify(equipmentCameraVO);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("模板名称修改失败");
			return false;
		}
		logger.info("模板名称修改成功");
		return true;
	}
	
	/**
	 * 删除摄像头控制的参数模板
	 * @param templateID
	 * @return
	 */
	public Boolean delCameraPreferences(String templateID){
		try {
			ServiceFactory.getEquipmentCameraService().deleteByID(templateID);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("模板删除失败");
			return false;
		}
		logger.info("模板删除成功");
		return true;
	}
	
	/**
	 * 保存摄像头控制的参数模板
	 * baseinfos:ccIP,cameraId,templateID,templateName
	 * paras:backlight,exposure,gain,speed,iris,whiteBalance,red,blue
	 * @param templateID
	 * @return
	 */
	public String saveCameraTemplate(String baseinfos,String preferences){
		EquipmentCameraVO equipmentCameraVO = new EquipmentCameraVO();
		try {
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			
			equipmentCameraVO.setCreateUserId(userVO.getUserID());
			
			String infoTemp = baseinfos.replaceAll(",,", ",NONE,");//防止为空时切割没了
			String[] info = infoTemp.split(",");
			equipmentCameraVO.setCcIP(info[0]);
			equipmentCameraVO.setCameraId(info[1]);
			equipmentCameraVO.setTemplateID(info[2]);
			if("NONE".equals(info[3])){
				equipmentCameraVO.setTemplateName(null);
			}else{
				equipmentCameraVO.setTemplateName(info[3]);
			}
			String[] preference = preferences.split(",");
			equipmentCameraVO.setBacklight(preference[0]);
			equipmentCameraVO.setExposure(preference[1]);
			equipmentCameraVO.setGain(preference[2]);
			equipmentCameraVO.setSpeed(preference[3]);
			equipmentCameraVO.setIris(preference[4]);
			equipmentCameraVO.setWhiteBalance(preference[5]);
			equipmentCameraVO.setRed(preference[6]);
			equipmentCameraVO.setBlue(preference[7]);
			
			String templateID =  equipmentCameraVO.getTemplateID();
			if("NONE".equals(templateID)){//新增模板
				equipmentCameraVO.setTemplateID(UtilDAO.getUUid());
				equipmentCameraVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
				ServiceFactory.getEquipmentCameraService().add(equipmentCameraVO);
			}else{
				equipmentCameraVO.setTemplateName(null);//修改模板，但是不修改名字
				equipmentCameraVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				ServiceFactory.getEquipmentCameraService().modify(equipmentCameraVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("模板保存失败");
			return null;
		}
		logger.info("模板保存成功");
		return equipmentCameraVO.getTemplateID();
	}
	/**
	 * 获取岗位信息树
	 * @return
	 */
	public String getPostList(){
		PostVO postVO = new PostVO();
		List<PostVO> poList = new ArrayList<PostVO>();
		StringBuffer sb = new StringBuffer();
		try {
			poList = ServiceFactory.getPostService().query(postVO, null);
			//构造岗位树数据 
		    if(null!= poList&& poList.size()>0){
		    	sb.append("[");
			    for(int i=0;i<poList.size();i++){
			    	postVO = poList.get(i);
			    	if(i < (poList.size()-1)){
			    		sb.append("{id:'"+postVO.getPostNO()+"',pId:'"+postVO.getParentNO()+"',name:\""+postVO.getPostName()+"\",icon:\"/icmp/plug-in/jquery-ztree-v3.5/css/img/diy/postIco.png\",open:false,isParent:false},");
			    	}else{
			    		sb.append("{id:'"+postVO.getPostNO()+"',pId:'"+postVO.getParentNO()+"',name:\""+postVO.getPostName()+"\",icon:\"/icmp/plug-in/jquery-ztree-v3.5/css/img/diy/postIco.png\",open:false,isParent:false}");
			    	}
		        }
			    sb.append("]");
			}else{
				logger.info("获取岗位信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("获取岗位信息成功！");
		return sb.toString();
	}
	
	/**
	 * 删除流程下的所有节点
	 * @param flowID
	 * @return
	 */
	public Boolean delFlownode(String flowID){
		ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
		applyFlownodeVO.setFlowID(flowID);
		try {
			ServiceFactory.getApplyFlownodeService().deleteByFlowID(applyFlownodeVO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 添加流程节点
	 * @return
	 */
	public String addFlownode(int orderNum,String flowID,String userID,String flownodeName,String checkType,String checkRule){
		ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
		applyFlownodeVO.setFlowID(flowID);
		applyFlownodeVO.setFlownodeName(flownodeName);
		applyFlownodeVO.setOrderNum(orderNum);
		applyFlownodeVO.setCheckRule(checkRule);
		if("person".equals(checkType)){
			applyFlownodeVO.setCheckType(ApplyEnum.CHECKTYPE_PERSON);
			applyFlownodeVO.setUserID(userID);
		}else if("post".equals(checkType)){
			applyFlownodeVO.setCheckType(ApplyEnum.CHECKTYPE_POST);
			applyFlownodeVO.setPostNO(userID);
		}
		try {
			ServiceFactory.getApplyFlownodeService().add(applyFlownodeVO);
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}
	
	/**
	 * 获取流程下的所有节点
	 * @param flowID
	 * @return
	 */
	public String getFlownode(String flowID){
		logger.info("DwrMethod getFlownode begin");
		ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
		ApplyFlowVO applyFlowVO = new ApplyFlowVO();
		List<ApplyFlownodeVO> afnList = new ArrayList<ApplyFlownodeVO>();
		//applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
		applyFlownodeVO.setApplyFlowVO(applyFlowVO);
		applyFlownodeVO.setFlowID(flowID);
		try {
			afnList = ServiceFactory.getApplyFlownodeService().queryWithOthTab(applyFlownodeVO, null);
			if(afnList!=null && afnList.size()>0){
				StringBuffer sb = new StringBuffer();
				sb.append("[");
				for(ApplyFlownodeVO vo:afnList){
					sb.append("{flownodeID:'"+vo.getFlownodeID()+"',");
					sb.append("flownodeName:'"+vo.getFlownodeName()+"',");
					sb.append("orderNum:'"+vo.getOrderNum()+"',");
					sb.append("userID:'"+vo.getUserID()+"',");
					sb.append("postNO:'"+vo.getPostNO()+"',");
					sb.append("checkType:'"+vo.getCheckType()+"',");
					sb.append("checkRule:'"+vo.getCheckRule()+"'},");
				}
				String str = sb.toString();
				str = str.substring(0, str.length()-1);
				str += "]";
				logger.info("流程节点获取成功");
				return str;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 校验流程，根据申请表类型
	 * @return
	 */
	public String checkFlow(int flowType,int security,String departmentID){
		logger.info("DwrMethod checkFlow begin");
		ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
		ApplyFlowVO applyFlowVO = new ApplyFlowVO();
		List<ApplyFlownodeVO> afnList = new ArrayList<ApplyFlownodeVO>();
		List<ApplyFlowVO> afList = new ArrayList<ApplyFlowVO>();
		applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
		applyFlowVO.setFlowType(flowType);
		applyFlownodeVO.setApplyFlowVO(applyFlowVO);
		try {
			afList = ServiceFactory.getApplyFlowService().query(applyFlowVO, null);
			if(afList!=null&&afList.size()>0){
				applyFlownodeVO.setFlowID(afList.get(0).getFlowID());//防止一个表有多个流程
				afnList = ServiceFactory.getApplyFlownodeService().queryWithOthTab(applyFlownodeVO, null);
				if(afnList!=null&&afnList.size()>0){
					UserVO userVO = new UserVO();
					List<UserVO> uList = new ArrayList<UserVO>();
					for(ApplyFlownodeVO vo:afnList){
						if(security==ApplyEnum.SECURITY_LEVEL1){//如果不涉密则可跳过
							if(vo.getCheckRule().contains(ApplyEnum.CHECKRULE_SECRET)){
								continue;
							}
						}
						if(ApplyEnum.CHECKTYPE_POST == vo.getCheckType()){//该部门的该岗位下是否存在人员
							String checkUserIDs = "";
							if(vo.getCheckRule().contains(ApplyEnum.CHECKRULE_SECRET)){//涉密岗位
								checkUserIDs = ApplyDetailUtil.getBroDeptId(departmentID, vo.getPostNO());
							}else{
								checkUserIDs = ApplyDetailUtil.getCheckUsersByPost(departmentID, vo.getPostNO());//其他岗位
							}
							if(checkUserIDs==null || checkUserIDs.length()==0){
								String str = "该单位下没有注册相关人员在此岗位：";
								str += ServiceFactory.getPostService().queryByID(vo.getPostNO()).getPostName();
								return str;
							}
						}
					}
					return "ok";
				}else{
					return "没有相关启用的流程，请联系运维人员！";
				}
			}else{
				return "没有相关启用的流程，请联系运维人员！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "出错了";
		}
	}
	
	/**
	 * 查看流程节点
	 * @param applyID
	 * @return
	 */
	public String seeFlow(String applyID){
		logger.info("DwrMethod seeFlow begin");
		ApplyDetailVO adVO = new ApplyDetailVO();
		UserVO userVO = new UserVO();
		List<ApplyDetailVO> adList = new ArrayList<ApplyDetailVO>();
		adVO.setApplyDetailID(applyID);
		try {
			adList = ServiceFactory.getApplyDetailService().query(adVO, null);
			if(adList!=null && adList.size()>0){
				String flownodeName;
				int checkType;
				StringBuffer sb = new StringBuffer();
				sb.append("[");
				if(adList.get(0).getOrderNum()!=Integer.MIN_VALUE){
					for(ApplyDetailVO vo:adList){
						if(vo.getOrderNum()==ApplyEnum.ORDERNUM_START){
							userVO.setUserID(vo.getUserID());
							flownodeName = ServiceFactory.getUserService().getUserList(userVO, null).get(0).getName()+"<br/>（开始）";
							checkType = ApplyEnum.CHECKTYPE_PERSON;
						}else{
							flownodeName = vo.getFlownodeName();
							checkType = vo.getCheckType();
							if(vo.getStatus()==ApplyEnum.STATUS_REJECT){
								flownodeName += "<br/>（已结束：不同意）";
							}
						}
						sb.append("{flownodeName:'"+flownodeName+"',");
//						sb.append("applyDetailID:'"+vo.getApplyDetailID()+"',");
//						sb.append("flownodeID:'"+vo.getFlownodeID()+"',");
						sb.append("suggestion:'"+vo.getSuggestion()+"',");//申请人的suggestion为流程的描述信息，审批人为审批意见
						sb.append("orderNum:'"+vo.getOrderNum()+"',");
						sb.append("userID:'"+vo.getUserID()+"',");
						sb.append("checkUserIDs:'"+vo.getCheckUserIDs()+"',");
						sb.append("status:'"+vo.getStatus()+"',");
						sb.append("checkType:'"+checkType+"'},");
					}
				}else{//推送过来的审批信息不包含orderNum
					for(int m=0;m<adList.size();m++){
						if(m==0){
							userVO.setUserID(adList.get(m).getUserID());
							flownodeName = adList.get(m).getFlownodeName()+"<br/>（开始）";
							checkType = ApplyEnum.CHECKTYPE_PERSON;
						}else{
							flownodeName = adList.get(m).getFlownodeName();
							checkType = adList.get(m).getCheckType();
							if(adList.get(m).getStatus()==ApplyEnum.STATUS_REJECT){
								flownodeName += "<br/>（已结束：不同意）";
							}
						}
						sb.append("{flownodeName:'"+flownodeName+"',");
						sb.append("suggestion:'"+adList.get(m).getSuggestion()+"',");//申请人的suggestion为流程的描述信息，审批人为审批意见
						sb.append("orderNum:'"+adList.get(m).getOrderNum()+"',");
						sb.append("userID:'"+adList.get(m).getUserID()+"',");
						sb.append("checkUserIDs:'"+adList.get(m).getCheckUserIDs()+"',");
						sb.append("status:'"+adList.get(m).getStatus()+"',");
						sb.append("checkType:'"+checkType+"'},");
					}
				}
				
				String str = sb.toString();
				str = str.substring(0, str.length()-1);
				str += "]";
				logger.info("流程节点提取成功");
				return str;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据用户IDs获取用户的名字
	 * @param userID
	 * @return
	 */
	public String getUserNameByID(String userIDs){
		try {
			UserVO userVO = new UserVO();
			String[] uIDs = userIDs.split(",");
			String userName = ""; 
			for(int i=0;i<uIDs.length;i++){
				if(!"".equals(uIDs[i])){
					userVO.setUserID(uIDs[i]);
					userName += ServiceFactory.getUserService().getUserList(userVO, null).get(0).getName();
					userName += ",";
				}
			}
			return userName.substring(0,userName.length()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 会议视频资料与会议关联
	 * @param meetingDetailID
	 * @param fileUrls
	 * @param fileNames
	 */
	
	public void videoRelation(String meetingDetailID,String[] fileUrls,String[] fileNames){
			WebContext webcontext  = WebContextFactory.get();
			HttpSession session = webcontext.getSession();
			UserVO user = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		try {
			String fileUrl = "ftp://zzst:zzst@localhost";
			UploadFileVO uploadFileVO1 = new UploadFileVO();
			
			uploadFileVO1.setUploadKey(meetingDetailID);
			uploadFileVO1.setUploadType(FileEnum.MEETING_RECORD_FILE);
			ServiceFactory.getFileuploadService().deleteByMeeting(uploadFileVO1);
			MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
			List<MeetingDetailUserVO> aList = new ArrayList<MeetingDetailUserVO>();
			vMeetingDetailUserVO.setMeetingDetailID(meetingDetailID);
			aList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(vMeetingDetailUserVO, null);
			
			UploadFileImpowerVO uploadFileImpowerVO = new UploadFileImpowerVO();
			uploadFileImpowerVO.setCreateUserId(user.getUserID());//文件上传者的UserId
			uploadFileImpowerVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			//获取超级管理员的userId
			UserVO vUserVO = new UserVO();
			vUserVO.setLoginName(UserEnum.SUPER_ADMIN);
			String superAdminID = ServiceFactory.getUserService().getUserList(vUserVO, null).get(0).getUserID();
			for(int i=0;i<fileUrls.length;i++){
			UploadFileVO uploadFileVO = new UploadFileVO();
			uploadFileVO.setUploadKey(meetingDetailID);
			uploadFileVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			uploadFileVO.setUploadType(FileEnum.MEETING_RECORD_FILE);
			uploadFileVO.setFileName(fileNames[i]);
			uploadFileVO.setFileUrl(fileUrls[i]);
			String[] filetype = fileNames[i].split("\\.");
			uploadFileVO.setFileType(filetype[filetype.length-1]);
			uploadFileVO.setStatus(FileEnum.STATUS_VALID);
			uploadFileVO.setCreateUserID(user.getUserID());
			uploadFileVO.setUploadID(UtilDAO.getUUid());
			ServiceFactory.getFileuploadService().add(false,uploadFileVO);
			
			uploadFileImpowerVO.setUploadId(uploadFileVO.getUploadID());
			uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_MANAGER);
			if(!uploadFileVO.getCreateUserID().equals(superAdminID)){//超级管理员有所有权限
				uploadFileImpowerVO.setUserId(superAdminID);
				ServiceFactory.getUploadFileImpowerService().add(uploadFileImpowerVO);
			}
			uploadFileImpowerVO.setUserId(uploadFileVO.getCreateUserID());
			ServiceFactory.getUploadFileImpowerService().add(uploadFileImpowerVO);
			if(aList!=null&&aList.size()>0){
				for(MeetingDetailUserVO mVO:aList){
					if(!mVO.getUserID().equals(uploadFileVO.getCreateUserID())){
						uploadFileImpowerVO.setStatus(FileEnum.STATUS_IMPOWER_VISIBLE);
						uploadFileImpowerVO.setUserId(mVO.getUserID());
						ServiceFactory.getUploadFileImpowerService().add(uploadFileImpowerVO);
					}
				}
			}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 检查当前申请表单中的当前时间段是否有会场被占用 add 20130805
	 * @param meetingRoomNameIDs//确认会议室名称不能重复
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public String checkBusyMeetingRooms(String applyID, String meetingRoomNameIDs,
			String startTime, String endTime) {
		logger.info("DwrMethod checkBusyMeetingRooms begin");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ArrayList<ApplyConferenceVO> acList = new ArrayList<ApplyConferenceVO>();
		try {
			Date startTimeDate = format.parse(startTime);
			Date endTimeDate = format.parse(endTime);
			ApplyConferenceVO applyConferenceVO = new ApplyConferenceVO();
			applyConferenceVO.setStartTime(new Timestamp(startTimeDate
					.getTime()));
			applyConferenceVO.setEndTime(new Timestamp(endTimeDate
					.getTime()));
			acList = ServiceFactory.getApplyConferenceService().queryBusyMeetingRoom(applyConferenceVO, null);
			if(acList==null || acList.size()==0){
				return null;
			}else{
				String busyMeetingRoomNames = "";
				Boolean flag = false;//是否有占用资源信息的标识
				for(ApplyConferenceVO acVO:acList){
					if(acVO.getApplyID().equals(applyID)){//修改申请表单时过滤这条申请表单信息
						continue;
					}
					String conferenceIDs	= acVO.getVenueConferenceIDs();
					String conferenceNames	= acVO.getVenueConference();
					if(conferenceIDs.indexOf(acVO.getMainConferenceID())<0){
						conferenceIDs += ","+acVO.getMainConferenceID();
					}
					if(conferenceNames.indexOf(acVO.getMainConference())<0){
						conferenceNames += ","+acVO.getMainConference();
					}
					String[] conferenceID	= conferenceIDs.split(",");
					String[] conferenceName	= conferenceNames.split(",");
					String info = "";
					if(conferenceID!=null && conferenceID.length>0){
						Boolean flag1 = false;//该会议是否有占用信息的标识
						info = "会议名称:"+acVO.getConferenceName()+";申请人:"+acVO.getLinkManName()+";申请时间:"+acVO.getCreateTime()+";联系方式:"+acVO.getLinkManCellPhone()+";占用的会议室有:";
						for(int j=0;j<conferenceID.length;j++){
							if(meetingRoomNameIDs.indexOf(conferenceID[j])>=0&&conferenceID[j]!=null&&!"".equals(conferenceID[j])){
								flag = true;
								flag1 = true;
								//meetingRoomNameIDs = meetingRoomNameIDs.substring(0,meetingRoomNameIDs.indexOf(conferenceID[j]))+meetingRoomNameIDs.substring(meetingRoomNameIDs.indexOf(conferenceID[j])+conferenceID[j].length()+1);
								info += conferenceName[j];
								info += ",";
							}
						}
						if(flag1){
							busyMeetingRoomNames += info;
						}
					}
					busyMeetingRoomNames += "\n";
				}
				if(flag){
					return busyMeetingRoomNames;
				}else{
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("DwrMethod	checkMeetingRooms	error:	"+e.getMessage());
		}
		return null;
	}

	/**
	 * 控制菜单可配置
	 * @param str
	 * @return
	 */
	public Boolean saveControlMenuConfig(String str){
		logger.info("DwrMethod saveControlMenuConfig	 begin");
		Boolean flag = false;
		try{
			DictionaryVO dictionaryVO = new DictionaryVO();
			dictionaryVO.setDicType(DictionaryEnum.CONTROLMENU);
			DictionaryService dictionaryService = ServiceFactory.getDictionaryService();
			flag = dictionaryService.deleteByVO(dictionaryVO);
			if(str!=null&&!"".equals(str)){
				if(flag){
					String[] groups = str.split(";");
					int startIndex = DictionaryEnum.CONTROLMENUGROUP_FIRST;
					for(int i=startIndex;i<groups.length+startIndex;i++){
						String groupName = groups[i-startIndex].substring(0,groups[i-startIndex].indexOf(","));
						String[] controlMenus = groups[i-startIndex].substring(groups[i-startIndex].indexOf(",")+1).split("&");
						dictionaryVO.setSysValue(i);
						dictionaryVO.setDescription(groupName);
						for(int j=0;j<controlMenus.length;j++){
							String[] strs = controlMenus[j].split(",");
							dictionaryVO.setDicValue(strs[0]);
							dictionaryVO.setDicViewName(strs[1]);
							dictionaryService.add(dictionaryVO);
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			flag = false;
			logger.error("DwrMethod	saveControlMenuConfig	error:	"+e.getMessage());
		}
		logger.info("DwrMethod saveControlMenuConfig	 end");
		return flag;
	}
	
	/**
	 * 判断岗位编号是否已经存在（唯一性）20130909
	 * @param postNo
	 * @return
	 */
	public Boolean checkPostNo(String postNo){
		try {
			PostVO postVO = new PostVO();
			postVO.setPostNO(postNo);
			ArrayList<PostVO> list = ServiceFactory.getPostService().query(postVO, null);
			if(list!=null&&list.size()>0){
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 判断岗位名称是否唯一 add by liujf 20140103
	 * @param postName
	 * @return
	 */
	public ArrayList checkPostName(String postName) {
		PostVO postVO = new PostVO();
		ArrayList check = null;
		try {
			PostService service = new PostServiceImpl();
			postVO.setPostName(postName);
			check = service.query(postVO, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	/**
	 * 右键菜单可配置
	 * @author zhangjy
	 * @date 2013-10-18
	 * 
	 */
	public Boolean saveControlRightMenuConfig(String str){
		
		DictionaryVO dictionaryVO = new DictionaryVO();
		dictionaryVO.setDicType(DictionaryEnum.CONTROLRightMENU);
		DictionaryService ds = ServiceFactory.getDictionaryService();
		if(str!=null&&!str.equals("")){
			//List<String> list = Arrays.asList(str.split(",")); 
				try {
					String[] controlMenus = str.split(",");
					ds.deleteByVO(dictionaryVO);
					dictionaryVO.setDescription("checked");
					for(String s:controlMenus){
						if(!"".equals(s)){
							dictionaryVO.setDicValue(s);
							ds.add(dictionaryVO);
						}
					}
					/**
					List<DictionaryVO> dvlist=ds.query(dictionaryVO, null);
					for(DictionaryVO dv:dvlist){
						if(list.contains(dv.getDicValue())){
							dv.setDescription("checked");
						}else{
							dv.setDescription("noChecked");	
						}
						ds.modify(dv);
						
					}
					*/
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}
	/**
	 * 
	 * 配置appConfig.xml
	 * @param object String[]
	 * @return
	 */
	public boolean modifyConfiguration(String[] object){
		logger.info("DwrMethod modifyConfiguration begin");
		Map<String,String> config = new HashMap<String,String>();
		for(int i=0;i<object.length;i++){
			if(object[i].split("__").length<2){
				continue;
			}
			config.put(object[i].split("__")[0], object[i].split("__")[1]);
		}
		
		Eryptogram etg = new Eryptogram();
		//config.put("ftpUser", etg.encryptData(config.get("ftpUser")));
		//config.put("ftpPsw", etg.encryptData(config.get("ftpPsw")));
		//config.put("DB_USER", etg.encryptData(config.get("DB_USER")));
		//config.put("DB_PASSWD", etg.encryptData(config.get("DB_PASSWD")));
		//config.put("pwdInit", etg.encryptData(config.get("pwdInit")));
		
		SAXReader reader = new SAXReader();
	    Class runClass;
		try {
			runClass = Class.forName("com.zzst.meeting.dwr.DwrMethod");
			Document p_document = reader.read(runClass.getResourceAsStream("/appConfig.xml"));
			List<Element> initparams = p_document.selectNodes("root/init-param");
			
			for(int i=0;i<initparams.size();i++){
				Element node = (Element)initparams.get(i);
				if(config.get(node.attributeValue("key"))!=null){
					//如果ftpUser的value发生改变则加密
					if(node.attributeValue("key").equals("ftpUser")&&!config.get(node.attributeValue("key")).equals(node.attributeValue("value"))){
						node.attribute("value").setValue(etg.encryptData(config.get(node.attributeValue("key"))));
					}else if(node.attributeValue("key").equals("ftpPsw")&&!config.get(node.attributeValue("key")).equals(node.attributeValue("value"))){
						node.attribute("value").setValue(etg.encryptData(config.get(node.attributeValue("key"))));
					}else if(node.attributeValue("key").equals("pwdInit")&&!config.get(node.attributeValue("key")).equals(node.attributeValue("value"))){
						node.attribute("value").setValue(etg.encryptData(config.get(node.attributeValue("key"))));
					}else if(node.attributeValue("key").equals("pwdInitAdmin")&&!config.get(node.attributeValue("key")).equals(node.attributeValue("value"))){
						node.attribute("value").setValue(etg.encryptData(config.get(node.attributeValue("key"))));
					}else{
						//不需加密数据
						node.attribute("value").setValue(config.get(node.attributeValue("key")));
					}
				}
				
			}
			
			List<Element> db_initparams = p_document.selectNodes("root/datasources/datasource");
			for(int i=0;i<db_initparams.size();i++){
 				Element node = (Element)db_initparams.get(i);
 				if(config.get("DB_URL")!=null){
 					node.element("DB_URL").setText(config.get("DB_URL"));
 				}
 				if(config.get("DB_USER")!=null&&!config.get("DB_USER").equals(node.elementText("DB_USER"))){
 					node.element("DB_USER").setText(etg.encryptData(config.get("DB_USER")));
 				}else{
 					node.element("DB_USER").setText(config.get("DB_USER"));
 				}
 				if(config.get("DB_PASSWD")!=null&&!config.get("DB_PASSWD").equals(node.elementText("DB_PASSWD"))){
 					node.element("DB_PASSWD").setText(etg.encryptData(config.get("DB_PASSWD")));
 				}else{
 					node.element("DB_PASSWD").setText(config.get("DB_PASSWD"));
 				}
 				if(config.get("DB_JNDI")!=null){
 					node.element("DB_JNDI").setText(config.get("DB_JNDI"));
 				}
				
			}
			
			List<Element> db_initparamsBAK = p_document.selectNodes("root/datasources/datasourceBAK");
			for(int i=0;i<db_initparamsBAK.size();i++){
 				Element node = (Element)db_initparamsBAK.get(i);
 				if(config.get("BAK_DB_URL")!=null){
 					node.element("BAK_DB_URL").setText(config.get("BAK_DB_URL"));
 				}
 				if(config.get("BAK_DB_USER")!=null&&!config.get("BAK_DB_USER").equals(node.elementText("BAK_DB_USER"))){
 					node.element("BAK_DB_USER").setText(etg.encryptData(config.get("BAK_DB_USER")));
 				}else{
 					node.element("BAK_DB_USER").setText(config.get("BAK_DB_USER"));
 				}
 				if(config.get("BAK_DB_PASSWD")!=null&&!config.get("BAK_DB_PASSWD").equals(node.elementText("BAK_DB_PASSWD"))){
 					node.element("BAK_DB_PASSWD").setText(etg.encryptData(config.get("BAK_DB_PASSWD")));
 				}else{
 					node.element("BAK_DB_PASSWD").setText(config.get("BAK_DB_PASSWD"));
 				}
 				if(config.get("BAK_DB_JNDI")!=null){
 					node.element("BAK_DB_JNDI").setText(config.get("BAK_DB_JNDI"));
 				}
 				
 				if(config.get("BAK_IS_OPEN")!=null){
 					node.element("BAK_IS_OPEN").setText(config.get("BAK_IS_OPEN"));
 				}
				
			}
			
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("GBK");
			XMLWriter writer = new XMLWriter(new FileWriter(runClass.getResource("/appConfig.xml").getPath()),format);
			writer.write(p_document);
			writer.close();
		} catch (ClassNotFoundException e) {
			logger.error("DwrMethod modifyConfiguration error:ClassNotFoundException");
			e.printStackTrace();
			return false;
		} catch (DocumentException e) {
			logger.error("DwrMethod modifyConfiguration error:DocumentException");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			logger.error("DwrMethod modifyConfiguration error:IOException");
			e.printStackTrace();
			return false;
		}
		logger.info("DwrMethod modifyConfiguration begin");
		return true;
	}
	
	
	public String updateAuthorization(String roleId,String[] userIds,String[] userNames){
		UserVO user = new UserVO();
		UserRoleVO urVO = new UserRoleVO();
		ArrayList<UserRoleVO> oldurList = new ArrayList<UserRoleVO>();
		ArrayList<UserRoleVO> delurList = new ArrayList<UserRoleVO>();
		ArrayList<UserRoleVO> newurList = new ArrayList<UserRoleVO>();
		TransactionManager tm = null;
		try {
			
			for(int i=0;i<userIds.length;i++){
				UserRoleVO role = new UserRoleVO();
				role.setRoleID(roleId);
				role.setUserID(userIds[i]);
				newurList.add(role);
			}
		UserRoleVO role1 = new UserRoleVO();
		role1.setRoleID(roleId);
		oldurList = ServiceFactory.getUserRoleService().getUserRoleList(role1, null);
		
		for(int i =0;i<oldurList.size();i++){
			for(int j=0;j<newurList.size();j++){
				if(oldurList.get(i).getUserID().equals(newurList.get(j).getUserID())){
					oldurList.remove(i);
					i--;
					newurList.remove(j);
					j--;
					break;
				}
			}
		}
		tm = new TransactionManager();
		ServiceFactory.getUserRoleService().addUserRole(newurList, tm);
		for(int i=0;i<oldurList.size();i++){
		ServiceFactory.getUserRoleService().delUserRole(oldurList.get(i), tm);
		}
		
	    ////////////////author:zhangjy/////////////
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session = ctx.getHttpServletRequest().getSession(); 
		UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		
		RoleVO roleVO=new RoleVO();
		roleVO.setRoleID(roleId);
		RoleService roleService = new RoleServiceImpl();
		List<RoleVO> roleVOList = roleService.getRoleList(roleVO, null);
		if(roleVOList != null && roleVOList.size() > 0){
			roleVO = roleVOList.get(0);
		}
		LogUtil.addLogForOperate("重新为 "+roleVO.getRoleName()+" 分配人员", userVO.getUserID(), "", LogEnum.TYPE_DB, 1);
		for(String userName:userNames){
		LogUtil.addLogForOperate("为"+roleVO.getRoleName()+"添加人员:"+userName, userVO.getUserID(), "", LogEnum.TYPE_DB, 1);
		}
		} catch (SQLException e) {
			tm.rollback();
			e.printStackTrace();
			return "failure";
		}
		return "success";
	}
/**
 * @author:zhangjy 2014-01-15
 * @param meetid
 * @param roomid
 * @param manNum
 * @param cont
 * @param logInfo
 * @return
 */
	public String upadateMeetDetailRoom(String meetid,String roomid,String manNum,String description){
		
		TransactionManager tm;
		try {
			tm = new TransactionManager();
		MeetingDetailRoomVO vdmv=new MeetingDetailRoomVO();
		vdmv.setMeetingDetailId(meetid);
		vdmv.setMeetingRoomId(roomid);
		List<MeetingDetailRoomVO> vdmvList=ServiceFactory.getMeetingDetailRoomService().getMeetingDetailRoomList(vdmv, null);
		vdmv=vdmvList.get(0);
		vdmv.setDescription(description);
		vdmv.setManNum(manNum);
		
		MeetingDetailRoomVO tmdv=new MeetingDetailRoomVO();
		tmdv.setMeetingDetailId(vdmv.getMeetingDetailId());
	
        ////////////////log/////////////
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session = ctx.getHttpServletRequest().getSession(); 
		UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
		LogUtil.addLogForOperate("确认参会信息:"+vdmv.getMeetingDetailName()+"-"+vdmv.getMeetingRoomName(), userVO.getUserID(), "", LogEnum.TYPE_DB, 1);
		////////////////////////////////////////////
		ServiceFactory.getMeetingDetailRoomService().modifyMeetingDetailRoom(vdmv, tm);
		
		int count=0;
		List<MeetingDetailRoomVO> mrvlist=ServiceFactory.getMeetingDetailRoomService().getMeetingDetailRoomList(tmdv, null);
		for(MeetingDetailRoomVO m:mrvlist){
			try {
				if(m.getManNum()!=null&&!(m.getManNum().equals(""))){
				count+=Integer.parseInt(m.getManNum());
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
		}
		MeetingDetailVO vMeetingDetailVO=new MeetingDetailVO();
		vMeetingDetailVO.setMeetingDetailID(vdmv.getMeetingDetailId());
		vMeetingDetailVO.setInfo2(""+count);
		ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForInfo2(vMeetingDetailVO);
		
		} catch (DBConnectionException e) {
			return "fail";
			
		} catch (SQLException e) {
			
			return "fail";
		}

		return "success";
	}
	
	
	
	/**
	 * 检查会议室此类型设备是够已经存在
	 * @param meetingRoomID
	 * @param equipmentType设备类型
	 * @return
	 */
	public String checkRoomIsOnly(String meetingRoomID,int equipmentType){
		logger.info("DwrMethod checkRoomIsOnly begin");
		String returnInfo = "";
		List<EquipmentVO> eList = new ArrayList<EquipmentVO>();
		EquipmentVO equipmentVO = new EquipmentVO();
		MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
		meetingRoomVO.setMeetingRoomID(meetingRoomID);
		equipmentVO.setMeetingRoomVO(meetingRoomVO);
		equipmentVO.setEquipmentType(equipmentType);
		try {
			eList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
			if(eList!=null&&eList.size()>0){
				returnInfo = eList.get(0).getEquipmentNO();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("DwrMethod checkRoomIsOnly begin");
		return returnInfo;
	}
	/**
	 * 根据parentId 查询厂家下的设备型号信息。
	 * @param dicID
	 * @return
	 */
	public String getDicNameByDicID(String dicID){
		StringBuffer html = new StringBuffer();
		try{
			DictionaryEquipmentVO dicEquipmentVO = new DictionaryEquipmentVO();
			dicEquipmentVO.setParentID(dicID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(dicEquipmentVO, null);
			for( DictionaryEquipmentVO devo : deList ){
				html.append("<option value='" + devo.getDicID() +"'");
				html.append(">" + devo.getDicName() + "</option>");
			}
		}catch( Exception e ){
			e.printStackTrace();
			return null;
		}
		return html.toString();
	}
	
	/**
	 * 根据时间段查询使用的设备列表
	 * @param startT
	 * @param endT
	 * @return
	 * @throws Exception
	 */
	public String[]	getUseEquipmentByTime(String startT,String endT) {
		String[] s =null;
		try{
			ArrayList<MeetingDetailEquipmentVO> list = new MeetingDetailEquipmentServiceImpl().queryUseEquipmentList(new Timestamp(Long.valueOf(startT)),new Timestamp(Long.valueOf(endT)),null);
			if(list!=null&&list.size()>0){
				s = new String[list.size()];
				for(int i=0;i<list.size();i++){
					s[i]=list.get(i).getEquipmentID();
				}
			}
		}catch(Exception e){
			logger.equals(e.getMessage());
		}
		return s;
	}
	
	public boolean	addEquipmentGroup(String ids,String groupName) {
		try{
			if(ids!=null&&ids.length()>0){
				for(String s : ids.split(",")){
					EquipmentGroupVO equipmentGroupVO = new EquipmentGroupVO();
					equipmentGroupVO.setEquipmentID(s);
					equipmentGroupVO.setGroupname(groupName);
					equipmentGroupVO.setStatus(EquipmentGroupVO.STATUS_VALID);
					ServiceFactory.getEquipmentGroupService().add(equipmentGroupVO);
				}
			}
		}catch(Exception e){
			logger.equals(e.getMessage());
			return false;
		}
		return true;
	}
	//设备退出所在会议
	public void exitMeeting(String id,String equipmentID,String meetingdetailID,String roomID){
		try{
			WebContext ctx = WebContextFactory.get(); 
			HttpSession session = ctx.getHttpServletRequest().getSession(); 
			UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
			MeetingDetailEquipmentVO mdeVO = new MeetingDetailEquipmentVO();
			mdeVO.setId(id);
			mdeVO.setEquipmentID(equipmentID);
			mdeVO.setMeetingDetailID(meetingdetailID);
			mdeVO.setStatus(MeetingDetailEquipmentVO.INVALID);
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			mdeVO.setCreateDate(ts);
			mdeVO.setCreateUserID(userVO.getUserID());
			ServiceFactory.getMeetingDetailEquipmentService().modify(mdeVO);
			
			EquipmentVO eVO = new EquipmentVO();
			MeetingRoomVO mrVO = new MeetingRoomVO();
			MeetingDetailEquipmentVO mdeVO1 = new MeetingDetailEquipmentVO();
			MeetingDetailRoomVO mdrVO = new MeetingDetailRoomVO();
			mdrVO.setMeetingRoomId(roomID);
			mdrVO.setMeetingDetailId(meetingdetailID);
			//判断设备所在的会议室是不是还有其它设备在会议中被占用，如果没有则删除z_t_meetingdetail_room表中的数据，如果有不做处理。
			boolean flag=false;
			ArrayList<MeetingDetailEquipmentVO> mList = new ArrayList<MeetingDetailEquipmentVO>();
			mrVO.setMeetingRoomID(roomID);
			eVO.setMeetingRoomVO(mrVO);
			ArrayList<EquipmentVO> list = ServiceFactory.getEquipmentService().query(eVO, null);
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++){
					if(!list.get(i).getEquipmentID().equals(equipmentID)){
					mdeVO1.setEquipmentID(list.get(i).getEquipmentID());
					mList = ServiceFactory.getMeetingDetailEquipmentService().queryMeeting(mdeVO1, null);
					if(mList!=null && mList.size()>0){
						flag = true;
						break;
					}
					}
				}
			}
			if(!flag){
				ServiceFactory.getMeetingDetailRoomService().delMeetingDetailRoom(mdrVO, null);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

	public boolean changeNode(String levelID,String nodeIP,int nodePort){
		LevelVO lVO = new LevelVO();
		lVO.setLevelID(levelID);
		lVO.setNodeIP(nodeIP);
		lVO.setNodePort(nodePort);
		try {
			ServiceFactory.getLevelService().modify(lVO);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//开启终端检测状态线程
	public boolean startTer(){
		boolean flag = false;
		if(ControlFactory.startEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_TERMINAL)){
			numberTerStatus = 1;
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}
	//关闭终端检测状态线程
	public boolean stopTer(){
		boolean flag = false;
		if(ControlFactory.stopEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_TERMINAL)){
			numberTerStatus = 2;
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}
	//开启中控检测状态线程 startEquipmentNetStatusThreads该方法只要没有异常返回值均为true
	public boolean startCenter(){
		boolean flag = false;
		if(ControlFactory.startEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL)){
			numberCenStatus = 1;
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}
	//关闭中控检测状态线程
	public boolean stopCenter(){
		boolean flag = false;
		if(ControlFactory.stopEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL)){
			numberCenStatus = 2;
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}
	//导出word
	public boolean exporWord(String str,String file){
		boolean flag = false;
		logger.info("导出word");
		try {
			WordExport.exportWord(str, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
			logger.error("导出word失败");
			//e.printStackTrace();
		}
		flag = true;
		logger.info("导出word成功");
		return flag;
	}
}