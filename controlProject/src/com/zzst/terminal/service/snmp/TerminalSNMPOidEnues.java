package com.zzst.terminal.service.snmp;


/**
 *@Description
 *@date 2011-3-21下午03:51:09
 *@author ryan
 */
public class TerminalSNMPOidEnues {

	public static final	String	polycomVSAuthLocation_oid			=	"1.3.6.1.4.1.2684.1.1.1";
	public static final	String	polycomVSPhoneNumber_oid			=	"1.3.6.1.4.1.2684.1.1.2";//最后呼叫的ip或者电话号码
	public static final	String	polycomVSReason_oid					=	"1.3.6.1.4.1.2684.1.1.3";
	public static final	String	polycomVSPlead_oid					=	"1.3.6.1.4.1.2684.1.1.4";
	public static final	String	polycomVSMicDataOid					=	"1.3.6.1.4.1.2684.1.1.5";
	public static final	String	polycomVSAutoAnswerSetting_oid		=	"1.3.6.1.4.1.2684.1.1.6";
	public static final	String	polycomVSTimeServerAddress_oid		=	"1.3.6.1.4.1.2684.1.1.7";
	public static final	String	polycomVSTimeServerSetting_oid		=	"1.3.6.1.4.1.2684.1.1.8";
	public static final	String	polycomVSGDSAddress_oid				=	"1.3.6.1.4.1.2684.1.1.9";
	public static final	String	polycomVSGatekeeperAddress_oid		=	"1.3.6.1.4.1.2684.1.1.10";
	public static final	String	polycomVSPreviousIPAddress_oid		=	"1.3.6.1.4.1.2684.1.1.11";
	public static final	String	polycomVSCurrentIPAddress_oid		=	"1.3.6.1.4.1.2684.1.1.12";
	public static final	String	polycomVSPreviousNicType_oid		=	"1.3.6.1.4.1.2684.1.1.13";
	public static final	String	polycomVSCurrentNicType_oid			=	"1.3.6.1.4.1.2684.1.1.14";
	public static final	String	polycomVSNicLineNumber_oid			=	"1.3.6.1.4.1.2684.1.1.15";
	public static final	String	polycomVSPreviousNicLineCount_oid	=	"1.3.6.1.4.1.2684.1.1.16";
	public static final	String	polycomVSCurrentNicLineCount_oid	=	"1.3.6.1.4.1.2684.1.1.17";
	public static final	String	polycomVSV35PortsEnabled_oid		=	"1.3.6.1.4.1.2684.1.1.18";
	public static final	String	polycomVSAuthClientAddress_oid		=	"1.3.6.1.4.1.2684.1.1.19";
	public static final	String	polycomVSUPnPStatus_oid				=	"1.3.6.1.4.1.2684.1.1.20";
	public static final	String	polycomVSPercentPacketLoss_oid		=	"1.3.6.1.4.1.2684.1.1.21";
	public static final	String	polycomVSJitter_oid					=	"1.3.6.1.4.1.2684.1.1.22";
	public static final	String	polycomVSLatency_oid				=	"1.3.6.1.4.1.2684.1.1.23";

	public static final	String	polycomAudio_oid					=	"1.3.6.1.4.1.2684.2";
	public static final	String	polycomData_oid						=	"1.3.6.1.4.1.2684.3";
	
	
	//trap信息返回标示
	public static final	String	call_status_oid			="1.3.6.1.6.3.1.1.4.1.0";//提取呼叫状态的oid
	public static final	String	call_status_up			="1.3.6.1.4.1.2684.1.1.0.4";//呼通
	public static final	String	call_status_down		="1.3.6.1.4.1.2684.1.1.0.5";//挂断
	public static final	String	call_status_fail		="1.3.6.1.4.1.2684.1.1.0.6";//异常
	
	public static final	String	call_hangup_IP_oid		="1.3.6.1.4.1.2684.1.1.2.0";//呼叫、挂断IP
	public static final	String	call_hangup_date_oid	="1.3.6.1.2.1.1.3.0";//呼叫、挂断时间
	
//	public static final	String	back_call_IP_oid		="1.3.6.1.4.1.2684.1.1.0.4";//呼叫ip返回的标示
//	public static final	String	back_call_phone_oid		="1.3.6.1.4.1.2684.1.1.0.6";//呼叫电话返回的标示
//	public static final	String	back_hangup_oid			="1.3.6.1.4.1.2684.1.1.0.5";//挂断通话返回的标示

}
