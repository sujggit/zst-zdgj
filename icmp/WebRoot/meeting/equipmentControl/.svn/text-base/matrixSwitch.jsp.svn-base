<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>矩阵切换</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/TerminalDwrMethod.js'></script>
<script type="text/javascript">
var input="";
var output=new Array();
function changeBg(id,op){
	if(op=="in"){
		$(".in .k2").removeAttr("class");
		$(".outpt .k2").removeAttr("class");//点击输入时，输出全部清空，为提取对应的输出做准备
		$("#in"+id).attr("class","k2");
		input = id;
		var ccip = "${equipmentVO.ip }";
		var matriID = "${matrixSwitchVO.id}";
		TerminalDwrMethod.matriSwitchOut(ccip,matriID,id,matriSwitchOutBack);
	}else{
		if($("#out"+id).attr("class")=="k2"){
			$("#out"+id).removeAttr("class");
			for(var i=0;i<output.length;i++){
				if(output[i]==id){
					output.splice(i,1);
				}
			}
		}else{
			$("#out"+id).attr("class","k2");
			output.push(id);
		}
	}

}

function matriSwitchOutBack(outvalue){
	//alert(outvalue);
	if(outvalue!= null){
		var outvalues = new Array();
		outvalues = outvalue.split(",");
		for(var i = 0;i<outvalues.length;i++){
			$("#out"+outvalues[i]).attr("class","k2");
		}
	}
}
function matrixName(){
     var ids=document.getElementById("matrixNames").value;
     document.getElementById("pageform").submit();
    
    }
    
function matrixSwitch(){
	if(input == ""){
		alert("请选择输入信号！");
		return;
	}else if(output.length==0){
		alert("请选择输出信号！");
		return;
	}else{
		var ids=document.getElementById("meetingRoomIDs").value;
       var id2s=document.getElementById("matrixNames").value;
       
       var outputValues="";
       for(var i=0;i<output.length;i++){
        outputValues=outputValues+output[i]+"!";
       }
       outputValues = outputValues.substring(0,outputValues.length-1);
    	//alert(input);
    	//alert(outputValues);
      	if(id2s == "6"){//
      		var op_ip = (document.getElementById("meetingRoomID")).value;
      		DwrMethod.changeSourceVlink(op_ip,input,changeSourceVlinkBack);
      	}else{
	   		TerminalDwrMethod.matriSwitchesByIP(ids,id2s,input,outputValues,matriSwitchssback);
      	}
	}
}

function changeSourceVlinkBack(result){
		alert(1);
   		alert(result);
   	}
   	
function matriSwitchssback(result)
    {
	    	if(result==true){
	    	//alert("成功！");
	    	input=""; //必须清空次全局变量，否则下次不选输入也能切换
	    	output=new Array();//必须清空次全局变量，否则下次不选输出也能切换
	    	$("#k2 .dd table tr td a").removeClass("k2");//操作成功矩阵输入输出显示清空
	    	}else{
	    	alert("失败！");
	    	input=""; //必须清空次全局变量，否则下次不选输入也能切换
	    	output=new Array();//必须清空次全局变量，否则下次不选输出也能切换
	    	$("#k2 .dd table tr td a").removeClass("k2");//操作失败矩阵输入输出显示清空
	    	}	
	}
/**
 * matrixSwitchCancel取消矩阵输入输出所有按钮的选择，以便用户重新进行选择
 */
function matrixSwitchCancel(){
	 $("#k2 .dd table tr td a").removeClass("k2")
}

function preBoolTerminalStatusNew(data,id,flag,ids){
	//alert("="+data+"="+id+"="+flag+"=ids:"+ids);//ids为终端设备的id
	document.getElementById("equipmentID").value=ids;
	document.getElementById(ids).disabled="disabled";
	TerminalDwrMethod.booleanTerminalStatus(data,id,ids,flag,resultStatusNew);
}

 function resultStatusNew(status){
 	var terminalStatus=status[2]
  //alert(terminalStatus);
	if(terminalStatus==1){
	 	alert("关机状态，不可控！");
	 	var ids = document.getElementById("equipmentID").value;
	    document.getElementById(ids).disabled="";
	 	return ;
	}else if(terminalStatus==0||terminalStatus==2){
	 	controlTerminal(status[0],status[1],status[3],status[4]);
	}else if(terminalStatus!=0&&terminalStatus!=1&&terminalStatus!==2){
	 	alert("网络故障！");
	 	var ids = document.getElementById("equipmentID").value;
	    document.getElementById(ids).disabled="";
	 	return ;
	}
 }

function controlTerminal(data,id,flag,ids){
	      if(ids==""||ids==null){//ids为终端设备的id
	        alert("请选择终端!");
	        var ids = document.getElementById("equipmentID").value;
	    	document.getElementById(ids).disabled="";
			return;
		}
	     TerminalDwrMethod.controlTerminalById(ids,data,controlTerminalback);
    }
    
    
    function controlTerminalback(result)
    {		
    		
        	if(result!=true){
	    		alert("失败！");
	    		var ids = document.getElementById("equipmentID").value;
	    		document.getElementById(ids).disabled="";
	    	}else{
	    		//alert("双流发送成功");
	    		var ids = document.getElementById("equipmentID").value;
	    		document.getElementById(ids).disabled="";
	    	} 
	} 

</script>
</head>
<body>
<div id="k2" class="k" style="display:block">

	
	<form action="${sys_ctx}/equipmentControl/matrixBefore.action" id="pageform" name="pageform" method="post">
	<p class="cd" style="margin:2px;"><span>矩阵选择</span>
	<input type="hidden" id="meetingRoomIDs" value="${equipmentVO.meetingRoomVO.meetingRoomID}"/>
	<input type="hidden" id="meetingRoomID" value="${equipmentVO.ip }" name="equipmentVO.ip"/>
	<input type="hidden" id="equipmentID" value=""/>
	<select name="matrixSwitchVO.id" id="matrixNames" style="margin-top:5px" onchange="matrixName();">
		<c:forEach items="${matrixSwitchVOList}" var="matrixSwitchVOTemp" varStatus="state">
   		<option value="${matrixSwitchVOTemp.id}" ${matrixSwitchVOTemp.id==matrixSwitchVO.id  ? "selected" : "" } ><c:out value="${matrixSwitchVOTemp.name}"/></option>
        </c:forEach>
	</select>
	<%--<c:forEach items="${tList}" var="tEquipmentVO" varStatus="state">
   		<a id="${tEquipmentVO.equipmentID}" style="float:right;margin-right:1%;" onclick='preBoolTerminalStatusNew("content","content","1","${tEquipmentVO.equipmentID}");'><c:out value="${tEquipmentVO.equipmentNO}双流"/></a>
    </c:forEach>
	--%></p>
	</form>
	
	<div class="dd" style="margin-top:3px;margin-left:1%;width:47%;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center" >
			<tr style="line-height:28px;height:28px;"><td colspan="4">输入</td></tr>
			<tr style="line-height:20px;height:20px;">
                <c:forEach items="${matrixSwitchVO.in}" var="vo"  varStatus="status"> 
                  <td align="center" class="in" style="width:20px;">
                <a  id="in${vo[0]}" title="${vo[1]}"  onclick="changeBg('${vo[0]}','in')" >${vo[1]}</a></td>
                <c:if test="${status.index>0&&(status.index+1)%4==0&&status.last==false}"> 
          		</tr>
          		<tr style="line-height:20px;height:20px;">
          		</c:if>
          		<c:if test="${status.index>0&&status.last==true}">
          			</tr>
          		</c:if>
                </c:forEach>
		</table>
	</div>
	<div class="dd" style="margin-top:3px;margin-left:1%;width:47%;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
            <tr style="line-height:28px;height:28px;"><td colspan="4">输出</td></tr>
            <tr style="line-height:28px;height:28px;">
               
                <c:forEach items="${matrixSwitchVO.out}" var="vo"  varStatus="status"> 
                <td align="center" class="outpt">
                <a  id="out${vo[0]}" title="${vo[1]}" onclick="changeBg('${vo[0]}','out')" >${vo[1]}</a></td>
                <c:if test="${status.index>0&&(status.index+1)%4==0&&status.last==false}"> 
          		</tr>
          		<tr style="line-height:28px;height:28px;">
          		</c:if>
          		<c:if test="${status.index>0&&status.last==true}">
          			</tr>
          		</c:if>
                </c:forEach>
		</table>
	</div>
	<table width="80%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
		<tfoot>
        </tfoot>        
        <tbody>
		<tr>
        	<td>
                <input type="reset" class="submit1 radius2" onclick="matrixSwitch()" value="切 换" />
                <input type="reset" class="reset1 radius2" onclick="matrixSwitchCancel()" value="取 消"/>
            </td>
        </tr>
        </tbody>
	</table>
</div>
</body>
</html>
