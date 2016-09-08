package com.zzst.action.meeting.information;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfAction;
import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.AlertInfoUtil;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.information.InformationVO;

public class AlertAction extends CjfAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = CjfLogger
	.getLogger(AlertAction.class.getName());
	
	private  AlertInfoUtil alertInfoUtil=new AlertInfoUtil();
	private  ArrayList<InformationVO> informationVOList=new ArrayList<InformationVO>();
	// ArrayList<InformationVO>
	public  String getAlertInfomation(){
		
		logger.info("AlertAction	getAlertInfomation	begin");
		try{			
			informationVOList=alertInfoUtil.getAlertInformationList();
			for(int i=0;i<informationVOList.size();i++){
				InformationVO informationVO=new InformationVO();
				informationVO=informationVOList.get(i);
				informationVO.setStatus(0);
			ServiceFactory.getInformationService().modify(informationVO);
			}
			this.getCurHttpServletRequest().getSession().setAttribute("alertList", informationVOList);
			
		}catch(Exception e){
			logger.error("AlertAction	getAlertInfomation	error:	"+e.getMessage());
		}
		return  SUCCESS;	
}
	public AlertInfoUtil getAlertInfoUtil() {
		return alertInfoUtil;
	}
	public void setAlertInfoUtil(AlertInfoUtil alertInfoUtil) {
		this.alertInfoUtil = alertInfoUtil;
	}
	public ArrayList<InformationVO> getInformationVOList() {
		return informationVOList;
	}
	public void setInformationVOList(ArrayList<InformationVO> informationVOList) {
		this.informationVOList = informationVOList;
	}
	
}
