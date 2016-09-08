package com.zzst.centerContor.service.impl.communication;


/**
 * 序号和指令之间的转换
 * @author wxw
 *
 */
public class GetCommand {
	public static String getOutCommand(String num){
		System.out.println("源指令---------"+num);
		//-------------电源------
		if("POWER.001:ON".equals(num)){//党组电视机开
			num = CommandHelp.ml[33];return num;
		}else if("POWER.001:OFF".equals(num)){//党组电视机关
			num = CommandHelp.ml[34];return num;
		}
		else if("POWER.000:ON".equals(num)){//时序电源
			num = CommandHelp.ml[0];return num;
		}
		else if("POWER.000:OFF".equals(num)){
			num = CommandHelp.ml[1];return num;
		}
		else if("POWER.002:ON".equals(num)){//中型电视机
			num = CommandHelp.ml[35];return num;
		}
		else if("POWER.002:OFF".equals(num)){
			num = CommandHelp.ml[36];return num;
		}
		//十二层中控
		else if("POWER.010:ON".equals(num)){//12F时序电源
			num = CommandHelp.ml[132];return num;
		}
		else if("POWER.010:OFF".equals(num)){
			num = CommandHelp.ml[133];return num;
		}
		//-------------------音频----------
		else if("AUDIO.004:MUTE>OFF".equals(num)){//中型会议室电视取消静音
			num = CommandHelp.ml[129];return num;
		}
		else if("AUDIO.004:MUTE>ON".equals(num)){//中型会议室电视静音
			num = CommandHelp.ml[128];return num;
		}
		else if("AUDIO.003:MUTE>OFF".equals(num)){//党组会议室电视取消静音
			num = CommandHelp.ml[121];return num;
		}
		else if("AUDIO.003:MUTE>ON".equals(num)){//党组会议室电视静音
			num = CommandHelp.ml[120];return num;
		}
		//------------矩阵-------------MATRIX.1:VIDEO>01>03
		else if("MATRIX.1".equals(num.split(":")[0])){//党组矩阵
			String start = num.split(":")[1].split(">")[1];//VIDEO>01>03 --> 01 
			String end = num.split(":")[1].split(">")[2];//VIDEO>01>03 --> 03 
			//输入命令
			if("01".equals(start)){num=CommandHelp.ml[2];}
			else if("02".equals(start)){num=CommandHelp.ml[4];}
			else if("03".equals(start)){num=CommandHelp.ml[3];}
			else if("04".equals(start)){num=CommandHelp.ml[8];}
			else if("05".equals(start)){num=CommandHelp.ml[7];}
			else if("06".equals(start)){num=CommandHelp.ml[11];}
			else if("07".equals(start)){num=CommandHelp.ml[14];}
			//输出命令
			if("01".equals(end)){num=num+"-"+CommandHelp.ml[15];}
			else if("02".equals(end)){num=num+"-"+CommandHelp.ml[18];}
			else if("03".equals(end)){num=num+"-"+CommandHelp.ml[19];}
			else if("04".equals(end)){num=num+"-"+CommandHelp.ml[20];}
			else if("05".equals(end)){num=num+"-"+CommandHelp.ml[21];}
			else if("06".equals(end)){num=num+"-"+CommandHelp.ml[22];}
			return num;
		}
		else if("MATRIX.2".equals(num.split(":")[0])){//中型
			String start = num.split(":")[1].split(">")[1];//VIDEO>01>03 --> 01 
			String end = num.split(":")[1].split(">")[2];//VIDEO>01>03 --> 03 
			//输入命令
			if("01".equals(start)){num=CommandHelp.ml[5];}
			else if("02".equals(start)){num=CommandHelp.ml[6];}
			else if("03".equals(start)){num=CommandHelp.ml[9];}
			else if("04".equals(start)){num=CommandHelp.ml[10];}
			else if("05".equals(start)){num=CommandHelp.ml[11];}
			else if("06".equals(start)){num=CommandHelp.ml[12];}
			else if("07".equals(start)){num=CommandHelp.ml[13];}
			else if("08".equals(start)){num=CommandHelp.ml[14];}
			//输出命令
			if("01".equals(end)){num=num+"-"+CommandHelp.ml[17];}
			else if("02".equals(end)){num=num+"-"+CommandHelp.ml[16];}
			else if("03".equals(end)){num=num+"-"+CommandHelp.ml[18];}
			else if("04".equals(end)){num=num+"-"+CommandHelp.ml[23];}
			else if("05".equals(end)){num=num+"-"+CommandHelp.ml[19];}
			else if("06".equals(end)){num=num+"-"+CommandHelp.ml[20];}
			else if("07".equals(end)){num=num+"-"+CommandHelp.ml[21];}
			else if("08".equals(end)){num=num+"-"+CommandHelp.ml[22];}
			else if("09".equals(end)){num=num+"-"+CommandHelp.ml[24];}
			return num;
		}
		else if("MATRIX.3".equals(num.split(":")[0])){//12F
			String start = num.split(":")[1].split(">")[1];//VIDEO>01>03 --> 01 
			String end = num.split(":")[1].split(">")[2];//VIDEO>01>03 --> 03 
			//输入命令
			if("01".equals(start)){num=CommandHelp.ml[134];}
			else if("02".equals(start)){num=CommandHelp.ml[135];}
			else if("03".equals(start)){num=CommandHelp.ml[137];}
			else if("04".equals(start)){num=CommandHelp.ml[138];}
			else if("05".equals(start)){num=CommandHelp.ml[136];}
			else if("06".equals(start)){num=CommandHelp.ml[139];}
			else if("07".equals(start)){num=CommandHelp.ml[140];}
			//输出命令
			if("01".equals(end)){num=num+"-"+CommandHelp.ml[141];}
			else if("02".equals(end)){num=num+"-"+CommandHelp.ml[142];}
			else if("03".equals(end)){num=num+"-"+CommandHelp.ml[143];}
			else if("04".equals(end)){num=num+"-"+CommandHelp.ml[144];}
			else if("05".equals(end)){num=num+"-"+CommandHelp.ml[145];}
			return num;
		}
		else if(num.contains("_")){
			return num;
		}
		else{
			return null;
		}
	}//POWER.001:OFF
}
