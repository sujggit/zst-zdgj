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

public class CopyOfTerminalClientThread extends Thread{
	private static Logger logger = Logger.getLogger(CopyOfTerminalClientThread.class
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
	 BufferedReader in =null;
		try {
			
			Socket socket = ServerSocketEnues.getTerminalSoket(ip);
			if(socket==null){
				logger.info("第一次连接终端");
				socket = new Socket();
				InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
				socket.connect(inetSocketAddress);
				ServerSocketEnues.setTerminalSoket(ip,socket);
				
				TerminalObject tobj	=	ControlFactory.getTerminalObject(ip);
				if(tobj!=null && tobj.getWebLoginPassword()!=null && tobj.getWebLoginPassword().length()>0){
					OutputStream out=socket.getOutputStream();
					out.write(tobj.getWebLoginPassword().getBytes());
					out.write(new byte[]{13,10});
					out.flush();
					logger.info("成功发送远程控制登陆密码："+tobj.getWebLoginPassword());
				}
				
				Thread.sleep(500);
			}else if(!socket.isConnected()){
				ServerSocketEnues.removeTerminalSoket(ip);
				logger.info("失效后再连接开始");
				InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
				socket.connect(inetSocketAddress);
				logger.info("失效后再连接结束");
				ServerSocketEnues.setTerminalSoket(ip, socket);
				
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
			
			OutputStream out=socket.getOutputStream();
			out.write(outCommand.getBytes());
			out.write(new byte[]{13,10});
			out.flush();
			logger.info("成功发送命令："+outCommand);
		} catch (Exception e) {
			ServerSocketEnues.removeTerminalSoket(ip);
			logger.error("连接终端异常："+e.getMessage());
			return false;
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
		return true;
	}
}
