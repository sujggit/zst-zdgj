package com.zzst.model.enums;


/**
 *@Description	中控基础数据枚举
 *@date 2012-6-28下午03:30:29
 *@author ryan
 */
public class CenterControlEnum {
	
	public static final String 	type_camera_id	=	"camera";
	public static final String 	type_camera_name	=	"摄像头";
	
	public static final String 	type_audio_id	=	"audio";
	public static final String 	type_audio_name	=	"音频";
	
	public static final String 	type_light_id	=	"light";
	public static final String 	type_light_name	=	"灯光";
	
	public static final String 	type_pla_id	=	"pla";
	public static final String 	type_pla_name	=	"电视盒";

	public static final String 	type_screent_id	=	"screent";
	public static final String 	type_screent_name	=	"大屏";
	
	public static final String 	type_screentView_id	=	"screent_view";
	public static final String 	type_screentView_name	=	"大屏模式";
	
	public static final String 	type_sysPower_id	=	"sysPower";
	public static final String 	type_sysPower_name	=	"系统电源";
	
	public static final String 	type_upDownScreen_id	=	"upDownScreen";
	public static final String 	type_upDownScreen_name	=	"升降屏";
	
	public static final String 	type_vedioTerminal_id	=	"vedioTerminal";
	public static final String 	type_vedioTerminal_name	=	"视频终端";
	
	public static final String 	type_matrix_id	=	"matrix";
	public static final String 	type_matrix_name	=	"矩阵";
	
	public static final String 	type_dvd_id	=	"dvd";//配置邮件信息类型
	public static final String 	type_dvd_name = "DVD";
	
	public static final String 	type_curtain_id	=	"curtain";//配置邮件信息类型
	public static final String 	type_curtain_name = "窗帘";
	
	public static final String 	type_proj_id	=	"proj";//配置邮件信息类型
	public static final String 	type_proj_name = "投影仪";
	
	public static final String 	type_videom_id	=	"videom";//配置邮件信息类型
	public static final String 	type_videom_name = "画面分割器";
	
	public static final String type_roomModel_id = "roomModel";//会议室组合键1-本地回忆;2-视频会议
	public static final String 	type_roomModel_name = "会议模式";
	
	public static String[][] getEquipmentType(){
		String[][] type = new String[15][2];
		type[0][0] = type_matrix_id;
		type[0][1] = type_matrix_name;
		type[1][0] = type_audio_id;
		type[1][1] = type_audio_name;
		type[2][0] = type_light_id;
		type[2][1] = type_light_name;
		type[3][0] = type_pla_id;
		type[3][1] = type_pla_name;
		//type[4][0] = type_screent_id;
		//type[4][1] = type_screent_name;
		type[4][0] = type_camera_id;
		type[4][1] = type_camera_name;
		type[5][0] = type_sysPower_id;
		type[5][1] = type_sysPower_name;
		type[6][0] = type_upDownScreen_id;
		type[6][1] = type_upDownScreen_name;
		type[7][0] = type_vedioTerminal_id;
		type[7][1] = type_vedioTerminal_name;
		type[8][0] = type_screent_id;
		type[8][1] = type_screent_name;
		type[9][0] = type_dvd_id;
		type[9][1] = type_dvd_name;
		type[10][0] = type_curtain_id;
		type[10][1] = type_curtain_name;
		type[11][0] = type_proj_id;
		type[11][1] = type_proj_name;
		type[12][0] = type_videom_id;
		type[12][1] = type_videom_name;
		type[13][0] = type_roomModel_id;
		type[13][1] = type_roomModel_name;
		type[14][0] = type_screentView_id;
		type[14][1] = type_screentView_name;
		return type;
	}
}
