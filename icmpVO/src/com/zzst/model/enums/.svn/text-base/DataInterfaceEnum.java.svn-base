package com.zzst.model.enums;

public class DataInterfaceEnum {
	public static final int 	NOT_IMPORT		=	0;		//未导入
	public static final int 	IMPORT_SUCCESS		=	1;		// 导入成功
	public static final int 	IMNPORT_FAILURE          =   2; 		//导入失败
	
	public static final int     UPDATE_TYPE = 1;//更新操作
	public static final int     ADD_TYPE = 2;//添加操作
	
	public static final int     PORT_DEFAULT = 24;//默认端口号
	public static final String     PSW_DEFAULT = "123456";//默认密码
	
	
	/**
	 * 提取数据操作状态
	 * @return
	 */
	public static String[][] getDataInterfaceStatus(){
		String[][] s = new String[3][3];
		s[0][0] =   NOT_IMPORT+"";
		s[0][1] =	"未同步";
		s[1][0] =	IMPORT_SUCCESS+"";
		s[1][1] =	"同步成功";
		s[2][0] =	IMNPORT_FAILURE+"";
		s[2][1] =	"同步失败";
		return s;
	}
}
