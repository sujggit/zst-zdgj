package com.zzst.action.meeting.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.BaseInfoHelp;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.application.mcuVO.ZZOConfProfileVO;
import com.zzst.application.meeting.mcuFactory.ZZOMcuFactory;
import com.zzst.model.enums.BaseInfoEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.service.meeting.baseinfo.BaseInfoService;
import com.zzst.util.tools.export.ExportFileObject;
import com.zzst.util.tools.export.ExportObjectHelp;
import com.zzst.util.tools.export.ecxel.CellVO;


/**
 *@Description
 *@date 2012-7-4上午11:44:19
 *@author ryan
 */
public class BaseInfoAction extends CjfAction {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(BaseInfoAction.class.getName());
	
	private BaseInfoVO baseInfoVO = new BaseInfoVO();
 
	private ArrayList<EquipmentVO>  equipmentList = new ArrayList<EquipmentVO>();
	
	private ArrayList<BaseInfoVO> baseInfoList = new ArrayList<BaseInfoVO>();
	
	private InputStream  excelStream;
	private String baseInfoValues;//页面传递的option values串
	private String baseInfoTexts;//页面传递的option text串
	private String dateDictionaryType;//数据字典类型
	
	private String mcuIp;
	private String mcuUserName;
	private String mcuPsw;
	private List<ZZOConfProfileVO> profileList = new ArrayList<ZZOConfProfileVO>();
	/**
	 * 配置mcu信息
	 * @return
	 */
	public String mcuAdd(){
		logger.info("BaseInfoAction	mcuAdd	begin");
		try {
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			EquipmentVO tev=new EquipmentVO();
			if(MeetingAppConfig.LEVEL_IS_POEN){
		    //UserVO lu = (UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			UserVO lu = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			tev.setLsql(lu.getLvoids());
			tev.setLevel(true);
			}
			/////////////////////////end////////////////////////////////////////
			equipmentList = ServiceFactory.getEquipmentService().queryMCUID(tev);
		} catch (Exception e) {
			logger.error("BaseInfoAction	mcuAdd	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	mcuAdd	end");
		return SUCCESS;
	}
	
	/**
	 * 配置mcu信息
	 * @return
	 */
	public String mcuAddSave(){
		logger.info("BaseInfoAction	mcuAddSave	begin");
		try {
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
			ServiceFactory.getBaseInfoService().add(baseInfoVO);
			
			BaseInfoHelp.getMcuCon();//更新缓存
			
		} catch (Exception e) {
			logger.error("BaseInfoAction	mcuAddSave	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	mcuAddSave	end");
		return SUCCESS;
	}
	
	/**
	 * list mcu profiles.
	 * @return
	 */
	public String mcuList(){
		logger.info("BaseInfoAction	mcuAdd	begin");
		try {
			//equipmentList = ServiceFactory.getEquipmentService().queryMCUID();
			//baseInfoVO = new BaseInfoVO();
			baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
			baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, getPageControler());
		} catch (Exception e) {
			logger.error("BaseInfoAction	mcuAdd	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	mcuAdd	end");
		return SUCCESS;
	}
	
	
	/**
	 *配置列表的导出功能
	 * @return
	 */
	public String baseInfoexportQuery(){
		logger.info("BaseInfoAction	baseInfoexportQuery	begin");
		try{
			baseInfoList=ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			
			String fileName = "baseInfoInfo.xls";
			
			ExportFileObject fileObj = new ExportFileObject();
			fileObj.setExportFilePath(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC);
			fileObj.setExportFileName(fileName);
			ArrayList<CellVO[]> list = new ArrayList<CellVO[]>();
			setTitle(list);//添加表头
			
			if(baseInfoList!=null&&baseInfoList.size()>0){
				
				
				for (int i = 0; i < baseInfoList.size(); i++) {
					BaseInfoVO baseInfoVO = baseInfoList.get(i);
					CellVO[] cell = new CellVO[7];
					CellVO ex0 = new CellVO();
					ex0.setValue(i+"");
					cell[0] = ex0;
					
					CellVO ex3 = new CellVO();
					ex3.setValue(baseInfoVO.getInfoValue());
					cell[3] = ex3;
					
					CellVO ex2 = new CellVO();
					ex2.setValue(baseInfoVO.getInfoName());
					cell[2] = ex2;
					
					CellVO ex1 = new CellVO();
					for(String[] s : BaseInfoEnum.getBaseInfoType()){
						 if(s==null)	continue;
						 if(s[0].equalsIgnoreCase(baseInfoVO.getInfoType()+"")){
							 ex1.setValue(s[1]);
							 continue;
						 }
					}
					cell[1] = ex1;
					
					CellVO ex4 = new CellVO();
					ex4.setValue(baseInfoVO.getDescription());
					cell[4] = ex4;
					
					
					list.add(cell);
					
				}
			
			}
			ExportObjectHelp.exportExcel(fileObj, list);//生成excel文件
	        excelStream = new FileInputStream(MeetingAppConfig.PROJECT_SRC+MeetingAppConfig.EXPORT_SRC+fileName);
			
		}catch(Exception 
				e){
			logger.error("BaseInfoAction	baseInfoexportQuery 	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	baseInfoexportQuery	end");
		return "success";
	}
	
	private void setTitle(ArrayList<CellVO[]> list){
		CellVO[] cellTitle = new CellVO[7];
		CellVO ex0 = new CellVO();
		ex0.setValue("序号");
		cellTitle[0] = ex0;
		ex0 = new CellVO();
		ex0.setValue("配置类型");
		cellTitle[1] = ex0;
		ex0 = new CellVO();
		ex0.setValue("配置名称");
		cellTitle[2] = ex0;
		ex0 = new CellVO();
		ex0.setValue("配置内容");
		cellTitle[3] = ex0;
		ex0 = new CellVO();
		ex0.setValue("描述");
		cellTitle[4] = ex0;
		list.add(cellTitle);
	}
	
	
	
	
	/***
	 * 查询基础配置信息列表
	 * 
	 * @return 
	 * 
	 * @author yangyi
	 */
	public String queryBaseInfoList(){
		logger.info("BaseInfoAction	queryBaseInfoList	begin");
		try {
			if(baseInfoVO.getInfoType()!=null && baseInfoVO.getInfoType().equals(String.valueOf(Integer.MIN_VALUE))){
				baseInfoVO.setInfoType(null);
			}
			baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, getPageControler());
		} catch (Exception e) {
			logger.error("BaseInfoAction	queryBaseInfoList	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	queryBaseInfoList	end");
		return "success";
	}
	
	/***
	 * 查询基础配置修改
	 * 
	 * @return 
	 * 
	 * @author tanzanlong
	 */
	public String configurationQueryById(){
		logger.info("BaseInfoAction	configurationQueryById	begin");
		try {
		
			String id=baseInfoVO.getId();
			baseInfoVO=ServiceFactory.getBaseInfoService().queryByID(id);
			
		
		} catch (Exception e) {
			logger.error("BaseInfoAction	configurationQueryById	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	configurationQueryById	end");
		this.getCurHttpServletRequest().setAttribute("baseInfoVO", baseInfoVO);
		return "success";
	}
	
	
	public String configurationModify(){
		logger.info("BaseInfoAction	configurationModify	begin");
		try {
			//System.out.println(baseInfoVO.getInfoType()+"./////////,,,,,,,,,,,,,");
			ServiceFactory.getBaseInfoService().modify(baseInfoVO);
		
		} catch (Exception e) {
			logger.error("BaseInfoAction	configurationModify	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	configurationModify	end");
		return "success";
	}
	
	
	/***
	 * 查询基础配置查看
	 * 
	 * @return 
	 * 
	 * @author tanzanlong
	 */
	public String configurationDetail(){
		logger.info("BaseInfoAction	configurationDetail	begin");
		try {
		
			 String id=baseInfoVO.getId();
			 baseInfoVO=ServiceFactory.getBaseInfoService().queryByID(id);
		
		} catch (Exception e) {
			logger.error("BaseInfoAction	configurationDetail	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction configurationDetail	end");
		this.getCurHttpServletRequest().setAttribute("baseInfoVO", baseInfoVO);
		return "success";
	}
	
	public String configurationAdd(){
		logger.info("BaseInfoAction	configurationAdd	begin");
		try {
		
			ServiceFactory.getBaseInfoService().add(baseInfoVO);
		
		} catch (Exception e) {
			logger.error("BaseInfoAction	configurationAdd	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction configurationAdd	end");
		return "success";
	}
	
	
	/***
	 * 查询基础配置信息列表
	 * 
	 * @return 
	 * 
	 * @author yangyi
	 */
	public String delBaseInfo(){
		logger.info("BaseInfoAction	delBaseInfo	begin");
		try {
			ServiceFactory.getBaseInfoService().deleteByID(baseInfoVO.getId());
		} catch (Exception e) {
			logger.error("BaseInfoAction	delBaseInfo	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	delBaseInfo	end");
		return "success";
	}
	
	
	/**
	 * 保存数据字典信息
	 * @return
	 * @author chenshuo
	 */
	public String addDateDictionary(){
		logger.info("BaseInfoAction	addDateDictionary	begin");
		try {
			String[] values = baseInfoValues.split(",");
			String[] texts = baseInfoTexts.split(",");
			
			BaseInfoVO baseInfoVO1 = new BaseInfoVO();
			baseInfoVO1.setDescription(dateDictionaryType);
			
			BaseInfoService baseInfoService = ServiceFactory.getBaseInfoService();
			baseInfoService.delete(baseInfoVO1);
			
			if( !"".equals(baseInfoValues)){
				for( int i=0; i<values.length; i++ ){
					baseInfoVO1 = new BaseInfoVO();
					baseInfoVO1.setInfoType(BaseInfoEnum.TYPE_BASEINFO_DICTIONARY);
					baseInfoVO1.setInfoValue(values[i]);
					baseInfoVO1.setInfoName(texts[i]);
					baseInfoVO1.setDescription(dateDictionaryType);
					baseInfoService.add(baseInfoVO1);
				}
			}
			
		} catch (Exception e) {
			logger.error("BaseInfoAction	addDateDictionary	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	addDateDictionary	end");
		return "success";
	}
	public String getMCUTemplate(){
		logger.info("BaseInfoAction	getMCUTemplate	begin");
		try {
			profileList = ZZOMcuFactory.getInstance().getMcuControlHelper().getProfileList(mcuIp, mcuUserName, mcuPsw, null);
			logger.info("BaseInfoAction	getMCUTemplate	模板数量："+profileList.size());
			
			if(profileList!=null&&profileList.size()>0){
				BaseInfoVO baseInfoVO = new BaseInfoVO();
				baseInfoVO.setInfoName(mcuIp);
				//情况该MCU模板信息
				ServiceFactory.getBaseInfoService().delete(baseInfoVO);
				
				for(ZZOConfProfileVO vo :profileList){
					baseInfoVO = new BaseInfoVO();
					baseInfoVO.setInfoType(BaseInfoEnum.TYPE_BASEINFO_MCU);
					baseInfoVO.setInfoName(mcuIp);
					baseInfoVO.setDescription(vo.getProfileName());
					baseInfoVO.setInfoValue(vo.getGuid());
					ServiceFactory.getBaseInfoService().add(baseInfoVO);
					logger.info("BaseInfoAction	getMCUTemplate	添加	"+vo.getProfileName()+"	成功，ID："+vo.getGuid());
				}
			}
			
			BaseInfoHelp.getMcuCon();//更新缓存
		} catch (Exception e) {
			logger.error("BaseInfoAction getMCUTemplate	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("BaseInfoAction	getMCUTemplate	end");
		return "success";
	}
	
	public String beforeNoticeConfig(){
		logger.info("BaseInfoAction beforeNoticeConfig begin");
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoType(BaseInfoEnum.NOTICE_CONTENT);
		try {
			baseInfoList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		logger.info("BaseInfoAction beforeNoticeConfig end");
		return "success";
	}
	
	
	
	public BaseInfoVO getBaseInfoVO() {
		return baseInfoVO;
	}

	public void setBaseInfoVO(BaseInfoVO baseInfoVO) {
		this.baseInfoVO = baseInfoVO;
	}

	public ArrayList<EquipmentVO> getEquipmentList() {
		return equipmentList;
	}

	public void setEquipmentList(ArrayList<EquipmentVO> equipmentList) {
		this.equipmentList = equipmentList;
	}

	public void setBaseInfoList(ArrayList<BaseInfoVO> baseInfoList) {
		this.baseInfoList = baseInfoList;
	}

	public ArrayList<BaseInfoVO> getBaseInfoList() {
		return baseInfoList;
	}

	public String getBaseInfoValues() {
		return baseInfoValues;
	}

	public void setBaseInfoValues(String baseInfoValues) {
		this.baseInfoValues = baseInfoValues;
	}

	public String getBaseInfoTexts() {
		return baseInfoTexts;
	}

	public void setBaseInfoTexts(String baseInfoTexts) {
		this.baseInfoTexts = baseInfoTexts;
	}

	public String getDateDictionaryType() {
		return dateDictionaryType;
	}

	public void setDateDictionaryType(String dateDictionaryType) {
		this.dateDictionaryType = dateDictionaryType;
	}

	public String getMcuIp() {
		return mcuIp;
	}

	public void setMcuIp(String mcuIp) {
		this.mcuIp = mcuIp;
	}

	public String getMcuUserName() {
		return mcuUserName;
	}

	public void setMcuUserName(String mcuUserName) {
		this.mcuUserName = mcuUserName;
	}

	public String getMcuPsw() {
		return mcuPsw;
	}

	public void setMcuPsw(String mcuPsw) {
		this.mcuPsw = mcuPsw;
	}

	public List<ZZOConfProfileVO> getProfileList() {
		return profileList;
	}

	public void setProfileList(List<ZZOConfProfileVO> profileList) {
		this.profileList = profileList;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	
	
	

	
}
