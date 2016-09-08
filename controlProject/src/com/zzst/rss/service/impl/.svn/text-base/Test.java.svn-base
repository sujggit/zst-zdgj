package com.zzst.rss.service.impl;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;



/**
 *@Description
 *@date 2011-4-11下午01:47:59
 *@author ryan
 */
public class Test {
	public static void main(String[] args) { 
		  OutputStream out1=null;
		  String command = "<? xml version=\"1.0\" encoding=\"utf-8\"?><DVCRMANAGER version=\"1.0.0.0\"><COMMAND xmlid=\"login\"><USERNAME value=\"admin\"/><PASSWORD value=\"admin\"/><LANG value=\"0\"/><DOMAIN value=\"DomainName\"/><INDICATION value=\"1\"/></COMMAND></DVCRMANAGER>";
		try {
			//Socket s = new Socket(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("10.1.6.180", 81))); 
			InetAddress sa = InetAddress.getByName("10.1.6.180");
			Socket s = new Socket(sa,81);
			System.out.println(s.getLocalPort());
			out1=s.getOutputStream();
			out1.write(command.getBytes());
			out1.write(new byte[]{13,10});
			out1.flush();
			
			InputStream in =s.getInputStream();
		//	InputStream in = socket.getInputStream();
			boolean mark = true;
			String str = new String();
			while (mark) {
				byte[] backStr = new byte[1024];
				in.read(backStr);
				str = new String(backStr);
				if (str == null || str.trim().length() == 0){
					 System.out.println(str);
					mark = false;
					continue;
				}
				 System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
