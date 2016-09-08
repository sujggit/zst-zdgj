<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>等离子控制</title>
  <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
  <script type="text/javascript">
	function plasmaGroupOperation(plasmaGr,op){
		var plasmaArray = document.getElementsByName("plasma");
		var choosedArray = "";
		for(var i=0;i<plasmaArray.length;i++){
	    	if(op.indexOf("all")!=-1){
				choosedArray = choosedArray + plasmaArray[i].id+",";
	        }else if (plasmaArray[i].className == "k5") {
	            choosedArray = choosedArray + plasmaArray[i].id+",";
	        }
		}
		var ccIp = "${equipmentVO.ip }";
		//$("table tr td a").removeClass("k2");
		$("#operateTR > td a").removeClass("k2");
		$(plasmaGr).addClass("k2");
		//alert(choosedArray);
		DwrMethod.plasmaGroupOperation(op,ccIp,choosedArray,plasmaBack);
	}
	
	function plasmaBack(result){
		if(result == true){
			//alert("操作成功！");
		}else{
			alert("操作失败！");
			$("table tr td a").removeClass();
		}
	}

	function btnqhClick(plasmaImg){
		if($(plasmaImg).hasClass("k5")){
			$(plasmaImg).removeClass();
		}else{
			$(plasmaImg).attr("class","k5");
		}
	}

	/**等离子频道切换
	*/
	function plasmaName(plasma_id){
		var ccIp = "${equipmentVO.ip }"
		var plasma_no = $("#plasmaNames"+plasma_id).val();
		//alert(ccIp);
		//alert(plasma_id);
		//alert(plasma_no);
		if(plasma_no != "999999"){
			DwrMethod.plaChannel(ccIp,plasma_id,plasma_no,plaChanBack);
		}
	}
	 function plaChanBack(para){
		if(para != null){
			alert("操作失败！");
			$("#plasmaNames"+para).val("999999");
		}
	}
  </script>
</head>
<body>
  <div id="k7" class="k" style="display:block">
	<table width="60%" border="0" cellspacing="0" cellpadding="0" class="con_5">
		<tr>
			<c:forEach items="${plasmaTVVOList}" var="plasmaVO" varStatus="status">
			  <td align="center" style="overflow:hidden">
			  	<a href="#" alt="等离子" title="${plasmaVO.name}" id="${plasmaVO.id}" name="plasma" onclick="btnqhClick(this);">${plasmaVO.name}</a>
			  	<%--<select name="plasmaVO.id" id="plasmaNames${plasmaVO.id}" style="margin-top:5px" onchange="plasmaName(${plasmaVO.id})" title="点击实时切换当前等离子频道">
				 <option value="999999">请选择频道...</option>
				 <c:forEach items="${plasmaVO.channelList}" var="vo" varStatus="state">
			   		  <option value="${vo[0]}"  ${plasmaVO.channel==vo[0] ? "selected" : "" } ><c:out value="${vo[1]}"/></option>
			     </c:forEach>
				</select>
			  	--%></td>
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
            <td align="center"><a href="#" alt="编组开" title="编组开" onclick="javascript:plasmaGroupOperation(this,'on');">编组开</a></td>
            <td align="center"><a href="#" alt="编组关" title="编组关" onclick="javascript:plasmaGroupOperation(this,'off');">编组关</a></td>
            <td align="center"><a href="#" alt="全开" title="全开" onclick="javascript:plasmaGroupOperation(this,'on_all');">全开</a></td>
            <td align="center"><a href="#" alt="全关" title="全关" onclick="javascript:plasmaGroupOperation(this,'off_all');">全关</a></td>
        </tr>
	</table>
  </div>
</body>
</html>