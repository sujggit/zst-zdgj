<%@ page language="java" pageEncoding="UTF-8"%>
<script>
    function direction(op) {  
 		var id = getSelectedCCIP();
 	    var ids=document.getElementById("cameraNames").value;
 	    //alert(op);
		DwrMethod.directionKey(id, ids, op, opback);
	}

	function opback(para) {
		if (para!= "") {
			alert("失败");
		}
	}
	
	
	function speed(op) {
	    var id = getSelectedCCIP();
	    var ids=document.getElementById("cameraNames").value;
		DwrMethod.speed(id,ids,op,sback);
	}
	function sback(para) {
        if (para!= "") {
			alert("失败");
		}
	}
	
	
	function speed(op) {
	    var id = getSelectedCCIP();
	    var ids=document.getElementById("cameraNames").value;
		DwrMethod.speed(id,ids,op,sback);
	}
	function sback(para) {
        if (para!= "") {
			alert("失败");
		}
	}
	
	function cameraName(){
     var ids=document.getElementById("cameraNames").value;
     document.getElementById("pageform").submit();
     //alert(ids);
    }
    
    function btnchClick(){
    el=event.srcElement
    if (el.tagName=="INPUT"&&el.type=="button") {
        if (el.className == "yzw_btn font18wb") {
            var inputArray = document.getElementsByName("inputName");
            if(inputArray != null && inputArray.length > 0){
				for(var i=0; i<inputArray.length; i++){
					inputArray[i].className = "yzw_btn font18wb";
				}
            }
            el.className = "yzw_btnchoose font18wb";
        }        
        else {
            el.className = "yzw_btn font18wb";
        }
    }
}

 function cameraRecalls(op){
   var ids = getSelectedCCIP();
   var idss=document.getElementById("cameraNames").value;
   var inputArray = document.getElementsByName("inputName");
   var ops;
   for(var i=0;i<inputArray.length;i++){
	   if (inputArray[i].className == "yzw_btnchoose font18wb") {
	       ops=inputArray[i].id;
	   }
   }
   DwrMethod.cameraRecalls( op,ids,idss,ops,callsback);
 }
 
 function callsback(result)
    {
	    	if(result!=true){
	    	 alert("失败！");
	    	 }
	}
	
	
function zoomss(op){
   var id = getSelectedCCIP();
   //alert("id:"+id)
   var ids=document.getElementById("cameraNames").value;
   //alert("ids::"+ids);
   DwrMethod.zooms(op,id,ids,zoomsback);
 }
 function zoomsback(result)
    {
	    	if(result!=true){
	    	 alert("失败！");
	    	 }
	}
	
	//自动跟踪
	function cameraOperation(operation){
		el=event.srcElement;
		
		var autoButtons = document.getElementsByName("autoButton");
		for(var i=0;i<autoButtons.length;i++){
			autoButtons[i].className = "yzw_btn font12wb";
		}
		el.className = "yzw_btnchoose font12wb";
		
		var ip = getSelectedCCIP();
		var id = document.getElementById("cameraNames").value;
		DwrMethod.cameraOperation(operation,ip,id,operationBack);
	}
	function operationBack(result){
		if(result!=true){
	    	 alert("失败！");
	    }else alert("成功！");
	}
	
</script>

	<div id="container">
  	  <div class="content">
    	<div class="contenttitle fontstyle fontb">
  		  <div class="fl"><img src="${sys_style_url }/titleicon.gif" width="20" height="25" /></div>
  		  <div class="fl">&nbsp;摄像头控制</div>
		</div>
	  <form action="${sys_ctx}/equipmentControl/cameraBefore.action" id="pageform" name="pageform" method="post">
		<div class="tablesdiv">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="tables">
            <tr class="tdhight">
              <td class="cd">请选择视频终端：</td>
              <td class="al pl3">
          	  <select name="equipmentVO.ip" id="ccIp" class="select200 fontstyle" onchange="chengeCC();" >
                <c:forEach items="${equipmentList}" var="equipmentsVO" varStatus="statue">
   				  <option value="${equipmentsVO.ip}"  ${equipmentsVO.ip==equipmentVO.ip  ? "selected" : "" }  ><c:out value="${equipmentsVO.meetingRoomVO.meetingRoomName}"/></option>
   				</c:forEach>
              </select></td>
            </tr>
      	  </table>
		  <table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
        	<tr>
          	  <td width="365" align="center"></td>
              <td width="435" align="center"></td>
        	</tr>
        	<tr>
          	  <td height="25" align="center">
          		<div class="spzddiv2"><table width="250" border="0" cellspacing="1" cellpadding="1">
              	  <tr>
                	<td height="20">&nbsp;</td>
                  </tr>
              	  <tr>
                	<td><table width="242" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                      	<td width="48">&nbsp;</td>
                      	<td width="146"><img src="${sys_style_url }/zd/spzd_kzt.png" style="cursor:pointer" width="146" height="43"  onmouseup="direction('stop')" onmousedown="direction('up')"/></td>
                      	<td width="48">&nbsp;</td>
                      </tr>
                      <tr>
                      	<td><img src="${sys_style_url }/zd/spzd_kzl.png" style="cursor:pointer" width="48" height="147" onmouseup="direction('stop')" onmousedown="direction('left')" /></td>
                      	<td><img src="${sys_style_url }/zd/spzd_enter.png" width="146" height="147" /></td>
                      	<td><img src="${sys_style_url }/zd/spzd_kzr.png" style="cursor:pointer" width="49" height="147" onmouseup="direction('stop')" onmousedown="direction('right')" /></td>
                      </tr>
                      <tr>
                      	<td>&nbsp;</td>
                      	<td><img src="${sys_style_url }/zd/spzd_kzb.png" style="cursor:pointer" width="145" height="43" onmouseup="direction('stop')" onmousedown="direction('down')" /></td>
                      	<td>&nbsp;</td>
                      </tr>
                  	</table></td>
              	</tr>
              	<tr>
                  <td height="20">&nbsp;</td>
              	</tr>
              </table></div></td>
          	<td><table width="400" border="0" cellspacing="0" cellpadding="0" class="ac">
              <tr>
              	<td width="30%">
              	  <span class="al pl3">
                	<select name="cameraVO.id" id="cameraNames" onchange="cameraName();" class="select200 fontstyle">
                  	  <c:forEach items="${cameraList}" var="camera" varStatus="state">
   		                <option value="${camera.id}"  ${cameraVO.id==camera.id ? "selected" : "" } ><c:out value="${camera.name}"/></option>
               		  </c:forEach>
                	</select>
              	  </span>
              	</td>
              	<td width="30%">&nbsp;</td>
              	<td width="30%"> 
               	  <ul>
                	<li class=" spbtn sxtkz_ks font12wb" style="cursor:pointer" onclick="speed('3')">快速</li>
               	  </ul>
                </td>
              </tr>
              <tr>
              	<td>
              	  <span class="jztd ac">
                	<input id="autoStart" name="autoButton" type="button" class="yzw_btn font12wb" onclick="cameraOperation('start')" value="自动跟踪开"/>
              	  </span>
              	  <span class="jztd ac">
              		<input id="autoClose" name="autoButton" type="button" class="yzw_btn font12wb" onclick="cameraOperation('close')" value="自动跟踪关"/>
              	  </span>
              	  <script type="text/javascript">
        			if(getSelectedCCIP() != "10.6.22.250"){
        				var autoStartButton =  document.getElementById("autoStart");
        				var autoCloseButton =  document.getElementById("autoClose");
        				autoStartButton.style.display = "none";
        				autoCloseButton.style.display = "none";
        			}
        		</script>
             	</td>
              	<td>
              	</td>
              	<td>
               	  <ul>
                	<li class=" spbtn sxtkz_zs font12wb" style="cursor:pointer" onclick="speed('2')">中速</li>
               	  </ul>
              	</td>
              </tr>
              <tr>
              	<td>
              	  <table>
              	  	<tr>
                	  <td><input name="input" type="button" class="sxtkzbj_sm"  value="" onmousedown="zoomss('add')" onmouseup="direction('stop')" /></td>
                	  <td><input name="input" type="button" class="sxtkz_bj font12wb"  value="变焦"/></td>
                	  <td><input name="input" type="button" class="sxtkzbj_bg"  value="" onmousedown="zoomss('subtract')" onmouseup="direction('stop')" /></td>
                	</tr>
              	  </table>  
              	</td>
              	<td>&nbsp;</td>
              	<td>
               	  <ul>
                	<li class=" spbtn sxtkz_ms font12wb" style="cursor:pointer" onclick="speed('1')">慢速</li>
               	  </ul>
              	</td>
              </tr>
            </table></td>
          </tr>
          <tr>
          </tr>
      	</table>
		</div>
		<table width="99%" border="0" cellspacing="0" cellpadding="0" class="jztable2" align="center">
        <tr>
          <td class="jztitle2 pl3 fontstyle fontb">预置位</td>
        </tr>
        <tr>
          <td class="jztd ac">
          	<c:forEach items="${cameraVO.storeAll}" var="vo"  varStatus="status">
          	  <input type="button"  class="yzw_btn font18wb"  value="${vo[1]}" onclick="btnchClick()" name="inputName"  id="${vo[0]}"/>
          	  <c:if test="${status.index>0&&(status.index+1)%5==0&&status.last==false}">
          	  	</td></tr>
          	  	<tr><td class="jztd ac">
          	  </c:if>
          	  <c:if test="${status.index>0&&status.last==true}">
          		</td></tr>
          	  </c:if>
          	</c:forEach>
      	</table>
	  </form>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="buttoncontainer">
	  <tfoot>
        </tfoot>        
        <tbody>
      	<tr>
          <td class="btntable ac">  
          <input type="button" value="调 用" class="button fontstyle fontb" onclick="cameraRecalls('recalls')"/>
          <input type="button" value="存 储" class="button fontstyle fontb" onclick="cameraRecalls('store')"/></td>
      	</tr>
      	</tbody>
      </table>
	</div>
  </div>