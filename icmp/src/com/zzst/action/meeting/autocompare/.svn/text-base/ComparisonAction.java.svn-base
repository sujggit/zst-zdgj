package com.zzst.action.meeting.autocompare;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.autocompare.histogram.HistogramUtil;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuVO.ZZOMainStatusVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.cbfImpl.util.StringUtils;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.enums.MeetingDetailEnum;
import com.zzst.model.meeting.comparison.ComparisonCriteriaVO;
import com.zzst.model.meeting.comparison.ComparisonDetailVO;
import com.zzst.model.meeting.comparison.ComparisonReferenceVO;
import com.zzst.model.meeting.comparison.ComparisonVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.information.InformationVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.service.meeting.meetingDetail.MeetingDetailService;
import com.zzst.service.meeting.meetingDetail.MeetingDetailServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

import freemarker.template.utility.StringUtil;

public class ComparisonAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(ComparisonAction.class.getName());
	private ComparisonVO comparisonVO ;
	private ArrayList<ComparisonVO> comparisonVOList = new ArrayList<ComparisonVO>();
	private ArrayList<ComparisonDetailVO> comparisonDetailVOList = new ArrayList<ComparisonDetailVO>();
	private String meetingDetailId;
	private ArrayList<MeetingDetailVO> meetingDetailList = new ArrayList<MeetingDetailVO>();
	
	private MeetingRoomVO meetingRoomVO;
	private ComparisonDetailVO comparisonDetailVO;
	private ComparisonDetailVO comparisonDetailVO_;
	private ArrayList<ComparisonDetailVO> comparisonDetailList;
	private String masterEpIp;
	private String compareID;
	private String compareDetailID;
	private String meetingRoomID;
	private int radioStatus;
	private ComparisonVO comparisonVO_ ;
	private InputStream  excelStream;
	private int barPercent;
	
	private int goodCount =0;
	private int okCount =0;
	private int badCount =0;
	


	private ComparisonReferenceVO comparisonReferenceVO;
	private EquipmentVO equipmentVO;
	
	public	String	queryComparisonList(){
		logger.info("ComparisonAction	queryComparisonList		begin");
		try{
			/**
			comparisonVOList=ServiceFactory.getConparisonService().query(comparisonVO, this.getPageControler());
			System.out.println(comparisonVOList.size()+"..............");
			*/
			String chooseMeetingNumber = request.getParameter("chooseMeetingNumber");
			
			MeetingDetailService meetingDetailService = new MeetingDetailServiceImpl();
			MeetingDetailVO vMeetingDetailVO = new MeetingDetailVO();
			vMeetingDetailVO.setMeetingStartTime(new Timestamp(System.currentTimeMillis()));
			vMeetingDetailVO.setMeetingType(MeetingDetailEnum.TYPE_VEDIO);
			meetingDetailList = meetingDetailService.getMeetingListForToday(vMeetingDetailVO, null);
			if (meetingDetailList == null || meetingDetailList.size() == 0) {
//					info = "没有正在开的会";
				return SUCCESS;
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
				comparisonVO=new ComparisonVO();
				comparisonVO.setMeetingDetailID(detailVO.getMeetingDetailID());
				//comparisonVO.setStatus(comparisonVO_.getStatus());
				
				
				
				
				comparisonVOList=ServiceFactory.getConparisonService().query(comparisonVO, null);
				int size=0;
				
				if(comparisonVOList!=null&&comparisonVOList.size()>0){
					for(ComparisonVO oldCom : comparisonVOList){
						if(oldCom.getResult() > 0){
							size++;
						}
                    
					}
					request.setAttribute("referencedCount", size);
					
					radioStatus=comparisonVOList.get(0).getStatus();
					//MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
					for(ComparisonVO cvList:comparisonVOList){
						//meetingRoomVO.setMeetingRoomID(cvList.getMeetingRoomID());
						cvList.setMeetingRoomVO(ServiceFactory.getMeetingRoomService().queryByID(cvList.getMeetingRoomID()));
					
						if(cvList.getResult()==HistogramUtil.MANUAL_GOOD_RESULT
								||cvList.getResult()==HistogramUtil.GOOD_RESULT){
							++goodCount;
							
						}else{
							if(cvList.getResult()==HistogramUtil.MANUAL_OK_RESULT||cvList.getResult()==HistogramUtil.OK_RESULT){
								++okCount;
							}else{
								if(cvList.getResult() > 0){
									++badCount;					
								}
							}
						}
					}					
					
					
					
					
				}
				
				//comparisonVO.getMeetingRoomID();
				List<ZZOMainStatusVO> meetingRoomList = ZZOMcuFactory.getInstance().getInnerConfPts().getMainStatusMap().get(detailVO.getMeetingDetailID());
				int epCount = 0;
				if(meetingRoomList != null && meetingRoomList.size() > 0){
					ZZOMainStatusVO mainMeetingRoom = new ZZOMainStatusVO();
					for(int i=0;i<meetingRoomList.size();i++){
						if(meetingRoomList.get(i).getCascadeRole()!=null&&meetingRoomList.get(i).getCascadeRole().equals("none")){
							if(meetingRoomList.get(i).getIsSpeaker()==1){
								mainMeetingRoom = meetingRoomList.get(i);
							}else{
								epCount++;
							}
						}
					}
					if(mainMeetingRoom!=null){
						request.setAttribute("masterEpIp", mainMeetingRoom.getMcu_participant_ip());
						request.setAttribute("epCount", epCount);
					}
				}
		//	}
			chooseMeetingNumber = detailVO.getMeetingDetailID() + "";
			request.setAttribute("chooseMeetingNumber", chooseMeetingNumber);
			
			
			float s=(float)size;
			
			float c=(float)epCount;
			//System.out.println((float)(s/c)*100);
			if(size>=0&&epCount>=size&&epCount!=0){
				float result=(s/c)*100;
				
				if(barPercent!=(int)result){
					barPercent=(int)result;
				}
			}
			
			
		}catch(Exception e){
			request.setAttribute("info", "获取会议室列表时发生异常！");
			logger.error(e.getMessage());
			e.printStackTrace();
			return "failure";
		}
		
		
		
		
		logger.info("ComparisonAction		queryComparisonList	end");
		return SUCCESS;
	}
	
	

	
	public	String	comparisonDetail(){
		logger.info("ComparisonAction	comparisonDetail		begin");
		try{
			//ComparisonReferenceVO comparisonReference=new ComparisonReferenceVO();
			// comparisonDetailList = ServiceFactory.getConparisonDetailService().query(comparisonDetailVO,null);
			comparisonDetailVO=ServiceFactory.getConparisonDetailService().queryByID(comparisonVO.getCompDetailID());
			//if(comparisonDetailList!=null&&comparisonDetailList.size()>0){
				//comparisonDetailVO=comparisonDetailList.get(0);
			//}
			
			ComparisonReferenceVO	mainComparisonReferenceVO=new ComparisonReferenceVO();
			compareDetailID=comparisonVO.getCompDetailID();
			compareID=comparisonVO.getID();
		
			
			comparisonVO=ServiceFactory.getConparisonService().queryByID(comparisonVO.getID());
			comparisonVO_=comparisonVO;
			meetingDetailId=comparisonVO.getMeetingDetailID();
			meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(comparisonVO.getMeetingRoomID());
	//分会场本身的标准		
			if(meetingRoomVO!=null&&!meetingRoomVO.getMeetingRoomName().equals("")){
				comparisonVO.setMeetingRoomVO(meetingRoomVO);			
				comparisonReferenceVO=new ComparisonReferenceVO();			
				comparisonReferenceVO.setMeetingRoomID(meetingRoomVO.getMeetingRoomID());
				ArrayList<ComparisonReferenceVO> cfList=ServiceFactory.getConparisonReferenceService().query(comparisonReferenceVO, null);
				if(cfList!=null&&cfList.size()>0){
					comparisonReferenceVO=cfList.get(0);
					
				}
				meetingRoomVO=comparisonVO.getMeetingRoomVO();
				meetingRoomID=meetingRoomVO.getMeetingRoomID();
//主终端下比对卡标准值
				//得到主终端
				equipmentVO=new EquipmentVO();
				equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				equipmentVO.setIp(masterEpIp);
				ArrayList<EquipmentVO> eList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
				if(eList!=null&&eList.size()>0){
					equipmentVO=new  EquipmentVO();
					equipmentVO=eList.get(0);
				}
				//根据主终端所在room获得比对卡标准值
				
				mainComparisonReferenceVO.setMeetingRoomID(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
				ArrayList<ComparisonReferenceVO> comparisonReferenceVOList=new ArrayList<ComparisonReferenceVO>();
				
				comparisonReferenceVOList=ServiceFactory.getConparisonReferenceService().query(mainComparisonReferenceVO, null);
				
				if(comparisonReferenceVOList!=null&&comparisonReferenceVOList.size()>0){
					mainComparisonReferenceVO=comparisonReferenceVOList.get(0);
					
				}
				
				if(comparisonVO.getCompDetailID()!=null&&!comparisonVO.getCompDetailID().equals("")){
					comparisonVO=ServiceFactory.getConparisonService().queryByID(comparisonVO.getCompDetailID());	
					
					
				}
				
				
			}
			List<ComparisonCriteriaVO> criteriaList = ServiceFactory.getConparisonCriteriaService().query(null, null);
			if(criteriaList != null && criteriaList.size() > 0){
				ComparisonCriteriaVO  criteriaVO = criteriaList.get(0);
				request.setAttribute("criteriaVO", criteriaVO);
			}

			this.request.setAttribute("comparisonDetailVO", comparisonDetailVO);
			this.request.setAttribute("comparisonReferenceVO", comparisonReferenceVO);
			this.request.setAttribute("mainComparisonReferenceVO", mainComparisonReferenceVO);
			
			return  SUCCESS;
		}catch(Exception e){
		
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("ComparisonAction		comparisonDetail	end");
		return SUCCESS;
	}
	
	//手工确认
	

	public	String	toMamufactruerComparison(){
		logger.info("ComparisonAction	toMamufactruerComparison		begin");
		try{
			 comparisonVO_=new ComparisonVO();
			 //comparisonVO_.setID(comparisonVO.getID());
			 comparisonVO_=ServiceFactory.getConparisonService().queryByID(comparisonVO.getID());
			 System.out.println(comparisonVO.getID());
			if(comparisonVO_.getMeetingRoomID()!=null&&!comparisonVO_.getMeetingRoomID().equals("")){
				meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(comparisonVO_.getMeetingRoomID());
				comparisonVO.setMeetingRoomVO(meetingRoomVO);
				EquipmentVO equipmentVO = new EquipmentVO();
				equipmentVO.setMeetingRoomVO(meetingRoomVO);
				equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
				List<EquipmentVO> equipmentList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
				if(equipmentList != null && equipmentList.size() > 0){
					comparisonVO.setDescription(equipmentList.get(0).getIp());
				}
			}
			
			return  SUCCESS;
		}catch(Exception e){
		
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("ComparisonAction		toMamufactruerComparison	end");
		return SUCCESS;
	}
	
	public	String	mamufactruerComparison(){
		logger.info("ComparisonAction	mamufactruerComparison		begin");
		try{			
			comparisonVOList=ServiceFactory.getConparisonService().queryByIDs(comparisonVO.getID());
			
			if(comparisonVOList!=null&&comparisonVOList.size()>0){
				comparisonVO_=new ComparisonVO();
				comparisonVO_=comparisonVOList.get(0);
				comparisonVO_.setUpAudioQuality(comparisonVO.getUpAudioQuality());
				comparisonVO_.setUpVideoQuality(comparisonVO.getUpVideoQuality());
				comparisonVO_.setDownAudioQuality(comparisonVO.getDownAudioQuality());
				comparisonVO_.setDownVideoQuality(comparisonVO.getDownVideoQuality());		
				comparisonVO_.setResult(comparisonVO.getResult());
				ServiceFactory.getConparisonService().modify(comparisonVO_);
				
			}
			
			return  SUCCESS;
		}catch(Exception e){
		
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("ComparisonAction		mamufactruerComparison	end");
		return SUCCESS;
	}
	
	
	
	
	
	public	String	historyComparison(){
		logger.info("ComparisonAction	historyComparison		begin");
		try{			
			
			comparisonVOList=ServiceFactory.getConparisonService().queryHistory(comparisonVO, PageSplittor.getPageSplittor(request).getPControler() );
			//会议
			ArrayList<MeetingDetailVO> mdList=new ArrayList<MeetingDetailVO>();
			for(ComparisonVO comparisonVO:comparisonVOList){
				MeetingDetailVO vMeetingDetailVO=new MeetingDetailVO();
				vMeetingDetailVO.setMeetingDetailID(comparisonVO.getMeetingDetailID());
				mdList=ServiceFactory.getMeetingDetailService().query(vMeetingDetailVO, null);
				
				if(mdList!=null&&mdList.size()>0){
					comparisonVO.setMeetingName(mdList.get(0).getMeetingName());
				}
				//会场
				meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(comparisonVO.getMeetingRoomID());
				comparisonVO.setMeetingRoomVO(meetingRoomVO);
			
			}
			
			
			
			
		}catch(Exception e){
		
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("ComparisonAction		historyComparison	end");
		return SUCCESS;
	}
	
	//设备状态 wangle 2013-9-24
	public	String	getEquipmentStatus(){
		logger.info("ComparisonAction	getEquipmentStatus		begin");
		try{			
			comparisonDetailVO=ServiceFactory.getConparisonDetailService().queryByID(comparisonVO.getCompDetailID());
			comparisonVO=ServiceFactory.getConparisonService().queryByID(comparisonVO.getID());
			meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(comparisonVO.getMeetingRoomID());
			if(meetingRoomVO != null){
				comparisonVO.setMeetingRoomVO(meetingRoomVO);
			}
			if(comparisonVO != null && comparisonVO.getResult() == HistogramUtil.ISNOTCONNECTED_RESULT){
				this.request.setAttribute("TERMINAL", "0");
			}
			String equipmentStatus = comparisonVO.getDescription();
			if(equipmentStatus==null) equipmentStatus="";
			//String equipmentStatus = "pla1:true;pla2:false;proj:true;sysPower:true;matrix:false;camera:true";
			String info[] = equipmentStatus.split(";");
			String items[][] = new String[info.length][2];
			if(info != null && info.length > 0){
				for(int i=0; i<info.length; i++){
					String eqStatus = info[i];
					if(eqStatus == null || eqStatus.trim().equals("")){
						continue;
					}
					items[i][0] = eqStatus.split(":")[0];
					items[i][1] = eqStatus.split(":")[1];
					
					if(items[i][0].equals("camera2")){
						if(comparisonVO != null && comparisonVO.getResult() == HistogramUtil.ISNOTCONNECTED_RESULT){
							items[i][1] = "false";
						}else{
							items[i][1] = "true";	
						}
					}
					/*
					if("sysPower".equalsIgnoreCase(eqStatus)){
						if(eqStatus.contains("true")){
							this.request.setAttribute("sysPower", 1);
						}else{
							this.request.setAttribute("sysPower", 0);
						}
					}
					if("matrix".equalsIgnoreCase(eqStatus)){
						if(eqStatus.contains("true")){
							this.request.setAttribute("matrix", 1);
						}else{
							this.request.setAttribute("matrix", 0);
						}
					}
					if("camera".equalsIgnoreCase(eqStatus)){
						if(eqStatus.contains("true")){
							this.request.setAttribute("camera", 1);
						}else{
							this.request.setAttribute("camera", 0);
						}
					}
					*/
				}
				
			}
			this.request.setAttribute("equipmentStatus", equipmentStatus);
			this.request.setAttribute("equipmentItems", items);
		}catch(Exception e){
		
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("ComparisonAction		getEquipmentStatus	end");
		return  SUCCESS;
	}
	
	
	//导出历史
	
	/**
	 * 导出
	 * add  by tanzanlong. modified by wangle 2013-7-18 recorrect
	 * @return
	 */
	public String historyComparisonexport(){
		logger.info("ComparisonAction	historyComparisonexport	begin");
		try{
			comparisonVOList=ServiceFactory.getConparisonService().query(comparisonVO, null);
			
			
			//会议
			ArrayList<MeetingDetailVO> mdList=new ArrayList<MeetingDetailVO>();
			for(ComparisonVO comparisonVO:comparisonVOList){
				MeetingDetailVO vMeetingDetailVO=new MeetingDetailVO();
				vMeetingDetailVO.setMeetingDetailID(comparisonVO.getMeetingDetailID());
				mdList=ServiceFactory.getMeetingDetailService().query(vMeetingDetailVO, null);
				
				if(mdList!=null&&mdList.size()>0){
					comparisonVO.setMeetingName(mdList.get(0).getMeetingName());
				}
				//会场
//				meetingRoomVO=ServiceFactory.getMeetingRoomService().queryByID(comparisonVO.getMeetingRoomID());
				meetingRoomVO = new MeetingRoomVO();
				meetingRoomVO.setMeetingRoomID(comparisonVO.getMeetingRoomID());
				List<MeetingRoomVO> mrList = ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
				if(mrList != null && mrList.size() > 0){
					comparisonVO.setMeetingRoomVO(mrList.get(0));
				}
			}
				
			String fileName = "comparisonVO.xls";
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			
			if(comparisonVOList!=null&&comparisonVOList.size()>0){
			
				
				for (int i = 0; i < comparisonVOList.size(); i++) {
					ComparisonVO cVO = comparisonVOList.get(i);
					if( StringUtils.isNullOrBlank(cVO.getMeetingName()) || cVO.getMeetingRoomVO() == null || StringUtils.isNullOrBlank(cVO.getMeetingRoomVO().getMeetingRoomName())
							|| StringUtils.isNullOrBlank(cVO.getResult())){
						continue;
					}
					CellVO[] cell = new CellVO[7];
					
					
					CellVO ex0 = new CellVO();
					ex0.setValue(cVO.getMeetingName());
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();			
					ex1.setValue(cVO.getMeetingRoomVO().getMeetingRoomName());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();	
					ex2 = getCellResult(ex2, cVO, 1);
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3 = getCellResult(ex3, cVO, 5);
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4 = getCellResult(ex4, cVO, 4);
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					ex5 = getCellResult(ex5, cVO, 3);
					cell[5] = ex5;
					
					CellVO ex6 = new CellVO();
					ex6 = getCellResult(ex6, cVO, 2);
					cell[6] = ex6;
					
					list.add(cell);
				}
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("ComparisonAction	historyComparisonexport	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("ComparisonAction	historyComparisonexport	end");
		return "success";
	}
	
	
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[7];
		CellVO ex0 = new CellVO();
		ex0.setValue("会议");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会场");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("结果");
		cellTitle[2] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("上行视频");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("下行视频");
		cellTitle[4] = ex0;
		ex0 = new CellVO();
		ex0.setValue("上行音频");
		cellTitle[5] = ex0;
		ex0 = new CellVO();
		ex0.setValue("下行音频");
		cellTitle[6] = ex0;
		list.add(cellTitle);
	}
	
	/**wangle create 2013-7-18.
	 * result type=1; down audio result type=2；up audio result type=3；down video result type=4；up video result type=5；
	 * @param cellVO
	 * @param cVO
	 * @param type
	 * @return
	 */
	private CellVO getCellResult(CellVO cellVO, ComparisonVO cVO, int type){
		if(type == 1){
			if(cVO.getResult() == HistogramUtil.GOOD_RESULT){
				cellVO.setValue("好");
				
			}
			else{ 
				if(cVO.getResult() == HistogramUtil.OK_RESULT){
					cellVO.setValue("中");
				}
				else{
					if(cVO.getResult() == HistogramUtil.BAD_RESULT){
						cellVO.setValue("差");
					}
					else{ 
						if(cVO.getResult() == HistogramUtil.MANUAL_GOOD_RESULT){
							cellVO.setValue("手工确认好");
						}
						else{ 
							if(cVO.getResult() == HistogramUtil.MANUAL_OK_RESULT){
								cellVO.setValue("手工确认中");
							}
							else{ 
								if(cVO.getResult() == HistogramUtil.MANUAL_BAD_RESULT){
									cellVO.setValue("手工确认差");
								}
								else{
									cellVO.setValue("-");
								}
							}
						}
					}
				}
			}
		}
		if(type == 2){
			if(cVO.getDownAudioQuality() == HistogramUtil.ONVOICE_VALUE){
				cellVO.setValue("有");
				
			}
			else{ 
				if(cVO.getDownAudioQuality() == HistogramUtil.NONEVOICE_VALUE){
					cellVO.setValue("无");
				}
				else{
					cellVO.setValue("-");
				}
			}	
		}
		if(type == 3){
			if(cVO.getUpAudioQuality() == HistogramUtil.ONVOICE_VALUE){
				cellVO.setValue("有");
				
			}
			else{ 
				if(cVO.getUpAudioQuality() == HistogramUtil.NONEVOICE_VALUE){
					cellVO.setValue("无");
				}
				else{
					cellVO.setValue("-");
				}
			}	
		}
		
		if(type == 4){
			if(cVO.getDownVideoQuality() == HistogramUtil.GOOD_RESULT){
				cellVO.setValue("好");
				
			}
			else{ 
				if(cVO.getDownVideoQuality() == HistogramUtil.OK_RESULT){
					cellVO.setValue("中");
				}
				else{
					if(cVO.getDownVideoQuality() == HistogramUtil.BAD_RESULT){
						cellVO.setValue("差");
					}
					else{ 
						if(cVO.getDownVideoQuality() == HistogramUtil.MANUAL_GOOD_RESULT){
							cellVO.setValue("手工确认好");
						}
						else{ 
							if(cVO.getDownVideoQuality() == HistogramUtil.MANUAL_OK_RESULT){
								cellVO.setValue("手工确认中");
							}
							else{ 
								if(cVO.getDownVideoQuality() == HistogramUtil.MANUAL_BAD_RESULT){
									cellVO.setValue("手工确认差");
								}
								else{
									cellVO.setValue("-");
								}
							}
						}
					}
				}
			}
		}
		if(type == 5){
			if(cVO.getUpVideoQuality() == HistogramUtil.GOOD_RESULT){
				cellVO.setValue("好");
				
			}
			else{ 
				if(cVO.getUpVideoQuality() == HistogramUtil.OK_RESULT){
					cellVO.setValue("中");
				}
				else{
					if(cVO.getUpVideoQuality() == HistogramUtil.BAD_RESULT){
						cellVO.setValue("差");
					}
					else{ 
						if(cVO.getUpVideoQuality() == HistogramUtil.MANUAL_GOOD_RESULT){
							cellVO.setValue("手工确认好");
						}
						else{ 
							if(cVO.getUpVideoQuality() == HistogramUtil.MANUAL_OK_RESULT){
								cellVO.setValue("手工确认中");
							}
							else{ 
								if(cVO.getUpVideoQuality() == HistogramUtil.MANUAL_BAD_RESULT){
									cellVO.setValue("手工确认差");
								}
								else{
									cellVO.setValue("-");
								}
							}
						}
					}
				}
			}
		}
		return cellVO;
	}
	
	
	public ArrayList<ComparisonDetailVO> getComparisonDetailVOList() {
		return comparisonDetailVOList;
	}




	public void setComparisonDetailVOList(
			ArrayList<ComparisonDetailVO> comparisonDetailVOList) {
		this.comparisonDetailVOList = comparisonDetailVOList;
	}




	public ComparisonDetailVO getComparisonDetailVO_() {
		return comparisonDetailVO_;
	}




	public void setComparisonDetailVO_(ComparisonDetailVO comparisonDetailVO) {
		comparisonDetailVO_ = comparisonDetailVO;
	}




	public ComparisonVO getComparisonVO() {
		return comparisonVO;
	}
	public void setComparisonVO(ComparisonVO comparisonVO) {
		this.comparisonVO = comparisonVO;
	}

	public ArrayList<ComparisonVO> getComparisonVOList() {
		return comparisonVOList;
	}

	public void setComparisonVOList(ArrayList<ComparisonVO> comparisonVOList) {
		this.comparisonVOList = comparisonVOList;
	}

	public String getMeetingDetailId() {
		return meetingDetailId;
	}

	public void setMeetingDetailId(String meetingDetailId) {
		this.meetingDetailId = meetingDetailId;
	}

	public ArrayList<MeetingDetailVO> getMeetingDetailList() {
		return meetingDetailList;
	}

	public void setMeetingDetailList(ArrayList<MeetingDetailVO> meetingDetailList) {
		this.meetingDetailList = meetingDetailList;
	}





	public String getMasterEpIp() {
		return masterEpIp;
	}




	public void setMasterEpIp(String masterEpIp) {
		this.masterEpIp = masterEpIp;
	}




	public ComparisonReferenceVO getComparisonReferenceVO() {
		return comparisonReferenceVO;
	}




	public void setComparisonReferenceVO(ComparisonReferenceVO comparisonReferenceVO) {
		this.comparisonReferenceVO = comparisonReferenceVO;
	}




	public ComparisonDetailVO getComparisonDetailVO() {
		return comparisonDetailVO;
	}




	public void setComparisonDetailVO(ComparisonDetailVO comparisonDetailVO) {
		this.comparisonDetailVO = comparisonDetailVO;
	}




	public ArrayList<ComparisonDetailVO> getComparisonDetailList() {
		return comparisonDetailList;
	}




	public void setComparisonDetailList(
			ArrayList<ComparisonDetailVO> comparisonDetailList) {
		this.comparisonDetailList = comparisonDetailList;
	}




	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}




	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}




	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}




	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}




	public String getCompareID() {
		return compareID;
	}




	public void setCompareID(String compareID) {
		this.compareID = compareID;
	}




	public String getCompareDetailID() {
		return compareDetailID;
	}




	public void setCompareDetailID(String compareDetailID) {
		this.compareDetailID = compareDetailID;
	}




	public String getMeetingRoomID() {
		return meetingRoomID;
	}




	public void setMeetingRoomID(String meetingRoomID) {
		this.meetingRoomID = meetingRoomID;
	}




	public ComparisonVO getComparisonVO_() {
		return comparisonVO_;
	}




	public void setComparisonVO_(ComparisonVO comparisonVO) {
		comparisonVO_ = comparisonVO;
	}




	public int getGoodCount() {
		return goodCount;
	}




	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}




	public int getOkCount() {
		return okCount;
	}




	public void setOkCount(int okCount) {
		this.okCount = okCount;
	}




	public int getBadCount() {
		return badCount;
	}




	public void setBadCount(int badCount) {
		this.badCount = badCount;
	}


	public InputStream getExcelStream() {
		return excelStream;
	}




	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}




	public int getBarPercent() {
		return barPercent;
	}




	public int getRadioStatus() {
		return radioStatus;
	}




	public void setRadioStatus(int radioStatus) {
		this.radioStatus = radioStatus;
	}




	public void setBarPercent(int barPercent) {
		this.barPercent = barPercent;
	}








}