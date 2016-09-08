package com.zzst.action.meeting.util;

import java.util.Collection;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

public class ReverseDWR {
	
	
	public void sendMsg(){
			 //得到上下文  
			WebContext contex = WebContextFactory.get();  
			         
			 //得到要推送到 的页面  dwr3为项目名称 ， 一定要加上。  
			 Collection<ScriptSession> sessions = contex.getScriptSessionsByPage("/icmp/showMsg.jsp");  
				          
			Util util = new Util(sessions);  
				          
			//下面是创建一个javascript脚本 ， 相当于在页面脚本中添加了一句  show(msg);   
		    ScriptBuffer sb = new ScriptBuffer();  
			sb.appendScript("show(");  
			sb.appendData("我是后台推送的消息");  
		    sb.appendScript(")");  
			          
	        //推送  
			util.addScript(sb);  
		} 
	
	
	

	}

