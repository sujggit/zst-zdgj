<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>灯光控制</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function lightGroupOperation(lightGr,op){
		var lightArray = document.getElementsByName("light");
		var choosedArray = "";
		for(var i=0;i<lightArray.length;i++){
			if(op.indexOf("all")!=-1){
				choosedArray = choosedArray + lightArray[i].id+","
	        }else if(lightArray[i].className == "k1") {
	            choosedArray = choosedArray + lightArray[i].id+",";
	        }
		}
		var ccIp = "${equipmentVO.ip }";
		$("#operateTR > td a").removeClass("k2");
		//$("table tr td a").removeClass("k2");
		$(lightGr).addClass("k2");
		DwrMethod.lightGroupOperation(op,ccIp,choosedArray,lightBack);
	}
	
	function lightBack(result){
		if(result == true){
			//alert("操作成功！");
		}else{
			alert("操作失败！");
			$("table tr td a").removeClass();
		}
	}
	
	function btnqhClick(lightImg){
		if($(lightImg).hasClass("k1")){
			$(lightImg).removeClass();
		}else{
			$(lightImg).attr("class","k1");
		}
	}
  </script>
</head>
<body>
  <div id="k5" class="k" style="display:block">
	<table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_4">
		<tr>
			<c:forEach items="${lightVOList}" var="lightVO" varStatus="status">
				 <td align="center">
				 	<a href="#" alt="灯光" title="灯光" id="${lightVO.id}" name="light" onclick="btnqhClick(this);">${lightVO.name}</a>
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
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="con_2">
        <tr id='operateTR'>
            <td align="center"><a href="#" alt="编组开" title="编组开" onclick="javascript:lightGroupOperation(this,'on');">编组开</a></td>
            <td align="center"><a href="#" alt="编组关" title="编组关" onclick="javascript:lightGroupOperation(this,'off');">编组关</a></td>
            <td align="center"><a href="#" alt="全开" title="全开" onclick="javascript:lightGroupOperation(this,'on_all');">全开</a></td>
            <td align="center"><a href="#" alt="全关" title="全关" onclick="javascript:lightGroupOperation(this,'off_all');">全关</a></td>
        </tr>
	</table>
  </div>
</body>
</html>