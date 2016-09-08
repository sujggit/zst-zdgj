<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    
    <title>会场轮询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
	
	<script type="text/javascript">
		 function init(){
			$("#terList").sortable();
			$("#terList1").sortable();
		}
		
		function callPoll(){
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			var intervalTime = document.getElementById("intervalTime").value;
			var terArr1 = new Array();
			var terArr2 = new Array();
			$("#terList li").each(function(i){
			terArr1.push($(this).find("input").val());
			});
			$("#terList1 li").each(function(i){
			terArr2.push($(this).find("input").val());
			});
			if(terArr1.length<=0||terArr2.length<=0){
				alert("无数据输入");
				return;
			}
			var count = 3;
			McuDwrMethod.oneAndTwoPoll(meetingDetailID,count,terArr1,terArr2,intervalTime,callback);
		}
		
		function callback(){
		
		}
		
		function delTerminal(id){
			$("#"+id).remove();
		}

		function getSelectConf(){
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			var confList1 = document.getElementById("confList1").value;
			var confList2 = document.getElementById("confList2").value;
			window.location.href='${sys_ctx }/mcuControl/getSelectConfList.action?meetingDetailID=' + meetingDetailID+'&confList1='+confList1+'&confList2='+confList2;
		}

		function serachRoom(){
			var searchRoom = document.getElementById("searchMeeingRoom1").value;//搜索条件
			var terlist1 = $("#terList li");
			var terlist2 = $("#terList1 li");

			for( var i=0; i<terlist1.length; i++){
				terlist1[i].style.display = "none";
			}

			for( var i=0; i<terlist2.length; i++){
				terlist2[i].style.display = "none";
			}

			
			for( var i=0; i<terlist1.length; i++){
				if( terlist1[i].innerText.indexOf(searchRoom)!= -1 ){//匹配到节点
					terlist1[i].style.display = "block";
				}
			}

			for( var i=0; i<terlist2.length; i++){
				if( terlist2[i].innerText.indexOf(searchRoom)!= -1 ){//匹配到节点
					terlist2[i].style.display = "block";
				}
			}
			
	 	}

		function EnterPress(e){ //传入 event 
	    	   var e = e || window.event; 
	    	   if(e.keyCode == 13){ 
	    		   serachRoom();
	    	   } 
	       } 

		function reStore(){
			var searchRoom = document.getElementById("searchMeeingRoom1").value;//搜索条件
			if( searchRoom == ""){
				var terlist1 = $("#terList li");
				var terlist2 = $("#terList1 li");

				for( var i=0; i<terlist1.length; i++){
					terlist1[i].style.display = "block";
				}

				for( var i=0; i<terlist2.length; i++){
					terlist2[i].style.display = "block";
				}
			}
		}
	</script>
	
	<style>
		.bSelectNode{
			padding-top: 0px;
			background-color: #FFE6B0;
			color: black;
			border: 1px #FFB951 solid;
			opacity: 0.8;
		}	
		
		.glass {
			border: 2px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
  </head>
  
  <body onload="init()" style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  <div class="min-widthdiv">
	<div id="basicform" class="contentwrapper" style="padding: 3px 3px;">
	 <div class="contenttitle2">
			<h5 class="fwb fl10">
				间隔时间：<select id="intervalTime">
   				<option value="10">10</option>
   				<option value="30">30</option>
   				<option value="60">60</option>
   				<option value="120">120</option>
   				<option value="300">300</option>
   				<option value="600">600</option>
   			</select>秒
			</h5>
			
			&nbsp;&nbsp;&nbsp;&nbsp;搜索 :<input id="searchMeeingRoom1"  type="text" class="glass" value="" onkeypress="EnterPress(event)"  onkeyup="reStore();" title="按回车搜索"/><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom();" style="cursor:pointer;">
	 </div>
  	<input type="hidden" value="${meetingDetailID }" id="meetingDetailID"/>
  	<input type="hidden" value="${confList1}" id="confList1"/>
  	<input type="hidden" value="${confList2}" id="confList2"/>
   <div id="screenContainer" style="width:100%;height:600px;">
   
   <div id="screen1" style="width:100%;height:300px;border:1px solid black;overflow:auto;">
   <ul id="terList">
   	<c:forEach items="${tList1}" var="ter1" varStatus="k">
   	<li id="ter1${k.count }" style="cursor:pointer" >
   	${ter1.mcu_participant_name }
   	<input type="hidden" value="${ter1.mcu_participant_id }_${ter1.mcuMeetingID}_${ter1.confFlagId}_${ter1.mcuIp}_${ter1.mcu_participant_name}"/>
   	<input type="button"  class="stdbtn" value="删除" onclick="delTerminal('ter1${k.count}')"/>
   	</li>
   	</c:forEach>
   	</ul>
   </div>
   <div id="screen2" style="width:100%;height:300px;border:1px solid black;border-top:0px;overflow:auto;">
   <ul id="terList1">
   		<c:forEach items="${tList2}" var="ter2" varStatus="s">
   		<li id="ter2${s.count }" style="cursor:pointer">
   		${ter2.mcu_participant_name }
   		<input type="hidden" value="${ter2.mcu_participant_id }_${ter2.mcuMeetingID}_${ter2.confFlagId}_${ter2.mcuIp}_${ter2.mcu_participant_name}"/>
   		<input type="button" class="stdbtn"  value="删除" onclick="delTerminal('ter2${s.count}')"/>
   		</li>
   		</c:forEach>
   	</ul>
   </div>
   </div>
   <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td><input type="button" class="submit1 radius2" value="确定" onclick="callPoll()"/>
                <input type="button" class="submit1 radius2" value="上一步" onclick="getSelectConf()"/>
               </td>
              </tr>
            </tbody>
  </table>
</div>
</div>
  </body>
</html>
