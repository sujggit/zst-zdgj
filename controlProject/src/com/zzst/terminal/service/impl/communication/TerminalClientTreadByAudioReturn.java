package com.zzst.terminal.service.impl.communication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.terminal.service.TerminalObject;
import com.zzst.terminal.service.impl.vo.AudiometerVO;
import com.zzst.util.ControlFactory;
import com.zzst.util.EquipmentObject;
import com.zzst.util.EquipmentObjectImpl;
import com.zzst.util.ExcuteResultVO;
import com.zzst.util.SystemConfig;

/**
 * soket链接为长链接。
 * 使用完成必须关闭
 * @author zhangdq
 * @since 20140328
 */
public class TerminalClientTreadByAudioReturn {
	private static Logger logger = Logger.getLogger(TerminalClientTreadByAudioReturn.class
			.getName());
	private String ip;
	private int port;
	private	String	command;
	private	String	commandReturn;
	private	long	startTime;
	private	boolean loop = true;
	public boolean	waitMark	=	true;
	public static	long	waitTime	=	5*1000;

	private int	commandNum	=	0;
	/**
	 * 
	 * @param ip
	 * @param port
	 * @param command
	 * @param commandReturn
	 * @param waitMark		是否立即返回值
	 */
	public TerminalClientTreadByAudioReturn(String ip, int port,String command,String commandReturn,boolean waitMark) {
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


//	@Override
	public void run() {
//		long l1 = System.currentTimeMillis();
//		this.setName("终端（"+ip+"）：提取返回值线程"+command);
		Socket socket = null;
		OutputStream out= null;
		commandNum = 0;
		try {
			TerminalObject tobj	=	ControlFactory.getTerminalObject(ip);
			if(tobj!=null){
				logger.info("接收音频返回值连接终端"+ip);
				socket = new Socket();
				InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
				socket.connect(inetSocketAddress);
//				socket.setSoTimeout(2000);
				Thread.sleep(500);
				out=socket.getOutputStream();
				
				if(tobj!=null && tobj.getWebLoginPassword()!=null && tobj.getWebLoginPassword().length()>0){
					out.write(tobj.getWebLoginPassword().getBytes());
					out.write(new byte[]{13,10});
					out.flush();
					logger.info("成功发送远程控制登陆密码："+tobj.getWebLoginPassword());
				}
				
				out.write(command.getBytes());
				out.write(new byte[]{13,10});
				out.flush();
				
				if(commandReturn!=null&&!commandReturn.equals("")&&commandReturn.length()>0){
					InputStream inputStream	= socket.getInputStream();
					
					startTime = System.currentTimeMillis();
					while(loop){
						if(System.currentTimeMillis()-startTime>waitTime){
							logger.info(ip+"超时没有接到返回值");
							loop = false;
						}
						int available = inputStream.available();
						
						if(available==0){
							logger.info(ip+"等待音量值");
							Thread.sleep(1000);
							continue;
						}
						byte[] tArray = new byte[available];
						inputStream.read(tArray);
						
						if(setAudiometer(new String(tArray),commandReturn)){
							logger.info(ip+"接收到音量值返回");		
							loop = false;
						}
					}
				}
			}else{
				logger.info("终端"+ip+"没有注册");
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				Thread.sleep(1000);
				if(out!=null)
					out.close();
				if(socket!=null){
					socket.close();
				}
			} catch (Exception e) {
				
			}
//			logger.info("##########取声音值消耗时间#############"+(System.currentTimeMillis()-l1));
//			logger.info("finally===================");
		}
	}

	//--------------2011-07-11---------------add--by--rayn-----------begin------
	
	
	/**
	 * 解析音量值
	 * @param str
	 * @param commandRetrun
	 * @return
	 */
	private	boolean setAudiometer(String str,String commandRetrun){
		if(str.indexOf("audiometer lineoutleft level peak")<0) return false; 
		TerminalObject tObject =(TerminalObject)EquipmentObjectImpl.getEquipmentObject(EquipmentObject.EQUIPMENT_TYPE_TERMINAL,this.ip);		
		str = str.substring(str.indexOf("audiometer lineoutleft level peak"),str.length());
		logger.info(ip+"="+str);
		String[] lineStr	=	str.split("\\r\\n");
		
		for(String s : lineStr){
			commandNum++;
			try{
				if(s.indexOf(commandRetrun)<0)	continue;
				//audiometer lineinleft level peak:-20
				AudiometerVO audiometerVO = new AudiometerVO();
				audiometerVO.setNum(s.split(":")[1]);
				audiometerVO.setOnLine(true);
				audiometerVO.setType(s.split(" ")[1]);
				//logger.info(ip+"###"+s+"======="+s.split(":")[1]+"-------"+s.split(" ")[1]+"####"+audiometerVO.getNum()+"###"+commandNum);
				tObject.setAudiometerVO(SystemConfig.METHED_WITHIN, audiometerVO);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(commandNum>=10)	{
				TerminalObject tobj =ControlFactory.getTerminalObject(ip);
				ExcuteResultVO resultVO = tobj.getAudiometerVO();
				if(!resultVO.isSuccess()){
					logger.info(ip+"=="+resultVO.getDes());continue;
				}
				Map<String,AudiometerVO> map = (Map<String,AudiometerVO>)resultVO.getObject();
				if(map==null){
					logger.info("map为空");
					continue ;
				}
				
				AudiometerVO vo = map.get(AudiometerVO.lineoutleft);
				if(vo==null) {
					logger.info("lineoutleft对象为空");
				}else
					logger.info(ip+"##soket内"+vo.getNum()+"===lineoutleft");
				
				return true;//至少取到5条数据
			}
		}
		return false;
	}
}
