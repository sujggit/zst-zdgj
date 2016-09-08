package com.zzst.util.snmp;

import snmp.SNMPVarBindList;


/**
 *@Description
 *测试使用
 *
 *@date 2011-5-23下午03:12:15
 *@author ryan
 */
public class SnmpAnswerParseTest extends SnmpAnswerDate {

	@Override
	public void parseDate(String ip,SNMPVarBindList tableVars) {
		// TODO Auto-generated method stub
		System.out.println("=="+tableVars.getValue());
	}
	public static void main(String[] args) {
		//SnmpAnswerMethod.snmpGet("10.1.6.201", "public", "1.3.6.1.6.3.1.1.4.1.0");
		//SnmpManager.snmpGet("127.0.0.1", "public", "sysName.0");
		new SnmpAnswerParseTest().snmpGet("10.1.6.201",  "1.3.6.1.4.1.13885.9.2.1.2.2.2.1");
	}
}
