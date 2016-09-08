package com.zzst.util.dynamicProxy;

public class InterceptorClass {

	  public void before(){ 
		  System.out.println("拦截器:before()!"); 
	  } 
	  public void after(){ 
		  System.out.println("拦截器after()!"); 
	  } 
}
