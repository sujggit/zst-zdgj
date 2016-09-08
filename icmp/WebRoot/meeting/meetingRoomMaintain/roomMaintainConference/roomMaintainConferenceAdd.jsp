<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.zzst.model.enums.DictionaryEnum"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <%@include file="/common/common.jsp"%>
  <title>会场维护记录添加</title>
</head>
<body>
	<div class="contentwrapper">
	  <form action="${sys_ctx }/meetingRoomMaintain/roomMaintainConferenceAdd_list.action" method="post" name="form" id="form">
		<div class="contenttitle2">
			<h5 class="fwb fl10">会场维护记录添加</h5>
		</div>
		<div style="overflow:auto;max-height:388px;width:100%;padding:0">
		  <table width="100%" border="0" cellspacing="1" cellpadding="0" class="tableadd">
			<tr>
				<td class="tableaddtitle"><span>*</span>会议名称</td>
				<td class="tableadd_data">
					<input type="hidden" value="${meetingDetailVO.meetingDetailID }" name="meetingRoomMaintainVO.maintainKey"/>
					<input class=inputtran value="${meetingDetailVO.meetingName }" id="meetingName" readonly="readonly" style="cursor: default;"/>
				</td>
			</tr>
			<tr>
			  <td class="tableaddtitle"><span>*</span>会场名称</td>
				<td class="tableadd_data">
				  <c:if test="${addType == 1}">
					<input type="hidden" value="${meetingRoomVO.meetingRoomID }" name="meetingRoomMaintainVO.roomID" id="meetingRoomID"  />
          			<input class="inputtran" value="${meetingRoomVO.meetingRoomName }" id="meetingRoomName" readonly="readonly" style="cursor: default;" />
          		  </c:if>
				  <c:if test="${addType == 2}">
					<input type="hidden" name="meetingRoomMaintainVO.roomID" id="meetingRoomID" value="" />
          			<input name="meetingRoomName" id="meetingRoomName" class="inputtran" onclick="selectRoom(this)" value=""/>
          		  </c:if>
				</td>
			</tr>
			<c:forEach items="${dListType}" var="dictionaryVO1" varStatus="state1">
              <tr>
                <c:if test="${state1.last==true }"><input type="hidden" name="equipmentTypeSize" value="${state1.index }"/></c:if>
                <td class="tableaddtitle" style="vertical-align: top;">${dictionaryVO1.dicViewName }</td>
				<td class="tableadd_data">
					<input type="hidden" name="maintainName${state1.index }" id="" value="${dictionaryVO1.dicViewName }"/>
					<input type="hidden" name="type${state1.index }" id="" value="${dictionaryVO1.dicValue }"/>
					<select name="status${state1.index }" style="font-family:'SimSun'">
						<c:forEach items="${dListStatus}" var="dictionaryVO2" varStatus="state2">
						  	<option value="${dictionaryVO2.dicValue }" style="font-family:'SimSun'">${dictionaryVO2.dicViewName }</option>
						</c:forEach>
					</select>
					<textarea name="questionDes${state1.index }" style="margin-top:2px;display:block;min-height:50px;"></textarea>					
				</td>
			  </tr>
			</c:forEach>
		  </table>
		</div>
		<table cellpadding="0" cellspacing="0" border="0" class="buttoncontainer" id="table">
			<tr>
				<td>
					<c:if test="${addType == 1}">
					  <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="commitAndClose()"/>
					  <input type="button" class="reset1 radius2" value="关 闭" onclick="window.close()"/>
					</c:if>
					<c:if test="${addType == 2}">
					  <input type="button" class="submit1 radius2 submitBtn_Disa" value="确 定" onclick="commit()"/>
					  <input type="button" class="reset1 radius2" value="返 回" onclick="window.history.back()"/>
					</c:if>
				</td>
			</tr>
		</table>
	  </form>
	</div>
	<!--上箭头加一，下箭头减一-->
	<script>
		/**
	     *选择会议室
	     */
	    function selectRoom(thisDom){
	        var conferenceParameters = {
	            methodName:'getReturnRoomMethod',
	            selectType:'radio'
	        }
	       creatConferenceSelect(thisDom,conferenceParameters); 
	    }
	    function getReturnRoomMethod(conferenceArray){
	            var meetingRoomID="";
	            var meetingRoomName="";
	            var conferenceLength = conferenceArray.length;
	            for(var i=0;i<conferenceLength;i++){
	          	  meetingRoomID=conferenceArray[i].conferenceID;
	          	  meetingRoomName=conferenceArray[i].conferenceName;
	            }
	        	$("#meetingRoomID").attr("value",meetingRoomID);
	         	$("#meetingRoomName").attr("value",meetingRoomName);
	        
	    }
	    
		$(document).ready(function(){
			var obj = new htmlUtil();
			//obj.title("meetingName","输入长度不超过25个字符");	
			obj.title("meetingRoomName","请选择会场");
			$("#form").validate({
				rules:{
					"meetingRoomName":{
						required: true
	           		}
				}
			});
		})

		function commit(){
		    $("#form").submit();
			 window.close();
		}

		function commitAndClose(){
			$("#form").submit();
			window.close();
		}
	</script>
</body>
</html>