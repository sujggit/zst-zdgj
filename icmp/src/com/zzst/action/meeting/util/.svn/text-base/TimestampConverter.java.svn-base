package com.zzst.action.meeting.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import ognl.DefaultTypeConverter;



public class TimestampConverter extends DefaultTypeConverter { 
	private static final DateFormat[] ACCEPT_DATE_FORMATS = { 
	new SimpleDateFormat("dd/MM/yyyy"), 
	new SimpleDateFormat("yyyy-MM-dd HH:mm"), 
	new SimpleDateFormat("yyyy-MM-dd"), 
	new SimpleDateFormat("yyyy/MM/dd") 
	};  //支持转换的日期格式 
	@Override 
	public Object convertValue(Map context, Object value, Class toType) { 
	//	 TODO Auto-generated method stub 
		if (toType == Timestamp.class) {  //浏览器向服务器提交时，进行String to Timestamp的转换 
			Date date = null; 
			String dateString = null; 
			String[] params = (String[])value; 
			dateString = params[0]; //获取日期的字符串 
			for (DateFormat format : ACCEPT_DATE_FORMATS) { 
				try{ 
					Date temp = format.parse(dateString); //遍历日期支持格式，进行转换
					return  new Timestamp(temp.getTime());
				}catch(Exception e) { 
					continue; 
				} 
			} 
			return null; 
		}
	
	else if (toType == String.class) {   //服务器向浏览器输出时，进行Timestamp to String的类型转换 
		Timestamp timestamp = (Timestamp)value; 
		Date tempDate = new Date(timestamp.getTime());
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(tempDate); //输出的格式是yyyy-MM-dd hh:mm
	} 
	return null; 
	}
}

