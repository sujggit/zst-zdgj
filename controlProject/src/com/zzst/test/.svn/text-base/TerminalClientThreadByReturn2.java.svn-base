package com.zzst.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.ZZSTTerminalObject;
import com.zzst.terminal.service.impl.vo.AudiometerVO;
import com.zzst.terminal.service.impl.vo.CallDetailVO;
import com.zzst.terminal.service.impl.vo.CameraVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ServerSocketEnues;
import com.zzst.util.SystemConfig;

/**
 *@Description
 *@date 2011-1-20上午09:25:19
 *@author ryan
 */
public class TerminalClientThreadByReturn2 extends Thread{
	private static Logger logger = Logger.getLogger(TerminalClientThreadByReturn.class
			.getName());
	private String ip;
	private int port;
	private	String	command;
	private	String	commandReturn;
	private	long	startTime;
	private	boolean loop = true;
	public boolean	waitMark	=	true;
	public static	long	waitTime	=	10*1000;

	public static void main(String[] args) { 
		PropertyConfigurator.configure("E:/develop_C/6dev/icmp/src/applog4j.properties");//加载.properties文件 
		try {
			TerminalClientThreadByReturn2 t=new TerminalClientThreadByReturn2("10.33.13.41",24,"audiometer micleft","audiometer micleft level peak:",false);
			t.start();
		}catch(Exception e){
			
		}
	}
	/**
	 * 
	 * @param ip
	 * @param port
	 * @param command
	 * @param commandReturn
	 * @param waitMark		是否立即返回值
	 */
	public TerminalClientThreadByReturn2(String ip, int port,String command,String commandReturn,boolean waitMark) {
		this.ip = ip;
		this.port = port;
		this.command = command;
		this.commandReturn	= commandReturn;
		this.waitMark	=	waitMark;
	}
	
	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}


	/**
	 * 
	 * modify	by ryan	on 2011-07-08
	 */

	@Override
	public void run() {
		this.setName("终端（"+ip+"）：提取返回值线程"+command);
		Socket socket = null;
		try {
			socket = ServerSocketEnues.getTerminalSoket(ip);
			if(socket==null){
				logger.info("第一次连接终端"+ip);
				socket = new Socket();
				InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
			
				socket.connect(inetSocketAddress);
				
				ServerSocketEnues.setTerminalSoket(ip,socket);
				
				OutputStream out=socket.getOutputStream();
				out.write("013041".getBytes());
				out.write(new byte[]{13,10});
				out.flush();
				logger.info("成功发送远程控制登陆密码：");
				
				Thread.sleep(500);
			}else if(!socket.isConnected()){ }
		} catch (IOException e) {
			ServerSocketEnues.removeTerminalSoket(ip);
			logger.error(ip+"::socket  连接::"+e.getMessage());
		} catch (InterruptedException e) {
			
		}
		try {
			OutputStream out=socket.getOutputStream();
			out.write(command.getBytes());
			out.write(new byte[]{13,10});
			out.flush();
			
			if(commandReturn!=null&&!commandReturn.equals("")&&commandReturn.length()>0){
				InputStream inputStream	= socket.getInputStream();
				
				startTime = System.currentTimeMillis();
				while(loop){
					//长时间没有结束，自动结束   （没有提取到有用信息时）
					if(waitMark){
						if(System.currentTimeMillis()-startTime>waitTime)	loop = false;	
					}
					
					int available = inputStream.available();
//					logger.info(available);
					if(available==0){
						Thread.sleep(1000);
						continue;
					}
					
					byte[] tArray = new byte[available];
					inputStream.read(tArray);

					//if(tArray!=null&&tArray.length>0&&getUseful(new String(tArray),commandReturn)){
					if(getUseful(new String(tArray),commandReturn)){
						loop = false;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			// throw new ZZSTControlTerminalException("系统异常");
		} finally {

		}
	}

	//--------------2011-07-11---------------add--by--rayn-----------begin------
	
	private	boolean	getUseful(String str,String	commandReturn){
			if(str!=null&&str.length()>0){
				//提取音量值
				setAudiometer(str,commandReturn);
			}
		return false;
	}
	
	/**
	 * 提取镜头当前的坐标
	 * @param str
	 * @param commandRetrun
	 * @return false
	 */
	private	boolean getCameraPosition(String str,String commandRetrun){
		if (str != null && str.length() > 0 && str.indexOf("camera near position ") >= 0) {
			String[] lineStr	=	str.split("\\r\\n");
			for(String s : lineStr){
				if(s != null && s.length() > 0 && s.indexOf("camera near position ") >= 0){
					TerminalObject tObject =(TerminalObject)ControlFactory.getTerminalObject(this.ip);
					CameraVO cameraVO = new CameraVO();
					String[] xyz = s.split(" ");
					if(xyz.length==6){
						cameraVO.setX(xyz[3]);
						cameraVO.setY(xyz[4]);
						cameraVO.setZoom(xyz[5]);
					}
					tObject.setCameraVO(SystemConfig.METHED_WITHIN, cameraVO);
					return false;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 提取终端本身信息
	 * @param str
	 * @param commandRetrun
	 * @return false
	 */
	private	boolean setWhoami(String str,String commandRetrun){
		if (str != null && str.length() > 0 && str.indexOf("Here is what I know about myself:") >= 0) {
			TerminalObject tObject =(TerminalObject)ControlFactory.getTerminalObject(this.ip);
			tObject.getShoami().getMap().clear();
			if(str.indexOf(commandRetrun)>0) str = str.substring(str.indexOf("Here is what I know about myself:"),str.length());
			String[] lineStr	=	str.split("\\r\\n");
			for(String s : lineStr){
				if(s.indexOf(":")==s.lastIndexOf(":")){
					String[] map = s.split(":");
					if(map.length!=2) continue;
					String key = map[0];
					String value = map[1].trim();	
					tObject.getShoami().getMap().put(key, value.trim());
				}else{
					String key = s.substring(0,s.indexOf(":"));
					String value = s.substring(s.indexOf(":")+1,s.length());
					tObject.getShoami().getMap().put(key, value.trim());
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 解析音量值
	 * @param str
	 * @param commandRetrun
	 * @return
	 */
	private	boolean setAudiometer(String str,String commandRetrun){
		logger.info("commandRetrun####"+str);
//		if(str.indexOf("audiometer")<0) return false; 
//			
//		str = str.substring(str.indexOf("audiometer"),str.length());
//		String[] lineStr	=	str.split("\\r\\n");
//		for(String s : lineStr){
//			if(s.indexOf(commandRetrun)<0)	continue;
//			//logger.info("开始提前音量"+s+"======="+s.split(":")[1]+"-------"+s.split(" ")[1]);
//			//audiometer lineinleft level peak:-20
//			TerminalObject tObject =(TerminalObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_TERMINAL,this.ip);
//			AudiometerVO audiometerVO = new AudiometerVO();
//			audiometerVO.setNum(s.split(":")[1]);
//			audiometerVO.setOnLine(true);
//			audiometerVO.setType(s.split(" ")[1]);
//			tObject.setAudiometerVO(SystemConfig.METHED_WITHIN, audiometerVO);
//		}
		return false;
	}
	
	
	//--------------2011-07-11---------------add--by--rayn-----------end--------

	/**
	 * 提取终端是否静音
	 * 
	 * @param str
	 */
	private void getMuteStatus(String str) {
		String[] equip = ZZSTTerminalObject.getEquipmentInfo(ip);
		if (str.indexOf("mute near on") >= 0) {
			// ((String[])ZZSTTerminalObject.getEquipmentInfo(ip))[3]=ZZSTTerminalObject.MUTE_STATUS_OFF+"";
			equip[3] = ZZSTTerminalObject.MUTE_STATUS_OFF + "";
		} else if (str.indexOf("mute near off") >= 0) {
			// ((String[])ZZSTTerminalObject.getEquipmentInfo(ip))[3]=ZZSTTerminalObject.MUTE_STATUS_ON+"";
			equip[3] = ZZSTTerminalObject.MUTE_STATUS_ON + "";
		}
		//ZZSTTerminalObject.setEquipmentInfo(equip, ip);
	}
	//--------------2012-5-18---------------add--by--rayn-----------end--------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 提取有用信息
	 * 
	 * @param str
	 * @param ip
	 */
	private void getUsingInfo(String str, String ip) {
		getMuteStatus(str);

		getCallStatus(str);

		//String[] equip = ZZSTTerminalObject.getEquipmentInfo(ip);
		//if(ZZSTTerminalObject.CALL_NO.equals(equip[2])){
			getCallParticularInfo(str);	
		//}
	}

	

	/**
	 * 提取是否在通话中
	 * 
	 * @param str
	 */
	private void getCallStatus(String str) {
		if (str.indexOf("system is not in a call") >= 0) {
			String[] equip = ZZSTTerminalObject.getEquipmentInfo(ip);
			equip[2] = ZZSTTerminalObject.CALL_NO;
			// ZZSTTerminalObject.callStatus=ZZSTTerminalObject.CALL_NO;
		} else if (str.indexOf("callinfo begin") >= 0) {
			if (str.indexOf("callinfo end") > 0) {
				int startNum = str.indexOf("callinfo:");
				int endNum = str.indexOf("callinfo end");
				String[] s = str.substring(startNum, endNum).split("callinfo");
				if (s.length == 3) {
					for (int i = 1; i < s.length; i++) {
						String[] info = s[i].split(":");
						if ("videocall".equals(info[8].trim())) {
//							System.out.println(info[0] + "=" + info[1] + "="
//									+ info[2] + "=" + info[3] + "=" + info[4]
//									+ "=" + info[5] + "=" + info[6] + "="
//									+ info[7] + "=" + info[8]);
						} else if ("voiceonly".equals(info[8].trim())) {
//							System.out.println("电话信息：" + info[0] + "="
//									+ info[1] + "=" + info[2] + "=" + info[3]
//									+ "=" + info[4] + "=" + info[5] + "="
//									+ info[6] + "=" + info[7] + "="
//									+ info[8].substring(0, 9));
						}
					}
					ZZSTTerminalObject.getEquipmentInfo(ip)[2] = ZZSTTerminalObject.CALL_ALL;
					// ZZSTTerminalObject.callStatus =
					// ZZSTTerminalObject.CALL_ALL;
				} else if (s.length == 2) {
					String[] info = s[1].split(":");
					if ("videocall".equals(info[8].trim())) {// 终端信息
//						System.out.println("视频信息：" + info[0] + "=" + info[1]
//								+ "=" + info[2] + "=" + info[3] + "=" + info[4]
//								+ "=" + info[5] + "=" + info[6] + "=" + info[7]
//								+ "=" + info[8].substring(0, 9));
						ZZSTTerminalObject.getEquipmentInfo(ip)[2] = ZZSTTerminalObject.CALL_VIDEO;
						// ZZSTTerminalObject.callStatus =
						// ZZSTTerminalObject.CALL_VIDEO;
					} else if ("voiceonly".equals(info[8].trim())) {// 电话信息
//						System.out.println("电话信息：" + info[0] + "=" + info[1]
//								+ "=" + info[2] + "=" + info[3] + "=" + info[4]
//								+ "=" + info[5] + "=" + info[6] + "=" + info[7]
//								+ "=" + info[8].substring(0, 9));
						ZZSTTerminalObject.getEquipmentInfo(ip)[2] = ZZSTTerminalObject.CALL_AUDIO;
						// ZZSTTerminalObject.callStatus =
						// ZZSTTerminalObject.CALL_AUDIO;
					}
				}

			}
		}
	}

	/**
	 * 通话详细信息
	 * 
	 * @param str
	 */
	private void getCallParticularInfo(String str) {
//		logger.info("####"+str);
		getNetstatsInfo(str);
		getAdvnetstatsInfo(str);
	}

	/**
	 * netstats命令返回的信息
	 * 
	 * @param str
	 */
	public void getNetstatsInfo(String str) {
		
		if (str != null && str.length() > 0 && str.indexOf("call:") >= 0) {
			String callStr = str.substring(str.indexOf("call:"),str.length());
//			logger.info("#####:::"+callStr);
			String[] lineStr = callStr.split("r/n/");
			for(String s : lineStr ){
				if(s== null|| s.length()==0||s.equalsIgnoreCase("/r/n")) continue;
				String[] map = s.split(" ");
				for(String ss : map){
					if(ss.indexOf(":")>0){
						String key = ss.split(":")[0];
						String value = ss.split(":")[1];
//						logger.debug(key+"===netstats-==="+value);
						TerminalObject tObject =(TerminalObject)ControlFactory.getTerminalObject(this.ip);
						CallDetailVO detailVO = tObject.getCallDetailVO();
						detailVO.getCallDetail().put(key, value.trim());
//						detailVO.setCallDetail(callDetail)
					}
				}
			}
//		if (str != null && str.length() > 0 && str.indexOf("call:") >= 0
//				&& str.indexOf(" tar:") > 0 && str.indexOf("rar:") > 0
//				&& str.indexOf("dc:") > 0 && str.indexOf("rsid:") > 0
//				&& str.indexOf("rcp:") > 0) {
		
//			int startNum = str.indexOf("call:");
//			int endNum = str.indexOf("rcp:");
//			str = str.substring(startNum, endNum + 8);
//			int txrateNum = str.indexOf(" txrate:");
//			int rxrateNum = str.indexOf(" rxrate:");
//			int tvpNum = str.indexOf("tvp:");
//			int rvpNum = str.indexOf(" rvp:");
//			int tvfNum = str.indexOf(" tvf:");
//			int rvfNum = str.indexOf(" rvf:");
//			int tapNum = str.indexOf(" tap:");
//			int rapNum = str.indexOf(" rap:");
//			int pktlossNum = str.indexOf(" pktloss:");
//			int pktlossNum2 = str.indexOf(" %pktloss:");
//			int tcpNum = str.indexOf(" tcp:");
//			int rcpNum = str.indexOf(" rcp:");
//			
//			int pktloss =str.lastIndexOf(" %"); 
//			
//			
//			String[] equip = new String[32];//tObject.getMeetingVO("10.1.6.161","10.1.6.162").getDetailVO().getCallDetail();
//			if(equip==null)
//				equip = new String[32];
////			String[] equip = ZZSTTerminalObject.getEquipmentCallInfo(ip);
//			equip[0] = str.substring(txrateNum + 8, rxrateNum);
//			equip[1] =str.substring(rxrateNum + 8, pktlossNum);
//			equip[2] =str.substring(tvpNum + 4, rvpNum);
//			equip[3] =str.substring(rvpNum + 5, tvfNum);
//			equip[4] =str.substring(tvfNum + 5, rvfNum);
//			equip[5] =str.substring(rvfNum + 5, tapNum);
//			equip[6] =str.substring(tapNum + 5, rapNum);
//			equip[7] =str.substring(rapNum + 5, tcpNum);
//			equip[8] =str.substring(pktlossNum + 9, pktlossNum2+2);
//			equip[9] =str.substring(pktlossNum2 + 10, pktloss+2);
//			
//			equip[10]=str.substring(tcpNum + 4, rcpNum);
//			equip[29]=str.substring(rcpNum + 4, str.length());
			
//			System.out.println(str);
//			 for(int i=0;i<equip.length;i++){
//				 System.out.println("netstats-------"+equip[i]);
//			 }
		}
	}

	/**
	 * advnetstats命令返回的信息
	 * 
	 * @param str
	 */
	private void getAdvnetstatsInfo(String str) {
		if (str != null && str.length() > 0 && str.indexOf("call:") >= 0
				&& str.indexOf("tar:") > 0 && str.indexOf("rar:") > 0
				&& str.indexOf("rsid:") > 0 && str.indexOf("ccaps:") > 0) {
			
			String callStr = str.substring(str.indexOf("call:"),str.length());
//			logger.info("#####::getAdvnetstatsInfo::::"+callStr);
			String[] lineStr = callStr.split("r/n/");
			for(String s : lineStr ){
				if(s== null|| s.length()==0||s.equalsIgnoreCase("/r/n")) continue;
				String[] map = s.split(" ");
				for(String ss : map){
					if(ss.indexOf(":")>0){
						String key = ss.split(":")[0];
						String value = ss.split(":")[1];
//						logger.debug(key+"===advnetstats-==="+value);
						TerminalObject tObject =(TerminalObject)ControlFactory.getTerminalObject(this.ip);
						CallDetailVO detailVO = tObject.getCallDetailVO();
						detailVO.getCallDetail().put(key, value.trim());
					}
				}
			}
//			int startNum = str.indexOf("call:");
//			int endNum = str.indexOf("ccaps:");
//			  
//			str = str.substring(startNum, endNum + 9);
//			int tarNum = str.indexOf(" tar:");
//			int rarNum = str.indexOf(" rar:");
//			int tvrNum = str.indexOf(" tvr:");
//			int rvrNum = str.indexOf(" rvr:");
//			int tvruNum = str.indexOf(" tvru:");
//			int rvruNum = str.indexOf(" rvru:");
//			int tvfrNum = str.indexOf(" tvfr:");
//			int rvfrNum = str.indexOf(" rvfr:");
//			int vfeNum = str.indexOf(" vfe:");
//			int taplNum = str.indexOf(" tapl:");
//			int raplNum = str.indexOf(" rapl:");
//			int tajNum = str.indexOf(" taj:");
//			int rajNum = str.indexOf(" raj:");
//			int tvplNum = str.indexOf(" tvpl:");
//			int rvplNum = str.indexOf(" rvpl:");
//			int tvjNum = str.indexOf(" tvj:");
//			int rvjNum = str.indexOf(" rvj:");
//			int dcNum = str.indexOf(" dc:");
//			
//			int rsidNum = str.indexOf(" rsid:");
//			int ccapsNum = str.indexOf(" ccaps:");
//			
////			String[] equip = ZZSTTerminalObject.getEquipmentCallInfo(ip);
//			TerminalObject tObject =(TerminalObject)ControlFactory.getTerminalObject("10.1.6.161");
//			String[] equip = new String[32];//tObject.getMeetingVO("10.1.6.161","10.1.6.162").getDetailVO().getCallDetail();
//			if(equip==null)
//				equip = new String[32];
//			
//			equip[11] = str.substring(tarNum + 5, rarNum).trim();
//			equip[12] = str.substring(rarNum + 5, tvrNum).trim();
//			equip[13] = str.substring(tvrNum + 5, rvrNum).trim();
//			equip[14] = str.substring(rvrNum + 5, tvruNum).trim();
//			equip[15] = str.substring(tvruNum + 6, tvruNum+11).trim();
//			equip[16] = str.substring(rvruNum + 6, tvfrNum).trim();
//			equip[17] =str.substring(tvfrNum + 6, rvfrNum).trim();
//			equip[18] =str.substring(rvfrNum + 6, vfeNum).trim();
//			equip[19] =str.substring(vfeNum + 6, vfeNum+7).trim();
//			equip[20] =str.substring(taplNum + 6, raplNum).trim();
//			equip[21] =str.substring(raplNum + 6, tajNum).trim();
//			equip[22] =str.substring(tajNum + 5, rajNum).trim();
//			equip[23] =str.substring(rajNum + 5, tvplNum).trim();
//			equip[24] =str.substring(tvplNum + 6, rvplNum).trim();
//			equip[25] =str.substring(rvplNum + 6, rvplNum+7).trim();
//			equip[26] =str.substring(tvjNum + 5, rvjNum).trim();
//			equip[27] =str.substring(rvjNum + 5, dcNum).trim();
//			equip[28] =str.substring(dcNum + 3, rsidNum).trim();
//			equip[30]=str.substring(rsidNum + 5, ccapsNum).trim();
//			equip[31]=str.substring(ccapsNum + 6, str.length());
//			
//			 for(int i=0;i<equip.length;i++){
//				 System.out.println("advnetstats---------"+equip[i]);
//			}
		}
	}
}
