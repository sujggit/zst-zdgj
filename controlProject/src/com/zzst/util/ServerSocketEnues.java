package com.zzst.util;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.zzst.terminal.service.impl.communication.TerminalClientThreadByReturn;
import com.zzst.terminal.service.impl.communication.TerminalClientTreadByAudioReturn;

/**
 * 缓存枚举
 *@author	ryan
 *@since	2010-11-15上午11:02:37
 *@version	1.0
 *modify by ryan on 2013-1-5	把所有的连接缓存都放在一个map内
 *modify by rayn on 2013-8-18	中控已经不在使用，调整到CenterControlObjectHelp
 */

public class ServerSocketEnues {

	public static Map<String,Socket> socketMap = new HashMap<String,Socket>();
	
//	public static Map<String,Socket> terminalServerSocketMap 		= new HashMap<String,Socket>();
//	
//	public static Map<String,Socket> centerControleServerSocketMap 	= new HashMap<String,Socket>();
//	
//	public static Map<String,Socket> C16ServerSocket				= new HashMap<String,Socket>();
//	
	public static Map<String,TerminalClientThreadByReturn> threadMap = new HashMap<String,TerminalClientThreadByReturn>();
	
	//取音频值的缓存
	public static Map<String,TerminalClientTreadByAudioReturn> audioThreadMap = new HashMap<String,TerminalClientTreadByAudioReturn>();
//	
//	public static Map<String,Socket> vtronMap = new HashMap<String,Socket>();

	
	public static void setSocket(String ip,Socket socket){
		socketMap.put(ip, socket);
	}
	
	public static void removeSocket(String ip){
		socketMap.remove(ip);
	}
	
	public static Socket getSocket(String ip){
		return socketMap.get(ip);
	}
	
	public static void setVtronSocket(String ip,Socket socket){
		socketMap.put(ip, socket);
	}
	
	public static void removeVtronSocket(String ip){
		socketMap.remove(ip);
	}
	
	public static Socket getVtronSocket(String ip){
		return socketMap.get(ip);
	}
	
	public static	boolean	setTerminalThread(String key,TerminalClientThreadByReturn thread){
		threadMap.put(key, thread);
		return true;
	}
	
	public static	TerminalClientThreadByReturn  getTerminalThread(String key){
		if(threadMap == null) return null;
		return threadMap.get(key);
	}
	
	public static	boolean  removeTerminalhread(String key){
		if(threadMap == null) return false;
		threadMap.remove(key);
		return true;
	}
	
	public static void setC16ServerSoket(String ip,Socket socket){
		socketMap.put(ip, socket);
	}
	
	public static Socket getC16ServerSoket(String ip){
		return socketMap.get(ip);
	}
	public static void setCenterControlSocket(String ip,Socket socket){
		socketMap.put(ip, socket);
	}
	
	public static void removeCenterControlSocket(String ip){
		socketMap.remove(ip);
	}
	
	public static Socket getCenterControlSocket(String ip){
		return socketMap.get(ip);
	}
	
	public static void setTerminalSoket(String ip,Socket socket){
		socketMap.put(ip, socket);
	}
	
	public static Socket getTerminalSoket(String ip){
		return socketMap.get(ip);
	}
	
	public static Socket removeTerminalSoket(String ip){
		return socketMap.remove(ip);
	}
}
