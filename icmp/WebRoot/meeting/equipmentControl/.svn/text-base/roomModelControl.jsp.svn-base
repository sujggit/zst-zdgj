<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>会议模式选择</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function btnqhClick(roomModelId,roomModel){
		var ccip = "${equipmentVO.ip }";
		var roomModelNo = "${roomModelVO.id}";
		//alert(ccip);alert(modelId);alert(videomId);
		//if($(roomModel).hasClass("k2")){
			//$(videomModelImg).removeClass();
		//}else{
			$(".con_2 tr td a").removeClass();
			$(roomModel).attr("class","k2");
			DwrMethod.setRoomModel(ccip,roomModelNo,roomModelId,roomModelBack);
			//$(roomModel).attr("class","k2");
		//}
	}

	function roomModelBack(result){
		if(result!=null){
			//var checkedId = "roomModel"+result;
			//$("#"+checkedId).attr("class","k2");
		}else{
			alert("操作失败");
			$(".con_2 tr td a").removeClass();
		}
	}
	function roomModelName(){
		var a = document.getElementById("roomModelVO").value;
		document.getElementById("pageform").submit();
	}
  </script>
</head>
<body>
	<div id="k6" class="k" style="display:block">
	<form action="${sys_ctx}/equipmentControl/roomModelControlBefore.action" id="pageform" name="pageform" method="post">
	<p class="cd"><span>会议模式选择</span>
		<input type="hidden" id="ccip" value="${equipmentVO.ip }" name="equipmentVO.ip"/>
		<select name="roomModelVO.id" id="roomModelVO" style="margin-top:5px" onchange="roomModelName()">
		 <c:forEach items="${mrlist}" var="roomModel" varStatus="state">
	   		  <option value="${roomModel.id}"  ${roomModelVO.id==roomModel.id ? "selected" : "" } ><c:out value="${roomModel.name}"/></option>
	     </c:forEach>
		</select>
	</p>
	</form>
	  <table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_2" id="con_2">
        <tr>
			<c:forEach items="${roomModelVO.modelList}" var="rmVO" varStatus="status">
				<td align="center">
			  		<a href="#" alt="${rmVO[1]}" title="${rmVO[1]}" id="roomModel${rmVO[0]}" name="roomModel" onclick="btnqhClick(${rmVO[0]},this);">${rmVO[1]}</a>
			  	</td>
			  <c:if test="${status.index>0&&(status.index+1)%5==0&&status.last==false}"> 
          		</tr>
          		<tr>
          	  </c:if>
          	  <c:if test="${status.index>0&&status.last==true}">
          		</tr>
          	  </c:if>
			</c:forEach>
		  </table>
	</div>
</body>
</html>