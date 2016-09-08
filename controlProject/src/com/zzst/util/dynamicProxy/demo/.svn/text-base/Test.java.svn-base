package com.zzst.util.dynamicProxy.demo;

import com.zzst.util.dynamicProxy.DynamicProxyHandler;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  DynamicProxyHandler handler = new DynamicProxyHandler(); 
		  User business = new UserImpl(); 
		  User businessProxy = (User) handler.bind(business); 
	      businessProxy.add();
	}

}
