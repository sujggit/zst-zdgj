package com.zzst.meeting.util.test.webService;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.zzst.action.meeting.util.webService.MeetingRoomService;
import com.zzst.action.meeting.util.webService.impl.MeetingRoomServiceImpl;


public class ServerTest {
	
	public static void main(String args[]) throws Exception {
        
		MeetingRoomService implementor = new MeetingRoomServiceImpl();
        Endpoint.publish("http://localhost:8088/icmp/services",implementor);
        // Adding logging for incoming and outgoing messages
//        ep.getServer().getEndpoint().getInInterceptors().add(new LoggingInInterceptor());
//        ep.getServer().getEndpoint().getOutInterceptors().add(new LoggingOutInterceptor());
        
//		方式二：
		/*JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setAddress("http://localhost:8088/icmp/services");
		factory.setServiceClass(MeetingRoomService.class);
		factory.setServiceBean(new MeetingRoomServiceImpl());
		MeetingRoomService rs =(MeetingRoomService)factory.create();*/
//		rs.getFreeMeetingRoomList("");
//		
       /* System.out.println("Server ready...");
        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);*/
		
    }
}
