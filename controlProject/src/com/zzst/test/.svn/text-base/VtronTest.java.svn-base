package com.zzst.test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

import org.apache.log4j.PropertyConfigurator;

import com.zzst.util.ControlFactory;
import com.zzst.vtron.service.VtronObject;
import com.zzst.vtron.service.impl.vo.VtronVO;


/**
 *@Description
 *@date 2011-12-30下午07:13:50
 *@author ryan
 */
public class VtronTest {
	 static byte bswap(byte a)
	    {
	        byte b = 0;
	        for(int i = 0; i < 8; ++i)
	            b |= ((a & (1 << i)) == 0 ? 0 : 1) << (7-i);
	        return b;
	    }
	    
	    static void bprint(byte b)
	    {
	        for(int i = 7; i >= 0; --i)
	                System.out.print((b & (1 << i)) == 0 ? '0' : '1');
	        System.out.println();
	    }
	    
	    

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PropertyConfigurator.configure("D:/develop_C/zdq/controlProject/src/applog4j.properties");//加载.properties文件 
		try {
//			 byte   b = 0xF;
//		        bprint(b);
//		        b = bswap(b);
//		        bprint(b);
//		        System.out.println(0xBBBBBBBB);
//		        System.out.println(0xDDDDDDDD);
			new VtronTest().initCenterControlDate();
			VtronObject obj = null;//(VtronObject)ControlFactory.getVtronObject("10.6.22.248");
			if(obj!=null){
				System.out.println("对象不为空");
				//obj.setModel("model2");
				obj.getWallInfo("");
//				obj.setSourse("");
			}else{
				System.out.println("对象为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initCenterControlDate(){ 
		ArrayList<VtronVO> ccList = new ArrayList<VtronVO>();
		ccList.add(initCenterControl1());
//		ControlFactory.vtronInitDate(ccList);
	}
	  
	private VtronVO initCenterControl1(){

		VtronVO v = new VtronVO();
		v.setIp("10.6.22.248");
		v.setPort(5999);
		return v;
	}
}
