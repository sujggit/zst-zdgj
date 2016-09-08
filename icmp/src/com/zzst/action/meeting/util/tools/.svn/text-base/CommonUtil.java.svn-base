package com.zzst.action.meeting.util.tools;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CommonUtil {
	
	/**
	 * 根据map的value获取key
	 * @param map
	 * @param val
	 * @return
	 */
	public static Object getMapKey(Map map,Object val){
		Object obj = null;
		
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			if(entry.getValue().equals(val)){
				obj = entry.getKey();
			}
		}
		
		return obj;
	}
}
