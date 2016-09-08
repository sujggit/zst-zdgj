package com.zzst.meeting.dwr.dataShare;

public class VLinkHelper {
	/**
	 * 根据IP得到数据源代码
	 * 
	 * @param op_ip 操作方IP
	 */
	public static String getSourceNameForIP(String op_ip){
		String sourceName = "";
		
		//TODO
		
		if(op_ip!=null && !"".equals(op_ip)){
			if("10.215.9.50".equals(op_ip)){
				sourceName = "RH";
			}else if("10.6.22.250".equals(op_ip)){
				sourceName = "BJ";
			}
		}
		
		return sourceName;
	}
}
