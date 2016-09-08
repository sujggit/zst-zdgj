package com.zzst.action.meeting.equipment;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

import javax.servlet.http.HttpSession;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.model.portal.session.UserSessionVO;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuUtil.MCUConfig;
import com.zzst.application.mcuVO.ZZOMcuRSRCReportVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.dao.common.UtilDAO;
import com.zzst.dao.meeting.equipment.EquipmentDAO;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.DateBaseEnum;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.dictionary.DictionaryEquipmentVO;
import com.zzst.model.meeting.equipment.EquipmentGroupVO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.meetingroomEquipment.MeetingroomEquipmentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoCard.VideoCardVO;
import com.zzst.service.meeting.baseinfo.BaseInfoService;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class EquipmentAction extends CjfAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(EquipmentAction.class.getName());
	private EquipmentVO equipmentVO=new EquipmentVO();
	private ArrayList<EquipmentVO> equipmentVOList = new ArrayList<EquipmentVO>();
	private EquipmentTerminalVO equipmentTerminalVO=new EquipmentTerminalVO();
	private VideoCardVO videoCardVO=new VideoCardVO();
	
	private EquipmentMcuVO equipmentMcuVO=new EquipmentMcuVO();
	private MeetingRoomVO meetingRoomVO=new MeetingRoomVO();
	private UserVO userVO=new UserVO();
	private ArrayList<EquipmentMcuVO> equipmentMcuList=new  ArrayList<EquipmentMcuVO>();
	private ArrayList<EquipmentVO> equipmentVOListsss = new ArrayList<EquipmentVO>();
	private InputStream  excelStream;
	private ArrayList<BaseInfoVO> baseInfoList = new ArrayList<BaseInfoVO>();
	private String style1;
	private String style2;
	private String style3;
	private String style4;
	private String style5;
	private String style6;
	public static final String styleBackColor = "#fff";
	
	private EquipmentGroupVO equipmentGroupVO = new EquipmentGroupVO();
	private ArrayList<EquipmentGroupVO> egList = new ArrayList<EquipmentGroupVO>();
	/**
	 * 导出
	 * @return
	 */
	public String exportQuery(){
		logger.info("EquipmentAction	exportQuery	begin");
		try{
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO, null);
			
			String fileName = "equipment.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitle(list);//添加表头
				if(equipmentVOList!=null&&equipmentVOList.size()>0){	
				for (int i = 0; i < equipmentVOList.size(); i++) {
					EquipmentVO lVO = equipmentVOList.get(i);
					CellVO[] cell = new CellVO[11];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getEquipmentNO());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					for(String[] s : EquipmentEnum.getEquipmentType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getEquipmentType()+"")){
							 ex2.setValue(s[1]);
							 continue;
						 }
					}
					
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getIp());
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getMeetingRoomVO().getMeetingRoomName());
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					ex5.setValue(lVO.getUserVO().getName());
					cell[5] = ex5;
					
					CellVO ex6 = new CellVO();
					for(String[] s : EquipmentEnum.getTerminalStatus()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getStatus()+"")){
							 ex6.setValue(s[1]);
							 continue;
						 }
					 }
					cell[6] = ex6;
					
					
					CellVO ex7 = new CellVO();
					if( lVO.getMaintenanceStartTime() != null ){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String date = sdf.format(new Date(lVO.getMaintenanceStartTime().getTime()));
						ex7.setValue(date);
					}else{
						ex7.setValue("");
					}
					
					cell[7] = ex7;
					
					CellVO ex8 = new CellVO();
					///计算时间差值
				    if( lVO.getMaintenanceStartTime() != null && lVO.getMaintenanceEndTime() != null){
						 Calendar sc = Calendar.getInstance();
						 sc.setTimeInMillis(lVO.getMaintenanceStartTime().getTime());
						 int scYear  = sc.get(Calendar.YEAR);
						 int scMonth = sc.get(Calendar.MONTH);
						 
						 
						 Calendar ec = Calendar.getInstance();
						 ec.setTimeInMillis(lVO.getMaintenanceEndTime().getTime());
						 int ecYear  = ec.get(Calendar.YEAR);
						 int ecMonth = ec.get(Calendar.MONTH);
						 
						 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
						 ex8.setValue(duringMonth+"个月");
					 }else{
						 ex8.setValue("");
					 }
					
					cell[8] = ex8;
					
					CellVO ex9 = new CellVO();
					ex9.setValue(lVO.getEquipmentIdentifier());
					cell[9] = ex9;
					
					CellVO ex10 = new CellVO();
					ex10.setValue(lVO.getSerialNumber());
					cell[10] = ex10;
					
					list.add(cell);
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("EquipmentAction	exportQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	exportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[11];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备名称");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备类型");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备IP");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("所属会议室");
		cellTitle[4] = ex0;
		ex0 = new CellVO();
		ex0.setValue("管理员");
		cellTitle[5] = ex0;
		ex0 = new CellVO();
		ex0.setValue("状态");
		cellTitle[6] = ex0;
		
		//////////////////
		ex0 = new CellVO();
		ex0.setValue("维保开始日期");
		cellTitle[7] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("期限");
		cellTitle[8] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("资产编号");
		cellTitle[9] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("序列号");
		cellTitle[10] = ex0;
		
		list.add(cellTitle);
	}
	
	/**
	 * 根据ID查询QBox系统信息
	 * @return
	 */
	public String QBoxDetail(){
		logger.info("EquipmentAction	QBoxDetail	begin");
		try {
			String equipmentID=equipmentVO.getEquipmentID();
			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
		} catch (Exception e) {
			logger.error("EquipmentAction	QBoxDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	QBoxDetail	end");
		return SUCCESS;
	}
	
	/**
	 * 添加及注册QBox系统
	 * @return
	 */
	public String	QBoxBeforAdd(){
		
		logger.info("EquipmentAction	QBoxBeforAdd	begin");
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction	QBoxBeforAdd	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存及注册QBox系统
	 * @return
	 */
	public	String	QBoxAdd(){
		logger.info("EquipmentAction	QBoxAdd	begin");
		//equipmentVO.setEquipmentType(EquipmentVO.TYPE_NOTICE);
		try{
            EquipmentVO QBoxEquipmentVO = equipmentVO;
            QBoxEquipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_QBOX);
            QBoxEquipmentVO.setEquipmentName(EquipmentEnum.TYPE_NAME_QBOX);
		    ServiceFactory.getEquipmentService().addEqupment(QBoxEquipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	QBoxAdd	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	QBoxAdd	end");
		return SUCCESS;
	}
	
	
	/**
	 * 修改QBox
	 * @return
	 */
	public	String	QBoxBeforeModify(){
		logger.info("EquipmentAction	QBoxBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
		}catch(Exception e){
			logger.error("EquipmentAction	QBoxBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	QBoxBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改保存QBox系统
	 * @return
	 */
	public	String	QBoxModify(){
		//equipmentVO.setEquipmentType(EquipmentVO.TYPE_NOTICE);
		logger.info("EquipmentAction	QBoxModify	begin");
		try{
		    ServiceFactory.getEquipmentService().modify(equipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	QBoxModify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	QBoxModify	end");
		return SUCCESS;
	}
	
	
	public String queryNotice(){
		logger.info("EquipmentAction	queryNotice	begin");
		try{
			equipmentVOList=ServiceFactory.getEquipmentService().queryNotice(equipmentVO, getPageControler());
			int equipmentTypes= equipmentVO.getEquipmentType();
			this.getCurHttpServletRequest().setAttribute("equipmentTypes", equipmentTypes);
		}catch(Exception e){
			logger.error("EquipmentAction	queryNotice	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	queryNotice	end");
		return SUCCESS;
	}
	
	/**
	 * 根据ID查询告示系统信息
	 * @return
	 */
	public String noticeDetail(){
		logger.info("EquipmentAction	noticeDetail	begin");
		try {
			equipmentVOList=ServiceFactory.getEquipmentService().queryNotice(equipmentVO, getPageControler());
			if(equipmentVOList!=null&&equipmentVOList.size()>0){
				equipmentVO = equipmentVOList.get(0);
				
				///计算时间差值
				 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
					 Calendar sc = Calendar.getInstance();
					 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
					 int scYear  = sc.get(Calendar.YEAR);
					 int scMonth = sc.get(Calendar.MONTH);
					 
					 
					 Calendar ec = Calendar.getInstance();
					 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
					 int ecYear  = ec.get(Calendar.YEAR);
					 int ecMonth = ec.get(Calendar.MONTH);
					 
					 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
					 equipmentVO.setMaintenanceMonths(duringMonth);
				 }
			}
			
		} catch (Exception e) {
			logger.error("EquipmentAction	noticeDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	noticeDetail	end");
		return SUCCESS;
	}
	
	/**
	 * 添加及注册告示系统
	 * @return
	 */
	public String	noticeBeforeAdd(){
		logger.info("EquipmentAction	noticeBeforeAdd	begin");
		try {
			//管理员默认为当前系统登录用户
			UserVO userVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			this.getCurHttpServletRequest().setAttribute("userName", userVO.getName());
			this.getCurHttpServletRequest().setAttribute("userID", userVO.getUserID());
			
			DictionaryEquipmentVO deEquipmentVO = new DictionaryEquipmentVO();
			deEquipmentVO.setParentID(DateBaseEnum.Default_ID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(deEquipmentVO, null);
			this.getServletRequest().setAttribute("deList", deList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getCurHttpServletRequest().setAttribute("style6", style6);
		logger.info("EquipmentAction	noticeBeforeAdd	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存及注册告示系统
	 * @return
	 */
	public	String	noticeAdd(){
		logger.info("EquipmentAction	noticeAdd	begin");
		//equipmentVO.setEquipmentType(EquipmentVO.TYPE_NOTICE);
		try{
			equipmentVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			///计算维保到期日add on 2013-5-7 by chenshuo
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			String[] roomIds = equipmentVO.getMeetingRoomVO().getMeetingRoomID().split(",");
			equipmentVO.getMeetingRoomVO().setMeetingRoomID(roomIds[0]);
			
			DictionaryEquipmentVO dEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
//			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentName(dEquipmentVO.getDicName());
//			equipmentVO.setEquipmentModel(String.valueOf(deEquipmentVO.getDicValue()));
			
		  EquipmentVO eqVO =   ServiceFactory.getEquipmentService().addNotice(equipmentVO);
		    if(eqVO!=null){
		    	MeetingroomEquipmentVO meVO = new MeetingroomEquipmentVO();
				for(int i=0;i<roomIds.length;i++){
					meVO.setRoomId(roomIds[i]);
					meVO.setEquipmentId(eqVO.getEquipmentID());
					ServiceFactory.getMeetingroomEquipmentService().add(meVO);
				}
		    }
		}catch(Exception e){
			logger.error("EquipmentAction	noticeAdd	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	noticeAdd	end");
		return SUCCESS;
	}
	
	
	/**
	 * 修改告示系统
	 * @return
	 */
	public	String	noticeBeforeModify(){
		logger.info("EquipmentAction	noticeBeforModify	begin");
		try{
			equipmentVOList=ServiceFactory.getEquipmentService().queryNotice(equipmentVO, getPageControler());
			if(equipmentVOList!=null&&equipmentVOList.size()>0){
				equipmentVO = equipmentVOList.get(0);
			}
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		}catch(Exception e){
			logger.error("EquipmentAction	noticeBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	noticeBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改保存告示系统
	 * @return
	 */
	public	String	noticeModify(){
		//equipmentVO.setEquipmentType(EquipmentVO.TYPE_NOTICE);
		logger.info("EquipmentAction	noticeModify	begin");
		try{
			ServiceFactory.getMeetingroomEquipmentService().deleteByID(equipmentVO.getEquipmentID());
			String[] roomIds = equipmentVO.getMeetingRoomVO().getMeetingRoomID().split(",");
			MeetingroomEquipmentVO meVO = new MeetingroomEquipmentVO();
			for(int i=0;i<roomIds.length;i++){
				meVO.setRoomId(roomIds[i]);
				meVO.setEquipmentId(equipmentVO.getEquipmentID());
				ServiceFactory.getMeetingroomEquipmentService().add(meVO);
			}
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			//前台传递设备厂家和设备型号参数均为z_t_equipment_dictionary表中的dicID
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			equipmentVO.setEquipmentName(deEquipmentVO.getDicName());
	//		DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
	//		equipmentVO.setEquipmentModel(String.valueOf(dVo.getDicValue()));
			
			equipmentVO.getMeetingRoomVO().setMeetingRoomID(null);
		    ServiceFactory.getEquipmentService().modify(equipmentVO);
		    
		}catch(Exception e){
			logger.error("EquipmentAction	noticeModify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	noticeModify	end");
		return SUCCESS;
	}
	
	public String deleteNotice(){
		logger.info("EquipmentAction  deleteNotice   begin");
		try {
			ServiceFactory.getEquipmentService().deleteByID(equipmentVO.getEquipmentID());
			ServiceFactory.getMeetingroomEquipmentService().deleteByID(equipmentVO.getEquipmentID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction  deleteNotice   end");
		return SUCCESS;
	}
	
	/**
	 * 查询设备列表
	 * @return
	 */
	public String query(){
		logger.info("EquipmentAction	query	begin");
		try{
          ///////////////会议室分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentVO.setLevel(true);
					equipmentVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			equipmentVOList=ServiceFactory.getEquipmentService().queryEquipments(equipmentVO, getPageControler());
			int equipmentTypes= equipmentVO.getEquipmentType();
			this.getCurHttpServletRequest().setAttribute("equipmentTypes", equipmentTypes);
		}catch(Exception e){
			logger.error("EquipmentAction	query	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	query	end");
		return SUCCESS;
	}
	
	/**
	 * 根据ID查询mcu信息
	 * @return
	 */
	public	String	mcuDetail(){
		logger.info("EquipmentAction	mcuDetail	begin");
		try {
			String equipmentID=equipmentVO.getEquipmentID();
			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
			equipmentMcuVO=ServiceFactory.getEquipmentMcuService().queryByID(equipmentID);
			
			///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
		} catch (Exception e) {
			logger.error("EquipmentAction	mcuDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	mcuDetail	end");
		return SUCCESS;
	}
	/**
	 * 根据ID查询终端信息
	 * @return
	 */
	public String terminalDetail(){
		logger.info("EquipmentAction	terminalDetail	begin");
		try {
			ArrayList<EquipmentVO> mcuBelong = new ArrayList<EquipmentVO>();
			String equipmentID=equipmentVO.getEquipmentID();
			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
			equipmentTerminalVO=ServiceFactory.getEquipmentTerminalService().queryByID(equipmentID);
			if(equipmentTerminalVO!=null){
				mcuBelong.add(ServiceFactory.getEquipmentService().queryByID(equipmentTerminalVO.getEquipmentMCUID()));
			}
			equipmentVOListsss = mcuBelong;
			
			///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
		} catch (Exception e) {
			logger.error("EquipmentAction	terminalDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	terminalDetail	end");
		return SUCCESS;
	}
	/**
	 * 根据ID查询中控信息
	 * @return
	 */
	public String controlDetail(){
		logger.info("EquipmentAction	controlDetail	begin");
		try {
			String equipmentID=equipmentVO.getEquipmentID();
			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
			
			///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
		} catch (Exception e) {
			logger.error("EquipmentAction	controlDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	controlDetail	end");
		return SUCCESS;
	}
	
	
	/**
	 * 添加及注册终端
	 * @return
	 */
	public String	terminalBeforAdd(){
		
		logger.info("EquipmentAction	terminalBeforAdd	begin");
		try {
			//管理员默认为当前系统登录用户
			UserVO userVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			this.getCurHttpServletRequest().setAttribute("userName", userVO.getName());
			this.getCurHttpServletRequest().setAttribute("userID", userVO.getUserID());
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO lu = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			equipmentVOListsss=ServiceFactory.getEquipmentService().queryMCUID(tev);
			
			DictionaryEquipmentVO deEquipmentVO = new DictionaryEquipmentVO();
			deEquipmentVO.setParentID(DateBaseEnum.Default_ID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(deEquipmentVO, null);
			this.getServletRequest().setAttribute("deList", deList);
			this.getCurHttpServletRequest().setAttribute("style1", style1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction	terminalBeforAdd	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存及注册终端
	 * @return
	 */
	public	String	terminalAdd(){
		logger.info("EquipmentAction	terminalAdd	begin");
		try{
			if(equipmentTerminalVO.getRadioTreaty().equals(EquipmentEnum.COMMUCONV_E164)){
				equipmentVO.setIp(equipmentTerminalVO.getPstn());
			}
			///计算维保到期日add on 2013-5-7 by chenshuo
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			String equipmentID = UtilDAO.getUUid();
			equipmentVO.setEquipmentID(equipmentID);
			DictionaryEquipmentVO dEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentName(dEquipmentVO.getDicName());
			equipmentVO.setEquipmentModel(String.valueOf(deEquipmentVO.getDicValue()));

			int isCheck = equipmentTerminalVO.getIsCheck();
			if(isCheck==Integer.MIN_VALUE){
				equipmentTerminalVO.setIsCheck(0);
			}
			
		    ServiceFactory.getEquipmentService().addEquipmentTerminal(equipmentVO, equipmentTerminalVO);
		    
		    //往z_t_meetingRoom_equipment表插入数据。
		    MeetingroomEquipmentVO mEquipmentVO = new MeetingroomEquipmentVO();
			mEquipmentVO.setEquipmentId(equipmentID);
			mEquipmentVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			ServiceFactory.getMeetingroomEquipmentService().add(mEquipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	terminalAdd	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	terminalAdd	end");
		return SUCCESS;
	}
	/**
	 * 添加及注册mcu
	 * @return
	 */
	public String	mcuBeforAdd(){
		logger.info("EquipmentAction	mcuBeforAdd	begin");
		try {
			//管理员默认为当前系统登录用户
			UserVO userVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			this.getCurHttpServletRequest().setAttribute("userName", userVO.getName());
			this.getCurHttpServletRequest().setAttribute("userID", userVO.getUserID());
			
			DictionaryEquipmentVO deEquipmentVO = new DictionaryEquipmentVO();
			deEquipmentVO.setParentID(DateBaseEnum.Default_ID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(deEquipmentVO, null);
			this.getServletRequest().setAttribute("deList", deList);
			this.getCurHttpServletRequest().setAttribute("style2", style2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction	mcuBeforAdd	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存及注册mcu
	 * @return
	 */
	public	String	mcuAdd(){
		logger.info("EquipmentAction	mcuAdd	begin");
		try{
			equipmentVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			///计算维保到期日add on 2013-5-7 by chenshuo
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			String equipmentID = UtilDAO.getUUid();
			equipmentVO.setEquipmentID(equipmentID);
			DictionaryEquipmentVO dEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentName(dEquipmentVO.getDicName());
			equipmentVO.setEquipmentModel(String.valueOf(deEquipmentVO.getDicValue()));
			
			int isCheck = equipmentMcuVO.getIsCheck();
			if(isCheck==Integer.MIN_VALUE){
				equipmentMcuVO.setIsCheck(0);
			}
			
		    ServiceFactory.getEquipmentService().addEquipmentMcu(equipmentVO, equipmentMcuVO);
		    
		    //往z_t_meetingRoom_equipment表插入数据。
		    MeetingroomEquipmentVO mEquipmentVO = new MeetingroomEquipmentVO();
			mEquipmentVO.setEquipmentId(equipmentID);
			mEquipmentVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			ServiceFactory.getMeetingroomEquipmentService().add(mEquipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	mcuAdd	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	mcuAdd	end");
		return SUCCESS;
	}
	
	/**
	 * 添加及注册中控
	 * @return
	 */
	public String	centerControlBeforAdd(){
		
		logger.info("EquipmentAction	centerControlBeforAdd	begin");
		try {
			//管理员默认为当前系统登录用户
			UserVO userVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			this.getCurHttpServletRequest().setAttribute("userName", userVO.getName());
			this.getCurHttpServletRequest().setAttribute("userID", userVO.getUserID());
			
			DictionaryEquipmentVO deEquipmentVO = new DictionaryEquipmentVO();
			deEquipmentVO.setParentID(DictionaryEnum.dicID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(deEquipmentVO, null);
			this.getServletRequest().setAttribute("deList",deList);
			this.getCurHttpServletRequest().setAttribute("style3", style3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction	centerControlBeforAdd	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存及注册中控
	 * @return
	 */
	public	String	centerControlAdd(){
		logger.info("EquipmentAction	centerControlAdd	begin");
		try{
			equipmentVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			///计算维保到期日add on 2013-5-7 by chenshuo
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			String equipmentID = UtilDAO.getUUid();
			equipmentVO.setEquipmentID(equipmentID);
			DictionaryEquipmentVO dEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentName(dEquipmentVO.getDicName());
			equipmentVO.setEquipmentModel(String.valueOf(deEquipmentVO.getDicValue()));
			ServiceFactory.getEquipmentService().add(equipmentVO);
			
			//往z_t_meetingRoom_equipment表插入数据。
		    MeetingroomEquipmentVO mEquipmentVO = new MeetingroomEquipmentVO();
			mEquipmentVO.setEquipmentId(equipmentID);
			mEquipmentVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			ServiceFactory.getMeetingroomEquipmentService().add(mEquipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	centerControlAdd	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	centerControlAdd	end");
		return SUCCESS;
	}
	
	/**
	 * 添加及注册比对卡
	 * @return
	 */
	public String	videoCardBeforeAdd(){
		logger.info("EquipmentAction	videoCardBeforeAdd	begin");
		try {
			//管理员默认为当前系统登录用户
			UserVO userVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			this.getCurHttpServletRequest().setAttribute("userName", userVO.getName());
			this.getCurHttpServletRequest().setAttribute("userID", userVO.getUserID());
			
			DictionaryEquipmentVO deEquipmentVO = new DictionaryEquipmentVO();
			deEquipmentVO.setParentID(DictionaryEnum.dicID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(deEquipmentVO, null);
			this.getServletRequest().setAttribute("deList", deList);
			this.getCurHttpServletRequest().setAttribute("style4", style4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction	videoCardBeforeAdd	end");
		return SUCCESS;
	}
	
	public	String	videoCardAdd(){
		logger.info("EquipmentAction	videoCardAdd	begin");
		try{
			String equipmentID = UtilDAO.getUUid();
			equipmentVO.setEquipmentID(equipmentID);
			DictionaryEquipmentVO dEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
//			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentName(dEquipmentVO.getDicName());
//			equipmentVO.setEquipmentModel(String.valueOf(deEquipmentVO.getDicValue()));
			ServiceFactory.getEquipmentService().addEquipmentVideoCard(equipmentVO, videoCardVO);
			
			//往z_t_meetingRoom_equipment表插入数据。
		    MeetingroomEquipmentVO mEquipmentVO = new MeetingroomEquipmentVO();
			mEquipmentVO.setEquipmentId(equipmentID);
			mEquipmentVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			ServiceFactory.getMeetingroomEquipmentService().add(mEquipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	videoCardAdd	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	videoCardAdd	end");
		return SUCCESS;
	}
	
	
	public String videoCardDetail(){
		logger.info("EquipmentAction	videoCardDetail	begin");
		try {
			ArrayList<EquipmentVO> videoVOlong = new ArrayList<EquipmentVO>();
			String equipmentID=equipmentVO.getEquipmentID();
			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
			videoCardVO=ServiceFactory.getVideoCardService().queryByID(equipmentID);
			if(videoCardVO!=null){
				videoVOlong.add(ServiceFactory.getEquipmentService().queryByID(videoCardVO.getEquipmentID()));
			}
			equipmentVOListsss =videoVOlong;
		} catch (Exception e) {
			logger.error("EquipmentAction	videoCardDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	videoCardDetail	end");
		return SUCCESS;
	}

	/**
	 * 修改比对卡
	 * @return
	 */
	public	String	videoCardBeforModify(){
		logger.info("EquipmentAction	videoCardBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 videoCardVO=ServiceFactory.getVideoCardService().queryByID(equipmentVO.getEquipmentID());
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		}catch(Exception e){
			logger.error("EquipmentAction	videoCardBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	videoCardBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 复制比对卡
	 * @return
	 */
	public	String	videoCardBeforCopy(){
		logger.info("EquipmentAction	videoCardBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 videoCardVO=ServiceFactory.getVideoCardService().queryByID(equipmentVO.getEquipmentID());
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		}catch(Exception e){
			logger.error("EquipmentAction	videoCardBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	videoCardBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改保存比对卡
	 * @return
	 */
	public	String	videoCardModify(){
		logger.info("EquipmentAction	videoCardModify	begin");
		try{
			//前台传递设备厂家和设备型号参数均为z_t_equipment_dictionary表中的dicID
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			equipmentVO.setEquipmentName(deEquipmentVO.getDicName());
	//		DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
	//		equipmentVO.setEquipmentModel(String.valueOf(dVo.getDicValue()));
			
		    ServiceFactory.getEquipmentService().modifyVideoCard(equipmentVO, videoCardVO);
		    
		    //修改中间表的数据
			MeetingroomEquipmentVO mVO = new MeetingroomEquipmentVO();
		    mVO.setEquipmentId(equipmentVO.getEquipmentID());
		    mVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
		    ServiceFactory.getMeetingroomEquipmentService().modify(mVO);
		}catch(Exception e){
			logger.error("EquipmentAction	videoCardModify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	videoCardModify	end");
		return SUCCESS;
	}
	
	//add by duting
	/**
	 * 根据ID查询话筒信息
	 * @return
	 */
	public String microphoneDetail(){
		logger.info("EquipmentAction	microphoneDetail	begin");
		try {
			String equipmentID=equipmentVO.getEquipmentID();
			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
		} catch (Exception e) {
			logger.error("EquipmentAction	microphoneDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	microphoneDetail	end");
		return SUCCESS;
	}
	/**
	 * 添加及注册话筒
	 * @return
	 */
      public String	microphoneBeforAdd(){
		
		logger.info("EquipmentAction	microphoneBeforAdd	begin");
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction	microphoneBeforAdd	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存及注册话筒
	 * @return
	 */
	public	String	microphoneAdd(){
		logger.info("EquipmentAction	microphoneAdd	begin");
		try{
		    ServiceFactory.getEquipmentService().addEquipmentMicrophone(equipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	microphoneAdd	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	microphoneAdd	end");
		return SUCCESS;
	}
	/**
	 * 修改话筒
	 * @return
	 */
	public	String	microphoneBeforModify(){
		logger.info("EquipmentAction	microphoneBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
		}catch(Exception e){
			logger.error("EquipmentAction	microphoneBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	microphoneBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改保存话筒
	 * @return
	 */
	public	String	microphoneModify(){
		logger.info("EquipmentAction	microphoneModify	begin");
		try{
		    ServiceFactory.getEquipmentService().modify(equipmentVO);
		}catch(Exception e){
			logger.error("EquipmentAction	microphoneModify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	microphoneModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改mcu
	 * @return
	 */
	public	String	mcuBeforModify(){
		logger.info("EquipmentAction	mcuBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 equipmentMcuVO=ServiceFactory.getEquipmentMcuService().queryByID(equipmentVO.getEquipmentID());
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
			 
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
		}catch(Exception e){
			logger.error("EquipmentAction	mcuBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	mcuBeforModify	end");
		return SUCCESS;
	}
	
	
	/**
	 * 复制mcu
	 * @return
	 */
	public	String	mcuBeforCopy(){
		logger.info("EquipmentAction	mcuBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 equipmentMcuVO=ServiceFactory.getEquipmentMcuService().queryByID(equipmentVO.getEquipmentID());
			 
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		}catch(Exception e){
			logger.error("EquipmentAction	mcuBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	mcuBeforModify	end");
		return SUCCESS;
	}
	
	
	/**
	 * 修改保存mcu
	 * @return
	 */
	public	String	mcuModify(){
		logger.info("EquipmentAction	mcuModify	begin");
		try{
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			
			//前台传递设备厂家和设备型号参数均为z_t_equipment_dictionary表中的dicID
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			equipmentVO.setEquipmentName(deEquipmentVO.getDicName());
			DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentModel(String.valueOf(dVo.getDicValue()));
			int isCheck = equipmentMcuVO.getIsCheck();
			if(isCheck==Integer.MIN_VALUE){
				equipmentMcuVO.setIsCheck(0);
			}
		    ServiceFactory.getEquipmentService().modifyEquipmentMcu(equipmentVO, equipmentMcuVO);
		    MeetingroomEquipmentVO mVO = new MeetingroomEquipmentVO();
		    mVO.setEquipmentId(equipmentVO.getEquipmentID());
		    mVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
		    ServiceFactory.getMeetingroomEquipmentService().modify(mVO);
		    
		}catch(Exception e){
			logger.error("EquipmentAction	mcuModify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	mcuModify	end");
		return SUCCESS;
	}
	
	/**
	 * 复制终端信息
	 * @return
	 */
	public	String	terminalBeforCopy(){
		logger.info("EquipmentAction	terminalBeforModify	begin");
		try{
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO lu = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			 equipmentVOListsss=ServiceFactory.getEquipmentService().queryMCUID(tev);
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 equipmentTerminalVO=ServiceFactory.getEquipmentTerminalService().queryByID(equipmentVO.getEquipmentID());
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
				
			 }
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		}catch(Exception e){
			logger.error("EquipmentAction	terminalBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	terminalBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改终端信息
	 * @return
	 */
	public	String	terminalBeforModify(){
		logger.info("EquipmentAction	terminalBeforModify	begin");
		try{
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO lu = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			 equipmentVOListsss=ServiceFactory.getEquipmentService().queryMCUID(tev);
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 if(dList.size()==1)
				 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
			 
			 equipmentTerminalVO=ServiceFactory.getEquipmentTerminalService().queryByID(equipmentVO.getEquipmentID());
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
		}catch(Exception e){
			logger.error("EquipmentAction	terminalBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	terminalBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改保存终端信息
	 * @return
	 */
	public	String	terminalModify(){
		logger.info("EquipmentAction	terminalModify	begin");
		try{
			if(equipmentTerminalVO.getRadioTreaty().equals(EquipmentEnum.COMMUCONV_E164)){
				equipmentVO.setIp(equipmentTerminalVO.getPstn());
			}
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			//前台传递设备厂家和设备型号参数均为z_t_equipment_dictionary表中的dicID
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			equipmentVO.setEquipmentName(deEquipmentVO.getDicName());
			DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentModel(String.valueOf(dVo.getDicValue()));
			
			int isCheck = equipmentTerminalVO.getIsCheck();
			if(isCheck==Integer.MIN_VALUE){
				equipmentTerminalVO.setIsCheck(0);
			}
			
			ServiceFactory.getEquipmentService().modifyEquipmentTerminal(equipmentVO, equipmentTerminalVO);
			//修改中间表的数据
			MeetingroomEquipmentVO mVO = new MeetingroomEquipmentVO();
		    mVO.setEquipmentId(equipmentVO.getEquipmentID());
		    mVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
		    ServiceFactory.getMeetingroomEquipmentService().modify(mVO);
		}catch(Exception e){
			logger.error("EquipmentAction	terminalModify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	terminalModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改中控
	 * @return
	 */
	public	String	controlBeforModify(){
		logger.info("EquipmentAction	controlBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 
			///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
			 
		}catch(Exception e){
			logger.error("EquipmentAction	controlBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	controlBeforModify	end");
		return SUCCESS;
	}
	
	

	/**
	 * 复制中控
	 * @return
	 */
	public	String	controlBeforCopy(){
		logger.info("EquipmentAction	controlBeforModify	begin");
		try{
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 
			///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		}catch(Exception e){
			logger.error("EquipmentAction	controlBeforModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	controlBeforModify	end");
		return SUCCESS;
	}
	
	/**
	 * 修改保存中控
	 * @return
	 */
	public	String	controlModify(){
		logger.info("EquipmentAction	controlModify	begin");
		try{
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			//前台传递设备厂家和设备型号参数均为z_t_equipment_dictionary表中的dicID
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			equipmentVO.setEquipmentName(deEquipmentVO.getDicName());
			DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentModel(String.valueOf(dVo.getDicValue()));
			
		    ServiceFactory.getEquipmentService().modify(equipmentVO);
		    
		    //修改中间表的数据
			MeetingroomEquipmentVO mVO = new MeetingroomEquipmentVO();
		    mVO.setEquipmentId(equipmentVO.getEquipmentID());
		    mVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
		    ServiceFactory.getMeetingroomEquipmentService().modify(mVO);
		}catch(Exception e){
			logger.error("EquipmentAction	controlModify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("EquipmentAction	controlModify	end");
		return SUCCESS;
	}
	
	/**
	 * 根据id删除设备管理信息
	 * @return
	 */
	public	String	delete(){
		logger.info("EquipmentAction	delete	begin");
		try {
//			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			ServiceFactory.getEquipmentService().modifyState(equipmentVO);
			ServiceFactory.getMeetingroomEquipmentService().deleteByID(equipmentVO.getEquipmentID());
		} catch (Exception e) {
			logger.error("EquipmentAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	delete	end");
		return	SUCCESS;
	}
	
	public String equipmentBeforeAdd(){
		logger.info("EquipmentAction	equipmentBeforeAdd	begin");
		try {
			BaseInfoService bis = ServiceFactory.getBaseInfoService();
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE);
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
			baseInfoList = bis.query(baseInfoVO, null);
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
			UserVO lu = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			equipmentVOListsss=ServiceFactory.getEquipmentService().queryMCUID(tev);
		} catch (Exception e) {
			logger.error("EquipmentAction	equipmentBeforeAdd	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	equipmentBeforeAdd	end");
		return SUCCESS;
	}
	
	public String otherEquipmentBeforeAdd(){
		logger.info("EquipmentAction	otherEquipmentBeforeAdd 	begin");
		try {
			//管理员默认为当前系统登录用户
			UserVO userVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			this.getCurHttpServletRequest().setAttribute("userName", userVO.getName());
			this.getCurHttpServletRequest().setAttribute("userID", userVO.getUserID());
			
			DictionaryEquipmentVO deEquipmentVO = new DictionaryEquipmentVO();
			deEquipmentVO.setParentID(DateBaseEnum.Default_ID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(deEquipmentVO, null);
			this.getServletRequest().setAttribute("deList", deList);
			this.getCurHttpServletRequest().setAttribute("style5", styleBackColor);
		} catch (Exception e) {
			logger.error("EquipmentAction	otherEquipmentBeforeAdd	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	otherEquipmentBeforeAdd	end");
		return SUCCESS;
	}
	
	
	
	public String otherEquipmentAdd(){
		logger.info("EquipmentAction	otherEquipmentAdd 	begin");
		try {
			equipmentVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			///计算维保到期日add on 2013-5-7 by chenshuo
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			String equipmentID = UtilDAO.getUUid();
			equipmentVO.setEquipmentID(equipmentID);
			DictionaryEquipmentVO dEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentName(dEquipmentVO.getDicName());
			equipmentVO.setEquipmentModel(String.valueOf(deEquipmentVO.getDicValue()));
			equipmentVO.setEquipmentType(Integer.parseInt(dEquipmentVO.getParentID()));
		    ServiceFactory.getEquipmentService().addEqupment(equipmentVO);
		    
		    //往z_t_meetingRoom_equipment表插入数据。
		    MeetingroomEquipmentVO mEquipmentVO = new MeetingroomEquipmentVO();
			mEquipmentVO.setEquipmentId(equipmentID);
			mEquipmentVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
			ServiceFactory.getMeetingroomEquipmentService().add(mEquipmentVO);
		} catch (Exception e) {
			logger.error("EquipmentAction	otherEquipmentAdd	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	otherEquipmentAdd	end");
		return SUCCESS;
	}
	
	public String otherEquipmentBeforeModify(){
		logger.info("EquipmentAction	otherEquipmentBeforeModify 	begin");
		try {
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		} catch (Exception e) {
			logger.error("EquipmentAction	otherEquipmentBeforeModify	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	otherEquipmentBeforeModify	end");
		return SUCCESS;
	}
	
	/**
	 * 复制其他设备
	 * @return
	 */
	public String otherEquipmentBeforeCopy(){
		logger.info("EquipmentAction	otherEquipmentBeforeModify 	begin");
		try {
			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		} catch (Exception e) {
			logger.error("EquipmentAction	otherEquipmentBeforeModify	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	otherEquipmentBeforeModify	end");
		return SUCCESS;
	}
	
	public String otherEquipmentModify(){
		logger.info("EquipmentAction	otherEquipmentModify 	begin");
		try {
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			
			//前台传递设备厂家和设备型号参数均为z_t_equipment_dictionary表中的dicID
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			equipmentVO.setEquipmentName(deEquipmentVO.getDicName());
			DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentModel(String.valueOf(dVo.getDicValue()));
			
		    ServiceFactory.getEquipmentService().modify(equipmentVO);
		    
		    //修改中间表的数据
			MeetingroomEquipmentVO mVO = new MeetingroomEquipmentVO();
		    mVO.setEquipmentId(equipmentVO.getEquipmentID());
		    mVO.setRoomId(equipmentVO.getMeetingRoomVO().getMeetingRoomID());
		    ServiceFactory.getMeetingroomEquipmentService().modify(mVO);
			 
		} catch (Exception e) {
			logger.error("EquipmentAction	otherEquipmentModify	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	otherEquipmentModify	end");
		return SUCCESS;
	}
	
	public String otherEquipmentDetail(){
		logger.info("EquipmentAction	otherEquipmentDetail 	begin");
		try {
			String equipmentID=equipmentVO.getEquipmentID();
			equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
			///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
		} catch (Exception e) {
			logger.error("EquipmentAction	otherEquipmentDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	otherEquipmentDetail	end");
		return SUCCESS;
	}
	//设备管理~~维保期查询
	public String queryEquipmentMaintenance(){
		logger.info("EquipmentAction	queryEquipmentMaintenance 	begin");
		try {
			///////////////会议室分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentVO.setLevel(true);
					equipmentVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			
			equipmentVOList	=	ServiceFactory.getEquipmentService().query(equipmentVO, getPageControler());
			for( EquipmentVO eq : equipmentVOList){
				///计算时间差值
				 if( eq.getMaintenanceStartTime() != null && eq.getMaintenanceEndTime() != null){
					 Calendar sc = Calendar.getInstance();
					 sc.setTimeInMillis(eq.getMaintenanceStartTime().getTime());
					 int scYear  = sc.get(Calendar.YEAR);
					 int scMonth = sc.get(Calendar.MONTH);
					 
					 Calendar ec = Calendar.getInstance();
					 ec.setTimeInMillis(eq.getMaintenanceEndTime().getTime());
					 int ecYear  = ec.get(Calendar.YEAR);
					 int ecMonth = ec.get(Calendar.MONTH);
					 
					 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
					 eq.setMaintenanceMonths(duringMonth);
				 }
			}
		} catch (Exception e) {
			logger.error("EquipmentAction	queryEquipmentMaintenance	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	queryEquipmentMaintenance	end");
		return SUCCESS;
	}
	
	public String queryUselessEquipment(){
		logger.info("EquipmentAction	queryUselessEquipment 	begin");
		try {
			///////////////会议室分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentVO.setLevel(true);
					equipmentVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			equipmentVO.setStatus(EquipmentEnum.STATUS_USELESS);
			equipmentVOList	=	ServiceFactory.getEquipmentService().queryScrap(equipmentVO, getPageControler());
			for( EquipmentVO eq : equipmentVOList){
				///计算时间差值
				 if( eq.getMaintenanceStartTime() != null && eq.getMaintenanceEndTime() != null){
					 Calendar sc = Calendar.getInstance();
					 sc.setTimeInMillis(eq.getMaintenanceStartTime().getTime());
					 int scYear  = sc.get(Calendar.YEAR);
					 int scMonth = sc.get(Calendar.MONTH);
					 
					 Calendar ec = Calendar.getInstance();
					 ec.setTimeInMillis(eq.getMaintenanceEndTime().getTime());
					 int ecYear  = ec.get(Calendar.YEAR);
					 int ecMonth = ec.get(Calendar.MONTH);
					 
					 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
					 eq.setMaintenanceMonths(duringMonth);
				 }
			}
		} catch (Exception e) {
			logger.error("EquipmentAction	queryUselessEquipment	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	queryUselessEquipment	end");
		return SUCCESS;
	}
	
	public String exportUselessEquipment(){
		logger.info("EquipmentAction	exportUselessEquipment 	begin");
		try {
			equipmentVO.setStatus(EquipmentEnum.STATUS_USELESS);
			equipmentVOList	=	ServiceFactory.getEquipmentService().query(equipmentVO, getPageControler());

			String fileName = "uselessEquipment.xls";
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			if(equipmentVOList!=null&&equipmentVOList.size()>0){	
			for (int i = 0; i < equipmentVOList.size(); i++) {
				EquipmentVO lVO = equipmentVOList.get(i);
				CellVO[] cell = new CellVO[11];
				CellVO ex0 = new CellVO();
				ex0.setValue(i+1+"");
				cell[0] = ex0;
				
				CellVO ex1 = new CellVO();
				ex1.setValue(lVO.getEquipmentName());
				cell[1] = ex1;
				
				CellVO ex2 = new CellVO();
				for(String[] s : EquipmentEnum.getEquipmentType()){
					 if(s==null)	continue;
					 if(s[0].equalsIgnoreCase(lVO.getEquipmentType()+"")){
						 ex2.setValue(s[1]);
						 continue;
					 }
				}
				
				cell[2] = ex2;
				
				CellVO ex3 = new CellVO();
				ex3.setValue(lVO.getIp());
				cell[3] = ex3;
				
				CellVO ex4 = new CellVO();
				ex4.setValue(lVO.getMeetingRoomVO().getMeetingRoomName());
				cell[4] = ex4;
				
				CellVO ex5 = new CellVO();
				ex5.setValue(lVO.getUserVO().getName());
				cell[5] = ex5;
				
				CellVO ex6 = new CellVO();
				for(String[] s : EquipmentEnum.getTerminalStatus()){
					 if(s==null)	continue;
					 if(s[0].equalsIgnoreCase(lVO.getStatus()+"")){
						 ex6.setValue(s[1]);
						 continue;
					 }
				 }
				cell[6] = ex6;
				
				CellVO ex7 = new CellVO();
				if( lVO.getMaintenanceStartTime() != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(new Date(lVO.getMaintenanceStartTime().getTime()));
					ex7.setValue(date);
				}else{
					ex7.setValue("");
				}
				cell[7] = ex7;
				
				CellVO ex8 = new CellVO();
				///计算时间差值
			    if( lVO.getMaintenanceStartTime() != null && lVO.getMaintenanceEndTime() != null){
					 Calendar sc = Calendar.getInstance();
					 sc.setTimeInMillis(lVO.getMaintenanceStartTime().getTime());
					 int scYear  = sc.get(Calendar.YEAR);
					 int scMonth = sc.get(Calendar.MONTH);
					 
					 Calendar ec = Calendar.getInstance();
					 ec.setTimeInMillis(lVO.getMaintenanceEndTime().getTime());
					 int ecYear  = ec.get(Calendar.YEAR);
					 int ecMonth = ec.get(Calendar.MONTH);
					 
					 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
					 ex8.setValue(duringMonth+"个月");
				 }else{
					 ex8.setValue("");
				 }
				cell[8] = ex8;
				
				CellVO ex9 = new CellVO();
				ex9.setValue(lVO.getEquipmentIdentifier());
				cell[9] = ex9;
				
				CellVO ex10 = new CellVO();
				ex10.setValue(lVO.getSerialNumber());
				cell[10] = ex10;
				
				list.add(cell);
				}
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
		} catch (Exception e) {
			logger.error("EquipmentAction	exportUselessEquipment	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	exportUselessEquipment	end");
		return SUCCESS;
	}
	
	/**
	 * 导出设备（一个设备对应多个会议室）
	 * @return
	 */
	public String exportEquipments(){
		logger.info("EquipmentAction	exportEquipments	begin");
		try{
			equipmentVOList=ServiceFactory.getEquipmentService().queryEquipments(equipmentVO, null);
			String fileName = "equipments.xls";
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			if(equipmentVOList!=null&&equipmentVOList.size()>0){	
			for (int i = 0; i < equipmentVOList.size(); i++) {
				EquipmentVO lVO = equipmentVOList.get(i);
				CellVO[] cell = new CellVO[11];
				CellVO ex0 = new CellVO();
				ex0.setValue(i+1+"");
				cell[0] = ex0;
				
				CellVO ex1 = new CellVO();
				ex1.setValue(lVO.getEquipmentNO());
				cell[1] = ex1;
				
				CellVO ex2 = new CellVO();
				for(String[] s : EquipmentEnum.getEquipmentType()){
					 if(s==null)	continue;
					 if(s[0].equalsIgnoreCase(lVO.getEquipmentType()+"")){
						 ex2.setValue(s[1]);
						 continue;
					 }
				}
				cell[2] = ex2;
				
				CellVO ex3 = new CellVO();
				ex3.setValue(lVO.getIp());
				cell[3] = ex3;
				
				CellVO ex4 = new CellVO();
				ex4.setValue(lVO.getMeetingRoomVO().getMeetingRoomName());
				cell[4] = ex4;
				
				CellVO ex5 = new CellVO();
				ex5.setValue(lVO.getUserVO().getName());
				cell[5] = ex5;
				
				CellVO ex6 = new CellVO();
				for(String[] s : EquipmentEnum.getTerminalStatus()){
					 if(s==null)	continue;
					 if(s[0].equalsIgnoreCase(lVO.getStatus()+"")){
						 ex6.setValue(s[1]);
						 continue;
					 }
				 }
				cell[6] = ex6;
				
				CellVO ex7 = new CellVO();
				if( lVO.getMaintenanceStartTime() != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(new Date(lVO.getMaintenanceStartTime().getTime()));
					ex7.setValue(date);
				}else{
					ex7.setValue("");
				}
				cell[7] = ex7;
				
				CellVO ex8 = new CellVO();
				///计算时间差值
			    if( lVO.getMaintenanceStartTime() != null && lVO.getMaintenanceEndTime() != null){
					 Calendar sc = Calendar.getInstance();
					 sc.setTimeInMillis(lVO.getMaintenanceStartTime().getTime());
					 int scYear  = sc.get(Calendar.YEAR);
					 int scMonth = sc.get(Calendar.MONTH);
					 
					 Calendar ec = Calendar.getInstance();
					 ec.setTimeInMillis(lVO.getMaintenanceEndTime().getTime());
					 int ecYear  = ec.get(Calendar.YEAR);
					 int ecMonth = ec.get(Calendar.MONTH);
					 
					 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
					 ex8.setValue(duringMonth+"个月");
				 }else{
					 ex8.setValue("");
				 }
				cell[8] = ex8;
				
				CellVO ex9 = new CellVO();
				ex9.setValue(lVO.getEquipmentIdentifier());
				cell[9] = ex9;
				
				CellVO ex10 = new CellVO();
				ex10.setValue(lVO.getSerialNumber());
				cell[10] = ex10;
				
				list.add(cell);
				}
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
		}catch(Exception e){
			logger.error("EquipmentAction	exportEquipments	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	exportEquipments	end");
		return "success";
	}
	
	public String queryEquipments(){
		logger.info("EquipmentAction	queryEquipments	begin");
		try{
			 ///////////////会议室分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentVO.setLevel(true);
					equipmentVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			equipmentVOList=ServiceFactory.getEquipmentService().queryEquipments(equipmentVO, null);
			int equipmentTypes= equipmentVO.getEquipmentType();
			this.getCurHttpServletRequest().setAttribute("equipmentTypes", equipmentTypes);
		}catch(Exception e){
			logger.error("EquipmentAction	queryEquipments	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	queryEquipments	end");
		return SUCCESS;
	}
	
	public String deleteEquipments(){
		logger.info("EquipmentAction  deleteEquipments   begin");
		try {
			ServiceFactory.getEquipmentService().deleteByID(equipmentVO.getEquipmentID());
			ServiceFactory.getMeetingroomEquipmentService().deleteByID(equipmentVO.getEquipmentID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("EquipmentAction  deleteEquipments   end");
		return SUCCESS;
	}
	
	public String equipmentsBeforeAdd(){
		logger.info("EquipmentAction	equipmentsBeforeAdd	begin");
		try {
			BaseInfoService bis = ServiceFactory.getBaseInfoService();
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE);
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
			baseInfoList = bis.query(baseInfoVO, null);
			for(BaseInfoVO vo:baseInfoList){
				if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_ENC){
					return "enc";
				}else if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_AUDIO){
					return "audio";
				}
			}
		} catch (Exception e) {
			logger.error("EquipmentAction	equipmentBeforeAdd	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	equipmentsBeforeAdd	end");
		return SUCCESS;
	}
	
	/**
	 * 设备管理模块，增加按钮。add by liujf 20131111
	 * @return
	 */
	public String equipmentsAddBefore(){
		logger.info("EquipmentAction	equipmentsBeforeAdd	begin");
		try {
			BaseInfoService bis = ServiceFactory.getBaseInfoService();
			BaseInfoVO baseInfoVO = new BaseInfoVO();
			baseInfoVO.setDescription(BaseInfoEnum.DICTIONARY_EQUIPMENT_TYPE);
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
			baseInfoList = bis.query(baseInfoVO, null);
			for(BaseInfoVO vo:baseInfoList){
				if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_TERMINAL){
					return "terminal";
				}else if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_MCU){
					return "mcu";
				}else if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_CENTERCONTROL){
					return "centerControl";
				}else if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_VIDEOCARD){
					return "videoCard";
				}else if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_OTHEREQUIPMENT){
					return "otherEquipment";
				}else if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_ENC){
					return "enc";
				}else if(Integer.parseInt(vo.getInfoValue())==EquipmentEnum.TYPE_ID_AUDIO){
					return "audio";
				}
			}
		} catch (Exception e) {
			logger.error("EquipmentAction	equipmentBeforeAdd	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	equipmentsBeforeAdd	end");
		return SUCCESS;
	}
	
	public String audioBeforeAdd(){
		logger.info("EquipmentAction	audioBeforeAdd 	begin");
		try {
			//管理员默认为当前系统登录用户
			UserVO userVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			this.getCurHttpServletRequest().setAttribute("userName", userVO.getName());
			this.getCurHttpServletRequest().setAttribute("userID", userVO.getUserID());
			
			DictionaryEquipmentVO deEquipmentVO = new DictionaryEquipmentVO();
			deEquipmentVO.setParentID(DateBaseEnum.Default_ID);
			ArrayList<DictionaryEquipmentVO> deList = ServiceFactory.getDictionaryEquipmentService().queryByPid(deEquipmentVO, null);
			this.getServletRequest().setAttribute("deList", deList);
			this.getCurHttpServletRequest().setAttribute("style7", styleBackColor);
		} catch (Exception e) {
			logger.error("EquipmentAction	audioBeforeAdd	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	audioBeforeAdd	end");
		return SUCCESS;
	}
	
	public String audioAdd(){
		logger.info("EquipmentAction	audioAdd 	begin");
		try {
			equipmentVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			///计算维保到期日add on 2013-5-7 by chenshuo
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			String[] roomIds = equipmentVO.getMeetingRoomVO().getMeetingRoomID().split(",");
			equipmentVO.getMeetingRoomVO().setMeetingRoomID(null);
//			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_AUDIO);
//			equipmentVO.setEquipmentName("宝利通音频处理器");
			
			DictionaryEquipmentVO dEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentName(dEquipmentVO.getDicName());
			equipmentVO.setEquipmentModel(String.valueOf(deEquipmentVO.getDicValue()));
		  EquipmentVO eqVO =   ServiceFactory.getEquipmentService().addEqupment(equipmentVO);
		  if(eqVO!=null){
		    	MeetingroomEquipmentVO meVO = new MeetingroomEquipmentVO();
				for(int i=0;i<roomIds.length;i++){
					meVO.setRoomId(roomIds[i]);
					meVO.setEquipmentId(eqVO.getEquipmentID());
					ServiceFactory.getMeetingroomEquipmentService().add(meVO);
				}
		    }
		} catch (Exception e) {
			logger.error("EquipmentAction	audioAdd	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	audioAdd	end");
		return SUCCESS;
	}
	
	public String audioBeforeModify(){
		logger.info("EquipmentAction	audioBeforeModify 	begin");
		try {
//			 equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentVO.getEquipmentID());
			equipmentVOList=ServiceFactory.getEquipmentService().queryEquipments(equipmentVO, getPageControler());
			if(equipmentVOList!=null&&equipmentVOList.size()>0){
				equipmentVO = equipmentVOList.get(0);
			}
			 ///计算时间差值
			 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
				 Calendar sc = Calendar.getInstance();
				 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
				 int scYear  = sc.get(Calendar.YEAR);
				 int scMonth = sc.get(Calendar.MONTH);
				 
				 Calendar ec = Calendar.getInstance();
				 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
				 int ecYear  = ec.get(Calendar.YEAR);
				 int ecMonth = ec.get(Calendar.MONTH);
				 
				 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
				 equipmentVO.setMaintenanceMonths(duringMonth);
			 }
			 
			 DictionaryEquipmentVO dEquipmentVO = new DictionaryEquipmentVO();
			 dEquipmentVO.setDicName(equipmentVO.getEquipmentName());
			 dEquipmentVO.setParentID(String.valueOf(equipmentVO.getEquipmentType()));
			 ArrayList<DictionaryEquipmentVO> dList=ServiceFactory.getDictionaryEquipmentService().query(dEquipmentVO, null);
			 this.getCurHttpServletRequest().setAttribute("dicName", dList.get(0).getDicID());
		} catch (Exception e) {
			logger.error("EquipmentAction	audioBeforeModify	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	audioBeforeModify	end");
		return SUCCESS;
	}
	
	public String audioModify(){
		logger.info("EquipmentAction	audioModify 	begin");
		try {
		    ServiceFactory.getMeetingroomEquipmentService().deleteByID(equipmentVO.getEquipmentID());
			String[] roomIds = equipmentVO.getMeetingRoomVO().getMeetingRoomID().split(",");
			MeetingroomEquipmentVO meVO = new MeetingroomEquipmentVO();
			for(int i=0;i<roomIds.length;i++){
				meVO.setRoomId(roomIds[i]);
				meVO.setEquipmentId(equipmentVO.getEquipmentID());
				ServiceFactory.getMeetingroomEquipmentService().add(meVO);
			}
			if( equipmentVO.getMaintenanceStartTime() != null ){
				int durinMonths = equipmentVO.getMaintenanceMonths();
				Long st = equipmentVO.getMaintenanceStartTime().getTime();
				Calendar sc = Calendar.getInstance();
				sc.setTimeInMillis(st);
				sc.add(Calendar.MONTH, durinMonths);
			    Long et = sc.getTimeInMillis();
			    equipmentVO.setMaintenanceEndTime(new Timestamp(et));
			}
			equipmentVO.getMeetingRoomVO().setMeetingRoomID(null);
			
			//前台传递设备厂家和设备型号参数均为z_t_equipment_dictionary表中的dicID
			DictionaryEquipmentVO deEquipmentVO = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentName());
			equipmentVO.setEquipmentName(deEquipmentVO.getDicName());
			DictionaryEquipmentVO dVo = ServiceFactory.getDictionaryEquipmentService().queryByID(equipmentVO.getEquipmentModel());
			equipmentVO.setEquipmentModel(String.valueOf(dVo.getDicValue()));
			
		    ServiceFactory.getEquipmentService().modify(equipmentVO);
		} catch (Exception e) {
			logger.error("EquipmentAction	audioModify	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	audioModify	end");
		return SUCCESS;
	}
	
	public String audioDetail(){
		logger.info("EquipmentAction	audioDetail 	begin");
		try {
			equipmentVOList=ServiceFactory.getEquipmentService().queryEquipments(equipmentVO, getPageControler());
			if(equipmentVOList!=null&&equipmentVOList.size()>0){
				equipmentVO = equipmentVOList.get(0);
				
				///计算时间差值
				 if( equipmentVO.getMaintenanceStartTime() != null && equipmentVO.getMaintenanceEndTime() != null){
					 Calendar sc = Calendar.getInstance();
					 sc.setTimeInMillis(equipmentVO.getMaintenanceStartTime().getTime());
					 int scYear  = sc.get(Calendar.YEAR);
					 int scMonth = sc.get(Calendar.MONTH);
					 
					 Calendar ec = Calendar.getInstance();
					 ec.setTimeInMillis(equipmentVO.getMaintenanceEndTime().getTime());
					 int ecYear  = ec.get(Calendar.YEAR);
					 int ecMonth = ec.get(Calendar.MONTH);
					 
					 int duringMonth = 12*(ecYear - scYear) + ( ecMonth - scMonth);
					 equipmentVO.setMaintenanceMonths(duringMonth);
				 }
			}
		} catch (Exception e) {
			logger.error("EquipmentAction	audioDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	audioDetail	end");
		return SUCCESS;
	}
	/**
	 * 查询mcu端口使用率 add by liujf20131203
	 * @return
	 */
	public String equipmentMcuUsedRate(){
		logger.info("EquipmentAction	equipmentMcuUsedRate	begin");
		try{
          ///////////////会议室分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentVO.setLevel(true);
					equipmentVO.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);//类型设置为MCU类型
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO, getPageControler());
			if(equipmentVOList!=null&&equipmentVOList.size()>0){
				for(int i=0;i<equipmentVOList.size();i++){
					for(EquipmentVO vo:equipmentVOList){
						vo = equipmentVOList.get(i);
						equipmentMcuVO = ServiceFactory.getEquipmentMcuService().queryByID(vo.getEquipmentID());
						if(equipmentMcuVO!=null){
							ZZOMcuRSRCReportVO reportVO = ZZOMcuFactory.getInstance().getMcuControlHelper().getMcuRSRCReport(vo.getEquipmentModel(),vo.getIp() , equipmentMcuVO.getLoginName(), equipmentMcuVO.getLoginPassword());
							if(reportVO!=null){
							vo.setAudioTotal(Integer.parseInt(reportVO.getAudioTotal()));
							vo.setAudioUsing(Integer.parseInt(reportVO.getAudioTotal())-Integer.parseInt(reportVO.getAudioFree()));
							vo.setVedioTotal(Integer.parseInt(reportVO.getVideoTotal()));
							vo.setVedioUsing(Integer.parseInt(reportVO.getVideoTotal())-Integer.parseInt(reportVO.getVideoFree()));
							this.getCurHttpServletRequest().setAttribute("equipmentVO", vo);
							}
						}
					}
				}
			}
		}catch(Exception e){
			logger.error("EquipmentAction	equipmentMcuUsedRate	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	equipmentMcuUsedRate	end");
		return SUCCESS;
	}
	
	/**
	 * 设备组list页面 add by liujf20140606
	 * @return
	 */
	public String equipmentGroup(){
		logger.info("EquipmentAction	equipmentGroup	begin");
		try{
		if(equipmentGroupVO.getGroupname()!=null && equipmentGroupVO.getGroupname()!=""){
			egList = ServiceFactory.getEquipmentGroupService().queryFuzzySearch(equipmentGroupVO.getGroupname(), null);
		}else{
           egList = ServiceFactory.getEquipmentGroupService().query(null);
		}
		}catch(Exception e){
			logger.error("EquipmentAction	equipmentGroup	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	equipmentGroup	end");
		return SUCCESS;
	}
	
	/**
	 * 设备组删除 add by liujf20140606
	 * @return
	 */
	public String equipmentGroupdelete(){
		logger.info("EquipmentAction	equipmentGroupdelete	begin");
		try{
			String groupname = equipmentGroupVO.getGroupname();
			groupname = new String(groupname.getBytes("iso-8859-1"),"utf-8");

			ServiceFactory.getEquipmentGroupService().deleteByName(groupname);
		}catch(Exception e){
			logger.error("EquipmentAction	equipmentGroupdelete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentAction	equipmentGroupdelete	end");
		return SUCCESS;
	}
	
	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public ArrayList<EquipmentVO> getEquipmentVOList() {
		return equipmentVOList;
	}

	public void setEquipmentVOList(ArrayList<EquipmentVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}

	public EquipmentTerminalVO getEquipmentTerminalVO() {
		return equipmentTerminalVO;
	}

	public void setEquipmentTerminalVO(EquipmentTerminalVO equipmentTerminalVO) {
		this.equipmentTerminalVO = equipmentTerminalVO;
	}

	public EquipmentMcuVO getEquipmentMcuVO() {
		return equipmentMcuVO;
	}

	public void setEquipmentMcuVO(EquipmentMcuVO equipmentMcuVO) {
		this.equipmentMcuVO = equipmentMcuVO;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public ArrayList<EquipmentMcuVO> getEquipmentMcuList() {
		return equipmentMcuList;
	}

	public void setEquipmentMcuList(ArrayList<EquipmentMcuVO> equipmentMcuList) {
		this.equipmentMcuList = equipmentMcuList;
	}

	public ArrayList<EquipmentVO> getEquipmentVOListsss() {
		return equipmentVOListsss;
	}

	public void setEquipmentVOListsss(ArrayList<EquipmentVO> equipmentVOListsss) {
		this.equipmentVOListsss = equipmentVOListsss;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public ArrayList<BaseInfoVO> getBaseInfoList() {
		return baseInfoList;
	}

	public void setBaseInfoList(ArrayList<BaseInfoVO> baseInfoList) {
		this.baseInfoList = baseInfoList;
	}

	public String getStyle1() {
		return style1;
	}

	public void setStyle1(String style1) {
		this.style1 = style1;
	}

	public String getStyle2() {
		return style2;
	}

	public void setStyle2(String style2) {
		this.style2 = style2;
	}

	public String getStyle3() {
		return style3;
	}

	public void setStyle3(String style3) {
		this.style3 = style3;
	}

	public String getStyle4() {
		return style4;
	}

	public void setStyle4(String style4) {
		this.style4 = style4;
	}

	public VideoCardVO getVideoCardVO() {
		return videoCardVO;
	}

	public void setVideoCardVO(VideoCardVO videoCardVO) {
		this.videoCardVO = videoCardVO;
	}

	public String getStyle5() {
		return style5;
	}

	public void setStyle5(String style5) {
		this.style5 = style5;
	}

	public String getStyle6() {
		return style6;
	}

	public void setStyle6(String style6) {
		this.style6 = style6;
	}

	public ArrayList<EquipmentGroupVO> getEgList() {
		return egList;
	}

	public void setEgList(ArrayList<EquipmentGroupVO> egList) {
		this.egList = egList;
	}

	public EquipmentGroupVO getEquipmentGroupVO() {
		return equipmentGroupVO;
	}

	public void setEquipmentGroupVO(EquipmentGroupVO equipmentGroupVO) {
		this.equipmentGroupVO = equipmentGroupVO;
	}
	
	
   
}
