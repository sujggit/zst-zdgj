/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.zzst.util.serverSocket.netty;


import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a client-side channel.
 */
@Sharable
public class TelnetShortClientHandler extends SimpleChannelInboundHandler<String> {
	
	@Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		if(msg==null||msg.length()==0||msg.indexOf(">>")>=0||msg.indexOf("<<")>=0) return;
		
		if(msg.toString().equalsIgnoreCase("Telnet Server Started"))	return;
        
		if(msg.toString().toLowerCase().equals("<connect>success!</connect>")){
        	return;
        }
		
        if(msg.indexOf("<channelcount>")==0 && msg.indexOf("</channelcount>")>0){//支持多少间会议室
        	System.out.println("client接收到服务器返回的消息:"+msg);
        	ReferenceCountUtil.release(msg);
        	ctx.close();
        }else if(msg.indexOf("<channelcount>")==0 && msg.indexOf("</channelcount>")>0){
        	
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
