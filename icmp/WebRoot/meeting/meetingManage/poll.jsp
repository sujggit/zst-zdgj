<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    
    <title>会议分配</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		function init(){
			//$("#confList").sortable();
			//$("#confList1").sortable();
			//$(".screen").each(function(index,dom){alert($(this).html());});
			$("#confList li").draggable({ revert:'invalid',addClasses: false });
			
			$("#screen2").droppable({
				drop:function(event,ui){
				//alert(ui.draggable.html());
					ui.draggable.attr("style","cursor:pointer");
					ui.draggable.clone().appendTo('#confList1');
					ui.draggable.remove();
					$("#confList1 li").draggable({ revert:'invalid',addClasses: false });
				}
			});
			$("#screen1").droppable({
				drop:function(event,ui){
				//alert(ui.draggable.html());
					ui.draggable.attr("style","cursor:pointer");
					ui.draggable.clone().appendTo('#confList');
					ui.draggable.remove();
					$("#confList li").draggable({ revert:'invalid',addClasses: false });
				}
			});
		}
		
		function nextStep(){
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			var confList1 = ""
			$("#confList li").each(function(i){
			if(confList1!=""){
				confList1 += "_";
			}
			confList1 += $(this).find("input").val();
			});
			var confList2 = "";
			$("#confList1 li").each(function(i){
			if(confList2!=""){
				confList2 += "_";
			}
			confList2 += $(this).find("input").val();
			});
			if(confList1==""||confList2==""){
				alert("分配不能为空");
				return;
			}
			
			window.location.href='${sys_ctx }/mcuControl/getPollList.action?meetingDetailID=' + meetingDetailID+'&confList1='+confList1+'&confList2='+confList2;
		}

		function delConf(id){
			$("#"+id).remove();
		}
	</script>
  </head>
  
  <body onload="init()" style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
 <div class="min-widthdiv">
	<div id="basicform" class="contentwrapper" style="padding: 3px 3px;">
	 <div class="contenttitle2">
			<h5 class="fwb fl10">会议分配</h5>
	 </div>
	  <input id="meetingDetailID" type="hidden" value="${meetingDetailID }"/>
	  <input id="confListValue1" type="hidden" value=""/>
	  <input id="confListValue2" type="hidden" value=""/>
	   <div id="screenContainer" style="width:100%;height:600px;">
	   <div id="screen1" style="width:100%;height:300px;border:1px solid black;overflow:auto;" class="screen">
	   <ul id="confList">
	    <c:if test="${confVOList != null }" >
	    		<c:forEach items="${confVOList}" var="conf" varStatus="k">
	   					<li id="conf${k.count }" style="cursor:pointer">${conf.confName }<input type="hidden" value="${conf.confID }"/>
	   					 <button class="stdbtn"   onclick="delConf('conf${k.count}')">删除</button>
	   					</li>
	   					
	   	        </c:forEach>
	    </c:if>
	    <c:if test="${conferenceList1 != null}">
	    	<c:forEach items="${conferenceList1}" var="conf" varStatus="k">
	   					<li id="conf${k.count }" style="cursor:pointer" >${conf.confName }<input type="hidden" value="${conf.confID }"/>
	   					<button class="stdbtn"   onclick="delConf('conf${k.count}')">删除</button>
	   					</li>
	   	    </c:forEach>
	    </c:if>
	   
	   	</ul>
	   </div>
	   <div id="screen2" style="width:100%;height:300px;border:1px solid black;border-top:0px;overflow:auto;" class="screen">
	   <ul id="confList1">
	   	<c:if test="${conferenceList2 != null}">
	    	<c:forEach items="${conferenceList2}" var="conf" varStatus="k">
	   					<li id="conf${k.count }" style="cursor:pointer">${conf.confName }<input type="hidden" value="${conf.confID }"/>
	   					<button class="stdbtn"   onclick="delConf('conf${k.count}')">删除</button>
	   					</li>
	   	    </c:forEach>
	    </c:if>
	   	</ul>
	   </div>
	   </div>
	   <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td><input type="button" class="submit1 radius2" value="下一步" onclick="nextStep()"/>
                 </td>
              </tr>
            </tbody>
		</table>
   </div>
</div>
  </body>
</html>
