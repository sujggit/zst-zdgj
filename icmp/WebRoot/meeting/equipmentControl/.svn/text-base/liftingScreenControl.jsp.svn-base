<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>升降屏控制</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function liftingGroupOperation(liftingGr,op){
		var liftingArray = document.getElementsByName("lifting");
		var choosedArray = "";
		for(var i=0;i<liftingArray.length;i++){
			if(op.indexOf("all")!=-1){
				choosedArray = choosedArray + liftingArray[i].id+","
			}else if(liftingArray[i].className == "k2") {
	            choosedArray = choosedArray + liftingArray[i].id+",";
	        }
		}
		var ccIp = "${equipmentVO.ip }";
		//$("table tr td a").removeClass("k2");
		$("#operateTR > td a").removeClass("k2");
		$(liftingGr).addClass("k2");
		//alert(choosedArray);
		DwrMethod.liftingGroupOperation(op,ccIp,choosedArray,liftBack);
	}
	
	function liftBack(result){
		if(result == true){
			//alert("操作成功！");
		}else{
			$("table tr td a").removeClass();
			alert("操作失败！");
		}
	}

	function btnqhClick(liftingImg){
		if($(liftingImg).hasClass("k2")){
			$(liftingImg).removeClass();
		}else{
			$(liftingImg).attr("class","k2");
		}
	}
  </script>
</head>
<body>
	<div id="k6" class="k" style="display:block">
	<input type="hidden" id="ccip" value="${equipmentVO.ip }" />
	<table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_2" id="con_2">
		<tr>
			<c:forEach items="${liftingScreenVOList}" var="upDownScreenVO" varStatus="status" >
			  <td align="center">
			  		<a href="#" alt="升降屏" title="升降屏" id="${upDownScreenVO.id}" name="lifting" onclick="btnqhClick(this);">${upDownScreenVO.name}</a>
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
	<table width="80%" border="0" cellspacing="0" cellpadding="0" class="con_2" style="margin-top:80px">
		<tr id="operateTR">
            <td align="center"><a href="#" alt="编组升" title="编组升" onclick="javascript:liftingGroupOperation(this,'on');">编组升</a></td>
            <td align="center"><a href="#" alt="编组降" title="编组降" onclick="javascript:liftingGroupOperation(this,'off');">编组降</a></td>
            <td align="center"><a href="#" alt="全升" title="全升" onclick="javascript:liftingGroupOperation(this,'on_all');">全升</a></td>
            <td align="center"><a href="#" alt="全降" title="全降" onclick="javascript:liftingGroupOperation(this,'off_all');">全降</a></td>
        </tr>
	</table>
</div>
</body>
</html>