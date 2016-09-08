package com.zzst.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.vo.CameraVO;
import com.zzst.centerContor.vo.CenterControlVO;
import com.zzst.centerContor.vo.RoomModelVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.initDate.DBHelp;


/**
 *@Description
 *@date 2011-12-30下午07:13:50
 *@author ryan
 */
public class CCTest {

	public static String testIP = "10.1.6.6";
	public static String aaa = "aa";
	public static String[] bbb = {"aa","aa","aa"};
	private	List<String>	objList	=	Collections.synchronizedList(new LinkedList<String>());
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/6dev/icmp/src/applog4j.properties");//加载.properties文件 
		try {
		new CCTest().initSys();
			
		new CCTest().initCenterControlDate(testIP);
//		new CCTest().initCenterControlDate("10.6.22.250");
		Thread.sleep(1000);
		CenterControlObject obj = ControlFactory.
			getCenterControlObject(testIP);
		if(obj==null){
			System.out.println("对象为空，异常");
		}else{
//			obj.audioMuteOn("2");
			boolean b = true;
			int count =0;
			while(b){
				count++;
				System.out.println(obj.getStatus());
				Thread.sleep(5000);	
			}
			
			
//			for(String s : obj.getEquipmentList()){
//				System.out.println(s);	
//			}
//			ExcuteResultVO resultVO = obj.getEquipmentStatus("1");
//			System.out.println(resultVO.isSuccess()+""+obj.getStatus());
			
			//obj.sendCommand("MATRIX.1:VIDEO>48>39");
//			public static String terminal2_outPort="38";
//			public static String terminal2_inPort="48";
//			public static String terminal2_graphics_inPort="7";
//			public static String terminal2_graphics_outPort="10";
			//obj.matrixSwitch("1", "38", "02");
//			ExcuteResultVO resultVO = obj.cameraAutoTrack("1");
//			if(resultVO.isSuccess()){
//				System.out.println(resultVO.getObject());
//			}
//			System.out.println(resultVO.getDes());
		}
		
//		if(obj!=null){
////			System.out.println("======="+obj.getStatus());
////			ExcuteResultVO  rVO = obj.viewScreentModelStatusInfo("1");
////			ViewScreentVO vo = (ViewScreentVO)rVO.getObject();
////			String[] s = vo.getModelInfo();
//////
////			for (String ss : s) {
////				System.out.println(ss);
////			}
//			//obj.viewScreentModel("1","221-VLINK_TJ");
//			
//			obj.viewScreentModel("1", "221-VLINK_TJ");
//			
//			ViewScreentVO vo = (ViewScreentVO)(obj.viewScreentModelStatusInfo("1").getObject());
//			
//			ViewScreentVO vo1 = (ViewScreentVO)(obj.viewScreentModelStatus("1").getObject());
//			
//			CenterControlObject obj1 = (CenterControlObject)ControlFactory.getCenterControlObject("10.6.22.250");
//			
//			
//			
////			obj1.viewModelInfo("1", "521-VLINK", "RH");
//			
//			
//			//obj1.viewScreentModelInfo("1", vo1.getModel(), "1", "rhvlink01_rhvlink02_rhvlink01_rhvlink02");
//			
//			//			Thread.sleep(2000);
//			//obj.plaOff("0");
//			//obj.viewScreentModel("1", "203-AV");
//			//obj.viewScreentModelStatus("1");
//			//obj.viewScreentOFF("1");
//			//obj.viewScreentStauts("1");
//			//obj.viewScreentModelList("1");
////			System.out.println(obj.getUpDownScreenList().size());
////			for(int i=4;i>0;i--){
////				if(i!=1)
////				obj.lightOff(i+"");
////				Thread.sleep(500);	
////			}
//			
//			//obj.cameraLeft("1");
//			//Thread.sleep(1000);
//			//obj.cameraStop("1");
//			//obj.upDownScreenScreenDown("7");
//			//obj.sendCommand("POWER.1:STATUS");
//			//obj.viewScreentModelList("1");
//			//obj.viewScreentON("1");
//			//obj.viewScreentOFF("1");
//			//obj.viewScreentModelStatus("1");
//			//obj.viewScreentStauts("1");
//			//obj.viewScreentModel("1", "MODEL2");
//			//obj.viewScreentModel("1", "10");
//			
//			
//			//obj.matrixSwitch("1", "13", "18");
//			//obj.matrixSwitchList("1");
//			
//			
//			//obj.audioMuteOn("1");
//			//obj.audioMuteOff("1");
//			//obj.audioSetMuteUP("1");
//			//obj.audioSetMuteDown("1");
//			//obj.audioStatus("1");
//			//obj.audioMuteNum("1");
//			
//			
//			
//			//obj.sysPowerOn("1");
////			ExcuteResultVO resultVO = obj.sysPowerStatus("1");
////			if(resultVO.isSuccess()){
////				SysPowerVO sv = (SysPowerVO)resultVO.getObject();
////				System.out.println(sv.getStatus());
////			}
//			
//			
//			
//			
//			
//			
//			
//			
////			ExcuteResultVO rVO = null;
////			Thread.sleep(2000);
////			rVO = obj.viewScreentModelList("1");
////			ViewScreentVO vvo = (ViewScreentVO)rVO.getObject();
////			String[][] s = vvo.getAllModel();
////			for(int i=0;i<s.length;i++){
////				System.out.println(s[i][0]);
////				System.out.println(s[i][1]);
////				System.out.println(vvo.getModelSwitchOutPort(s[i][0]));
////			}
////			ArrayList<MatrixSwitchVO> mvList = obj.getMatrixSwitchList();
////			if(mvList==null||mvList.size()==0){
////				System.out.println("=-没有矩阵=-");return ;
////			}
////			MatrixSwitchVO msv = mvList.get(0);
////			System.out.println("=-2=-"+msv.getId());
//			
////			ExcuteResultVO rVO = null;
////			SysPowerVO svo =null;
////			rVO = obj.sysPowerOff(msv.getId());
//			
//			//svo = (SysPowerVO)rVO.getObject();
////			System.out.println(svo.getStatus());
////			obj = (CenterControlObject)ControlFactory.getCenterControlObject("10.1.6.166");
////			rVO = obj.sysPowerOn(msv.getId());
////			svo =(SysPowerVO)rVO.getObject();
////			System.out.println("==="+svo.getStatus());
////			
////			obj = (CenterControlObject)ControlFactory.getCenterControlObject("10.1.6.166");
////			rVO = obj.sysPowerStatus(msv.getId());
////			svo =(SysPowerVO)rVO.getObject();
////			System.out.println("=22222222=="+svo.getStatus());
////			
////			obj.matrixSwitch(msv.getId(), "1", "2");
//			//Thread.sleep(1000);
//			
//			//obj.matrixSwitchList(msv.getId());
//			//msv = mvList.get(0);
//			
////			obj.matrixSwitch(msv.getId(), "1", "2");
////			MATRIX.1:VIDEO>1:2
////			System.out.println(obj.getMatrixSwitchList().size());
////			System.out.println(obj.getAudioList().size());
////			System.out.println(obj.getVedioTerminalList().size());
//		}else{
//			System.out.println("对象为空");
//		}
		
		
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initSys(){
		//ControlFactory.snmpInitDate("10.1.2.154");
		ControlFactory.dbInitDate(DBHelp.type_mysql, "icmp", "icmp", "jdbc:mysql://10.1.8.7:3306/icmp?characterEncoding=gb2312");
	}
	
	public void initCenterControlDate(String ip){ 
		ArrayList<CenterControlVO> ccList = new ArrayList<CenterControlVO>();
		ccList.add(initCenterControl1(ip));
//		ccList.add(initCenterControl2());
//		CenterControlVO c = new CenterControlVO();
//		for(int i=0;i<13;i++){
//			c = new CenterControlVO();
//			c.setId("1");
//			c.setIp("10.1.2.1"+i);
//			c.setPort(1550);
//			c.setName("10.1.2.1"+i);
//			ccList.add(c);
//		}
		
		ControlFactory.centerControlInitDate(ccList);
	}
	  
	private CenterControlVO initCenterControl1(String ip){

		CenterControlVO c = new CenterControlVO();
		c.setId("1");
		c.setIp(ip);
		c.setPort(1550);
		c.setName("中控一");
		
		ArrayList<RoomModelVO> roomModel = new ArrayList<RoomModelVO>();
		RoomModelVO vo = new RoomModelVO();
		vo.setId("a");
		vo.setName("aa");
		String[][] s = new String[][]{{"1-1","1-2"},{"2-1","2-2"},{"3-1","3-2"}};
		vo.setModelList(s);
		
//		ArrayList<AudioControlVO> audioList = new ArrayList<AudioControlVO>();
//		AudioControlVO av = new AudioControlVO();
//		av.setId("1");
//		av.setIp("10.2.2.2");
//		av.setName("bss处理器");
//		audioList.add(av);
//		av = new AudioControlVO();
//		av.setId("2");
//		av.setIp("10.3.3.3");
//		av.setName("c16处理器");
//		audioList.add(av);
//		c.setAudioList(audioList);
//		
//		ArrayList<MatrixSwitchVO> matrixSwitchList = new ArrayList<MatrixSwitchVO>();
//		
//		String[][] in = {{"13","输入一"},{"14","输入二"},{"15","输入三"}};
//		String[][] out = {{"17","输出一"},{"24","输出二"}};
//		MatrixSwitchVO mv = new MatrixSwitchVO();
//		mv.setId(CenterControlObjectHelp.matrix_type_VGA);
//		mv.setIp("100.1.1.1");
//		mv.setName("分量");
//		mv.setType(CenterControlObjectHelp.matrix_type_VGA);
//		mv.setIn(in);
//		mv.setOut(out);
//		matrixSwitchList.add(mv);
		
		//IN 1-12  16-22 24
		//out 1-16 18
		
//		String[][] in2 = {{"13","输入一"},{"14","输入二"},{"15","输入三"}};
//		String[][] out2 = {{"1","输出一"},{"2","输出二"},{"3","输出三"},{"4","输出四"},{"5","输出五"}};
//		mv = new MatrixSwitchVO();
//		mv.setId(CenterControlObjectHelp.matrix_type_RGB);
//		mv.setIp("100.2.2.2");
//		mv.setName("VGA");
//		mv.setType(CenterControlObjectHelp.matrix_type_RGB);
//		mv.setIn(in2);
//		mv.setOut(out2);
//		matrixSwitchList.add(mv);
//		
//		c.setMatrixSwitchList(matrixSwitchList);
//		ArrayList<SysPowerVO> sysPowerList = new ArrayList<SysPowerVO>();
//		SysPowerVO sv = new SysPowerVO();
//		sv.setId("1");
//		sv.setName("系统电源");
//		sysPowerList.add(sv);
//		c.setSysPowerList(sysPowerList);
		
//		ArrayList<VedioTerminalVO> vedioTerminalList = new ArrayList<VedioTerminalVO>();
//		VedioTerminalVO vv = new VedioTerminalVO();
//		vv.setId("1");
//		vv.setIp("200.2.2.1");
//		vv.setName("第一终端");
//		vedioTerminalList.add(vv);
//		vv = new VedioTerminalVO();
//		vv.setId("2");
//		vv.setIp("200.2.2.2");
//		vv.setName("第二终端");
//		vedioTerminalList.add(vv);
//		vv = new VedioTerminalVO();
//		vv.setId("3");
//		vv.setIp("200.2.2.3");
//		vv.setName("第三终端");
//		vedioTerminalList.add(vv);
//		c.setVedioTerminalList(vedioTerminalList);
		
//		ArrayList<ViewScreentVO> viewScreenList = new ArrayList<ViewScreentVO>();
//		ViewScreentVO vsv = new ViewScreentVO();
//		vsv.setId("1");
//		vsv.setName("大屏");
//		String[][] s = new String[4][2];
//		s[0][0] = ViewScreentVO.screent_type_1;
//		s[0][1] = "一份屏";
//		s[1][0] = ViewScreentVO.screent_type_12;
//		s[1][1] = "12分屏";
//		s[2][0] = ViewScreentVO.screent_type_2_1;
//		s[2][1] = "二分屏";
//		s[3][0] = ViewScreentVO.screent_type_3_1;
//		s[3][1] = "三分屏";
//		vsv.setAllModel(s);
//		
//		Map<String,String> allModelSwitchOutPort	= new HashMap<String,String>();
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_1, "1");
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_12, "1,2,3,4,5,6,7,8,9,10,11,12");
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_2_1, "1,2");
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_3_1, "1,2,3");
//		 vsv.setAllModelSwitchOutPort(allModelSwitchOutPort);
//		viewScreenList.add(vsv);
//		
//		vsv = new ViewScreentVO();
//		vsv.setId("2");
//		vsv.setName("屏屏");
//		s = new String[4][2];
//		s[0][0] = ViewScreentVO.screent_type_1;
//		s[0][1] = "一份屏";
//		s[1][0] = ViewScreentVO.screent_type_12;
//		s[1][1] = "12分屏";
//		s[2][0] = ViewScreentVO.screent_type_2_1;
//		s[2][1] = "二分屏";
//		s[3][0] = ViewScreentVO.screent_type_3_1;
//		s[3][1] = "三分屏";
//		vsv.setAllModel(s);
//		allModelSwitchOutPort	= new HashMap<String,String>();
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_1, "1");
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_12, "1,2,3,4,5,6,7,8,9,10,11,12");
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_2_1, "1,2");
//		 allModelSwitchOutPort.put(ViewScreentVO.screent_type_3_1, "1,2,3");
//		 vsv.setAllModelSwitchOutPort(allModelSwitchOutPort);
//		viewScreenList.add(vsv);
//		c.setViewScreenList(viewScreenList);
//		
//		ArrayList<CameraVO> cameraList = new ArrayList<CameraVO>();
//		CameraVO cv = new CameraVO();
//		cv.setId("1");
//		cv.setName("摄像头1");
//		cameraList.add(cv);
//		c.setCameraList(cameraList);
//		
//		cv = new CameraVO();
//		cv.setId("2");
//		cv.setName("摄像头2");
//		cameraList.add(cv);
//		c.setCameraList(cameraList);
		
		return c;
	}
	
	public void initCenterControlList(){
		ArrayList<CenterControlVO> ccList = new ArrayList<CenterControlVO>();
		CenterControlVO c = new CenterControlVO();
		for(int i=1;i<5;i++){
			for(int j=1;j<255;j++){
				c = new CenterControlVO();
				c.setId("1");
				c.setIp("10.1."+i+"."+j);
				c.setPort(1550);
				c.setName(i+j+"==");
				ccList.add(c);
			}
		}
		ControlFactory.centerControlInitDate(ccList);
	}
}
