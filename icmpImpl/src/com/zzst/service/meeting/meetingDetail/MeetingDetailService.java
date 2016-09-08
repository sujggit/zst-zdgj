package com.zzst.service.meeting.meetingDetail;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cbf.db.PageController;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.user.UserVO;
import com.zzst.model.meeting.videoconference.VideoconferenceVO;

/**
 * class description: MeetingDetail Service
 * 
 * @author ryan
 * @date Mon Aug 17 15:16:09 CST 2009
 */

public interface MeetingDetailService {

	/**
	 * 提取开始时间或者结束时间已经超过当前时间的列表add by ryan on 2012-04-13
	 * @param vMeetingDetailVO
	 * @param PageController
	 * @returnArrayList<MeetingDetailVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailVO> queryPastSysTime(PageController mPageController) throws Exception;
		
	
	/**
	 * 会议总览专用 add by ryan on 2012-04-13
	 * @param vMeetingDetailVO
	 * @param PageController
	 * @returnArrayList<MeetingDetailVO>
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailVO> queryForPandect(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws Exception;
		
	/**
	 * 本地会议预定add by ryan on 2011-12-02
	 * modify by ryan on 2012-04-20   增加预订部门功能
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @String departIDs     以“,”分割
	 * @return
	 */
	public MeetingDetailVO addGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList,String departIDs) ;
	
	public MeetingDetailVO addGeneralMeetingDetailThread(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList,String departIDs) ;
	/**
	 * 视频会议预定add by ryan on 2011-12-02
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @return
	 */
	public MeetingDetailVO addVedioMeetingDetail(MeetingDetailVO vMeetingDetailVO,String[] userList,String[] roomList) ;
	
	public MeetingDetailVO addVedioMeetingDetail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList) ;
	
	/**
	 * 添加会议明细：包括模板、备用信息等  wangle 2013-8-22
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @return
	 */
	public MeetingDetailVO addMeetingDetail(MeetingDetailVO vMeetingDetailVO)  throws Exception ;
	/**
	 * 提取会议明细：包括模板、备用信息等  wangle 2013-8-22
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public  ArrayList<MeetingDetailVO> queryMeetingDetailList2(MeetingDetailVO vMeetingDetailVO, PageController mPageController) throws SQLException;
	
	
	/**
	 * 本地会议修改add by ryan on 2011-12-02
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @String departIDs  以","分割
	 * @return
	 */
	public MeetingDetailVO modifyGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList,String departIDs);
	
	/**
	 * 视频会议修改add by ryan on 2012-0420
	 * 主会场必须在meetingDetailVO.getMeetingRoomID()内
	 * @param vMeetingDetailVO
	 * @param userList
	 * @param roomList
	 * @String departIDs  以","分割
	 * @return
	 */
	public MeetingDetailVO modifyVedioMeetingDetail(MeetingDetailVO vMeetingDetailVO,String[] userList,String[] roomList);
	
	public MeetingDetailVO modifyVedioMeetingDetail(MeetingDetailVO vMeetingDetailVO,ArrayList<UserVO> userList,ArrayList<VideoconferenceVO> roomList);
	/**
	 * method description : modify MeetingDetail state by id
	 * 
	 * @param MeetingDetailVO
	 * @return MeetingDetailVO
	 * @throws SQLException
	 */
	public MeetingDetailVO delMeetingDetail(
			MeetingDetailVO vMeetingDetailVO)
			throws SQLException;
	
	/**
	 * 根据id修改状态
	 * @param vMeetingDetailVO
	 * @return
	 * @throws SQLException
	 */
	 MeetingDetailVO ModifyMeetingDetailForState(
				MeetingDetailVO vMeetingDetailVO)throws SQLException;
		/**
		 * 根据id修改参会人数
		 * @param vMeetingDetailVO
		 * @return
		 * @throws SQLException
		 */
		 MeetingDetailVO ModifyMeetingDetailForInfo2(MeetingDetailVO vMeetingDetailVO)throws SQLException;
	 
	 /**
	  * 
	  * @param vMeetingDetailVO
	  * @return
	  */
	 public MeetingDetailVO modifyGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO);
	
		/**
		 * method description : getMeetingDetailList
		 * 
		 * @param MeetingDetailVO
		 * @return ArrayList<MeetingDetailVO>
		 * @throws SQLException
		 * 我的会议本地会议查看wangyulong
		 */
		public ArrayList<MeetingDetailVO> getMeetingDetailList(MeetingDetailVO vMeetingDetailVO, PageController mPageController)throws SQLException;
		
		/**
		 * 查询会议状态列表
		 * @param vMeetingDetailVO
		 * @param mPageController
		 * @return ArrayList<MeetingDetailVO>
		 * @throws SQLException
		 */
		public  ArrayList<MeetingDetailVO> getMeetingDetailstatusList(MeetingDetailVO vMeetingDetailVO, PageController mPageController)
				throws SQLException;
		/**
		 * get meetingdetail list according to some statuses
		 * @param vMeetingDetailVO
		 * @param statusArray
		 * @param mPageController
		 * @return
		 * @throws SQLException
		 */
//		public ArrayList<MeetingDetailVO> getMeetingDetailList(
//				MeetingDetailVO vMeetingDetailVO, String[] statusArray, PageController mPageController) throws SQLException;
		
	 
	 
	 
	 
	 
	///////////////////以下方法需要验证---------------------
	   
//	/**
//	 * 取我参加过的会议
//	 * @param vMeetingDetailVO
//	 * @param mPageController
//	 * @return ArrayList<MeetingDetailVO>
//	 * @throws SQLException
//	 */
//	public  ArrayList<MeetingDetailVO> getOldMeetingDetailListByUserID(
//			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
//			throws SQLException;
//	
//	/**
//	 * 取用户的预定列表
//	 * @param vMeetingDetailVO
//	 * @param mPageController
//	 * @return ArrayList<MeetingDetailVO>
//	 * @throws SQLException
//	 */
//	public ArrayList<MeetingDetailVO> getMeetingDetailAndAssignListByUserID(
//			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
//			throws SQLException;
//	
	/**
	 * 取现在正在开的会议
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public  ArrayList<MeetingDetailVO> getMeetingListForToday(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException;
	
	/**
	 * 提取会议及相关会议室信息
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public  ArrayList<MeetingDetailVO> query(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException;
	/**
	 * 中电国际 通过会议名称，会议开始结束时间得到 会议ID
	 * @param vMeetingDetailVO
	 * @return
	 */
	public String query(MeetingDetailVO vMeetingDetailVO); 
	/**
	 * 提取会议及相关会议室信息
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return MeetingDetailVO
	 * @throws SQLException
	 */
	public  MeetingDetailVO queryByID(String id)
			throws SQLException;
	
	/**
	 * 提取会议及相关部门信息
	 * @param vMeetingDetailVO
	 * @param mPageController
	 * @return ArrayList<MeetingDetailVO>
	 * @throws SQLException
	 */
	public  ArrayList<MeetingDetailVO> queryForDepartment(
			MeetingDetailVO vMeetingDetailVO, PageController mPageController)
			throws SQLException;
	/**
	 * 审批会议
	 * @param vMeetingDetailVO
	 * @return MeetingDetailVO
	 */
	public MeetingDetailVO examGeneralMeetingDetail(MeetingDetailVO vMeetingDetailVO); 
	
	public ArrayList<MeetingDetailVO> queryWithMeetingDebug(MeetingDetailVO vMeetingDetailVO,PageController mPageController) throws SQLException;


	/**
	 * 获取有效的(含会议资料)会议详情列表
	 * @param meetingDetailVO
	 * @param mPageController
	 * @return
	 * @throws SQLException
	 */
	public List<MeetingDetailVO> getMeetingDetailAndFileList(
			MeetingDetailVO meetingDetailVO, PageController mPageController) throws SQLException;


	/**
	 * 会议预约审批列表
	 * @param meetingDetailVO
	 * @param loginUser
	 * @param pControler
	 * @return
	 * @throws SQLException
	 */
	public List<MeetingDetailVO> getMeetingDetailApplyList(
			MeetingDetailVO meetingDetailVO, UserVO loginUser,
			PageController pControler) throws SQLException;
	
	public List<MeetingDetailVO> getMeetingDetailByTimeAndName(
			MeetingDetailVO meetingDetailVO, Timestamp time) throws SQLException;
	
	/**
	 * 查询会议占用情况，年、月、日（会议室日历）
	 * @param meetingDetailVO
	 * @param pageController
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailVO> queryMeetingOccupy(MeetingDetailVO meetingDetailVO,
			PageController pageController) throws Exception;
	/**
	 * 根据查询此时间段的会议
	 * @param meetingStartTime
	 * @param meetingEndTime
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MeetingDetailVO> queryNextWeekMeeting(Timestamp meetingStartTime,
			Timestamp meetingEndTime) throws Exception;
}
