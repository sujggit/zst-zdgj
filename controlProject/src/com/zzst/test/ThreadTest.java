package com.zzst.test;

import org.apache.log4j.PropertyConfigurator;


/**
 *@Description
 *@date 2013-12-27下午03:43:29
 *@author ryan
 */
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("D:/develop_C/6dev/icmp/src/applog4j.properties");//加载.properties文件
		// TODO Auto-generated method stub
		long l = java.lang.Runtime.getRuntime().freeMemory();
		System.out.println(l);
		System.out.println(java.lang.Runtime.getRuntime().maxMemory());
		System.out.println(java.lang.Runtime.getRuntime().totalMemory());
		new CCTest().initCenterControlList();
		new TerminalTest().initTerminalList();

		try {
			Thread.sleep(999999999);
		} catch (InterruptedException e) {
		}
	}
}