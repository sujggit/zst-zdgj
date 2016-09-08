package com.zzst.action.meeting.meeting;
 


import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.meetingStatic.MeetingDetialStatic;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.MeetingUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.tools.CommonUtil;
import com.zzst.application.mcuUtil.ConfManager;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOConfVO;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.mcuVO.ZZOPtsChannel;
import com.zzst.application.mcuservice.conf.ConfService;
import com.zzst.application.mcuservice.conf.ConfServiceImpl;
import com.zzst.application.meeting.mcu.operate.OperateUtil;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.meeting.dwr.CallPollThread1;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.enums.MeetingRoomEnum;
import com.zzst.model.enums.MeetingTypeEnum;
import com.zzst.model.enums.PollTerminalEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.enums.VideoconferenceEnum;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.pollTemplate.PollTemplateVO;
import com.zzst.model.meeting.pollTerminal.PollTerminalVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.levelConfig.LevelConfigServiceImpl;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;
import com.zzst.service.meeting.meetingRoom.MeetingRoomService;
import com.zzst.service.meeting.meetingRoom.MeetingRoomServiceImpl;

 

public class McuControlAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static Logger logger = CbfLogger.getLogger(McuControlAction.class.getName());
	public  String AIRPORT_REQUEST_SUCCESS="AIRPORT_REQUEST_SUCCESS";
	public MeetingDetialStatic meetingDetialStatic =new MeetingDetialStatic();
	private MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	private ArrayList<MeetingRoomVO> meetingRoomVOList = new ArrayList<MeetingRoomVO>();
	private Map<String, List<MeetingRoomVO>> meetingRoomMap = new HashMap<String, List<MeetingRoomVO>>();
	private ArrayList<MeetingDetailVO> meetingDetailList = new ArrayList<MeetingDetailVO>();
	
	private ArrayList<ZZOConfVO> confVOList = new ArrayList<ZZOConfVO>();
	
	private ZZOConfVO confVO = new ZZOConfVO();
	
	private String meetingDetailID;
	
	private String confId;
	private String pollTemplate;
	
	private ArrayList<ZZOMainStatusVO>  meetingMcuVOList = new ArrayList<ZZOMainStatusVO>();
	private Vector<ZZOMainStatusVO> meetingRoomVector = new Vector<ZZOMainStatusVO>();
	private List<ZZOPtsChannel> ptsChannelVOList = new ArrayList<ZZOPtsChannel>();
	
	private ZZOMainStatusVO zzoMainStatusVO = new ZZOMainStatusVO();
	
	private String monitor;
	private String type;
	
	private String menuManager;
	public ArrayList<ZZOMainStatusVO> getMeetingMcuVOList() {
		return meetingMcuVOList;
	}

	public void setMeetingMcuVOList(ArrayList<ZZOMainStatusVO> meetingMcuVOList) {
		this.meetingMcuVOList = meetingMcuVOList;
	}

	public String getClassifiedRoomList(){
		logger.info("PolyComAction		getClassifiedRoomList	begin");
		
		try {
			///////////////////////////按钮控制 zjy 2013-10-10//////////////
			DictionaryVO dictionaryVO = new DictionaryVO();
			dictionaryVO.setDicType(DictionaryEnum.CONTROLMENU);
			Set<String> menus=new HashSet<String>();
			List<DictionaryVO> dList = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
		    for(DictionaryVO dv:dList){
		    	menus.add(dv.getDicViewName());
		    	menus.add(dv.getDescription());
		    }
		    menuManager="";
		    for(String str:menus){
		    	menuManager+="|"+str+"|";
		    }
			////////////////////////////////////////////////////////////////
			String chooseMeetingNumber = request.getParameter("chooseMeetingNumber");
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
			vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			
			////////////////////////@author:zhangjy @date:2013-12-23 控制页面会议分级分权////////////////////		
			if(MeetingAppConfig.LEVEL_IS_POEN){
				UserVO pUserVO = (UserVO) request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
					if(!(pUserVO.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					LevelConfigServiceImpl lcs=new LevelConfigServiceImpl();
					vMeetingDetailVO.setOpenlevel(true);
					vMeetingDetailVO.setLvoids(lcs.queryByTypeAndLid(pUserVO.getLvoids(),LevelEnum.LEVEL_USER));
				}
			}
			////////////////////////////////////////////end//////////////////////////////////////////////////
			meetingDetailList = meetingDetailService.getMeetingListForToday(vMeetingDetailVO, null);
			
			if (meetingDetailList == null || meetingDetailList.size() == 0) {
//				info = "没有正在开的会";
				return REQUEST_SUCCESS;
			}
			
				// 根据选择的会议ID，取会议的信息
				MeetingDetailVO detailVO = null;
				if (chooseMeetingNumber == null || chooseMeetingNumber.length() <= 0) {
					detailVO = (MeetingDetailVO) meetingDetailList.get(0);
				} else {
					for (MeetingDetailVO v : meetingDetailList) {
						if (chooseMeetingNumber.equals(v.getMeetingDetailID())) {
							detailVO = v;
						}
					}
					if(detailVO == null){
						detailVO = (MeetingDetailVO) meetingDetailList.get(0);
					}
				}
				chooseMeetingNumber = detailVO.getMeetingDetailID() + "";
			ConfManager confManager = ZZOMcuFactory.getInstance().getConfManager();

			confVO.setConfFlagId(detailVO.getMeetingDetailID());
			List<ZZOConfVO> confList = confManager.getConfList(confVO);
			if(confList!=null){			
			for(int i=0;i<confList.size();i++){
				if(confList.get(i).getIsMasterConf()==1){
					confVO = confList.get(i);
				}
			}
			}
			request.setAttribute("chooseMeetingNumber", chooseMeetingNumber);
			meetingDetailVO.setMeetingDetailID(chooseMeetingNumber);
//			MeetingMcuVO meetingMcuVO = new MeetingMcuVO();
//			meetingMcuVO.setMeetingDetailID(Integer.parseInt(chooseMeetingNumber));
//			MeetingMcuService meetingMcuService = new MeetingMcuServiceImpl();
//			List<MeetingMcuVO> meetingMcuVOList = meetingMcuService.getMeetingMcuList(meetingMcuVO, null);
			meetingDetialStatic=MeetingDetialStatic.getMeetingListStaticList(meetingDetailVO.getMeetingDetailID());
			Vector<ZZOMainStatusVO> confRoomVector = new Vector<ZZOMainStatusVO>();
			confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailVO.getMeetingDetailID());
			
			int count = 0;
			int subCount=0;
			if(confRoomVector!=null){
			for(int i=0;i<confRoomVector.size();i++){
				if(confRoomVector.get(i) != null && confRoomVector.get(i).getConnectStatus() != null && confRoomVector.get(i).getConnectStatus()==1){
					 count++;
				}
			}
			subCount = confRoomVector.size();
			}
			request.setAttribute("chooseMeetingNumber", meetingDetailVO.getMeetingDetailID());
			request.setAttribute("confRoomVector", confRoomVector);
			
			request.setAttribute("endTime", detailVO.getMeetingEndTime().toString());
				
			request.setAttribute("meetingRoomCount", count+"/"+subCount);
			/*
			ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				meetingDetailVO = meetingDetailVOList.get(0);
				if(MeetingTypeEnum.isPolycomMeeting(meetingDetailVO.getMeetingType()) && ZZOMcuFactory.getInnerConfPts().mainStatusMap.size() > 0){
					 Vector<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInnerConfPts().mainStatusMap.get(meetingDetailVO.getMeetingDetailID());
					
//					String videoMode = "";
//					ConfVO confVO = new ConfVO();
//					confVO.setMeetingDetailID(meetingDetailVO.getMeetingDetailID());
//					List<ConfVO> confVOList = new ConfServiceImpl().getConfList(confVO, null);
//					if(confVOList != null && confVOList.size() > 0){
//						if(confVOList.size() == 1){
//							videoMode = confVOList.get(0).getVideoMode();
//						}else{
//							boolean isFound = false;
//							for(ConfVO conf : confVOList){
//								if(conf.getLayoutMode() != null && !conf.getLayoutMode().trim().equals(MCUConfig.LAYOUT_MODE_101)){
//									isFound = true;
//									videoMode = conf.getVideoMode();	
//								}
//							}
//							if(!isFound){
//								videoMode = MCUConfig.LECTURE;
//							}
//						}
//					}
//					request.setAttribute("videoMode", videoMode);
					request.setAttribute("meetingDetailList", meetingDetailList);
				//	request.setAttribute("meetingRoomMap", meetingRoomMap);
					request.setAttribute("confRoomVector", confRoomVector);
				}
				
			}
			*/
			//// operatorEnd();
		}catch(Exception e){
			request.setAttribute("info", "获取会议室列表时发生异常！");
			logger.error(e.getMessage());
			e.printStackTrace();
			return REQUEST_FAILURE;
		}
		
		logger.info("PolyComAction		getClassifiedRoomList	end");
		String flag = request.getParameter("flag");
		if(flag != null && flag.trim().equals(AIRPORT_REQUEST_SUCCESS)){
			return AIRPORT_REQUEST_SUCCESS;
		}
		return REQUEST_SUCCESS;
	}
		
	public String manageMeetingList() {
		PageSplittor pageSplittor = PageSplittor.getPageSplittor(request);
		logger.info("MeetingAction		manageMeetingListFor	begin");
		
		try {
			List<ZZOConfVO> confVOList = new ArrayList<ZZOConfVO>();	
				MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
				MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
				vMeetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
				meetingDetailList = meetingDetailService.getMeetingListForToday(vMeetingDetailVO, pageSplittor.getPControler());
				if(meetingDetailList != null && meetingDetailList.size() > 0){
					List<ZZOConfVO> oldConfList = null;
					for(MeetingDetailVO meetingDetail : meetingDetailList){
						oldConfList = ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(meetingDetail.getMeetingDetailID());
						if(oldConfList != null && oldConfList.size() > 0){
							confVOList.addAll(oldConfList);
						}
					}
				}
				request.setAttribute("confVOList", confVOList);
		}catch(Exception e){
			request.setAttribute("info", "显示会议时发生异常！");
			
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("MeetingAction		manageMeetingListFor	end");
		return REQUEST_SUCCESS;
	}
	
	//ADD MEETINGROOM
	public String getOtherRoomList(){
		logger.info("PolyComAction		getOtherRoomList	end");
		try{
			// operatorBegin();
			String chooseMeetingNumber = request.getParameter("chooseMeetingNumber");
			request.setAttribute("chooseMeetingNumber", chooseMeetingNumber);
			meetingDetailVO.setMeetingDetailID(chooseMeetingNumber);
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				meetingDetailVO = meetingDetailVOList.get(meetingDetailVOList.size() - 1);
				if(MeetingTypeEnum.isPolycomMeeting(meetingDetailVO.getMeetingType())){
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
					meetingRoomVO.setStatus(MeetingRoomEnum.ROOM_STATUS_VALID);
					MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
					ArrayList<MeetingRoomVO> allMeetingRoomVOList = meetingRoomService.query(meetingRoomVO, null);
					if(allMeetingRoomVOList != null && allMeetingRoomVOList.size() > 0){
						Vector<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailVO.getMeetingDetailID());
						if(confRoomVector != null && confRoomVector.size() > 0){
							boolean isExisted = false;
							for(MeetingRoomVO meetingRoom : allMeetingRoomVOList){
								isExisted = false;
								for(ZZOMainStatusVO confRoom : confRoomVector){
									if(confRoom != null && meetingRoom.getMeetingRoomName() != null && meetingRoom.getMeetingRoomName().equals(confRoom.getMcu_participant_name())){
										isExisted = true;
										break;
									}
								}
								if(!isExisted){
									meetingRoomVOList.add(meetingRoom);
								}
							}
						}
					}
				}
			}
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取会议室列表时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		} 
		
		logger.info("PolyComAction		getOtherRoomList	end");
//		return REQUEST_SUCCESS;
//		return "REQUEST_MGC50_SUCCESS";
		return "REQUEST_CASCADE_SUCCESS";
	}
	
	
	/**
	 * poll meeting rooms
	 * @return
	 * @author wangle
	 * @since Feb 8, 2010
	 */
	public String pollMeetingRoomList(){
		logger.info("MeetingAction		pollMeetingRoomList	end");
		try{
			String chooseMeetingNumber = request.getParameter("chooseMeetingNumber");
			request.setAttribute("chooseMeetingNumber", chooseMeetingNumber);
			meetingDetailVO.setMeetingDetailID(chooseMeetingNumber);
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			ArrayList<MeetingDetailVO> meetingDetailVOList = meetingDetailService.getMeetingDetailList(meetingDetailVO, null);
			if(meetingDetailVOList != null && meetingDetailVOList.size() > 0){
				meetingDetailVO = meetingDetailVOList.get(meetingDetailVOList.size() - 1);
				if(MeetingTypeEnum.isPolycomMeeting(meetingDetailVO.getMeetingType())){
					MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					meetingRoomVO.setMeetingRoomType(MeetingRoomEnum.ROOM_TYPE_VEDIO);
					meetingRoomVO.setStatus(MeetingRoomEnum.ROOM_STATUS_VALID);
					MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
					ArrayList<MeetingRoomVO> allMeetingRoomVOList = meetingRoomService.query(meetingRoomVO, null);
					if(allMeetingRoomVOList != null && allMeetingRoomVOList.size() > 0){
						Vector<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailVO.getMeetingDetailID());
						for(int i=0;i<confRoomVector.size();i++){
							if(confRoomVector.get(i).getConnectStatus()!=1){
								confRoomVector.remove(i);
							}
						}
						
						request.setAttribute("meetingRoomVOList", confRoomVector);
					}
				}
			}
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ获取会议室列表时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		logger.info("MeetingAction		pollMeetingRoomList	end");
		return REQUEST_SUCCESS;
	}
	
	//分屏模式
	public String screenModelBefore(){
		try {
		if(meetingDetailID!=null && !"".equals(meetingDetailID)){
			ConfService confService = new ConfServiceImpl();
			confVO.setConfFlagId(meetingDetailID);
			confVOList = confService.getConfList(confVO, null);
			
		}
		String monitor1 ="";
		if(monitor!=null&&!"".equals(monitor)){
			monitor1 = new String(monitor.getBytes("iso-8859-1"),"utf-8");
			request.setAttribute("monitor", monitor1);
		}
		request.setAttribute("type", type);
		if(type.equals("meetingroom")){
			String[] layOutInfo = new String[3];
			String layoutIds = "";
			if(!monitor1.equals("")){
				String[] monitor2 = monitor1.split("__");
				List<ZZOMainStatusVO> mList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(meetingDetailID, monitor2[2], monitor2[1]);
				for(ZZOMainStatusVO zVO : mList){
					if(zVO.getMcu_participant_id().equals(monitor2[3])){
						layoutIds = zVO.getDescription();
					}
				}
			}
			if(!layoutIds.equals("")){
				String[] layoutId = layoutIds.split("_");
				
				String key = (String)CommonUtil.getMapKey(MeetingAppConfig.layoutMap, layoutId[0]);
				layOutInfo[0] = key;
				
				int screenCount=1;
				if(layoutId.length-1>=5&&layoutId.length-1<9){
					screenCount = 5;
				}else if(layoutId.length-1==9){
					screenCount = 9;
				}else if(layoutId.length-1>=10){
					screenCount = 10;
				}else{
					screenCount = layoutId.length-1;
				}
				layOutInfo[2] = Integer.toString(screenCount);
			}
			request.setAttribute("layOutInfo", layOutInfo);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 会议分屏&会场分屏
	 * @return
	 */
	public String screenModel(){
		
		logger.info("PolyComAction		meetingRoom	end");
		try{
			if(meetingDetailID!=null && !"".equals(meetingDetailID)){
				//ConfService confService = new ConfServiceImpl();
				confVO.setConfFlagId(meetingDetailID);
				//confVOList = confService.getConfList(confVO, null);
				List<ZZOConfVO> confVOList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
				
				if("meeting".equals(type)){
				if(confVOList != null && confVOList.size() > 0){
					for(int i=0;i<confVOList.size();i++){
						if(confId.equals(confVOList.get(i).getConfID())){
							confVO = confVOList.get(i);
						}
					}
					
					//MeetingMcuService meetingMcuService = new MeetingMcuServiceImpl();
					ZZOMainStatusVO meetingMcuVO = new ZZOMainStatusVO();
					//meetingMcuVO.setMcuMeetingID(confVO.getGuid());
					//jar包有问题，未给ID加引号
					//meetingMcuVO.setConfFlagId("'"+confVO.getConfFlagId()+"'");
					//meetingMcuVOList = meetingMcuService.getMeetingMcuList(meetingMcuVO, null);
					if(!confVO.getMcuType().equals("11")){
						ZZOMainStatusVO ptsAuto = new ZZOMainStatusVO();
						ptsAuto.setMcu_participant_id("auto");
						ptsAuto.setMcu_participant_name("自动");
						meetingMcuVOList.add(ptsAuto);
						
						ZZOMainStatusVO ptsBlank = new ZZOMainStatusVO();
						ptsBlank.setMcu_participant_id("blank");
						ptsBlank.setMcu_participant_name("空");
						meetingMcuVOList.add(ptsBlank);
						
						ZZOMainStatusVO ptsAutoscan = new ZZOMainStatusVO();
						ptsAutoscan.setMcu_participant_id("autoscan");
						ptsAutoscan.setMcu_participant_name("自动轮询");
						meetingMcuVOList.add(ptsAutoscan);
					}else{
						ZZOMainStatusVO ptsAuto = new ZZOMainStatusVO();
						ptsAuto.setMcu_participant_id("00000000000000000000000000000003");
						ptsAuto.setMcu_participant_name("自动");
						meetingMcuVOList.add(ptsAuto);
						
						ZZOMainStatusVO ptsAutoscan = new ZZOMainStatusVO();
						ptsAutoscan.setMcu_participant_id("00000000000000000000000000000002");
						ptsAutoscan.setMcu_participant_name("自动轮询");
						meetingMcuVOList.add(ptsAutoscan);
					}
					List<ZZOMainStatusVO> listOper = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(confVO.getConfFlagId(), confVO.getMcuIP(), confVO.getGuid());
					Collections.sort(listOper,Collections.reverseOrder(new McuSortByName()));
					meetingMcuVOList.addAll(listOper);
//					meetingMcuVOList.addAll(ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(confVO.getConfFlagId(), confVO.getMcuIP(), confVO.getGuid()));
					//排除不在线终端
					for(int i = 0; i < meetingMcuVOList.size(); i++){
						meetingMcuVO = meetingMcuVOList.get(i);
						if(meetingMcuVO.getMcu_participant_id() != null && (meetingMcuVO.getMcu_participant_id().equals("auto") ||  
							 meetingMcuVO.getMcu_participant_id().equals("blank") || 
							 meetingMcuVO.getMcu_participant_id().equals("autoscan") || 
							 meetingMcuVO.getMcu_participant_id().equals("00000000000000000000000000000003") ||   
							 meetingMcuVO.getMcu_participant_id().equals("00000000000000000000000000000002")  
							)){
							continue;
						}
						if(meetingMcuVO.getConnectStatus() != 1 ){
							meetingMcuVOList.remove(i);
							i--;
						}
					}
					
					ZZOConfVO zconf = new ZZOConfVO();
					zconf.setConfFlagId(meetingDetailID);
					zconf.setConfID(confId);
					List<ZZOConfVO> confVOList1 =	new ConfServiceImpl().getConfList(zconf, null);
					if(confVOList1!=null){
						zconf = confVOList1.get(0);
					
					String upLinkName = "";
					upLinkName = zconf.getLayoutConfigGuid();
					String[] configGuidArray;
					if(zconf.getMcuType().equals("11")){
						configGuidArray = OperateUtil.splitter(upLinkName, "-");
						if (zconf.getLayoutMode().equals(MCUConfig.LAYOUT_MODE_801)) {
							String idTemp = "";
							idTemp = configGuidArray[5];
							configGuidArray[5] = configGuidArray[6];
							configGuidArray[6] = idTemp;
							String idTemp1 = "";
							idTemp1 = configGuidArray[4];
							configGuidArray[4] = configGuidArray[7];
							configGuidArray[7] = idTemp1;
						}
						if (zconf.getLayoutMode().equals(MCUConfig.LAYOUT_MODE_902)|| zconf.getLayoutMode().equals(MCUConfig.LAYOUT_MODE_903)|| zconf.getLayoutMode().equals(MCUConfig.LAYOUT_MODE_904)) {
							String idTemp = "";
							idTemp = configGuidArray[6];
							configGuidArray[6] = configGuidArray[7];
							configGuidArray[7] = idTemp;
							String idTemp1 = "";
							idTemp1 = configGuidArray[8];
							configGuidArray[8] = configGuidArray[5];
							configGuidArray[5] = idTemp1;
						}
					}else{
						configGuidArray = OperateUtil.splitter(upLinkName, "_");
					}
					
					for(int i=0;i< configGuidArray.length;i++){
						
						request.setAttribute("selectItem" + (i+1), configGuidArray[i]);
					}
					}
				}
				
			
			}else{//会场分屏部分
				if(confVOList != null && confVOList.size() > 0){
					String monitor = request.getParameter("monitor");
					String[] monitorInfo = monitor.split("__");
					
					for(int i=0;i<confVOList.size();i++){
						if(monitorInfo[1].equals(confVOList.get(i).getGuid())&&monitorInfo[2].equals(confVOList.get(i).getMcuIP())){
							confVO = confVOList.get(i);
						}
					}
					ZZOMainStatusVO ptsAuto = new ZZOMainStatusVO();
					ptsAuto.setMcu_participant_id("auto");
					ptsAuto.setMcu_participant_name("自动");
					meetingMcuVOList.add(ptsAuto);
					
					ZZOMainStatusVO ptsBlank = new ZZOMainStatusVO();
					ptsBlank.setMcu_participant_id("blank");
					ptsBlank.setMcu_participant_name("空");
					meetingMcuVOList.add(ptsBlank);
					

					List<ZZOMainStatusVO> listOper = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(confVO.getConfFlagId(), confVO.getMcuIP(), confVO.getGuid());
					Collections.sort(listOper,Collections.reverseOrder(new McuSortByName()));
					meetingMcuVOList.addAll(listOper);
//					meetingMcuVOList.addAll(ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(confVO.getConfFlagId(), confVO.getMcuIP(), confVO.getGuid()));
					//排除不在线终端
					for(int i = 0; i < meetingMcuVOList.size(); i++){
					ZZOMainStatusVO	meetingMcuVO = meetingMcuVOList.get(i);
						if( meetingMcuVO.getConnectStatus() != 1 ){
							meetingMcuVOList.remove(i);
							i--;
						}
					}
					String upLinkName = "";
					for(int i=0;i<meetingMcuVOList.size();i++){
						if(meetingMcuVOList.get(i).getMcu_participant_id().equals(monitorInfo[3])){
							
							upLinkName = meetingMcuVOList.get(i).getDescription();
						}
					}
					String[] configGuidArray = upLinkName.split("_");
					
					
					for(int i=1;i< configGuidArray.length;i++){
						
						request.setAttribute("selectItem" + i, configGuidArray[i]);
					}
				}
				
			}
			}
			
			String layout_mode = request.getParameter("layout_mode");
			
			if(layout_mode!=null && !"".equals(layout_mode)&&!(confVO.getMcuType()).equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)){
				request.setAttribute("LAYOUT_MODE", MeetingAppConfig.layoutMap.get(layout_mode));
				return layout_mode;
				
			}else if(layout_mode!=null && !"".equals(layout_mode)){
				request.setAttribute("LAYOUT_MODE", MeetingAppConfig.layoutMap.get(layout_mode+"_1000"));
				return layout_mode;
			
			}
			
			
			
			
		}catch(Exception e){
			request.setAttribute("info", "获取会议室列表时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("PolyComAction		meetingRoom 	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 *get message overlay.
	 * @return
	 */
	public String getMessageOverlay() {
		logger.info("McuControlAction		getMessageOverlay	begin");
		try {
			ConfService confService = new ConfServiceImpl();
			if(OperateUtil.isAvailable(request.getParameter("confID"))){
				confVO.setConfFlagId(request.getParameter("confID"));
			}
			confVOList = confService.getConfList(confVO, null);
			
			if(OperateUtil.isAvailable(request.getParameter("confKeyId"))){
				for(ZZOConfVO tempConfVO : confVOList){
					if(tempConfVO.getConfID().equals(request.getParameter("confKeyId"))){
						confVO = tempConfVO;
						break;
					}
				}
			}
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ显示会议时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("McuControlAction		getMessageOverlay	end");
		return REQUEST_SUCCESS;
	}
	
	
	public String getMessagePageByConId() {
		logger.info("McuControlAction		getMessagePageByConId	begin");
		try {
			
			confVO.setConfID(request.getParameter("confID"));
			List<ZZOConfVO> confVOList = new ConfServiceImpl().getConfList(confVO, null);
			if(confVOList == null || confVOList.size() <= 0){
				return null;
			}
			
			confVO = confVOList.get(confVOList.size() - 1);
			
			logger.info("McuControlAction		getMessagePageByConId	end");
			if(confVO.getMcuType().equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)){//rmx1000
				return "RMX1000";
			}else{//rmx2000 4000
				return "RMX2000";
			}
		
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ显示会议时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		
		
	}
	/**
	 * 轮询时返回所有会场
	 * @return
	 */
	public String getAllMeetingRoom(){
		Vector<ZZOMainStatusVO> meetingroomVector1  =  ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
		meetingRoomVector.addAll(meetingroomVector1);
		for(int i=0;i<meetingRoomVector.size();i++){
			if(!meetingRoomVector.get(i).getConnectStatus().equals(1)||!meetingRoomVector.get(i).getCascadeRole().equals("none")){
				meetingRoomVector.remove(i);
				i--;
			}
		}
		request.setAttribute("videoMode", request.getParameter("videoMode"));
		request.setAttribute("lectureName", request.getParameter("lectureName"));
		request.setAttribute("meetingDetailId", meetingDetailID);
		return REQUEST_SUCCESS;
	}
	
	/**
	 * get participant channel status.such as package loss ...
	 */
	public String getPtsChannel() {
		logger.info("MeetingAction		getPtsChannel	begin");
		try {
			String meetingDetailID = request.getParameter("meetingDetailID");
			String ptsNameVconfGuidVmcuIp = request.getParameter("roomID");
			ptsNameVconfGuidVmcuIp = new String(ptsNameVconfGuidVmcuIp.getBytes("iso-8859-1"),"utf-8");
			setPtsChannelVOList(ZZOMcuFactory.getInstance().getMcuControlHelper().getPtsChannel(meetingDetailID, ptsNameVconfGuidVmcuIp));
			request.setAttribute("meetingDetailID", meetingDetailID);
			request.setAttribute("roomID", ptsNameVconfGuidVmcuIp);
		}catch(Exception e){
			request.setAttribute("info", "ϵͳ显示丢包时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("MeetingAction		getPtsChannel	end");
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 中航轮询取得会议信息
	 * @param meetingDetailID
	 * @author zhangjz
	 */
	public String getConfList(){
		
		confVOList = (ArrayList<ZZOConfVO>)ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(meetingDetailID);
		request.setAttribute("meetingDetailID", meetingDetailID);
		return REQUEST_SUCCESS;
	}
	
	
	
	/**
	 * 通过上一步返回会议列表
	 * @param meetingDetailID
	 * @author chenshuo
	 */
	public String getSelectConfList(){
		String meetingDetailID =  request.getParameter("meetingDetailID");
		String confList1 = request.getParameter("confList1");
		String confList2 = request.getParameter("confList2");
		String[] confListArr1 = confList1.split("_");      //第一屏confID数组
		String[] confListArr2 = confList2.split("_");      //第二屏confID数组
		ZZOConfVO confVO1 = new ZZOConfVO();
		confVO1.setConfFlagId(meetingDetailID);
		List<ZZOConfVO> conferenceList1 = new ArrayList<ZZOConfVO>();
		List<ZZOConfVO> conferenceList2 = new ArrayList<ZZOConfVO>();
		List<ZZOConfVO> conferenceAll = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO1);
		
		
		for(int i=0;i<confListArr1.length;i++){
			for(ZZOConfVO cVO : conferenceAll){
				if(cVO.getConfID().equals(confListArr1[i])){
					conferenceList1.add(cVO);
				}
			}
		}
		
		for(int i=0;i<confListArr2.length;i++){
			for(ZZOConfVO cVO : conferenceAll){
				if(cVO.getConfID().equals(confListArr2[i])){
					conferenceList2.add(cVO);
				}
			}
		}
		
		////////////
		request.setAttribute("meetingDetailID", meetingDetailID);
		request.setAttribute("conferenceList1", conferenceList1);
		request.setAttribute("conferenceList2", conferenceList2);
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 根据会议取得会场
	 * @author zhangjz
	 */
	public String getPollList(){
		String ifShow = request.getParameter("ifShow");
		String confList1 = request.getParameter("confList1");
		String confList2 = request.getParameter("confList2");
		String[] confListArr1 = confList1.split("_");      //confId数组
		String[] confListArr2 = confList2.split("_");
		ZZOConfVO confVO1 = new ZZOConfVO();
		List<ZZOConfVO> confListA = new ArrayList<ZZOConfVO>();
		List<ZZOConfVO> confListB = new ArrayList<ZZOConfVO>();
		List<ZZOMainStatusVO> tList1 = new ArrayList<ZZOMainStatusVO>();
		for(int i=0;i<confListArr1.length;i++){
			confVO1.setConfFlagId(meetingDetailID);
			confListA = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO1);
			for(ZZOConfVO cVO : confListA){
				if(cVO.getConfID().equals(confListArr1[i])){
					tList1.addAll(ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(cVO.getConfFlagId(), cVO.getMcuIP(), cVO.getGuid()));
				}
			}
		}
		
		List<ZZOMainStatusVO> tList2 = new ArrayList<ZZOMainStatusVO>();
		for(int i=0;i<confListArr2.length;i++){
			confVO1.setConfFlagId(meetingDetailID);
			confListB = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO1);
			for(ZZOConfVO cVO : confListB){
				if(cVO.getConfID().equals(confListArr2[i])){
					tList2.addAll(ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(cVO.getConfFlagId(), cVO.getMcuIP(), cVO.getGuid()));
				}
			}
		}
		tList1 = deleteAliasAndUnconnected(tList1,ifShow);
		tList2 = deleteAliasAndUnconnected(tList2,ifShow);
		request.setAttribute("meetingDetailID", meetingDetailID);
		request.setAttribute("tList1", tList1);
		request.setAttribute("tList2", tList2);
		
		/////
		request.setAttribute("confList1",confList1);
		request.setAttribute("confList2",confList2);
		
		return REQUEST_SUCCESS;
	}
	
	/**
	 * 轮询时返回所有会议
	 * @author xiongshun
	 * @return
	 */
	public String getConfList1(){
		logger.info("McuControlAction		getConfList1	begin");
		if(MeetingAppConfig.pollMap.get(meetingDetailID)==null){	//判断该会议是否正在轮询
			ZZOConfVO masterConf = new ZZOConfVO();
			if(meetingDetailID!=null && !"".equals(meetingDetailID)){
				String video_mode = request.getParameter("videoMode").trim();
				String lectureName = request.getParameter("lectureName").trim();
				if( (!"".equals(lectureName) && !"".equals(video_mode))||("".equals(lectureName)&&"LECTURE".equals(video_mode))){
					try {
						confVOList = (ArrayList<ZZOConfVO>)ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(meetingDetailID);
						if(confVOList!=null && confVOList.size()>0){
							if(video_mode.equals("LECTURE")){
								video_mode = "5";
							}
							int videoMode = Integer.parseInt(video_mode);
							String layoutMode = "";
							for(ZZOConfVO confVOListTemp:confVOList){
								if(confVOListTemp.getIsMasterConf()==1){//根据主会模式做判断
									masterConf = confVOListTemp;
									if(videoMode==1||!lectureName.equals("[None]")){
										layoutMode = confVOListTemp.getLayoutMode();
										request.setAttribute("mcuMode", VideoconferenceEnum.LECTURERMODE);//MCU的会议模式~演讲者模式
									}else if(videoMode!=1&&lectureName.equals("[None]")&&videoMode!=4){
										int hasSpeaker = 0;
										List<ZZOMainStatusVO> meetingrooms=	ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(confVOListTemp.getConfFlagId(), confVOListTemp.getMcuIP(), confVOListTemp.getGuid());
										for(ZZOMainStatusVO meetingRoom:meetingrooms){
											if(meetingRoom.getIsSpeaker()==1&&meetingRoom.getDescription().contains("_")){
												if(meetingRoom.getConnectStatus()==1){
													layoutMode =  meetingRoom.getDescription().split("_")[0];
													request.setAttribute("mcuMode", VideoconferenceEnum.PERSONALMODE);//MCU的会议模式~个人模式
												}else{
													this.request.setAttribute("failure_message","主会场终端没有在线！");
													return "failure_meeting";//轮询失败跳转到出错页面
												}
												hasSpeaker = 1;
											}
											
										}
										if(hasSpeaker == 0){
											this.request.setAttribute("failure_message","主会中未设置广播者！");
											return "failure_meeting";//轮询失败跳转到出错页面
										}
									}else if(videoMode==4){
										layoutMode = confVOListTemp.getLayoutMode();
										request.setAttribute("mcuMode", VideoconferenceEnum.SAMELAYOUTMODE);//MCU的会议模式~相同分屏模式
									}
								}
							}
							PollTemplateVO pollTemplateVO = new PollTemplateVO();
							ArrayList<PollTemplateVO> plist = ServiceFactory.getPollTemplateService().query(pollTemplateVO, null);
							
							request.setAttribute("plist", plist);
							logger.info("McuControlAction		getConfList1	end");
							if(layoutMode!=null && !"".equals(layoutMode)){
								layoutMode.trim();
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_1X1)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_1X1);
									return "PollOne";
								}
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_101)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_101);
									return "PollOne";
								}
								if(layoutMode.equals("1x2Hor")){
									request.setAttribute("LAYOUT_MODE", "1x2Hor");
									return "PollTwo";
								}
								if(layoutMode.equals("1x2Ver")){
									request.setAttribute("LAYOUT_MODE", "1x2Ver");
									return "PollTwo2";
								}
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND2HORUPPER)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_1AND2HORUPPER);
									return "PollThree";
								}
								if(layoutMode.equals("1and2Hor")){
									request.setAttribute("LAYOUT_MODE", "1and2Hor");
									return "PollThree2";
								}
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND2VER)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_1AND2VER);
									return "PollThree3";
								}
								if(layoutMode.equals("2x2")){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_2X2);
									return "PollFour";
								}
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND5)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_1AND5);
									return "PollFiveAndOne";
								}
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND7)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_1AND7);
									return "PollOneAndSeven";
								}
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_3X3)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_3X3);
									return "PollNine";
								}
								if(layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND12)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_1AND12);
									return "PollTwelveAndOne";
								}
								if(masterConf.getMcuType().equals(MCUConfig.RMX1000_EQUIPMENT_MODEL_ID)){
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_101);
									return "PollOne";
								}else{
									request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_1X1);
									return "PollOne";
								}
							}
						}
						//request.setAttribute("videoMode", request.getParameter("videoMode"));
						//request.setAttribute("lectureName", request.getParameter("lectureName"));
						//request.setAttribute("meetingDetailId", meetingDetailID);
						
						
					} catch (Exception e) {
						logger.info("McuControlAction		getConfList1	error");
						e.printStackTrace();
					}
				}
			}
		}else{
			this.request.setAttribute("failure_message","会议正在轮询中，请您等待轮训结束，或者手动结束轮询");
			return "failure_meeting";//轮询失败跳转到出错页面
		}
		return REQUEST_FAILURE;
	}
	
	/**
	 * 根据会议取得会场
	 * @author xiongshun
	 */
	public String getPollList1() {
		logger.info("McuControlAction		getPollList1	begin");
		String ifShow = request.getParameter("ifShow");
		String meetings = request.getParameter("meetings").trim();
		String layoutMode = request.getParameter("layoutMode").trim();
		String mcuMode = request.getParameter("mcuMode").trim();
		try {
			if (meetings != null && !"".equals(meetings) && layoutMode != null&& !"".equals(layoutMode)) {

				String[] pollListArr = meetings.split(",");
				int num = -1;
				String info = "";
				ZZOConfVO masterConf = new ZZOConfVO();
				List<ZZOConfVO> confList = new ArrayList<ZZOConfVO>();
				ZZOConfVO confVO = new ZZOConfVO();
				confVO.setConfFlagId(meetingDetailID);
				confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
				masterConf = MeetingUtil.getMasterConf(meetingDetailID);
				List<ZZOMainStatusVO> tList2 = new ArrayList<ZZOMainStatusVO>();
				for (int i = 0; i < pollListArr.length; i++) {
					if (!"None".equals(pollListArr[i])&& !"".equals(pollListArr[i])) {
						String[] confListArr = pollListArr[i].split("_");
						List<ZZOMainStatusVO> tList = new ArrayList<ZZOMainStatusVO>();
						for (int j = 0; j < confListArr.length; j++) {
							for (ZZOConfVO cVO : confList) {
								if (cVO.getConfID().equals(confListArr[j])) {
									if (cVO.getIsMasterConf().equals(MCUConfig.IS_MASTER_CONF)) {
										num = i + 1;
									}
									tList.addAll(ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(cVO.getConfFlagId(),cVO.getMcuIP(),cVO.getGuid()));
								}
							}
						}
						 tList = deleteAliasAndUnconnected(tList,ifShow);
						 if(pollTemplate!=null&&!"".equals(pollTemplate)){
							 tList = sortVenue(pollTemplate,tList);
						 }
						
						request.setAttribute("tList" + (i + 1), tList);
					} else {
						if (masterConf != null) {
							if(mcuMode.equals(VideoconferenceEnum.LECTURERMODE)||mcuMode.equals(VideoconferenceEnum.SAMELAYOUTMODE)){
							String layoutStr = masterConf.getLayoutConfigGuid();
							String[] layouts = layoutStr.split("_");
							if (!layouts[i].equals("auto")&& !layouts[i].equals("blank")) {
								List<ZZOMainStatusVO> tList = new ArrayList<ZZOMainStatusVO>();
								tList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(masterConf.getConfFlagId(),masterConf.getMcuIP(),masterConf.getGuid());
								for (ZZOMainStatusVO venueVO : tList) {
									if (venueVO.getMcu_participant_id().equals(layouts[i])) {
										request.setAttribute("defaultVenue"+ (i + 1), venueVO.getMcu_participant_name());
										tList2.add(venueVO);
									}
								}
							} else {
								request.setAttribute("defaultVenue" + (i + 1),layouts[i]);
							}
						}else if(mcuMode.equals(VideoconferenceEnum.PERSONALMODE)){
							String layoutStr = "";
							List<ZZOMainStatusVO> tList = new ArrayList<ZZOMainStatusVO>();
							tList = ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(masterConf.getConfFlagId(),masterConf.getMcuIP(),masterConf.getGuid());
							for(ZZOMainStatusVO vVO : tList){
								if(vVO.getIsSpeaker()==1){
									layoutStr = vVO.getDescription();
									break;
								}
							}
							if(!layoutStr.equals("")){
								String[] layouts = layoutStr.split("_");
								if (!layouts[i+1].equals("auto")&& !layouts[i+1].equals("blank")) {
								for(ZZOMainStatusVO vVO : tList){
									if(layouts[i+1].equals(vVO.getMcu_participant_id())){
										request.setAttribute("defaultVenue"+ (i + 1), vVO.getMcu_participant_name());
										tList2.add(vVO);
									}
								}
								}else{
									request.setAttribute("defaultVenue" + (i + 1),layouts[i+1]);
								}
							}
						}
						}

					}
				}
				List<ZZOMainStatusVO> tList1 = new ArrayList<ZZOMainStatusVO>();
				if (num != -1) {// 将主会列表中该会场移除
					tList1 = (ArrayList<ZZOMainStatusVO>) request.getAttribute("tList" + num);
					for (ZZOMainStatusVO vVO1 : tList2) {
						for (ZZOMainStatusVO vVO : tList1) {
							if ((vVO.getMcu_participant_id()+vVO.getMcuIp()+vVO.getMcuMeetingID()).equals(vVO1.getMcu_participant_id()+vVO1.getMcuIp()+vVO.getMcuMeetingID())) {
								tList1.remove(vVO);
								break;
							}
						}

					}
				}
				
				//从数据字典提取时间间隔

				request.setAttribute("meetingDetailID", meetingDetailID);
				request.setAttribute("mcuMode", mcuMode);
				request.setAttribute("meetings", meetings);
				logger.info("McuControlAction		getPollList1	end");
				if (pollListArr.length == 1&& layoutMode.equals(MCUConfig.LAYOUT_MODE_1X1)) {
					request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1X1);
					return "PollParticipantsOne";
				}
				if (pollListArr.length == 1&& layoutMode.equals(MCUConfig.LAYOUT_MODE_101)) {
					request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_101);
					return "PollParticipantsOne";
				}
				if (pollListArr.length == 2 && layoutMode.equals("1x2Hor")) {
					request.setAttribute("LAYOUT_MODE", "1x2Hor");
					return "PollParticipantsTwo";
				}
				
				if (pollListArr.length == 2 && layoutMode.equals("1x2Ver")) {
					request.setAttribute("LAYOUT_MODE", "1x2Ver");
					return "PollParticipantsTwo2";
				}
				if (pollListArr.length == 3&& layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND2HORUPPER)) {
					request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1AND2HORUPPER);
					return "PollParticipantsThree";
				}
				if (pollListArr.length == 3 && layoutMode.equals("1and2Hor")) {
					request.setAttribute("LAYOUT_MODE", "1and2Hor");
					return "PollParticipantsThree2";
				}
				if (pollListArr.length == 3&& layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND2VER)) {
					request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1AND2VER);
					return "PollParticipantsThree3";
				}
				if (pollListArr.length == 4 && layoutMode.equals(MCUConfig.LAYOUT_MODE_2X2)) {
					request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_2X2);
					return "PollParticipantsFour";
				}
				if (pollListArr.length == 6&& layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND5)) {
					request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1AND5);
					return "PollParticipantsFiveAndOne";
				}
				if (pollListArr.length == 9&& layoutMode.equals(MCUConfig.LAYOUT_MODE_3X3)) {
					request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_3X3);
					return "PollParticipantsNine";
				}

			}
		} catch (Exception e) {
			logger.info("McuControlAction		getPollList1	error");
			e.printStackTrace();
		}
		return REQUEST_FAILURE;
	}
	
	
	public String beforeModifyPoll(){
		String meetingDetailID = request.getParameter("meetingDetailID");
		if(MeetingAppConfig.pollMap.get(meetingDetailID)!=null){//轮询正在进行
			ZZOConfVO masterConf = new ZZOConfVO();
			String video_mode = request.getParameter("videoMode").trim();
			String lectureName = request.getParameter("lectureName").trim();
			if( (!"".equals(lectureName) && !"".equals(video_mode))||("".equals(lectureName)&&"LECTURE".equals(video_mode))){
				try {
					confVOList = (ArrayList<ZZOConfVO>)ZZOMcuFactory.getInstance().getInnerConfPts().getConfList(meetingDetailID);
					if(confVOList!=null && confVOList.size()>0){
						if(video_mode.equals("LECTURE")){
							video_mode = "5";
						}
						int videoMode = Integer.parseInt(video_mode);
						String layoutMode = "";
						for(ZZOConfVO confVOListTemp:confVOList){
							if(confVOListTemp.getIsMasterConf()==1){//根据主会模式做判断
								masterConf = confVOListTemp;
								if(videoMode==1||!lectureName.equals("[None]")){
									layoutMode = confVOListTemp.getLayoutMode();
									request.setAttribute("mcuMode", VideoconferenceEnum.LECTURERMODE);//MCU的会议模式~演讲者模式
								}else if(videoMode!=1&&lectureName.equals("[None]")&&videoMode!=4){
									int hasSpeaker = 0;
									List<ZZOMainStatusVO> meetingrooms=	ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(confVOListTemp.getConfFlagId(), confVOListTemp.getMcuIP(), confVOListTemp.getGuid());
									for(ZZOMainStatusVO meetingRoom:meetingrooms){
										if(meetingRoom.getIsSpeaker()==1&&meetingRoom.getDescription().contains("_")){
											if(meetingRoom.getConnectStatus()==1){
												layoutMode =  meetingRoom.getDescription().split("_")[0];
												request.setAttribute("mcuMode", VideoconferenceEnum.PERSONALMODE);//MCU的会议模式~个人模式
											}else{
												this.request.setAttribute("failure_message","主会场终端没有在线！");
												return "undo";//轮询失败跳转到出错页面
											}
											hasSpeaker = 1;
										}
										
									}
									if(hasSpeaker == 0){
										this.request.setAttribute("failure_message","主会中未设置广播者！");
										return "undo";//轮询失败跳转到出错页面
									}
								}else if(videoMode==4){
									layoutMode = confVOListTemp.getLayoutMode();
									request.setAttribute("mcuMode", VideoconferenceEnum.SAMELAYOUTMODE);//MCU的会议模式~相同分屏模式
								}
							}
						}
						logger.info("McuControlAction		beforeModifyPoll	end");
						
						request.setAttribute("meetingDetailID", meetingDetailID);
						
						CallPollThread1 thread =  MeetingAppConfig.pollMap.get(meetingDetailID);
						//request.setAttribute("meetings", thread.getMeetings());//会议分配情况传递到页面
						request.setAttribute("intervalTime", thread.getIntervalTime());
						String[][] terStrs = thread.getInfos();
						String[] meetings = thread.getMeetings().split(",");//会议分配情况
						////////////传递到页面已经选择的终端
						for( int i=0; i<terStrs.length; i++ ){//第几屏
							String[] terInfos = terStrs[i];//每一屏终端数组
							
							List<ZZOMainStatusVO> tList = new ArrayList<ZZOMainStatusVO>();//每一屏已选终端对象List
							
							for( int j=0; j<terInfos.length; j++ ){
								ZZOMainStatusVO zm = new ZZOMainStatusVO();
								String[] perTerInfos = terInfos[j].split("_");
								
								if( "None".equals(perTerInfos[0]) || "auto".equals(perTerInfos[0])){
									request.setAttribute("defaultVenue"+(i+1),perTerInfos[0] );
									break;
								}else{
									zm.setMcu_participant_id(perTerInfos[0]);
									zm.setMcuMeetingID(perTerInfos[1]);
									zm.setConfFlagId(perTerInfos[2]);
									zm.setMcuIp(perTerInfos[3]);
									zm.setMcu_participant_name(perTerInfos[4]);
									tList.add(zm);
								}
								
							}
							
							request.setAttribute("tList" + (i + 1), tList);
						}
						/////////会议分配情况
						ZZOConfVO confVO = new ZZOConfVO();
						confVO.setConfFlagId(meetingDetailID);
						List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
						for( int i=0; i<meetings.length; i++ ){//每一屏
							String[] meetingPerScr = meetings[i].split("_");//每一屏的会议ID数组
							
							List<ZZOMainStatusVO> tList = new ArrayList<ZZOMainStatusVO>();//每一屏终端对象List
							
							for (int j = 0; j < meetingPerScr.length; j++) {
								for (ZZOConfVO cVO : confList) {
									if (cVO.getConfID().equals(meetingPerScr[j])) {
										tList.addAll(ZZOMcuFactory.getInstance().getInnerConfPts().getMeetingMcuList(cVO.getConfFlagId(),cVO.getMcuIP(),cVO.getGuid()));
									}
								}
							}
							request.setAttribute("tAllList"+(i+1), tList);
							
						}
						
						if(layoutMode!=null && !"".equals(layoutMode)){
							layoutMode.trim();
							
							if (layoutMode.equals(MCUConfig.LAYOUT_MODE_1X1)) {
								request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1X1);
								return "PollParticipantsOne";
							}
							if (layoutMode.equals(MCUConfig.LAYOUT_MODE_101)) {
								request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_101);
								return "PollParticipantsOne";
							}
							if (layoutMode.equals("1x2Hor")) {
								request.setAttribute("LAYOUT_MODE", "1x2Hor");
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsTwo";
								return "undo";
							}
							
							if (layoutMode.equals("1x2Ver")) {
								request.setAttribute("LAYOUT_MODE", "1x2Ver");
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsTwo2";
								return "undo";
							}
							if (layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND2HORUPPER)) {
								request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1AND2HORUPPER);
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsThree";
								return "undo";
							}
							if (layoutMode.equals("1and2Hor")) {
								request.setAttribute("LAYOUT_MODE", "1and2Hor");
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsThree2";
								return "undo";
							}
							if (layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND2VER)) {
								request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1AND2VER);
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsThree3";
								return "undo";
							}
							if (layoutMode.equals(MCUConfig.LAYOUT_MODE_2X2)) {
								request.setAttribute("LAYOUT_MODE", MCUConfig.LAYOUT_MODE_2X2);
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsFour";
								return "undo";
							}
							if (layoutMode.equals(MCUConfig.LAYOUT_MODE_1AND5)) {
								request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_1AND5);
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsFiveAndOne";
								return "undo";
							}
							if (layoutMode.equals(MCUConfig.LAYOUT_MODE_3X3)) {
								request.setAttribute("LAYOUT_MODE",MCUConfig.LAYOUT_MODE_3X3);
								request.setAttribute("failure_message", "暂时不支持该分屏");
								//return "PollParticipantsNine";
								return "undo";
							}

							///////////////
							
						}
					}
					
					
					
				} catch (Exception e) {
					logger.info("McuControlAction		getConfList1	error");
					e.printStackTrace();
				}
			}
			
			return "PollParticipantsOne";
		}else{
			request.setAttribute("failure_message", "当前会议没有轮询");
			return "undo";
		}
	}
	/**
	 * 删除级联点及不在线的会场
	 * @author zhangjz
	 * @param List<ZZOMainStatusVO>
	 * @return List<ZZOMainStatusVO>
	 */
	private List<ZZOMainStatusVO> deleteAliasAndUnconnected(List<ZZOMainStatusVO> list, String ifShow){
		for(int i=0;i<list.size();i++){
			if( "true".equals(ifShow)){//需要要显示不在线终端
				if(!(null == list.get(i).getCascadeRole()||"none".equals(list.get(i).getCascadeRole()))||list.get(i).getNodeType()==2){
					list.remove(i);
					i--;
				}
			}else{
				if(!(null == list.get(i).getCascadeRole()||"none".equals(list.get(i).getCascadeRole()))||list.get(i).getConnectStatus()!=1||list.get(i).getNodeType()==2){
					list.remove(i);
					i--;
				}
			}
			
		}
		return list;
	}
	
	private List<ZZOMainStatusVO> sortVenue(String pollTemplateID,List<ZZOMainStatusVO> list){
		List<ZZOMainStatusVO> list1 = new ArrayList<ZZOMainStatusVO>();
		
		try {
		PollTerminalVO ptVO = new PollTerminalVO();
		ptVO.setPollTemplateID(pollTemplateID);
		ptVO.setOrgType(PollTerminalEnum.TER); //取得会议室节点
		List<PollTerminalVO> pollList = ServiceFactory.getPollTerminalService().queryWithEquipment(ptVO,null);
		for(PollTerminalVO pVO : pollList){
			for(int i=0;i<list.size();i++){
				if((pVO.getEquipmentVO().getIp()).equals(list.get(i).getMcu_participant_ip())){
					list1.add(list.get(i));
					list.remove(i);
					break;
				}
			}
			
		}
		list1.addAll(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list1;
	}
	/**
	 * 获取会场属性
	 * @return
	 */
	public String getMeetinRoomAttr(){
		logger.info("MeetingAction		getMeetinRoomAttr	begin");
		try {
			String meetingDetailID = request.getParameter("meetingDetailID");//conflagID
			String ptsNameVconfGuidVmcuIp = request.getParameter("roomInfo");
			ptsNameVconfGuidVmcuIp = new String(ptsNameVconfGuidVmcuIp.getBytes("iso-8859-1"),"utf-8");
			
			String[] roomInfo = ptsNameVconfGuidVmcuIp.split("__");
			
			String participantName = roomInfo[3];
			//confId = roomInfo[2];
			
			ZZOConfVO confVO=new ZZOConfVO();
			confVO.setConfFlagId(meetingDetailID);
			List<ZZOConfVO> confList = ZZOMcuFactory.getInstance().getConfManager().getConfList(confVO);
			for (ZZOConfVO cVO : confList) {
				if(cVO.getMcuIP().equals(roomInfo[2])){
					confVO=cVO;
					break;
				}
			}
			confId = confVO.getConfID();
			List<ZZOMainStatusVO> confRoomVector = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(meetingDetailID);
			for(  ZZOMainStatusVO terminal : confRoomVector ){
				if(terminal.getConfFlagId().equals(meetingDetailID) && terminal.getMcuIp().equals(confVO.getMcuIP()) && 
						terminal.getMcuMeetingID().equals(confVO.getGuid()) && terminal.getMcu_participant_id().equals(roomInfo[0])){
					zzoMainStatusVO = terminal;
					break;
				}
			}
			
			//modify by wangle 2013-06-28
			//get end point administrator
			EquipmentVO ptsVO = new EquipmentVO();
			ptsVO.setIp(zzoMainStatusVO.getMcu_participant_ip());
			ptsVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			List<EquipmentVO> ptsList = ServiceFactory.getEquipmentService().query(ptsVO, null);
			if(ptsList != null && ptsList.size() > 0){
				ptsVO = ptsList.get(0);
				request.setAttribute("ptsName", ptsVO.getUserVO().getName());
				request.setAttribute("ptsTelephone", ptsVO.getUserVO().getMobile());
				MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
				meetingRoomVO.setMeetingRoomID(ptsVO.getMeetingRoomVO().getMeetingRoomID());
				List<MeetingRoomVO> meetingRoomList = ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
				if(meetingRoomList != null && meetingRoomList.size() > 0){
					meetingRoomVO = meetingRoomList.get(0);
					request.setAttribute("meetingRoomAdminName", meetingRoomVO.getUserVO().getName());
					
					UserVO userVO = new UserVO();
					userVO.setUserID( meetingRoomVO.getUserVO().getUserID());
					List<UserVO> userList = ServiceFactory.getUserService().getUserList(userVO, null);
					if(userList != null && userList.size() > 0){
						request.setAttribute("meetingRoomAdminTelephone", userList.get(0).getMobile());
					}
				}
			}
			//get meeting room administrator
			
			
		}catch(Exception e){
			request.setAttribute("info", "获取会场属性时发生异常！");
			logger.error(e.getMessage());
			return REQUEST_FAILURE;
		}
		logger.info("MeetingAction		getMeetinRoomAttr	end");
		return REQUEST_SUCCESS;
	}
	
	public String[] splitID(String IDs){
		if(IDs == null || IDs.trim().equals("")){
			return null;
		}
		String[] result = IDs.split("-");
		return result;
	}
	
	public String[] splitName(String names){
		if(names == null || names.trim().equals("")){
			return null;
		}
		String[] result = names.split("、");
		return result;
	}
	
	public MeetingDetailVO getMeetingDetailVO() {
		return meetingDetailVO;
	}

	public void setMeetingDetailVO(MeetingDetailVO meetingDetailVO) {
		this.meetingDetailVO = meetingDetailVO;
	}

	public ArrayList<MeetingRoomVO> getMeetingRoomVOList() {
		return meetingRoomVOList;
	}

	public void setMeetingRoomVOList(ArrayList<MeetingRoomVO> meetingRoomVOList) {
		this.meetingRoomVOList = meetingRoomVOList;
	}

	public ArrayList<MeetingDetailVO> getMeetingDetailList() {
		return meetingDetailList;
	}

	public void setMeetingDetailList(ArrayList<MeetingDetailVO> meetingDetailList) {
		this.meetingDetailList = meetingDetailList;
	}
	
	public Map<String, List<MeetingRoomVO>> getMeetingRoomMap() {
		return meetingRoomMap;
	}

	public void setMeetingRoomMap(Map<String, List<MeetingRoomVO>> meetingRoomMap) {
		this.meetingRoomMap = meetingRoomMap;
	}

	public String getMeetingDetailID() {
		return meetingDetailID;
	}

	public void setMeetingDetailID(String meetingDetailID) {
		this.meetingDetailID = meetingDetailID;
	}

	public void setConfVO(ZZOConfVO confVO) {
		this.confVO = confVO;
	}

	public ZZOConfVO getConfVO() {
		return confVO;
	}

	public ArrayList<ZZOConfVO> getConfVOList() {
		return confVOList;
	}

	public void setConfVOList(ArrayList<ZZOConfVO> confVOList) {
		this.confVOList = confVOList;
	}

	public void setConfId(String confId) {
		this.confId = confId;
	}

	public String getConfId() {
		return confId;
	}

	public Vector<ZZOMainStatusVO> getMeetingRoomVector() {
		return meetingRoomVector;
	}

	public void setMeetingRoomVector(Vector<ZZOMainStatusVO> meetingRoomVector) {
		this.meetingRoomVector = meetingRoomVector;
	}

	public void setPtsChannelVOList(List<ZZOPtsChannel> ptsChannelVOList) {
		this.ptsChannelVOList = ptsChannelVOList;
	}

	public List<ZZOPtsChannel> getPtsChannelVOList() {
		return ptsChannelVOList;
	}

	public ZZOMainStatusVO getZzoMainStatusVO() {
		return zzoMainStatusVO;
	}

	public void setZzoMainStatusVO(ZZOMainStatusVO zzoMainStatusVO) {
		this.zzoMainStatusVO = zzoMainStatusVO;
	}
	
	public String getPollTemplate() {
		return pollTemplate;
	}

	public void setPollTemplate(String pollTemplate) {
		this.pollTemplate = pollTemplate;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static void main(String[] args){
		System.out.println(MCUConfig.LAYOUT_MODE_101);
		System.out.println(MCUConfig.LAYOUT_MODE_1201);
		System.out.println(MCUConfig.LAYOUT_MODE_1601);
		System.out.println(MCUConfig.LAYOUT_MODE_1AND12);
		System.out.println(MCUConfig.LAYOUT_MODE_1AND2HORUPPER);
		System.out.println(MCUConfig.LAYOUT_MODE_1AND2VER);
		System.out.println(MCUConfig.LAYOUT_MODE_1AND5);
		System.out.println(MCUConfig.LAYOUT_MODE_1AND7);
		System.out.println(MCUConfig.LAYOUT_MODE_1X1);
		System.out.println(MCUConfig.LAYOUT_MODE_1X2);
		System.out.println(MCUConfig.LAYOUT_MODE_201);
		System.out.println(MCUConfig.LAYOUT_MODE_2AND8);
		System.out.println(MCUConfig.LAYOUT_MODE_2X1);
		System.out.println(MCUConfig.LAYOUT_MODE_2X2);
		System.out.println(MCUConfig.LAYOUT_MODE_305);
		System.out.println(MCUConfig.LAYOUT_MODE_3X3);
		System.out.println(MCUConfig.LAYOUT_MODE_401);
		System.out.println(MCUConfig.LAYOUT_MODE_4X4);
		System.out.println(MCUConfig.LAYOUT_MODE_601);
		System.out.println(MCUConfig.LAYOUT_MODE_604);
		System.out.println(MCUConfig.LAYOUT_MODE_801);
		System.out.println(MCUConfig.LAYOUT_MODE_901);
		System.out.println(MCUConfig.LAYOUT_MODE_902);
	}

	public void setMenuManager(String menuManager) {
		this.menuManager = menuManager;
	}

	public String getMenuManager() {
		return menuManager;
	}

	public void setMeetingDetialStatic(MeetingDetialStatic meetingDetialStatic) {
		this.meetingDetialStatic = meetingDetialStatic;
	}

	public MeetingDetialStatic getMeetingDetialStatic() {
		return meetingDetialStatic;
	}
	
	
}
