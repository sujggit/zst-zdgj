package com.zzst.centerContor.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.zzst.centerContor.service.CenterControlObjectHelp;
import com.zzst.centerContor.service.impl.communication.CenterControlClientThread;
import com.zzst.centerContor.service.impl.communication.CommandHelp;
import com.zzst.centerContor.service.impl.communication.ControlCommandHelp;
import com.zzst.centerContor.vo.MatrixSwitchVO;
import com.zzst.util.ExcuteResultVO;


/**
 *@Description	矩阵控制
 *@date 2011-12-20下午04:19:02
 *@author ryan
 */
public class MatrixSwitchImpl {
	private static Logger logger = Logger.getLogger(MatrixSwitchImpl.class
			.getName());
	
	
	private String centerControlIP  ;
	private int centerControlPort  ;
	private MatrixSwitchVO matrixVO = new MatrixSwitchVO();
	
	private ExcuteResultVO resultVO = new ExcuteResultVO();
	
	public MatrixSwitchImpl(String ip,int port,MatrixSwitchVO vo){
		this.centerControlIP = ip;
		this.centerControlPort = port;
		this.matrixVO = vo;
	}
	
	/**
	 * 矩阵切换操作
	 * @param in
	 * @param out
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO matrixSwitch(String in ,String out){
		logger.info("矩阵设备：matrixSw："+in+" out："+out);
		try{
//				add by ryan on 2012-07-13  兼容一对多切换时 ！号分隔
				String command = "";
				if(out!=null&&out.length()>0&&out.indexOf("!")>0){//多个输出
					String[] ou = out.split("!");
					String temp = "";
					for(String o : ou){
						command  = ControlCommandHelp.MATRIX_SWITCH.replaceFirst("##1", matrixVO.getId());
						command	 = command.replaceFirst("##2", in);
						command	 = command.replaceFirst("##3", o);
						temp += command+"!";
						//Thread.sleep(CenterControlObjectHelp.DEF_MIN);
					}
					if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(temp)){
						resultVO.setSuccess(true);
					}
				}else{//一个输出
					command  = ControlCommandHelp.MATRIX_SWITCH.replaceFirst("##1", matrixVO.getId());
					command	 = command.replaceFirst("##2", in);
					command	 = command.replaceFirst("##3", out);
					if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
						resultVO.setSuccess(true);
					}
				}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("矩阵切换异常："+e.getMessage());
		}
		resultVO.setObject(matrixVO);
		logger.info("矩阵设备：matrixSwitch	end		in："+in+" out："+out);
		return resultVO;
	}
	
	/**
	 * 矩阵一对多切换操作
	 * @param in
	 * @param String[] out
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO matrixSwitch(String in ,String[] out){
		logger.info("矩阵设备：matrixSwitch	begin	in："+in+" out："+out);
		String command  = ControlCommandHelp.MATRIX_SWITCH.replaceFirst("##1", matrixVO.getId());
		command	= command.replaceFirst("##2", in);
		for(String s : out){
			command	= command.replaceFirst("##3", s);
			try{
				if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
					resultVO.setSuccess(true);
				}
				Thread.sleep(400);
			}catch(Exception e){
				resultVO.setSuccess(false);
				resultVO.setDes(e.getMessage());
				logger.error("矩阵切换异常："+e.getMessage());
			}
		}
		
		resultVO.setObject(matrixVO);
		logger.info("矩阵设备：matrixSwitch	end		in："+in+" out："+out);
		return resultVO;
	}
	
	/**
	 * 提取矩阵上所有的切换对应关系
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO matrixSwitchList(){
		logger.info("矩阵设备：matrixSwitchList	begin");
		String command  = ControlCommandHelp.MATRIX_SWITCH_INFO.replaceFirst("##1", matrixVO.getId());
		try{
			if(new CenterControlClientThread(centerControlIP,centerControlPort).sendCommand(command)){
				resultVO.setSuccess(true);
			}
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("矩阵提取切换对应关系时异常："+e.getMessage());
		}
		resultVO.setObject(matrixVO);
		logger.info("矩阵设备：matrixSwitchList	end");
		return resultVO;
	}
	
	/**
	 * 输出对应的输入
	 * @return
	 */
	public  ExcuteResultVO matrixSwitchFrom(String toUnm){
		logger.info("矩阵设备：matrixSwitchFrom	begin  toUnm："+toUnm);
		try{
			String info = matrixVO.getAllSwitch();
			String inf = info.substring(info.indexOf("SWITCH>")+7, info.length());
			String[] s = inf.split(",");
			for(String ss : s){
				String[] sss = ss.split("->");
				if(toUnm.equalsIgnoreCase(sss[0])){
					resultVO.setObject(sss[1]);
				}
			}
			resultVO.setSuccess(true);
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("矩阵提取输出对应的输入时异常："+e.getMessage());
		}
		logger.info("矩阵设备：matrixSwitchFrom	end	  toUnm："+toUnm);
		return resultVO;
	}
	
	/**
	 * 输入对应的输出列表
	 * @return ExcuteResultVO
	 */
	public  ExcuteResultVO matrixSwitchTo(String fromUnm){
		logger.info("矩阵设备：matrixSwitchTo	begin  toUnm："+fromUnm);
//		MATRIX.1:INFO>SWITCH>1->0,2->0,3->0,4->0 
		//输出->输入
		try{
			String info = matrixVO.getAllSwitch();
			logger.info("全部的切换："+info);
			if(info==null||info.length()==0){
				resultVO.setSuccess(false);
				resultVO.setDes("没有切换信息");
				return resultVO;
			}
			String inf = info.substring(info.indexOf("SWITCH>")+7, info.length());
			String[] s = inf.split(",");
			Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
			for(String ss : s){
				String[] sss = ss.split("->");
				String inNum = "";
				String outNum = "";
				if(sss[1]==null||sss[1].length()==0){
					inNum = "00";
				}else if(sss[1].length()==1){
					inNum = "0"+sss[1];
				}else{
					inNum = sss[1];
				}
				
				if(sss[0]==null||sss[0].length()==0){
					outNum = "00";
				}else if(sss[0].length()==1){
					outNum = "0"+sss[0];
				}else{
					outNum = sss[0];
				}
//				logger.info(inNum+"输入==输出"+outNum);
				if("00".equalsIgnoreCase(inNum)){
					continue;
				}
				if(map.get(inNum)==null){
//					logger.info("第一次存储======");
					ArrayList<String> list = new ArrayList<String>();
					list.add(outNum);
					map.put(inNum, list);
				}else{
//					logger.info("多次存储#####");
					ArrayList<String> list = map.get(inNum);
//					logger.info("已经存储多少次======"+list.size());
					list.add(outNum);
					map.put(inNum, list);
				}
//				logger.info("存储成功########"+map.get(inNum));
			}
			resultVO.setSuccess(true);
			resultVO.setObject(map.get(fromUnm));
		}catch(Exception e){
			resultVO.setSuccess(false);
			resultVO.setDes(e.getMessage());
			logger.error("矩阵提取输入对应的输出时异常："+e.getMessage());
		}
		logger.info("矩阵设备：matrixSwitchTo	end	  toUnm："+fromUnm);
		return resultVO;
	}
	
}
