package com.zzst.action.project.webservices.meetingcheck.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.XPath;

import com.gsiec.cjf.system.CjfLogger;
import com.opensymphony.xwork2.util.Element;
import com.zzst.action.meeting.util.ServiceFactory;
import com.zzst.action.project.webservices.meetingcheck.meetingcheckservices;
import com.zzst.application.mcudao.common.UtilDAO;
import com.zzst.dao.meeting.department.DepartmentDAO;
import com.zzst.dao.meeting.meetingRoom.MeetingRoomDAO;
import com.zzst.dao.project.avic.applyConference.ApplyConferenceDAO;
import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;
import com.zzst.model.project.avic.applyConference.ApplyConferenceVO;

public class meetingcheckservicesImpl  implements meetingcheckservices{
	private static final long serialVersionUID = 1L;
	private static Logger logger = CjfLogger.getLogger(meetingcheckservicesImpl.class.getName());
	
	private ApplyConferenceDAO    applyinfodao;
	private DepartmentDAO         departmentdao;
	private MeetingRoomDAO        meetingroomdao;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public DepartmentDAO getDepartmentdao() {
		return departmentdao;
	}
	public void setDepartmentdao(DepartmentDAO departmentdao) {
		this.departmentdao = departmentdao;
	}
	public MeetingRoomDAO getMeetingroomdao() {
		return meetingroomdao;
	}
	public void setMeetingroomdao(MeetingRoomDAO meetingroomdao) {
		this.meetingroomdao = meetingroomdao;
	}
	public ApplyConferenceDAO getApplyinfodao() {
		return applyinfodao;
	}
	public void setApplyinfodao(ApplyConferenceDAO applyinfodao) {
		this.applyinfodao = applyinfodao;
	}
	

	
	@SuppressWarnings({ "static-access"})
	public String getXml(String strXml) {
		logger.info("meetingcheckservicesImpl	getXml	begin");
		logger.info("xml传入内容为："+strXml);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><dataList>";
		//部门编号
		String depNo=this.getValue(strXml, "depNo");
		if(depNo==null||depNo.length()==0) return xml;
		
//		开始时间
		String startTime=this.getValue(strXml, "startTime");
		//结束时间
		String endTime = this.getValue(strXml, "endTime");
		if(startTime==null||startTime.length()==0) return xml;
		if(endTime==null||endTime.length()==0) return xml;
		
		List<ApplyConferenceVO>  list =this.queryBusyApplyConferenceVO(startTime, endTime);
		
		String[] depNos = depNo.split(",");
		for(String s : depNos){
			ArrayList<MeetingRoomVO> roomList=this.getMeetingRooms(s);
			if(roomList!=null&&roomList.size()>0){
				for(MeetingRoomVO vo : roomList){
					String roomid = vo.getMeetingRoomID();
					Boolean flag = true;
					if(list!=null && list.size()>0){
						for(int i=0;i<list.size();i++){
							if(roomid.equals(list.get(i).getMainConferenceID())||list.get(i).getVenueConferenceIDs().indexOf(roomid)>-1){
								xml += this.getXml1(strXml,list.get(i),roomid,s);//占用的会议室
								flag = false;
								continue;
							}
						}
					}
					if(flag){//没有被占用
						xml += this.getXml2(strXml,roomid,s);
				    }
				}
			}else{//depNO not exits
				xml += this.getXml3(strXml,s);
			}
		}
		xml += "</dataList>";
		logger.info("xml传出内容为："+xml);
		logger.info("meetingcheckservicesImpl	getXml	end");
		return xml;
	}	
	
	@SuppressWarnings("static-access")
	public String getXml1(String strXml,ApplyConferenceVO vo,String meetingRoomId,String depNo){
		//定义xml
		StringBuffer xml = new StringBuffer();
		String roomName = getRoomNameById(meetingRoomId);
//		String depNo=this.getValue(strXml, "depNo");
		if(vo!=null){
//		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		
		xml.append("<date>");
		xml.append("<depNo>").append(depNo).append("</depNo>");
		if(meetingRoomId!=null && meetingRoomId.length()>0){
		xml.append("<id>").append(meetingRoomId).append("</id>");
		}else{
		xml.append("<id>").append("</id>"); 
		}
		if(roomName!=null && roomName.length()>0){
		xml.append("<name>").append(roomName).append("</name>");
		}else{
			xml.append("<name>").append("</name>"); 	
		}
		xml.append("<status>").append("占用").append("</status>");
		if(vo.getLinkManName()!=null && vo.getLinkManName().toString().length()>0){
		xml.append("<linkManName>").append(vo.getLinkManName()).append("</linkManName>");
		}else{
		xml.append("<linkManName>").append("</linkManName>"); 	
		}							
		if(vo.getLinkManCellPhone()!=null && vo.getLinkManCellPhone().toString().length()>0){
		xml.append("<phone>").append(vo.getLinkManCellPhone()).append("</phone>");
		}else{
		xml.append("<phone>").append("</phone>"); 	
		}
		if(vo.getCreateTime()!=null && vo.getCreateTime().toString().length()>0){
		xml.append("<createTime>").append(vo.getCreateTime()).append("</createTime>");
		}else{
		xml.append("<createTime>").append("</createTime>"); 	
		}			
		if(vo.getConferenceName()!=null && vo.getConferenceName().toString().length()>0){
		xml.append("<conferenceName>").append(vo.getConferenceName()).append("</conferenceName>");
		}else{
		xml.append("<conferenceName>").append("</conferenceName>"); 	
		}			
		xml.append("</date>");		
		}
		
		return xml.toString();
	}
	
	
	@SuppressWarnings("static-access")
	public String getXml2(String strXml,String roomid,String depNo){
		//定义xml
		StringBuffer xml = new StringBuffer();
		String roomName = getRoomNameById(roomid);
//		String depNo=this.getValue(strXml, "depNo");
//		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<date>");
		xml.append("<depNo>").append(depNo).append("</depNo>");
		xml.append("<id>").append(roomid).append("</id>"); 
		xml.append("<name>").append(roomName).append("</name>"); 	
		xml.append("<status>").append("未占用").append("</status>");
		xml.append("<linkManName>").append("</linkManName>"); 	
		xml.append("<phone>").append("</phone>"); 	
		xml.append("<createTime>").append("</createTime>"); 	
		xml.append("<conferenceName>").append("</conferenceName>"); 	
		xml.append("</date>");		
		return xml.toString();
	}
	
	@SuppressWarnings("static-access")
	public String getXml3(String strXml,String depNo){
		//定义xml
		StringBuffer xml = new StringBuffer();
		String roomid = UtilDAO.getUUid();
//		String depNo=this.getValue(strXml, "depNo");
//		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<date>");
		xml.append("<depNo>").append(depNo).append("</depNo>");
		xml.append("<id>").append(roomid).append("</id>"); 
		xml.append("<name>").append("此单位下无会议室").append("</name>"); 	
		xml.append("<status>").append("占用").append("</status>");
		xml.append("<linkManName>").append("</linkManName>"); 	
		xml.append("<phone>").append("</phone>"); 	
		xml.append("<createTime>").append("</createTime>"); 	
		xml.append("<conferenceName>").append("</conferenceName>"); 	
		xml.append("</date>");		
		return xml.toString();
	}
	
	//获取指定节点值
	@SuppressWarnings("unchecked")
	public static String getValue(String xmlString,String nodeName){
		Document doc = null;		
		org.dom4j.Element root = null;		
		String namespace = null;	
		Object nameEle =null;
		try {
			doc = DocumentHelper.parseText(xmlString);  
			root = doc.getRootElement();				
			namespace = ((org.dom4j.Element) root).getNamespaceURI();
		} catch (DocumentException e) {
			return null;
		}
		Map map = new HashMap(); 					
		map.put("TJ", namespace);
		XPath x = doc.createXPath("//TJ:"+nodeName);
		x.setNamespaceURIs(map);
		List nodelist = x.selectNodes(doc);
		if (nodelist == null || nodelist.size() == 0) {
			return null;
		}
		nameEle =nodelist.get(0);
		String name = ((org.dom4j.Element) nameEle).getTextTrim();
		return name ;
	}
	
	//通过xml传入的开始时间结束时间，查询出此时间段内所有申请的会议信息
	@SuppressWarnings("static-access")
	public ArrayList<ApplyConferenceVO> queryBusyApplyConferenceVO(String startTime ,String endTime){
			ApplyConferenceVO applyConferenceVO = new ApplyConferenceVO();
			ArrayList<ApplyConferenceVO> aList = new ArrayList<ApplyConferenceVO>();
			if(startTime!=null && startTime.trim().length()>0 && endTime!=null && endTime.trim().length()>0){
				try {
					Date startTimeDate = format.parse(startTime);
					Date endTimeDate = format.parse(endTime);
					applyConferenceVO.setStartTime(new Timestamp(startTimeDate.getTime()));
					applyConferenceVO.setEndTime(new Timestamp(endTimeDate.getTime()));
					aList = applyinfodao.queryBusyMeetingRoom(applyConferenceVO, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return aList;
		}	
	
	//通过分会场id查询分会场名称
	public  String getRoomNameById(String  id){
		MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
		if(id!=null && id.trim().length()>0){
			try {
				meetingRoomVO = ServiceFactory.getMeetingRoomService().queryByID(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return meetingRoomVO.getMeetingRoomName();
	}
	
	//会议室的id meetingRoomid
	public ArrayList<MeetingRoomVO>  getMeetingRooms(String depNo){
		ArrayList<MeetingRoomVO> list = new ArrayList<MeetingRoomVO>();
//			String meetingRoomId = "";
			MeetingRoomVO meetingRoomVO = new MeetingRoomVO();
			if(depNo!=null && depNo.trim().length()>0){
//				meetingRoomVO.getDepartmentVO().setDepNo(depNo);===========================中航的depNo对应“ICMP”本系统的id
				meetingRoomVO.getDepartmentVO().setId(depNo);
				try {
					list = ServiceFactory.getMeetingRoomService().query(meetingRoomVO, null);
//					if(list!=null && list.size()>0){
//							meetingRoomId = list.get(0).getMeetingRoomID();
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return list;
		}	
	 
	
}
