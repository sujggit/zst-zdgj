package com.zzst.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.audio.service.AudioObject;
import com.zzst.audio.service.impl.AudioServiceImpl;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.service.impl.CenterControlImpl;
import com.zzst.centerContor.vo.CenterControlVO;
import com.zzst.enc.service.ENCObject;
import com.zzst.enc.service.ENCObjectHelp;
import com.zzst.enc.service.impl.ENCObjectImpl;
import com.zzst.kst.service.KstObject;
import com.zzst.kst.service.impl.KstObjectImpl;
import com.zzst.kst.service.impl.vo.KstVO;
import com.zzst.kst.videocard.service.VideocardObject;
import com.zzst.kst.videocard.service.icmp.VideocardObjectImpl;
import com.zzst.kst.videocard.vo.VideoCardVO;
import com.zzst.mcu.service.McuObject;
import com.zzst.mcu.service.impl.MCUClientThread;
import com.zzst.mcu.service.impl.MCUServiceImpl;
import com.zzst.otherEquipment.service.OtherEquipmentObject;
import com.zzst.otherEquipment.service.impl.OtherEquipmentObjectImpl;
import com.zzst.reach.service.ReachObject;
import com.zzst.reach.service.impl.ReachObjectImpl;
import com.zzst.reach.service.vo.ReachVO;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.TerminalImpl;
import com.zzst.util.equipment.EquipmentNetStatusOperate;
import com.zzst.util.initDate.DBHelp;
import com.zzst.util.snmp.SnmpTrapParse;
/**
 *  对外提供的所有控制接口
 *@author	ryan
 *@since	2010-11-15上午11:31:23
 *@version	1.0
 */

public class ControlFactory{
	private static Logger logger = Logger.getLogger(ControlFactory.class
			.getName());
	
	public  static void main(String[] arge){ 
	
	}
	//////逐步替换、、、、、、、、、、、开始
	/**
	 * 提取终端对象     不再使用
	 * @param ip
	 * @return	null
	 * @throws ZZSTControlException
	 * delete	on 2014-02-25	by ryan
	 */
//	public	static	TerminalImpl	getTerminalImpl(String ip)throws ZZSTControlException{
//		return	null;//new TerminalImpl(ip);
//	}
	
	/**
	 * 开启接受终端返回信息的线程，建议在系统启动时加载
	 * @param ip
	 * 
	 * modify	on 2011-07-08	by ryan
	 * delete	on 2014-02-25	by ryan	
	 */
//	public	static void	getReturnThread(String ip){
//		if(ip!=null&&ip.length()>0){
//			ExecutorServiceHelp.executorService.execute(new TerminalClientThreadByReturn(ip,24,"","",true));	
//		}
//	}
	
	/**
	 * 启动支持mpv2版本的snmp协议下 trap终端信息的线程
	 * @param ip
	 * @throws ZZSTControlException
	 * 
	 * modify	on 2011-07-08	by ryan
	 * delete	on 2014-02-25	by ryan
	 */
//	public	static	void	terminalInitSys(String ip)throws ZZSTControlException{
//		//首先  询问所有状态
//		ExecutorServiceHelp.executorService.execute(new TerminalClientThreadByReturn(ip,24,"","",true));
//	}
	
	//////逐步替换、、、、、、、、、、结束
	
	

	/**
	 * 检测设备网络情况时，一个线程内检测的设备个数
	 * 默认为5个设备
	 * @return	int
	 * add by ryan on 20140224
	 */
	public static	int getEquipmentThreadNnumber(){
		return EquipmentObjectImpl.net_status_equipment_number;
	}
	
	/**
	 * 定期检查设备网络状态的时间间隔
	 * 默认为10秒,以秒为单位
	 * @return long
	 * add by ryan on 20140224
	 */
	public static	long getEquipmentThreadSleepTime(){
		return	EquipmentObjectImpl.net_status_equipment_time;
	}
	
	/**
	 * 开启一类设备的状态检测线程，网络状态正常才能控制设备
	 * @param	equipmentType	如：EquipmentObject.EQUIPMENT_TYPE_TERMINAL
	 * @return boolean
	 * add by ryan on 20140225
	 */
	public static	boolean	startEquipmentNetStatusThreads(int equipmentType){
		return EquipmentNetStatusOperate.startEquipmentNetStatusThreads(equipmentType);
	}
	
	/**
	 * 关闭一类设备的状态检测线程，网络状态正常才能控制设备
	 * @param	equipmentType	如：EquipmentObject.EQUIPMENT_TYPE_TERMINAL
	 * @return boolean
	 * add by ryan on 20140225
	 */
	public static	boolean	stopEquipmentNetStatusThreads(int equipmentType){
		return EquipmentNetStatusOperate.stopEquipmentNetStatusThreads(equipmentType);
	}
	
	/**
	 * 停止对设备状态的检测
	 * 设备状态设置为未知状态
	 * @return boolean
	 * add by ryan on 20140225
	 */
	public static	boolean	stopEquipmentNetStatusThreads(String[] ips){
		return EquipmentNetStatusOperate.stopEquipmentNetStatusThreads(ips);
	}
	
	/**
	 * 继续检测设备网络情况
	 * 针对执行stopEquipmentNetStatusThreads后的终端
	 * @return boolean
	 * add by ryan on 20140225
	 */
	public static	boolean	recoverEquipmentNetStatusThreads(String[] ips){
		return EquipmentNetStatusOperate.recoverEquipmentNetStatusThreads(ips);
	}
	
	/**
	 * 设置
	 * 检测设备网络情况时，一个线程内检测的设备个数
	 * 线程内检查一遍后等待的时间
	 * @param	number	默认为5个设备 不大于0即为使用默认
	 * @param	time	默认为10秒,以秒为单位	不大于0即为使用默认
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public static	boolean setEquipmentParam(int number,long time){
		return new EquipmentObjectImpl().setNetStatusEquipment(number, time);
	}
	
	
	/////////////////add by   zhangdq	2011-03-22/////////////////////////////////////////////
	
	///////////元嘉告示------------add by ryan on 2012-04-17---
	/**
	 * 提取告示终端对象
	 * @return ENCObject
	 */
	public static	ENCObject getEncObject(){
		if(ENCObjectHelp.serverIp==null||ENCObjectHelp.serverIp.length()==0){
			logger.error("没有注册告示服务器");
			return null;
		}
		ENCObject obj = new ENCObjectImpl();
//		ENCObject obj = (ENCObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_ENC,ip);
//		if(obj==null)	return null;

		return obj;
	}
	
	/**
	 * 注册告示终端设备
	 * String[] obj
	 * 0 ip
	 * 1 mac
	 * 2 url
	 * @return	
	 */
//	public	static	boolean	eNCObjectInitDate(Map<String,String[]> map){
//		boolean	ifRight	=	true;
//		
//		Collection<String[]>	c 	=	map.values();
//		Iterator<String[]>	i		=	c.iterator();
//		while(i.hasNext()){
//			String[] encInfo = (String[])i.next();
//			if(encInfo==null||encInfo.length<3) continue;
//			
//			ENCObject obj = new ENCObjectImpl(encInfo);
//			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_ENC,obj.getIp(), obj)) ifRight = false;
//		}
//		return ifRight;
//	}
	
	/**
	 * 注册告示服务器设备
	 * String[] obj
	 * 0 serverIp
	 * 1 serverName
	 * 2 serverPas
	 * 3 db-url
	 * 4 db-name
	 * 5 db-pas
	 * 6 db-type
	 * 7 ftpIp
	 * 8 ftpName
	 * 9 ftpPas
	 * @return
	 */
	public	static	boolean	eNCServerDate(String[] str){
		if(str==null||str.length<10) return false;
		
		ENCObjectHelp.serverIp   = str[0];
		ENCObjectHelp.serverName = str[1];
		ENCObjectHelp.serverPas  = str[2];
		DBHelp.enc_db_url	= str[3];
		DBHelp.enc_db_name = str[4];
		DBHelp.enc_db_password = str[5];
		DBHelp.enc_db_type	= str[6];
		
		ENCObjectHelp.ftpIp	= str[7];
		ENCObjectHelp.ftpName = str[8];
		ENCObjectHelp.ftpPas = str[9];
		
		return true;
	}
	
//////////////其他设备开始=---------------------------------------------------
	
	/**
	 * 提取所有其它设备对象
	 * @return ArrayList<OtherEquipmentObject>
	 */
	public static	ArrayList<OtherEquipmentObject> getAllOtherEquipmentObject(){
		return EquipmentObjectImpl.getOtherEquipmentObject();
	}
	/**
	 * 根据IP提取设备对象
	 * @return OtherEquipmentObject
	 */
	public static	OtherEquipmentObject getOtherEquipmentObject(String ip){
		OtherEquipmentObject obj = (OtherEquipmentObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_OTHER,ip);
		if(obj==null)	return null;
		return obj;
	}
	
	
	/**
	 * 初始化设备基础数据,在系统启动时加载
	 * map key ip value string[]
	 * Stirng[] 
	 * 0	id
	 * 1	ip 
	 * 2	port
	 * 3	name
	 * @return	boolean
	 */
	public	static	boolean	otherEquipmentInitDate(Map<String,String[]> map){
		//设备注册
		Iterator<String[]>	i	=	map.values().iterator();
		while(i.hasNext()){
			String[] info = (String[])i.next();
			OtherEquipmentObject obj = new OtherEquipmentObjectImpl(info);
			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_OTHER,obj.getIp(), obj)) return false;
//			logger.info("启动检测设备网络状态线程");
//			CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+10*1000), new OtherEquipmentNetStatus(System.currentTimeMillis()+obj.getIp(),obj.getIp(),null));
		}
		return true;
	}
	
	/**
	 * 开启注册的所有其他设备
	 * 检查端口是否正常连接或者是ping ip是否正常
	 * delete by ryan on 20140225	所有设备统一检查网络情况
	 */
//	public static void callInspectOtherEquipmentNetStatus(){
//		 ArrayList<OtherEquipmentObject>	list 	=	EquipmentObjectImpl.getOtherEquipmentObject();
//		 for(OtherEquipmentObject obj : list){
//			 if(obj.getIp()==null||obj.getIp().length()==0) continue;//应该完善为正则表达式
//			 
////			 ScheduledExecutorService scheduler=(ScheduledExecutorService) Executors.newSingleThreadScheduledExecutor();
//			 OtherEquipmentNetStatusFutureTask ct=new OtherEquipmentNetStatusFutureTask(obj.getIp());
//			 
//			 FutureTask<Boolean> futureTask=new FutureTask<Boolean>(ct);
//			 
//			 new Thread(futureTask,"检查"+obj.getIp()+"状态的子线程").start();  
//			 
////			 scheduler.schedule(futureTask,1,TimeUnit.SECONDS);
//			 
//			 OtherEquipmentObjectHelp.threadMap.put(obj.getIp(), ct);
//		 }
//	}
	
	/**
	 * 关闭 注册的所有其他设备
	 * 检查端口是否正常连接或者是ping ip是否正常
	 *
	 */
//	public static void quitInspectOtherEquipmentNetStatus(){
//		for(Iterator i=OtherEquipmentObjectHelp.threadMap.entrySet().iterator();i.hasNext();){   
//			Map.Entry entry=(Map.Entry)i.next();   
//			OtherEquipmentNetStatusFutureTask task = (OtherEquipmentNetStatusFutureTask)entry.getValue();
//			task.quit();  
//		}   
//	}
	
/////////////其他设备结束	-----------------------------------
	
//////////////音频开始=---------------------------------------------------
	
	public static	AudioObject getAudioObject(String ip){
		AudioObject obj = (AudioObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_AUDIO,ip);
		if(obj==null)	return null;
		return obj;
	}
	
	
	/**
	 * 初始化音频设备基础数据,在系统启动时加载
	 * map key ip value string[]
	 * Stirng[] 
	 * 0 ip
	 * 1 port
	 * 2 名称
	 * @return	boolean
	 */
	public	static	boolean	audioInitDate(Map<String,String[]> map){
		//设备注册
		Iterator<String[]>	i		=	map.values().iterator();
		while(i.hasNext()){
			String[] info = (String[])i.next();
			AudioObject obj = new AudioServiceImpl(info);
			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_AUDIO,obj.getIp(), obj)) return false;
			/**
			 * modify by ryan on	20140225	调整为所有设备统一处理。equipmentNetStatusTask
			 */
//			logger.info("启动检测设备网络状态线程");
//			CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+15*1000), new AudioNetStatus(System.currentTimeMillis()+obj.getIp(),obj.getIp(),null),"音频设备（"+obj.getIp()+")检查网络情况");
			
		}
		return true;
	}
	
/////////////音频结束	-----------------------------------
	///////////终端开始----------------------------------------
	
	/**
	 * 提取所有终端对象
	 * @return ArrayList<TerminalObject>
	 */
	public static	ArrayList<TerminalObject> getAllTerminalObject(){
		return EquipmentObjectImpl.getTerminalObject();
	}
	
	/**
	 * 提取终端对象，可以调用终端所有功能
	 * @param 终端内网IP
	 * @return TerminalObject
	 */
	public static	TerminalObject getTerminalObject(String ip){
		TerminalObject obj = (TerminalObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_TERMINAL,ip);
		if(obj==null)	return null;
		
		return obj;
	}
	
	
	/**
	 * 初始化终端基础数据,在系统启动时加载。
	 * 数据长度或格式不对，直接返回false
	 * @param map	key :terminalIP ;value	String[]
	 * 数组存储的结构
	 * 0:ip
	 * 1:phone
	 * 2:远程控制登陆名 ：默认为admin。影响控制
	 * 3：远程控制登陆密码
	 * 4:外网ip
	 * 5:会议室登陆名 ：默认为admin。不影响控制
	 * 6：会议室登陆密码
	 * 7:终端设备类型。
	 * @return	boolean
	 */
	public	static	boolean	terminalInitDate(Map<String,String[]> map){
		//设备注册
		Collection<String[]>	c 	=	map.values();
		Iterator<String[]>	i		=	c.iterator();
		while(i.hasNext()){
			String[] terminalInfo = (String[])i.next();
			if(terminalInfo==null){
				logger.warn("终端对象为空，该终端加载失败");
				continue;
			}
			if(terminalInfo.length!=8){
				logger.warn("终端("+terminalInfo[0]+")对象应该拥有8个属性，该终端加载失败");
				continue;
			}
			boolean mark = true;
			for(String s : terminalInfo){
				if(s==null){
					logger.warn("终端("+terminalInfo[0]+")属性为空,该终端加载失败");
					mark = false;
					break;
				}
			}
			if(mark){
				TerminalObject obj = new TerminalImpl(terminalInfo);
				if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_TERMINAL,obj.getTerminalIp(), obj)) return false;
			}

			/**
			 * modify by ryan on	20140225	调整为所有设备统一处理。equipmentNetStatusTask
			 */
//			方式一：一个设备一个线程检测网络状态
//			CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+2*1000), new TerminalNetStatusTask(System.currentTimeMillis()+obj.getTerminalIp(),obj.getTerminalIp(),null),"终端设备（"+obj.getTerminalIp()+")检查网络情况");
//			方式二：定时询问23端口是否通，超过N个终端是在不同的线程内检测
//			int number = EquipmentObjectImpl.getTerminalObject().size();
//			if(number>0){
//				int startNum = EquipmentObjectImpl.net_status_equipment_number*TerminalObject.getNetStatusThreadNumber();
//				int endNum = startNum+EquipmentObjectImpl.net_status_equipment_number;
//				if(number>startNum){
//					logger.info("启动检测终端网络状态线程");
//					CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+2*1000),new TerminalNetStatusTask2(System.currentTimeMillis()+"",null,startNum),"终端设备（"+startNum+"到"+endNum+")检查网络情况");
//					EquipmentObjectImpl.setNetStatusThreadNumber(EquipmentObject.EQUIPMENT_TYPE_TERMINAL);
//				}
//			}
		}
		return true;
	}
	
	/////////-----------------------------mcu部分开始-------------------------
	/**
	 * 开启接受MCU返回信息的线程，在系统启动时加载
	 * @param ip
	 */
	public	static	void	mcuInitSysThread(String ip)throws ZZSTControlException{
		MCUClientThread.initSysThread(ip);
	}
	
	/**
	 * 初始化mcu基础数据,在系统启动时加载
	 * @param	map	key :mcuIP ;value	String[]
	 * 数组存储的结构
	 * 0:mcuIP
	 * 1:mcuType
	 * 2:信令地址
	 * 3:登录名
	 * 4:登录密码
	 * 5:父节点IP
	 * @return	boolean
	 */
	public static boolean	mcuInitDate(Map<String,String[]> map){
		boolean	ifRight	=	true;
		
		Collection<String[]>	c 	=	map.values();
		Iterator<String[]>	i		=	c.iterator();
		while(i.hasNext()){
			String[] mcuInfo = (String[])i.next();
			if(mcuInfo==null||mcuInfo.length!=7) continue;
			
			MCUServiceImpl obj =new MCUServiceImpl(mcuInfo); 
			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_MCU,obj.getMcuIP(), obj)) ifRight = false;
		}
		return ifRight;
	}
	
	/**
	 * 对外提供mcu对象
	 * @param ip
	 * @return McuObject
	 */
	public static	McuObject getMcuObject(String ip){
		McuObject obj = (McuObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_MCU,ip);
		if(obj==null)	return null;
		
		return obj;
	}
	
	/////////-----------------------------mcu部分结束-------------------------
	
	
	
	/////////-----------------------------中控部分开始-------------------------
	/**
	 * 提取所有中控对象
	 * @return ArrayList<CenterControlObject>
	 */
	public static	ArrayList<CenterControlObject> getAllCenterControlObject(){
		return EquipmentObjectImpl.getCenterControlObject();
	}
	
	/**
	 * 加载中控部分基础数据
	 * @param ArrayList<CenterControlVO>
	 * @return boolean boolean
	 */
	public static boolean	centerControlInitDate(ArrayList<CenterControlVO> list){
		boolean	ifRight	=	true;
		for(CenterControlVO vo : list){
			if(vo==null) continue;
			CenterControlImpl obj =new CenterControlImpl(vo); 
			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL,obj.getIP(), obj)) ifRight = false;
			/**
			 * modify by ryan on	20140225	调整为所有设备统一处理。equipmentNetStatusTask
			 */
//			定时询问端口是否通
//				logger.info("启动检测中控网络状态线程");
//				方式一：
//				CjfTimerHelper.addTaskPeriod(10*1000, 30*1000, new CCNetStatusTask(System.currentTimeMillis()+vo.getIp(),vo.getIp(),null));
//				方式二：
//				CjfTimerHelper.addTimerTask(new Timestamp(System.currentTimeMillis()+10*1000), new CCNetStatusTask(System.currentTimeMillis()+vo.getIp(),vo.getIp(),null),"中控设备（"+obj.getIP()+")检查网络情况");
		}
		return ifRight;
	}
	
	/**
	 * 对外提供中控对象，支持中控下的所有设备控制
	 * @param ip
	 * @return CenterControlObject
	 */
	public static	CenterControlObject getCenterControlObject(String ip){
		CenterControlObject obj = (CenterControlObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL,ip);
		if(obj==null)	return null;
		
		return obj;
	}
	
	/////////-----------------------------中控部分结束-------------------------
	
/////////-----------------------------威创图像处理器部分开始-------------------------
	
//	/**
//	 * 加载威创图像处理器部分基础数据
//	 */
//	public static boolean	vtronInitDate(ArrayList<VtronVO> list){
//		boolean	ifRight	=	true;
//		for(VtronVO vo : list){
//			if(vo==null) continue;
//			if(vo.getIp()==null) continue;
//			VtronObjectImpl obj =new VtronObjectImpl(vo); 
//			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_VTRON,vo.getIp(), obj)) ifRight = false;
//		}
//		return ifRight;
//	}
//	
//	/**
//	 * 对外提供处理器对象
//	 * @param ip
//	 * @return
//	 */
//	public static	VtronObject getVtronObject(String ip){
//		VtronObject obj = (VtronObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_VTRON,ip);
//		if(obj==null)	return null;
//		
//		return obj;
//	}
	/////////-----------------------------威创图像处理器部分结束-------------------------
	
/////////-----------------------------可视通部分开始-------------------------
	
	/**
	 * 加载可视通基础数据
	 * @param ArrayList<KstVO>
	 * @return boolean
	 */
	public static boolean	kstInitDate(ArrayList<KstVO> list){
		boolean	ifRight	=	true;
		for(KstVO vo : list){
			if(vo==null) continue;
			if(vo.getIp()==null) continue;
			KstObjectImpl obj =new KstObjectImpl(vo); 
			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_KST,vo.getIp(), obj)) ifRight = false;
		}
		return ifRight;
	}
	/**
	 * 加载可视通视频比对卡基础数据
	 * @param ArrayList<KstVO>
	 * @return boolean
	 */
	public static boolean	kstVideocardInitDate(ArrayList<VideoCardVO> list){
		boolean	ifRight	=	true;
		for(VideoCardVO vo : list){
			if(vo==null) continue;
			if(vo.getIp()==null) continue;
			VideocardObject obj =new VideocardObjectImpl(vo); 
			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_KST_VIDEOCARD,vo.getIp(), obj)) ifRight = false;
		}
		return ifRight;
	}
	
	/**
	 * 对外提供对象
	 * @param ip
	 * @return KstObject
	 */
	public static	KstObject getKstObject(String ip){
		KstObject obj = (KstObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_KST,ip);
		if(obj==null)	return null;
		return obj;
	}
	
	/**
	 * 对外提供视频比对卡的对象
	 * @param ip
	 * @return KstObject
	 */
	public static	VideocardObject getKstVideocardObject(String ip){
		VideocardObject obj = (VideocardObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_KST_VIDEOCARD,ip);
		if(obj==null)	return null;
		return obj;
	}
	/////////-----------------------------可视通部分结束-------------------------
	
/////////-----------------------------锐取部分开始-------------------------
	/**
	 * 加载锐取基础数据
	 * @param ArrayList<ReachVO>
	 * @return boolean
	 */
	public static boolean	ReachInitDate(ArrayList<ReachVO> list){
		boolean	ifRight	=	true;
		for(ReachVO vo : list){
			if(vo==null) continue;
			if(vo.getServerIP()==null) continue;
			ReachObject obj =new ReachObjectImpl(vo); 
			if(!EquipmentObjectImpl.setEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_REACH,vo.getServerIP(), obj)) ifRight = false;
		}
		return ifRight;
	}
	
	/**
	 * 对外提供对象
	 * @param ip
	 * @return ReachObject
	 */
	public static	ReachObject getReachObject(String ip){
		ReachObject obj = (ReachObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_KST,ip);
		if(obj==null)	return null;
		return obj;
	}
	
/////////-----------------------------锐取部分结束-------------------------
	
	/**
	 * 初始化服务器IP
	 * @param serverIP 
	 * @return boolean
	 */
	public static boolean	snmpInitDate(String serverIP){
		SnmpTrapParse TrapSnmp = new SnmpTrapParse(serverIP,SnmpTrapParse.mpv2);
		TrapSnmp.startListen();
		return true;
	}
	
	/////////------------初始化数据库-------------------------------------------
	/**
	 * 初始化数据库信息IP
	 * @param serverIP 
	 * @return boolean
	 */
	public static boolean	dbInitDate(String db_type,String db_name,String db_password,String db_url){
		DBHelp.db_name=db_name;
		DBHelp.db_password=db_password;
		DBHelp.db_url=db_url;
		DBHelp.db_type=db_type;
		return true;
	}
	
	
}
