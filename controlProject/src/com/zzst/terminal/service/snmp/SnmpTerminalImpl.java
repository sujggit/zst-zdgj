package com.zzst.terminal.service.snmp;

import snmp.SNMPVarBindList;

import com.zzst.util.snmp.SnmpAnswerDate;


/**
 *@Description
 *@date 2011-5-23下午03:15:56
 *@author ryan
 */
public class SnmpTerminalImpl  extends SnmpAnswerDate {

	@Override
	public void parseDate(String ip,SNMPVarBindList tableVars) {
		// TODO Auto-generated method stub
		//解析返回数据，调用终端提供的接口
		//TerminalObject mcuObject = (TerminalObject)TerminalObject.getEquipmentObject(ip);;
		System.out.println(tableVars.getValue());
		System.out.println(ip+"--"+tableVars.size()+"==");
	}
	
	
	public static void main(String[] args) {
													   
		new SnmpTerminalImpl().snmpwalk("10.1.6.83", "1.3.6.1.4.1.13885.9.2.1.2.1.3.1");
	}
}
