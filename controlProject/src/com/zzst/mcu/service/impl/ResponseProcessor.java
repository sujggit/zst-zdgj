package com.zzst.mcu.service.impl;


/**
 *@Description
 *@date 2011-3-15下午03:19:54
 *@author ryan
 */
import java.io.BufferedReader;   
import java.io.IOException;   
import java.io.InputStreamReader;   
import java.io.PrintWriter;   
import java.net.Socket;
import java.net.SocketException;   
  
/**  
 * 服务端响应处理器  
 *   
 * @author Johnson Lee  
 *   
 */  
public class ResponseProcessor implements Runnable {   
    Socket svrSocket ;
    public ResponseProcessor(Socket svrSocket) {   
        super();   
        this.svrSocket = svrSocket;   
    }
  
    @Override  
    public void run() {   
    	
        BufferedReader br = null;   
        PrintWriter pw = null;   
        String line = null;   
        try {   
        	
            br = new BufferedReader(new InputStreamReader(svrSocket   
                    .getInputStream()));   
            pw = new PrintWriter(System.out, true);   
            while (this.svrSocket == null || this.svrSocket.isClosed()) { 
                line = br.readLine();   
                pw.println(line);   
                System.out.println("======"+line);
            }
        } catch (SocketException e) {   
            if (this.svrSocket == null || this.svrSocket.isClosed()) {   
                System.err.println(e);   
            }
        } catch (IOException e) {   
            e.printStackTrace();
        }   
    }   
  
}  

