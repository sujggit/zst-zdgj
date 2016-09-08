<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>sendPacketLoss</title>
    
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>		


  </head>
		
  <script type="text/javascript">
  	/**
	* interval call method
	*/
	function getMeetingRoomList(){
	
			McuDwrMethod.getPtsChannel('${meetingDetailID}','${roomID}', roomStatusCallBack);
	}
	
		/**
	*call back room status 
	*/
	function roomStatusCallBack(lst){
			
		if(lst == null || lst.length <= 0){
			return;
		}
		for(var i=0; i < lst.length; i++){
		
			if(lst[i] != null){
					opRoomStatus(lst[i]);
				}
			}
		}
	
		function opRoomStatus(PtsChannelVO){
		
		if(PtsChannelVO != null){
		
			//	do casDialDirection
			if(PtsChannelVO.bitRate == "-1"){
				document.getElementById("bitRate_" + PtsChannelVO.channelType).innerHTML = "";	
			}else{
				document.getElementById("bitRate_" + PtsChannelVO.channelType).innerHTML = PtsChannelVO.bitRate/1000.0;
			}
			
			if(PtsChannelVO.packetLoss == null){
				document.getElementById("packetLoss_" + PtsChannelVO.channelType).innerHTML = "";	
			}else{
				document.getElementById("packetLoss_" + PtsChannelVO.channelType).innerHTML = PtsChannelVO.packetLoss;
			}
			
			if(PtsChannelVO.fractionLoss == null || PtsChannelVO.fractionLossPeak == null){
				document.getElementById("fractionLoss_" + PtsChannelVO.channelType).innerHTML = "";	
			}else{
				document.getElementById("fractionLoss_" + PtsChannelVO.channelType).innerHTML = PtsChannelVO.fractionLoss/100.0+'%('+PtsChannelVO.fractionLossPeak/100.0+'%)';
			}
			
			if(PtsChannelVO.jitter == null || PtsChannelVO.jitterPeak == null){
				document.getElementById("jitter_" + PtsChannelVO.channelType).innerHTML = "";	
			}else{
				document.getElementById("jitter_" + PtsChannelVO.channelType).innerHTML = PtsChannelVO.jitter+'('+PtsChannelVO.jitterPeak+')';
			}
			
			if(PtsChannelVO.numberOfPackets == null){
				document.getElementById("numberOfPackets_" + PtsChannelVO.channelType).innerHTML = "";	
			}else{
				document.getElementById("numberOfPackets_" + PtsChannelVO.channelType).innerHTML = PtsChannelVO.numberOfPackets;
			}
			
			if(PtsChannelVO.latency == null){
				document.getElementById("latency_" + PtsChannelVO.channelType).innerHTML = "";	
			}else{
				document.getElementById("latency_" + PtsChannelVO.channelType).innerHTML = PtsChannelVO.latency;
			}
		}
	}
	
	
	function geturlcs(){
var str=window.location.href;
var es=/roomID=/;
es.exec(str);
var right=RegExp.rightContext;
right=right.split("__")[0]+' 丢包率';
document.getElementById("fwbid110").innerHTML=right;
}
  </script>
  <body onload="geturlcs();">
  <div class="contenttitle2">
		<h5 class="fwb fl10" id="fwbid110">丢包率</h5>
	</div>
    <table width="100%" id="query_table_nosearch"  cellspacing="1" cellpadding="0" align="center" class="stdtable">
      <thead>	
        <tr>
          <th class="head1">信道</th>
          <th class="head1">故障</th>
          <th class="head1">比特率</th>
          <th class="head1">包丢失</th>
          <th class="head1">片断丢失(峰值)</th>
          <th class="head1">抖动(峰值)</th>
          <th class="head1">包数量</th>
          <th class="head1">延时</th>
        </tr>
       </thead>
      <tbody id="tbodyId">
        <c:forEach items="${ptsChannelVOList}" var="PtsChannel" varStatus="status">
        <tr  >
        <td>

		<c:if test="${PtsChannel.channelType == 'h225'}">
    			H.225	
    	</c:if>
    	<c:if test="${PtsChannel.channelType == 'h245'}">
    			H.245 	
    	</c:if>
        <c:if test="${PtsChannel.channelType == 'audio_in'}">
    			音频输入	
    	</c:if> 
    	<c:if test="${PtsChannel.channelType == 'audio_out'}">
    			音频输出	
    	</c:if>
    	<c:if test="${PtsChannel.channelType == 'video_in'}">
    			视频输入	
    	</c:if> 
    	<c:if test="${PtsChannel.channelType == 'video_out'}">
    			视频输出	
    	</c:if> 
    	<c:if test="${PtsChannel.channelType == 'video_content_in'}">
    			内容输入	
    	</c:if> 
    	<c:if test="${PtsChannel.channelType == 'video_content_out'}">
    			内容输出	
    	</c:if> 
    	<c:if test="${PtsChannel.channelType == 'fecc_in'}">
    			FECC输入	
    	</c:if>  
    	<c:if test="${PtsChannel.channelType == 'fecc_out'}">
    			FECC输出	
    	</c:if>   	
    	<c:if test="${PtsChannel.channelType == 'bfcp'}">
    			SIP BFCPT
    	</c:if>   	
        </td>
        <td>
        111
        </td>
        <td>
        <c:if test="${PtsChannel.bitRate == '-1'}">
        <span id="bitRate_${PtsChannel.channelType}"></span>
    	</c:if>
    	<c:if test="${PtsChannel.bitRate != '-1' }">
           <span id="bitRate_${PtsChannel.channelType}"><fmt:formatNumber value="${PtsChannel.bitRate/1000.0}" pattern="########.#" minFractionDigits="1" ></fmt:formatNumber>
         </span>
         </c:if>
        </td>
        <td>
          <span id="packetLoss_${PtsChannel.channelType}"> <c:out value="${PtsChannel.packetLoss}" /> </span>	
        </td>
        <td>
        
        <c:if test="${PtsChannel.fractionLoss == null || PtsChannel.fractionLossPeak ==null}">
    		<span id="fractionLoss_${PtsChannel.channelType}"></span>		
    	</c:if>
    	<c:if test="${PtsChannel.fractionLoss !=null && PtsChannel.fractionLossPeak !=null}">
           <span id="fractionLoss_${PtsChannel.channelType}"><c:out value='${PtsChannel.fractionLoss/100.0}%(${PtsChannel.fractionLossPeak/100.0 }%)' /></span> 
         </c:if>  	
        </td>
        <td>
        <c:if test="${PtsChannel.jitter == null || PtsChannel.jitterPeak ==null}">
        <span id="jitter_${PtsChannel.channelType}"></span>
    	</c:if>
    	<c:if test="${PtsChannel.jitter !=null && PtsChannel.jitterPeak !=null}">
        <span id="jitter_${PtsChannel.channelType}"><c:out value='${PtsChannel.jitter}(${PtsChannel.jitterPeak })' /> </span>
         </c:if> 
        </td>
        <td>
           <span id="numberOfPackets_${PtsChannel.channelType}"><c:out value="${PtsChannel.numberOfPackets}" /></span>
        </td>
        <td>
          <span id="latency_${PtsChannel.channelType}"><c:out value="${PtsChannel.latency}" /> 	</span>
        </td>
        </tr>
        </c:forEach>
    	</tbody> 
     </table>
  </body>
	<script type="text/javascript">
  		var intervalFunc = window.setInterval("getMeetingRoomList()", 3000);
  		
  	</script>
</html>
