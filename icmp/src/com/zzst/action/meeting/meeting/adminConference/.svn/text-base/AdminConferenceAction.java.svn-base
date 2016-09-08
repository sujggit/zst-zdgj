package com.zzst.action.meeting.meeting.adminConference;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.meeting.McuControlHelper;
import com.zzst.action.meeting.meeting.task.MeetingTaskOperate;
import com.zzst.action.meeting.util.LogUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuVO.ZZOResultVO;
import com.zzst.dao.meeting.meetingDetail.MeetingDetailDAO;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailDepartment.MeetingDetailDepartMentVO;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;
import com.zzst.model.meeting.meetingDetailUser.MeetingDetailUserVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.user.UserVO;

/**
 * 立即召开功能，
 * 包含立即召开与会议预约
 * @author zhangdq
 *
 */
public class AdminConferenceAction extends CjfAction {
 
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(AdminConferenceAction.class.getName());
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private ArrayList<MeetingRoomVO> meetingRoomList = new ArrayList<MeetingRoomVO>();
	private List<MeetingDetailVO> meetingDetailVOList = new ArrayList<MeetingDetailVO>();
	
	
	/**
	 * 会议模板中的立即召开
	 * 只创建会议信息，不维护涉及的会场及其他信息
	 * @return
	 */
	public String conveneVideoConference(){
		logger.info("AdminConferenceAction	conveneVideoConference	begin");
		try{
			String tempMeetingDetailID = meetingDetailVO.getMeetingDetailID();
			if(tempMeetingDetailID!=null&&!(tempMeetingDetailID.equals(""))){
				UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
				//插入日志
				LogVO vLogVO = new LogVO();
				vLogVO.setLogType(LogEnum.TYPE_DB);
				vLogVO.setLevel(LogEnum.LEVEL_DeFAULT);
				vLogVO.setUserID(sessionUserVO.getUserID());
				
				MeetingDetailVO newDetailVO = copyConference(tempMeetingDetailID);

				ZZOResultVO resultVO = new McuControlHelper().creatConfInMcuLevelTwo(newDetailVO.getMeetingDetailID());//根据模板ID，查询相关信息
				
				if(resultVO == null){//建会成功
					
					vLogVO.setOperatorContent("模版开会："+meetingDetailVO.getMeetingName()+" 成功");
					LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
				}else if(resultVO != null ){//建会失败
					newDetailVO.setStatus(MeetingDetailEnum.STATUS_INVALID+"");
					ServiceFactory.getMeetingDetailService().ModifyMeetingDetailForState(newDetailVO);
					
					vLogVO.setOperatorContent("模版开会："+meetingDetailVO.getMeetingName()+" 失败");
					LogUtil.addLogForOperate(vLogVO.getOperatorContent(), vLogVO.getUserID(), vLogVO.getUserIP(), vLogVO.getLogType(), vLogVO.getLevel());
					String errorMessage = McuControlHelper.getErrorMessage(resultVO.getDescription());
					
					this.getCurHttpServletRequest().setAttribute("failure_message", errorMessage);
					return "failure_meeting";//建会失败跳转到出错页面
				}
			}
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "用模板建会时发生异常！");
			logger.error(e.getMessage());
			return ERROR;
		}
		logger.info("AdminConferenceAction	conveneVideoConference	end");   
		return SUCCESS;
	}
	
	/**
	 * 根据模板ID，复制一个正在召开的会议
	 * @param tempMeetingDetailID
	 * @return
	 */
	private MeetingDetailVO copyConference(String tempMeetingDetailID){
		MeetingDetailVO newDetailVO  = new MeetingDetailVO(); 
		try{
			MeetingDetailVO detailVO = ServiceFactory.getMeetingDetailService().queryByID(tempMeetingDetailID);//得到会议模板对象VO
			//创建一个会议
			detailVO.setStatus(MeetingDetailEnum.STATUS_ING+"");
			detailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_PTMB);
			newDetailVO = ServiceFactory.getMeetingDetailService().addMeetingDetail(detailVO);
			
			MeetingDetailRoomVO vMeetingDetailRoomVO = new MeetingDetailRoomVO();
			vMeetingDetailRoomVO.setMeetingDetailId(tempMeetingDetailID);
			ArrayList<MeetingDetailRoomVO> drVOList = ServiceFactory.getMeetingDetailRoomService().getMeetingDetailRoomList(vMeetingDetailRoomVO, null);
			for(MeetingDetailRoomVO vo : drVOList){
				vo.setMeetingDetailId(newDetailVO.getMeetingDetailID());
				ServiceFactory.getMeetingDetailRoomService().addMeetingDetailRoom(vo, null);
			}
			MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
			meetingDetailEquipmentVO.setMeetingDetailID(tempMeetingDetailID);
			ArrayList<MeetingDetailEquipmentVO> deVOList = ServiceFactory.getMeetingDetailEquipmentService().query(meetingDetailEquipmentVO, null);
			for(MeetingDetailEquipmentVO vo : deVOList){
				vo.setMeetingDetailID(newDetailVO.getMeetingDetailID());
				ServiceFactory.getMeetingDetailEquipmentService().add(vo, null);
			}
			
			MeetingDetailUserVO vMeetingDetailUserVO = new MeetingDetailUserVO();
			vMeetingDetailUserVO.setMeetingDetailID(tempMeetingDetailID);
			ArrayList<MeetingDetailUserVO> duVOList = ServiceFactory.getMeetingDetailUserService().getMeetingDetailUserList(vMeetingDetailUserVO, null);
			for(MeetingDetailUserVO vo : duVOList){
				vo.setMeetingDetailID(newDetailVO.getMeetingDetailID());
				ServiceFactory.getMeetingDetailUserService().addMeetingDetailUser(vo, null);
			}
			MeetingDetailDepartMentVO meetingDetailDepartMentVO = new MeetingDetailDepartMentVO();
			meetingDetailDepartMentVO.setMeetingDetailID(tempMeetingDetailID);
			ArrayList<MeetingDetailDepartMentVO> ddVOList = ServiceFactory.getMeetingDetailDepartMentService().query(meetingDetailDepartMentVO, null);
			for(MeetingDetailDepartMentVO vo : ddVOList){
				vo.setMeetingDetailID(newDetailVO.getMeetingDetailID());
				ServiceFactory.getMeetingDetailDepartMentService().add(vo, null);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return newDetailVO;
	}
	/**
	 * 跳转到快速建会修改页面
	 * @author zhangdq
	 * @serialData 2014-7-15
	 * @return
	 */
	public String meetingTemplateBeforeModify(){
		logger.info("MeetingAction	meetingTemplateBeforeModify	begin");
		try{
			long tl = Integer.valueOf(MeetingAppConfig.meeting_start_time)*60*1000;
			if(tl>0)
				this.getCurHttpServletRequest().setAttribute("meetingStartTimeMark",true);
			meetingDetailVO.setStatus(MeetingDetailEnum.STATUS_TEMPLATE+"");
			if(meetingDetailVO.getMeetingDetailID()!=null&&!(meetingDetailVO.getMeetingDetailID().equals(""))){
				ArrayList<MeetingDetailVO> meetingDetailVOList = ServiceFactory.getMeetingDetailService().query(meetingDetailVO, null);//.getMeetingDetailList(meetingDetailVO, null);
				if(meetingDetailVOList != null && meetingDetailVOList.size()>0 ){
					meetingDetailVO = meetingDetailVOList.get(0);
					
					MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
					meetingDetailEquipmentVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
					ArrayList<MeetingDetailEquipmentVO> li = ServiceFactory.getMeetingDetailEquipmentService().query(meetingDetailEquipmentVO, null);
					this.getCurHttpServletRequest().setAttribute("joinEquipmentList", li);//参会设备
				}else{
					return "FAILURE";
				}
			}
			
			ArrayList<EquipmentVO>	leftTreeList	=	ServiceFactory.getEquipmentService().queryEquipmentRoomAddress(null, null);
			Map<String,EquipmentVO> leftTreeMap = new HashMap<String,EquipmentVO>();
			Map<String,AddressVO> addressMap = new HashMap<String,AddressVO>();
			Map<String,MeetingRoomVO> roomMap = new HashMap<String,MeetingRoomVO>();
			for(int i=0;i<leftTreeList.size();i++){
				EquipmentVO vo = leftTreeList.get(i);
				
				if(leftTreeMap.get(vo.getEquipmentID())==null){
					leftTreeMap.put(vo.getEquipmentID(),vo);
				}
				if(addressMap.get(vo.getAddressVO().getAddressID())==null){
					addressMap.put(vo.getAddressVO().getAddressID(), vo.getAddressVO());
				}
				if(roomMap.get(vo.getMeetingRoomVO().getMeetingRoomID())==null){
					roomMap.put(vo.getMeetingRoomVO().getMeetingRoomID(),vo.getMeetingRoomVO());
				}
			}
			
			ArrayList<EquipmentVO> groupEquipmentList = new ArrayList<EquipmentVO>();
			Map<String,EquipmentGroupVO> groupList = new HashMap<String,EquipmentGroupVO>();
			ArrayList<EquipmentGroupVO> allGroupList = ServiceFactory.getEquipmentGroupService().query(null, null);
			for(EquipmentGroupVO vo : allGroupList){
				EquipmentVO eVO = leftTreeMap.get(vo.getEquipmentID());
				EquipmentVO e = new EquipmentVO();
				e.setDescription(vo.getGroupname());
				e.setEquipmentNO(eVO.getEquipmentNO());
				e.setCascadeEquipmentID(eVO.getCascadeEquipmentID());
				e.setAllResourceNumber(eVO.getAllResourceNumber());
				e.setIp(eVO.getIp());
				e.setEquipmentType(eVO.getEquipmentType());
				e.setEquipmentModel(eVO.getEquipmentModel());
				e.setEquipmentID(eVO.getEquipmentID());
				if(eVO!=null){
					groupEquipmentList.add(e);
				}
				if(groupList.get(vo.getGroupname())==null){
					groupList.put(vo.getGroupname(),vo);
				}
			}

			//会议模式
			StringBuffer sb = new StringBuffer();
			McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
			mcuCascadeModelVO.setStatus(McuCascademodelEnum.VALID);
			try{
				ArrayList<McuCascadeModelVO> mcuCascadeModelList =  ServiceFactory.getMcuCascadeModelService().query(mcuCascadeModelVO, null);
				if(mcuCascadeModelList!=null){
					for(McuCascadeModelVO vo : mcuCascadeModelList ){
						sb.append("<option value='");
						sb.append(vo.getCascadeID()+"'>");
						sb.append(vo.getCascadeName());
						sb.append("</option>");
					}
				}
			}catch( Exception e ){
				logger.error(e.getMessage());
			}
			this.getCurHttpServletRequest().setAttribute("mcuCacsdeModelOption", sb.toString());//会议模式
			this.getCurHttpServletRequest().setAttribute("groupList", groupList.values());//组
			this.getCurHttpServletRequest().setAttribute("groupEquipmentList", groupEquipmentList);//组内设备信息
			this.getCurHttpServletRequest().setAttribute("addressMap", addressMap);//区域
			this.getCurHttpServletRequest().setAttribute("roomMap", roomMap);//会议室
			this.getCurHttpServletRequest().setAttribute("equipmentList", leftTreeList);//所有的设备
		}catch(Exception e){
			this.getCurHttpServletRequest().setAttribute("info", "跳转修改会议模板页面时发生异常！");
			logger.error(e.getMessage());
			return ERROR;
		}		
		
		logger.info("MeetingAction	meetingTemplateBeforeModify	end");   
		return SUCCESS;
	}
	
	
	/**
	 * 跳转到会议预约界面
	 * @return
	 */
	public String	conferenceBookBefore(){
		logger.info("AdminConferenceAction	conferenceBookBefore		begin");
		try{
			
			meetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
			
			long tl = Integer.valueOf(MeetingAppConfig.meeting_start_time)*60*1000;
			if(tl>0)
				this.getCurHttpServletRequest().setAttribute("meetingStartTimeMark",true);
			meetingDetailVO.setRealityStartTime(new Timestamp(System.currentTimeMillis()+tl));

			Calendar c = Calendar.getInstance();
			int iDuration = MeetingAppConfig.SysMeetTime;
			c.add(Calendar.MINUTE, iDuration);
			meetingDetailVO.setMeetingEndTime(new Timestamp(c.getTimeInMillis()));
            ////////////////////////@author:zhangjy 分级分权///////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			EquipmentVO equipmentVO=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentVO.setLevel(true);
					equipmentVO.setLsql(suv.getLvoids());
				}
			}
			////////////////////////////////////////////
			ArrayList<EquipmentVO>	leftTreeList	=	ServiceFactory.getEquipmentService().queryEquipmentRoomAddress(equipmentVO, null);
			Map<String,EquipmentVO> leftTreeMap = new HashMap<String,EquipmentVO>();
			Map<String,AddressVO> addressMap = new HashMap<String,AddressVO>();
			Map<String,MeetingRoomVO> roomMap = new HashMap<String,MeetingRoomVO>();
			for(int i=0;i<leftTreeList.size();i++){
				EquipmentVO vo = leftTreeList.get(i);
				
				if(leftTreeMap.get(vo.getEquipmentID())==null){
					leftTreeMap.put(vo.getEquipmentID(),vo);
				}
				if(addressMap.get(vo.getAddressVO().getAddressID())==null){
					addressMap.put(vo.getAddressVO().getAddressID(), vo.getAddressVO());
				}
				if(roomMap.get(vo.getMeetingRoomVO().getMeetingRoomID())==null){
					roomMap.put(vo.getMeetingRoomVO().getMeetingRoomID(),vo.getMeetingRoomVO());
				}
			}
			
			ArrayList<EquipmentVO> groupEquipmentList = new ArrayList<EquipmentVO>();
			Map<String,EquipmentGroupVO> groupList = new HashMap<String,EquipmentGroupVO>();
			ArrayList<EquipmentGroupVO> allGroupList = ServiceFactory.getEquipmentGroupService().query(null, null);
			for(EquipmentGroupVO vo : allGroupList){
				EquipmentVO eVO = leftTreeMap.get(vo.getEquipmentID());
				if(eVO!=null){
					EquipmentVO e = new EquipmentVO();
					e.setDescription(vo.getGroupname());
					e.setEquipmentNO(eVO.getEquipmentNO());
					e.setCascadeEquipmentID(eVO.getCascadeEquipmentID());
					e.setAllResourceNumber(eVO.getAllResourceNumber());
					e.setIp(eVO.getIp());
					e.setEquipmentType(eVO.getEquipmentType());
					e.setEquipmentModel(eVO.getEquipmentModel());
					e.setEquipmentID(eVO.getEquipmentID());
					groupEquipmentList.add(e);
				}
				if(groupList.get(vo.getGroupname())==null){
					groupList.put(vo.getGroupname(),vo);
				}
			}
			
			//会议模式
			StringBuffer sb = new StringBuffer();
			McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
			mcuCascadeModelVO.setStatus(McuCascademodelEnum.VALID);
			try{
				ArrayList<McuCascadeModelVO> mcuCascadeModelList =  ServiceFactory.getMcuCascadeModelService().query(mcuCascadeModelVO, null);
				if(mcuCascadeModelList!=null){
					for(McuCascadeModelVO vo : mcuCascadeModelList ){
						sb.append("<option value='");
						sb.append(vo.getCascadeID()+"'>");
						sb.append(vo.getCascadeName());
						sb.append("</option>");
					}
				}
			}catch( Exception e ){
				logger.error(e.getMessage());
			}
			
//			ArrayList<MeetingDetailEquipmentVO> useEquipmentList = getUseEquipmentByTime(meetingDetailVO.getMeetingStartTime(),meetingDetailVO.getMeetingEndTime());
//			Map<String,MeetingDetailEquipmentVO> useEquipmentMap = new HashMap<String,MeetingDetailEquipmentVO>();
//			for(MeetingDetailEquipmentVO vo : useEquipmentList){
//				useEquipmentMap.put(vo.getEquipmentID(), vo);
//			}
//			
//			this.getCurHttpServletRequest().setAttribute("useEquipmentMap", useEquipmentMap);//已经占有的设备
			this.getCurHttpServletRequest().setAttribute("mcuCacsdeModelOption", sb.toString());//会议模式
			this.getCurHttpServletRequest().setAttribute("groupList", groupList.values());//组
			this.getCurHttpServletRequest().setAttribute("groupEquipmentList", groupEquipmentList);//组内设备信息
			this.getCurHttpServletRequest().setAttribute("addressMap", addressMap);//区域
			this.getCurHttpServletRequest().setAttribute("roomMap", roomMap);//会议室
			this.getCurHttpServletRequest().setAttribute("equipmentList", leftTreeList);//所有的设备
		}catch(Exception e){
			logger.error("AdminConferenceAction	conferenceBookBefore	error："+e.getMessage());
			return ERROR;
		}
		logger.info("AdminConferenceAction	conferenceBookBefore		end");
		return SUCCESS;
	}
	
	public static void main(String[] args) { }
	
	private static Map<String,String> roomMap = new HashMap<String,String>();//缓存已经插入的会议室，避免重复插入
	/**
	 * 插入到会议-设备表中
	 */
	private void equipmentList(String meetingDetailID ,String mainEquipmentID,String cascadeID,JSONObject json){
		try{
			MeetingDetailEquipmentVO meetingDetailEquipmentVO = new MeetingDetailEquipmentVO();
			
			//存储会议设备表
			String equipmentID = json.getString("id");
			String equipmentType = json.getInt("nodeType")+"";
			
			EquipmentVO eVO = ServiceFactory.getEquipmentService().queryByIDNew(equipmentID);
			
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO != null){
				meetingDetailEquipmentVO.setCreateUserID(sessionUserVO.getUserID());
			}
			
			if(roomMap.get(eVO.getMeetingRoomVO().getMeetingRoomID())==null){
				//存储会议会议室表
				MeetingDetailRoomVO vMeetingDetailRoomVO = new MeetingDetailRoomVO();
				vMeetingDetailRoomVO.setIsmain(MeetingDetailEnum.mainVenue_invalid);
				vMeetingDetailRoomVO.setMeetingDetailId(meetingDetailID);
				vMeetingDetailRoomVO.setMeetingRoomId(eVO.getMeetingRoomVO().getMeetingRoomID());
				ServiceFactory.getMeetingDetailRoomService().addMeetingDetailRoom(vMeetingDetailRoomVO, null);
				roomMap.put(eVO.getMeetingRoomVO().getMeetingRoomID(),eVO.getMeetingRoomVO().getMeetingRoomID());
			}
			
			meetingDetailEquipmentVO.setCascadeID(cascadeID);
			meetingDetailEquipmentVO.setCount(9);
			meetingDetailEquipmentVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			
//			meetingDetailEquipmentVO.setDescription(eVO.);
			meetingDetailEquipmentVO.setEquipmentID(equipmentID);
			meetingDetailEquipmentVO.setEquipmentIP(eVO.getIp());
			meetingDetailEquipmentVO.setEquipmentNo(eVO.getEquipmentNO());
			meetingDetailEquipmentVO.setEquipmentType(eVO.getEquipmentType());
			meetingDetailEquipmentVO.setRoomID(eVO.getMeetingRoomVO().getMeetingRoomID());
			meetingDetailEquipmentVO.setStatus(MeetingDetailEquipmentVO.VALID);
			meetingDetailEquipmentVO.setMeetingDetailID(meetingDetailID);
			
			//2、3 为页面维护的标识
			if("2".equalsIgnoreCase(equipmentType)){//MCU
				EquipmentMcuVO mcuVO = ServiceFactory.getEquipmentMcuService().queryByID(equipmentID);
				String confProfileID = json.getString("confProfileID");
				meetingDetailEquipmentVO.setConfProfileID(confProfileID);
				meetingDetailEquipmentVO.setAgc(mcuVO.getAgc());
				meetingDetailEquipmentVO.setAudioAgreementType(mcuVO.getRadioTreaty());
				meetingDetailEquipmentVO.setVideoAgreementType(mcuVO.getVideoTreaty());
				meetingDetailEquipmentVO.setAliasName(mcuVO.getAliasName());
				meetingDetailEquipmentVO.setAliasType(mcuVO.getAliasType());
				meetingDetailEquipmentVO.setCascadeRole(mcuVO.getCascadeRole());
				meetingDetailEquipmentVO.setDialingDirection(mcuVO.getDialingDirection());
				meetingDetailEquipmentVO.setDialingType(mcuVO.getDialingType());
				meetingDetailEquipmentVO.setMaxPesolution(mcuVO.getMaxPesolution());
				meetingDetailEquipmentVO.setEquipmentNumber(mcuVO.getAliasName());//别名
				meetingDetailEquipmentVO.setSpeed(mcuVO.getSpeed());
			}else if("3".equalsIgnoreCase(equipmentType)){//终端
				EquipmentTerminalVO terVO = ServiceFactory.getEquipmentTerminalService().queryByID(equipmentID);
				meetingDetailEquipmentVO.setDialingType(terVO.getDialingType());
				meetingDetailEquipmentVO.setDialingDirection(terVO.getDialingDirection());
				meetingDetailEquipmentVO.setAgc(terVO.getAgc());
				meetingDetailEquipmentVO.setAliasName(terVO.getAliasName());
				meetingDetailEquipmentVO.setAliasType(terVO.getAliasType());
				meetingDetailEquipmentVO.setCascadeRole(terVO.getCascadeRole());
				meetingDetailEquipmentVO.setDialingDirection(terVO.getDialingDirection());
				meetingDetailEquipmentVO.setDialingType(terVO.getDialingType());
				meetingDetailEquipmentVO.setEquipmentTel(terVO.getPstn());
				meetingDetailEquipmentVO.setMaxPesolution(terVO.getMaxPesolution());
				meetingDetailEquipmentVO.setSpeed(terVO.getSpeed());
				if(equipmentID.equalsIgnoreCase(mainEquipmentID))
					meetingDetailEquipmentVO.setMainEquipment(MeetingDetailEquipmentVO.MAIN_VALID);
				else
					meetingDetailEquipmentVO.setMainEquipment(MeetingDetailEquipmentVO.MAIN_INVALID);
			}
			ServiceFactory.getMeetingDetailEquipmentService().add(meetingDetailEquipmentVO,null);
			try{
				JSONArray childrenJson = json.getJSONArray("children");//为空时，抛空异常
				for(int i=0;childrenJson!=null&&i<childrenJson.length();i++){
					equipmentList(meetingDetailID,mainEquipmentID,equipmentID,childrenJson.getJSONObject(i));
				}
			}catch(Exception e){}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private MeetingDetailVO addConferenceDate(String meetingStatus){
		logger.info("AdminConferenceAction	addConferenceDate		begin");
		MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
		try{
			String josnStr = meetingDetailVO.getMeetingDescription();
			String mainRoomID = meetingDetailVO.getInfo3();
			String mainEquipmentID = meetingDetailVO.getInfo4();
			
			long endTime = 1;
			try{
				endTime = Long.valueOf(meetingDetailVO.getInfo2()).longValue();
			}catch(Exception e){
				logger.error("开会时长（"+meetingDetailVO.getInfo2()+"）异常，默认为1小时");
			}
			
			//存储会议明细表
			UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(sessionUserVO!=null&&sessionUserVO.getUserID()!=null){
				vMeetingDetailVO.setCreateUserID(sessionUserVO.getUserID());
			}
			vMeetingDetailVO.setMeetingName(meetingDetailVO.getMeetingName());
			vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			vMeetingDetailVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			vMeetingDetailVO.setStatus(meetingStatus);
			vMeetingDetailVO.setMeetingStartTime(meetingDetailVO.getMeetingStartTime());
			vMeetingDetailVO.setMeetingEndTime(new Timestamp(meetingDetailVO.getMeetingStartTime().getTime()+(endTime*60*60*1000)));
			vMeetingDetailVO.setUseReach(MeetingDetailEnum.REACH_INVALID);//录播
//			vMeetingDetailVO.setGrade(grade);//级别
//			vMeetingDetailVO.setNotifyType(notifyType);//通知方式
			vMeetingDetailVO.setConfProfileID(meetingDetailVO.getConfProfileID());
//			vMeetingDetailVO.setMeetingAgenda(meetingAgenda)//议程
			vMeetingDetailVO.setConfDocAdminId(sessionUserVO.getUserID());//资料人
			vMeetingDetailVO.setConfDocAdminName(sessionUserVO.getName());//
			vMeetingDetailVO.setInfo1(MeetingDetailEnum.TYPE_NOTICE_LJZK);//标签
			vMeetingDetailVO.setTemplateType(MeetingDetailEnum.TYPE_TEMPLATETYPE_DEF);
			if(meetingDetailVO.getRealityStartTime()!=null)
				vMeetingDetailVO.setRealityStartTime(meetingDetailVO.getRealityStartTime());
			MeetingDetailVO detailVO = MeetingDetailDAO.addMeetingDetail2(vMeetingDetailVO, null);
			
			//存储会议会议室表中的主会议室
			roomMap.clear();
			MeetingDetailRoomVO vMeetingDetailRoomVO = new MeetingDetailRoomVO();
			vMeetingDetailRoomVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
			vMeetingDetailRoomVO.setMeetingDetailId(detailVO.getMeetingDetailID());
			vMeetingDetailRoomVO.setMeetingRoomId(mainRoomID);
			ServiceFactory.getMeetingDetailRoomService().addMeetingDetailRoom(vMeetingDetailRoomVO, null);
			roomMap.put(mainRoomID,mainRoomID);
			
			//存储到会议设备数据库中
			equipmentList(detailVO.getMeetingDetailID(),mainEquipmentID,"-1",new JSONObject(josnStr));
			
		}catch(Exception e){
			logger.error("AdminConferenceAction	addConferenceDate	error："+e.getMessage());
			return null;
		}
		logger.info("AdminConferenceAction	addConferenceDate		end");
		return vMeetingDetailVO;
	}
	
	public String	conferenceBook(){
		logger.info("AdminConferenceAction	conferenceBook		begin");
		try{
			MeetingDetailVO vMeetingDetailVO = addConferenceDate(MeetingDetailEnum.STATUS_APPROVED_PASS+"");
			if(vMeetingDetailVO!=null){
				//add 20120416 增加定时器，以便会议状态的定时修改
				MeetingTaskOperate.meetingStartForEquipment(vMeetingDetailVO);
			}
			
			String modelMark = meetingDetailVO.getInfo5();
			if(modelMark!=null&&modelMark.length()>0){//要存为模板
				addConferenceDate(MeetingDetailEnum.STATUS_TEMPLATE+"");
			}
			
		}catch(Exception e){
			logger.error("AdminConferenceAction	conferenceBook	error："+e.getMessage());
		}
		logger.info("AdminConferenceAction	conferenceBook		end");
		
		if(meetingDetailVO.getMeetingStartTime().after(new Timestamp(System.currentTimeMillis())))
			return "meetingList";
		else
			return "meetingControl";
	}
	
	
	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public List<MeetingDetailVO> getMeetingDetailVOList() {
		return meetingDetailVOList;
	}

	public void setMeetingDetailVOList(List<MeetingDetailVO> meetingDetailVOList) {
		this.meetingDetailVOList = meetingDetailVOList;
	}

	public ArrayList<MeetingRoomVO> getMeetingRoomList() {
		return meetingRoomList;
	}

	public void setMeetingRoomList(ArrayList<MeetingRoomVO> meetingRoomList) {
		this.meetingRoomList = meetingRoomList;
	}
}
