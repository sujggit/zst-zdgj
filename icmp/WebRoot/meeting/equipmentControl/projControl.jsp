<%@ page language="java"  pageEncoding="UTF-8"%>
<%@include file="/common/common_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>投影机控制</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>

<script type="text/javascript">
	function projOperation(op){
		var projArray = document.getElementsByName("proj");
		var choosedArray = "";
		for(var i=0;i<projArray.length;i++){
			if(op.indexOf("all")!=-1){
				choosedArray = choosedArray + projArray[i].id+","
	        }else if(projArray[i].className == "glay fontstyle fontb") {
	            choosedArray = choosedArray + projArray[i].id+",";
	        }
		}
		
		var ccIp = (window.document.getElementById("ccIp")).value;
		//alert(choosedArray);
		DwrMethod.projControlBefore(op,ccIp,choosedArray,function (result){});
	}
	
	function chengeCC(){
		var select = window.document.getElementById("ccIp");
		var ips=select.value;
		parent.setOperateMeetingRoom(ips);
		window.location.href="${sys_ctx}/equipmentControl/projControlBefore.action?equipmentVO.ip=" +ips;
		//document.getElementById("pageform").submit();
	}
	
	function loadMeetingRoom(){
		var operatMeetingRoom = parent.getOperateMeetingRoom();
		var select = window.document.getElementById("ccIp");
		
		if(select.value != operatMeetingRoom && operatMeetingRoom!=""){
			select.value = operatMeetingRoom;
			chengeCC();
		}
	}
	
	function btnqhClick(){
    	el=event.srcElement
    	if (el.tagName=="INPUT"&&el.type=="button") {
        	if (el.className == "srbtn fontstyle fontb") {
            		el.className = "glay fontstyle fontb";
        	}        
        	else {
            	el.className = "srbtn fontstyle fontb";
        	}
    	}
	}
  
</script>

</head>
<body onload="loadMeetingRoom();">
  <div id="container">
  <div class="content">
    <div class="contenttitle fontstyle fontb">
      <div class="fl"><img src="${sys_style_url }/titleicon.gif" width="20" height="25" /></div>
      <div class="fl">&nbsp;投影机控制</div></div>
      <div class="dgkz_fw">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="al fontstyle pr3 dgkzlayout">
          <form action="${sys_ctx}/equipmentControl/getLightControl.action" id="pageform" name="pageform" method="post">
          	<select name="equipmentVO.ip" id="ccIp" class="select200 fontstyle" onchange="chengeCC();" >
              <c:forEach items="${equipmentList}" var="equipmentsVO" varStatus="statue">
   				<option value="${equipmentsVO.ip}"  ${equipmentsVO.ip==equipmentVO.ip  ? "selected" : "" }  ><c:out value="${equipmentsVO.meetingRoomVO.meetingRoomName}"/></option>
   			  </c:forEach>
            </select>
          </form>
          </td>
        </tr>
      </table>
	  <table width="98%" border="0" cellspacing="0" cellpadding="0" class="jztable" align="center">
        <tr>
          <td class="jztd ac">
			<c:forEach items="${projVOList}" var="projVO" varStatus="status">
			  <input type="button" class="srbtn fontstyle fontb" value="${projVO.name}" id="${projVO.id}"
			  		 name="proj" onclick="btnqhClick();" />
			  <c:if test="${status.index>0&&(status.index+1)%4==0&&status.last==false}"> 
          		</td></tr>
          		<tr><td class="jztd ac">
          	  </c:if>
          	  <c:if test="${status.index>0&&status.last==true}">
          		</td></tr>
          	  </c:if>
			</c:forEach>
		   </table>
		   <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
      	  <tr>
        	<td class="btntable">
        	  <input type="button" class="yzw_btn2 font12wb"  value="编组开" onclick="projOperation('on');"/>
        	  <input type="button" class="yzw_btn2 font12wb"  value="编组关" onclick="projOperation('off');"/>
        	  <input type="button" class="yzw_btn2 font12wb"  value="全开" onclick="projOperation('on_all');"/>
        	  <input type="button" class="yzw_btn2 font12wb"  value="全关" onclick="projOperation('off_all');"/>
       		</td>
      	</tr>
      </table>
    	</div>
    </div>
  </div>
</body>
</html>