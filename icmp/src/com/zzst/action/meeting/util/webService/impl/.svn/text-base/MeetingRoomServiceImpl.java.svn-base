package com.zzst.action.meeting.util.webService.impl;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.meeting.util.webService.MeetingRoomService;
import com.zzst.dao.meeting.department.DepartmentDAO;
import com.zzst.model.meeting.department.DepartmentVO;
import com.zzst.model.meeting.meetingDetail.MeetingDetailVO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;

public class MeetingRoomServiceImpl implements MeetingRoomService {

	//可以获取客户端信息
	private WebServiceContext context;
	
	@Override
	public String getFreeMeetingRoomList(String xml) {
	  String starTime=XmlReader.getTagValue(xml, "startTime");
	  if(starTime.split(",")[0].equals("false")){
		  return XmlReader.getXmlTop(starTime.split(",")[0], starTime.split(",")[1]);
	  }
	  System.out.println(starTime);
	  starTime=starTime.split(",")[1].replace("T", " ");
	  System.out.println(starTime);
	  if(!XmlReader.checkDate(starTime)){
		 return XmlReader.getXmlTop("false", "starTime时间格式错误");
	  }
	  String endTime=XmlReader.getTagValue(xml, "endTime");
	  if(endTime.split(",")[0].equals("false")){
		  return XmlReader.getXmlTop(endTime.split(",")[0], endTime.split(",")[1]);
	  }
	  endTime=endTime.split(",")[1].replace("T", " ");
	  if(!XmlReader.checkDate(endTime)){
		 return XmlReader.getXmlTop("false", "endTime时间格式错误");
	  }
	  
	  /////////////////////////////////////////////////////////////////////////////
	  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  StringBuffer xmlStr =new StringBuffer();
	  MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
	  try {
		meetingDetailVO.setMeetingStartTime(new Timestamp(format.parse(starTime).getTime()));
        meetingDetailVO.setMeetingEndTime(new Timestamp(format.parse(endTime).getTime()));
		} catch (ParseException e1) {
		return XmlReader.getXmlTop("false", "时间格式错误");
		}
		
	  List<MeetingRoomVO> meetingRoomVOList=new ArrayList<MeetingRoomVO>();
	 try {
		meetingRoomVOList=ServiceFactory.getMeetingRoomService().getEmptyMeetingRoomListForWs(meetingDetailVO, null);
		xmlStr.append(XmlReader.getXmlMeetRoomList(meetingRoomVOList));
	} catch (Exception e) {
		 return XmlReader.getXmlTop("false", "查询异常");
	}
	  return xmlStr.toString();
	}

	public String getAllMeetingRoomList(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMeetingRoomList(String strJSON) {
		//参数信息 {'startTime':'2016-4-7 15:39:09','endTime':'2016-4-8 15:39:09'}
		HashMap<String, String> data = new HashMap<String, String>();  
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = new JSONObject(strJSON);
		Iterator it = jsonObject.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = (String) jsonObject.get(key);
			data.put(key, value);
		}
	       
	       
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp st = null;
		Timestamp et = null;
		try {
			st = new Timestamp(format.parse(data.get("startTime")).getTime());
			et = new Timestamp(format.parse(data.get("endTime")).getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List<Map<String, String>> lm = new ArrayList<Map<String, String>>();
		
		//查询所有会场用
		MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
		//查询空会场用
		MeetingDetailVO meetingDetailVO = new MeetingDetailVO();
		//开始时间和结束时间，是对面传过来的
		meetingDetailVO.setMeetingStartTime(st);
		meetingDetailVO.setMeetingEndTime(et);
		try {
			//所有空闲会场
			ArrayList<MeetingRoomVO> emptyMeetingRoomList = ServiceFactory.getMeetingRoomService().getEmptyMeetingRoomList(meetingDetailVO, null);
			//查询所有的会议室
			ArrayList<MeetingRoomVO> meetingRoomList = ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
			if(emptyMeetingRoomList !=null && emptyMeetingRoomList.size()>0){//有空闲会场
				for( MeetingRoomVO rvo : meetingRoomList ){
					Map<String, String> map = new HashMap<String, String>();//用来存储会议信息
					boolean flag = false;
					for(MeetingRoomVO rvo2:emptyMeetingRoomList){//遍历空闲会场
						if(rvo.getMeetingRoomID().equals(rvo2.getMeetingRoomID())){//会议室ID相等
							//TODO 是空闲会场
							flag = true;
						}
					}
					if(flag){//空闲
						map.put("meetingroomID", rvo.getMeetingRoomID());
						map.put("meetingroomName", rvo.getMeetingRoomName());
						map.put("meetingroomType", rvo.getMeetingRoomType()+"");//int ---> string
						map.put("departmentID", rvo.getDepartmentVO().getId());
						map.put("status", "0");//状态：0、空闲      1、占用
						map.put("capacity", rvo.getCapacity()+"");//容纳人数
						map.put("roomNO", rvo.getRoomNO());
						map.put("adminID", rvo.getUserVO().getUserID());
						map.put("description", rvo.getDescription());
					}else{//占用
						map.put("meetingroomID", rvo.getMeetingRoomID());
						map.put("meetingroomName", rvo.getMeetingRoomName());
						map.put("meetingroomType", rvo.getMeetingRoomType()+"");//int ---> string
						map.put("departmentID", rvo.getDepartmentVO().getId());
						map.put("status", "1");//状态：0、空闲       1、占用
						map.put("capacity", rvo.getCapacity()+"");//容纳人数
						map.put("roomNO", rvo.getRoomNO());
						map.put("adminID", rvo.getUserVO().getUserID());
						map.put("description", rvo.getDescription());
					}
					lm.add(map);
				}
			}else{
				for( MeetingRoomVO rvo : meetingRoomList ){
					//TODO 所有的会场都被占用
					Map<String, String> map = new HashMap<String, String>();//用来存储会议信息
					map.put("meetingroomID", rvo.getMeetingRoomID());
					map.put("meetingroomName", rvo.getMeetingRoomName());
					map.put("meetingroomType", rvo.getMeetingRoomType()+"");//int ---> string
					map.put("departmentID", rvo.getDepartmentVO().getId());
					map.put("status", "1");//状态：0、空闲1、占用
					map.put("capacity", rvo.getCapacity()+"");//容纳人数
					map.put("roomNO", rvo.getRoomNO());
					map.put("adminID", rvo.getUserVO().getUserID());
					map.put("description", rvo.getDescription());
					lm.add(map);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray(lm);
		//System.out.println(ja.length());
		return ja.toString();
	}

	@Override
	public String getAllDepartmentList() {
		// TODO Auto-generated method stub
		ArrayList<DepartmentVO> departmentList = DepartmentDAO.getAllList(new DepartmentVO(), null);
		//System.out.println(departmentList.size());
		List<Map<String, String>> lm = new ArrayList<Map<String, String>>();
		
		for(DepartmentVO dv : departmentList){
			Map<String, String> map = new HashMap<String, String>();//用来存储会议信息
			map.put("id", dv.getId());
			map.put("parentID", dv.getParentId());
			map.put("name", dv.getTitle());
			lm.add(map);
		}
		JSONArray ja = new JSONArray(lm);
		//System.out.println(ja.length());
		return ja.toString();
	}
	
}
