package com.zzst.action.meeting.autocompare.histogram;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.MessageDigest;

public class VideoCardNew_1 {
	
    public String ip="192.168.1.10";
    public int port=7777;
    public int timeout=10000;
    public int x_min = 5;
    public int x_max = 255;
    public int GET_HISTOGRAM_SLEEP_TIME = 5000;
    
    public VideoCardNew_1(String ip){
    	this.ip = ip;
    }
    
    public VideoCardNew_1(String ip, int port){
    	this.ip = ip;
    	this.port = port;
    }
    
	/**
	 * 
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
			int[][] revByte = this.sendCommandTCP(setsendbytes,ip,port,timeout, 0);
			//System.out.println("接收到的返回值："+revByte[2]+"_"+revByte[3]+"_"+revByte[4]+"_"+revByte[7]);
			
    }
    /**
     * 
    * @Title: getCommand 
    * @Description: TODO(获取当前比对值) 
    * @return void    返回类型 
    * @throws
     */
    public int[][] getCommand(byte getCommand) throws Exception{
    
    	MessageDigest digest = MessageDigest.getInstance("MD5");
    	digest.update(getCommand);
    	byte[] afterMd5 = digest.digest();
		byte[] getsendbytes = new byte[17];
		
		getsendbytes[0]=getCommand;

		for(int i=1;i<1+afterMd5.length;i++)
		{
			getsendbytes[i]=afterMd5[i-1];
		}
		int[][] revByte = this.sendCommandTCP(getsendbytes,ip,port,timeout, GET_HISTOGRAM_SLEEP_TIME);
		//System.out.println("接收到的返回值："+revByte[2]+"_"+revByte[3]+"_"+revByte[4]+"_"+revByte[7]);
		return revByte;
    }
    /**
     * 
    * @Title: sendCommandTCP 
    * @Description: TODO(通过TCP链接发送命令) 
    * @return byte[]    返回类型 
    * @throws
     */
    private int[][] sendCommandTCP(byte[] sendByte,String ip,int port,int timeout, int sleepTime)throws Exception {
		int[][] rgbArray = new int[3][256];
    	Socket cardSocket = new Socket(ip,port);
		cardSocket.setSoTimeout(timeout);//接收超时时间
		
		OutputStream outputStream ;//输出流
		outputStream = cardSocket.getOutputStream();
		InputStream inputStream;//输入流
		inputStream = cardSocket.getInputStream();
		byte[] revByte=new byte[38];//接收到得数组
		byte[] revByte2=new byte[539];//接收到得数组
		byte[] revByte3=new byte[539];//接收到得数组
		byte[] revByte4=new byte[539];//接收到得数组
	    //发送命令
		outputStream.write(sendByte);
		if(sleepTime > 0){
			Thread.sleep(sleepTime);
		}
		//接收指令
		StringBuffer buffer = new StringBuffer();
		int rcvlen;
		rcvlen=inputStream.read(revByte);
		System.out.println("len0:"+rcvlen);
		rcvlen=inputStream.read(revByte2);
		System.out.println("len1:"+rcvlen);
		if(rcvlen > 512){
			
			int ii = 0;
			for(int i=2; i<2+512; ){
				rgbArray[0][ii] = ((revByte2[i] & 0x0ff) * 256) + (revByte2[i+1] & 0x0ff);
				buffer.append(rgbArray[0][ii]);
				ii++;
				i = i+2;
				if(i < 2+512){
					buffer.append(",");
				}
			}
			System.out.println("\n**********R直方图数据****:" + buffer.toString());
			int s = 0;
			for(int i=x_min; i<= x_max; i++){
				s += rgbArray[0][i] * i;
			}
			System.out.println("\n**********R直方图面积****s=" + s);
		}
		rcvlen=inputStream.read(revByte3);
		System.out.println("len2:"+rcvlen);
		if(rcvlen > 512){
			buffer = new StringBuffer();
			
			int ii = 0;
			for(int i=2; i<2+512; ){
				rgbArray[1][ii] = ((revByte3[i] & 0x0ff) * 256) + (revByte3[i+1] & 0x0ff);
				buffer.append(rgbArray[1][ii]);
				ii++;
				i = i+2;
				if(i < 2+512){
					buffer.append(",");
				}
			}
			System.out.println("\n**********G直方图数据****:" + buffer.toString());
			int s = 0;
			for(int i=x_min; i<= x_max; i++){
				s += rgbArray[1][i] * i;
			}
			System.out.println("\n**********G直方图面积****s=" + s);
		}
		rcvlen=inputStream.read(revByte4);
		System.out.println("len3:"+rcvlen);
		if(rcvlen > 512){
			buffer = new StringBuffer();
			
			int ii = 0;
			for(int i=2; i<2+512; ){
				rgbArray[2][ii] = ((revByte4[i] & 0x0ff) * 256) + (revByte4[i+1] & 0x0ff);
				buffer.append(rgbArray[2][ii]);
				ii++;
				i = i+2;
				if(i < 2+512){
					buffer.append(",");
				}
			}
			System.out.println("\n**********B直方图数据****:" + buffer.toString());
			int s = 0;
			for(int i=x_min; i<= x_max; i++){
				s += rgbArray[2][i] * i;
			}
			System.out.println("\n**********B直方图面积****s=" + s);
		}
		
		System.out.println("\n*******接受的原始数据*******");
		System.out.println("\n*******评测参数数据包*******");
		for(byte b : revByte){
			System.out.print(Integer.toHexString(b & 0x0ff) + ",");
		}
		System.out.println("\n*******R直方图接受数据*******");
		for(byte b : revByte2){
			System.out.print(Integer.toHexString(b & 0x0ff) + ",");
		}
		System.out.println("\n*******G直方图接受数据*******");
		for(byte b : revByte3){
			System.out.print(Integer.toHexString(b & 0x0ff) + ",");
		}
		System.out.println("\n*******B直方图接受数据*******");
		for(byte b : revByte4){
			System.out.print(Integer.toHexString(b & 0x0ff) + ",");
		}
		
		
		//System.out.println(revByte[2]+"_"+revByte[3]+"_"+revByte[4]+"_"+revByte[7]);
		//清空输入输出流
		outputStream.close();
		inputStream.close();
		return rgbArray;
	}
    
    public static void main(String[] args){
    	
    	//取值
		byte getCommand=0x00;
    	byte[] setCommand = new byte[9];
		setCommand[0]=0x02; //msg type。 0x02:设置视频参数命令
		setCommand[1]=0x55;	//fixed byte
		setCommand[2]=(byte)0xA8; //A6: colorful bar A8:frame mode
		setCommand[3]=(byte)0xB7; //B0: 1080P60 B1:1080P50 B7:720P60
		setCommand[4]=(byte)0xC2; //C0:DVI C1:VGA C2:YPbPr  out
		setCommand[5]=(byte)0xD2; //D0:DVI D1:VGA D2:YPbPr  in
		setCommand[6]=(byte)0xE5; //E0:绝对偏差(彩条) E1:平均偏差(彩条) E2:自标准差(冻结帧) E3:自平均(冻结帧) E4:源标准差(冻结帧) E5:源平均(冻结帧)
		setCommand[7]=0x00;
		setCommand[8]=0x00;
		
		VideoCardNew_1 vcn = new VideoCardNew_1( "10.1.6.41");
		
		vcn.x_min = 5;
		vcn.x_max = 255;
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
		
		/*
    	String s = "A0";
    	int i = Integer.parseInt(s, 16);
    	byte b = (byte)i;
    	System.out.println(String.valueOf(b));
    	
    	byte b2 = (byte)0xA0;
    	System.out.println(String.valueOf(b2));
    	
    	
    	byte b = -116;
    	System.out.println(Integer.toHexString(b));
    	System.out.println(b & 0x0ff);
    	*/
		//int i = Integer.parseInt("0xec", 10) * 256 + 1;
		//System.out.println("aaaa **** :" + i);
    } 
}
