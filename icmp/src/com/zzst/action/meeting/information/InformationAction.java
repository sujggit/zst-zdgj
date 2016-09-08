package com.zzst.action.meeting.information;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.meeting.information.InformationVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;

public class InformationAction extends CjfAction{

	/**
	 *  获得消息列表 ；
	 *  add by tanzanlong
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(InformationAction.class.getName());
	private ArrayList<InformationVO> informationVOList=new ArrayList<InformationVO>();
	private InformationVO informationVO=new InformationVO();
	private InputStream  excelStream;
	
	public String queryInformationList(){
		logger.info("InformationAction queryInformationList	begin");
		try {
			informationVOList=ServiceFactory.getInformationService().query(informationVO, getPageControler());
			   
			 for(int i=0;i<informationVOList.size();i++){
				 InformationVO information=new InformationVO();	
				 if(information.getCreateUserID()==null){
					 information.setCreateUserID(" ");
				 }
				 information=informationVOList.get(i);
				 UserVO vUserVO= new UserVO ();
				 vUserVO.setUserID(information.getCreateUserID());
				  
				 ArrayList<UserVO> ulist=ServiceFactory.getUserService().getUserList(vUserVO, null);				
				 if(ulist.size()>0&&ulist.get(0)!=null){
					 information.setCreateUserID(((UserVO)ulist.get(0)).getName());
					// System.out.println(information.getCreateUserID()+"//////////////////");
				 }
				 
				 
			 }
			 
			 
			 
			 
		} catch (Exception e) {
			logger.error("InformationAction	queryInformationList	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("InformationAction	queryInformationList	end");
		return SUCCESS;
	}
	/**
	 *  获得根据id获得该消息的详情；
	 *  add by tanzanlong
	 */
	public String informationDetail(){
		logger.info("InformationAction InformationDetail	begin");
		try {
			String id=informationVO.getInfoID();
			
						
			 informationVO=ServiceFactory.getInformationService().queryByID(id);
			 if(informationVO.getCreateUserID()==null){
				 informationVO.setCreateUserID(" ");
			 }
			 informationVO.setStatus(InformationEnum.STATUS_INVALID);
		     ServiceFactory.getInformationService().modify(informationVO);
		     
		     if(informationVO.getCreateUserID()!=null&&informationVO.getCreateUserID().length()>0){
		    	 UserVO vUserVO= new UserVO ();
				 vUserVO.setUserID(informationVO.getCreateUserID());
			     ArrayList<UserVO> ulist=ServiceFactory.getUserService().getUserList(vUserVO, null);
			     if(ulist!=null&&ulist.size()>0){
			    	 informationVO.setCreateUserID((ulist.get(0)).getName());	
			     }
		     }
		     
		} catch (Exception e) {
			logger.error("InformationAction	InformationDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("InformationAction	InformationDetail	end");
		return SUCCESS;
	}

	
	
	
	public String informationDel(){
		logger.info("InformationAction informationDel	begin");
		try {
			String id=informationVO.getInfoID();
			ServiceFactory.getInformationService().deleteByID(id);
			
		} catch (Exception e) {
			logger.error("InformationAction	informationDel	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("InformationAction	informationDel	end");
		return SUCCESS;
	}

	
	/**
	 * 导出
	 * add  by tanzanlong
	 * @return
	 */
	public String informationexportQuery(){
		logger.info("InformationAction	informationexportQuery	begin");
		try{
			informationVOList=ServiceFactory.getInformationService().query(informationVO, null);
			
			String fileName = "information.xls";
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			
			if(informationVOList!=null&&informationVOList.size()>0){
			
				
				for (int i = 0; i < informationVOList.size(); i++) {
					InformationVO lVO = informationVOList.get(i);
					CellVO[] cell = new CellVO[7];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+1+"");
					cell[0] = ex0;
					
					CellVO ex1 = new CellVO();
					ex1.setValue(lVO.getTitle());
					cell[1] = ex1;
					
					CellVO ex2 = new CellVO();
					for(String[] s : InformationEnum.getInfoType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(lVO.getInfoType()+"")){
							 ex2.setValue(s[1]);
							 continue;
						 }
					}
					
					cell[2] = ex2;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(lVO.getCreateUserID());
					cell[3] = ex3;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(lVO.getCreateTime().toString());
					cell[4] = ex4;
					
					CellVO ex5 = new CellVO();
					ex5.setValue(lVO.getDescription());
					cell[5] = ex5;
					
					list.add(cell);
					
				}
				
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
			
		}catch(Exception e){
			logger.error("InformationAction	informationexportQuery	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("InformationAction	informationexportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[7];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("警告标题");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("警告类型");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("发起人");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("发起时间");
		cellTitle[4] = ex0;
		ex0 = new CellVO();
		ex0.setValue("描述");
		cellTitle[5] = ex0;
		ex0 = new CellVO();
		list.add(cellTitle);
	}
	


	public ArrayList<InformationVO> getInformationVOList() {
		return informationVOList;
	}

	public void setInformationVOList(ArrayList<InformationVO> informationVOList) {
		this.informationVOList = informationVOList;
	}

	public InformationVO getInformationVO() {
		return informationVO;
	}

	public void setInformationVO(InformationVO informationVO) {
		this.informationVO = informationVO;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	

}
