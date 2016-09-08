package com.zzst.action.meeting.util.authorization;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.cbf.log.CbfLogger;
import com.zzst.action.meeting.util.MeetingAppConfig;
import com.zzst.action.meeting.util.tools.Eryptogram;
import com.zzst.action.meeting.util.tools.FileHelper;
import com.zzst.action.meeting.util.tools.SoftWareUtils;

public class AuthorHelper {
	private static Logger logger = CbfLogger.getLogger(AuthorHelper.class.getName());
	public static int authorMonth = 1;
	/**
	 * 得到解密字符串
	 * @param str
	 * @return	String
	 */
	public static String getDecryptData(String key,String str){
		Eryptogram e=new Eryptogram(key);
		return e.decryptData(str);
	}
	
	/**
	 * 读取授权文件，设置相关变量
	 */
	public static void	configInit(){
		try{
			String fileName = SoftWareUtils.getCode();
	        
			String classPath = FileHelper.class.getResource("/").getPath()+"/WEB-INF/classes/"+fileName+".lic";
	        ArrayList<String> list = FileHelper.readFileByLines(classPath);
	        if(list == null || list.size()==0 || list.size()!=10){
	        	String authorFileName = (AuthorHelper.class.getResource("").getPath()+"author.java").substring(1);
	        	ArrayList<String> listFile = FileHelper.readFileByLines(authorFileName);
	        	if(listFile == null || listFile.size()==0){
	        		logger.info("系统第一次启用");
//	        		第一次授权启动的日期
	    		    FileHelper.createFile(authorFileName, new Eryptogram(fileName).encryptData(System.currentTimeMillis()+""));
	        	}else{
	        		String ti = getDecryptData(fileName,listFile.get(0));
	        		if(ti!=null&&ti.length()!=0){
	        			Calendar c = Calendar.getInstance();
	    	        	c.setTimeInMillis(Long.parseLong(ti));
	    	        	c.add(Calendar.MONTH, authorMonth);
	    	        	c.add(Calendar.DAY_OF_MONTH, 1);
	    	        	MeetingAppConfig.authorization_date = new Timestamp(c.getTimeInMillis()); 
	    	        	logger.info("第一次使用日期：:"+new Timestamp(Long.parseLong(ti)));
	    	        	logger.info("试用截止期:"+MeetingAppConfig.authorization_date);
	        		}
	        		return;
	        	}
	        	
	        	logger.warn("没有授权,默认授权为：");	
	        	Calendar c = Calendar.getInstance();
	        	c.add(Calendar.MONTH, authorMonth);
				c.add(Calendar.DAY_OF_MONTH, 1);
				c.clear(Calendar.AM_PM);
				c.clear(Calendar.HOUR);
				c.clear(Calendar.HOUR_OF_DAY);
	 			c.clear(Calendar.MINUTE);
	 			c.clear(Calendar.MILLISECOND);
	 			c.clear(Calendar.SECOND);
	 			
				MeetingAppConfig.authorization_date = new Timestamp(c.getTimeInMillis()); //时间限制
		        logger.warn("授权期限："+MeetingAppConfig.authorization_date);
		        logger.warn("授权中控："+MeetingAppConfig.authorization_cc_num);
		        logger.warn("授权mcu："+MeetingAppConfig.authorization_mcu_num);
		        logger.warn("授权终端："+MeetingAppConfig.authorization_ter_num);
		        logger.warn("授权会议室："+MeetingAppConfig.authorization_room_num);
		        logger.warn("授权用户："+MeetingAppConfig.authorization_user_num);
	        	return;
	        }
	        
	        //2019-12-30
	        String date = getDecryptData(fileName,list.get(3));
	        String[] info = date.split("-");
	        Calendar c = Calendar.getInstance();
			c.clear();
			c.set(Calendar.YEAR, Integer.parseInt(info[0]));
			c.set(Calendar.MONTH, Integer.parseInt(info[1])-1);
			c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(info[2])+1);//授权当前有效，到下一天的零点到期
			MeetingAppConfig.authorization_date = new Timestamp(c.getTimeInMillis()); //时间限制
			MeetingAppConfig.authorization_user_num	=	Integer.parseInt(getDecryptData(fileName,list.get(2)));//用户数量
	        MeetingAppConfig.authorization_mcu_num 	=	Integer.parseInt(getDecryptData(fileName,list.get(4)));//mcu数量
	        MeetingAppConfig.authorization_cc_num	=	Integer.parseInt(getDecryptData(fileName,list.get(5)));//中控数量
	        MeetingAppConfig.authorization_ter_num	=	Integer.parseInt(getDecryptData(fileName,list.get(6)));//终端数量
	        MeetingAppConfig.authorization_room_num	=	Integer.parseInt(getDecryptData(fileName,list.get(7)));//会议室数量	
	        logger.info("已授权");
	        logger.info("授权期限："+MeetingAppConfig.authorization_date);
	        logger.info("用户数量："+MeetingAppConfig.authorization_user_num);
	        logger.info("mcu："+MeetingAppConfig.authorization_mcu_num);
	        logger.info("中控："+MeetingAppConfig.authorization_cc_num);
	        logger.info("终端："+MeetingAppConfig.authorization_ter_num);
	        logger.info("会议室："+MeetingAppConfig.authorization_room_num);
	        
	        
		}catch(Exception e){
			logger.error("授权文件异常，默认授权：时长为30天,1用户、1MCU、1中控、1终端、1会议室");
			logger.error("异常："+e.getMessage());
			Calendar c = Calendar.getInstance();
 			c.add(Calendar.MONTH, authorMonth);
 			c.add(Calendar.DAY_OF_MONTH, 1);
 			c.clear(Calendar.AM_PM);
 			c.clear(Calendar.HOUR);
 			c.clear(Calendar.MINUTE);
 			c.clear(Calendar.MILLISECOND);
 			c.clear(Calendar.SECOND);
			MeetingAppConfig.authorization_date = new Timestamp(c.getTimeInMillis()); //时间限制
		}
		
	}
	
	public static void main(String[] str){
		try {
//			AuthorHelper.configInit();
			String authorFileName = (AuthorHelper.class.getResource("").getPath()+"author.java").substring(1);
			System.out.println(authorFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
