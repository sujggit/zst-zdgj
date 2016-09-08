<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>窗帘控制</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function curtainOperation(curtainGr,op){
		var curtainArray = document.getElementsByName("curtain");
		var choosedArray = "";
		for(var i=0;i<curtainArray.length;i++){
			if(op.indexOf("all")!=-1){
				choosedArray = choosedArray + curtainArray[i].id+","
	        }else if(curtainArray[i].className == "k2") {
	            choosedArray = choosedArray + curtainArray[i].id+",";
	        }
		}
		
		var ccIp = "${equipmentVO.ip }";
		//$("table tr td a").removeClass("k2");
		$("#operateTR > td a").removeClass("k2");
		$(curtainGr).addClass("k2");
		//alert(choosedArray);
		DwrMethod.curtainOperation(op,ccIp,choosedArray,curtainBack);
	}
	
	function curtainBack(result){
		if(result == true){
			//alert("操作成功！");
		}else{
			alert("操作失败！");
			$("table tr td a").removeClass();
		}
	}
	
	function btnqhClick(curtainImg){
		if($(curtainImg).hasClass("k2")){
			$(curtainImg).removeClass();
		}else{
			$(curtainImg).attr("class","k2");
		}
	}
  </script>
</head>
<body>
	<div id="k6" class="k" style="display:block">
	<input type="hidden" id="ccip" value="${equipmentVO.ip }" />
	  <table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_2" id="con_2">
        <tr>
			<c:forEach items="${curtainVOList}" var="curtainVO" varStatus="status">
				<td align="center">
			  		<a href="#" alt="窗帘" title="窗帘" id="${curtainVO.id}" name="curtain" onclick="btnqhClick(this);">${curtainVO.name}</a>
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
    	<table width="80%" border="0" cellspacing="0" cellpadding="0" class="con_2" style="margin-top:80px">
      	  <tr id="operateTR">
      	  	<td align="center"><a href="#" alt="编组开" title="编组开" onclick="javascript:curtainOperation(this,'on');">编组开</a></td>
            <td align="center"><a href="#" alt="编组关" title="编组关" onclick="javascript:curtainOperation(this,'off');">编组关</a></td>
            <td align="center"><a href="#" alt="全开" title="全开" onclick="javascript:curtainOperation(this,'on_all');">全开</a></td>
            <td align="center"><a href="#" alt="全关" title="全关" onclick="javascript:curtainOperation(this,'off_all');">全关</a></td>
      	</tr>
      </table>
	</div>
</body>
</html>