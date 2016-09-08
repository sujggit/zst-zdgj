package com.zzst.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zzst.audio.service.AudioObject;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.enc.service.ENCObject;
import com.zzst.kst.service.KstObject;
import com.zzst.kst.videocard.service.VideocardObject;
import com.zzst.mcu.service.McuObject;
import com.zzst.otherEquipment.service.OtherEquipmentObject;
import com.zzst.reach.service.ReachObject;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.vtron.service.VtronObject;



/**
 *@Description
 *@date 2011-5-27下午05:02:04
 *@author ryan
 */
public class EquipmentObjectImpl extends EquipmentObject implements EquipmentObjectProperty {
	

	/**
	 * 检查设备网络状态的超时时间
	 * 默认为10秒,以秒为单位
	 */
	public	static	long	net_status_equipment_time	=10*1000;
	
	/**
	 * 检查终端的线程，检测一遍后休眠时间
	 * 默认为10秒,以秒为单位
	 */
	public	static	long	THREAD_SLEEP_TIME	=1000*10;;
	/**
	 * 检测设备网络情况时，一个线程内检测的设备个数
	 * 默认为5个设备
	 * modfiy by ryan on 2013-12-17 取消
	 * modfiy by ryan on 2014-12-24 恢复使用
	 */
	public	static		int net_status_equipment_number = 5;

	//modify by ryan on 20140225	begin
	/**
	 * 检测终端网络情况时，一共多少线程
	 */
	public	static		int net_status_thread_number_ter = 0;
	/**
	 * 检测中控网络情况时，一共多少线程
	 */
	public	static		int net_status_thread_number_cc = 0;
	/**
	 * 检测其它设备网络情况时，一共多少线程
	 */
	public	static		int net_status_thread_number_other = 0;
	/**
	 * 检测音频设备网络情况时，一共多少线程
	 */
	public	static		int net_status_thread_number_audio = 0;
	//	modify by ryan on 20140225	end
	
	public	static		Map<String,Object>					equipmentObject_map = new HashMap<String,Object>();
	public	static		ArrayList<TerminalObject>			terminalObjectes = new	ArrayList<TerminalObject>();
	public	static		ArrayList<McuObject>				mcuObjectes = new	ArrayList<McuObject>();
	public	static		ArrayList<CenterControlObject>		centerControlObjectes = new	ArrayList<CenterControlObject>();
	public	static		ArrayList<ENCObject>				eNCObjectes = new	ArrayList<ENCObject>();
	public	static		ArrayList<VtronObject>				vtronObjectes = new	ArrayList<VtronObject>();
	public	static		ArrayList<KstObject>				KstObjectes = new	ArrayList<KstObject>();
	public	static		ArrayList<VideocardObject>			KstVideocardObjectes = new	ArrayList<VideocardObject>();
	public	static		ArrayList<AudioObject>				audioObjectes = new	ArrayList<AudioObject>();	
	public	static		ArrayList<ReachObject>				reachObjectes = new	ArrayList<ReachObject>();
	public	static		ArrayList<OtherEquipmentObject>		otherEquipmentObjectes = new	ArrayList<OtherEquipmentObject>();
	
	/**
	 * 记录终端IP
	 * @param TerminalObject
	 */
	public	static void	setTerminalIP(TerminalObject terminalObject){
		terminalObjectes.add(terminalObject);
	}
	
	/**
	 * 记录mcuip
	 * @param McuObject
	 */
	public	static void	setMcuIP(McuObject mcuObject){
		mcuObjectes.add(mcuObject);
	}
	
	/**
	 * 记录中控 
	 * @param centerControlObject
	 */
	public	static void	setCenterControlObject(CenterControlObject centerControlObject){
		centerControlObjectes.add(centerControlObject);
	}
	
	/**
	 * 提取中控 
	 * @param ArrayList<CenterControlObject>
	 */
	public	static ArrayList<CenterControlObject>	getCenterControlObject(){
		return centerControlObjectes;
	}
	
	
	/**
	 * 提前终端
	 * @param ArrayList<TerminalObject>
	 */
	public	static ArrayList<TerminalObject>	getTerminalObject(){
		return terminalObjectes;
	}
	
	/**
	 * 提前其他设备
	 * @param ArrayList<TerminalObject>
	 */
	public	static ArrayList<OtherEquipmentObject>	getOtherEquipmentObject(){
		return otherEquipmentObjectes;
	}
	
	/**
	 * 记录音频设备
	 * @param AudioObject
	 */
	public	static void	setAudioObject(AudioObject audioObject){
		audioObjectes.add(audioObject);
	}
	/**
	 * 记录ENC 
	 * @param ENCObject
	 */
	public	static void	setENCObject(ENCObject eNCObject){
		eNCObjectes.add(eNCObject);
	}
	
	/**
	 * Vtron
	 * @param VtronObject
	 */
	public	static void	setVtronObject(VtronObject obj){
		vtronObjectes.add(obj);
	}
	
	/**
	 * INS
	 * @param VtronObject
	 */
	public	static void	setKstObject(KstObject obj){
		KstObjectes.add(obj);
	}
	
	/**
	 * 可视通-视频对比卡
	 * @param VideocardObject
	 */
	public	static void	setKstVideocardObject(VideocardObject obj){
		KstVideocardObjectes.add(obj);
	}
	
	/**
	 * 锐取录播服务器
	 * @param ReachObject
	 */
	public	static void	setReachObject(ReachObject obj){
		reachObjectes.add(obj);
	}
	
	/**
	 * 其他设备
	 * @param ReachObject
	 */
	public	static void	setOtherEquipmentObject(OtherEquipmentObject obj){
		otherEquipmentObjectes.add(obj);
	}
	
	/**
	 * 返回设备类型
	 * @param ip
	 * @return
	 */
	public static int	checkEquipmentType(String ip){
		 if(checkTerminalIP(ip)) return EQUIPMENT_TYPE_TERMINAL;
		 if(checkMcuIP(ip))		 return	EQUIPMENT_TYPE_MCU;
		 
		 return Integer.MIN_VALUE;
	}
	
	/**
	 * 根据ip检查是否有这个终端
	 * @param ip
	 * @return	boolean
	 */
	public static boolean checkTerminalIP(String ip) {
		if(ip==null||ip.length()<0) return false;
		
		for(TerminalObject terminalObject : terminalObjectes){
			if(ip.equalsIgnoreCase(terminalObject.getTerminalIp())||ip.equalsIgnoreCase(terminalObject.getOuterNetIp())) return true;
		}
		return false;
	}

	/**
	 * 根据ip检查是否有这个mcu
	 * @param ip
	 * @return	boolean
	 */
	public static boolean checkMcuIP(String ip) {
		if(ip==null||ip.length()<0) return false;
		
		for(McuObject mcuObject : mcuObjectes){
			if(ip.equalsIgnoreCase(mcuObject.getMcuIP())) return true;
		}
		return false;
	}
	
	/**
	 * 兼容终端2个ip情况
	 * @param ip
	 * @return
	 */
	public static	 String getTerminalIp(String ip){
		String reIp = "";
		Object obj = equipmentObject_map.get(ip);
		if(obj == null){
			for(TerminalObject t : terminalObjectes){
				if(t.getOuterNetIp().equalsIgnoreCase(ip))
					reIp = t.getTerminalIp();
			}
		}else{
			reIp = ip;	
		}
		return reIp;
	}
	
	/**
	 * @param ip
	 * @return
	 */
	public static	Object	getEquipmentObject(int type ,String ip){
		if(ip==null||ip.length()<0) return null;
		if(EQUIPMENT_TYPE_TERMINAL==type){
			ip = getTerminalIp(ip);	
		}
		
		return equipmentObject_map.get(ip);
	}
	
	public static	boolean	setEquipmentObject(int equipmentType,String ip,Object obj){
		if(obj==null) return false;
		if(ip==null||ip.length()<0)	return false;
		
		equipmentObject_map.put(ip, obj);
		
		switch (equipmentType) {
		     case EQUIPMENT_TYPE_TERMINAL:			
		    	 setTerminalIP((TerminalObject)obj);	break;
		     case EQUIPMENT_TYPE_MCU:				
		    	 setMcuIP((McuObject)obj);			break;
		     case EQUIPMENT_TYPE_RSS:							
		    	 break;
		     case EQUIPMENT_TYPE_AUDIO:				
		    	 setAudioObject((AudioObject)obj); break;
		     case EQUIPMENT_TYPE_CENTERCONTROL:		
		    	 setCenterControlObject((CenterControlObject)obj);			break;
		     case EQUIPMENT_TYPE_ENC:				
		    	 setENCObject((ENCObject)obj);			break;
		     case EQUIPMENT_TYPE_VTRON:				
		    	 setVtronObject((VtronObject)obj);			break;
		     case EQUIPMENT_TYPE_KST:				
		    	 setKstObject((KstObject)obj);			break;		     
		     case EQUIPMENT_TYPE_KST_VIDEOCARD:		
		    	 setKstVideocardObject((VideocardObject)obj);break;	
		     case EQUIPMENT_TYPE_REACH:		
		    	 setReachObject((ReachObject)obj);break;	
		     case EQUIPMENT_TYPE_OTHER:		
		    	 setOtherEquipmentObject((OtherEquipmentObject)obj);break;	
		     
		     default:	break;
		}
		return true;
	}
	  
	
	/**
	 * 设置检测设备网络情况时，一个线程内检测的设备个数
	 * 设置定期检查设备网络状态的时间间隔
	 * @param	number	默认为5个设备 不大于0即为使用默认
	 * @param	time	默认为10秒,以秒为单位	不大于0即为使用默认
	 * @return	boolean
	 * add by ryan on 20140224
	 */
	public boolean setNetStatusEquipment(int number, long time) {
		if(number>0)
			net_status_equipment_number = number;
		else
			net_status_equipment_number = 5;
		if(time>0)
			THREAD_SLEEP_TIME = time*1000;
		else
			THREAD_SLEEP_TIME = 1000*10;
		return true;
	}
	
	@Override
	/**
	 * add by ryan on	20140225
	 */
	public ArrayList<String[]> getThreads() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	/**
	 * add by ryan on	20140225
	 */
	public boolean startEquipmentNetStatusThreads(String[] ips) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	/**
	 * add by ryan on	20140225
	 */
	public boolean startEquipmentNetStatusThreads(String equipmentType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * add by ryan on	20140225
	 */
	public boolean stopEquipmentNetStatusThreads(String[] ips) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * add by ryan on	20140225
	 */
	public boolean stopEquipmentNetStatusThreads(String equipmentType) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 终端设备线程个数增加一个
	 * @return int
	 */
	public static void setNetStatusThreadNumber(int equipmentType) {
		switch(equipmentType){
			 case EquipmentObject.EQUIPMENT_TYPE_TERMINAL:			
				EquipmentObjectImpl.net_status_thread_number_ter++;
				break;
		     case EquipmentObject.EQUIPMENT_TYPE_MCU:				
		    	 
		    	 break;
		     case EquipmentObject.EQUIPMENT_TYPE_RSS:							
		    	 
		    	 break;
		     case EquipmentObject.EQUIPMENT_TYPE_AUDIO:				
		    	 EquipmentObjectImpl.net_status_thread_number_audio++;
		    	 break;
		     case EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL:		
		    	 EquipmentObjectImpl.net_status_thread_number_cc++; 
		    	 break;
		     case EquipmentObject.EQUIPMENT_TYPE_ENC:				
		    	 
		    	 break;
		     case EquipmentObject.EQUIPMENT_TYPE_VTRON:				
		    	 
		    	 break;
		     case EquipmentObject.EQUIPMENT_TYPE_KST:				
		    	 
		    	 break;		     
		     case EquipmentObject.EQUIPMENT_TYPE_KST_VIDEOCARD:		
		    	 
		    	 break;	
		     case EquipmentObject.EQUIPMENT_TYPE_REACH:		
		    	 
		    	 break;	
		     case EquipmentObject.EQUIPMENT_TYPE_OTHER:		
		    	 EquipmentObjectImpl.net_status_thread_number_other++;
		    	 break;	
		     
		     default:	break;
		}
	}
}
