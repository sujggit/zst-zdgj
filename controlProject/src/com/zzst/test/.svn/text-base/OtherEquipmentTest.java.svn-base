package com.zzst.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.otherEquipment.service.OtherEquipmentObject;
import com.zzst.util.ControlFactory;


/**
 *@Description
 *@date 2013-12-27下午05:35:23
 *@author ryan
 */
public class OtherEquipmentTest { 
	private static String ip = "10.1.9.170";
	
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/6dev/controlProject/src/applog4j.properties");//加载.properties文件 
		new OtherEquipmentTest().initDate();

		OtherEquipmentObject obj = ControlFactory.getOtherEquipmentObject(ip);
//		ControlFactory.callInspectOtherEquipmentNetStatus();
		int i=0;
		while(true){
			i++;
			System.out.println("############"+obj.getStatus());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 
		}
		
	}
	public void initDate(){ 
		Map<String,String[]> map = new HashMap<String,String[]>();
		String[] audio2 = new String[4];
		audio2[0]=ip;
		audio2[1]=ip;
		audio2[2]="";
		audio2[3]="aaa";
		map.put(ip, audio2);
		for(int i=0;i<20;i++){
			for(int j=0;j<2;j++){
				String ip = i+"."+j+".1.1";
				String[] audio = new String[4];
				audio[0]=ip;
				audio[1]=ip;
				audio[2]="23";
				audio[3]="aaa";
				map.put(ip, audio);	
			}
							
		}
		
		ControlFactory.otherEquipmentInitDate(map);
		System.out.println("初始化数据结束");
	}
}
