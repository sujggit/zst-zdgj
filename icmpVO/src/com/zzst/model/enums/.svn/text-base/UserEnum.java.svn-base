package com.zzst.model.enums;

import java.io.Serializable;

public class UserEnum implements Serializable{

	 	private static final long serialVersionUID = 1L;
	 	public static final String USER_SESSION_ID="user_session";
	 	public static final String USER_FUNC_SESSION_ID="user_func";
	 	
	 	public static final int 	INVALID	=	0;		//失效
		public static final int 	VALID	=	1;		//有效
		public static final int 	lock	=	2;		//锁定
		
		public static final String SUPER_ADMIN = "admin";  //超级管理员
		public static final String CINDA_SUPERROLE_ID="3";
	 	public static final int 	INTERNAL_AUTHENTICATE	=	0;		//内部认证
		public static final int 	CENTRAL_AUTHENTICATE	=	1;		//集中认证
		
		/** 
		 * 提取状态信息
		 * @return	Stirng[][]
		 */
		public static String[][] getUserStatus(){
			String[][] status = new String[3][2];
			status[0][0] = INVALID+"";
			status[0][1] = "失效";
			status[1][0] = VALID+"";
			status[1][1] = "有效";
			status[2][0] = lock+"";
			status[2][1] = "锁定";
			return status;
		}
		
}
