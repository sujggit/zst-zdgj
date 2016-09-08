package com.zzst.action.meeting.util.task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.model.meeting.equipment.EquipmentVO;
import com.zzst.util.timerTask.CjfTimeTask;

public class EquipmentMaintenanceTask extends CjfTimeTask {

	public EquipmentMaintenanceTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	@Override
	public boolean excuteTask() {
		EquipmentVO eqVO = new EquipmentVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			List<EquipmentVO> eqList = ServiceFactory.getEquipmentService().query(eqVO, null);
			if(eqList!=null&&eqList.size()>0){
				String currentTime = (sdf.format(new Timestamp(System.currentTimeMillis()))).toString();
				for(int i=0;i<eqList.size();i++){
					if(eqList.get(i).getMaintenanceEndTime()==null) continue;
					String endTime = (sdf.format(eqList.get(i).getMaintenanceEndTime())).toString();
					if(currentTime.equals(endTime)){
						//SendMessage sdMessage = new SendMessage(MeetingAppConfig.MESSAGE_TYPE_EQWANRRANTY,eqList.get(i));
						//接口变动，张建志还没有调整完成。
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void main(String[] args){
//		EquipmentMaintenanceTask eq = new EquipmentMaintenanceTask();
//		eq.excuteTask();
		
		
	}
}
