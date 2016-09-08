package com.zzst.action.meeting.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;
import com.zzst.model.enums.InformationEnum;
import com.zzst.model.meeting.information.InformationVO;

public class AlertInfoUtil {
	private static Logger logger = CjfLogger.getLogger(BaseInfoHelp.class.getName());
    private  ArrayList<InformationVO> list=new ArrayList<InformationVO>();
    private  InformationVO informationVO;
    ArrayList<InformationVO> infolist=new ArrayList<InformationVO>();
	/**add by tanzanlong
	 * 获得未失效的告警信息
	 *
	 */
	public  ArrayList<InformationVO> getAlertInformationList(){ 
	
		try{
			
			
		
			InformationVO infoVO=new InformationVO();
			infoVO.setStatus(InformationEnum.STATUS_VALID);
		   
			list= ServiceFactory.getInformationService().query(infoVO, null);
		    
		    //获得当前系统时间
			      
            Timestamp sysTime= new Timestamp(System.currentTimeMillis());
		 
		    int j=list.size();
		    for(int i=0;i<j;i++){
		    	InformationVO info=new InformationVO();
		    	info=list.get(i);
		    	Timestamp createMesTime=info.getCreateTime();
		    	createMesTime.setMinutes(createMesTime.getMinutes()+5);	    	
		    	int bool=createMesTime.compareTo(sysTime);
		    	if(bool<0&&info.getInfoType()==InformationEnum.TYPE_MEETING){
		    		info.setStatus(InformationEnum.STATUS_INVALID);
		    		ServiceFactory.getInformationService().modify(info);
		    		list.remove(info);
		    		--i;
		    		--j;
		    	}
		    
		    }
		    
		 
		 
	}catch (Exception e) {
		logger.error("提取告警信息异常："+e.getMessage());
	}
	
	  return list;
}
	/**add by tanzanlong
	 * 设置告警信息失效     1为有效    0为无效；
	 *
	 */
	public InformationVO  DelInfoFromList(InformationVO vInformationVO){ 
		
		try{
			vInformationVO.setStatus(InformationEnum.STATUS_INVALID);	 
	}catch (Exception e) {
		logger.error("提取告警信息异常："+e.getMessage());
	}
	
	  return vInformationVO;
}	
	
public void  DelInfoFromListByList(ArrayList<InformationVO> vInformationVOList){ 
		
		try{
			for(int i=0;i<vInformationVOList.size();i++){
				InformationVO vInformationVO=new InformationVO();
				vInformationVO=(InformationVO) vInformationVOList.get(i);
			    vInformationVO.setStatus(InformationEnum.STATUS_INVALID);	
			    ServiceFactory.getInformationService().modify(vInformationVO);
			}
			 
	}catch (Exception e) {
		logger.error("提取告警信息异常："+e.getMessage());
	}
	
	  return ;
}	
	
	
	
	
	
	
	public ArrayList<InformationVO> getList() {
		return list;
	}
	public void setList(ArrayList<InformationVO> list) {
		this.list = list;
	}

	
}