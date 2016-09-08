package com.zzst.reach.service.impl.communication.cm200;

	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	import java.io.OutputStream;
	import java.net.Socket;
	import java.net.UnknownHostException;

	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;

	import com.zzst.centerContor.service.CCNetStatusTask;
	import com.zzst.centerContor.service.CenterControlObjectHelp;
import com.zzst.util.ZZSTControlException;

	/**
	 * 描述
	 *@author	ryan
	 *@since	2010-11-11下午01:37:03
	 *@version	1.0
	 */

	public class ClientSoket {
		private static Logger logger = Logger.getLogger(ClientSoket.class
				.getName());
		
		private String ip;
		private int port;
		private boolean isResolved = true;//ip是否通
		
		public ClientSoket(String ip,int port){
			this.ip = ip;
			this.port = port;
		}
		
		
		public boolean isResolved() {
			return isResolved;
		}


		public static void main(String[] arg){
			PropertyConfigurator.configure("C:/workspace/icmp/src/applog4j.properties");//加载.properties文件 
			
			try{
//				new CenterControlClientThread("localhost",155).sendCommand("asd");
//				System.out.println("aaaaaaaaaa");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/**
		 * 向中控发送命令无返回值
		 * @param String 发送命令
		 * @param String ip
		 * @param String port
		 * @return boolean 成功返回true 失败抛出Exception异常
		 */
		public  String  sendCommand(String outCommand)throws Exception {
			try {
				Socket so =  new Socket(ip,port);
				
				if(so==null) return null;
				
				OutputStream out=so.getOutputStream();
				out.write(outCommand.getBytes());
				out.write(new byte[]{13,10});
				out.flush();
				logger.info(ip+"  发送命令:	"+outCommand+"		成功");
				try{
					BufferedReader in = new BufferedReader(new InputStreamReader(so
							.getInputStream()));
					boolean b = true;
					StringBuffer backStr = new StringBuffer();
					boolean ta = false;//是否连续接受返回值的标识
					while(b){
						
						String msg=in.readLine();
						if(msg==null||msg.length()==0||msg.indexOf(">>")>=0||msg.indexOf("<<")>=0) continue;
						
						if(msg.toString().equalsIgnoreCase("Telnet Server Started"))	continue;
						
						if(msg.toString().toLowerCase().equals("<connect>success!</connect>")) 	continue;
						
						if(ta||msg.indexOf("<connroomEX>")>=0||msg.indexOf("<recordEX>")>=0||msg.indexOf("<roomstateex>")>=0||msg.indexOf("<recordstate>")>=0||msg.indexOf("<getrecordstateEX>")>=0){
							ta = true;
							backStr.append(msg);
						}
						
						if(msg.indexOf("</connroomEX>")>=0||msg.indexOf("</recordEX>")>=0||msg.indexOf("</roomstateex>")>=0||msg.indexOf("</recordstate>")>=0||msg.indexOf("</getrecordstateEX>")>=0){
							b = false;continue;
						}
					}
					return backStr.toString();
				}catch(Exception e){
					return e.getMessage();
				}
			}catch(UnknownHostException e){
				throw new  Exception("端口连接异常");
			 } catch (Exception e) {
				logger.error(ip+"  发送命令:	"+outCommand+"		异常");
				throw new  Exception("系统异常");
			}
		}
	 

	}

