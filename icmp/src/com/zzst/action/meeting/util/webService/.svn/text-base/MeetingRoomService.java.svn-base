package com.zzst.action.meeting.util.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name="MeetingRoom",serviceName="MeetingRoomServices",targetNamespace="MeetingRoomServices")
public interface MeetingRoomService {
	
	/**
	 * 根据时间提取空闲会议室
	 * @param strXml
	 * @return 
	 */
	@WebMethod
	public String getFreeMeetingRoomList(@WebParam(name="strXml")String strXml);
	
	/**
	 * 根据时间提取所有会议室
	 * @param strXml
	 * @return 
	 */
	@WebMethod
	public String getAllMeetingRoomList(@WebParam(name = "strXml")String strXml);
	
	/**
	 * 根据时间取得所有会议室，并判断是否占用
	 * @param strJSON
	 * @return
	 */
	@WebMethod
	public String getMeetingRoomList(@WebParam(name = "strJSON")String strJSON);
	
	@WebMethod
	public String getAllDepartmentList();
	
	
}
