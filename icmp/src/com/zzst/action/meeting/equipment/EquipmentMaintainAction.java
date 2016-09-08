package com.zzst.action.meeting.equipment;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.EquipmentMaintainEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.equipment.maintain.EquipmentMaintainVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class EquipmentMaintainAction extends CjfAction{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(EquipmentMaintainAction.class.getName());
	
	private EquipmentVO equipmentVO = new EquipmentVO();
	private EquipmentMaintainVO equipmentMaintainVO = new EquipmentMaintainVO();
	private ArrayList<EquipmentMaintainVO> list = new ArrayList<EquipmentMaintainVO>();
	private InputStream  excelStream;
	
	/**
	 * 跳转添加维修信息页面
	 * @return
	 */
	public String equipmentMaintain(){
		logger.info("EquipmentMaintainAction	equipmentMaintain 	begin");
		try {
			try {
				String equipmentID=equipmentVO.getEquipmentID();
				equipmentVO	=	ServiceFactory.getEquipmentService().queryByID(equipmentID);
				equipmentMaintainVO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
				
				
			} catch (Exception e) {
				logger.error("EquipmentMaintainAction	equipmentMaintain	error:"+e.getMessage());
				return ERROR;
			}
			logger.info("EquipmentMaintainAction	equipmentMaintain	end");
			 
		} catch (Exception e) {
			logger.error("EquipmentMaintainAction	equipmentMaintain	 error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentMaintainAction	equipmentMaintain	end");
		return SUCCESS;
	}
	
	/**
	 * 添加维修信息记录
	 * @return
	 */
	public String equipmentMaintainAdd(){
		logger.info("EquipmentMaintainAction	equipmentMaintainAdd 	begin");
		
			try {
				HttpSession session = this.getCurHttpServletRequest().getSession();

				UserVO userVO = (UserVO)session.getAttribute(UserEnum.USER_SESSION_ID);
				equipmentMaintainVO.setUpdateUserID(userVO.getUserID());
				ServiceFactory.getEquipmentMaintainService().add(equipmentMaintainVO);
				EquipmentVO equipmentVO = new EquipmentVO();
				equipmentVO.setEquipmentID(equipmentMaintainVO.getEquipmentID());
				//更新equipment状态
				if( equipmentMaintainVO.getStatus() == EquipmentMaintainEnum.STATUS_VALID ){//正常
					equipmentVO.setStatus(EquipmentEnum.STATUS_VALID);
					
				}
				if( equipmentMaintainVO.getStatus() == EquipmentMaintainEnum.STATUS_TODOREPAIRED ){//报修
					equipmentVO.setStatus(EquipmentEnum.STATUS_TODOREPAIRED);
				}
				if( equipmentMaintainVO.getStatus() == EquipmentMaintainEnum.STATUS_USELESS ){//报废
					equipmentVO.setStatus(EquipmentEnum.STATUS_USELESS);
				}
				ServiceFactory.getEquipmentService().modify(equipmentVO);
				
				
				/*HttpServletResponse response = this.getServletResponse();
				response.setCharacterEncoding("uft-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter pt = response.getWriter();
				pt.print("<script>window.onload=function(){window.close()}</script>");
				pt.flush();*/
				
			} catch (Exception e) {
				logger.error("EquipmentMaintainAction	equipmentMaintainAdd	error:"+e.getMessage());
				return ERROR;
			}
			logger.info("EquipmentMaintainAction	equipmentMaintainAdd	end");
			 
		
		return SUCCESS;
	}
	
	/**
	 * 所有设备维修记录查询
	 * @return
	 */
	public String queryEquipmentMaintain (){
		logger.info("EquipmentMaintainAction	queryEquipmentMaintain 	begin");
			try {
				///////////////会议室分级分权 @author:zhangjy///////////////////////////
				UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
				if(MeetingAppConfig.LEVEL_IS_POEN){
					if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
						equipmentMaintainVO.setLevel(true);
						equipmentMaintainVO.setLsql(suv.getLvoids());
					}
				}
	            /////////////////////////////////end/////////////////////////////////////
				list = ServiceFactory.getEquipmentMaintainService().queryEquipmentMaintain(equipmentMaintainVO, this.getPageControler());
				if(list!=null&&list.size()>0){
					for(int i=0;i<list.size();i++){
						for(EquipmentMaintainVO vo:list){
							vo = list.get(i);
							EquipmentVO eVO=new EquipmentVO();
							eVO.setEquipmentID(vo.getEquipmentID());
							ArrayList<EquipmentVO> eList = ServiceFactory.getEquipmentService().queryEquipments(eVO, null);
							if(eList!=null&&eList.size()>0){
								vo.getEquipmentVO().getMeetingRoomVO().setMeetingRoomName(eList.get(0).getMeetingRoomVO().getMeetingRoomName());
							}
							
						}
					}
				}
				
			} catch (Exception e) {
				logger.error("EquipmentMaintainAction	queryEquipmentMaintain	error:"+e.getMessage());
				return ERROR;
			}
			logger.info("EquipmentMaintainAction	queryEquipmentMaintain	end");
			 
		
		return SUCCESS;
	}
	
	
	/**
	 * 导出设备维修记录
	 * @return
	 */
	public String exportEquipmentMaintain (){
		logger.info("LoginAction	exportEquipmentMaintain	begin");
		try{
			list = ServiceFactory.getEquipmentMaintainService().queryEquipmentMaintain(equipmentMaintainVO, this.getPageControler());
			
			String fileName = "equipmentMaintain.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list1 = new ArrayList<CellVO[]>();
				setTitle(list1);//添加表头
				if(list!=null&&list.size()>0){	
				for (int i = 0; i < list.size(); i++) {
					EquipmentMaintainVO lVO = list.get(i);
					CellVO[] cell = new CellVO[6];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");//序号
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getEquipmentVO().getEquipmentNO());//名称
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					for(String[] s : EquipmentEnum.getEquipmentType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getEquipmentVO().getEquipmentType()+"")){//类型
							 ex2.setValue(s[1]);
							 continue;
						 }
					}
					
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getMaintainTime()+"");//维修次数
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getSumCost()+"");//成本
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					ex5.setValue(lVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomName());//会议室名字
					cell[5] = ex5;
					
					
					list1.add(cell);
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list1);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("LoginAction	exportEquipmentMaintain 	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	exportEquipmentMaintain 	end");
		return "success";
	}
	
	
	/**
	 * 导出设备维修记录
	 * @return
	 */
	public String exportEquipmentMaintainDetail(){
		logger.info("LoginAction	exportEquipmentMaintainDetail	begin");
		try{
			list = ServiceFactory.getEquipmentMaintainService().queryDetail(equipmentMaintainVO, getPageControler());
			
			String fileName = "equipmentMaintainDetail.xls";
			
				ExportFileObject fileObj = new ExportFileObject();
				fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
				fileObj.setExportFileName(fileName);
				ArrayList<CellVO[]> list1 = new ArrayList<CellVO[]>();
				setTitle1(list1);//添加表头
				if(list!=null&&list.size()>0){	
				for (int i = 0; i < list.size(); i++) {
					EquipmentMaintainVO lVO = list.get(i);
					CellVO[] cell = new CellVO[7];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");//序号
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getEquipmentVO().getEquipmentNO());//名称
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					for(String[] s : EquipmentEnum.getEquipmentType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getEquipmentVO().getEquipmentType()+"")){//类型
							 ex2.setValue(s[1]);
							 continue;
						 }
					}
					
					cell[2] = ex2;
					
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getEquipmentVO().getMeetingRoomVO().getMeetingRoomName());//会议室名字
					cell[3] = ex3;
					
					
					
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getMaintainCost()+"");//成本
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					for(String[] s : EquipmentMaintainEnum.getEquipmentMaintainStatus()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getStatus()+"")){//类型
							 ex5.setValue(s[1]);
							 continue;
						 }
					}
					cell[5] = ex5;
					
					
					CellVO ex6 = new CellVO();
					ex6.setValue(lVO.getDescription());//描述
					cell[6] = ex6;
					
					list1.add(cell);
					}
				}
				ExportObjectHelp.exportExcel(fileObj, list1);//生成excel文件
		        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception e){
			logger.error("LoginAction	exportEquipmentMaintainDetail 	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("LoginAction	exportEquipmentMaintainDetail 	end");
		return "success";
	}
	
	
	
	
	public String deleteEquipmentMaintain (){
		logger.info("EquipmentMaintainAction	deleteEquipmentMaintain 	begin");
			try {
				ServiceFactory.getEquipmentMaintainService().deleteByID(equipmentMaintainVO.getMaintainID());
				
			} catch (Exception e) {
				logger.error("EquipmentMaintainAction	deleteEquipmentMaintain	error:"+e.getMessage());
				return ERROR;
			}
			logger.info("EquipmentMaintainAction	deleteEquipmentMaintain	end");
			 
		
		return SUCCESS;
	}
	/**
	 * 查询一个设备所有维修记录
	 * @return
	 */
	public String maintainDetail(){
		logger.info("EquipmentMaintainAction	maintainDetail 	begin");
		try {
			list = ServiceFactory.getEquipmentMaintainService().queryDetail(equipmentMaintainVO, getPageControler());
			if(list!=null&&list.size()>0){
				EquipmentMaintainVO vo = new EquipmentMaintainVO();
				vo = list.get(0);
				EquipmentVO eVO=new EquipmentVO();
				eVO.setEquipmentID(vo.getEquipmentID());
				ArrayList<EquipmentVO> eList = ServiceFactory.getEquipmentService().queryEquipments(eVO, null);
				if(eList!=null&&eList.size()>0){
					vo.getEquipmentVO().getMeetingRoomVO().setMeetingRoomName(eList.get(0).getMeetingRoomVO().getMeetingRoomName());
				}
			}
		} catch (Exception e) {
			logger.error("EquipmentMaintainAction	maintainDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("EquipmentMaintainAction	maintainDetail	end");
		 
	
	return SUCCESS;
	}
	

	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[6];
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
		ex0.setValue("维修次数");
		cellTitle[3] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("维修成本");
		cellTitle[4] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("所属会议室");
		cellTitle[5] = ex0;
		
		
		list.add(cellTitle);
	}
	
	private void setTitle1(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[7];
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
		ex0.setValue("所属会议室");
		cellTitle[3] = ex0;
		
		
		ex0 = new CellVO();
		ex0.setValue("维修成本");
		cellTitle[4] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("状态");
		cellTitle[5] = ex0;
		
		ex0 = new CellVO();
		ex0.setValue("描述");
		cellTitle[6] = ex0;
		
		
		list.add(cellTitle);
	}
	
	
	
	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public EquipmentMaintainVO getEquipmentMaintainVO() {
		return equipmentMaintainVO;
	}

	public void setEquipmentMaintainVO(EquipmentMaintainVO equipmentMaintainVO) {
		this.equipmentMaintainVO = equipmentMaintainVO;
	}


	public ArrayList<EquipmentMaintainVO> getList() {
		return list;
	}


	public void setList(ArrayList<EquipmentMaintainVO> list) {
		this.list = list;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	
	
	
}
