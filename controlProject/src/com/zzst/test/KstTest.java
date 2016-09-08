package com.zzst.test;

import java.util.ArrayList;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.kst.service.KstObject;
import com.zzst.kst.service.impl.vo.KstVO;
import com.zzst.util.ControlFactory;


/**
 *@Description
 *@date 2011-12-30下午07:13:50
 *@author ryan
 */
public class KstTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/6dev/icmp/src/applog4j.properties");//加载.properties文件 
		try {
			new KstTest().initDate();
			KstObject obj = (KstObject)ControlFactory.getKstObject("10.1.6.93");
//			obj.stopLiveMeet("3536");
//			if(obj!=null){
//				System.out.println("===取得对象====");
//				obj.getCamerasbyGroupID("0c5ce42f-ba31-4b7a-8173-79ecae4a73ca");
////				obj.getMCUProx();
//			}else{
//				System.out.println("对象为空");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initDate(){ 
		ArrayList<KstVO> list = new ArrayList<KstVO>();
		KstVO kstVO = new KstVO();
		kstVO.setIp("10.1.6.93");
		kstVO.setVideoIP("10.1.6.94");
		kstVO.setVideoPort(10000);
		list.add(kstVO);
		
		ControlFactory.kstInitDate(list);
	}
}
