package com.zzst.model.enums;

import java.io.Serializable;

public class UseStatusEnum  implements Serializable{

 	private static final long serialVersionUID = 1L;
 	
 	public static final int 	INVALID	=	0;		//淘汰
	public static final int 	VALID	=	1;		//使用
	public static final int 	MAINTAIN	=	2;		//维护
//	public static final int 	ROOM_GROUP	=	3;		//添加会议室自定义组时的标示
	
//	public static final String[]  DESCARIPTION={"淘汰","使用","维护"};

	//SLAVE MCU AND MASTER MCU
	public static final int 	SLAVE_MCU	=	0;	
	public static final int 	MASTER_MCU	=	1;		
	
	//SLASH delimiter
	public static final String SLASH_DELIMITER = "/";
	
	public static String getNameDescription(int id){
		String reString="";
		
		if(0==id){
			reString="淘汰";
		}
		if(1==id){
			reString="使用";
		}
		if(2==id){
			reString="维护";
		}
		return reString;
	}
	
}
