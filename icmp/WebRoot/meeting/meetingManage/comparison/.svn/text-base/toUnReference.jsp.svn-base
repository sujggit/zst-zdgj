<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base target="_self"/>
<%@include file="/common/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${sys_ctx}/meeting/meetingManage/comparison/css/comparisonCss.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>会议比对列表</title>
		
		<style type="text/css">
			
			#fullbg {background-color: #a6b7c8;/*#aadfe4*/display:none;z-index:3;position:absolute;
			    left:0px;top:0px;width:100%;height:100%;filter:Alpha(Opacity=30);/* IE */-moz-opacity:0.4;/* Moz + FF */opacity: 0.6;}
			.showWindow{background: #DCDCDC;border:2px solid #6A5AEB;position:absolute;z-index: 10;filter:Alpha(Opacity=70);/* IE */ -moz-opacity:0.7;/* Moz + FF */ opacity: 0.6;}
			.dialogDiv{background: no-repeat; width:399px; height:199px; border:0px; }
			.dialog_title{background: #6A5AEB; height: 20px; line-height: 20px;filter:Alpha(Opacity=80);}
			.fontone{padding-top:60px; font-size:24px; color:#a90d19; font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif; font-weight:bold; text-align:center;}
			.fonttwo{text-align:right; padding-right:30px; color:414243; width:399px; font-size:18px;font-family:'Microsoft Yahei', Arial, Helvetica, sans-serif;}
			.fonttwo a { text-decoration: none; color: #414243; outline: none; }
			.fonttwo a:hover { text-decoration: underline; color: #000000; outline: none; }
		</style>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/VideoCardDwrMethod.js'></script>
		<script type="text/javascript">
		 function modify(id){
  location.href="${sys_ctx}/videoCardCompare/singleCompareCriteria.action?comparisonReferenceVO.ID="+id;
  }	
  
  
  function singleCompareadd(){
  window.location.href="${sys_ctx}/meeting/meetingManage/singleComparisonCriteriaAdd.jsp";
  
  }
  
  
   function equipmentdel(ID){
  
	if(!window.confirm("是否确认删除？")) return;
  window.location.href="${sys_ctx}/videoCardCompare/SingleCompareCriteriaDel.action?comparisonReferenceVO.ID="+ID;
  
  }
  function Qeury(){
  $("#pageform").submit();
  }
  
//全选或取消
  function queryAllToReferenced(){
	  var selAll=$("#selectAll").attr("checked");
	if(selAll==true){
		$("input[type='checkbox']").attr("checked","true");
		}else{
			$("input[type='checkbox']").removeAttr("checked");
			}
    
	  }

//选定标定
function toReferenced(){
	showBg('dialog','dialog_content');
var box=$("input[type='checkbox'][name='toSelect']");
var meetingRoomID="";
 //alert(box.length);
 for(var i=0;i<box.length;i++){ 
	   if(box[i].checked==true){
		  // alert(box[i].value);
		   meetingRoomID+=box[i].value+","
	     }
	  
	 
	 }
// alert(meetingRoomID);
 VideoCardDwrMethod.setSomeOrAllStandardRGB(meetingRoomID ,allback);//box[i].value
}

function allback(bool){
	//alert(bool);
	 if(bool=='true'){
	window.dialogArguments.location =window.dialogArguments.location;
	 window.close();
	 } else{
         alert("标定失败！");
         return;
         }
	 
}

  
  //标定
  function getReferenceRGB(meetingRoomID){
	  //alert(111);
	  VideoCardDwrMethod.setStandardRGB(meetingRoomID,backBool);
	  
	  
  }


  function backBool(bool){
     //alert(bool);
     closeBg();
     if(bool=='true'){
     window.dialogArguments.location =window.dialogArguments.location;	    
      window.close();
     }
     else{
         alert("标定失败！");
         return;
         }
     
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
  
  <body STYLE='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN'>
   
    <form action="/icmp/videoCardCompare/queryCompareMeeting.action" method="post" name="pageform" id="pageform">
     <div id="contentwrapper" class="contentwrapper">
    
	<div class="contenttitle2">
		<h5 class="fwb fl10">未标定&nbsp;&nbsp;<!--select class="radius3">
			<option value="" selected="selected">列表模式</option>
			<option value="">图表模式</option</select> -->
		
        </h5>
     </div>
     <div class="tableoptions" style="height:30px;line-height:30px">
           
		<span style=" float:right;margin:0;padding:0" class="comparison">
        	<input type="button" class="searchbtn radius2" value="标定" onclick="toReferenced();"/>
        </span>
	</div>
	<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="">
		<thead>
			<tr>
				<th width="8%" class="head1">全选<input type="checkbox" id="selectAll"  onclick="queryAllToReferenced()"/></th>
				<th width="26%" class="head1">会场名称</th>
                <th width="26%" class="head1">对比卡IP地址</th>
                <th width="20%" class="head1">终端IP地址</th>
				<th width="20%" class="head1">操作</th>
			</tr>
        </thead>
        <tbody>
         <c:forEach items="${comparisonReferenceVOList}" var="comparisonReferenceVO" varStatus="status">
			
			<tr class="gradeX">
				<td class="alc"><input type="checkbox" name="toSelect" value="${comparisonReferenceVO.meetingRoomID}"/></td>
				<td><c:out value="${comparisonReferenceVO.meetingRoomName}" /></td>
                <td><c:out value="${comparisonReferenceVO.videoCardIp}" /></td>
                <td><c:out value="${comparisonReferenceVO.terminalIp}" /></td>
				<td class="alc"><input type="button" class="searchbtn radius2" onclick="getReferenceRGB('${comparisonReferenceVO.meetingRoomID}')" value="标定" /></td>
			</tr>
          </c:forEach>
          
		</tbody>
	</table>
    
</div>

 <div id="fullbg"></div>
<!-- end JS遮罩层 -->
<!-- 对话框 -->
<div class="showWindow" style="display:none" id="dialog">
	<div  class="dialogDiv" id="dialog_content">
		<p class="dialog_title"></p>
		<p class="fontone">比对卡正在努力标定，请稍等...</p>
		<p style="text-align:center;"><img src="/icmp/images/advance/loading.gif" width="50" height="10" style="margin-top: 20px;"/></p>
		<p class="fonttwo"></p>
	</div>
	</div>
   </form>
  </body>
</html>
