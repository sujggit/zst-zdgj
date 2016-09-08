package com.zzst.model.enums;


/**
 *@Description
 *@date 2011-12-2上午11:07:38
 *@author ryan
 */
public class MeetingDetailEnum {

	public 	static final int	mainVenue_invalid		=	1; //分会场
	public 	static final int	mainVenue_valid			=	0; //主会场

	
	//录播
	public static final int REACH_INVALID=0;//0为不启用
	public static final int REACH_VALID=1;//1为启用
	
	public static final int TYPE_GENERAL=MeetingTypeEnum.HOST_MEETING_NEW;
	public static final String TYPE_GENERAL_NAME="本地会议";
	public static final int TYPE_VEDIO=MeetingTypeEnum.PLOYCOM_MEETING_NEW;
	public static final String TYPE_VEDIO_NAME="视频会议";
	public static final int TYPE_VEDIO_DEBUG=3;
	public static final String TYPE_VEDIO_DEBUG_NAME="调试视频会议";

	//info1 标签
	public static final String TYPE_NOTICE_LJZK="立即召开";
	public static final String TYPE_NOTICE_GJMB="高级模板";
	public static final String TYPE_NOTICE_PTMB="普通模板";
	public static final String TYPE_NOTICE_DEBUG="调试会议";
	
	//templateType标签
	public static final int TYPE_TEMPLATETYPE_GJMB=1;//高级模板
	public static final int TYPE_TEMPLATETYPE_PUMB=0;//普通模板
	public static final int TYPE_TEMPLATETYPE_DEF=-1;//非模板建会
	
	//会议状态
	public static final int STATUS_INVALID=MeetingStatus.INVALID;
	public static final String STATUS_INVALID_NAME ="无效";
	public static final	int STATUS_APPROVED=MeetingStatus.TO_BE_APPROVED;
	public static final String STATUS_APPROVED_NAME ="待审批";
	public static final int STATUS_APPROVED_PASS=MeetingStatus.APPROVED;
	public static final String STATUS_APPROVED_PASS_NAME ="预约成功";
	public static final int STATUS_END=MeetingStatus.END;
	public static final String STATUS_END_NAME ="会议结束";
	public static final int STATUS_TEMPLATE=MeetingStatus.TEMPLATE;
	public static final String STATUS_TEMPLATE_NAME ="模板标识";
	public static final int STATUS_ING=MeetingStatus.BE_ATTENDING;
	public static final String STATUS_ING_NAME ="会议中";
	public static final int STATUS_FAILURE=7;
	public static final String STATUS_FAILURE_NAME ="建会失败";
	
//	public static final int STATUS_DOCUMENTED=MeetingStatus.DOCUMENTED;//归档
//	public static final int STATUS_SAVED=MeetingStatus.SAVED;//保存待发
	public static final int STATUS_APPLYING = MeetingStatus.APPLYING;//审批中
	public static final String STATUS_APPLYING_NAME ="审批中";
	public static final	int STATUS_NOAPPROVED = MeetingStatus.NOAPPROVED;
	public static final String STATUS_NOAPPROVED_NAME ="审批不通过";
	public static final	int STATUS_APPROVEDREVOKE = MeetingStatus.APPROVEDREVOKE;
	public static final String STATUS_APPROVEDREVOKE_NAME ="审批被撤销";
	
//	/**
//	 * 配置为支持审批时，调用此方法
//	 * @return
//	 */
////	public static void startUsingApproved(){
////		//启用该功能时，需调整插入数据时的状态、及查询是的控制
////		STATUS_APPROVED = MeetingStatus.TO_BE_APPROVED;
////	}
	
	
	/**
	 * 提取mcu上的会议模板列表
	 * @return
	 */
//	public static String[][] getMcuConferenProfiles(){
//		String[][] profiles = new String[2][2];
//		profiles[0][0] = "0";
//		profiles[0][1] = "1024会议";
//		
//		profiles[1][0] = "1";
//		profiles[1][1] = "2048会议";
//		return profiles;
//	}
	
	/**
	 * 提取会议类型
	 * @return
	 */
	public static String[][] getMeetingType(){
		String[][] type = new String[2][2];
		type[0][0] = TYPE_GENERAL+"";
		type[0][1] = TYPE_GENERAL_NAME;
		type[1][0] = TYPE_VEDIO+"";
		type[1][1] = TYPE_VEDIO_NAME;
		return type;
	}
	
	/**
	 * 提取会议状态
	 * @return
	 */
	public static String[][] getMeetingStatus(){
		String[][] status = new String[3][2];
		status[0][0] = STATUS_APPROVED_PASS+"";
		status[0][1] = STATUS_APPROVED_PASS_NAME;
		status[1][0] = STATUS_END+"";
		status[1][1] = STATUS_END_NAME;
		status[2][0] = STATUS_ING+"";
		status[2][1] = STATUS_ING_NAME;
		return status;
	}
	
}
