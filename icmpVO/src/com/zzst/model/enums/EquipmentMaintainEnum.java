package com.zzst.model.enums;


/**
 *@Description
 *@date 2013-5-6下午02:04:16
 *@author ryan
 */
public class EquipmentMaintainEnum {
	//1、正常 5、待修6、报废
	public static final int 	STATUS_VALID		=	EquipmentEnum.STATUS_VALID;		//正常
	public static final int 	STATUS_INVALID		=	EquipmentEnum.STATUS_INVALID;		//失效
	public static final int 	STATUS_TODOREPAIRED	=	EquipmentEnum.STATUS_TODOREPAIRED;		//待修
	public static final int 	STATUS_USELESS		=	EquipmentEnum.STATUS_USELESS;		//报废
	
	/**
	 * 提取维护信息状态
	 * @return
	 */
	public static String[][] getEquipmentMaintainStatus(){
		String[][] s = new String[3][2];
		s[0][0] =   STATUS_VALID+"";
		s[0][1] =	"正常";
		s[1][0] =	STATUS_TODOREPAIRED+"";
		s[1][1] =	"待修";
		s[2][0] =   STATUS_USELESS+"";
		s[2][1] =	"报废";
		
		return s;
	}
}
