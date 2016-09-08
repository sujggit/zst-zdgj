<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>画面分割器</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function btnqhClick(modelId,videomModelImg){
		var videomId=document.getElementById("videomNames").value;
		var ccip = "${equipmentVO.ip }";
		//alert(ccip);alert(modelId);alert(videomId);
		//if($(videomModelImg).hasClass("k2")){
			//$(videomModelImg).removeClass();
		//}else{
			$(".con_2 tr td a").removeClass();
			DwrMethod.videomModel(ccip,videomId,modelId,videomModelBack);
			$(videomModelImg).attr("class","k2");
		//}
	}

	function videomModelBack(result){
		if(result!=null){
			//alert("操作成功");
		}else{
			alert("操作失败");
			$(".con_2 tr td a").removeClass();
		}
	}
	
	function videomName(){
	     var ids=document.getElementById("videomNames").value;
	     document.getElementById("pageform").submit();
	}
  </script>
</head>
<body>
	<div id="k2" class="k" style="display:block">
		<form action="${sys_ctx}/equipmentControl/getVideom.action" id="pageform" name="pageform" method="post">
		<p class="cd"><span>画面分割器选择</span>
		<input type="hidden" id="meetingRoomIDs" value="${equipmentVO.meetingRoomVO.meetingRoomID}"/>
		<input type="hidden" id="meetingRoomID" value="${equipmentVO.ip }" name="equipmentVO.ip"/>
		<select name="videomVO.id" id="videomNames" style="margin-top:5px" onchange="videomName();">
			<c:forEach items="${videomVOList}" var="videomVOListTemp" varStatus="state">
	   		<option value="${videomVOListTemp.id}" ${videomVOListTemp.id==videomVO.id  ? "selected" : "" } ><c:out value="${videomVOListTemp.name}"/></option>
	        </c:forEach>
		</select>
		</p>
		</form>
	  <div id="k6" class="k" style="display:block">
	    <table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_2" id="con_2">
          <tr>
			<c:forEach items="${videomVO.modelList}" var="vv" varStatus="status">
				<td align="center">
			  		<a href="#" alt="画面分割器" title="画面分割器" id="videomModel${vv[0]}" name="videom" onclick="btnqhClick(${vv[0]},this);">${vv[1]}</a>
			  	</td>
			  <c:if test="${status.index>0&&(status.index+1)%4==0&&status.last==false}"> 
          		</tr>
          		<tr><td>
          	  </c:if>
          	  <c:if test="${status.index>0&&status.last==true}">
          		</td></tr>
          	  </c:if>
			</c:forEach>
		 </table>
	  </div>
	</div>
</body>
</html>