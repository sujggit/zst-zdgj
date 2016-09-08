package com.zzst.reach.service.impl.communication.cm200;


/**
 *@Description	CM200锐取设备指令
 *第二个参数是，执行成功的返回值
 *@date 2014-7-9下午07:10:05
 *@author ryan
 */
public class CommnadEnues {
	//tnrc connroomEX id:0 bHighRate:0 bConn:1 ip1:192.168.2.235 ip2:192.168.2.236 ip3:192.168.2.234
	public final static  String[]		connect_channelID	={"tnrc connroomEX id:##1 bHighRate:##2 bConn:1 ","<connroomEX>operate succeed</connroomEX>"};
	public final static  String[]		unConnect_channelID	={"tnrc connroomEX id:##1 bHighRate:0 bConn:0","<connroomEX>operate succeed</connroomEX>"};
	
	public final static  String[]		channel_status	={"tnrc roomstateEX  roomid:##1 "};
	
	public final static  String[]		record	={"tnrc recordEX id:##1 bRecord:1 ppt:1 name:##2 mask:127","<recordEX>operate succeed</recordEX>"};
	public final static  String[]		record_status	={"tnrc getrecordstateEX id:##1"};
	public final static  String[]		stop_record	={"tnrc recordEX id:##1 bRecord:0","<recordEX>operate succeed</recordEX>"};
	public final static  String[]		pause_record	={"tnrc recordEX id:##1 bRecord:2","<recordEX>operate succeed</recordEX>"};
	public final static  String[]		continue_record	={"tnrc recordEX id:##1 bRecord:3","<recordEX>operate succeed</recordEX>"};
	
}
