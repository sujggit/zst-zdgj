	<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zzst.model.enums.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link rel="stylesheet" type="text/css"
			href="/icmp/meeting/meetingManage/comparison/lib/jsProgressBarHandler.css"
			media="screen" />
		<style type="text/css">
			#fullbg {background-color: #a6b7c8;/*#aadfe4*/display:none;z-index:3;position:absolute;
			    left:0px;top:0px;width:100%;height:100%;filter:Alpha(Opacity=30);/* IE */-moz-opacity:0.4;/* Moz + FF */opacity: 0.6;}
			.showWindow{background: #DCDCDC;border:2px solid #6A5AEB;position:absolute;z-index: 10;filter:Alpha(Opacity=70);/* IE */ -moz-opacity:0.7;/* Moz + FF */ opacity: 0.6;}
			.dialogDiv{background: no-repeat; width:500px; height:250px; border:0px; }
			.dialog_title{background: #6A5AEB; height: 20px; line-height: 20px;filter:Alpha(Opacity=80);}
			.fontone{padding-top:60px; font-size:24px; color:#a90d19; font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold; text-align:center;}
			.fonttwo{text-align:right; padding-right:30px; color:414243; width:399px; font-size:18px;font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif;}
			.fonttwo a { text-decoration: none; color: #414243; outline: none; }
			.fonttwo a:hover { text-decoration: underline; color: #000000; outline: none; }
		</style>	
			
		<%@include file="/common/common.jsp"%>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
		<script type='text/javascript' src='${sys_ctx }/dwr/interface/VoiceCardDwrMethod.js'></script>
		<script type="text/javascript" src="${sys_ctx }/js/jquery.progressbar.js"></script>
		<script type="text/javascript">
	
	function exportComparison(){onload="setInterval('refresh()',6*1000)"
		window.location.href="${sys_ctx}/detail/exportComparisonList.action";
	}
	 
	 function test(){
		 myJsProgressBarHandler.setPercentage('element1',30);
		//setPercentage('element1','0');return false;
		 alert(155);
	     }
	
	 
	 function getComparisonProcess(){
		 var meetingDetailID = document
			.getElementById("meetingDetailIDSelect").value;

			if(meetingDetailID==""){
				//myJsProgressBarHandler.setPercentage('element1',0);
				$("#element1").progressBar(0, { barImage: '/icmp/meeting/meetingManage/comparison/images/progressbg_green.gif.png'} );
				}else{
					 VideoCardDwrMethod.getComparisonProcess(meetingDetailID,backToSetBarProcess);
					}
		
		 }

	function backToSetBarProcess(percent){
	   // alert(percent);
	   // var barPercent="'"+percent+"'";
	    var pre=document.getElementById("pre").value;
		
	    if(pre==""){
	    	pre=0;
		    }
 	 
	  var now= parseInt(percent);
	  var pre= parseInt(pre);
      var plus=now-pre;
      var strPlus="+"+plus;
	 if(now == 100 && now > pre){
	 	refresh();
	 	return;
	 }
	 
     //  myJsProgressBarHandler.setPercentage('element1',strPlus);
     $("#element1").progressBar(percent, { barImage: '${sys_ctx }/images/progressbg_green.gif'} ); 
		 document.getElementById("pre").value=percent;
		    }
	
	//VideoCardParameter音视频参数

	function getThreadStatus() {
		var meetingDetailID = document.getElementById("meetingDetailIDSelect").value;
		//alert(meetingDetailID);
		VideoCardDwrMethod.getThreadStatus(meetingDetailID, getStatusBack);

	}

	function getStatusBack(flag) {
		alert(flag);
	}

	var meetingDetailId;
	var compareThreadCount = "0";
	function compare() {
		if(compareThreadCount == "1"){
	    	alert("现在不能点名，一个时间段只能有一个会议能点名！");
	    	return;
	    }
	    compareThreadCount = "1";
		//获得音视频参数 0是音视频，1是视频
		var videoOrAudioObj = document
				.getElementsByName("comparisonVO_.status");

		var videoOrAudio = null;
		for ( var i = 0; i < videoOrAudioObj.length; i++) {
			if (videoOrAudioObj[i].type == "radio"
					&& videoOrAudioObj[i].checked == true) {
				videoOrAudio = videoOrAudioObj[i].value;
			}
		}

		var meetingDetailIDSelect = document
				.getElementById("meetingDetailIDSelect");
		if(meetingDetailIDSelect.value == ""){
			alert("没有会议，无法点名！");
			return;
		}

		if (videoOrAudio == 1) {

			VideoCardDwrMethod.autoCompare(meetingDetailIDSelect.value,
					videoOrAudio, compareBackup);
		}
		if (videoOrAudio == 0) {
           //alert(33);
			VoiceCardDwrMethod.autoCompareVoice(meetingDetailIDSelect.value,
					videoOrAudio,voicebCompareBack);
		} else {
			return;
		}

	}

	function voicebCompareBack(result) {
		compareThreadCount = "0";
		if (result == "none") {
			alert("现在不能点名，一个时间段只能有一个会议能点名！");
		} else {
			if (result == "nobroadcaster") {
				alert("现在不能点名，会议没有广播者！");
			}else{
				if (result == "noconf") {
					alert("现在不能点名，没有此会议会场信息！");
				}else{
			  		refresh();
			  	}
			}
		}
	}
	

	function compareBackup(result) {
		compareThreadCount = 0;
		if (result == "none") {
			alert("现在不能点名，一个时间段只能有一个会议能点名！");
		} else {
			if (result == "nobroadcaster") {
				alert("现在不能点名，会议没有广播者！");
			}else{
				if (result == "noconf") {
					alert("现在不能点名，没有此会议会场信息！");
				}else{
					refresh();
				}
			}
		}
	}

	function stopCompare() {
		compareThreadCount = 0;
		var meetingDetailIDSelect = document
				.getElementById("meetingDetailIDSelect");
		if(meetingDetailIDSelect.value == ""){
			alert("没有会议！");
			return;
		}
		VideoCardDwrMethod.stopAutoCompare(meetingDetailIDSelect.value,
				stopCompareBackup);
	}

	function stopCompareBackup(result) {
		compareThreadCount = 0;	
		//if(result == "none"){
		//	alert("目前可能没有点名线程");
		//}else{
		alert("操作成功!");
		//}
	}

	function refresh() {
		var pre=document.getElementById("pre").value;
		var meetingDetailIDSelect = document
				.getElementById("meetingDetailIDSelect");

		//获得音视频参数 0是音视频，1是视频
		var videoOrAudioObj = document
				.getElementsByName("comparisonVO_.status");

		var videoOrAudio = null;
		for ( var i = 0; i < videoOrAudioObj.length; i++) {
			if (videoOrAudioObj[i].type == "radio"
					&& videoOrAudioObj[i].checked == true) {
				videoOrAudio = videoOrAudioObj[i].value;
			}
		}
		
		
	  //var prePercent= document.getElementById("element1").innerHTML;
	 // alert(prePercent);
		window.location.href = "${sys_ctx}/videoCardCompare/queryComparisonList.action?chooseMeetingNumber="
				+ meetingDetailIDSelect.value+"&barPercent="+pre+"&radioStatus="+videoOrAudio;
		//window.location.href = window.location.href;
		//window.location.reload();
	}

	function changeMeetingDetail(selectValue) {
		//var chooseMeetingNumber = document.getElementById("meetingDetailIDSelect").value;
		//alert(chooseMeetingNumber);
		// $('#pageform').submit();
		meetingDetailId = selectValue;
		//compare();
		refresh();
	}

	function comparisonDetail(compDetailID, comparisonID, masterEpIp) {

		//window.open("${sys_ctx}/videoCardCompare/comparisonDetail.action?comparisonVO.compDetailID="+compDetailID+"&comparisonVO.ID="+comparisonID+"&masterEpIp="+masterEpIp,window222,'');
		window
				.open(
						"${sys_ctx}/videoCardCompare/comparisonDetail.action?comparisonVO.compDetailID="
								+ compDetailID
								+ "&comparisonVO.ID="
								+ comparisonID + "&masterEpIp=" + masterEpIp,
						'newwindow',
						'height=670px,width=1100px,top=100px,left=100px,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
	}

	function reView() {
		window.location.href = "/icmp/meeting/meetingManage/viewCompare/RviewCompare.jsp";

	}
	function toView(meetingRoomID, meetingDetailId, compDetailID, IP) {
		window
				.showModalDialog(
						"${sys_ctx}/meeting/meetingManage/viewCompare/detailCompareView.jsp?meetingRoomNo="
								+ meetingRoomID
								+ "&meetingDetailId="
								+ meetingDetailId
								+ "&compareDetailId="
								+ compDetailID + "&equipIp=" + IP, window,
						'dialogWidth=1100px;dialogHeight=670px;');
	}

	function manufacturerComparison(comparisonDetaildID, comparisonID, roomID) {
		window.location.href = "${sys_ctx}/videoCardCompare/toMamufactruerComparison.action?comparisonVO.compDetailID="
				+ comparisonDetaildID
				+ "&comparisonVO.ID="
				+ comparisonID
				+ "&meetingRoomVO.meetingRoomID=" + roomID;
	}
	
	function getEquipmentDetails(comparisonDetaildID, comparisonID, roomID) {
		window.showModalDialog("${sys_ctx}/videoCardCompare/getEquipmentStatus.action?comparisonVO.compDetailID="
				+ comparisonDetaildID
				+ "&comparisonVO.ID="
				+ comparisonID
				+ "&meetingRoomVO.meetingRoomID=" + roomID, "window", 'dialogWidth=600px;dialogHeight=470px;');
	}

   function singleCompareVoice(comparisonID){
   	   showBg('dialog','dialog_content');
   	   VoiceCardDwrMethod.singleCompareVoice(comparisonID,singleCompareVoiceBack);
   }
	
	function singleCompareVoiceBack(result) {
		closeBg();
		if (result == "none") {
			alert("比对失败！\n被点名会场或主会场无效(不在线或不存在)!");
		} else {
			alert("单会场比对完成！");
			
		}
		
	
	}
	function loadHandler() {
		$("#element1").progressBar(${barPercent}, {barImage: '${sys_ctx }/images/progressbg_green.gif'});
		setInterval("getComparisonProcess()",5*1000);
		
	
	}
	
    //显示灰色JS遮罩层 
	function showBg(ct,content){ 
	    var bH=$("body").height()+20; 
	    var bW=$("body").width()+16; 
	    var objWH=getObjWh(ct); 
	    $("#fullbg").css({display:"block"}); 
	    var tbT=objWH.split("|")[0]+"px"; 
	    var tbL=objWH.split("|")[1]+"px"; 
	    $("#"+ct).css({top:tbT,left:tbL,display:"block"}); 
	    $(window).scroll(function(){resetBg()}); 
	   	$(window).resize(function(){resetBg()}); 
	} 
	function getObjWh(obj){ 
	    var st=document.documentElement.scrollTop;//滚动条距顶部的距离 
	    var sl=document.documentElement.scrollLeft;//滚动条距左边的距离 
	    var ch=document.documentElement.clientHeight;//屏幕的高度 
	    var cw=document.documentElement.clientWidth;//屏幕的宽度 
	    var objH=$("#"+obj).height();//浮动对象的高度 
	    var objW=$("#"+obj).width();//浮动对象的宽度 
	    var objT=Number(st)+(Number(ch)-Number(objH))/2; 
	    var objL=Number(sl)+(Number(cw)-Number(objW))/2; 
	    return objT+"|"+objL; 
	} 

	function resetBg(){ 
	    var fullbg=$("#fullbg").css("display"); 
	    if(fullbg=="block"){ 
	        var bH2=$("body").height(); 
	        var bW2=$("body").width()+16; 
	        $("#fullbg").css({width:bW2,height:bH2}); 
	        var objV=getObjWh("dialog"); 
	        var tbT=objV.split("|")[0]+"px"; 
	        var tbL=objV.split("|")[1]+"px"; 
	        $("#dialog").css({top:tbT,left:tbL}); 
	    } 
	} 
	//关闭灰色JS遮罩层和操作窗口 
	function closeBg(){ 
	    $("#fullbg").css("display","none"); 
	    $("#showWindow").css("display","none"); 
	    $("#dialog").css("display","none"); 
	} 
	
</script>
	</head>
	<body onload='loadHandler()'>
		<form action="${sys_ctx}/videoCardCompare/queryComparisonList.action"
			id="pageform" name="pageform" method="post">
			<div id="basicform" class="contentwrapper">
				<table width="100%" border="0" cellspacing="1" cellpadding="0"
					class="tableadd">
					<tr>
						<td width="15%" class="tableaddtitle">
							会议列表
						</td>
						<td class="tableadd_data">
							<select name="" id="meetingDetailIDSelect" class="inputtran bl"  onchange="changeMeetingDetail(this.value);"

								<c:if test="${disabled=='disabled'}">disabled</c:if>>
								<c:forEach items="${meetingDetailList}" var="meetingDetail">
									<option value="${meetingDetail.meetingDetailID }"
										${meetingDetail.meetingDetailID==chooseMeetingNumber? "selected" : "" }>
										${meetingDetail.meetingName }
									</option>
								</c:forEach>
								<c:if test="${empty  meetingDetailList}">
									<option value="">
										没有会议
									</option>
								</c:if>
							</select>
							<!--<select name="comparisonVO_.status">
								<option value="0" <c:if test="${radioStatus==0}">selected</c:if>>音视频</option>
								<option value="1" <c:if test="${radioStatus==0}">selected</c:if>>视频</option>
							</select>-->
							  <span><input type="radio" name="comparisonVO_.status"
									value="0"  <c:if test="${radioStatus==0}">checked</c:if>/>音视频</span>
							<span><input type="radio" name="comparisonVO_.status"
									value="1"  <c:if test="${radioStatus==1}">checked</c:if>/>视频</span>

                   <!-- <input type="button" onclick="getComparisonProcess()"/> -->
						</td>

						<td class="tableaddtitle" style="width:200px;">
							<input type="button" class="stdbtn mlr10" value="点 名"	onclick="compare();"/>
							<input type="button" class="stdbtn mlr10" value="终止点名"	onclick="stopCompare();"/>
							<input type="button" class="stdbtn mlr10" value="刷 新"	onclick="refresh();"/>
						</td>
					</tr>
				</table>
			</div>

			<div id="contentwrapper" class="contentwrapper">
				<div class="contenttitle2">
					<h5 class="fwb fl10">
						查询列表&nbsp;&nbsp;
					</h5>
					<h5 class="fwb fl10">
                       <span id="demo"><span  id="element1"></span></span>
					   <input type="hidden" value="${barPercent}" id="pre" name="barPercent"/>
					</h5>
					<h5 class="fwb fr10">
						<span class="copan_one">好</span>/<span class="copan_two">中</span>/<span class="copan_tree">差</span>：<span class="copan_one">${goodCount}</span>/<span class="copan_two">${okCount}</span>/<span class="copan_tree">${badCount}</span>
						<!-- 
						<font color="red">进度:已标定会场数：<c:if
								test="${referencedCount==null}">0</c:if>
							<c:if test="${referencedCount!=null}">${referencedCount}</c:if>
						</font>/总会场数：
						<c:if test="${epCount!=null||epCount==0}">${epCount}</c:if>
						<c:if test="${epCount==null}">${referencedCount==null?0:referencedCount}</c:if>
						 -->
					</h5>

				</div>



				<div id="tableShow">
					<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
						id="query_table">
						<thead>
							<tr>
								<th width="9%" class="head1">
									序号
								</th>
								<th width="15%" class="head1">
									会场名称
								</th>
								<th width="9%" class="head1">
									结果
								</th>
								<th width="9%" class="head1">
									音频&uarr;
								</th>
								<th width="9%" class="head1">
									音频&darr;
								</th>
								<th width="9%" class="head1">
									视频&uarr;
								</th>
								<th width="9%" class="head1">
									视频&darr;
								</th>
								<!--    <th width="9%" class="head1">上行音频</th>
            <th width="9%" class="head1">下行音频</th>-->
								<th width="9%" class="head1">
									丢包率&uarr;
								</th>
								<th width="9%" class="head1">
									丢包率&darr;
								</th>
                             <th width="7%" class="head1">
									状态
								</th>
								<th width="210" class="head1">
									操作
								</th>
							</tr>
						</thead>
						<tfoot>
						</tfoot>
						<tbody>
							<c:forEach items="${comparisonVOList}" var="comparisonVO"
								varStatus="status">
								<tr>
									<td class="alc" id="comparison_${status.index+1}">
										<c:out value="${status.index+1}"></c:out>
									</td>
									<td title="${comparisonVO.meetingRoomVO.meetingRoomName}">
										<c:out value="${comparisonVO.meetingRoomVO.meetingRoomName}"></c:out>
									</td>
									<td>
										<c:if test="${comparisonVO.result==3}">好</c:if>
										<c:if test="${comparisonVO.result==2}">中</c:if>
										<c:if test="${comparisonVO.result==1}">差</c:if>
										<c:if test="${comparisonVO.result==6}">
											<font color="red">手工确认好</font>
										</c:if>
										<c:if test="${comparisonVO.result==5}">
											<font color="red">手工确认中</font>
										</c:if>
										<c:if test="${comparisonVO.result==4}">
											<font color="red">手工确认差</font>
										</c:if>
										<c:if
											test="${comparisonVO.result!=1&&comparisonVO.result!=2&&comparisonVO.result!=3&&comparisonVO.result!=4&&comparisonVO.result!=5&&comparisonVO.result!=6}">—</c:if>

									</td>
									
									<td>
										<!--<c:out value="${comparisonVO.upVideoQuality}"></c:out>-->	
										<c:if test="${comparisonVO.upAudioQuality==1}">
											有
										</c:if>	
										<c:if test="${comparisonVO.upAudioQuality==0}">
											无
										</c:if>		
										<c:if test="${comparisonVO.upAudioQuality==6}">
											<font color="red">手工确认好</font>
										</c:if>		
										<c:if test="${comparisonVO.upAudioQuality==5}">
											<font color="red">手工确认中</font>
										</c:if>	
										<c:if test="${comparisonVO.upAudioQuality==4}">
											<font color="red">手工确认差</font>
										</c:if>						
										<c:if test="${comparisonVO.upAudioQuality!=0&&comparisonVO.upAudioQuality!=1 &&comparisonVO.upAudioQuality!=6&&comparisonVO.upAudioQuality!=4&&comparisonVO.upAudioQuality!=4}">
											—
										</c:if>	
									</td>
									<td>
									<c:if test="${comparisonVO.downAudioQuality==1}">
											有
										</c:if>	
										<c:if test="${comparisonVO.downAudioQuality==0}">
											无
										</c:if>	
										<c:if test="${comparisonVO.downAudioQuality==6}">
											<font color="red">手工确认好</font>
										</c:if>	
										<c:if test="${comparisonVO.downAudioQuality==5}">
											<font color="red">手工确认中</font>
										</c:if>	
										<c:if test="${comparisonVO.downAudioQuality==4}">
											<font color="red">手工确认差</font>
										</c:if>										
										<c:if test="${comparisonVO.downAudioQuality!=0&&comparisonVO.downAudioQuality!=1&&comparisonVO.downAudioQuality!=6&&comparisonVO.downAudioQuality!=5&&comparisonVO.downAudioQuality!=4}">
											—
										</c:if>	
									
									</td>
									
									<td>
										<!--<c:out value="${comparisonVO.upVideoQuality}"></c:out>-->
										<c:if test="${comparisonVO.upVideoQuality==3}">好</c:if>
										<c:if test="${comparisonVO.upVideoQuality==2}">中</c:if>
										<c:if test="${comparisonVO.upVideoQuality==1}">差</c:if>
										<c:if test="${comparisonVO.upVideoQuality==6}">
											<font color="red">手工确认好</font>
										</c:if>
										<c:if test="${comparisonVO.upVideoQuality==5}">
											<font color="red">手工确认中</font>
										</c:if>
										<c:if test="${comparisonVO.upVideoQuality==4}">
											<font color="red">手工确认差</font>
										</c:if>
										<c:if
											test="${comparisonVO.upVideoQuality!=1&&comparisonVO.upVideoQuality!=2&&comparisonVO.upVideoQuality!=3&&comparisonVO.upVideoQuality!=4&&comparisonVO.upVideoQuality!=5&&comparisonVO.upVideoQuality!=6}">—</c:if>

									</td>
									<td>
										<!--<c:out value="${comparisonVO.downVideoQuality}"></c:out>-->

										<c:if test="${comparisonVO.downVideoQuality==3}">好</c:if>
										<c:if test="${comparisonVO.downVideoQuality==2}">中</c:if>
										<c:if test="${comparisonVO.downVideoQuality==1}">差</c:if>
										<c:if test="${comparisonVO.downVideoQuality==6}">
											<font color="red">手工确认好</font>
										</c:if>
										<c:if test="${comparisonVO.downVideoQuality==5}">
											<font color="red">手工确认中</font>
										</c:if>
										<c:if test="${comparisonVO.downVideoQuality==4}">
											<font color="red">手工确认差</font>
										</c:if>
										<c:if
											test="${comparisonVO.downVideoQuality!=1&&comparisonVO.downVideoQuality!=2&&comparisonVO.downVideoQuality!=3&&comparisonVO.downVideoQuality!=4&&comparisonVO.downVideoQuality!=5&&comparisonVO.downVideoQuality!=6}">—</c:if>
									</td>
									<!--  <td class="ac fontstyle ">
				<c:out value="${comparisonVO.upAudioQuality}"></c:out>
				</td>
				<td class="ac fontstyle ">
				<c:out value="${comparisonVO.downAudioQuality}"></c:out>
				</td>-->
									<td>
										<c:out value="${comparisonVO.sendPacketLoss}"></c:out>
									</td>
									<td>
										<c:out value="${comparisonVO.receivePacketLoss}"></c:out>
									</td>
                                      <td title="${comparisonVO.result==8 ? '不通' : '通'}">
                                      <c:if test="${comparisonVO.result==8}">
											<font color="red">不通</font>
										</c:if>
										<c:if test="${comparisonVO.result!=8}">
											<font color="green">通</font>
										</c:if>
										<c:out value=""></c:out>
									</td>
									<td class="alc">
										<a class="funcOper <%= FuncEnum.FUNC_NO_MANUALCONFIRMATION%>"
											onclick="manufacturerComparison('${comparisonVO.compDetailID}','${comparisonVO.ID}','${comparisonVO.meetingRoomVO.meetingRoomID}');">手工确认</a>
										 
										<a class="funcOper <%= FuncEnum.FUNC_NO_ALINGMENTCARDS%>" title="比对卡详情查看"
											onclick="comparisonDetail('${comparisonVO.compDetailID}','${comparisonVO.ID}','${masterEpIp}')">比对卡</a>
										 
										<a class="funcOper <%= FuncEnum.FUNC_NO_DETAILEQUIPMENT%>" title="设备详情查看"
											onclick="getEquipmentDetails('${comparisonVO.compDetailID}','${comparisonVO.ID}','${comparisonVO.meetingRoomVO.meetingRoomID}')">设备</a>	
										 
										<a class="funcOper <%= FuncEnum.FUNC_NO_SINGLECOMPAREVOICE%>" title="单会场点名" onclick="singleCompareVoice('${comparisonVO.ID}')">点名</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
					
		<div id="fullbg"></div>
		<!-- end JS遮罩层 -->
		<!-- 对话框 -->
		<div class="showWindow" style="display:none" id="dialog">
			<div  class="dialogDiv" id="dialog_content">
				<p class="dialog_title"></p>
				<p class="fontone">单会场点名中，请稍等...</p>
				<p style="text-align:center;"><img src="/icmp/images/advance/loading.gif" width="50" height="10" style="margin-top: 20px;"/></p>
				<p class="fonttwo"></p>
			</div>
		</div>
			
		</form>
		
	</body>
</html>