<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<%@include file="/common/common_header.jsp"%>
<html>
  <head>
    <title>拥有的地址</title>
    <link rel="stylesheet" href="${sys_ctx }/style/screenModel.css" type="text/css">
    
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
    <script type='text/javascript'>
    	function setVideo3(videoModeId, lecturerId){
<%--			var mcuType = parent.document.getElementById(confID).value;--%>
			var confID = document.getElementById("confID").value;
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			var mcuType = parent.document.getElementById(confID).value;
			var videoMode = "";
			if(mcuType == 11){
			videoMode = parent.document.getElementById("mode").value;
			}
			var lecturer = "";
			if(videoMode == "4"){
				lecturer = "";
			}
			
			var confID = document.getElementById("confID").value;
			
			var meetingDetailID = document.getElementById("meetingDetailID").value;
			
			//the first select in every column
			var selectItem1 = document.getElementById('selectId1');
			var selectItem2 = document.getElementById('selectId2');
			var selectItem3 = document.getElementById('selectId3');
			var selectItem4 = document.getElementById('selectId4');
			var selectItem5 = document.getElementById('selectId5');
			var selectItem6 = document.getElementById('selectId6');
			var selectItem7 = document.getElementById('selectId7');
			var selectItem8 = document.getElementById('selectId8');
			var selectItem9 = document.getElementById('selectId9');
	 		var selectItems = selectItem1.value + "_" + selectItem2.value + "_" + selectItem3.value + "_" + selectItem4.value+ "_" + selectItem5.value+ "_" + selectItem6.value+ "_" + selectItem7.value+ "_" + selectItem8.value+ "_" + selectItem9.value;
			
			if(selectItems != null){
				//McuDwrMethod.setVideo('${confVO.confID}', videoMode.value, lecturer.value, isConversation.checked, '${LAYOUT_MODE}', '6', selectItems, slaveSelectItems, function(){});
				McuDwrMethod.setVideoScreen(meetingDetailID, confID, lecturer, videoMode, '${LAYOUT_MODE}', 9, selectItems);
				parent.setIntervaltime();
			}
		}
    </script>
</head>
<body>
     <input type="hidden" value="${confVO.confID}" id="confID"/>
     <input type="hidden" value="${confVO.confFlagId}" id="meetingDetailID"/>
   <table width="100%" border="0" cellspacing="1" cellpadding="0" height="100%" bgcolor="#e4eafa">
   	 <!--<tr>
   	 <td colspan="3" bgcolor="#bdcbef" style="border:1px solid #505050;height:30px;font-size:12px;">&nbsp;&nbsp;&nbsp;&nbsp;分屏模式： 
   	 	<input type="hidden" id="videoMode" value="${confVO.videoMode}" >
   	 	<c:if test="${confVO.videoMode=='1'}"><span class="fonttsx">演示模式</span></c:if>
   	 	<c:if test="${confVO.videoMode=='0'}"><span class="fonttsx">演讲者模式</span></c:if>
   	 	<c:if test="${confVO.videoMode=='4'}"><span class="fonttsx">相同分屏模式</span></c:if>
   	 	&nbsp;&nbsp;&nbsp;&nbsp;演讲者： <span class="fonttsx"><input type="text" id="lecturerId" value="${confVO.lectureName }" /></span> 
			 	&nbsp;&nbsp;&nbsp;&nbsp;
			 <script language="javascript">
			 </script>
			 </td>
   	 </tr>
   	 
   	   -->
   	   <tr>
   	     <td width="33%" rowspan="1" colspan="1" style="border:1px solid #505050" valign="top"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	     <div  style="margin-top:0px; height:20px; text-align:left; padding-left:10px;padding-top:8px;">
   	      </div>
   	    
   	      <div style="margin-top:60px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId1" >
   	         <option value="auto" ${'auto' == selectItem1 ? "selected" : "" }>自动</option>
   	         <option value="autoscan" ${'autoscan' == selectItem1 ? "selected" : "" }>自动轮询</option>
			 <option value="blank" ${'blank' == selectItem1 ? "selected" : "" }>空</option>
			 <c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem1 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			 </c:forEach>
 	         </select>
 	        </div>
 	       </form></td>
 	       <td width="33%" rowspan="1" colspan="1" style="border:1px solid #505050" valign="top"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	     <div  style="margin-top:0px; height:20px; text-align:left; padding-left:10px;padding-top:8px;">
   	      </div>
   	    
   	      <div style="margin-top:60px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId2" >
   	         <option value="auto" ${'auto' == selectItem2 ? "selected" : "" }>自动</option>
   	         <option value="autoscan" ${'autoscan' == selectItem2 ? "selected" : "" }>自动轮询</option>
			 <option value="blank" ${'blank' == selectItem2 ? "selected" : "" }>空</option>
			 <c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem2 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			 </c:forEach>
 	         </select>
 	        </div>
 	       </form></td>
   	     <td height="100" style="border:1px solid #505050"  valign="top"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div  width="100" style=" margin-top:0px; height:20px; text-align:left; padding-left:10px;padding-top:8px;">
   	       
   	       </div>
   	       <div style="margin-top:10px;">
	   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId3" >
	   	         <option value="auto" ${'auto' == selectItem3 ? "selected" : "" }>自动</option>
	   	         <option value="autoscan" ${'autoscan' == selectItem3 ? "selected" : "" }>自动轮询</option>
				 <option value="blank" ${'blank' == selectItem3 ? "selected" : "" }>空</option>
				 <c:forEach items="${meetingMcuVOList}" var="meetingMcu">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem3 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name }
					</option>
				 </c:forEach>
	 	       </select>
 	        </div>
 	       </form></td>
        </tr>
   	   <tr>
   	     <td width="33%" height="100" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:25px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId4" >
   	        <option value="auto" ${'auto' == selectItem4 ? "selected" : "" }>自动</option>
   	        <option value="autoscan" ${'autoscan' == selectItem4 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem4 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem4 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			</c:forEach>
   	      </select>
 	      </div>
 	      </form>
 	      </td>
 	       <td width="33%" height="100" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:25px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId5" >
   	        <option value="auto" ${'auto' == selectItem5 ? "selected" : "" }>自动</option>
   	        <option value="autoscan" ${'autoscan' == selectItem5 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem5 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem5 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			</c:forEach>
   	      </select>
 	      </div>
 	      </form>
 	      </td>
 	       <td width="33%" height="100" style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:25px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId6" >
   	        <option value="auto" ${'auto' == selectItem6 ? "selected" : "" }>自动</option>
   	        <option value="autoscan" ${'autoscan' == selectItem6 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem6 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem6 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			</c:forEach>
   	      </select>
 	      </div>
 	      </form>
 	      </td>
 	      </tr>
 	      <tr>
 	      <td height="100px"  style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:25px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId7" >
   	        <option value="auto" ${'auto' == selectItem7 ? "selected" : "" }>自动</option>
   	        <option value="autoscan" ${'autoscan' == selectItem7 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem7 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem7 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			</c:forEach>
   	      </select>
 	      </div>
 	       </form>
 	      </td>
 	      <td height="100px"  style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:25px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId8" >
   	        <option value="auto" ${'auto' == selectItem8 ? "selected" : "" }>自动</option>
   	        <option value="autoscan" ${'autoscan' == selectItem8 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem8 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem8 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			</c:forEach>
   	      </select>
 	      </div>
 	       </form>
 	      </td>
 	      <td height="100px"  style="border:1px solid #505050"><form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div style="margin-top:25px;">
   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId9" >
   	        <option value="auto" ${'auto' == selectItem9 ? "selected" : "" }>自动</option>
   	        <option value="autoscan" ${'autoscan' == selectItem9 ? "selected" : "" }>自动轮询</option>
			<option value="blank" ${'blank' == selectItem9 ? "selected" : "" }>空</option>
			<c:forEach items="${meetingMcuVOList}" var="meetingMcu">
				<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem9 ? "selected" : "" }>
					${meetingMcu.mcu_participant_name }
				</option>
			</c:forEach>
   	      </select>
 	      </div>
 	       </form>
 	      </td>
        </tr>
   	   <tr>
   	     <td height="63" colspan="3" style="border:1px solid #505050" align="center" bgcolor="#bdcbef">
   	     	<input type="button" value="生 效" onclick="setVideo3('videoModeId', 'lecturerId');" style="border-top:1px solid #ffffff; border-left:1px solid #ffffff; border-right:1px solid #4d658d;  border-bottom:1px solid #4d658d; width:80px;height:24px; background:#6b7c98; color:#ffffff; font-size:12px; font-family:'微软雅黑', '黑体', '宋体', Arial, Verdana"  />
   	     </td>
       </tr>
     </table>
  </body>

</html>