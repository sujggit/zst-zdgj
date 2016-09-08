<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>投影仪控制</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function projectorGroupOperation(projectorGr,op){
		var projectorArray = document.getElementsByName("projector");
		var choosedArray = "";
		for(var i=0;i<projectorArray.length;i++){
			if(op.indexOf("all")!=-1){
				choosedArray = choosedArray + projectorArray[i].id+","
			}else if(projectorArray[i].className == "a_3") {
	            choosedArray = choosedArray + projectorArray[i].id+",";
	        }
		}
		var ccIp = "${equipmentVO.ip }";
		$("#operateTR > td a").removeClass("k2");
		//$("table tr td a").removeClass("k2");
		$(projectorGr).addClass("k2");
		//alert(choosedArray);
		DwrMethod.projectorGroupOperation(op,ccIp,choosedArray,liftBack);
	}
	
	function liftBack(result){
		if(result == true){
			//alert("操作成功！");
		}else{
			alert("操作失败！");
			$("table tr td a").removeClass();
		}
	}

	function btnqhClick(projectorImg){
		if($(projectorImg).hasClass("a_3")){
			$(projectorImg).removeClass();
		}else{
			$(projectorImg).attr("class","a_3");
		}
	}
	function projector(op){
		/* if(op=="on"){
			$("#down #stop #up #off").removeClass();
		}else if(op=="off"){
			$("#down #stop #up #on").removeClass();
		} */
		var ccIp = "${equipmentVO.ip }";
		/* $("#"+op).addClass("k2"); */
		DwrMethod.modifyProjector(op,ccIp,liftBack);
	}
	window.onload=function (){
		//projector
		$('a[name=projector]')
		.css("background","url('/icmp/meeting/equipmentControl/images/projector.png') no-repeat ")
		.css("background-position","50% 100%")
		.html("");
	};
  </script>
</head>
<body>
	<div id="k1" class="k" style="display:block">
		<table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_tyy">
			<tr>
				<c:forEach items="${projectorVOList}" var="projectorVO" varStatus="status" >
					<td align="center" style="overflow:hidden">
						<a href="#" alt="投影仪" title="${projectorVO.name}" id="${projectorVO.id}" name="projector" onclick="btnqhClick(this);">${projectorVO.name}</a>
					</td>
	          	  <c:if test="${status.index>0&&(status.index+1)%4==0&&status.last==false}">
	          	  	</tr>
	          	  	<tr>
	          	  </c:if>
	          	   <c:if test="${status.index>0&&status.last==true}">
	          		</tr>
	          	  </c:if>
				</c:forEach>
		</table>
		<table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_2">
			<tr id='operateTR'>
				<td align="center"><a href="#" alt="开投影机" title="开投影机" onclick="javascript:projector('on');" id="on">开投影机</a></td>
				<td align="center"><a href="#" alt="升" title="升" onclick="javascript:projector('up');" id="up">升</a></td>
			</tr>
			<tr>
				<td align="center"><a href="#" alt="关投影机" title="关投影机" onclick="javascript:projector('off');" id="off">关投影机</a></td>
				<td align="center"><a href="#" alt="停" title="停" onclick="javascript:projector('stop');" id="stop">停</a></td>
			</tr>
			<tr>
				<td></td>
				<td align="center"><a href="#" alt="降" title="降" onclick="javascript:projector('down');" id="down">降</a></td>
			</tr>
		</table>
	</div>
</body>
</html>