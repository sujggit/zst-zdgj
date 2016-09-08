package com.zzst.terminal.service.impl;

import com.zzst.terminal.service.impl.communication.TerminalClientThread;
import com.zzst.terminal.service.impl.communication.TerminalClientThreadByReturn;
import com.zzst.terminal.service.snmp.SnmpTerminalImpl;
import com.zzst.util.ServerSocketEnues;

/**
 * 终端命令
 *@author	ryan
 *@since	2010-11-15上午10:48:13
 *@version	1.0
 */

public class TerminalImplHelp {
	
	/**
	 * 终端发送命令
	 * @param command
	 * @return
	 */
	public static boolean sendCommand(String terminalIp,int terminalPort,String command){
		try {
			return TerminalClientThread.sendCommandToTerminal(terminalIp, terminalPort, command);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 终端发送命令提取返回值
	 * @param command
	 * @return
	 */
	public static boolean sendCommandByBackInfo(String terminalIp,int terminalPort,String command,String commandReturn){
		try {
			TerminalClientThreadByReturn t=new TerminalClientThreadByReturn(terminalIp,terminalPort,command,commandReturn,false);
			t.start();
			ServerSocketEnues.setTerminalThread(terminalIp, t);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	
	/**
	 * 在设备注册完成询问信息
	 */
	public static  void  initDateFromSnmp(String terminalIp){
		new SnmpTerminalImpl().snmpGet(terminalIp, "1.3.6.1.4.1.13885.9.2.1.2.2.2.1");
		new SnmpTerminalImpl().snmpGet(terminalIp, "1.3.6.1.4.1.13885.9.2.1.2.2.2.1");
		new SnmpTerminalImpl().snmpGet(terminalIp, "1.3.6.1.4.1.13885.9.2.1.2.2.2.1");
	}
	
	/**
	 * 根据oid询问终端相应状态，只负责发送命令
	 * @param oid
	 */
	public static  void  answerInfoFromSnmp(String terminalIp,String oid){
		new SnmpTerminalImpl().snmpGet(terminalIp, oid);
	}
}
