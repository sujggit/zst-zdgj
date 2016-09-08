package com.zzst.util.snmp;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.mp.MPv3;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TcpAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;


/**
 *@Description
 *@date 2011-2-12上午09:45:28
 *@author ryan
 */
public abstract class SnmpTrapDate  implements CommandResponder {
	private static Logger logger = Logger.getLogger(SnmpTrapDate.class
			.getName());
	
	public static	final	String	mpv1 = "1";
	public static	final	String	mpv2 = "2";
	public static	final	String	mpv3 = "3";
	
	private String ip;
	private String revision;
	/**
	 * 	接受信息的服务器ip地址
	 * @param ip
	 */
	public SnmpTrapDate(String ip,String revision) {
		this.ip 		=	ip;
		this.revision	=	revision;
		// BasicConfigurator.configure();
	}

	private Snmp init() throws UnknownHostException, IOException {
		ThreadPool threadPool = ThreadPool.create("Trap", 20);
		MultiThreadedMessageDispatcher dispatcher = new MultiThreadedMessageDispatcher(threadPool,
				new MessageDispatcherImpl());
		Address listenAddress = GenericAddress.parse(System.getProperty(
				"snmp4j.listenAddress", "udp:"+ip+"/162")); // 本地IP与监听端口
		TransportMapping transport;
		// 对TCP与UDP协议进行处理
		if (listenAddress instanceof UdpAddress) {
			transport = new DefaultUdpTransportMapping(
					(UdpAddress) listenAddress);
		} else {
			transport = new DefaultTcpTransportMapping(
					(TcpAddress) listenAddress);
		}
		Snmp snmp = new Snmp(dispatcher, transport);
		if(mpv1.equals(revision)){
			snmp.getMessageDispatcher().addMessageProcessingModel(new MPv1());
		}else if(mpv2.equals(revision)){
			snmp.getMessageDispatcher().addMessageProcessingModel(new MPv2c());
		}else if(mpv3.equals(revision)){
			snmp.getMessageDispatcher().addMessageProcessingModel(new MPv3());
		}
		
		USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(MPv2c.ID+""), 0);
		SecurityModels.getInstance().addSecurityModel(usm);
		snmp.listen();
		return snmp;
	}

	
	public void startListen() {
		try {
			init().addCommandResponder(this);
			logger.info("开始监听信息!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 实现CommandResponder的processPdu方法, 用于处理传入的请求、PDU等信息
	 * 当接收到trap时，会自动进入这个方法
	 * 
	 * @param respEvnt
	 */
	public abstract void processPdu(CommandResponderEvent respEvnt);

}
