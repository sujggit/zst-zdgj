package com.zzst.action.meeting.filter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
 * @author zhangjy
 *  @date 2013-1130
 *  监控回话session
 */
public class ActiveUserListener implements HttpSessionListener {
	private static int sessionCount = 0;
	public static Map<String, HttpSession> sessionMaps = new HashMap<String, HttpSession>(); // 存放session的集合类
    
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		String sessionId = session.getId();
		sessionMaps.put(sessionId, session);
		sessionCount++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		sessionCount--;
		String sessionId = arg0.getSession().getId();
		sessionMaps.remove(sessionId);// 利用会话ID标示特定会话
	}
    
	public static void  sessionInterval(){
		
		try {
			Collection<HttpSession> c=sessionMaps.values();
			Iterator<HttpSession> iths=c.iterator();
			while(iths.hasNext()){
				HttpSession hs=iths.next();
				hs.invalidate();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getSessionCount() {
		return sessionCount;
	}

	public static Map<String, HttpSession> getSessionMaps() {
		return sessionMaps;
	}

}
