package com.zzst.model.enums;

public class LevelEnum {
	public static final String LEVEL_USER = "z_t_user";//levelType
	public static final String LEVEL_ROOM = "z_t_meetingroom";
	
	public static final int STATUS_LEVEL_INVALID = 0;//无效
	public static final int STATUS_LEVEL_VALID = 1;//有效
	
	public static final int STATUS_LEVELCONFIG_INVALID = 0;//无效
	public static final int STATUS_LEVELCONFIG_VALID = 1;//有效
	
	public static final int LEVELCONFIG_SUPERPOWER_CLOSE = 0;//关闭向下的权限
	public static final int LEVELCONFIG_SUPERPOWER = 1;//拥有向下的权限
	
	public static final String IS_LEVEL_FATHER=DateBaseEnum.Default_ID+"-0";
}
