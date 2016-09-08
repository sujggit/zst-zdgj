package com.zzst.otherEquipment.service;


import com.zzst.otherEquipment.service.vo.OtherEquipmentVO;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.SystemConfig;


/**
 *@Description
 *@date 2013-12-27下午05:03:20
 *@author ryan
 */
public class OtherEquipmentObject  extends EquipmentObject{

	/**
	 * 在线
	 */
	public static final String status_on = "0";
	
	/**
	 * ip不通
	 */
	public static final String status_off = "1";
	
	/**
	 * 未知状态
	 */
	public static final String status_def = "-1";
	
	
	private String status;
	private OtherEquipmentVO equipmentVO = new OtherEquipmentVO();
	
	 

	public String getStatus() {
		return status;
	}

	public void setStatus(String sys,String status) {
		if(SystemConfig.METHED_WITHIN.equalsIgnoreCase(sys))
			this.status = status;
	}

	public OtherEquipmentVO getEquipmentVO() {
		return equipmentVO;
	}

	public void setEquipmentVO(OtherEquipmentVO equipmentVO) {
		this.equipmentVO = equipmentVO;
	}

	public String getIp() {
		return equipmentVO.getIp();
	}

	public int getPort() {
		return equipmentVO.getPort();
	}
	/**
	 * 提取当前检查终端的的线程数
	 * @return int
	 * add by ryan on 20140226
	 */
	public static int getNetStatusThreadNumber() {
		return EquipmentObjectImpl.net_status_thread_number_other;
	}
}
