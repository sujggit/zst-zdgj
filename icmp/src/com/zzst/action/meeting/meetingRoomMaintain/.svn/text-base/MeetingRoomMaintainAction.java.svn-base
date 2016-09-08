package com.zzst.action.meeting.meetingRoomMaintain;


import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.cbf.web.util.PageSplittor;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.cbfImpl.util.BaseAction;
import com.zzst.model.enums.MeetingRoomMaintain;
import com.zzst.model.enums.UserEnum;
import com.zzst.model.meeting.address.AddressVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.meeting.meetingRoomMaintain.MeetingRoomMaintainVO;
import com.zzst.model.meeting.meetingRoomMaintainDetail.MeetingRoomMaintainDetailVO;
import com.zzst.model.meeting.user.UserVO;




public class MeetingRoomMaintainAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    private static Logger logger = CbfLogger.getLogger(MeetingRoomMaintainAction.class.getName());
	private UserVO userVO = new UserVO();
	private	MeetingRoomMaintainVO	meetingRoomMaintainVO = new MeetingRoomMaintainVO();
	private	MeetingRoomMaintainDetailVO	meetingRoomMaintainDetailVO = new MeetingRoomMaintainDetailVO();
	private MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
//	private InputStream  excelStream;
	private ArrayList<MeetingRoomMaintainVO> meetingRoomMaintainVOList = new ArrayList<MeetingRoomMaintainVO>();
	private ArrayList<MeetingRoomVO> meetingRoomVOList=new ArrayList<MeetingRoomVO>();
	private String[] strs={"","设备开机","终端连接","本地图像","本地声音","远端图像","远端声音","双流测试","设备关机","网络连接","IP电话"};
	
	
	/**
	 * 查询单位维护情况列表
	 * @return
	 */
	public String query(){
		logger.info("MeetingRoomMaintainAction	query	begin");
		PageSplittor pSplittor = PageSplittor.getPageSplittor(request);
		try{
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM);
			meetingRoomMaintainVOList=ServiceFactory.getMeetingRoomMaintainService().query(meetingRoomMaintainVO, pSplittor.getPControler());
		}catch(Exception e){
			logger.error("MeetingRoomMaintainAction	query	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomMaintainAction	query	end");
		return SUCCESS;
	}
	
	/**
	 * 根据ID查询会议室
	 * @return
	 */
	public	String	detail(){
		logger.info("MeetingRoomMaintainAction	detail	begin");
		try{
			meetingRoomMaintainVO = ServiceFactory.getMeetingRoomMaintainService().queryByID(meetingRoomMaintainVO.getMaintainID());
			meetingRoomMaintainDetailVO.setMaintainID(meetingRoomMaintainVO.getMaintainID());
			ArrayList<MeetingRoomMaintainDetailVO> list =  ServiceFactory.getMeetingRoomMaintainDetailService().query(meetingRoomMaintainDetailVO, null);
			meetingRoomMaintainVO.setMeetingRoomMaintainDetailList(list);
			
		}catch(Exception e){
			logger.error("MeetingRoomMaintainAction	detail	error:"+e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		logger.info("MeetingRoomMaintainAction	detail	end");
		return SUCCESS;
	}
	
	
	/**
	 * 添加会议室维护信息前
	 * @return
	 */
	public String	addBefore(){
		
		logger.info("MeetingRoomMaintainAction	addBefore	begin");
		try {
			meetingRoomVOList=ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("MeetingRoomMaintainAction	addBefore	end");
		return SUCCESS;
	}
	
	/**  
	 * 添加保存会议室维护信息
	 * @return
	 */
	public	String	add(){
		logger.info("MeetingRoomMaintainAction	add	begin");
		try{				
			UserVO user=(UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			meetingRoomMaintainVO.setCreateUserID(user.getUserID());
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);//默认状态，有效
			meetingRoomMaintainVO.setMaintainType(MeetingRoomMaintain.MAINTAINTYPE_ROOM);//会场~会议相关
			meetingRoomMaintainVO.setProcessStatus(MeetingRoomMaintain.PROCESSSTATUS_NO);//尚未处理
            meetingRoomMaintainVO=ServiceFactory.getMeetingRoomMaintainService().add(meetingRoomMaintainVO);
			
			String maintainID=meetingRoomMaintainVO.getMaintainID();
			for(int i=1;i<=10;i++){
				meetingRoomMaintainDetailVO=new MeetingRoomMaintainDetailVO();
				meetingRoomMaintainDetailVO.setMaintainID(maintainID);
				meetingRoomMaintainDetailVO.setMaintainName(strs[i]);
				meetingRoomMaintainDetailVO.setStatus(Integer.parseInt(request.getParameter("status"+i)));//0正常，1故障
				meetingRoomMaintainDetailVO.setQuestionDes(request.getParameter("description"+i));
				meetingRoomMaintainDetailVO.setType(i);
				ServiceFactory.getMeetingRoomMaintainDetailService().add(meetingRoomMaintainDetailVO);
//				meetingRoomMaintainDetailVO.setRevision(0);//默认为0
//				meetingRoomMaintainDetailVO.setDescription("");//
			}
		}catch(Exception e){
			logger.error("MeetingRoomMaintainAction	add	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("MeetingRoomMaintainAction	add	end");
		return SUCCESS;
	}

	/**
	 * 根据ID提取会议室信息
	 * @return
	 */
	public	String	modifyBefore(){
		logger.info("MeetingRoomMaintainAction	modifyBefore	begin");
		try{
			meetingRoomMaintainVO = ServiceFactory.getMeetingRoomMaintainService().queryByID(meetingRoomMaintainVO.getMaintainID());
			meetingRoomMaintainDetailVO.setMaintainID(meetingRoomMaintainVO.getMaintainID());
			ArrayList<MeetingRoomMaintainDetailVO> list =  ServiceFactory.getMeetingRoomMaintainDetailService().query(meetingRoomMaintainDetailVO, null);
			meetingRoomMaintainVO.setMeetingRoomMaintainDetailList(list);
		}catch(Exception e){
			logger.error("MeetingRoomMaintainAction	modifyBefore	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomMaintainAction	modifyBefore	end");
		return SUCCESS;
	}
	
	/**
	 * 根据id修改会议室信息
	 * @return
	 */
	public	String	modify(){
		logger.info("MeetingRoomMaintainAction	modify	begin");
		try{
			UserVO user=(UserVO)request.getSession().getAttribute(UserEnum.USER_SESSION_ID);
			meetingRoomMaintainVO.setCreateUserID(user.getUserID());
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_VALID);//默认状态，未删除
			meetingRoomMaintainVO.setRevision(0);//默认状态，0
			meetingRoomMaintainVO.setCreateTime(meetingRoomMaintainVO.getCreateTime());
			meetingRoomMaintainVO.setDescription(meetingRoomMaintainVO.getDescription());
			meetingRoomMaintainVO=ServiceFactory.getMeetingRoomMaintainService().modify(meetingRoomMaintainVO);
			
			String maintainID=meetingRoomMaintainVO.getMaintainID();
			int count=ServiceFactory.getMeetingRoomMaintainDetailService().deleteByMaintainID(maintainID);
//			System.out.println("删除了："+count);
//			String description=meetingRoomMaintainVO.getDescription();
			for(int i=1;i<=count;i++){
				meetingRoomMaintainDetailVO=new MeetingRoomMaintainDetailVO();
				meetingRoomMaintainDetailVO.setMaintainID(maintainID);
				meetingRoomMaintainDetailVO.setMaintainName(strs[i]);
				meetingRoomMaintainDetailVO.setStatus(Integer.parseInt(request.getParameter("status"+i)));//0正常，1故障
				meetingRoomMaintainDetailVO.setQuestionDes(request.getParameter("description"+i));
				meetingRoomMaintainDetailVO.setRevision(0);
				meetingRoomMaintainDetailVO.setType(i);
				meetingRoomMaintainDetailVO.setDescription(meetingRoomMaintainDetailVO.getDescription());
				System.out.println("status:"+request.getParameter("status"+i)+"**description:"+request.getParameter("description"+i)+"***detailID:"+meetingRoomMaintainDetailVO.getDetailID());
				ServiceFactory.getMeetingRoomMaintainDetailService().add(meetingRoomMaintainDetailVO);
			}
		}catch(Exception e){
			logger.error("MeetingRoomMaintainAction	modify	error:"+e.getMessage());
			return ERROR;
		} 
		logger.info("MeetingRoomMaintainAction	modify	end");
		return SUCCESS;
	}

	/**
	 * 根据id删除会议室信息
	 * @return
	 */
	public	String	delete(){
		logger.info("MeetingRoomMaintainAction	delete	begin");
	
		try {
			meetingRoomMaintainVO	=	ServiceFactory.getMeetingRoomMaintainService().queryByID(meetingRoomMaintainVO.getMaintainID());
			meetingRoomMaintainVO.setStatus(MeetingRoomMaintain.STATUS_INVALID);
			ServiceFactory.getMeetingRoomMaintainService().deleteByID(meetingRoomMaintainVO);
		} catch (Exception e) {
			logger.error("MeetingRoomMaintainAction	delete	error:"+e.getMessage());
			return ERROR;
		}
		logger.info("MeetingRoomMaintainAction	delete	end");
		return	SUCCESS;
	}
	/**
	 * 获取会议室地址目录
	 * @return
	 */
	/*public ArrayList<AddressVO> getRoomAdressList(){
		ArrayList<AddressVO>  list_address = new ArrayList<AddressVO>();
		try {
			list_address = ServiceFactory.getAddressService().query(new AddressVO(),null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_address;
	}*/
	public ArrayList<MeetingRoomVO>  getMeetingRoomByAddress(String addressID){
		ArrayList<MeetingRoomVO>  list_room = new ArrayList<MeetingRoomVO>();
		AddressVO advo = new AddressVO();
		MeetingRoomVO mrvo = new MeetingRoomVO();
		advo.setAddressID(addressID);
		try {
			mrvo.setAddressVO(advo);
			list_room =	ServiceFactory.getMeetingRoomService().query(mrvo, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_room;
	}

	public MeetingRoomMaintainVO getMeetingRoomMaintainVO() {
		return meetingRoomMaintainVO;
	}

	public void setMeetingRoomMaintainVO(MeetingRoomMaintainVO meetingRoomMaintainVO) {
		this.meetingRoomMaintainVO = meetingRoomMaintainVO;
	}

	public MeetingRoomMaintainDetailVO getMeetingRoomMaintainDetailVO() {
		return meetingRoomMaintainDetailVO;
	}

	public void setMeetingRoomMaintainDetailVO(
			MeetingRoomMaintainDetailVO meetingRoomMaintainDetailVO) {
		this.meetingRoomMaintainDetailVO = meetingRoomMaintainDetailVO;
	}

	public MeetingRoomVO getMeetingRoomVO() {
		return meetingRoomVO;
	}

	public void setMeetingRoomVO(MeetingRoomVO meetingRoomVO) {
		this.meetingRoomVO = meetingRoomVO;
	}

	public ArrayList<MeetingRoomMaintainVO> getMeetingRoomMaintainVOList() {
		return meetingRoomMaintainVOList;
	}

	public void setMeetingRoomMaintainVOList(
			ArrayList<MeetingRoomMaintainVO> meetingRoomMaintainVOList) {
		this.meetingRoomMaintainVOList = meetingRoomMaintainVOList;
	}

	public ArrayList<MeetingRoomVO> getMeetingRoomVOList() {
		return meetingRoomVOList;
	}

	public void setMeetingRoomVOList(ArrayList<MeetingRoomVO> meetingRoomVOList) {
		this.meetingRoomVOList = meetingRoomVOList;
	}
	
}
