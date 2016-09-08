﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zzst.application.mcuVO.ZZOMainStatusVO"%>

<%@ page import="com.zzst.application.mcuVO.ZZOConfVO"%>
<%@ page import="com.zzst.model.meeting.meetingDetail.MeetingDetailVO"%>
<%@ page import="com.zzst.application.mcuUtil.ConfAllPts"%>
<%@ page import="com.zzst.application.mcuVO.ZZOMainVO"%>
<%@ page import="com.zzst.application.mcuUtil.ConfManager"%>
<%@ page import="com.zzst.application.meeting.mcuFactory.ZZOMcuFactory"%>
<%@ page import="com.zzst.meeting.dwr.McuDwrMethod"%>
<%@ page import="com.zzst.model.meeting.dictionary.DictionaryVO"%>
<%@ page import="com.zzst.model.enums.DictionaryEnum"%>
<%@ page import="com.zzst.action.meeting.util.ServiceFactory"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/common/common.jsp"%>
		<title>会议控制</title>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="${sys_ctx }/style/blue/compatibleBefor.css" />
		<link rel="stylesheet" type="text/css" href="${sys_ctx }/meeting/meetingManage/repop/style.default.css" />

		<link rel="stylesheet" type="text/css" href="${sys_ctx }/plug-in/jquery-easyui-1.3/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="${sys_ctx }/plug-in/jquery-easyui-1.3/themes/icon.css" />
		<link rel="stylesheet" type="text/css" href="${sys_ctx }/plug-in/jquery-ui/css/jquery-ui.css" />
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/meeting/meetingManage/meetingRoomJs.js'> </script>
		<script type='text/javascript' src="${sys_ctx }/plug-in/jquery.contextmenu.r2.js"></script>
<%--		<script type='text/javascript' src='${sys_ctx }/dwr/interface/ControlDWR.js'></script>--%>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/mcuControlMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
		<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/table-order/jquery.tablesorter.js"></script>

		<%
			String customerIp = request.getRemoteAddr();
			pageContext.setAttribute("customerIp", customerIp);
		%>
		<script type="text/javascript">
	/*modify wangle in 2013-5-27. don't use this technology.
	$(function(){  
	    //这句话千万不能少 ，表示允许使用推送技术  
	   		dwr.engine.setActiveReverseAjax(true);  
	    });  
	   */
	//set global meetingDetail Id and project name.
		$(document).ready(function(){
		setGlobalMeetingDetailId('${chooseMeetingNumber}');
		setGlobalProjectName('${sys_ctx }');
		initONcontextmenuAction();
		});
		var mainStatusVOArray = new Array();
		
		function getMeetingRoomList(room){
			//var rooms = document.getElementsByName(room);
			//var meetingDetailID = '${chooseMeetingNumber}';
			room_Name = new Array();
			t_IP = new Array();
			mcu_IP = new Array();

			var td_roomNames = $(".td_Mcu_participant_name");
			var td_roomIp = $(".td_Mcu_participant_ip");
			var td_Mcu = $(".td_Mcu");
			for( var i=0; i<td_roomNames.length; i++ ){
				var td_id = td_roomNames[i].id;
				var val_roomName = td_roomNames[i].innerHTML+"_"+td_id.split("_")[1];
				room_Name.push(val_roomName);//会场名数组
			}
			for( var i=0; i<td_roomIp.length; i++ ){
				var td_id = td_roomIp[i].id;
				t_IP.push(td_id);//会场ip数组
			}
			for( var i=0; i<td_Mcu.length; i++ ){
				var td_MCU = td_Mcu[i].id;
				mcu_IP.push(td_MCU);//所属mcu数组
			}

			//获取mcuIps
			McuDwrMethod.getMeetingConfs(meetingDetailID,function backIps(strs){
				if(strs.length == 0){
				   return;
				}
			    mcuIps= new Array();
				mcuIps = strs;
			});

			if(globalMeetingDetailId != null && globalMeetingDetailId != ""){
				mainStatusVOArray = new Array();
				var rooms = document.getElementsByName('room');
				var val;
				/*
				for(var i=0; i < rooms.length; i++){
					mainStatusVOArray[i] = new Array();
					val = document.getElementById("mcuptsname__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("mcuMeetingID__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("mcuip__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("connectstatus__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 	
					val = document.getElementById("audio__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("video__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("contenttoken__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("dialdirection__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("lecturer__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("speaker__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val); 
					val = document.getElementById("receivepacketloss__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val);
					val = document.getElementById("sendpacketloss__" + rooms[i].value).value;
					mainStatusVOArray[i].push(val);
				}
				*/
				//alert(globalMeetingDetailId + mainStatusVOArray);
				McuDwrMethod.getNewMeetingMcuList('${customerIp}', globalMeetingDetailId, mainStatusVOArray, {    
		            callback:roomStatusCallBack,   
		       		errorHandler:errorHandler,   
		        	exceptionHandler:exceptionHandler   
		        	});
				McuDwrMethod.getMeetingControlStatus(globalMeetingDetailId,meetingControlStatusCallBack);
				getMasterConf(globalMeetingDetailId);

				McuDwrMethod.getTerminalComment(globalMeetingDetailId,terminalCommentCallBack);
			}
		}
		function errorHandler(errorString, exception){   
			 $("#errorMessageId").text("Error Message:" + exception.message);
			// refreshSelf('2');  
		}   
		function exceptionHandler(exceptionString, exception){   
			 //alert(exception.message);
			 $("#errorMessageId").text("Error Message:" + exception.message);
			// refreshSelf('2');   
		}  

		function initMeetingRoomList(room){
			//var rooms = document.getElementsByName(room);
			//var meetingDetailID = '${chooseMeetingNumber}';
			room_Name = new Array();
			t_IP = new Array();
			mcu_IP = new Array();

			var td_roomNames = $(".td_Mcu_participant_name");
			var td_roomIp = $(".td_Mcu_participant_ip");
			var td_Mcu = $(".td_Mcu");
			for( var i=0; i<td_roomNames.length; i++ ){
				var td_id = td_roomNames[i].id;
				var val_roomName = td_roomNames[i].innerHTML+"_"+td_id.split("_")[1];
				room_Name.push(val_roomName);//会场名数组
			}
			for( var i=0; i<td_roomIp.length; i++ ){
				var td_id = td_roomIp[i].id;
				t_IP.push(td_id);//会场ip数组
			}
			for( var i=0; i<td_Mcu.length; i++ ){
				var td_MCU = td_Mcu[i].id;
				mcu_IP.push(td_MCU);//所属mcu数组
			}

			//获取mcuIps
			McuDwrMethod.getMeetingConfs(meetingDetailID,function backIps(strs){
				if(strs.length == 0){
				   return;
				}
			    mcuIps= new Array();
				mcuIps = strs;
			});
			//if(globalMeetingDetailId != null && globalMeetingDetailId != ""){//没有会议也自动刷新本页面
				mainStatusVOArray = new Array();
				var rooms = document.getElementsByName('room');
				var val;
				if(rooms != null && rooms.length>0){
					for(var i=0; i < rooms.length; i++){
						mainStatusVOArray[i] = new Array();
						val = document.getElementById("mcuptsname__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("mcuMeetingID__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("mcuip__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("connectstatus__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 	
						val = document.getElementById("audio__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("video__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("contenttoken__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("dialdirection__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("lecturer__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("speaker__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val); 
						val = document.getElementById("receivepacketloss__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val);
						val = document.getElementById("sendpacketloss__" + rooms[i].value).value;
						mainStatusVOArray[i].push(val);
					}
					//alert(globalMeetingDetailId + mainStatusVOArray);
				
					McuDwrMethod.getNewMeetingMcuList('${customerIp}', globalMeetingDetailId, mainStatusVOArray, {    
			            callback:roomStatusCallBack,   
			       		errorHandler:errorHandler,   
			        	exceptionHandler:exceptionHandler   
			        	});
					McuDwrMethod.getMeetingControlStatus(globalMeetingDetailId,meetingControlStatusCallBack);
					getMasterConf(globalMeetingDetailId);

					McuDwrMethod.getTerminalComment(globalMeetingDetailId,terminalCommentCallBack);	
					return;
				}else{
					McuDwrMethod.getNewMeetingMcuList('${customerIp}', globalMeetingDetailId, mainStatusVOArray, {    
			            callback:roomStatusCallBack,   
			       		errorHandler:errorHandler,   
			        	exceptionHandler:exceptionHandler   
			        	});
					McuDwrMethod.getMeetingControlStatus(globalMeetingDetailId,meetingControlStatusCallBack);
					return;
				}
			//}
		}
		
		
		function meetingControlStatusCallBack(status){
		if('${fn:contains(menuManager,'开始轮询')}'=='true'){
			if(status=="poll_start"){
				//$("#pollStart a").attr("style","color:red");
				//$("#pollSuspend a").attr("style","color:black");
				//$("#pollStop a").attr("style","color:black");
				document.getElementById("polla").innerHTML='<span class="czdiv_ztlx_zt"></span>';
				document.getElementById("polla").onclick=suspendPoll;
				//document.getElementById("suspolla").innerHTML='<img src="'+globalProjectName+'/meeting/meetingManage/image/report/ztlx.png" align="absmiddle" /> 暂停轮询';
				//document.getElementById("suspolla").setAttribute("onclick", "suspendPoll()");
				document.getElementById("polla").setAttribute("title", "暂停轮询");
				//$("#polla a").attr("style","color:black");
				
				
			}else if(status=="poll_suspend"){
				//$("#pollStart a").attr("style","color:black");
				//$("#pollSuspend a").attr("style","color:red");
				//$("#pollStop a").attr("style","color:black");
				document.getElementById("polla").innerHTML='<span class="czdiv_ztlx_bf"></span>';
				document.getElementById("polla").onclick=resumePoll;
				document.getElementById("polla").setAttribute("title", "继续轮询");
			}else{
				//$("#pollStart a").attr("style","color:black");
				//$("#pollSuspend a").attr("style","color:black");
				//$("#pollStop a").attr("style","color:red");
				document.getElementById("polla").innerHTML='<span class="czdiv_kslx"></span>';
				document.getElementById("polla").onclick=startPolling1;
				document.getElementById("polla").setAttribute("title", "开始轮询");

			//	$("#pollSuspend a").attr("style","color:gray");
			}
			}
		}
		//初始化右键菜单
		/*
		function rightMenuInit(){
			initMeetingRoomList('${chooseMeetingNumber}');
			$("#query_table_nosearch tr").each(function(i){
				var id = $(this).attr("id");
				if(i!=0){
					addRightMenu(id);
				}
			});
			document.getElementById("meetingRoomDiv").style.height = document.documentElement.scrollHeight-145;
		}
		*/
		//获取主会conf
		function getMasterConf(meetingDetailID){
			McuDwrMethod.getMasterConf(meetingDetailID,masterConfCallback);
		}
		
		function masterConfCallback(data){
			if(data.isMasterConf!=null){
				if(data.isMasterConf==1){
				//alert(data.lectureName);
				document.getElementById("videoMode1").value = data.videoMode;
				document.getElementById("lectureName").value = data.lectureName;
				}
			}
		}
		function openyj(){
		var meetingDetailId = getMeetingDetailId();
    	if(meetingDetailId==null||meetingDetailId=="") return; 
		window.open("${sys_ctx}/meeting/meetingManage/McuDwrYujian/McuDwrYujianView.jsp?meetingID="+meetingDetailId, "window",
						'Width=700px;Height=500px;');
		}
		
		//添加级联点
		function openmcujl(){
			var meetids =getMeetingDetailId();
			var cofid=document.getElementById("confID");
//			alert(mcuIps);
//			alert("confID:"+cofid.value+",meetids:"+meetids);
			var url = encodeURI("${sys_ctx}/meeting/meetingManage/McuJL/addParticipant.jsp?meetingDetailID="+meetids+"&confId="+mcuIps)
			window.open(url, "window",
							'Width=700px;Height=500px;');
		}
		
		function openmcubk(){
		var meetingDetailId = getMeetingDetailId();
    	if(meetingDetailId==null||meetingDetailId=="")return; 
    		
    	window.open("${sys_ctx}/equipmentBackup/mcuBackupqueryByMeetingID.action?meetingID="+meetingDetailId, "window",
						'Width=700px;Height=500px;');
		
		}
		
var aDoc = [document.documentElement.offsetWidth, document.documentElement.offsetHeight];				
function initONcontextmenuAction()
{
$("#abc").tablesorter({    
				//sortList: [[1,0]]  //当首次加载页面设置排序列和排序类型
				headers:{0:{sorter:false}}
		}); 
document.getElementById("meetingRoomDiv").style.height = document.documentElement.offsetHeight-180;
initMeetingRoomList('${chooseMeetingNumber}');
 var oMenu = document.getElementById("rightMenu");
 var maxWidth = maxHeight = 0;
 var oMenAreasConventer=document.getElementById("tbodyId");

 oMenu.style.display = "none";
 
 //自定义右键菜单
oMenAreasConventer.oncontextmenu = function (event)
 {
 var keyidtem=document.getElementById('tempMeetingMcuKeyId3').value;
 if(keyidtem==null || keyidtem==""){
 	keyidtem=document.getElementById('tempMeetingMcuKeyId').value=document.getElementById('tempMeetingMcuKeyId2').value;
 }else{
 	keyidtem=document.getElementById('tempMeetingMcuKeyId').value=document.getElementById('tempMeetingMcuKeyId2').value=document.getElementById('tempMeetingMcuKeyId3').value;
 }
 //var keyidtem=document.getElementById('tempMeetingMcuKeyId').value=document.getElementById('tempMeetingMcuKeyId2').value;
 var meetingRoomNameTemp=document.getElementById('room_'+keyidtem+'_roomName').value;
 document.getElementById('rightMenuMeetingRoomName').innerHTML=meetingRoomNameTemp;
 initMenuList();
 // alert(meetingRoomNameTemp);
  var event = event || window.event;
  oMenu.style.display = "block";
  oMenu.style.top = event.clientY + "px";
  oMenu.style.left = event.clientX + "px";

  
  //最大显示范围
  maxWidth = aDoc[0] - oMenu.offsetWidth;
  maxHeight = aDoc[1] - oMenu.offsetHeight;
  
  //防止菜单溢出
  oMenu.offsetTop > maxHeight && (oMenu.style.top = maxHeight + "px");
  oMenu.offsetLeft > maxWidth && (oMenu.style.left = maxWidth + "px");
  return false;
 };
 
 
 //点击隐藏菜单
 document.onclick = function ()
 {
  oMenu.style.display = "none" 
 };
}

function onchangActionTr(tempKeyID){
document.getElementById('tempMeetingMcuKeyId3').value="";
document.getElementById('tempMeetingMcuKeyId2').value=tempKeyID;

}

function onclickOmenu(){
var oMenu = document.getElementById("rightMenu");
oMenu.style.display = "none" 
}
</script>
	</head>
	<body class="withvernav"  scroll="no"	style="overflow: hidden">
	<div class="contentwrapper" onclick="onclickOmenu()">
		<%@include file="repop/rightMenuConveter.jsp"%>
		<input type="hidden" id="tempMeetingMcuKeyId" />
		<input type="hidden" id="tempMeetingMcuKeyId2" />
		<input type="hidden" id="tempMeetingMcuKeyId3"/>
		<%--<div id="containerTest" style="width:100%; margin-top:-20px;margin-left:0;float:left;">--%>
		<div class="czdiv_top">
			<form method="post" action="" name="myform"
				onsubmit="return check(document.myform.room);">
				<input type="hidden" value="" name="confProfileVO.layoutMode"
					id="layoutMode" />
				<input type="hidden" value="" name="confProfileVO.videoMode"
					id="videoMode" />
				<input type="hidden" name="interfaceImplements"
					value="com.newzzst.application.meeting.action.infoimport.ImportEquipmentBaseData" />
				<input type="hidden" value="${confVO.confID }" id="confID" />
				<input type="hidden" value="${confVO.videoMode }" id="videoMode1" />
				<input type="hidden" value="${confVO.lectureName }" id="lectureName" />
				<input type="hidden" value="${confVO.mcuIP}" id="confMcuIp"/>
				<input type="hidden" value="${meetingDetialStatic.monitorMeetingRoomIP}" id="monitorMeetingRoomIP"/>
				<input type="hidden" value="${meetingDetialStatic.nowMonitorMeetRoom}" id="nowMonitorMeetRoom"/>
				<div id="basicform" class="contentwrapper czdiv_top">
					<table width="100%" border="0" cellspacing="1" cellpadding="0"
						class="tableadd">
						<tr>
							<td width="120" class="tableaddtitle">
								会议选择
							</td>
							<td class="tableadd_data">
								<span class="field" style="display: block; float: left">
									<select name="selection" id="filterSelectId" onchange="changeMeetingDetail(this.value);" style="font-size:12px">
										<c:forEach items="${meetingDetailList}" var="meetingDetail">
											<option value="${meetingDetail.meetingDetailID }"
												${meetingDetail.meetingDetailID==chooseMeetingNumber ? "selected" : "" }>
												${meetingDetail.meetingName }
											</option>
										</c:forEach>
										<c:if test="${empty  meetingDetailList}">
											<option value="">
												没有会议
											</option>
										</c:if>
									</select> </span>
								<span style="display: block; float: left">
									&nbsp;&nbsp;
									<c:forEach items="${meetingDetailList}" var="meeting">
										<c:if test="${meeting.meetingDetailID == chooseMeetingNumber }">
			          开始时间：<font color="red"><fmt:formatDate
													value="${meeting.meetingStartTime }"
													pattern="yyyy-MM-dd HH:mm" />
											</font>
			          &nbsp;&nbsp;
			          结束时间：<font color="red"><c:choose>
													<c:when test="${endTime == '2099-01-01 00:00:00.0' }">永久</c:when>
													<c:otherwise>
														<fmt:formatDate value="${meeting.meetingEndTime }"
															pattern="yyyy-MM-dd HH:mm" />
													</c:otherwise>
												</c:choose>
											</font>
										</c:if>
									</c:forEach> </span>
								 <span onclick="maximizition()"	style="display: block; margin-top: 5px; float: right; cursor: pinter"
									id="maxSpan" title="最大化"><img height="20px"
										style="cursor: pinter" src="${sys_ctx }/images/sf.png"
										id="maxW" />
								</span> 
							</td>
						</tr>
					</table>
				</div>
				<div id="contentwrapper" class="contentwrapper czdiv_top">
					<!--contenttitle-->
					<table width="99%" border="0" cellpadding="0" cellspacing="0"
						class="stdtable stb" id="table4">
						<tbody>
							<tr class="gradeA">
								<td style="border: none">
									<div class="czdiv">
										<%@include file="repop/meetingRoomButton.jsp"%>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<!--contenttitle-->
					<div style="width: 100%; height: 360px; overflow: auto; overflow-x: hidden" id="meetingRoomDiv">
						<table width="99%" border="0" cellpadding="0" cellspacing="0"
							id="table3" style="margin-bottom: 0px; margin-top: 0px;">
							<tbody>
								<tr>
									<td style="font-size: 14px; text-align: left">
										会场统计：当前连接终端
										<span style="color: red" id="meetingRoomCount">${meetingRoomCount
											}</span> 个 &nbsp;&nbsp;
										<span id="errorMessageId"></span>
									</td>
									<td align="right">
										<%--              <input type="text" class="glass" />--%>

										<span style="float: right; font-size: 14px">搜索：<input
												style="font: 14px" id="datepicker" type="text"
												class="searwidth100" onkeypress="if(event.keyCode==13){serachRoom(this);return false;}"
												onclick="clearInput(this)" value="请输入关键字" />
										</span>
									</td>

								</tr>
							</tbody>
						</table>
						<table cellpadding="0" cellspacing="0" border="0" class="stdtablemeet" id="abc" style="table-layout: fixed;">
							<thead>
								<tr>
									<th width="4%" class="meetinghead {sorter:false}">
										<input type="checkbox" name="checkbox2" id="checkAll"
											onclick="checkall(document.myform.room)" class="checkbox1"
											style="background: none; border: none" />
									</th>
									<th width="14%" class="meetinghead">
										会场名
									</th>
									<th width="6%" class="meetinghead">
										备注
									</th>
									<th width="14%" class="meetinghead">
										IP
									</th>
									<th width="6%" class="meetinghead">
										状态
									</th>
									<th width="7%" class="meetinghead">
										音频
									</th>
									<th width="5%" class="meetinghead">
										视频
									</th>
									<th width="8%" class="meetinghead">
										角色
									</th>
									<th width="5%" class="meetinghead">
										内容
									</th>
									<th width="9%" class="meetinghead"  style="display: none" title="当前值  峰值">
										输入(%)
									</th>
									<th width="9%" class="meetinghead"  style="display: none" title="当前值  峰值">
										输出(%)
									</th>
									<th width="6%" class="meetinghead" style="display: none">
										方向
									</th>
									<th width="12%" class="meetinghead">
										所属MCU
									</th>
									<!--  <th width="%" class="head1" style="font-size:15px">预监</th>  -->
								</tr>
							</thead>
							<tbody id="tbodyId">
								<%
									Vector confRoomVectorTemp = (Vector) request
											.getAttribute("confRoomVector");
									if (confRoomVectorTemp != null) {
										if (confRoomVectorTemp.size() > 0) {
											String meetingDetailId = (String) request
													.getAttribute("chooseMeetingNumber");

											ConfManager confManager = ZZOMcuFactory.getInstance()
													.getConfManager();
											ZZOConfVO confVO = new ZZOConfVO();
											confVO.setConfFlagId(meetingDetailId);
											List confList = confManager.getConfList(confVO);
											List mainStatusVOList = null;
											if (confList != null && confList.size() > 0) {
												ConfAllPts confAllPts = ZZOMcuFactory.getInstance()
														.getInnerConfPts();
												ZZOConfVO tempConfVO = null;
												for (int i = 0; i < confList.size(); i++) {
													tempConfVO = (ZZOConfVO) confList.get(i);
													mainStatusVOList = (List) confAllPts
															.getMeetingMcuList(tempConfVO
																	.getConfFlagId(), tempConfVO
																	.getMcuIP(), tempConfVO.getGuid());
								%>
								<%
									//Vector confRoomVector = (Vector)aConfPtsMcuMap.get(mcuVO);
													if (mainStatusVOList != null
															&& mainStatusVOList.size() > 0) {
														for (int j = 0; j < mainStatusVOList.size(); j++) {
															ZZOMainStatusVO meetingRoom = (ZZOMainStatusVO) mainStatusVOList
																	.get(j);
															if (meetingRoom == null) {
																continue;
															}
															pageContext.setAttribute("meetingRoom",
																	meetingRoom);
															pageContext.setAttribute("j", j + "");
								%>

								<tr id="room_${meetingRoom.meetingMCUKeyID}"
									onmousemove="onchangActionTr('${meetingRoom.meetingMCUKeyID}');"
									indexTr="${j }">
									<td>
										<span lang="zh-cn" xml:lang="zh-cn"> <input
												type="checkbox" name="room"
												id="room_${meetingRoom.meetingMCUKeyID}_checkbox"
												value="${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<!-- 右键菜单 --> 
											<input type="hidden" value="${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}"
												id="room_${meetingRoom.meetingMCUKeyID}_roomIds" />
											<input
												type="hidden" value="${meetingRoom.mcu_participant_ip }"
												id="room_${meetingRoom.meetingMCUKeyID}_roomIP" /> 
											<input
												type="hidden" value="${meetingRoom.mcu_participant_name }"
												id="room_${meetingRoom.meetingMCUKeyID}_roomName" /> 
											<input
												type="hidden" value="${meetingRoom.connectStatus }"
												id="room_${meetingRoom.meetingMCUKeyID}_IPConnectStatus" />
											<input type="hidden" value="${meetingRoom.video }"
												id="room_${meetingRoom.meetingMCUKeyID}_video" /> 
											<input
												type="hidden" value="${meetingRoom.contentToken }"
												id="room_${meetingRoom.meetingMCUKeyID}_contentToken" /> 
											<input
												type="hidden" value="${meetingRoom.audio }"
												id="room_${meetingRoom.meetingMCUKeyID}_audio" /> 
											<input
												type="hidden"
												value="${meetingRoom.mcu_participant_ip}_${meetingRoom.mcuIp}"
												id="room_${meetingRoom.meetingMCUKeyID}_backupInfo" /> 
											<input
												type="hidden" value="${meetingRoom.nodeType }"
												id="room_${meetingRoom.meetingMCUKeyID}_nodeType" /> <!-- 右键菜单 -->
											<input type="hidden" value="${meetingRoom.meetingMCUKeyID }"
												id="meetingRoomMID_${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												value="${meetingRoom.mcu_participant_id }"
												id="mparticipantid_${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden" value="${meetingRoom.meetingMCUKeyID }"
												id="meetingMCUKeyID" /> <input type="hidden"
												value="${meetingRoom.nodeType }"
												id="nodeType_${meetingRoom.mcu_participant_ip }" /> 
											<input
												type="hidden" value="${meetingRoom.mcuCommandIp }"
												id="commandIp_${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												id="infoIps_${meetingRoom.mcu_participant_ip }"
												value="${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												id="personalInfo_${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}"
												value="${meetingRoom.mcu_participant_id}_${meetingRoom.mcuMeetingID}_${meetingRoom.confFlagId}_${meetingRoom.mcuIp}_${meetingRoom.mcu_participant_name}" />
											<input type="hidden"
												id="backupInfo_${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}"
												value="${meetingRoom.mcu_participant_ip}_${meetingRoom.mcuIp}" />
											<input type="hidden"
												id="participantIp_${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}"
												value="${meetingRoom.mcu_participant_ip }" /> 
											<input
												type="hidden"
												id="room_${meetingRoom.meetingMCUKeyID}_participant_id"
												value="${meetingRoom.mcu_participant_id}__${meetingRoom.confFlagId}__${meetingRoom.mcuIp}__${meetingRoom.mcu_participant_name}" />

											<!-- hide end point current status    --> 
											<input
												type="hidden" value="<%=meetingRoom.getConnectStatus()%>"
												id="connectstatus__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden" value="<%=meetingRoom.getAudio()%>"
												id="audio__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden" value="<%=meetingRoom.getVideo()%>"
												id="video__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												value="<%=meetingRoom.getContentToken()%>"
												id="contenttoken__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												value="<%=meetingRoom
													.getCasDialDirection()%>"
												id="dialdirection__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden" value="<%=meetingRoom.getIsLecturer()%>"
												id="lecturer__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden" value="<%=meetingRoom.getIsSpeaker()%>"
												id="speaker__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												value="<%=meetingRoom
											.getMcu_participant_name()%>"
												id="mcuptsname__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												value="<%=meetingRoom.getMcuMeetingID()%>"
												id="mcuMeetingID__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden" value="<%=meetingRoom.getMcuIp()%>"
												id="mcuip__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												value="<%=meetingRoom
											.getReceivePacketLoss()%>"
												id="receivepacketloss__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />
											<input type="hidden"
												value="<%=meetingRoom.getSendPacketLoss()%>"
												id="sendpacketloss__${meetingRoom.mcu_participant_name}__${meetingRoom.mcuMeetingID}__${meetingRoom.mcuIp}" />

										</span>
									</td>
									<td
										style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<span style="display: none">
											<%
												if (meetingRoom
																				.getMcu_participant_visualName() != null
																				&& !""
																						.equals(meetingRoom
																								.getMcu_participant_visualName())) {
																			out
																					.print(meetingRoom
																							.getMcu_participant_visualName());
																		} else
																			out.print(meetingRoom
																					.getMcu_participant_name());
											%>
										</span>
										<a style="cursor: pointer"
											onmouseover="displayComments('<%=meetingRoom
											.getMcu_participant_ip()%>','font_<%=meetingRoom.getMeetingMCUKeyID()%>');">
											<font style="color: #000"
											title="<%if (meetingRoom
											.getMcu_participant_visualName() != null
											&& !""
													.equals(meetingRoom
															.getMcu_participant_visualName())) {
										out
												.print(meetingRoom
														.getMcu_participant_visualName());
									} else
										out.print(meetingRoom
												.getMcu_participant_name());%>"
											id="font_<%=meetingRoom.getMeetingMCUKeyID()%>"
											class="td_Mcu_participant_name">
												<%
													if (meetingRoom
																					.getMcu_participant_visualName() != null
																					&& !""
																							.equals(meetingRoom
																									.getMcu_participant_visualName())) {
																				out
																						.print(meetingRoom
																								.getMcu_participant_visualName());
																			} else
																				out.print(meetingRoom
																						.getMcu_participant_name());
												%>

										</font>
										</a>

									</td>
									<td
										style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<span id="comment_${meetingRoom.meetingMCUKeyID}"
											style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis">
											<%
												HashMap ob = McuDwrMethod.getTerComment();
																		Object ipMap = ob
																				.get((String) request
																						.getAttribute("chooseMeetingNumber"));
																		if (ipMap != null) {
																			String com = (String) ((HashMap) ipMap)
																					.get(meetingRoom
																							.getMeetingMCUKeyID());
																			if (com != null) {
																				out.print(com);
																			}

																		}
											%> </span>
									</td>
									<script>
             	$(document).ready(function(){
					var commentField = document.getElementById("comment_<%=meetingRoom.getMeetingMCUKeyID()%>");
					commentField.title = commentField.innerHTML;
                 })
             </script>
									<td
										style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<span style="cursor: pointer"
											onclick="ipGo('<%=meetingRoom
											.getMcu_participant_ip()%>');"
											class="td_Mcu_participant_ip"
											id="<%=meetingRoom
											.getMcu_participant_ip()%>_<%=meetingRoom.getMeetingMCUKeyID()%>">
											<%=meetingRoom
											.getMcu_participant_ip()%> </span>
									</td>
									<td>
										<%
											if (meetingRoom.getConnectStatus() != null
																			&& meetingRoom.getConnectStatus()
																					.intValue() == 1) {
										%>

										<SPAN style="display: none;"
											id="span_img_connect_<%=meetingRoom
												.getMeetingMCUKeyID()%>">1</SPAN>
										<img src="${sys_ctx }/images/rmx1000/connected.gif"
											id="img_connect_<%=meetingRoom
												.getMeetingMCUKeyID()%>" />
										<%
											} else {
																		if (meetingRoom.getConnectStatus() != null
																				&& (meetingRoom
																						.getConnectStatus()
																						.intValue() == 2||meetingRoom.getConnectStatus().intValue()==3||meetingRoom.getConnectStatus().intValue()==4||meetingRoom.getConnectStatus().intValue()==5)) {
										%>
										<SPAN style="display: none;"
											id="span_img_connect_<%=meetingRoom
													.getMeetingMCUKeyID()%>">2</SPAN>
										<img src="${sys_ctx }/images/rmx1000/connecting.gif"
											id="img_connect_<%=meetingRoom
													.getMeetingMCUKeyID()%>" />
										<%
											} else {
																			if (meetingRoom.getConnectStatus() != null
																					&& meetingRoom
																							.getConnectStatus()
																							.intValue() == 3) {
										%>
										<SPAN style="display: none;"
											id="span_img_connect_<%=meetingRoom
														.getMeetingMCUKeyID()%>">3</SPAN>
										<img src="${sys_ctx }/images/rmx1000/disconnected.gif"
											id="img_connect_<%=meetingRoom
														.getMeetingMCUKeyID()%>" />
										<%
											} else {
										%>
										<SPAN style="display: none;"
											id="span_img_connect_<%=meetingRoom
														.getMeetingMCUKeyID()%>">3</SPAN>
										<img src="${sys_ctx }/images/rmx1000/disconnected.gif"
											id="img_connect_<%=meetingRoom
														.getMeetingMCUKeyID()%>" />
										<%
											}
																		}
																	}
										%>
									</td>

									<td
										style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<c:if
											test="${meetingRoom.audio == 0 && meetingRoom.connectStatus == 1}">
											<SPAN4></SPAN><!--<!-- <img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/> 
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/>
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 1 && meetingRoom.connectStatus == 1}">
											<SPAN2></SPAN><!--<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/mute.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 2 && meetingRoom.connectStatus == 1}">
											<SPAN1></SPAN><!--<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/block.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 3 && meetingRoom.connectStatus == 1}">
											<SPAN3></SPAN><!--<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/muteAndBlock.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 4 && meetingRoom.connectStatus == 1}">
											<SPAN4></SPAN><!--<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 5 && meetingRoom.connectStatus == 1}">
											<SPAN5></SPAN><!--<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/mute.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 6 && meetingRoom.connectStatus == 1}">
											<SPAN6></SPAN><!--<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/block.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 7 && meetingRoom.connectStatus == 1}">
											<SPAN7></SPAN><!--<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/muteAndBlock.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 8 && meetingRoom.connectStatus == 1}">
											<SPAN4></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/> 
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/>
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 9 && meetingRoom.connectStatus == 1}">
											<SPAN2></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/mute.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 10 && meetingRoom.connectStatus == 1}">
											<SPAN1></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/block.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 11 && meetingRoom.connectStatus == 1}">
											<SPAN3></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/muteAndBlock.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 12 && meetingRoom.connectStatus == 1}">
											<SPAN4></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 13 && meetingRoom.connectStatus == 1}">
											<SPAN5></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/mute.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 14 && meetingRoom.connectStatus == 1}">
											<SPAN6></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/block.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.audio == 15 && meetingRoom.connectStatus == 1}">
											<SPAN7></SPAN><!--<img src="${sys_ctx }/images/rmx1000/speaker.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/muteAndBlock.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/ptsmute.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if test="${meetingRoom.connectStatus != 1}">
											<SPAN0></SPAN><!-- <img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_speaker_${meetingRoom.meetingMCUKeyID }"/> -->
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_${meetingRoom.meetingMCUKeyID }"/>
    				<img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_audio_ptsmute_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
									</td>
									<td>
										<c:if
											test="${meetingRoom.video == 1 && meetingRoom.connectStatus == 1}">
											<SPAN1></SPAN><img src="${sys_ctx }/images/rmx1000/suspendVideo.gif" id="img_video_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.video != 1 || meetingRoom.connectStatus != 1}">
											<SPAN3></SPAN><img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_video_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
									</td>
									<td
										style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<c:if test="${meetingRoom.isLecturer == 1}">
											<SPAN1></SPAN><img name="role" src="${sys_ctx }/images/rmx1000/lecturer.gif" id="img_member_${meetingRoom.meetingMCUKeyID }"/>
    									</c:if>
    									
										<c:if test="${meetingRoom.isSpeaker == 1}">
											<SPAN3></SPAN><img src="${sys_ctx }/images/rmx1000/broadcaster.gif" id="img_member_${meetingRoom.meetingMCUKeyID }"/>
    			</c:if>
										<c:if
											test="${meetingRoom.isSpeaker != 1 && meetingRoom.isLecturer != 1}">
											<SPAN3></SPAN><img src="${sys_ctx }/images/rmx1000/blank.gif" id="img_member_${meetingRoom.meetingMCUKeyID }"/> 
    			</c:if>
										<c:if
											test="${meetingRoom.contentToken == 1 || meetingRoom.contentToken == 3}">
											<SPAN2></SPAN><img src="${sys_ctx }/images/rmx1000/contentOwner.gif" id="is_content_owner_${meetingRoom.meetingMCUKeyID }"/>
    			</c:if>
										<c:if
											test="${meetingRoom.contentToken != 1 && meetingRoom.contentToken != 3}">
											<SPAN3></SPAN><img src="${sys_ctx }/images/rmx1000/blank.gif" id="is_content_owner_${meetingRoom.meetingMCUKeyID }"/>
    			</c:if>
									</td>
									<td
										style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<c:if
											test="${meetingRoom.connectStatus == 1 && (meetingRoom.contentToken == 2 || meetingRoom.contentToken == 3)}">
											<SPAN1></SPAN><img src="${sys_ctx }/images/rmx1000/contentToken.gif" id="content_token_${meetingRoom.meetingMCUKeyID }">
    			</c:if>
										<c:if
											test="${meetingRoom.contentToken != 2 && meetingRoom.contentToken != 3}">
											<SPAN3></SPAN><img src="${sys_ctx }/images/rmx1000/blank.gif" id="content_token_${meetingRoom.meetingMCUKeyID }">
    			</c:if>
									</td>

									<td
										style="display: none;word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<c:if
											test="${meetingRoom.vIFractionLossPeak != '0.0' && meetingRoom.vIFractionLossPeak != null && meetingRoom.connectStatus == 1}">
											<span id="receive_<%=meetingRoom
												.getMeetingMCUKeyID()%>">${meetingRoom.vIFractionLoss}
												${meetingRoom.vIFractionLossPeak}</span>
										</c:if>
										<c:if
											test="${meetingRoom.vIFractionLossPeak == '0.0' || meetingRoom.vIFractionLossPeak == null || meetingRoom.connectStatus != 1}">
											<span id="receive_<%=meetingRoom
												.getMeetingMCUKeyID()%>"></span>
										</c:if>
									</td>
									<td
										style="display: none;word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<c:if
											test="${meetingRoom.vOFractionLossPeak != '0.0' && meetingRoom.vOFractionLossPeak != null && meetingRoom.connectStatus == 1}">
											<span id="send_<%=meetingRoom
												.getMeetingMCUKeyID()%>">${meetingRoom.vOFractionLoss}
												${meetingRoom.vOFractionLossPeak}</span>
										</c:if>
										<c:if
											test="${meetingRoom.vOFractionLossPeak == '0.0' || meetingRoom.vOFractionLossPeak == null || meetingRoom.connectStatus != 1}">
											<span id="send_<%=meetingRoom
												.getMeetingMCUKeyID()%>"></span>
										</c:if>
									</td>
									<td style="display: none">
										<c:if
											test="${(meetingRoom.casDialDirection =='dial_out' || meetingRoom.casDialDirection =='Dial-out') && meetingRoom.connectStatus == 1 }">
											<span id="casDialDirection_${meetingRoom.meetingMCUKeyID }">呼出</span>
										</c:if>
										<c:if
											test="${(meetingRoom.casDialDirection =='dial_in' || meetingRoom.casDialDirection =='Dial-in') && meetingRoom.connectStatus == 1}">
											<span id="casDialDirection_${meetingRoom.meetingMCUKeyID }">呼入</span>
										</c:if>
										<c:if test="${meetingRoom.connectStatus != 1}">
	    				&nbsp;<span
												id="casDialDirection_${meetingRoom.meetingMCUKeyID }">
											</span>
										</c:if>
									</td>
									<td class="td_Mcu"
										id="<%=tempConfVO.getMcuName()%>_<%=meetingRoom.getMeetingMCUKeyID()%>"
										style="word-break: keep-all; white-space: nowrap; text-overflow: ellipsis; overflow: hidden;">
										<span id="mcuName_${meetingRoom.meetingMCUKeyID}"><%=tempConfVO.getMcuName()%></span>
									</td>
								</tr>

								<%
									}
													}
								%>
								<%
									}

											}
										}
									}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</form>
			<%--    </div>--%>

			<!--contentwrapper-->
			<!--  <div id="operateDiv" style="position:absolute;border:2px;display:none;z-index:9999;float:right;right:0px"> -->
			<%--<div id="operateDiv"   style="height:500px;border:2px;display:none;float:right top;overflow:hidden;overflow-y:scroll;">--%>
			<%--
	<div id="operateDiv"  title="视频会场" style="display:none">
			<%@include file="operateMenu.jsp" %>
  	</div>
   
	  <input id="kstMeetNumber" type="hidden" />
	<div id="vedioMonitorDiv" title="视频监控" style="display:none;vertical-align: middle">
		<iframe width="100%" height="100%" src="../camera/jiankongTree.action"></iframe>
	</div>
	--%>
			<div id="lunXunTimeDiv"
				style="overflow: auto; display: none; LEFT: 250px; TOP: 115px; POSITION: absolute; background: #A9A9A9"
				class="popdialog">
				<table width="490" border="0" cellspacing="0" cellpadding="0"
					align="center">
					<tr>
						<td>
							<fieldset>
								<br />
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="ar fontstyle fontb pr3 tdhight">
											轮循间隔时间（秒）
										</td>
										<td class="al pl3">
											<input id="lunXunTimeID" value="10" />
										</td>
									</tr>
								</table>
								<table cellpadding="0" cellspacing="1" class="" width="100%"
									align="center">
									<tr>
										<td width="100%" height="35" colspan="4" align="center">
											<input name="input3" value="确 定" type="button"
												class="tableBtn" onclick="startPolling('room');" />
											<input name="input3" value="返 回" type="button"
												class="tableBtn" onclick="closeDIV('lunXunTimeDiv');" />
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
				</table>
			</div>


			<div id="delayMeetingTime" class="contentwrapper"
				style="width: 480px; display: none; LEFT: 250px; TOP: 115px; POSITION: absolute; z-index: 50">
				<div class="contenttitle2" style="width: 100%">
					<h5 class="fwb fl10">
						会议延时
					</h5>
				</div>
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">

					<tr>
						<td class="tableaddtitle" width="50%">
							延迟时间（小时）
						</td>
						<td class="tableadd_data">
							<select id="delayMeetingTimeID" class="select2002 fontstyle">
								<option value="1" selected="selected">
									1
								</option>
								<option value="2">
									2
								</option>
								<option value="4">
									4
								</option>
								<option value="10">
									10
								</option>
								<option value="23">
									23
								</option>
							</select>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
					<tfoot>
					</tfoot>
					<tbody>
						<tr>
							<td>

								<input type="button" name="button" id="button"
									class="submit1 radius2" value="确 定" onclick="meetingDelay();" />

								<input type="button" name="button2" id="button2"
									class="reset1 radius2" value="取 消"
									onclick="closeDIV('delayMeetingTime');" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
<!-- zjy -->
			<div id="comments" style="overflow: auto; display: none; LEFT: 250px; TOP: 150px; POSITION: absolute; width: 420px; background: #F5F5F5">
				<div class="contenttitle2">
		         <h5 class="fwb fl10" id="fwbid110">会场备注</h5>
	             </div>
				<div id="basicform" class="contentwrapper">
					<table width="100%" border="0" cellspacing="1" cellpadding="0"
						class="tableadd">
						<tr>
							<td class="tableadd_data">
								<textarea id="commentText" cols="50" rows="5" style="width: 99%"
									onclick="javascript:if(this.value=='请输入备注'){this.value='';}">请输入备注</textarea>
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="1" cellpadding="0"
						class="tableadd">
						<tr>
							<td class="tableadd_data">
								<input style="float: right; margin-right: 10px; padding: 3.5px 4px;" type="reset" id="commentsCancel" class="reset1 radius2" value="取 消" onclick="closeDIV('comments')" />
								<input style="float: right; padding: 3.5px 4px;" type="reset" id="commentsAdd" class="submit1 radius2" value="确 定" onclick="" />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	</body>
	<script type="text/javascript">
        function refreshSelf(number){
			window.location.href = "${sys_ctx }/mcuControl/getClassifiedRoomList.action?refresh=" + number + "&chooseMeetingNumber=" + document.getElementById("filterSelectId").value;
  		}
       
		var meetingDetailID = document.getElementById("filterSelectId").value;

		/*McuDwrMethod.getMeetingConfs(meetingDetailID,function backIps(strs){
			if(strs.length == 0){
			   return;
			}
		    mcuIps= new Array();
			mcuIps = strs;
		})*/
		
  		if((meetingDetailID == "" || meetingDetailID == null) && window.location.href.indexOf("refresh") == -1){
  			window.setTimeout("refreshSelf('2')", 3000);
  		}else{
			var mcuListExistCheck = document.getElementsByName("mcuListExistCheck");
			if(meetingDetailID != "" && meetingDetailID != null && mcuListExistCheck == null && window.location.href.indexOf("refresh=2") != -1){
				window.setTimeout("refreshSelf('3')", 2000);				
			}else{
				//update when having pts.
				if(meetingDetailID != "" && meetingDetailID != null && mcuListExistCheck != null){
					if(window.location.href.indexOf("refresh=4") == -1){
						//window.setTimeout("refreshSelf('4')", 2000);
						//window.setTimeout("getMeetingRoomList('${chooseMeetingNumber}')",3000);
						//window.setTimeout("getMasterConf('${chooseMeetingNumber}')",3000);
					}
					//var intervalFunc = window.setInterval("getMeetingRoomList('${chooseMeetingNumber}')", 3000);
					//var intervalFunc1 = window.setInterval("getMasterConf('${chooseMeetingNumber}')", 3000);
				}
			}
  		}
  		
		//this global variable is used to check connction status update condition.
		var isUpdated = false;
		//inital sort
		var meetingDetailID = document.getElementById("filterSelectId").value;
		
		//专员办=begin=======
		function backUp(type){
			var meetingDetailId = getMeetingDetailId();
			mcuControlMethod.addParticipants(meetingDetailId, "10.255.255.138", function(parame){
				if(!parame) alert("添加失败！");
			});
			
			ControlDWR.backUp(meetingDetailId,type,function(back){
					if(!back) alert("操作异常");
			})
		}
		
		//建会--处理预监终端操作
		function test(){
			var meetingDetailId = getMeetingDetailId();
			var roomID = "";
			var count = 0;
			var rooms = document.getElementsByName("room");
			for(var i=0; i < rooms.length; i++){
				if(rooms[i].checked == true){
					count++;
					roomID += rooms[i].value;
				}
			}
			if(count!=1){
			alert("只能选择一个会场");
			return;
			}
			ControlDWR.yuJianOperate(meetingDetailId,roomID,function(back){
						if(!back) alert("操作异常");
			})
		}
		//end=======================
  </script>
</html>