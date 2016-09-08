<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page  import="com.zzst.service.meeting.address.AddressServiceImpl" %>
<%@ page  import="com.zzst.model.meeting.address.AddressVO" %>
<%@ page  import="com.zzst.model.enums.AddressEnu" %>
<%@include file="/common/common_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="X-UA-Compatible" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="${sys_ctx }/style/screenModel.css" type="text/css">
    
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/DwrMethod.js'> </script>
    <script type='text/javascript' src='${sys_ctx }/dwr/interface/McuDwrMethod.js'> </script>
	
	<script type="text/javascript">
		var data2 = [ { name:"请选择...", id:"0" }];
		var data3 = [ { name:"自动", id:"auto" }];
		var data4 = [ { name:"自动轮询", id:"autoscan" }];
		var data5 = [ { name:"空", id:"blank" }];
		
		function setVideo() { 

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
			
			var selectItem1 = document.getElementById("selectId1").value;
			if(selectItem1 != null){
				McuDwrMethod.setVideoScreen(meetingDetailID, confID, lecturer, videoMode, '${LAYOUT_MODE}', 1, selectItem1);
				//McuDwrMethod.setVideoScreen(lecturer.value, '${confVO.confID}', videoMode.value, '${LAYOUT_MODE}', 1, selectItem.value, slaveSelectItem.value);
			parent.setIntervaltime();
			}
		}

		function setVideoMode(videoModeId, lecturerId){
			var id = "auto";
			var confID = document.getElementById("confID").value;
			var screenValue = document.getElementById(videoModeId).value;
			if(screenValue == "0"){
				document.getElementById(lecturerId).disabled = "";
				McuHelpDwrMethod.getMastListExceptLec(document.getElementById("lecturerId").value,confID,callback4);
			}
			if(screenValue == "4"){
				document.getElementById(lecturerId).disabled = "disabled";
				if(document.getElementById(lecturerId).value != "[auto]"){
					McuHelpDwrMethod.getMastListExceptLec(id,confID,callback4); 
				}
			}
		}

		/*
		*  演讲者 select 过滤其他select option 
		*/
		function selectDriverDel(id){
			if(document.getElementById("lecturerId").disabled ==""){
				var confID = document.getElementById("confID").value;
			    McuHelpDwrMethod.getMastListExceptLec(id.value,confID,callback4); 
			}
			
		}
		
		function callback4(lst){
		    var avalue = document.getElementById('selectId1').value;
			var speakerSelect1 = document.getElementById('selectId1');
			var speakerText1 = speakerSelect1.options[speakerSelect1.selectedIndex].text;
		   	var data2 = [ { name:"请选择...", id:"0" }];
		   	/*
			*  a select option 初始化
			*/
			dwr.util.removeAllOptions('selectId1');
			dwr.util.addOptions('selectId1', data3, "id", "name");
			dwr.util.addOptions('selectId1', data4, "id", "name");
			dwr.util.addOptions('selectId1', data5, "id", "name");
			dwr.util.addOptions('selectId1', lst, 'mcu_participant_id', 'mcu_participant_name');
			slef_selected('selectId1', avalue);
			var lecturerSelect = document.getElementById("lecturerId");
			if(speakerText1 == lecturerSelect.options[lecturerSelect.selectedIndex].text){
				document.getElementById('selectId1').value='auto';
				dwr.util.removeAllOptions('slaveSlectId1');
			   	dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
			}
		}

		function slef_selected(id, value) {
			document.getElementById(id).value=value;
		}

		/*
		*  点名判断
		*
		*/
		function checkroll(){
			var videoMode = document.getElementById("videoModeId");
			var isConversation = document.getElementById("isConversationId");
			if(isConversation.checked==true){
				if(videoMode.value=="0"){
				  	document.getElementById("checkrollImage1").style.display = "";
			  	}
				if(videoMode.value=="4"){
				  	document.getElementById("checkrollImage1").style.display = "";
			  	}
			}
			if(isConversation.checked==false){
				document.getElementById("checkrollImage1").style.display = "none";
			}
		}

		function screen1(){
			var id = "auto";
			var screenValue = document.getElementById('select').value;
			var confID = document.getElementById("confID").value;
			if(screenValue == "0"){	
				document.getElementById("lecturerId").disabled = "";
			}
			if(screenValue == "4"){
				document.getElementById("lecturerId").disabled = "disabled";
			}
		}

		 /*
		*  select option 互斥
		*/
		function check(id){
				if(id.value!="blank" && id.value!="auto" && id.value!="autoscan"){
					var confID = document.getElementById("confID").value;
					McuHelpDwrMethod.getCasList(id.value,confID,callback); 
				}else{
					
					dwr.util.removeAllOptions('slaveSlectId1');
		    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
				}
		}	
		function callback(lst){
		    	if(lst ==null){
		    		dwr.util.removeAllOptions('slaveSlectId1');
		    		var data2 = [ { name:"请选择...", id:"0" }];
		    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
			    	return;
			    }
				dwr.util.removeAllOptions('slaveSlectId1');
				dwr.util.addOptions('slaveSlectId1', data3, "id", "name");
				dwr.util.addOptions('slaveSlectId1', data4, "id", "name");
				dwr.util.addOptions('slaveSlectId1', data5, "id", "name");
				dwr.util.addOptions('slaveSlectId1', lst, 'mcu_participant_id', 'mcu_participant_name');

		}
		
	function presentation(id){
	if(id.checked == true){
		document.getElementById("lecturerId").value = "auto";
		}else{
			return;
		}
	}
	//-->
	</script>
  </head>
  
  <body>
  	<input type="hidden" value="${confVO.confID}" id="confID"/>
  	<input type="hidden" value="${confVO.confFlagId}" id="meetingDetailID"/>
    <table width="100%" border="0" cellspacing="1" cellpadding="0" height="100%" bgcolor="#e4eafa">
   	  <!--<tr>
   	 <td colspan="3" bgcolor="#bdcbef" style="border:1px solid #505050;height:30px;font-size:12px;">&nbsp;&nbsp;&nbsp;&nbsp;分屏模式： 
   	 	<c:if test="${confVO.videoMode=='1'}"><span class="fonttsx">演示模式</span></c:if>
   	 	<c:if test="${confVO.videoMode=='0'}"><span class="fonttsx">演讲者模式</span></c:if>
   	 	<c:if test="${confVO.videoMode=='4'}"><span class="fonttsx">相同分屏模式</span></c:if>
   	 	<input type="hidden" id="videoMode" value="${confVO.videoMode}" >
   	 	&nbsp;&nbsp;&nbsp;&nbsp;演讲者：<span class="fonttsx"><input type="text" id="lecturerId" value="${confVO.lectureName }" /></span> 
			 	&nbsp;&nbsp;&nbsp;&nbsp;
			 <script language="javascript">
			 </script>
			 </td>
   	 </tr>
   	
   	   -->
   	   <tr>
   	     <td width="100%" valign="top" height="300px"  style="border:1px solid #505050;background:#F5F5F5">
   	     <form id="form1" name="form1" method="post" action="" class="selectform" style="text-align:center">
   	       <div  style="margin-top:0px; height:20px; text-align:left; padding-left:10px;padding-top:8px;">
   	      </div>
   	       <div style="margin-top:110px;">
	   	       <select name="select"  style="color:#666; font-size:12px;" id="selectId1" >
	   	         <option value="auto" ${'auto' == confVO.layoutConfigGuid ? "selected" : "" }>自动</option>
	   	         <option value="autoscan" ${'autoscan' == confVO.layoutConfigGuid ? "selected" : "" }>自动轮询</option>
				 <option value="blank" ${'blank' == confVO.layoutConfigGuid ? "selected" : "" }>空</option>
				 <c:forEach items="${meetingMcuVOList}" var="meetingMcu">
					<option value="${meetingMcu.mcu_participant_id }" ${meetingMcu.mcu_participant_id == selectItem1 ? "selected" : "" }>
						${meetingMcu.mcu_participant_name}
					</option>
					
			 	</c:forEach>
			  </select>
			 </div>
 	       </form></td>
        </tr>
   	   <tr>
   	     <td height="63"  style="border:1px solid #505050" align="center" bgcolor="#bdcbef">
   	     	<input type="button" value="生 效" onclick="setVideo();" style="border-top:1px solid #ffffff; border-left:1px solid #ffffff; border-right:1px solid #4d658d;  border-bottom:1px solid #4d658d; width:80px;height:24px; background:#6b7c98; color:#ffffff; font-size:12px; font-family:'微软雅黑', '黑体', '宋体', Arial, Verdana"  />
   	     </td>
        </tr>
     </table>
  </body>
   <script>
   /*
	*  select级联初始化
	*
	*/
   	
   function check13(id){
			if(id.value!="blank" && id.value!="auto"){
				
			var confID = document.getElementById("confID").value;
				
				McuHelpDwrMethod.getCasList(id.value,confID,callback13); 
			}else{
				dwr.util.removeAllOptions('slaveSlectId1');
	    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
			}
		}
    function callback13(lst){
	    	if(lst == null){
	    		dwr.util.removeAllOptions('slaveSlectId1');
	    		dwr.util.addOptions('slaveSlectId1', data2, "id", "name");
		    	return;
		    }
		}
  </script>
</html>
