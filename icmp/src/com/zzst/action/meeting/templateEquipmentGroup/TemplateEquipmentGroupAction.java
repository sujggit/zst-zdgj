package com.zzst.action.meeting.templateEquipmentGroup;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.enums.LevelEnum;
import com.zzst.model.enums.TopMeetingTemplate;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.templateEquipment.TemplateEquipmentVO;
import com.zzst.model.meeting.templateEquipmentGroup.TemplateEquipmentGroupVO;
import com.zzst.model.meeting.user.UserVO;

public class TemplateEquipmentGroupAction extends CjfAction{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(TemplateEquipmentGroupAction.class.getName());
	private TemplateEquipmentGroupVO templateEquipmentGroupVO;
	private ArrayList<TemplateEquipmentGroupVO> templateEquipmentGroupVOList;
	private String groupName;
	public String  MeetingGroupQuery(){
		logger.info("TemplateEquipmentGroupAction	 MeetingGroupQuery		begin");
		try{
			 TemplateEquipmentGroupVO templateEquipmentGroupVO_=new  TemplateEquipmentGroupVO();
			if(groupName!=null&&!groupName.equals("")){
				templateEquipmentGroupVO_.setName(groupName);
			}
			 ///////////////分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
					templateEquipmentGroupVO_.setLevelid(suv.getLvoids());
					System.out.println("============"+suv.getLvoids());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			templateEquipmentGroupVOList=ServiceFactory.getTemplateEquipmentGroupService().query(templateEquipmentGroupVO_,this.getPageControler());
		  // System.out.println("templateEquipmentGroupVOList ..............."+templateEquipmentGroupVOList.size());
		}catch(Exception e){
			logger.error("TemplateEquipmentGroupAction	 MeetingGroupQuery	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentGroupAction	 MeetingGroupQuery		end");
		return SUCCESS;
	}
	
	
	public String  preMeetingGroupModify(){
		logger.info("TemplateEquipmentGroupAction	 preMeetingGroupModify		begin");
		try{
			templateEquipmentGroupVO=ServiceFactory.getTemplateEquipmentGroupService().queryByID(templateEquipmentGroupVO.getID());
		   //System.out.println("templateEquipmentGroupVOList ..............."+templateEquipmentGroupVOList.size());
		}catch(Exception e){
			logger.error("TemplateEquipmentGroupAction	 preMeetingGroupModify	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentGroupAction	 preMeetingGroupModify		end");
		return SUCCESS;
	}
	
	public String  MeetingGroupModify(){
		logger.info("TemplateEquipmentGroupAction	MeetingGroupModify		begin");
		try{
			ServiceFactory.getTemplateEquipmentGroupService().modify(templateEquipmentGroupVO);
		   //System.out.println("templateEquipmentGroupVOList ..............."+templateEquipmentGroupVOList.size());
		}catch(Exception e){
			logger.error("TemplateEquipmentGroupAction	 MeetingGroupModify	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentGroupAction	 MeetingGroupModify		end");
		return SUCCESS;
	}
	
	
	public String  MeetingGroupAdd(){
		logger.info("TemplateEquipmentGroupAction	 MeetingGroupQueryAdd		begin");
		try{
           ///////////////分级分权 @author:zhangjy///////////////////////////
			UserVO suv = (UserVO)this.getCurHttpServletRequest().getSession().getAttribute(UserEnum.USER_SESSION_ID);
			if(MeetingAppConfig.LEVEL_IS_POEN){
				if(!(suv.getLvoids().contains("'"+LevelEnum.IS_LEVEL_FATHER+"'"))){
			      templateEquipmentGroupVO.setLevelid(suv.getLevelConfigVO().getLevelID());
				}
			}
            /////////////////////////////////end/////////////////////////////////////
			templateEquipmentGroupVO.setStatus(TopMeetingTemplate.STATUS_VALID);
			TemplateEquipmentGroupVO templateEquipmentGroupVO_=new TemplateEquipmentGroupVO();
			templateEquipmentGroupVO_.setName(templateEquipmentGroupVO.getName());
			templateEquipmentGroupVOList=ServiceFactory.getTemplateEquipmentGroupService().query(templateEquipmentGroupVO_, null);
			if(templateEquipmentGroupVOList!=null&&templateEquipmentGroupVOList.size()>0){
				return SUCCESS;
			}
			ServiceFactory.getTemplateEquipmentGroupService().add(templateEquipmentGroupVO);
		
		}catch(Exception e){
			logger.error("TemplateEquipmentGroupAction	 MeetingGroupQueryAdd	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentGroupAction	 MeetingGroupQueryAdd		end");
		return SUCCESS;
	}
	
	
	public String  MeetingGroupDel(){
		logger.info("TemplateEquipmentGroupAction	 MeetingGroupQueryAdd		begin");
		try{
			TemplateEquipmentVO templateEquipmentVO=new TemplateEquipmentVO();
			templateEquipmentVO.setGroupId(templateEquipmentGroupVO.getID());
			
			ArrayList<TemplateEquipmentVO> templateEquipmentVOList= ServiceFactory.getTemplateEquipmentService().query(templateEquipmentVO, null);
			
			for(int i=0;i<templateEquipmentVOList.size();i++){
				
				ServiceFactory.getTemplateEquipmentService().deleteByID(templateEquipmentVOList.get(i).getID());
			}
			
			ServiceFactory.getTemplateEquipmentGroupService().deleteByID(templateEquipmentGroupVO.getID());
		
		}catch(Exception e){
			logger.error("TemplateEquipmentGroupAction	 MeetingGroupQueryAdd	error："+e.getMessage());
			return ERROR;
		}
		logger.info("TemplateEquipmentGroupAction	 MeetingGroupQueryAdd		end");
		return SUCCESS;
	}
	
	
	public TemplateEquipmentGroupVO getTemplateEquipmentGroupVO() {
		return templateEquipmentGroupVO;
	}
	public void setTemplateEquipmentGroupVO(
			TemplateEquipmentGroupVO templateEquipmentGroupVO) {
		this.templateEquipmentGroupVO = templateEquipmentGroupVO;
	}


	public ArrayList<TemplateEquipmentGroupVO> getTemplateEquipmentGroupVOList() {
		return templateEquipmentGroupVOList;
	}


	public void setTemplateEquipmentGroupVOList(
			ArrayList<TemplateEquipmentGroupVO> templateEquipmentGroupVOList) {
		this.templateEquipmentGroupVOList = templateEquipmentGroupVOList;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	

}
