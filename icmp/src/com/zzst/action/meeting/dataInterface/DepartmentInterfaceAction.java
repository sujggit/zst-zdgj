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
import com.zzst.model.enums.LogEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.RoleVO;
import com.zzst.model.meeting.dataInterface.department.DepartmentInterfaceVO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.dataInterface.department.DepartmentInterfaceService;
import com.zzst.service.meeting.dataInterface.department.DepartmentInterfaceServiceImpl;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class DepartmentInterfaceAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(DepartmentInterfaceAction.class.getName());
	private static DepartmentInterfaceService diService = new DepartmentInterfaceServiceImpl();
	private ArrayList<DepartmentInterfaceVO> diList = new ArrayList<DepartmentInterfaceVO>();
	private DepartmentInterfaceVO diVO = new DepartmentInterfaceVO();
	private InputStream  excelStream;
	
	public String queryDepartment(){
		logger.info("DepartmentInterfaceAction	queryDepartment	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			diList = diService.query(diVO, pSplittor.getPControler());
			for( DepartmentInterfaceVO diVO : diList ){
				DepartmentInterfaceVO tempVO = diService.queryByID(diVO.getParentid());
				if( tempVO != null ){
					diVO.setParentname(tempVO.getDepartmentname());
				}
				
			}
			
		}catch(Exception e){
			logger.error("DepartmentInterfaceAction	queryDepartment	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("DepartmentInterfaceAction	queryDepartment	end");
		return SUCCESS; 
	}
	
	public String delete(){
		logger.info("DepartmentInterfaceAction	delete	begin");
		try{
			diService.deleteByID(diVO.getDepartmentid());
			
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_department表 进行delete操作");
				new LogServiceImpl().add(logVO);
			}
			
			
		}catch(Exception e){
			logger.error("DepartmentInterfaceAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("DepartmentInterfaceAction	delete	end");
		return SUCCESS;
	}
	
	public String detail(){
		logger.info("DepartmentInterfaceAction	detail	begin");
		try{
			diVO = diService.queryByID(diVO.getDepartmentid());
			
			DepartmentInterfaceVO diParent = diService.queryByID(diVO.getParentid());
			
			if( diParent!=null ){
				diVO.setParentname(diParent.getDepartmentname());
			}
			
		}catch(Exception e){
			logger.error("DepartmentInterfaceAction	detail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("DepartmentInterfaceAction	detail	end");
		return SUCCESS;
	}
	
	public String beforeModify(){
		logger.info("DepartmentInterfaceAction	beforeModify	begin");
		try{
			diVO = diService.queryByID(diVO.getDepartmentid());
			
		}catch(Exception e){
			logger.error("DepartmentInterfaceAction	beforeModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("DepartmentInterfaceAction	beforeModify	end");
		return SUCCESS;
	}
	
	public String modify(){
		logger.info("DepartmentInterfaceAction	modify	begin");
		try{
			diVO = diService.modify(diVO);
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_department表 进行update操作");
				new LogServiceImpl().add(logVO);
			}
			
		}catch(Exception e){
			logger.error("DepartmentInterfaceAction	modify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("DepartmentInterfaceAction	modify	end");
		return SUCCESS;
	}
	
	
	public String exportQuery(){
		logger.info("DepartmentInterfaceAction	exportQuery	begin");
		try{
			DepartmentVO di = new DepartmentVO();
			ArrayList<DepartmentVO> departmentList = ServiceFactory.getDepartmentService().getAllFuncList(di, null);
			
			String fileName = "department.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitle(list);//添加表头
				if(departmentList!=null&&departmentList.size()>0){	
				for (int i = 0; i < departmentList.size(); i++) {
					DepartmentVO lVO = departmentList.get(i);
					CellVO[] cell = new CellVO[3];
					CellVO ex0 = new CellVO();
					ex0.setValue(lVO.getId()+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getTitle());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(lVO.getParentId());
					cell[2] = ex2;
					
					
					list.add(cell);
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("DepartmentInterfaceAction	exportQuery	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("DepartmentInterfaceAction	exportQuery	end");
		return "success";
	}
	
	
	

	public ArrayList<DepartmentInterfaceVO> getDiList() {
		return diList;
	}

	public void setDiList(ArrayList<DepartmentInterfaceVO> diList) {
		this.diList = diList;
	}

	public DepartmentInterfaceVO getDiVO() {
		return diVO;
	}

	public void setDiVO(DepartmentInterfaceVO diVO) {
		this.diVO = diVO;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[3];
		CellVO ex0 = new CellVO();
		ex0.setValue("id");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("组织结构名");
		cellTitle[1] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("父组织结构id");
		cellTitle[2] = ex0;
		
		list.add(cellTitle);
	}
}
