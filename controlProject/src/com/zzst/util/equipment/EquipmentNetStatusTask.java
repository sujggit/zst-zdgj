package com.zzst.util.equipment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.audio.service.AudioObject;
import com.zzst.centerContor.service.CenterControlObject;
import com.zzst.centerContor.service.CenterControlObjectHelp;
import com.zzst.centerContor.service.impl.communication.ReturnValueThread;
import com.zzst.otherEquipment.service.OtherEquipmentObject;
import com.zzst.reach.service.ReachObject;
import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.communication.TerminalClientThreadByReturn;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ServerSocketEnues;
import com.zzst.util.SystemConfig;
import com.zzst.util.timerTask.CjfTimeTask;


/**
 *@Description
 *检查设备网络是否可达
 *@date 2014-2-25下午05:08:22
 *@author ryan
 */
public class EquipmentNetStatusTask  extends CjfTimeTask{
	private static Logger logger = Logger.getLogger(EquipmentNetStatusTask.class.getName());
	private	boolean	loop = true;
	private String ips ;
	
	private boolean isTerminal = false;
	
	/**
	 * 记录线程内中控设备最后一次发送心跳的时间
	 */
	private Map<String,Long> heartbeatTime=new HashMap<String,Long>();
	
	/**
	 * 线程内处理的所有设备IP，多个IP“,”分割
	 * @return	String
	 */
	public String getIps() {
		return ips;
	}

	/**
	 * 
	 * @param timeTaskID
	 * @param timeTaskName	设备类型
	 * @param taskObject	开始的序号
	 */
	public EquipmentNetStatusTask(String timeTaskID, String timeTaskName, Object taskObject) {
		super(timeTaskID, timeTaskName, taskObject);
	}

	public void setLoop(boolean loop){
		this.loop	=	loop;
	}
	
	@Override
	public boolean excuteTask() {
		if(this.getTaskObject()==null||this.getTimeTaskName()==null)	return false;
		int	type	=	Integer.valueOf(this.getTimeTaskName()).intValue();
		int startNumber = ((Integer)this.getTaskObject()).intValue();
		
		while(loop){
			int endNumber = startNumber+EquipmentObjectImpl.net_status_equipment_number;
			ArrayList	list = null;
			switch(type){
				case EquipmentObject.EQUIPMENT_TYPE_TERMINAL:	
					list = EquipmentObjectImpl.getTerminalObject();break;
				case EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL:
					list = EquipmentObjectImpl.getCenterControlObject();break;			    			
				case EquipmentObject.EQUIPMENT_TYPE_AUDIO:
					list = EquipmentObjectImpl.audioObjectes;break;	
			    case EquipmentObject.EQUIPMENT_TYPE_OTHER:	
			    	list = EquipmentObjectImpl.getOtherEquipmentObject();break;	
			    case EquipmentObject.EQUIPMENT_TYPE_REACH:	
			    	list = EquipmentObjectImpl.reachObjectes;break;	
				default:	break;
			}
			if(list==null||list.size()==0){
				loop = false;
				continue;
			}else if(list.size()<endNumber){
				endNumber = list.size();
			}
			
			//检测完一圈等待、只检测到endNumber个设备
			try{
				Thread.sleep(EquipmentObjectImpl.THREAD_SLEEP_TIME);	
			}catch(Exception e){}

			StringBuffer sb = new StringBuffer();
			for(int i=startNumber;i<endNumber;i++){
				if(!loop) return true;//结束线程时，立即跳出循环
				
				Object ccobj =	list.get(i);
				if(ccobj==null)	continue;
				switch(type){
					case EquipmentObject.EQUIPMENT_TYPE_TERMINAL:
						if(!isTerminal){
							TerminalObject obj = (TerminalObject)list.get(i);
							sb.append(obj.getTerminalIp()+",");
							if(EquipmentNetStatusOperate.stopCheckNetIPMap.get(obj.getTerminalIp())==null)//是否检测该设备
								terminal(obj,startNumber,endNumber);
							else
								obj.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);//设备状态恢复为未知
						}
						break;
					case EquipmentObject.EQUIPMENT_TYPE_CENTERCONTROL:
						CenterControlObject objc = (CenterControlObject)list.get(i);
						sb.append(objc.getIP()+",");
						if(EquipmentNetStatusOperate.stopCheckNetIPMap.get(objc.getIP())==null)//是否检测该设备
							cc(objc,startNumber,endNumber);
						else
							objc.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);
						break;			    			
					case EquipmentObject.EQUIPMENT_TYPE_AUDIO:
						AudioObject obja = (AudioObject)list.get(i);
						sb.append(obja.getIp()+",");
						if(EquipmentNetStatusOperate.stopCheckNetIPMap.get(obja.getIp())==null)//是否检测该设备
							audio(obja,startNumber,endNumber);
						else
							obja.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);
						break;
				     case EquipmentObject.EQUIPMENT_TYPE_OTHER:
				    	 OtherEquipmentObject objo = (OtherEquipmentObject)list.get(i);
				    	 sb.append(objo.getIp()+",");
				    	 if(EquipmentNetStatusOperate.stopCheckNetIPMap.get(objo.getIp())==null)//是否检测该设备
				    		 otherEquipment(objo,startNumber,endNumber);
				    	 else
				    		 objo.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);
				    	 break;
				     case EquipmentObject.EQUIPMENT_TYPE_REACH:
				    	 ReachObject objrb = (ReachObject)list.get(i);
				    	 sb.append(objrb.getVo().getServerIP()+",");
				    	 if(EquipmentNetStatusOperate.stopCheckNetIPMap.get(objrb.getVo().getServerIP())==null)//是否检测该设备
				    		 reachEquipment(objrb,startNumber,endNumber);
				    	 else
				    		 objrb.setStatus(SystemConfig.METHED_WITHIN,ReachObject.status_def);
				    	 break;
					default:	break;
				}
			}
			isTerminal = true;
			ips = sb.toString();
		}
		return true;
	}
	
	private void reachEquipment(ReachObject obj,int startNumber,int endNumber){
		String ip = obj.getVo().getServerIP();
		int port = obj.getVo().getServerPort();
		String status_n = getSocket(ip,port);
		
		if(obj.getStatus()==null||obj.getStatus().equalsIgnoreCase(""))
			obj.setStatus(SystemConfig.METHED_WITHIN,ReachObject.status_def);
		
		if(ReachObject.status_def.equalsIgnoreCase(obj.getStatus())){
			String sta = "网络异常";
			if(ReachObject.status_on.equalsIgnoreCase(status_n))
				sta = "网络正常";
			logger.warn("第一次检查（"+ip+"）的("+port+")端口"+sta);
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
		
		if(!obj.getStatus().equalsIgnoreCase(status_n)){
			if(ReachObject.status_off.equalsIgnoreCase(status_n)){
				logger.warn("检查（"+ip+"）的端口("+port+")网络异常");
			}else if(ReachObject.status_on.equalsIgnoreCase(status_n)){
				logger.warn("检查（"+ip+"）的端口("+port+")网络在线");
			}
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
	}
	
	private void otherEquipment(OtherEquipmentObject obj,int startNumber,int endNumber){
		String status_n = getSocket(obj.getIp(),obj.getPort());
		
		if(obj.getStatus()==null||obj.getStatus().equalsIgnoreCase(""))
			obj.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);
		
		if(OtherEquipmentObject.status_def.equalsIgnoreCase(obj.getStatus())){
			String sta = "网络异常";
			if(OtherEquipmentObject.status_on.equalsIgnoreCase(status_n))
				sta = "网络正常";
			logger.warn("第一次检查（"+obj.getIp()+"）的("+obj.getPort()+")端口"+sta);
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
		
		if(!obj.getStatus().equalsIgnoreCase(status_n)){
			if(OtherEquipmentObject.status_off.equalsIgnoreCase(status_n)){
				logger.warn("检查（"+obj.getIp()+"）的端口("+obj.getPort()+")网络异常");
			}else if(OtherEquipmentObject.status_on.equalsIgnoreCase(status_n)){
				logger.warn("检查（"+obj.getIp()+"）的端口("+obj.getPort()+")网络在线");
			}
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
	}
	
	private void audio(AudioObject obj,int startNumber,int endNumber){
		String status_n = getSocket(obj.getIp(),obj.getPort());
		if(status_n.equalsIgnoreCase(obj.getStatus())){
			if(status_n.equalsIgnoreCase(AudioObject.status_on))
				logger.info("检查音频设备（"+obj.getIp()+"）的("+obj.getPort()+")端口连接正常");
			else
				logger.info("检查音频设备（"+obj.getIp()+"）的("+obj.getPort()+")端口连接异常");
		}
		
		
		if(obj.getStatus()==null||obj.getStatus().equalsIgnoreCase(""))
			obj.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);
		
		if(AudioObject.status_def.equalsIgnoreCase(obj.getStatus())){
			String sta = "网络异常";
			if(AudioObject.status_on.equalsIgnoreCase(status_n))
				sta = "网络正常";
			logger.warn("第一次检查音频（"+obj.getIp()+"）的("+obj.getPort()+")端口"+sta);
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
		
		if(!obj.getStatus().equalsIgnoreCase(status_n)){
			if(AudioObject.status_off.equalsIgnoreCase(status_n)){
				logger.warn("检查音频（"+obj.getIp()+"）的端口("+obj.getPort()+")网络异常");
			}else if(AudioObject.status_on.equalsIgnoreCase(status_n)){
				logger.warn("检查音频（"+obj.getIp()+"）的端口("+obj.getPort()+")网络在线");
			}
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
	}
	
	private void cc(CenterControlObject ccobj,int startNumber,int endNumber){
		try{
			ReturnValueThread socketThread = null;
			String status = getConnection(ccobj.getIP(),ccobj.getPort());
			if(ccobj.getStatus()==null)
				ccobj.setStatus(SystemConfig.METHED_WITHIN,CenterControlObject.status_def);
			
			if(CenterControlObject.status_def.equalsIgnoreCase(ccobj.getStatus())){
					CenterControlObjectHelp.flagMap.put(ccobj.getIP(), true);
					socketThread = new ReturnValueThread(ccobj.getIP(),ccobj.getPort());
					socketThread.setName("中控"+ccobj.getIP()+"长连接");
					socketThread.start();
					CenterControlObjectHelp.threadMap.put(ccobj.getIP(), socketThread);
					if(CenterControlObject.status_off.equalsIgnoreCase(status)){
						logger.warn("第一次检查中控（"+ccobj.getIP()+"）的"+ccobj.getPort()+"端口通讯：异常");					
					}else if(CenterControlObject.status_on.equalsIgnoreCase(status)){
						logger.warn("第一次检查中控（"+ccobj.getIP()+"）的"+ccobj.getPort()+"端口通讯：正常");					
					}
					ccobj.setStatus(SystemConfig.METHED_WITHIN,status);
			}
			if(!ccobj.getStatus().equalsIgnoreCase(status)){
				if(CenterControlObject.status_off.equalsIgnoreCase(status)){
					CenterControlObjectHelp.flagMap.put(ccobj.getIP(), false);
					CenterControlObjectHelp.threadMap.remove(ccobj.getIP());
					Socket s = CenterControlObjectHelp.socketMap.get(ccobj.getIP());
					if(s!=null) {
						try {
							s.shutdownInput();
							s.shutdownOutput();
							s.close();
						} catch (IOException e) {}
					}
					CenterControlObjectHelp.socketMap.remove(ccobj.getIP());
					logger.warn("检查中控（"+ccobj.getIP()+"）的("+ccobj.getPort()+")端口通讯：异常");
				}else if(CenterControlObject.status_on.equalsIgnoreCase(status)){
					CenterControlObjectHelp.flagMap.put(ccobj.getIP(), true);
					CenterControlObjectHelp.threadMap.remove(ccobj.getIP());
					socketThread = new ReturnValueThread(ccobj.getIP(),ccobj.getPort());
					socketThread.setName("中控"+ccobj.getIP()+"长连接");
					socketThread.start();
					CenterControlObjectHelp.threadMap.put(ccobj.getIP(), socketThread);
					
					logger.warn("检查中控（"+ccobj.getIP()+"）的("+ccobj.getPort()+")端口通讯：正常");
				}else{
				}
			}
			ccobj.setStatus(SystemConfig.METHED_WITHIN,status);
			
//			Thread.sleep(EquipmentObjectImpl.THREAD_SLEEP_TIME);
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	private void terminal(TerminalObject obj,int startNumber,int endNumber){
		if(obj==null) return;
		String status_n = getSocket(obj.getTerminalIp(),23);
		
		if(obj.getStatus()==null||obj.getStatus().equalsIgnoreCase(""))
			obj.setStatus(SystemConfig.METHED_WITHIN,TerminalObject.status_def);
		
		if(TerminalObject.status_def.equalsIgnoreCase(obj.getStatus())){
			String sta = "网络异常";
			if(CenterControlObject.status_on.equalsIgnoreCase(status_n))
				sta = "网络正常";
			logger.warn("第一次检查终端（"+obj.getTerminalIp()+"）的(23)端口"+sta);
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
		
		if(!obj.getStatus().equalsIgnoreCase(status_n)){
			if(TerminalObject.status_off.equalsIgnoreCase(status_n)){
				stopTermianlWorking(obj.getTerminalIp());
				logger.warn("检查终端（"+obj.getTerminalIp()+"）的端口(23)网络异常");
			}else if(TerminalObject.status_on.equalsIgnoreCase(status_n)){
				logger.warn("检查终端（"+obj.getTerminalIp()+"）的端口(23)网络在线");
			}
		}

		if(TerminalObject.status_on.equalsIgnoreCase(status_n)){
			if(!TerminalObject.status_onMeeting.equalsIgnoreCase(obj.getStatus()))
				obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}else if(TerminalObject.status_off.equalsIgnoreCase(status_n)){
			stopTermianlWorking(obj.getTerminalIp());
			obj.setStatus(SystemConfig.METHED_WITHIN,status_n);
		}
	}
	
	private void stopTermianlWorking(String ip){
		ServerSocketEnues.removeTerminalSoket(ip);//发送的链接缓存
		
		//接收返回值的链接缓存
		if(!ServerSocketEnues.threadMap.isEmpty()&&ServerSocketEnues.threadMap.get(ip)!=null){
			TerminalClientThreadByReturn t = (TerminalClientThreadByReturn)ServerSocketEnues.threadMap.get(ip);
			if(t!=null)
				t.setLoop(false);
			
			ServerSocketEnues.threadMap.remove(ip);
		}
	}
	
	private  String getSocket(String ip,int port){
		 try{
			 
			 /**
			  * 如果port为最小值，用ping检测网络状态
			  */
			if(Integer.MIN_VALUE==port){
				String status = pingNet(ip);
				return status;
			}
			
//			Socket server = new Socket(ip,23);
			InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,23);
			Socket server = new Socket();
			server.connect(inetSocketAddress,5*1000);
			Thread.sleep(1000);
			server.close();
			return TerminalObject.status_on;
		 }catch(Exception e){
//			 logger.error("检查终端（"+ip+"）的端口(23)网络异常"+e.getMessage());
			 return TerminalObject.status_off;
		 }
	 }
	
	private  String pingNet(String ip){
        BufferedReader in = null;   
        Runtime r = Runtime.getRuntime();   
        String pingCommand = "ping " + ip + " -n 1 -w " + 3000;   
        try {
            Process p = r.exec(pingCommand);   
            if (p == null) {   
                return "0";   
            }   
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));   
            String line = null;   
            while ((line = in.readLine()) != null) {   
                if (line.contains("ms")) {   
                    return "1";   
                }
            }   
  
        } catch (Exception ex) {   
        	logger.error(ex.getMessage());
        	return "0";   
        } finally {   
            try {   
            	if(in!=null)
            		in.close();   
            } catch (IOException e) {   
            	logger.error(e.getMessage());
            	return "0";   
            }   
        }
        return "0";   
	 }
	
	/**
	 * 中控检测
	 * @param ip
	 * @param port
	 * @return
	 */
	private String getConnection(String ip,int port){
		 Socket server = null;
		 try{
			server = CenterControlObjectHelp.socketMap.get(ip);
			if(server==null){
				server = new Socket(ip,port);
				CenterControlObjectHelp.socketMap.put(ip, server);
				Thread.sleep(500);
			}else if(server.isClosed()||!server.isConnected()){
				logger.error(ip+"="+port+"长连接失效：是否关闭"+server.isClosed()+"是否连接"+server.isConnected());
				server.shutdownInput();
				server.shutdownOutput();
				server.close();
				CenterControlObjectHelp.socketMap.remove(ip);
				server = new Socket(ip,port);
				CenterControlObjectHelp.socketMap.put(ip, server);
				Thread.sleep(500);
			}
			
			if(checkHearbeatTime(ip)){//发送心跳
				OutputStream out=server.getOutputStream();
				out.write("icmpheartbeat".getBytes());
				out.write(new byte[]{13,10});
				out.flush();
			}
			
			return CenterControlObject.status_on;
		 }catch(Exception e){
			 CenterControlObjectHelp.flagMap.put(ip, false);
			 CenterControlObjectHelp.socketMap.remove(ip);
			 if(server!=null){
				 try {
					 if(server.isClosed())
						 server.close();
				} catch (IOException e1) {
					logger.error(ip+"="+port+"检查中控的端口系统异常:"+e.getMessage());
				}
			 }
			 return CenterControlObject.status_off;
		 }
	 }
	
	/**
	 * 检查是否应该发送心跳信息
	 * @param ip
	 * @return
	 */
	private	boolean	checkHearbeatTime(String ip){
		Long lastTime = heartbeatTime.get(ip);
		if(lastTime==null){
			heartbeatTime.put(ip, System.currentTimeMillis());
			return false;
		}else{
			if((System.currentTimeMillis()-lastTime.longValue())>CenterControlObject.HEARBEAT_TIME){
				heartbeatTime.remove(ip);
				heartbeatTime.put(ip, System.currentTimeMillis());
				return true;
			}else{
				return false;
			}
		}
	}

}
