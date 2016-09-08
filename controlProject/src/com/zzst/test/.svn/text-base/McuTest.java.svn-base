package com.zzst.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.mcu.service.McuObject;
import com.zzst.util.ControlFactory;


/**
 *@Description
 *@date 2011-12-30下午07:12:54
 *@author ryan
 */
public class McuTest {

	public static String aaa = "aa";
	public static String[] bbb = {"aa","aa","aa"};
	private	List<String>	objList	=	Collections.synchronizedList(new LinkedList<String>());
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/zdq/controlProject/src/applog4j.properties");//加载.properties文件 
		try {
		//new McuTest().initSys();
//			ControlFactory.initTrapParseMpv2("10.1.3.150");
			
//		//mcu测试----------------
		new McuTest().initMcuDate();
//		
		McuObject mc = ControlFactory.getMcuObject("10.255.255.56");
		if(mc==null){
			System.out.println("没有对象");
		}else{
				mc.test();
//				MeetingInfoVO v = mc.meetingInfoVO;		
//				//mc.modifyMeetingEndTime(v.getMeetingID(), null);
//				//McuObject mc2 = ControlFactory.getMcuObject("10.1.6.190");
//				Thread.sleep(1000);
//				mc.addVenue(v.getMeetingID(), "10.1.3.150", "1111111");
//				//mc.addVenue(v.getMeetingID(), "10.1.3.151", "1111111");
//				//System.out.println(v.getMeetingID());
//				mc.callVenue();
//				//mc.callVenue(v.getMeetingID(),"10.1.3.150","tttttttt");
//				//mc.getVenueFromMeetingList(v.getMeetingID());
//				//mc.getVenueFromMCUList();
//				//mc.registerVenueToMCU();
//				//mc.getVenueFromMCUList();
//				//Thread.sleep(2000);
//				//mc.endMeeting(v.getMeetingID());
//				//mc.test();
//				//mc.getMeetingListFromMcu();
//				System.out.println("ok");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initSys(){
		ControlFactory.snmpInitDate("10.1.2.154");
	}
	 
	 
	public void initMcuDate(){
		Map m = new HashMap();
		String[] a  = new String[7];
		a[0]="10.255.255.56";
		a[1]=McuObject.MCU_TYPE_2000;
		a[2]="10.255.255.56";
		a[3]="POLYCOM";
		a[4]="POLYCOM";
		a[5]="-1";
		a[6]="80";
		m.put("10.255.255.56",a);
		ControlFactory.mcuInitDate(m);
	}
	 
}
