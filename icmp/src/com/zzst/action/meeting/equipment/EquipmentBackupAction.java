package com.zzst.action.meeting.equipment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.opensymphony.xwork2.ActionContext;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.EquipmentBackupEnum;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.McuCascademodelEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.auth.FuncVO;
import com.zzst.model.meeting.config.BaseInfoVO;
import com.zzst.model.meeting.equipment.EquipmentBackupVO;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.mcuCascadeModel.McuCascadeModelVO;
import com.zzst.model.meeting.user.UserVO;

public class EquipmentBackupAction extends CjfAction{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;

private static Logger logger = CjfLogger.getLogger(EquipmentBackupAction.class.getName());
private ArrayList<EquipmentBackupVO> equipmentBackupVOList = new ArrayList<EquipmentBackupVO>();
private ArrayList<EquipmentVO> equipmentVOList = new ArrayList<EquipmentVO>();
private  ArrayList<BaseInfoVO> mainMucList=new  ArrayList<BaseInfoVO>();
private  ArrayList<BaseInfoVO> backMucList=new  ArrayList<BaseInfoVO>();
private ArrayList<McuCascadeModelVO> mcuModelList;
private EquipmentVO equipmentVO=new EquipmentVO();
private static EquipmentBackupVO equipmentBackupVO;
private BaseInfoVO baseInfoVO;
private McuCascadeModelVO mcuCascadeModelVO;

private String equipmentbackupIDs;
private String InUseEquipmentID;
private String description;
private String style1;
private String style2;
private String meetingID;
/**
 * 查询mcu列表
 * add by tanzanlong
 * @return
 */
public String mcuquery(){
	logger.info("EquipmentBackupAction	mcuquery	begin");
	try{
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO,null);
	   
		
		this.getCurHttpServletRequest().setAttribute("equipmentVOList", equipmentVOList);
	}catch(Exception e){
		logger.error("EquipmentBackupAction	mcuquery	error:"+e.getMessage());
		return ERROR;
	}
	logger.info("EquipmentBackupAction	mcuquery	end");
	return SUCCESS;
}

/**
 * 查询teminal(终端)列表
 * add by tanzanlong
 * @return
 */
public String terminalquery(){
	logger.info("EquipmentBackupAction	terminalquery	begin");
	try{
		equipmentVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
		equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO,null);
	    
		
		
		this.getCurHttpServletRequest().setAttribute("equipmentVOList", equipmentVOList);
	}catch(Exception e){
		logger.error("EquipmentBackupAction	terminalquery	error:"+e.getMessage());
		return ERROR;
	}
	logger.info("EquipmentBackupAction	terminalquery	end");
	return SUCCESS;
}


public String backupQuery() throws Exception{
	logger.info("EquipmentBackupAction	 backupQuery	begin");
	try{ 
		UserVO userVO = (UserVO)getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		List<FuncVO> fcList = new ArrayList<FuncVO>();
		fcList = ServiceFactory.getFuncService().getFuncList(userVO, null);
		if(fcList!=null&&fcList.size()>0){
			for(int i=0;i<fcList.size();i++){
				for(FuncVO vo:fcList){
					vo = fcList.get(i);
					if("8a8690153947d1f4013947d4325e9811".equals(vo.getFunc_id())){
						return "mcuBackup";
					}else if("8a8690153947d1f4013947d4325e9812".equals(vo.getFunc_id())){
						return "terminalBackup";
					}
				}
			}
		}
		logger.info("EquipmentBackupAction	 backupQuery	end");
	}catch(Exception e){
		logger.error("EquipmentBackupAction	 backupQuery	error:"+e.getMessage());
		return ERROR;
	}
	return SUCCESS;
}

/**
 * 查询mcu备份列表
 * add by tanzanlong
 * @return
 */
public String mcuBackupquery() throws Exception{
	logger.info("EquipmentBackupAction	 mcuBackupquery	begin");
	try{ 
		 ActionContext.getContext().getSession().put("mcuBackInfo", "");
		 EquipmentBackupVO equipmentBackupVON=new EquipmentBackupVO ();
		 equipmentBackupVON.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		 equipmentBackupVON.setStatus(EquipmentBackupEnum.STATUS_VALID);
		 equipmentBackupVOList=ServiceFactory.getEquipmentBackupService().query(equipmentBackupVON,getPageControler() );
	
	   this.getCurHttpServletRequest().setAttribute("style1", style1);
	
	}catch(Exception e){
		logger.error("EquipmentBackupAction	 mcuBackupquery	error:"+e.getMessage());
		return ERROR;
	}
	return SUCCESS;
}


/**
 * 根据meetid查询mcu备份列表
 * @author zhangjy
 * @return
 */
public String mcuBackupqueryByMeetingID() throws Exception{
	logger.info("EquipmentBackupAction	 mcuBackupqueryByMeetingID	begin");
	try{ 
		 equipmentBackupVOList=ServiceFactory.getEquipmentBackupService().queryByMeetingID(meetingID);
	     this.getCurHttpServletRequest().setAttribute("style1", style1);
	
	}catch(Exception e){
		logger.error("EquipmentBackupAction	 mcuBackupquery	error:"+e.getMessage());
		return ERROR;
	}
	return SUCCESS;
}


/**
 * 删除mcu备份
 * add by tanzanlong
 * @return
 */
public String mcuBackupqueryDel() throws Exception{
	logger.info("EquipmentBackupAction	 DelmcuBackup	begin");
	try{
			
		ServiceFactory.getEquipmentBackupService().deleteByID(equipmentBackupVO.getEquipmentID(), equipmentBackupVO.getBackupEquipmentID());
	
	}catch(Exception e){
		logger.error("EquipmentBackupAction	 DelmcuBackup	error:"+e.getMessage());
		return ERROR;
	}
	return SUCCESS;
}

	
/**
 * 修改mcu备份
 * add by tanzanlong
 * @return
 */
public String mcuBackupqueryUpdate() throws Exception{
	logger.info("EquipmentBackupAction	 DelmcuBackup	begin");
	try{
		equipmentBackupVO=ServiceFactory.getEquipmentBackupService().queryByID(equipmentBackupVO.getBackupEquipmentID());
		
		ServiceFactory.getEquipmentBackupService().deleteByID(equipmentBackupVO.getEquipmentID(), equipmentBackupVO.getBackupEquipmentID());
	
	}catch(Exception e){
		logger.error("EquipmentBackupAction	 DelmcuBackup	error:"+e.getMessage());
		return ERROR;
	}
	return SUCCESS;
}


/**
 * 终端备份信息
 * add by tanzanlong
 * @return
 */
public String terminalBackupquery(){
	logger.info("EquipmentBackupAction	terminalBackupquery	begin");
	try {		
	
		 EquipmentBackupVO equipmentBackupVON=new EquipmentBackupVO ();
		 equipmentBackupVON.setStatus(EquipmentBackupEnum.STATUS_VALID);
		 equipmentBackupVON.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
		 equipmentBackupVOList=ServiceFactory.getEquipmentBackupService().query(equipmentBackupVON,getPageControler() );
		 this.getCurHttpServletRequest().setAttribute("style2", style2);
		
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	
	return SUCCESS;
}


/**
 * 保存mcu备份信息
 * add by tanzanlong
 * @return InUseEquipmentID
 */
public String addMCUBackup(){
	logger.info("EquipmentBackupAction	addMCUBackup	begin");
	try{
		UserVO sessionUserVO = (UserVO)getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);		
		String []id=InUseEquipmentID.split(",");
		for(int i=0;i<id.length;i++){
			EquipmentBackupVO equipmentBackupVO=new EquipmentBackupVO();
			equipmentBackupVO.setEquipmentID(id[i]);	
			equipmentBackupVO.setBackupEquipmentID(equipmentbackupIDs);	
			equipmentBackupVO.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
			equipmentBackupVO.setStatus(EquipmentBackupEnum.STATUS_VALID);
			List<EquipmentBackupVO> list=ServiceFactory.getEquipmentBackupService().query(equipmentBackupVO, null);
			if(list.size()>0){
				ActionContext.getContext().getSession().put("mcuBackInfo", "已存在相同记录备份");
				continue;
				}else{
					ActionContext.getContext().getSession().put("mcuBackInfo", "");
				}
		
	 		equipmentBackupVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			equipmentBackupVO.setDescription(description);
			equipmentBackupVO.setBackupLevel(i);
			equipmentBackupVO.setCreateUserID(sessionUserVO.getUserID());
			equipmentBackupVO.setEmploy(EquipmentBackupEnum.IS_AVAILABLE);
			
						
						
			ServiceFactory.getEquipmentBackupService().add(equipmentBackupVO);
			
		}
		
		
	}catch(Exception e){
		logger.error("EquipmentBackupAction	addMCUBackup	error:"+e.getMessage());
		return ERROR;
	}
	logger.info("EquipmentBackupAction	addMCUBackup	end");
	return SUCCESS;
}

/**
 * 保存终端备份信息
 * add by tanzanlong
 * @return
 */
public String addTerminalBackup(){
	logger.info("EquipmentBackupAction	addTerminalBackup	begin");
	try{
		
		UserVO sessionUserVO = (UserVO)getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
		
		String []id=InUseEquipmentID.split(",");
		for(int i=0;i<id.length;i++){
			EquipmentBackupVO equipmentBackupVO=new EquipmentBackupVO();
			equipmentBackupVO.setEquipmentID(id[i]);
			equipmentBackupVO.setBackupEquipmentID(equipmentbackupIDs);
			
			equipmentBackupVO.setStatus(EquipmentBackupEnum.STATUS_VALID);
			
		
			List<EquipmentBackupVO> list=ServiceFactory.getEquipmentBackupService().query(equipmentBackupVO, null);
			if(list.size()>0){
				continue;
			}		
			equipmentBackupVO.setCreateDate(new Timestamp(System.currentTimeMillis()));
			equipmentBackupVO.setDescription(description);
			equipmentBackupVO.setBackupLevel(i);
			equipmentBackupVO.setCreateUserID(sessionUserVO.getUserID());
			equipmentBackupVO.setEmploy(EquipmentBackupEnum.IS_AVAILABLE);
			
			equipmentBackupVO.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			
			ServiceFactory.getEquipmentBackupService().add(equipmentBackupVO);
		}
		
	}catch(Exception e){
		logger.error("EquipmentBackupAction	addTerminalBackup	error:"+e.getMessage());
		return ERROR;
	}
	logger.info("EquipmentBackupAction	addTerminalBackup	end");
	return SUCCESS;
}

	
/**
 * 删除终端备份
 * add by tanzanlong
 * @return
 */
public String terminalBackupqueryDel() throws Exception{
	logger.info("EquipmentBackupAction	 DelmcuBackup	begin");
	try{
		ServiceFactory.getEquipmentBackupService().deleteByID(equipmentBackupVO.getEquipmentID(), equipmentBackupVO.getBackupEquipmentID());
	
	}catch(Exception e){
		logger.error("EquipmentBackupAction	 DelmcuBackup	error:"+e.getMessage());
		return ERROR;
	}
	return SUCCESS;
}

/**
 * 
 * @author zhangjy
 * @return
 */
public String mcuBackGl(){
	logger.info("EquipmentBackupAction	 mcuBackupquery	begin");
	try{ 
		EquipmentBackupVO tempebv=new EquipmentBackupVO();
		tempebv.setBackupEquipmentID(equipmentBackupVO.getBackupEquipmentID());
		tempebv.setEquipmentID(equipmentBackupVO.getEquipmentID());
		tempebv.setEquipmentType(EquipmentEnum.TYPE_ID_MCU);
		tempebv.setStatus(EquipmentBackupEnum.STATUS_VALID);
		equipmentBackupVO=ServiceFactory.getEquipmentBackupService().query(tempebv, null).get(0);;
		
		McuCascadeModelVO mcuCascadeModelVO=new McuCascadeModelVO();
		mcuCascadeModelVO.setStatus(McuCascademodelEnum.STATUS_BACK);
		mcuCascadeModelVO.setMcuIp(equipmentBackupVO.getIp()+","+equipmentBackupVO.getBackupip());
		mcuModelList=ServiceFactory.getMcuCascadeModelService().query(mcuCascadeModelVO, null);
		String[] tempStrs=new String[mcuModelList.size()];
		for(int i=0;i<mcuModelList.size();i++){
			McuCascadeModelVO mm=(McuCascadeModelVO)mcuModelList.get(i);
			tempStrs[i]=mm.getModelID().split(",")[0];
		}
		
		BaseInfoVO baseInfoVO = new BaseInfoVO();
		baseInfoVO.setInfoName(equipmentBackupVO.getBackupip());
		backMucList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
		baseInfoVO.setInfoName(equipmentBackupVO.getIp());
		mainMucList = ServiceFactory.getBaseInfoService().query(baseInfoVO, null);
		for(int i=0;i<mainMucList.size();i++){
			BaseInfoVO bv=mainMucList.get(i);
			int tempint=Arrays.binarySearch(tempStrs, bv.getInfoValue());
			if(tempint>=0){
				mainMucList.remove(bv);
			}
		}
	   this.getCurHttpServletRequest().setAttribute("style1", style1);
	
	}catch(Exception e){
		logger.error("EquipmentBackupAction	 mcuBackupquery	error:"+e.getMessage());
		return ERROR;
	}
	    return SUCCESS;
	
}


/**
 * @author zhangjy
 * @2013-08-27
 * @return
 */

public String addMcuModelGl(){
	logger.info("EquipmentBackupAction	 addMcuModelGl	begin");
	McuCascadeModelVO mmv=new McuCascadeModelVO();
	UserVO sessionUserVO = (UserVO)getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
	try {
		
		mmv.setCascadeName("备份关联");
		String tempMcuName=equipmentBackupVO.getEquipmentName()+","+equipmentBackupVO.getBackupEquipmentName();
		mmv.setMcuName(tempMcuName);
		String tempMcuIp=equipmentBackupVO.getIp()+","+equipmentBackupVO.getBackupip();
		mmv.setMcuIp(tempMcuIp);
		String tempMainMcu=baseInfoVO.getInfoValue();
		String[] tempMainMcus=tempMainMcu.split(",");
		String tempBackMcu=baseInfoVO.getDescription();
		String[] tempBackMcus=tempBackMcu.split(",");
		mmv.setModelID(tempMainMcus[0]+","+tempBackMcus[0]);
		mmv.setModelName(tempMainMcus[1]+","+tempBackMcus[1]);
		mmv.setStatus(McuCascademodelEnum.STATUS_BACK);
		mmv.setCreateDate(new Timestamp(System.currentTimeMillis()));
		mmv.setCreateUserID(sessionUserVO.getUserID());
		McuCascadeModelVO tempmmv=new McuCascadeModelVO();
		tempmmv.setStatus(McuCascademodelEnum.STATUS_BACK);
		tempmmv.setMcuIp(tempMcuIp);
		tempmmv.setModelID(tempMainMcus[0]+",%");
		logger.info(" start query mmList");
		ArrayList mmList=ServiceFactory.getMcuCascadeModelService().query(tempmmv, null);
		logger.info(" end query mmList");
		if(mmList.size()<=0){
		ServiceFactory.getMcuCascadeModelService().add(mmv);
		}
		return SUCCESS;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	logger.info("EquipmentBackupAction	 addMcuModelGl	end");
	return ERROR;
	
}

/**
 * 
 * @author zhangjy
 * 2013-08-27
 * @return
 */
public String delMcuModelGl(){
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



	public EquipmentBackupVO getEquipmentBackupVO() {
		return equipmentBackupVO;
	}

	public void setEquipmentBackupVO(EquipmentBackupVO equipmentBackupVO) {
		this.equipmentBackupVO = equipmentBackupVO;
	}

	public ArrayList<EquipmentBackupVO> getEquipmentBackupVOList() {
		return equipmentBackupVOList;
	}

	public void setEquipmentBackupVOList(
			ArrayList<EquipmentBackupVO> equipmentBackupVOList) {
		this.equipmentBackupVOList = equipmentBackupVOList;
	}

	public ArrayList<EquipmentVO> getEquipmentVOList() {
		return equipmentVOList;
	}

	public void setEquipmentVOList(ArrayList<EquipmentVO> equipmentVOList) {
		this.equipmentVOList = equipmentVOList;
	}

	public EquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(EquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getEquipmentbackupIDs() {
		return equipmentbackupIDs;
	}

	public void setEquipmentbackupIDs(String equipmentbackupIDs) {
		this.equipmentbackupIDs = equipmentbackupIDs;
	}

	public String getInUseEquipmentID() {
		return InUseEquipmentID;
	}

	public void setInUseEquipmentID(String inUseEquipmentID) {
		InUseEquipmentID = inUseEquipmentID;
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

	public String getMeetingID() {
		return meetingID;
	}

	public void setMeetingID(String meetingID) {
		this.meetingID = meetingID;
	}

	public ArrayList<BaseInfoVO> getMainMucList() {
		return mainMucList;
	}

	public void setMainMucList(ArrayList<BaseInfoVO> mainMucList) {
		this.mainMucList = mainMucList;
	}

	public ArrayList<BaseInfoVO> getBackMucList() {
		return backMucList;
	}

	public void setBackMucList(ArrayList<BaseInfoVO> backMucList) {
		this.backMucList = backMucList;
	}

	public void setBaseInfoVO(BaseInfoVO baseInfoVO) {
		this.baseInfoVO = baseInfoVO;
	}

	public BaseInfoVO getBaseInfoVO() {
		return baseInfoVO;
	}

	public void setMcuModelList(ArrayList<McuCascadeModelVO> mcuModelList) {
		this.mcuModelList = mcuModelList;
	}

	public ArrayList<McuCascadeModelVO> getMcuModelList() {
		return mcuModelList;
	}

	public void setMcuCascadeModelVO(McuCascadeModelVO mcuCascadeModelVO) {
		this.mcuCascadeModelVO = mcuCascadeModelVO;
	}

	public McuCascadeModelVO getMcuCascadeModelVO() {
		return mcuCascadeModelVO;
	}

	
	
	
}
