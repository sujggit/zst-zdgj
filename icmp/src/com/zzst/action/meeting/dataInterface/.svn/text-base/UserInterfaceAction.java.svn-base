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
import com.zzst.model.meeting.dataInterface.user.UserInterfaceVO;
import com.zzst.model.meeting.log.LogVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.dataInterface.user.UserInterfaceService;
import com.zzst.service.meeting.dataInterface.user.UserInterfaceServiceImpl;
import com.zzst.service.meeting.log.LogServiceImpl;
import com.zzst.service.meeting.user.UserServiceImpl;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class UserInterfaceAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(UserInterfaceAction.class.getName());
	private static UserInterfaceService uiService = new UserInterfaceServiceImpl();
	private ArrayList<UserInterfaceVO> uiList = new ArrayList<UserInterfaceVO>();
	private UserInterfaceVO uiVO = new UserInterfaceVO();
	private InputStream  excelStream;
	
	public String queryUser(){
		logger.info("UserInterfaceAction	queryUser	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			uiList = uiService.query(uiVO, pSplittor.getPControler());
			
		}catch(Exception e){
			logger.error("UserInterfaceAction	queryUser	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("UserInterfaceAction	queryRole	end");
		return SUCCESS; 
	}
	
	public String delete(){
		logger.info("UserInterfaceAction	delete	begin");
		try{
			uiService.deleteByID(uiVO.getUserid());
			
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_user表 进行delete操作");
				new LogServiceImpl().add(logVO);
			}
			
			
		}catch(Exception e){
			logger.error("UserInterfaceAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("UserInterfaceAction	delete	end");
		return SUCCESS;
	}
	
	public String detail(){
		logger.info("UserInterfaceAction	detail	begin");
		try{
			uiVO = uiService.queryByID(uiVO.getUserid());
			
		}catch(Exception e){
			logger.error("UserInterfaceAction	detail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("UserInterfaceAction	detail	end");
		return SUCCESS;
	}
	
	public String beforeModify(){
		logger.info("UserInterfaceAction	beforeModify	begin");
		try{
			uiVO = uiService.queryByID(uiVO.getUserid());
			
		}catch(Exception e){
			logger.error("UserInterfaceAction	beforeModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("UserInterfaceAction	beforeModify	end");
		return SUCCESS;
	}
	
	public String modify(){
		logger.info("UserInterfaceAction	modify	begin");
		try{
			uiVO = uiService.modify(uiVO);
			UserVO sessionUserVO = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if( sessionUserVO != null ){
				LogVO  logVO  = new LogVO();
				logVO.setLogType(LogEnum.TYPE_DEFAULT);
				logVO.setLevel(LogEnum.LEVEL_DeFAULT);
				logVO.setUserID(sessionUserVO.getUserID());
				logVO.setUserName(sessionUserVO.getName());
				logVO.setOperatorContent("对 z_interface_in_user表 进行update操作");
				new LogServiceImpl().add(logVO);
			}
			
		}catch(Exception e){
			logger.error("UserInterfaceAction	modify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("UserInterfaceAction	modify	end");
		return SUCCESS;
	}
	
	
	public String exportQuery(){
		logger.info("UserInterfaceAction	exportQuery	begin");
		try{
			UserVO uv = new UserVO();
			uv.setState(UserEnum.VALID);
			ArrayList<UserVO> userList = ServiceFactory.getUserService().getUserList(uv, null);
			//ArrayList<UserVO> userList = new ArrayList<UserVO>();
			
			String fileName = "user.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
				setTitle(list);//添加表头
				if(userList!=null&&userList.size()>0){	
				for (int i = 0; i < userList.size(); i++) {
					UserVO lVO = userList.get(i);
					CellVO[] cell = new CellVO[7];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getLoginName());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(lVO.getName());
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getEmail());
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getMobile());
					cell[4] = ex4;
					
					list.add(cell);
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("UserInterfaceAction	exportQuery	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("UserInterfaceAction	exportQuery	end");
		return "success";
	}
	
	
	

	public ArrayList<UserInterfaceVO> getUiList() {
		return uiList;
	}

	public void setUiList(ArrayList<UserInterfaceVO> uiList) {
		this.uiList = uiList;
	}

	public UserInterfaceVO getUiVO() {
		return uiVO;
	}

	public void setUiVO(UserInterfaceVO uiVO) {
		this.uiVO = uiVO;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[7];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("用户名");
		cellTitle[1] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("姓名");
		cellTitle[2] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("邮箱");
		cellTitle[3] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("手机");
		cellTitle[4] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("角色名字");
		cellTitle[5] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("部门id");
		cellTitle[6] = ex0;
		
		list.add(cellTitle);
	}
}
