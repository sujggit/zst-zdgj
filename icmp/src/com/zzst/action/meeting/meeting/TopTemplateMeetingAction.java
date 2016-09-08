package com.zzst.action.meeting.meeting;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.db.TransactionManager;
import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.gsiec.cbimpl.util.StringUtils;
import com.gsiec.model.portal.session.UserSessionVO;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfProfileVO;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOInterfaceConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOMainVO;
import com.zzst.application.mcuVO.ZZOResultVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.application.meeting.mcuInterface.IMcuDwrMethodHelp;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.meeting.dwr.McuDwrMethod;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingStatus;
import com.zzst.model.enums.MeetingTypeEnum;
import com.zzst.model.enums.TopMeetingTemplate;
import com.zzst.model.enums.UseStatusEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.enums.VideoconferenceEnum;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.template.TemplateVO;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;
import com.zzst.model.meeting.templateMeeting.TemplateMeetingVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;
import com.zzst.service.meeting.equipment.EquipmentMcuService;
import com.zzst.service.meeting.equipment.EquipmentMcuServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentServiceImpl;
import com.zzst.service.meeting.meeting.MeetingService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.template.TemplateService;
import com.zzst.service.meeting.templateEquipment.TemplateEquipmentService;
import com.zzst.service.meeting.templateMeeting.TemplateMeetingService;
import com.zzst.service.meeting.videoconference.VideoconferenceService;
import com.zzst.service.meeting.videoconference.VideoconferenceServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;


/**
 * 
 * @author chenshuo
 * @since 2013-3-20
 */
public class TopTemplateMeetingAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = CbfLogger.getLogger(TopTemplateMeetingAction.class.getName());
	
	private List<TemplateVO> templateList = new ArrayList<TemplateVO>();//页面间传递数据集合
	private TemplateVO templateVO = new TemplateVO();//页面传递VO
	private TemplateMeetingVO templateMeetingVO = new TemplateMeetingVO();
	private TemplateMeetingVO templateMeetingVO1 = new TemplateMeetingVO();
	private InputStream  excelStream;//excel输入流
	private List<EquipmentVO> mcuList = new ArrayList<EquipmentVO>();
	private List<TemplateEquipmentGroupVO> tegList = new ArrayList<TemplateEquipmentGroupVO>();
	private List<TemplateMeetingVO> tmList = new ArrayList<TemplateMeetingVO>();
	private TemplateEquipmentGroupVO templateEquipmentGroupVO = new TemplateEquipmentGroupVO();
	private ZZOInterfaceConfVO mainConfVO = null;
	private ZZOMainVO zzoMainMcuVO = null;
	/**
	 * 获取高级会议模板列表
	 * @return
	 */
	public String manageTopMeetingTemplateList(){
		logger.info("TopTemplateMeetingAction		manageTopMeetingTemplateList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		
		try{
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO suv = (UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					templateVO.setLevel(true);
					templateVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			TemplateService templateService = ServiceFactory.getTemplateService();
			templateVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			templateList = templateService.query(templateVO, pSplittor.getPControler());
		 
		}catch(Exception e){
			request.setAttribute("info", "获取高级模板管理时发生异常！");
			logger.error(e.getMessage());
			return "failure";
		}
		
		logger.info("TopTemplateMeetingAction		manageTopMeetingTemplateList	end");
		return "success";
	}
	
	/**
	 * 导出高级模板列表excel
	 * @return
	 */
	public String exportTopMeetingTemplateList(){
		logger.info("TopTemplateMeetingAction	exportTopMeetingTemplateList	begin");
		try{
			templateVO.setStatus(TopMeetingTemplate.STATUS_VALID);//有效状态
			templateList = ServiceFactory.getTemplateService().query(templateVO, null);
			
			String fileName = "topTemplate.xls";
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			if(templateList!=null&& templateList.size()>0){
				
				for (int i = 0; i < templateList.size(); i++) {
					TemplateVO tVO = templateList.get(i);
					CellVO[] cell = new CellVO[4];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");//序号
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(tVO.getTemplateName());//模板名称
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(tVO.getDuration()+"");//会议时长
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(tVO.getDescription());//模板描述
					cell[3] = ex3;
					
					
					list.add(cell);
					
				}
				//ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        //excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	exportTopMeetingTemplateList	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	exportTopMeetingTemplateList	end");
		return "success";
	}

	
	/**
	 * 跳转修改高级模板
	 * @return
	 */
	public String beforeModifyTopMeetingTemplate(){
		logger.info("TopTemplateMeetingAction	beforeModifyTopMeetingTemplate	begin");
		try{
			templateVO =  ServiceFactory.getTemplateService().queryByID(templateVO.getId());
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	beforeModifyTopMeetingTemplate	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	beforeModifyTopMeetingTemplate	end");
		return "success";
	}
	
	/**
	 * 修改高级模板
	 * @return
	 */
	public String modifyTopMeetingTemplate(){
		logger.info("TopTemplateMeetingAction	modifyTopMeetingTemplate	begin");
		try{
			templateVO =  ServiceFactory.getTemplateService().modify(templateVO);
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	modifyTopMeetingTemplate	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	modifyTopMeetingTemplate	end");
		return "success";
	}
	
	
	/**
	 * 删除高级模板
	 * @return
	 */
	public String deleteTopMeetingTemplate(){
		logger.info("TopTemplateMeetingAction	deleteTopMeetingTemplate	begin");
		try{
			//1.删除该模板下所有会议
			ServiceFactory.getTemplateMeetingService().deleteByTemplateId(templateVO.getId());
			//2.删除该模板
			ServiceFactory.getTemplateService().deleteByID(templateVO.getId());
			//3.删除meetingdetail表的数据（假删除）
			MeetingDetailService meetingDetailService = ServiceFactory.getMeetingDetailService();
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
			String meetingDetailID = request.getParameter("meetingDetailID");
			meetingDetailVO.setMeetingDetailID(meetingDetailID);
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID + "");
			meetingDetailService.delMeetingDetail(meetingDetailVO);
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	deleteTopMeetingTemplate	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	deleteTopMeetingTemplate	end");
		return "success";
	}
	
	
	/**
	 * 跳转至添加高级模板
	 * @return
	 */
	public String beforeAddTopTemplate(){
		logger.info("TopTemplateMeetingAction	beforeAddTopTemplate	begin");
		try{
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	beforeAddTopTemplate	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	beforeAddTopTemplate	end");
		return "success";
	}
	
	
	/**
	 * 添加高级模板
	 * @return
	 */
	public String addTopTemplate(){
		logger.info("TopTemplateMeetingAction	addTopTemplate	begin");
		try{
			templateVO.setStatus(TopMeetingTemplate.STATUS_VALID);//状态有效
			
			UserVO loginUser = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user
			if(loginUser != null){
				templateVO.setCreateUserID(loginUser.getUserID());
			}
			ServiceFactory.getTemplateService().add(templateVO);
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	addTopTemplate	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	addTopTemplate	end");
		return "success";
	}
	
	
	/**
	 * 跳转至添加模板-会议页面
	 * @return
	 */
	public String beforeAddTopMeetingTemplate(){
		logger.info("TopTemplateMeetingAction	beforeAddTopMeetingTemplate	begin");
		try{
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO lu = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user
			templateEquipmentGroupVO.setLevelid(lu.getLvoids());
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			mcuList =  ServiceFactory.getEquipmentService().queryMCUID(tev);//mcu列表
			templateEquipmentGroupVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			tegList = ServiceFactory.getTemplateEquipmentGroupService().query(templateEquipmentGroupVO, null);//提取设备组
			
			//RtegList = ServiceFactory.
			
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	beforeAddTopMeetingTemplate	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	beforeAddTopMeetingTemplate	end");
		return "success";
	}
	
	/**
	 * 添加高级模板及其主会
	 * @return
	 */
	public String addTopMeetingTemplate(){
		logger.info("TopTemplateMeetingAction	addTopMeetingTemplate	begin");
		try{
			//1.添加一条模板记录
			templateVO.setStatus(TopMeetingTemplate.STATUS_VALID);//状态有效
			UserVO loginUser = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user
			if(loginUser != null){
				templateVO.setCreateUserID(loginUser.getUserID());
			}
			templateVO = ServiceFactory.getTemplateService().add(templateVO);
			
			// 2.添加一条主会数据
			templateMeetingVO.setTemplateId(templateVO.getId());//关联模板id
			templateMeetingVO.setIsMain(TopMeetingTemplate.STATUS_ISMAIN);//主会
			templateMeetingVO.setParentId("-1");//主会无上联会议id
			templateMeetingVO.setRank(TopMeetingTemplate.ORDER_NUMBER);//主会默认1000
			templateMeetingVO.setStatus(TopMeetingTemplate.STATUS_VALID);//有效
			templateMeetingVO.setCreateUserID(loginUser.getUserID());//创建人
			ServiceFactory.getTemplateMeetingService().add(templateMeetingVO);
			
			//3.往z_t_meetingdetail表插入数据
			MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
				//get UserInfo
			if(loginUser != null){
				meetingDetailVO.setCreateUserID(loginUser.getUserID());
				meetingDetailVO.setCreateUserName(loginUser.getUserID());
			}
			
			int vTime = (int)((Float.parseFloat(templateVO.getDuration())) * 60);
			Calendar currentTime = Calendar.getInstance();
			meetingDetailVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));
			currentTime.add(Calendar.MINUTE, vTime);
			meetingDetailVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));
			
				//会议表
			if(meetingDetailVO.getUseNotice() == Integer.MIN_VALUE){
				meetingDetailVO.setUseNotice(UseStatusEnum.INVALID);
			}
			if(meetingDetailVO.getUseReach() == Integer.MIN_VALUE){
				meetingDetailVO.setUseReach(UseStatusEnum.INVALID);
			}
			
			meetingDetailVO.setStatus(MeetingStatus.TEMPLATE+"");
				//会议明细
			meetingDetailVO.setMeetingDescription(templateVO.getDuration());
			meetingDetailVO.setMeetingName(templateMeetingVO.getMeetingName());
			meetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);//2视频会议
			meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_GJMB);//info1字段放“高级模板”
			meetingDetailVO.setTemplateType(MeetingDetailEnum.TYPE_TEMPLATETYPE_GJMB);//1为高级模板，2为普通模板
			meetingDetailVO.setTemplateID(templateVO.getId());
			meetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));//设置创建时间
			MeetingDetailDAO.addMeetingDetail2(meetingDetailVO, null);
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	addTopMeetingTemplate	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	addTopTemplate	end");
		return "success";
	}
	
	
	
	
	/**
	 * 跳转至会议列表页面
	 * @return
	 */
	public String getTopMeetingList(){
		logger.info("TopTemplateMeetingAction	getTopMeetingList	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			templateMeetingVO.setTemplateId(templateVO.getId());//根据模板id关联出所有会议
			templateMeetingVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			tmList = ServiceFactory.getTemplateMeetingService().query(templateMeetingVO, pSplittor.getPControler());
			for( int i=0; i<tmList.size(); i++ ){
				EquipmentVO mcuVO = ServiceFactory.getEquipmentService().queryByID(tmList.get(i).getMcuEquipmentId());
				if(null!=mcuVO){
					tmList.get(i).setMcuEquipmentName(mcuVO.getEquipmentNO());
				}
			}
			
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	getTopMeetingList	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	getTopMeetingList	end");
		return "success";
	}
	
	

	/**
	 * 删除模板会议
	 * @return
	 */
	public String deleteTopMeeting(){
		logger.info("TopTemplateMeetingAction	deleteTopMeeting	begin");
		try{
			ServiceFactory.getTemplateMeetingService().deleteByID(templateMeetingVO.getId());
			//ServiceFactory.getTemplateMeetingService().modify(templateMeetingVO);
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	deleteTopMeeting	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	deleteTopMeeting	end");
		return "success";
	}
	
	
	/**
	 * 跳转至添加会议信息页面
	 * @return
	 */
	public String beforeAddMeeting(){
		logger.info("TopTemplateMeetingAction	beforeAddMeeting	begin");
		try{
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO lu = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			mcuList =  ServiceFactory.getEquipmentService().queryMCUID(tev);//mcu列表
			templateMeetingVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			tmList = ServiceFactory.getTemplateMeetingService().query(templateMeetingVO, null);//该模板下所有会议
			templateEquipmentGroupVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			tegList = ServiceFactory.getTemplateEquipmentGroupService().query(templateEquipmentGroupVO, null);//提取设备组
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	beforeAddMeeting	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	beforeAddMeeting	end");
		return "success";
	}
	
	
	
	/**
	 * 添加会议信息
	 * @return
	 */
	public String addMeetingInfo(){
		logger.info("TopTemplateMeetingAction	addMeetingInfo	begin");
		try{
			UserVO loginUser = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user
			if(loginUser != null){
				templateMeetingVO.setCreateUserID(loginUser.getUserID());
			}
			if( templateMeetingVO.getIsMain() == Integer.MIN_VALUE){//没有勾选主会
				templateMeetingVO.setIsMain(TopMeetingTemplate.STATUS_NOTMAIN);
				
				int rank = getParentMeetingRank(templateMeetingVO.getParentId());//获取上联会议Rank值
				templateMeetingVO.setRank(rank-10);
			}
			
			if( StringUtils.isNullOrBlank(templateMeetingVO.getParentId())){//主会没有上联会议
				templateMeetingVO.setParentId("-1");
				templateMeetingVO.setRank(TopMeetingTemplate.ORDER_NUMBER);//主会默认1000建会顺序
			}
			templateMeetingVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			ServiceFactory.getTemplateMeetingService().add(templateMeetingVO);
	
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	addMeetingInfo	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	addMeetingInfo	end");
		return "success";
	}
	
	
	/**
	 * 修改会议信息
	 * @return
	 */
	public String beforeModifyMeetingInfo(){
		logger.info("TopTemplateMeetingAction	beforeModifyMeetingInfo	begin");
		try{
            ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO lu = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			templateEquipmentGroupVO.setLevelid(lu.getLvoids());
			}
			/////////////////////////end////////////////////////////////////////
			mcuList =  ServiceFactory.getEquipmentService().queryMCUID(tev);//mcu列表
			templateMeetingVO1.setStatus(TopMeetingTemplate.STATUS_VALID);
			tmList = ServiceFactory.getTemplateMeetingService().query(templateMeetingVO1, null);//上联会议列表
			templateMeetingVO = ServiceFactory.getTemplateMeetingService().queryByID(templateMeetingVO.getId());//当前要修改的对象
			templateEquipmentGroupVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			tegList = ServiceFactory.getTemplateEquipmentGroupService().query(templateEquipmentGroupVO, null);//提取设备组
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	beforeModifyMeetingInfo	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	beforeModifyMeetingInfo	end");
		return "success";
	}
	
	
	/**
	 * 修改会议信息
	 * @return
	 */
	public String modifyMeetingInfo(){
		logger.info("TopTemplateMeetingAction	modifyMeetingInfo	begin");
		try{
			
			if( templateMeetingVO.getIsMain() == Integer.MIN_VALUE){//没有勾选主会
				templateMeetingVO.setIsMain(TopMeetingTemplate.STATUS_NOTMAIN);
				
				int rank = getParentMeetingRank(templateMeetingVO.getParentId());//获取上联会议Rank值
				templateMeetingVO.setRank(rank-10);
			}
			
			if( StringUtils.isNullOrBlank(templateMeetingVO.getParentId())){//主会没有上联会议
				templateMeetingVO.setParentId("-1");
				templateMeetingVO.setRank(TopMeetingTemplate.ORDER_NUMBER);//主会默认1000建会顺序
			}
			templateMeetingVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			ServiceFactory.getTemplateMeetingService().modify(templateMeetingVO);
			
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	modifyMeetingInfo	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	modifyMeetingInfo	end");
		return "success";
	}
	
	/**
	 * 立即召开高级模板会议
	 * @author chenshuo at 2013-3-22
	 * @return
	 */
	public String addVideoMeetingOnMcu(){
		logger.info("TopTemplateMeetingAction	addVideoMeetingOnMcu	begin");
		MCUConfig.RMX2000_EQUIPMENT_MODEL_ID = String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000);
		MCUConfig.RMX2000C_EQUIPMENT_MODEL_ID = String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000C);
		MCUConfig.RMX1000_EQUIPMENT_MODEL_ID = String.valueOf(EquipmentEnum.MODEL_ID_MCU_1000);
		
		
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		TemplateMeetingService templateMeetingService = ServiceFactory.getTemplateMeetingService();
		TemplateEquipmentService templateEquipmentService = ServiceFactory.getTemplateEquipmentService();
		MeetingService meetingService = ServiceFactory.getMeetingService();
		MeetingDetailService meetingDetailService = ServiceFactory.getMeetingDetailService();
		EquipmentMcuService mcuser = new EquipmentMcuServiceImpl();
		int duration = -1;
		try{
			
			
			//1.向数据库插入会议信息
			
			
			List<ZZOResultVO> resultVOList = null;//MCU会议建会返回值
			
			meetingDetailVO = setMeetingDetail(meetingDetailVO);//设置会议信息
			meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_GJMB);
			//2.参会会场 通过所有会场组拼装 ---待完善 未向meetingDetailRoom插入数据
			ArrayList<VideoconferenceVO> videoconferenceVOList = new ArrayList<VideoconferenceVO>();
			templateMeetingVO.setTemplateId(templateVO.getId());//查询条件为该模板id
			tmList = templateMeetingService.query(templateMeetingVO, null);//获取该模板下所有会议组
			
			
			TemplateEquipmentVO varTemEqu = new TemplateEquipmentVO();
			ArrayList<TemplateEquipmentVO> temList = null;
			List<ZZOInterfaceConfVO> interfaceConfVOList = new ArrayList<ZZOInterfaceConfVO>();//会议对象List（几个会议几个VO）
			if( tmList != null && tmList.size()>0){//该模板下有会议可以建会
					//record template information
					meetingDetailVO.setTemplateID(templateVO.getId());
				    meetingDetailVO = meetingService.addMeetingByStatus(meetingDetailVO, null,  null, null, MeetingStatus.BE_ATTENDING);//注意位置	待完善
				    meetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_GJMB);
				    for( TemplateMeetingVO tmpTM : tmList){//遍历所有会议
		            	
		            	EquipmentMcuVO mcu = mcuser.queryByMCUID(tmpTM.getMcuEquipmentId());//获取建会MCU
		            	
		            	ArrayList<ZZOMainVO> innerMcuVOList = new ArrayList<ZZOMainVO>();
				        ZZOMainVO innerMcuVO = new ZZOMainVO();//MCU对象
			            innerMcuVO.setEquipmentID(mcu.getEquipmentID());
			            innerMcuVO.setEquipmentName(mcu.getEquipmentNO());
			            innerMcuVO.setAdminLoginName(mcu.getLoginName());
			            innerMcuVO.setAdminLoginPassword(mcu.getLoginPassword());
			            innerMcuVO.setEquipmentIP(mcu.getIp());
			            innerMcuVO.setCommandIP(mcu.getCommandIP());
			            innerMcuVO.setModelID(mcu.getEquipmentModel());
			            //MCU 4000 and MCU 2000 use the same model id
			            if(mcu.getEquipmentModel().equals(String.valueOf(EquipmentEnum.MODEL_ID_MCU_4000))){
			            	innerMcuVO.setModelID(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
			            }
			            ZZOConfProfileVO confProfileVO = new ZZOConfProfileVO();//模板对象
			            
			            confProfileVO.setGuid(tmpTM.getMcuTemplateID());
			            innerMcuVO.setZzoConfProfileVO(confProfileVO);
			            
			            
			            List<ZZOMainVO> innerTermList = new ArrayList<ZZOMainVO>();//终端列表
						String groupId = tmpTM.getGroupId();//每一个会场组id
						varTemEqu.setGroupId(groupId);
						temList = templateEquipmentService.query(varTemEqu, null);//获取终端列表
						ZZOInterfaceConfVO interfaceConfVO = new ZZOInterfaceConfVO();//会议VO
				    	
						setTermianlList(tmpTM, temList,interfaceConfVO,innerTermList,videoconferenceVOList);//设置
		            	 
			            
			            innerMcuVO.setSubMainVOList(innerTermList);
			           
				        
				       
						interfaceConfVO.setConfFlagId(meetingDetailVO.getMeetingDetailID());
						interfaceConfVO.setConfName(tmpTM.getMeetingName());
						interfaceConfVO.setConfNumber(tmpTM.getMeetingNumber());
						interfaceConfVO.setMasterConf(false);
						if( tmpTM.getIsMain() == 1 ){//主会
							interfaceConfVO.setMasterConf(true);
							mainConfVO = interfaceConfVO;
							zzoMainMcuVO = innerMcuVO;
						}else{
							//add this field by wangle 2013-4-15
							innerMcuVO.setUplinkEquipmentID("x");
							
							String pid = tmpTM.getParentId();
							TemplateMeetingVO tmVO = new TemplateMeetingVO();
							tmVO.setId(pid);
							List<TemplateMeetingVO> tmList = templateMeetingService.query(tmVO, null);
							if(tmList!=null&&tmList.size()>0){
								tmVO = tmList.get(0);
								String mcuid = tmVO.getMcuEquipmentId();
								EquipmentMcuVO mainMcu = mcuser.queryByMCUID(mcuid);
								if(null!=mainMcu){
									interfaceConfVO.setParentIpAndConfNum(mainMcu.getCommandIP()+tmVO.getMeetingNumber());
								}
							}
							
							
						}
						innerMcuVOList.add(innerMcuVO);
						
						interfaceConfVO.setOrderNumber(tmpTM.getRank());
						duration = (int)((meetingDetailVO.getMeetingEndTime().getTime() - meetingDetailVO.getMeetingStartTime().getTime())/(1000 * 60));
						
						interfaceConfVO.setDuration(duration);
						interfaceConfVO.setMainVOList(innerMcuVOList);
						
						interfaceConfVOList.add(interfaceConfVO);
						
					}
		            //向meetingDetail_Room表插入数据
		            VideoconferenceService service = new VideoconferenceServiceImpl();
		            TransactionManager tManager = new TransactionManager();
					for (int i = 0; i < videoconferenceVOList.size(); i++) {
						VideoconferenceVO vVideoconferenceVO = (VideoconferenceVO) videoconferenceVOList.get(i);
						vVideoconferenceVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
						try{
							service.addVideoconference(vVideoconferenceVO, tManager);
						}catch( SQLException se){
							se.printStackTrace();//由于联合主键依然可能重复 导致无法插入
							tManager.rollback();
							continue;
						}
					}
					
					//handle master mcu by wangle 2013-4-26 
					if(zzoMainMcuVO != null){
						for(ZZOInterfaceConfVO confVO : interfaceConfVOList){
							List<ZZOMainVO> mainStatusList = confVO.getMainVOList();
							for(ZZOMainVO mainVO : mainStatusList){
								if(mainVO.getEquipmentIP().equals(zzoMainMcuVO.getEquipmentIP())){
									mainVO.setUplinkEquipmentID("");
								}
							}
						}
					}
		            resultVOList = ZZOMcuFactory.getInstance().createConf(interfaceConfVOList, true);
		        	//插入日志
					LogVO vLogVO = new LogVO();
					vLogVO.setLogType(LogEnum.TYPE_DB);
					vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
					vLogVO.setUserID(meetingDetailVO.getCreateUserID());
					if(resultVOList.size()!= 0){//建会失败
						meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
						meetingDetailService.ModifyMeetingDetailForState(meetingDetailVO);//建会失败删除该条会议记录
						(new McuDwrMethod()).deleteConf(meetingDetailVO.getMeetingDetailID());//MCU上删会
						
						vLogVO.setOperatorContent("高级模版开会： "+meetingDetailVO.getMeetingName()+" 失败");
						LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
						String errorMessage = McuControlHelper.getErrorMessage(resultVOList.get(0).getDescription());
						
						
						this.request.setAttribute("failure_message", errorMessage);
						return "failure_meeting";//建会失败跳转到出错页面
					}else{
						if(duration == 10140){
							String endTime = "2099-01-01 00:00:00";
							Timestamp meetingEndTime = Timestamp.valueOf(endTime);
							meetingDetailVO.setMeetingEndTime(meetingEndTime);
							meetingDetailService.modifyGeneralMeetingDetail(meetingDetailVO);
						}
						vLogVO.setOperatorContent("高级模版开会： "+meetingDetailVO.getMeetingName()+" 失败");
						LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
						MeetingTaskOperate.meetingEndTask(meetingDetailVO);//增加定时器 到时间后修改会议状态
					}
			}
			
			
			if(mainConfVO != null){
			ZZOConfVO zzoconf = new ZZOConfVO();
			zzoconf.setConfFlagId(meetingDetailVO.getMeetingDetailID());
			List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(zzoconf);
			for(ZZOConfVO zzconf : confList){
				if(zzconf.getIsMasterConf()==MCUConfig.IS_MASTER_CONF){
					List<ZZOMainStatusVO> equipmentList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(zzconf.getConfFlagId(), zzconf.getMcuIP(), zzconf.getGuid());
					for(ZZOMainStatusVO equipment : equipmentList){
						if(equipment.getMcu_participant_name().equals(mainConfVO.getBroadcaster())){
							//ZZOConfVO newConfVO = new ZZOConfVO();
							zzconf.setLayoutConfigGuid(equipment.getMcu_participant_id());
							zzconf.setLayoutMode(MCUConfig.LAYOUT_MODE_1X1);
							IMcuDwrMethodHelp imcu =	ZZOMcuFactory.createMethodHelp(String.valueOf(EquipmentEnum.MODEL_ID_MCU_2000));
							imcu.setVideo(zzconf);
						}
						if(equipment.getMcu_participant_name().equals(mainConfVO.getLecturer())){
							StringBuffer str = new StringBuffer();
							str.append(equipment.getMcu_participant_name());
							str.append("__");
							str.append(zzconf.getGuid());
							str.append("__");
							str.append(zzconf.getMcuIP());
							ZZOMcuFactory.getInstance().getMcuControlHelper().setLecturer(zzconf.getConfFlagId(), str.toString(), zzconf);
						}
					}
				}
					
					
			}
			
			}
		}catch(Exception e){
			logger.error("TopTemplateMeetingAction	addVideoMeetingOnMcu	error:"+e.getMessage());
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
			try {
				meetingDetailService.ModifyMeetingDetailForState(meetingDetailVO);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//建会失败删除该条会议记录
		
			e.printStackTrace();
			return ERROR;
		}
		
		logger.info("TopTemplateMeetingAction	addVideoMeetingOnMcu	end");
		return "success";
	}
	
	private void setTermianlList(TemplateMeetingVO tmpTM, ArrayList<TemplateEquipmentVO> temList, ZZOInterfaceConfVO interfaceConfVO, List<ZZOMainVO> innerTermList,ArrayList<VideoconferenceVO> videoconferenceVOList) throws Exception{
		for( TemplateEquipmentVO tempTemVO : temList){//终端列表
        	
        	VideoconferenceVO videoconferenceVO = new VideoconferenceVO();
			
        	
        	ZZOMainVO innerTerminalVO = new ZZOMainVO();
        	innerTerminalVO.setEquipmentName(tempTemVO.getEquipmentName().trim());
        	innerTerminalVO.setEquipmentIP(tempTemVO.getEquipmentIp());
        	innerTerminalVO.setpInterface(tempTemVO.getPInterface());
        	innerTerminalVO.setAliasName(tempTemVO.getAliasName());//级联点别名与主MCU建会的会议号一致
        	innerTerminalVO.setAliasType(tempTemVO.getAliasType());
        	innerTerminalVO.setPtsNumber(tempTemVO.getPtsNumber());
        	innerTerminalVO.setLineRate(tempTemVO.getLineRate());
        	innerTerminalVO.setMaxResolution(tempTemVO.getMaxResolution());
        	innerTerminalVO.setVideoProtocol(tempTemVO.getVideoProtocol());
        	innerTerminalVO.setCascadeRole(tempTemVO.getCascadeRole());//级联角色
        	innerTerminalVO.setAgc(tempTemVO.getAgc());
        	//innerTerminalVO.setCallDirection(tempTemVO.getCallDirection());//呼叫方向
        	innerTerminalVO.setDescription(tempTemVO.getDescription());
        	if(tempTemVO.getCallDirection() != null && tempTemVO.getCallDirection().equals("0")){
        		innerTerminalVO.setCallDirection(MCUConfig.MGC_CASCADE_DIAL_DIRECTION_DIAL_IN);
			}else{
				innerTerminalVO.setCallDirection(MCUConfig.MGC_CASCADE_DIAL_DIRECTION_DIAL_OUT);	
			}
        	//广播者演讲者设置
        	if( tempTemVO.getIsMain() != Integer.MIN_VALUE && tempTemVO.getIsMain() == 1 ){//广播者
        		interfaceConfVO.setBroadcaster(innerTerminalVO.getEquipmentName());
        		//videoconferenceVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
        	}
        	if( tempTemVO.getIsMain() != Integer.MIN_VALUE && tempTemVO.getIsMain() == 2 ){//演讲者
        		interfaceConfVO.setLecturer(innerTerminalVO.getEquipmentName());
        		//videoconferenceVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
        	}
        	if( tempTemVO.getIsMain() != Integer.MIN_VALUE && tempTemVO.getIsMain() == 3 ){//广播+演讲者
        		interfaceConfVO.setBroadcaster(innerTerminalVO.getEquipmentName());
        		interfaceConfVO.setLecturer(innerTerminalVO.getEquipmentName());
        		//videoconferenceVO.setIsmain(VideoconferenceEnum.mainVenue_valid);
        	}
        	EquipmentMcuVO equipmentMcuVO = new EquipmentMcuVO();
        	equipmentMcuVO.setCommandIP(innerTerminalVO.getEquipmentIP());
        	List<EquipmentMcuVO> equipMcuList = new EquipmentMcuServiceImpl().query(equipmentMcuVO, null);
        	if(equipMcuList != null && equipMcuList.size() > 0){
        		innerTerminalVO.setModelID(MCUConfig.RMX2000_EQUIPMENT_MODEL_ID);
        		equipmentMcuVO = equipMcuList.get(0);
        		EquipmentVO mcuEquipmentVO = new EquipmentVO();
        		mcuEquipmentVO.setEquipmentID(equipmentMcuVO.getEquipmentID());
        		List<EquipmentVO> mcuList = new EquipmentServiceImpl().query(mcuEquipmentVO, null);
        		if(mcuList != null && mcuList.size() > 0){
        			mcuEquipmentVO = mcuList.get(0);
	        		if( tmpTM.getIsMain() == 1 ){
						//master mcu dial out other slave mcu.
	        			innerTerminalVO.setEquipmentIP(mcuEquipmentVO.getIp());
	        			innerTerminalVO.setCommandIP(equipmentMcuVO.getCommandIP());
	        			innerTerminalVO.setUplinkEquipmentID("x");
	        			//innerTerminalVO.setCallDirection(MCUConfig.MGC_CASCADE_DIAL_DIRECTION_DIAL_OUT);
					}else{
						innerTerminalVO.setEquipmentIP(mcuEquipmentVO.getIp());
						innerTerminalVO.setCommandIP(equipmentMcuVO.getCommandIP());
						//innerTerminalVO.setCallDirection(MCUConfig.MGC_CASCADE_DIAL_DIRECTION_DIAL_IN);
					}
        		}
        	}else{
				//end point need to set uplink id.
        		innerTerminalVO.setUplinkEquipmentID("x");
			}
        	
        	innerTermList.add(innerTerminalVO);
        	boolean flag = true;
        	if( tempTemVO.getMeetingRoomID() != null ){
        		for( VideoconferenceVO ved : videoconferenceVOList ){
        			if( ved.getSubmeetingRoomID().equals(tempTemVO.getMeetingRoomID()) ){
        				flag = false;
        				break;
        			}
        		}
        		if( flag ){
        			videoconferenceVO.setSubmeetingRoomID(tempTemVO.getMeetingRoomID());
        			
        			if( tmpTM.getIsMain() == 1 && tempTemVO.getIsMain() != 0 && tempTemVO.getIsMain() != Integer.MIN_VALUE ){
        				videoconferenceVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
        			}
        			
            		videoconferenceVOList.add(videoconferenceVO);
        		}
			}
			
        }
		}
	
	/**
	 * 设置会议VO信息	
	 * @return
	 */
	private MeetingDetailVO setMeetingDetail( MeetingDetailVO meetingDetailVO ) throws Exception{
		TemplateService templateService = ServiceFactory.getTemplateService();
		templateVO = templateService.queryByID(templateVO.getId());//通过点击立即召开获取的模板对象
		
		UserVO loginUser = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);//获取user的id和name
		if(loginUser != null){
			meetingDetailVO.setCreateUserID(loginUser.getUserID());
			meetingDetailVO.setCreateUserName(loginUser.getUserID());
		}
		meetingDetailVO.setMeetingType(MeetingTypeEnum.PLOYCOM_MEETING_NEW);//会议类型为视频会议
		int duration = (int)((Float.parseFloat(templateVO.getDuration()) * 60));
		
		Calendar currentTime = Calendar.getInstance();
		meetingDetailVO.setMeetingStartTime(new Timestamp(currentTime.getTimeInMillis()));//会议开始时间
		currentTime.add(Calendar.MINUTE, duration);
		meetingDetailVO.setMeetingEndTime(new Timestamp(currentTime.getTimeInMillis()));//会议结束时间
		meetingDetailVO.setMeetingDescription(templateVO.getDescription());//会议描述
		meetingDetailVO.setMeetingName(templateVO.getTemplateName());//会议名称
		meetingDetailVO.setStatus(MeetingStatus.BE_ATTENDING+"");//会议状态
		return meetingDetailVO;
	}
		
	
	/**
	 * 设置模板信息excel文件表头
	 * @param list
	 */
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[4];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("模板名称");
		cellTitle[1] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("会议时长");
		cellTitle[2] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("模板描述");
		cellTitle[3] = ex0;
		
		list.add(cellTitle);
	}

	
	
	
	private int getParentMeetingRank( String pid ) throws Exception{
		return ServiceFactory.getTemplateMeetingService().queryByID(pid).getRank();
	}

	public List<TemplateVO> getTemplateList() {
		return templateList;
	}



	public void setTemplateList(List<TemplateVO> templateList) {
		this.templateList = templateList;
	}



	public TemplateVO getTemplateVO() {
		return templateVO;
	}



	public void setTemplateVO(TemplateVO templateVO) {
		this.templateVO = templateVO;
	}
	
	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public TemplateMeetingVO getTemplateMeetingVO() {
		return templateMeetingVO;
	}

	public void setTemplateMeetingVO(TemplateMeetingVO templateMeetingVO) {
		this.templateMeetingVO = templateMeetingVO;
	}

	public List<EquipmentVO> getMcuList() {
		return mcuList;
	}

	public void setMcuList(List<EquipmentVO> mcuList) {
		this.mcuList = mcuList;
	}

	public List<TemplateEquipmentGroupVO> getTegList() {
		return tegList;
	}

	public void setTegList(List<TemplateEquipmentGroupVO> tegList) {
		this.tegList = tegList;
	}

	public List<TemplateMeetingVO> getTmList() {
		return tmList;
	}

	public void setTmList(List<TemplateMeetingVO> tmList) {
		this.tmList = tmList;
	}

	public TemplateMeetingVO getTemplateMeetingVO1() {
		return templateMeetingVO1;
	}

	public void setTemplateMeetingVO1(TemplateMeetingVO templateMeetingVO1) {
		this.templateMeetingVO1 = templateMeetingVO1;
	}

	public TemplateEquipmentGroupVO getTemplateEquipmentGroupVO() {
		return templateEquipmentGroupVO;
	}

	public void setTemplateEquipmentGroupVO(
			TemplateEquipmentGroupVO templateEquipmentGroupVO) {
		this.templateEquipmentGroupVO = templateEquipmentGroupVO;
	}
	
	
}
