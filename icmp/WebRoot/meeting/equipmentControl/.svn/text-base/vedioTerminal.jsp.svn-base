<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>视频终端</title>
<link rel="stylesheet" type="text/css" href="${sys_ctx}/meeting/equipmentControl/css/cc.css"/>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/TerminalDwrMethod.js'></script>
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.slider-min.js"></script>
<script type="text/javascript" language="javascript" src="${sys_ctx }/plug-in/jquery-slider/jquery.dependClass.js"></script>
<script type="text/javascript"> 

/*add by tanzanlong
  date:2013-3-15
*/

function getTerminal(){
	var id=document.getElementById("equipmentId").value;
	window.location.href="${sys_ctx}/equipmentControl/videoEndPointBefore.action?equipmentVO.equipmentID="+id;
	preBoolStatus();
}

function keyboard(){
var id=document.getElementById("equipmentId").value; 
TerminalDwrMethod.booleanStatus(id,function (status){
if(status==0){
window.showModalDialog('http://${equipmentVO.ip }/a_remotecontrol.htm','example03','dialogWidth=260px;dialogHeight=627px;scrollbars=no');
}else{
alert('设备不在线或网络异常');
}
});

}

function getStatus(){
  //preBoolStatus();
  //setInterval('preBoolStatus();',3*1000);
}

function preBoolStatus(){
	var id=document.getElementById("equipmentId").value; 
	TerminalDwrMethod.booleanStatus(id,result);
}

function result(bool){
	if(bool==0){//在线
		document.getElementById("off").innerHTML="";
		document.getElementById("on").innerHTML="<img src='${sys_ctx }/meeting/equipmentControl/images/free.png'/>";
	}else if(bool==2){//会议中
		document.getElementById("off").innerHTML="";
		document.getElementById("on").innerHTML="<img src='${sys_ctx }/meeting/equipmentControl/images/meeting.png'/>";
	}else if(bool==1){//ip不通
		document.getElementById("on").innerHTML="";
		document.getElementById("off").innerHTML="<img src='${sys_ctx }/meeting/equipmentControl/images/shutdown.png'/>";
	}else {//异常
		document.getElementById("on").innerHTML="";
		document.getElementById("off").innerHTML="<img src='${sys_ctx }/meeting/equipmentControl/images/runing.gif'/>";
	}
}

function terminalControl(mark){
	var id=document.getElementById("equipmentId").value; 
	var numList=document.getElementById("contentShow").value;
	TerminalDwrMethod.terminalControl(id,mark,numList,function(){
	
	});
}



function preBoolTerminalStatus(data,id,flag){
	var ids=document.getElementById("equipmentId").value; 
	//alert("="+data+"="+id+"="+flag+"=ids:"+ids);
	//TerminalDwrMethod.booleanTerminalStatus(data,id,ids,flag,resultStatus);
	if(data == "delete"){
     	var operateValue = document.getElementById("contentShow");
     	var beforeValue = operateValue.value;
     	var afterValue = beforeValue.substring(0,beforeValue.length-1);
     	operateValue.value = afterValue;
     	//TerminalDwrMethod.booleanTerminalStatus(data,id,ids,flag,function(){});
     	TerminalDwrMethod.controlTerminalById(ids,data,controlTerminalback);
     }else{
    	 TerminalDwrMethod.booleanTerminalStatus(data,id,ids,flag,resultStatus);
     }
}

 function resultStatus(status){
 	var terminalStatus=status[2]
  //alert(terminalStatus);
	if(terminalStatus==1){
	 	alert("关机状态，不可控！");
	 	return ;
	 }else if(terminalStatus==0||terminalStatus==2){
	 	controlTerminal(status[0],status[1],status[3]);
	 }else if(terminalStatus!=0&&terminalStatus!=1&&terminalStatus!==2){
	 	alert("网络故障！");
	 	return ;
	 }
 }
 
	// oldContents = "";
	var chooseKey = "";
	function contentShow(input){
		var inputContents = document.getElementById("contentShow");
		var oldContents = inputContents.value;
		var newContents = oldContents+input;
		inputContents.value = newContents;
	}
	
	
    function controlTerminal(data,id,flag){
	    var ids=document.getElementById("equipmentId").value; //获得终端id
	    //获得终端的状态；
	   if(flag==1){
	     $(".b_1").removeAttr("class");
	     $("#"+id).attr("class","b_1");
	    }
	   
	     if(data == "dot"){
	     	chooseKey = ".";
	     }
	     if(data == "delete"){
	     	var operateValue = document.getElementById("contentShow");
	     	var beforeValue = operateValue.value;
	     	var afterValue = beforeValue.substring(0,beforeValue.length-1);
	     	operateValue.value = afterValue;
	     }
	     
	      if(ids==""||ids==null){
	       // alert(ids);
	        alert("请选择终端!");
			return;
		}
	     TerminalDwrMethod.controlTerminalById(ids,data,controlTerminalback);
	     contentShow(chooseKey);
    }
    
    
    function controlTerminalback(result)
    {		
    		
        	if(result!=true){
	    		alert("失败！");
	    	}else if(chooseKey == "."){
	    		//contentShow(chooseKey);
	    	} 
	}      
	
	
	
	function preBoolNumkeyStatus(nums){
 		var ids=document.getElementById("equipmentId").value; 
		TerminalDwrMethod.booleanNumkeyStatus(nums,ids,resultNumkeyStatus);
	}

	 function resultNumkeyStatus(status){
		 var terminalStatus=status[1];
		 
		  
		if(terminalStatus==1){
		 	alert("关机状态，不可控！");
		 	return ;
		 }else if(terminalStatus==0||terminalStatus==2){
			 numKey(status[0]);
		 } else {
		 	alert("网络故障！");
			return ;
		}
	 }
	
	                                                                                                                                                           
 
	//数字键
	function numKey(num){
	 	 chooseKey = num;
      	var ids=document.getElementById("equipmentId").value;
      	if(ids==""||ids==null){
       // alert(ids);
        	alert("请选择终端!");
			return;
		}
    	TerminalDwrMethod.numKeys(ids,num,numKeyback);
    	contentShow(chooseKey);
    }
    
    function numKeyback(result)
    {		//alert(chooseKey);
   		if(result!=true){
            alert("失败！");
            //document.getElementById("contentShow").value = oldContents;
        }else{
        	//contentShow(chooseKey);
        }		
	}	
	
	
	
	function preBoolDirectekeyStatus(nums,id){
 		var ids=document.getElementById("equipmentId").value; 
		TerminalDwrMethod.booleanDirectekeyStatus(nums,id,ids,resultDirectekeyStatus);
	}

 function resultDirectekeyStatus(status){
 	var terminalStatus=status[2];
	if(terminalStatus==1){
	 	alert("关机状态，不可控！");
	 	return ;
	 }else if(terminalStatus==0||terminalStatus==2){
	 	directionKey(status[0],status[1]);
	 } else {
	 	alert("网络故障！");
	 	return ;
	 }
 }
	
	
	//方向键
	function directionKey(nums,id){
		//$(".b_1").removeAttr("class");
		
		for(var i=1;i<6;i++){
		$(".span_"+i).removeAttr("id");
		$(".span_"+i).attr("id","");
		}
		$("."+id).attr("id",id);
		
		
		// alert(nums);
	     var ids=document.getElementById("equipmentId").value;
	     
	      if(ids==""||ids==null){
	        alert("请选择终端!");
			return;
			}
	      
	    if($("#camera").attr("class") == "b_1"){
	    	TerminalDwrMethod.directionKeyCamera(ids,nums,directionKeyback);
	    }else{
	    	TerminalDwrMethod.directionKey(ids,nums,directionKeyback);
	    }
    }
    function directionKeyback(result)
    {
    	 if(result!=true){
	         alert("失败！");
	        }		
	}
	
	//方向键鼠标移开onclick='preBoolDirectekeyStatus("up","span_1")'
	function undirectionKey(){
	
	}
	
	function removeDirStyle(id,num){
	$("#"+num).removeAttr("id");
	$("."+num).attr("id",id);
	
	 var ids=document.getElementById("equipmentId").value;
	if($("#camera").attr("class") == "b_1"){
    	TerminalDwrMethod.directionKeyCameraStop(ids,function(){
    		
    	});
    }
	
	}
	
	function removeNearFar(type){
		var ids=document.getElementById("equipmentId").value;
		TerminalDwrMethod.directionKeyCameraStop(ids,function(){
    		
    	});
	}
	
	//add by yangyi
	//function change(){
		//var ip = document.getElementById("equipmentId").value;	
		//alert("111:"+ip);
		//window.location.href="${sys_ctx}/equipmentControl/videoEndPointBefore.action?equipmentVO.equipmentID="+ip;
	   
	//}
    
    
</script>
</head>
<body class="withvernav" onload="getStatus()">

	<div class="terminal">
	<div class="contenttitle2" style="margin-top: 0px;">
        <h5 class="fwb fl10">视频终端:${equipmentVO.equipmentNO }(${equipmentVO.ip })&nbsp;&nbsp;
      		<input type="hidden" id="equipmentId" value="${equipmentVO.equipmentID }"/>
        </h5>
      </div>
	<table width="100%" style="display: none;">
     <tr><td align="left" width="50%">
		<p class="cd"><span>请选择视频终端</span>
		<select name="select" id="equipmentId" onchange="getTerminal()" style="margin-top:5px">
              <c:forEach items="${equipmentList}" var="equipmentVOs" varStatus="state">
   	        	<option value="${equipmentVOs.equipmentID}" ${equipmentVOs.equipmentID==equipmentVO.equipmentID  ? "selected" : "" } ><c:out value="${equipmentVOs.equipmentNO}（${equipmentVOs.ip}）"/></option>
   			  </c:forEach>
            </select>
            </p>
            </td>
         <td align="right" width="10%">可控状态：</td>
         <td align="left" width="40%"><div id="off" align="left"></div> <div align="left" id="on" style="margin-top:5px"></div></td>
		</tr></table>
		  
		<table width="60%" border="0" cellspacing="0" cellpadding="0" align="center">
            <tr>
                <td style="text-align:center">
                    <table width="200" height="260" border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr>
                            <td colspan="3" class="cd_1" id="" name="buttonnear"  onmouseup="removeNearFar('buttonnear')" onmousedown="preBoolTerminalStatus('buttonnear','buttonnear','0')">缩小</td>
                        </tr>
                        <tr>
                            <%--<td class="cd_1" id="keyboard1" name="keyboard1" onclick='keyboard();'>遥控器</td> --%>
                            <td></td>
                           <td>
                                <div class="dd_5">
                                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
                                        <tr>
                                            <td><br /></td>
                                            <td class="span_1" id="up"  onmouseup="removeDirStyle('up','span_1')" onmousedown="preBoolDirectekeyStatus('up','span_1')"><br/></td>
                                            <td><br /></td>
                                        </tr>
                                        <tr>
                                            <td class="span_2" id="lefts"  onmouseup="removeDirStyle('lefts','span_2')" onmousedown="preBoolDirectekeyStatus('lefts','span_2')" ><br /></td>
                                            <td class="span_3" id="centers"  onmouseup="removeDirStyle('centers','span_3')" onmousedown="preBoolDirectekeyStatus('centers','span_3')"><br /></td>
                                            <td class="span_4"  id="rights"   onmouseup="removeDirStyle('rights','span_4')" onmousedown="preBoolDirectekeyStatus('rights','span_4')"><br /></td>
                                        </tr>
                                        <tr>
                                            <td><br /></td>
                                            <td class="span_5" id="down"  onmouseup="removeDirStyle('down','span_5')" onmousedown="preBoolDirectekeyStatus('down','span_5')"><br /></td>
                                            <td><br/></td>
                                        </tr>
                                    </table>
                                </div>
                            <br /></td>
                            <td></td>
                             
                            </tr>
                            
                            <tr>
                              <td colspan="3" id="buttonfar" class="cd_1" name="buttonfar"    onmouseup="removeNearFar('buttonfar')" onmousedown="preBoolTerminalStatus('buttonfar','buttonfar','0')" >放大</td>
                         </tr>
                        </table>
                    </td>
                    <td style="text-align:center">
                        <div class="dd_2" style="width:193px">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
                                <tr>
                                    <td align="center"><input type="text"  id="contentShow"  style="border:none;margin:0;padding:0"/></td>
                                </tr>  
                            </table>
                        </div>
                        <div class="dd_3" style="width:203px">
                            <table width="100%" border="1" cellspacing="0" cellpadding="0" class="con_2" align="center" style="">
                                <tr>
                                    <td align="center" onclick='preBoolNumkeyStatus("1")'>1</td><td align="center" onclick='preBoolNumkeyStatus("2")'>2</td><td align="center" onclick='preBoolNumkeyStatus("3")'>3</td>
                                </tr>
                                <tr>
                                    <td align="center" onclick='preBoolNumkeyStatus("4")'>4</td><td align="center" onclick='preBoolNumkeyStatus("5")'>5</td><td align="center" onclick='preBoolNumkeyStatus("6")'>6</td>
                                </tr>
                                <tr>
                                    <td align="center" onclick='preBoolNumkeyStatus("7")'>7</td><td align="center" onclick='preBoolNumkeyStatus("8")'>8</td><td align="center" onclick='preBoolNumkeyStatus("9")'>9</td>
                                </tr>
                                <tr>
                                    <td align="center" onclick='preBoolNumkeyStatus("*")'>*</></td>
                                    <td align="center" onclick='preBoolNumkeyStatus("0")'>0</td>
                                    <td align="center" onclick='preBoolNumkeyStatus("#")'>#</td>
                                </tr>
                                
                                 <tr>
                                    <td align="center"><img src="${sys_style1}/images/answer.png" onclick='terminalControl("dialing");'/></td>
                                    <td align="center" onclick='controlTerminal("dot","dot","0");'>.</td>
                                    <td align="center"><img src="${sys_style1}/images/hangup.png"  onclick='terminalControl("hangup");'/></td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
			</table>    	
			<div class="con_3">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
					<%--<tr>
						<td><span  onclick='preBoolTerminalStatus("painted","pinp","1");'  id="pinp">画中画</span></td>
						<td><span onclick='preBoolTerminalStatus("cameras","camera","1");' id="camera">摄像机</span></td>
						<td><span onclick='preBoolTerminalStatus("content","content","1");' id="content">内容</span></td>
                        <td  colspan="2"><span onclick='preBoolTerminalStatus("messages","messages","1");'id="messages">信息</span></td>
					</tr>
                    <tr>
						<td><span  onclick='preBoolTerminalStatus("home","main","1");' id="main">主页</span></td>
						<td><span onclick='preBoolTerminalStatus("back","back","1");' id="back">返回</span></td>
						<td><span onclick='preBoolTerminalStatus("mute","novoice","1");' id="novoice">静音</span></td>
						<td  colspan="2"><span onclick='preBoolTerminalStatus("delete","d","1");'id="d">删除</span></td>
					</tr>
					
					--%>
					<tr>
						<td><span  onclick='preBoolTerminalStatus("home","main","1");' id="main">主页</span></td>
						<td><span onclick='preBoolTerminalStatus("cameras","camera","1");' id="camera">摄像机</span></td>
						<td><span onclick='preBoolTerminalStatus("mute","novoice","1");' id="novoice">静音</span></td>
					</tr>
                    <tr>
						<td><span onclick='preBoolTerminalStatus("back","back","1");' id="back">返回</span></td>
						<td  colspan="2"><span onclick='preBoolTerminalStatus("delete","d","1");'id="d">删除</span></td>
					</tr>
				</table>                  
			</div> 
            
        
    </div>
    
</body>
</html>
