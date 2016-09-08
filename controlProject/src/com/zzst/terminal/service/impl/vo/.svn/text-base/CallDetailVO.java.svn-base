package com.zzst.terminal.service.impl.vo;

import java.util.HashMap;
import java.util.Map;


/**
 *@Description
 *@date 2011-5-25上午11:28:26
 *@author ryan
 */
public class CallDetailVO {
	public static final String callID = "call";//当前通话ID
	public static final String txrate = "txrate";//输出速率
	public static final String rxrate = "rxrate";//输入速率
	public static final String pktloss = "pktloss";//总数据包丢失
	public static final String pktlossPercent = "%pktloss";//总数据包丢失百分比
	public static final String tvp = "tvp";//输出视频协议
	public static final String rvp = "rvp";//输入视频协议
	public static final String tvf = "tvf";//输出视频格式
	public static final String rvf = "rvf";//输入视频格式
	public static final String tap = "tap";//输出音频协议
	public static final String rap = "rap";//输入音频协议
	public static final String tcp = "tcp";//呼叫类型
	public static final String rcp = "rcp";//呼叫类型
    
	public static final String tar = "tar";//输出音频速率
	public static final String rar = "rar";//输入音频速率
	public static final String tvr = "tvr";//输出视频速率
	public static final String rvr = "rvr";//输入视频速率
	public static final String tvru = "tvru";//输出使用中的视频速率
	public static final String rvru = "rvru";//输入使用中的视频速率
	public static final String tvfr = "tvfr";//输出视频帧速率
	public static final String rvfr = "rvfr";//输入视频帧速率
	public static final String vfe = "vfe";//输出视频数据包丢失
	public static final String tapl = "tapl";//输入视频数据包丢失
	public static final String taj = "taj";//输出音频抖动
	public static final String raj = "raj";//输入音频抖动
	public static final String tvpl = "tvpl";//输出音频数据包丢失
	public static final String rvpl = "rvpl";//输入音频数据包丢失
	public static final String tvj = "tvj";//输出视频抖动
	public static final String rvj = "rvj";//输入视频抖动
	public static final String dc = "dc";//呼叫加密
	public static final String rsid = "rsid";//远端名称
	public static final String ccaps = "ccaps";
	public static final String cp = "cp";//内容协议。固定为H.264;目前没有解决办法
	
	/**
	 * 存储通话中信息的状态 
	 */
	private Map<String,String> callDetail = new HashMap<String,String>();
	
	
	/**
	 * key 为：CallDetailVO内的常量；
	 * 内容协议：固定为H.264,目前没有解决办法
	 * @return Map<String, String>
	 */
	public Map<String, String> getCallDetail() {
		callDetail.put(cp, "H.264");
		return callDetail;
	}
	public void setCallDetail(Map<String, String> callDetail) {
		this.callDetail = callDetail;
	}
	
	
	
	 
	
	
}
