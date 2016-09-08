package com.zzst.model.enums;

public class MeetingStatus {
	private static final long serialVersionUID = 1L;
	
	public static final int TO_BE_APPROVED=0;//待审批
	
	public static final int APPROVED=1;//审批通过
	
	public static final int BE_ATTENDING=2;//进行中
	
	public static final int END=3;//会议结束
	
	public static final int BOOkMEETING_SUCCESS=4;//会议预约成功； add by tanzanlong time：2013-3-6
	
	public static final int DOCUMENTED=5;//归档
	
	public static final int SAVED=6;//保存待发
	
	public static final int INVALID = 11; //无效状态 会议取消
	
	public static final int TEMPLATE = 12; //模板标识
	public static final int APPLYING = 13;//审批中
	public static final int NOAPPROVED = 14;//审批不通过
	public static final int APPROVEDREVOKE = 15;//审批被撤销
    public static final String[] descs = {"待审批","会议预约成功","进行中","会议结束","审批通过","归档","保存待发","无效状态","模板标识","审批中","审批不通过","审批被撤销"};

    
    
    public static String getDesc(int index)
    {
       return descs[index];  
    }
    

	/**add by chenshuo 2012 8-22
	 * 数据字典模块使用
	 * 提取所有会议状态
	 * @return
	 */
	public static String[][] getMeetingStatus(){
		String[][] s = new String[11][2];
		s[0][0] =	TO_BE_APPROVED + "";
		s[0][1] =	descs[0];
		s[1][0] =	APPROVED + "";
		s[1][1] =	descs[1];
		s[2][0] =	BE_ATTENDING + "";
		s[2][1] =	descs[2];
		s[3][0] =	END + "";
		s[3][1] =	descs[3];
		s[4][0] =	DOCUMENTED + "";
		s[4][1] =	descs[4];
		s[5][0] =	SAVED + "";
		s[5][1] =	descs[5];
		s[6][0] =	INVALID + "";
		s[6][1] =	descs[6];
		s[7][0] =	TEMPLATE + "";
		s[7][1] =	descs[7];
		s[8][0] =	BOOkMEETING_SUCCESS + "";
		s[8][1] =	descs[8];	
		s[9][0] =	NOAPPROVED + "";
		s[9][1] =	descs[9];
		s[10][0] =	APPROVEDREVOKE + "";
		s[10][1] =	descs[10];
		return s;
	}
}
