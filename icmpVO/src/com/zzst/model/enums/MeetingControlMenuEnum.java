package com.zzst.model.enums;

public class MeetingControlMenuEnum {
	public static final String[] PUB_NAMES = { "呼叫", "挂断", "静音", "非静音", "闭音", "取消闭音", "添加会场", "删除会场", "设置双流权限", "取消双流权限",
		"设为演讲者", "设为发言人", "视频屏蔽", "取消视频屏蔽", "结束会议", "广播模式-开始轮训", "广播模式-结束轮训", "设为个人模式", "个人模式-开始轮训", "个人模式-结束轮训" };
public static final String[] PUB_IDS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
		"19"};

public static final String[] ZHUANYUANBAN_NAMES = {"",""};
public static final String[] ZHUANYUANBAN_IDS = {"",""};

public static void main(String[] args){
	System.out.println(getPubMenuList().length);
}

/**
 * 提取公共按钮的方法
 * @author ryan
 * @return String[][]
 */
public static String[][] getPubMenuList(){
	String[][] s = new String[PUB_NAMES.length][2];
	for(int i=0;i<PUB_NAMES.length;i++){	
		s[i][0] =	PUB_IDS[i]+"";
		s[i][1] =	PUB_NAMES[i]+"";
	}
	return s;
}

/**
 * 提取项目按钮
 * @author ryan
 * @return String[][]
 */
public static String[][] getProjectMenuList(){
	String[][] s = new String[1][2];
	s[0][0] =	ZHUANYUANBAN_NAMES[0]+"";
	s[0][1] =	ZHUANYUANBAN_IDS[1]+"";	
	
	
	return s;
}
}
