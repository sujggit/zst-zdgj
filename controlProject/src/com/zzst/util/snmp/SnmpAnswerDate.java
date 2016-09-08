package com.zzst.util.snmp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.log4j.Logger;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import com.zzst.terminal.service.impl.communication.TerminalClientThread;

import snmp.SNMPVarBindList;
import snmp.SNMPv1CommunicationInterface;



/**
 *@Description
 *@date 2011-5-23下午03:11:48
 *@author ryan
 */
public abstract class SnmpAnswerDate {
	private static Logger log = Logger.getLogger(TerminalClientThread.class
			.getName());
	private  int version=0;
	private  String protocol = "udp";
	private  String port="161";
	private  String community = "public";
	
	public   String snmpGet(String ipAddress,String oid){
		String resultStat = null;
		StringBuilder address = new StringBuilder();
		address.append(protocol);
		address.append(":");
		address.append(ipAddress);
		address.append("/");
		address.append(port);
		Address targetAddress = GenericAddress.parse(address.toString());
		PDU pdu = new PDU();
		pdu.add(new VariableBinding(new OID(oid)));
		pdu.setType(PDU.GET);
		
		//创建共同体对象communityTarget
		CommunityTarget target = new CommunityTarget();
		target.setCommunity(new OctetString(community));
		target.setAddress(targetAddress);
		target.setVersion(SnmpConstants.version1);
		target.setTimeout(2000);
		target.setRetries(1);
		
		DefaultUdpTransportMapping udpTransportMapping = null;
		Snmp snmp = null;
		try{
			//发送同步消息
			udpTransportMapping = new DefaultUdpTransportMapping();
			udpTransportMapping.listen();
			snmp = new Snmp(udpTransportMapping);
			ResponseEvent response = snmp.send(pdu, target);
			PDU responsePdu = response.getResponse();
			
			if(responsePdu == null){
				log.info(ipAddress+":Request time out");
			}else {
				Object obj = responsePdu.getVariableBindings().firstElement();
				VariableBinding variable = (VariableBinding)obj;
				System.out.println(variable.getOid());
				resultStat = variable.getVariable().toString();
			}
		}catch (Exception e) {
			System.out.println("获取SNMP节点状态时发生错误"+e);
		}finally{
			if(snmp != null){
				try {
					snmp.close();
				} catch (IOException e2) {
					snmp = null;
				}
			}
			if(udpTransportMapping != null){
				try {
					udpTransportMapping.close();
				} catch (Exception e2) {
					udpTransportMapping = null;
				}
			}
		}
		System.out.println("IP" + ipAddress + " resultStat:"+resultStat);
		return resultStat;
	}
	
	/**
	 *  2.0版本
	 * @param ipAddress
	 * @param community
	 * @param oid
	 * @return
	 */
	public String[] snmpwalk(String ipAddress,String oid){
		String[] returnValueStrings = null; //oid走访结果数组
		SNMPv1CommunicationInterface comInterface = null;
		try{
			InetAddress hostAddress = InetAddress.getByName(ipAddress);
			comInterface = new SNMPv1CommunicationInterface(version,hostAddress,community);
			comInterface.setSocketTimeout(2000);
			
			//返回所有以oid开始的管理信息库变量值
			parseDate(ipAddress,comInterface.retrieveMIBTable(oid));
			
		}catch (Exception e) {
			System.out.println("SNMP走访节点时发生错误");
		}finally{
			if(comInterface!=null){
				try{
					comInterface.closeConnection();
				}catch (SocketException e) {
					comInterface = null;
				}
				
			}
		}
		return returnValueStrings;
	}
	
	
	public  abstract  void parseDate(String ip,SNMPVarBindList tableVars);
	
	public static void main(String[] args) {
		//SnmpAnswerMethod.snmpGet("10.1.6.201", "public", "1.3.6.1.6.3.1.1.4.1.0");
		//SnmpManager.snmpGet("127.0.0.1", "public", "sysName.0");
//new SnmpAnswerMethod().snmpwalk("10.1.6.21", "public", "1.3.6.1.4.1.2684.1.1.5");
	}
	




}
