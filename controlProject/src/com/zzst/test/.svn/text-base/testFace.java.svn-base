package com.zzst.test;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.communication.TerminalClientTreadByAudioReturn;
import com.zzst.terminal.service.impl.communication.TerminalCommnadEnues;
import com.zzst.util.ControlFactory;

/**
 * 描述
 *@author	ryan
 *@since	2010-11-8上午11:41:02
 *@version	1.0
 */

public class testFace {

	public static String aaa = "aa";
	public static String[] bbb = {"aa","aa","aa"};
	private	List<String>	objList	=	Collections.synchronizedList(new LinkedList<String>());
	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		System.out.println("ASASds".toLowerCase());
	}
	
	 public void aa(){
		try{
		
			Socket socket = new Socket("10.1.6.161",24);
			//		Socket socket = new Socket();
			//		InetSocketAddress inetSocketAddress = new InetSocketAddress("10.1.6.162",24);
			//		socket.connect(inetSocketAddress,20000);
			
			Thread.sleep(500);
			
			OutputStream out=socket.getOutputStream();
			out.write("generatetone on".getBytes());
			out.write(new byte[]{13,10});
			out.flush();
			System.out.println("161======on");
			//		String str = "audiometer lineinleft level peak:-20";
			//		str = str.substring(str.indexOf("audiometer lineinleft level peak:"),str.length());
			//		System.out.println(str);
			Thread.sleep(500);
			out.write("generatetone off".getBytes());
			out.write(new byte[]{13,10});
			out.flush();
			System.out.println("161====off");
			Thread.sleep(500);
			socket.close();
		}catch(Exception e){
			
		}
	 }
}
