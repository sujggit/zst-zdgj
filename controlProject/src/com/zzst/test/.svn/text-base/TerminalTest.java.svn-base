package com.zzst.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.vo.AudiometerVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description
 *@date 2011-12-30下午06:21:00
 *@author ryan
 */
public class TerminalTest {
	
	

	public static String db_url = "jdbc:mysql://10.8.12.78:5522/icmp20140925?characterEncoding=gb2312";
	public static String db_name = "test"; 
	public static String db_pas = "123456";
	
	public static String testIpsd = "10.1.6.93";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("E:/develop_C/6dev/controlProject/src/applog4j.properties");//加载.properties文件 
		try {
//		TerminalTest.initSys();
		TerminalTest.initTerminalDate();//手动配置信息
		
//		TerminalTest.getTerminalEquipmentList();//使用数据库信息
		System.out.println("完成初始化数据");
//		10.6.242.15
		ControlFactory.setEquipmentParam(1, 1);
		ControlFactory.startEquipmentNetStatusThreads(EquipmentObject.EQUIPMENT_TYPE_TERMINAL);
		Thread.sleep(10*1000);
		
		//====================功能测试模块====================
		
		//==f7测试音频取值问题20141014		开始
				for(int i=0;i<5;i++){
					TerminalTest.getAudioStatus();
					Thread.sleep(5000);					
				}
		//==测试音频取值问题20141014		结束
		
		TerminalObject tobj	=	ControlFactory.getTerminalObject(testIpsd);
		tobj.callIP(1024, "10.1.6.161");
		
//		Thread.sleep(5*100000000);
		//测试终端状态测试用例===开始
//		while(true){
//			ArrayList<TerminalObject> list = ControlFactory.getAllTerminalObject();
//			if(list==null||list.size()==0){
//				Thread.sleep(5000);
//				System.out.println("===终端=为0");
//				continue;
//			}
//			
//			for(TerminalObject obj : list){
//				if(TerminalObject.status_on.equalsIgnoreCase(obj.getStatus())){
//					System.out.println(obj.getTerminalIp()+"在线");	
//				}else if(TerminalObject.status_off.equalsIgnoreCase(obj.getStatus())){
//					System.out.println(obj.getTerminalIp()+"不在线");
//				}else{
//					System.out.println(obj.getTerminalIp()+"会议中");
//				}
//				Thread.sleep(2000);
//			}
//		}
		//测试终端状态测试用例===结束
		
//		String fromIP = "11.63.193.132";
//		TerminalObject fromObj = ControlFactory.getTerminalObject(fromIP);
//		if(fromObj==null) {
//			System.out.println("from为空");
//		} ;
//		fromObj.testToneOn();
//		Thread.sleep(2000);
		
//		TerminalObject tobj = ControlFactory.getTerminalObject(testIpsd);
////		tobj.setAudiometerAllOn();
//		tobj.setAudiometerOn(AudiometerVO.lineoutleft);
//		Thread.sleep(1000);
//		tobj.setAudiometerOn(AudiometerVO.micleft);
//		Thread.sleep(1000);
//		tobj.setAudiometerOn(AudiometerVO.farendleft);
		
//		tobj.getCallSound("1");
//		tobj.getPromptSound("1");
		
		
		/**
		 * 终端测试
		 */
//		for(int i=0;i<9999;i++){
//			Thread.sleep(3*1000);
//			tobj = ControlFactory.getTerminalObject(testIpsd);
//			
//			ExcuteResultVO resultVO = tobj.getAudiometerVO();
//			if(!resultVO.isSuccess()){
//				System.out.println(resultVO.getDes()+"===============");return;
//			}
//			Map<String,AudiometerVO> map = (Map<String,AudiometerVO>)resultVO.getObject();
//			if(map==null){
//				System.out.println("map为空");
//				continue ;
//			}
//			
//			AudiometerVO vo = map.get(AudiometerVO.lineoutleft);
//			if(vo==null) {
//				System.out.println("lineoutleft对象为空");
//			}else
//			System.out.println(vo.getNum()+"==lineoutleft");
//			
//			vo = map.get(AudiometerVO.micleft);
//			if(vo==null) {
//				System.out.println("micleft对象为空");
//			}else
//			System.out.println(vo.getNum()+"==micleft");
//			
//			vo = map.get(AudiometerVO.farendleft);
//			if(vo==null) {
//				System.out.println("farendleft对象为空");
//			}else
//				System.out.println(vo.getNum()+"==farendleft");
//		}
		
		
//			tobj.setCallDetailOn();
//		Thread.sleep(2000);
		
//		CallDetailVO vo = tobj.setCallDetailOn();
//		System.out.println(vo.getCallDetail().get(CallDetailVO.txrate));
//		System.out.println(tobj.getMeetingVO().size());
//			tobj.callIP(1024, "10.1.6.162");
			
		
		//tobj.cameraSetPosition("2", "2", "2");
		
		//CameraVO c = tobj.cameraGetPosition();
		//System.out.println(c.getX()+"#######"+c.getY()+"======="+c.getZoom());
		
//		tobj.callIP(1024, "10.1.6.162");
//		Thread.sleep(10000);
		
//		for(int i=0;i<20;i++){
//			Map<String ,String> map = tobj.setCallDetailOn().getCallDetail();
//			Iterator it= map.entrySet().iterator();
////			for(String dataKey : map.keySet()){
//				while(it.hasNext()){
//					Map.Entry  pairs = (Map.Entry)it.next();
////					System.out.println(pairs.getKey() + " = " + pairs.getValue());
//					//System.out.println(dataKey+"&&&&&&&&&&&&&&&&&&&");
//				}
////			}
//
//			Thread.sleep(5*1000);
//		}
		
		
		//tobj.buttonHome();
		//tobj.buttonKeyboard();
		//tobj.buttonSelect(); //ok
		//tobj.buttonBack(); // ok
		//tobj.buttonPip();
		//tobj.buttonNum("6");//ok
		//tobj.buttonVolumeDown();
		//tobj.buttonHome(); //ok
		//tobj.buttonDelete(); //ok
//		tobj.buttonDown();
		
//		if(tobj==null) {
//			System.out.println("=====");
//			return;
//		}
//		tobj.setAudiometerAllOn();
//		tobj.setAudiometerOn(AudiometerVO.micleft);
//		for(int i=20;i>0;i--){
//			if(tobj.getAudiometerVO()!=null&&tobj.getAudiometerVO().size()>0&&tobj.getAudiometerVO().get(AudiometerVO.micleft)!=null)
//				System.out.println("===%%=="+tobj.getAudiometerVO().get(AudiometerVO.micleft).getNum());
//			else
//				System.out.println("-------------");
//			
//			System.out.println("#########"+tobj.getAudiometerVO().size());
//			Thread.sleep(1000);
//		}
		
	
//		tobj.setAudiometerAllOff();
//		for(int i=20;i>0;i--){
//			Thread.sleep(1000);
//			System.out.println(tobj.getAudiometerVO().get(AudiometerVO.micleft));
//		}
		//tobj.cameraMoveFar();
//		Thread.sleep(3000);
//		tobj.cameraMoveLeft();
//		Thread.sleep(3000);
//		tobj.cameraMoveNear();
//		Thread.sleep(3000);
//		tobj.cameraMoveRight();
//		tobj.callIP(1024, "10.1.6.161");
//		 
//		TerminalMeetingVO tMeetingVO = tobj.getMeetingVO("10.1.6.162","10.1.6.161");
//		if(tMeetingVO==null){
//			System.out.println("没有对象");
//		}else{
//			System.out.println(tMeetingVO.getFarIP());	
//		}
//		TerminalObject tobj2 = (TerminalObject)ControlFactory.getTerminalObject("10.1.6.161");
//		for(int i=0;i<999999;i++){
//			Thread.sleep(2000);
//			System.out.println(i+"&&&&&&"+tobj2.getTerminalIp()+":::::::::::"+tobj2.isOnLine()+"===");
//			System.out.println(i+"&&&&&&"+tobj.getTerminalIp()+":::::::::::"+tobj.isOnLine()+"===");
//		}
		
		//Thread.sleep(5000);
		//tobj.muteOff();
		//Thread.sleep(5000);
		//tobj.muteOn();
		//Thread.sleep(5000);
		//tobj.hangupAll();
		//Thread.sleep(5000);
//		tobj.setAudiometerOn(AudiometerVO.micleft);
//		Thread.sleep(5000);
//
//		tobj.setAudiometerOff(AudiometerVO.micleft);
//		Thread.sleep(5000);
//		System.out.println("end");
		
	 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  void initSys(){
		ControlFactory.snmpInitDate("10.6.242.12");
	}
	
	public void initTerminalList(){ 
		
	}
	
	public static void initTerminalDate(){
		
		Map<String,String[]> map = new HashMap<String,String[]>();
		String[] a  = new String[7];
		a[0]=testIpsd;
		a[1]="86073526";
		a[2]="admin";
		a[3]="123456";
		a[4]="";
		a[5]="";
		a[6]="";
		map.put(testIpsd, a);
		 
		a  = new String[7];
		a[0]="11.63.193.132";
		a[1]="86073526";
		a[2]="";
		a[3]="";
		a[4]="";
		a[5]="";
		a[6]="";
		map.put("11.63.193.132", a);
		
		ControlFactory.terminalInitDate(map);
		
	}
	public static void getAudioStatus(){
		//全部设备列表
//		String sql = "select equipmentID,ip,status from z_t_equipment  where equipmentType = 0 and status = 1";
		//会议中在线的会场
		String sql = "SELECT mcu_participant_ip FROM `zzo_mcu_pts` where confFlagId='8a86728c4911d893014911d893050000' and nodeType=-2147483648 and connectStatus=1";
		
		try{
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection(db_url,db_name,db_pas);
			Statement stmt = conn.createStatement();
			ResultSet rs   = stmt.executeQuery(sql);
			  if( rs!= null)
			  {
				  while(rs.next()){
					  String ip = rs.getString("mcu_participant_ip");
//						String ip = rs.getString("ip");
						
						if(ip.equalsIgnoreCase(testIpsd)) continue;
						
						TerminalObject tobj = ControlFactory.getTerminalObject(ip);
						if(tobj==null) continue;
						tobj.setAudiometerOn(AudiometerVO.lineoutleft);
//						Thread.sleep(3000);
						ExcuteResultVO resultVO = tobj.getAudiometerVO();
						if(!resultVO.isSuccess()){
							System.out.println(ip+"=="+resultVO.getDes());continue;
						}
						Map<String,AudiometerVO> map = (Map<String,AudiometerVO>)resultVO.getObject();
						if(map==null){
							System.out.println("map为空");
							continue ;
						}
						
						AudiometerVO vo = map.get(AudiometerVO.lineoutleft);
						if(vo==null) {
							System.out.println("lineoutleft对象为空");
						}else
							System.out.println(ip+"#########################"+vo.getNum()+"===lineoutleft");
						
						tobj.setAudiometerOff(AudiometerVO.lineoutleft);
				  }
			  }
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Map<String,String[]> getTerminalEquipmentList(){
		Map<String,String[]> map = new HashMap<String,String[]>();
		//全部设备列表
//		String sql = "select equipmentID,ip,status from z_t_equipment  where equipmentType = 0 and status = 1";
		//会议中在线的会场
		String sql = "SELECT mcu_participant_ip FROM `zzo_mcu_pts` where confFlagId='8a86728c4911d893014911d893050000' and nodeType=-2147483648 and connectStatus=1";
				
		try{
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection(db_url,db_name,db_pas);
			Statement stmt = conn.createStatement();
			ResultSet rs   = stmt.executeQuery(sql);
			  if( rs!= null)
			  {
				  while(rs.next()){
						String[] a  = new String[7];
						String ip = rs.getString("mcu_participant_ip");
						//String ip = rs.getString("ip");
						a[0]=ip;
						a[1]="";
						a[2]="";
						a[3]="";
						a[4]="";
						a[5]="";
						a[6]="";
						map.put(ip, a);
				  }
				  ControlFactory.terminalInitDate(map);
			  }
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
