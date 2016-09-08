package com.zzst.action.meeting.util;

import java.sql.Timestamp;

import com.zzst.meeting.service.comparison.ComparisonCriteriaService;
import com.zzst.meeting.service.comparison.ComparisonCriteriaServiceImpl;
import com.zzst.meeting.service.comparison.ComparisonDetailService;
import com.zzst.meeting.service.comparison.ComparisonDetailServiceImpl;
import com.zzst.meeting.service.comparison.ComparisonReferenceService;
import com.zzst.meeting.service.comparison.ComparisonReferenceServiceImpl;
import com.zzst.meeting.service.comparison.ComparisonService;
import com.zzst.meeting.service.comparison.ComparisonServiceImpl;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.service.meeting.address.AddressService;
import com.zzst.service.meeting.address.AddressServiceImpl;
import com.zzst.service.meeting.apply.applyDetail.ApplyDetailService;
import com.zzst.service.meeting.apply.applyDetail.ApplyDetailServiceImpl;
import com.zzst.service.meeting.apply.flow.ApplyFlowService;
import com.zzst.service.meeting.apply.flow.ApplyFlowServiceImpl;
import com.zzst.service.meeting.apply.flownode.ApplyFlownodeService;
import com.zzst.service.meeting.apply.flownode.ApplyFlownodeServiceImpl;
import com.zzst.service.meeting.auth.FuncService;
import com.zzst.service.meeting.auth.FuncServiceImpl;
import com.zzst.service.meeting.authorization.AuthorizationService;
import com.zzst.service.meeting.authorization.AuthorizationServiceImpl;
import com.zzst.service.meeting.baseinfo.BaseInfoService;
import com.zzst.service.meeting.baseinfo.BaseInfoServiceImpl;
import com.zzst.service.meeting.centerControl.CenterControlService;
import com.zzst.service.meeting.centerControl.CenterControlServiceImpl;
import com.zzst.service.meeting.configTcip.ConfigTcipService;
import com.zzst.service.meeting.configTcip.ConfigTcipServiceImpl;
import com.zzst.service.meeting.dataInterface.department.DepartmentInterfaceService;
import com.zzst.service.meeting.dataInterface.department.DepartmentInterfaceServiceImpl;
import com.zzst.service.meeting.dataInterface.equipment.EquipmentInterfaceService;
import com.zzst.service.meeting.dataInterface.equipment.EquipmentInterfaceServiceImpl;
import com.zzst.service.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailService;
import com.zzst.service.meeting.dataInterface.meetingDetail.InterfaceMeetingDetailServiceImpl;
import com.zzst.service.meeting.dataInterface.meetingModel.InterfaceMeetingModelService;
import com.zzst.service.meeting.dataInterface.meetingModel.InterfaceMeetingModelServiceImpl;
import com.zzst.service.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceService;
import com.zzst.service.meeting.dataInterface.meetingRoom.MeetingRoomInterfaceServiceImpl;
import com.zzst.service.meeting.dataInterface.role.RoleInterfaceService;
import com.zzst.service.meeting.dataInterface.role.RoleInterfaceServiceImpl;
import com.zzst.service.meeting.dataInterface.terminal.TerminalInterfaceService;
import com.zzst.service.meeting.dataInterface.terminal.TerminalInterfaceServiceImpl;
import com.zzst.service.meeting.dataInterface.user.UserInterfaceService;
import com.zzst.service.meeting.dataInterface.user.UserInterfaceServiceImpl;
import com.zzst.service.meeting.department.DepartmentService;
import com.zzst.service.meeting.department.DepartmentServiceImpl;
import com.zzst.service.meeting.dictionary.DictionaryEquipmentService;
import com.zzst.service.meeting.dictionary.DictionaryEquipmentServiceImpl;
import com.zzst.service.meeting.dictionary.DictionaryService;
import com.zzst.service.meeting.dictionary.DictionaryServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentBackupService;
import com.zzst.service.meeting.equipment.EquipmentBackupServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentGroupService;
import com.zzst.service.meeting.equipment.EquipmentGroupServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentMcuService;
import com.zzst.service.meeting.equipment.EquipmentMcuServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentService;
import com.zzst.service.meeting.equipment.EquipmentServiceImpl;
import com.zzst.service.meeting.equipment.EquipmentTerminalService;
import com.zzst.service.meeting.equipment.EquipmentTerminalServiceImpl;
import com.zzst.service.meeting.equipment.camera.EquipmentCameraService;
import com.zzst.service.meeting.equipment.camera.EquipmentCameraServiceImpl;
import com.zzst.service.meeting.equipment.maintain.EquipmentMaintainService;
import com.zzst.service.meeting.equipment.maintain.EquipmentMaintainServiceImpl;
import com.zzst.service.meeting.information.InformationService;
import com.zzst.service.meeting.information.InformationServiceImpl;
import com.zzst.service.meeting.informationUser.InformationUserService;
import com.zzst.service.meeting.informationUser.InformationUserServiceImpl;
import com.zzst.service.meeting.kst.KstVedioMoniterService;
import com.zzst.service.meeting.kst.KstVedioMoniterServiceImpl;
import com.zzst.service.meeting.kst.WallPresetService;
import com.zzst.service.meeting.kst.WallPresetServiceImpl;
import com.zzst.service.meeting.level.LevelService;
import com.zzst.service.meeting.level.LevelServiceImpl;
import com.zzst.service.meeting.levelConfig.LevelConfigService;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;
import com.zzst.service.meeting.log.LogService;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.service.meeting.mailConfig.MailConfigService;
import com.zzst.service.meeting.mailConfig.MailConfigServiceImpl;
import com.zzst.service.meeting.mcuCascadeModel.McuCascadeModelService;
import com.zzst.service.meeting.mcuCascadeModel.McuCascadeModelServiceImpl;
import com.zzst.service.meeting.meeting.MeetingService;
import com.zzst.service.meeting.meeting.MeetingServiceImpl;
import com.zzst.service.meeting.meetingDebug.MeetingDebugService;
import com.zzst.service.meeting.meetingDebug.MeetingDebugServiceImpl;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;
import com.zzst.service.meeting.meetingDetailDepartment.MeetingDetailDepartMentService;
import com.zzst.service.meeting.meetingDetailDepartment.MeetingDetailDepartMentServiceImpl;
import com.zzst.service.meeting.meetingDetailEquipment.MeetingDetailEquipmentService;
import com.zzst.service.meeting.meetingDetailEquipment.MeetingDetailEquipmentServiceImpl;
import com.zzst.service.meeting.meetingDetailRoom.MeetingDetailRoomService;
import com.zzst.service.meeting.meetingDetailRoom.MeetingDetailRoomServiceImpl;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserService;
import com.zzst.service.meeting.meetingDetailUser.MeetingDetailUserServiceImpl;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.meetingRoom.MeetingRoomServiceImpl;
import com.zzst.service.meeting.meetingRoomMaintain.MeetingRoomMaintainService;
import com.zzst.service.meeting.meetingRoomMaintain.MeetingRoomMaintainServiceImpl;
import com.zzst.service.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailService;
import com.zzst.service.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailServiceImpl;
import com.zzst.service.meeting.meetingroomEquipment.MeetingroomEquipmentService;
import com.zzst.service.meeting.meetingroomEquipment.MeetingroomEquipmentServiceImpl;
import com.zzst.service.meeting.messageContent.MessageContentService;
import com.zzst.service.meeting.messageContent.MessageContentServiceImpl;
import com.zzst.service.meeting.pollTemplate.PollTemplateService;
import com.zzst.service.meeting.pollTemplate.PollTemplateServiceImpl;
import com.zzst.service.meeting.pollTerminal.PollTerminalService;
import com.zzst.service.meeting.pollTerminal.PollTerminalServiceImpl;
import com.zzst.service.meeting.post.PostService;
import com.zzst.service.meeting.post.PostServiceImpl;
import com.zzst.service.meeting.statistics.StatisticsService;
import com.zzst.service.meeting.statistics.StatisticsServiceImpl;
import com.zzst.service.meeting.template.TemplateService;
import com.zzst.service.meeting.template.TemplateServiceImpl;
import com.zzst.service.meeting.templateEquipment.TemplateEquipmentService;
import com.zzst.service.meeting.templateEquipment.TemplateEquipmentServiceImpl;
import com.zzst.service.meeting.templateEquipmentGroup.TemplateEquipmentGroupService;
import com.zzst.service.meeting.templateEquipmentGroup.TemplateEquipmentGroupServiceImpl;
import com.zzst.service.meeting.templateMeeting.TemplateMeetingService;
import com.zzst.service.meeting.templateMeeting.TemplateMeetingServiceImpl;
import com.zzst.service.meeting.uploadFile.UploadFileService;
import com.zzst.service.meeting.uploadFile.UploadFileServiceImpl;
import com.zzst.service.meeting.uploadFile.impower.UploadFileImpowerService;
import com.zzst.service.meeting.uploadFile.impower.UploadFileImpowerServiceImpl;
import com.zzst.service.meeting.user.UserService;
import com.zzst.service.meeting.user.UserServiceImpl;
import com.zzst.service.meeting.userRole.UserRoleService;
import com.zzst.service.meeting.userRole.UserRoleServiceImpl;
import com.zzst.service.meeting.videoCard.VideoCardService;
import com.zzst.service.meeting.videoCard.VideoCardServiceImpl;
import com.zzst.service.meeting.videoconference.VideoconferenceService;
import com.zzst.service.meeting.videoconference.VideoconferenceServiceImpl;
import com.zzst.service.meeting.view.VmeetingDetailService;
import com.zzst.service.meeting.view.VmeetingDetailServiceImpl;
import com.zzst.service.meeting.view.VmeetingService;
import com.zzst.service.meeting.view.VmeetingServiceImpl;
import com.zzst.service.project.avic.applyConference.ApplyConferenceService;
import com.zzst.service.project.avic.applyConference.ApplyConferenceServiceImpl;
import com.zzst.service.project.avic.applySysInsert.ApplySysInsertService;
import com.zzst.service.project.avic.applySysInsert.ApplySysInsertServiceImpl;
import com.zzst.service.project.avic.applyVideoExport.ApplyVideoExportService;
import com.zzst.service.project.avic.applyVideoExport.ApplyVideoExportServiceImpl;
import com.zzst.service.project.avic.service.AvicServiceService;
import com.zzst.service.project.avic.service.AvicServiceServiceImpl;
import com.zzst.service.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackService;
import com.zzst.service.project.avic.videoConferenceFeedBack.VideoConferenceFeedBackServiceImpl;


/**
 *@Description  提取所有Service实现类
 *@date 2011-10-24下午03:30:41
 *@author ryan
 */
public class ServiceFactory { 
	
	//标准接口部分---开始
	/**
	 * 预约信息接口
	 * @return InterfaceMeetingDetailService
	 */
	public static InterfaceMeetingDetailService getInterfaceMeetingDetailService(){
		return new InterfaceMeetingDetailServiceImpl();
	}
	
	public static EquipmentGroupService getEquipmentGroupService(){
		return new EquipmentGroupServiceImpl();
	}
	
	/**
	 * 会议模板信息
	 * @return InterfaceMeetingModelService
	 */ 
	public  static InterfaceMeetingModelService getInterfaceMeetingModelService(){
		return new InterfaceMeetingModelServiceImpl();
	}
	//标准接口部分---结束
	/**
	 * 授权接口表
	 * @return AuthorizationService
	 */
	public  static AuthorizationService getAuthorizationService(){
		return new AuthorizationServiceImpl();
	}
	
	/**
	 * 可视通-摄像头提取---add by ryan on 2012-08-22
	 * @return KstVedioMoniterService
	 */
	public static KstVedioMoniterService getKstVedioMoniterService(){
		return new KstVedioMoniterServiceImpl();
	}
	
	/**
	 * 可视通-电视墙接口提取---add by ryan on 2012-07-30
	 * @return BaseInfoService
	 */
	public static WallPresetService getWallPresetService(){
		return new WallPresetServiceImpl();
	}
	/**
	 * 基础信息提取---add by ryan on 2012-06-20
	 * @return BaseInfoService
	 */
	public static BaseInfoService getBaseInfoService(){
		return new BaseInfoServiceImpl();
	}
	/**
	 * 中控控制基本信息提取---add by ryan on 2012-06-28
	 * @return CenterControlService
	 */
	public static CenterControlService getCenterControlService(){
		return new CenterControlServiceImpl();
	}
	/**
	 * 摄像头参数模板提取---add on 2013-06-24
	 * @return EquipmentCameraService
	 */
	public static EquipmentCameraService getEquipmentCameraService(){
		return new EquipmentCameraServiceImpl();
	}
	
	/**
	 * 会议接口---add by ryan on 2012-4-23
	 * @return	FuncService
	 * @author ryan
	 */ 
	public	static	FuncService	getFuncService(){
		return	new FuncServiceImpl();
	}
	
	/**
	 * 会议接口---add by ryan on 2011-12-02
	 * @return	MeetingService
	 * @author ryan
	 */ 
	public	static	MeetingDetailService	getMeetingDetailService(){
		return	new MeetingDetailServiceImpl();
	}

	/**
	 * 会议接口---add by ryan on 2014-05-07
	 * @return	MeetingDetailEquipmentService
	 * @author ryan
	 */ 
	public	static	MeetingDetailEquipmentService	getMeetingDetailEquipmentService(){
		return	new MeetingDetailEquipmentServiceImpl();
	}
	
	/**
	 * 部门接口---add by ryan on 2011-12-06
	 * @return
	 */
	public	static	DepartmentService	getDepartmentService(){
		return	new DepartmentServiceImpl();
	}
	
	/**
	 *   会议文件上传下载借口---add by tanzl on 2013-1-14
	 * @return
	 */
	public	static	UploadFileService	getFileuploadService(){
		return	new UploadFileServiceImpl();
	}
	
	/**
	 * 资料下载授权接口
	 * @return
	 */
	public static UploadFileImpowerService getUploadFileImpowerService(){
		return new UploadFileImpowerServiceImpl();
	}
	
	/**
	 * 视频会议接口 ---历史遗留不建议使用
	 * @return	MeetingService
	 * @author ryan
	 */ 
	public	static	MeetingService	getMeetingService(){
		return	new MeetingServiceImpl();
	}
	
	
	/**
	 * 人员接口
	 * @return	UserService
	 * @author ryan
	 */ 
	public	static	UserService	getUserService(){
		return	new UserServiceImpl();
	}
	
	/**
	 * 岗位接口
	 * @return	UserService
	 * @author ryan
	 */ 
	public	static	PostService	getPostService(){
		return	new PostServiceImpl();
	}
	
	/**
	 * 会议室管理接口
	 * @return	MeetingService
	 * @author linsha
	 */ 
	public	static	MeetingRoomService	getMeetingRoomService(){
		
		return	new MeetingRoomServiceImpl();
	}
	
	
	/**
	 * 地址接口
	 * @return	AddressService
	 * @author linsha
	 */
	public static AddressService getAddressService(){
		
		return new AddressServiceImpl();
	}
	
	
	/**
	 * 日志接口
	 * @return	AddressService
	 * @author linsha
	 */
	public static LogService getLogService(){
		return new LogServiceImpl();
	}
	
	/**
	 * 增加日志接口
	 * 所有项都必填
	 * @param level		LogEnum内引用
	 * @param logType	LogEnum内引用
	 * @param content
	 * @param userID	非具体用户产生的日志统一引用DateBaseEnum.Default_ID
	 * @param userIP	
	 * @return
	 */
	public static LogVO addLog(int level,String logType,String userID,String content){
		LogVO logVO = new LogVO();
		try{
			logVO.setLevel(level);
			logVO.setLogType(logType);
			logVO.setOperatorContent(content);
			logVO.setUserID(userID);
			logVO.setOperatorDate(new Timestamp(System.currentTimeMillis()));
			return new LogServiceImpl().add(logVO);
		}catch(Exception e){
			return logVO;
		}
	}

	/**
	 * 消息接口
	 * @return	AddressService
	 * @author tanzanlong
	 */
	public static InformationService getInformationService(){
		return new InformationServiceImpl();
	}
	

	/**
	 * 消息用户接口
	 * @return	InformationUserService
	 * @author tanzanlong
	 */
	public static InformationUserService getInformationUserService(){
		return new InformationUserServiceImpl();
	}
	
	/**
	 * 设备接口
	 * @return	AddressService
	 * @author linsha
	 */
	public static EquipmentService getEquipmentService(){
		return new EquipmentServiceImpl();
	}
	

	/**
	 * 设备维修记录接口
	 * @return	AddressService
	 * @author linsha
	 */
	public static EquipmentMaintainService getEquipmentMaintainService(){
		
		return new EquipmentMaintainServiceImpl();
	}

	
	

	/**
	 * mcu设备接口
	 * @return	AddressService
	 * @author linsha
	 */
	public static EquipmentMcuService getEquipmentMcuService(){
		return new EquipmentMcuServiceImpl();
	}
	/**
	 *设备备份接口
	 * @return	EquipmentBackupService
	 * date：3012-1-23
	 * @author tanzanlong
	 */
	public static EquipmentBackupService getEquipmentBackupService(){
		return new EquipmentBackupServiceImpl();
	}
	

	/**
	 * 终端接口
	 * @return	AddressService
	 * @author linsha
	 */
	public static EquipmentTerminalService getEquipmentTerminalService(){
		return new EquipmentTerminalServiceImpl();
	}
	
	public static VideoconferenceService getVideoconferenceService(){
		return new VideoconferenceServiceImpl();
	}
	
	
	public static MeetingDetailUserService getMeetingDetailUserService(){
		return new MeetingDetailUserServiceImpl();
		
	}
	
	public static StatisticsService getStatisticsService(){
		return new StatisticsServiceImpl();
	}
	
	/**
	 * 审批流程接口
	 * @return
	 */
	public static ApplyFlowService getApplyFlowService(){
		return new ApplyFlowServiceImpl();
	}
	
	public static ApplyFlownodeService getApplyFlownodeService(){
		return new ApplyFlownodeServiceImpl();
	}
	 
	/**
	 * 审批过程信息
	 * @return
	 */
	public static ApplyDetailService getApplyDetailService(){
		return new ApplyDetailServiceImpl();
	}
	 
	/**
	 * 系统维护接口
	 * @return
	 */
	public static MeetingRoomMaintainService getMeetingRoomMaintainService(){
		return new MeetingRoomMaintainServiceImpl();
	}
	public static MeetingRoomMaintainDetailService getMeetingRoomMaintainDetailService(){
		return new MeetingRoomMaintainDetailServiceImpl();
	}
	 
	/**
	 * 级联模板
	 * @return
	 */
	public static McuCascadeModelService getMcuCascadeModelService(){
		return new McuCascadeModelServiceImpl();
	}
	
	/**
	 * 会议于部门关联表
	 * @return
	 */
	public static MeetingDetailDepartMentService getMeetingDetailDepartMentService(){
		return new MeetingDetailDepartMentServiceImpl();
	}
	
	/**
	 * 操作数据字典的接口
	 * @return
	 */
	public static DictionaryService getDictionaryService(){
		return new DictionaryServiceImpl();
	}
	
	/**
	 * 高级模板接口
	 * @return
	 */
	public static TemplateService getTemplateService(){
		return new TemplateServiceImpl();
	}
	
	/**
	 * 高级模板-会议接口
	 * @return
	 */
	public static TemplateMeetingService getTemplateMeetingService(){
		return new TemplateMeetingServiceImpl();
	}
	
	/**
	 * 高级模板设备组接口
	 * @return
	 */
	public static TemplateEquipmentGroupService getTemplateEquipmentGroupService(){
		return new TemplateEquipmentGroupServiceImpl();
	}
	
	/**
	 * 高级模板设备接口
	 * @return
	 */
	public static TemplateEquipmentService getTemplateEquipmentService(){
		return new TemplateEquipmentServiceImpl();
	}
	/**
	 * 点名对比接口
	 * @return
	 */
	public static ComparisonService getConparisonService(){
		return new ComparisonServiceImpl();
	}
	public static ComparisonDetailService getConparisonDetailService(){
		return new ComparisonDetailServiceImpl();
	}
	public static ComparisonReferenceService getConparisonReferenceService(){
		return new ComparisonReferenceServiceImpl();
	}
	public static ComparisonCriteriaService getConparisonCriteriaService(){
		return new ComparisonCriteriaServiceImpl();
	}
	
	/**
	 * 比对卡接口
	 * @return
	 */
	public static VideoCardService getVideoCardService(){
		return new VideoCardServiceImpl();
	}
	/**
	 * 视频会议申请
	 * @return
	 */
	public static ApplyConferenceService getApplyConferenceService(){
		return new ApplyConferenceServiceImpl();
	}
	
	/**
	 * 系统接入申请接口
	 */
	public static ApplySysInsertService getApplySysInsertService(){
		return new ApplySysInsertServiceImpl();
	}
	/**
	 * 视频文件导出申请
	 */
	public static ApplyVideoExportService getApplyVideoExportService(){
		return new ApplyVideoExportServiceImpl();
	}
	/**
	 * 视频会议反馈
	 * @return
	 */
	public static VideoConferenceFeedBackService getVideoConferenceFeedBackService(){
		return new VideoConferenceFeedBackServiceImpl();
	}
	
	/**
	 * 服务统计接口
	 * @return
	 */
	public static AvicServiceService getAvicServiceService(){
		return new AvicServiceServiceImpl();
	}

	
	/**
	 * 发送消息接口
	 * @return
	 */
	public static MessageContentService getMessageContentService(){
		return new MessageContentServiceImpl();
	}
	
	/**
	 * 轮询模板接口
	 * @return
	 */
	public static PollTemplateService getPollTemplateService(){
		return new PollTemplateServiceImpl();
	}
	
	/**
	 * 轮询终端接口
	 * @return
	 */
	public static PollTerminalService getPollTerminalService(){
		return new PollTerminalServiceImpl();
	}
	
	/**
	 * 会议室导入接口
	 */

	public static MeetingRoomInterfaceService getMeetingRoomInterfaceService(){
		return new MeetingRoomInterfaceServiceImpl();
	}
	
	
	/**
	 * 终端导入接口
	 */

	public static TerminalInterfaceService getTerminalInterfaceService(){
		return new TerminalInterfaceServiceImpl();
	}
	
	/**
	 * 设备导入接口
	 */

	public static EquipmentInterfaceService getEquipmentInterfaceService(){
		return new EquipmentInterfaceServiceImpl();
	}
	
	/**
	 * 会议调试接口
	 * @return
	 */
	public static MeetingDebugService getMeetingDebugService(){
		return new MeetingDebugServiceImpl();
	}
	
	/**
	 * 角色导入接口
	 * @return
	 */
	public static RoleInterfaceService getRoleInterfaceService(){
		return new RoleInterfaceServiceImpl();
	
	}
	
	
	/**
	 * 部门导入接口
	 * @return
	 */
	public static DepartmentInterfaceService getDepartmentInterfaceService(){
		return new DepartmentInterfaceServiceImpl();
	
	}
	
	
	/**
	 * 用户导入接口
	 * @return
	 */
	public static UserInterfaceService getUserInterfaceService(){
		return new UserInterfaceServiceImpl();
	
	}
	
	/**
	 * 会议室设备关联
	 * @return
	 */
	public static MeetingroomEquipmentService getMeetingroomEquipmentService(){
		return new MeetingroomEquipmentServiceImpl();
	}
	/**
	 * 会后修改参会信息
	 * @author zhangjy
	 * @date 2014-01-15
	 */
	public static MeetingDetailRoomService getMeetingDetailRoomService(){
		
		return new MeetingDetailRoomServiceImpl();
	}
	
	/**
	 * 统计
	 * @author zhangjy
	 * @date 2013-09-23
	 * 
	 */
	public static VmeetingService getVmeetingService(){
		return new VmeetingServiceImpl();
	}
	
	public static VmeetingDetailService getVmeetingDetailService(){
		return new VmeetingDetailServiceImpl();
	}
	public static UserRoleService getUserRoleService(){
		return new UserRoleServiceImpl();
	}
	
	/**
	 * 短信、告示配置
	 * @author liujf
	 * @date 2013-11-11
	 * 
	 */
	public static ConfigTcipService getConfigTcipService(){
		return new ConfigTcipServiceImpl();
	}
	
	/**
	 * 邮件配置
	 * @author liujf
	 * @date 2013-11-11
	 * 
	 */
	public static MailConfigService getMailConfigService(){
		return new MailConfigServiceImpl();
	}
	
	/**
	 * 分级配置
	 * @author liujf
	 * @date 2013-11-14
	 * 
	 */
	public static LevelService getLevelService(){
		return new LevelServiceImpl();
	}
	
	/**
	 * 分级分权配置
	 * @author liujf
	 * @date 2013-11-18
	 * 
	 */
	public static LevelConfigService getLevelConfigService(){
		return new LevelConfigServiceImpl();
	}
	/**
	 * 提取设备枚举的接口
	 * @author liujf
	 * @date 2014-01-14
	 */
	public static DictionaryEquipmentService getDictionaryEquipmentService(){
		return new DictionaryEquipmentServiceImpl();
	}
}
