package com.zzst.model.enums;


/**
 *@Description
 *@date 2012-11-30下午02:28:37
 *@author ryan
 */
public class McuCascademodelEnum {
	public static final int 	INVALID		=	0;		//失效
	public static final int 	VALID		=	1;		//有效
	public static final int     STATUS_BACK         = -999;//mcu备份关联关系专用
	public static final int   PERSONAL_MODEL = 1; //个人模式： 主会个人模式+从会个人模式
	public static final int   SAME_SCREEN_MODEL = 2;//相同分屏模式: 主会相同分屏 + 从会演讲者
	public static final int   LECTURE_MODEL = 3;//演讲者模式: 主会演讲者 + 从会演讲者
	
	
	public static String[][] getConfModel(){
		String[][] type = new String[3][2];
		type[0][0] = PERSONAL_MODEL+"";
		type[0][1] = "个人模式";
		type[1][0] = SAME_SCREEN_MODEL+"";
		type[1][1] = "相同分屏模式";
		type[2][0] = LECTURE_MODEL+"";
		type[2][1] = "演讲者模式";
		
		return type;
	}
}
