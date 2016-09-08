<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%@include file="/common/common.jsp"%>
<title>立即召开</title>
<script type='text/javascript' src='${sys_ctx }/js/json2.js'> </script>
<script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'></script>
<style>
</style>
	<script type="text/javascript">
		function bookConference(){
			
			var name = $("#meetingName").val();
			var roomId = $("#mainRoomID").val();
			var equipId = $("#mainEquipmentID").val();
			if(name==null||name==""||roomId==null||roomId==""||equipId==null||equipId==""){
				alert("必选参数\r会议名称、会场及主会场");
				return;
			}
			
			var zTree = $.fn.zTree.getZTreeObj("rightTree");
			if(zTree!=null){
				var nodes = zTree.getNodesByParam("level", 0, null);
				if(nodes==null||nodes.length !=1){
					alert("选择主MCU");return;
				}else if(nodes[0].nodeType!=nodeType_mcu){
					alert("必须使用MCU组会");return;
				}
			}
			
			//提取mcu模板数据到node内
			var nodes = zTree.getNodesByParam("nodeType", nodeType_mcu, null);
			if(nodes!=null){
				var mainMCUNode = nodes[0];
				//记录会议模式
				var selectValue = $("#diyBtn_right_mcu"+mainMCUNode.id).val();
				if(selectValue==null||selectValue.length==0){
					alert("会议模式不能为空");				
					return;
				}
				//会议模式
				$("#confProfileID").val(selectValue);
				
				//主mcu的模板
				DwrMethod.getMcuModelOptionByMeetingModel(selectValue,function(rs){
					if(rs!=null&&rs.length>0){
						var modelStr = rs.split("##");
						if(modelStr==null||modelStr.length!=2) return;
						var mcuIPS		=	modelStr[0];
						var mcuModelIDs	=	modelStr[1];
						if(mcuIPS==null||mcuIPS.length==0||mcuModelIDs==null||mcuModelIDs.length==0) return;
						
						var modelID = getSelectModelID(mcuIPS,mcuModelIDs,mainMCUNode.ip,mainMCUNode.name);
						if(modelID==null){
							mainMCUNode.confProfileID="-";
							alert("没有匹配上对应的模板");
						}else
							mainMCUNode.confProfileID=modelID;
					}
				});

				//从mcu的模板
				for(var i=1;i<nodes.length;i++){
					var node = nodes[i];
					//记录会议模式
					var selectValue = $("#diyBtn_right_mcu"+node.id).val();
					
					//从MCU模板改变时。node的tId,seID是select的ID
					if(selectValue!=null)
						node.confProfileID = selectValue;
					else
						node.confProfileID = "-";
				}
			}
			
			var nodes = zTree.transformToArray(zTree.getNodes());
			var aToStr=JSON.stringify(nodes);
			
			$("#jsonData").attr("value",aToStr.substr(1,(aToStr.length-1)));
			
			var startTime = $("#meetingStartTime").val();
			startTime = startTime.replace(/-/g,"/");//替换字符，变成标准格式
			var startDate = new Date(Date.parse(startTime));
			var date = new Date();
			if(date>startDate){
				if(!window.confirm("立即召开会议")) return;
			}else{
				if(!window.confirm("预约会议")) return;
			}
			 
			$("#form").submit();
		}
		
		//json转字符串
		var O2String = function (O) {
			var S = [];
	       var J = "";
	       if (Object.prototype.toString.apply(O) === '[object Array]') {
	           for (var i = 0; i < O.length; i++)
	               S.push(O2String(O[i]));
	           J = '[' + S.join(',') + ']';
	       }
	       else if (Object.prototype.toString.apply(O) === '[object Date]') {
	           J = "new Date(" + O.getTime() + ")";
	       }
	       else if (Object.prototype.toString.apply(O) === '[object RegExp]' || Object.prototype.toString.apply(O) === '[object Function]') {
	           J = O.toString();
	       }
	       else if (Object.prototype.toString.apply(O) === '[object Object]') {
	           for (var i in O) {
	               O[i] = typeof (O[i]) == 'string' ? '"' + O[i] + '"' : (typeof (O[i]) === 'object' ? O2String(O[i]) : O[i]);
	               S.push(i + ':' + O[i]);
	           }
	           J = '{' + S.join(',') + '}';
	       }
	
	       return J;
		};
		
		function maxMeetingTime(){
			var startTime = $("#meetingStartTime").val();
			startTime = startTime.replace("-","/");//替换字符，变成标准格式
			var startDate = new Date(Date.parse(startTime));
			var endTime = $("#info2").val()*60*60*1000;
			var meetingTime =startDate.getTime()+endTime; 
			return new Date(meetingTime);
		}
		
		function clearMeetingTime(){
			$("#realityStartTime").val("");
			$("#selectVenueSpan").empty();
			$("#selectVenueSpan").append(0);
			getUseEquipment();
			clearMainRoom();
		}
		
		//根据时间查询使用的设备信息
		function getUseEquipment(){
			var startTime = $("#meetingStartTime").val();
			startTime = startTime.replace("-","/");//替换字符，变成标准格式
			var startDate = new Date(Date.parse(startTime)).getTime();
			var endTime = startDate+$("#info2").val()*60*60*1000;
			DwrMethod.getUseEquipmentByTime(startDate+"",endTime+"",function(lis){
				useEquipmentUStatus(lis);
			});
			
			//折叠所有节点
			var zTree = $.fn.zTree.getZTreeObj("leftTree");
			zTree.expandAll(false);
			
			var rightzTree = $.fn.zTree.getZTreeObj("rightTree");
			var nodes = rightzTree.getNodesByParam("level", 0, null);
			for (var i=0, l=nodes.length; i < l; i++) {
				rightzTree.removeNode(nodes[i],true);
			}
		}
		
		
	</script>
</head>
<body onload="getUseEquipment();">
<form action="/icmp/adminConference/conferenceBook.action" method="post" name="form" id="form">
	<input id="confProfileID" type="hidden" size="100"name="meetingDetailVO.confProfileID"/>
	<input id="jsonData" type="hidden" name="meetingDetailVO.meetingDescription"/>
    <div id="basicform" class="contentwrapper">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
  			<tr>
  				<td width="15%" class="tableaddtitle"><span>*</span>会议名称</td>
          		<td class="tableadd_data" colspan="3"><input maxlength="25" id="meetingName" name="meetingDetailVO.meetingName" type="text" class="inputtran" value="${meetingDetailVO.meetingName }"/></td>
        		<%--<td colspan="2" class="tableadd_data"><input type="radio" name="radio"/>立即召开&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="radio"/>预约</td>--%>
        	</tr>
  			<tr>
  				<td width="15%" class="tableaddtitle">开始时间</td>
          		<td width="40%" class="tableadd_data"  >
	          		<input name="meetingDetailVO.meetingStartTime" class="Wdate" id="meetingStartTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'%y-%M-%d %H:%m',onpicked:clearMeetingTime});" value="<fmt:formatDate value="${meetingDetailVO.meetingStartTime }"  pattern="yyyy-MM-dd HH:mm"/>"/>
					&nbsp;&nbsp;&nbsp;时长:
					<select class=""  name="meetingDetailVO.info2" id="info2" onchange="clearMeetingTime()">
				    	<zzst:option type="meetingtime" value="" />
	    			</select>
          		</td>
          		<c:if test="${meetingStartTimeMark }"><!-- 会议提前期的控制 -->
	          		<td width="15%" class="tableaddtitle">会议时间</td>
	          		<td width="35%" class="tableadd_data" >
		            	<input name="meetingDetailVO.realityStartTime" class="Wdate" id="realityStartTime" type="text" style="cursor:pointer" readonly="readonly" onfocus="var datema=maxMeetingTime();WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'meetingStartTime\')}',maxDate:datema});" value="<fmt:formatDate value="${meetingDetailVO.realityStartTime }"  pattern="yyyy-MM-dd HH:mm"/>"/>        
	          		</td>
          		</c:if>
        	</tr>
      	</table>
		<%@include file="./conferenceRoom.jsp"%>			
      	
      	<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
        	<tbody>
          		<tr>
            		<td >
            			<input type="checkbox" id="" name="meetingDetailVO.info5"/>存为模板
            			<input type="button" id="subbtn" class="submit1 radius2" value="确 定" onclick="bookConference();"/>
                    	<input type="button" class="reset1 radius2" value="取 消" onclick=" javascript:history.go(-1)"/>
            		</td>
          		</tr>
        	</tbody>
      	</table>
	</div>
</form>
</body>
</html>