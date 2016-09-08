package com.zzst.centerContor.service.impl.communication;

import java.io.IOException;
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
 * 
 * @author ryan
 * @since 2010-11-11下午01:37:03
 * @version 1.0
 */

public class CenterControlClientThread {
	private static Logger logger = Logger
			.getLogger(CenterControlClientThread.class.getName());

	private String ip;
	private int port;
	private boolean isResolved = true;// ip是否通

	public CenterControlClientThread(String ip, int port) {
		this.ip = ip;
		this.port = port;
		// InetSocketAddress inet = new InetSocketAddress(ip,port);
		// this.isResolved = inet.isUnresolved();
	}

	public boolean isResolved() {
		return isResolved;
	}

	public static void main(String[] arg) {
		PropertyConfigurator
				.configure("C:/workspace/icmp/src/applog4j.properties");// 加载.properties文件

		try {
			new CenterControlClientThread("localhost", 155).sendCommand("asd");
			// System.out.println("aaaaaaaaaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向中控发送命令无返回值
	 * 
	 * @param String
	 *            发送命令
	 * @param String
	 *            ip
	 * @param String
	 *            port
	 * @return boolean 成功返回true 失败抛出ZZSTControlTerminalException异常
	 */
	public boolean sendCommand(String num) throws ZZSTControlException {
		String outCommand=null;
		if(num.contains("!")){
			String[] strs = num.split("!");
			for(int i=0;i<strs.length;i++){
				if(strs[i]!=null&&strs[i]!=""){
					outCommand = GetCommand.getOutCommand(strs[i]);
					CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(),
							outCommand);
				}
			}
		}else{
			
			outCommand = GetCommand.getOutCommand(num);
			System.out.println("命令---------" + outCommand);
			if (outCommand == null) {
				return true;
			}
			CommandHelp.sendCommands.put(CommandHelp.sendCommands.size(),
					outCommand);
		}

		Socket so = null;
		try {
			so = CCNetStatusTask.checkConnection(ip, port);// new Socket(ip,
															// port);
			if (so == null) {
				// so = new Socket(ip, port);
				// CenterControlObjectHelp.socketMap.put(ip, so);
				System.out.println("中控链接异常");
				CommandHelp.clearCommands();
				return false;
			}
			if (!CommandHelp.sendLock) {
				CommandHelp.sendLock = true;
				for (int j = 0; j < CommandHelp.sendCommands.size(); j++) {
					outCommand = CommandHelp.sendCommands.get(j);
					boolean flag = false;
					if (outCommand.contains(",")) {
						flag = true;
						outCommand = outCommand.substring(0,
								outCommand.length() - 1);
					}

					// 中控是两条指令，需要判断一下
					if (outCommand.contains("-")) {// 发送中控指令
						try {
							OutputStream out = so.getOutputStream();
							for (int i = 0; i < 2; i++) {
								byte a = (byte) Integer.parseInt(
										outCommand.split("-")[i].split("_")[0],
										16);
								byte b = (byte) Integer.parseInt(
										outCommand.split("-")[i].split("_")[1],
										16);
								byte[] Get_by = new byte[] { (byte) 0xFF, 06,
										01, 0x14, (byte) 0xFF, (byte) 0xFF, 00,
										01, (byte) 0xFA };
								if(CommandHelp.floorNum.equals("12F")){
									Get_by[3] = 0x0A;
								}
								Get_by[4] = a;
								Get_by[5] = b;
								out.write(Get_by, 0, Get_by.length);
								out.write(new byte[] { 13, 10 }); // 13是回车，10是换行
								out.flush();
								Thread.sleep(500);
							}
							//out.close();
						} catch (Exception e) {
							logger.info("发送矩阵命令时异常");
							CommandHelp.clearCommands();
						}
					} else {
						byte a = (byte) Integer.parseInt(
								outCommand.split("_")[0], 16);
						byte b = (byte) Integer.parseInt(
								outCommand.split("_")[1], 16);
						try {
							OutputStream out = so.getOutputStream();
							byte[] Get_by = new byte[] { (byte) 0xFF, 06, 01,
									0x14, (byte) 0xFF, (byte) 0xFF, 00, 01,
									(byte) 0xFA };
							if(CommandHelp.floorNum.equals("12F")){
								Get_by[3] = 0x0A;
							}
							Get_by[4] = a;
							Get_by[5] = b;
							if (flag) {
								Get_by[7] = 00;
							}
							out.write(Get_by, 0, Get_by.length);
							// out.write(new byte[]{13,10}); //13是回车，10是换行
							out.flush();
							// so.shutdownOutput();
							CommandHelp.cammeraStop = outCommand;
							logger.info(ip + "  发送命令:	" + outCommand + "		成功");
						} catch (Exception e) {
							CommandHelp.clearCommands();
							CCNetStatusTask.netException(ip);
							logger.error(ip + "  发送命令:	" + outCommand + "		异常");
							throw new ZZSTControlException("系统异常");
						}
					}
					if (j != CommandHelp.sendCommands.size() - 1) {
						Thread.sleep(500);
					}
				}
				CommandHelp.clearCommands();
			}
		} catch (Exception e) {
			/*
			 * try { so.close(); } catch (IOException e1) { // TODO
			 * Auto-generated catch block e1.printStackTrace(); }
			 */
		} finally {
			/*
			 * try { so.close(); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
		return true;
	}

	/**
	 * 发送命令并接收返回值
	 * 
	 * @param ip
	 * @param port
	 * @param command
	 * @return String
	 * @throws ZZSTControlException
	 */
	// public String sendCommandByReturn(String command)throws
	// ZZSTControlException {
	// try {
	// // InetSocketAddress inet = new InetSocketAddress(ip,port);
	// // if(!inet.isUnresolved()) return null;
	//
	// Socket server = getSocket();
	// if(server==null) return null;
	//
	// OutputStream out=server.getOutputStream();
	//
	// out.write(command.getBytes());
	// out.write(new byte[]{13,10});
	// out.flush();
	// // if("10.6.22.250".equalsIgnoreCase(ip))
	// logger.info(ip+"  发送命令:	"+command+"		成功");
	//
	// //等待才能接到返回值？？？？
	//
	//
	//
	// if(command.indexOf("MODEL>WALLINFO")!=-1){
	// Thread.sleep(4000);
	// }else{
	// Thread.sleep(200);
	// }
	//
	// String reStr = "";
	//
	// BufferedReader in = new BufferedReader(new InputStreamReader(server
	// .getInputStream()));
	// reStr=in.readLine();
	//
	// // InputStream in = server.getInputStream();
	// // int c = 0;
	// // boolean m = true;
	// // while(m){
	// // //logger.info("总长度："+in.available());
	// // if(in.available()==0){
	// // m = false;
	// // continue;
	// // }
	// //
	// // c = in.read();
	// // //logger.info((char)c+"========"+c);
	// // if(c==3){
	// // m = false;
	// // continue;
	// // }
	// // reStr += (char)c;
	// // }
	//
	// //---------==============================
	// // byte[] b = new byte[1024];
	// // in.read(b);
	//
	// // String str = "";
	// // byte[] reB = reStr.getBytes();
	// // if(reB!=null&&reB.length>0){
	// // for(byte bb : reB){
	// // if(bb == 3) break;
	// // str += (char)bb;
	// // }
	// // }
	// // if("10.6.22.250".equalsIgnoreCase(ip))
	// logger.info(ip+"返回值："+reStr);
	// return reStr;
	// } catch (Exception e) {
	// logger.error("返回值出现问题："+e.getMessage());
	// ServerSocketEnues.removeCenterControlSocket(ip);
	// throw new ZZSTControlException("系统异常");
	// }finally{
	//
	// }
	// }

	// private Socket getSocket(){
	// Socket server = null;
	// try{
	// server = CenterControlObjectHelp.socketMap.get(ip);
	// if(server==null){
	// server = new Socket(ip,port);
	// CenterControlObjectHelp.socketMap.put(ip, server);
	//
	// Thread.sleep(500);
	// }
	//
	// if(!server.isConnected()){
	// server = new Socket(ip,port);
	// Thread.sleep(500);
	// }
	// }catch(UnknownHostException e){
	// logger.error(ip+"连接"+port+"异常");
	// CenterControlObjectHelp.socketMap.remove(ip);
	// }catch (IOException e) {
	// logger.error(ip+"IOException"+port+"异常");
	// } catch (InterruptedException e) {
	// // e.printStackTrace();
	// }
	// return server;
	// }

}
