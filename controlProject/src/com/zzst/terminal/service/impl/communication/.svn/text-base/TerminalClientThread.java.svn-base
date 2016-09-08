package com.zzst.terminal.service.impl.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.util.ControlFactory;
import com.zzst.util.ServerSocketEnues;
import com.zzst.util.ZZSTControlException;

/**
 * 描述
 *@author	ryan
 *@since	2010-11-15下午03:09:57
 *@version	1.0
 */

public class TerminalClientThread extends Thread{
	private static Logger logger = Logger.getLogger(TerminalClientThread.class
			.getName());
	/**
	 * 向终端发送命令无返回值
	 * 新连接为什么要等500毫秒后，发信息才有效？？？
	 * @param String 发送命令
	 * @param String 终端设备ip
	 * @param String 终端设备网控port
	 * @return boolean 成功返回true 失败抛出ZZSTControlTerminalException异常
	 */
 public  static boolean  sendCommandToTerminal(String ip,int port,String outCommand)throws ZZSTControlException {
//	long l1 = System.currentTimeMillis();
	 Socket socket = new Socket();
	 OutputStream out = null;	
	 try {
			TerminalObject tobj	=	ControlFactory.getTerminalObject(ip);
			if(tobj==null){
				logger.info("终端"+ip+"没有注册");
				return false;
			}
			
//			Socket socket = ServerSocketEnues.getTerminalSoket(ip);
//			try{
//				socket.sendUrgentData(0xFF);
//			}catch(Exception e){
//				ServerSocketEnues.removeTerminalSoket(ip);
//				socket = new Socket();
//				InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
//				socket.connect(inetSocketAddress);
//				Thread.sleep(500);
//				ServerSocketEnues.setTerminalSoket(ip,socket);
//				
//				logger.error(ip+"新链接"+e.getMessage());
//			}
			InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
			socket.connect(inetSocketAddress);
			Thread.sleep(500);
			out=socket.getOutputStream();
			if(tobj!=null && tobj.getWebLoginPassword()!=null && tobj.getWebLoginPassword().length()>0){
				out.write(tobj.getWebLoginPassword().getBytes());
				out.write(new byte[]{13,10});
				out.flush();
				logger.info("成功发送远程控制登陆密码："+tobj.getWebLoginPassword());
			}
			
			out.write(outCommand.getBytes());
			out.write(new byte[]{13,10});
			out.flush();
			
			logger.info(ip+"成功发送命令："+outCommand);
		} catch (Exception e) {e.printStackTrace();
//			ServerSocketEnues.removeTerminalSoket(ip);
			logger.error("连接终端异常："+e.getMessage());
			return false;
		}finally{
			try {
				Thread.sleep(1000);
				if(out!=null)
					out.close();
				if(socket!=null)
					socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//	 logger.info("##########发送指令消耗时间#############"+(System.currentTimeMillis()-l1));
		return true;
	}
}
