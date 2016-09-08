package com.zzst.action.meeting.mcuCascadeModel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;


/**
 *@Description	配置mcu级联模板
 *@date 2012-11-20上午11:25:01
 *@author ryan
 */
public class McuCascadeModelAction extends CjfAction {
		 
			
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(McuCascadeModelAction.class.getName());
	
	private McuCascadeModelVO mcuCascadeModelVO = new McuCascadeModelVO();
	private ArrayList<McuCascadeModelVO> mcuCascadeModelVOList = new ArrayList<McuCascadeModelVO>();
	ArrayList<EquipmentVO>  equipmentVOList = new ArrayList<EquipmentVO>();
	private InputStream  excelStream;
			
	public ArrayList<EquipmentVO> getEquipmentVOList() {
		return equipmentVOList;
	}

	public void setEquipmentVOList(ArrayList<EquipmentVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}

	//级联 模板查看 
	public String mcuCascadeDetail(){
		logger.info("McuCascadeModelAction	mcuCascadeDetail	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(this.getCurHttpServletRequest());
		try{
			String mcuCascadeModelVOID=mcuCascadeModelVO.getCascadeID();
			mcuCascadeModelVO=ServiceFactory.getMcuCascadeModelService().queryByID(mcuCascadeModelVOID);
			
			
			
		}catch(Exception e){
			logger.error("LoginAction	mcuCascadeDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("McuCascadeModelAction	mcuCascadeDetail	end");
		return "success";
	}	
	
	
	
	/**
	 * 导出
	 * add  by tanzanlong
	 * @return
	 */
	public String McuCascadeModelexportQuery(){
		logger.info("McuCascadeModelexportQuery	McuCascadeModelexportQuery	begin");
		try{
			mcuCascadeModelVO.setStatus(McuCascademodelEnum.VALID);
			mcuCascadeModelVOList = ServiceFactory.getMcuCascadeModelService().query(mcuCascadeModelVO, null);
			String fileName = "MCUCscadeModel.xls";
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			
			if(mcuCascadeModelVOList!=null&&mcuCascadeModelVOList.size()>0){
			
				
				for (int i = 0; i < mcuCascadeModelVOList.size(); i++) {
					McuCascadeModelVO lVO = mcuCascadeModelVOList.get(i);
					CellVO[] cell = new CellVO[7];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getCascadeName());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					EquipmentVO equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(lVO.getDescription());
					if( equipmentVO != null ){
						ex2.setValue(equipmentVO.getEquipmentNO());
					}
					
					
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getMcuName());
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getModelName());
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					ex5.setValue(sdf.format(new Date(lVO.getCreateDate().getTime())));
					cell[5] = ex5;
					
					list.add(cell);
					
				}
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("McuCascadeModelexportQuery	McuCascadeModelexportQuery	error:"+e.getMessage());
			return ERROR;
		}
		
		logger.info("McuCascadeModelexportQuery	McuCascadeModelexportQuery	end");
		return "success";
	}
	
	
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[7];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("会议模式");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("主MCU");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("MCU名称");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("MCU模板");
		cellTitle[4] = ex0;
		ex0 = new CellVO();
		ex0.setValue("创建时间");
		cellTitle[5] = ex0;
		ex0 = new CellVO();
		list.add(cellTitle);
	}
	

	
	
	
	
	
	
	public String add(){
		logger.info("McuCascadeModelAction	add	begin");
		try{
			Map mcuEquipmentMap = new HashMap();
			EquipmentVO equipmentVO = new EquipmentVO();
			ArrayList<EquipmentVO>  equipmentVOList = new ArrayList<EquipmentVO>();
			equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
			equipmentVOList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
			if(equipmentVOList != null && equipmentVOList.size()>0){
				for(int i=0;i<equipmentVOList.size();i++){
					EquipmentVO tEquipmentVO = new EquipmentVO();
					tEquipmentVO = equipmentVOList.get(i);
					ArrayList<BaseInfoVO>  baseInfoVOList = new ArrayList<BaseInfoVO>();
					BaseInfoVO baseInfoVO = new BaseInfoVO();
					baseInfoVO.setInfoName(tEquipmentVO.getIp());
					baseInfoVOList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
					mcuEquipmentMap.put(equipmentVOList.get(i), baseInfoVOList);
				}
			}
			this.getCurHttpServletRequest().setAttribute("mcuEquipmentMap", mcuEquipmentMap);
			this.getCurHttpServletRequest().setAttribute("equipmentVOList", equipmentVOList);
		}catch(Exception e){
			logger.error("McuCascadeModelAction	add	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("McuCascadeModelAction	add	end");
		return "success";
	}
			
	public McuCascadeModelVO getMcuCascadeModelVO() {
		return mcuCascadeModelVO;
	}

	public void setMcuCascadeModelVO(McuCascadeModelVO mcuCascadeModelVO) {
		this.mcuCascadeModelVO = mcuCascadeModelVO;
	}

	public ArrayList<McuCascadeModelVO> getMcuCascadeModelVOList() {
		return mcuCascadeModelVOList;
	}

	public void setMcuCascadeModelVOList(
			ArrayList<McuCascadeModelVO> mcuCascadeModelVOList) {
		this.mcuCascadeModelVOList = mcuCascadeModelVOList;
	}

	public String query(){
		logger.info("McuCascadeModelAction	query	begin");
		//PageSplittor pSplittor = PageSplittor.getPageSplittor(this.getCurHttpServletRequest());
		try{
			//UserVO sessionUserVO = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);pSplittor.getPControler()
			
			mcuCascadeModelVO.setStatus(McuCascademodelEnum.VALID);
			mcuCascadeModelVOList = ServiceFactory.getMcuCascadeModelService().query(mcuCascadeModelVO,  this.getPageControler());
			if(mcuCascadeModelVOList != null && mcuCascadeModelVOList.size()>0){
				for(int i=0;i<mcuCascadeModelVOList.size();i++){
					McuCascadeModelVO tMcuCascadeModelVO = new McuCascadeModelVO();			
					tMcuCascadeModelVO = mcuCascadeModelVOList.get(i);				
					EquipmentVO equipmentVO = new EquipmentVO();
					equipmentVO.setEquipmentID(tMcuCascadeModelVO.getDescription());
					ArrayList<EquipmentVO> equipmentVOList = ServiceFactory.getEquipmentService().query(equipmentVO, null);
					
					UserVO vUserVO=new UserVO();
					String userID=tMcuCascadeModelVO.getCreateUserID();
					vUserVO.setUserID(userID);
					ArrayList<UserVO> userlist=ServiceFactory.getUserService().getUserList(vUserVO, null);
					if(userlist!=null&&userlist.size()>0){		
						UserVO uservo=userlist.get(0);
						tMcuCascadeModelVO.setCreateUserID(uservo.getName());
					}
					
					if(equipmentVOList != null && equipmentVOList.size()>0){
						equipmentVO = equipmentVOList.get(0);
						tMcuCascadeModelVO.setDescription(equipmentVO.getEquipmentNO());
						//mcuCascadeModelVOList.add(tMcuCascadeModelVO);
					}
				}
			}
			EquipmentVO equipmentVO_ = new EquipmentVO();
			equipmentVO_.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
			
			//equipmentVO_.setEquipmentNO(mcuCascadeModelVO.getDescription());
			equipmentVOList = ServiceFactory.getEquipmentService().query(equipmentVO_,null);//
		    
		
		}catch(Exception e){
			logger.error("McuCascadeModelAction	query	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("McuCascadeModelAction	query	end");
		return "success";
	}	
	
	public String delete(){
		logger.info("McuCascadeModelAction	delete	begin");
		try{
			//mcuCascadeModelVO.setStatus(McuCascademodelEnum.INVALID);
			ServiceFactory.getMcuCascadeModelService().deleteByID(mcuCascadeModelVO.getCascadeID());
			
		}catch(Exception e){
			logger.error("LoginAction	query	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("McuCascadeModelAction	delete	end");
		return "success";
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
}
