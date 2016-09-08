package com.zzst.util.snmp;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.smi.VariableBinding;

import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.snmp.trapParse.impl.TerminalInfoParse;



/**
 *@Description
 *@date 2011-3-22上午11:25:25
 *@author ryan
 */
public class SnmpTrapParse extends SnmpTrapDate{
	private static Logger logger = Logger.getLogger(SnmpTrapParse.class
			.getName());
	public static final	String	polycomData_oid						=	"1.3.6.1.4.1.2684.3";
	
	public SnmpTrapParse(String ip, String revision) {
		super(ip, revision);
	}

	@Override
	public void processPdu(CommandResponderEvent respEvnt) {
		
		
		// 解析Response
        if (respEvnt != null && respEvnt.getPDU() != null) {
        	Vector<VariableBinding> recVBs = respEvnt.getPDU().getVariableBindings();
      		Map<String,String> mibMap = new HashMap<String,String>();
        	
      		for (int i = 0; i < recVBs.size(); i++) {
           		VariableBinding recVB = recVBs.elementAt(i);
           		mibMap.put(recVB.getOid().toString(), recVB.getVariable().toString());
           		logger.info(recVB.getOid().toString()+"::::::::"+recVB.getVariable().toString());
      		}
      		
        	//检查是什么设备a.substring(0, a.indexOf("/"))
           	String fromIp = respEvnt.getPeerAddress().toString().subSequence(0, respEvnt.getPeerAddress().toString().indexOf("/")).toString();
           	if(EquipmentObject.EQUIPMENT_TYPE_TERMINAL==EquipmentObjectImpl.checkEquipmentType(fromIp)){
           		logger.info("==**终端*****SNMP*****=");
           		TerminalInfoParse.parseMib(fromIp,mibMap);
        	}else if(EquipmentObject.EQUIPMENT_TYPE_MCU==EquipmentObjectImpl.checkEquipmentType(fromIp)){
        		//McuInofParse
        		logger.info("==**MCU*****SNMP*****=");
        	}else{
        		logger.info("==**其它*****SNMP*****=");
        	}
		}
	}

	public static void main(String[] args) {
		PropertyConfigurator.configure("D:/develop_C/zdq/controlProject/src/applog4j.properties");//加载.properties文件
		
		SnmpTrapParse TrapSnmp = new SnmpTrapParse("10.1.3.46",SnmpTrapParse.mpv2);
		TrapSnmp.startListen();
	}

}
