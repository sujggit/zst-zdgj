package com.zzst.dao.meeting.equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.db.MasterQueryObject;
import com.cbf.log.CbfLogger;
import com.zzst.model.meeting.equipment.EquipmentVO;

/**
 * class description: Equipment MQB
 * 
 * @author ryan
 * @date Mon Aug 03 17:54:13 CST 2009
 */

public class EquipmentUseTimeMQB extends MasterQueryObject {
	static Logger logger = CbfLogger.getLogger(EquipmentMQB.class.getName());

	public static int QUERY_FROM_EQUIPMENT = 1;

	private EquipmentVO vEquipmentVO;

	private ArrayList<EquipmentVO> lstEquipment = new ArrayList<EquipmentVO>();

	private int _operatorType = -1;

	public EquipmentUseTimeMQB(int operatorType) {
		_operatorType = operatorType;

	}

	public void setSql(String sqlstr) {
		this.sqlStr = sqlstr;
	}

	public void getDataForRow(ResultSet rs) throws SQLException {
//		if (QUERY_FROM_EQUIPMENT == _operatorType) {
//			vEquipmentVO = new EquipmentVO();
//			vEquipmentVO.setEquipmentID(rs.getInt("equipmentID"));
//			vEquipmentVO.setEquipmentNO(rs.getString("equipmentNO"));
//			vEquipmentVO.setEquipmentNameCaption(rs
//					.getString("equipmentNameCaption"));
//			vEquipmentVO.setModelName(rs.getString("modelName"));
//			vEquipmentVO.setMeetingRoomName(rs.getString("meetingRoomName"));
//			vEquipmentVO.setMeetingRoomID(rs.getInt("meetingroomId"));
//			
//			//计算设备用时
//			Timestamp startTime =rs.getTimestamp("starttime");
//			Timestamp endTime =rs.getTimestamp("endtime");	
//			if(startTime!=null&&endTime!=null){
//				long useTime=endTime.getTime()-startTime.getTime();
//				long a=useTime/60000;//以分钟为单位
//				vEquipmentVO.setUseTime(a);
//			}
//			lstEquipment.add(vEquipmentVO);
//		}

	}

	public ArrayList<EquipmentVO> getEquipmentList() {
		return lstEquipment;

	}

	public EquipmentVO getEquipmentVO() {
		return vEquipmentVO;
	}

}
