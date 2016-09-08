package com.zzst.action.meeting.autocompare.histogram;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.security.MessageDigest;

public class VideoCardController {
	
	
	
    public String ip="192.168.1.10";
    public int port=7777;
    public int timeout=10000;
    public int x_min = 31;
    public int x_max = 226;
    public int GET_HISTOGRAM_SLEEP_TIME = 5000;
    
    public VideoCardController(String ip){
    	this.ip = ip;
    }
    
    public VideoCardController(String ip, int port){
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
			this.sendCommandTCP(setsendbytes,ip,port,timeout, 0, 1);
			//System.out.println("接收到的返回值："+revByte[2]+"_"+revByte[3]+"_"+revByte[4]+"_"+revByte[7]);
			
    }
    /**
     * 
    * @Title: getCommand 
    * @Description: TODO(获取当前比对值) 
    * @return void    返回类型 
    * @throws
     */
    public int[][] getCommand(byte getCommand, int multiple) throws Exception{
    
    	MessageDigest digest = MessageDigest.getInstance("MD5");
    	digest.update(getCommand);
    	byte[] afterMd5 = digest.digest();
		byte[] getsendbytes = new byte[17];
		
		getsendbytes[0]=getCommand;

		for(int i=1;i<1+afterMd5.length;i++)
		{
			getsendbytes[i]=afterMd5[i-1];
		}
		int[][] revByte = this.sendCommandTCP(getsendbytes,ip,port,timeout, GET_HISTOGRAM_SLEEP_TIME, multiple);
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
    private int[][] sendCommandTCP(byte[] sendByte,String ip,int port,int timeout, int sleepTime, int multiple)throws Exception {
    	int[][] rgbArray = new int[3][256];
    	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+ip+"================================"+port);
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
		inputStream.read(revByte);
		//
		int rcvlen=inputStream.read(revByte2);
		int rcvlen3=inputStream.read(revByte3);
		int rcvlen4=inputStream.read(revByte4);
		
		if(rcvlen > 512){
			buffer = new StringBuffer();
			//int[] iArray = new int[256];
			for(int i=0; i<256; i++ ){
				rgbArray[0][i] = (((revByte2[2*(i+1)] & 0x0ff) * 256) + (revByte2[2*(i+1)+1] & 0x0ff)) * multiple;
				buffer.append(rgbArray[0][i]);
				buffer.append(",");
			}
			System.out.println("\n**********R直方图数据****:" + buffer.toString());
			int s = 0;
			for(int i=x_min; i<= x_max; i++){
				s += rgbArray[0][i];
			}
			System.out.println("\n**********R直方图面积****s=" + s);
		}
		
		if(rcvlen3 > 512){
			buffer = new StringBuffer();
			//int[] iArray = new int[256];
			for(int i=0; i<256; i++ ){
				rgbArray[1][i] = (((revByte3[2*(i+1)] & 0x0ff) * 256) + (revByte3[2*(i+1)+1] & 0x0ff)) * multiple;
				buffer.append(rgbArray[1][i]);
				buffer.append(",");
			}
			System.out.println("\n**********G直方图数据****:" + buffer.toString());
			int s = 0;
			for(int i=x_min; i<= x_max; i++){
				s += rgbArray[1][i];
			}
			System.out.println("\n**********G直方图面积****s=" + s);
		}
		
		if(rcvlen4 > 512){
			buffer = new StringBuffer();
			//int[] iArray = new int[256];
			for(int i=0; i<256; i++ ){
				rgbArray[2][i] = (((revByte4[2*(i+1)] & 0x0ff) * 256) + (revByte4[2*(i+1)+1] & 0x0ff)) * multiple;
				buffer.append(rgbArray[2][i]);
				buffer.append(",");
			}
			System.out.println("\n**********B直方图数据****:" + buffer.toString());
			int s = 0;
			for(int i=x_min; i<= x_max; i++){
				s += rgbArray[2][i];
			}
			System.out.println("\n**********B直方图面积****s=" + s);
		}
		
		/* annotated by wangle 2013-9-4
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
		*/
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
		setCommand[7]=(byte)0xF1;// F1 多帧；F0：单帧
		setCommand[8]=0x00;
		
		VideoCardController vcn = new VideoCardController("10.1.6.81");
		
		vcn.x_min = 5;
		vcn.x_max = 255;
		try {
			//发送视频参数命令设置命令
			vcn.setCommand(setCommand);
			
			System.out.println("\n**********rgb the following****");
			
			//视频评价结果请求
			byte getByte = 0x00;
			int[][] rgbArray = vcn.getCommand(getByte, 1);
			for(int i=0; i<rgbArray.length; i++){
				for(int j=0; j<rgbArray[i].length; j++){
					System.out.print(rgbArray[i][j] + ",");
				}
				System.out.println("*******256*value*******");
			}
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
    	
    	
		String s = "A0";
    	int i = Integer.parseInt(s, 16);
    	byte b = (byte)i;
    	System.out.println(String.valueOf(b));
    	byte c = (byte)0xA8;
    	System.out.println(c);
    	*/
    } 
}
