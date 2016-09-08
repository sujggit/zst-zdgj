package com.zzst.meeting.dwr.dataShare;

import java.util.Timer;
import java.util.TimerTask;

import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.vo.ViewScreentVO;
import com.zzst.util.ControlFactory;

public class SynchronizeThread extends Thread {
	public SynchronizeThread(String ip) {
		this.operateIP = ip;
	}
	
	private String operateIP;
	private String currentModel;
	
	private CenterControlObject currentCenterControl;
	private CenterControlObject localCenterControl = ControlFactory.getCenterControlObject(MeetingAppConfig.LOCAL_CCIP);
	
	private String operateType; // 操作类型 ：上行up 下行down

	public void setOperateIP(String operateIP) {
		this.operateIP = operateIP;
	}

	public String getOperateIP() {
		return operateIP;
	}
	
	@Override
	public void run() {
		Timer timer = new Timer();
		timer.schedule(new MyTask(),100,60000);
	}
	
	public void setCurrentModel(String currentModel) {
		this.currentModel = currentModel;
	}

	public String getCurrentModel() {
		return currentModel;
	}

	public void setCurrentCenterControl(CenterControlObject currentCenterControl) {
		this.currentCenterControl = currentCenterControl;
	}

	public CenterControlObject getCurrentCenterControl() {
		return currentCenterControl;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperateType() {
		return operateType;
	}

	public CenterControlObject getLocalCenterControl() {
		return localCenterControl;
	}

	public void setLocalCenterControl(CenterControlObject localCenterControl) {
		this.localCenterControl = localCenterControl;
	}


	class MyTask extends TimerTask{

        @Override
        public void run(){
        	
        	if("up".equals(operateType)){
        		currentCenterControl = (CenterControlObject)ControlFactory.getCenterControlObject(operateIP);
        		ViewScreentVO op_model_vo = (ViewScreentVO)(currentCenterControl.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID).getObject());
        		if(op_model_vo != null){
        			String op_model = op_model_vo.getModel();
        			if(op_model!=null){
        				if(!op_model.equals(currentModel)){
        					localCenterControl.viewScreentModel(MeetingAppConfig.CC_DEF_ID, op_model);
        					currentModel = op_model;
        				}
//        				if(currentModel.indexOf("221-VLINK")!=-1){
//        					ViewScreentVO vo = (ViewScreentVO)(currentCenterControl.viewScreentModelStatusInfo(MeetingAppConfig.CC_DEF_ID).getObject());
//        					if(!(vo.getModelInfo()[0].equals(currentSouce))){
//        						localCenterControl.viewScreentModelInfo(MeetingAppConfig.CC_DEF_ID, op_model, MeetingAppConfig.CC_DEF_ID, vo.getModelInfo()[0]);
//        						currentSouce = vo.getModelInfo()[0];
//        					}
//        				}
        			}
        		}
        	}
        	
        	if("down".equals(operateType)){
        		ViewScreentVO local_model_vo = (ViewScreentVO)(localCenterControl.viewScreentModelStatus(MeetingAppConfig.CC_DEF_ID).getObject());
        		if(local_model_vo !=null){
        			String local_model = local_model_vo.getModel();
        			
        			currentCenterControl = (CenterControlObject)ControlFactory.getCenterControlObject(operateIP);
        			if(local_model!=null){
        				if(!local_model.equals(currentModel)){
        					currentCenterControl.viewScreentModel(MeetingAppConfig.CC_DEF_ID, local_model);
        					currentModel = local_model;
        				}
        			}
        		}
        	}
        }
    }
}
