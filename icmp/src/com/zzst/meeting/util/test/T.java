package com.zzst.meeting.util.test;

import com.zzst.action.meeting.util.tools.Eryptogram;
import com.zzst.action.meeting.util.tools.MD5;


public class T {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eryptogram e=new Eryptogram();
		System.out.println(e.encryptData("7c5EGIN5"));
		System.out.println(e.encryptData("123456")+"===pd");
		System.out.println("ss:"+e.encryptData("7c5EGIN5"));
		System.out.println(e.encryptData("root")+"==root");
		long l = System.currentTimeMillis();
		
		try{
//			DatagramSocket s = new DatagramSocket("11.3.22.22",80);
//			s.setSoTimeout(3);
		}catch(Exception e1){
			
		}
		System.out.println(System.currentTimeMillis()-l);
		
		//		"".split("-")
//		String str="jdbc:mysql://127.0.0.1:3306/icmp?characterEncoding=gb2312";
//		String[] strs=str.split(":");
//		for(String s:strs){
//			System.out.println(s);
//		}
		
		String str = "123456";
		System.out.println(MD5.GetMD5Code2(str));
	}

}
