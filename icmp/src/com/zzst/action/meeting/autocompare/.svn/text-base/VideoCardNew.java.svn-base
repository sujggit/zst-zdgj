package com.zzst.action.meeting.autocompare;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.MessageDigest;

public class VideoCardNew {
	
    public String ip="192.168.1.10";
    public int port=7777;
    public int timeout=3000;
    private VideoCardNew(){
    	
    }
    public VideoCardNew(String ip){
    	this.ip = ip;
    }
    
    public VideoCardNew(String ip, int port){
    	this.ip = ip;
    	this.port = port;
    }
	/** 
	* @Title: setCommand 
	* @Description: TODO(设置比对卡参数命令,setCommand为9位的byte数组) 
	* @return void    返回类型 
	 * @throws Exception 
	* @throws
	 */
    public void setCommand(byte[] setCommand) throws Exception{
    	   
	    	MessageDigest digest = MessageDigest.getInstance("MD5");
			
			digest.update(setCommand);
			byte[] afterMd5 = digest.digest();
			byte[] setsendbytes = new byte[25];
			for(int i=0;i<9;i++)
			{
				setsendbytes[i]=setCommand[i];
			}
			
			for(int i=9;i<9+afterMd5.length;i++)
			{
			   setsendbytes[i]=afterMd5[i-9];
			}
			byte[] revByte = this.sendCommandTCP(setsendbytes,ip,port,timeout);
			System.out.println("接收到的返回值："+revByte[2]+"_"+revByte[3]+"_"+revByte[4]+"_"+revByte[7]);
			
    }
    /**
     * 
    * @Title: getCommand 
    * @Description: TODO(获取当前比对值) 
    * @return void    返回类型 
    * @throws
     */
    public byte[] getCommand(byte getCommand) throws Exception{
    
    	MessageDigest digest = MessageDigest.getInstance("MD5");
    	digest.update(getCommand);
    	byte[] afterMd5 = digest.digest();
		byte[] getsendbytes = new byte[17];
		
		getsendbytes[0]=getCommand;

		for(int i=1;i<1+afterMd5.length;i++)
		{
			getsendbytes[i]=afterMd5[i-1];
		}
		byte[] revByte = this.sendCommandTCP(getsendbytes,ip,port,timeout);
		System.out.println("接收到的返回值："+revByte[2]+"_"+revByte[3]+"_"+revByte[4]+"_"+revByte[7]);
		
		return revByte;
    }
    /**
     * 
    * @Title: sendCommandTCP 
    * @Description: TODO(通过TCP链接发送命令) 
    * @return byte[]    返回类型 
    * @throws
     */
    private byte[] sendCommandTCP(byte[] sendByte,String ip,int port,int timeout)throws Exception {
		Socket cardSocket = new Socket(ip,port);
		cardSocket.setSoTimeout(timeout);//接收超时时间
		
		OutputStream outputStream ;//输出流
		outputStream = cardSocket.getOutputStream();
		InputStream inputStream;//输入流
		inputStream = cardSocket.getInputStream();
		byte[] revByte=new byte[50];//接收到得数组
	    //发送命令
		outputStream.write(sendByte);
		//接收指令
		inputStream.read(revByte);
		//System.out.println(revByte[2]+"_"+revByte[3]+"_"+revByte[4]+"_"+revByte[7]);
		//清空输入输出流
		outputStream.close();
		inputStream.close();
		return revByte;
	}
    
    public static void main(String[] args){
    	//取值
		byte getCommand=0x00;
    	byte[] setCommand = new byte[9];
		setCommand[0]=0x02; //msg type。 0x02:设置视频参数命令
		setCommand[1]=0x55;	//fixed byte
		setCommand[2]=(byte)0xA6; //A6: colorful bar A8:frame mode
		setCommand[3]=(byte)0xB0; //B0: 1080P60 B1:1080P50 B7:720P60
		setCommand[4]=(byte)0xC2; //C0:DVI C1:VGA C2:YPbPr  out
		setCommand[5]=(byte)0xD2; //D0:DVI D1:VGA D2:YPbPr  in
		setCommand[6]=(byte)0xE0; //E0:绝对偏差(彩条) E1:平均偏差(彩条) E2:自标准差(冻结帧) E3:自平均(冻结帧) E4:源标准差(冻结帧) E5:源平均(冻结帧)
		setCommand[7]=0x00;
		setCommand[8]=0x00;
		
		VideoCardNew vcn = new VideoCardNew();
		try {
			//发送视频参数命令设置命令
			vcn.setCommand(setCommand);
			
			//视频评价结果请求
			byte getByte = 0x00;
			vcn.getCommand(getByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}
