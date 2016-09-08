package com.zzst.action.meeting.apply.flow;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cbf.web.util.PageSplittor;
import com.gsiec.cjf.system.CjfLogger;
import com.gsiec.model.portal.session.UserSessionVO;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.ApplyEnum;
import com.zzst.model.enums.DictionaryEnum;
import com.zzst.model.meeting.apply.flow.ApplyFlowVO;
import com.zzst.model.meeting.apply.flownode.ApplyFlownodeVO;
import com.zzst.model.meeting.dictionary.DictionaryVO;
import com.zzst.model.meeting.user.UserVO;

public class ApplyFlowAction extends BaseAction{
	private static Logger logger = CjfLogger.getLogger(ApplyFlowAction.class.getName());
	private static final long serialVersionUID = 1L;
	private ApplyFlowVO applyFlowVO = new ApplyFlowVO();
	private List<ApplyFlowVO> applyFlowList = new ArrayList<ApplyFlowVO>();
	private List<DictionaryVO> dictionaryList	= new ArrayList<DictionaryVO>();
	
	/**
	 * 流程管理列表
	 * @return
	 */
	public String queryApplyFlows(){
		logger.info("ApplyFlowAction	queryApplyFlows	begin");		
		try{
			PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
			//applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
			applyFlowList = ServiceFactory.getApplyFlowService().query(applyFlowVO, pSplittor.getPControler());
		}catch(Exception e){
			logger.error("ApplyFlowAction	queryApplyFlows	error:"+e.getMessage());
		}
		logger.info("ApplyFlowAction	queryApplyFlows	end");
		return SUCCESS;
	}

	/**
	 * 查看流程
	 * @return
	 */
	public String applyFlowDetail(){
		logger.info("ApplyFlowAction	applyFlowDetail	begin");		
		try{
			applyFlowList = ServiceFactory.getApplyFlowService().query(applyFlowVO,null);
			if(applyFlowList!=null&&applyFlowList.size()>0){
				applyFlowVO = applyFlowList.get(0);
			}
		}catch(Exception e){
			logger.error("ApplyFlowAction	applyFlowDetail	error:"+e.getMessage());	
		}
		logger.info("ApplyFlowAction	applyFlowDetail	end");
		return SUCCESS;
	}
	
	/**
	 * 添加流程前
	 * @return
	 */
	public String applyFlowBeforeAdd(){
		logger.info("ApplyFlowAction	applyFlowBeforeAdd	begin");		
		try{
			DictionaryVO dictionaryVO = new DictionaryVO();
			dictionaryVO.setDicType(DictionaryEnum.DICTYPE_APPLYFLOW);
			dictionaryList = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
		}catch(Exception e){
			logger.error("ApplyFlowAction	applyFlowBeforeAdd	error:"+e.getMessage());	
		}
		logger.info("ApplyFlowAction	applyFlowBeforeAdd	end");
		return SUCCESS;
	}
	
	/**
	 * 添加流程
	 * @return
	 */
	public String addApplyFlow(){
		logger.info("ApplyFlowAction	addApplyFlow	begin");		
		try{
			UserVO loginUser = (UserVO)request.getSession().getAttribute(UserSessionVO.USER_SESSION_ID);
			applyFlowVO.setCreateUserID(loginUser.getUserID());
			applyFlowVO.setCreateTime(new Timestamp(System.currentTimeMillis()));
			if(applyFlowVO.getStatus()==ApplyEnum.STATUS_STOPUSE){
				applyFlowVO.setEndTime(new Timestamp(System.currentTimeMillis()));
			}else{
				applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
				applyFlowVO.setStartTime(new Timestamp(System.currentTimeMillis()));
			}
			//applyFlowVO.setIsEndFlow(ApplyEnum.END_FLOW);//默认结束
			//新加节点
			ServiceFactory.getApplyFlowService().add(applyFlowVO);
		}catch(Exception e){
			logger.error("ApplyFlowAction	addApplyFlow	error:"+e.getMessage());	
		}
		logger.info("ApplyFlowAction	addApplyFlow	end");
		return SUCCESS;
	}
	
	/**
	 * 删除流程以及对应的流程节点
	 * @return
	 */
	public String applyFlowDelete(){
		logger.info("ApplyFlowAction	applyFlowDelete	begin");		
		try{
			ServiceFactory.getApplyFlowService().deleteByID(applyFlowVO.getFlowID());//查询当前节点
			ApplyFlownodeVO applyFlownodeVO = new ApplyFlownodeVO();
			applyFlownodeVO.setFlowID(applyFlowVO.getFlowID());
			ServiceFactory.getApplyFlownodeService().deleteByFlowID(applyFlownodeVO);//删除该流程下的流程节点的配置
		}catch(Exception e){
			logger.error("ApplyFlowAction	applyFlowDelete	error:"+e.getMessage());	
		}
		logger.info("ApplyFlowAction	applyFlowDelete	end");
		return SUCCESS;
	}
	
	/**
	 * 流程修改前
	 * @return
	 */
	public String applyFlowBeforeModify(){
		logger.info("ApplyFlowAction	applyFlowBeforeModify	begin");		
		try{
			applyFlowList = ServiceFactory.getApplyFlowService().query(applyFlowVO,null);
			if(applyFlowList!=null&&applyFlowList.size()>0){
				applyFlowVO = applyFlowList.get(0);
			}
			DictionaryVO dictionaryVO = new DictionaryVO();
			dictionaryVO.setDicType(DictionaryEnum.DICTYPE_APPLYFLOW);
			dictionaryList = ServiceFactory.getDictionaryService().query(dictionaryVO, null);
		}catch(Exception e){
			logger.error("ApplyFlowAction	applyFlowBeforeModify	error:"+e.getMessage());	
		}
		logger.info("ApplyFlowAction	applyFlowBeforeModify	end");
		return SUCCESS;
	}
	
	/**
	 * 流程修改
	 * @return
	 */
	public String modifyApplyFlow(){
		logger.info("ApplyFlowAction	modifyApplyFlow	begin");		
		try{
			if(applyFlowVO.getStatus()==ApplyEnum.STATUS_STOPUSE){
				applyFlowVO.setEndTime(new Timestamp(System.currentTimeMillis()));
			}else{
				applyFlowVO.setStatus(ApplyEnum.STATUS_USE);
				applyFlowVO.setStartTime(new Timestamp(System.currentTimeMillis()));
			}
			ServiceFactory.getApplyFlowService().modify(applyFlowVO);
		}catch(Exception e){
			logger.error("ApplyFlowAction	modifyApplyFlow	error:"+e.getMessage());	
		}
		logger.info("ApplyFlowAction	modifyApplyFlow	end");
		return SUCCESS;
	}
	
	public ApplyFlowVO getApplyFlowVO() {
		return applyFlowVO;
	}

	public void setApplyFlowVO(ApplyFlowVO applyFlowVO) {
		this.applyFlowVO = applyFlowVO;
	}

	public List<ApplyFlowVO> getApplyFlowList() {
		return applyFlowList;
	}

	public void setApplyFlowList(List<ApplyFlowVO> applyFlowList) {
		this.applyFlowList = applyFlowList;
	}

	public List<DictionaryVO> getDictionaryList() {
		return dictionaryList;
	}

	public void setDictionaryList(List<DictionaryVO> dictionaryList) {
		this.dictionaryList = dictionaryList;
	}
	
	/**
	 * 查看审批流程
	 * @return
	 
	public String seeFlowStatus(){
		logger.info("ApplyConferenceAction	seeFlowStatus	begin");
		try{
			flowList = ServiceFactory.getApplyFlowService().seeFlowStatus(applyID,applyType);
		}catch(Exception e){
			logger.error("ApplyConferenceAction	queryApplyConferences	error:"+e.getMessage());
		}
		logger.info("ApplyConferenceAction	seeFlowStatus	end");
		return SUCCESS;
	}
	*/

}
