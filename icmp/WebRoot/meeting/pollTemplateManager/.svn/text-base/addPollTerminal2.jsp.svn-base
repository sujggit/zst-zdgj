<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    
    <title>会场轮询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'></script>
	
	<script type="text/javascript">
		 function init(){
			$("#terList").sortable();
		}
		
		function addTer(){

			var temName = document.getElementById("pollTemplateName").value;

			if( temName == "" ){
				alert("模板名称不能为空");
				return;
			}
			
			var terArr = new Array();
			
			$("#terList li").each(function(i){
			   terArr.push($(this).find("input").val());
			});
			
			if(terArr.length<=0 ){
				alert("没有选择任何终端");
				return;
			}
			McuDwrMethod.addPollTerminal(temName,terArr,callback);
		}
		
		function callback(){
			window.returnValue="1";
			window.close();
		}
		
		function delTerminal(id){
			$("#"+id).remove();
		}

		function getSelectConf(){
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			var confList1 = document.getElementById("confList1").value;
			var confList2 = document.getElementById("confList2").value;
			window.location.href='${sys_ctx }/mcuControl/getSelectConfList.action?meetingDetailID=' + meetingDetailID+'&confList1='+confList1+'&confList2='+confList2;
		}

		function serachRoom(){
			var searchRoom = document.getElementById("searchMeeingRoom1").value;//搜索条件

			if( searchRoom == ""){
					return;
				}
			var terlist1 = $("#terList li");

			for( var i=0; i<terlist1.length; i++){
				terlist1[i].style.color = "black";
			}

			for( var i=0; i<terlist1.length; i++){
				if( terlist1[i].innerText.indexOf(searchRoom)!= -1 ){//匹配到节点
					terlist1[i].style.color = "red";
				}
			}



			
			
			
	 	}

		function EnterPress(e){ //传入 event 
	    	   var e = e || window.event; 
	    	   if(e.keyCode == 13){ 
	    		   serachRoom();
	    	   } 
	       } 

		
		
	</script>
	
	<style>
		.bSelectNode{
			padding-top: 0px;
			background-color: #FFE6B0;
			color: black;
			border: 1px #FFB951 solid;
			opacity: 0.8;
		}	
		
		.glass {
			border: 2px solid #CCC;
			padding: 0px 0px 0px 4px;
			width: 120px;
		}
	</style>
  </head>
  
  <body onload="init()" style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN;'>
  <div class="min-widthdiv" style="height: 98%">
	<div id="basicform" class="contentwrapper" style="padding: 3px 3px;">
	 <div class="contenttitle2">
	 	<h5 class="fwb fl10">
			<span style="color: red;">*</span>轮询模板名称 <input name="pollTemplateVO.pollTemplateName" id="pollTemplateName" />
		</h5>
			&nbsp;&nbsp;&nbsp;&nbsp;搜索 :<input id="searchMeeingRoom1"  type="text" class="glass" value="" onkeypress="EnterPress(event)"   title="按回车搜索"/><img src="/icmp/images/icons/glass.png"/ onclick="serachRoom();" style="cursor:pointer;">
	 </div>
   <div id="screenContainer" style="width:100%;height:600px;">
   
   <div id="screen1" style="width:100%;height:590px;overflow:auto;">
   <ul id="terList">
   	<c:forEach items="${equipmentList}" var="ter" varStatus="k">
   	<li id="ter${k.count }" style="cursor:pointer" >
   	${ter.equipmentNO}
   	<input type="hidden" value="${ter.equipmentID}"/>
   	</li>
   	</c:forEach>
   	</ul>
   </div>
   
   </div>
   <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
            <tfoot>
            </tfoot>
            <tbody>
              <tr>
                <td><input type="button" class="submit1 radius2" value="确定" onclick="addTer()"/>
               </td>
              </tr>
            </tbody>
  </table>
</div>
</div>
  </body>
</html>
