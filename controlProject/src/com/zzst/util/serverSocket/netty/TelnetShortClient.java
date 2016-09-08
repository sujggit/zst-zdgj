package com.zzst.util.serverSocket.netty;

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

	import io.netty.bootstrap.Bootstrap;
	import io.netty.channel.Channel;
	import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
	import io.netty.channel.EventLoopGroup;
	import io.netty.channel.nio.NioEventLoopGroup;
	import io.netty.channel.socket.nio.NioSocketChannel;
	import io.netty.handler.ssl.SslContext;


import org.apache.log4j.Logger;


	/**
	 * Simplistic telnet client.
	 */
	public final class TelnetShortClient {
		private static Logger logger = Logger.getLogger(TelnetShortClient.class
				.getName());
	    static final String HOST = System.getProperty("host", "10.1.6.11");
	    static final int PORT = Integer.parseInt(System.getProperty("port", "23"));

	    public static void execute (String comment){
	    	EventLoopGroup group = new NioEventLoopGroup();
	    	try{
	    		// Configure SSL.
	    		final SslContext sslCtx  =null;
	    		
    			Bootstrap b = new Bootstrap();
    			b.group(group)
    			.channel(NioSocketChannel.class)
    			.option(ChannelOption.TCP_NODELAY,true)
    			.option(ChannelOption.CONNECT_TIMEOUT_MILLIS,2000)
    			.handler(new TelnetShortClientInitializer(sslCtx));
    			
    			// Start the connection attempt.
    			Channel ch = b.connect(HOST, PORT).sync().channel();
    			ChannelFuture lastWriteFuture = ch.writeAndFlush(comment + "\r\n");
    			lastWriteFuture.channel().closeFuture().sync();
	    	}catch(Exception e){
	    		logger.error(e.getMessage());
	    	} finally {
    			group.shutdownGracefully();
    		}
	    }
	}
