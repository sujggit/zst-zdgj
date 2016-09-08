package com.zzst.mcu.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zzst.mcu.service.impl.vo.ControlLoginVO;
import com.zzst.mcu.service.impl.vo.ExceptionVO;
import com.zzst.mcu.service.impl.vo.MeetingInfoVO;
import com.zzst.mcu.service.impl.vo.MeetingRoomVO;
import com.zzst.mcu.service.impl.vo.TerminalVO;
import com.zzst.util.EquipmentObject;
import com.zzst.util.ZZSTControlException;


/**
 *@Description
 *@date 2011-2-12下午01:06:41
 *@author ryan
 */
public abstract class  McuObject extends EquipmentObject{

	public static final String MCU_TYPE_500		=	"MCU_TYPE_500";
	public static final String MCU_TYPE_1000	=	"MCU_TYPE_1000";
	public static final String MCU_TYPE_2000	=	"MCU_TYPE_2000";
	public static final String MCU_TYPE_2000C	=	"MCU_TYPE_2000C";

	//操作--------开始------------------
	/**
	 * 登录
	 * @return	boolean
	 */
	//public abstract boolean login() ;
	
	
	/**
	 * 创建会议
	 * @param	Timestamp	startTime	会议开始时间
	 * @param	Timestamp	endTime		会议结束时间
	 * @param	String		meetingName	会议名称
	 * @param	int			speed		会议速率
	 * @return	boolean
	 * @throws ZZSTControlException
	 */
	public abstract boolean creatMeeting(String meetingName,Timestamp	startTime,Timestamp	endTime,int speed) throws ZZSTControlException;
	
	/**
	 * 会议结束
	 */
	public abstract boolean endMeeting(String meetingID)  throws ZZSTControlException;
	
	/**
	 * 修改会议结束时间
	 * @param	Timestamp	endTime	
	 * @return	boolean
	 */
	public abstract boolean modifyMeetingEndTime(String meetingID,Timestamp	endTime) throws ZZSTControlException;
	
	/**
	 * 会议中添加会场
	 * @param meetingID
	 * @param terminalIP
	 * @param terminalName
	 * @return
	 * @throws ZZSTControlException
	 */
	public abstract boolean addVenue(String meetingID,String terminalIP,String terminalName)  throws ZZSTControlException;
	
	/**
	 * 呼叫会场
	 * @param meetingID
	 * @param terminalIP
	 * @param terminalName
	 * @return
	 * @throws ZZSTControlException
	 */
	public abstract boolean callVenue()  throws ZZSTControlException;
	
	public abstract void hangupVenue()  throws ZZSTControlException;
	
	/**
	 * 添加会场到mcu上
	 * @return
	 * @throws ZZSTControlException
	 */
	public abstract boolean registerVenueToMCU()  throws ZZSTControlException;
	
	/**
	 * 提取mcu上的地址薄
	 * @return
	 * @throws ZZSTControlException
	 */
	public abstract boolean getVenueFromMCUList()  throws ZZSTControlException;
	
	/**
	 * 提取会议中的参会方列表
	 * @param meetingID
	 * @return
	 * @throws ZZSTControlException
	 */
	public abstract boolean getVenueFromMeetingList(String meetingID)  throws ZZSTControlException;
	
	/**
	 * 提取mcu上会议室列表
	 * @return
	 * @throws ZZSTControlException
	 */
	public abstract boolean getMeetingRoomFromMCUList()  throws ZZSTControlException;
	
	/**
	 * 提取mcu上的所有会议列表
	 */
	public abstract boolean getMeetingListFromMcu()  throws ZZSTControlException;
	/**
	 * 提取mcu上的所有会议ID（所有的会议ID，需详细了解）
	 */
	public abstract boolean getRESListFromMcu()  throws ZZSTControlException;
	
	
	/**
	 * 提取mcu上所有简档（模板）列表
	 * @return
	 * @throws ZZSTControlException
	 */
	public abstract boolean getMeetingProfilesListFromMcu()  throws ZZSTControlException;
	
	public abstract boolean test()  throws ZZSTControlException;
	
	//操作--------结束------------------	
	

	/**
	 * 初始化数据
	 * 数组存储的结构
	 * 0:mcuIP
	 * 1:mcuType
	 * 2:信令地址
	 * 3:登录名
	 * 4:登录密码
	 * 5:父节点IP
	 * 6:监听端口
	 */
	public McuObject(String[] mcuInfoes){
		if(mcuInfoes==null||mcuInfoes.length!=7) return	;
		this.mcuIP			=	mcuInfoes[0];
		this.mcuType		=	mcuInfoes[1];
		this.xinLingIP		=	mcuInfoes[2];
		this.loginName		=	mcuInfoes[3];
		this.loginPassword	=	mcuInfoes[4];
		this.parentIP		=	mcuInfoes[5];
		if(mcuInfoes[6]!=null&&mcuInfoes[6].length()>0){
			this.listenPort		=	Integer.parseInt(mcuInfoes[6]);		
		}
	}

	protected String mcuIP;
	protected String xinLingIP;
	protected String mcuType;
	protected String loginName;
	protected String loginPassword;
	protected String parentIP		=	"-1";
	protected int    listenPort	=80;
	protected boolean	onLine		=	false;	//设备是否在线
	public MeetingInfoVO meetingInfoVO	=	new MeetingInfoVO();//需要控制的会议
	
	protected String	meetingID	;//需要控制的会议ID
	protected	ControlLoginVO	loginVO		= new ControlLoginVO();		//控制mcu过程中的登录信息
	protected	Map<String,MeetingInfoVO>	meetingVOMap = new HashMap<String,MeetingInfoVO>();     //mcu所有的会议信息
	protected	ArrayList<ExceptionVO>	exceptionVOList =	new ArrayList<ExceptionVO>();//系统异常列表
	protected	ArrayList<TerminalVO>	terminalVOList =	new ArrayList<TerminalVO>();//mcu内所有终端列表
	protected	ArrayList<MeetingRoomVO>	meetingRoomVOList =	new ArrayList<MeetingRoomVO>();//mcu内所有会议室列表
	
	
	public String getMcuIP() {
		return mcuIP;
	}

	/**
	 * 根据会议ID提取会议相关信息
	 * 注释：如果meetingID为null时,返回新MeetingInfoVO对象
	 * @param	mcuIP
	 * @param	meetingID	会议ID
	 * @return	MeetingInfoVO
	 */
	public MeetingInfoVO getMeetingVO(String mcuIP,String meetingID) {
		if(mcuIP==null||mcuIP.length()<0) return null;
		if(meetingID==null||meetingID.length()<0){
			return new MeetingInfoVO();
		}
		String key = MeetingInfoVO.key.replaceAll("mcuIP", mcuIP);
		key = key.replaceAll("meetingID", meetingID);
		return meetingVOMap.get(key);
	}

	/**
	 * 存储会议对象到缓存
	 * @param mcuIP
	 * @param meetingVO
	 */
	protected boolean setMeetingVO(String mcuIP,MeetingInfoVO	meetingVO) {
		String key = MeetingInfoVO.key.replaceAll("mcuIP", mcuIP);
		key = MeetingInfoVO.key.replaceAll("meetingID", meetingVO.getMeetingID());
		meetingVOMap.put(key, meetingVO);
		return true;
	}

	/**
	 * 删除某个会议信息
	 * @param mcuIP
	 * @param meetingID
	 */
	protected boolean removeMeetingVO(String mcuIP,String meetingID) {
		String key = MeetingInfoVO.key.replaceAll("mcuIP", mcuIP);
		key = MeetingInfoVO.key.replaceAll("meetingID", meetingID);
		meetingVOMap.remove(key);
		return true;
	}
	
	public ControlLoginVO getLoginVO() {
		return loginVO;
	}

	protected void setLoginVO(ControlLoginVO loginVO) {
		this.loginVO = loginVO;
	}

	protected int getMeetingList() {
		return meetingVOMap.size();
	}
//	public Map<String, MeetingInfoVO> getMeetingVOMap() {
//		return meetingVOMap;
//	}
//
//	public void setMeetingVOMap(Map<String, MeetingInfoVO> meetingVOMap) {
//		this.meetingVOMap = meetingVOMap;
//	}
	
	/**
	 * 设置mcu操作异常信息
	 * @param content
	 */
	protected void setException(String content,String messageID){
		ExceptionVO ev= new ExceptionVO();
		ev.setMessageType(ExceptionVO.EXCEPTION_SYSTEM);
		ev.setMessageContent(content);
		ev.setMessageID(messageID);
		exceptionVOList.add(ev);
	}

	public String getMeetingID() {
		return meetingID;
	}

	protected void setMeetingID(String meetingID) {
		this.meetingID = meetingID;
		MeetingInfoVO vo = this.getMeetingVO(this.mcuIP, meetingID);
		this.meetingInfoVO	=	vo;
	}
	 
}
