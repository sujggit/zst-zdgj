package com.zzst.action.meeting.util;

import java.util.Map;

import ognl.DefaultTypeConverter;



public class FloatConverter extends DefaultTypeConverter { 
	@Override 
	public Object convertValue(Map context, Object value, Class toType) { 
	//	 TODO Auto-generated method stub 
		if (toType == Float.class) {  //浏览器向服务器提交时，进行String to Float的转换
			Float floatValue = 0f;
			String floatString = null; 
			String[] params = (String[])value; 
			floatString = params[0]; //获取日期的字符串 
			try{ 
				floatValue = Float.parseFloat(floatString);//进行转换
				
				return floatValue;
			}catch(Exception e) { 
				 
			} 
			 
			return null; 
		}
	
	else if (toType == String.class) {   //服务器向浏览器输出时，进行Float to String的类型转换 
		Float floatValue = (Float)value; 
		return String.valueOf(floatValue);
	} 
	return null; 
	}
}

