package com.zzst.terminal.service.impl.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.vo.AudiometerVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ServerSocketEnues;
import com.zzst.util.SystemConfig;

/**
 * soket链接为长链接。
 * 使用完成必须关闭
 * @author zhangdq
 * @since 20140328
 */
public class Copy_2_of_TerminalClientTreadByAudioReturn extends Thread{
	private static Logger logger = Logger.getLogger(Copy_2_of_TerminalClientTreadByAudioReturn.class
			.getName());
	private String ip;
	private int port;
	private	String	command;
	private	String	commandReturn;
	private	long	startTime;
	private	boolean loop = true;
	public boolean	waitMark	=	true;
	public static	long	waitTime	=	10*1000;

	/**
	 * 
	 * @param ip
	 * @param port
	 * @param command
	 * @param commandReturn
	 * @param waitMark		是否立即返回值
	 */
	public Copy_2_of_TerminalClientTreadByAudioReturn(String ip, int port,String command,String commandReturn,boolean waitMark) {
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


	@Override
	public void run() {
		this.setName("终端（"+ip+"）：提取返回值线程"+command);
		Socket socket = null;
		try {
			if(socket==null){
				logger.info("第一次连接终端"+ip);
				socket = new Socket();
				InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
				socket.connect(inetSocketAddress);
				
				TerminalObject tobj	=	ControlFactory.getTerminalObject(ip);
				if(tobj!=null && tobj.getWebLoginPassword()!=null && tobj.getWebLoginPassword().length()>0){
					OutputStream out=socket.getOutputStream();
					out.write(tobj.getWebLoginPassword().getBytes());
					out.write(new byte[]{13,10});
					out.flush();
					logger.info("成功发送远程控制登陆密码："+tobj.getWebLoginPassword());
				}
				Thread.sleep(500);
			}
		} catch (Exception e) {
			ServerSocketEnues.audioThreadMap.remove(ip);
			logger.error(ip+"::socket  连接::"+e.getMessage());
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
			ServerSocketEnues.audioThreadMap.remove(ip);
		} finally {

		}
	}

	//--------------2011-07-11---------------add--by--rayn-----------begin------
	
	private	boolean	getUseful(String str,String	commandReturn){
			if(str!=null&&str.length()>0){
//				logger.info("有信息返回");
				//提取音量值
				setAudiometer(str,commandReturn);
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
		if(str.indexOf("audiometer")<0) return false; 
			
		str = str.substring(str.indexOf("audiometer"),str.length());
		String[] lineStr	=	str.split("\\r\\n");
		for(String s : lineStr){
			if(s.indexOf(commandRetrun)<0)	continue;
			//logger.info("开始提前音量"+s+"======="+s.split(":")[1]+"-------"+s.split(" ")[1]);
			//audiometer lineinleft level peak:-20
			TerminalObject tObject =(TerminalObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_TERMINAL,this.ip);
			AudiometerVO audiometerVO = new AudiometerVO();
			audiometerVO.setNum(s.split(":")[1]);
			audiometerVO.setOnLine(true);
			audiometerVO.setType(s.split(" ")[1]);
			tObject.setAudiometerVO(SystemConfig.METHED_WITHIN, audiometerVO);
		}
		return false;
	}
}
