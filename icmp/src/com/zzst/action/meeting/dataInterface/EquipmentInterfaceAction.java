package com.zzst.action.meeting.dataInterface;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.dataInterface.equipment.EquipmentInterfaceVO;
import com.zzst.model.meeting.dataInterface.terminal.TerminalInterfaceVO;
import com.zzst.model.meeting.equipment.EquipmentMcuVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.dataInterface.equipment.EquipmentInterfaceService;
import com.zzst.service.meeting.dataInterface.terminal.TerminalInterfaceService;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class EquipmentInterfaceAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(EquipmentInterfaceAction.class.getName());
	private static TerminalInterfaceService tis = ServiceFactory.getTerminalInterfaceService();
	private static EquipmentInterfaceService eis = ServiceFactory.getEquipmentInterfaceService();
	private TerminalInterfaceVO tifVO = new TerminalInterfaceVO();
	private EquipmentInterfaceVO difVO = new EquipmentInterfaceVO();
	private ArrayList<TerminalInterfaceVO> tifList = new ArrayList<TerminalInterfaceVO>();
	private ArrayList<EquipmentInterfaceVO> difList = new ArrayList<EquipmentInterfaceVO>();
	private ArrayList<EquipmentVO> equipmentVOListsss = new ArrayList<EquipmentVO>();
	private ArrayList<EquipmentTerminalVO> equipmentVOList = new ArrayList<EquipmentTerminalVO>();
	private EquipmentTerminalVO equipmentTerminalVO=new EquipmentTerminalVO();
	private InputStream  excelStream;
	
	public String queryEquipment(){
		logger.info("EquipmentInterfaceAction	queryEquipment	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			difList = eis.query(difVO, pSplittor.getPControler());
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	queryEquipment	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	queryTerminal	end");
		return SUCCESS; 
	}

	
	public String beforeModify(){
		logger.info("EquipmentInterfaceAction	beforeModify	begin");
		try{
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
		    UserVO lu = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			//UserVO lu = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			equipmentVOListsss=ServiceFactory.getEquipmentService().queryMCUID(tev);
			tifVO = tis.queryByID(tifVO.getEquipmentID());
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	beforeModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	beforeModify	end");
		return SUCCESS;
	}
	
	
	public String modify(){
		logger.info("EquipmentInterfaceAction	modify	begin");
		try{
			tifVO = tis.modify(tifVO);
			
			
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_terminal表 进行update操作");
				new LogServiceImpl().add(logVO);
			}
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	modify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	modify	end");
		return SUCCESS;
	}
	
	public String delete(){
		logger.info("EquipmentInterfaceAction	delete	begin");
		try{
			eis.deleteByID(difVO.getEquipmentID());
			
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_equipment表 进行delete操作");
				new LogServiceImpl().add(logVO);
			}
			
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	delete	end");
		return SUCCESS;
	}
	
	/**
	 * 终端详情
	 * @return
	 */
	public String detailTerminal(){
		logger.info("EquipmentInterfaceAction	detailTerminal	begin");
		try{
			difVO = eis.queryByID(difVO.getEquipmentID());
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	detailTerminal	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	detailTerminal	end");
		return SUCCESS;
	}
	
	/**
	 * Mcu详情
	 * @return
	 */
	public String detailMcu(){
		logger.info("EquipmentInterfaceAction	detailMcu	begin");
		try{
			difVO = eis.queryByID(difVO.getEquipmentID());
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	detailMcu	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	detailMcu	end");
		return SUCCESS;
	}
	
	/**
	 * 中控详情
	 * @return
	 */
	public String detailCenterControl(){
		logger.info("EquipmentInterfaceAction	detailCenterControl	begin");
		try{
			difVO = eis.queryByID(difVO.getEquipmentID());
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	detailCenterControl	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	detailCenterControl	end");
		return SUCCESS;
	}
	
	/**
	 * 对比卡详情
	 * @return
	 */
	public String detailVideoCard(){
		logger.info("EquipmentInterfaceAction	detailVideoCard	begin");
		try{
			difVO = eis.queryByID(difVO.getEquipmentID());
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	detailVideoCard	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	detailVideoCard	end");
		return SUCCESS;
	}
	
	/**
	 * 其他设备详情
	 * @return
	 */
	public String detailOtherEquipment(){
		logger.info("EquipmentInterfaceAction	detailOtherEquipment	begin");
		try{
			difVO = eis.queryByID(difVO.getEquipmentID());
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	detailOtherEquipment	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	detailOtherEquipment	end");
		return SUCCESS;
	}
	
	
	public String exportQuery(){
		logger.info("EquipmentInterfaceAction	exportQuery	begin");
		try{
			equipmentVOList=ServiceFactory.getEquipmentTerminalService().query(equipmentTerminalVO, null);
			//ArrayList<EquipmentTerminalVO> terminalList = ServiceFactory.getEquipmentTerminalService().query(equipmentTerminalVO, null);
			
			
			String fileName = "allEquipments.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitle(list);//添加表头
				if(equipmentVOList!=null&&equipmentVOList.size()>0){	
				for (int i = 0; i < equipmentVOList.size(); i++) {
					EquipmentTerminalVO lVO = equipmentVOList.get(i);
					CellVO[] cell = new CellVO[19];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getEquipmentNO());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(lVO.getIp());
					
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getMeetingRoomVO().getMeetingRoomName());
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getUserVO().getLoginName());
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					EquipmentVO em =  ServiceFactory.getEquipmentService().queryByID(lVO.getEquipmentMCUID());
					if( em != null ){
						ex5.setValue(em.getIp());//所属MCU ip
					}
					
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
				    ex7.setValue(lVO.getSerialNumber());
					cell[7] = ex7;
					
					list.add(cell);
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("EquipmentInterfaceAction	exportQuery	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("EquipmentInterfaceAction	exportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[19];
		CellVO ex0 = new CellVO();
		ex0.setValue("设备类型(0-终端 1-MCU 2-中控 7-对比卡 8-其他设备)");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("设备型号(终端:0-6000 1-8000 2-9000 mcu:11-1000 12-2000 13-2000c 16-4000 中控:14 其他设备:8)");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("显示名称");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("状态( 1-有效 3-无效 5-等待检查 6-报废)");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("ip");
		cellTitle[4] = ex0;
		ex0 = new CellVO();
		ex0.setValue("信令ip（MCU）");
		cellTitle[5] = ex0;
		ex0 = new CellVO();
		ex0.setValue("端口号");
		cellTitle[6] = ex0;
		
		//////////////////
		ex0 = new CellVO();
		ex0.setValue("所属会议室编号");
		cellTitle[7] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("设备管理员(登录名)");
		cellTitle[8] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("用户名");
		cellTitle[9] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("密码");
		cellTitle[10] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("所属MCUIP");
		cellTitle[11] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("评测任务号（对比卡 默认：A8）");
		cellTitle[12] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("显示格式(对比卡 默认：B8)");
		cellTitle[13] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("输入方式(对不卡 默认D2)");
		cellTitle[14] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("输出方式（对比卡 默认C2）");
		cellTitle[15] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("评价方式(对比卡 默认E5)");
		cellTitle[16] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("采集方式(对比卡 默认F1)");
		cellTitle[17] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("序列号");
		cellTitle[18] = ex0;
		
		list.add(cellTitle);
	}
	
	public TerminalInterfaceVO getTifVO() {
		return tifVO;
	}

	public void setTifVO(TerminalInterfaceVO tifVO) {
		this.tifVO = tifVO;
	}

	public ArrayList<TerminalInterfaceVO> getTifList() {
		return tifList;
	}

	public void setTifList(ArrayList<TerminalInterfaceVO> tifList) {
		this.tifList = tifList;
	}


	public ArrayList<EquipmentVO> getEquipmentVOListsss() {
		return equipmentVOListsss;
	}


	public void setEquipmentVOListsss(ArrayList<EquipmentVO> equipmentVOListsss) {
		this.equipmentVOListsss = equipmentVOListsss;
	}



	public ArrayList<EquipmentTerminalVO> getEquipmentVOList() {
		return equipmentVOList;
	}


	public void setEquipmentVOList(ArrayList<EquipmentTerminalVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}


	public EquipmentTerminalVO getEquipmentTerminalVO() {
		return equipmentTerminalVO;
	}


	public void setEquipmentTerminalVO(EquipmentTerminalVO equipmentTerminalVO) {
		this.equipmentTerminalVO = equipmentTerminalVO;
	}


	public InputStream getExcelStream() {
		return excelStream;
	}


	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	public static TerminalInterfaceService getTis() {
		return tis;
	}


	public static void setTis(TerminalInterfaceService tis) {
		EquipmentInterfaceAction.tis = tis;
	}


	public EquipmentInterfaceVO getDifVO() {
		return difVO;
	}


	public void setDifVO(EquipmentInterfaceVO difVO) {
		this.difVO = difVO;
	}


	public ArrayList<EquipmentInterfaceVO> getDifList() {
		return difList;
	}


	public void setDifList(ArrayList<EquipmentInterfaceVO> difList) {
		this.difList = difList;
	}
	
	
	
	
}
