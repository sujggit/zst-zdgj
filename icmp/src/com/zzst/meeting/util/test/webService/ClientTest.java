package com.zzst.meeting.util.test.webService;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
			Client client = factory.createClient("http://localhost:8088/icmp/services?wsdl");
			Object[] obj = client.invoke("", "KEVIN");
			System.out.println(obj[0]);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
