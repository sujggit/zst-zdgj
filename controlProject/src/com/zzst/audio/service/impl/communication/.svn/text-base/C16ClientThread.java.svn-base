package com.zzst.audio.service.impl.communication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.zzst.util.ServerSocketEnues;

/**
 * 描述
 *@author	ryan
 *@since	2010-11-15上午11:12:28
 *@version	1.0
 */

public class C16ClientThread {
	private static Logger logger = Logger.getLogger(C16ClientThread.class
			.getName());
	
	public  final static String[]	MUTE_ON	={"set mute \"##1\" 0","val mute \"##1\" 0"};//设置输出不静音
	public  final static String[]	MUTE_OFF	={"set mute \"##1\" 1","val mute \"##1\" 1"};//设置输出静音
	public  final static String[]	MUTE_STATUS	={"get mute \"##1\"","val mute \"##1\" 1"};//提取输出静音状态
	
	public  final static String[]	SET_MUTE_LINE_OUT_GAIN	={"set line_out_gain \"##1\" ##2","val line_out_gain \"##1\" ##2.0"};//设置level音量值
	public  final static String[]	GET_MUTE_LINE_OUT_GAIN	={"get line_out_gain \"##1\"","val line_out_gain \"##1\" "};//提取level音量值
	public  final static String[]	SET_MUTE_FADER	={"set fader \"##1\" ##2","val fader \"##1\" ##2.0"};//设置fader音量值
	public  final static String[]	GET_MUTE_FADER	={"get fader \"##1\"","val fader \"##1\" "};//提取fader音量值
	
	public  final static String[]	SET_MIC_IN_GAIN	={"set mic_in_gain \"##1\" ##2","set mic_in_gain \"##1\" ##2"};//设置输入level音量值
	public  final static String[]	GET_MIC_IN_GAIN	={"get mic_in_gain \"##1\"",""};//提取输入level音量值
	
	

	/**
	 * 给音频处理器发送命令
	 */
	public static String sendCommandToC16(String ip,int port,String command){
		logger.info("C16ClientThread	sendCommandToC16	begin");
		logger.info("发送的指令："+command);
		OutputStream out1=null;
		  String str="";
			try {
//				Socket c16Socket = ServerSocketEnues.getC16ServerSoket(ip);
//				if(c16Socket==null||!c16Socket.isConnected()){
//					//c16Socket = new Socket("10.255.255.16",52774);
//					c16Socket = new Socket(ip,port);
//					ServerSocketEnues.setC16ServerSoket(ip, c16Socket);
//				}
//				
//				if(!c16Socket.isConnected()){
//					c16Socket = new Socket(ip,port);
//					Thread.sleep(500);
//				}
				Socket c16Socket = new Socket(ip,port);
				out1=c16Socket.getOutputStream();
				out1.write(command.getBytes());
				out1.write(new byte[]{13,10});
				out1.flush();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(c16Socket
						.getInputStream()));
				str=in.readLine();
				in.close();
			} catch (Exception e) {
				logger.error("音频处理器异常:"+e.getMessage());
			}finally{

			}
			logger.info("音频处理器返回值"+str);
		return str;
	}
	
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/5ICMP/icmp/src/applog4j.properties");//加载.properties文件 
		
		new C16ClientThread().sendCommandToC16("10.1.6.91",52774,"get line_out_gain \"##1\"");
	}
}
