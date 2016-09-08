package com.zzst.mcu.service.snmp;

import snmp.SNMPVarBindList;

import com.zzst.util.snmp.SnmpAnswerDate;


/**
 *@Description
 *@date 2011-5-23下午03:16:10
 *@author ryan
 */
public class SnmpMcuImpl  extends SnmpAnswerDate {

	@Override
	public void parseDate(String ip,SNMPVarBindList tableVars) {
		// TODO Auto-generated method stub
		//解析返回数据，调用mcu提供的接口
		//McuObject mcuObject = (McuObject)McuObject.getEquipmentObject(ip);;
		
	}

	public static void main(String[] args) {
		//new SnmpMcuImpl().snmpwalk(ipAddress, oid);
	}
}
