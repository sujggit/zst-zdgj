<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/common/common_header.jsp"%>
<title>定时开关</title>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<script type="text/javascript">
	function controlMethod(param,num,ccIP){
		var spanID = "onspan"+num;
		var hourID = "onhour"+num;
		var miID = "onmi"+num;
		
		if(param.value=="0"){
			$("#"+spanID).show();
			DwrMethod.fixedTimeControl("on","on",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){

			});
		}
		
		if(param.value=="1"){
			$("#"+spanID).hide();
			DwrMethod.fixedTimeControl("on","off",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){
				
			});
		}
	}

	function saveTime(num,ccIP){
		var hourID = "onhour"+num;
		var miID = "onmi"+num;
		 
		DwrMethod.fixedTimeControl("on","on",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){
			
		});
	}
	function offControlMethod(param,num,ccIP){
		var spanID = "offspan"+num;
		var hourID = "offhour"+num;
		var miID = "offmi"+num;
		
		if(param.value=="0"){
			$("#"+spanID).show();
			DwrMethod.fixedTimeControl("off","on",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){

			});
		}
		
		if(param.value=="1"){
			$("#"+spanID).hide();
			DwrMethod.fixedTimeControl("off","off",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){
				
			});
		}
	}

	function offSaveTime(num,ccIP){
		var hourID = "offhour"+num;
		var miID = "offmi"+num;
		 
		DwrMethod.fixedTimeControl("off","on",ccIP,$("#"+hourID).val(),$("#"+miID).val(),function(){
			
		});
	}
	
	function exportFixedTime(){
		document.getElementById('pageform').action="${sys_ctx}/equipmentControl/exportQuery.action";
		document.getElementById('pageform').submit();
		document.getElementById('pageform').action="${sys_ctx}/equipmentControl/fixedTimeBefore.action";
	}
	
</script>

</head>

<body style='OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN' >
<form action="${sys_ctx}/equipmentControl/fixedTimeBefore.action" id="pageform" name="pageform" method="post">
	<div id="container">
	<div class="content">
  	<div class="contenttitle fontstyle ">
  		<div class="fl"><img src="${sys_page_list_table }" width="20" height="25" /></div>
  		<div class="fl fontb">&nbsp;定时开关设备</div>
  		<div class="fr">
  			<input name="" type="button" class="searbutton fontstyle fontb" value="导 出"  onclick="exportFixedTime();"/>
	    </div>
  	</div>
	<div class="tablesdiv">
        <table width="100%" border="0" id="query_table" cellspacing="0" cellpadding="0" class="listsearch">
          <thead>
          <tr valign="top">
          	<th width="65px" class="titlehome ac fontstyle">序号</th>
            <th width="" class="titlehome ac fontstyle" >会场名称</th>
            <th width="" class="titlehome ac fontstyle" >定时开机</th>
            <th width="" class="titlehome ac fontstyle" >定时关机</th>
          </tr>
          </thead>
          <tbody>
	         <c:forEach items="${equipmentList}" var="equipmentVO" 	varStatus="state">
				<tr>
				<td class="ac fontstyle "><c:out value="${state.index+1}"></c:out></td>
				<td class="ac fontstyle "><c:out value="${equipmentVO.meetingRoomVO.meetingRoomName}"></c:out></td>
				<td class="ac fontstyle ">
				    <input type="radio" value="0" id="groupNameon${state.index}" name="groupName${state.index}" onclick="controlMethod(this,'${state.index}','${equipmentVO.ip }');" />启用
				    
				    <span id="onspan${state.index}" style="display:none">
				    <select id="onhour${state.index}" onchange="saveTime('${state.index}','${equipmentVO.ip }');">
				    <option value="1">1点</option>
				    <option value="2">2点</option>
				    <option value="3">3点</option>
				    <option value="4">4点</option>
				    <option value="5">5点</option>
				    <option value="6">6点</option>
				    <option value="7">7点</option>
				    <option value="8">8点</option>
				    <option value="9">9点</option>
				    <option value="10">10点</option>
				    <option value="11">11点</option>
				    <option value="12">12点</option>
				    <option value="13">13点</option>
				    <option value="14">14点</option>
				    <option value="15">15点</option>
				    <option value="16">16点</option>
				    <option value="17">17点</option>
				    <option value="18">18点</option>
				    <option value="19">19点</option>
				    <option value="20">20点</option>
				    <option value="21">21点</option>
				    <option value="22">22点</option>
				    <option value="23">23点</option>
				    <option value="24">24点</option>
				    </select>
				    <select id="onmi${state.index}"  onchange="saveTime('${state.index}','${equipmentVO.ip }');">
				    <option value="10">10分</option>
				    <option value="20">20分</option>
				    <option value="30">30分</option>
				    <option value="40">40分</option>
				    <option value="50">50分</option>
				    </select>
				    </span>
				    <input type="radio" value="1" checked name="groupName${state.index}" onclick="controlMethod(this,'${state.index}','${equipmentVO.ip }');"/>禁用
				    <c:if test="${equipmentVO.status==1}">
						<script type="text/javascript">var indeNum = "${state.index}";$("#onspan"+indeNum).show();$("#groupNameon"+indeNum).attr("checked","checked"); </script>
				    </c:if>
				</td>
				<td class="ac fontstyle ">
				    <input type="radio" value="0"  id="groupNameoff${state.index }" name="groupOff${state.index}" onclick="offControlMethod(this,'${state.index}','${equipmentVO.ip }');"/>启用
				    
				    <span id="offspan${state.index}" style="display:none">
				    <select id="offhour${state.index}" onchange="offSaveTime('${state.index}','${equipmentVO.ip }');">
				    <option value="1">1点</option>
				    <option value="2">2点</option>
				    <option value="3">3点</option>
				    <option value="4">4点</option>
				    <option value="5">5点</option>
				    <option value="6">6点</option>
				    <option value="7">7点</option>
				    <option value="8">8点</option>
				    <option value="9">9点</option>
				    <option value="10">10点</option>
				    <option value="11">11点</option>
				    <option value="12">12点</option>
				    <option value="13">13点</option>
				    <option value="14">14点</option>
				    <option value="15">15点</option>
				    <option value="16">16点</option>
				    <option value="17">17点</option>
				    <option value="18">18点</option>
				    <option value="19">19点</option>
				    <option value="20">20点</option>
				    <option value="21">21点</option>
				    <option value="22">22点</option>
				    <option value="23">23点</option>
				    <option value="24">24点</option>
				    </select>
				    <select id="offmi${state.index}"  onchange="offSaveTime('${state.index}','${equipmentVO.ip }');">
				    <option value="10">10分</option>
				    <option value="20">20分</option>
				    <option value="30">30分</option>
				    <option value="40">40分</option>
				    <option value="50">50分</option>
				    </select>
				    </span>
				    <input type="radio" value="1" checked name="groupOff${state.index}" onclick="offControlMethod(this,'${state.index}','${equipmentVO.ip }');"/>禁用
				     <c:if test="${equipmentVO.port==1}">
						<script type="text/javascript">var indeNum = "${state.index}";$("#offspan"+indeNum).show();$("#groupNameoff"+indeNum).attr("checked","checked"); </script>
				    </c:if>
				</td>				
				</tr>
				</c:forEach>
          </tbody>
          </table>
            </div>
    	<jsp:include page="/common/pageFooter.jsp"/>
		</div>
     </div>
   
     <div/>
     <div/>
     </form>
</body>
</html>