<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>右键菜单</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
     function menu(){
		document.getElementById("m5").style.backgroundColor="#fff";
		checked();	
	  }
	  
	 function checkbox(){
	 var checks=document.getElementsByName('rightCheckBok');
	 for(var i=0;i<checks.length;i++){
	 checks[i].checked=true;
	 }	 
	 } 
	 
	 function checked(){
	 var tempstrs="${checkList}";
	 var checks=tempstrs.split(',');
	 for(var i=0;i<checks.length;i++){
	 if(checks[i]!=""){
	 id='chk_'+checks[i];
	 try{
	 document.getElementById(id).checked=true;
	 }catch(e){
	 }
	 }
	 }	 
	 }
	 
	 function saveMenu(){
	 var tempstr="";
	 var checks=document.getElementsByName('rightCheckBok');
	 for(var i=0;i<checks.length;i++){
	 if(checks[i].checked){
	 tempstr+=checks[i].value+',';
	 }
	 }
	 DwrMethod.saveControlRightMenuConfig(tempstr,function(para){
			if(para){
				document.getElementById("promptSpan").innerHTML = "右键菜单配置成功！";
			}else{
				document.getElementById("promptSpan").innerHTML = "右键菜单配置失败！";
			}
	 });
	 }
  </script>
  <style>
  .controlMenuUL li{float: left;margin: 10px; width: 120px; text-align: left;}
  </style>
  </head>
  <body onload="menu()">
  	<div id="contentwrapper" class="contentwrapper">
  		<%@include file="./pageLabel.jsp"%>
  		<input type="hidden" id="editRowNum"/>
  		<input type="hidden" id="sumRowNum"/>
  		<div id="basicform">
			<div class="contenttitle2">
	          <h5 class="fwb fl10">右键菜单编辑</h5>
	          <h5 class="fwb fr10"><a onclick="checkbox();">全选</a></h5>
	        </div>
	        <div>
	        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="stdtable" style="table-layout: auto">
	    	  <thead>
	    		<tr>
	    			<th class="head1" width="50px">右键菜单控制 </th>
	    			    			
	    		</tr>
	    	  </thead>
	    	  <tr>
	    	  <td class="alc">
	   <ul id="controlMenuUL" class="controlMenuUL">
	  <li id="call"><input id="chk_call" value="call" type="checkbox" name="rightCheckBok"/>连接</li>
      <li id="handUP" ><input id="chk_handUP" value="handUP" type="checkbox" name="rightCheckBok" />挂断</li>
      <li id="mute"><input id="chk_mute" value="mute" type="checkbox" name="rightCheckBok" />静音</li>
      <li id="unMute"><input id="chk_unMute" value="unMute" type="checkbox" name="rightCheckBok" />取消静音</li>
      <li id="blockParticipants"><input id="chk_blockParticipants" value="blockParticipants" type="checkbox" name="rightCheckBok" />闭音</li>
      <li id="unBlockParticipants"><input id="chk_unBlockParticipants" value="unBlockParticipants" type="checkbox" name="rightCheckBok" />取消闭音</li>      
      <li id="suspendParticipants"><input id="chk_suspendParticipants" value="suspendParticipants" type="checkbox" name="rightCheckBok" />视频屏蔽</li>
      <li id="unSuspendParticipants"><input id="chk_unSuspendParticipants" value="unSuspendParticipants" type="checkbox" name="rightCheckBok" />取消视频屏蔽</li>
      <li id="contentToken"><input id="chk_contentToken" value="contentToken" type="checkbox" name="rightCheckBok" />双流发送</li>
      <li id="unContentToken"><input id="chk_unContentToken" value="unContentToken" type="checkbox" name="rightCheckBok" />取消双流发送</li>
      <li id="broadcast"><input id="chk_broadcast" value="broadcast" type="checkbox" name="rightCheckBok" />广播</li>
      <li id="rollCall"><input id="chk_rollCall" value="rollCall" type="checkbox" name="rightCheckBok" />点名</li>
      <li id="president"><input id="chk_president" value="president" type="checkbox" name="rightCheckBok" />设为演讲者</li>
      <li id="cancelPresident"><input id="chk_cancelPresident" value="cancelPresident" type="checkbox" name="rightCheckBok" />取消演讲者</li>
      <li id="speaker"><input id="chk_speaker" value="speaker" type="checkbox" name="rightCheckBok" />设为发言人</li>
      <li id="packetLoss"><input id="chk_packetLoss" value="packetLoss" type="checkbox" name="rightCheckBok" />丢包率</li>
      <li id='seeNearImg'><input id='chk_seeNearImg' value="seeNearImg" type="checkbox" name="rightCheckBok" />查看近端图像</li>
      <li id='seeFarawayImg'><input id='chk_seeFarawayImg' value="seeFarawayImg" type="checkbox" name="rightCheckBok" />查看远端图像</li>
      <li id='roomAttr'><input id='chk_roomAttr' value="roomAttr" type="checkbox" name="rightCheckBok" />会场属性</li>
      <li id="addComment"><input id="chk_addComment" value="addComment" type="checkbox" name="rightCheckBok" />备注</li>
      <li id="delMeetrRoom"><input id="chk_delMeetrRoom" value="delMeetrRoom" type="checkbox" name="rightCheckBok" />删除会场</li>
      <li id="meetingRoomFP"><input id="chk_meetingRoomFP" value="meetingRoomFP" type="checkbox" name="rightCheckBok" />会场分屏</li>
      <li id="watchMeetingroom"><input id="chk_watchMeetingroom" value="watchMeetingroom" type="checkbox" name="rightCheckBok" />选看会场</li>
      <li id="roomMaintain"><input id="chk_roomMaintain" value="roomMaintain" type="checkbox" name="rightCheckBok" />会场记录</li>
      <li id="zdBakUP"><input id="chk_zdBakUP" value="zdBakUP" type="checkbox" name="rightCheckBok" />终端备份</li>
	        </ul>
	        </td></tr>
	        </table>
	        <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
	        <tbody>
	          <tr>
	            <td>
	              <span class="promptSpan" style="margin: 8px 10px" id="promptSpan"></span>
	              <input type="button" class="submit1 radius2" value="确 定" onclick="saveMenu();"/>
	            </td>
	          </tr>
	        </tbody>
          </table>
	        
	        
	        </div>
	        
	    </div>
	   </div>

  </body>
</html>
