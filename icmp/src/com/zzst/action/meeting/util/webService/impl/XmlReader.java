package com.zzst.action.meeting.util.webService.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.zzst.model.meeting.meetingRoom.MeetingRoomVO;



public class XmlReader {
	Logger log=Logger.getLogger(XmlReader.class.getClass());
public static String getTagValue(String xml,String tagName) {
        String str="";
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc;
			StringReader sr=new StringReader(xml);
			InputSource is=new InputSource(sr);
			doc = builder.parse(is);
			
		    String userName=doc.getElementsByTagName(tagName).item(0).getFirstChild().getNodeValue();
		    if(userName==null||userName.equals("")){
		    str="false,"+tagName+"为空值";
		    }else{
		    str="true,"+userName;
		    }
		} catch (ParserConfigurationException e) {
			str="false,解析xml错误";
			e.printStackTrace();
		} catch (SAXException e) {
			str="false,xml文件格式错误";
		} catch (IOException e) {
			str="false,错误的xml";
			e.printStackTrace();
		}
			
	return str;
	
}


public static String getTagValues(String xml,String tagName) {
    String str="";
	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
	try {
		builder = factory.newDocumentBuilder();
		Document doc;
		doc = builder.parse(xml);
	    NodeList nodeList=doc.getElementsByTagName(tagName);
	    if(nodeList==null||nodeList.getLength()==0){
	    str="false_"+tagName+"为空值";
	    }else{
	    	String tempstr="";
	    for(int i=0;i<nodeList.getLength();i++){
	    	Node node=nodeList.item(i);
	    	tempstr+=node.getFirstChild().getNodeValue()+",";
	    }
	    
	    str="true_"+tempstr;
	    }
	    
	} catch (ParserConfigurationException e) {
		str="false_解析xml错误";
		e.printStackTrace();
	} catch (SAXException e) {
		str="false_xml文件格式错误";
	} catch (IOException e) {
		
		str="false_错误的xml";
		
	}
		
return str;

}


public static boolean checkDate(String date) {
	String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
	Pattern p = Pattern.compile(eL);
	Matcher m = p.matcher(date);
	boolean b = m.matches();
	return b;
	}

public static String getXmlTop(String flag,String description){
	StringBuffer str=new StringBuffer();
	str.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
	str.append("<data>");
	str.append("<result>");	
	str.append("<flag>"+flag+"</flag>");	
	str.append("<description>"+description+"</description>");	
	str.append("</result>");	
	str.append("</data>");
	return str.toString();
}

public static String getXmlMeetRoomList(List<MeetingRoomVO> list){
	StringBuffer str=new StringBuffer();
	if(list.size()==0){
		str.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		str.append("<data>");
		str.append("<result>");	
		str.append("<flag>false</flag>");	
		str.append("<description>没有查到相关会议室</description>");	
		str.append("</result>");	
		str.append("</data>");	
	}else{
		str.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		str.append("<data>");
		str.append("<result>");	
		str.append("<flag>true</flag>");	
		str.append("<description></description>");	
		str.append("</result>");	
		
		str.append("<meetingRoomList>");
		for(MeetingRoomVO mrv:list){
		str.append("<meetingRoom>");
		str.append("<meetingRoomID>"+mrv.getMeetingRoomID()+"</meetingRoomID>");
		str.append("<meetingRoomName>"+mrv.getMeetingRoomName()+"</meetingRoomName>");
		str.append("<capacity>"+mrv.getCapacity()+"</capacity>");
		str.append("<adminID>"+mrv.getUserVO().getUserID()+"</adminID>");
		str.append("<adminName>"+mrv.getUserVO().getName()+"</adminName>");
		str.append("<departmentID>"+mrv.getDepartmentVO().getId()+"</departmentID>");
		str.append("<departmentName>"+mrv.getDepartmentVO().getDepNo()+"</departmentName>");
		str.append("<addressID>"+mrv.getAddressVO().getAddressID()+"</addressID>");
		str.append("<addressName>"+mrv.getAddressVO().getName()+"</addressName>");
		str.append("<meetingRoomType>"+mrv.getMeetingRoomType()+"</meetingRoomType>");
		str.append("</meetingRoom>");
		}
		str.append("</meetingRoomList>");
		str.append("</data>");
		
		
	}
	
	
	
	return str.toString();
}
}
