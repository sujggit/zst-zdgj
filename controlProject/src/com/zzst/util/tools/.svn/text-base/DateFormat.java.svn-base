package com.zzst.util.tools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;


/**
 *@Description	时间格式化
 *@date 2012-8-2上午09:53:33
 *@author ryan
 */
public class DateFormat {
	private static Logger logger = Logger.getLogger(DateFormat.class
			.getName());
	
	public static void main(String[] arg){
		System.out.println(DateFormat.format(new Timestamp(System.currentTimeMillis())));
	}
	
	public static String format(Timestamp time){
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //12小时制
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //24小时制 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "";
		try {
			Date date = formatter.parse(time.toString());
			dateString = formatter.format(date); 
		} catch (ParseException e) {
			logger.error("时间转换失败："+e.getMessage());
		}
		return dateString;
	}
}
