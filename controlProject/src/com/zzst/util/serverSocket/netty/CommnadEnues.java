package com.zzst.util.serverSocket.netty;


/**
 *@Description	锐取设备指令
 *@date 2011-3-21下午07:10:05
 *@author ryan
 */
public class CommnadEnues {
	//tnrc connroomEX id:0 bHighRate:0 bConn:1 ip1:192.168.2.235 ip2:192.168.2.236 ip3:192.168.2.234
	public final static  String		connect_channelID	="tnrc connroomEX id:##1 bHighRate:##2 bConn:1 ";
	public final static  String		unConnect_channelID	="tnrc connroomEX id:##1 bHighRate:0 bConn:0";
	
	public final static  String		record	="tnrc recordEX id:##1 bRecord:0 ppt:1 name:##3 mask:127";
	public final static  String		stop_record	="tnrc recordEX id:##1 bRecord:1";
	public final static  String		pause_record	="tnrc recordEX id:##1 bRecord:2";
	public final static  String		continue_record	="tnrc recordEX id:##1 bRecord:3";
	
}
