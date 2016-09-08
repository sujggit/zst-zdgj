package com.zzst.test;

import java.util.ArrayList;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.kst.videocard.service.VideocardObject;
import com.zzst.kst.videocard.vo.VideoCardVO;
import com.zzst.util.ControlFactory;


/**
 *@Description
 *@date 2013-1-5下午07:29:26
 *@author ryan
 */
public class KstVideoCardTest {

	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/5ICMP/controlProject/src/applog4j.properties");//加载.properties文件 
		try {
			new KstVideoCardTest().initDate();
			VideocardObject obj = (VideocardObject)ControlFactory.getKstVideocardObject("10.116.106.45");
			obj.setModel("aaaaaaaa".getBytes());
			VideocardObject obj2 = (VideocardObject)ControlFactory.getKstVideocardObject("10.116.106.35");
			obj2.setModel("qqqqqqqqqqq".getBytes());
		}catch(Exception e){
			
		}
	}
	
	public void initDate(){ 
		ArrayList<VideoCardVO> list = new ArrayList<VideoCardVO>();
		VideoCardVO kstVO = new VideoCardVO();
		kstVO.setIp("10.116.106.45");
		kstVO.setName("aa");
		kstVO.setTcpPort(111);
		kstVO.setUdpPort(222);
		list.add(kstVO);
		kstVO = new VideoCardVO();
		kstVO.setIp("10.116.106.35");
		kstVO.setName("bbb");
		kstVO.setTcpPort(111);
		kstVO.setUdpPort(222);
		list.add(kstVO);
		ControlFactory.kstVideocardInitDate(list);
	}
}
