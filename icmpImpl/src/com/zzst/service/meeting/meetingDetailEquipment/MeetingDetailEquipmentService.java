package com.zzst.service.meeting.meetingDetailEquipment;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.cbf.db.PageController;
import com.cbf.db.TransactionManager;
import com.zzst.model.meeting.meetingDetailEquipment.MeetingDetailEquipmentVO;

/**
 * class description: MeetingDetailEquipment Service
 * 
 * @date Mon Dec 17 11:09:48 CST 2012
 * @author ryan
 */
public interface MeetingDetailEquipmentService {
	/**
	 * method description : add MeetingDetailEquipmentVO	object
	 * @param MeetingDetailEquipmentVO
	 * @return MeetingDetailEquipmentVO
	 * @throws Exception
	 */
	public MeetingDetailEquipmentVO add(MeetingDetailEquipmentVO meetingDetailEquipmentVO, TransactionManager tManager) throws Exception;

	/**
	 * 查询在时间段内视频会议使用的设备
	 * @param MeetingDetailEquipmentVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailEquipmentVO>
	 * @throws Exception
	 */
	public  ArrayList<MeetingDetailEquipmentVO> queryUseEquipmentList(Timestamp startTime,Timestamp endTime,PageController pageController) throws Exception;

	/**
	 * method description : query	MeetingDetailEquipment	list
	 * 注意：
	 * 查询当前表状态不为失效的数据，如果包含关联查询不过滤其状态。如：关联用户信息，不管用户是否正常都需要查询出该数据。
	 * 需要把关联信息的状态带到前台
	 * @param MeetingDetailEquipmentVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailEquipmentVO>
	 * @throws Exception
	 */
	public  ArrayList<MeetingDetailEquipmentVO> query(MeetingDetailEquipmentVO meetingDetailEquipmentVO,PageController pageController) throws Exception;

	/**
	 * method description : query	MeetingDetailEquipmentVO	by	id
	 * @param id
	 * @return MeetingDetailEquipmentVO
	 * @throws Exception
	 */
	public  MeetingDetailEquipmentVO queryByID(String id) throws Exception;

	/**
	 * method description : query	MeetingDetailEquipmentVO	by	ids
	 * @param String example: 1,2,3,4
	 * @return MeetingDetailEquipmentVO
	 * @throws Exception
	 */
	public   ArrayList<MeetingDetailEquipmentVO> queryByIDs(String ids) throws Exception;

	/**
	 * method description :modify	MeetingDetailEquipmentVO	by id
	 * @param MeetingDetailEquipmentVO
	 * @return MeetingDetailEquipmentVO
	 * @throws Exception
	 */
	public MeetingDetailEquipmentVO modify(MeetingDetailEquipmentVO meetingDetailEquipmentVO )throws Exception;


	/**
	 * method description : delete MeetingDetailEquipmentVO by	id
	 * @param String	
	 * @return boolean
	 * @throws Exception
	 */
	public boolean deleteByID(String id )throws Exception;

	/**
	 * method description : delete MeetingDetailEquipmentVO by	ids
	 * @param String example: 1,2,3,4
	 * @return int
	 * @throws Exception
	 */
	public void deleteByIDs(String id )throws Exception;

	/**
	 * method description : query	MeetingDetailEquipment	list
	 * 注意：
	 * 全表模糊查询，效率差，谨慎使用。
	 * @param MeetingDetailEquipmentVO
	 * @param PageController
	 * @return ArrayList<MeetingDetailEquipmentVO>
	 * @throws Exception
	 */
	public  ArrayList<MeetingDetailEquipmentVO> queryFuzzySearch(String str,PageController pageController) throws Exception;

	public  ArrayList<MeetingDetailEquipmentVO> queryMeeting(MeetingDetailEquipmentVO meetingDetailEquipmentVO,PageController pageController) throws Exception;
}
