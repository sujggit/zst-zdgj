package com.zzst.model.enums;

public class ApplyEnum {
	public static final int		STATUS_USE			=	0;		//流程启用
	public static final int		STATUS_STOPUSE		=	1;		//流程停用
	public static final int		STATUS_NOFLOWNODE	=	2;		//流程启用，但是没有流程节点
	
	public static final int		ORDERNUM_START		=	1;		//开始节点,即申请人开始发起申请，下一个审批人是2，以此类推
	public static final int		ORDERNUM_END		=	999;	//结束节点
	
	public static final int		CHECKTYPE_PERSON	=	0;		//处理类型——人员
	public static final int		CHECKTYPE_POST		=	1;		//处理类型——岗位
	
	public static final String	CHECKRULE_DEFAULT	=	"none";		//处理规则——默认是无，即普通节点
	public static final String	CHECKRULE_SECRET	=	"secret";	//处理规则——是否涉密
	public static final String	CHECKRULE_GROUP		=	"group";	//处理规则——是否需要集团签字
	
	public static final int		SECURITY_LEVEL1		=	0;		//安全秘密等级：普通
	public static final int		SECURITY_LEVEL2		=	1;		//安全秘密等级：秘密
	public static final int		SECURITY_LEVEL3		=	2;		//安全秘密等级：机密
	
	public static final int 	STATUS_VALID		=	0;		//正常 申请时表示待审批
	public static final int 	STATUS_INVALID		=	1;		// 审批结束
	public static final int 	STATUS_ING          =   2; 		//申请中使用表示审批中
	public static final int 	STATUS_REJECT 		=   3; 		//申請被拒絕
	public static final int 	STATUS_NONE 		=   4; 		//无需审批
	public static final int 	STATUS_REVOKE 		=   5; 		//审批被撤销
	
	public static final int     APPLYFLOWTYPE_1     =   0;      //并行
	public static final int     APPLYFLOWTYPE_2     =   1;      //串行
	
	//节点标识
	public static final int     FIRST_FLOW     =   0;     //开始节点
	public static final int     END_FLOW       =   1;     //最后节点
	public static final int     OTHER_FLOW     =   2;     //非开始节点和最后节点
	
	//流程类型
	public static final int     ZH_VIDEO_CONFERENCE   =   0;//中航视频会议
	public static final int     ZH_VIDEO_SYS          =   1;//中航系统接入
	public static final int     ZH_VIDEO_EXPORT       =   2;//中航文件导出
	public static final int     ZH_FEEDBACK           =   3;//中航问题反馈
	public static final int 	ZH_SERVICE	   		  =   4;//中航服務
	public static final int 	VIDEO_CONFERENCE	  =   5;//视频会议预约
	public static final int 	CONFERENCE_BOOK	  =   6;//视频会议预约
	
	public static final int 	APPLY_CONFERENCE      = 0 ;//视频会议申请
	public static final int     SYS_INSERT            = 1 ;//系统接入申请
	
	public static final String 	APPLY_START_POINT     = "-1";//申请时记录开始节点标示
	
	public static final int     NAT_YES       = 1;//nat转换-是
	public static final int     NAT_NO        = 0;//nat转换-否
	
	public static final String	ZH_appID	= "ICMP";//待办事项信息紧急程度，越小越紧急,0:特急 1:紧急 2:一般,缺省2
	public static final String	ZH_priorityID	= "2";//待办事项信息紧急程度，越小越紧急,0:特急 1:紧急 2:一般,缺省2
	/**
	 * 提取审批流程状态
	 * @return
	 */
	public static String[][] getApplyStatus(){
		String[][] s = new String[6][2];
		s[0][0] =   STATUS_VALID+"";
		s[0][1] =	"待审批";
		s[1][0] =	STATUS_INVALID+"";
		s[1][1] =	"审批通过";
		s[2][0] =	STATUS_ING+"";
		s[2][1] =	"审批中";
		s[3][0] =	STATUS_REJECT+"";
		s[3][1] =	"审批不通过";
		s[4][0] =	STATUS_REVOKE+"";
		s[4][1] =	"审批被撤销";
		s[5][0] =	STATUS_NONE+"";
		s[5][1] =	"无需审批";
		return s;
	}
	
	/**
	 * 提取审批方式
	 */
	public static String[][] getApplyFlowType(){
		String[][] s = new String[2][2];
		s[0][0] =   APPLYFLOWTYPE_1+"";
		s[0][1] =	"并行";
		s[1][0] =	APPLYFLOWTYPE_2+"";
		s[1][1] =	"串行";
		return s;
	}
	
	/**
	 * 提取是否是最后节点
	 */
	public static String[][] isEndFlow(){
		String[][] s = new String[3][2];
		s[0][0] =   FIRST_FLOW+"";
		s[0][1] =	"开始节点";
		s[1][0] =	END_FLOW+"";
		s[1][1] =	"最后节点";
		s[2][0] =   OTHER_FLOW + "";
		s[2][1] =   "一般节点";
		return s;
	}
	
	public static String[][] flowType(){
		String[][] s = new String[7][2];
		s[0][0] =   ZH_VIDEO_CONFERENCE+"";
		s[0][1] =	"视频会议申请";
		s[1][0] =	ZH_VIDEO_SYS +"";
		s[1][1] =	"视频会议系统接入申请";
		s[2][0] =	ZH_VIDEO_EXPORT +"";
		s[2][1] =	"视频会议录像文件导出申请";
		s[3][0] =	ZH_FEEDBACK +"";
		s[3][1] =	"视频会议系统问题反馈";
		s[4][0] =   ZH_SERVICE +"";
		s[4][1] =   "视频会议服务情况";
		s[5][0] =   VIDEO_CONFERENCE+"";
		s[5][1] =	"视频会议预约申请";
		s[6][0] =   CONFERENCE_BOOK+"";
		s[6][1] =	"本地会议预约申请";
		return s;
	}
	
	//nat状态
	public static String[][] natStatus(){
		String[][] s = new String[2][2];
		s[0][0] =   NAT_YES+"";
		s[0][1] =	"是";
		s[1][0] =	NAT_NO +"";
		s[1][1] =	"否";
		return s;
	}
}