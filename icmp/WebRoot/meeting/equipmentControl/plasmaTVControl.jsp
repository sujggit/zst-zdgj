<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <%@include file="/common/common.jsp"%>
  <title>等离子控制</title>
  <style type="text/css">
  </style>
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
		if(para == null){
			alert("操作失败！");
			//$("#plasmaNames"+para).val("999999");
		}
	}
	function plasmaop(op){
		//var plasmaVOId = $("#plasmaVOId").val();//电视盒子的设备编号，现在只有一个先不区分
		//alert(plasmaVOId);
		var ccIp = "${equipmentVO.ip }";
		DwrMethod.plaChange(op,ccIp,plaChanBack);
	}
	window.onload=function(){///icmp/WebRoot/meeting/equipmentControl/images/menu.png
		$(".span_ok").css("background-image","url(/icmp/meeting/equipmentControl/images/menu.png)");
		$(".span_ok").bind("mouseover", function(){
			$(".span_ok").css("background-image","url(/icmp/meeting/equipmentControl/images/menu_on.png)");
		});
		$(".span_ok").bind("mouseout", function(){
			$(".span_ok").css("background-image","url(/icmp/meeting/equipmentControl/images/menu.png)");
		});
	};
	fu
  </script>
</head>
<body>
  <div id="k7" class="k" style="display:block">
  	<br />
  	<br />
  	<br />
	<table width="60%" style="display: none;" border="0" cellspacing="0" cellpadding="0" class="con_5">
		<tr>
			<c:forEach items="${plasmaTVVOList}" var="plasmaVO" varStatus="status">
			  <td align="center" style="overflow:hidden">
			 	<input type="hidden" value="${plasmaVO.id}" id="plasmaVOId"/>
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
	<div>
		<table width="80%" border="0" cellspacing="0" cellpadding="0" class="con_2">
	        <tr>
	            <!-- <td align="center"><a href="#" alt="编组开" title="编组开" onclick="javascript:plasmaGroupOperation(this,'on');">编组开</a></td>
	            <td align="center"><a href="#" alt="编组关" title="编组关" onclick="javascript:plasmaGroupOperation(this,'off');">编组关</a></td>
	            <td align="center"><a href="#" alt="全开" title="全开" onclick="javascript:plasmaGroupOperation(this,'on_all');">全开</a></td>
	            <td align="center"><a href="#" alt="全关" title="全关" onclick="javascript:plasmaGroupOperation(this,'off_all');">全关</a></td> -->
	            <td align="center"><a ref="#" onclick="javascript:plasmaop('10');">电源</a></td>
	            <td></td><td></td><td width="100px;"></td>
	        </tr>
	        <tr>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('1');">1</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('2');">2</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('3');">3</a></td>
	            <td>&nbsp;</td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('11');">静音</a></td>
	            <td align="center"></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('12');">————</a></td>
	        </tr>
	        <tr>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('4');">4</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('5');">5</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('6');">6</a></td>
	            <td>&nbsp;</td>
	            <td colspan="3" align="center" style="visibility: hidden;"><a  href="#" onclick="javascript:plasmaop('13');">频道+</a></td>
	        </tr>
	        <tr>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('7');">7</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('8');">8</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('9');">9</a></td>
	            <td>&nbsp;</td>
	            <td align="center" style="visibility: hidden;"><a  href="#" onclick="javascript:plasmaop('14');">音量-</a></td>
	            <td align="center" style="visibility: hidden;"><a  href="#" onclick="javascript:plasmaop('15');">菜单</a></td>
	            <td align="center" style="visibility: hidden;"><a  href="#" onclick="javascript:plasmaop('16');">音量+</a></td>
	        </tr>
	        <tr>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('17');">-/--</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('0');">0</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('18');">回看</a></td>
	            <td>&nbsp;</td>
	            <td colspan="3" align="center" style="visibility: hidden;"><a  href="#" onclick="javascript:plasmaop('19');">频道-</a></td>
	        </tr>
	        <tr>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('20');">RES</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('21');">9画面</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop('22');">Skip</a></td>
	            <td>&nbsp;</td>
	            
	        </tr>
	        <tr>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop(25);">Zz</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop(26);">Scan</a></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop(27);">SYS</a></td>
	            <td>&nbsp;</td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop(23);">Exit</a></td>
	            <td align="center"></td>
	            <td align="center"><a  href="#" onclick="javascript:plasmaop(24);">PIP</a></td>
	        </tr>
		</table>
		<div class="dd_5" style="position: relative;left: 530px;bottom: 240px;">
			<table border="0" cellspacing="0" cellpadding="0" class="con_2" align="center">
				<tr>
					<td> </td>
					<td><span title="频道+" class="span_up" onclick="javascript:plasmaop('13');"></span></td>
					<td> </td>
				</tr>
	            <tr>
	                <td><span title="音量-" class="span_left" onclick="javascript:plasmaop('14');"></span></td>
	                <td><span title="菜单" id="ok" class="span_ok" style="cursor: default" onclick="javascript:plasmaop('15');"></span></td>
	                <td><span title="音量+" class="span_right" onclick="javascript:plasmaop('16');"></span></td>
	            </tr>
	            <tr>
	                <td> </td>
	                <td><span title="频道-" class="span_down" onclick="javascript:plasmaop('19');"></span></td>
	                <td> </td>
	            </tr>
	        </table>
		</div>
	</div>
  </div>
</body>
</html>