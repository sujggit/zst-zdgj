package com.zzst.util.snmp.trapParse.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.vo.TerminalMeetingVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.SystemConfig;


/**
 *@Description
 *@date 2011-5-27下午12:01:48
 *@author ryan
 */
public class TerminalInfoParse {
	private static Logger logger = Logger.getLogger(TerminalInfoParse.class
			.getName());
	public	static void	parseMib(String fromIP,Map<String,String>	mibMap){
		//呼叫、挂断信息
		if(mibMap.get(TerminalBackOidEnues.BACK_KEY_OID_CALL)!=null){
			setMeetingVO(fromIP,mibMap);
		}else if(true){
			
		}
	}
	
	/**
	 * 处理呼叫、挂断信息
	 * @param fromIP
	 * @param value
	 */
	private	static	void	setMeetingVO(String fromIP,Map<String,String>	mibMap){
		String backValue	=	mibMap.get(TerminalBackOidEnues.BACK_KEY_OID_CALL)	;
		String farIP = mibMap.get(TerminalBackOidEnues.BACK_VALUE_OID_IP);
		try{
			TerminalObject terminalObject = (TerminalObject)ControlFactory.getTerminalObject(fromIP);
			if(terminalObject!=null){
				if(TerminalBackOidEnues.BACK_VALUE_OID_CALL_UP.equalsIgnoreCase(backValue)){
					logger.info("SNMP返回信息-----"+terminalObject.getTerminalIp()+"----呼叫"+farIP+"成功");
					if(terminalObject.getMeetingVO(fromIP, farIP)==null){
						logger.info("SNMP返回信息---------"+farIP+"呼入成功");
						TerminalMeetingVO callInVO = new TerminalMeetingVO();
						callInVO.setFarIP(farIP);
						callInVO.setFarPhone(farIP);
						callInVO.setMeetingType(TerminalMeetingVO.TYPE_MANUAL_IN);
						terminalObject.setMeetingVO(SystemConfig.METHED_WITHIN, callInVO);
					}
				}else if(TerminalBackOidEnues.BACK_VALUE_OID_CALL_DOWN.equalsIgnoreCase(backValue)){
					logger.info("SNMP返回信息-----"+terminalObject.getTerminalIp()+"----挂断"+farIP+"成功");
					terminalObject.removeMeetingVO(SystemConfig.METHED_WITHIN, farIP);
				}else if(TerminalBackOidEnues.BACK_VALUE_OID_CALL_EXCEPTION.equalsIgnoreCase(backValue)){
					logger.info("SNMP返回信息-----"+terminalObject.getTerminalIp()+"-呼叫---对方("+farIP+")没有接受呼叫");
					terminalObject.removeMeetingVO(SystemConfig.METHED_WITHIN, farIP);
				}
			}
		}catch(Exception e){
			logger.error("解析SNMP返回信息异常："+e.getMessage());
		}
		
	}
}
