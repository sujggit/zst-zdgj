package com.zzst.action.meeting.templateEquipment;

import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.dao.common.UtilDAO;
import com.zzst.model.enums.EquipmentEnum;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;
import com.zzst.model.meeting.user.UserVO;

public class TemplateEquipmentAction extends CjfAction{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(TemplateEquipmentAction.class.getName());
	private TemplateEquipmentVO templateEquipmentVO;
	private TemplateEquipmentGroupVO templateEquipmentGroupVO;
	private ArrayList<TemplateEquipmentVO> templateEquipmentVOList;
	ArrayList<EquipmentVO> equipmentVOList;
	private EquipmentVO equipmentVO;
	private String groupId;
	private String id;
	private String equipmentName;
	
	public String  MeetingEquipmentQuery(){
		logger.info("TemplateEquipmentAction	 MeetingEquipmentQuery		begin");
		try{
			templateEquipmentGroupVO =ServiceFactory.getTemplateEquipmentGroupService().queryByID(templateEquipmentGroupVO.getID());
			
			//System.out.println(templateEquipmentGroupVO.getID().toString()+"----------------");
			TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
			templateEquipmentVO_.setGroupId(templateEquipmentGroupVO.getID());
			//
			templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO_, getPageControler());
		    //System.out.println(templateEquipmentGroupVO.getID()+"此会议组的id----");
		    this.getCurHttpServletRequest().getSession().setAttribute("groupId",templateEquipmentGroupVO.getID());
		  
		   
			//System.out.println("templateEquipmentVOList ..............."+templateEquipmentVOList.size());
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	MeetingEquipmentQuery	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 MeetingEquipmentQuery		end");
		return SUCCESS;
	}
	
	
	
	public String  Query(){
		logger.info("TemplateEquipmentAction	 MeetingEquipmentQuery		begin");
		try{
			
			TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
			if(equipmentName!=null&&!equipmentName.equals("")){
				templateEquipmentVO_.setEquipmentName(equipmentName);
			}
			
			templateEquipmentGroupVO =ServiceFactory.getTemplateEquipmentGroupService().queryByID(templateEquipmentGroupVO.getID());
			templateEquipmentVO_.setGroupId(templateEquipmentGroupVO.getID());
			templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO_, getPageControler());
		    //System.out.println(templateEquipmentGroupVO.getID()+"此会议组的id----");
		    this.getCurHttpServletRequest().getSession().setAttribute("groupId",templateEquipmentGroupVO.getID());
		  
		   
			//System.out.println("templateEquipmentVOList ..............."+templateEquipmentVOList.size());
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	MeetingEquipmentQuery	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 MeetingEquipmentQuery		end");
		return SUCCESS;
	}
	
	
	
	
	
	
	public String  MeetingEquipmentAdd(){
		logger.info("TemplateEquipmentAction	 MeetingEquipmentAdd		begin");
		try{
			EquipmentVO  equipmentVO_=new EquipmentVO();
			equipmentVO_.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			equipmentVO_.setIp(templateEquipmentVO.getEquipmentIp());
			//System.out.println(templateEquipmentVO.getEquipmentIp()+"ip.............");
                templateEquipmentVO.setGroupId(templateEquipmentGroupVO.getID());
                TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
               // templateEquipmentVO_.setEquipmentName(templateEquipmentVO.getEquipmentName());
                templateEquipmentVO_.setEquipmentIp(templateEquipmentVO.getEquipmentIp());
                templateEquipmentVO_.setAliasName(templateEquipmentVO.getAliasName());
                templateEquipmentVO_.setGroupId(templateEquipmentGroupVO.getID());
                templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO_, null);
			if(templateEquipmentVOList!=null&&templateEquipmentVOList.size()>0){
				return SUCCESS;
			}
			
			
			ArrayList<EquipmentVO> equipmentVOList =ServiceFactory.getEquipmentService().query(equipmentVO_, null);
			if(equipmentVOList!=null&& equipmentVOList.size()>0){
				templateEquipmentVO.setMeetingRoomID(equipmentVOList.get(0).getMeetingRoomVO().getMeetingRoomID());
			}else{
				templateEquipmentVO.setMeetingRoomID(null);
			}
			
			
			
		
			ServiceFactory.getTemplateEquipmentService().add(templateEquipmentVO);
		    
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	MeetingEquipmentAdd	error："+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 MeetingEquipmentAdd		end");
		return SUCCESS;
	}
	
	
	
	public String  EquipmentQuery(){
		logger.info("TemplateEquipmentAction	 EquipmentQuery		begin");
		try{
			
			EquipmentVO equipmentVO_=new EquipmentVO();
			equipmentVO_.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			  ///////////////会议室分级分权 @author:zhangjy///////////////////////////
			if(MeetingAppConfig.LEVEL_IS_POEN){
				UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					equipmentVO_.setLevel(true);
					equipmentVO_.setLsql(suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			equipmentVOList=ServiceFactory.getEquipmentService().query(equipmentVO_, null);
			
			
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	 EquipmentQuery	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 EquipmentQuery		end");
		return SUCCESS;
	}
	
	public String  preToAddMeeting(){
		logger.info("TemplateEquipmentAction	 preToAddMeeting		begin");
	
		logger.info("TemplateEquipmentAction	 preToAddMeeting		end");
		return SUCCESS;
	}
	
	//
	
	
	public String preMeetingEquipmentAdd(){
		logger.info("TemplateEquipmentAction	 preMeetingEquipmentAdd		begin");
		try{
			templateEquipmentVO=ServiceFactory.getTemplateEquipmentService().queryByID(templateEquipmentVO.getID());
			//System.out.println(templateEquipmentVO.getID());
			if(templateEquipmentVO==null||templateEquipmentVO.getEquipmentIp()==null){
				EquipmentVO equipmentVO=new EquipmentVO();
				equipmentVO=ServiceFactory.getEquipmentService().queryByID(templateEquipmentVO.getID());
				templateEquipmentVO.setEquipmentName(equipmentVO.getEquipmentNO());
				templateEquipmentVO.setEquipmentIp(equipmentVO.getIp());
				ServiceFactory.getTemplateEquipmentService().add(templateEquipmentVO);
			}else{
				
				EquipmentVO equipmentVO=new EquipmentVO();
				equipmentVO=ServiceFactory.getEquipmentService().queryByID(templateEquipmentVO.getID());
				templateEquipmentVO.setEquipmentName(equipmentVO.getEquipmentNO());
				templateEquipmentVO.setEquipmentIp(equipmentVO.getIp());
				ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO);
			}
			
					    
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	 preMeetingEquipmentAdd	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 preMeetingEquipmentAdd		end");
		
		this.getCurHttpServletRequest().getSession().setAttribute("equipmentGroupId",templateEquipmentVO.getGroupId() );
		return SUCCESS;
	}
	
	
	public String  MeetingEquipmentDel(){
		logger.info("TemplateEquipmentAction	 MeetingEquipmentDel		begin");
		try{
			
			ServiceFactory.getTemplateEquipmentService().deleteByID(id);
		    
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	MeetingEquipmentDel	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 MeetingEquipmentDel		end");
		return SUCCESS;
	}
	
	
	public String  preMeetingEquipmentModify(){
		logger.info("TemplateEquipmentAction	 preMeetingEquipmentModify		begin");
		try{
			
			templateEquipmentVO=ServiceFactory.getTemplateEquipmentService().queryByID(id);
			System.out.println(templateEquipmentVO.getEquipmentIp());
		    
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	preMeetingEquipmentModify	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 preMeetingEquipmentModify		end");
		return SUCCESS;
	}
	
	
	public String  MeetingEquipmentModify(){
		logger.info("TemplateEquipmentAction	 MeetingEquipmentModify		begin");
		try{
			EquipmentVO  equipmentVO_=new EquipmentVO();
			equipmentVO_.setEquipmentType(EquipmentEnum.TYPE_ID_TERMINAL);
			equipmentVO_.setIp(templateEquipmentVO.getEquipmentIp());
			ArrayList<EquipmentVO> equipmentVOList =ServiceFactory.getEquipmentService().query(equipmentVO_, null);
			if(equipmentVOList!=null&& equipmentVOList.size()>0){
				templateEquipmentVO.setMeetingRoomID(equipmentVOList.get(0).getMeetingRoomVO().getMeetingRoomID());
			}else{
				templateEquipmentVO.setMeetingRoomID(null);
			}
			ServiceFactory.getTemplateEquipmentService().modify(templateEquipmentVO);
		    
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	MeetingEquipmentModify	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 MeetingEquipmentModify		end");
		return SUCCESS;
	}
	/**
	 * 会场组复制
	 * @return
	 */
	
	public String  MeetingEquipmentCopy(){
		logger.info("TemplateEquipmentAction	 MeetingEquipmentCopy		begin");
		try{
			//前台传递了一个templateEquipmentGroupVO.ID,插入z_t_template_equipment_group表
			String oldGroupId = templateEquipmentGroupVO.getID();
			templateEquipmentGroupVO = ServiceFactory.getTemplateEquipmentGroupService().queryByID(oldGroupId);
			String groupId = UtilDAO.getUUid();
			templateEquipmentGroupVO.setID(groupId);
			templateEquipmentGroupVO.setName(templateEquipmentGroupVO.getName()+"的复制");
			ServiceFactory.getTemplateEquipmentGroupService().add(templateEquipmentGroupVO);
			
			//根据前台传递的templateEquipmentGroupVO.ID，查询templateEquipmentVOList
			templateEquipmentGroupVO =ServiceFactory.getTemplateEquipmentGroupService().queryByID(oldGroupId);
			TemplateEquipmentVO templateEquipmentVO_=new TemplateEquipmentVO();
			templateEquipmentVO_.setGroupId(oldGroupId);
			templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO_, null);
			this.getCurHttpServletRequest().getSession().setAttribute("groupId",templateEquipmentGroupVO.getID());
			
			//将templateEquipmentVOList循环遍历插入到数据库。将grooupId设置为之前插入的groupId。
			if(templateEquipmentVOList!=null&&templateEquipmentVOList.size()>0){
				for(TemplateEquipmentVO vo:templateEquipmentVOList){
					vo.setGroupId(groupId);
					vo.setID(UtilDAO.getUUid());
					ServiceFactory.getTemplateEquipmentService().add(vo);
				}
			}
			TemplateEquipmentVO templateEquipmentVO_1=new TemplateEquipmentVO();
			templateEquipmentVO_1.setGroupId(oldGroupId);
			templateEquipmentVOList=ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO_1, getPageControler());
		}catch(Exception e){
			logger.error("TemplateEquipmentAction	MeetingEquipmentCopy	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentAction	 MeetingEquipmentCopy		end");
		return SUCCESS;
	}
	
	public TemplateEquipmentVO getTemplateEquipmentVO() {
		return templateEquipmentVO;
	}
	public void setTemplateEquipmentVO(
			TemplateEquipmentVO templateEquipmentVO) {
		this.templateEquipmentVO = templateEquipmentVO;
	}


	public ArrayList<TemplateEquipmentVO> getTemplateEquipmentVOList() {
		return templateEquipmentVOList;
	}


	public void setTemplateEquipmentVOList(
			ArrayList<TemplateEquipmentVO> templateEquipmentVOList) {
		this.templateEquipmentVOList = templateEquipmentVOList;
	}


	public TemplateEquipmentGroupVO getTemplateEquipmentGroupVO() {
		return templateEquipmentGroupVO;
	}


	public void setTemplateEquipmentGroupVO(TemplateEquipmentGroupVO templateEquipmentGroupVO) {
		this.templateEquipmentGroupVO = templateEquipmentGroupVO;
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	public String getEquipmentName() {
		return equipmentName;
	}



	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}




}
