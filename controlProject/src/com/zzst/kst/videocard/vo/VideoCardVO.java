package com.zzst.kst.videocard.vo;

public class VideoCardVO {
	private String id;
	private String name;
	private String ip;
    private int udpPort;
    private int tcpPort;
    private int revSoTimeout;//接收命令超时时间
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getUdpPort() {
		return udpPort;
	}
	public void setUdpPort(int udpPort) {
		this.udpPort = udpPort;
	}
	public int getTcpPort() {
		return tcpPort;
	}
	public void setTcpPort(int tcpPort) {
		this.tcpPort = tcpPort;
	}
	public int getRevSoTimeout() {
		return revSoTimeout;
	}
	public void setRevSoTimeout(int revSoTimeout) {
		this.revSoTimeout = revSoTimeout;
	}
    
}
