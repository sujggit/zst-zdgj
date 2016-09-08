package com.zzst.kst.service.impl;

import java.util.List;

import com.vmediax.oneplusn.ice.api.vmxICE.CmdResult;
import com.vmediax.oneplusn.ice.api.vmxICE.Conference;
import com.vmediax.oneplusn.ice.api.vmxICE.MC3Prx;
import com.vmediax.oneplusn.ice.api.vmxICE.TerminalInfo;

public class KstInsImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MCUProxy mcu = new MCUProxy();
		mcu.setMCUIp("10.1.251.175");//"10.1.6.94"
		mcu.setMCUPort(10000);//10000
        mcu.CreateMC3Prx();
        MC3Prx m=mcu.getMcuProx();
       
      
        List<Conference> str=m.getChannelsList();
      int i=1;
        for(Conference c:str){
        	int t=i++;
        	System.out.println(t+":"+c.name+"=="+c.gwIp+"=="+c.number+"=="+c.meetnumber);
          
            String ipaddr="rtsp://10.1.251.170:8000/channel_"+t+".264";
            String name="会议通道"+t;
            String type="rtsp";
            TerminalInfo h=new TerminalInfo(ipaddr,type,name);
            System.out.println(h.ipaddr);
            CmdResult cr1=m.disconnectRtspCall2Channels(h,c.number);
            CmdResult cr2= m.stopH323Call2Channels(h, c.number);
            CmdResult cr3= m.callRtspTerminal2Channels(h, c.number);
            
            System.out.println("1:"+cr1.result+" 2:"+cr2.result+" 3:"+cr3.result);
          
        
        }
       mcu.destroyICE();
        System.out.println("======================");
  

        

	}
	public static void getMc2Prx() {
		MCUProxy mcu = new MCUProxy();
		mcu.setMCUIp("10.1.251.173");//"192.168.100.151"
		mcu.setMCUPort(10000);//10000
        mcu.CreateMC2Prx();
        
        MC3Prx m=mcu.getMcuProx();
     
     
       
		
	}

}
