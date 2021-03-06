package com.zzst.centerContor.service.impl.communication;

import java.util.HashMap;
import java.util.Map;


public class CommandHelp {
	public static Map<Integer,String> sendCommands = new HashMap<Integer,String>();
	/**
	 * 当socket中断是调用清空命令的方法
	 */
	public static void clearCommands(){
		sendCommands.clear();
		sendLock = false;
	}
	public static boolean sendLock=false;
	public static String floorNum = "13F";
	public static String cammeraStop = "";//存储上一条指令，当取消按钮时取此指令
	public static String[] ml = {"00_01",
		"00_02",
		"00_0B",
		"00_0C",
		"00_0D",
		"00_0E",
		"00_0F",
		"00_10",
		"00_11",
		"00_12",
		"00_13",
		"00_14",
		"00_15",
		"00_16",
		"00_17",
		"00_1F",
		"00_21",
		"00_22",
		"00_23",
		"00_24",
		"00_25",
		"00_26",
		"00_27",
		"00_28",
		"00_29",
		"00_64",
		"00_65",
		"00_66",
		"00_6E",
		"00_6F",
		"00_78",
		"00_79",
		"00_7A",
		"00_96",
		"00_97",
		"00_9B",
		"00_9C",
		"00_BE",
		"00_BF",
		"00_C0",
		"00_C6",
		"00_C7",
		"00_C8",
		"00_C9",
		"00_CA",
		"00_CB",
		"00_CC",
		"00_CD",
		"00_CE",
		"00_CF",
		"00_D0",
		"00_D1",
		"00_D2",
		"00_D3",
		"00_D4",
		"00_D5",
		"00_D6",
		"00_D7",
		"00_D8",
		"00_D9",
		"00_DA",
		"00_DB",
		"00_DC",
		"00_DD",
		"00_DE",
		"00_F8",
		"00_F9",
		"00_FA",
		"00_FB",
		"00_FC",
		"00_FD",
		"00_FE",
		"00_FF",
		"01_00",
		"01_01",
		"01_02",
		"01_03",
		"01_04",
		"01_05",
		"01_06",
		"01_07",
		"01_08",
		"01_09",
		"01_0A",
		"01_0B",
		"01_0C",
		"01_0D",
		"01_0E",
		"01_0F",
		"01_10",
		"01_11",
		"01_12",
		"01_2C",
		"01_2D",
		"01_2E",
		"01_2F",
		"01_30",
		"01_31",
		"01_32",
		"01_33",
		"01_34",
		"01_35",
		"01_36",
		"01_37",
		"01_38",
		"01_39",
		"01_3A",
		"01_3B",
		"01_3C",
		"01_3D",
		"01_3E",
		"01_3F",
		"02_BC",
		"02_BD",
		"02_C6",
		"02_C7",
		"03_21",
		"03_22",
		"03_23",
		"03_24",
		"03_25",
		"03_26",
		"03_27",
		"03_28",
		"03_2B",
		"03_2C",
		"03_2D",
		"03_2E",
		"03_2F",
		"03_30",
		"03_31",
		"03_32",
		//12F指令
		"00_01",
		"00_02",
		"00_0B",
		"00_0C",
		"00_0D",
		"00_0E",
		"00_0F",
		"00_10",
		"00_11",
		"00_15",
		"00_16",
		"00_17",
		"00_18",
		"00_19",
		"00_64",
		"00_65",
		"00_66",
		"00_6E",
		"00_6F",
		"00_78",
		"00_79",
		"00_7A",
		
		"00_C8",
		"00_C9",
		"00_CA",
		"00_CB",
		"00_CC",
		"00_CD",
		"00_CE",
		"00_CF",
		"00_D0",
		"00_D1",
		"00_D2",
		"00_D3",
		"00_D4",
		"00_D5",
		"00_D6",
		"00_D7",
		"00_D8",
		"00_D9",
		"00_DA",
		"00_FA",
		"00_FB",
		"00_FC",
		"02_BC",
		"02_BD",
		"01_13"
	};
}
