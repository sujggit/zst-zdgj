<%@include file="/common/common.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<title>模式管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>

		<script type="text/javascript">  
		function init() {
			//alert("ooo");
		    $("#terminalList").sortable();
		  }
		
		function commit(op){
		
			  var obj = $("#terminalList li > .input1");
			  var array = new Array();
			  for(var i=0;i<obj.length;i++){
			  	array[i]=obj[i].value;
			 
			  }
			  
			  var obj2 = $("#terminalList li > .input2");
			  var str="";
			
			  for(var j=0;j<obj2.length;j++){
			  if(str==""){
			  	str=obj2[j].value;
			  	}else{
			  	str += "-"+obj2[j].value;
			  }
			  }
			  var meetingDetailID = document.getElementById("meetingDetailId").value;
			  var time = document.getElementById("pollTime").value;
			  var videoMode = document.getElementById("videoMode").value;
			  var lectureName = document.getElementById("lectureName").value;
			  if(time==""||time==null||time=="undefine"){
			  	alert("请输入轮询间隔时间！");
			  	return;
			  }
			
			McuDwrMethod.startPoll(meetingDetailID, array,str, time,videoMode,lectureName,callback);
			if(op=="close"){
				window.setTimeout('closeWin()',500);
			}
			
		}
		function callback(message){
			if(message=="none"){
				alert("请先设置广播者");
			}
		}
		function closeWin(){
			window.close();
		}
		function deleteTerminal( id ){
			$("#terminal"+id).remove();
		}
	</script>
	
	</head>
		
	<body onload="init()">
	<input type="hidden" value="${videoMode }" id="videoMode"/>
	<input type="hidden" value="${lectureName }" id="lectureName"/>
	<input type="hidden" value="${meetingDetailId}" id="meetingDetailId"/>
	<div id="basicform" class="contentwrapper">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
		<tr>
			<td width="100" class="tableaddtitle">轮询间隔</td>
            <td class="tableadd_data"><input type="text" id="pollTime"/>秒</td>
		</tr>
        <tr>
			<td width="100" class="tableaddtitle">轮询顺序</td>
            <td class="tableadd_data">
            	<ol id="terminalList">
				<c:forEach items="${meetingRoomVector}" var="list" varStatus="i" step="1" begin="0" >
				<li id="terminal${i.count}" class="terminal${i.count}">${list.mcu_participant_name}  
				<input class="input1" type="hidden" value="${list.mcu_participant_id }_${list.mcuMeetingID}_${list.confFlagId}_${list.mcuIp}_${list.mcu_participant_name }" />&nbsp;&nbsp;
				<input class="input2" type="hidden" value="${list.mcu_participant_ip }_${list.mcuIp }"/>
				<input type="button" value="删除" onclick="deleteTerminal(${i.count});"/> 
				</li> 
				</c:forEach>
				</ol>
            </td>
		</tr>
	</table>
	</div>
	<div class="k_bottom">
	<input type="reset" class="submit1 radius2" value="确 定" onclick="commit('close')"/></button>
	<input type="reset" class="reset1 radius2" value="应 用" onclick="commit('open')"/></button>
	<input type="reset" class="reset1 radius2" value="取 消" onclick="cancel()"/></button>
</div>	

	</body>

</html>
