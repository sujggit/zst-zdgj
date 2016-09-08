package com.zzst.vtron.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.zzst.util.ExcuteResultVO;
import com.zzst.vtron.service.VtronObject;
import com.zzst.vtron.service.impl.communication.VtronCommandHelp;
import com.zzst.vtron.service.impl.communication.VtronThread;
import com.zzst.vtron.service.impl.vo.VtronVO;


/**
 *@Description
 *@date 2012-8-12上午11:43:14
 *@author ryan
 */
public class VtronObjectImpl extends VtronObject{
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	private VtronThread thread= null;
	private static Logger logger = Logger.getLogger(VtronObjectImpl.class
			.getName());
	
	public static void main(String[] arg){
		System.out.println(new VtronObjectImpl().getHex("JUjjjjjj"));
	}
	
//	0-3是BB 开始符
	//4-7:数据长度
	//8：指令
	//9：执行状态，是否成功 0 成功
	//10-13:屏幕窗口数量
	//14：窗口类型 1为处理器类型
	//15：信号源类型
	//16-19:窗口句柄
	//20-23:窗口名称长度
	//24-名称长度：窗口名称
	//循环句柄
	//最后4为DD结束符
	public VtronObjectImpl(){}
	public VtronObjectImpl(VtronVO vtronVO) {
		super(vtronVO);
		
		this.ip = vtronVO.getIp();
		this.port = vtronVO.getPort();
		try{
			thread = new VtronThread(ip,port);	
		}catch(Exception e){
			thread = null;
		}
		
	}

	@Override
	public ExcuteResultVO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExcuteResultVO getModelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExcuteResultVO setModel(String modelID) {
		String command = "0000000b";
		command = command+"08000000";
		command = command+"06"+getHex(modelID);
		
//		System.out.println(command);
		try{
			if(thread!=null)
			thread.sendCommandByReturn(command);
		}catch(Exception e){
			logger.error("VtronObjectImpl	setModel	error："+e.getMessage());
		}
		return null;
	}

	public String getHex(String str){
		String strHex = "0123456789ABCDEF";
		byte[] bArray = str.getBytes();
		StringBuffer  sb = new StringBuffer();
        for (int i = 0; i < bArray.length; i++) {
        	sb.append(strHex.charAt(0xf & bArray[i] >> 4)+ strHex.charAt(bArray[i] & 0xf));
        }
        return sb.toString();
	}

	@Override
	public ExcuteResultVO modelPieview() {
		String command = "00000008";
		command = command+"0F000000";
		command = command+"06"+getHex("111");
		
//		System.out.println(command);
		try{
			if(thread!=null)
			thread.sendCommandByReturn(command);
			
			resultVO.setSuccess(true);
		}catch(Exception e){
			logger.error("VtronObjectImpl	setModel	error："+e.getMessage());
			resultVO.setSuccess(false);
		}
		return resultVO;
	}

	@Override
	public ExcuteResultVO getWallInfo(String wallName) {
//		String command = "00000008";
//		command = command+"0F000000";
//		command = command+"03"+getHex("111");
//		
		String command = "0F1010080301000000000000000";
		
//		System.out.println(command);
		try{
			if(thread!=null)
			thread.sendCommandByReturn(command);
			
			resultVO.setSuccess(true);
		}catch(Exception e){
			logger.error("VtronObjectImpl	setModel	error："+e.getMessage());
			resultVO.setSuccess(false);
		}
		return resultVO;
	}

	@Override
	public ExcuteResultVO setSourse(String sourseName) {
		String command = "0000000B";
		command = command+"09000000";
		command = command+"06"+getHex("vlink1");
		
		try{
			if(thread!=null)
			thread.sendCommandByReturn(command);
			
			resultVO.setSuccess(true);
		}catch(Exception e){
			logger.error("VtronObjectImpl	setModel	error："+e.getMessage());
			resultVO.setSuccess(false);
		}
		return resultVO;
	}

}
