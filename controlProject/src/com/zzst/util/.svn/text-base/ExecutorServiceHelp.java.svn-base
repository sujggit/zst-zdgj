package com.zzst.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 公共线程接口
 *@author	ryan
 *@since	2010-12-3下午02:59:03
 *@version	1.0
 */

public class ExecutorServiceHelp {
	
	private static int	poolSize = 10;/** 单个cpu中的最大工作线程 */
	
	/** Runtime.getRuntime().availableProcessors  提取当前系统CPU数目*/
	
	public static ExecutorService	executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*poolSize);
	
	
	public static	Map<String,Thread>		threadMap = new HashMap<String,Thread>();
}