package com.zzst.action.meeting.util.notice;



public class SendMessage {
	private String messageAddress;
	private Message message;
	private Send send;
	private Object[] obj;
	public SendMessage(Object[] obj,Send send,Message message,String messageAddress){
		this.send = send;
		this.message = message;
		this.messageAddress = messageAddress;
		this.obj = obj;
	}
	
	
	
	public void send(){
		if(this.messageAddress==null){
			return;
		}else{
			this.send.send(obj,message,messageAddress);
		}
		
	}
	
	public void setMessage(Message message){
		this.message = message;
	}
	
}
