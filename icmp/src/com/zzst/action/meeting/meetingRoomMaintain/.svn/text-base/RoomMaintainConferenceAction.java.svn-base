package com.zzst.action.meeting.meetingRoomMaintain;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.dao.meeting.meetingRoomMaintain.MeetingRoomMaintainDAO;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomMaintain;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingDetailRoom.MeetingDetailRoomVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ecxel.CellVO;

/**
 * @author xiongshun
 *
 */
public class RoomMaintainConferenceAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private static Logger logger = CbfLogger.getLogger(RoomMaintainConferenceAction.class.getName());
	private	MeetingRoomMaintainVO	meetingRoomMaintainVO = new MeetingRoomMaintainVO();
	private	MeetingRoomMaintainDetailVO	meetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
	private MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private DictionaryVO dictionaryVO = new DictionaryVO();
	private InputStream  excelStream;
	private ArrayList<MeetingRoomMaintainVO> meetingRoomMaintainVOList = new ArrayList<MeetingRoomMaintainVO>();
	private ArrayList<MeetingRoomVO> meetingRoomVOList=new ArrayList<MeetingRoomVO>();
	private ArrayList<DictionaryVO> dListStatus = new ArrayList<DictionaryVO>();
	private ArrayList<DictionaryVO> dListType = new ArrayList<DictionaryVO>();
	
	/**
	 * 跳转到会议记录添加页面
	 * 针对会议的记录。行为会场。
	 * @return
	 */
	public	String	addConferenceMaintainBefore(){
		logger.info("RoomMaintainConferenceAction	addConferenceMaintainBefore	begin");
		try {
			
			meetingDetailVO=ServiceFactory.getMeetingDetailService().queryByID(meetingDetailVO.getMeetingDetailID());
//			MeetingDetailRoomVO vMeetingDetailRoomVO = new MeetingDetailRoomVO();
//			vMeetingDetailRoomVO.setMeetingDetailId(meetingDetailVO.getMeetingDetailID());
			meetingRoomMaintainVO = new MeetingRoomMaintainVO();
			meetingRoomMaintainVO.setMaintainKey(meetingDetailVO.getMeetingDetailID());
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_CONFERENCE);//会场~会议相关
			meetingRoomMaintainVO.setProcessStatus(MeetingRoomMaintain.PROCESSSTATUS_NO);//尚未处理
            ArrayList<MeetingRoomMaintainVO> list=ServiceFactory.getMeetingRoomMaintainService().query(meetingRoomMaintainVO, null);
            if(list.size()>0)
            	meetingRoomMaintainVO = list.get(0);
			UserVO user=(UserVO)this.request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			request.setAttribute("user", user);
			
//			ArrayList<MeetingDetailRoomVO> list = ServiceFactory.getMeetingDetailRoomService().getMeetingDetailRoomList(vMeetingDetailRoomVO, null);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("RoomMaintainConferenceAction	addConferenceMaintainBefore		end");
		return SUCCESS;
	}
	
	/**
	 * 添加会议记录
	 * @return
	 */
	public	String	addConferenceMaintain(){
		logger.info("RoomMaintainConferenceAction	addConferenceMaintain	begin");
		try{
			meetingDetailVO=ServiceFactory.getMeetingDetailService().queryByID(meetingRoomMaintainVO.getMaintainKey());
			
			UserVO user=(UserVO)this.request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			request.setAttribute("user", user);
			meetingRoomMaintainVO.setCreateUserID(user.getUserID());
			meetingRoomMaintainVO.setMaintainUserName(user.getName());
			meetingRoomMaintainVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);//默认状态，有效
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_CONFERENCE);//会场~会议相关
			meetingRoomMaintainVO.setProcessStatus(MeetingRoomMaintain.PROCESSSTATUS_NO);//尚未处理
			MeetingDetailRoomVO vMeetingDetailRoomVO = new MeetingDetailRoomVO();
			vMeetingDetailRoomVO.setIsmain(MeetingDetailEnum.mainVenue_valid);
			vMeetingDetailRoomVO.setMeetingDetailId(meetingRoomMaintainVO.getMaintainKey());
			ArrayList<MeetingDetailRoomVO> list = ServiceFactory.getMeetingDetailRoomService().getMeetingDetailRoomList(vMeetingDetailRoomVO, null);
			if(list.size()>0)
				meetingRoomMaintainVO.setRoomID(list.get(0).getMeetingRoomId());
			meetingRoomMaintainVO=ServiceFactory.getMeetingRoomMaintainService().add(meetingRoomMaintainVO);
            
            this.request.setAttribute("info", "添加成功");
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	addConferenceMaintain	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("RoomMaintainConferenceAction	addConferenceMaintain	end");
		return SUCCESS;
	}
	
	/**
	 * 跳转到调试记录添加页面
	 * 针对会议的记录。行为会场。
	 * @return
	 */
	public	String	addDebugConferenceMaintainBefore(){
		logger.info("VedioMeetingAction	addDebugConferenceMaintainBefore	begin");
		try {
			MeetingDetailVO debugMeetingDetailVO=ServiceFactory.getMeetingDetailService().queryByID(this.request.getParameter("debugConferenceID"));//调试会议
			this.request.setAttribute("debugMeetingDetailVO", debugMeetingDetailVO);
			
			meetingDetailVO=ServiceFactory.getMeetingDetailService().queryByID(meetingDetailVO.getMeetingDetailID());//实际召开会议
			
			dictionaryVO.setDicType(DictionaryEnum.EQUIPMENTTYPE);
			dListType = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			dictionaryVO.setDicType(DictionaryEnum.EQUIPMENTSTATUS);
			dListStatus = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			
			MeetingDetailRoomVO vMeetingDetailRoomVO = new MeetingDetailRoomVO();
			vMeetingDetailRoomVO.setMeetingDetailId(meetingDetailVO.getMeetingDetailID());
			ArrayList<MeetingDetailRoomVO> list = ServiceFactory.getMeetingDetailRoomService().getMeetingDetailRoomList(vMeetingDetailRoomVO, null);//参见会场列表
			for(MeetingDetailRoomVO vo : list){//参会会场
				vo.setListType(dListType);
				vo.setListStatus(dListStatus);
				//info1	描述
				//info2	所有检查项的及选择状态
				
				MeetingRoomMaintainVO roomMaintainVO = new MeetingRoomMaintainVO();
				roomMaintainVO.setMaintainKey(debugMeetingDetailVO.getMeetingDetailID());
				roomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
				roomMaintainVO.setRoomID(vo.getMeetingRoomId());
				roomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);
				roomMaintainVO.setProcessStatus(MeetingRoomMaintain.PROCESSSTATUS_NO);
				ArrayList<MeetingRoomMaintainVO> list3 = ServiceFactory.getMeetingRoomMaintainService().query(roomMaintainVO, null);
				for(MeetingRoomMaintainVO v : list3){//描述信息.描述信息在主表内查找
					vo.setInfo1(v.getDescription());
				}

				ArrayList<MeetingRoomMaintainVO> list2 = ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintainConference(roomMaintainVO, null);
				String	info2 = "";
				for(MeetingRoomMaintainVO v : list2){//会场的维护主表信息
					if(Integer.MIN_VALUE!=v.getMeetingRoomMaintainDetailVO().getType()){
						info2 +=v.getMeetingRoomMaintainDetailVO().getType()+"=";
					}
					if(Integer.MIN_VALUE!=v.getMeetingRoomMaintainDetailVO().getStatus()){
						info2 +=v.getMeetingRoomMaintainDetailVO().getStatus();
					}
					info2 +="-";//于页面一致
				}
				vo.setInfo2(info2);
			}
			this.request.setAttribute("list", list);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("VedioMeetingAction	addDebugConferenceMaintainBefore		end");
		return SUCCESS;
	}
	
	/**
	 * 添加调试记录
	 * @return
	 */
	public	String	addDebugConferenceMaintain(){
		logger.info("VedioMeetingAction	addDebugConferenceMaintain	begin");
		try{
//			meetingRoomMaintainVO.getMaintainKey() 调试的会议ID
			//meetingDetailVO.getMeetingDetailID();//真实会议ID
			String	des	=	meetingRoomMaintainVO.getDescription();//描述
			String	roomIDs	=	meetingRoomMaintainVO.getRoomID();//会场列表ID已”, “分割8a8188f64461dc0f014461dde66e0004, 8a8188fe442e28fc01442e2c96210005
			String	detailOption = meetingRoomMaintainVO.getMaintainUserName();// 3=2-2=2, 3=2-2=2
			
			MeetingRoomMaintainDAO.deleteByKey(meetingRoomMaintainVO.getMaintainKey(), MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL+"", null);//删除历史记录
			
			UserVO user=(UserVO)this.request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			
			if(roomIDs!=null){
				String[] str	=	roomIDs.split(", ");
				if(str!=null){
					for(int i=0;i<str.length;i++){
						MeetingRoomMaintainVO	innertVO	=	new MeetingRoomMaintainVO();
						if(str[i]==null||str[i].trim().length()==0) continue;
						innertVO.setCreateUserID(user.getUserID());
						innertVO.setMaintainUserName(user.getName());
						innertVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
						innertVO.setStatus(MeetingRoomMaintain.STATUS_VALID);//默认状态，有效
						innertVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);//会场~会议相关
						innertVO.setProcessStatus(MeetingRoomMaintain.PROCESSSTATUS_NO);//尚未处理
						innertVO.setRoomID(str[i]);
						innertVO.setMaintainKey(meetingRoomMaintainVO.getMaintainKey());
						if(des!=null){//添加描述。描述信息存储在维护主表内
							String[] descr = des.split(", ");
							if(descr!=null&&descr.length>i&&descr[i]!=null&&descr[i].trim().length()!=0){
								innertVO.setDescription(descr[i]);
							}
						}
						
						MeetingRoomMaintainVO	newmeetingRoomMaintainVO=ServiceFactory.getMeetingRoomMaintainService().add(innertVO);//添加会议于会议室关联
						
						//会议室详细记录项
						MeetingRoomMaintainDetailVO	detailVO=new MeetingRoomMaintainDetailVO();
						detailVO.setMaintainID(newmeetingRoomMaintainVO.getMaintainID());
						if(detailOption!=null&&detailOption.trim().length()!=0){//添加会议室详细检查项
							String[] detail = detailOption.split(", ");
							if(detail!=null&&detail.length>i&&detail[i]!=null&&detail[i].trim().length()!=0){
								String[] maintainDetail	=	detail[i].split("-");//一个会议室内的多个检查项。格式：3=2-2=2
								for(int j=0;j<maintainDetail.length;j++){
									if(maintainDetail==null||maintainDetail[j]==null||maintainDetail[j].trim().length()==0)	continue;
									
									String[] checkOption =	maintainDetail[j].split("=");
									if(checkOption==null||checkOption[0]==null||checkOption[0].trim().length()==0) continue;
									if(checkOption==null||checkOption[1]==null||checkOption[1].trim().length()==0) continue;
									DictionaryVO	dVO	=	new DictionaryVO();
									dVO.setDicType(DictionaryEnum.EQUIPMENTTYPE);
									dVO.setDicValue(checkOption[0]);
									
									ArrayList<DictionaryVO> list = ServiceFactory.getDictionaryService().query(dVO, null);
									if(list!=null&&list.size()==1){
										dVO = list.get(0);
										detailVO.setType(Integer.valueOf(dVO.getDicValue()).intValue());
										detailVO.setMaintainName(dVO.getDicViewName());
									}else{
										logger.warn("数据字典维护项配置不准确");
									}
									
									DictionaryVO	dVO2	=	new DictionaryVO();
									dVO2.setDicType(DictionaryEnum.EQUIPMENTSTATUS);
									dVO2.setDicValue(checkOption[1]);
									ArrayList<DictionaryVO> list2 = ServiceFactory.getDictionaryService().query(dVO2, null);
									if(list2!=null&&list2.size()==1){
										dVO = list2.get(0);
										detailVO.setStatus(Integer.valueOf(dVO.getDicValue()).intValue());
										detailVO.setDescription(dVO.getDicViewName());
									}else{
										logger.warn("数据字典维护项状态配置不准确");
									}
									
									if(des!=null){//添加描述
										String[] descr = des.split(", ");
										if(descr!=null&&descr.length>i&&descr[i]!=null&&descr[i].trim().length()!=0){
											detailVO.setQuestionDes(descr[i]);
										}
									}
									ServiceFactory.getMeetingRoomMaintainDetailService().add(detailVO);
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			logger.error("VedioMeetingAction	addDebugConferenceMaintain	error:"+e.getMessage());
			return "failure_meeting";
		} 
		logger.info("VedioMeetingAction	addDebugConferenceMaintain	end"+SUCCESS);
		return SUCCESS;
	}
	
	/**
	 * 查询单位维护情况列表
	 * @return
	 */
	public String manageRoomMaintainConference(){
		logger.info("RoomMaintainConferenceAction	manageRoomMaintainConference	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
			meetingRoomMaintainVOList=ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintain(meetingRoomMaintainVO, pSplittor.getPControler());
		
			dictionaryVO.setDicType(DictionaryEnum.EQUIPMENTTYPE);
			dListType = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			dictionaryVO.setDicType(DictionaryEnum.EQUIPMENTSTATUS);
			dListStatus = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	manageRoomMaintainConference	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("RoomMaintainConferenceAction	manageRoomMaintainConference	end");
		return SUCCESS;
	}
	
	/**
	 * 根据maintainID和detailID查询会议室具体设备的维护详情(会议)
	 * @return
	 */
	public	String	roomMaintainConferenceDetail(){
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceDetail	begin");
		try{
			meetingRoomMaintainVOList = ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintainConference(meetingRoomMaintainVO, null);
			if(meetingRoomMaintainVOList!=null&&meetingRoomMaintainVOList.size()>0){
				meetingRoomMaintainVO = meetingRoomMaintainVOList.get(0);
			}
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	roomMaintainConferenceDetail	error:"+e.getMessage());
			this.request.setAttribute("failure_message","该设备维护记录已经不存在！");
			return "failure_meeting";
		}
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceDetail	end");
		return SUCCESS;
	}
	
	/**
	 * 根据maintainID查询会议室具体设备的维护详情(会议)
	 * @return
	 */
	public	String	roomMaintainConferenceDetailNew(){
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceDetailNew	begin");
		try{
			
			ArrayList<MeetingRoomMaintainVO> list = ServiceFactory.getMeetingRoomMaintainService().query(meetingRoomMaintainVO, null);
			if(list!=null&&list.size()>0){
				meetingRoomMaintainVO = new MeetingRoomMaintainVO();
				meetingRoomMaintainVO.setMaintainID(list.get(0).getMaintainID());
				meetingRoomMaintainVOList = ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintainConference(meetingRoomMaintainVO, null);
				String meetingRoomName = meetingRoomMaintainVOList.get(0).getMeetingRoomVO().getMeetingRoomName();
				String meetingName = meetingRoomMaintainVOList.get(0).getMeetingDetailVO().getMeetingName();
				String maintainUserName = meetingRoomMaintainVOList.get(0).getMaintainUserName();
				this.request.setAttribute("createTime", meetingRoomMaintainVOList.get(0).getCreateTime());
				this.request.setAttribute("maintainUserName", maintainUserName);//检查人
				this.request.setAttribute("meetingRoomName", meetingRoomName);//会场名称
				this.request.setAttribute("meetingName", meetingName);//会议名称
				this.request.setAttribute("mrList", meetingRoomMaintainVOList);	
			}
			
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	roomMaintainConferenceDetailNew	error:"+e.getMessage());
			this.request.setAttribute("failure_message","该设备维护记录已经不存在！");
			return "failure_meeting";
		}
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceDetailNew	end");
		return SUCCESS;
	}
	
	/**
	 * 添加会议室维护信息前(会议)
	 * @return
	 */
	public String	roomMaintainConferenceAddBefore(){
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceAddBefore	begin");
		try {
			MeetingDetailVO vMeetingDetailVO=new MeetingDetailVO();
			vMeetingDetailVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
			String meetingRoomID=meetingDetailVO.getMeetingRoomID();
			meetingDetailVO=ServiceFactory.getMeetingDetailService().query(vMeetingDetailVO, null).get(0);
					
			
			String ip = request.getParameter("ip");
			if(ip!=null&&!"".equals(ip)){
				request.setAttribute("addType", 1);//在会议控制页面进行新增会场设备的维护记录（适用于会议中）
				EquipmentVO equipmentVO = new EquipmentVO();
				List<EquipmentVO> eList = new ArrayList<EquipmentVO>();
				equipmentVO.setIp(ip);
				eList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
				if(eList!=null&&eList.size()>0){
					meetingRoomVO = eList.get(0).getMeetingRoomVO();
				}else{
					this.request.setAttribute("failure_message","1、请确认此会场是否在系统中注册<br />2、请确认是否为会场，而不是级联点！");
					return "failure_meeting";
				}
			}else{
				request.setAttribute("addType", 2);//在会议管理页面进行新增会场设备的维护记录（适用于会议前、后）
			}
			
			if(meetingRoomID!=null&&!"".equals(meetingRoomID)){
				request.setAttribute("addType", 1);
				MeetingRoomVO tempMrv=new MeetingRoomVO();
				tempMrv.setMeetingRoomID(meetingRoomID);
				List<MeetingRoomVO> eList = ServiceFactory.getMeetingRoomService().query(tempMrv, null);
				if(eList!=null&&eList.size()>0){
					meetingRoomVO = eList.get(0);
				}
			}
			dictionaryVO.setDicType(DictionaryEnum.EQUIPMENTTYPE);
			dListType = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			dictionaryVO.setDicType(DictionaryEnum.EQUIPMENTSTATUS);
			dListStatus = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			if(dListType==null||dListType.size()<=0||dListStatus==null||dListStatus.size()<=0){
				this.request.setAttribute("failure_message","设备维护类型以及设备状态都必须配置！");
				return "failure_meeting";
			}
			//meetingRoomVOList=ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceAddBefore	end");
		return SUCCESS;
	}
	/**  
	 * 会管管理功能下的会场记录
	 * 添加保存会议室维护信息(会议)
	 * @return
	 */
	public	String	roomMaintainConferenceAdd_list(){
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceAdd	begin");
		try{
			HashMap<String, String> map = this.getEquipmentStatus();
            if(map.size()<=0){//设备状态在dictionary表内不能配置为空
            	this.request.setAttribute("failure_message","设备状态必须配置！");
				return "failure_meeting";
            }
			
			UserVO user=(UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			meetingRoomMaintainVO.setCreateUserID(user.getUserID());
			meetingRoomMaintainVO.setMaintainUserName(user.getName());
			meetingRoomMaintainVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);//默认状态，有效
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);//会场~会议相关
			meetingRoomMaintainVO.setProcessStatus(MeetingRoomMaintain.PROCESSSTATUS_NO);//尚未处理
			
            meetingRoomMaintainVO=ServiceFactory.getMeetingRoomMaintainService().add(meetingRoomMaintainVO);
			
			String maintainID=meetingRoomMaintainVO.getMaintainID();
			int equipmentTypeSize = Integer.parseInt(request.getParameter("equipmentTypeSize"));
			for(int i=0;i<=equipmentTypeSize;i++){
				meetingRoomMaintainDetailVO=new MeetingRoomMaintainDetailVO();
				meetingRoomMaintainDetailVO.setMaintainID(maintainID);
				meetingRoomMaintainDetailVO.setMaintainName(request.getParameter("maintainName"+i));
				meetingRoomMaintainDetailVO.setType(Integer.parseInt(request.getParameter("type"+i)));
				meetingRoomMaintainDetailVO.setStatus(Integer.parseInt(request.getParameter("status"+i)));
				meetingRoomMaintainDetailVO.setDescription(map.get(""+meetingRoomMaintainDetailVO.getStatus()));
				meetingRoomMaintainDetailVO.setQuestionDes(request.getParameter("questionDes"+i));
				ServiceFactory.getMeetingRoomMaintainDetailService().add(meetingRoomMaintainDetailVO);
//				meetingRoomMaintainDetailVO.setRevision(0);//默认为0
//				meetingRoomMaintainDetailVO.setDescription("");//
			}
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	roomMaintainConferenceAdd	error:"+e.getMessage());
		} 
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceAdd	end");
		return SUCCESS;
	}
	
	/**  
	 * 确认功能下的会场记录
	 * 添加保存会议室维护信息(会议)
	 * @return
	 */
	public	String	roomMaintainConferenceAdd(){
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceAdd	begin");
		try{
			HashMap<String, String> map = this.getEquipmentStatus();
            if(map.size()<=0){//设备状态在dictionary表内不能配置为空
            	this.request.setAttribute("failure_message","设备状态必须配置！");
				return "failure_meeting";
            }
			
			UserVO user=(UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			meetingRoomMaintainVO.setCreateUserID(user.getUserID());
			meetingRoomMaintainVO.setMaintainUserName(user.getName());
			meetingRoomMaintainVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);//默认状态，有效
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);//会场~会议相关
			meetingRoomMaintainVO.setProcessStatus(MeetingRoomMaintain.PROCESSSTATUS_NO);//尚未处理
			
            meetingRoomMaintainVO=ServiceFactory.getMeetingRoomMaintainService().add(meetingRoomMaintainVO);
			
			String maintainID=meetingRoomMaintainVO.getMaintainID();
			int equipmentTypeSize = Integer.parseInt(request.getParameter("equipmentTypeSize"));
			for(int i=0;i<=equipmentTypeSize;i++){
				meetingRoomMaintainDetailVO=new MeetingRoomMaintainDetailVO();
				meetingRoomMaintainDetailVO.setMaintainID(maintainID);
				meetingRoomMaintainDetailVO.setMaintainName(request.getParameter("maintainName"+i));
				meetingRoomMaintainDetailVO.setType(Integer.parseInt(request.getParameter("type"+i)));
				meetingRoomMaintainDetailVO.setStatus(Integer.parseInt(request.getParameter("status"+i)));
				meetingRoomMaintainDetailVO.setDescription(map.get(""+meetingRoomMaintainDetailVO.getStatus()));
				meetingRoomMaintainDetailVO.setQuestionDes(request.getParameter("questionDes"+i));
				ServiceFactory.getMeetingRoomMaintainDetailService().add(meetingRoomMaintainDetailVO);
//				meetingRoomMaintainDetailVO.setRevision(0);//默认为0
//				meetingRoomMaintainDetailVO.setDescription("");//
			}
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	roomMaintainConferenceAdd	error:"+e.getMessage());
		} 
		logger.info("RoomMaintainConferenceAction	roomMaintainConferenceAdd	end");
		return null;
	}

	/**
	 * 根据id删除会议室信息~假删(会议)
	 * @return
	 */
	public	String	deleteRoomMaintainConference(){
		logger.info("RoomMaintainConferenceAction	deleteRoomMaintainConference	begin");
	
		try {
			meetingRoomMaintainVO	=	ServiceFactory.getMeetingRoomMaintainService().queryByID(meetingRoomMaintainVO.getMaintainID());
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_INVALID);
			ServiceFactory.getMeetingRoomMaintainService().deleteByID(meetingRoomMaintainVO);
		} catch (Exception e) {
			logger.error("RoomMaintainConferenceAction	deleteRoomMaintainConference	error:"+e.getMessage());
		}
		logger.info("RoomMaintainConferenceAction	deleteRoomMaintainConference	end");
		return	SUCCESS;
	}
	/**
	 * 获取会议室地址目录
	 * @return
	 */
	/*public ArrayList<AddressVO> getRoomAdressList(){
		ArrayList<AddressVO>  list_address = new ArrayList<AddressVO>();
		try {
			list_address = ServiceFactory.getAddressService().query(new AddressVO(),null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_address;
	}*/
	public ArrayList<MeetingRoomVO>  getMeetingRoomByAddress(String addressID){
		ArrayList<MeetingRoomVO>  list_room = new ArrayList<MeetingRoomVO>();
		AddressVO advo = new AddressVO();
		MeetingRoomVO mrvo = new MeetingRoomVO();
		advo.setAddressID(addressID);
		try {
			mrvo.setAddressVO(advo);
			list_room =	ServiceFactory.getMeetingRoomService().query(mrvo, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_room;
	}

	/**
	 *  返回设备状态的map(key对应dictionary表内的dicValue,value对应表内的dicViewName)
	 * @return
	 */
	public HashMap<String, String> getEquipmentStatus(){
		dictionaryVO.setDicType(DictionaryEnum.EQUIPMENTSTATUS);
		HashMap<String, String> map = new HashMap<String, String>();
		try {
			dListStatus = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
			if(dListStatus!=null&&dListStatus.size()>0){
				for(int i=0;i<dListStatus.size();i++){
					map.put(dListStatus.get(i).getDicValue(), dListStatus.get(i).getDicViewName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public String exportQuery(){
		logger.info("RoomMaintainConferenceAction	exportQuery	begin");
		try{
			
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
			meetingRoomMaintainVOList=ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintain(meetingRoomMaintainVO, null);
		    Set<String> meetingDetialIds=new HashSet<String>();
		    System.out.println("============1==============");
		    for(MeetingRoomMaintainVO mrv:meetingRoomMaintainVOList){
		    	meetingDetialIds.add(mrv.getMaintainKey());
		    }
		    System.out.println("============2===============");
		    Map<String,List<MeetingRoomMaintainVO>> termMap=new HashMap<String,List<MeetingRoomMaintainVO>>();
		    for(String mdid:meetingDetialIds){
		    	List<MeetingRoomMaintainVO> tList=new ArrayList<MeetingRoomMaintainVO>();
		    	 for(MeetingRoomMaintainVO mrv:meetingRoomMaintainVOList){
		    		 System.out.println(mdid+"==============="+mrv.getMeetingDetailVO().getMeetingDetailID());
		    		 if(mrv.getMaintainKey().equals(mdid)){
		    			 tList.add(mrv);
		    		 }
		    		
		    	 }
		    	 System.out.println("=====================3======================");
		    	 termMap.put(mdid, tList);
		    }  
		    
		    System.out.println("=============================================");
		    String fileName = "roomMaintain.xls";
			 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName));
			int sIndex=0;
			 for(String mdid:meetingDetialIds){
			List<MeetingRoomMaintainVO> tList=termMap.get(mdid);	 
			 WritableSheet sheet  =  book.createSheet(tList.get(0).getMeetingDetailVO().getMeetingName() ,  sIndex );
			 sIndex++;
			 int ci=0;
			 for(MeetingRoomMaintainVO mmv:tList){
			MeetingRoomMaintainVO serchmmVO=new MeetingRoomMaintainVO();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//按指定格式显示时间。
			serchmmVO.setStatus(MeetingRoomMaintain.STATUS_VALID);
			serchmmVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
			serchmmVO.setMaintainID(mmv.getMeetingRoomMaintainDetailVO().getMaintainID());
			serchmmVO.setMaintainKey(mmv.getMaintainKey());
			serchmmVO.setRoomID(mmv.getRoomID());
			meetingRoomMaintainVOList=ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintainConference(serchmmVO, null);
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
		
		
			 WritableCellFormat wcfColor = new WritableCellFormat();
			 wcfColor.setBackground(Colour.GRAY_25);
			 if(meetingRoomMaintainVOList!=null&&meetingRoomMaintainVOList.size()>0){
				 sheet.addCell(new Label(0 ,ci,"会议名称:",wcfColor));
				
				 
				 sheet.addCell(new Label(1 ,ci,meetingRoomMaintainVOList.get(0).getMeetingDetailVO().getMeetingName())); 
				 sheet.addCell(new Label(2 ,ci,"会场名称:",wcfColor)); 
				 sheet.addCell(new Label(3 ,ci,meetingRoomMaintainVOList.get(0).getMeetingRoomVO().getMeetingRoomName())); 
				 ci++;
				 sheet.addCell(new Label(0 ,ci,"检查人:",wcfColor)); 
				 sheet.addCell(new Label(1 ,ci,meetingRoomMaintainVOList.get(0).getMeetingDetailVO().getMeetingName())); 
				 sheet.addCell(new Label(2 ,ci,"检查时间:",wcfColor)); 
				 sheet.addCell(new Label(3 ,ci,meetingRoomMaintainVOList.get(0).getMeetingRoomVO().getMeetingRoomName())); 
				 ci++;
				 for (int i = 0; i < meetingRoomMaintainVOList.size(); i++) {
					MeetingRoomMaintainVO mVO = meetingRoomMaintainVOList.get(i);
					sheet.addCell(new Label(0,ci,mVO.getMeetingRoomMaintainDetailVO().getMaintainName()+":",wcfColor));
					String cont=mVO.getMeetingRoomMaintainDetailVO().getDescription();
					if(mVO.getMeetingRoomMaintainDetailVO().getQuestionDes()!=null&&!(mVO.getMeetingRoomMaintainDetailVO().getQuestionDes().equals(""))){
						cont+=":"+mVO.getMeetingRoomMaintainDetailVO().getQuestionDes();
					}
					sheet.addCell(new Label(1,ci,cont));
					sheet.mergeCells(1, i+2,3, ci);
					ci++;
					
				}
				 ci++;ci++;
			 }
				
			}
			 }
			 book.write();
             book.close();
			excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);// ByteArrayInputStream(excelString.getBytes(), 0, excelString.length());
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	exportQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("RoomMaintainConferenceAction	exportQuery	end");
		return SUCCESS;
	}
	
	/**
	 * 导出
	 * @return
	 */
	public String exportQuery5K(){
		logger.info("RoomMaintainConferenceAction	exportQuery	begin");
		try{
			
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
			meetingRoomMaintainVOList=ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintain(meetingRoomMaintainVO, null);
		    Set<String> meetingDetialIds=new HashSet<String>();
		    for(MeetingRoomMaintainVO mrv:meetingRoomMaintainVOList){
		    	meetingDetialIds.add(mrv.getMaintainKey());
		    }
		    Map<String,List<MeetingRoomMaintainVO>> termMap=new HashMap<String,List<MeetingRoomMaintainVO>>();
		    for(String mdid:meetingDetialIds){
		    	List<MeetingRoomMaintainVO> tList=new ArrayList<MeetingRoomMaintainVO>();
		    	 for(MeetingRoomMaintainVO mrv:meetingRoomMaintainVOList){
		    		 if(mrv.getMaintainKey().equals(mdid)){
		    			 tList.add(mrv);
		    		 }
		    		
		    	 }
		    	 termMap.put(mdid, tList);
		    }  
		     String fileName = "roomMaintain.xls";
			 WritableWorkbook book  =  Workbook.createWorkbook( new  File(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName));
			int sIndex=0;
			 for(String mdid:meetingDetialIds){
			List<MeetingRoomMaintainVO> tList=termMap.get(mdid);	 
			 WritableSheet sheet  =  book.createSheet(tList.get(0).getMeetingDetailVO().getMeetingName() ,  sIndex );
			 sIndex++;
			 sheet.getSettings().setShowGridLines(true);
			 sheet.setColumnView(0, 15);
			 sheet.setColumnView(1, 15);
			 sheet.setColumnView(2, 15);
			 sheet.setColumnView(3, 15);
			 sheet.setColumnView(4, 15);

			 int ci=0;
			 Border b=Border.ALL;
	         BorderLineStyle ls=BorderLineStyle.THIN;  
			 WritableFont font1 = new  WritableFont(WritableFont.TIMES, 12 ,WritableFont.NO_BOLD); 

			 WritableCellFormat wcfColor = new WritableCellFormat();//内容标题样式
			 wcfColor.setBackground(Colour.GRAY_25);
			 wcfColor.setBorder(b, ls);
			 wcfColor.setWrap(true);
			 
             WritableCellFormat titlColor = new WritableCellFormat(font1);//标题内容样式
             titlColor.setBorder(b, ls);
			 titlColor.setAlignment(Alignment.CENTRE);
			 
			  WritableCellFormat blankStyle = new WritableCellFormat();//空白或内容样式
			  blankStyle.setBorder(b, ls);
			  blankStyle.setAlignment(Alignment.CENTRE);
			
			 sheet.addCell(new Label(0,ci,"主会场视频会议系统情况记录表",titlColor));
			 sheet.mergeCells(0,ci,4, ci);
			 ci++;
			 sheet.addCell(new Label(0,ci,"会议名称:"+tList.get(0).getMeetingDetailVO().getMeetingName()));
			 sheet.mergeCells(0,ci,4, ci);
			 ci++;
			 sheet.addCell(new Label(0,ci,"单位名称",wcfColor));
			 sheet.addCell(new Label(1,ci,"",blankStyle)); 
			 sheet.mergeCells(1,ci,2, ci);
			 sheet.addCell(new Label(3 ,ci,"参会人数",wcfColor)); 
			 sheet.addCell(new Label(4 ,ci,"",blankStyle)); 
			 ci++;
			 sheet.addCell(new Label(0 ,ci,"填写人",wcfColor)); 
			 sheet.addCell(new Label(1 ,ci,"",blankStyle)); 
			 sheet.mergeCells(1,ci,2, ci);
			 sheet.addCell(new Label(3 ,ci,"电话",wcfColor)); 
			 sheet.addCell(new Label(4 ,ci,"",blankStyle)); 
			 ci++;
			 sheet.addCell(new Label(0 ,ci,"主会场效果",wcfColor)); 
			 sheet.addCell(new Label(1 ,ci,"画面质量",wcfColor)); 
			 sheet.addCell(new Label(2 ,ci,"",blankStyle)); 
			 sheet.addCell(new Label(3 ,ci,"声音质量",wcfColor)); 
			 sheet.addCell(new Label(4 ,ci,"",blankStyle)); 
			 ci++;
			 sheet.mergeCells(0,ci-1,0, ci);
			 sheet.addCell(new Label(1 ,ci,"灯光效果",wcfColor)); 
			 sheet.addCell(new Label(2 ,ci,"",blankStyle)); 
			 sheet.addCell(new Label(3 ,ci,"镜头效果",wcfColor)); 
			 sheet.addCell(new Label(4 ,ci,"",blankStyle)); 
			 ci++;
			 sheet.addCell(new Label(0 ,ci,"网络效果",wcfColor)); 
			 sheet.addCell(new Label(1 ,ci,"",blankStyle)); 
			 sheet.mergeCells(1,ci,2, ci);
			 sheet.addCell(new Label(3 ,ci,"是否出现故障",wcfColor)); 
			 sheet.addCell(new Label(4 ,ci,"",blankStyle)); 
			 ci++;
			 sheet.addCell(new Label(0,ci,"分会场情况记录",titlColor));
			 sheet.mergeCells(0,ci,4, ci);
			 ci++;
			 sheet.addCell(new Label(0 ,ci,"会场名称",wcfColor)); 
			 sheet.addCell(new Label(1 ,ci,"网络情况",wcfColor)); 
			 sheet.addCell(new Label(2 ,ci,"画面质量",wcfColor)); 
			 sheet.addCell(new Label(3 ,ci,"声音质量",wcfColor)); 
			 sheet.addCell(new Label(4 ,ci,"笔记本信号",wcfColor)); 
			 ci++;
			 
			 for(MeetingRoomMaintainVO mmv:tList){
			MeetingRoomMaintainVO serchmmVO=new MeetingRoomMaintainVO();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//按指定格式显示时间。
			serchmmVO.setStatus(MeetingRoomMaintain.STATUS_VALID);
			serchmmVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM_MEETINGDETAIL);
			serchmmVO.setMaintainID(mmv.getMeetingRoomMaintainDetailVO().getMaintainID());
			serchmmVO.setMaintainKey(mmv.getMaintainKey());
			serchmmVO.setRoomID(mmv.getRoomID());
			meetingRoomMaintainVOList=ServiceFactory.getMeetingRoomMaintainService().queryRoomMaintainConference(serchmmVO, null);
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
		    if(meetingRoomMaintainVOList!=null&&meetingRoomMaintainVOList.size()>0){
		    sheet.addCell(new Label(0 ,ci,mmv.getMeetingRoomVO().getMeetingRoomName(),blankStyle)); 	 
				 for (int i = 0; i < meetingRoomMaintainVOList.size(); i++) {
					MeetingRoomMaintainVO mVO = meetingRoomMaintainVOList.get(i);
					 String tileName=mVO.getMeetingRoomMaintainDetailVO().getMaintainName();
					
					 
					
					 if(tileName.equals("网络情况")){
					 sheet.addCell(new Label(1 ,ci,mVO.getMeetingRoomMaintainDetailVO().getDescription(),blankStyle)); 
					 }
					 if(tileName.equals("画面质量")){
					 sheet.addCell(new Label(2 ,ci,mVO.getMeetingRoomMaintainDetailVO().getDescription(),blankStyle)); 
					 }
					 if(tileName.equals("声音质量")){
					 sheet.addCell(new Label(3 ,ci,mVO.getMeetingRoomMaintainDetailVO().getDescription(),blankStyle)); 
					 }
					 if(tileName.equals("笔记本信号")){
					 sheet.addCell(new Label(4 ,ci,mVO.getMeetingRoomMaintainDetailVO().getDescription(),blankStyle)); 
					 }
					
					
				}
				 ci++;
			 }
				
			}
				 
			 sheet.addCell(new Label(0 ,ci,"主要故障原因分析及改进建议",wcfColor));
			 sheet.addCell(new Label(1 ,ci,"",blankStyle));
			 sheet.mergeCells(1,ci,4, ci);
			 ci++;
			 sheet.mergeCells(0,ci-1,0, ci);
			 sheet.addCell(new Label(1 ,ci,"负责人签字：                   年       月       日",blankStyle));
			 sheet.mergeCells(1,ci,4, ci);
			 ci++;
			 
		}
			
			 book.write();
             book.close();
			excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);// ByteArrayInputStream(excelString.getBytes(), 0, excelString.length());
		}catch(Exception e){
			logger.error("RoomMaintainConferenceAction	exportQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("RoomMaintainConferenceAction	exportQuery	end");
		return SUCCESS;
	}
	
	
	public MeetingRoomMaintainVO getMeetingRoomMaintainVO() {
		return meetingRoomMaintainVO;
	}

	public void setMeetingRoomMaintainVO(MeetingRoomMaintainVO meetingRoomMaintainVO) {
		this.meetingRoomMaintainVO = meetingRoomMaintainVO;
	}

	public MeetingRoomMaintainDetailVO getMeetingRoomMaintainDetailVO() {
		return meetingRoomMaintainDetailVO;
	}

	public void setMeetingRoomMaintainDetailVO(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO) {
		this.meetingRoomMaintainDetailVO = meetingRoomMaintainDetailVO;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public ArrayList<MeetingRoomMaintainVO> getMeetingRoomMaintainVOList() {
		return meetingRoomMaintainVOList;
	}

	public void setMeetingRoomMaintainVOList(
			ArrayList<MeetingRoomMaintainVO> meetingRoomMaintainVOList) {
		this.meetingRoomMaintainVOList = meetingRoomMaintainVOList;
	}

	public ArrayList<MeetingRoomVO> getMeetingRoomVOList() {
		return meetingRoomVOList;
	}

	public void setMeetingRoomVOList(ArrayList<MeetingRoomVO> meetingRoomVOList) {
		this.meetingRoomVOList = meetingRoomVOList;
	}

	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public DictionaryVO getDictionaryVO() {
		return dictionaryVO;
	}

	public void setDictionaryVO(DictionaryVO dictionaryVO) {
		this.dictionaryVO = dictionaryVO;
	}

	public ArrayList<DictionaryVO> getdListStatus() {
		return dListStatus;
	}

	public void setdListStatus(ArrayList<DictionaryVO> dListStatus) {
		this.dListStatus = dListStatus;
	}

	public ArrayList<DictionaryVO> getdListType() {
		return dListType;
	}

	public void setdListType(ArrayList<DictionaryVO> dListType) {
		this.dListType = dListType;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

}
