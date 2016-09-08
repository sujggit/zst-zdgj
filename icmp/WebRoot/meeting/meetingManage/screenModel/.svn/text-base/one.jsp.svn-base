<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@include file="/common/common_header.jsp" %>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/mcuControlMethod.js'></script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<link rel="stylesheet" type="text/css"  href="screenModel.css">
<script type="text/javascript">
	function changeOption(num){
		document.getElementById("selectNum").value=num;
		var monitor = "${monitor}";
		var screenCount = "${screenCount}";
		var vals = new Array();
		var options = new Array();
		
		for(var i=0;i<=screenCount-1;i++){
			var m = i+1;
			vals[i]=document.getElementById("select"+m).value;
			options[i] = new Array();
			var option = document.getElementById("select"+m).options;
			for(var nn=0;nn<option.length;nn++){
				options[i][nn]=option[nn].value;
			}
		}
		document.getElementById("selectVal").value=vals;
		DwrMethod.changeOptions(screenCount,vals,num,monitor,options,changeCallback);
	}
	function changeCallback(data){

		var num = document.getElementById("selectNum").value;
		var selectVal = new Array();
		selectVal = document.getElementById("selectVal").value.split(",");
		
		var infoArray = new Array();
		for(var i=0;i<data.length;i++){
		if(i!=num){
		var k = i+1;
		dwr.util.removeAllOptions("select"+k);
		for(var j=0;j<data[i].length;j++){
			if(data[i][j]!=null){
				
				infoArray = data[i][j].split("_");
					dwr.util.addOptions("select"+k,[{ name:infoArray[4], id:data[i][j] }],'id','name');
					
			}
			var sOption	= document.getElementById("select"+k).options;
			for(var t=0;t<sOption.length;t++){
				if(selectVal[i]==sOption[t].value){
					sOption[t].selected='selected';
					break;
				}
			}
			}
			
		}
		}
		
	}
	function setPersonal(){
  		var monitor = "${monitor}";
  		var screenCount = "${screenCount}";
  		var infos = new Array();
  		for(var i=0;i<=screenCount-1;i++){
  			var j = i+1;
  			infos[i]=document.getElementById("select"+j).value;	
  		}
  		
  		mcuControlMethod.setPersonal(infos,monitor,"personal");
  	}
  	function closeWin(){
  		parent.close();
  	}
</script>
</head>
<body>
<div class="screenD" style="height:330px">
	<table class="content" style="border:1px solid black; background:#F5F5F5;">
	
		<tr>
		<c:forEach var="sn" begin="1" end="${screenCount }" step="1">
		<td style="border:1px solid">
			<select id="select${sn }"  onchange="changeOption('${sn-1 }')">
			
				<c:forEach var="meetingroom" items="${meetingRoomList }">
				<option value="${meetingroom.mcu_participant_id }_${meetingroom.mcuMeetingID}_${meetingroom.confFlagId}_${meetingroom.mcuIp}_${meetingroom.mcu_participant_name }">${meetingroom.mcu_participant_name }</option>
				</c:forEach>
			</select>
		</td>
		<c:if test="${sn%2==0&&screenCount==4&&sn!=4 }"></tr><tr></c:if>
		<c:if test="${sn%4==0&&screenCount==16&&sn!=16 }"></tr><tr></c:if>
		</c:forEach></tr>
		
	</table>
	<input type="hidden" value="" id="selectNum"/>
	<input type="hidden" value="" id="selectVal"/>
	<div class="k_bottom" style="float:right;margin-right:10px"><input type="reset" class="submit1 radius2" value="确定" onclick="setPersonal()" style="margin-right:10px"/>
	<input type="reset" class="reset1 radius2" value="取消" onclick="closeWin()" />
	</div>
</div>

</body>
</html>
