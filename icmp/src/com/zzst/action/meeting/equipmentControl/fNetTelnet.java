package com.zzst.action.meeting.equipmentControl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;

import com.gsiec.cjf.system.CjfLogger;

public class fNetTelnet {
	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private char prompt = '$';

	private static Logger logger = CjfLogger.getLogger(fNetTelnet.class
			.getName());

	// 普通用户结束
	public fNetTelnet(String ip, int port, String user, String password) {
		try {
			telnet.connect(ip, port);
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());

			InputStreamReader fin = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(fin);

			String result2 = br.readLine();
			System.out.println(result2);
			result2 = br.readLine();
			System.out.println(result2);
			// 根据root用户设置结束符
			// this.prompt = user.equals("root") ? '#' : '$';
			// login(user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** * 登录 * * @param user * @param password */
	public void login(String user, String password) {
		readUntil("login:");
		write(user);
		readUntil("Password:");
		write(password);
		readUntil(prompt + " ");
	}

	/** * 读取分析结果 * * @param pattern * @return */
	public String readUntil(String pattern) {
		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			StringBuffer sb = new StringBuffer();
			char ch = (char) in.read();
			while (true) {
				sb.append(ch);
				if (ch == lastChar) {
					if (sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
				}
				ch = (char) in.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** * 写操作 * * @param value */
	public void write(String value) {
		try {
			out.println(value);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** * 向目标发送命令字符串 * * @param command * @return */
	public String sendCommand(String command) {
		try {
			write(command);
			return readUntil(prompt + " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/** * 关闭连接 */
	public void disconnect() {
		try {
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String execCommand(String ip, int port, String equRoomId, String user, String password, String type) {
		String result2 = "";
		String result = "";
		fNetTelnet telnet = null;
		try {
			System.out.println("启动Telnet...");
			telnet = new fNetTelnet(ip, port, user, password);
			telnet.write(user);
			telnet.readUntil("Password:");
			telnet.write(password);
			InputStreamReader fin = new InputStreamReader(telnet.in);
			BufferedReader br = new BufferedReader(fin);
			result2 = br.readLine();
			logger.info("loginResult:  " + result2);

			String command = "tnrc recordex roomid:" + (equRoomId.trim()) + " bRecord:";
			
			if("start".equals(type)){
				command += "1";
			}else if("pause".equals(type)){
				command += "2";
			}else if("continue".equals(type)){
				command += "3";
			}else if("stop".equals(type)){
				command += "0";
			}else if("state".equals(type)){
				command = "tnrc getrecordstateEX roomid:" + (equRoomId.trim());
			}
			
			logger.info(ip + ":" + command);
			telnet.write(command);
			result2 = br.readLine();
			while(!(result2.contains("</getrecordstateEX >")) ){
				if(result2.contains("<recordEX>error")){
					if(result2.contains("<recordEX>error:0")){
						result = "未知";
						break;
					}else{
						break;
					}
				}else if(result2.contains("state:Pause")){
					result = "暂停";
					break;
				}else if(result2.contains("state:Record")){
					result = "录制中";
					break;
				}else if(result2.contains("state:Stop")){
					result = "停止";
					break;
				}
				result2 = br.readLine();
			}
			
			logger.info(type + "Result:  " + result2);
			Thread.sleep(300);
//			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("error:" + e.getMessage());
		} finally{
			if(telnet != null){
				telnet.disconnect();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			System.out.println("启动Telnet...");
			String ip = "10.1.6.159";
			int port = 23;
			String user = "admin";
			String password = "admin";
			fNetTelnet telnet = new fNetTelnet(ip, port, user, password);
			telnet.write(user);

			telnet.readUntil("Password:");

			telnet.write(password);
			InputStreamReader fin = new InputStreamReader(telnet.in);
			BufferedReader br = new BufferedReader(fin);
			String result2 = br.readLine();
			System.out.println(result2);

//			 telnet.write("tnrc getipinfo");
//			 while(!(result2 = br.readLine()).contains("</getipinfo>") ){
//			 System.out.println(result2);;
//			 }

			telnet.write("tnrc getrecordstateEX roomid:0");
			String result = "";
			result2 = br.readLine();
			while(!(result2.contains("</getrecordstateEX >")) ){
				System.out.println(result2);
				result2 = br.readLine();
			}
			System.out.println(result);
			Thread.sleep(5000);

			// telnet.write("tnrc getrecordstateEX roomid:0");
			// result2 = br.readLine();
			// System.out.println(result2);
			// Thread.sleep(25000);

			// telnet.write("tnrc recordex roomid:0 bRecord:1");
			// result2 = br.readLine();
			// System.out.println(result2);
			// Thread.sleep(5000);

			// telnet.sendCommand("export LANG=en");
			// String r1 = telnet.sendCommand("cd /home/project/");
			// String r2 = telnet.sendCommand("pwd");
			// String r3 = telnet.sendCommand("sh a.sh");
			// System.out.println("显示结果");
			// System.out.println(r1);
			// System.out.println(r2);
			// System.out.println(r3);

			// telnet.write("tnrc recordex roomid:0 bRecord:2");
			// result2 = br.readLine();
			// System.out.println(result2);
			// Thread.sleep(5000);

			// telnet.write("tnrc recordex roomid:0 bRecord:3");
			// result2 = br.readLine();
			// System.out.println(result2);

			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
