package com.zzst.otherEquipment.service.impl;

import org.apache.log4j.Logger;

import com.zzst.otherEquipment.service.OtherEquipmentObject;
import com.zzst.otherEquipment.service.vo.OtherEquipmentVO;


/**
 *@Description
 *@date 2013-12-27下午05:07:11
 *@author ryan
 */
public class OtherEquipmentObjectImpl extends OtherEquipmentObject{
	private static Logger logger = Logger.getLogger(OtherEquipmentObjectImpl.class
			.getName());
	/**
	 * 0	id
	 * 1	ip 
	 * 2	port
	 * 3	name
	 */
	public OtherEquipmentObjectImpl(String[] info){
		OtherEquipmentVO vo = new OtherEquipmentVO();
		vo.setId(info[0]);
		vo.setIp(info[1]);
		if(info[2]!=null&&info[2].length()>0){
			try{
				vo.setPort(Integer.valueOf(info[2]).intValue());
			}catch(Exception e){
				logger.error("注册端口异常:"+info[2]);
			}
		}
				
		vo.setName(info[3]);
		this.setEquipmentVO(vo);
	}
}
