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
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.dataInterface.role.RoleInterfaceVO;
import com.zzst.model.meeting.equipment.EquipmentTerminalVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.auth.RoleServiceImpl;
import com.zzst.service.meeting.dataInterface.role.RoleInterfaceService;
import com.zzst.service.meeting.dataInterface.role.RoleInterfaceServiceImpl;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class RoleInterfaceAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(RoleInterfaceAction.class.getName());
	private static RoleInterfaceService riService = new RoleInterfaceServiceImpl();
	private ArrayList<RoleInterfaceVO> risList = new ArrayList<RoleInterfaceVO>();
	private RoleInterfaceVO riVO = new RoleInterfaceVO();
	private InputStream  excelStream;
	
	public String queryRole(){
		logger.info("RoleInterfaceAction	queryRole	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			risList = riService.query(riVO, pSplittor.getPControler());
			
		}catch(Exception e){
			logger.error("RoleInterfaceAction	queryRole	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("RoleInterfaceAction	queryRole	end");
		return SUCCESS; 
	}
	
	public String delete(){
		logger.info("RoleInterfaceAction	delete	begin");
		try{
			riService.deleteByID(riVO.getRoleid());
			
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_role表 进行delete操作");
				new LogServiceImpl().add(logVO);
			}
			
			
		}catch(Exception e){
			logger.error("RoleInterfaceAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("RoleInterfaceAction	delete	end");
		return SUCCESS;
	}
	
	public String detail(){
		logger.info("RoleInterfaceAction	detail	begin");
		try{
			riVO = riService.queryByID(riVO.getRoleid());
			
		}catch(Exception e){
			logger.error("RoleInterfaceAction	detail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("RoleInterfaceAction	detail	end");
		return SUCCESS;
	}
	
	public String beforeModify(){
		logger.info("RoleInterfaceAction	beforeModify	begin");
		try{
			riVO = riService.queryByID(riVO.getRoleid());
			
		}catch(Exception e){
			logger.error("RoleInterfaceAction	beforeModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("RoleInterfaceAction	beforeModify	end");
		return SUCCESS;
	}
	
	public String modify(){
		logger.info("RoleInterfaceAction	modify	begin");
		try{
			riVO = riService.modify(riVO);
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_role表 进行update操作");
				new LogServiceImpl().add(logVO);
			}
			
		}catch(Exception e){
			logger.error("RoleInterfaceAction	modify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("RoleInterfaceAction	modify	end");
		return SUCCESS;
	}
	
	
	public String exportQuery(){
		logger.info("RoleInterfaceAction	exportQuery	begin");
		try{
			RoleVO rv = new RoleVO();
			ArrayList<RoleVO> roleList = new RoleServiceImpl().getRoleList(rv, null);
			
			String fileName = "role.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitle(list);//添加表头
				if(roleList!=null&&roleList.size()>0){	
				for (int i = 0; i < roleList.size(); i++) {
					RoleVO lVO = roleList.get(i);
					CellVO[] cell = new CellVO[2];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getRoleName());
					cell[1] = ex1;
					
					list.add(cell);
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("RoleInterfaceAction	exportQuery	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("RoleInterfaceAction	exportQuery	end");
		return "success";
	}
	
	
	public ArrayList<RoleInterfaceVO> getRisList() {
		return risList;
	}

	public void setRisList(ArrayList<RoleInterfaceVO> risList) {
		this.risList = risList;
	}

	public RoleInterfaceVO getRiVO() {
		return riVO;
	}

	public void setRiVO(RoleInterfaceVO riVO) {
		this.riVO = riVO;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[2];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("角色名");
		cellTitle[1] = ex0;
		
		list.add(cellTitle);
	}
}
