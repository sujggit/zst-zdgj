package com.zzst.action.meeting.information;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.action.meeting.util.AlertInfoUtil;
import com.zzst.model.meeting.information.InformationVO;


public class AlertDwrMethod {
	private static Logger logger = CjfLogger
	.getLogger(AlertDwrMethod.class.getName());
	private  AlertInfoUtil alertInfoUtil=new AlertInfoUtil();
	private  ArrayList<InformationVO> list=new ArrayList<InformationVO>();
	// ArrayList<InformationVO>
	public  int getAlertInfomation(){
		int s=0;
		logger.info("AlertDwrMethod	getAlertInfomation	begin");
		try{			
			list=alertInfoUtil.getAlertInformationList();
			s=list.size();
		}catch(Exception e){
			logger.error("AlertDwrMethod	getAlertInfomation	error:	"+e.getMessage());
		}
		return s;	
}
	
	public  ArrayList<InformationVO> getReAlertInfomation(){
		logger.info("AlertDwrMethod	getReAlertInfomation	begin");
		try{			
			list=alertInfoUtil.getAlertInformationList();
			
		}catch(Exception e){
			logger.error("AlertDwrMethod	getReAlertInfomation	error:	"+e.getMessage());
		}
		return list;	
}
	//add by tanzanlong 2013-3-12
	public  void hidenAlertInfomation(){
		logger.info("AlertDwrMethod	getAlertInfomation	begin");
		try{	
			list=alertInfoUtil.getAlertInformationList();
			alertInfoUtil.DelInfoFromListByList(list);
			
		}catch(Exception e){
			logger.error("AlertDwrMethod	getAlertInfomation	error:	"+e.getMessage());
		}
		return ;	
}
	
	
}