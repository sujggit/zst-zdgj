<%@ page language="java"  pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.LevelEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<%@include file="/common/common.jsp" %>
		<title>会议室分级配置修改页面</title>
	</head>
  <body style='OVERFLOW:AUTO;OVERFLOW-X:HIDDEN'>
  	<form action="${sys_ctx }/level/roomLevelModify.action?" method="post" name="form" id="form">
	    <div id="basicform" class="contentwrapper">
	      <input type="hidden" id="power" value="${power }"/>
	      <input id="levelType" name="levelConfigVO.levelType" type="hidden" value="<%=LevelEnum.LEVEL_ROOM %>"/>
	      <input id="level_pId" name="level_pId" type="hidden" value="<%=request.getAttribute("level_pId")%>"/>
	      <div class="contenttitle2">
	        <h5 class="fwb fl10">会议室分级配置修改</h5>
	      </div>
	      <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
	        <tr>
			  <td class="tableaddtitle"><span>*</span>分级名称</td>
			  <td class="tableadd_data" >
			  	<input id="levelID" name="levelConfigVO.levelID" type="hidden" value="${levelVO.levelID}"/>
			  	<input id="levelName" name="levelName" class="inputtran" value="${levelVO.levelName}" disabled="disabled"/>
			  </td>
			</tr>
			<tr>
				<td class="tableaddtitle"><span>*</span>会议室名称</td>
				<td class="tableadd_data" >
					<input id="meetingRoomNameIDs" name="levelConfigVO.levelKey" type="hidden" value="${levelVO.levelKeyIds1 }"/>
					<textarea id="meetingRoomNames" name="roomName" class="inputtran" onclick="selectConference(this)" readonly="readonly" title="${levelVO.levelKeyNames1}" style="cursor:pointer;width:100%"><c:out  value="${levelVO.levelKeyNames1}"></c:out></textarea>
					<input id="description" name="levelConfigVO.description" type="hidden"/>
				</td>
			</tr>
	       </table>
		  <table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
		        <tfoot>
		        </tfoot>
		        <tbody>
		          <tr>
		            <td>
		            	<input class="submit1 radius2 submitBtn_Disa" type="button" name="addButton" id="addButton" value="确  定"  onclick="add();"/>
		              	<input class="reset1 radius2" type="button" name="button2" id="button2" value="取  消"  onclick="backHistory()"/>
		              </td>
		          </tr>
		        </tbody>
		    </table>
		</div>
	</form>
	 <script type="text/javascript">
	 	$(document).ready(function(){
	 		pageInit();
	 		var power = document.getElementById("power").value;
	 		if(power == "noPower"){
		 		$("#meetingRoomNames").attr("disabled","disabled");
		 		$("#addButton").val("分级权限不够").attr("disabled","disabled");
		 	}else if(power == "LEVEL_IS_CLOSE"){
		 		$("#meetingRoomNames").attr("disabled","disabled");
		 		$("#addButton").val("分级已关闭").attr("disabled","disabled");
		 	}
		 });
		 
		 function pageInit(){
				var obj = new htmlUtil();
				obj.title("meetingRoomNames","请选择会议室信息");
				//obj.title("description","输入长度不超过300个字符");
	     }
	 	function add(){    
			$('#form').validate({    
				rules:{    
					"roomName" : {
				           required:true
					}
				}
			});
			var meetingRoomNames = document.getElementById("meetingRoomNames").value;
			var meetingRoomNamesTemp = "${levelVO.levelKeyNames1}";
			if(meetingRoomNames == meetingRoomNamesTemp &&meetingRoomNames){
				backHistory();
				return;
			}
			$('#form').submit();
		}

		function backHistory(){
			var level_pId=document.getElementById("level_pId").value;
			window.location.href = "${sys_ctx }/level/roomLevelList.action?parentId="+level_pId;
		}

		/**选择会议室
   		*/
   		function selectConference(thisDom){
            var selectedConference = document.getElementById("meetingRoomNameIDs").value;
          	var conferenceParameters = {
              methodName:'getReturnConferenceMethod',
              selectedConference:selectedConference,
              selectType:'multiple'
          	}
     		creatConferenceSelect(thisDom,conferenceParameters); 
   	 	}
   		//返回方法
   		//用于获取返回参数
   		//返回参数为数组类型
   		//用法类似VO如获取所选第一个用户的名称则为conferenceArray[0].conferenceName
   		//以提供的参数：conferenceID,conferenceName
   		function getReturnConferenceMethod(conferenceArray){
      		//alert(userArray);
      		var conferenceName = "";
      		var conferenceID = "";
      		var length = conferenceArray.length;
      		for(var i=0;i<length;i++){
 	          	if(i==(length-1)){
 	          		conferenceName =conferenceName+conferenceArray[i].conferenceName;
 	          		conferenceID = conferenceID+conferenceArray[i].conferenceID;
 	            }else{
 	            	conferenceName =conferenceName+conferenceArray[i].conferenceName+",";
 	            	conferenceID = conferenceID+conferenceArray[i].conferenceID+",";
 	            }
            }
            $("#meetingRoomNames").attr("value",conferenceName);
            $("#meetingRoomNameIDs").attr("value",conferenceID);
   		}
	 </script>
  </body>
</html>
