package com.zzst.action.meeting.util.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件的基础操作类
 * @author zhangjz
 * @since	2013-8-9
 */

public class PropertiesUtil {

	/**
	 * 根据key获取值
	 * @param filePath properties文件路径
	 * @param key 
	 * @return
	 */
	public  String readValue(String file,String key) {
		  Properties props = new Properties();
		  String path = getClass().getResource("/WEB-INF/classes/").getPath();
		        try {
		         InputStream in = new BufferedInputStream (new FileInputStream(path+file));
		         props.load(in);
		         String value = props.getProperty (key);
		            System.out.println(key+value);
		            return value;
		        } catch (Exception e) {
		         e.printStackTrace();
		         return null;
		        }
		 }
	
	public static void main(String[] args){
		PropertiesUtil pu = new PropertiesUtil();
		String val = pu.readValue("ftp.properties", "ftpService");
		System.out.println(val);
	}
	
	
}
