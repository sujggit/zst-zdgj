package com.zzst.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.enc.service.ENCObject;
import com.zzst.util.ControlFactory;
import com.zzst.util.initDate.DBHelp;


/**
 *@Description
 *@date 2012-4-17下午05:18:45
 *@author ryan
 */
public class EncTest {

	public static String aaa = "aa";
	public static String[] bbb = {"aa","aa","aa"};

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/zdq/controlProject/src/applog4j.properties");//加载.properties文件 
		try {
//			ControlFactory.eNCObjectInitDate(initEncDate());
			ControlFactory.eNCServerDate(initServerDate());
			ENCObject obj = (ENCObject)ControlFactory.getEncObject();
			if(obj!=null){
				System.out.println("######");
				obj.getIp();
			}else{
				System.out.println("对象为空");
			}
			 obj.setURLView("00:27:0e:3b:f0:ef", "http://172.100.100.30:8080/icmp/meeting/notice/noticeInfo.jsp?a=2ce4e49e36ec1d440136ec2094ec0004");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		
	
	public static String[] initServerDate(){ 
		String[] obj = new String[10];
		obj[0] = "172.100.100.30";
		obj[1] = "admin";
		obj[2] = "1234";
		obj[3] = "jdbc:mysql://172.100.100.30:3306/MediaDB?auotReconnect=true&useUnicode=true&characterEncoding=GB2312";
		obj[4] = "root";
		obj[5] = "1234";
		obj[6] = "mysql";
		return obj;
	}
	
	 
}